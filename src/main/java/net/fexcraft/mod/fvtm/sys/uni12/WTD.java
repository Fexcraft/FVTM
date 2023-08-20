package net.fexcraft.mod.fvtm.sys.uni12;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.util.function.TireFunction.TireAttr;

public class WTD {

	public final String id;
	public V3D pos;
	public Axle axle;
	public TireAttr function;

	public WTD(String key){
		this.id = key;
	}

}
