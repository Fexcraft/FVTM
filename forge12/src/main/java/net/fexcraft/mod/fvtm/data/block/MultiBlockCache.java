package net.fexcraft.mod.fvtm.data.block;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * @author Ferdinand Calo' (FEX___96)
 * 
 * Capability to hold quick accessible links to multiblocks (/cores).
 */
public interface MultiBlockCache {

	public void setWorld(World world);
	
	public void registerMultiBlock(BlockPos posfrom, EnumFacing rotation, MultiBlockData data);

	public void unregisterMultiBlock(BlockPos pos, EnumFacing byIndex, MultiBlockData data);
	
	public MultiBlockData getMultiBlock(BlockPos pos);

	public BlockPos getMultiBlockCore(BlockPos pos);

}
