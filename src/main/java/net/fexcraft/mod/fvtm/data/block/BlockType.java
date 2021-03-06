package net.fexcraft.mod.fvtm.data.block;

import net.fexcraft.mod.fvtm.block.generated.*;

public enum BlockType {
	
	GENERIC_4ROT(G_4ROT_TE.class, G_4ROT.class),
	GENERIC_16ROT(G_16ROT_TE.class, G_16ROT.class),
	GENERIC_ROAD(G_ROAD_TE.class, G_ROAD.class),
	MULTIBLOCK_4ROT(M_4ROT_TE.class, M_4ROT.class),
	SIGNAL_4ROT(SG_4ROT_TE.class, null),
	SIGNAL_16ROT(SG_16ROT_TE.class, null),
	FORK2_SWITCH_4ROT(F2SW_4ROT_TE.class, null),
	FORK3_SWITCH_4ROT(F3SW_4ROT_TE.class, null),
	DOUBLE_SWITCH_4ROT(DBSW_4ROT_TE.class, null),
	;
	
	public final Class<? extends net.minecraft.block.Block> blockclass, plainclass;
	
	BlockType(Class<? extends net.minecraft.block.Block> clazz, Class<? extends net.minecraft.block.Block> clazz0){
		this.blockclass = clazz;
		this.plainclass = clazz0;
	}

	public double getRotationForMeta(int meta){
		switch(this){
			case MULTIBLOCK_4ROT:
			case GENERIC_4ROT:
			case SIGNAL_4ROT:
			case FORK2_SWITCH_4ROT:
			case FORK3_SWITCH_4ROT:
			case DOUBLE_SWITCH_4ROT: {
		        switch(meta){
		            case 2: return 0;
		            case 3: return -180d;
		            case 4: return -90;
		            case 5: return -270d;
		        }
			}
			case GENERIC_16ROT:
			case SIGNAL_16ROT:{
				return meta * 22.5 + 180;
			}
			default: return 0;
		}
	}

	public Class<? extends net.minecraft.block.Block> getApplicableClass(boolean functional, boolean plain_model){
		return plain_model && !functional ? plainclass : blockclass;
	}

	public boolean isGenericRoad(){
		return this == GENERIC_ROAD;
	}

	public boolean isMultiBlock(){
		return this == MULTIBLOCK_4ROT;
	}

	boolean isRailBlock(){
		return this == SIGNAL_16ROT || this == SIGNAL_4ROT || this == FORK2_SWITCH_4ROT || this == FORK3_SWITCH_4ROT || this == DOUBLE_SWITCH_4ROT;
	}

}
