package net.fexcraft.mod.fvtm.item;

import net.fexcraft.lib.common.utils.Formatter;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.*;
import net.fexcraft.mod.uni.EnvInfo;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class WireDecoItem extends Item implements ContentItem<WireDeco>, JunctionGridItem {

	private WireDeco wire;

    public WireDecoItem(WireDeco type){
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
        tooltip.add(Formatter.format("&9Accepts: &7"));
		for(String str : wire.getCompatible()){
			tooltip.add(Formatter.format("- " + str));
		}
    }

	@Override
	public WireDeco getContent(){
		return wire;
	}

	@Override
	public ContentType getType(){
		return ContentType.WIREDECO;
	}

}
