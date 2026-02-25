package net.fexcraft.mod.fvtm.block.generated;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.data.block.BlockFunction;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.world.StateWrapper;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import static net.fexcraft.mod.uni.world.WrapperHolder.*;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class PlainBase extends net.minecraft.world.level.block.Block {

	public Block type;

	public PlainBase(Block type){
		super(getProps(type));
		this.type = type;
	}

	private static Properties getProps(Block type){
		Properties prop = Properties.of();
		prop.destroyTime(type.getHardness());
		prop.lightLevel(state -> type.getLightLevel());
		prop.explosionResistance(type.getResistance());
		if(!type.getBlockType().isGenericRoad()){
			if(!type.isFullBlock() || type.isCutout() || !type.isOpaque()) prop.noOcclusion();
		}
		if(type.getBlockType().isRoadLayer()) prop.noCollission();
		if(type.getBlockType().isJackStand()) prop.noOcclusion();
		return prop;
	}

	@Override
	public RenderShape getRenderShape(BlockState state){
		return type.isInvisible() ? RenderShape.INVISIBLE : RenderShape.MODEL;
	}

	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit){
		if(level.isClientSide || hand == InteractionHand.OFF_HAND) return InteractionResult.PASS;
		if(!player.isCrouching() && type.getFunctions().size() > 0){
			for(BlockFunction func : type.getFunctions()){
				if(func.onClick(getWorld(level), getPos(pos), new V3D(0, 0, 0), StateWrapper.of(state), getSide(hit.getDirection()), UniEntity.getEntity(player), hand == InteractionHand.MAIN_HAND)) return InteractionResult.SUCCESS;
			}
		}
		return InteractionResult.PASS;
	}

}
