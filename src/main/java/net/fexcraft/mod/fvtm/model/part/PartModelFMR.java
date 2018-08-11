package net.fexcraft.mod.fvtm.model.part;

import org.lwjgl.opengl.GL11;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.lib.fmr.ModelCompound;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class PartModelFMR extends PartBaseModel {

    public ModelCompound body = new ModelCompound();
    public ModelCompound body_colored_primary = new ModelCompound();
    public ModelCompound body_colored_secondary = new ModelCompound();
    public ModelCompound body_door_open = new ModelCompound();
    public ModelCompound body_door_close = new ModelCompound();
    public ModelCompound body_door_open_colored_primary = new ModelCompound();
    public ModelCompound body_door_close_colored_primary = new ModelCompound();
    public ModelCompound turret = new ModelCompound();
    public ModelCompound steering = new ModelCompound();
    //
    public ModelCompound wheels = new ModelCompound();
    public ModelCompound wheel_front = new ModelCompound();
    public ModelCompound wheel_back = new ModelCompound();
    public ModelCompound wheel_front_left = new ModelCompound();
    public ModelCompound wheel_back_left = new ModelCompound();
    public ModelCompound wheel_front_right = new ModelCompound();
    public ModelCompound wheel_back_right = new ModelCompound();
    //
    public ModelCompound track_wheels = new ModelCompound();
    public ModelCompound track_wheels_right = new ModelCompound();
    public ModelCompound track_wheels_left = new ModelCompound();
    //
    public ModelCompound lights = new ModelCompound();
    public ModelCompound front_lights = new ModelCompound();
    public ModelCompound back_lights = new ModelCompound();
    public ModelCompound reverse_lights = new ModelCompound();
    public ModelCompound fog_lights = new ModelCompound();
    public ModelCompound turn_signal_left = new ModelCompound();
    public ModelCompound turn_signal_right = new ModelCompound();
    //
    public ModelCompound windows = new ModelCompound();
    public ModelCompound windows_door_open = new ModelCompound();
    public ModelCompound windows_door_close = new ModelCompound();
    
    public PartModelFMR(){ super(); }

    public PartModelFMR(JsonObject obj){
        super(obj);
        body = fmrmodels.get("body");
        body_colored_primary = fmrmodels.get("body_colored_primary");
        body_colored_secondary = fmrmodels.get("body_colored_secondary");
        body_door_open = fmrmodels.get("body_door_open");
        body_door_close = fmrmodels.get("body_door_close");
        body_door_open_colored_primary = fmrmodels.get("body_door_open_colored_primary");
        body_door_close_colored_primary = fmrmodels.get("body_door_close_colored_primary");
        turret = fmrmodels.get("turret");
        //
        steering = fmrmodels.get("steering");
        wheels = fmrmodels.get("wheels");
        wheel_front = fmrmodels.get("wheel_front");
        wheel_back = fmrmodels.get("wheel_back");
        wheel_front_left = fmrmodels.get("wheel_front_left");
        wheel_back_left = fmrmodels.get("wheel_back_left");
        wheel_front_right = fmrmodels.get("wheel_front_right");
        wheel_back_right = fmrmodels.get("wheel_back_right");
        //
        lights = fmrmodels.get("lights");
        front_lights = fmrmodels.get("front_lights");
        back_lights = fmrmodels.get("back_lights");
        reverse_lights = fmrmodels.get("reverse_lights");
        fog_lights = fmrmodels.get("fog_lights");
        //
        windows = fmrmodels.get("windows");
        windows_door_open = fmrmodels.get("windows_door_open");
        windows_door_close = fmrmodels.get("windows_door_close");
    }

	@Override
	public void render(VehicleData data, String key){
        //Body/Chassis
        body.render();
        if(data.doorsOpen()) body_door_open.render(); else body_door_close.render();
        
        //Primary Color
        if(body_colored_primary.shouldRender() || body_door_open_colored_primary.shouldRender() || body_door_close_colored_primary.shouldRender()){
            data.getPrimaryColor().glColorApply();
            body_colored_primary.render();
            if(data.doorsOpen()) body_door_open_colored_primary.render(); else body_door_close_colored_primary.render();
            RGB.glColorReset();
        }
        
        //Secondary Color
        if(body_colored_secondary.shouldRender()){
            data.getSecondaryColor().glColorApply();
            body_colored_secondary.render();
            RGB.glColorReset();
        }

        //Other
        turret.render();
        steering.render();

        //Wheels
        wheels.render();
        wheel_front.render();
        wheel_back.render();
        wheel_front_right.render();
        wheel_back_right.render();
        wheel_front_left.render();
        wheel_back_left.render();
        //
        track_wheels.render();
        track_wheels_right.render();
        track_wheels_left.render();
        //
        lights.render();
        front_lights.render();
        back_lights.render();
        reverse_lights.render();
        fog_lights.render();
        //
        if(windows.shouldRender() || windows_door_open.shouldRender() || windows_door_close.shouldRender()){
            GlStateManager.pushMatrix();
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glDepthMask(false);
            GL11.glEnable(GL11.GL_ALPHA_TEST);
            windowcolor.glColorApply();
            windows.render();
            if(data.doorsOpen()) windows_door_open.render(); else windows_door_close.render();
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
        body.render();
        if(data.doorsOpen()) body_door_open.render(); else body_door_close.render();

        //Primary Color
        if(body_colored_primary.shouldRender() || body_door_open_colored_primary.shouldRender()|| body_door_close_colored_primary.shouldRender()){
            data.getPrimaryColor().glColorApply();
            body_colored_primary.render();
            if(data.doorsOpen()) body_door_open_colored_primary.render(); else body_door_close_colored_primary.render();
            RGB.glColorReset();
        }
        
        //Secondary Color
        if(body_colored_secondary.shouldRender()){
            data.getSecondaryColor().glColorApply();
            body_colored_secondary.render();
            RGB.glColorReset();
        }

        //Render Turret
        turret.render();

        //Render Steering
        float steerangle = vehicle.getWheelsYaw() * 3.14159265F / 180F * 3F;
        steering.rotAngleX = steerangle; steering.render();

        //Render Wheels
        wheel_back_left.rotAngleZ = vehicle.getWheelsAngle(); wheel_back_left.render();
        wheel_back_right.rotAngleZ = vehicle.getWheelsAngle(); wheel_back_right.render();
        wheel_back.rotAngleZ = vehicle.getWheelsAngle(); wheel_back.render();
        wheel_front_left.rotAngleZ = vehicle.getWheelsAngle(); wheel_front_left.rotAngleY = steerangle; wheel_front_left.render();
        wheel_front_right.rotAngleZ = vehicle.getWheelsAngle(); wheel_front_right.rotAngleY = steerangle; wheel_front_right.render();
        wheel_front.rotAngleZ = vehicle.getWheelsAngle(); wheel_front.rotAngleY = steerangle; wheel_front.render();
        wheels.rotAngleZ = vehicle.getWheelsAngle(); wheels.render();
        track_wheels.rotAngleZ = vehicle.getWheelsAngle(); track_wheels.render();
        track_wheels_right.rotAngleZ = vehicle.getWheelsAngle(); track_wheels_right.render();
        track_wheels_left.rotAngleZ = vehicle.getWheelsAngle(); track_wheels_left.render();
        //
        boolean s1 = data.getLightsState() > 0, s3 = data.getLightsState() > 2, sr = vehicle.getThrottle() < -0.01;
        {
            if(lights.shouldRender() || front_lights.shouldRender()){
                if(s1){ lightOff(ent); }
                lights.render();
                front_lights.render();
                //render(back_lights);
                if(s1){ lightOn(ent); }
            }
        }
        {
            if(back_lights.shouldRender()){
                if(s1 || sr){ lightOff(ent); }
                back_lights.render();
                if(s1 || sr){ lightOn(ent); }
            }
        }
        {
            if(fog_lights.shouldRender()){
                if(s3){ lightOff(ent); }
                fog_lights.render();
                if(s3){ lightOn(ent); }
            }
        }
        {
            if(reverse_lights.shouldRender()){
                if(sr){ lightOff(ent); }
                //render(back_lights);
                reverse_lights.render();
                if(sr){ lightOn(ent); }
            }
        }
        //
        if(windows.shouldRender() || windows_door_open.shouldRender() || windows_door_close.shouldRender()){
            GlStateManager.pushMatrix();
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glDepthMask(false);
            GL11.glEnable(GL11.GL_ALPHA_TEST);
            windowcolor.glColorApply();
            windows.render();
            if(data.doorsOpen()) windows_door_open.render(); else windows_door_close.render();
            RGB.glColorReset();
            GL11.glDisable(GL11.GL_ALPHA_TEST);
            GL11.glDepthMask(true);
            GL11.glDisable(GL11.GL_BLEND);
            GlStateManager.popMatrix();
        }
	}

    @Override
    public void rotateAll(float x, float y, float z){
    	body.rotate(x, y, z);
    	body_colored_primary.rotate(x, y, z);
    	body_colored_secondary.rotate(x, y, z);
    	body_door_open.rotate(x, y, z);
    	body_door_close.rotate(x, y, z);
    	body_door_open_colored_primary.rotate(x, y, z);
    	body_door_close_colored_primary.rotate(x, y, z);
    	turret.rotate(x, y, z);
    	steering.rotate(x, y, z);
    	wheels.rotate(x, y, z);
    	wheel_front.rotate(x, y, z);
    	wheel_back.rotate(x, y, z);
    	wheel_front_left.rotate(x, y, z);
    	wheel_back_left.rotate(x, y, z);
    	wheel_front_right.rotate(x, y, z);
    	wheel_back_right.rotate(x, y, z);
    	track_wheels.rotate(x, y, z);
        track_wheels_right.rotate(x, y, z);
        track_wheels_left.rotate(x, y, z);
    }

    public void translateAll(float x, float y, float z){
    	if(x == 0 && y == 0 && z == 0){ return; }
    	body.translate(x, y, z);
    	body_colored_primary.translate(x, y, z);
    	body_colored_secondary.translate(x, y, z);
    	body_door_open.translate(x, y, z);
    	body_door_close.translate(x, y, z);
    	body_door_open_colored_primary.translate(x, y, z);
    	body_door_close_colored_primary.translate(x, y, z);
    	turret.translate(x, y, z);
    	steering.translate(x, y, z);
    	wheels.translate(x, y, z);
    	wheel_front.translate(x, y, z);
    	wheel_back.translate(x, y, z);
    	wheel_front_left.translate(x, y, z);
    	wheel_back_left.translate(x, y, z);
    	wheel_front_right.translate(x, y, z);
    	wheel_back_right.translate(x, y, z);
    	track_wheels.translate(x, y, z);
    	track_wheels_right.translate(x, y, z);
    	track_wheels_left.translate(x, y, z);
    }

    public void def_renderWheels4(VehicleData type, String us){
        switch(us){
            case "left_front_wheel": wheel_front_left.render(); break;
            case "right_front_wheel": wheel_front_right.render(); break;
            case "left_back_wheel": wheel_back_left.render(); break;
            case "right_back_wheel": wheel_back_right.render(); break;
        }
    }

    public void def_renderWheels4(VehicleData type, String us, Entity veh){
        VehicleEntity vehicle = (VehicleEntity) veh;
        switch(us){
            case "left_front_wheel":
            	wheel_front_left.rotAngleZ = vehicle.getWheelsAngle();
            	wheel_front_left.rotAngleY = vehicle.getWheelsYaw() * Static.rad180 / 180F * 3F;
            	wheel_front_left.render();
            	wheel_front_left.rotAngleY = 0;
                break;
            case "right_front_wheel":
            	wheel_front_right.rotAngleZ = vehicle.getWheelsAngle();
            	wheel_front_right.rotAngleY = vehicle.getWheelsYaw() * Static.rad180 / 180F * 3F;
            	wheel_front_right.render();
            	wheel_front_right.rotAngleY = 0;
                break;
            case "left_back_wheel":
            	wheel_back_left.rotAngleZ = vehicle.getWheelsAngle();
            	wheel_back_left.render();
                break;
            case "right_back_wheel":
            	wheel_back_right.rotAngleZ = vehicle.getWheelsAngle();
            	wheel_back_right.render();
                break;
        }
    }

}
