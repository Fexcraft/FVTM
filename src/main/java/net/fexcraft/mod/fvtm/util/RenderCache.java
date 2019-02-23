package net.fexcraft.mod.fvtm.util;

import java.util.TreeMap;

import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.minecraft.entity.Entity;

@Deprecated
public class RenderCache {
	
	//I tried a Guava Table, but it was relatively unreliable, somehow.
	private static final TreeMap<Long, TreeMap<String, Float>> cache = new TreeMap<>();

	public static void removeEntity(Entity ent){
		removeEntity(ent.getEntityId());
	}
	
	public static void removeEntity(long ent){
		Print.debug(cache);
		cache.remove(ent);
		Print.debug(cache);
	}
	
	public static final float getData(Entity ent, String id, float def){
		return getData(ent.getEntityId(), id, def);
	}
	
	public static final float getData(VehicleEntity ent, String id, float def){
		return getData(ent.getEntity().getEntityId(), id, def);
	}

	public static final float getData(long ent, String id, float def){
		if(!cache.containsKey(ent)){
			cache.put(ent, new TreeMap<>());
		}
		if(!cache.get(ent).containsKey(id)){
			cache.get(ent).put(id, def);
		}
		return cache.get(ent).get(id);
	}
	
	public static final float updateData(Entity ent, String id, float data){
		return updateData(ent.getEntityId(), id, data);
	}
	
	public static final float updateData(VehicleEntity ent, String id, float data){
		return updateData(ent.getEntity().getEntityId(), id, data);
	}
	
	public static final float updateData(long ent, String id, float data){
		if(!cache.containsKey(ent)){
			cache.put(ent, new TreeMap<>());
		}
		Float fl = cache.get(ent).put(id, data);
		return fl == null ? 0 : fl;
	}
	
}