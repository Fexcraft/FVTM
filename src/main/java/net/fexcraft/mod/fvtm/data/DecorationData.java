package net.fexcraft.mod.fvtm.data;

import java.util.Map.Entry;
import java.util.TreeMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.utils.Pos;
import net.fexcraft.mod.fvtm.data.root.Colorable;
import net.fexcraft.mod.fvtm.data.root.Model;

public class DecorationData implements Colorable {
	
	private final String key, category;
	public /*final*/ String modelid;
	public Model<DecorationData, Object> model;
	private TreeMap<String, RGB> channels = new TreeMap<>();
	public Pos offset;
	public float rotx, roty, rotz;
	public float sclx, scly, sclz;
	public int size = 8;
	
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
				if(array.size() > 1) size = array.get(1).getAsInt();
				if(array.size() > 2){
					JsonArray chnnls = array.get(2).getAsJsonArray();
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
			}
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
		channels.forEach((key, rgb) -> data.channels.put(key, rgb.copy()));
		data.offset = offset.copy();
		data.rotx = rotx;
		data.roty = roty;
		data.rotz = rotz;
		data.sclx = sclx;
		data.scly = scly;
		data.sclz = sclz;
		return data;
	}

}
