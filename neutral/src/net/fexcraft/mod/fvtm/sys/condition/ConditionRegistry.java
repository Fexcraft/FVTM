package net.fexcraft.mod.fvtm.sys.condition;

import net.fexcraft.mod.fvtm.sys.impl.CondBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ConditionRegistry {
	
	public static HashMap<String, Condition> MAPPED_CONDITIONS = new HashMap<>();
	private static HashMap<String, Conditional> MAPPED_CONDITIONALS = new HashMap<>();
	private static HashMap<String, Condition> PARSED_CONDITIONS = new HashMap<>();
	private static HashMap<String, Conditional> PARSED_CONDITIONALS = new HashMap<>();
	public static Function<Condition, Conditional> BUILDER = CondBuilder.run();
	public static final Conditional COND_FALSE = data -> false;
	public static final Conditional COND_TRUE = data -> true;
	static {
		MAPPED_CONDITIONALS.put("fvtm:true", COND_TRUE);
		MAPPED_CONDITIONALS.put("true", COND_TRUE);
	}
	
	public static void register(String id, Condition con){
		MAPPED_CONDITIONS.put(id, con);
	}
	
	public static Conditional get(String id){
		if(!MAPPED_CONDITIONALS.containsKey(id)){
			Condition con = MAPPED_CONDITIONS.get(id);
			if(con == null) return parse(id);
			MAPPED_CONDITIONALS.put(id, BUILDER.apply(con));
		}
		return MAPPED_CONDITIONALS.get(id);
	}

	public static Conditional parse(String cond){
		if(!PARSED_CONDITIONS.containsKey(cond)){
			String[] arr = cond.split(" ");
			if(arr.length < 2) return COND_FALSE;
			cond = new Condition(arr).toCompare();
			if(PARSED_CONDITIONALS.containsKey(cond)) return PARSED_CONDITIONALS.get(cond);
		}
		if(!PARSED_CONDITIONALS.containsKey(cond)){
			PARSED_CONDITIONALS.put(cond, BUILDER.apply(PARSED_CONDITIONS.get(cond)));
		}
		return PARSED_CONDITIONALS.get(cond);
	}

}
