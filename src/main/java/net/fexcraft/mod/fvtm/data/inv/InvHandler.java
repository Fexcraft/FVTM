package net.fexcraft.mod.fvtm.data.inv;

import net.fexcraft.mod.fvtm.util.handler.ContentFilter;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.items.ItemStackHandler;

public class InvHandler {
	
	public final InvType type;
	protected String initarg;
	protected int capacity;

	public InvHandler(InvType type){
		this.type = type;
	}
	
	public InvHandler setArg(String str){
		if(this.getClass() == InvHandler.class) initarg = str;
		return this;
	}
	
	public InvHandler setCapacity(int val){
		if(this.getClass() == InvHandler.class) capacity = val;
		return this;
	}
	
	public InvHandler gen(){
		if(type.isItem()) return new InvHandlerItem(type, initarg, capacity);
		else if(type.isFluid()) return new InvHandlerFluid(type, initarg, capacity);
		else if(type.isContainer());
		else if(type.isVariable());
		return null;
	}
	
	public int capacity(){
		return capacity;
	}

	public Fluid getFluid(){
		return null;
	}

	public ContentFilter getFilter(){
		return null;
	}
	
	//

	public NBTTagCompound save(NBTTagCompound compound){
		return save(compound, null);
	}

	public void load(NBTTagCompound compound){
		load(compound, null);
	}

	public NBTTagCompound save(NBTTagCompound compound, String ctag){
		return compound;
	}

	public void load(NBTTagCompound compound, String ctag){}
	
	//

	public NonNullList<ItemStack> getStacks(){
		return null;
	}

	public FluidTank getTank(){
		return null;
	}

	public String getContentDesc(){
		return "empty";
	}

	public void dropAllAt(Entity entity){
		if(!type.isItem()) return;
		for(int i = 0; i < getStacks().size(); i++){
            entity.entityDropItem(getStacks().get(i), 0.5f);
            getStacks().set(i, ItemStack.EMPTY);
		}
	}

	public String getBlkSavePrefix(){
		if(type.isItem()) return "inv-";
		if(type.isFluid()) return "tank-";
		if(type.isVariable()) return "var-";
		return "";
	}

	public ItemStackHandler getStackHandler(){
		return null;
	}

	public Object getCapObj(){
		if(type.isFluid()) return getTank();
		if(type.isItem()) return getStackHandler();
		return null;
	}

}
