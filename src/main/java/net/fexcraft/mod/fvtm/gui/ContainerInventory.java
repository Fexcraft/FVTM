package net.fexcraft.mod.fvtm.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class ContainerInventory implements IInventory {
	
	private NonNullList<ItemStack> coninv = NonNullList.<ItemStack>withSize(2, ItemStack.EMPTY);

	@Override
	public String getName(){
		return coninv == null || coninv.isEmpty() || coninv.get(0).isEmpty() ? "Null;" : coninv.get(0).getDisplayName();
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
		return 2;
	}

	@Override
	public boolean isEmpty(){
		return coninv.get(0).isEmpty() && coninv.get(1).isEmpty();
	}

	@Override
	public ItemStack getStackInSlot(int index){
		//TODO
		return null;
	}

	@Override
	public ItemStack decrStackSize(int index, int count){
		//TODO
		return null;
	}

	@Override
	public ItemStack removeStackFromSlot(int index){
		//TODO
		return null;
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack){
		//TODO
	}

	@Override
	public int getInventoryStackLimit(){
		//TODO
		return 0;
	}

	@Override
	public void markDirty(){
		//TODO
	}

	@Override
	public boolean isUsableByPlayer(EntityPlayer player){
		return !player.isDead;
	}

	@Override
	public void openInventory(EntityPlayer player){
		//TODO
	}

	@Override
	public void closeInventory(EntityPlayer player){
		//TODO drop
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack){
		//TODO
		return false;
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
		coninv.clear();
	}
	
}