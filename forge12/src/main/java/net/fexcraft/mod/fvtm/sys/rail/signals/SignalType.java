package net.fexcraft.mod.fvtm.sys.rail.signals;

/**
 * For "OpenTTD"-styled signals.
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public enum SignalType {
	
	TWO_WAY_BLOCK(Kind.BLOCK, false),
	ONE_WAY_BLOCK(Kind.BLOCK, true),
	TWO_WAY_PATH(Kind.PATH, false),
	ONE_WAY_PATH(Kind.PATH, true),
	CONTROLLED(Kind.CUSTOM, null),
	PROGRAMMED(Kind.CUSTOM, null),
	;
	
	public final Kind type;
	public Boolean oneway;
	
	SignalType(Kind type, Boolean bool){ this.oneway = bool; this.type = type; }
	
	public static enum Kind { BLOCK, PATH, CUSTOM; }

	public boolean is(Kind custom){
		return type == custom;
	}

	public boolean isOneWay(){
		return oneway == null ? false : oneway;
	}

}
