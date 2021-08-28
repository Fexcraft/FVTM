package net.fexcraft.mod.fvtm.data.block;

import net.fexcraft.mod.fvtm.block.generated.*;

public enum BlockType {
	
	GENERIC_4ROT(G_4ROT_TE.class, G_4ROT.class, 4),
	GENERIC_16ROT(G_16ROT_TE.class, G_16ROT.class, 16),
	GENERIC_ROAD(G_ROAD_TE.class, G_ROAD.class, 0),
	MULTIBLOCK_4ROT(M_4ROT_TE.class, M_4ROT.class, 4),
	SIGNAL_4ROT(SG_4ROT_TE.class, null, 4),
	SIGNAL_16ROT(SG_16ROT_TE.class, null, 16),
	FORK2_SWITCH_4ROT(F2SW_4ROT_TE.class, null, 4),
	FORK3_SWITCH_4ROT(F3SW_4ROT_TE.class, null, 4),
	DOUBLE_SWITCH_4ROT(DBSW_4ROT_TE.class, null, 4),
	;
	
	public final Class<? extends net.minecraft.block.Block> blockclass, plainclass;
	public final int rotations;
	
	BlockType(Class<? extends net.minecraft.block.Block> clazz, Class<? extends net.minecraft.block.Block> clazz0, int rot){
		this.blockclass = clazz;
		this.plainclass = clazz0;
		this.rotations = rot;
	}

	public double getRotationForMeta(int meta){
		if(rotations == 4){
	        switch(meta){
	            case 2: return 0;
	            case 3: return -180d;
	            case 4: return -90;
	            case 5: return -270d;
	        }
		}
		if(rotations == 16){
			return meta * 22.5 + 180;
		}
		return 0;
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

	public boolean isRailBlock(){
		return this == SIGNAL_16ROT || this == SIGNAL_4ROT || this == FORK2_SWITCH_4ROT || this == FORK3_SWITCH_4ROT || this == DOUBLE_SWITCH_4ROT;
	}

	public boolean is4Rot(){
		return rotations == 4;
	}

	public boolean is16Rot(){
		return rotations == 16;
	}

}
