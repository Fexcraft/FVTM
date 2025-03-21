package net.fexcraft.mod.fvtm.data.part;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.mod.uni.EnvInfo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class PartSlots extends LinkedHashMap<String, PartSlot> {

	public HashMap<String, Integer> count;
	public boolean copy_rot;

	public PartSlots(JsonMap map){
		copy_rot = map.has("copy_rot") ? map.rem("copy_rot").bool() : false;
		for(Entry<String, JsonValue<?>> entry : map.entries()){
			put(entry.getKey(), new PartSlot(entry.getKey(), entry.getValue()));
		}
		if(EnvInfo.CLIENT || EnvInfo.is121()){
			count = new HashMap<>();
			for(PartSlot slot : this.values()){
				if(count.containsKey(slot.type)) count.put(slot.type, count.get(slot.type) + 1);
				else count.put(slot.type, 1);
			}
		}
	}

}
