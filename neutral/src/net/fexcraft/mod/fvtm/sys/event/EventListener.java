package net.fexcraft.mod.fvtm.sys.event;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.mod.fvtm.sys.condition.ConditionRegistry;
import net.fexcraft.mod.fvtm.sys.condition.Conditional;

import java.util.Arrays;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class EventListener {

	public EventType type;
	public Conditional cond;
	public EventAction action;
	public String[] args;

	public EventListener(JsonMap map){
		type = EventType.parse(map.getString("type", "null"));
		cond = ConditionRegistry.get(map.getString("cond", "null"));
		action = EventAction.parse(map.getString("action", "none"));
		if(map.has("args")){
			if(map.get("args").isArray()) args = map.getArray("args").toStringArray();
			else args = map.get("args").string_value().split(" ");
		}
		else{
			args = new String[0];
		}
	}

	public EventListener(JsonArray arr){
		type = EventType.parse(arr.get(0).string_value());
		cond = ConditionRegistry.get(arr.get(1).string_value());
		action = EventAction.parse(arr.get(2).string_value());
		if(arr.size() > 3){
			if(arr.get(3).isArray()) args = arr.get(3).asArray().toStringArray();
			else args = arr.get(3).string_value().split(" ");
		}
		else args = new String[0];
	}

	public EventListener(String[] strs){
		type = EventType.parse(strs[0]);
		cond = ConditionRegistry.get(strs[1]);
		action = EventAction.parse(strs[2]);
		if(strs.length > 3){
			args = Arrays.copyOfRange(strs, 3, strs.length);
		}
		else args = new String[0];
	}

	public static EventListener parse(JsonValue val){
		if(val.isArray()) return new EventListener(val.asArray());
		else if(val.isMap()) return new EventListener(val.asMap());
		else return new EventListener(val.string_value().split(" "));
	}

}
