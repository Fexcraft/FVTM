package net.fexcraft.mod.fvtm.ui.rail;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.sys.event.EventListener;
import net.fexcraft.mod.fvtm.sys.event.EventType;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.ContainerInterface;
import net.fexcraft.mod.uni.ui.UIButton;
import net.fexcraft.mod.uni.ui.UserInterface;

import java.util.List;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RailJuncEvents extends UserInterface {

	private static int type;
	private static int sel;
	private RailJuncEventsCon menu;

	public RailJuncEvents(JsonMap map, ContainerInterface con) throws Exception{
		super(map, con);
		menu = (RailJuncEventsCon)con;
	}

	@Override
	public void init(){
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
					type = EventType.JUNCTION_EVENTS.size() - 1;
					sel = 0;
				}
				updateListener();
				break;
			}
			case "t_next":{
				type++;
				if(type >= EventType.JUNCTION_EVENTS.size()){
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
				com.set("type", EventType.JUNCTION_EVENTS.get(type).key);
				com.set("sel", sel);
				ContainerInterface.SEND_TO_SERVER.accept(com);
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
			case "clear_cond":{
				fields.get("cond").text("true");
				break;
			}
			case "clear_act":{
				fields.get("act").text("logger");
				break;
			}
			case "clear_arg":{
				fields.get("arg").text("{event}/{junction}");
				break;
			}
			case "save":{
				TagCW com = TagCW.create();
				com.set("task", id);
				com.set("type", EventType.JUNCTION_EVENTS.get(type).key);
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
		EventType et = EventType.JUNCTION_EVENTS.get(type);
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
