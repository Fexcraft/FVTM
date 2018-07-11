package net.fexcraft.mod.fvtm.blocks;

import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.entities.RailLink;
import net.fexcraft.mod.fvtm.util.Tabs;
import net.fexcraft.mod.lib.api.block.fBlock;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@fBlock(modid = FVTM.MODID, name = "rail", item = RailConnection.Item.class, tileentity = RailConnTile.class)
public class RailConnection extends BlockContainer {

	public RailConnection(){
		super(Material.IRON, MapColor.CYAN);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta){
		return new RailConnTile();
	}
	
	public static class Item extends ItemBlock {

		public Item(Block block){
			super(block);
			this.setCreativeTab(Tabs.BLOCKS);
		}
		
		@Override
	    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
	        if(world.isRemote){
	        	return EnumActionResult.PASS;
	        }
	        IBlockState state = world.getBlockState(pos); Block block = state.getBlock(); ItemStack stack = player.getHeldItem(hand);
	        if(block instanceof RailConnection){
	        	if(stack.getTagCompound() == null){
	        		stack.setTagCompound(new NBTTagCompound());
	        	}
	        	if(stack.getTagCompound().hasKey("fvtm:railconn")){
	        		BlockPos pos0 = BlockPos.fromLong(stack.getTagCompound().getLong("fvtm:railconn"));
	        		stack.getTagCompound().removeTag("fvtm:railconn");
	        		//Print.chat(player, "&7&oTrying to connect rails...");
	        		RailConnTile tile0 = (RailConnTile)world.getTileEntity(pos0);
	        		//RailConnTile tile = (RailConnTile)world.getTileEntity(pos);
	        		if(tile0 == null){
	        			Print.chat(player, "&cTileEntity at first connection point is NULL.");
	        	        return EnumActionResult.FAIL;
	        		}
	        		/*if(tile == null){
	        			Print.chat(player, "&cTileEntity at second connection point is NULL.");
	        	        return EnumActionResult.FAIL;
	        		}*/
	        		RailLink link = new RailLink(pos0, pos);
	        		tile0.addLink(link);
	        		//tile.addLink(link);
	        		Print.bar(player, "&7Connected&9!");
	        	}
	        	else{
	        		stack.getTagCompound().setLong("fvtm:railconn", pos.toLong());
	        		Print.bar(player, "&7&oFirst position cached (into itemstack).");
	        	}
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
	
}