package net.fexcraft.mod.fvtm.data;

import java.util.ArrayList;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.util.NamedResourceLocation;

public class TextureSupply {
	
	private ArrayList<String> targets = new ArrayList<>();
	private ArrayList<NamedResourceLocation> reslocs = new ArrayList<>();
	public final String id;
	
	public TextureSupply(String key){
		this.id = key;
	}
	
	public TextureSupply(String key, JsonObject obj){
		this(key);
		JsonElement tar = obj.get("target");
		if(tar.isJsonArray()){
			for(JsonElement elm : tar.getAsJsonArray()) targets.add(elm.getAsString());
		}
		else targets.add(tar.getAsString());
		JsonElement tex = obj.get("texture");
		if(tex.isJsonArray()){
			for(JsonElement elm : tex.getAsJsonArray()) reslocs.add(new NamedResourceLocation(elm.getAsString()));
		}
		else reslocs.add(new NamedResourceLocation(tex.getAsString()));
	}
	
	public ArrayList<String> targets(){
		return targets;
	}
	
	public ArrayList<NamedResourceLocation> textures(){
		return reslocs;
	}

}
