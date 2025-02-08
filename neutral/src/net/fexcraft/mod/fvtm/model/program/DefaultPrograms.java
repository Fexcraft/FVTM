package net.fexcraft.mod.fvtm.model.program;

import net.fexcraft.lib.common.math.Time;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.model.ModelGroup;
import net.fexcraft.mod.fvtm.model.ModelRenderData;
import net.fexcraft.mod.fvtm.model.Program;
import net.fexcraft.mod.fvtm.model.RenderOrder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import static net.fexcraft.mod.fvtm.Config.BLINKER_INTERVAL;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class DefaultPrograms {

	public static boolean BLINKER_TOGGLE;
	public static Timer BLINKER_TIMER;
	public static Program GLOW;

	public static void init(){
		ModelGroup.PROGRAMS.add(new AlwaysGlow() {
			public boolean shouldGlow(ModelGroup list, ModelRenderData data){
				return true;
			}

			public String id(){
				return "fvtm:glow";
			}
		});
		ModelGroup.PROGRAMS.add(new AlwaysGlow() {
			public boolean shouldGlow(ModelGroup list, ModelRenderData data){
				return data.vehicle.getLightsState();
			}

			public String id(){
				return "fvtm:lights";
			}
		});
		ModelGroup.PROGRAMS.add(new AlwaysGlow() {
			public boolean shouldGlow(ModelGroup list, ModelRenderData data){
				return data.vehicle.getLightsState();
			}

			public String id(){
				return "fvtm:front_lights";
			}
		});
		ModelGroup.PROGRAMS.add(new AlwaysGlow() {
			public boolean shouldGlow(ModelGroup list, ModelRenderData data){
				return data.vehicle.getLightsState() || (data.vehent != null && data.vehent.isBraking());
			}

			public String id(){
				return "fvtm:back_lights";
			}
		});
		ModelGroup.PROGRAMS.add(new AlwaysGlow() {
			public boolean shouldGlow(ModelGroup list, ModelRenderData data){
				return data.vehicle.getFogLightsState();
			}

			public String id(){
				return "fvtm:fog_lights";
			}
		});
		ModelGroup.PROGRAMS.add(new AlwaysGlow() {
			public boolean shouldGlow(ModelGroup list, ModelRenderData data){
				return data.vehicle.getLongLightsState();
			}

			public String id(){
				return "fvtm:long_lights";
			}
		});
		ModelGroup.PROGRAMS.add(new AlwaysGlow() {
			public boolean shouldGlow(ModelGroup list, ModelRenderData data){
				return (data.entity != null && data.vehent.isBraking());
			}

			public String id(){
				return "fvtm:brake_lights";
			}
		});
		ModelGroup.PROGRAMS.add(new AlwaysGlow() {
			public boolean shouldGlow(ModelGroup list, ModelRenderData data){
				return data.vehicle.getThrottle() < -0.01;
			}

			public String id(){
				return "fvtm:reverse_lights";
			}
		});
		ModelGroup.PROGRAMS.add(new AlwaysGlow() {
			public boolean shouldGlow(ModelGroup list, ModelRenderData data){
				return BLINKER_TOGGLE && (data.vehicle.getTurnLightLeft() || data.vehicle.getWarningLights());
			}

			public String id(){
				return "fvtm:turn_signal_left";
			}
		});
		ModelGroup.PROGRAMS.add(new AlwaysGlow() {
			public boolean shouldGlow(ModelGroup list, ModelRenderData data){
				return BLINKER_TOGGLE && (data.vehicle.getTurnLightRight() || data.vehicle.getWarningLights());
			}

			public String id(){
				return "fvtm:turn_signal_right";
			}
		});
		ModelGroup.PROGRAMS.add(new AlwaysGlow() {
			public boolean shouldGlow(ModelGroup list, ModelRenderData data){
				return BLINKER_TOGGLE && data.vehicle.getWarningLights();
			}

			public String id(){
				return "fvtm:warning_lights";
			}
		});
		ModelGroup.PROGRAMS.add(new AlwaysGlow() {
			public boolean shouldGlow(ModelGroup list, ModelRenderData data){
				if(data.vehicle.getTurnLightLeft() || data.vehicle.getWarningLights()) return BLINKER_TOGGLE;
				else return data.vehicle.getLightsState() || data.vehicle.getThrottle() < -0.01;
			}

			public String id(){
				return "fvtm:back_lights_signal_left";
			}
		});
		ModelGroup.PROGRAMS.add(new AlwaysGlow() {
			public boolean shouldGlow(ModelGroup list, ModelRenderData data){
				if(data.vehicle.getTurnLightRight() || data.vehicle.getWarningLights()) return BLINKER_TOGGLE;
				else return data.vehicle.getLightsState() || data.vehicle.getThrottle() < -0.01;
			}

			public String id(){
				return "fvtm:back_lights_signal_right";
			}
		});
		ModelGroup.PROGRAMS.add(new AttributeLights("", false));
	}

	public static void setupBlinkerTimer(){
		if(BLINKER_TIMER != null) BLINKER_TIMER.cancel();
		FvtmLogger.debug("Setting up blinker-toggle timer.");
		LocalDateTime midnight = LocalDateTime.of(LocalDate.now(ZoneOffset.systemDefault()), LocalTime.MIDNIGHT);
		long mid = midnight.toInstant(ZoneOffset.UTC).toEpochMilli();
		long date = Time.getDate();
		while((mid += BLINKER_INTERVAL) < date) ;
		(BLINKER_TIMER = new Timer()).schedule(new TimerTask() {
			@Override
			public void run(){
				BLINKER_TOGGLE = !BLINKER_TOGGLE;
			}
		}, new Date(mid), BLINKER_INTERVAL);
	}

	public static abstract class AlwaysGlow implements Program {

		private boolean didglow;

		public AlwaysGlow(){
		}

		public abstract boolean shouldGlow(ModelGroup list, ModelRenderData data);

		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			if(!(didglow = shouldGlow(list, data))) return;
			GLOW.pre(list, data);
		}

		@Override
		public void post(ModelGroup list, ModelRenderData data){
			if(!didglow) return;
			GLOW.post(list, data);
		}

		@Override
		public String id(){
			return "fvtm:glow";
		}


		@Override
		public RenderOrder order(){
			return RenderOrder.BLENDED;
		}

	}

	public static abstract class AttributeBased implements Program {

		protected Attribute<?> attr;
		protected String attribute;

		public AttributeBased(String attr){
			attribute = attr;
		}

		@Override
		public void init(ModelGroup list){}

	}

	public static class AttributeLights extends AttributeBased {

		private boolean equals, did;

		public AttributeLights(String attr, boolean eq){
			super(attr);
			equals = eq;
		}

		@Override
		public String id(){ return "fvtm:attribute_lights"; }

		@Override
		public void pre(ModelGroup group, ModelRenderData data){
			attr = data.vehicle.getAttribute(attribute);
			if(attr == null) return;
			if(attr.asBoolean() != equals){
				GLOW.pre(group, data);
				did = true;
			}
		}

		@Override
		public void post(ModelGroup group, ModelRenderData data){
			if(did){
				GLOW.post(group, data);
				did = false;
			}
		}

		@Override
		public Program parse(String[] args){
			return new AttributeLights(args[0], args.length > 1 ? Boolean.parseBoolean(args[1]) : false);
		}

	}

}
