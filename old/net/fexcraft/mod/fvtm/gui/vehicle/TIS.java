package net.fexcraft.mod.fvtm.gui.vehicle;

import net.fexcraft.mod.fvtm.data.container.ContainerData;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.item.ContainerItem;
import net.fexcraft.mod.fvtm.item.PartItem;
import net.fexcraft.mod.fvtm.item.VehicleItem;
import net.fexcraft.mod.fvtm.util.function.InventoryFunction;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/** Temporary Inventory Slot */
public class TIS extends Slot {

    private ContainerData containerdata;
    private PartData partdata;

    public TIS(IInventory inventory, int index, int xPosition, int yPosition, PartData data, ContainerData condata){
        super(inventory, index, xPosition, yPosition); this.partdata = data; this.containerdata = condata;
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
            PartData data = ((PartItem)stack.getItem()).getData(stack);
            if(data.hasFunction("fvtm:inventory") && !data.getFunction(InventoryFunction.class, "fvtm:inventory").getStacks().isEmpty()){
                return false;
            }
        }
        return partdata == null ? containerdata == null ? true : containerdata.getType().getContentFilter().isValid(containerdata, stack) : partdata.getFunction(InventoryFunction.class, "fvtm:inventory").isItemValid(stack);
    }

}
