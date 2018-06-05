package net.fexcraft.mod.addons.fvp.models.part;

import net.fexcraft.mod.fvtm.model.part.AdjustableWheelModel;
import net.fexcraft.mod.lib.tmt.Coord2D;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.tmt.Shape2D;

public class ModelT2W extends AdjustableWheelModel {

    public ModelT2W(){
    	super(); textureX = 512; textureY = 64;
        addToCreators("Ferdinand (FEX___96)");
        wheel = new ModelRendererTurbo[93];
        wheel[0] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 0
        wheel[1] = new ModelRendererTurbo(this, 49, 1, textureX, textureY); // Box 20
        wheel[2] = new ModelRendererTurbo(this, 73, 1, textureX, textureY); // Box 21
        wheel[3] = new ModelRendererTurbo(this, 97, 1, textureX, textureY); // Box 22
        wheel[4] = new ModelRendererTurbo(this, 121, 1, textureX, textureY); // Box 23
        wheel[5] = new ModelRendererTurbo(this, 145, 1, textureX, textureY); // Box 24
        wheel[6] = new ModelRendererTurbo(this, 169, 1, textureX, textureY); // Box 25
        wheel[7] = new ModelRendererTurbo(this, 193, 1, textureX, textureY); // Box 26
        wheel[8] = new ModelRendererTurbo(this, 217, 1, textureX, textureY); // Box 27
        wheel[9] = new ModelRendererTurbo(this, 241, 1, textureX, textureY); // Box 28
        wheel[10] = new ModelRendererTurbo(this, 265, 1, textureX, textureY); // Box 29
        wheel[11] = new ModelRendererTurbo(this, 289, 1, textureX, textureY); // Box 30
        wheel[12] = new ModelRendererTurbo(this, 313, 1, textureX, textureY); // Box 31
        wheel[13] = new ModelRendererTurbo(this, 337, 1, textureX, textureY); // Box 32
        wheel[14] = new ModelRendererTurbo(this, 361, 1, textureX, textureY); // Box 33
        wheel[15] = new ModelRendererTurbo(this, 385, 1, textureX, textureY); // Box 34
        wheel[16] = new ModelRendererTurbo(this, 409, 1, textureX, textureY); // Box 35
        wheel[17] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 36
        wheel[18] = new ModelRendererTurbo(this, 41, 1, textureX, textureY); // Box 37
        wheel[19] = new ModelRendererTurbo(this, 65, 1, textureX, textureY); // Box 38
        wheel[20] = new ModelRendererTurbo(this, 89, 1, textureX, textureY); // Box 39
        wheel[21] = new ModelRendererTurbo(this, 113, 1, textureX, textureY); // Box 40
        wheel[22] = new ModelRendererTurbo(this, 137, 1, textureX, textureY); // Box 41
        wheel[23] = new ModelRendererTurbo(this, 161, 1, textureX, textureY); // Box 42
        wheel[24] = new ModelRendererTurbo(this, 185, 1, textureX, textureY); // Box 43
        wheel[25] = new ModelRendererTurbo(this, 209, 1, textureX, textureY); // Box 44
        wheel[26] = new ModelRendererTurbo(this, 233, 1, textureX, textureY); // Box 45
        wheel[27] = new ModelRendererTurbo(this, 257, 1, textureX, textureY); // Box 46
        wheel[28] = new ModelRendererTurbo(this, 281, 1, textureX, textureY); // Box 47
        wheel[29] = new ModelRendererTurbo(this, 305, 1, textureX, textureY); // Box 48
        wheel[30] = new ModelRendererTurbo(this, 329, 1, textureX, textureY); // Box 49
        wheel[31] = new ModelRendererTurbo(this, 353, 1, textureX, textureY); // Box 50
        wheel[32] = new ModelRendererTurbo(this, 377, 1, textureX, textureY); // Box 51
        wheel[33] = new ModelRendererTurbo(this, 401, 1, textureX, textureY); // Box 52
        wheel[34] = new ModelRendererTurbo(this, 425, 1, textureX, textureY); // Box 53
        wheel[35] = new ModelRendererTurbo(this, 441, 1, textureX, textureY); // Box 54
        wheel[36] = new ModelRendererTurbo(this, 457, 1, textureX, textureY); // Box 55
        wheel[37] = new ModelRendererTurbo(this, 473, 1, textureX, textureY); // Box 56
        wheel[38] = new ModelRendererTurbo(this, 489, 1, textureX, textureY); // Box 57
        wheel[39] = new ModelRendererTurbo(this, 433, 9, textureX, textureY); // Box 58
        wheel[40] = new ModelRendererTurbo(this, 449, 9, textureX, textureY); // Box 59
        wheel[41] = new ModelRendererTurbo(this, 465, 9, textureX, textureY); // Box 60
        wheel[42] = new ModelRendererTurbo(this, 481, 9, textureX, textureY); // Box 61
        wheel[43] = new ModelRendererTurbo(this, 497, 9, textureX, textureY); // Box 62
        wheel[44] = new ModelRendererTurbo(this, 25, 17, textureX, textureY); // Box 63
        wheel[45] = new ModelRendererTurbo(this, 41, 17, textureX, textureY); // Box 64
        wheel[46] = new ModelRendererTurbo(this, 57, 17, textureX, textureY); // Box 65
        wheel[47] = new ModelRendererTurbo(this, 73, 17, textureX, textureY); // Box 66
        wheel[48] = new ModelRendererTurbo(this, 89, 17, textureX, textureY); // Box 67
        wheel[49] = new ModelRendererTurbo(this, 1, 12, textureX, textureY); // Shape 69
        wheel[50] = new ModelRendererTurbo(this, 1, 24, textureX, textureY); // Shape 70
        wheel[51] = new ModelRendererTurbo(this, 1, 36, textureX, textureY); // Shape 71
        wheel[52] = new ModelRendererTurbo(this, 105, 17, textureX, textureY); // Box 72
        wheel[53] = new ModelRendererTurbo(this, 121, 17, textureX, textureY); // Box 73
        wheel[54] = new ModelRendererTurbo(this, 137, 17, textureX, textureY); // Box 74
        wheel[55] = new ModelRendererTurbo(this, 153, 17, textureX, textureY); // Box 75
        wheel[56] = new ModelRendererTurbo(this, 169, 17, textureX, textureY); // Box 76
        wheel[57] = new ModelRendererTurbo(this, 185, 17, textureX, textureY); // Box 77
        wheel[58] = new ModelRendererTurbo(this, 201, 17, textureX, textureY); // Box 78
        wheel[59] = new ModelRendererTurbo(this, 217, 17, textureX, textureY); // Box 79
        wheel[60] = new ModelRendererTurbo(this, 233, 17, textureX, textureY); // Box 80
        wheel[61] = new ModelRendererTurbo(this, 249, 17, textureX, textureY); // Box 81
        wheel[62] = new ModelRendererTurbo(this, 265, 17, textureX, textureY); // Box 82
        wheel[63] = new ModelRendererTurbo(this, 281, 17, textureX, textureY); // Box 83
        wheel[64] = new ModelRendererTurbo(this, 297, 17, textureX, textureY); // Box 84
        wheel[65] = new ModelRendererTurbo(this, 313, 17, textureX, textureY); // Box 85
        wheel[66] = new ModelRendererTurbo(this, 329, 17, textureX, textureY); // Box 86
        wheel[67] = new ModelRendererTurbo(this, 345, 17, textureX, textureY); // Box 87
        wheel[68] = new ModelRendererTurbo(this, 361, 17, textureX, textureY); // Box 88
        wheel[69] = new ModelRendererTurbo(this, 377, 17, textureX, textureY); // Box 89
        wheel[70] = new ModelRendererTurbo(this, 393, 17, textureX, textureY); // Box 90
        wheel[71] = new ModelRendererTurbo(this, 409, 17, textureX, textureY); // Box 91
        wheel[72] = new ModelRendererTurbo(this, 425, 17, textureX, textureY); // Box 92
        wheel[73] = new ModelRendererTurbo(this, 441, 17, textureX, textureY); // Box 93
        wheel[74] = new ModelRendererTurbo(this, 457, 17, textureX, textureY); // Box 94
        wheel[75] = new ModelRendererTurbo(this, 473, 17, textureX, textureY); // Box 95
        wheel[76] = new ModelRendererTurbo(this, 489, 17, textureX, textureY); // Box 96
        wheel[77] = new ModelRendererTurbo(this, 17, 25, textureX, textureY); // Box 97
        wheel[78] = new ModelRendererTurbo(this, 33, 25, textureX, textureY); // Box 98
        wheel[79] = new ModelRendererTurbo(this, 49, 25, textureX, textureY); // Box 99
        wheel[80] = new ModelRendererTurbo(this, 65, 25, textureX, textureY); // Box 100
        wheel[81] = new ModelRendererTurbo(this, 81, 25, textureX, textureY); // Box 101
        wheel[82] = new ModelRendererTurbo(this, 97, 25, textureX, textureY); // Box 102
        wheel[83] = new ModelRendererTurbo(this, 505, 1, textureX, textureY); // Box 103
        wheel[84] = new ModelRendererTurbo(this, 41, 9, textureX, textureY); // Box 104
        wheel[85] = new ModelRendererTurbo(this, 505, 17, textureX, textureY); // Box 105
        wheel[86] = new ModelRendererTurbo(this, 113, 25, textureX, textureY); // Box 106
        wheel[87] = new ModelRendererTurbo(this, 121, 25, textureX, textureY); // Box 107
        wheel[88] = new ModelRendererTurbo(this, 129, 25, textureX, textureY); // Box 108
        wheel[89] = new ModelRendererTurbo(this, 137, 25, textureX, textureY); // Box 109
        wheel[90] = new ModelRendererTurbo(this, 145, 25, textureX, textureY); // Box 110
        wheel[91] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Shape 93
        wheel[92] = new ModelRendererTurbo(this, 153, 25, textureX, textureY); // Box 94

        wheel[0].addBox(-1F, -1F, -2F, 2, 2, 6, 0F); // Box 0
        wheel[0].setRotationPoint(0F, 0F, 0F);

        wheel[1].addShapeBox(0F, 9F, 0F, 5, 3, 5, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 20
        wheel[1].setRotationPoint(0F, 0F, 0F);

        wheel[2].addShapeBox(0F, 9F, 0F, 5, 3, 5, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 21
        wheel[2].setRotationPoint(0F, 0F, 0F);
        wheel[2].rotateAngleZ = 0.39269908F;

        wheel[3].addShapeBox(0F, 9F, 0F, 5, 3, 5, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 22
        wheel[3].setRotationPoint(0F, 0F, 0F);
        wheel[3].rotateAngleZ = 0.78539816F;

        wheel[4].addShapeBox(0F, 9F, 0F, 5, 3, 5, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 23
        wheel[4].setRotationPoint(0F, 0F, 0F);
        wheel[4].rotateAngleZ = 1.17809725F;

        wheel[5].addShapeBox(0F, 9F, 0F, 5, 3, 5, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 24
        wheel[5].setRotationPoint(0F, 0F, 0F);
        wheel[5].rotateAngleZ = 1.57079633F;

        wheel[6].addShapeBox(0F, 9F, 0F, 5, 3, 5, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 25
        wheel[6].setRotationPoint(0F, 0F, 0F);
        wheel[6].rotateAngleZ = 1.96349541F;

        wheel[7].addShapeBox(0F, 9F, 0F, 5, 3, 5, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 26
        wheel[7].setRotationPoint(0F, 0F, 0F);
        wheel[7].rotateAngleZ = 2.35619449F;

        wheel[8].addShapeBox(0F, 9F, 0F, 5, 3, 5, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 27
        wheel[8].setRotationPoint(0F, 0F, 0F);
        wheel[8].rotateAngleZ = 2.74889357F;

        wheel[9].addShapeBox(0F, 9F, 0F, 5, 3, 5, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 28
        wheel[9].setRotationPoint(0F, 0F, 0F);
        wheel[9].rotateAngleZ = 3.14159265F;

        wheel[10].addShapeBox(0F, 9F, 0F, 5, 3, 5, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 29
        wheel[10].setRotationPoint(0F, 0F, 0F);
        wheel[10].rotateAngleZ = 3.53429174F;

        wheel[11].addShapeBox(0F, 9F, 0F, 5, 3, 5, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 30
        wheel[11].setRotationPoint(0F, 0F, 0F);
        wheel[11].rotateAngleZ = 3.92699082F;

        wheel[12].addShapeBox(0F, 9F, 0F, 5, 3, 5, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 31
        wheel[12].setRotationPoint(0F, 0F, 0F);
        wheel[12].rotateAngleZ = 4.3196899F;

        wheel[13].addShapeBox(0F, 9F, 0F, 5, 3, 5, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 32
        wheel[13].setRotationPoint(0F, 0F, 0F);
        wheel[13].rotateAngleZ = 4.71238898F;

        wheel[14].addShapeBox(0F, 9F, 0F, 5, 3, 5, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 33
        wheel[14].setRotationPoint(0F, 0F, 0F);
        wheel[14].rotateAngleZ = 5.10508806F;

        wheel[15].addShapeBox(0F, 9F, 0F, 5, 3, 5, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 34
        wheel[15].setRotationPoint(0F, 0F, 0F);
        wheel[15].rotateAngleZ = 5.49778714F;

        wheel[16].addShapeBox(0F, 9F, 0F, 5, 3, 5, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 35
        wheel[16].setRotationPoint(0F, 0F, 0F);
        wheel[16].rotateAngleZ = 5.89048623F;

        wheel[17].addShapeBox(0F, 9F, 5F, 5, 3, 1, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.35F, 0.25F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.6F, -1.4F, -0.5F, 0F, -0.5F, -0.5F); // Box 36
        wheel[17].setRotationPoint(0F, 0F, 0F);

        wheel[18].addShapeBox(0F, 9F, 5F, 5, 3, 1, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.35F, 0.25F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.6F, -1.4F, -0.5F, 0F, -0.5F, -0.5F); // Box 37
        wheel[18].setRotationPoint(0F, 0F, 0F);
        wheel[18].rotateAngleZ = 0.39269908F;

        wheel[19].addShapeBox(0F, 9F, 5F, 5, 3, 1, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.35F, 0.25F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.6F, -1.4F, -0.5F, 0F, -0.5F, -0.5F); // Box 38
        wheel[19].setRotationPoint(0F, 0F, 0F);
        wheel[19].rotateAngleZ = 0.78539816F;

        wheel[20].addShapeBox(0F, 9F, 5F, 5, 3, 1, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.35F, 0.25F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.6F, -1.4F, -0.5F, 0F, -0.5F, -0.5F); // Box 39
        wheel[20].setRotationPoint(0F, 0F, 0F);
        wheel[20].rotateAngleZ = 1.17809725F;

        wheel[21].addShapeBox(0F, 9F, 5F, 5, 3, 1, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.35F, 0.25F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.6F, -1.4F, -0.5F, 0F, -0.5F, -0.5F); // Box 40
        wheel[21].setRotationPoint(0F, 0F, 0F);
        wheel[21].rotateAngleZ = 1.57079633F;

        wheel[22].addShapeBox(0F, 9F, 5F, 5, 3, 1, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.35F, 0.25F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.6F, -1.4F, -0.5F, 0F, -0.5F, -0.5F); // Box 41
        wheel[22].setRotationPoint(0F, 0F, 0F);
        wheel[22].rotateAngleZ = 1.96349541F;

        wheel[23].addShapeBox(0F, 9F, 5F, 5, 3, 1, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.35F, 0.25F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.6F, -1.4F, -0.5F, 0F, -0.5F, -0.5F); // Box 42
        wheel[23].setRotationPoint(0F, 0F, 0F);
        wheel[23].rotateAngleZ = 2.35619449F;

        wheel[24].addShapeBox(0F, 9F, 5F, 5, 3, 1, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.35F, 0.25F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.6F, -1.4F, -0.5F, 0F, -0.5F, -0.5F); // Box 43
        wheel[24].setRotationPoint(0F, 0F, 0F);
        wheel[24].rotateAngleZ = 2.74889357F;

        wheel[25].addShapeBox(0F, 9F, 5F, 5, 3, 1, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.35F, 0.25F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.6F, -1.4F, -0.5F, 0F, -0.5F, -0.5F); // Box 44
        wheel[25].setRotationPoint(0F, 0F, 0F);
        wheel[25].rotateAngleZ = 3.14159265F;

        wheel[26].addShapeBox(0F, 9F, 5F, 5, 3, 1, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.35F, 0.25F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.6F, -1.4F, -0.5F, 0F, -0.5F, -0.5F); // Box 45
        wheel[26].setRotationPoint(0F, 0F, 0F);
        wheel[26].rotateAngleZ = 3.53429174F;

        wheel[27].addShapeBox(0F, 9F, 5F, 5, 3, 1, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.35F, 0.25F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.6F, -1.4F, -0.5F, 0F, -0.5F, -0.5F); // Box 46
        wheel[27].setRotationPoint(0F, 0F, 0F);
        wheel[27].rotateAngleZ = 3.92699082F;

        wheel[28].addShapeBox(0F, 9F, 5F, 5, 3, 1, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.35F, 0.25F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.6F, -1.4F, -0.5F, 0F, -0.5F, -0.5F); // Box 47
        wheel[28].setRotationPoint(0F, 0F, 0F);
        wheel[28].rotateAngleZ = 4.3196899F;

        wheel[29].addShapeBox(0F, 9F, 5F, 5, 3, 1, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.35F, 0.25F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.6F, -1.4F, -0.5F, 0F, -0.5F, -0.5F); // Box 48
        wheel[29].setRotationPoint(0F, 0F, 0F);
        wheel[29].rotateAngleZ = 4.71238898F;

        wheel[30].addShapeBox(0F, 9F, 5F, 5, 3, 1, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.35F, 0.25F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.6F, -1.4F, -0.5F, 0F, -0.5F, -0.5F); // Box 49
        wheel[30].setRotationPoint(0F, 0F, 0F);
        wheel[30].rotateAngleZ = 5.10508806F;

        wheel[31].addShapeBox(0F, 9F, 5F, 5, 3, 1, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.35F, 0.25F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.6F, -1.4F, -0.5F, 0F, -0.5F, -0.5F); // Box 50
        wheel[31].setRotationPoint(0F, 0F, 0F);
        wheel[31].rotateAngleZ = 5.49778714F;

        wheel[32].addShapeBox(0F, 9F, 5F, 5, 3, 1, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.35F, 0.25F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.6F, -1.4F, -0.5F, 0F, -0.5F, -0.5F); // Box 51
        wheel[32].setRotationPoint(0F, 0F, 0F);
        wheel[32].rotateAngleZ = 5.89048623F;

        wheel[33].addShapeBox(0F, 9F, -1F, 5, 3, 1, 0F, 0F, -0.5F, -0.5F, -1.35F, 0.25F, -0.5F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -0.6F, -1.4F, -0.5F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 52
        wheel[33].setRotationPoint(0F, 0F, 0F);

        wheel[34].addShapeBox(0F, 9F, -1F, 5, 3, 1, 0F, 0F, -0.5F, -0.5F, -1.35F, 0.25F, -0.5F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -0.6F, -1.4F, -0.5F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 53
        wheel[34].setRotationPoint(0F, 0F, 0F);
        wheel[34].rotateAngleZ = 0.39269908F;

        wheel[35].addShapeBox(0F, 9F, -1F, 5, 3, 1, 0F, 0F, -0.5F, -0.5F, -1.35F, 0.25F, -0.5F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -0.6F, -1.4F, -0.5F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 54
        wheel[35].setRotationPoint(0F, 0F, 0F);
        wheel[35].rotateAngleZ = 0.78539816F;

        wheel[36].addShapeBox(0F, 9F, -1F, 5, 3, 1, 0F, 0F, -0.5F, -0.5F, -1.35F, 0.25F, -0.5F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -0.6F, -1.4F, -0.5F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 55
        wheel[36].setRotationPoint(0F, 0F, 0F);
        wheel[36].rotateAngleZ = 1.57079633F;

        wheel[37].addShapeBox(0F, 9F, -1F, 5, 3, 1, 0F, 0F, -0.5F, -0.5F, -1.35F, 0.25F, -0.5F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -0.6F, -1.4F, -0.5F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 56
        wheel[37].setRotationPoint(0F, 0F, 0F);
        wheel[37].rotateAngleZ = 1.17809725F;

        wheel[38].addShapeBox(0F, 9F, -1F, 5, 3, 1, 0F, 0F, -0.5F, -0.5F, -1.35F, 0.25F, -0.5F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -0.6F, -1.4F, -0.5F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 57
        wheel[38].setRotationPoint(0F, 0F, 0F);
        wheel[38].rotateAngleZ = 1.96349541F;

        wheel[39].addShapeBox(0F, 9F, -1F, 5, 3, 1, 0F, 0F, -0.5F, -0.5F, -1.35F, 0.25F, -0.5F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -0.6F, -1.4F, -0.5F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 58
        wheel[39].setRotationPoint(0F, 0F, 0F);
        wheel[39].rotateAngleZ = 2.35619449F;

        wheel[40].addShapeBox(0F, 9F, -1F, 5, 3, 1, 0F, 0F, -0.5F, -0.5F, -1.35F, 0.25F, -0.5F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -0.6F, -1.4F, -0.5F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 59
        wheel[40].setRotationPoint(0F, 0F, 0F);
        wheel[40].rotateAngleZ = 2.74889357F;

        wheel[41].addShapeBox(0F, 9F, -1F, 5, 3, 1, 0F, 0F, -0.5F, -0.5F, -1.35F, 0.25F, -0.5F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -0.6F, -1.4F, -0.5F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 60
        wheel[41].setRotationPoint(0F, 0F, 0F);
        wheel[41].rotateAngleZ = 3.14159265F;

        wheel[42].addShapeBox(0F, 9F, -1F, 5, 3, 1, 0F, 0F, -0.5F, -0.5F, -1.35F, 0.25F, -0.5F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -0.6F, -1.4F, -0.5F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 61
        wheel[42].setRotationPoint(0F, 0F, 0F);
        wheel[42].rotateAngleZ = 3.53429174F;

        wheel[43].addShapeBox(0F, 9F, -1F, 5, 3, 1, 0F, 0F, -0.5F, -0.5F, -1.35F, 0.25F, -0.5F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -0.6F, -1.4F, -0.5F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 62
        wheel[43].setRotationPoint(0F, 0F, 0F);
        wheel[43].rotateAngleZ = 3.92699082F;

        wheel[44].addShapeBox(0F, 9F, -1F, 5, 3, 1, 0F, 0F, -0.5F, -0.5F, -1.35F, 0.25F, -0.5F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -0.6F, -1.4F, -0.5F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 63
        wheel[44].setRotationPoint(0F, 0F, 0F);
        wheel[44].rotateAngleZ = 4.3196899F;

        wheel[45].addShapeBox(0F, 9F, -1F, 5, 3, 1, 0F, 0F, -0.5F, -0.5F, -1.35F, 0.25F, -0.5F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -0.6F, -1.4F, -0.5F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 64
        wheel[45].setRotationPoint(0F, 0F, 0F);
        wheel[45].rotateAngleZ = 4.71238898F;

        wheel[46].addShapeBox(0F, 9F, -1F, 5, 3, 1, 0F, 0F, -0.5F, -0.5F, -1.35F, 0.25F, -0.5F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -0.6F, -1.4F, -0.5F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 65
        wheel[46].setRotationPoint(0F, 0F, 0F);
        wheel[46].rotateAngleZ = 5.10508806F;

        wheel[47].addShapeBox(0F, 9F, -1F, 5, 3, 1, 0F, 0F, -0.5F, -0.5F, -1.35F, 0.25F, -0.5F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -0.6F, -1.4F, -0.5F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 66
        wheel[47].setRotationPoint(0F, 0F, 0F);
        wheel[47].rotateAngleZ = 5.49778714F;

        wheel[48].addShapeBox(0F, 9F, -1F, 5, 3, 1, 0F, 0F, -0.5F, -0.5F, -1.35F, 0.25F, -0.5F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -0.6F, -1.4F, -0.5F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 67
        wheel[48].setRotationPoint(0F, 0F, 0F);
        wheel[48].rotateAngleZ = 5.89048623F;

        wheel[49].flip = true;
        wheel[49].addShape3D(0F, 0F, -3F, new Shape2D(new Coord2D[]{new Coord2D(0, 6, 0, 6), new Coord2D(3, 5, 3, 5), new Coord2D(5, 3, 5, 3), new Coord2D(6, 0, 6, 0), new Coord2D(0, 0, 0, 0)}), 4, 6, 6, 23, 4, ModelRendererTurbo.MR_FRONT, new float[]{6, 6, 4, 3, 4}); // Shape 69
        wheel[49].setRotationPoint(0F, 0F, 0F);
        wheel[49].rotateAngleZ = 1.57079633F;

        wheel[50].flip = true;
        wheel[50].addShape3D(0F, 0F, -3F, new Shape2D(new Coord2D[]{new Coord2D(0, 6, 0, 6), new Coord2D(3, 5, 3, 5), new Coord2D(5, 3, 5, 3), new Coord2D(6, 0, 6, 0), new Coord2D(0, 0, 0, 0)}), 4, 6, 6, 23, 4, ModelRendererTurbo.MR_FRONT, new float[]{6, 6, 4, 3, 4}); // Shape 70
        wheel[50].setRotationPoint(0F, 0F, 0F);
        wheel[50].rotateAngleZ = 3.14159265F;

        wheel[51].flip = true;
        wheel[51].addShape3D(0F, 0F, -3F, new Shape2D(new Coord2D[]{new Coord2D(0, 6, 0, 6), new Coord2D(3, 5, 3, 5), new Coord2D(5, 3, 5, 3), new Coord2D(6, 0, 6, 0), new Coord2D(0, 0, 0, 0)}), 4, 6, 6, 23, 4, ModelRendererTurbo.MR_FRONT, new float[]{6, 6, 4, 3, 4}); // Shape 71
        wheel[51].setRotationPoint(0F, 0F, 0F);
        wheel[51].rotateAngleZ = 4.71238898F;

        wheel[52].addBox(-2F, 5F, 0.5F, 4, 1, 1, 0F); // Box 72
        wheel[52].setRotationPoint(0F, 0F, 0F);

        wheel[53].addBox(-2F, 8.5F, 0.5F, 4, 1, 1, 0F); // Box 73
        wheel[53].setRotationPoint(0F, 0F, 0F);
        wheel[53].rotateAngleZ = 1.57079633F;

        wheel[54].addShapeBox(-2F, 7.5F, 0.5F, 4, 1, 1, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 74
        wheel[54].setRotationPoint(0F, 0F, 0F);

        wheel[55].addShapeBox(-2F, 6F, 0.5F, 4, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F); // Box 75
        wheel[55].setRotationPoint(0F, 0F, 0F);

        wheel[56].addBox(-2F, 5F, 0.5F, 4, 1, 1, 0F); // Box 76
        wheel[56].setRotationPoint(0F, 0F, 0F);
        wheel[56].rotateAngleZ = 0.78539816F;

        wheel[57].addShapeBox(-2F, 6F, 0.5F, 4, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F); // Box 77
        wheel[57].setRotationPoint(0F, 0F, 0F);
        wheel[57].rotateAngleZ = 0.78539816F;

        wheel[58].addShapeBox(-2F, 7.5F, 0.5F, 4, 1, 1, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 78
        wheel[58].setRotationPoint(0F, 0F, 0F);
        wheel[58].rotateAngleZ = 0.78539816F;

        wheel[59].addBox(-2F, 8.5F, 0.5F, 4, 1, 1, 0F); // Box 79
        wheel[59].setRotationPoint(0F, 0F, 0F);
        wheel[59].rotateAngleZ = 0.78539816F;

        wheel[60].addBox(-2F, 5F, 0.5F, 4, 1, 1, 0F); // Box 80
        wheel[60].setRotationPoint(0F, 0F, 0F);
        wheel[60].rotateAngleZ = 1.57079633F;

        wheel[61].addShapeBox(-2F, 6F, 0.5F, 4, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F); // Box 81
        wheel[61].setRotationPoint(0F, 0F, 0F);
        wheel[61].rotateAngleZ = 1.57079633F;

        wheel[62].addShapeBox(-2F, 7.5F, 0.5F, 4, 1, 1, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 82
        wheel[62].setRotationPoint(0F, 0F, 0F);
        wheel[62].rotateAngleZ = 1.57079633F;

        wheel[63].addBox(-2F, 5F, 0.5F, 4, 1, 1, 0F); // Box 83
        wheel[63].setRotationPoint(0F, 0F, 0F);
        wheel[63].rotateAngleZ = 2.35619449F;

        wheel[64].addShapeBox(-2F, 6F, 0.5F, 4, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F); // Box 84
        wheel[64].setRotationPoint(0F, 0F, 0F);
        wheel[64].rotateAngleZ = 2.35619449F;

        wheel[65].addShapeBox(-2F, 7.5F, 0.5F, 4, 1, 1, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 85
        wheel[65].setRotationPoint(0F, 0F, 0F);
        wheel[65].rotateAngleZ = 2.35619449F;

        wheel[66].addBox(-2F, 8.5F, 0.5F, 4, 1, 1, 0F); // Box 86
        wheel[66].setRotationPoint(0F, 0F, 0F);
        wheel[66].rotateAngleZ = 2.35619449F;

        wheel[67].addBox(-2F, 5F, 0.5F, 4, 1, 1, 0F); // Box 87
        wheel[67].setRotationPoint(0F, 0F, 0F);
        wheel[67].rotateAngleZ = 3.14159265F;

        wheel[68].addShapeBox(-2F, 6F, 0.5F, 4, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F); // Box 88
        wheel[68].setRotationPoint(0F, 0F, 0F);
        wheel[68].rotateAngleZ = 3.14159265F;

        wheel[69].addShapeBox(-2F, 7.5F, 0.5F, 4, 1, 1, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 89
        wheel[69].setRotationPoint(0F, 0F, 0F);
        wheel[69].rotateAngleZ = 3.14159265F;

        wheel[70].addBox(-2F, 8.5F, 0.5F, 4, 1, 1, 0F); // Box 90
        wheel[70].setRotationPoint(0F, 0F, 0F);
        wheel[70].rotateAngleZ = 3.14159265F;

        wheel[71].addBox(-2F, 5F, 0.5F, 4, 1, 1, 0F); // Box 91
        wheel[71].setRotationPoint(0F, 0F, 0F);
        wheel[71].rotateAngleZ = 3.92699082F;

        wheel[72].addShapeBox(-2F, 6F, 0.5F, 4, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F); // Box 92
        wheel[72].setRotationPoint(0F, 0F, 0F);
        wheel[72].rotateAngleZ = 3.92699082F;

        wheel[73].addShapeBox(-2F, 7.5F, 0.5F, 4, 1, 1, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 93
        wheel[73].setRotationPoint(0F, 0F, 0F);
        wheel[73].rotateAngleZ = 3.92699082F;

        wheel[74].addBox(-2F, 8.5F, 0.5F, 4, 1, 1, 0F); // Box 94
        wheel[74].setRotationPoint(0F, 0F, 0F);
        wheel[74].rotateAngleZ = 3.92699082F;

        wheel[75].addBox(-2F, 5F, 0.5F, 4, 1, 1, 0F); // Box 95
        wheel[75].setRotationPoint(0F, 0F, 0F);
        wheel[75].rotateAngleZ = 4.71238898F;

        wheel[76].addShapeBox(-2F, 6F, 0.5F, 4, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F); // Box 96
        wheel[76].setRotationPoint(0F, 0F, 0F);
        wheel[76].rotateAngleZ = 4.71238898F;

        wheel[77].addShapeBox(-2F, 7.5F, 0.5F, 4, 1, 1, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 97
        wheel[77].setRotationPoint(0F, 0F, 0F);
        wheel[77].rotateAngleZ = 4.71238898F;

        wheel[78].addBox(-2F, 8.5F, 0.5F, 4, 1, 1, 0F); // Box 98
        wheel[78].setRotationPoint(0F, 0F, 0F);
        wheel[78].rotateAngleZ = 4.71238898F;

        wheel[79].addBox(-2F, 5F, 0.5F, 4, 1, 1, 0F); // Box 99
        wheel[79].setRotationPoint(0F, 0F, 0F);
        wheel[79].rotateAngleZ = 5.49778714F;

        wheel[80].addShapeBox(-2F, 6F, 0.5F, 4, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F); // Box 100
        wheel[80].setRotationPoint(0F, 0F, 0F);
        wheel[80].rotateAngleZ = 5.49778714F;

        wheel[81].addShapeBox(-2F, 7.5F, 0.5F, 4, 1, 1, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 101
        wheel[81].setRotationPoint(0F, 0F, 0F);
        wheel[81].rotateAngleZ = 5.49778714F;

        wheel[82].addBox(-2F, 8.5F, 0.5F, 4, 1, 1, 0F); // Box 102
        wheel[82].setRotationPoint(0F, 0F, 0F);
        wheel[82].rotateAngleZ = 5.49778714F;

        wheel[83].addBox(-0.5F, 4F, 2.5F, 1, 1, 1, 0F); // Box 103
        wheel[83].setRotationPoint(0F, 0F, 0F);

        wheel[84].addBox(-0.5F, 4F, 2.5F, 1, 1, 1, 0F); // Box 104
        wheel[84].setRotationPoint(0F, 0F, 0F);
        wheel[84].rotateAngleZ = 0.78539816F;

        wheel[85].addBox(-0.5F, 4F, 2.5F, 1, 1, 1, 0F); // Box 105
        wheel[85].setRotationPoint(0F, 0F, 0F);
        wheel[85].rotateAngleZ = 1.57079633F;

        wheel[86].addBox(-0.5F, 4F, 2.5F, 1, 1, 1, 0F); // Box 106
        wheel[86].setRotationPoint(0F, 0F, 0F);
        wheel[86].rotateAngleZ = 2.35619449F;

        wheel[87].addBox(-0.5F, 4F, 2.5F, 1, 1, 1, 0F); // Box 107
        wheel[87].setRotationPoint(0F, 0F, 0F);
        wheel[87].rotateAngleZ = 3.14159265F;

        wheel[88].addBox(-0.5F, 4F, 2.5F, 1, 1, 1, 0F); // Box 108
        wheel[88].setRotationPoint(0F, 0F, 0F);
        wheel[88].rotateAngleZ = 3.92699082F;

        wheel[89].addBox(-0.5F, 4F, 2.5F, 1, 1, 1, 0F); // Box 109
        wheel[89].setRotationPoint(0F, 0F, 0F);
        wheel[89].rotateAngleZ = 4.71238898F;

        wheel[90].addBox(-0.5F, 4F, 2.5F, 1, 1, 1, 0F); // Box 110
        wheel[90].setRotationPoint(0F, 0F, 0F);
        wheel[90].rotateAngleZ = 5.49778714F;

        wheel[91].flip = true;
        wheel[91].addShape3D(0F, 0F, -3F, new Shape2D(new Coord2D[]{new Coord2D(0, 6, 0, 6), new Coord2D(3, 5, 3, 5), new Coord2D(5, 3, 5, 3), new Coord2D(6, 0, 6, 0), new Coord2D(0, 0, 0, 0)}), 4, 6, 6, 23, 4, ModelRendererTurbo.MR_FRONT, new float[]{6, 6, 4, 3, 4}); // Shape 93
        wheel[91].setRotationPoint(0F, 0F, 0F);

        wheel[92].addBox(-2F, 8.5F, 0.5F, 4, 1, 1, 0F); // Box 94
        wheel[92].setRotationPoint(0F, 0F, 0F);

        translateAll(0F, 0F, 0F);
        flipAll();
    }

}
