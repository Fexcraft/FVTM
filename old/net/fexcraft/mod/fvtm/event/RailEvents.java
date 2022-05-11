package net.fexcraft.mod.fvtm.event;

import net.fexcraft.mod.fvtm.sys.rail.RailSystem;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.Event;

public class RailEvents extends Event {
	
	private RailSystem system;
	
	private RailEvents(RailSystem system){
		this.system = system;
	}
	
	public RailSystem getSystem(){
		return system;
	}
	
	public World getWorld(){
		return system.getWorld();
	}

}
