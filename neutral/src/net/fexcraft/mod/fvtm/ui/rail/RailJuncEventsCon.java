package net.fexcraft.mod.fvtm.ui.rail;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.sys.condition.ConditionRegistry;
import net.fexcraft.mod.fvtm.sys.event.EventAction;
import net.fexcraft.mod.fvtm.sys.event.EventListener;
import net.fexcraft.mod.fvtm.sys.event.EventType;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailSystem;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.ui.UIKeys;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.ContainerInterface;

import java.util.ArrayList;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RailJuncEventsCon extends ContainerInterface {

	protected RailSystem sys;
	protected Junction junc;

	public RailJuncEventsCon(JsonMap map, UniEntity player, V3I vec){
		super(map, player, vec);
		sys = SystemManager.get(SystemManager.Systems.RAIL, player.entity.getWorld());
		if(sys == null) player.entity.closeUI();
		junc = sys.getJunction(vec);
		if(junc == null){
			player.entity.send("junction.not.found");
			player.entity.closeUI();
		}
	}

	@Override
	public Object get(String key, Object... objs){
		return null;
	}

	@Override
	public void packet(TagCW com, boolean client){
		if(client){
			((RailJuncEvents)ui).updateListener();
			return;
		}
		String task = com.getString("task");
		switch(task){
			case "add":{
				EventType type = EventType.parse(com.getString("type"));
				if(!EventType.JUNCTION_EVENTS.contains(type)) return;
				if(!junc.holder.listeners.containsKey(type)) junc.holder.listeners.put(type, new ArrayList<>());
				junc.holder.listeners.get(type).add(new EventListener(type.key, "true", "logger", "empty {event} listener in {junction}"));
				junc.updateClient();
				break;
			}
			case "rem":{
				EventType type = EventType.parse(com.getString("type"));
				if(!EventType.JUNCTION_EVENTS.contains(type)) return;
				if(junc.holder.listeners.containsKey(type)){
					int idx = com.getInteger("sel");
					if(idx >= 0 && idx < junc.holder.listeners.get(type).size()){
						junc.holder.listeners.get(type).remove(idx);
					}
				}
				junc.updateClient();
				break;
			}
			case "save":{
				EventType type = EventType.parse(com.getString("type"));
				if(!EventType.JUNCTION_EVENTS.contains(type)) return;
				if(junc.holder.listeners.containsKey(type)){
					int idx = com.getInteger("sel");
					if(idx >= 0 && idx < junc.holder.listeners.get(type).size()){
						EventListener lis = junc.holder.listeners.get(type).get(idx);
						lis.cond = ConditionRegistry.parse(com.getString("cond"));
						lis.action = EventAction.parse(com.getString("act"));
						lis.args = EventListener.parseArg(com.getString("arg"));
						lis.cond.link();
						junc.updateClient();
					}
				}
				break;
			}
		}
		SEND_TO_CLIENT.accept(com, player);
	}

}
