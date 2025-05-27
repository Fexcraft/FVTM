package net.fexcraft.mod.fvtm.sys.impl;

import net.fexcraft.mod.fvtm.sys.condition.CondBuilderRoot;
import net.fexcraft.mod.fvtm.sys.condition.CondKey;
import net.fexcraft.mod.fvtm.sys.condition.Condition;
import net.fexcraft.mod.fvtm.sys.condition.Conditional;

import java.util.function.Function;

import static net.fexcraft.mod.fvtm.sys.condition.ConditionRegistry.COND_FALSE;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class CondBuilder {

	public static Function<CondKey, Conditional> run(){
		Function<CondKey, Conditional> con = CondBuilderRoot.run();
		if(con != null) return con;
		return key -> {
			switch(key.type){
				case WORLDTIME -> {

					return COND_FALSE;
				}
				case BLOCKSTATE -> {

					return COND_FALSE;
				}
				case CUSTOM -> {

					return COND_FALSE;
				}
			}
			return COND_FALSE;
		};
	}

}
