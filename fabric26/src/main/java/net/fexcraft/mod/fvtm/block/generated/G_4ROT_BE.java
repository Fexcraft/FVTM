package net.fexcraft.mod.fvtm.block.generated;

import net.fexcraft.lib.common.Static;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import static net.fexcraft.mod.fvtm.block.generated.FvtmProperties.FACING;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class G_4ROT_BE extends BlockBase {

	public G_4ROT_BE(Properties prop, Block type){
		super(prop, type);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<net.minecraft.world.level.block.Block, BlockState> sd){
		sd.add(FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return defaultBlockState().setValue(FACING, type.isRandomRot() ? Direction.values()[Static.random.nextInt(4) + 2] : context.getPlayer().getDirection().getOpposite());
	}

	@Override
	protected void fillVoxelShapes(){
		super.fillVoxelShapes();
		for(Direction dir : FACING.getPossibleValues()){
			vshapes.put("facing=", Shapes.create(type.getAABB("default", "facing=" + dir.getName()).get(0)));
			collision.put("facing=", Shapes.create(type.getAABB("collision", "facing=" + dir.getName()).get(0)));
		}
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext ctx){
		return vshapes.getOrDefault("facing=" + state.getValue(FACING).name(), vshapes.get("normal"));
	}

	@Override
	public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext ctx){
		return collision.getOrDefault("facing=" + state.getValue(FACING).name(), collision.get("normal"));
	}

}
