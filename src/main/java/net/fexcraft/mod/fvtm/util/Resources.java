package net.fexcraft.mod.fvtm.util;

import java.io.File;
import java.util.HashMap;

import net.fexcraft.mod.fvtm.data.addon.Addon;
import net.fexcraft.mod.fvtm.data.addon.AddonLocation;
import net.fexcraft.mod.fvtm.data.root.TypeCore;
import net.fexcraft.mod.fvtm.util.Config.PackFolder;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.loading.FMLPaths;

public class Resources {
	
	public static RegistryMap<Addon> ADDONS = new RegistryMap<>();
	//
	public static final NamedResourceLocation NULL_TEXTURE = new NamedResourceLocation("No Texture;fvtm:textures/entity/null.png");
	public static final NamedResourceLocation WHITE_TEXTURE = new NamedResourceLocation("No Texture;fvtm:textures/entity/white.png");
	
	
	public static class RegistryMap<T extends TypeCore<T>> extends HashMap<ResourceLocation, T> {
		
		public void register(T obj){
			this.put(obj.getRegistryName(), obj);
		}
		
	}


	public static Addon getAddon(String string){
		for(Addon addon : ADDONS.values()){
			if(addon.getRegistryName().getPath().equals(string)) return addon;
		}
		return null;
	}


	public static void findAndLoadAddons(){
		File root = FMLPaths.GAMEDIR.get().toFile();
		searchAddonsInFolder(new File(root, "/resourcepacks/"), AddonLocation.RESOURCEPACK, false);
		searchAddonsInFolder(new File(root, "/config/fvtm/packs/"), AddonLocation.RESOURCEPACK, false);
		if(Config.LOAD_LITE_FROM_MODS) searchAddonsInFolder(new File(root, "/mods/"), AddonLocation.RESOURCEPACK, false);
		for(PackFolder file : Config.packfolders){
			//TODO se
		}
	}


	private static void searchAddonsInFolder(File file, AddonLocation resourcepack, boolean b) {
		// TODO Auto-generated method stub
		
	}

}
