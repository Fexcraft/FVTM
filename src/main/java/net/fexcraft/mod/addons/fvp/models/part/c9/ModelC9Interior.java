package net.fexcraft.mod.addons.fvp.models.part.c9;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.part.PartModel;

public class ModelC9Interior extends PartModel {

    public ModelC9Interior(){
    	super(); textureX = 512; textureY = 512;
        this.addToCreators("01e4af9b-2a30-471e-addf-f6338ffce04b");
        ModelRendererTurbo[] body = new ModelRendererTurbo[30];
		body[0] = new ModelRendererTurbo(this, 393, 153, textureX, textureY); // Box 374
		body[1] = new ModelRendererTurbo(this, 249, 161, textureX, textureY); // Box 376
		body[2] = new ModelRendererTurbo(this, 1, 169, textureX, textureY); // Box 379
		body[3] = new ModelRendererTurbo(this, 73, 169, textureX, textureY); // Box 380
		body[4] = new ModelRendererTurbo(this, 289, 193, textureX, textureY); // Box 526
		body[5] = new ModelRendererTurbo(this, 185, 201, textureX, textureY); // Box 527
		body[6] = new ModelRendererTurbo(this, 345, 201, textureX, textureY); // Box 528
		body[7] = new ModelRendererTurbo(this, 481, 193, textureX, textureY); // Box 529
		body[8] = new ModelRendererTurbo(this, 25, 129, textureX, textureY); // Box 530
		body[9] = new ModelRendererTurbo(this, 297, 1, textureX, textureY); // Box 531
		body[10] = new ModelRendererTurbo(this, 225, 209, textureX, textureY); // Box 532
		body[11] = new ModelRendererTurbo(this, 385, 41, textureX, textureY); // Box 533
		body[12] = new ModelRendererTurbo(this, 177, 177, textureX, textureY); // Box 534
		body[13] = new ModelRendererTurbo(this, 433, 177, textureX, textureY); // Box 535
		body[14] = new ModelRendererTurbo(this, 33, 185, textureX, textureY); // Box 536
		body[15] = new ModelRendererTurbo(this, 89, 185, textureX, textureY); // Box 537
		body[16] = new ModelRendererTurbo(this, 217, 185, textureX, textureY); // Box 538
		body[17] = new ModelRendererTurbo(this, 249, 185, textureX, textureY); // Box 539
		body[18] = new ModelRendererTurbo(this, 273, 201, textureX, textureY); // Box 540
		body[19] = new ModelRendererTurbo(this, 393, 201, textureX, textureY); // Box 541
		body[20] = new ModelRendererTurbo(this, 433, 201, textureX, textureY); // Box 542
		body[21] = new ModelRendererTurbo(this, 321, 201, textureX, textureY); // Box 543
		body[22] = new ModelRendererTurbo(this, 489, 201, textureX, textureY); // Box 544
		body[23] = new ModelRendererTurbo(this, 497, 201, textureX, textureY); // Box 545
		body[24] = new ModelRendererTurbo(this, 505, 201, textureX, textureY); // Box 546
		body[25] = new ModelRendererTurbo(this, 441, 201, textureX, textureY); // Box 547
		body[26] = new ModelRendererTurbo(this, 481, 201, textureX, textureY); // Box 548
		body[27] = new ModelRendererTurbo(this, 41, 73, textureX, textureY); // Box 549
		body[28] = new ModelRendererTurbo(this, 153, 105, textureX, textureY); // Box 550
		body[29] = new ModelRendererTurbo(this, 177, 217, textureX, textureY); // Box 551

		body[0].addShapeBox(0F, 0F, -0.5F, 1, 2, 12, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 374
		body[0].setRotationPoint(9F, -4F, 2.5F);

		body[1].addShapeBox(0F, 0F, -0.5F, 4, 1, 12, 0F, 0F, 0.5F, -1F, 0F, -0.6F, -1F, 0F, -0.6F, -1F, 0F, 0.5F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 376
		body[1].setRotationPoint(9F, -5F, 2.5F);

		body[2].addShapeBox(0F, 0F, 0F, 29, 2, 5, 0F, 0F, -0.3F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, 0F, -0.3F, -0.2F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F); // Box 379
		body[2].setRotationPoint(-11F, 8F, -2.5F);

		body[3].addShapeBox(0F, 0F, 0F, 7, 9, 5, 0F, 0F, 0F, -0.3F, 0F, 0F, 0.4F, 0F, 0F, 0.4F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.3F); // Box 380
		body[3].setRotationPoint(13F, 0F, -2.5F);
		body[3].rotateAngleZ = -0.29670597F;

		body[4].addShapeBox(0F, 0F, 0F, 7, 2, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0.5F); // Box 526
		body[4].setRotationPoint(-2F, 7F, -1.5F);

		body[5].addBox(0F, 0F, 0F, 6, 1, 1, 0F); // Box 527
		body[5].setRotationPoint(-1.5F, 6.5F, -0.5F);
		body[5].rotateAngleZ = 0.12217305F;

		body[6].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F); // Box 528
		body[6].setRotationPoint(7F, 7F, -2F);

		body[7].addShapeBox(0F, -4F, 0F, 1, 4, 1, 0F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 529
		body[7].setRotationPoint(8F, 8F, -0.5F);
		body[7].rotateAngleZ = 0.08726646F;

		body[8].addBox(0F, -5F, 0F, 1, 1, 1, 0F); // Box 530
		body[8].setRotationPoint(8F, 8F, -0.5F);
		body[8].rotateAngleZ = 0.08726646F;

		body[9].addShapeBox(0F, 0F, 0F, 1, 3, 4, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F); // Box 531
		body[9].setRotationPoint(9.2F, -3.5F, -2F);

		body[10].addShapeBox(0F, 0F, 0F, 3, 4, 8, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F); // Box 532
		body[10].setRotationPoint(9F, -3.5F, -13F);

		body[11].addShapeBox(0F, -1F, 0F, 1, 1, 3, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F); // Box 533
		body[11].setRotationPoint(9.1F, -2.5F, -1.5F);

		body[12].addShapeBox(0F, -1F, 0F, 1, 1, 1, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F); // Box 534
		body[12].setRotationPoint(9.1F, -0.5F, -1.5F);

		body[13].addShapeBox(0F, -1F, 0F, 1, 1, 1, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F); // Box 535
		body[13].setRotationPoint(9.1F, -0.5F, -0.5F);

		body[14].addShapeBox(0F, -1F, 0F, 1, 1, 1, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F); // Box 536
		body[14].setRotationPoint(9.1F, -0.5F, 0.5F);

		body[15].addShapeBox(0F, -1F, 0F, 1, 1, 1, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F); // Box 537
		body[15].setRotationPoint(9.1F, -1F, 0.5F);

		body[16].addShapeBox(0F, -1F, 0F, 1, 1, 1, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F); // Box 538
		body[16].setRotationPoint(9.1F, -1F, -0.5F);

		body[17].addShapeBox(0F, -1F, 0F, 1, 1, 1, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F); // Box 539
		body[17].setRotationPoint(9.1F, -1F, -1.5F);

		body[18].addShapeBox(0F, -1F, 0F, 1, 1, 1, 0F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F); // Box 540
		body[18].setRotationPoint(9.1F, -1.75F, -1.75F);

		body[19].addShapeBox(0F, -1F, 0F, 1, 1, 1, 0F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F); // Box 541
		body[19].setRotationPoint(9.1F, -1.75F, 0.75F);

		body[20].addShapeBox(0F, -1F, 0F, 1, 1, 2, 0F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F); // Box 542
		body[20].setRotationPoint(9.1F, -1.75F, -1F);

		body[21].addShapeBox(0F, 0F, 0F, 1, 6, 4, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F); // Box 543
		body[21].setRotationPoint(10.2F, -0.5F, -2F);
		body[21].rotateAngleZ = 0.2443461F;

		body[22].addShapeBox(0F, -1F, -1F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 544
		body[22].setRotationPoint(8.9F, -4F, 5.5F);

		body[23].addShapeBox(0F, -1F, -1F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 545
		body[23].setRotationPoint(8.9F, -4F, 8F);

		body[24].addShapeBox(0F, -1F, -1F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 546
		body[24].setRotationPoint(8.9F, -4F, 10.5F);

		body[25].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 547
		body[25].setRotationPoint(8.9F, -4F, 12F);

		body[26].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 548
		body[26].setRotationPoint(8.9F, -4F, 3F);

		body[27].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 549
		body[27].setRotationPoint(9.1F, -2.5F, 2.5F);

		body[28].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 550
		body[28].setRotationPoint(9.1F, -2.5F, 10.5F);

		body[29].addShapeBox(0F, -1F, 0F, 1, 1, 3, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F); // Box 551
		body[29].setRotationPoint(8.8F, -2F, -10.5F);
		this.add("body", body);
        translateAll(0F, 0F, 0F);
        flipAll();
    }

}
