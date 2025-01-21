package net.fexcraft.mod.fvtm.data;

import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.item.UniInventory;
import net.fexcraft.mod.uni.item.UniStack;
import net.fexcraft.mod.uni.tag.TagCW;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class FuelFiller {

	public UniInventory items;
	public long converted;
	public long stored;
	public IDL fluid;
	public Fuel selected;

	public FuelFiller(){
		selected = FvtmRegistry.FUELS.get(0);
		fluid = IDLManager.getIDLCached("minecraft:lava");
		items = UniInventory.create(2).stacksize(1);
		items.addValidator(1, (idx, stack) -> stack.getItem().direct() instanceof Fuel.FuelItem);
	}

	public TagCW save(){
		TagCW com = TagCW.create();
		com.set("fuel", selected.getIDS());
		com.set("stored", stored);
		com.set("converted", converted);
		com.set("fluid", fluid.colon());
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
		fluid = IDLManager.getIDLCached("fluid");
		for(int i = 0; i < 2; i++){
			if(!com.has("item" + i)) continue;
			items.set(i, UniStack.createStack(com.getCompound("item" + i)));
		}
	}

	public void update(){
		//
	}

	public static interface FuelFillerContainer {

		public FuelFiller getFuelFiller();

	}

}
