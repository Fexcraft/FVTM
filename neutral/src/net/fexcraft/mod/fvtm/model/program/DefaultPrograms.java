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

import static net.fexcraft.mod.fvtm.Config.SIGNAL_INTERVAL;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class DefaultPrograms {

	public static boolean[] SIGNAL_TOGGLE = new boolean[4];
	public static Timer[] SIGNAL_TIMER = new Timer[4];
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
				return SIGNAL_TOGGLE[0] && (data.vehicle.getTurnLightLeft() || data.vehicle.getWarningLights());
			}

			public String id(){
				return "fvtm:turn_signal_left";
			}
		});
		ModelGroup.PROGRAMS.add(new AlwaysGlow() {
			public boolean shouldGlow(ModelGroup list, ModelRenderData data){
				return SIGNAL_TOGGLE[0] && (data.vehicle.getTurnLightRight() || data.vehicle.getWarningLights());
			}

			public String id(){
				return "fvtm:turn_signal_right";
			}
		});
		ModelGroup.PROGRAMS.add(new AlwaysGlow() {
			public boolean shouldGlow(ModelGroup list, ModelRenderData data){
				return SIGNAL_TOGGLE[0] && data.vehicle.getWarningLights();
			}

			public String id(){
				return "fvtm:warning_lights";
			}
		});
		ModelGroup.PROGRAMS.add(new AlwaysGlow() {
			public boolean shouldGlow(ModelGroup list, ModelRenderData data){
				if(data.vehicle.getTurnLightLeft() || data.vehicle.getWarningLights()) return SIGNAL_TOGGLE[0];
				else return data.vehicle.getLightsState() || data.vehicle.getThrottle() < -0.01;
			}

			public String id(){
				return "fvtm:back_lights_signal_left";
			}
		});
		ModelGroup.PROGRAMS.add(new AlwaysGlow() {
			public boolean shouldGlow(ModelGroup list, ModelRenderData data){
				if(data.vehicle.getTurnLightRight() || data.vehicle.getWarningLights()) return SIGNAL_TOGGLE[0];
				else return data.vehicle.getLightsState() || data.vehicle.getThrottle() < -0.01;
			}

			public String id(){
				return "fvtm:back_lights_signal_right";
			}
		});
		for(int i = 0; i < SIGNAL_TOGGLE.length; i++){
			int fi = i;
			ModelGroup.PROGRAMS.add(new AlwaysGlow() {
				public boolean shouldGlow(ModelGroup list, ModelRenderData data){
					return SIGNAL_TOGGLE[fi];
				}
				public String id(){
					return "fvtm:signal_lights_" + fi;
				}
			});
		}
		ModelGroup.PROGRAMS.add(new AttributeLights("", false));
		ModelGroup.PROGRAMS.add(new AttributeSignalLights("", 0, false));
	}

	public static void setupSignalTimer(){
		for(int i = 0; i < SIGNAL_TOGGLE.length; i++){
			if(SIGNAL_TIMER[i] != null) SIGNAL_TIMER[i].cancel();
		}
		FvtmLogger.debug("Setting up blinker-toggle timer.");
		LocalDateTime midnight = LocalDateTime.of(LocalDate.now(ZoneOffset.systemDefault()), LocalTime.MIDNIGHT);
		long mid = midnight.toInstant(ZoneOffset.UTC).toEpochMilli();
		long date = Time.getDate();
		while((mid += SIGNAL_INTERVAL) < date);
		long quarter = SIGNAL_INTERVAL / 4;
		for(int i = 0; i < SIGNAL_TOGGLE.length; i++){
			int fi = i;
			SIGNAL_TIMER[fi] = new Timer();
			SIGNAL_TIMER[fi].schedule(new TimerTask(){
				@Override
				public void run(){
					SIGNAL_TOGGLE[fi] = !SIGNAL_TOGGLE[fi];
				}
			}, new Date(mid + quarter * fi), SIGNAL_INTERVAL);
		}
	}

	public static abstract class AlwaysGlow implements Program {

		private boolean didglow;

		public AlwaysGlow(){}

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
			if(did = did()){
				GLOW.pre(group, data);
				did = true;
			}
		}

		protected boolean did(){
			return attr != null && attr.asBoolean() != equals;
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

	public static class AttributeSignalLights extends AttributeLights {

		private int channel;

		public AttributeSignalLights(String attr, int chan, boolean eq){
			super(attr, eq);
			channel = chan;
		}

		@Override
		public String id(){ return "fvtm:attribute_signal_lights"; }

		@Override
		public boolean did(){
			return super.did() && SIGNAL_TOGGLE[channel];
		}

		@Override
		public Program parse(String[] args){
			return new AttributeSignalLights(args[0], args.length > 1 ? Integer.parseInt(args[1]) : 1, args.length > 2 && Boolean.parseBoolean(args[2]));
		}

	}

}
