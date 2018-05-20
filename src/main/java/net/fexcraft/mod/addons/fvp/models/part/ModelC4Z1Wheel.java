//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2017 Minecraft-SMP.de
// Model: C2R2T1 Wheel
// Model Creator: FEX___96
// Created on: 31.03.2017 - 14:38:29
// Last changed on: 31.03.2017 - 14:38:29
package net.fexcraft.mod.addons.fvp.models.part;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.part.PartModel;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.minecraft.entity.Entity;

public class ModelC4Z1Wheel extends PartModel {

    private int textureX = 1024;
    private int textureY = 1024;

    public ModelC4Z1Wheel(){
        this.creators.add("zackyboy18");
        this.creators.add("FEX___96");
        wheel_front_left = new ModelRendererTurbo[20];
        wheel_front_left[0] = new ModelRendererTurbo(this, 1001, 169, textureX, textureY); // Import WBL1
        wheel_front_left[1] = new ModelRendererTurbo(this, 217, 177, textureX, textureY); // Import WBL2
        wheel_front_left[2] = new ModelRendererTurbo(this, 249, 177, textureX, textureY); // Import WBL3
        wheel_front_left[3] = new ModelRendererTurbo(this, 305, 177, textureX, textureY); // Import WBL4
        wheel_front_left[4] = new ModelRendererTurbo(this, 329, 177, textureX, textureY); // Import WBL5
        wheel_front_left[5] = new ModelRendererTurbo(this, 545, 177, textureX, textureY); // Import WBL6
        wheel_front_left[6] = new ModelRendererTurbo(this, 593, 177, textureX, textureY); // Import WBL7
        wheel_front_left[7] = new ModelRendererTurbo(this, 641, 177, textureX, textureY); // Import WBL8
        wheel_front_left[8] = new ModelRendererTurbo(this, 665, 177, textureX, textureY); // Import WBL9
        wheel_front_left[9] = new ModelRendererTurbo(this, 793, 177, textureX, textureY); // Import WBL10
        wheel_front_left[10] = new ModelRendererTurbo(this, 833, 177, textureX, textureY); // Import WBL11
        wheel_front_left[11] = new ModelRendererTurbo(this, 865, 177, textureX, textureY); // Import WBL12
        wheel_front_left[12] = new ModelRendererTurbo(this, 57, 161, textureX, textureY); // Import WBL15
        wheel_front_left[13] = new ModelRendererTurbo(this, 369, 161, textureX, textureY); // Import WBL16
        wheel_front_left[14] = new ModelRendererTurbo(this, 353, 161, textureX, textureY); // Import WBL17
        wheel_front_left[15] = new ModelRendererTurbo(this, 497, 161, textureX, textureY); // Import WBL18
        wheel_front_left[16] = new ModelRendererTurbo(this, 385, 161, textureX, textureY); // Import WBL19
        wheel_front_left[17] = new ModelRendererTurbo(this, 737, 161, textureX, textureY); // Box 333
        wheel_front_left[18] = new ModelRendererTurbo(this, 49, 177, textureX, textureY); // Box 334
        wheel_front_left[19] = new ModelRendererTurbo(this, 81, 177, textureX, textureY); // Box 335

        wheel_front_left[0].addShapeBox(-8.5F, -2.5F, -3F, 4, 5, 6, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Import WBL1
        wheel_front_left[0].setRotationPoint(60F, -1.5F, 20F);

        wheel_front_left[1].addShapeBox(-8.5F, -6.5F, -3F, 4, 4, 6, 0F, -2F, 0F, 0F, 1F, -3F, 0F, 1F, -3F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F); // Import WBL2
        wheel_front_left[1].setRotationPoint(60F, -1.5F, 20F);

        wheel_front_left[2].addShapeBox(-6.5F, -8.5F, -3F, 4, 4, 6, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, -3F, 1F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -3F, 1F, 0F); // Import WBL3
        wheel_front_left[2].setRotationPoint(60F, -1.5F, 20F);

        wheel_front_left[3].addShapeBox(-2.5F, -8.5F, -3F, 5, 4, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Import WBL4
        wheel_front_left[3].setRotationPoint(60F, -1.5F, 20F);

        wheel_front_left[4].addShapeBox(2.5F, -8.5F, -3F, 4, 4, 6, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, -3F, 1F, 0F, -3F, 1F, 0F, 1F, 0F, 0F); // Import WBL5
        wheel_front_left[4].setRotationPoint(60F, -1.5F, 20F);

        wheel_front_left[5].addShapeBox(4.5F, -6.5F, -3F, 4, 4, 6, 0F, 1F, -3F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 1F, -3F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F); // Import WBL6
        wheel_front_left[5].setRotationPoint(60F, -1.5F, 20F);

        wheel_front_left[6].addShapeBox(4.5F, -2.5F, -3F, 4, 5, 6, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Import WBL7
        wheel_front_left[6].setRotationPoint(60F, -1.5F, 20F);

        wheel_front_left[7].addShapeBox(4.5F, 2.5F, -3F, 4, 4, 6, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 1F, -3F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 1F, -3F, 0F); // Import WBL8
        wheel_front_left[7].setRotationPoint(60F, -1.5F, 20F);

        wheel_front_left[8].addShapeBox(2.5F, 4.5F, -3F, 4, 4, 6, 0F, 1F, 0F, 0F, -3F, 1F, 0F, -3F, 1F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F); // Import WBL9
        wheel_front_left[8].setRotationPoint(60F, -1.5F, 20F);

        wheel_front_left[9].addShapeBox(-2.5F, 4.5F, -3F, 5, 4, 6, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Import WBL10
        wheel_front_left[9].setRotationPoint(60F, -1.5F, 20F);

        wheel_front_left[10].addShapeBox(-6.5F, 4.5F, -3F, 4, 4, 6, 0F, -3F, 1F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -3F, 1F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Import WBL11
        wheel_front_left[10].setRotationPoint(60F, -1.5F, 20F);

        wheel_front_left[11].addShapeBox(-8.5F, 2.5F, -3F, 4, 4, 6, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 1F, -3F, 0F, 1F, -3F, 0F, -2F, 0F, 0F); // Import WBL12
        wheel_front_left[11].setRotationPoint(60F, -1.5F, 20F);

        wheel_front_left[12].addShapeBox(-1.5F, -6F, 1.5F, 3, 6, 1, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Import WBL15
        wheel_front_left[12].setRotationPoint(60F, -1.5F, 20F);

        wheel_front_left[13].addShapeBox(-6F, -1.5F, 1.5F, 6, 3, 1, 0F, 0F, 2F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 2F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Import WBL16
        wheel_front_left[13].setRotationPoint(60F, -1.5F, 20F);

        wheel_front_left[14].addShapeBox(-1.5F, 0F, 1.5F, 3, 6, 1, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 4F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 4F, 0F, 0F); // Import WBL17
        wheel_front_left[14].setRotationPoint(60F, -1.5F, 20F);

        wheel_front_left[15].addShapeBox(-1.5F, 0F, 1.5F, 3, 6, 1, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -5F, 0F, 0F, 4F, 0F, 0F, 4F, 0F, 0F, -5F, 0F, 0F); // Import WBL18
        wheel_front_left[15].setRotationPoint(60F, -1.5F, 20F);

        wheel_front_left[16].addShapeBox(0F, -1.5F, 1.5F, 6, 3, 1, 0F, 1F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Import WBL19
        wheel_front_left[16].setRotationPoint(60F, -1.5F, 20F);

        wheel_front_left[17].addShapeBox(-0.5F, -1.5F, 0F, 1, 3, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 333
        wheel_front_left[17].setRotationPoint(60F, -1.5F, 20F);

        wheel_front_left[18].addShapeBox(0.5F, -1.5F, 0F, 1, 3, 3, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 334
        wheel_front_left[18].setRotationPoint(60F, -1.5F, 20F);

        wheel_front_left[19].addShapeBox(-1.5F, -1.5F, 0F, 1, 3, 3, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 335
        wheel_front_left[19].setRotationPoint(60F, -1.5F, 20F);

        wheel_front_right = new ModelRendererTurbo[20];
        wheel_front_right[0] = new ModelRendererTurbo(this, 409, 185, textureX, textureY); // Import WBL1
        wheel_front_right[1] = new ModelRendererTurbo(this, 449, 185, textureX, textureY); // Import WBL2
        wheel_front_right[2] = new ModelRendererTurbo(this, 689, 185, textureX, textureY); // Import WBL3
        wheel_front_right[3] = new ModelRendererTurbo(this, 249, 193, textureX, textureY); // Import WBL4
        wheel_front_right[4] = new ModelRendererTurbo(this, 729, 185, textureX, textureY); // Import WBL5
        wheel_front_right[5] = new ModelRendererTurbo(this, 761, 185, textureX, textureY); // Import WBL6
        wheel_front_right[6] = new ModelRendererTurbo(this, 305, 193, textureX, textureY); // Import WBL7
        wheel_front_right[7] = new ModelRendererTurbo(this, 345, 193, textureX, textureY); // Import WBL8
        wheel_front_right[8] = new ModelRendererTurbo(this, 377, 193, textureX, textureY); // Import WBL9
        wheel_front_right[9] = new ModelRendererTurbo(this, 497, 193, textureX, textureY); // Import WBL10
        wheel_front_right[10] = new ModelRendererTurbo(this, 425, 193, textureX, textureY); // Import WBL11
        wheel_front_right[11] = new ModelRendererTurbo(this, 537, 193, textureX, textureY); // Import WBL12
        wheel_front_right[12] = new ModelRendererTurbo(this, 529, 161, textureX, textureY); // Import WBL15
        wheel_front_right[13] = new ModelRendererTurbo(this, 409, 161, textureX, textureY); // Import WBL16
        wheel_front_right[14] = new ModelRendererTurbo(this, 545, 161, textureX, textureY); // Import WBL17
        wheel_front_right[15] = new ModelRendererTurbo(this, 609, 161, textureX, textureY); // Import WBL18
        wheel_front_right[16] = new ModelRendererTurbo(this, 849, 161, textureX, textureY); // Import WBL19
        wheel_front_right[17] = new ModelRendererTurbo(this, 97, 177, textureX, textureY); // Box 643
        wheel_front_right[18] = new ModelRendererTurbo(this, 113, 177, textureX, textureY); // Box 644
        wheel_front_right[19] = new ModelRendererTurbo(this, 129, 177, textureX, textureY); // Box 645

        wheel_front_right[0].addShapeBox(-8.5F, -2.5F, -3F, 4, 5, 6, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Import WBL1
        wheel_front_right[0].setRotationPoint(60F, -1.5F, -21F);

        wheel_front_right[1].addShapeBox(-8.5F, -6.5F, -3F, 4, 4, 6, 0F, -2F, 0F, 0F, 1F, -3F, 0F, 1F, -3F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F); // Import WBL2
        wheel_front_right[1].setRotationPoint(60F, -1.5F, -21F);

        wheel_front_right[2].addShapeBox(-6.5F, -8.5F, -3F, 4, 4, 6, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, -3F, 1F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -3F, 1F, 0F); // Import WBL3
        wheel_front_right[2].setRotationPoint(60F, -1.5F, -21F);

        wheel_front_right[3].addShapeBox(-2.5F, -8.5F, -3F, 5, 4, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Import WBL4
        wheel_front_right[3].setRotationPoint(60F, -1.5F, -21F);

        wheel_front_right[4].addShapeBox(2.5F, -8.5F, -3F, 4, 4, 6, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, -3F, 1F, 0F, -3F, 1F, 0F, 1F, 0F, 0F); // Import WBL5
        wheel_front_right[4].setRotationPoint(60F, -1.5F, -21F);

        wheel_front_right[5].addShapeBox(4.5F, -6.5F, -3F, 4, 4, 6, 0F, 1F, -3F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 1F, -3F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F); // Import WBL6
        wheel_front_right[5].setRotationPoint(60F, -1.5F, -21F);

        wheel_front_right[6].addShapeBox(4.5F, -2.5F, -3F, 4, 5, 6, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Import WBL7
        wheel_front_right[6].setRotationPoint(60F, -1.5F, -21F);

        wheel_front_right[7].addShapeBox(4.5F, 2.5F, -3F, 4, 4, 6, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 1F, -3F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 1F, -3F, 0F); // Import WBL8
        wheel_front_right[7].setRotationPoint(60F, -1.5F, -21F);

        wheel_front_right[8].addShapeBox(2.5F, 4.5F, -3F, 4, 4, 6, 0F, 1F, 0F, 0F, -3F, 1F, 0F, -3F, 1F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F); // Import WBL9
        wheel_front_right[8].setRotationPoint(60F, -1.5F, -21F);

        wheel_front_right[9].addShapeBox(-2.5F, 4.5F, -3F, 5, 4, 6, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Import WBL10
        wheel_front_right[9].setRotationPoint(60F, -1.5F, -21F);

        wheel_front_right[10].addShapeBox(-6.5F, 4.5F, -3F, 4, 4, 6, 0F, -3F, 1F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -3F, 1F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Import WBL11
        wheel_front_right[10].setRotationPoint(60F, -1.5F, -21F);

        wheel_front_right[11].addShapeBox(-8.5F, 2.5F, -3F, 4, 4, 6, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 1F, -3F, 0F, 1F, -3F, 0F, -2F, 0F, 0F); // Import WBL12
        wheel_front_right[11].setRotationPoint(60F, -1.5F, -21F);

        wheel_front_right[12].addShapeBox(-1.5F, -6F, -2.5F, 3, 6, 1, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Import WBL15
        wheel_front_right[12].setRotationPoint(60F, -1.5F, -21F);

        wheel_front_right[13].addShapeBox(-6F, -1.5F, -2.5F, 6, 3, 1, 0F, 0F, 2F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 2F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Import WBL16
        wheel_front_right[13].setRotationPoint(60F, -1.5F, -21F);

        wheel_front_right[14].addShapeBox(-1.5F, 0F, -2.5F, 3, 6, 1, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 4F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 4F, 0F, 0F); // Import WBL17
        wheel_front_right[14].setRotationPoint(60F, -1.5F, -21F);

        wheel_front_right[15].addShapeBox(-1.5F, 0F, -2.5F, 3, 6, 1, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -5F, 0F, 0F, 4F, 0F, 0F, 4F, 0F, 0F, -5F, 0F, 0F); // Import WBL18
        wheel_front_right[15].setRotationPoint(60F, -1.5F, -21F);

        wheel_front_right[16].addShapeBox(0F, -1.5F, -2.5F, 6, 3, 1, 0F, 1F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Import WBL19
        wheel_front_right[16].setRotationPoint(60F, -1.5F, -21F);

        wheel_front_right[17].addShapeBox(-1.5F, -1.5F, 0F, 1, 3, 3, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 643
        wheel_front_right[17].setRotationPoint(60F, -1.5F, -24F);

        wheel_front_right[18].addShapeBox(-0.5F, -1.5F, 0F, 1, 3, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 644
        wheel_front_right[18].setRotationPoint(60F, -1.5F, -24F);

        wheel_front_right[19].addShapeBox(0.5F, -1.5F, 0F, 1, 3, 3, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 645
        wheel_front_right[19].setRotationPoint(60F, -1.5F, -24F);

        wheel_back_left = new ModelRendererTurbo[20];
        wheel_back_left[0] = new ModelRendererTurbo(this, 169, 201, textureX, textureY); // Box 666
        wheel_back_left[1] = new ModelRendererTurbo(this, 193, 201, textureX, textureY); // Box 667
        wheel_back_left[2] = new ModelRendererTurbo(this, 217, 201, textureX, textureY); // Box 668
        wheel_back_left[3] = new ModelRendererTurbo(this, 449, 201, textureX, textureY); // Box 669
        wheel_back_left[4] = new ModelRendererTurbo(this, 409, 201, textureX, textureY); // Box 670
        wheel_back_left[5] = new ModelRendererTurbo(this, 689, 201, textureX, textureY); // Box 671
        wheel_back_left[6] = new ModelRendererTurbo(this, 969, 201, textureX, textureY); // Box 672
        wheel_back_left[7] = new ModelRendererTurbo(this, 993, 201, textureX, textureY); // Box 673
        wheel_back_left[8] = new ModelRendererTurbo(this, 425, 209, textureX, textureY); // Box 674
        wheel_back_left[9] = new ModelRendererTurbo(this, 497, 209, textureX, textureY); // Box 675
        wheel_back_left[10] = new ModelRendererTurbo(this, 905, 217, textureX, textureY); // Box 676
        wheel_back_left[11] = new ModelRendererTurbo(this, 929, 217, textureX, textureY); // Box 677
        wheel_back_left[12] = new ModelRendererTurbo(this, 129, 185, textureX, textureY); // Box 678
        wheel_back_left[13] = new ModelRendererTurbo(this, 273, 185, textureX, textureY); // Box 679
        wheel_back_left[14] = new ModelRendererTurbo(this, 433, 185, textureX, textureY); // Box 680
        wheel_back_left[15] = new ModelRendererTurbo(this, 713, 169, textureX, textureY); // Box 681
        wheel_back_left[16] = new ModelRendererTurbo(this, 473, 185, textureX, textureY); // Box 682
        wheel_back_left[17] = new ModelRendererTurbo(this, 761, 169, textureX, textureY); // Box 683
        wheel_back_left[18] = new ModelRendererTurbo(this, 617, 185, textureX, textureY); // Box 684
        wheel_back_left[19] = new ModelRendererTurbo(this, 713, 185, textureX, textureY); // Box 685

        wheel_back_left[0].addShapeBox(-8.5F, -2.5F, -3F, 4, 5, 6, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 666
        wheel_back_left[0].setRotationPoint(-63F, -1.5F, 20F);

        wheel_back_left[1].addShapeBox(-8.5F, -6.5F, -3F, 4, 4, 6, 0F, -2F, 0F, 0F, 1F, -3F, 0F, 1F, -3F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F); // Box 667
        wheel_back_left[1].setRotationPoint(-63F, -1.5F, 20F);

        wheel_back_left[2].addShapeBox(-6.5F, -8.5F, -3F, 4, 4, 6, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, -3F, 1F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -3F, 1F, 0F); // Box 668
        wheel_back_left[2].setRotationPoint(-63F, -1.5F, 20F);

        wheel_back_left[3].addShapeBox(-2.5F, -8.5F, -3F, 5, 4, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 669
        wheel_back_left[3].setRotationPoint(-63F, -1.5F, 20F);

        wheel_back_left[4].addShapeBox(2.5F, -8.5F, -3F, 4, 4, 6, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, -3F, 1F, 0F, -3F, 1F, 0F, 1F, 0F, 0F); // Box 670
        wheel_back_left[4].setRotationPoint(-63F, -1.5F, 20F);

        wheel_back_left[5].addShapeBox(4.5F, -6.5F, -3F, 4, 4, 6, 0F, 1F, -3F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 1F, -3F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F); // Box 671
        wheel_back_left[5].setRotationPoint(-63F, -1.5F, 20F);

        wheel_back_left[6].addShapeBox(4.5F, -2.5F, -3F, 4, 5, 6, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 672
        wheel_back_left[6].setRotationPoint(-63F, -1.5F, 20F);

        wheel_back_left[7].addShapeBox(4.5F, 2.5F, -3F, 4, 4, 6, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 1F, -3F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 1F, -3F, 0F); // Box 673
        wheel_back_left[7].setRotationPoint(-63F, -1.5F, 20F);

        wheel_back_left[8].addShapeBox(2.5F, 4.5F, -3F, 4, 4, 6, 0F, 1F, 0F, 0F, -3F, 1F, 0F, -3F, 1F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F); // Box 674
        wheel_back_left[8].setRotationPoint(-63F, -1.5F, 20F);

        wheel_back_left[9].addShapeBox(-2.5F, 4.5F, -3F, 5, 4, 6, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 675
        wheel_back_left[9].setRotationPoint(-63F, -1.5F, 20F);

        wheel_back_left[10].addShapeBox(-6.5F, 4.5F, -3F, 4, 4, 6, 0F, -3F, 1F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -3F, 1F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 676
        wheel_back_left[10].setRotationPoint(-63F, -1.5F, 20F);

        wheel_back_left[11].addShapeBox(-8.5F, 2.5F, -3F, 4, 4, 6, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 1F, -3F, 0F, 1F, -3F, 0F, -2F, 0F, 0F); // Box 677
        wheel_back_left[11].setRotationPoint(-63F, -1.5F, 20F);

        wheel_back_left[12].addShapeBox(0.5F, -1.5F, 0F, 1, 3, 3, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 678
        wheel_back_left[12].setRotationPoint(-63F, -1.5F, 20F);

        wheel_back_left[13].addShapeBox(-0.5F, -1.5F, 0F, 1, 3, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 679
        wheel_back_left[13].setRotationPoint(-63F, -1.5F, 20F);

        wheel_back_left[14].addShapeBox(-1.5F, -1.5F, 0F, 1, 3, 3, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 680
        wheel_back_left[14].setRotationPoint(-63F, -1.5F, 20F);

        wheel_back_left[15].addShapeBox(-6F, -1.5F, 1.5F, 6, 3, 1, 0F, 0F, 2F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 2F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 681
        wheel_back_left[15].setRotationPoint(-63F, -1.5F, 20F);

        wheel_back_left[16].addShapeBox(-1.5F, -6F, 1.5F, 3, 6, 1, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 682
        wheel_back_left[16].setRotationPoint(-63F, -1.5F, 20F);

        wheel_back_left[17].addShapeBox(0F, -1.5F, 1.5F, 6, 3, 1, 0F, 1F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 683
        wheel_back_left[17].setRotationPoint(-63F, -1.5F, 20F);

        wheel_back_left[18].addShapeBox(-1.5F, 0F, 1.5F, 3, 6, 1, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -5F, 0F, 0F, 4F, 0F, 0F, 4F, 0F, 0F, -5F, 0F, 0F); // Box 684
        wheel_back_left[18].setRotationPoint(-63F, -1.5F, 20F);

        wheel_back_left[19].addShapeBox(-1.5F, 0F, 1.5F, 3, 6, 1, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 4F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 4F, 0F, 0F); // Box 685
        wheel_back_left[19].setRotationPoint(-63F, -1.5F, 20F);

        wheel_back_right = new ModelRendererTurbo[20];
        wheel_back_right[0] = new ModelRendererTurbo(this, 145, 177, textureX, textureY); // Box 646
        wheel_back_right[1] = new ModelRendererTurbo(this, 177, 177, textureX, textureY); // Box 647
        wheel_back_right[2] = new ModelRendererTurbo(this, 193, 177, textureX, textureY); // Box 648
        wheel_back_right[3] = new ModelRendererTurbo(this, 273, 177, textureX, textureY); // Box 649
        wheel_back_right[4] = new ModelRendererTurbo(this, 865, 161, textureX, textureY); // Box 650
        wheel_back_right[5] = new ModelRendererTurbo(this, 617, 177, textureX, textureY); // Box 651
        wheel_back_right[6] = new ModelRendererTurbo(this, 817, 177, textureX, textureY); // Box 652
        wheel_back_right[7] = new ModelRendererTurbo(this, 577, 169, textureX, textureY); // Box 653
        wheel_back_right[8] = new ModelRendererTurbo(this, 593, 193, textureX, textureY); // Box 654
        wheel_back_right[9] = new ModelRendererTurbo(this, 569, 193, textureX, textureY); // Box 655
        wheel_back_right[10] = new ModelRendererTurbo(this, 641, 193, textureX, textureY); // Box 656
        wheel_back_right[11] = new ModelRendererTurbo(this, 665, 193, textureX, textureY); // Box 657
        wheel_back_right[12] = new ModelRendererTurbo(this, 793, 193, textureX, textureY); // Box 658
        wheel_back_right[13] = new ModelRendererTurbo(this, 1, 201, textureX, textureY); // Box 659
        wheel_back_right[14] = new ModelRendererTurbo(this, 25, 201, textureX, textureY); // Box 660
        wheel_back_right[15] = new ModelRendererTurbo(this, 49, 201, textureX, textureY); // Box 661
        wheel_back_right[16] = new ModelRendererTurbo(this, 73, 201, textureX, textureY); // Box 662
        wheel_back_right[17] = new ModelRendererTurbo(this, 97, 201, textureX, textureY); // Box 663
        wheel_back_right[18] = new ModelRendererTurbo(this, 121, 201, textureX, textureY); // Box 664
        wheel_back_right[19] = new ModelRendererTurbo(this, 145, 201, textureX, textureY); // Box 665

        wheel_back_right[0].addShapeBox(-0.5F, -1.5F, 0F, 1, 3, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 646
        wheel_back_right[0].setRotationPoint(-63F, -1.5F, -24F);

        wheel_back_right[1].addShapeBox(0.5F, -1.5F, 0F, 1, 3, 3, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 647
        wheel_back_right[1].setRotationPoint(-63F, -1.5F, -24F);

        wheel_back_right[2].addShapeBox(-1.5F, -1.5F, 0F, 1, 3, 3, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 648
        wheel_back_right[2].setRotationPoint(-63F, -1.5F, -24F);

        wheel_back_right[3].addShapeBox(-1.5F, -6F, -2.5F, 3, 6, 1, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 649
        wheel_back_right[3].setRotationPoint(-63F, -1.5F, -21F);

        wheel_back_right[4].addShapeBox(-6F, -1.5F, -2.5F, 6, 3, 1, 0F, 0F, 2F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 2F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 650
        wheel_back_right[4].setRotationPoint(-63F, -1.5F, -21F);

        wheel_back_right[5].addShapeBox(-1.5F, 0F, -2.5F, 3, 6, 1, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 4F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 4F, 0F, 0F); // Box 651
        wheel_back_right[5].setRotationPoint(-63F, -1.5F, -21F);

        wheel_back_right[6].addShapeBox(-1.5F, 0F, -2.5F, 3, 6, 1, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -5F, 0F, 0F, 4F, 0F, 0F, 4F, 0F, 0F, -5F, 0F, 0F); // Box 652
        wheel_back_right[6].setRotationPoint(-63F, -1.5F, -21F);

        wheel_back_right[7].addShapeBox(0F, -1.5F, -2.5F, 6, 3, 1, 0F, 1F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 653
        wheel_back_right[7].setRotationPoint(-63F, -1.5F, -21F);

        wheel_back_right[8].addShapeBox(-2.5F, 4.5F, -3F, 5, 4, 6, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 654
        wheel_back_right[8].setRotationPoint(-63F, -1.5F, -21F);

        wheel_back_right[9].addShapeBox(-6.5F, 4.5F, -3F, 4, 4, 6, 0F, -3F, 1F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -3F, 1F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 655
        wheel_back_right[9].setRotationPoint(-63F, -1.5F, -21F);

        wheel_back_right[10].addShapeBox(-8.5F, 2.5F, -3F, 4, 4, 6, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 1F, -3F, 0F, 1F, -3F, 0F, -2F, 0F, 0F); // Box 656
        wheel_back_right[10].setRotationPoint(-63F, -1.5F, -21F);

        wheel_back_right[11].addShapeBox(-8.5F, -2.5F, -3F, 4, 5, 6, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 657
        wheel_back_right[11].setRotationPoint(-63F, -1.5F, -21F);

        wheel_back_right[12].addShapeBox(2.5F, 4.5F, -3F, 4, 4, 6, 0F, 1F, 0F, 0F, -3F, 1F, 0F, -3F, 1F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F); // Box 658
        wheel_back_right[12].setRotationPoint(-63F, -1.5F, -21F);

        wheel_back_right[13].addShapeBox(4.5F, 2.5F, -3F, 4, 4, 6, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 1F, -3F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 1F, -3F, 0F); // Box 659
        wheel_back_right[13].setRotationPoint(-63F, -1.5F, -21F);

        wheel_back_right[14].addShapeBox(4.5F, -2.5F, -3F, 4, 5, 6, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 660
        wheel_back_right[14].setRotationPoint(-63F, -1.5F, -21F);

        wheel_back_right[15].addShapeBox(4.5F, -6.5F, -3F, 4, 4, 6, 0F, 1F, -3F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 1F, -3F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F); // Box 661
        wheel_back_right[15].setRotationPoint(-63F, -1.5F, -21F);

        wheel_back_right[16].addShapeBox(2.5F, -8.5F, -3F, 4, 4, 6, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, -3F, 1F, 0F, -3F, 1F, 0F, 1F, 0F, 0F); // Box 662
        wheel_back_right[16].setRotationPoint(-63F, -1.5F, -21F);

        wheel_back_right[17].addShapeBox(-2.5F, -8.5F, -3F, 5, 4, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 663
        wheel_back_right[17].setRotationPoint(-63F, -1.5F, -21F);

        wheel_back_right[18].addShapeBox(-6.5F, -8.5F, -3F, 4, 4, 6, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, -3F, 1F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -3F, 1F, 0F); // Box 664
        wheel_back_right[18].setRotationPoint(-63F, -1.5F, -21F);

        wheel_back_right[19].addShapeBox(-8.5F, -6.5F, -3F, 4, 4, 6, 0F, -2F, 0F, 0F, 1F, -3F, 0F, 1F, -3F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F); // Box 665
        wheel_back_right[19].setRotationPoint(-63F, -1.5F, -21F);
    }

    @Override
    public void render(VehicleData data, String us){
        super.def_renderWheels4(data, us);
    }

    @Override
    public void render(VehicleData data, String us, Entity veh){
        super.def_renderWheels4(data, us, veh);
    }

}
