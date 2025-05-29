package net.fexcraft.mod.fvtm.sys.event;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.mod.fvtm.sys.condition.Condition;
import net.fexcraft.mod.fvtm.sys.condition.ConditionRegistry;

import java.util.Arrays;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class EventListener {

	public EventType type;
	public Condition cond;
	public EventAction action;
	public String[] args;

	public EventListener(JsonMap map){
		type = EventType.parse(map.getString("type", "null"));
		cond = map.get("cond").isArray() ? new Condition(map.get("cond").asArray()) : ConditionRegistry.parse(map.getString("cond", "true"));
		cond.link();
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
		cond = arr.get(1).isArray() ? new Condition(arr.get(1).asArray()) : ConditionRegistry.parse(arr.get(1).string_value());
		cond.link();
		action = EventAction.parse(arr.get(2).string_value());
		if(arr.size() > 3){
			if(arr.get(3).isArray()) args = arr.get(3).asArray().toStringArray();
			else args = arr.get(3).string_value().split(" ");
		}
		else args = new String[0];
	}

	public EventListener(String typ, String con, String act, String... strs){
		type = EventType.parse(typ);
		cond = ConditionRegistry.parse(con);
		cond.link();
		action = EventAction.parse(act);
		args = strs;
	}

	public static EventListener parse(JsonValue val){
		if(val.isArray()) return new EventListener(val.asArray());
		else if(val.isMap()) return new EventListener(val.asMap());
		else{
			String[] args = val.string_value().split(" ");
			return new EventListener(args[0], args[1], args[2], args.length > 3 ? Arrays.copyOfRange(args, 3, args.length) : new String[0]);
		}
	}

	public String argString(){
		StringBuilder str = new StringBuilder();
		for(String arg : args){
			if(str.length() > 0) str.append(" " + arg);
			else str.append(arg);
		}
		return str.toString();
	}
}
