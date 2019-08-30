package net.fexcraft.mod.fvtm.data;

import java.io.File;
import java.util.UUID;

import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailEntity;
import net.fexcraft.mod.fvtm.sys.rail.Track;
import net.fexcraft.mod.fvtm.util.Vec316f;
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

	public Junction getJunction(Vec316f object);
	
	public Junction getJunction(Vec316f vector, boolean load);

	public boolean delJunction(Vec316f vector);
	
	public boolean delTrack(Track track);

	public void addJunction(Vec316f vector);
	
	/** For timed tasks, do not use this one. */
	public void scheduledCheck();
	
	public void updateTick();
	
	/** WorldSave/fvtm folder. */
	public File getRootFile();

	public void unload();

	public void onChunkLoad(Chunk chunk);
	
	public void onChunkUnload(Chunk chunk);
	
	public boolean registerEntity(RailEntity entity);
	
	/** Update the last region this entity was seen/active in. */
	public void updateEntityEntry(UUID uuid, int x, int z);
	
	public RailEntity getEntity(UUID uuid, boolean load);
	
}