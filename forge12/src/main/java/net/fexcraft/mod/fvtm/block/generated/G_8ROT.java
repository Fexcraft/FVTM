package net.fexcraft.mod.fvtm.block.generated;

import net.fexcraft.lib.common.Static;
import net.fexcraft.mod.uni.world.AABB;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

import static net.fexcraft.mod.fvtm.block.generated.FvtmProperties.ROTATION8;

public class G_8ROT extends PlainBase {

	public G_8ROT(Block type){
		super(type);
		this.setDefaultState(this.blockState.getBaseState().withProperty(ROTATION8, 0));
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
		return type.getAABB("default", "rotation=" + state.getValue(ROTATION8)).get(0);
	}

	@Override
	public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos){
		return type.getAABB("selection", "rotation=" + state.getValue(ROTATION8)).offset(0, pos.getX(), pos.getY(), pos.getZ()).local();
	}

	@Nullable
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos){
		return type.getAABB("collision", "rotation=" + state.getValue(ROTATION8)).get(0);
	}

	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
		return this.getDefaultState().withProperty(ROTATION8, type.isRandomRot() ? Static.random.nextInt(8) : MathHelper.floor((double)(placer.rotationYaw * 8f / 360f) + 0.5d) & 7);
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
		worldIn.setBlockState(pos, state.withProperty(ROTATION8, type.isRandomRot() ? Static.random.nextInt(8) : MathHelper.floor((double)(placer.rotationYaw * 8f / 360f) + 0.5d) & 7));
	}

	@Override
	public IBlockState getStateFromMeta(int meta){
		return this.getDefaultState().withProperty(ROTATION8, meta);
	}

	@Override
	public int getMetaFromState(IBlockState state){
		return state.getValue(ROTATION8);
	}

	@Override
	protected BlockStateContainer createBlockState(){
		return new BlockStateContainer(this, ROTATION8);
	}

	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state){
		super.breakBlock(world, pos, state);
	}

	@Override
	protected void addCollisionsToList(IBlockState state, World world, BlockPos pos, AxisAlignedBB entitybox, List<AxisAlignedBB> boxes){
		for(AABB aabb : type.getAABB("collision", "rotation=" + state.getValue(ROTATION8)).get()){
			if(entitybox == null) boxes.add(aabb.local());
			else addCollisionBoxToList(pos, entitybox, boxes, aabb.local());
		}
	}

}
