package net.fexcraft.mod.fvtm.data.vehicle;

import net.fexcraft.app.json.JsonMap;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class SimplePhysData {

	public float max_throttle;
	public float min_throttle;
	public float turn_left_mod;
	public float turn_right_mod;
	public float wheel_step_height;
	public float wheel_spring_strength;
	public float bouyancy;
	public int trailer_adjustment_axe;
	
	public SimplePhysData(JsonMap map){
		max_throttle = map.getFloat("MaxPositiveThrottle", 1f);
		min_throttle = map.getFloat("MaxNegativeThrottle", 1f);
		turn_left_mod = map.getFloat("TurnLeftModifier", 1f);
		turn_right_mod = map.getFloat("TurnRightModifier", 1f);
		wheel_step_height = map.getFloat("WheelStepHeight", 1f);
		wheel_spring_strength = map.getFloat("WheelSpringStrength", 0.5f);
		bouyancy = map.getFloat("Bouyancy", 0.25f);
		trailer_adjustment_axe = map.getInteger("TrailerAdjustmentAxe", 1);
	}

}
