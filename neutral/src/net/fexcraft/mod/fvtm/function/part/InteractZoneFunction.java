package net.fexcraft.mod.fvtm.function.part;

import net.fexcraft.app.json.FJson;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.mod.fvtm.data.InteractZone;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.part.PartFunction;
import net.fexcraft.mod.fvtm.data.part.PartFunction.StaticFunction;

import java.util.ArrayList;
import java.util.Map.Entry;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class InteractZoneFunction extends StaticFunction {

	private ArrayList<InteractZone> zones = new ArrayList<>();

	@Override
	public PartFunction init(Part part, FJson json){
		JsonMap map = json.asMap();
		for(Entry<String, JsonValue<?>> entry : map.entries()){
			zones.add(new InteractZone(entry.getKey(), entry.getValue().asArray()));
		}
		return this;
	}

	@Override
	public String getId(){
		return "fvtm:interact_zone";
	}

	public ArrayList<InteractZone> getZones(){
		return zones;
	}

}
