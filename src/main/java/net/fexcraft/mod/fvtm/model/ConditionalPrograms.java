package net.fexcraft.mod.fvtm.model;

import static net.fexcraft.mod.fvtm.model.DefaultPrograms.BLINKER_TOGGLE;

import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.block.generated.SignalTileEntity;
import net.fexcraft.mod.fvtm.block.generated.SwitchTileEntity;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.root.Colorable;
import net.fexcraft.mod.fvtm.data.root.RenderCache;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.TurboList.ConditionalProgram;
import net.fexcraft.mod.fvtm.sys.condition.Condition.Conditional;
import net.fexcraft.mod.fvtm.sys.condition.ConditionRegistry;
import net.fexcraft.mod.fvtm.sys.uni.GenericVehicle;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;

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
			return data.getLightsState() || data.getThrottle() < -0.01 || (ent != null && ((GenericVehicle)ent).isBraking());//TODO rear+brake lights instead
		}
		
	}
	
	public static class RearLights extends BackLights {}
	
	public static class BrakeLights extends ConditionalProgram {
		
		@Override
		public boolean test(TurboList list, @Nullable Entity ent, VehicleData data, @Nullable Colorable color, @Nullable String part, @Nullable RenderCache cache){
			return ((GenericVehicle)ent).isBraking();
		}
		
	}
	
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
			return data.getLightsState() && data.getAttribute("forward").boolean_value();
		}
		
	}
	
	public static class LightsFrontBackward extends ConditionalProgram {
		
		@Override
		public boolean test(TurboList list, @Nullable Entity ent, VehicleData data, @Nullable Colorable color, @Nullable String part, @Nullable RenderCache cache){
			return data.getLightsState() && !data.getAttribute("forward").boolean_value();
		}
		
	}
	
	public static class LightsRearForward extends ConditionalProgram {
		
		@Override
		public boolean test(TurboList list, @Nullable Entity ent, VehicleData data, @Nullable Colorable color, @Nullable String part, @Nullable RenderCache cache){
			return data.getLightsState() && data.getAttribute("forward").boolean_value();
		}
		
	}
	
	public static class LightsRearBackward extends ConditionalProgram {
		
		@Override
		public boolean test(TurboList list, @Nullable Entity ent, VehicleData data, @Nullable Colorable color, @Nullable String part, @Nullable RenderCache cache){
			return data.getLightsState() && !data.getAttribute("forward").boolean_value();
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
	
	public static class SignalState extends ConditionalProgram {

		@Override
		public boolean test(TurboList list, @Nullable TileEntity tile, BlockData data, @Nullable RenderCache cache){
			return tile != null && ((SignalTileEntity)tile).getSignalState() > 0;
		}
		
	}
	
	public static class SwitchFork2State extends ConditionalProgram {

		@Override
		public boolean test(TurboList list, @Nullable TileEntity tile, BlockData data, @Nullable RenderCache cache){
			return tile != null && ((SwitchTileEntity)tile).getSwitch0State();
		}
		
	}
	
	public static class SwitchFork3State extends ConditionalProgram {
		
		private int tracked;

		public SwitchFork3State(int tracked){
			this.tracked = tracked;
		}

		@Override
		public boolean test(TurboList list, @Nullable TileEntity tile, BlockData data, @Nullable RenderCache cache){
			return tile != null && ((SwitchTileEntity)tile).getSwitch2State() == tracked;
		}
		
	}
	
	public static class SwitchDoubleState extends ConditionalProgram {
		
		private boolean switch0, switch1;

		public SwitchDoubleState(boolean switch0, boolean switch1){
			this.switch0 = switch0;
			this.switch1 = switch1;
		}

		@Override
		public boolean test(TurboList list, @Nullable TileEntity tile, BlockData data, @Nullable RenderCache cache){
			return tile != null && ((SwitchTileEntity)tile).isDoubleSwitchState(switch0, switch1);
		}
		
	}
	
	public static class SwitchDoubleStateSide extends ConditionalProgram {
		
		private boolean side, state;

		public SwitchDoubleStateSide(boolean side, boolean state){
			this.side = side;
			this.state = state;
		}

		@Override
		public boolean test(TurboList list, @Nullable TileEntity tile, BlockData data, @Nullable RenderCache cache){
			return tile != null && ((SwitchTileEntity)tile).isDoubleSwitchStateOnSide(side, state);
		}
		
	}
	
	public static class ConditionBased extends ConditionalProgram {
		
		protected Conditional cond;
		
		public ConditionBased(String condition){
			cond = ConditionRegistry.CONDITIONALS.get(condition);
		}
		
		@Override
		public boolean test(TurboList list, @Nullable Entity ent, VehicleData data, @Nullable Colorable color, @Nullable String part, @Nullable RenderCache cache){
			return cond.isMet((GenericVehicle)ent, null, data, null, null, null, part, list, cache);
		}
		
	}

}
