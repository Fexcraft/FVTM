package net.fexcraft.mod.fvtm.gui.inv;

import net.fexcraft.mod.fvtm.data.inv.InvHandler;
import net.fexcraft.mod.fvtm.data.inv.InvHandlerItem.StackEntry;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.item.ContainerItem;
import net.fexcraft.mod.fvtm.item.PartItem;
import net.fexcraft.mod.fvtm.item.VehicleItem;
import net.fexcraft.mod.fvtm.util.function.InventoryFunction;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/** Temporary Inventory Slot */
public class InvSlot extends Slot {

    public static IInventory empty = new InventoryBasic("[null]", true, 0);
	protected UniItemInvContainer container;
	protected InvHandler handler;
	protected StackEntry entry;
	protected boolean full;
	protected int index;

    public InvSlot(UniItemInvContainer container, InvHandler handler, boolean full, int index, int xPosition, int yPosition){
        super(empty, index, xPosition, yPosition);
        this.entry = (this.handler = handler).getStacks().get(this.index = index);
        this.container = container;
        this.full = full;
    }

    @Override
    public boolean isItemValid(ItemStack stack){
        return false;
    }

	public static boolean isValid(InvHandler handler, ItemStack stack){
        if(stack.getItem() instanceof VehicleItem){
            return false;
        }
        if(stack.getItem() instanceof ContainerItem){
            return false;
        }
        if(stack.getItem() instanceof PartItem){
            PartData data = ((PartItem)stack.getItem()).getData(stack);
            if(data.hasFunction("fvtm:inventory") && !data.getFunction(InventoryFunction.class, "fvtm:inventory").inventory().getStacks().isEmpty()){
                return false;
            }
        }
        return handler.getFilter() == null ? true : handler.getFilter().isValid(stack);
	}
	
	@Override
    public ItemStack getStack(){
		if(full) return entry.genstack(64);
		else return entry.modstack();
    }

	@Override
    public boolean getHasStack(){
        return full ? entry.amount > 0 : entry.amount > entry.max();
    }

	@Override
    public void putStack(ItemStack stack){
        //
    }

	@Override
    public int getSlotStackLimit(){
        return entry.max();
    }

	@Override
    public ItemStack decrStackSize(int amount){
		ItemStack stack = entry.genstack(amount);
		entry.amount -= amount;
		if(entry.amount <= 0){
			handler.getStacks().remove(entry);
			container.populateSlots();
		}
        return stack;
    }

}
