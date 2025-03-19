package net.fexcraft.mod.fvtm.item;

import net.fexcraft.mod.fvtm.data.ContentItem;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.Decoration;
import net.fexcraft.mod.fvtm.data.DecorationData;
import net.fexcraft.mod.fvtm.data.root.ItemTextureable;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;

import java.util.List;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class DecorationItem extends Item implements ContentItem.ContentDataItem<Decoration, DecorationData>, ItemTextureable.TextureableItem<Decoration> {

	private Decoration deco;

	public DecorationItem(Properties prop, Decoration deco){
		super(prop.stacksTo(deco.getMaxStack()));
		this.deco = deco;
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag){
		/*tooltip.add(GenericUtils.format("&9Name: &7" + deco.getName()));
		for(String s : deco.getDescription()){
			tooltip.add(GenericUtils.format(I18n.get(s)));
		}
		DecorationData data = getDataFromTag(stack.getTag());
		if(data != null){
			tooltip.add(GenericUtils.format("&9Texture: &7" + VehicleItem.getTexTitle(data)));
			if(deco.getModel() != null && deco.getModel().getCreators().size() > 0){
				tooltip.add(GenericUtils.format("&9Model by:"));
				for(String str : deco.getModel().getCreators()){
					tooltip.add(GenericUtils.format("&7- " + str));
				}
			}
		}
		tooltip.add(GenericUtils.format("&9Rightclick on a block to place this decoration."));*/
	}

	@Override
	public InteractionResult useOn(UseOnContext context){
		/*if(context.getLevel().isClientSide) return InteractionResult.PASS;
		ItemStack stack = context.getItemInHand();
		DecorationEntity decoen = FVTM4.DECORATION_ENTITY.get().create(context.getLevel());
		DecorationData data = getDataFromTag(stack.getTag());
		if(data != null) decoen.decos.add(data);
		decoen.setPos(context.getClickLocation());
		context.getLevel().addFreshEntity(decoen);
		if(!context.getPlayer().isCreative()) stack.shrink(1);*/
		//EntityUtil.get(context.getPlayer()).openUI(UIKeys.DECORATION_EDITOR.key, new V3I(decoen.getId(), 0, 0));*///TODO
		return InteractionResult.SUCCESS;
	}

	@Override
	public Decoration getContent(){
		return deco;
	}

	@Override
	public ContentType getType(){
		return ContentType.DECORATION;
	}

	@Override
	public DecorationData getData(StackWrapper stack){
		return getData(stack.directTag());
	}

	@Override
	public DecorationData getData(TagCW compound){
		return new DecorationData(deco).read(compound);
	}

}