package net.fexcraft.mod.fvtm.block.generated;

import static net.fexcraft.mod.fvtm.util.Properties.FACING;
import static net.fexcraft.mod.fvtm.util.Properties.VARIANTS4;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.lib.common.Static;
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

public class G_4x4ROT_TE extends BlockBase {

    public G_4x4ROT_TE(Block type){
        super(type); this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(VARIANTS4, 0));
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        return type.getAABB("default", "variant=" + state.getValue(VARIANTS4) + ",facing=" + state.getValue(FACING).getName())[0];
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos){
        return type.getAABB("selection", "variant=" + state.getValue(VARIANTS4) + ",facing=" + state.getValue(FACING).getName())[0].offset(pos);
    }
    
    @Nullable @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos){
        return type.getAABB("collision", "variant=" + state.getValue(VARIANTS4) + ",facing=" + state.getValue(FACING).getName())[0];
    }

    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
        return this.getDefaultState().withProperty(VARIANTS4, meta).withProperty(FACING, type.getRandomRot() ? EnumFacing.HORIZONTALS[Static.random.nextInt(4)] : placer.getHorizontalFacing().getOpposite());
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
        worldIn.setBlockState(pos, state.withProperty(VARIANTS4, stack.getMetadata()).withProperty(FACING, type.getRandomRot() ? EnumFacing.HORIZONTALS[Static.random.nextInt(4)] : placer.getHorizontalFacing().getOpposite()), 2);
    }

    @Override
    public IBlockState getStateFromMeta(int meta){
    	int var = meta / 4;
    	meta %= 4;
        EnumFacing facing = EnumFacing.byIndex(meta + 2);
        facing = facing.getAxis() == EnumFacing.Axis.Y ? EnumFacing.NORTH : facing;
        return this.getDefaultState().withProperty(FACING, facing).withProperty(VARIANTS4, var);
    }

    @Override
    public int getMetaFromState(IBlockState state){
        return (state.getValue(VARIANTS4) * 4) + (((EnumFacing)state.getValue(FACING)).getIndex() - 2);
    }

    @Override
    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this, new IProperty[]{ VARIANTS4, FACING });
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state){
        super.breakBlock(world, pos, state);
    }

	@Override
	protected void addCollisionsToList(IBlockState state, World world, BlockPos pos, AxisAlignedBB entitybox, List<AxisAlignedBB> boxes){
		for(AxisAlignedBB aabb : type.getAABB("collision", "variant=" + state.getValue(VARIANTS4) + ",facing=" + state.getValue(FACING).getName())){
			if(entitybox == null) boxes.add(aabb);
			else addCollisionBoxToList(pos, entitybox, boxes, aabb);
		}
	}

}

