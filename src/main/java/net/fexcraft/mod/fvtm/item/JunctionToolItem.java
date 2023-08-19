package net.fexcraft.mod.fvtm.item;

import static net.fexcraft.mod.fvtm.Config.DISABLE_RAILS;
import static net.fexcraft.mod.fvtm.Config.RAIL_PLACING_GRID;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.JUNCTION_ADJUSTER;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.LISTENERID;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.lib.mc.api.registry.fItem;
import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.JunctionGridItem;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailSystem;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager.Systems;
import net.fexcraft.mod.fvtm.util.GridV3D;
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
public class JunctionToolItem extends Item implements JunctionGridItem {

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
        	tooltip.add(Formatter.format("&9Junction Selected: &7" + new GridV3D(com).toString()));
        }
        else{
        	tooltip.add("No Junction Position Cached.");
        }
    }
	
	@Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
        if(world.isRemote || DISABLE_RAILS){ return EnumActionResult.PASS; }
        RailSystem syscap = SystemManager.get(Systems.RAIL, world);
        if(syscap == null){
			Print.chat(player, "&cWorld Capability not found.");
	        return EnumActionResult.FAIL;
        }
        GridV3D vector = new GridV3D(world, new Vec3d(pos).add(hitX, hitY, hitZ), RAIL_PLACING_GRID), cached;
        ItemStack stack = player.getHeldItem(hand);
        if(player.isSneaking()){
        	Junction junc = syscap.getJunction(vector);
        	if(junc == null){
				Print.bar(player, "&cNo junction at position.");
        	}
        	else if(junc.size() > 0){
				Print.bar(player, "&cDisconnect all tracks before removing a Junction.");
        	}
        	else{
            	syscap.delJunction(vector);
            	Print.bar(player, "&c&oRemoving Junction...");
        	}
			return EnumActionResult.SUCCESS;
		}
		if(stack.getTagCompound() == null) stack.setTagCompound(new NBTTagCompound());
		Junction junk = syscap.getJunction(vector, true);
		if(junk == null){
			Print.bar(player, "&cNo Junction at this Position.");
	        return EnumActionResult.SUCCESS;
		}
		else{
	        if(stack.getTagCompound().hasKey("fvtm:junction")){
	        	cached = new GridV3D(stack.getTagCompound().getCompoundTag("fvtm:junction"));
	        	if(cached.equals(vector)){
	        		GenericContainer.openGui(JUNCTION_ADJUSTER, new int[]{ 0, 0, 0 }, LISTENERID, cached.write(), player);
	                return EnumActionResult.SUCCESS;
	        	}
	        	if(junk.tracks.size() <= 2){
	        		stack.getTagCompound().removeTag("fvtm:junction");
	    			Print.bar(player, "&7&oResetting previous Cached Position.");
	        	}
	        }
			if(junk.tracks.size() < 2){
        		GenericContainer.openGui(JUNCTION_ADJUSTER, new int[]{ 0, 0, 0 }, LISTENERID, vector.write(), player);
			}
			else{
				stack.getTagCompound().setTag("fvtm:junction", vector.write());
    			Print.bar(player, "&a&lJunction Position Cached.");
			}
            return EnumActionResult.SUCCESS;
		}
    }

}
