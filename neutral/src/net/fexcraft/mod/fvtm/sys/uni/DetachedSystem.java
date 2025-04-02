package net.fexcraft.mod.fvtm.sys.uni;

import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager.Systems;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.ChunkW;
import net.fexcraft.mod.uni.world.EntityW;
import net.fexcraft.mod.uni.world.WorldW;
import net.fexcraft.mod.uni.world.WrapperHolder;

import java.io.File;
import java.util.Timer;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public abstract class DetachedSystem<S extends DetachedSystem<S, V>, V extends SysObj> {

	protected SystemRegMap<S, V> regions;
	protected WorldW world;
	protected Timer timer;
	protected File root;
	
	public DetachedSystem(WorldW world){
		this.world = world;
		root = WrapperHolder.getWorldFolder(world, "fvtm");
		regions = new SystemRegMap<>((S)this);
	}
	
	public WorldW getWorld(){
		return world;
	}

	public abstract Systems getType();
	
	public void setupTimer(long time){
		if(!hasTimer()) return;
		timer = new Timer();
		addTimerTask(time);
	}
	
	public void stopTimer(){
		if(timer != null) timer.cancel();
	}
	
	public abstract boolean hasTimer();
	
	public void addTimerTask(long time){}
	
	public File getSaveRoot(){
		return root;
	}

	public abstract String getRegFolderName();

	public abstract void unload();
	
	public abstract void onChunkLoad(ChunkW chunk);
	
	public abstract void onChunkUnload(ChunkW chunk);

	public abstract void onServerTick();

	public abstract void onClientTick();
	
	public void onTimerTick(){
		//
	}

	public void syncPlayer(EntityW entity){
		for(SystemRegion region : regions.values()){
			region.sendSync(entity);
		}
	}

	public SystemRegMap<S, V> getRegions(){
		return regions;
	}

	public void updateRegion(TagCW compound, Passenger player){
		RegionKey key = new RegionKey(compound.getIntArray("xz"));
		if(world.isClient()){
			SystemRegion<S, V> region = regions.get(key);
			if(region == null)regions.put(key, region = new SystemRegion(this, key, false));
			region.read(compound);
		}
		else{
			SystemRegion<S, V> region = regions.get(key, true);
			region.sendSync(player);
		}
	}

	//

	public abstract V create(SystemRegion<S, V> region, V3I pos);

	public V get(V3I pos){
		SystemRegion<S, V> region = regions.get(pos, false);
		return region == null ? null : region.get(pos);
	}

	public V get(V3I pos, boolean load){
		SystemRegion<S, V> region = regions.get(pos, load);
		return region.get(pos);
	}

	public V add(V3I pos){
		SystemRegion<S, V> region = regions.get(pos, true);
		return region.add(pos);
	}

	public void del(V3I pos){
		SystemRegion<S, V> region = regions.get(pos, true);
		if(region != null) region.del(pos);
	}

	//

	public abstract void writeRegion(SystemRegion<S, V> region, TagCW com);

	public abstract void readRegion(SystemRegion<S, V> region, TagCW com);

}
