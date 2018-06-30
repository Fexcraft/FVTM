package net.fexcraft.mod.fmt.data;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.Map.Entry;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.json.NBTToJson;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModelCompound {
	
	public int texture_size_x = 512, texture_size_y = 512;
	public TreeMap<String, List<Polygon>> polygons = new TreeMap<>();
	@SideOnly(Side.CLIENT)
	public TreeMap<String, List<net.fexcraft.mod.lib.tmt.ModelRendererTurbo>> models = new TreeMap<>();
	public ArrayList<String> creators = new ArrayList<>();
	public String name;
	
	public ModelCompound(JsonObject obj){
		creators = obj.has("creators") ? JsonUtil.jsonArrayToStringArray(obj.get("creators").getAsJsonArray()) : new ArrayList<>();
		texture_size_x = JsonUtil.getIfExists(obj, "texture_size_x", 512).intValue();
		texture_size_y = JsonUtil.getIfExists(obj, "texture_size_y", 512).intValue();
		if(obj.has("model")){
	        JsonObject modelobj = obj.get("model").getAsJsonObject();
	        for(Entry<String, JsonElement> entry : modelobj.entrySet()){
	        	ArrayList<Polygon> list = new ArrayList<>();
	        	entry.getValue().getAsJsonArray().forEach(elm -> {
	        		list.add(new Polygon(this, elm.getAsJsonObject()));
	        	});
	        	polygons.put(entry.getKey(), list);
	        }
		}
        name = JsonUtil.getIfExists(obj, "name", "unnamed");
        if(Static.side().isClient()){
        	refreshTMT();
        }
	}
	
	@SideOnly(Side.CLIENT)
	public void refreshTMT(){
		models.clear();
		polygons.forEach((key, value) -> {
			ArrayList<net.fexcraft.mod.lib.tmt.ModelRendererTurbo> list = new ArrayList<>();
			value.forEach(elm -> { list.add(elm.toTMT()); });
			models.put(key, list);
		});
	}
	
	@SideOnly(Side.CLIENT)
	public void refreshTMT(String group, int selected){
		//Polygon polygon = polygons.get(group).get(selected);
		//models.get(group).set(selected, polygon.toTMT());//TODO find error cause
		refreshTMT();
	}
	
	public JsonObject toJTMT(){
		JsonObject obj = new JsonObject();
		obj.addProperty("format", 1);
		obj.addProperty("name", name);
		obj.addProperty("type", "jtmt");
		obj.addProperty("texture_size_x", texture_size_x);
		obj.addProperty("texture_size_y", texture_size_y);
		JsonArray creators = new JsonArray();
		this.creators.forEach(elm -> { creators.add(elm); });
		obj.add("creators", creators);
		//
		JsonObject model = new JsonObject();
		this.polygons.forEach((key, value) -> {
			JsonArray array = new JsonArray();
			value.forEach(elm -> { array.add(elm.toJTMT()); });
			model.add(key, array);
		});
		obj.add("model", model);
		return obj;
	}
	
	@Override
	public String toString(){
		return toJTMT().toString();
	}

	public NBTBase toNBTTagCompound(){
		try{
			return JsonToNBT.getTagFromJson(this.toJTMT().toString());
		}
		catch(NBTException e){
			e.printStackTrace();
			return null;
		}
	}

	public static ModelCompound fromNBTTagCompound(NBTTagCompound compound){
		JsonObject obj = NBTToJson.getJsonFromTag(compound);
		return new ModelCompound(obj == null ? new JsonObject() : obj);
	}
	
}