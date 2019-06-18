package net.fexcraft.mod.fvtm.util.function;

import java.util.HashMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.data.Function.StaticFuntion;
import net.fexcraft.mod.fvtm.data.WheelSlot;

public class WheelPositionsFunction extends StaticFuntion {
	
	private HashMap<String, WheelSlot> wheels = new HashMap<>();

	public WheelPositionsFunction(JsonObject obj){
		super(obj);
		JsonArray array = obj.get("wheel_positions").getAsJsonArray();
		for(JsonElement elm : array){
			JsonObject json = elm.getAsJsonObject();
			String id = json.get("id").getAsString();
			this.wheels.put(id, new WheelSlot(json));
		}
	}

	@Override
	public String getId(){
		return "fvtm:wheel_positions";
	}
	
	public HashMap<String, WheelSlot> getPositions(){
		return wheels;
	}
	
}
