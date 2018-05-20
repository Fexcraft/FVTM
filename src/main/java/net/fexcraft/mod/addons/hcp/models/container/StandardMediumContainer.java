//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2017 Minecraft-SMP.de
// Model: 
// Model Creator: 
// Created on: 05.12.2017 - 18:43:59
// Last changed on: 05.12.2017 - 18:43:59
package net.fexcraft.mod.addons.hcp.models.container;

import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.model.container.ContainerModel;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class StandardMediumContainer extends ContainerModel<ContainerData> {

    int textureX = 512;
    int textureY = 512;

    public StandardMediumContainer(){
        this.creators.add("01e4af9b-2a30-471e-addf-f6338ffce04b");
        bodyColoredPrimary = new ModelRendererTurbo[91];
        bodyColoredPrimary[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
        bodyColoredPrimary[1] = new ModelRendererTurbo(this, 57, 1, textureX, textureY); // Box 1
        bodyColoredPrimary[2] = new ModelRendererTurbo(this, 201, 1, textureX, textureY); // Box 2
        bodyColoredPrimary[3] = new ModelRendererTurbo(this, 257, 1, textureX, textureY); // Box 3
        bodyColoredPrimary[4] = new ModelRendererTurbo(this, 57, 9, textureX, textureY); // Box 4
        bodyColoredPrimary[5] = new ModelRendererTurbo(this, 257, 9, textureX, textureY); // Box 5
        bodyColoredPrimary[6] = new ModelRendererTurbo(this, 449, 1, textureX, textureY); // Box 6
        bodyColoredPrimary[7] = new ModelRendererTurbo(this, 449, 9, textureX, textureY); // Box 7
        bodyColoredPrimary[8] = new ModelRendererTurbo(this, 57, 17, textureX, textureY); // Box 8
        bodyColoredPrimary[9] = new ModelRendererTurbo(this, 137, 17, textureX, textureY); // Box 9
        bodyColoredPrimary[10] = new ModelRendererTurbo(this, 193, 17, textureX, textureY); // Box 10
        bodyColoredPrimary[11] = new ModelRendererTurbo(this, 257, 17, textureX, textureY); // Box 11
        bodyColoredPrimary[12] = new ModelRendererTurbo(this, 1, 57, textureX, textureY); // Box 12
        bodyColoredPrimary[13] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 13
        bodyColoredPrimary[14] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 14
        bodyColoredPrimary[15] = new ModelRendererTurbo(this, 33, 1, textureX, textureY); // Box 15
        bodyColoredPrimary[16] = new ModelRendererTurbo(this, 337, 17, textureX, textureY); // Box 16
        bodyColoredPrimary[17] = new ModelRendererTurbo(this, 305, 17, textureX, textureY); // Box 17
        bodyColoredPrimary[18] = new ModelRendererTurbo(this, 409, 17, textureX, textureY); // Box 18
        bodyColoredPrimary[19] = new ModelRendererTurbo(this, 57, 25, textureX, textureY); // Box 20
        bodyColoredPrimary[20] = new ModelRendererTurbo(this, 57, 33, textureX, textureY); // Box 21
        bodyColoredPrimary[21] = new ModelRendererTurbo(this, 281, 73, textureX, textureY); // Box 22
        bodyColoredPrimary[22] = new ModelRendererTurbo(this, 1, 105, textureX, textureY); // Box 23
        bodyColoredPrimary[23] = new ModelRendererTurbo(this, 153, 121, textureX, textureY); // Box 24
        bodyColoredPrimary[24] = new ModelRendererTurbo(this, 385, 129, textureX, textureY); // Box 25
        bodyColoredPrimary[25] = new ModelRendererTurbo(this, 457, 97, textureX, textureY); // Box 26
        bodyColoredPrimary[26] = new ModelRendererTurbo(this, 1, 153, textureX, textureY); // Box 27
        bodyColoredPrimary[27] = new ModelRendererTurbo(this, 505, 1, textureX, textureY); // Box 28
        bodyColoredPrimary[28] = new ModelRendererTurbo(this, 361, 17, textureX, textureY); // Box 29
        bodyColoredPrimary[29] = new ModelRendererTurbo(this, 369, 17, textureX, textureY); // Box 30
        bodyColoredPrimary[30] = new ModelRendererTurbo(this, 377, 17, textureX, textureY); // Box 31
        bodyColoredPrimary[31] = new ModelRendererTurbo(this, 385, 17, textureX, textureY); // Box 32
        bodyColoredPrimary[32] = new ModelRendererTurbo(this, 393, 17, textureX, textureY); // Box 33
        bodyColoredPrimary[33] = new ModelRendererTurbo(this, 401, 17, textureX, textureY); // Box 34
        bodyColoredPrimary[34] = new ModelRendererTurbo(this, 409, 17, textureX, textureY); // Box 35
        bodyColoredPrimary[35] = new ModelRendererTurbo(this, 417, 17, textureX, textureY); // Box 36
        bodyColoredPrimary[36] = new ModelRendererTurbo(this, 425, 17, textureX, textureY); // Box 37
        bodyColoredPrimary[37] = new ModelRendererTurbo(this, 433, 17, textureX, textureY); // Box 38
        bodyColoredPrimary[38] = new ModelRendererTurbo(this, 441, 17, textureX, textureY); // Box 39
        bodyColoredPrimary[39] = new ModelRendererTurbo(this, 449, 17, textureX, textureY); // Box 40
        bodyColoredPrimary[40] = new ModelRendererTurbo(this, 465, 17, textureX, textureY); // Box 41
        bodyColoredPrimary[41] = new ModelRendererTurbo(this, 473, 17, textureX, textureY); // Box 42
        bodyColoredPrimary[42] = new ModelRendererTurbo(this, 481, 17, textureX, textureY); // Box 43
        bodyColoredPrimary[43] = new ModelRendererTurbo(this, 489, 17, textureX, textureY); // Box 44
        bodyColoredPrimary[44] = new ModelRendererTurbo(this, 497, 17, textureX, textureY); // Box 45
        bodyColoredPrimary[45] = new ModelRendererTurbo(this, 489, 73, textureX, textureY); // Box 46
        bodyColoredPrimary[46] = new ModelRendererTurbo(this, 497, 73, textureX, textureY); // Box 47
        bodyColoredPrimary[47] = new ModelRendererTurbo(this, 505, 73, textureX, textureY); // Box 48
        bodyColoredPrimary[48] = new ModelRendererTurbo(this, 433, 121, textureX, textureY); // Box 49
        bodyColoredPrimary[49] = new ModelRendererTurbo(this, 441, 121, textureX, textureY); // Box 50
        bodyColoredPrimary[50] = new ModelRendererTurbo(this, 449, 121, textureX, textureY); // Box 52
        bodyColoredPrimary[51] = new ModelRendererTurbo(this, 505, 121, textureX, textureY); // Box 53
        bodyColoredPrimary[52] = new ModelRendererTurbo(this, 49, 153, textureX, textureY); // Box 54
        bodyColoredPrimary[53] = new ModelRendererTurbo(this, 57, 153, textureX, textureY); // Box 55
        bodyColoredPrimary[54] = new ModelRendererTurbo(this, 65, 153, textureX, textureY); // Box 56
        bodyColoredPrimary[55] = new ModelRendererTurbo(this, 73, 153, textureX, textureY); // Box 57
        bodyColoredPrimary[56] = new ModelRendererTurbo(this, 81, 153, textureX, textureY); // Box 58
        bodyColoredPrimary[57] = new ModelRendererTurbo(this, 473, 73, textureX, textureY); // Box 59
        bodyColoredPrimary[58] = new ModelRendererTurbo(this, 89, 153, textureX, textureY); // Box 60
        bodyColoredPrimary[59] = new ModelRendererTurbo(this, 97, 153, textureX, textureY); // Box 61
        bodyColoredPrimary[60] = new ModelRendererTurbo(this, 105, 153, textureX, textureY); // Box 62
        bodyColoredPrimary[61] = new ModelRendererTurbo(this, 113, 153, textureX, textureY); // Box 63
        bodyColoredPrimary[62] = new ModelRendererTurbo(this, 121, 153, textureX, textureY); // Box 64
        bodyColoredPrimary[63] = new ModelRendererTurbo(this, 129, 153, textureX, textureY); // Box 65
        bodyColoredPrimary[64] = new ModelRendererTurbo(this, 137, 153, textureX, textureY); // Box 66
        bodyColoredPrimary[65] = new ModelRendererTurbo(this, 145, 153, textureX, textureY); // Box 67
        bodyColoredPrimary[66] = new ModelRendererTurbo(this, 113, 169, textureX, textureY); // Box 68
        bodyColoredPrimary[67] = new ModelRendererTurbo(this, 209, 169, textureX, textureY); // Box 69
        bodyColoredPrimary[68] = new ModelRendererTurbo(this, 265, 177, textureX, textureY); // Box 70
        bodyColoredPrimary[69] = new ModelRendererTurbo(this, 321, 185, textureX, textureY); // Box 71
        bodyColoredPrimary[70] = new ModelRendererTurbo(this, 9, 201, textureX, textureY); // Box 72
        bodyColoredPrimary[71] = new ModelRendererTurbo(this, 65, 217, textureX, textureY); // Box 73
        bodyColoredPrimary[72] = new ModelRendererTurbo(this, 161, 217, textureX, textureY); // Box 74
        bodyColoredPrimary[73] = new ModelRendererTurbo(this, 377, 217, textureX, textureY); // Box 75
        bodyColoredPrimary[74] = new ModelRendererTurbo(this, 217, 225, textureX, textureY); // Box 76
        bodyColoredPrimary[75] = new ModelRendererTurbo(this, 273, 233, textureX, textureY); // Box 77
        bodyColoredPrimary[76] = new ModelRendererTurbo(this, 1, 249, textureX, textureY); // Box 78
        bodyColoredPrimary[77] = new ModelRendererTurbo(this, 57, 265, textureX, textureY); // Box 79
        bodyColoredPrimary[78] = new ModelRendererTurbo(this, 153, 265, textureX, textureY); // Box 80
        bodyColoredPrimary[79] = new ModelRendererTurbo(this, 329, 265, textureX, textureY); // Box 81
        bodyColoredPrimary[80] = new ModelRendererTurbo(this, 209, 273, textureX, textureY); // Box 82
        bodyColoredPrimary[81] = new ModelRendererTurbo(this, 385, 273, textureX, textureY); // Box 83
        bodyColoredPrimary[82] = new ModelRendererTurbo(this, 281, 33, textureX, textureY); // Box 84
        bodyColoredPrimary[83] = new ModelRendererTurbo(this, 233, 57, textureX, textureY); // Box 85
        bodyColoredPrimary[84] = new ModelRendererTurbo(this, 161, 169, textureX, textureY); // Box 86
        bodyColoredPrimary[85] = new ModelRendererTurbo(this, 457, 201, textureX, textureY); // Box 87
        bodyColoredPrimary[86] = new ModelRendererTurbo(this, 193, 185, textureX, textureY); // Box 88
        bodyColoredPrimary[87] = new ModelRendererTurbo(this, 121, 217, textureX, textureY); // Box 89
        bodyColoredPrimary[88] = new ModelRendererTurbo(this, 153, 225, textureX, textureY); // Box 90
        bodyColoredPrimary[89] = new ModelRendererTurbo(this, 449, 241, textureX, textureY); // Box 91
        bodyColoredPrimary[90] = new ModelRendererTurbo(this, 321, 169, textureX, textureY); // Box 51

        bodyColoredPrimary[0].addBox(0F, 0F, 0F, 2, 3, 48, 0F); // Box 0
        bodyColoredPrimary[0].setRotationPoint(-48F, -3F, -24F);

        bodyColoredPrimary[1].addBox(0F, 0F, 0F, 92, 1, 2, 0F); // Box 1
        bodyColoredPrimary[1].setRotationPoint(-46F, -1F, -24F);

        bodyColoredPrimary[2].addBox(0F, 0F, 0F, 2, 3, 48, 0F); // Box 2
        bodyColoredPrimary[2].setRotationPoint(46F, -3F, -24F);

        bodyColoredPrimary[3].addBox(0F, 0F, 0F, 92, 1, 2, 0F); // Box 3
        bodyColoredPrimary[3].setRotationPoint(-46F, -1F, 22F);

        bodyColoredPrimary[4].addBox(0F, 0F, 0F, 92, 1, 2, 0F); // Box 4
        bodyColoredPrimary[4].setRotationPoint(-46F, -3F, -24F);

        bodyColoredPrimary[5].addBox(0F, 0F, 0F, 92, 1, 2, 0F); // Box 5
        bodyColoredPrimary[5].setRotationPoint(-46F, -3F, 22F);

        bodyColoredPrimary[6].addBox(0F, 0F, 0F, 24, 1, 2, 0F); // Box 6
        bodyColoredPrimary[6].setRotationPoint(-46F, -2F, 22F);

        bodyColoredPrimary[7].addBox(0F, 0F, 0F, 24, 1, 2, 0F); // Box 7
        bodyColoredPrimary[7].setRotationPoint(22F, -2F, 22F);

        bodyColoredPrimary[8].addBox(0F, 0F, 0F, 36, 1, 2, 0F); // Box 8
        bodyColoredPrimary[8].setRotationPoint(-18F, -2F, 22F);

        bodyColoredPrimary[9].addBox(0F, 0F, 0F, 24, 1, 2, 0F); // Box 9
        bodyColoredPrimary[9].setRotationPoint(-46F, -2F, -24F);

        bodyColoredPrimary[10].addBox(0F, 0F, 0F, 24, 1, 2, 0F); // Box 10
        bodyColoredPrimary[10].setRotationPoint(22F, -2F, -24F);

        bodyColoredPrimary[11].addBox(0F, 0F, 0F, 36, 1, 2, 0F); // Box 11
        bodyColoredPrimary[11].setRotationPoint(-18F, -2F, -24F);

        bodyColoredPrimary[12].addBox(0F, 0F, 0F, 92, 1, 44, 0F); // Box 12
        bodyColoredPrimary[12].setRotationPoint(-46F, -3F, -22F);

        bodyColoredPrimary[13].addBox(0F, 0F, 0F, 2, 43, 2, 0F); // Box 13
        bodyColoredPrimary[13].setRotationPoint(-48F, -46F, -24F);

        bodyColoredPrimary[14].addBox(0F, 0F, 0F, 2, 43, 2, 0F); // Box 14
        bodyColoredPrimary[14].setRotationPoint(-48F, -46F, 22F);

        bodyColoredPrimary[15].addBox(0F, 0F, 0F, 2, 43, 2, 0F); // Box 15
        bodyColoredPrimary[15].setRotationPoint(46F, -46F, 22F);

        bodyColoredPrimary[16].addBox(0F, 0F, 0F, 2, 43, 2, 0F); // Box 16
        bodyColoredPrimary[16].setRotationPoint(46F, -46F, -24F);

        bodyColoredPrimary[17].addBox(0F, 0F, 0F, 2, 2, 48, 0F); // Box 17
        bodyColoredPrimary[17].setRotationPoint(46F, -48F, -24F);

        bodyColoredPrimary[18].addBox(0F, 0F, 0F, 2, 2, 48, 0F); // Box 18
        bodyColoredPrimary[18].setRotationPoint(-48F, -48F, -24F);

        bodyColoredPrimary[19].addBox(0F, 0F, 0F, 92, 2, 2, 0F); // Box 20
        bodyColoredPrimary[19].setRotationPoint(-46F, -48F, -24F);

        bodyColoredPrimary[20].addBox(0F, 0F, 0F, 92, 2, 2, 0F); // Box 21
        bodyColoredPrimary[20].setRotationPoint(-46F, -48F, 22F);

        bodyColoredPrimary[21].addBox(0F, 0F, 0F, 94, 43, 1, 0F); // Box 22
        bodyColoredPrimary[21].setRotationPoint(-46F, -46F, -23.5F);

        bodyColoredPrimary[22].addBox(0F, 0F, 0F, 94, 43, 1, 0F); // Box 23
        bodyColoredPrimary[22].setRotationPoint(-46F, -46F, 22.5F);

        bodyColoredPrimary[23].addBox(0F, 0F, 0F, 92, 1, 44, 0F); // Box 24
        bodyColoredPrimary[23].setRotationPoint(-46F, -47.5F, -22F);

        bodyColoredPrimary[24].addBox(0F, 0F, 0F, 1, 43, 44, 0F); // Box 25
        bodyColoredPrimary[24].setRotationPoint(46.5F, -46F, -22F);

        bodyColoredPrimary[25].addBox(0F, 0F, 0F, 1, 44, 22, 0F); // Box 26
        bodyColoredPrimary[25].setRotationPoint(-47.5F, -46F, 0F);

        bodyColoredPrimary[26].addBox(0F, 0F, 22F, 1, 44, 22, 0F); // Box 27
        bodyColoredPrimary[26].setRotationPoint(-47.5F, -46F, -44F);

        bodyColoredPrimary[27].addShapeBox(0F, 0F, 0F, 1, 43, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F); // Box 28
        bodyColoredPrimary[27].setRotationPoint(-46F, -46F, -24F);

        bodyColoredPrimary[28].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F); // Box 29
        bodyColoredPrimary[28].setRotationPoint(-41F, -46F, -24F);

        bodyColoredPrimary[29].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F); // Box 30
        bodyColoredPrimary[29].setRotationPoint(-35F, -46F, -24F);

        bodyColoredPrimary[30].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F); // Box 31
        bodyColoredPrimary[30].setRotationPoint(-29F, -46F, -24F);

        bodyColoredPrimary[31].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F); // Box 32
        bodyColoredPrimary[31].setRotationPoint(-23F, -46F, -24F);

        bodyColoredPrimary[32].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F); // Box 33
        bodyColoredPrimary[32].setRotationPoint(-17F, -46F, -24F);

        bodyColoredPrimary[33].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F); // Box 34
        bodyColoredPrimary[33].setRotationPoint(-11F, -46F, -24F);

        bodyColoredPrimary[34].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F); // Box 35
        bodyColoredPrimary[34].setRotationPoint(-5F, -46F, -24F);

        bodyColoredPrimary[35].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F); // Box 36
        bodyColoredPrimary[35].setRotationPoint(3F, -46F, -24F);

        bodyColoredPrimary[36].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F); // Box 37
        bodyColoredPrimary[36].setRotationPoint(9F, -46F, -24F);

        bodyColoredPrimary[37].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F); // Box 38
        bodyColoredPrimary[37].setRotationPoint(15F, -46F, -24F);

        bodyColoredPrimary[38].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F); // Box 39
        bodyColoredPrimary[38].setRotationPoint(21F, -46F, -24F);

        bodyColoredPrimary[39].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F); // Box 40
        bodyColoredPrimary[39].setRotationPoint(27F, -46F, -24F);

        bodyColoredPrimary[40].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F); // Box 41
        bodyColoredPrimary[40].setRotationPoint(33F, -46F, -24F);

        bodyColoredPrimary[41].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F); // Box 42
        bodyColoredPrimary[41].setRotationPoint(39F, -46F, -24F);

        bodyColoredPrimary[42].addShapeBox(0F, 0F, 0F, 1, 43, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F); // Box 43
        bodyColoredPrimary[42].setRotationPoint(45F, -46F, -24F);

        bodyColoredPrimary[43].addShapeBox(0F, 0F, 0F, 1, 43, 1, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 44
        bodyColoredPrimary[43].setRotationPoint(-46F, -46F, 23F);

        bodyColoredPrimary[44].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 45
        bodyColoredPrimary[44].setRotationPoint(-41F, -46F, 23F);

        bodyColoredPrimary[45].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 46
        bodyColoredPrimary[45].setRotationPoint(-35F, -46F, 23F);

        bodyColoredPrimary[46].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 47
        bodyColoredPrimary[46].setRotationPoint(-29F, -46F, 23F);

        bodyColoredPrimary[47].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 48
        bodyColoredPrimary[47].setRotationPoint(-23F, -46F, 23F);

        bodyColoredPrimary[48].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 49
        bodyColoredPrimary[48].setRotationPoint(-17F, -46F, 23F);

        bodyColoredPrimary[49].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 50
        bodyColoredPrimary[49].setRotationPoint(-11F, -46F, 23F);

        bodyColoredPrimary[50].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 52
        bodyColoredPrimary[50].setRotationPoint(3F, -46F, 23F);

        bodyColoredPrimary[51].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 53
        bodyColoredPrimary[51].setRotationPoint(9F, -46F, 23F);

        bodyColoredPrimary[52].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 54
        bodyColoredPrimary[52].setRotationPoint(15F, -46F, 23F);

        bodyColoredPrimary[53].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 55
        bodyColoredPrimary[53].setRotationPoint(21F, -46F, 23F);

        bodyColoredPrimary[54].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 56
        bodyColoredPrimary[54].setRotationPoint(27F, -46F, 23F);

        bodyColoredPrimary[55].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 57
        bodyColoredPrimary[55].setRotationPoint(33F, -46F, 23F);

        bodyColoredPrimary[56].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 58
        bodyColoredPrimary[56].setRotationPoint(39F, -46F, 23F);

        bodyColoredPrimary[57].addShapeBox(0F, 0F, 0F, 1, 43, 1, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 59
        bodyColoredPrimary[57].setRotationPoint(45F, -46F, 23F);

        bodyColoredPrimary[58].addShapeBox(0F, 0F, 0F, 1, 43, 1, 0F, -0.5F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 1F); // Box 60
        bodyColoredPrimary[58].setRotationPoint(47F, -46F, -22F);

        bodyColoredPrimary[59].addShapeBox(0F, 0F, 0F, 1, 43, 1, 0F, -0.5F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 1F); // Box 61
        bodyColoredPrimary[59].setRotationPoint(47F, -46F, 21F);

        bodyColoredPrimary[60].addShapeBox(0F, 0F, 0F, 1, 43, 2, 0F, -0.5F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 1F); // Box 62
        bodyColoredPrimary[60].setRotationPoint(47F, -46F, 15F);

        bodyColoredPrimary[61].addShapeBox(0F, 0F, 0F, 1, 43, 2, 0F, -0.5F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 1F); // Box 63
        bodyColoredPrimary[61].setRotationPoint(47F, -46F, -17F);

        bodyColoredPrimary[62].addShapeBox(0F, 0F, 0F, 1, 43, 2, 0F, -0.5F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 1F); // Box 64
        bodyColoredPrimary[62].setRotationPoint(47F, -46F, -11F);

        bodyColoredPrimary[63].addShapeBox(0F, 0F, 0F, 1, 43, 2, 0F, -0.5F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 1F); // Box 65
        bodyColoredPrimary[63].setRotationPoint(47F, -46F, 9F);

        bodyColoredPrimary[64].addShapeBox(0F, 0F, 0F, 1, 43, 2, 0F, -0.5F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 1F); // Box 66
        bodyColoredPrimary[64].setRotationPoint(47F, -46F, 2F);

        bodyColoredPrimary[65].addShapeBox(0F, 0F, 0F, 1, 43, 2, 0F, -0.5F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 1F); // Box 67
        bodyColoredPrimary[65].setRotationPoint(47F, -46F, -5F);

        bodyColoredPrimary[66].addShapeBox(0F, 0F, 0F, 1, 1, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F); // Box 68
        bodyColoredPrimary[66].setRotationPoint(-46F, -48F, -22F);

        bodyColoredPrimary[67].addShapeBox(0F, 0F, 0F, 2, 1, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F); // Box 69
        bodyColoredPrimary[67].setRotationPoint(-41F, -48F, -22F);

        bodyColoredPrimary[68].addShapeBox(0F, 0F, 0F, 2, 1, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F); // Box 70
        bodyColoredPrimary[68].setRotationPoint(-35F, -48F, -22F);

        bodyColoredPrimary[69].addShapeBox(0F, 0F, 0F, 2, 1, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F); // Box 71
        bodyColoredPrimary[69].setRotationPoint(-29F, -48F, -22F);

        bodyColoredPrimary[70].addShapeBox(0F, 0F, 0F, 2, 1, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F); // Box 72
        bodyColoredPrimary[70].setRotationPoint(-23F, -48F, -22F);

        bodyColoredPrimary[71].addShapeBox(0F, 0F, 0F, 2, 1, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F); // Box 73
        bodyColoredPrimary[71].setRotationPoint(-17F, -48F, -22F);

        bodyColoredPrimary[72].addShapeBox(0F, 0F, 0F, 2, 1, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F); // Box 74
        bodyColoredPrimary[72].setRotationPoint(-11F, -48F, -22F);

        bodyColoredPrimary[73].addShapeBox(0F, 0F, 0F, 2, 1, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F); // Box 75
        bodyColoredPrimary[73].setRotationPoint(-5F, -48F, -22F);

        bodyColoredPrimary[74].addShapeBox(0F, 0F, 0F, 2, 1, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F); // Box 76
        bodyColoredPrimary[74].setRotationPoint(3F, -48F, -22F);

        bodyColoredPrimary[75].addShapeBox(0F, 0F, 0F, 2, 1, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F); // Box 77
        bodyColoredPrimary[75].setRotationPoint(9F, -48F, -22F);

        bodyColoredPrimary[76].addShapeBox(0F, 0F, 0F, 2, 1, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F); // Box 78
        bodyColoredPrimary[76].setRotationPoint(15F, -48F, -22F);

        bodyColoredPrimary[77].addShapeBox(0F, 0F, 0F, 2, 1, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F); // Box 79
        bodyColoredPrimary[77].setRotationPoint(21F, -48F, -22F);

        bodyColoredPrimary[78].addShapeBox(0F, 0F, 0F, 2, 1, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F); // Box 80
        bodyColoredPrimary[78].setRotationPoint(27F, -48F, -22F);

        bodyColoredPrimary[79].addShapeBox(0F, 0F, 0F, 2, 1, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F); // Box 81
        bodyColoredPrimary[79].setRotationPoint(33F, -48F, -22F);

        bodyColoredPrimary[80].addShapeBox(0F, 0F, 0F, 2, 1, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F); // Box 82
        bodyColoredPrimary[80].setRotationPoint(39F, -48F, -22F);

        bodyColoredPrimary[81].addShapeBox(0F, 0F, 0F, 1, 1, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F); // Box 83
        bodyColoredPrimary[81].setRotationPoint(45F, -48F, -22F);

        bodyColoredPrimary[82].addShapeBox(-1F, 0F, 0F, 1, 5, 22, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, -0.5F, 0F, 0F); // Box 84
        bodyColoredPrimary[82].setRotationPoint(-47.5F, -46F, 0F);

        bodyColoredPrimary[83].addShapeBox(-1F, 37F, 0F, 1, 6, 22, 0F, -0.5F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F); // Box 85
        bodyColoredPrimary[83].setRotationPoint(-47.5F, -46F, 0F);

        bodyColoredPrimary[84].addShapeBox(-1F, 9F, 0F, 1, 10, 22, 0F, -0.5F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, -0.5F, 0F, 0F); // Box 86
        bodyColoredPrimary[84].setRotationPoint(-47.5F, -46F, 0F);

        bodyColoredPrimary[85].addShapeBox(-1F, 23F, 0F, 1, 10, 22, 0F, -0.5F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, -0.5F, 0F, 0F); // Box 87
        bodyColoredPrimary[85].setRotationPoint(-47.5F, -46F, 0F);

        bodyColoredPrimary[86].addShapeBox(-1F, 0F, 22F, 1, 5, 22, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, -0.5F, 0F, 0F); // Box 88
        bodyColoredPrimary[86].setRotationPoint(-47.5F, -46F, -44F);

        bodyColoredPrimary[87].addShapeBox(-1F, 37F, 22F, 1, 6, 22, 0F, -0.5F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F); // Box 89
        bodyColoredPrimary[87].setRotationPoint(-47.5F, -46F, -44F);

        bodyColoredPrimary[88].addShapeBox(-1F, 9F, 22F, 1, 10, 22, 0F, -0.5F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, -0.5F, 0F, 0F); // Box 90
        bodyColoredPrimary[88].setRotationPoint(-47.5F, -46F, -44F);

        bodyColoredPrimary[89].addShapeBox(-1F, 23F, 22F, 1, 10, 22, 0F, -0.5F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, -0.5F, 0F, 0F); // Box 91
        bodyColoredPrimary[89].setRotationPoint(-47.5F, -46F, -44F);

        bodyColoredPrimary[90].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 51
        bodyColoredPrimary[90].setRotationPoint(-5F, -46F, 23F);

        body = new ModelRendererTurbo[32];
        body[0] = new ModelRendererTurbo(this, 257, 25, textureX, textureY); // Box 92
        body[1] = new ModelRendererTurbo(this, 265, 25, textureX, textureY); // Box 93
        body[2] = new ModelRendererTurbo(this, 273, 25, textureX, textureY); // Box 94
        body[3] = new ModelRendererTurbo(this, 281, 25, textureX, textureY); // Box 95
        body[4] = new ModelRendererTurbo(this, 289, 25, textureX, textureY); // Box 97
        body[5] = new ModelRendererTurbo(this, 297, 25, textureX, textureY); // Box 98
        body[6] = new ModelRendererTurbo(this, 305, 25, textureX, textureY); // Box 99
        body[7] = new ModelRendererTurbo(this, 313, 25, textureX, textureY); // Box 100
        body[8] = new ModelRendererTurbo(this, 321, 25, textureX, textureY); // Box 101
        body[9] = new ModelRendererTurbo(this, 329, 25, textureX, textureY); // Box 102
        body[10] = new ModelRendererTurbo(this, 257, 33, textureX, textureY); // Box 103
        body[11] = new ModelRendererTurbo(this, 265, 33, textureX, textureY); // Box 104
        body[12] = new ModelRendererTurbo(this, 273, 33, textureX, textureY); // Box 105
        body[13] = new ModelRendererTurbo(this, 281, 33, textureX, textureY); // Box 106
        body[14] = new ModelRendererTurbo(this, 289, 33, textureX, textureY); // Box 107
        body[15] = new ModelRendererTurbo(this, 297, 33, textureX, textureY); // Box 108
        body[16] = new ModelRendererTurbo(this, 329, 169, textureX, textureY); // Box 109
        body[17] = new ModelRendererTurbo(this, 337, 169, textureX, textureY); // Box 110
        body[18] = new ModelRendererTurbo(this, 345, 169, textureX, textureY); // Box 111
        body[19] = new ModelRendererTurbo(this, 353, 169, textureX, textureY); // Box 112
        body[20] = new ModelRendererTurbo(this, 313, 33, textureX, textureY); // Box 113
        body[21] = new ModelRendererTurbo(this, 105, 41, textureX, textureY); // Box 114
        body[22] = new ModelRendererTurbo(this, 129, 41, textureX, textureY); // Box 115
        body[23] = new ModelRendererTurbo(this, 153, 41, textureX, textureY); // Box 116
        body[24] = new ModelRendererTurbo(this, 313, 33, textureX, textureY); // Box 117
        body[25] = new ModelRendererTurbo(this, 329, 33, textureX, textureY); // Box 118
        body[26] = new ModelRendererTurbo(this, 57, 41, textureX, textureY); // Box 119
        body[27] = new ModelRendererTurbo(this, 65, 41, textureX, textureY); // Box 120
        body[28] = new ModelRendererTurbo(this, 81, 41, textureX, textureY); // Box 122
        body[29] = new ModelRendererTurbo(this, 89, 41, textureX, textureY); // Box 123
        body[30] = new ModelRendererTurbo(this, 97, 41, textureX, textureY); // Box 124
        body[31] = new ModelRendererTurbo(this, 105, 41, textureX, textureY); // Box 125

        body[0].addShapeBox(-2F, -1.5F, -18F, 1, 1, 1, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F); // Box 92
        body[0].setRotationPoint(-47F, -46F, 21F);

        body[1].addShapeBox(-2F, -1.5F, -8F, 1, 1, 1, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F); // Box 93
        body[1].setRotationPoint(-47F, -46F, 21F);

        body[2].addShapeBox(-2F, 43.5F, -18F, 1, 1, 1, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F); // Box 94
        body[2].setRotationPoint(-47F, -46F, 21F);

        body[3].addShapeBox(-2F, 43.5F, -8F, 1, 1, 1, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F); // Box 95
        body[3].setRotationPoint(-47F, -46F, 21F);

        body[4].addShapeBox(-1.5F, -1.5F, 18F, 1, 1, 1, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F); // Box 97
        body[4].setRotationPoint(-47.5F, -46F, -22F);

        body[5].addShapeBox(-1.5F, -1.5F, 8F, 1, 1, 1, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F); // Box 98
        body[5].setRotationPoint(-47.5F, -46F, -22F);

        body[6].addShapeBox(-1.5F, 43.5F, 18F, 1, 1, 1, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F); // Box 99
        body[6].setRotationPoint(-47.5F, -46F, -22F);

        body[7].addShapeBox(-1.5F, 43.5F, 8F, 1, 1, 1, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F); // Box 100
        body[7].setRotationPoint(-47.5F, -46F, -22F);

        body[8].addShapeBox(-1.5F, 26.5F, 5F, 1, 1, 1, 0F, -0.4F, 0F, -0.1F, 0F, 0.5F, -0.1F, 0F, 0.5F, -0.1F, -0.4F, 0F, -0.1F, -0.4F, 0F, -0.1F, 0F, 0.5F, -0.1F, 0F, 0.5F, -0.1F, -0.4F, 0F, -0.1F); // Box 101
        body[8].setRotationPoint(-47.5F, -46F, -22F);

        body[9].addShapeBox(-1.5F, 1.5F, 18F, 1, 1, 1, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F); // Box 102
        body[9].setRotationPoint(-47.5F, -46F, -22F);

        body[10].addShapeBox(-2F, 1.5F, -8F, 1, 1, 1, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F); // Box 103
        body[10].setRotationPoint(-47F, -46F, 21F);

        body[11].addShapeBox(-2F, 1.5F, -18F, 1, 1, 1, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F); // Box 104
        body[11].setRotationPoint(-47F, -46F, 21F);

        body[12].addShapeBox(-1.5F, 40.5F, 8F, 1, 1, 1, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F); // Box 105
        body[12].setRotationPoint(-47.5F, -46F, -22F);

        body[13].addShapeBox(-1.5F, 40.5F, 18F, 1, 1, 1, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F); // Box 106
        body[13].setRotationPoint(-47.5F, -46F, -22F);

        body[14].addShapeBox(-2F, 40.5F, -8F, 1, 1, 1, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F); // Box 107
        body[14].setRotationPoint(-47F, -46F, 21F);

        body[15].addShapeBox(-2F, 40.5F, -18F, 1, 1, 1, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F); // Box 108
        body[15].setRotationPoint(-47F, -46F, 21F);

        body[16].addShapeBox(-1.5F, 0F, 8F, 1, 46, 1, 0F, -0.6F, 0.4F, -0.2F, 0F, 0.4F, -0.2F, 0F, 0.4F, -0.2F, -0.6F, 0.4F, -0.2F, -0.6F, 0.4F, -0.2F, 0F, 0.4F, -0.2F, 0F, 0.4F, -0.2F, -0.6F, 0.4F, -0.2F); // Box 109
        body[16].setRotationPoint(-47.5F, -47.5F, -22F);

        body[17].addShapeBox(-1.5F, 0F, 18F, 1, 46, 1, 0F, -0.6F, 0.4F, -0.2F, 0F, 0.4F, -0.2F, 0F, 0.4F, -0.2F, -0.6F, 0.4F, -0.2F, -0.6F, 0.4F, -0.2F, 0F, 0.4F, -0.2F, 0F, 0.4F, -0.2F, -0.6F, 0.4F, -0.2F); // Box 110
        body[17].setRotationPoint(-47.5F, -47.5F, -22F);

        body[18].addShapeBox(-2F, 0F, -8F, 1, 46, 1, 0F, -0.6F, 0.4F, -0.2F, 0F, 0.4F, -0.2F, 0F, 0.4F, -0.2F, -0.6F, 0.4F, -0.2F, -0.6F, 0.4F, -0.2F, 0F, 0.4F, -0.2F, 0F, 0.4F, -0.2F, -0.6F, 0.4F, -0.2F); // Box 111
        body[18].setRotationPoint(-47F, -47.5F, 21F);

        body[19].addShapeBox(-2F, 0F, -18F, 1, 46, 1, 0F, -0.6F, 0.4F, -0.2F, 0F, 0.4F, -0.2F, 0F, 0.4F, -0.2F, -0.6F, 0.4F, -0.2F, -0.6F, 0.4F, -0.2F, 0F, 0.4F, -0.2F, 0F, 0.4F, -0.2F, -0.6F, 0.4F, -0.2F); // Box 112
        body[19].setRotationPoint(-47F, -47.5F, 21F);

        body[20].addShapeBox(-1.5F, 10F, -9F, 1, 1, 7, 0F, -0.6F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, -0.6F, -0.2F, -0.2F, -0.6F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, -0.6F, -0.2F, -0.2F); // Box 113
        body[20].setRotationPoint(-47.5F, -29.5F, 22F);

        body[21].addShapeBox(-1.5F, 12F, -19F, 1, 1, 7, 0F, -0.6F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, -0.6F, -0.2F, -0.2F, -0.6F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, -0.6F, -0.2F, -0.2F); // Box 114
        body[21].setRotationPoint(-47.5F, -29.5F, 22F);

        body[22].addShapeBox(-1.5F, 12F, 12F, 1, 1, 7, 0F, -0.6F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, -0.6F, -0.2F, -0.2F, -0.6F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, -0.6F, -0.2F, -0.2F); // Box 115
        body[22].setRotationPoint(-47.5F, -29.5F, -22F);

        body[23].addShapeBox(-1.5F, 10F, 2F, 1, 1, 7, 0F, -0.6F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, -0.6F, -0.2F, -0.2F, -0.6F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, -0.6F, -0.2F, -0.2F); // Box 116
        body[23].setRotationPoint(-47.5F, -29.5F, -22F);

        body[24].addShapeBox(-1.5F, 26.5F, 8F, 1, 1, 1, 0F, -0.4F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, -0.4F, 0.2F, 0.2F, -0.4F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, -0.4F, 0.2F, 0.2F); // Box 117
        body[24].setRotationPoint(-47.5F, -46F, -22F);

        body[25].addShapeBox(-1.5F, 28.5F, 18F, 1, 1, 1, 0F, -0.4F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, -0.4F, 0.2F, 0.2F, -0.4F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, -0.4F, 0.2F, 0.2F); // Box 118
        body[25].setRotationPoint(-47.5F, -46F, -22F);

        body[26].addShapeBox(-1.5F, 28.5F, -18F, 1, 1, 1, 0F, -0.4F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, -0.4F, 0.2F, 0.2F, -0.4F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, -0.4F, 0.2F, 0.2F); // Box 119
        body[26].setRotationPoint(-47.5F, -46F, 21F);

        body[27].addShapeBox(-1.5F, 26.5F, -8F, 1, 1, 1, 0F, -0.4F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, -0.4F, 0.2F, 0.2F, -0.4F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, -0.4F, 0.2F, 0.2F); // Box 120
        body[27].setRotationPoint(-47.5F, -46F, 21F);

        body[28].addShapeBox(-1.5F, 1.5F, 8F, 1, 1, 1, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F); // Box 122
        body[28].setRotationPoint(-47.5F, -46F, -22F);

        body[29].addShapeBox(-1.5F, 28.5F, 15F, 1, 1, 1, 0F, -0.4F, 0F, -0.1F, 0F, 0.5F, -0.1F, 0F, 0.5F, -0.1F, -0.4F, 0F, -0.1F, -0.4F, 0F, -0.1F, 0F, 0.5F, -0.1F, 0F, 0.5F, -0.1F, -0.4F, 0F, -0.1F); // Box 123
        body[29].setRotationPoint(-47.5F, -46F, -22F);

        body[30].addShapeBox(-1.5F, 28.5F, -15F, 1, 1, 1, 0F, -0.4F, 0F, -0.1F, 0F, 0.5F, -0.1F, 0F, 0.5F, -0.1F, -0.4F, 0F, -0.1F, -0.4F, 0F, -0.1F, 0F, 0.5F, -0.1F, 0F, 0.5F, -0.1F, -0.4F, 0F, -0.1F); // Box 124
        body[30].setRotationPoint(-47.5F, -46F, 21F);

        body[31].addShapeBox(-1.5F, 26.5F, -5F, 1, 1, 1, 0F, -0.4F, 0F, -0.1F, 0F, 0.5F, -0.1F, 0F, 0.5F, -0.1F, -0.4F, 0F, -0.1F, -0.4F, 0F, -0.1F, 0F, 0.5F, -0.1F, 0F, 0.5F, -0.1F, -0.4F, 0F, -0.1F); // Box 125
        body[31].setRotationPoint(-47.5F, -46F, 21F);

        flipAll();
    }

}
