package net.fexcraft.mod.fvtm.event;

import net.fexcraft.mod.fvtm.sys.rail.Junction;
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

	public static class JunctionEvent extends RailEvents {
		
		private Junction junction;
		
		private JunctionEvent(RailSys system, Junction junction){
			super(system);
			this.junction = junction;
		}
		
		public Junction getJunction(){
			return junction;
		}

		public static class JunctionAdded extends JunctionEvent {
			
			public JunctionAdded(RailSys system, Junction junction){
				super(system, junction);
			}
			
		}

		public static class JunctionRemoved extends JunctionEvent {
			
			public JunctionRemoved(RailSys system, Junction junction){
				super(system, junction);
			}
			
		}

		public static class JunctionLoaded extends JunctionEvent {
			
			public JunctionLoaded(RailSys system, Junction junction){
				super(system, junction);
			}
			
		}
		
	}

}
