package net.fexcraft.mod.fvtm.data.vehicle;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;

public class LegacyData {

	public float max_throttle, min_throttle, turn_left_mod, turn_right_mod, wheel_step_height, camera_distance, wheel_spring_strength, bouyancy;
	public float look_up_mod, look_down_mod, roll_left_mod, roll_right_mod, drag;
	public int trailer_adjustment_axe;
	//public Vec3d[] wheelpos = new Vec3d[4];
	public boolean is_tracked;
	
	public LegacyData(JsonObject obj){
		max_throttle = JsonUtil.getIfExists(obj, "MaxPositiveThrottle", 1f).floatValue();
		min_throttle = JsonUtil.getIfExists(obj, "MaxNegativeThrottle", 1f).floatValue();
		//JsonArray array = obj.get("WheelPositions").getAsJsonArray();
		//for(int i = 0; i < wheelpos.length; i++){ wheelpos[i] = Pos.fromJson(array.get(i), false).to16Double(); }
		turn_left_mod = JsonUtil.getIfExists(obj, "TurnLeftModifier", 1f).floatValue();
		turn_right_mod = JsonUtil.getIfExists(obj, "TurnRightModifier", 1f).floatValue();
		wheel_step_height = JsonUtil.getIfExists(obj, "WheelStepHeight", 1f).floatValue();
		camera_distance = JsonUtil.getIfExists(obj, "CameraDistance", 5f).floatValue();
		is_tracked = JsonUtil.getIfExists(obj, "Tank", false) || JsonUtil.getIfExists(obj, "Tracks", false) ||
		JsonUtil.getIfExists(obj, "Tracked", false) || JsonUtil.getIfExists(obj, "Catenary", false);
		wheel_spring_strength = JsonUtil.getIfExists(obj, "WheelSpringStrength", 0.5f).floatValue();
		bouyancy = JsonUtil.getIfExists(obj, "Bouyancy", 0.25f).floatValue();
		//
		look_up_mod = JsonUtil.getIfExists(obj, "LookUpModifier", 1f).floatValue();
		look_down_mod = JsonUtil.getIfExists(obj, "LookDownModifier", 1f).floatValue();
		roll_left_mod = JsonUtil.getIfExists(obj, "RollLeftModifier", 1f).floatValue();
		roll_right_mod = JsonUtil.getIfExists(obj, "RollRightModifier", 1f).floatValue();
		drag = JsonUtil.getIfExists(obj, "Drag", 1f).floatValue();
		trailer_adjustment_axe = JsonUtil.getIfExists(obj, "TrailerAdjustmentAxe", 1).intValue();
	}

}
