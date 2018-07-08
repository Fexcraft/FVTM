package net.fexcraft.mod.fvtm.model.part;

import org.lwjgl.opengl.GL11;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class PartModel extends PartBaseModel {

    public ModelRendererTurbo body[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo body_colored_primary[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo body_colored_secondary[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo body_door_open[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo body_door_close[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo body_door_open_colored_primary[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo body_door_close_colored_primary[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo turret[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo steering[] = new ModelRendererTurbo[0];
    //
    public ModelRendererTurbo wheels[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo wheel_front[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo wheel_back[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo wheel_front_left[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo wheel_back_left[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo wheel_front_right[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo wheel_back_right[] = new ModelRendererTurbo[0];
    //
    public ModelRendererTurbo track_wheels[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo track_wheels_right[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo track_wheels_left[] = new ModelRendererTurbo[0];
    //
    public ModelRendererTurbo lights[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo front_lights[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo back_lights[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo reverse_lights[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo fog_lights[] = new ModelRendererTurbo[0];
    //
    public ModelRendererTurbo windows[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo windows_door_open[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo windows_door_close[] = new ModelRendererTurbo[0];
    
    public PartModel(){ super(); }

    public PartModel(JsonObject obj){
        super(obj);
        body = submodels.get("body");
        body_colored_primary = submodels.get("body_colored_primary");
        body_colored_secondary = submodels.get("body_colored_secondary");
        body_door_open = submodels.get("body_door_open");
        body_door_close = submodels.get("body_door_close");
        body_door_open_colored_primary = submodels.get("body_door_open_colored_primary");
        body_door_close_colored_primary = submodels.get("body_door_close_colored_primary");
        turret = submodels.get("turret");
        //
        steering = submodels.get("steering");
        wheels = submodels.get("wheels");
        wheel_front = submodels.get("wheel_front");
        wheel_back = submodels.get("wheel_back");
        wheel_front_left = submodels.get("wheel_front_left");
        wheel_back_left = submodels.get("wheel_back_left");
        wheel_front_right = submodels.get("wheel_front_right");
        wheel_back_right = submodels.get("wheel_back_right");
        //
        lights = submodels.get("lights");
        front_lights = submodels.get("front_lights");
        back_lights = submodels.get("back_lights");
        reverse_lights = submodels.get("reverse_lights");
        fog_lights = submodels.get("fog_lights");
        //
        windows = submodels.get("windows");
        windows_door_open = submodels.get("windows_door_open");
        windows_door_close = submodels.get("windows_door_close");
    }

	@Override
	public void render(VehicleData data, String key){
        //Body/Chassis
        render(body);
        render(data.doorsOpen() ? body_door_open : body_door_close);
        
        //Primary Color
        if(rq(body_colored_primary, body_door_open_colored_primary, body_door_close_colored_primary)){
            data.getPrimaryColor().glColorApply();
            render(body_colored_primary);
            render(data.doorsOpen() ? body_door_open_colored_primary : body_door_close_colored_primary);
            RGB.glColorReset();
        }
        
        //Secondary Color
        if(rq(body_colored_secondary)){
            data.getSecondaryColor().glColorApply();
            render(body_colored_secondary);
            RGB.glColorReset();
        }

        //Other
        render(turret);
        render(steering);

        //Wheels
        render(wheels);
        render(wheel_front);
        render(wheel_back);
        render(wheel_front_right);
        render(wheel_back_right);
        render(wheel_front_left);
        render(wheel_back_left);
        //
        render(track_wheels);
        render(track_wheels_right);
        render(track_wheels_left);
        //
        render(lights);
        render(front_lights);
        render(back_lights);
        render(reverse_lights);
        render(fog_lights);
        //
        if(rq(windows, windows_door_open, windows_door_close)){
            GlStateManager.pushMatrix();
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glDepthMask(false);
            GL11.glEnable(GL11.GL_ALPHA_TEST);
            windowcolor.glColorApply();
            render(windows);
            render(data.doorsOpen() ? windows_door_open : windows_door_close);
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
        render(body);
        render(data.doorsOpen() ? body_door_open : body_door_close);

        //Primary Color
        if(rq(body_colored_primary, body_door_open_colored_primary, body_door_close_colored_primary)){
            data.getPrimaryColor().glColorApply();
            render(body_colored_primary);
            render(data.doorsOpen() ? body_door_open_colored_primary : body_door_close_colored_primary);
            RGB.glColorReset();
        }
        
        //Secondary Color
        if(rq(body_colored_secondary)){
            data.getSecondaryColor().glColorApply();
            render(body_colored_secondary);
            RGB.glColorReset();
        }

        //Render Turret
        render(turret);

        //Render Steering
        float steerangle = vehicle.getWheelsYaw() * 3.14159265F / 180F * 3F;
        for(ModelRendererTurbo elm : steering){
        	elm.rotateAngleX = steerangle; elm.render();
        }

        //Render Wheels
        for(ModelRendererTurbo element : wheel_back_left){
            element.rotateAngleZ = vehicle.getWheelsAngle();
            element.render();
        }
        for(ModelRendererTurbo element : wheel_back_right){
            element.rotateAngleZ = vehicle.getWheelsAngle();
            element.render();
        }
        for(ModelRendererTurbo element : wheel_back){
            element.rotateAngleZ = vehicle.getWheelsAngle();
            element.render();
        }
        for(ModelRendererTurbo element : wheel_front_left){
            element.rotateAngleZ = vehicle.getWheelsAngle();
            element.rotateAngleY = steerangle;
            element.render();
        }
        for(ModelRendererTurbo element : wheel_front_right){
            element.rotateAngleZ = vehicle.getWheelsAngle();
            element.rotateAngleY = steerangle;
            element.render();
        }
        for(ModelRendererTurbo element : wheel_front){
            element.rotateAngleZ = vehicle.getWheelsAngle();
            element.rotateAngleY = steerangle;
            element.render();
        }
        for(ModelRendererTurbo element : wheels){
            element.rotateAngleZ = vehicle.getWheelsAngle();
            element.render();
        }
        for(ModelRendererTurbo element : track_wheels){
            element.rotateAngleZ = vehicle.getWheelsAngle();
            element.render();
        }
        for(ModelRendererTurbo element : track_wheels_right){
            element.rotateAngleZ = vehicle.getWheelsAngle();
            element.render();
        }
        for(ModelRendererTurbo element : track_wheels_left){
            element.rotateAngleZ = vehicle.getWheelsAngle();
            element.render();
        }
        //
        boolean s1 = data.getLightsState() > 0, s3 = data.getLightsState() > 2, sr = vehicle.getThrottle() < -0.01;
        {
            if(rq(lights, front_lights)){
                if(s1){ lightOff(ent); }
                render(lights);
                render(front_lights);
                //render(back_lights);
                if(s1){ lightOn(ent); }
            }
        }
        {
            if(rq(back_lights)){
                if(s1 || sr){ lightOff(ent); }
                render(back_lights);
                if(s1 || sr){ lightOn(ent); }
            }
        }
        {
            if(rq(fog_lights)){
                if(s3){ lightOff(ent); }
                render(fog_lights);
                if(s3){ lightOn(ent); }
            }
        }
        {
            if(rq(reverse_lights)){
                if(sr){ lightOff(ent); }
                //render(back_lights);
                render(reverse_lights);
                if(sr){ lightOn(ent); }
            }
        }
        //
        if(rq(windows, windows_door_open, windows_door_close)){
            GlStateManager.pushMatrix();
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glDepthMask(false);
            GL11.glEnable(GL11.GL_ALPHA_TEST);
            windowcolor.glColorApply();
            render(windows);
            render(data.doorsOpen() ? windows_door_open : windows_door_close);
            RGB.glColorReset();
            GL11.glDisable(GL11.GL_ALPHA_TEST);
            GL11.glDepthMask(true);
            GL11.glDisable(GL11.GL_BLEND);
            GlStateManager.popMatrix();
        }
	}

    @Override
    public void rotateAll(float x, float y, float z){
        rotate(body, x, y, z);
        rotate(body_colored_primary, x, y, z);
        rotate(body_colored_secondary, x, y, z);
        rotate(body_door_open, x, y, z);
        rotate(body_door_close, x, y, z);
        rotate(body_door_open_colored_primary, x, y, z);
        rotate(body_door_close_colored_primary, x, y, z);
        rotate(turret, x, y, z);
        rotate(steering, x, y, z);
        rotate(wheels, x, y, z);
        rotate(wheel_front, x, y, z);
        rotate(wheel_back, x, y, z);
        rotate(wheel_front_left, x, y, z);
        rotate(wheel_back_left, x, y, z);
        rotate(wheel_front_right, x, y, z);
        rotate(wheel_back_right, x, y, z);
        rotate(track_wheels, x, y, z);
        rotate(track_wheels_right, x, y, z);
        rotate(track_wheels_left, x, y, z);
    }

    public void translateAll(float x, float y, float z){
        translate(body, x, y, z);
        translate(body_colored_primary, x, y, z);
        translate(body_colored_secondary, x, y, z);
        translate(body_door_open, x, y, z);
        translate(body_door_close, x, y, z);
        translate(body_door_open_colored_primary, x, y, z);
        translate(body_door_close_colored_primary, x, y, z);
        translate(turret, x, y, z);
        translate(steering, x, y, z);
        translate(wheels, x, y, z);
        translate(wheel_front, x, y, z);
        translate(wheel_back, x, y, z);
        translate(wheel_front_left, x, y, z);
        translate(wheel_back_left, x, y, z);
        translate(wheel_front_right, x, y, z);
        translate(wheel_back_right, x, y, z);
        translate(track_wheels, x, y, z);
        translate(track_wheels_right, x, y, z);
        translate(track_wheels_left, x, y, z);
    }

    public void flip(ModelRendererTurbo[] model){
        this.fixRotations(model);
    }

    public void flipAll(){
        flip(body);
        flip(body_colored_primary);
        flip(body_colored_secondary);
        flip(body_door_open);
        flip(body_door_close);
        flip(body_door_open_colored_primary);
        flip(body_door_close_colored_primary);
        flip(turret);
        flip(steering);
        flip(wheels);
        flip(wheel_front);
        flip(wheel_back);
        flip(wheel_front_left);
        flip(wheel_front_right);
        flip(wheel_back_left);
        flip(wheel_back_right);
        flip(track_wheels);
        flip(track_wheels_right);
        flip(track_wheels_left);
    }

    public void def_renderWheels4(VehicleData type, String us, Entity veh, boolean rot){
        if(rot){
            switch(us){
                case "left_front_wheel":
                    this.def_renderWheelWithRotations(wheel_front_left, veh, true);
                    break;
                case "right_front_wheel":
                    this.def_renderWheelWithRotations(wheel_front_right, veh, true);
                    break;
                case "left_back_wheel":
                    this.def_renderWheelWithRotations(wheel_back_left, veh, false);
                    break;
                case "right_back_wheel":
                    this.def_renderWheelWithRotations(wheel_back_right, veh, false);
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
                render(wheel_front_left);
                break;
            case "right_front_wheel":
                render(wheel_front_right);
                break;
            case "left_back_wheel":
                render(wheel_back_left);
                break;
            case "right_back_wheel":
                render(wheel_back_right);
                break;
        }
    }

    public void def_renderWheels4(VehicleData type, String us, Entity veh){
        VehicleEntity vehicle = (VehicleEntity) veh;
        switch(us){
            case "left_front_wheel":
                for(ModelRendererTurbo element : wheel_front_left){
                    element.rotateAngleZ = vehicle.getWheelsAngle();
                    element.rotateAngleY = vehicle.getWheelsYaw() * Static.rad180 / 180F * 3F;
                    element.render();
                    element.rotateAngleY = 0;
                }
                break;
            case "right_front_wheel":
                for(ModelRendererTurbo element : wheel_front_right){
                    element.rotateAngleZ = vehicle.getWheelsAngle();
                    element.rotateAngleY = vehicle.getWheelsYaw() * Static.rad180 / 180F * 3F;
                    element.render();
                    element.rotateAngleY = 0;
                }
                break;
            case "left_back_wheel":
                for(ModelRendererTurbo element : wheel_back_left){
                    element.rotateAngleZ = vehicle.getWheelsAngle();
                    element.render();
                }
                break;
            case "right_back_wheel":
                for(ModelRendererTurbo element : wheel_back_right){
                    element.rotateAngleZ = vehicle.getWheelsYaw();
                    element.render();
                }
                break;
        }
    }

}
