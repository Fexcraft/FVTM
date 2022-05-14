package net.fexcraft.mod.fvtm.util;

import java.util.HashMap;

import net.fexcraft.mod.fvtm.data.addon.Addon;
import net.fexcraft.mod.fvtm.data.root.TypeCore;
import net.minecraft.resources.ResourceLocation;

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
		// TODO Auto-generated method stub
		
	}

}
