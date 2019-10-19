package net.fexcraft.mod.fvtm.data.block;

import net.fexcraft.mod.fvtm.block.generated.G_16ROT;
import net.fexcraft.mod.fvtm.block.generated.G_16ROT_TE;
import net.fexcraft.mod.fvtm.block.generated.G_4ROT;
import net.fexcraft.mod.fvtm.block.generated.G_4ROT_TE;
import net.fexcraft.mod.fvtm.block.generated.G_ROAD;
import net.fexcraft.mod.fvtm.block.generated.G_ROAD_TE;

public enum BlockType {
	
	GENERIC_4ROT(G_4ROT_TE.class, G_4ROT.class),
	GENERIC_16ROT(G_16ROT_TE.class, G_16ROT.class),
	GENERIC_ROAD(G_ROAD_TE.class, G_ROAD.class);
	;
	
	public final Class<? extends net.minecraft.block.Block> blockclass, plainclass;
	
	BlockType(Class<? extends net.minecraft.block.Block> clazz, Class<? extends net.minecraft.block.Block> clazz0){
		this.blockclass = clazz; this.plainclass = clazz0;
	}

	public double getRotationForMeta(int meta){
		switch(this){
			case GENERIC_4ROT:{
		        switch(meta){
		            case 2: return 0;
		            case 3: return -180d;
		            case 4: return -90;
		            case 5: return -270d;
		        }
			}
			case GENERIC_16ROT: return meta * 22.5 + 180;
			default: return 0;
		}
	}

	public Class<? extends net.minecraft.block.Block> getApplicableClass(boolean functional, boolean plain_model){
		return plain_model && !functional ? plainclass : blockclass;
	}

}
