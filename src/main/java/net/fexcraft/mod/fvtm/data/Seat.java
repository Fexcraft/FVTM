package net.fexcraft.mod.fvtm.data;

import java.util.UUID;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.common.math.Vec3f;
import net.minecraft.util.math.Vec3d;

public class Seat {
	
	public float x, y, z;
	public boolean driver, sitting;
	public String name;
	public float minyaw, maxyaw;
	public float minpitch, maxpitch;
	//public String swivel_point;
	
	public Seat(JsonObject obj){
		this.x = JsonUtil.getIfExists(obj, "x", 0).floatValue();
		this.y = JsonUtil.getIfExists(obj, "y", 0).floatValue();
		this.z = JsonUtil.getIfExists(obj, "z", 0).floatValue();
		driver = JsonUtil.getIfExists(obj, "driver", false);
		name = obj.has("name") ? obj.get("name").getAsString() : UUID.randomUUID().toString().substring(0, 8);
		minyaw = JsonUtil.getIfExists(obj, "min_yaw", -90f).floatValue();
		maxyaw = JsonUtil.getIfExists(obj, "max_yaw", 90f).floatValue();
		minpitch = JsonUtil.getIfExists(obj, "min_pitch", -80f).floatValue();
		maxpitch = JsonUtil.getIfExists(obj, "max_pitch", 80f).floatValue();
		sitting = JsonUtil.getIfExists(obj, "sitting", true);
	}
	
	public Seat(String name, float x, float y, float z, boolean driver){
		this.x = x; this.y = y; this.z = z; this.driver = driver; this.name = name;
		minyaw = -90; maxyaw = 90; minpitch = -80; maxpitch = 80; sitting = true;
	}
	
	public boolean isDriver(){
		return driver;
	}
	
	public Vec3f copyPos(){
		return new Vec3f(x, y, z);
	}
	
	public Vec3d toVec3d(){
		return new Vec3d(x, y, z);
	}
	
	public String getName(){
		return name;
	}

}
