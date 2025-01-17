package net.fexcraft.mod.fvtm.block;

import net.fexcraft.mod.fvtm.FvtmGetters;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ConstructorEntity extends BlockEntity {

	public ConstructorEntity(BlockPos pPos, BlockState pBlockState){
		super(FvtmGetters.CONST_ENTITY.get(), pPos, pBlockState);
	}

}
