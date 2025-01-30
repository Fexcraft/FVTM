package net.fexcraft.mod.fvtm.ui.road;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.ui.UIKeys;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.inv.UniInventory;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.ContainerInterface;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RoadToolCon extends ContainerInterface {

	public static final String[] fills = new String[]{ "RoadFill", "BottomFill", "SideLeftFill", "SideRightFill", "TopFill", "LinesFill" };
	protected StackWrapper stack;
	protected boolean custom_road;
	protected boolean custom_top;
	protected boolean custom_lines;

	public RoadToolCon(JsonMap map, UniEntity player, V3I pos){
		super(map, player, pos);
		stack = player.entity.getHeldItem(true);
		custom_road = stack.directTag().has("CustomRoadFill");
		custom_top = stack.directTag().has("CustomTopFill");
		custom_lines = stack.directTag().has("CustomLinesFill");
		inventory = UniInventory.create(6).stacksize(1).name("Road Fill Inventory");
		for(int i = 0; i < fills.length; i++){
			if(stack.directTag().has(fills[i])){
				inventory.set(i, stack.directTag().getCompound(fills[i]));
			}
		}
	}

	@Override
	public Object get(String key, Object... objs){
		//
		return null;
	}

	@Override
	public void packet(TagCW com, boolean client){
		switch(com.getString("cargo")){
			case "save":{
				stack.updateTag(tag -> tag.set("RoadLayers", com.getIntArray("sizes")));
				break;
			}
			case "custom":{
				player.entity.openUI(UIKeys.ROAD_TOOL_CUSTOM, new V3I(com.getInteger("layer"), 0, 0));
				break;
			}
			case "remove":{
				stack.updateTag(tag -> tag.rem("Custom" + fills[com.getInteger("layer")]));
				custom_road = stack.directTag().has("CustomRoadFill");
				custom_top = stack.directTag().has("CustomTopFill");
				custom_lines = stack.directTag().has("CustomLinesFill");
				if(!client) SEND_TO_CLIENT.accept(com, player);
				break;
			}
		}
	}

	@Override
	public void onClosed(){
		super.onClosed();
		stack.updateTag(com -> {
			for(int i = 0; i < fills.length; i++){
				if(!inventory.empty(i)){
					TagCW tag = TagCW.create();
					inventory.get(i).save(tag);
					com.set(fills[i], tag);
				}
				else com.rem(fills[i]);
			}
		});
	}

}
