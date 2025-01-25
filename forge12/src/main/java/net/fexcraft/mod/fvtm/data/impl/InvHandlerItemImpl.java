package net.fexcraft.mod.fvtm.data.impl;

import net.fexcraft.mod.fvtm.data.inv.InvHandlerItem;
import net.fexcraft.mod.fvtm.data.inv.ItemStackHandler;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.minecraftforge.items.ItemHandlerHelper;

public class InvHandlerItemImpl extends InvHandlerItem {

	public InvHandlerItemImpl(String filter, int cap, int min){
		super(filter, cap, min);
		stackhandler = new ItemStackHandler(this, min);
	}

	@Override
	public boolean canStacksStack(StackWrapper other, StackWrapper stack){
		return ItemHandlerHelper.canItemStacksStack(other.local(), stack.local());
	}

}
