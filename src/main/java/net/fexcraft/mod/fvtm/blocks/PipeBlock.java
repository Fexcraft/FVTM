package net.fexcraft.mod.fvtm.blocks;

import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.util.Tabs;
import net.fexcraft.mod.lib.api.block.fBlock;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

@fBlock(modid = FVTM.MODID, name = "pipe", tileentity = PipeTileEntity.class)
public class PipeBlock extends BlockContainer {

	public PipeBlock(){
		super(Material.IRON, MapColor.WHITE_STAINED_HARDENED_CLAY);
		this.setCreativeTab(Tabs.BLOCKS);
		this.setSoundType(SoundType.GLASS);
		//
        this.setHarvestLevel("pickaxe", 0);
        this.setHardness(10.0F);
        this.setResistance(20.0F);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta){
		return new PipeTileEntity();
	}
	
    @Override
	public boolean isFullBlock(IBlockState state){
		return true;
	}
	
	@Override
	public boolean isFullCube(IBlockState state){
        return false;
    }
	
	@Override
	public boolean isOpaqueCube(IBlockState state){
        return false;
    }
	
	@Override
    public void onNeighborChange(IBlockAccess world, BlockPos pos, BlockPos change){
		((PipeTileEntity)world.getTileEntity(pos)).removeConnection(pos, change);
    }
	
	@Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state){
		if(world.isRemote){ return; }
		for(EnumFacing facing : EnumFacing.VALUES){
			((PipeTileEntity)world.getTileEntity(pos)).updateConnections(world, pos, facing, false);
		}
    }

}
