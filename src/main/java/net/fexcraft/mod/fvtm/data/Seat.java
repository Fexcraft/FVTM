package net.fexcraft.mod.fvtm.data;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.common.math.Vec3f;

public class Seat {
	
	public float x, y, z;
	public boolean driver;
	//public String swivel_point;
	
	public Seat(JsonObject obj){
		this.x = JsonUtil.getIfExists(obj, "x", 0).floatValue();
		this.y = JsonUtil.getIfExists(obj, "y", 0).floatValue();
		this.z = JsonUtil.getIfExists(obj, "z", 0).floatValue();
		driver = JsonUtil.getIfExists(obj, "driver", false);
	}
	
	public Seat(float x, float y, float z, boolean driver){
		this.x = x; this.y = y; this.z = z; this.driver = driver;
	}
	
	public boolean isDriver(){
		return driver;
	}
	
	public Vec3f copyPos(){
		return new Vec3f(x, y, z);
	}

}
