package net.fexcraft.mod.fvtm.data;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.data.root.Colorable;
import net.fexcraft.mod.fvtm.data.root.Model;
import net.fexcraft.mod.fvtm.util.NamedResourceLocation;
import net.fexcraft.mod.fvtm.util.Pos;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.nbt.CompoundTag;

public class DecorationData implements Colorable {
	
	private final String key, category;
	public /*final*/ String modelid;
	public Model model;
	public ArrayList<NamedResourceLocation> textures = new ArrayList<>();
	private TreeMap<String, RGB> channels = new TreeMap<>();
	public Pos offset = new Pos(0, 0, 0);
	public float rotx, roty, rotz;
	public float sclx = 1, scly = 1, sclz = 1;
	public int size = 8, seltex;
	
	public DecorationData(String key, String category){
		this.key = key;
		this.category = category;
	}
	
	public DecorationData(String key, String category, JsonElement value){
		this(key, category);
		if(value.isJsonPrimitive()){
			modelid = value.getAsString();
		}
		else{
			if(value.isJsonArray()){
				JsonArray array = value.getAsJsonArray();
				modelid = array.get(0).getAsString();
				if(array.get(1).isJsonArray()){
					array.get(1).getAsJsonArray().forEach(elm -> textures.add(new NamedResourceLocation(elm.getAsString())));
				}
				else{
					textures.add(new NamedResourceLocation(array.get(1).getAsString()));
				}
				if(array.size() > 2) size = array.get(2).getAsInt();
				if(array.size() > 3){
					JsonArray chnnls = array.get(3).getAsJsonArray();
					for(JsonElement elm : chnnls){
						channels.put(elm.getAsString(), RGB.WHITE.copy());
					}
				}
			}
			else{
				JsonObject obj = value.getAsJsonObject();
				modelid = obj.get("model").getAsString();
				if(obj.has("size")) size = obj.get("size").getAsInt();
				if(obj.has("channels")){
					for(Entry<String, JsonElement> entry : obj.get("channels").getAsJsonObject().entrySet()){
						channels.put(entry.getKey(), new RGB(entry.getValue().getAsString()));
					}
				}
				if(obj.has("texture")){
					if(obj.get("texture").isJsonArray()){
						obj.get("texture").getAsJsonArray().forEach(elm -> textures.add(new NamedResourceLocation(elm.getAsString())));
					}
					else{
						textures.add(new NamedResourceLocation(obj.get("texture").getAsString()));
					}
				}
			}
		}
		if(textures.isEmpty()) textures.add(Resources.WHITE_TEXTURE);
	}
	
	public DecorationData(CompoundTag compound, boolean client){
		key = compound.getString("key");
		category = compound.getString("category");
		offset = new Pos(compound.getFloat("offx"), compound.getFloat("offy"), compound.getFloat("offz"));
		if(compound.contains("rotx")) rotx = compound.getFloat("rotx");
		if(compound.contains("roty")) roty = compound.getFloat("roty");
		if(compound.contains("rotz")) rotz = compound.getFloat("rotz");
		if(compound.contains("sclx")) sclx = compound.getFloat("sclx");
		if(compound.contains("scly")) scly = compound.getFloat("scly");
		if(compound.contains("sclz")) sclz = compound.getFloat("sclz");
		if(compound.contains("seltex")) seltex = compound.getInt("seltex");
		DecorationData data = Resources.DECORATIONS.get(key);
		if(data != null) copy(data);
		if(seltex >= textures.size()) seltex = textures.size() - 1;
		if(seltex < 0) seltex = 0;
		for(Entry<String, RGB> entry : channels.entrySet()){
			if(compound.contains("color_" + entry.getKey())) entry.getValue().packed = compound.getInt("color_" + entry.getKey()); 
		}
	}

	@Override
	public RGB getColorChannel(String channel){
		return channels.get(channel);
	}
	
	@Override
	public void setColorChannel(String channel, RGB color){
		channels.put(channel, color);
	}
	
	@Override
	public TreeMap<String, RGB> getColorChannels(){
		return channels;
	}

	public String key(){
		return key;
	}
	
	public String category(){
		return category;
	}
	
	public DecorationData copy(){
		DecorationData data = new DecorationData(key, category);
		data.size = size;
		data.model = model;
		data.modelid = modelid;
		channels.forEach((key, rgb) -> data.channels.put(key, rgb.copy()));
		data.offset = offset.copy();
		data.rotx = rotx;
		data.roty = roty;
		data.rotz = rotz;
		data.sclx = sclx;
		data.scly = scly;
		data.sclz = sclz;
		data.textures.addAll(textures);
		data.seltex = seltex;
		return data;
	}
	
	public DecorationData copy(DecorationData data){
		model = data.model;
		modelid = data.modelid;
		channels.clear();
		textures.clear();
		data.channels.forEach((key, rgb) -> channels.put(key, rgb.copy()));
		textures.addAll(data.textures);
		return data;
	}

	public CompoundTag write(){
		CompoundTag compound = new CompoundTag();
		compound.putString("key", key);
		compound.putString("category", category);
		compound.putFloat("offx", offset.x);
		compound.putFloat("offy", offset.y);
		compound.putFloat("offz", offset.z);
		if(rotx != 0f) compound.putFloat("rotx", rotx);
		if(roty != 0f) compound.putFloat("roty", roty);
		if(rotz != 0f) compound.putFloat("rotz", rotz);
		if(sclx != 1f) compound.putFloat("sclx", sclx);
		if(scly != 1f) compound.putFloat("scly", scly);
		if(sclz != 1f) compound.putFloat("sclz", sclz);
		if(seltex != 0) compound.putInt("seltex", seltex);
		for(Entry<String, RGB> entry : channels.entrySet()){
			compound.putInt("color_" + entry.getKey(), entry.getValue().packed);
		}
		return compound;
	}

}
