package net.fexcraft.mod.fvtm.impl.caps;

import java.util.Map;

import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.api.Block.BlockData;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.capabilities.Capability;

public interface BlockChunk {

	public void setChunk(Chunk chunk);
	
	public Chunk getChunk();

	public NBTBase writeToNBT(Capability<BlockChunk> capability, BlockChunk instance, EnumFacing side);

	public void readFromNBT(Capability<BlockChunk> capability, BlockChunk instance, EnumFacing side, NBTBase nbt);

	public BlockData getBlockDataFor(BlockPos corepos);
	
	public void setBlockAt(@Nullable BlockData data, BlockPos pos);

	public Map<BlockPos, BlockData> getAllBlockData();
	
}