package net.fexcraft.mod.fvtm.util;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.data.block.AABB;
import net.fexcraft.mod.fvtm.data.vehicle.SwivelPoint;

/**
 * Universal class for FVTM OBB Collisions.
 */
public class OBB {

	public V3D[] axes = new V3D[3];
	public V3D[] verts = new V3D[8];

	public OBB(){
		for(int i = 0; i < axes.length; i++){
			axes[i] = new V3D();
		}
		for(int i = 0; i < verts.length; i++){
			verts[i] = new V3D();
		}
	}

	public OBB set(AABB aabb, V3D pos){
		verts[0].set(aabb.minX() + pos.x, aabb.minY() + pos.y, aabb.minZ() + pos.z);
		verts[1].set(aabb.minX() + pos.x, aabb.minY() + pos.y, aabb.maxZ() + pos.z);
		verts[2].set(aabb.minX() + pos.x, aabb.maxY() + pos.y, aabb.minZ() + pos.z);
		verts[3].set(aabb.minX() + pos.x, aabb.maxY() + pos.y, aabb.maxZ() + pos.z);
		verts[4].set(aabb.maxX() + pos.x, aabb.minY() + pos.y, aabb.minZ() + pos.z);
		verts[5].set(aabb.maxX() + pos.x, aabb.minY() + pos.y, aabb.maxZ() + pos.z);
		verts[6].set(aabb.maxX() + pos.x, aabb.maxY() + pos.y, aabb.minZ() + pos.z);
		verts[7].set(aabb.maxX() + pos.x, aabb.maxY() + pos.y, aabb.maxZ() + pos.z);
		genAxes();
		return this;
	}

	private void genAxes(){
		axes[0] = verts[0].sub(verts[1]).normalize();
		axes[1] = verts[0].sub(verts[2]).normalize();
		axes[2] = verts[0].sub(verts[4]).normalize();
	}

	public void update(SwivelPoint point, V3D vec, double x, double y, double z){
		verts[0].set(-(x *= 0.5), -(y *= 0.5), -(z *= 0.5));
		verts[1].set(-x, -y, +z);
		verts[2].set(-x, +y, -z);
		verts[3].set(-x, +y, +z);
		verts[4].set(+x, -y, -z);
		verts[5].set(+x, -y, +z);
		verts[6].set(+x, +y, -z);
		verts[7].set(+x, +y, +z);
		for(int i = 0; i < verts.length; i++) verts[i] = point.getPivot().get_vector(verts[i]).add(vec);
		genAxes();
	}

	public V3D[] getCollisionAxes(OBB obb){
		return new V3D[]{
			axes[0],
			axes[1],
			axes[2],
			obb.axes[0],
			obb.axes[1],
			obb.axes[2],
			axes[0].cross(obb.axes[0]).normalize(),
			axes[0].cross(obb.axes[1]).normalize(),
			axes[0].cross(obb.axes[2]).normalize(),
			axes[1].cross(obb.axes[0]).normalize(),
			axes[1].cross(obb.axes[1]).normalize(),
			axes[1].cross(obb.axes[2]).normalize(),
			axes[2].cross(obb.axes[0]).normalize(),
			axes[2].cross(obb.axes[1]).normalize(),
			axes[2].cross(obb.axes[2]).normalize(),
		};
	}

}
