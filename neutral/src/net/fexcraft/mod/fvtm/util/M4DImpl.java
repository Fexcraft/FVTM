package net.fexcraft.mod.fvtm.util;

import net.fexcraft.lib.common.math.M4DW;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3F;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class M4DImpl extends M4DW {

	private Matrix matrix = new Matrix();

	@Override
	public void rotate(double am, int axe){
		switch(axe){
			case 0: matrix.rotateX((float)am, 1f); break;
			case 1: matrix.rotateY((float)am, 1f); break;
			case 2: matrix.rotateZ((float)am, 1f); break;
		}
	}

	@Override
	protected void reset(double x, double y, double z){
		matrix.reset();
		matrix.set((float)x, (float)y, (float)z);
	}

	@Override
	protected V3D fill(V3D vec){
		return vec.set(matrix.m0[0], matrix.m1[0], matrix.m2[0]);
	}

	@Override
	protected V3F fill(V3F vec){
		return vec.set(matrix.m0[0], (float)matrix.m1[0], (float)matrix.m2[0]);
	}

	@Override
	protected void norm(){
		yaw = Math.atan2(matrix.m2[0], matrix.m0[0]);
		pit = Math.atan2(-matrix.m1[0], Math.sqrt(matrix.m1[2] * matrix.m1[2] + matrix.m1[1] * matrix.m1[1]));
		rol = Math.atan2(matrix.m1[2], matrix.m1[1]);
	}

}
