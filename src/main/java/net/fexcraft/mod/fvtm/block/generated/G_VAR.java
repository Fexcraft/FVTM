package net.fexcraft.mod.fvtm.block.generated;

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

public class G_VAR extends PlainBase {

	public G_VAR(Block type){
		super(type);
		this.setDefaultState(this.blockState.getBaseState().withProperty(type.getBlockType().getIntProperty(), 0));
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
		return type.getAABB("default", "variant=" + state.getValue(type.getBlockType().getIntProperty()))[0];
	}

	@Override
	public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos){
		return type.getAABB("selection", "variant=" + state.getValue(type.getBlockType().getIntProperty()))[0].offset(pos);
	}

	@Nullable
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos){
		return type.getAABB("collision", "variant=" + state.getValue(type.getBlockType().getIntProperty()))[0];
	}

    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
        return this.getDefaultState().withProperty(type.getBlockType().getIntProperty(), type.getRandomRot() ? Static.random.nextInt(16) : meta);
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
        worldIn.setBlockState(pos, state.withProperty(type.getBlockType().getIntProperty(), type.getRandomRot() ? Static.random.nextInt(16) : stack.getMetadata()), 2);
    }

	@Override
	public IBlockState getStateFromMeta(int meta){
		return this.getDefaultState().withProperty(type.getBlockType().getIntProperty(), meta);
	}

	@Override
	public int getMetaFromState(IBlockState state){
		return state.getValue(type.getBlockType().getIntProperty());
	}

	@Override
	protected BlockStateContainer createBlockState(){
		return new BlockStateContainer(this, new IProperty[]{ type.getBlockType().getIntProperty() });
	}

	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state){
		super.breakBlock(world, pos, state);
	}

	@Override
	protected void addCollisionsToList(IBlockState state, World world, BlockPos pos, AxisAlignedBB entitybox, List<AxisAlignedBB> boxes){
		for(AxisAlignedBB aabb : type.getAABB("collision", "variant=" + state.getValue(type.getBlockType().getIntProperty()))){
			if(entitybox == null) boxes.add(aabb);
			else addCollisionBoxToList(pos, entitybox, boxes, aabb);
		}
	}

}
