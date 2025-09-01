package net.fexcraft.mod.fvtm.block.generated;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

import static net.fexcraft.mod.fvtm.block.generated.FvtmProperties.*;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class G_ROAD_MARKER extends PlainBase {

	public G_ROAD_MARKER(net.fexcraft.mod.fvtm.data.block.Block type){
		super(type);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> sd){
		sd.add(PROP_HEIGHT);
	}

	@Nullable
	public BlockState getStateForPlacement(BlockPlaceContext context){
		return defaultBlockState().setValue(PROP_HEIGHT, getMarkerHeight(context.getLevel(), context.getClickedPos()));
	}

	public static int getMarkerHeight(LevelAccessor level, BlockPos pos){
		BlockState state = level.getBlockState(pos.below());
		VoxelShape shape = state.getShape(level, pos.below());
		int val = shape.isEmpty() ? 0 : (int)((shape.bounds().maxY - 1) * -16);
		if(val >= 16 || val < 0) val = 0;
		return val;
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext ctx){
		return LOWER_SHAPES[state.getValue(PROP_HEIGHT)];
	}

}