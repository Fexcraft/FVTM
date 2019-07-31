package net.fexcraft.mod.fvtm.entity;

import java.nio.charset.StandardCharsets;
import io.netty.buffer.ByteBuf;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.RoadSign;
import net.fexcraft.mod.fvtm.item.MaterialItem;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;

public class RoadSignEntity extends Entity implements IEntityAdditionalSpawnData {
	
    private boolean locked = false;
    public EnumFacing facing;
    public RoadSign sign;

    public RoadSignEntity(World world){
        super(world); stepHeight = 0; setSize(0.75f, 0.75f); locked = false;
    }

    public RoadSignEntity(World world, EnumFacing facing, RoadSign sign){
        this(world); this.facing = facing; this.sign = sign;
    }

    @Override
    public void writeSpawnData(ByteBuf buffer){
    	try{
            buffer.writeByte(facing.getIndex()); buffer.writeBoolean(locked);
            String regname = sign.getRegistryName().toString();
        	buffer.writeInt(regname.length());
        	buffer.writeCharSequence(regname, StandardCharsets.UTF_8);
    	}
    	catch(Exception e){
			e.printStackTrace();
		}
    }

    @Override
    public void readSpawnData(ByteBuf buffer){
    	try{
        	facing = EnumFacing.getFront(buffer.readByte()); locked = buffer.readBoolean();
        	sign = Resources.getRoadSign(buffer.readCharSequence(buffer.readInt(), StandardCharsets.UTF_8).toString());
    	}
    	catch(Exception e){
			e.printStackTrace();
		}
    }

	@Override
    protected void readEntityFromNBT(NBTTagCompound compound){
    	facing = EnumFacing.getFront(compound.getByte("facing"));
        locked = compound.getBoolean("locked");
        sign = Resources.getRoadSign(compound.getString("fvtm:roadsign"));
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound compound){
    	compound.setByte("facing", (byte)facing.getIndex());
    	compound.setBoolean("locked", locked);
    	compound.setString("fvtm:roadsign", sign.getRegistryName().toString());
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
        if(!stack.isEmpty() && stack.getItem() instanceof MaterialItem && ((MaterialItem)stack.getItem()).getType().isVehicleKey()){
            /*if(this.isLocked()){
                this.unlock(world, player, stack, (KeyItem)stack.getItem());
            }
            else{
                this.lock(world, player, stack, (KeyItem)stack.getItem());
            }*/
            return true;
        }
        if(locked){
            Print.chat(player, "Sign is locked.");
            return true;
        }
        if(stack.isEmpty()){
        	//GenericGui.openGui("fvtm", 700, new int[]{ this.getEntityId(), 0, 0 }); return true;
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
            entityDropItem(stack, 0.5F); this.setDead();
        }
        return true;
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target){
        return sign == null ? new ItemStack(Items.FEATHER) : sign.newItemStack();
    }

}
