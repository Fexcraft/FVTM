package net.fexcraft.mod.fvtm.data.inv;

import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.item.ContainerItem;
import net.fexcraft.mod.fvtm.item.PartItem;
import net.fexcraft.mod.fvtm.item.VehicleItem;
import net.fexcraft.mod.fvtm.util.handler.ContentFilter;
import net.minecraft.item.ItemStack;

public class ItemStackHandler extends net.minecraftforge.items.ItemStackHandler {
	
	protected InvHandlerItem handler;
	private ContentFilter filter;

    public ItemStackHandler(InvHandlerItem invhandler){
		filter = (handler = invhandler).getFilter();
	}

    private boolean isValid(ItemStack stack){
        return filter == null ? true : filter.isValid(stack);
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
    
    //

	@Override
    public ItemStack insertItem(int slot, ItemStack stack, boolean simulate){
        if(stack.getItem() instanceof VehicleItem || stack.getItem() instanceof ContainerItem || isContainerPart(stack) || !isValid(stack)){
            return stack;
        }
        return super.insertItem(slot, stack, simulate);
    }
	
    @Override
    public void setStackInSlot(int slot, ItemStack stack){
        validateIndex(slot);
        this.stacks.set(slot, stack);
        onContentsChanged(slot);
    }

	private void validateIndex(int slot){
		if(slot < 0 || slot > stacks.size()) validateSlotIndex(slot);
	}

}
