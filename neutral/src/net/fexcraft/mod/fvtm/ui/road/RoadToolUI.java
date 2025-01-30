package net.fexcraft.mod.fvtm.ui.road;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.utils.Formatter;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.ContainerInterface;
import net.fexcraft.mod.uni.ui.UIButton;
import net.fexcraft.mod.uni.ui.UserInterface;

import java.util.List;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RoadToolUI extends UserInterface {

	protected RoadToolCon rtc;
	protected int[] size = new int[]{ 1, 0, 0, 0, 0, 0 };

	public RoadToolUI(JsonMap map, ContainerInterface con) throws Exception{
		super(map, con);
		rtc = (RoadToolCon)con;
		if(!rtc.stack.directTag().has("RoadLayers")){
			rtc.stack.updateTag(tag -> tag.set("RoadLayers", size));
		}
		else size = rtc.stack.directTag().getIntArray("RoadLayers");
	}

	@Override
	public void predraw(float ticks, int mx, int my){
		if(rtc.custom_road){
			texts.get("road_fill").value("ui.fvtm.road_tool.road_fill_custom");
			texts.get("road_fill").translate();
		}
		else if(rtc.inventory.empty(0)){
			texts.get("road_fill").value("ui.fvtm.road_tool.no_fill_block");
			texts.get("road_fill").translate();
		}
		else{
			texts.get("road_fill").value(rtc.inventory.get(0).getName());
		}
		texts.get("road_width").value("ui.fvtm.road_tool.road_fill_width");
		texts.get("road_width").translate(size[0]);
		//
		if(rtc.inventory.empty(1)){
			texts.get("ground_fill").value("ui.fvtm.road_tool.no_fill_block");
			texts.get("ground_fill").translate();
		}
		else{
			texts.get("ground_fill").value(rtc.inventory.get(1).getName());
		}
		texts.get("ground_status").value("ui.fvtm.road_tool.ground_fill_" + (size[1] > 0 ? "enabled" : "disabled"));
		texts.get("ground_status").translate();
		//
		if(rtc.inventory.empty(2)){
			texts.get("left_fill").value("ui.fvtm.road_tool.no_fill_block");
			texts.get("left_fill").translate();
		}
		else{
			texts.get("left_fill").value(rtc.inventory.get(2).getName());
		}
		if(size[2] > 0){
			texts.get("left_size").value("ui.fvtm.road_tool.left_fill_size");
			texts.get("left_size").translate(size[2]);
		}
		else{
			texts.get("left_size").value("ui.fvtm.road_tool.left_fill_disabled");
			texts.get("left_size").translate();
		}
		//
		if(rtc.inventory.empty(3)){
			texts.get("right_fill").value("ui.fvtm.road_tool.no_fill_block");
			texts.get("right_fill").translate();
		}
		else{
			texts.get("right_fill").value(rtc.inventory.get(3).getName());
		}
		if(size[3] > 0){
			texts.get("right_size").value("ui.fvtm.road_tool.right_fill_size");
			texts.get("right_size").translate(size[3]);
		}
		else{
			texts.get("right_size").value("ui.fvtm.road_tool.right_fill_disabled");
			texts.get("right_size").translate();
		}
		//
		if(rtc.custom_top){
			texts.get("top_fill").value("ui.fvtm.road_tool.top_fill_custom");
			texts.get("top_fill").translate();
		}
		else if(rtc.inventory.empty(4)){
			texts.get("top_fill").value("ui.fvtm.road_tool.no_fill_block");
			texts.get("top_fill").translate();
		}
		else{
			texts.get("top_fill").value(rtc.inventory.get(4).getName());
		}
		texts.get("top_status").value("ui.fvtm.road_tool.top_fill_" + (size[4] > 0 ? "enabled" : "disabled"));
		texts.get("top_status").translate();
		//
		if(rtc.custom_lines){
			texts.get("lines_fill").value("ui.fvtm.road_tool.lines_fill_custom");
			texts.get("lines_fill").translate();
		}
		else if(rtc.inventory.empty(5)){
			texts.get("lines_fill").value("ui.fvtm.road_tool.no_fill_block");
			texts.get("lines_fill").translate();
		}
		else{
			texts.get("lines_fill").value(rtc.inventory.get(5).getName());
		}
		texts.get("lines_status").value("ui.fvtm.road_tool.lines_fill_" + (size[5] > 0 ? "enabled" : "disabled"));
		texts.get("lines_status").translate();
	}

	@Override
	public boolean onAction(UIButton button, String id, int x, int y, int b){
		switch(id){
			case "add_width":{
				size(0, 1);
				return true;
			}
			case "sub_width":{
				size(0, -1);
				return true;
			}
			case "enable_ground":{
				size(1, 1);
				return true;
			}
			case "disable_ground":{
				size(1, -1);
				return true;
			}
			case "add_left":{
				size(2, 1);
				return true;
			}
			case "sub_left":{
				size(2, -1);
				return true;
			}
			case "add_right":{
				size(3, 1);
				return true;
			}
			case "sub_right":{
				size(3, -1);
				return true;
			}
			case "enable_top":{
				size(4, 1);
				return true;
			}
			case "disable_top":{
				size(4, -1);
				return true;
			}
			case "enable_lines":{
				size(5, 1);
				return true;
			}
			case "disable_lines":{
				size(5, -1);
				return true;
			}
			case "edit_road":{
				TagCW compound = TagCW.create();
				compound.set("cargo", "custom");
				compound.set("layer", 0);
				container.SEND_TO_SERVER.accept(compound);
				return true;
			}
			case "edit_top":{
				TagCW compound = TagCW.create();
				compound.set("cargo", "custom");
				compound.set("layer", 4);
				container.SEND_TO_SERVER.accept(compound);
				return true;
			}
			case "edit_lines":{
				TagCW compound = TagCW.create();
				compound.set("cargo", "custom");
				compound.set("layer", 5);
				container.SEND_TO_SERVER.accept(compound);
				return true;
			}
			case "rem_road":{
				TagCW compound = TagCW.create();
				compound.set("cargo", "remove");
				compound.set("layer", 0);
				container.SEND_TO_SERVER.accept(compound);
				return true;
			}
			case "rem_top":{
				TagCW compound = TagCW.create();
				compound.set("cargo", "remove");
				compound.set("layer", 4);
				container.SEND_TO_SERVER.accept(compound);
				return true;
			}
			case "rem_lines":{
				TagCW compound = TagCW.create();
				compound.set("cargo", "remove");
				compound.set("layer", 5);
				container.SEND_TO_SERVER.accept(compound);
				return true;
			}
		}
		return false;
	}

	protected void size(int idx, int am){
		switch(idx){
			case 0:
			case 2:
			case 3:
				if(size[idx] + am >= 0 && size[idx] + am <= 64) size[idx] += am;
				break;
			case 1:
			case 4:
			case 5:
				if(size[idx] + am >= 0 && size[idx] + am < 2) size[idx] += am;
				break;
		}
		TagCW compound = TagCW.create();
		compound.set("sizes", size);
		compound.set("cargo", "save");
		container.SEND_TO_SERVER.accept(compound);
	}

	@Override
	public void getTooltip(int mx, int my, List<String> list){
		if(rtc.inventory.empty(0) && slots.get("road").hovered(gLeft, gTop, mx, my)){
			for(int i = 0; i < 6; i++){
				list.add(container.TRANSLATOR.apply("ui.fvtm.road_tool.road_slot_info" + i));
			}
		}
	}

}
