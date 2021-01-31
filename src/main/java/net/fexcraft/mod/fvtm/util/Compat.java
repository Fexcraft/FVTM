package net.fexcraft.mod.fvtm.util;

import net.fexcraft.mod.fvtm.block.Asphalt;
import net.fexcraft.mod.fvtm.block.generated.G_ROAD;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class Compat {
	
	private static final String[] valid_flenix_blocks = { "road_block", "sidewalk" };

	public static final boolean isValidFlenix(String domain, String path){
		if(!domain.equals("furenikusroads")) return false;
		for(String str : valid_flenix_blocks){
			if(path.startsWith(str)) return true;
		}
		return false;
	}

	public static boolean isValidFlenix(ResourceLocation regname){
		return isValidFlenix(regname.getNamespace(), regname.getPath());
	}

	public static boolean isValidFlenix(Block block){
		return isValidFlenix(block.getRegistryName());
	}

	public static boolean isValidFlenix(Item item){
		return isValidFlenix(item.getRegistryName());
	}

	public static boolean isFVTMRoad(Block block){
		return block instanceof Asphalt || block instanceof G_ROAD;
	}

	public static int getRoadHeight(int height, boolean flenix){
		if(!flenix) return height;
		return height == 0 ? 15 : height - 1;
	}

}
