package net.fexcraft.mod.fvtm.sys.impl;

import net.fexcraft.mod.fvtm.sys.condition.Condition;
import net.fexcraft.mod.fvtm.sys.condition.Conditional;

import java.util.function.Function;

public class CondBuilder {

	public static Function<Condition, Conditional> run(){
		return cond -> null;
	}

}
