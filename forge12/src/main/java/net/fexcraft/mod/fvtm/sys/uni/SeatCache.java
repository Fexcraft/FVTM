package net.fexcraft.mod.fvtm.sys.uni;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.Seat;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.data.root.Lockable;
import net.fexcraft.mod.fvtm.data.vehicle.SwivelPoint;
import net.fexcraft.mod.fvtm.util.Pivot;
import net.fexcraft.mod.fvtm.event.EventHandler;
import net.fexcraft.mod.uni.world.EntityWIE;
import net.fexcraft.mod.uni.world.MessageSenderI;
import net.fexcraft.mod.uni.impl.SWIE;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemLead;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SeatCache {
	
    //public int vehicleid;
	public int seatindex;
    public GenericVehicle vehicle;
    private Entity passenger;
    protected SwivelPoint point;
    //
    public Seat seatdata;
    public Pivot looking, prevlooking;
    public Pivot passlooking, prevpasslooking;
    //
    //private double pass_x, pass_y, pass_z;
    private float pass_yaw, pass_pitch;//, pass_roll;
    //private double prev_pass_x, prev_pass_y, prev_pass_z;
    private float prev_pass_yaw, prev_pass_pitch;//, prev_pass_roll;
    //
    private byte clicktimer, interacttimer;
    
	public SeatCache(GenericVehicle veh, int index){
		vehicle = veh;
		seatindex = index;
        //vehicleid = veh.getEntityId();
    	seatdata = veh.getVehicleData().getSeats().get(index);
        point = vehicle.getVehicleData().getRotationPoint(seatdata.swivel_point);
        resetAxes();
        //pass_x = prev_pass_x = veh.posX;
        //pass_y = prev_pass_y = veh.posY;
        //pass_z = prev_pass_z = veh.posZ;
	}

	public void resetAxes(){
        prevlooking = new Pivot(); looking = new Pivot();
        passlooking = new Pivot(); prevpasslooking = new Pivot();
        looking.set_rotation((seatdata.minyaw + seatdata.maxyaw) / 2, 0F, 0F, true);
        prevlooking.set_rotation((seatdata.minyaw + seatdata.maxyaw) / 2, 0F, 0F, true);
	}


	public boolean processInteract(EntityPlayer player, EnumHand hand){
        if(vehicle.world.isRemote){ return false; }
        ItemStack stack = player.getHeldItem(hand);
        if(Lockable.isKey(FvtmRegistry.getItem(stack.getItem().getRegistryName().toString()))){
			vehicle.getVehicleData().getLock().toggle(new MessageSenderI(player), new SWIE(stack));
        	vehicle.sendLockStateUpdate();
        	return true;
        }
        if(vehicle.getVehicleData().getLock().isLocked()){
            Print.chat(player, "Vehicle is Locked.");
            return true;
        }
        if(interacttimer > 0) return false;
        if(stack.getItem() instanceof ItemLead){
        	if(passenger instanceof EntityPlayer) return false;
            if(passenger instanceof EntityLiving){
                EntityLiving mob = (EntityLiving)passenger;
                passenger.dismountRidingEntity();
                mob.setLeashHolder(player, true);
                interacttimer += 10;
                return true;
            }
            double checkRange = 10;
            V3D pos = getFreshPosition();
            AxisAlignedBB aabb = new AxisAlignedBB(pos.x - checkRange, pos.y - checkRange, pos.z - checkRange, pos.x + checkRange, pos.y + checkRange, pos.z + checkRange);
            List<EntityLiving> nearbyMobs = vehicle.world.getEntitiesWithinAABB(EntityLiving.class, aabb);
            for(EntityLiving entity : nearbyMobs){
                if(entity.getLeashed() && entity.getLeashHolder() == player){
                	if(!seatdata.allow(new EntityWIE(entity))){
                		Print.bar(player, "&eSeat does not accept this entity kind. (" + entity.getName() + ")");
                		continue;
                	}
                	entity.getCapability(Capabilities.PASSENGER, null).set(vehicle.getEntityId(), seatindex);
                    looking.set_rotation(-entity.rotationYaw, entity.rotationPitch, 0F, true);
                    entity.clearLeashed(true, !player.capabilities.isCreativeMode);
                    entity.startRiding(vehicle);
                    break;
                }
            }
            interacttimer += 10;
            return true;
        }
        if(passenger == null){
        	if(!seatdata.allow(new EntityWIE(player))){
        		Print.bar(player, "&eSeat does not accept players as passengers.");
        		return false;
        	}
        	if(player.isRiding() && player.getRidingEntity().equals(vehicle)){
        		SeatCache seat = vehicle.getSeatOf(player);
        		seat.passenger(null);
            	player.getCapability(Capabilities.PASSENGER, null).set(vehicle.getEntityId(), seatindex);
            	this.passenger(player);
        	}
        	else{
        		player.dismountRidingEntity();
            	player.getCapability(Capabilities.PASSENGER, null).set(vehicle.getEntityId(), seatindex);
                player.startRiding(vehicle);
        	}
            interacttimer += 10;
            return true;
        }
        return false;
    }

	public void updatePosition(){
		if(clicktimer > 0) clicktimer--;
		if(interacttimer > 0) interacttimer--;
        if(passenger == null) return;
        prev_pass_yaw = pass_yaw;
        prev_pass_pitch = pass_pitch;
        //prev_pass_roll = pass_roll;
        //
        //this.updatePassenger();
        //
        pass_yaw = -90F + passlooking.deg_yaw() + point.getPivot().deg_yaw();
        pass_pitch = passlooking.deg_pitch() + point.getPivot().deg_pitch();
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
        //if(world.isRemote){ pass_roll = -glookaxes.deg_roll(); }
	}


	public V3D getFreshPosition(){
        V3D relpos = point.getRelativeVector(seatdata.pos);
		return relpos.add(vehicle.posX, vehicle.posY, vehicle.posZ);
	}

	public void updatePassenger(Entity pass){
		if(passenger != pass) passenger = pass;
        //if(passenger == null) return;
        V3D pos = getFreshPosition();
        passenger.rotationYaw = pass_yaw;
        passenger.rotationPitch = pass_pitch;
        passenger.prevRotationYaw = prev_pass_yaw;
        passenger.prevRotationPitch = prev_pass_pitch;
        //passenger.lastTickPosX = passenger.prevPosX = passenger.posX;
        //passenger.lastTickPosY = passenger.prevPosY = passenger.posY;
        //passenger.lastTickPosZ = passenger.prevPosZ = passenger.posZ;
        double yoff = passenger instanceof EntityPlayer ? passenger.getYOffset() : 0;
        passenger.setPosition(pos.x, pos.y + yoff, pos.z);
        if(!vehicle.world.isRemote && passenger instanceof EntityPlayerMP){
        	EventHandler.resetFlight((EntityPlayerMP)passenger);
        }
	}


	public boolean onKeyPress(KeyPress key, EntityPlayer player){
		if(key == null) return false;
		else if(key.toggable_input() && vehicle.world.isRemote){
    		if(clicktimer > 0) return false;
    		boolean bool = false;//TODO ToggableHandler.handleClick(key, vehicle, this, player, ItemStack.EMPTY);
        	clicktimer += 10;
        	return bool;
		}
        else if(!seatdata.driver && vehicle.world.isRemote){
			if(clicktimer > 0) return false;
			Collection<Attribute<?>> attributes = vehicle.getVehicleData().getAttributes().values().stream().filter(pr -> (pr.valuetype.isTristate() || pr.valuetype.isNumber()) && pr.access.contains(seatdata.name)).collect(Collectors.toList());
			boolean bool = false;
			for(Attribute<?> attr : attributes){
				Float val = attr.getKeyValue(key);
				if(val != null){
					KeyPress mouse = val == 0 ? KeyPress.RESET : val > 0 ? KeyPress.MOUSE_MAIN : KeyPress.MOUSE_RIGHT;
					//TODO if(bool = ToggableHandler.sendToggle(attr, vehicle, mouse, val, player)) break;
				}
			}
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
        prevlooking = looking.copy();
        prevpasslooking = passlooking.copy();
        //
        double lookSpeed = 4F;
        double npasspitch = passlooking.deg_pitch() - dy / lookSpeed * net.minecraft.client.Minecraft.getMinecraft().gameSettings.mouseSensitivity;
        if(npasspitch > -seatdata.minpitch){ npasspitch = -seatdata.minpitch; }
        if(npasspitch < -seatdata.maxpitch){ npasspitch = -seatdata.maxpitch; }
        //
        double npassyaw = passlooking.deg_yaw() + dx / lookSpeed * net.minecraft.client.Minecraft.getMinecraft().gameSettings.mouseSensitivity;
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
        passlooking.set_rotation(npassyaw, npasspitch, 0F, true);
        //
        Vec3d vecais = new Vec3d(1, 1, 0);
        double targetx = passlooking.deg_yaw();
        double yawToMove = (targetx - looking.deg_yaw());
        for(; yawToMove > 180F; yawToMove -= 360F){}
        for(; yawToMove <= -180F; yawToMove += 360F){}
        float signDeltaX = 0;
        if(yawToMove > (vecais.x / 2)){ signDeltaX = 1; }
        else if(yawToMove < -(vecais.x / 2)){ signDeltaX = -1; }
        else{ signDeltaX = 0; }
        //
        double newYaw = 0f;
        if((signDeltaX == 0 && dx == 0)){ newYaw = passlooking.deg_yaw(); }
        else{ newYaw = looking.deg_yaw() + signDeltaX * vecais.x; }
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
        double targetY = passlooking.deg_pitch();
        double pitchToMove = (targetY - looking.deg_pitch());
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
        if((signDeltaY == 0 && dy == 0)){ newPitch = passlooking.deg_pitch(); }
        else if(currentYawToMove < minYawToMove){ newPitch = looking.deg_pitch() + signDeltaY * vecais.y; }
        else{ newPitch = looking.deg_pitch(); }
        if(newPitch > -seatdata.minpitch){ newPitch = -seatdata.minpitch; }
        if(newPitch < -seatdata.maxpitch){ newPitch = -seatdata.maxpitch; }
        looking.set_rotation(newYaw, newPitch, 0F, true);
        //TODO Packets.sendToServer(new PKT_SeatUpdate(this));
        return;
	}
	
    public static final boolean isPassengerThePlayer(GenericVehicle con){
        if(con.world.isRemote){
        	return clofnn(con);
        }
        return false;
    }

    @SideOnly(Side.CLIENT)
	private static boolean clofnn(GenericVehicle con){
		return con.getSeatOf(net.minecraft.client.Minecraft.getMinecraft().player) != null;
	}

	public void passenger(Entity pass){
		if(pass != null){
			SeatCache old = vehicle.getSeatOf(pass);
			if(old != null && old != this) old.passenger(null);
		}
		passenger = pass;
		resetAxes();
		pass_yaw = prev_pass_yaw = seatdata.defyaw;
		pass_pitch = prev_pass_pitch = seatdata.defpitch;
		looking.set_rotation(pass_yaw, pass_pitch, 0, true);
		prevlooking.set_rotation(pass_yaw, pass_pitch, 0, true);
		passlooking.set_rotation(pass_yaw, pass_pitch, 0, true);
		prevpasslooking.set_rotation(pass_yaw, pass_pitch, 0, true);
	}
	
	public Entity passenger(){
		return passenger;
	}

}
