package net.fexcraft.mod.fvtm.util;

import net.fexcraft.lib.common.math.Vec3f;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class MiniBB {
	
	private float x0, x1, y0, y1, z0, z1;
	public Vec3f center = new Vec3f();
	
	public MiniBB(Vec3f pos, float radius){
		update(pos, radius);
	}
	
	public MiniBB(Vec3f one, Vec3f two){
		update(one, two);
	}
	
    public MiniBB(){}

	public boolean contains(Vec3f vec){
        if(vec.x >= this.x0 && vec.x <= this.x1){
            if(vec.y >= this.y0 && vec.y <= this.y1){
                return vec.z >= this.z0 && vec.z <= this.z1;
            }
        } return false;
    }
    
    public MiniBB update(Vec3f pos, float radius){
		x0 = pos.x - radius; x1 = pos.x + radius;
		y0 = pos.y - radius; y1 = pos.y + radius;
		z0 = pos.z - radius; z1 = pos.z + radius;
		center = pos/*new Vec3f(pos)*/; return this;
    }
    
    public MiniBB update(Vec3f one, Vec3f two){
		x0 = Math.min(one.x, two.x); x1 = Math.max(one.x, two.x);
		y0 = Math.min(one.y, two.y); y1 = Math.max(one.y, two.y);
		z0 = Math.min(one.z, two.z); z1 = Math.max(one.z, two.z);
		center = new Vec3f((x0 + x1) * 0.5f, (y0 + y1) * 0.5f, (z0 + z1) * 0.5f); return this;
    }

	public MiniBB update(Vec3f one, Vec3f two, float addition){
		this.update(one, two); x0 -= addition; x1 += addition;
		y0 -= addition; y1 += addition; z0 -= addition; z1 += addition;
		return this;
	}
    
}
