package net.fexcraft.mod.fvtm.sys.uni12;

import net.fexcraft.mod.fvtm.util.function.TireFunction.TireAttr;
import net.minecraft.util.math.Vec3d;

public class WTD {

	public final String id;
	public Vec3d pos;
	public Axle axle;
	public TireAttr function;

	public WTD(String key){
		this.id = key;
	}

}
