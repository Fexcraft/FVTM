package net.fexcraft.mod.fvtm.ui.road;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.item.UniInventory;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.ContainerInterface;
import net.fexcraft.mod.uni.ui.UniCon;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public abstract class RoadToolCustomCon extends ContainerInterface {

	protected int[] size = new int[]{ 1, 0, 0, 0, 0, 0 };
	protected StackWrapper stack;
	protected String tagname;
	protected int offset;
	protected int scroll;

	public RoadToolCustomCon(JsonMap map, UniEntity player, V3I pos){
		super(map, player, pos);
		stack = player.entity.getHeldItem(true);
		stack.createTagIfMissing();
		if(!stack.getTag().has("RoadLayers")){
			stack.getTag().set("RoadLayers", size);
		}
		else size = stack.getTag().getIntArray("RoadLayers");
		tagname = "Custom" + RoadToolCon.fills[pos.x];
		offset = size[0] > 9 ? 9 * 9 : (size[0] * 9);
		inventory = UniInventory.create(size[0] >= 9 ? 9 : size[0]);
	}

	@Override
	public void init(){
		int is = size[0] > 9 ? 9 : size[0];
		for(int i = 0; i < is; i++){
			((UniCon)root).addSlot("fvtm:roadfill", player.entity.getWorld(), inventory, i, 88 - offset + 1 + i * 18, 8, true, pos.x > 0);
		}
		fillStacks();
	}

	@Override
	public Object get(String key, Object... objs){
		//
		return null;
	}

	@Override
	public void packet(TagCW packet, boolean client){
		if(!packet.has("cargo")) return;
		switch(packet.getString("cargo")){
			case "scroll":{
				saveStacks();
				scroll += packet.getInteger("by");
				if(scroll < 0) scroll = 0;
				if(scroll + 9 >= size[0]) scroll = size[0] - 9;
				fillStacks();
				break;
			}
		}
	}

	protected void fillStacks(){
		if(!stack.getTag().has(tagname)) return;
		TagCW compound = stack.getTag().getCompound(tagname);
		for(int i = 0; i < 9; i++){
			int j = i + scroll;
			if(j >= size[0]) break;
			if(!compound.has("Block" + j)){
				inventory.set(i, StackWrapper.EMPTY);
				continue;
			}
			inventory.set(i, StackWrapper.wrap(compound.getCompound("Block" + j)));
		}
	}

	protected void saveStacks(){
		try{
			TagCW com = stack.getTag().has(tagname) ? stack.getTag().getCompound(tagname) : TagCW.create();
			com.set("Size", size[0]);
			int is = size[0] > 9 ? 9 : size[0];
			for(int i = 0; i < is; i++){
				int j = i + scroll;
				if(inventory.empty(i)){
					com.rem("Block" + j);
				}
				else{
					StackWrapper stack = inventory.get(i);
					TagCW tag = TagCW.create();
					stack.save(tag);
					com.set("Block" + j, tag);
				}
			}
			stack.getTag().set(tagname, com);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void onClosed(){
		super.onClosed();
		saveStacks();
	}

}
