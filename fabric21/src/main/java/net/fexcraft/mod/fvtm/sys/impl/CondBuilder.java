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
		return CondBuilderRoot.run();
	}

}
