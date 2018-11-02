package net.fexcraft.mod.fvtm.model.part;

import org.lwjgl.opengl.GL11;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class PartModel extends PartBaseModel {
	
	public static final String[] defval = new String[]{
		"body", "body_colored_primary", "body_colored_secondary", "body_door_open", "body_door_close",
		"body_door_open_colored_primary", "body_door_close_colored_primary", "turret", "steering",
		//
		"wheels", "wheel_front", "wheel_back",
		"wheel_front_left", "wheel_back_left", "wheel_front_right", "wheel_back_right", 
		//
		"track_wheels", "track_wheels_right", "track_wheels_left",
		//
		"lights", "front_lights", "back_lights", "reverse_lights",
		"fog_lights", "turn_signal_left", "turn_signal_right",
		//
		"windows", "windows_door_open", "windows_door_close"
	};
    
    public PartModel(){ super(); }

    public PartModel(JsonObject obj){ super(obj); }

	@Override
	public void render(VehicleData data, String key){
        //Body/Chassis
        render("body");
        render(data.doorsOpen() ? "body_door_open" : "body_door_close");
        
        //Primary Color
        if(notEmpty("body_colored_primary", "body_door_open_colored_primary", "body_door_close_colored_primary")){
            data.getPrimaryColor().glColorApply();
            render("body_colored_primary");
            render(data.doorsOpen() ? "body_door_open_colored_primary" : "body_door_close_colored_primary");
            RGB.glColorReset();
        }
        
        //Secondary Color
        if(notEmpty("body_colored_secondary")){
            render("body_colored_secondary", data.getSecondaryColor());
        }

        //Other
        render("turret");
        render("steering");

        //Wheels
        render("wheels");
        render("wheel_front");
        render("wheel_back");
        render("wheel_front_right");
        render("wheel_back_right");
        render("wheel_front_left");
        render("wheel_back_left");
        //
        render("track_wheels");
        render("track_wheels_right");
        render("track_wheels_left");
        //
        render("lights");
        render("front_lights");
        render("back_lights");
        render("reverse_lights");
        render("fog_lights");
        //
        if(notEmpty("windows", "windows_door_open", "windows_door_close")){
            GlStateManager.pushMatrix();
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glDepthMask(false);
            GL11.glEnable(GL11.GL_ALPHA_TEST);
            windowcolor.glColorApply();
            render("windows");
            render(data.doorsOpen() ? "windows_door_open" : "windows_door_close");
            RGB.glColorReset();
            GL11.glDisable(GL11.GL_ALPHA_TEST);
            GL11.glDepthMask(true);
            GL11.glDisable(GL11.GL_BLEND);
            GlStateManager.popMatrix();
        }
	}

	@Override
	public void render(VehicleData data, String key, Entity ent, int meta){
		VehicleEntity vehicle = (VehicleEntity)ent;
		
        //Body/Chassis
        render("body");
        render(data.doorsOpen() ? "body_door_open" : "body_door_close");

        //Primary Color
        if(notEmpty("body_colored_primary", "body_door_open_colored_primary", "body_door_close_colored_primary")){
            data.getPrimaryColor().glColorApply();
            render("body_colored_primary");
            render(data.doorsOpen() ? "body_door_open_colored_primary" : "body_door_close_colored_primary");
            RGB.glColorReset();
        }
        
        //Secondary Color
        if(notEmpty("body_colored_secondary")){
            render("body_colored_secondary", data.getSecondaryColor());
        }

        //Render Turret
        render("turret");

        //Render Steering
        float steerangle = vehicle.getWheelsYaw() * 3.14159265F / 180F * 3F;
        for(ModelRendererTurbo elm : get("steering")){
        	elm.rotateAngleX = steerangle; elm.render();
        }

        //Render Wheels
        for(ModelRendererTurbo element : get("wheel_back_left")){
            element.rotateAngleZ = vehicle.getWheelsAngle();
            element.render();
        }
        for(ModelRendererTurbo element : get("wheel_back_right")){
            element.rotateAngleZ = vehicle.getWheelsAngle();
            element.render();
        }
        for(ModelRendererTurbo element : get("wheel_back")){
            element.rotateAngleZ = vehicle.getWheelsAngle();
            element.render();
        }
        for(ModelRendererTurbo element : get("wheel_front_left")){
            element.rotateAngleZ = vehicle.getWheelsAngle();
            element.rotateAngleY = steerangle;
            element.render();
        }
        for(ModelRendererTurbo element : get("wheel_front_right")){
            element.rotateAngleZ = vehicle.getWheelsAngle();
            element.rotateAngleY = steerangle;
            element.render();
        }
        for(ModelRendererTurbo element : get("wheel_front")){
            element.rotateAngleZ = vehicle.getWheelsAngle();
            element.rotateAngleY = steerangle;
            element.render();
        }
        for(ModelRendererTurbo element : get("wheels")){
            element.rotateAngleZ = vehicle.getWheelsAngle();
            element.render();
        }
        for(ModelRendererTurbo element : get("track_wheels")){
            element.rotateAngleZ = vehicle.getWheelsAngle();
            element.render();
        }
        for(ModelRendererTurbo element : get("track_wheels_right")){
            element.rotateAngleZ = vehicle.getWheelsAngle();
            element.render();
        }
        for(ModelRendererTurbo element : get("track_wheels_left")){
            element.rotateAngleZ = vehicle.getWheelsAngle();
            element.render();
        }
        //
        boolean s1 = data.getLightsState() > 0, s3 = data.getLightsState() > 2, sr = vehicle.getThrottle() < -0.01;
        {
            if(notEmpty("lights", "front_lights")){
                if(s1){
                	renderGlow(ent, "lights", "front_lights");
                }
                else{
                	render("lights"); render("front_lights");
                }
            }
        }
        {
            if(notEmpty("back_lights")){
            	if(s1 || sr) renderGlow(ent, "back_lights");
            	else render("back_lights");
            }
        }
        {
            if(notEmpty("fog_lights")){
            	if(s3) renderGlow(ent, "fog_lights");
            	else render("fog_lights");
            }
        }
        {
            if(notEmpty("reverse_lights")){
            	if(sr) renderGlow(ent, "reverse_lights");
            	else render("reverse_lights");
            }
        }
        //
        if(notEmpty("windows", "windows_door_open", "windows_door_close")){
            GlStateManager.pushMatrix();
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glDepthMask(false);
            GL11.glEnable(GL11.GL_ALPHA_TEST);
            windowcolor.glColorApply();
            render("windows");
            render(data.doorsOpen() ? "windows_door_open" : "windows_door_close");
            RGB.glColorReset();
            GL11.glDisable(GL11.GL_ALPHA_TEST);
            GL11.glDepthMask(true);
            GL11.glDisable(GL11.GL_BLEND);
            GlStateManager.popMatrix();
        }
	}

    public void def_renderWheels4(VehicleData type, String us, Entity veh, boolean rot){
        if(rot){
        	float ret = ((VehicleEntity)veh).getWheelsAngle();
            switch(us){
                case "left_front_wheel":
                    this.def_renderWheelWithRotations("wheel_front_left", veh, ret, true);
                    break;
                case "right_front_wheel":
                    this.def_renderWheelWithRotations("wheel_front_right", veh, ret, true);
                    break;
                case "left_back_wheel":
                    this.def_renderWheelWithRotations("wheel_back_left", veh, ret, false);
                    break;
                case "right_back_wheel":
                    this.def_renderWheelWithRotations("wheel_back_right", veh, ret, false);
                    break;
            }
        }
        else{
            def_renderWheels4(type, us, veh);
        }
    }

    public void def_renderWheels4(VehicleData type, String us){
        switch(us){
            case "left_front_wheel":
                render("wheel_front_left");
                break;
            case "right_front_wheel":
                render("wheel_front_right");
                break;
            case "left_back_wheel":
                render("wheel_back_left");
                break;
            case "right_back_wheel":
                render("wheel_back_right");
                break;
        }
    }

    public void def_renderWheels4(VehicleData type, String us, Entity veh){
        VehicleEntity vehicle = (VehicleEntity) veh;
        switch(us){
            case "left_front_wheel":
                for(ModelRendererTurbo element : get("wheel_front_left")){
                    element.rotateAngleZ = vehicle.getWheelsAngle();
                    element.rotateAngleY = vehicle.getWheelsYaw() * Static.rad180 / 180F * 3F;
                    element.render();
                    element.rotateAngleY = 0;
                }
                break;
            case "right_front_wheel":
                for(ModelRendererTurbo element : get("wheel_front_right")){
                    element.rotateAngleZ = vehicle.getWheelsAngle();
                    element.rotateAngleY = vehicle.getWheelsYaw() * Static.rad180 / 180F * 3F;
                    element.render();
                    element.rotateAngleY = 0;
                }
                break;
            case "left_back_wheel":
                for(ModelRendererTurbo element : get("wheel_back_left")){
                    element.rotateAngleZ = vehicle.getWheelsAngle();
                    element.render();
                }
                break;
            case "right_back_wheel":
                for(ModelRendererTurbo element : get("wheel_back_right")){
                    element.rotateAngleZ = vehicle.getWheelsYaw();
                    element.render();
                }
                break;
        }
    }

}
