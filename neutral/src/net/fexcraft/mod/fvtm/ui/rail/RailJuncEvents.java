package net.fexcraft.mod.fvtm.ui.rail;

import net.fexcraft.app.json.JsonHandler;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.sys.event.EventAction;
import net.fexcraft.mod.fvtm.sys.event.EventActions;
import net.fexcraft.mod.fvtm.sys.event.EventListener;
import net.fexcraft.mod.fvtm.sys.event.EventType;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.ContainerInterface;
import net.fexcraft.mod.uni.ui.UIButton;
import net.fexcraft.mod.uni.ui.UserInterface;

import java.util.ArrayList;
import java.util.List;

import static net.fexcraft.mod.fvtm.sys.event.EventAction.NONE;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RailJuncEvents extends UserInterface {

	private static List<EventType> types = new ArrayList<>();
	private static int type;
	private static int sel;
	private RailJuncEventsCon menu;

	public RailJuncEvents(JsonMap map, ContainerInterface con) throws Exception{
		super(map, con);
		menu = (RailJuncEventsCon)con;
	}

	@Override
	public void init(){
		types.clear();
		types.add(EventType.JUNC_PASS);
		if(menu.junc.hasSignals()) types.add(EventType.JUNC_SIGNAL);
		else if(menu.junc.type.isSwitch() || menu.junc.type.isDouble()){
			types.add(EventType.JUNC_SWITCH);
		}
		updateListener();
	}

	@Override
	public void predraw(float ticks, int mx, int my){
		//
	}

	@Override
	public void drawbackground(float ticks, int mx, int my){
		//
	}

	@Override
	public void postdraw(float ticks, int mx, int my){
		//
	}

	@Override
	public boolean onAction(UIButton button, String id, int x, int y, int mb){
		switch(id){
			case "t_prev":{
				type--;
				if(type < 0){
					type = types.size() - 1;
					sel = 0;
				}
				updateListener();
				break;
			}
			case "t_next":{
				type++;
				if(type >= types.size()){
					type = 0;
					sel = 0;
				}
				updateListener();
				break;
			}
			case "add":
			case "rem":{
				TagCW com = TagCW.create();
				com.set("task", id);
				com.set("type", types.get(type).key);
				com.set("sel", sel);
				ContainerInterface.SEND_TO_SERVER.accept(com);
				break;
			}
			case "paste":{
				try{
					JsonMap map = JsonHandler.parse(root.getClipboard(), true).asMap();
					EventType type = EventType.parse(map.get("type").string_value());
					if(!types.contains(type)) break;
					fields.get("cond").text(map.get("cond").string_value());
					fields.get("act").text(map.get("action").string_value());
					fields.get("arg").text(map.getString("args", ""));
				}
				catch(Exception e){
					e.printStackTrace();
					container.player.entity.send("error: see log");
				}
				break;
			}
			case "copye":{
				try{
					JsonMap map = new JsonMap();
					map.add("type", types.get(type).key);
					map.add("cond", fields.get("cond").text());
					map.add("action", fields.get("act").text());
					map.add("args", fields.get("arg").text());
					root.setClipboard(map.toString());
				}
				catch(Exception e){
					e.printStackTrace();
					container.player.entity.send("error: see log");
				}
				break;
			}
			case "e_prev":{
				sel--;
				updateListener();
				break;
			}
			case "e_next":{
				sel++;
				updateListener();
				break;
			}
			case "a_prev":
			case "a_next":{
				EventType et = types.get(type);
				List<EventAction> list = et == EventType.JUNC_PASS ? EventActions.JUNC_PASS_ACTIONS : et == EventType.JUNC_SIGNAL ? EventActions.JUNC_SIGNAL_ACTIONS : EventActions.JUNC_SWITCH_ACTIONS;
				EventAction act = EventAction.parse(fields.get("act").text());
				int idx = act == NONE ? -1 : list.indexOf(act);
				if(idx < 0){
					fields.get("act").text(list.get(0).key);
				}
				else{
					idx += id.equals("a_prev") ? -1 : 1;
					if(idx < 0) idx = list.size() - 1;
					if(idx >= list.size()) idx = 0;
					fields.get("act").text(list.get(idx).key);
				}
				break;
			}
			case "clear_cond":{
				fields.get("cond").text("true");
				break;
			}
			case "clear_act":{
				fields.get("act").text("logger");
				break;
			}
			case "clear_arg":{
				fields.get("arg").text("");
				break;
			}
			case "reset":{
				fields.get("arg").text("{event}/{junction}");
				break;
			}
			case "save":{
				TagCW com = TagCW.create();
				com.set("task", id);
				com.set("type", types.get(type).key);
				com.set("sel", sel);
				com.set("cond", fields.get("cond").text());
				com.set("act", fields.get("act").text());
				com.set("arg", fields.get("arg").text());
				ContainerInterface.SEND_TO_SERVER.accept(com);
				break;
			}
		}
		return false;
	}

	protected void updateListener(){
		if(type >= types.size()){
			type = types.size() - 1;
		}
		EventType et = types.get(type);
		int am = 0;
		if(menu.junc.holder.listeners.containsKey(et)){
			am = menu.junc.holder.listeners.get(et).size();
			if(sel >= am) sel = am - 1;
			if(sel < 0) sel = 0;
		}
		else{
			sel = 0;
		}
		texts.get("title").transval("ui.fvtm.rail_junction_events." + et.key, et.key);
		texts.get("entry").transval("ui.fvtm.rail_junction_events.selected", sel + 1, am);
		if(am > 0){
			EventListener lis = menu.junc.holder.listeners.get(et).get(sel);
			fields.get("cond").text(lis.cond.toString());
			fields.get("act").text(lis.action.key);
			fields.get("arg").text(lis.argString());
		}
		else{
			fields.get("cond").text("");
			fields.get("act").text("");
			fields.get("arg").text("");
		}
	}

	@Override
	public void getTooltip(int mx, int my, List<String> list){
		//
	}

}
