package net.fexcraft.mod.fvtm.gui.vehicle;

import net.fexcraft.mod.fvtm.data.inv.InvHandler;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.util.function.InventoryFunction;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

/** "Temporary Inventory Function Inventory "*/
public class TIFI implements IInventory {

	private InventoryFunction func;
	private InvHandler inv;
    private PartData part;

    public TIFI(PartData data, InventoryFunction partfunc){
        part = data;
        func = partfunc;
        inv = func.inventory();
    }

    @Override
    public String getName(){
        return part.getType().getRegistryName().toString();
    }

    @Override
    public boolean hasCustomName(){
        return true;
    }

    @Override
    public ITextComponent getDisplayName(){
        return new TextComponentString(part.getType().getName());
    }

    @Override
    public int getSizeInventory(){
        return inv.getStacks().size();
    }

    @Override
    public boolean isEmpty(){
        return inv.getStacks().isEmpty();
    }

    @Override
    public ItemStack getStackInSlot(int index){
        return inv.getStacks().get(index);
    }

    @Override
    public ItemStack decrStackSize(int index, int count){
        return !getStackInSlot(index).isEmpty() ? ItemStackHelper.getAndSplit(inv.getStacks(), index, count) : ItemStack.EMPTY;
    }

    @Override
    public ItemStack removeStackFromSlot(int index){
        return inv.getStacks().set(index, ItemStack.EMPTY);
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack){
        inv.getStacks().set(index, stack);
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
        return func.isItemValid(stack);
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
        inv.getStacks().clear();
    }

    public PartData getData(){
        return this.part;
    }

}
