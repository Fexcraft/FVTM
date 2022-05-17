package net.fexcraft.mod.fvtm.util;

import java.io.File;
import java.util.ArrayList;

import net.fexcraft.app.json.JsonHandler;
import net.fexcraft.app.json.JsonHandler.PrintOption;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.fvtm.data.addon.AddonLocation;

public class Config {
	
	public static ArrayList<PackFolder> packfolders = new ArrayList<>();
	public static boolean LOAD_LITE_FROM_MODS;
	public static int RAIL_PLACING_GRID = 0;
	
	public static void load(File root){
		File file = new File(root, "/fvtm.json");
		if(!file.exists()) JsonHandler.print(file, new JsonMap(), PrintOption.SPACED);
		JsonMap map = JsonHandler.parse(file);
		if(map.has("pack_folders")){
			map.get("pack_folders").asArray().elements().forEach(elm -> {
				if(elm.isArray()){
					packfolders.add(new PackFolder(new File(elm.asArray().get(0).string_value()), elm.asArray().get(1).bool()));
				}
				else packfolders.add(new PackFolder(new File(elm.string_value()), false));
			});
		}
		LOAD_LITE_FROM_MODS = map.getBoolean("load_litepacks_from_mods", true);
		RAIL_PLACING_GRID = map.getInteger("rail_placing_grid", 2);
	}
	
	public static record PackFolder(File file, boolean mdk){

		public AddonLocation addonloc(){
			return mdk() ? AddonLocation.MDK : AddonLocation.LITEPACK;
		}
		
	}

}
