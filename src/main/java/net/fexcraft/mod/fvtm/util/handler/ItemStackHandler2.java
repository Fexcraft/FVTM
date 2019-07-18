package net.fexcraft.mod.fvtm.util.handler;

import javax.annotation.Nonnull;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemStackHandler2 extends net.minecraftforge.items.ItemStackHandler {

    public ItemStackHandler2(NonNullList<ItemStack> inventory){
        super(inventory);
    }

    @Override
    public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate){
        return stack;
    }
    
    public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate, boolean sys){
        return sys ? super.insertItem(slot, stack, simulate) : insertItem(slot, stack, simulate);
    }

}
