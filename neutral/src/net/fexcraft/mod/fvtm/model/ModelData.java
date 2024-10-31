package net.fexcraft.mod.fvtm.model;

import java.util.*;
import java.util.function.Supplier;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.mod.uni.IDL;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ModelData extends JsonMap {

	public String location;

	public ModelData(){
		super();
	}

	public ModelData(JsonMap map){
		this(map, "ModelData");
	}

	public ModelData(JsonMap map, String key){
		this();
		if(map.has(key)){
			map = map.getMap(key);
			for(Map.Entry<String, JsonValue<?>> entry : map.entries()){
				add(entry.getKey(), entry.getValue().copy());
			}
		}
	}

	public int gsI(String key, Supplier<Integer> val){
		if(!has(key)) add(key, val.get());
		return get(key).integer_value();
	}

	public float gsF(String key, Supplier<Float> val){
		if(!has(key)) add(key, val.get());
		return get(key).float_value();
	}

	public String gsS(String key, Supplier<String> val){
		if(!has(key)) add(key, val.get());
		return get(key).string_value();
	}

	public boolean gsB(String key, Supplier<Boolean> val){
		if(!has(key)) add(key, val.get());
		return get(key).bool();
	}

	//

}
