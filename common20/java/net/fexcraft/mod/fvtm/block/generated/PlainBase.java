package net.fexcraft.mod.fvtm.block.generated;

import net.fexcraft.mod.fvtm.data.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;

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
		prop.lightLevel(state -> (int)(type.getLightLevel() * 16));
		prop.explosionResistance(type.getResistance());
		if(!type.isFullBlock() || type.isCutout() || type.isOpaque()) prop.noOcclusion();
		return prop;
	}

	@Override
	public RenderShape getRenderShape(BlockState state){
		return type.isInvisible() ? RenderShape.INVISIBLE : RenderShape.MODEL;
	}

}
