package net.fexcraft.mod.fvtm.data.vehicle;

import java.util.UUID;

import net.fexcraft.mod.fvtm.data.SwivelPoint;

public interface VehicleEntity {
	
	public VehicleData getVehicleData();
	
	public VehicleType getVehicleType();
	
	public net.minecraft.entity.Entity getEntity();
	
	public UUID getPlacer();
	
	public VehicleEntity getCoupledEntity(boolean front);
	public default VehicleEntity getFrontCoupledEntity(){ return getCoupledEntity(true); }
	public default VehicleEntity getRearCoupledEntity(){ return getCoupledEntity(false); }
	
	public boolean isLocked();

	public SwivelPoint getRotPoint();

}
