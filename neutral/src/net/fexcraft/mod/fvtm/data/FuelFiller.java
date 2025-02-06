package net.fexcraft.mod.fvtm.data;

import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.inv.UniFluidTank;
import net.fexcraft.mod.uni.inv.UniInventory;
import net.fexcraft.mod.uni.inv.UniStack;
import net.fexcraft.mod.uni.tag.TagCW;
import org.apache.commons.lang3.tuple.Pair;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class FuelFiller {

	public static int tanksize = 16000;
	public static int fullenough = 15000;
	public UniInventory items;
	public UniFluidTank tank;
	public long converted;
	public long stored;
	public Fuel selected;
	private int ticks;

	public FuelFiller(){
		selected = FvtmRegistry.FUELS.get(0);
		items = UniInventory.create(2).stacksize(1);
		items.addValidator(1, (idx, stack) -> stack.getItem().direct() instanceof Fuel.FuelItem);
		tank = UniFluidTank.create(tanksize);
	}

	public TagCW save(){
		TagCW com = TagCW.create();
		com.set("fuel", selected.getIDS());
		com.set("stored", stored);
		com.set("converted", converted);
		com.set("tank", tank.save());
		for(int i = 0; i < 2; i++){
			if(items.get(i).empty()) continue;
			TagCW tag = TagCW.create();
			items.get(i).save(tag);
			com.set("item" + i, tag);
		}
		return com;
	}

	public void load(TagCW com){
		selected = FvtmRegistry.getFuel(com.getString("fuel"));
		if(selected == null) selected = FvtmRegistry.FUELS.get(0);
		stored = com.getLong("stored");
		converted = com.getLong("converted");
		tank.load(com.getCompound("tank"));
		tank.addValidator(stack -> selected.isSourceFluid(tank.getFluidFromStack(stack)));
		for(int i = 0; i < 2; i++){
			if(!com.has("item" + i)) continue;
			items.set(i, UniStack.createStack(com.getCompound("item" + i)));
		}
	}

	public void update(){
		if(ticks > 0){
			ticks--;
			return;
		}
		extractFromItem();
		convert();
		insertToItem();
		ticks = 20;
	}

	private void extractFromItem(){
		if(stored > fullenough) return;
		StackWrapper stack = items.get(0);
		if(!tank.isValid(stack)) return;
		Pair<StackWrapper, Boolean> res = tank.drainFrom(stack, 1000);
		if(res.getRight()) items.set(0, res.getLeft());
	}

	private void convert(){
		if(stored <= 0) return;

	}

	private void insertToItem(){
		if(converted <= 0) return;
		StackWrapper stack = items.get(1);
		if(stack.getItem().direct() instanceof Fuel.FuelItem == false) return;
		Fuel.FuelItem item = stack.getItem().local();
		Material mat = stack.getContent(ContentType.MATERIAL.item_type);
		Fuel fuel = item.getStoredFuelType(stack);
		if(!fuel.getPrimaryGroup().equals(selected.getPrimaryGroup())) return;
		int stored = item.getStoredFuelAmount(stack);
		if(stored >= mat.fuel_capacity) return;
		int cangiv = converted < 1000 ? (int)converted : 1000;
		int canfit = Math.min(mat.fuel_capacity - stored, cangiv);
		item.insertFuel(stack, canfit);
		converted -= canfit;
	}

	public static interface FuelFillerContainer {

		public FuelFiller getFuelFiller();

	}

}
