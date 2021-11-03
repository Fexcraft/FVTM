package net.fexcraft.mod.fvtm.sys.condition;

import java.util.HashMap;

import net.fexcraft.mod.fvtm.sys.condition.Condition.Conditional;

public class ConditionRegistry {
	
	public static HashMap<String, Condition> CONDITIONS = new HashMap<>();
	public static HashMap<String, Conditional> CONDITIONALS = new HashMap<>();
	
	public static void register(Condition con){
		CONDITIONS.put(con.id, con);
		String comp = con.toCompare();
		if(!CONDITIONALS.containsKey(comp)){
			CONDITIONALS.put(con.id, con.build());
		}
	}

}
