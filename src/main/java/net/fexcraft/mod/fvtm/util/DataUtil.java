package net.fexcraft.mod.fvtm.util;

import java.awt.image.BufferedImage;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.mc.registry.NamedResourceLocation;
import net.fexcraft.mod.fvtm.InternalAddon;
import net.fexcraft.mod.fvtm.data.addon.Addon;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagDouble;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;

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
			reslocs.add(new NamedResourceLocation("NullTex|fvtm:textures/entity/null.png"));
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
    
    /** Allows for loading more than 256 slots. **/
    public static void loadAllItems(NBTTagCompound tag, NonNullList<ItemStack> stacks){
        NBTTagList list = tag.getTagList("Items", 10);
        for(int i = 0; i < list.tagCount(); ++i){
            NBTTagCompound compound = list.getCompoundTagAt(i);
            int j = compound.getShort("Slot");
            if(j >= 0 && j < stacks.size()){
                stacks.set(j, new ItemStack(compound));
            }
        }
    }
    
    /** Allows for saving more than 256 slots. **/
    public static NBTTagCompound saveAllItems(NBTTagCompound tag, NonNullList<ItemStack> stacks, boolean saveEmpty){
        NBTTagList list = new NBTTagList();
        for(int i = 0; i < stacks.size(); ++i){
            ItemStack stack = stacks.get(i);
            if(!stack.isEmpty()){
                NBTTagCompound compound = new NBTTagCompound();
                compound.setShort("Slot", (short)i);
                stack.writeToNBT(compound);
                list.appendTag(compound);
            }
        }
        if(!list.hasNoTags() || saveEmpty){
            tag.setTag("Items", list);
        }
        return tag;
    }

	public static NBTBase writeVec3d(Vec3d vec){
		NBTTagList list = new NBTTagList();
		list.appendTag(new NBTTagDouble(vec.x));
		list.appendTag(new NBTTagDouble(vec.y));
		list.appendTag(new NBTTagDouble(vec.z));
		return list;
	}

	public static Vec3d readVec3d(NBTBase base){
		if(base instanceof NBTTagList == false) return null; NBTTagList list = (NBTTagList)base;
		if(list.hasNoTags() || list.tagCount() < 3) return null;
		return new Vec3d(list.getDoubleAt(0), list.getDoubleAt(1), list.getDoubleAt(2));
	}

	public static NBTBase writeVec3f(Vec3f vec){
		NBTTagList list = new NBTTagList();
		list.appendTag(new NBTTagFloat(vec.xCoord));
		list.appendTag(new NBTTagFloat(vec.yCoord));
		list.appendTag(new NBTTagFloat(vec.zCoord));
		return list;
	}

	public static Vec3f readVec3f(NBTBase tag){
		if(tag instanceof NBTTagList == false) return null; NBTTagList list = (NBTTagList)tag;
		if(list.hasNoTags() || list.tagCount() < 3) return null;
		return new Vec3f(list.getFloatAt(0), list.getFloatAt(1), list.getFloatAt(2));
	}
	
	public static BufferedImage tryDownload(String url){
        try{
        	HttpURLConnection urlconn = (HttpURLConnection)(new URL(url)).openConnection(Minecraft.getMinecraft().getProxy());
            urlconn.setDoInput(true); urlconn.setDoOutput(false); urlconn.connect();
            if(urlconn.getResponseCode() == 200){
                return TextureUtil.readBufferedImage(urlconn.getInputStream());
            } urlconn.disconnect();
        } catch (Exception e){ e.printStackTrace(); }
		return null;
	}

}
