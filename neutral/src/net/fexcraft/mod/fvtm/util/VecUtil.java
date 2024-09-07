package net.fexcraft.mod.fvtm.util;

import net.fexcraft.lib.common.math.V3D;

/**
 * Utility for vector calculations.
 * Some of the methods here been formerly on client-side classes, as such they would cause crashes when using on server-side.
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class VecUtil {
	
	public static V3D rotByRad(double rad, V3D vec){
        double co = Math.cos(rad), si = Math.sin(rad);
        return new V3D(co * vec.x - si * vec.z, vec.y, si * vec.x + co * vec.z);
	}

	public static V3D rotByDeg(double deg, V3D vec){
        double co = Math.cos(Math.toRadians(deg)), si = Math.sin(Math.toRadians(deg));
        return new V3D(co * vec.x - si * vec.z, vec.y, si * vec.x + co * vec.z);
	}

	public static V3D rotByRad(double rad, double x, double y, double z){
		double co = Math.cos(rad), si = Math.sin(rad);
		return new V3D(co * x - si * z, y, si * x + co * z);
	}
	
	public static V3D rotate(V3D vec, double r, double p, double y){
		double[] arr = { vec.x, vec.y, vec.z };
		rotate(arr, r, 1, 0, 0);
		rotate(arr, p, 0, 0, 1);
		rotate(arr, y, 0, 1, 0);
		return new V3D(arr[0], arr[1], arr[2]);
	}

	public static double[] rotate(double[] vec, double angle, int ax, int ay, int az){
		if(angle == 0) return vec;
		double c = Math.cos(angle), s = Math.sin(angle), oc = 1.0f - c;
		double xy = ax * ay, yz = ay * az, xz = ax * az;
		double xs = ax * s, ys = ay * s, zs = az * s;
		double f0 = ax * ax * oc + c, f1 = xy * oc + zs, f2 = xz * oc - ys;
		double f3 = xy * oc - zs, f4 = ay * ay * oc + c, f5 = yz * oc + xs;
		double f6 = xz * oc + ys, f7 = yz * oc - xs, f8 = az * az * oc + c;
		double f9 = vec[0] * f0 + vec[1] * f1 + vec[2] * f2;
		double ff = vec[0] * f3 + vec[1] * f4 + vec[2] * f5;
		vec[2] = vec[0] * f6 +vec[1] * f7 + vec[2] * f8;
		vec[1] = ff;
		vec[0] = f9;
		return vec;
	}
	
	public static double[] rotate(double[] vec, double r, double p, double y){
		rotate(vec, r, 0, 0, 1);
		rotate(vec, p, 1, 0, 0);
		rotate(vec, y, 0, 1, 0);
		return vec;
	}

}
