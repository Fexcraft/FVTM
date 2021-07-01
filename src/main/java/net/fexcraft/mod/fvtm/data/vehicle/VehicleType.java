package net.fexcraft.mod.fvtm.data.vehicle;

import java.util.ArrayList;
import java.util.UUID;

import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.data.attribute.BooleanAttribute;
import net.fexcraft.mod.fvtm.data.attribute.FloatAttribute;
import net.fexcraft.mod.fvtm.data.attribute.IntegerAttribute;
import net.fexcraft.mod.fvtm.data.attribute.LongAttribute;
import net.fexcraft.mod.fvtm.data.attribute.StringAttribute;
import net.fexcraft.mod.fvtm.data.attribute.TriStateAttribute;

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
		attrs.add(new FloatAttribute("weight", 1000f).minmax(0, Integer.MAX_VALUE));
		attrs.add(new BooleanAttribute("constructor_show", true).editable(true));
		attrs.add(new FloatAttribute("hitbox_width", 1f).minmax(0, 16).editable(false));
		attrs.add(new FloatAttribute("hitbox_height", 1f).minmax(0, 16).editable(false));
		attrs.add(new FloatAttribute("collision_range", 4f).minmax(0, 16).editable(false));
		attrs.add(new IntegerAttribute("fuel_capacity", 20000).minmax(0, Integer.MAX_VALUE));
		attrs.add(new StringAttribute("fuel_primary", ""));
		attrs.add(new StringAttribute("fuel_secondary", ""));
		attrs.add(new FloatAttribute("fuel_quality", 0f).minmax(0, 10f));
		attrs.add(new IntegerAttribute("fuel_stored", 0).minmax(0, Integer.MAX_VALUE));
		//animation
		attrs.add(new BooleanAttribute("lights", false).addSeat("driver").sync(true));
		attrs.add(new FloatAttribute("throttle", 0f).minmax(-10f, 10f));
		attrs.add(new BooleanAttribute("front_connected", false).editable(false));
		attrs.add(new BooleanAttribute("rear_connected", false).editable(false));
		attrs.add(new FloatAttribute("brake_force", 15000f).minmax(0, Integer.MAX_VALUE));//control
		attrs.add(new FloatAttribute("parking_brake_force", 5000f).minmax(0, Integer.MAX_VALUE));//control
		attrs.add(new FloatAttribute("roll_resistance", 8f).minmax(0, Integer.MAX_VALUE));
		attrs.add(new FloatAttribute("air_resistance", 2.5f).minmax(0, Integer.MAX_VALUE));
		attrs.add(new FloatAttribute("differential_ratio", 3.5f).minmax(0, Integer.MAX_VALUE));
		attrs.add(new IntegerAttribute("gear", 0).minmax(-64, 64));
		attrs.add(new FloatAttribute("speed", 0f).minmax(Integer.MIN_VALUE, Integer.MAX_VALUE).editable(false));
		attrs.add(new IntegerAttribute("rpm", 0).minmax(0, Integer.MAX_VALUE).editable(false));
		attrs.add(new IntegerAttribute("generated_keys", 0).minmax(0, 8).editable(false));
		switch(this){
			case LAND:{
				attrs.add(new BooleanAttribute("lights_fog", false).addSeat("driver").sync(true));
				attrs.add(new BooleanAttribute("lights_long", false).addSeat("driver").sync(true));
				attrs.add(new BooleanAttribute("lights_other", false).addSeat("driver").sync(true));
				//attrs.add(new BooleanAttribute("turn_light_left", false).setSeat("driver"));
				//attrs.add(new BooleanAttribute("turn_light_right", false).setSeat("driver"));
				attrs.add(new TriStateAttribute("turn_lights", (Boolean)null).addSeat("driver").sync(true));
				attrs.add(new BooleanAttribute("warning_lights", false).addSeat("driver").sync(true));
				//
				attrs.add(new FloatAttribute("steering_angle", 0f).minmax(-90f, 90f));
				attrs.add(new FloatAttribute("wheel_angle", 0f).minmax(-360f, 360f));
				attrs.add(new FloatAttribute("max_steering_angle", 35f).minmax(-90f, 90f).editable(false));
				attrs.add(new FloatAttribute("max_towing", 3500f).minmax(1, Integer.MAX_VALUE).editable(false));
				if(vehicle.isTrailerOrWagon()){
					attrs.add(new FloatAttribute("trailer_weight_ratio", 0.2f).minmax(0f, 1f));
				}
				attrs.add(new StringAttribute("license_plate", UUID.randomUUID().toString().replace("-", "").substring(0, 8)).editable(true));//TODO not editable later
				break;
			}
			case RAIL:{
				attrs.add(new FloatAttribute("bogie_front_angle", 0f).minmax(-360f, 360f));
				attrs.add(new FloatAttribute("bogie_rear_angle", 0f).minmax(-360f, 360f));
				attrs.add(new IntegerAttribute("gauge", 30).minmax(Integer.MIN_VALUE, Integer.MAX_VALUE).editable(false).addSeat("driver"));
				attrs.add(new BooleanAttribute("forward", true).editable(false));
				attrs.add(new BooleanAttribute("active", false).editable(true));//for automatic/steered/AI traffic
				attrs.add(new BooleanAttribute("paused", false).editable(true));//for automatic/steered/AI traffic
				attrs.add(new BooleanAttribute("doors_left", false).sync(true).group("mirror_lr"));
				attrs.add(new BooleanAttribute("doors_right", false).sync(true).group("mirror_lr"));
				attrs.add(new LongAttribute("section_on", 0l));
				break;
			}
			default: break;
		}
		return attrs;
	}

}
