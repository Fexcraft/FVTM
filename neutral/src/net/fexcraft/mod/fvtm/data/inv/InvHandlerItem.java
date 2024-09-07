package net.fexcraft.mod.fvtm.data.inv;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.tag.TagLW;
import net.fexcraft.mod.uni.world.EntityW;
import net.fexcraft.mod.uni.world.WorldW;

import java.util.ArrayList;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public abstract class InvHandlerItem extends InvHandler {

	public static Class<? extends InvHandlerItem> IMPL = InvHandlerItem.class;
	protected Object stackhandler;
	protected ArrayList<StackEntry> stacks = new ArrayList<>();
	protected ContentFilter filter;

	public InvHandlerItem(String filterid, int cap, int min){
		super(InvType.ITEM);
		if(filterid != null) filter = ContentFilter.FILTER_REGISTRY.get(filterid);
		capacity = cap;
	}

	@Override
	public TagCW save(TagCW compound, String ctag){
		TagLW list = TagLW.create();
		for(StackEntry entry : stacks){
			TagCW com = TagCW.create();
			entry.stack.save(com);
			com.set("fvtm:stack_amount", entry.amount);
			list.add(com);
		}
		if(list.size() > 0) compound.set(ctag == null ? "Items" : ctag, list);
		return compound;
	}

	@Override
	public void load(TagCW compound, String ctag){
		stacks.clear();
		TagLW list = compound.getList(ctag == null ? "Items" : ctag);
		if(list.empty()) return;
		for(TagCW com : list){
			stacks.add(new StackEntry(com));
		}
	}

	@Override
	public String getContentDesc(){
		return getStacks().stream().filter(is -> is != null && !is.stack.empty()).count() + "";
	}

	@Override
	public void dropAllAt(EntityW entity){
		for(StackEntry entry : stacks){
			int am = entry.amount;
			while(am - entry.stack.maxsize() > 0){
				entity.drop(entry.stack, 0.5f);
				am -= entry.stack.maxsize();
			}
		}
		stacks.clear();
	}

	@Override
	public void dropAllAt(WorldW world, V3I pos){
		for(StackEntry entry : stacks){
			int am = entry.amount;
			while(am - entry.stack.maxsize() > 0){
				world.drop(entry.stack, new V3D(pos).add(0.5, 2.5, 0.5));
				am -= entry.stack.maxsize();
			}
		}
		stacks.clear();
	}

	@Override
	public String getSavePrefix(){
		return "inv-";
	}

	@Override
	public ArrayList<StackEntry> getStacks(){
		return stacks;
	}

	@Override
	public <ISH> ISH getStackHandler(){
		return (ISH)stackhandler;
	}

	@Override
	public Object getCapability(){
		return stackhandler;
	}

	public StackEntry getEntryFor(StackWrapper stack){
		for(StackEntry entry : stacks){
			if(canStacksStack(stack, entry.stack)) return entry;
		}
		return null;
	}

	public abstract boolean canStacksStack(StackWrapper other, StackWrapper stack);

	public boolean full(){
		int am = 0;
		for(StackEntry entry : stacks) am += entry.stacksize();
		return am >= capacity;
	}

}
