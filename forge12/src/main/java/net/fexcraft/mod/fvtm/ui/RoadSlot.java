package net.fexcraft.mod.fvtm.ui;

import net.fexcraft.mod.fvtm.sys.uni.FvtmWorld;
import net.fexcraft.mod.fvtm.util.CompatUtil;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RoadSlot extends Slot {

	private FvtmWorld world;
	private boolean road, any;

	public RoadSlot(Object[] args){
		this((FvtmWorld)args[0], (IInventory)args[1], (int)args[2], (int)args[3], (int)args[4], (boolean)args[5], (boolean)args[6]);
	}

	public RoadSlot(FvtmWorld world, IInventory inventory, int index, int xPosition, int yPosition, boolean road, boolean any){
		super(inventory, index, xPosition, yPosition);
		this.world = world;
		this.road = road;
		this.any = any;
	}

	@Override
	public boolean isItemValid(ItemStack stack){
		if(stack.getItem() instanceof ItemBlock == false) return false;
		if(!any && (road || this.getSlotIndex() == 0)){
			ItemBlock iblock = (ItemBlock)stack.getItem();
			return world.isFvtmRoad(iblock.getBlock().getDefaultState()) || CompatUtil.isValidFurenikus(iblock.getBlock().getRegistryName().toString());
		}
		else return true;
	}

}
