package net.fexcraft.mod.fvtm.sys.rail;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public enum JuncType {
	
	/** Junctions with 2 tracks or fewer. */
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

	public boolean isFork2(){
		return this == FORK_2;
	}

	public boolean isFork3(){
		return this == FORK_3;
	}
	
	public boolean isDouble(){
		return this == DOUBLE;
	}

	/** Default method in case the type is missing in a Junction. */
	public static JuncType byTracksAmount(int size){
		return size <= 2 ? JuncType.STRAIGHT : size == 3 ? JuncType.FORK_2 : JuncType.CROSSING;
	}

	public boolean isStraight(){
		return this == STRAIGHT;
	}

	/*public static JuncType fromAddonBlock(Block block){
		if(block instanceof DBSW_4ROT_TE) return DOUBLE;
		if(block instanceof F2SW_4ROT_TE) return FORK_2;
		if(block instanceof F3SW_4ROT_TE) return FORK_3;
		return STRAIGHT;
	}*/

	public boolean is4Track(){
		return this == CROSSING || this == DOUBLE || this == FORK_3;
	}

	public boolean is3Track(){
		return this == FORK_2;
	}

}
