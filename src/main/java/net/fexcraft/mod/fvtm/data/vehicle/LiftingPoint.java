package net.fexcraft.mod.fvtm.data.vehicle;

import com.google.gson.JsonArray;
import net.fexcraft.mod.fvtm.sys.uni.Pos;

public class LiftingPoint {
	
	public final String id, second;
	public final Pos pos;
	public final float off;

	public LiftingPoint(String key, JsonArray array){
		id = key;
		pos = Pos.fromJson(array, true);
		second = array.size() > 3 ? array.get(3).getAsString() : null;
		off = array.size() > 4 ? array.get(4).getAsFloat() : 0;
	}
	
	public LiftingPoint(String key, Pos pos2, String str, float yoff0){
		id = key;
		pos = pos2;
		second = str;
		off = yoff0;
	}

	public boolean isSingular(){
		return second == null || second.equals("none") || second.equals("singular");
	}

}
