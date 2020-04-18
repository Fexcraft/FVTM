package net.fexcraft.mod.fvtm.sys.legacy;

import java.util.List;

import javax.annotation.Nullable;

import io.netty.buffer.ByteBuf;
import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.mc.api.packet.IPacketReceiver;
import net.fexcraft.lib.mc.network.packet.PacketEntityUpdate;
import net.fexcraft.lib.mc.utils.ApiUtil;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.Seat;
import net.fexcraft.mod.fvtm.data.SwivelPoint;
import net.fexcraft.mod.fvtm.util.Axis3D;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.handler.ToggableHandler;
import net.fexcraft.mod.fvtm.util.packet.PKT_SeatDismount;
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
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;

public class SeatEntity extends Entity implements IEntityAdditionalSpawnData, IPacketReceiver<PacketEntityUpdate> {

    private int vehicleid, seatindex;
    private GenericVehicle vehicle;
    //
    public Seat seatdata;
    public Axis3D looking, prevlooking;
    public Axis3D passlooking, prevpasslooking;
    //
    private double pass_x, pass_y, pass_z;
    private float pass_yaw, pass_pitch;//, pass_roll;
    private double prev_pass_x, prev_pass_y, prev_pass_z;
    private float prev_pass_yaw, prev_pass_pitch;//, prev_pass_roll;
    //private PassList passenger = new PassList();

    public SeatEntity(World world){
        super(world); setSize(0.5F, 0.5F);
        prevlooking = new Axis3D(); looking = new Axis3D();
        passlooking = new Axis3D(); prevpasslooking = new Axis3D();
        /*this.passenger = null;*/ //if(world.isRemote){ rqSync(); }
    }

    public SeatEntity(GenericVehicle veh, int index){
        this(veh.world); vehicle = veh; seatindex = index;
        vehicleid = veh.getEntity().getEntityId(); seatdata = veh.getVehicleData().getSeats().get(index);
        setPosition(veh.getEntity().posX, veh.getEntity().posY, veh.getEntity().posZ);
        pass_x = prev_pass_x = posX; pass_y = prev_pass_y = posY; pass_z = prev_pass_z = posZ;
        looking.setAngles((seatdata.minyaw + seatdata.maxyaw) / 2, 0F, 0F);
        prevlooking.setAngles((seatdata.minyaw + seatdata.maxyaw) / 2, 0F, 0F);
        /*this.passenger = null;*/
    }

	@Override
    public void writeSpawnData(ByteBuf buffer){
		buffer.writeInt(vehicleid); buffer.writeInt(seatindex); buffer.writeLong(this.getPosition().toLong());
		//Print.debug(world.isRemote + "", this.getEntityId(), vehicleid, vehicle);
    }

    @Override
    public void readSpawnData(ByteBuf buffer){
    	this.vehicleid = buffer.readInt(); seatindex = buffer.readInt(); long pos = buffer.readLong();
        this.vehicle = (GenericVehicle)world.getEntityByID(vehicleid);
    	//Print.debug(world.isRemote + "", this.getEntityId(), vehicleid, vehicle);
        if(vehicle == null || vehicle.getSeats() == null || vehicle.getSeats().length == 0){
            Print.debug("VEHICLE SEATS NULL? ", seatdata == null ? "no seatdata" : seatdata.name,
            	vehicle, vehicleid, world.getEntityByID(vehicleid)); Print.debug(world.loadedEntityList);
            BlockPos blk = BlockPos.fromLong(pos); setPosition(blk.getX(), blk.getY(), blk.getZ()); return;
        }
        //
        this.seatdata = vehicle.getVehicleData().getSeats().get(seatindex);
        this.vehicle.getSeats()[seatindex] = this;
        looking.setAngles((seatdata.minyaw + seatdata.maxyaw) / 2, 0F, 0F);
        prevlooking.setAngles((seatdata.minyaw + seatdata.maxyaw) / 2, 0F, 0F);
        Vec3d relpos = vehicle.getVehicleData().getRotationPoint(seatdata.swivel_point).getRelativeVector(seatdata.toVec3d(), false);
        pass_x = prev_pass_x = prevPosX = posX = vehicle.getEntity().posX + relpos.x;
        pass_y = prev_pass_y = prevPosY = posY = vehicle.getEntity().posY + relpos.y;
        pass_z = prev_pass_z = prevPosZ = posZ = vehicle.getEntity().posZ + relpos.z;
        setPosition(posX, posY, posZ); //Print.debug(posX, posY, posZ);
    }

