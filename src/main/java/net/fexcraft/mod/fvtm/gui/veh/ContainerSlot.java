package net.fexcraft.mod.fvtm.gui.veh;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerSlot extends Slot {

    public ContainerSlot(IInventory inv, int index, int xpos, int ypos){
        super(inv, index, xpos, ypos);
    }

    @Override
    public boolean isItemValid(ItemStack stack){
        return ((ContainerInventory)inventory).isItemValidForSlot(getSlotIndex(), stack);
    }

}
