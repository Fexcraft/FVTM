package net.fexcraft.mod.fvtm.block.generated;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.lib.common.Static;
import net.fexcraft.mod.fvtm.data.block.AABB;
import net.fexcraft.mod.fvtm.data.block.AABBs;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.util.Properties;
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

public abstract class G_VAR extends PlainBase {

	public G_VAR(Block type){
		super(type);
		this.setDefaultState(this.blockState.getBaseState().withProperty(var_property(), 0));
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
		return type.getAABB("default", "variant=" + state.getValue(var_property())).get(0);
	}

	@Override
	public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos){
		return type.getAABB("selection", "variant=" + state.getValue(var_property())).offset(0, pos.getX(), pos.getY(), pos.getZ()).local();
	}

	@Nullable
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos){
		return type.getAABB("collision", "variant=" + state.getValue(var_property())).get(0);
	}

    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
        return this.getDefaultState().withProperty(var_property(), type.isRandomRot() ? Static.random.nextInt(16) : meta);
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
        worldIn.setBlockState(pos, state.withProperty(var_property(), type.isRandomRot() ? Static.random.nextInt(16) : stack.getMetadata()), 2);
    }

	@Override
	public IBlockState getStateFromMeta(int meta){
		return this.getDefaultState().withProperty(var_property(), meta);
	}

	@Override
	public int getMetaFromState(IBlockState state){
		return state.getValue(var_property());
	}

	@Override
	protected BlockStateContainer createBlockState(){
		return new BlockStateContainer(this, var_property());
	}

	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state){
		super.breakBlock(world, pos, state);
	}

	@Override
	protected void addCollisionsToList(IBlockState state, World world, BlockPos pos, AxisAlignedBB entitybox, List<AxisAlignedBB> boxes){
		for(AABB aabb : type.getAABB("collision", "variant=" + state.getValue(var_property())).get()){
			if(entitybox == null) boxes.add(aabb.local());
			else addCollisionBoxToList(pos, entitybox, boxes, aabb.local());
		}
	}

	public abstract IProperty<Integer> var_property();
	
	public static class T2 extends G_VAR {

		public T2(Block type){ super(type); }

		@Override
		public IProperty<Integer> var_property(){
			return Properties.VARIANTS2;
		}
		
	}
	
	public static class T3 extends G_VAR {

		public T3(Block type){ super(type); }

		@Override
		public IProperty<Integer> var_property(){
			return Properties.VARIANTS3;
		}
		
	}
	
	public static class T4 extends G_VAR {

		public T4(Block type){ super(type); }

		@Override
		public IProperty<Integer> var_property(){
			return Properties.VARIANTS4;
		}
		
	}
	
	public static class T5 extends G_VAR {

		public T5(Block type){ super(type); }

		@Override
		public IProperty<Integer> var_property(){
			return Properties.VARIANTS5;
		}
		
	}
	
	public static class T6 extends G_VAR {

		public T6(Block type){ super(type); }

		@Override
		public IProperty<Integer> var_property(){
			return Properties.VARIANTS6;
		}
		
	}
	
	public static class T7 extends G_VAR {

		public T7(Block type){ super(type); }

		@Override
		public IProperty<Integer> var_property(){
			return Properties.VARIANTS7;
		}
		
	}
	
	public static class T8 extends G_VAR {

		public T8(Block type){ super(type); }

		@Override
		public IProperty<Integer> var_property(){
			return Properties.VARIANTS8;
		}
		
	}
	
	public static class T9 extends G_VAR {

		public T9(Block type){ super(type); }

		@Override
		public IProperty<Integer> var_property(){
			return Properties.VARIANTS9;
		}
		
	}
	
	public static class T10 extends G_VAR {

		public T10(Block type){ super(type); }

		@Override
		public IProperty<Integer> var_property(){
			return Properties.VARIANTS10;
		}
		
	}
	
	public static class T11 extends G_VAR {

		public T11(Block type){ super(type); }

		@Override
		public IProperty<Integer> var_property(){
			return Properties.VARIANTS11;
		}
		
	}
	
	public static class T12 extends G_VAR {

		public T12(Block type){ super(type); }

		@Override
		public IProperty<Integer> var_property(){
			return Properties.VARIANTS12;
		}
		
	}
	
	public static class T13 extends G_VAR {

		public T13(Block type){ super(type); }

		@Override
		public IProperty<Integer> var_property(){
			return Properties.VARIANTS13;
		}
		
	}
	
	public static class T14 extends G_VAR {

		public T14(Block type){ super(type); }

		@Override
		public IProperty<Integer> var_property(){
			return Properties.VARIANTS14;
		}
		
	}
	
	public static class T15 extends G_VAR {

		public T15(Block type){ super(type); }

		@Override
		public IProperty<Integer> var_property(){
			return Properties.VARIANTS15;
		}
		
	}
	
	public static class T16 extends G_VAR {

		public T16(Block type){ super(type); }

		@Override
		public IProperty<Integer> var_property(){
			return Properties.VARIANTS16;
		}
		
	}

}
