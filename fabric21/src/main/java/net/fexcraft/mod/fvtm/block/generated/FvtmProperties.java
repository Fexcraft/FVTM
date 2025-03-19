package net.fexcraft.mod.fvtm.block.generated;

import net.fexcraft.mod.fcl.local.CraftingBlock;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class FvtmProperties {

	public static final EnumProperty<Direction> FACING = CraftingBlock.FACING;
	public static final IntegerProperty PROP_ROT8 = IntegerProperty.create("rotation", 0, 7);
	public static final IntegerProperty PROP_ROT16 = IntegerProperty.create("rotation", 0, 15);

}
