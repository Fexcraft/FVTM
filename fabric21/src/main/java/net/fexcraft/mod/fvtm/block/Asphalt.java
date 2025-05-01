package net.fexcraft.mod.fvtm.block;

import net.fexcraft.mod.fvtm.util.Resources21;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Asphalt extends Block {

	public static final VoxelShape[] SHAPES = new VoxelShape[16];
	public final int height;

	public Asphalt(Properties prop, int height){
		super(prop.noOcclusion().explosionResistance(2000).strength(8));
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

	@Override
	public InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult res){
		if(level.isClientSide){
			return stack.getItem() instanceof BlockItem && ((BlockItem)stack.getItem()).getBlock() instanceof Asphalt ? InteractionResult.SUCCESS : InteractionResult.PASS;
		}
		int hei = height;
		if(stack.getItem() instanceof BlockItem && ((BlockItem)stack.getItem()).getBlock() instanceof Asphalt && hei > 0){
			int height = hei + ((Asphalt)((BlockItem)stack.getItem()).getBlock()).height;
			if(height >= 16) height = 0;
			if(height < 0) height = 0;
			level.setBlock(pos, Resources21.ASPHALT[height].defaultBlockState(), 2);
			if(!player.isCreative()) stack.shrink(1);
			return InteractionResult.SUCCESS;
		}
		if(stack.has(DataComponents.TOOL)){
			if(hei == 0) hei = 15;
			else if(hei == 1) return InteractionResult.PASS;
			else hei--;
			level.setBlock(pos, Resources21.ASPHALT[hei].defaultBlockState(), 2);
			if(!player.isCreative()) stack.hurtAndBreak(1, (ServerLevel)level, (ServerPlayer)player, item -> {});
			player.addItem(new ItemStack(Resources21.ASPHALT_ITEM[1], 1));
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.PASS;
	}

}
