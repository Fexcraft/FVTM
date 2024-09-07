package net.fexcraft.mod.fvtm.entity;

import static net.fexcraft.mod.fvtm.gui.GuiHandler.TSEDITOR;

import io.netty.buffer.ByteBuf;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.item.MaterialItem;
import net.fexcraft.mod.fvtm.item.TrafficSignItem;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSigns;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;

public class TrafficSignEntity extends Entity implements IEntityAdditionalSpawnData {
	
    private boolean locked = false;

    public TrafficSignEntity(World world){
        super(world);
        stepHeight = 0;
        setSize(0.75f, 0.75f);
        locked = false;
    }

    @Override
    public void writeSpawnData(ByteBuf buffer){
    	try{
            buffer.writeBoolean(locked);
    	}
    	catch(Exception e){
			e.printStackTrace();
		}
    }

    @Override
    public void readSpawnData(ByteBuf buffer){
    	try{
        	locked = buffer.readBoolean();
    	}
    	catch(Exception e){
			e.printStackTrace();
		}
    }

	@Override
    protected void readEntityFromNBT(NBTTagCompound compound){
        locked = compound.getBoolean("locked");
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound compound){
    	compound.setBoolean("locked", locked);
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
    	//
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
        if(isDead || world.isRemote || hand == EnumHand.OFF_HAND){
            return false;
        }
        ItemStack stack = player.getHeldItem(hand);
        if(!stack.isEmpty() && stack.getItem() instanceof MaterialItem ){//TODO && ((MaterialItem)stack.getItem()).getType().isVehicleKey()){
            locked = !locked;
            Print.chat(player, "Toggled sign status.");
            return true;
        }
        if(locked){
            Print.chat(player, "Sign is locked.");
            return true;
        }
        if(stack.isEmpty()){
        	player.openGui(FVTM.getInstance(), TSEDITOR, world, getEntityId(), 0, 0);
        	return true;
        }
        return false;
    }
    
    @Override
    public boolean attackEntityFrom(DamageSource damagesource, float i){
        if(world.isRemote || isDead){
            return true;
        }
        if(damagesource.damageType.equals("player")){
            if(locked){
                Print.chat(damagesource.getImmediateSource(), "Sign is locked.");
                return true;
            }
        	ItemStack stack = this.getPickedResult(null);
            entityDropItem(stack, 0.5F);
            setDead();
            BlockPos pos = getPosition();
            TrafficSigns cap = world.getChunk(pos).getCapability(Capabilities.TRAFFIC_SIGNS, null);
            if(cap != null) cap.remove(pos);
        }
        return true;
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target){
    	Chunk chunk = world.getChunk(getPosition());
    	TrafficSigns cap = chunk == null ? null : chunk.getCapability(Capabilities.TRAFFIC_SIGNS, null);
        return cap == null ? new ItemStack(TrafficSignItem.INSTANCE) : cap.signToItem(getPosition());
    }

}
