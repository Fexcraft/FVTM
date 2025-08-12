package net.fexcraft.mod.fvtm.ui.road;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.ui.UIKeys;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.inv.UniInventory;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.ContainerInterface;

import static net.fexcraft.mod.fvtm.sys.road.UniRoadTool.TAG_KEY;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RoadToolCon extends ContainerInterface {

	public static final String[] fills = new String[]{ "RoadFill", "BottomFill", "SideLeftFill", "SideRightFill", "TopFill", "LinesFill", "SlabFill" };
	protected StackWrapper stack;
	protected boolean custom_road;
	protected boolean custom_slab;
	protected boolean custom_top;
	protected boolean custom_lines;
	//
	protected int rt_width;
	protected boolean bot_on;
	protected boolean top_on;
	protected boolean lin_on;
	protected int rheight;
	protected int lheight;

	public RoadToolCon(JsonMap map, UniEntity player, V3I pos){
		super(map, player, pos);
		stack = player.entity.getHeldItem(true);
		if(!stack.directTag().has(TAG_KEY)){
			stack.updateTag(tag -> tag.set(TAG_KEY, TagCW.create()));
		}
		TagCW com = stack.directTag().getCompound(TAG_KEY);
		custom_road = com.has("CustomRoadFill");
		custom_slab = com.has("CustomSlabFill");
		custom_top = com.has("CustomTopFill");
		custom_lines = com.has("CustomLinesFill");
		rt_width  = com.getInteger("Width");
		bot_on = com.getBoolean("Ground");
		top_on = com.getBoolean("Top");
		lin_on = com.getBoolean("Lines");
		rheight  = com.getInteger("RHeight");
		lheight  = com.getInteger("LHeight");
		//
		inventory = UniInventory.create(fills.length).stacksize(1).name("Road Fill Inventory");
		for(int i = 0; i < fills.length; i++){
			if(com.has(fills[i])){
				inventory.set(i, com.getCompound(fills[i]));
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
			case "add_width":{
				stack.updateTag(tag -> {
					if(++rt_width > 64) rt_width = 64;
					tag.getCompound(TAG_KEY).set("Width", rt_width);
				});
				break;
			}
			case "sub_width":{
				stack.updateTag(tag -> {
					if(--rt_width < 1) rt_width = 1;
					tag.getCompound(TAG_KEY).set("Width", rt_width);
				});
				break;
			}
			case "ground":{
				stack.updateTag(tag -> {
					tag.getCompound(TAG_KEY).set("Ground", com.getBoolean("ground"));
				});
				break;
			}
			case "add_left":{
				stack.updateTag(tag -> {
					if(++lheight > 64) lheight = 64;
					tag.getCompound(TAG_KEY).set("LHeight", lheight);
				});
				break;
			}
			case "sub_left":{
				stack.updateTag(tag -> {
					if(--lheight < 0) lheight = 0;
					tag.getCompound(TAG_KEY).set("LHeight", lheight);
				});
				break;
			}
			case "add_right":{
				stack.updateTag(tag -> {
					if(++rheight > 64) rheight = 64;
					tag.getCompound(TAG_KEY).set("RHeight", rheight);
				});
				break;
			}
			case "sub_right":{
				stack.updateTag(tag -> {
					if(--rheight < 0) rheight = 0;
					tag.getCompound(TAG_KEY).set("RHeight", rheight);
				});
				break;
			}
			case "top":{
				stack.updateTag(tag -> {
					tag.getCompound(TAG_KEY).set("Top", com.getBoolean("top"));
				});
				break;
			}
			case "lines":{
				stack.updateTag(tag -> {
					tag.getCompound(TAG_KEY).set("Lines", com.getBoolean("lines"));
				});
				break;
			}
			case "custom":{
				player.entity.openUI(UIKeys.ROAD_TOOL_CUSTOM, new V3I(com.getInteger("layer"), 0, 0));
				break;
			}
			case "remove":{
				stack.updateTag(tag -> tag.getCompound(TAG_KEY).rem("Custom" + fills[com.getInteger("layer")]));
				TagCW rtg = stack.directTag().getCompound(TAG_KEY);
				custom_road = rtg.has("CustomRoadFill");
				custom_slab = rtg.has("CustomSlabFill");
				custom_top = rtg.has("CustomTopFill");
				custom_lines = rtg.has("CustomLinesFill");
				if(!client) SEND_TO_CLIENT.accept(rtg, player);
				break;
			}
		}
	}

	@Override
	public void onClosed(){
		super.onClosed();
		if(player.entity.isOnClient()) return;
		stack.updateTag(ut -> {
			TagCW com = ut.getCompound(TAG_KEY);
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
