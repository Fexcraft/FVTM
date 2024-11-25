package net.fexcraft.mod.fvtm.block.generated;

import net.fexcraft.mod.fvtm.FvtmGetters;
import net.fexcraft.mod.fvtm.block.VehicleLiftEntity;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.item.BlockItem;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class BlockBase extends PlainBase implements EntityBlock {

	public BlockBase(Block type){
		super(type);
	}

	@Override
	public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state){
		return FvtmGetters.BLOCK_ENTITY.get().create(pos, state);
	}

	@Override
	public void setPlacedBy(Level level, BlockPos pos, BlockState state, @javax.annotation.Nullable LivingEntity placer, ItemStack stack){
		BlockEntity entity = level.getBlockEntity(pos);
		if(entity == null) return;
		BaseBlockEntity base = (BaseBlockEntity)entity;
		base.data = ((BlockItem)stack.getItem()).getData(StackWrapper.wrap(stack));
	}

	@Override
	public RenderShape getRenderShape(BlockState state){
		return type.isInvisible() ? RenderShape.INVISIBLE : type.hasPlainModel() ? RenderShape.MODEL : RenderShape.ENTITYBLOCK_ANIMATED;
	}

}
