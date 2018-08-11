package net.fexcraft.mod.fvtm.model.container;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.part.PartModelTMT;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.entity.Entity;

public class ContainerModelTMT extends ContainerBaseModel {

    public ModelRendererTurbo body[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo body_colored_primary[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo body_colored_secondary[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo body_door_open[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo body_door_close[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo body_door_open_colored_primary[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo body_door_close_colored_primary[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo other[] = new ModelRendererTurbo[0];

    public ContainerModelTMT(){ super(); }

    public ContainerModelTMT(JsonObject obj){
        super(obj);
        body = submodels.get("body");
        body_colored_primary = submodels.get("body_colored_primary");
        body_colored_secondary = submodels.get("body_colored_secondary");
        body_door_open = submodels.get("body_door_open");
        body_door_close = submodels.get("body_door_close");
        body_door_open_colored_primary = submodels.get("body_door_open_colored_primary");
        body_door_close_colored_primary = submodels.get("body_door_close_colored_primary");
        other = submodels.get("other");
    }
    
	@Override
	public void render(ContainerData data, Object key){
		render(data, key, null, -2);
	}

	@Override
	public void render(ContainerData data, Object key, Entity ent, int meta){
		render(body);
        //
		if(PartModelTMT.rq(body_colored_primary, body_door_open_colored_primary, body_door_close_colored_primary)){
			data.getPrimaryColor().glColorApply();
	        render(body_colored_primary);
	        render((key instanceof VehicleData ? ((VehicleData)key).doorsOpen() : false) ? body_door_open_colored_primary : body_door_close_colored_primary);
	        RGB.glColorReset();
		}
        //
		if(PartModelTMT.rq(body_colored_secondary)){
	        data.getSecondaryColor().glColorApply();
	        render(body_colored_secondary);
	        RGB.glColorReset();
		}
        //
        render(other);
	}

}
