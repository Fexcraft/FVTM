package net.fexcraft.mod.fvtm.sys.legacy;

public enum KeyPress {
	
	ACCELERATE, DECELERATE, TURN_LEFT, TURN_RIGHT, BRAKE, ENGINE, DISMOUNT,
	INVENTORY, DOORS, SCRIPTS, LIGHTS, COUPLER_FRONT, COUPLER_REAR, OTHER,
	MOUSE_MAIN, MOUSE_RIGHT, TURN_UP, TURN_DOWN, ROLL_LEFT, ROLL_RIGHT;
	
	public boolean dismount(){
		return this == DISMOUNT;
	}
	
	public boolean scripts(){
		return this == SCRIPTS;
	}

}
