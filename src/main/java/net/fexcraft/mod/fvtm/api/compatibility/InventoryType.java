package net.fexcraft.mod.fvtm.api.compatibility;

public enum InventoryType {
	
	ITEM("item", "stacks"), FLUID("fluid", "buckets"), ENERGY("energy", "FE"), FUEL("fuel", "units");
	private String id, units;
	
	InventoryType(String str, String u){
		this.id = str;
		this.units = u;
	}

	public static InventoryType fromString(String exists){
		for(InventoryType type : values()){
			if(type.id.equalsIgnoreCase(exists)){
				return type;
			}
		}
		return ITEM;
	}
	
	public String getUnitsName(){
		return units;
	}

	public String getName(){
		return id;
	}
	
}