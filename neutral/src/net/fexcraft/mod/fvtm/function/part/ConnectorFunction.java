package net.fexcraft.mod.fvtm.function.part;

import net.fexcraft.app.json.FJson;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.part.PartFunction;
import net.fexcraft.mod.fvtm.data.part.PartFunction.StaticFunction;
import net.fexcraft.mod.fvtm.util.ContentConfigUtil;

import java.util.ArrayList;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ConnectorFunction extends StaticFunction {

	private ArrayList<String> types = new ArrayList<>();
	private V3D offset = V3D.NULL;

	@Override
	public PartFunction init(Part part, FJson json){
		JsonMap map = json.asMap();
		if(map.has("pos")) offset = ContentConfigUtil.getVector(map.getArray("pos"), 0);
		if(map.has("type")){
			if(map.get("type").isArray()){
				for(JsonValue<?> elm : map.getArray("type").elements()){
					types.add(elm.string_value());
				}
			}
			else types.add(map.get("type").string_value());
		}
		else types.add("car_trailer");
		return this;
	}

	@Override
	public String getId(){
		return "fvtm:connector";
	}

	public V3D getOffset(){
		return offset;
	}

	public ArrayList<String> getTypes(){
		return types;
	}

	public boolean accepts(String type){
		for(String str : types){
			if(type.equals(str)) return true;
		}
		return false;
	}

}
