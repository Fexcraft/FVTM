package net.fexcraft.mod.fvtm.block.generated;

import net.fexcraft.lib.common.Static;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import static net.fexcraft.mod.fvtm.block.generated.FvtmProperties.*;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class G_ROAD_MARKER4 extends G_ROAD_MARKER {

	public G_ROAD_MARKER4(Block type){
		super(type);
		this.setDefaultState(this.blockState.getBaseState());
	}

    @Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
		EnumFacing rot = EnumFacing.NORTH;
		if(type.isRandomRot()) rot = EnumFacing.values()[Static.random.nextInt(4) + 2];
		else if(placer != null) rot = placer.getHorizontalFacing().getOpposite();
		return getDefaultState().withProperty(HEIGHT, getMarkerHeight(world, pos)).withProperty(FACING, rot);
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
        world.setBlockState(pos, getStateForPlacement(world, pos, null, 0, 0, 0, stack.getMetadata(), placer), 2);
    }

	@Override
	public IBlockState getStateFromMeta(int meta){
		EnumFacing facing = EnumFacing.byIndex(meta);
		facing = facing.getAxis() == EnumFacing.Axis.Y ? EnumFacing.NORTH : facing;
		return this.getDefaultState().withProperty(FACING, facing);
	}

	@Override
	public int getMetaFromState(IBlockState state){
		return state.getValue(FACING).getIndex();
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos){
		return getDefaultState().withProperty(HEIGHT, getMarkerHeight(world, pos));
	}

	@Override
	protected BlockStateContainer createBlockState(){
		return new BlockStateContainer(this, FACING, HEIGHT);
	}

}
