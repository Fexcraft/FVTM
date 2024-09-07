package net.fexcraft.mod.fvtm.ui.vehicle;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.sys.uni.SeatInstance;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.ContainerInterface;
import net.fexcraft.mod.uni.ui.UIButton;
import net.fexcraft.mod.uni.ui.UIText;
import net.fexcraft.mod.uni.ui.UserInterface;

import java.util.ArrayList;
import java.util.List;

import static net.fexcraft.lib.common.utils.Formatter.PARAGRAPH_SIGN;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class VehicleAttributes extends UserInterface {

	private ArrayList<Attribute<?>> attributes = new ArrayList<>();
	private VehicleInstance veh;
	private SeatInstance seat;
	private int scroll;
	private int lastveh;

	public VehicleAttributes(JsonMap map, ContainerInterface con) throws Exception{
		super(map, con);
		veh = (VehicleInstance)container.get("vehicle");
		seat = veh.getSeatOf(con.player.entity.direct());
		veh.data.getAttributes().values().forEach(attr -> {
			if(seat == null){
				if(attr.external) attributes.add(attr);
			}
			else if(seat.seat.driver || (attr.access.contains(seat.seat.name))){
				attributes.add(attr);
			}
		});
		if(lastveh != con.pos.x) scroll = 0;
		lastveh = con.pos.x;
		scroll(null);
	}

	@Override
	public void predraw(float ticks, int mx, int my){
		UIText temp = null;
		for(int k = 0; k < 14; k++){
			int l = scroll + k;
			if(l >= attributes.size()){
				texts.get("attr_" + k).visible(false);
				buttons.get("toggle_" + k).visible(false);
				buttons.get("edit_" + k).visible(false);
			}
			else{
				temp = texts.get("attr_" + k);
				temp.visible(true);
				temp.value(attributes.get(l).id);
				buttons.get("toggle_" + k).visible(attributes.get(l).valuetype.isTristate());
				buttons.get("edit_" + k).visible(true);
			}
		}
	}

	@Override
	public boolean onAction(UIButton button, String id, int x, int y, int b){
		switch(id){
			case "up":{
				scroll(-1);
				return true;
			}
			case "down":{
				scroll(1);
				return true;
			}
			case "filter_all":{
				attributes.clear();
				veh.data.getAttributes().values().forEach(attr -> attributes.add(attr));
				scroll(0);
				return true;
			}
			case "filter_editable":{
				attributes.removeIf(attr -> !attr.editable);
				scroll(null);
				return true;
			}
			case "filter_external":{
				attributes.clear();
				veh.data.getAttributes().values().forEach(attr -> {
					if(attr.external){
						attributes.add(attr);
					}
				});
				scroll(0);
				return true;
			}
			case "filter_seat":{
				attributes.clear();
				if(seat == null) return true;
				veh.data.getAttributes().values().forEach(attr -> {
					if(seat.seat.driver || (attr.access.contains(seat.seat.name))){
						attributes.add(attr);
					}
				});
				scroll(0);
				return true;
			}
		}
		if(id.startsWith("toggle_")){
			int idx = Integer.parseInt(id.substring(7));
			if(idx + scroll >= attributes.size()) return true;
			Attribute<?> attr = attributes.get(scroll + idx);
			TagCW com = TagCW.create();
			com.set("cargo", "toggle");
			com.set("attr", attr.id);
			if(!attr.valuetype.isBoolean() && b != 0){
				com.set("reset", true);
			}
			com.set("bool", !attr.asBoolean());
			container.SEND_TO_SERVER.accept(com);
		}
		if(id.startsWith("edit_")){
			int idx = Integer.parseInt(id.substring(5));
			if(idx + scroll >= attributes.size()) return true;
			Attribute<?> attr = attributes.get(scroll + idx);
			TagCW com = TagCW.create();
			com.set("cargo", "editor");
			com.set("attr", attr.id);
			container.SEND_TO_SERVER.accept(com);
		}
		return false;
	}

	private void scroll(Integer by){
		if(by != null){
			scroll += by;
			if(scroll < 0) scroll = 0;
			if(scroll + 14 >= attributes.size()) scroll = attributes.size() - 14;
		}
		UIText text = texts.get("scroll");
		text.value("ui.fvtm.vehicle_attributes.scroll");
		text.translate();
		int m = scroll + 14;
		if(m > attributes.size()) m = attributes.size();
		text.value(text.value() + " " + (scroll + 1) + "-" + m + "/" + attributes.size());
	}

	@Override
	public boolean onScroll(UIButton button, String id, int mx, int my, int am){
		scroll(am);
		return true;
	}

	@Override
	public void getTooltip(int mx, int my, List<String> list){
		UIText text = null;
		for(int i = 0; i < 14; i++){
			text = texts.get("attr_" + i);
			if(!text.visible() || !text.hovered()) continue;
			Attribute<?> attr = attributes.get(i + scroll);
			list.add(PARAGRAPH_SIGN + "6V: " + PARAGRAPH_SIGN + "7" + attr.asString());
			if(attr.group != null){
				list.add(PARAGRAPH_SIGN + "bG: " + PARAGRAPH_SIGN + "7" + attr.group);
			}
			if(attr.hasPerm()){
				list.add(PARAGRAPH_SIGN + "6P: " + PARAGRAPH_SIGN + "7" + attributes.get(i).perm);
			}
			if(!attr.editable){
				text.value("ui.fvtm.vehicle_attributes.not_editable");
				text.translate();
				list.add(PARAGRAPH_SIGN + "o" + PARAGRAPH_SIGN + "e" + text.value());
				text.value(attr.id);
			}
		}
	}

}
