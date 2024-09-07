package net.fexcraft.mod.fvtm.sys.impl;

import net.fexcraft.mod.fvtm.sys.condition.*;

import java.util.function.Function;

import static net.fexcraft.mod.fvtm.sys.condition.ConditionRegistry.COND_FALSE;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class CondBuilder {

	public static Function<Condition, Conditional> run(){
		Function<Condition, Conditional> con = CondBuilderRoot.run();
		if(con != null) return con;
		return cond -> {
			switch(cond.type){
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
