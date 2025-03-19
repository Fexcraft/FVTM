package net.fexcraft.mod.fvtm.block;

import net.fexcraft.mod.fvtm.ui.UIKeys;
import net.fexcraft.mod.fvtm.util.Resources21;
import net.fexcraft.mod.uni.UniEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;

import static net.fexcraft.mod.fvtm.block.generated.FvtmProperties.FACING;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class FuelFillerBlock extends Block implements EntityBlock {

    public FuelFillerBlock(Properties prop){
        super(prop.noOcclusion().explosionResistance(64).strength(2));
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state){
        return Resources21.FUELFILLER_ENTITY.create(pos, state);
    }

    @Override
    public RenderShape getRenderShape(BlockState pState){
        return RenderShape.INVISIBLE;
    }

    @Override
    public InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult res){
        if(!level.isClientSide && hand != InteractionHand.OFF_HAND){
            UniEntity.getEntity(player).openUI(UIKeys.FUEL_FILLER, pos.getX(), pos.getY(), pos.getZ());
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> sd){
        sd.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState().setValue(FACING, context.getPlayer().getDirection().getOpposite());
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type){
        return (BlockEntityTicker<T>)new FuelFillerEntity.Ticker();
    }

}

