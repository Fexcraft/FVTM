package net.fexcraft.mod.fvtm.block;

import net.fexcraft.mod.fvtm.FVTM4;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ConstructorEntity extends BlockEntity {

	public ConstructorEntity(BlockPos pPos, BlockState pBlockState){
		super(FVTM4.CONST_ENTITY.get(), pPos, pBlockState);
	}

}
