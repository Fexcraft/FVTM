package net.fexcraft.mod.addons.fvp.models.part.c9;

import net.fexcraft.mod.fvtm.model.part.PartModel;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelC9Seats extends PartModel {

    public ModelC9Seats(){
    	super(); textureX = 512; textureY = 512;
        this.addToCreators("01e4af9b-2a30-471e-addf-f6338ffce04b");
		body = new ModelRendererTurbo[13];
		body[0] = new ModelRendererTurbo(this, 65, 169, textureX, textureY); // Box 381
		body[1] = new ModelRendererTurbo(this, 249, 177, textureX, textureY); // Box 427
		body[2] = new ModelRendererTurbo(this, 393, 193, textureX, textureY); // Box 428
		body[3] = new ModelRendererTurbo(this, 441, 193, textureX, textureY); // Box 429
		body[4] = new ModelRendererTurbo(this, 145, 201, textureX, textureY); // Box 430
		body[5] = new ModelRendererTurbo(this, 1, 177, textureX, textureY); // Box 431
		body[6] = new ModelRendererTurbo(this, 393, 169, textureX, textureY); // Box 432
		body[7] = new ModelRendererTurbo(this, 49, 193, textureX, textureY); // Box 433
		body[8] = new ModelRendererTurbo(this, 409, 169, textureX, textureY); // Box 434
		body[9] = new ModelRendererTurbo(this, 193, 201, textureX, textureY); // Box 442
		body[10] = new ModelRendererTurbo(this, 321, 201, textureX, textureY); // Box 443
		body[11] = new ModelRendererTurbo(this, 353, 201, textureX, textureY); // Box 444
		body[12] = new ModelRendererTurbo(this, 9, 209, textureX, textureY); // Box 445

		body[0].addShapeBox(0F, 0F, 0F, 11, 4, 34, 0F, 0F, 0F, 0.4F, -0.3F, 0F, -0.4F, -0.3F, 0F, -0.4F, 0F, 0F, 0.4F, 0F, 0F, 0.6F, 0.4F, 0F, 0F, 0.4F, 0F, 0F, 0F, 0F, 0.6F); // Box 381
		body[0].setRotationPoint(-21.5F, 7.8F, -17F);

		body[1].addShapeBox(0F, 0F, 0F, 3, 15, 32, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -5F, 0F, 2F, 4F, 0F, 0F, 4F, 0F, 0F, -5F, 0F, 2F); // Box 427
		body[1].setRotationPoint(-27F, -6.6F, -16F);

		body[2].addShapeBox(0F, 0F, 0F, 11, 1, 12, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 428
		body[2].setRotationPoint(-37F, -6.5F, -6F);

		body[3].addShapeBox(0F, 0F, 0F, 11, 1, 11, 0F, -0.8F, -0.85F, -0.5F, 0F, -0.2F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, -0.9F, 0.8F, 0F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 429
		body[3].setRotationPoint(-37F, -6.5F, -17F);

		body[4].addShapeBox(0F, 0F, 0F, 11, 1, 11, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.5F, -0.8F, -0.85F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.9F, 0.8F, 0F); // Box 430
		body[4].setRotationPoint(-37F, -6.5F, 6F);

		body[5].addShapeBox(0F, 0F, 0F, 2, 17, 2, 0F, 7.5F, 0F, 0F, 0F, 0F, 0F, -1.5F, -0.5F, -1F, 2F, -0.1F, -0.5F, 1F, -9.5F, 0F, 5F, 0F, 0F, 4F, 0F, 1F, 0F, -8F, 0F); // Box 431
		body[5].setRotationPoint(-27F, -6.6F, 16F);

		body[6].addShapeBox(0F, 0F, 0F, 3, 9, 1, 0F, -0.4F, 0.5F, -0.5F, 0F, 0F, 0F, -1.2F, -6.2F, 0.8F, 0.1F, -1.1F, 0.3F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 432
		body[6].setRotationPoint(-29.5F, -6.1F, 17F);

		body[7].addShapeBox(0F, 0F, 0F, 2, 17, 2, 0F, 2F, -0.1F, -0.5F, -1.5F, -0.5F, -1F, 0F, 0F, 0F, 7.5F, 0F, 0F, 0F, -8F, 0F, 4F, 0F, 1F, 5F, 0F, 0F, 1F, -9.5F, 0F); // Box 433
		body[7].setRotationPoint(-27F, -6.6F, -18F);

		body[8].addShapeBox(0F, 0F, 0F, 3, 9, 1, 0F, 0.1F, -1.1F, 0.3F, -1.2F, -6.2F, 0.8F, 0F, 0F, 0F, -0.4F, 0.5F, -0.5F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 434
		body[8].setRotationPoint(-29.5F, -6.1F, -18F);

		body[9].addShapeBox(0F, 0F, 0F, 3, 15, 12, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F); // Box 442
		body[9].setRotationPoint(-7.5F, -6F, -15.5F);

		body[10].addShapeBox(0F, 0F, 0F, 3, 15, 12, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F); // Box 443
		body[10].setRotationPoint(-7.5F, -6F, 3.5F);

		body[11].addShapeBox(0F, 0F, 0F, 12, 3, 12, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 444
		body[11].setRotationPoint(-4.5F, 7.8F, -15.5F);

		body[12].addShapeBox(0F, 0F, 0F, 12, 3, 12, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 445
		body[12].setRotationPoint(-4.5F, 7.8F, 3.5F);

        translateAll(0F, 0F, 0F);
        flipAll();
    }

}
