package net.fexcraft.mod.fvtm.blocks;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.util.Tabs;
import net.fexcraft.mod.lib.api.block.fBlock;
import net.fexcraft.mod.lib.util.common.Formatter;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

@fBlock(modid = FVTM.MODID, name = "road_line", item = GenericRoadLine.Item.class, tileentity = RailConnTile.class)
public class GenericRoadLine extends BlockContainer {

	public GenericRoadLine(){
		super(Material.IRON, MapColor.CYAN);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta){
		return new RoadLineTile(world);
	}
	
	public static class Item extends ItemBlock {

		public Item(Block block){
			super(block);
			this.setCreativeTab(Tabs.BLOCKS);
		}
		
	    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flag){
	    	if(!stack.hasTagCompound()) return;
	    	for(int i = 0; i < 4; i ++){
	    		if(stack.getTagCompound().hasKey("fvtm:roadline" + i)){
		        	tooltip.add(Formatter.format("&9POS%s: %s", i, BlockPos.fromLong(stack.getTagCompound().getLong("fvtm:roadline" + i))));
	    		}
	    	}
	    }
		
		@Override
	    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
	        if(world.isRemote){
	        	return EnumActionResult.PASS;
	        }
	        IBlockState state = world.getBlockState(pos); Block block = state.getBlock(); ItemStack stack = player.getHeldItem(hand);
	        if(block instanceof GenericRoadLine){
        		//TODO
	        }
	        else{
		        if(!block.isReplaceable(world, pos)){
		            pos = pos.offset(facing);
		        }
		        if(!stack.isEmpty() && player.canPlayerEdit(pos, facing, stack) && world.mayPlace(this.block, pos, false, facing, (Entity)null)){
		            int i = this.getMetadata(stack.getMetadata());
		            IBlockState nstate = this.block.getStateForPlacement(world, pos, facing, hitX, hitY, hitZ, i, player, hand);
		            if(placeBlockAt(stack, player, world, pos, facing, hitX, hitY, hitZ, nstate)){
		                nstate = world.getBlockState(pos); SoundType soundtype = nstate.getBlock().getSoundType(nstate, world, pos, player);
		                world.playSound(player, pos, soundtype.getPlaceSound(), SoundCategory.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);
		                stack.shrink(1);
		            }
		            return EnumActionResult.SUCCESS;
		        }
	        }
	        return EnumActionResult.FAIL;
	    }
		
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
    public void breakBlock(World world, BlockPos pos, IBlockState state){
        super.breakBlock(world, pos, state);
    }
    
    public static final AxisAlignedBB AABB = new AxisAlignedBB(0D, 0D, 0D, 1D, 0.875D, 1D);

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        return AABB;
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBox(IBlockState blockState, World worldIn, BlockPos pos){
        return AABB.offset(pos);
    }
	
}