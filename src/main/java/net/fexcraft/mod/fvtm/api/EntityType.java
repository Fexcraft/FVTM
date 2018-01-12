package net.fexcraft.mod.fvtm.api;

public enum EntityType {

	NONE(0, "No Type"), //un-spawned
	INTERNAL(1, "INTERNAL"),
	PROTOTYPE(2, "PROTOTYPE"),
	MTS(3, "MC Trans. Sim."), //if it ever get's that far
	TiM(4, "Trains In Motion"); //Trains-Only
	
	private int index;
	private String name;
	
	EntityType(int index, String name){
		this.index = index;
		this.name = name;
	}
	
	@Override
	public final String toString(){
		return this.name().toLowerCase();
	}
	
	public final EntityType fromString(String string){
		if(string != null && !string.equals("")){
			for(EntityType type : values()){
				if(type.name().equalsIgnoreCase(string)){
					return type;
				}
			}
		}
		return NONE;
	}

	public static final EntityType byIndex(int i){
		for(EntityType type : values()){
			if(type.index() == i){
				return type;
			}
		}
		return NONE;
	}
	
	public final int index(){
		return index;
	}

	public final String getName(){ return name; }
	
}