package net.fexcraft.mod.addons.zmp.models.part;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.part.PartModel;

public class Model4x4EscapeBackSeats extends PartModel {

    public Model4x4EscapeBackSeats(){
    	super(); textureX = 512; textureY = 512;
        this.addToCreators("zackyboy18"); this.addToCreators("FEX___96");
        ModelRendererTurbo[] body = new ModelRendererTurbo[18];
        body[0] = new ModelRendererTurbo(this, 121, 113, textureX, textureY); // Box 272
        body[1] = new ModelRendererTurbo(this, 161, 113, textureX, textureY); // Box 273
        body[2] = new ModelRendererTurbo(this, 353, 65, textureX, textureY); // Box 274
        body[3] = new ModelRendererTurbo(this, 209, 113, textureX, textureY); // Box 275
        body[4] = new ModelRendererTurbo(this, 49, 57, textureX, textureY); // Box 276
        body[5] = new ModelRendererTurbo(this, 457, 113, textureX, textureY); // Box 277
        body[6] = new ModelRendererTurbo(this, 1, 121, textureX, textureY); // Box 278
        body[7] = new ModelRendererTurbo(this, 369, 121, textureX, textureY); // Box 279
        body[8] = new ModelRendererTurbo(this, 1, 73, textureX, textureY); // Box 280
        body[9] = new ModelRendererTurbo(this, 265, 201, textureX, textureY); // Box 523
        body[10] = new ModelRendererTurbo(this, 361, 33, textureX, textureY); // Box 524
        body[11] = new ModelRendererTurbo(this, 369, 33, textureX, textureY); // Box 525
        body[12] = new ModelRendererTurbo(this, 289, 201, textureX, textureY); // Box 526
        body[13] = new ModelRendererTurbo(this, 417, 33, textureX, textureY); // Box 527
        body[14] = new ModelRendererTurbo(this, 465, 33, textureX, textureY); // Box 528
        body[15] = new ModelRendererTurbo(this, 313, 201, textureX, textureY); // Box 529
        body[16] = new ModelRendererTurbo(this, 489, 33, textureX, textureY); // Box 530
        body[17] = new ModelRendererTurbo(this, 81, 41, textureX, textureY); // Box 531

        body[0].addBox(0F, 0F, 0F, 8, 2, 10, 0F); // Box 272
        body[0].setRotationPoint(-12F, 2F, 6F);

        body[1].addBox(0F, 0F, 0F, 12, 1, 10, 0F); // Box 273
        body[1].setRotationPoint(-12F, 2F, 6F);
        body[1].rotateAngleZ = 1.8675023F;

        body[2].addBox(0F, 0F, 0F, 7, 2, 6, 0F); // Box 274
        body[2].setRotationPoint(-12F, 4F, 5F);

        body[3].addBox(0F, 0F, 0F, 8, 2, 10, 0F); // Box 275
        body[3].setRotationPoint(-12F, 2F, -4.5F);

        body[4].addBox(0F, 0F, 0F, 7, 2, 4, 0F); // Box 276
        body[4].setRotationPoint(-12F, 4F, -1.5F);

        body[5].addBox(0F, 0F, 0F, 12, 1, 10, 0F); // Box 277
        body[5].setRotationPoint(-12F, 2F, -4.5F);
        body[5].rotateAngleZ = 1.8675023F;

        body[6].addBox(0F, 0F, 0F, 8, 2, 10, 0F); // Box 278
        body[6].setRotationPoint(-12F, 2F, -15F);

        body[7].addBox(0F, 0F, 0F, 12, 1, 10, 0F); // Box 279
        body[7].setRotationPoint(-12F, 2F, -15F);
        body[7].rotateAngleZ = 1.8675023F;

        body[8].addBox(0F, 0F, 0F, 7, 2, 6, 0F); // Box 280
        body[8].setRotationPoint(-12F, 4F, -12F);

        body[9].addBox(0F, 0F, 0F, 1, 3, 8, 0F); // Box 523
        body[9].setRotationPoint(-15.5F, -13.5F, -14F);

        body[10].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 524
        body[10].setRotationPoint(-15.5F, -11F, -8F);

        body[11].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 525
        body[11].setRotationPoint(-15.5F, -11F, -13F);

        body[12].addBox(0F, 0F, 0F, 1, 3, 8, 0F); // Box 526
        body[12].setRotationPoint(-15.5F, -13.5F, 7F);

        body[13].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 527
        body[13].setRotationPoint(-15.5F, -11F, 13F);

        body[14].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 528
        body[14].setRotationPoint(-15.5F, -11F, 8F);

        body[15].addBox(0F, 0F, 0F, 1, 3, 8, 0F); // Box 529
        body[15].setRotationPoint(-15.5F, -13.5F, -4F);

        body[16].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 530
        body[16].setRotationPoint(-15.5F, -11F, 2F);

        body[17].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 531
        body[17].setRotationPoint(-15.5F, -11F, -3F);
        //
        this.add("body", body); translate(0F, -12F, 0F); fixRotations();
    }

}