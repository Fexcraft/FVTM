package net.fexcraft.mod.fvtm.data;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.mc.utils.Pos;
import net.minecraft.nbt.NBTTagCompound;

public class WheelSlot {
	
	private Pos position;
	private float yrot, connector, maxradius = 16f, minradius = 16f;
	private boolean drive = false, steering = false, required;
	//TODO implement deco wheels and inactive wheels
	
	public WheelSlot(JsonObject obj){
		position = Pos.fromJson(obj, false);
		yrot = JsonUtil.getIfExists(obj, "y_rot", 0).floatValue();
		drive = JsonUtil.getIfExists(obj, "drive", false);
		connector = JsonUtil.getIfExists(obj, "connector", 0f).floatValue();
		if(obj.has("radius")){
			float rad = obj.get("radius").getAsFloat();
			maxradius = rad + 1; minradius = rad - 1;
		}
		maxradius = JsonUtil.getIfExists(obj, "max_radius", maxradius).floatValue();
		minradius = JsonUtil.getIfExists(obj, "min_radius", minradius).floatValue();
		steering = JsonUtil.getIfExists(obj, "steering", false);
		required = JsonUtil.getIfExists(obj, "required", false);
	}
	
	public WheelSlot read(NBTTagCompound compound){
		position = Pos.fromNBT(null, compound);
		yrot = compound.getFloat("y_rot");
		drive = compound.hasKey("drive") && compound.getBoolean("drive");
		connector = compound.hasKey("connector") ? compound.getFloat("connector") : 0f;
		maxradius = compound.hasKey("max_radius") ? compound.getFloat("max_radius") : 16f;
		minradius = compound.hasKey("min_radius") ? compound.getFloat("min_radius") : 16f;
		steering = compound.hasKey("steering") && compound.getBoolean("steering");
		required = compound.hasKey("required") && compound.getBoolean("required");
		return this;
	}
	
	public WheelSlot(Pos pos, float rot, boolean drivewheel, float conn, float max, float min, boolean bool, boolean req){
		this.position = pos; this.yrot = rot; this.drive = drivewheel; this.connector = conn;
		this.maxradius = max; this.minradius = min; this.steering = bool; this.required = req;
	}
	
	/** For copying the default WheelSlot from e.g. Vehicle into VehicleData*/
	public WheelSlot copy(){
		return new WheelSlot(position.copy(), yrot, drive, connector, maxradius, minradius, steering, required);
	}
	
	public NBTTagCompound write(NBTTagCompound compound){
		position.toNBT(null, compound);
		compound.setFloat("y_rot", yrot);
		if(drive) compound.setBoolean("drive", drive);
		if(connector > 0f) compound.setFloat("connector", connector); 
		compound.setFloat("max_radius", maxradius);
		compound.setFloat("min_radius", maxradius);
		if(steering) compound.setBoolean("steering", true);
		return compound;
	}
	
	public Pos pos(){ return position; }
	public float yrot(){ return yrot; }
	public boolean drivewheel(){ return drive; }
	public float maxradius(){ return maxradius; }
	public float minradius(){ return minradius; }
	public float connector(){ return connector; }
	public boolean steering(){ return steering; }
	public boolean required(){ return required; }

}
