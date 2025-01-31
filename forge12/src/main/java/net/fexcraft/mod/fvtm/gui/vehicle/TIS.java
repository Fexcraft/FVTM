package net.fexcraft.mod.fvtm.gui.vehicle;

import net.fexcraft.mod.fvtm.data.inv.InvHandler;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.item.ContainerItem;
import net.fexcraft.mod.fvtm.item.PartItem;
import net.fexcraft.mod.fvtm.item.VehicleItem;
import net.fexcraft.mod.fvtm.function.part.InventoryFunction;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/** Temporary Inventory Slot */
public class TIS extends Slot {
	
	protected InvHandler handler;

    public TIS(InvHandler handler, int index, int xPosition, int yPosition){
        super(new TIFI(handler), index, xPosition, yPosition);
        this.handler = handler;
    }

    @Override
    public boolean isItemValid(ItemStack stack){
        if(stack.getItem() instanceof VehicleItem){
            return false;
        }
        if(stack.getItem() instanceof ContainerItem){
            return false;
        }
        if(stack.getItem() instanceof PartItem){
            PartData data = ((PartItem)stack.getItem()).getDataFromTag(stack.getTagCompound());
            if(data.hasFunction("fvtm:inventory")){//TODO && !data.getFunction(InventoryFunction.class, "fvtm:inventory").inventory().getStacks().isEmpty()){
                return false;
            }
        }
        return handler.getFilter().isValid(stack);
    }

}
