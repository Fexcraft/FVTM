package net.fexcraft.mod.fvtm.prototype;

import java.util.Collection;

import net.fexcraft.mod.fvtm.blocks.rail.Connection;
import net.fexcraft.mod.fvtm.blocks.rail.TrackTileEntity;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface WorldRailData {
	
	public void setWorld(World world, int dimension);
	
	public World getWorld();
	
	public int getDimension();

	public NBTBase write(EnumFacing side);

	public void read(EnumFacing side, NBTBase nbt);
	
	public ConnContainer getConnectionsAt(BlockPos pos);
	
	public BlockPos getNext(BlockPos current, BlockPos previous, boolean test);
	
	/** To be called from a tick handler or something. */
	public void checkForInactive();

	public void onUnload();

	public void resetConnectionsAt(BlockPos pos);
	
	public void addConnection(Connection conn);
	
	public void delConnection(BlockPos pos, BlockPos end);

	public void updateRegion(int x, int z, NBTTagCompound nbt);

	public void unloadRegion(int x, int z);

	public Collection<RailRegion> getLoadedRegions();

	public void setTileData(TrackTileEntity trackTileEntity, boolean fromtile);

	public void doTask(String string, int[] reg, NBTTagCompound packet);

	public void toggleSwitch(BlockPos pos);
	
}