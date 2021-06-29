package net.fexcraft.mod.fvtm.data.part;

import com.google.gson.JsonArray;

import net.fexcraft.lib.mc.utils.Pos;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.util.Rot;

public class PartSlot {
	
	public final String type;
	public final Pos pos;
	public final String category;
	public final float radius;
	public final Rot rotation;
	
	public PartSlot(String defcat, JsonArray array, int idx){
		type = array.get(3).getAsString();
		pos = Pos.fromJson(array, true);
		category = array.size() > 4 ? array.get(4).getAsString() : defcat + "_" + idx;
		radius = array.size() > 5 ? array.get(5).getAsInt() * Static.sixteenth : 0.25f;
		rotation = array.size() > 6 && array.get(6).isJsonArray() ? new Rot(array.get(6).getAsJsonArray()) : Rot.NULL;
	}

}
