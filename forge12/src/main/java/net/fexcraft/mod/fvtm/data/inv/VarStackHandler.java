package net.fexcraft.mod.fvtm.data.inv;

import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemHandlerHelper;

import static net.fexcraft.mod.fvtm.FvtmResources.wrapStack;

public class VarStackHandler implements IItemHandler {

	protected InvHandlerVar handler;

	public VarStackHandler(InvHandlerVar invhandler){
		handler = invhandler;
	}

	private boolean isValid(ItemStack stack){
		if(stack.getItem() instanceof BlockItem == false) return false;
		Block block = ((BlockItem)stack.getItem()).getContent();
		return block.hasFunction("fvtm:barrel");
	}

	@Override
	public int getSlots(){
		return handler.stacks.size();
	}

	@Override
	public ItemStack getStackInSlot(int idx){
		if(idx < 0 || idx >= handler.items()) return ItemStack.EMPTY;
		return handler.stacks.get(idx).local();
	}

	@Override
	public ItemStack insertItem(int idx, ItemStack stack, boolean simulate){
		if(idx < 0 || idx >= handler.items()) return ItemStack.EMPTY;
		if(!isValid(stack)) return stack;
		ItemStack local = handler.stacks.get(idx).local();
		int max = Math.min(getSlotLimit(idx), stack.getMaxStackSize());
		if(!local.isEmpty()){
			if(!ItemHandlerHelper.canItemStacksStack(stack, local)) return stack;
			max -= local.getCount();
		}
		if(max <= 0) return stack;
		boolean full = stack.getCount() > max;
		if(!simulate){
			if(local.isEmpty()){
				handler.stacks.set(idx, wrapStack(full ? ItemHandlerHelper.copyStackWithSize(stack, max) : stack));
			}
			else{
				local.grow(full ? max : stack.getCount());
			}
		}
		return full ? ItemHandlerHelper.copyStackWithSize(stack, stack.getCount() - max) : ItemStack.EMPTY;
	}

	@Override
	public ItemStack extractItem(int idx, int am, boolean simulate){
		if(idx < 0 || idx >= handler.items()) return ItemStack.EMPTY;
		if(am == 0) return ItemStack.EMPTY;
		ItemStack local = handler.stacks.get(idx).local();
		if(local.isEmpty()) return ItemStack.EMPTY;
		int rem = Math.min(am, local.getMaxStackSize());
		if(local.getCount() <= rem){
			if(!simulate) handler.stacks.remove(idx);
			return local;
		}
		else{
			if(!simulate) handler.stacks.set(idx, wrapStack(ItemHandlerHelper.copyStackWithSize(local, local.getCount() - rem)));
			return ItemHandlerHelper.copyStackWithSize(local, rem);
		}
	}

	@Override
	public int getSlotLimit(int idx){
		return 1;
	}

}
