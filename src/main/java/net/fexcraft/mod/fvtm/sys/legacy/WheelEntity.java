package net.fexcraft.mod.fvtm.sys.legacy;

import io.netty.buffer.ByteBuf;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.vehicle.LegacyData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WheelEntity extends Entity implements IEntityAdditionalSpawnData {

    public GenericVehicle vehicle;
    public LegacyData lata;

    @SideOnly(Side.CLIENT)
    public boolean foundveh;
    private int vehicleid;
    public int wheelid;

    public WheelEntity(World world){
        super(world); setSize(0.25F, 0.25F); stepHeight = 1.1F;
    }

    public WheelEntity(GenericVehicle entity, int i){
        this(entity.world); vehicle = entity;
        vehicleid = entity.getEntity().getEntityId();
        wheelid = i; initPosition();
    }

    @Override
    public void writeSpawnData(ByteBuf buffer){
        buffer.writeInt(vehicleid); buffer.writeInt(wheelid);
    }

    @Override
    public void readSpawnData(ByteBuf buffer){
        vehicleid = buffer.readInt(); wheelid = buffer.readInt();
        if(world.getEntityByID(vehicleid) instanceof GenericVehicle){
            vehicle = (GenericVehicle)world.getEntityByID(vehicleid);
        }
        if(vehicle != null){
            setPosition(posX, posY, posZ);
        }
    }

    public void initPosition(){
    	lata = vehicle.getVehicleData().getType().getLegacyData();
    	//Print.debug(wheelid, this, vehicle, vehicle.getVehicleData().getWheelPositions());
    	String index = vehicle.getVehicleType().isAirVehicle() ? AirVehicle.WHEELINDEX[wheelid] : LandVehicle.WHEELINDEX[wheelid];
    	if(!vehicle.getVehicleData().getWheelPositions().containsKey(index)){
    		Print.debug("Vehicle was missing an essential Wheel Position, skipping wheel[" + wheelid + "] init.");
    		return;
    	}
        Vec3d vec = vehicle.getAxes().getRelativeVector(vehicle.getVehicleData().getWheelPositions().get(index));
        setPosition(vehicle.getEntity().posX + vec.x, vehicle.getEntity().posY + vec.y, vehicle.getEntity().posZ + vec.z);
        stepHeight = lata.wheel_step_height;
        //
        prevPosX = posX; prevPosY = posY; prevPosZ = posZ;
    }

    @Override
    public void fall(float k, float l){
        //
    }

    @Override
    protected void entityInit(){
        //
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound tags){
        this.setDead();
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound tags){
        //
    }

    @Override
    public void onUpdate(){
        if(world.isRemote && !foundveh){
            if(!(world.getEntityByID(vehicleid) instanceof VehicleEntity)){ return; }
            vehicle = (GenericVehicle)world.getEntityByID(vehicleid);
            foundveh = true; lata = vehicle.getVehicleData().getType().getLegacyData();
            if((vehicle.getVehicleType().isAirVehicle() ? 3 : 4) <= wheelid){ this.setDead(); return; }
            vehicle.wheels[wheelid] = this;
        }
        if(vehicle == null){ return; }
        if(!addedToChunk){ world.spawnEntity(this); }
    }

    public double getHorizontalSpeed(){
        return Math.sqrt(motionX * motionX + motionZ * motionZ);
    }

    @Override
    public void setPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int incr, boolean tele){
        this.setPosition(x, y, z); this.setRotation(yaw, pitch);
    }

    @Override
    public boolean canBePushed(){
        return false;
    }

    @Override
    public boolean canBeCollidedWith(){
        return false;//!isDead;
    }

    @Override
    public void applyEntityCollision(Entity entity){
        return;
    }

}
