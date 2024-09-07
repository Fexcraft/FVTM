package net.fexcraft.mod.fvtm.util;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.uni.tag.TagLW;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class SaveUtils {

	public static TagLW saveV3D(V3D vec){
		TagLW list = TagLW.create();
		list.add(vec.x);
		list.add(vec.y);
		list.add(vec.z);
		return list;
	}

	public static JsonArray saveV3DJson(V3D vec){
		JsonArray array = new JsonArray();
		array.add(vec.x);
		array.add(vec.y);
		array.add(vec.z);
		return array;
	}

	public static V3D loadV3D(TagLW list){
		if(list.direct() == null || list.size() == 0) return new V3D();
		V3D vec = new V3D();
		if(list.size() > 0) vec.x = list.getDouble(0);
		if(list.size() > 1) vec.y = list.getDouble(1);
		if(list.size() > 2) vec.z = list.getDouble(2);
		return vec;
	}

	public static V3D loadV3D(JsonArray array){
		if(array.size() == 0) return new V3D();
		V3D vec = new V3D();
		if(array.size() > 0) vec.x = array.get(0).float_value();
		if(array.size() > 1) vec.y = array.get(1).float_value();
		if(array.size() > 2) vec.z = array.get(2).float_value();
		return vec;
	}

}
