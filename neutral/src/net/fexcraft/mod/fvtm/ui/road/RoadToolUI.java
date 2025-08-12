package net.fexcraft.mod.fvtm.ui.road;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.utils.Formatter;
import net.fexcraft.mod.fvtm.sys.road.UniRoadTool;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.ContainerInterface;
import net.fexcraft.mod.uni.ui.UIButton;
import net.fexcraft.mod.uni.ui.UserInterface;

import java.util.List;

import static net.fexcraft.mod.uni.ui.ContainerInterface.sendToServer;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RoadToolUI extends UserInterface {

	protected RoadToolCon rtc;

	public RoadToolUI(JsonMap map, ContainerInterface con) throws Exception{
		super(map, con);
		rtc = (RoadToolCon)con;
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
		texts.get("road_width").translate(rtc.rt_width);
		texts.get("slab_width").value("ui.fvtm.road_tool.slab_fill_width");
		texts.get("slab_width").translate(rtc.rt_width);
		//
		if(rtc.custom_slab){
			texts.get("slab_fill").value("ui.fvtm.road_tool.slab_fill_custom");
			texts.get("slab_fill").translate();
		}
		else if(rtc.inventory.empty(6)){
			texts.get("slab_fill").value("ui.fvtm.road_tool.no_fill_block");
			texts.get("slab_fill").translate();
		}
		else{
			texts.get("slab_fill").value(rtc.inventory.get(6).getName());
		}
 		//
		if(rtc.inventory.empty(1)){
			texts.get("ground_fill").value("ui.fvtm.road_tool.no_fill_block");
			texts.get("ground_fill").translate();
		}
		else{
			texts.get("ground_fill").value(rtc.inventory.get(1).getName());
		}
		texts.get("ground_status").value("ui.fvtm.road_tool.ground_fill_" + (rtc.bot_on ? "enabled" : "disabled"));
		texts.get("ground_status").translate();
		//
		if(rtc.inventory.empty(2)){
			texts.get("left_fill").value("ui.fvtm.road_tool.no_fill_block");
			texts.get("left_fill").translate();
		}
		else{
			texts.get("left_fill").value(rtc.inventory.get(2).getName());
		}
		if(rtc.lheight > 0){
			texts.get("left_size").value("ui.fvtm.road_tool.left_fill_size");
			texts.get("left_size").translate(rtc.lheight);
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
		if(rtc.rheight > 0){
			texts.get("right_size").value("ui.fvtm.road_tool.right_fill_size");
			texts.get("right_size").translate(rtc.rheight);
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
		texts.get("top_status").value("ui.fvtm.road_tool.top_fill_" + (rtc.top_on ? "enabled" : "disabled"));
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
		texts.get("lines_status").value("ui.fvtm.road_tool.lines_fill_" + (rtc.lin_on ? "enabled" : "disabled"));
		texts.get("lines_status").translate();
	}

	@Override
	public boolean onAction(UIButton button, String id, int x, int y, int b){
		switch(id){
			case "add_width0":
			case "add_width1":{
				if(++rtc.rt_width > 64) rtc.rt_width = 64;
				sendToServer(com -> com.set("cargo", "add_width"));
				return true;
			}
			case "sub_width0":
			case "sub_width1":{
				if(--rtc.rt_width < 1) rtc.rt_width = 1;
				sendToServer(com -> com.set("cargo", "sub_width"));
				return true;
			}
			case "enable_ground":{
				sendToServer(com -> {
					com.set("cargo", "ground");
					com.set("ground", rtc.bot_on = true);
				});
				return true;
			}
			case "disable_ground":{
				sendToServer(com -> {
					com.set("cargo", "ground");
					com.set("ground", rtc.bot_on = false);
				});
				return true;
			}
			case "add_left":{
				if(++rtc.lheight > 64) rtc.lheight = 64;
				sendToServer(com -> com.set("cargo", "add_left"));
				return true;
			}
			case "sub_left":{
				if(--rtc.lheight < 0) rtc.lheight = 0;
				sendToServer(com -> com.set("cargo", "sub_left"));
				return true;
			}
			case "add_right":{
				if(++rtc.rheight > 64) rtc.rheight = 64;
				sendToServer(com -> com.set("cargo", "add_right"));
				return true;
			}
			case "sub_right":{
				if(--rtc.rheight < 0) rtc.rheight = 0;
				sendToServer(com -> com.set("cargo", "sub_right"));
				return true;
			}
			case "enable_top":{
				sendToServer(com -> {
					com.set("cargo", "top");
					com.set("top", rtc.top_on = true);
				});
				return true;
			}
			case "disable_top":{
				sendToServer(com -> {
					com.set("cargo", "top");
					com.set("top", rtc.top_on = false);
				});
				return true;
			}
			case "enable_lines":{
				sendToServer(com -> {
					com.set("cargo", "lines");
					com.set("lines", rtc.lin_on = true);
				});
				return true;
			}
			case "disable_lines":{
				sendToServer(com -> {
					com.set("cargo", "lines");
					com.set("lines", rtc.lin_on = false);
				});
				return true;
			}
			case "edit_road":{
				TagCW compound = TagCW.create();
				compound.set("cargo", "custom");
				compound.set("layer", 0);
				container.SEND_TO_SERVER.accept(compound);
				return true;
			}
			case "edit_slab":{
				TagCW compound = TagCW.create();
				compound.set("cargo", "custom");
				compound.set("layer", 6);
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
			case "rem_slab":{
				TagCW compound = TagCW.create();
				compound.set("cargo", "remove");
				compound.set("layer", 6);
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

	@Override
	public void getTooltip(int mx, int my, List<String> list){
		if(rtc.inventory.empty(0) && slots.get("road").hovered(gLeft, gTop, mx, my)){
			for(int i = 0; i < 8; i++){
				list.add(container.TRANSLATOR.apply("ui.fvtm.road_tool.road_slot_info" + i));
			}
		}
		if(rtc.inventory.empty(6) && slots.get("slab").hovered(gLeft, gTop, mx, my)){
			for(int i = 0; i < 4; i++){
				list.add(container.TRANSLATOR.apply("ui.fvtm.road_tool.road_slab_info" + i));
			}
		}
	}

}
