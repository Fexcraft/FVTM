package net.fexcraft.mod.fvtm.data.container;

import net.minecraft.item.ItemStack;

public abstract class ContainerContentFilter {
	
	public abstract String id();
	
	public abstract boolean isValid(ContainerData data, ItemStack stack);
	
}
