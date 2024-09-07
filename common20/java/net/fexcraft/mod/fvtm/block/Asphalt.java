package net.fexcraft.mod.fvtm.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Asphalt extends Block {

	public static final VoxelShape[] SHAPES = new VoxelShape[16];
	public final int height;

	public Asphalt(int height){
		super(Properties.of().noOcclusion().explosionResistance(2000).strength(8));
		this.height = height;
		if(SHAPES[0] == null){
			SHAPES[0] = Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 16.0);
			for(int i = 1; i < 16; i++){
				SHAPES[i] = Block.box(0, 0, 0, 16, i, 16);
			}
		}
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext ctx){
		return SHAPES[height];
	}

}
