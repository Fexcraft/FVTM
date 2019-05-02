package net.fexcraft.mod.fvtm.data;

import java.util.List;

import net.fexcraft.mod.fvtm.data.root.Attribute;

public enum VehicleType {
	
	LAND("Landvehicle"),
	WATER("Watercraft"),
	RAIL("Railvehicle"),
	AIR("Aircraft"),
	SPACE("Spacecraft");
	
	private String name;
	
	private VehicleType(String name){
		this.name = name;
	}
	
	public boolean isLandVehicle(){
		return this == LAND;
	}
	
	public boolean isWaterVehicle(){
		return this == WATER;
	}
	
	public boolean isRailVehicle(){
		return this == RAIL;
	}
	
	public boolean isAirVehicle(){
		return this == AIR;
	}
	
	public String getName(){
		return name;
	}
	
	public List<Attribute> getDefaultAttributesForType(){
		//TODO
		return null;
	}

}
