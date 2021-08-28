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

}
