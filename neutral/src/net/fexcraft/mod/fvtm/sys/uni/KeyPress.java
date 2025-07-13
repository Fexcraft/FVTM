package net.fexcraft.mod.fvtm.sys.uni;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public enum KeyPress {
	
	ACCELERATE, DECELERATE, TURN_LEFT, TURN_RIGHT, BRAKE, PBRAKE, ENGINE, DISMOUNT,
	INVENTORY, CONTROL, SCRIPTS, LIGHTS, COUPLER_FRONT, COUPLER_REAR, RESET,
	MOUSE_MAIN, MOUSE_RIGHT, TURN_UP, TURN_DOWN, ROLL_LEFT, ROLL_RIGHT, GEAR_UP, GEAR_DOWN;
	
	public boolean dismount(){
		return this == DISMOUNT;
	}
	
	public boolean scripts(){
		return this == SCRIPTS;
	}

	public boolean control(){
		return this == CONTROL;
	}

	public boolean inventory(){
		return this == INVENTORY;
	}
	
	public boolean toggable_input(){
		return this == MOUSE_MAIN || this == MOUSE_RIGHT || this == RESET;
	}

	public boolean driver_only(){
		return !dismount() && !scripts() && !control() && !inventory();// && !toggableInput();
	}

	public boolean synced(){
		return this == BRAKE || this == PBRAKE;
	}

	public boolean sync_state(){
		return this == BRAKE;
	}

	public boolean mouse_right(){
		return this == MOUSE_RIGHT;
	}

	public boolean mouse_main(){
		return this == MOUSE_MAIN;
	}

	public boolean serv_only(){
		return (dismount() || inventory() || scripts() || this == ENGINE || this == LIGHTS || this == COUPLER_FRONT || this == COUPLER_REAR);
	}

}
