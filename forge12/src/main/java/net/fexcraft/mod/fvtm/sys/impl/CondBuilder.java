package net.fexcraft.mod.fvtm.sys.impl;

import java.util.function.Function;

import net.fexcraft.mod.fvtm.sys.condition.*;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import static net.fexcraft.mod.fvtm.sys.condition.ConditionRegistry.COND_FALSE;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class CondBuilder {

	public static Function<CondKey, Conditional> run(){
		return CondBuilderRoot.run();
	}
}
