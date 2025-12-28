package net.fexcraft.mod.fvtm.model;

import java.io.Closeable;
import java.io.InputStream;
import java.util.*;
import java.util.function.Supplier;

import net.fexcraft.app.json.JsonHandler;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.FvtmResources.InputStreamWithFallback;

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
			integrate(map.getMap(key));
		}
		if(has("Import")){
			String mdr = get("Import").string_value();
			if(FvtmRegistry.MODEL_DATAS.containsKey(mdr)){
				integrate(FvtmRegistry.MODEL_DATAS.get(mdr));
			}
			else{
				try{
					InputStreamWithFallback iswf = FvtmResources.getAssetInputStreamWithFallback(mdr);
					ModelData nmd = new ModelData();
					JsonMap imp = JsonHandler.parse(iswf.stream());
					iswf.close();
					nmd.integrate(imp);
					integrate(nmd);
					FvtmRegistry.MODEL_DATAS.put(mdr, nmd);
				}
				catch(Exception e){
					FvtmLogger.log(e, "loading modeldata root " + mdr);
				}
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

	public void integrate(JsonMap map){
		for(Map.Entry<String, JsonValue<?>> entry : map.entries()){
			add(entry.getKey(), entry.getValue().copy());
		}
	}

	//

}
