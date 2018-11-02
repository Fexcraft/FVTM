//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2016 Minecraft-SMP.de
// This file is for Fex's Vehicle Mod
// Model: OT1
// Model Creator: FEX___96
// Created on: 25.02.2016 - 16:09:52
// Last changed on: 25.02.2016 - 16:09:52
package net.fexcraft.mod.addons.fvp.models.part;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.part.PartModel;
import net.minecraft.entity.Entity;

public class ModelOT1FW extends PartModel {

    public ModelOT1FW(){
    	super(); textureX = 512; textureY = 512;
        addToCreators("Ferdinand (FEX___96)");
        ModelRendererTurbo[] wheel_front_left = new ModelRendererTurbo[51];
        wheel_front_left[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 01
        wheel_front_left[1] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 02
        wheel_front_left[2] = new ModelRendererTurbo(this, 49, 1, textureX, textureY); // Box 03
        wheel_front_left[3] = new ModelRendererTurbo(this, 65, 1, textureX, textureY); // Box 04
        wheel_front_left[4] = new ModelRendererTurbo(this, 81, 1, textureX, textureY); // Box 05
        wheel_front_left[5] = new ModelRendererTurbo(this, 97, 1, textureX, textureY); // Box 06
        wheel_front_left[6] = new ModelRendererTurbo(this, 113, 1, textureX, textureY); // Box 07
        wheel_front_left[7] = new ModelRendererTurbo(this, 121, 1, textureX, textureY); // Box 08
        wheel_front_left[8] = new ModelRendererTurbo(this, 137, 1, textureX, textureY); // Box 09
        wheel_front_left[9] = new ModelRendererTurbo(this, 153, 1, textureX, textureY); // Box 10
        wheel_front_left[10] = new ModelRendererTurbo(this, 169, 1, textureX, textureY); // Box 11
        wheel_front_left[11] = new ModelRendererTurbo(this, 177, 1, textureX, textureY); // Box 12
        wheel_front_left[12] = new ModelRendererTurbo(this, 193, 1, textureX, textureY); // Box 13
        wheel_front_left[13] = new ModelRendererTurbo(this, 209, 1, textureX, textureY); // Box 14
        wheel_front_left[14] = new ModelRendererTurbo(this, 225, 1, textureX, textureY); // Box 15
        wheel_front_left[15] = new ModelRendererTurbo(this, 241, 1, textureX, textureY); // Box 16
        wheel_front_left[16] = new ModelRendererTurbo(this, 257, 1, textureX, textureY); // Box 17
        wheel_front_left[17] = new ModelRendererTurbo(this, 273, 1, textureX, textureY); // Box 18
        wheel_front_left[18] = new ModelRendererTurbo(this, 281, 1, textureX, textureY); // Box 19
        wheel_front_left[19] = new ModelRendererTurbo(this, 289, 1, textureX, textureY); // Box 20
        wheel_front_left[20] = new ModelRendererTurbo(this, 313, 1, textureX, textureY); // Box 21
        wheel_front_left[21] = new ModelRendererTurbo(this, 337, 1, textureX, textureY); // Box 22
        wheel_front_left[22] = new ModelRendererTurbo(this, 353, 1, textureX, textureY); // Box 23
        wheel_front_left[23] = new ModelRendererTurbo(this, 369, 1, textureX, textureY); // Box 24
        wheel_front_left[24] = new ModelRendererTurbo(this, 385, 1, textureX, textureY); // Box 25
        wheel_front_left[25] = new ModelRendererTurbo(this, 401, 1, textureX, textureY); // Box 26
        wheel_front_left[26] = new ModelRendererTurbo(this, 417, 1, textureX, textureY); // Box 27
        wheel_front_left[27] = new ModelRendererTurbo(this, 433, 1, textureX, textureY); // Box 28
        wheel_front_left[28] = new ModelRendererTurbo(this, 449, 1, textureX, textureY); // Box 29
        wheel_front_left[29] = new ModelRendererTurbo(this, 465, 1, textureX, textureY); // Box 30
        wheel_front_left[30] = new ModelRendererTurbo(this, 481, 1, textureX, textureY); // Box 31
        wheel_front_left[31] = new ModelRendererTurbo(this, 497, 1, textureX, textureY); // Box 32
        wheel_front_left[32] = new ModelRendererTurbo(this, 17, 9, textureX, textureY); // Box 33
        wheel_front_left[33] = new ModelRendererTurbo(this, 49, 9, textureX, textureY); // Box 34
        wheel_front_left[34] = new ModelRendererTurbo(this, 65, 9, textureX, textureY); // Box 35
        wheel_front_left[35] = new ModelRendererTurbo(this, 281, 193, textureX, textureY); // Box 334
        wheel_front_left[36] = new ModelRendererTurbo(this, 169, 185, textureX, textureY); // Box 335
        wheel_front_left[37] = new ModelRendererTurbo(this, 185, 185, textureX, textureY); // Box 336
        wheel_front_left[38] = new ModelRendererTurbo(this, 17, 193, textureX, textureY); // Box 337
        wheel_front_left[39] = new ModelRendererTurbo(this, 257, 193, textureX, textureY); // Box 338
        wheel_front_left[40] = new ModelRendererTurbo(this, 297, 193, textureX, textureY); // Box 339
        wheel_front_left[41] = new ModelRendererTurbo(this, 313, 193, textureX, textureY); // Box 340
        wheel_front_left[42] = new ModelRendererTurbo(this, 113, 65, textureX, textureY); // Box 348
        wheel_front_left[43] = new ModelRendererTurbo(this, 161, 65, textureX, textureY); // Box 349
        wheel_front_left[44] = new ModelRendererTurbo(this, 169, 65, textureX, textureY); // Box 350
        wheel_front_left[45] = new ModelRendererTurbo(this, 193, 65, textureX, textureY); // Box 351
        wheel_front_left[46] = new ModelRendererTurbo(this, 289, 73, textureX, textureY); // Box 352
        wheel_front_left[47] = new ModelRendererTurbo(this, 321, 73, textureX, textureY); // Box 353
        wheel_front_left[48] = new ModelRendererTurbo(this, 1, 81, textureX, textureY); // Box 354
        wheel_front_left[49] = new ModelRendererTurbo(this, 49, 81, textureX, textureY); // Box 355
        wheel_front_left[50] = new ModelRendererTurbo(this, 345, 201, textureX, textureY); // Box 364

        wheel_front_left[0].addBox(-2F, -8F, 0F, 4, 16, 1, 0F); // Box 01
        wheel_front_left[0].setRotationPoint(65F, 0F, 18F);

        wheel_front_left[1].addBox(-8F, -2F, 0F, 6, 4, 1, 0F); // Box 02
        wheel_front_left[1].setRotationPoint(65F, 0F, 18F);

        wheel_front_left[2].addBox(2F, -2F, 0F, 6, 4, 1, 0F); // Box 03
        wheel_front_left[2].setRotationPoint(65F, 0F, 18F);

        wheel_front_left[3].addShapeBox(-8F, 2F, 0F, 3, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F); // Box 04
        wheel_front_left[3].setRotationPoint(65F, 0F, 18F);

        wheel_front_left[4].addShapeBox(-5F, 5F, 0F, 3, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 05
        wheel_front_left[4].setRotationPoint(65F, 0F, 18F);

        wheel_front_left[5].addBox(-5F, 2F, 0F, 3, 3, 1, 0F); // Box 06
        wheel_front_left[5].setRotationPoint(65F, 0F, 18F);

        wheel_front_left[6].addShapeBox(-6F, 5F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 07
        wheel_front_left[6].setRotationPoint(65F, 0F, 18F);

        wheel_front_left[7].addBox(-5F, -5F, 0F, 3, 3, 1, 0F); // Box 08
        wheel_front_left[7].setRotationPoint(65F, 0F, 18F);

        wheel_front_left[8].addShapeBox(-8F, -5F, 0F, 3, 3, 1, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 09
        wheel_front_left[8].setRotationPoint(65F, 0F, 18F);

        wheel_front_left[9].addShapeBox(-5F, -8F, 0F, 3, 3, 1, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 10
        wheel_front_left[9].setRotationPoint(65F, 0F, 18F);

        wheel_front_left[10].addShapeBox(-6F, -6F, 0F, 1, 1, 1, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 11
        wheel_front_left[10].setRotationPoint(65F, 0F, 18F);

        wheel_front_left[11].addBox(2F, -5F, 0F, 3, 3, 1, 0F); // Box 12
        wheel_front_left[11].setRotationPoint(65F, 0F, 18F);

        wheel_front_left[12].addBox(2F, 2F, 0F, 3, 3, 1, 0F); // Box 13
        wheel_front_left[12].setRotationPoint(65F, 0F, 18F);

        wheel_front_left[13].addShapeBox(2F, 5F, 0F, 3, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F); // Box 14
        wheel_front_left[13].setRotationPoint(65F, 0F, 18F);

        wheel_front_left[14].addShapeBox(2F, -8F, 0F, 3, 3, 1, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 15
        wheel_front_left[14].setRotationPoint(65F, 0F, 18F);

        wheel_front_left[15].addShapeBox(5F, -5F, 0F, 3, 3, 1, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 16
        wheel_front_left[15].setRotationPoint(65F, 0F, 18F);

        wheel_front_left[16].addShapeBox(5F, 2F, 0F, 3, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F); // Box 17
        wheel_front_left[16].setRotationPoint(65F, 0F, 18F);

        wheel_front_left[17].addShapeBox(5F, 5F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 18
        wheel_front_left[17].setRotationPoint(65F, 0F, 18F);

        wheel_front_left[18].addShapeBox(5F, -6F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 19
        wheel_front_left[18].setRotationPoint(65F, 0F, 18F);

        wheel_front_left[19].addBox(-2F, 8F, 0F, 4, 2, 4, 0F); // Box 20
        wheel_front_left[19].setRotationPoint(65F, 0F, 17F);

        wheel_front_left[20].addBox(-2F, -10F, 0F, 4, 2, 4, 0F); // Box 21
        wheel_front_left[20].setRotationPoint(65F, 0F, 17F);

        wheel_front_left[21].addBox(8F, -2F, 0F, 2, 4, 4, 0F); // Box 22
        wheel_front_left[21].setRotationPoint(65F, 0F, 17F);

        wheel_front_left[22].addBox(-10F, -2F, 0F, 2, 4, 4, 0F); // Box 23
        wheel_front_left[22].setRotationPoint(65F, 0F, 17F);

        wheel_front_left[23].addShapeBox(2F, 8F, 0F, 3, 2, 4, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F, 0F, 0F, -1.5F, 0F, 0F, 0F, 0F); // Box 24
        wheel_front_left[23].setRotationPoint(65F, 0F, 17F);

        wheel_front_left[24].addShapeBox(8F, 2F, 0F, 2, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -1.5F, 0F, 0F, -1.5F, 0F, 0F, 2F, 0F, 0F); // Box 25
        wheel_front_left[24].setRotationPoint(65F, 0F, 17F);

        wheel_front_left[25].addShapeBox(5F, 5F, 0F, 3, 3, 4, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, 0.5F, 0F, 0.5F, -3F, 0F, 0.5F, -3F, 0F, 0F, 0.5F, 0F); // Box 26
        wheel_front_left[25].setRotationPoint(65F, 0F, 17F);

        wheel_front_left[26].addShapeBox(-5F, 8F, 0F, 3, 2, 4, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F, 0F); // Box 27
        wheel_front_left[26].setRotationPoint(65F, 0F, 17F);

        wheel_front_left[27].addShapeBox(-5F, -10F, 0F, 3, 2, 4, 0F, 0F, -1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F); // Box 28
        wheel_front_left[27].setRotationPoint(65F, 0F, 17F);

        wheel_front_left[28].addShapeBox(2F, -10F, 0F, 3, 2, 4, 0F, 0F, 0F, 0F, 0F, -1.5F, 0F, 0F, -1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F); // Box 29
        wheel_front_left[28].setRotationPoint(65F, 0F, 17F);

        wheel_front_left[29].addShapeBox(8F, -5F, 0F, 2, 3, 4, 0F, 2F, 0F, 0F, -1.5F, 0F, 0F, -1.5F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 30
        wheel_front_left[29].setRotationPoint(65F, 0F, 17F);

        wheel_front_left[30].addShapeBox(-10F, -5F, 0F, 2, 3, 4, 0F, -1.5F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 31
        wheel_front_left[30].setRotationPoint(65F, 0F, 17F);

        wheel_front_left[31].addShapeBox(-10F, 2F, 0F, 2, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -1.5F, 0F, 0F); // Box 32
        wheel_front_left[31].setRotationPoint(65F, 0F, 17F);

        wheel_front_left[32].addShapeBox(-8F, 5F, 0F, 3, 3, 4, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, 0.5F, -3F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0.5F, -3F, 0F); // Box 33
        wheel_front_left[32].setRotationPoint(65F, 0F, 17F);

        wheel_front_left[33].addShapeBox(-8F, -8F, 0F, 3, 3, 4, 0F, 0.5F, -3F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0.5F, -3F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F); // Box 34
        wheel_front_left[33].setRotationPoint(65F, 0F, 17F);

        wheel_front_left[34].addShapeBox(5F, -8F, 0F, 3, 3, 4, 0F, 0F, 0.5F, 0F, 0.5F, -3F, 0F, 0.5F, -3F, 0F, 0F, 0.5F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F); // Box 35
        wheel_front_left[34].setRotationPoint(65F, 0F, 17F);

        wheel_front_left[35].addBox(-2F, -6F, 1F, 4, 12, 1, 0F); // Box 334
        wheel_front_left[35].setRotationPoint(65F, 0F, 18F);

        wheel_front_left[36].addBox(2F, -2F, 1F, 4, 4, 1, 0F); // Box 335
        wheel_front_left[36].setRotationPoint(65F, 0F, 18F);

        wheel_front_left[37].addBox(-6F, -2F, 1F, 4, 4, 1, 0F); // Box 336
        wheel_front_left[37].setRotationPoint(65F, 0F, 18F);

        wheel_front_left[38].addShapeBox(2F, 2F, 1F, 4, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F); // Box 337
        wheel_front_left[38].setRotationPoint(65F, 0F, 18F);

        wheel_front_left[39].addShapeBox(2F, -6F, 1F, 4, 4, 1, 0F, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 338
        wheel_front_left[39].setRotationPoint(65F, 0F, 18F);

        wheel_front_left[40].addShapeBox(-6F, -6F, 1F, 4, 4, 1, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 339
        wheel_front_left[40].setRotationPoint(65F, 0F, 18F);

        wheel_front_left[41].addShapeBox(-6F, 2F, 1F, 4, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F); // Box 340
        wheel_front_left[41].setRotationPoint(65F, 0F, 18F);

        wheel_front_left[42].addBox(1.5F, -4.5F, 1.2F, 1, 1, 1, 0F); // Box 348
        wheel_front_left[42].setRotationPoint(65F, 0F, 18F);

        wheel_front_left[43].addBox(-2.5F, -4.5F, 1.2F, 1, 1, 1, 0F); // Box 349
        wheel_front_left[43].setRotationPoint(65F, 0F, 18F);

        wheel_front_left[44].addBox(-2.5F, 3.5F, 1.2F, 1, 1, 1, 0F); // Box 350
        wheel_front_left[44].setRotationPoint(65F, 0F, 18F);

        wheel_front_left[45].addBox(1.5F, 3.5F, 1.2F, 1, 1, 1, 0F); // Box 351
        wheel_front_left[45].setRotationPoint(65F, 0F, 18F);

        wheel_front_left[46].addBox(3.5F, -2.5F, 1.2F, 1, 1, 1, 0F); // Box 352
        wheel_front_left[46].setRotationPoint(65F, 0F, 18F);

        wheel_front_left[47].addBox(3.5F, 1.5F, 1.2F, 1, 1, 1, 0F); // Box 353
        wheel_front_left[47].setRotationPoint(65F, 0F, 18F);

        wheel_front_left[48].addBox(-4.5F, 1.5F, 1.2F, 1, 1, 1, 0F); // Box 354
        wheel_front_left[48].setRotationPoint(65F, 0F, 18F);

        wheel_front_left[49].addBox(-4.5F, -2.5F, 1.2F, 1, 1, 1, 0F); // Box 355
        wheel_front_left[49].setRotationPoint(65F, 0F, 18F);

        wheel_front_left[50].addShapeBox(-2F, -2F, 1.5F, 4, 4, 1, 0F, 1F, 1F, 0F, 1F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 1F, 0F, 1F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 364
        wheel_front_left[50].setRotationPoint(65F, 0F, 18F);
        this.add("wheel_front_left", wheel_front_left);

        ModelRendererTurbo[] wheel_front_right = new ModelRendererTurbo[51];
        wheel_front_right[0] = new ModelRendererTurbo(this, 81, 9, textureX, textureY); // Box 36
        wheel_front_right[1] = new ModelRendererTurbo(this, 97, 9, textureX, textureY); // Box 37
        wheel_front_right[2] = new ModelRendererTurbo(this, 113, 9, textureX, textureY); // Box 38
        wheel_front_right[3] = new ModelRendererTurbo(this, 129, 9, textureX, textureY); // Box 39
        wheel_front_right[4] = new ModelRendererTurbo(this, 145, 9, textureX, textureY); // Box 40
        wheel_front_right[5] = new ModelRendererTurbo(this, 161, 9, textureX, textureY); // Box 41
        wheel_front_right[6] = new ModelRendererTurbo(this, 177, 9, textureX, textureY); // Box 42
        wheel_front_right[7] = new ModelRendererTurbo(this, 193, 9, textureX, textureY); // Box 43
        wheel_front_right[8] = new ModelRendererTurbo(this, 209, 9, textureX, textureY); // Box 44
        wheel_front_right[9] = new ModelRendererTurbo(this, 225, 9, textureX, textureY); // Box 45
        wheel_front_right[10] = new ModelRendererTurbo(this, 241, 9, textureX, textureY); // Box 46
        wheel_front_right[11] = new ModelRendererTurbo(this, 257, 9, textureX, textureY); // Box 47
        wheel_front_right[12] = new ModelRendererTurbo(this, 273, 9, textureX, textureY); // Box 48
        wheel_front_right[13] = new ModelRendererTurbo(this, 289, 9, textureX, textureY); // Box 49
        wheel_front_right[14] = new ModelRendererTurbo(this, 305, 9, textureX, textureY); // Box 50
        wheel_front_right[15] = new ModelRendererTurbo(this, 305, 1, textureX, textureY); // Box 51
        wheel_front_right[16] = new ModelRendererTurbo(this, 329, 1, textureX, textureY); // Box 52
        wheel_front_right[17] = new ModelRendererTurbo(this, 321, 9, textureX, textureY); // Box 53
        wheel_front_right[18] = new ModelRendererTurbo(this, 329, 9, textureX, textureY); // Box 54
        wheel_front_right[19] = new ModelRendererTurbo(this, 369, 9, textureX, textureY); // Box 55
        wheel_front_right[20] = new ModelRendererTurbo(this, 393, 9, textureX, textureY); // Box 56
        wheel_front_right[21] = new ModelRendererTurbo(this, 417, 9, textureX, textureY); // Box 57
        wheel_front_right[22] = new ModelRendererTurbo(this, 433, 9, textureX, textureY); // Box 58
        wheel_front_right[23] = new ModelRendererTurbo(this, 449, 9, textureX, textureY); // Box 59
        wheel_front_right[24] = new ModelRendererTurbo(this, 465, 9, textureX, textureY); // Box 60
        wheel_front_right[25] = new ModelRendererTurbo(this, 481, 9, textureX, textureY); // Box 61
        wheel_front_right[26] = new ModelRendererTurbo(this, 497, 9, textureX, textureY); // Box 62
        wheel_front_right[27] = new ModelRendererTurbo(this, 9, 17, textureX, textureY); // Box 63
        wheel_front_right[28] = new ModelRendererTurbo(this, 49, 17, textureX, textureY); // Box 64
        wheel_front_right[29] = new ModelRendererTurbo(this, 65, 17, textureX, textureY); // Box 65
        wheel_front_right[30] = new ModelRendererTurbo(this, 97, 17, textureX, textureY); // Box 66
        wheel_front_right[31] = new ModelRendererTurbo(this, 113, 17, textureX, textureY); // Box 67
        wheel_front_right[32] = new ModelRendererTurbo(this, 129, 17, textureX, textureY); // Box 68
        wheel_front_right[33] = new ModelRendererTurbo(this, 145, 17, textureX, textureY); // Box 69
        wheel_front_right[34] = new ModelRendererTurbo(this, 161, 17, textureX, textureY); // Box 70
        wheel_front_right[35] = new ModelRendererTurbo(this, 329, 193, textureX, textureY); // Box 341
        wheel_front_right[36] = new ModelRendererTurbo(this, 345, 193, textureX, textureY); // Box 342
        wheel_front_right[37] = new ModelRendererTurbo(this, 361, 193, textureX, textureY); // Box 343
        wheel_front_right[38] = new ModelRendererTurbo(this, 377, 193, textureX, textureY); // Box 344
        wheel_front_right[39] = new ModelRendererTurbo(this, 393, 193, textureX, textureY); // Box 345
        wheel_front_right[40] = new ModelRendererTurbo(this, 297, 201, textureX, textureY); // Box 346
        wheel_front_right[41] = new ModelRendererTurbo(this, 313, 201, textureX, textureY); // Box 347
        wheel_front_right[42] = new ModelRendererTurbo(this, 193, 81, textureX, textureY); // Box 356
        wheel_front_right[43] = new ModelRendererTurbo(this, 209, 81, textureX, textureY); // Box 357
        wheel_front_right[44] = new ModelRendererTurbo(this, 129, 89, textureX, textureY); // Box 358
        wheel_front_right[45] = new ModelRendererTurbo(this, 137, 89, textureX, textureY); // Box 359
        wheel_front_right[46] = new ModelRendererTurbo(this, 145, 89, textureX, textureY); // Box 360
        wheel_front_right[47] = new ModelRendererTurbo(this, 153, 89, textureX, textureY); // Box 361
        wheel_front_right[48] = new ModelRendererTurbo(this, 161, 89, textureX, textureY); // Box 362
        wheel_front_right[49] = new ModelRendererTurbo(this, 169, 89, textureX, textureY); // Box 363
        wheel_front_right[50] = new ModelRendererTurbo(this, 361, 201, textureX, textureY); // Box 365

        wheel_front_right[0].addBox(-2F, -8F, -1F, 4, 16, 1, 0F); // Box 36
        wheel_front_right[0].setRotationPoint(65F, 0F, -18F);

        wheel_front_right[1].addBox(-8F, -2F, -1F, 6, 4, 1, 0F); // Box 37
        wheel_front_right[1].setRotationPoint(65F, 0F, -18F);

        wheel_front_right[2].addBox(2F, -2F, -1F, 6, 4, 1, 0F); // Box 38
        wheel_front_right[2].setRotationPoint(65F, 0F, -18F);

        wheel_front_right[3].addBox(-5F, 2F, -1F, 3, 3, 1, 0F); // Box 39
        wheel_front_right[3].setRotationPoint(65F, 0F, -18F);

        wheel_front_right[4].addBox(-5F, -5F, -1F, 3, 3, 1, 0F); // Box 40
        wheel_front_right[4].setRotationPoint(65F, 0F, -18F);

        wheel_front_right[5].addBox(2F, -5F, -1F, 3, 3, 1, 0F); // Box 41
        wheel_front_right[5].setRotationPoint(65F, 0F, -18F);

        wheel_front_right[6].addBox(2F, 2F, -1F, 3, 3, 1, 0F); // Box 42
        wheel_front_right[6].setRotationPoint(65F, 0F, -18F);

        wheel_front_right[7].addShapeBox(-5F, 5F, -1F, 3, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 43
        wheel_front_right[7].setRotationPoint(65F, 0F, -18F);

        wheel_front_right[8].addShapeBox(-5F, -8F, -1F, 3, 3, 1, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 44
        wheel_front_right[8].setRotationPoint(65F, 0F, -18F);

        wheel_front_right[9].addShapeBox(2F, -8F, -1F, 3, 3, 1, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 45
        wheel_front_right[9].setRotationPoint(65F, 0F, -18F);

        wheel_front_right[10].addShapeBox(2F, 5F, -1F, 3, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F); // Box 46
        wheel_front_right[10].setRotationPoint(65F, 0F, -18F);

        wheel_front_right[11].addShapeBox(-8F, 2F, -1F, 3, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F); // Box 47
        wheel_front_right[11].setRotationPoint(65F, 0F, -18F);

        wheel_front_right[12].addShapeBox(-8F, -5F, -1F, 3, 3, 1, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 48
        wheel_front_right[12].setRotationPoint(65F, 0F, -18F);

        wheel_front_right[13].addShapeBox(5F, -5F, -1F, 3, 3, 1, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 49
        wheel_front_right[13].setRotationPoint(65F, 0F, -18F);

        wheel_front_right[14].addShapeBox(5F, 2F, -1F, 3, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F); // Box 50
        wheel_front_right[14].setRotationPoint(65F, 0F, -18F);

        wheel_front_right[15].addShapeBox(-6F, 5F, -1F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 51
        wheel_front_right[15].setRotationPoint(65F, 0F, -18F);

        wheel_front_right[16].addShapeBox(-6F, -6F, -1F, 1, 1, 1, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 52
        wheel_front_right[16].setRotationPoint(65F, 0F, -18F);

        wheel_front_right[17].addShapeBox(5F, -6F, -1F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 53
        wheel_front_right[17].setRotationPoint(65F, 0F, -18F);

        wheel_front_right[18].addShapeBox(5F, 5F, -1F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 54
        wheel_front_right[18].setRotationPoint(65F, 0F, -18F);

        wheel_front_right[19].addBox(-2F, 8F, -4F, 4, 2, 4, 0F); // Box 55
        wheel_front_right[19].setRotationPoint(65F, 0F, -17F);

        wheel_front_right[20].addBox(-2F, -10F, -4F, 4, 2, 4, 0F); // Box 56
        wheel_front_right[20].setRotationPoint(65F, 0F, -17F);

        wheel_front_right[21].addBox(-10F, -2F, -4F, 2, 4, 4, 0F); // Box 57
        wheel_front_right[21].setRotationPoint(65F, 0F, -17F);

        wheel_front_right[22].addBox(8F, -2F, -4F, 2, 4, 4, 0F); // Box 58
        wheel_front_right[22].setRotationPoint(65F, 0F, -17F);

        wheel_front_right[23].addShapeBox(-5F, 8F, -4F, 3, 2, 4, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F, 0F); // Box 59
        wheel_front_right[23].setRotationPoint(65F, 0F, -17F);

        wheel_front_right[24].addShapeBox(-5F, -10F, -4F, 3, 2, 4, 0F, 0F, -1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F); // Box 60
        wheel_front_right[24].setRotationPoint(65F, 0F, -17F);

        wheel_front_right[25].addShapeBox(2F, -10F, -4F, 3, 2, 4, 0F, 0F, 0F, 0F, 0F, -1.5F, 0F, 0F, -1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F); // Box 61
        wheel_front_right[25].setRotationPoint(65F, 0F, -17F);

        wheel_front_right[26].addShapeBox(2F, 8F, -4F, 3, 2, 4, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F, 0F, 0F, -1.5F, 0F, 0F, 0F, 0F); // Box 62
        wheel_front_right[26].setRotationPoint(65F, 0F, -17F);

        wheel_front_right[27].addShapeBox(-10F, 2F, -4F, 2, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -1.5F, 0F, 0F); // Box 63
        wheel_front_right[27].setRotationPoint(65F, 0F, -17F);

        wheel_front_right[28].addShapeBox(-10F, -5F, -4F, 2, 3, 4, 0F, -1.5F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 64
        wheel_front_right[28].setRotationPoint(65F, 0F, -17F);

        wheel_front_right[29].addShapeBox(8F, -5F, -4F, 2, 3, 4, 0F, 2F, 0F, 0F, -1.5F, 0F, 0F, -1.5F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 65
        wheel_front_right[29].setRotationPoint(65F, 0F, -17F);

        wheel_front_right[30].addShapeBox(8F, 2F, -4F, 2, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -1.5F, 0F, 0F, -1.5F, 0F, 0F, 2F, 0F, 0F); // Box 66
        wheel_front_right[30].setRotationPoint(65F, 0F, -17F);

        wheel_front_right[31].addShapeBox(-8F, 5F, -4F, 3, 3, 4, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, 0.5F, -3F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0.5F, -3F, 0F); // Box 67
        wheel_front_right[31].setRotationPoint(65F, 0F, -17F);

        wheel_front_right[32].addShapeBox(-8F, -8F, -4F, 3, 3, 4, 0F, 0.5F, -3F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0.5F, -3F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F); // Box 68
        wheel_front_right[32].setRotationPoint(65F, 0F, -17F);

        wheel_front_right[33].addShapeBox(5F, -8F, -4F, 3, 3, 4, 0F, 0F, 0.5F, 0F, 0.5F, -3F, 0F, 0.5F, -3F, 0F, 0F, 0.5F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F); // Box 69
        wheel_front_right[33].setRotationPoint(65F, 0F, -17F);

        wheel_front_right[34].addShapeBox(5F, 5F, -4F, 3, 3, 4, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, 0.5F, 0F, 0.5F, -3F, 0F, 0.5F, -3F, 0F, 0F, 0.5F, 0F); // Box 70
        wheel_front_right[34].setRotationPoint(65F, 0F, -17F);

        wheel_front_right[35].addBox(-2F, -6F, -2F, 4, 12, 1, 0F); // Box 341
        wheel_front_right[35].setRotationPoint(65F, 0F, -18F);

        wheel_front_right[36].addBox(-6F, -2F, -2F, 4, 4, 1, 0F); // Box 342
        wheel_front_right[36].setRotationPoint(65F, 0F, -18F);

        wheel_front_right[37].addBox(2F, -2F, -2F, 4, 4, 1, 0F); // Box 343
        wheel_front_right[37].setRotationPoint(65F, 0F, -18F);

        wheel_front_right[38].addShapeBox(-6F, -6F, -2F, 4, 4, 1, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 344
        wheel_front_right[38].setRotationPoint(65F, 0F, -18F);

        wheel_front_right[39].addShapeBox(-6F, 2F, -2F, 4, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F); // Box 345
        wheel_front_right[39].setRotationPoint(65F, 0F, -18F);

        wheel_front_right[40].addShapeBox(2F, 2F, -2F, 4, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F); // Box 346
        wheel_front_right[40].setRotationPoint(65F, 0F, -18F);

        wheel_front_right[41].addShapeBox(2F, -6F, -2F, 4, 4, 1, 0F, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 347
        wheel_front_right[41].setRotationPoint(65F, 0F, -18F);

        wheel_front_right[42].addBox(-4.5F, -2.5F, -2.2F, 1, 1, 1, 0F); // Box 356
        wheel_front_right[42].setRotationPoint(65F, 0F, -18F);

        wheel_front_right[43].addBox(-2.5F, -4.5F, -2.2F, 1, 1, 1, 0F); // Box 357
        wheel_front_right[43].setRotationPoint(65F, 0F, -18F);

        wheel_front_right[44].addBox(1.5F, -4.5F, -2.2F, 1, 1, 1, 0F); // Box 358
        wheel_front_right[44].setRotationPoint(65F, 0F, -18F);

        wheel_front_right[45].addBox(1.5F, 3.5F, -2.2F, 1, 1, 1, 0F); // Box 359
        wheel_front_right[45].setRotationPoint(65F, 0F, -18F);

        wheel_front_right[46].addBox(-2.5F, 3.5F, -2.2F, 1, 1, 1, 0F); // Box 360
        wheel_front_right[46].setRotationPoint(65F, 0F, -18F);

        wheel_front_right[47].addBox(-4.5F, 1.5F, -2.2F, 1, 1, 1, 0F); // Box 361
        wheel_front_right[47].setRotationPoint(65F, 0F, -18F);

        wheel_front_right[48].addBox(3.5F, 1.5F, -2.2F, 1, 1, 1, 0F); // Box 362
        wheel_front_right[48].setRotationPoint(65F, 0F, -18F);

        wheel_front_right[49].addBox(3.5F, -2.5F, -2.2F, 1, 1, 1, 0F); // Box 363
        wheel_front_right[49].setRotationPoint(65F, 0F, -18F);

        wheel_front_right[50].addShapeBox(-2F, -2F, -2.5F, 4, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 1F, 0F, 1F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 1F, 0F, 1F, 1F, 0F); // Box 365
        wheel_front_right[50].setRotationPoint(65F, 0F, -18F);
        this.add("wheel_front_right", wheel_front_right);
        //translateAll(0F, 0F, 0F);
        //flipAll();
    }

    @Override
    public void render(VehicleData data, String us){
        this.def_renderWheels4(data, us);
    }

    @Override
    public void render(VehicleData data, String us, Entity vehicle, int meta){
        this.def_renderWheels4(data, us, vehicle);
    }

}
