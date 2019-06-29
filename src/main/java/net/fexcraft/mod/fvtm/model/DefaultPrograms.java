package net.fexcraft.mod.fvtm.model;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.data.WheelSlot;
import net.fexcraft.mod.fvtm.data.root.Attribute;
import net.fexcraft.mod.fvtm.data.root.Colorable;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.TurboList.Program;
import net.fexcraft.mod.fvtm.util.function.WheelFunction;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;

public class DefaultPrograms {

	public static boolean DIDLOAD = false;
	
	public static void init(){
		TurboList.PROGRAMS.add(RGB_PRIMARY);
		TurboList.PROGRAMS.add(RGB_SECONDARY);
		TurboList.PROGRAMS.add(ALWAYS_GLOW);
		TurboList.PROGRAMS.add(LIGHTS);
		TurboList.PROGRAMS.add(FRONT_LIGHTS);
		TurboList.PROGRAMS.add(BACK_LIGHTS);
		TurboList.PROGRAMS.add(FOG_LIGHTS);
		TurboList.PROGRAMS.add(REVERSE_LIGHTS);
		TurboList.PROGRAMS.add(TURN_SIGNAL_LEFT);
		TurboList.PROGRAMS.add(TURN_SIGNAL_RIGHT);
		TurboList.PROGRAMS.add(WINDOW);
		TurboList.PROGRAMS.add(WHEEL_AUTO_ALL);
		TurboList.PROGRAMS.add(WHEEL_AUTO_STEERING);
		TurboList.PROGRAMS.add(NO_CULLFACE);
		TurboList.PROGRAMS.add(STEERING_WHEEL_Z);
		TurboList.PROGRAMS.add(STEERING_WHEEL_X);
		TurboList.PROGRAMS.add(STEERING_WHEEL_Y);
		//
		DIDLOAD = true;
	}

