package net.fexcraft.mod.fvtm.block.generated;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.lib.common.Static;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

import static net.fexcraft.mod.fvtm.block.generated.FvtmProperties.FACING;
import static net.fexcraft.mod.fvtm.block.generated.FvtmProperties.PROP_HEIGHT;
import static net.fexcraft.mod.fvtm.data.block.Block.BLK_GETTER_CACHE;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class G_ROAD_PATTERN extends G_ROAD_MARKER {

	public IntegerProperty prop_x;
	public IntegerProperty prop_z;
	public int texx;
	public int texz;
	private int sizex;
	private int sizez;
	private int defx;
	private int defz;

	public G_ROAD_PATTERN(Properties prop, net.fexcraft.mod.fvtm.data.block.Block type){
		super(prop, type);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> sd){
		sd.add(PROP_HEIGHT);
		sd.add(FACING);
		JsonArray arr = BLK_GETTER_CACHE.getCustomStates().get("pattern_x").asArray();
		prop_x = FvtmProperties.PROP_PATTERN_X.get(sizex = arr.get(0).integer_value());
		defx = arr.get(1).integer_value();
		texx = arr.get(2).integer_value();
		arr = BLK_GETTER_CACHE.getCustomStates().get("pattern_z").asArray();
		prop_z = FvtmProperties.PROP_PATTERN_Z.get(sizez = arr.get(0).integer_value());
		defz = arr.get(1).integer_value();
		texz = arr.get(2).integer_value();
		sd.add(prop_x);
		sd.add(prop_z);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context){
		int[] xz = { defx, defz };
		BlockState n = getSamePattern(getPatternAt(context.getLevel(), context.getClickedPos().north()));
		BlockState w = getSamePattern(getPatternAt(context.getLevel(), context.getClickedPos().west()));
		BlockState s = getSamePattern(getPatternAt(context.getLevel(), context.getClickedPos().south()));
		BlockState e = getSamePattern(getPatternAt(context.getLevel(), context.getClickedPos().east()));
		Direction rot = Direction.NORTH;
		if(type.isRandomRot()) rot = Direction.values()[Static.random.nextInt(4) + 2];
		else if(context.getPlayer() != null) rot = context.getPlayer().getDirection();
		switch(rot){
			case NORTH -> rot = setPatternPos(rot, xz, n, w, s, e);
			case SOUTH -> rot = setPatternPos(rot, xz, s, e, n, w);
			case EAST -> rot = setPatternPos(rot, xz, e, n, w, s);
			case WEST -> rot = setPatternPos(rot, xz, w, s, e, n);
		}
		return defaultBlockState().setValue(PROP_HEIGHT, getMarkerHeight(context.getLevel(), context.getClickedPos()))
			.setValue(FACING, rot).setValue(prop_x, xz[0]).setValue(prop_z, xz[1]);
	}

	private Direction setPatternPos(Direction rot, int[] xz, BlockState n, BlockState w, BlockState s, BlockState e){
		if(n != null){
			xz[0] = n.getValue(prop_x);
			xz[1] = n.getValue(prop_z) + 1;
			if(xz[1] >= sizez) xz[1] = 0;
			if(xz[1] < 0) xz[1] = sizez - 1;
			return n.getValue(FACING);
 		}
		if(w != null){
			xz[0] = w.getValue(prop_x) + 1;
			xz[1] = w.getValue(prop_z);
			if(xz[0] >= sizex) xz[0] = 0;
			if(xz[0] < 0) xz[0] = sizex - 1;
			return w.getValue(FACING);
		}
		if(s != null){
			xz[0] = s.getValue(prop_x);
			xz[1] = s.getValue(prop_z) - 1;
			if(xz[1] >= sizez) xz[1] = 0;
			if(xz[1] < 0) xz[1] = sizez - 1;
			return s.getValue(FACING);
		}
		if(e != null){
			xz[0] = e.getValue(prop_x) - 1;
			xz[1] = e.getValue(prop_z);
			if(xz[0] >= sizex) xz[0] = 0;
			if(xz[0] < 0) xz[0] = sizex - 1;
			return e.getValue(FACING);
		}
		return rot;
	}

	private BlockState getSamePattern(BlockState state){
		return state != null && ((PlainBase)state.getBlock()).type == type ? state : null;
	}

	private BlockState getPatternAt(Level level, BlockPos pos){
		BlockState state = level.getBlockState(pos);
		if(state.getBlock() instanceof G_ROAD_PATTERN) return state;
		state = level.getBlockState(pos.below());
		if(state.getBlock() instanceof G_ROAD_PATTERN) return state;
		state = level.getBlockState(pos.above());
		return state.getBlock() instanceof G_ROAD_PATTERN ? state : null;
	}

}