package net.fexcraft.mod.fvtm.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;
import java.util.function.BiPredicate;

import org.apache.commons.lang3.math.NumberUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.mc.utils.Pos;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.lib.tmt.ModelBase;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.block.generated.SignalTileEntity;
import net.fexcraft.mod.fvtm.data.WheelSlot;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.root.Colorable;
import net.fexcraft.mod.fvtm.data.root.RenderCache;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.model.TurboList.Program;
import net.fexcraft.mod.fvtm.render.EffectRenderer;
import net.fexcraft.mod.fvtm.sys.uni.GenericVehicle;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.fexcraft.mod.fvtm.util.function.EngineFunction;
import net.fexcraft.mod.fvtm.util.function.WheelFunction;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class DefaultPrograms {

	public static boolean DIDLOAD = false, BLINKER_TOGGLE;
	public static Timer BLINKER_TIMER;
	
	public static void init(){
		TurboList.PROGRAMS.add(RGB_PRIMARY);
		TurboList.PROGRAMS.add(RGB_SECONDARY);
		TurboList.PROGRAMS.add(new RGBCustom(0xffffff));
		TurboList.PROGRAMS.add(new RGBChannel("custom"));
		TurboList.PROGRAMS.add(INVISIBLE);
		TurboList.PROGRAMS.add(ALWAYS_GLOW);
		TurboList.PROGRAMS.add(LIGHTS);
		TurboList.PROGRAMS.add(FRONT_LIGHTS);
		TurboList.PROGRAMS.add(BACK_LIGHTS);
		TurboList.PROGRAMS.add(FOG_LIGHTS);
		TurboList.PROGRAMS.add(REVERSE_LIGHTS);
		TurboList.PROGRAMS.add(TURN_SIGNAL_LEFT);
		TurboList.PROGRAMS.add(TURN_SIGNAL_RIGHT);
		TurboList.PROGRAMS.add(WARNING_LIGHTS);
		TurboList.PROGRAMS.add(BACK_LIGHTS_SIGNAL_LEFT);
		TurboList.PROGRAMS.add(BACK_LIGHTS_SIGNAL_RIGHT);
		TurboList.PROGRAMS.add(WINDOW);
		TurboList.PROGRAMS.add(WHEEL_AUTO_ALL);
		TurboList.PROGRAMS.add(WHEEL_AUTO_STEERING);
		TurboList.PROGRAMS.add(WHEEL_AUTO_ALL_OPPOSITE);
		TurboList.PROGRAMS.add(WHEEL_AUTO_STEERING_OPPOSITE);
		TurboList.PROGRAMS.add(NO_CULLFACE);
		TurboList.PROGRAMS.add(new SteeringWheel(0, 0));//jtmt/obj init only
		TurboList.PROGRAMS.add(new SteeringWheelCentered(0, 0));//jtmt/obj init only
		TurboList.PROGRAMS.add(STEERING_WHEEL_Z);
		TurboList.PROGRAMS.add(STEERING_WHEEL_X);
		TurboList.PROGRAMS.add(STEERING_WHEEL_Y);
		TurboList.PROGRAMS.add(STEERING_WHEEL_ZN);
		TurboList.PROGRAMS.add(STEERING_WHEEL_XN);
		TurboList.PROGRAMS.add(STEERING_WHEEL_YN);
		//
		TurboList.PROGRAMS.add(LIGHTS_RAIL_FORWARD);
		TurboList.PROGRAMS.add(LIGHTS_RAIL_BACKWARD);
		TurboList.PROGRAMS.add(BOGIE_AUTO);
		TurboList.PROGRAMS.add(BOGIE_AUTO_OPPOSITE);
		TurboList.PROGRAMS.add(BOGIE_FRONT);
		TurboList.PROGRAMS.add(BOGIE_REAR);
		//
		TurboList.PROGRAMS.add(BASIC_SIGNAL_CLEAR);
		TurboList.PROGRAMS.add(BASIC_SIGNAL_STOP);
		//
		TurboList.PROGRAMS.add(new Scale(1f));
		TurboList.PROGRAMS.add(TRANSPARENT);
		TurboList.PROGRAMS.add(WINDOW);
		TurboList.PROGRAMS.add(new AttributeRotator("", false, 0, 0, 0, 0, 0f));//jtmt/obj init only
		TurboList.PROGRAMS.add(new AttributeTranslator("", false, 0, 0, 0, 0));//jtmt/obj init only
		TurboList.PROGRAMS.add(new Gauge("", 0, 0, 0, 0, 0));//jtmt/obj init only
		TurboList.PROGRAMS.add(new RotationSetter(0, 0, 0, false));//jtmt/obj init only
		TurboList.PROGRAMS.add(new TranslationSetter(0, 0, 0, 0));//jtmt/obj init only
		TurboList.PROGRAMS.add(new TextureBinder("minecraft:textures/blocks/stone.png"));
		TurboList.PROGRAMS.add(RESCALE_NORMAL);
		TurboList.PROGRAMS.add(new TextRenderer(0, 0, 0, 0, 0, 0, 0, true));
		TurboList.PROGRAMS.add(new AttributeTextRenderer("", 0, 0, 0, 0, 0, 0, 0, true));
		//
		DIDLOAD = true;
	}

	@SuppressWarnings("deprecation")
	public static final Program RGB_PRIMARY = new Program(){
		@Override public String getId(){ return "fvtm:rgb_primary"; }
		@Override public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){ color.getPrimaryColor().glColorApply(); }
		@Override public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){ RGB.glColorReset(); }
		@Override public void preRender(TurboList list, TileEntity ent, BlockData data, RenderCache cache){ data.getPrimaryColor().glColorApply(); }
		@Override public void postRender(TurboList list, TileEntity ent, BlockData data, RenderCache cache){ RGB.glColorReset(); }
	};

	@SuppressWarnings("deprecation")
	public static final Program RGB_SECONDARY = new Program(){
		@Override public String getId(){ return "fvtm:rgb_secondary"; }
		@Override public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){ color.getSecondaryColor().glColorApply(); }
		@Override public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){ RGB.glColorReset(); }
		@Override public void preRender(TurboList list, TileEntity ent, BlockData data, RenderCache cache){ data.getSecondaryColor().glColorApply(); }
		@Override public void postRender(TurboList list, TileEntity ent, BlockData data, RenderCache cache){ RGB.glColorReset(); }
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
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			this.color.glColorApply();
		}
		
		@Override
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			RGB.glColorReset();
		}
		
		@Override
		public void preRender(TurboList list, TileEntity ent, BlockData data, RenderCache cache){
			this.color.glColorApply();
		}
		
		@Override
		public void postRender(TurboList list, TileEntity ent, BlockData data, RenderCache cache){
			RGB.glColorReset();
		}
		
		@Override
		public Program parse(JsonElement elm){
			return new RGBCustom(new RGB(elm.getAsJsonArray().get(0).getAsString()));
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
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			color.getColorChannel(channel).glColorApply();
		}
		
		@Override
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			RGB.glColorReset();
		}
		
		@Override
		public void preRender(TurboList list, TileEntity ent, BlockData data, RenderCache cache){
			data.getColorChannel(channel).glColorApply();
		}
		
		@Override
		public void postRender(TurboList list, TileEntity ent, BlockData data, RenderCache cache){
			RGB.glColorReset();
		}
		
		@Override
		public Program parse(JsonElement elm){
			return new RGBChannel(elm.getAsJsonArray().get(0).getAsString());
		}

		@Override
		public Program parse(String[] args){
			return new RGBChannel(args[0]);
		}
		
	}
	
	public static final Program INVISIBLE = new Program(){
		@Override public String getId(){ return "fvtm:hide"; }
		@Override public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){ list.visible = false; }
		@Override public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){ list.visible = true; }
		@Override public void preRender(TurboList list, TileEntity ent, BlockData data, RenderCache cache){ list.visible = false; }
		@Override public void postRender(TurboList list, TileEntity ent, BlockData data, RenderCache cache){ list.visible = true; }
	}, HIDE = INVISIBLE;
	
	public static final Program ALWAYS_GLOW = new AlwaysGlow(){
		@Override public boolean shouldGlow(Entity ent, VehicleData data){ return true; }
		@Override public String getId(){ return "fvtm:glow"; }
	}, GLOW = ALWAYS_GLOW;
	
	public static final Program LIGHTS = new AlwaysGlow(){
		@Override public boolean shouldGlow(Entity ent, VehicleData data){ return data.getLightsState(); }
		@Override public String getId(){ return "fvtm:lights"; }
	};
	
	public static final Program FRONT_LIGHTS = new AlwaysGlow(){
		@Override public boolean shouldGlow(Entity ent, VehicleData data){ return data.getLightsState(); }
		@Override public String getId(){ return "fvtm:front_lights"; }
	};
	
	public static final Program BACK_LIGHTS = new AlwaysGlow(){
		@Override public boolean shouldGlow(Entity ent, VehicleData data){ return data.getLightsState() || data.getThrottle() < -0.01 || (ent != null && ((GenericVehicle)ent).isBraking()); }//TODO rear+brake lights instead
		@Override public String getId(){ return "fvtm:back_lights"; }
	};
	public static final Program REAR_LIGHTS = BACK_LIGHTS;
	
	public static final Program FOG_LIGHTS = new AlwaysGlow(){
		@Override public boolean shouldGlow(Entity ent, VehicleData data){ return data.getFogLightsState(); }
		@Override public String getId(){ return "fvtm:fog_lights"; }
	};
	public static final Program LONG_LIGHTS = new AlwaysGlow(){
		@Override public boolean shouldGlow(Entity ent, VehicleData data){ return data.getLongLightsState(); }
		@Override public String getId(){ return "fvtm:long_lights"; }
	};
	
	public static final Program REVERSE_LIGHTS = new AlwaysGlow(){
		@Override public boolean shouldGlow(Entity ent, VehicleData data){ return data.getThrottle() < -0.01; }
		@Override public String getId(){ return "fvtm:reverse_lights"; }
	};
	public static final Program BRAKE_LIGHTS = new AlwaysGlow(){
		@Override public boolean shouldGlow(Entity ent, VehicleData data){ return (ent != null && ((GenericVehicle)ent).isBraking()); }
		@Override public String getId(){ return "fvtm:brake_lights"; }
	};
	
	public static final Program LIGHTS_RAIL_FORWARD = new AlwaysGlow(){
		@Override public boolean shouldGlow(Entity ent, VehicleData data){ return data.getLightsState() && data.getAttribute("forward").boolean_value(); }
		@Override public String getId(){ return "fvtm:lights_rail_forward"; }
	};
	
	public static final Program LIGHTS_RAIL_BACKWARD = new AlwaysGlow(){
		@Override public boolean shouldGlow(Entity ent, VehicleData data){ return data.getLightsState() && !data.getAttribute("forward").boolean_value(); }
		@Override public String getId(){ return "fvtm:lights_rail_backward"; }
	};
	
	public static final Program TURN_SIGNAL_LEFT = new AlwaysGlow(){
		@Override public boolean shouldGlow(Entity ent, VehicleData data){ return BLINKER_TOGGLE && (data.getTurnLightLeft() || data.getWarningLights()); }
		@Override public String getId(){ return "fvtm:turn_signal_left"; }
	};
	
	public static final Program TURN_SIGNAL_RIGHT = new AlwaysGlow(){
		@Override public boolean shouldGlow(Entity ent, VehicleData data){ return BLINKER_TOGGLE && (data.getTurnLightRight() || data.getWarningLights()); }
		@Override public String getId(){ return "fvtm:turn_signal_right"; }
	};
	
	public static final Program WARNING_LIGHTS = new AlwaysGlow(){
		@Override public boolean shouldGlow(Entity ent, VehicleData data){ return BLINKER_TOGGLE && data.getWarningLights(); }
		@Override public String getId(){ return "fvtm:warning_lights"; }
	};
	
	public static final Program INDICATOR_LIGHT_LEFT = TURN_SIGNAL_LEFT, INDICATOR_LIGHT_RIGHT = TURN_SIGNAL_RIGHT;
	
	public static final Program BACK_LIGHTS_SIGNAL_LEFT = new AlwaysGlow(){
		@Override public boolean shouldGlow(Entity ent, VehicleData data){
			if(data.getTurnLightLeft() || data.getWarningLights()) return BLINKER_TOGGLE;
			else return data.getLightsState() || data.getThrottle() < -0.01;
		}
		@Override public String getId(){ return "fvtm:back_lights_signal_left"; }
	};
	
	public static final Program BACK_LIGHTS_SIGNAL_RIGHT = new AlwaysGlow(){
		@Override public boolean shouldGlow(Entity ent, VehicleData data){
			if(data.getTurnLightRight() || data.getWarningLights()) return BLINKER_TOGGLE;
			else return data.getLightsState() || data.getThrottle() < -0.01;
		}
		@Override public String getId(){ return "fvtm:back_lights_signal_right"; }
	};
	
	public static final Program TAIL_LIGHTS_SIGNAL_LEFT = BACK_LIGHTS_SIGNAL_LEFT;
	public static final Program TAIL_LIGHTS_SIGNAL_RIGHT = BACK_LIGHTS_SIGNAL_RIGHT;
	
	//
	
	public static final Program BASIC_SIGNAL_CLEAR = new AlwaysGlow(){
		@Override
		public boolean shouldGlow(TileEntity tile, BlockData data){
			return tile != null && ((SignalTileEntity)tile).getSignalState() == 1;
		}
		@Override
		public String getId(){ return "fvtm:basic_signal_clear"; }
	};
	public static final Program BASIC_SIGNAL_GREEN = BASIC_SIGNAL_CLEAR;
	
	public static final Program BASIC_SIGNAL_STOP = new AlwaysGlow(){
		@Override
		public boolean shouldGlow(TileEntity tile, BlockData data){
			return tile == null || ((SignalTileEntity)tile).getSignalState() == 0;
		}
		@Override
		public String getId(){ return "fvtm:basic_signal_stop"; }
	};
	public static final Program BASIC_SIGNAL_RED = BASIC_SIGNAL_STOP;
	
	//
	
	public static final Program TRANSPARENT = new Transparent(63f, 63f){
		@Override public String getId(){ return "fvtm:transparent"; }
	};
	
	public static final Window WINDOW = new Window();
	
	public static final class Window implements Program {
		
		protected RGB color = new RGB(0x007208).setAlpha(0.3f);
		
		public Window(){}
		
		public Window(int color){ this.color = new RGB(color).setAlpha(0.3f); }

		@Override
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
            GlStateManager.pushMatrix();
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glDepthMask(false);
            GL11.glEnable(GL11.GL_ALPHA_TEST);
            this.color.glColorApply();
		}

		@Override
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
            RGB.glColorReset();
            GL11.glDisable(GL11.GL_ALPHA_TEST);
            GL11.glDepthMask(true);
            GL11.glDisable(GL11.GL_BLEND);
            GlStateManager.popMatrix();
		}
		
		@Override
		public String getId(){
			return "fvtm:window";
		}
		
		@Override
		public Program parse(JsonElement elm){
			return new Window(Integer.parseInt(elm.getAsJsonArray().get(0).getAsString().replace("#", "").replace("0x", ""), 16));
		}
		

		@Override
		public Program parse(String[] args){
			return new Window(Integer.parseInt(args[0].replace("#", "").replace("0x", ""), 16));
		}
		
	}
	
	public static final Program WHEEL_AUTO_ALL = new Program(){
		
		private WheelSlot slot;
		
		@Override public String getId(){ return "fvtm:wheel_auto_all"; }
		
		@Override
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			slot = data.getPart(part).getFunction(WheelFunction.class, "fvtm:wheel").getWheelPos(data);
			if(slot != null && slot.steering()) GL11.glRotatef(data.getAttribute("steering_angle").float_value(), 0, 1, 0);
			GL11.glRotatef(data.getAttribute("wheel_angle").float_value(), 0, 0, 1);
			if(slot != null && slot.yrot() != 0f) GL11.glRotatef(slot.yrot(), 0, 1, 0);
		}
		
		@Override
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			if(slot != null && slot.yrot() != 0f) GL11.glRotatef(-slot.yrot(), 0, 1, 0);
			GL11.glRotatef(-data.getAttribute("wheel_angle").float_value(), 0, 0, 1);
			if(slot != null && slot.steering()) GL11.glRotatef(-data.getAttribute("steering_angle").float_value(), 0, 1, 0);
		}
		
	};
	
	public static final Program WHEEL_AUTO_ALL_OPPOSITE = new Program(){
		
		private WheelSlot slot;
		
		@Override public String getId(){ return "fvtm:wheel_auto_all_opposite"; }
		
		@Override
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			slot = data.getPart(part).getFunction(WheelFunction.class, "fvtm:wheel").getWheelPos(data);
			if(slot != null && slot.steering()) GL11.glRotatef(-data.getAttribute("steering_angle").float_value(), 0, 1, 0);
			GL11.glRotatef(data.getAttribute("wheel_angle").float_value(), 0, 0, 1);
			if(slot != null && slot.yrot() != 0f) GL11.glRotatef(slot.yrot(), 0, 1, 0);
		}
		
		@Override
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			if(slot != null && slot.yrot() != 0f) GL11.glRotatef(-slot.yrot(), 0, 1, 0);
			GL11.glRotatef(-data.getAttribute("wheel_angle").float_value(), 0, 0, 1);
			if(slot != null && slot.steering()) GL11.glRotatef(data.getAttribute("steering_angle").float_value(), 0, 1, 0);
		}
		
	};
	
	public static final Program WHEEL_AUTO_STEERING = new Program(){
		
		private WheelSlot slot;
		
		@Override public String getId(){ return "fvtm:wheel_auto_steering"; }
		
		@Override
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			slot = data.getPart(part).getFunction(WheelFunction.class, "fvtm:wheel").getWheelPos(data);
			if(slot != null && slot.yrot() != 0f) GL11.glRotatef(slot.yrot(), 0, 1, 0);
			if(slot != null && slot.steering()) GL11.glRotatef(data.getAttribute("steering_angle").float_value(), 0, 1, 0);
		}
		
		@Override
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			if(slot != null && slot.steering()) GL11.glRotatef(-data.getAttribute("steering_angle").float_value(), 0, 1, 0);
			if(slot != null && slot.yrot() != 0f) GL11.glRotatef(-slot.yrot(), 0, 1, 0);
		}
		
	};
	
	public static final Program WHEEL_AUTO_STEERING_OPPOSITE = new Program(){
		
		private WheelSlot slot;
		
		@Override public String getId(){ return "fvtm:wheel_auto_steering_opposite"; }
		
		@Override
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			slot = data.getPart(part).getFunction(WheelFunction.class, "fvtm:wheel").getWheelPos(data);
			if(slot != null && slot.yrot() != 0f) GL11.glRotatef(slot.yrot(), 0, 1, 0);
			if(slot != null && slot.steering()) GL11.glRotatef(-data.getAttribute("steering_angle").float_value(), 0, 1, 0);
		}
		
		@Override
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			if(slot != null && slot.steering()) GL11.glRotatef(data.getAttribute("steering_angle").float_value(), 0, 1, 0);
			if(slot != null && slot.yrot() != 0f) GL11.glRotatef(-slot.yrot(), 0, 1, 0);
		}
		
	};

	public static final Program BOGIE_AXLE_WHEEL = new Program(){
		
		@Override public String getId(){ return "fvtm:bogie_axle_wheel"; }
		
		@Override
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			//
		}
		
		@Override
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			//
		}
		
	};

	public static final Program BOGIE_AUTO = new Program(){
		
		@Override public String getId(){ return "fvtm:bogie_auto"; }
		
		@Override
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			GL11.glRotatef(data.getAttribute(part + "_angle").float_value(), 0, 1, 0);
		}
		
		@Override
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			GL11.glRotatef(-data.getAttribute(part + "_angle").float_value(), 0, 1, 0);
		}
		
	};

	public static final Program BOGIE_AUTO_OPPOSITE = new Program(){
		
		@Override public String getId(){ return "fvtm:bogie_auto_opposite"; }
		
		@Override
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			GL11.glRotatef(-data.getAttribute(part + "_angle").float_value(), 0, 1, 0);
		}
		
		@Override
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			GL11.glRotatef(data.getAttribute(part + "_angle").float_value(), 0, 1, 0);
		}
		
	};
	
	public static final Program BOGIE_FRONT = new Program(){
		
		@Override public String getId(){ return "fvtm:bogie_front"; }
		
		@Override
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			GL11.glRotatef(data.getAttribute("bogie_front_angle").float_value(), 0, 1, 0);
		}
		
		@Override
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			GL11.glRotatef(-data.getAttribute("bogie_front_angle").float_value(), 0, 1, 0);
		}
		
	};
	
	public static final Program BOGIE_REAR = new Program(){
		
		@Override public String getId(){ return "fvtm:bogie_rear"; }
		
		@Override
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			GL11.glRotatef(data.getAttribute("bogie_rear_angle").float_value(), 0, 1, 0);
		}
		
		@Override
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			GL11.glRotatef(-data.getAttribute("bogie_rear_angle").float_value(), 0, 1, 0);
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
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			list.rotateAxis(rotated = data.getAttribute("steering_angle").float_value() * ratio, axis, apply);
		}
		
		@Override
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			list.rotateAxis(-rotated, axis, apply);
		}
		
		@Override
		public Program parse(JsonElement elm){
			return new SteeringWheel(elm.getAsJsonArray().get(0).getAsInt(), elm.getAsJsonArray().get(1).getAsFloat());
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
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			GL11.glRotatef(data.getAttribute("steering_angle").float_value() * ratio, x, y, z);
		}
		
		@Override
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			GL11.glRotatef(-data.getAttribute("steering_angle").float_value() * ratio, x, y, z);
		}
		
		@Override
		public Program parse(JsonElement elm){
			return new SteeringWheelCentered(elm.getAsJsonArray().get(0).getAsInt(), elm.getAsJsonArray().get(1).getAsFloat());
		}
		

		@Override
		public Program parse(String[] args){
			return new SteeringWheelCentered(Integer.parseInt(args[0]), Float.parseFloat(args[1]));
		}
		
	};
	
	public static abstract class AttributeBased implements Program {
		
		private static final TreeMap<String, Integer> linked = new TreeMap<>();
		protected String attribute, cacheid;
		
		public AttributeBased(String attr){
			this.attribute = attr;
		}

		@Override
		public void init(TurboList list){
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
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			if(cache == null) return;
			if((attr = data.getAttribute(attribute)) == null) return;
			current = cache.getValue(cacheid);
			if(current == null) current = 0f;
			current = boolstatebased ? (attr.boolean_value() ? current + step : current - step) : attr.float_value() * step;
			if(current > max) current = max;
			if(current < min) current = min;
			list.rotateAxis(current + defrot, axis, override);
			cache.setValue(cacheid, current);
		}
		
		@Override
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			if(cache == null || attr == null) return;
			list.rotateAxis(override ? defrot : -(current + defrot), axis, override);
			current = 0f;
		}
		
		@Override
		public Program parse(JsonElement elm){
			JsonArray array = elm.getAsJsonArray();
			String attr = array.get(0).getAsString();
			boolean boolstate = array.get(1).getAsBoolean();
			float min = array.get(2).getAsFloat();
			float max = array.get(3).getAsFloat();
			float step = array.get(4).getAsFloat();
			int axis = array.get(5).getAsInt();
			Float defrot = array.size() > 6 && NumberUtils.isCreatable(array.get(6).getAsString()) ? array.get(6).getAsFloat() : null;
			return new AttributeRotator(attr, boolstate, min, max, step, axis, defrot, array.size() >= 7 && array.get(7).getAsBoolean());
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
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			if(cache == null) return;
			if((attr = data.getAttribute(attribute)) == null) return;
			current = cache.getValue(cacheid);
			if(current == null) current = 0f;
			current = bool ? (attr.boolean_value() ? current + step : current - step) : attr.float_value();
			if(current > max) current = max; if(current < min) current = min;
			//GL11.glPushMatrix();
			GL11.glTranslatef(
				axis == 0 ? current * Static.sixteenth : 0,
				axis == 1 ? current * Static.sixteenth : 0,
				axis == 2 ? current * Static.sixteenth : 0);
			cache.setValue(cacheid, current);
		}

		@Override
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			if(cache == null || attr == null) return;
			GL11.glTranslatef(
				axis == 0 ? current * -Static.sixteenth : 0,
				axis == 1 ? current * -Static.sixteenth : 0,
				axis == 2 ? current * -Static.sixteenth : 0);
			//GL11.glPopMatrix();
		}
		
		@Override
		public Program parse(JsonElement elm){
			JsonArray array = elm.getAsJsonArray();
			String attr = array.get(0).getAsString();
			boolean boolstate = array.get(1).getAsBoolean();
			float min = array.get(2).getAsFloat();
			float max = array.get(3).getAsFloat();
			float step = array.get(4).getAsFloat();
			int axis = array.get(5).getAsInt();
			return new AttributeTranslator(attr, boolstate, min, max, step, axis);
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
		
		private Attribute<?> attr; private String attribute; boolean ifis;
		
		public AttributeVisible(String attribute, boolean ifis){
			this.attribute = attribute; this.ifis = ifis;
		}

		@Override public String getId(){ return "fvtm:attribute_visible"; }
		
		@Override
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			attr = data.getAttribute(attribute); if(attr == null) return;
			if(attr.boolean_value() != ifis) list.visible = false;
		}
		
		@Override
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			list.visible = true;
		}
		
	};
	
	public static abstract class AlwaysGlow extends Transparent implements Program {

		private boolean didglow;
		
		public AlwaysGlow(){ super(189f, 4f); }
		
		public boolean shouldGlow(Entity ent, VehicleData data){ return true;}
		
		public boolean shouldGlow(TileEntity tile, BlockData data){ return true; }
		//TurboList list, TileEntity ent, BlockData data, RenderCache cache, int meta

		@Override
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			if(!(didglow = shouldGlow(ent, data))) return; super.preRender(list, ent, data, color, part, cache);
		}

		@Override
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			if(!didglow) return; super.postRender(list, ent, data, color, part, cache);
		}
		
		@Override
		public void preRender(TurboList list, TileEntity ent, BlockData data, RenderCache cache){
			if(!(didglow = shouldGlow(ent, data))) return; super.preRender(list, null, null, null, null, cache);
		}

		@Override
		public void postRender(TurboList list, TileEntity ent, BlockData data, RenderCache cache){
			if(!didglow) return; super.postRender(list, null, null, null, null, cache);
		}
		
	}
	
	public static class Transparent implements Program {
		
		protected float lx, ly, x, y;
		
		public Transparent(float mapx, float mapy){ x = mapx; y = mapy; }

		@Override
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
	        GlStateManager.enableBlend();
	        GlStateManager.disableAlpha();
	        GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.SRC_COLOR);
	        //if(ent != null) GlStateManager.depthMask(!ent.isInvisible());
	        lx = OpenGlHelper.lastBrightnessX; ly = OpenGlHelper.lastBrightnessY;
	        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, x, y);
	        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		}

		@Override
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
	        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, lx, ly);
	        GlStateManager.disableBlend();
	        GlStateManager.enableAlpha();
		}
		
		@Override
		public Program parse(JsonElement elm){
			JsonArray array = elm.getAsJsonArray();
			if(array.size() == 0) return this; 
			float x = array.get(0).getAsFloat();
			float y = array.get(1).getAsFloat();
			return new Transparent(x, y);
		}

		@Override
		public Program parse(String[] args){
			if(args.length < 2) return this;
			float x = Float.parseFloat(args[0]);
			float y = Float.parseFloat(args[1]);
			return new Transparent(x, y);
		}
		
	}
	
	public static class IDSpecific implements Program {
		
		private String group;
		
		public IDSpecific(String id){ this.group = id; }

		@Override
		public String getId(){ return "fvtm:group_specific"; }

		@Override
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			if(!part.equals(group)) list.visible = false;
		}

		@Override
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			list.visible = true;
		}

	}
	
	public static class IDSpecificArray implements Program {
		
		private String[] groups;
		
		public IDSpecificArray(String... ids){ this.groups = ids; }

		@Override
		public String getId(){ return "fvtm:group_specific"; }

		@Override
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			for(String str : groups) if(str.equals(part)) return; list.visible = false;
		}

		@Override
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			list.visible = true;
		}

	}
	
	public static final Program NO_CULLFACE = new Program(){
		@Override public String getId(){ return "fvtm:no_cullface"; }
		//
		@Override
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
            GL11.glDisable(GL11.GL_CULL_FACE);
		}
		//
		@Override
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
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
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			GL11.glPushMatrix(); GL11.glScalef(scale, scale, scale);
		}

		@Override
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			GL11.glPopMatrix();
		}
		
		@Override
		public Program parse(JsonElement elm){
			return new Scale(elm.getAsJsonArray().get(0).getAsFloat());
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
		public String getId(){ return "fvtm:scale"; }
		
		@Override
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			GL11.glPushMatrix(); GL11.glScalef(x, y, z);
		}

		@Override
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			GL11.glPopMatrix();
		}
		
	}
	
	/** Unfinished Prototype. */
	public static class ParticleEmitter implements Program {
		
		private net.minecraft.util.EnumParticleTypes particle;
		private boolean ignore; private float x, y, z, sx, sy, sz;
		private int[] params;
		
		public ParticleEmitter(net.minecraft.util.EnumParticleTypes particle, boolean ignorerange, float x, float y, float z, float sx, float sy, float sz, int... params){
			this.particle = particle; this.ignore = ignorerange; this.x = x; this.y = y; this.z = z; this.sx = sx; this.sy = sy; this.sz = sz; this.params = params;
		}
		
		@Override
		public String getId(){ return "fvtm:particle_emitter"; }

		@Override
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			//
		}

		@Override
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			if(cache != null){
				if(ent != null && ent instanceof VehicleEntity){
					//TODO apply rotation
					ent.world.spawnParticle(particle, ignore, x, y, z, sx, sy, sz, params);
				}
				else{
					//cache.getWorld().spawnParticle(particle, ignore, x, y, z, sx, sy, sz, params);
				}
			}
		}
		
	}
	
	public static class LightBeam implements Program {

		public Vec3d pos;
		public ModelRendererTurbo shape;
		public String swivel;
		public ResourceLocation tex;
		protected BiPredicate<Entity, VehicleData> predicate;
		protected BiPredicate<TileEntity, BlockData> block_predicate;
		
		public LightBeam(){}
		
		public LightBeam init(ModelRendererTurbo turboobj, Vec3d pos, String swivelpoint, ResourceLocation texture, BiPredicate<Entity, VehicleData> predicate){
			this.shape = turboobj;
			this.pos = pos;
			this.tex = texture;
			this.predicate = predicate;
			return this;
		}
		
		public LightBeam setPredicate(BiPredicate<Entity, VehicleData> predicate){
			this.predicate = predicate;
			return this;
		}

		@Override
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			if(ent == null || (predicate != null && !predicate.test(ent, data))) return;
			EffectRenderer.LIGHTRAYS.add(this);
			EffectRenderer.LIGHTRAYDATAS.add(data);
			EffectRenderer.LIGHTRAYVEHS.add((VehicleEntity)ent);
		}
		
		public LightBeam init(ModelRendererTurbo turboobj, Vec3d pos, ResourceLocation texture, BiPredicate<TileEntity, BlockData> predicate){
			this.shape = turboobj;
			this.pos = pos;
			this.tex = texture;
			this.block_predicate = predicate;
			return this;
		}
		
		public LightBeam setBlockPredicate(BiPredicate<TileEntity, BlockData> predicate){
			this.block_predicate = predicate;
			return this;
		}
		
		@Override
		public void preRender(TurboList list, TileEntity ent, BlockData data, RenderCache cache){
			if(ent == null || (block_predicate != null && !block_predicate.test(ent, data))) return;
			EffectRenderer.BLOCK_LIGHTRAYS.add(this);
			EffectRenderer.BLOCK_LIGHTRAYDATAS.add(data);
			EffectRenderer.BLOCK_LIGHTRAYTILES.add(ent);
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
				new Pos(x, y, z).to16Double(), swivelpoint, resloc == null ? null : new ResourceLocation(resloc), null
			);
			beam.setPredicate(predicate);
			return beam;
		}
		
		@Override
		public Program parse(JsonElement elm){
			JsonArray array = elm.getAsJsonArray();
			float sx = array.get(0).getAsFloat();
			float sy = array.get(1).getAsFloat();
			float sz = array.get(2).getAsFloat();
			float expw = array.get(3).getAsFloat();
			float exph = array.get(4).getAsFloat();
			float x = array.get(5).getAsFloat();
			float y = array.get(6).getAsFloat();
			float z = array.get(7).getAsFloat();
			float rx = array.size() > 8 ? array.get(8).getAsFloat() : 0;
			float ry = array.size() > 9 ? array.get(9).getAsFloat() : 0;
			float rz = array.size() > 10 ? array.get(10).getAsFloat() : 0;
			String sp = array.size() > 11 ? array.get(11).getAsString() : "vehicle";
			String rs = array.size() > 12 ? array.get(12).getAsString() : null;
			return init(sx, sy, sz, expw, exph, x, y, z, rx, ry, rz, sp, rs).setPredicate(predicate);
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
	public static final RectLightBeam RECT_LIGHTBEAM_LIGHTS = new RectLightBeam("fvtm:rlb_lights").setPredicate((ent, veh) -> veh.getLightsState()).register();
	public static final RectLightBeam RECT_LIGHTBEAM_FRONT_LIGHTS = new RectLightBeam("fvtm:rlb_front_lights").setPredicate((ent, veh) -> veh.getLightsState() && !veh.getLongLightsState() && !veh.getFogLightsState()).register();
	public static final RectLightBeam RECT_LIGHTBEAM_BACK_LIGHTS = new RectLightBeam("fvtm:rlb_back_lights").setPredicate((ent, veh) -> veh.getLightsState() || veh.getThrottle() < -0.01).register();
	public static final RectLightBeam RECT_LIGHTBEAM_REAR_LIGHTS = RECT_LIGHTBEAM_BACK_LIGHTS;
	public static final RectLightBeam RECT_LIGHTBEAM_BRAKE_LIGHTS = new RectLightBeam("fvtm:rlb_back_lights").setPredicate((ent, veh) -> (ent != null && ((GenericVehicle)ent).isBraking())).register();
	public static final RectLightBeam RECT_LIGHTBEAM_LONG_LIGHTS = new RectLightBeam("fvtm:rlb_long_lights").setPredicate((ent, veh) -> veh.getLongLightsState() && !veh.getFogLightsState()).register();
	public static final RectLightBeam RECT_LIGHTBEAM_FOG_LIGHTS = new RectLightBeam("fvtm:rlb_fog_lights").setPredicate((ent, veh) -> veh.getFogLightsState()).register();
	public static final RectLightBeam RECT_LIGHTBEAM_REVERSE_LIGHTS = new RectLightBeam("fvtm:rlb_reverse_lights").setPredicate((ent, veh) -> veh.getThrottle() < -0.01).register();
	public static final RectLightBeam RECT_LIGHTBEAM_SIGNAL_LEFT = new RectLightBeam("fvtm:rlb_signal_left").setPredicate((ent, veh) -> BLINKER_TOGGLE && (veh.getTurnLightLeft() || veh.getWarningLights())).register();
	public static final RectLightBeam RECT_LIGHTBEAM_SIGNAL_RIGHT = new RectLightBeam("fvtm:rlb_signal_right").setPredicate((ent, veh) -> BLINKER_TOGGLE && (veh.getTurnLightRight() || veh.getWarningLights())).register();
	public static final RectLightBeam RECT_LIGHTBEAM_WARNING_LIGHTS = new RectLightBeam("fvtm:rlb_warning_lights").setPredicate((ent, veh) -> BLINKER_TOGGLE && veh.getWarningLights()).register();
	public static final RectLightBeam RECT_LIGHTBEAM_INDICATOR_LEFT = RECT_LIGHTBEAM_SIGNAL_LEFT;
	public static final RectLightBeam RECT_LIGHTBEAM_INDICATOR_RIGHT = RECT_LIGHTBEAM_SIGNAL_RIGHT;
	public static final RectLightBeam RECT_LIGHTBEAM_BACK_LIGHTS_SIGNAL_LEFT = new RectLightBeam("fvtm:rlb_back_lights_signal_left").setPredicate((ent, veh) -> {
		if(veh.getTurnLightLeft() || veh.getWarningLights()) return BLINKER_TOGGLE;
		return veh.getLightsState() || veh.getThrottle() < -0.01;
	}).register();
	public static final RectLightBeam RECT_LIGHTBEAM_BACK_LIGHTS_SIGNAL_RIGHT = new RectLightBeam("fvtm:rlb_back_lights_signal_right").setPredicate((ent, veh) -> {
		if(veh.getTurnLightRight() || veh.getWarningLights()) return BLINKER_TOGGLE;
		return veh.getLightsState() || veh.getThrottle() < -0.01;
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
			public boolean shouldGlow(Entity ent, VehicleData data){
				return data.getAttribute(attr_id).boolean_value();
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
		while((mid += Config.BLINKER_INTERVAL) < date);
		(BLINKER_TIMER = new Timer()).schedule(new TimerTask(){
			@Override
			public void run(){
				BLINKER_TOGGLE = !BLINKER_TOGGLE;
			}
		}, new Date(mid), Config.BLINKER_INTERVAL);
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
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			if((attr = data.getAttribute(attribute)) == null) return;
			current = attr.float_value() < minval ? minval : attr.float_value();
			if(current > maxval(ent, data)) current = maxval;
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
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			list.rotateAxis(0, axis, true);
		}
		
		@Override
		public Program parse(JsonElement elm){
			return parse(JsonUtil.jsonArrayToStringArray(elm.getAsJsonArray()).toArray(new String[0]));
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
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			list.rotateAxis(rot + defrot, axis, override);
		}
		
		@Override
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			list.rotateAxis(override ? defrot : -(rot + defrot), axis, override);
		}
		
		@Override
		public void preRender(TurboList list, TileEntity ent, BlockData data, RenderCache cache){
			list.rotateAxis(rot + defrot, axis, override);
		}
		
		@Override
		public void postRender(TurboList list, TileEntity ent, BlockData data, RenderCache cache){
			list.rotateAxis(override ? defrot : -(rot + defrot), axis, override);
		}
		
		@Override
		public Program parse(JsonElement elm){
			JsonArray array = elm.getAsJsonArray();
			int axis = array.get(0).getAsInt();
			int to = array.get(1).getAsInt();
			int def = array.get(2).getAsInt();
			boolean set = array.get(3).getAsBoolean();
			return new RotationSetter(axis, def, to, set);
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
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			GL11.glPushMatrix();
			GL11.glTranslatef(x, y, z);
		}

		@Override
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			GL11.glPopMatrix();
		}

		@Override
		public void preRender(TurboList list, TileEntity ent, BlockData data, RenderCache cache){
			GL11.glPushMatrix();
			GL11.glTranslatef(x, y, z);
		}

		@Override
		public void postRender(TurboList list, TileEntity ent, BlockData data, RenderCache cache){
			GL11.glPopMatrix();
		}
		
		@Override
		public Program parse(JsonElement elm){
			JsonArray array = elm.getAsJsonArray();
			float x = array.get(0).getAsFloat();
			float y = array.get(1).getAsFloat();
			float z = array.get(2).getAsFloat();
			float s = array.size() > 3 ? array.get(3).getAsFloat() : Static.sixteenth;
			return new TranslationSetter(x, y, z, s);
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
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			ModelBase.bindTexture(resloc);
		}

		@Override
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			//
		}
		
		@Override
		public void preRender(TurboList list, TileEntity ent, BlockData data, RenderCache cache){
			ModelBase.bindTexture(resloc);
		}
		
		@Override
		public void postRender(TurboList list, TileEntity ent, BlockData data, RenderCache cache){
			//
		}
		
		@Override
		public Program parse(JsonElement elm){
			return new TextureBinder(elm.getAsJsonArray().get(0).getAsString());
		}

		@Override
		public Program parse(String[] args){
			return new TextureBinder(args[0]);
		}
		
	}
	
	public static Program RESCALE_NORMAL = new Program(){

		@Override
		public String getId(){
			return "fvtm:rescale_normal";
		}
		
		@Override
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		}

		@Override
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		}
		
		@Override
		public void preRender(TurboList list, TileEntity ent, BlockData data, RenderCache cache){
			GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		}
		
		@Override
		public void postRender(TurboList list, TileEntity ent, BlockData data, RenderCache cache){
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
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			if(ent == null || text.length() == 0) return;
		}

		@Override
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			if(ent == null || text.length() == 0) return;
			if(font_renderer == null) font_renderer = Minecraft.getMinecraft().getRenderManager().getFontRenderer();
	        GlStateManager.pushMatrix();
			if(glow || (attrid != null && attr(data))) super.preRender(list, ent, data, color, part, cache);
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
			if(glow || (attrid != null && attr(data))) super.postRender(list, ent, data, color, part, cache);
	        GlStateManager.popMatrix();
		}
		
		protected boolean attr(VehicleData data){
			attr = data.getAttribute(attrid);
			return attr != null && attr.boolean_value();
		}

		@Override
		public void preRender(TurboList list, TileEntity ent, BlockData data, RenderCache cache){
			//if(glow) super.preRender(list, ent, data, cache);
		}
		
		@Override
		public void postRender(TurboList list, TileEntity ent, BlockData data, RenderCache cache){
			if(ent == null || text.length() == 0) return;
			if(font_renderer == null) font_renderer = Minecraft.getMinecraft().getRenderManager().getFontRenderer();
	        GlStateManager.pushMatrix();
			if(glow) super.preRender(list, ent, data, cache);
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
			if(glow) super.postRender(list, ent, data, cache);
	        GlStateManager.popMatrix();
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
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
			if(ent == null) return;
			if((attr = data.getAttribute(attribute)) == null) return;
			text = attr.string_value();
		}
		
	}
	
}