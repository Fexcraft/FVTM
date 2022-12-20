package net.fexcraft.mod.fvtm.sys.road;

import java.io.File;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonHandler;
import net.fexcraft.app.json.JsonHandler.PrintOption;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonObject;
import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.minecraft.entity.player.EntityPlayer;

public class PlacingUtils {
	
	private static final ConcurrentHashMap<UUID, HashMap<Integer, JsonArray>> UNDOCACHE = new ConcurrentHashMap<>();

	public static void onLogIn(EntityPlayer player){
		new Thread(() -> { load(player); }, "PlacingUtils.LOAD").start();;
	}

	public static void onLogOut(EntityPlayer player){
		HashMap<Integer, JsonArray> array = UNDOCACHE.remove(player.getGameProfile().getId());
		if(array != null) save(player, array);
	}

	private static void load(EntityPlayer player){
		UNDOCACHE.put(player.getGameProfile().getId(), new HashMap<>());
		File file = new File(getFileRoot(), player.getGameProfile().getId().toString() + ".json");
		if(!file.exists()) return;
		JsonMap map = JsonHandler.parse(file);
		if(!map.has("dims")) return;
		for(JsonObject<?> o : map.getArray("dims").value){
			int i = o.integer_value();
			if(!map.has("dim" + i)) continue;
			UNDOCACHE.get(player.getGameProfile().getId()).put(i, map.getArray("dim" + i));
		}
	}

	private static File getFileRoot(){
		File root = new File(Static.getServer().getEntityWorld().getSaveHandler().getWorldDirectory(), "/fvtm/road-undo/");
		if(!root.exists()) root.mkdirs();
		return root;
	}

	private static void save(EntityPlayer player, HashMap<Integer, JsonArray> map){
		if(map == null || map.size() == 0) return;
		File file = new File(getFileRoot(), player.getGameProfile().getId().toString() + ".json");
		JsonMap jmap = new JsonMap();
		JsonArray dims = new JsonArray();
		for(Entry<Integer, JsonArray> entry : map.entrySet()){
			dims.add(entry.getKey());
			jmap.add("dim" + entry.getKey(), entry.getValue());
		}
		jmap.add("dims", dims);
		jmap.add("last_save", Time.getAsString(null, true));
		JsonHandler.print(file, jmap, PrintOption.FLAT);
		Print.log(String.format("Saved road placing cache for %s (%s).", player, player.getGameProfile().getId()));
	}

	public static void addEntry(EntityPlayer player, JsonMap map){
		UUID uuid = player.getGameProfile().getId();
		if(!UNDOCACHE.containsKey(uuid)) UNDOCACHE.put(uuid, new HashMap<>());
		if(!UNDOCACHE.get(uuid).containsKey(player.dimension)) UNDOCACHE.get(uuid).put(player.dimension, new JsonArray());
		JsonArray array = UNDOCACHE.get(uuid).get(player.dimension);
		while(array.size() >= 10) array.rem(0);
		array.add(map);
	}
	
	public static JsonMap getLastEntry(EntityPlayer player){
		UUID uuid = player.getGameProfile().getId();
		if(!UNDOCACHE.containsKey(uuid)) return null;
		if(!UNDOCACHE.get(uuid).containsKey(player.dimension)) return null;
		JsonArray array = UNDOCACHE.get(uuid).get(player.dimension);
		if(array.empty()) return null;
		return array.get(array.size() - 1).asMap();
	}
	
	public static void remLastEntry(EntityPlayer player){
		UUID uuid = player.getGameProfile().getId();
		if(!UNDOCACHE.containsKey(uuid)) return;
		if(!UNDOCACHE.get(uuid).containsKey(player.dimension)) return;
		JsonArray array = UNDOCACHE.get(uuid).get(player.dimension);
		if(array.empty()) return;
		array.rem(array.size() - 1);
	}
	
}
