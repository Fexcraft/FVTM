package net.fexcraft.mod.fvtm.item;

import net.fexcraft.mod.fvtm.data.ContentItem;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.WireComponent;
import net.fexcraft.mod.fvtm.util.GenericUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.function.Consumer;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class WireCompItem extends Item implements ContentItem<WireComponent> {

	private WireComponent deco;

	public WireCompItem(Properties prop, WireComponent type){
		super(prop.stacksTo(1));
		this.deco = type;
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay disp, Consumer<Component> cons, TooltipFlag flag){
		cons.accept(GenericUtils.format("&9Name: &7" + deco.getName()));
		for(String s : deco.getDescription()) cons.accept(Component.translatable(s));
		cons.accept(GenericUtils.format("&9Component Type: &7" + deco.getType()));
		cons.accept(GenericUtils.format("&9Accepts: &7"));
		for(String s : deco.getCompatible()) cons.accept(Component.translatable(s));
	}

	@Override
	public WireComponent getContent(){
		return deco;
	}

	@Override
	public ContentType getType(){
		return ContentType.WIRE_COMPONENT;
	}

}