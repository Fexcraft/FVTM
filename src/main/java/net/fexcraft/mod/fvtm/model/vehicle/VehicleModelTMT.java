package net.fexcraft.mod.fvtm.model.vehicle;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.tmt.ModelBase;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.minecraft.entity.Entity;

public class VehicleModelTMT extends VehicleBaseModel {

    public ModelRendererTurbo chassis[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo body[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo body_colored_primary[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo body_colored_secondary[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo body_door_open[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo body_door_close[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo body_door_open_colored_primary[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo body_door_close_colored_primary[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo turret[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo steering[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo wheels_import[] = new ModelRendererTurbo[0];

    public VehicleModelTMT(){ super(); }

    public VehicleModelTMT(JsonObject obj){
    	super(obj);
        chassis = submodels.get("chassis");
        body = submodels.get("body");
        body_colored_primary = submodels.get("body_colored_primary");
        body_colored_secondary = submodels.get("body_colored_secondary");
        body_door_open = submodels.get("body_door_open");
        body_door_close = submodels.get("body_door_close");
        body_door_open_colored_primary = submodels.get("body_door_open_colored_primary");
        body_door_close_colored_primary = submodels.get("body_door_close_colored_primary");
        turret = submodels.get("turret");
        wheels_import = submodels.get("wheels_import");
    }

	@Override
	public void render(VehicleData data, Object key){
		render(data, key, null, -2);
	}

	@Override
	public void render(VehicleData data, Object key, Entity ent, int meta){
		//General
		render(chassis);
        render(body);
        render(data.doorsOpen() ? body_door_open : body_door_close);

        //Primary Color
        data.getPrimaryColor().glColorApply();
        render(body_colored_primary);
        render(data.doorsOpen() ? body_door_open_colored_primary : body_door_close_colored_primary);
        RGB.glColorReset();

        //Secondary Color
        data.getSecondaryColor().glColorApply();
        render(body_colored_secondary);
        RGB.glColorReset();

        //Legacy render call
        render(turret);

        //TODO animation, although it's still better if people ad it as part.
        render(steering);

        //In case someone didn't add them as part.
        render(wheels_import);
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
        rotate(body_colored_primary, x, y, z);
        rotate(body_colored_secondary, x, y, z);
        rotate(body_door_open, x, y, z);
        rotate(body_door_close, x, y, z);
        rotate(body_door_open_colored_primary, x, y, z);
        rotate(body_door_close_colored_primary, x, y, z);
        rotate(turret, x, y, z);
        rotate(steering, x, y, z);
        rotate(wheels_import, x, y, z);
    }

    public void translateAll(float x, float y, float z){
    	if(x == 0 && y == 0 && z == 0){ return; }
        translate(chassis, x, y, z);
        translate(body, x, y, z);
        translate(body_colored_primary, x, y, z);
        translate(body_colored_secondary, x, y, z);
        translate(body_door_open, x, y, z);
        translate(body_door_close, x, y, z);
        translate(body_door_open_colored_primary, x, y, z);
        translate(body_door_close_colored_primary, x, y, z);
        translate(turret, x, y, z);
        translate(steering, x, y, z);
        translate(wheels_import, x, y, z);
    }

    public void flip(ModelRendererTurbo[] mod){
        ModelBase.fixRotations(mod);
    }

    public void flipAll(){
        flip(chassis);
        flip(body);
        flip(body_colored_primary);
        flip(body_colored_secondary);
        flip(body_door_open);
        flip(body_door_close);
        flip(body_door_open_colored_primary);
        flip(body_door_close_colored_primary);
        flip(turret);
        flip(steering);
        flip(wheels_import);
    }

}
