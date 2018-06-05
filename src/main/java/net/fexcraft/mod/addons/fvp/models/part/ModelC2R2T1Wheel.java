//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2017 Minecraft-SMP.de
// Model: C2R2T1 Wheel
// Model Creator: FEX___96
// Created on: 31.03.2017 - 14:38:29
// Last changed on: 31.03.2017 - 14:38:29
package net.fexcraft.mod.addons.fvp.models.part;

import net.fexcraft.mod.fvtm.model.part.AdjustableWheelModel;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelC2R2T1Wheel extends AdjustableWheelModel {

    public ModelC2R2T1Wheel(){
    	super(); textureX = 128; textureY = 64;
        this.addToCreators("Ferdinand (FEX___96)");
        wheel = new ModelRendererTurbo[48];
        wheel[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 18
        wheel[1] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 19
        wheel[2] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 20
        wheel[3] = new ModelRendererTurbo(this, 41, 1, textureX, textureY); // Box 47
        wheel[4] = new ModelRendererTurbo(this, 57, 1, textureX, textureY); // Box 48
        wheel[5] = new ModelRendererTurbo(this, 73, 1, textureX, textureY); // Box 49
        wheel[6] = new ModelRendererTurbo(this, 89, 1, textureX, textureY); // Box 50
        wheel[7] = new ModelRendererTurbo(this, 105, 1, textureX, textureY); // Box 51
        wheel[8] = new ModelRendererTurbo(this, 1, 9, textureX, textureY); // Box 65
        wheel[9] = new ModelRendererTurbo(this, 17, 9, textureX, textureY); // Box 66
        wheel[10] = new ModelRendererTurbo(this, 33, 9, textureX, textureY); // Box 67
        wheel[11] = new ModelRendererTurbo(this, 49, 9, textureX, textureY); // Box 71
        wheel[12] = new ModelRendererTurbo(this, 65, 9, textureX, textureY); // Box 73
        wheel[13] = new ModelRendererTurbo(this, 81, 9, textureX, textureY); // Box 74
        wheel[14] = new ModelRendererTurbo(this, 97, 9, textureX, textureY); // Box 75
        wheel[15] = new ModelRendererTurbo(this, 113, 9, textureX, textureY); // Box 76
        wheel[16] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 77
        wheel[17] = new ModelRendererTurbo(this, 17, 17, textureX, textureY); // Box 78
        wheel[18] = new ModelRendererTurbo(this, 33, 17, textureX, textureY); // Box 79
        wheel[19] = new ModelRendererTurbo(this, 49, 17, textureX, textureY); // Box 81
        wheel[20] = new ModelRendererTurbo(this, 65, 17, textureX, textureY); // Box 82
        wheel[21] = new ModelRendererTurbo(this, 81, 17, textureX, textureY); // Box 83
        wheel[22] = new ModelRendererTurbo(this, 97, 17, textureX, textureY); // Box 84
        wheel[23] = new ModelRendererTurbo(this, 113, 17, textureX, textureY); // Box 85
        wheel[24] = new ModelRendererTurbo(this, 1, 25, textureX, textureY); // Box 86
        wheel[25] = new ModelRendererTurbo(this, 17, 25, textureX, textureY); // Box 87
        wheel[26] = new ModelRendererTurbo(this, 33, 25, textureX, textureY); // Box 88
        wheel[27] = new ModelRendererTurbo(this, 49, 25, textureX, textureY); // Box 89
        wheel[28] = new ModelRendererTurbo(this, 49, 25, textureX, textureY); // Box 90
        wheel[29] = new ModelRendererTurbo(this, 49, 25, textureX, textureY); // Box 91
        wheel[30] = new ModelRendererTurbo(this, 49, 25, textureX, textureY); // Box 92
        wheel[31] = new ModelRendererTurbo(this, 49, 25, textureX, textureY); // Box 94
        wheel[32] = new ModelRendererTurbo(this, 9, 25, textureX, textureY); // Box 96
        wheel[33] = new ModelRendererTurbo(this, 25, 25, textureX, textureY); // Box 97
        wheel[34] = new ModelRendererTurbo(this, 41, 25, textureX, textureY); // Box 98
        wheel[35] = new ModelRendererTurbo(this, 65, 25, textureX, textureY); // Box 99
        wheel[36] = new ModelRendererTurbo(this, 81, 25, textureX, textureY); // Box 100
        wheel[37] = new ModelRendererTurbo(this, 97, 25, textureX, textureY); // Box 101
        wheel[38] = new ModelRendererTurbo(this, 113, 25, textureX, textureY); // Box 102
        wheel[39] = new ModelRendererTurbo(this, 1, 33, textureX, textureY); // Box 103
        wheel[40] = new ModelRendererTurbo(this, 121, 1, textureX, textureY); // Box 104
        wheel[41] = new ModelRendererTurbo(this, 17, 33, textureX, textureY); // Box 105
        wheel[42] = new ModelRendererTurbo(this, 25, 33, textureX, textureY); // Box 106
        wheel[43] = new ModelRendererTurbo(this, 33, 33, textureX, textureY); // Box 107
        wheel[44] = new ModelRendererTurbo(this, 41, 33, textureX, textureY); // Box 108
        wheel[45] = new ModelRendererTurbo(this, 49, 33, textureX, textureY); // Box 109
        wheel[46] = new ModelRendererTurbo(this, 57, 33, textureX, textureY); // Box 111
        wheel[47] = new ModelRendererTurbo(this, 65, 33, textureX, textureY); // Box 112

        wheel[0].addBox(-1.5F, -1.5F, -1F, 3, 3, 2, 0F); // Box 18
        wheel[0].setRotationPoint(0F, 0F, 0F);

        wheel[1].addBox(-1F, -1F, -2F, 2, 2, 1, 0F); // Box 19
        wheel[1].setRotationPoint(0F, 0F, 0F);

        wheel[2].addShapeBox(-1.5F, -1.5F, 1F, 3, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, -0.75F, -0.5F, -0.75F, -0.75F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, -0.75F, -0.5F, -0.75F, -0.75F, -0.5F); // Box 20
        wheel[2].setRotationPoint(0F, 0F, 0F);

        wheel[3].addShapeBox(0F, 6F, -2.5F, 3, 2, 4, 0F, 0F, 0F, 0F, -0.7F, 0.45F, 0F, -0.7F, 0.45F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.06F, -0.6F, 0F, 0.06F, -0.6F, 0F, 0F, 0F, 0F); // Box 47
        wheel[3].setRotationPoint(0F, 0F, 0F);

        wheel[4].addShapeBox(-3F, 6F, -2.5F, 3, 2, 4, 0F, -0.7F, 0.45F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.7F, 0.45F, 0F, 0.06F, -0.6F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.06F, -0.6F, 0F); // Box 48
        wheel[4].setRotationPoint(0F, 0F, 0F);

        wheel[5].addShapeBox(0F, -8F, -2.5F, 3, 2, 4, 0F, 0F, 0F, 0F, 0.06F, -0.6F, 0F, 0.06F, -0.6F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.7F, 0.45F, 0F, -0.7F, 0.45F, 0F, 0F, 0F, 0F); // Box 49
        wheel[5].setRotationPoint(0F, 0F, 0F);

        wheel[6].addShapeBox(-3F, -8F, -2.5F, 3, 2, 4, 0F, 0.06F, -0.6F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.06F, -0.6F, 0F, -0.7F, 0.45F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.7F, 0.45F, 0F); // Box 50
        wheel[6].setRotationPoint(0F, 0F, 0F);

        wheel[7].addShapeBox(6F, 0F, -2.5F, 2, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.45F, -0.7F, 0F, -0.6F, 0.06F, 0F, -0.6F, 0.06F, 0F, 0.45F, -0.7F, 0F); // Box 51
        wheel[7].setRotationPoint(0F, 0F, 0F);

        wheel[8].addShapeBox(6F, -3F, -2.5F, 2, 3, 4, 0F, 0.45F, -0.7F, 0F, -0.6F, 0.06F, 0F, -0.6F, 0.06F, 0F, 0.45F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 65
        wheel[8].setRotationPoint(0F, 0F, 0F);

        wheel[9].addShapeBox(-8F, -3F, -2.5F, 2, 3, 4, 0F, -0.6F, 0.06F, 0F, 0.45F, -0.7F, 0F, 0.45F, -0.7F, 0F, -0.6F, 0.06F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 66
        wheel[9].setRotationPoint(0F, 0F, 0F);

        wheel[10].addShapeBox(-8F, 0F, -2.5F, 2, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.6F, 0.06F, 0F, 0.45F, -0.7F, 0F, 0.45F, -0.7F, 0F, -0.6F, 0.06F, 0F); // Box 67
        wheel[10].setRotationPoint(0F, 0F, 0F);

        wheel[11].addShapeBox(3F, 5F, -2.5F, 3, 2, 4, 0F, 0.7F, -0.55F, 0F, -1.8F, 0.8F, 0F, -1.8F, 0.8F, 0F, 0.7F, -0.55F, 0F, -0.05F, 0.4F, 0F, -0.35F, -1.35F, 0F, -0.35F, -1.35F, 0F, -0.05F, 0.4F, 0F); // Box 71
        wheel[11].setRotationPoint(0F, 0F, 0F);

        wheel[12].addShapeBox(5F, 3F, -2.5F, 2, 3, 4, 0F, -0.55F, 0.7F, 0F, 0.4F, -0.05F, 0F, 0.4F, -0.05F, 0F, -0.55F, 0.7F, 0F, 0.8F, -1.8F, 0F, -1.35F, -0.35F, 0F, -1.35F, -0.35F, 0F, 0.8F, -1.8F, 0F); // Box 73
        wheel[12].setRotationPoint(0F, 0F, 0F);

        wheel[13].addShapeBox(3F, -7F, -2.5F, 3, 2, 4, 0F, -0.05F, 0.4F, 0F, -0.35F, -1.35F, 0F, -0.35F, -1.35F, 0F, -0.05F, 0.4F, 0F, 0.7F, -0.55F, 0F, -1.8F, 0.8F, 0F, -1.8F, 0.8F, 0F, 0.7F, -0.55F, 0F); // Box 74
        wheel[13].setRotationPoint(0F, 0F, 0F);

        wheel[14].addShapeBox(-6F, -7F, -2.5F, 3, 2, 4, 0F, -0.35F, -1.35F, 0F, -0.05F, 0.4F, 0F, -0.05F, 0.4F, 0F, -0.35F, -1.35F, 0F, -1.8F, 0.8F, 0F, 0.7F, -0.55F, 0F, 0.7F, -0.55F, 0F, -1.8F, 0.8F, 0F); // Box 75
        wheel[14].setRotationPoint(0F, 0F, 0F);

        wheel[15].addShapeBox(-6F, 5F, -2.5F, 3, 2, 4, 0F, -1.8F, 0.8F, 0F, 0.7F, -0.55F, 0F, 0.7F, -0.55F, 0F, -1.8F, 0.8F, 0F, -0.35F, -1.35F, 0F, -0.05F, 0.4F, 0F, -0.05F, 0.4F, 0F, -0.35F, -1.35F, 0F); // Box 76
        wheel[15].setRotationPoint(0F, 0F, 0F);

        wheel[16].addShapeBox(-7F, 3F, -2.5F, 2, 3, 4, 0F, 0.4F, -0.05F, 0F, -0.55F, 0.7F, 0F, -0.55F, 0.7F, 0F, 0.4F, -0.05F, 0F, -1.35F, -0.35F, 0F, 0.8F, -1.8F, 0F, 0.8F, -1.8F, 0F, -1.35F, -0.35F, 0F); // Box 77
        wheel[16].setRotationPoint(0F, 0F, 0F);

        wheel[17].addShapeBox(-7F, -6F, -2.5F, 2, 3, 4, 0F, -1.35F, -0.35F, 0F, 0.8F, -1.8F, 0F, 0.8F, -1.8F, 0F, -1.35F, -0.35F, 0F, 0.4F, -0.05F, 0F, -0.55F, 0.7F, 0F, -0.55F, 0.7F, 0F, 0.4F, -0.05F, 0F); // Box 78
        wheel[17].setRotationPoint(0F, 0F, 0F);

        wheel[18].addShapeBox(5F, -6F, -2.5F, 2, 3, 4, 0F, 0.8F, -1.8F, 0F, -1.35F, -0.35F, 0F, -1.35F, -0.35F, 0F, 0.8F, -1.8F, 0F, -0.55F, 0.7F, 0F, 0.4F, -0.05F, 0F, 0.4F, -0.05F, 0F, -0.55F, 0.7F, 0F); // Box 79
        wheel[18].setRotationPoint(0F, 0F, 0F);

        wheel[19].addShapeBox(0F, 5F, -2.5F, 3, 1, 4, 0F, 0F, 0F, -0.2F, -0.7F, 0.45F, -0.2F, -0.7F, 0.45F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.1F, 0.06F, -0.6F, -0.1F, 0.06F, -0.6F, -0.1F, 0F, 0F, -0.1F); // Box 81
        wheel[19].setRotationPoint(0F, 0F, 0F);

        wheel[20].addShapeBox(-3F, 5F, -2.5F, 3, 1, 4, 0F, -0.7F, 0.45F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, -0.7F, 0.45F, -0.2F, 0.06F, -0.6F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0.06F, -0.6F, -0.1F); // Box 82
        wheel[20].setRotationPoint(0F, 0F, 0F);

        wheel[21].addShapeBox(-3F, -6F, -2.5F, 3, 1, 4, 0F, 0.06F, -0.6F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0.06F, -0.6F, -0.1F, -0.7F, 0.45F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, -0.7F, 0.45F, -0.2F); // Box 83
        wheel[21].setRotationPoint(0F, 0F, 0F);

        wheel[22].addShapeBox(0F, -6F, -2.5F, 3, 1, 4, 0F, 0F, 0F, -0.1F, 0.06F, -0.6F, -0.1F, 0.06F, -0.6F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.2F, -0.7F, 0.45F, -0.2F, -0.7F, 0.45F, -0.2F, 0F, 0F, -0.2F); // Box 84
        wheel[22].setRotationPoint(0F, 0F, 0F);

        wheel[23].addShapeBox(5F, -3F, -2.5F, 1, 3, 4, 0F, 0.45F, -0.7F, -0.2F, -0.6F, 0.06F, -0.1F, -0.6F, 0.06F, -0.1F, 0.45F, -0.7F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.2F); // Box 85
        wheel[23].setRotationPoint(0F, 0F, 0F);

        wheel[24].addShapeBox(5F, 0F, -2.5F, 1, 3, 4, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.2F, 0.45F, -0.7F, -0.2F, -0.6F, 0.06F, -0.1F, -0.6F, 0.06F, -0.1F, 0.45F, -0.7F, -0.2F); // Box 86
        wheel[24].setRotationPoint(0F, 0F, 0F);

        wheel[25].addShapeBox(-6F, -3F, -2.5F, 1, 3, 4, 0F, -0.6F, 0.06F, -0.1F, 0.45F, -0.7F, -0.2F, 0.45F, -0.7F, -0.2F, -0.6F, 0.06F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.1F); // Box 87
        wheel[25].setRotationPoint(0F, 0F, 0F);

        wheel[26].addShapeBox(-6F, 0F, -2.5F, 1, 3, 4, 0F, 0F, 0F, -0.1F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.1F, -0.6F, 0.06F, -0.1F, 0.45F, -0.7F, -0.2F, 0.45F, -0.7F, -0.2F, -0.6F, 0.06F, -0.1F); // Box 88
        wheel[26].setRotationPoint(0F, 0F, 0F);

        wheel[27].addShapeBox(2F, 4F, -2.5F, 3, 1, 4, 0F, -0.2F, -0.6F, -0.2F, -0.45F, 1.7F, -0.2F, -0.45F, 1.7F, -0.2F, -0.2F, -0.6F, -0.2F, -1F, 0.3F, -0.1F, 0.4F, -2F, -0.1F, 0.4F, -2F, -0.1F, -1F, 0.3F, -0.1F); // Box 89
        wheel[27].setRotationPoint(0F, 0F, 0F);

        wheel[28].addShapeBox(2F, -5F, -2.5F, 3, 1, 4, 0F, -1F, 0.3F, -0.1F, 0.4F, -2F, -0.1F, 0.4F, -2F, -0.1F, -1F, 0.3F, -0.1F, -0.2F, -0.6F, -0.2F, -0.45F, 1.7F, -0.2F, -0.45F, 1.7F, -0.2F, -0.2F, -0.6F, -0.2F); // Box 90
        wheel[28].setRotationPoint(0F, 0F, 0F);

        wheel[29].addShapeBox(2F, -5F, -2.5F, 3, 1, 4, 0F, -1F, 0.3F, -0.1F, 0.4F, -2F, -0.1F, 0.4F, -2F, -0.1F, -1F, 0.3F, -0.1F, -0.2F, -0.6F, -0.2F, -0.5F, 1.7F, -0.2F, -0.5F, 1.7F, -0.2F, -0.2F, -0.6F, -0.2F); // Box 91
        wheel[29].setRotationPoint(0F, 0F, 0F);

        wheel[30].addShapeBox(-5.6F, -3.6F, -2.5F, 3, 1, 4, 0F, -0.2F, -0.6F, -0.1F, -0.5F, 1.7F, -0.1F, -0.5F, 1.7F, -0.1F, -0.2F, -0.6F, -0.1F, -1.05F, 0.3F, -0.2F, 0.4F, -2F, -0.2F, 0.4F, -2F, -0.2F, -1.05F, 0.3F, -0.2F); // Box 92
        wheel[30].setRotationPoint(0F, 0F, 0F);

        wheel[31].addShapeBox(-5.6F, 2.6F, -2.5F, 3, 1, 4, 0F, -1.05F, 0.3F, -0.2F, 0.4F, -2F, -0.2F, 0.4F, -2F, -0.2F, -1.05F, 0.3F, -0.2F, -0.2F, -0.6F, -0.1F, -0.5F, 1.7F, -0.1F, -0.5F, 1.7F, -0.1F, -0.2F, -0.6F, -0.1F); // Box 94
        wheel[31].setRotationPoint(0F, 0F, 0F);

        wheel[32].addShapeBox(-1.5F, 2.5F, 0F, 3, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 96
        wheel[32].setRotationPoint(0F, 0F, 0F);

        wheel[33].addShapeBox(-1.5F, 4.5F, -1F, 3, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 97
        wheel[33].setRotationPoint(0F, 0F, 0F);

        wheel[34].addShapeBox(-1.5F, 1.5F, -0.5F, 3, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 98
        wheel[34].setRotationPoint(0F, 0F, 0F);

        wheel[35].addShapeBox(-1.5F, 3.5F, 0F, 3, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1.5F, 0F, 0F, -1.5F); // Box 99
        wheel[35].setRotationPoint(0F, 0F, 0F);

        wheel[36].addShapeBox(-1.5F, -2.5F, -0.5F, 3, 1, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 100
        wheel[36].setRotationPoint(0F, 0F, 0F);

        wheel[37].addShapeBox(-1.5F, -3.5F, 0F, 3, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 101
        wheel[37].setRotationPoint(0F, 0F, 0F);

        wheel[38].addShapeBox(-1.5F, -4.5F, 0F, 3, 1, 1, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1.5F, 0F, 0F, -1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 102
        wheel[38].setRotationPoint(0F, 0F, 0F);

        wheel[39].addShapeBox(-1.5F, -5.5F, -1F, 3, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 103
        wheel[39].setRotationPoint(0F, 0F, 0F);

        wheel[40].addShapeBox(2.5F, -1.5F, 0F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 104
        wheel[40].setRotationPoint(0F, 0F, 0F);

        wheel[41].addShapeBox(1.5F, -1.5F, -0.5F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, -0.5F); // Box 105
        wheel[41].setRotationPoint(0F, 0F, 0F);

        wheel[42].addShapeBox(4.5F, -1.5F, -1F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 106
        wheel[42].setRotationPoint(0F, 0F, 0F);

        wheel[43].addShapeBox(3.5F, -1.5F, -1F, 1, 3, 1, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, 0.5F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, 0.5F); // Box 107
        wheel[43].setRotationPoint(0F, 0F, 0F);

        wheel[44].addShapeBox(-2.5F, -1.5F, -0.5F, 1, 3, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, 0F); // Box 108
        wheel[44].setRotationPoint(0F, 0F, 0F);

        wheel[45].addShapeBox(-3.5F, -1.5F, 0F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 109
        wheel[45].setRotationPoint(0F, 0F, 0F);

        wheel[46].addShapeBox(-4.5F, -1.5F, -1F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0.5F, 0F, 0F, -0.5F); // Box 111
        wheel[46].setRotationPoint(0F, 0F, 0F);

        wheel[47].addShapeBox(-5.5F, -1.5F, -1F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 112
        wheel[47].setRotationPoint(0F, 0F, 0F);

        //translateAll(0F, 0F, 0F);
        //flipAll();
    }

}
