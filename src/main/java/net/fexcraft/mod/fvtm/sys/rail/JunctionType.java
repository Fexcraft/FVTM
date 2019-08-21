package net.fexcraft.mod.fvtm.sys.rail;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public enum JunctionType {
	
	STRAIGHT, FORK_2, FORK_3, CROSSING;

	public boolean isCrossing(){
		return this == CROSSING;
	}

}
