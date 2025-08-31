package net.fexcraft.mod.fvtm.block.generated;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class FvtmProperties {

	public static final DirectionProperty FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final IntegerProperty PROP_VAR4 = IntegerProperty.create("variant", 0, 3);
	public static final IntegerProperty PROP_ROT8 = IntegerProperty.create("rotation", 0, 7);
	public static final IntegerProperty PROP_ROT16 = IntegerProperty.create("rotation", 0, 15);
	public static final IntegerProperty PROP_HEIGHT = IntegerProperty.create("height", 0, 15);
	public static final IntegerProperty PROP_LINE_TYPE = IntegerProperty.create("line_type", 0, 3);
	public static final IntegerProperty PROP_LINE_ROT = IntegerProperty.create("line_rot", 0, 3);
	//
	public static final VoxelShape[] SHAPES = new VoxelShape[16];
	static{
		SHAPES[0] = Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 16.0);
		for(int i = 1; i < 16; i++){
			SHAPES[i] = Block.box(0, 0, 0, 16, i, 16);
		}
	}
	public static final VoxelShape[] LOWER_SHAPES = new VoxelShape[16];
	static{
		LOWER_SHAPES[0] = Block.box(0.0, 0.0, 0.0, 16.0, 0.25, 16.0);
		for(int i = 1; i < 16; i++){
			LOWER_SHAPES[i] = Block.box(0, -16 + i, 0, 16, -16 + i + 0.25, 16);
		}
	}

}
