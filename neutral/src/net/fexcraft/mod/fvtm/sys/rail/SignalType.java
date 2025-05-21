package net.fexcraft.mod.fvtm.sys.rail;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public enum SignalType {

	NONE,
	AUTOMATIC,
	CONTROLLED,
	;

	public static SignalType parse(String str){
		return str == null || str.length() == 0 ? NONE : str.equals("auto") ? AUTOMATIC : CONTROLLED;
	}

	public String save(){
		return this == NONE ? null : this == AUTOMATIC ? "auto" : "con";
	}

	public boolean none(){
		return this == NONE;
	}

	public boolean auto(){
		return this == AUTOMATIC;
	}

}
