package net.fexcraft.mod.fvtm.sys.condition;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public enum CondMode {

	EQUAL("=="),
	NEQUAL("!="),
	LEQUAL("<="),
	GEQUAL(">="),
	LESS("<"),
	GREATER(">"),
	NUMB_EQUAL("n="),
	NUMB_NEQUAL("n!"),
	BOOL_EQUAL("b="),
	BOOL_NEQUAL("b!"),
	AND("&&"),
	ANN("&!"),
	OR("||"),
	;

	public final String key;

	CondMode(String ky){
		key = ky;
	}

	public static CondMode parse(String mode){
		for(CondMode cm : values()){
			if(cm.key.equals(mode) || cm.name().equals(mode)) return cm;
		}
		return EQUAL;
	}

	public boolean equal(){
		return this == EQUAL || this == BOOL_EQUAL || this == NUMB_EQUAL;
	}

	public boolean nequal(){
		return this == NEQUAL || this == BOOL_NEQUAL || this == NUMB_NEQUAL;
	}

}
