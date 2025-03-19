package net.fexcraft.mod.fvtm.item;

import net.fexcraft.mod.fvtm.data.Consumable;
import net.fexcraft.mod.fvtm.data.ContentItem;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ConsumableItem extends Item implements ContentItem<Consumable> {

	private Consumable consumable;

	public ConsumableItem(Properties prop, Consumable consumable){
		super(prop.stacksTo(consumable.getMaxStack()).food(build(consumable)));
		this.consumable = consumable;
	}

	private static FoodProperties build(Consumable consumable){
		FoodProperties.Builder prop = new FoodProperties.Builder();
		prop.nutrition(consumable.getHealAmount());
		/*prop.saturationMod(consumable.getSaturation());
		if(consumable.isWolfFood()) prop.meat();
		if(consumable.isAlwaysEdible()) prop.alwaysEat();*/
		return prop.build();
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag){;
		/*tooltip.add(GenericUtils.format("&9Name: &7" + consumable.getName()));
		for(String s : consumable.getDescription()) tooltip.add(GenericUtils.format(I18n.get(s)));
		tooltip.add(GenericUtils.format("&9Type: &7" + (consumable.isDrinkable() ? "drink/beverage" : "food")));
		tooltip.add(GenericUtils.format("&9Heal Amout: &7" + consumable.getHealAmount()));
		tooltip.add(GenericUtils.format("&9Saturation: &7" + consumable.getSaturation()));
		if(consumable.isWolfFood()){
			tooltip.add(GenericUtils.format("&9&oLiked by wolves."));
		}
		if(consumable.isAlwaysEdible()){
			tooltip.add(GenericUtils.format("&8&oAlways " + (consumable.isDrinkable() ? "drinkable" : "edible") + "."));
		}
		if(consumable.getOreDictId() != null){
			tooltip.add(GenericUtils.format("&9OreDict: &7" + consumable.getOreDictId()));
		}*/
	}

	@Override
	public Consumable getContent(){
		return consumable;
	}

	@Override
	public ContentType getType(){
		return ContentType.CONSUMABLE;
	}

}