package net.fexcraft.mod.fvtm.util.handler;

import javax.annotation.Nonnull;

import net.fexcraft.mod.fvtm.data.container.ContainerData;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.item.ContainerItem;
import net.fexcraft.mod.fvtm.item.PartItem;
import net.fexcraft.mod.fvtm.item.VehicleItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemStackHandler extends net.minecraftforge.items.ItemStackHandler {

    private ContainerData container;

    public ItemStackHandler(NonNullList<ItemStack> inventory){
        super(inventory); this.container = null;
    }

    public ItemStackHandler(ContainerData container, NonNullList<ItemStack> inventory){
        super(inventory); this.container = container;
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
            PartData data = ((PartItem)stack.getItem()).getData(stack);
            if(data.hasFunction("fvtm:inventory") || data.hasFunction("fvtm:container")){
                return true;
            }
        }
        return false;
    }

}
