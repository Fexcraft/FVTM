package net.fexcraft.mod.fvtm.data.vehicle;

import java.util.UUID;

public interface VehicleEntity {
	
	public VehicleData getVehicleData();
	
	public VehicleType getVehicleType();
	
	public net.minecraft.entity.Entity getEntity();
	
	public UUID getPlacer();
	
	public VehicleEntity getCoupledEntity(boolean front);

}
