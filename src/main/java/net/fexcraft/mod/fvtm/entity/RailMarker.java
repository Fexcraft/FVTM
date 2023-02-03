package net.fexcraft.mod.fvtm.entity;

import java.util.UUID;

import io.netty.buffer.ByteBuf;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.mod.fvtm.item.RailGaugeItem;
import net.fexcraft.mod.fvtm.sys.rail.RailPlacingUtil;
import net.fexcraft.mod.fvtm.sys.rail.RailPlacingUtil.NewTrack;
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

public class RailMarker extends Entity implements IEntityAdditionalSpawnData {
	
	public GridV3D position;
	public UUID queueid;

    public RailMarker(World world){
        super(world);
        stepHeight = 0;
        setSize(0.24f, 1f);
    }

    public RailMarker(World world, UUID id){
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
    		buffer.writeDouble(position.vector.x);
    		buffer.writeDouble(position.vector.y);
    		buffer.writeDouble(position.vector.z);
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
    		position = new GridV3D(new V3D(buffer.readDouble(), buffer.readDouble(), buffer.readDouble()));
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
    	if(queueid == null || !RailPlacingUtil.QUEUE.containsKey(queueid)) setDead();
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
    	UUID current = RailPlacingUtil.CURRENT.get(player.getGameProfile().getId());
    	if(current == null || queueid == null) return true;
        if(queueid.equals(current)){
        	NewTrack track = RailPlacingUtil.QUEUE.get(current);
        	if(track == null) return true;
        	if(player.getHeldItemMainhand().getItem() instanceof RailGaugeItem){
        		track.create(player, position);
        	}
        	else track.select(player, position);
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
            	NewTrack track = RailPlacingUtil.QUEUE.get(queueid);
            	if(track != null) track.remove(player, position);
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
