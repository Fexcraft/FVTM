package net.fexcraft.mod.addons.zmp.models.part;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.part.PartModel;

public class Model4x4EscapeTrailerHitch extends PartModel {

    public Model4x4EscapeTrailerHitch(){
    	super(); textureX = 512; textureY = 512;
        this.addToCreators("zackyboy18"); this.addToCreators("FEX___96");
        ModelRendererTurbo[] body = new ModelRendererTurbo[4];
        body[0] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 376
        body[1] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 377
        body[2] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 378
        body[3] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 380
        body[0].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 376
        body[0].setRotationPoint(-52F, 12.2F, -0.5F);
        body[1].addShapeBox(0F, 0F, 0F, 17, 1, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 377
        body[1].setRotationPoint(-51F, 13.2F, -1F);
        body[2].addShapeBox(0F, 0F, 0F, 18, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 4F, 0F, 0F, -4F, -1F, 0F, 0F); // Box 378
        body[2].setRotationPoint(-52F, 13.2F, -1F);
        body[3].addShapeBox(0F, 0F, 0F, 18, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 4F, -1F, 0F, 0F); // Box 380
        body[3].setRotationPoint(-52F, 13.2F, 0F);
        this.add("body", body); fixRotations();
    }

}