	public static final Program RGB_PRIMARY = new Program(){
		@Override public String getId(){ return "fvtm:rgb_primary"; }
		@Override public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part){ color.getPrimaryColor().glColorApply(); }
		@Override public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part){ RGB.glColorReset(); }
	};
	
	public static final Program RGB_SECONDARY = new Program(){
		@Override public String getId(){ return "fvtm:rgb_secondary"; }
		@Override public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part){ color.getSecondaryColor().glColorApply(); }
		@Override public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part){ RGB.glColorReset(); }
	};
	
	public static final Program ALWAYS_GLOW = new AlwaysGlow(){
		@Override public boolean shouldGlow(Entity ent, VehicleData data){ return true; }
		@Override public String getId(){ return "fvtm:glow"; }
	};
	
	public static final Program LIGHTS = new AlwaysGlow(){
		@Override public boolean shouldGlow(Entity ent, VehicleData data){ return data.getLightsState() > 0; }
		@Override public String getId(){ return "fvtm:lights"; }
	};
	
	public static final Program FRONT_LIGHTS = new AlwaysGlow(){
		@Override public boolean shouldGlow(Entity ent, VehicleData data){ return data.getLightsState() > 0; }
		@Override public String getId(){ return "fvtm:front_lights"; }
	};
	
	public static final Program BACK_LIGHTS = new AlwaysGlow(){
		@Override public boolean shouldGlow(Entity ent, VehicleData data){ return data.getLightsState() > 0 || data.getThrottle() < -0.01; }
		@Override public String getId(){ return "fvtm:back_lights"; }
	};
	public static final Program REAR_LIGHTS = BACK_LIGHTS, BRAKE_LIGHTS = REAR_LIGHTS;//TODO add "break" marker;
	
	public static final Program FOG_LIGHTS = new AlwaysGlow(){
		@Override public boolean shouldGlow(Entity ent, VehicleData data){ return data.getLightsState() > 2; }
		@Override public String getId(){ return "fvtm:fog_lights"; }
	};
	
	public static final Program REVERSE_LIGHTS = new AlwaysGlow(){
		@Override public boolean shouldGlow(Entity ent, VehicleData data){ return data.getThrottle() < -0.01; }
		@Override public String getId(){ return "fvtm:reverse_lights"; }
	};
	
	public static final Program TURN_SIGNAL_LEFT = new AlwaysGlow(){
		@Override public boolean shouldGlow(Entity ent, VehicleData data){ return false; }//TODO
		@Override public String getId(){ return "fvtm:turn_signal_left"; }
	};
	
	public static final Program TURN_SIGNAL_RIGHT = new AlwaysGlow(){
		@Override public boolean shouldGlow(Entity ent, VehicleData data){ return false; }//TODO
		@Override public String getId(){ return "fvtm:turn_signal_right"; }
	};
	
	public static final Program INDICATOR_LIGHT_LEFT = TURN_SIGNAL_LEFT, INDICATOR_LIGHT_RIGHT = TURN_SIGNAL_RIGHT;
	
	public static final Program WINDOW = new Program(){
		@Override public String getId(){ return "fvtm:window"; }
		//
		@Override
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part){
            GlStateManager.pushMatrix();
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glDepthMask(false);
            GL11.glEnable(GL11.GL_ALPHA_TEST);
            PartModel.windowcolor.glColorApply();
		}
		//
		@Override
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part){
            RGB.glColorReset();
            GL11.glDisable(GL11.GL_ALPHA_TEST);
            GL11.glDepthMask(true);
            GL11.glDisable(GL11.GL_BLEND);
            GlStateManager.popMatrix();
		}
	};
	
	public static final Program WHEEL_AUTO_ALL = new Program(){
		
		private WheelSlot slot;
		
		@Override public String getId(){ return "fvtm:wheel_auto_all"; }
		
		@Override
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part){
			slot = data.getPart(part).getFunction(WheelFunction.class, "fvtm:wheel").getWheelPos(data);
			if(slot != null && slot.yrot() != 0f) GL11.glRotatef(slot.yrot(), 0, 1, 0);
			if(slot != null && slot.steering()) GL11.glRotatef(data.getAttribute("steering_angle").getCurrentFloat(), 0, 1, 0);
			GL11.glRotatef(data.getAttribute("wheel_angle").getCurrentFloat(), 0, 0, 1);
		}
		
		@Override
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part){
			GL11.glRotatef(-data.getAttribute("wheel_angle").getCurrentFloat(), 0, 0, 1);
			if(slot != null && slot.steering()) GL11.glRotatef(-data.getAttribute("steering_angle").getCurrentFloat(), 0, 1, 0);
			if(slot != null && slot.yrot() != 0f) GL11.glRotatef(-slot.yrot(), 0, 1, 0);
		}
		
	};
	
	public static final Program WHEEL_AUTO_STEERING = new Program(){
		
		private WheelSlot slot;
		
		@Override public String getId(){ return "fvtm:wheel_auto_steering"; }
		
		@Override
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part){
			slot = data.getPart(part).getFunction(WheelFunction.class, "fvtm:wheel").getWheelPos(data);
			if(slot != null && slot.yrot() != 0f) GL11.glRotatef(slot.yrot(), 0, 1, 0);
			if(slot != null && slot.steering()) GL11.glRotatef(data.getAttribute("steering_angle").getCurrentFloat(), 0, 1, 0);
		}
		
		@Override
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part){
			if(slot != null && slot.steering()) GL11.glRotatef(-data.getAttribute("steering_angle").getCurrentFloat(), 0, 1, 0);
			if(slot != null && slot.yrot() != 0f) GL11.glRotatef(-slot.yrot(), 0, 1, 0);
		}
		
	};
	
	public static final Program STEERING_WHEEL_Z = new SteeringWheel(2, 1f), STEERING_WHEEL_X = new SteeringWheel(0, 1f), STEERING_WHEEL_Y = new SteeringWheel(1, 1f);
	
	/** Only works with centered steering wheels and translated into position. */
	public static class SteeringWheel implements Program {
		
		private byte x, y, z; private float ratio; private String id;
		
		public SteeringWheel(int axis, float ratio){
			x = (byte)(axis == 0 ? 1 : 0); y = (byte)(axis == 1 ? 1 : 0); z = (byte)(axis == 2 ? 1 : 0); this.ratio = ratio;
			id = "fvtm:steering_" + (axis == 0 ? "x" : axis == 1 ? "y" : "z");
		}

		@Override public String getId(){ return id; }
		
		@Override
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part){
			GL11.glRotatef(data.getAttribute("steering_angle").getCurrentFloat() * ratio, x, y, z);
		}
		
		@Override
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part){
			GL11.glRotatef(-data.getAttribute("steering_angle").getCurrentFloat() * ratio, x, y, z);
		}
		
	};
	
	public static class AttributeRotator implements Program {
		
		private Attribute attr; private String attribute;
		private float min, max, step, lastcurr, current; private int axis;
		private boolean boolstatebased, override; private float defrot;
		
		public AttributeRotator(String attribute, boolean boolstatebased, float min, float max, float step, int axis, Float defrot){
			this.attribute = attribute; this.boolstatebased = boolstatebased; current = 0; lastcurr = 0; override = true;
			this.min = min; this.max = max; this.step = step; this.axis = axis; this.defrot = defrot;
			if(min == max || (min == 0f && max == 0f)){ min = -360; max = 360; }
		}
		
		public AttributeRotator(String attribute, boolean boolstatebased, float min, float max, float step, int axis, Float defrot, boolean notadditive){
			this(attribute, boolstatebased, min, max, step, axis, defrot); this.override = notadditive;
		}

		@Override public String getId(){ return "fvtm:attribute_rotator"; }
		
		@Override
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part){
			if(ent == null) return; /*if(attr == null)*/ attr = data.getAttribute(attribute); if(attr == null) return;
			//attr.setCurrentValue(Time.getSecond() % 2);
			/*if(!boolstatebased){
				attr.setCurrentValue(attr.getCurrentFloat() + 0.1f);
				if(attr.getCurrentFloat() >= attr.getMax()) attr.setCurrentValue(attr.getMin());
			}*/
			current = boolstatebased ? (attr.getCurrentBoolean() ? current + step : current - step) : attr.getCurrentFloat();
			if(current > max) current = max; if(current < min) current = min;
			if(current != lastcurr) list.rotateAxis(current + defrot, axis, override);
		}
		
		@Override
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part){
			if(ent == null || attr == null) return;
			if(current != lastcurr) list.rotateAxis(override ? defrot : -(current + defrot), axis, override);
			lastcurr = current;
		}
		
	};
	
	/*public static final Program STEERING_X = new Program(){
		@Override public String getId(){ return "fvtm:steering_x"; }
		//
		@Override
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part){
	        if(ent == null) return; list.rotateAxis(ent.getWheelsYaw() * 3F, 0, true);
		}
		//
		@Override
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part){
			//
		}
	};
	
	public static final Program STEERING_Y = new Program(){
		@Override public String getId(){ return "fvtm:steering_y"; }
		//
		@Override
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part){
	        if(ent == null) return; list.rotateAxis(ent.getWheelsYaw() * 3F, 1, true);
		}
		//
		@Override
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part){
			//
		}
	};
	
	public static final Program DEF_WHEEL_ROTATE = new Program(){
		@Override public String getId(){ return "fvtm:default_wheel"; }
		//
		@Override
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part){
			if(ent == null) return; list.rotateAxis(ent.getWheelsAngle(), 2, true);
		}
		//
		@Override
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part){
			if(ent == null) return; list.rotateAxis(-ent.getWheelsAngle(), 2, true);
		}
	};
	
	public static final Program ROTATED_WHEEL_ROTATE = new Program(){
		@Override public String getId(){ return "fvtm:rotated_wheel"; }
		//
		@Override
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part){
			if(ent == null) return; list.rotateAxis(ent.getWheelsAngle(), 2, false);
		}
		//
		@Override
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part){
			if(ent == null) return; list.rotateAxis(-ent.getWheelsAngle(), 2, false);
		}
	};
	
	public static final Program ADJUSTABLE_WHEEL = new Program(){
		private net.fexcraft.lib.mc.utils.Pos lastpos;
		@Override public String getId(){ return "fvtm:adjustable_wheel"; }
		//
		@Override
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part){
	        lastpos = data.getType().getWheelPositions().get(part);
	        lastpos = lastpos == null ? Pos.NULL : lastpos;
	        lastpos.translate();
	        if(part.contains("right")){ GL11.glRotated(180, 0, 1, 0); }
	        if(ent != null && data.getVehicle().getSteeringWheels().contains(part))
	        	list.rotateAxis(ent.getWheelsYaw() * 3F, 1, true);
		}
		//
		@Override
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part){
	        if(ent != null && data.getVehicle().getSteeringWheels().contains(part)) list.rotateAxis(0, 1, true);
			if(part.contains("right")){ GL11.glRotated(-180, 0, 1, 0); }
			lastpos.translateR();
		}
	};
	
	public static final Program ADJUSTABLE_BOGIE = new Program(){
		private net.fexcraft.lib.mc.utils.Pos lastpos;
		@Override public String getId(){ return "fvtm:adjustable_wheel"; }
		//
		@Override
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part){
	        lastpos = data.getVehicle().getWheelPositions().get(part);
	        lastpos = lastpos == null ? Pos.NULL : lastpos;
	        lastpos.translate();
	        if(ent != null){
	        	GL11.glPushMatrix();
	        	GL11.glRotatef(ent.getBogieYaw()[part.contains("front") ? 0 : 1], 0, 1, 0);
	        }
		}
		//
		@Override
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part){
	        if(ent != null) GL11.glPopMatrix();
			lastpos.translateR();
		}
	};
	
	public static final Program IMPORTED_WHEEL = new Program(){
		private boolean bool;
		@Override public String getId(){ return "fvtm:imported_wheel"; }
		//
		@Override
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part){
			switch(part){
				case "right_front_wheel": bool = list.name.equals("wheel_front_right"); break;
				case "left_front_wheel": bool = list.name.equals("wheel_front_left"); break;
				case "right_back_wheel": bool = list.name.equals("wheel_back_right"); break;
				case "left_back_wheel": bool = list.name.equals("wheel_back_left"); break;
				default: bool = true;
			} list.visible = bool;
		}
		//
		@Override
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part){
	        list.visible = true;
		}
	};
	
	public static final Program DOOR_OPEN = new Program(){
		@Override public String getId(){ return "fvtm:door_open"; }
		//
		@Override
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part){
			list.visible = data.doorsOpen();
		}
		//
		@Override
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part){
	        list.visible = true;
		}
	};
	
	public static final Program DOOR_CLOSE = new Program(){
		@Override public String getId(){ return "fvtm:door_close"; }
		//
		@Override
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part){
			list.visible = !data.doorsOpen();
		}
		//
		@Override
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part){
	        list.visible = true;
		}
	};*/
	
	public static abstract class AlwaysGlow implements Program {
		
		private boolean didglow; private float lx, ly;
		
		public abstract boolean shouldGlow(Entity ent, VehicleData data);

		@Override
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part){
			if(!(didglow = shouldGlow(ent, data))) return;
	        GlStateManager.enableBlend(); GlStateManager.disableAlpha();
	        GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
	        if(ent != null) GlStateManager.depthMask(!ent.isInvisible());
	        lx = OpenGlHelper.lastBrightnessX; ly = OpenGlHelper.lastBrightnessY;
	        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 61680, 0.941162109375f);//238f, 238f);
	        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		}

		@Override
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part){
			if(!didglow) return;
	        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, lx, ly);
	        GlStateManager.disableBlend(); GlStateManager.enableAlpha();
		}
		
	}
	
	public static class IDSpecific implements Program {
		
		private String group;
		
		public IDSpecific(String id){ this.group = id; }

		@Override
		public String getId(){ return "fvtm:group_specific"; }

		@Override
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part){
			if(!part.equals(group)) list.visible = false;
		}

		@Override
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part){
			list.visible = true;
		}

	}
	
	public static class IDSpecificArray implements Program {
		
		private String[] groups;
		
		public IDSpecificArray(String... ids){ this.groups = ids; }

		@Override
		public String getId(){ return "fvtm:group_specific"; }

		@Override
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part){
			for(String str : groups) if(str.equals(part)) return; list.visible = false;
		}

		@Override
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part){
			list.visible = true;
		}

	}
	
	public static final Program NO_CULLFACE = new Program(){
		@Override public String getId(){ return "fvtm:no_cullface"; }
		//
		@Override
		public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part){
            GL11.glDisable(GL11.GL_CULL_FACE);
		}
		//
		@Override
		public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part){
            GL11.glEnable(GL11.GL_CULL_FACE);
		}
	};
	
}