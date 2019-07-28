package net.fexcraft.mod.fvtm.data;

import net.fexcraft.lib.common.math.RGB;

public enum InventoryType {
	
	ITEM, FLUID, ENERGY, CONTAINER;

	public String getUnitSuffix(){
		switch(this){
			case CONTAINER: return "CNTNRS";
			case ENERGY: return "FE";
			case FLUID: return "mB";
			case ITEM: return "stacks";
			default: return "";
		}
	}

	public RGB getColor(){
		switch(this){
			case CONTAINER: return new RGB(RGB.RED);
			case ENERGY: return new RGB(RGB.GREEN);
			case FLUID: return new RGB(RGB.BLUE);
			case ITEM: return new RGB(RGB.BLACK);
			default: return new RGB(127, 127, 127);
		}
	}

}
