package net.fexcraft.mod.addons.fvp.models.part;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.part.PartModel;

public class ModelAB1Lights extends PartModel {

    public ModelAB1Lights(){
    	super(); textureX = 1024; textureY = 1024;
        addToCreators("Ferdinand (FEX___96)");
        ModelRendererTurbo[] lights = new ModelRendererTurbo[4];
        lights[0] = new ModelRendererTurbo(this, 57, 161, textureX, textureY); // Box 306
        lights[1] = new ModelRendererTurbo(this, 81, 161, textureX, textureY); // Box 307
        lights[2] = new ModelRendererTurbo(this, 33, 161, textureX, textureY); // Box 308
        lights[3] = new ModelRendererTurbo(this, 321, 161, textureX, textureY); // Box 309
        lights[0].addShapeBox(0F, 0F, 0F, 1, 4, 8, 0F, 1F, 0F, 0F, 3F, 0F, 0F, -0.2F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F); // Box 306
        lights[0].setRotationPoint(97.2F, -10F, 23.7F);
        lights[1].addShapeBox(0F, 0F, 0F, 1, 4, 8, 0F, 1F, 0F, 0F, -0.2F, 0F, 0F, 3F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, 0F, 0F, 0F); // Box 307
        lights[1].setRotationPoint(97.2F, -10F, -31.7F);
        lights[2].addShapeBox(0F, 0F, 0F, 1, 10, 3, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 308
        lights[2].setRotationPoint(-108.2F, -23F, 28.7F);
        lights[3].addShapeBox(0F, 0F, 0F, 1, 10, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F); // Box 309
        lights[3].setRotationPoint(-108.2F, -23F, -31.7F);
        this.add("lights", lights);
        get("lights").addProgram(DefaultPrograms.LIGHTS);
        //translateAll(0F, 0F, 0F);
        fixRotations();
    }

}
