package net.fexcraft.mod.fvtm.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Optional;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.api.Addon;

public class AddonList {
	
	private static AddonList instance;
	private ArrayList<Entry> cache = new ArrayList<>();

	public static void load(){
		if(instance != null) return;
		instance = new AddonList();
		JsonObject obj = JsonUtil.get(new File("./config/fvtm_addons.json"));
		if(obj.has("entries")){
			obj.get("entries").getAsJsonArray().forEach(elm -> {
				JsonObject jsn = elm.isJsonObject() ? elm.getAsJsonObject() : null;
				if(jsn != null && jsn.has("name")){
					instance.cache.add(new Entry(elm.getAsJsonObject()));
				}
			});
		}
		if(!obj.has("format")) obj.addProperty("format", 1);
		//JsonUtil.write(file, obj);
	}

	public static boolean isAddonContainer(String parent, File file){
		Entry entry = getEntry(parent, file); return entry == null ? false : entry.addon && entry.enabled;
	}
	
	public static class Entry {
		
		public Entry(JsonObject obj){
			enabled = JsonUtil.getIfExists(obj, "enabled", true);
			addon = JsonUtil.getIfExists(obj, "addon", true);
			filename = JsonUtil.getIfExists(obj, "name", "null.name");
			//hash = JsonUtil.getIfExists(obj, "hash", "null.hash");
			parent = JsonUtil.getIfExists(obj, "parent", "null.parent");
		}

		public boolean enabled, addon;
		public String filename, parent;
		
		@Override
		public boolean equals(Object obj){
			if(obj instanceof Entry == false) return false;
			return ((Entry)obj).filename.equals(filename) && ((Entry)obj).parent.equals(parent);
		}
		
		public boolean equals(String parent, File file){
			return this.parent.equals(parent) && file.getName().equals(filename);
		}
		
		public Entry(String folder, File file){
			addon = Addon.isAddonContainer(file);
			enabled = addon ? true : false;
			filename = file.getName(); parent = folder;
		}

		public JsonObject toJsonObject(){
			JsonObject obj = new JsonObject();
			obj.addProperty("addon", addon);
			if(addon) obj.addProperty("enabled", enabled);
			obj.addProperty("name", filename);
			obj.addProperty("parent", parent);
			return obj;
		}
		
	}

	public static void checkFolder(File folder, String id){
		if(!folder.exists() || !folder.isDirectory()) return;
		if(instance == null) load();
		Print.debug(folder, id);
		Entry entry = null;
		for(int i = 0; i < instance.cache.size(); i++){
			entry = instance.cache.get(i);
			if(entry.parent.equals(id) && !new File("." + entry.parent + entry.filename).exists()){
				instance.cache.remove(i);
			}
		}
		//
		for(File file : folder.listFiles()){
			if(file.isDirectory() && !Addon.isAddonContainer(file)) continue;
			entry = getEntry(id, file);
			if(entry == null){
				instance.cache.add(new Entry(id, file));
			}
		}
	}
	
	private static Optional<Entry> optional;

	private static Entry getEntry(String id, File file){
		return (optional = instance.cache.stream().filter(pre -> pre.equals(id, file)).findFirst()).isPresent() ? optional.get() : null;
	}

	public static void save(){
		if(instance == null) return;
		if(instance.cache.isEmpty()) return;
		JsonObject obj = new JsonObject();
		obj.addProperty("format", 1);
		JsonArray array = new JsonArray();
		instance.cache.forEach(entry -> array.add(entry.toJsonObject()));
		obj.add("entries", array);
		JsonUtil.write(new File("./config/fvtm_addons.json"), obj);
	}

	public static void setEnabled(Addon addon){
		// TODO Auto-generated method stub
		
	}

	public static void updateAddon(Addon addon){
		if(addon.getFile() == null) return;
		Optional<Entry> entry = instance.cache.stream().filter(pre -> pre.filename.equals(addon.getFile().getName())).findFirst();
		if(entry.isPresent()){ entry.get().enabled = addon.isEnabled(); }
	}
	
}