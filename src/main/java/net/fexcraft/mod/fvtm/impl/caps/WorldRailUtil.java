package net.fexcraft.mod.fvtm.impl.caps;

import java.util.TreeMap;

import net.fexcraft.mod.fvtm.blocks.rail.Connection;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;

@SuppressWarnings("unused")
public class WorldRailUtil implements WorldRailData {

	private TreeMap<ChunkPos, TreeMap<ChunkPos, TreeMap<BlockPos, Connection[]>>> rootmap = new TreeMap<>();
	private World world;
	private int dim;

	@Override
	public void setWorld(World world, int dimension){
		this.world = world; this.dim = dimension;
	}

	@Override
	public World getWorld(){
		return world;
	}

	@Override
	public int getDimension(){
		return dim;
	}

	@Override
	public NBTBase write(EnumFacing side){
		NBTTagCompound compound = new NBTTagCompound();
		//TODO
		return compound;
	}

	@Override
	public void read(EnumFacing side, NBTBase nbt){
		if(nbt == null) return;
	}

	@Override
	public Connection[] getConnectionsAt(BlockPos pos){
		ChunkPos ckpos = new ChunkPos(pos);
		
		return null;
	}

}