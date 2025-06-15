package net.fexcraft.mod.fvtm.block.generated;

import net.fexcraft.lib.common.Static;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;

import static net.fexcraft.mod.fvtm.block.generated.FvtmProperties.PROP_ROT16;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class G_16ROT_BE extends BlockBase {

	public G_16ROT_BE(Properties prop, Block type){
		super(prop, type);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<net.minecraft.world.level.block.Block, BlockState> sd){
		sd.add(PROP_ROT16);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return defaultBlockState().setValue(PROP_ROT16, type.isRandomRot() ? Static.random.nextInt(16) : (int)Math.floor((double)(context.getPlayer().yRotO * 16.0F / 360.0F) + 0.5D) & 15);
	}

}
