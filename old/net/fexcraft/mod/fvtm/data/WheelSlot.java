package net.fexcraft.mod.fvtm.data;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.mc.utils.Pos;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.minecraft.nbt.NBTTagCompound;

public class WheelSlot {
	
	private Pos position;
	private float yrot, connector;
	private float max_radius = 16, min_wheel_radius = 16, min_tire_radius = 16;
	private float max_width = 8, min_wheel_width = 1, min_tire_width = 1;
	private boolean steering, required, relative, braking;
	private String powered = null;
	
	public WheelSlot(JsonObject obj){
		position = Pos.fromJson(obj, false);
		yrot = JsonUtil.getIfExists(obj, "y_rot", 0).floatValue();
		connector = JsonUtil.getIfExists(obj, "connector", 0f).floatValue();
		if(obj.has("radius")){
			float rad = obj.get("radius").getAsFloat();
			max_radius = rad + 1;
			min_wheel_radius = (int)(rad / 2);
			min_tire_radius = rad - 1;
		}
		if(obj.has("width")){
			float wid = obj.get("width").getAsFloat();
			max_width = wid + 1;
			min_wheel_width = wid - 1;
			min_tire_width = wid - 1;
		}
		max_radius = JsonUtil.getIfExists(obj, "max_radius", max_radius).floatValue();
		min_wheel_radius = JsonUtil.getIfExists(obj, "min_radius", min_wheel_radius).floatValue();
		min_tire_radius = JsonUtil.getIfExists(obj, "min_tire_radius", min_tire_radius).floatValue();
		max_width = JsonUtil.getIfExists(obj, "max_width", max_width).floatValue();
		min_wheel_width = JsonUtil.getIfExists(obj, "min_width", min_wheel_width).floatValue();
		min_tire_width = JsonUtil.getIfExists(obj, "min_tire_width", min_tire_width).floatValue();
		steering = JsonUtil.getIfExists(obj, "steering", false);
		required = JsonUtil.getIfExists(obj, "required", false);
		relative = JsonUtil.getIfExists(obj, "relative", false);
		boolean drive = JsonUtil.getIfExists(obj, "drive", false);
		if(drive || obj.has("powered")){
			if(drive || obj.get("powered").getAsString().equals("true")) powered = "";
			else powered = obj.get("powered").getAsString();
		}
		braking = JsonUtil.getIfExists(obj, "braking", true);
	}
	
	public WheelSlot read(NBTTagCompound compound){
		position = Pos.fromNBT(null, compound);
		yrot = compound.getFloat("y_rot");
		connector = compound.hasKey("connector") ? compound.getFloat("connector") : 0f;
		max_radius = compound.hasKey("max_radius") ? compound.getFloat("max_radius") : 16f;
		min_wheel_radius = compound.hasKey("min_radius") ? compound.getFloat("min_radius") : 16f;
		min_tire_radius = compound.hasKey("min_tire_radius") ? compound.getFloat("min_tire_radius") : 16f;
		max_radius = compound.hasKey("max_width") ? compound.getFloat("max_width") : 8f;
		min_wheel_radius = compound.hasKey("min_width") ? compound.getFloat("min_width") : 1f;
		min_tire_radius = compound.hasKey("min_tire_width") ? compound.getFloat("min_tire_width") : 1f;
		steering = compound.hasKey("steering") && compound.getBoolean("steering");
		required = compound.hasKey("required") && compound.getBoolean("required");
		relative = compound.hasKey("relative") && compound.getBoolean("relative");
		powered = compound.hasKey("powered") ? compound.getString("powered") : null;
		braking = compound.hasKey("braking") && compound.getBoolean("braking");
		return this;
	}
	
	public WheelSlot(Pos pos, float rot, String powered, float conn, float max, float min, float wmax, float wmin, boolean bool, boolean req){
		this.position = pos;
		this.yrot = rot;
		this.powered = powered;
		this.connector = conn;
		this.min_wheel_width = wmin;
		this.min_tire_width = wmin;
		this.max_width = wmax;
		this.max_radius = max;
		this.min_wheel_radius = (int)(max / 2);
		this.min_tire_radius = min;
		this.steering = bool;
		this.required = req;
	}
	
	/** For copying the default WheelSlot from e.g. Vehicle into VehicleData
	 * @param pos position the part this wheel slot is mounted on is located, may be null, only used in case of "relative" wheel slots */
	public WheelSlot copy(Pos pos){
		Pos newpos = this.position.copy();
		if(pos != null && relative) newpos = newpos.add(pos);
		return new WheelSlot(newpos, yrot, powered, connector, max_radius, min_wheel_radius, max_width, min_wheel_width, steering, required);
	}
	
	public NBTTagCompound write(NBTTagCompound compound){
		position.toNBT(null, compound);
		compound.setFloat("y_rot", yrot);
		if(connector > 0f) compound.setFloat("connector", connector);
		compound.setFloat("max_radius", max_radius);
		compound.setFloat("min_radius", min_wheel_radius);
		compound.setFloat("min_tire_radius", min_tire_radius);
		compound.setFloat("max_width", max_width);
		compound.setFloat("min_tire_width", min_tire_width);
		if(steering) compound.setBoolean("steering", true);
		if(required) compound.setBoolean("required", true);
		if(relative) compound.setBoolean("relative", true);
		if(powered != null) compound.setString("powered", powered);
		if(braking) compound.setBoolean("braking", braking);
		return compound;
	}
	
	public Pos pos(){ return position; }
	public float yrot(){ return yrot; }
	public float max_radius(){ return max_radius; }
	public float min_wheel_radius(){ return min_wheel_radius; }
	public float min_tire_radius(){ return min_tire_radius; }
	public float max_width(){ return max_width; }
	public float min_wheel_width(){ return min_wheel_width; }
	public float min_tire_width(){ return min_tire_width; }
	public float connector(){ return connector; }
	public boolean steering(){ return steering; }
	public boolean required(){ return required; }
	public boolean braking(){ return braking; }
	
	public boolean powered(VehicleData data){
		return powered == null ? false : powered.length() == 0 || (data != null && data.getAttributeBoolean(powered, false));
	}

	public float min_radius(boolean has_tire){
		return has_tire ? min_tire_radius : min_wheel_radius;
	}

	public float min_width(boolean has_tire){
		return has_tire ? min_tire_width : min_wheel_width;
	}

}
