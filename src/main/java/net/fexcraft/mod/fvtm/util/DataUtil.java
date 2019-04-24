package net.fexcraft.mod.fvtm.util;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.InternalAddon;
import net.fexcraft.mod.fvtm.data.Addon;
import net.minecraft.util.ResourceLocation;

public class DataUtil {

	public static ResourceLocation getRegistryName(JsonObject obj){
		return obj.has("RegistryName") ? new ResourceLocation(obj.get("RegistryName").getAsString()) : null;
	}

	public static ResourceLocation getRegistryName(String key, JsonObject obj){
		return obj.has(key) ? new ResourceLocation(obj.get(key).getAsString()) : null;
	}

	public static Addon getAddon(JsonObject obj){
		if(obj.has("Addon")){
			Addon addon = Resources.ADDONS.getValue(new ResourceLocation(obj.get("Addon").getAsString()));
			if(addon != null) return addon;
		} return Resources.ADDONS.getValue(InternalAddon.REGNAME);
	}

	public static List<String> getStringArray(JsonObject obj, String key, boolean split, boolean immutable){
		ArrayList<String> list = new ArrayList<>();
		if(obj.has(key)){
			if(obj.get(key).isJsonPrimitive()){
				if(split){
					String[] arr = obj.get(key).getAsString().split("\n");
					for(String string : arr) list.add(string);
				}
				else list.add(obj.get(key).getAsString());
			}
			else{
				obj.get(key).getAsJsonArray().forEach(elm -> list.add(elm.getAsString()));
			}
		}
		return immutable ? ImmutableList.copyOf(list) : list;
	}

}
