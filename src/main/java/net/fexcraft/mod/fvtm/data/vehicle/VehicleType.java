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
	
	public ArrayList<Attribute<?>> getDefaultAttributesForType(Vehicle vehicle){
		ArrayList<Attribute<?>> attrs = new ArrayList<>();
		//general
		attrs.add(new Attribute.FloatAttribute(true, "weight", 1000f).setMinMax(0, Integer.MAX_VALUE));
		attrs.add(new Attribute.BooleanAttribute(true, "constructor_show", true).setEditable(true));
		attrs.add(new Attribute.FloatAttribute(true, "hitbox_width", 1f).setMinMax(0, 16).setEditable(false));
		attrs.add(new Attribute.FloatAttribute(true, "hitbox_height", 1f).setMinMax(0, 16).setEditable(false));
		attrs.add(new Attribute.FloatAttribute(true, "collision_range", 4f).setMinMax(0, 16).setEditable(false));
		attrs.add(new Attribute.IntegerAttribute(true, "fuel_capacity", 20000).setMinMax(0, Integer.MAX_VALUE));
		attrs.add(new Attribute.StringAttribute(true, "fuel_primary", ""));
		attrs.add(new Attribute.StringAttribute(true, "fuel_secondary", ""));
		attrs.add(new Attribute.FloatAttribute(true, "fuel_quality", 0f).setMinMax(0, 10f));
		attrs.add(new Attribute.IntegerAttribute(true, "fuel_stored", 0).setMinMax(0, Integer.MAX_VALUE));
		//animation
		attrs.add(new Attribute.BooleanAttribute(true, "lights", false).setSeat("driver"));
		attrs.add(new Attribute.FloatAttribute(true, "throttle", 0f).setMinMax(-10f, 10f));
		attrs.add(new Attribute.BooleanAttribute(true, "front_connected", false).setEditable(false));
		attrs.add(new Attribute.BooleanAttribute(true, "rear_connected", false).setEditable(false));
		attrs.add(new Attribute.FloatAttribute(true, "brake_force", 15000f).setMinMax(0, Integer.MAX_VALUE));//control
		attrs.add(new Attribute.FloatAttribute(true, "parking_brake_force", 5000f).setMinMax(0, Integer.MAX_VALUE));//control
		attrs.add(new Attribute.FloatAttribute(true, "roll_resistance", 8f).setMinMax(0, Integer.MAX_VALUE));
		attrs.add(new Attribute.FloatAttribute(true, "air_resistance", 2.5f).setMinMax(0, Integer.MAX_VALUE));
		attrs.add(new Attribute.FloatAttribute(true, "differential_ratio", 3.5f).setMinMax(0, Integer.MAX_VALUE));
		attrs.add(new Attribute.IntegerAttribute(true, "gear", 0).setMinMax(-64, 64));
		switch(this){
			case LAND:{
				attrs.add(new Attribute.BooleanAttribute(true, "lights_fog", false).setSeat("driver"));
				attrs.add(new Attribute.BooleanAttribute(true, "lights_long", false).setSeat("driver"));
				attrs.add(new Attribute.BooleanAttribute(true, "lights_other", false).setSeat("driver"));
				//attrs.add(new Attribute.BooleanAttribute(true, "turn_light_left", false).setSeat("driver"));
				//attrs.add(new Attribute.BooleanAttribute(true, "turn_light_right", false).setSeat("driver"));
				attrs.add(new Attribute.TriStateAttribute(true, "turn_lights", null).setSeat("driver"));
				attrs.add(new Attribute.BooleanAttribute(true, "warning_lights", false).setSeat("driver"));
				//
				attrs.add(new Attribute.FloatAttribute(true, "steering_angle", 0f).setMinMax(-90f, 90f));
				attrs.add(new Attribute.FloatAttribute(true, "wheel_angle", 0f).setMinMax(-360f, 360f));
				attrs.add(new Attribute.FloatAttribute(true, "max_steering_angle", 35f).setMinMax(-90f, 90f).setEditable(false));
				if(vehicle.isTrailerOrWagon()){
					attrs.add(new Attribute.FloatAttribute(true, "trailer_weight_ratio", 0.2f).setMinMax(0f, 1f));
				}
				break;
			}
			case RAIL:{
				attrs.add(new Attribute.FloatAttribute(true, "bogie_front_angle", 0f).setMinMax(-360f, 360f));
				attrs.add(new Attribute.FloatAttribute(true, "bogie_rear_angle", 0f).setMinMax(-360f, 360f));
				attrs.add(new Attribute.IntegerAttribute(true, "gauge", 30).setMinMax(Integer.MIN_VALUE, Integer.MAX_VALUE).setEditable(false).setSeat("driver"));
				attrs.add(new Attribute.BooleanAttribute(true, "forward", true).setEditable(false));
				attrs.add(new Attribute.BooleanAttribute(true, "active", false).setEditable(true));//for automatic/steered/AI traffic
				attrs.add(new Attribute.BooleanAttribute(true, "paused", false).setEditable(true));//for automatic/steered/AI traffic
				attrs.add(new Attribute.BooleanAttribute(true, "doors_left", false));
				attrs.add(new Attribute.BooleanAttribute(true, "doors_right", false));
				break;
			}
			default: break;
		}
		return attrs;
	}

}
