package net.fexcraft.mod.fvtm.blocks;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.util.Tabs;
import net.fexcraft.mod.lib.api.item.fItem;
import net.fexcraft.mod.lib.util.common.Formatter;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@fItem(modid = FVTM.MODID, name = "constructor_remote")
public class ConstructorRemote extends Item {
	
	public static final String NBTKEY = "ConstructorControllerPos";
	
	public ConstructorRemote(){
		this.setMaxStackSize(1);
		this.setCreativeTab(Tabs.BLOCKS);
	}
	
	@Override
    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flag){
		if(stack.hasTagCompound()){
			if(stack.getTagCompound().hasKey(NBTKEY)){
				BlockPos pos = BlockPos.fromLong(stack.getTagCompound().getLong(NBTKEY));
				tooltip.add(Formatter.format("&9Controller: &7" + pos.getX() + ", " + pos.getY() + ", " + pos.getZ() + "."));
			}
			else{
				tooltip.add("No Controller connected.");
			}
		}
		else{
			tooltip.add("No Tag.");
		}
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		if(world.isRemote){
			return EnumActionResult.PASS;
		}
		else{
			ItemStack stack = player.getHeldItem(hand);
			IBlockState state = world.getBlockState(pos);
			if(state.getBlock() instanceof ConstructorController){
				if(!stack.hasTagCompound()){
					stack.setTagCompound(new NBTTagCompound());
				}
				stack.getTagCompound().setLong(NBTKEY, pos.toLong());
				Print.chat(player, "Coordinates saved.");
			}
			else{
				return EnumActionResult.PASS;
			}
			return EnumActionResult.SUCCESS;
		}
    }
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand){
		ItemStack stack = player.getHeldItem(hand);
		if(stack.hasTagCompound() && stack.getTagCompound().hasKey(NBTKEY)){
			player.openGui(FVTM.getInstance(), 9912, world, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getY());
			return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
		}
		return new ActionResult<ItemStack>(EnumActionResult.PASS, player.getHeldItem(hand));
		
	}
	
}