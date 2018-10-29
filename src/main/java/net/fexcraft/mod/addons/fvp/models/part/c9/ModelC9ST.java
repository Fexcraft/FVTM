package net.fexcraft.mod.addons.fvp.models.part.c9;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.part.PartModelTMT;

public class ModelC9ST extends PartModelTMT {

    public ModelC9ST(){
    	super(); textureX = 512; textureY = 512;
        this.addToCreators("01e4af9b-2a30-471e-addf-f6338ffce04b");
        steering = new ModelRendererTurbo[12];
		steering[0] = new ModelRendererTurbo(this, 161, 137, textureX, textureY); // Box 446
		steering[1] = new ModelRendererTurbo(this, 273, 137, textureX, textureY); // Box 447
		steering[2] = new ModelRendererTurbo(this, 489, 9, textureX, textureY); // Box 448
		steering[3] = new ModelRendererTurbo(this, 97, 41, textureX, textureY); // Box 449
		steering[4] = new ModelRendererTurbo(this, 73, 129, textureX, textureY); // Box 450
		steering[5] = new ModelRendererTurbo(this, 345, 129, textureX, textureY); // Box 451
		steering[6] = new ModelRendererTurbo(this, 241, 113, textureX, textureY); // Box 452
		steering[7] = new ModelRendererTurbo(this, 297, 113, textureX, textureY); // Box 453
		steering[8] = new ModelRendererTurbo(this, 329, 113, textureX, textureY); // Box 454
		steering[9] = new ModelRendererTurbo(this, 353, 113, textureX, textureY); // Box 455
		steering[10] = new ModelRendererTurbo(this, 409, 129, textureX, textureY); // Box 456
		steering[11] = new ModelRendererTurbo(this, 433, 145, textureX, textureY); // Box 457

		steering[0].addShapeBox(0F, -1F, -1F, 4, 2, 2, 0F,0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F); // Box 446
		steering[0].setRotationPoint(6.5F, -2.5F, 8F);
		steering[0].rotateAngleZ = -0.20943951F;

		steering[1].addShapeBox(-1F, -1F, -1F, 1, 3, 2, 0F,-0.4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, 0F, 0F); // Box 447
		steering[1].setRotationPoint(6.5F, -2.5F, 8F);
		steering[1].rotateAngleZ = -0.20943951F;

		steering[2].addBox(-0.8F, 2F, -1.5F, 1, 1, 3, 0F); // Box 448
		steering[2].setRotationPoint(6.5F, -2.5F, 8F);
		steering[2].rotateAngleZ = -0.20943951F;

		steering[3].addBox(-0.8F, -3F, -1.5F, 1, 1, 3, 0F); // Box 449
		steering[3].setRotationPoint(6.5F, -2.5F, 8F);
		steering[3].rotateAngleZ = -0.20943951F;

		steering[4].addBox(-0.8F, -1.5F, 2F, 1, 3, 1, 0F); // Box 450
		steering[4].setRotationPoint(6.5F, -2.5F, 8F);
		steering[4].rotateAngleZ = -0.20943951F;

		steering[5].addBox(-0.8F, -1.5F, -3F, 1, 3, 1, 0F); // Box 451
		steering[5].setRotationPoint(6.5F, -2.5F, 8F);
		steering[5].rotateAngleZ = -0.20943951F;

		steering[6].addShapeBox(-0.8F, -3F, -2.5F, 1, 1, 1, 0F,0F, -1.5F, 0.5F, 0F, -1.5F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, -0.5F, 0F, 0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 452
		steering[6].setRotationPoint(6.5F, -2.5F, 8F);
		steering[6].rotateAngleZ = -0.20943951F;

		steering[7].addShapeBox(-0.8F, 2F, -2.5F, 1, 1, 1, 0F,0F, 0.5F, -0.5F, 0F, 0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F, 0.5F, 0F, -1.5F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 453
		steering[7].setRotationPoint(6.5F, -2.5F, 8F);
		steering[7].rotateAngleZ = -0.20943951F;

		steering[8].addShapeBox(-0.8F, 2F, 1.5F, 1, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, -0.5F, 0F, 0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F, 0.5F, 0F, -1.5F, 0.5F); // Box 454
		steering[8].setRotationPoint(6.5F, -2.5F, 8F);
		steering[8].rotateAngleZ = -0.20943951F;

		steering[9].addShapeBox(-0.8F, -3F, 1.5F, 1, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F, 0.5F, 0F, -1.5F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, -0.5F, 0F, 0.5F, -0.5F); // Box 455
		steering[9].setRotationPoint(6.5F, -2.5F, 8F);
		steering[9].rotateAngleZ = -0.20943951F;

		steering[10].addShapeBox(-1F, 0F, -0.5F, 1, 3, 1, 0F,-0.4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, 0F, 0F); // Box 456
		steering[10].setRotationPoint(6.5F, -2.5F, 8F);
		steering[10].rotateAngleX = 2.26892803F;
		steering[10].rotateAngleZ = -0.20943951F;

		steering[11].addShapeBox(-1F, 0F, -0.5F, 1, 3, 1, 0F,-0.4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, 0F, 0F); // Box 457
		steering[11].setRotationPoint(6.5F, -2.5F, 8F);
		steering[11].rotateAngleX = -2.26892803F;
		steering[11].rotateAngleZ = -0.20943951F;

        translateAll(0F, 0F, 0F);
        flipAll();
    }

}
