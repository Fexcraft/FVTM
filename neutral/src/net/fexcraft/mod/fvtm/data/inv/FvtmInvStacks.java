package net.fexcraft.mod.fvtm.data.inv;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.uni.inv.UniInventory;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.tag.TagLW;
import net.fexcraft.mod.uni.world.EntityW;

import java.util.ArrayList;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class FvtmInvStacks extends FvtmInv {

	protected ArrayList<StackEntry> stacks = new ArrayList<>();
	public int capacity;

	public FvtmInvStacks(){
		super(InvType.STACK);
	}

	@Override
	public FvtmInvStacks init(JsonMap map){
		init0(map);
		capacity = map.getInteger("capacity", 27);
		return this;
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
	public void clearAt(EntityW entity){
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
	public FvtmInvStacks copy(){
		FvtmInvStacks inv = new FvtmInvStacks();
		copy(inv);
		inv.capacity = capacity;
		return inv;
	}

}
