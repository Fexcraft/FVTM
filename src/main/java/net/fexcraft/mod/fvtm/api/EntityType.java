package net.fexcraft.mod.fvtm.api;

public enum EntityType {
	
	NONE(0), //un-spawned
	INTERNAL(1),
	//FLANSMOD(1), //Flansmod Re-Minus
	MTS(2), //if it ever get's that far
	TiM(3); //Trains-Only
	
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
				if(type.name().toLowerCase().equals(string.toLowerCase())){
					return type;
				}
			}
		}
		return NONE;
	}
	
	public final int index(){
		return index;
	}
	
}