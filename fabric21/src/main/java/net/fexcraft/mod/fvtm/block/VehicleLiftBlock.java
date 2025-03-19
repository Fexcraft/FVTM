package net.fexcraft.mod.fvtm.block;

import net.fexcraft.mod.fvtm.item.VehicleItem;
import net.fexcraft.mod.fvtm.util.Resources21;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class VehicleLiftBlock extends Block implements EntityBlock {

	public VehicleLiftBlock(Properties prop){
		super(prop.noOcclusion().explosionResistance(64).strength(2));
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext ctx){
		return Asphalt.SHAPES[1];
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState){
		return Resources21.LIFT_ENTITY.create(pPos, pState);
	}

	@Override
	public RenderShape getRenderShape(BlockState pState){
		return RenderShape.INVISIBLE;
	}

	@Override
	public boolean triggerEvent(BlockState state, Level level, BlockPos pos, int i, int j){
		super.triggerEvent(state, level, pos, i, j);
		BlockEntity be = level.getBlockEntity(pos);
		return be == null ? false : be.triggerEvent(i, j);
	}

	@Override
	public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, BlockEntity tile, ItemStack tool) {
		super.playerDestroy(level, player, pos, state, tile, tool);
		if(tile != null){
			VehicleLiftEntity lift = (VehicleLiftEntity)tile;
			if(lift.getVehicleData() == null) return;
			ItemEntity ent = new ItemEntity(level, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, lift.getVehicleData().newItemStack().local());
			level.addFreshEntity(ent);
		}
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack){
		BlockEntity entity = level.getBlockEntity(pos);
		if(entity == null) return;
		VehicleLiftEntity lift = (VehicleLiftEntity)entity;
		lift.rot = placer.getDirection().ordinal();
    }

    @Override
    public InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult res){
		if(level.isClientSide || hand == InteractionHand.OFF_HAND) return InteractionResult.PASS;
		if(player.isShiftKeyDown()){
			VehicleLiftEntity tile = (VehicleLiftEntity)level.getBlockEntity(pos);
			if(tile != null){
				tile.setVehicle(ItemStack.EMPTY);
				return InteractionResult.SUCCESS;
			}
			return InteractionResult.SUCCESS;
		}
		if(player.getMainHandItem().getItem() instanceof VehicleItem){
			VehicleLiftEntity tile = (VehicleLiftEntity)level.getBlockEntity(pos);
			if(tile != null){
				tile.setVehicle(player.getMainHandItem());
				if(!player.isCreative()) player.getMainHandItem().shrink(1);
				return InteractionResult.SUCCESS;
			}
		}
		return InteractionResult.PASS;
    }

}
