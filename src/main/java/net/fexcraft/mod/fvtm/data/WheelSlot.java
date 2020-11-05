package net.fexcraft.mod.fvtm.data;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.mc.utils.Pos;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.minecraft.nbt.NBTTagCompound;

public class WheelSlot {
	
	private Pos position;
	private float yrot, connector, maxradius = 16f, minradius = 16f, minwidth = 1, maxwidth = 8;
	private boolean steering, required, relative, braking;
	private String powered = null;
	
	public WheelSlot(JsonObject obj){
		position = Pos.fromJson(obj, false);
		yrot = JsonUtil.getIfExists(obj, "y_rot", 0).floatValue();
		connector = JsonUtil.getIfExists(obj, "connector", 0f).floatValue();
		if(obj.has("radius")){
			float rad = obj.get("radius").getAsFloat();
			maxradius = rad + 1; minradius = rad - 1;
		}
		if(obj.has("width")){
			float wid = obj.get("width").getAsFloat();
			maxwidth = wid + 1; minwidth = wid - 1;
		}
		maxradius = JsonUtil.getIfExists(obj, "max_radius", maxradius).floatValue();
		minradius = JsonUtil.getIfExists(obj, "min_radius", minradius).floatValue();
		maxwidth = JsonUtil.getIfExists(obj, "max_width", maxwidth).floatValue();
		minwidth = JsonUtil.getIfExists(obj, "min_width", minwidth).floatValue();
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
		maxradius = compound.hasKey("max_radius") ? compound.getFloat("max_radius") : 16f;
		minradius = compound.hasKey("min_radius") ? compound.getFloat("min_radius") : 16f;
		maxradius = compound.hasKey("max_width") ? compound.getFloat("max_width") : 8f;
		minradius = compound.hasKey("min_width") ? compound.getFloat("min_width") : 1f;
		steering = compound.hasKey("steering") && compound.getBoolean("steering");
		required = compound.hasKey("required") && compound.getBoolean("required");
		relative = compound.hasKey("relative") && compound.getBoolean("relative");
		powered = compound.hasKey("powered") ? compound.getString("powered") : null;
		braking = compound.hasKey("braking") && compound.getBoolean("braking");
		return this;
	}
	
	public WheelSlot(Pos pos, float rot, String powered, float conn, float max, float min, float wmax, float wmin, boolean bool, boolean req){
		this.position = pos; this.yrot = rot; this.powered = powered; this.connector = conn; this.minwidth = wmin; this.maxwidth = wmax;
		this.maxradius = max; this.minradius = min; this.steering = bool; this.required = req;
	}
	
	/** For copying the default WheelSlot from e.g. Vehicle into VehicleData
	 * @param pos position the part this wheel slot is mounted on is located, may be null, only used in case of "relative" wheel slots */
	public WheelSlot copy(Pos pos){
		Pos newpos = this.position.copy();
		if(pos != null && relative) newpos = newpos.add(pos);
		return new WheelSlot(newpos, yrot, powered, connector, maxradius, minradius, maxwidth, minwidth, steering, required);
	}
	
	public NBTTagCompound write(NBTTagCompound compound){
		position.toNBT(null, compound);
		compound.setFloat("y_rot", yrot);
		if(connector > 0f) compound.setFloat("connector", connector);
		compound.setFloat("max_radius", maxradius);
		compound.setFloat("min_radius", maxradius);
		compound.setFloat("max_width", maxwidth);
		compound.setFloat("min_width", maxwidth);
		if(steering) compound.setBoolean("steering", true);
		if(required) compound.setBoolean("required", true);
		if(relative) compound.setBoolean("relative", true);
		if(powered != null) compound.setString("powered", powered);
		if(braking) compound.setBoolean("braking", braking);
		return compound;
	}
	
	public Pos pos(){ return position; }
	public float yrot(){ return yrot; }
	public float maxradius(){ return maxradius; }
	public float minradius(){ return minradius; }
	public float maxwidth(){ return maxwidth; }
	public float minwidth(){ return minwidth; }
	public float connector(){ return connector; }
	public boolean steering(){ return steering; }
	public boolean required(){ return required; }
	
	public boolean powered(VehicleData data){
		return powered == null ? false : powered.length() == 0 || data != null && data.getAttributeBoolean(powered, false);
	}

}
