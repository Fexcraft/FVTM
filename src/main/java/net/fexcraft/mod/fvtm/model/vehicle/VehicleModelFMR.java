package net.fexcraft.mod.fvtm.model.vehicle;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.lib.fmr.ModelCompound;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.entity.Entity;

public class VehicleModelFMR extends VehicleBaseModel {

    public ModelCompound chassis = new ModelCompound();
    public ModelCompound body = new ModelCompound();
    public ModelCompound body_colored_primary = new ModelCompound();
    public ModelCompound body_colored_secondary = new ModelCompound();
    public ModelCompound body_door_open = new ModelCompound();
    public ModelCompound body_door_close = new ModelCompound();
    public ModelCompound body_door_open_colored_primary = new ModelCompound();
    public ModelCompound body_door_close_colored_primary = new ModelCompound();
    public ModelCompound turret = new ModelCompound();
    public ModelCompound steering = new ModelCompound();
    public ModelCompound wheels_import = new ModelCompound();

    public VehicleModelFMR(){ super(); }

    public VehicleModelFMR(JsonObject obj){
    	super(obj);
        chassis = fmrmodels.get("chassis");
        body = fmrmodels.get("body");
        body_colored_primary = fmrmodels.get("body_colored_primary");
        body_colored_secondary = fmrmodels.get("body_colored_secondary");
        body_door_open = fmrmodels.get("body_door_open");
        body_door_close = fmrmodels.get("body_door_close");
        body_door_open_colored_primary = fmrmodels.get("body_door_open_colored_primary");
        body_door_close_colored_primary = fmrmodels.get("body_door_close_colored_primary");
        turret = fmrmodels.get("turret");
        wheels_import = fmrmodels.get("wheels_import");
    }

	@Override
	public void render(VehicleData data, Object key){
		render(data, key, null, -2);
	}

	@Override
	public void render(VehicleData data, Object key, Entity ent, int meta){
		//General
		chassis.render();
        body.render();
        if(data.doorsOpen()) body_door_open.render(); else body_door_close.render();

        //Primary Color
        data.getPrimaryColor().glColorApply();
        body_colored_primary.render();
        if(data.doorsOpen()) body_door_open_colored_primary.render(); else body_door_close_colored_primary.render();
        RGB.glColorReset();

        //Secondary Color
        data.getSecondaryColor().glColorApply();
        body_colored_secondary.render();
        RGB.glColorReset();

        //Legacy render call
        turret.render();

        //TODO animation, although it's still better if people ad it as part.
        steering.render();

        //In case someone didn't add them as part.
        wheels_import.render();
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
        chassis.rotate(x, y, z);
        body.rotate(x, y, z);
        body_colored_primary.rotate(x, y, z);
        body_colored_secondary.rotate(x, y, z);
        body_door_open.rotate(x, y, z);
        body_door_close.rotate(x, y, z);
        body_door_open_colored_primary.rotate(x, y, z);
        body_door_close_colored_primary.rotate(x, y, z);
        turret.rotate(x, y, z);
        steering.rotate(x, y, z);
        wheels_import.rotate(x, y, z);
    }

    public void translateAll(float x, float y, float z){
    	if(x == 0 && y == 0 && z == 0){ return; }
    	chassis.translate(x, y, z);
    	body.translate(x, y, z);
    	body_colored_primary.translate(x, y, z);
    	body_colored_secondary.translate(x, y, z);
    	body_door_open.translate(x, y, z);
    	body_door_close.translate(x, y, z);
    	body_door_open_colored_primary.translate(x, y, z);
    	body_door_close_colored_primary.translate(x, y, z);
    	turret.translate(x, y, z);
    	steering.translate(x, y, z);
    	wheels_import.translate(x, y, z);
    }

}
