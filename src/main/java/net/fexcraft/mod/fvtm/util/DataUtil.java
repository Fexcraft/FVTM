package net.fexcraft.mod.fvtm.util;

import static net.fexcraft.mod.fvtm.FvtmRegistry.ADDONS;

import java.awt.image.BufferedImage;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.imageio.ImageIO;

import com.google.common.collect.ImmutableList;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.addon.Addon;
import net.fexcraft.mod.fvtm.model.Model;
import net.fexcraft.mod.fvtm.model.ModelData;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;
import net.fexcraft.mod.uni.tag.TagLW;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagDouble;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;

public class DataUtil {

	public static ResourceLocation getRegistryName(Addon addon, JsonObject obj){
		String regname = obj.has("RegistryName") ? obj.get("RegistryName").getAsString() : null;
		if(regname == null) return null;
		if(regname.contains(":")) return new ResourceLocation(regname);
		return new ResourceLocation((addon == null ? "fvtm" : addon.getID().id()) + ":" + regname);
	}

	public static ResourceLocation getRegistryName(String key, JsonObject obj){
		return obj.has(key) ? new ResourceLocation(obj.get(key).getAsString()) : null;
	}

	public static Addon getAddon(JsonObject obj){
		if(obj.has("Addon")){
			String addin = obj.get("Addon").getAsString();
			if(addin.contains(":")) addin = addin.split(":")[1];
			Addon addon = FvtmRegistry.getAddon(addin);
			if(addon != null) return addon;
		}
		return ADDONS.get(FvtmRegistry.INTERNAL_ADDON_ID);
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

	public static List<IDL> getTextures(JsonObject obj){
		ArrayList<IDL> reslocs = new ArrayList<>();
		if(obj.has("Texture") && obj.get("Texture").isJsonPrimitive()){
			reslocs.add(IDLManager.getIDLNamed(obj.get("Texture").getAsString()));
		}
		else if(obj.has("Textures") && obj.get("Textures").isJsonArray()){
			obj.get("Textures").getAsJsonArray().forEach(elm -> {
				reslocs.add(IDLManager.getIDLNamed(elm.getAsString()));
			});
		}
		if(reslocs.isEmpty()){
			reslocs.add(FvtmRegistry.NULL_TEXTURE);
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
    public static void loadAllItems(NBTTagCompound tag, NonNullList<ItemStack> stacks, String customtag){
        NBTTagList list = tag.getTagList(customtag == null ? "Items" : customtag, 10);
        for(int i = 0; i < list.tagCount(); ++i){
            NBTTagCompound compound = list.getCompoundTagAt(i);
            int j = compound.getShort("Slot");
            if(j >= 0 && j < stacks.size()){
                stacks.set(j, new ItemStack(compound));
            }
        }
    }
    
    /** Allows for saving more than 256 slots. **/
    public static NBTTagCompound saveAllItems(NBTTagCompound tag, NonNullList<ItemStack> stacks, boolean saveEmpty, String customtag){
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
        if(!list.isEmpty() || saveEmpty){
            tag.setTag(customtag != null ? customtag : "Items", list);
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
		if(list.isEmpty() || list.tagCount() < 3) return null;
		return new Vec3d(list.getDoubleAt(0), list.getDoubleAt(1), list.getDoubleAt(2));
	}

	public static TagLW writeVec(V3D vec){
		TagLW list = TagLW.create();
		list.add(vec.x);
		list.add(vec.y);
		list.add(vec.z);
		return list;
	}

	public static V3D readVec(NBTBase tag){
		if(tag instanceof NBTTagList == false) return null;
		NBTTagList list = (NBTTagList)tag;
		if(list.isEmpty() || list.tagCount() < 3) return null;
		return new V3D(list.getFloatAt(0), list.getFloatAt(1), list.getFloatAt(2));
	}

	public static V3D readVec(TagLW tag){
		NBTTagList list = tag.local();
		if(list.isEmpty() || list.tagCount() < 3) return null;
		return new V3D(list.getFloatAt(0), list.getFloatAt(1), list.getFloatAt(2));
	}

	public static JsonElement writeVecJSON(V3D vec){
		JsonArray array = new JsonArray();
		array.add(vec.x);
		array.add(vec.y);
		array.add(vec.z);
		return array;
	}

	public static V3D readVec(JsonElement elm){
		if(elm == null || !elm.isJsonArray()) return null;
		JsonArray array = elm.getAsJsonArray();
		if(array.size() == 0) return null;
		return new V3D(array.get(0).getAsDouble(), array.get(1).getAsDouble(), array.get(2).getAsDouble());
	}
	
	public static BufferedImage tryDownload(String url){
        try{
        	HttpURLConnection urlconn = (HttpURLConnection)(new URL(url)).openConnection(Minecraft.getMinecraft().getProxy());
            urlconn.setDoInput(true); urlconn.setDoOutput(false); urlconn.connect();
            if(urlconn.getResponseCode() == 200){
                return ImageIO.read(urlconn.getInputStream());
            } urlconn.disconnect();
        } catch (Exception e){ e.printStackTrace(); }
		return null;
	}

	public static final ResourceLocation RSLC_GENERAL = new ResourceLocation("fvtm:textures/items/ph_general.png");
	public static final ResourceLocation RSLC_VEHICLE = new ResourceLocation("fvtm:textures/items/ph_vehicle.png");
	public static final ResourceLocation RSLC_MBLOCK = new ResourceLocation("fvtm:textures/items/ph_multiblock.png");
	public static final ResourceLocation RSLC_PART = new ResourceLocation("fvtm:textures/items/ph_part.png");

	public static ResourceLocation getItemTexture(ResourceLocation regname, ContentType type, JsonObject obj){
		if(obj.has("ItemTexture")){
			return new ResourceLocation(obj.get("ItemTexture").getAsString());
		}
		else{
			ResourceLocation resloc = new ResourceLocation(regname.getNamespace(), "textures/items/" + regname.getPath() + ".png");
			if(Static.side().isClient()){
				if(net.fexcraft.mod.fvtm.util.TexUtil.isMissing(resloc)){
					if(type == ContentType.VEHICLE) return RSLC_VEHICLE;
					else if(type == ContentType.PART) return RSLC_PART;
					else if(type == ContentType.MULTIBLOCK) return RSLC_MBLOCK;
					else return RSLC_GENERAL;
				}
			}
			return resloc;
		}
	}

}