    /*@Nullable
    public LandVehicle getLandVehicle(){
        return (LandVehicle)vehicle;
    }

    @Nullable
    public AirVehicle getAirVehicle(){
        return (AirVehicle)vehicle;
    }*/

    @Nullable
    public GenericVehicle getVehicle(){
        return vehicle;
    }

    public void rqSync(){
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setString("request", "sync");
        ApiUtil.sendEntityUpdatePacketToServer(this, nbt);
    }

    @Override
    public void setPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int partialticks, boolean b){
        return; //super.setPositionAndRotationDirect(x, y, z, yaw, pitch, partialticks, b);
    }

    @Override
    public void onUpdate(){
        super.onUpdate(); if(clicktimer > 0) clicktimer--;
        //
        if(!world.isRemote && getControllingPassenger() instanceof EntityPlayerMP){
        	Resources.resetFlight((EntityPlayerMP)getControllingPassenger());
        }
        //
        if(world.isRemote && vehicle == null){ rqSync(); }
    }
    
    @Override
    public void setPosition(double x, double y, double z){
        this.posX = x; this.posY = y; this.posZ = z; float f = width / 2.0F;
        this.setEntityBoundingBox(new AxisAlignedBB(x - f, y, z - f, x + f, y + height, z + f));
    }

    public void updatePosition(){
        if(world.isRemote && vehicle == null){ return; }
        prev_pass_x = pass_x;
        prev_pass_y = pass_y;
        prev_pass_z = pass_z;
        prev_pass_yaw = pass_yaw;
        prev_pass_pitch = pass_pitch;
        //prev_pass_roll = pass_roll;

        SwivelPoint point = vehicle.getVehicleData().getRotationPoint(seatdata.swivel_point);
        Vec3d relpos = point.getRelativeVector(seatdata.x, seatdata.y, seatdata.z);
        setPosition(vehicle.getEntity().posX + relpos.x, vehicle.getEntity().posY + relpos.y, vehicle.getEntity().posZ + relpos.z);
        this.lastTickPosX = this.prevPosX = posX;
        this.lastTickPosY = this.prevPosY = posY;
        this.lastTickPosZ = this.prevPosZ = posZ;

        if(this.getControllingPassenger() != null){
            pass_x = posX;
            pass_y = posY - 0.5;
            pass_z = posZ;
            this.updatePassenger();
            //
            Axis3D glookaxes = vehicle.getRotPoint().getAxes().getRelativeVector(passlooking);
            pass_yaw = -90F + glookaxes.getYaw();
            pass_pitch = glookaxes.getPitch();
            //
            double yaw = pass_yaw - prev_pass_yaw;
            if(yaw > 180){ prev_pass_yaw += 360F; }
            if(yaw < -180){ prev_pass_yaw -= 360F; }
            if(this.getControllingPassenger() instanceof EntityPlayer){
                this.getControllingPassenger().prevRotationYaw = prev_pass_yaw;
                this.getControllingPassenger().prevRotationPitch = prev_pass_pitch;
                //
                this.getControllingPassenger().rotationYaw = pass_yaw;
                this.getControllingPassenger().rotationPitch = pass_pitch;
            }
            //if(world.isRemote){ pass_roll = -glookaxes.getRoll(); }
        }
    }

    @Override
    public void updatePassenger(Entity passenger){
        if(passenger == null){ return; }
        passenger.rotationYaw = pass_yaw;
        passenger.rotationPitch = pass_pitch;
        passenger.prevRotationYaw = prev_pass_yaw;
        passenger.prevRotationPitch = prev_pass_pitch;
        passenger.lastTickPosX = passenger.prevPosX = prev_pass_x;
        passenger.lastTickPosY = passenger.prevPosY = prev_pass_y;
        passenger.lastTickPosZ = passenger.prevPosZ = prev_pass_z;
        passenger.setPosition(pass_x, pass_y, pass_z);
    }

    public void processServerPacket(PacketEntityUpdate pkt){
        if(pkt.nbt.hasKey("request")){
            switch(pkt.nbt.getString("request")){
                case "sync": {
                    try{
                        NBTTagCompound nbt = new NBTTagCompound();
                        nbt.setString("task", "sync");
                        nbt.setInteger("index", seatindex);
                        nbt.setLong("pos", this.getPosition().toLong());
                        nbt.setInteger("vid", vehicle.getEntity().getEntityId());
                        ApiUtil.sendEntityUpdatePacketToAllAround(this, nbt);
                    }
                    catch(Exception e){
                        e.printStackTrace();
                        //remove seat since it's apparently non existent or broken.
                    }
                    break;
                }
            }
        }
    }

    public void processClientPacket(PacketEntityUpdate pkt){
        if(pkt.nbt.hasKey("task")){
            switch(pkt.nbt.getString("task")){
                case "sync": {
                    this.seatindex = pkt.nbt.getInteger("index");
                    this.vehicleid = pkt.nbt.getInteger("vid");
                    this.vehicle = (GenericVehicle)world.getEntityByID(vehicleid);
                    if(vehicle == null || vehicle.getSeats().length == 0){
                        Print.debug("VEHICLE SEATS NULL? ", seatdata == null ? "no seat data" : seatdata.name,
                        	vehicle, vehicleid, world.getEntityByID(vehicleid));
                        Print.debug(world.loadedEntityList);
                        BlockPos pos = BlockPos.fromLong(pkt.nbt.getLong("pos"));
                        setPosition(pos.getX(), pos.getY(), pos.getZ());
                        return;
                    }
                    this.seatdata = vehicle.getVehicleData().getSeat(seatindex);
                    this.vehicle.getSeats()[seatindex] = this;
                    //
                    looking.setAngles((seatdata.minyaw + seatdata.maxyaw) / 2, 0F, 0F);
                    prevlooking.setAngles((seatdata.minyaw + seatdata.maxyaw) / 2, 0F, 0F);
                    SwivelPoint point = vehicle.getVehicleData().getRotationPoint(seatdata.swivel_point);
                    Vec3d relpos = point.getRelativeVector(seatdata.x, seatdata.y, seatdata.z);
                    pass_x = prev_pass_x = prevPosX = posX = vehicle.getEntity().posX + relpos.x;
                    pass_y = prev_pass_y = prevPosY = posY = vehicle.getEntity().posY + relpos.y;
                    pass_z = prev_pass_z = prevPosZ = posZ = vehicle.getEntity().posZ + relpos.z;
                    setPosition(posX, posY, posZ);
                    break;
                }
            }
        }
    }

    public void updatePassenger(){
        this.updatePassenger(this.getControllingPassenger());
    }

    @Override
    public boolean canBeCollidedWith(){
        return !isDead;
    }

    @Override
    protected void entityInit(){
        //
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound compound){
        //
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound compound){
        this.setDead();
    }

    /*@Override
    public boolean writeToNBTOptional(NBTTagCompound tags){
        return false;
    }*/

    /*@Override
    public boolean isPassenger(Entity entity){
        return this.passenger.passenger.equals(entity);
    }*/

    public void onMouseMoved(int dx, int dy){
        if(vehicle == null){ return; }
        //
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
    
    private byte clicktimer;

    public boolean onKeyPress(KeyPress key, EntityPlayer player){
        if(vehicle != null){
            if(key == null){
                //this.vehicle.getVehicleData().getScripts().forEach((script) -> script.onKeyPress(key, seatdata, player));
                return false;
            }
            else if(key.toggableInput() && world.isRemote){
        		if(clicktimer > 0) return false;
        		boolean bool = ToggableHandler.handleClick(key, vehicle, this, player);
            	clicktimer += 10; return bool;
            }
            else return vehicle.onKeyPress(key, seatdata, player);
        }
        if(world.isRemote && key.dismount() && hasPassenger()){ getControllingPassenger().dismountRidingEntity(); }
        return false;
    }

	@Override
    public boolean processInitialInteract(EntityPlayer entityplayer, EnumHand hand){
        if(isDead || world.isRemote){ return false; }
        ItemStack currentItem = entityplayer.getHeldItem(hand);
        if(vehicle.getVehicleData().isLocked()){
            Print.chat(entityplayer, "Vehicle is Locked.");
            return true;
        }
        if(currentItem != null && currentItem.getItem() instanceof ItemLead){
            if(this.getControllingPassenger() != null && this.getControllingPassenger() instanceof EntityLiving && !(this.getControllingPassenger() instanceof EntityPlayer)){
                EntityLiving mob = (EntityLiving) this.getControllingPassenger();
                this.getControllingPassenger().dismountRidingEntity();
                Print.spam(1, "PASSENGER != ENTITYPLAYER >>> DISMOUNTING");
                mob.setLeashHolder(entityplayer, true);
                return true;
            }
            double checkRange = 10;
            List<EntityLiving> nearbyMobs = world.getEntitiesWithinAABB(EntityLiving.class, new AxisAlignedBB(posX - checkRange, posY - checkRange, posZ - checkRange, posX + checkRange, posY + checkRange, posZ + checkRange));
            for(EntityLiving entity : nearbyMobs){
                if(entity.getLeashed() && entity.getLeashHolder() == entityplayer){
                    entity.startRiding(this);
                    looking.setAngles(-entity.rotationYaw, entity.rotationPitch, 0F);
                    entity.clearLeashed(true, !entityplayer.capabilities.isCreativeMode);
                }
            }
            return true;
        }
        if(this.getControllingPassenger() == null){
            entityplayer.startRiding(this);
            return true;
        }
        return false;
    }

    @Override
    public Entity getControllingPassenger(){
        return getPassengers().isEmpty() ? null : getPassengers().get(0);
    }

    @Override
    public List<Entity> getPassengers(){
        return super.getPassengers();
    }

    public boolean hasPassenger(){
		return !this.getPassengers().isEmpty();
	}

    @Override
    public void addPassenger(Entity passenger){
        super.addPassenger(passenger);
        Print.debug("AP => " + Time.getDate() + " " + seatindex + " " + (world.isRemote ? "[CLIENT]" : "[SERVER]"));
    }

    @Override
    public boolean isPassenger(Entity passenger){
        return super.isPassenger(passenger);
    }

    @Override
    public void removePassenger(Entity entity){ //Static.exception(null, false);
        if(world.isRemote){
        	super.removePassenger(entity);
        	Print.debug("RM => " + Time.getDate() + " " + seatindex + " [CLIENT] OK");
        	//
        	net.fexcraft.mod.fvtm.gui.VehicleSteeringOverlay.resetView();
        }
        else{
            Packets.sendToAllAround(new PKT_SeatDismount(entity), Resources.getTargetPoint(this));
            super.removePassenger(entity);
            Print.debug("RM => " + Time.getDate() + " " + seatindex + " [SERVER]"); return;
        }
    }

    @Override
    public void setDead(){
        if(world.isRemote){ this.isDead = true; Print.debug("DD => " + Time.getDate() + " " + seatindex + " [CLIENT] OK;"); }
        else{ this.isDead = true; Print.debug("DD => " + Time.getDate() + " " + seatindex + " [SERVER]"); }
    }

    public float getCameraDistance(){
        return vehicle != null /*&& seatdata.driver*/ ? vehicle.getVehicleData().getType().getLegacyData().camera_distance : 5F;
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float f){
    	if(world.isRemote || vehicle == null) return false;
        return vehicle.getEntity().attackEntityFrom(source, f);
    }

    public String getSeatId(){
        return seatdata == null ? "no seatdata" : seatdata.name;
    }
    
    public int getSeatIndex(){
    	return seatindex;
    }

    @Override
    public void applyEntityCollision(Entity entity){
        return;
    }

    @Override
    public boolean shouldRiderSit(){
        return seatdata == null ? true : seatdata.sitting;
    }

    @Override
    public boolean canRiderInteract(){
        return super.canRiderInteract();//TODO test this
    }

    @Override
    public AxisAlignedBB getCollisionBox(Entity entity){
        return null;//entity.getEntityBoundingBox();
    }

    @Override
    public boolean canBePushed(){
        return false;
    }

    public static final boolean isPassengerThePlayer(SeatEntity ent){
        if(ent.world.isRemote){
        	return ent.getControllingPassenger() == net.minecraft.client.Minecraft.getMinecraft().player;
        } else{ return false; }
    }

}
