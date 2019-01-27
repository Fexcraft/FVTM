package net.fexcraft.mod.fvtm.gui.veh;

import net.fexcraft.mod.fvtm.api.Container;
import net.fexcraft.mod.fvtm.api.Container.ContainerItem;
import net.fexcraft.mod.fvtm.impl.caps.ContainerHolderUtil.ContainerSlot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class ContainerInventory implements IInventory {


    private NonNullList<ItemStack> coninv = NonNullList.<ItemStack>withSize(12, ItemStack.EMPTY);
    private ContainerSlot conslot;

    public ContainerInventory(ContainerSlot slot){
        this.conslot = slot;
        for(int i = 0; i < 12; i++){
        	if(i < slot.data.length){
        		coninv.set(i, slot.data[i] == null ? ItemStack.EMPTY : slot.data[i].getContainer().getItemStack(slot.data[i]));
        	}
        	else{
        		coninv.set(i, new ItemStack(Blocks.BARRIER));
        	}
        }
    }
    
    public ContainerSlot getConSlot(){ return conslot; }

    @Override
    public String getName(){
        return "Vehicle-Inventory Container GUI";
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
        return 12;
    }

    @Override
    public boolean isEmpty(){
    	for(ItemStack stack : coninv){
    		if(!stack.isEmpty() && !(stack.getItem() instanceof ItemBlock)) return false;
    	} return true;
    }

    @Override
    public ItemStack getStackInSlot(int index){
        return coninv.get(index);
    }

    @Override
    public ItemStack decrStackSize(int index, int count){
    	if(!getStackInSlot(index).isEmpty()){
    		ItemStack stack = ItemStackHelper.getAndSplit(coninv, index, count);
    		this.sync(); return stack;
    	} return ItemStack.EMPTY;
    }

    @Override
    public ItemStack removeStackFromSlot(int index){
    	ItemStack stack = coninv.set(index, ItemStack.EMPTY);
    	this.sync(); return stack;
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack){
        coninv.set(index, stack); this.sync();
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
        return !player.isDead;
    }

    @Override
    public void openInventory(EntityPlayer player){
        // Apparently this doesn't get called, let's use the constructor instead;
    }

    @Override
    public void closeInventory(EntityPlayer player){
    	//
    }
    
    private void sync(){
    	for(int i = 0; i < conslot.data.length; i++){
    		if(i >= coninv.size()) break;
    		if(coninv.get(i).getItem() instanceof ContainerItem){
    			conslot.data[i] = ((ContainerItem)coninv.get(i).getItem()).getContainer(coninv.get(i));
    		} else { conslot.data[i] = null; }
    	} conslot.impl.sync(false);
    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack){
    	//Print.debug(stack.getTagCompound());
    	if(index >= conslot.data.length) return false;
        if(stack.getItem() instanceof Container.ContainerItem){
            return ((ContainerItem)stack.getItem()).getContainer(stack).getContainer().getType() == conslot.curr;
        } return false;
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
        //coninv.clear();
    }

}
