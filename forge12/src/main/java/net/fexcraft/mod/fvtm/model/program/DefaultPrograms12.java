package net.fexcraft.mod.fvtm.model.program;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.block.generated.MultiblockTileEntity;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.inv.InvHandlerVar;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.vehicle.SwivelPoint;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.WheelSlot;
import net.fexcraft.mod.fvtm.function.part.EngineFunction;
import net.fexcraft.mod.fvtm.function.part.GetWheelPos;
import net.fexcraft.mod.fvtm.model.*;
import net.fexcraft.mod.fvtm.render.EffectRenderer;
import net.fexcraft.mod.fvtm.sys.uni.RootVehicle;
import net.fexcraft.mod.fvtm.sys.uni.WheelTireData;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.fexcraft.mod.uni.Pos;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.lang3.math.NumberUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import java.util.HashMap;

import static net.fexcraft.lib.frl.Renderer.RENDERER;
import static net.fexcraft.mod.fvtm.model.ProgramUtils.*;
import static net.fexcraft.mod.fvtm.model.program.DefaultPrograms.LightBeam.*;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class DefaultPrograms12 extends DefaultPrograms {

	public static boolean DIDLOAD = false;
	private static FontRenderer fr;

	public static void init(){
		DefaultPrograms.init();
		GLOW = new Transparent(189f, 4f);
		ModelGroup.PROGRAMS.add(new Program(){
			public String id(){
				return "fvtm:rgb_primary";
			}
			public void pre(ModelGroup list, ModelRenderData data){
				if(data.color != null) data.color.getPrimaryColor().glColorApply();
			}
			public void post(ModelGroup list, ModelRenderData data){
				RGB.glColorReset();
			}
		});
		ModelGroup.PROGRAMS.add(new Program(){
			public String id(){
				return "fvtm:rgb_secondary";
			}
			public void pre(ModelGroup list, ModelRenderData data){
				if(data.color != null) data.color.getSecondaryColor().glColorApply();
			}
			public void post(ModelGroup list, ModelRenderData data){
				RGB.glColorReset();
			}
		});
		ModelGroup.PROGRAMS.add(new RGBCustom(0xffffff));
		ModelGroup.PROGRAMS.add(new RGBChannel("custom"));
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
		ModelGroup.PROGRAMS.add(new Window());
		ModelGroup.PROGRAMS.add(new WindowTinted());
		ModelGroup.PROGRAMS.add(new Program(){
			private WheelTireData wtd;
			private WheelSlot slot;

			public String id(){
				return "fvtm:wheel_auto_all";
			}
			public void pre(ModelGroup list, ModelRenderData data){
				slot = data.part.getFunction(GetWheelPos.class, "fvtm:wheel", "fvtm:tire").getWheelPos(data.vehicle);
				if(slot != null && slot.steering){
					GL11.glRotatef(-data.vehicle.getAttribute("steering_angle").asFloat(), 0, 1, 0);
				}
				if(data.vehent != null){
					wtd = data.vehent.wheeldata.get(data.part_category);
					if(wtd != null) GL11.glRotatef(-wtd.rotation, 1, 0, 0);
				}
				if(slot != null && slot.mirror) GL11.glRotatef(180f, 0, 1, 0);
			}
			public void post(ModelGroup list, ModelRenderData data){
				if(slot != null && slot.mirror) GL11.glRotatef(-180f, 0, 1, 0);
				if(data.vehent != null){
					wtd = data.vehent.wheeldata.get(data.part_category);
					if(wtd != null) GL11.glRotatef(wtd.rotation, 1, 0, 0);
				}
				if(slot != null && slot.steering) GL11.glRotatef(data.vehicle.getAttribute("steering_angle").asFloat(), 0, 1, 0);
			}
		});
		ModelGroup.PROGRAMS.add(new Program(){
			private WheelSlot slot;

			public String id(){
				return "fvtm:wheel_auto_steering";
			}
			public void pre(ModelGroup list, ModelRenderData data){
				slot = data.part.getFunction(GetWheelPos.class, "fvtm:wheel", "fvtm:tire").getWheelPos(data.vehicle);
				if(slot != null && slot.mirror) GL11.glRotatef(180f, 0, 1, 0);
				if(slot != null && slot.steering)
					GL11.glRotatef(data.vehicle.getAttribute("steering_angle").asFloat(), 0, 1, 0);
			}
			public void post(ModelGroup list, ModelRenderData data){
				if(slot != null && slot.steering)
					GL11.glRotatef(-data.vehicle.getAttribute("steering_angle").asFloat(), 0, 1, 0);
				if(slot != null && slot.mirror) GL11.glRotatef(-180f, 0, 1, 0);
			}
		});
		ModelGroup.PROGRAMS.add(new Program(){
			private WheelSlot slot;
			private WheelTireData wtd;

			public String id(){
				return "fvtm:wheel_auto_all_opposite";
			}
			public void pre(ModelGroup list, ModelRenderData data){
				slot = data.part.getFunction(GetWheelPos.class, "fvtm:wheel", "fvtm:tire").getWheelPos(data.vehicle);
				if(slot != null && slot.steering)
					GL11.glRotatef(-data.vehicle.getAttribute("steering_angle").asFloat(), 0, 1, 0);
				if(data.vehent != null){
					wtd = data.vehent.wheeldata.get(data.part_category);
					if(wtd != null) GL11.glRotatef(wtd.rotation, 1, 0, 0);
				}
				if(slot != null && slot.mirror) GL11.glRotatef(180f, 0, 1, 0);
			}
			public void post(ModelGroup list, ModelRenderData data){
				if(slot != null && slot.mirror) GL11.glRotatef(-180f, 0, 1, 0);
				if(data.vehent != null){
					wtd = data.vehent.wheeldata.get(data.part_category);
					if(wtd != null) GL11.glRotatef(-wtd.rotation, 1, 0, 0);
				}
				if(slot != null && slot.steering)
					GL11.glRotatef(data.vehicle.getAttribute("steering_angle").asFloat(), 0, 1, 0);
			}
		});
		ModelGroup.PROGRAMS.add(new Program(){
			private WheelSlot slot;

			public String id(){
				return "fvtm:wheel_auto_steering_opposite";
			}
			public void pre(ModelGroup list, ModelRenderData data){
				slot = data.part.getFunction(GetWheelPos.class, "fvtm:wheel", "fvtm:tire").getWheelPos(data.vehicle);
				if(slot != null && slot.mirror) GL11.glRotatef(180f, 0, 1, 0);
				if(slot != null && slot.steering)
					GL11.glRotatef(-data.vehicle.getAttribute("steering_angle").asFloat(), 0, 1, 0);
			}
			public void post(ModelGroup list, ModelRenderData data){
				if(slot != null && slot.steering)
					GL11.glRotatef(data.vehicle.getAttribute("steering_angle").asFloat(), 0, 1, 0);
				if(slot != null && slot.mirror) GL11.glRotatef(-180f, 0, 1, 0);
			}
		});
		ModelGroup.PROGRAMS.add(new SteeringWheel(0, 0));
		ModelGroup.PROGRAMS.add(new SteeringWheelCentered(0, 0));
		ModelGroup.PROGRAMS.add(new SteeringWheel(2, 1f));
		ModelGroup.PROGRAMS.add(new SteeringWheel(0, 1f));
		ModelGroup.PROGRAMS.add(new SteeringWheel(1, 1f));
		ModelGroup.PROGRAMS.add(new SteeringWheel(2, 1f, false));
		ModelGroup.PROGRAMS.add(new SteeringWheel(0, 1f, false));
		ModelGroup.PROGRAMS.add(new SteeringWheel(1, 1f, false));
		ModelGroup.PROGRAMS.add(new SteeringWheelCentered(2, 1f));
		ModelGroup.PROGRAMS.add(new SteeringWheelCentered(0, 1f));
		ModelGroup.PROGRAMS.add(new SteeringWheelCentered(1, 1f));
		//
		ModelGroup.PROGRAMS.add(new AlwaysGlow(){
			public boolean shouldGlow(ModelGroup list, ModelRenderData data){
				return data.vehicle.getLightsState() && data.vehicle.getAttribute("forward").asBoolean();
			}
			public String id(){
				return "fvtm:lights_rail_forward";
			}
		});
		ModelGroup.PROGRAMS.add(new AlwaysGlow(){
			public boolean shouldGlow(ModelGroup list, ModelRenderData data){
				return data.vehicle.getLightsState() && !data.vehicle.getAttribute("forward").asBoolean();
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
				GL11.glRotatef(data.vehicle.getAttribute(data.part_category + "_angle").asFloat(), 0, 1, 0);
			}
			public void post(ModelGroup list, ModelRenderData data){
				GL11.glRotatef(-data.vehicle.getAttribute(data.part_category + "_angle").asFloat(), 0, 1, 0);
			}
		});
		ModelGroup.PROGRAMS.add(new Program(){
			public String id(){
				return "fvtm:bogie_auto_opposite";
			}
			public void pre(ModelGroup list, ModelRenderData data){
				GL11.glRotatef(-data.vehicle.getAttribute(data.part_category + "_angle").asFloat(), 0, 1, 0);
			}
			public void post(ModelGroup list, ModelRenderData data){
				GL11.glRotatef(data.vehicle.getAttribute(data.part_category + "_angle").asFloat(), 0, 1, 0);
			}
		});
		ModelGroup.PROGRAMS.add(new Program(){
			public String id(){
				return "fvtm:bogie_front";
			}
			public void pre(ModelGroup list, ModelRenderData data){
				GL11.glRotatef(data.vehicle.getAttribute("bogie_front_angle").asFloat(), 0, 1, 0);
			}
			public void post(ModelGroup list, ModelRenderData data){
				GL11.glRotatef(-data.vehicle.getAttribute("bogie_front_angle").asFloat(), 0, 1, 0);
			}
		});
		ModelGroup.PROGRAMS.add(new Program(){
			public String id(){
				return "fvtm:bogie_rear";
			}
			public void pre(ModelGroup list, ModelRenderData data){
				GL11.glRotatef(data.vehicle.getAttribute("bogie_rear_angle").asFloat(), 0, 1, 0);
			}
			public void post(ModelGroup list, ModelRenderData data){
				GL11.glRotatef(-data.vehicle.getAttribute("bogie_rear_angle").asFloat(), 0, 1, 0);
			}
		});
		//
		ModelGroup.PROGRAMS.add(new Scale(1f));
		ModelGroup.PROGRAMS.add(new Scale3D(1f, 1f, 1f));
		ModelGroup.PROGRAMS.add(new Transparent(63f, 63f));
		ModelGroup.PROGRAMS.add(new AttributeRotator("", false, 0, 0, 0, 0, 0f));//jtmt/obj init only
		ModelGroup.PROGRAMS.add(new AttributeTranslator("", false, 0, 0, 0, 0));//jtmt/obj init only
		ModelGroup.PROGRAMS.add(new AttributeVisible("", false));//jtmt/obj init only
		ModelGroup.PROGRAMS.add(new Gauge("", 0, 0, 0, 0, 0));//jtmt/obj init only
		ModelGroup.PROGRAMS.add(new RotationSetter(0, 0, 0, false));//jtmt/obj init only
		ModelGroup.PROGRAMS.add(new TranslationSetter(0, 0, 0, 0));//jtmt/obj init only
		ModelGroup.PROGRAMS.add(new TextureBinder("minecraft:textures/blocks/stone.png"));
		ModelGroup.PROGRAMS.add(new Program(){
			public String id(){
				return "fvtm:bind_selected_texture";
			}
			public void pre(ModelGroup list, ModelRenderData data){
				TexUtil.bindTexture(data.texture.getCurrentTexture());
			}
			public boolean post(){
				return false;
			}
		});
		ModelGroup.PROGRAMS.add(new Program(){
			public String id(){
				return "fvtm:bind_block_4x4rot_texture";
			}
			public void pre(ModelGroup list, ModelRenderData data){
				if(data.texture == null || data.tile == null) return;
				TexUtil.bindTexture(data.texture.getTexHolder().getDefaultTextures().get(((TileEntity)data.tile).getBlockMetadata() / 4));
			}
			public boolean post(){
				return false;
			}
		});
		ModelGroup.PROGRAMS.add(new Program(){
			public String id(){
				return "fvtm:bind_block_variant_texture";
			}
			public void pre(ModelGroup list, ModelRenderData data){
				TexUtil.bindTexture(data.texture.getTexHolder().getDefaultTextures().get(((TileEntity)data.tile).getBlockMetadata()));
			}
			public boolean post(){
				return false;
			}
		});
		ModelGroup.PROGRAMS.add(new Program(){
			public String id(){
				return "fvtm:rescale_normal";
			}
			public void pre(ModelGroup list, ModelRenderData data){
				GL11.glEnable(GL12.GL_RESCALE_NORMAL);
			}
			public void post(ModelGroup list, ModelRenderData data){
				GL11.glDisable(GL12.GL_RESCALE_NORMAL);
			}
		});
		ModelGroup.PROGRAMS.add(new TextRenderer(0, 0, 0, 0, 0, 0, 0, true));
		ModelGroup.PROGRAMS.add(new AttributeTextRenderer("", 0, 0, 0, 0, 0, 0, 0, true));
		ModelGroup.PROGRAMS.add(new Rotator(0, 0, 0, 0, null, false, false));//parsed init only
		ModelGroup.PROGRAMS.add(new Translator(0, 0, 0, 0, false));//parsed init only
		ModelGroup.PROGRAMS.add(new DisplayBarrel());
		ModelGroup.PROGRAMS.add(new RenderOrderSetter(null));
		ModelGroup.PROGRAMS.add(new RotateTo());
		ModelGroup.PROGRAMS.add(new TranslateTo());
		ModelGroup.PROGRAMS.add(new SignText());
		//
		AnimationPrograms.init();
		OpenGlPrograms.init();
		BlockPrograms.init();
		BakedPrograms.init();
		//
		LBR = new LBRender(){
			@Override
			public void pre(LightBeam beam, ModelGroup list, ModelRenderData data){TexUtil.bindTexture(EffectRenderer.LIGHT_TEXTURE);
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glDepthMask(false);
				GL11.glEnable(GL11.GL_ALPHA_TEST);
				GlStateManager.blendFunc(GlStateManager.SourceFactor.DST_COLOR, GlStateManager.DestFactor.SRC_ALPHA);
				GL11.glPushMatrix();
				if(beam.swivel == null || beam.swivel.equals("vehicle")){
					RENDERER.translate(beam.pos);
				}
				else{
					SwivelPoint point = data.vehicle.getRotationPoint(beam.swivel);
					V3D pos = point.getRelativeVector(beam.pos);
					GL11.glRotated(-180f, 0.0F, 1.0F, 0.0F);
					GL11.glRotated(-180f, 0.0F, 0.0F, 1.0F);
					GL11.glTranslated(pos.x, pos.y, pos.z);
					GL11.glRotated(180f, 0.0F, 1.0F, 0.0F);
					GL11.glRotated(180f, 0.0F, 0.0F, 1.0F);
				}
				GL11.glColor4f(1, 1, 1, 0.5F);
			}

			@Override
			public void post(LightBeam beam, ModelGroup list, ModelRenderData data){
				GL11.glPopMatrix();
				GL11.glDisable(GL11.GL_ALPHA_TEST);
				GL11.glDepthMask(true);
				GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
				GL11.glDisable(GL11.GL_BLEND);
			}
		};
		//
		DIDLOAD = true;
	}
	
	public static class RGBCustom implements Program {
		
		private RGB color;
		
		public RGBCustom(int color){
			this.color = new RGB(color);
		}
		
		public RGBCustom(RGB rgb){
			color = rgb;
		}
		
		@Override
		public String id(){
			return "fvtm:rgb_custom";
		}
		
		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			this.color.glColorApply();
		}
		
		@Override
		public void post(ModelGroup list, ModelRenderData data){
			RGB.glColorReset();
		}

		@Override
		public Program parse(String[] args){
			return new RGBCustom(new RGB(args[0]));
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
			data.color.getColorChannel(channel).glColorApply();
		}
		
		@Override
		public void post(ModelGroup list, ModelRenderData data){
			RGB.glColorReset();
		}

		@Override
		public Program parse(String[] args){
			return new RGBChannel(args[0]);
		}
		
	}
	
	public static final class Window implements Program {
		
		public Window(){}

		@Override
		public void pre(ModelGroup list, ModelRenderData data){
            GlStateManager.pushMatrix();
            enableBlend();
            GL11.glDepthMask(false);
            enableAlpha();
		}

		@Override
		public void post(ModelGroup list, ModelRenderData data){
            disableAlpha();
            GL11.glDepthMask(true);
            disableBlend();
            GlStateManager.popMatrix();
		}
		
		@Override
		public String id(){
			return "fvtm:window";
		}

		@Override
		public RenderOrder order(){
			return RenderOrder.LAST;
		}
		
	}

	public static final class WindowTinted implements Program {

		protected RGB color = new RGB(0x007208).setAlpha(0.3f);

		public WindowTinted(){}

		public WindowTinted(int color){
			this.color = new RGB(color).setAlpha(0.3f);
		}

		public WindowTinted(int color, float alpha){
			this.color = new RGB(color).setAlpha(alpha);
		}

		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			GlStateManager.pushMatrix();
			enableBlend();
			GL11.glDepthMask(false);
			enableAlpha();
			this.color.glColorApply();
		}

		@Override
		public void post(ModelGroup list, ModelRenderData data){
			RGB.glColorReset();
			disableAlpha();
			GL11.glDepthMask(true);
			disableBlend();
			GlStateManager.popMatrix();
		}

		@Override
		public String id(){
			return "fvtm:window_tinted";
		}

		@Override
		public Program parse(String[] args){
			int color = args.length > 0 ? Integer.parseInt(args[0].replace("#", "").replace("0x", ""), 16) : 0x007208;
			float alpha = args.length > 1 ? Float.parseFloat(args[1]) : 0.3f;
			return new WindowTinted(color, alpha);
		}

		@Override
		public RenderOrder order(){
			return RenderOrder.LAST;
		}

	}

	public static final Program BOGIE_AXLE_WHEEL = new Program(){
		
		@Override
		public String id(){ return "fvtm:bogie_axle_wheel"; }
		
		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			//
		}
		
		@Override
		public void post(ModelGroup list, ModelRenderData data){
			//
		}
		
	};
	
	public static class SteeringWheel implements Program {
		
		private byte axis;
		private float ratio, rotated;
		private boolean apply;
		private String id;
		
		public SteeringWheel(int axis, float ratio){
			this(axis, ratio, true);
		}
		
		public SteeringWheel(int axis, float ratio, boolean override){
			this.axis = (byte)axis; this.ratio = ratio;
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
		
	};
	
	/** Only works with centered steering wheels and translated into position. */
	public static class SteeringWheelCentered implements Program {
		
		private byte x, y, z; private float ratio; private String id;
		
		public SteeringWheelCentered(int axis, float ratio){
			x = (byte)(axis == 0 ? 1 : 0); y = (byte)(axis == 1 ? 1 : 0); z = (byte)(axis == 2 ? 1 : 0); this.ratio = ratio;
			id = axis == 0 && ratio == 0 ? "fvtm:steering_base_centered" : "fvtm:steering_c" + (axis == 0 ? "x" : axis == 1 ? "y" : "z");
		}

		@Override
		public String id(){
			return id;
		}
		
		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			GL11.glRotatef(data.vehicle.getAttribute("steering_angle").asFloat() * ratio, x, y, z);
		}
		
		@Override
		public void post(ModelGroup list, ModelRenderData data){
			GL11.glRotatef(-data.vehicle.getAttribute("steering_angle").asFloat() * ratio, x, y, z);
		}
		

		@Override
		public Program parse(String[] args){
			return new SteeringWheelCentered(Integer.parseInt(args[0]), Float.parseFloat(args[1]));
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
			if(current > max) current = max; if(current < min) current = min;
			//GL11.glPushMatrix();
			GL11.glTranslatef(
				axis == 0 ? current * Static.sixteenth : 0,
				axis == 1 ? current * Static.sixteenth : 0,
				axis == 2 ? current * Static.sixteenth : 0);
			data.cache.set(this, current);
		}

		@Override
		public void post(ModelGroup list, ModelRenderData data){
			if(data.cache == null || attr == null) return;
			GL11.glTranslatef(
				axis == 0 ? current * -Static.sixteenth : 0,
				axis == 1 ? current * -Static.sixteenth : 0,
				axis == 2 ? current * -Static.sixteenth : 0);
			//GL11.glPopMatrix();
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
		public String id(){ return "fvtm:attribute_visible"; }
		
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
	
	public static class Transparent implements Program {
		
		protected float lx, ly, x, y;
		
		public Transparent(float mapx, float mapy){
			x = mapx;
			y = mapy;
		}

		@Override
		public String id(){
			return "fvtm:transparent";
		}

		@Override
		public void pre(ModelGroup list, ModelRenderData data){
	        enableBlend();
	        disableAlphaTest();
	        GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.SRC_COLOR);
	        //if(ent != null) GlStateManager.depthMask(!ent.isInvisible());
	        lx = OpenGlHelper.lastBrightnessX; ly = OpenGlHelper.lastBrightnessY;
	        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, x, y);
	        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		}

		@Override
		public void post(ModelGroup list, ModelRenderData data){
	        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, lx, ly);
	        disableBlend();
	        enableAlphaTest();
		}

		@Override
		public Program parse(String[] args){
			if(args.length < 2) return this;
			float x = Float.parseFloat(args[0]);
			float y = Float.parseFloat(args[1]);
			return new Transparent(x, y);
		}

		@Override
		public RenderOrder order(){
			return RenderOrder.BLENDED;
		}
		
	}
	
	public static class Scale implements Program {
		
		private float scale;
		
		public Scale(float scale){ this.scale = scale; }

		@Override
		public String id(){
			return "fvtm:scale";
		}
		
		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			GL11.glPushMatrix();
			GL11.glScalef(scale, scale, scale);
		}

		@Override
		public void post(ModelGroup list, ModelRenderData data){
			GL11.glPopMatrix();
		}

		@Override
		public Program parse(String[] args){
			return new Scale(Float.parseFloat(args[0]));
		}
		
	}
	
	public static class Scale3D implements Program {
		
		private float x, y, z;
		
		public Scale3D(float x, float y, float z){ this.x = x; this.y = y; this.z = z; }

		@Override
		public String id(){ return "fvtm:scale_3d"; }
		
		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			GL11.glPushMatrix();
			GL11.glScalef(x, y, z);
		}

		@Override
		public void post(ModelGroup list, ModelRenderData data){
			GL11.glPopMatrix();
		}
		

		@Override
		public Program parse(String[] args){
			return new Scale3D(
				args.length > 0 ? Float.parseFloat(args[0]) : 1,
				args.length > 1 ? Float.parseFloat(args[1]) : 1,
				args.length > 2 ? Float.parseFloat(args[2]) : 1);
		}
		
	}
	
	public static final HashMap<String, RGBChannel> RGB_CHANNELS = new HashMap<>();
	public static final HashMap<String, AlwaysGlow> CUSTOM_LIGHTS = new HashMap<>();

	public static RGBChannel getRGBChannel(String channel_id){
		if(RGB_CHANNELS.containsKey(channel_id)) return RGB_CHANNELS.get(channel_id);
		RGBChannel channel = new RGBChannel(channel_id);
		RGB_CHANNELS.put(channel_id, channel);
		return channel;
	}

	public static AlwaysGlow getCustomLights(String attr_id){
		if(CUSTOM_LIGHTS.containsKey(attr_id)) return CUSTOM_LIGHTS.get(attr_id);
		AlwaysGlow glow = new AlwaysGlow(){
			@Override
			public boolean shouldGlow(ModelGroup list, ModelRenderData data){
				return data.vehicle.getAttribute(attr_id).asBoolean();
			}
		};
		CUSTOM_LIGHTS.put(attr_id, glow);
		return glow;
	}
	
	public static class Gauge implements Program {
		
		private byte axis;
		private float minrot, maxrot, minval, maxval;
		private String attribute, maxvalattr;
		private Attribute<?> attr, mvattr;
		private float current, rotdiff, valdiff;
		private GaugeLimit limit;
		
		public <V> Gauge(String attribute, int axis, float min_rot, float max_rot, float min_value, V max_value){
			this.attribute = attribute;
			this.axis = (byte)axis;
			minrot = min_rot;
			maxrot = max_rot;
			minval = min_value;
			if(max_value instanceof GaugeLimit){
				limit = (GaugeLimit)max_value;
				maxval = min_value * 2;
			}
			else if(max_value instanceof String){
				maxvalattr = (String)max_value;
				maxval = min_value * 2;
			}
			else maxval = ((Number)max_value).floatValue();
			rotdiff = maxrot - minrot;
			valdiff = maxval - minval;
		}

		@Override
		public String id(){
			return "fvtm:gauge";
		}
		
		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			if((attr = data.vehicle.getAttribute(attribute)) == null) return;
			current = attr.asFloat() < minval ? minval : attr.asFloat();
			if(current > maxval((Entity)data.entity, data.vehicle)) current = maxval;
			list.rotate(minrot + ((current - minval) / valdiff()) * rotdiff, axis, true);
		}

		private float maxval(Entity ent, VehicleData data){
			if(maxvalattr != null && (mvattr = data.getAttribute(maxvalattr)) != null) return maxval = mvattr.asFloat();
			else if(limit != null) return maxval = limit.getMaxValue(maxval, ent, data);
			else return maxval;
		}
		
		private float valdiff(){
			if(maxvalattr != null || limit != null) return valdiff = maxval - minval;
			else return valdiff;
		}

		@Override
		public void post(ModelGroup list, ModelRenderData data){
			list.rotate(0, axis, true);
		}
		

		@Override
		public Program parse(String[] args){
			int axis = args.length < 2 ? 0 : Integer.parseInt(args[1]);
			float minr = args.length < 3 ? 0 : Float.parseFloat(args[2]);
			float maxr = args.length < 4 ? 0 : Float.parseFloat(args[3]);
			float minv = args.length < 5 ? 0 : Float.parseFloat(args[4]);
			Object maxv = 0;
			if(args.length > 5){
				if(NumberUtils.isCreatable(args[5])){
					maxv = Float.parseFloat(args[5]);
				}
				else if(GaugeLimit.parseable(args[5])){
					maxv = GaugeLimit.valueOf(args[5]);
				}
				else{
					maxv = args[5];
				}
			}
			return new Gauge(args[0], axis, minr, maxr, minv, maxv);
		}
		
	};
	
	public static enum GaugeLimit {
		
		RPM{
			@Override
			public float getMaxValue(float maxval, Entity ent, VehicleData data){
				part = data.getPart("engine");
				if(part == null) return maxval;
				func = part.getFunction("fvtm:engine");
				if(func == null) return maxval;
				return func.maxRPM();
			}
		};
		
		private static PartData part;
		private static EngineFunction func;
		
		public abstract float getMaxValue(float maxval, Entity ent, VehicleData data);

		static boolean parseable(String string){
			for(GaugeLimit limit : GaugeLimit.values()){
				if(string.equals(limit.name())) return true;
			}
			return false;
		}
		
	}
	
	public static class RotationSetter implements Program {
		
		private Float defrot;
		private int axis;
		private boolean override;
		private float rot;
		
		public RotationSetter(int axis, float rot_by, float def_rot, boolean set){
			this.override = set;
			this.axis = axis;
			defrot = def_rot;
			rot = rot_by;
		}

		@Override
		public String id(){
			return "fvtm:rotation_setter";
		}
		
		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			list.rotate(rot + defrot, axis, override);
		}
		
		@Override
		public void post(ModelGroup list, ModelRenderData data){
			list.rotate(override ? defrot : -(rot + defrot), axis, override);
		}
		

		@Override
		public Program parse(String[] args){
			int axis = Integer.parseInt(args[0]);
			float to = Float.parseFloat(args[1]);
			float def = Float.parseFloat(args[2]);
			boolean set = Boolean.parseBoolean(args[3]);
			return new RotationSetter(axis, def, to, set);
		}
		
	}
	
	public static class TranslationSetter implements Program {
		
		private float x, y, z;
		
		public TranslationSetter(float x, float y, float z){
			this(x, y, z, Static.sixteenth);
		}
		
		public TranslationSetter(float x, float y, float z, float scale){
			this.x = x * scale;
			this.y = y * scale;
			this.z = z * scale;
		}

		@Override
		public String id(){
			return "fvtm:translation_setter";
		}

		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			GL11.glPushMatrix();
			GL11.glTranslatef(x, y, z);
		}

		@Override
		public void post(ModelGroup list, ModelRenderData data){
			GL11.glPopMatrix();
		}

		@Override
		public Program parse(String[] args){
			float x = Float.parseFloat(args[0]);
			float y = Float.parseFloat(args[1]);
			float z = Float.parseFloat(args[2]);
			float s = args.length > 3 ? Float.parseFloat(args[3]) : Static.sixteenth;
			return new TranslationSetter(x, y, z, s);
		}

	}
	
	public static class TextureBinder implements Program {
		
		private ResourceLocation resloc;
		
		public TextureBinder(String rs){
			resloc = new ResourceLocation(rs);
		}
		
		public TextureBinder(ResourceLocation rs){
			resloc = rs;
		}

		@Override
		public String id(){
			return "fvtm:bind_texture";
		}
		
		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			TexUtil.bindTexture(resloc);
		}

		@Override
		public boolean post(){
			return false;
		}

		@Override
		public Program parse(String[] args){
			return new TextureBinder(args[0]);
		}
		
	}
	
	public static class TextRenderer extends Transparent {
		
		protected static Attribute<?> attr;
		protected net.minecraft.client.gui.FontRenderer font_renderer;
		protected float downscale_font = 0.00390625f;
		protected float rx, ry, rz, scale;
		protected boolean glow, no_depth_test, centered;
		protected String text = "", attrid;
		protected int color = RGB.BLACK.packed, lx, ly;
		protected Pos pos;
		
		public TextRenderer(float x, float y, float z, float rx, float ry, float rz, float scale, boolean centered){
			super(189f, 4f);
			this.centered = centered;
			this.scale = scale;
			this.rx = rx;
			this.ry = ry;
			this.rz = rz;
			pos = new Pos(-x, y, z);
		}
		
		public TextRenderer(float x, float y, float z, float rx, float ry, float rz, float scale, boolean centered, String string){
			this(x, y, z, rx, ry, rz, scale, centered);
			this.text = string;
		}
		
		public TextRenderer setFontRenderer(net.minecraft.client.gui.FontRenderer renderer){
			font_renderer = renderer;
			return this;
		}
		
		public TextRenderer disableDepthTest(boolean bool){
			no_depth_test = bool;
			return this;
		}
		
		public TextRenderer setColor(RGB rgb){
			color = rgb.packed;
			return this;
		}
		
		public TextRenderer setColor(int color){
			this.color = color;
			return this;
		}
		
		public TextRenderer setGlow(boolean bool){
			glow = bool;
			return this;
		}
		
		public TextRenderer glow(){
			glow = true;
			return this;
		}

		public TextRenderer setLightAttribute(String string){
			attrid = string;
			return this;
		}

		@Override
		public String id(){
			return "fvtm:text_renderer";
		}
		
		@Override
		public boolean pre(){
			return false;
		}

		@Override
		public void post(ModelGroup list, ModelRenderData data){
			if(text.length() == 0) return;
			if(font_renderer == null) font_renderer = Minecraft.getMinecraft().getRenderManager().getFontRenderer();
			if(font_renderer == null) return;
	        GlStateManager.pushMatrix();
			if(glow || (attrid != null && attr(data.vehicle))) super.pre(list, data);
			pos.translate();
	        RGB.WHITE.glColorApply();
	        GL11.glScalef(downscale_font, downscale_font, downscale_font);
	        if(scale != 1f){ GL11.glScalef(scale, scale, scale); }
	        GL11.glRotatef(-90, 0, 1, 0);
			if(ry != 0.0F) GL11.glRotatef(ry, 0.0F, 1.0F, 0.0F);
	        if(rz != 0.0F) GL11.glRotatef(rz, 0.0F, 0.0F, 1.0F);
	        if(rx != 0.0F) GL11.glRotatef(rx, 1.0F, 0.0F, 0.0F);
	        GlStateManager.depthMask(false);
	        if(no_depth_test) GL11.glDisable(GL11.GL_DEPTH_TEST);
	        font_renderer.drawString(text, centered ? -font_renderer.getStringWidth(text) / 2 : 0, 0, this.color);
	        if(no_depth_test) GL11.glEnable(GL11.GL_DEPTH_TEST);
	        GlStateManager.depthMask(true);
	        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			if(glow || (attrid != null && attr(data.vehicle))) super.post(list, data                                                                                                                    );
	        GlStateManager.popMatrix();
		}
		
		protected boolean attr(VehicleData data){
			attr = data.getAttribute(attrid);
			return attr != null && attr.asBoolean();
		}
		

		@Override
		public Program parse(String[] args){
			float px = args.length > 0 ? Float.parseFloat(args[0]) : 0;
			float py = args.length > 1 ? Float.parseFloat(args[1]) : 0;
			float pz = args.length > 2 ? Float.parseFloat(args[2]) : 0;
			float rx = args.length > 3 ? Float.parseFloat(args[3]) : 0;
			float ry = args.length > 4 ? Float.parseFloat(args[4]) : 0;
			float rz = args.length > 5 ? Float.parseFloat(args[5]) : 0;
			float scale = args.length > 6 ? Float.parseFloat(args[6]) : 4;
			boolean cen = args.length > 7 ? Boolean.parseBoolean(args[7]) : true;
			String text = args.length > 8 && !args[8].equals("null") ? args[8] : "";
			int color = args.length > 9 ? new RGB(args[9]).packed : RGB.BLACK.packed;
			boolean glow = args.length > 10 ? Boolean.parseBoolean(args[10]) : false;
			return new TextRenderer(px, py, pz, rx, ry, rz, scale, cen, text).setColor(color).setGlow(glow);
		}
		
	}
	
	public static class AttributeTextRenderer extends TextRenderer {
		
		protected Attribute<?> attr;
		protected String attribute;
		
		public AttributeTextRenderer(String attribute, float x, float y, float z, float rx, float ry, float rz, float scale, boolean centered){
			super(x, y, z, rx, ry, rz, scale, centered);
			this.attribute = attribute;
		}

		@Override
		public String id(){
			return "fvtm:attr_text_renderer";
		}
		
		@Override
		public boolean pre(){
			return true;
		}
		
		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			if((attr = data.vehicle.getAttribute(attribute)) == null) return;
			text = attr.asString();
		}
		

		@Override
		public Program parse(String[] args){
			float px = args.length > 0 ? Float.parseFloat(args[0]) : 0;
			float py = args.length > 1 ? Float.parseFloat(args[1]) : 0;
			float pz = args.length > 2 ? Float.parseFloat(args[2]) : 0;
			float rx = args.length > 3 ? Float.parseFloat(args[3]) : 0;
			float ry = args.length > 4 ? Float.parseFloat(args[4]) : 0;
			float rz = args.length > 5 ? Float.parseFloat(args[5]) : 0;
			float scale = args.length > 6 ? Float.parseFloat(args[6]) : 4;
			boolean cen = args.length > 7 ? Boolean.parseBoolean(args[7]) : true;
			String attr = args.length > 8 && !args[8].equals("null") ? args[8] : "";
			int color = args.length > 9 ? new RGB(args[9]).packed : RGB.BLACK.packed;
			boolean glow = args.length > 10 ? Boolean.parseBoolean(args[10]) : false;
			return new AttributeTextRenderer(attr, px, py, pz, rx, ry, rz, scale, cen).setColor(color).setGlow(glow);
		}
		
	}
	
	public static abstract class Duplicable implements Program {

		@Override
		public void init(ModelGroup list){
			//
		}
		
	}
	
	public static class Rotator extends Duplicable {
		
		private float min, max, step = 1;
		private float defrot;
		private Float[] cd;
		private int axis;
		private boolean loop;
		private boolean override;
		
		public Rotator(float mn, float mx, float step, int axis, Float defrot, boolean loop, boolean ntadd){
			this.min = mn;
			this.max = mx;
			this.step = step;
			this.axis = axis;
			this.defrot = defrot == null ? 0 : defrot;
			if(min == max || (min == 0f && max == 0f)){
				min = -180; max = 180;
			}
			this.loop = loop;
			this.override = ntadd;
		}

		@Override
		public String id(){
			return "fvtm:rotator";
		}
		
		@Override
		public void init(ModelGroup list){
			super.init(list);
		}
		
		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			if(data.cache == null) return;
			cd = data.cache.get(this, FLOAT2_SUPP);
			if(cd[1] == 0f) cd[1] = step;
			cd[0] += cd[1];
			if(cd[0] > max){
				if(loop){
					cd[0] = min + (cd[0] - max);
					cd[1] = step;
				}
				else{
					cd[0] = max - (cd[0] - max);
					cd[1] = -step;
				}
			}
			if(cd[0] < min){
				if(loop){
					cd[0] = max + (cd[0] - min);
					cd[1] = step;
				}
				else{
					cd[0] = min - (cd[0] - min);
					cd[1] = -step;
				}
			}
			list.rotate(cd[0] + defrot, axis, override);
		}
		
		@Override
		public void post(ModelGroup list, ModelRenderData data){
			if(data.cache == null) return;
			list.rotate(override ? defrot : -(cd[0] + defrot), axis, override);
		}
		

		@Override
		public Program parse(String[] args){
			float min = Float.parseFloat(args[0]);
			float max = Float.parseFloat(args[1]);
			float step = Float.parseFloat(args[2]);
			int axis = Integer.parseInt(args[3]);
			float dero = Float.parseFloat(args[4]);
			boolean loop = Boolean.parseBoolean(args[5]);
			boolean noad = args.length > 6 ? Boolean.parseBoolean(args[6]) : true;
			return new Rotator(min, max, step, axis, dero, loop, noad);
		}
		
	}
	
	public static class Translator extends Duplicable {
		
		private boolean loop;
		private float min, max, step;
		private Float[] cd;
		private int axis;
		
		public Translator(float min, float max, float step, int axis, boolean loop){
			this.axis = axis;
			this.step = step;
			this.min = min;
			this.max = max;
			this.loop = loop;
		}

		@Override
		public String id(){
			return "fvtm:translator";
		}
		
		@Override
		public void init(ModelGroup list){
			super.init(list);
		}

		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			if(data.cache == null) return;
			cd = data.cache.get(this, FLOAT2_SUPP);
			if(cd[1] == 0) cd[1] = step;
			cd[0] += cd[1];
			if(cd[0] > max){
				if(loop){
					cd[0] = min + (cd[0] - max);
					cd[1] = step;
				}
				else{
					cd[0] = max - (cd[0] - max);
					cd[1] = -step;
				}
			}
			if(cd[0] < min){
				if(loop){
					cd[0] = max + (cd[0] - min);
					cd[1] = step;
				}
				else{
					cd[0] = min - (cd[0] - min);
					cd[1] = -step;
				}
			}
			//GL11.glPushMatrix();
			GL11.glTranslatef(
				axis == 0 ? cd[0] * Static.sixteenth : 0,
				axis == 1 ? cd[0] * Static.sixteenth : 0,
				axis == 2 ? cd[0] * Static.sixteenth : 0);
		}

		@Override
		public void post(ModelGroup list, ModelRenderData data){
			if(data.cache == null) return;
			GL11.glTranslatef(
				axis == 0 ? cd[0] * -Static.sixteenth : 0,
				axis == 1 ? cd[0] * -Static.sixteenth : 0,
				axis == 2 ? cd[0] * -Static.sixteenth : 0);
			//GL11.glPopMatrix();
		}

		@Override
		public Program parse(String[] args){
			float min = Float.parseFloat(args[0]);
			float max = Float.parseFloat(args[1]);
			float step = Float.parseFloat(args[2]);
			int axis = Integer.parseInt(args[3]);
			boolean loop = Boolean.parseBoolean(args[4]);
			return new Translator(min, max, step, axis, loop);
		}

	}

	public static class DisplayBarrel implements Program {

		private String inv;
		private int index;
		private Pos pos;

		public DisplayBarrel(){
			pos = new Pos(0, 0, 0);
			index = 0;
		}

		public DisplayBarrel(String inv, int idx, float x, float y, float z){
			pos = new Pos(x, y, z);
			this.inv = inv;
			index = idx;
		}

		@Override
		public String id(){
			return "fvtm:display_barrel";
		}

		private BlockData bdata, odata;
		private InvHandlerVar var;
		private Model model;

		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			if(data.tile == null) return;
			var = (InvHandlerVar)((MultiblockTileEntity)data.tile).getMultiBlockData().getInventory(inv);
			if(var == null || var.stackAt(index).empty()) return;
			bdata = ((ItemStack)var.stackAt(index).direct()).getCapability(Capabilities.VAPDATA, null).getBlockData();
			if(bdata.getType().getModel() == null) return;
			pos.translate();
			TexUtil.bindTexture(bdata.getTexture().getTexture());
			odata = data.block;
			data.block = bdata;
			data.color = bdata;
			bdata.getType().getModel().render(data);
			pos.translateR();
			data.block = odata;
			data.color = odata;
			TexUtil.bindTexture(data.block.getTexture().getTexture());
		}

		@Override
		public boolean post(){
			return false;
		}

		@Override
		public Program parse(String[] args){
			return new DisplayBarrel(args[0], Integer.parseInt(args[1]), Float.parseFloat(args[2]), Float.parseFloat(args[3]), Float.parseFloat(args[4]));
		}

	}

	private static boolean was_blended, was_alpha, was_alpha_tested;
	
	public static void enableBlend(){
		if(!(was_blended = GL11.glGetBoolean(GL11.GL_BLEND))) GL11.glEnable(GL11.GL_BLEND);
	}
	
	public static void disableBlend(){
		if(!was_blended) GL11.glDisable(GL11.GL_BLEND);
	}
	
	public static void enableAlpha(){
		if(!(was_alpha = GL11.glGetBoolean(GL11.GL_ALPHA_TEST))) GL11.glEnable(GL11.GL_ALPHA_TEST);
	}
	
	public static void disableAlpha(){
		if(!was_alpha) GL11.glDisable(GL11.GL_ALPHA_TEST);
	}
	
	public static void disableAlphaTest(){
		if(!(was_alpha_tested = GL11.glGetBoolean(GL11.GL_ALPHA_TEST))) GL11.glDisable(GL11.GL_ALPHA_TEST);
	}
	
	public static void enableAlphaTest(){
		if(!was_alpha_tested) GL11.glEnable(GL11.GL_ALPHA_TEST);
	}

	public static class RenderOrderSetter implements Program {

		private HashMap<RenderOrder, RenderOrderSetter> map = new HashMap<>();
		private RenderOrder order;

		private RenderOrderSetter(RenderOrder ord){
			if(ord == null){
				ord = RenderOrder.NORMAL;
				map.put(ord, this);
				map.put(RenderOrder.BLENDED, new RenderOrderSetter(RenderOrder.BLENDED));
				map.put(RenderOrder.LAST, new RenderOrderSetter(RenderOrder.LAST));
				map.put(RenderOrder.SEPARATE, new RenderOrderSetter(RenderOrder.SEPARATE));
			}
			this.order = order;
		}

		@Override
		public String id(){
			return "fvtm:render_order";
		}

		@Override
		public Program parse(String[] args){
			return map.get(RenderOrder.valueOf(args[0].toUpperCase()));
		}

	}

	public static class RotateTo implements Program {

		private float from;
		private float to;
		private float def;
		private float mul;
		private int time;
		private int axis;
		private boolean or;
		/** fl - ticks passed, bl0 - reversing, bl1 - paused*/
		private FloatBool2 progress;

		@Override
		public String id(){
			return "fvtm:rotate";
		}

		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			if(data.cache == null) return;
			progress = data.cache.get(this, FLOAT_BOOL2_SUPP);
			if(!progress.bl1){
				if(progress.bl0){
					progress.fl -= data.partialticks;
					if(progress.fl < 0) progress.fl = 0;
				}
				else{
					progress.fl += data.partialticks;
					if(progress.fl > time) progress.fl = time;
				}
			}
			mul = progress.fl / time;
			list.rotate((mul = from + (to - from) * mul) + def, axis, or);
		}

		@Override
		public void post(ModelGroup list, ModelRenderData data){
			if(data.cache == null) return;
			list.rotate(or ? def : -mul + def, axis, or);
		}

		@Override
		public Program parse(String[] args){
			RotateTo rot = new RotateTo();
			rot.axis = Integer.parseInt(args[0]);
			rot.from = Float.parseFloat(args[1]);
			rot.to = Float.parseFloat(args[2]);
			rot.time = Integer.parseInt(args[3]);
			rot.def = args.length > 4 ? Float.parseFloat(args[4]) : 0;
			rot.or = args.length > 5 && Boolean.parseBoolean(args[5]);
			return rot;
		}

		@Override
		public void reverse(ModelRenderData data, boolean bool){
			progress = data.cache.get(this, FLOAT_BOOL2_SUPP);
			progress.bl0 = bool;
		}

		@Override
		public Program pause(ModelRenderData data, boolean pause){
			data.cache.get(this, FLOAT_BOOL2_SUPP).bl1 = pause;
			return this;
		}

		@Override
		public int ticktime(){
			return time;
		}

	}

	public static class TranslateTo implements Program {

		private float fx, fy, fz;
		private float tx, ty, tz;
		/** fl - ticks passed, bl0 - reversing, bl1 - paused*/
		private FloatBool2 progress;
		private float mul;
		private int time;

		@Override
		public String id(){
			return "fvtm:translate";
		}

		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			GL11.glPushMatrix();
			progress = data.cache.get(this, FLOAT_BOOL2_SUPP);
			if(!progress.bl1){
				if(progress.bl0){
					progress.fl -= data.partialticks;
					if(progress.fl < 0) progress.fl = 0;
				}
				else{
					progress.fl += data.partialticks;
					if(progress.fl > time) progress.fl = time;
				}
			}
			mul = progress.fl / time;
			GL11.glTranslatef(fx + (tx - fx) * mul, fy + (ty - fy) * mul, fz + (tz - fz) * mul);
		}

		@Override
		public void post(ModelGroup list, ModelRenderData data){
			GL11.glPopMatrix();
		}

		@Override
		public void reverse(ModelRenderData data, boolean bool){
			progress = data.cache.get(this, FLOAT_BOOL2_SUPP);
			progress.bl0 = bool;
		}

		@Override
		public Program pause(ModelRenderData data, boolean pause){
			data.cache.get(this, FLOAT_BOOL2_SUPP).bl1 = pause;
			return this;
		}

		@Override
		public Program parse(String[] args){
			TranslateTo trs = new TranslateTo();
			trs.fx = Float.parseFloat(args[0]);
			trs.fy = Float.parseFloat(args[1]);
			trs.fz = Float.parseFloat(args[2]);
			trs.tx = Float.parseFloat(args[3]);
			trs.ty = Float.parseFloat(args[4]);
			trs.tz = Float.parseFloat(args[5]);
			trs.time = Integer.parseInt(args[6]);
			return trs;
		}

		@Override
		public int ticktime(){
			return time;
		}

	}

	public static class SignText implements Program {

		@Override
		public String id(){ return "fvtm:sign_text"; }

		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			if(data.sign == null || data.sign.text == null || data.sign.text.length() == 0) return;
			if(fr == null) fr = Minecraft.getMinecraft().getRenderManager().getFontRenderer();
			GlStateManager.pushMatrix();
			GlStateManager.scale(-0.025F, -0.025F, 0.025F);
			GlStateManager.rotate(90, 0, 1, 0);
			/*if(glow)*/ GlStateManager.disableLighting();
			fr.drawString(data.sign.text, data.sign.centered ? -fr.getStringWidth(data.sign.text) / 2 : 0, 0, data.sign.getColorChannel("text").packed - 16777216);
			/*if(glow)*/ GlStateManager.enableLighting();
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			GlStateManager.popMatrix();
		}

		@Override
		public boolean post(){
			return false;
		}

		@Override
		public Program parse(String[] args){
			return this;
		}

	}
	
}