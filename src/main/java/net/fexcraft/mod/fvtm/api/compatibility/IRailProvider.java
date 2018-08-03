package net.fexcraft.mod.fvtm.api.compatibility;

import net.minecraft.util.math.BlockPos;

public interface IRailProvider {
	
	public BlockPos getNext(BlockPos current, BlockPos previous);
	
}