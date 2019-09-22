package net.fexcraft.mod.fvtm.sys.rail.cmds;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public enum JCType {
	
	SIGNAL_WAIT(true, 20),//check if signal changed once per second
	GOTO(true, -1),//path finding, only search if in need
	REVERSE(true, 0),//apply instantly, remove command afterwards
	STOP(true, 0),//apply instantly (decrease throttle to 0), remove command afterwards
	WAIT(true, 20),//check every second if time passed
	ADJUST_SPEED(true, 1),//apply instantly, remove command afterwards
	CHANGE_ATTRIBUTE(true, 20),//check once per second (?), remove command afterwards
	//
	SET_STATE(false, -1),//triggered when needed
	SET_SIGNAL(false, -1),//triggered when needed
	;
	
	public final int interval;
	public final boolean fortrain;
	
	JCType(boolean bool, int interval){
		this.fortrain = bool;
		this.interval = interval;
	}
	
}
