package net.fexcraft.mod.fvtm.prototype;

import java.io.File;
import java.util.Map.Entry;
import java.util.TreeMap;

import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.blocks.rail.Connection;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;

/** @author Ferdinand Calo' (FEX___96) */
@SuppressWarnings("unused")
public class WorldRailUtil implements WorldRailData {

	private DynamicRegionMap map = new DynamicRegionMap(this);
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
		File root = this.getRootFile();
		if(!root.exists()){ root.mkdirs(); }
		//
		
		//
		NBTTagCompound compound = new NBTTagCompound();
		compound.setLong("LastSave", Time.getDate());
		return compound;
	}

	@Override
	public void read(EnumFacing side, NBTBase nbt){
		if(!getRootFile().exists()) return;
		if(nbt == null) return;
	}
	
	public static int[] getRegion(int x, int z){
		return new int[]{(int)Math.floor(x / 32.0), (int)Math.floor(z / 32.0)};
	}
	
	public static int[] getRegion(BlockPos pos){
		return getRegion(pos.getX() >> 4, pos.getZ() >> 4);
	}

	@Override
	public Connection[] getConnectionsAt(BlockPos pos){
		RailRegion reg = map.get(getRegion(pos));
		if(reg == null) return new Connection[0];
		return reg.getConnectionsAt(pos);
	}
	
	public File getRootFile(){
		if(dim != 0){
			return new File(world.getSaveHandler().getWorldDirectory(), world.provider.getSaveFolder() + "/fvtm");
		}
		return new File(world.getSaveHandler().getWorldDirectory(), "/fvtm");
	}
	
	public static class DynamicRegionMap extends TreeMap<int[], RailRegion> {
		
		private WorldRailUtil util;

		public DynamicRegionMap(WorldRailUtil util){
			this.util = util;
		}
		
		public RailRegion getRegion(int[] reg){
			RailRegion region = this.get(reg);
			if(region != null) return region;
			else{
				//TODO check if qualifies for load
				this.put(reg, new RailRegion(util, reg[0], reg[1]));
				return this.get(reg);
			}
		}
		
	}

	@Override
	public void checkForInactive(){
		final long date = Time.getDate();
		for(Entry<int[], RailRegion> entry : map.entrySet()){
			if(entry.getValue().lastaccessed + Time.MIN_MS < date){
				unloadRegion(entry.getKey());
			}
		}
	}

	private void unloadRegion(int[] key){
		RailRegion reg = map.remove(key);
		if(reg == null) return; reg.save(this);
	}

	@Override
	public void onUnload(){
		for(Entry<int[], RailRegion> entry : map.entrySet()){
			unloadRegion(entry.getKey());
		}
	}

}