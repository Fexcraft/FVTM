package net.fexcraft.mod.fvtm.model.vehicle;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.minecraft.entity.Entity;

public class VehicleModel extends VehicleBaseModel {
	
	public static final String[] defval = new String[]{ "chassis", "body", "body_colored_primary", "body_colored_secondary",
		"body_door_open", "body_door_close", "body_door_open_colored_primary", "body_door_close_colored_primary",
		"turret", "steering", "wheels_import"
	};

    public VehicleModel(){ super(); }

    public VehicleModel(JsonObject obj){ super(obj); }

	@Override
	public void render(VehicleData data, Object key){
		render(data, key, null, -2);
	}

	@Override
	public void render(VehicleData data, Object key, Entity ent, int meta){
		//General
		render("chassis");
        render("body");
        render(data.doorsOpen() ? "body_door_open" : "body_door_close");

        //Primary Color
        data.getPrimaryColor().glColorApply();
        render("body_colored_primary");
        render(data.doorsOpen() ? "body_door_open_colored_primary" : "body_door_close_colored_primary");
        RGB.glColorReset();

        //Secondary Color
        render("body_colored_secondary", data.getSecondaryColor());

        //Legacy render call
        render("turret");

        //TODO animation, although it's still better if people ad it as part.
        render("steering");

        //In case someone didn't add them as part.
        render("wheels_import");
	}

}
