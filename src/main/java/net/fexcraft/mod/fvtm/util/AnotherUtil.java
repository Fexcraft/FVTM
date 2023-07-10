package net.fexcraft.mod.fvtm.util;

import net.fexcraft.mod.uni.Pos;
import net.minecraft.nbt.NBTTagCompound;
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

	public static void toNBT(Pos pos, String key, NBTTagCompound compound){
		if(compound == null) compound = new NBTTagCompound();
		key = prefix(key);
		compound.setFloat(key + "x", pos.x);
		compound.setFloat(key + "y", pos.y);
		compound.setFloat(key + "z", pos.z);
	}

	public static Pos frNBT(String key, NBTTagCompound compound){
		return new Pos(compound.getFloat(key = prefix(key) + "x"), compound.getFloat(key + "y"), compound.getFloat(key + "z"));
	}

}
