package net.fexcraft.mod.fvtm.block.generated;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class FvtmProperties {

	public static final DirectionProperty FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final IntegerProperty PROP_ROT8 = IntegerProperty.create("rotation", 0, 7);
	public static final IntegerProperty PROP_ROT16 = IntegerProperty.create("rotation", 0, 15);

}
