package net.fexcraft.mod.fvtm.util;

import javax.annotation.Nonnull;

import net.fexcraft.mod.addons.gep.attributes.ContainerAttribute;
import net.fexcraft.mod.addons.gep.attributes.InventoryAttribute;
import net.fexcraft.mod.fvtm.api.Container;
import net.fexcraft.mod.fvtm.api.Container.ContainerItem;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.api.Part.PartItem;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemStackHandler extends net.minecraftforge.items.ItemStackHandler {

    private Container container;

    public ItemStackHandler(NonNullList<ItemStack> inventory){
        super(inventory);
        this.container = null;
    }

    public ItemStackHandler(Container container, NonNullList<ItemStack> inventory){
        super(inventory);
        this.container = container;
    }

    @Override
    @Nonnull
    public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate){
        if(stack.getItem() instanceof VehicleItem || stack.getItem() instanceof ContainerItem || isContainerPart(stack) || !isValid(stack)){
            return stack;
        }
        return super.insertItem(slot, stack, simulate);
    }

    private boolean isValid(ItemStack stack){
        return container == null ? true : container.isItemValid(stack);
    }

    public static boolean isContainerPart(ItemStack stack){
        if(stack.getItem() instanceof PartItem){
            PartData data = ((PartItem) stack.getItem()).getPart(stack);
            if(data.getPart().getAttribute(InventoryAttribute.class) != null || data.getPart().getAttribute(ContainerAttribute.class) != null){
                return true;
            }
        }
        return false;
    }

}
