package net.fexcraft.mod.fvtm.gui;

import net.fexcraft.mod.addons.gep.attributes.InventoryAttribute;
import net.fexcraft.mod.addons.gep.attributes.InventoryAttribute.InventoryAttributeData;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class TempPartInventory implements IInventory {
	
	private PartData partdata;
	
	public TempPartInventory(PartData data){
		this.partdata = data;
	}

	@Override
	public String getName(){
		return partdata.getPart().getRegistryName().toString();
	}

	@Override
	public boolean hasCustomName(){
		return true;
	}

	@Override
	public ITextComponent getDisplayName(){
		return new TextComponentString(partdata.getPart().getName());
	}

	@Override
	public int getSizeInventory(){
		return partdata.getPart().getAttribute(InventoryAttribute.class).getSize();
	}

	@Override
	public boolean isEmpty(){
		return partdata.getAttributeData(InventoryAttributeData.class).isEmpty();
	}

	@Override
	public ItemStack getStackInSlot(int index){
		return partdata.getAttributeData(InventoryAttributeData.class).getInventory().get(index);
	}

	@Override
	public ItemStack decrStackSize(int index, int count){
		return !getStackInSlot(index).isEmpty() ? ItemStackHelper.getAndSplit(partdata.getAttributeData(InventoryAttributeData.class).getInventory(), index, count) : ItemStack.EMPTY;
	}

	@Override
	public ItemStack removeStackFromSlot(int index){
		return partdata.getAttributeData(InventoryAttributeData.class).getInventory().set(index, ItemStack.EMPTY);
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack){
		partdata.getAttributeData(InventoryAttributeData.class).getInventory().set(index, stack);
	}

	@Override
	public int getInventoryStackLimit(){
		return 64;
	}

	@Override
	public void markDirty(){
		// ?
	}

	@Override
	public boolean isUsableByPlayer(EntityPlayer player){
		return true;//TODO perm/lock check maybe?
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
		return partdata.getPart().getAttribute(InventoryAttribute.class).isItemValid(stack);
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
		partdata.getAttributeData(InventoryAttributeData.class).getInventory().clear();
	}

	public PartData getData(){
		return this.partdata;
	}
	
}