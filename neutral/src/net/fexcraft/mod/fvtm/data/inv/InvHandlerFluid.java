package net.fexcraft.mod.fvtm.data.inv;

import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.EntityW;
import net.fexcraft.mod.uni.world.WorldW;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public abstract class InvHandlerFluid extends InvHandler {

	public static Class<? extends InvHandlerFluid> IMPL = InvHandlerFluid.class;

	public InvHandlerFluid(int cap){
		super(InvType.FLUID);
		capacity = cap;
	}

	@Override
	public String getSavePrefix(){
		return "tank-";
	}

}
