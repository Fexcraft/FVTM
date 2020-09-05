package net.fexcraft.mod.fvtm.model;

import static net.fexcraft.mod.fvtm.model.DefaultPrograms.BLINKER_TOGGLE;

import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.data.root.Colorable;
import net.fexcraft.mod.fvtm.data.root.RenderCache;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.TurboList.ConditionalProgram;
import net.minecraft.entity.Entity;

public class ConditionalPrograms {
	
	public static class Lights extends ConditionalProgram {
		
		@Override
		public boolean test(TurboList list, @Nullable Entity ent, VehicleData data, @Nullable Colorable color, @Nullable String part, @Nullable RenderCache cache){
			return data.getLightsState();
		}
		
	}
	
	public static class FrontLights extends Lights {}
	
	public static class BackLights extends ConditionalProgram {
		
		@Override
		public boolean test(TurboList list, @Nullable Entity ent, VehicleData data, @Nullable Colorable color, @Nullable String part, @Nullable RenderCache cache){
			return data.getLightsState() || data.getThrottle() < -0.01;
		}
		
	}
	
	public static class RearLights extends BackLights {}
	
	public static class BrakeLights extends BackLights {}//TODO update when "break" marker exists
	
	public static class FogLights extends ConditionalProgram {
		
		@Override
		public boolean test(TurboList list, @Nullable Entity ent, VehicleData data, @Nullable Colorable color, @Nullable String part, @Nullable RenderCache cache){
			return data.getFogLightsState();
		}
		
	}
	
	public static class LongLights extends ConditionalProgram {
		
		@Override
		public boolean test(TurboList list, @Nullable Entity ent, VehicleData data, @Nullable Colorable color, @Nullable String part, @Nullable RenderCache cache){
			return data.getLongLightsState();
		}
		
	}
	
	public static class ReverseLights extends ConditionalProgram {
		
		@Override
		public boolean test(TurboList list, @Nullable Entity ent, VehicleData data, @Nullable Colorable color, @Nullable String part, @Nullable RenderCache cache){
			return data.getThrottle() < -0.01;
		}
		
	}
	
	public static class LightsFrontForward extends ConditionalProgram {
		
		@Override
		public boolean test(TurboList list, @Nullable Entity ent, VehicleData data, @Nullable Colorable color, @Nullable String part, @Nullable RenderCache cache){
			return data.getLightsState() && data.getAttribute("forward").getBooleanValue();
		}
		
	}
	
	public static class LightsFrontBackward extends ConditionalProgram {
		
		@Override
		public boolean test(TurboList list, @Nullable Entity ent, VehicleData data, @Nullable Colorable color, @Nullable String part, @Nullable RenderCache cache){
			return data.getLightsState() && !data.getAttribute("forward").getBooleanValue();
		}
		
	}
	
	public static class LightsRearForward extends ConditionalProgram {
		
		@Override
		public boolean test(TurboList list, @Nullable Entity ent, VehicleData data, @Nullable Colorable color, @Nullable String part, @Nullable RenderCache cache){
			return data.getLightsState() && data.getAttribute("forward").getBooleanValue();
		}
		
	}
	
	public static class LightsRearBackward extends ConditionalProgram {
		
		@Override
		public boolean test(TurboList list, @Nullable Entity ent, VehicleData data, @Nullable Colorable color, @Nullable String part, @Nullable RenderCache cache){
			return data.getLightsState() && !data.getAttribute("forward").getBooleanValue();
		}
		
	}
	
	public static class TurnSignalLeft extends ConditionalProgram {
		
		@Override
		public boolean test(TurboList list, @Nullable Entity ent, VehicleData data, @Nullable Colorable color, @Nullable String part, @Nullable RenderCache cache){
			return BLINKER_TOGGLE && (data.getTurnLightLeft() || data.getWarningLights());
		}
		
	}
	
	public static class TurnSignalRight extends ConditionalProgram {
		
		@Override
		public boolean test(TurboList list, @Nullable Entity ent, VehicleData data, @Nullable Colorable color, @Nullable String part, @Nullable RenderCache cache){
			return BLINKER_TOGGLE && (data.getTurnLightRight() || data.getWarningLights());
		}
		
	}
	
	public static class WarningLights extends ConditionalProgram {
		
		@Override
		public boolean test(TurboList list, @Nullable Entity ent, VehicleData data, @Nullable Colorable color, @Nullable String part, @Nullable RenderCache cache){
			return BLINKER_TOGGLE && data.getWarningLights();
		}
		
	}
	
	public static class IndicatorLightLeft extends TurnSignalLeft {}
	public static class IndicatorLightRight extends TurnSignalRight {}
	
	public static class BackLightsSignalLeft extends ConditionalProgram {
		
		@Override
		public boolean test(TurboList list, @Nullable Entity ent, VehicleData data, @Nullable Colorable color, @Nullable String part, @Nullable RenderCache cache){
			if(data.getTurnLightLeft() || data.getWarningLights()) return BLINKER_TOGGLE;
			else return data.getLightsState() || data.getThrottle() < -0.01;
		}
		
	}
	
	public static class BackLightsSignalRight extends ConditionalProgram {
		
		@Override
		public boolean test(TurboList list, @Nullable Entity ent, VehicleData data, @Nullable Colorable color, @Nullable String part, @Nullable RenderCache cache){
			if(data.getTurnLightRight() || data.getWarningLights()) return BLINKER_TOGGLE;
			else return data.getLightsState() || data.getThrottle() < -0.01;
		}
		
	}
	
	public static class TailLightsSignalLeft extends BackLightsSignalLeft {}
	public static class TailLightsSignalRight extends BackLightsSignalRight {}
	
	public static class IDSpecific extends ConditionalProgram {
		
		private String group;
		
		public IDSpecific(String id){ this.group = id; }
		
		@Override
		public boolean test(TurboList list, @Nullable Entity ent, VehicleData data, @Nullable Colorable color, @Nullable String part, @Nullable RenderCache cache){
			return part.equals(group);
		}
		
	}
	
	public static class IDSpecificArray extends ConditionalProgram {
		
		private String[] groups;
		
		public IDSpecificArray(String... ids){ this.groups = ids; }
		
		@Override
		public boolean test(TurboList list, @Nullable Entity ent, VehicleData data, @Nullable Colorable color, @Nullable String part, @Nullable RenderCache cache){
			for(String str : groups) if(str.equals(part)) return true;
			return false;
		}
		
	}

}
