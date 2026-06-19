package net.fexcraft.mod.fvtm.block.generated;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.FVTM4;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.data.block.BlockFunction;
import net.fexcraft.mod.fvtm.item.BlockItem20;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.wire.WireSystem;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.inv.UniStack;
import net.fexcraft.mod.uni.world.StateWrapper;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

import static net.fexcraft.mod.uni.world.WrapperHolder.*;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class BlockBase extends PlainBase implements EntityBlock {

	public BlockBase(Block type){
		super(type);
	}

	@Override
	public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state){
		return FVTM4.BLOCK_ENTITY.get().create(pos, state);
	}

	@Override
	public void setPlacedBy(Level level, BlockPos pos, BlockState state, @javax.annotation.Nullable LivingEntity placer, ItemStack stack){
		BlockEntity entity = level.getBlockEntity(pos);
		if(entity == null) return;
		BaseBlockEntity base = (BaseBlockEntity)entity;
		base.data = ((BlockItem20)stack.getItem()).getData(UniStack.getStack(stack));
		base.regRelay();
	}

	@Deprecated
	public void onRemove(BlockState state0, Level level, BlockPos pos, BlockState state1, boolean bool){
		if(type.hasRelay() && SystemManager.active(SystemManager.Systems.WIRE)){
			SystemManager.get(SystemManager.Systems.WIRE, WrapperHolder.getWorld(level), WireSystem.class).deregister(level.getBlockEntity(pos));
		}
		super.onRemove(state0, level, pos, state1, bool);
	}

	@Override
	public RenderShape getRenderShape(BlockState state){
		return type.isInvisible() ? RenderShape.INVISIBLE : type.hasPlainModel() ? RenderShape.MODEL : RenderShape.ENTITYBLOCK_ANIMATED;
	}

	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit){
		if(level.isClientSide || hand == InteractionHand.OFF_HAND) return InteractionResult.PASS;
		if(!player.isCrouching() && type.getFunctions().size() > 0){
			BaseBlockEntity tile = (BaseBlockEntity)level.getBlockEntity(pos);
			for(BlockFunction func : tile.data.getFunctions()){
				if(func.onClick(getWorld(level), getPos(pos), new V3D(0, 0, 0), StateWrapper.of(state), getSide(hit.getDirection()), UniEntity.getEntity(player), hand == InteractionHand.MAIN_HAND)) return InteractionResult.SUCCESS;
			}
		}
		return InteractionResult.PASS;
	}

}
