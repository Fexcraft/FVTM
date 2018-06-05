package net.fexcraft.mod.fvtm.model.part;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.math.Pos;
import net.minecraft.entity.Entity;

public class AdjustableWheelModel extends PartBaseModel {
	
	public ModelRendererTurbo[] wheel = new ModelRendererTurbo[0];

    @Override
    public void render(VehicleData data, String us){
        this.def_renderAdjustableWheels4(data, us);
    }

    @Override
    public void render(VehicleData data, String us, Entity veh, int meta){
        this.def_renderAdjustableWheels4(data, us, veh, true);
    }

    public void def_renderAdjustableWheels4(VehicleData data, String us){
        Pos pos = data.getVehicle().getWheelPositions().get(us);
        pos = pos == null ? new Pos(0, 0, 0) : pos;
        pos.translate();
        if(us.contains("left")){
            render(wheel);
        }
        else if(us.contains("right")){
            GL11.glRotated(180, 0, 1, 0);
            render(wheel);
            GL11.glRotated(-180, 0, 1, 0);
        }
        pos.translateR();
    }

    public void def_renderAdjustableWheels4(VehicleData data, String us, Entity ent){
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
        for(ModelRendererTurbo element : wheel){
            element.rotateAngleZ = vehicle.getWheelsAngle();
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

    public void def_renderAdjustableWheels4(VehicleData data, String us, Entity ent, boolean rot){
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
            this.def_renderWheelWithRotations(wheel, ent, str);
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
