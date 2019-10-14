package net.fexcraft.mod.fvtm.gui.road;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

/** @author Ferdinand Calo' (FEX___96) */
public class RoadInventory implements IInventory {
	
	private NonNullList<ItemStack> stacks;

    public RoadInventory(int size){
    	stacks = NonNullList.<ItemStack>withSize(size, ItemStack.EMPTY);
    }

    @Override
    public String getName(){
        return "Road Inventory";
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
    	ItemStack stack = !getStackInSlot(index).isEmpty() ? ItemStackHelper.getAndSplit(stacks, index, count) : ItemStack.EMPTY;
    	if(index < 6){
        	ItemStack stack0 = stacks.get(index);
    		if(index < 3){
    			stacks.set(0, stack0); stacks.set(1, stack0); stacks.set(2, stack0);
    		}
    		else{
    			stacks.set(3, stack0); stacks.set(4, stack0); stacks.set(5, stack0);
    		}
    	}
        return stack;
    }

    @Override
    public ItemStack removeStackFromSlot(int index){
    	if(index < 6){
    		if(index < 3){
    			stacks.set(0, ItemStack.EMPTY); stacks.set(1, ItemStack.EMPTY); stacks.set(2, ItemStack.EMPTY);
    		}
    		else{
    			stacks.set(3, ItemStack.EMPTY); stacks.set(4, ItemStack.EMPTY); stacks.set(5, ItemStack.EMPTY);
    		}
    	}
        return stacks.set(index, ItemStack.EMPTY);
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack){
    	if(index < 6){
    		if(index < 3){
    			stacks.set(0, stack); stacks.set(1, stack); stacks.set(2, stack);
    		}
    		else{
    			stacks.set(3, stack); stacks.set(4, stack); stacks.set(5, stack);
    		}
    	}
        stacks.set(index, stack);
    }

    @Override
    public int getInventoryStackLimit(){
        return 64;
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
    	if(!stacks.get(0).isEmpty() && !player.addItemStackToInventory(stacks.get(0))) player.dropItem(stacks.get(0), false);
    	if(!stacks.get(3).isEmpty() && !player.addItemStackToInventory(stacks.get(3))) player.dropItem(stacks.get(3), false);
    	if(!stacks.get(6).isEmpty() && !player.addItemStackToInventory(stacks.get(6))) player.dropItem(stacks.get(6), false);
    	if(!stacks.get(7).isEmpty() && !player.addItemStackToInventory(stacks.get(7))) player.dropItem(stacks.get(7), false);
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
    
    public static class RoadSlot extends Slot {

        public RoadSlot(IInventory inventory, int index, int xPosition, int yPosition){
            super(inventory, index, xPosition, yPosition);
        }

        @SuppressWarnings("deprecation") @Override
        public boolean isItemValid(ItemStack stack){
        	if(stack.getItem() instanceof ItemBlock == false) return false;
            Block block = ((ItemBlock)stack.getItem()).getBlock();
            return block.isFullBlock(block.getDefaultState());
        }

    }

}
