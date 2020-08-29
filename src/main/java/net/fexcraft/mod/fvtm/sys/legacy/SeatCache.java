package net.fexcraft.mod.fvtm.sys.legacy;

import java.util.List;

import net.fexcraft.lib.mc.utils.ApiUtil;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.Seat;
import net.fexcraft.mod.fvtm.data.SwivelPoint;
import net.fexcraft.mod.fvtm.util.Axis3D;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.handler.ToggableHandler;
import net.fexcraft.mod.fvtm.util.packet.PKT_SeatUpdate;
import net.fexcraft.mod.fvtm.util.packet.Packets;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemLead;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;

public class SeatCache {
	
    public int vehicleid, seatindex, pending = -1;
    public GenericVehicle vehicle;
    public Entity passenger;
    //
    public Seat seatdata;
    public Axis3D looking, prevlooking;
    public Axis3D passlooking, prevpasslooking;
    //
    //private double pass_x, pass_y, pass_z;
    private float pass_yaw, pass_pitch;//, pass_roll;
    //private double prev_pass_x, prev_pass_y, prev_pass_z;
    private float prev_pass_yaw, prev_pass_pitch;//, prev_pass_roll;
    //
    private byte clicktimer;
    
    
	public SeatCache(GenericVehicle veh, int index){
		vehicle = veh;
		seatindex = index;
        vehicleid = veh.getEntityId();
        seatdata = veh.getVehicleData().getSeats().get(index);
        //pass_x = prev_pass_x = veh.posX;
        //pass_y = prev_pass_y = veh.posY;
        //pass_z = prev_pass_z = veh.posZ;
        resetAxes();
	}

	public void resetAxes(){
        prevlooking = new Axis3D(); looking = new Axis3D();
        passlooking = new Axis3D(); prevpasslooking = new Axis3D();
        looking.setAngles((seatdata.minyaw + seatdata.maxyaw) / 2, 0F, 0F);
        prevlooking.setAngles((seatdata.minyaw + seatdata.maxyaw) / 2, 0F, 0F);
	}


	public boolean processInteract(EntityPlayer player, EnumHand hand){
        if(vehicle.world.isRemote){ return false; }
        ItemStack stack = player.getHeldItem(hand);
        Print.debug(stack);
        if(vehicle.getVehicleData().isLocked()){
            Print.chat(player, "Vehicle is Locked.");
            return true;
        }
        if(stack.getItem() instanceof ItemLead){
        	if(passenger instanceof EntityPlayer) return false;
            if(passenger instanceof EntityLiving){
                EntityLiving mob = (EntityLiving)passenger;
                passenger.dismountRidingEntity();
                mob.setLeashHolder(player, true);
                return true;
            }
            double checkRange = 10;
            Vec3d pos = getFreshPosition();
            AxisAlignedBB aabb = new AxisAlignedBB(pos.x - checkRange, pos.y - checkRange, pos.z - checkRange, pos.x + checkRange, pos.y + checkRange, pos.z + checkRange);
            List<EntityLiving> nearbyMobs = vehicle.world.getEntitiesWithinAABB(EntityLiving.class, aabb);
            for(EntityLiving entity : nearbyMobs){
                if(entity.getLeashed() && entity.getLeashHolder() == player){
                	pending = entity.getEntityId();
                    sendPendingPacket();
                    looking.setAngles(-entity.rotationYaw, entity.rotationPitch, 0F);
                    entity.clearLeashed(true, !player.capabilities.isCreativeMode);
                    entity.startRiding(vehicle);
                    Print.debug("found");
                    break;
                }
            }
            Print.debug("end");
            return true;
        }
        if(passenger == null){
        	pending = player.getEntityId();
            sendPendingPacket();
            player.startRiding(vehicle);
            return true;
        }
        return false;
    }


	private void sendPendingPacket(){
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setString("task", "seat_pending");
        nbt.setInteger("seat", seatindex);
        nbt.setInteger("pending", pending);
        ApiUtil.sendEntityUpdatePacketToAllAround(vehicle, nbt);
	}

