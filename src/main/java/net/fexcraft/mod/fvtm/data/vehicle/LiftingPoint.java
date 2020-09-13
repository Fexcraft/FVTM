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
	
	public LiftingPoint(String key, Pos pos2, String str){
		id = key;
		pos = pos2;
		second = str;
	}

	public boolean isSingular(){
		return second == null || second.equals("none") || second.equals("singular");
	}

}
