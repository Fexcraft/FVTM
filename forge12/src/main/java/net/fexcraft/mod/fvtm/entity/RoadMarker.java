package net.fexcraft.mod.fvtm.entity;

import java.util.UUID;

import io.netty.buffer.ByteBuf;
import net.fexcraft.mod.fvtm.item.RoadToolItem;
import net.fexcraft.mod.fvtm.sys.road.RoadPlacingUtil;
import net.fexcraft.mod.fvtm.sys.road.RoadPlacingUtil.NewRoad;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.tag.TagCW;
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
	
	public QV3D position;
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
    		buffer.writeDouble(position.vec.x);
    		buffer.writeDouble(position.vec.y);
    		buffer.writeDouble(position.vec.z);
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
    		position = new QV3D(buffer.readDouble(), buffer.readDouble(), buffer.readDouble());
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
        	position = new QV3D(TagCW.wrap(compound), "position");
        }
    }

	@Override
    protected void writeEntityToNBT(NBTTagCompound compound){
    	if(queueid != null){
    		compound.setLong("uuid0", queueid.getMostSignificantBits());
    		compound.setLong("uuid1", queueid.getLeastSignificantBits());
    	}
    	if(position != null){
    		position.write(TagCW.wrap(compound), "position");
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
			Passenger pass = (Passenger)UniEntity.getEntity(player);
        	if(player.getHeldItemMainhand().getItem() instanceof RoadToolItem){
        		road.create(pass, position, pass.getHeldItem(true));
        	}
        	else road.select(pass, position);
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
            	if(road != null) road.remove((Passenger)UniEntity.getEntity(player), position);
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
