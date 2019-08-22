package net.fexcraft.mod.fvtm.data.block;

import net.fexcraft.mod.fvtm.block.generated.Generic4RotBlock;
import net.fexcraft.mod.fvtm.block.generated.Generic16RotBlock;

public enum BlockType {
	
	GENERIC_4ROT(Generic4RotBlock.class),
	GENERIC_16ROT(Generic16RotBlock.class),
	;
	
	public final Class<? extends net.minecraft.block.Block> blockclass;
	
	BlockType(Class<? extends net.minecraft.block.Block> clazz){
		this.blockclass = clazz;
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

}
