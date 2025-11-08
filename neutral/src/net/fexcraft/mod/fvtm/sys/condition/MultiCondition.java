package net.fexcraft.mod.fvtm.sys.condition;

import net.fexcraft.app.json.JsonArray;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class MultiCondition extends Condition {

	public Condition[] conditions;

	public MultiCondition(JsonArray array){
		key = ConditionRegistry.regKey(CondType.MULTI, CondMode.parse(array.get(0).string_value()), "");
		conditions = new Condition[array.size() - 1];
		for(int i = 1; i < array.size(); i++){
			conditions[i - 1] = Condition.parse(array.get(i));
		}
	}

	@Override
	public Condition link(){
		super.link();
		for(Condition condition : conditions) condition.link();
		return this;
	}

	@Override
	public String toString(){
		StringBuilder conds = new StringBuilder(conditions[0].toString());
		for(int i = 1; i < conditions.length; i++){
			conds.append(", ").append(conditions[i]);
		}
		return key.type.key + " " + key.target + " " + key.mode.key + " [ " + conds + "]";
	}

	@Override
	public Condition[] conditions(){
		return conditions;
	}

}
