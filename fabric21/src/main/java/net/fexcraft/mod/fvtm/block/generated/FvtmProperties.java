package net.fexcraft.mod.fvtm.block.generated;

import net.fexcraft.mod.fcl.local.CraftingBlock;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class FvtmProperties {

	public static final EnumProperty<Direction> FACING = CraftingBlock.FACING;
	public static final IntegerProperty PROP_ROT8 = IntegerProperty.create("rotation", 0, 7);
	public static final IntegerProperty PROP_ROT16 = IntegerProperty.create("rotation", 0, 15);
	//
	public static final VoxelShape[] SHAPES = new VoxelShape[16];
	static {
		SHAPES[0] = Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 16.0);
		for(int i = 1; i < 16; i++){
			SHAPES[i] = Block.box(0, 0, 0, 16, i, 16);
		}
	}

}