	public void updatePosition(){
		if(clicktimer > 0) clicktimer--;
        if(passenger == null) return;
        prev_pass_yaw = pass_yaw;
        prev_pass_pitch = pass_pitch;
        //prev_pass_roll = pass_roll;
        //
        this.updatePassenger();
        //
        Axis3D glookaxes = vehicle.getRotPoint().getAxes().getRelativeVector(passlooking);
        pass_yaw = -90F + glookaxes.getYaw();
        pass_pitch = glookaxes.getPitch();
        //
        double yaw = pass_yaw - prev_pass_yaw;
        if(yaw > 180){ prev_pass_yaw += 360F; }
        if(yaw < -180){ prev_pass_yaw -= 360F; }
        //if(passenger instanceof EntityPlayer){
            passenger.prevRotationYaw = prev_pass_yaw;
            passenger.prevRotationPitch = prev_pass_pitch;
            //
            passenger.rotationYaw = pass_yaw;
            passenger.rotationPitch = pass_pitch;
        //}
        //if(world.isRemote){ pass_roll = -glookaxes.getRoll(); }
	}


	private Vec3d getFreshPosition(){
        SwivelPoint point = vehicle.getVehicleData().getRotationPoint(seatdata.swivel_point);
        Vec3d relpos = point.getRelativeVector(seatdata.x, seatdata.y, seatdata.z);
		return relpos.add(vehicle.posX, vehicle.posY, vehicle.posZ);
	}

	private void updatePassenger(){
        if(passenger == null) return;
        Vec3d pos = getFreshPosition();
        passenger.rotationYaw = pass_yaw;
        passenger.rotationPitch = pass_pitch;
        passenger.prevRotationYaw = prev_pass_yaw;
        passenger.prevRotationPitch = prev_pass_pitch;
        //passenger.lastTickPosX = passenger.prevPosX = passenger.posX;
        //passenger.lastTickPosY = passenger.prevPosY = passenger.posY;
        //passenger.lastTickPosZ = passenger.prevPosZ = passenger.posZ;
        passenger.setPosition(pos.x, pos.y, pos.z);
        if(!vehicle.world.isRemote && passenger instanceof EntityPlayerMP){
        	Resources.resetFlight((EntityPlayerMP)passenger);
        }
	}


	public boolean onKeyPress(KeyPress key, EntityPlayer player){
		if(key == null) return false;
		else if(key.toggableInput() && vehicle.world.isRemote){
    		if(clicktimer > 0) return false;
    		boolean bool = ToggableHandler.handleClick(key, vehicle, this, player, ItemStack.EMPTY);
        	clicktimer += 10;
        	return bool;
		}
		/*else if(key.dismount() && vehicle.world.isRemote && passenger != null){
			passenger.dismountRidingEntity();
			return true;
		}*/
        else return vehicle.onKeyPress(key, seatdata, player);
	}


