package net.fexcraft.mod.fvtm.item;

import static net.fexcraft.mod.fvtm.Config.DISABLE_WIRES;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.lib.common.utils.Formatter;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.ContentItem;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.JunctionGridItem;
import net.fexcraft.mod.fvtm.data.WireType;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager.Systems;
import net.fexcraft.mod.fvtm.sys.wire.WireSystem;
import net.fexcraft.mod.uni.EnvInfo;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
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

public class WireItem extends Item implements ContentItem<WireType>, JunctionGridItem {//}, ItemTex<WireType> {

	private WireType wire;

    public WireItem(WireType type){
		super();
		wire = type;
		setHasSubtypes(true);
		setMaxStackSize(1);
		setRegistryName(wire.getID().colon());
		setTranslationKey(wire.getID().colon());
		if(!EnvInfo.CLIENT) return;
		setCreativeTab((CreativeTabs)FvtmResources.INSTANCE.getCreativeTab(wire));
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn){
        tooltip.add(Formatter.format("&9Name: &7" + wire.getName()));
        for(String s : wire.getDescription()){
            tooltip.add(Formatter.format(I18n.format(s)));
        }
		tooltip.add(Formatter.format("&9Type: &7" + wire.getType()));
        tooltip.add(Formatter.format("&9Def. Slack: &7" + wire.getDefaultSlack()));
        tooltip.add(Formatter.format("&9Customisable: &7" + wire.isCustomisable()));
        tooltip.add(Formatter.format("&9- &6- &9- - - - &6-"));
        if(stack.getTagCompound() != null && stack.getTagCompound().hasKey("fvtm:wirepoint")){
        	tooltip.add(Formatter.format("&9Block: &7" + stack.getTagCompound().getIntArray("fvtm:wirepoint")));
        	tooltip.add(Formatter.format("&9Relay: &7" + stack.getTagCompound().getString("fvtm:wirepoint_key")));
        }
        else{
        	tooltip.add("No Connection data.");
        }
        tooltip.add(Formatter.format("&9- &6- &9- - - - &6-"));
        tooltip.add(Formatter.format("&6Usage:"));
        tooltip.add(Formatter.format("&b- Rightclick on a relay to select."));
        tooltip.add(Formatter.format("&b- Rightclick 2 relays in sequence to create a wire. "));
        tooltip.add(Formatter.format("&b- Rightclick + Sneak to reset point cache (sequence)."));
    }
	
	@Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
        if(world.isRemote || DISABLE_WIRES || hand != EnumHand.MAIN_HAND) return EnumActionResult.PASS;
        WireSystem system = SystemManager.get(Systems.WIRE, WrapperHolder.getWorld(world));
        if(system == null){
			Print.chat(player, "&cWire System not found. Is it enabled?");
	        return EnumActionResult.FAIL;
        }
        ItemStack stack = player.getHeldItem(hand);
        if(player.isSneaking()){
        	if(stack.getTagCompound() != null && stack.getTagCompound().hasKey("fvtm:wirepoint")){
    			stack.getTagCompound().removeTag("fvtm:wirepoint");
    			stack.getTagCompound().removeTag("fvtm:wirepoint_key");
				UniEntity.getEntity(player).send("interact.fvtm.relay.cache_reset");
        	}
			return EnumActionResult.SUCCESS;
		}
        return EnumActionResult.SUCCESS;
    }

	@Override
	public WireType getContent(){
		return wire;
	}

	@Override
	public ContentType getType(){
		return ContentType.WIRE;
	}

}
