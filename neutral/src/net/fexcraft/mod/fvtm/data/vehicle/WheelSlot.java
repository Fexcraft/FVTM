package net.fexcraft.mod.fvtm.data.vehicle;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.util.ContentConfigUtil;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class WheelSlot {

	public V3D position;
	public boolean mirror;
	public float hubsize;
	public float max_radius = 0.75f;
	public float min_wheel_radius = 0.25f;
	public float min_tire_radius = 0.5f;
	public float max_width = 0.75f;
	public float min_wheel_width = 0.125f;
	public float min_tire_width = 0.125f;
	public boolean steering;
	public boolean required;
	public boolean relative;
	public boolean braking;
	public String powered;

	public WheelSlot(){}

	public WheelSlot(JsonMap map){
		position = ContentConfigUtil.getVector(map.getArray("pos"));
		mirror = map.getBoolean("mirror", false);
		hubsize = map.getFloat("hubsize", 0f);
		if(map.has("radius")){
			float rad = map.getFloat("radius", 0.5f);
			max_radius = rad + 0.0125f;
			min_wheel_radius = (rad / 2);
			min_tire_radius = rad - 0.0125f;
		}
		if(map.has("width")){
			float wid = map.getFloat("width", 0.5f);
			max_width = wid + 0.0125f;
			min_wheel_width = wid - 0.0125f;
			min_tire_width = wid - 0.0125f;
		}
		max_radius = map.getFloat("max_radius", max_radius);
		min_wheel_radius = map.getFloat("min_wheel_radius", min_wheel_width);
		min_tire_radius = map.getFloat("min_tire_radius", min_tire_radius);
		max_width = map.getFloat("max_width", max_width);
		min_wheel_width = map.getFloat("min_wheel_width", min_wheel_width);
		min_tire_width = map.getFloat("min_tire_width", min_tire_width);
		steering = map.getBoolean("steering", false);
		required = map.getBoolean("required", true);
		relative = map.getBoolean("relative", false);
		if(map.has("powered")){
			if(map.get("powered").string_value().equals("true")){
				powered = "";
			}
			else powered = map.getString("powered", "");
		}
		braking = map.getBoolean("braking", true);
	}

	public boolean powered(VehicleData data){
		return powered == null ? false : powered.length() == 0 || data.getAttributeBoolean(powered, false);
	}

	public float min_radius(boolean tire){
		return tire ? min_tire_radius : min_wheel_radius;
	}

	public float min_width(boolean tire){
		return tire ? min_tire_width : min_wheel_width;
	}

	public WheelSlot copy(V3D pos){
		V3D npos = position.copy();
		if(pos != null && relative) npos = npos.add(pos);
		WheelSlot slot = new WheelSlot();
		slot.position = npos;
		slot.mirror = mirror;
		slot.hubsize = hubsize;
		slot.max_radius = max_radius;
		slot.min_wheel_radius = min_wheel_radius;
		slot.min_tire_radius = min_tire_radius;
		slot.max_width = max_width;
		slot.min_wheel_width = min_wheel_width;
		slot.min_tire_width = min_tire_width;
		slot.steering = steering;
		slot.required = required;
		slot.relative = relative;
		slot.braking = braking;
		slot.powered = powered;
		return slot;
	}

}
