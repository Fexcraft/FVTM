package net.fexcraft.mod.fvtm.sys.condition;

import net.fexcraft.app.json.JsonValue;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Condition {

	public CondKey key;
	public Conditional al;

	public static Condition parse(JsonValue<?> val){
		if(val == null) return ConditionRegistry.parse("true");
		if(val.isArray()) return new MultiCondition(val.asArray());
		else return ConditionRegistry.parse(val.string_value());
	}

	public Condition link(){
		if(al == null) al = ConditionRegistry.get(key);
		return this;
	}

	public JsonValue<?> value(){
		return null;
	}

	public Condition[] conditions(){
		return null;
	}

}
