package net.fexcraft.mod.fvtm.data;

import java.io.File;

import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.Vec316f;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

/** @author Ferdinand Calo' (FEX___96) **/
public interface RailSystem {

	public void setWorld(World world, int dimension);
	
	public World getWorld();
	
	public int getDimension();

	public NBTBase write(EnumFacing side);

	public void read(EnumFacing side, NBTTagCompound compound);

	public Junction getJunction(Vec316f object);
	
	/** For timed tasks, do not use this one. */
	public void scheduledCheck();
	
	public void updateTick();
	
	/** WorldSave/fvtm folder. */
	public File getRootFile();
	
}