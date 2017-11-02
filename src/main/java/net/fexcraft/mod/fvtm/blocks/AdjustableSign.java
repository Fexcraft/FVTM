package net.fexcraft.mod.fvtm.blocks;

import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.util.Tabs;
import net.fexcraft.mod.lib.api.block.fBlock;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

@fBlock(modid = FVTM.MODID, name = "adj_sign", tileentity = AdjustableSignEntity.class)
public class AdjustableSign extends BlockContainer {
	
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

	public AdjustableSign(){
		super(Material.IRON, MapColor.SNOW);
		//
    	this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
		this.setCreativeTab(Tabs.BLOCKS);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta){
		return new AdjustableSignEntity();
	}
	
	@Override
	public boolean isFullBlock(IBlockState state){
		return false;
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
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        return get((EnumFacing)state.getValue(FACING));
    }

	@Override
    public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos){
        return get((EnumFacing)state.getValue(FACING));
    }
	
	public static final AxisAlignedBB SOUTH = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.05);
	public static final AxisAlignedBB NORTH = new AxisAlignedBB(0.0D, 0.0D, 0.95, 1.0D, 1.0D, 1.0D);
	public static final AxisAlignedBB WEST  = new AxisAlignedBB(0.95, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
	public static final AxisAlignedBB EAST  = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.05, 1.0D, 1.0D);
    
    public static final AxisAlignedBB get(EnumFacing facing){
    	switch(facing){
    		case SOUTH: return SOUTH;
    		case NORTH: return NORTH;
    		case WEST: return WEST;
    		case EAST: default: return EAST;
    	}
    }
	
	@Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

	@Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
        worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
    }
    
	@Override
    public IBlockState getStateFromMeta(int meta){
        EnumFacing enumfacing = EnumFacing.getFront(meta);
        if (enumfacing.getAxis() == EnumFacing.Axis.Y){
            enumfacing = EnumFacing.NORTH;
        }
        return this.getDefaultState().withProperty(FACING, enumfacing);
    }
	
	@Override
    public int getMetaFromState(IBlockState state){
        return ((EnumFacing)state.getValue(FACING)).getIndex();
    }
	
	@Override
    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this, new IProperty[] {FACING});
    }
	
}