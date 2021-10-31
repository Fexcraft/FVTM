package net.fexcraft.mod.fvtm.util;

import net.fexcraft.lib.common.math.Vec3f;

/**
 * Utility for vector calculations.
 * Some of the methods here been formerly on client-side classes, as such they would cause crashes when using on server-side.
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class VecUtil {
	
	public static final Vec3f rotByRad(float rad, Vec3f vec){
        double co = Math.cos(rad), si = Math.sin(rad);
        return new Vec3f(co * vec.x - si * vec.z, vec.y, si * vec.x + co * vec.z);
	}

	public static Vec3f rotByDeg(double deg, Vec3f vec){
        double co = Math.cos(Math.toRadians(deg)), si = Math.sin(Math.toRadians(deg));
        return new Vec3f(co * vec.x - si * vec.z, vec.y, si * vec.x + co * vec.z);
	}
	
	public static Vec3f rotate(Vec3f vec, float r, float p, float y){
		float[] arr = { vec.x, vec.y, vec.z };
		rotate(arr, r, 1, 0, 0);
		rotate(arr, p, 0, 0, 1);
		rotate(arr, y, 0, 1, 0);
		return new Vec3f(arr[0], arr[1], arr[2]);
	}

	private static float[] rotate(float[] vec, float angle, int ax, int ay, int az){
		float c = (float)Math.cos(angle), s = (float)Math.sin(angle), oc = 1.0f - c;
		float xy = ax * ay, yz = ay * az, xz = ax * az;
		float xs = ax * s, ys = ay * s, zs = az * s;
		float f0 = ax * ax * oc + c, f1 = xy * oc + zs, f2 = xz * oc - ys;
		float f3 = xy * oc - zs, f4 = ay * ay * oc + c, f5 = yz * oc + xs;
		float f6 = xz * oc + ys, f7 = yz * oc - xs, f8 = az * az * oc + c;
		float f9 = vec[0] * f0 + vec[1] * f1 + vec[2] * f2;
		float ff = vec[0] * f3 + vec[1] * f4 + vec[2] * f5;
		vec[2] = vec[0] * f6 +vec[1] * f7 + vec[2] * f8;
		vec[1] = ff;
		vec[0] = f9;
		return vec;
	}
	
	public static float[] rotate(float[] vec, float r, float p, float y){
		rotate(vec, r, 1, 0, 0);
		rotate(vec, p, 0, 0, 1);
		rotate(vec, y, 0, 1, 0);
		return vec;
	}

}
