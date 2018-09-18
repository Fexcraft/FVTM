package net.fexcraft.mod.fvtm.util;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

/**
 * @author Ferdinand Calo' (FEX___96)
 * Util class to prevent constant creation of new Vec3d or similar objects.
 * */
public class Vector3D {
	
	/** Adds <b>0.5D</b> to every coordinate. */
	public static double[] newVector(BlockPos pos){
		return new double[]{ pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5 };
	}

	public static double[] newVector(double x, double y, double z){
		return new double[]{ x, y, z };
	}

	public static double[] newVector(Vec3d vec){
		return new double[]{ vec.x, vec.y, vec.z };
	}
	
	/** Array of 3 values expected. **/
    public static double length(double... arr){
        return Math.sqrt(arr[0] * arr[0] + arr[1] * arr[1] + arr[2] * arr[2]);
    }
    
    public static double distance(double[] first, double[] second){
        return length(second[0] - first[0], second[1] - first[1], second[2] - first[2]);
    }
    
    public static double[] direction(double... arr){
    	double l = length(arr[0], arr[1], arr[2]); return new double[]{ arr[0] / l, arr[1] / l, arr[2] / l };
    }
	
}