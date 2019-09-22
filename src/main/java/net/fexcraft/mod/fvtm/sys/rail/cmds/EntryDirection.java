package net.fexcraft.mod.fvtm.sys.rail.cmds;

/** Only usable on JunctionType.STRAIGHT which can hold signals. */
public enum EntryDirection {
	
	BOTH, FORWARD, BACKWARD;

	public boolean compatible(EntryDirection dir){
		if(this == BOTH) return true; else return this == dir;
	}

}
