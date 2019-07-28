package net.fexcraft.mod.fvtm.util;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.registry.NamedResourceLocation;
import net.fexcraft.mod.fvtm.InternalAddon;
import net.fexcraft.mod.fvtm.data.addon.Addon;
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

	public static List<NamedResourceLocation> getTextures(JsonObject obj){
		ArrayList<NamedResourceLocation> reslocs = new ArrayList<>();
		if(obj.has("Texture") && obj.get("Texture").isJsonPrimitive()){
			reslocs.add(new NamedResourceLocation(obj.get("Texture").getAsString()));
		}
		else if(obj.has("Textures") && obj.get("Textures").isJsonArray()){
			obj.get("Textures").getAsJsonArray().forEach(elm -> {
				reslocs.add(new NamedResourceLocation(elm.getAsString()));
			});
		}
		else{
			reslocs.add(new NamedResourceLocation("NullTex|fvtm:textures/entities/null_texture.png"));
		} return reslocs;
	}

	public static RGB getColor(JsonObject obj, String prefix){
		RGB result = null;
		if(obj.has(prefix + "Color")){
			JsonElement elm = obj.get(prefix + "Color");
			if(elm.isJsonPrimitive()){
				result = new RGB(elm.getAsString());//HEX expected
			}
			else if(elm.isJsonObject()){
				int red = obj.has("Red") ? obj.get("Red").getAsInt() : 0;
				int gre = obj.has("Green") ? obj.get("Green").getAsInt() : 0;
				int blu = obj.has("Blue") ? obj.get("Blue").getAsInt() : 0;
				result = new RGB(red, gre, blu);
			}
			else if(elm.isJsonArray()){//array of 3 integers expected
				int[] arr = new int[3]; JsonArray array = elm.getAsJsonArray();
				for(int x = 0; x < 3; x++){ arr[x] = array.get(x).getAsInt(); }
				result = new RGB(arr);
			}
			else {};
		}
		return result == null ? new RGB() : result;
	}

}
