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
	HELI("Helicraft"),
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
		return this == AIR || this == HELI;
	}

	public boolean isHeli(){
		return this == HELI;
	}
	
	public String getName(){
		return name;
	}
	
	public ArrayList<Attribute<?>> getDefaultAttributesForType(){
		ArrayList<Attribute<?>> attrs = new ArrayList<>();
		//general
		attrs.add(new Attribute.FloatAttribute(true, "weight", 1000f).setMinMax(0, Integer.MAX_VALUE));
		attrs.add(new Attribute.FloatAttribute(true, "constructor_length", 3f).setMinMax(0, 4096).setEditable(true));
		attrs.add(new Attribute.FloatAttribute(true, "constructor_height", 0f).setMinMax(0, 4096).setEditable(true));
		attrs.add(new Attribute.FloatAttribute(true, "constructor_wheel_offset", 16f).setEditable(true).setMinMax(0, 4096));
		attrs.add(new Attribute.BooleanAttribute(true, "constructor_show", true).setEditable(true));
		attrs.add(new Attribute.IntegerAttribute(true, "fuel_capacity", 20000).setMinMax(0, Integer.MAX_VALUE));
		attrs.add(new Attribute.StringAttribute(true, "fuel_primary", ""));
		attrs.add(new Attribute.StringAttribute(true, "fuel_secondary", ""));
		attrs.add(new Attribute.FloatAttribute(true, "fuel_quality", 0f).setMinMax(0, 10f));
		attrs.add(new Attribute.IntegerAttribute(true, "fuel_stored", 0).setMinMax(0, Integer.MAX_VALUE));
		//animation
		attrs.add(new Attribute.FloatAttribute(true, "steering_angle", 0f).setMinMax(-40f, 40f));
		attrs.add(new Attribute.FloatAttribute(true, "wheel_angle", 0f).setMinMax(-360f, 360f));
		attrs.add(new Attribute.FloatAttribute(true, "throttle", 0f).setMinMax(-10f, 10f));
		attrs.add(new Attribute.BooleanAttribute(true, "lights", false));
		attrs.add(new Attribute.BooleanAttribute(true, "lights_fog", false));
		attrs.add(new Attribute.BooleanAttribute(true, "lights_long", false));
		attrs.add(new Attribute.BooleanAttribute(true, "lights_other", false));
		//TODO
		switch(this){
			//TODO type specific
			default: break;
		}
		return attrs;
	}

}
