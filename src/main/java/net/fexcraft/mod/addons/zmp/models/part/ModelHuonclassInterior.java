package net.fexcraft.mod.addons.zmp.models.part;

import net.fexcraft.mod.fvtm.model.part.PartModelTMT;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelHuonclassInterior extends PartModelTMT {

    public ModelHuonclassInterior(){
    	super(); textureX = 512; textureY = 512;
        this.addToCreators("zackyboy18");
        body = new ModelRendererTurbo[13];
        body[0] = new ModelRendererTurbo(this, 353, 25, textureX, textureY); // Box 243
        body[1] = new ModelRendererTurbo(this, 393, 25, textureX, textureY); // Box 18
        body[2] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 19
        body[3] = new ModelRendererTurbo(this, 73, 1, textureX, textureY); // Box 20
        body[4] = new ModelRendererTurbo(this, 449, 137, textureX, textureY); // Box 226
        body[5] = new ModelRendererTurbo(this, 1, 137, textureX, textureY); // Box 228
        body[6] = new ModelRendererTurbo(this, 393, 145, textureX, textureY); // Box 256
        body[7] = new ModelRendererTurbo(this, 489, 137, textureX, textureY); // Box 257
        body[8] = new ModelRendererTurbo(this, 17, 153, textureX, textureY); // Box 258
        body[9] = new ModelRendererTurbo(this, 121, 145, textureX, textureY); // Box 259
        body[10] = new ModelRendererTurbo(this, 57, 153, textureX, textureY); // Box 260
        body[11] = new ModelRendererTurbo(this, 313, 153, textureX, textureY); // Box 261
        body[12] = new ModelRendererTurbo(this, 353, 153, textureX, textureY); // Box 262

        body[0].addShapeBox(0F, 0F, 0F, 1, 1, 18, 0F, 0F, -0.2F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -1F, 0F, -0.2F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -1F); // Box 243
        body[0].setRotationPoint(-53F, -2F, 0F);

        body[1].addShapeBox(0F, 0F, 0F, 1, 1, 18, 0F, 0F, -0.2F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -1F, 0F, -0.2F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -1F); // Box 18
        body[1].setRotationPoint(-53F, -2F, -18F);

        body[2].addShapeBox(0F, 0F, 0F, 7, 1, 1, 0F, -1F, -0.2F, 0F, -1F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -0.2F, 0F, -1F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 19
        body[2].setRotationPoint(-52F, -2F, -19F);

        body[3].addShapeBox(0F, 0F, 0F, 7, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -0.2F, 0F, -1F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -0.2F, 0F, -1F, -0.2F, 0F); // Box 20
        body[3].setRotationPoint(-52F, -2F, 18F);

        body[4].addBox(0F, 0F, 0F, 10, 2, 8, 0F); // Box 226
        body[4].setRotationPoint(-20F, -7F, 4F);

        body[5].addBox(0F, 0F, 0F, 2, 10, 8, 0F); // Box 228
        body[5].setRotationPoint(-21F, -16.5F, 4F);
        body[5].rotateAngleZ = 0.06981317F;

        body[6].addBox(0F, 0F, 0F, 10, 2, 8, 0F); // Box 256
        body[6].setRotationPoint(-4F, -7F, 4F);

        body[7].addBox(0F, 0F, 0F, 2, 10, 8, 0F); // Box 257
        body[7].setRotationPoint(-5F, -16.5F, 4F);
        body[7].rotateAngleZ = 0.06981317F;

        body[8].addBox(0F, 0F, 0F, 8, 2, 8, 0F); // Box 258
        body[8].setRotationPoint(19F, -7F, -4F);

        body[9].addBox(0F, 0F, 0F, 2, 10, 8, 0F); // Box 259
        body[9].setRotationPoint(18F, -16.5F, -4F);
        body[9].rotateAngleZ = 0.06981317F;

        body[10].addBox(0F, 0F, 0F, 8, 3, 8, 0F); // Box 260
        body[10].setRotationPoint(-18F, -5F, 4F);

        body[11].addBox(0F, 0F, 0F, 8, 3, 8, 0F); // Box 261
        body[11].setRotationPoint(-3F, -5F, 4F);

        body[12].addBox(0F, 0F, 0F, 6, 3, 6, 0F); // Box 262
        body[12].setRotationPoint(20F, -5F, -2F);

        steering = new ModelRendererTurbo[13];
        steering[0] = new ModelRendererTurbo(this, 353, 129, textureX, textureY); // Box 261
        steering[1] = new ModelRendererTurbo(this, 361, 129, textureX, textureY); // Box 262
        steering[2] = new ModelRendererTurbo(this, 369, 129, textureX, textureY); // Box 263
        steering[3] = new ModelRendererTurbo(this, 377, 129, textureX, textureY); // Box 264
        steering[4] = new ModelRendererTurbo(this, 409, 129, textureX, textureY); // Box 265
        steering[5] = new ModelRendererTurbo(this, 257, 105, textureX, textureY); // Box 266
        steering[6] = new ModelRendererTurbo(this, 449, 129, textureX, textureY); // Box 267
        steering[7] = new ModelRendererTurbo(this, 385, 129, textureX, textureY); // Box 268
        steering[8] = new ModelRendererTurbo(this, 417, 129, textureX, textureY); // Box 269
        steering[9] = new ModelRendererTurbo(this, 465, 129, textureX, textureY); // Box 270
        steering[10] = new ModelRendererTurbo(this, 473, 129, textureX, textureY); // Box 271
        steering[11] = new ModelRendererTurbo(this, 481, 129, textureX, textureY); // Box 272
        steering[12] = new ModelRendererTurbo(this, 489, 129, textureX, textureY); // Box 273

        steering[0].addBox(0F, -0.5F, 0.5F, 2, 1, 1, 0F); // Box 261
        steering[0].setRotationPoint(30F, -13F, -1F);

        steering[1].addShapeBox(0F, -2.5F, 0.5F, 1, 2, 1, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F); // Box 262
        steering[1].setRotationPoint(30F, -13F, -1F);

        steering[2].addShapeBox(0F, 0.5F, 0.5F, 1, 2, 1, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F); // Box 263
        steering[2].setRotationPoint(30F, -13F, -1F);

        steering[3].addShapeBox(0F, -0.5F, 1.5F, 1, 1, 2, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F); // Box 264
        steering[3].setRotationPoint(30F, -13F, -1F);

        steering[4].addShapeBox(0F, -0.5F, -1.5F, 1, 1, 2, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F); // Box 265
        steering[4].setRotationPoint(30F, -13F, -1F);

        steering[5].addBox(0F, 2.5F, -0.5F, 1, 1, 3, 0F); // Box 266
        steering[5].setRotationPoint(30F, -13F, -1F);

        steering[6].addBox(0F, -3.5F, -0.5F, 1, 1, 3, 0F); // Box 267
        steering[6].setRotationPoint(30F, -13F, -1F);

        steering[7].addBox(0F, -1.5F, -2.5F, 1, 3, 1, 0F); // Box 268
        steering[7].setRotationPoint(30F, -13F, -1F);

        steering[8].addBox(0F, -1.5F, 3.5F, 1, 3, 1, 0F); // Box 269
        steering[8].setRotationPoint(30F, -13F, -1F);

        steering[9].addShapeBox(0F, 1.5F, 3.5F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 1F, 0F, -1F, 1F, 0F, 0F, -2F, 0F, 0F, -2F); // Box 270
        steering[9].setRotationPoint(30F, -13F, -1F);

        steering[10].addShapeBox(0F, -3.5F, 3.5F, 1, 2, 1, 0F, 0F, -1F, 1F, 0F, -1F, 1F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 271
        steering[10].setRotationPoint(30F, -13F, -1F);

        steering[11].addShapeBox(0F, -3.5F, -2.5F, 1, 2, 1, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, -1F, 1F, 0F, -1F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 272
        steering[11].setRotationPoint(30F, -13F, -1F);

        steering[12].addShapeBox(0F, 1.5F, -2.5F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, -1F, 1F, 0F, -1F, 1F); // Box 273
        steering[12].setRotationPoint(30F, -13F, -1F);
        //
        translateAll(0F, 0F, 0F);
        flipAll();
    }
    
}