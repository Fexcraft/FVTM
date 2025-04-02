package net.fexcraft.mod.fvtm.sys.uni;

import net.fexcraft.lib.common.math.V3I;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class SystemRegMap<R extends DetachedSystem<R, V>, V extends SysObj> extends ConcurrentHashMap<RegionKey, SystemRegion<R, V>> {

	private R system;

	public SystemRegMap(R sys){
		system = sys;
	}

	public SystemRegion<R, V> get(int x, int z){
		for(RegionKey key : keySet()){
			if(x == key.x && z == key.z) return get(key);
		}
		return null;
	}

	public SystemRegion<R, V> get(int[] xz){
		for(RegionKey key : keySet()){
			if(xz[0] == key.x && xz[1] == key.z) return get(key);
		}
		return null;
	}

	public SystemRegion<R, V> get(V3I pos, boolean load){
		SystemRegion<R, V> region = get(RegionKey.getRegionXZ(pos));
		if(region != null || !load) return region;
		put(new RegionKey(RegionKey.getRegionXZ(pos)), region = new SystemRegion<>(system, new RegionKey(RegionKey.getRegionXZ(pos)), false));
		region.load().sendSync(pos);
		return region;
	}

	public SystemRegion<R, V> get(int[] xz, boolean load){
		SystemRegion<R, V> region = get(xz);
		if(region != null || !load) return region;
		put(new RegionKey(xz), region = new SystemRegion<>(system, new RegionKey(xz[0], xz[1]), false));
		return region.load();
	}

	public SystemRegion<R, V> get(RegionKey xz, boolean load){
		SystemRegion<R, V> region = get(xz);
		if(region != null || !load) return region;
		put(new RegionKey(xz.x, xz.z), region = new SystemRegion<>(system, new RegionKey(xz.x, xz.z), false));
		return region.load();
	}

}
