package net.fexcraft.mod.fvtm.model.container;

import com.google.gson.JsonObject;

import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ContainerModel extends ContainerBaseModel {

    public ModelRendererTurbo body[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo body_colored_primary[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo body_colored_secondary[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo body_door_open[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo body_door_close[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo body_door_open_colored_primary[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo body_door_close_colored_primary[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo other[] = new ModelRendererTurbo[0];

    public ContainerModel(){ super(); }

    public ContainerModel(JsonObject obj){
        super(obj);
        body = submodels.get("body");
        body_colored_primary = submodels.get("body_colored_primary");
        body_colored_secondary = submodels.get("body_colored_secondary");
        body_door_open = submodels.get("body_door_open");
        body_door_close = submodels.get("body_door_close");
        body_door_open_colored_primary = submodels.get("body_door_open_colored_primary");
        body_door_close_colored_primary = submodels.get("body_door_close_colored_primary");
        other = submodels.get("body");
    }

}
