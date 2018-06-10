package net.fexcraft.mod.fvtm.gui;

import net.fexcraft.mod.fvtm.api.Container.ContainerItem;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleItem;
import net.fexcraft.mod.fvtm.util.ItemStackHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class TempUTInventory implements IInventory {

    private NonNullList<ItemStack> stacks;
    private String sel;

    public TempUTInventory(NonNullList<ItemStack> nonNullList, String sel){
		stacks = nonNullList; this.sel = sel;
	}

	@Override
    public String getName(){
        return "universal_block";
    }

    @Override
    public boolean hasCustomName(){
        return false;
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
    	if(!sel.endsWith("_out")){
            if(stack.getItem() instanceof VehicleItem || stack.getItem() instanceof ContainerItem || ItemStackHandler.isContainerPart(stack)){
                return false;
            }
    	}
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

    @Override
    public ITextComponent getDisplayName(){
        return new TextComponentString("block_inventory:" + sel);
    }

    @Override
    public void markDirty(){
        //
    }

}
