package net.fexcraft.mod.fvtm.util;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;

import net.fexcraft.app.json.JsonHandler;
import net.fexcraft.app.json.JsonMap;

public class Config {
	
	public static ArrayList<PackFolder> packfolders = new ArrayList<>();
	
	public static void load(Path path){
		File file = new File(path.toString(), "/fvtm.json");
		JsonMap map = JsonHandler.parse(file);
		if(map.has("pack_folders")){
			map.get("pack_folders").asArray().elements().forEach(elm -> {
				if(elm.isArray()){
					packfolders.add(new PackFolder(new File(elm.asArray().get(0).string_value()), elm.asArray().get(1).bool()));
				}
				else packfolders.add(new PackFolder(new File(elm.string_value()), false));
			});
		}
	}
	
	public static record PackFolder(File file, boolean mdk){}

}
