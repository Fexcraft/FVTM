//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2017 Minecraft-SMP.de
// This file is for Fex's Vehicle mod
// Model: C7
// Model Creator: FEX___96 (Ferdinand)
// Created on: 11.01.2017 - 21:49:25
// Last changed on: 11.01.2017 - 21:49:25
package net.fexcraft.mod.addons.fvp.models.vehicle;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.vehicle.VehicleModelTMT;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.util.render.RGB;

public class ModelC7 extends VehicleModelTMT {

    public ModelC7(){
    	super(); textureX = 512; textureY = 512;
        this.addToCreators("Ferdinand (FEX___96)");
        body = new ModelRendererTurbo[94];
        body[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
        body[1] = new ModelRendererTurbo(this, 137, 1, textureX, textureY); // Box 1
        body[2] = new ModelRendererTurbo(this, 249, 1, textureX, textureY); // Box 2
        body[3] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 3
        body[4] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 4
        body[5] = new ModelRendererTurbo(this, 361, 1, textureX, textureY); // Box 5
        body[6] = new ModelRendererTurbo(this, 377, 1, textureX, textureY); // Box 6
        body[7] = new ModelRendererTurbo(this, 393, 1, textureX, textureY); // Box 7
        body[8] = new ModelRendererTurbo(this, 425, 1, textureX, textureY); // Box 8
        body[9] = new ModelRendererTurbo(this, 441, 1, textureX, textureY); // Box 9
        body[10] = new ModelRendererTurbo(this, 457, 1, textureX, textureY); // Box 10
        body[11] = new ModelRendererTurbo(this, 489, 1, textureX, textureY); // Box 11
        body[12] = new ModelRendererTurbo(this, 1, 9, textureX, textureY); // Box 12
        body[13] = new ModelRendererTurbo(this, 17, 9, textureX, textureY); // Box 13
        body[14] = new ModelRendererTurbo(this, 137, 9, textureX, textureY); // Box 14
        body[15] = new ModelRendererTurbo(this, 153, 9, textureX, textureY); // Box 15
        body[16] = new ModelRendererTurbo(this, 169, 9, textureX, textureY); // Box 16
        body[17] = new ModelRendererTurbo(this, 201, 9, textureX, textureY); // Box 17
        body[18] = new ModelRendererTurbo(this, 217, 9, textureX, textureY); // Box 18
        body[19] = new ModelRendererTurbo(this, 233, 9, textureX, textureY); // Box 19
        body[20] = new ModelRendererTurbo(this, 249, 9, textureX, textureY); // Box 20
        body[21] = new ModelRendererTurbo(this, 281, 9, textureX, textureY); // Box 21
        body[22] = new ModelRendererTurbo(this, 297, 9, textureX, textureY); // Box 22
        body[23] = new ModelRendererTurbo(this, 313, 9, textureX, textureY); // Box 23
        body[24] = new ModelRendererTurbo(this, 337, 9, textureX, textureY); // Box 24
        body[25] = new ModelRendererTurbo(this, 329, 9, textureX, textureY); // Box 25
        body[26] = new ModelRendererTurbo(this, 369, 9, textureX, textureY); // Box 26
        body[27] = new ModelRendererTurbo(this, 385, 9, textureX, textureY); // Box 27
        body[28] = new ModelRendererTurbo(this, 401, 9, textureX, textureY); // Box 28
        body[29] = new ModelRendererTurbo(this, 401, 9, textureX, textureY); // Box 29
        body[30] = new ModelRendererTurbo(this, 417, 9, textureX, textureY); // Box 30
        body[31] = new ModelRendererTurbo(this, 441, 9, textureX, textureY); // Box 31
        body[32] = new ModelRendererTurbo(this, 457, 9, textureX, textureY); // Box 32
        body[33] = new ModelRendererTurbo(this, 473, 9, textureX, textureY); // Box 33
        body[34] = new ModelRendererTurbo(this, 489, 9, textureX, textureY); // Box 34
        body[35] = new ModelRendererTurbo(this, 137, 17, textureX, textureY); // Box 35
        body[36] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 36
        body[37] = new ModelRendererTurbo(this, 17, 17, textureX, textureY); // Box 37
        body[38] = new ModelRendererTurbo(this, 209, 17, textureX, textureY); // Box 38
        body[39] = new ModelRendererTurbo(this, 257, 25, textureX, textureY); // Box 39
        body[40] = new ModelRendererTurbo(this, 1, 41, textureX, textureY); // Box 40
        body[41] = new ModelRendererTurbo(this, 441, 17, textureX, textureY); // Box 41
        body[42] = new ModelRendererTurbo(this, 137, 17, textureX, textureY); // Box 42
        body[43] = new ModelRendererTurbo(this, 153, 17, textureX, textureY); // Box 43
        body[44] = new ModelRendererTurbo(this, 441, 41, textureX, textureY); // Box 60
        body[45] = new ModelRendererTurbo(this, 417, 17, textureX, textureY); // Box 61
        body[46] = new ModelRendererTurbo(this, 441, 17, textureX, textureY); // Box 66
        body[47] = new ModelRendererTurbo(this, 497, 1, textureX, textureY); // Box 72
        body[48] = new ModelRendererTurbo(this, 497, 9, textureX, textureY); // Box 73
        body[49] = new ModelRendererTurbo(this, 417, 25, textureX, textureY); // Box 74
        body[50] = new ModelRendererTurbo(this, 209, 33, textureX, textureY); // Box 75
        body[51] = new ModelRendererTurbo(this, 225, 33, textureX, textureY); // Box 76
        body[52] = new ModelRendererTurbo(this, 305, 33, textureX, textureY); // Box 79
        body[53] = new ModelRendererTurbo(this, 321, 33, textureX, textureY); // Box 80
        body[54] = new ModelRendererTurbo(this, 337, 33, textureX, textureY); // Box 81
        body[55] = new ModelRendererTurbo(this, 369, 33, textureX, textureY); // Box 82
        body[56] = new ModelRendererTurbo(this, 385, 33, textureX, textureY); // Box 83
        body[57] = new ModelRendererTurbo(this, 225, 25, textureX, textureY); // Box 84
        body[58] = new ModelRendererTurbo(this, 401, 33, textureX, textureY); // Box 85
        body[59] = new ModelRendererTurbo(this, 417, 33, textureX, textureY); // Box 86
        body[60] = new ModelRendererTurbo(this, 321, 17, textureX, textureY); // Box 87
        body[61] = new ModelRendererTurbo(this, 257, 33, textureX, textureY); // Box 88
        body[62] = new ModelRendererTurbo(this, 57, 41, textureX, textureY); // Box 89
        body[63] = new ModelRendererTurbo(this, 105, 41, textureX, textureY); // Box 90
        body[64] = new ModelRendererTurbo(this, 305, 41, textureX, textureY); // Box 91
        body[65] = new ModelRendererTurbo(this, 481, 41, textureX, textureY); // Box 92
        body[66] = new ModelRendererTurbo(this, 17, 41, textureX, textureY); // Box 99
        body[67] = new ModelRendererTurbo(this, 57, 41, textureX, textureY); // Box 100
        body[68] = new ModelRendererTurbo(this, 73, 41, textureX, textureY); // Box 106
        body[69] = new ModelRendererTurbo(this, 105, 41, textureX, textureY); // Box 107
        body[70] = new ModelRendererTurbo(this, 137, 57, textureX, textureY); // Box 108
        body[71] = new ModelRendererTurbo(this, 209, 57, textureX, textureY); // Box 109
        body[72] = new ModelRendererTurbo(this, 465, 49, textureX, textureY); // Box 121
        body[73] = new ModelRendererTurbo(this, 225, 57, textureX, textureY); // Box 123
        body[74] = new ModelRendererTurbo(this, 249, 57, textureX, textureY); // Box 124
        body[75] = new ModelRendererTurbo(this, 505, 57, textureX, textureY); // Box 125
        body[76] = new ModelRendererTurbo(this, 273, 65, textureX, textureY); // Box 131
        body[77] = new ModelRendererTurbo(this, 1, 73, textureX, textureY); // Box 132
        body[78] = new ModelRendererTurbo(this, 289, 81, textureX, textureY); // Box 133
        body[79] = new ModelRendererTurbo(this, 169, 73, textureX, textureY); // Box 135
        body[80] = new ModelRendererTurbo(this, 369, 1, textureX, textureY); // Box 138
        body[81] = new ModelRendererTurbo(this, 385, 1, textureX, textureY); // Box 139
        body[82] = new ModelRendererTurbo(this, 449, 1, textureX, textureY); // Box 140
        body[83] = new ModelRendererTurbo(this, 161, 9, textureX, textureY); // Box 141
        body[84] = new ModelRendererTurbo(this, 305, 65, textureX, textureY); // Box 142
        body[85] = new ModelRendererTurbo(this, 361, 65, textureX, textureY); // Box 143
        body[86] = new ModelRendererTurbo(this, 9, 49, textureX, textureY); // Box 144
        body[87] = new ModelRendererTurbo(this, 497, 89, textureX, textureY); // Box 145
        body[88] = new ModelRendererTurbo(this, 337, 89, textureX, textureY); // Box 156
        body[89] = new ModelRendererTurbo(this, 217, 105, textureX, textureY); // Box 157
        body[90] = new ModelRendererTurbo(this, 449, 81, textureX, textureY); // Box 158
        body[91] = new ModelRendererTurbo(this, 377, 137, textureX, textureY); // Box 241
        body[92] = new ModelRendererTurbo(this, 393, 137, textureX, textureY); // Box 242
        body[93] = new ModelRendererTurbo(this, 433, 129, textureX, textureY); // Box 245

        body[0].addBox(0F, 0F, 0F, 48, 1, 32, 0F); // Box 0
        body[0].setRotationPoint(-24F, -3F, -16F);

        body[1].addShapeBox(0F, 0F, 0F, 50, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.9F, 0F, 0F, -0.9F, 0F, 0F, -0.9F, 0F, 0F, -0.9F, 0F, 0F); // Box 1
        body[1].setRotationPoint(-25F, -4F, -18F);

        body[2].addShapeBox(0F, 0F, 0F, 50, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.9F, 0F, 0F, -0.9F, 0F, 0F, -0.9F, 0F, 0F, -0.9F, 0F, 0F); // Box 2
        body[2].setRotationPoint(-25F, -4F, 16F);

        body[3].addShapeBox(0F, 0F, 0F, 2, 5, 2, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 3
        body[3].setRotationPoint(23F, -9F, -18F);

        body[4].addShapeBox(0F, 0F, 0F, 2, 5, 2, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 4
        body[4].setRotationPoint(38F, -9F, -18F);

        body[5].addShapeBox(0F, 0F, 0F, 2, 1, 2, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 5
        body[5].setRotationPoint(37F, -10F, -18F);

        body[6].addShapeBox(0F, 0F, 0F, 2, 1, 2, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 6
        body[6].setRotationPoint(24F, -10F, -18F);

        body[7].addShapeBox(0F, 0F, 0F, 13, 1, 2, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 7
        body[7].setRotationPoint(25F, -11F, -18F);

        body[8].addShapeBox(0F, 0F, 0F, 2, 5, 2, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 8
        body[8].setRotationPoint(23F, -9F, 16F);

        body[9].addShapeBox(0F, 0F, 0F, 2, 1, 2, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 9
        body[9].setRotationPoint(24F, -10F, 16F);

        body[10].addShapeBox(0F, 0F, 0F, 13, 1, 2, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 10
        body[10].setRotationPoint(25F, -11F, 16F);

        body[11].addShapeBox(0F, 0F, 0F, 2, 1, 2, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 11
        body[11].setRotationPoint(37F, -10F, 16F);

        body[12].addShapeBox(0F, 0F, 0F, 2, 5, 2, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 12
        body[12].setRotationPoint(38F, -9F, 16F);

        body[13].addShapeBox(0F, 0F, 0F, 2, 5, 2, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 13
        body[13].setRotationPoint(-40F, -9F, 16F);

        body[14].addShapeBox(0F, 0F, 0F, 2, 5, 2, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 14
        body[14].setRotationPoint(-25F, -9F, 16F);

        body[15].addShapeBox(0F, 0F, 0F, 2, 1, 2, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 15
        body[15].setRotationPoint(-26F, -10F, 16F);

        body[16].addShapeBox(0F, 0F, 0F, 13, 1, 2, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 16
        body[16].setRotationPoint(-38F, -11F, 16F);

        body[17].addShapeBox(0F, 0F, 0F, 2, 1, 2, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 17
        body[17].setRotationPoint(-39F, -10F, 16F);

        body[18].addShapeBox(0F, 0F, 0F, 2, 5, 2, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 18
        body[18].setRotationPoint(-25F, -9F, -18F);

        body[19].addShapeBox(0F, 0F, 0F, 2, 1, 2, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 19
        body[19].setRotationPoint(-26F, -10F, -18F);

        body[20].addShapeBox(0F, 0F, 0F, 13, 1, 2, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 20
        body[20].setRotationPoint(-38F, -11F, -18F);

        body[21].addShapeBox(0F, 0F, 0F, 2, 1, 2, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 21
        body[21].setRotationPoint(-39F, -10F, -18F);

        body[22].addShapeBox(0F, 0F, 0F, 2, 5, 2, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 22
        body[22].setRotationPoint(-40F, -9F, -18F);

        body[23].addShapeBox(0F, 0F, 0F, 6, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.9F, 0F, 0F, -0.9F, 0F, 0F, 0F, 0F, 0F); // Box 23
        body[23].setRotationPoint(-44F, -4F, 16F);

        body[24].addShapeBox(0F, 0F, 0F, 6, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.9F, 0F, 0F, -0.9F, 0F, 0F, 0F, 0F, 0F); // Box 24
        body[24].setRotationPoint(-44F, -4F, -18F);

        body[25].addShapeBox(0F, 0F, 0F, 2, 2, 32, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 25
        body[25].setRotationPoint(-47F, -4F, -16F);

        body[26].addShapeBox(0F, 0F, 0F, 3, 2, 2, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 26
        body[26].setRotationPoint(-47F, -4F, -18F);

        body[27].addShapeBox(0F, 0F, 0F, 3, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -1F); // Box 27
        body[27].setRotationPoint(-47F, -4F, 16F);

        body[28].addBox(0F, 0F, 0F, 2, 1, 32, 0F); // Box 28
        body[28].setRotationPoint(-47F, -5F, -16F);

        body[29].addShapeBox(0F, 0F, 0F, 3, 1, 2, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 29
        body[29].setRotationPoint(-47F, -5F, -18F);

        body[30].addShapeBox(0F, 0F, 0F, 3, 1, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F); // Box 30
        body[30].setRotationPoint(-47F, -5F, 16F);

        body[31].addShapeBox(0F, 0F, 0F, 5, 1, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.9F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.9F, 0F, 0F); // Box 31
        body[31].setRotationPoint(38F, -4F, 16F);

        body[32].addShapeBox(0F, 0F, 0F, 3, 1, 2, 0F, 0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 32
        body[32].setRotationPoint(40F, -5F, 16F);

        body[33].addShapeBox(0F, 0F, 0F, 5, 1, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.9F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.9F, 0F, 0F); // Box 33
        body[33].setRotationPoint(38F, -4F, -18F);

        body[34].addShapeBox(0F, 0F, 0F, 3, 1, 2, 0F, 0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 34
        body[34].setRotationPoint(40F, -5F, -18F);

        body[35].addShapeBox(0F, 0F, 0F, 3, 2, 32, 0F, 0F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.9F, 0F, 0F, -0.9F, 0F, 0F, 0F, 0F, 0F); // Box 35
        body[35].setRotationPoint(43F, -5F, -16F);

        body[36].addShapeBox(0F, 0F, 0F, 3, 2, 2, 0F, 0F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, -0.9F, 0F, 0F, -0.9F, 0F, -1F, 0F, 0F, 0F); // Box 36
        body[36].setRotationPoint(43F, -5F, 16F);

        body[37].addShapeBox(0F, 0F, 0F, 3, 2, 2, 0F, 0F, 0F, 0F, 0.1F, 0F, -1F, 0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.9F, 0F, -1F, -0.9F, 0F, 0F, 0F, 0F, 0F); // Box 37
        body[37].setRotationPoint(43F, -5F, -18F);

        body[38].addBox(0F, 0F, 0F, 6, 1, 32, 0F); // Box 38
        body[38].setRotationPoint(-45F, -3F, -16F);

        body[39].addBox(0F, 0F, 0F, 4, 1, 32, 0F); // Box 39
        body[39].setRotationPoint(39F, -4F, -16F);

        body[40].addBox(0F, 0F, 0F, 15, 1, 24, 0F); // Box 40
        body[40].setRotationPoint(-39F, -3F, -12F);

        body[41].addShapeBox(0F, 0F, 0F, 15, 2, 20, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 41
        body[41].setRotationPoint(24F, -4F, -10F);

        body[42].addShapeBox(0F, 0F, 0F, 5, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 42
        body[42].setRotationPoint(17F, -7F, 17.5F);

        body[43].addShapeBox(0F, 0F, 0F, 5, 2, 1, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 43
        body[43].setRotationPoint(17F, -7F, -18.5F);

        body[44].addShapeBox(0F, 0F, 0F, 3, 2, 32, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0F, 0F, 0F); // Box 60
        body[44].setRotationPoint(43F, -7F, -16F);

        body[45].addShapeBox(0F, 0F, 0F, 3, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, -1F, 0F, 0F, 0F); // Box 61
        body[45].setRotationPoint(43F, -7F, 16F);

        body[46].addShapeBox(0F, 0F, 0F, 3, 2, 2, 0F, 0F, 0F, -0.25F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, -1F, 0.1F, 0F, 0F, 0F, 0F, 0F); // Box 66
        body[46].setRotationPoint(43F, -7F, -18F);

        body[47].addShapeBox(0F, 0F, 0F, 3, 1, 4, 0F, 0F, -0.8F, 0F, -0.2F, -0.8F, 0F, -0.2F, -0.8F, -1.2F, 0F, -0.8F, -0.4F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, -1.2F, 0F, 0F, -0.4F); // Box 72
        body[47].setRotationPoint(43F, -8F, 14F);

        body[48].addShapeBox(0F, 0F, 0F, 3, 1, 4, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, -1.7F, 0F, 0F, -0.9F, 0F, -0.8F, 0F, -0.2F, -0.8F, 0F, -0.2F, -0.8F, -1.7F, 0F, -0.8F, -0.9F); // Box 73
        body[48].setRotationPoint(43F, -12F, 14F);

        body[49].addShapeBox(0F, 0F, 0F, 3, 1, 4, 0F, 0F, -0.8F, 0F, -0.2F, -0.8F, 0F, -0.2F, -0.8F, -1.45F, 0F, -0.8F, -0.65F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, -1.45F, 0F, 0F, -0.65F); // Box 74
        body[49].setRotationPoint(43F, -10F, 14F);

        body[50].addShapeBox(0F, 0F, 0F, 3, 3, 3, 0F, 0F, -0.2F, 0F, -0.3F, -0.2F, 0F, -0.3F, -0.2F, -0.8F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, -0.3F, -0.2F, 0F, -0.3F, -0.2F, -0.55F, 0F, -0.2F, 0.25F); // Box 75
        body[50].setRotationPoint(43F, -12F, 14F);

        body[51].addShapeBox(0F, 0F, 0F, 3, 2, 3, 0F, 0F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, -0.55F, 0F, 0F, 0.25F, 0F, -0.2F, 0F, -0.3F, -0.2F, 0F, -0.3F, -0.2F, -0.3F, 0F, -0.2F, 0.5F); // Box 76
        body[51].setRotationPoint(43F, -9F, 14F);

        body[52].addShapeBox(0F, 0F, 0F, 3, 1, 4, 0F, 0F, -0.8F, -0.4F, -0.2F, -0.8F, -1.2F, -0.2F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, -0.4F, -0.2F, 0F, -1.2F, -0.2F, 0F, 0F, 0F, 0F, 0F); // Box 79
        body[52].setRotationPoint(43F, -8F, -18F);

        body[53].addShapeBox(0F, 0F, 0F, 3, 2, 3, 0F, 0F, 0F, 0.25F, -0.3F, 0F, -0.55F, -0.3F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0.5F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, 0F, 0F, -0.2F, 0F); // Box 80
        body[53].setRotationPoint(43F, -9F, -17F);

        body[54].addShapeBox(0F, 0F, 0F, 3, 1, 4, 0F, 0F, -0.8F, -0.65F, -0.2F, -0.8F, -1.45F, -0.2F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, -0.65F, -0.2F, 0F, -1.45F, -0.2F, 0F, 0F, 0F, 0F, 0F); // Box 81
        body[54].setRotationPoint(43F, -10F, -18F);

        body[55].addShapeBox(0F, 0F, 0F, 3, 1, 4, 0F, 0F, 0F, -0.9F, -0.2F, 0F, -1.7F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, -0.9F, -0.2F, -0.8F, -1.7F, -0.2F, -0.8F, 0F, 0F, -0.8F, 0F); // Box 82
        body[55].setRotationPoint(43F, -12F, -18F);

        body[56].addShapeBox(0F, 0F, 0F, 3, 3, 3, 0F, 0F, -0.2F, 0F, -0.3F, -0.2F, -0.8F, -0.3F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0.25F, -0.3F, -0.2F, -0.55F, -0.3F, -0.2F, 0F, 0F, -0.2F, 0F); // Box 83
        body[56].setRotationPoint(43F, -12F, -17F);

        body[57].addShapeBox(0F, 0F, 0F, 1, 1, 6, 0F, 0F, -0.2F, 0F, -0.8F, -0.2F, 0F, -0.8F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, -0.8F, -0.2F, 0F, -0.8F, -0.2F, 0F, 0F, -0.2F, 0F); // Box 84
        body[57].setRotationPoint(46.1F, -8.5F, -3F);

        body[58].addShapeBox(0F, 0F, 0F, 1, 1, 6, 0F, 0F, -0.2F, 0F, -0.8F, -0.2F, 0F, -0.8F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, -0.8F, -0.2F, 0F, -0.8F, -0.2F, 0F, 0F, -0.2F, 0F); // Box 85
        body[58].setRotationPoint(46.1F, -10F, -3F);

        body[59].addShapeBox(0F, 0F, 0F, 1, 1, 6, 0F, 0F, -0.2F, 0F, -0.8F, -0.2F, 0F, -0.8F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, -0.8F, -0.2F, 0F, -0.8F, -0.2F, 0F, 0F, -0.2F, 0F); // Box 86
        body[59].setRotationPoint(46.1F, -11.5F, -3F);

        body[60].addShapeBox(0F, 0F, 0F, 1, 1, 11, 0F, 0F, -0.2F, 0F, -0.8F, -0.2F, 0F, -1.1F, -0.2F, -0.5F, 0.3F, -0.2F, -0.5F, 0F, -0.2F, 0F, -0.8F, -0.2F, 0F, -1.1F, -0.2F, -0.5F, 0.3F, -0.2F, -0.5F); // Box 87
        body[60].setRotationPoint(46.1F, -11.5F, 3F);

        body[61].addShapeBox(0F, 0F, 0F, 1, 1, 11, 0F, 0F, -0.2F, 0F, -0.8F, -0.2F, 0F, -1.1F, -0.2F, -0.5F, 0.3F, -0.2F, -0.5F, 0F, -0.2F, 0F, -0.8F, -0.2F, 0F, -1.1F, -0.2F, -0.5F, 0.3F, -0.2F, -0.5F); // Box 88
        body[61].setRotationPoint(46.1F, -10F, 3F);

        body[62].addShapeBox(0F, 0F, 0F, 1, 1, 11, 0F, 0F, -0.2F, 0F, -0.8F, -0.2F, 0F, -1.1F, -0.2F, -0.5F, 0.3F, -0.2F, -0.5F, 0F, -0.2F, 0F, -0.8F, -0.2F, 0F, -1.1F, -0.2F, -0.5F, 0.3F, -0.2F, -0.5F); // Box 89
        body[62].setRotationPoint(46.1F, -8.5F, 3F);

        body[63].addShapeBox(0F, 0F, 0F, 1, 1, 11, 0F, 0.3F, -0.2F, -0.5F, -1.1F, -0.2F, -0.5F, -0.8F, -0.2F, 0F, 0F, -0.2F, 0F, 0.3F, -0.2F, -0.5F, -1.1F, -0.2F, -0.5F, -0.8F, -0.2F, 0F, 0F, -0.2F, 0F); // Box 90
        body[63].setRotationPoint(46.1F, -11.5F, -14F);

        body[64].addShapeBox(0F, 0F, 0F, 1, 1, 11, 0F, 0.3F, -0.2F, -0.5F, -1.1F, -0.2F, -0.5F, -0.8F, -0.2F, 0F, 0F, -0.2F, 0F, 0.3F, -0.2F, -0.5F, -1.1F, -0.2F, -0.5F, -0.8F, -0.2F, 0F, 0F, -0.2F, 0F); // Box 91
        body[64].setRotationPoint(46.1F, -10F, -14F);

        body[65].addShapeBox(0F, 0F, 0F, 1, 1, 11, 0F, 0.3F, -0.2F, -0.5F, -1.1F, -0.2F, -0.5F, -0.8F, -0.2F, 0F, 0F, -0.2F, 0F, 0.3F, -0.2F, -0.5F, -1.1F, -0.2F, -0.5F, -0.8F, -0.2F, 0F, 0F, -0.2F, 0F); // Box 92
        body[65].setRotationPoint(46.1F, -8.5F, -14F);

        body[66].addShapeBox(0F, 0F, 0F, 1, 5, 1, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F); // Box 99
        body[66].setRotationPoint(45F, -12F, -4F);

        body[67].addShapeBox(0F, 0F, 0F, 1, 5, 1, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F); // Box 100
        body[67].setRotationPoint(45F, -12F, 2F);

        body[68].addShapeBox(0F, 0F, 0F, 2, 4, 2, 0F, 0.1F, 0F, -1.3F, 0F, 0F, -0.65F, 0F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, -1.1F, 0F, 0F, -0.3F, 0F, 0F, 0F, 0.1F, 0F, 0F); // Box 106
        body[68].setRotationPoint(-46F, -12F, -18F);

        body[69].addShapeBox(0F, 0F, 0F, 2, 4, 2, 0F, 0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.65F, 0.1F, 0F, -1.3F, 0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, 0.1F, 0F, -1.1F); // Box 107
        body[69].setRotationPoint(-46F, -12F, 16F);

        body[70].addBox(0F, 0F, 0F, 2, 2, 30, 0F); // Box 108
        body[70].setRotationPoint(30.5F, -4.5F, -15F);

        body[71].addBox(0F, 0F, 0F, 2, 2, 30, 0F); // Box 109
        body[71].setRotationPoint(-32.5F, -4.5F, -15F);

        body[72].addShapeBox(0F, 0F, 0F, 2, 12, 1, 0F, 8F, 0F, 1F, -8F, 0F, 1F, -8F, 0F, -1F, 8F, 0F, -1F, 4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 4F, 0F, 0.5F); // Box 121
        body[72].setRotationPoint(20F, -26F, 15F);

        body[73].addShapeBox(0F, 0F, 0F, 2, 12, 1, 0F, 8F, 0F, -1F, -8F, 0F, -1F, -8F, 0F, 1F, 8F, 0F, 1F, 4F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 4F, 0F, 0F); // Box 123
        body[73].setRotationPoint(20F, -26F, -16F);

        body[74].addShapeBox(0F, 0F, 0F, 2, 11, 1, 0F, -4F, 0F, 1F, 4F, 0F, 1F, 4F, 0F, -1F, -4F, 0F, -1F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0.5F, 0F, 0.5F); // Box 124
        body[74].setRotationPoint(-45F, -26F, 15F);

        body[75].addShapeBox(0F, 0F, 0F, 2, 11, 1, 0F, -4F, 0F, -1F, 4F, 0F, -1F, 4F, 0F, 1F, -4F, 0F, 1F, 0.5F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0.5F, 0F, 0F); // Box 125
        body[75].setRotationPoint(-45F, -26F, -16F);

        body[76].addShapeBox(0F, 0F, 0F, 2, 11, 1, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F); // Box 131
        body[76].setRotationPoint(-24F, -26F, 15F);

        body[77].addShapeBox(0F, 0F, 0F, 2, 11, 1, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 132
        body[77].setRotationPoint(-24F, -26F, -16F);

        body[78].addShapeBox(0F, 0F, 0F, 5, 4, 32, 0F, 1F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 1F, 0F, 0F, 0F, 0F, 1F, 0F, 1F, 1F, 0F, 1F, 1F, 0F, 0F, 1F); // Box 133
        body[78].setRotationPoint(17F, -15F, -16F);

        body[79].addShapeBox(0F, 0F, 0F, 1, 8, 34, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F); // Box 135
        body[79].setRotationPoint(21F, -11F, -17F);

        body[80].addShapeBox(0F, 0F, 0F, 1, 2, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.9F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.9F, 0F, 0F); // Box 138
        body[80].setRotationPoint(-25F, -4F, 12F);

        body[81].addShapeBox(0F, 0F, 0F, 1, 2, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.9F, 0F, 0F, -0.9F, 0F, 0F, 0F, 0F, 0F); // Box 139
        body[81].setRotationPoint(-39F, -4F, 12F);

        body[82].addShapeBox(0F, 0F, 0F, 1, 2, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.9F, 0F, 0F, -0.9F, 0F, 0F, 0F, 0F, 0F); // Box 140
        body[82].setRotationPoint(-39F, -4F, -16F);

        body[83].addShapeBox(0F, 0F, 0F, 1, 2, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.9F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.9F, 0F, 0F); // Box 141
        body[83].setRotationPoint(-25F, -4F, -16F);

        body[84].addShapeBox(0F, 0F, 0F, 1, 2, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.9F, 0F, 0F, -0.9F, 0F, 0F, 0F, 0F, 0F); // Box 142
        body[84].setRotationPoint(24F, -4F, -16F);

        body[85].addShapeBox(0F, 0F, 0F, 1, 2, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.9F, 0F, 0F, -0.9F, 0F, 0F, 0F, 0F, 0F); // Box 143
        body[85].setRotationPoint(24F, -4F, 10F);

        body[86].addShapeBox(0F, 0F, 0F, 1, 1, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.9F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.9F, 0F, 0F); // Box 144
        body[86].setRotationPoint(38F, -4F, 10F);

        body[87].addShapeBox(0F, 0F, 0F, 1, 1, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.9F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.9F, 0F, 0F); // Box 145
        body[87].setRotationPoint(38F, -4F, -16F);

        body[88].addShapeBox(0F, 0F, 0F, 6, 2, 34, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 156
        body[88].setRotationPoint(-45F, -5F, -17F);

        body[89].addShapeBox(0F, 0F, 0F, 8, 1, 24, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 157
        body[89].setRotationPoint(-39F, -4F, -12F);

        body[90].addShapeBox(0F, 0F, 0F, 7, 1, 24, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 158
        body[90].setRotationPoint(-31F, -4F, -12F);

        body[91].addShapeBox(0F, 0F, 0F, 3, 11, 1, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 241
        body[91].setRotationPoint(-4F, -26F, -16F);

        body[92].addShapeBox(0F, 0F, 0F, 3, 11, 1, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F); // Box 242
        body[92].setRotationPoint(-4F, -26F, 15F);

        body[93].addBox(0F, 0F, 0F, 1, 1, 34, 0F); // Box 245
        body[93].setRotationPoint(23F, -4F, -17F);

        //
        body_colored_primary = new ModelRendererTurbo[78];
        body_colored_primary[0] = new ModelRendererTurbo(this, 177, 17, textureX, textureY); // Box 44
        body_colored_primary[1] = new ModelRendererTurbo(this, 209, 17, textureX, textureY); // Box 45
        body_colored_primary[2] = new ModelRendererTurbo(this, 257, 17, textureX, textureY); // Box 46
        body_colored_primary[3] = new ModelRendererTurbo(this, 273, 17, textureX, textureY); // Box 47
        body_colored_primary[4] = new ModelRendererTurbo(this, 305, 17, textureX, textureY); // Box 48
        body_colored_primary[5] = new ModelRendererTurbo(this, 337, 17, textureX, textureY); // Box 49
        body_colored_primary[6] = new ModelRendererTurbo(this, 369, 17, textureX, textureY); // Box 50
        body_colored_primary[7] = new ModelRendererTurbo(this, 385, 17, textureX, textureY); // Box 51
        body_colored_primary[8] = new ModelRendererTurbo(this, 1, 25, textureX, textureY); // Box 52
        body_colored_primary[9] = new ModelRendererTurbo(this, 137, 25, textureX, textureY); // Box 53
        body_colored_primary[10] = new ModelRendererTurbo(this, 177, 25, textureX, textureY); // Box 54
        body_colored_primary[11] = new ModelRendererTurbo(this, 305, 25, textureX, textureY); // Box 55
        body_colored_primary[12] = new ModelRendererTurbo(this, 385, 25, textureX, textureY); // Box 56
        body_colored_primary[13] = new ModelRendererTurbo(this, 177, 33, textureX, textureY); // Box 57
        body_colored_primary[14] = new ModelRendererTurbo(this, 497, 17, textureX, textureY); // Box 63
        body_colored_primary[15] = new ModelRendererTurbo(this, 273, 25, textureX, textureY); // Box 64
        body_colored_primary[16] = new ModelRendererTurbo(this, 409, 25, textureX, textureY); // Box 65
        body_colored_primary[17] = new ModelRendererTurbo(this, 441, 25, textureX, textureY); // Box 66
        body_colored_primary[18] = new ModelRendererTurbo(this, 497, 25, textureX, textureY); // Box 69
        body_colored_primary[19] = new ModelRendererTurbo(this, 201, 33, textureX, textureY); // Box 70
        body_colored_primary[20] = new ModelRendererTurbo(this, 353, 49, textureX, textureY); // Box 71
        body_colored_primary[21] = new ModelRendererTurbo(this, 257, 33, textureX, textureY); // Box 77
        body_colored_primary[22] = new ModelRendererTurbo(this, 273, 33, textureX, textureY); // Box 78
        body_colored_primary[23] = new ModelRendererTurbo(this, 1, 41, textureX, textureY); // Box 93
        body_colored_primary[24] = new ModelRendererTurbo(this, 121, 41, textureX, textureY); // Box 95
        body_colored_primary[25] = new ModelRendererTurbo(this, 233, 17, textureX, textureY); // Box 97
        body_colored_primary[26] = new ModelRendererTurbo(this, 353, 33, textureX, textureY); // Box 98
        body_colored_primary[27] = new ModelRendererTurbo(this, 361, 49, textureX, textureY); // Box 99
        body_colored_primary[28] = new ModelRendererTurbo(this, 393, 49, textureX, textureY); // Box 100
        body_colored_primary[29] = new ModelRendererTurbo(this, 137, 41, textureX, textureY); // Box 101
        body_colored_primary[30] = new ModelRendererTurbo(this, 177, 41, textureX, textureY); // Box 102
        body_colored_primary[31] = new ModelRendererTurbo(this, 417, 49, textureX, textureY); // Box 103
        body_colored_primary[32] = new ModelRendererTurbo(this, 433, 49, textureX, textureY); // Box 104
        body_colored_primary[33] = new ModelRendererTurbo(this, 449, 49, textureX, textureY); // Box 105
        body_colored_primary[34] = new ModelRendererTurbo(this, 249, 65, textureX, textureY); // Box 126
        body_colored_primary[35] = new ModelRendererTurbo(this, 401, 65, textureX, textureY); // Box 127
        body_colored_primary[36] = new ModelRendererTurbo(this, 1, 89, textureX, textureY); // Box 128
        body_colored_primary[37] = new ModelRendererTurbo(this, 257, 65, textureX, textureY); // Box 129
        body_colored_primary[38] = new ModelRendererTurbo(this, 289, 65, textureX, textureY); // Box 130
        body_colored_primary[39] = new ModelRendererTurbo(this, 441, 33, textureX, textureY); // Box 136
        body_colored_primary[40] = new ModelRendererTurbo(this, 497, 33, textureX, textureY); // Box 137
        body_colored_primary[41] = new ModelRendererTurbo(this, 305, 41, textureX, textureY); // Box 146
        body_colored_primary[42] = new ModelRendererTurbo(this, 481, 41, textureX, textureY); // Box 147
        body_colored_primary[43] = new ModelRendererTurbo(this, 9, 73, textureX, textureY); // Box 148
        body_colored_primary[44] = new ModelRendererTurbo(this, 25, 73, textureX, textureY); // Box 149
        body_colored_primary[45] = new ModelRendererTurbo(this, 409, 9, textureX, textureY); // Box 150
        body_colored_primary[46] = new ModelRendererTurbo(this, 465, 9, textureX, textureY); // Box 151
        body_colored_primary[47] = new ModelRendererTurbo(this, 449, 25, textureX, textureY); // Box 152
        body_colored_primary[48] = new ModelRendererTurbo(this, 321, 41, textureX, textureY); // Box 153
        body_colored_primary[49] = new ModelRendererTurbo(this, 441, 65, textureX, textureY); // Box 154
        body_colored_primary[50] = new ModelRendererTurbo(this, 41, 73, textureX, textureY); // Box 155
        body_colored_primary[51] = new ModelRendererTurbo(this, 73, 73, textureX, textureY); // Box 159
        body_colored_primary[52] = new ModelRendererTurbo(this, 393, 73, textureX, textureY); // Box 160
        body_colored_primary[53] = new ModelRendererTurbo(this, 209, 73, textureX, textureY); // Box 161
        body_colored_primary[54] = new ModelRendererTurbo(this, 41, 81, textureX, textureY); // Box 162
        body_colored_primary[55] = new ModelRendererTurbo(this, 177, 73, textureX, textureY); // Box 163
        body_colored_primary[56] = new ModelRendererTurbo(this, 289, 81, textureX, textureY); // Box 164
        body_colored_primary[57] = new ModelRendererTurbo(this, 57, 57, textureX, textureY); // Box 165
        body_colored_primary[58] = new ModelRendererTurbo(this, 113, 73, textureX, textureY); // Box 166
        body_colored_primary[59] = new ModelRendererTurbo(this, 65, 81, textureX, textureY); // Box 167
        body_colored_primary[60] = new ModelRendererTurbo(this, 337, 89, textureX, textureY); // Box 168
        body_colored_primary[61] = new ModelRendererTurbo(this, 209, 81, textureX, textureY); // Box 169
        body_colored_primary[62] = new ModelRendererTurbo(this, 305, 81, textureX, textureY); // Box 170
        body_colored_primary[63] = new ModelRendererTurbo(this, 441, 81, textureX, textureY); // Box 171
        body_colored_primary[64] = new ModelRendererTurbo(this, 145, 73, textureX, textureY); // Box 172
        body_colored_primary[65] = new ModelRendererTurbo(this, 337, 81, textureX, textureY); // Box 173
        body_colored_primary[66] = new ModelRendererTurbo(this, 385, 89, textureX, textureY); // Box 174
        body_colored_primary[67] = new ModelRendererTurbo(this, 249, 81, textureX, textureY); // Box 175
        body_colored_primary[68] = new ModelRendererTurbo(this, 137, 97, textureX, textureY); // Box 176
        body_colored_primary[69] = new ModelRendererTurbo(this, 457, 81, textureX, textureY); // Box 177
        body_colored_primary[70] = new ModelRendererTurbo(this, 489, 81, textureX, textureY); // Box 178
        body_colored_primary[71] = new ModelRendererTurbo(this, 201, 25, textureX, textureY); // Box 179
        body_colored_primary[72] = new ModelRendererTurbo(this, 401, 33, textureX, textureY); // Box 180
        body_colored_primary[73] = new ModelRendererTurbo(this, 417, 33, textureX, textureY); // Box 181
        body_colored_primary[74] = new ModelRendererTurbo(this, 225, 41, textureX, textureY); // Box 182
        body_colored_primary[75] = new ModelRendererTurbo(this, 193, 73, textureX, textureY); // Box 238
        body_colored_primary[76] = new ModelRendererTurbo(this, 345, 137, textureX, textureY); // Box 239
        body_colored_primary[77] = new ModelRendererTurbo(this, 361, 137, textureX, textureY); // Box 240

        body_colored_primary[0].addShapeBox(0F, 0F, 0F, 11, 2, 3, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -1.5F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 44
        body_colored_primary[0].setRotationPoint(32F, -15F, 13F);

        body_colored_primary[1].addShapeBox(0F, 0F, 0F, 9, 9, 1, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 45
        body_colored_primary[1].setRotationPoint(16F, -13F, 17F);

        body_colored_primary[2].addShapeBox(0F, 0F, 0F, 5, 9, 1, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 46
        body_colored_primary[2].setRotationPoint(38F, -13F, 17F);

        body_colored_primary[3].addShapeBox(0F, 0F, 0F, 13, 3, 1, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, -0.65F, 0F, 0F, -0.65F); // Box 47
        body_colored_primary[3].setRotationPoint(25F, -13F, 17F);

        body_colored_primary[4].addShapeBox(0F, 0F, 0F, 11, 1, 1, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.9F, 0F, 0F, -0.9F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 48
        body_colored_primary[4].setRotationPoint(32F, -14F, 16F);

        body_colored_primary[5].addShapeBox(0F, 0F, 0F, 9, 9, 1, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 49
        body_colored_primary[5].setRotationPoint(16F, -13F, -18F);

        body_colored_primary[6].addShapeBox(0F, 0F, 0F, 5, 9, 1, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 50
        body_colored_primary[6].setRotationPoint(38F, -13F, -18F);

        body_colored_primary[7].addShapeBox(0F, 0F, 0F, 13, 3, 1, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -0.65F, 0F, 0F, -0.65F, 0F, 0F, 0.5F, 0F, 0F, 0.5F); // Box 51
        body_colored_primary[7].setRotationPoint(25F, -13F, -18F);

        body_colored_primary[8].addShapeBox(0F, 0F, 0F, 11, 1, 1, 0F, 0F, -0.9F, 0F, 0F, -0.9F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 52
        body_colored_primary[8].setRotationPoint(32F, -14F, -17F);

        body_colored_primary[9].addShapeBox(0F, 0F, 0F, 11, 2, 3, 0F, 0F, -1F, 0F, 0F, -1.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 53
        body_colored_primary[9].setRotationPoint(32F, -15F, -16F);

        body_colored_primary[10].addShapeBox(0F, 0F, 0F, 10, 2, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 54
        body_colored_primary[10].setRotationPoint(22F, -15F, 13F);

        body_colored_primary[11].addShapeBox(0F, 0F, 0F, 10, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.9F, 0F, 0F, -0.9F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 55
        body_colored_primary[11].setRotationPoint(22F, -14F, 16F);

        body_colored_primary[12].addShapeBox(0F, 0F, 0F, 10, 1, 1, 0F, 0F, -0.9F, 0F, 0F, -0.9F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 56
        body_colored_primary[12].setRotationPoint(22F, -14F, -17F);

        body_colored_primary[13].addShapeBox(0F, 0F, 0F, 10, 2, 3, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 57
        body_colored_primary[13].setRotationPoint(22F, -15F, -16F);

        body_colored_primary[14].addShapeBox(0F, 0F, 0F, 3, 1, 3, 0F, 0F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0F, 0F, 0F); // Box 63
        body_colored_primary[14].setRotationPoint(43F, -14F, -16F);

        body_colored_primary[15].addShapeBox(0F, 0F, 0F, 3, 1, 3, 0F, 0F, 0.5F, 0F, -0.5F, 0F, 0F, -0.5F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0F, 0F, 0F); // Box 64
        body_colored_primary[15].setRotationPoint(43F, -14F, 13F);

        body_colored_primary[16].addShapeBox(0F, 0F, 0F, 3, 1, 1, 0F, 0F, -0.9F, 0F, 0F, -0.9F, -0.6F, -0.5F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0.1F, 0F, -0.6F, 0.1F, 0F, 0F, 0F, 0F, 0F); // Box 65
        body_colored_primary[16].setRotationPoint(43F, -14F, -17F);

        body_colored_primary[17].addShapeBox(0F, 0F, 0F, 3, 1, 1, 0F, 0F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, -0.9F, -0.6F, 0F, -0.9F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, -0.6F, 0F, 0F, 0F); // Box 66
        body_colored_primary[17].setRotationPoint(43F, -14F, 16F);

        body_colored_primary[18].addShapeBox(0F, 0F, 0F, 3, 1, 1, 0F, 0F, 0F, 0F, 0.1F, 0F, -0.6F, 0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.11F, 0.1F, 0F, -0.6F, 0.1F, 0F, 0F, 0F, 0F, 0F); // Box 69
        body_colored_primary[18].setRotationPoint(43F, -13F, -17F);

        body_colored_primary[19].addShapeBox(0F, 0F, 0F, 3, 1, 1, 0F, 0F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, -0.6F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, -0.6F, 0F, 0F, 0.11F); // Box 70
        body_colored_primary[19].setRotationPoint(43F, -13F, 16F);

        body_colored_primary[20].addShapeBox(0F, 0F, 0F, 3, 1, 32, 0F, 0F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0F, 0F, 0F); // Box 71
        body_colored_primary[20].setRotationPoint(43F, -13F, -16F);

        body_colored_primary[21].addBox(0F, 0F, 0F, 3, 5, 1, 0F); // Box 77
        body_colored_primary[21].setRotationPoint(43F, -12F, 13F);

        body_colored_primary[22].addBox(0F, 0F, 0F, 3, 5, 1, 0F); // Box 78
        body_colored_primary[22].setRotationPoint(43F, -12F, -14F);

        body_colored_primary[23].addShapeBox(0F, 0F, 0F, 3, 5, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F, 0F, 0F, 0F, 0F, 0F); // Box 93
        body_colored_primary[23].setRotationPoint(43F, -12F, -13F);

        body_colored_primary[24].addShapeBox(0F, 0F, 0F, 3, 5, 3, 0F, 0F, 0F, 0F, -1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 95
        body_colored_primary[24].setRotationPoint(43F, -12F, 10F);

        body_colored_primary[25].addShapeBox(0F, 0F, 0F, 1, 5, 1, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F); // Box 97
        body_colored_primary[25].setRotationPoint(43F, -12F, -10F);

        body_colored_primary[26].addShapeBox(0F, 0F, 0F, 1, 5, 1, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F); // Box 98
        body_colored_primary[26].setRotationPoint(43F, -12F, 9F);

        body_colored_primary[27].addShapeBox(0F, 0F, 0F, 6, 11, 2, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 99
        body_colored_primary[27].setRotationPoint(-44F, -15F, 16F);

        body_colored_primary[28].addShapeBox(0F, 0F, 0F, 6, 11, 2, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 100
        body_colored_primary[28].setRotationPoint(-44F, -15F, -18F);

        body_colored_primary[29].addShapeBox(0F, 0F, 0F, 13, 5, 2, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0.55F, 0F, 0F, 0.55F, 0F, 0F, -0.55F, 0F, 0F, -0.55F); // Box 101
        body_colored_primary[29].setRotationPoint(-38F, -15F, 16F);

        body_colored_primary[30].addShapeBox(0F, 0F, 0F, 13, 5, 2, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -0.55F, 0F, 0F, -0.55F, 0F, 0F, 0.55F, 0F, 0F, 0.55F); // Box 102
        body_colored_primary[30].setRotationPoint(-38F, -15F, -18F);

        body_colored_primary[31].addBox(0F, 0F, 0F, 2, 11, 2, 0F); // Box 103
        body_colored_primary[31].setRotationPoint(-46F, -15F, -16F);

        body_colored_primary[32].addShapeBox(0F, 0F, 0F, 2, 10, 2, 0F, 0F, 0F, -1.5F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 104
        body_colored_primary[32].setRotationPoint(-46F, -15F, -18F);

        body_colored_primary[33].addShapeBox(0F, 0F, 0F, 2, 10, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.1F, 0F, 0F, -1F); // Box 105
        body_colored_primary[33].setRotationPoint(-46F, -15F, 16F);

        body_colored_primary[34].addShapeBox(0F, 0F, 0F, 3, 1, 31, 0F, 0F, 0F, 0F, -1F, 0F, -1F, -1F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 126
        body_colored_primary[34].setRotationPoint(11.5F, -27F, -15.5F);

        body_colored_primary[35].addShapeBox(0F, 0F, 0F, 3, 1, 31, 0F, -1F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 127
        body_colored_primary[35].setRotationPoint(-41.5F, -27F, -15.5F);

        body_colored_primary[36].addBox(0F, 0F, 0F, 50, 1, 31, 0F); // Box 128
        body_colored_primary[36].setRotationPoint(-38.5F, -27F, -15.5F);

        body_colored_primary[37].addShapeBox(0F, 0F, 0F, 4, 11, 1, 0F, 0F, 0F, 1F, -1F, 0F, 1F, -1F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 129
        body_colored_primary[37].setRotationPoint(-25F, -15F, 17F);

        body_colored_primary[38].addShapeBox(0F, 0F, 0F, 4, 11, 1, 0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 130
        body_colored_primary[38].setRotationPoint(-25F, -15F, -18F);

        body_colored_primary[39].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, -0.9F, 0F, 0F, -0.9F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 136
        body_colored_primary[39].setRotationPoint(16F, -14F, 16F);

        body_colored_primary[40].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, 0F, -0.9F, 0F, 0F, -0.9F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 137
        body_colored_primary[40].setRotationPoint(16F, -14F, -17F);

        body_colored_primary[41].addShapeBox(0F, 0F, 0F, 1, 5, 4, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 146
        body_colored_primary[41].setRotationPoint(-25F, -9F, 12F);

        body_colored_primary[42].addShapeBox(0F, 0F, 0F, 1, 5, 4, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 147
        body_colored_primary[42].setRotationPoint(-25F, -9F, -16F);

        body_colored_primary[43].addShapeBox(0F, 0F, 0F, 1, 5, 4, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 148
        body_colored_primary[43].setRotationPoint(-39F, -9F, -16F);

        body_colored_primary[44].addShapeBox(0F, 0F, 0F, 1, 5, 4, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 149
        body_colored_primary[44].setRotationPoint(-39F, -9F, 12F);

        body_colored_primary[45].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 150
        body_colored_primary[45].setRotationPoint(-26F, -10F, 12F);

        body_colored_primary[46].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 151
        body_colored_primary[46].setRotationPoint(-38F, -10F, 12F);

        body_colored_primary[47].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 152
        body_colored_primary[47].setRotationPoint(-26F, -10F, -16F);

        body_colored_primary[48].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 153
        body_colored_primary[48].setRotationPoint(-38F, -10F, -16F);

        body_colored_primary[49].addShapeBox(0F, 0F, 0F, 11, 1, 4, 0F, -1F, -0.5F, -1F, -1F, -0.5F, -1F, -1F, -0.5F, 0F, -1F, -0.5F, 0F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 154
        body_colored_primary[49].setRotationPoint(-37F, -11F, 12F);

        body_colored_primary[50].addShapeBox(0F, 0F, 0F, 11, 1, 4, 0F, -1F, -0.5F, 0F, -1F, -0.5F, 0F, -1F, -0.5F, -1F, -1F, -0.5F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0F, 0.1F); // Box 155
        body_colored_primary[50].setRotationPoint(-37F, -11F, -16F);

        body_colored_primary[51].addShapeBox(0F, 0F, 0F, 15, 5, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -0.5F, -1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 159
        body_colored_primary[51].setRotationPoint(-39F, -9F, -12F);

        body_colored_primary[52].addShapeBox(0F, 0F, 0F, 15, 5, 1, 0F, -1F, 0F, -0.5F, -1F, 0F, -0.5F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 160
        body_colored_primary[52].setRotationPoint(-39F, -9F, 11F);

        body_colored_primary[53].addShapeBox(0F, 0F, 0F, 13, 1, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -0.9F, -1F, 0F, -0.9F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 161
        body_colored_primary[53].setRotationPoint(-38F, -10F, -12F);

        body_colored_primary[54].addShapeBox(0F, 0F, 0F, 13, 1, 1, 0F, -1F, 0F, -0.9F, -1F, 0F, -0.9F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 162
        body_colored_primary[54].setRotationPoint(-38F, -10F, 11F);

        body_colored_primary[55].addShapeBox(0F, 0F, 0F, 1, 5, 6, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 163
        body_colored_primary[55].setRotationPoint(38F, -9F, -16F);

        body_colored_primary[56].addShapeBox(0F, 0F, 0F, 1, 5, 6, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 164
        body_colored_primary[56].setRotationPoint(24F, -9F, -16F);

        body_colored_primary[57].addShapeBox(0F, 0F, 0F, 1, 1, 6, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 165
        body_colored_primary[57].setRotationPoint(37F, -10F, -16F);

        body_colored_primary[58].addShapeBox(0F, 0F, 0F, 1, 1, 6, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 166
        body_colored_primary[58].setRotationPoint(25F, -10F, -16F);

        body_colored_primary[59].addShapeBox(0F, 0F, 0F, 11, 1, 6, 0F, -1F, -0.5F, 0F, -1F, -0.5F, 0F, -1F, -0.5F, -1F, -1F, -0.5F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0F, 0.1F); // Box 167
        body_colored_primary[59].setRotationPoint(26F, -11F, -16F);

        body_colored_primary[60].addShapeBox(0F, 0F, 0F, 15, 5, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -0.5F, -1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 168
        body_colored_primary[60].setRotationPoint(24F, -9F, -10F);

        body_colored_primary[61].addShapeBox(0F, 0F, 0F, 13, 1, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -0.9F, -1F, 0F, -0.9F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 169
        body_colored_primary[61].setRotationPoint(25F, -10F, -10F);

        body_colored_primary[62].addShapeBox(0F, 0F, 0F, 1, 5, 6, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 170
        body_colored_primary[62].setRotationPoint(38F, -9F, 10F);

        body_colored_primary[63].addShapeBox(0F, 0F, 0F, 1, 5, 6, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 171
        body_colored_primary[63].setRotationPoint(24F, -9F, 10F);

        body_colored_primary[64].addShapeBox(0F, 0F, 0F, 1, 1, 6, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 172
        body_colored_primary[64].setRotationPoint(37F, -10F, 10F);

        body_colored_primary[65].addShapeBox(0F, 0F, 0F, 1, 1, 6, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 173
        body_colored_primary[65].setRotationPoint(25F, -10F, 10F);

        body_colored_primary[66].addShapeBox(0F, 0F, 0F, 15, 5, 1, 0F, -1F, 0F, -0.5F, -1F, 0F, -0.5F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 174
        body_colored_primary[66].setRotationPoint(24F, -9F, 9F);

        body_colored_primary[67].addShapeBox(0F, 0F, 0F, 13, 1, 1, 0F, -1F, 0F, -0.9F, -1F, 0F, -0.9F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 175
        body_colored_primary[67].setRotationPoint(25F, -10F, 9F);

        body_colored_primary[68].addShapeBox(0F, 0F, 0F, 11, 1, 6, 0F, -1F, -0.5F, -1F, -1F, -0.5F, -1F, -1F, -0.5F, 0F, -1F, -0.5F, 0F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 176
        body_colored_primary[68].setRotationPoint(26F, -11F, 10F);

        body_colored_primary[69].addShapeBox(0F, 0F, 0F, 4, 11, 1, 0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 177
        body_colored_primary[69].setRotationPoint(-25F, -15F, -17F);

        body_colored_primary[70].addShapeBox(0F, 0F, 0F, 4, 11, 1, 0F, 0F, 0F, 1F, -1F, 0F, 1F, -1F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 178
        body_colored_primary[70].setRotationPoint(-25F, -15F, 16F);

        body_colored_primary[71].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 179
        body_colored_primary[71].setRotationPoint(-26F, -10F, 15.5F);

        body_colored_primary[72].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 180
        body_colored_primary[72].setRotationPoint(-38F, -10F, 15.5F);

        body_colored_primary[73].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 181
        body_colored_primary[73].setRotationPoint(-38F, -10F, -16.5F);

        body_colored_primary[74].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 182
        body_colored_primary[74].setRotationPoint(-26F, -10F, -16.5F);

        body_colored_primary[75].addBox(0F, 0F, 0F, 2, 11, 2, 0F); // Box 238
        body_colored_primary[75].setRotationPoint(-46F, -15F, 14F);

        body_colored_primary[76].addShapeBox(0F, 0F, 0F, 4, 11, 2, 0F, 0F, 0F, 1F, -1F, 0F, 1F, -1F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 239
        body_colored_primary[76].setRotationPoint(-4F, -15F, 16F);

        body_colored_primary[77].addShapeBox(0F, 0F, 0F, 4, 11, 2, 0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 240
        body_colored_primary[77].setRotationPoint(-4F, -15F, -18F);
        flipAll();
    }

    @Override
    public void render(VehicleData data, Object obj){
        render(body);
        data.getPrimaryColor().glColorApply();
        render(body_colored_primary);
        data.getPrimaryColor();
        RGB.glColorReset();
    }

}
