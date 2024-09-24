package net.fexcraft.mod.fvtm.data.vehicle;

import java.util.ArrayList;

import net.fexcraft.mod.fvtm.data.attribute.AttrBoolean;
import net.fexcraft.mod.fvtm.data.attribute.AttrFloat;
import net.fexcraft.mod.fvtm.data.attribute.AttrInteger;
import net.fexcraft.mod.fvtm.data.attribute.AttrString;
import net.fexcraft.mod.fvtm.data.attribute.AttrTristate;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;

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
	
	public ArrayList<Attribute<?>> getDefaultAttributesForType(boolean trailer){
		ArrayList<Attribute<?>> attrs = new ArrayList<>();
		//general
		attrs.add(new AttrFloat("weight", 1000f).limit(0, Integer.MAX_VALUE));
		attrs.add(new AttrBoolean("constructor_show", true).editable(true));
		attrs.add(new AttrFloat("hitbox_width", 1f).limit(0, 16).editable(false));
		attrs.add(new AttrFloat("hitbox_height", 1f).limit(0, 16).editable(false));
		attrs.add(new AttrInteger("fuel_capacity", 20000).limit(0, Integer.MAX_VALUE));
		attrs.add(new AttrString("fuel_primary", ""));
		attrs.add(new AttrString("fuel_secondary", ""));
		attrs.add(new AttrFloat("fuel_quality", 0f).limit(0, 10f));
		attrs.add(new AttrInteger("fuel_stored", 0).limit(0, Integer.MAX_VALUE));
		//animation
		attrs.add(new AttrBoolean("lights", false).addAccess("driver").sync(true)
			.addIcons("true", "fvtm:textures/gui/icons/lights_low_on.png", "false", "fvtm:textures/gui/icons/lights_low_off.png"));
		attrs.add(new AttrFloat("throttle", 0f).limit(-10f, 10f));
		attrs.add(new AttrBoolean("front_connected", false).editable(false));
		attrs.add(new AttrBoolean("rear_connected", false).editable(false));
		attrs.add(new AttrFloat("brake_force", 15000f).limit(0, Integer.MAX_VALUE));//control
		attrs.add(new AttrFloat("parking_brake_force", 5000f).limit(0, Integer.MAX_VALUE));//control
		attrs.add(new AttrFloat("roll_resistance", 8f).limit(0, Integer.MAX_VALUE));
		attrs.add(new AttrFloat("air_resistance", 2.5f).limit(0, Integer.MAX_VALUE));
		attrs.add(new AttrFloat("differential_ratio", 3.5f).limit(0, Integer.MAX_VALUE));
		attrs.add(new AttrInteger("gear", 0).limit(-64, 64));
		attrs.add(new AttrFloat("speed", 0f).limit(Integer.MIN_VALUE, Integer.MAX_VALUE).editable(false));
		attrs.add(new AttrInteger("rpm", 0).limit(0, Integer.MAX_VALUE).editable(false));
		attrs.add(new AttrInteger("generated_keys", 0).limit(0, 8).editable(false));
		switch(this){
			case LAND:{
				attrs.add(new AttrBoolean("lights_fog", false).editable(true).addAccess("driver").sync(true)
					.addIcons("true", "fvtm:textures/gui/icons/lights_fog_on.png", "false", "fvtm:textures/gui/icons/lights_fog_off.png"));
				attrs.add(new AttrBoolean("lights_long", false).editable(true).addAccess("driver").sync(true)
					.addIcons("true", "fvtm:textures/gui/icons/lights_high_on.png", "false", "fvtm:textures/gui/icons/lights_high_off.png"));
				attrs.add(new AttrBoolean("lights_other", false).editable(true).addAccess("driver").sync(true));
				//attrs.add(new AttrBoolean("turn_light_left", false).setSeat("driver"));
				//attrs.add(new AttrBoolean("turn_light_right", false).setSeat("driver"));
				attrs.add(new AttrTristate("turn_lights", (Boolean)null).editable(true).addAccess("driver").sync(true)
					.addIcons("true", "fvtm:textures/gui/icons/turn_indicator_right.png", "false", "fvtm:textures/gui/icons/turn_indicator_left.png", "null", "fvtm:textures/gui/icons/turn_indicator.png"));
				attrs.add(new AttrBoolean("warning_lights", false).editable(true).addAccess("driver").sync(true)
					.addIcons("true", "fvtm:textures/gui/icons/warning_lights_on.png", "false", "fvtm:textures/gui/icons/warning_lights_off.png"));
				//
				attrs.add(new AttrFloat("steering_angle", 0f).limit(-90f, 90f));
				attrs.add(new AttrFloat("wheel_angle", 0f).limit(-360f, 360f));
				attrs.add(new AttrFloat("max_steering_angle", 35f).limit(-90f, 90f).editable(false));
				attrs.add(new AttrFloat("max_towing", 3500f).limit(1, Integer.MAX_VALUE).editable(false));
				if(trailer){
					attrs.add(new AttrFloat("trailer_weight_ratio", 0.2f).limit(0f, 1f));
				}
				attrs.add(new AttrString("license_plate", "FVTM").addAccess("external").editable(false).perm("fvtm.attribute.license_plate"));
				attrs.add(new AttrInteger("lug_size", 0).limit(0, 8));
				break;
			}
			case RAIL:{
				attrs.add(new AttrFloat("bogie_front_angle", 0f).limit(-360f, 360f));
				attrs.add(new AttrFloat("bogie_rear_angle", 0f).limit(-360f, 360f));
				attrs.add(new AttrInteger("gauge", 30).limit(Integer.MIN_VALUE, Integer.MAX_VALUE).editable(false).addAccess("driver"));
				attrs.add(new AttrBoolean("forward", true).editable(false));
				attrs.add(new AttrBoolean("active", false).editable(true));//for automatic/steered/AI traffic
				attrs.add(new AttrBoolean("paused", false).editable(true));//for automatic/steered/AI traffic
				attrs.add(new AttrBoolean("doors_left", false).sync(true).group("mirror_lr"));
				attrs.add(new AttrBoolean("doors_right", false).sync(true).group("mirror_lr"));
				attrs.add(new AttrInteger("section_on", 0));
				break;
			}
			case WATER:{
				attrs.add(new AttrBoolean("lights_fog", false).addAccess("driver").sync(true)
						.addIcons("true", "fvtm:textures/gui/icons/lights_fog_on.png", "false", "fvtm:textures/gui/icons/lights_fog_off.png"));
				attrs.add(new AttrBoolean("lights_long", false).addAccess("driver").sync(true)
						.addIcons("true", "fvtm:textures/gui/icons/lights_high_on.png", "false", "fvtm:textures/gui/icons/lights_high_off.png"));
				attrs.add(new AttrBoolean("lights_other", false).addAccess("driver").sync(true));
				attrs.add(new AttrFloat("steering_angle", 0f).limit(-90f, 90f));
				attrs.add(new AttrFloat("wheel_angle", 0f).limit(-360f, 360f));
				attrs.add(new AttrFloat("max_steering_angle", 35f).limit(-90f, 90f).editable(false));
				attrs.add(new AttrFloat("max_towing", 3500f).limit(1, Integer.MAX_VALUE).editable(false));
				attrs.add(new AttrString("license_plate", "FVTM").addAccess("external").editable(false).perm("fvtm.attribute.license_plate"));
				break;
			}
			default: break;
		}
		return attrs;
	}

	public int minWheels(){
		return 4;
	}

}
