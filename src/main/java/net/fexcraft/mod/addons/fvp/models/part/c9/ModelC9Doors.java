package net.fexcraft.mod.addons.fvp.models.part.c9;

import net.fexcraft.mod.addons.gep.scripts.MultiDoorScript;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.part.PartModelTMT;
import net.fexcraft.mod.fvtm.util.RenderCache;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.entity.Entity;

public class ModelC9Doors extends PartModelTMT {
	
    public ModelRendererTurbo[] front_right;
    public ModelRendererTurbo[] front_left;
    public ModelRendererTurbo[] back_left;
    public ModelRendererTurbo[] back_right;

    public ModelC9Doors(){
    	super(); textureX = 512; textureY = 512;
        this.addToCreators("Ferdinand (FEX___96)");
        //
        front_left = new ModelRendererTurbo[21];
		front_left[0] = new ModelRendererTurbo(this, 65, 209, textureX, textureY); // Box 458
		front_left[1] = new ModelRendererTurbo(this, 409, 209, textureX, textureY); // Box 459
		front_left[2] = new ModelRendererTurbo(this, 217, 201, textureX, textureY); // Box 460
		front_left[3] = new ModelRendererTurbo(this, 121, 217, textureX, textureY); // Box 461
		front_left[4] = new ModelRendererTurbo(this, 465, 209, textureX, textureY); // Box 462
		front_left[5] = new ModelRendererTurbo(this, 353, 217, textureX, textureY); // Box 465
		front_left[6] = new ModelRendererTurbo(this, 441, 145, textureX, textureY); // Box 466
		front_left[7] = new ModelRendererTurbo(this, 33, 153, textureX, textureY); // Box 467
		front_left[8] = new ModelRendererTurbo(this, 89, 153, textureX, textureY); // Box 468
		front_left[9] = new ModelRendererTurbo(this, 177, 153, textureX, textureY); // Box 469
		front_left[10] = new ModelRendererTurbo(this, 473, 153, textureX, textureY); // Box 470
		front_left[11] = new ModelRendererTurbo(this, 105, 161, textureX, textureY); // Box 471
		front_left[12] = new ModelRendererTurbo(this, 105, 153, textureX, textureY); // Box 472
		front_left[13] = new ModelRendererTurbo(this, 289, 161, textureX, textureY); // Box 473
		front_left[14] = new ModelRendererTurbo(this, 401, 217, textureX, textureY); // Box 555
		front_left[15] = new ModelRendererTurbo(this, 193, 209, textureX, textureY); // Box 556
		front_left[16] = new ModelRendererTurbo(this, 217, 209, textureX, textureY); // Box 557
		front_left[17] = new ModelRendererTurbo(this, 225, 209, textureX, textureY); // Box 558
		front_left[18] = new ModelRendererTurbo(this, 169, 225, textureX, textureY); // Box 559
		front_left[19] = new ModelRendererTurbo(this, 241, 209, textureX, textureY); // Box 560
		front_left[20] = new ModelRendererTurbo(this, 345, 209, textureX, textureY); // Box 561

		front_left[0].addShapeBox(-23.5F, 0F, 0F, 23, 5, 3, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.7F, 0F, 0F, -0.7F, 0F, -1.2F, 0F, 0F, -1.2F); // Box 458
		front_left[0].setRotationPoint(17F, 5F, 17.5F);

		front_left[1].addShapeBox(-23.5F, 0F, 0F, 23, 6, 3, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F); // Box 459
		front_left[1].setRotationPoint(17F, -1F, 17.5F);

		front_left[2].addShapeBox(-23.5F, 0F, 0F, 23, 2, 3, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F); // Box 460
		front_left[2].setRotationPoint(17F, -3F, 17.5F);

		front_left[3].addShapeBox(-23.5F, 0F, 0F, 23, 1, 2, 0F, 0F, 0F, 0.2F, 0.5F, 0F, 0.2F, 0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F); // Box 461
		front_left[3].setRotationPoint(17F, -4F, 17.5F);

		front_left[4].addShapeBox(-23.5F, 0F, 0F, 22, 1, 1, 0F, -0.5F, -0.5F, 0.2F, 0F, -0.8F, 0.4F, 0F, -0.8F, -0.2F, 0F, -0.5F, -0.2F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 462
		front_left[4].setRotationPoint(17F, -5F, 17.5F);

		front_left[5].addShapeBox(-23.5F, -2F, 1.8F, 23, 1, 1, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F); // Box 465
		front_left[5].setRotationPoint(17F, 3.9F, 17.5F);
		front_left[5].rotateAngleX = -0.80285146F;

		front_left[6].addShapeBox(-23.7F, -1F, -1.7F, 1, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.6F, 0F, 0F, 0.6F, 0F, 0F, -0.7F, 0F, -1.5F, 0.7F, 0F, -1.5F, 0.2F, 0F, 1.5F, -0.2F, 0F, 1.5F); // Box 466
		front_left[6].setRotationPoint(17F, -7.5F, 17.5F);

		front_left[7].addShapeBox(-23.7F, -1F, -1.7F, 1, 5, 1, 0F, 1F, -0.5F, 3.3F, -1F, -0.5F, 3.3F, -1.6F, -0.5F, -3.3F, 1.6F, -0.5F, -3.3F, 0F, 0F, 0F, 0F, 0F, 0F, -0.6F, 0F, 0F, 0.6F, 0F, 0F); // Box 467
		front_left[7].setRotationPoint(17F, -12.5F, 17.5F);

		front_left[8].addShapeBox(-10F, -1F, -2F, 1, 4, 1, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 2.1F, 0.1F, 0F, -2.1F, 0F, 0F, -5.3F, 0.3F, -2F, 5.3F, 0.3F, -2F, 7.7F, 0.3F, 2F, -7.7F, 0.3F, 2F); // Box 468
		front_left[8].setRotationPoint(17F, -7.3F, 17.5F);

		front_left[9].addShapeBox(-14.3F, -1F, -5F, 1, 5, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, -5F, -0.4F, -3F, 4.4F, -0.4F, -3F, 6.4F, -0.5F, 3F, -6.4F, -0.4F, 3F); // Box 469
		front_left[9].setRotationPoint(17F, -11.9F, 17.5F);

		front_left[10].addShapeBox(-24.5F, -2F, -5F, 5, 1, 1, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0.5F, 0F, -0.8F, 0.5F, 0F, 0.7F, 0F, 0F, 0.7F); // Box 470
		front_left[10].setRotationPoint(17F, -11F, 17.5F);

		front_left[11].addShapeBox(-19F, -2F, -5F, 5, 1, 1, 0F, 0F, 0F, 0F, 0.5F, -0.1F, 0F, 0.5F, -0.1F, -0.1F, 0F, 0F, 0F, 0F, 0F, -0.8F, 1.1F, 0F, -0.6F, 1.1F, 0F, 0.5F, 0F, 0F, 0.7F); // Box 471
		front_left[11].setRotationPoint(17F, -11F, 17.5F);

		front_left[12].addShapeBox(-20.5F, -2F, 0F, 3, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0.4F, 0F, 0.2F, 0.4F, 0F, 0.2F); // Box 472
		front_left[12].setRotationPoint(17F, 0F, 19.5F);

		front_left[13].addShapeBox(-12.5F, -2F, 0F, 3, 1, 1, 0F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 473
		front_left[13].setRotationPoint(17F, 0F, 17F);

		front_left[14].addShapeBox(-4.8F, 0F, 3.5F, 1, 2, 3, 0F, -0.4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, 0F, 0F); // Box 555
		front_left[14].setRotationPoint(17F, -6.5F, 17.5F);
		front_left[14].rotateAngleY = -0.17453293F;

		front_left[15].addShapeBox(-4.9F, 0F, 6.5F, 1, 2, 1, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, -0.5F, -0.5F, -0.3F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, -0.5F, -0.5F, -0.3F, -0.5F); // Box 556
		front_left[15].setRotationPoint(17F, -6.5F, 17.5F);
		front_left[15].rotateAngleY = -0.17453293F;

		front_left[16].addShapeBox(-4.9F, 0F, 2.5F, 1, 2, 1, 0F, -0.5F, -0.3F, -0.5F, 0F, -0.3F, -0.5F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, -0.3F, -0.5F, 0F, -0.3F, -0.5F, 0F, 0F, 0F, -0.5F, 0F, 0F); // Box 557
		front_left[16].setRotationPoint(17F, -6.5F, 17.5F);
		front_left[16].rotateAngleY = -0.17453293F;

		front_left[17].addShapeBox(-3.8F, -5F, -1.5F, 1, 5, 1, 0F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F); // Box 558
		front_left[17].setRotationPoint(17F, -5.5F, 17.5F);
		front_left[17].rotateAngleX = -1.04719755F;
		front_left[17].rotateAngleZ = -0.78539816F;

		front_left[18].addShapeBox(-3.8F, 0F, 3.5F, 1, 2, 3, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F); // Box 559
		front_left[18].setRotationPoint(17F, -6.5F, 17.5F);
		front_left[18].rotateAngleY = -0.17453293F;

		front_left[19].addShapeBox(-3.9F, 0F, 6.5F, 1, 2, 1, 0F, 0F, 0F, 0F, -0.9F, 0F, 0F, -0.4F, -0.5F, -1F, 0F, -0.3F, -0.5F, 0F, 0F, 0F, -0.9F, 0F, 0F, -0.4F, -0.5F, -1F, 0F, -0.3F, -0.5F); // Box 560
		front_left[19].setRotationPoint(17F, -6.5F, 17.5F);
		front_left[19].rotateAngleY = -0.17453293F;

		front_left[20].addShapeBox(-3.9F, 0F, 2.5F, 1, 2, 1, 0F, 0F, -0.3F, -0.5F, -0.4F, -0.5F, -1F, -0.9F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, -0.5F, -0.4F, -0.5F, -1F, -0.9F, 0F, 0F, 0F, 0F, 0F); // Box 561
		front_left[20].setRotationPoint(17F, -6.5F, 17.5F);
		front_left[20].rotateAngleY = -0.17453293F;


		front_right = new ModelRendererTurbo[21];
		front_right[0] = new ModelRendererTurbo(this, 65, 169, textureX, textureY); // Box 474
		front_right[1] = new ModelRendererTurbo(this, 1, 225, textureX, textureY); // Box 475
		front_right[2] = new ModelRendererTurbo(this, 57, 225, textureX, textureY); // Box 476
		front_right[3] = new ModelRendererTurbo(this, 113, 225, textureX, textureY); // Box 477
		front_right[4] = new ModelRendererTurbo(this, 225, 225, textureX, textureY); // Box 478
		front_right[5] = new ModelRendererTurbo(this, 465, 217, textureX, textureY); // Box 479
		front_right[6] = new ModelRendererTurbo(this, 249, 169, textureX, textureY); // Box 480
		front_right[7] = new ModelRendererTurbo(this, 353, 225, textureX, textureY); // Box 481
		front_right[8] = new ModelRendererTurbo(this, 361, 153, textureX, textureY); // Box 482
		front_right[9] = new ModelRendererTurbo(this, 409, 153, textureX, textureY); // Box 483
		front_right[10] = new ModelRendererTurbo(this, 169, 185, textureX, textureY); // Box 484
		front_right[11] = new ModelRendererTurbo(this, 185, 185, textureX, textureY); // Box 485
		front_right[12] = new ModelRendererTurbo(this, 457, 153, textureX, textureY); // Box 486
		front_right[13] = new ModelRendererTurbo(this, 273, 161, textureX, textureY); // Box 487
		front_right[14] = new ModelRendererTurbo(this, 353, 209, textureX, textureY); // Box 562
		front_right[15] = new ModelRendererTurbo(this, 393, 209, textureX, textureY); // Box 563
		front_right[16] = new ModelRendererTurbo(this, 121, 241, textureX, textureY); // Box 564
		front_right[17] = new ModelRendererTurbo(this, 145, 241, textureX, textureY); // Box 565
		front_right[18] = new ModelRendererTurbo(this, 401, 209, textureX, textureY); // Box 566
		front_right[19] = new ModelRendererTurbo(this, 49, 217, textureX, textureY); // Box 567
		front_right[20] = new ModelRendererTurbo(this, 185, 225, textureX, textureY); // Box 568

		front_right[0].addShapeBox(-12.5F, -2F, 0F, 3, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.1F, 0F, 0F, -0.1F); // Box 474
		front_right[0].setRotationPoint(17F, 0F, -18F);

		front_right[1].addShapeBox(-23.5F, 0F, -1F, 23, 6, 3, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F); // Box 475
		front_right[1].setRotationPoint(17F, -1F, -19.5F);

		front_right[2].addShapeBox(-23.5F, 0F, -1F, 23, 5, 3, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.2F, -0.7F, 0F, -1.2F, -0.7F, 0F, 0F, 0F, 0F, 0F); // Box 476
		front_right[2].setRotationPoint(17F, 5F, -19.5F);

		front_right[3].addShapeBox(-23.5F, 0F, -1F, 23, 2, 3, 0F, 0F, 0F, -1F, 0.5F, 0F, -1F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F); // Box 477
		front_right[3].setRotationPoint(17F, -3F, -19.5F);

		front_right[4].addShapeBox(-23.5F, 0F, 0F, 23, 1, 2, 0F, 0F, 0F, -1F, 0.5F, 0F, -1F, 0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F); // Box 478
		front_right[4].setRotationPoint(17F, -4F, -19.5F);

		front_right[5].addShapeBox(-23.5F, 0F, 1F, 22, 1, 1, 0F, 0F, -0.5F, -0.2F, 0F, -0.8F, -0.2F, 0F, -0.8F, 0.4F, -0.5F, -0.5F, 0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.2F, -0.5F, 0F, 0.2F); // Box 479
		front_right[5].setRotationPoint(17F, -5F, -19.5F);

		front_right[6].addShapeBox(-19.5F, -2F, 0F, 3, 1, 1, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0.4F, 0F, 0.2F, 0.4F, 0F, 0.2F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 480
		front_right[6].setRotationPoint(17F, 0F, -20.5F);

		front_right[7].addShapeBox(-23.5F, 0.4F, -0.55F, 23, 1, 1, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F); // Box 481
		front_right[7].setRotationPoint(17F, 3.9F, -19.5F);
		front_right[7].rotateAngleX = -0.78539816F;

		front_right[8].addShapeBox(-10F, -1F, 3F, 1, 4, 1, 0F, -2.1F, 0F, 0F, 2.1F, 0.1F, 0F, 0F, 0F, 0F, -0.7F, 0F, 0F, -7.7F, 0.3F, 2F, 7.7F, 0.3F, 2F, 5.3F, 0.3F, -2F, -5.3F, 0.3F, -2F); // Box 482
		front_right[8].setRotationPoint(17F, -7.3F, -19.5F);

		front_right[9].addShapeBox(-14.3F, -1F, 6F, 1, 5, 1, 0F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F, -6.4F, -0.4F, 3F, 6.4F, -0.5F, 3F, 4.4F, -0.4F, -3F, -5F, -0.4F, -3F); // Box 483
		front_right[9].setRotationPoint(17F, -11.9F, -19.5F);

		front_right[10].addShapeBox(-19F, -2F, 6F, 5, 1, 1, 0F, 0F, 0F, 0F, 0.5F, -0.1F, -0.1F, 0.5F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.7F, 1.1F, 0F, 0.5F, 1.1F, 0F, -0.6F, 0F, 0F, -0.8F); // Box 484
		front_right[10].setRotationPoint(17F, -11F, -19.5F);

		front_right[11].addShapeBox(-24.5F, -2F, 6F, 5, 1, 1, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.7F, 0.5F, 0F, 0.7F, 0.5F, 0F, -0.8F, 0F, 0F, -0.8F); // Box 485
		front_right[11].setRotationPoint(17F, -11F, -19.5F);

		front_right[12].addShapeBox(-23.7F, -1F, 2.7F, 1, 5, 1, 0F, 1.6F, -0.5F, -3.3F, -1.6F, -0.5F, -3.3F, -1F, -0.5F, 3.3F, 1F, -0.5F, 3.3F, 0.6F, 0F, 0F, -0.6F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 486
		front_right[12].setRotationPoint(17F, -12.5F, -19.5F);

		front_right[13].addShapeBox(-23.7F, -1F, 2.7F, 1, 4, 1, 0F, 0.6F, 0F, 0F, -0.6F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 1.5F, 0.2F, 0F, 1.5F, 0.7F, 0F, -1.5F, -0.7F, 0F, -1.5F); // Box 487
		front_right[13].setRotationPoint(17F, -7.5F, -19.5F);

		front_right[14].addShapeBox(-4.4F, 0F, -1.5F, 1, 2, 1, 0F, 0F, 0F, 0F, -0.9F, 0F, 0F, -0.4F, -0.5F, -1F, 0F, -0.3F, -0.5F, 0F, 0F, 0F, -0.9F, 0F, 0F, -0.4F, -0.5F, -1F, 0F, -0.3F, -0.5F); // Box 562
		front_right[14].setRotationPoint(17F, -6.5F, -19.5F);
		front_right[14].rotateAngleY = 0.17453293F;

		front_right[15].addShapeBox(-5.4F, 0F, -1.5F, 1, 2, 1, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, -0.5F, -0.5F, -0.3F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, -0.5F, -0.5F, -0.3F, -0.5F); // Box 563
		front_right[15].setRotationPoint(17F, -6.5F, -19.5F);
		front_right[15].rotateAngleY = 0.17453293F;

		front_right[16].addShapeBox(-5.3F, 0F, -4.5F, 1, 2, 3, 0F, -0.4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, 0F, 0F); // Box 564
		front_right[16].setRotationPoint(17F, -6.5F, -19.5F);
		front_right[16].rotateAngleY = 0.17453293F;

		front_right[17].addShapeBox(-4.3F, 0F, -4.5F, 1, 2, 3, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F); // Box 565
		front_right[17].setRotationPoint(17F, -6.5F, -19.5F);
		front_right[17].rotateAngleY = 0.17453293F;

		front_right[18].addShapeBox(-5.4F, 0F, -5.5F, 1, 2, 1, 0F, -0.5F, -0.3F, -0.5F, 0F, -0.3F, -0.5F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, -0.3F, -0.5F, 0F, -0.3F, -0.5F, 0F, 0F, 0F, -0.5F, 0F, 0F); // Box 566
		front_right[18].setRotationPoint(17F, -6.5F, -19.5F);
		front_right[18].rotateAngleY = 0.17453293F;

		front_right[19].addShapeBox(-4.4F, 0F, -5.5F, 1, 2, 1, 0F, 0F, -0.3F, -0.5F, -0.4F, -0.5F, -1F, -0.9F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, -0.5F, -0.4F, -0.5F, -1F, -0.9F, 0F, 0F, 0F, 0F, 0F); // Box 567
		front_right[19].setRotationPoint(17F, -6.5F, -19.5F);
		front_right[19].rotateAngleY = 0.17453293F;

		front_right[20].addShapeBox(-3.8F, -3.25F, 1.5F, 1, 5, 1, 0F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F); // Box 568
		front_right[20].setRotationPoint(17F, -5.5F, -19.5F);
		front_right[20].rotateAngleX = 1.04719755F;
		front_right[20].rotateAngleZ = -0.78539816F;


		back_left = new ModelRendererTurbo[17];
		back_left[0] = new ModelRendererTurbo(this, 281, 225, textureX, textureY); // Box 489
		back_left[1] = new ModelRendererTurbo(this, 401, 225, textureX, textureY); // Box 490
		back_left[2] = new ModelRendererTurbo(this, 449, 225, textureX, textureY); // Box 491
		back_left[3] = new ModelRendererTurbo(this, 113, 233, textureX, textureY); // Box 492
		back_left[4] = new ModelRendererTurbo(this, 169, 233, textureX, textureY); // Box 493
		back_left[5] = new ModelRendererTurbo(this, 225, 233, textureX, textureY); // Box 494
		back_left[6] = new ModelRendererTurbo(this, 313, 161, textureX, textureY); // Box 495
		back_left[7] = new ModelRendererTurbo(this, 177, 169, textureX, textureY); // Box 496
		back_left[8] = new ModelRendererTurbo(this, 345, 169, textureX, textureY); // Box 497
		back_left[9] = new ModelRendererTurbo(this, 401, 185, textureX, textureY); // Box 498
		back_left[10] = new ModelRendererTurbo(this, 433, 169, textureX, textureY); // Box 499
		back_left[11] = new ModelRendererTurbo(this, 233, 169, textureX, textureY); // Box 500
		back_left[12] = new ModelRendererTurbo(this, 481, 161, textureX, textureY); // Box 501
		back_left[13] = new ModelRendererTurbo(this, 441, 129, textureX, textureY); // Box 502
		back_left[14] = new ModelRendererTurbo(this, 1, 169, textureX, textureY); // Box 503
		back_left[15] = new ModelRendererTurbo(this, 329, 169, textureX, textureY); // Box 504
		back_left[16] = new ModelRendererTurbo(this, 289, 201, textureX, textureY); // Box 509

		back_left[0].addShapeBox(-14.5F, 0F, 0F, 16, 5, 3, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -1.5F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, -1.2F, -1.5F, 0F, -1.2F); // Box 489
		back_left[0].setRotationPoint(-8F, 5F, 17.5F);

		back_left[1].addShapeBox(-17.5F, 0F, 0F, 19, 3, 3, 0F, -0.4F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, -0.4F, 0F, -0.2F, -3F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, -0.4F); // Box 490
		back_left[1].setRotationPoint(-8F, 2F, 17.5F);

		back_left[2].addShapeBox(-20.5F, 0F, 0F, 22, 3, 3, 0F, -0.6F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, -0.6F, 0F, -0.3F, -3.4F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, -3.4F, 0F, -0.2F); // Box 491
		back_left[2].setRotationPoint(-8F, -1F, 17.5F);

		back_left[3].addShapeBox(-20.5F, 0F, 0F, 22, 2, 3, 0F, 0.3F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, -1F, 0.3F, -0.2F, -1F, -0.6F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, -0.6F, 0F, -0.3F); // Box 492
		back_left[3].setRotationPoint(-8F, -3F, 17.5F);

		back_left[4].addShapeBox(-21.5F, 0F, 0F, 23, 1, 2, 0F, -0.4F, -0.7F, 0F, -1F, 0F, 0.2F, 0F, 0F, -1F, -0.4F, -0.7F, -0.3F, -0.7F, 0.2F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, -0.7F, 0.2F, 0F); // Box 493
		back_left[4].setRotationPoint(-8F, -4F, 17.5F);

		back_left[5].addShapeBox(-21.5F, 0F, 0F, 23, 1, 1, 0F, 0.1F, 0F, 0.2F, -1F, -0.5F, 0.2F, 0F, -0.5F, -0.2F, 0.1F, 0F, -0.2F, -0.4F, 0.7F, 0F, -1F, 0F, 0.2F, 0F, 0F, 0F, -0.4F, 0.7F, 0.7F); // Box 494
		back_left[5].setRotationPoint(-8F, -5F, 17.5F);

		back_left[6].addShapeBox(-1F, -1F, -1.7F, 1, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.6F, 0F, 0F, -0.6F, 0F, 0F, -0.5F, 0F, -1.5F, 0.5F, 0F, -1.5F, 1.4F, 0F, 1.5F, -1.4F, 0F, 1.5F); // Box 495
		back_left[6].setRotationPoint(-8F, -7.5F, 17.5F);

		back_left[7].addShapeBox(-2F, -1F, -5F, 1, 5, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.6F, 0F, 0F, -0.6F, 0F, 0F, -1F, -0.5F, -3.3F, 1F, -0.5F, -3.3F, 1.6F, -0.5F, 3.3F, -1.6F, -0.5F, 3.3F); // Box 496
		back_left[7].setRotationPoint(-8F, -12F, 17.5F);

		back_left[8].addShapeBox(-16F, -2F, 1.9F, 3, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0.4F, 0F, 0.2F, 0.4F, 0F, 0.2F); // Box 497
		back_left[8].setRotationPoint(-8F, 0F, 17.5F);

		back_left[9].addShapeBox(-12F, -2F, -5F, 11, 1, 1, 0F, 0F, 0F, 0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.1F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0.7F, 0F, 0F, 0.6F); // Box 498
		back_left[9].setRotationPoint(-8F, -11F, 17.5F);

		back_left[10].addShapeBox(-5.5F, -2F, -0.5F, 3, 1, 1, 0F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 499
		back_left[10].setRotationPoint(-8F, 0F, 17.5F);

		back_left[11].addShapeBox(-12F, -1F, -5F, 1, 5, 1, 0F, 0.4F, 0F, 0F, 0.4F, 0F, 0F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0.4F, -0.5F, -3.3F, 0.4F, -0.5F, -3.3F, 0F, -0.5F, 3.3F, 0F, -0.5F, 3.3F); // Box 500
		back_left[11].setRotationPoint(-8F, -12F, 17.5F);

		back_left[12].addShapeBox(-12F, -1F, -1.7F, 1, 4, 1, 0F, 0.4F, 0F, 0F, 0.4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.4F, -0.25F, -1.5F, 0.4F, -0.25F, -1.5F, 0F, -0.25F, 1.5F, 0F, -0.25F, 1.5F); // Box 501
		back_left[12].setRotationPoint(-8F, -7.5F, 17.5F);

		back_left[13].addShapeBox(-21F, -1F, -0.2F, 1, 2, 1, 0F, 0F, 0F, 0.9F, 0F, 0F, 0.9F, 0F, 0F, -0.9F, 0F, 0F, -0.9F, 0.6F, -0.2F, 0F, 0.6F, -0.2F, 0F, 0.5F, -0.2F, 0F, 0.6F, -0.2F, 0F); // Box 502
		back_left[13].setRotationPoint(-8F, -5.8F, 17.5F);

		back_left[14].addShapeBox(-17.8F, -1F, -2.6F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3.2F, -0.4F, -1.5F, -3.2F, -0.4F, -1.5F, -3.2F, -0.4F, 1.5F, 3.2F, -0.4F, 1.5F); // Box 503
		back_left[14].setRotationPoint(-8F, -8.4F, 17.5F);

		back_left[15].addShapeBox(-13F, -1F, -5.1F, 1, 4, 1, 0F, -1F, 0F, -0.1F, 1F, 0F, -1F, 1F, 0F, 0F, -1F, 0F, 0F, 4.8F, -0.4F, -2.5F, -4.8F, -0.4F, -2.5F, -4.8F, -0.4F, 2.5F, 4.8F, -0.4F, 2.5F); // Box 504
		back_left[15].setRotationPoint(-8F, -12F, 17.5F);

		back_left[16].addShapeBox(-15F, -1.9F, 1.9F, 16, 1, 1, 0F, 0.4F, -0.3F, 0.3F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, -0.2F, -0.3F, -0.3F, -0.2F, 0.3F, 0.3F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, -0.6F, 0.3F, -0.3F); // Box 509
		back_left[16].setRotationPoint(-8F, 3.8F, 17.5F);
		back_left[16].rotateAngleX = -0.78539816F;


		back_right = new ModelRendererTurbo[17];
		back_right[0] = new ModelRendererTurbo(this, 321, 233, textureX, textureY); // Box 510
		back_right[1] = new ModelRendererTurbo(this, 361, 233, textureX, textureY); // Box 511
		back_right[2] = new ModelRendererTurbo(this, 409, 233, textureX, textureY); // Box 512
		back_right[3] = new ModelRendererTurbo(this, 1, 241, textureX, textureY); // Box 513
		back_right[4] = new ModelRendererTurbo(this, 57, 241, textureX, textureY); // Box 514
		back_right[5] = new ModelRendererTurbo(this, 457, 233, textureX, textureY); // Box 515
		back_right[6] = new ModelRendererTurbo(this, 465, 169, textureX, textureY); // Box 516
		back_right[7] = new ModelRendererTurbo(this, 505, 169, textureX, textureY); // Box 517
		back_right[8] = new ModelRendererTurbo(this, 33, 177, textureX, textureY); // Box 518
		back_right[9] = new ModelRendererTurbo(this, 249, 193, textureX, textureY); // Box 519
		back_right[10] = new ModelRendererTurbo(this, 65, 177, textureX, textureY); // Box 520
		back_right[11] = new ModelRendererTurbo(this, 489, 177, textureX, textureY); // Box 521
		back_right[12] = new ModelRendererTurbo(this, 9, 137, textureX, textureY); // Box 522
		back_right[13] = new ModelRendererTurbo(this, 505, 177, textureX, textureY); // Box 523
		back_right[14] = new ModelRendererTurbo(this, 457, 185, textureX, textureY); // Box 524
		back_right[15] = new ModelRendererTurbo(this, 121, 209, textureX, textureY); // Box 525
		back_right[16] = new ModelRendererTurbo(this, 313, 177, textureX, textureY); // Box 527

		back_right[0].addShapeBox(-14.5F, 0F, -1F, 16, 5, 3, 0F, 0F, 0F, -0.4F, 0F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, -1.5F, 0F, -1.2F, 0F, 0F, -1.2F, -0.8F, 0F, 0F, -1.5F, 0F, 0F); // Box 510
		back_right[0].setRotationPoint(-8F, 5F, -19.5F);

		back_right[1].addShapeBox(-17.5F, 0F, -1F, 19, 3, 3, 0F, -0.4F, 0F, -0.2F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.4F, 0F, 0F, -3F, 0F, -0.4F, 0F, 0F, 0F, -0.8F, 0F, 0F, -3F, 0F, 0F); // Box 511
		back_right[1].setRotationPoint(-8F, 2F, -19.5F);

		back_right[2].addShapeBox(-20.5F, 0F, -1F, 22, 3, 3, 0F, -0.6F, 0F, -0.3F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.6F, 0F, 0F, -3.4F, 0F, -0.2F, 0F, 0F, 0F, -0.8F, 0F, 0F, -3.4F, 0F, 0F); // Box 512
		back_right[2].setRotationPoint(-8F, -1F, -19.5F);

		back_right[3].addShapeBox(-20.5F, 0F, -1F, 22, 2, 3, 0F, 0.3F, -0.2F, -1F, 0F, 0F, -1F, -0.8F, 0F, 0F, 0.3F, 0F, 0F, -0.6F, 0F, -0.3F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.6F, 0F, 0F); // Box 513
		back_right[3].setRotationPoint(-8F, -3F, -19.5F);

		back_right[4].addShapeBox(-21.5F, 0F, 0F, 23, 1, 2, 0F, -0.4F, -0.7F, -0.3F, 0F, 0F, -1F, -1F, 0F, 0.2F, -0.4F, -0.7F, 0F, -0.7F, 0.2F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.7F, 0.2F, 0F); // Box 514
		back_right[4].setRotationPoint(-8F, -4F, -19.5F);

		back_right[5].addShapeBox(-21.5F, 0F, 1F, 23, 1, 1, 0F, 0.1F, 0F, -0.2F, 0F, -0.5F, -0.2F, -1F, -0.5F, 0.2F, 0.1F, 0F, 0.2F, -0.4F, 0.7F, 0.7F, 0F, 0F, 0F, -1F, 0F, 0.2F, -0.4F, 0.7F, 0F); // Box 515
		back_right[5].setRotationPoint(-8F, -5F, -19.5F);

		back_right[6].addShapeBox(-1F, -1F, 2.7F, 1, 4, 1, 0F, -0.6F, 0F, 0F, 0.6F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.4F, 0F, 1.5F, 1.4F, 0F, 1.5F, 0.5F, 0F, -1.5F, -0.5F, 0F, -1.5F); // Box 516
		back_right[6].setRotationPoint(-8F, -7.5F, -19.5F);

		back_right[7].addShapeBox(-2F, -1F, 6F, 1, 5, 1, 0F, -0.6F, 0F, 0F, 0.6F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.6F, -0.5F, 3.3F, 1.6F, -0.5F, 3.3F, 1F, -0.5F, -3.3F, -1F, -0.5F, -3.3F); // Box 517
		back_right[7].setRotationPoint(-8F, -12F, -19.5F);

		back_right[8].addShapeBox(-16F, -2F, -0.9F, 3, 1, 1, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0.4F, 0F, 0.2F, 0.4F, 0F, 0.2F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 518
		back_right[8].setRotationPoint(-8F, 0F, -19.5F);

		back_right[9].addShapeBox(-12F, -2F, 6F, 11, 1, 1, 0F, 0F, 0F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0F, 0.6F, 0F, 0F, 0.7F, 0F, 0F, -0.8F, 0F, 0F, -0.8F); // Box 519
		back_right[9].setRotationPoint(-8F, -11F, -19.5F);

		back_right[10].addShapeBox(-12F, -1F, 6F, 1, 5, 1, 0F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0.4F, 0F, 0F, 0.4F, 0F, 0F, 0F, -0.5F, 3.3F, 0F, -0.5F, 3.3F, 0.4F, -0.5F, -3.3F, 0.4F, -0.5F, -3.3F); // Box 520
		back_right[10].setRotationPoint(-8F, -12F, -19.5F);

		back_right[11].addShapeBox(-12F, -1F, 2.7F, 1, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.4F, 0F, 0F, 0.4F, 0F, 0F, 0F, -0.25F, 1.5F, 0F, -0.25F, 1.5F, 0.4F, -0.25F, -1.5F, 0.4F, -0.25F, -1.5F); // Box 521
		back_right[11].setRotationPoint(-8F, -7.5F, -19.5F);

		back_right[12].addShapeBox(-21F, -1F, 1.2F, 1, 2, 1, 0F, 0F, 0F, -0.9F, 0F, 0F, -0.9F, 0F, 0F, 0.9F, 0F, 0F, 0.9F, 0.6F, -0.2F, 0F, 0.5F, -0.2F, 0F, 0.6F, -0.2F, 0F, 0.6F, -0.2F, 0F); // Box 522
		back_right[12].setRotationPoint(-8F, -5.8F, -19.5F);

		back_right[13].addShapeBox(-17.8F, -1F, 3.6F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3.2F, -0.4F, 1.5F, -3.2F, -0.4F, 1.5F, -3.2F, -0.4F, -1.5F, 3.2F, -0.4F, -1.5F); // Box 523
		back_right[13].setRotationPoint(-8F, -8.4F, -19.5F);

		back_right[14].addShapeBox(-13F, -1F, 6.1F, 1, 4, 1, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, -1F, -1F, 0F, -0.1F, 4.8F, -0.4F, 2.5F, -4.8F, -0.4F, 2.5F, -4.8F, -0.4F, -2.5F, 4.8F, -0.4F, -2.5F); // Box 524
		back_right[14].setRotationPoint(-8F, -12F, -19.5F);

		back_right[15].addShapeBox(-15F, 0.5F, -0.5F, 16, 1, 1, 0F, 0.5F, 0.3F, -0.3F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0.3F, 0.3F, 0F, -0.3F, -0.3F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, -0.7F, -0.3F, 0.3F); // Box 525
		back_right[15].setRotationPoint(-8F, 3.8F, -19.5F);
		back_right[15].rotateAngleX = -0.78539816F;

		back_right[16].addShapeBox(-5.5F, -2F, 1.5F, 3, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.1F, 0F, 0F, -0.1F); // Box 527
		back_right[16].setRotationPoint(-8F, 0F, -19.5F);
    }

    @Override
    public void render(VehicleData data, String us){
        data.getPrimaryColor().glColorApply();
        render(this.front_left); render(this.front_right); render(this.back_left); render(this.back_right);
        RGB.glColorReset();
    }

    @Override
    public void render(VehicleData data, String us, Entity ent, int meta){
    	float[] arr = get(data, us, ent, meta);
    	for(int i = 0; i < arr.length; i++){
    		arr[i] = arr[i] * Static.rad1;
    	}
        data.getPrimaryColor().glColorApply();
        rotate(this.front_left, 0, arr[0], 0);
        render(this.front_left);
        rotate(this.front_left, 0, -arr[0], 0);
        //
        rotate(this.front_right, 0, -arr[1], 0);
        render(this.front_right);
        rotate(this.front_right, 0, arr[1], 0);
        //
        rotate(this.back_left, 0, arr[2], 0);
        render(this.back_left);
        rotate(this.back_left, 0, -arr[2], 0);
        //
        rotate(this.back_right, 0, -arr[3], 0);
        render(this.back_right);
        rotate(this.back_right, 0, arr[3], 0);
        RGB.glColorReset();
    }

	private float[] get(VehicleData data, String us, Entity ent, int meta){
		if(ent  == null){
			return new float[]{
				data.doorsOpen() ? 45 : 0, data.doorsOpen() ? 45 : 0,
				data.doorsOpen() ? 45 : 0, data.doorsOpen() ? 45 : 0,	
			};
		}
        MultiDoorScript script = data.getScript(MultiDoorScript.class);
        if(script == null){
    		return new float[]{
    			get(ent, data.doorsOpen(), "c9_door_front_left"), get(ent, data.doorsOpen(), "c9_door_front_right"),
    			get(ent, data.doorsOpen(), "c9_door_back_left"), get(ent, data.doorsOpen(), "c9_door_back_right")
    		};
        }
		return new float[]{
			get(ent, script.front_left, "c9_door_front_left"),
			get(ent, script.front_right, "c9_door_front_right"),
			get(ent, script.back_left, "c9_door_back_left"),
			get(ent, script.back_right, "c9_door_back_right")
		};
	}

	private float get(Entity ent, boolean bool, String string){
    	float state = RenderCache.getData(ent, string, 0) + (bool ? 1 : -1);
    	return RenderCache.updateData(ent, string, state = state > 45 ? 45 : state < 0 ? 0 : state);
	}

}
