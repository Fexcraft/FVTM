package net.fexcraft.mod.fvtm.function.part;

import java.util.HashMap;
import java.util.Map.Entry;

import net.fexcraft.app.json.FJson;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.part.PartFunction;
import net.fexcraft.mod.fvtm.data.part.PartFunction.StaticFunction;
import net.fexcraft.mod.fvtm.data.vehicle.WheelSlot;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class WheelPositionsFunction extends StaticFunction {
	
	private HashMap<String, WheelSlot> wheels = new HashMap<>();

	@Override
	public PartFunction init(Part part, FJson json){
		for(Entry<String, JsonValue<?>> entry : json.asMap().entries()){
			wheels.put(entry.getKey(), new WheelSlot(entry.getValue().asMap()));
		}
		return this;
	}

	@Override
	public String getId(){
		return "fvtm:wheel_positions";
	}
	
	public HashMap<String, WheelSlot> getPositions(){
		return wheels;
	}
	
}
