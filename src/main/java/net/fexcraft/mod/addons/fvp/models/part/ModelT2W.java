package net.fexcraft.mod.addons.fvp.models.part;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.part.PartModel;
import net.fexcraft.mod.lib.tmt.Coord2D;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.tmt.Shape2D;
import net.fexcraft.mod.lib.util.math.Pos;
import net.minecraft.entity.Entity;

public class ModelT2W extends PartModel<VehicleData>{
	
	int textureX = 512;
	int textureY = 64;

	public ModelT2W(){
		creators.add("Ferdinand (FEX___96)");
		wheels = new ModelRendererTurbo[93];
		wheels[0] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 0
		wheels[1] = new ModelRendererTurbo(this, 49, 1, textureX, textureY); // Box 20
		wheels[2] = new ModelRendererTurbo(this, 73, 1, textureX, textureY); // Box 21
		wheels[3] = new ModelRendererTurbo(this, 97, 1, textureX, textureY); // Box 22
		wheels[4] = new ModelRendererTurbo(this, 121, 1, textureX, textureY); // Box 23
		wheels[5] = new ModelRendererTurbo(this, 145, 1, textureX, textureY); // Box 24
		wheels[6] = new ModelRendererTurbo(this, 169, 1, textureX, textureY); // Box 25
		wheels[7] = new ModelRendererTurbo(this, 193, 1, textureX, textureY); // Box 26
		wheels[8] = new ModelRendererTurbo(this, 217, 1, textureX, textureY); // Box 27
		wheels[9] = new ModelRendererTurbo(this, 241, 1, textureX, textureY); // Box 28
		wheels[10] = new ModelRendererTurbo(this, 265, 1, textureX, textureY); // Box 29
		wheels[11] = new ModelRendererTurbo(this, 289, 1, textureX, textureY); // Box 30
		wheels[12] = new ModelRendererTurbo(this, 313, 1, textureX, textureY); // Box 31
		wheels[13] = new ModelRendererTurbo(this, 337, 1, textureX, textureY); // Box 32
		wheels[14] = new ModelRendererTurbo(this, 361, 1, textureX, textureY); // Box 33
		wheels[15] = new ModelRendererTurbo(this, 385, 1, textureX, textureY); // Box 34
		wheels[16] = new ModelRendererTurbo(this, 409, 1, textureX, textureY); // Box 35
		wheels[17] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 36
		wheels[18] = new ModelRendererTurbo(this, 41, 1, textureX, textureY); // Box 37
		wheels[19] = new ModelRendererTurbo(this, 65, 1, textureX, textureY); // Box 38
		wheels[20] = new ModelRendererTurbo(this, 89, 1, textureX, textureY); // Box 39
		wheels[21] = new ModelRendererTurbo(this, 113, 1, textureX, textureY); // Box 40
		wheels[22] = new ModelRendererTurbo(this, 137, 1, textureX, textureY); // Box 41
		wheels[23] = new ModelRendererTurbo(this, 161, 1, textureX, textureY); // Box 42
		wheels[24] = new ModelRendererTurbo(this, 185, 1, textureX, textureY); // Box 43
		wheels[25] = new ModelRendererTurbo(this, 209, 1, textureX, textureY); // Box 44
		wheels[26] = new ModelRendererTurbo(this, 233, 1, textureX, textureY); // Box 45
		wheels[27] = new ModelRendererTurbo(this, 257, 1, textureX, textureY); // Box 46
		wheels[28] = new ModelRendererTurbo(this, 281, 1, textureX, textureY); // Box 47
		wheels[29] = new ModelRendererTurbo(this, 305, 1, textureX, textureY); // Box 48
		wheels[30] = new ModelRendererTurbo(this, 329, 1, textureX, textureY); // Box 49
		wheels[31] = new ModelRendererTurbo(this, 353, 1, textureX, textureY); // Box 50
		wheels[32] = new ModelRendererTurbo(this, 377, 1, textureX, textureY); // Box 51
		wheels[33] = new ModelRendererTurbo(this, 401, 1, textureX, textureY); // Box 52
		wheels[34] = new ModelRendererTurbo(this, 425, 1, textureX, textureY); // Box 53
		wheels[35] = new ModelRendererTurbo(this, 441, 1, textureX, textureY); // Box 54
		wheels[36] = new ModelRendererTurbo(this, 457, 1, textureX, textureY); // Box 55
		wheels[37] = new ModelRendererTurbo(this, 473, 1, textureX, textureY); // Box 56
		wheels[38] = new ModelRendererTurbo(this, 489, 1, textureX, textureY); // Box 57
		wheels[39] = new ModelRendererTurbo(this, 433, 9, textureX, textureY); // Box 58
		wheels[40] = new ModelRendererTurbo(this, 449, 9, textureX, textureY); // Box 59
		wheels[41] = new ModelRendererTurbo(this, 465, 9, textureX, textureY); // Box 60
		wheels[42] = new ModelRendererTurbo(this, 481, 9, textureX, textureY); // Box 61
		wheels[43] = new ModelRendererTurbo(this, 497, 9, textureX, textureY); // Box 62
		wheels[44] = new ModelRendererTurbo(this, 25, 17, textureX, textureY); // Box 63
		wheels[45] = new ModelRendererTurbo(this, 41, 17, textureX, textureY); // Box 64
		wheels[46] = new ModelRendererTurbo(this, 57, 17, textureX, textureY); // Box 65
		wheels[47] = new ModelRendererTurbo(this, 73, 17, textureX, textureY); // Box 66
		wheels[48] = new ModelRendererTurbo(this, 89, 17, textureX, textureY); // Box 67
		wheels[49] = new ModelRendererTurbo(this, 1, 12, textureX, textureY); // Shape 69
		wheels[50] = new ModelRendererTurbo(this, 1, 24, textureX, textureY); // Shape 70
		wheels[51] = new ModelRendererTurbo(this, 1, 36, textureX, textureY); // Shape 71
		wheels[52] = new ModelRendererTurbo(this, 105, 17, textureX, textureY); // Box 72
		wheels[53] = new ModelRendererTurbo(this, 121, 17, textureX, textureY); // Box 73
		wheels[54] = new ModelRendererTurbo(this, 137, 17, textureX, textureY); // Box 74
		wheels[55] = new ModelRendererTurbo(this, 153, 17, textureX, textureY); // Box 75
		wheels[56] = new ModelRendererTurbo(this, 169, 17, textureX, textureY); // Box 76
		wheels[57] = new ModelRendererTurbo(this, 185, 17, textureX, textureY); // Box 77
		wheels[58] = new ModelRendererTurbo(this, 201, 17, textureX, textureY); // Box 78
		wheels[59] = new ModelRendererTurbo(this, 217, 17, textureX, textureY); // Box 79
		wheels[60] = new ModelRendererTurbo(this, 233, 17, textureX, textureY); // Box 80
		wheels[61] = new ModelRendererTurbo(this, 249, 17, textureX, textureY); // Box 81
		wheels[62] = new ModelRendererTurbo(this, 265, 17, textureX, textureY); // Box 82
		wheels[63] = new ModelRendererTurbo(this, 281, 17, textureX, textureY); // Box 83
		wheels[64] = new ModelRendererTurbo(this, 297, 17, textureX, textureY); // Box 84
		wheels[65] = new ModelRendererTurbo(this, 313, 17, textureX, textureY); // Box 85
		wheels[66] = new ModelRendererTurbo(this, 329, 17, textureX, textureY); // Box 86
		wheels[67] = new ModelRendererTurbo(this, 345, 17, textureX, textureY); // Box 87
		wheels[68] = new ModelRendererTurbo(this, 361, 17, textureX, textureY); // Box 88
		wheels[69] = new ModelRendererTurbo(this, 377, 17, textureX, textureY); // Box 89
		wheels[70] = new ModelRendererTurbo(this, 393, 17, textureX, textureY); // Box 90
		wheels[71] = new ModelRendererTurbo(this, 409, 17, textureX, textureY); // Box 91
		wheels[72] = new ModelRendererTurbo(this, 425, 17, textureX, textureY); // Box 92
		wheels[73] = new ModelRendererTurbo(this, 441, 17, textureX, textureY); // Box 93
		wheels[74] = new ModelRendererTurbo(this, 457, 17, textureX, textureY); // Box 94
		wheels[75] = new ModelRendererTurbo(this, 473, 17, textureX, textureY); // Box 95
		wheels[76] = new ModelRendererTurbo(this, 489, 17, textureX, textureY); // Box 96
		wheels[77] = new ModelRendererTurbo(this, 17, 25, textureX, textureY); // Box 97
		wheels[78] = new ModelRendererTurbo(this, 33, 25, textureX, textureY); // Box 98
		wheels[79] = new ModelRendererTurbo(this, 49, 25, textureX, textureY); // Box 99
		wheels[80] = new ModelRendererTurbo(this, 65, 25, textureX, textureY); // Box 100
		wheels[81] = new ModelRendererTurbo(this, 81, 25, textureX, textureY); // Box 101
		wheels[82] = new ModelRendererTurbo(this, 97, 25, textureX, textureY); // Box 102
		wheels[83] = new ModelRendererTurbo(this, 505, 1, textureX, textureY); // Box 103
		wheels[84] = new ModelRendererTurbo(this, 41, 9, textureX, textureY); // Box 104
		wheels[85] = new ModelRendererTurbo(this, 505, 17, textureX, textureY); // Box 105
		wheels[86] = new ModelRendererTurbo(this, 113, 25, textureX, textureY); // Box 106
		wheels[87] = new ModelRendererTurbo(this, 121, 25, textureX, textureY); // Box 107
		wheels[88] = new ModelRendererTurbo(this, 129, 25, textureX, textureY); // Box 108
		wheels[89] = new ModelRendererTurbo(this, 137, 25, textureX, textureY); // Box 109
		wheels[90] = new ModelRendererTurbo(this, 145, 25, textureX, textureY); // Box 110
		wheels[91] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Shape 93
		wheels[92] = new ModelRendererTurbo(this, 153, 25, textureX, textureY); // Box 94

		wheels[0].addBox(-1F, -1F, -2F, 2, 2, 6, 0F); // Box 0
		wheels[0].setRotationPoint(0F, 0F, 0F);

		wheels[1].addShapeBox(0F, 9F, 0F, 5, 3, 5, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 20
		wheels[1].setRotationPoint(0F, 0F, 0F);

		wheels[2].addShapeBox(0F, 9F, 0F, 5, 3, 5, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 21
		wheels[2].setRotationPoint(0F, 0F, 0F);
		wheels[2].rotateAngleZ = 0.39269908F;

		wheels[3].addShapeBox(0F, 9F, 0F, 5, 3, 5, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 22
		wheels[3].setRotationPoint(0F, 0F, 0F);
		wheels[3].rotateAngleZ = 0.78539816F;

		wheels[4].addShapeBox(0F, 9F, 0F, 5, 3, 5, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 23
		wheels[4].setRotationPoint(0F, 0F, 0F);
		wheels[4].rotateAngleZ = 1.17809725F;

		wheels[5].addShapeBox(0F, 9F, 0F, 5, 3, 5, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 24
		wheels[5].setRotationPoint(0F, 0F, 0F);
		wheels[5].rotateAngleZ = 1.57079633F;

		wheels[6].addShapeBox(0F, 9F, 0F, 5, 3, 5, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 25
		wheels[6].setRotationPoint(0F, 0F, 0F);
		wheels[6].rotateAngleZ = 1.96349541F;

		wheels[7].addShapeBox(0F, 9F, 0F, 5, 3, 5, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 26
		wheels[7].setRotationPoint(0F, 0F, 0F);
		wheels[7].rotateAngleZ = 2.35619449F;

		wheels[8].addShapeBox(0F, 9F, 0F, 5, 3, 5, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 27
		wheels[8].setRotationPoint(0F, 0F, 0F);
		wheels[8].rotateAngleZ = 2.74889357F;

		wheels[9].addShapeBox(0F, 9F, 0F, 5, 3, 5, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 28
		wheels[9].setRotationPoint(0F, 0F, 0F);
		wheels[9].rotateAngleZ = 3.14159265F;

		wheels[10].addShapeBox(0F, 9F, 0F, 5, 3, 5, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 29
		wheels[10].setRotationPoint(0F, 0F, 0F);
		wheels[10].rotateAngleZ = 3.53429174F;

		wheels[11].addShapeBox(0F, 9F, 0F, 5, 3, 5, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 30
		wheels[11].setRotationPoint(0F, 0F, 0F);
		wheels[11].rotateAngleZ = 3.92699082F;

		wheels[12].addShapeBox(0F, 9F, 0F, 5, 3, 5, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 31
		wheels[12].setRotationPoint(0F, 0F, 0F);
		wheels[12].rotateAngleZ = 4.3196899F;

		wheels[13].addShapeBox(0F, 9F, 0F, 5, 3, 5, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 32
		wheels[13].setRotationPoint(0F, 0F, 0F);
		wheels[13].rotateAngleZ = 4.71238898F;

		wheels[14].addShapeBox(0F, 9F, 0F, 5, 3, 5, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 33
		wheels[14].setRotationPoint(0F, 0F, 0F);
		wheels[14].rotateAngleZ = 5.10508806F;

		wheels[15].addShapeBox(0F, 9F, 0F, 5, 3, 5, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 34
		wheels[15].setRotationPoint(0F, 0F, 0F);
		wheels[15].rotateAngleZ = 5.49778714F;

		wheels[16].addShapeBox(0F, 9F, 0F, 5, 3, 5, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 35
		wheels[16].setRotationPoint(0F, 0F, 0F);
		wheels[16].rotateAngleZ = 5.89048623F;

		wheels[17].addShapeBox(0F, 9F, 5F, 5, 3, 1, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.35F, 0.25F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.6F, -1.4F, -0.5F, 0F, -0.5F, -0.5F); // Box 36
		wheels[17].setRotationPoint(0F, 0F, 0F);

		wheels[18].addShapeBox(0F, 9F, 5F, 5, 3, 1, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.35F, 0.25F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.6F, -1.4F, -0.5F, 0F, -0.5F, -0.5F); // Box 37
		wheels[18].setRotationPoint(0F, 0F, 0F);
		wheels[18].rotateAngleZ = 0.39269908F;

		wheels[19].addShapeBox(0F, 9F, 5F, 5, 3, 1, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.35F, 0.25F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.6F, -1.4F, -0.5F, 0F, -0.5F, -0.5F); // Box 38
		wheels[19].setRotationPoint(0F, 0F, 0F);
		wheels[19].rotateAngleZ = 0.78539816F;

		wheels[20].addShapeBox(0F, 9F, 5F, 5, 3, 1, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.35F, 0.25F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.6F, -1.4F, -0.5F, 0F, -0.5F, -0.5F); // Box 39
		wheels[20].setRotationPoint(0F, 0F, 0F);
		wheels[20].rotateAngleZ = 1.17809725F;

		wheels[21].addShapeBox(0F, 9F, 5F, 5, 3, 1, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.35F, 0.25F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.6F, -1.4F, -0.5F, 0F, -0.5F, -0.5F); // Box 40
		wheels[21].setRotationPoint(0F, 0F, 0F);
		wheels[21].rotateAngleZ = 1.57079633F;

		wheels[22].addShapeBox(0F, 9F, 5F, 5, 3, 1, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.35F, 0.25F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.6F, -1.4F, -0.5F, 0F, -0.5F, -0.5F); // Box 41
		wheels[22].setRotationPoint(0F, 0F, 0F);
		wheels[22].rotateAngleZ = 1.96349541F;

		wheels[23].addShapeBox(0F, 9F, 5F, 5, 3, 1, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.35F, 0.25F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.6F, -1.4F, -0.5F, 0F, -0.5F, -0.5F); // Box 42
		wheels[23].setRotationPoint(0F, 0F, 0F);
		wheels[23].rotateAngleZ = 2.35619449F;

		wheels[24].addShapeBox(0F, 9F, 5F, 5, 3, 1, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.35F, 0.25F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.6F, -1.4F, -0.5F, 0F, -0.5F, -0.5F); // Box 43
		wheels[24].setRotationPoint(0F, 0F, 0F);
		wheels[24].rotateAngleZ = 2.74889357F;

		wheels[25].addShapeBox(0F, 9F, 5F, 5, 3, 1, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.35F, 0.25F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.6F, -1.4F, -0.5F, 0F, -0.5F, -0.5F); // Box 44
		wheels[25].setRotationPoint(0F, 0F, 0F);
		wheels[25].rotateAngleZ = 3.14159265F;

		wheels[26].addShapeBox(0F, 9F, 5F, 5, 3, 1, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.35F, 0.25F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.6F, -1.4F, -0.5F, 0F, -0.5F, -0.5F); // Box 45
		wheels[26].setRotationPoint(0F, 0F, 0F);
		wheels[26].rotateAngleZ = 3.53429174F;

		wheels[27].addShapeBox(0F, 9F, 5F, 5, 3, 1, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.35F, 0.25F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.6F, -1.4F, -0.5F, 0F, -0.5F, -0.5F); // Box 46
		wheels[27].setRotationPoint(0F, 0F, 0F);
		wheels[27].rotateAngleZ = 3.92699082F;

		wheels[28].addShapeBox(0F, 9F, 5F, 5, 3, 1, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.35F, 0.25F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.6F, -1.4F, -0.5F, 0F, -0.5F, -0.5F); // Box 47
		wheels[28].setRotationPoint(0F, 0F, 0F);
		wheels[28].rotateAngleZ = 4.3196899F;

		wheels[29].addShapeBox(0F, 9F, 5F, 5, 3, 1, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.35F, 0.25F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.6F, -1.4F, -0.5F, 0F, -0.5F, -0.5F); // Box 48
		wheels[29].setRotationPoint(0F, 0F, 0F);
		wheels[29].rotateAngleZ = 4.71238898F;

		wheels[30].addShapeBox(0F, 9F, 5F, 5, 3, 1, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.35F, 0.25F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.6F, -1.4F, -0.5F, 0F, -0.5F, -0.5F); // Box 49
		wheels[30].setRotationPoint(0F, 0F, 0F);
		wheels[30].rotateAngleZ = 5.10508806F;

		wheels[31].addShapeBox(0F, 9F, 5F, 5, 3, 1, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.35F, 0.25F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.6F, -1.4F, -0.5F, 0F, -0.5F, -0.5F); // Box 50
		wheels[31].setRotationPoint(0F, 0F, 0F);
		wheels[31].rotateAngleZ = 5.49778714F;

		wheels[32].addShapeBox(0F, 9F, 5F, 5, 3, 1, 0F, 0F, 0F, 0F, -1.55F, 0.7F, 0F, -1.35F, 0.25F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, -0.4F, -0.9F, 0F, -0.6F, -1.4F, -0.5F, 0F, -0.5F, -0.5F); // Box 51
		wheels[32].setRotationPoint(0F, 0F, 0F);
		wheels[32].rotateAngleZ = 5.89048623F;

		wheels[33].addShapeBox(0F, 9F, -1F, 5, 3, 1, 0F, 0F, -0.5F, -0.5F, -1.35F, 0.25F, -0.5F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -0.6F, -1.4F, -0.5F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 52
		wheels[33].setRotationPoint(0F, 0F, 0F);

		wheels[34].addShapeBox(0F, 9F, -1F, 5, 3, 1, 0F, 0F, -0.5F, -0.5F, -1.35F, 0.25F, -0.5F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -0.6F, -1.4F, -0.5F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 53
		wheels[34].setRotationPoint(0F, 0F, 0F);
		wheels[34].rotateAngleZ = 0.39269908F;

		wheels[35].addShapeBox(0F, 9F, -1F, 5, 3, 1, 0F, 0F, -0.5F, -0.5F, -1.35F, 0.25F, -0.5F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -0.6F, -1.4F, -0.5F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 54
		wheels[35].setRotationPoint(0F, 0F, 0F);
		wheels[35].rotateAngleZ = 0.78539816F;

		wheels[36].addShapeBox(0F, 9F, -1F, 5, 3, 1, 0F, 0F, -0.5F, -0.5F, -1.35F, 0.25F, -0.5F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -0.6F, -1.4F, -0.5F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 55
		wheels[36].setRotationPoint(0F, 0F, 0F);
		wheels[36].rotateAngleZ = 1.57079633F;

		wheels[37].addShapeBox(0F, 9F, -1F, 5, 3, 1, 0F, 0F, -0.5F, -0.5F, -1.35F, 0.25F, -0.5F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -0.6F, -1.4F, -0.5F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 56
		wheels[37].setRotationPoint(0F, 0F, 0F);
		wheels[37].rotateAngleZ = 1.17809725F;

		wheels[38].addShapeBox(0F, 9F, -1F, 5, 3, 1, 0F, 0F, -0.5F, -0.5F, -1.35F, 0.25F, -0.5F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -0.6F, -1.4F, -0.5F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 57
		wheels[38].setRotationPoint(0F, 0F, 0F);
		wheels[38].rotateAngleZ = 1.96349541F;

		wheels[39].addShapeBox(0F, 9F, -1F, 5, 3, 1, 0F, 0F, -0.5F, -0.5F, -1.35F, 0.25F, -0.5F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -0.6F, -1.4F, -0.5F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 58
		wheels[39].setRotationPoint(0F, 0F, 0F);
		wheels[39].rotateAngleZ = 2.35619449F;

		wheels[40].addShapeBox(0F, 9F, -1F, 5, 3, 1, 0F, 0F, -0.5F, -0.5F, -1.35F, 0.25F, -0.5F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -0.6F, -1.4F, -0.5F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 59
		wheels[40].setRotationPoint(0F, 0F, 0F);
		wheels[40].rotateAngleZ = 2.74889357F;

		wheels[41].addShapeBox(0F, 9F, -1F, 5, 3, 1, 0F, 0F, -0.5F, -0.5F, -1.35F, 0.25F, -0.5F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -0.6F, -1.4F, -0.5F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 60
		wheels[41].setRotationPoint(0F, 0F, 0F);
		wheels[41].rotateAngleZ = 3.14159265F;

		wheels[42].addShapeBox(0F, 9F, -1F, 5, 3, 1, 0F, 0F, -0.5F, -0.5F, -1.35F, 0.25F, -0.5F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -0.6F, -1.4F, -0.5F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 61
		wheels[42].setRotationPoint(0F, 0F, 0F);
		wheels[42].rotateAngleZ = 3.53429174F;

		wheels[43].addShapeBox(0F, 9F, -1F, 5, 3, 1, 0F, 0F, -0.5F, -0.5F, -1.35F, 0.25F, -0.5F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -0.6F, -1.4F, -0.5F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 62
		wheels[43].setRotationPoint(0F, 0F, 0F);
		wheels[43].rotateAngleZ = 3.92699082F;

		wheels[44].addShapeBox(0F, 9F, -1F, 5, 3, 1, 0F, 0F, -0.5F, -0.5F, -1.35F, 0.25F, -0.5F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -0.6F, -1.4F, -0.5F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 63
		wheels[44].setRotationPoint(0F, 0F, 0F);
		wheels[44].rotateAngleZ = 4.3196899F;

		wheels[45].addShapeBox(0F, 9F, -1F, 5, 3, 1, 0F, 0F, -0.5F, -0.5F, -1.35F, 0.25F, -0.5F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -0.6F, -1.4F, -0.5F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 64
		wheels[45].setRotationPoint(0F, 0F, 0F);
		wheels[45].rotateAngleZ = 4.71238898F;

		wheels[46].addShapeBox(0F, 9F, -1F, 5, 3, 1, 0F, 0F, -0.5F, -0.5F, -1.35F, 0.25F, -0.5F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -0.6F, -1.4F, -0.5F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 65
		wheels[46].setRotationPoint(0F, 0F, 0F);
		wheels[46].rotateAngleZ = 5.10508806F;

		wheels[47].addShapeBox(0F, 9F, -1F, 5, 3, 1, 0F, 0F, -0.5F, -0.5F, -1.35F, 0.25F, -0.5F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -0.6F, -1.4F, -0.5F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 66
		wheels[47].setRotationPoint(0F, 0F, 0F);
		wheels[47].rotateAngleZ = 5.49778714F;

		wheels[48].addShapeBox(0F, 9F, -1F, 5, 3, 1, 0F, 0F, -0.5F, -0.5F, -1.35F, 0.25F, -0.5F, -1.55F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, -0.6F, -1.4F, -0.5F, -0.4F, -0.9F, 0F, 0F, 0F, 0F); // Box 67
		wheels[48].setRotationPoint(0F, 0F, 0F);
		wheels[48].rotateAngleZ = 5.89048623F;

		wheels[49].flip = true;
		wheels[49].addShape3D(0F, 0F, -3F, new Shape2D(new Coord2D[] { new Coord2D(0, 6, 0, 6), new Coord2D(3, 5, 3, 5), new Coord2D(5, 3, 5, 3), new Coord2D(6, 0, 6, 0), new Coord2D(0, 0, 0, 0) }), 4, 6, 6, 23, 4, ModelRendererTurbo.MR_FRONT, new float[] {6 ,6 ,4 ,3 ,4}); // Shape 69
		wheels[49].setRotationPoint(0F, 0F, 0F);
		wheels[49].rotateAngleZ = 1.57079633F;

		wheels[50].flip = true;
		wheels[50].addShape3D(0F, 0F, -3F, new Shape2D(new Coord2D[] { new Coord2D(0, 6, 0, 6), new Coord2D(3, 5, 3, 5), new Coord2D(5, 3, 5, 3), new Coord2D(6, 0, 6, 0), new Coord2D(0, 0, 0, 0) }), 4, 6, 6, 23, 4, ModelRendererTurbo.MR_FRONT, new float[] {6 ,6 ,4 ,3 ,4}); // Shape 70
		wheels[50].setRotationPoint(0F, 0F, 0F);
		wheels[50].rotateAngleZ = 3.14159265F;

		wheels[51].flip = true;
		wheels[51].addShape3D(0F, 0F, -3F, new Shape2D(new Coord2D[] { new Coord2D(0, 6, 0, 6), new Coord2D(3, 5, 3, 5), new Coord2D(5, 3, 5, 3), new Coord2D(6, 0, 6, 0), new Coord2D(0, 0, 0, 0) }), 4, 6, 6, 23, 4, ModelRendererTurbo.MR_FRONT, new float[] {6 ,6 ,4 ,3 ,4}); // Shape 71
		wheels[51].setRotationPoint(0F, 0F, 0F);
		wheels[51].rotateAngleZ = 4.71238898F;

		wheels[52].addBox(-2F, 5F, 0.5F, 4, 1, 1, 0F); // Box 72
		wheels[52].setRotationPoint(0F, 0F, 0F);

		wheels[53].addBox(-2F, 8.5F, 0.5F, 4, 1, 1, 0F); // Box 73
		wheels[53].setRotationPoint(0F, 0F, 0F);
		wheels[53].rotateAngleZ = 1.57079633F;

		wheels[54].addShapeBox(-2F, 7.5F, 0.5F, 4, 1, 1, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 74
		wheels[54].setRotationPoint(0F, 0F, 0F);

		wheels[55].addShapeBox(-2F, 6F, 0.5F, 4, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F); // Box 75
		wheels[55].setRotationPoint(0F, 0F, 0F);

		wheels[56].addBox(-2F, 5F, 0.5F, 4, 1, 1, 0F); // Box 76
		wheels[56].setRotationPoint(0F, 0F, 0F);
		wheels[56].rotateAngleZ = 0.78539816F;

		wheels[57].addShapeBox(-2F, 6F, 0.5F, 4, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F); // Box 77
		wheels[57].setRotationPoint(0F, 0F, 0F);
		wheels[57].rotateAngleZ = 0.78539816F;

		wheels[58].addShapeBox(-2F, 7.5F, 0.5F, 4, 1, 1, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 78
		wheels[58].setRotationPoint(0F, 0F, 0F);
		wheels[58].rotateAngleZ = 0.78539816F;

		wheels[59].addBox(-2F, 8.5F, 0.5F, 4, 1, 1, 0F); // Box 79
		wheels[59].setRotationPoint(0F, 0F, 0F);
		wheels[59].rotateAngleZ = 0.78539816F;

		wheels[60].addBox(-2F, 5F, 0.5F, 4, 1, 1, 0F); // Box 80
		wheels[60].setRotationPoint(0F, 0F, 0F);
		wheels[60].rotateAngleZ = 1.57079633F;

		wheels[61].addShapeBox(-2F, 6F, 0.5F, 4, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F); // Box 81
		wheels[61].setRotationPoint(0F, 0F, 0F);
		wheels[61].rotateAngleZ = 1.57079633F;

		wheels[62].addShapeBox(-2F, 7.5F, 0.5F, 4, 1, 1, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 82
		wheels[62].setRotationPoint(0F, 0F, 0F);
		wheels[62].rotateAngleZ = 1.57079633F;

		wheels[63].addBox(-2F, 5F, 0.5F, 4, 1, 1, 0F); // Box 83
		wheels[63].setRotationPoint(0F, 0F, 0F);
		wheels[63].rotateAngleZ = 2.35619449F;

		wheels[64].addShapeBox(-2F, 6F, 0.5F, 4, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F); // Box 84
		wheels[64].setRotationPoint(0F, 0F, 0F);
		wheels[64].rotateAngleZ = 2.35619449F;

		wheels[65].addShapeBox(-2F, 7.5F, 0.5F, 4, 1, 1, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 85
		wheels[65].setRotationPoint(0F, 0F, 0F);
		wheels[65].rotateAngleZ = 2.35619449F;

		wheels[66].addBox(-2F, 8.5F, 0.5F, 4, 1, 1, 0F); // Box 86
		wheels[66].setRotationPoint(0F, 0F, 0F);
		wheels[66].rotateAngleZ = 2.35619449F;

		wheels[67].addBox(-2F, 5F, 0.5F, 4, 1, 1, 0F); // Box 87
		wheels[67].setRotationPoint(0F, 0F, 0F);
		wheels[67].rotateAngleZ = 3.14159265F;

		wheels[68].addShapeBox(-2F, 6F, 0.5F, 4, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F); // Box 88
		wheels[68].setRotationPoint(0F, 0F, 0F);
		wheels[68].rotateAngleZ = 3.14159265F;

		wheels[69].addShapeBox(-2F, 7.5F, 0.5F, 4, 1, 1, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 89
		wheels[69].setRotationPoint(0F, 0F, 0F);
		wheels[69].rotateAngleZ = 3.14159265F;

		wheels[70].addBox(-2F, 8.5F, 0.5F, 4, 1, 1, 0F); // Box 90
		wheels[70].setRotationPoint(0F, 0F, 0F);
		wheels[70].rotateAngleZ = 3.14159265F;

		wheels[71].addBox(-2F, 5F, 0.5F, 4, 1, 1, 0F); // Box 91
		wheels[71].setRotationPoint(0F, 0F, 0F);
		wheels[71].rotateAngleZ = 3.92699082F;

		wheels[72].addShapeBox(-2F, 6F, 0.5F, 4, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F); // Box 92
		wheels[72].setRotationPoint(0F, 0F, 0F);
		wheels[72].rotateAngleZ = 3.92699082F;

		wheels[73].addShapeBox(-2F, 7.5F, 0.5F, 4, 1, 1, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 93
		wheels[73].setRotationPoint(0F, 0F, 0F);
		wheels[73].rotateAngleZ = 3.92699082F;

		wheels[74].addBox(-2F, 8.5F, 0.5F, 4, 1, 1, 0F); // Box 94
		wheels[74].setRotationPoint(0F, 0F, 0F);
		wheels[74].rotateAngleZ = 3.92699082F;

		wheels[75].addBox(-2F, 5F, 0.5F, 4, 1, 1, 0F); // Box 95
		wheels[75].setRotationPoint(0F, 0F, 0F);
		wheels[75].rotateAngleZ = 4.71238898F;

		wheels[76].addShapeBox(-2F, 6F, 0.5F, 4, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F); // Box 96
		wheels[76].setRotationPoint(0F, 0F, 0F);
		wheels[76].rotateAngleZ = 4.71238898F;

		wheels[77].addShapeBox(-2F, 7.5F, 0.5F, 4, 1, 1, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 97
		wheels[77].setRotationPoint(0F, 0F, 0F);
		wheels[77].rotateAngleZ = 4.71238898F;

		wheels[78].addBox(-2F, 8.5F, 0.5F, 4, 1, 1, 0F); // Box 98
		wheels[78].setRotationPoint(0F, 0F, 0F);
		wheels[78].rotateAngleZ = 4.71238898F;

		wheels[79].addBox(-2F, 5F, 0.5F, 4, 1, 1, 0F); // Box 99
		wheels[79].setRotationPoint(0F, 0F, 0F);
		wheels[79].rotateAngleZ = 5.49778714F;

		wheels[80].addShapeBox(-2F, 6F, 0.5F, 4, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F); // Box 100
		wheels[80].setRotationPoint(0F, 0F, 0F);
		wheels[80].rotateAngleZ = 5.49778714F;

		wheels[81].addShapeBox(-2F, 7.5F, 0.5F, 4, 1, 1, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F, 0.25F, 0.5F, 0F, 0.25F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 101
		wheels[81].setRotationPoint(0F, 0F, 0F);
		wheels[81].rotateAngleZ = 5.49778714F;

		wheels[82].addBox(-2F, 8.5F, 0.5F, 4, 1, 1, 0F); // Box 102
		wheels[82].setRotationPoint(0F, 0F, 0F);
		wheels[82].rotateAngleZ = 5.49778714F;

		wheels[83].addBox(-0.5F, 4F, 2.5F, 1, 1, 1, 0F); // Box 103
		wheels[83].setRotationPoint(0F, 0F, 0F);

		wheels[84].addBox(-0.5F, 4F, 2.5F, 1, 1, 1, 0F); // Box 104
		wheels[84].setRotationPoint(0F, 0F, 0F);
		wheels[84].rotateAngleZ = 0.78539816F;

		wheels[85].addBox(-0.5F, 4F, 2.5F, 1, 1, 1, 0F); // Box 105
		wheels[85].setRotationPoint(0F, 0F, 0F);
		wheels[85].rotateAngleZ = 1.57079633F;

		wheels[86].addBox(-0.5F, 4F, 2.5F, 1, 1, 1, 0F); // Box 106
		wheels[86].setRotationPoint(0F, 0F, 0F);
		wheels[86].rotateAngleZ = 2.35619449F;

		wheels[87].addBox(-0.5F, 4F, 2.5F, 1, 1, 1, 0F); // Box 107
		wheels[87].setRotationPoint(0F, 0F, 0F);
		wheels[87].rotateAngleZ = 3.14159265F;

		wheels[88].addBox(-0.5F, 4F, 2.5F, 1, 1, 1, 0F); // Box 108
		wheels[88].setRotationPoint(0F, 0F, 0F);
		wheels[88].rotateAngleZ = 3.92699082F;

		wheels[89].addBox(-0.5F, 4F, 2.5F, 1, 1, 1, 0F); // Box 109
		wheels[89].setRotationPoint(0F, 0F, 0F);
		wheels[89].rotateAngleZ = 4.71238898F;

		wheels[90].addBox(-0.5F, 4F, 2.5F, 1, 1, 1, 0F); // Box 110
		wheels[90].setRotationPoint(0F, 0F, 0F);
		wheels[90].rotateAngleZ = 5.49778714F;

		wheels[91].flip = true;
		wheels[91].addShape3D(0F, 0F, -3F, new Shape2D(new Coord2D[] { new Coord2D(0, 6, 0, 6), new Coord2D(3, 5, 3, 5), new Coord2D(5, 3, 5, 3), new Coord2D(6, 0, 6, 0), new Coord2D(0, 0, 0, 0) }), 4, 6, 6, 23, 4, ModelRendererTurbo.MR_FRONT, new float[] {6 ,6 ,4 ,3 ,4}); // Shape 93
		wheels[91].setRotationPoint(0F, 0F, 0F);

		wheels[92].addBox(-2F, 8.5F, 0.5F, 4, 1, 1, 0F); // Box 94
		wheels[92].setRotationPoint(0F, 0F, 0F);

		translateAll(0F, 0F, 0F);
		flipAll();
	}
	
	@Override
	public void render(VehicleData data, String us){
		//this.render(wheels);
		//this.def_renderAdjustableWheels4(data, us);
		Pos pos = data.getVehicle().getWheelPositions().get(us);
		pos = pos == null ? new Pos(0, 0, 0) : pos;
		pos.translate();
		switch(us){
			case "left_front_wheel":
			case "left_back_wheel":
			default:
				render(wheels);
				break;
			case "right_front_wheel":
			case "right_back_wheel":
				GL11.glRotated( 180, 0, 1, 0);
				render(wheels);
				GL11.glRotated(-180, 0, 1, 0);
				break;
		}
		pos.translateR();
	}
	
	@Override
	public void render(VehicleData data, String us, Entity vehicle){
		//this.def_renderWheelWithRotations(wheels, data, us, vehicle);
		//this.def_renderAdjustableWheels4(data, us, vehicle, true);
		Pos pos = data.getVehicle().getWheelPositions().get(us);
		pos = pos == null ? new Pos(0, 0, 0) : pos;
		pos.translate();
		boolean str, mir;
		switch(us){
			case "left_front_wheel":{
				str = true;
				mir = false;
				break;
			}
			case "right_front_wheel":{
				str = true;
				mir = true;
				break;
			}
			case "left_back_wheel":{
				str = false;
				mir = false;
				break;
			}
			case "right_back_wheel":{
				str = false;
				mir = true;
				break;
			}
			default:{
				str = false;
				mir = false;
				break;
			}
		}
		if(mir){
			GL11.glRotated( 180, 0, 1, 0);
		}
		this.def_renderWheelWithRotations(wheels, vehicle, str);
		if(mir){
			GL11.glRotated(-180, 0, 1, 0);
		}
		pos.translateR();
	}
	
}