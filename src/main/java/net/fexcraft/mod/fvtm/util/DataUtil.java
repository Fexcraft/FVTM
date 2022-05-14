package net.fexcraft.mod.fvtm.util;

import java.awt.image.BufferedImage;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import com.google.common.collect.ImmutableList;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.math.Vector3f;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.mod.fvtm.InternalAddon;
import net.fexcraft.mod.fvtm.data.addon.Addon;
import net.fexcraft.mod.fvtm.data.root.DataType;
import net.minecraft.client.Minecraft;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.FloatTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class DataUtil {

	public static ResourceLocation getRegistryName(JsonObject obj){
		String regname = obj.has("RegistryName") ? obj.get("RegistryName").getAsString() : null;
		if(regname == null) return null;
		return new ResourceLocation(regname.contains(":") ? regname : "fvtm:" + regname);
	}

	public static ResourceLocation getRegistryName(String key, JsonObject obj){
		return obj.has(key) ? new ResourceLocation(obj.get(key).getAsString()) : null;
	}

	public static Addon getAddon(JsonObject obj){
		if(obj.has("Addon")){
			String addin = obj.get("Addon").getAsString();
			if(addin.contains(":")) addin = addin.split(":")[1];
			Addon addon = Resources.getAddon(addin);
			if(addon != null) return addon;
		}
		return Resources.ADDONS.get(InternalAddon.REGNAME);
	}
	
	public static List<String> getStringArray(JsonObject obj, String key, boolean split, boolean immutable){
		return getStringArray(obj, new String[]{ key }, split ? "\n" : null, immutable);
	}

	public static List<String> getStringArray(JsonObject obj, String[] keys, String split, boolean immutable){
		ArrayList<String> list = new ArrayList<>();
		for(String key : keys){
			if(obj.has(key)){
				if(obj.get(key).isJsonPrimitive()){
					if(split != null){
						String[] arr = obj.get(key).getAsString().split(split);//"\n");
						for(String string : arr) list.add(string);
					}
					else list.add(obj.get(key).getAsString());
				}
				else{
					obj.get(key).getAsJsonArray().forEach(elm -> list.add(elm.getAsString()));
				}
			}
		}
		return immutable ? ImmutableList.copyOf(list) : list;
	}

	public static ArrayList<String> getStringArray(JsonElement elm){
		ArrayList<String> list = new ArrayList<>();
		if(elm.isJsonArray()){
			for(JsonElement e : elm.getAsJsonArray()) list.add(e.getAsString());
		}
		else list.add(elm.getAsString());
		return list;
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
		if(reslocs.isEmpty()){
			reslocs.add(Resources.NULL_TEXTURE);
		}
		return reslocs;
	}

	public static RGB getColor(JsonObject obj, String prefix, boolean nell){
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
		return result == null ? nell ? null : new RGB() : result;
	}
    
    /** Allows for loading more than 256 slots. **/
    public static void loadAllItems(CompoundTag tag, NonNullList<ItemStack> stacks, String customtag){
        ListTag list = tag.getList(customtag == null ? "Items" : customtag, 10);
        for(int i = 0; i < list.size(); ++i){
        	CompoundTag compound = list.getCompound(i);
            int j = compound.getShort("Slot");
            if(j >= 0 && j < stacks.size()){
                stacks.set(j, ItemStack.of(compound));
            }
        }
    }
    
    /** Allows for saving more than 256 slots. **/
    public static CompoundTag saveAllItems(CompoundTag tag, NonNullList<ItemStack> stacks, boolean saveEmpty, String customtag){
        ListTag list = new ListTag();
        for(int i = 0; i < stacks.size(); ++i){
            ItemStack stack = stacks.get(i);
            if(!stack.isEmpty()){
                CompoundTag compound = new CompoundTag();
                compound.putShort("Slot", (short)i);
                stack.save(compound);
                list.add(compound);
            }
        }
        if(!list.isEmpty() || saveEmpty){
            tag.put(customtag != null ? customtag : "Items", list);
        }
        return tag;
    }

	public static Tag saveVector3d(Vector3f vec){
		ListTag list = new ListTag();
		list.add(FloatTag.valueOf(vec.x()));
		list.add(FloatTag.valueOf(vec.y()));
		list.add(FloatTag.valueOf(vec.z()));
		return list;
	}

	public static Vector3f loadVector3f(Tag base){
		if(base instanceof ListTag == false) return null; ListTag list = (ListTag)base;
		if(list.isEmpty() || list.size() < 3) return null;
		return new Vector3f(list.getFloat(0), list.getFloat(1), list.getFloat(2));
	}

	public static Tag saveVec3f(Vec3f vec){
		ListTag list = new ListTag();
		list.add(FloatTag.valueOf(vec.x));
		list.add(FloatTag.valueOf(vec.y));
		list.add(FloatTag.valueOf(vec.z));
		return list;
	}

	public static Vec3f loadVec3f(Tag tag){
		if(tag instanceof ListTag == false) return null; ListTag list = (ListTag)tag;
		if(list.isEmpty() || list.size() < 3) return null;
		return new Vec3f(list.getFloat(0), list.getFloat(1), list.getFloat(2));
	}

	public static JsonElement writeVec3fJSON(Vec3f vec){
		JsonArray array = new JsonArray();
		array.add(vec.x);
		array.add(vec.y);
		array.add(vec.z);
		return array;
	}

	public static Vec3f readVec3f(JsonElement elm){
		if(elm == null || !elm.isJsonArray()) return null;
		JsonArray array = elm.getAsJsonArray();
		if(array.size() == 0) return null;
		return new Vec3f(array.get(0).getAsFloat(), array.get(1).getAsFloat(), array.get(2).getAsFloat());
	}
	
	public static BufferedImage tryDownload(String url){
        try{
        	HttpURLConnection urlconn = (HttpURLConnection)(new URL(url)).openConnection(Minecraft.getInstance().getProxy());
            urlconn.setDoInput(true); urlconn.setDoOutput(false); urlconn.connect();
            if(urlconn.getResponseCode() == 200){
                return ImageIO.read(urlconn.getInputStream());
            }
            urlconn.disconnect();
        }
        catch(Exception e){
        	e.printStackTrace();
        }
		return null;
	}
	
	public static final ResourceLocation RSLC_GENERAL = new ResourceLocation("fvtm:textures/items/ph_general.png");
	public static final ResourceLocation RSLC_VEHICLE = new ResourceLocation("fvtm:textures/items/ph_vehicle.png");
	public static final ResourceLocation RSLC_PART = new ResourceLocation("fvtm:textures/items/ph_part.png");

	public static ResourceLocation getItemTexture(ResourceLocation regname, DataType type,  JsonObject obj){
		if(obj.has("ItemTexture")){
			return new ResourceLocation(obj.get("ItemTexture").getAsString());
		}
		else{
			ResourceLocation resloc = new ResourceLocation(regname.getNamespace(), "textures/items/" + regname.getPath() + ".png");
			/*if(Static.side().isClient()){
				if(net.fexcraft.mod.fvtm.util.TexUtil.isMissing(resloc)){
					if(type == DataType.VEHICLE) return RSLC_VEHICLE;
					else if(type == DataType.PART) return RSLC_PART;
					else return RSLC_GENERAL;
				}
			}*///TODO item placeholder model texture
			return resloc;
		}
	}

}
