package net.fexcraft.mod.fvtm.block;

import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.FvtmGetters;
import net.fexcraft.mod.fvtm.ui.UIKeys;
import net.fexcraft.mod.uni.UniEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;

import static net.fexcraft.mod.fvtm.block.generated.FvtmProperties.FACING;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ConstructorBlock extends Block implements EntityBlock {

	public ConstructorBlock(){
		super(Properties.of().noOcclusion().explosionResistance(64).strength(2));
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState){
		return FvtmGetters.CONST_ENTITY.get().create(pPos, pState);
	}

	@Override
	public RenderShape getRenderShape(BlockState pState){
		return RenderShape.INVISIBLE;
	}

	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult res){
		if(!level.isClientSide && hand != InteractionHand.OFF_HAND){
			UniEntity.get(player).entity.openUI(UIKeys.VEHICLE_CATALOG, new V3I(pos.getX(), pos.getY(), pos.getZ()));
		}
		return InteractionResult.SUCCESS;
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> sd){
		sd.add(FACING);
	}

	@Nullable
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return defaultBlockState().setValue(FACING, context.getPlayer().getDirection().getOpposite());
	}

}
