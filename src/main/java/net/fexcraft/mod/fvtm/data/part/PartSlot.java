package net.fexcraft.mod.fvtm.data.part;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.fexcraft.lib.mc.utils.Pos;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.util.Rot;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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
	
	public static class PartSlots extends ArrayList<PartSlot> {

		@SideOnly(Side.CLIENT)
		public HashMap<String, Integer> count;
		public final boolean copy_rot;

		public PartSlots(Part part, JsonObject obj){
			JsonArray jslots = obj.get("slots").getAsJsonArray();
			for(int i = 0; i < jslots.size(); i++){
				JsonArray array = jslots.get(i).getAsJsonArray();
				add(new PartSlot(part.getCategory(), array, i));
			}
			copy_rot = obj.has("copy_rot") ? obj.get("copy_rot").getAsBoolean() : false;
			if(Static.side().isClient()){
				count = new HashMap<>();
				for(PartSlot slot : this){
					if(count.containsKey(slot.type)) count.put(slot.type, count.get(slot.type) + 1);
					else count.put(slot.type, 1);
				}
			}
		}
		
	}

}
