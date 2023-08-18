package net.fexcraft.mod.fvtm.data.part;

import java.util.ArrayList;
import java.util.HashMap;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.util.ContentConfigUtil;
import net.fexcraft.mod.fvtm.util.Rot;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class PartSlot {
	
	public final String type;
	public final V3D pos;
	public final String category;
	public final float radius;
	public final Rot rotation;
	
	public PartSlot(String defcat, JsonArray array, int idx){
		type = array.get(3).string_value();
		pos = ContentConfigUtil.getVector(array);
		category = array.size() > 4 ? array.get(4).string_value() : defcat + "_" + idx;
		radius = array.size() > 5 ? array.get(5).integer_value() * Static.sixteenth : 0.25f;
		rotation = array.size() > 6 && array.get(6).isArray() ? new Rot(array.get(6).asArray()) : Rot.NULL;
	}
	
	public static class PartSlots extends ArrayList<PartSlot> {

		public static final String VEHPARTSLOTS = "vehicle_partslots";
		@SideOnly(Side.CLIENT)
		public HashMap<String, Integer> count;
		public boolean copy_rot;

		public PartSlots(Part part, JsonMap obj){
			this(part.getCategory(), obj.get("slots").asArray());
			copy_rot = obj.has("copy_rot") ? obj.get("copy_rot").bool() : false;
		}
		
		public PartSlots(String defcat, JsonArray jslots){
			for(int i = 0; i < jslots.size(); i++){
				JsonArray array = jslots.get(i).asArray();
				add(new PartSlot(defcat, array, i));
			}
			if(Static.side().isClient()){
				count = new HashMap<>();
				for(PartSlot slot : this){
					if(count.containsKey(slot.type)) count.put(slot.type, count.get(slot.type) + 1);
					else count.put(slot.type, 1);
				}
			}
		}
		
	}

	public String category(String provider){
		if(category.contains("*")) return category.replace("*", provider);
		return category;
	}

}
