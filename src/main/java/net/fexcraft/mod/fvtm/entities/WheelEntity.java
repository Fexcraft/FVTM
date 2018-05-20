package net.fexcraft.mod.fvtm.entities;

import io.netty.buffer.ByteBuf;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.lib.util.math.Pos;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WheelEntity extends Entity implements IEntityAdditionalSpawnData {

    public VehicleEntity vehicle;

    @SideOnly(Side.CLIENT)
    public boolean foundveh;
    private int vehicleid;
    public int wheelid;

    public WheelEntity(World world){
        super(world);
        setSize(0.75F, 0.75F);
        stepHeight = 1.1F;
    }

    public WheelEntity(World world, VehicleEntity entity, int i){
        this(world);
        vehicle = entity;
        vehicleid = entity.getEntity().getEntityId();
        wheelid = i;
        initPosition();
    }

    @Override
    public void writeSpawnData(ByteBuf buffer){
        buffer.writeInt(vehicleid);
        buffer.writeInt(wheelid);
    }

    @Override
    public void readSpawnData(ByteBuf buffer){
        vehicleid = buffer.readInt();
        wheelid = buffer.readInt();
        if(world.getEntityByID(vehicleid) instanceof VehicleEntity){
            vehicle = (VehicleEntity) world.getEntityByID(vehicleid);
        }
        if(vehicle != null){
            setPosition(posX, posY, posZ);
        }
    }

    public void initPosition(){
        Pos s = vehicle.getVehicleData().getWheelPos().get(wheelid);
        Vec3d vec = vehicle.getAxes().getRelativeVector(s.to16Double());
        setPosition(vehicle.getEntity().posX + vec.x, vehicle.getEntity().posY + vec.y, vehicle.getEntity().posZ + vec.z);
        stepHeight = vehicle.getVehicleData().getVehicle().getFMWheelStepHeight();
        //
        prevPosX = posX;
        prevPosY = posY;
        prevPosZ = posZ;
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
            if(!(world.getEntityByID(vehicleid) instanceof VehicleEntity)){
                return;
            }
            vehicle = (VehicleEntity) world.getEntityByID(vehicleid);
            foundveh = true;
            vehicle.getWheels()[wheelid] = this;
        }
        if(vehicle == null){
            return;
        }
        if(!addedToChunk){
            world.spawnEntity(this);
        }
    }

    public double getHorizontalSpeed(){
        return Math.sqrt(motionX * motionX + motionZ * motionZ);
    }

    @Override
    public void setPositionAndRotationDirect(double d, double d1, double d2, float f, float f1, int i, boolean b){
        //
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
