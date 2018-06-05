//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2018 Minecraft-SMP.de
// Model: GenericFluidContainer
// Model Creator: FEX___96
// Created on: 31.03.2018 - 16:18:53
// Last changed on: 31.03.2018 - 16:18:53
package net.fexcraft.mod.addons.hcp.models.container;

import net.fexcraft.mod.fvtm.model.container.ContainerModel;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class StandardFluidContainer extends ContainerModel {

    public StandardFluidContainer(){
    	super();
        this.addToCreators("01e4af9b-2a30-471e-addf-f6338ffce04b");
        textureX = 512; textureY = 512;
        body_colored_primary = new ModelRendererTurbo[32];
        body_colored_primary[0] = new ModelRendererTurbo(this, 1, 57, textureX, textureY); // Box 13
        body_colored_primary[1] = new ModelRendererTurbo(this, 273, 65, textureX, textureY); // Box 15
        body_colored_primary[2] = new ModelRendererTurbo(this, 1, 113, textureX, textureY); // Box 16
        body_colored_primary[3] = new ModelRendererTurbo(this, 209, 121, textureX, textureY); // Box 17
        body_colored_primary[4] = new ModelRendererTurbo(this, 1, 145, textureX, textureY); // Box 18
        body_colored_primary[5] = new ModelRendererTurbo(this, 209, 153, textureX, textureY); // Box 19
        body_colored_primary[6] = new ModelRendererTurbo(this, 1, 177, textureX, textureY); // Box 20
        body_colored_primary[7] = new ModelRendererTurbo(this, 209, 185, textureX, textureY); // Box 21
        body_colored_primary[8] = new ModelRendererTurbo(this, 1, 209, textureX, textureY); // Box 22
        body_colored_primary[9] = new ModelRendererTurbo(this, 209, 217, textureX, textureY); // Box 23
        body_colored_primary[10] = new ModelRendererTurbo(this, 97, 1, textureX, textureY); // Box 24
        body_colored_primary[11] = new ModelRendererTurbo(this, 441, 1, textureX, textureY); // Box 25
        body_colored_primary[12] = new ModelRendererTurbo(this, 433, 89, textureX, textureY); // Box 26
        body_colored_primary[13] = new ModelRendererTurbo(this, 385, 1, textureX, textureY); // Box 27
        body_colored_primary[14] = new ModelRendererTurbo(this, 417, 129, textureX, textureY); // Box 28
        body_colored_primary[15] = new ModelRendererTurbo(this, 433, 169, textureX, textureY); // Box 29
        body_colored_primary[16] = new ModelRendererTurbo(this, 129, 9, textureX, textureY); // Box 30
        body_colored_primary[17] = new ModelRendererTurbo(this, 97, 25, textureX, textureY); // Box 31
        body_colored_primary[18] = new ModelRendererTurbo(this, 433, 209, textureX, textureY); // Box 32
        body_colored_primary[19] = new ModelRendererTurbo(this, 1, 241, textureX, textureY); // Box 33
        body_colored_primary[20] = new ModelRendererTurbo(this, 73, 241, textureX, textureY); // Box 34
        body_colored_primary[21] = new ModelRendererTurbo(this, 385, 25, textureX, textureY); // Box 35
        body_colored_primary[22] = new ModelRendererTurbo(this, 145, 241, textureX, textureY); // Box 36
        body_colored_primary[23] = new ModelRendererTurbo(this, 217, 33, textureX, textureY); // Box 37
        body_colored_primary[24] = new ModelRendererTurbo(this, 185, 249, textureX, textureY); // Box 38
        body_colored_primary[25] = new ModelRendererTurbo(this, 265, 33, textureX, textureY); // Box 39
        body_colored_primary[26] = new ModelRendererTurbo(this, 257, 249, textureX, textureY); // Box 40
        body_colored_primary[27] = new ModelRendererTurbo(this, 297, 41, textureX, textureY); // Box 41
        body_colored_primary[28] = new ModelRendererTurbo(this, 329, 249, textureX, textureY); // Box 42
        body_colored_primary[29] = new ModelRendererTurbo(this, 401, 249, textureX, textureY); // Box 43
        body_colored_primary[30] = new ModelRendererTurbo(this, 441, 257, textureX, textureY); // Box 44
        body_colored_primary[31] = new ModelRendererTurbo(this, 1, 281, textureX, textureY); // Box 45

        body_colored_primary[0].addBox(0F, 0F, 0F, 90, 4, 44, 0F); // Box 13
        body_colored_primary[0].setRotationPoint(-45F, -26F, -22F);

        body_colored_primary[1].addBox(0F, 0F, 0F, 90, 44, 4, 0F); // Box 15
        body_colored_primary[1].setRotationPoint(-45F, -46F, -2F);

        body_colored_primary[2].addShapeBox(0F, 0F, 0F, 90, 20, 10, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, -2F, 0F, -2F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -14F, 4F, 0F, -14F, 4F); // Box 16
        body_colored_primary[2].setRotationPoint(-45F, -46F, 2F);

        body_colored_primary[3].addShapeBox(0F, 0F, 0F, 90, 10, 20, 0F, 0F, 4F, -14F, 0F, 4F, -14F, 0F, -2F, -2F, 0F, -2F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 17
        body_colored_primary[3].setRotationPoint(-45F, -36F, 2F);

        body_colored_primary[4].addShapeBox(0F, 0F, 0F, 90, 20, 10, 0F, 0F, -2F, -2F, 0F, -2F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -14F, 4F, 0F, -14F, 4F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 18
        body_colored_primary[4].setRotationPoint(-45F, -46F, -12F);

        body_colored_primary[5].addShapeBox(0F, 0F, 0F, 90, 10, 20, 0F, 0F, -2F, -2F, 0F, -2F, -2F, 0F, 4F, -14F, 0F, 4F, -14F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 19
        body_colored_primary[5].setRotationPoint(-45F, -36F, -22F);

        body_colored_primary[6].addShapeBox(0F, 0F, 0F, 90, 20, 10, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -14F, 4F, 0F, -14F, 4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, -2F, 0F, -2F, -2F); // Box 20
        body_colored_primary[6].setRotationPoint(-45F, -22F, 2F);

        body_colored_primary[7].addShapeBox(0F, 0F, 0F, 90, 10, 20, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 4F, -14F, 0F, 4F, -14F, 0F, -2F, -2F, 0F, -2F, -2F); // Box 21
        body_colored_primary[7].setRotationPoint(-45F, -22F, 2F);

        body_colored_primary[8].addShapeBox(0F, 0F, 0F, 90, 20, 10, 0F, 0F, -14F, 4F, 0F, -14F, 4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, -2F, 0F, -2F, -2F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 22
        body_colored_primary[8].setRotationPoint(-45F, -22F, -12F);

        body_colored_primary[9].addShapeBox(0F, 0F, 0F, 90, 10, 20, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, -2F, 0F, -2F, -2F, 0F, 4F, -14F, 0F, 4F, -14F); // Box 23
        body_colored_primary[9].setRotationPoint(-45F, -22F, -22F);

        body_colored_primary[10].addShapeBox(0F, 0F, 0F, 2, 2, 20, 0F, 0.5F, -1F, -8F, 0F, 0F, -8F, 0F, 0F, -8F, 0.5F, -1F, -8F, 0.5F, 0.5F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0.5F, -1F); // Box 24
        body_colored_primary[10].setRotationPoint(-47F, -46F, -10F);

        body_colored_primary[11].addShapeBox(0F, 0F, 0F, 2, 4, 32, 0F, 0.5F, -0.5F, -7F, 0F, 0F, -6F, 0F, 0F, -6F, 0.5F, -0.5F, -7F, 0.5F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, -1F); // Box 25
        body_colored_primary[11].setRotationPoint(-47F, -44F, -16F);

        body_colored_primary[12].addShapeBox(0F, 0F, 0F, 2, 4, 32, 0F, 0.5F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, -1F, 0.5F, -0.5F, -7F, 0F, 0F, -6F, 0F, 0F, -6F, 0.5F, -0.5F, -7F); // Box 26
        body_colored_primary[12].setRotationPoint(-47F, -8F, -16F);

        body_colored_primary[13].addShapeBox(0F, 0F, 0F, 2, 2, 20, 0F, 0.5F, 0.5F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0.5F, -1F, 0.5F, -1F, -8F, 0F, 0F, -8F, 0F, 0F, -8F, 0.5F, -1F, -8F); // Box 27
        body_colored_primary[13].setRotationPoint(-47F, -4F, -10F);

        body_colored_primary[14].addShapeBox(0F, 0F, 0F, 2, 4, 32, 0F, 0.5F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, -1F, 0.5F, -0.5F, -7F, 0F, 0F, -6F, 0F, 0F, -6F, 0.5F, -0.5F, -7F); // Box 28
        body_colored_primary[14].setRotationPoint(-47F, -40F, -16F);
        body_colored_primary[14].rotateAngleX = -1.57079633F;

        body_colored_primary[15].addShapeBox(0F, 0F, 0F, 2, 4, 32, 0F, 0.5F, -0.5F, -7F, 0F, 0F, -6F, 0F, 0F, -6F, 0.5F, -0.5F, -7F, 0.5F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, -1F); // Box 29
        body_colored_primary[15].setRotationPoint(-47F, -40F, 20F);
        body_colored_primary[15].rotateAngleX = -1.57079633F;

        body_colored_primary[16].addShapeBox(0F, 0F, 0F, 2, 2, 20, 0F, 0.5F, -1F, -8F, 0F, 0F, -8F, 0F, 0F, -8F, 0.5F, -1F, -8F, 0.5F, 0.5F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0.5F, -1F); // Box 30
        body_colored_primary[16].setRotationPoint(-47F, -14F, -22F);
        body_colored_primary[16].rotateAngleX = 1.57079633F;

        body_colored_primary[17].addShapeBox(0F, 0F, 0F, 2, 2, 20, 0F, 0.5F, 0.5F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0.5F, -1F, 0.5F, -1F, -8F, 0F, 0F, -8F, 0F, 0F, -8F, 0.5F, -1F, -8F); // Box 31
        body_colored_primary[17].setRotationPoint(-47F, -14F, 20F);
        body_colored_primary[17].rotateAngleX = 1.57079633F;

        body_colored_primary[18].addShapeBox(0F, 0F, 0F, 2, 1, 32, 0F, 0.5F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, -1F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F); // Box 32
        body_colored_primary[18].setRotationPoint(-47F, -40F, -16F);

        body_colored_primary[19].addShapeBox(0F, 0F, 0F, 2, 1, 32, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, -1F); // Box 33
        body_colored_primary[19].setRotationPoint(-47F, -9F, -16F);

        body_colored_primary[20].addShapeBox(0F, 0F, 0F, 2, 30, 32, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F); // Box 34
        body_colored_primary[20].setRotationPoint(-47F, -39F, -16F);

        body_colored_primary[21].addShapeBox(0F, 0F, 0F, 2, 2, 20, 0F, 0F, 0F, -8F, 0.5F, -1F, -8F, 0.5F, -1F, -8F, 0F, 0F, -8F, 0F, 0F, 0F, 0.5F, 0.5F, -1F, 0.5F, 0.5F, -1F, 0F, 0F, 0F); // Box 35
        body_colored_primary[21].setRotationPoint(45F, -46F, -10F);

        body_colored_primary[22].addShapeBox(0F, 0F, 0F, 2, 4, 32, 0F, 0F, 0F, -6F, 0.5F, -0.5F, -7F, 0.5F, -0.5F, -7F, 0F, 0F, -6F, 0F, 0F, 0F, 0.5F, 0F, -1F, 0.5F, 0F, -1F, 0F, 0F, 0F); // Box 36
        body_colored_primary[22].setRotationPoint(45F, -44F, -16F);

        body_colored_primary[23].addShapeBox(0F, 0F, 0F, 2, 2, 20, 0F, 0F, 0F, 0F, 0.5F, 0.5F, -1F, 0.5F, 0.5F, -1F, 0F, 0F, 0F, 0F, 0F, -8F, 0.5F, -1F, -8F, 0.5F, -1F, -8F, 0F, 0F, -8F); // Box 37
        body_colored_primary[23].setRotationPoint(45F, -4F, -10F);

        body_colored_primary[24].addShapeBox(0F, 0F, 0F, 2, 4, 32, 0F, 0F, 0F, 0F, 0.5F, 0F, -1F, 0.5F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -6F, 0.5F, -0.5F, -7F, 0.5F, -0.5F, -7F, 0F, 0F, -6F); // Box 38
        body_colored_primary[24].setRotationPoint(45F, -8F, -16F);

        body_colored_primary[25].addShapeBox(0F, 0F, 0F, 2, 2, 20, 0F, 0F, 0F, -8F, 0.5F, -1F, -8F, 0.5F, -1F, -8F, 0F, 0F, -8F, 0F, 0F, 0F, 0.5F, 0.5F, -1F, 0.5F, 0.5F, -1F, 0F, 0F, 0F); // Box 39
        body_colored_primary[25].setRotationPoint(45F, -14F, -22F);
        body_colored_primary[25].rotateAngleX = 1.57079633F;

        body_colored_primary[26].addShapeBox(0F, 0F, 0F, 2, 4, 32, 0F, 0F, 0F, 0F, 0.5F, 0F, -1F, 0.5F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -6F, 0.5F, -0.5F, -7F, 0.5F, -0.5F, -7F, 0F, 0F, -6F); // Box 40
        body_colored_primary[26].setRotationPoint(45F, -40F, -16F);
        body_colored_primary[26].rotateAngleX = -1.57079633F;

        body_colored_primary[27].addShapeBox(0F, 0F, 0F, 2, 2, 20, 0F, 0F, 0F, 0F, 0.5F, 0.5F, -1F, 0.5F, 0.5F, -1F, 0F, 0F, 0F, 0F, 0F, -8F, 0.5F, -1F, -8F, 0.5F, -1F, -8F, 0F, 0F, -8F); // Box 41
        body_colored_primary[27].setRotationPoint(45F, -14F, 20F);
        body_colored_primary[27].rotateAngleX = 1.57079633F;

        body_colored_primary[28].addShapeBox(0F, 0F, 0F, 2, 4, 32, 0F, 0F, 0F, -6F, 0.5F, -0.5F, -7F, 0.5F, -0.5F, -7F, 0F, 0F, -6F, 0F, 0F, 0F, 0.5F, 0F, -1F, 0.5F, 0F, -1F, 0F, 0F, 0F); // Box 42
        body_colored_primary[28].setRotationPoint(45F, -40F, 20F);
        body_colored_primary[28].rotateAngleX = -1.57079633F;

        body_colored_primary[29].addShapeBox(0F, 0F, 0F, 2, 1, 32, 0F, 0F, 0F, 0F, 0.5F, 0F, -1F, 0.5F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F); // Box 43
        body_colored_primary[29].setRotationPoint(45F, -40F, -16F);

        body_colored_primary[30].addShapeBox(0F, 0F, 0F, 2, 1, 32, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, -1F, 0.5F, 0F, -1F, 0F, 0F, 0F); // Box 44
        body_colored_primary[30].setRotationPoint(45F, -9F, -16F);

        body_colored_primary[31].addShapeBox(0F, 0F, 0F, 2, 30, 32, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F); // Box 45
        body_colored_primary[31].setRotationPoint(45F, -39F, -16F);

        other = new ModelRendererTurbo[36];
        other[0] = new ModelRendererTurbo(this, 1, 57, textureX, textureY); // Box 50
        other[1] = new ModelRendererTurbo(this, 9, 57, textureX, textureY); // Box 51
        other[2] = new ModelRendererTurbo(this, 97, 1, textureX, textureY); // Box 52
        other[3] = new ModelRendererTurbo(this, 129, 1, textureX, textureY); // Box 53
        other[4] = new ModelRendererTurbo(this, 385, 1, textureX, textureY); // Box 54
        other[5] = new ModelRendererTurbo(this, 441, 1, textureX, textureY); // Box 55
        other[6] = new ModelRendererTurbo(this, 481, 1, textureX, textureY); // Box 56
        other[7] = new ModelRendererTurbo(this, 441, 17, textureX, textureY); // Box 57
        other[8] = new ModelRendererTurbo(this, 481, 17, textureX, textureY); // Box 58
        other[9] = new ModelRendererTurbo(this, 97, 25, textureX, textureY); // Box 59
        other[10] = new ModelRendererTurbo(this, 233, 57, textureX, textureY); // Box 60
        other[11] = new ModelRendererTurbo(this, 417, 169, textureX, textureY); // Box 61
        other[12] = new ModelRendererTurbo(this, 321, 297, textureX, textureY); // Box 62
        other[13] = new ModelRendererTurbo(this, 73, 313, textureX, textureY); // Box 63
        other[14] = new ModelRendererTurbo(this, 321, 305, textureX, textureY); // Box 64
        other[15] = new ModelRendererTurbo(this, 401, 305, textureX, textureY); // Box 65
        other[16] = new ModelRendererTurbo(this, 249, 313, textureX, textureY); // Box 66
        other[17] = new ModelRendererTurbo(this, 73, 321, textureX, textureY); // Box 67
        other[18] = new ModelRendererTurbo(this, 153, 321, textureX, textureY); // Box 68
        other[19] = new ModelRendererTurbo(this, 321, 321, textureX, textureY); // Box 69
        other[20] = new ModelRendererTurbo(this, 193, 321, textureX, textureY); // Box 70
        other[21] = new ModelRendererTurbo(this, 361, 321, textureX, textureY); // Box 71
        other[22] = new ModelRendererTurbo(this, 249, 329, textureX, textureY); // Box 72
        other[23] = new ModelRendererTurbo(this, 33, 337, textureX, textureY); // Box 73
        other[24] = new ModelRendererTurbo(this, 137, 337, textureX, textureY); // Box 74
        other[25] = new ModelRendererTurbo(this, 305, 337, textureX, textureY); // Box 75
        other[26] = new ModelRendererTurbo(this, 249, 33, textureX, textureY); // Box 76
        other[27] = new ModelRendererTurbo(this, 385, 25, textureX, textureY); // Box 77
        other[28] = new ModelRendererTurbo(this, 17, 57, textureX, textureY); // Box 78
        other[29] = new ModelRendererTurbo(this, 129, 33, textureX, textureY); // Box 79
        other[30] = new ModelRendererTurbo(this, 25, 57, textureX, textureY); // Box 80
        other[31] = new ModelRendererTurbo(this, 473, 97, textureX, textureY); // Box 81
        other[32] = new ModelRendererTurbo(this, 153, 33, textureX, textureY); // Box 82
        other[33] = new ModelRendererTurbo(this, 185, 33, textureX, textureY); // Box 83
        other[34] = new ModelRendererTurbo(this, 33, 57, textureX, textureY); // Box 84
        other[35] = new ModelRendererTurbo(this, 505, 185, textureX, textureY); // Box 85

        other[0].addBox(0F, 0F, 0F, 1, 42, 1, 0F); // Box 50
        other[0].setRotationPoint(-47.8F, -45F, -20F);

        other[1].addBox(0F, 0F, 0F, 1, 42, 1, 0F); // Box 51
        other[1].setRotationPoint(-47.8F, -45F, -12F);

        other[2].addShapeBox(0F, 0F, 0F, 1, 1, 7, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F); // Box 52
        other[2].setRotationPoint(-47.8F, -42F, -19F);

        other[3].addShapeBox(0F, 0F, 0F, 1, 1, 7, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F); // Box 53
        other[3].setRotationPoint(-47.8F, -37F, -19F);

        other[4].addShapeBox(0F, 0F, 0F, 1, 1, 7, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F); // Box 54
        other[4].setRotationPoint(-47.8F, -32F, -19F);

        other[5].addShapeBox(0F, 0F, 0F, 1, 1, 7, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F); // Box 55
        other[5].setRotationPoint(-47.8F, -27F, -19F);

        other[6].addShapeBox(0F, 0F, 0F, 1, 1, 7, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F); // Box 56
        other[6].setRotationPoint(-47.8F, -22F, -19F);

        other[7].addShapeBox(0F, 0F, 0F, 1, 1, 7, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F); // Box 57
        other[7].setRotationPoint(-47.8F, -17F, -19F);

        other[8].addShapeBox(0F, 0F, 0F, 1, 1, 7, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F); // Box 58
        other[8].setRotationPoint(-47.8F, -12F, -19F);

        other[9].addShapeBox(0F, 0F, 0F, 1, 1, 7, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F); // Box 59
        other[9].setRotationPoint(-47.8F, -7F, -19F);

        other[10].addBox(0F, 0F, 0F, 1, 10, 17, 0F); // Box 60
        other[10].setRotationPoint(-47.8F, -13F, 5F);

        other[11].addBox(0F, 0F, 0F, 1, 10, 17, 0F); // Box 61
        other[11].setRotationPoint(46.8F, -13F, -22F);

        other[12].addShapeBox(0F, 0F, 0F, 90, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 62
        other[12].setRotationPoint(-45F, -47.8F, -11F);

        other[13].addBox(0F, 0F, -1F, 90, 1, 1, 0F); // Box 63
        other[13].setRotationPoint(-45F, -47.8F, 11F);

        other[14].addShapeBox(0F, 0F, 0F, 28, 1, 10, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 64
        other[14].setRotationPoint(-43.5F, -47.5F, -21F);

        other[15].addShapeBox(0F, 0F, 0F, 28, 1, 10, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 65
        other[15].setRotationPoint(-14F, -47.5F, -21F);

        other[16].addShapeBox(0F, 0F, 0F, 28, 1, 10, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 66
        other[16].setRotationPoint(15.5F, -47.5F, -21F);

        other[17].addShapeBox(0F, 0F, 0F, 28, 1, 10, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 67
        other[17].setRotationPoint(-43.5F, -47.5F, 11F);

        other[18].addShapeBox(0F, 0F, 0F, 28, 1, 10, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 68
        other[18].setRotationPoint(-14F, -47.5F, 11F);

        other[19].addShapeBox(0F, 0F, 0F, 28, 1, 10, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 69
        other[19].setRotationPoint(15.5F, -47.5F, 11F);

        other[20].addBox(0F, 0F, 0F, 6, 1, 42, 0F); // Box 70
        other[20].setRotationPoint(-43F, -2F, -21F);

        other[21].addBox(0F, 0F, 0F, 6, 1, 42, 0F); // Box 71
        other[21].setRotationPoint(37F, -2F, -21F);

        other[22].addBox(0F, 0F, 0F, 6, 1, 42, 0F); // Box 72
        other[22].setRotationPoint(27F, -2F, -21F);

        other[23].addBox(0F, 0F, 0F, 6, 1, 42, 0F); // Box 73
        other[23].setRotationPoint(-33F, -2F, -21F);

        other[24].addBox(0F, 0F, 0F, 6, 1, 42, 0F); // Box 74
        other[24].setRotationPoint(-23F, -2F, -21F);

        other[25].addBox(0F, 0F, 0F, 6, 1, 42, 0F); // Box 75
        other[25].setRotationPoint(17F, -2F, -21F);

        other[26].addBox(0F, 0F, 0F, 16, 16, 1, 0F); // Box 76
        other[26].setRotationPoint(28F, -45F, 22.5F);

        other[27].addBox(0F, 0F, 0F, 8, 8, 1, 0F); // Box 77
        other[27].setRotationPoint(28F, -11F, 22.5F);

        other[28].addBox(0F, 0F, 0F, 1, 42, 1, 0F); // Box 78
        other[28].setRotationPoint(29F, -45F, 22F);

        other[29].addBox(0F, 0F, 0F, 8, 8, 1, 0F); // Box 79
        other[29].setRotationPoint(36F, -11F, 22.5F);

        other[30].addBox(0F, 0F, 0F, 1, 42, 1, 0F); // Box 80
        other[30].setRotationPoint(42F, -45F, 22F);

        other[31].addBox(0F, 0F, 0F, 16, 16, 1, 0F); // Box 81
        other[31].setRotationPoint(-44F, -45F, -23.5F);

        other[32].addBox(0F, 0F, 0F, 8, 8, 1, 0F); // Box 82
        other[32].setRotationPoint(-44F, -11F, -23.5F);

        other[33].addBox(0F, 0F, 0F, 8, 8, 1, 0F); // Box 83
        other[33].setRotationPoint(-36F, -11F, -23.5F);

        other[34].addBox(0F, 0F, 0F, 1, 42, 1, 0F); // Box 84
        other[34].setRotationPoint(-30F, -45F, -23F);

        other[35].addBox(0F, 0F, 0F, 1, 42, 1, 0F); // Box 85
        other[35].setRotationPoint(-43F, -45F, -23F);

        body_colored_secondary = new ModelRendererTurbo[12];
        body_colored_secondary[0] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 1
        body_colored_secondary[1] = new ModelRendererTurbo(this, 129, 1, textureX, textureY); // Box 2
        body_colored_secondary[2] = new ModelRendererTurbo(this, 185, 1, textureX, textureY); // Box 3
        body_colored_secondary[3] = new ModelRendererTurbo(this, 185, 9, textureX, textureY); // Box 4
        body_colored_secondary[4] = new ModelRendererTurbo(this, 329, 1, textureX, textureY); // Box 5
        body_colored_secondary[5] = new ModelRendererTurbo(this, 385, 9, textureX, textureY); // Box 6
        body_colored_secondary[6] = new ModelRendererTurbo(this, 185, 17, textureX, textureY); // Box 7
        body_colored_secondary[7] = new ModelRendererTurbo(this, 185, 25, textureX, textureY); // Box 8
        body_colored_secondary[8] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 9
        body_colored_secondary[9] = new ModelRendererTurbo(this, 41, 1, textureX, textureY); // Box 10
        body_colored_secondary[10] = new ModelRendererTurbo(this, 57, 1, textureX, textureY); // Box 11
        body_colored_secondary[11] = new ModelRendererTurbo(this, 81, 1, textureX, textureY); // Box 12

        body_colored_secondary[0].addBox(0F, 0F, 0F, 3, 3, 48, 0F); // Box 1
        body_colored_secondary[0].setRotationPoint(-48F, -3F, -24F);

        body_colored_secondary[1].addBox(-3F, 0F, 0F, 3, 3, 48, 0F); // Box 2
        body_colored_secondary[1].setRotationPoint(48F, -3F, -24F);

        body_colored_secondary[2].addBox(0F, 0F, 0F, 90, 3, 3, 0F); // Box 3
        body_colored_secondary[2].setRotationPoint(-45F, -3F, 21F);

        body_colored_secondary[3].addBox(0F, 0F, 0F, 90, 3, 3, 0F); // Box 4
        body_colored_secondary[3].setRotationPoint(-45F, -3F, -24F);

        body_colored_secondary[4].addBox(0F, 0F, 0F, 3, 3, 48, 0F); // Box 5
        body_colored_secondary[4].setRotationPoint(-48F, -48F, -24F);

        body_colored_secondary[5].addBox(-3F, 0F, 0F, 3, 3, 48, 0F); // Box 6
        body_colored_secondary[5].setRotationPoint(48F, -48F, -24F);

        body_colored_secondary[6].addBox(0F, 0F, 0F, 90, 3, 3, 0F); // Box 7
        body_colored_secondary[6].setRotationPoint(-45F, -48F, 21F);

        body_colored_secondary[7].addBox(0F, 0F, 0F, 90, 3, 3, 0F); // Box 8
        body_colored_secondary[7].setRotationPoint(-45F, -48F, -24F);

        body_colored_secondary[8].addShapeBox(0F, 0F, 0F, 3, 42, 3, 0F, 0F, 0F, 0F, -1F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 9
        body_colored_secondary[8].setRotationPoint(-48F, -45F, 21F);

        body_colored_secondary[9].addShapeBox(0F, 0F, 0F, 3, 42, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -1F, 0F, 0F, 0F); // Box 10
        body_colored_secondary[9].setRotationPoint(-48F, -45F, -24F);

        body_colored_secondary[10].addShapeBox(0F, 0F, 0F, 3, 42, 3, 0F, -1F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 11
        body_colored_secondary[10].setRotationPoint(45F, -45F, 21F);

        body_colored_secondary[11].addShapeBox(0F, 0F, 0F, 3, 42, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -1F); // Box 12
        body_colored_secondary[11].setRotationPoint(45F, -45F, -24F);

        body = new ModelRendererTurbo[5];
        body[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
        body[1] = new ModelRendererTurbo(this, 129, 289, textureX, textureY); // Box 46
        body[2] = new ModelRendererTurbo(this, 233, 289, textureX, textureY); // Box 47
        body[3] = new ModelRendererTurbo(this, 489, 41, textureX, textureY); // Box 48
        body[4] = new ModelRendererTurbo(this, 489, 129, textureX, textureY); // Box 49

        body[0].addBox(-2F, 0F, -2F, 4, 48, 4, 0F); // Box 0
        body[0].setRotationPoint(0F, -48F, 0F);

        body[1].addBox(0F, 0F, 0F, 32, 4, 16, 0F); // Box 46
        body[1].setRotationPoint(-16F, -47.5F, -8F);

        body[2].addBox(0F, 0F, 0F, 32, 4, 16, 0F); // Box 47
        body[2].setRotationPoint(-16F, -4.5F, -8F);

        body[3].addBox(-2F, 0F, -2F, 4, 48, 4, 0F); // Box 48
        body[3].setRotationPoint(8F, -48F, 0F);

        body[4].addBox(-2F, 0F, -2F, 4, 48, 4, 0F); // Box 49
        body[4].setRotationPoint(-8F, -48F, 0F);

        translateAll(0F, 0F, 0F);
        flipAll();
    }

}
