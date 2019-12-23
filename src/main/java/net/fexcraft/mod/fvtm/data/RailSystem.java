package net.fexcraft.mod.fvtm.data;

import java.io.File;

import net.fexcraft.mod.fvtm.sys.rail.RailSys;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

/** @author Ferdinand Calo' (FEX___96) **/
public interface RailSystem {

	public void setWorld(World world, int dimension);
	
	public World getWorld();
	
	public int getDimension();

	public NBTBase write(EnumFacing side);

	public void read(EnumFacing side, NBTTagCompound compound);

	/*public Junction getJunction(Vec316f object);
	
	public Junction getJunction(Vec316f vector, boolean load);

	public boolean delJunction(Vec316f vector);
	
	public void updateJuncton(Vec316f vector);

	public void addJunction(Vec316f vector);
	
	public boolean delTrack(Track track, boolean remjunk);
	
	public Track getTrack(TrackKey trackKey);
	
	/** For timed tasks, do not use this one. */
	public void scheduledCheck();
	
	public void updateTick(boolean remote);
	
	/** WorldSave/fvtm folder. */
	public File getRootFile();

	public void unload();

	public void onChunkLoad(Chunk chunk);
	
	public void onChunkUnload(Chunk chunk);

	/*public void registerEntity(RailEntity railentity);
	
	/** Update the last region this entity was seen/active in. */
	/*public void updateEntityEntry(long uid, int x, int z);
	public void updateEntityEntry(long uid, RegionKey key);
	
	public RailEntity getEntity(long uid, boolean load);

	public void delEntity(RailEntity railentity);*/
	
	public default RailSys get(){
		return (RailSys)this;
	}
	
}