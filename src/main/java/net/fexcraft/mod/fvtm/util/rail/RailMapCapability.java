package net.fexcraft.mod.fvtm.util.rail;

import net.fexcraft.mod.fvtm.blocks.RailTileEntity;
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
	
	public RailPiece getNearestRailPosition(Vec3d vehpos);
	
	public RailPiece getNextRailPosition(RailPiece curr, RailPiece prev);

	public RailPiece getRailPositionAt(Vec3d prev);

	public void updateRailPositions(RailTileEntity railte);
	
}