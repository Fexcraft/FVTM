package net.fexcraft.mod.fvtm.util;

import net.fexcraft.mod.uni.Pos;
import net.minecraft.util.math.Vec3d;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class AnotherUtil {

	public static Vec3d toV3(Pos pos){
		if(pos == null) return new Vec3d(0, 0, 0);
		return new Vec3d(pos.x16, pos.y16, pos.z16);
	}

	private static String prefix(String prefix){
		return prefix == null ? "" : prefix + "_";
	}

}
