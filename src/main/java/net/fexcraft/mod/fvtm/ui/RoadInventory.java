package net.fexcraft.mod.fvtm.ui;

import static net.fexcraft.mod.fvtm.util.Compat.isFVTMRoad;
import static net.fexcraft.mod.fvtm.util.Compat.isValidFlenix;

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

    public RoadInventory(){
    	stacks = NonNullList.<ItemStack>withSize(6, ItemStack.EMPTY);
    }

    public RoadInventory(int size){
    	stacks = NonNullList.<ItemStack>withSize(size, ItemStack.EMPTY);
    }

    @Override
    public String getName(){
        return "Road Fill Inventory";
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
        return 1;
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
    	for(int i = 0; i < stacks.size(); i++){
        	if(!stacks.get(i).isEmpty() && !player.addItemStackToInventory(stacks.get(i))) player.dropItem(stacks.get(i), false);
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
    
    public static class RoadSlot extends Slot {
    	
    	private boolean road, any;

        public RoadSlot(IInventory inventory, int index, int xPosition, int yPosition, boolean road, boolean any){
            super(inventory, index, xPosition, yPosition);
            this.road = road;
            this.any = any;
        }

        @Override
        public boolean isItemValid(ItemStack stack){
        	if(stack.getItem() instanceof ItemBlock == false) return false;
        	if(!any && (road || this.getSlotIndex() == 0)){
        		ItemBlock iblock = (ItemBlock)stack.getItem();
        		return isFVTMRoad(iblock.getBlock()) || isValidFlenix(iblock.getBlock().getRegistryName());
        	}
        	else return true;
        	//if(stack.getItem() instanceof ItemBlock == false) return false;
            //Block block = ((ItemBlock)stack.getItem()).getBlock();
            //return block.isFullBlock(block.getDefaultState());
        }

    }

	public NonNullList<ItemStack> getStacks(){
		return stacks;
	}

}
