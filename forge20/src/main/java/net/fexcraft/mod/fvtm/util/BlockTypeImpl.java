package net.fexcraft.mod.fvtm.util;

import net.fexcraft.mod.fvtm.block.generated.*;
import net.fexcraft.mod.fvtm.data.block.BlockType;
import net.minecraft.world.level.block.state.BlockState;

import static net.fexcraft.mod.fvtm.block.generated.FvtmProperties.*;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class BlockTypeImpl {

	public static Class get(BlockType type, boolean func, boolean plain){
		plain = plain && !func;
		switch(type){
			case GENERIC_4ROT: return plain ? G_4ROT.class : G_4ROT_BE.class;
			case GENERIC_16ROT: return plain ? G_16ROT.class : G_16ROT_BE.class;
			case GENERIC_SIMPLE: return plain ? PlainBase.class : BlockBase.class;
			case GENERIC_ROAD: return G_ROAD.class;
			case GENERIC_ROAD_MARKER: return G_ROAD_MARKER.class;
			case GENERIC_ROAD_LINES: return G_ROAD_LINES.class;
			case GENERIC_ROAD_MARKER_4ROT: return G_ROAD_MARKER4.class;
			case GENERIC_ROAD_PATTERN: return G_ROAD_PATTERN.class;
			case JACK_STAND: return JACK.class;
		}
		return plain ? PlainBase.class : BlockBase.class;
	}

	public static double getRot(BlockState state){
		BlockType type = ((PlainBase)state.getBlock()).type.getBlockType();
		if(type.rotations == 4 || type.rotations == 44){
			switch(state.getValue(FACING).ordinal()){
				case 2: return 90;
				case 3: return -90;
				case 4: return 180;
				case 5: return 0;
			}
		}
		else if(type.rotations == 8){
			return state.getValue(PROP_ROT8) * -45 + 90;
		}
		else if(type.rotations == 16){
			return state.getValue(PROP_ROT16) * -22.5 + 90;
		}
		return 0;
	}

}
