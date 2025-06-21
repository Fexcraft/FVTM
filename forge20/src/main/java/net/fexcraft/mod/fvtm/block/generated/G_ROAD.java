package net.fexcraft.mod.fvtm.block.generated;

import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.util.Resources20;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

import static net.fexcraft.mod.fvtm.block.generated.FvtmProperties.*;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class G_ROAD extends PlainBase {

	public final int height;

	public G_ROAD(Block block, int height){
		super(block);
		this.height = height;
		Resources20.ROAD_BLOCKS.computeIfAbsent(block.getID(), key -> new net.minecraft.world.level.block.Block[16])[height] = this;
	}

	@Nullable
	public BlockState getStateForPlacement(BlockPlaceContext context){
		return super.getStateForPlacement(context);
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext ctx){
		return SHAPES[height];
	}

	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult res){
		ItemStack stack = player.getItemInHand(hand);
		if(level.isClientSide){
			return isRoadBlock(stack) ? InteractionResult.SUCCESS : InteractionResult.PASS;
		}
		int hei = height;
		if(isRoadBlock(stack) && hei > 0){
			int height = hei + ((G_ROAD)(((BlockItem)stack.getItem()).getBlock())).height;
			if(height >= 16) height = 0;
			if(height < 0) height = 0;
			level.setBlock(pos, Resources20.ROAD_BLOCKS.get(type.getID())[height].defaultBlockState(), 2);
			if(!player.isCreative()) stack.shrink(1);
			return InteractionResult.SUCCESS;
		}
		if(stack.getItem() instanceof DiggerItem && ((DiggerItem)stack.getItem()).getTier().getLevel() > 1){
			if(hei == 0) hei = 15;
			else if(hei == 1) return InteractionResult.PASS;
			else hei--;
			level.setBlock(pos, Resources20.ROAD_BLOCKS.get(type.getID())[hei].defaultBlockState(), 2);
			if(!player.isCreative()) stack.hurt(1, level.random, (ServerPlayer)player);
			player.addItem(new ItemStack(Resources20.ROAD_BLOCKS.get(type.getID())[1].asItem(), 1));
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.PASS;
	}

	private boolean isRoadBlock(ItemStack stack){
		if(!(stack.getItem() instanceof net.fexcraft.mod.fvtm.item.BlockItem)) return false;
		return ((net.fexcraft.mod.fvtm.item.BlockItem)stack.getItem()).getContent().getBlockType().isGenericRoad();
	}

}