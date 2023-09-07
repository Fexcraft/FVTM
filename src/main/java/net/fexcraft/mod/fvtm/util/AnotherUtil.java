package net.fexcraft.mod.fvtm.util;

import net.fexcraft.mod.uni.Pos;
import net.fexcraft.mod.uni.tag.TagCW;
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

	public static void toTag(Pos pos, String key, TagCW compound){
		if(compound == null) compound = TagCW.create();
		key = prefix(key);
		compound.set(key + "x", pos.x);
		compound.set(key + "y", pos.y);
		compound.set(key + "z", pos.z);
	}

	public static Pos frNBT(String key, TagCW compound){
		return new Pos(compound.getFloat(key = prefix(key) + "x"), compound.getFloat(key + "y"), compound.getFloat(key + "z"));
	}

}
