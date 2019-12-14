package net.fexcraft.mod.fvtm.sys.rail;

/** Only usable on JunctionType.STRAIGHT which can hold signals. */
public enum EntryDirection {
	
	BOTH, FORWARD, BACKWARD;

	public boolean compatible(EntryDirection dir){
		if(this == BOTH) return true; else return this == dir;
	}

	public EntryDirection opposite(){
		return this == FORWARD ? BACKWARD : FORWARD;
	}

	public boolean isForward(){
		return this == FORWARD;
	}

	public boolean isBackward(){
		return this == BACKWARD;
	}

	public boolean isBoth(){
		return this == BOTH;
	}

	public int getTrackId(){
		return isBoth() ? 0 : isForward() ? 1 : 0;
	}

}
