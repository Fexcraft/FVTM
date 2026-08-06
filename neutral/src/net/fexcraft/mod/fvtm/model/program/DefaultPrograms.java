package net.fexcraft.mod.fvtm.model.program;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.data.block.JackEntity;
import net.fexcraft.mod.fvtm.data.vehicle.WheelSlot;
import net.fexcraft.mod.fvtm.function.part.GetWheelPos;
import net.fexcraft.mod.fvtm.model.ModelGroup;
import net.fexcraft.mod.fvtm.model.ModelRenderData;
import net.fexcraft.mod.fvtm.model.Program;
import net.fexcraft.mod.fvtm.model.RenderOrder;
import net.fexcraft.mod.fvtm.render.SeparateRenderCache;
import net.fexcraft.mod.fvtm.sys.uni.WheelTireData;
import net.fexcraft.mod.fvtm.util.ContentConfigUtil;
import org.apache.commons.lang3.math.NumberUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Predicate;

import static net.fexcraft.lib.frl.Renderer.RENDERER;
import static net.fexcraft.mod.fvtm.Config.DISABLE_LIGHT_BEAMS;
import static net.fexcraft.mod.fvtm.Config.SIGNAL_INTERVAL;
import static net.fexcraft.mod.fvtm.model.ProgramUtils.FLOAT_SUPP;
import static net.fexcraft.mod.fvtm.render.RenderUtil.RENDER_UTIL;

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
				return data.vehicle().getLightsState();
			}

			public String id(){
				return "fvtm:lights";
			}
		});
		ModelGroup.PROGRAMS.add(new AlwaysGlow() {
			public boolean shouldGlow(ModelGroup list, ModelRenderData data){
				return data.vehicle().getLightsState();
			}

			public String id(){
				return "fvtm:front_lights";
			}
		});
		ModelGroup.PROGRAMS.add(new AlwaysGlow() {
			public boolean shouldGlow(ModelGroup list, ModelRenderData data){
				return data.vehicle().getLightsState() || (data.vehent() != null && data.vehent().isBraking());
			}

			public String id(){
				return "fvtm:back_lights";
			}
		});
		ModelGroup.PROGRAMS.add(new AlwaysGlow() {
			public boolean shouldGlow(ModelGroup list, ModelRenderData data){
				return data.vehicle().getFogLightsState();
			}

			public String id(){
				return "fvtm:fog_lights";
			}
		});
		ModelGroup.PROGRAMS.add(new AlwaysGlow() {
			public boolean shouldGlow(ModelGroup list, ModelRenderData data){
				return data.vehicle().getLongLightsState();
			}

			public String id(){
				return "fvtm:long_lights";
			}
		});
		ModelGroup.PROGRAMS.add(new AlwaysGlow() {
			public boolean shouldGlow(ModelGroup list, ModelRenderData data){
				return (data.vehent() != null && data.vehent().isBraking());
			}

			public String id(){
				return "fvtm:brake_lights";
			}
		});
		ModelGroup.PROGRAMS.add(new AlwaysGlow() {
			public boolean shouldGlow(ModelGroup list, ModelRenderData data){
				return data.vehicle().getThrottle() < -0.01;
			}

			public String id(){
				return "fvtm:reverse_lights";
			}
		});
		ModelGroup.PROGRAMS.add(new AlwaysGlow() {
			public boolean shouldGlow(ModelGroup list, ModelRenderData data){
				return SIGNAL_TOGGLE[0] && (data.vehicle().getTurnLightLeft() || data.vehicle().getWarningLights());
			}

			public String id(){
				return "fvtm:turn_signal_left";
			}
		});
		ModelGroup.PROGRAMS.add(new AlwaysGlow() {
			public boolean shouldGlow(ModelGroup list, ModelRenderData data){
				return SIGNAL_TOGGLE[0] && (data.vehicle().getTurnLightRight() || data.vehicle().getWarningLights());
			}

			public String id(){
				return "fvtm:turn_signal_right";
			}
		});
		ModelGroup.PROGRAMS.add(new AlwaysGlow() {
			public boolean shouldGlow(ModelGroup list, ModelRenderData data){
				return SIGNAL_TOGGLE[0] && data.vehicle().getWarningLights();
			}

			public String id(){
				return "fvtm:warning_lights";
			}
		});
		ModelGroup.PROGRAMS.add(new AlwaysGlow() {
			public boolean shouldGlow(ModelGroup list, ModelRenderData data){
				if(data.vehicle().getTurnLightLeft() || data.vehicle().getWarningLights()) return SIGNAL_TOGGLE[0];
				else return data.vehicle().getLightsState() || data.vehicle().getThrottle() < -0.01;
			}

			public String id(){
				return "fvtm:back_lights_signal_left";
			}
		});
		ModelGroup.PROGRAMS.add(new AlwaysGlow() {
			public boolean shouldGlow(ModelGroup list, ModelRenderData data){
				if(data.vehicle().getTurnLightRight() || data.vehicle().getWarningLights()) return SIGNAL_TOGGLE[0];
				else return data.vehicle().getLightsState() || data.vehicle().getThrottle() < -0.01;
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
		//
		ModelGroup.PROGRAMS.add(new Program() {
			private WheelSlot slot;
			private WheelTireData wtd;

			public String id(){
				return "fvtm:wheel_auto_all";
			}

			public void pre(ModelGroup list, ModelRenderData data){
				slot = data.part().getFunction(GetWheelPos.class, "fvtm:wheel", "fvtm:tire").getWheelPos(data.vehicle());
				if(slot != null && slot.steering){
					list.rotateGroup(-data.vehicle().getAttribute("steering_angle").asFloat(), 1, false);
				}
				if(data.vehent() != null){
					wtd = data.vehent().wheeldata.get(data.part_category());
					if(wtd != null) list.rotateGroup(-wtd.rotation, 0, false);
				}
				if(slot != null && slot.mirror) list.rotateGroup(-180, 1, false);
			}

			@Override
			public boolean post(){
				return false;
			}
		});
		ModelGroup.PROGRAMS.add(new Program() {
			private WheelSlot slot;

			public String id(){
				return "fvtm:wheel_auto_steering";
			}

			public void pre(ModelGroup list, ModelRenderData data){
				slot = data.part().getFunction(GetWheelPos.class, "fvtm:wheel", "fvtm:tire").getWheelPos(data.vehicle());
				if(slot != null && slot.mirror) list.rotateGroup(-180, 1, false);
				if(slot != null && slot.steering) list.rotateGroup(data.vehicle().getAttribute("steering_angle").asFloat(), 1, false);
			}

			@Override
			public boolean post(){
				return false;
			}
		});
		ModelGroup.PROGRAMS.add(new Program() {
			private WheelSlot slot;
			private WheelTireData wtd;

			public String id(){
				return "fvtm:wheel_auto_all_opposite";
			}

			public void pre(ModelGroup list, ModelRenderData data){
				slot = data.part().getFunction(GetWheelPos.class, "fvtm:wheel", "fvtm:tire").getWheelPos(data.vehicle());
				if(slot != null && slot.steering) list.rotateGroup(-data.vehicle().getAttribute("steering_angle").asFloat(), 1, false);
				if(data.vehent() != null){
					wtd = data.vehent().wheeldata.get(data.part_category());
					if(wtd != null) list.rotateGroup(-wtd.rotation, 0, false);
				}
				if(slot != null && slot.mirror) list.rotateGroup(-180, 1, false);
			}

			@Override
			public boolean post(){
				return false;
			}
		});
		ModelGroup.PROGRAMS.add(new Program() {
			private WheelSlot slot;

			public String id(){
				return "fvtm:wheel_auto_steering_opposite";
			}

			public void pre(ModelGroup list, ModelRenderData data){
				slot = data.part().getFunction(GetWheelPos.class, "fvtm:wheel", "fvtm:tire").getWheelPos(data.vehicle());
				if(slot != null && slot.mirror) list.rotateGroup(-180, 1, false);
				if(slot != null && slot.steering) list.rotateGroup(-data.vehicle().getAttribute("steering_angle").asFloat(), 1, false);
			}

			@Override
			public boolean post(){
				return false;
			}
		});
		ModelGroup.PROGRAMS.add(new SteeringWheel(0, 0));
		ModelGroup.PROGRAMS.add(new SteeringWheel(2, 1f));
		ModelGroup.PROGRAMS.add(new SteeringWheel(0, 1f));
		ModelGroup.PROGRAMS.add(new SteeringWheel(1, 1f));
		ModelGroup.PROGRAMS.add(new SteeringWheel(2, 1f, false));
		ModelGroup.PROGRAMS.add(new SteeringWheel(0, 1f, false));
		ModelGroup.PROGRAMS.add(new SteeringWheel(1, 1f, false));
		//
		ModelGroup.PROGRAMS.add(new AlwaysGlow(){
			public boolean shouldGlow(ModelGroup list, ModelRenderData data){
				return data.vehicle().getLightsState() && data.vehicle().getAttribute("forward").asBoolean();
			}
			public String id(){
				return "fvtm:lights_rail_forward";
			}
		});
		ModelGroup.PROGRAMS.add(new AlwaysGlow(){
			public boolean shouldGlow(ModelGroup list, ModelRenderData data){
				return data.vehicle().getLightsState() && !data.vehicle().getAttribute("forward").asBoolean();
			}
			public String id(){
				return "fvtm:lights_rail_backward";
			}
		});
		ModelGroup.PROGRAMS.add(new Program(){
			public String id(){
				return "fvtm:bogie_auto";
			}
			public void pre(ModelGroup list, ModelRenderData data){
				list.rotate(0, data.vehicle().getAttribute(data.part_category() + "_angle").asFloat(), 0);
			}
			@Override
			public boolean post(){
				return false;
			}
		});
		ModelGroup.PROGRAMS.add(new Program(){
			public String id(){
				return "fvtm:bogie_auto_opposite";
			}
			public void pre(ModelGroup list, ModelRenderData data){
				list.rotate(0, -data.vehicle().getAttribute(data.part_category() + "_angle").asFloat(), 0);
			}
			@Override
			public boolean post(){
				return false;
			}
		});
		ModelGroup.PROGRAMS.add(new Program(){
			public String id(){
				return "fvtm:bogie_front";
			}
			public void pre(ModelGroup list, ModelRenderData data){
				list.rotate(0, data.vehicle().getAttribute("bogie_front_angle").asFloat(), 0);
			}
			@Override
			public boolean post(){
				return false;
			}
		});
		ModelGroup.PROGRAMS.add(new Program(){
			public String id(){
				return "fvtm:bogie_rear";
			}
			public void pre(ModelGroup list, ModelRenderData data){
				list.rotate(0, data.vehicle().getAttribute("bogie_rear_angle").asFloat(), 0);
			}
			@Override
			public boolean post(){
				return false;
			}
		});
		ModelGroup.PROGRAMS.add(new Program(){
			public String id(){
				return "fvtm:hide";
			}
			public void pre(ModelGroup list, ModelRenderData data){
				list.visible = false;
			}
			@Override
			public void post(ModelGroup list, ModelRenderData data){
				list.visible = true;
			}
		});
		//
		ModelGroup.PROGRAMS.add(new AttributeLights("", false));
		ModelGroup.PROGRAMS.add(new AttributeSignalLights("", 0, false));
		ModelGroup.PROGRAMS.add(new AttributeRotator("", false, 0, 0, 0, 0, 0f));
		ModelGroup.PROGRAMS.add(new AttributeTranslator("", false, 0, 0, 0, 0));
		ModelGroup.PROGRAMS.add(new AttributeVisible("", false));
		ModelGroup.PROGRAMS.add(new IDSpecific(""));
		ModelGroup.PROGRAMS.add(new IDSpecificArray(""));
		ModelGroup.PROGRAMS.add(new SignBase());
		ModelGroup.PROGRAMS.add(SignScaled.INST[0]);
		ModelGroup.PROGRAMS.add(new SignScaledOff(false, false, 0, 0));
		ModelGroup.PROGRAMS.add(new SignOffset(0, 0));
		ModelGroup.PROGRAMS.add(SignBorder.INST[0]);
		ModelGroup.PROGRAMS.add(SignCorner.INST[0]);
		//
		ModelGroup.PROGRAMS.add(new LightBeam());
		ModelGroup.PROGRAMS.add(new LightBeam("fvtm:lb_lights").setPredicate(data -> data.vehicle().getLightsState()).register());
		ModelGroup.PROGRAMS.add(new LightBeam("fvtm:lb_front_lights").setPredicate(data -> data.vehicle().getLightsState() && !data.vehicle().getLongLightsState() && !data.vehicle().getFogLightsState()).register());
		ModelGroup.PROGRAMS.add(new LightBeam("fvtm:lb_back_lights").setPredicate(data -> data.vehicle().getLightsState() || data.vehicle().getThrottle() < -0.01).register());
		ModelGroup.PROGRAMS.add(new LightBeam("fvtm:lb_back_lights").setPredicate(data -> (data.vehent() != null && data.vehent().isBraking())).register());
		ModelGroup.PROGRAMS.add(new LightBeam("fvtm:lb_long_lights").setPredicate(data -> data.vehicle().getLongLightsState() && !data.vehicle().getFogLightsState()).register());
		ModelGroup.PROGRAMS.add(new LightBeam("fvtm:lb_fog_lights").setPredicate(data -> data.vehicle().getFogLightsState()).register());
		ModelGroup.PROGRAMS.add(new LightBeam("fvtm:lb_reverse_lights").setPredicate(data -> data.vehicle().getThrottle() < -0.01).register());
		ModelGroup.PROGRAMS.add(new LightBeam("fvtm:lb_signal_left").setPredicate(data -> SIGNAL_TOGGLE[0] && (data.vehicle().getTurnLightLeft() || data.vehicle().getWarningLights())).register());
		ModelGroup.PROGRAMS.add(new LightBeam("fvtm:lb_signal_right").setPredicate(data -> SIGNAL_TOGGLE[0] && (data.vehicle().getTurnLightRight() || data.vehicle().getWarningLights())).register());
		ModelGroup.PROGRAMS.add(new LightBeam("fvtm:lb_warning_lights").setPredicate(data -> SIGNAL_TOGGLE[0] && data.vehicle().getWarningLights()).register());
		ModelGroup.PROGRAMS.add(new LightBeam("fvtm:lb_back_lights_signal_left").setPredicate(data -> {
			if(data.vehicle().getTurnLightLeft() || data.vehicle().getWarningLights()) return SIGNAL_TOGGLE[0];
			return data.vehicle().getLightsState() || data.vehicle().getThrottle() < -0.01;
		}).register());
		ModelGroup.PROGRAMS.add(new LightBeam("fvtm:lb_back_lights_signal_right").setPredicate(data -> {
			if(data.vehicle().getTurnLightRight() || data.vehicle().getWarningLights()) return SIGNAL_TOGGLE[0];
			return data.vehicle().getLightsState() || data.vehicle().getThrottle() < -0.01;
		}).register());
		//
		WirePrograms.init();
		BlockPrograms.init();
		BlockCondPrograms.init();
		BakedPrograms.init();
		//
		ModelGroup.PROGRAMS.add(new Program(){
			public String id(){
				return "fvtm:vehicle_on_jack";
			}
			public void pre(ModelGroup list, ModelRenderData data){
				if(data.block_entity() == null || ((JackEntity)data.block_entity()).getVehicle() == null) return;
				SeparateRenderCache.insert((JackEntity)data.block_entity());
			}
			public boolean post(){
				return false;
			}
		});
		ModelGroup.PROGRAMS.add(new JackStandProgram());
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
			attr = data.vehicle().getAttribute(attribute);
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

	public static class AttributeRotator extends AttributeBased {

		private float min, max, step = 1;
		private Float current;
		private int axis;
		private boolean boolstatebased;
		private boolean override;
		private float defrot;

		public AttributeRotator(String attribute, boolean boolstatebased, float mn, float mx, float step, int axis, Float defrot){
			super(attribute);
			this.boolstatebased = boolstatebased;
			this.override = true;
			this.min = mn;
			this.max = mx;
			this.step = step;
			this.axis = axis;
			this.defrot = defrot == null ? 0 : defrot;
			if(min == max || (min == 0f && max == 0f)){
				min = -180; max = 180;
			}
		}

		public AttributeRotator(String attribute, boolean boolstatebased, float min, float max, float step, int axis, Float defrot, boolean notadditive){
			this(attribute, boolstatebased, min, max, step, axis, defrot);
			this.override = notadditive;
		}

		@Override
		public String id(){
			return "fvtm:attribute_rotator";
		}

		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			if(data.cache == null) return;
			if((attr = data.vehicle().getAttribute(attribute)) == null) return;
			current = data.cache.get(this, FLOAT_SUPP);
			if(current == null) current = 0f;
			current = boolstatebased ? (attr.asBoolean() ? current + step : current - step) : attr.asFloat() * step;
			if(current > max) current = max;
			if(current < min) current = min;
			list.rotate(current + defrot, axis, override);
			data.cache.set(this, current);
		}

		@Override
		public void post(ModelGroup list, ModelRenderData data){
			if(data.cache == null || attr == null) return;
			list.rotate(override ? defrot : -(current + defrot), axis, override);
			current = 0f;
		}

		@Override
		public Program parse(String[] args){
			String attr = args[0];
			boolean boolstate = Boolean.parseBoolean(args[1]);
			float min = Float.parseFloat(args[2]);
			float max = Float.parseFloat(args[3]);
			float step = Float.parseFloat(args[4]);
			int axis = Integer.parseInt(args[5]);
			Float defrot = args.length > 6 && NumberUtils.isCreatable(args[6]) ? Float.parseFloat(args[6]) : null;
			return new AttributeRotator(attr, boolstate, min, max, step, axis, defrot, args.length >= 7 && Boolean.parseBoolean(args[7]));
		}

	}

	public static class AttributeTranslator extends AttributeBased {

		private boolean bool;
		private float min, max, step;
		private Float current;
		private int axis;

		public AttributeTranslator(String attribute, boolean boolstatebased, float min, float max, float step, int axis){
			super(attribute);
			this.bool = boolstatebased;
			this.axis = axis;
			this.step = step;
			this.min = min;
			this.max = max;
		}

		@Override
		public String id(){
			return "fvtm:attribute_translator";
		}

		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			if(data.cache == null) return;
			if((attr = data.vehicle().getAttribute(attribute)) == null) return;
			current = data.cache.get(this, FLOAT_SUPP);
			if(current == null) current = 0f;
			current = bool ? (attr.asBoolean() ? current + step : current - step) : attr.asFloat();
			if(current > max) current = max; if(current < min) current = min;
			list.translate(
				axis == 0 ? current * Static.sixteenth : 0,
				axis == 1 ? current * Static.sixteenth : 0,
				axis == 2 ? current * Static.sixteenth : 0, false);
			data.cache.set(this, current);
		}

		@Override
		public void post(ModelGroup list, ModelRenderData data){
			if(data.cache == null || attr == null) return;
			list.translate(
				axis == 0 ? current * -Static.sixteenth : 0,
				axis == 1 ? current * -Static.sixteenth : 0,
				axis == 2 ? current * -Static.sixteenth : 0, false);
		}

		@Override
		public Program parse(String[] args){
			String attr = args[0];
			boolean boolstate = Boolean.parseBoolean(args[1]);
			float min = Float.parseFloat(args[2]);
			float max = Float.parseFloat(args[3]);
			float step = Float.parseFloat(args[4]);
			int axis = Integer.parseInt(args[5]);
			return new AttributeTranslator(attr, boolstate, min, max, step, axis);
		}

	}

	public static class AttributeVisible implements Program {

		private String attribute;
		private boolean equals;

		public AttributeVisible(String attribute, boolean equals){
			this.attribute = attribute;
			this.equals = equals;
		}

		@Override
		public String id(){ return "fvtm:attribute_visible"; }

		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			if(data.vehicle().getAttributeBoolean(attribute, !equals) != equals) list.visible = false;
		}

		@Override
		public void post(ModelGroup list, ModelRenderData data){
			list.visible = true;
		}

		@Override
		public Program parse(String[] args){
			return new AttributeVisible(args[0], args.length > 1 ? Boolean.parseBoolean(args[1]) : false);
		}

	}

	public static class IDSpecific implements Program {

		private String group;

		public IDSpecific(String id){ this.group = id; }

		@Override
		public String id(){ return "fvtm:category_specific"; }

		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			if(!data.part_category().equals(group)) list.visible = false;
		}

		@Override
		public void post(ModelGroup list, ModelRenderData data){
			list.visible = true;
		}

		@Override
		public Program parse(String[] args){
			if(args.length > 1) return new IDSpecificArray(args);
			return new IDSpecific(args[0]);
		}

	}

	public static class IDSpecificArray implements Program {

		private String[] groups;

		public IDSpecificArray(String... ids){ this.groups = ids; }

		@Override
		public String id(){ return "fvtm:category_specific_array"; }

		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			for(String str : groups) if(str.equals(data.part_category())) return; list.visible = false;
		}

		@Override
		public void post(ModelGroup list, ModelRenderData data){
			list.visible = true;
		}

		@Override
		public Program parse(String[] args){
			if(args.length == 1) return new IDSpecific(args[0]);
			return new IDSpecificArray(args);
		}

	}

	public static class SignBase implements Program {

		public SignBase(){}

		@Override
		public String id(){ return "fvtm:sign_base"; }

		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			if(data.sign() != null) list.scale(1, data.sign().height, data.sign().width);
		}

		@Override
		public void post(ModelGroup list, ModelRenderData data){
			list.scale(1, 1, 1);
		}

		@Override
		public Program parse(String[] args){
			return this;
		}

	}

	public static class SignScaled implements Program {

		public static SignScaled[] INST = new SignScaled[4];
		static{
			INST[0] = new SignScaled(false, false);
			INST[1] = new SignScaled(true, false);
			INST[2] = new SignScaled(false, true);
			INST[3] = new SignScaled(true, true);
		}
		protected boolean width, height;

		public SignScaled(boolean w, boolean h){
			width = w;
			height = h;
		}

		@Override
		public String id(){ return "fvtm:sign_scaled"; }

		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			if(data.sign() != null && list.visible) list.scale(1, height ? data.sign().height : 1, width ? data.sign().width : 1);
		}

		@Override
		public void post(ModelGroup list, ModelRenderData data){
			list.scale(1, 1, 1);
		}

		@Override
		public Program parse(String[] args){
			boolean w = args.length > 0 && Boolean.parseBoolean(args[0]);
			boolean h = args.length > 1 && Boolean.parseBoolean(args[1]);
			return INST[(w ? 1 : 0) + (h ? 2 : 0)];
		}

	}

	public static class SignScaledOff extends SignScaled {

		private float ws, hs;

		public SignScaledOff(boolean w, boolean h, float sx, float sy){
			super(w, h);
			ws = sx;
			hs = sy;
		}

		@Override
		public String id(){ return "fvtm:sign_scaled_offset"; }

		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			if(data.sign() != null /*&& list.visible*/){
				list.translate(0, data.sign().height * hs, data.sign().width * ws);
				list.scale(1, height ? data.sign().height : 1, width ? data.sign().width : 1, true);
			}
		}

		@Override
		public void post(ModelGroup list, ModelRenderData data){
			if(data.sign() != null /*&& list.visible*/){
				list.scale(1, 1, 1);
				list.translate(0, -data.sign().height * hs, -data.sign().width * ws);
			}
		}

		@Override
		public Program parse(String[] args){
			boolean w = args.length > 0 && Boolean.parseBoolean(args[0]);
			boolean h = args.length > 1 && Boolean.parseBoolean(args[1]);
			float ws = args.length > 2 ? Float.parseFloat(args[2]) : 1;
			float hs = args.length > 3 ? Float.parseFloat(args[3]) : 1;
			return new SignScaledOff(w, h, ws, hs);
		}

	}

	public static class SignOffset implements Program {

		private float ws, hs;

		public SignOffset(float sx, float sy){
			ws = sx;
			hs = sy;
		}

		@Override
		public String id(){ return "fvtm:sign_offset"; }

		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			if(data.sign() != null /*&& list.visible*/){
				list.translate(0, data.sign().height * hs, data.sign().width * ws);
			}
		}

		@Override
		public void post(ModelGroup list, ModelRenderData data){
			if(data.sign() != null /*&& list.visible*/){
				list.translate(0, -data.sign().height * hs, -data.sign().width * ws);
			}
		}

		@Override
		public Program parse(String[] args){
			float ws = args.length > 0 ? Float.parseFloat(args[0]) : 1;
			float hs = args.length > 1 ? Float.parseFloat(args[1]) : 1;
			return new SignOffset(ws, hs);
		}

	}

	public static class SignBorder implements Program {

		public static SignBorder[] INST = new SignBorder[4];
		static{ for(int i = 0; i < INST.length; i++) INST[i] = new SignBorder(i); }
		private int side;

		private SignBorder(int sid){
			side = sid;
		}

		@Override
		public String id(){ return "fvtm:sign_border"; }

		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			if(data.sign() == null) return;
			if(data.sign().sides[side]) list.visible = false;
		}

		@Override
		public void post(ModelGroup list, ModelRenderData data){
			list.visible = true;
		}

		@Override
		public Program parse(String[] args){
			return INST[args.length > 0 ? Integer.parseInt(args[0]) : 0];
		}

	}

	public static class SignCorner implements Program {

		public static SignCorner[] INST = new SignCorner[4];
		static{ for(int i = 0; i < INST.length; i++) INST[i] = new SignCorner(i); }
		private int corner;

		private SignCorner(int cid){
			corner = cid;
		}

		@Override
		public String id(){ return "fvtm:sign_corner"; }

		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			if(data.sign() == null) return;
			switch(corner){
				case 0: list.visible = !(data.sign().sides[0] || data.sign().sides[1]); break;
				case 1: list.visible = !(data.sign().sides[0] || data.sign().sides[2]); break;
				case 2: list.visible = !(data.sign().sides[2] || data.sign().sides[3]); break;
				case 3: list.visible = !(data.sign().sides[1] || data.sign().sides[3]); break;
			}
		}

		@Override
		public void post(ModelGroup list, ModelRenderData data){
			list.visible = true;
		}

		@Override
		public Program parse(String[] args){
			return INST[args.length > 0 ? Integer.parseInt(args[0]) : 0];
		}

	}

	public static class LightBeam implements Program {

		public static LBRender LBR;
		protected Predicate<ModelRenderData> predicate;
		protected String id = "fvtm:light_beam";
		public String swivel;
		public V3D pos = new V3D();
		public boolean skipped;

		public LightBeam(){}

		public LightBeam(String lbid){
			id = lbid;
		}

		public LightBeam init(V3D pos, String point, Predicate<ModelRenderData> predicate){
			this.pos = pos;
			this.swivel = point;
			this.predicate = predicate;
			return this;
		}

		public LightBeam init(V3D pos, Predicate<ModelRenderData> predicate){
			this.pos = pos;
			this.predicate = predicate;
			return this;
		}

		public LightBeam setPredicate(Predicate<ModelRenderData> predicate){
			this.predicate = predicate;
			return this;
		}

		@Override
		public String id(){
			return id;
		}

		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			if(!data.separaterender || DISABLE_LIGHT_BEAMS) return;
			skipped = predicate != null && !predicate.test(data);
			if(!skipped) LBR.pre(this, list, data);
		}

		@Override
		public void post(ModelGroup list, ModelRenderData data){
			if(!data.separaterender || DISABLE_LIGHT_BEAMS) return;
			if(!skipped) LBR.post(this, list, data);
			skipped = false;
		}

		@Override
		public RenderOrder order(){
			return RenderOrder.SEPARATE;
		}

		public static abstract class LBRender {

			public abstract void pre(LightBeam beam, ModelGroup list, ModelRenderData data);

			public abstract void post(LightBeam beam, ModelGroup list, ModelRenderData data);
		}

	}

	public static abstract class TextRendererBase implements Program {

		protected static float downscale = 1f / 256f;
		protected static RGB col = new RGB();
		protected int color = RGB.BLACK.packed;
		protected int width;
		protected float scale;
		protected static Attribute<?> attr;
		protected boolean glow;
		protected boolean centered;
		protected String text = "";
		protected String attrid;
		protected V3D pos = new V3D();
		protected V3D rot = new V3D();
		protected String fontkey;

		@Override
		public String id(){
			return "fvtm:text";
		}

		@Override
		public boolean pre(){
			return false;
		}

		@Override
		public Program parse(JsonMap map){
			TextRendererBase ren = create();
			ren.pos = map.has("pos") ? ContentConfigUtil.getVector(map.getArray("pos")) : V3D.NULL;
			ren.rot = map.has("rot") ? ContentConfigUtil.getVector(map.getArray("rot")) : V3D.NULL;
			ren.scale = map.getFloat("scale", 4);
			ren.centered = map.getBoolean("centered", true);
			ren.text = map.getString("text", "-");
			ren.color = map.has("color") ? Integer.parseInt(map.get("color").string_value(), 16) : RGB.BLACK.packed;
			ren.glow = map.getBoolean("glow", false);
			ren.attrid = map.getString("attr", null);
			ren.fontkey = map.getString("font", null);
			ren.width = map.getInteger("width", 0);
			return ren;
		}

		public abstract TextRendererBase create();

	}

	public static class JackStandProgram implements Program {

		private boolean in;

		@Override
		public String id(){
			return "fvtm:jack_stand";
		}

		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			list.visible = true;
			if(in || data.block_entity() == null || ((JackEntity)data.block_entity()).getCoords().size() < 2) return;
			in = true;
			for(V3D coord : ((JackEntity)data.block_entity()).getCoords()){
				RENDERER.translate(coord);
				RENDER_UTIL.render(list, data);
				RENDERER.translate(-coord.x, -coord.y, -coord.z);
			}
			list.visible = false;
			in = false;
		}

		@Override
		public boolean post(){
			return false;
		}

		@Override
		public RenderOrder order(){
			return RenderOrder.BLENDED;
		}

	}

	public static class SteeringWheel implements Program {

		private byte axis;
		private float ratio, rotated;
		private boolean apply;
		private String id;

		public SteeringWheel(int axis, float ratio){
			this(axis, ratio, true);
		}

		public SteeringWheel(int axis, float ratio, boolean override){
			this.axis = (byte)axis;
			this.ratio = ratio;
			id = axis == 0 && ratio == 0 ? "fvtm:steering_base" : "fvtm:steering_" + (axis == 0 ? "x" : axis == 1 ? "y" : "z") + (override ? "" : "_no_apply");
			this.apply = override;
		}

		@Override
		public String id(){
			return id;
		}

		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			list.rotate(rotated = -data.vehicle().getAttribute("steering_angle").asFloat() * ratio, axis, apply);
		}

		@Override
		public void post(ModelGroup list, ModelRenderData data){
			list.rotate(rotated, axis, apply);
		}


		@Override
		public Program parse(String[] args){
			return new SteeringWheel(Integer.parseInt(args[0]), Float.parseFloat(args[1]));
		}

	}

}
