//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2018 Minecraft-SMP.de
// This file is for Fex's Vehicle & Transportation Mod
// Model: C1_R1
// Model Creator: FEX___96
// Created on: 22.08.2016 - 20:40:40
// Last changed on: 04.04.2018
package net.fexcraft.mod.addons.fvp.models.part;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.model.part.PartModel;

public class ModelC1R1T1Wheel extends PartModel {

    public ModelC1R1T1Wheel(){
    	super(); textureX = 512; textureY = 512;
        this.addToCreators("01e4af9b-2a30-471e-addf-f6338ffce04b");
        ModelRendererTurbo[] wheel_front_left = new ModelRendererTurbo[78];
        wheel_front_left[0] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 6
        wheel_front_left[1] = new ModelRendererTurbo(this, 265, 1, textureX, textureY); // Box 11
        wheel_front_left[2] = new ModelRendererTurbo(this, 305, 1, textureX, textureY); // Box 12
        wheel_front_left[3] = new ModelRendererTurbo(this, 345, 1, textureX, textureY); // Box 13
        wheel_front_left[4] = new ModelRendererTurbo(this, 385, 1, textureX, textureY); // Box 14
        wheel_front_left[5] = new ModelRendererTurbo(this, 441, 1, textureX, textureY); // Box 16
        wheel_front_left[6] = new ModelRendererTurbo(this, 465, 1, textureX, textureY); // Box 18
        wheel_front_left[7] = new ModelRendererTurbo(this, 489, 1, textureX, textureY); // Box 19
        wheel_front_left[8] = new ModelRendererTurbo(this, 1, 9, textureX, textureY); // Box 20
        wheel_front_left[9] = new ModelRendererTurbo(this, 25, 9, textureX, textureY); // Box 21
        wheel_front_left[10] = new ModelRendererTurbo(this, 177, 9, textureX, textureY); // Box 22
        wheel_front_left[11] = new ModelRendererTurbo(this, 217, 9, textureX, textureY); // Box 23
        wheel_front_left[12] = new ModelRendererTurbo(this, 265, 9, textureX, textureY); // Box 24
        wheel_front_left[13] = new ModelRendererTurbo(this, 305, 9, textureX, textureY); // Box 26
        wheel_front_left[14] = new ModelRendererTurbo(this, 441, 9, textureX, textureY); // Box 27
        wheel_front_left[15] = new ModelRendererTurbo(this, 457, 9, textureX, textureY); // Box 28
        wheel_front_left[16] = new ModelRendererTurbo(this, 473, 9, textureX, textureY); // Box 29
        wheel_front_left[17] = new ModelRendererTurbo(this, 33, 1, textureX, textureY); // Box 30
        wheel_front_left[18] = new ModelRendererTurbo(this, 281, 1, textureX, textureY); // Box 31
        wheel_front_left[19] = new ModelRendererTurbo(this, 361, 1, textureX, textureY); // Box 32
        wheel_front_left[20] = new ModelRendererTurbo(this, 401, 1, textureX, textureY); // Box 33
        wheel_front_left[21] = new ModelRendererTurbo(this, 457, 1, textureX, textureY); // Box 34
        wheel_front_left[22] = new ModelRendererTurbo(this, 481, 1, textureX, textureY); // Box 36
        wheel_front_left[23] = new ModelRendererTurbo(this, 17, 9, textureX, textureY); // Box 37
        wheel_front_left[24] = new ModelRendererTurbo(this, 505, 1, textureX, textureY); // Box 38
        wheel_front_left[25] = new ModelRendererTurbo(this, 281, 9, textureX, textureY); // Box 39
        wheel_front_left[26] = new ModelRendererTurbo(this, 361, 9, textureX, textureY); // Box 40
        wheel_front_left[27] = new ModelRendererTurbo(this, 401, 9, textureX, textureY); // Box 41
        wheel_front_left[28] = new ModelRendererTurbo(this, 489, 9, textureX, textureY); // Box 42
        wheel_front_left[29] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 43
        wheel_front_left[30] = new ModelRendererTurbo(this, 17, 17, textureX, textureY); // Box 44
        wheel_front_left[31] = new ModelRendererTurbo(this, 33, 17, textureX, textureY); // Box 45
        wheel_front_left[32] = new ModelRendererTurbo(this, 265, 17, textureX, textureY); // Box 46
        wheel_front_left[33] = new ModelRendererTurbo(this, 281, 17, textureX, textureY); // Box 47
        wheel_front_left[34] = new ModelRendererTurbo(this, 385, 17, textureX, textureY); // Box 48
        wheel_front_left[35] = new ModelRendererTurbo(this, 401, 17, textureX, textureY); // Box 49
        wheel_front_left[36] = new ModelRendererTurbo(this, 505, 9, textureX, textureY); // Box 50
        wheel_front_left[37] = new ModelRendererTurbo(this, 489, 17, textureX, textureY); // Box 51
        wheel_front_left[38] = new ModelRendererTurbo(this, 497, 17, textureX, textureY); // Box 52
        wheel_front_left[39] = new ModelRendererTurbo(this, 1, 25, textureX, textureY); // Box 53
        wheel_front_left[40] = new ModelRendererTurbo(this, 17, 25, textureX, textureY); // Box 54
        wheel_front_left[41] = new ModelRendererTurbo(this, 33, 25, textureX, textureY); // Box 55
        wheel_front_left[42] = new ModelRendererTurbo(this, 177, 25, textureX, textureY); // Box 56
        wheel_front_left[43] = new ModelRendererTurbo(this, 193, 25, textureX, textureY); // Box 57
        wheel_front_left[44] = new ModelRendererTurbo(this, 505, 17, textureX, textureY); // Box 58
        wheel_front_left[45] = new ModelRendererTurbo(this, 305, 25, textureX, textureY); // Box 59
        wheel_front_left[46] = new ModelRendererTurbo(this, 313, 25, textureX, textureY); // Box 60
        wheel_front_left[47] = new ModelRendererTurbo(this, 209, 25, textureX, textureY); // Box 61
        wheel_front_left[48] = new ModelRendererTurbo(this, 225, 25, textureX, textureY); // Box 62
        wheel_front_left[49] = new ModelRendererTurbo(this, 321, 25, textureX, textureY); // Box 63
        wheel_front_left[50] = new ModelRendererTurbo(this, 337, 25, textureX, textureY); // Box 65
        wheel_front_left[51] = new ModelRendererTurbo(this, 353, 25, textureX, textureY); // Box 66
        wheel_front_left[52] = new ModelRendererTurbo(this, 465, 25, textureX, textureY); // Box 67
        wheel_front_left[53] = new ModelRendererTurbo(this, 481, 25, textureX, textureY); // Box 68
        wheel_front_left[54] = new ModelRendererTurbo(this, 489, 25, textureX, textureY); // Box 69
        wheel_front_left[55] = new ModelRendererTurbo(this, 265, 25, textureX, textureY); // Box 70
        wheel_front_left[56] = new ModelRendererTurbo(this, 385, 25, textureX, textureY); // Box 71
        wheel_front_left[57] = new ModelRendererTurbo(this, 441, 25, textureX, textureY); // Box 74
        wheel_front_left[58] = new ModelRendererTurbo(this, 497, 25, textureX, textureY); // Box 75
        wheel_front_left[59] = new ModelRendererTurbo(this, 505, 25, textureX, textureY); // Box 77
        wheel_front_left[60] = new ModelRendererTurbo(this, 1, 33, textureX, textureY); // Box 78
        wheel_front_left[61] = new ModelRendererTurbo(this, 9, 33, textureX, textureY); // Box 79
        wheel_front_left[62] = new ModelRendererTurbo(this, 17, 33, textureX, textureY); // Box 81
        wheel_front_left[63] = new ModelRendererTurbo(this, 177, 33, textureX, textureY); // Box 82
        wheel_front_left[64] = new ModelRendererTurbo(this, 201, 33, textureX, textureY); // Box 83
        wheel_front_left[65] = new ModelRendererTurbo(this, 225, 33, textureX, textureY); // Box 84
        wheel_front_left[66] = new ModelRendererTurbo(this, 449, 25, textureX, textureY); // Box 85
        wheel_front_left[67] = new ModelRendererTurbo(this, 417, 33, textureX, textureY); // Box 86
        wheel_front_left[68] = new ModelRendererTurbo(this, 249, 33, textureX, textureY); // Box 87
        wheel_front_left[69] = new ModelRendererTurbo(this, 433, 33, textureX, textureY); // Box 88
        wheel_front_left[70] = new ModelRendererTurbo(this, 441, 33, textureX, textureY); // Box 89
        wheel_front_left[71] = new ModelRendererTurbo(this, 449, 33, textureX, textureY); // Box 93
        wheel_front_left[72] = new ModelRendererTurbo(this, 457, 33, textureX, textureY); // Box 94
        wheel_front_left[73] = new ModelRendererTurbo(this, 465, 33, textureX, textureY); // Box 95
        wheel_front_left[74] = new ModelRendererTurbo(this, 217, 41, textureX, textureY); // Box 99
        wheel_front_left[75] = new ModelRendererTurbo(this, 233, 41, textureX, textureY); // Box 100
        wheel_front_left[76] = new ModelRendererTurbo(this, 249, 41, textureX, textureY); // Box 101
        wheel_front_left[77] = new ModelRendererTurbo(this, 265, 41, textureX, textureY); // Box 102

        wheel_front_left[0].addBox(-1.5F, -1.5F, -3F, 3, 3, 3, 0F); // Box 6
        wheel_front_left[0].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[1].addBox(-1.5F, 7.5F, -4.5F, 3, 2, 5, 0F); // Box 11
        wheel_front_left[1].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[2].addBox(-1.5F, -9.5F, -4.5F, 3, 2, 5, 0F); // Box 12
        wheel_front_left[2].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[3].addBox(7.5F, -1.5F, -4.5F, 2, 3, 5, 0F); // Box 13
        wheel_front_left[3].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[4].addBox(-9.5F, -1.5F, -4.5F, 2, 3, 5, 0F); // Box 14
        wheel_front_left[4].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[5].addShapeBox(3.7F, 4.7F, -4.5F, 3, 2, 5, 0F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -2F, 1F, 0F, 1F, -1F, 0F, 1F, -1F, 0F, -2F, 1F, 0F); // Box 16
        wheel_front_left[5].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[6].addShapeBox(5.2F, -7.2F, -4.5F, 3, 2, 5, 0F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F, 1F, -1F, 0F, -2F, 1F, 0F, -2F, 1F, 0F, 1F, -1F, 0F); // Box 18
        wheel_front_left[6].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[7].addShapeBox(-6.7F, 4.7F, -4.5F, 3, 2, 5, 0F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F, 1F, -1F, 0F, -2F, 1F, 0F, -2F, 1F, 0F, 1F, -1F, 0F); // Box 19
        wheel_front_left[7].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[8].addShapeBox(-6.7F, -6.7F, -4.5F, 3, 2, 5, 0F, 1F, -1F, 0F, -2F, 1F, 0F, -2F, 1F, 0F, 1F, -1F, 0F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F); // Box 20
        wheel_front_left[8].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[9].addShapeBox(1.5F, 7.5F, -4.5F, 3, 2, 5, 0F, 0F, 0F, 0F, -0.3F, 1.3F, 0F, -0.3F, 1.3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1.2F, -1.8F, 0F, 1.2F, -1.8F, 0F, 0F, 0F, 0F); // Box 21
        wheel_front_left[9].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[10].addShapeBox(-4.5F, 7.5F, -4.5F, 3, 2, 5, 0F, -0.3F, 1.3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, 1.3F, 0F, 1.2F, -1.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1.2F, -1.8F, 0F); // Box 22
        wheel_front_left[10].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[11].addShapeBox(-4.5F, -9.5F, -4.5F, 3, 2, 5, 0F, 1.2F, -1.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1.2F, -1.8F, 0F, -0.3F, 1.3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, 1.3F, 0F); // Box 23
        wheel_front_left[11].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[12].addShapeBox(1.5F, -9.5F, -4.5F, 3, 2, 5, 0F, 0F, 0F, 0F, 1.2F, -1.8F, 0F, 1.2F, -1.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, 1.3F, 0F, -0.3F, 1.3F, 0F, 0F, 0F, 0F); // Box 24
        wheel_front_left[12].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[13].addShapeBox(7.5F, 1.5F, -4.5F, 2, 3, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F); // Box 26
        wheel_front_left[13].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[14].addShapeBox(7.5F, -4.5F, -4.5F, 2, 3, 5, 0F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 27
        wheel_front_left[14].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[15].addShapeBox(-9.5F, -4.5F, -4.5F, 2, 3, 5, 0F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 28
        wheel_front_left[15].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[16].addShapeBox(-9.5F, 1.5F, -4.5F, 2, 3, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F); // Box 29
        wheel_front_left[16].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[17].addShapeBox(-1.5F, 7.5F, 0.5F, 3, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F); // Box 30
        wheel_front_left[17].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[18].addShapeBox(-1.5F, -9.5F, 0.5F, 3, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F); // Box 31
        wheel_front_left[18].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[19].addShapeBox(7.5F, -1.5F, 0.5F, 2, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F); // Box 32
        wheel_front_left[19].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[20].addShapeBox(-9.5F, -1.5F, 0.5F, 2, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F); // Box 33
        wheel_front_left[20].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[21].addShapeBox(7.5F, 1.5F, 0.5F, 2, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F, -2F, 1.2F, -0.7F, 1.2F, -0.1F, -0.7F); // Box 34
        wheel_front_left[21].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[22].addShapeBox(3.7F, 4.7F, 0.5F, 3, 2, 1, 0F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F, -0.4F, 0.3F, -0.7F, -0.7F, -1.6F, -0.7F, -2F, 1F, 0F, 1F, -1F, 0F, 0.8F, -1F, -0.7F, -1.9F, 0.8F, -0.7F); // Box 36
        wheel_front_left[22].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[23].addShapeBox(1.5F, 7.5F, 0.5F, 3, 2, 1, 0F, 0F, 0F, 0F, -0.3F, 1.3F, 0F, -0.1F, 1.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 1.2F, -1.8F, 0F, 1.1F, -2F, -0.7F, 0F, -0.2F, -0.7F); // Box 37
        wheel_front_left[23].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[24].addShapeBox(7.5F, -4.5F, 0.5F, 2, 3, 1, 0F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F, -2F, 1.2F, -0.7F, 1.2F, -0.1F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F); // Box 38
        wheel_front_left[24].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[25].addShapeBox(-9.5F, -4.5F, 0.5F, 2, 3, 1, 0F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F, 1.2F, -0.1F, -0.7F, -2F, 1.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F); // Box 39
        wheel_front_left[25].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[26].addShapeBox(-9.5F, 1.5F, 0.5F, 2, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F, 1.2F, -0.1F, -0.7F, -2F, 1.2F, -0.7F); // Box 40
        wheel_front_left[26].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[27].addShapeBox(3.7F, -6.7F, 0.5F, 3, 2, 1, 0F, -2F, 1F, 0F, 1F, -1F, 0F, 0.8F, -1F, -0.7F, -1.9F, 0.8F, -0.7F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F, -0.4F, 0.3F, -0.7F, -0.7F, -1.6F, -0.7F); // Box 41
        wheel_front_left[27].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[28].addShapeBox(-6.7F, -6.7F, 0.5F, 3, 2, 1, 0F, 1F, -1F, 0F, -2F, 1F, 0F, -1.9F, 0.8F, -0.7F, 0.8F, -1F, -0.7F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -0.7F, -1.6F, -0.7F, -0.4F, 0.3F, -0.7F); // Box 42
        wheel_front_left[28].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[29].addShapeBox(-6.7F, 4.7F, 0.5F, 3, 2, 1, 0F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -0.7F, -1.6F, -0.7F, -0.4F, 0.3F, -0.7F, 1F, -1F, 0F, -2F, 1F, 0F, -1.9F, 0.8F, -0.7F, 0.8F, -1F, -0.7F); // Box 43
        wheel_front_left[29].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[30].addShapeBox(-4.5F, 7.5F, 0.5F, 3, 2, 1, 0F, -0.3F, 1.3F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, -0.1F, 1.2F, -0.7F, 1.2F, -1.8F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 1.1F, -2F, -0.7F); // Box 44
        wheel_front_left[30].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[31].addShapeBox(-4.5F, -9.5F, 0.5F, 3, 2, 1, 0F, 1.2F, -1.8F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 1.1F, -2F, -0.7F, -0.3F, 1.3F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, -0.1F, 1.2F, -0.7F); // Box 45
        wheel_front_left[31].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[32].addShapeBox(1.5F, -9.5F, 0.5F, 3, 2, 1, 0F, 0F, 0F, 0F, 1.2F, -1.8F, 0F, 1.1F, -2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, -0.3F, 1.3F, 0F, -0.1F, 1.2F, -0.7F, 0F, -0.2F, -0.7F); // Box 46
        wheel_front_left[32].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[33].addShapeBox(-1.5F, -9.5F, -5.5F, 3, 2, 1, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 47
        wheel_front_left[33].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[34].addShapeBox(1.5F, -9.5F, -5.5F, 3, 2, 1, 0F, 0F, -0.2F, -0.7F, 1.1F, -2F, -0.7F, 1.2F, -1.8F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, -0.1F, 1.2F, -0.7F, -0.3F, 1.3F, 0F, 0F, 0F, 0F); // Box 48
        wheel_front_left[34].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[35].addShapeBox(3.7F, -6.7F, -5.5F, 3, 2, 1, 0F, -1.9F, 0.8F, -0.7F, 0.8F, -1F, -0.7F, 1F, -1F, 0F, -2F, 1F, 0F, -0.7F, -1.6F, -0.7F, -0.4F, 0.3F, -0.7F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F); // Box 49
        wheel_front_left[35].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[36].addShapeBox(7.5F, -4.5F, -5.5F, 2, 3, 1, 0F, 1.2F, -0.1F, -0.7F, -2F, 1.2F, -0.7F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 50
        wheel_front_left[36].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[37].addShapeBox(7.5F, -1.5F, -5.5F, 2, 3, 1, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 51
        wheel_front_left[37].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[38].addShapeBox(7.5F, 1.5F, -5.5F, 2, 3, 1, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 1.2F, -0.1F, -0.7F, -2F, 1.2F, -0.7F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F); // Box 52
        wheel_front_left[38].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[39].addShapeBox(3.7F, 4.7F, -5.5F, 3, 2, 1, 0F, -0.7F, -1.6F, -0.7F, -0.4F, 0.3F, -0.7F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -1.9F, 0.8F, -0.7F, 0.8F, -1F, -0.7F, 1F, -1F, 0F, -2F, 1F, 0F); // Box 53
        wheel_front_left[39].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[40].addShapeBox(1.5F, 7.5F, -5.5F, 3, 2, 1, 0F, 0F, -0.2F, -0.7F, -0.1F, 1.2F, -0.7F, -0.3F, 1.3F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 1.1F, -2F, -0.7F, 1.2F, -1.8F, 0F, 0F, 0F, 0F); // Box 54
        wheel_front_left[40].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[41].addShapeBox(-1.5F, 7.5F, -5.5F, 3, 2, 1, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 55
        wheel_front_left[41].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[42].addShapeBox(-4.5F, 7.5F, -5.5F, 3, 2, 1, 0F, -0.1F, 1.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, -0.3F, 1.3F, 0F, 1.1F, -2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 1.2F, -1.8F, 0F); // Box 56
        wheel_front_left[42].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[43].addShapeBox(-6.7F, 4.7F, -5.5F, 3, 2, 1, 0F, -0.4F, 0.3F, -0.7F, -0.7F, -1.6F, -0.7F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F, 0.8F, -1F, -0.7F, -1.9F, 0.8F, -0.7F, -2F, 1F, 0F, 1F, -1F, 0F); // Box 57
        wheel_front_left[43].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[44].addShapeBox(-9.5F, 1.5F, -5.5F, 2, 3, 1, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 1.2F, -0.7F, 1.2F, -0.1F, -0.7F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F); // Box 58
        wheel_front_left[44].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[45].addShapeBox(-9.5F, -1.5F, -5.5F, 2, 3, 1, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 59
        wheel_front_left[45].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[46].addShapeBox(-9.5F, -4.5F, -5.5F, 2, 3, 1, 0F, -2F, 1.2F, -0.7F, 1.2F, -0.1F, -0.7F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 60
        wheel_front_left[46].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[47].addShapeBox(-6.7F, -6.7F, -5.5F, 3, 2, 1, 0F, 0.8F, -1F, -0.7F, -1.9F, 0.8F, -0.7F, -2F, 1F, 0F, 1F, -1F, 0F, -0.4F, 0.3F, -0.7F, -0.7F, -1.6F, -0.7F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F); // Box 61
        wheel_front_left[47].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[48].addShapeBox(-4.5F, -9.5F, -5.5F, 3, 2, 1, 0F, 1.1F, -2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 1.2F, -1.8F, 0F, -0.1F, 1.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, -0.3F, 1.3F, 0F); // Box 62
        wheel_front_left[48].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[49].addShapeBox(1.5F, -0.5F, -3F, 1, 1, 3, 0F, 0F, 0.1F, 0F, -0.4F, -0.5F, 0F, -0.4F, -0.5F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, -0.4F, -0.5F, 0F, -0.4F, -0.5F, 0F, 0F, 0.1F, 0F); // Box 63
        wheel_front_left[49].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[50].addShapeBox(-2.5F, -0.5F, -3F, 1, 1, 3, 0F, -0.4F, -0.5F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, -0.4F, -0.5F, 0F, -0.4F, -0.5F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, -0.4F, -0.5F, 0F); // Box 65
        wheel_front_left[50].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[51].addShapeBox(-0.5F, 1.5F, -3F, 1, 1, 3, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, -0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F); // Box 66
        wheel_front_left[51].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[52].addShapeBox(-0.5F, -2.5F, -3F, 1, 1, 3, 0F, -0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 67
        wheel_front_left[52].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[53].addBox(-0.5F, 1.5F, -2.5F, 1, 6, 2, 0F); // Box 68
        wheel_front_left[53].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[54].addBox(-0.5F, -7.5F, -2.5F, 1, 6, 2, 0F); // Box 69
        wheel_front_left[54].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[55].addBox(1.5F, -0.5F, -2.5F, 6, 1, 2, 0F); // Box 70
        wheel_front_left[55].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[56].addBox(-7.5F, -0.5F, -2.5F, 6, 1, 2, 0F); // Box 71
        wheel_front_left[56].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[57].addShapeBox(-1F, -1F, 0F, 2, 2, 1, 0F, 0.5F, 0.5F, 0F, 0.5F, 0.5F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0.5F, 0.5F, 0F, 0.5F, 0.5F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 74
        wheel_front_left[57].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[58].addShapeBox(-0.5F, 1.5F, -2.5F, 1, 6, 2, 0F, -0.85F, -0.05F, 0F, 0.7F, 0.45F, 0F, 0.7F, 0.45F, 0F, -0.85F, -0.05F, 0F, -3.8F, -0.75F, 0F, 3.7F, -1.25F, 0F, 3.7F, -1.25F, 0F, -3.8F, -0.75F, 0F); // Box 75
        wheel_front_left[58].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[59].addShapeBox(-0.5F, -7.5F, -2.5F, 1, 6, 2, 0F, -3.8F, -0.75F, 0F, 3.7F, -1.25F, 0F, 3.7F, -1.25F, 0F, -3.8F, -0.75F, 0F, -0.85F, -0.05F, 0F, 0.7F, 0.45F, 0F, 0.7F, 0.45F, 0F, -0.85F, -0.05F, 0F); // Box 77
        wheel_front_left[59].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[60].addShapeBox(-0.5F, -7.5F, -2.5F, 1, 6, 2, 0F, 3.7F, -1.25F, 0F, -3.8F, -0.75F, 0F, -3.8F, -0.75F, 0F, 3.7F, -1.25F, 0F, 0.7F, 0.45F, 0F, -0.85F, -0.05F, 0F, -0.85F, -0.05F, 0F, 0.7F, 0.45F, 0F); // Box 78
        wheel_front_left[60].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[61].addShapeBox(-0.5F, 1.5F, -2.5F, 1, 6, 2, 0F, 0.7F, 0.45F, 0F, -0.85F, -0.05F, 0F, -0.85F, -0.05F, 0F, 0.7F, 0.45F, 0F, 3.7F, -1.25F, 0F, -3.8F, -0.75F, 0F, -3.8F, -0.75F, 0F, 3.7F, -1.25F, 0F); // Box 79
        wheel_front_left[61].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[62].addShapeBox(1.5F, -0.5F, -2.5F, 6, 1, 2, 0F, -0.05F, -0.8F, 0F, -0.75F, -3.8F, 0F, -0.75F, -3.8F, 0F, -0.05F, -0.8F, 0F, 0.45F, 0.7F, 0F, -1.25F, 3.7F, 0F, -1.25F, 3.7F, 0F, 0.45F, 0.7F, 0F); // Box 81
        wheel_front_left[62].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[63].addShapeBox(-7.5F, -0.5F, -2.5F, 6, 1, 2, 0F, -1.25F, 3.7F, 0F, 0.45F, 0.7F, 0F, 0.45F, 0.7F, 0F, -1.25F, 3.7F, 0F, -0.75F, -3.8F, 0F, -0.05F, -0.8F, 0F, -0.05F, -0.8F, 0F, -0.75F, -3.8F, 0F); // Box 82
        wheel_front_left[63].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[64].addShapeBox(-7.5F, -0.5F, -2.5F, 6, 1, 2, 0F, -0.75F, -3.8F, 0F, -0.05F, -0.8F, 0F, -0.05F, -0.8F, 0F, -0.75F, -3.8F, 0F, -1.25F, 3.7F, 0F, 0.45F, 0.7F, 0F, 0.45F, 0.7F, 0F, -1.25F, 3.7F, 0F); // Box 83
        wheel_front_left[64].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[65].addShapeBox(1.5F, -0.5F, -2.5F, 6, 1, 2, 0F, 0.45F, 0.7F, 0F, -1.25F, 3.7F, 0F, -1.25F, 3.7F, 0F, 0.45F, 0.7F, 0F, -0.05F, -0.8F, 0F, -0.75F, -3.8F, 0F, -0.75F, -3.8F, 0F, -0.05F, -0.8F, 0F); // Box 84
        wheel_front_left[65].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[66].addShapeBox(1.5F, -0.5F, -0.5F, 6, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 85
        wheel_front_left[66].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[67].addShapeBox(-7.5F, -0.5F, -0.5F, 6, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 86
        wheel_front_left[67].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[68].addShapeBox(-0.5F, 1.5F, -0.5F, 1, 6, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F); // Box 87
        wheel_front_left[68].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[69].addShapeBox(-0.5F, -7.5F, -0.5F, 1, 6, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F); // Box 88
        wheel_front_left[69].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[70].addShapeBox(-0.5F, 1.5F, -0.5F, 1, 6, 1, 0F, -0.85F, -0.05F, 0F, 0.7F, 0.45F, 0F, 0.35F, 0.15F, -0.5F, -1.35F, 0.15F, -0.5F, -3.8F, -0.75F, 0F, 3.7F, -1.25F, 0F, 3.3F, -1F, -0.5F, -4.25F, -1.1F, -0.5F); // Box 89
        wheel_front_left[70].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[71].addShapeBox(-0.5F, 1.5F, -0.5F, 1, 6, 1, 0F, 0.7F, 0.45F, 0F, -0.85F, -0.05F, 0F, -1.35F, 0.15F, -0.5F, 0.35F, 0.15F, -0.5F, 3.7F, -1.25F, 0F, -3.8F, -0.75F, 0F, -4.25F, -1.1F, -0.5F, 3.3F, -1F, -0.5F); // Box 93
        wheel_front_left[71].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[72].addShapeBox(-0.5F, -7.5F, -0.5F, 1, 6, 1, 0F, 3.7F, -1.25F, 0F, -3.8F, -0.75F, 0F, -4.25F, -1.1F, -0.5F, 3.3F, -1F, -0.5F, 0.7F, 0.45F, 0F, -0.85F, -0.05F, 0F, -1.35F, 0.15F, -0.5F, 0.35F, 0.15F, -0.5F); // Box 94
        wheel_front_left[72].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[73].addShapeBox(-0.5F, -7.5F, -0.5F, 1, 6, 1, 0F, -3.8F, -0.75F, 0F, 3.7F, -1.25F, 0F, 3.3F, -1F, -0.5F, -4.25F, -1.1F, -0.5F, -0.85F, -0.05F, 0F, 0.7F, 0.45F, 0F, 0.35F, 0.15F, -0.5F, -1.35F, 0.15F, -0.5F); // Box 95
        wheel_front_left[73].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[74].addShapeBox(1.5F, -0.5F, -0.5F, 6, 1, 1, 0F, -0.05F, -0.8F, 0F, -0.75F, -3.8F, 0F, -0.85F, -4.25F, -0.5F, 0.15F, -1.25F, -0.5F, 0.45F, 0.7F, 0F, -1.25F, 3.7F, 0F, -1.05F, 3.15F, -0.5F, 0.3F, 0.15F, -0.5F); // Box 99
        wheel_front_left[74].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[75].addShapeBox(1.5F, -0.5F, -0.5F, 6, 1, 1, 0F, 0.45F, 0.7F, 0F, -1.25F, 3.7F, 0F, -1.05F, 3.15F, -0.5F, 0.3F, 0.15F, -0.5F, -0.05F, -0.8F, 0F, -0.75F, -3.8F, 0F, -0.85F, -4.25F, -0.5F, 0.15F, -1.25F, -0.5F); // Box 100
        wheel_front_left[75].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[76].addShapeBox(-7.5F, -0.5F, -0.5F, 6, 1, 1, 0F, -1.25F, 3.7F, 0F, 0.45F, 0.7F, 0F, 0.3F, 0.15F, -0.5F, -1.05F, 3.15F, -0.5F, -0.75F, -3.8F, 0F, -0.05F, -0.8F, 0F, 0.15F, -1.25F, -0.5F, -0.85F, -4.25F, -0.5F); // Box 101
        wheel_front_left[76].setRotationPoint(43.5F, 0.5F, 20F);

        wheel_front_left[77].addShapeBox(-7.5F, -0.5F, -0.5F, 6, 1, 1, 0F, -0.75F, -3.8F, 0F, -0.05F, -0.8F, 0F, 0.15F, -1.25F, -0.5F, -0.85F, -4.25F, -0.5F, -1.25F, 3.7F, 0F, 0.45F, 0.7F, 0F, 0.3F, 0.15F, -0.5F, -1.05F, 3.15F, -0.5F); // Box 102
        wheel_front_left[77].setRotationPoint(43.5F, 0.5F, 20F);
        this.add("wheel_front_left", wheel_front_left);

        ModelRendererTurbo[] wheel_front_right = new ModelRendererTurbo[78];
        wheel_front_right[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 5
        wheel_front_right[1] = new ModelRendererTurbo(this, 281, 41, textureX, textureY); // Box 103
        wheel_front_right[2] = new ModelRendererTurbo(this, 305, 41, textureX, textureY); // Box 104
        wheel_front_right[3] = new ModelRendererTurbo(this, 473, 33, textureX, textureY); // Box 105
        wheel_front_right[4] = new ModelRendererTurbo(this, 329, 41, textureX, textureY); // Box 106
        wheel_front_right[5] = new ModelRendererTurbo(this, 345, 41, textureX, textureY); // Box 107
        wheel_front_right[6] = new ModelRendererTurbo(this, 361, 41, textureX, textureY); // Box 108
        wheel_front_right[7] = new ModelRendererTurbo(this, 385, 41, textureX, textureY); // Box 109
        wheel_front_right[8] = new ModelRendererTurbo(this, 409, 41, textureX, textureY); // Box 110
        wheel_front_right[9] = new ModelRendererTurbo(this, 425, 41, textureX, textureY); // Box 111
        wheel_front_right[10] = new ModelRendererTurbo(this, 449, 41, textureX, textureY); // Box 112
        wheel_front_right[11] = new ModelRendererTurbo(this, 473, 41, textureX, textureY); // Box 113
        wheel_front_right[12] = new ModelRendererTurbo(this, 489, 41, textureX, textureY); // Box 114
        wheel_front_right[13] = new ModelRendererTurbo(this, 1, 49, textureX, textureY); // Box 115
        wheel_front_right[14] = new ModelRendererTurbo(this, 17, 49, textureX, textureY); // Box 116
        wheel_front_right[15] = new ModelRendererTurbo(this, 41, 49, textureX, textureY); // Box 117
        wheel_front_right[16] = new ModelRendererTurbo(this, 65, 49, textureX, textureY); // Box 118
        wheel_front_right[17] = new ModelRendererTurbo(this, 89, 49, textureX, textureY); // Box 119
        wheel_front_right[18] = new ModelRendererTurbo(this, 297, 41, textureX, textureY); // Box 120
        wheel_front_right[19] = new ModelRendererTurbo(this, 321, 41, textureX, textureY); // Box 121
        wheel_front_right[20] = new ModelRendererTurbo(this, 377, 41, textureX, textureY); // Box 122
        wheel_front_right[21] = new ModelRendererTurbo(this, 401, 41, textureX, textureY); // Box 123
        wheel_front_right[22] = new ModelRendererTurbo(this, 441, 41, textureX, textureY); // Box 124
        wheel_front_right[23] = new ModelRendererTurbo(this, 465, 41, textureX, textureY); // Box 125
        wheel_front_right[24] = new ModelRendererTurbo(this, 33, 49, textureX, textureY); // Box 126
        wheel_front_right[25] = new ModelRendererTurbo(this, 57, 49, textureX, textureY); // Box 127
        wheel_front_right[26] = new ModelRendererTurbo(this, 81, 49, textureX, textureY); // Box 128
        wheel_front_right[27] = new ModelRendererTurbo(this, 105, 49, textureX, textureY); // Box 129
        wheel_front_right[28] = new ModelRendererTurbo(this, 121, 49, textureX, textureY); // Box 130
        wheel_front_right[29] = new ModelRendererTurbo(this, 137, 49, textureX, textureY); // Box 131
        wheel_front_right[30] = new ModelRendererTurbo(this, 505, 41, textureX, textureY); // Box 132
        wheel_front_right[31] = new ModelRendererTurbo(this, 153, 49, textureX, textureY); // Box 133
        wheel_front_right[32] = new ModelRendererTurbo(this, 161, 49, textureX, textureY); // Box 134
        wheel_front_right[33] = new ModelRendererTurbo(this, 169, 49, textureX, textureY); // Box 135
        wheel_front_right[34] = new ModelRendererTurbo(this, 177, 49, textureX, textureY); // Box 136
        wheel_front_right[35] = new ModelRendererTurbo(this, 185, 49, textureX, textureY); // Box 137
        wheel_front_right[36] = new ModelRendererTurbo(this, 193, 49, textureX, textureY); // Box 138
        wheel_front_right[37] = new ModelRendererTurbo(this, 217, 49, textureX, textureY); // Box 139
        wheel_front_right[38] = new ModelRendererTurbo(this, 241, 49, textureX, textureY); // Box 140
        wheel_front_right[39] = new ModelRendererTurbo(this, 257, 49, textureX, textureY); // Box 141
        wheel_front_right[40] = new ModelRendererTurbo(this, 273, 49, textureX, textureY); // Box 142
        wheel_front_right[41] = new ModelRendererTurbo(this, 289, 49, textureX, textureY); // Box 143
        wheel_front_right[42] = new ModelRendererTurbo(this, 305, 49, textureX, textureY); // Box 144
        wheel_front_right[43] = new ModelRendererTurbo(this, 313, 49, textureX, textureY); // Box 145
        wheel_front_right[44] = new ModelRendererTurbo(this, 321, 49, textureX, textureY); // Box 146
        wheel_front_right[45] = new ModelRendererTurbo(this, 361, 49, textureX, textureY); // Box 147
        wheel_front_right[46] = new ModelRendererTurbo(this, 369, 49, textureX, textureY); // Box 148
        wheel_front_right[47] = new ModelRendererTurbo(this, 393, 49, textureX, textureY); // Box 149
        wheel_front_right[48] = new ModelRendererTurbo(this, 425, 49, textureX, textureY); // Box 150
        wheel_front_right[49] = new ModelRendererTurbo(this, 449, 49, textureX, textureY); // Box 151
        wheel_front_right[50] = new ModelRendererTurbo(this, 17, 57, textureX, textureY); // Box 250
        wheel_front_right[51] = new ModelRendererTurbo(this, 33, 57, textureX, textureY); // Box 251
        wheel_front_right[52] = new ModelRendererTurbo(this, 49, 57, textureX, textureY); // Box 252
        wheel_front_right[53] = new ModelRendererTurbo(this, 505, 49, textureX, textureY); // Box 253
        wheel_front_right[54] = new ModelRendererTurbo(this, 65, 57, textureX, textureY); // Box 254
        wheel_front_right[55] = new ModelRendererTurbo(this, 73, 57, textureX, textureY); // Box 255
        wheel_front_right[56] = new ModelRendererTurbo(this, 81, 57, textureX, textureY); // Box 256
        wheel_front_right[57] = new ModelRendererTurbo(this, 97, 57, textureX, textureY); // Box 257
        wheel_front_right[58] = new ModelRendererTurbo(this, 113, 57, textureX, textureY); // Box 258
        wheel_front_right[59] = new ModelRendererTurbo(this, 129, 57, textureX, textureY); // Box 259
        wheel_front_right[60] = new ModelRendererTurbo(this, 145, 57, textureX, textureY); // Box 260
        wheel_front_right[61] = new ModelRendererTurbo(this, 161, 57, textureX, textureY); // Box 261
        wheel_front_right[62] = new ModelRendererTurbo(this, 169, 57, textureX, textureY); // Box 262
        wheel_front_right[63] = new ModelRendererTurbo(this, 193, 57, textureX, textureY); // Box 263
        wheel_front_right[64] = new ModelRendererTurbo(this, 201, 57, textureX, textureY); // Box 264
        wheel_front_right[65] = new ModelRendererTurbo(this, 217, 57, textureX, textureY); // Box 265
        wheel_front_right[66] = new ModelRendererTurbo(this, 233, 57, textureX, textureY); // Box 266
        wheel_front_right[67] = new ModelRendererTurbo(this, 249, 57, textureX, textureY); // Box 267
        wheel_front_right[68] = new ModelRendererTurbo(this, 265, 57, textureX, textureY); // Box 268
        wheel_front_right[69] = new ModelRendererTurbo(this, 273, 57, textureX, textureY); // Box 269
        wheel_front_right[70] = new ModelRendererTurbo(this, 281, 57, textureX, textureY); // Box 270
        wheel_front_right[71] = new ModelRendererTurbo(this, 289, 57, textureX, textureY); // Box 271
        wheel_front_right[72] = new ModelRendererTurbo(this, 297, 57, textureX, textureY); // Box 272
        wheel_front_right[73] = new ModelRendererTurbo(this, 329, 57, textureX, textureY); // Box 273
        wheel_front_right[74] = new ModelRendererTurbo(this, 337, 57, textureX, textureY); // Box 274
        wheel_front_right[75] = new ModelRendererTurbo(this, 369, 57, textureX, textureY); // Box 275
        wheel_front_right[76] = new ModelRendererTurbo(this, 385, 57, textureX, textureY); // Box 276
        wheel_front_right[77] = new ModelRendererTurbo(this, 401, 57, textureX, textureY); // Box 277

        wheel_front_right[0].addBox(-1.5F, -1.5F, 0F, 3, 3, 3, 0F); // Box 5
        wheel_front_right[0].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[1].addBox(-1.5F, 7.5F, -0.5F, 3, 2, 5, 0F); // Box 103
        wheel_front_right[1].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[2].addBox(-1.5F, -9.5F, -0.5F, 3, 2, 5, 0F); // Box 104
        wheel_front_right[2].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[3].addShapeBox(-1F, -1F, -1F, 2, 2, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0.5F, 0.5F, 0F, 0.5F, 0.5F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0.5F, 0.5F, 0F, 0.5F, 0.5F, 0F); // Box 105
        wheel_front_right[3].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[4].addBox(7.5F, -1.5F, -0.5F, 2, 3, 5, 0F); // Box 106
        wheel_front_right[4].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[5].addBox(-9.5F, -1.5F, -0.5F, 2, 3, 5, 0F); // Box 107
        wheel_front_right[5].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[6].addShapeBox(3.7F, 4.7F, -0.5F, 3, 2, 5, 0F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -2F, 1F, 0F, 1F, -1F, 0F, 1F, -1F, 0F, -2F, 1F, 0F); // Box 108
        wheel_front_right[6].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[7].addShapeBox(-6.7F, 4.7F, -0.5F, 3, 2, 5, 0F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F, 1F, -1F, 0F, -2F, 1F, 0F, -2F, 1F, 0F, 1F, -1F, 0F); // Box 109
        wheel_front_right[7].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[8].addShapeBox(7.5F, -4.5F, -0.5F, 2, 3, 5, 0F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 110
        wheel_front_right[8].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[9].addShapeBox(5.2F, -7.2F, -0.5F, 3, 2, 5, 0F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F, 1F, -1F, 0F, -2F, 1F, 0F, -2F, 1F, 0F, 1F, -1F, 0F); // Box 111
        wheel_front_right[9].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[10].addShapeBox(-6.7F, -6.7F, -0.5F, 3, 2, 5, 0F, 1F, -1F, 0F, -2F, 1F, 0F, -2F, 1F, 0F, 1F, -1F, 0F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F); // Box 112
        wheel_front_right[10].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[11].addShapeBox(7.5F, 1.5F, -0.5F, 2, 3, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F); // Box 113
        wheel_front_right[11].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[12].addShapeBox(-9.5F, 1.5F, -0.5F, 2, 3, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F); // Box 114
        wheel_front_right[12].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[13].addShapeBox(-9.5F, -4.5F, -0.5F, 2, 3, 5, 0F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 115
        wheel_front_right[13].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[14].addShapeBox(1.5F, 7.5F, -0.5F, 3, 2, 5, 0F, 0F, 0F, 0F, -0.3F, 1.3F, 0F, -0.3F, 1.3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1.2F, -1.8F, 0F, 1.2F, -1.8F, 0F, 0F, 0F, 0F); // Box 116
        wheel_front_right[14].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[15].addShapeBox(-4.5F, 7.5F, -0.5F, 3, 2, 5, 0F, -0.3F, 1.3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, 1.3F, 0F, 1.2F, -1.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1.2F, -1.8F, 0F); // Box 117
        wheel_front_right[15].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[16].addShapeBox(-4.5F, -9.5F, -0.5F, 3, 2, 5, 0F, 1.2F, -1.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1.2F, -1.8F, 0F, -0.3F, 1.3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, 1.3F, 0F); // Box 118
        wheel_front_right[16].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[17].addShapeBox(1.5F, -9.5F, -0.5F, 3, 2, 5, 0F, 0F, 0F, 0F, 1.2F, -1.8F, 0F, 1.2F, -1.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, 1.3F, 0F, -0.3F, 1.3F, 0F, 0F, 0F, 0F); // Box 119
        wheel_front_right[17].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[18].addShapeBox(-1.5F, 7.5F, -1.5F, 3, 2, 1, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 120
        wheel_front_right[18].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[19].addShapeBox(-1.5F, -9.5F, -1.5F, 3, 2, 1, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 121
        wheel_front_right[19].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[20].addShapeBox(7.5F, -1.5F, -1.5F, 2, 3, 1, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 122
        wheel_front_right[20].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[21].addShapeBox(-9.5F, -1.5F, -1.5F, 2, 3, 1, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 123
        wheel_front_right[21].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[22].addShapeBox(3.7F, -6.7F, -1.5F, 3, 2, 1, 0F, -1.9F, 0.8F, -0.7F, 0.8F, -1F, -0.7F, 1F, -1F, 0F, -2F, 1F, 0F, -0.7F, -1.6F, -0.7F, -0.4F, 0.3F, -0.7F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F); // Box 124
        wheel_front_right[22].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[23].addShapeBox(3.7F, 4.7F, -1.5F, 3, 2, 1, 0F, -0.7F, -1.6F, -0.7F, -0.4F, 0.3F, -0.7F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -1.9F, 0.8F, -0.7F, 0.8F, -1F, -0.7F, 1F, -1F, 0F, -2F, 1F, 0F); // Box 125
        wheel_front_right[23].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[24].addShapeBox(-6.7F, 4.7F, -1.5F, 3, 2, 1, 0F, -0.4F, 0.3F, -0.7F, -0.7F, -1.6F, -0.7F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F, 0.8F, -1F, -0.7F, -1.9F, 0.8F, -0.7F, -2F, 1F, 0F, 1F, -1F, 0F); // Box 126
        wheel_front_right[24].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[25].addShapeBox(-6.7F, -6.7F, -1.5F, 3, 2, 1, 0F, 0.8F, -1F, -0.7F, -1.9F, 0.8F, -0.7F, -2F, 1F, 0F, 1F, -1F, 0F, -0.4F, 0.3F, -0.7F, -0.7F, -1.6F, -0.7F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F); // Box 127
        wheel_front_right[25].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[26].addShapeBox(1.5F, 7.5F, -1.5F, 3, 2, 1, 0F, 0F, -0.2F, -0.7F, -0.1F, 1.2F, -0.7F, -0.3F, 1.3F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 1.1F, -2F, -0.7F, 1.2F, -1.8F, 0F, 0F, 0F, 0F); // Box 128
        wheel_front_right[26].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[27].addShapeBox(-4.5F, 7.5F, -1.5F, 3, 2, 1, 0F, -0.1F, 1.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, -0.3F, 1.3F, 0F, 1.1F, -2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 1.2F, -1.8F, 0F); // Box 129
        wheel_front_right[27].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[28].addShapeBox(-4.5F, -9.5F, -1.5F, 3, 2, 1, 0F, 1.1F, -2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 1.2F, -1.8F, 0F, -0.1F, 1.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, -0.3F, 1.3F, 0F); // Box 130
        wheel_front_right[28].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[29].addShapeBox(1.5F, -9.5F, -1.5F, 3, 2, 1, 0F, 0F, -0.2F, -0.7F, 1.1F, -2F, -0.7F, 1.2F, -1.8F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, -0.1F, 1.2F, -0.7F, -0.3F, 1.3F, 0F, 0F, 0F, 0F); // Box 131
        wheel_front_right[29].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[30].addShapeBox(7.5F, 1.5F, -1.5F, 2, 3, 1, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 1.2F, -0.1F, -0.7F, -2F, 1.2F, -0.7F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F); // Box 132
        wheel_front_right[30].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[31].addShapeBox(7.5F, -4.5F, -1.5F, 2, 3, 1, 0F, 1.2F, -0.1F, -0.7F, -2F, 1.2F, -0.7F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 133
        wheel_front_right[31].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[32].addShapeBox(-9.5F, -4.5F, -1.5F, 2, 3, 1, 0F, -2F, 1.2F, -0.7F, 1.2F, -0.1F, -0.7F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 134
        wheel_front_right[32].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[33].addShapeBox(-9.5F, 1.5F, -1.5F, 2, 3, 1, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 1.2F, -0.7F, 1.2F, -0.1F, -0.7F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F); // Box 135
        wheel_front_right[33].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[34].addBox(-0.5F, -7.5F, 0.5F, 1, 6, 2, 0F); // Box 136
        wheel_front_right[34].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[35].addBox(-0.5F, 1.5F, 0.5F, 1, 6, 2, 0F); // Box 137
        wheel_front_right[35].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[36].addBox(-7.5F, -0.5F, 0.5F, 6, 1, 2, 0F); // Box 138
        wheel_front_right[36].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[37].addBox(1.5F, -0.5F, 0.5F, 6, 1, 2, 0F); // Box 139
        wheel_front_right[37].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[38].addShapeBox(1.5F, -0.5F, 0F, 1, 1, 3, 0F, 0F, 0.1F, 0F, -0.4F, -0.5F, 0F, -0.4F, -0.5F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, -0.4F, -0.5F, 0F, -0.4F, -0.5F, 0F, 0F, 0.1F, 0F); // Box 140
        wheel_front_right[38].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[39].addShapeBox(-2.5F, -0.5F, 0F, 1, 1, 3, 0F, -0.4F, -0.5F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, -0.4F, -0.5F, 0F, -0.4F, -0.5F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, -0.4F, -0.5F, 0F); // Box 141
        wheel_front_right[39].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[40].addShapeBox(-0.5F, -2.5F, 0F, 1, 1, 3, 0F, -0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 142
        wheel_front_right[40].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[41].addShapeBox(-0.5F, 1.5F, 0F, 1, 1, 3, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, -0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F); // Box 143
        wheel_front_right[41].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[42].addShapeBox(-0.5F, -7.5F, 0.5F, 1, 6, 2, 0F, 3.7F, -1.25F, 0F, -3.8F, -0.75F, 0F, -3.8F, -0.75F, 0F, 3.7F, -1.25F, 0F, 0.7F, 0.45F, 0F, -0.85F, -0.05F, 0F, -0.85F, -0.05F, 0F, 0.7F, 0.45F, 0F); // Box 144
        wheel_front_right[42].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[43].addShapeBox(-0.5F, -7.5F, 0.5F, 1, 6, 2, 0F, -3.8F, -0.75F, 0F, 3.7F, -1.25F, 0F, 3.7F, -1.25F, 0F, -3.8F, -0.75F, 0F, -0.85F, -0.05F, 0F, 0.7F, 0.45F, 0F, 0.7F, 0.45F, 0F, -0.85F, -0.05F, 0F); // Box 145
        wheel_front_right[43].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[44].addShapeBox(-0.5F, 1.5F, 0.5F, 1, 6, 2, 0F, -0.85F, -0.05F, 0F, 0.7F, 0.45F, 0F, 0.7F, 0.45F, 0F, -0.85F, -0.05F, 0F, -3.8F, -0.75F, 0F, 3.7F, -1.25F, 0F, 3.7F, -1.25F, 0F, -3.8F, -0.75F, 0F); // Box 146
        wheel_front_right[44].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[45].addShapeBox(-0.5F, 1.5F, 0.5F, 1, 6, 2, 0F, 0.7F, 0.45F, 0F, -0.85F, -0.05F, 0F, -0.85F, -0.05F, 0F, 0.7F, 0.45F, 0F, 3.7F, -1.25F, 0F, -3.8F, -0.75F, 0F, -3.8F, -0.75F, 0F, 3.7F, -1.25F, 0F); // Box 147
        wheel_front_right[45].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[46].addShapeBox(1.5F, -0.5F, 0.5F, 6, 1, 2, 0F, 0.45F, 0.7F, 0F, -1.25F, 3.7F, 0F, -1.25F, 3.7F, 0F, 0.45F, 0.7F, 0F, -0.05F, -0.8F, 0F, -0.75F, -3.8F, 0F, -0.75F, -3.8F, 0F, -0.05F, -0.8F, 0F); // Box 148
        wheel_front_right[46].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[47].addShapeBox(1.5F, -0.5F, 0.5F, 6, 1, 2, 0F, -0.05F, -0.8F, 0F, -0.75F, -3.8F, 0F, -0.75F, -3.8F, 0F, -0.05F, -0.8F, 0F, 0.45F, 0.7F, 0F, -1.25F, 3.7F, 0F, -1.25F, 3.7F, 0F, 0.45F, 0.7F, 0F); // Box 149
        wheel_front_right[47].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[48].addShapeBox(-7.5F, -0.5F, 0.5F, 6, 1, 2, 0F, -0.75F, -3.8F, 0F, -0.05F, -0.8F, 0F, -0.05F, -0.8F, 0F, -0.75F, -3.8F, 0F, -1.25F, 3.7F, 0F, 0.45F, 0.7F, 0F, 0.45F, 0.7F, 0F, -1.25F, 3.7F, 0F); // Box 150
        wheel_front_right[48].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[49].addShapeBox(-7.5F, -0.5F, 0.5F, 6, 1, 2, 0F, -1.25F, 3.7F, 0F, 0.45F, 0.7F, 0F, 0.45F, 0.7F, 0F, -1.25F, 3.7F, 0F, -0.75F, -3.8F, 0F, -0.05F, -0.8F, 0F, -0.05F, -0.8F, 0F, -0.75F, -3.8F, 0F); // Box 151
        wheel_front_right[49].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[50].addShapeBox(-1.5F, -9.5F, 4.5F, 3, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F); // Box 250
        wheel_front_right[50].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[51].addShapeBox(1.5F, -9.5F, 4.5F, 3, 2, 1, 0F, 0F, 0F, 0F, 1.2F, -1.8F, 0F, 1.1F, -2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, -0.3F, 1.3F, 0F, -0.1F, 1.2F, -0.7F, 0F, -0.2F, -0.7F); // Box 251
        wheel_front_right[51].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[52].addShapeBox(3.7F, -6.7F, 4.5F, 3, 2, 1, 0F, -2F, 1F, 0F, 1F, -1F, 0F, 0.8F, -1F, -0.7F, -1.9F, 0.8F, -0.7F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F, -0.4F, 0.3F, -0.7F, -0.7F, -1.6F, -0.7F); // Box 252
        wheel_front_right[52].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[53].addShapeBox(7.5F, -4.5F, 4.5F, 2, 3, 1, 0F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F, -2F, 1.2F, -0.7F, 1.2F, -0.1F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F); // Box 253
        wheel_front_right[53].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[54].addShapeBox(7.5F, -1.5F, 4.5F, 2, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F); // Box 254
        wheel_front_right[54].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[55].addShapeBox(7.5F, 1.5F, 4.5F, 2, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F, -2F, 1.2F, -0.7F, 1.2F, -0.1F, -0.7F); // Box 255
        wheel_front_right[55].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[56].addShapeBox(3.7F, 4.7F, 4.5F, 3, 2, 1, 0F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F, -0.4F, 0.3F, -0.7F, -0.7F, -1.6F, -0.7F, -2F, 1F, 0F, 1F, -1F, 0F, 0.8F, -1F, -0.7F, -1.9F, 0.8F, -0.7F); // Box 256
        wheel_front_right[56].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[57].addShapeBox(1.5F, 7.5F, 4.5F, 3, 2, 1, 0F, 0F, 0F, 0F, -0.3F, 1.3F, 0F, -0.1F, 1.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 1.2F, -1.8F, 0F, 1.1F, -2F, -0.7F, 0F, -0.2F, -0.7F); // Box 257
        wheel_front_right[57].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[58].addShapeBox(-1.5F, 7.5F, 4.5F, 3, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F); // Box 258
        wheel_front_right[58].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[59].addShapeBox(-4.5F, 7.5F, 4.5F, 3, 2, 1, 0F, -0.3F, 1.3F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, -0.1F, 1.2F, -0.7F, 1.2F, -1.8F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 1.1F, -2F, -0.7F); // Box 259
        wheel_front_right[59].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[60].addShapeBox(-6.7F, 4.7F, 4.5F, 3, 2, 1, 0F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -0.7F, -1.6F, -0.7F, -0.4F, 0.3F, -0.7F, 1F, -1F, 0F, -2F, 1F, 0F, -1.9F, 0.8F, -0.7F, 0.8F, -1F, -0.7F); // Box 260
        wheel_front_right[60].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[61].addShapeBox(-9.5F, 1.5F, 4.5F, 2, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F, 1.2F, -0.1F, -0.7F, -2F, 1.2F, -0.7F); // Box 261
        wheel_front_right[61].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[62].addShapeBox(-9.5F, -1.5F, 4.5F, 2, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F); // Box 262
        wheel_front_right[62].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[63].addShapeBox(-9.5F, -4.5F, 4.5F, 2, 3, 1, 0F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F, 1.2F, -0.1F, -0.7F, -2F, 1.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F); // Box 263
        wheel_front_right[63].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[64].addShapeBox(-6.7F, -6.7F, 4.5F, 3, 2, 1, 0F, 1F, -1F, 0F, -2F, 1F, 0F, -1.9F, 0.8F, -0.7F, 0.8F, -1F, -0.7F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -0.7F, -1.6F, -0.7F, -0.4F, 0.3F, -0.7F); // Box 264
        wheel_front_right[64].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[65].addShapeBox(-4.5F, -9.5F, 4.5F, 3, 2, 1, 0F, 1.2F, -1.8F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 1.1F, -2F, -0.7F, -0.3F, 1.3F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, -0.1F, 1.2F, -0.7F); // Box 265
        wheel_front_right[65].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[66].addShapeBox(1.5F, -0.5F, -0.5F, 6, 1, 1, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 266
        wheel_front_right[66].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[67].addShapeBox(-7.5F, -0.5F, -0.5F, 6, 1, 1, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 267
        wheel_front_right[67].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[68].addShapeBox(-0.5F, -7.5F, -0.5F, 1, 6, 1, 0F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 268
        wheel_front_right[68].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[69].addShapeBox(-0.5F, 1.5F, -0.5F, 1, 6, 1, 0F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 269
        wheel_front_right[69].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[70].addShapeBox(-0.5F, 1.5F, -0.5F, 1, 6, 1, 0F, -1.35F, 0.15F, -0.5F, 0.35F, 0.15F, -0.5F, 0.7F, 0.45F, 0F, -0.85F, -0.05F, 0F, -4.25F, -1.1F, -0.5F, 3.3F, -1F, -0.5F, 3.7F, -1.25F, 0F, -3.8F, -0.75F, 0F); // Box 270
        wheel_front_right[70].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[71].addShapeBox(-0.5F, 1.5F, -0.5F, 1, 6, 1, 0F, 0.35F, 0.15F, -0.5F, -1.35F, 0.15F, -0.5F, -0.85F, -0.05F, 0F, 0.7F, 0.45F, 0F, 3.3F, -1F, -0.5F, -4.25F, -1.1F, -0.5F, -3.8F, -0.75F, 0F, 3.7F, -1.25F, 0F); // Box 271
        wheel_front_right[71].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[72].addShapeBox(-0.5F, -7.5F, -0.5F, 1, 6, 1, 0F, 3.3F, -1F, -0.5F, -4.25F, -1.1F, -0.5F, -3.8F, -0.75F, 0F, 3.7F, -1.25F, 0F, 0.35F, 0.15F, -0.5F, -1.35F, 0.15F, -0.5F, -0.85F, -0.05F, 0F, 0.7F, 0.45F, 0F); // Box 272
        wheel_front_right[72].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[73].addShapeBox(-0.5F, -7.5F, -0.5F, 1, 6, 1, 0F, -4.25F, -1.1F, -0.5F, 3.3F, -1F, -0.5F, 3.7F, -1.25F, 0F, -3.8F, -0.75F, 0F, -1.35F, 0.15F, -0.5F, 0.35F, 0.15F, -0.5F, 0.7F, 0.45F, 0F, -0.85F, -0.05F, 0F); // Box 273
        wheel_front_right[73].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[74].addShapeBox(1.5F, -0.5F, -0.5F, 6, 1, 1, 0F, 0.3F, 0.15F, -0.5F, -1.05F, 3.15F, -0.5F, -1.25F, 3.7F, 0F, 0.45F, 0.7F, 0F, 0.15F, -1.25F, -0.5F, -0.85F, -4.25F, -0.5F, -0.75F, -3.8F, 0F, -0.05F, -0.8F, 0F); // Box 274
        wheel_front_right[74].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[75].addShapeBox(1.5F, -0.5F, -0.5F, 6, 1, 1, 0F, 0.15F, -1.25F, -0.5F, -0.85F, -4.25F, -0.5F, -0.75F, -3.8F, 0F, -0.05F, -0.8F, 0F, 0.3F, 0.15F, -0.5F, -1.05F, 3.15F, -0.5F, -1.25F, 3.7F, 0F, 0.45F, 0.7F, 0F); // Box 275
        wheel_front_right[75].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[76].addShapeBox(-7.5F, -0.5F, -0.5F, 6, 1, 1, 0F, -0.85F, -4.25F, -0.5F, 0.15F, -1.25F, -0.5F, -0.05F, -0.8F, 0F, -0.75F, -3.8F, 0F, -1.05F, 3.15F, -0.5F, 0.3F, 0.15F, -0.5F, 0.45F, 0.7F, 0F, -1.25F, 3.7F, 0F); // Box 276
        wheel_front_right[76].setRotationPoint(43.5F, 0.5F, -20F);

        wheel_front_right[77].addShapeBox(-7.5F, -0.5F, -0.5F, 6, 1, 1, 0F, -1.05F, 3.15F, -0.5F, 0.3F, 0.15F, -0.5F, 0.45F, 0.7F, 0F, -1.25F, 3.7F, 0F, -0.85F, -4.25F, -0.5F, 0.15F, -1.25F, -0.5F, -0.05F, -0.8F, 0F, -0.75F, -3.8F, 0F); // Box 277
        wheel_front_right[77].setRotationPoint(43.5F, 0.5F, -20F);
        this.add("wheel_front_right", wheel_front_right);

        ModelRendererTurbo[] wheel_back_left = new ModelRendererTurbo[78];
        wheel_back_left[0] = new ModelRendererTurbo(this, 177, 1, textureX, textureY); // Box 7
        wheel_back_left[1] = new ModelRendererTurbo(this, 353, 57, textureX, textureY); // Box 278
        wheel_back_left[2] = new ModelRendererTurbo(this, 417, 57, textureX, textureY); // Box 279
        wheel_back_left[3] = new ModelRendererTurbo(this, 433, 57, textureX, textureY); // Box 280
        wheel_back_left[4] = new ModelRendererTurbo(this, 449, 57, textureX, textureY); // Box 281
        wheel_back_left[5] = new ModelRendererTurbo(this, 465, 57, textureX, textureY); // Box 282
        wheel_back_left[6] = new ModelRendererTurbo(this, 473, 57, textureX, textureY); // Box 283
        wheel_back_left[7] = new ModelRendererTurbo(this, 1, 65, textureX, textureY); // Box 284
        wheel_back_left[8] = new ModelRendererTurbo(this, 497, 57, textureX, textureY); // Box 285
        wheel_back_left[9] = new ModelRendererTurbo(this, 25, 65, textureX, textureY); // Box 286
        wheel_back_left[10] = new ModelRendererTurbo(this, 41, 65, textureX, textureY); // Box 287
        wheel_back_left[11] = new ModelRendererTurbo(this, 65, 65, textureX, textureY); // Box 288
        wheel_back_left[12] = new ModelRendererTurbo(this, 89, 65, textureX, textureY); // Box 289
        wheel_back_left[13] = new ModelRendererTurbo(this, 113, 65, textureX, textureY); // Box 290
        wheel_back_left[14] = new ModelRendererTurbo(this, 137, 65, textureX, textureY); // Box 291
        wheel_back_left[15] = new ModelRendererTurbo(this, 161, 65, textureX, textureY); // Box 292
        wheel_back_left[16] = new ModelRendererTurbo(this, 185, 65, textureX, textureY); // Box 293
        wheel_back_left[17] = new ModelRendererTurbo(this, 209, 65, textureX, textureY); // Box 294
        wheel_back_left[18] = new ModelRendererTurbo(this, 233, 65, textureX, textureY); // Box 295
        wheel_back_left[19] = new ModelRendererTurbo(this, 249, 65, textureX, textureY); // Box 296
        wheel_back_left[20] = new ModelRendererTurbo(this, 265, 65, textureX, textureY); // Box 297
        wheel_back_left[21] = new ModelRendererTurbo(this, 281, 65, textureX, textureY); // Box 298
        wheel_back_left[22] = new ModelRendererTurbo(this, 489, 57, textureX, textureY); // Box 299
        wheel_back_left[23] = new ModelRendererTurbo(this, 17, 65, textureX, textureY); // Box 300
        wheel_back_left[24] = new ModelRendererTurbo(this, 57, 65, textureX, textureY); // Box 301
        wheel_back_left[25] = new ModelRendererTurbo(this, 81, 65, textureX, textureY); // Box 302
        wheel_back_left[26] = new ModelRendererTurbo(this, 105, 65, textureX, textureY); // Box 303
        wheel_back_left[27] = new ModelRendererTurbo(this, 129, 65, textureX, textureY); // Box 304
        wheel_back_left[28] = new ModelRendererTurbo(this, 153, 65, textureX, textureY); // Box 305
        wheel_back_left[29] = new ModelRendererTurbo(this, 177, 65, textureX, textureY); // Box 306
        wheel_back_left[30] = new ModelRendererTurbo(this, 201, 65, textureX, textureY); // Box 307
        wheel_back_left[31] = new ModelRendererTurbo(this, 225, 65, textureX, textureY); // Box 308
        wheel_back_left[32] = new ModelRendererTurbo(this, 297, 65, textureX, textureY); // Box 309
        wheel_back_left[33] = new ModelRendererTurbo(this, 313, 65, textureX, textureY); // Box 310
        wheel_back_left[34] = new ModelRendererTurbo(this, 329, 65, textureX, textureY); // Box 311
        wheel_back_left[35] = new ModelRendererTurbo(this, 337, 65, textureX, textureY); // Box 312
        wheel_back_left[36] = new ModelRendererTurbo(this, 345, 65, textureX, textureY); // Box 313
        wheel_back_left[37] = new ModelRendererTurbo(this, 353, 65, textureX, textureY); // Box 314
        wheel_back_left[38] = new ModelRendererTurbo(this, 361, 65, textureX, textureY); // Box 315
        wheel_back_left[39] = new ModelRendererTurbo(this, 369, 65, textureX, textureY); // Box 316
        wheel_back_left[40] = new ModelRendererTurbo(this, 377, 65, textureX, textureY); // Box 317
        wheel_back_left[41] = new ModelRendererTurbo(this, 401, 65, textureX, textureY); // Box 318
        wheel_back_left[42] = new ModelRendererTurbo(this, 425, 65, textureX, textureY); // Box 319
        wheel_back_left[43] = new ModelRendererTurbo(this, 441, 65, textureX, textureY); // Box 320
        wheel_back_left[44] = new ModelRendererTurbo(this, 457, 65, textureX, textureY); // Box 321
        wheel_back_left[45] = new ModelRendererTurbo(this, 473, 65, textureX, textureY); // Box 322
        wheel_back_left[46] = new ModelRendererTurbo(this, 481, 65, textureX, textureY); // Box 323
        wheel_back_left[47] = new ModelRendererTurbo(this, 489, 65, textureX, textureY); // Box 324
        wheel_back_left[48] = new ModelRendererTurbo(this, 1, 73, textureX, textureY); // Box 325
        wheel_back_left[49] = new ModelRendererTurbo(this, 17, 73, textureX, textureY); // Box 326
        wheel_back_left[50] = new ModelRendererTurbo(this, 41, 73, textureX, textureY); // Box 327
        wheel_back_left[51] = new ModelRendererTurbo(this, 57, 73, textureX, textureY); // Box 328
        wheel_back_left[52] = new ModelRendererTurbo(this, 73, 73, textureX, textureY); // Box 329
        wheel_back_left[53] = new ModelRendererTurbo(this, 89, 73, textureX, textureY); // Box 330
        wheel_back_left[54] = new ModelRendererTurbo(this, 97, 73, textureX, textureY); // Box 331
        wheel_back_left[55] = new ModelRendererTurbo(this, 105, 73, textureX, textureY); // Box 332
        wheel_back_left[56] = new ModelRendererTurbo(this, 113, 73, textureX, textureY); // Box 333
        wheel_back_left[57] = new ModelRendererTurbo(this, 129, 73, textureX, textureY); // Box 334
        wheel_back_left[58] = new ModelRendererTurbo(this, 145, 73, textureX, textureY); // Box 335
        wheel_back_left[59] = new ModelRendererTurbo(this, 153, 73, textureX, textureY); // Box 336
        wheel_back_left[60] = new ModelRendererTurbo(this, 161, 73, textureX, textureY); // Box 337
        wheel_back_left[61] = new ModelRendererTurbo(this, 169, 73, textureX, textureY); // Box 338
        wheel_back_left[62] = new ModelRendererTurbo(this, 177, 73, textureX, textureY); // Box 339
        wheel_back_left[63] = new ModelRendererTurbo(this, 201, 73, textureX, textureY); // Box 340
        wheel_back_left[64] = new ModelRendererTurbo(this, 297, 73, textureX, textureY); // Box 341
        wheel_back_left[65] = new ModelRendererTurbo(this, 321, 73, textureX, textureY); // Box 342
        wheel_back_left[66] = new ModelRendererTurbo(this, 225, 73, textureX, textureY); // Box 343
        wheel_back_left[67] = new ModelRendererTurbo(this, 345, 73, textureX, textureY); // Box 344
        wheel_back_left[68] = new ModelRendererTurbo(this, 377, 73, textureX, textureY); // Box 345
        wheel_back_left[69] = new ModelRendererTurbo(this, 393, 73, textureX, textureY); // Box 346
        wheel_back_left[70] = new ModelRendererTurbo(this, 353, 73, textureX, textureY); // Box 347
        wheel_back_left[71] = new ModelRendererTurbo(this, 409, 73, textureX, textureY); // Box 348
        wheel_back_left[72] = new ModelRendererTurbo(this, 417, 73, textureX, textureY); // Box 349
        wheel_back_left[73] = new ModelRendererTurbo(this, 425, 73, textureX, textureY); // Box 350
        wheel_back_left[74] = new ModelRendererTurbo(this, 433, 73, textureX, textureY); // Box 351
        wheel_back_left[75] = new ModelRendererTurbo(this, 449, 73, textureX, textureY); // Box 352
        wheel_back_left[76] = new ModelRendererTurbo(this, 465, 73, textureX, textureY); // Box 353
        wheel_back_left[77] = new ModelRendererTurbo(this, 481, 73, textureX, textureY); // Box 354

        wheel_back_left[0].addBox(-1.5F, -1.5F, -3F, 3, 3, 3, 0F); // Box 7
        wheel_back_left[0].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[1].addShapeBox(-1F, -1F, 0F, 2, 2, 1, 0F, 0.5F, 0.5F, 0F, 0.5F, 0.5F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0.5F, 0.5F, 0F, 0.5F, 0.5F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 278
        wheel_back_left[1].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[2].addShapeBox(-2.5F, -0.5F, -3F, 1, 1, 3, 0F, -0.4F, -0.5F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, -0.4F, -0.5F, 0F, -0.4F, -0.5F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, -0.4F, -0.5F, 0F); // Box 279
        wheel_back_left[2].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[3].addShapeBox(1.5F, -0.5F, -3F, 1, 1, 3, 0F, 0F, 0.1F, 0F, -0.4F, -0.5F, 0F, -0.4F, -0.5F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, -0.4F, -0.5F, 0F, -0.4F, -0.5F, 0F, 0F, 0.1F, 0F); // Box 280
        wheel_back_left[3].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[4].addShapeBox(-0.5F, -2.5F, -3F, 1, 1, 3, 0F, -0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 281
        wheel_back_left[4].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[5].addShapeBox(-0.5F, 1.5F, -3F, 1, 1, 3, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, -0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F); // Box 282
        wheel_back_left[5].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[6].addBox(-1.5F, -9.5F, -4.5F, 3, 2, 5, 0F); // Box 283
        wheel_back_left[6].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[7].addBox(-1.5F, 7.5F, -4.5F, 3, 2, 5, 0F); // Box 284
        wheel_back_left[7].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[8].addBox(7.5F, -1.5F, -4.5F, 2, 3, 5, 0F); // Box 285
        wheel_back_left[8].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[9].addBox(-9.5F, -1.5F, -4.5F, 2, 3, 5, 0F); // Box 286
        wheel_back_left[9].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[10].addShapeBox(3.7F, 4.7F, -4.5F, 3, 2, 5, 0F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -2F, 1F, 0F, 1F, -1F, 0F, 1F, -1F, 0F, -2F, 1F, 0F); // Box 287
        wheel_back_left[10].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[11].addShapeBox(5.2F, -7.2F, -4.5F, 3, 2, 5, 0F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F, 1F, -1F, 0F, -2F, 1F, 0F, -2F, 1F, 0F, 1F, -1F, 0F); // Box 288
        wheel_back_left[11].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[12].addShapeBox(-6.7F, -6.7F, -4.5F, 3, 2, 5, 0F, 1F, -1F, 0F, -2F, 1F, 0F, -2F, 1F, 0F, 1F, -1F, 0F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F); // Box 289
        wheel_back_left[12].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[13].addShapeBox(-6.7F, 4.7F, -4.5F, 3, 2, 5, 0F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F, 1F, -1F, 0F, -2F, 1F, 0F, -2F, 1F, 0F, 1F, -1F, 0F); // Box 290
        wheel_back_left[13].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[14].addShapeBox(-4.5F, 7.5F, -4.5F, 3, 2, 5, 0F, -0.3F, 1.3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, 1.3F, 0F, 1.2F, -1.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1.2F, -1.8F, 0F); // Box 291
        wheel_back_left[14].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[15].addShapeBox(1.5F, 7.5F, -4.5F, 3, 2, 5, 0F, 0F, 0F, 0F, -0.3F, 1.3F, 0F, -0.3F, 1.3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1.2F, -1.8F, 0F, 1.2F, -1.8F, 0F, 0F, 0F, 0F); // Box 292
        wheel_back_left[15].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[16].addShapeBox(1.5F, -9.5F, -4.5F, 3, 2, 5, 0F, 0F, 0F, 0F, 1.2F, -1.8F, 0F, 1.2F, -1.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, 1.3F, 0F, -0.3F, 1.3F, 0F, 0F, 0F, 0F); // Box 293
        wheel_back_left[16].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[17].addShapeBox(-4.5F, -9.5F, -4.5F, 3, 2, 5, 0F, 1.2F, -1.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1.2F, -1.8F, 0F, -0.3F, 1.3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, 1.3F, 0F); // Box 294
        wheel_back_left[17].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[18].addShapeBox(7.5F, 1.5F, -4.5F, 2, 3, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F); // Box 295
        wheel_back_left[18].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[19].addShapeBox(7.5F, -4.5F, -4.5F, 2, 3, 5, 0F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 296
        wheel_back_left[19].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[20].addShapeBox(-9.5F, -4.5F, -4.5F, 2, 3, 5, 0F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 297
        wheel_back_left[20].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[21].addShapeBox(-9.5F, 1.5F, -4.5F, 2, 3, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F); // Box 298
        wheel_back_left[21].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[22].addShapeBox(-1.5F, -9.5F, 0.5F, 3, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F); // Box 299
        wheel_back_left[22].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[23].addShapeBox(-1.5F, 7.5F, 0.5F, 3, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F); // Box 300
        wheel_back_left[23].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[24].addShapeBox(7.5F, -1.5F, 0.5F, 2, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F); // Box 301
        wheel_back_left[24].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[25].addShapeBox(-9.5F, -1.5F, 0.5F, 2, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F); // Box 302
        wheel_back_left[25].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[26].addShapeBox(3.7F, 4.7F, 0.5F, 3, 2, 1, 0F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F, -0.4F, 0.3F, -0.7F, -0.7F, -1.6F, -0.7F, -2F, 1F, 0F, 1F, -1F, 0F, 0.8F, -1F, -0.7F, -1.9F, 0.8F, -0.7F); // Box 303
        wheel_back_left[26].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[27].addShapeBox(3.7F, -6.7F, 0.5F, 3, 2, 1, 0F, -2F, 1F, 0F, 1F, -1F, 0F, 0.8F, -1F, -0.7F, -1.9F, 0.8F, -0.7F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F, -0.4F, 0.3F, -0.7F, -0.7F, -1.6F, -0.7F); // Box 304
        wheel_back_left[27].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[28].addShapeBox(-6.7F, 4.7F, 0.5F, 3, 2, 1, 0F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -0.7F, -1.6F, -0.7F, -0.4F, 0.3F, -0.7F, 1F, -1F, 0F, -2F, 1F, 0F, -1.9F, 0.8F, -0.7F, 0.8F, -1F, -0.7F); // Box 305
        wheel_back_left[28].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[29].addShapeBox(-6.7F, -6.7F, 0.5F, 3, 2, 1, 0F, 1F, -1F, 0F, -2F, 1F, 0F, -1.9F, 0.8F, -0.7F, 0.8F, -1F, -0.7F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -0.7F, -1.6F, -0.7F, -0.4F, 0.3F, -0.7F); // Box 306
        wheel_back_left[29].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[30].addShapeBox(1.5F, 7.5F, 0.5F, 3, 2, 1, 0F, 0F, 0F, 0F, -0.3F, 1.3F, 0F, -0.1F, 1.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 1.2F, -1.8F, 0F, 1.1F, -2F, -0.7F, 0F, -0.2F, -0.7F); // Box 307
        wheel_back_left[30].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[31].addShapeBox(-4.5F, 7.5F, 0.5F, 3, 2, 1, 0F, -0.3F, 1.3F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, -0.1F, 1.2F, -0.7F, 1.2F, -1.8F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 1.1F, -2F, -0.7F); // Box 308
        wheel_back_left[31].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[32].addShapeBox(-4.5F, -9.5F, 0.5F, 3, 2, 1, 0F, 1.2F, -1.8F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 1.1F, -2F, -0.7F, -0.3F, 1.3F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, -0.1F, 1.2F, -0.7F); // Box 309
        wheel_back_left[32].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[33].addShapeBox(1.5F, -9.5F, 0.5F, 3, 2, 1, 0F, 0F, 0F, 0F, 1.2F, -1.8F, 0F, 1.1F, -2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, -0.3F, 1.3F, 0F, -0.1F, 1.2F, -0.7F, 0F, -0.2F, -0.7F); // Box 310
        wheel_back_left[33].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[34].addShapeBox(-9.5F, 1.5F, 0.5F, 2, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F, 1.2F, -0.1F, -0.7F, -2F, 1.2F, -0.7F); // Box 311
        wheel_back_left[34].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[35].addShapeBox(-9.5F, -4.5F, 0.5F, 2, 3, 1, 0F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F, 1.2F, -0.1F, -0.7F, -2F, 1.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F); // Box 312
        wheel_back_left[35].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[36].addShapeBox(7.5F, -4.5F, 0.5F, 2, 3, 1, 0F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F, -2F, 1.2F, -0.7F, 1.2F, -0.1F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F); // Box 313
        wheel_back_left[36].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[37].addShapeBox(7.5F, 1.5F, 0.5F, 2, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F, -2F, 1.2F, -0.7F, 1.2F, -0.1F, -0.7F); // Box 314
        wheel_back_left[37].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[38].addBox(-0.5F, 1.5F, -2.5F, 1, 6, 2, 0F); // Box 315
        wheel_back_left[38].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[39].addBox(-0.5F, -7.5F, -2.5F, 1, 6, 2, 0F); // Box 316
        wheel_back_left[39].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[40].addBox(1.5F, -0.5F, -2.5F, 6, 1, 2, 0F); // Box 317
        wheel_back_left[40].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[41].addBox(-7.5F, -0.5F, -2.5F, 6, 1, 2, 0F); // Box 318
        wheel_back_left[41].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[42].addShapeBox(-1.5F, -9.5F, -5.5F, 3, 2, 1, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 319
        wheel_back_left[42].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[43].addShapeBox(-4.5F, -9.5F, -5.5F, 3, 2, 1, 0F, 1.1F, -2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 1.2F, -1.8F, 0F, -0.1F, 1.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, -0.3F, 1.3F, 0F); // Box 320
        wheel_back_left[43].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[44].addShapeBox(-6.7F, -6.7F, -5.5F, 3, 2, 1, 0F, 0.8F, -1F, -0.7F, -1.9F, 0.8F, -0.7F, -2F, 1F, 0F, 1F, -1F, 0F, -0.4F, 0.3F, -0.7F, -0.7F, -1.6F, -0.7F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F); // Box 321
        wheel_back_left[44].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[45].addShapeBox(-9.5F, -4.5F, -5.5F, 2, 3, 1, 0F, -2F, 1.2F, -0.7F, 1.2F, -0.1F, -0.7F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 322
        wheel_back_left[45].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[46].addShapeBox(-9.5F, -1.5F, -5.5F, 2, 3, 1, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 323
        wheel_back_left[46].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[47].addShapeBox(-9.5F, 1.5F, -5.5F, 2, 3, 1, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 1.2F, -0.7F, 1.2F, -0.1F, -0.7F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F); // Box 324
        wheel_back_left[47].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[48].addShapeBox(-6.7F, 4.7F, -5.5F, 3, 2, 1, 0F, -0.4F, 0.3F, -0.7F, -0.7F, -1.6F, -0.7F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F, 0.8F, -1F, -0.7F, -1.9F, 0.8F, -0.7F, -2F, 1F, 0F, 1F, -1F, 0F); // Box 325
        wheel_back_left[48].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[49].addShapeBox(-4.5F, 7.5F, -5.5F, 3, 2, 1, 0F, -0.1F, 1.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, -0.3F, 1.3F, 0F, 1.1F, -2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 1.2F, -1.8F, 0F); // Box 326
        wheel_back_left[49].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[50].addShapeBox(-1.5F, 7.5F, -5.5F, 3, 2, 1, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 327
        wheel_back_left[50].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[51].addShapeBox(1.5F, 7.5F, -5.5F, 3, 2, 1, 0F, 0F, -0.2F, -0.7F, -0.1F, 1.2F, -0.7F, -0.3F, 1.3F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 1.1F, -2F, -0.7F, 1.2F, -1.8F, 0F, 0F, 0F, 0F); // Box 328
        wheel_back_left[51].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[52].addShapeBox(3.7F, 4.7F, -5.5F, 3, 2, 1, 0F, -0.7F, -1.6F, -0.7F, -0.4F, 0.3F, -0.7F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -1.9F, 0.8F, -0.7F, 0.8F, -1F, -0.7F, 1F, -1F, 0F, -2F, 1F, 0F); // Box 329
        wheel_back_left[52].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[53].addShapeBox(7.5F, 1.5F, -5.5F, 2, 3, 1, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 1.2F, -0.1F, -0.7F, -2F, 1.2F, -0.7F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F); // Box 330
        wheel_back_left[53].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[54].addShapeBox(7.5F, -1.5F, -5.5F, 2, 3, 1, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 331
        wheel_back_left[54].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[55].addShapeBox(7.5F, -4.5F, -5.5F, 2, 3, 1, 0F, 1.2F, -0.1F, -0.7F, -2F, 1.2F, -0.7F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 332
        wheel_back_left[55].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[56].addShapeBox(3.7F, -6.7F, -5.5F, 3, 2, 1, 0F, -1.9F, 0.8F, -0.7F, 0.8F, -1F, -0.7F, 1F, -1F, 0F, -2F, 1F, 0F, -0.7F, -1.6F, -0.7F, -0.4F, 0.3F, -0.7F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F); // Box 333
        wheel_back_left[56].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[57].addShapeBox(1.5F, -9.5F, -5.5F, 3, 2, 1, 0F, 0F, -0.2F, -0.7F, 1.1F, -2F, -0.7F, 1.2F, -1.8F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, -0.1F, 1.2F, -0.7F, -0.3F, 1.3F, 0F, 0F, 0F, 0F); // Box 334
        wheel_back_left[57].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[58].addShapeBox(-0.5F, 1.5F, -2.5F, 1, 6, 2, 0F, -0.85F, -0.05F, 0F, 0.7F, 0.45F, 0F, 0.7F, 0.45F, 0F, -0.85F, -0.05F, 0F, -3.8F, -0.75F, 0F, 3.7F, -1.25F, 0F, 3.7F, -1.25F, 0F, -3.8F, -0.75F, 0F); // Box 335
        wheel_back_left[58].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[59].addShapeBox(-0.5F, 1.5F, -2.5F, 1, 6, 2, 0F, 0.7F, 0.45F, 0F, -0.85F, -0.05F, 0F, -0.85F, -0.05F, 0F, 0.7F, 0.45F, 0F, 3.7F, -1.25F, 0F, -3.8F, -0.75F, 0F, -3.8F, -0.75F, 0F, 3.7F, -1.25F, 0F); // Box 336
        wheel_back_left[59].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[60].addShapeBox(-0.5F, -7.5F, -2.5F, 1, 6, 2, 0F, 3.7F, -1.25F, 0F, -3.8F, -0.75F, 0F, -3.8F, -0.75F, 0F, 3.7F, -1.25F, 0F, 0.7F, 0.45F, 0F, -0.85F, -0.05F, 0F, -0.85F, -0.05F, 0F, 0.7F, 0.45F, 0F); // Box 337
        wheel_back_left[60].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[61].addShapeBox(-0.5F, -7.5F, -2.5F, 1, 6, 2, 0F, -3.8F, -0.75F, 0F, 3.7F, -1.25F, 0F, 3.7F, -1.25F, 0F, -3.8F, -0.75F, 0F, -0.85F, -0.05F, 0F, 0.7F, 0.45F, 0F, 0.7F, 0.45F, 0F, -0.85F, -0.05F, 0F); // Box 338
        wheel_back_left[61].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[62].addShapeBox(-7.5F, -0.5F, -2.5F, 6, 1, 2, 0F, -0.75F, -3.8F, 0F, -0.05F, -0.8F, 0F, -0.05F, -0.8F, 0F, -0.75F, -3.8F, 0F, -1.25F, 3.7F, 0F, 0.45F, 0.7F, 0F, 0.45F, 0.7F, 0F, -1.25F, 3.7F, 0F); // Box 339
        wheel_back_left[62].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[63].addShapeBox(-7.5F, -0.5F, -2.5F, 6, 1, 2, 0F, -1.25F, 3.7F, 0F, 0.45F, 0.7F, 0F, 0.45F, 0.7F, 0F, -1.25F, 3.7F, 0F, -0.75F, -3.8F, 0F, -0.05F, -0.8F, 0F, -0.05F, -0.8F, 0F, -0.75F, -3.8F, 0F); // Box 340
        wheel_back_left[63].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[64].addShapeBox(1.5F, -0.5F, -2.5F, 6, 1, 2, 0F, 0.45F, 0.7F, 0F, -1.25F, 3.7F, 0F, -1.25F, 3.7F, 0F, 0.45F, 0.7F, 0F, -0.05F, -0.8F, 0F, -0.75F, -3.8F, 0F, -0.75F, -3.8F, 0F, -0.05F, -0.8F, 0F); // Box 341
        wheel_back_left[64].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[65].addShapeBox(1.5F, -0.5F, -2.5F, 6, 1, 2, 0F, -0.05F, -0.8F, 0F, -0.75F, -3.8F, 0F, -0.75F, -3.8F, 0F, -0.05F, -0.8F, 0F, 0.45F, 0.7F, 0F, -1.25F, 3.7F, 0F, -1.25F, 3.7F, 0F, 0.45F, 0.7F, 0F); // Box 342
        wheel_back_left[65].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[66].addShapeBox(-0.5F, 1.5F, -0.5F, 1, 6, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F); // Box 343
        wheel_back_left[66].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[67].addShapeBox(-0.5F, -7.5F, -0.5F, 1, 6, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F); // Box 344
        wheel_back_left[67].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[68].addShapeBox(1.5F, -0.5F, -0.5F, 6, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 345
        wheel_back_left[68].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[69].addShapeBox(-7.5F, -0.5F, -0.5F, 6, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 346
        wheel_back_left[69].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[70].addShapeBox(-0.5F, 1.5F, -0.5F, 1, 6, 1, 0F, -0.85F, -0.05F, 0F, 0.7F, 0.45F, 0F, 0.35F, 0.15F, -0.5F, -1.35F, 0.15F, -0.5F, -3.8F, -0.75F, 0F, 3.7F, -1.25F, 0F, 3.3F, -1F, -0.5F, -4.25F, -1.1F, -0.5F); // Box 347
        wheel_back_left[70].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[71].addShapeBox(-0.5F, 1.5F, -0.5F, 1, 6, 1, 0F, 0.7F, 0.45F, 0F, -0.85F, -0.05F, 0F, -1.35F, 0.15F, -0.5F, 0.35F, 0.15F, -0.5F, 3.7F, -1.25F, 0F, -3.8F, -0.75F, 0F, -4.25F, -1.1F, -0.5F, 3.3F, -1F, -0.5F); // Box 348
        wheel_back_left[71].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[72].addShapeBox(-0.5F, -7.5F, -0.5F, 1, 6, 1, 0F, 3.7F, -1.25F, 0F, -3.8F, -0.75F, 0F, -4.25F, -1.1F, -0.5F, 3.3F, -1F, -0.5F, 0.7F, 0.45F, 0F, -0.85F, -0.05F, 0F, -1.35F, 0.15F, -0.5F, 0.35F, 0.15F, -0.5F); // Box 349
        wheel_back_left[72].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[73].addShapeBox(-0.5F, -7.5F, -0.5F, 1, 6, 1, 0F, -3.8F, -0.75F, 0F, 3.7F, -1.25F, 0F, 3.3F, -1F, -0.5F, -4.25F, -1.1F, -0.5F, -0.85F, -0.05F, 0F, 0.7F, 0.45F, 0F, 0.35F, 0.15F, -0.5F, -1.35F, 0.15F, -0.5F); // Box 350
        wheel_back_left[73].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[74].addShapeBox(1.5F, -0.5F, -0.5F, 6, 1, 1, 0F, -0.05F, -0.8F, 0F, -0.75F, -3.8F, 0F, -0.85F, -4.25F, -0.5F, 0.15F, -1.25F, -0.5F, 0.45F, 0.7F, 0F, -1.25F, 3.7F, 0F, -1.05F, 3.15F, -0.5F, 0.3F, 0.15F, -0.5F); // Box 351
        wheel_back_left[74].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[75].addShapeBox(1.5F, -0.5F, -0.5F, 6, 1, 1, 0F, 0.45F, 0.7F, 0F, -1.25F, 3.7F, 0F, -1.05F, 3.15F, -0.5F, 0.3F, 0.15F, -0.5F, -0.05F, -0.8F, 0F, -0.75F, -3.8F, 0F, -0.85F, -4.25F, -0.5F, 0.15F, -1.25F, -0.5F); // Box 352
        wheel_back_left[75].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[76].addShapeBox(-7.5F, -0.5F, -0.5F, 6, 1, 1, 0F, -1.25F, 3.7F, 0F, 0.45F, 0.7F, 0F, 0.3F, 0.15F, -0.5F, -1.05F, 3.15F, -0.5F, -0.75F, -3.8F, 0F, -0.05F, -0.8F, 0F, 0.15F, -1.25F, -0.5F, -0.85F, -4.25F, -0.5F); // Box 353
        wheel_back_left[76].setRotationPoint(-43.5F, 0.5F, 20F);

        wheel_back_left[77].addShapeBox(-7.5F, -0.5F, -0.5F, 6, 1, 1, 0F, -0.75F, -3.8F, 0F, -0.05F, -0.8F, 0F, 0.15F, -1.25F, -0.5F, -0.85F, -4.25F, -0.5F, -1.25F, 3.7F, 0F, 0.45F, 0.7F, 0F, 0.3F, 0.15F, -0.5F, -1.05F, 3.15F, -0.5F); // Box 354
        wheel_back_left[77].setRotationPoint(-43.5F, 0.5F, 20F);
        this.add("wheel_back_left", wheel_back_left);

        ModelRendererTurbo[] wheel_back_right = new ModelRendererTurbo[78];
        wheel_back_right[0] = new ModelRendererTurbo(this, 217, 1, textureX, textureY); // Box 8
        wheel_back_right[1] = new ModelRendererTurbo(this, 497, 73, textureX, textureY); // Box 355
        wheel_back_right[2] = new ModelRendererTurbo(this, 1, 81, textureX, textureY); // Box 356
        wheel_back_right[3] = new ModelRendererTurbo(this, 25, 81, textureX, textureY); // Box 357
        wheel_back_right[4] = new ModelRendererTurbo(this, 49, 81, textureX, textureY); // Box 358
        wheel_back_right[5] = new ModelRendererTurbo(this, 65, 81, textureX, textureY); // Box 359
        wheel_back_right[6] = new ModelRendererTurbo(this, 81, 81, textureX, textureY); // Box 360
        wheel_back_right[7] = new ModelRendererTurbo(this, 105, 81, textureX, textureY); // Box 361
        wheel_back_right[8] = new ModelRendererTurbo(this, 129, 81, textureX, textureY); // Box 362
        wheel_back_right[9] = new ModelRendererTurbo(this, 177, 81, textureX, textureY); // Box 363
        wheel_back_right[10] = new ModelRendererTurbo(this, 201, 81, textureX, textureY); // Box 364
        wheel_back_right[11] = new ModelRendererTurbo(this, 225, 81, textureX, textureY); // Box 365
        wheel_back_right[12] = new ModelRendererTurbo(this, 249, 81, textureX, textureY); // Box 366
        wheel_back_right[13] = new ModelRendererTurbo(this, 273, 81, textureX, textureY); // Box 367
        wheel_back_right[14] = new ModelRendererTurbo(this, 297, 81, textureX, textureY); // Box 368
        wheel_back_right[15] = new ModelRendererTurbo(this, 313, 81, textureX, textureY); // Box 369
        wheel_back_right[16] = new ModelRendererTurbo(this, 329, 81, textureX, textureY); // Box 370
        wheel_back_right[17] = new ModelRendererTurbo(this, 345, 81, textureX, textureY); // Box 371
        wheel_back_right[18] = new ModelRendererTurbo(this, 17, 81, textureX, textureY); // Box 372
        wheel_back_right[19] = new ModelRendererTurbo(this, 41, 81, textureX, textureY); // Box 373
        wheel_back_right[20] = new ModelRendererTurbo(this, 505, 73, textureX, textureY); // Box 374
        wheel_back_right[21] = new ModelRendererTurbo(this, 97, 81, textureX, textureY); // Box 375
        wheel_back_right[22] = new ModelRendererTurbo(this, 121, 81, textureX, textureY); // Box 376
        wheel_back_right[23] = new ModelRendererTurbo(this, 193, 81, textureX, textureY); // Box 377
        wheel_back_right[24] = new ModelRendererTurbo(this, 217, 81, textureX, textureY); // Box 378
        wheel_back_right[25] = new ModelRendererTurbo(this, 241, 81, textureX, textureY); // Box 379
        wheel_back_right[26] = new ModelRendererTurbo(this, 265, 81, textureX, textureY); // Box 380
        wheel_back_right[27] = new ModelRendererTurbo(this, 289, 81, textureX, textureY); // Box 381
        wheel_back_right[28] = new ModelRendererTurbo(this, 361, 81, textureX, textureY); // Box 382
        wheel_back_right[29] = new ModelRendererTurbo(this, 377, 81, textureX, textureY); // Box 383
        wheel_back_right[30] = new ModelRendererTurbo(this, 393, 81, textureX, textureY); // Box 384
        wheel_back_right[31] = new ModelRendererTurbo(this, 401, 81, textureX, textureY); // Box 385
        wheel_back_right[32] = new ModelRendererTurbo(this, 409, 81, textureX, textureY); // Box 386
        wheel_back_right[33] = new ModelRendererTurbo(this, 417, 81, textureX, textureY); // Box 387
        wheel_back_right[34] = new ModelRendererTurbo(this, 425, 81, textureX, textureY); // Box 388
        wheel_back_right[35] = new ModelRendererTurbo(this, 441, 81, textureX, textureY); // Box 389
        wheel_back_right[36] = new ModelRendererTurbo(this, 457, 81, textureX, textureY); // Box 390
        wheel_back_right[37] = new ModelRendererTurbo(this, 473, 81, textureX, textureY); // Box 391
        wheel_back_right[38] = new ModelRendererTurbo(this, 481, 81, textureX, textureY); // Box 392
        wheel_back_right[39] = new ModelRendererTurbo(this, 489, 81, textureX, textureY); // Box 393
        wheel_back_right[40] = new ModelRendererTurbo(this, 497, 81, textureX, textureY); // Box 394
        wheel_back_right[41] = new ModelRendererTurbo(this, 1, 89, textureX, textureY); // Box 395
        wheel_back_right[42] = new ModelRendererTurbo(this, 17, 89, textureX, textureY); // Box 396
        wheel_back_right[43] = new ModelRendererTurbo(this, 33, 89, textureX, textureY); // Box 397
        wheel_back_right[44] = new ModelRendererTurbo(this, 81, 89, textureX, textureY); // Box 398
        wheel_back_right[45] = new ModelRendererTurbo(this, 97, 89, textureX, textureY); // Box 399
        wheel_back_right[46] = new ModelRendererTurbo(this, 105, 89, textureX, textureY); // Box 400
        wheel_back_right[47] = new ModelRendererTurbo(this, 113, 89, textureX, textureY); // Box 401
        wheel_back_right[48] = new ModelRendererTurbo(this, 121, 89, textureX, textureY); // Box 402
        wheel_back_right[49] = new ModelRendererTurbo(this, 137, 89, textureX, textureY); // Box 403
        wheel_back_right[50] = new ModelRendererTurbo(this, 153, 89, textureX, textureY); // Box 404
        wheel_back_right[51] = new ModelRendererTurbo(this, 169, 89, textureX, textureY); // Box 405
        wheel_back_right[52] = new ModelRendererTurbo(this, 185, 89, textureX, textureY); // Box 406
        wheel_back_right[53] = new ModelRendererTurbo(this, 201, 89, textureX, textureY); // Box 407
        wheel_back_right[54] = new ModelRendererTurbo(this, 217, 89, textureX, textureY); // Box 408
        wheel_back_right[55] = new ModelRendererTurbo(this, 225, 89, textureX, textureY); // Box 409
        wheel_back_right[56] = new ModelRendererTurbo(this, 233, 89, textureX, textureY); // Box 410
        wheel_back_right[57] = new ModelRendererTurbo(this, 257, 89, textureX, textureY); // Box 411
        wheel_back_right[58] = new ModelRendererTurbo(this, 281, 89, textureX, textureY); // Box 412
        wheel_back_right[59] = new ModelRendererTurbo(this, 289, 89, textureX, textureY); // Box 413
        wheel_back_right[60] = new ModelRendererTurbo(this, 361, 89, textureX, textureY); // Box 414
        wheel_back_right[61] = new ModelRendererTurbo(this, 369, 89, textureX, textureY); // Box 415
        wheel_back_right[62] = new ModelRendererTurbo(this, 377, 89, textureX, textureY); // Box 416
        wheel_back_right[63] = new ModelRendererTurbo(this, 401, 89, textureX, textureY); // Box 417
        wheel_back_right[64] = new ModelRendererTurbo(this, 425, 89, textureX, textureY); // Box 418
        wheel_back_right[65] = new ModelRendererTurbo(this, 449, 89, textureX, textureY); // Box 419
        wheel_back_right[66] = new ModelRendererTurbo(this, 473, 89, textureX, textureY); // Box 420
        wheel_back_right[67] = new ModelRendererTurbo(this, 481, 89, textureX, textureY); // Box 421
        wheel_back_right[68] = new ModelRendererTurbo(this, 489, 89, textureX, textureY); // Box 422
        wheel_back_right[69] = new ModelRendererTurbo(this, 1, 97, textureX, textureY); // Box 423
        wheel_back_right[70] = new ModelRendererTurbo(this, 505, 89, textureX, textureY); // Box 424
        wheel_back_right[71] = new ModelRendererTurbo(this, 17, 97, textureX, textureY); // Box 425
        wheel_back_right[72] = new ModelRendererTurbo(this, 25, 97, textureX, textureY); // Box 426
        wheel_back_right[73] = new ModelRendererTurbo(this, 33, 97, textureX, textureY); // Box 427
        wheel_back_right[74] = new ModelRendererTurbo(this, 41, 97, textureX, textureY); // Box 428
        wheel_back_right[75] = new ModelRendererTurbo(this, 57, 97, textureX, textureY); // Box 429
        wheel_back_right[76] = new ModelRendererTurbo(this, 73, 97, textureX, textureY); // Box 430
        wheel_back_right[77] = new ModelRendererTurbo(this, 89, 97, textureX, textureY); // Box 431

        wheel_back_right[0].addBox(-1.5F, -1.5F, 0F, 3, 3, 3, 0F); // Box 8
        wheel_back_right[0].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[1].addShapeBox(-1F, -1F, -1F, 2, 2, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0.5F, 0.5F, 0F, 0.5F, 0.5F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0.5F, 0.5F, 0F, 0.5F, 0.5F, 0F); // Box 355
        wheel_back_right[1].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[2].addBox(-1.5F, 7.5F, -0.5F, 3, 2, 5, 0F); // Box 356
        wheel_back_right[2].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[3].addBox(-1.5F, -9.5F, -0.5F, 3, 2, 5, 0F); // Box 357
        wheel_back_right[3].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[4].addBox(-9.5F, -1.5F, -0.5F, 2, 3, 5, 0F); // Box 358
        wheel_back_right[4].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[5].addBox(7.5F, -1.5F, -0.5F, 2, 3, 5, 0F); // Box 359
        wheel_back_right[5].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[6].addShapeBox(-6.7F, 4.7F, -0.5F, 3, 2, 5, 0F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F, 1F, -1F, 0F, -2F, 1F, 0F, -2F, 1F, 0F, 1F, -1F, 0F); // Box 360
        wheel_back_right[6].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[7].addShapeBox(3.7F, 4.7F, -0.5F, 3, 2, 5, 0F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -2F, 1F, 0F, 1F, -1F, 0F, 1F, -1F, 0F, -2F, 1F, 0F); // Box 361
        wheel_back_right[7].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[8].addShapeBox(-6.7F, -6.7F, -0.5F, 3, 2, 5, 0F, 1F, -1F, 0F, -2F, 1F, 0F, -2F, 1F, 0F, 1F, -1F, 0F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F); // Box 362
        wheel_back_right[8].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[9].addShapeBox(5.2F, -7.2F, -0.5F, 3, 2, 5, 0F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F, 1F, -1F, 0F, -2F, 1F, 0F, -2F, 1F, 0F, 1F, -1F, 0F); // Box 363
        wheel_back_right[9].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[10].addShapeBox(-4.5F, 7.5F, -0.5F, 3, 2, 5, 0F, -0.3F, 1.3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, 1.3F, 0F, 1.2F, -1.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1.2F, -1.8F, 0F); // Box 364
        wheel_back_right[10].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[11].addShapeBox(1.5F, 7.5F, -0.5F, 3, 2, 5, 0F, 0F, 0F, 0F, -0.3F, 1.3F, 0F, -0.3F, 1.3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1.2F, -1.8F, 0F, 1.2F, -1.8F, 0F, 0F, 0F, 0F); // Box 365
        wheel_back_right[11].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[12].addShapeBox(1.5F, -9.5F, -0.5F, 3, 2, 5, 0F, 0F, 0F, 0F, 1.2F, -1.8F, 0F, 1.2F, -1.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, 1.3F, 0F, -0.3F, 1.3F, 0F, 0F, 0F, 0F); // Box 366
        wheel_back_right[12].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[13].addShapeBox(-4.5F, -9.5F, -0.5F, 3, 2, 5, 0F, 1.2F, -1.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1.2F, -1.8F, 0F, -0.3F, 1.3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, 1.3F, 0F); // Box 367
        wheel_back_right[13].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[14].addShapeBox(-9.5F, 1.5F, -0.5F, 2, 3, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F); // Box 368
        wheel_back_right[14].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[15].addShapeBox(-9.5F, -4.5F, -0.5F, 2, 3, 5, 0F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 369
        wheel_back_right[15].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[16].addShapeBox(7.5F, -4.5F, -0.5F, 2, 3, 5, 0F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 370
        wheel_back_right[16].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[17].addShapeBox(7.5F, 1.5F, -0.5F, 2, 3, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F); // Box 371
        wheel_back_right[17].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[18].addShapeBox(-1.5F, -9.5F, -1.5F, 3, 2, 1, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 372
        wheel_back_right[18].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[19].addShapeBox(-1.5F, 7.5F, -1.5F, 3, 2, 1, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 373
        wheel_back_right[19].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[20].addShapeBox(-9.5F, -1.5F, -1.5F, 2, 3, 1, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 374
        wheel_back_right[20].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[21].addShapeBox(7.5F, -1.5F, -1.5F, 2, 3, 1, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 375
        wheel_back_right[21].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[22].addShapeBox(-6.7F, -6.7F, -1.5F, 3, 2, 1, 0F, 0.8F, -1F, -0.7F, -1.9F, 0.8F, -0.7F, -2F, 1F, 0F, 1F, -1F, 0F, -0.4F, 0.3F, -0.7F, -0.7F, -1.6F, -0.7F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F); // Box 376
        wheel_back_right[22].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[23].addShapeBox(-6.7F, 4.7F, -1.5F, 3, 2, 1, 0F, -0.4F, 0.3F, -0.7F, -0.7F, -1.6F, -0.7F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F, 0.8F, -1F, -0.7F, -1.9F, 0.8F, -0.7F, -2F, 1F, 0F, 1F, -1F, 0F); // Box 377
        wheel_back_right[23].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[24].addShapeBox(3.7F, 4.7F, -1.5F, 3, 2, 1, 0F, -0.7F, -1.6F, -0.7F, -0.4F, 0.3F, -0.7F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -1.9F, 0.8F, -0.7F, 0.8F, -1F, -0.7F, 1F, -1F, 0F, -2F, 1F, 0F); // Box 378
        wheel_back_right[24].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[25].addShapeBox(-4.5F, 7.5F, -1.5F, 3, 2, 1, 0F, -0.1F, 1.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, -0.3F, 1.3F, 0F, 1.1F, -2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 1.2F, -1.8F, 0F); // Box 379
        wheel_back_right[25].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[26].addShapeBox(1.5F, 7.5F, -1.5F, 3, 2, 1, 0F, 0F, -0.2F, -0.7F, -0.1F, 1.2F, -0.7F, -0.3F, 1.3F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 1.1F, -2F, -0.7F, 1.2F, -1.8F, 0F, 0F, 0F, 0F); // Box 380
        wheel_back_right[26].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[27].addShapeBox(1.5F, -9.5F, -1.5F, 3, 2, 1, 0F, 0F, -0.2F, -0.7F, 1.1F, -2F, -0.7F, 1.2F, -1.8F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, -0.1F, 1.2F, -0.7F, -0.3F, 1.3F, 0F, 0F, 0F, 0F); // Box 381
        wheel_back_right[27].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[28].addShapeBox(-4.5F, -9.5F, -1.5F, 3, 2, 1, 0F, 1.1F, -2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 1.2F, -1.8F, 0F, -0.1F, 1.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, -0.3F, 1.3F, 0F); // Box 382
        wheel_back_right[28].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[29].addShapeBox(3.7F, -6.7F, -1.5F, 3, 2, 1, 0F, -1.9F, 0.8F, -0.7F, 0.8F, -1F, -0.7F, 1F, -1F, 0F, -2F, 1F, 0F, -0.7F, -1.6F, -0.7F, -0.4F, 0.3F, -0.7F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F); // Box 383
        wheel_back_right[29].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[30].addShapeBox(7.5F, 1.5F, -1.5F, 2, 3, 1, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 1.2F, -0.1F, -0.7F, -2F, 1.2F, -0.7F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F); // Box 384
        wheel_back_right[30].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[31].addShapeBox(7.5F, -4.5F, -1.5F, 2, 3, 1, 0F, 1.2F, -0.1F, -0.7F, -2F, 1.2F, -0.7F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 385
        wheel_back_right[31].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[32].addShapeBox(-9.5F, -4.5F, -1.5F, 2, 3, 1, 0F, -2F, 1.2F, -0.7F, 1.2F, -0.1F, -0.7F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 386
        wheel_back_right[32].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[33].addShapeBox(-9.5F, 1.5F, -1.5F, 2, 3, 1, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 1.2F, -0.7F, 1.2F, -0.1F, -0.7F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F); // Box 387
        wheel_back_right[33].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[34].addShapeBox(-1.5F, -9.5F, 4.5F, 3, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F); // Box 388
        wheel_back_right[34].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[35].addShapeBox(-4.5F, -9.5F, 4.5F, 3, 2, 1, 0F, 1.2F, -1.8F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 1.1F, -2F, -0.7F, -0.3F, 1.3F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, -0.1F, 1.2F, -0.7F); // Box 389
        wheel_back_right[35].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[36].addShapeBox(-6.7F, -6.7F, 4.5F, 3, 2, 1, 0F, 1F, -1F, 0F, -2F, 1F, 0F, -1.9F, 0.8F, -0.7F, 0.8F, -1F, -0.7F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -0.7F, -1.6F, -0.7F, -0.4F, 0.3F, -0.7F); // Box 390
        wheel_back_right[36].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[37].addShapeBox(-9.5F, -4.5F, 4.5F, 2, 3, 1, 0F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F, 1.2F, -0.1F, -0.7F, -2F, 1.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F); // Box 391
        wheel_back_right[37].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[38].addShapeBox(-9.5F, -1.5F, 4.5F, 2, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F); // Box 392
        wheel_back_right[38].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[39].addShapeBox(-9.5F, 1.5F, 4.5F, 2, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F, 1.2F, -0.1F, -0.7F, -2F, 1.2F, -0.7F); // Box 393
        wheel_back_right[39].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[40].addShapeBox(-6.7F, 4.7F, 4.5F, 3, 2, 1, 0F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -0.7F, -1.6F, -0.7F, -0.4F, 0.3F, -0.7F, 1F, -1F, 0F, -2F, 1F, 0F, -1.9F, 0.8F, -0.7F, 0.8F, -1F, -0.7F); // Box 394
        wheel_back_right[40].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[41].addShapeBox(-4.5F, 7.5F, 4.5F, 3, 2, 1, 0F, -0.3F, 1.3F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, -0.1F, 1.2F, -0.7F, 1.2F, -1.8F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 1.1F, -2F, -0.7F); // Box 395
        wheel_back_right[41].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[42].addShapeBox(-1.5F, 7.5F, 4.5F, 3, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F); // Box 396
        wheel_back_right[42].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[43].addShapeBox(1.5F, 7.5F, 4.5F, 3, 2, 1, 0F, 0F, 0F, 0F, -0.3F, 1.3F, 0F, -0.1F, 1.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 1.2F, -1.8F, 0F, 1.1F, -2F, -0.7F, 0F, -0.2F, -0.7F); // Box 397
        wheel_back_right[43].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[44].addShapeBox(3.7F, 4.7F, 4.5F, 3, 2, 1, 0F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F, -0.4F, 0.3F, -0.7F, -0.7F, -1.6F, -0.7F, -2F, 1F, 0F, 1F, -1F, 0F, 0.8F, -1F, -0.7F, -1.9F, 0.8F, -0.7F); // Box 398
        wheel_back_right[44].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[45].addShapeBox(7.5F, 1.5F, 4.5F, 2, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F, -2F, 1.2F, -0.7F, 1.2F, -0.1F, -0.7F); // Box 399
        wheel_back_right[45].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[46].addShapeBox(7.5F, -1.5F, 4.5F, 2, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F); // Box 400
        wheel_back_right[46].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[47].addShapeBox(7.5F, -4.5F, 4.5F, 2, 3, 1, 0F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F, -2F, 1.2F, -0.7F, 1.2F, -0.1F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F); // Box 401
        wheel_back_right[47].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[48].addShapeBox(3.7F, -6.7F, 4.5F, 3, 2, 1, 0F, -2F, 1F, 0F, 1F, -1F, 0F, 0.8F, -1F, -0.7F, -1.9F, 0.8F, -0.7F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F, -0.4F, 0.3F, -0.7F, -0.7F, -1.6F, -0.7F); // Box 402
        wheel_back_right[48].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[49].addShapeBox(1.5F, -9.5F, 4.5F, 3, 2, 1, 0F, 0F, 0F, 0F, 1.2F, -1.8F, 0F, 1.1F, -2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, -0.3F, 1.3F, 0F, -0.1F, 1.2F, -0.7F, 0F, -0.2F, -0.7F); // Box 403
        wheel_back_right[49].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[50].addShapeBox(1.5F, -0.5F, 0F, 1, 1, 3, 0F, 0F, 0.1F, 0F, -0.4F, -0.5F, 0F, -0.4F, -0.5F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, -0.4F, -0.5F, 0F, -0.4F, -0.5F, 0F, 0F, 0.1F, 0F); // Box 404
        wheel_back_right[50].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[51].addShapeBox(-2.5F, -0.5F, 0F, 1, 1, 3, 0F, -0.4F, -0.5F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, -0.4F, -0.5F, 0F, -0.4F, -0.5F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, -0.4F, -0.5F, 0F); // Box 405
        wheel_back_right[51].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[52].addShapeBox(-0.5F, -2.5F, 0F, 1, 1, 3, 0F, -0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 406
        wheel_back_right[52].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[53].addShapeBox(-0.5F, 1.5F, 0F, 1, 1, 3, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, -0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F); // Box 407
        wheel_back_right[53].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[54].addBox(-0.5F, 1.5F, 0.5F, 1, 6, 2, 0F); // Box 408
        wheel_back_right[54].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[55].addBox(-0.5F, -7.5F, 0.5F, 1, 6, 2, 0F); // Box 409
        wheel_back_right[55].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[56].addBox(1.5F, -0.5F, 0.5F, 6, 1, 2, 0F); // Box 410
        wheel_back_right[56].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[57].addBox(-7.5F, -0.5F, 0.5F, 6, 1, 2, 0F); // Box 411
        wheel_back_right[57].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[58].addShapeBox(-0.5F, 1.5F, 0.5F, 1, 6, 2, 0F, 0.7F, 0.45F, 0F, -0.85F, -0.05F, 0F, -0.85F, -0.05F, 0F, 0.7F, 0.45F, 0F, 3.7F, -1.25F, 0F, -3.8F, -0.75F, 0F, -3.8F, -0.75F, 0F, 3.7F, -1.25F, 0F); // Box 412
        wheel_back_right[58].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[59].addShapeBox(-0.5F, 1.5F, 0.5F, 1, 6, 2, 0F, -0.85F, -0.05F, 0F, 0.7F, 0.45F, 0F, 0.7F, 0.45F, 0F, -0.85F, -0.05F, 0F, -3.8F, -0.75F, 0F, 3.7F, -1.25F, 0F, 3.7F, -1.25F, 0F, -3.8F, -0.75F, 0F); // Box 413
        wheel_back_right[59].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[60].addShapeBox(-0.5F, -7.5F, 0.5F, 1, 6, 2, 0F, -3.8F, -0.75F, 0F, 3.7F, -1.25F, 0F, 3.7F, -1.25F, 0F, -3.8F, -0.75F, 0F, -0.85F, -0.05F, 0F, 0.7F, 0.45F, 0F, 0.7F, 0.45F, 0F, -0.85F, -0.05F, 0F); // Box 414
        wheel_back_right[60].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[61].addShapeBox(-0.5F, -7.5F, 0.5F, 1, 6, 2, 0F, 3.7F, -1.25F, 0F, -3.8F, -0.75F, 0F, -3.8F, -0.75F, 0F, 3.7F, -1.25F, 0F, 0.7F, 0.45F, 0F, -0.85F, -0.05F, 0F, -0.85F, -0.05F, 0F, 0.7F, 0.45F, 0F); // Box 415
        wheel_back_right[61].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[62].addShapeBox(-7.5F, -0.5F, 0.5F, 6, 1, 2, 0F, -0.75F, -3.8F, 0F, -0.05F, -0.8F, 0F, -0.05F, -0.8F, 0F, -0.75F, -3.8F, 0F, -1.25F, 3.7F, 0F, 0.45F, 0.7F, 0F, 0.45F, 0.7F, 0F, -1.25F, 3.7F, 0F); // Box 416
        wheel_back_right[62].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[63].addShapeBox(-7.5F, -0.5F, 0.5F, 6, 1, 2, 0F, -1.25F, 3.7F, 0F, 0.45F, 0.7F, 0F, 0.45F, 0.7F, 0F, -1.25F, 3.7F, 0F, -0.75F, -3.8F, 0F, -0.05F, -0.8F, 0F, -0.05F, -0.8F, 0F, -0.75F, -3.8F, 0F); // Box 417
        wheel_back_right[63].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[64].addShapeBox(1.5F, -0.5F, 0.5F, 6, 1, 2, 0F, 0.45F, 0.7F, 0F, -1.25F, 3.7F, 0F, -1.25F, 3.7F, 0F, 0.45F, 0.7F, 0F, -0.05F, -0.8F, 0F, -0.75F, -3.8F, 0F, -0.75F, -3.8F, 0F, -0.05F, -0.8F, 0F); // Box 418
        wheel_back_right[64].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[65].addShapeBox(1.5F, -0.5F, 0.5F, 6, 1, 2, 0F, -0.05F, -0.8F, 0F, -0.75F, -3.8F, 0F, -0.75F, -3.8F, 0F, -0.05F, -0.8F, 0F, 0.45F, 0.7F, 0F, -1.25F, 3.7F, 0F, -1.25F, 3.7F, 0F, 0.45F, 0.7F, 0F); // Box 419
        wheel_back_right[65].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[66].addShapeBox(-0.5F, 1.5F, -0.5F, 1, 6, 1, 0F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 420
        wheel_back_right[66].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[67].addShapeBox(-0.5F, -7.5F, -0.5F, 1, 6, 1, 0F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 421
        wheel_back_right[67].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[68].addShapeBox(-7.5F, -0.5F, -0.5F, 6, 1, 1, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 422
        wheel_back_right[68].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[69].addShapeBox(1.5F, -0.5F, -0.5F, 6, 1, 1, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 423
        wheel_back_right[69].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[70].addShapeBox(-0.5F, 1.5F, -0.5F, 1, 6, 1, 0F, 0.35F, 0.15F, -0.5F, -1.35F, 0.15F, -0.5F, -0.85F, -0.05F, 0F, 0.7F, 0.45F, 0F, 3.3F, -1F, -0.5F, -4.25F, -1.1F, -0.5F, -3.8F, -0.75F, 0F, 3.7F, -1.25F, 0F); // Box 424
        wheel_back_right[70].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[71].addShapeBox(-0.5F, 1.5F, -0.5F, 1, 6, 1, 0F, -1.35F, 0.15F, -0.5F, 0.35F, 0.15F, -0.5F, 0.7F, 0.45F, 0F, -0.85F, -0.05F, 0F, -4.25F, -1.1F, -0.5F, 3.3F, -1F, -0.5F, 3.7F, -1.25F, 0F, -3.8F, -0.75F, 0F); // Box 425
        wheel_back_right[71].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[72].addShapeBox(-0.5F, -7.5F, -0.5F, 1, 6, 1, 0F, -4.25F, -1.1F, -0.5F, 3.3F, -1F, -0.5F, 3.7F, -1.25F, 0F, -3.8F, -0.75F, 0F, -1.35F, 0.15F, -0.5F, 0.35F, 0.15F, -0.5F, 0.7F, 0.45F, 0F, -0.85F, -0.05F, 0F); // Box 426
        wheel_back_right[72].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[73].addShapeBox(-0.5F, -7.5F, -0.5F, 1, 6, 1, 0F, 3.3F, -1F, -0.5F, -4.25F, -1.1F, -0.5F, -3.8F, -0.75F, 0F, 3.7F, -1.25F, 0F, 0.35F, 0.15F, -0.5F, -1.35F, 0.15F, -0.5F, -0.85F, -0.05F, 0F, 0.7F, 0.45F, 0F); // Box 427
        wheel_back_right[73].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[74].addShapeBox(-7.5F, -0.5F, -0.5F, 6, 1, 1, 0F, -0.85F, -4.25F, -0.5F, 0.15F, -1.25F, -0.5F, -0.05F, -0.8F, 0F, -0.75F, -3.8F, 0F, -1.05F, 3.15F, -0.5F, 0.3F, 0.15F, -0.5F, 0.45F, 0.7F, 0F, -1.25F, 3.7F, 0F); // Box 428
        wheel_back_right[74].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[75].addShapeBox(-7.5F, -0.5F, -0.5F, 6, 1, 1, 0F, -1.05F, 3.15F, -0.5F, 0.3F, 0.15F, -0.5F, 0.45F, 0.7F, 0F, -1.25F, 3.7F, 0F, -0.85F, -4.25F, -0.5F, 0.15F, -1.25F, -0.5F, -0.05F, -0.8F, 0F, -0.75F, -3.8F, 0F); // Box 429
        wheel_back_right[75].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[76].addShapeBox(1.5F, -0.5F, -0.5F, 6, 1, 1, 0F, 0.3F, 0.15F, -0.5F, -1.05F, 3.15F, -0.5F, -1.25F, 3.7F, 0F, 0.45F, 0.7F, 0F, 0.15F, -1.25F, -0.5F, -0.85F, -4.25F, -0.5F, -0.75F, -3.8F, 0F, -0.05F, -0.8F, 0F); // Box 430
        wheel_back_right[76].setRotationPoint(-43.5F, 0.5F, -20F);

        wheel_back_right[77].addShapeBox(1.5F, -0.5F, -0.5F, 6, 1, 1, 0F, 0.15F, -1.25F, -0.5F, -0.85F, -4.25F, -0.5F, -0.75F, -3.8F, 0F, -0.05F, -0.8F, 0F, 0.3F, 0.15F, -0.5F, -1.05F, 3.15F, -0.5F, -1.25F, 3.7F, 0F, 0.45F, 0.7F, 0F); // Box 431
        wheel_back_right[77].setRotationPoint(-43.5F, 0.5F, -20F);
        this.add("wheel_back_right", wheel_back_right);
        translateAll(0F, 0F, 0F);
        flipAll();
    }

    @Override
    public void render(VehicleData data, String us){
        super.def_renderWheels4(data, us);
    }

    @Override
    public void render(VehicleData data, String us, VehicleEntity vehicle, int meta){
        super.def_renderWheels4(data, us, vehicle);
    }

}
