package net.fexcraft.mod.fvtm.data.vehicle;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.util.ContentConfigUtil;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static net.fexcraft.mod.fvtm.FvtmLogger.NONE;
import static net.fexcraft.mod.fvtm.FvtmRegistry.PARTS;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class CatalogPreset {

	public final Map<String, String> parts = new LinkedHashMap<>();
	public final Map<String, RGB> channels = new LinkedHashMap<>();
	public final Map<String, Integer> recipe = new LinkedHashMap<>();
	public final List<String> desc;
	public final Vehicle vehicle;
	public final String name;
	public final String id;
	public final float scale;

	public CatalogPreset(Vehicle root, String cid, JsonMap map){
		vehicle = root;
		id = cid;
		name = map.getString("name", root.getName() + "(" + id + ")");
		desc = ContentConfigUtil.getStringList(map, "description");
		if(map.has("parts")){
			map.getMap("parts").entries().forEach(entry -> {
				parts.put(entry.getKey(), entry.getValue().string_value());
			});
		}
		if(map.has("recipe") && map.get("recipe").isMap()){
			for(Map.Entry<String, JsonValue<?>> entry : map.getMap("recipe").entries()){
				int val = entry.getValue().integer_value();
				recipe.put(entry.getKey(), val < 1 ? 1 : val > 64 ? 64 : val);
			}
		}
		if(map.has("colors")){
			map.getMap("colors").entries().forEach(entry -> {
				channels.put(entry.getKey(), new RGB(entry.getValue().string_value()));
			});
		}
		scale = map.getFloat("scale", 1);
	}

	public String getDesc(int i){
		if(desc.isEmpty()) return i == 0 ? "ui.fvtm.vehicle_catalog.no_desc" : "";
		if(i >= desc.size()) return "";
		return desc.get(i);
	}

	public VehicleData getVehicleData(){
		VehicleData data = new VehicleData(vehicle);
		for(Map.Entry<String, String> entry : parts.entrySet()){
			try{
				Part part = PARTS.get(entry.getValue());
				if(part == null) continue;
				data.installPart(NONE, new PartData(part), entry.getKey(), false);
			}
			catch(Exception e){
				FvtmLogger.log(e, "catalog entry part install / " + entry);
			}
		}
		for(Map.Entry<String, RGB> entry : channels.entrySet()){
			if(data.channels.containsKey(entry.getKey())){
				data.channels.get(entry.getKey()).packed = entry.getValue().packed;
			}
		}
		return data;
	}

}
