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
        if(vec.xCoord >= this.x0 && vec.xCoord <= this.x1){
            if(vec.yCoord >= this.y0 && vec.yCoord <= this.y1){
                return vec.zCoord >= this.z0 && vec.zCoord <= this.z1;
            }
        } return false;
    }
    
    public MiniBB update(Vec3f pos, float radius){
		x0 = pos.xCoord - radius; x1 = pos.xCoord + radius;
		y0 = pos.yCoord - radius; y1 = pos.yCoord + radius;
		z0 = pos.zCoord - radius; z1 = pos.zCoord + radius;
		center = pos/*new Vec3f(pos)*/; return this;
    }
    
    public MiniBB update(Vec3f one, Vec3f two){
		x0 = Math.min(one.xCoord, two.xCoord); x1 = Math.max(one.xCoord, two.xCoord);
		y0 = Math.min(one.yCoord, two.yCoord); y1 = Math.max(one.yCoord, two.yCoord);
		z0 = Math.min(one.zCoord, two.zCoord); z1 = Math.max(one.zCoord, two.zCoord);
		center = new Vec3f((x0 + x1) * 0.5f, (y0 + y1) * 0.5f, (z0 + z1) * 0.5f); return this;
    }

	public MiniBB update(Vec3f one, Vec3f two, float addition){
		this.update(one, two); x0 -= addition; x1 += addition;
		y0 -= addition; y1 += addition; z0 -= addition; z1 += addition;
		return this;
	}
    
}
