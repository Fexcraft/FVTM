package net.fexcraft.mod.fvtm.model.container;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.model.TurboList;

public class ContainerModel extends ContainerBaseModel {
	
	public static final String[] defval = new String[]{ "body", "body_colored_primary", "body_door_open_colored_primary",
		"body_door_close_colored_primary", "body_colored_secondary", "other"};

    public ContainerModel(){ super(); }

    public ContainerModel(JsonObject obj){
        super(obj);
    }
    
	@Override
	public void render(ContainerData data, Object key){
		render(data, key, null, -2);
	}

	@Override
	public void render(ContainerData data, Object key, VehicleEntity ent, int meta){
		for(TurboList list : groups.values()){
			list.render(ent, null, data, null);
		}
	}

}
