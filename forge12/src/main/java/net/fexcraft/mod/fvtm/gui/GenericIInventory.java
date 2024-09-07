package net.fexcraft.mod.fvtm.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

/** @author Ferdinand Calo' (FEX___96) */
public class GenericIInventory implements IInventory {
	
	private NonNullList<ItemStack> stacks;
	private int stacksize;

    public GenericIInventory(NonNullList<ItemStack> list, int size, int stacksize){
    	stacks = list == null ? NonNullList.<ItemStack>withSize(size, ItemStack.EMPTY) : list;
    	this.stacksize = stacksize;
    }

    @Override
    public String getName(){
        return "Generic IInventory Implementation.";
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
        return stacks.size();
    }

    @Override
    public boolean isEmpty(){
        return stacks.isEmpty();
    }

    @Override
    public ItemStack getStackInSlot(int index){
        return stacks.get(index);
    }

    @Override
    public ItemStack decrStackSize(int index, int count){
        return !getStackInSlot(index).isEmpty() ? ItemStackHelper.getAndSplit(stacks, index, count) : ItemStack.EMPTY;
    }

    @Override
    public ItemStack removeStackFromSlot(int index){
        return stacks.set(index, ItemStack.EMPTY);
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack){
        stacks.set(index, stack);
    }

    @Override
    public int getInventoryStackLimit(){
        return stacksize;
    }

    @Override
    public void markDirty(){
    	//
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer player){
        return true;
    }

    @Override
    public void openInventory(EntityPlayer player){
        //
    }

    @Override
    public void closeInventory(EntityPlayer player){
    	for(ItemStack stack : stacks){
    		if(!stack.isEmpty() && !player.addItemStackToInventory(stack)){
    			player.dropItem(stack, false);
    		}
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
        stacks.clear();
    }

}
