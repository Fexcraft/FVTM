package net.fexcraft.mod.addons.fvp.models.part;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.part.PartModel;
import net.fexcraft.mod.lib.tmt.Coord2D;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.tmt.Shape2D;
import net.minecraft.entity.Entity;

public class ModelT2W extends PartModel<VehicleData>{
	
	int textureX = 512;
	int textureY = 64;

	public ModelT2W(){
		body = new ModelRendererTurbo[93];
		body[0] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 0
		body[1] = new ModelRendererTurbo(this, 49, 1, textureX, textureY); // Box 20
		body[2] = new ModelRendererTurbo(this, 73, 1, textureX, textureY); // Box 21
		body[3] = new ModelRendererTurbo(this, 97, 1, textureX, textureY); // Box 22
		body[4] = new ModelRendererTurbo(this, 121, 1, textureX, textureY); // Box 23
		body[5] = new ModelRendererTurbo(this, 145, 1, textureX, textureY); // Box 24
		body[6] = new ModelRendererTurbo(this, 169, 1, textureX, textureY); // Box 25
		body[7] = new ModelRendererTurbo(this, 193, 1, textureX, textureY); // Box 26
		body[8] = new ModelRendererTurbo(this, 217, 1, textureX, textureY); // Box 27
		body[9] = new ModelRendererTurbo(this, 241, 1, textureX, textureY); // Box 28
		body[10] = new ModelRendererTurbo(this, 265, 1, textureX, textureY); // Box 29
		body[11] = new ModelRendererTurbo(this, 289, 1, textureX, textureY); // Box 30
		body[12] = new ModelRendererTurbo(this, 313, 1, textureX, textureY); // Box 31
		body[13] = new ModelRendererTurbo(this, 337, 1, textureX, textureY); // Box 32
		body[14] = new ModelRendererTurbo(this, 361, 1, textureX, textureY); // Box 33
		body[15] = new ModelRendererTurbo(this, 385, 1, textureX, textureY); // Box 34
		body[16] = new ModelRendererTurbo(this, 409, 1, textureX, textureY); // Box 35
		body[17] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 36
		body[18] = new ModelRendererTurbo(this, 41, 1, textureX, textureY); // Box 37
		body[19] = new ModelRendererTurbo(this, 65, 1, textureX, textureY); // Box 38
		body[20] = new ModelRendererTurbo(this, 89, 1, textureX, textureY); // Box 39
		body[21] = new ModelRendererTurbo(this, 113, 1, textureX, textureY); // Box 40
		body[22] = new ModelRendererTurbo(this, 137, 1, textureX, textureY); // Box 41
		body[23] = new ModelRendererTurbo(this, 161, 1, textureX, textureY); // Box 42
		body[24] = new ModelRendererTurbo(this, 185, 1, textureX, textureY); // Box 43
		body[25] = new ModelRendererTurbo(this, 209, 1, textureX, textureY); // Box 44
		body[26] = new ModelRendererTurbo(this, 233, 1, textureX, textureY); // Box 45
		body[27] = new ModelRendererTurbo(this, 257, 1, textureX, textureY); // Box 46
		body[28] = new ModelRendererTurbo(this, 281, 1, textureX, textureY); // Box 47
		body[29] = new ModelRendererTurbo(this, 305, 1, textureX, textureY); // Box 48
		body[30] = new ModelRendererTurbo(this, 329, 1, textureX, textureY); // Box 49
		body[31] = new ModelRendererTurbo(this, 353, 1, textureX, textureY); // Box 50
		body[32] = new ModelRendererTurbo(this, 377, 1, textureX, textureY); // Box 51
		body[33] = new ModelRendererTurbo(this, 401, 1, textureX, textureY); // Box 52
		body[34] = new ModelRendererTurbo(this, 425, 1, textureX, textureY); // Box 53
		body[35] = new ModelRendererTurbo(this, 441, 1, textureX, textureY); // Box 54
		body[36] = new ModelRendererTurbo(this, 457, 1, textureX, textureY); // Box 55
		body[37] = new ModelRendererTurbo(this, 473, 1, textureX, textureY); // Box 56
		body[38] = new ModelRendererTurbo(this, 489, 1, textureX, textureY); // Box 57
		body[39] = new ModelRendererTurbo(this, 433, 9, textureX, textureY); // Box 58
		body[40] = new ModelRendererTurbo(this, 449, 9, textureX, textureY); // Box 59
		body[41] = new ModelRendererTurbo(this, 465, 9, textureX, textureY); // Box 60
		body[42] = new ModelRendererTurbo(this, 481, 9, textureX, textureY); // Box 61
		body[43] = new ModelRendererTurbo(this, 497, 9, textureX, textureY); // Box 62
		body[44] = new ModelRendererTurbo(this, 25, 17, textureX, textureY); // Box 63
		body[45] = new ModelRendererTurbo(this, 41, 17, textureX, textureY); // Box 64
		body[46] = new ModelRendererTurbo(this, 57, 17, textureX, textureY); // Box 65
		body[47] = new ModelRendererTurbo(this, 73, 17, textureX, textureY); // Box 66
		body[48] = new ModelRendererTurbo(this, 89, 17, textureX, textureY); // Box 67
		body[49] = new ModelRendererTurbo(this, 1, 12, textureX, textureY); // Shape 69
		body[50] = new ModelRendererTurbo(this, 1, 24, textureX, textureY); // Shape 70
		body[51] = new ModelRendererTurbo(this, 1, 36, textureX, textureY); // Shape 71
		body[52] = new ModelRendererTurbo(this, 105, 17, textureX, textureY); // Box 72
		body[53] = new ModelRendererTurbo(this, 121, 17, textureX, textureY); // Box 73
		body[54] = new ModelRendererTurbo(this, 137, 17, textureX, textureY); // Box 74
		body[55] = new ModelRendererTurbo(this, 153, 17, textureX, textureY); // Box 75
		body[56] = new ModelRendererTurbo(this, 169, 17, textureX, textureY); // Box 76
		body[57] = new ModelRendererTurbo(this, 185, 17, textureX, textureY); // Box 77
		body[58] = new ModelRendererTurbo(this, 201, 17, textureX, textureY); // Box 78
		body[59] = new ModelRendererTurbo(this, 217, 17, textureX, textureY); // Box 79
		body[60] = new ModelRendererTurbo(this, 233, 17, textureX, textureY); // Box 80
		body[61] = new ModelRendererTurbo(this, 249, 17, textureX, textureY); // Box 81
		body[62] = new ModelRendererTurbo(this, 265, 17, textureX, textureY); // Box 82
		body[63] = new ModelRendererTurbo(this, 281, 17, textureX, textureY); // Box 83
		body[64] = new ModelRendererTurbo(this, 297, 17, textureX, textureY); // Box 84
		body[65] = new ModelRendererTurbo(this, 313, 17, textureX, textureY); // Box 85
		body[66] = new ModelRendererTurbo(this, 329, 17, textureX, textureY); // Box 86
		body[67] = new ModelRendererTurbo(this, 345, 17, textureX, textureY); // Box 87
		body[68] = new ModelRendererTurbo(this, 361, 17, textureX, textureY); // Box 88
		body[69] = new ModelRendererTurbo(this, 377, 17, textureX, textureY); // Box 89
		body[70] = new ModelRendererTurbo(this, 393, 17, textureX, textureY); // Box 90
		body[71] = new ModelRendererTurbo(this, 409, 17, textureX, textureY); // Box 91
		body[72] = new ModelRendererTurbo(this, 425, 17, textureX, textureY); // Box 92
		body[73] = new ModelRendererTurbo(this, 441, 17, textureX, textureY); // Box 93
		body[74] = new ModelRendererTurbo(this, 457, 17, textureX, textureY); // Box 94
		body[75] = new ModelRendererTurbo(this, 473, 17, textureX, textureY); // Box 95
		body[76] = new ModelRendererTurbo(this, 489, 17, textureX, textureY); // Box 96
		body[77] = new ModelRendererTurbo(this, 17, 25, textureX, textureY); // Box 97
		body[78] = new ModelRendererTurbo(this, 33, 25, textureX, textureY); // Box 98
		body[79] = new ModelRendererTurbo(this, 49, 25, textureX, textureY); // Box 99
		body[80] = new ModelRendererTurbo(this, 65, 25, textureX, textureY); // Box 100
		body[81] = new ModelRendererTurbo(this, 81, 25, textureX, textureY); // Box 101
		body[82] = new ModelRendererTurbo(this, 97, 25, textureX, textureY); // Box 102
		body[83] = new ModelRendererTurbo(this, 505, 1, textureX, textureY); // Box 103
		body[84] = new ModelRendererTurbo(this, 41, 9, textureX, textureY); // Box 104
		body[85] = new ModelRendererTurbo(this, 505, 17, textureX, textureY); // Box 105
		body[86] = new ModelRendererTurbo(this, 113, 25, textureX, textureY); // Box 106
		body[87] = new ModelRendererTurbo(this, 121, 25, textureX, textureY); // Box 107
		body[88] = new ModelRendererTurbo(this, 129, 25, textureX, textureY); // Box 108
		body[89] = new ModelRendererTurbo(this, 137, 25, textureX, textureY); // Box 109
		body[90] = new ModelRendererTurbo(this, 145, 25, textureX, textureY); // Box 110
		body[91] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Shape 93
		body[92] = new ModelRendererTurbo(this, 153, 25, textureX, textureY); // Box 94

		body[0].addBox(-1F, -1F, -2F, 2, 2, 6, 0F); // Box 0
		body[0].setRotationPoint(0F, 0F, 0F);

		body[1].addShapeBox(0F, 9F, 0F, 5, 3, 5, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 20
		body[1].setRotationPoint(0F, 0F, 0F);

		body[2].addShapeBox(0F, 9F, 0F, 5, 3, 5, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 21
		body[2].setRotationPoint(0F, 0F, 0F);
		body[2].rotateAngleZ = 0.39269908F;

		body[3].addShapeBox(0F, 9F, 0F, 5, 3, 5, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 22
		body[3].setRotationPoint(0F, 0F, 0F);
		body[3].rotateAngleZ = 0.78539816F;

		body[4].addShapeBox(0F, 9F, 0F, 5, 3, 5, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 23
		body[4].setRotationPoint(0F, 0F, 0F);
		body[4].rotateAngleZ = 1.17809725F;

		body[5].addShapeBox(0F, 9F, 0F, 5, 3, 5, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 24
		body[5].setRotationPoint(0F, 0F, 0F);
		body[5].rotateAngleZ = 1.57079633F;

		body[6].addShapeBox(0F, 9F, 0F, 5, 3, 5, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 25
		body[6].setRotationPoint(0F, 0F, 0F);
		body[6].rotateAngleZ = 1.96349541F;

		body[7].addShapeBox(0F, 9F, 0F, 5, 3, 5, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 26
		body[7].setRotationPoint(0F, 0F, 0F);
		body[7].rotateAngleZ = 2.35619449F;

		body[8].addShapeBox(0F, 9F, 0F, 5, 3, 5, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 27
		body[8].setRotationPoint(0F, 0F, 0F);
		body[8].rotateAngleZ = 2.74889357F;

		body[9].addShapeBox(0F, 9F, 0F, 5, 3, 5, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 28
		body[9].setRotationPoint(0F, 0F, 0F);
		body[9].rotateAngleZ = 3.14159265F;

		body[10].addShapeBox(0F, 9F, 0F, 5, 3, 5, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 29
		body[10].setRotationPoint(0F, 0F, 0F);
		body[10].rotateAngleZ = 3.53429174F;

		body[11].addShapeBox(0F, 9F, 0F, 5, 3, 5, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 30
		body[11].setRotationPoint(0F, 0F, 0F);
		body[11].rotateAngleZ = 3.92699082F;

		body[12].addShapeBox(0F, 9F, 0F, 5, 3, 5, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 31
		body[12].setRotationPoint(0F, 0F, 0F);
		body[12].rotateAngleZ = 4.3196899F;

		body[13].addShapeBox(0F, 9F, 0F, 5, 3, 5, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 32
		body[13].setRotationPoint(0F, 0F, 0F);
		body[13].rotateAngleZ = 4.71238898F;

		body[14].addShapeBox(0F, 9F, 0F, 5, 3, 5, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 33
		body[14].setRotationPoint(0F, 0F, 0F);
		body[14].rotateAngleZ = 5.10508806F;

		body[15].addShapeBox(0F, 9F, 0F, 5, 3, 5, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 34
		body[15].setRotationPoint(0F, 0F, 0F);
		body[15].rotateAngleZ = 5.49778714F;

		body[16].addShapeBox(0F, 9F, 0F, 5, 3, 5, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 35
		body[16].setRotationPoint(0F, 0F, 0F);
		body[16].rotateAngleZ = 5.89048623F;

		body[17].addShapeBox(0F, 9F, 5F, 5, 3, 1, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.35F, 0.25F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.6F, -1.4F, -0.5F, 0F, -0.5F, -0.5F); // Box 36
		body[17].setRotationPoint(0F, 0F, 0F);

		body[18].addShapeBox(0F, 9F, 5F, 5, 3, 1, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.35F, 0.25F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.6F, -1.4F, -0.5F, 0F, -0.5F, -0.5F); // Box 37
		body[18].setRotationPoint(0F, 0F, 0F);
		body[18].rotateAngleZ = 0.39269908F;

		body[19].addShapeBox(0F, 9F, 5F, 5, 3, 1, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.35F, 0.25F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.6F, -1.4F, -0.5F, 0F, -0.5F, -0.5F); // Box 38
		body[19].setRotationPoint(0F, 0F, 0F);
		body[19].rotateAngleZ = 0.78539816F;

		body[20].addShapeBox(0F, 9F, 5F, 5, 3, 1, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.35F, 0.25F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.6F, -1.4F, -0.5F, 0F, -0.5F, -0.5F); // Box 39
		body[20].setRotationPoint(0F, 0F, 0F);
		body[20].rotateAngleZ = 1.17809725F;

		body[21].addShapeBox(0F, 9F, 5F, 5, 3, 1, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.35F, 0.25F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.6F, -1.4F, -0.5F, 0F, -0.5F, -0.5F); // Box 40
		body[21].setRotationPoint(0F, 0F, 0F);
		body[21].rotateAngleZ = 1.57079633F;

		body[22].addShapeBox(0F, 9F, 5F, 5, 3, 1, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.35F, 0.25F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.6F, -1.4F, -0.5F, 0F, -0.5F, -0.5F); // Box 41
		body[22].setRotationPoint(0F, 0F, 0F);
		body[22].rotateAngleZ = 1.96349541F;

		body[23].addShapeBox(0F, 9F, 5F, 5, 3, 1, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.35F, 0.25F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.6F, -1.4F, -0.5F, 0F, -0.5F, -0.5F); // Box 42
		body[23].setRotationPoint(0F, 0F, 0F);
		body[23].rotateAngleZ = 2.35619449F;

		body[24].addShapeBox(0F, 9F, 5F, 5, 3, 1, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.35F, 0.25F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.6F, -1.4F, -0.5F, 0F, -0.5F, -0.5F); // Box 43
		body[24].setRotationPoint(0F, 0F, 0F);
		body[24].rotateAngleZ = 2.74889357F;

		body[25].addShapeBox(0F, 9F, 5F, 5, 3, 1, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.35F, 0.25F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.6F, -1.4F, -0.5F, 0F, -0.5F, -0.5F); // Box 44
		body[25].setRotationPoint(0F, 0F, 0F);
		body[25].rotateAngleZ = 3.14159265F;

		body[26].addShapeBox(0F, 9F, 5F, 5, 3, 1, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.35F, 0.25F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.6F, -1.4F, -0.5F, 0F, -0.5F, -0.5F); // Box 45
		body[26].setRotationPoint(0F, 0F, 0F);
		body[26].rotateAngleZ = 3.53429174F;

		body[27].addShapeBox(0F, 9F, 5F, 5, 3, 1, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.35F, 0.25F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.6F, -1.4F, -0.5F, 0F, -0.5F, -0.5F); // Box 46
		body[27].setRotationPoint(0F, 0F, 0F);
		body[27].rotateAngleZ = 3.92699082F;

		body[28].addShapeBox(0F, 9F, 5F, 5, 3, 1, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.35F, 0.25F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.6F, -1.4F, -0.5F, 0F, -0.5F, -0.5F); // Box 47
		body[28].setRotationPoint(0F, 0F, 0F);
		body[28].rotateAngleZ = 4.3196899F;

		body[29].addShapeBox(0F, 9F, 5F, 5, 3, 1, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.35F, 0.25F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.6F, -1.4F, -0.5F, 0F, -0.5F, -0.5F); // Box 48
		body[29].setRotationPoint(0F, 0F, 0F);
		body[29].rotateAngleZ = 4.71238898F;

		body[30].addShapeBox(0F, 9F, 5F, 5, 3, 1, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.35F, 0.25F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.6F, -1.4F, -0.5F, 0F, -0.5F, -0.5F); // Box 49
		body[30].setRotationPoint(0F, 0F, 0F);
		body[30].rotateAngleZ = 5.10508806F;

		body[31].addShapeBox(0F, 9F, 5F, 5, 3, 1, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.35F, 0.25F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.6F, -1.4F, -0.5F, 0F, -0.5F, -0.5F); // Box 50
		body[31].setRotationPoint(0F, 0F, 0F);
		body[31].rotateAngleZ = 5.49778714F;

		body[32].addShapeBox(0F, 9F, 5F, 5, 3, 1, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.35F, 0.25F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.6F, -1.4F, -0.5F, 0F, -0.5F, -0.5F); // Box 51
		body[32].setRotationPoint(0F, 0F, 0F);
		body[32].rotateAngleZ = 5.89048623F;

		body[33].addShapeBox(0F, 9F, -1F, 5, 3, 1, 0F, 0F, -0.5F, -0.5F, -1.35F, 0.25F, -0.5F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -0.6F, -1.4F, -0.5F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 52
		body[33].setRotationPoint(0F, 0F, 0F);

		body[34].addShapeBox(0F, 9F, -1F, 5, 3, 1, 0F, 0F, -0.5F, -0.5F, -1.35F, 0.25F, -0.5F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -0.6F, -1.4F, -0.5F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 53
		body[34].setRotationPoint(0F, 0F, 0F);
		body[34].rotateAngleZ = 0.39269908F;

		body[35].addShapeBox(0F, 9F, -1F, 5, 3, 1, 0F, 0F, -0.5F, -0.5F, -1.35F, 0.25F, -0.5F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -0.6F, -1.4F, -0.5F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 54
		body[35].setRotationPoint(0F, 0F, 0F);
		body[35].rotateAngleZ = 0.78539816F;

		body[36].addShapeBox(0F, 9F, -1F, 5, 3, 1, 0F, 0F, -0.5F, -0.5F, -1.35F, 0.25F, -0.5F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -0.6F, -1.4F, -0.5F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 55
		body[36].setRotationPoint(0F, 0F, 0F);
		body[36].rotateAngleZ = 1.57079633F;

		body[37].addShapeBox(0F, 9F, -1F, 5, 3, 1, 0F, 0F, -0.5F, -0.5F, -1.35F, 0.25F, -0.5F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -0.6F, -1.4F, -0.5F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 56
		body[37].setRotationPoint(0F, 0F, 0F);
		body[37].rotateAngleZ = 1.17809725F;

		body[38].addShapeBox(0F, 9F, -1F, 5, 3, 1, 0F, 0F, -0.5F, -0.5F, -1.35F, 0.25F, -0.5F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -0.6F, -1.4F, -0.5F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 57
		body[38].setRotationPoint(0F, 0F, 0F);
		body[38].rotateAngleZ = 1.96349541F;

		body[39].addShapeBox(0F, 9F, -1F, 5, 3, 1, 0F, 0F, -0.5F, -0.5F, -1.35F, 0.25F, -0.5F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -0.6F, -1.4F, -0.5F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 58
		body[39].setRotationPoint(0F, 0F, 0F);
		body[39].rotateAngleZ = 2.35619449F;

		body[40].addShapeBox(0F, 9F, -1F, 5, 3, 1, 0F, 0F, -0.5F, -0.5F, -1.35F, 0.25F, -0.5F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -0.6F, -1.4F, -0.5F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 59
		body[40].setRotationPoint(0F, 0F, 0F);
		body[40].rotateAngleZ = 2.74889357F;

		body[41].addShapeBox(0F, 9F, -1F, 5, 3, 1, 0F, 0F, -0.5F, -0.5F, -1.35F, 0.25F, -0.5F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -0.6F, -1.4F, -0.5F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 60
		body[41].setRotationPoint(0F, 0F, 0F);
		body[41].rotateAngleZ = 3.14159265F;

		body[42].addShapeBox(0F, 9F, -1F, 5, 3, 1, 0F, 0F, -0.5F, -0.5F, -1.35F, 0.25F, -0.5F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -0.6F, -1.4F, -0.5F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 61
		body[42].setRotationPoint(0F, 0F, 0F);
		body[42].rotateAngleZ = 3.53429174F;

		body[43].addShapeBox(0F, 9F, -1F, 5, 3, 1, 0F, 0F, -0.5F, -0.5F, -1.35F, 0.25F, -0.5F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -0.6F, -1.4F, -0.5F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 62
		body[43].setRotationPoint(0F, 0F, 0F);
		body[43].rotateAngleZ = 3.92699082F;

		body[44].addShapeBox(0F, 9F, -1F, 5, 3, 1, 0F, 0F, -0.5F, -0.5F, -1.35F, 0.25F, -0.5F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -0.6F, -1.4F, -0.5F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 63
		body[44].setRotationPoint(0F, 0F, 0F);
		body[44].rotateAngleZ = 4.3196899F;

		body[45].addShapeBox(0F, 9F, -1F, 5, 3, 1, 0F, 0F, -0.5F, -0.5F, -1.35F, 0.25F, -0.5F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -0.6F, -1.4F, -0.5F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 64
		body[45].setRotationPoint(0F, 0F, 0F);
		body[45].rotateAngleZ = 4.71238898F;

		body[46].addShapeBox(0F, 9F, -1F, 5, 3, 1, 0F, 0F, -0.5F, -0.5F, -1.35F, 0.25F, -0.5F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -0.6F, -1.4F, -0.5F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 65
		body[46].setRotationPoint(0F, 0F, 0F);
		body[46].rotateAngleZ = 5.10508806F;

		body[47].addShapeBox(0F, 9F, -1F, 5, 3, 1, 0F, 0F, -0.5F, -0.5F, -1.35F, 0.25F, -0.5F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -0.6F, -1.4F, -0.5F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 66
		body[47].setRotationPoint(0F, 0F, 0F);
		body[47].rotateAngleZ = 5.49778714F;

		body[48].addShapeBox(0F, 9F, -1F, 5, 3, 1, 0F, 0F, -0.5F, -0.5F, -1.35F, 0.25F, -0.5F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -0.6F, -1.4F, -0.5F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 67
		body[48].setRotationPoint(0F, 0F, 0F);
		body[48].rotateAngleZ = 5.89048623F;

		body[49].flip = true;
		body[49].addShape3D(0F, 0F, -3F, new Shape2D(new Coord2D[] { new Coord2D(0, 6, 0, 6), new Coord2D(3, 5, 3, 5), new Coord2D(5, 3, 5, 3), new Coord2D(6, 0, 6, 0), new Coord2D(0, 0, 0, 0) }), 4, 6, 6, 23, 4, ModelRendererTurbo.MR_FRONT, new float[] {6 ,6 ,4 ,3 ,4}); // Shape 69
		body[49].setRotationPoint(0F, 0F, 0F);
		body[49].rotateAngleZ = 1.57079633F;

		body[50].flip = true;
		body[50].addShape3D(0F, 0F, -3F, new Shape2D(new Coord2D[] { new Coord2D(0, 6, 0, 6), new Coord2D(3, 5, 3, 5), new Coord2D(5, 3, 5, 3), new Coord2D(6, 0, 6, 0), new Coord2D(0, 0, 0, 0) }), 4, 6, 6, 23, 4, ModelRendererTurbo.MR_FRONT, new float[] {6 ,6 ,4 ,3 ,4}); // Shape 70
		body[50].setRotationPoint(0F, 0F, 0F);
		body[50].rotateAngleZ = 3.14159265F;

		body[51].flip = true;
		body[51].addShape3D(0F, 0F, -3F, new Shape2D(new Coord2D[] { new Coord2D(0, 6, 0, 6), new Coord2D(3, 5, 3, 5), new Coord2D(5, 3, 5, 3), new Coord2D(6, 0, 6, 0), new Coord2D(0, 0, 0, 0) }), 4, 6, 6, 23, 4, ModelRendererTurbo.MR_FRONT, new float[] {6 ,6 ,4 ,3 ,4}); // Shape 71
		body[51].setRotationPoint(0F, 0F, 0F);
		body[51].rotateAngleZ = 4.71238898F;

		body[52].addBox(-2F, 5F, 0.5F, 4, 1, 1, 0F); // Box 72
		body[52].setRotationPoint(0F, 0F, 0F);

		body[53].addBox(-2F, 8.5F, 0.5F, 4, 1, 1, 0F); // Box 73
		body[53].setRotationPoint(0F, 0F, 0F);
		body[53].rotateAngleZ = 1.57079633F;

		body[54].addShapeBox(-2F, 7.5F, 0.5F, 4, 1, 1, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 74
		body[54].setRotationPoint(0F, 0F, 0F);

		body[55].addShapeBox(-2F, 6F, 0.5F, 4, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F); // Box 75
		body[55].setRotationPoint(0F, 0F, 0F);

		body[56].addBox(-2F, 5F, 0.5F, 4, 1, 1, 0F); // Box 76
		body[56].setRotationPoint(0F, 0F, 0F);
		body[56].rotateAngleZ = 0.78539816F;

		body[57].addShapeBox(-2F, 6F, 0.5F, 4, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F); // Box 77
		body[57].setRotationPoint(0F, 0F, 0F);
		body[57].rotateAngleZ = 0.78539816F;

		body[58].addShapeBox(-2F, 7.5F, 0.5F, 4, 1, 1, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 78
		body[58].setRotationPoint(0F, 0F, 0F);
		body[58].rotateAngleZ = 0.78539816F;

		body[59].addBox(-2F, 8.5F, 0.5F, 4, 1, 1, 0F); // Box 79
		body[59].setRotationPoint(0F, 0F, 0F);
		body[59].rotateAngleZ = 0.78539816F;

		body[60].addBox(-2F, 5F, 0.5F, 4, 1, 1, 0F); // Box 80
		body[60].setRotationPoint(0F, 0F, 0F);
		body[60].rotateAngleZ = 1.57079633F;

		body[61].addShapeBox(-2F, 6F, 0.5F, 4, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F); // Box 81
		body[61].setRotationPoint(0F, 0F, 0F);
		body[61].rotateAngleZ = 1.57079633F;

		body[62].addShapeBox(-2F, 7.5F, 0.5F, 4, 1, 1, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 82
		body[62].setRotationPoint(0F, 0F, 0F);
		body[62].rotateAngleZ = 1.57079633F;

		body[63].addBox(-2F, 5F, 0.5F, 4, 1, 1, 0F); // Box 83
		body[63].setRotationPoint(0F, 0F, 0F);
		body[63].rotateAngleZ = 2.35619449F;

		body[64].addShapeBox(-2F, 6F, 0.5F, 4, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F); // Box 84
		body[64].setRotationPoint(0F, 0F, 0F);
		body[64].rotateAngleZ = 2.35619449F;

		body[65].addShapeBox(-2F, 7.5F, 0.5F, 4, 1, 1, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 85
		body[65].setRotationPoint(0F, 0F, 0F);
		body[65].rotateAngleZ = 2.35619449F;

		body[66].addBox(-2F, 8.5F, 0.5F, 4, 1, 1, 0F); // Box 86
		body[66].setRotationPoint(0F, 0F, 0F);
		body[66].rotateAngleZ = 2.35619449F;

		body[67].addBox(-2F, 5F, 0.5F, 4, 1, 1, 0F); // Box 87
		body[67].setRotationPoint(0F, 0F, 0F);
		body[67].rotateAngleZ = 3.14159265F;

		body[68].addShapeBox(-2F, 6F, 0.5F, 4, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F); // Box 88
		body[68].setRotationPoint(0F, 0F, 0F);
		body[68].rotateAngleZ = 3.14159265F;

		body[69].addShapeBox(-2F, 7.5F, 0.5F, 4, 1, 1, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 89
		body[69].setRotationPoint(0F, 0F, 0F);
		body[69].rotateAngleZ = 3.14159265F;

		body[70].addBox(-2F, 8.5F, 0.5F, 4, 1, 1, 0F); // Box 90
		body[70].setRotationPoint(0F, 0F, 0F);
		body[70].rotateAngleZ = 3.14159265F;

		body[71].addBox(-2F, 5F, 0.5F, 4, 1, 1, 0F); // Box 91
		body[71].setRotationPoint(0F, 0F, 0F);
		body[71].rotateAngleZ = 3.92699082F;

		body[72].addShapeBox(-2F, 6F, 0.5F, 4, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F); // Box 92
		body[72].setRotationPoint(0F, 0F, 0F);
		body[72].rotateAngleZ = 3.92699082F;

		body[73].addShapeBox(-2F, 7.5F, 0.5F, 4, 1, 1, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 93
		body[73].setRotationPoint(0F, 0F, 0F);
		body[73].rotateAngleZ = 3.92699082F;

		body[74].addBox(-2F, 8.5F, 0.5F, 4, 1, 1, 0F); // Box 94
		body[74].setRotationPoint(0F, 0F, 0F);
		body[74].rotateAngleZ = 3.92699082F;

		body[75].addBox(-2F, 5F, 0.5F, 4, 1, 1, 0F); // Box 95
		body[75].setRotationPoint(0F, 0F, 0F);
		body[75].rotateAngleZ = 4.71238898F;

		body[76].addShapeBox(-2F, 6F, 0.5F, 4, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F); // Box 96
		body[76].setRotationPoint(0F, 0F, 0F);
		body[76].rotateAngleZ = 4.71238898F;

		body[77].addShapeBox(-2F, 7.5F, 0.5F, 4, 1, 1, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 97
		body[77].setRotationPoint(0F, 0F, 0F);
		body[77].rotateAngleZ = 4.71238898F;

		body[78].addBox(-2F, 8.5F, 0.5F, 4, 1, 1, 0F); // Box 98
		body[78].setRotationPoint(0F, 0F, 0F);
		body[78].rotateAngleZ = 4.71238898F;

		body[79].addBox(-2F, 5F, 0.5F, 4, 1, 1, 0F); // Box 99
		body[79].setRotationPoint(0F, 0F, 0F);
		body[79].rotateAngleZ = 5.49778714F;

		body[80].addShapeBox(-2F, 6F, 0.5F, 4, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F); // Box 100
		body[80].setRotationPoint(0F, 0F, 0F);
		body[80].rotateAngleZ = 5.49778714F;

		body[81].addShapeBox(-2F, 7.5F, 0.5F, 4, 1, 1, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 101
		body[81].setRotationPoint(0F, 0F, 0F);
		body[81].rotateAngleZ = 5.49778714F;

		body[82].addBox(-2F, 8.5F, 0.5F, 4, 1, 1, 0F); // Box 102
		body[82].setRotationPoint(0F, 0F, 0F);
		body[82].rotateAngleZ = 5.49778714F;

		body[83].addBox(-0.5F, 4F, 2.5F, 1, 1, 1, 0F); // Box 103
		body[83].setRotationPoint(0F, 0F, 0F);

		body[84].addBox(-0.5F, 4F, 2.5F, 1, 1, 1, 0F); // Box 104
		body[84].setRotationPoint(0F, 0F, 0F);
		body[84].rotateAngleZ = 0.78539816F;

		body[85].addBox(-0.5F, 4F, 2.5F, 1, 1, 1, 0F); // Box 105
		body[85].setRotationPoint(0F, 0F, 0F);
		body[85].rotateAngleZ = 1.57079633F;

		body[86].addBox(-0.5F, 4F, 2.5F, 1, 1, 1, 0F); // Box 106
		body[86].setRotationPoint(0F, 0F, 0F);
		body[86].rotateAngleZ = 2.35619449F;

		body[87].addBox(-0.5F, 4F, 2.5F, 1, 1, 1, 0F); // Box 107
		body[87].setRotationPoint(0F, 0F, 0F);
		body[87].rotateAngleZ = 3.14159265F;

		body[88].addBox(-0.5F, 4F, 2.5F, 1, 1, 1, 0F); // Box 108
		body[88].setRotationPoint(0F, 0F, 0F);
		body[88].rotateAngleZ = 3.92699082F;

		body[89].addBox(-0.5F, 4F, 2.5F, 1, 1, 1, 0F); // Box 109
		body[89].setRotationPoint(0F, 0F, 0F);
		body[89].rotateAngleZ = 4.71238898F;

		body[90].addBox(-0.5F, 4F, 2.5F, 1, 1, 1, 0F); // Box 110
		body[90].setRotationPoint(0F, 0F, 0F);
		body[90].rotateAngleZ = 5.49778714F;

		body[91].flip = true;
		body[91].addShape3D(0F, 0F, -3F, new Shape2D(new Coord2D[] { new Coord2D(0, 6, 0, 6), new Coord2D(3, 5, 3, 5), new Coord2D(5, 3, 5, 3), new Coord2D(6, 0, 6, 0), new Coord2D(0, 0, 0, 0) }), 4, 6, 6, 23, 4, ModelRendererTurbo.MR_FRONT, new float[] {6 ,6 ,4 ,3 ,4}); // Shape 93
		body[91].setRotationPoint(0F, 0F, 0F);

		body[92].addBox(-2F, 8.5F, 0.5F, 4, 1, 1, 0F); // Box 94
		body[92].setRotationPoint(0F, 0F, 0F);

		translateAll(0F, 0F, 0F);
		flipAll();
	}
	
	@Override
	public void render(VehicleData data, String us){
		this.render(body);
	}
	
	@Override
	public void render(VehicleData data, String us, Entity vehicle){
		this.def_renderWheelWithRotations(body, data, us, vehicle);
	}
	
}