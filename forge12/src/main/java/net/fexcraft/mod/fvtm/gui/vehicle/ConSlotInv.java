package net.fexcraft.mod.fvtm.gui.vehicle;

import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.container.ContainerData;
import net.fexcraft.mod.fvtm.data.container.ContainerSlot;
import net.fexcraft.mod.fvtm.item.ContainerItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

/** @author Ferdinand Calo' (FEX___96) */
public class ConSlotInv implements IInventory {

	private ContainerSlot slot;
	private Entity entity;
	//
	private ItemStack[] array;

    public ConSlotInv(ContainerSlot slot, Entity entity){
        this.slot = slot; this.entity = entity; array = new ItemStack[slot.length];
    	for(int i = 0; i < slot.length; i++){
        	array[i] = slot.getContainers()[i] == null ? null : slot.getContainers()[i].getNewStack().local();
        }
    }

    private void copytoslot(){
    	for(int i = 0; i < array.length; i++){
    		slot.setContainer(i, array[i] == null || array[i].isEmpty() ? null : ((ContainerItem)array[i].getItem()).getDataFromTag(array[i].getTagCompound()));
    	}
	}

	@Override
    public String getName(){
        return "Container Slot Temporary Inventory";
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
        return slot.length;
    }

    @Override
    public boolean isEmpty(){
    	for(ContainerData data : slot.getContainers()) if(data != null) return false; return true;
    }

    @Override
    public ItemStack getStackInSlot(int index){
        return array[index] == null ? ItemStack.EMPTY : array[index];
    }

    @Override
    public ItemStack decrStackSize(int index, int count){
    	if(array[index] != null){
    		ItemStack stack = array[index]; array[index] = null; this.copytoslot();
    		return stack;
    	}
    	return ItemStack.EMPTY;
    }

    @Override
    public ItemStack removeStackFromSlot(int index){
    	this.copytoslot(); return array[index] = null;
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack){
        array[index] = stack; this.copytoslot();
    }

    @Override
    public int getInventoryStackLimit(){
        return 1;
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
    	copytoslot(); if(!entity.world.isRemote){ entity.getCapability(Capabilities.CONTAINER, null).sync(false); }
    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack){
    	if(!(stack.getItem() instanceof ContainerItem)) return false;
    	ContainerData data = stack.getCapability(Capabilities.VAPDATA, null).getContainerData();
    	if(slot.onlytype != null && data.getContainerType() != slot.onlytype) return false;
    	//
    	boolean[] bools = slot.getFillStateArray();
    	int end = index + data.getContainerType().length();
    	for(int i = index; i < end; i++){
    		if(i >= bools.length || bools[i]) return false;
    	} return true;
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
        array = new ItemStack[slot.length];
    }
    
    public ItemStack[] getArray(){
		return array;
	}
    
    public static class SSlot extends Slot {

        public SSlot(IInventory inventory, int index, int xPosition, int yPosition){
            super(inventory, index, xPosition, yPosition);
        }

        @Override
        public boolean isItemValid(ItemStack stack){
        	return inventory.isItemValidForSlot(getSlotIndex(), stack);
        }

    }

}
