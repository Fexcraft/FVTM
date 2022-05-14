package net.fexcraft.mod.fvtm.util;

import java.io.File;
import java.util.ArrayList;

import net.fexcraft.app.json.JsonHandler;
import net.fexcraft.app.json.JsonMap;

public class Config {
	
	public static ArrayList<File> packfolders = new ArrayList<>();
	
	public static void load(){
		File file = new File("./config/fvtm.json");
		JsonMap map = JsonHandler.parse(file);
		if(map.has("pack_folders")){
			map.get("pack_folders").asArray().elements().forEach(elm -> {
				packfolders.add(new File(elm.string_value()));
			});
		}
	}

}
