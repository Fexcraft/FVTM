package net.fexcraft.mod.fvtm.ui.rail;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.RGB;
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

	private RailJuncEventsCon menu;
	private int type;
	private int sel;

	public RailJuncEvents(JsonMap map, ContainerInterface con) throws Exception{
		super(map, con);
		menu = (RailJuncEventsCon)con;
	}

	@Override
	public void init(){
		updateTitle();
	}

	private void updateTitle(){
		EventType et = EventType.JUNCTION_EVENTS.get(type);
		texts.get("title").transval("ui.fvtm.rail_junction_events." + et.key, et.key);
		int am = menu.junc.holder.listeners.containsKey(et) ? menu.junc.holder.listeners.get(et).size() : 0;
		texts.get("entry").transval("ui.fvtm.rail_junction_events.selected", sel + 1, am);
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

				break;
			}
			case "t_next":{

				break;
			}
			case "add":{

				break;
			}
			case "rem":{

				break;
			}
			case "e_prev":{

				break;
			}
			case "e_next":{

				break;
			}
			case "clear_cond":{

				break;
			}
			case "clear_act":{

				break;
			}
			case "clear_arg":{

				break;
			}
			case "save":{

			}
			default:{
				break;
			}
		}
		return false;
	}

	@Override
	public void getTooltip(int mx, int my, List<String> list){
		//
	}

}
