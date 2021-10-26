package net.fexcraft.mod.fvtm.block.generated;

import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.item.BlockItem;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PlainBase extends net.minecraft.block.Block {

	public final Block type;
	
	public PlainBase(Block type){
		super(type.getMaterial(), type.getMapColor()); this.type = type;
		type.getAddon().getFCLRegisterer().addBlock(
			type.getRegistryName().getPath(), this, BlockItem.class, type.getBlockType().isGenericRoad() ? 16 : 0, null);
		this.setHardness(type.getHardness());
		this.setLightLevel(type.getLightLevel());
		this.setResistance(type.getResistance());
		this.setLightOpacity(type.getLightOpacity());
		this.setHarvestLevel(type.getHarverestToolClass(), type.getHarverestToolLevel());
	}
	
    @Override
    public boolean isFullBlock(IBlockState state){ return type.isFullBlock(); }

    @Override
    public boolean isFullCube(IBlockState state){ return type.isFullCube(); }

    @Override
    public boolean isOpaqueCube(IBlockState state){ return type == null ? false : type.isOpaque(); }
	
	@Override
    public void onEntityCollision(World world, BlockPos pos, IBlockState state, Entity entity){
		if(type.getCollisionDamage() > 0) entity.attackEntityFrom(DamageSource.CACTUS, type.getCollisionDamage());
		if(type.isWebLike()) entity.setInWeb(); return;
    }
    
    @Override
    public BlockRenderLayer getRenderLayer(){
        return type.isCutout() ? BlockRenderLayer.CUTOUT : BlockRenderLayer.SOLID;
    }
    
    @Override
    public EnumBlockRenderType getRenderType(IBlockState state){
        return type.isInvisible() ? EnumBlockRenderType.INVISIBLE : EnumBlockRenderType.MODEL;
    }

}
