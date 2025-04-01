package net.fexcraft.mod.fvtm.item;

import net.fexcraft.mod.fvtm.data.*;
import net.fexcraft.mod.fvtm.data.root.ItemTextureable;
import net.fexcraft.mod.fvtm.util.GenericUtils;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.inv.UniStack;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

import static net.fexcraft.mod.fvtm.item.VehicleItem.getTexTitle;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class SignItem extends Item implements ContentItem.ContentDataItem<Sign, SignData>, ItemTextureable.TextureableItem<Sign> {

	private Sign sign;

	public SignItem(Sign deco){
		super(new Properties().stacksTo(64));
		this.sign = deco;
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag){
		tooltip.add(GenericUtils.format("&9Name: &7" + sign.getName()));
		for(String s : sign.getDescription()){
			tooltip.add(GenericUtils.format(s));
		}
		UniStack uni = UniStack.get(stack);
		if(uni == null) return;
		SignData data = getData(uni.stack);
		if(data != null){
			tooltip.add(GenericUtils.format("&9Texture: &7" + getTexTitle(data)));
			if(sign.getModel() != null && sign.getModel().getCreators().size() > 0){
				tooltip.add(GenericUtils.format("&9Model by:"));
				for(String str : sign.getModel().getCreators()){
					tooltip.add(GenericUtils.format("&7- " + str));
				}
			}
		}
	}

	@Override
	public Sign getContent(){
		return sign;
	}

	@Override
	public ContentType getType(){
		return ContentType.SIGN;
	}

	@Override
	public SignData getData(StackWrapper stack){
		return getData(stack.directTag());
	}

	@Override
	public SignData getData(TagCW compound){
		return new SignData(sign).read(compound);
	}

}