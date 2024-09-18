package net.fexcraft.mod.fvtm.util;

import net.fexcraft.lib.common.math.V3D;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class MiniBB {
	
	private double x0, x1, y0, y1, z0, z1;
	public V3D center = new V3D();
	
	public MiniBB(V3D pos, double radius){
		update(pos, radius);
	}
	
	public MiniBB(V3D one, V3D two){
		update(one, two);
	}
	
    public MiniBB(){}

	public boolean contains(V3D vec){
        if(vec.x >= this.x0 && vec.x <= this.x1){
            if(vec.y >= this.y0 && vec.y <= this.y1){
                return vec.z >= this.z0 && vec.z <= this.z1;
            }
        } return false;
    }
    
    public MiniBB update(V3D pos, double radius){
		x0 = pos.x - radius; x1 = pos.x + radius;
		y0 = pos.y - radius; y1 = pos.y + radius;
		z0 = pos.z - radius; z1 = pos.z + radius;
		center = pos;
		return this;
    }
    
    public MiniBB update(V3D one, V3D two){
		x0 = Math.min(one.x, two.x); x1 = Math.max(one.x, two.x);
		y0 = Math.min(one.y, two.y); y1 = Math.max(one.y, two.y);
		z0 = Math.min(one.z, two.z); z1 = Math.max(one.z, two.z);
		center = new V3D((x0 + x1) * 0.5f, (y0 + y1) * 0.5f, (z0 + z1) * 0.5f);
		return this;
    }

	public MiniBB update(V3D one, V3D two, float addition){
		this.update(one, two);
		x0 -= addition; x1 += addition;
		y0 -= addition; y1 += addition;
		z0 -= addition; z1 += addition;
		return this;
	}
    
}
