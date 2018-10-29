//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2016 Minecraft-SMP.de
// This file is for Fex's Vehicle Mod
// Model: T1(P) Back Wheels
// Model Creator: FEX___96
// Created on: 20.01.2016 - 22:15:40
// Last changed on: 20.01.2016 - 22:15:40
package net.fexcraft.mod.addons.fvp.models.part;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.part.PartModelTMT;
import net.minecraft.entity.Entity;

public class ModelT1BW extends PartModelTMT {

    public ModelT1BW(){
    	super(); textureX = 512; textureY = 512;
        addToCreators("Ferdinand (FEX___96)");
        wheel_back_left = new ModelRendererTurbo[62];
        wheel_back_left[0] = new ModelRendererTurbo(this, 249, 145, textureX, textureY); // Box 231
        wheel_back_left[1] = new ModelRendererTurbo(this, 209, 121, textureX, textureY); // Box 232
        wheel_back_left[2] = new ModelRendererTurbo(this, 161, 129, textureX, textureY); // Box 233
        wheel_back_left[3] = new ModelRendererTurbo(this, 473, 81, textureX, textureY); // Box 234
        wheel_back_left[4] = new ModelRendererTurbo(this, 1, 89, textureX, textureY); // Box 235
        wheel_back_left[5] = new ModelRendererTurbo(this, 25, 89, textureX, textureY); // Box 236
        wheel_back_left[6] = new ModelRendererTurbo(this, 337, 97, textureX, textureY); // Box 237
        wheel_back_left[7] = new ModelRendererTurbo(this, 449, 97, textureX, textureY); // Box 238
        wheel_back_left[8] = new ModelRendererTurbo(this, 25, 113, textureX, textureY); // Box 239
        wheel_back_left[9] = new ModelRendererTurbo(this, 465, 25, textureX, textureY); // Box 240
        wheel_back_left[10] = new ModelRendererTurbo(this, 73, 57, textureX, textureY); // Box 241
        wheel_back_left[11] = new ModelRendererTurbo(this, 161, 57, textureX, textureY); // Box 242
        wheel_back_left[12] = new ModelRendererTurbo(this, 249, 113, textureX, textureY); // Box 243
        wheel_back_left[13] = new ModelRendererTurbo(this, 361, 57, textureX, textureY); // Box 244
        wheel_back_left[14] = new ModelRendererTurbo(this, 281, 113, textureX, textureY); // Box 245
        wheel_back_left[15] = new ModelRendererTurbo(this, 209, 97, textureX, textureY); // Box 246
        wheel_back_left[16] = new ModelRendererTurbo(this, 369, 129, textureX, textureY); // Box 247
        wheel_back_left[17] = new ModelRendererTurbo(this, 137, 145, textureX, textureY); // Box 248
        wheel_back_left[18] = new ModelRendererTurbo(this, 153, 137, textureX, textureY); // Box 249
        wheel_back_left[19] = new ModelRendererTurbo(this, 177, 145, textureX, textureY); // Box 250
        wheel_back_left[20] = new ModelRendererTurbo(this, 345, 145, textureX, textureY); // Box 251
        wheel_back_left[21] = new ModelRendererTurbo(this, 393, 145, textureX, textureY); // Box 252
        wheel_back_left[22] = new ModelRendererTurbo(this, 433, 145, textureX, textureY); // Box 253
        wheel_back_left[23] = new ModelRendererTurbo(this, 41, 153, textureX, textureY); // Box 254
        wheel_back_left[24] = new ModelRendererTurbo(this, 369, 145, textureX, textureY); // Box 255
        wheel_back_left[25] = new ModelRendererTurbo(this, 81, 153, textureX, textureY); // Box 256
        wheel_back_left[26] = new ModelRendererTurbo(this, 193, 153, textureX, textureY); // Box 257
        wheel_back_left[27] = new ModelRendererTurbo(this, 105, 153, textureX, textureY); // Box 258
        wheel_back_left[28] = new ModelRendererTurbo(this, 153, 153, textureX, textureY); // Box 259
        wheel_back_left[29] = new ModelRendererTurbo(this, 473, 153, textureX, textureY); // Box 260
        wheel_back_left[30] = new ModelRendererTurbo(this, 409, 153, textureX, textureY); // Box 261
        wheel_back_left[31] = new ModelRendererTurbo(this, 129, 241, textureX, textureY); // Box 542
        wheel_back_left[32] = new ModelRendererTurbo(this, 441, 281, textureX, textureY); // Box 543
        wheel_back_left[33] = new ModelRendererTurbo(this, 425, 233, textureX, textureY); // Box 544
        wheel_back_left[34] = new ModelRendererTurbo(this, 473, 257, textureX, textureY); // Box 545
        wheel_back_left[35] = new ModelRendererTurbo(this, 449, 233, textureX, textureY); // Box 550
        wheel_back_left[36] = new ModelRendererTurbo(this, 105, 241, textureX, textureY); // Box 551
        wheel_back_left[37] = new ModelRendererTurbo(this, 105, 249, textureX, textureY); // Box 552
        wheel_back_left[38] = new ModelRendererTurbo(this, 225, 273, textureX, textureY); // Box 553
        wheel_back_left[39] = new ModelRendererTurbo(this, 241, 161, textureX, textureY); // Box 554
        wheel_back_left[40] = new ModelRendererTurbo(this, 385, 217, textureX, textureY); // Box 555
        wheel_back_left[41] = new ModelRendererTurbo(this, 137, 225, textureX, textureY); // Box 556
        wheel_back_left[42] = new ModelRendererTurbo(this, 33, 233, textureX, textureY); // Box 557
        wheel_back_left[43] = new ModelRendererTurbo(this, 1, 337, textureX, textureY); // Box 566
        wheel_back_left[44] = new ModelRendererTurbo(this, 433, 161, textureX, textureY); // Box 567
        wheel_back_left[45] = new ModelRendererTurbo(this, 41, 169, textureX, textureY); // Box 568
        wheel_back_left[46] = new ModelRendererTurbo(this, 385, 321, textureX, textureY); // Box 569
        wheel_back_left[47] = new ModelRendererTurbo(this, 401, 321, textureX, textureY); // Box 570
        wheel_back_left[48] = new ModelRendererTurbo(this, 417, 313, textureX, textureY); // Box 577
        wheel_back_left[49] = new ModelRendererTurbo(this, 249, 121, textureX, textureY); // Box 578
        wheel_back_left[50] = new ModelRendererTurbo(this, 465, 121, textureX, textureY); // Box 581
        wheel_back_left[51] = new ModelRendererTurbo(this, 177, 145, textureX, textureY); // Box 583
        wheel_back_left[52] = new ModelRendererTurbo(this, 345, 145, textureX, textureY); // Box 584
        wheel_back_left[53] = new ModelRendererTurbo(this, 505, 153, textureX, textureY); // Box 585
        wheel_back_left[54] = new ModelRendererTurbo(this, 497, 105, textureX, textureY); // Box 593
        wheel_back_left[55] = new ModelRendererTurbo(this, 281, 121, textureX, textureY); // Box 594
        wheel_back_left[56] = new ModelRendererTurbo(this, 497, 121, textureX, textureY); // Box 595
        wheel_back_left[57] = new ModelRendererTurbo(this, 41, 153, textureX, textureY); // Box 596
        wheel_back_left[58] = new ModelRendererTurbo(this, 81, 153, textureX, textureY); // Box 597
        wheel_back_left[59] = new ModelRendererTurbo(this, 289, 153, textureX, textureY); // Box 598
        wheel_back_left[60] = new ModelRendererTurbo(this, 473, 153, textureX, textureY); // Box 599
        wheel_back_left[61] = new ModelRendererTurbo(this, 497, 153, textureX, textureY); // Box 600

        wheel_back_left[0].addBox(-8F, -3F, 0F, 16, 6, 2, 0F); // Box 231
        wheel_back_left[0].setRotationPoint(-71F, 0F, 17F);

        wheel_back_left[1].addBox(-3F, 3F, 0F, 6, 5, 2, 0F); // Box 232
        wheel_back_left[1].setRotationPoint(-71F, 0F, 17F);

        wheel_back_left[2].addBox(-3F, -8F, 0F, 6, 5, 2, 0F); // Box 233
        wheel_back_left[2].setRotationPoint(-71F, 0F, 17F);

        wheel_back_left[3].addBox(-6F, 3F, 0F, 3, 3, 2, 0F); // Box 234
        wheel_back_left[3].setRotationPoint(-71F, 0F, 17F);

        wheel_back_left[4].addBox(3F, 3F, 0F, 3, 3, 2, 0F); // Box 235
        wheel_back_left[4].setRotationPoint(-71F, 0F, 17F);

        wheel_back_left[5].addBox(-6F, -6F, 0F, 3, 3, 2, 0F); // Box 236
        wheel_back_left[5].setRotationPoint(-71F, 0F, 17F);

        wheel_back_left[6].addBox(3F, -6F, 0F, 3, 3, 2, 0F); // Box 237
        wheel_back_left[6].setRotationPoint(-71F, 0F, 17F);

        wheel_back_left[7].addShapeBox(3F, 6F, 0F, 3, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F); // Box 238
        wheel_back_left[7].setRotationPoint(-71F, 0F, 17F);

        wheel_back_left[8].addShapeBox(-6F, 6F, 0F, 3, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F); // Box 239
        wheel_back_left[8].setRotationPoint(-71F, 0F, 17F);

        wheel_back_left[9].addShapeBox(-8F, 3F, 0F, 2, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F); // Box 240
        wheel_back_left[9].setRotationPoint(-71F, 0F, 17F);

        wheel_back_left[10].addShapeBox(6F, 3F, 0F, 2, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F); // Box 241
        wheel_back_left[10].setRotationPoint(-71F, 0F, 17F);

        wheel_back_left[11].addShapeBox(-8F, -6F, 0F, 2, 3, 2, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 242
        wheel_back_left[11].setRotationPoint(-71F, 0F, 17F);

        wheel_back_left[12].addShapeBox(-6F, -8F, 0F, 3, 2, 2, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 243
        wheel_back_left[12].setRotationPoint(-71F, 0F, 17F);

        wheel_back_left[13].addShapeBox(6F, -6F, 0F, 2, 3, 2, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 244
        wheel_back_left[13].setRotationPoint(-71F, 0F, 17F);

        wheel_back_left[14].addShapeBox(3F, -8F, 0F, 3, 2, 2, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 245
        wheel_back_left[14].setRotationPoint(-71F, 0F, 17F);

        wheel_back_left[15].addShapeBox(-10F, 3F, 0F, 2, 3, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F); // Box 246
        wheel_back_left[15].setRotationPoint(-71F, 0F, 16.5F);

        wheel_back_left[16].addShapeBox(-8F, 6F, 0F, 2, 2, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F); // Box 247
        wheel_back_left[16].setRotationPoint(-71F, 0F, 16.5F);

        wheel_back_left[17].addShapeBox(-6F, 8F, 0F, 3, 2, 6, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 248
        wheel_back_left[17].setRotationPoint(-71F, 0F, 16.5F);

        wheel_back_left[18].addBox(-10F, -3F, 0F, 2, 6, 6, 0F); // Box 249
        wheel_back_left[18].setRotationPoint(-71F, 0F, 16.5F);

        wheel_back_left[19].addShapeBox(-10F, -6F, 0F, 2, 3, 6, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 250
        wheel_back_left[19].setRotationPoint(-71F, 0F, 16.5F);

        wheel_back_left[20].addShapeBox(-8F, -8F, 0F, 2, 2, 6, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 251
        wheel_back_left[20].setRotationPoint(-71F, 0F, 16.5F);

        wheel_back_left[21].addShapeBox(-6F, -10F, 0F, 3, 2, 6, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F); // Box 252
        wheel_back_left[21].setRotationPoint(-71F, 0F, 16.5F);

        wheel_back_left[22].addBox(-3F, -10F, 0F, 6, 2, 6, 0F); // Box 253
        wheel_back_left[22].setRotationPoint(-71F, 0F, 16.5F);

        wheel_back_left[23].addShapeBox(3F, -10F, 0F, 3, 2, 6, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F); // Box 254
        wheel_back_left[23].setRotationPoint(-71F, 0F, 16.5F);

        wheel_back_left[24].addShapeBox(8F, -6F, 0F, 2, 3, 6, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 255
        wheel_back_left[24].setRotationPoint(-71F, 0F, 16.5F);

        wheel_back_left[25].addShapeBox(6F, -8F, 0F, 2, 2, 6, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 256
        wheel_back_left[25].setRotationPoint(-71F, 0F, 16.5F);

        wheel_back_left[26].addBox(8F, -3F, 0F, 2, 6, 6, 0F); // Box 257
        wheel_back_left[26].setRotationPoint(-71F, 0F, 16.5F);

        wheel_back_left[27].addBox(-3F, 8F, 0F, 6, 2, 6, 0F); // Box 258
        wheel_back_left[27].setRotationPoint(-71F, 0F, 16.5F);

        wheel_back_left[28].addShapeBox(8F, 3F, 0F, 2, 3, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F); // Box 259
        wheel_back_left[28].setRotationPoint(-71F, 0F, 16.5F);

        wheel_back_left[29].addShapeBox(3F, 8F, 0F, 3, 2, 6, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F); // Box 260
        wheel_back_left[29].setRotationPoint(-71F, 0F, 16.5F);

        wheel_back_left[30].addShapeBox(6F, 6F, 0F, 2, 2, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F); // Box 261
        wheel_back_left[30].setRotationPoint(-71F, 0F, 16.5F);

        wheel_back_left[31].addBox(7F, -3F, 1F, 1, 6, 4, 0F); // Box 542
        wheel_back_left[31].setRotationPoint(-71F, 0F, 17F);

        wheel_back_left[32].addBox(-8F, -3F, 1F, 1, 6, 4, 0F); // Box 543
        wheel_back_left[32].setRotationPoint(-71F, 0F, 17F);

        wheel_back_left[33].addBox(-3F, -8F, 1F, 6, 1, 4, 0F); // Box 544
        wheel_back_left[33].setRotationPoint(-71F, 0F, 17F);

        wheel_back_left[34].addBox(-3F, 7F, 1F, 6, 1, 4, 0F); // Box 545
        wheel_back_left[34].setRotationPoint(-71F, 0F, 17F);

        wheel_back_left[35].addShapeBox(3F, 7F, 1F, 3, 1, 4, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F); // Box 550
        wheel_back_left[35].setRotationPoint(-71F, 0F, 17F);

        wheel_back_left[36].addShapeBox(3F, -8F, 1F, 3, 1, 4, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F); // Box 551
        wheel_back_left[36].setRotationPoint(-71F, 0F, 17F);

        wheel_back_left[37].addShapeBox(-6F, -8F, 1F, 3, 1, 4, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F); // Box 552
        wheel_back_left[37].setRotationPoint(-71F, 0F, 17F);

        wheel_back_left[38].addShapeBox(-6F, 7F, 1F, 3, 1, 4, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 553
        wheel_back_left[38].setRotationPoint(-71F, 0F, 17F);

        wheel_back_left[39].addShapeBox(7F, 3F, 1F, 1, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F); // Box 554
        wheel_back_left[39].setRotationPoint(-71F, 0F, 17F);

        wheel_back_left[40].addShapeBox(7F, -6F, 1F, 1, 3, 4, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 555
        wheel_back_left[40].setRotationPoint(-71F, 0F, 17F);

        wheel_back_left[41].addShapeBox(-8F, -6F, 1F, 1, 3, 4, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 556
        wheel_back_left[41].setRotationPoint(-71F, 0F, 17F);

        wheel_back_left[42].addShapeBox(-8F, 3F, 1F, 1, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F); // Box 557
        wheel_back_left[42].setRotationPoint(-71F, 0F, 17F);

        wheel_back_left[43].addBox(-2F, -2F, 1F, 4, 4, 3, 0F); // Box 566
        wheel_back_left[43].setRotationPoint(-71F, 0F, 17F);

        wheel_back_left[44].addShapeBox(-3F, -2F, 1F, 1, 4, 3, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 567
        wheel_back_left[44].setRotationPoint(-71F, 0F, 17F);

        wheel_back_left[45].addShapeBox(2F, -2F, 1F, 1, 4, 3, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 568
        wheel_back_left[45].setRotationPoint(-71F, 0F, 17F);

        wheel_back_left[46].addShapeBox(-2F, -3F, 1F, 4, 1, 3, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 569
        wheel_back_left[46].setRotationPoint(-71F, 0F, 17F);

        wheel_back_left[47].addShapeBox(-2F, 2F, 1F, 4, 1, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 570
        wheel_back_left[47].setRotationPoint(-71F, 0F, 17F);

        wheel_back_left[48].addShapeBox(-2F, -2F, 4F, 4, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 577
        wheel_back_left[48].setRotationPoint(-71F, 0F, 17F);

        wheel_back_left[49].addShapeBox(-2F, -3F, 4F, 4, 1, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -1F, -1F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 578
        wheel_back_left[49].setRotationPoint(-71F, 0F, 17F);

        wheel_back_left[50].addShapeBox(-2F, 2F, 4F, 4, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -1F, -1F, 0F, -1F); // Box 581
        wheel_back_left[50].setRotationPoint(-71F, 0F, 17F);

        wheel_back_left[51].addShapeBox(-3F, -2F, 4F, 1, 4, 1, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, -1F, -1F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, -1F, -1F); // Box 583
        wheel_back_left[51].setRotationPoint(-71F, 0F, 17F);

        wheel_back_left[52].addShapeBox(2F, -2F, 4F, 1, 4, 1, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, -1F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, -1F, 0F, 0F, -0.5F); // Box 584
        wheel_back_left[52].setRotationPoint(-71F, 0F, 17F);

        wheel_back_left[53].addShapeBox(-1F, -1F, 4.5F, 2, 2, 1, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F); // Box 585
        wheel_back_left[53].setRotationPoint(-71F, 0F, 17F);

        wheel_back_left[54].addShapeBox(5F, -2F, 2F, 1, 1, 1, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F); // Box 593
        wheel_back_left[54].setRotationPoint(-71F, 0F, 17F);

        wheel_back_left[55].addShapeBox(5F, 1F, 2F, 1, 1, 1, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F); // Box 594
        wheel_back_left[55].setRotationPoint(-71F, 0F, 17F);

        wheel_back_left[56].addShapeBox(-6F, 1F, 2F, 1, 1, 1, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F); // Box 595
        wheel_back_left[56].setRotationPoint(-71F, 0F, 17F);

        wheel_back_left[57].addShapeBox(-6F, -2F, 2F, 1, 1, 1, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F); // Box 596
        wheel_back_left[57].setRotationPoint(-71F, 0F, 17F);

        wheel_back_left[58].addShapeBox(1F, -6F, 2F, 1, 1, 1, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F); // Box 597
        wheel_back_left[58].setRotationPoint(-71F, 0F, 17F);

        wheel_back_left[59].addShapeBox(-2F, -6F, 2F, 1, 1, 1, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F); // Box 598
        wheel_back_left[59].setRotationPoint(-71F, 0F, 17F);

        wheel_back_left[60].addShapeBox(1F, 5F, 2F, 1, 1, 1, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F); // Box 599
        wheel_back_left[60].setRotationPoint(-71F, 0F, 17F);

        wheel_back_left[61].addShapeBox(-2F, 5F, 2F, 1, 1, 1, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F); // Box 600
        wheel_back_left[61].setRotationPoint(-71F, 0F, 17F);

        wheel_back_right = new ModelRendererTurbo[62];
        wheel_back_right[0] = new ModelRendererTurbo(this, 473, 169, textureX, textureY); // Box 273
        wheel_back_right[1] = new ModelRendererTurbo(this, 489, 129, textureX, textureY); // Box 274
        wheel_back_right[2] = new ModelRendererTurbo(this, 281, 169, textureX, textureY); // Box 275
        wheel_back_right[3] = new ModelRendererTurbo(this, 465, 113, textureX, textureY); // Box 276
        wheel_back_right[4] = new ModelRendererTurbo(this, 497, 113, textureX, textureY); // Box 277
        wheel_back_right[5] = new ModelRendererTurbo(this, 1, 129, textureX, textureY); // Box 278
        wheel_back_right[6] = new ModelRendererTurbo(this, 465, 129, textureX, textureY); // Box 279
        wheel_back_right[7] = new ModelRendererTurbo(this, 193, 145, textureX, textureY); // Box 280
        wheel_back_right[8] = new ModelRendererTurbo(this, 177, 89, textureX, textureY); // Box 281
        wheel_back_right[9] = new ModelRendererTurbo(this, 217, 145, textureX, textureY); // Box 282
        wheel_back_right[10] = new ModelRendererTurbo(this, 249, 89, textureX, textureY); // Box 283
        wheel_back_right[11] = new ModelRendererTurbo(this, 49, 97, textureX, textureY); // Box 284
        wheel_back_right[12] = new ModelRendererTurbo(this, 361, 145, textureX, textureY); // Box 285
        wheel_back_right[13] = new ModelRendererTurbo(this, 409, 145, textureX, textureY); // Box 286
        wheel_back_right[14] = new ModelRendererTurbo(this, 89, 97, textureX, textureY); // Box 287
        wheel_back_right[15] = new ModelRendererTurbo(this, 321, 169, textureX, textureY); // Box 289
        wheel_back_right[16] = new ModelRendererTurbo(this, 177, 161, textureX, textureY); // Box 290
        wheel_back_right[17] = new ModelRendererTurbo(this, 121, 169, textureX, textureY); // Box 291
        wheel_back_right[18] = new ModelRendererTurbo(this, 393, 169, textureX, textureY); // Box 292
        wheel_back_right[19] = new ModelRendererTurbo(this, 137, 177, textureX, textureY); // Box 293
        wheel_back_right[20] = new ModelRendererTurbo(this, 1, 177, textureX, textureY); // Box 294
        wheel_back_right[21] = new ModelRendererTurbo(this, 161, 177, textureX, textureY); // Box 295
        wheel_back_right[22] = new ModelRendererTurbo(this, 81, 185, textureX, textureY); // Box 296
        wheel_back_right[23] = new ModelRendererTurbo(this, 201, 185, textureX, textureY); // Box 297
        wheel_back_right[24] = new ModelRendererTurbo(this, 121, 185, textureX, textureY); // Box 298
        wheel_back_right[25] = new ModelRendererTurbo(this, 177, 185, textureX, textureY); // Box 299
        wheel_back_right[26] = new ModelRendererTurbo(this, 233, 185, textureX, textureY); // Box 300
        wheel_back_right[27] = new ModelRendererTurbo(this, 257, 185, textureX, textureY); // Box 301
        wheel_back_right[28] = new ModelRendererTurbo(this, 297, 185, textureX, textureY); // Box 302
        wheel_back_right[29] = new ModelRendererTurbo(this, 321, 185, textureX, textureY); // Box 303
        wheel_back_right[30] = new ModelRendererTurbo(this, 353, 185, textureX, textureY); // Box 304
        wheel_back_right[31] = new ModelRendererTurbo(this, 353, 313, textureX, textureY); // Box 546
        wheel_back_right[32] = new ModelRendererTurbo(this, 377, 313, textureX, textureY); // Box 547
        wheel_back_right[33] = new ModelRendererTurbo(this, 393, 313, textureX, textureY); // Box 548
        wheel_back_right[34] = new ModelRendererTurbo(this, 489, 329, textureX, textureY); // Box 549
        wheel_back_right[35] = new ModelRendererTurbo(this, 65, 241, textureX, textureY); // Box 558
        wheel_back_right[36] = new ModelRendererTurbo(this, 289, 241, textureX, textureY); // Box 559
        wheel_back_right[37] = new ModelRendererTurbo(this, 137, 249, textureX, textureY); // Box 560
        wheel_back_right[38] = new ModelRendererTurbo(this, 57, 257, textureX, textureY); // Box 561
        wheel_back_right[39] = new ModelRendererTurbo(this, 337, 313, textureX, textureY); // Box 562
        wheel_back_right[40] = new ModelRendererTurbo(this, 297, 329, textureX, textureY); // Box 563
        wheel_back_right[41] = new ModelRendererTurbo(this, 321, 329, textureX, textureY); // Box 564
        wheel_back_right[42] = new ModelRendererTurbo(this, 353, 329, textureX, textureY); // Box 565
        wheel_back_right[43] = new ModelRendererTurbo(this, 25, 337, textureX, textureY); // Box 572
        wheel_back_right[44] = new ModelRendererTurbo(this, 441, 321, textureX, textureY); // Box 573
        wheel_back_right[45] = new ModelRendererTurbo(this, 457, 321, textureX, textureY); // Box 574
        wheel_back_right[46] = new ModelRendererTurbo(this, 81, 169, textureX, textureY); // Box 575
        wheel_back_right[47] = new ModelRendererTurbo(this, 105, 169, textureX, textureY); // Box 576
        wheel_back_right[48] = new ModelRendererTurbo(this, 1, 137, textureX, textureY); // Box 586
        wheel_back_right[49] = new ModelRendererTurbo(this, 217, 153, textureX, textureY); // Box 587
        wheel_back_right[50] = new ModelRendererTurbo(this, 297, 337, textureX, textureY); // Box 588
        wheel_back_right[51] = new ModelRendererTurbo(this, 393, 145, textureX, textureY); // Box 589
        wheel_back_right[52] = new ModelRendererTurbo(this, 257, 169, textureX, textureY); // Box 590
        wheel_back_right[53] = new ModelRendererTurbo(this, 433, 145, textureX, textureY); // Box 591
        wheel_back_right[54] = new ModelRendererTurbo(this, 177, 161, textureX, textureY); // Box 601
        wheel_back_right[55] = new ModelRendererTurbo(this, 121, 169, textureX, textureY); // Box 602
        wheel_back_right[56] = new ModelRendererTurbo(this, 321, 169, textureX, textureY); // Box 603
        wheel_back_right[57] = new ModelRendererTurbo(this, 353, 169, textureX, textureY); // Box 604
        wheel_back_right[58] = new ModelRendererTurbo(this, 377, 169, textureX, textureY); // Box 605
        wheel_back_right[59] = new ModelRendererTurbo(this, 393, 169, textureX, textureY); // Box 606
        wheel_back_right[60] = new ModelRendererTurbo(this, 1, 177, textureX, textureY); // Box 607
        wheel_back_right[61] = new ModelRendererTurbo(this, 137, 177, textureX, textureY); // Box 608

        wheel_back_right[0].addBox(-8F, -3F, -2F, 16, 6, 2, 0F); // Box 273
        wheel_back_right[0].setRotationPoint(-71F, 0F, -17F);

        wheel_back_right[1].addBox(-3F, 3F, -2F, 6, 5, 2, 0F); // Box 274
        wheel_back_right[1].setRotationPoint(-71F, 0F, -17F);

        wheel_back_right[2].addBox(-3F, -8F, -2F, 6, 5, 2, 0F); // Box 275
        wheel_back_right[2].setRotationPoint(-71F, 0F, -17F);

        wheel_back_right[3].addBox(-6F, 3F, -2F, 3, 3, 2, 0F); // Box 276
        wheel_back_right[3].setRotationPoint(-71F, 0F, -17F);

        wheel_back_right[4].addBox(-6F, -6F, -2F, 3, 3, 2, 0F); // Box 277
        wheel_back_right[4].setRotationPoint(-71F, 0F, -17F);

        wheel_back_right[5].addBox(3F, 3F, -2F, 3, 3, 2, 0F); // Box 278
        wheel_back_right[5].setRotationPoint(-71F, 0F, -17F);

        wheel_back_right[6].addBox(3F, -6F, -2F, 3, 3, 2, 0F); // Box 279
        wheel_back_right[6].setRotationPoint(-71F, 0F, -17F);

        wheel_back_right[7].addShapeBox(-6F, -8F, -2F, 3, 2, 2, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 280
        wheel_back_right[7].setRotationPoint(-71F, 0F, -17F);

        wheel_back_right[8].addShapeBox(-8F, -6F, -2F, 2, 3, 2, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 281
        wheel_back_right[8].setRotationPoint(-71F, 0F, -17F);

        wheel_back_right[9].addShapeBox(3F, -8F, -2F, 3, 2, 2, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 282
        wheel_back_right[9].setRotationPoint(-71F, 0F, -17F);

        wheel_back_right[10].addShapeBox(6F, -6F, -2F, 2, 3, 2, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 283
        wheel_back_right[10].setRotationPoint(-71F, 0F, -17F);

        wheel_back_right[11].addShapeBox(-8F, 3F, -2F, 2, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F); // Box 284
        wheel_back_right[11].setRotationPoint(-71F, 0F, -17F);

        wheel_back_right[12].addShapeBox(-6F, 6F, -2F, 3, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F); // Box 285
        wheel_back_right[12].setRotationPoint(-71F, 0F, -17F);

        wheel_back_right[13].addShapeBox(3F, 6F, -2F, 3, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F); // Box 286
        wheel_back_right[13].setRotationPoint(-71F, 0F, -17F);

        wheel_back_right[14].addShapeBox(6F, 3F, -2F, 2, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F); // Box 287
        wheel_back_right[14].setRotationPoint(-71F, 0F, -17F);

        wheel_back_right[15].addBox(-3F, -10F, 0F, 6, 2, 6, 0F); // Box 289
        wheel_back_right[15].setRotationPoint(-71F, 0F, -22.5F);

        wheel_back_right[16].addShapeBox(-6F, -10F, 0F, 3, 2, 6, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F); // Box 290
        wheel_back_right[16].setRotationPoint(-71F, 0F, -22.5F);

        wheel_back_right[17].addShapeBox(-8F, -8F, 0F, 2, 2, 6, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 291
        wheel_back_right[17].setRotationPoint(-71F, 0F, -22.5F);

        wheel_back_right[18].addShapeBox(-10F, -6F, 0F, 2, 3, 6, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 292
        wheel_back_right[18].setRotationPoint(-71F, 0F, -22.5F);

        wheel_back_right[19].addBox(-10F, -3F, 0F, 2, 6, 6, 0F); // Box 293
        wheel_back_right[19].setRotationPoint(-71F, 0F, -22.5F);

        wheel_back_right[20].addShapeBox(-10F, 3F, 0F, 2, 3, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F); // Box 294
        wheel_back_right[20].setRotationPoint(-71F, 0F, -22.5F);

        wheel_back_right[21].addShapeBox(-8F, 6F, 0F, 2, 2, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F); // Box 295
        wheel_back_right[21].setRotationPoint(-71F, 0F, -22.5F);

        wheel_back_right[22].addShapeBox(-6F, 8F, 0F, 3, 2, 6, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 296
        wheel_back_right[22].setRotationPoint(-71F, 0F, -22.5F);

        wheel_back_right[23].addBox(-3F, 8F, 0F, 6, 2, 6, 0F); // Box 297
        wheel_back_right[23].setRotationPoint(-71F, 0F, -22.5F);

        wheel_back_right[24].addShapeBox(3F, -10F, 0F, 3, 2, 6, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F); // Box 298
        wheel_back_right[24].setRotationPoint(-71F, 0F, -22.5F);

        wheel_back_right[25].addShapeBox(6F, -8F, 0F, 2, 2, 6, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 299
        wheel_back_right[25].setRotationPoint(-71F, 0F, -22.5F);

        wheel_back_right[26].addShapeBox(8F, -6F, 0F, 2, 3, 6, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 300
        wheel_back_right[26].setRotationPoint(-71F, 0F, -22.5F);

        wheel_back_right[27].addBox(8F, -3F, 0F, 2, 6, 6, 0F); // Box 301
        wheel_back_right[27].setRotationPoint(-71F, 0F, -22.5F);

        wheel_back_right[28].addShapeBox(8F, 3F, 0F, 2, 3, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F); // Box 302
        wheel_back_right[28].setRotationPoint(-71F, 0F, -22.5F);

        wheel_back_right[29].addShapeBox(6F, 6F, 0F, 2, 2, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F); // Box 303
        wheel_back_right[29].setRotationPoint(-71F, 0F, -22.5F);

        wheel_back_right[30].addShapeBox(3F, 8F, 0F, 3, 2, 6, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F); // Box 304
        wheel_back_right[30].setRotationPoint(-71F, 0F, -22.5F);

        wheel_back_right[31].addBox(7F, -3F, -5F, 1, 6, 4, 0F); // Box 546
        wheel_back_right[31].setRotationPoint(-71F, 0F, -17F);

        wheel_back_right[32].addBox(-8F, -3F, -5F, 1, 6, 4, 0F); // Box 547
        wheel_back_right[32].setRotationPoint(-71F, 0F, -17F);

        wheel_back_right[33].addBox(-3F, -8F, -5F, 6, 1, 4, 0F); // Box 548
        wheel_back_right[33].setRotationPoint(-71F, 0F, -17F);

        wheel_back_right[34].addBox(-3F, 7F, -5F, 6, 1, 4, 0F); // Box 549
        wheel_back_right[34].setRotationPoint(-71F, 0F, -17F);

        wheel_back_right[35].addShapeBox(7F, 3F, -5F, 1, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F); // Box 558
        wheel_back_right[35].setRotationPoint(-71F, 0F, -17F);

        wheel_back_right[36].addShapeBox(7F, -6F, -5F, 1, 3, 4, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 559
        wheel_back_right[36].setRotationPoint(-71F, 0F, -17F);

        wheel_back_right[37].addShapeBox(-8F, -6F, -5F, 1, 3, 4, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 560
        wheel_back_right[37].setRotationPoint(-71F, 0F, -17F);

        wheel_back_right[38].addShapeBox(-8F, 3F, -5F, 1, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F); // Box 561
        wheel_back_right[38].setRotationPoint(-71F, 0F, -17F);

        wheel_back_right[39].addShapeBox(3F, 7F, -5F, 3, 1, 4, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F); // Box 562
        wheel_back_right[39].setRotationPoint(-71F, 0F, -17F);

        wheel_back_right[40].addShapeBox(3F, -8F, -5F, 3, 1, 4, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F); // Box 563
        wheel_back_right[40].setRotationPoint(-71F, 0F, -17F);

        wheel_back_right[41].addShapeBox(-6F, -8F, -5F, 3, 1, 4, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F); // Box 564
        wheel_back_right[41].setRotationPoint(-71F, 0F, -17F);

        wheel_back_right[42].addShapeBox(-6F, 7F, -5F, 3, 1, 4, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 565
        wheel_back_right[42].setRotationPoint(-71F, 0F, -17F);

        wheel_back_right[43].addBox(-2F, -2F, -4F, 4, 4, 3, 0F); // Box 572
        wheel_back_right[43].setRotationPoint(-71F, 0F, -17F);

        wheel_back_right[44].addShapeBox(-2F, -3F, -4F, 4, 1, 3, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 573
        wheel_back_right[44].setRotationPoint(-71F, 0F, -17F);

        wheel_back_right[45].addShapeBox(-2F, 2F, -4F, 4, 1, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 574
        wheel_back_right[45].setRotationPoint(-71F, 0F, -17F);

        wheel_back_right[46].addShapeBox(-3F, -2F, -4F, 1, 4, 3, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 575
        wheel_back_right[46].setRotationPoint(-71F, 0F, -17F);

        wheel_back_right[47].addShapeBox(2F, -2F, -4F, 1, 4, 3, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 576
        wheel_back_right[47].setRotationPoint(-71F, 0F, -17F);

        wheel_back_right[48].addShapeBox(-2F, -3F, -5F, 4, 1, 1, 0F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 586
        wheel_back_right[48].setRotationPoint(-71F, 0F, -17F);

        wheel_back_right[49].addShapeBox(-2F, 2F, -5F, 4, 1, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 587
        wheel_back_right[49].setRotationPoint(-71F, 0F, -17F);

        wheel_back_right[50].addShapeBox(-2F, -2F, -5F, 4, 4, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 588
        wheel_back_right[50].setRotationPoint(-71F, 0F, -17F);

        wheel_back_right[51].addShapeBox(-3F, -2F, -5F, 1, 4, 1, 0F, 0F, -1F, -1F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, -1F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 589
        wheel_back_right[51].setRotationPoint(-71F, 0F, -17F);

        wheel_back_right[52].addShapeBox(-1F, -1F, -5.5F, 2, 2, 1, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F); // Box 590
        wheel_back_right[52].setRotationPoint(-71F, 0F, -17F);

        wheel_back_right[53].addShapeBox(2F, -2F, -5F, 1, 4, 1, 0F, 0F, 0F, -0.5F, 0F, -1F, -1F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, -1F, -1F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 591
        wheel_back_right[53].setRotationPoint(-71F, 0F, -17F);

        wheel_back_right[54].addShapeBox(5F, -2F, -3F, 1, 1, 1, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F); // Box 601
        wheel_back_right[54].setRotationPoint(-71F, 0F, -17F);

        wheel_back_right[55].addShapeBox(5F, 1F, -3F, 1, 1, 1, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F); // Box 602
        wheel_back_right[55].setRotationPoint(-71F, 0F, -17F);

        wheel_back_right[56].addShapeBox(-6F, 1F, -3F, 1, 1, 1, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F); // Box 603
        wheel_back_right[56].setRotationPoint(-71F, 0F, -17F);

        wheel_back_right[57].addShapeBox(-6F, -2F, -3F, 1, 1, 1, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F); // Box 604
        wheel_back_right[57].setRotationPoint(-71F, 0F, -17F);

        wheel_back_right[58].addShapeBox(-2F, -6F, -3F, 1, 1, 1, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F); // Box 605
        wheel_back_right[58].setRotationPoint(-71F, 0F, -17F);

        wheel_back_right[59].addShapeBox(1F, -6F, -3F, 1, 1, 1, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F); // Box 606
        wheel_back_right[59].setRotationPoint(-71F, 0F, -17F);

        wheel_back_right[60].addShapeBox(1F, 5F, -3F, 1, 1, 1, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F); // Box 607
        wheel_back_right[60].setRotationPoint(-71F, 0F, -17F);

        wheel_back_right[61].addShapeBox(-2F, 5F, -3F, 1, 1, 1, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F); // Box 608
        wheel_back_right[61].setRotationPoint(-71F, 0F, -17F);
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
