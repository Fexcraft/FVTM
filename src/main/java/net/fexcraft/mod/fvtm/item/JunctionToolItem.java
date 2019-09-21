package net.fexcraft.mod.fvtm.item;

import java.util.List;
import javax.annotation.Nullable;

import net.fexcraft.lib.mc.api.registry.fItem;
import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.RailSystem;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@fItem(modid = "fvtm", name = "junction_tool")
public class JunctionToolItem extends Item {

    public static JunctionToolItem INSTANCE;

	public JunctionToolItem(){
		this.setHasSubtypes(true); this.setMaxStackSize(1); INSTANCE = this;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn){
        tooltip.add(Formatter.format("&9Junction Editing Toolbox"));
        tooltip.add(Formatter.format("&9- - - - - - &7-"));
        if(stack.getTagCompound() != null && stack.getTagCompound().hasKey("fvtm:junction")){
        	NBTTagCompound com = stack.getTagCompound().getCompoundTag("fvtm:junction");
        	tooltip.add(Formatter.format("&9Junction Selected:" + new Vec316f(com).toString()));
        }
        else{
        	tooltip.add("No Junction Position Cached.");
        }
    }
	
	@Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
        if(world.isRemote){ return EnumActionResult.PASS; }
        RailSystem syscap = world.getCapability(Capabilities.RAILSYSTEM, null);
        if(syscap == null){
			Print.chat(player, "&cWorld Capability not found.");
	        return EnumActionResult.FAIL;
        }
        ItemStack stack = player.getHeldItem(hand);
        if(player.isSneaking()){
			stack.getTagCompound().removeTag("fvtm:junction");
			Print.chat(player, "&cResetting Cached Position.");
			return EnumActionResult.SUCCESS;
		}
        Vec316f vector = new Vec316f(new Vec3d(pos).addVector(hitX, hitY, hitZ), Config.RAIL_PLACING_GRID), cached;
		if(stack.getTagCompound() == null) stack.setTagCompound(new NBTTagCompound());
		Junction junk = syscap.getJunction(vector, true);
		if(junk == null){
	        if(stack.getTagCompound().hasKey("fvtm:junction")){
	        	cached = new Vec316f(stack.getTagCompound().getCompoundTag("fvtm:junction"));
        		junk = syscap.getJunction(cached, true);
        		junk.updateSwitchLocation(vector.vector, player.getHorizontalFacing().getOpposite());
        		junk.updateClient(); Print.chat(player, "&aNew Switch Location for Junction set!");
    			Print.chat(player, "&7&oResetting Cached Position.");
	        }
	        else{
    			Print.chat(player, "&cNo Junction at this Position.");
	        }
	        return EnumActionResult.SUCCESS;
		}
		else{
	        if(stack.getTagCompound().hasKey("fvtm:junction")){
	        	cached = new Vec316f(stack.getTagCompound().getCompoundTag("fvtm:junction"));
	        	if(cached.equals(vector)){
	        		GenericContainer.openGenericGui(701, new int[]{ 0, 0, 0 }, cached.write(), player);
	                return EnumActionResult.SUCCESS;
	        	}
	        	if(junk.tracks.size() <= 2){
	    			Print.chat(player, "&7&oResetting previous Cached Position.");
	        	}
	        }
			if(junk.tracks.size() <= 2){
        		GenericContainer.openGenericGui(701, new int[]{ 0, 0, 0 }, vector.write(), player);
			}
			else{
				stack.getTagCompound().setTag("fvtm:junction", vector.write());
    			Print.chat(player, "&a&lJunction Position Cached.");
			}
            return EnumActionResult.SUCCESS;
		}
    }

}
