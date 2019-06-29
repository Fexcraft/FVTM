package net.fexcraft.mod.fvtm.data.vehicle;

import java.util.ArrayList;
import net.fexcraft.mod.fvtm.data.root.Attribute;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
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
	
	public ArrayList<Attribute> getDefaultAttributesForType(){
		ArrayList<Attribute> attrs = new ArrayList<>();
		//general
		attrs.add(new Attribute.FloatAttribute(true, "weight", 1000f).setMinMax(0, Integer.MAX_VALUE));
		attrs.add(new Attribute.FloatAttribute(true, "constructor_length", 3f).setMinMax(0, 4096));
		attrs.add(new Attribute.FloatAttribute(true, "constructor_height", 0).setMinMax(0, 4096));
		attrs.add(new Attribute.FloatAttribute(true, "constructor_wheel_offset", 16).setMinMax(0, 4096));
		attrs.add(new Attribute.IntegerAttribute(true, "constructor_show", 1, true));
		attrs.add(new Attribute.FloatAttribute(true, "steering_angle", 0).setMinMax(-40, 40));
		attrs.add(new Attribute.FloatAttribute(true, "wheel_angle", 0).setMinMax(-360, 360));
		//TODO
		switch(this){
			//TODO type specific
			default: break;
		}
		return attrs;
	}

}
