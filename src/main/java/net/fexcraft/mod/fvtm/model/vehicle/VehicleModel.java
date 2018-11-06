package net.fexcraft.mod.fvtm.model.vehicle;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.model.TurboList;

public class VehicleModel extends VehicleBaseModel {
	
	public static final String[] defval = new String[]{ "chassis", "body", "body_colored_primary", "body_colored_secondary",
		"body_door_open", "body_door_close", "body_door_open_colored_primary", "body_door_close_colored_primary",
		"turret", "steering", "wheels_import"
	};

    public VehicleModel(){ super(); }

    public VehicleModel(JsonObject obj){ super(obj); }

	@Override
	public void render(VehicleData data, Object key){
		this.render(data, key, null, -2);
	}

	@Override
	public void render(VehicleData data, Object key, VehicleEntity ent, int meta){
		for(TurboList list : groups.values()){
			list.render(ent, data, data, null);
		}
	}

}
