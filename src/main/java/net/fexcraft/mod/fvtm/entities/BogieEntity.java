package net.fexcraft.mod.fvtm.entities;

import io.netty.buffer.ByteBuf;
import net.fexcraft.mod.fvtm.api.Vehicle.MovementCalculationEntity;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.lib.util.math.Pos;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BogieEntity extends MovementCalculationEntity implements IEntityAdditionalSpawnData {

    public VehicleEntity vehicle;
    @SideOnly(Side.CLIENT)
    public boolean foundveh;
    private int vehicleid;
    public int wheelid;
    //
    BlockPos lpos, pos;
    Vec3d dest;

    public BogieEntity(World world){
        super(world);
        setSize(0.45F, 0.45F);
        stepHeight = 1.1F;
    }

    public BogieEntity(World world, VehicleEntity entity, int i, BlockPos pos){
        this(world);
        vehicle = entity;
        vehicleid = entity.getEntity().getEntityId();
        wheelid = i;
        initPosition();
        if(pos != null){
        	lpos = this.pos = pos;
        }
        else{
        	lpos = this.pos = new BlockPos(posX, posY, posZ);
        }
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
    	Pos s = null;
    	if(wheelid >= vehicle.getVehicleData().getWheelPos().size() && vehicle.getVehicleData().getVehicle().isTrailerOrWagon()){
    		s = vehicle.getVehicleData().getWheelPos().get(wheelid == 2 ? 1 : 0);
    		s = new Pos(0, s.y, s.z);
    	}
    	else{
    		s = vehicle.getVehicleData().getWheelPos().get(wheelid);
    	}
        Vec3d vec = vehicle.getAxes().getRelativeVector(s.to16Double());
        setPosition(vehicle.getEntity().posX + vec.x, vehicle.getEntity().posY + vec.y, vehicle.getEntity().posZ + vec.z);
        stepHeight = vehicle.getVehicleData().getVehicle().getFMAttribute("wheel_step_height");
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
            if(vehicle.getWheels().length <= wheelid){
            	this.setDead();
            	return;
            }
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
        return true;
    }

    @Override
    public boolean canBeCollidedWith(){
        return !isDead;
    }

    @Override
    public void applyEntityCollision(Entity entity){
        return;
    }

	public double moveAlongRails(double amount){
		//
		return 0;
	}

}
