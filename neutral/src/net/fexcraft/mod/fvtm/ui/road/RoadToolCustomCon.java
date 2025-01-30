package net.fexcraft.mod.fvtm.ui.road;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.inv.UniInventory;
import net.fexcraft.mod.uni.inv.UniStack;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.ContainerInterface;
import net.fexcraft.mod.uni.ui.UniCon;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RoadToolCustomCon extends ContainerInterface {

	protected int[] size = new int[]{ 1, 0, 0, 0, 0, 0 };
	protected StackWrapper stack;
	protected String tagname;
	protected int offset;
	protected int scroll;

	public RoadToolCustomCon(JsonMap map, UniEntity player, V3I pos){
		super(map, player, pos);
		stack = player.entity.getHeldItem(true);
		if(!stack.directTag().has("RoadLayers")){
			stack.updateTag(tag -> tag.set("RoadLayers", size));
		}
		else size = stack.directTag().getIntArray("RoadLayers");
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
		if(!stack.directTag().has(tagname)) return;
		TagCW compound = stack.directTag().getCompound(tagname);
		for(int i = 0; i < 9; i++){
			int j = i + scroll;
			if(j >= size[0]) break;
			if(!compound.has("Block" + j)){
				inventory.set(i, StackWrapper.EMPTY);
				continue;
			}
			inventory.set(i, UniStack.createStack(compound.getCompound("Block" + j)));
		}
	}

	protected void saveStacks(){
		try{
			TagCW com = stack.directTag().has(tagname) ? stack.directTag().getCompound(tagname).copy() : TagCW.create();
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
			stack.updateTag(tag -> tag.set(tagname, com));
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
