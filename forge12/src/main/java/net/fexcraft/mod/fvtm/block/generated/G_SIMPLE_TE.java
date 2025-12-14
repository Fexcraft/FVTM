package net.fexcraft.mod.fvtm.block.generated;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.mod.uni.world.AABB;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class G_SIMPLE_TE extends BlockBase {

    public G_SIMPLE_TE(Block type){
        super(type); this.setDefaultState(this.blockState.getBaseState().withProperty(FvtmProperties.getIntProperty(type.getBlockType()), 0));
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        return type.getAABB("default", "").get(0);
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos){
        return type.getAABB("selection", "").offset(0, pos.getX(), pos.getY(), pos.getZ()).local();
    }
    
    @Nullable @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos){
        return type.getAABB("collision", "").get(0);
    }

    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
        return this.getDefaultState();
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
        super.onBlockPlacedBy(world, pos, state, placer, stack);
        world.setBlockState(pos, state, 2);
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
        return new BlockStateContainer(this, new IProperty[0]);
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state){
        super.breakBlock(world, pos, state);
    }

	@Override
	protected void addCollisionsToList(IBlockState state, World world, BlockPos pos, AxisAlignedBB entitybox, List<AxisAlignedBB> boxes){
		for(AABB aabb : type.getAABB("collision", "").get()){
			if(entitybox == null) boxes.add(aabb.local());
			else addCollisionBoxToList(pos, entitybox, boxes, aabb.local());
		}
	}

}

