package net.fexcraft.mod.fvtm.block.generated;

import net.fexcraft.mod.fvtm.data.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Generic16RotBlock extends BlockBase {

    public static final PropertyInteger ROTATION = PropertyInteger.create("rotation", 0, 15);

    public Generic16RotBlock(Block type){
        super(type); this.setDefaultState(this.blockState.getBaseState().withProperty(ROTATION, 0));
    }

    @Override
    public boolean isFullBlock(IBlockState state){ return true; }

    @Override
    public boolean isFullCube(IBlockState state){ return true; }

    @Override
    public boolean isOpaqueCube(IBlockState state){ return false; }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        return type.getAABB("rotation=" + state.getValue(ROTATION));
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos){
        return type.getAABB("rotation=" + state.getValue(ROTATION)).offset(pos);
    }

    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
        return this.getDefaultState().withProperty(ROTATION, MathHelper.floor((double)((placer.rotationYaw + 180.0F) * 16.0F / 360.0F) + 0.5D) & 15);
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
        worldIn.setBlockState(pos, state.withProperty(ROTATION, MathHelper.floor((double)((placer.rotationYaw + 180.0F) * 16.0F / 360.0F) + 0.5D) & 15), 2);
    }

    @Override
    public IBlockState getStateFromMeta(int meta){
        return this.getDefaultState().withProperty(ROTATION, meta);
    }

    @Override
    public int getMetaFromState(IBlockState state){
        return state.getValue(ROTATION);
    }

    @Override
    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this, new IProperty[]{ ROTATION });
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state){
        super.breakBlock(world, pos, state);
    }
    
    @Override
    public EnumBlockRenderType getRenderType(IBlockState state){
        return type.hasPlainModel() ? EnumBlockRenderType.MODEL : EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
    }

}

