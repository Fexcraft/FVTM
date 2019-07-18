package net.fexcraft.mod.fvtm.data;

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

}
