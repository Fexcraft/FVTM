package net.fexcraft.mod.fvtm.impl;


import net.fexcraft.lib.common.math.V3D;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class AABBI extends net.fexcraft.mod.fvtm.data.block.AABB {

	private AABB aabb;

	public AABBI(){
	}

	public AABBI(AABB albb){
		aabb = albb;
	}

	@Override
	public net.fexcraft.mod.fvtm.data.block.AABB set(float sx, float sy, float sz, float ex, float ey, float ez){
		aabb = new AABB(sx, sy, sz, ex, ey, ez);
		return this;
	}

	@Override
	public <AB> AB local(){
		return (AB)aabb;
	}

	@Override
	public Object direct(){
		return aabb;
	}

	@Override
	public net.fexcraft.mod.fvtm.data.block.AABB offset(int x, int y, int z){
		AABB nbb = new AABB(aabb.minX + x, aabb.minY + y, aabb.minZ + z, aabb.maxX + x, aabb.maxY + y, aabb.maxZ + z);
		return new AABBI(nbb);
	}

	@Override
	public net.fexcraft.mod.fvtm.data.block.AABB offset(V3D vec){
		AABB nbb = new AABB(aabb.minX + vec.x, aabb.minY + vec.y, aabb.minZ + vec.z, aabb.maxX + vec.x, aabb.maxY + vec.y, aabb.maxZ + vec.z);
		return new AABBI(nbb);
	}

	@Override
	public boolean contains(V3D vec){
		return aabb.contains(vec.x, vec.y, vec.z);
	}

	@Override
	public boolean contains(Object vec){
		return aabb.contains((Vec3)vec);
	}

}
