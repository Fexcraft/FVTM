package net.fexcraft.mod.fvtm.test;

import net.fexcraft.mod.fvtm.FVTM;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class TestTile extends BlockEntity {

	public TestTile(BlockPos p_155229_, BlockState p_155230_){
		super(FVTM.TEST_TILE.get(), p_155229_, p_155230_);
	}

}
