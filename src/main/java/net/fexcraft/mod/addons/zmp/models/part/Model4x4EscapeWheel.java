package net.fexcraft.mod.addons.zmp.models.part;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.part.PartModelTMT;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.minecraft.entity.Entity;

public class Model4x4EscapeWheel extends PartModelTMT {

    public Model4x4EscapeWheel(){
    	super(); textureX = 512; textureY = 512;
        this.addToCreators("zackyboy18");
        this.addToCreators("FEX___96");
        wheel_front_left = new ModelRendererTurbo[17];
        wheel_front_left[0] = new ModelRendererTurbo(this, 193, 217, textureX, textureY); // Box 555
        wheel_front_left[1] = new ModelRendererTurbo(this, 217, 217, textureX, textureY); // Box 556
        wheel_front_left[2] = new ModelRendererTurbo(this, 241, 217, textureX, textureY); // Box 557
        wheel_front_left[3] = new ModelRendererTurbo(this, 265, 217, textureX, textureY); // Box 558
        wheel_front_left[4] = new ModelRendererTurbo(this, 289, 217, textureX, textureY); // Box 559
        wheel_front_left[5] = new ModelRendererTurbo(this, 313, 217, textureX, textureY); // Box 560
        wheel_front_left[6] = new ModelRendererTurbo(this, 441, 217, textureX, textureY); // Box 561
        wheel_front_left[7] = new ModelRendererTurbo(this, 337, 217, textureX, textureY); // Box 562
        wheel_front_left[8] = new ModelRendererTurbo(this, 489, 217, textureX, textureY); // Box 563
        wheel_front_left[9] = new ModelRendererTurbo(this, 353, 225, textureX, textureY); // Box 564
        wheel_front_left[10] = new ModelRendererTurbo(this, 377, 225, textureX, textureY); // Box 565
        wheel_front_left[11] = new ModelRendererTurbo(this, 17, 145, textureX, textureY); // Box 566
        wheel_front_left[12] = new ModelRendererTurbo(this, 169, 145, textureX, textureY); // Box 567
        wheel_front_left[13] = new ModelRendererTurbo(this, 433, 145, textureX, textureY); // Box 568
        wheel_front_left[14] = new ModelRendererTurbo(this, 209, 145, textureX, textureY); // Box 569
        wheel_front_left[15] = new ModelRendererTurbo(this, 401, 225, textureX, textureY); // Box 570
        wheel_front_left[16] = new ModelRendererTurbo(this, 233, 145, textureX, textureY); // Box 571

        wheel_front_left[0].addShapeBox(-2.5F, -8.5F, -3F, 5, 4, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 555
        wheel_front_left[0].setRotationPoint(38.5F, 12.5F, 16F);

        wheel_front_left[1].addShapeBox(-6.5F, -8.5F, -3F, 4, 4, 6, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, -3F, 1F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -3F, 1F, 0F); // Box 556
        wheel_front_left[1].setRotationPoint(38.5F, 12.5F, 16F);

        wheel_front_left[2].addShapeBox(-8.5F, -6.5F, -3F, 4, 4, 6, 0F, -2F, 0F, 0F, 1F, -3F, 0F, 1F, -3F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F); // Box 557
        wheel_front_left[2].setRotationPoint(38.5F, 12.5F, 16F);

        wheel_front_left[3].addShapeBox(-8.5F, -2.5F, -3F, 4, 5, 6, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 558
        wheel_front_left[3].setRotationPoint(38.5F, 12.5F, 16F);

        wheel_front_left[4].addShapeBox(-8.5F, 2.5F, -3F, 4, 4, 6, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 1F, -3F, 0F, 1F, -3F, 0F, -2F, 0F, 0F); // Box 559
        wheel_front_left[4].setRotationPoint(38.5F, 12.5F, 16F);

        wheel_front_left[5].addShapeBox(-6.5F, 4.5F, -3F, 4, 4, 6, 0F, -3F, 1F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -3F, 1F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 560
        wheel_front_left[5].setRotationPoint(38.5F, 12.5F, 16F);

        wheel_front_left[6].addShapeBox(-2.5F, 4.5F, -3F, 5, 4, 6, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 561
        wheel_front_left[6].setRotationPoint(38.5F, 12.5F, 16F);

        wheel_front_left[7].addShapeBox(2.5F, 4.5F, -3F, 4, 4, 6, 0F, 1F, 0F, 0F, -3F, 1F, 0F, -3F, 1F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F); // Box 562
        wheel_front_left[7].setRotationPoint(38.5F, 12.5F, 16F);

        wheel_front_left[8].addShapeBox(4.5F, -2.5F, -3F, 4, 5, 6, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 563
        wheel_front_left[8].setRotationPoint(38.5F, 12.5F, 16F);

        wheel_front_left[9].addShapeBox(4.5F, -6.5F, -3F, 4, 4, 6, 0F, 1F, -3F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 1F, -3F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F); // Box 564
        wheel_front_left[9].setRotationPoint(38.5F, 12.5F, 16F);

        wheel_front_left[10].addShapeBox(2.5F, -8.5F, -3F, 4, 4, 6, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, -3F, 1F, 0F, -3F, 1F, 0F, 1F, 0F, 0F); // Box 565
        wheel_front_left[10].setRotationPoint(38.5F, 12.5F, 16F);

        wheel_front_left[11].addShapeBox(0F, -1.5F, 1.5F, 6, 3, 1, 0F, 1F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 566
        wheel_front_left[11].setRotationPoint(38.5F, 12.5F, 16F);

        wheel_front_left[12].addShapeBox(-1.5F, -6F, 1.5F, 3, 6, 1, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 567
        wheel_front_left[12].setRotationPoint(38.5F, 12.5F, 16F);

        wheel_front_left[13].addShapeBox(-6F, -1.5F, 1.5F, 6, 3, 1, 0F, 0F, 2F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 2F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 568
        wheel_front_left[13].setRotationPoint(38.5F, 12.5F, 16F);

        wheel_front_left[14].addShapeBox(-1.5F, 0F, 1.5F, 3, 6, 1, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 4F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 4F, 0F, 0F); // Box 569
        wheel_front_left[14].setRotationPoint(38.5F, 12.5F, 16F);

        wheel_front_left[15].addShapeBox(4.5F, 2.5F, -3F, 4, 4, 6, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 1F, -3F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 1F, -3F, 0F); // Box 570
        wheel_front_left[15].setRotationPoint(38.5F, 12.5F, 16F);

        wheel_front_left[16].addShapeBox(-1.5F, 0F, 1.5F, 3, 6, 1, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -5F, 0F, 0F, 4F, 0F, 0F, 4F, 0F, 0F, -5F, 0F, 0F); // Box 571
        wheel_front_left[16].setRotationPoint(38.5F, 12.5F, 16F);

        wheel_front_right = new ModelRendererTurbo[17];
        wheel_front_right[0] = new ModelRendererTurbo(this, 265, 185, textureX, textureY); // Box 500
        wheel_front_right[1] = new ModelRendererTurbo(this, 289, 185, textureX, textureY); // Box 501
        wheel_front_right[2] = new ModelRendererTurbo(this, 313, 185, textureX, textureY); // Box 502
        wheel_front_right[3] = new ModelRendererTurbo(this, 337, 185, textureX, textureY); // Box 503
        wheel_front_right[4] = new ModelRendererTurbo(this, 361, 185, textureX, textureY); // Box 504
        wheel_front_right[5] = new ModelRendererTurbo(this, 473, 185, textureX, textureY); // Box 505
        wheel_front_right[6] = new ModelRendererTurbo(this, 217, 193, textureX, textureY); // Box 506
        wheel_front_right[7] = new ModelRendererTurbo(this, 441, 193, textureX, textureY); // Box 507
        wheel_front_right[8] = new ModelRendererTurbo(this, 489, 193, textureX, textureY); // Box 508
        wheel_front_right[9] = new ModelRendererTurbo(this, 1, 201, textureX, textureY); // Box 509
        wheel_front_right[10] = new ModelRendererTurbo(this, 25, 201, textureX, textureY); // Box 510
        wheel_front_right[11] = new ModelRendererTurbo(this, 49, 201, textureX, textureY); // Box 511
        wheel_front_right[12] = new ModelRendererTurbo(this, 201, 113, textureX, textureY); // Box 512
        wheel_front_right[13] = new ModelRendererTurbo(this, 241, 113, textureX, textureY); // Box 513
        wheel_front_right[14] = new ModelRendererTurbo(this, 489, 129, textureX, textureY); // Box 517
        wheel_front_right[15] = new ModelRendererTurbo(this, 409, 121, textureX, textureY); // Box 518
        wheel_front_right[16] = new ModelRendererTurbo(this, 169, 129, textureX, textureY); // Box 519

        wheel_front_right[0].addShapeBox(-2.5F, -8.5F, -3F, 5, 4, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 500
        wheel_front_right[0].setRotationPoint(38.5F, 12.5F, -16F);

        wheel_front_right[1].addShapeBox(-6.5F, -8.5F, -3F, 4, 4, 6, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, -3F, 1F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -3F, 1F, 0F); // Box 501
        wheel_front_right[1].setRotationPoint(38.5F, 12.5F, -16F);

        wheel_front_right[2].addShapeBox(-8.5F, -6.5F, -3F, 4, 4, 6, 0F, -2F, 0F, 0F, 1F, -3F, 0F, 1F, -3F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F); // Box 502
        wheel_front_right[2].setRotationPoint(38.5F, 12.5F, -16F);

        wheel_front_right[3].addShapeBox(-8.5F, -2.5F, -3F, 4, 5, 6, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 503
        wheel_front_right[3].setRotationPoint(38.5F, 12.5F, -16F);

        wheel_front_right[4].addShapeBox(-8.5F, 2.5F, -3F, 4, 4, 6, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 1F, -3F, 0F, 1F, -3F, 0F, -2F, 0F, 0F); // Box 504
        wheel_front_right[4].setRotationPoint(38.5F, 12.5F, -16F);

        wheel_front_right[5].addShapeBox(-6.5F, 4.5F, -3F, 4, 4, 6, 0F, -3F, 1F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -3F, 1F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 505
        wheel_front_right[5].setRotationPoint(38.5F, 12.5F, -16F);

        wheel_front_right[6].addShapeBox(-2.5F, 4.5F, -3F, 5, 4, 6, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 506
        wheel_front_right[6].setRotationPoint(38.5F, 12.5F, -16F);

        wheel_front_right[7].addShapeBox(2.5F, 4.5F, -3F, 4, 4, 6, 0F, 1F, 0F, 0F, -3F, 1F, 0F, -3F, 1F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F); // Box 507
        wheel_front_right[7].setRotationPoint(38.5F, 12.5F, -16F);

        wheel_front_right[8].addShapeBox(4.5F, 2.5F, -3F, 4, 4, 6, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 1F, -3F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 1F, -3F, 0F); // Box 508
        wheel_front_right[8].setRotationPoint(38.5F, 12.5F, -16F);

        wheel_front_right[9].addShapeBox(4.5F, -2.5F, -3F, 4, 5, 6, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 509
        wheel_front_right[9].setRotationPoint(38.5F, 12.5F, -16F);

        wheel_front_right[10].addShapeBox(4.5F, -6.5F, -3F, 4, 4, 6, 0F, 1F, -3F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 1F, -3F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F); // Box 510
        wheel_front_right[10].setRotationPoint(38.5F, 12.5F, -16F);

        wheel_front_right[11].addShapeBox(2.5F, -8.5F, -3F, 4, 4, 6, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, -3F, 1F, 0F, -3F, 1F, 0F, 1F, 0F, 0F); // Box 511
        wheel_front_right[11].setRotationPoint(38.5F, 12.5F, -16F);

        wheel_front_right[12].addShapeBox(-1.5F, -6F, -2.5F, 3, 6, 1, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 512
        wheel_front_right[12].setRotationPoint(38.5F, 12.5F, -16F);

        wheel_front_right[13].addShapeBox(0F, -1.5F, -2.5F, 6, 3, 1, 0F, 1F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 513
        wheel_front_right[13].setRotationPoint(38.5F, 12.5F, -16F);

        wheel_front_right[14].addShapeBox(-6F, -1.5F, -2.5F, 6, 3, 1, 0F, 0F, 2F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 2F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 517
        wheel_front_right[14].setRotationPoint(38.5F, 12.5F, -16F);

        wheel_front_right[15].addShapeBox(-1.5F, 0F, -2.5F, 3, 6, 1, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 4F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 4F, 0F, 0F); // Box 518
        wheel_front_right[15].setRotationPoint(38.5F, 12.5F, -16F);

        wheel_front_right[16].addShapeBox(-1.5F, 0F, -2.5F, 3, 6, 1, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -5F, 0F, 0F, 4F, 0F, 0F, 4F, 0F, 0F, -5F, 0F, 0F); // Box 519
        wheel_front_right[16].setRotationPoint(38.5F, 12.5F, -16F);

        wheel_back_left = new ModelRendererTurbo[17];
        wheel_back_left[0] = new ModelRendererTurbo(this, 65, 137, textureX, textureY); // Box 581
        wheel_back_left[1] = new ModelRendererTurbo(this, 473, 129, textureX, textureY); // Box 585
        wheel_back_left[2] = new ModelRendererTurbo(this, 401, 137, textureX, textureY); // Box 586
        wheel_back_left[3] = new ModelRendererTurbo(this, 385, 137, textureX, textureY); // Box 587
        wheel_back_left[4] = new ModelRendererTurbo(this, 1, 145, textureX, textureY); // Box 588
        wheel_back_left[5] = new ModelRendererTurbo(this, 377, 209, textureX, textureY); // Box 589
        wheel_back_left[6] = new ModelRendererTurbo(this, 401, 209, textureX, textureY); // Box 590
        wheel_back_left[7] = new ModelRendererTurbo(this, 425, 209, textureX, textureY); // Box 591
        wheel_back_left[8] = new ModelRendererTurbo(this, 473, 209, textureX, textureY); // Box 592
        wheel_back_left[9] = new ModelRendererTurbo(this, 1, 217, textureX, textureY); // Box 593
        wheel_back_left[10] = new ModelRendererTurbo(this, 25, 217, textureX, textureY); // Box 594
        wheel_back_left[11] = new ModelRendererTurbo(this, 49, 217, textureX, textureY); // Box 595
        wheel_back_left[12] = new ModelRendererTurbo(this, 73, 217, textureX, textureY); // Box 596
        wheel_back_left[13] = new ModelRendererTurbo(this, 97, 217, textureX, textureY); // Box 597
        wheel_back_left[14] = new ModelRendererTurbo(this, 121, 217, textureX, textureY); // Box 598
        wheel_back_left[15] = new ModelRendererTurbo(this, 145, 217, textureX, textureY); // Box 599
        wheel_back_left[16] = new ModelRendererTurbo(this, 169, 217, textureX, textureY); // Box 600

        wheel_back_left[0].addShapeBox(0F, -1.5F, 1.5F, 6, 3, 1, 0F, 1F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 581
        wheel_back_left[0].setRotationPoint(-31.5F, 12.5F, 16F);

        wheel_back_left[1].addShapeBox(-1.5F, -6F, 1.5F, 3, 6, 1, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 585
        wheel_back_left[1].setRotationPoint(-31.5F, 12.5F, 16F);

        wheel_back_left[2].addShapeBox(-6F, -1.5F, 1.5F, 6, 3, 1, 0F, 0F, 2F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 2F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 586
        wheel_back_left[2].setRotationPoint(-31.5F, 12.5F, 16F);

        wheel_back_left[3].addShapeBox(-1.5F, 0F, 1.5F, 3, 6, 1, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 4F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 4F, 0F, 0F); // Box 587
        wheel_back_left[3].setRotationPoint(-31.5F, 12.5F, 16F);

        wheel_back_left[4].addShapeBox(-1.5F, 0F, 1.5F, 3, 6, 1, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -5F, 0F, 0F, 4F, 0F, 0F, 4F, 0F, 0F, -5F, 0F, 0F); // Box 588
        wheel_back_left[4].setRotationPoint(-31.5F, 12.5F, 16F);

        wheel_back_left[5].addShapeBox(2.5F, 4.5F, -3F, 4, 4, 6, 0F, 1F, 0F, 0F, -3F, 1F, 0F, -3F, 1F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F); // Box 589
        wheel_back_left[5].setRotationPoint(-31.5F, 12.5F, 16F);

        wheel_back_left[6].addShapeBox(-2.5F, 4.5F, -3F, 5, 4, 6, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 590
        wheel_back_left[6].setRotationPoint(-31.5F, 12.5F, 16F);

        wheel_back_left[7].addShapeBox(-6.5F, 4.5F, -3F, 4, 4, 6, 0F, -3F, 1F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -3F, 1F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 591
        wheel_back_left[7].setRotationPoint(-31.5F, 12.5F, 16F);

        wheel_back_left[8].addShapeBox(-8.5F, 2.5F, -3F, 4, 4, 6, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 1F, -3F, 0F, 1F, -3F, 0F, -2F, 0F, 0F); // Box 592
        wheel_back_left[8].setRotationPoint(-31.5F, 12.5F, 16F);

        wheel_back_left[9].addShapeBox(-8.5F, -2.5F, -3F, 4, 5, 6, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 593
        wheel_back_left[9].setRotationPoint(-31.5F, 12.5F, 16F);

        wheel_back_left[10].addShapeBox(-8.5F, -6.5F, -3F, 4, 4, 6, 0F, -2F, 0F, 0F, 1F, -3F, 0F, 1F, -3F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F); // Box 594
        wheel_back_left[10].setRotationPoint(-31.5F, 12.5F, 16F);

        wheel_back_left[11].addShapeBox(-6.5F, -8.5F, -3F, 4, 4, 6, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, -3F, 1F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -3F, 1F, 0F); // Box 595
        wheel_back_left[11].setRotationPoint(-31.5F, 12.5F, 16F);

        wheel_back_left[12].addShapeBox(-2.5F, -8.5F, -3F, 5, 4, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 596
        wheel_back_left[12].setRotationPoint(-31.5F, 12.5F, 16F);

        wheel_back_left[13].addShapeBox(2.5F, -8.5F, -3F, 4, 4, 6, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, -3F, 1F, 0F, -3F, 1F, 0F, 1F, 0F, 0F); // Box 597
        wheel_back_left[13].setRotationPoint(-31.5F, 12.5F, 16F);

        wheel_back_left[14].addShapeBox(4.5F, -6.5F, -3F, 4, 4, 6, 0F, 1F, -3F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 1F, -3F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F); // Box 598
        wheel_back_left[14].setRotationPoint(-31.5F, 12.5F, 16F);

        wheel_back_left[15].addShapeBox(4.5F, -2.5F, -3F, 4, 5, 6, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 599
        wheel_back_left[15].setRotationPoint(-31.5F, 12.5F, 16F);

        wheel_back_left[16].addShapeBox(4.5F, 2.5F, -3F, 4, 4, 6, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 1F, -3F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 1F, -3F, 0F); // Box 600
        wheel_back_left[16].setRotationPoint(-31.5F, 12.5F, 16F);

        wheel_back_right = new ModelRendererTurbo[17];
        wheel_back_right[0] = new ModelRendererTurbo(this, 497, 97, textureX, textureY); // Box 649
        wheel_back_right[1] = new ModelRendererTurbo(this, 369, 105, textureX, textureY); // Box 650
        wheel_back_right[2] = new ModelRendererTurbo(this, 1, 105, textureX, textureY); // Box 651
        wheel_back_right[3] = new ModelRendererTurbo(this, 121, 113, textureX, textureY); // Box 652
        wheel_back_right[4] = new ModelRendererTurbo(this, 153, 113, textureX, textureY); // Box 653
        wheel_back_right[5] = new ModelRendererTurbo(this, 473, 153, textureX, textureY); // Box 654
        wheel_back_right[6] = new ModelRendererTurbo(this, 89, 137, textureX, textureY); // Box 655
        wheel_back_right[7] = new ModelRendererTurbo(this, 473, 169, textureX, textureY); // Box 656
        wheel_back_right[8] = new ModelRendererTurbo(this, 217, 177, textureX, textureY); // Box 657
        wheel_back_right[9] = new ModelRendererTurbo(this, 409, 177, textureX, textureY); // Box 658
        wheel_back_right[10] = new ModelRendererTurbo(this, 433, 177, textureX, textureY); // Box 659
        wheel_back_right[11] = new ModelRendererTurbo(this, 457, 177, textureX, textureY); // Box 660
        wheel_back_right[12] = new ModelRendererTurbo(this, 489, 177, textureX, textureY); // Box 661
        wheel_back_right[13] = new ModelRendererTurbo(this, 1, 185, textureX, textureY); // Box 662
        wheel_back_right[14] = new ModelRendererTurbo(this, 25, 185, textureX, textureY); // Box 663
        wheel_back_right[15] = new ModelRendererTurbo(this, 49, 185, textureX, textureY); // Box 664
        wheel_back_right[16] = new ModelRendererTurbo(this, 73, 185, textureX, textureY); // Box 665

        wheel_back_right[0].addShapeBox(-1.5F, -6F, -2.5F, 3, 6, 1, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 649
        wheel_back_right[0].setRotationPoint(-31.5F, 12.5F, -16F);

        wheel_back_right[1].addShapeBox(-6F, -1.5F, -2.5F, 6, 3, 1, 0F, 0F, 2F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 2F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 650
        wheel_back_right[1].setRotationPoint(-31.5F, 12.5F, -16F);

        wheel_back_right[2].addShapeBox(-1.5F, 0F, -2.5F, 3, 6, 1, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 4F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 4F, 0F, 0F); // Box 651
        wheel_back_right[2].setRotationPoint(-31.5F, 12.5F, -16F);

        wheel_back_right[3].addShapeBox(-1.5F, 0F, -2.5F, 3, 6, 1, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -5F, 0F, 0F, 4F, 0F, 0F, 4F, 0F, 0F, -5F, 0F, 0F); // Box 652
        wheel_back_right[3].setRotationPoint(-31.5F, 12.5F, -16F);

        wheel_back_right[4].addShapeBox(0F, -1.5F, -2.5F, 6, 3, 1, 0F, 1F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 653
        wheel_back_right[4].setRotationPoint(-31.5F, 12.5F, -16F);

        wheel_back_right[5].addShapeBox(-2.5F, 4.5F, -3F, 5, 4, 6, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 654
        wheel_back_right[5].setRotationPoint(-31.5F, 12.5F, -16F);

        wheel_back_right[6].addShapeBox(-6.5F, 4.5F, -3F, 4, 4, 6, 0F, -3F, 1F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -3F, 1F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 655
        wheel_back_right[6].setRotationPoint(-31.5F, 12.5F, -16F);

        wheel_back_right[7].addShapeBox(-8.5F, 2.5F, -3F, 4, 4, 6, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 1F, -3F, 0F, 1F, -3F, 0F, -2F, 0F, 0F); // Box 656
        wheel_back_right[7].setRotationPoint(-31.5F, 12.5F, -16F);

        wheel_back_right[8].addShapeBox(-8.5F, -2.5F, -3F, 4, 5, 6, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 657
        wheel_back_right[8].setRotationPoint(-31.5F, 12.5F, -16F);

        wheel_back_right[9].addShapeBox(2.5F, 4.5F, -3F, 4, 4, 6, 0F, 1F, 0F, 0F, -3F, 1F, 0F, -3F, 1F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F); // Box 658
        wheel_back_right[9].setRotationPoint(-31.5F, 12.5F, -16F);

        wheel_back_right[10].addShapeBox(4.5F, 2.5F, -3F, 4, 4, 6, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 1F, -3F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 1F, -3F, 0F); // Box 659
        wheel_back_right[10].setRotationPoint(-31.5F, 12.5F, -16F);

        wheel_back_right[11].addShapeBox(4.5F, -2.5F, -3F, 4, 5, 6, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 660
        wheel_back_right[11].setRotationPoint(-31.5F, 12.5F, -16F);

        wheel_back_right[12].addShapeBox(4.5F, -6.5F, -3F, 4, 4, 6, 0F, 1F, -3F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 1F, -3F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F); // Box 661
        wheel_back_right[12].setRotationPoint(-31.5F, 12.5F, -16F);

        wheel_back_right[13].addShapeBox(2.5F, -8.5F, -3F, 4, 4, 6, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, -3F, 1F, 0F, -3F, 1F, 0F, 1F, 0F, 0F); // Box 662
        wheel_back_right[13].setRotationPoint(-31.5F, 12.5F, -16F);

        wheel_back_right[14].addShapeBox(-2.5F, -8.5F, -3F, 5, 4, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 663
        wheel_back_right[14].setRotationPoint(-31.5F, 12.5F, -16F);

        wheel_back_right[15].addShapeBox(-6.5F, -8.5F, -3F, 4, 4, 6, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, -3F, 1F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -3F, 1F, 0F); // Box 664
        wheel_back_right[15].setRotationPoint(-31.5F, 12.5F, -16F);

        wheel_back_right[16].addShapeBox(-8.5F, -6.5F, -3F, 4, 4, 6, 0F, -2F, 0F, 0F, 1F, -3F, 0F, 1F, -3F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F); // Box 665
        wheel_back_right[16].setRotationPoint(-31.5F, 12.5F, -16F);
        //
        translateAll(0F, -12F, 0F);
    }

    @Override
    public void render(VehicleData data, String us){
        super.def_renderWheels4(data, us);
    }

    @Override
    public void render(VehicleData data, String us, Entity vehicle, int meta){
        super.def_renderWheels4(data, us, vehicle);
    }

}
