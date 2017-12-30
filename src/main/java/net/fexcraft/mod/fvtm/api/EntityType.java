package net.fexcraft.mod.fvtm.api;

public enum EntityType {
	
	NONE(0), //un-spawned
	INTERNAL(1),
	PROTOTYPE(2),
	MTS(3), //if it ever get's that far
	TiM(4); //Trains-Only
	
	private int index;
	
	EntityType(int index){
		this.index = index;
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
	
}