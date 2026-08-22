package net.fexcraft.mod.fvtm.ui.road;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.ContainerInterface;
import net.fexcraft.mod.uni.ui.UIButton;
import net.fexcraft.mod.uni.ui.UIText;
import net.fexcraft.mod.uni.ui.UserInterface;

import java.util.List;
import java.util.Map;

import static net.fexcraft.mod.uni.ui.ContainerInterface.*;

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
			texts.get("road").value("C" + rtc.rt_width);
		}
		else if(rtc.inventory.empty(0)){
			texts.get("road").value("OFF");
		}
		else{
			texts.get("road").value("" + rtc.rt_width);
		}
		//
		if(rtc.custom_slab){
			texts.get("slab").value("C" + rtc.rt_width);
		}
		else if(rtc.inventory.empty(6)){
			texts.get("slab").value("OFF");
		}
		else{
			texts.get("slab").value("" + rtc.rt_width);
		}
 		//
		texts.get("ground").value(rtc.bot_on && !rtc.inventory.empty(1) ? "ON" : "OFF");
		//
		if(rtc.inventory.empty(2) || rtc.lheight < 1){
			texts.get("left").value("OFF");
		}
		else{
			texts.get("left").value("" + rtc.lheight);
		}
		//
		if(rtc.inventory.empty(3) || rtc.rheight < 1){
			texts.get("right").value("OFF");
		}
		else{
			texts.get("right").value("" + rtc.rheight);
		}
		//
		texts.get("top").value(rtc.top_on ? rtc.custom_top ? "C:ON" : "ON" : "OFF");
		texts.get("lines").value(rtc.lin_on ? rtc.custom_lines ? "C:ON" : "ON" : "OFF");
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
		for(Map.Entry<String, UIText> entry : texts.entrySet()){
			if(entry.getValue().hovered(gLeft, gTop, mx, my)) list.add(TRANSLATOR.apply("ui.fvtm.road_tool." + entry.getKey() + "_info"));
		}
	}

}
