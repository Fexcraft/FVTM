package net.fexcraft.mod.addons.fvp.models.part.c5;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.part.PartModel;

public class ModelC5FL extends PartModel {

    public ModelC5FL(){
    	super(); textureX = 512; textureY = 512;
        addToCreators("Ferdinand (FEX___96)");
        ModelRendererTurbo[] front_lights = new ModelRendererTurbo[4];
        front_lights[0] = new ModelRendererTurbo(this, 201, 25, textureX, textureY); // Box 85
        front_lights[1] = new ModelRendererTurbo(this, 89, 1, textureX, textureY); // Box 87
        front_lights[2] = new ModelRendererTurbo(this, 129, 1, textureX, textureY); // Box 89
        front_lights[3] = new ModelRendererTurbo(this, 281, 25, textureX, textureY); // Box 90
        front_lights[0].addBox(0F, 0F, 0F, 2, 3, 5, 0F); // Box 85
        front_lights[0].setRotationPoint(59.9F, -6F, -21.9F);
        front_lights[1].addShapeBox(0F, 0F, 0F, 2, 3, 1, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 87
        front_lights[1].setRotationPoint(59.9F, -6F, -22.9F);
        front_lights[2].addShapeBox(0F, 0F, 0F, 2, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F); // Box 89
        front_lights[2].setRotationPoint(59.9F, -6F, 21.9F);
        front_lights[3].addBox(0F, 0F, 0F, 2, 3, 5, 0F); // Box 90
        front_lights[3].setRotationPoint(59.9F, -6F, 16.9F);
        this.add("front_lights", front_lights);
        fixRotations();
    }

    /*@Override
	public void render(VehicleData data, String us){
		render(front_lights);
	}
	
	@Override
	public void render(VehicleData data, String us, Entity vehicle, int meta){
		render(front_lights);
	}*/
    
}
