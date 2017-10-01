package net.fexcraft.mod.fvtm.gui;

import net.fexcraft.mod.addons.gep.attributes.EngineAttribute;
import net.fexcraft.mod.fvtm.api.Fuel;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class FuelSlot extends Slot {
	
	private Fuel fuel;

	public FuelSlot(IInventory inventory, int index, int xPosition, int yPosition, VehicleData data){
		super(inventory, index, xPosition, yPosition);
		this.fuel = data.getPart("engine").getPart().getAttribute(EngineAttribute.class).getFuelType();
	}
	
	@Override
	public boolean isItemValid(ItemStack stack){
		return this.fuel.isValidFuelContainer(stack);
    }
	
}