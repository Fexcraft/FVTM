package net.fexcraft.mod.fvtm.block.generated;

import net.fexcraft.mod.fvtm.data.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class SG_16ROT_TE extends G_16ROT_TE {

	public SG_16ROT_TE(Block type){
		super(type);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta){
		return new SignalTileEntity(this);
	}

}
