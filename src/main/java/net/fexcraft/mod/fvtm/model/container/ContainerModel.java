package net.fexcraft.mod.fvtm.model.container;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.minecraft.entity.Entity;

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
	public void render(ContainerData data, Object key, Entity ent, int meta){
		render("body");
        //
		if(notEmpty("body_colored_primary", "body_door_open_colored_primary", "body_door_close_colored_primary")){
			data.getPrimaryColor().glColorApply();
	        render("body_colored_primary");
	        render((key instanceof VehicleData ? ((VehicleData)key).doorsOpen() : false) ? "body_door_open_colored_primary" : "body_door_close_colored_primary");
	        RGB.glColorReset();
		}
        //
		if(notEmpty("body_colored_secondary")){
	        render("body_colored_secondary", data.getSecondaryColor());
		}
        //
        render("other");
	}

}
