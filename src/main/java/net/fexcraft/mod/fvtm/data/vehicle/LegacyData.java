package net.fexcraft.mod.fvtm.data.vehicle;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.mc.utils.Pos;
import net.minecraft.util.math.Vec3d;

public class LegacyData {

	public float max_throttle, min_throttle, turn_left_mod, turn_right_mod;
	public Vec3d[] wheelpos = new Vec3d[4];
	
	public LegacyData(JsonObject obj){
		max_throttle = JsonUtil.getIfExists(obj, "MaxPositiveThrottle", 1f).floatValue();
		min_throttle = JsonUtil.getIfExists(obj, "MaxNegativeThrottle", 1f).floatValue();
		JsonArray array = obj.get("WheelPositions").getAsJsonArray();
		for(int i = 0; i < wheelpos.length; i++){ wheelpos[i] = Pos.fromJson(array.get(i), false).to16Double(); }
		turn_left_mod = JsonUtil.getIfExists(obj, "TurnLeftModifier", 1f).floatValue();
		turn_right_mod = JsonUtil.getIfExists(obj, "TurnRightModifier", 1f).floatValue();
	}

}
