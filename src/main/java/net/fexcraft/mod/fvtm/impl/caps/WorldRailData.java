package net.fexcraft.mod.fvtm.impl.caps;

import net.fexcraft.mod.fvtm.blocks.rail.Connection;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface WorldRailData {
	
	public void setWorld(World world, int dimension);
	
	public World getWorld();
	
	public int getDimension();

	public NBTBase write(EnumFacing side);

	public void read(EnumFacing side, NBTBase nbt);
	
	public Connection[] getConnectionsAt(BlockPos pos);
	
}