package net.fexcraft.mod.fvtm.sys.uni;

import net.fexcraft.lib.common.math.V3I;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class SystemRegMap<R extends DetachedSystem<R, V>, V extends SysObj> extends ConcurrentHashMap<RegionKey, SystemRegion<R, V>> {

	private Function<RegionKey, SystemRegion<R, V>> function;
	private R system;

	public SystemRegMap(R sys, Function<RegionKey, SystemRegion<R, V>> func){
		system = sys;
		function = func;
	}

	public SystemRegion<R, V> get(int x, int z){
		for(SystemRegion<R, V> reg : values()){
			if(x == reg.key.x && z == reg.key.z) return reg;
		}
		return null;
	}

	public SystemRegion<R, V> get(int[] xz){
		for(SystemRegion<R, V> reg : values()){
			if(xz[0] == reg.key.x && xz[1] == reg.key.z) return reg;
		}
		return null;
	}

	public SystemRegion<R, V> get(V3I pos, boolean load){
		SystemRegion<R, V> region = get(RegionKey.getRegionXZ(pos));
		if(region != null || !load) return region;
		region = function.apply(new RegionKey(RegionKey.getRegionXZ(pos)));
		put(region.key, region);
		region.load().sendSync(pos);
		return region;
	}

	public <C extends SystemRegion<R, V>> C getC(V3I pos, boolean load){
		return (C)get(pos, load);
	}

	public SystemRegion<R, V> get(int[] xz, boolean load){
		SystemRegion<R, V> region = get(xz);
		if(region != null || !load) return region;
		region = function.apply(new RegionKey(xz[0], xz[1]));
		put(region.key, region);
		return region.load();
	}

	public <C extends SystemRegion<R, V>> C getC(int[] xz, boolean load){
		return (C)get(xz, load);
	}

	public SystemRegion<R, V> get(RegionKey xz, boolean load){
		SystemRegion<R, V> region = get(xz.x, xz.z);
		if(region != null || !load) return region;
		region = function.apply(xz);
		put(region.key, region);
		return region.load();
	}

	public <C extends SystemRegion<R, V>> C getC(RegionKey xz, boolean load){
		return (C)get(xz, load);
	}

}
