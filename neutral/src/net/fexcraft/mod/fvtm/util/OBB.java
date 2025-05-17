package net.fexcraft.mod.fvtm.util;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonMap;
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

	public OBB set(AABB aabb){
		verts[0].set(aabb.minX(), aabb.minY(), aabb.minZ());
		verts[1].set(aabb.minX(), aabb.minY(), aabb.maxZ());
		verts[2].set(aabb.minX(), aabb.maxY(), aabb.minZ());
		verts[3].set(aabb.minX(), aabb.maxY(), aabb.maxZ());
		verts[4].set(aabb.maxX(), aabb.minY(), aabb.minZ());
		verts[5].set(aabb.maxX(), aabb.minY(), aabb.maxZ());
		verts[6].set(aabb.maxX(), aabb.maxY(), aabb.minZ());
		verts[7].set(aabb.maxX(), aabb.maxY(), aabb.maxZ());
		genAxes();
		return this;
	}

	private void genAxes(){
		verts[0].sub(verts[1]).normalize(axes[0]);
		verts[0].sub(verts[2]).normalize(axes[1]);
		verts[0].sub(verts[4]).normalize(axes[2]);
	}

	public void update(SwivelPoint point, V3D pos, V3D veh, double x, double y, double z){
		verts[0].set(-(x *= 0.5) + pos.x, -(y *= 0.5) + pos.y, -(z *= 0.5) + pos.z);
		verts[1].set(-x + pos.x, -y + pos.y, +z + pos.z);
		verts[2].set(-x + pos.x, +y + pos.y, -z + pos.z);
		verts[3].set(-x + pos.x, +y + pos.y, +z + pos.z);
		verts[4].set(+x + pos.x, -y + pos.y, -z + pos.z);
		verts[5].set(+x + pos.x, -y + pos.y, +z + pos.z);
		verts[6].set(+x + pos.x, +y + pos.y, -z + pos.z);
		verts[7].set(+x + pos.x, +y + pos.y, +z + pos.z);
		for(int i = 0; i < verts.length; i++){
			V3D rel = point.getRelativeVector(verts[i]);
			verts[i].x = rel.x + veh.x;
			verts[i].y = rel.y + veh.y;
			verts[i].z = rel.z + veh.z;
		}
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

	public static class OBBRef {

		public String point;
		public String key;
		public V3D pos;
		public V3D size;

		public OBBRef(String key, JsonMap map){
			this.key = key;
			pos = ContentConfigUtil.getVector(map.getArray("pos"));
			size = map.has("size") ? ContentConfigUtil.getVector(map.getArray("size")) : new V3D(1, 1, 1);
			point = map.getString("point", SwivelPoint.DEFAULT);
		}

	}

}
