package net.fexcraft.mod.fvtm.block;

import net.fexcraft.mod.fvtm.util.Resources20;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import static net.fexcraft.mod.fvtm.block.generated.FvtmProperties.SHAPES;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Asphalt extends Block {
	public final int height;

	public Asphalt(int height){
		super(Properties.of().noOcclusion().explosionResistance(2000).strength(height == 0 ? 3 : 3f - 3f / height));
		this.height = height;

	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext ctx){
		return SHAPES[height];
	}

	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult res){
		ItemStack stack = player.getItemInHand(hand);
		if(level.isClientSide){
			return stack.getItem() instanceof BlockItem && ((BlockItem)stack.getItem()).getBlock() instanceof Asphalt ? InteractionResult.SUCCESS : InteractionResult.PASS;
		}
		int hei = height;
		if(stack.getItem() instanceof BlockItem && ((BlockItem)stack.getItem()).getBlock() instanceof Asphalt && hei > 0){
			int height = hei + ((Asphalt)((BlockItem)stack.getItem()).getBlock()).height;
			if(height >= 16) height = 0;
			if(height < 0) height = 0;
			level.setBlock(pos, Resources20.ASPHALT[height].get().defaultBlockState(), 2);
			if(!player.isCreative()) stack.shrink(1);
			return InteractionResult.SUCCESS;
		}
		if(stack.getItem() instanceof DiggerItem && ((DiggerItem)stack.getItem()).getTier().getLevel() > 1){
			if(hei == 0) hei = 15;
			else if(hei == 1) return InteractionResult.PASS;
			else hei--;
			level.setBlock(pos, Resources20.ASPHALT[hei].get().defaultBlockState(), 2);
			if(!player.isCreative()) stack.hurt(1, level.random, (ServerPlayer)player);
			player.addItem(new ItemStack(Resources20.ASPHALT_ITEM[1].get(), 1));
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.PASS;
	}

}
