package net.fexcraft.mod.fvtm.api.compatibility;

import com.google.gson.JsonObject;

import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.math.Pos;

public class FMSeat {

	private Pos pos;
	private int id;
	
	public FMSeat(JsonObject obj){
		pos = Pos.fromJSON(obj);
		id = JsonUtil.getIfExists(obj, "id", -1).intValue();
		if(obj.has("driver") && obj.get("driver").getAsBoolean()){
			id = 0;
		}
	}
	
	public Pos getPos(){
		return pos;
	}
	
	public int getId(){
		return id;
	}
	
	public boolean isDriver(){
		return id == 0;
	}
	
}