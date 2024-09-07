package net.fexcraft.mod.fvtm.data.vehicle;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.util.ContentConfigUtil;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class LiftingPoint {
	
	public final String id, second;
	public final V3D pos;
	public final float off;

	public LiftingPoint(String key, JsonArray array){
		id = key;
		pos = ContentConfigUtil.getVector(array);
		second = array.size() > 3 ? array.get(3).string_value() : null;
		off = array.size() > 4 ? array.get(4).float_value() : 0;
	}

	public LiftingPoint(String key, JsonMap map){
		id = key;
		pos = ContentConfigUtil.getVector(map.getArray("pos"));
		second = map.getString("pair", null);
		off = map.getFloat("offset", 0);
	}
	
	public LiftingPoint(String key, V3D pos2, String str, float yoff0){
		id = key;
		pos = pos2;
		second = str;
		off = yoff0;
	}

	public boolean isSingular(){
		return second == null || second.equals("none") || second.equals("singular");
	}

}
