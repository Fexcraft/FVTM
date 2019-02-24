package net.fexcraft.mod.fvtm.model;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.utils.Pos;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.api.root.Colorable;
import net.fexcraft.mod.fvtm.model.TurboList.Program;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;

public class DefaultPrograms {

	public static final Program RGB_PRIMARY = new AutoRegProgram(){
		@Override public String getId(){ return "fvtm:rgb_primary"; }
		@Override public void preRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){ color.getPrimaryColor().glColorApply(); }
		@Override public void postRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){ RGB.glColorReset(); }
	};
	
	public static final Program RGB_SECONDARY = new AutoRegProgram(){
		@Override public String getId(){ return "fvtm:rgb_secondary"; }
		@Override public void preRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){ color.getSecondaryColor().glColorApply(); }
		@Override public void postRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){ RGB.glColorReset(); }
	};
	
	public static final Program ALWAYS_GLOW = new AlwaysGlow(){
		@Override public boolean shouldGlow(VehicleEntity ent, VehicleData data){ return true; }
		@Override public String getId(){ return "fvtm:glow"; }
	};
	
	public static final Program LIGHTS = new AlwaysGlow(){
		@Override public boolean shouldGlow(VehicleEntity ent, VehicleData data){ return data.getLightsState() > 0; }
		@Override public String getId(){ return "fvtm:lights"; }
	};
	
	public static final Program FRONT_LIGHTS = new AlwaysGlow(){
		@Override public boolean shouldGlow(VehicleEntity ent, VehicleData data){ return data.getLightsState() > 0; }
		@Override public String getId(){ return "fvtm:front_lights"; }
	};
	
	public static final Program BACK_LIGHTS = new AlwaysGlow(){
		@Override public boolean shouldGlow(VehicleEntity ent, VehicleData data){ return data.getLightsState() > 0 || (ent != null && ent.getThrottle() < -0.01); }
		@Override public String getId(){ return "fvtm:back_lights"; }
	};
	public static final Program REAR_LIGHTS = BACK_LIGHTS, BRAKE_LIGHTS = REAR_LIGHTS;//TODO add "break" marker;
	
	public static final Program FOG_LIGHTS = new AlwaysGlow(){
		@Override public boolean shouldGlow(VehicleEntity ent, VehicleData data){ return data.getLightsState() > 2; }
		@Override public String getId(){ return "fvtm:fog_lights"; }
	};
	
	public static final Program REVERSE_LIGHTS = new AlwaysGlow(){
		@Override public boolean shouldGlow(VehicleEntity ent, VehicleData data){ return ent != null && ent.getThrottle() < -0.01; }
		@Override public String getId(){ return "fvtm:reverse_lights"; }
	};
	
	public static final Program TURN_SIGNAL_LEFT = new AlwaysGlow(){
		@Override public boolean shouldGlow(VehicleEntity ent, VehicleData data){ return false; }//TODO
		@Override public String getId(){ return "fvtm:turn_signal_left"; }
	};
	
	public static final Program TURN_SIGNAL_RIGHT = new AlwaysGlow(){
		@Override public boolean shouldGlow(VehicleEntity ent, VehicleData data){ return false; }//TODO
		@Override public String getId(){ return "fvtm:turn_signal_right"; }
	};
	
	public static final Program INDICATOR_LIGHT_LEFT = TURN_SIGNAL_LEFT, INDICATOR_LIGHT_RIGHT = TURN_SIGNAL_RIGHT;
	
	public static final Program WINDOW = new AutoRegProgram(){
		@Override public String getId(){ return "fvtm:window"; }
		//
		@Override
		public void preRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
            GlStateManager.pushMatrix();
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glDepthMask(false);
            GL11.glEnable(GL11.GL_ALPHA_TEST);
            list.windowcolor.glColorApply();
		}
		//
		@Override
		public void postRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
            RGB.glColorReset();
            GL11.glDisable(GL11.GL_ALPHA_TEST);
            GL11.glDepthMask(true);
            GL11.glDisable(GL11.GL_BLEND);
            GlStateManager.popMatrix();
		}
	};
	
	public static final Program STEERING_X = new AutoRegProgram(){
		@Override public String getId(){ return "fvtm:steering_x"; }
		//
		@Override
		public void preRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
	        if(ent == null) return; list.rotateAxis(ent.getWheelsYaw() * 3F, 0, true);
		}
		//
		@Override
		public void postRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
			//
		}
	};
	
	public static final Program STEERING_Y = new AutoRegProgram(){
		@Override public String getId(){ return "fvtm:steering_y"; }
		//
		@Override
		public void preRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
	        if(ent == null) return; list.rotateAxis(ent.getWheelsYaw() * 3F, 1, true);
		}
		//
		@Override
		public void postRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
			//
		}
	};
	
	public static final Program DEF_WHEEL_ROTATE = new AutoRegProgram(){
		@Override public String getId(){ return "fvtm:default_wheel"; }
		//
		@Override
		public void preRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
			if(ent == null) return; list.rotateAxis(ent.getWheelsAngle(), 2, true);
		}
		//
		@Override
		public void postRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
			if(ent == null) return; list.rotateAxis(-ent.getWheelsAngle(), 2, true);
		}
	};
	
	public static final Program ROTATED_WHEEL_ROTATE = new AutoRegProgram(){
		@Override public String getId(){ return "fvtm:rotated_wheel"; }
		//
		@Override
		public void preRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
			if(ent == null) return; list.rotateAxis(ent.getWheelsAngle(), 2, false);
		}
		//
		@Override
		public void postRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
			if(ent == null) return; list.rotateAxis(-ent.getWheelsAngle(), 2, false);
		}
	};
	
	public static final Program ADJUSTABLE_WHEEL = new AutoRegProgram(){
		private net.fexcraft.lib.mc.utils.Pos lastpos;
		@Override public String getId(){ return "fvtm:adjustable_wheel"; }
		//
		@Override
		public void preRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
	        lastpos = data.getVehicle().getWheelPositions().get(part);
	        lastpos = lastpos == null ? Pos.NULL : lastpos;
	        lastpos.translate();
	        if(part.contains("right")){ GL11.glRotated(180, 0, 1, 0); }
	        if(ent != null && data.getVehicle().getSteeringWheels().contains(part))
	        	list.rotateAxis(ent.getWheelsYaw() * 3F, 1, true);
		}
		//
		@Override
		public void postRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
	        if(ent != null && data.getVehicle().getSteeringWheels().contains(part)) list.rotateAxis(0, 1, true);
			if(part.contains("right")){ GL11.glRotated(-180, 0, 1, 0); }
			lastpos.translateR();
		}
	};
	
	public static final Program ADJUSTABLE_BOGIE = new AutoRegProgram(){
		private net.fexcraft.lib.mc.utils.Pos lastpos;
		@Override public String getId(){ return "fvtm:adjustable_wheel"; }
		//
		@Override
		public void preRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
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
		public void postRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
	        if(ent != null) GL11.glPopMatrix();
			lastpos.translateR();
		}
	};
	
	public static final Program IMPORTED_WHEEL = new AutoRegProgram(){
		private boolean bool;
		@Override public String getId(){ return "fvtm:imported_wheel"; }
		//
		@Override
		public void preRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
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
		public void postRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
	        list.visible = true;
		}
	};
	
	public static final Program DOOR_OPEN = new AutoRegProgram(){
		@Override public String getId(){ return "fvtm:door_open"; }
		//
		@Override
		public void preRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
			list.visible = data.doorsOpen();
		}
		//
		@Override
		public void postRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
	        list.visible = true;
		}
	};
	
	public static final Program DOOR_CLOSE = new AutoRegProgram(){
		@Override public String getId(){ return "fvtm:door_close"; }
		//
		@Override
		public void preRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
			list.visible = !data.doorsOpen();
		}
		//
		@Override
		public void postRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
	        list.visible = true;
		}
	};
	
	public static abstract class AutoRegProgram implements Program {
		
		public AutoRegProgram(){ TurboList.PROGRAMS.add(this); }
		
	}
	
	public static abstract class AlwaysGlow extends AutoRegProgram {
		
		private boolean didglow; private float lx, ly;
		
		public abstract boolean shouldGlow(VehicleEntity ent, VehicleData data);

		@Override
		public void preRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
			if(!(didglow = shouldGlow(ent, data))) return;
	        GlStateManager.enableBlend(); GlStateManager.disableAlpha();
	        GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
	        if(ent != null) GlStateManager.depthMask(!ent.getEntity().isInvisible());
	        lx = OpenGlHelper.lastBrightnessX; ly = OpenGlHelper.lastBrightnessY;
	        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 61680, 0.941162109375f);//238f, 238f);
	        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		}

		@Override
		public void postRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
			if(!didglow) return;
	        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, lx, ly);
	        GlStateManager.disableBlend(); GlStateManager.enableAlpha();
		}
		
	}
	
	public static class IDSpecific extends AutoRegProgram {
		
		private String group;
		
		public IDSpecific(String id){ this.group = id; }

		@Override
		public String getId(){ return "fvtm:group_specific"; }

		@Override
		public void preRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
			if(!part.equals(group)) list.visible = false;
		}

		@Override
		public void postRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
			list.visible = true;
		}

	}
	
	public static class IDSpecificArray extends AutoRegProgram {
		
		private String[] groups;
		
		public IDSpecificArray(String... ids){ this.groups = ids; }

		@Override
		public String getId(){ return "fvtm:group_specific"; }

		@Override
		public void preRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
			for(String str : groups) if(str.equals(part)) return; list.visible = false;
		}

		@Override
		public void postRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
			list.visible = true;
		}

	}
	
	public static final Program NO_CULLFACE = new AutoRegProgram(){
		@Override public String getId(){ return "fvtm:no_cullface"; }
		//
		@Override
		public void preRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
            GL11.glDisable(GL11.GL_CULL_FACE);
		}
		//
		@Override
		public void postRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
            GL11.glEnable(GL11.GL_CULL_FACE);
		}
	};
	
}