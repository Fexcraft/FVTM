package net.fexcraft.mod.fvtm.block.generated;

import net.fexcraft.lib.common.Static;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;

import javax.annotation.Nullable;

import static net.fexcraft.mod.fvtm.block.generated.FvtmProperties.FACING;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class G_4ROT extends PlainBase {

	public G_4ROT(net.fexcraft.mod.fvtm.data.block.Block type){
		super(type);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> sd){
		sd.add(FACING);
	}

	@Nullable
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return defaultBlockState().setValue(FACING, type.isRandomRot() ? Direction.values()[Static.random.nextInt(4) + 2] : context.getPlayer().getDirection().getOpposite());
	}


}
