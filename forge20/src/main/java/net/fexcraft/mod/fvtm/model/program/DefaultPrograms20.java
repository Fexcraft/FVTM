package net.fexcraft.mod.fvtm.model.program;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.mod.fcl.util.Renderer20;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.data.vehicle.SwivelPoint;
import net.fexcraft.mod.fvtm.data.vehicle.WheelSlot;
import net.fexcraft.mod.fvtm.function.part.GetWheelPos;
import net.fexcraft.mod.fvtm.model.ModelGroup;
import net.fexcraft.mod.fvtm.model.ModelRenderData;
import net.fexcraft.mod.fvtm.model.Program;
import net.fexcraft.mod.fvtm.model.RenderOrder;
import net.fexcraft.mod.fvtm.render.FvtmRenderTypes;
import net.fexcraft.mod.fvtm.sys.uni.WheelTireData;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.HashMap;

import static net.fexcraft.mod.fcl.util.Renderer20.*;
import static net.fexcraft.mod.fvtm.model.ProgramUtils.FLOAT_SUPP;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class DefaultPrograms20 extends DefaultPrograms {

	private static HashMap<String, Font> FONTS = new HashMap<>();

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
				if(data.color != null) Renderer20.setColor(data.color.getPrimaryColor());
			}

			public void post(ModelGroup list, ModelRenderData data){
				Renderer20.resetColor();
			}
		});
		ModelGroup.PROGRAMS.add(new Program() {
			public String id(){
				return "fvtm:rgb_secondary";
			}

			public void pre(ModelGroup list, ModelRenderData data){
				if(data.color != null) Renderer20.setColor(data.color.getSecondaryColor());
			}

			public void post(ModelGroup list, ModelRenderData data){
				Renderer20.resetColor();
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
			private WheelTireData wtd;

			public String id(){
				return "fvtm:wheel_auto_all";
			}

			public void pre(ModelGroup list, ModelRenderData data){
				pushPose();
				slot = data.part.getFunction(GetWheelPos.class, "fvtm:wheel", "fvtm:tire").getWheelPos(data.vehicle);
				if(slot != null && slot.steering){
					rotateDeg(-data.vehicle.getAttribute("steering_angle").asFloat(), AY);
				}
				if(data.vehent != null){
					wtd = data.vehent.wheeldata.get(data.part_category);
					if(wtd != null) rotateDeg(-wtd.rotation, AX);
				}
				if(slot != null && slot.mirror) rotateRad(Static.rad180, AY);
			}

			public void post(ModelGroup list, ModelRenderData data){
				Renderer20.popPose();
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
			private WheelTireData wtd;

			public String id(){
				return "fvtm:wheel_auto_all_opposite";
			}

			public void pre(ModelGroup list, ModelRenderData data){
				pushPose();
				slot = data.part.getFunction(GetWheelPos.class, "fvtm:wheel", "fvtm:tire").getWheelPos(data.vehicle);
				if(slot != null && slot.steering) rotateDeg(-data.vehicle.getAttribute("steering_angle").asFloat(), AY);
				if(data.vehent != null){
					wtd = data.vehent.wheeldata.get(data.part_category);
					if(wtd != null) rotateDeg(-wtd.rotation, AX);
				}
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
		ModelGroup.PROGRAMS.add(new SignText());
		LightBeam.LBR = new LightBeam.LBRender(){
			@Override
			public void pre(LightBeam beam, ModelGroup list, ModelRenderData data){
				FvtmRenderTypes.setLB(data.texture.getCurrentTexture());
				pose.pushPose();
				if(beam.swivel == null || beam.swivel.equals("vehicle")){
					RENDERER.translate(beam.pos);
				}
				else{
					SwivelPoint point = data.vehicle.getRotationPoint(beam.swivel);
					V3D pos = point.getRelativeVector(beam.pos);
					pose.translate(pos.x, pos.y, pos.z);
				}
				setColor(RGB.WHITE, 0.5f);
			}

			@Override
			public void post(LightBeam beam, ModelGroup list, ModelRenderData data){
				pose.popPose();
			}
		};
		ModelGroup.PROGRAMS.add(new TextRenderer());
	}

	public static class RGBCustom implements Program {

		private float[] color;

		public RGBCustom(float[] col){
			color = col;
		}

		@Override
		public String id(){
			return "fvtm:rgb_custom";
		}

		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			Renderer20.setColor(color);
		}

		@Override
		public void post(ModelGroup list, ModelRenderData data){
			Renderer20.resetColor();
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
			Renderer20.setColor(data.color.getColorChannel(channel));
		}

		@Override
		public void post(ModelGroup list, ModelRenderData data){
			Renderer20.resetColor();
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
			rentype = Renderer20.rentype();
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

	public static class SignText implements Program {

		private static HashMap<String, SignText> TEXTS = new HashMap<>();
		private Font font;
		private String key;

		public SignText(){}

		public SignText(String font){
			key = font;
		}

		@Override
		public String id(){ return "fvtm:sign_text"; }

		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			if(data.sign == null || data.sign.text == null || data.sign.text.length() == 0) return;
			RENDERER.push();
			RENDERER.scale(-0.025F, -0.025F, 0.025F);
			RENDERER.rotate(90, 0, 1, 0);
			if(font == null){
				font = getFont(key);
				if(font == null) return;
			}
			font.drawInBatch(data.sign.text, data.sign.centered ? -font.width(data.sign.text) / 2 : 0, 0,
				data.sign.getColorChannel("text").packed - 16777216, false, pose.last().pose(), Renderer20.buffer(),
				Font.DisplayMode.NORMAL, overlay, light
			);
			Renderer20.resetColor();
			RENDERER.pop();
		}

		@Override
		public boolean post(){
			return false;
		}

		@Override
		public Program parse(String[] args){
			if(args.length > 0){
				String key = args[0];
				if(!TEXTS.containsKey(key)){
					TEXTS.put(key, new SignText(key));
				}
				return TEXTS.get(key);
			}
			return this;
		}

	}

	private static Font getFont(String key){
		if(key == null) return Minecraft.getInstance().font;
		else{
			if(!FONTS.containsKey(key)){
				FONTS.put(key, new Font(res -> Minecraft.getInstance().fontManager.fontSets.getOrDefault(ResourceLocation.tryParse(key), Minecraft.getInstance().fontManager.missingFontSet), true));
			}
			return FONTS.get(key);
		}
	}

	public static class TextRenderer extends TextRendererBase {

		protected Font font;

		@Override
		public TextRendererBase create(){
			return new TextRenderer();
		}

		@Override
		public void post(ModelGroup list, ModelRenderData data){
			if(attrid != null){
				attr = data.vehicle.getAttribute(attrid);
				if(attr == null) return;
				text = attr.asString();
			}
			if(text.isEmpty()) return;
			if(font == null){
				font = getFont(fontkey);
				if(font == null) return;
			}
			RENDERER.push();
			RENDERER.translate(pos);
			RENDERER.scale(-downscale, -downscale, -downscale);
			if(scale != 1f) RENDERER.scale(scale, scale, scale);
			RENDERER.rotate(-90, 0, 1, 0);
			if(rot.y != 0.0F) RENDERER.rotate(rot.y, 0, 1, 0);
			if(rot.z != 0.0F) RENDERER.rotate(rot.z, 0, 0, 1);
			if(rot.x != 0.0F) RENDERER.rotate(rot.x, 1, 0, 0);
			font.drawInBatch(width > 0 ? font.plainSubstrByWidth(text, width) : text, centered ? -font.width(text) * 0.5f : 0, 0,
				color - 16777216, false, pose.last().pose(), Renderer20.buffer(),
				glow ? Font.DisplayMode.SEE_THROUGH : Font.DisplayMode.NORMAL, overlay, light
			);
			RENDERER.pop();
		}

	}

}
