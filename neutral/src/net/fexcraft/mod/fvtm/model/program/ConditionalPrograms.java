package net.fexcraft.mod.fvtm.model.program;

import static net.fexcraft.mod.fvtm.model.program.DefaultPrograms.SIGNAL_TOGGLE;
import static net.fexcraft.mod.fvtm.model.ModelGroup.COND_PROGRAMS;

import net.fexcraft.mod.fvtm.model.ModelGroup;
import net.fexcraft.mod.fvtm.model.ModelRenderData;
import net.fexcraft.mod.fvtm.model.Program;
import net.fexcraft.mod.fvtm.model.Program.ConditionalProgram;
import net.fexcraft.mod.fvtm.sys.condition.ConditionRegistry;
import net.fexcraft.mod.fvtm.sys.condition.Conditional;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ConditionalPrograms {
	
	public static void init(){
		COND_PROGRAMS.put("fvtm:lights", Lights.class);
		COND_PROGRAMS.put("fvtm:front_lights", FrontLights.class);
		COND_PROGRAMS.put("fvtm:back_lights", BackLights.class);
		COND_PROGRAMS.put("fvtm:brake_lights", BrakeLights.class);
		COND_PROGRAMS.put("fvtm:fog_lights", FogLights.class);
		COND_PROGRAMS.put("fvtm:long_lights", LongLights.class);
		COND_PROGRAMS.put("fvtm:reverse_lights", ReverseLights.class);
		COND_PROGRAMS.put("fvtm:lights_rail_forward", LightsForward.class);
		COND_PROGRAMS.put("fvtm:lights_rail_backward", LightsBackward.class);
		COND_PROGRAMS.put("fvtm:turn_signal_left", TurnSignalLeft.class);
		COND_PROGRAMS.put("fvtm:turn_signal_right", TurnSignalRight.class);
		COND_PROGRAMS.put("fvtm:warning_lights", WarningLights.class);
		COND_PROGRAMS.put("fvtm:back_lights_signal_left", BackLightsSignalLeft.class);
		COND_PROGRAMS.put("fvtm:back_lights_signal_right", BackLightsSignalRight.class);
		COND_PROGRAMS.put("fvtm:category_specific", IDSpecific.class);
		COND_PROGRAMS.put("fvtm:category_specific_array", IDSpecificArray.class);
	}

	public static class ConditionBased extends Program.ConditionalProgram {

		protected Conditional cond;

		public ConditionBased(String condition){
			cond = ConditionRegistry.get(condition);
		}

		@Override
		public boolean test(ModelGroup list, ModelRenderData data){
			return cond.isMet(data);
		}

	}

	
	public static class Lights extends ConditionalProgram {
		
		@Override
		public boolean test(ModelGroup list, ModelRenderData data){
			return data.vehicle.getLightsState();
		}
		
	}
	
	public static class FrontLights extends Lights {}
	
	public static class BackLights extends ConditionalProgram {
		
		@Override
		public boolean test(ModelGroup list, ModelRenderData data){
			return data.vehicle.getLightsState() || data.vehicle.getThrottle() < -0.01 || (data.vehent != null && data.vehent.isBraking());//TODO rear+brake lights instead
		}
		
	}
	
	public static class RearLights extends BackLights {}
	
	public static class BrakeLights extends ConditionalProgram {
		
		@Override
		public boolean test(ModelGroup list, ModelRenderData data){
			return data.vehent != null && data.vehent.isBraking();
		}
		
	}
	
	public static class FogLights extends ConditionalProgram {
		
		@Override
		public boolean test(ModelGroup list, ModelRenderData data){
			return data.vehicle.getFogLightsState();
		}
		
	}
	
	public static class LongLights extends ConditionalProgram {
		
		@Override
		public boolean test(ModelGroup list, ModelRenderData data){
			return data.vehicle.getLongLightsState();
		}
		
	}
	
	public static class ReverseLights extends ConditionalProgram {
		
		@Override
		public boolean test(ModelGroup list, ModelRenderData data){
			return data.vehicle.getThrottle() < -0.01;
		}
		
	}
	
	public static class LightsForward extends ConditionalProgram {
		
		@Override
		public boolean test(ModelGroup list, ModelRenderData data){
			return data.vehicle.getLightsState() && data.vehicle.getAttribute("forward").asBoolean();
		}
		
	}
	
	public static class LightsBackward extends ConditionalProgram {
		
		@Override
		public boolean test(ModelGroup list, ModelRenderData data){
			return data.vehicle.getLightsState() && !data.vehicle.getAttribute("forward").asBoolean();
		}
		
	}
	
	public static class TurnSignalLeft extends ConditionalProgram {
		
		@Override
		public boolean test(ModelGroup list, ModelRenderData data){
			return SIGNAL_TOGGLE[0] && (data.vehicle.getTurnLightLeft() || data.vehicle.getWarningLights());
		}
		
	}
	
	public static class TurnSignalRight extends ConditionalProgram {
		
		@Override
		public boolean test(ModelGroup list, ModelRenderData data){
			return SIGNAL_TOGGLE[0] && (data.vehicle.getTurnLightRight() || data.vehicle.getWarningLights());
		}
		
	}
	
	public static class WarningLights extends ConditionalProgram {
		
		@Override
		public boolean test(ModelGroup list, ModelRenderData data){
			return SIGNAL_TOGGLE[0] && data.vehicle.getWarningLights();
		}
		
	}
	
	public static class IndicatorLightLeft extends TurnSignalLeft {}
	public static class IndicatorLightRight extends TurnSignalRight {}
	
	public static class BackLightsSignalLeft extends ConditionalProgram {
		
		@Override
		public boolean test(ModelGroup list, ModelRenderData data){
			if(data.vehicle.getTurnLightLeft() || data.vehicle.getWarningLights()) return SIGNAL_TOGGLE[0];
			else return data.vehicle.getLightsState() || data.vehicle.getThrottle() < -0.01;
		}
		
	}
	
	public static class BackLightsSignalRight extends ConditionalProgram {
		
		@Override
		public boolean test(ModelGroup list, ModelRenderData data){
			if(data.vehicle.getTurnLightRight() || data.vehicle.getWarningLights()) return SIGNAL_TOGGLE[0];
			else return data.vehicle.getLightsState() || data.vehicle.getThrottle() < -0.01;
		}
		
	}
	
	public static class TailLightsSignalLeft extends BackLightsSignalLeft {}
	public static class TailLightsSignalRight extends BackLightsSignalRight {}
	
	public static class IDSpecific extends ConditionalProgram {
		
		private String group;
		
		public IDSpecific(){}
		
		public IDSpecific(String id){ this.group = id; }
		
		@Override
		public boolean test(ModelGroup list, ModelRenderData data){
			return data.part_category.equals(group);
		}
		
		@Override
		public Program parse(String[] args){
			return new IDSpecific(args[0]).transfer(this);
		}
		
	}
	
	public static class IDSpecificArray extends ConditionalProgram {
		
		private String[] groups;
		
		public IDSpecificArray(){}
		
		public IDSpecificArray(String... ids){ this.groups = ids; }
		
		@Override
		public boolean test(ModelGroup list, ModelRenderData data){
			for(String str : groups) if(str.equals(data.part_category)) return true;
			return false;
		}
		
		@Override
		public Program parse(String[] args){
			return new IDSpecificArray(args).transfer(this);
		}
		
	}

}
