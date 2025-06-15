package net.fexcraft.mod.fvtm.item;

import net.fexcraft.mod.fvtm.data.ContentItem;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.WireDeco;
import net.fexcraft.mod.fvtm.util.GenericUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class WireDecoItem extends Item implements ContentItem<WireDeco> {

	private WireDeco deco;

	public WireDecoItem(WireDeco type){
		super((new Properties()).stacksTo(1));
		this.deco = type;
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag){
		tooltip.add(GenericUtils.format("&9Name: &7" + deco.getName()));
		for(String s : deco.getDescription()) tooltip.add(Component.translatable(s));
		tooltip.add(GenericUtils.format("&9DecoType: &7" + deco.getType()));
		tooltip.add(GenericUtils.format("&9Accepts: &7"));
		for(String s : deco.getCompatible()) tooltip.add(Component.translatable(s));
	}

	@Override
	public WireDeco getContent(){
		return deco;
	}

	@Override
	public ContentType getType(){
		return ContentType.WIREDECO;
	}

}