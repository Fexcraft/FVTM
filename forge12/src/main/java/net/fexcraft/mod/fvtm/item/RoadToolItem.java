package net.fexcraft.mod.fvtm.item;

import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.data.JunctionGridItem;
import net.fexcraft.mod.fvtm.sys.road.RoadPlacingUtil;
import net.fexcraft.mod.fvtm.sys.road.UniRoadTool;
import net.fexcraft.mod.fvtm.util.Perms;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.EntityW;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.client.resources.I18n;
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

public class RoadToolItem extends Item implements JunctionGridItem {
	
	public static RoadToolItem INSTANCE;

    public RoadToolItem(){
		super();
		INSTANCE = this;
		setMaxStackSize(1);
		setRegistryName("fvtm:road_tool");
		setTranslationKey("fvtm:road_tool");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn){
        UniRoadTool.addTooltip(TagCW.wrap(stack.getTagCompound()), tooltip, (str, objs) -> I18n.format(str, objs));
    }
	
	@Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		EntityW ent = UniEntity.getEntity(player);
		int result = UniRoadTool.onUse(ent, hand == EnumHand.MAIN_HAND);
		switch(result){
			case 1: return EnumActionResult.FAIL;
			case 2: return EnumActionResult.SUCCESS;
			case 3:{
				if(!Static.getServer().isSinglePlayer() && !Perms.ROAD_PLACER_ITEM.has(player)){
					Print.chat(player, "&cNo permission to use this item.");
					return EnumActionResult.FAIL;
				}
				pos = pos.down();
				RoadPlacingUtil.place(WrapperHolder.getWorld(world), ent,
					TagCW.wrap(player.getHeldItem(hand).getTagCompound()),
					new QV3D(pos.getX() + hitX, pos.getY() + hitY, pos.getZ() + hitZ));
				return EnumActionResult.SUCCESS;
			}
			case 0:
			default: return EnumActionResult.PASS;
		}
    }

}
