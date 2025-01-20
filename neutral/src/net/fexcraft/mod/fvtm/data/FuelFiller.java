package net.fexcraft.mod.fvtm.data;

import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;
import net.fexcraft.mod.uni.tag.TagCW;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class FuelFiller {

	public long converted;
	public long stored;
	public IDL fluid;
	public Fuel selected;

	public FuelFiller(){
		selected = FvtmRegistry.FUELS.get(0);
		fluid = IDLManager.getIDLCached("minecraft:lava");
	}

	public TagCW save(){
		TagCW com = TagCW.create();
		com.set("fuel", selected.getIDS());
		com.set("stored", stored);
		com.set("converted", converted);
		com.set("fluid", fluid.colon());
		return com;
	}

	public void load(TagCW com){
		selected = FvtmRegistry.getFuel(com.getString("fuel"));
		if(selected == null) selected = FvtmRegistry.FUELS.get(0);
		stored = com.getLong("stored");
		converted = com.getLong("converted");
		fluid = IDLManager.getIDLCached("fluid");
	}

	public void update(){
		//
	}

	public static interface FuelFillerContainer {

		public FuelFiller getFuelFiller();

	}

}
