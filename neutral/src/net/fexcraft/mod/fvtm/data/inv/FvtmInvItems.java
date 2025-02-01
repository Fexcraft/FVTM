package net.fexcraft.mod.fvtm.data.inv;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.inv.UniInventory;
import net.fexcraft.mod.uni.inv.UniStack;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.EntityW;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class FvtmInvItems extends FvtmInv {

	public UniInventory items;
	public int rows;
	public int cols;

	public FvtmInvItems(){
		super(InvType.ITEM);
	}

	@Override
	public FvtmInvItems init(JsonMap map){
		rows = map.getInteger("rows", 1);
		cols = map.getInteger("cols", 1);
		if(rows < 1) rows = 1;
		if(rows > 7) rows = 7;
		if(cols < 1) cols = 1;
		if(cols > 9) cols = 9;
		items = UniInventory.create(rows * cols);
		if(map.has("filter")){
			//TODO
		}
		init0(map);
		return this;
	}

	@Override
	public TagCW save(TagCW compound, String ctag){
		TagCW stacks = TagCW.create();
		StackWrapper stack;
		int idx;
		for(int r = 0; r < rows; r++){
			for(int c = 0; c < cols; c++){
				stack = items.get(idx = r * cols + c);
				if(stack.empty()) continue;
				TagCW com = TagCW.create();
				stack.save(com);
				stacks.set("s" + idx, com);
			}
		}
		if(stacks.size() > 0) compound.set(ctag == null ? "Items" : ctag, stacks);
		return compound;
	}

	@Override
	public void load(TagCW compound, String ctag){
		items.clear();
		TagCW stacks = compound.getCompound(ctag == null ? "Items" : ctag);
		if(stacks.empty()) return;
		StackWrapper stack;
		int idx;
		for(int r = 0; r < rows; r++){
			for(int c = 0; c < cols; c++){
				idx = r * cols + c;
				if(!stacks.has("s" + idx)) continue;
				stack = UniStack.createStack(stacks.getCompound("s" + idx));
				if(stack.empty()) continue;
				items.set(idx, stack);
			}
		}
	}

	@Override
	public void clearAt(EntityW entity){
		StackWrapper stack;
		for(int i = 0; i < items.size(); i++){
			if((stack = items.get(i)).empty()) continue;
			entity.drop(stack, 0.5f);
		}
		items.clear();
	}

	@Override
	public FvtmInvItems copy(){
		FvtmInvItems inv = new FvtmInvItems();
		copy(inv);
		inv.rows = rows;
		inv.cols = cols;
		inv.items = UniInventory.create(rows * cols);
		return inv;
	}

}
