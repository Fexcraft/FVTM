package net.fexcraft.mod.fvtm.sys.rail;

/**
 * For "OpenTTD"-styled signals.
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public enum SignalType {
	
	TWO_WAY_BLOCK(Kind.BLOCK),
	ONE_WAY_BLOCK(Kind.BLOCK),
	TWO_WAY_PATH(Kind.PATH),
	ONE_WAY_PATH(Kind.PATH),
	CONTROLLED(Kind.CUSTOM),
	PROGRAMMED(Kind.CUSTOM),
	;
	
	public final Kind type;
	
	SignalType(Kind type){ this.type = type; }
	
	public static enum Kind { BLOCK, PATH, CUSTOM; }

	public boolean is(Kind custom){
		return type == custom;
	}

}
