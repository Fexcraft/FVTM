package net.fexcraft.mod.fvtm.api;

public enum VehicleType {
	
	LAND, AIR, WATER, RAIL, NULL;
	
	VehicleType(){
		//
	}
	
	public static VehicleType fromString(String string){
		string = string.toUpperCase();
		for(VehicleType type : values()){
			if(type.name().equals(string)) {
				return type;
			}
		}
		return LAND;
	}
	
}