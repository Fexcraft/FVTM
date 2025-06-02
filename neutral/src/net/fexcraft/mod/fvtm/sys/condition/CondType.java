package net.fexcraft.mod.fvtm.sys.condition;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public enum CondType {

	ATTRIBUTE("attribute"),
	PART_FUNC("part_func"),
	WORLDTIME("world_time"),
	BLOCKSTATE("blockstate"),
	TRACK_FROM("track_from"),
	MULTI("multi"),
	CUSTOM("custom"),
	//STATIC("static"),
	;

	public final String key;

	CondType(String ky){
		key = ky;
	}

	public static CondType parse(String type){
		for(CondType cond : values()){
			if(cond.key.equals(type)) return cond;
		}
		return CUSTOM;
	}

}
