package net.fexcraft.mod.fvtm.util;

import net.fexcraft.mod.fvtm.block.generated.*;
import net.fexcraft.mod.fvtm.data.block.BlockType;

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
			case GENERIC_ROAD_MARKER_4ROT: return G_ROAD_MARKER4.class;
			case GENERIC_ROAD_LINES: return G_ROAD_LINES.class;
        }
        return plain ? PlainBase.class : BlockBase.class;
    }

}
