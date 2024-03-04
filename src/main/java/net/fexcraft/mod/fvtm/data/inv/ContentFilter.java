package net.fexcraft.mod.fvtm.data.inv;

import java.util.TreeMap;

import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public abstract class ContentFilter {
	
	public static final TreeMap<String, ContentFilter> FILTER_REGISTRY = new TreeMap<>();
	static {
		FILTER_REGISTRY.put("food_only", new FoodFilter());
	}
	
	public abstract String id();
	
	public abstract boolean isValid(ItemStack stack);
	
	public static class FoodFilter extends ContentFilter {

		@Override
		public String id(){ return "food_only"; }

		@Override
		public boolean isValid(ItemStack stack){
			return stack.getItem() instanceof ItemFood;
		}
		
	}
	
	//TODO more preset filters
	
}
