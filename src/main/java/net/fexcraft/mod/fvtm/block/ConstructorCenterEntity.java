package net.fexcraft.mod.fvtm.block;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;

public class ConstructorCenterEntity extends TileEntity {
	
	private ConstructorEntity tile;
	private BlockPos conpos;
	
	public ConstructorCenterEntity(){}
	
	public ConstructorEntity getConstructor(){
		return tile;
	}
	
	public BlockPos getLinkPos(){
		return conpos;
	}

}
