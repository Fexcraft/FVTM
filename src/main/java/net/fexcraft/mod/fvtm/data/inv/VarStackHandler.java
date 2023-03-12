package net.fexcraft.mod.fvtm.data.inv;

import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;

public class VarStackHandler extends ItemStackHandler {

	protected InvHandlerVar handler;

    public VarStackHandler(InvHandlerVar invhandler){
		super(invhandler.stacks);
		handler = invhandler;
	}

    private boolean isValid(ItemStack stack){
		if(stack.getItem() instanceof BlockItem == false) return false;
		Block block = ((BlockItem)stack.getItem()).getDataType();
        return block.hasFunction("fvtm:barrel");
    }

	@Override
	public int getSlots(){
		return handler.stacks.size();
	}

	@Override
	public ItemStack getStackInSlot(int idx){
		if(idx < 0 || idx > handler.items()) return ItemStack.EMPTY;
		return handler.stacks.get(idx);
	}

	@Override
	public ItemStack insertItem(int slot, ItemStack stack, boolean simulate){
        if(!isValid(stack)) return stack;
		return super.insertItem(slot, stack, simulate);
	}

	@Override
	public int getSlotLimit(int idx){
		return 1;
	}

}
