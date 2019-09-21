package net.fexcraft.mod.fvtm.entity;

import io.netty.buffer.ByteBuf;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.item.JunctionToolItem;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;

public class JunctionSwitchEntity extends Entity implements IEntityAdditionalSpawnData {
	
    public Junction junction;

    public JunctionSwitchEntity(World world){
        super(world); stepHeight = 0; setSize(0.5f, 0.5f);
    }

    public JunctionSwitchEntity(World world, Junction junction){
        this(world); this.junction = junction; if(junction == null) this.setDead();
    }

    @Override
    public void writeSpawnData(ByteBuf buffer){
    	try{ ByteBufUtils.writeTag(buffer, junction.getVec316f().write()); }
    	catch(Exception e){ e.printStackTrace(); }
    }

    @Override
    public void readSpawnData(ByteBuf buffer){
    	try{ Vec316f vector = new Vec316f(ByteBufUtils.readTag(buffer));
        	junction = world.getCapability(Capabilities.RAILSYSTEM, null).getJunction(vector);
    	} catch(Exception e){ e.printStackTrace(); }
    }

	@Override
    protected void readEntityFromNBT(NBTTagCompound compound){
    	this.setDead();
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound compound){
    	//
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

    /*@Override
    public void setPositionAndRotationDirect(double d, double d1, double d2, float f, float f1, int i, boolean b){
        //
    }*/

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
        if(isDead || world.isRemote || hand == EnumHand.OFF_HAND){ return false; }
        if(player.getHeldItem(hand).isEmpty()){
        	return junction.onSwitchInteract(player, this, false);
        } return false;
    }
    
    @Override
    public boolean attackEntityFrom(DamageSource damagesource, float i){
        if(world.isRemote || isDead){ return true;  }
        if(damagesource.damageType.equals("player")){
        	if(((EntityPlayer)damagesource.getTrueSource()).isSneaking()){
            	this.setDead(); if(junction != null) junction.resetSwitchPosition();
        	}
        	else return junction.onSwitchInteract((EntityPlayer)damagesource.getTrueSource(), this, true);
        }
        return true;
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target){
        return new ItemStack(JunctionToolItem.INSTANCE);
    }

}
