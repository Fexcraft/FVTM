package net.fexcraft.mod.fvtm.sys.tsign;

import java.io.File;
import java.util.HashMap;
import java.util.Map.Entry;

import com.google.gson.JsonObject;

import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.model.FRLModel;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TrafficSignLibrary {
	
	public static HashMap<String, Object> PRESETS = new HashMap<>();
	public static HashMap<String, String> BACKGROUNDS = new HashMap<>();
	public static HashMap<String, String> COMPONENTS = new HashMap<>();
	public static HashMap<String, Object> FONTS = new HashMap<>();
	public static HashMap<String, Library> LIBRARIES = new HashMap<>();
	
	public static final HashMap<String, FRLModel> MODELS = new HashMap<>();
	private static Side side;
	public static File CACHE;

	public static void initialize(Side side, File config_folder){
		CACHE = new File(config_folder, "/fvtm/cache/traffic_signs/");
		if(!CACHE.exists()) CACHE.mkdirs();
		TrafficSignLibrary.side = side;
		load(false);
	}

	public static void load(boolean reload){
		new Thread("TrafficSign-Loader"){
			@Override
			public void run(){
				Print.log("Starting TrafficSign Loader Thread");
				LIBRARIES.values().removeIf(lib -> lib.external);
				for(String str : Config.DEFAULT_TRAFFIC_SIGN_LIBRARIES){
					String[] split = str.split(";");
					if(split.length < 2) continue;
					LIBRARIES.put(split[0], new Library(split[0], split[1], true));
				}
				PRESETS.clear();
				BACKGROUNDS.clear();
				COMPONENTS.clear();
				FONTS.clear();
				for(Library lib : LIBRARIES.values()) lib.load();
				if(side.isClient()){
					loadModels();
				}
				Print.log("Stopping TrafficSign Loader Thread");
			}
		}.start();
	}
	
	@SideOnly(Side.CLIENT)
	protected static void loadModels(){
		//
	}

	public static class Library {
		
		public final String id, adress;
		public final boolean external;

		public Library(String id, String adress, boolean external){
			this.id = id;
			this.adress = adress;
			this.external = external;
		}

		public void load(){
			//
		}
		
	}
	
	public static class AddonLib extends Library {
		
		public HashMap<String, JsonObject> presets = new HashMap<>();
		public HashMap<String, String> backgrounds = new HashMap<>();
		public HashMap<String, String> components = new HashMap<>();
		public HashMap<String, JsonObject> fonts = new HashMap<>();

		public AddonLib(String id){
			super(id, null, false);
		}
		
		@Override
		public void load(){
			for(Entry<String, JsonObject> entry : presets.entrySet()) PRESETS.put(id + ":" + entry.getKey(), entry.getValue());
			for(Entry<String, String> entry : backgrounds.entrySet()) BACKGROUNDS.put(id + ":" + entry.getKey(), entry.getValue());
			for(Entry<String, String> entry : components.entrySet()) COMPONENTS.put(id + ":" + entry.getKey(), entry.getValue());
			for(Entry<String, JsonObject> entry : fonts.entrySet()) FONTS.put(id + ":" + entry.getKey(), entry.getValue());
		}
		
	}

}
