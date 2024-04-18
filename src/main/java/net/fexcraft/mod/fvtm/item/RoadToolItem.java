package net.fexcraft.mod.fvtm.item;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.block.Asphalt;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.JunctionGridItem;
import net.fexcraft.mod.fvtm.sys.road.RoadPlacingCache;
import net.fexcraft.mod.fvtm.sys.road.RoadPlacingUtil;
import net.fexcraft.mod.fvtm.sys.road.UniRoadTool;
import net.fexcraft.mod.fvtm.util.CompatUtil;
import net.fexcraft.mod.fvtm.util.Perms;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

import static net.fexcraft.mod.fvtm.Config.MAX_ROAD_LENGTH;
import static net.fexcraft.mod.fvtm.sys.road.UniRoadTool.grv;

public class RoadToolItem extends Item {
	
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
        int result = UniRoadTool.onUse(player.getCapability(Capabilities.PASSENGER, null).asWrapper(), hand == EnumHand.MAIN_HAND);
		switch(result){
			case 1: return EnumActionResult.FAIL;
			case 2: return EnumActionResult.SUCCESS;
			case 3:{
				if(!Static.getServer().isSinglePlayer() && !Perms.ROAD_PLACER_ITEM.has(player)){
					Print.chat(player, "&cNo permission to use this item.");
					return EnumActionResult.FAIL;
				}
				pos = pos.down();
				RoadPlacingUtil.place(WrapperHolder.getWorld(world),
					player.getCapability(Capabilities.PASSENGER, null).asWrapper(),
					TagCW.wrap(player.getHeldItem(hand).getTagCompound()),
					new QV3D(pos.getX() + hitX, pos.getY() + hitY, pos.getZ() + hitZ, 16));
				return EnumActionResult.SUCCESS;
			}
			case 0:
			default: return EnumActionResult.PASS;
		}
    }

}
