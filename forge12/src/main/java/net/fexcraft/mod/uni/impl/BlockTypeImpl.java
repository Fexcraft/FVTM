package net.fexcraft.mod.uni.impl;

import net.fexcraft.mod.fvtm.block.generated.*;
import net.fexcraft.mod.fvtm.data.block.BlockType;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class BlockTypeImpl {

	public static Class get(BlockType type, boolean func, boolean plain){
		plain = plain && !func;
		switch(type){
			case GENERIC_4ROT: return plain ? G_4ROT.class : G_4ROT_TE.class;
			case GENERIC_4X4ROT: return plain ? G_4x4ROT.class : G_4x4ROT_TE.class;
			case GENERIC_8ROT: return plain ? G_8ROT.class : G_8ROT_TE.class;
			case GENERIC_16ROT: return plain ? G_16ROT.class : G_16ROT_TE.class;
			case GENERIC_SIMPLE: return plain ? G_SIMPLE.class : G_SIMPLE_TE.class;
			case GENERIC_2VAR: return plain ? G_VAR.T2.class : G_VAR_TE.T2.class;
			case GENERIC_3VAR: return plain ? G_VAR.T3.class : G_VAR_TE.T3.class;
			case GENERIC_4VAR: return plain ? G_VAR.T4.class : G_VAR_TE.T4.class;
			case GENERIC_5VAR: return plain ? G_VAR.T5.class : G_VAR_TE.T5.class;
			case GENERIC_6VAR: return plain ? G_VAR.T6.class : G_VAR_TE.T6.class;
			case GENERIC_7VAR: return plain ? G_VAR.T7.class : G_VAR_TE.T7.class;
			case GENERIC_8VAR: return plain ? G_VAR.T8.class : G_VAR_TE.T8.class;
			case GENERIC_9VAR: return plain ? G_VAR.T9.class : G_VAR_TE.T9.class;
			case GENERIC_10VAR: return plain ? G_VAR.T10.class : G_VAR_TE.T10.class;
			case GENERIC_11VAR: return plain ? G_VAR.T11.class : G_VAR_TE.T11.class;
			case GENERIC_12VAR: return plain ? G_VAR.T12.class : G_VAR_TE.T12.class;
			case GENERIC_13VAR: return plain ? G_VAR.T13.class : G_VAR_TE.T13.class;
			case GENERIC_14VAR: return plain ? G_VAR.T14.class : G_VAR_TE.T14.class;
			case GENERIC_15VAR: return plain ? G_VAR.T15.class : G_VAR_TE.T15.class;
			case GENERIC_16VAR: return plain ? G_VAR.T16.class : G_VAR_TE.T16.class;
			case GENERIC_8LAYER: return G_8LAY.class;
			case GENERIC_ROAD: return G_ROAD.class;
			case GENERIC_ROAD_LINES: return G_ROAD_LINES.class;
			case GENERIC_ROAD_MARKER: return G_ROAD_MARKER.class;
			case GENERIC_ROAD_MARKER_4ROT: return G_ROAD_MARKER4.class;
			case GENERIC_ROAD_PATTERN: return G_ROAD_MARKER.class;
			case MULTIBLOCK_4ROT: return plain ? M_4ROT.class : M_4ROT_TE.class;
			case SIGNAL_4ROT: return SG_4ROT_TE.class;
			case SIGNAL_16ROT: return SG_16ROT_TE.class;
			case FORK2_SWITCH_4ROT: return F2SW_4ROT_TE.class;
			case FORK3_SWITCH_4ROT: return F3SW_4ROT_TE.class;
			case DOUBLE_SWITCH_4ROT: return DBSW_4ROT_TE.class;
			case GENERIC_POST_LIKE: return G_POSTLIKE.class;
			case JACK_STAND: return JACK.class;
		}
		return G_SIMPLE.class;
	}

}
