//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2018 Minecraft-SMP.de
// Model: RefrigeratorContainer
// Model Creator: FEX___96
// Created on: 06.04.2018 - 13:42:02
// Last changed on: 06.04.2018 - 13:42:02
package net.fexcraft.mod.addons.hcp.models.container;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.model.container.ContainerModelTMT;
import net.fexcraft.mod.fvtm.model.part.PartModelTMT;
import net.minecraft.client.renderer.GlStateManager;

public class StandardRefrigeratorContainer extends ContainerModelTMT {

    public ModelRendererTurbo rot[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo glow[] = new ModelRendererTurbo[0];

    public StandardRefrigeratorContainer(){
    	super(); this.addToCreators("01e4af9b-2a30-471e-addf-f6338ffce04b");
        textureX = 512; textureY = 512;
        body_colored_primary = new ModelRendererTurbo[104];
        body_colored_primary[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
        body_colored_primary[1] = new ModelRendererTurbo(this, 129, 1, textureX, textureY); // Box 0
        body_colored_primary[2] = new ModelRendererTurbo(this, 185, 1, textureX, textureY); // Box 1
        body_colored_primary[3] = new ModelRendererTurbo(this, 329, 1, textureX, textureY); // Box 2
        body_colored_primary[4] = new ModelRendererTurbo(this, 185, 9, textureX, textureY); // Box 3
        body_colored_primary[5] = new ModelRendererTurbo(this, 185, 17, textureX, textureY); // Box 4
        body_colored_primary[6] = new ModelRendererTurbo(this, 185, 25, textureX, textureY); // Box 5
        body_colored_primary[7] = new ModelRendererTurbo(this, 81, 1, textureX, textureY); // Box 6
        body_colored_primary[8] = new ModelRendererTurbo(this, 385, 1, textureX, textureY); // Box 7
        body_colored_primary[9] = new ModelRendererTurbo(this, 81, 9, textureX, textureY); // Box 8
        body_colored_primary[10] = new ModelRendererTurbo(this, 441, 1, textureX, textureY); // Box 9
        body_colored_primary[11] = new ModelRendererTurbo(this, 385, 9, textureX, textureY); // Box 10
        body_colored_primary[12] = new ModelRendererTurbo(this, 81, 17, textureX, textureY); // Box 11
        body_colored_primary[13] = new ModelRendererTurbo(this, 81, 57, textureX, textureY); // Box 12
        body_colored_primary[14] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 13
        body_colored_primary[15] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 14
        body_colored_primary[16] = new ModelRendererTurbo(this, 33, 1, textureX, textureY); // Box 15
        body_colored_primary[17] = new ModelRendererTurbo(this, 161, 1, textureX, textureY); // Box 16
        body_colored_primary[18] = new ModelRendererTurbo(this, 393, 9, textureX, textureY); // Box 17
        body_colored_primary[19] = new ModelRendererTurbo(this, 313, 57, textureX, textureY); // Box 18
        body_colored_primary[20] = new ModelRendererTurbo(this, 185, 33, textureX, textureY); // Box 20
        body_colored_primary[21] = new ModelRendererTurbo(this, 185, 41, textureX, textureY); // Box 21
        body_colored_primary[22] = new ModelRendererTurbo(this, 1, 105, textureX, textureY); // Box 22
        body_colored_primary[23] = new ModelRendererTurbo(this, 161, 113, textureX, textureY); // Box 23
        body_colored_primary[24] = new ModelRendererTurbo(this, 1, 161, textureX, textureY); // Box 24
        body_colored_primary[25] = new ModelRendererTurbo(this, 377, 65, textureX, textureY); // Box 25
        body_colored_primary[26] = new ModelRendererTurbo(this, 321, 113, textureX, textureY); // Box 26
        body_colored_primary[27] = new ModelRendererTurbo(this, 449, 137, textureX, textureY); // Box 27
        body_colored_primary[28] = new ModelRendererTurbo(this, 497, 1, textureX, textureY); // Box 28
        body_colored_primary[29] = new ModelRendererTurbo(this, 505, 1, textureX, textureY); // Box 29
        body_colored_primary[30] = new ModelRendererTurbo(this, 449, 9, textureX, textureY); // Box 30
        body_colored_primary[31] = new ModelRendererTurbo(this, 457, 9, textureX, textureY); // Box 31
        body_colored_primary[32] = new ModelRendererTurbo(this, 465, 9, textureX, textureY); // Box 32
        body_colored_primary[33] = new ModelRendererTurbo(this, 473, 9, textureX, textureY); // Box 33
        body_colored_primary[34] = new ModelRendererTurbo(this, 481, 9, textureX, textureY); // Box 34
        body_colored_primary[35] = new ModelRendererTurbo(this, 489, 9, textureX, textureY); // Box 35
        body_colored_primary[36] = new ModelRendererTurbo(this, 313, 49, textureX, textureY); // Box 36
        body_colored_primary[37] = new ModelRendererTurbo(this, 321, 49, textureX, textureY); // Box 37
        body_colored_primary[38] = new ModelRendererTurbo(this, 497, 49, textureX, textureY); // Box 38
        body_colored_primary[39] = new ModelRendererTurbo(this, 505, 49, textureX, textureY); // Box 39
        body_colored_primary[40] = new ModelRendererTurbo(this, 369, 57, textureX, textureY); // Box 40
        body_colored_primary[41] = new ModelRendererTurbo(this, 377, 57, textureX, textureY); // Box 41
        body_colored_primary[42] = new ModelRendererTurbo(this, 385, 57, textureX, textureY); // Box 44
        body_colored_primary[43] = new ModelRendererTurbo(this, 473, 65, textureX, textureY); // Box 45
        body_colored_primary[44] = new ModelRendererTurbo(this, 481, 65, textureX, textureY); // Box 46
        body_colored_primary[45] = new ModelRendererTurbo(this, 489, 65, textureX, textureY); // Box 47
        body_colored_primary[46] = new ModelRendererTurbo(this, 497, 97, textureX, textureY); // Box 48
        body_colored_primary[47] = new ModelRendererTurbo(this, 505, 97, textureX, textureY); // Box 49
        body_colored_primary[48] = new ModelRendererTurbo(this, 369, 113, textureX, textureY); // Box 50
        body_colored_primary[49] = new ModelRendererTurbo(this, 481, 113, textureX, textureY); // Box 52
        body_colored_primary[50] = new ModelRendererTurbo(this, 489, 113, textureX, textureY); // Box 53
        body_colored_primary[51] = new ModelRendererTurbo(this, 497, 145, textureX, textureY); // Box 54
        body_colored_primary[52] = new ModelRendererTurbo(this, 505, 145, textureX, textureY); // Box 55
        body_colored_primary[53] = new ModelRendererTurbo(this, 1, 153, textureX, textureY); // Box 56
        body_colored_primary[54] = new ModelRendererTurbo(this, 9, 153, textureX, textureY); // Box 57
        body_colored_primary[55] = new ModelRendererTurbo(this, 337, 153, textureX, textureY); // Box 68
        body_colored_primary[56] = new ModelRendererTurbo(this, 249, 161, textureX, textureY); // Box 69
        body_colored_primary[57] = new ModelRendererTurbo(this, 385, 161, textureX, textureY); // Box 70
        body_colored_primary[58] = new ModelRendererTurbo(this, 305, 201, textureX, textureY); // Box 71
        body_colored_primary[59] = new ModelRendererTurbo(this, 1, 209, textureX, textureY); // Box 72
        body_colored_primary[60] = new ModelRendererTurbo(this, 97, 209, textureX, textureY); // Box 73
        body_colored_primary[61] = new ModelRendererTurbo(this, 193, 209, textureX, textureY); // Box 74
        body_colored_primary[62] = new ModelRendererTurbo(this, 361, 209, textureX, textureY); // Box 75
        body_colored_primary[63] = new ModelRendererTurbo(this, 249, 217, textureX, textureY); // Box 76
        body_colored_primary[64] = new ModelRendererTurbo(this, 417, 217, textureX, textureY); // Box 77
        body_colored_primary[65] = new ModelRendererTurbo(this, 305, 249, textureX, textureY); // Box 78
        body_colored_primary[66] = new ModelRendererTurbo(this, 1, 257, textureX, textureY); // Box 79
        body_colored_primary[67] = new ModelRendererTurbo(this, 97, 257, textureX, textureY); // Box 80
        body_colored_primary[68] = new ModelRendererTurbo(this, 193, 257, textureX, textureY); // Box 81
        body_colored_primary[69] = new ModelRendererTurbo(this, 385, 17, textureX, textureY); // Box 84
        body_colored_primary[70] = new ModelRendererTurbo(this, 1, 65, textureX, textureY); // Box 85
        body_colored_primary[71] = new ModelRendererTurbo(this, 49, 65, textureX, textureY); // Box 86
        body_colored_primary[72] = new ModelRendererTurbo(this, 425, 65, textureX, textureY); // Box 87
        body_colored_primary[73] = new ModelRendererTurbo(this, 313, 73, textureX, textureY); // Box 88
        body_colored_primary[74] = new ModelRendererTurbo(this, 209, 161, textureX, textureY); // Box 89
        body_colored_primary[75] = new ModelRendererTurbo(this, 241, 169, textureX, textureY); // Box 90
        body_colored_primary[76] = new ModelRendererTurbo(this, 57, 209, textureX, textureY); // Box 91
        body_colored_primary[77] = new ModelRendererTurbo(this, 17, 153, textureX, textureY); // Box 51
        body_colored_primary[78] = new ModelRendererTurbo(this, 417, 25, textureX, textureY); // Box 121
        body_colored_primary[79] = new ModelRendererTurbo(this, 473, 209, textureX, textureY); // Box 1
        body_colored_primary[80] = new ModelRendererTurbo(this, 361, 257, textureX, textureY); // Box 2
        body_colored_primary[81] = new ModelRendererTurbo(this, 457, 265, textureX, textureY); // Box 3
        body_colored_primary[82] = new ModelRendererTurbo(this, 249, 297, textureX, textureY); // Box 4
        body_colored_primary[83] = new ModelRendererTurbo(this, 1, 305, textureX, textureY); // Box 5
        body_colored_primary[84] = new ModelRendererTurbo(this, 153, 209, textureX, textureY); // Box 6
        body_colored_primary[85] = new ModelRendererTurbo(this, 97, 65, textureX, textureY); // Box 7
        body_colored_primary[86] = new ModelRendererTurbo(this, 393, 65, textureX, textureY); // Box 9
        body_colored_primary[87] = new ModelRendererTurbo(this, 57, 305, textureX, textureY); // Box 57
        body_colored_primary[88] = new ModelRendererTurbo(this, 153, 305, textureX, textureY); // Box 58
        body_colored_primary[89] = new ModelRendererTurbo(this, 97, 97, textureX, textureY); // Box 59
        body_colored_primary[90] = new ModelRendererTurbo(this, 257, 105, textureX, textureY); // Box 60
        body_colored_primary[91] = new ModelRendererTurbo(this, 425, 105, textureX, textureY); // Box 61
        body_colored_primary[92] = new ModelRendererTurbo(this, 41, 153, textureX, textureY); // Box 62
        body_colored_primary[93] = new ModelRendererTurbo(this, 73, 153, textureX, textureY); // Box 63
        body_colored_primary[94] = new ModelRendererTurbo(this, 105, 153, textureX, textureY); // Box 64
        body_colored_primary[95] = new ModelRendererTurbo(this, 409, 153, textureX, textureY); // Box 65
        body_colored_primary[96] = new ModelRendererTurbo(this, 241, 161, textureX, textureY); // Box 66
        body_colored_primary[97] = new ModelRendererTurbo(this, 89, 217, textureX, textureY); // Box 84
        body_colored_primary[98] = new ModelRendererTurbo(this, 193, 217, textureX, textureY); // Box 85
        body_colored_primary[99] = new ModelRendererTurbo(this, 249, 217, textureX, textureY); // Box 86
        body_colored_primary[100] = new ModelRendererTurbo(this, 305, 217, textureX, textureY); // Box 87
        body_colored_primary[101] = new ModelRendererTurbo(this, 361, 217, textureX, textureY); // Box 88
        body_colored_primary[102] = new ModelRendererTurbo(this, 417, 217, textureX, textureY); // Box 89
        body_colored_primary[103] = new ModelRendererTurbo(this, 89, 225, textureX, textureY); // Box 90

        body_colored_primary[0].addBox(0F, 0F, 0F, 14, 12, 47, 0F); // Box 0
        body_colored_primary[0].setRotationPoint(-47.5F, -14.5F, -23.5F);

        body_colored_primary[1].addBox(0F, 0F, 0F, 2, 3, 48, 0F); // Box 0
        body_colored_primary[1].setRotationPoint(46F, -3F, -24F);

        body_colored_primary[2].addBox(0F, 0F, 0F, 92, 1, 2, 0F); // Box 1
        body_colored_primary[2].setRotationPoint(-46F, -1F, 22F);

        body_colored_primary[3].addBox(0F, 0F, 0F, 2, 3, 48, 0F); // Box 2
        body_colored_primary[3].setRotationPoint(-48F, -3F, -24F);

        body_colored_primary[4].addBox(0F, 0F, 0F, 92, 1, 2, 0F); // Box 3
        body_colored_primary[4].setRotationPoint(-46F, -1F, -24F);

        body_colored_primary[5].addBox(0F, 0F, 0F, 92, 1, 2, 0F); // Box 4
        body_colored_primary[5].setRotationPoint(-46F, -3F, 22F);

        body_colored_primary[6].addBox(0F, 0F, 0F, 92, 1, 2, 0F); // Box 5
        body_colored_primary[6].setRotationPoint(-46F, -3F, -24F);

        body_colored_primary[7].addBox(0F, 0F, 0F, 24, 1, 2, 0F); // Box 6
        body_colored_primary[7].setRotationPoint(22F, -2F, -24F);

        body_colored_primary[8].addBox(0F, 0F, 0F, 24, 1, 2, 0F); // Box 7
        body_colored_primary[8].setRotationPoint(-46F, -2F, -24F);

        body_colored_primary[9].addBox(0F, 0F, 0F, 36, 1, 2, 0F); // Box 8
        body_colored_primary[9].setRotationPoint(-18F, -2F, -24F);

        body_colored_primary[10].addBox(0F, 0F, 0F, 24, 1, 2, 0F); // Box 9
        body_colored_primary[10].setRotationPoint(22F, -2F, 22F);

        body_colored_primary[11].addBox(0F, 0F, 0F, 24, 1, 2, 0F); // Box 10
        body_colored_primary[11].setRotationPoint(-46F, -2F, 22F);

        body_colored_primary[12].addBox(0F, 0F, 0F, 36, 1, 2, 0F); // Box 11
        body_colored_primary[12].setRotationPoint(-18F, -2F, 22F);

        body_colored_primary[13].addBox(0F, 0F, 0F, 92, 1, 44, 0F); // Box 12
        body_colored_primary[13].setRotationPoint(-46F, -3F, -22F);

        body_colored_primary[14].addBox(0F, 0F, 0F, 2, 43, 2, 0F); // Box 13
        body_colored_primary[14].setRotationPoint(46F, -46F, 22F);

        body_colored_primary[15].addBox(0F, 0F, 0F, 2, 43, 2, 0F); // Box 14
        body_colored_primary[15].setRotationPoint(46F, -46F, -24F);

        body_colored_primary[16].addBox(0F, 0F, 0F, 2, 43, 2, 0F); // Box 15
        body_colored_primary[16].setRotationPoint(-48F, -46F, -24F);

        body_colored_primary[17].addBox(0F, 0F, 0F, 2, 43, 2, 0F); // Box 16
        body_colored_primary[17].setRotationPoint(-48F, -46F, 22F);

        body_colored_primary[18].addBox(0F, 0F, 0F, 2, 2, 48, 0F); // Box 17
        body_colored_primary[18].setRotationPoint(-48F, -48F, -24F);

        body_colored_primary[19].addBox(0F, 0F, 0F, 2, 2, 48, 0F); // Box 18
        body_colored_primary[19].setRotationPoint(46F, -48F, -24F);

        body_colored_primary[20].addBox(0F, 0F, 0F, 92, 2, 2, 0F); // Box 20
        body_colored_primary[20].setRotationPoint(-46F, -48F, 22F);

        body_colored_primary[21].addBox(0F, 0F, 0F, 92, 2, 2, 0F); // Box 21
        body_colored_primary[21].setRotationPoint(-46F, -48F, -24F);

        body_colored_primary[22].addBox(0F, 0F, 0F, 78, 43, 1, 0F); // Box 22
        body_colored_primary[22].setRotationPoint(-32F, -46F, 22.5F);

        body_colored_primary[23].addBox(0F, 0F, 0F, 78, 43, 1, 0F); // Box 23
        body_colored_primary[23].setRotationPoint(-32F, -46F, -23.5F);

        body_colored_primary[24].addBox(0F, 0F, 0F, 78, 1, 44, 0F); // Box 24
        body_colored_primary[24].setRotationPoint(-32F, -47.5F, -22F);

        body_colored_primary[25].addBox(0F, 0F, 0F, 1, 43, 44, 0F); // Box 25
        body_colored_primary[25].setRotationPoint(-33.5F, -46F, -22F);

        body_colored_primary[26].addBox(0F, 0F, 0F, 1, 44, 22, 0F); // Box 26
        body_colored_primary[26].setRotationPoint(46.5F, -46F, -22F);

        body_colored_primary[27].addBox(0F, 0F, -22F, 1, 44, 22, 0F); // Box 27
        body_colored_primary[27].setRotationPoint(46.5F, -46F, 22F);

        body_colored_primary[28].addShapeBox(0F, 0F, 0F, 1, 43, 1, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 28
        body_colored_primary[28].setRotationPoint(45F, -46F, 23F);

        body_colored_primary[29].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 29
        body_colored_primary[29].setRotationPoint(39F, -46F, 23F);

        body_colored_primary[30].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 30
        body_colored_primary[30].setRotationPoint(33F, -46F, 23F);

        body_colored_primary[31].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 31
        body_colored_primary[31].setRotationPoint(27F, -46F, 23F);

        body_colored_primary[32].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 32
        body_colored_primary[32].setRotationPoint(21F, -46F, 23F);

        body_colored_primary[33].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 33
        body_colored_primary[33].setRotationPoint(15F, -46F, 23F);

        body_colored_primary[34].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 34
        body_colored_primary[34].setRotationPoint(9F, -46F, 23F);

        body_colored_primary[35].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 35
        body_colored_primary[35].setRotationPoint(3F, -46F, 23F);

        body_colored_primary[36].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 36
        body_colored_primary[36].setRotationPoint(-3F, -46F, 23F);

        body_colored_primary[37].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 37
        body_colored_primary[37].setRotationPoint(-9F, -46F, 23F);

        body_colored_primary[38].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 38
        body_colored_primary[38].setRotationPoint(-15F, -46F, 23F);

        body_colored_primary[39].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 39
        body_colored_primary[39].setRotationPoint(-21F, -46F, 23F);

        body_colored_primary[40].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 40
        body_colored_primary[40].setRotationPoint(-27F, -46F, 23F);

        body_colored_primary[41].addShapeBox(0F, 0F, 0F, 1, 43, 1, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 41
        body_colored_primary[41].setRotationPoint(-32F, -46F, 23F);

        body_colored_primary[42].addShapeBox(0F, 0F, 0F, 1, 43, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F); // Box 44
        body_colored_primary[42].setRotationPoint(45F, -46F, -24F);

        body_colored_primary[43].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F); // Box 45
        body_colored_primary[43].setRotationPoint(39F, -46F, -24F);

        body_colored_primary[44].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F); // Box 46
        body_colored_primary[44].setRotationPoint(33F, -46F, -24F);

        body_colored_primary[45].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F); // Box 47
        body_colored_primary[45].setRotationPoint(27F, -46F, -24F);

        body_colored_primary[46].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F); // Box 48
        body_colored_primary[46].setRotationPoint(21F, -46F, -24F);

        body_colored_primary[47].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F); // Box 49
        body_colored_primary[47].setRotationPoint(15F, -46F, -24F);

