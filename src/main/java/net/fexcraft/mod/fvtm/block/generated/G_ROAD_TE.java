package net.fexcraft.mod.fvtm.block.generated;

import java.util.List;
import java.util.Random;

import net.fexcraft.mod.fvtm.block.Asphalt;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class G_ROAD_TE extends BlockBase {

	public G_ROAD_TE(Block block){ super(block); }
    
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        return Asphalt.BOUNDING_BOXES[state.getValue(Asphalt.HEIGHT)];
    }

    @Override
    public boolean isFullBlock(IBlockState state){
        return state.getValue(Asphalt.HEIGHT) == 0;
    }

    @Override
    public boolean isFullCube(IBlockState state){
        return state.getValue(Asphalt.HEIGHT) == 0;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state){
        return state.getValue(Asphalt.HEIGHT) == 0;
    }
    
	@Override
    public int getLightOpacity(IBlockState state){
    	return state.getValue(Asphalt.HEIGHT) == 0 ? 255 : 0;
    }
    
    @Override
    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this, Asphalt.HEIGHT);
    }

    @Override
    public IBlockState getStateFromMeta(int meta){
        return this.getDefaultState().withProperty(Asphalt.HEIGHT, meta);
    }

    @Override
    public int getMetaFromState(IBlockState state){
        return state.getValue(Asphalt.HEIGHT);
    }
    
    @Override
    public int damageDropped(IBlockState state){
        return state.getValue(Asphalt.HEIGHT);
    }
    
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
    	if(world.isRemote) return player.getHeldItem(hand).getItem() instanceof ItemBlock;
    	ItemStack stack = player.getHeldItem(hand);
    	if(stack.getItem() instanceof ItemBlock && ((ItemBlock)stack.getItem()).getBlock() == this && state.getValue(Asphalt.HEIGHT) > 0){
    		int height = state.getValue(Asphalt.HEIGHT) + stack.getMetadata(); if(height >= 16) height = 0; if(height < 0) height = 0;
    		world.setBlockState(pos, state.withProperty(Asphalt.HEIGHT, height), 2);
    		if(!player.capabilities.isCreativeMode) stack.shrink(1);
    		return true;
    	} else return false;
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player){
        return getItem(world, pos, state);
    }
    
    @Override
    public int quantityDropped(Random random){
        return 1;
    }
    
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune){
        return new ItemStack(this).getItem();
    }
    
    @Override
    public ItemStack getItem(World world, BlockPos pos, IBlockState state){
        return new ItemStack(this, 1, state.getValue(Asphalt.HEIGHT));
    }
    
    @Override
    public boolean isReplaceable(IBlockAccess world, BlockPos pos){
        return false;
    }

	@Override
	protected void addCollisionsToList(IBlockState state, World world, BlockPos pos, AxisAlignedBB entitybox, List<AxisAlignedBB> boxes){
		if(entitybox == null) boxes.add(Asphalt.BOUNDING_BOXES[state.getValue(Asphalt.HEIGHT)]);
		else addCollisionBoxToList(pos, entitybox, boxes, Asphalt.BOUNDING_BOXES[state.getValue(Asphalt.HEIGHT)]);
	}

}