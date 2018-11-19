package net.fexcraft.mod.addons.zmp.models.part;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.part.PartModel;

public class Model4x4EscapeSterringWheel extends PartModel {

    public Model4x4EscapeSterringWheel(){
    	super(); textureX = 512; textureY = 512;
        this.addToCreators("zackyboy18");
        this.addToCreators("FEX___96");
        ModelRendererTurbo[] steering = new ModelRendererTurbo[13];
        steering[0] = new ModelRendererTurbo(this, 505, 33, textureX, textureY); // Box 261
        steering[1] = new ModelRendererTurbo(this, 145, 41, textureX, textureY); // Box 262
        steering[2] = new ModelRendererTurbo(this, 153, 41, textureX, textureY); // Box 263
        steering[3] = new ModelRendererTurbo(this, 417, 41, textureX, textureY); // Box 264
        steering[4] = new ModelRendererTurbo(this, 505, 41, textureX, textureY); // Box 265
        steering[5] = new ModelRendererTurbo(this, 73, 153, textureX, textureY); // Box 266
        steering[6] = new ModelRendererTurbo(this, 97, 153, textureX, textureY); // Box 267
        steering[7] = new ModelRendererTurbo(this, 233, 49, textureX, textureY); // Box 268
        steering[8] = new ModelRendererTurbo(this, 265, 49, textureX, textureY); // Box 269
        steering[9] = new ModelRendererTurbo(this, 193, 49, textureX, textureY); // Box 270
        steering[10] = new ModelRendererTurbo(this, 425, 49, textureX, textureY); // Box 271
        steering[11] = new ModelRendererTurbo(this, 25, 57, textureX, textureY); // Box 272
        steering[12] = new ModelRendererTurbo(this, 73, 57, textureX, textureY); // Box 273

        steering[0].addBox(0F, -0.5F, -0.5F, 2, 1, 1, 0F); // Box 261
        steering[0].setRotationPoint(17F, -5F, 9F);

        steering[1].addShapeBox(0F, -2.5F, -0.5F, 1, 2, 1, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F); // Box 262
        steering[1].setRotationPoint(17F, -5F, 9F);

        steering[2].addShapeBox(0F, 0.5F, -0.5F, 1, 2, 1, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F); // Box 263
        steering[2].setRotationPoint(17F, -5F, 9F);

        steering[3].addShapeBox(0F, -0.5F, 0.5F, 1, 1, 2, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F); // Box 264
        steering[3].setRotationPoint(17F, -5F, 9F);

        steering[4].addShapeBox(0F, -0.5F, -2.5F, 1, 1, 2, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F); // Box 265
        steering[4].setRotationPoint(17F, -5F, 9F);

        steering[5].addBox(0F, 2.5F, -1.5F, 1, 1, 3, 0F); // Box 266
        steering[5].setRotationPoint(17F, -5F, 9F);

        steering[6].addBox(0F, -3.5F, -1.5F, 1, 1, 3, 0F); // Box 267
        steering[6].setRotationPoint(17F, -5F, 9F);

        steering[7].addBox(0F, -1.5F, -3.5F, 1, 3, 1, 0F); // Box 268
        steering[7].setRotationPoint(17F, -5F, 9F);

        steering[8].addBox(0F, -1.5F, 2.5F, 1, 3, 1, 0F); // Box 269
        steering[8].setRotationPoint(17F, -5F, 9F);

        steering[9].addShapeBox(0F, 1.5F, 2.5F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 1F, 0F, -1F, 1F, 0F, 0F, -2F, 0F, 0F, -2F); // Box 270
        steering[9].setRotationPoint(17F, -5F, 9F);

        steering[10].addShapeBox(0F, -3.5F, 2.5F, 1, 2, 1, 0F, 0F, -1F, 1F, 0F, -1F, 1F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 271
        steering[10].setRotationPoint(17F, -5F, 9F);

        steering[11].addShapeBox(0F, -3.5F, -3.5F, 1, 2, 1, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, -1F, 1F, 0F, -1F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 272
        steering[11].setRotationPoint(17F, -5F, 9F);

        steering[12].addShapeBox(0F, 1.5F, -3.5F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, -1F, 1F, 0F, -1F, 1F); // Box 273
        steering[12].setRotationPoint(17F, -5F, 9F);
        this.add("steering", steering);
        //
        translate(0F, -12F, 0F);
        fixRotations();
    }

}