	public void onMouseMoved(int dx, int dy){
        prevlooking = looking.clone();
        prevpasslooking = passlooking.clone();
        //
        double lookSpeed = 4F;
        double npasspitch = passlooking.getPitch() - dy / lookSpeed * Minecraft.getMinecraft().gameSettings.mouseSensitivity;
        if(npasspitch > -seatdata.minpitch){ npasspitch = -seatdata.minpitch; }
        if(npasspitch < -seatdata.maxpitch){ npasspitch = -seatdata.maxpitch; }
        //
        double npassyaw = passlooking.getYaw() + dx / lookSpeed * Minecraft.getMinecraft().gameSettings.mouseSensitivity;
        double opassyaw = npassyaw - 360F;
        if(npassyaw < 0){ opassyaw = npassyaw + 360F; }
        if(!(npassyaw >= seatdata.minyaw && npassyaw <= seatdata.maxyaw) || (opassyaw >= seatdata.minyaw && opassyaw <= seatdata.maxyaw)){
            double npassyawd = Math.min(Math.abs(npassyaw - seatdata.minyaw), Math.abs(npassyaw - seatdata.maxyaw));
            double opassyawd = Math.min(Math.abs(opassyaw - seatdata.minyaw), Math.abs(opassyaw - seatdata.maxyaw));
            if(npassyawd <= opassyawd){
                if(npassyaw > seatdata.maxyaw){ npassyaw = seatdata.maxyaw; }
                if(npassyaw < seatdata.minyaw){ npassyaw = seatdata.minyaw; }
            }
            else{
                if(opassyaw > seatdata.maxyaw){ opassyaw = seatdata.maxyaw; }
                if(opassyaw < seatdata.minyaw){ opassyaw = seatdata.minyaw; }
                if(npassyaw < 0){ npassyaw = opassyaw - 360F; }
                else{ npassyaw = opassyaw + 360F; }
            }
        }
        passlooking.setAngles(npassyaw, npasspitch, 0F);
        //
        Vec3d vecais = new Vec3d(1, 1, 0);
        double targetx = passlooking.getYaw();
        double yawToMove = (targetx - looking.getYaw());
        for(; yawToMove > 180F; yawToMove -= 360F){}
        for(; yawToMove <= -180F; yawToMove += 360F){}
        float signDeltaX = 0;
        if(yawToMove > (vecais.x / 2)){ signDeltaX = 1; }
        else if(yawToMove < -(vecais.x / 2)){ signDeltaX = -1; }
        else{ signDeltaX = 0; }
        //
        double newYaw = 0f;
        if((signDeltaX == 0 && dx == 0)){ newYaw = passlooking.getYaw(); }
        else{ newYaw = looking.getYaw() + signDeltaX * vecais.x; }
        //
        double otherNewYaw = newYaw - 360F;
        if(newYaw < 0){ otherNewYaw = newYaw + 360F; }
        if(!(newYaw >= seatdata.minyaw && newYaw <= seatdata.maxyaw) || (otherNewYaw >= seatdata.minyaw && otherNewYaw <= seatdata.maxyaw)){
            double newYawDistFromRange = Math.min(Math.abs(newYaw - seatdata.minyaw), Math.abs(newYaw - seatdata.maxyaw));
            double otherNewYawDistFromRange = Math.min(Math.abs(otherNewYaw - seatdata.minyaw), Math.abs(otherNewYaw - seatdata.maxyaw));
            if(newYawDistFromRange <= otherNewYawDistFromRange){
                if(newYaw > seatdata.maxyaw){ newYaw = seatdata.maxyaw; }
                if(newYaw < seatdata.minyaw){ newYaw = seatdata.minyaw; }
            }
            else{
                if(otherNewYaw > seatdata.maxyaw){ otherNewYaw = seatdata.maxyaw; }
                if(otherNewYaw < seatdata.minyaw){ otherNewYaw = seatdata.minyaw; }
                if(newYaw < 0){ newYaw = otherNewYaw - 360F; }
                else{ newYaw = otherNewYaw + 360F; }
            }
        }
        //
        double targetY = passlooking.getPitch();
        double pitchToMove = (targetY - looking.getPitch());
        for(; pitchToMove > 180F; pitchToMove -= 360F){}
        for(; pitchToMove <= -180F; pitchToMove += 360F){}
        //
        double signDeltaY = 0;
        if(pitchToMove > (vecais.y / 2)){ signDeltaY = 1; }
        else if(pitchToMove < -(vecais.y / 2)){ signDeltaY = -1; }
        else{ signDeltaY = 0; }
        //
        double newPitch = 0f;
        double minYawToMove = 0f;
        double currentYawToMove = 0f;
        minYawToMove = (Math.sqrt((pitchToMove / vecais.y) * (pitchToMove / vecais.y))) * vecais.x;
        currentYawToMove = (float) Math.sqrt((yawToMove) * (yawToMove));
        if((signDeltaY == 0 && dy == 0)){ newPitch = passlooking.getPitch(); }
        else if(currentYawToMove < minYawToMove){ newPitch = looking.getPitch() + signDeltaY * vecais.y; }
        else{ newPitch = looking.getPitch(); }
        if(newPitch > -seatdata.minpitch){ newPitch = -seatdata.minpitch; }
        if(newPitch < -seatdata.maxpitch){ newPitch = -seatdata.maxpitch; }
        looking.setAngles(newYaw, newPitch, 0F);
        Packets.sendToServer(new PKT_SeatUpdate(this));
        return;
	}
	
    public static final boolean isPassengerThePlayer(GenericVehicle con){
        if(con.world.isRemote){
        	return con.getSeatOf(net.minecraft.client.Minecraft.getMinecraft().player) != null;
        }
        return false;
    }

	public void setPassenger(Entity pass){
		passenger = pass;
		resetAxes();
		pending = -1;
		pass_yaw = prev_pass_yaw = seatdata.defyaw;
		pass_pitch = prev_pass_pitch = seatdata.defpitch;
		looking.setAngles(pass_yaw, pass_pitch, 0);
		prevlooking.setAngles(pass_yaw, pass_pitch, 0);
		passlooking.setAngles(pass_yaw, pass_pitch, 0);
		prevpasslooking.setAngles(pass_yaw, pass_pitch, 0);
	}

}
