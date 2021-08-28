package net.fexcraft.mod.fvtm.data.block;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.mod.fvtm.block.generated.BlockTileEntity;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.fexcraft.mod.fvtm.util.VecUtil;
import net.minecraft.util.math.BlockPos;

public class RelayData {
	
	public boolean input, output;
	public HashMap<String, Vec3f> conns = new HashMap<>();

	public RelayData(JsonObject obj){
		input = JsonUtil.getIfExists(obj, "input", true);
		output = JsonUtil.getIfExists(obj, "output", true);
		if(!obj.has("points")){
			conns.put("default", new Vec3f(0, 0.5f, 0));
			return;
		}
		JsonObject points = obj.get("points").getAsJsonObject();
		for(Entry<String, JsonElement> entry : points.entrySet()){
			JsonArray array = entry.getValue().getAsJsonArray();
			byte x = array.get(0).getAsByte();
			byte y = array.get(1).getAsByte();
			byte z = array.get(2).getAsByte();
			conns.put(entry.getKey(), new Vec3f(x * Static.sixteenth, y * Static.sixteenth, z * Static.sixteenth));
		}
	}

	public ArrayList<Vec316f> getVectors(BlockTileEntity tile){
		ArrayList<Vec316f> list = new ArrayList<Vec316f>();
		for(Vec3f conn : conns.values()){
			list.add(rotate(conn, tile.getPos(), tile.meta, tile.getBlockData().getType().getBlockType()));
		}
		return list;
	}

	public static Vec316f rotate(Vec3f vector, BlockPos pos, int meta, BlockType type){
		double rot = type.getRotationForMeta(meta);
		return new Vec316f(VecUtil.rotByDeg(rot, vector).add(pos.getX() + .5f, pos.getY(), pos.getZ() + .5f));
	}

}
