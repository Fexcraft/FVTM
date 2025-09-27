package net.fexcraft.mod.fvtm.block.generated;

import net.fexcraft.mod.fvtm.data.block.AABB;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

import static net.fexcraft.mod.fvtm.block.generated.FvtmProperties.LAYER8;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class G_8LAY extends PlainBase {

    public G_8LAY(Block type){
        super(type); this.setDefaultState(this.blockState.getBaseState().withProperty(LAYER8, 0));
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        return type.getAABB("default", "layer=" + state.getValue(LAYER8)).get(0);
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos){
        return type.getAABB("selection", "layer=" + state.getValue(LAYER8)).offset(0, pos.getX(), pos.getY(), pos.getZ()).local();
    }
    
    @Nullable @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos){
        return type.getAABB("collision", "layer=" + state.getValue(LAYER8)).get(0);
    }

    @Override
    public IBlockState getStateFromMeta(int meta){
        return this.getDefaultState().withProperty(LAYER8, meta);
    }

    @Override
    public int getMetaFromState(IBlockState state){
        return state.getValue(LAYER8);
    }

    @Override
    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this, LAYER8);
    }

	@Override
	protected void addCollisionsToList(IBlockState state, World world, BlockPos pos, AxisAlignedBB entitybox, List<AxisAlignedBB> boxes){
		for(AABB aabb : type.getAABB("collision", "layer=" + state.getValue(LAYER8)).get()){
			if(entitybox == null) boxes.add(aabb.local());
			else addCollisionBoxToList(pos, entitybox, boxes, aabb.local());
		}
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		if(super.onBlockActivated(world, pos, state, player, hand, facing, hitX, hitY, hitZ)) return true;
		if(world.isRemote) return player.getHeldItem(hand).getItem() instanceof ItemBlock;
		ItemStack stack = player.getHeldItem(hand);
		if(stack.getItem() instanceof ItemBlock && ((ItemBlock)stack.getItem()).getBlock() == this && state.getValue(LAYER8) > 0){
			int height = state.getValue(LAYER8) + stack.getMetadata();
			if(height >= 8) height = 0;
			if(height < 0) height = 0;
			world.setBlockState(pos, state.withProperty(LAYER8, height), 2);
			if(!player.capabilities.isCreativeMode) stack.shrink(1);
			return true;
		}
		int lvl = Math.max(stack.getItem().getHarvestLevel(stack, "shovel", player, state), stack.getItem().getHarvestLevel(stack, "pickaxe", player, state));
		if(lvl > 0){
			int height = state.getValue(LAYER8);
			if(height == 0) height = 7;
			else if(height == 1) return false;
			else height--;
			world.setBlockState(pos, state.withProperty(LAYER8, height), 2);
			if(!player.capabilities.isCreativeMode) stack.damageItem(1, player);
			player.addItemStackToInventory(new ItemStack(state.getBlock(), 1, 1));
			return true;
		}
		return false;
	}

}

