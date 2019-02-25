package net.fexcraft.mod.fvtm.sys.rail.cap;

import java.util.Map;

import net.fexcraft.mod.fvtm.api.Gauge;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.blocks.rail.JunctionTileEntity;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailRegion;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/** @author Ferdinand Calo' (FEX___96) **/
public interface WorldRailData {

	public void setWorld(World world, int dimension);
	
	public World getWorld();
	
	public int getDimension();

	public NBTBase write(EnumFacing side);

	public void read(EnumFacing side, NBTBase nbt);
	
	/** To be called from a tick handler or something. */
	public void checkForInactive();

	public void onUnload();

	public void updateRegion(int x, int z, NBTTagCompound nbt);

	public void unloadRegion(int x, int z);

	public void doTask(String string, int[] reg, NBTTagCompound packet);

	public void toggleSwitch(BlockPos pos, boolean type);
	
	public void updateTick();

	public void addJunction(Gauge gauge, BlockPos start, BlockPos end, BlockPos[] arr);

	public void delJunction(BlockPos pos);

	public Junction getJunction(BlockPos pos);

	public void setTileData(JunctionTileEntity junctionTileEntity, boolean fromtile);
	
	/** Mainly for client side, to prevent concurrent errors on rendering. */
	public boolean isLoading();

	public void spawnEntity(VehicleData data, Junction junk);

	public Map<WorldRailImpl.XZKey, RailRegion> getRegions();
	
}