package net.fexcraft.mod.fvtm.block.generated;

import net.fexcraft.mod.fvtm.FVTM4;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.data.block.JackEntity;
import net.fexcraft.mod.fvtm.item.VehicleItem;
import net.fexcraft.mod.uni.inv.UniStack;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class JACK extends G_4ROT_BE {

    public JACK(Block type){
        super(type);
    }

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state){
		return FVTM4.JACK_ENTITY.get().create(pos, state);
	}

	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit){
		if(level.isClientSide || hand == InteractionHand.OFF_HAND) return InteractionResult.PASS;
		if(player.isShiftKeyDown()){
			JACK_BE tile = (JACK_BE)level.getBlockEntity(pos);
			if(tile != null){
				tile.dropVehicle(true);
				tile.markChanged();
				return InteractionResult.SUCCESS;
			}
			return InteractionResult.SUCCESS;
		}
		if(player.getMainHandItem().getItem() instanceof VehicleItem){
			JACK_BE tile = (JACK_BE)level.getBlockEntity(pos);
			if(tile != null){
				tile.dropVehicle(false);
				tile.vehicle = UniStack.get(player.getMainHandItem()).stack.getContent(ContentType.VEHICLE.item_type);
				tile.sendVehUpdate();
				tile.markChanged();
				if(!player.isCreative()) player.getMainHandItem().shrink(1);
				return InteractionResult.SUCCESS;
			}
		}
		return InteractionResult.PASS;
	}

	@Override
	public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, BlockEntity tile, ItemStack tool) {
		super.playerDestroy(level, player, pos, state, tile, tool);
		if(tile instanceof JackEntity){
			((JACK_BE)tile).dropVehicle(false);
		}
	}

}

