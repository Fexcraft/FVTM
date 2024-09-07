package net.fexcraft.mod.fvtm.data.vehicle;

import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;

public interface SwivelPointMover {
	
	public void update(VehicleInstance vehicle, SwivelPoint point);
	
	public SwivelPointMover clone();
	
	public boolean shouldUpdate();

}
