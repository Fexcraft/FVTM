package net.fexcraft.mod.fvtm.data;

import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;

public interface SwivelPointMover {
	
	public void update(VehicleEntity entity, SwivelPoint point);
	
	public SwivelPointMover clone();

}
