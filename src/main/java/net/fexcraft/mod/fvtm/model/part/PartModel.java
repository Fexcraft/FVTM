package net.fexcraft.mod.fvtm.model.part;

import com.google.gson.JsonObject;

import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

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
    public ModelRendererTurbo windowsDoorOpen[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo windowsDoorClose[] = new ModelRendererTurbo[0];
    
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
        windowsDoorOpen = submodels.get("windows_door_open");
        windowsDoorClose = submodels.get("windows_door_close");
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

}
