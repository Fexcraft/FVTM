package net.fexcraft.mod.fvtm.data.block;

import net.fexcraft.mod.fvtm.block.Asphalt;
import net.fexcraft.mod.fvtm.block.generated.*;
import net.fexcraft.mod.fvtm.util.Properties;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;

public enum BlockType {
	
	GENERIC_4ROT(G_4ROT_TE.class, G_4ROT.class, 4),
	GENERIC_4X4ROT(G_4x4ROT_TE.class, G_4x4ROT.class, 44),
	GENERIC_16ROT(G_16ROT_TE.class, G_16ROT.class, 16),
	GENERIC_SIMPLE(G_SIMPLE_TE.class, G_SIMPLE.class, 0),
	GENERIC_2VAR(G_VAR_TE.T2.class, G_VAR.T2.class, 0),
	GENERIC_3VAR(G_VAR_TE.T3.class, G_VAR.T3.class, 0),
	GENERIC_4VAR(G_VAR_TE.T4.class, G_VAR.T4.class, 0),
	GENERIC_5VAR(G_VAR_TE.T5.class, G_VAR.T5.class, 0),
	GENERIC_6VAR(G_VAR_TE.T6.class, G_VAR.T6.class, 0),
	GENERIC_7VAR(G_VAR_TE.T7.class, G_VAR.T7.class, 0),
	GENERIC_8VAR(G_VAR_TE.T8.class, G_VAR.T8.class, 0),
	GENERIC_9VAR(G_VAR_TE.T9.class, G_VAR.T9.class, 0),
	GENERIC_10VAR(G_VAR_TE.T10.class, G_VAR.T10.class, 0),
	GENERIC_11VAR(G_VAR_TE.T11.class, G_VAR.T11.class, 0),
	GENERIC_12VAR(G_VAR_TE.T12.class, G_VAR.T12.class, 0),
	GENERIC_13VAR(G_VAR_TE.T13.class, G_VAR.T13.class, 0),
	GENERIC_14VAR(G_VAR_TE.T14.class, G_VAR.T14.class, 0),
	GENERIC_15VAR(G_VAR_TE.T15.class, G_VAR.T15.class, 0),
	GENERIC_16VAR(G_VAR_TE.T16.class, G_VAR.T16.class, 0),
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
		switch(this){
			case GENERIC_2VAR: return 2;
			case GENERIC_3VAR: return 3;
			case GENERIC_4VAR: return 4;
			case GENERIC_5VAR: return 5;
			case GENERIC_6VAR: return 6;
			case GENERIC_7VAR: return 7;
			case GENERIC_8VAR: return 8;
			case GENERIC_9VAR: return 9;
			case GENERIC_10VAR: return 10;
			case GENERIC_11VAR: return 11;
			case GENERIC_12VAR: return 12;
			case GENERIC_13VAR: return 13;
			case GENERIC_14VAR: return 14;
			case GENERIC_15VAR: return 15;
			case GENERIC_16VAR: return 16;
			case GENERIC_4X4ROT: return 4;
			case GENERIC_ROAD: return 16;
			default: return 0;
		}
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

	public IProperty<?> getProperty(){
		switch(this){
			case GENERIC_4ROT:
			case GENERIC_4X4ROT:
			case MULTIBLOCK_4ROT:
			case SIGNAL_4ROT:
			case FORK2_SWITCH_4ROT:
			case FORK3_SWITCH_4ROT:
			case DOUBLE_SWITCH_4ROT:
				return Properties.FACING;
			case GENERIC_16ROT:
			case SIGNAL_16ROT:
				return Properties.ROTATION;
			case GENERIC_SIMPLE:
				return null;
			case GENERIC_2VAR:
				return Properties.VARIANTS2;
			case GENERIC_3VAR:
				return Properties.VARIANTS3;
			case GENERIC_4VAR:
				return Properties.VARIANTS4;
			case GENERIC_5VAR:
				return Properties.VARIANTS5;
			case GENERIC_6VAR:
				return Properties.VARIANTS6;
			case GENERIC_7VAR:
				return Properties.VARIANTS7;
			case GENERIC_8VAR:
				return Properties.VARIANTS8;
			case GENERIC_9VAR:
				return Properties.VARIANTS9;
			case GENERIC_10VAR:
				return Properties.VARIANTS10;
			case GENERIC_11VAR:
				return Properties.VARIANTS11;
			case GENERIC_12VAR:
				return Properties.VARIANTS12;
			case GENERIC_13VAR:
				return Properties.VARIANTS13;
			case GENERIC_14VAR:
				return Properties.VARIANTS14;
			case GENERIC_15VAR:
				return Properties.VARIANTS15;
			case GENERIC_16VAR:
				return Properties.VARIANTS16;
			case GENERIC_ROAD:
				return Asphalt.HEIGHT;
		}
		return null;
	}

	public boolean isVariant(){
		return this == GENERIC_4X4ROT || (this.ordinal() >= GENERIC_2VAR.ordinal() && this.ordinal() <= GENERIC_ROAD.ordinal());
	}
}
