package net.fexcraft.mod.fvtm.data;

import net.fexcraft.mod.fvtm.sys.road.RoadSys;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

/** @author Ferdinand Calo' (FEX___96) **/
public interface RoadSystem {

	public void setWorld(World world, int dimension);
	
	public World getWorld();
	
	public int getDimension();

	public NBTBase write(EnumFacing side);

	public void read(EnumFacing side, NBTTagCompound compound);
	
	/** For timed tasks, do not use this one. */
	public void scheduledCheck();
	
	public void updateTick();

	public void unload();

	public void onChunkLoad(Chunk chunk);
	
	public void onChunkUnload(Chunk chunk);
	
	public default RoadSys get(){
		return (RoadSys)this;
	}
	
}