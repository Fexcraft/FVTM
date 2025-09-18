package net.fexcraft.mod.fvtm.block.generated;

import net.fexcraft.mod.fvtm.data.block.Block;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

import static net.fexcraft.mod.fvtm.block.generated.FvtmProperties.HEIGHT;
import static net.fexcraft.mod.fvtm.block.generated.FvtmProperties.LOWER_AABBS;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class G_ROAD_MARKER extends PlainBase {

	public G_ROAD_MARKER(Block type){
		super(type);
		this.setDefaultState(this.blockState.getBaseState());
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
		return LOWER_AABBS[state.getValue(HEIGHT)];
	}

	@Override
	public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos){
		return LOWER_AABBS[state.getValue(HEIGHT)].offset(pos.getX(), pos.getY(), pos.getZ());
	}

	@Nullable
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos){
		return NULL_AABB;
	}

    @Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
        return getDefaultState().withProperty(HEIGHT, getMarkerHeight(world, pos));
    }

	public static int getMarkerHeight(IBlockAccess level, BlockPos pos){
		IBlockState state = level.getBlockState(pos.down());
		AxisAlignedBB shape = state.getBoundingBox(level, pos.down());
		int val = shape == null ? 0 : (int)((shape.maxY - 1) * -16);
		if(val >= 16 || val < 0) val = 0;
		return val;
	}

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
        world.setBlockState(pos, state.withProperty(HEIGHT, getMarkerHeight(world, pos)), 2);
    }

	@Override
	public IBlockState getStateFromMeta(int meta){
		return this.getDefaultState();
	}

	@Override
	public int getMetaFromState(IBlockState state){
		return 0;
	}

	@Override
	protected BlockStateContainer createBlockState(){
		return new BlockStateContainer(this, HEIGHT);
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos){
		return getDefaultState().withProperty(HEIGHT, getMarkerHeight(world, pos));
	}

	@Override
	protected void addCollisionsToList(IBlockState state, World world, BlockPos pos, AxisAlignedBB entitybox, List<AxisAlignedBB> boxes){
		//
	}

	@Override
	public boolean isPassable(IBlockAccess world, BlockPos pos){
		return true;
	}

	@Override
	public BlockRenderLayer getRenderLayer(){
		return BlockRenderLayer.CUTOUT;
	}

}
