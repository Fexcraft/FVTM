package net.fexcraft.mod.fvtm.sys.road;

import java.io.File;
import java.util.HashMap;
import java.util.UUID;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonHandler;
import net.fexcraft.app.json.JsonHandler.PrintOption;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.mc.utils.Print;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class PlacingUtils {
	
	private static final HashMap<UUID, JsonArray> UNDOCACHE = new HashMap<>();

	public static void onLogIn(EntityPlayer player){
		UNDOCACHE.put(player.getGameProfile().getId(), new JsonArray());
		load(player);
	}

	public static void onLogOut(EntityPlayer player){
		JsonArray array = UNDOCACHE.remove(player.getGameProfile().getId());
		if(array != null) save(player, array);
	}

	private static void load(EntityPlayer player){
		File root = getFileRoot(player.world, player.dimension);
		File file = new File(root, player.getGameProfile().getId().toString() + ".json");
		if(file.exists()){
			JsonMap map = JsonHandler.parse(file);
			if(!map.has("last")) return;
			UNDOCACHE.get(player.getGameProfile().getId()).add(map.getArray("last"));
		}
	}

	private static File getFileRoot(World world, int dimension) {
		File root = new File(world.getSaveHandler().getWorldDirectory(), (dimension == 0 ? "" : world.provider.getSaveFolder()) + "/fvtm/road-undo/");
		if(!root.exists()) root.mkdirs();
		return root;
	}

	private static void save(EntityPlayer player, JsonArray array){
		if(array == null || array.size() == 0) return;
		File root = getFileRoot(player.world, player.dimension);
		File file = new File(root, player.getGameProfile().getId().toString() + ".json");
		JsonMap map = new JsonMap();
		map.add("last_save", Time.getAsString(null, true));
		map.add("last", array);
		JsonHandler.print(file, map, PrintOption.FLAT);
		Print.log(String.format("Saved road placing cache for %s (%s).", player, player.getGameProfile().getId()));
	}

	public static void addEntry(EntityPlayer player, JsonMap map){
		if(!map.has("dimension")) map.add("dimension", player.dimension);
		UUID uuid = player.getGameProfile().getId();
		if(!UNDOCACHE.containsKey(uuid)) UNDOCACHE.put(uuid, new JsonArray());
		JsonArray array = UNDOCACHE.get(uuid);
		if(array.size() == 10) array.rem(0);
		array.add(map);
	}
	
	public static JsonMap getLastEntry(EntityPlayer player){
		UUID uuid = player.getGameProfile().getId();
		if(!UNDOCACHE.containsKey(uuid)) return null;
		JsonArray array = UNDOCACHE.get(uuid);
		if((array.value.isEmpty())) return null;
		return array.get(array.size() - 1).asMap();
	}
	
	public static void remLastEntry(EntityPlayer player){
		UUID uuid = player.getGameProfile().getId();
		if(!UNDOCACHE.containsKey(uuid)) return;
		JsonArray array = UNDOCACHE.get(uuid);
		if((array.value.isEmpty())) return;
		array.rem(array.size() - 1);
	}
	
}
