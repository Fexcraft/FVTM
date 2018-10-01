package net.fexcraft.mod.fvtm.util;

import net.minecraft.util.math.BlockPos;

public class PalletUtil {

	public static Integer getRotation(BlockPos pos){
		if(pos.getX() % 2 == 1 || pos.getZ() % 2 == 1) return -1;
		int x = pos.getX() % 4, z = pos.getZ() % 4;
		return x == 0 ? z == 0 ? 0 : 3 : z == 0 ? 1 : 2;
	}
	
	public static Integer getRotationForBlock(BlockPos pos){
		int x = getRotation(pos); return x <= -1 ? 0 : x; 
	}
	
}