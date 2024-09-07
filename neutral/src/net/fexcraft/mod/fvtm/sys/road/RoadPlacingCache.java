package net.fexcraft.mod.fvtm.sys.road;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.Time;
import net.fexcraft.mod.uni.world.WrapperHolder;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static net.fexcraft.mod.fvtm.Config.ROAD_UNDO_CACHE_CLEARTIME;
import static net.fexcraft.mod.fvtm.Config.ROAD_UNDO_CACHE_SIZE;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RoadPlacingCache {
	
	private static final ConcurrentHashMap<UUID, HashMap<String, JsonArray>> UNDOCACHE = new ConcurrentHashMap<>();
	private static final ConcurrentHashMap<UUID, Timer> TIMERCACHE = new ConcurrentHashMap<>();

	public static void onLogIn(UUID uuid){
		if(ROAD_UNDO_CACHE_SIZE == 0) return;
		UNDOCACHE.put(uuid, new HashMap<>());
	}

	public static void onLogOut(UUID uuid){
		if(ROAD_UNDO_CACHE_SIZE == 0) return;
		if(ROAD_UNDO_CACHE_CLEARTIME == 0) UNDOCACHE.remove(uuid);
		else {
			if(TIMERCACHE.containsKey(uuid)) TIMERCACHE.get(uuid).cancel();
			Timer timer = new Timer("RoadPlacingCache/" + uuid + "/Timer");
			timer.schedule(new TimerTask(){
				@Override
				public void run(){
					List<UUID> uuids = WrapperHolder.getOnlinePlayerIDs();
					for(UUID id : uuids){
						if(id.equals(uuid)) return;
					}
					UNDOCACHE.remove(uuid);
					timer.cancel();
					TIMERCACHE.remove(uuid);
				}
			}, new Date(Time.getDate() + (ROAD_UNDO_CACHE_CLEARTIME * 60000L)));
			TIMERCACHE.put(uuid, timer);
		}
	}

	public static void addEntry(UUID uuid, String dim, JsonMap map){
		if(ROAD_UNDO_CACHE_SIZE == 0) return;
		if(!UNDOCACHE.containsKey(uuid)) UNDOCACHE.put(uuid, new HashMap<>());
		if(!UNDOCACHE.get(uuid).containsKey(dim)) UNDOCACHE.get(uuid).put(dim, new JsonArray());
		JsonArray array = UNDOCACHE.get(uuid).get(dim);
		while(array.size() >= ROAD_UNDO_CACHE_SIZE) array.rem(0);
		array.add(map);
	}

	public static void addEntry(UUID uuid, int dim, JsonMap map){
		addEntry(uuid, dim + "", map);
	}
	
	public static JsonMap getLastEntry(UUID uuid, String dim){
		if(ROAD_UNDO_CACHE_SIZE == 0) return null;
		if(!UNDOCACHE.containsKey(uuid)) return null;
		if(!UNDOCACHE.get(uuid).containsKey(dim)) return null;
		JsonArray array = UNDOCACHE.get(uuid).get(dim);
		if(array.empty()) return null;
		return array.get(array.size() - 1).asMap();
	}

	public static JsonMap getLastEntry(UUID uuid, int dim){
		return getLastEntry(uuid, dim + "");
	}
	
	public static void remLastEntry(UUID uuid, String dim){
		if(ROAD_UNDO_CACHE_SIZE == 0) return;
		if(!UNDOCACHE.containsKey(uuid)) return;
		if(!UNDOCACHE.get(uuid).containsKey(dim)) return;
		JsonArray array = UNDOCACHE.get(uuid).get(dim);
		if(array.empty()) return;
		array.rem(array.size() - 1);
	}

	public static void remLastEntry(UUID uuid, int dim){
		remLastEntry(uuid, dim + "");
	}
	
}
