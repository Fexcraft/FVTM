package net.fexcraft.mod.fvtm.impl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Nullable;

import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.api.Addon;
import net.fexcraft.mod.fvtm.api.Gauge;
import net.fexcraft.mod.fvtm.api.Gauge.GaugeItem;
import net.fexcraft.mod.fvtm.blocks.rail.Connection;
import net.fexcraft.mod.fvtm.blocks.rail.TrackBlock;
import net.fexcraft.mod.fvtm.blocks.rail.TrackItemBlock;
import net.fexcraft.mod.fvtm.prototype.WorldRailData;
import net.fexcraft.mod.fvtm.prototype.WorldRailDataSerializer;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GenericRailGaugeItem extends Item implements GaugeItem {

    public static final GenericRailGaugeItem INSTANCE = new GenericRailGaugeItem();

    public GenericRailGaugeItem(){
        this.setHasSubtypes(true);
        this.setMaxStackSize(64);
        this.setRegistryName("fvtm:railgauge");
        this.setUnlocalizedName(this.getRegistryName().toString());
    }

    @SideOnly(Side.CLIENT)
    public static class ItemMeshDef implements net.minecraft.client.renderer.ItemMeshDefinition {

        @Override
        public final net.minecraft.client.renderer.block.model.ModelResourceLocation getModelLocation(ItemStack stack){
            if(stack.hasTagCompound() && stack.getTagCompound().hasKey(NBTKEY)){
                return new net.minecraft.client.renderer.block.model.ModelResourceLocation(new ResourceLocation(stack.getTagCompound().getString(NBTKEY)), "inventory");
            }
            return new net.minecraft.client.renderer.block.model.ModelResourceLocation(INSTANCE.getRegistryName(), "inventory");
        }

    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn){
        if(stack.hasTagCompound() && stack.getTagCompound().hasKey(NBTKEY)){
            Gauge gau = Resources.GAUGES.getValue(new ResourceLocation(stack.getTagCompound().getString(NBTKEY)));
            if(gau == null){
                return;
            }
            tooltip.add(Formatter.format("&9Name: &7" + gau.getName()));
            for(String s : gau.getDescription()){
                tooltip.add(Formatter.format(s));
            }
        }
        //
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
        	tooltip.add("No Connection data.");
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
        if(block instanceof TrackBlock){
    		if(player.isSneaking()){
    			worldcap.resetConnectionsAt(pos); Print.chat(player, "&cResetting...");
    			return EnumActionResult.SUCCESS;
    		}
    		if(stack.getTagCompound() == null) stack.setTagCompound(new NBTTagCompound());
        	if(stack.getTagCompound().hasKey("fvtm:railtrackstart")){
        		BlockPos pos0 = BlockPos.fromLong(stack.getTagCompound().getLong("fvtm:railtrackstart"));
        		IBlockState state0 = world.getBlockState(pos0);
        		if(state0 == null){ Print.chat(player, "&cRailConnector at first connection point is NULL."); return EnumActionResult.FAIL; }
        		//if(tte == null){ Print.chat(player, "&cTileEntity at second connection point is NULL."); return EnumActionResult.FAIL; }
        		Connection[] conns = worldcap.getConnectionsAt(pos0); Gauge sec = this.getGauge(stack);
        		if(conns != null && conns.length > 0 && !conns[0].isCompatibleGauge(sec)){
        			Print.chat(player, "&cGauges do not match.");
        			Print.chat(player, "&7Item: &9(" + sec.width() + ") &7" + sec.getName());
        			Print.chat(player, "&7This: &a(" + conns[0].getGauge().width() + ") &7" + conns[0].getGauge().getName());
        	        return EnumActionResult.FAIL;
        		}
        		if(stack.getTagCompound().getInteger("fvtm:railtrackpoints") == 1){
        			Print.chat(player, "&cAt least 2 subpoints are needed."); return EnumActionResult.FAIL;
        		}
        		BlockPos[] arr = new BlockPos[stack.getTagCompound().getInteger("fvtm:railtrackpoints")];
        		for(int j = 0; j < arr.length; j++){
        			arr[j] = BlockPos.fromLong(stack.getTagCompound().getLong("fvtm:railtrackpoint" + j));
        		}
        		worldcap.addConnection(new Connection(sec, pos0, pos, false, arr));
        		Print.bar(player, "&7Connected&9!");
        		//
        		stack.getTagCompound().removeTag("fvtm:railtrackstart");
        		stack.getTagCompound().removeTag("fvtm:railtrackpoints");
        		for(int k = 0; k < arr.length; k++) stack.getTagCompound().removeTag("fvtm:railtrackpoint" + k);
	            return EnumActionResult.SUCCESS;
        	}
        	else{
        		Connection[] conns = worldcap.getConnectionsAt(pos);
    			if(conns != null && conns.length >= 4){
        			Print.chat(player, "&cTileEntity reached max allowed connections. (#" + conns.length + ";)");
        	        return EnumActionResult.FAIL;
    			}
				Gauge sec = this.getGauge(stack);
    			if(sec == null){
        			Print.chat(player, "&cItem has no Gauge Data.");
        	        return EnumActionResult.FAIL;
    			}
    			if(conns != null && conns.length > 0 && !conns[0].isCompatibleGauge(sec)){
        			Print.chat(player, "&cGauges do not match.");
        			Print.chat(player, "&7Item: &9(" + sec.width() + ") &7" + sec.getName());
        			Print.chat(player, "&7Rail: &b(" + conns[0].getGauge().width() + ") &7" + conns[0].getGauge().getName());
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
    	        if(!stack.isEmpty() && player.canPlayerEdit(pos, facing, stack) && world.mayPlace(TrackItemBlock.INSTANCE.getBlock(), pos, false, facing, (Entity)null)){
    	            int i = this.getMetadata(stack.getMetadata());
    	            IBlockState nstate = TrackItemBlock.INSTANCE.getBlock().getStateForPlacement(world, pos, facing, hitX, hitY, hitZ, i, player, hand);
    	            if(TrackItemBlock.INSTANCE.placeBlockAt(stack, player, world, pos, facing, hitX, hitY, hitZ, nstate)){
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

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items){
        if(tab == CreativeTabs.SEARCH){
            for(Gauge gauge : Resources.GAUGES.getValuesCollection()){
                ItemStack stack = new ItemStack(this); NBTTagCompound nbt = new NBTTagCompound();
                nbt.setString(NBTKEY, gauge.getRegistryName().toString());
                stack.setTagCompound(nbt); items.add(stack);
            }
        }
        if(tab instanceof GenericCreativeTab){
            Addon addon = ((GenericCreativeTab)tab).getAddon();
            Collection<Gauge> coll = Resources.GAUGES.getValuesCollection().stream().filter(p -> p.getAddon().getRegistryName().equals(addon.getRegistryName())).collect(Collectors.toList());
            for(Gauge gauge : coll){
                ItemStack stack = new ItemStack(this); NBTTagCompound nbt = new NBTTagCompound();
                nbt.setString(NBTKEY, gauge.getRegistryName().toString());
                stack.setTagCompound(nbt); items.add(stack);
            }
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack){
        if(stack.hasTagCompound()){
            return "item." + stack.getTagCompound().getString(NBTKEY);
        }
        return this.getUnlocalizedName();
    }

	@Override
	public Gauge getGauge(ItemStack stack){
        if(stack.hasTagCompound() && stack.getTagCompound().hasKey(NBTKEY)){
            return Resources.GAUGES.getValue(new ResourceLocation(stack.getTagCompound().getString(NBTKEY)));
        }
        return null;
	}

}
