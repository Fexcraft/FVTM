package net.fexcraft.mod.fvtm.item;

import static net.fexcraft.mod.fvtm.Config.DISABLE_RAILS;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.JUNCTION_ADJUSTER;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.LISTENERID;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.lib.common.utils.Formatter;
import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.JunctionGridItem;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailSystem;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager.Systems;
import net.fexcraft.mod.fvtm.ui.UIKeys;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class JunctionToolItem extends Item implements JunctionGridItem {

	public static JunctionToolItem INSTANCE;

	public JunctionToolItem(){
		setHasSubtypes(true);
		setMaxStackSize(1);
		setRegistryName("fvtm:junction_tool");
		setTranslationKey("fvtm:junction_tool");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn){
		tooltip.add(Formatter.format("&9Junction Editing Toolbox"));
		tooltip.add(Formatter.format("&9- - - - - - &7-"));
		if(stack.getTagCompound() != null && stack.getTagCompound().hasKey("fvtm:junction")){
			tooltip.add(Formatter.format("&9Junction Selected: &7" + new QV3D(TagCW.wrap(stack.getTagCompound()), "fvtm:junction").toString()));
		}
		else{
			tooltip.add("No Junction Position Cached.");
		}
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		if(world.isRemote || DISABLE_RAILS){
			return EnumActionResult.PASS;
		}
		RailSystem syscap = SystemManager.get(Systems.RAIL, WrapperHolder.getWorld(world));
		if(syscap == null){
			Print.chat(player, "&cWorld Capability not found.");
			return EnumActionResult.FAIL;
		}
		QV3D vector = new QV3D(pos.getX() + hitX, pos.getY() + hitY, pos.getZ() + hitZ), cached;
		Passenger pass = (Passenger)UniEntity.getEntity(player);
		ItemStack stack = player.getHeldItem(hand);
		if(player.isSneaking()){
			Junction junc = syscap.getJunction(vector.pos);
			if(junc == null){
				Print.bar(player, "&cNo junction at position.");
			}
			else if(junc.size() > 0){
				Print.bar(player, "&cDisconnect all tracks before removing a Junction.");
			}
			else{
				syscap.delJunction(vector.pos);
				Print.bar(player, "&c&oRemoving Junction...");
			}
			return EnumActionResult.SUCCESS;
		}
		if(stack.getTagCompound() == null) stack.setTagCompound(new NBTTagCompound());
		Junction junk = syscap.getJunction(vector.pos, true);
		if(junk == null){
			Print.bar(player, "&cNo Junction at this Position.");
			return EnumActionResult.SUCCESS;
		}
		else{
			if(stack.getTagCompound().hasKey("fvtm:junction")){
				cached = new QV3D(TagCW.wrap(stack.getTagCompound()), "fvtm:junction");
				if(cached.equals(vector)){
					//GenericContainer.openGui(JUNCTION_ADJUSTER, new int[]{ 0, 0, 0 }, LISTENERID, cached.write(null, null).local(), player);
					pass.openUI(UIKeys.RAIL_JUNCTION, cached.pos.x, cached.pos.y, cached.pos.z);
					return EnumActionResult.SUCCESS;
				}
				if(junk.tracks.size() <= 2){
					stack.getTagCompound().removeTag("fvtm:junction");
					Print.bar(player, "&7&oResetting previous Cached Position.");
				}
			}
			if(junk.tracks.size() < 2){
				//GenericContainer.openGui(JUNCTION_ADJUSTER, new int[]{ 0, 0, 0 }, LISTENERID, vector.write(null, null).local(), player);
				pass.openUI(UIKeys.RAIL_JUNCTION, vector.pos.x, vector.pos.y, vector.pos.z);
			}
			else{
				vector.write(TagCW.wrap(stack.getTagCompound()), "fvtm:junction");
				Print.bar(player, "&a&lJunction Position Cached.");
			}
			return EnumActionResult.SUCCESS;
		}
	}

}
