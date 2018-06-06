package net.fexcraft.mod.fvtm.blocks;

import net.fexcraft.mod.fvtm.api.Block.BlockData;
import net.fexcraft.mod.fvtm.api.Block.BlockTileEntity;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;

public class UniversalTileEntity extends TileEntity implements BlockTileEntity {

	@Override
	public TileEntity getTileEntity(){
		return this;
	}

	@Override
	public IBlockState getBlockState(){
		return this.getBlockState();
	}

	@Override
	public BlockData getBlockData(){
		// TODO Auto-generated method stub
		return null;
	}

}
