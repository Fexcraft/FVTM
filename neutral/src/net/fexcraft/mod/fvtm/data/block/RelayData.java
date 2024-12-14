package net.fexcraft.mod.fvtm.data.block;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.util.VecUtil;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RelayData {
	
	public boolean input, output;
	public LinkedHashMap<String, V3D> conns = new LinkedHashMap<>();
	public HashMap<String, ArrayList<String>> types = new HashMap<>();
	public HashMap<String, Integer> limits = new HashMap<>();

	public RelayData(JsonMap map){
		input = map.getBoolean("input", true);
		output = map.getBoolean("output", true);
		if(!map.has("points")){
			conns.put("default", new V3D(0, 0.5f, 0));
			return;
		}
		JsonMap points = map.getMap("points");
		for(Entry<String, JsonValue<?>> entry : points.entries()){
			JsonArray array = entry.getValue().asArray();
			float x = array.get(0).float_value();
			float y = array.get(1).float_value();
			float z = array.get(2).float_value();
			conns.put(entry.getKey(), new V3D(x, y, z));
			limits.put(entry.getKey(), array.size() > 3 ? array.get(3).integer_value() : 0);
			types.put(entry.getKey(), array.size() > 4 ? array.get(4).asArray().toStringList() : new ArrayList<>());
		}
	}

	public HashMap<String, V3D> getVectors(FvtmBlockEntity tile){
		LinkedHashMap<String, V3D> list = new LinkedHashMap<>();
		for(Entry<String, V3D> entry : conns.entrySet()){
			list.put(entry.getKey(), rotate(entry.getValue(), tile.getV3I(), tile.getMeta(), tile.getBlockData().getType().getBlockType()));
		}
		return list;
	}

	public static V3D rotate(V3D vector, V3I pos, int meta, BlockType type){
		double rot = type.getRotationFor(meta);
		return VecUtil.rotByDeg(rot, vector).add(pos.x + .5, pos.y, pos.z + .5);
	}

	public V3D getVec(String string, V3I pos, int meta, BlockType type){
		return VecUtil.rotByDeg(type.getRotationFor(meta), conns.get(string)).add(pos.x + .5f, pos.y, pos.z + .5f);
	}

}
