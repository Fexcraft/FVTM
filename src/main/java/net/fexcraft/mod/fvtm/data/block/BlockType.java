package net.fexcraft.mod.fvtm.data.block;

import net.fexcraft.mod.fvtm.block.generated.*;
import net.fexcraft.mod.fvtm.util.Properties;
import net.minecraft.block.properties.PropertyInteger;

public enum BlockType {
	
	GENERIC_4ROT(G_4ROT_TE.class, G_4ROT.class, 4),
	GENERIC_4X4ROT(G_4x4ROT_TE.class, G_4x4ROT.class, 44),
	GENERIC_16ROT(G_16ROT_TE.class, G_16ROT.class, 16),
	GENERIC_2VAR(G_VAR_TE.class, G_VAR.class, 0),
	GENERIC_3VAR(G_VAR_TE.class, G_VAR.class, 0),
	GENERIC_4VAR(G_VAR_TE.class, G_VAR.class, 0),
	GENERIC_5VAR(G_VAR_TE.class, G_VAR.class, 0),
	GENERIC_6VAR(G_VAR_TE.class, G_VAR.class, 0),
	GENERIC_7VAR(G_VAR_TE.class, G_VAR.class, 0),
	GENERIC_8VAR(G_VAR_TE.class, G_VAR.class, 0),
	GENERIC_9VAR(G_VAR_TE.class, G_VAR.class, 0),
	GENERIC_10VAR(G_VAR_TE.class, G_VAR.class, 0),
	GENERIC_11VAR(G_VAR_TE.class, G_VAR.class, 0),
	GENERIC_12VAR(G_VAR_TE.class, G_VAR.class, 0),
	GENERIC_13VAR(G_VAR_TE.class, G_VAR.class, 0),
	GENERIC_14VAR(G_VAR_TE.class, G_VAR.class, 0),
	GENERIC_15VAR(G_VAR_TE.class, G_VAR.class, 0),
	GENERIC_16VAR(G_VAR_TE.class, G_VAR.class, 0),
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
		else if(rotations == 16){
			return meta * 22.5 + 180;
		}
		else if(rotations == 44){
			meta %= 4;
	        switch(meta){
	            case 0: return 0;
	            case 1: return -180d;
	            case 2: return -90;
	            case 3: return -270d;
	        }
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

	public int getMetaVariants(){
		return this == GENERIC_ROAD ? 16 : this == GENERIC_4X4ROT ? 4 : (this.ordinal() >= 2 && this.ordinal() <= 16) ? this.ordinal() - 2 : 0;
	}

	public PropertyInteger getIntProperty(){
		switch(this){
			case GENERIC_2VAR: return Properties.VARIANTS2;
			case GENERIC_3VAR: return Properties.VARIANTS3;
			case GENERIC_4VAR:
			case GENERIC_4X4ROT: return Properties.VARIANTS4;
			case GENERIC_5VAR: return Properties.VARIANTS5;
			case GENERIC_6VAR: return Properties.VARIANTS6;
			case GENERIC_7VAR: return Properties.VARIANTS7;
			case GENERIC_8VAR: return Properties.VARIANTS8;
			case GENERIC_9VAR: return Properties.VARIANTS9;
			case GENERIC_10VAR: return Properties.VARIANTS10;
			case GENERIC_11VAR: return Properties.VARIANTS11;
			case GENERIC_12VAR: return Properties.VARIANTS12;
			case GENERIC_13VAR: return Properties.VARIANTS13;
			case GENERIC_14VAR: return Properties.VARIANTS14;
			case GENERIC_15VAR: return Properties.VARIANTS15;
			case GENERIC_16VAR: return Properties.VARIANTS16;
			default: break;
		}
		return Properties.VARIANTS16;
	}

}
