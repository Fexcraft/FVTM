package net.fexcraft.mod.fvtm.sys.uni;

import java.util.Arrays;
import java.util.List;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public enum KeyPress {

	//controls
	ACCELERATE("driver", "sync", "state"),
	DECELERATE("driver", "sync", "state"),
	TURN_LEFT("driver", "sync"),
	TURN_RIGHT("driver", "sync"),
	BRAKE("driver", "sync", "state"),
	PBRAKE("driver", "sync"),
	ENGINE("driver", "sync"),
	//general
	DISMOUNT("sync"),
	INVENTORY("sync"),
	CONTROL("sync"),
	SCRIPTS("sync"),
	//other
	LIGHTS("driver", "sync"),
	COUPLER_FRONT("driver", "sync"),
	COUPLER_REAR("driver", "sync"),
	//toggle inputs
	RESET("input"),
	MOUSE_MAIN("input"),
	MOUSE_RIGHT("input"),
	//arrow keys
	ROLL_LEFT("driver"),
	ROLL_RIGHT("driver"),
	GEAR_UP("driver"),
	GEAR_DOWN("driver");

	public final boolean toggle_input;
	public final boolean driver_only;
	public final boolean with_state;
	public final boolean sync;

	KeyPress(String... s){
		List<String> list = Arrays.asList(s);
		with_state = list.contains("state");
		sync = list.contains("sync");
		driver_only = list.contains("driver");
		toggle_input = list.contains("input");
	}

	public boolean send_serv(boolean driver){
		return sync && driver == driver_only;
	}
	
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

	public boolean mouse_right(){
		return this == MOUSE_RIGHT;
	}

	public boolean mouse_main(){
		return this == MOUSE_MAIN;
	}

}
