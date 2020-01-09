package net.fexcraft.mod.fvtm.sys.legacy;

public enum KeyPress {
	
	ACCELERATE, DECELERATE, TURN_LEFT, TURN_RIGHT, BRAKE, ENGINE, DISMOUNT,
	INVENTORY, TOGGABLES, SCRIPTS, LIGHTS, COUPLER_FRONT, COUPLER_REAR, RESET,
	MOUSE_MAIN, MOUSE_RIGHT, TURN_UP, TURN_DOWN, ROLL_LEFT, ROLL_RIGHT;
	
	public boolean dismount(){
		return this == DISMOUNT;
	}
	
	public boolean scripts(){
		return this == SCRIPTS;
	}

	public boolean toggables(){
		return this == TOGGABLES;
	}

	public boolean inventory(){
		return this == INVENTORY;
	}
	
	public boolean toggableInput(){
		return this == MOUSE_MAIN || this == MOUSE_RIGHT || this == RESET;
	}

	public boolean driverOnly(){
		return !dismount() && !scripts() && !toggables() && !inventory();// && !toggableInput();
	}

}
