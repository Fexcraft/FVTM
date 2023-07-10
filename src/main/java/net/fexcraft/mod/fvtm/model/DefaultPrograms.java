package net.fexcraft.mod.fvtm.model;

import static net.fexcraft.mod.fvtm.Config.BLINKER_INTERVAL;
import static net.fexcraft.mod.fvtm.Config.DISABLE_LIGHT_BEAMS;
import static net.fexcraft.mod.fvtm.util.AnotherUtil.toV3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;
import java.util.function.Predicate;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.Time;
import net.fexcraft.mod.uni.Pos;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.block.generated.MultiblockTileEntity;
import net.fexcraft.mod.fvtm.block.generated.SignalTileEntity;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.SwivelPoint;
import net.fexcraft.mod.fvtm.data.WheelSlot;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.inv.InvHandlerVar;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.root.Model;
import net.fexcraft.mod.fvtm.data.root.Model.ModelRenderData;
import net.fexcraft.mod.fvtm.data.root.Model.RenderOrder;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.ModelGroup.Program;
import net.fexcraft.mod.fvtm.render.EffectRenderer;
import net.fexcraft.mod.fvtm.sys.uni.GenericVehicle;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.fexcraft.mod.fvtm.util.function.EngineFunction;
import net.fexcraft.mod.fvtm.util.function.WheelFunction;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.apache.commons.lang3.math.NumberUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class DefaultPrograms {

	public static boolean DIDLOAD = false, BLINKER_TOGGLE;
	public static Timer BLINKER_TIMER;
	
	public static void init(){
		ModelGroup.PROGRAMS.add(RGB_PRIMARY);
		ModelGroup.PROGRAMS.add(RGB_SECONDARY);
		ModelGroup.PROGRAMS.add(new RGBCustom(0xffffff));
		ModelGroup.PROGRAMS.add(new RGBChannel("custom"));
		ModelGroup.PROGRAMS.add(INVISIBLE);
		ModelGroup.PROGRAMS.add(ALWAYS_GLOW);
		ModelGroup.PROGRAMS.add(LIGHTS);
		ModelGroup.PROGRAMS.add(FRONT_LIGHTS);
		ModelGroup.PROGRAMS.add(BACK_LIGHTS);
		ModelGroup.PROGRAMS.add(FOG_LIGHTS);
		ModelGroup.PROGRAMS.add(BRAKE_LIGHTS);
		ModelGroup.PROGRAMS.add(REVERSE_LIGHTS);
		ModelGroup.PROGRAMS.add(TURN_SIGNAL_LEFT);
		ModelGroup.PROGRAMS.add(TURN_SIGNAL_RIGHT);
		ModelGroup.PROGRAMS.add(WARNING_LIGHTS);
		ModelGroup.PROGRAMS.add(BACK_LIGHTS_SIGNAL_LEFT);
		ModelGroup.PROGRAMS.add(BACK_LIGHTS_SIGNAL_RIGHT);
		ModelGroup.PROGRAMS.add(WINDOW);
		ModelGroup.PROGRAMS.add(new WindowTinted());
		ModelGroup.PROGRAMS.add(WHEEL_AUTO_ALL);
		ModelGroup.PROGRAMS.add(WHEEL_AUTO_STEERING);
		ModelGroup.PROGRAMS.add(WHEEL_AUTO_ALL_OPPOSITE);
		ModelGroup.PROGRAMS.add(WHEEL_AUTO_STEERING_OPPOSITE);
		ModelGroup.PROGRAMS.add(NO_CULLFACE);
		ModelGroup.PROGRAMS.add(new SteeringWheel(0, 0));//jtmt/obj init only
		ModelGroup.PROGRAMS.add(new SteeringWheelCentered(0, 0));//jtmt/obj init only
		ModelGroup.PROGRAMS.add(STEERING_WHEEL_Z);
		ModelGroup.PROGRAMS.add(STEERING_WHEEL_X);
		ModelGroup.PROGRAMS.add(STEERING_WHEEL_Y);
		ModelGroup.PROGRAMS.add(STEERING_WHEEL_ZN);
		ModelGroup.PROGRAMS.add(STEERING_WHEEL_XN);
		ModelGroup.PROGRAMS.add(STEERING_WHEEL_YN);
		ModelGroup.PROGRAMS.add(STEERING_WHEEL_CZ);
		ModelGroup.PROGRAMS.add(STEERING_WHEEL_CX);
		ModelGroup.PROGRAMS.add(STEERING_WHEEL_CY);
		//
		ModelGroup.PROGRAMS.add(LIGHTS_RAIL_FORWARD);
		ModelGroup.PROGRAMS.add(LIGHTS_RAIL_BACKWARD);
		ModelGroup.PROGRAMS.add(BOGIE_AUTO);
		ModelGroup.PROGRAMS.add(BOGIE_AUTO_OPPOSITE);
		ModelGroup.PROGRAMS.add(BOGIE_FRONT);
		ModelGroup.PROGRAMS.add(BOGIE_REAR);
		//
		ModelGroup.PROGRAMS.add(BASIC_SIGNAL_CLEAR);
		ModelGroup.PROGRAMS.add(BASIC_SIGNAL_STOP);
		//
		ModelGroup.PROGRAMS.add(new Scale(1f));
		ModelGroup.PROGRAMS.add(new Scale3D(1f, 1f, 1f));
		ModelGroup.PROGRAMS.add(TRANSPARENT);
		ModelGroup.PROGRAMS.add(WINDOW);
		ModelGroup.PROGRAMS.add(new AttributeRotator("", false, 0, 0, 0, 0, 0f));//jtmt/obj init only
		ModelGroup.PROGRAMS.add(new AttributeTranslator("", false, 0, 0, 0, 0));//jtmt/obj init only
		ModelGroup.PROGRAMS.add(new AttributeVisible("", false));//jtmt/obj init only
		ModelGroup.PROGRAMS.add(new Gauge("", 0, 0, 0, 0, 0));//jtmt/obj init only
		ModelGroup.PROGRAMS.add(new RotationSetter(0, 0, 0, false));//jtmt/obj init only
		ModelGroup.PROGRAMS.add(new TranslationSetter(0, 0, 0, 0));//jtmt/obj init only
		ModelGroup.PROGRAMS.add(new TextureBinder("minecraft:textures/blocks/stone.png"));
		ModelGroup.PROGRAMS.add(TEXTURE_BINDER_SELECTED);
		ModelGroup.PROGRAMS.add(TEXTURE_BINDER_BLOCK_4x4ROT);
		ModelGroup.PROGRAMS.add(TEXTURE_BINDER_BLOCK_VARIANT);
		ModelGroup.PROGRAMS.add(RESCALE_NORMAL);
		ModelGroup.PROGRAMS.add(new TextRenderer(0, 0, 0, 0, 0, 0, 0, true));
		ModelGroup.PROGRAMS.add(new AttributeTextRenderer("", 0, 0, 0, 0, 0, 0, 0, true));
		ModelGroup.PROGRAMS.add(new Rotator(0, 0, 0, 0, null, false, false));//parsed init only
		ModelGroup.PROGRAMS.add(new Translator(0, 0, 0, 0, false));//parsed init only
		ModelGroup.PROGRAMS.add(new BlockBoolRotator("", true, 0, 0, 0, 0, 0f));//jtmt/obj init only
		ModelGroup.PROGRAMS.add(new BlockBoolTranslator("", true, 0, 0, 0, 0));//jtmt/obj init only
		ModelGroup.PROGRAMS.add(new BlockBoolVisible("", true));//jtmt/obj init only
		ModelGroup.PROGRAMS.add(new Block4x4RotVisible(0));
		ModelGroup.PROGRAMS.add(new BlockVariantVisible(0));
		ModelGroup.PROGRAMS.add(new DisplayBarrel());
		ModelGroup.PROGRAMS.add(new TextureSetter("minecraft:textures/blocks/stone.png"));
		ModelGroup.PROGRAMS.add(new BlockFacePlayer(0, 0, 0));
		ModelGroup.PROGRAMS.add(new RenderOrderSetter(null));
		//
		DIDLOAD = true;
	}

	@SuppressWarnings("deprecation")
	public static final Program RGB_PRIMARY = new Program(){
		@Override
		public String getId(){ return "fvtm:rgb_primary"; }
		@Override
		public void preRender(ModelGroup list, ModelRenderData data){ if(data.color != null) data.color.getPrimaryColor().glColorApply(); }
		@Override
		public void postRender(ModelGroup list, ModelRenderData data){ RGB.glColorReset(); }
	};

	@SuppressWarnings("deprecation")
	public static final Program RGB_SECONDARY = new Program(){
		@Override
		public String getId(){ return "fvtm:rgb_secondary"; }
		@Override
		public void preRender(ModelGroup list, ModelRenderData data){ if(data.color != null) data.color.getSecondaryColor().glColorApply(); }
		@Override
		public void postRender(ModelGroup list, ModelRenderData data){ RGB.glColorReset(); }
	};
	
	public static class RGBCustom implements Program {
		
		private RGB color;
		
		public RGBCustom(int color){
			this.color = new RGB(color);
		}
		
		public RGBCustom(RGB rgb){
			color = rgb;
		}
		
		@Override
		public String getId(){
			return "fvtm:rgb_custom";
		}
		
		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
			this.color.glColorApply();
		}
		
		@Override
		public void postRender(ModelGroup list, ModelRenderData data){
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
		public String getId(){
			return "fvtm:rgb_channel";
		}
		
		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
			data.color.getColorChannel(channel).glColorApply();
		}
		
		@Override
		public void postRender(ModelGroup list, ModelRenderData data){
			RGB.glColorReset();
		}

		@Override
		public Program parse(String[] args){
			return new RGBChannel(args[0]);
		}
		
	}
	
	public static final Program INVISIBLE = new Program(){
		@Override
		public String getId(){ return "fvtm:hide"; }
		@Override
		public void preRender(ModelGroup list, ModelRenderData data){ list.visible = false; }
		@Override
		public void postRender(ModelGroup list, ModelRenderData data){ list.visible = true; }
	}, HIDE = INVISIBLE;
	
	public static final Program ALWAYS_GLOW = new AlwaysGlow(){
		@Override
		public boolean shouldGlow(ModelGroup list, ModelRenderData data){ return true; }
		@Override
		public String getId(){ return "fvtm:glow"; }
	}, GLOW = ALWAYS_GLOW;
	
	public static final Program LIGHTS = new AlwaysGlow(){
		@Override
		public boolean shouldGlow(ModelGroup list, ModelRenderData data){ return data.vehicle.getLightsState(); }
		@Override
		public String getId(){ return "fvtm:lights"; }
	};
	
	public static final Program FRONT_LIGHTS = new AlwaysGlow(){
		@Override
		public boolean shouldGlow(ModelGroup list, ModelRenderData data){ return data.vehicle.getLightsState(); }
		@Override
		public String getId(){ return "fvtm:front_lights"; }
	};
	
	public static final Program BACK_LIGHTS = new AlwaysGlow(){
		@Override
		public boolean shouldGlow(ModelGroup list, ModelRenderData data){ return data.vehicle.getLightsState() || data.vehicle.getThrottle() < -0.01 || (data.entity != null && ((GenericVehicle)data.entity).isBraking()); }//TODO rear+brake lights instead
		@Override
		public String getId(){ return "fvtm:back_lights"; }
	};
	public static final Program REAR_LIGHTS = BACK_LIGHTS;
	
	public static final Program FOG_LIGHTS = new AlwaysGlow(){
		@Override
		public boolean shouldGlow(ModelGroup list, ModelRenderData data){ return data.vehicle.getFogLightsState(); }
		@Override
		public String getId(){ return "fvtm:fog_lights"; }
	};
	public static final Program LONG_LIGHTS = new AlwaysGlow(){
		@Override
		public boolean shouldGlow(ModelGroup list, ModelRenderData data){ return data.vehicle.getLongLightsState(); }
		@Override
		public String getId(){ return "fvtm:long_lights"; }
	};
	
	public static final Program REVERSE_LIGHTS = new AlwaysGlow(){
		@Override
		public boolean shouldGlow(ModelGroup list, ModelRenderData data){ return data.vehicle.getThrottle() < -0.01; }
		@Override
		public String getId(){ return "fvtm:reverse_lights"; }
	};
	public static final Program BRAKE_LIGHTS = new AlwaysGlow(){
		@Override
		public boolean shouldGlow(ModelGroup list, ModelRenderData data){ return (data.entity != null && ((GenericVehicle)data.entity).isBraking()); }
		@Override
		public String getId(){ return "fvtm:brake_lights"; }
	};
	
	public static final Program LIGHTS_RAIL_FORWARD = new AlwaysGlow(){
		@Override
		public boolean shouldGlow(ModelGroup list, ModelRenderData data){ return data.vehicle.getLightsState() && data.vehicle.getAttribute("forward").boolean_value(); }
		@Override
		public String getId(){ return "fvtm:lights_rail_forward"; }
	};
	
	public static final Program LIGHTS_RAIL_BACKWARD = new AlwaysGlow(){
		@Override
		public boolean shouldGlow(ModelGroup list, ModelRenderData data){ return data.vehicle.getLightsState() && !data.vehicle.getAttribute("forward").boolean_value(); }
		@Override
		public String getId(){ return "fvtm:lights_rail_backward"; }
	};
	
	public static final Program TURN_SIGNAL_LEFT = new AlwaysGlow(){
		@Override
		public boolean shouldGlow(ModelGroup list, ModelRenderData data){ return BLINKER_TOGGLE && (data.vehicle.getTurnLightLeft() || data.vehicle.getWarningLights()); }
		@Override
		public String getId(){ return "fvtm:turn_signal_left"; }
	};
	
	public static final Program TURN_SIGNAL_RIGHT = new AlwaysGlow(){
		@Override
		public boolean shouldGlow(ModelGroup list, ModelRenderData data){ return BLINKER_TOGGLE && (data.vehicle.getTurnLightRight() || data.vehicle.getWarningLights()); }
		@Override
		public String getId(){ return "fvtm:turn_signal_right"; }
	};
	
	public static final Program WARNING_LIGHTS = new AlwaysGlow(){
		@Override
		public boolean shouldGlow(ModelGroup list, ModelRenderData data){ return BLINKER_TOGGLE && data.vehicle.getWarningLights(); }
		@Override
		public String getId(){ return "fvtm:warning_lights"; }
	};
	
	public static final Program INDICATOR_LIGHT_LEFT = TURN_SIGNAL_LEFT, INDICATOR_LIGHT_RIGHT = TURN_SIGNAL_RIGHT;
	
	public static final Program BACK_LIGHTS_SIGNAL_LEFT = new AlwaysGlow(){
		@Override
		public boolean shouldGlow(ModelGroup list, ModelRenderData data){
			if(data.vehicle.getTurnLightLeft() || data.vehicle.getWarningLights()) return BLINKER_TOGGLE;
			else return data.vehicle.getLightsState() || data.vehicle.getThrottle() < -0.01;
		}
		@Override
		public String getId(){ return "fvtm:back_lights_signal_left"; }
	};
	
	public static final Program BACK_LIGHTS_SIGNAL_RIGHT = new AlwaysGlow(){
		@Override
		public boolean shouldGlow(ModelGroup list, ModelRenderData data){
			if(data.vehicle.getTurnLightRight() || data.vehicle.getWarningLights()) return BLINKER_TOGGLE;
			else return data.vehicle.getLightsState() || data.vehicle.getThrottle() < -0.01;
		}
		@Override
		public String getId(){ return "fvtm:back_lights_signal_right"; }
	};
	
	public static final Program TAIL_LIGHTS_SIGNAL_LEFT = BACK_LIGHTS_SIGNAL_LEFT;
	public static final Program TAIL_LIGHTS_SIGNAL_RIGHT = BACK_LIGHTS_SIGNAL_RIGHT;
	
	//
	
	public static final Program BASIC_SIGNAL_CLEAR = new AlwaysGlow(){
		@Override
		public boolean shouldGlow(ModelGroup list, ModelRenderData data){
			return data.tile != null && ((SignalTileEntity)data.tile).getSignalState() == 1;
		}
		@Override
		public String getId(){ return "fvtm:basic_signal_clear"; }
	};
	public static final Program BASIC_SIGNAL_GREEN = BASIC_SIGNAL_CLEAR;
	
	public static final Program BASIC_SIGNAL_STOP = new AlwaysGlow(){
		@Override
		public boolean shouldGlow(ModelGroup list, ModelRenderData data){
			return data.tile == null || ((SignalTileEntity)data.tile).getSignalState() == 0;
		}
		@Override
		public String getId(){ return "fvtm:basic_signal_stop"; }
	};
	public static final Program BASIC_SIGNAL_RED = BASIC_SIGNAL_STOP;
	
	//
	
	public static final Program TRANSPARENT = new Transparent(63f, 63f){
		@Override
		public String getId(){ return "fvtm:transparent"; }
	};
	
	public static final Window WINDOW = new Window();
	
	public static final class Window implements Program {
		
		public Window(){}

		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
            GlStateManager.pushMatrix();
            enableBlend();
            GL11.glDepthMask(false);
            enableAlpha();
		}

		@Override
		public void postRender(ModelGroup list, ModelRenderData data){
            disableAlpha();
            GL11.glDepthMask(true);
            disableBlend();
            GlStateManager.popMatrix();
		}
		
		@Override
		public String getId(){
			return "fvtm:window";
		}
		@Override
		public RenderOrder getRenderOrder(){
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
		public void preRender(ModelGroup list, ModelRenderData data){
			GlStateManager.pushMatrix();
			enableBlend();
			GL11.glDepthMask(false);
			enableAlpha();
			this.color.glColorApply();
		}

		@Override
		public void postRender(ModelGroup list, ModelRenderData data){
			RGB.glColorReset();
			disableAlpha();
			GL11.glDepthMask(true);
			disableBlend();
			GlStateManager.popMatrix();
		}

		@Override
		public String getId(){
			return "fvtm:window_tinted";
		}

		@Override
		public Program parse(String[] args){
			int color = args.length > 0 ? Integer.parseInt(args[0].replace("#", "").replace("0x", ""), 16) : 0x007208;
			float alpha = args.length > 1 ? Float.parseFloat(args[1]) : 0.3f;
			return new WindowTinted(color, alpha);
		}

		@Override
		public RenderOrder getRenderOrder(){
			return RenderOrder.LAST;
		}

	}
	
	public static final Program WHEEL_AUTO_ALL = new Program(){
		
		private WheelSlot slot;
		
		@Override
		public String getId(){ return "fvtm:wheel_auto_all"; }
		
		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
			slot = data.part.getFunction(WheelFunction.class, "fvtm:wheel").getWheelPos(data.vehicle);
			if(slot != null && slot.steering()) GL11.glRotatef(data.vehicle.getAttribute("steering_angle").float_value(), 0, 1, 0);
			GL11.glRotatef(data.vehicle.getAttribute("wheel_angle").float_value(), 0, 0, 1);
			if(slot != null && slot.yrot() != 0f) GL11.glRotatef(slot.yrot(), 0, 1, 0);
		}
		
		@Override
		public void postRender(ModelGroup list, ModelRenderData data){
			if(slot != null && slot.yrot() != 0f) GL11.glRotatef(-slot.yrot(), 0, 1, 0);
			GL11.glRotatef(-data.vehicle.getAttribute("wheel_angle").float_value(), 0, 0, 1);
			if(slot != null && slot.steering()) GL11.glRotatef(-data.vehicle.getAttribute("steering_angle").float_value(), 0, 1, 0);
		}
		
	};
	
	public static final Program WHEEL_AUTO_ALL_OPPOSITE = new Program(){
		
		private WheelSlot slot;
		
		@Override
		public String getId(){ return "fvtm:wheel_auto_all_opposite"; }
		
		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
			slot = data.part.getFunction(WheelFunction.class, "fvtm:wheel").getWheelPos(data.vehicle);
			if(slot != null && slot.steering()) GL11.glRotatef(-data.vehicle.getAttribute("steering_angle").float_value(), 0, 1, 0);
			GL11.glRotatef(data.vehicle.getAttribute("wheel_angle").float_value(), 0, 0, 1);
			if(slot != null && slot.yrot() != 0f) GL11.glRotatef(slot.yrot(), 0, 1, 0);
		}
		
		@Override
		public void postRender(ModelGroup list, ModelRenderData data){
			if(slot != null && slot.yrot() != 0f) GL11.glRotatef(-slot.yrot(), 0, 1, 0);
			GL11.glRotatef(-data.vehicle.getAttribute("wheel_angle").float_value(), 0, 0, 1);
			if(slot != null && slot.steering()) GL11.glRotatef(data.vehicle.getAttribute("steering_angle").float_value(), 0, 1, 0);
		}
		
	};
	
	public static final Program WHEEL_AUTO_STEERING = new Program(){
		
		private WheelSlot slot;
		
		@Override
		public String getId(){ return "fvtm:wheel_auto_steering"; }
		
		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
			slot = data.part.getFunction(WheelFunction.class, "fvtm:wheel").getWheelPos(data.vehicle);
			if(slot != null && slot.yrot() != 0f) GL11.glRotatef(slot.yrot(), 0, 1, 0);
			if(slot != null && slot.steering()) GL11.glRotatef(data.vehicle.getAttribute("steering_angle").float_value(), 0, 1, 0);
		}
		
		@Override
		public void postRender(ModelGroup list, ModelRenderData data){
			if(slot != null && slot.steering()) GL11.glRotatef(-data.vehicle.getAttribute("steering_angle").float_value(), 0, 1, 0);
			if(slot != null && slot.yrot() != 0f) GL11.glRotatef(-slot.yrot(), 0, 1, 0);
		}
		
	};
	
	public static final Program WHEEL_AUTO_STEERING_OPPOSITE = new Program(){
		
		private WheelSlot slot;
		
		@Override
		public String getId(){ return "fvtm:wheel_auto_steering_opposite"; }
		
		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
			slot = data.part.getFunction(WheelFunction.class, "fvtm:wheel").getWheelPos(data.vehicle);
			if(slot != null && slot.yrot() != 0f) GL11.glRotatef(slot.yrot(), 0, 1, 0);
			if(slot != null && slot.steering()) GL11.glRotatef(-data.vehicle.getAttribute("steering_angle").float_value(), 0, 1, 0);
		}
		
		@Override
		public void postRender(ModelGroup list, ModelRenderData data){
			if(slot != null && slot.steering()) GL11.glRotatef(data.vehicle.getAttribute("steering_angle").float_value(), 0, 1, 0);
			if(slot != null && slot.yrot() != 0f) GL11.glRotatef(-slot.yrot(), 0, 1, 0);
		}
		
	};

	public static final Program BOGIE_AXLE_WHEEL = new Program(){
		
		@Override
		public String getId(){ return "fvtm:bogie_axle_wheel"; }
		
		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
			//
		}
		
		@Override
		public void postRender(ModelGroup list, ModelRenderData data){
			//
		}
		
	};

	public static final Program BOGIE_AUTO = new Program(){
		
		@Override
		public String getId(){ return "fvtm:bogie_auto"; }
		
		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
			GL11.glRotatef(data.vehicle.getAttribute(data.part_category + "_angle").float_value(), 0, 1, 0);
		}
		
		@Override
		public void postRender(ModelGroup list, ModelRenderData data){
			GL11.glRotatef(-data.vehicle.getAttribute(data.part_category + "_angle").float_value(), 0, 1, 0);
		}
		
	};

	public static final Program BOGIE_AUTO_OPPOSITE = new Program(){
		
		@Override
		public String getId(){ return "fvtm:bogie_auto_opposite"; }
		
		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
			GL11.glRotatef(-data.vehicle.getAttribute(data.part_category + "_angle").float_value(), 0, 1, 0);
		}
		
		@Override
		public void postRender(ModelGroup list, ModelRenderData data){
			GL11.glRotatef(data.vehicle.getAttribute(data.part_category + "_angle").float_value(), 0, 1, 0);
		}
		
	};
	
	public static final Program BOGIE_FRONT = new Program(){
		
		@Override
		public String getId(){ return "fvtm:bogie_front"; }
		
		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
			GL11.glRotatef(data.vehicle.getAttribute("bogie_front_angle").float_value(), 0, 1, 0);
		}
		
		@Override
		public void postRender(ModelGroup list, ModelRenderData data){
			GL11.glRotatef(-data.vehicle.getAttribute("bogie_front_angle").float_value(), 0, 1, 0);
		}
		
	};
	
	public static final Program BOGIE_REAR = new Program(){
		
		@Override
		public String getId(){ return "fvtm:bogie_rear"; }
		
		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
			GL11.glRotatef(data.vehicle.getAttribute("bogie_rear_angle").float_value(), 0, 1, 0);
		}
		
		@Override
		public void postRender(ModelGroup list, ModelRenderData data){
			GL11.glRotatef(-data.vehicle.getAttribute("bogie_rear_angle").float_value(), 0, 1, 0);
		}
		
	};
	
	public static final Program STEERING_WHEEL_Z = new SteeringWheel(2, 1f);
	public static final Program STEERING_WHEEL_X = new SteeringWheel(0, 1f);
	public static final Program STEERING_WHEEL_Y = new SteeringWheel(1, 1f);
	public static final Program STEERING_WHEEL_ZN = new SteeringWheel(2, 1f, false);
	public static final Program STEERING_WHEEL_XN = new SteeringWheel(0, 1f, false);
	public static final Program STEERING_WHEEL_YN = new SteeringWheel(1, 1f, false);
	public static final Program STEERING_WHEEL_CZ = new SteeringWheelCentered(2, 1f);
	public static final Program STEERING_WHEEL_CX = new SteeringWheelCentered(0, 1f);
	public static final Program STEERING_WHEEL_CY = new SteeringWheelCentered(1, 1f);
	
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
		public String getId(){
			return id;
		}
		
		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
			list.rotateAxis(rotated = data.vehicle.getAttribute("steering_angle").float_value() * ratio, axis, apply);
		}
		
		@Override
		public void postRender(ModelGroup list, ModelRenderData data){
			list.rotateAxis(-rotated, axis, apply);
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
		public String getId(){
			return id;
		}
		
		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
			GL11.glRotatef(data.vehicle.getAttribute("steering_angle").float_value() * ratio, x, y, z);
		}
		
		@Override
		public void postRender(ModelGroup list, ModelRenderData data){
			GL11.glRotatef(-data.vehicle.getAttribute("steering_angle").float_value() * ratio, x, y, z);
		}
		

		@Override
		public Program parse(String[] args){
			return new SteeringWheelCentered(Integer.parseInt(args[0]), Float.parseFloat(args[1]));
		}
		
	}
	
	public static abstract class AttributeBased implements Program {
		
		private static final TreeMap<String, Integer> linked = new TreeMap<>();
		protected String attribute, cacheid;
		
		public AttributeBased(String attr){
			this.attribute = attr;
		}

		@Override
		public void init(ModelGroup list){
			if(cacheid != null) return;
			if(linked.containsKey(attribute)){
				cacheid = attribute + "_" + linked.get(attribute);
				linked.put(attribute, linked.get(attribute) + 1);
			}
			else{
				cacheid = attribute + "_0";
				linked.put(attribute, 1);
			}
		}
		
	}
	
	public static class AttributeRotator extends AttributeBased {
		
		private Attribute<?> attr;
		private float min, max, step = 1;
		private Float current;
		private int axis;
		private boolean boolstatebased, override;
		private float defrot;
		
		public AttributeRotator(String attribute, boolean boolstatebased, float min, float max, float step, int axis, Float defrot){
			super(attribute);
			this.boolstatebased = boolstatebased;
			this.override = true;
			this.min = min; 
			this.max = max;
			this.step = step;
			this.axis = axis;
			this.defrot = defrot == null ? 0 : defrot;
			if(min == max || (min == 0f && max == 0f)){
				min = -360; max = 360;
			}
		}
		
		public AttributeRotator(String attribute, boolean boolstatebased, float min, float max, float step, int axis, Float defrot, boolean notadditive){
			this(attribute, boolstatebased, min, max, step, axis, defrot);
			this.override = notadditive;
		}

		@Override
		public String getId(){
			return "fvtm:attribute_rotator";
		}
		
		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
			if(data.cache == null) return;
			if((attr = data.vehicle.getAttribute(attribute)) == null) return;
			current = data.cache.getValue(cacheid);
			if(current == null) current = 0f;
			current = boolstatebased ? (attr.boolean_value() ? current + step : current - step) : attr.float_value() * step;
			if(current > max) current = max;
			if(current < min) current = min;
			list.rotateAxis(current + defrot, axis, override);
			data.cache.setValue(cacheid, current);
		}
		
		@Override
		public void postRender(ModelGroup list, ModelRenderData data){
			if(data.cache == null || attr == null) return;
			list.rotateAxis(override ? defrot : -(current + defrot), axis, override);
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
		
		private Attribute<?> attr;
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
		public String getId(){
			return "fvtm:attribute_translator";
		}

		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
			if(data.cache == null) return;
			if((attr = data.vehicle.getAttribute(attribute)) == null) return;
			current = data.cache.getValue(cacheid);
			if(current == null) current = 0f;
			current = bool ? (attr.boolean_value() ? current + step : current - step) : attr.float_value();
			if(current > max) current = max; if(current < min) current = min;
			//GL11.glPushMatrix();
			GL11.glTranslatef(
				axis == 0 ? current * Static.sixteenth : 0,
				axis == 1 ? current * Static.sixteenth : 0,
				axis == 2 ? current * Static.sixteenth : 0);
			data.cache.setValue(cacheid, current);
		}

		@Override
		public void postRender(ModelGroup list, ModelRenderData data){
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
		
		private Attribute<?> attr; private String attribute; boolean equals;
		
		public AttributeVisible(String attribute, boolean equals){
			this.attribute = attribute; this.equals = equals;
		}

		@Override
		public String getId(){ return "fvtm:attribute_visible"; }
		
		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
			attr = data.vehicle.getAttribute(attribute); if(attr == null) return;
			if(attr.boolean_value() != equals) list.visible = false;
		}
		
		@Override
		public void postRender(ModelGroup list, ModelRenderData data){
			list.visible = true;
		}

		@Override
		public Program parse(String[] args){
			return new AttributeVisible(args[0], args.length > 1 ? Boolean.parseBoolean(args[1]) : false);
		}
		
	}
	
	public static abstract class AlwaysGlow extends Transparent implements Program {

		private boolean didglow;
		
		public AlwaysGlow(){ super(189f, 4f); }
		
		public boolean shouldGlow(ModelGroup list, ModelRenderData data){ return true; }

		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
			if(!(didglow = shouldGlow(list, data))) return;
			super.preRender(list, data);
		}

		@Override
		public void postRender(ModelGroup list, ModelRenderData data){
			if(!didglow) return;
			super.postRender(list, data);
		}
		
	}
	
	public static class Transparent implements Program {
		
		protected float lx, ly, x, y;
		
		public Transparent(float mapx, float mapy){ x = mapx; y = mapy; }

		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
	        enableBlend();
	        disableAlphaTest();
	        GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.SRC_COLOR);
	        //if(ent != null) GlStateManager.depthMask(!ent.isInvisible());
	        lx = OpenGlHelper.lastBrightnessX; ly = OpenGlHelper.lastBrightnessY;
	        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, x, y);
	        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		}

		@Override
		public void postRender(ModelGroup list, ModelRenderData data){
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
		public RenderOrder getRenderOrder(){
			return RenderOrder.BLENDED;
		}
		
	}
	
	public static class IDSpecific implements Program {
		
		private String group;
		
		public IDSpecific(String id){ this.group = id; }

		@Override
		public String getId(){ return "fvtm:category_specific"; }

		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
			if(!data.part_category.equals(group)) list.visible = false;
		}

		@Override
		public void postRender(ModelGroup list, ModelRenderData data){
			list.visible = true;
		}

		@Override
		public Program parse(String[] args){
			return new IDSpecific(args[0]);
		}

	}
	
	public static class IDSpecificArray implements Program {
		
		private String[] groups;
		
		public IDSpecificArray(String... ids){ this.groups = ids; }

		@Override
		public String getId(){ return "fvtm:category_specific_array"; }

		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
			for(String str : groups) if(str.equals(data.part_category)) return; list.visible = false;
		}

		@Override
		public void postRender(ModelGroup list, ModelRenderData data){
			list.visible = true;
		}

		@Override
		public Program parse(String[] args){
			return new IDSpecificArray(args);
		}

	}
	
	public static final Program NO_CULLFACE = new Program(){
		@Override
		public String getId(){ return "fvtm:no_cullface"; }
		//
		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
            GL11.glDisable(GL11.GL_CULL_FACE);
		}
		//
		@Override
		public void postRender(ModelGroup list, ModelRenderData data){
            GL11.glEnable(GL11.GL_CULL_FACE);
		}
	};
	
	public static class Scale implements Program {
		
		private float scale;
		
		public Scale(float scale){ this.scale = scale; }

		@Override
		public String getId(){
			return "fvtm:scale";
		}
		
		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
			GL11.glPushMatrix();
			GL11.glScalef(scale, scale, scale);
		}

		@Override
		public void postRender(ModelGroup list, ModelRenderData data){
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
		public String getId(){ return "fvtm:scale_3d"; }
		
		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
			GL11.glPushMatrix();
			GL11.glScalef(x, y, z);
		}

		@Override
		public void postRender(ModelGroup list, ModelRenderData data){
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
	
	public static class LightBeam implements Program {

		public Vec3d pos;
		public ModelRendererTurbo shape;
		public String swivel;
		public ResourceLocation tex;
		protected Predicate<ModelRenderData> predicate;
		public static ResourceLocation last;
		private boolean skipped;
		
		public LightBeam(){}
		
		public LightBeam init(ModelRendererTurbo turboobj, Vec3d pos, String swivelpoint, ResourceLocation texture, Predicate<ModelRenderData> predicate){
			this.shape = turboobj;
			this.pos = pos;
			this.tex = texture;
			this.predicate = predicate;
			return this;
		}
		
		public LightBeam init(ModelRendererTurbo turboobj, Vec3d pos, ResourceLocation texture, Predicate<ModelRenderData> predicate){
			this.shape = turboobj;
			this.pos = pos;
			this.tex = texture;
			this.predicate = predicate;
			return this;
		}
		
		public LightBeam setPredicate(Predicate<ModelRenderData> predicate){
			this.predicate = predicate;
			return this;
		}

		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
			if(data.itemrender || !data.separaterender || DISABLE_LIGHT_BEAMS) return;
			skipped = false;
			if(!predicate.test(data)){
				skipped = true;
				return;
			}
			else{
				TexUtil.bindTexture(EffectRenderer.LIGHT_TEXTURE);
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glDepthMask(false);
				GL11.glEnable(GL11.GL_ALPHA_TEST);
				GlStateManager.blendFunc(GlStateManager.SourceFactor.DST_COLOR, GlStateManager.DestFactor.SRC_ALPHA);
				if(tex != null){
					if(last == null || !last.equals(tex)){
						TexUtil.bindTexture(last = tex);
					}
				}
				else if(last != null){
					last = null;
					TexUtil.bindTexture(EffectRenderer.LIGHT_TEXTURE);
				}
				GL11.glPushMatrix();
				if(swivel == null || swivel.equals("vehicle")){
					GL11.glTranslated(pos.x, pos.y, pos.z);
				}
				else{
					SwivelPoint point = data.vehicle.getRotationPoint(swivel);
					Vec3d pos = point.getRelativeVector(this.pos, true);
					GL11.glRotated(-180f, 0.0F, 1.0F, 0.0F);
					GL11.glRotated(-180f, 0.0F, 0.0F, 1.0F);
					GL11.glTranslated(pos.x, pos.y, pos.z);
					GL11.glRotated(180f, 0.0F, 1.0F, 0.0F);
					GL11.glRotated(180f, 0.0F, 0.0F, 1.0F);
				}
				GL11.glColor4f(1, 1, 1, 0.5F);
				shape.render();
				GL11.glColor4f(1, 1, 1, 0.5F);
				shape.render();
				GL11.glPopMatrix();
			}
		}

		@Override
		public void postRender(ModelGroup list, ModelRenderData data){
			if(data.itemrender || !data.separaterender || DISABLE_LIGHT_BEAMS) return;
			if(skipped){
				skipped = false;
				return;
			}
			GL11.glDisable(GL11.GL_ALPHA_TEST);
			GL11.glDepthMask(true);
			GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
			GL11.glDisable(GL11.GL_BLEND);
		}

		@Override
		public RenderOrder getRenderOrder(){
			return RenderOrder.SEPARATE;
		}
		
	}
	
	public static class RectLightBeam extends LightBeam {
		
		private String id;
		
		public RectLightBeam(String id){
			this.id = id;
		}
		
		@Override
		public String getId(){
			return id;
		}

		public RectLightBeam init(float sx, float sy, float sz, float expw, float exph, float x, float y, float z, float rx, float ry, float rz, String swivelpoint, String resloc){
			RectLightBeam beam = new RectLightBeam(id);
			beam.init(new ModelRendererTurbo(null, 0, 0, 16, 16).newBoxBuilder()
				.setOffset(0, -(sy / 2), -(sz / 2)).setSize(sx, sy, sz)
				.setCorners(0, 0, 0, 0, exph, expw, 0, exph, expw, 0, 0, 0, 0, 0, 0, 0, exph, expw, 0, exph, expw, 0, 0, 0)
				.removePolygons(0, 1)
				.setPolygonUV(2, new float[]{ 16.0f, 0.0f, 0.0f, 0.0f, 0.0f, 4.0f, 16.0f, 4.0f })
				.setPolygonUV(3, new float[]{ 16.0f, 4.0f, 0.0f, 4.0f, 0.0f, 8.0f, 16.0f, 8.0f })
				.setPolygonUV(4, new float[]{ 16.0f, 8.0f, 0.0f, 8.0f, 0.0f, 12.0f, 16.0f, 12.0f })
				.setPolygonUV(5, new float[]{ 0.0f, 12.0f, 16.0f, 12.0f, 16.0f, 16.0f, 0.0f, 16.0f })
				.build().setRotationAngle(rx, ry, rz).addChild(
					new ModelRendererTurbo(null, 0, 0, 16, 16).setFlipped(true).newBoxBuilder()
					.setOffset(0, -(sy / 2), -(sz / 2)).setSize(sx, sy, sz)
					.setCorners(0, 0, 0, 0, exph, expw, 0, exph, expw, 0, 0, 0, 0, 0, 0, 0, exph, expw, 0, exph, expw, 0, 0, 0)
					.removePolygons(0, 1)
					.setPolygonUV(2, new float[]{ 16.0f, 0.0f, 0.0f, 0.0f, 0.0f, 4.0f, 16.0f, 4.0f })
					.setPolygonUV(3, new float[]{ 16.0f, 4.0f, 0.0f, 4.0f, 0.0f, 8.0f, 16.0f, 8.0f })
					.setPolygonUV(4, new float[]{ 16.0f, 8.0f, 0.0f, 8.0f, 0.0f, 12.0f, 16.0f, 12.0f })
					.setPolygonUV(5, new float[]{ 0.0f, 12.0f, 16.0f, 12.0f, 16.0f, 16.0f, 0.0f, 16.0f })
					.build()
				),
				toV3(new Pos(x, y, z)), swivelpoint, resloc == null ? null : new ResourceLocation(resloc), null
			);
			beam.setPredicate(predicate);
			return beam;
		}

		@Override
		public Program parse(String[] args){
			float sx = Float.parseFloat(args[0]);
			float sy = Float.parseFloat(args[1]);
			float sz = Float.parseFloat(args[2]);
			float expw = Float.parseFloat(args[3]);
			float exph = Float.parseFloat(args[4]);
			float x = Float.parseFloat(args[5]);
			float y = Float.parseFloat(args[6]);
			float z = Float.parseFloat(args[7]);
			float rx = args.length > 8 ? Float.parseFloat(args[8]) : 0;
			float ry = args.length > 9 ? Float.parseFloat(args[9]) : 0;
			float rz = args.length > 10 ? Float.parseFloat(args[10]) : 0;
			String sp = args.length > 11 ? args[11] : "vehicle";
			String rs = args.length > 12 ? args[12] : null;
			return init(sx, sy, sz, expw, exph, x, y, z, rx, ry, rz, sp, rs).setPredicate(predicate);
		}
		
	}
	
	public static final RectLightBeam RECT_LIGHTBEAM = new RectLightBeam("fvtm:rect_light_beam").register();
	public static final RectLightBeam RECT_LIGHTBEAM_LIGHTS = new RectLightBeam("fvtm:rlb_lights").setPredicate(data -> data.vehicle.getLightsState()).register();
	public static final RectLightBeam RECT_LIGHTBEAM_FRONT_LIGHTS = new RectLightBeam("fvtm:rlb_front_lights").setPredicate(data -> data.vehicle.getLightsState() && !data.vehicle.getLongLightsState() && !data.vehicle.getFogLightsState()).register();
	public static final RectLightBeam RECT_LIGHTBEAM_BACK_LIGHTS = new RectLightBeam("fvtm:rlb_back_lights").setPredicate(data -> data.vehicle.getLightsState() || data.vehicle.getThrottle() < -0.01).register();
	public static final RectLightBeam RECT_LIGHTBEAM_REAR_LIGHTS = RECT_LIGHTBEAM_BACK_LIGHTS;
	public static final RectLightBeam RECT_LIGHTBEAM_BRAKE_LIGHTS = new RectLightBeam("fvtm:rlb_back_lights").setPredicate(data -> (data.entity != null && ((GenericVehicle)data.entity).isBraking())).register();
	public static final RectLightBeam RECT_LIGHTBEAM_LONG_LIGHTS = new RectLightBeam("fvtm:rlb_long_lights").setPredicate(data -> data.vehicle.getLongLightsState() && !data.vehicle.getFogLightsState()).register();
	public static final RectLightBeam RECT_LIGHTBEAM_FOG_LIGHTS = new RectLightBeam("fvtm:rlb_fog_lights").setPredicate(data -> data.vehicle.getFogLightsState()).register();
	public static final RectLightBeam RECT_LIGHTBEAM_REVERSE_LIGHTS = new RectLightBeam("fvtm:rlb_reverse_lights").setPredicate(data -> data.vehicle.getThrottle() < -0.01).register();
	public static final RectLightBeam RECT_LIGHTBEAM_SIGNAL_LEFT = new RectLightBeam("fvtm:rlb_signal_left").setPredicate(data -> BLINKER_TOGGLE && (data.vehicle.getTurnLightLeft() || data.vehicle.getWarningLights())).register();
	public static final RectLightBeam RECT_LIGHTBEAM_SIGNAL_RIGHT = new RectLightBeam("fvtm:rlb_signal_right").setPredicate(data -> BLINKER_TOGGLE && (data.vehicle.getTurnLightRight() || data.vehicle.getWarningLights())).register();
	public static final RectLightBeam RECT_LIGHTBEAM_WARNING_LIGHTS = new RectLightBeam("fvtm:rlb_warning_lights").setPredicate(data -> BLINKER_TOGGLE && data.vehicle.getWarningLights()).register();
	public static final RectLightBeam RECT_LIGHTBEAM_INDICATOR_LEFT = RECT_LIGHTBEAM_SIGNAL_LEFT;
	public static final RectLightBeam RECT_LIGHTBEAM_INDICATOR_RIGHT = RECT_LIGHTBEAM_SIGNAL_RIGHT;
	public static final RectLightBeam RECT_LIGHTBEAM_BACK_LIGHTS_SIGNAL_LEFT = new RectLightBeam("fvtm:rlb_back_lights_signal_left").setPredicate(data -> {
		if(data.vehicle.getTurnLightLeft() || data.vehicle.getWarningLights()) return BLINKER_TOGGLE;
		return data.vehicle.getLightsState() || data.vehicle.getThrottle() < -0.01;
	}).register();
	public static final RectLightBeam RECT_LIGHTBEAM_BACK_LIGHTS_SIGNAL_RIGHT = new RectLightBeam("fvtm:rlb_back_lights_signal_right").setPredicate(data -> {
		if(data.vehicle.getTurnLightRight() || data.vehicle.getWarningLights()) return BLINKER_TOGGLE;
		return data.vehicle.getLightsState() || data.vehicle.getThrottle() < -0.01;
	}).register();
	public static final RectLightBeam RECT_LIGHTBEAM_TAIL_LIGHTS_SIGNAL_LEFT = RECT_LIGHTBEAM_BACK_LIGHTS_SIGNAL_LEFT;
	public static final RectLightBeam RECT_LIGHTBEAM_TAIL_LIGHTS_SIGNAL_RIGHT = RECT_LIGHTBEAM_BACK_LIGHTS_SIGNAL_RIGHT;
	
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
				return data.vehicle.getAttribute(attr_id).boolean_value();
			}
		};
		CUSTOM_LIGHTS.put(attr_id, glow);
		return glow;
	}

	public static void setupBlinkerTimer(){
		if(BLINKER_TIMER != null) BLINKER_TIMER.cancel();
		Print.debug("Setting up blinker-toggle timer.");
		LocalDateTime midnight = LocalDateTime.of(LocalDate.now(ZoneOffset.systemDefault()), LocalTime.MIDNIGHT);
		long mid = midnight.toInstant(ZoneOffset.UTC).toEpochMilli(); long date = Time.getDate();
		while((mid += BLINKER_INTERVAL) < date);
		(BLINKER_TIMER = new Timer()).schedule(new TimerTask(){
			@Override
			public void run(){
				BLINKER_TOGGLE = !BLINKER_TOGGLE;
			}
		}, new Date(mid), BLINKER_INTERVAL);
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
		public String getId(){
			return "fvtm:gauge";
		}
		
		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
			if((attr = data.vehicle.getAttribute(attribute)) == null) return;
			current = attr.float_value() < minval ? minval : attr.float_value();
			if(current > maxval((Entity)data.entity, data.vehicle)) current = maxval;
			list.rotateAxis(minrot + ((current - minval) / valdiff()) * rotdiff, axis, true);
		}

		private float maxval(Entity ent, VehicleData data){
			if(maxvalattr != null && (mvattr = data.getAttribute(maxvalattr)) != null) return maxval = mvattr.float_value();
			else if(limit != null) return maxval = limit.getMaxValue(maxval, ent, data);
			else return maxval;
		}
		
		private float valdiff(){
			if(maxvalattr != null || limit != null) return valdiff = maxval - minval;
			else return valdiff;
		}

		@Override
		public void postRender(ModelGroup list, ModelRenderData data){
			list.rotateAxis(0, axis, true);
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
		public String getId(){
			return "fvtm:rotation_setter";
		}
		
		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
			list.rotateAxis(rot + defrot, axis, override);
		}
		
		@Override
		public void postRender(ModelGroup list, ModelRenderData data){
			list.rotateAxis(override ? defrot : -(rot + defrot), axis, override);
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
		public String getId(){
			return "fvtm:translation_setter";
		}

		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
			GL11.glPushMatrix();
			GL11.glTranslatef(x, y, z);
		}

		@Override
		public void postRender(ModelGroup list, ModelRenderData data){
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
		public String getId(){
			return "fvtm:bind_texture";
		}
		
		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
			TexUtil.bindTexture(resloc);
		}

		@Override
		public boolean isPostRender(){
			return false;
		}

		@Override
		public Program parse(String[] args){
			return new TextureBinder(args[0]);
		}
		
	}
	
	public static Program TEXTURE_BINDER_SELECTED = new Program(){

		@Override
		public String getId(){
			return "fvtm:bind_selected_texture";
		}
		
		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
			TexUtil.bindTexture(data.texture.getCurrentTexture());
		}

		@Override
		public boolean isPostRender(){
			return false;
		}
		
	};
	
	public static Program TEXTURE_BINDER_BLOCK_4x4ROT = new Program(){

		@Override
		public String getId(){
			return "fvtm:bind_block_4x4rot_texture";
		}
		
		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
			if(data.texture == null || data.tile == null) return;
			TexUtil.bindTexture(data.texture.getTexHolder().getDefaultTextures().get(((TileEntity)data.tile).getBlockMetadata() / 4));
		}

		@Override
		public boolean isPostRender(){
			return false;
		}
		
	};
	
	public static Program TEXTURE_BINDER_BLOCK_VARIANT = new Program(){

		@Override
		public String getId(){
			return "fvtm:bind_block_variant_texture";
		}
		
		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
			TexUtil.bindTexture(data.texture.getTexHolder().getDefaultTextures().get(((TileEntity)data.tile).getBlockMetadata()));
		}

		@Override
		public boolean isPostRender(){
			return false;
		}
		
	};
	
	public static Program RESCALE_NORMAL = new Program(){

		@Override
		public String getId(){
			return "fvtm:rescale_normal";
		}
		
		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
			GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		}

		@Override
		public void postRender(ModelGroup list, ModelRenderData data){
			GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		}
		
	}, GL_RESCALE_NORMAL = RESCALE_NORMAL;
	
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
		public String getId(){
			return "fvtm:text_renderer";
		}
		
		@Override
		public boolean isPreRender(){
			return false;
		}

		@Override
		public void postRender(ModelGroup list, ModelRenderData data){
			if(text.length() == 0) return;
			if(font_renderer == null) font_renderer = Minecraft.getMinecraft().getRenderManager().getFontRenderer();
			if(font_renderer == null) return;
	        GlStateManager.pushMatrix();
			if(glow || (attrid != null && attr(data.vehicle))) super.preRender(list, data);
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
			if(glow || (attrid != null && attr(data.vehicle))) super.postRender(list, data                                                                                                                    );
	        GlStateManager.popMatrix();
		}
		
		protected boolean attr(VehicleData data){
			attr = data.getAttribute(attrid);
			return attr != null && attr.boolean_value();
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
		public String getId(){
			return "fvtm:attr_text_renderer";
		}
		
		@Override
		public boolean isPreRender(){
			return true;
		}
		
		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
			if((attr = data.vehicle.getAttribute(attribute)) == null) return;
			text = attr.string_value();
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
		
		private static final TreeMap<String, Integer> linked = new TreeMap<>();
		protected String cacheid;

		@Override
		public void init(ModelGroup list){
			if(cacheid != null) return;
			String id = getId();
			if(linked.containsKey(id)){
				cacheid = id + "_" + linked.get(id);
				linked.put(id, linked.get(id) + 1);
			}
			else{
				cacheid = id + "_0";
				linked.put(id, 1);
			}
		}
		
	}
	
	public static class Rotator extends Duplicable {
		
		private float min, max, step = 1;
		private float current, dir, defrot;
		private int axis;
		private boolean loop, override;
		private String cacheids;
		
		public Rotator(float min, float max, float step, int axis, Float defrot, boolean loop, boolean ntadd){
			this.override = true;
			this.min = min; 
			this.max = max;
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
		public String getId(){
			return "fvtm:rotator";
		}
		
		@Override
		public void init(ModelGroup list){
			super.init(list);
			cacheids = cacheid + "s";
		}
		
		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
			if(data.cache == null) return;
			current = data.cache.getValue(cacheid, 0f);
			dir = data.cache.getValue(cacheids, step);
			current += dir;
			if(current > max){
				if(loop){
					current = min + (current - max);
					data.cache.setValue(cacheids, dir);
				}
				else{
					current = max - (current - max);
					data.cache.setValue(cacheids, -dir);
				}
			}
			if(current < min){
				if(loop){
					current = max + (current - min);
					data.cache.setValue(cacheids, dir);
				}
				else{
					current = min - (current - min);
					data.cache.setValue(cacheids, -dir);
				}
			}
			list.rotateAxis(current + defrot, axis, override);
			data.cache.setValue(cacheid, current);
		}
		
		@Override
		public void postRender(ModelGroup list, ModelRenderData data){
			if(data.cache == null) return;
			list.rotateAxis(override ? defrot : -(current + defrot), axis, override);
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
		private float current, dir;
		private int axis;
		private String cacheids;
		
		public Translator(float min, float max, float step, int axis, boolean loop){
			this.axis = axis;
			this.step = step;
			this.min = min;
			this.max = max;
			this.loop = loop;
		}

		@Override
		public String getId(){
			return "fvtm:translator";
		}
		
		@Override
		public void init(ModelGroup list){
			super.init(list);
			cacheids = cacheid + "s";
		}

		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
			if(data.cache == null) return;
			current = data.cache.getValue(cacheid, 0f);
			dir = data.cache.getValue(cacheids, step);
			current += dir;
			if(current > max){
				if(loop){
					current = min + (current - max);
					data.cache.setValue(cacheids, dir);
				}
				else{
					current = max - (current - max);
					data.cache.setValue(cacheids, -dir);
				}
			}
			if(current < min){
				if(loop){
					current = max + (current - min);
					data.cache.setValue(cacheids, dir);
				}
				else{
					current = min - (current - min);
					data.cache.setValue(cacheids, -dir);
				}
			}
			//GL11.glPushMatrix();
			GL11.glTranslatef(
				axis == 0 ? current * Static.sixteenth : 0,
				axis == 1 ? current * Static.sixteenth : 0,
				axis == 2 ? current * Static.sixteenth : 0);
			data.cache.setValue(cacheid, current);
		}

		@Override
		public void postRender(ModelGroup list, ModelRenderData data){
			if(data.cache == null) return;
			GL11.glTranslatef(
				axis == 0 ? current * -Static.sixteenth : 0,
				axis == 1 ? current * -Static.sixteenth : 0,
				axis == 2 ? current * -Static.sixteenth : 0);
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

	public static abstract class BlockBoolBased implements Program {

		private static final TreeMap<String, Integer> linked = new TreeMap<>();
		protected String key, cacheid;

		public BlockBoolBased(String key){
			this.key = key;
		}

		@Override
		public void init(ModelGroup list){
			if(cacheid != null) return;
			if(linked.containsKey(key)){
				cacheid = key + "_" + linked.get(key);
				linked.put(key, linked.get(key) + 1);
			}
			else{
				cacheid = key + "_0";
				linked.put(key, 1);
			}
		}

	}

	public static class BlockBoolRotator extends BlockBoolBased {

		private String key;
		private float min, max, step = 1;
		private Float current;
		private int axis;
		private boolean equals, override;
		private float defrot;

		public BlockBoolRotator(String key, boolean equals, float min, float max, float step, int axis, Float defrot){
			super(key);
			this.equals = equals;
			this.override = true;
			this.min = min;
			this.max = max;
			this.step = step;
			this.axis = axis;
			this.defrot = defrot == null ? 0 : defrot;
			if(min == max || (min == 0f && max == 0f)){
				min = -360; max = 360;
			}
		}

		public BlockBoolRotator(String key, boolean equals, float min, float max, float step, int axis, Float defrot, boolean notadditive){
			this(key, equals, min, max, step, axis, defrot);
			this.override = notadditive;
		}

		@Override
		public String getId(){
			return "fvtm:block_bool_rotator";
		}

		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
			if(data.cache == null || data.block == null) return;
			current = data.cache.getValue(cacheid);
			if(current == null) current = 0f;
			current = data.block.getFunctionBool(key) == equals ? current + step : current - step;
			if(current > max) current = max;
			if(current < min) current = min;
			list.rotateAxis(current + defrot, axis, override);
			data.cache.setValue(cacheid, current);
		}

		@Override
		public void postRender(ModelGroup list, ModelRenderData data){
			if(data.cache == null || data.block == null) return;
			list.rotateAxis(override ? defrot : -(current + defrot), axis, override);
			current = 0f;
		}


		@Override
		public Program parse(String[] args){
			String attr = args[0];
			boolean equals = Boolean.parseBoolean(args[1]);
			float min = Float.parseFloat(args[2]);
			float max = Float.parseFloat(args[3]);
			float step = Float.parseFloat(args[4]);
			int axis = Integer.parseInt(args[5]);
			Float defrot = args.length > 6 && NumberUtils.isCreatable(args[6]) ? Float.parseFloat(args[6]) : null;
			return new BlockBoolRotator(attr, equals, min, max, step, axis, defrot, args.length >= 7 && Boolean.parseBoolean(args[7]));
		}

	}

	public static class BlockBoolTranslator extends BlockBoolBased {

		private boolean bool;
		private float min, max, step;
		private Float current;
		private int axis;

		public BlockBoolTranslator(String key, boolean equals, float min, float max, float step, int axis){
			super(key);
			this.bool = equals;
			this.axis = axis;
			this.step = step;
			this.min = min;
			this.max = max;
		}

		@Override
		public String getId(){
			return "fvtm:block_bool_translator";
		}

		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
			if(data.cache == null || data.block == null) return;
			current = data.cache.getValue(cacheid);
			if(current == null) current = 0f;
			current = data.block.getFunctionBool(key) == bool ? current + step : current - step;
			if(current > max) current = max; if(current < min) current = min;
			//GL11.glPushMatrix();
			GL11.glTranslatef(
					axis == 0 ? current * Static.sixteenth : 0,
					axis == 1 ? current * Static.sixteenth : 0,
					axis == 2 ? current * Static.sixteenth : 0);
			data.cache.setValue(cacheid, current);
		}

		@Override
		public void postRender(ModelGroup list, ModelRenderData data){
			if(data.cache == null || data.block == null) return;
			GL11.glTranslatef(
					axis == 0 ? current * -Static.sixteenth : 0,
					axis == 1 ? current * -Static.sixteenth : 0,
					axis == 2 ? current * -Static.sixteenth : 0);
			//GL11.glPopMatrix();
		}

		@Override
		public Program parse(String[] args){
			String attr = args[0];
			boolean equals = Boolean.parseBoolean(args[1]);
			float min = Float.parseFloat(args[2]);
			float max = Float.parseFloat(args[3]);
			float step = Float.parseFloat(args[4]);
			int axis = Integer.parseInt(args[5]);
			return new BlockBoolTranslator(attr, equals, min, max, step, axis);
		}

	}

	public static class BlockBoolVisible implements Program {

		private String key;
		private boolean equals;

		public BlockBoolVisible(String key, boolean equals){
			this.key = key;
			this.equals = equals;
		}

		@Override
		public String getId(){
			return "fvtm:block_bool_visible";
		}

		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
			if(data.block == null) return;
			if(data.block.getFunctionBool(key) != equals) list.visible = false;
		}

		@Override
		public void postRender(ModelGroup list, ModelRenderData data){
			list.visible = true;
		}

		@Override
		public Program parse(String[] args){
			return new BlockBoolVisible(args[0], args.length < 2 || Boolean.parseBoolean(args[1]));
		}

	}

	public static class Block4x4RotVisible implements Program {

		private int equals;

		public Block4x4RotVisible(int var){
			this.equals = var;
		}

		@Override
		public String getId(){
			return "fvtm:block_4x4rot_visible";
		}

		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
			if(data.tile == null) return;
			list.visible = (((TileEntity)data.tile).getBlockMetadata() / 4) == equals;
		}

		@Override
		public void postRender(ModelGroup list, ModelRenderData data){
			list.visible = true;
		}

		@Override
		public Program parse(String[] args){
			return new Block4x4RotVisible(Integer.parseInt(args[0]));
		}

	}

	public static class BlockVariantVisible implements Program {

		private int equals;

		public BlockVariantVisible(int var){
			this.equals = var;
		}

		@Override
		public String getId(){
			return "fvtm:block_variant_visible";
		}

		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
			if(data.tile == null) return;
			list.visible = ((TileEntity)data.tile).getBlockMetadata() == equals;
		}

		@Override
		public void postRender(ModelGroup list, ModelRenderData data){
			list.visible = true;
		}

		@Override
		public Program parse(String[] args){
			return new BlockVariantVisible(Integer.parseInt(args[0]));
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
		public String getId(){
			return "fvtm:display_barrel";
		}

		private BlockData bdata, odata;
		private InvHandlerVar var;
		private Model model;

		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
			if(data.tile == null) return;
			var = (InvHandlerVar)((MultiblockTileEntity)data.tile).getMultiBlockData().getInventory(inv);
			if(var == null || var.stackAt(index).isEmpty()) return;
			bdata = var.stackAt(index).getCapability(Capabilities.VAPDATA, null).getBlockData();
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
		public boolean isPostRender(){
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

	public static class TextureSetter implements Program {

		private String texloc, otex;

		public TextureSetter(String str){
			texloc = str;
		}

		@Override
		public String getId(){
			return "fvtm:set_texture";
		}

		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
			if(list.size() == 0) return;
			otex = list.get(0).getTexture();
			for(ModelRendererTurbo mrt : list){
				mrt.setTexture(texloc);
			}
		}

		@Override
		public void postRender(ModelGroup list, ModelRenderData data){
			if(list.size() == 0) return;
			for(ModelRendererTurbo mrt : list){
				mrt.setTexture(otex);
			}
		}

		@Override
		public Program parse(String[] args){
			return new TextureSetter(args[0]);
		}

	}

	public static class BlockFacePlayer implements Program {

		private Pos pos;

		public BlockFacePlayer(float x, float y, float z){
			pos = new Pos(x, y, z);
		}

		@Override
		public String getId(){
			return "fvtm:block_face_player";
		}

		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
			if(data.tile == null) return;
			GL11.glPushMatrix();
			GL11.glRotated(-data.block.getType().getBlockType().getRotationForMeta(((TileEntity)data.tile).getBlockMetadata()), 0, 1, 0);
			pos.translate();
			double d0 = Minecraft.getMinecraft().player.posX - (((TileEntity)data.tile).getPos().getX() + 0.5F);
			double d1 = Minecraft.getMinecraft().player.posZ - (((TileEntity)data.tile).getPos().getZ() + 0.5F);
			double d2 = Minecraft.getMinecraft().player.posY + Minecraft.getMinecraft().player.eyeHeight - (((TileEntity)data.tile).getPos().getY() + 0.5F);
			d2 = -Math.atan2(d2, Math.sqrt(d0 * d0 + d1 * d1));
			d0 = MathHelper.atan2(d1, d0);
			//if(d0 >= (float)Math.PI) d0 -= ((float)Math.PI * 2F);
			//if(d0 < -(float)Math.PI) d0 += ((float)Math.PI * 2F);
			GL11.glRotated(Static.toDegrees(d0) + 90, 0, 1, 0);
			GL11.glRotated(Static.toDegrees(d2), 1, 0, 0);
		}

		@Override
		public void postRender(ModelGroup list, ModelRenderData data){
			if(data.tile == null) return;
			GL11.glPopMatrix();
			//GL11.glRotated(data.block.getType().getBlockType().getRotationForMeta(data.tile.getBlockMetadata()), 0, 1, 0);
		}

		@Override
		public Program parse(String[] args){
			float x = args.length > 0 ? Float.parseFloat(args[0]) : 0;
			float y = args.length > 1 ? Float.parseFloat(args[1]) : 0;
			float z = args.length > 2 ? Float.parseFloat(args[2]) : 0;
			return new BlockFacePlayer(x, y, z);
		}

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
		public String getId(){
			return "fvtm:render_order";
		}

		@Override
		public Program parse(String[] args){
			return map.get(RenderOrder.valueOf(args[0].toUpperCase()));
		}

	}
	
}