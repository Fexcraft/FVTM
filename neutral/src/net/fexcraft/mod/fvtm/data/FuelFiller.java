package net.fexcraft.mod.fvtm.data;

import net.fexcraft.mod.fcl.FCL;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.FvtmRegistry;
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
	public float converted;
	public Fuel selected;
	private int ticks;

	public FuelFiller(){
		selected = FvtmRegistry.FUELS.get(0);
		items = UniInventory.create(2);//.stacksize(1);
		items.addValidator(1, (idx, stack) -> {
			Material mat = stack.getContent(ContentType.MATERIAL.item_type);
			return mat != null && mat.isFuelContainer();
		});
		tank = UniFluidTank.create(tanksize);
	}

	public TagCW save(){
		TagCW com = TagCW.create();
		com.set("fuel", selected.getIDS());
		//com.set("stored", stored);
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
		//stored = com.getFloat("stored");
		converted = com.getFloat("converted");
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
		if(tank.amount() > fullenough) return;
		StackWrapper stack = items.get(0);
		if(tank.isValid(stack)){
			Pair<StackWrapper, Boolean> res = tank.drainFrom(stack, 1000);
			if(res.getRight()) items.set(0, res.getLeft());
		}
		else if(selected.isSourceFluid(stack.getID())){
			if(converted == tanksize) return;
			stack.count(stack.count() - 1);
			items.set(0, stack);
			converted += 1000 * selected.getConversionRate(stack.getID());
			if(converted > tanksize) converted = tanksize;
		}
	}

	private void convert(){
		if(tank.amount() <= 0) return;
		float am = tank.amount() < 200 ? tank.amount() : 200;
		tank.drain((int)am, true);
		converted += am * selected.getConversionRate(tank.getFluid());
		if(converted > tanksize) converted = tanksize;
	}

	private void insertToItem(){
		if(converted <= 0) return;
		StackWrapper stack = items.get(1);
		Material mat = stack.getContent(ContentType.MATERIAL.item_type);
		if(mat == null || !mat.isFuelContainer()) return;
		Fuel fuel = Fuel.getStoredType(stack);
		if(fuel == null){
			Fuel.setStoredType(stack, selected);
		}
		else{
			if(!fuel.getIDS().equals(selected.getIDS())) return;
		}
		int stored = Fuel.getStoredAmount(stack);
		if(stored >= mat.fuel_capacity) return;
		int cangiv = converted < 1000 ? (int)converted : 1000;
		int canfit = Math.min(mat.fuel_capacity - stored, cangiv);
		Fuel.insert(stack, canfit);
		converted -= canfit;
	}

	public static interface FuelFillerContainer {

		public FuelFiller getFuelFiller();

	}

}