        body_colored_primary[48].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F); // Box 50
        body_colored_primary[48].setRotationPoint(9F, -46F, -24F);

        body_colored_primary[49].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F); // Box 52
        body_colored_primary[49].setRotationPoint(-3F, -46F, -24F);

        body_colored_primary[50].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F); // Box 53
        body_colored_primary[50].setRotationPoint(-9F, -46F, -24F);

        body_colored_primary[51].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F); // Box 54
        body_colored_primary[51].setRotationPoint(-15F, -46F, -24F);

        body_colored_primary[52].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F); // Box 55
        body_colored_primary[52].setRotationPoint(-21F, -46F, -24F);

        body_colored_primary[53].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F); // Box 56
        body_colored_primary[53].setRotationPoint(-27F, -46F, -24F);

        body_colored_primary[54].addShapeBox(0F, 0F, 0F, 1, 43, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F); // Box 57
        body_colored_primary[54].setRotationPoint(-32F, -46F, -24F);

        body_colored_primary[55].addShapeBox(0F, 0F, 0F, 1, 1, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F); // Box 68
        body_colored_primary[55].setRotationPoint(45F, -48F, -22F);

        body_colored_primary[56].addShapeBox(0F, 0F, 0F, 2, 1, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F); // Box 69
        body_colored_primary[56].setRotationPoint(39F, -48F, -22F);

        body_colored_primary[57].addShapeBox(0F, 0F, 0F, 2, 1, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F); // Box 70
        body_colored_primary[57].setRotationPoint(33F, -48F, -22F);

        body_colored_primary[58].addShapeBox(0F, 0F, 0F, 2, 1, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F); // Box 71
        body_colored_primary[58].setRotationPoint(27F, -48F, -22F);

        body_colored_primary[59].addShapeBox(0F, 0F, 0F, 2, 1, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F); // Box 72
        body_colored_primary[59].setRotationPoint(21F, -48F, -22F);

        body_colored_primary[60].addShapeBox(0F, 0F, 0F, 2, 1, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F); // Box 73
        body_colored_primary[60].setRotationPoint(15F, -48F, -22F);

        body_colored_primary[61].addShapeBox(0F, 0F, 0F, 2, 1, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F); // Box 74
        body_colored_primary[61].setRotationPoint(9F, -48F, -22F);

        body_colored_primary[62].addShapeBox(0F, 0F, 0F, 2, 1, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F); // Box 75
        body_colored_primary[62].setRotationPoint(3F, -48F, -22F);

        body_colored_primary[63].addShapeBox(0F, 0F, 0F, 2, 1, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F); // Box 76
        body_colored_primary[63].setRotationPoint(-3F, -48F, -22F);

        body_colored_primary[64].addShapeBox(0F, 0F, 0F, 2, 1, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F); // Box 77
        body_colored_primary[64].setRotationPoint(-9F, -48F, -22F);

        body_colored_primary[65].addShapeBox(0F, 0F, 0F, 2, 1, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F); // Box 78
        body_colored_primary[65].setRotationPoint(-15F, -48F, -22F);

        body_colored_primary[66].addShapeBox(0F, 0F, 0F, 2, 1, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F); // Box 79
        body_colored_primary[66].setRotationPoint(-21F, -48F, -22F);

        body_colored_primary[67].addShapeBox(0F, 0F, 0F, 2, 1, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F); // Box 80
        body_colored_primary[67].setRotationPoint(-27F, -48F, -22F);

        body_colored_primary[68].addShapeBox(0F, 0F, 0F, 4, 1, 44, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F); // Box 81
        body_colored_primary[68].setRotationPoint(-35F, -48F, -22F);

        body_colored_primary[69].addShapeBox(1F, 0F, 0F, 1, 5, 22, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 1F, 0F); // Box 84
        body_colored_primary[69].setRotationPoint(46.5F, -46F, -22F);

        body_colored_primary[70].addShapeBox(1F, 37F, 0F, 1, 6, 22, 0F, 0F, 1F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F); // Box 85
        body_colored_primary[70].setRotationPoint(46.5F, -46F, -22F);

        body_colored_primary[71].addShapeBox(1F, 9F, 0F, 1, 10, 22, 0F, 0F, 1F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 1F, 0F); // Box 86
        body_colored_primary[71].setRotationPoint(46.5F, -46F, -22F);

        body_colored_primary[72].addShapeBox(1F, 23F, 0F, 1, 10, 22, 0F, 0F, 1F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 1F, 0F); // Box 87
        body_colored_primary[72].setRotationPoint(46.5F, -46F, -22F);

        body_colored_primary[73].addShapeBox(1F, 0F, -22F, 1, 5, 22, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 1F, 0F); // Box 88
        body_colored_primary[73].setRotationPoint(46.5F, -46F, 22F);

        body_colored_primary[74].addShapeBox(1F, 37F, -22F, 1, 6, 22, 0F, 0F, 1F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F); // Box 89
        body_colored_primary[74].setRotationPoint(46.5F, -46F, 22F);

        body_colored_primary[75].addShapeBox(1F, 9F, -22F, 1, 10, 22, 0F, 0F, 1F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 1F, 0F); // Box 90
        body_colored_primary[75].setRotationPoint(46.5F, -46F, 22F);

        body_colored_primary[76].addShapeBox(1F, 23F, -22F, 1, 10, 22, 0F, 0F, 1F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 1F, 0F); // Box 91
        body_colored_primary[76].setRotationPoint(46.5F, -46F, 22F);

        body_colored_primary[77].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F); // Box 51
        body_colored_primary[77].setRotationPoint(3F, -46F, -24F);

        body_colored_primary[78].addShapeBox(1.5F, 26.5F, -5F, 1, 1, 1, 0F, 0F, 0.5F, -0.1F, -0.4F, 0F, -0.1F, -0.4F, 0F, -0.1F, 0F, 0.5F, -0.1F, 0F, 0.5F, -0.1F, -0.4F, 0F, -0.1F, -0.4F, 0F, -0.1F, 0F, 0.5F, -0.1F); // Box 121
        body_colored_primary[78].setRotationPoint(46.5F, -46F, 22F);

        body_colored_primary[79].addBox(0F, 0F, 0F, 2, 43, 2, 0F); // Box 1
        body_colored_primary[79].setRotationPoint(-34F, -46F, 22F);

        body_colored_primary[80].addBox(0F, 0F, 0F, 2, 2, 44, 0F); // Box 2
        body_colored_primary[80].setRotationPoint(-34F, -48F, -22F);

        body_colored_primary[81].addBox(0F, 0F, 0F, 2, 43, 2, 0F); // Box 3
        body_colored_primary[81].setRotationPoint(-34F, -46F, -24F);

        body_colored_primary[82].addBox(0F, 0F, 0F, 14, 12, 47, 0F); // Box 4
        body_colored_primary[82].setRotationPoint(-47.5F, -47.5F, -23.5F);

        body_colored_primary[83].addBox(0F, 0F, 0F, 4, 21, 47, 0F); // Box 5
        body_colored_primary[83].setRotationPoint(-37.5F, -35.5F, -23.5F);

        body_colored_primary[84].addBox(0F, 0F, 0F, 10, 21, 14, 0F); // Box 6
        body_colored_primary[84].setRotationPoint(-47.5F, -35.5F, -23.5F);

        body_colored_primary[85].addBox(0F, 0F, 0F, 10, 21, 3, 0F); // Box 7
        body_colored_primary[85].setRotationPoint(-47.5F, -35.5F, 20.5F);

        body_colored_primary[86].addBox(0F, 0F, 0F, 10, 21, 2, 0F); // Box 9
        body_colored_primary[86].setRotationPoint(-47.5F, -35.5F, 6.5F);

        body_colored_primary[87].addShapeBox(0F, 0F, 0F, 1, 1, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F); // Box 57
        body_colored_primary[87].setRotationPoint(-46F, -48F, -22F);

        body_colored_primary[88].addShapeBox(0F, 0F, 0F, 2, 1, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F); // Box 58
        body_colored_primary[88].setRotationPoint(-41F, -48F, -22F);

        body_colored_primary[89].addBox(0F, 0F, 0F, 12, 1, 1, 0F); // Box 59
        body_colored_primary[89].setRotationPoint(-46F, -7F, 23F);

        body_colored_primary[90].addBox(0F, 0F, 0F, 12, 1, 1, 0F); // Box 60
        body_colored_primary[90].setRotationPoint(-46F, -13F, 23F);

        body_colored_primary[91].addBox(0F, 0F, 0F, 12, 1, 1, 0F); // Box 61
        body_colored_primary[91].setRotationPoint(-46F, -19F, 23F);

        body_colored_primary[92].addBox(0F, 0F, 0F, 12, 1, 1, 0F); // Box 62
        body_colored_primary[92].setRotationPoint(-46F, -25F, 23F);

        body_colored_primary[93].addBox(0F, 0F, 0F, 12, 1, 1, 0F); // Box 63
        body_colored_primary[93].setRotationPoint(-46F, -31F, 23F);

        body_colored_primary[94].addBox(0F, 0F, 0F, 12, 1, 1, 0F); // Box 64
        body_colored_primary[94].setRotationPoint(-46F, -37F, 23F);

        body_colored_primary[95].addBox(0F, 0F, 0F, 12, 1, 1, 0F); // Box 65
        body_colored_primary[95].setRotationPoint(-46F, -43F, 23F);

        body_colored_primary[96].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 66
        body_colored_primary[96].setRotationPoint(-46F, -13F, -24F);

        body_colored_primary[97].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F); // Box 84
        body_colored_primary[97].setRotationPoint(-46F, -23F, -24F);

        body_colored_primary[98].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F); // Box 85
        body_colored_primary[98].setRotationPoint(-46F, -18F, -24F);

        body_colored_primary[99].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F); // Box 86
        body_colored_primary[99].setRotationPoint(-46F, -28F, -24F);

        body_colored_primary[100].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F); // Box 87
        body_colored_primary[100].setRotationPoint(-46F, -33F, -24F);

        body_colored_primary[101].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F); // Box 88
        body_colored_primary[101].setRotationPoint(-46F, -46F, -24F);

        body_colored_primary[102].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F); // Box 89
        body_colored_primary[102].setRotationPoint(-46F, -38F, -24F);

        body_colored_primary[103].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F); // Box 90
        body_colored_primary[103].setRotationPoint(-46F, -42F, -24F);

        body = new ModelRendererTurbo[55];
        body[0] = new ModelRendererTurbo(this, 137, 1, textureX, textureY); // Box 92
        body[1] = new ModelRendererTurbo(this, 145, 1, textureX, textureY); // Box 93
        body[2] = new ModelRendererTurbo(this, 153, 1, textureX, textureY); // Box 94
        body[3] = new ModelRendererTurbo(this, 385, 17, textureX, textureY); // Box 95
        body[4] = new ModelRendererTurbo(this, 393, 17, textureX, textureY); // Box 97
        body[5] = new ModelRendererTurbo(this, 401, 17, textureX, textureY); // Box 98
        body[6] = new ModelRendererTurbo(this, 417, 17, textureX, textureY); // Box 99
        body[7] = new ModelRendererTurbo(this, 425, 17, textureX, textureY); // Box 100
        body[8] = new ModelRendererTurbo(this, 433, 17, textureX, textureY); // Box 101
        body[9] = new ModelRendererTurbo(this, 81, 25, textureX, textureY); // Box 102
        body[10] = new ModelRendererTurbo(this, 89, 25, textureX, textureY); // Box 103
        body[11] = new ModelRendererTurbo(this, 97, 25, textureX, textureY); // Box 104
        body[12] = new ModelRendererTurbo(this, 105, 25, textureX, textureY); // Box 105
        body[13] = new ModelRendererTurbo(this, 113, 25, textureX, textureY); // Box 106
        body[14] = new ModelRendererTurbo(this, 121, 25, textureX, textureY); // Box 107
        body[15] = new ModelRendererTurbo(this, 129, 25, textureX, textureY); // Box 108
        body[16] = new ModelRendererTurbo(this, 25, 153, textureX, textureY); // Box 109
        body[17] = new ModelRendererTurbo(this, 33, 153, textureX, textureY); // Box 110
        body[18] = new ModelRendererTurbo(this, 441, 153, textureX, textureY); // Box 111
        body[19] = new ModelRendererTurbo(this, 497, 193, textureX, textureY); // Box 112
        body[20] = new ModelRendererTurbo(this, 129, 25, textureX, textureY); // Box 113
        body[21] = new ModelRendererTurbo(this, 385, 25, textureX, textureY); // Box 114
        body[22] = new ModelRendererTurbo(this, 417, 25, textureX, textureY); // Box 115
        body[23] = new ModelRendererTurbo(this, 81, 33, textureX, textureY); // Box 116
        body[24] = new ModelRendererTurbo(this, 145, 25, textureX, textureY); // Box 117
        body[25] = new ModelRendererTurbo(this, 153, 25, textureX, textureY); // Box 118
        body[26] = new ModelRendererTurbo(this, 385, 25, textureX, textureY); // Box 119
        body[27] = new ModelRendererTurbo(this, 401, 25, textureX, textureY); // Box 120
        body[28] = new ModelRendererTurbo(this, 433, 25, textureX, textureY); // Box 122
        body[29] = new ModelRendererTurbo(this, 81, 33, textureX, textureY); // Box 123
        body[30] = new ModelRendererTurbo(this, 97, 33, textureX, textureY); // Box 124
        body[31] = new ModelRendererTurbo(this, 105, 33, textureX, textureY); // Box 125
        body[32] = new ModelRendererTurbo(this, 57, 257, textureX, textureY); // Box 10
        body[33] = new ModelRendererTurbo(this, 385, 153, textureX, textureY); // Box 50
        body[34] = new ModelRendererTurbo(this, 385, 169, textureX, textureY); // Box 51
        body[35] = new ModelRendererTurbo(this, 305, 185, textureX, textureY); // Box 52
        body[36] = new ModelRendererTurbo(this, 321, 113, textureX, textureY); // Box 53
        body[37] = new ModelRendererTurbo(this, 1, 209, textureX, textureY); // Box 54
        body[38] = new ModelRendererTurbo(this, 329, 185, textureX, textureY); // Box 67
        body[39] = new ModelRendererTurbo(this, 385, 185, textureX, textureY); // Box 68
        body[40] = new ModelRendererTurbo(this, 209, 193, textureX, textureY); // Box 69
        body[41] = new ModelRendererTurbo(this, 337, 193, textureX, textureY); // Box 70
        body[42] = new ModelRendererTurbo(this, 385, 193, textureX, textureY); // Box 71
        body[43] = new ModelRendererTurbo(this, 1, 201, textureX, textureY); // Box 72
        body[44] = new ModelRendererTurbo(this, 209, 201, textureX, textureY); // Box 73
        body[45] = new ModelRendererTurbo(this, 305, 201, textureX, textureY); // Box 74
        body[46] = new ModelRendererTurbo(this, 361, 201, textureX, textureY); // Box 75
        body[47] = new ModelRendererTurbo(this, 393, 201, textureX, textureY); // Box 76
        body[48] = new ModelRendererTurbo(this, 89, 209, textureX, textureY); // Box 77
        body[49] = new ModelRendererTurbo(this, 193, 209, textureX, textureY); // Box 78
        body[50] = new ModelRendererTurbo(this, 249, 209, textureX, textureY); // Box 79
        body[51] = new ModelRendererTurbo(this, 281, 209, textureX, textureY); // Box 80
        body[52] = new ModelRendererTurbo(this, 313, 209, textureX, textureY); // Box 81
        body[53] = new ModelRendererTurbo(this, 361, 209, textureX, textureY); // Box 82
        body[54] = new ModelRendererTurbo(this, 417, 209, textureX, textureY); // Box 83

        body[0].addShapeBox(1.5F, -1.5F, 8F, 1, 1, 1, 0F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F); // Box 92
        body[0].setRotationPoint(46.5F, -46F, -22F);

        body[1].addShapeBox(1.5F, -1.5F, 18F, 1, 1, 1, 0F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F); // Box 93
        body[1].setRotationPoint(46.5F, -46F, -22F);

        body[2].addShapeBox(1.5F, 43.5F, 8F, 1, 1, 1, 0F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F); // Box 94
        body[2].setRotationPoint(46.5F, -46F, -22F);

        body[3].addShapeBox(1.5F, 43.5F, 18F, 1, 1, 1, 0F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F); // Box 95
        body[3].setRotationPoint(46.5F, -46F, -22F);

        body[4].addShapeBox(1.5F, -1.5F, -18F, 1, 1, 1, 0F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F); // Box 97
        body[4].setRotationPoint(46.5F, -46F, 22F);

        body[5].addShapeBox(1.5F, -1.5F, -8F, 1, 1, 1, 0F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F); // Box 98
        body[5].setRotationPoint(46.5F, -46F, 22F);

        body[6].addShapeBox(1.5F, 43.5F, -18F, 1, 1, 1, 0F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F); // Box 99
        body[6].setRotationPoint(46.5F, -46F, 22F);

        body[7].addShapeBox(1.5F, 43.5F, -8F, 1, 1, 1, 0F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F); // Box 100
        body[7].setRotationPoint(46.5F, -46F, 22F);

        body[8].addShapeBox(1.5F, 26.5F, -5F, 1, 1, 1, 0F, 0F, 0.5F, -0.1F, -0.4F, 0F, -0.1F, -0.4F, 0F, -0.1F, 0F, 0.5F, -0.1F, 0F, 0.5F, -0.1F, -0.4F, 0F, -0.1F, -0.4F, 0F, -0.1F, 0F, 0.5F, -0.1F); // Box 101
        body[8].setRotationPoint(46.5F, -46F, 22F);

        body[9].addShapeBox(1.5F, 1.5F, -18F, 1, 1, 1, 0F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F); // Box 102
        body[9].setRotationPoint(46.5F, -46F, 22F);

        body[10].addShapeBox(1.5F, 1.5F, 18F, 1, 1, 1, 0F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F); // Box 103
        body[10].setRotationPoint(46.5F, -46F, -22F);

        body[11].addShapeBox(1.5F, 1.5F, 8F, 1, 1, 1, 0F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F); // Box 104
        body[11].setRotationPoint(46.5F, -46F, -22F);

        body[12].addShapeBox(1.5F, 40.5F, -8F, 1, 1, 1, 0F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F); // Box 105
        body[12].setRotationPoint(46.5F, -46F, 22F);

        body[13].addShapeBox(1.5F, 40.5F, -18F, 1, 1, 1, 0F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F); // Box 106
        body[13].setRotationPoint(46.5F, -46F, 22F);

        body[14].addShapeBox(1.5F, 40.5F, 18F, 1, 1, 1, 0F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F); // Box 107
        body[14].setRotationPoint(46.5F, -46F, -22F);

        body[15].addShapeBox(1.5F, 40.5F, 8F, 1, 1, 1, 0F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F); // Box 108
        body[15].setRotationPoint(46.5F, -46F, -22F);

        body[16].addShapeBox(1.5F, 0F, -8F, 1, 46, 1, 0F, 0F, 0.4F, -0.2F, -0.6F, 0.4F, -0.2F, -0.6F, 0.4F, -0.2F, 0F, 0.4F, -0.2F, 0F, 0.4F, -0.2F, -0.6F, 0.4F, -0.2F, -0.6F, 0.4F, -0.2F, 0F, 0.4F, -0.2F); // Box 109
        body[16].setRotationPoint(46.5F, -47.5F, 22F);

        body[17].addShapeBox(1.5F, 0F, -18F, 1, 46, 1, 0F, 0F, 0.4F, -0.2F, -0.6F, 0.4F, -0.2F, -0.6F, 0.4F, -0.2F, 0F, 0.4F, -0.2F, 0F, 0.4F, -0.2F, -0.6F, 0.4F, -0.2F, -0.6F, 0.4F, -0.2F, 0F, 0.4F, -0.2F); // Box 110
        body[17].setRotationPoint(46.5F, -47.5F, 22F);

        body[18].addShapeBox(1.5F, 0F, 18F, 1, 46, 1, 0F, 0F, 0.4F, -0.2F, -0.6F, 0.4F, -0.2F, -0.6F, 0.4F, -0.2F, 0F, 0.4F, -0.2F, 0F, 0.4F, -0.2F, -0.6F, 0.4F, -0.2F, -0.6F, 0.4F, -0.2F, 0F, 0.4F, -0.2F); // Box 111
        body[18].setRotationPoint(46.5F, -47.5F, -22F);

        body[19].addShapeBox(1.5F, 0F, 8F, 1, 46, 1, 0F, 0F, 0.4F, -0.2F, -0.6F, 0.4F, -0.2F, -0.6F, 0.4F, -0.2F, 0F, 0.4F, -0.2F, 0F, 0.4F, -0.2F, -0.6F, 0.4F, -0.2F, -0.6F, 0.4F, -0.2F, 0F, 0.4F, -0.2F); // Box 112
        body[19].setRotationPoint(46.5F, -47.5F, -22F);

        body[20].addShapeBox(1.5F, 10F, 2F, 1, 1, 7, 0F, 0F, -0.2F, -0.2F, -0.6F, -0.2F, -0.2F, -0.6F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, -0.6F, -0.2F, -0.2F, -0.6F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 113
        body[20].setRotationPoint(46.5F, -29.5F, -22F);

        body[21].addShapeBox(1.5F, 12F, 12F, 1, 1, 7, 0F, 0F, -0.2F, -0.2F, -0.6F, -0.2F, -0.2F, -0.6F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, -0.6F, -0.2F, -0.2F, -0.6F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 114
        body[21].setRotationPoint(46.5F, -29.5F, -22F);

        body[22].addShapeBox(1.5F, 12F, -18F, 1, 1, 7, 0F, 0F, -0.2F, -0.2F, -0.6F, -0.2F, -0.2F, -0.6F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, -0.6F, -0.2F, -0.2F, -0.6F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 115
        body[22].setRotationPoint(46.5F, -29.5F, 22F);

        body[23].addShapeBox(1.5F, 10F, -8F, 1, 1, 7, 0F, 0F, -0.2F, -0.2F, -0.6F, -0.2F, -0.2F, -0.6F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, -0.6F, -0.2F, -0.2F, -0.6F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 116
        body[23].setRotationPoint(46.5F, -29.5F, 22F);

        body[24].addShapeBox(1.5F, 26.5F, -8F, 1, 1, 1, 0F, 0F, 0.2F, 0.2F, -0.4F, 0.2F, 0.2F, -0.4F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, -0.4F, 0.2F, 0.2F, -0.4F, 0.2F, 0.2F, 0F, 0.2F, 0.2F); // Box 117
        body[24].setRotationPoint(46.5F, -46F, 22F);

        body[25].addShapeBox(1.5F, 28.5F, -18F, 1, 1, 1, 0F, 0F, 0.2F, 0.2F, -0.4F, 0.2F, 0.2F, -0.4F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, -0.4F, 0.2F, 0.2F, -0.4F, 0.2F, 0.2F, 0F, 0.2F, 0.2F); // Box 118
        body[25].setRotationPoint(46.5F, -46F, 22F);

        body[26].addShapeBox(1.5F, 28.5F, 18F, 1, 1, 1, 0F, 0F, 0.2F, 0.2F, -0.4F, 0.2F, 0.2F, -0.4F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, -0.4F, 0.2F, 0.2F, -0.4F, 0.2F, 0.2F, 0F, 0.2F, 0.2F); // Box 119
        body[26].setRotationPoint(46.5F, -46F, -22F);

        body[27].addShapeBox(1.5F, 26.5F, 8F, 1, 1, 1, 0F, 0F, 0.2F, 0.2F, -0.4F, 0.2F, 0.2F, -0.4F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, -0.4F, 0.2F, 0.2F, -0.4F, 0.2F, 0.2F, 0F, 0.2F, 0.2F); // Box 120
        body[27].setRotationPoint(46.5F, -46F, -22F);

        body[28].addShapeBox(1.5F, 1.5F, -8F, 1, 1, 1, 0F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F); // Box 122
        body[28].setRotationPoint(46.5F, -46F, 22F);

        body[29].addShapeBox(1.5F, 28.5F, -15F, 1, 1, 1, 0F, 0F, 0.5F, -0.1F, -0.4F, 0F, -0.1F, -0.4F, 0F, -0.1F, 0F, 0.5F, -0.1F, 0F, 0.5F, -0.1F, -0.4F, 0F, -0.1F, -0.4F, 0F, -0.1F, 0F, 0.5F, -0.1F); // Box 123
        body[29].setRotationPoint(46.5F, -46F, 22F);

        body[30].addShapeBox(1.5F, 28.5F, 15F, 1, 1, 1, 0F, 0F, 0.5F, -0.1F, -0.4F, 0F, -0.1F, -0.4F, 0F, -0.1F, 0F, 0.5F, -0.1F, 0F, 0.5F, -0.1F, -0.4F, 0F, -0.1F, -0.4F, 0F, -0.1F, 0F, 0.5F, -0.1F); // Box 124
        body[30].setRotationPoint(46.5F, -46F, -22F);

        body[31].addShapeBox(1.5F, 26.5F, 5F, 1, 1, 1, 0F, 0F, 0.5F, -0.1F, -0.4F, 0F, -0.1F, -0.4F, 0F, -0.1F, 0F, 0.5F, -0.1F, 0F, 0.5F, -0.1F, -0.4F, 0F, -0.1F, -0.4F, 0F, -0.1F, 0F, 0.5F, -0.1F); // Box 125
        body[31].setRotationPoint(46.5F, -46F, -22F);

        body[32].addShapeBox(0F, 0F, 0F, 10, 5, 16, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 10
        body[32].setRotationPoint(-47.5F, -19.5F, -9.5F);

        body[33].addBox(0F, 0F, 0F, 4, 2, 8, 0F); // Box 50
        body[33].setRotationPoint(-43F, -18F, 11F);

        body[34].addShapeBox(0F, 0F, 0F, 4, 1, 8, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -1F, -1F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 51
        body[34].setRotationPoint(-43F, -19F, 11F);

        body[35].addShapeBox(0F, 0F, 0F, 4, 1, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -1F, -1F, 0F, -1F); // Box 52
        body[35].setRotationPoint(-43F, -16F, 11F);

        body[36].addBox(0F, 0F, 0F, 4, 6, 2, 0F); // Box 53
        body[36].setRotationPoint(-43F, -20F, 9F);

        body[37].addShapeBox(0F, 0F, 0F, 8, 16, 12, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 54
        body[37].setRotationPoint(-45.5F, -35.5F, 8.5F);

        body[38].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 67
        body[38].setRotationPoint(-46F, -12F, -23.8F);

        body[39].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 68
        body[39].setRotationPoint(-46F, -11.5F, -23.8F);

        body[40].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 69
        body[40].setRotationPoint(-46F, -11F, -23.8F);

        body[41].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 70
        body[41].setRotationPoint(-46F, -10.5F, -23.8F);

        body[42].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 71
        body[42].setRotationPoint(-46F, -10F, -23.8F);

        body[43].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 72
        body[43].setRotationPoint(-46F, -9.5F, -23.8F);

        body[44].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 73
        body[44].setRotationPoint(-46F, -9F, -23.8F);

        body[45].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 74
        body[45].setRotationPoint(-46F, -8.5F, -23.8F);

        body[46].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 75
        body[46].setRotationPoint(-46F, -8F, -23.8F);

        body[47].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 76
        body[47].setRotationPoint(-46F, -7.5F, -23.8F);

        body[48].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 77
        body[48].setRotationPoint(-46F, -7F, -23.8F);

        body[49].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 78
        body[49].setRotationPoint(-46F, -6.5F, -23.8F);

        body[50].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 79
        body[50].setRotationPoint(-46F, -6F, -23.8F);

        body[51].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 80
        body[51].setRotationPoint(-46F, -5.5F, -23.8F);

        body[52].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 81
        body[52].setRotationPoint(-46F, -5F, -23.8F);

        body[53].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 82
        body[53].setRotationPoint(-46F, -4.5F, -23.8F);

        body[54].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 83
        body[54].setRotationPoint(-46F, -4F, -23.8F);

        other = new ModelRendererTurbo[5];
        other[0] = new ModelRendererTurbo(this, 33, 65, textureX, textureY); // Box 8
        other[1] = new ModelRendererTurbo(this, 105, 217, textureX, textureY); // Box 91
        other[2] = new ModelRendererTurbo(this, 249, 225, textureX, textureY); // Box 92
        other[3] = new ModelRendererTurbo(this, 305, 225, textureX, textureY); // Box 93
        other[4] = new ModelRendererTurbo(this, 361, 225, textureX, textureY); // Box 94

        other[0].addShapeBox(0F, 0F, 0F, 1, 2, 16, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F); // Box 8
        other[0].setRotationPoint(-47F, -34.5F, -9.5F);

        other[1].addShapeBox(0F, 0F, 0F, 1, 2, 16, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F); // Box 91
        other[1].setRotationPoint(-47F, -31.5F, -9.5F);

        other[2].addShapeBox(0F, 0F, 0F, 1, 2, 16, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F); // Box 92
        other[2].setRotationPoint(-47F, -28.5F, -9.5F);

        other[3].addShapeBox(0F, 0F, 0F, 1, 2, 16, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F); // Box 93
        other[3].setRotationPoint(-47F, -25.5F, -9.5F);

        other[4].addShapeBox(0F, 0F, 0F, 1, 2, 16, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F); // Box 94
        other[4].setRotationPoint(-47F, -22.5F, -9.5F);

        rot = new ModelRendererTurbo[39];
        rot[0] = new ModelRendererTurbo(this, 113, 33, textureX, textureY); // Box 11
        rot[1] = new ModelRendererTurbo(this, 97, 41, textureX, textureY); // Box 12
        rot[2] = new ModelRendererTurbo(this, 121, 41, textureX, textureY); // Box 13
        rot[3] = new ModelRendererTurbo(this, 145, 33, textureX, textureY); // Box 14
        rot[4] = new ModelRendererTurbo(this, 145, 41, textureX, textureY); // Box 15
        rot[5] = new ModelRendererTurbo(this, 233, 49, textureX, textureY); // Box 16
        rot[6] = new ModelRendererTurbo(this, 249, 49, textureX, textureY); // Box 17
        rot[7] = new ModelRendererTurbo(this, 265, 49, textureX, textureY); // Box 18
        rot[8] = new ModelRendererTurbo(this, 281, 49, textureX, textureY); // Box 19
        rot[9] = new ModelRendererTurbo(this, 297, 49, textureX, textureY); // Box 20
        rot[10] = new ModelRendererTurbo(this, 329, 57, textureX, textureY); // Box 21
        rot[11] = new ModelRendererTurbo(this, 345, 57, textureX, textureY); // Box 22
        rot[12] = new ModelRendererTurbo(this, 1, 65, textureX, textureY); // Box 23
        rot[13] = new ModelRendererTurbo(this, 33, 65, textureX, textureY); // Box 24
        rot[14] = new ModelRendererTurbo(this, 57, 65, textureX, textureY); // Box 25
        rot[15] = new ModelRendererTurbo(this, 81, 65, textureX, textureY); // Box 26
        rot[16] = new ModelRendererTurbo(this, 329, 65, textureX, textureY); // Box 27
        rot[17] = new ModelRendererTurbo(this, 345, 65, textureX, textureY); // Box 28
        rot[18] = new ModelRendererTurbo(this, 425, 65, textureX, textureY); // Box 29
        rot[19] = new ModelRendererTurbo(this, 457, 65, textureX, textureY); // Box 30
        rot[20] = new ModelRendererTurbo(this, 1, 73, textureX, textureY); // Box 31
        rot[21] = new ModelRendererTurbo(this, 33, 73, textureX, textureY); // Box 32
        rot[22] = new ModelRendererTurbo(this, 57, 73, textureX, textureY); // Box 33
        rot[23] = new ModelRendererTurbo(this, 81, 73, textureX, textureY); // Box 34
        rot[24] = new ModelRendererTurbo(this, 345, 73, textureX, textureY); // Box 35
        rot[25] = new ModelRendererTurbo(this, 425, 73, textureX, textureY); // Box 36
        rot[26] = new ModelRendererTurbo(this, 457, 73, textureX, textureY); // Box 37
        rot[27] = new ModelRendererTurbo(this, 345, 81, textureX, textureY); // Box 38
        rot[28] = new ModelRendererTurbo(this, 393, 89, textureX, textureY); // Box 39
        rot[29] = new ModelRendererTurbo(this, 1, 97, textureX, textureY); // Box 40
        rot[30] = new ModelRendererTurbo(this, 17, 97, textureX, textureY); // Box 41
        rot[31] = new ModelRendererTurbo(this, 33, 97, textureX, textureY); // Box 42
        rot[32] = new ModelRendererTurbo(this, 393, 97, textureX, textureY); // Box 43
        rot[33] = new ModelRendererTurbo(this, 161, 105, textureX, textureY); // Box 44
        rot[34] = new ModelRendererTurbo(this, 177, 105, textureX, textureY); // Box 45
        rot[35] = new ModelRendererTurbo(this, 193, 105, textureX, textureY); // Box 46
        rot[36] = new ModelRendererTurbo(this, 209, 105, textureX, textureY); // Box 47
        rot[37] = new ModelRendererTurbo(this, 225, 105, textureX, textureY); // Box 48
        rot[38] = new ModelRendererTurbo(this, 241, 105, textureX, textureY); // Box 49

        rot[0].addBox(0F, -1.5F, -0.5F, 7, 3, 1, 0F); // Box 11
        rot[0].setRotationPoint(-44F, -27.5F, -1.5F);

        rot[1].addShapeBox(0F, -1.5F, 0.5F, 7, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 12
        rot[1].setRotationPoint(-44F, -27.5F, -1.5F);

        rot[2].addShapeBox(0F, -1.5F, -1.5F, 7, 3, 1, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 13
        rot[2].setRotationPoint(-44F, -27.5F, -1.5F);

        rot[3].addShapeBox(0F, 1.5F, -0.5F, 5, 6, 1, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 1F, 0F, -1.2F, -1F, 0F, -0.4F, -1F, 0F, -0.4F, 1F, 0F, 0.4F); // Box 14
        rot[3].setRotationPoint(-43.5F, -27.5F, -1.5F);

        rot[4].addShapeBox(0F, 1.5F, -0.5F, 5, 6, 1, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 1F, 0F, -1.2F, -1F, 0F, -0.4F, -1F, 0F, -0.4F, 1F, 0F, 0.4F); // Box 15
        rot[4].setRotationPoint(-43.5F, -27.5F, -1.5F);
        rot[4].rotateAngleX = -0.17453293F;

        rot[5].addShapeBox(0F, 1.5F, -0.5F, 5, 6, 1, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 1F, 0F, -1.2F, -1F, 0F, -0.4F, -1F, 0F, -0.4F, 1F, 0F, 0.4F); // Box 16
        rot[5].setRotationPoint(-43.5F, -27.5F, -1.5F);
        rot[5].rotateAngleX = -0.34906585F;

        rot[6].addShapeBox(0F, 1.5F, -0.5F, 5, 6, 1, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 1F, 0F, -1.2F, -1F, 0F, -0.4F, -1F, 0F, -0.4F, 1F, 0F, 0.4F); // Box 17
        rot[6].setRotationPoint(-43.5F, -27.5F, -1.5F);
        rot[6].rotateAngleX = -0.52359878F;

        rot[7].addShapeBox(0F, 1.5F, -0.5F, 5, 6, 1, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 1F, 0F, -1.2F, -1F, 0F, -0.4F, -1F, 0F, -0.4F, 1F, 0F, 0.4F); // Box 18
        rot[7].setRotationPoint(-43.5F, -27.5F, -1.5F);
        rot[7].rotateAngleX = -0.6981317F;

        rot[8].addShapeBox(0F, 1.5F, -0.5F, 5, 6, 1, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 1F, 0F, -1.2F, -1F, 0F, -0.4F, -1F, 0F, -0.4F, 1F, 0F, 0.4F); // Box 19
        rot[8].setRotationPoint(-43.5F, -27.5F, -1.5F);
        rot[8].rotateAngleX = -0.87266463F;

        rot[9].addShapeBox(0F, 1.5F, -0.5F, 5, 6, 1, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 1F, 0F, -1.2F, -1F, 0F, -0.4F, -1F, 0F, -0.4F, 1F, 0F, 0.4F); // Box 20
        rot[9].setRotationPoint(-43.5F, -27.5F, -1.5F);
        rot[9].rotateAngleX = -1.04719755F;

        rot[10].addShapeBox(0F, 1.5F, -0.5F, 5, 6, 1, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 1F, 0F, -1.2F, -1F, 0F, -0.4F, -1F, 0F, -0.4F, 1F, 0F, 0.4F); // Box 21
        rot[10].setRotationPoint(-43.5F, -27.5F, -1.5F);
        rot[10].rotateAngleX = -1.22173048F;

        rot[11].addShapeBox(0F, 1.5F, -0.5F, 5, 6, 1, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 1F, 0F, -1.2F, -1F, 0F, -0.4F, -1F, 0F, -0.4F, 1F, 0F, 0.4F); // Box 22
        rot[11].setRotationPoint(-43.5F, -27.5F, -1.5F);
        rot[11].rotateAngleX = -1.3962634F;

        rot[12].addShapeBox(0F, 1.5F, -0.5F, 5, 6, 1, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 1F, 0F, -1.2F, -1F, 0F, -0.4F, -1F, 0F, -0.4F, 1F, 0F, 0.4F); // Box 23
        rot[12].setRotationPoint(-43.5F, -27.5F, -1.5F);
        rot[12].rotateAngleX = -1.57079633F;

        rot[13].addShapeBox(0F, 1.5F, -0.5F, 5, 6, 1, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 1F, 0F, -1.2F, -1F, 0F, -0.4F, -1F, 0F, -0.4F, 1F, 0F, 0.4F); // Box 24
        rot[13].setRotationPoint(-43.5F, -27.5F, -1.5F);
        rot[13].rotateAngleX = -1.74532925F;

        rot[14].addShapeBox(0F, 1.5F, -0.5F, 5, 6, 1, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 1F, 0F, -1.2F, -1F, 0F, -0.4F, -1F, 0F, -0.4F, 1F, 0F, 0.4F); // Box 25
        rot[14].setRotationPoint(-43.5F, -27.5F, -1.5F);
        rot[14].rotateAngleX = -1.91986218F;

        rot[15].addShapeBox(0F, 1.5F, -0.5F, 5, 6, 1, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 1F, 0F, -1.2F, -1F, 0F, -0.4F, -1F, 0F, -0.4F, 1F, 0F, 0.4F); // Box 26
        rot[15].setRotationPoint(-43.5F, -27.5F, -1.5F);
        rot[15].rotateAngleX = -2.0943951F;

        rot[16].addShapeBox(0F, 1.5F, -0.5F, 5, 6, 1, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 1F, 0F, -1.2F, -1F, 0F, -0.4F, -1F, 0F, -0.4F, 1F, 0F, 0.4F); // Box 27
        rot[16].setRotationPoint(-43.5F, -27.5F, -1.5F);
        rot[16].rotateAngleX = -2.26892803F;

        rot[17].addShapeBox(0F, 1.5F, -0.5F, 5, 6, 1, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 1F, 0F, -1.2F, -1F, 0F, -0.4F, -1F, 0F, -0.4F, 1F, 0F, 0.4F); // Box 28
        rot[17].setRotationPoint(-43.5F, -27.5F, -1.5F);
        rot[17].rotateAngleX = -2.44346095F;

        rot[18].addShapeBox(0F, 1.5F, -0.5F, 5, 6, 1, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 1F, 0F, -1.2F, -1F, 0F, -0.4F, -1F, 0F, -0.4F, 1F, 0F, 0.4F); // Box 29
        rot[18].setRotationPoint(-43.5F, -27.5F, -1.5F);
        rot[18].rotateAngleX = -2.61799388F;

        rot[19].addShapeBox(0F, 1.5F, -0.5F, 5, 6, 1, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 1F, 0F, -1.2F, -1F, 0F, -0.4F, -1F, 0F, -0.4F, 1F, 0F, 0.4F); // Box 30
        rot[19].setRotationPoint(-43.5F, -27.5F, -1.5F);
        rot[19].rotateAngleX = -2.7925268F;

        rot[20].addShapeBox(0F, 1.5F, -0.5F, 5, 6, 1, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 1F, 0F, -1.2F, -1F, 0F, -0.4F, -1F, 0F, -0.4F, 1F, 0F, 0.4F); // Box 31
        rot[20].setRotationPoint(-43.5F, -27.5F, -1.5F);
        rot[20].rotateAngleX = -2.96705973F;

        rot[21].addShapeBox(0F, 1.5F, -0.5F, 5, 6, 1, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 1F, 0F, -1.2F, -1F, 0F, -0.4F, -1F, 0F, -0.4F, 1F, 0F, 0.4F); // Box 32
        rot[21].setRotationPoint(-43.5F, -27.5F, -1.5F);
        rot[21].rotateAngleX = 0.17453293F;

        rot[22].addShapeBox(0F, 1.5F, -0.5F, 5, 6, 1, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 1F, 0F, -1.2F, -1F, 0F, -0.4F, -1F, 0F, -0.4F, 1F, 0F, 0.4F); // Box 33
        rot[22].setRotationPoint(-43.5F, -27.5F, -1.5F);
        rot[22].rotateAngleX = 0.34906585F;

        rot[23].addShapeBox(0F, 1.5F, -0.5F, 5, 6, 1, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 1F, 0F, -1.2F, -1F, 0F, -0.4F, -1F, 0F, -0.4F, 1F, 0F, 0.4F); // Box 34
        rot[23].setRotationPoint(-43.5F, -27.5F, -1.5F);
        rot[23].rotateAngleX = 0.52359878F;

        rot[24].addShapeBox(0F, 1.5F, -0.5F, 5, 6, 1, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 1F, 0F, -1.2F, -1F, 0F, -0.4F, -1F, 0F, -0.4F, 1F, 0F, 0.4F); // Box 35
        rot[24].setRotationPoint(-43.5F, -27.5F, -1.5F);
        rot[24].rotateAngleX = 0.6981317F;

        rot[25].addShapeBox(0F, 1.5F, -0.5F, 5, 6, 1, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 1F, 0F, -1.2F, -1F, 0F, -0.4F, -1F, 0F, -0.4F, 1F, 0F, 0.4F); // Box 36
        rot[25].setRotationPoint(-43.5F, -27.5F, -1.5F);
        rot[25].rotateAngleX = 0.87266463F;

        rot[26].addShapeBox(0F, 1.5F, -0.5F, 5, 6, 1, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 1F, 0F, -1.2F, -1F, 0F, -0.4F, -1F, 0F, -0.4F, 1F, 0F, 0.4F); // Box 37
        rot[26].setRotationPoint(-43.5F, -27.5F, -1.5F);
        rot[26].rotateAngleX = 1.04719755F;

        rot[27].addShapeBox(0F, 1.5F, -0.5F, 5, 6, 1, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 1F, 0F, -1.2F, -1F, 0F, -0.4F, -1F, 0F, -0.4F, 1F, 0F, 0.4F); // Box 38
        rot[27].setRotationPoint(-43.5F, -27.5F, -1.5F);
        rot[27].rotateAngleX = 1.22173048F;

        rot[28].addShapeBox(0F, 1.5F, -0.5F, 5, 6, 1, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 1F, 0F, -1.2F, -1F, 0F, -0.4F, -1F, 0F, -0.4F, 1F, 0F, 0.4F); // Box 39
        rot[28].setRotationPoint(-43.5F, -27.5F, -1.5F);
        rot[28].rotateAngleX = 1.3962634F;

        rot[29].addShapeBox(0F, 1.5F, -0.5F, 5, 6, 1, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 1F, 0F, -1.2F, -1F, 0F, -0.4F, -1F, 0F, -0.4F, 1F, 0F, 0.4F); // Box 40
        rot[29].setRotationPoint(-43.5F, -27.5F, -1.5F);
        rot[29].rotateAngleX = 1.57079633F;

        rot[30].addShapeBox(0F, 1.5F, -0.5F, 5, 6, 1, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 1F, 0F, -1.2F, -1F, 0F, -0.4F, -1F, 0F, -0.4F, 1F, 0F, 0.4F); // Box 41
        rot[30].setRotationPoint(-43.5F, -27.5F, -1.5F);
        rot[30].rotateAngleX = 1.74532925F;

        rot[31].addShapeBox(0F, 1.5F, -0.5F, 5, 6, 1, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 1F, 0F, -1.2F, -1F, 0F, -0.4F, -1F, 0F, -0.4F, 1F, 0F, 0.4F); // Box 42
        rot[31].setRotationPoint(-43.5F, -27.5F, -1.5F);
        rot[31].rotateAngleX = 1.91986218F;

        rot[32].addShapeBox(0F, 1.5F, -0.5F, 5, 6, 1, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 1F, 0F, -1.2F, -1F, 0F, -0.4F, -1F, 0F, -0.4F, 1F, 0F, 0.4F); // Box 43
        rot[32].setRotationPoint(-43.5F, -27.5F, -1.5F);
        rot[32].rotateAngleX = 2.0943951F;

        rot[33].addShapeBox(0F, 1.5F, -0.5F, 5, 6, 1, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 1F, 0F, -1.2F, -1F, 0F, -0.4F, -1F, 0F, -0.4F, 1F, 0F, 0.4F); // Box 44
        rot[33].setRotationPoint(-43.5F, -27.5F, -1.5F);
        rot[33].rotateAngleX = 2.26892803F;

        rot[34].addShapeBox(0F, 1.5F, -0.5F, 5, 6, 1, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 1F, 0F, -1.2F, -1F, 0F, -0.4F, -1F, 0F, -0.4F, 1F, 0F, 0.4F); // Box 45
        rot[34].setRotationPoint(-43.5F, -27.5F, -1.5F);
        rot[34].rotateAngleX = 2.44346095F;

        rot[35].addShapeBox(0F, 1.5F, -0.5F, 5, 6, 1, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 1F, 0F, -1.2F, -1F, 0F, -0.4F, -1F, 0F, -0.4F, 1F, 0F, 0.4F); // Box 46
        rot[35].setRotationPoint(-43.5F, -27.5F, -1.5F);
        rot[35].rotateAngleX = 2.61799388F;

        rot[36].addShapeBox(0F, 1.5F, -0.5F, 5, 6, 1, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 1F, 0F, -1.2F, -1F, 0F, -0.4F, -1F, 0F, -0.4F, 1F, 0F, 0.4F); // Box 47
        rot[36].setRotationPoint(-43.5F, -27.5F, -1.5F);
        rot[36].rotateAngleX = 2.7925268F;

        rot[37].addShapeBox(0F, 1.5F, -0.5F, 5, 6, 1, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 1F, 0F, -1.2F, -1F, 0F, -0.4F, -1F, 0F, -0.4F, 1F, 0F, 0.4F); // Box 48
        rot[37].setRotationPoint(-43.5F, -27.5F, -1.5F);
        rot[37].rotateAngleX = 2.96705973F;

        rot[38].addShapeBox(0F, 1.5F, -0.5F, 5, 6, 1, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 1F, 0F, -1.2F, -1F, 0F, -0.4F, -1F, 0F, -0.4F, 1F, 0F, 0.4F); // Box 49
        rot[38].setRotationPoint(-43.5F, -27.5F, -1.5F);
        rot[38].rotateAngleX = 3.14159265F;

        glow = new ModelRendererTurbo[2];
        glow[0] = new ModelRendererTurbo(this, 1, 81, textureX, textureY); // Box 55
        glow[1] = new ModelRendererTurbo(this, 81, 81, textureX, textureY); // Box 56

        glow[0].addBox(0F, 0F, 0F, 1, 1, 3, 0F); // Box 55
        glow[0].setRotationPoint(-44F, -15.2F, 17F);
        glow[0].rotateAngleZ = 0.78539816F;

        glow[1].addBox(0F, 0F, 0F, 1, 1, 3, 0F); // Box 56
        glow[1].setRotationPoint(-44F, -20.2F, 17F);
        glow[1].rotateAngleZ = 0.78539816F;
        
        translateAll(0F, 0F, 0F);
        flipAll();
    }

    private static RGB color = new RGB(128, 128, 128, 0.67f);

    @Override
    public void render(ContainerData data, Object obj){
        data.getPrimaryColor().glColorApply();
        render(body_colored_primary);
        RGB.glColorReset();
        render(body);
        //
        for(ModelRendererTurbo sub : rot){
            sub.rotateAngleX += Static.rad1;
            if(sub.rotateAngleX > 360){
                sub.rotateAngleX -= 360;
            }
            sub.render();
        }
        //
        {
            GlStateManager.pushMatrix();
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glDepthMask(false);
            GL11.glEnable(GL11.GL_ALPHA_TEST);
            color.glColorApply();
            render(other);
            RGB.glColorReset();
            GL11.glDisable(GL11.GL_ALPHA_TEST);
            GL11.glDepthMask(true);
            GL11.glDisable(GL11.GL_BLEND);
            GlStateManager.popMatrix();
        }
        //
        PartModelTMT.lightOff(null);
        render(glow);
        PartModelTMT.lightOn(null);
    }

}
