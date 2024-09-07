package net.fexcraft.mod.fvtm.util;

import net.fexcraft.lib.common.Static;

import static net.fexcraft.lib.common.Static.*;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class MathUtils {

	public static double valDeg(double value){
		while(value >= 180) value -= 360;
		while(value < -180) value += 360;
		return value;
	}

	public static float valDegF(double value){
		return valDegF((float)value);
	}

	public static float valDegF(float value){
		while(value >= 180) value -= 360;
		while(value < -180) value += 360;
		return value;
	}

	public static double valRad(double value){
		while(value > PI) value -= PI2;
		while(value < -PI) value += PI2;
		return value;
	}

	public static double calcSpeed(double x, double y, double z, double ox, double oy, double oz){
		return Math.sqrt((x -= ox) * x + /*(y -= oy) * y +*/ (z -= oz) * z);
	}

}
