package net.fexcraft.mod.fvtm.ui.vehicle;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.sys.uni.FvtmWorld;
import net.fexcraft.mod.fvtm.sys.uni.SeatInstance;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.*;

import java.util.ArrayList;
import java.util.List;

import static net.fexcraft.mod.uni.ui.ContainerInterface.TRANSFORMAT;
import static net.fexcraft.mod.uni.ui.ContainerInterface.TRANSLATOR;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class VehicleAttributes extends UserInterface {

	private ArrayList<Attribute<?>> attributes = new ArrayList<>();
	private static final int ROWS = 4, COLS = 12;
	private VehicleInstance veh;
	private SeatInstance seat;
	private int lastveh;
	private int page;
	private int sel;

	public VehicleAttributes(JsonMap map, ContainerInterface con) throws Exception{
		super(map, con);
		veh = ((FvtmWorld)con.player.entity.getWorld()).getVehicle(con.pos.x);
		seat = veh.getSeatOf(con.player.entity.direct());
		veh.data.getAttributes().values().forEach(attr -> {
			if(seat == null){
				if(attr.external) attributes.add(attr);
			}
			else if(seat.seat.driver || attr.access.contains(seat.seat.name)){
				attributes.add(attr);
			}
		});
		if(lastveh != con.pos.x) page = 0;
		lastveh = con.pos.x;
	}

	@Override
	public void init(){
		fields.get("editor").text(attributes.size() > 0 ? attributes.get(0).asString() : "");
	}

	@Override
	public void predraw(float ticks, int mx, int my){
		int max = attributes.size() / 48 + 1;
		texts.get("page").transval("ui.fvtm.vehicle_attributes.page", page + 1 + "/" + max, sel + 1 + "/" + attributes.size());
		if(sel >= attributes.size()){
			for(int i = 0; i < 4; i++) texts.get("info_" + i).value("");
			return;
		}
		Attribute<?> attr = attributes.get(sel);
		texts.get("info_0").transval("ui.fvtm.vehicle_attributes.info_id", attr.id);
		texts.get("info_1").transval("ui.fvtm.vehicle_attributes.info_status", attr.editable, attr.external);
		texts.get("info_2").transval("ui.fvtm.vehicle_attributes.info_origin", attr.valuetype.name, attr.origin == null ? "vehicle" : attr.origin);
		texts.get("info_3").transval("ui.fvtm.vehicle_attributes.info_bound", attr.value, attr.initial,
			attr.min == Integer.MIN_VALUE ? "-" : attr.min, attr.max == Integer.MAX_VALUE ? "-" : attr.max);
	}

	@Override
	public void postdraw(float ticks, int mx, int my){
		drawer.bind(tabs.get("main").texture);
		drawer.draw(gLeft + 7 + (sel % COLS) * 18, gTop + 7 + (sel / COLS) * 18, 0, 238, 18, 18);
		int idx;
		for(int row = 0; row < ROWS; row++){
			for(int col = 0; col < COLS; col++){
				idx = col + row * COLS;
				if(idx >= attributes.size()) continue;
				drawer.bind(attributes.get(idx).getCurrentIcon());
				drawer.drawFull(gLeft + 8 + col * 18, gTop + 8 + row * 18,16, 16);
			}
		}
	}

	@Override
	public boolean onAction(UIButton button, String id, int x, int y, int b){
		switch(id){
			case "prev":{
				updatePage(-1);
				return true;
			}
			case "next":{
				updatePage(1);
				return true;
			}
			case "list":{
				attributes.clear();
				veh.data.getAttributes().values().forEach(attr -> attributes.add(attr));
				fields.get("editor").text(attributes.size() > 0 ? attributes.get(0).asString() : "");
				sel = 0;
				return true;
			}
			case "seat":{
				attributes.clear();
				veh.data.getAttributes().values().forEach(attr -> {
					if(seat != null && attr.access.contains(seat.seat.name)) attributes.add(attr);
				});
				fields.get("editor").text(attributes.size() > 0 ? attributes.get(0).asString() : "");
				sel = 0;
				return true;
			}
			case "ext":{
				attributes.clear();
				veh.data.getAttributes().values().forEach(attr -> {
					if(attr.external) attributes.add(attr);
				});
				fields.get("editor").text(attributes.size() > 0 ? attributes.get(0).asString() : "");
				sel = 0;
				return true;
			}
			case "toggle":{
				Attribute<?> attr = attributes.get(sel);
				if(!attr.editable && !attr.hasPerm()) return true;
				if(!attr.valuetype.isTristate()) return true;
				TagCW com = TagCW.create();
				com.set("cargo", "toggle");
				com.set("attr", attr.id);
				com.set("bool", !attr.asBoolean());
				container.SEND_TO_SERVER.accept(com);
				return true;
			}
			case "reset":{
				Attribute<?> attr = attributes.get(sel);
				if(!attr.editable && !attr.hasPerm()) return true;
				if(!attr.valuetype.isTristate()) return true;
				TagCW com = TagCW.create();
				com.set("cargo", "toggle");
				com.set("attr", attr.id);
				com.set("reset", true);
				if(attr.valuetype.isBoolean()) com.set("bool", (Boolean)attr.initial);
				container.SEND_TO_SERVER.accept(com);
				return true;
			}
			case "decr":{
				Attribute<?> attr = attributes.get(sel);
				if(!attr.editable && !attr.hasPerm()) return true;
				if(!attr.valuetype.isNumber()) return true;
				TagCW com = TagCW.create();
				com.set("cargo", "toggle");
				com.set("attr", attr.id);
				if(attr.valuetype.isFloat()){
					com.set("value", attr.asFloat() - 1f);
				}
				else{
					com.set("value", attr.asInteger() - 1);
				}
				container.SEND_TO_SERVER.accept(com);
				return true;
			}
			case "incr":{
				Attribute<?> attr = attributes.get(sel);
				if(!attr.editable && !attr.hasPerm()) return true;
				if(!attr.valuetype.isNumber()) return true;
				TagCW com = TagCW.create();
				com.set("cargo", "toggle");
				com.set("attr", attr.id);
				if(attr.valuetype.isFloat()){
					com.set("value", attr.asFloat() + 1f);
				}
				else{
					com.set("value", attr.asInteger() + 1);
				}
				container.SEND_TO_SERVER.accept(com);
				return true;
			}
			case "apply":{
				Attribute<?> attr = attributes.get(sel);
				if(!attr.editable && !attr.hasPerm()) return true;
				UIField field = fields.get("editor");
				TagCW com = TagCW.create();
				com.set("cargo", "toggle");
				com.set("attr", attr.id);
				if(attr.valuetype.isTristate()){
					if(field.text().equals("null")){
						com.set("reset", true);
						com.set("bool", (Boolean)attr.initial);
					}
					else com.set("bool", Boolean.parseBoolean(field.text()));
				}
				else if(attr.valuetype.isFloat()){
					com.set("value", field._float());
				}
				else if(attr.valuetype.isInteger()){
					com.set("value", field.integer());
				}
				else{
					com.set("value", field.text());
				}
				container.SEND_TO_SERVER.accept(com);
				return true;
			}
			case "attrs":{
				int col = (x - gLeft - 7) / 18;
				int row = (y - gTop - 7) / 18;
				int idx = col + row * COLS;
				if(idx < 0 || idx >= attributes.size()) return true;
				if(b > 0){
					int os = sel;
					sel = idx;
					onAction(buttons.get("toggle"), "toggle", x, y, b);
					sel = os;
				}
				else{
					sel = idx;
					fields.get("editor").text(attributes.get(idx).asString());
				}
				return true;
			}
		}
		return false;
	}

	private void updatePage(int by){
		if(by != 0){
			page += by;
			if(page < 0) page = 0;
		}
	}

	@Override
	public boolean onScroll(UIButton button, String id, int mx, int my, int am){
		updatePage(am);
		return true;
	}

	@Override
	public void getTooltip(int mx, int my, List<String> list){
		if(buttons.get("decr").hovered() || buttons.get("incr").hovered()){
			list.add(TRANSLATOR.apply("ui.fvtm.vehicle_attributes.number_info"));
		}
		if(buttons.get("toggle").hovered()){
			list.add(TRANSLATOR.apply("ui.fvtm.vehicle_attributes.toggle_info"));
		}
		UIText text;
		for(int i = 0; i < 4; i++){
			text = texts.get("info_" + i);
			if(text.hovered()) list.add(text.value());
		}
		int idx = ((mx - gLeft - 7) / 18) + ((my - gTop - 7) / 18) * COLS;
		if(idx < 0 || idx >= attributes.size()) return;
		Attribute attr = attributes.get(idx);
		list.add(TRANSFORMAT.apply("ui.fvtm.vehicle_attributes.info_id", new Object[]{ attr.id }));
		list.add(TRANSFORMAT.apply("ui.fvtm.vehicle_attributes.info_value", new Object[]{ attr.asString() }));
		list.add(TRANSFORMAT.apply("ui.fvtm.vehicle_attributes.info_type", new Object[]{ attr.valuetype.name }));
		if(attr.hasPerm()){
			list.add(TRANSFORMAT.apply("ui.fvtm.vehicle_attributes.info_perm", new Object[]{ attr.perm }));
		}
	}

}
