package net.fexcraft.mod.fvtm.gui;

import net.fexcraft.mod.addons.gep.attributes.InventoryAttribute;
import net.fexcraft.mod.addons.gep.attributes.InventoryAttribute.InventoryAttributeData;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.api.Part.PartItem;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class TempInventorySlot extends Slot {
	
	private PartData partdata;

	public TempInventorySlot(IInventory inventory, int index, int xPosition, int yPosition, PartData data){
		super(inventory, index, xPosition, yPosition);
		this.partdata = data;
	}
	
	@Override
	public boolean isItemValid(ItemStack stack){
		if(stack.getItem() instanceof VehicleItem){
			return false;
		}
		if(stack.getItem() instanceof PartItem){
			PartData data = ((PartItem)stack.getItem()).getPart(stack);
			if(data.getAttributeData(InventoryAttributeData.class) != null && !data.getAttributeData(InventoryAttributeData.class).isEmpty()){
				return false;
			}
		}
        return partdata.getPart().getAttribute(InventoryAttribute.class).isItemValid(stack);
    }
	
}