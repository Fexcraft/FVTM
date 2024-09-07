package net.fexcraft.mod.fvtm.data.root;

import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;

import java.util.function.Consumer;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class LoopedSound {

	public static Consumer<LoopedSound> ACTIVATE = null;
	//
	public Sound sound;
	public VehicleInstance vehicle;
	public Object localsound;
	public boolean active;

	public LoopedSound(VehicleInstance inst, Sound snd){
		vehicle = inst;
		sound = snd;
	}

	public void start(){
		if(!active) ACTIVATE.accept(this);
		active = true;
	}

	public void stop(){
		active = false;
	}

}
