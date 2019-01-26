package net.fexcraft.mod.fvtm.gui.veh;

import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.api.Container;
import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.api.Container.ContainerItem;
import net.fexcraft.mod.fvtm.impl.caps.ContainerHolderUtil.ContainerSlot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
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
        return 12;
    }

    @Override
    public boolean isEmpty(){
    	for(ItemStack stack : coninv){
    		if(!stack.isEmpty()) return false;
    	} return true;
    }

    @Override
    public ItemStack getStackInSlot(int index){
        return coninv.get(index);
    }

    @Override
    public ItemStack decrStackSize(int index, int count){
        return !getStackInSlot(index).isEmpty() ? ItemStackHelper.getAndSplit(coninv, index, count) : ItemStack.EMPTY;
    }

    @Override
    public ItemStack removeStackFromSlot(int index){
        return coninv.set(index, ItemStack.EMPTY);
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack){
        coninv.set(index, stack);
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
        return !player.isDead;
    }

    @Override
    public void openInventory(EntityPlayer player){
        // Apparently this doesn't get called, let's use the constructor instead;
    }

    @Override
    public void closeInventory(EntityPlayer player){
    	for(int i = 0; i < conslot.data.length; i++){
    		if(i >= coninv.size()) break;
    		if(coninv.get(i).isEmpty() || coninv.get(i).getItem() instanceof ContainerItem) continue;
    		conslot.data[i] = ((ContainerItem)coninv.get(i).getItem()).getContainer(coninv.get(i));
    	}
        conslot.impl.sync(true);
    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack){
    	Print.debug(stack.getTagCompound());
        if(stack.getItem() instanceof Container.ContainerItem){
            ContainerData data = get(stack); return data.getContainer().getType() == conslot.curr && index < conslot.data.length && index > -1;
        } Print.debug("nopass"); return false;
    }

    private ContainerData get(ItemStack stack){
        return ((ContainerItem)stack.getItem()).getContainer(stack);
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
