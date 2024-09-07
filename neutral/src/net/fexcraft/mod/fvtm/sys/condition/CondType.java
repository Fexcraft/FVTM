package net.fexcraft.mod.fvtm.sys.condition;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public enum CondType {

	ATTRIBUTE("attribute"),
	PART_FUNC("part-func"),
	WORLDTIME("world-time"),
	BLOCKSTATE("blockstate"),
	MULTI("multi"),
	CUSTOM("custom"),
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
