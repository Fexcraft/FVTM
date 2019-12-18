package net.fexcraft.mod.fvtm.sys.road;

import java.util.TimerTask;

import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.RoadSystem;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public class RoadSys implements RoadSystem {
	
	private World world;
	private int dimension;

	@Override
	public void setWorld(World world, int dimension){
		this.world = world; this.dimension = dimension;
	}

	@Override
	public World getWorld(){
		return world;
	}

	@Override
	public int getDimension(){
		return dimension;
	}

	@Override
	public NBTBase write(EnumFacing side){
		return new NBTTagCompound();
	}

	@Override
	public void read(EnumFacing side, NBTTagCompound compound){
		//
	}

	@Override
	public void scheduledCheck(){
		//
	}

	@Override
	public void updateTick(){
		//
	}

	@Override
	public void unload(){
		//
	}

	@Override
	public void onChunkLoad(Chunk chunk){
		//
	}

	@Override
	public void onChunkUnload(Chunk chunk){
		//
	}

	public static class TimedTask extends TimerTask {

		@Override
		public void run(){
			for(World world : Static.getServer().worlds){
				if(world.isRemote) return; world.getCapability(Capabilities.RAILSYSTEM, null).scheduledCheck();
			}
		}

	}

}
