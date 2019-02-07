package net.fexcraft.mod.fvtm.blocks.rail;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.lib.mc.registry.ItemBlock16;
import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.FVTM.InternalAddon;
import net.fexcraft.mod.fvtm.sys.rail.cap.WorldRailData;
import net.fexcraft.mod.fvtm.sys.rail.cap.WorldRailDataSerializer;
import net.fexcraft.mod.fvtm.util.Resources;
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

public class JunctionItemBlock extends ItemBlock16 {
	
	public static JunctionItemBlock INSTANCE;

	public JunctionItemBlock(Block block){
		super(block); INSTANCE = this;
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
        if(world.isRemote){ return EnumActionResult.PASS; }
        WorldRailData worldcap = world.getCapability(WorldRailDataSerializer.CAPABILITY, null);
        if(worldcap == null){
			Print.chat(player, "&cWorld Capability not found.");
	        return EnumActionResult.FAIL;
        }
        IBlockState state = world.getBlockState(pos); Block block = state.getBlock(); ItemStack stack = player.getHeldItem(hand);
        if(block instanceof JunctionBlock){
    		if(player.isSneaking()){
    			worldcap.delJunction(pos); Print.chat(player, "&cResetting...");
    			return EnumActionResult.SUCCESS;
    		}
    		if(stack.getTagCompound() == null) stack.setTagCompound(new NBTTagCompound());
        	if(stack.getTagCompound().hasKey("fvtm:railtrackstart")){
        		BlockPos pos0 = BlockPos.fromLong(stack.getTagCompound().getLong("fvtm:railtrackstart"));
        		IBlockState state0 = world.getBlockState(pos0);
        		if(state0 == null){ Print.chat(player, "&cRailConnector at first connection point is NULL."); return EnumActionResult.FAIL; }
        		//if(tte == null){ Print.chat(player, "&cTileEntity at second connection point is NULL."); return EnumActionResult.FAIL; }
        		if(stack.getTagCompound().getInteger("fvtm:railtrackpoints") == 1){
        			Print.chat(player, "&cAt least 2 subpoints are needed."); return EnumActionResult.FAIL;
        		}
        		BlockPos[] arr = new BlockPos[stack.getTagCompound().getInteger("fvtm:railtrackpoints")];
        		for(int j = 0; j < arr.length; j++){
        			arr[j] = BlockPos.fromLong(stack.getTagCompound().getLong("fvtm:railtrackpoint" + j));
        		}
        		//worldcap.addConnection(new Connection(Resources.GAUGES.getValue(InternalAddon.STANDARD_GAUGE), pos0, pos, false, arr));
        		worldcap.addJunction(Resources.GAUGES.getValue(InternalAddon.STANDARD_GAUGE), pos0, pos, arr);
        		Print.bar(player, "&7Connected&9!");
        		//
        		stack.getTagCompound().removeTag("fvtm:railtrackstart");
        		stack.getTagCompound().removeTag("fvtm:railtrackpoints");
        		for(int k = 0; k < arr.length; k++) stack.getTagCompound().removeTag("fvtm:railtrackpoint" + k);
	            return EnumActionResult.SUCCESS;
        	}
        	else{
        		int check = worldcap.getJunction(pos).tracks.size();
        		if(check >= 4){
        			Print.chat(player, "&cTileEntity reached max allowed connections. (#" + check + ";)");
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