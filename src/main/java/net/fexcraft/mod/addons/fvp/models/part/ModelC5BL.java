package net.fexcraft.mod.addons.fvp.models.part;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.part.PartModel;

public class ModelC5BL extends PartModel {

    public ModelC5BL(){
    	super(); textureX = 512; textureY = 512;
        addToCreators("Ferdinand (FEX___96)");
        ModelRendererTurbo[] back_lights = new ModelRendererTurbo[4];
        back_lights[0] = new ModelRendererTurbo(this, 233, 1, textureX, textureY); // Box 138
        back_lights[1] = new ModelRendererTurbo(this, 305, 81, textureX, textureY); // Box 139
        back_lights[2] = new ModelRendererTurbo(this, 249, 1, textureX, textureY); // Box 142
        back_lights[3] = new ModelRendererTurbo(this, 321, 81, textureX, textureY); // Box 143

        back_lights[0].addShapeBox(0F, 0F, 0F, 2, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 138
        back_lights[0].setRotationPoint(-40.9F, -6F, 21.9F);

        back_lights[1].addBox(0F, 0F, 0F, 2, 3, 5, 0F); // Box 139
        back_lights[1].setRotationPoint(-40.9F, -6F, 16.9F);

        back_lights[2].addShapeBox(0F, 0F, 0F, 2, 3, 1, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 142
        back_lights[2].setRotationPoint(-40.9F, -6F, -22.9F);

        back_lights[3].addBox(0F, 0F, 0F, 2, 3, 5, 0F); // Box 143
        back_lights[3].setRotationPoint(-40.9F, -6F, -21.9F);
        this.add("back_lights", back_lights);
        //translateAll(0F, 0F, 0F);
        flipAll();
    }

    /*@Override
	public void render(VehicleData data, String us){
		render(back_lights);
	}
	
	@Override
	public void render(VehicleData data, String us, Entity vehicle, int meta){
		render(back_lights);
	}*/
    
}
