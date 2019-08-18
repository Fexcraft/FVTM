package net.fexcraft.mod.fvtm.sys.rail;

import java.io.File;
import java.util.HashMap;

import net.fexcraft.mod.fvtm.data.RailSystem;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class RailData implements RailSystem {
	
	private World world;
	private int dimension;
	//
	private RegionMap regions = new RegionMap();
	//private HashMap<String, Object> sections = new HashMap<>();

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
	public NBTBase write(EnumFacing side){ //TODO
		return new NBTTagCompound();
	}

	@Override
	public void read(EnumFacing side, NBTTagCompound compound){ //TODO
		//
	}
	
	public static class RegionMap extends HashMap<XZK, RailRegion> {
		
		public RailRegion get(int x, int z){
			for(XZK key : keySet()){
				if(x == key.x && z == key.z) return get(key);
			} return null;
		}
		
		public RailRegion get(int[] xz){
			for(XZK key : keySet()){
				if(xz[0] == key.x && xz[1] == key.z) return get(key);
			} return null;
		}
		
		public RailRegion get(int[] xz, boolean load){
			RailRegion region = get(xz); if(region != null || !load) return region;
			//TODO load region
			return null;
		}
		
	}
	
	public static class XZK implements Comparable<XZK> {
		
		public final int x, z;
		
		public XZK(int x, int z){
			this.x = x; this.z = z;
		}
		
		@Override
		public boolean equals(Object obj){
			if(obj instanceof XZK == false) return false;
			return ((XZK)obj).x == x && ((XZK)obj).z == z;
		}
		
		@Override
		public int compareTo(XZK key){
			if(key.x > x) return 1; else if(key.x < x) return -1;
			if(key.z > z) return 1; else if(key.z < z) return -1;
			return 0;
		}
		
	}
	
	public static int[] getRegionXZ(int cx, int cz){
		return new int[]{(int)Math.floor(cx / 32.0), (int)Math.floor(cz / 32.0)};
	}
	
	public static int[] getRegionXZ(Vec316f vec){
		return getRegionXZ((int)vec.pos.getX() >> 4, (int)vec.pos.getZ() >> 4);
	}
	
	public RegionMap getRegions(){
		return regions;
	}

	@Override
	public Junction getJunction(Vec316f vec){
		RailRegion region = regions.get(getRegionXZ(vec));
		if(region == null) return null; return region.getJunction(vec);
	}

	@Override
	public void scheduledCheck(){
		//TODO
	}

	@Override
	public void updateTick(){
		for(RailRegion region : regions.values()){
			region.updateTick();
		}
	}

	@Override
	public File getRootFile(){
		if(dimension != 0){ return new File(world.getSaveHandler().getWorldDirectory(), world.provider.getSaveFolder() + "/fvtm"); }
		return new File(world.getSaveHandler().getWorldDirectory(), "/fvtm");
	}

}
