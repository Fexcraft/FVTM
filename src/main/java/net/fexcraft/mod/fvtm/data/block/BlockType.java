package net.fexcraft.mod.fvtm.data.block;

import net.fexcraft.mod.fvtm.block.generated.Generic4RotBlock;

public enum BlockType {
	
	GENERIC_4ROT(Generic4RotBlock.class);
	
	public final Class<? extends net.minecraft.block.Block> blockclass;
	
	BlockType(Class<? extends net.minecraft.block.Block> clazz){
		this.blockclass = clazz;
	}

}
