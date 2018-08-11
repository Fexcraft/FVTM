package net.fexcraft.mod.fvtm.model.container;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.lib.fmr.ModelCompound;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.entity.Entity;

public class ContainerModelFMR extends ContainerBaseModel {

    public ModelCompound body = new ModelCompound();
    public ModelCompound body_colored_primary = new ModelCompound();
    public ModelCompound body_colored_secondary = new ModelCompound();
    public ModelCompound body_door_open = new ModelCompound();
    public ModelCompound body_door_close = new ModelCompound();
    public ModelCompound body_door_open_colored_primary = new ModelCompound();
    public ModelCompound body_door_close_colored_primary = new ModelCompound();
    public ModelCompound other = new ModelCompound();

    public ContainerModelFMR(){ super(); }

    public ContainerModelFMR(JsonObject obj){
        super(obj);
        body = fmrmodels.get("body");
        body_colored_primary = fmrmodels.get("body_colored_primary");
        body_colored_secondary = fmrmodels.get("body_colored_secondary");
        body_door_open = fmrmodels.get("body_door_open");
        body_door_close = fmrmodels.get("body_door_close");
        body_door_open_colored_primary = fmrmodels.get("body_door_open_colored_primary");
        body_door_close_colored_primary = fmrmodels.get("body_door_close_colored_primary");
        other = fmrmodels.get("other");
    }
    
	@Override
	public void render(ContainerData data, Object key){
		render(data, key, null, -2);
	}

	@Override
	public void render(ContainerData data, Object key, Entity ent, int meta){
		body.render();
        //
		if(body_colored_primary.shouldRender() || body_door_open_colored_primary.shouldRender() || body_door_close_colored_primary.shouldRender()){
			data.getPrimaryColor().glColorApply();
			body_colored_primary.render();
	        if((key instanceof VehicleData ? ((VehicleData)key).doorsOpen() : false)) body_door_open_colored_primary.render(); else body_door_close_colored_primary.render();
	        RGB.glColorReset();
		}
        //
		if(body_colored_secondary.shouldRender()){
	        data.getSecondaryColor().glColorApply();
	        body_colored_secondary.render();
	        RGB.glColorReset();
		}
        //
        other.render();
	}

}
