package net.fexcraft.mod.fvtm.data.inv;

import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.item.ContainerItem;
import net.fexcraft.mod.fvtm.item.PartItem;
import net.fexcraft.mod.fvtm.item.VehicleItem;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.items.IItemHandler;

public class ItemStackHandler implements IItemHandler {

	protected InvHandlerItem handler;
	protected int min;

	public ItemStackHandler(InvHandlerItem invhandler, int min){
		handler = invhandler;
		this.min = min;
	}

	private boolean isValid(ItemStack stack){
		return handler.filter == null ? true : handler.filter.isValid(stack);
	}

	public static boolean isContainerPart(ItemStack stack){
		if(stack.getItem() instanceof PartItem){
			PartData data = ((PartItem)stack.getItem()).getDataFromTag(stack.getTagCompound());
			if(data.hasFunction("fvtm:inventory") || data.hasFunction("fvtm:container")){
				return true;
			}
		}
		return false;
	}

	//

	@Override
	public int getSlots(){
		return handler.stacks.size() < min ? min : handler.stacks.size();
	}

	@Override
	public ItemStack getStackInSlot(int idx){
		if(idx < 0 || idx >= handler.stacks.size()) return ItemStack.EMPTY;
		StackEntry entry = handler.stacks.get(idx);
		ItemStack stack = entry.stack.copy().local();
		stack.setCount(entry.overmax() ? entry.amount : entry.max());
		return stack;
	}

	@Override
	public ItemStack insertItem(int unused, ItemStack stack, boolean simulate){
		if(stack.isEmpty()) return ItemStack.EMPTY;
		if(stack.getItem() instanceof VehicleItem || stack.getItem() instanceof ContainerItem || isContainerPart(stack) || !isValid(stack)){
			return stack;
		}
		StackEntry entry = handler.getEntryFor(FvtmResources.wrapStack(stack));
		if(entry == null){
			if(handler.full()) return stack;
			if(simulate) return ItemStack.EMPTY;
			entry = new StackEntry(TagCW.wrap(stack.writeToNBT(new NBTTagCompound())));
			entry.amount = stack.getCount();
			entry.stack.count(1);
			handler.stacks.add(entry);
			return ItemStack.EMPTY;
		}
		int tfs = entry.tillfullstack();
		if(tfs >= stack.getCount()){
			if(!simulate) entry.amount += stack.getCount();
			return ItemStack.EMPTY;
		}
		else{
			if(!simulate) entry.amount += tfs;
			if(tfs > 0){
				stack = stack.copy();
				stack.shrink(tfs);
			}
			if(handler.full()){
				return stack;
			}
			if(!simulate && stack.getCount() > 0) entry.amount += stack.getCount();
			return ItemStack.EMPTY;
		}
	}

	@Override
	public ItemStack extractItem(int idx, int amount, boolean simulate){
		if(amount == 0) return ItemStack.EMPTY;
		if(idx < 0 || idx >= handler.stacks.size()) return ItemStack.EMPTY;
		StackEntry entry = handler.stacks.get(idx);
		int exam = entry.max() < amount ? entry.max() : amount;
		ItemStack stack = entry.genstack(exam).local();
		if(!simulate){
			entry.amount -= exam;
			if(entry.amount <= 0){
				entry.amount = 0;
				handler.stacks.remove(entry);
			}
		}
		return stack;
	}

	@Override
	public int getSlotLimit(int idx){
		if(idx < 0 || idx >= handler.stacks.size()) return 0;
		return handler.stacks.get(idx).max();
	}

}
