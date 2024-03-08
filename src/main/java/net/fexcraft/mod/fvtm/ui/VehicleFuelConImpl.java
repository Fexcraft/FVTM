package net.fexcraft.mod.fvtm.ui;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.data.Fuel;
import net.fexcraft.mod.fvtm.gui.GenericIInventory;
import net.fexcraft.mod.fvtm.ui.vehicle.VehicleFuelCon;
import net.fexcraft.mod.uni.impl.SWI;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.EntityW;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class VehicleFuelConImpl extends VehicleFuelCon {

	private GenericIInventory inventory;
	private SWI wrapper = new SWI(ItemStack.EMPTY);

	public VehicleFuelConImpl(JsonMap map, EntityW player, V3I pos){
		super(map, player, pos);
		inventory = new GenericIInventory(null, 1, 1);
	}

	@Override
	public Object getInventory(){
		return inventory;
	}

	@Override
	public void onClosed(){
		inventory.closeInventory(player.local());
	}

	@Override
	public void setInventoryContent(int index, TagCW com){
		inventory.setInventorySlotContents(index, new ItemStack((NBTTagCompound)com.direct()));
	}

	@Override
	public StackWrapper getInventoryContent(int index){
		wrapper.stack = inventory.getStackInSlot(index);
		return wrapper;
	}

	@Override
	public boolean isInventoryEmpty(int at){
		return inventory.getStackInSlot(at).isEmpty();
	}

	@Override
	protected boolean isFuelItem(){
		return inventory.getStackInSlot(0).getItem() instanceof Fuel.FuelItem;
	}

	@Override
	protected Fuel.FuelItem getFuelItem(){
		return (Fuel.FuelItem)inventory.getStackInSlot(0).getItem();
	}

}
