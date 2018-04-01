package net.fexcraft.mod.fvtm.gui;

import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;

public class FluidInventory implements IInventory {
	
	private NonNullList<ItemStack> fluidinv = NonNullList.<ItemStack>withSize(1, ItemStack.EMPTY);
	
	public boolean isnew = true;
	public int lastaction = -1;

	@Override
	public String getName(){
		return fluidinv == null || fluidinv.isEmpty() || fluidinv.get(0).isEmpty() ? "Null;" : fluidinv.get(0).getDisplayName();
	}

	@Override
	public boolean hasCustomName(){
		return true;
	}

	@Override
	public ITextComponent getDisplayName(){
		return new TextComponentString(getName());
	}

	@Override
	public int getSizeInventory(){
		return 1;
	}

	@Override
	public boolean isEmpty(){
		return fluidinv.get(0).isEmpty();
	}

	@Override
	public ItemStack getStackInSlot(int index){
		return fluidinv.get(0);
	}

	@Override
	public ItemStack decrStackSize(int index, int count){
		return !getStackInSlot(index).isEmpty() ? ItemStackHelper.getAndSplit(fluidinv, index, count) : ItemStack.EMPTY;
	}

	@Override
	public ItemStack removeStackFromSlot(int index){
		return fluidinv.set(index, ItemStack.EMPTY);
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack){
		fluidinv.set(index, stack);
		if(fluidinv.get(0).isEmpty()){
			isnew = true;
			lastaction = 0;
		}
	}

	@Override
	public int getInventoryStackLimit(){
		return 1;
	}

	@Override
	public void markDirty(){
		//
	}

	@Override
	public boolean isUsableByPlayer(EntityPlayer player){
		return player != null && !player.isDead;
	}

	@Override
	public void openInventory(EntityPlayer player){
		//
	}

	@Override
	public void closeInventory(EntityPlayer player){
		if(!fluidinv.get(0).isEmpty() && !player.addItemStackToInventory(fluidinv.get(0))){
			player.dropItem(fluidinv.get(0), false);
		}
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack){
		return true;
	}

	@Override
	public int getField(int id){
		return 0;
	}

	@Override
	public void setField(int id, int value){
		//
	}

	@Override
	public int getFieldCount(){
		return 0;
	}

	@Override
	public void clear(){
		fluidinv.clear();
	}
	
	public static class FluidSlot extends Slot {

		//private Fluid fluid;

		public FluidSlot(IInventory inventory, int index, int xPosition, int yPosition, PartData data){
			super(inventory, index, xPosition, yPosition);
			//this.fluid = data.getPart().getAttribute(InventoryAttribute.class).getFluidType();
		}
		
		@Override
		public boolean isItemValid(ItemStack stack){
			return stack.hasCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null);
	    }
		
	}

	public NonNullList<ItemStack> getStacks(){
		return fluidinv;
	}
	
}