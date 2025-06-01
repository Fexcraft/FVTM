package net.fexcraft.mod.fvtm.sys.condition;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonHandler;
import net.fexcraft.app.json.JsonValue;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Condition {

	public CondKey key;
	public JsonValue value;
	public Conditional al;
	
	public Condition(){}

	public Condition(CondKey ck, JsonValue val){
		key = ck;
		value = val == null ? new JsonValue(true) : val;
	}

	public Condition(String[] array){
		key = ConditionRegistry.parseKey(array[0], array[1], array.length > 2 ? array[2] : CondMode.EQUAL.key);
		value = array.length > 3 ? JsonHandler.parseValue(array[3]) : new JsonValue(true);
	}

	public Condition(JsonArray array){
		key = ConditionRegistry.parseKey(array.get(0).string_value(), array.get(1).string_value(), array.size() > 2 ? array.get(2).string_value() : CondMode.EQUAL.key);
		value = array.size() > 3 ? array.get(3) : new JsonValue(true);
	}

	public Condition link(){
		al = ConditionRegistry.get(key);
		return this;
	}

	@Override
	public String toString(){
		return key.type.key + " " + key.target + " " + key.mode.key + " " + value.string_value();
	}

}
