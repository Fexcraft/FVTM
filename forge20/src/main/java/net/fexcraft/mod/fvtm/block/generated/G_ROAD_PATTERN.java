package net.fexcraft.mod.fvtm.block.generated;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.lib.common.Static;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

import javax.annotation.Nullable;

import static net.fexcraft.mod.fvtm.block.generated.FvtmProperties.FACING;
import static net.fexcraft.mod.fvtm.block.generated.FvtmProperties.PROP_HEIGHT;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class G_ROAD_PATTERN extends G_ROAD_MARKER {

	public IntegerProperty prop_x;
	public IntegerProperty prop_z;
	private int defx;
	private int defz;

	public G_ROAD_PATTERN(net.fexcraft.mod.fvtm.data.block.Block type){
		super(type);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> sd){
		sd.add(PROP_HEIGHT);
		sd.add(FACING);
		JsonArray arr = type.getCustomStates().get("x").asArray();
		prop_x = FvtmProperties.PROP_PATTERN_X.get(arr.get(0).integer_value());
		defx = arr.get(1).integer_value();
		arr = type.getCustomStates().get("z").asArray();
		prop_z = FvtmProperties.PROP_PATTERN_Z.get(arr.get(0).integer_value());
		defz = arr.get(1).integer_value();
		sd.add(prop_x);
		sd.add(prop_z);
	}

	@Nullable
	public BlockState getStateForPlacement(BlockPlaceContext context){
		return defaultBlockState().setValue(PROP_HEIGHT, getMarkerHeight(context.getLevel(), context.getClickedPos()))
			.setValue(FACING, type.isRandomRot() ? Direction.values()[Static.random.nextInt(4) + 2] : context.getPlayer().getDirection().getOpposite());
	}

}