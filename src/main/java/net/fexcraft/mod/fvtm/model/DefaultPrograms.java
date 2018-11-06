package net.fexcraft.mod.fvtm.model;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.api.root.Colorable;
import net.fexcraft.mod.fvtm.model.TurboList.Program;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;

public class DefaultPrograms {
	
	public static final Program RGB_PRIMARY = new AutoRegProgram(){
		@Override public String getId(){ return "fvtm:rgb_primary"; }
		@Override public void preRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String Part){ color.getPrimaryColor().glColorApply(); }
		@Override public void postRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String Part){ RGB.glColorReset(); }
	};
	
	public static final Program RGB_SECONDARY = new AutoRegProgram(){
		@Override public String getId(){ return "fvtm:rgb_secondary"; }
		@Override public void preRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String Part){ color.getSecondaryColor().glColorApply(); }
		@Override public void postRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String Part){ RGB.glColorReset(); }
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
	
	public static final Program WINDOW = new AutoRegProgram(){
		@Override public String getId(){ return "fvtm:window"; }
		//
		@Override
		public void preRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String Part){
            GlStateManager.pushMatrix();
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glDepthMask(false);
            GL11.glEnable(GL11.GL_ALPHA_TEST);
            list.windowcolor.glColorApply();
		}
		//
		@Override
		public void postRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String Part){
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
		public void preRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String Part){
	        if(ent == null) return;
	        list.rotate(ent.getWheelsYaw() * 3.14159265F / 180F * 3F, 0, 0, true);
		}
		//
		@Override
		public void postRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String Part){
			//
		}
	};
	
	public static final Program STEERING_Y = new AutoRegProgram(){
		@Override public String getId(){ return "fvtm:steering_y"; }
		//
		@Override
		public void preRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String Part){
	        if(ent == null) return;
	        list.rotate(0, ent.getWheelsYaw() * 3.14159265F / 180F * 3F, 0, true);
		}
		//
		@Override
		public void postRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String Part){
			//
		}
	};
	
	public static final Program DEF_WHEEL_ROTATE = new AutoRegProgram(){
		@Override public String getId(){ return "fvtm:default_wheel"; }
		//
		@Override
		public void preRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String Part){
			list.rotate(0, 0, ent.getWheelsAngle(), false);
		}
		//
		@Override
		public void postRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String Part){
			//
		}
	};
	
	public static final Program ROTATED_WHEEL_ROTATE = new AutoRegProgram(){
		@Override public String getId(){ return "fvtm:rotated_wheel"; }
		//
		@Override
		public void preRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String Part){
			list.rotate(0, 0, ent.getWheelsAngle(), true);
		}
		//
		@Override
		public void postRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String Part){
			//
		}
	};
	
	public static abstract class AutoRegProgram implements Program {
		
		public AutoRegProgram(){ TurboList.PROGRAMS.add(this); }
		
	}
	
	public static abstract class AlwaysGlow extends AutoRegProgram {
		
		public abstract boolean shouldGlow(VehicleEntity ent, VehicleData data);

		@Override
		public void preRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String Part){
			if(!shouldGlow(ent, data)) return;
	        GlStateManager.enableBlend();
	        GlStateManager.disableAlpha();
	        GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
	        GlStateManager.depthMask(true);
	        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 238f, 238f);
	        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		}

		@Override
		public void postRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String Part){
			if(!shouldGlow(ent, data)) return;
	        int i = ent == null ? MapColor.WHITE_STAINED_HARDENED_CLAY.colorValue : ent.getEntity().getBrightnessForRender(), j = i % 65536, k = i / 65536;
	        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) j, (float) k);
	        GlStateManager.disableBlend();
	        GlStateManager.enableAlpha();
		}
		
	}
	
}