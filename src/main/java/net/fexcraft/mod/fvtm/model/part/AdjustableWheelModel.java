package net.fexcraft.mod.fvtm.model.part;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.mc.utils.Pos;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;

public class AdjustableWheelModel extends PartBaseModel {

    @Override
    public void render(VehicleData data, String us){
        this.def_renderAdjustableWheels4(data, us);
    }

    @Override
    public void render(VehicleData data, String us, VehicleEntity veh, int meta){
        this.def_renderAdjustableWheels4(data, us, veh, true);
    }

    public void def_renderAdjustableWheels4(VehicleData data, String us){
        Pos pos = data.getVehicle().getWheelPositions().get(us);
        pos = pos == null ? new Pos(0, 0, 0) : pos;
        pos.translate();
        if(us.contains("left")){
            render(data, "wheel");
        }
        else if(us.contains("right")){
            GL11.glRotated(180, 0, 1, 0);
            render(data, "wheel");
            GL11.glRotated(-180, 0, 1, 0);
        }
        pos.translateR();
    }

    public void def_renderAdjustableWheels4(VehicleData data, String us, VehicleEntity ent){
        Pos pos = data.getVehicle().getWheelPositions().get(us);
        pos = pos == null ? new Pos(0, 0, 0) : pos;
        pos.translate();
        boolean str, mir;
        VehicleEntity vehicle = (VehicleEntity) ent;
        switch(us){
            case "left_front_wheel": {
                str = true;
                mir = false;
                break;
            }
            case "right_front_wheel": {
                str = true;
                mir = true;
                break;
            }
            case "left_back_wheel": {
                str = false;
                mir = false;
                break;
            }
            case "right_back_wheel": {
                str = false;
                mir = true;
                break;
            }
            default: {
                str = false;
                mir = us.contains("right");
                break;
            }
        }
        if(mir){
            GL11.glRotated(180, 0, 1, 0);
        }
        float wheelangl = mir ? -vehicle.getWheelsAngle() : vehicle.getWheelsAngle();
        for(ModelRendererTurbo element : get("wheel")){
            element.rotateAngleZ = wheelangl;
            if(str){
                element.rotateAngleY = vehicle.getWheelsYaw() * Static.rad180 / 180F * 3F;
            }
            element.render();
            element.rotateAngleY = 0;
        }
        if(mir){
            GL11.glRotated(-180, 0, 1, 0);
        }
        pos.translateR();
    }

    public void def_renderAdjustableWheels4(VehicleData data, String us, VehicleEntity ent, boolean rot){
        if(rot){
            Pos pos = data.getVehicle().getWheelPositions().get(us);
            pos = pos == null ? new Pos(0, 0, 0) : pos;
            pos.translate();
            boolean str, mir;
            switch(us){
                case "left_front_wheel": {
                    str = true;
                    mir = false;
                    break;
                }
                case "right_front_wheel": {
                    str = true;
                    mir = true;
                    break;
                }
                case "left_back_wheel": {
                    str = false;
                    mir = false;
                    break;
                }
                case "right_back_wheel": {
                    str = false;
                    mir = true;
                    break;
                }
                default: {
                    str = false;
                    mir = us.contains("right");
                    break;
                }
            }
            if(mir){
                GL11.glRotated(180, 0, 1, 0);
            }
            this.def_renderWheelWithRotations("wheel", ent, mir ? -ent.getWheelsAngle() : ent.getWheelsAngle(), str);
            if(mir){
                //for(ModelRendererTurbo turbo : wheels){ turbo.rotateAngleZ = -turbo.rotateAngleZ; }
                GL11.glRotated(-180, 0, 1, 0);
            }
            pos.translateR();
        }
        else{
            def_renderAdjustableWheels4(data, us, ent);
        }
    }

}
