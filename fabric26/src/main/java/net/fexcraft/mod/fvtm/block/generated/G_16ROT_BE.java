package net.fexcraft.mod.fvtm.block.generated;

import net.fexcraft.lib.common.Static;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import static net.fexcraft.mod.fvtm.block.generated.FvtmProperties.PROP_ROT16;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class G_16ROT_BE extends BlockBase {

	public G_16ROT_BE(Properties prop, Block type){
		super(prop, type);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<net.minecraft.world.level.block.Block, BlockState> sd){
		sd.add(PROP_ROT16);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return defaultBlockState().setValue(PROP_ROT16, type.isRandomRot() ? Static.random.nextInt(16) : (int)Math.floor((double)(context.getPlayer().yRotO * 16.0F / 360.0F) + 0.5D) & 15);
	}

	@Override
	protected void fillVoxelShapes(){
		super.fillVoxelShapes();
		for(Integer rot : PROP_ROT16.getPossibleValues()){
			vshapes.put("rotation=", Shapes.create(type.getAABB("default", "rotation=" + rot).get(0)));
			collision.put("rotation=", Shapes.create(type.getAABB("collision", "rotation=" + rot).get(0)));
		}
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext ctx){
		return vshapes.getOrDefault("rotation=" + state.getValue(PROP_ROT16), vshapes.get("normal"));
	}

	@Override
	public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext ctx){
		return collision.getOrDefault("rotation=" + state.getValue(PROP_ROT16), collision.get("normal"));
	}

}
