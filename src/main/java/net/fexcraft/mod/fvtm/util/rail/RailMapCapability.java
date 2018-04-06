package net.fexcraft.mod.fvtm.util.rail;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;

public interface RailMapCapability {

	public NBTBase writeToNBT(Capability<RailMapCapability> capability, EnumFacing side);

	public void readFromNBT(Capability<RailMapCapability> capability, EnumFacing side, NBTBase nbt);

	public void setWorld(World world);
	
	public World getWorld();
	
	public Vec3d getNearestRailPosition(Vec3d vehpos);
	
	public Vec3d getSupposedPosition(Vec3d vehpos, double expected_distance, boolean direction);
	
}