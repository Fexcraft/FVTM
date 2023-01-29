package net.fexcraft.mod.fvtm.sys.road;

import java.util.Date;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import com.mojang.authlib.GameProfile;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.minecraft.entity.player.EntityPlayer;

public class RoadPlacingCache {
	
	private static final ConcurrentHashMap<UUID, HashMap<Integer, JsonArray>> UNDOCACHE = new ConcurrentHashMap<>();

	public static void onLogIn(EntityPlayer player){
		if(Config.ROAD_UNDO_CACHE_SIZE == 0) return;
		UNDOCACHE.put(player.getGameProfile().getId(), new HashMap<>());
	}

	public static void onLogOut(EntityPlayer player){
		if(Config.ROAD_UNDO_CACHE_SIZE == 0) return;
		if(Config.ROAD_UNDO_CACHE_CLEARTIME == 0) UNDOCACHE.remove(player.getGameProfile().getId());
		else {
			UUID uuid = player.getGameProfile().getId();
			new Timer().schedule(new TimerTask(){
				@Override
				public void run(){
					for(GameProfile prof : Static.getServer().getPlayerList().getOnlinePlayerProfiles()){
						if(prof.getId().equals(uuid)) return;
					}
					UNDOCACHE.remove(uuid);
				}
			}, new Date(Time.getDate() + (Config.ROAD_UNDO_CACHE_CLEARTIME * 60000)));
		}
	}

	public static void addEntry(EntityPlayer player, JsonMap map){
		if(Config.ROAD_UNDO_CACHE_SIZE == 0) return;
		UUID uuid = player.getGameProfile().getId();
		if(!UNDOCACHE.containsKey(uuid)) UNDOCACHE.put(uuid, new HashMap<>());
		if(!UNDOCACHE.get(uuid).containsKey(player.dimension)) UNDOCACHE.get(uuid).put(player.dimension, new JsonArray());
		JsonArray array = UNDOCACHE.get(uuid).get(player.dimension);
		while(array.size() >= Config.ROAD_UNDO_CACHE_SIZE) array.rem(0);
		array.add(map);
	}
	
	public static JsonMap getLastEntry(EntityPlayer player){
		if(Config.ROAD_UNDO_CACHE_SIZE == 0) return null;
		UUID uuid = player.getGameProfile().getId();
		if(!UNDOCACHE.containsKey(uuid)) return null;
		if(!UNDOCACHE.get(uuid).containsKey(player.dimension)) return null;
		JsonArray array = UNDOCACHE.get(uuid).get(player.dimension);
		if(array.empty()) return null;
		return array.get(array.size() - 1).asMap();
	}
	
	public static void remLastEntry(EntityPlayer player){
		if(Config.ROAD_UNDO_CACHE_SIZE == 0) return;
		UUID uuid = player.getGameProfile().getId();
		if(!UNDOCACHE.containsKey(uuid)) return;
		if(!UNDOCACHE.get(uuid).containsKey(player.dimension)) return;
		JsonArray array = UNDOCACHE.get(uuid).get(player.dimension);
		if(array.empty()) return;
		array.rem(array.size() - 1);
	}
	
}
