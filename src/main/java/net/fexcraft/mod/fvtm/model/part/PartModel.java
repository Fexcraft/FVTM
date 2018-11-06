package net.fexcraft.mod.fvtm.model.part;

import com.google.gson.JsonObject;

import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.model.TurboList;

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
		for(TurboList list : groups.values()){
			list.render(null, data, data, null);
		}
	}

	@Override
	public void render(VehicleData data, String key, VehicleEntity ent, int meta){
		for(TurboList list : groups.values()){
			list.render(ent, data, data, key);
		}
	}

    public void def_renderWheels4(VehicleData type, String us, VehicleEntity veh, boolean rot){
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
                render(type, "wheel_front_left");
                break;
            case "right_front_wheel":
                render(type, "wheel_front_right");
                break;
            case "left_back_wheel":
                render(type, "wheel_back_left");
                break;
            case "right_back_wheel":
                render(type, "wheel_back_right");
                break;
        }
    }

    public void def_renderWheels4(VehicleData type, String us, VehicleEntity veh){
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
