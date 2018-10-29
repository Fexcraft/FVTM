package net.fexcraft.mod.addons.gep.models.containers;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.model.container.ContainerModelTMT;
import net.minecraft.entity.Entity;

public class GenericContainerModel extends ContainerModelTMT {

    private static final GenericContainerModel INSTANCE = new GenericContainerModel();
    private static final int textureSize = 512;

    public GenericContainerModel(){
    	super(); body = new ModelRendererTurbo[4];
        //
        body[0] = new ModelRendererTurbo(this, 1, 1, textureSize, textureSize); // Box 0
        body[0].addBox(0F, 0F, 0F, 192, 48, 48, 0F); // Box 0
        body[0].setRotationPoint(-96F, -48F, -24F);
        //
        body[1] = new ModelRendererTurbo(this, 1, 105, textureSize, textureSize); // Box 1
        body[1].addBox(0F, 0F, 0F, 96, 48, 48, 0F); // Box 1
        body[1].setRotationPoint(-96F, -48F, -24F);
        //
        body[2] = new ModelRendererTurbo(this, 1, 209, textureSize, textureSize); // Box 2
        body[2].addBox(0F, 0F, 0F, 96, 48, 48, 0F); // Box 2
        body[2].setRotationPoint(0F, -48F, -24F);
        //
        body[3] = new ModelRendererTurbo(this, 1, 313, textureSize, textureSize); // Box 3
        body[3].addBox(0F, 0F, 0F, 96, 48, 48, 0F); // Box 3
        body[3].setRotationPoint(-48F, -48F, -24F);
        //
        flipAll();
    }
    
    @Override
    public void render(ContainerData data, Object obj){
    	if(data.getContainer().isLargeContainer()){
            body[0].render();
        }
        else{
            body[3].render();
        }
    }

    @Override
    public void render(ContainerData data, Object obj, Entity vehicle, int meta){
        render(data, obj);
    }

    public static GenericContainerModel get(){
        return INSTANCE;
    }

}
