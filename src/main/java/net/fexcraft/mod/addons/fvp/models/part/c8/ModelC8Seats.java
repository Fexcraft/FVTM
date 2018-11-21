package net.fexcraft.mod.addons.fvp.models.part.c8;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.part.PartModel;

public class ModelC8Seats extends PartModel {

    public ModelC8Seats(){
    	super(); textureX = 512; textureY = 512;
        this.addToCreators("01e4af9b-2a30-471e-addf-f6338ffce04b");
        ModelRendererTurbo[] body = new ModelRendererTurbo[14];
        body[0] = new ModelRendererTurbo(this, 257, 209, textureX, textureY); // Box 136
        body[1] = new ModelRendererTurbo(this, 153, 217, textureX, textureY); // Box 137
        body[2] = new ModelRendererTurbo(this, 97, 129, textureX, textureY); // Box 140
        body[3] = new ModelRendererTurbo(this, 145, 161, textureX, textureY); // Box 141
        body[4] = new ModelRendererTurbo(this, 473, 121, textureX, textureY); // Box 142
        body[5] = new ModelRendererTurbo(this, 281, 129, textureX, textureY); // Box 143
        body[6] = new ModelRendererTurbo(this, 65, 89, textureX, textureY); // Box 201
        body[7] = new ModelRendererTurbo(this, 313, 97, textureX, textureY); // Box 202
        body[8] = new ModelRendererTurbo(this, 57, 105, textureX, textureY); // Box 203
        body[9] = new ModelRendererTurbo(this, 161, 105, textureX, textureY); // Box 204
        body[10] = new ModelRendererTurbo(this, 473, 105, textureX, textureY); // Box 205
        body[11] = new ModelRendererTurbo(this, 305, 129, textureX, textureY); // Box 206
        body[12] = new ModelRendererTurbo(this, 1, 240, textureX, textureY); // Box 207
        body[13] = new ModelRendererTurbo(this, 169, 137, textureX, textureY); // Box 208

        body[0].addBox(0F, 0F, 0F, 12, 2, 36, 0F); // Box 136
        body[0].setRotationPoint(-16F, 0F, -18F);

        body[1].addBox(0F, 0F, 0F, 2, 14, 36, 0F); // Box 137
        body[1].setRotationPoint(-18F, -13F, -18F);
        body[1].rotateAngleZ = 0.15707963F;

        body[2].addBox(0F, 0F, 0F, 12, 2, 14, 0F); // Box 140
        body[2].setRotationPoint(3F, 0F, 4F);

        body[3].addBox(0F, 0F, 0F, 12, 2, 14, 0F); // Box 141
        body[3].setRotationPoint(3F, 0F, -18F);

        body[4].addBox(0F, 0F, 0F, 2, 14, 14, 0F); // Box 142
        body[4].setRotationPoint(1F, -13F, 4F);
        body[4].rotateAngleZ = 0.15707963F;

        body[5].addBox(0F, 0F, 0F, 2, 14, 14, 0F); // Box 143
        body[5].setRotationPoint(1F, -13F, -18F);
        body[5].rotateAngleZ = 0.15707963F;

        body[6].addBox(0F, 0F, 0F, 10, 1, 2, 0F); // Box 201
        body[6].setRotationPoint(4F, 2F, 6F);

        body[7].addBox(0F, 0F, 0F, 10, 1, 2, 0F); // Box 202
        body[7].setRotationPoint(4F, 2F, 14F);

        body[8].addBox(0F, 0F, 0F, 10, 1, 2, 0F); // Box 203
        body[8].setRotationPoint(4F, 2F, -8F);

        body[9].addBox(0F, 0F, 0F, 10, 1, 2, 0F); // Box 204
        body[9].setRotationPoint(4F, 2F, -16F);

        body[10].addBox(0F, 0F, 0F, 10, 1, 2, 0F); // Box 205
        body[10].setRotationPoint(-15F, 2F, 6F);

        body[11].addBox(0F, 0F, 0F, 10, 1, 2, 0F); // Box 206
        body[11].setRotationPoint(-15F, 2F, 14F);

        body[12].addBox(0F, 0F, 0F, 10, 1, 2, 0F); // Box 207
        body[12].setRotationPoint(-15F, 2F, -16F);

        body[13].addBox(0F, 0F, 0F, 10, 1, 2, 0F); // Box 208
        body[13].setRotationPoint(-15F, 2F, -8F);
        this.add("body", body);
        fixRotations();
    }

}
