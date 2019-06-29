package net.fexcraft.mod.fvtm.sys.legacy;

public enum KeyPress {
	
	ACCELERATE, DECELERATE, TURN_LEFT, TURN_RIGHT, BRAKE, ENGINE, DISMOUNT,
	INVENTORY, DOORS, SCRIPTS, LIGHTS, COUPLER_FRONT, COUPLER_REAR,
	MOUSE_MAIN, MOUSE_RIGHT;
	
	public boolean dismount(){
		return this == DISMOUNT;
	}
	
	public boolean scripts(){
		return this == SCRIPTS;
	}

}
