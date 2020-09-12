package net.fexcraft.mod.fvtm.data.vehicle;

import com.google.gson.JsonArray;

import net.fexcraft.lib.mc.utils.Pos;

public class LiftingPoint {
	
	public final String id, second;
	public final Pos pos;

	public LiftingPoint(String key, JsonArray array){
		id = key;
		pos = Pos.fromJson(array, true);
		second = array.size() > 3 ? array.get(3).getAsString() : null;
	}
	
	public boolean isSingular(){
		return second.equals("none") || second.equals("singular");
	}

}
