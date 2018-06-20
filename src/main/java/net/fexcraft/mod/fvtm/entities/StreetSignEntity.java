package net.fexcraft.mod.fvtm.entities;

import io.netty.buffer.ByteBuf;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.util.Tabs;
import net.fexcraft.mod.lib.api.common.LockableObject;
import net.fexcraft.mod.lib.api.item.KeyItem;
import net.fexcraft.mod.lib.api.item.fItem;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.registry.RegistryUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;

public class StreetSignEntity extends Entity implements IEntityAdditionalSpawnData, LockableObject {
	
	private static Item ITEM;
    private EnumFacing facing;
    private boolean locked;

    public StreetSignEntity(World world){
        super(world);
        stepHeight = 0;
        setSize(0.75f, 0.75f);
        locked = false;
    }

    public StreetSignEntity(World world, EnumFacing facing){
        this(world);
        this.facing = facing;
    }

    @Override
    public void writeSpawnData(ByteBuf buffer){
        buffer.writeInt(facing.getIndex());
        buffer.writeBoolean(locked);
    }

    @Override
    public void readSpawnData(ByteBuf buffer){
    	facing = EnumFacing.getFront(buffer.readInt());
    	locked = buffer.readBoolean();
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
    protected void readEntityFromNBT(NBTTagCompound compound){
        facing = EnumFacing.getFront(compound.getByte("facing"));
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound compound){
    	compound.setByte("facing", (byte)facing.getIndex());
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
        /*if(!stack.isEmpty() && stack.getItem() instanceof KeyItem && (stack.getItem() instanceof Material.MaterialItem ? ((Material.MaterialItem) stack.getItem()).getMaterial(stack).isVehicleKey() : true)){
            if(this.isLocked()){
                this.unlock(world, player, stack, (KeyItem)stack.getItem());
            }
            else{
                this.lock(world, player, stack, (KeyItem)stack.getItem());
            }
            return true;
        }*/
        if(isLocked()){
            Print.chat(player, "Sign is locked.");
            return true;
        }
        if(stack.isEmpty()){
        	//TODO open GUI
        	return true;
        }
        return false;
    }

	@Override
	public boolean isLocked(){
		return locked;
	}

	@Override
	public boolean unlock(World world, EntityPlayer entity, ItemStack stack, KeyItem item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock(World world, EntityPlayer entity, ItemStack stack, KeyItem item) {
		// TODO Auto-generated method stub
		return false;
	}
    
    @Override
    public boolean attackEntityFrom(DamageSource damagesource, float i){
        if(world.isRemote || isDead){
            return true;
        }
        if(damagesource.damageType.equals("player")){
            if(isLocked()){
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
        return new ItemStack(getItem());
    }
    
    public static Item getItem(){
    	return ITEM == null ? ITEM = RegistryUtil.getItem("fvtm:streetsign") : ITEM;
    }
    
    @fItem(modid = FVTM.MODID, name = "streetsign")
    public static class StreetSignItem extends Item {
    	
    	public StreetSignItem(){
    		this.setCreativeTab(Tabs.BLOCKS);
    	}
    	
    }

}
