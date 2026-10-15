package net.fexcraft.mod.fvtm.data.inv;

import net.fexcraft.mod.uni.inv.StackWrapper;

import java.util.LinkedHashMap;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public abstract class ContentFilter {
	
	public static final LinkedHashMap<String, ContentFilter> FILTER_REGISTRY = new LinkedHashMap<>();
	static {
		FILTER_REGISTRY.put("food_only", new FoodFilter());
	}
	
	public abstract String id();
	
	public abstract boolean isValid(StackWrapper stack);
	
	public static class FoodFilter extends ContentFilter {

		@Override
		public String id(){ return "food_only"; }

		@Override
		public boolean isValid(StackWrapper stack){
			return stack.isItemOf(StackWrapper.IT_FOOD);
		}
		
	}
	
}
