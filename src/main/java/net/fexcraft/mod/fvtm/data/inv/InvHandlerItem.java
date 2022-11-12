package net.fexcraft.mod.fvtm.data.inv;

import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.fvtm.util.handler.ContentFilter;
import net.fexcraft.mod.fvtm.util.handler.ItemStackHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;

public class InvHandlerItem extends InvHandler {
	
	protected ItemStackHandler handler;
	protected NonNullList<ItemStack> stacks;
	private ContentFilter filter;

	public InvHandlerItem(InvType type, String filter, int cap){
		super(type);
		if(filter != null) this.filter = ContentFilter.FILTER_REGISTRY.get(filter);
		stacks = NonNullList.withSize(capacity = cap, ItemStack.EMPTY);
	}

	@Override
	public ContentFilter getFilter(){
		return null;
	}

	@Override
	public NBTTagCompound save(NBTTagCompound compound, String ctag){
        compound = DataUtil.saveAllItems(compound, stacks, true, ctag);
        return compound;
	}

	@Override
	public void load(NBTTagCompound compound, String ctag){
        DataUtil.loadAllItems(compound, stacks, ctag);
	}

	public NonNullList<ItemStack> getStacks(){
		return stacks;
	}
	
	@Override
	public ItemStackHandler getStackHandler(){
		if(handler == null) handler = new ItemStackHandler(stacks);
		return handler;
	}
	
	@Override
	public String getContentDesc(){
		return getStacks().stream().filter(is -> is != null && !is.isEmpty()).count() + "";
	}
	
}
