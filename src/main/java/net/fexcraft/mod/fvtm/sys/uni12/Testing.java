package net.fexcraft.mod.fvtm.sys.uni12;

import net.fexcraft.lib.common.math.Vec3f;

public class Testing {
	
	public static void main(){
		float engineforce = 2;
		Vec3f dir = new Vec3f(1, 0, 0).normalize();
		Vec3f traction = dir.scale(engineforce);
		
		float c_drag = 1f;
		//Vec3f drag = 
	}

}
