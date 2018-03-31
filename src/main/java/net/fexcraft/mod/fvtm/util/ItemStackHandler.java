package net.fexcraft.mod.fvtm.util;

import javax.annotation.Nonnull;

import net.fexcraft.mod.addons.gep.attributes.ContainerAttribute;
import net.fexcraft.mod.addons.gep.attributes.InventoryAttribute;
import net.fexcraft.mod.fvtm.api.Container.ContainerItem;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.api.Part.PartItem;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemStackHandler extends net.minecraftforge.items.ItemStackHandler {
	
	public ItemStackHandler(NonNullList<ItemStack> inventory){
		super(inventory);
	}

	@Override
	@Nonnull
	public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate){
		if(stack.getItem() instanceof VehicleItem || stack.getItem() instanceof ContainerItem || isContainerPart(stack)){
			return stack;
		}
		return super.insertItem(slot, stack, simulate);
	}

	private boolean isContainerPart(ItemStack stack){
		if(stack.getItem() instanceof PartItem){
			PartData data = ((PartItem)stack.getItem()).getPart(stack);
			if(data.getPart().getAttribute(InventoryAttribute.class) != null || data.getPart().getAttribute(ContainerAttribute.class) != null){
				return true;
			}
		}
		return false;
	}
	
}