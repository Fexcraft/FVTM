package net.fexcraft.mod.fvtm.event;

import net.fexcraft.mod.fvtm.sys.rail.RailSys;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.Event;

public class RailEvents extends Event {
	
	private RailSys system;
	
	private RailEvents(RailSys system){
		this.system = system;
	}
	
	public RailSys getSystem(){
		return system;
	}
	
	public World getWorld(){
		return system.getWorld();
	}

}
