package net.fexcraft.mod.fvtm.model.vehicle;

import com.google.gson.JsonObject;

import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class VehicleModel extends VehicleBaseModel {

    public ModelRendererTurbo chassis[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo body[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo bodyColoredPrimary[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo bodyColoredSecondary[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo bodyDoorOpen[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo bodyDoorClose[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo bodyDoorOpenColoredPrimary[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo bodyDoorCloseColoredPrimary[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo turret[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo steering[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo wheels_import[] = new ModelRendererTurbo[0];

    public VehicleModel(){ super(); }

    public VehicleModel(JsonObject obj){
    	super(obj);
        chassis = this.getSubModel("chassis");
        body = this.getSubModel("body");
        bodyColoredPrimary = this.getSubModel("body_colored_primary");
        bodyColoredSecondary = this.getSubModel("body_colored_secondary");
        bodyDoorOpen = this.getSubModel("body_door_open");
        bodyDoorClose = this.getSubModel("body_door_close");
        bodyDoorOpenColoredPrimary = this.getSubModel("body_door_open_colored_primary");
        bodyDoorCloseColoredPrimary = this.getSubModel("body_door_close_colored_primary");
        turret = this.getSubModel("turret");
        wheels_import = this.getSubModel("wheels_import");
    }

    @Override
    public void rotate(ModelRendererTurbo[] mod, float d, float d1, float d2){
        for(ModelRendererTurbo model : mod){
            model.rotateAngleX = d;
            model.rotateAngleY = d1;
            model.rotateAngleZ = d2;
        }
    }

    @Override
    public void rotateAll(float x, float y, float z){
        rotate(chassis, x, y, z);
        rotate(body, x, y, z);
        rotate(bodyColoredPrimary, x, y, z);
        rotate(bodyColoredSecondary, x, y, z);
        rotate(bodyDoorOpen, x, y, z);
        rotate(bodyDoorClose, x, y, z);
        rotate(bodyDoorOpenColoredPrimary, x, y, z);
        rotate(bodyDoorCloseColoredPrimary, x, y, z);
        rotate(turret, x, y, z);
        rotate(steering, x, y, z);
        rotate(wheels_import, x, y, z);
    }

    public void translateAll(float x, float y, float z){
        translate(chassis, x, y, z);
        translate(body, x, y, z);
        translate(bodyColoredPrimary, x, y, z);
        translate(bodyColoredSecondary, x, y, z);
        translate(bodyDoorOpen, x, y, z);
        translate(bodyDoorClose, x, y, z);
        translate(bodyDoorOpenColoredPrimary, x, y, z);
        translate(bodyDoorCloseColoredPrimary, x, y, z);
        translate(turret, x, y, z);
        translate(steering, x, y, z);
        translate(wheels_import, x, y, z);
    }

    public void flip(ModelRendererTurbo[] mod){
        this.fixRotations(mod);
    }

    public void flipAll(){
        flip(chassis);
        flip(body);
        flip(bodyColoredPrimary);
        flip(bodyColoredSecondary);
        flip(bodyDoorOpen);
        flip(bodyDoorClose);
        flip(bodyDoorOpenColoredPrimary);
        flip(bodyDoorCloseColoredPrimary);
        flip(turret);
        flip(steering);
        flip(wheels_import);
    }

}
