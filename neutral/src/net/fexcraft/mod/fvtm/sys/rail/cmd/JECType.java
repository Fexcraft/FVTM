package net.fexcraft.mod.fvtm.sys.rail.cmd;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public enum JECType {
	
	SIGNAL_WAIT(true, 20),//check if signal changed once per second
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
	
	JECType(boolean bool, int interval){
		this.fortrain = bool;
		this.interval = interval;
	}

	public Class<? extends JEC> getJCClass(){
		switch(this){
			case SET_SIGNAL: return CMD_SetSignal.class;
			case SET_STATE: return CMD_SetSwitch.class;
			case SIGNAL_WAIT: return CMD_SignalWait.class;
			default: return null;
		}
	}
	
}
