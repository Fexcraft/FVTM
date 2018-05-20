package net.fexcraft.mod.fvtm.gui;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerSlot extends Slot {

    public ContainerSlot(IInventory inventory, int index, int xPosition, int yPosition){
        super(inventory, index, xPosition, yPosition);
    }

    @Override
    public boolean isItemValid(ItemStack stack){
        return ((ContainerInventory) inventory).isItemValidForSlot(getSlotIndex(), stack);
    }

}
