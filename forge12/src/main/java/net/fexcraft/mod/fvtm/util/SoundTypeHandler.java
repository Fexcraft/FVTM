package net.fexcraft.mod.fvtm.util;

import net.fexcraft.app.json.JsonValue;
import net.minecraft.block.SoundType;

import java.util.HashMap;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class SoundTypeHandler {

	public static HashMap<String, SoundType> TYPES = new HashMap<>();

	public static SoundType parse(String id){
		if(TYPES.isEmpty()){
			TYPES.put("wood", SoundType.WOOD);
			TYPES.put("ground", SoundType.GROUND);
			TYPES.put("plant", SoundType.PLANT);
			TYPES.put("stone", SoundType.STONE);
			TYPES.put("metal", SoundType.METAL);
			TYPES.put("glass", SoundType.GLASS);
			TYPES.put("cloth", SoundType.CLOTH);
			TYPES.put("sand", SoundType.SAND);
			TYPES.put("snow", SoundType.SNOW);
			TYPES.put("ladder", SoundType.LADDER);
			TYPES.put("anvil", SoundType.ANVIL);
			TYPES.put("slime", SoundType.SLIME);
		}
		return TYPES.containsKey(id) ? TYPES.get(id) : TYPES.get("ground");
	}

}
