package net.fexcraft.mod.fvtm.model.program;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.mod.fvtm.data.attribute.AttrFloat;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.data.vehicle.WheelSlot;
import net.fexcraft.mod.fvtm.function.part.GetWheelPos;
import net.fexcraft.mod.fvtm.model.ModelGroup;
import net.fexcraft.mod.fvtm.model.ModelRenderData;
import net.fexcraft.mod.fvtm.model.Program;
import net.fexcraft.mod.fvtm.model.RenderOrder;
import net.fexcraft.mod.fvtm.render.FvtmRenderTypes;
import net.fexcraft.mod.fvtm.render.Renderer120;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;
import net.minecraft.client.renderer.RenderType;
import org.apache.commons.lang3.math.NumberUtils;

import static net.fexcraft.mod.fvtm.model.ProgramUtils.FLOAT_SUPP;
import static net.fexcraft.mod.fvtm.render.Renderer120.*;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class DefaultPrograms20 extends DefaultPrograms {

	public static void init(){
		DefaultPrograms.init();
		GLOW = new Program() {
			private RenderType old;
			@Override
			public String id(){
				return "fvtm:glow_internal";
			}
			@Override
			public void pre(ModelGroup list, ModelRenderData data){
				old = rentype();
				FvtmRenderTypes.setGlow(data.texture.getCurrentTexture());
			}
			@Override
			public void post(ModelGroup list, ModelRenderData data){
				FvtmRenderTypes.setDef(old);
			}
			@Override
			public RenderOrder order(){
				return RenderOrder.BLENDED;
			}
		};
		ModelGroup.PROGRAMS.add(new Program() {
			public String id(){
				return "fvtm:rgb_primary";
			}

			public void pre(ModelGroup list, ModelRenderData data){
				if(data.color != null) Renderer120.setColor(data.color.getPrimaryColor());
			}

			public void post(ModelGroup list, ModelRenderData data){
				Renderer120.resetColor();
			}
		});
		ModelGroup.PROGRAMS.add(new Program() {
			public String id(){
				return "fvtm:rgb_secondary";
			}

			public void pre(ModelGroup list, ModelRenderData data){
				if(data.color != null) Renderer120.setColor(data.color.getSecondaryColor());
			}

			public void post(ModelGroup list, ModelRenderData data){
				Renderer120.resetColor();
			}
		});
		ModelGroup.PROGRAMS.add(new RGBCustom(new float[]{ 1, 1, 1 }));
		ModelGroup.PROGRAMS.add(new RGBChannel("custom"));
		ModelGroup.PROGRAMS.add(new Program() {
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
		ModelGroup.PROGRAMS.add(new Program() {
			private WheelSlot slot;
			private AttrFloat attr = null;
			private float am;

			public String id(){
				return "fvtm:wheel_auto_all";
			}

			public void pre(ModelGroup list, ModelRenderData data){
				pushPose();
				slot = data.part.getFunction(GetWheelPos.class, "fvtm:wheel", "fvtm:tire").getWheelPos(data.vehicle);
				if(slot != null && slot.steering){
					attr = (AttrFloat)data.vehicle.getAttribute("steering_angle");
					am = attr.initial + data.partialticks * (attr.value - attr.initial);
					rotateDeg(-am, AY);
				}
				rotateDeg(-data.vehicle.getAttribute("wheel_angle").asFloat(), AX);
				if(slot != null && slot.mirror) rotateRad(Static.rad180, AY);
			}

			public void post(ModelGroup list, ModelRenderData data){
				Renderer120.popPose();
			}
		});
		ModelGroup.PROGRAMS.add(new Program() {
			private WheelSlot slot;

			public String id(){
				return "fvtm:wheel_auto_steering";
			}

			public void pre(ModelGroup list, ModelRenderData data){
				pushPose();
				slot = data.part.getFunction(GetWheelPos.class, "fvtm:wheel", "fvtm:tire").getWheelPos(data.vehicle);
				if(slot != null && slot.mirror) rotateRad(Static.rad180, AY);
				if(slot != null && slot.steering) rotateDeg(data.vehicle.getAttribute("steering_angle").asFloat(), AY);
			}

			public void post(ModelGroup list, ModelRenderData data){
				popPose();
			}
		});
		ModelGroup.PROGRAMS.add(new Program() {
			private WheelSlot slot;

			public String id(){
				return "fvtm:wheel_auto_all_opposite";
			}

			public void pre(ModelGroup list, ModelRenderData data){
				pushPose();
				slot = data.part.getFunction(GetWheelPos.class, "fvtm:wheel", "fvtm:tire").getWheelPos(data.vehicle);
				if(slot != null && slot.steering) rotateDeg(-data.vehicle.getAttribute("steering_angle").asFloat(), AY);
				rotateDeg(data.vehicle.getAttribute("wheel_angle").asFloat(), AX);
				if(slot != null && slot.mirror) rotateRad(Static.rad180, AY);
			}

			public void post(ModelGroup list, ModelRenderData data){
				popPose();
			}
		});
		ModelGroup.PROGRAMS.add(new Program() {
			private WheelSlot slot;

			public String id(){
				return "fvtm:wheel_auto_steering_opposite";
			}

			public void pre(ModelGroup list, ModelRenderData data){
				pushPose();
				slot = data.part.getFunction(GetWheelPos.class, "fvtm:wheel", "fvtm:tire").getWheelPos(data.vehicle);
				if(slot != null && slot.mirror) rotateRad(Static.rad180, AY);
				if(slot != null && slot.steering) rotateDeg(-data.vehicle.getAttribute("steering_angle").asFloat(), AY);
			}

			public void post(ModelGroup list, ModelRenderData data){
				popPose();
			}
		});
		ModelGroup.PROGRAMS.add(new SteeringWheel(0, 0));
		ModelGroup.PROGRAMS.add(new SteeringWheel(2, 1f));
		ModelGroup.PROGRAMS.add(new SteeringWheel(0, 1f));
		ModelGroup.PROGRAMS.add(new SteeringWheel(1, 1f));
		ModelGroup.PROGRAMS.add(new SteeringWheel(2, 1f, false));
		ModelGroup.PROGRAMS.add(new SteeringWheel(0, 1f, false));
		ModelGroup.PROGRAMS.add(new SteeringWheel(1, 1f, false));
		ModelGroup.PROGRAMS.add(new AttributeRotator("", false, 0, 0, 0, 0, 0f));//jtmt/obj init only
		ModelGroup.PROGRAMS.add(new AttributeTranslator("", false, 0, 0, 0, 0));//jtmt/obj init only
		ModelGroup.PROGRAMS.add(new AttributeVisible("", false));//jtmt/obj init only
		ModelGroup.PROGRAMS.add(new TextureBinder("minecraft:textures/blocks/stone.png"));
	}

	public static class RGBCustom implements Program {

		private Vec3f color = new Vec3f();

		public RGBCustom(float[] col){
			color.x = col[0];
			color.y = col[1];
			color.z = col[2];
		}

		@Override
		public String id(){
			return "fvtm:rgb_custom";
		}

		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			Renderer120.setColor(color);
		}

		@Override
		public void post(ModelGroup list, ModelRenderData data){
			Renderer120.resetColor();
		}

		@Override
		public Program parse(String[] args){
			return new RGBCustom(new RGB(args[0]).toFloatArray());
		}

	}

	public static class RGBChannel implements Program {

		private String channel;

		public RGBChannel(String colorchannel){
			this.channel = colorchannel;
		}

		@Override
		public String id(){
			return "fvtm:rgb_channel";
		}

		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			Renderer120.setColor(data.color.getColorChannel(channel));
		}

		@Override
		public void post(ModelGroup list, ModelRenderData data){
			Renderer120.resetColor();
		}

		@Override
		public Program parse(String[] args){
			return new RGBChannel(args[0]);
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
			list.rotate(rotated = -data.vehicle.getAttribute("steering_angle").asFloat() * ratio, axis, apply);
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
				min = -180;
				max = 180;
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
			if((attr = data.vehicle.getAttribute(attribute)) == null) return;
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
			if((attr = data.vehicle.getAttribute(attribute)) == null) return;
			current = data.cache.get(this, FLOAT_SUPP);
			if(current == null) current = 0f;
			current = bool ? (attr.asBoolean() ? current + step : current - step) : attr.asFloat();
			if(current > max) current = max;
			if(current < min) current = min;
			pose.translate(
				axis == 0 ? current * Static.sixteenth : 0,
				axis == 1 ? current * Static.sixteenth : 0,
				axis == 2 ? current * Static.sixteenth : 0);
			data.cache.set(this, current);
		}

		@Override
		public void post(ModelGroup list, ModelRenderData data){
			if(data.cache == null || attr == null) return;
			pose.translate(
				axis == 0 ? current * -Static.sixteenth : 0,
				axis == 1 ? current * -Static.sixteenth : 0,
				axis == 2 ? current * -Static.sixteenth : 0);
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

		private Attribute<?> attr;
		private String attribute;
		private boolean equals;

		public AttributeVisible(String attribute, boolean equals){
			this.attribute = attribute;
			this.equals = equals;
		}

		@Override
		public String id(){
			return "fvtm:attribute_visible";
		}

		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			if(data.vehicle.getAttributeBoolean(attribute, !equals) != equals) list.visible = false;
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

	public static class TextureBinder implements Program {

		private IDL idl;
		private RenderType rentype;

		public TextureBinder(String rs){
			idl = IDLManager.getIDLCached(rs);
		}

		public TextureBinder(IDL rs){
			idl = rs;
		}

		@Override
		public String id(){
			return "fvtm:bind_texture";
		}

		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			rentype = Renderer120.rentype();
			FvtmRenderTypes.setCutout(idl);
		}

		@Override
		public void post(ModelGroup list, ModelRenderData data){
			FvtmRenderTypes.setDef(rentype);
		}

		@Override
		public Program parse(String[] args){
			return new TextureBinder(args[0]);
		}

	}

}
