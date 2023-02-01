package net.fexcraft.mod.fvtm.entity;

import java.util.UUID;

import io.netty.buffer.ByteBuf;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.mod.fvtm.item.RoadToolItem;
import net.fexcraft.mod.fvtm.sys.road.RoadPlacingUtil;
import net.fexcraft.mod.fvtm.sys.road.RoadPlacingUtil.NewRoad;
import net.fexcraft.mod.fvtm.util.GridV3D;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;

public class RoadMarker extends Entity implements IEntityAdditionalSpawnData {
	
	public GridV3D position;
	public UUID queueid;

    public RoadMarker(World world){
        super(world);
        stepHeight = 0;
        setSize(0.24f, 0.5f);
    }

    public RoadMarker(World world, UUID id){
        this(world);
        queueid = id;
    }

    @Override
    public void writeSpawnData(ByteBuf buffer){
    	try{
    		if(queueid == null){
        		buffer.writeLong(0);
        		buffer.writeLong(0);
    		}
    		else{
        		buffer.writeLong(queueid.getMostSignificantBits());
        		buffer.writeLong(queueid.getLeastSignificantBits());
    		}
    		buffer.writeFloat(position.vector.x);
    		buffer.writeFloat(position.vector.y);
    		buffer.writeFloat(position.vector.z);
    	}
    	catch(Exception e){
			e.printStackTrace();
		}
    }

    @Override
    public void readSpawnData(ByteBuf buffer){
    	try{
    		long m = buffer.readLong(), l = buffer.readLong();
    		if(m == 0 && l == 0) queueid = null;
    		else queueid = new UUID(m, l);
    		position = new GridV3D(new Vec3f(buffer.readFloat(), buffer.readFloat(), buffer.readFloat()));
    	}
    	catch(Exception e){
			e.printStackTrace();
		}
    }

	@Override
	public void readEntityFromNBT(NBTTagCompound compound){
        if(compound.hasKey("uuid0")){
        	queueid = new UUID(compound.getLong("uuid0"), compound.getLong("uuid1"));
        }
        if(compound.hasKey("position")){
        	position = new GridV3D(compound.getCompoundTag("position"));
        }
    }

	@Override
    protected void writeEntityToNBT(NBTTagCompound compound){
    	if(queueid != null){
    		compound.setLong("uuid0", queueid.getMostSignificantBits());
    		compound.setLong("uuid1", queueid.getLeastSignificantBits());
    	}
    	if(position != null){
    		compound.setTag("position", position.write());
    	}
    }
    
	@Override
	public void setDead(){
		super.setDead();
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
    public void onUpdate(){
    	if(world.isRemote) return;
    	if(queueid == null || !RoadPlacingUtil.QUEUE.containsKey(queueid)) setDead();
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
        return !isDead;
    }

    @Override
    public void applyEntityCollision(Entity entity){
        return;
    }
    
    @Override
    public boolean processInitialInteract(EntityPlayer player, EnumHand hand){
    	if(world.isRemote || hand == EnumHand.OFF_HAND) return true;
    	UUID current = RoadPlacingUtil.CURRENT.get(player.getGameProfile().getId());
    	if(current == null || queueid == null) return true;
        if(queueid.equals(current)){
        	NewRoad road = RoadPlacingUtil.QUEUE.get(current);
        	if(road == null) return true;
        	if(player.getHeldItemMainhand().getItem() instanceof RoadToolItem){
        		road.create(player, position, player.getHeldItemMainhand());
        	}
        	else road.select(player, position);
    		return true;
        }
        return true;
    }
    
    @Override
    public boolean attackEntityFrom(DamageSource damagesource, float i){
        if(world.isRemote || isDead){
            return true;
        }
        if(damagesource.damageType.equals("player")){
            if(queueid != null && queueid.equals(queueid)){
            	EntityPlayer player = (EntityPlayer)damagesource.getTrueSource();
            	NewRoad road = RoadPlacingUtil.QUEUE.get(queueid);
            	if(road != null) road.remove(player, position);
                setDead();
            }
        }
        return true;
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target){
        return new ItemStack(Items.GLOWSTONE_DUST);
    }

}
