//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2017 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+
// Model: T1_Type2
// Model Creator: FEX___96
// Created on: 13.03.2017 - 19:28:44
// Last changed on: 13.03.2017 - 19:28:44
package net.fexcraft.mod.addons.fvp.models.part;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.addons.fvp.scripts.T1_2Script;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.part.PartModelTMT;
import net.minecraft.entity.Entity;

public class ModelT1_2 extends PartModelTMT {

    private ModelRendererTurbo[] out, in;

    public ModelT1_2(){
    	super(); textureX = 512; textureY = 512;
        this.addToCreators("Ferdinand (FEX___96)");
        //
        body = new ModelRendererTurbo[79];
        body[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
        body[1] = new ModelRendererTurbo(this, 65, 1, textureX, textureY); // Box 1
        body[2] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 2
        body[3] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 3
        body[4] = new ModelRendererTurbo(this, 33, 1, textureX, textureY); // Box 4
        body[5] = new ModelRendererTurbo(this, 65, 1, textureX, textureY); // Box 5
        body[6] = new ModelRendererTurbo(this, 81, 1, textureX, textureY); // Box 6
        body[7] = new ModelRendererTurbo(this, 113, 1, textureX, textureY); // Box 7
        body[8] = new ModelRendererTurbo(this, 129, 1, textureX, textureY); // Box 8
        body[9] = new ModelRendererTurbo(this, 145, 1, textureX, textureY); // Box 9
        body[10] = new ModelRendererTurbo(this, 161, 1, textureX, textureY); // Box 10
        body[11] = new ModelRendererTurbo(this, 177, 1, textureX, textureY); // Box 11
        body[12] = new ModelRendererTurbo(this, 193, 1, textureX, textureY); // Box 12
        body[13] = new ModelRendererTurbo(this, 161, 1, textureX, textureY); // Box 13
        body[14] = new ModelRendererTurbo(this, 257, 1, textureX, textureY); // Box 14
        body[15] = new ModelRendererTurbo(this, 353, 1, textureX, textureY); // Box 15
        body[16] = new ModelRendererTurbo(this, 409, 9, textureX, textureY); // Box 16
        body[17] = new ModelRendererTurbo(this, 105, 33, textureX, textureY); // Box 17
        body[18] = new ModelRendererTurbo(this, 161, 49, textureX, textureY); // Box 18
        body[19] = new ModelRendererTurbo(this, 257, 49, textureX, textureY); // Box 19
        body[20] = new ModelRendererTurbo(this, 353, 49, textureX, textureY); // Box 20
        body[21] = new ModelRendererTurbo(this, 409, 57, textureX, textureY); // Box 21
        body[22] = new ModelRendererTurbo(this, 1, 65, textureX, textureY); // Box 22
        body[23] = new ModelRendererTurbo(this, 57, 81, textureX, textureY); // Box 23
        body[24] = new ModelRendererTurbo(this, 113, 97, textureX, textureY); // Box 24
        body[25] = new ModelRendererTurbo(this, 169, 105, textureX, textureY); // Box 25
        body[26] = new ModelRendererTurbo(this, 169, 121, textureX, textureY); // Box 27
        body[27] = new ModelRendererTurbo(this, 377, 105, textureX, textureY); // Box 28
        body[28] = new ModelRendererTurbo(this, 1, 145, textureX, textureY); // Box 29
        body[29] = new ModelRendererTurbo(this, 217, 1, textureX, textureY); // Box 30
        body[30] = new ModelRendererTurbo(this, 241, 1, textureX, textureY); // Box 31
        body[31] = new ModelRendererTurbo(this, 297, 137, textureX, textureY); // Box 33
        body[32] = new ModelRendererTurbo(this, 369, 153, textureX, textureY); // Box 34
        body[33] = new ModelRendererTurbo(this, 265, 1, textureX, textureY); // Box 36
        body[34] = new ModelRendererTurbo(this, 281, 1, textureX, textureY); // Box 37
        body[35] = new ModelRendererTurbo(this, 313, 1, textureX, textureY); // Box 38
        body[36] = new ModelRendererTurbo(this, 329, 1, textureX, textureY); // Box 39
        body[37] = new ModelRendererTurbo(this, 345, 1, textureX, textureY); // Box 40
        body[38] = new ModelRendererTurbo(this, 361, 1, textureX, textureY); // Box 41
        body[39] = new ModelRendererTurbo(this, 377, 1, textureX, textureY); // Box 42
        body[40] = new ModelRendererTurbo(this, 409, 1, textureX, textureY); // Box 43
        body[41] = new ModelRendererTurbo(this, 425, 1, textureX, textureY); // Box 44
        body[42] = new ModelRendererTurbo(this, 441, 1, textureX, textureY); // Box 45
        body[43] = new ModelRendererTurbo(this, 465, 1, textureX, textureY); // Box 46
        body[44] = new ModelRendererTurbo(this, 17, 17, textureX, textureY); // Box 47
        body[45] = new ModelRendererTurbo(this, 1, 129, textureX, textureY); // Box 48
        body[46] = new ModelRendererTurbo(this, 1, 137, textureX, textureY); // Box 49
        body[47] = new ModelRendererTurbo(this, 169, 137, textureX, textureY); // Box 50
        body[48] = new ModelRendererTurbo(this, 233, 193, textureX, textureY); // Box 51
        body[49] = new ModelRendererTurbo(this, 1, 201, textureX, textureY); // Box 52
        body[50] = new ModelRendererTurbo(this, 105, 201, textureX, textureY); // Box 53
        body[51] = new ModelRendererTurbo(this, 209, 201, textureX, textureY); // Box 54
        body[52] = new ModelRendererTurbo(this, 97, 1, textureX, textureY); // Box 55
        body[53] = new ModelRendererTurbo(this, 465, 1, textureX, textureY); // Box 56
        body[54] = new ModelRendererTurbo(this, 289, 193, textureX, textureY); // Box 57
        body[55] = new ModelRendererTurbo(this, 233, 209, textureX, textureY); // Box 61
        body[56] = new ModelRendererTurbo(this, 273, 1, textureX, textureY); // Box 66
        body[57] = new ModelRendererTurbo(this, 289, 1, textureX, textureY); // Box 67
        body[58] = new ModelRendererTurbo(this, 409, 17, textureX, textureY); // Box 69
        body[59] = new ModelRendererTurbo(this, 489, 1, textureX, textureY); // Box 70
        body[60] = new ModelRendererTurbo(this, 33, 1, textureX, textureY); // Box 71
        body[61] = new ModelRendererTurbo(this, 49, 1, textureX, textureY); // Box 72
        body[62] = new ModelRendererTurbo(this, 65, 1, textureX, textureY); // Box 73
        body[63] = new ModelRendererTurbo(this, 217, 1, textureX, textureY); // Box 74
        body[64] = new ModelRendererTurbo(this, 241, 1, textureX, textureY); // Box 75
        body[65] = new ModelRendererTurbo(this, 321, 1, textureX, textureY); // Box 76
        body[66] = new ModelRendererTurbo(this, 337, 1, textureX, textureY); // Box 77
        body[67] = new ModelRendererTurbo(this, 457, 1, textureX, textureY); // Box 82
        body[68] = new ModelRendererTurbo(this, 505, 1, textureX, textureY); // Box 83
        body[69] = new ModelRendererTurbo(this, 481, 17, textureX, textureY); // Box 84
        body[70] = new ModelRendererTurbo(this, 33, 9, textureX, textureY); // Box 85
        body[71] = new ModelRendererTurbo(this, 65, 9, textureX, textureY); // Box 86
        body[72] = new ModelRendererTurbo(this, 273, 9, textureX, textureY); // Box 87
        body[73] = new ModelRendererTurbo(this, 289, 9, textureX, textureY); // Box 88
        body[74] = new ModelRendererTurbo(this, 353, 1, textureX, textureY); // Box 89
        body[75] = new ModelRendererTurbo(this, 369, 1, textureX, textureY); // Box 90
        body[76] = new ModelRendererTurbo(this, 497, 9, textureX, textureY); // Box 91
        body[77] = new ModelRendererTurbo(this, 385, 9, textureX, textureY); // Box 92
        body[78] = new ModelRendererTurbo(this, 505, 9, textureX, textureY); // Box 93

        body[0].addShapeBox(0F, 0F, 0F, 4, 8, 54, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 0
        body[0].setRotationPoint(18F, -22F, -27F);

        body[1].addBox(0F, 0F, 0F, 2, 2, 40, 0F); // Box 1
        body[1].setRotationPoint(20F, -49F, -20F);

        body[2].addBox(0F, 0F, 0F, 2, 22, 2, 0F); // Box 2
        body[2].setRotationPoint(20F, -44F, -25F);

        body[3].addBox(0F, 0F, 0F, 2, 22, 2, 0F); // Box 3
        body[3].setRotationPoint(20F, -44F, 23F);

        body[4].addShapeBox(0F, 0F, 0F, 2, 2, 5, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, -2F, 0F, 3F, -2F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 4
        body[4].setRotationPoint(20F, -49F, -25F);

        body[5].addShapeBox(0F, 0F, 0F, 2, 2, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, -2F, 0F, 3F, -2F); // Box 5
        body[5].setRotationPoint(20F, -49F, 20F);

        body[6].addShapeBox(0F, 0F, 0F, 2, 25, 2, 0F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F); // Box 6
        body[6].setRotationPoint(20F, -47F, -19F);

        body[7].addShapeBox(0F, 0F, 0F, 2, 25, 2, 0F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F); // Box 7
        body[7].setRotationPoint(20F, -47F, 17F);

        body[8].addShapeBox(0F, 0F, 0F, 2, 25, 2, 0F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F); // Box 8
        body[8].setRotationPoint(20F, -47F, -13F);

        body[9].addShapeBox(0F, 0F, 0F, 2, 25, 2, 0F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F); // Box 9
        body[9].setRotationPoint(20F, -47F, 11F);

        body[10].addShapeBox(0F, 0F, 0F, 2, 25, 2, 0F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F); // Box 10
        body[10].setRotationPoint(20F, -47F, -7F);

        body[11].addShapeBox(0F, 0F, 0F, 2, 25, 2, 0F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F); // Box 11
        body[11].setRotationPoint(20F, -47F, 5F);

        body[12].addShapeBox(0F, 0F, 0F, 2, 25, 2, 0F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F); // Box 12
        body[12].setRotationPoint(20F, -47F, -1F);

        body[13].addShapeBox(0F, 0F, 0F, 1, 1, 46, 0F, 0F, -0.25F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, -0.25F, 0F); // Box 13
        body[13].setRotationPoint(20.5F, -24F, -23F);

        body[14].addShapeBox(0F, 0F, 0F, 1, 1, 46, 0F, -0.5F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, -0.5F, 0F, 0F); // Box 14
        body[14].setRotationPoint(20.5F, -24F, -23F);

        body[15].addShapeBox(0F, 0F, 0F, 1, 1, 46, 0F, 0F, -0.25F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, -0.25F, 0F); // Box 15
        body[15].setRotationPoint(20.5F, -28F, -23F);

        body[16].addShapeBox(0F, 0F, 0F, 1, 1, 46, 0F, -0.5F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, -0.5F, 0F, 0F); // Box 16
        body[16].setRotationPoint(20.5F, -28F, -23F);

        body[17].addShapeBox(0F, 0F, 0F, 1, 1, 46, 0F, 0F, -0.25F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, -0.25F, 0F); // Box 17
        body[17].setRotationPoint(20.5F, -32F, -23F);

        body[18].addShapeBox(0F, 0F, 0F, 1, 1, 46, 0F, -0.5F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, -0.5F, 0F, 0F); // Box 18
        body[18].setRotationPoint(20.5F, -32F, -23F);

        body[19].addShapeBox(0F, 0F, 0F, 1, 1, 46, 0F, 0F, -0.25F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, -0.25F, 0F); // Box 19
        body[19].setRotationPoint(20.5F, -36F, -23F);

        body[20].addShapeBox(0F, 0F, 0F, 1, 1, 46, 0F, -0.5F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, -0.5F, 0F, 0F); // Box 20
        body[20].setRotationPoint(20.5F, -36F, -23F);

        body[21].addShapeBox(0F, 0F, 0F, 1, 1, 46, 0F, 0F, -0.25F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, -0.25F, 0F); // Box 21
        body[21].setRotationPoint(20.5F, -40F, -23F);

        body[22].addShapeBox(0F, 0F, 0F, 1, 1, 46, 0F, -0.5F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, -0.5F, 0F, 0F); // Box 22
        body[22].setRotationPoint(20.5F, -40F, -23F);

        body[23].addShapeBox(0F, 0F, 0F, 1, 1, 46, 0F, 0F, -0.25F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, -0.25F, 0F); // Box 23
        body[23].setRotationPoint(20.5F, -44F, -23F);

        body[24].addShapeBox(0F, 0F, 0F, 1, 1, 46, 0F, -0.5F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, -0.5F, 0F, 0F); // Box 24
        body[24].setRotationPoint(20.5F, -44F, -23F);

        body[25].addBox(0F, 0F, 0F, 119, 3, 5, 0F); // Box 25
        body[25].setRotationPoint(-97F, -14F, -27F);

        body[26].addBox(0F, 0F, 0F, 119, 3, 5, 0F); // Box 27
        body[26].setRotationPoint(-97F, -14F, 22F);

        body[27].addBox(0F, 0F, 0F, 1, 3, 44, 0F); // Box 28
        body[27].setRotationPoint(-103F, -14F, -22F);

        body[28].addBox(0F, 0F, 0F, 122, 1, 44, 0F); // Box 29
        body[28].setRotationPoint(-102F, -14F, -22F);

        body[29].addShapeBox(0F, 0F, 0F, 6, 3, 5, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 30
        body[29].setRotationPoint(-103F, -14F, -27F);

        body[30].addShapeBox(0F, 0F, 0F, 6, 3, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F); // Box 31
        body[30].setRotationPoint(-103F, -14F, 22F);

        body[31].addShapeBox(0F, 0F, 0F, 8, 1, 50, 0F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 33
        body[31].setRotationPoint(12F, -23F, -25F);

        body[32].addShapeBox(0F, 0F, 0F, 6, 8, 50, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 34
        body[32].setRotationPoint(12F, -22F, -23F);

        body[33].addShapeBox(0F, 0F, 0F, 2, 6, 3, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 36
        body[33].setRotationPoint(10F, -20F, 24F);

        body[34].addShapeBox(0F, 0F, 0F, 2, 6, 3, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 37
        body[34].setRotationPoint(-17F, -20F, 24F);

        body[35].addShapeBox(0F, 0F, 0F, 2, 6, 3, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 38
        body[35].setRotationPoint(-45F, -20F, 24F);

        body[36].addShapeBox(0F, 0F, 0F, 2, 6, 3, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 39
        body[36].setRotationPoint(-73F, -20F, 24F);

        body[37].addShapeBox(0F, 0F, 0F, 2, 6, 3, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 40
        body[37].setRotationPoint(-100F, -20F, 24F);

        body[38].addShapeBox(0F, 0F, 0F, 2, 6, 3, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F); // Box 41
        body[38].setRotationPoint(10F, -20F, -27F);

        body[39].addShapeBox(0F, 0F, 0F, 2, 6, 3, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F); // Box 42
        body[39].setRotationPoint(-17F, -20F, -27F);

        body[40].addShapeBox(0F, 0F, 0F, 2, 6, 3, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F); // Box 43
        body[40].setRotationPoint(-45F, -20F, -27F);

        body[41].addShapeBox(0F, 0F, 0F, 2, 6, 3, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F); // Box 44
        body[41].setRotationPoint(-73F, -20F, -27F);

        body[42].addShapeBox(0F, 0F, 0F, 2, 6, 3, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F); // Box 45
        body[42].setRotationPoint(-100F, -20F, -27F);

        body[43].addBox(0F, 0F, 0F, 3, 1, 12, 0F); // Box 46
        body[43].setRotationPoint(-45F, -3F, -22F);

        body[44].addBox(0F, 0F, 0F, 3, 1, 12, 0F); // Box 47
        body[44].setRotationPoint(-4F, -3F, -22F);

        body[45].addShapeBox(0F, 0F, 0F, 50, 2, 1, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 48
        body[45].setRotationPoint(-48F, -3.5F, -21.5F);

        body[46].addShapeBox(0F, 0F, 0F, 50, 2, 1, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 49
        body[46].setRotationPoint(-48F, -3.5F, -20F);

        body[47].addShapeBox(0F, 0F, 0F, 50, 2, 1, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 50
        body[47].setRotationPoint(-48F, -3.5F, -18.5F);

        body[48].addShapeBox(0F, 0F, 0F, 50, 2, 1, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 51
        body[48].setRotationPoint(-48F, -3.5F, -17F);

        body[49].addShapeBox(0F, 0F, 0F, 50, 2, 1, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 52
        body[49].setRotationPoint(-48F, -3.5F, -15.5F);

        body[50].addShapeBox(0F, 0F, 0F, 50, 2, 1, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 53
        body[50].setRotationPoint(-48F, -3.5F, -14F);

        body[51].addShapeBox(0F, 0F, 0F, 50, 2, 1, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 54
        body[51].setRotationPoint(-48F, -3.5F, -12.5F);

        body[52].addBox(0F, 0F, 0F, 1, 8, 2, 0F); // Box 55
        body[52].setRotationPoint(-3F, -11F, -21.5F);

        body[53].addBox(0F, 0F, 0F, 1, 8, 2, 0F); // Box 56
        body[53].setRotationPoint(-44F, -11F, -21.5F);

        body[54].addBox(0F, 0F, 0F, 2, 1, 48, 0F); // Box 57
        body[54].setRotationPoint(-103.5F, -12.5F, -24F);

        body[55].addShapeBox(0F, 0F, 0F, 50, 2, 1, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 61
        body[55].setRotationPoint(-48F, -3.5F, -23F);

        body[56].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 66
        body[56].setRotationPoint(-9F, -6F, 20.5F);

        body[57].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 67
        body[57].setRotationPoint(-41F, -6F, 20.5F);

        body[58].addShapeBox(0F, 0F, 0F, 6, 8, 4, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 69
        body[58].setRotationPoint(12F, -22F, -27F);

        body[59].addShapeBox(0F, 0F, 0F, 5, 3, 1, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 70
        body[59].setRotationPoint(12.5F, -21.5F, -25.5F);

        body[60].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 71
        body[60].setRotationPoint(12.5F, -17.5F, -26.5F);

        body[61].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 72
        body[61].setRotationPoint(14F, -17.5F, -26.5F);

        body[62].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 73
        body[62].setRotationPoint(15.25F, -17.5F, -26.5F);

        body[63].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 74
        body[63].setRotationPoint(16.5F, -17.5F, -26.5F);

        body[64].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 75
        body[64].setRotationPoint(14F, -15.5F, -27F);

        body[65].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 76
        body[65].setRotationPoint(15.25F, -15.5F, -27F);

        body[66].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 77
        body[66].setRotationPoint(16.5F, -15.5F, -27F);

        body[67].addShapeBox(0F, 0F, 0F, 2, 6, 1, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 82
        body[67].setRotationPoint(10F, -22F, 6F);

        body[68].addShapeBox(0F, 0F, 0F, 2, 6, 1, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 83
        body[68].setRotationPoint(10F, -22F, 17F);

        body[69].addShapeBox(0F, 0F, 0F, 2, 6, 10, 0F, 0F, -2F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -2F, 0F); // Box 84
        body[69].setRotationPoint(10.5F, -22F, 7F);

        body[70].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F); // Box 85
        body[70].setRotationPoint(11F, -16F, -4F);

        body[71].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F); // Box 86
        body[71].setRotationPoint(11F, -18F, -4F);

        body[72].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F); // Box 87
        body[72].setRotationPoint(11F, -18F, -9F);

        body[73].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F); // Box 88
        body[73].setRotationPoint(11F, -16F, -9F);

        body[74].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 89
        body[74].setRotationPoint(11F, -17F, -3F);

        body[75].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 90
        body[75].setRotationPoint(11F, -17F, -8F);

        body[76].addShapeBox(0F, 0F, 0F, 2, 6, 1, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 91
        body[76].setRotationPoint(10F, -22F, -22F);

        body[77].addShapeBox(0F, 0F, 0F, 2, 6, 3, 0F, 0F, -2F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -2F, 0F); // Box 92
        body[77].setRotationPoint(10.5F, -22F, -21F);

        body[78].addShapeBox(0F, 0F, 0F, 2, 6, 1, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 93
        body[78].setRotationPoint(10F, -22F, -18F);

        out = new ModelRendererTurbo[4];
        out[0] = new ModelRendererTurbo(this, 1, 209, textureX, textureY); // Box 58
        out[1] = new ModelRendererTurbo(this, 121, 209, textureX, textureY); // Box 59
        out[2] = new ModelRendererTurbo(this, 465, 17, textureX, textureY); // Box 78
        out[3] = new ModelRendererTurbo(this, 425, 25, textureX, textureY); // Box 79

        out[0].addShapeBox(0F, 0F, 0F, 48, 1, 8, 0F, 0F, -22F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -22F, 0F, 0F, 22F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 22F, 0F); // Box 58
        out[0].setRotationPoint(-151F, -13.5F, -22F);

        out[1].addShapeBox(0F, 0F, 0F, 48, 1, 8, 0F, 0F, -22F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -22F, 0F, 0F, 22F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 22F, 0F); // Box 59
        out[1].setRotationPoint(-151F, -13.5F, 14F);

        out[2].addShapeBox(0F, 0F, 0F, 4, 1, 8, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F); // Box 78
        out[2].setRotationPoint(-155F, 8.5F, -22F);

        out[3].addShapeBox(0F, 0F, 0F, 4, 1, 8, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F); // Box 79
        out[3].setRotationPoint(-155F, 8.5F, 14F);

        in = new ModelRendererTurbo[6];
        in[0] = new ModelRendererTurbo(this, 345, 217, textureX, textureY); // Box 60
        in[1] = new ModelRendererTurbo(this, 1, 225, textureX, textureY); // Box 62
        in[2] = new ModelRendererTurbo(this, 1, 33, textureX, textureY); // Box 80
        in[3] = new ModelRendererTurbo(this, 161, 33, textureX, textureY); // Box 81
        in[4] = new ModelRendererTurbo(this, 65, 17, textureX, textureY); // Box 94
        in[5] = new ModelRendererTurbo(this, 497, 17, textureX, textureY); // Box 95

        in[0].addBox(0F, 0F, 0F, 48, 1, 8, 0F); // Box 60
        in[0].setRotationPoint(-47F, -4F, -19.5F);

        in[1].addBox(0F, 0F, 0F, 48, 1, 8, 0F); // Box 62
        in[1].setRotationPoint(-47F, -5F, -19F);

        in[2].addBox(0F, 0F, 0F, 4, 1, 8, 0F); // Box 80
        in[2].setRotationPoint(-34F, -6F, -19.5F);
        in[2].rotateAngleY = -0.06981317F;

        in[3].addBox(0F, 0F, 0F, 4, 1, 8, 0F); // Box 81
        in[3].setRotationPoint(-26F, -6F, -19.5F);
        in[3].rotateAngleY = 0.10471976F;

        in[4].addShapeBox(0F, 0F, 0F, 1, 2, 6, 0F, -0.2F, 0F, -0.5F, -0.2F, 0F, -0.5F, -0.2F, 0F, -0.5F, -0.2F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 94
        in[4].setRotationPoint(-102F, -16F, 15F);

        in[5].addShapeBox(0F, 0F, 0F, 1, 2, 6, 0F, -0.2F, 0F, -0.5F, -0.2F, 0F, -0.5F, -0.2F, 0F, -0.5F, -0.2F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 95
        in[5].setRotationPoint(-102F, -16F, -21F);

        body_colored_secondary = new ModelRendererTurbo[4];
        body_colored_secondary[0] = new ModelRendererTurbo(this, 169, 97, textureX, textureY); // Box 32
        body_colored_secondary[1] = new ModelRendererTurbo(this, 1, 193, textureX, textureY); // Box 35
        body_colored_secondary[2] = new ModelRendererTurbo(this, 217, 17, textureX, textureY); // Box 63
        body_colored_secondary[3] = new ModelRendererTurbo(this, 313, 17, textureX, textureY); // Box 64

        body_colored_secondary[0].addShapeBox(0F, 0F, 0F, 110, 5, 2, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 32
        body_colored_secondary[0].setRotationPoint(-99F, -19F, -27F);

        body_colored_secondary[1].addShapeBox(0F, 0F, 0F, 110, 5, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 35
        body_colored_secondary[1].setRotationPoint(-99F, -19F, 25F);

        body_colored_secondary[2].addShapeBox(0F, 0F, 0F, 30, 8, 10, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F); // Box 63
        body_colored_secondary[2].setRotationPoint(-22F, -11F, 13F);

        body_colored_secondary[3].addShapeBox(0F, 0F, 0F, 30, 8, 10, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F); // Box 64
        body_colored_secondary[3].setRotationPoint(-54F, -11F, 13F);

        translateAll(0F, 0F, 0F);

    }

    @Override
    public void render(VehicleData data, String us, Entity vehicle, int meta){
        super.render(data, us, vehicle, meta);
        T1_2Script scr = data.getScript(T1_2Script.class);
        if(scr != null){
            render(scr.out ? out : in);
        }
        else{
            render(in);
        }
    }
}
