package net.fexcraft.mod.fvtm.data.block;

import java.util.HashMap;
import java.util.Map.Entry;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.mod.fvtm.util.Vec316f;

public class RelayData {
	
	public boolean input, output;
	public HashMap<String, Vec316f> conns = new HashMap<>();

	public RelayData(JsonObject obj){
		input = JsonUtil.getIfExists(obj, "input", true);
		output = JsonUtil.getIfExists(obj, "output", true);
		if(!conns.containsKey("points")){
			conns.put("default", new Vec316f(0, 0, 0, (byte)8, (byte)8, (byte)8));
			return;
		}
		JsonObject points = obj.get("points").getAsJsonObject();
		for(Entry<String, JsonElement> entry : points.entrySet()){
			JsonArray array = entry.getValue().getAsJsonArray();
			byte x = array.get(0).getAsByte();
			byte y = array.get(1).getAsByte();
			byte z = array.get(2).getAsByte();
			conns.put(entry.getKey(), new Vec316f(x / 16, y / 16, z / 16, (byte)(x % 16), (byte)(y % 16), (byte)(z % 16)));
		}
	}

}
