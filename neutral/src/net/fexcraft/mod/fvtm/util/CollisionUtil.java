package net.fexcraft.mod.fvtm.util;

import net.fexcraft.lib.common.math.V3D;

/**
 * An implementation of the Separating Axis Theorem for bounding boxes.
 *
 * Thanks to JTK222 for the initial code this was based on!
 */
public class CollisionUtil {

	public static V3D check(OBB a, OBB b){
		return overlaps(a.getCollisionAxes(b), b.verts, a.verts);
	}

	private static V3D overlaps(V3D[] axes, V3D[] b_verts, V3D[] a_verts){
		double min_ov = Double.POSITIVE_INFINITY;
		V3D min_ax = null;

		for(int i = 0; i < axes.length; i++){
			V3D axis = axes[i];

			double b_min = axis.dot(b_verts[0]), a_min = axis.dot(a_verts[0]);
			double b_max = b_min, a_max = a_min;

			if(axis.equals(V3D.NULL)) continue;

			for(int j = 1; j < b_verts.length; j++){
				double val = b_verts[j].dot(axis);
				if(val < b_min) b_min = val;
				if(val > b_max) b_max = val;
			}

			for(int j = 1; j < a_verts.length; j++){
				double val = a_verts[j].dot(axis);
				if(val < a_min) a_min = val;
				if(val > a_max) a_max = val;
			}

			double overlap = a_min < b_min ?
				(a_max < b_min ? 0 : a_max - b_min) :
				(b_max < a_min ? 0 : b_max - a_min);

			if(overlap <= 0) return null;

			if(Math.abs(a_min - b_min) > Math.abs(a_max - b_max)){
				axis = axis.scale(-1d);
			}

			if(overlap < min_ov){
				min_ov = overlap;
				min_ax = axis;
			}
		}
		return min_ax == null ? V3D.NULL : min_ax.scale(min_ov);
	}

}
