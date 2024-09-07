package net.fexcraft.mod.fvtm.sys.condition;

import net.fexcraft.mod.fvtm.sys.impl.CondBuilder;

import java.util.HashMap;
import java.util.function.Function;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ConditionRegistry {
	
	public static HashMap<String, Condition> CONDITIONS = new HashMap<>();
	private static HashMap<String, Conditional> CONDITIONALS = new HashMap<>();
	public static Function<Condition, Conditional> BUILDER = CondBuilder.run();
	public static final Conditional COND_FALSE = data -> false;
	public static final Conditional COND_TRUE = data -> true;
	static {
		CONDITIONALS.put("fvtm:true", COND_TRUE);
	}
	
	public static void register(Condition con){
		CONDITIONS.put(con.id, con);
	}
	
	public static Conditional get(String id){
		if(!CONDITIONALS.containsKey(id)){
			Condition con = CONDITIONS.get(id);
			if(con == null) return COND_FALSE;
			CONDITIONALS.put(con.id, BUILDER.apply(con));
		}
		return CONDITIONALS.get(id);
	}

}
