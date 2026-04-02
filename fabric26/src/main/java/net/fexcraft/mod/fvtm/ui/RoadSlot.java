package net.fexcraft.mod.fvtm.ui;

import net.fexcraft.mod.fvtm.sys.uni.FvtmWorld;
import net.fexcraft.mod.fvtm.util.CompatUtil;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;

public class RoadSlot extends Slot {

	private FvtmWorld world;
	private boolean road, any;

	public RoadSlot(Object[] args){
		this((FvtmWorld)args[0], (Container)args[1], (int)args[2], (int)args[3], (int)args[4], (boolean)args[5], (boolean)args[6]);
	}

	public RoadSlot(FvtmWorld world, Container inventory, int index, int x, int y, boolean road, boolean any){
		super(inventory, index, x, y);
		this.world = world;
		this.road = road;
		this.any = any;
	}

	@Override
	public boolean mayPlace(ItemStack stack){
		if(stack.getItem() instanceof BlockItem == false) return false;
		if(!any && (road || this.index == 0)){
			BlockItem iblock = (BlockItem)stack.getItem();
			return world.isFvtmRoad(iblock.getBlock().defaultBlockState()) || CompatUtil.isValidFurenikus(BuiltInRegistries.BLOCK.getKey(iblock.getBlock()).toString());
		}
		else return true;
	}

}
