package net.fexcraft.mod.fvtm.ui.road;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.InventoryInterface;
import net.fexcraft.mod.uni.world.EntityW;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public abstract class RoadToolCustomCon extends InventoryInterface {

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

	protected abstract void fillStacks();

	protected void saveStacks(){
		try{
			TagCW com = stack.getTag().has(tagname) ? stack.getTag().getCompound(tagname) : TagCW.create();
			com.set("Size", size[0]);
			int is = size[0] > 9 ? 9 : size[0];
			for(int i = 0; i < is; i++){
				int j = i + scroll;
				if(isInventoryEmpty(i)){
					com.rem("Block" + j);
				}
				else{
					StackWrapper stack = getInventoryContent(i);
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
		saveStacks();
	}

}
