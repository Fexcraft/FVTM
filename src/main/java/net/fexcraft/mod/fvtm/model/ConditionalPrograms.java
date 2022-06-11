package net.fexcraft.mod.fvtm.model;

import static net.fexcraft.mod.fvtm.model.DefaultPrograms.BLINKER_TOGGLE;
import static net.fexcraft.mod.fvtm.model.ModelGroup.COND_PROGRAMS;

import net.fexcraft.mod.fvtm.block.generated.SignalTileEntity;
import net.fexcraft.mod.fvtm.block.generated.SwitchTileEntity;
import net.fexcraft.mod.fvtm.data.root.Model.ModelRenderData;
import net.fexcraft.mod.fvtm.model.ModelGroup.ConditionalProgram;
import net.fexcraft.mod.fvtm.sys.condition.Condition.Conditional;
import net.fexcraft.mod.fvtm.sys.condition.ConditionRegistry;
import net.fexcraft.mod.fvtm.sys.uni.GenericVehicle;

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
			return data.vehicle.getLightsState() || data.vehicle.getThrottle() < -0.01 || (data.entity != null && ((GenericVehicle)data.entity).isBraking());//TODO rear+brake lights instead
		}
		
	}
	
	public static class RearLights extends BackLights {}
	
	public static class BrakeLights extends ConditionalProgram {
		
		@Override
		public boolean test(ModelGroup list, ModelRenderData data){
			return ((GenericVehicle)data.entity).isBraking();
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
			return data.vehicle.getLightsState() && data.vehicle.getAttribute("forward").boolean_value();
		}
		
	}
	
	public static class LightsBackward extends ConditionalProgram {
		
		@Override
		public boolean test(ModelGroup list, ModelRenderData data){
			return data.vehicle.getLightsState() && !data.vehicle.getAttribute("forward").boolean_value();
		}
		
	}
	
	public static class TurnSignalLeft extends ConditionalProgram {
		
		@Override
		public boolean test(ModelGroup list, ModelRenderData data){
			return BLINKER_TOGGLE && (data.vehicle.getTurnLightLeft() || data.vehicle.getWarningLights());
		}
		
	}
	
	public static class TurnSignalRight extends ConditionalProgram {
		
		@Override
		public boolean test(ModelGroup list, ModelRenderData data){
			return BLINKER_TOGGLE && (data.vehicle.getTurnLightRight() || data.vehicle.getWarningLights());
		}
		
	}
	
	public static class WarningLights extends ConditionalProgram {
		
		@Override
		public boolean test(ModelGroup list, ModelRenderData data){
			return BLINKER_TOGGLE && data.vehicle.getWarningLights();
		}
		
	}
	
	public static class IndicatorLightLeft extends TurnSignalLeft {}
	public static class IndicatorLightRight extends TurnSignalRight {}
	
	public static class BackLightsSignalLeft extends ConditionalProgram {
		
		@Override
		public boolean test(ModelGroup list, ModelRenderData data){
			if(data.vehicle.getTurnLightLeft() || data.vehicle.getWarningLights()) return BLINKER_TOGGLE;
			else return data.vehicle.getLightsState() || data.vehicle.getThrottle() < -0.01;
		}
		
	}
	
	public static class BackLightsSignalRight extends ConditionalProgram {
		
		@Override
		public boolean test(ModelGroup list, ModelRenderData data){
			if(data.vehicle.getTurnLightRight() || data.vehicle.getWarningLights()) return BLINKER_TOGGLE;
			else return data.vehicle.getLightsState() || data.vehicle.getThrottle() < -0.01;
		}
		
	}
	
	public static class TailLightsSignalLeft extends BackLightsSignalLeft {}
	public static class TailLightsSignalRight extends BackLightsSignalRight {}
	
	public static class IDSpecific extends ConditionalProgram {
		
		private String group;
		
		public IDSpecific(String id){ this.group = id; }
		
		@Override
		public boolean test(ModelGroup list, ModelRenderData data){
			return data.part_category.equals(group);
		}
		
	}
	
	public static class IDSpecificArray extends ConditionalProgram {
		
		private String[] groups;
		
		public IDSpecificArray(String... ids){ this.groups = ids; }
		
		@Override
		public boolean test(ModelGroup list, ModelRenderData data){
			for(String str : groups) if(str.equals(data.part_category)) return true;
			return false;
		}
		
	}
	
	public static class SignalState extends ConditionalProgram {

		@Override
		public boolean test(ModelGroup list, ModelRenderData data){
			return data.tile != null && ((SignalTileEntity)data.tile).getSignalState() > 0;
		}
		
	}
	
	public static class SwitchFork2State extends ConditionalProgram {

		@Override
		public boolean test(ModelGroup list, ModelRenderData data){
			return data.tile != null && ((SwitchTileEntity)data.tile).getSwitch0State();
		}
		
	}
	
	public static class SwitchFork3State extends ConditionalProgram {
		
		private int tracked;

		public SwitchFork3State(int tracked){
			this.tracked = tracked;
		}

		@Override
		public boolean test(ModelGroup list, ModelRenderData data){
			return data.tile != null && ((SwitchTileEntity)data.tile).getSwitch2State() == tracked;
		}
		
	}
	
	public static class SwitchDoubleState extends ConditionalProgram {
		
		private boolean switch0, switch1;

		public SwitchDoubleState(boolean switch0, boolean switch1){
			this.switch0 = switch0;
			this.switch1 = switch1;
		}

		@Override
		public boolean test(ModelGroup list, ModelRenderData data){
			return data.tile != null && ((SwitchTileEntity)data.tile).isDoubleSwitchState(switch0, switch1);
		}
		
	}
	
	public static class SwitchDoubleStateSide extends ConditionalProgram {
		
		private boolean side, state;

		public SwitchDoubleStateSide(boolean side, boolean state){
			this.side = side;
			this.state = state;
		}

		@Override
		public boolean test(ModelGroup list, ModelRenderData data){
			return data.tile != null && ((SwitchTileEntity)data.tile).isDoubleSwitchStateOnSide(side, state);
		}
		
	}
	
	public static class ConditionBased extends ConditionalProgram {
		
		protected Conditional cond;
		
		public ConditionBased(String condition){
			cond = ConditionRegistry.get(condition);
		}
		
		@Override
		public boolean test(ModelGroup list, ModelRenderData data){
			return cond.isMet(data);
		}
		
	}

}
