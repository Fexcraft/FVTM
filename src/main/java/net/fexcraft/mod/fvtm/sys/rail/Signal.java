package net.fexcraft.mod.fvtm.sys.rail;

/**
 * For "OpenTTD"-styled signals.
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public enum Signal {
	
	TWO_WAY_BLOCK(Type.BLOCK),
	ONE_WAY_BLOCK(Type.BLOCK),
	TWO_WAY_PATH(Type.PATH),
	ONE_WAY_PATH(Type.PATH);
	
	public final Type type;
	
	Signal(Type type){ this.type = type; }
	
	public static enum Type { BLOCK, PATH; }

}
