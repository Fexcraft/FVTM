package net.fexcraft.mod.fvtm.sys.rail;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public enum JunctionType {
	
	/** Junctions with 2 tracks or less. */
	STRAIGHT,
	/** Junctions with 3 tracks, 1st is IN, 2nd and 3d is OUT. */
	FORK_2,
	/** Junctions with 4 tracks, 1st is IN, 2nd, 3d and 4th are OUT. */
	FORK_3,
	/** Junctions with 4 tracks, 1st and 4th is IN, 2nd and 3d is OUT. */
	DOUBLE,
	/** Junctions with 4 tracks, acts as crossing, 1st <-> 2nd, 3rd <-> 4th. */
	CROSSING;

	public boolean isCrossing(){
		return this == CROSSING;
	}

	public boolean isSwitch(){
		return this == FORK_2 || this == FORK_3;
	}
	
	public boolean isDouble(){
		return this == DOUBLE;
	}

	/** Default method in case the type is missing in a Junction. */
	public static JunctionType byTracksAmount(int size){
		return size <= 2 ? JunctionType.STRAIGHT : size == 3 ? JunctionType.FORK_2 : JunctionType.CROSSING;
	}

}
