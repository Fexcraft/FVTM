package net.fexcraft.mod.fvtm.data.block;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.mod.fvtm.block.generated.BlockTileEntity;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.fvtm.util.VecUtil;
import net.minecraft.util.math.BlockPos;

public class RelayData {
	
	public boolean input, output;
	public LinkedHashMap<String, V3D> conns = new LinkedHashMap<>();
	public HashMap<String, ArrayList<String>> types = new HashMap<>();
	public HashMap<String, Integer> limits = new HashMap<>();

	public RelayData(JsonObject obj){
		input = JsonUtil.getIfExists(obj, "input", true);
		output = JsonUtil.getIfExists(obj, "output", true);
		if(!obj.has("points")){
			conns.put("default", new V3D(0, 0.5f, 0));
			return;
		}
		JsonObject points = obj.get("points").getAsJsonObject();
		for(Entry<String, JsonElement> entry : points.entrySet()){
			JsonArray array = entry.getValue().getAsJsonArray();
			byte x = array.get(0).getAsByte();
			byte y = array.get(1).getAsByte();
			byte z = array.get(2).getAsByte();
			conns.put(entry.getKey(), new V3D(x * Static.sixteenth, y * Static.sixteenth, z * Static.sixteenth));
			limits.put(entry.getKey(), array.size() > 3 ? array.get(3).getAsInt() : 0);
			types.put(entry.getKey(), array.size() > 4 ? DataUtil.getStringArray(array.get(4)) : new ArrayList<>());
		}
	}

	public HashMap<String, V3D> getVectors(BlockTileEntity tile){
		LinkedHashMap<String, V3D> list = new LinkedHashMap<>();
		for(Entry<String, V3D> entry : conns.entrySet()){
			list.put(entry.getKey(), rotate(entry.getValue(), tile.getPos(), tile.meta, tile.getBlockData().getType().getBlockType()));
		}
		return list;
	}

	public static V3D rotate(V3D vector, BlockPos pos, int meta, BlockType type){
		double rot = type.getRotationForMeta(meta);
		return VecUtil.rotByDeg(rot, vector).add(pos.getX() + .5f, pos.getY(), pos.getZ() + .5f);
	}

	public V3D getVec(String string, BlockPos pos, int meta, BlockType type){
		return VecUtil.rotByDeg(type.getRotationForMeta(meta), conns.get(string)).add(pos.getX() + .5f, pos.getY(), pos.getZ() + .5f);
	}

}
