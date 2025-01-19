package net.fexcraft.mod.fvtm.data;

import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.tag.TagCW;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class FuelFiller {

	public int converted;
	public int stored;
	public IDL fluid;
	public String category;
	public Fuel selected;

	public FuelFiller(){
		category = FvtmRegistry.FUELS.get(0).primary;
		selected = FvtmRegistry.FUELS.get(0);
	}

	public TagCW save(){
		TagCW com = TagCW.create();

		return com;
	}

	public void load(TagCW com){

	}

	public static interface FuelFillerContainer {

		public FuelFiller getFuelFiller();

	}

}
