//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2016 Minecraft-SMP.de
// This file is for Fex's Vehicle Mod
// Model: T1(P) Front Wheels
// Model Creator: FEX___96
// Created on: 20.01.2016 - 22:15:40
// Last changed on: 20.01.2016 - 22:15:40
package net.fexcraft.mod.addons.fvp.models.part;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.model.part.PartModel;

public class ModelT1FW extends PartModel {

    public ModelT1FW(){
    	super(); textureX = 512; textureY = 512;
        addToCreators("Ferdinand (FEX___96)");
        ModelRendererTurbo[] wheel_front_left = new ModelRendererTurbo[99];
        wheel_front_left[0] = new ModelRendererTurbo(this, 185, 1, textureX, textureY); // Box 12
        wheel_front_left[1] = new ModelRendererTurbo(this, 89, 9, textureX, textureY); // Box 13
        wheel_front_left[2] = new ModelRendererTurbo(this, 345, 1, textureX, textureY); // Box 14
        wheel_front_left[3] = new ModelRendererTurbo(this, 217, 1, textureX, textureY); // Box 15
        wheel_front_left[4] = new ModelRendererTurbo(this, 1, 9, textureX, textureY); // Box 16
        wheel_front_left[5] = new ModelRendererTurbo(this, 129, 9, textureX, textureY); // Box 17
        wheel_front_left[6] = new ModelRendererTurbo(this, 89, 17, textureX, textureY); // Box 18
        wheel_front_left[7] = new ModelRendererTurbo(this, 249, 1, textureX, textureY); // Box 19
        wheel_front_left[8] = new ModelRendererTurbo(this, 401, 1, textureX, textureY); // Box 20
        wheel_front_left[9] = new ModelRendererTurbo(this, 433, 1, textureX, textureY); // Box 21
        wheel_front_left[10] = new ModelRendererTurbo(this, 465, 1, textureX, textureY); // Box 22
        wheel_front_left[11] = new ModelRendererTurbo(this, 377, 17, textureX, textureY); // Box 23
        wheel_front_left[12] = new ModelRendererTurbo(this, 401, 17, textureX, textureY); // Box 24
        wheel_front_left[13] = new ModelRendererTurbo(this, 425, 17, textureX, textureY); // Box 25
        wheel_front_left[14] = new ModelRendererTurbo(this, 449, 17, textureX, textureY); // Box 26
        wheel_front_left[15] = new ModelRendererTurbo(this, 473, 17, textureX, textureY); // Box 27
        wheel_front_left[16] = new ModelRendererTurbo(this, 1, 25, textureX, textureY); // Box 28
        wheel_front_left[17] = new ModelRendererTurbo(this, 113, 25, textureX, textureY); // Box 29
        wheel_front_left[18] = new ModelRendererTurbo(this, 137, 25, textureX, textureY); // Box 30
        wheel_front_left[19] = new ModelRendererTurbo(this, 377, 1, textureX, textureY); // Box 31
        wheel_front_left[20] = new ModelRendererTurbo(this, 497, 1, textureX, textureY); // Box 32
        wheel_front_left[21] = new ModelRendererTurbo(this, 17, 9, textureX, textureY); // Box 33
        wheel_front_left[22] = new ModelRendererTurbo(this, 113, 17, textureX, textureY); // Box 34
        wheel_front_left[23] = new ModelRendererTurbo(this, 281, 1, textureX, textureY); // Box 35
        wheel_front_left[24] = new ModelRendererTurbo(this, 361, 1, textureX, textureY); // Box 36
        wheel_front_left[25] = new ModelRendererTurbo(this, 153, 9, textureX, textureY); // Box 37
        wheel_front_left[26] = new ModelRendererTurbo(this, 505, 9, textureX, textureY); // Box 38
        wheel_front_left[27] = new ModelRendererTurbo(this, 161, 9, textureX, textureY); // Box 39
        wheel_front_left[28] = new ModelRendererTurbo(this, 185, 9, textureX, textureY); // Box 40
        wheel_front_left[29] = new ModelRendererTurbo(this, 217, 9, textureX, textureY); // Box 41
        wheel_front_left[30] = new ModelRendererTurbo(this, 153, 17, textureX, textureY); // Box 42
        wheel_front_left[31] = new ModelRendererTurbo(this, 161, 25, textureX, textureY); // Box 43
        wheel_front_left[32] = new ModelRendererTurbo(this, 345, 17, textureX, textureY); // Box 44
        wheel_front_left[33] = new ModelRendererTurbo(this, 201, 25, textureX, textureY); // Box 45
        wheel_front_left[34] = new ModelRendererTurbo(this, 497, 17, textureX, textureY); // Box 46
        wheel_front_left[35] = new ModelRendererTurbo(this, 225, 25, textureX, textureY); // Box 47
        wheel_front_left[36] = new ModelRendererTurbo(this, 241, 25, textureX, textureY); // Box 48
        wheel_front_left[37] = new ModelRendererTurbo(this, 193, 33, textureX, textureY); // Box 49
        wheel_front_left[38] = new ModelRendererTurbo(this, 209, 33, textureX, textureY); // Box 50
        wheel_front_left[39] = new ModelRendererTurbo(this, 241, 33, textureX, textureY); // Box 51
        wheel_front_left[40] = new ModelRendererTurbo(this, 257, 33, textureX, textureY); // Box 52
        wheel_front_left[41] = new ModelRendererTurbo(this, 273, 33, textureX, textureY); // Box 53
        wheel_front_left[42] = new ModelRendererTurbo(this, 289, 33, textureX, textureY); // Box 54
        wheel_front_left[43] = new ModelRendererTurbo(this, 305, 33, textureX, textureY); // Box 55
        wheel_front_left[44] = new ModelRendererTurbo(this, 321, 33, textureX, textureY); // Box 56
        wheel_front_left[45] = new ModelRendererTurbo(this, 337, 33, textureX, textureY); // Box 57
        wheel_front_left[46] = new ModelRendererTurbo(this, 353, 33, textureX, textureY); // Box 58
        wheel_front_left[47] = new ModelRendererTurbo(this, 377, 33, textureX, textureY); // Box 59
        wheel_front_left[48] = new ModelRendererTurbo(this, 417, 33, textureX, textureY); // Box 60
        wheel_front_left[49] = new ModelRendererTurbo(this, 441, 33, textureX, textureY); // Box 61
        wheel_front_left[50] = new ModelRendererTurbo(this, 465, 33, textureX, textureY); // Box 62
        wheel_front_left[51] = new ModelRendererTurbo(this, 489, 33, textureX, textureY); // Box 63
        wheel_front_left[52] = new ModelRendererTurbo(this, 105, 41, textureX, textureY); // Box 64
        wheel_front_left[53] = new ModelRendererTurbo(this, 129, 41, textureX, textureY); // Box 65
        wheel_front_left[54] = new ModelRendererTurbo(this, 393, 17, textureX, textureY); // Box 66
        wheel_front_left[55] = new ModelRendererTurbo(this, 417, 17, textureX, textureY); // Box 68
        wheel_front_left[56] = new ModelRendererTurbo(this, 441, 17, textureX, textureY); // Box 69
        wheel_front_left[57] = new ModelRendererTurbo(this, 465, 17, textureX, textureY); // Box 70
        wheel_front_left[58] = new ModelRendererTurbo(this, 281, 9, textureX, textureY); // Box 71
        wheel_front_left[59] = new ModelRendererTurbo(this, 89, 33, textureX, textureY); // Box 72
        wheel_front_left[60] = new ModelRendererTurbo(this, 393, 33, textureX, textureY); // Box 73
        wheel_front_left[61] = new ModelRendererTurbo(this, 257, 25, textureX, textureY); // Box 74
        wheel_front_left[62] = new ModelRendererTurbo(this, 417, 25, textureX, textureY); // Box 75
        wheel_front_left[63] = new ModelRendererTurbo(this, 489, 25, textureX, textureY); // Box 76
        wheel_front_left[64] = new ModelRendererTurbo(this, 153, 33, textureX, textureY); // Box 77
        wheel_front_left[65] = new ModelRendererTurbo(this, 145, 41, textureX, textureY); // Box 78
        wheel_front_left[66] = new ModelRendererTurbo(this, 161, 41, textureX, textureY); // Box 79
        wheel_front_left[67] = new ModelRendererTurbo(this, 249, 1, textureX, textureY); // Box 80
        wheel_front_left[68] = new ModelRendererTurbo(this, 345, 1, textureX, textureY); // Box 81
        wheel_front_left[69] = new ModelRendererTurbo(this, 401, 1, textureX, textureY); // Box 82
        wheel_front_left[70] = new ModelRendererTurbo(this, 433, 1, textureX, textureY); // Box 83
        wheel_front_left[71] = new ModelRendererTurbo(this, 465, 1, textureX, textureY); // Box 84
        wheel_front_left[72] = new ModelRendererTurbo(this, 1, 9, textureX, textureY); // Box 85
        wheel_front_left[73] = new ModelRendererTurbo(this, 129, 9, textureX, textureY); // Box 86
        wheel_front_left[74] = new ModelRendererTurbo(this, 89, 17, textureX, textureY); // Box 87
        wheel_front_left[75] = new ModelRendererTurbo(this, 489, 17, textureX, textureY); // Box 88
        wheel_front_left[76] = new ModelRendererTurbo(this, 17, 25, textureX, textureY); // Box 89
        wheel_front_left[77] = new ModelRendererTurbo(this, 377, 17, textureX, textureY); // Box 90
        wheel_front_left[78] = new ModelRendererTurbo(this, 1, 25, textureX, textureY); // Box 91
        wheel_front_left[79] = new ModelRendererTurbo(this, 129, 25, textureX, textureY); // Box 93
        wheel_front_left[80] = new ModelRendererTurbo(this, 153, 25, textureX, textureY); // Box 94
        wheel_front_left[81] = new ModelRendererTurbo(this, 193, 25, textureX, textureY); // Box 95
        wheel_front_left[82] = new ModelRendererTurbo(this, 105, 33, textureX, textureY); // Box 96
        wheel_front_left[83] = new ModelRendererTurbo(this, 409, 33, textureX, textureY); // Box 97
        wheel_front_left[84] = new ModelRendererTurbo(this, 481, 33, textureX, textureY); // Box 98
        wheel_front_left[85] = new ModelRendererTurbo(this, 505, 33, textureX, textureY); // Box 99
        wheel_front_left[86] = new ModelRendererTurbo(this, 121, 41, textureX, textureY); // Box 100
        wheel_front_left[87] = new ModelRendererTurbo(this, 337, 225, textureX, textureY); // Box 533
        wheel_front_left[88] = new ModelRendererTurbo(this, 17, 233, textureX, textureY); // Box 534
        wheel_front_left[89] = new ModelRendererTurbo(this, 289, 145, textureX, textureY); // Box 535
        wheel_front_left[90] = new ModelRendererTurbo(this, 1, 161, textureX, textureY); // Box 536
        wheel_front_left[91] = new ModelRendererTurbo(this, 161, 177, textureX, textureY); // Box 609
        wheel_front_left[92] = new ModelRendererTurbo(this, 81, 185, textureX, textureY); // Box 610
        wheel_front_left[93] = new ModelRendererTurbo(this, 121, 185, textureX, textureY); // Box 611
        wheel_front_left[94] = new ModelRendererTurbo(this, 177, 185, textureX, textureY); // Box 612
        wheel_front_left[95] = new ModelRendererTurbo(this, 201, 185, textureX, textureY); // Box 613
        wheel_front_left[96] = new ModelRendererTurbo(this, 233, 185, textureX, textureY); // Box 614
        wheel_front_left[97] = new ModelRendererTurbo(this, 257, 185, textureX, textureY); // Box 615
        wheel_front_left[98] = new ModelRendererTurbo(this, 297, 185, textureX, textureY); // Box 616

        wheel_front_left[0].addBox(-3F, -8F, 0F, 6, 5, 1, 0F); // Box 12
        wheel_front_left[0].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[1].addBox(-8F, -3F, 0F, 16, 6, 1, 0F); // Box 13
        wheel_front_left[1].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[2].addBox(-10F, -3F, -0.5F, 2, 6, 6, 0F); // Box 14
        wheel_front_left[2].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[3].addBox(-3F, 3F, 0F, 6, 5, 1, 0F); // Box 15
        wheel_front_left[3].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[4].addBox(8F, -3F, -0.5F, 2, 6, 6, 0F); // Box 16
        wheel_front_left[4].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[5].addBox(-3F, 8F, -0.5F, 6, 2, 6, 0F); // Box 17
        wheel_front_left[5].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[6].addBox(-3F, -10F, -0.5F, 6, 2, 6, 0F); // Box 18
        wheel_front_left[6].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[7].addShapeBox(3F, 8F, -0.5F, 3, 2, 6, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F); // Box 19
        wheel_front_left[7].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[8].addShapeBox(8F, 3F, -0.5F, 2, 3, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F); // Box 20
        wheel_front_left[8].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[9].addShapeBox(6F, 6F, -0.5F, 2, 2, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F); // Box 21
        wheel_front_left[9].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[10].addShapeBox(8F, -6F, -0.5F, 2, 3, 6, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 22
        wheel_front_left[10].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[11].addShapeBox(3F, -10F, -0.5F, 3, 2, 6, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F); // Box 23
        wheel_front_left[11].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[12].addShapeBox(6F, -8F, -0.5F, 2, 2, 6, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 24
        wheel_front_left[12].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[13].addShapeBox(-6F, -10F, -0.5F, 3, 2, 6, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F); // Box 25
        wheel_front_left[13].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[14].addShapeBox(-10F, -6F, -0.5F, 2, 3, 6, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 26
        wheel_front_left[14].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[15].addShapeBox(-8F, -8F, -0.5F, 2, 2, 6, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 27
        wheel_front_left[15].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[16].addShapeBox(-10F, 3F, -0.5F, 2, 3, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F); // Box 28
        wheel_front_left[16].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[17].addShapeBox(-6F, 8F, -0.5F, 3, 2, 6, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 29
        wheel_front_left[17].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[18].addShapeBox(-8F, 6F, -0.5F, 2, 2, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F); // Box 30
        wheel_front_left[18].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[19].addBox(-6F, -6F, 0F, 3, 3, 1, 0F); // Box 31
        wheel_front_left[19].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[20].addBox(3F, -6F, 0F, 3, 3, 1, 0F); // Box 32
        wheel_front_left[20].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[21].addBox(3F, 3F, 0F, 3, 3, 1, 0F); // Box 33
        wheel_front_left[21].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[22].addBox(-6F, 3F, 0F, 3, 3, 1, 0F); // Box 34
        wheel_front_left[22].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[23].addShapeBox(-8F, -6F, 0F, 2, 3, 1, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 35
        wheel_front_left[23].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[24].addShapeBox(6F, -6F, 0F, 2, 3, 1, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 36
        wheel_front_left[24].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[25].addShapeBox(6F, 3F, 0F, 2, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F); // Box 37
        wheel_front_left[25].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[26].addShapeBox(-8F, 3F, 0F, 2, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F); // Box 38
        wheel_front_left[26].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[27].addShapeBox(-6F, -8F, 0F, 3, 2, 1, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 39
        wheel_front_left[27].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[28].addShapeBox(3F, -8F, 0F, 3, 2, 1, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 40
        wheel_front_left[28].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[29].addShapeBox(3F, 6F, 0F, 3, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F); // Box 41
        wheel_front_left[29].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[30].addShapeBox(-6F, 6F, 0F, 3, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F); // Box 42
        wheel_front_left[30].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[31].addBox(-6F, -3F, 0.5F, 12, 6, 5, 0F); // Box 43
        wheel_front_left[31].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[32].addBox(-3F, -8F, 0.5F, 6, 2, 4, 0F); // Box 44
        wheel_front_left[32].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[33].addBox(-3F, 6F, 0.5F, 6, 2, 4, 0F); // Box 45
        wheel_front_left[33].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[34].addBox(6F, -3F, 0.5F, 2, 6, 4, 0F); // Box 46
        wheel_front_left[34].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[35].addBox(-8F, -3F, 0.5F, 2, 6, 4, 0F); // Box 47
        wheel_front_left[35].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[36].addShapeBox(3F, 6F, 0.5F, 3, 2, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F); // Box 48
        wheel_front_left[36].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[37].addShapeBox(3F, -8F, 0.5F, 3, 2, 4, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 49
        wheel_front_left[37].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[38].addShapeBox(-6F, 6F, 0.5F, 3, 2, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 50
        wheel_front_left[38].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[39].addShapeBox(-6F, -8F, 0.5F, 3, 2, 4, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 51
        wheel_front_left[39].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[40].addShapeBox(6F, 3F, 0.5F, 2, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 52
        wheel_front_left[40].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[41].addShapeBox(-8F, 3F, 0.5F, 2, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 53
        wheel_front_left[41].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[42].addShapeBox(-8F, -6F, 0.5F, 2, 3, 4, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 54
        wheel_front_left[42].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[43].addShapeBox(6F, -6F, 0.5F, 2, 3, 4, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 55
        wheel_front_left[43].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[44].addShapeBox(3F, 3F, 0.5F, 3, 3, 4, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 56
        wheel_front_left[44].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[45].addShapeBox(3F, -6F, 0.5F, 3, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 57
        wheel_front_left[45].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[46].addShapeBox(-6F, -6F, 0.5F, 3, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 58
        wheel_front_left[46].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[47].addShapeBox(-6F, 3F, 0.5F, 3, 3, 4, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 59
        wheel_front_left[47].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[48].addBox(-3F, -6F, 0.5F, 6, 3, 5, 0F); // Box 60
        wheel_front_left[48].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[49].addBox(-3F, 3F, 0.5F, 6, 3, 5, 0F); // Box 61
        wheel_front_left[49].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[50].addShapeBox(-6F, 3F, 0.5F, 3, 3, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 62
        wheel_front_left[50].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[51].addShapeBox(-6F, -6F, 0.5F, 3, 3, 5, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 63
        wheel_front_left[51].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[52].addShapeBox(3F, -6F, 0.5F, 3, 3, 5, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 64
        wheel_front_left[52].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[53].addShapeBox(3F, 3F, 0.5F, 3, 3, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 65
        wheel_front_left[53].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[54].addShapeBox(-6F, -6F, 5.5F, 3, 3, 1, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, -1F, -0.5F, -1F, -3F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -1F, 0F, -0.5F); // Box 66
        wheel_front_left[54].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[55].addShapeBox(-6F, 3F, 5.5F, 3, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -1F, 0F, -0.5F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, -1F, -0.5F, -1F, -3F, -0.5F); // Box 68
        wheel_front_left[55].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[56].addShapeBox(3F, 3F, 5.5F, 3, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, -3F, 0F, -1F, -3F, -0.5F, 0F, -1F, -0.5F); // Box 69
        wheel_front_left[56].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[57].addShapeBox(3F, -6F, 5.5F, 3, 3, 1, 0F, 0F, 0F, 0F, 0F, -3F, 0F, -1F, -3F, -0.5F, 0F, -1F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 70
        wheel_front_left[57].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[58].addShapeBox(-3F, -3F, 5.5F, 2, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 71
        wheel_front_left[58].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[59].addShapeBox(-3F, -4F, 5.5F, 6, 1, 1, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 72
        wheel_front_left[59].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[60].addShapeBox(-3F, 3F, 5.5F, 6, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 73
        wheel_front_left[60].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[61].addShapeBox(3F, -3F, 5.5F, 1, 6, 1, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 74
        wheel_front_left[61].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[62].addShapeBox(-4F, -3F, 5.5F, 1, 6, 1, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F); // Box 75
        wheel_front_left[62].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[63].addShapeBox(-6F, -3F, 5.5F, 1, 6, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -1F, 0F, -0.5F); // Box 76
        wheel_front_left[63].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[64].addShapeBox(5F, -3F, 5.5F, 1, 6, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 77
        wheel_front_left[64].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[65].addShapeBox(-3F, 5F, 5.5F, 6, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -0.5F, 0F, -1F, -0.5F); // Box 78
        wheel_front_left[65].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[66].addShapeBox(-3F, -6F, 5.5F, 6, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -0.5F, 0F, -1F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 79
        wheel_front_left[66].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[67].addShapeBox(3.5F, -3F, 5.5F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 80
        wheel_front_left[67].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[68].addShapeBox(3.5F, -1F, 5.5F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 81
        wheel_front_left[68].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[69].addShapeBox(-4.5F, -1F, 5.5F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 82
        wheel_front_left[69].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[70].addShapeBox(3.5F, 2F, 5.5F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 83
        wheel_front_left[70].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[71].addShapeBox(-4.5F, -3F, 5.5F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 84
        wheel_front_left[71].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[72].addShapeBox(-4.5F, 2F, 5.5F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 85
        wheel_front_left[72].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[73].addShapeBox(2F, -4.5F, 5.5F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 86
        wheel_front_left[73].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[74].addShapeBox(-3F, -4.5F, 5.5F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 87
        wheel_front_left[74].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[75].addShapeBox(-1F, -4.5F, 5.5F, 2, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 88
        wheel_front_left[75].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[76].addShapeBox(-1F, 3.5F, 5.5F, 2, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 89
        wheel_front_left[76].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[77].addShapeBox(2F, 3.5F, 5.5F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 90
        wheel_front_left[77].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[78].addShapeBox(-3F, 3.5F, 5.5F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 91
        wheel_front_left[78].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[79].addShapeBox(-3F, 1F, 5.5F, 2, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 93
        wheel_front_left[79].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[80].addShapeBox(1F, 1F, 5.5F, 2, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 94
        wheel_front_left[80].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[81].addShapeBox(1F, -3F, 5.5F, 2, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 95
        wheel_front_left[81].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[82].addShapeBox(-1F, -3F, 5.5F, 2, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -0.5F, 0F, -1F, -0.5F); // Box 96
        wheel_front_left[82].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[83].addShapeBox(-1F, 1F, 5.5F, 2, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -0.5F, 0F, -1F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 97
        wheel_front_left[83].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[84].addShapeBox(1F, -1F, 5.5F, 2, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -1F, 0F, -0.5F); // Box 98
        wheel_front_left[84].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[85].addShapeBox(-3F, -1F, 5.5F, 2, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 99
        wheel_front_left[85].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[86].addShapeBox(-1F, -1F, 5.5F, 2, 2, 1, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F); // Box 100
        wheel_front_left[86].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[87].addShapeBox(-3F, 4F, 5.5F, 6, 1, 1, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 533
        wheel_front_left[87].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[88].addShapeBox(-3F, -5F, 5.5F, 6, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 534
        wheel_front_left[88].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[89].addShapeBox(4F, -3F, 5.5F, 1, 6, 1, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F); // Box 535
        wheel_front_left[89].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[90].addShapeBox(-5F, -3F, 5.5F, 1, 6, 1, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 536
        wheel_front_left[90].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[91].addShapeBox(3.5F, -2F, 5.5F, 1, 1, 1, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F); // Box 609
        wheel_front_left[91].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[92].addShapeBox(3.5F, 1F, 5.5F, 1, 1, 1, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F); // Box 610
        wheel_front_left[92].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[93].addShapeBox(-4.5F, 1F, 5.5F, 1, 1, 1, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F); // Box 611
        wheel_front_left[93].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[94].addShapeBox(-4.5F, -2F, 5.5F, 1, 1, 1, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F); // Box 612
        wheel_front_left[94].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[95].addShapeBox(-2F, -4.5F, 5.5F, 1, 1, 1, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F); // Box 613
        wheel_front_left[95].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[96].addShapeBox(1F, -4.5F, 5.5F, 1, 1, 1, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F); // Box 614
        wheel_front_left[96].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[97].addShapeBox(1F, 3.5F, 5.5F, 1, 1, 1, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F); // Box 615
        wheel_front_left[97].setRotationPoint(35F, 0F, 17F);

        wheel_front_left[98].addShapeBox(-2F, 3.5F, 5.5F, 1, 1, 1, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F); // Box 616
        wheel_front_left[98].setRotationPoint(35F, 0F, 17F);
        this.add("wheel_front_left", wheel_front_left);

        ModelRendererTurbo[] wheel_front_right = new ModelRendererTurbo[99];
        wheel_front_right[0] = new ModelRendererTurbo(this, 177, 41, textureX, textureY); // Box 12
        wheel_front_right[1] = new ModelRendererTurbo(this, 193, 41, textureX, textureY); // Box 13
        wheel_front_right[2] = new ModelRendererTurbo(this, 233, 41, textureX, textureY); // Box 14
        wheel_front_right[3] = new ModelRendererTurbo(this, 257, 41, textureX, textureY); // Box 15
        wheel_front_right[4] = new ModelRendererTurbo(this, 273, 41, textureX, textureY); // Box 16
        wheel_front_right[5] = new ModelRendererTurbo(this, 297, 41, textureX, textureY); // Box 17
        wheel_front_right[6] = new ModelRendererTurbo(this, 1, 49, textureX, textureY); // Box 18
        wheel_front_right[7] = new ModelRendererTurbo(this, 33, 49, textureX, textureY); // Box 19
        wheel_front_right[8] = new ModelRendererTurbo(this, 57, 49, textureX, textureY); // Box 20
        wheel_front_right[9] = new ModelRendererTurbo(this, 81, 49, textureX, textureY); // Box 21
        wheel_front_right[10] = new ModelRendererTurbo(this, 145, 49, textureX, textureY); // Box 22
        wheel_front_right[11] = new ModelRendererTurbo(this, 169, 49, textureX, textureY); // Box 23
        wheel_front_right[12] = new ModelRendererTurbo(this, 193, 49, textureX, textureY); // Box 24
        wheel_front_right[13] = new ModelRendererTurbo(this, 217, 49, textureX, textureY); // Box 25
        wheel_front_right[14] = new ModelRendererTurbo(this, 249, 49, textureX, textureY); // Box 26
        wheel_front_right[15] = new ModelRendererTurbo(this, 321, 49, textureX, textureY); // Box 27
        wheel_front_right[16] = new ModelRendererTurbo(this, 345, 49, textureX, textureY); // Box 28
        wheel_front_right[17] = new ModelRendererTurbo(this, 369, 49, textureX, textureY); // Box 29
        wheel_front_right[18] = new ModelRendererTurbo(this, 393, 49, textureX, textureY); // Box 30
        wheel_front_right[19] = new ModelRendererTurbo(this, 289, 41, textureX, textureY); // Box 31
        wheel_front_right[20] = new ModelRendererTurbo(this, 481, 41, textureX, textureY); // Box 32
        wheel_front_right[21] = new ModelRendererTurbo(this, 25, 49, textureX, textureY); // Box 33
        wheel_front_right[22] = new ModelRendererTurbo(this, 49, 49, textureX, textureY); // Box 34
        wheel_front_right[23] = new ModelRendererTurbo(this, 249, 41, textureX, textureY); // Box 35
        wheel_front_right[24] = new ModelRendererTurbo(this, 321, 41, textureX, textureY); // Box 36
        wheel_front_right[25] = new ModelRendererTurbo(this, 505, 41, textureX, textureY); // Box 37
        wheel_front_right[26] = new ModelRendererTurbo(this, 73, 49, textureX, textureY); // Box 38
        wheel_front_right[27] = new ModelRendererTurbo(this, 97, 49, textureX, textureY); // Box 39
        wheel_front_right[28] = new ModelRendererTurbo(this, 121, 49, textureX, textureY); // Box 40
        wheel_front_right[29] = new ModelRendererTurbo(this, 161, 49, textureX, textureY); // Box 41
        wheel_front_right[30] = new ModelRendererTurbo(this, 185, 49, textureX, textureY); // Box 42
        wheel_front_right[31] = new ModelRendererTurbo(this, 417, 49, textureX, textureY); // Box 43
        wheel_front_right[32] = new ModelRendererTurbo(this, 457, 49, textureX, textureY); // Box 44
        wheel_front_right[33] = new ModelRendererTurbo(this, 481, 49, textureX, textureY); // Box 45
        wheel_front_right[34] = new ModelRendererTurbo(this, 97, 57, textureX, textureY); // Box 46
        wheel_front_right[35] = new ModelRendererTurbo(this, 113, 57, textureX, textureY); // Box 47
        wheel_front_right[36] = new ModelRendererTurbo(this, 129, 57, textureX, textureY); // Box 48
        wheel_front_right[37] = new ModelRendererTurbo(this, 233, 57, textureX, textureY); // Box 49
        wheel_front_right[38] = new ModelRendererTurbo(this, 265, 57, textureX, textureY); // Box 50
        wheel_front_right[39] = new ModelRendererTurbo(this, 281, 57, textureX, textureY); // Box 51
        wheel_front_right[40] = new ModelRendererTurbo(this, 297, 57, textureX, textureY); // Box 52
        wheel_front_right[41] = new ModelRendererTurbo(this, 449, 57, textureX, textureY); // Box 53
        wheel_front_right[42] = new ModelRendererTurbo(this, 465, 57, textureX, textureY); // Box 54
        wheel_front_right[43] = new ModelRendererTurbo(this, 481, 57, textureX, textureY); // Box 55
        wheel_front_right[44] = new ModelRendererTurbo(this, 497, 57, textureX, textureY); // Box 56
        wheel_front_right[45] = new ModelRendererTurbo(this, 1, 65, textureX, textureY); // Box 57
        wheel_front_right[46] = new ModelRendererTurbo(this, 17, 65, textureX, textureY); // Box 58
        wheel_front_right[47] = new ModelRendererTurbo(this, 33, 65, textureX, textureY); // Box 59
        wheel_front_right[48] = new ModelRendererTurbo(this, 49, 65, textureX, textureY); // Box 60
        wheel_front_right[49] = new ModelRendererTurbo(this, 73, 65, textureX, textureY); // Box 61
        wheel_front_right[50] = new ModelRendererTurbo(this, 121, 65, textureX, textureY); // Box 62
        wheel_front_right[51] = new ModelRendererTurbo(this, 145, 65, textureX, textureY); // Box 63
        wheel_front_right[52] = new ModelRendererTurbo(this, 169, 65, textureX, textureY); // Box 64
        wheel_front_right[53] = new ModelRendererTurbo(this, 193, 65, textureX, textureY); // Box 65
        wheel_front_right[54] = new ModelRendererTurbo(this, 209, 49, textureX, textureY); // Box 66
        wheel_front_right[55] = new ModelRendererTurbo(this, 337, 49, textureX, textureY); // Box 68
        wheel_front_right[56] = new ModelRendererTurbo(this, 361, 49, textureX, textureY); // Box 69
        wheel_front_right[57] = new ModelRendererTurbo(this, 385, 49, textureX, textureY); // Box 70
        wheel_front_right[58] = new ModelRendererTurbo(this, 265, 49, textureX, textureY); // Box 71
        wheel_front_right[59] = new ModelRendererTurbo(this, 209, 65, textureX, textureY); // Box 72
        wheel_front_right[60] = new ModelRendererTurbo(this, 225, 65, textureX, textureY); // Box 73
        wheel_front_right[61] = new ModelRendererTurbo(this, 505, 49, textureX, textureY); // Box 74
        wheel_front_right[62] = new ModelRendererTurbo(this, 25, 57, textureX, textureY); // Box 75
        wheel_front_right[63] = new ModelRendererTurbo(this, 209, 57, textureX, textureY); // Box 76
        wheel_front_right[64] = new ModelRendererTurbo(this, 313, 57, textureX, textureY); // Box 77
        wheel_front_right[65] = new ModelRendererTurbo(this, 241, 65, textureX, textureY); // Box 78
        wheel_front_right[66] = new ModelRendererTurbo(this, 257, 65, textureX, textureY); // Box 79
        wheel_front_right[67] = new ModelRendererTurbo(this, 113, 25, textureX, textureY); // Box 80
        wheel_front_right[68] = new ModelRendererTurbo(this, 137, 25, textureX, textureY); // Box 81
        wheel_front_right[69] = new ModelRendererTurbo(this, 161, 25, textureX, textureY); // Box 82
        wheel_front_right[70] = new ModelRendererTurbo(this, 417, 33, textureX, textureY); // Box 83
        wheel_front_right[71] = new ModelRendererTurbo(this, 441, 33, textureX, textureY); // Box 84
        wheel_front_right[72] = new ModelRendererTurbo(this, 465, 33, textureX, textureY); // Box 85
        wheel_front_right[73] = new ModelRendererTurbo(this, 489, 33, textureX, textureY); // Box 86
        wheel_front_right[74] = new ModelRendererTurbo(this, 129, 41, textureX, textureY); // Box 87
        wheel_front_right[75] = new ModelRendererTurbo(this, 409, 49, textureX, textureY); // Box 88
        wheel_front_right[76] = new ModelRendererTurbo(this, 449, 49, textureX, textureY); // Box 89
        wheel_front_right[77] = new ModelRendererTurbo(this, 233, 41, textureX, textureY); // Box 90
        wheel_front_right[78] = new ModelRendererTurbo(this, 273, 41, textureX, textureY); // Box 91
        wheel_front_right[79] = new ModelRendererTurbo(this, 337, 57, textureX, textureY); // Box 93
        wheel_front_right[80] = new ModelRendererTurbo(this, 409, 57, textureX, textureY); // Box 94
        wheel_front_right[81] = new ModelRendererTurbo(this, 137, 65, textureX, textureY); // Box 95
        wheel_front_right[82] = new ModelRendererTurbo(this, 161, 65, textureX, textureY); // Box 96
        wheel_front_right[83] = new ModelRendererTurbo(this, 185, 65, textureX, textureY); // Box 97
        wheel_front_right[84] = new ModelRendererTurbo(this, 273, 65, textureX, textureY); // Box 98
        wheel_front_right[85] = new ModelRendererTurbo(this, 281, 65, textureX, textureY); // Box 99
        wheel_front_right[86] = new ModelRendererTurbo(this, 289, 65, textureX, textureY); // Box 100
        wheel_front_right[87] = new ModelRendererTurbo(this, 25, 161, textureX, textureY); // Box 537
        wheel_front_right[88] = new ModelRendererTurbo(this, 217, 161, textureX, textureY); // Box 538
        wheel_front_right[89] = new ModelRendererTurbo(this, 209, 233, textureX, textureY); // Box 539
        wheel_front_right[90] = new ModelRendererTurbo(this, 273, 233, textureX, textureY); // Box 541
        wheel_front_right[91] = new ModelRendererTurbo(this, 337, 185, textureX, textureY); // Box 617
        wheel_front_right[92] = new ModelRendererTurbo(this, 353, 185, textureX, textureY); // Box 618
        wheel_front_right[93] = new ModelRendererTurbo(this, 377, 185, textureX, textureY); // Box 619
        wheel_front_right[94] = new ModelRendererTurbo(this, 1, 193, textureX, textureY); // Box 620
        wheel_front_right[95] = new ModelRendererTurbo(this, 161, 193, textureX, textureY); // Box 621
        wheel_front_right[96] = new ModelRendererTurbo(this, 433, 193, textureX, textureY); // Box 622
        wheel_front_right[97] = new ModelRendererTurbo(this, 473, 193, textureX, textureY); // Box 623
        wheel_front_right[98] = new ModelRendererTurbo(this, 497, 193, textureX, textureY); // Box 624

        wheel_front_right[0].addBox(-3F, -8F, -1F, 6, 5, 1, 0F); // Box 12
        wheel_front_right[0].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[1].addBox(-8F, -3F, -1F, 16, 6, 1, 0F); // Box 13
        wheel_front_right[1].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[2].addBox(-10F, -3F, -5.5F, 2, 6, 6, 0F); // Box 14
        wheel_front_right[2].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[3].addBox(-3F, 3F, -1F, 6, 5, 1, 0F); // Box 15
        wheel_front_right[3].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[4].addBox(8F, -3F, -5.5F, 2, 6, 6, 0F); // Box 16
        wheel_front_right[4].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[5].addBox(-3F, 8F, -5.5F, 6, 2, 6, 0F); // Box 17
        wheel_front_right[5].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[6].addBox(-3F, -10F, -5.5F, 6, 2, 6, 0F); // Box 18
        wheel_front_right[6].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[7].addShapeBox(3F, 8F, -5.5F, 3, 2, 6, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F); // Box 19
        wheel_front_right[7].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[8].addShapeBox(8F, 3F, -5.5F, 2, 3, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F); // Box 20
        wheel_front_right[8].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[9].addShapeBox(6F, 6F, -5.5F, 2, 2, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F); // Box 21
        wheel_front_right[9].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[10].addShapeBox(8F, -6F, -5.5F, 2, 3, 6, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 22
        wheel_front_right[10].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[11].addShapeBox(3F, -10F, -5.5F, 3, 2, 6, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F); // Box 23
        wheel_front_right[11].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[12].addShapeBox(6F, -8F, -5.5F, 2, 2, 6, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 24
        wheel_front_right[12].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[13].addShapeBox(-6F, -10F, -5.5F, 3, 2, 6, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F); // Box 25
        wheel_front_right[13].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[14].addShapeBox(-10F, -6F, -5.5F, 2, 3, 6, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 26
        wheel_front_right[14].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[15].addShapeBox(-8F, -8F, -5.5F, 2, 2, 6, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 27
        wheel_front_right[15].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[16].addShapeBox(-10F, 3F, -5.5F, 2, 3, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F); // Box 28
        wheel_front_right[16].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[17].addShapeBox(-6F, 8F, -5.5F, 3, 2, 6, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 29
        wheel_front_right[17].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[18].addShapeBox(-8F, 6F, -5.5F, 2, 2, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F); // Box 30
        wheel_front_right[18].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[19].addBox(-6F, -6F, -1F, 3, 3, 1, 0F); // Box 31
        wheel_front_right[19].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[20].addBox(3F, -6F, -1F, 3, 3, 1, 0F); // Box 32
        wheel_front_right[20].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[21].addBox(3F, 3F, -1F, 3, 3, 1, 0F); // Box 33
        wheel_front_right[21].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[22].addBox(-6F, 3F, -1F, 3, 3, 1, 0F); // Box 34
        wheel_front_right[22].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[23].addShapeBox(-8F, -6F, -1F, 2, 3, 1, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 35
        wheel_front_right[23].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[24].addShapeBox(6F, -6F, -1F, 2, 3, 1, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 36
        wheel_front_right[24].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[25].addShapeBox(6F, 3F, -1F, 2, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F); // Box 37
        wheel_front_right[25].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[26].addShapeBox(-8F, 3F, -1F, 2, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F); // Box 38
        wheel_front_right[26].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[27].addShapeBox(-6F, -8F, -1F, 3, 2, 1, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 39
        wheel_front_right[27].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[28].addShapeBox(3F, -8F, -1F, 3, 2, 1, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 40
        wheel_front_right[28].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[29].addShapeBox(3F, 6F, -1F, 3, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F); // Box 41
        wheel_front_right[29].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[30].addShapeBox(-6F, 6F, -1F, 3, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F); // Box 42
        wheel_front_right[30].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[31].addBox(-6F, -3F, -5.5F, 12, 6, 5, 0F); // Box 43
        wheel_front_right[31].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[32].addBox(-3F, -8F, -4.5F, 6, 2, 4, 0F); // Box 44
        wheel_front_right[32].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[33].addBox(-3F, 6F, -4.5F, 6, 2, 4, 0F); // Box 45
        wheel_front_right[33].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[34].addBox(6F, -3F, -4.5F, 2, 6, 4, 0F); // Box 46
        wheel_front_right[34].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[35].addBox(-8F, -3F, -4.5F, 2, 6, 4, 0F); // Box 47
        wheel_front_right[35].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[36].addShapeBox(3F, 6F, -4.5F, 3, 2, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F); // Box 48
        wheel_front_right[36].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[37].addShapeBox(3F, -8F, -4.5F, 3, 2, 4, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 49
        wheel_front_right[37].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[38].addShapeBox(-6F, 6F, -4.5F, 3, 2, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 50
        wheel_front_right[38].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[39].addShapeBox(-6F, -8F, -4.5F, 3, 2, 4, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 51
        wheel_front_right[39].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[40].addShapeBox(6F, 3F, -4.5F, 2, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 52
        wheel_front_right[40].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[41].addShapeBox(-8F, 3F, -4.5F, 2, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 53
        wheel_front_right[41].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[42].addShapeBox(-8F, -6F, -4.5F, 2, 3, 4, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 54
        wheel_front_right[42].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[43].addShapeBox(6F, -6F, -4.5F, 2, 3, 4, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 55
        wheel_front_right[43].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[44].addShapeBox(3F, 3F, -4.5F, 3, 3, 4, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 56
        wheel_front_right[44].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[45].addShapeBox(3F, -6F, -4.5F, 3, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 57
        wheel_front_right[45].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[46].addShapeBox(-6F, -6F, -4.5F, 3, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 58
        wheel_front_right[46].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[47].addShapeBox(-6F, 3F, -4.5F, 3, 3, 4, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 59
        wheel_front_right[47].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[48].addBox(-3F, -6F, -5.5F, 6, 3, 5, 0F); // Box 60
        wheel_front_right[48].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[49].addBox(-3F, 3F, -5.5F, 6, 3, 5, 0F); // Box 61
        wheel_front_right[49].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[50].addShapeBox(-6F, 3F, -5.5F, 3, 3, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 62
        wheel_front_right[50].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[51].addShapeBox(-6F, -6F, -5.5F, 3, 3, 5, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 63
        wheel_front_right[51].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[52].addShapeBox(3F, -6F, -5.5F, 3, 3, 5, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 64
        wheel_front_right[52].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[53].addShapeBox(3F, 3F, -5.5F, 3, 3, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 65
        wheel_front_right[53].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[54].addShapeBox(-6F, -6F, -6.5F, 3, 3, 1, 0F, -1F, -3F, -0.5F, 0F, -1F, -0.5F, 0F, 0F, 0F, 0F, -3F, 0F, -1F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 66
        wheel_front_right[54].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[55].addShapeBox(-6F, 3F, -6.5F, 3, 3, 1, 0F, -1F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -3F, -0.5F, 0F, -1F, -0.5F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 68
        wheel_front_right[55].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[56].addShapeBox(3F, 3F, -6.5F, 3, 3, 1, 0F, 0F, 0F, -0.5F, -1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -0.5F, -1F, -3F, -0.5F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 69
        wheel_front_right[56].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[57].addShapeBox(3F, -6F, -6.5F, 3, 3, 1, 0F, 0F, -1F, -0.5F, -1F, -3F, -0.5F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 70
        wheel_front_right[57].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[58].addShapeBox(-3F, -3F, -6.5F, 2, 2, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 71
        wheel_front_right[58].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[59].addShapeBox(-3F, -4F, -6.5F, 6, 1, 1, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 72
        wheel_front_right[59].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[60].addShapeBox(-3F, 3F, -6.5F, 6, 1, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 73
        wheel_front_right[60].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[61].addShapeBox(3F, -3F, -6.5F, 1, 6, 1, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F); // Box 74
        wheel_front_right[61].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[62].addShapeBox(-4F, -3F, -6.5F, 1, 6, 1, 0F, -0.5F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, -0.5F, 0F, 0F); // Box 75
        wheel_front_right[62].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[63].addShapeBox(-6F, -3F, -6.5F, 1, 6, 1, 0F, -1F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 76
        wheel_front_right[63].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[64].addShapeBox(5F, -3F, -6.5F, 1, 6, 1, 0F, 0F, 0F, -0.5F, -1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 77
        wheel_front_right[64].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[65].addShapeBox(-3F, 5F, -6.5F, 6, 1, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -0.5F, 0F, -1F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 78
        wheel_front_right[65].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[66].addShapeBox(-3F, -6F, -6.5F, 6, 1, 1, 0F, 0F, -1F, -0.5F, 0F, -1F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 79
        wheel_front_right[66].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[67].addShapeBox(3.5F, -3F, -6.5F, 1, 1, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 80
        wheel_front_right[67].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[68].addShapeBox(3.5F, -1F, -6.5F, 1, 2, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 81
        wheel_front_right[68].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[69].addShapeBox(-4.5F, -1F, -6.5F, 1, 2, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 82
        wheel_front_right[69].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[70].addShapeBox(3.5F, 2F, -6.5F, 1, 1, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 83
        wheel_front_right[70].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[71].addShapeBox(-4.5F, -3F, -6.5F, 1, 1, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 84
        wheel_front_right[71].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[72].addShapeBox(-4.5F, 2F, -6.5F, 1, 1, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 85
        wheel_front_right[72].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[73].addShapeBox(2F, -4.5F, -6.5F, 1, 1, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 86
        wheel_front_right[73].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[74].addShapeBox(-3F, -4.5F, -6.5F, 1, 1, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 87
        wheel_front_right[74].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[75].addShapeBox(-1F, -4.5F, -6.5F, 2, 1, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 88
        wheel_front_right[75].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[76].addShapeBox(-1F, 3.5F, -6.5F, 2, 1, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 89
        wheel_front_right[76].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[77].addShapeBox(2F, 3.5F, -6.5F, 1, 1, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 90
        wheel_front_right[77].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[78].addShapeBox(-3F, 3.5F, -6.5F, 1, 1, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 91
        wheel_front_right[78].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[79].addShapeBox(-3F, 1F, -6.5F, 2, 2, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 93
        wheel_front_right[79].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[80].addShapeBox(1F, 1F, -6.5F, 2, 2, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 94
        wheel_front_right[80].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[81].addShapeBox(1F, -3F, -6.5F, 2, 2, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 95
        wheel_front_right[81].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[82].addShapeBox(-1F, -3F, -6.5F, 2, 2, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -0.5F, 0F, -1F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 96
        wheel_front_right[82].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[83].addShapeBox(-1F, 1F, -6.5F, 2, 2, 1, 0F, 0F, -1F, -0.5F, 0F, -1F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 97
        wheel_front_right[83].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[84].addShapeBox(1F, -1F, -6.5F, 2, 2, 1, 0F, -1F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 98
        wheel_front_right[84].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[85].addShapeBox(-3F, -1F, -6.5F, 2, 2, 1, 0F, 0F, 0F, -0.5F, -1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 99
        wheel_front_right[85].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[86].addShapeBox(-1F, -1F, -6.5F, 2, 2, 1, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F); // Box 100
        wheel_front_right[86].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[87].addShapeBox(-5F, -3F, -6.5F, 1, 6, 1, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F); // Box 537
        wheel_front_right[87].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[88].addShapeBox(4F, -3F, -6.5F, 1, 6, 1, 0F, -0.5F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, -0.5F, 0F, 0F); // Box 538
        wheel_front_right[88].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[89].addShapeBox(-3F, -5F, -6.5F, 6, 1, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 539
        wheel_front_right[89].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[90].addShapeBox(-3F, 4F, -6.5F, 6, 1, 1, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 541
        wheel_front_right[90].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[91].addShapeBox(3.5F, -2F, -6.5F, 1, 1, 1, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F); // Box 617
        wheel_front_right[91].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[92].addShapeBox(3.5F, 1F, -6.5F, 1, 1, 1, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F); // Box 618
        wheel_front_right[92].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[93].addShapeBox(-4.5F, 1F, -6.5F, 1, 1, 1, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F); // Box 619
        wheel_front_right[93].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[94].addShapeBox(-4.5F, -2F, -6.5F, 1, 1, 1, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F); // Box 620
        wheel_front_right[94].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[95].addShapeBox(-2F, -4.5F, -6.5F, 1, 1, 1, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F); // Box 621
        wheel_front_right[95].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[96].addShapeBox(1F, -4.5F, -6.5F, 1, 1, 1, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F); // Box 622
        wheel_front_right[96].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[97].addShapeBox(1F, 3.5F, -6.5F, 1, 1, 1, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F); // Box 623
        wheel_front_right[97].setRotationPoint(35F, 0F, -17F);

        wheel_front_right[98].addShapeBox(-2F, 3.5F, -6.5F, 1, 1, 1, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F); // Box 624
        wheel_front_right[98].setRotationPoint(35F, 0F, -17F);
        this.add("wheel_front_right", wheel_front_right);
    }

    @Override
    public void render(VehicleData data, String us){
        this.def_renderWheels4(data, us);
    }

    @Override
    public void render(VehicleData data, String us, VehicleEntity vehicle, int meta){
        this.def_renderWheels4(data, us, vehicle);
    }

}
