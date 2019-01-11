package net.fexcraft.mod.addons.test.models;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.container.ContainerModel;

@fModel(registryname = "test:models/container/small")
public class GenericSmall extends ContainerModel {

    private static final int textureSize = 512;
    private TurboList body;

    public GenericSmall(){
    	super(); ModelRendererTurbo[] body = new ModelRendererTurbo[1];
        body[0] = new ModelRendererTurbo(this, 1, 105, textureSize, textureSize); // Box 1
        body[0].addBox(0F, 0F, 0F, 48, 48, 48, 0F); // Box 1
        body[0].setRotationPoint(-24F, -48F, -24F);
        this.add("body", body); this.body = this.get("body");
    }
    
    @Override
    public void render(ContainerData data, Object obj){
        body.get(0).render();
    }

    @Override
    public void render(ContainerData data, Object obj, VehicleEntity vehicle, int meta){
        render(data, obj);
    }

}
