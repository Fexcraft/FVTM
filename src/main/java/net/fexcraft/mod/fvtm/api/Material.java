package net.fexcraft.mod.fvtm.api;

import net.minecraft.item.ItemStack;
import net.minecraftforge.registries.IForgeRegistryEntry;

public interface Material extends IForgeRegistryEntry<Material> {
	
	public Addon getAddon();
	
	public String getName();
	
	public String[] getDescription();
	
	@Override
	public default Class<Material> getRegistryType(){
		return Material.class;
	}
	
	public ItemStack getItemStack();
	
	public boolean isFuelContainer();
	
	public Fuel getFuelType();
	
	public int maxCapacity();
	
	//<--- ITEM --->//
	public static interface MaterialItem {
		
		public static final String NBTKEY = "FVTM:Material";
		
		public Material getMaterial(ItemStack stack);
		
	}
	
}