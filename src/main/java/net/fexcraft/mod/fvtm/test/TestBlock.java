package net.fexcraft.mod.fvtm.test;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class TestBlock extends Block implements EntityBlock {

	public TestBlock(Properties p_49795_){
		super(p_49795_);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
		return new TestTile(p_153215_, p_153216_);
	}

}
