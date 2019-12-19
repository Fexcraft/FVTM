package net.fexcraft.mod.fvtm.sys.road;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TimerTask;

import javax.annotation.Nullable;

import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.RoadSystem;
import net.fexcraft.mod.fvtm.sys.uni.RegionKey;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public class RoadSys implements RoadSystem {
	
	private RegionMap regions = new RegionMap(this);
	private long gc_entities, gc_sections;
	private int dimension;
	private World world;

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
		NBTTagCompound compound = new NBTTagCompound();
		compound.setLong("GlobalCounterEntities", gc_entities);
		compound.setLong("GlobalCounterSections", gc_sections);
		return compound;
	}

	@Override
	public void read(EnumFacing side, NBTTagCompound compound){
		if(compound == null || compound.hasNoTags()) return;
		gc_entities = compound.getLong("GlobalCounterEntities");
		gc_sections = compound.getLong("GlobalCounterSections");
	}

	@Override
	public void scheduledCheck(){
		ArrayList<Region> regs = new ArrayList<>();
		for(Region region : regions.values()){
			if(region.chucks.isEmpty() && region.lastaccessed < Time.getDate() - 60000) regs.add(region);
		}
		for(Region region : regs){
			region.save(); regions.remove(region.getKey());
		}
	}

	@Override
	public void updateTick(){
		for(Region region : regions.values()){ region.updateTick(); }
	}

	@Override
	public void unload(){
		if(!world.isRemote) regions.values().forEach(reg -> reg.save()); regions.clear();
	}

	@Override
	public void onChunkLoad(Chunk chunk){
		regions.get(RegionKey.getRegionXZ(chunk.x, chunk.z), true).chucks.add(new RegionKey(chunk.x, chunk.z));
	}

	@Override
	public void onChunkUnload(Chunk chunk){
		regions.get(RegionKey.getRegionXZ(chunk.x, chunk.z), true).chucks.removeIf(pre -> pre.x == chunk.x && pre.z == chunk.z);
	}

	public static class TimedTask extends TimerTask {

		@Override
		public void run(){
			for(World world : Static.getServer().worlds){
				if(world.isRemote) return; world.getCapability(Capabilities.RAILSYSTEM, null).scheduledCheck();
			}
		}

	}
	
	public static class RegionMap extends HashMap<RegionKey, Region> {
		
		private RoadSys root;
		public RegionMap(RoadSys data){ this.root = data; }
		
		public Region get(int x, int z){
			for(RegionKey key : keySet()){
				if(x == key.x && z == key.z) return get(key);
			} return null;
		}
		
		public Region get(int[] xz){
			for(RegionKey key : keySet()){
				if(xz[0] == key.x && xz[1] == key.z) return get(key);
			} return null;
		}
		
		public Region get(Vec316f vec, boolean load){
			Region region = get(RegionKey.getRegionXZ(vec)); if(region != null || !load) return region;
			put(new RegionKey(vec), region = new Region(vec, root)); return region;
		}

		public Region get(int[] xz, boolean load){
			Region region = get(xz); if(region != null || !load) return region;
			put(new RegionKey(xz), region = new Region(xz[0], xz[1], root)); return region;
		}

		public Region get(RegionKey xz, boolean load){
			Region region = get(xz); if(region != null || !load) return region;
			put(new RegionKey(xz.x, xz.z), region = new Region(xz.x, xz.z, root)); return region;
		}
		
	}
	
	public RegionMap getRegions(){
		return regions;
	}

	public File getRootFile(){
		if(dimension != 0){ return new File(world.getSaveHandler().getWorldDirectory(), world.provider.getSaveFolder() + "/fvtm"); }
		return new File(world.getSaveHandler().getWorldDirectory(), "/fvtm");
	}

	public void updateRegion(boolean isRemote, int[] xz, NBTTagCompound compound, @Nullable EntityPlayerMP player){
		if(isRemote){
			Region region = regions.get(xz); if(region == null) regions.put(new RegionKey(xz), region = new Region(xz[0], xz[1], this)); region.read(compound);
		}
		else{
			Region region = regions.get(xz, true); region.updateClient(player);
		}
	}

	public long getNewEntityId(){
		return gc_entities++;
	}

	public long getNewSectionId(){
		return gc_sections++;
	}

	public boolean isRemote(){
		return world.isRemote;
	}

	public RoadJunc getRoadPoint(Vec316f vec){
		Region region = regions.get(vec, false); return region == null ? null : region.getRoadPoint(vec);
	}

	public RoadJunc getRoadPoint(Vec316f vec, boolean load){
		Region region = regions.get(vec, load); return region.getRoadPoint(vec);
	}

	public void addRoadPoint(Vec316f vector){
		Region region = regions.get(vector, true); if(region == null) return;
		RoadJunc roadpoint = new RoadJunc(region, vector); region.getRoadPoints().put(vector, roadpoint);
		region.setAccessed().updateClient("point", vector); return;
	}

}
