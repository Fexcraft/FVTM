package net.fexcraft.mod.fvtm.gui;

import net.fexcraft.mod.fvtm.blocks.ContainerTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class TempContainerTileInventory implements IInventory {
	
	private ContainerTileEntity tile;

	public TempContainerTileInventory(ContainerTileEntity tile){
		this.tile = tile;
	}

	@Override
	public String getName(){
		return "container_block";
	}

	@Override
	public boolean hasCustomName(){
		return false;
	}

	@Override
	public int getSizeInventory(){
		return tile.getContainerData().getInventory().size();
	}

	@Override
	public boolean isEmpty(){
		return tile.getContainerData().getInventory().isEmpty();
	}

	@Override
	public ItemStack getStackInSlot(int index){
		return tile.getContainerData().getInventory().get(index);
	}

	@Override
	public ItemStack decrStackSize(int index, int count){
		return !getStackInSlot(index).isEmpty() ? ItemStackHelper.getAndSplit(tile.getContainerData().getInventory(), index, count) : ItemStack.EMPTY;
	}

	@Override
	public ItemStack removeStackFromSlot(int index){
		return tile.getContainerData().getInventory().set(index, ItemStack.EMPTY);
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack){
		tile.getContainerData().getInventory().set(index, stack);
	}

	@Override
	public int getInventoryStackLimit(){
		return 64;
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
		//
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack){
		return tile.getContainerData().getContainer().isItemValid(stack);
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
		tile.getContainerData().getInventory().clear();
	}

	@Override
	public ITextComponent getDisplayName(){
		return new TextComponentString(tile.getContainerData().getContainer().getName());
	}

	@Override
	public void markDirty(){
		//
	}

}
