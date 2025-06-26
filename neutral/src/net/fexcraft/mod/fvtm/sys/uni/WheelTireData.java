package net.fexcraft.mod.fvtm.sys.uni;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.data.vehicle.WheelSlot;
import net.fexcraft.mod.fvtm.function.part.TireFunction.TireAttr;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class WheelTireData {

	public final String id;
	public WheelSlot slot;
	public V3D pos;
	public Axle axle;
	public TireAttr function;
	public boolean steering;
	public boolean mirror;
	public float radius;
	public float rotation;

	public WheelTireData(String key){
		this.id = key;
	}

	public WheelTireData(){
		id = "null";
		pos = V3D.NULL;
	}

	public void asTrailerFront(WheelTireData rear){
		pos = new V3D(rear.pos.x, rear.pos.y, 0);
		axle = rear.axle;
		function = rear.function;
	}

	@Override
	public String toString(){
		return "WTD{" + id + " " + pos + "}";
	}

}
