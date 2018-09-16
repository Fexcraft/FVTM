package net.fexcraft.mod.fvtm.blocks.rail;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.mod.lib.util.common.Formatter;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.registry.ItemBlock16;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TrackItemBlock extends ItemBlock16 {

	public TrackItemBlock(Block block){
		super(block);
	}
	
	@Override
    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flag){
        if(stack.getTagCompound() != null && stack.getTagCompound().hasKey("fvtm:railtrackstart")){
        	tooltip.add(Formatter.format("&9STR BLK: " + BlockPos.fromLong(stack.getTagCompound().getLong("fvtm:railtrackstart"))));
        	if(stack.getTagCompound().hasKey("fvtm:railtrackpoints")){
        		int i = stack.getTagCompound().getInteger("fvtm:railtrackpoints");
        		for(int k = 0; k < i; k++){
                	tooltip.add(Formatter.format("&9PT" + k + " BLK: " + BlockPos.fromLong(stack.getTagCompound().getLong("fvtm:railtrackpoint" + k))));
        		}
        	}
        }
        else{
        	tooltip.add("No data.");
        }
    }
	
	@Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
        if(world.isRemote){
        	return EnumActionResult.PASS;
        }
        IBlockState state = world.getBlockState(pos); Block block = state.getBlock(); ItemStack stack = player.getHeldItem(hand);
        if(block instanceof TrackBlock){
    		TrackTileEntity tte = (TrackTileEntity)world.getTileEntity(pos);
    		if(tte != null && player.isSneaking()){
    			tte.reset(); Print.chat(player, "&cResetting...");
    			return EnumActionResult.SUCCESS;
    		}
    		if(stack.getTagCompound() == null) stack.setTagCompound(new NBTTagCompound());
        	if(stack.getTagCompound().hasKey("fvtm:railtrackstart")){
        		BlockPos pos0 = BlockPos.fromLong(stack.getTagCompound().getLong("fvtm:railtrackstart"));
        		TrackTileEntity tile0 = (TrackTileEntity)world.getTileEntity(pos0);
        		if(tile0 == null){ Print.chat(player, "&cTileEntity at first connection point is NULL."); return EnumActionResult.FAIL; }
        		if(tte == null){ Print.chat(player, "&cTileEntity at second connection point is NULL."); return EnumActionResult.FAIL; }
        		BlockPos[] arr = new BlockPos[stack.getTagCompound().getInteger("fvtm:railtrackpoints")];
        		for(int j = 0; j < arr.length; j++){
        			arr[j] = BlockPos.fromLong(stack.getTagCompound().getLong("fvtm:railtrackpoint" + j));
        		}
        		tile0.addConnection(new Connection(pos0, pos, false, arr));
        		Print.bar(player, "&7Connected&9!");
        		//
        		stack.getTagCompound().removeTag("fvtm:railtrackstart");
        		stack.getTagCompound().removeTag("fvtm:railtrackpoints");
        		for(int k = 0; k < arr.length; k++) stack.getTagCompound().removeTag("fvtm:railtrackpoint" + k);
	            return EnumActionResult.SUCCESS;
        	}
        	else{
        		if(tte != null && tte.connections.length >= 4){
        			Print.chat(player, "&cTileEntity reached max allowed connections. (#" + tte.connections.length + ";)");
        	        return EnumActionResult.FAIL;
        		}
        		stack.getTagCompound().setLong("fvtm:railtrackstart", pos.toLong());
        		stack.getTagCompound().setByte("fvtm:railtrackpoints", (byte)0);
        		Print.bar(player, "&7&oFirst position cached (into itemstack).");
	            return EnumActionResult.SUCCESS;
        	}
        }
        else{
	        if(!block.isReplaceable(world, pos)){
	            pos = pos.offset(facing);
	        }
        	if(player.isSneaking()){
        		if(stack.getTagCompound() == null) stack.setTagCompound(new NBTTagCompound());
        		int i = stack.getTagCompound().hasKey("fvtm:railtrackpoints") ? stack.getTagCompound().getInteger("fvtm:railtrackpoints") : 0;
        		if(i >= 127){
        			Print.bar(player, "Subpoint limit reached."); return EnumActionResult.FAIL;
        		}
        		stack.getTagCompound().setLong("fvtm:railtrackpoint" + i, pos.toLong());
        		stack.getTagCompound().setByte("fvtm:railtrackpoints", (byte)++i);
        		Print.bar(player, "&o&2" + i + " &7subposition cached (into itemstack).");
        		Print.debug(stack.getTagCompound());
	            return EnumActionResult.SUCCESS;
        	}
        	else{
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
        }
        return EnumActionResult.FAIL;
    }
	
}