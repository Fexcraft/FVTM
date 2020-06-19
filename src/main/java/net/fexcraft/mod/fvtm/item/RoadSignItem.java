package net.fexcraft.mod.fvtm.item;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.lib.mc.api.registry.fItem;
import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.RoadSign;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@fItem(modid = FVTM.MODID, name = "roadsign")
public class RoadSignItem extends Item {
	
	public static RoadSignItem INSTANCE;

    public RoadSignItem(){
		super(); INSTANCE = this; this.setHasSubtypes(true); this.setMaxStackSize(1);
        if(Static.side().isServer()) return;
        this.setCreativeTab(net.fexcraft.mod.fvtm.data.RoadSign.RoadSignsTab.INSTANCE);
	}

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flag){
    	if(!stack.hasTagCompound()){
            tooltip.add(Formatter.format("&7&oNo Tag Compound."));
    		return;
    	}
    	RoadSign sign = stack.getCapability(Capabilities.VAPDATA, null).getRSData();
    	if(sign == null){
            tooltip.add(Formatter.format("&cROAD SIGN NOT FOUND IN REGISTRY"));
            tooltip.add(Formatter.format("&a&o" + stack.getTagCompound().getString("fvtm:roadsign")));
            return;
    	}
        tooltip.add(Formatter.format("&9&o" + sign.getAddon().getName()));
        for(String s : sign.getDescription()){ tooltip.add(Formatter.format(I18n.format(s, new Object[0]))); }
    }

    @SuppressWarnings("deprecation")
	@Override
    public String getItemStackDisplayName(ItemStack stack){
    	if(!stack.getCapability(Capabilities.VAPDATA, null).overridesLang(false)){
        	String langname = "item." + stack.getItem().getRegistryName().toString() + ".name";
        	langname = net.minecraft.util.text.translation.I18n.translateToLocal(langname).trim();
        	if(langname.length() > 0) return langname;
        	stack.getCapability(Capabilities.VAPDATA, null).overridesLang(true);
    	}
        return Formatter.format(stack.getCapability(Capabilities.VAPDATA, null).getRSData().getName());
    }
	
    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items){
    	if(tab == CreativeTabs.SEARCH || tab == this.getCreativeTab()){
    		/*List<RoadSign> signs = Resources.ROADSIGNS.getValuesCollection().stream().sorted(new Comparator<RoadSign>(){
				@Override public int compare(RoadSign o1, RoadSign o2){
					return o1.getRegistryName().compareTo(o2.getRegistryName());
				}}).collect(java.util.stream.Collectors.toList());
    		for(RoadSign sign : signs){
        		items.add(sign.newItemStack());
    		}*/
    		for(RoadSign sign : Resources.ROADSIGNS.getValuesCollection()){
        		items.add(sign.newItemStack());
    		}
    	}
    }

	public RoadSign getType(ItemStack stack){
		return stack.hasTagCompound() ? Resources.getRoadSign(stack.getTagCompound().getString("fvtm:roadsign")) : null;
	}
    
    @Override
    public EnumActionResult onItemUseFirst(EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, EnumHand hand){
    	if(world.isRemote || side.getAxis().isVertical()) return EnumActionResult.PASS;
    	if(StreetSignItem.tryPlace(player, world, pos, side, player.getHeldItem(hand), 1)) return EnumActionResult.SUCCESS;
    	return EnumActionResult.PASS;
    }

}
