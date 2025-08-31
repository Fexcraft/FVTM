package net.fexcraft.mod.fvtm.block.generated;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import static net.fexcraft.mod.fvtm.block.generated.FvtmProperties.*;
import static net.fexcraft.mod.fvtm.block.generated.G_ROAD_MARKER.getMarkerHeight;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class G_ROAD_LINES extends PlainBase {

	public G_ROAD_LINES(net.fexcraft.mod.fvtm.data.block.Block type){
		super(type);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> sd){
		sd.add(PROP_HEIGHT);
		sd.add(PROP_LINE_TYPE);
		sd.add(PROP_LINE_ROT);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context){
		return getCurrentState(context.getLevel(), context.getClickedPos());
	}

	@Override
	public BlockState updateShape(BlockState state, Direction dir, BlockState o, LevelAccessor level, BlockPos pos, BlockPos opos){
		return getCurrentState(level, pos);
	}

	private BlockState getCurrentState(LevelAccessor level, BlockPos pos){
		boolean nc = isCompatible(level.getBlockState(pos.north()), level.getBlockState(pos.north().below()), level.getBlockState(pos.north().above()));
		boolean sc = isCompatible(level.getBlockState(pos.south()), level.getBlockState(pos.south().below()), level.getBlockState(pos.south().above()));
		boolean ec = isCompatible(level.getBlockState(pos.east()), level.getBlockState(pos.east().below()), level.getBlockState(pos.east().above()));
		boolean wc = isCompatible(level.getBlockState(pos.west()), level.getBlockState(pos.west().below()), level.getBlockState(pos.west().above()));
		int lines = (nc ? 1 : 0) + (sc ? 1 : 0) + (wc ? 1 : 0) + (ec ? 1 : 0);
		int lt = 0;
		int rot = 0;
		if(lines < 2){
			rot = nc || sc ? 0 : 1;
		}
		else if(lines == 2){
			if((nc && sc) || (wc && ec)){
				rot = nc ? 0 : 1;
			}
			if(nc && ec){
				lt = 1;
			}
			if(ec && sc){
				lt = 1;
				rot = 1;
			}
			if(sc && wc){
				lt = 1;
				rot = 2;
			}
			if(wc && nc){
				lt = 1;
				rot = 3;
			}
		}
		else if(lines == 3){
			lt = 2;
			if(!ec) rot = 1;
			if(!sc) rot = 2;
			if(!wc) rot = 3;
		}
		else{
			lt = 3;
		}
		return defaultBlockState().setValue(PROP_HEIGHT, getMarkerHeight(level, pos)).setValue(PROP_LINE_TYPE, lt).setValue(PROP_LINE_ROT, rot);
	}

	private boolean isCompatible(BlockState... states){
		for(BlockState state : states){
			if(isCompatible(state)) return true;
		}
		return false;
	}

	private boolean isCompatible(BlockState state){
		if(state.getBlock() instanceof PlainBase == false) return false;
		net.fexcraft.mod.fvtm.data.block.Block blk = ((PlainBase)state.getBlock()).type;
		return blk.getBlockType().isRoadLayer();
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext ctx){
		return LOWER_SHAPES[state.getValue(PROP_HEIGHT)];
	}

}