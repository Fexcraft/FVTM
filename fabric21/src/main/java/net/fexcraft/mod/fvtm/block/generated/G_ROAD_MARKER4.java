package net.fexcraft.mod.fvtm.block.generated;

import net.fexcraft.lib.common.Static;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;

import static net.fexcraft.mod.fvtm.block.generated.FvtmProperties.FACING;
import static net.fexcraft.mod.fvtm.block.generated.FvtmProperties.PROP_HEIGHT;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class G_ROAD_MARKER4 extends G_ROAD_MARKER {

	public G_ROAD_MARKER4(Properties prop, net.fexcraft.mod.fvtm.data.block.Block type){
		super(prop, type);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> sd){
		sd.add(PROP_HEIGHT);
		sd.add(FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context){
		return defaultBlockState().setValue(PROP_HEIGHT, getMarkerHeight(context.getLevel(), context.getClickedPos()))
			.setValue(FACING, type.isRandomRot() ? Direction.values()[Static.random.nextInt(4) + 2] : context.getPlayer().getDirection().getOpposite());
	}

}