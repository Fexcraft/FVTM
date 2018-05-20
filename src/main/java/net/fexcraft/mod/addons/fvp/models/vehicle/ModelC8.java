//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2018 Minecraft-SMP.de
// This file is for Fex's Vehicle & Transportation Mod
// Model: C1_R1
// Model Creator: FEX___96
// Created on: 22.08.2016 - 20:40:40
// Last changed on: 04.04.2018
package net.fexcraft.mod.addons.fvp.models.vehicle;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.vehicle.VehicleModel;
import net.fexcraft.mod.lib.tmt.Coord2D;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.tmt.Shape2D;

public class ModelC8 extends VehicleModel<VehicleData> {

    int textureX = 512;
    int textureY = 512;

    public ModelC8(){
        this.creators.add("01e4af9b-2a30-471e-addf-f6338ffce04b");
        body = new ModelRendererTurbo[49];
        body[0] = new ModelRendererTurbo(this, 161, 1, textureX, textureY); // Box 8
        body[1] = new ModelRendererTurbo(this, 433, 1, textureX, textureY); // Box 19
        body[2] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 20
        body[3] = new ModelRendererTurbo(this, 41, 17, textureX, textureY); // Box 26
        body[4] = new ModelRendererTurbo(this, 81, 17, textureX, textureY); // Box 32
        body[5] = new ModelRendererTurbo(this, 209, 25, textureX, textureY); // Box 33
        body[6] = new ModelRendererTurbo(this, 265, 33, textureX, textureY); // Box 34
        body[7] = new ModelRendererTurbo(this, 265, 25, textureX, textureY); // Box 35
        body[8] = new ModelRendererTurbo(this, 1, 57, textureX, textureY); // Box 36
        body[9] = new ModelRendererTurbo(this, 137, 41, textureX, textureY); // Box 37
        body[10] = new ModelRendererTurbo(this, 81, 17, textureX, textureY); // Box 38
        body[11] = new ModelRendererTurbo(this, 137, 17, textureX, textureY); // Box 39
        body[12] = new ModelRendererTurbo(this, 417, 41, textureX, textureY); // Box 40
        body[13] = new ModelRendererTurbo(this, 49, 17, textureX, textureY); // Box 41
        body[14] = new ModelRendererTurbo(this, 169, 17, textureX, textureY); // Box 42
        body[15] = new ModelRendererTurbo(this, 17, 65, textureX, textureY); // Box 49
        body[16] = new ModelRendererTurbo(this, 49, 25, textureX, textureY); // Box 51
        body[17] = new ModelRendererTurbo(this, 161, 17, textureX, textureY); // Box 52
        body[18] = new ModelRendererTurbo(this, 81, 33, textureX, textureY); // Box 53
        body[19] = new ModelRendererTurbo(this, 481, 17, textureX, textureY); // Box 54
        body[20] = new ModelRendererTurbo(this, 497, 17, textureX, textureY); // Box 55
        body[21] = new ModelRendererTurbo(this, 169, 25, textureX, textureY); // Box 56
        body[22] = new ModelRendererTurbo(this, 217, 73, textureX, textureY); // Box 57
        body[23] = new ModelRendererTurbo(this, 65, 81, textureX, textureY); // Box 58
        body[24] = new ModelRendererTurbo(this, 313, 73, textureX, textureY); // Box 59
        body[25] = new ModelRendererTurbo(this, 137, 33, textureX, textureY); // Box 60
        body[26] = new ModelRendererTurbo(this, 265, 33, textureX, textureY); // Box 61
        body[27] = new ModelRendererTurbo(this, 201, 25, textureX, textureY); // Box 62
        body[28] = new ModelRendererTurbo(this, 217, 25, textureX, textureY); // Box 63
        body[29] = new ModelRendererTurbo(this, 393, 25, textureX, textureY); // Box 64
        body[30] = new ModelRendererTurbo(this, 409, 25, textureX, textureY); // Box 65
        body[31] = new ModelRendererTurbo(this, 201, 81, textureX, textureY); // Box 78
        body[32] = new ModelRendererTurbo(this, 409, 81, textureX, textureY); // Box 79
        body[33] = new ModelRendererTurbo(this, 73, 89, textureX, textureY); // Box 80
        body[34] = new ModelRendererTurbo(this, 441, 89, textureX, textureY); // Box 81
        body[35] = new ModelRendererTurbo(this, 105, 97, textureX, textureY); // Box 82
        body[36] = new ModelRendererTurbo(this, 281, 97, textureX, textureY); // Box 83
        body[37] = new ModelRendererTurbo(this, 1, 105, textureX, textureY); // Box 84
        body[38] = new ModelRendererTurbo(this, 33, 113, textureX, textureY); // Box 85
        body[39] = new ModelRendererTurbo(this, 313, 113, textureX, textureY); // Box 86
        body[40] = new ModelRendererTurbo(this, 73, 65, textureX, textureY); // Box 113
        body[41] = new ModelRendererTurbo(this, 457, 81, textureX, textureY); // Box 210
        body[42] = new ModelRendererTurbo(this, 201, 97, textureX, textureY); // Box 212
        body[43] = new ModelRendererTurbo(this, 257, 81, textureX, textureY); // Box 214
        body[44] = new ModelRendererTurbo(this, 337, 81, textureX, textureY); // Box 216
        body[45] = new ModelRendererTurbo(this, 505, 81, textureX, textureY); // Box 256
        body[46] = new ModelRendererTurbo(this, 321, 113, textureX, textureY); // Box 257
        body[47] = new ModelRendererTurbo(this, 33, 89, textureX, textureY); // Box 258
        body[48] = new ModelRendererTurbo(this, 353, 113, textureX, textureY); // Box 259

        body[0].addBox(-1F, -1F, 0F, 2, 2, 34, 0F); // Box 8
        body[0].setRotationPoint(39F, 2F, -17F);

        body[1].addShapeBox(0F, 0F, 0F, 10, 1, 24, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0.5F, 0F); // Box 19
        body[1].setRotationPoint(29F, 3F, -12F);

        body[2].addShapeBox(0F, 0F, 0F, 10, 1, 24, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F); // Box 20
        body[2].setRotationPoint(39F, 3F, -12F);

        body[3].addBox(-1F, -1F, 0F, 2, 2, 34, 0F); // Box 26
        body[3].setRotationPoint(-39F, 2F, -17F);

        body[4].addShapeBox(0F, 0F, 0F, 10, 1, 32, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F); // Box 32
        body[4].setRotationPoint(-49F, 3F, -16F);

        body[5].addShapeBox(0F, 0F, 0F, 10, 1, 32, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, -0.5F, 0F); // Box 33
        body[5].setRotationPoint(-39F, 3F, -16F);

        body[6].addShapeBox(0F, 0F, 0F, 58, 1, 32, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F); // Box 34
        body[6].setRotationPoint(-29F, 3F, -16F);

        body[7].addShapeBox(0F, 0F, 0F, 58, 1, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F); // Box 35
        body[7].setRotationPoint(-29F, 3F, -22F);

        body[8].addShapeBox(0F, 0F, 0F, 58, 1, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 36
        body[8].setRotationPoint(-29F, 3F, 16F);

        body[9].addShapeBox(0F, 0F, 0F, 7, 2, 32, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 37
        body[9].setRotationPoint(49F, 3F, -16F);

        body[10].addShapeBox(0F, 0F, 0F, 7, 2, 6, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 38
        body[10].setRotationPoint(49F, 3F, -22F);

        body[11].addShapeBox(0F, 0F, 0F, 7, 2, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F); // Box 39
        body[11].setRotationPoint(49F, 3F, 16F);

        body[12].addShapeBox(0F, 0F, 0F, 6, 1, 32, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F); // Box 40
        body[12].setRotationPoint(-55F, 3F, -16F);

        body[13].addShapeBox(0F, 0F, 0F, 6, 1, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 1F, 0F); // Box 41
        body[13].setRotationPoint(-55F, 3F, 16F);

        body[14].addShapeBox(0F, 0F, 0F, 6, 1, 6, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F); // Box 42
        body[14].setRotationPoint(-55F, 3F, -22F);

        body[15].addShapeBox(0F, 0F, 0F, 4, 4, 32, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 49
        body[15].setRotationPoint(56F, 1F, -16F);

        body[16].addShapeBox(0F, 0F, 0F, 4, 4, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 2F, -1F, 0F, -2F, 0F, 0F); // Box 51
        body[16].setRotationPoint(54F, 1F, -22F);

        body[17].addShapeBox(0F, 0F, 0F, 4, 4, 1, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 52
        body[17].setRotationPoint(54F, 1F, -23F);

        body[18].addShapeBox(0F, 0F, 0F, 4, 4, 6, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 53
        body[18].setRotationPoint(54F, 1F, 16F);

        body[19].addShapeBox(0F, 0F, 0F, 4, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -2F, -1F, 0F, 0F, 0F, 0F); // Box 54
        body[19].setRotationPoint(54F, 1F, 22F);

        body[20].addShapeBox(0F, 0F, 0F, 6, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 55
        body[20].setRotationPoint(48F, 1F, 22F);

        body[21].addShapeBox(0F, 0F, 0F, 6, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 56
        body[21].setRotationPoint(48F, 1F, -23F);

        body[22].addShapeBox(0F, 0F, 0F, 60, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 57
        body[22].setRotationPoint(-30F, 1F, 22F);

        body[23].addShapeBox(0F, 0F, 0F, 60, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 58
        body[23].setRotationPoint(-30F, 1F, -23F);

        body[24].addShapeBox(0F, 0F, 0F, 4, 4, 32, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 59
        body[24].setRotationPoint(-59F, 1F, -16F);

        body[25].addShapeBox(0F, 0F, 0F, 4, 4, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, -1F, 0F); // Box 60
        body[25].setRotationPoint(-57F, 1F, -22F);

        body[26].addShapeBox(0F, 0F, 0F, 4, 4, 6, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, -1F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 61
        body[26].setRotationPoint(-57F, 1F, 16F);

        body[27].addShapeBox(0F, 0F, 0F, 4, 4, 1, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 62
        body[27].setRotationPoint(-57F, 1F, -23F);

        body[28].addShapeBox(0F, 0F, 0F, 4, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, -1F, 0F); // Box 63
        body[28].setRotationPoint(-57F, 1F, 22F);

        body[29].addShapeBox(0F, 0F, 0F, 5, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F); // Box 64
        body[29].setRotationPoint(-53F, 1F, -23F);

        body[30].addShapeBox(0F, 0F, 0F, 5, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F); // Box 65
        body[30].setRotationPoint(-53F, 1F, 22F);

        body[31].addShapeBox(0F, 0F, 0F, 1, 1, 24, 0F, 0F, -0.4F, 0F, -0.1F, -0.4F, 0F, -0.1F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, -0.1F, -0.4F, 0F, -0.1F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 78
        body[31].setRotationPoint(56F, -2F, -12F);

        body[32].addShapeBox(0F, 0F, 0F, 1, 1, 24, 0F, 0F, -0.4F, 0F, -0.1F, -0.4F, 0F, -0.1F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, -0.1F, -0.4F, 0F, -0.1F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 79
        body[32].setRotationPoint(56F, -3F, -12F);

        body[33].addShapeBox(0F, 0F, 0F, 1, 1, 24, 0F, 0F, -0.4F, 0F, -0.1F, -0.4F, 0F, -0.1F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, -0.1F, -0.4F, 0F, -0.1F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 80
        body[33].setRotationPoint(56F, -4F, -12F);

        body[34].addShapeBox(0F, 0F, 0F, 1, 1, 24, 0F, 0F, -0.4F, 0F, -0.1F, -0.4F, 0F, -0.1F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, -0.1F, -0.4F, 0F, -0.1F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 81
        body[34].setRotationPoint(56F, -5F, -12F);

        body[35].addShapeBox(0F, 0F, 0F, 1, 1, 24, 0F, 0F, -0.4F, 0F, -0.1F, -0.4F, 0F, -0.1F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, -0.1F, -0.4F, 0F, -0.1F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 82
        body[35].setRotationPoint(56F, -1.6F, -12F);

        body[36].addShapeBox(0F, 0F, 0F, 1, 1, 24, 0F, 0F, -0.4F, 0F, -0.1F, -0.4F, 0F, -0.1F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, -0.1F, -0.4F, 0F, -0.1F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 83
        body[36].setRotationPoint(56F, -5.4F, -12F);

        body[37].addShapeBox(0F, 0F, 0F, 1, 1, 24, 0F, 0F, -0.4F, 0F, -0.1F, -0.4F, 0F, -0.1F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, -0.1F, -0.4F, 0F, -0.1F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 84
        body[37].setRotationPoint(56F, -4.5F, -12F);

        body[38].addShapeBox(0F, 0F, 0F, 1, 1, 24, 0F, 0F, -0.4F, 0F, -0.1F, -0.4F, 0F, -0.1F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, -0.1F, -0.4F, 0F, -0.1F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 85
        body[38].setRotationPoint(56F, -2.5F, -12F);

        body[39].addShapeBox(0F, 0F, 0F, 1, 1, 24, 0F, 0F, -0.4F, 0F, -0.1F, -0.4F, 0F, -0.1F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, -0.1F, -0.4F, 0F, -0.1F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 86
        body[39].setRotationPoint(56F, -3.5F, -12F);

        body[40].addBox(0F, 0F, 0F, 1, 3, 12, 0F); // Box 113
        body[40].setRotationPoint(59.2F, 1.5F, -6F);

        body[41].addShapeBox(0F, 0F, 0F, 2, 4, 2, 0F, -0.6F, 0F, 0F, 0.6F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, -0.6F, 0F, 0F, 0.6F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F); // Box 210
        body[41].setRotationPoint(52.8F, -5F, 20F);

        body[42].addShapeBox(0F, 0F, 0F, 2, 4, 2, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0.6F, 0F, 0F, -0.6F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0.6F, 0F, 0F, -0.6F, 0F, 0F); // Box 212
        body[42].setRotationPoint(52.8F, -5F, -22F);

        body[43].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.6F, 0F, -0.2F, -0.6F, 0F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0.6F, 0F, -0.2F, -0.6F, 0F, -0.2F); // Box 214
        body[43].setRotationPoint(-54.4F, -6F, 20F);

        body[44].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F, -0.6F, 0F, -0.2F, 0.6F, 0F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F, -0.6F, 0F, -0.2F, 0.6F, 0F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 216
        body[44].setRotationPoint(-54.4F, -6F, -22F);

        body[45].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F); // Box 256
        body[45].setRotationPoint(25.5F, -12.5F, 21.5F);

        body[46].addBox(0F, 0F, 0F, 1, 3, 4, 0F); // Box 257
        body[46].setRotationPoint(25.5F, -13F, 22.5F);
        body[46].rotateAngleY = -0.20943951F;

        body[47].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F); // Box 258
        body[47].setRotationPoint(25.5F, -12.5F, -23.5F);

        body[48].addBox(0F, 0F, 0F, 1, 3, 4, 0F); // Box 259
        body[48].setRotationPoint(26.5F, -13F, -23F);
        body[48].rotateAngleY = -2.93215314F;
        //
        bodyColoredPrimary = new ModelRendererTurbo[98];
        bodyColoredPrimary[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
        bodyColoredPrimary[1] = new ModelRendererTurbo(this, 49, 1, textureX, textureY); // Shape 1
        bodyColoredPrimary[2] = new ModelRendererTurbo(this, 73, 1, textureX, textureY); // Shape 2
        bodyColoredPrimary[3] = new ModelRendererTurbo(this, 97, 1, textureX, textureY); // Shape 5
        bodyColoredPrimary[4] = new ModelRendererTurbo(this, 121, 1, textureX, textureY); // Shape 6
        bodyColoredPrimary[5] = new ModelRendererTurbo(this, 145, 1, textureX, textureY); // Box 7
        bodyColoredPrimary[6] = new ModelRendererTurbo(this, 241, 1, textureX, textureY); // Shape 14
        bodyColoredPrimary[7] = new ModelRendererTurbo(this, 305, 1, textureX, textureY); // Shape 18
        bodyColoredPrimary[8] = new ModelRendererTurbo(this, 369, 1, textureX, textureY); // Shape 23
        bodyColoredPrimary[9] = new ModelRendererTurbo(this, 433, 1, textureX, textureY); // Shape 25
        bodyColoredPrimary[10] = new ModelRendererTurbo(this, 481, 1, textureX, textureY); // Shape 29
        bodyColoredPrimary[11] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Shape 31
        bodyColoredPrimary[12] = new ModelRendererTurbo(this, 417, 33, textureX, textureY); // Shape 43
        bodyColoredPrimary[13] = new ModelRendererTurbo(this, 465, 33, textureX, textureY); // Shape 44
        bodyColoredPrimary[14] = new ModelRendererTurbo(this, 185, 41, textureX, textureY); // Shape 45
        bodyColoredPrimary[15] = new ModelRendererTurbo(this, 465, 41, textureX, textureY); // Shape 46
        bodyColoredPrimary[16] = new ModelRendererTurbo(this, 465, 49, textureX, textureY); // Box 47
        bodyColoredPrimary[17] = new ModelRendererTurbo(this, 1, 65, textureX, textureY); // Box 48
        bodyColoredPrimary[18] = new ModelRendererTurbo(this, 161, 81, textureX, textureY); // Box 66
        bodyColoredPrimary[19] = new ModelRendererTurbo(this, 505, 1, textureX, textureY); // Box 67
        bodyColoredPrimary[20] = new ModelRendererTurbo(this, 505, 9, textureX, textureY); // Box 68
        bodyColoredPrimary[21] = new ModelRendererTurbo(this, 233, 81, textureX, textureY); // Box 69
        bodyColoredPrimary[22] = new ModelRendererTurbo(this, 361, 81, textureX, textureY); // Box 70
        bodyColoredPrimary[23] = new ModelRendererTurbo(this, 417, 41, textureX, textureY); // Box 71
        bodyColoredPrimary[24] = new ModelRendererTurbo(this, 185, 49, textureX, textureY); // Box 72
        bodyColoredPrimary[25] = new ModelRendererTurbo(this, 137, 57, textureX, textureY); // Box 73
        bodyColoredPrimary[26] = new ModelRendererTurbo(this, 65, 65, textureX, textureY); // Box 74
        bodyColoredPrimary[27] = new ModelRendererTurbo(this, 185, 25, textureX, textureY); // Box 75
        bodyColoredPrimary[28] = new ModelRendererTurbo(this, 233, 25, textureX, textureY); // Box 76
        bodyColoredPrimary[29] = new ModelRendererTurbo(this, 425, 25, textureX, textureY); // Box 77
        bodyColoredPrimary[30] = new ModelRendererTurbo(this, 89, 65, textureX, textureY); // Box 87
        bodyColoredPrimary[31] = new ModelRendererTurbo(this, 113, 65, textureX, textureY); // Box 88
        bodyColoredPrimary[32] = new ModelRendererTurbo(this, 1, 33, textureX, textureY); // Box 89
        bodyColoredPrimary[33] = new ModelRendererTurbo(this, 97, 33, textureX, textureY); // Box 90
        bodyColoredPrimary[34] = new ModelRendererTurbo(this, 281, 33, textureX, textureY); // Box 91
        bodyColoredPrimary[35] = new ModelRendererTurbo(this, 433, 41, textureX, textureY); // Box 92
        bodyColoredPrimary[36] = new ModelRendererTurbo(this, 1, 49, textureX, textureY); // Box 93
        bodyColoredPrimary[37] = new ModelRendererTurbo(this, 17, 49, textureX, textureY); // Box 94
        bodyColoredPrimary[38] = new ModelRendererTurbo(this, 0, 134, textureX, textureY); // Shape 95
        bodyColoredPrimary[39] = new ModelRendererTurbo(this, 0, 148, textureX, textureY); // Shape 96
        bodyColoredPrimary[40] = new ModelRendererTurbo(this, 0, 140, textureX, textureY); // Shape 97
        bodyColoredPrimary[41] = new ModelRendererTurbo(this, 0, 156, textureX, textureY); // Shape 98
        bodyColoredPrimary[42] = new ModelRendererTurbo(this, 0, 188, textureX, textureY); // Shape 99
        bodyColoredPrimary[43] = new ModelRendererTurbo(this, 0, 172, textureX, textureY); // Shape 100
        bodyColoredPrimary[44] = new ModelRendererTurbo(this, 0, 180, textureX, textureY); // Shape 101
        bodyColoredPrimary[45] = new ModelRendererTurbo(this, 0, 164, textureX, textureY); // Shape 102
        bodyColoredPrimary[46] = new ModelRendererTurbo(this, 57, 121, textureX, textureY); // Box 103
        bodyColoredPrimary[47] = new ModelRendererTurbo(this, 361, 73, textureX, textureY); // Box 106
        bodyColoredPrimary[48] = new ModelRendererTurbo(this, 489, 73, textureX, textureY); // Box 107
        bodyColoredPrimary[49] = new ModelRendererTurbo(this, 433, 49, textureX, textureY); // Box 108
        bodyColoredPrimary[50] = new ModelRendererTurbo(this, 1, 81, textureX, textureY); // Box 109
        bodyColoredPrimary[51] = new ModelRendererTurbo(this, 17, 81, textureX, textureY); // Box 110
        bodyColoredPrimary[52] = new ModelRendererTurbo(this, 201, 81, textureX, textureY); // Box 111
        bodyColoredPrimary[53] = new ModelRendererTurbo(this, 233, 81, textureX, textureY); // Box 114
        bodyColoredPrimary[54] = new ModelRendererTurbo(this, 273, 81, textureX, textureY); // Box 115
        bodyColoredPrimary[55] = new ModelRendererTurbo(this, 169, 121, textureX, textureY); // Box 117
        bodyColoredPrimary[56] = new ModelRendererTurbo(this, 425, 121, textureX, textureY); // Box 118
        bodyColoredPrimary[57] = new ModelRendererTurbo(this, 241, 129, textureX, textureY); // Box 119
        bodyColoredPrimary[58] = new ModelRendererTurbo(this, 209, 49, textureX, textureY); // Box 120
        bodyColoredPrimary[59] = new ModelRendererTurbo(this, 265, 49, textureX, textureY); // Box 121
        bodyColoredPrimary[60] = new ModelRendererTurbo(this, 425, 137, textureX, textureY); // Box 122
        bodyColoredPrimary[61] = new ModelRendererTurbo(this, 185, 65, textureX, textureY); // Box 123
        bodyColoredPrimary[62] = new ModelRendererTurbo(this, 105, 89, textureX, textureY); // Box 124
        bodyColoredPrimary[63] = new ModelRendererTurbo(this, 273, 145, textureX, textureY); // Box 127
        bodyColoredPrimary[64] = new ModelRendererTurbo(this, 73, 161, textureX, textureY); // Box 128
        bodyColoredPrimary[65] = new ModelRendererTurbo(this, 377, 81, textureX, textureY); // Box 129
        bodyColoredPrimary[66] = new ModelRendererTurbo(this, 409, 81, textureX, textureY); // Box 130
        bodyColoredPrimary[67] = new ModelRendererTurbo(this, 441, 81, textureX, textureY); // Box 131
        bodyColoredPrimary[68] = new ModelRendererTurbo(this, 473, 81, textureX, textureY); // Box 132
        bodyColoredPrimary[69] = new ModelRendererTurbo(this, 337, 177, textureX, textureY); // Box 133
        bodyColoredPrimary[70] = new ModelRendererTurbo(this, 193, 169, textureX, textureY); // Box 134
        bodyColoredPrimary[71] = new ModelRendererTurbo(this, 1, 201, textureX, textureY); // Box 135
        bodyColoredPrimary[72] = new ModelRendererTurbo(this, 233, 41, textureX, textureY); // Box 138
        bodyColoredPrimary[73] = new ModelRendererTurbo(this, 289, 41, textureX, textureY); // Box 139
        bodyColoredPrimary[74] = new ModelRendererTurbo(this, 129, 57, textureX, textureY); // Box 145
        bodyColoredPrimary[75] = new ModelRendererTurbo(this, 153, 57, textureX, textureY); // Box 146
        bodyColoredPrimary[76] = new ModelRendererTurbo(this, 321, 81, textureX, textureY); // Box 147
        bodyColoredPrimary[77] = new ModelRendererTurbo(this, 505, 65, textureX, textureY); // Box 148
        bodyColoredPrimary[78] = new ModelRendererTurbo(this, 169, 89, textureX, textureY); // Box 149
        bodyColoredPrimary[79] = new ModelRendererTurbo(this, 361, 89, textureX, textureY); // Box 150
        bodyColoredPrimary[80] = new ModelRendererTurbo(this, 489, 89, textureX, textureY); // Box 151
        bodyColoredPrimary[81] = new ModelRendererTurbo(this, 1, 97, textureX, textureY); // Box 152
        bodyColoredPrimary[82] = new ModelRendererTurbo(this, 105, 97, textureX, textureY); // Box 153
        bodyColoredPrimary[83] = new ModelRendererTurbo(this, 41, 81, textureX, textureY); // Box 154
        bodyColoredPrimary[84] = new ModelRendererTurbo(this, 65, 25, textureX, textureY); // Box 155
        bodyColoredPrimary[85] = new ModelRendererTurbo(this, 417, 57, textureX, textureY); // Box 156
        bodyColoredPrimary[86] = new ModelRendererTurbo(this, 1, 145, textureX, textureY); // Box 157
        bodyColoredPrimary[87] = new ModelRendererTurbo(this, 329, 161, textureX, textureY); // Box 158
        bodyColoredPrimary[88] = new ModelRendererTurbo(this, 137, 97, textureX, textureY); // Shape 160
        bodyColoredPrimary[89] = new ModelRendererTurbo(this, 273, 97, textureX, textureY); // Shape 161
        bodyColoredPrimary[90] = new ModelRendererTurbo(this, 33, 105, textureX, textureY); // Shape 162
        bodyColoredPrimary[91] = new ModelRendererTurbo(this, 1, 113, textureX, textureY); // Shape 163
        bodyColoredPrimary[92] = new ModelRendererTurbo(this, 65, 121, textureX, textureY); // Shape 164
        bodyColoredPrimary[93] = new ModelRendererTurbo(this, 241, 121, textureX, textureY); // Shape 165
        bodyColoredPrimary[94] = new ModelRendererTurbo(this, 345, 121, textureX, textureY); // Shape 166
        bodyColoredPrimary[95] = new ModelRendererTurbo(this, 137, 129, textureX, textureY); // Shape 167
        bodyColoredPrimary[96] = new ModelRendererTurbo(this, 465, 65, textureX, textureY); // Shape 168
        bodyColoredPrimary[97] = new ModelRendererTurbo(this, 385, 73, textureX, textureY); // Shape 169

        bodyColoredPrimary[0].addBox(0F, 0F, 0F, 20, 7, 1, 0F); // Box 0
        bodyColoredPrimary[0].setRotationPoint(29F, -4F, -12F);

        bodyColoredPrimary[1].addShape3D(0F, 0F, 0F, new Shape2D(new Coord2D[]{new Coord2D(0, 0, 0, 0), new Coord2D(8, 0, 8, 0), new Coord2D(8, 3, 8, 3)}), 10, 8, 3, 20, 10, ModelRendererTurbo.MR_FRONT, new float[]{9, 3, 8}); // Shape 1
        bodyColoredPrimary[1].setRotationPoint(29F, 4F, -12F);
        bodyColoredPrimary[1].rotateAngleZ = -1.57079633F;

        bodyColoredPrimary[2].addShape3D(0F, 0F, 0F, new Shape2D(new Coord2D[]{new Coord2D(0, 0, 0, 0), new Coord2D(3, 0, 3, 0), new Coord2D(8, 4, 8, 4), new Coord2D(5, 4, 5, 4)}), 10, 8, 4, 20, 10, ModelRendererTurbo.MR_FRONT, new float[]{7, 3, 7, 3}); // Shape 2
        bodyColoredPrimary[2].setRotationPoint(29F, -4F, -22F);
        bodyColoredPrimary[2].rotateAngleY = -3.14159265F;

        bodyColoredPrimary[3].addShape3D(0F, 0F, 0F, new Shape2D(new Coord2D[]{new Coord2D(0, 0, 0, 0), new Coord2D(10, 0, 10, 0), new Coord2D(7, 1, 7, 1), new Coord2D(3, 1, 3, 1)}), 10, 10, 1, 22, 10, ModelRendererTurbo.MR_FRONT, new float[]{4, 4, 4, 10}); // Shape 5
        bodyColoredPrimary[3].setRotationPoint(34F, -8F, -22F);
        bodyColoredPrimary[3].rotateAngleY = -3.14159265F;

        bodyColoredPrimary[4].addShape3D(0F, 0F, 0F, new Shape2D(new Coord2D[]{new Coord2D(0, 0, 0, 0), new Coord2D(8, 0, 8, 0), new Coord2D(8, 3, 8, 3)}), 10, 8, 3, 20, 10, ModelRendererTurbo.MR_FRONT, new float[]{9, 3, 8}); // Shape 6
        bodyColoredPrimary[4].setRotationPoint(49F, 4F, -22F);
        bodyColoredPrimary[4].rotateAngleY = -3.14159265F;
        bodyColoredPrimary[4].rotateAngleZ = -1.57079633F;

        bodyColoredPrimary[5].addBox(0F, 0F, 0F, 20, 7, 1, 0F); // Box 7
        bodyColoredPrimary[5].setRotationPoint(29F, -4F, 11F);

        bodyColoredPrimary[6].addShape3D(0F, 0F, 0F, new Shape2D(new Coord2D[]{new Coord2D(0, 0, 0, 0), new Coord2D(8, 0, 8, 0), new Coord2D(8, 3, 8, 3)}), 10, 8, 3, 20, 10, ModelRendererTurbo.MR_FRONT, new float[]{9, 3, 8}); // Shape 14
        bodyColoredPrimary[6].setRotationPoint(29F, 4F, 22F);
        bodyColoredPrimary[6].rotateAngleZ = -1.57079633F;

        bodyColoredPrimary[7].addShape3D(0F, 0F, 0F, new Shape2D(new Coord2D[]{new Coord2D(0, 0, 0, 0), new Coord2D(8, 0, 8, 0), new Coord2D(8, 3, 8, 3)}), 10, 8, 3, 20, 10, ModelRendererTurbo.MR_FRONT, new float[]{9, 3, 8}); // Shape 18
        bodyColoredPrimary[7].setRotationPoint(49F, 4F, 12F);
        bodyColoredPrimary[7].rotateAngleY = -3.14159265F;
        bodyColoredPrimary[7].rotateAngleZ = -1.57079633F;

        bodyColoredPrimary[8].addShape3D(0F, 0F, 0F, new Shape2D(new Coord2D[]{new Coord2D(0, 0, 0, 0), new Coord2D(8, 0, 8, 0), new Coord2D(8, 3, 8, 3)}), 6, 8, 3, 20, 6, ModelRendererTurbo.MR_FRONT, new float[]{9, 3, 8}); // Shape 23
        bodyColoredPrimary[8].setRotationPoint(-49F, 4F, -16F);
        bodyColoredPrimary[8].rotateAngleZ = -1.57079633F;

        bodyColoredPrimary[9].addShape3D(0F, 0F, 0F, new Shape2D(new Coord2D[]{new Coord2D(0, 0, 0, 0), new Coord2D(8, 0, 8, 0), new Coord2D(8, 3, 8, 3)}), 6, 8, 3, 20, 6, ModelRendererTurbo.MR_FRONT, new float[]{9, 3, 8}); // Shape 25
        bodyColoredPrimary[9].setRotationPoint(-29F, 4F, -22F);
        bodyColoredPrimary[9].rotateAngleY = -3.14159265F;
        bodyColoredPrimary[9].rotateAngleZ = -1.57079633F;

        bodyColoredPrimary[10].addShape3D(0F, 0F, 0F, new Shape2D(new Coord2D[]{new Coord2D(0, 0, 0, 0), new Coord2D(8, 0, 8, 0), new Coord2D(8, 3, 8, 3)}), 6, 8, 3, 20, 6, ModelRendererTurbo.MR_FRONT, new float[]{9, 3, 8}); // Shape 29
        bodyColoredPrimary[10].setRotationPoint(-49F, 4F, 22F);
        bodyColoredPrimary[10].rotateAngleZ = -1.57079633F;

        bodyColoredPrimary[11].addShape3D(0F, 0F, 0F, new Shape2D(new Coord2D[]{new Coord2D(0, 0, 0, 0), new Coord2D(8, 0, 8, 0), new Coord2D(8, 3, 8, 3)}), 6, 8, 3, 20, 6, ModelRendererTurbo.MR_FRONT, new float[]{9, 3, 8}); // Shape 31
        bodyColoredPrimary[11].setRotationPoint(-29F, 4F, 16F);
        bodyColoredPrimary[11].rotateAngleY = -3.14159265F;
        bodyColoredPrimary[11].rotateAngleZ = -1.57079633F;

        bodyColoredPrimary[12].addShape3D(0F, 0F, 0F, new Shape2D(new Coord2D[]{new Coord2D(0, 0, 0, 0), new Coord2D(20, 0, 20, 0), new Coord2D(15, 4, 15, 4), new Coord2D(12, 5, 12, 5), new Coord2D(8, 5, 8, 5), new Coord2D(5, 4, 5, 4)}), 1, 20, 5, 46, 1, ModelRendererTurbo.MR_FRONT, new float[]{7, 4, 4, 4, 7, 20}); // Shape 43
        bodyColoredPrimary[12].setRotationPoint(49F, -4F, -11F);

        bodyColoredPrimary[13].addShape3D(0F, 0F, 0F, new Shape2D(new Coord2D[]{new Coord2D(0, 0, 0, 0), new Coord2D(20, 0, 20, 0), new Coord2D(15, 4, 15, 4), new Coord2D(12, 5, 12, 5), new Coord2D(8, 5, 8, 5), new Coord2D(5, 4, 5, 4)}), 1, 20, 5, 46, 1, ModelRendererTurbo.MR_FRONT, new float[]{7, 4, 4, 4, 7, 20}); // Shape 44
        bodyColoredPrimary[13].setRotationPoint(49F, -4F, 12F);

        bodyColoredPrimary[14].addShape3D(0F, 0F, 0F, new Shape2D(new Coord2D[]{new Coord2D(0, 0, 0, 0), new Coord2D(20, 0, 20, 0), new Coord2D(15, 4, 15, 4), new Coord2D(12, 5, 12, 5), new Coord2D(8, 5, 8, 5), new Coord2D(5, 4, 5, 4)}), 1, 20, 5, 46, 1, ModelRendererTurbo.MR_FRONT, new float[]{7, 4, 4, 4, 7, 20}); // Shape 45
        bodyColoredPrimary[14].setRotationPoint(-29F, -4F, 16F);

        bodyColoredPrimary[15].addShape3D(0F, 0F, 0F, new Shape2D(new Coord2D[]{new Coord2D(0, 0, 0, 0), new Coord2D(20, 0, 20, 0), new Coord2D(15, 4, 15, 4), new Coord2D(12, 5, 12, 5), new Coord2D(8, 5, 8, 5), new Coord2D(5, 4, 5, 4)}), 1, 20, 5, 46, 1, ModelRendererTurbo.MR_FRONT, new float[]{7, 4, 4, 4, 7, 20}); // Shape 46
        bodyColoredPrimary[15].setRotationPoint(-29F, -4F, -15F);

        bodyColoredPrimary[16].addBox(0F, 0F, 0F, 20, 7, 1, 0F); // Box 47
        bodyColoredPrimary[16].setRotationPoint(-49F, -4F, 15F);

        bodyColoredPrimary[17].addBox(0F, 0F, 0F, 20, 7, 1, 0F); // Box 48
        bodyColoredPrimary[17].setRotationPoint(-49F, -4F, -16F);

        bodyColoredPrimary[18].addShapeBox(0F, 0F, 0F, 2, 2, 32, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 66
        bodyColoredPrimary[18].setRotationPoint(56F, -1F, -16F);

        bodyColoredPrimary[19].addBox(0F, 0F, 0F, 1, 4, 2, 0F); // Box 67
        bodyColoredPrimary[19].setRotationPoint(56F, -5F, -14F);

        bodyColoredPrimary[20].addBox(0F, 0F, 0F, 1, 4, 2, 0F); // Box 68
        bodyColoredPrimary[20].setRotationPoint(56F, -5F, 12F);

        bodyColoredPrimary[21].addShapeBox(0F, 0F, 0F, 2, 2, 32, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F); // Box 69
        bodyColoredPrimary[21].setRotationPoint(56F, -7F, -16F);

        bodyColoredPrimary[22].addShapeBox(0F, 0F, 0F, 4, 2, 32, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 70
        bodyColoredPrimary[22].setRotationPoint(54F, -9F, -16F);

        bodyColoredPrimary[23].addShapeBox(0F, 0F, 0F, 2, 2, 6, 0F, 2F, 0F, 0F, -3F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 71
        bodyColoredPrimary[23].setRotationPoint(56F, -1F, -22F);

        bodyColoredPrimary[24].addShapeBox(0F, 0F, 0F, 2, 2, 6, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -3F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F); // Box 72
        bodyColoredPrimary[24].setRotationPoint(56F, -7F, -22F);

        bodyColoredPrimary[25].addShapeBox(0F, 0F, 0F, 2, 2, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -3F, 0F, 0F, 2F, 0F, 0F); // Box 73
        bodyColoredPrimary[25].setRotationPoint(56F, -7F, 16F);

        bodyColoredPrimary[26].addShapeBox(0F, 0F, 0F, 2, 2, 6, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -3F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F); // Box 74
        bodyColoredPrimary[26].setRotationPoint(56F, -1F, 16F);

        bodyColoredPrimary[27].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F); // Box 75
        bodyColoredPrimary[27].setRotationPoint(56F, -5F, 1F);

        bodyColoredPrimary[28].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 76
        bodyColoredPrimary[28].setRotationPoint(56F, -5F, -3F);

        bodyColoredPrimary[29].addBox(0F, 0F, 0F, 1, 4, 2, 0F); // Box 77
        bodyColoredPrimary[29].setRotationPoint(56F, -5F, -1F);

        bodyColoredPrimary[30].addShapeBox(0F, 0F, 0F, 4, 2, 6, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 87
        bodyColoredPrimary[30].setRotationPoint(54F, -9F, -22F);

        bodyColoredPrimary[31].addShapeBox(0F, 0F, 0F, 4, 2, 6, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F); // Box 88
        bodyColoredPrimary[31].setRotationPoint(54F, -9F, 16F);

        bodyColoredPrimary[32].addShapeBox(0F, 0F, 0F, 5, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 89
        bodyColoredPrimary[32].setRotationPoint(49F, -1F, 21F);

        bodyColoredPrimary[33].addShapeBox(0F, 0F, 0F, 5, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 90
        bodyColoredPrimary[33].setRotationPoint(49F, -9F, 21F);

        bodyColoredPrimary[34].addShapeBox(0F, 0F, 0F, 4, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 91
        bodyColoredPrimary[34].setRotationPoint(49F, -5F, 21F);

        bodyColoredPrimary[35].addShapeBox(0F, 0F, 0F, 5, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 92
        bodyColoredPrimary[35].setRotationPoint(49F, -1F, -22F);

        bodyColoredPrimary[36].addShapeBox(0F, 0F, 0F, 4, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 93
        bodyColoredPrimary[36].setRotationPoint(49F, -5F, -22F);

        bodyColoredPrimary[37].addShapeBox(0F, 0F, 0F, 5, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 94
        bodyColoredPrimary[37].setRotationPoint(49F, -9F, -22F);

        bodyColoredPrimary[38].addShape3D(0F, 0F, 0F, new Shape2D(new Coord2D[]{new Coord2D(0, 0, 0, 0), new Coord2D(5, 4, 5, 4), new Coord2D(8, 5, 8, 5), new Coord2D(0, 5, 0, 5)}), 1, 8, 5, 24, 1, ModelRendererTurbo.MR_FRONT, new float[]{5, 8, 4, 7}); // Shape 95
        bodyColoredPrimary[38].setRotationPoint(49F, -4F, 22F);

        bodyColoredPrimary[39].addShape3D(0F, 0F, 0F, new Shape2D(new Coord2D[]{new Coord2D(0, 0, 0, 0), new Coord2D(5, 4, 5, 4), new Coord2D(8, 5, 8, 5), new Coord2D(0, 5, 0, 5)}), 1, 8, 5, 24, 1, ModelRendererTurbo.MR_FRONT, new float[]{5, 8, 4, 7}); // Shape 96
        bodyColoredPrimary[39].setRotationPoint(49F, -4F, -21F);

        bodyColoredPrimary[40].addShape3D(0F, 0F, 0F, new Shape2D(new Coord2D[]{new Coord2D(0, 0, 0, 0), new Coord2D(5, 4, 5, 4), new Coord2D(8, 5, 8, 5), new Coord2D(0, 5, 0, 5)}), 1, 8, 5, 24, 1, ModelRendererTurbo.MR_FRONT, new float[]{5, 8, 4, 7}); // Shape 97
        bodyColoredPrimary[40].setRotationPoint(29F, -4F, 21F);
        bodyColoredPrimary[40].rotateAngleY = -3.14159265F;

        bodyColoredPrimary[41].addShape3D(0F, 0F, 0F, new Shape2D(new Coord2D[]{new Coord2D(0, 0, 0, 0), new Coord2D(5, 4, 5, 4), new Coord2D(8, 5, 8, 5), new Coord2D(0, 5, 0, 5)}), 1, 8, 5, 24, 1, ModelRendererTurbo.MR_FRONT, new float[]{5, 8, 4, 7}); // Shape 98
        bodyColoredPrimary[41].setRotationPoint(29F, -4F, -22F);
        bodyColoredPrimary[41].rotateAngleY = -3.14159265F;

        bodyColoredPrimary[42].addShape3D(0F, 0F, 0F, new Shape2D(new Coord2D[]{new Coord2D(0, 0, 0, 0), new Coord2D(5, 4, 5, 4), new Coord2D(8, 5, 8, 5), new Coord2D(0, 5, 0, 5)}), 1, 8, 5, 24, 1, ModelRendererTurbo.MR_FRONT, new float[]{5, 8, 4, 7}); // Shape 99
        bodyColoredPrimary[42].setRotationPoint(-49F, -4F, 21F);
        bodyColoredPrimary[42].rotateAngleY = -3.14159265F;

        bodyColoredPrimary[43].addShape3D(0F, 0F, 0F, new Shape2D(new Coord2D[]{new Coord2D(0, 0, 0, 0), new Coord2D(5, 4, 5, 4), new Coord2D(8, 5, 8, 5), new Coord2D(0, 5, 0, 5)}), 1, 8, 5, 24, 1, ModelRendererTurbo.MR_FRONT, new float[]{5, 8, 4, 7}); // Shape 100
        bodyColoredPrimary[43].setRotationPoint(-49F, -4F, -22F);
        bodyColoredPrimary[43].rotateAngleY = -3.14159265F;

        bodyColoredPrimary[44].addShape3D(0F, 0F, 0F, new Shape2D(new Coord2D[]{new Coord2D(0, 0, 0, 0), new Coord2D(5, 4, 5, 4), new Coord2D(8, 5, 8, 5), new Coord2D(0, 5, 0, 5)}), 1, 8, 5, 24, 1, ModelRendererTurbo.MR_FRONT, new float[]{5, 8, 4, 7}); // Shape 101
        bodyColoredPrimary[44].setRotationPoint(-29F, -4F, 22F);

        bodyColoredPrimary[45].addShape3D(0F, 0F, 0F, new Shape2D(new Coord2D[]{new Coord2D(0, 0, 0, 0), new Coord2D(5, 4, 5, 4), new Coord2D(8, 5, 8, 5), new Coord2D(0, 5, 0, 5)}), 1, 8, 5, 24, 1, ModelRendererTurbo.MR_FRONT, new float[]{5, 8, 4, 7}); // Shape 102
        bodyColoredPrimary[45].setRotationPoint(-29F, -4F, -21F);

        bodyColoredPrimary[46].addShapeBox(0F, 0F, 0F, 2, 3, 32, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 103
        bodyColoredPrimary[46].setRotationPoint(-57F, -2F, -16F);

        bodyColoredPrimary[47].addShapeBox(0F, 0F, 0F, 2, 3, 6, 0F, -3F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 106
        bodyColoredPrimary[47].setRotationPoint(-57F, -2F, -22F);

        bodyColoredPrimary[48].addShapeBox(0F, 0F, 0F, 2, 3, 6, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 107
        bodyColoredPrimary[48].setRotationPoint(-57F, -9F, -22F);

        bodyColoredPrimary[49].addShapeBox(0F, 0F, 0F, 4, 12, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 108
        bodyColoredPrimary[49].setRotationPoint(-53F, -9F, -22F);

        bodyColoredPrimary[50].addShapeBox(0F, 0F, 0F, 4, 12, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 109
        bodyColoredPrimary[50].setRotationPoint(-53F, -9F, 21F);

        bodyColoredPrimary[51].addShapeBox(0F, 0F, 0F, 2, 3, 6, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F); // Box 110
        bodyColoredPrimary[51].setRotationPoint(-57F, -2F, 16F);

        bodyColoredPrimary[52].addShapeBox(0F, 0F, 0F, 2, 3, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -3F, 0F, 0F); // Box 111
        bodyColoredPrimary[52].setRotationPoint(-57F, -9F, 16F);

        bodyColoredPrimary[53].addShapeBox(0F, 0F, 0F, 4, 2, 6, 0F, -1F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, -1F, -3F, 0F, -1F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F); // Box 114
        bodyColoredPrimary[53].setRotationPoint(-57F, -11F, 16F);

        bodyColoredPrimary[54].addShapeBox(0F, 0F, 0F, 4, 2, 6, 0F, -3F, 0F, -1F, 2F, 0F, -1F, 2F, 0F, 0F, -1F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F); // Box 115
        bodyColoredPrimary[54].setRotationPoint(-57F, -11F, -22F);

        bodyColoredPrimary[55].addShapeBox(0F, 0F, 0F, 22, 2, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 117
        bodyColoredPrimary[55].setRotationPoint(-51F, -11F, 16F);

        bodyColoredPrimary[56].addShapeBox(0F, 0F, 0F, 22, 2, 6, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 118
        bodyColoredPrimary[56].setRotationPoint(-51F, -11F, -22F);

        bodyColoredPrimary[57].addShapeBox(0F, 0F, 0F, 2, 2, 32, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 2F); // Box 119
        bodyColoredPrimary[57].setRotationPoint(-31F, -12F, -16F);

        bodyColoredPrimary[58].addShapeBox(0F, 0F, 0F, 6, 1, 6, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -3F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F); // Box 120
        bodyColoredPrimary[58].setRotationPoint(51F, -10F, 16F);

        bodyColoredPrimary[59].addShapeBox(0F, 0F, 0F, 6, 1, 6, 0F, 0F, 0F, -1F, -3F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 121
        bodyColoredPrimary[59].setRotationPoint(51F, -10F, -22F);

        bodyColoredPrimary[60].addShapeBox(0F, 0F, 0F, 6, 1, 32, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 122
        bodyColoredPrimary[60].setRotationPoint(51F, -10F, -16F);

        bodyColoredPrimary[61].addShapeBox(0F, 0F, 0F, 22, 1, 6, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 123
        bodyColoredPrimary[61].setRotationPoint(29F, -10F, -22F);

        bodyColoredPrimary[62].addShapeBox(0F, 0F, 0F, 22, 1, 6, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 124
        bodyColoredPrimary[62].setRotationPoint(29F, -10F, 16F);

        bodyColoredPrimary[63].addBox(0F, 0F, 0F, 4, 13, 44, 0F); // Box 127
        bodyColoredPrimary[63].setRotationPoint(25F, -10F, -22F);

        bodyColoredPrimary[64].addBox(0F, 0F, 0F, 13, 12, 44, 0F); // Box 128
        bodyColoredPrimary[64].setRotationPoint(-29F, -9F, -22F);

        bodyColoredPrimary[65].addShapeBox(0F, 0F, 0F, 2, 13, 4, 0F, 12F, 0F, 2F, -12F, 0F, 2F, -12F, 0F, -2F, 12F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 129
        bodyColoredPrimary[65].setRotationPoint(27F, -23F, 18F);

        bodyColoredPrimary[66].addShapeBox(0F, 0F, 0F, 2, 13, 4, 0F, 12F, 0F, -2F, -12F, 0F, -2F, -12F, 0F, 2F, 12F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 130
        bodyColoredPrimary[66].setRotationPoint(27F, -23F, -22F);

        bodyColoredPrimary[67].addShapeBox(0F, 0F, 0F, 2, 12, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 12F, 0F, -1F, -12F, 0F, -1F, -12F, 0F, 1F, 12F, 0F, 1F); // Box 131
        bodyColoredPrimary[67].setRotationPoint(-19F, -23F, 16F);

        bodyColoredPrimary[68].addShapeBox(0F, 0F, 0F, 2, 12, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 12F, 0F, 1F, -12F, 0F, 1F, -12F, 0F, -1F, 12F, 0F, -1F); // Box 132
        bodyColoredPrimary[68].setRotationPoint(-19F, -23F, -20F);

        bodyColoredPrimary[69].addShapeBox(0F, 0F, 0F, 36, 2, 40, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 133
        bodyColoredPrimary[69].setRotationPoint(-19F, -24F, -20F);

        bodyColoredPrimary[70].addShapeBox(0F, 0F, 0F, 4, 1, 44, 0F, 0F, 0F, 0F, 0F, -0.9F, 0F, 0F, -0.9F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 134
        bodyColoredPrimary[70].setRotationPoint(29F, -10F, -22F);

        bodyColoredPrimary[71].addShapeBox(0F, 0F, 0F, 13, 2, 44, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 135
        bodyColoredPrimary[71].setRotationPoint(-29F, -11F, -22F);

        bodyColoredPrimary[72].addShapeBox(0F, 0F, 0F, 2, 11, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F); // Box 138
        bodyColoredPrimary[72].setRotationPoint(-18F, -22F, 19F);

        bodyColoredPrimary[73].addShapeBox(0F, 0F, 0F, 2, 11, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 139
        bodyColoredPrimary[73].setRotationPoint(-18F, -22F, -20F);

        bodyColoredPrimary[74].addShapeBox(0F, 0F, 0F, 4, 2, 1, 0F, 0F, 0.2F, -0.3F, -1.85F, 0F, -0.3F, -1.85F, 0F, 0.3F, 0F, 0.2F, 0.3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 145
        bodyColoredPrimary[74].setRotationPoint(25F, -12F, -22F);

        bodyColoredPrimary[75].addShapeBox(0F, 0F, 0F, 4, 2, 1, 0F, 0F, 0.2F, 0.3F, -1.85F, 0F, 0.3F, -1.85F, 0F, -0.3F, 0F, 0.2F, -0.3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 146
        bodyColoredPrimary[75].setRotationPoint(25F, -12F, 21F);

        bodyColoredPrimary[76].addShapeBox(0F, 0F, 0F, 4, 11, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F); // Box 147
        bodyColoredPrimary[76].setRotationPoint(0F, -22F, 18F);

        bodyColoredPrimary[77].addShapeBox(0F, 0F, 0F, 2, 11, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F); // Box 148
        bodyColoredPrimary[77].setRotationPoint(1F, -22F, 19F);

        bodyColoredPrimary[78].addBox(0F, 0F, 0F, 4, 14, 1, 0F); // Box 149
        bodyColoredPrimary[78].setRotationPoint(0F, -11F, 19F);

        bodyColoredPrimary[79].addBox(0F, 0F, 0F, 2, 10, 2, 0F); // Box 150
        bodyColoredPrimary[79].setRotationPoint(1F, -9F, 20F);

        bodyColoredPrimary[80].addBox(0F, 0F, 0F, 4, 14, 1, 0F); // Box 151
        bodyColoredPrimary[80].setRotationPoint(0F, -11F, -20F);

        bodyColoredPrimary[81].addBox(0F, 0F, 0F, 2, 12, 2, 0F); // Box 152
        bodyColoredPrimary[81].setRotationPoint(1F, -9F, -22F);

        bodyColoredPrimary[82].addShapeBox(0F, 0F, 0F, 4, 11, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 153
        bodyColoredPrimary[82].setRotationPoint(0F, -22F, -19F);

        bodyColoredPrimary[83].addShapeBox(0F, 0F, 0F, 2, 11, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 154
        bodyColoredPrimary[83].setRotationPoint(1F, -22F, -20F);

        bodyColoredPrimary[84].addShapeBox(0F, 0F, 0F, 2, 2, 2, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 155
        bodyColoredPrimary[84].setRotationPoint(1F, -11F, -22F);

        bodyColoredPrimary[85].addShapeBox(0F, 0F, 0F, 2, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 156
        bodyColoredPrimary[85].setRotationPoint(1F, -11F, 20F);

        bodyColoredPrimary[86].addShapeBox(0F, 0F, 0F, 41, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 157
        bodyColoredPrimary[86].setRotationPoint(-16F, 1F, 20F);

        bodyColoredPrimary[87].addShapeBox(0F, 0F, 0F, 41, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F); // Box 158
        bodyColoredPrimary[87].setRotationPoint(-16F, 1F, -22F);

        bodyColoredPrimary[88].addShape3D(0F, 0F, 0F, new Shape2D(new Coord2D[]{new Coord2D(0, 0, 0, 0), new Coord2D(3, 0, 3, 0), new Coord2D(8, 4, 8, 4), new Coord2D(5, 4, 5, 4)}), 10, 8, 4, 20, 10, ModelRendererTurbo.MR_FRONT, new float[]{7, 3, 7, 3}); // Shape 160
        bodyColoredPrimary[88].setRotationPoint(49F, -4F, -12F);

        bodyColoredPrimary[89].addShape3D(0F, 0F, 0F, new Shape2D(new Coord2D[]{new Coord2D(0, 0, 0, 0), new Coord2D(3, 0, 3, 0), new Coord2D(8, 4, 8, 4), new Coord2D(5, 4, 5, 4)}), 10, 8, 4, 20, 10, ModelRendererTurbo.MR_FRONT, new float[]{7, 3, 7, 3}); // Shape 161
        bodyColoredPrimary[89].setRotationPoint(29F, -4F, 12F);
        bodyColoredPrimary[89].rotateAngleY = -3.14159265F;

        bodyColoredPrimary[90].addShape3D(0F, 0F, 0F, new Shape2D(new Coord2D[]{new Coord2D(0, 0, 0, 0), new Coord2D(3, 0, 3, 0), new Coord2D(8, 4, 8, 4), new Coord2D(5, 4, 5, 4)}), 10, 8, 4, 20, 10, ModelRendererTurbo.MR_FRONT, new float[]{7, 3, 7, 3}); // Shape 162
        bodyColoredPrimary[90].setRotationPoint(49F, -4F, 22F);

        bodyColoredPrimary[91].addShape3D(0F, 0F, 0F, new Shape2D(new Coord2D[]{new Coord2D(0, 0, 0, 0), new Coord2D(3, 0, 3, 0), new Coord2D(8, 4, 8, 4), new Coord2D(5, 4, 5, 4)}), 6, 8, 4, 20, 6, ModelRendererTurbo.MR_FRONT, new float[]{7, 3, 7, 3}); // Shape 163
        bodyColoredPrimary[91].setRotationPoint(-29F, -4F, 22F);

        bodyColoredPrimary[92].addShape3D(0F, 0F, 0F, new Shape2D(new Coord2D[]{new Coord2D(0, 0, 0, 0), new Coord2D(3, 0, 3, 0), new Coord2D(8, 4, 8, 4), new Coord2D(5, 4, 5, 4)}), 6, 8, 4, 20, 6, ModelRendererTurbo.MR_FRONT, new float[]{7, 3, 7, 3}); // Shape 164
        bodyColoredPrimary[92].setRotationPoint(-49F, -4F, 16F);
        bodyColoredPrimary[92].rotateAngleY = -3.14159265F;

        bodyColoredPrimary[93].addShape3D(0F, 0F, 0F, new Shape2D(new Coord2D[]{new Coord2D(0, 0, 0, 0), new Coord2D(3, 0, 3, 0), new Coord2D(8, 4, 8, 4), new Coord2D(5, 4, 5, 4)}), 6, 8, 4, 20, 6, ModelRendererTurbo.MR_FRONT, new float[]{7, 3, 7, 3}); // Shape 165
        bodyColoredPrimary[93].setRotationPoint(-49F, -4F, -22F);
        bodyColoredPrimary[93].rotateAngleY = -3.14159265F;

        bodyColoredPrimary[94].addShape3D(0F, 0F, 0F, new Shape2D(new Coord2D[]{new Coord2D(0, 0, 0, 0), new Coord2D(3, 0, 3, 0), new Coord2D(8, 4, 8, 4), new Coord2D(5, 4, 5, 4)}), 6, 8, 4, 20, 6, ModelRendererTurbo.MR_FRONT, new float[]{7, 3, 7, 3}); // Shape 166
        bodyColoredPrimary[94].setRotationPoint(-29F, -4F, -16F);

        bodyColoredPrimary[95].addShape3D(0F, 0F, 0F, new Shape2D(new Coord2D[]{new Coord2D(0, 0, 0, 0), new Coord2D(10, 0, 10, 0), new Coord2D(7, 1, 7, 1), new Coord2D(3, 1, 3, 1)}), 10, 10, 1, 22, 10, ModelRendererTurbo.MR_FRONT, new float[]{4, 4, 4, 10}); // Shape 167
        bodyColoredPrimary[95].setRotationPoint(34F, -8F, 12F);
        bodyColoredPrimary[95].rotateAngleY = -3.14159265F;

        bodyColoredPrimary[96].addShape3D(0F, 0F, 0F, new Shape2D(new Coord2D[]{new Coord2D(0, 0, 0, 0), new Coord2D(10, 0, 10, 0), new Coord2D(7, 1, 7, 1), new Coord2D(3, 1, 3, 1)}), 6, 10, 1, 22, 6, ModelRendererTurbo.MR_FRONT, new float[]{4, 4, 4, 10}); // Shape 168
        bodyColoredPrimary[96].setRotationPoint(-44F, -8F, 16F);
        bodyColoredPrimary[96].rotateAngleY = -3.14159265F;

        bodyColoredPrimary[97].addShape3D(0F, 0F, 0F, new Shape2D(new Coord2D[]{new Coord2D(0, 0, 0, 0), new Coord2D(10, 0, 10, 0), new Coord2D(7, 1, 7, 1), new Coord2D(3, 1, 3, 1)}), 6, 10, 1, 22, 6, ModelRendererTurbo.MR_FRONT, new float[]{4, 4, 4, 10}); // Shape 169
        bodyColoredPrimary[97].setRotationPoint(-44F, -8F, -22F);
        bodyColoredPrimary[97].rotateAngleY = -3.14159265F;
        //
        translateAll(0F, 0F, 0F);
        flipAll();
    }

}
