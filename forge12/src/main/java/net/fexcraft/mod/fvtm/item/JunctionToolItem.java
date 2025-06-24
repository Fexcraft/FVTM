package net.fexcraft.mod.fvtm.item;

import net.fexcraft.lib.common.utils.Formatter;
import net.fexcraft.mod.fvtm.data.JunctionGridItem;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailSystem;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.ui.UIKeys;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.inv.UniStack;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.EntityW;
import net.fexcraft.mod.uni.world.WorldW;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

import static net.fexcraft.mod.fvtm.Config.DISABLE_RAILS;

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
		if(stack.getTagCompound() != null && stack.getTagCompound().hasKey("fvtm:junction")){
			tooltip.add(Formatter.format("&9Junction Selected: &7" + new QV3D(TagCW.wrap(stack.getTagCompound()), "fvtm:junction").toString()));
		}
		else{
			tooltip.add("No Junction Position Cached.");
		}
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World level, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		if(level.isRemote || DISABLE_RAILS){
			return EnumActionResult.PASS;
		}
		WorldW world = WrapperHolder.getWorld(level);
		RailSystem railsys = SystemManager.get(SystemManager.Systems.RAIL, world);
		EntityW pass = UniEntity.getEntity(player);
		if(railsys == null){
			pass.bar("item.fvtm.junction_tool.nosys");
			return EnumActionResult.FAIL;
		}
		QV3D vector = new QV3D(pos.getX() + hitX, pos.getY() + hitY, pos.getZ() + hitZ), cached;
		StackWrapper stack = UniStack.getStack(player.getHeldItem(hand));
		if(player.isSneaking()){
			Junction junc = railsys.getJunction(vector.pos);
			if(junc == null){
				pass.bar("item.fvtm.junction_tool.nojunc");
			}
			else if(junc.size() > 0){
				pass.bar("item.fvtm.junction_tool.fulljunc");
			}
			else{
				railsys.delJunction(vector.pos);
				pass.bar("item.fvtm.junction_tool.remjunc");
			}
			return EnumActionResult.SUCCESS;
		}
		Junction junk = railsys.getJunction(vector.pos, true);
		if(junk == null){
			pass.bar("item.fvtm.junction_tool.nojunc");
			return EnumActionResult.SUCCESS;
		}
		else{
			if(stack.directTag().has("fvtm:junction")){
				cached = new QV3D(stack.directTag(), "fvtm:junction");
				if(cached.equals(vector)){
					pass.openUI(UIKeys.RAIL_JUNCTION, cached.pos.x, cached.pos.y, cached.pos.z);
					return EnumActionResult.SUCCESS;
				}
				if(junk.tracks.size() <= 2){
					stack.updateTag(tag -> tag.rem("fvtm:junction"));
					pass.bar("item.fvtm.junction_tool.reset");
				}
			}
			if(junk.tracks.size() < 2){
				pass.openUI(UIKeys.RAIL_JUNCTION, vector.pos.x, vector.pos.y, vector.pos.z);
			}
			else{
				stack.updateTag(tag -> vector.write(tag, "fvtm:junction"));
				pass.bar("item.fvtm.junction_tool.cached");
			}
			return EnumActionResult.SUCCESS;
		}
	}

}
