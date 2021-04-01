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
		attrs.add(new Attribute.FloatAttribute("weight", 1000f).setMinMax(0, Integer.MAX_VALUE));
		attrs.add(new Attribute.BooleanAttribute("constructor_show", true).setEditable(true));
		attrs.add(new Attribute.FloatAttribute("hitbox_width", 1f).setMinMax(0, 16).setEditable(false));
		attrs.add(new Attribute.FloatAttribute("hitbox_height", 1f).setMinMax(0, 16).setEditable(false));
		attrs.add(new Attribute.FloatAttribute("collision_range", 4f).setMinMax(0, 16).setEditable(false));
		attrs.add(new Attribute.IntegerAttribute("fuel_capacity", 20000).setMinMax(0, Integer.MAX_VALUE));
		attrs.add(new Attribute.StringAttribute("fuel_primary", ""));
		attrs.add(new Attribute.StringAttribute("fuel_secondary", ""));
		attrs.add(new Attribute.FloatAttribute("fuel_quality", 0f).setMinMax(0, 10f));
		attrs.add(new Attribute.IntegerAttribute("fuel_stored", 0).setMinMax(0, Integer.MAX_VALUE));
		//animation
		attrs.add(new Attribute.BooleanAttribute("lights", false).setSeat("driver"));
		attrs.add(new Attribute.FloatAttribute("throttle", 0f).setMinMax(-10f, 10f));
		attrs.add(new Attribute.BooleanAttribute("front_connected", false).setEditable(false));
		attrs.add(new Attribute.BooleanAttribute("rear_connected", false).setEditable(false));
		attrs.add(new Attribute.FloatAttribute("brake_force", 15000f).setMinMax(0, Integer.MAX_VALUE));//control
		attrs.add(new Attribute.FloatAttribute("parking_brake_force", 5000f).setMinMax(0, Integer.MAX_VALUE));//control
		attrs.add(new Attribute.FloatAttribute("roll_resistance", 8f).setMinMax(0, Integer.MAX_VALUE));
		attrs.add(new Attribute.FloatAttribute("air_resistance", 2.5f).setMinMax(0, Integer.MAX_VALUE));
		attrs.add(new Attribute.FloatAttribute("differential_ratio", 3.5f).setMinMax(0, Integer.MAX_VALUE));
		attrs.add(new Attribute.IntegerAttribute("gear", 0).setMinMax(-64, 64));
		attrs.add(new Attribute.FloatAttribute("speed", 0f).setMinMax(Integer.MIN_VALUE, Integer.MAX_VALUE).setEditable(false));
		attrs.add(new Attribute.IntegerAttribute("rpm", 0).setMinMax(0, Integer.MAX_VALUE).setEditable(false));
		attrs.add(new Attribute.IntegerAttribute("generated_keys", 0).setMinMax(0, 8).setEditable(false));
		switch(this){
			case LAND:{
				attrs.add(new Attribute.BooleanAttribute("lights_fog", false).setSeat("driver"));
				attrs.add(new Attribute.BooleanAttribute("lights_long", false).setSeat("driver"));
				attrs.add(new Attribute.BooleanAttribute("lights_other", false).setSeat("driver"));
				//attrs.add(new Attribute.BooleanAttribute("turn_light_left", false).setSeat("driver"));
				//attrs.add(new Attribute.BooleanAttribute("turn_light_right", false).setSeat("driver"));
				attrs.add(new Attribute.TriStateAttribute("turn_lights", null).setSeat("driver"));
				attrs.add(new Attribute.BooleanAttribute("warning_lights", false).setSeat("driver"));
				//
				attrs.add(new Attribute.FloatAttribute("steering_angle", 0f).setMinMax(-90f, 90f));
				attrs.add(new Attribute.FloatAttribute("wheel_angle", 0f).setMinMax(-360f, 360f));
				attrs.add(new Attribute.FloatAttribute("max_steering_angle", 35f).setMinMax(-90f, 90f).setEditable(false));
				attrs.add(new Attribute.FloatAttribute("max_towing", 3500f).setMinMax(1, Integer.MAX_VALUE).setEditable(false));
				if(vehicle.isTrailerOrWagon()){
					attrs.add(new Attribute.FloatAttribute("trailer_weight_ratio", 0.2f).setMinMax(0f, 1f));
				}
				break;
			}
			case RAIL:{
				attrs.add(new Attribute.FloatAttribute("bogie_front_angle", 0f).setMinMax(-360f, 360f));
				attrs.add(new Attribute.FloatAttribute("bogie_rear_angle", 0f).setMinMax(-360f, 360f));
				attrs.add(new Attribute.IntegerAttribute("gauge", 30).setMinMax(Integer.MIN_VALUE, Integer.MAX_VALUE).setEditable(false).setSeat("driver"));
				attrs.add(new Attribute.BooleanAttribute("forward", true).setEditable(false));
				attrs.add(new Attribute.BooleanAttribute("active", false).setEditable(true));//for automatic/steered/AI traffic
				attrs.add(new Attribute.BooleanAttribute("paused", false).setEditable(true));//for automatic/steered/AI traffic
				attrs.add(new Attribute.BooleanAttribute("doors_left", false));
				attrs.add(new Attribute.BooleanAttribute("doors_right", false));
				break;
			}
			default: break;
		}
		return attrs;
	}

}
