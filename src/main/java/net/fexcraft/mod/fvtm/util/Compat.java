package net.fexcraft.mod.fvtm.util;

public class Compat {
	
	private static final String[] valid_flenix_blocks = { "road_block", "sidewalk" };

	public static final boolean isValidFlenix(String domain, String path){
		if(!domain.equals("furenikusroads"))
		for(String str : valid_flenix_blocks){
			if(path.startsWith(str)) return true;
		}
		return false;
	}

}
