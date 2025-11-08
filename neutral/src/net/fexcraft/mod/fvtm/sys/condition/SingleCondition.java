package net.fexcraft.mod.fvtm.sys.condition;

import net.fexcraft.app.json.JsonHandler;
import net.fexcraft.app.json.JsonValue;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class SingleCondition extends Condition {

	public JsonValue value;
	public String target;

	public SingleCondition(CondKey ck, JsonValue val){
		key = ck;
		value = val == null ? new JsonValue<>(true) : val;
	}

	public SingleCondition(String[] array){
		key = ConditionRegistry.parseKey(array[0], array[1], array.length > 2 ? array[2] : CondMode.EQUAL.key);
		value = array.length > 3 ? JsonHandler.parseValue(array[3]) : new JsonValue<>(true);
	}

	@Override
	public String toString(){
		return key.type.key + " " + key.target + " " + key.mode.key + " " + value.string_value();
	}

	@Override
	public JsonValue<?> value(){
		return value;
	}

}
