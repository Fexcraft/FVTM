package net.fexcraft.mod.addons.fvp.models.vehicle;

import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.vehicle.VehicleModel;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.entity.Entity;

public class ModelAB1B extends VehicleModel<VehicleData> {
	
	int textureX = 1024;
	int textureY = 1024;

	public ModelAB1B(){
		creators.add("Ferdinand (FEX___96)");
		body = new ModelRendererTurbo[105];
		body[0] = new ModelRendererTurbo(this, 217, 1, textureX, textureY); // Box 6
		body[1] = new ModelRendererTurbo(this, 593, 1, textureX, textureY); // Box 7
		body[2] = new ModelRendererTurbo(this, 705, 1, textureX, textureY); // Box 8
		body[3] = new ModelRendererTurbo(this, 657, 1, textureX, textureY); // Box 10
		body[4] = new ModelRendererTurbo(this, 769, 1, textureX, textureY); // Box 11
		body[5] = new ModelRendererTurbo(this, 833, 1, textureX, textureY); // Box 12
		body[6] = new ModelRendererTurbo(this, 913, 1, textureX, textureY); // Box 13
		body[7] = new ModelRendererTurbo(this, 769, 17, textureX, textureY); // Box 14
		body[8] = new ModelRendererTurbo(this, 1, 33, textureX, textureY); // Box 15
		body[9] = new ModelRendererTurbo(this, 769, 33, textureX, textureY); // Box 16
		body[10] = new ModelRendererTurbo(this, 769, 41, textureX, textureY); // Box 17
		body[11] = new ModelRendererTurbo(this, 601, 1, textureX, textureY); // Box 18
		body[12] = new ModelRendererTurbo(this, 713, 1, textureX, textureY); // Box 19
		body[13] = new ModelRendererTurbo(this, 993, 1, textureX, textureY); // Box 20
		body[14] = new ModelRendererTurbo(this, 601, 9, textureX, textureY); // Box 21
		body[15] = new ModelRendererTurbo(this, 1, 49, textureX, textureY); // Box 22
		body[16] = new ModelRendererTurbo(this, 41, 49, textureX, textureY); // Box 23
		body[17] = new ModelRendererTurbo(this, 657, 17, textureX, textureY); // Box 24
		body[18] = new ModelRendererTurbo(this, 657, 25, textureX, textureY); // Box 25
		body[19] = new ModelRendererTurbo(this, 713, 9, textureX, textureY); // Box 26
		body[20] = new ModelRendererTurbo(this, 617, 17, textureX, textureY); // Box 27
		body[21] = new ModelRendererTurbo(this, 113, 49, textureX, textureY); // Box 28
		body[22] = new ModelRendererTurbo(this, 785, 49, textureX, textureY); // Box 29
		body[23] = new ModelRendererTurbo(this, 169, 57, textureX, textureY); // Box 30
		body[24] = new ModelRendererTurbo(this, 241, 57, textureX, textureY); // Box 31
		body[25] = new ModelRendererTurbo(this, 857, 49, textureX, textureY); // Box 32
		body[26] = new ModelRendererTurbo(this, 441, 57, textureX, textureY); // Box 33
		body[27] = new ModelRendererTurbo(this, 377, 57, textureX, textureY); // Box 34
		body[28] = new ModelRendererTurbo(this, 729, 81, textureX, textureY); // Box 60
		body[29] = new ModelRendererTurbo(this, 137, 113, textureX, textureY); // Box 67
		body[30] = new ModelRendererTurbo(this, 633, 9, textureX, textureY); // Box 84
		body[31] = new ModelRendererTurbo(this, 633, 33, textureX, textureY); // Box 85
		body[32] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 86
		body[33] = new ModelRendererTurbo(this, 57, 1, textureX, textureY); // Box 87
		body[34] = new ModelRendererTurbo(this, 129, 49, textureX, textureY); // Box 88
		body[35] = new ModelRendererTurbo(this, 705, 105, textureX, textureY); // Box 92
		body[36] = new ModelRendererTurbo(this, 65, 1, textureX, textureY); // Box 98
		body[37] = new ModelRendererTurbo(this, 121, 1, textureX, textureY); // Box 99
		body[38] = new ModelRendererTurbo(this, 169, 49, textureX, textureY); // Box 100
		body[39] = new ModelRendererTurbo(this, 201, 49, textureX, textureY); // Box 101
		body[40] = new ModelRendererTurbo(this, 129, 1, textureX, textureY); // Box 102
		body[41] = new ModelRendererTurbo(this, 185, 1, textureX, textureY); // Box 103
		body[42] = new ModelRendererTurbo(this, 473, 57, textureX, textureY); // Box 104
		body[43] = new ModelRendererTurbo(this, 193, 1, textureX, textureY); // Box 105
		body[44] = new ModelRendererTurbo(this, 249, 1, textureX, textureY); // Box 106
		body[45] = new ModelRendererTurbo(this, 569, 121, textureX, textureY); // Box 109
		body[46] = new ModelRendererTurbo(this, 753, 129, textureX, textureY); // Box 110
		body[47] = new ModelRendererTurbo(this, 1, 137, textureX, textureY); // Box 111
		body[48] = new ModelRendererTurbo(this, 193, 137, textureX, textureY); // Box 112
		body[49] = new ModelRendererTurbo(this, 801, 129, textureX, textureY); // Box 115
		body[50] = new ModelRendererTurbo(this, 297, 137, textureX, textureY); // Box 116
		body[51] = new ModelRendererTurbo(this, 473, 161, textureX, textureY); // Box 129
		body[52] = new ModelRendererTurbo(this, 113, 169, textureX, textureY); // Box 130
		body[53] = new ModelRendererTurbo(this, 521, 177, textureX, textureY); // Box 131
		body[54] = new ModelRendererTurbo(this, 897, 177, textureX, textureY); // Box 132
		body[55] = new ModelRendererTurbo(this, 569, 185, textureX, textureY); // Box 133
		body[56] = new ModelRendererTurbo(this, 721, 185, textureX, textureY); // Box 134
		body[57] = new ModelRendererTurbo(this, 1, 193, textureX, textureY); // Box 135
		body[58] = new ModelRendererTurbo(this, 257, 193, textureX, textureY); // Box 136
		body[59] = new ModelRendererTurbo(this, 353, 193, textureX, textureY); // Box 137
		body[60] = new ModelRendererTurbo(this, 945, 137, textureX, textureY); // Box 175
		body[61] = new ModelRendererTurbo(this, 249, 169, textureX, textureY); // Box 179
		body[62] = new ModelRendererTurbo(this, 473, 81, textureX, textureY); // Box 180
		body[63] = new ModelRendererTurbo(this, 1, 289, textureX, textureY); // Box 190
		body[64] = new ModelRendererTurbo(this, 577, 145, textureX, textureY); // Box 191
		body[65] = new ModelRendererTurbo(this, 377, 89, textureX, textureY); // Box 192
		body[66] = new ModelRendererTurbo(this, 153, 289, textureX, textureY); // Box 193
		body[67] = new ModelRendererTurbo(this, 1, 105, textureX, textureY); // Box 196
		body[68] = new ModelRendererTurbo(this, 113, 89, textureX, textureY); // Box 207
		body[69] = new ModelRendererTurbo(this, 409, 57, textureX, textureY); // Box 213
		body[70] = new ModelRendererTurbo(this, 801, 57, textureX, textureY); // Box 214
		body[71] = new ModelRendererTurbo(this, 657, 1, textureX, textureY); // Box 215
		body[72] = new ModelRendererTurbo(this, 769, 1, textureX, textureY); // Box 216
		body[73] = new ModelRendererTurbo(this, 777, 81, textureX, textureY); // Box 217
		body[74] = new ModelRendererTurbo(this, 1009, 1, textureX, textureY); // Box 218
		body[75] = new ModelRendererTurbo(this, 601, 9, textureX, textureY); // Box 305
		body[76] = new ModelRendererTurbo(this, 1009, 65, textureX, textureY); // Box 306
		body[77] = new ModelRendererTurbo(this, 113, 73, textureX, textureY); // Box 307
		body[78] = new ModelRendererTurbo(this, 729, 9, textureX, textureY); // Box 308
		body[79] = new ModelRendererTurbo(this, 769, 17, textureX, textureY); // Box 309
		body[80] = new ModelRendererTurbo(this, 129, 89, textureX, textureY); // Box 310
		body[81] = new ModelRendererTurbo(this, 1001, 17, textureX, textureY); // Box 311
		body[82] = new ModelRendererTurbo(this, 257, 25, textureX, textureY); // Box 312
		body[83] = new ModelRendererTurbo(this, 425, 145, textureX, textureY); // Box 313
		body[84] = new ModelRendererTurbo(this, 809, 153, textureX, textureY); // Box 314
		body[85] = new ModelRendererTurbo(this, 281, 89, textureX, textureY); // Box 315
		body[86] = new ModelRendererTurbo(this, 161, 137, textureX, textureY); // Box 316
		body[87] = new ModelRendererTurbo(this, 457, 89, textureX, textureY); // Box 317
		body[88] = new ModelRendererTurbo(this, 305, 121, textureX, textureY); // Box 318
		body[89] = new ModelRendererTurbo(this, 393, 121, textureX, textureY); // Box 319
		body[90] = new ModelRendererTurbo(this, 473, 145, textureX, textureY); // Box 320
		body[91] = new ModelRendererTurbo(this, 1001, 145, textureX, textureY); // Box 321
		body[92] = new ModelRendererTurbo(this, 665, 153, textureX, textureY); // Box 322
		body[93] = new ModelRendererTurbo(this, 689, 89, textureX, textureY); // Box 323
		body[94] = new ModelRendererTurbo(this, 1, 33, textureX, textureY); // Box 324
		body[95] = new ModelRendererTurbo(this, 945, 177, textureX, textureY); // Box 330
		body[96] = new ModelRendererTurbo(this, 457, 57, textureX, textureY); // Box 295
		body[97] = new ModelRendererTurbo(this, 1, 65, textureX, textureY); // Box 297
		body[98] = new ModelRendererTurbo(this, 753, 129, textureX, textureY); // Box 305
		body[99] = new ModelRendererTurbo(this, 729, 57, textureX, textureY); // Box 310
		body[100] = new ModelRendererTurbo(this, 65, 65, textureX, textureY); // Box 311
		body[101] = new ModelRendererTurbo(this, 993, 65, textureX, textureY); // Box 312
		body[102] = new ModelRendererTurbo(this, 617, 185, textureX, textureY); // Box 313
		body[103] = new ModelRendererTurbo(this, 633, 185, textureX, textureY); // Box 314
		body[104] = new ModelRendererTurbo(this, 649, 185, textureX, textureY); // Box 315

		body[0].addBox(0F, 0F, 0F, 166, 2, 46, 0F); // Box 6
		body[0].setRotationPoint(-112F, -3F, -23F);

		body[1].addBox(-2F, -2F, 0F, 4, 4, 50, 0F); // Box 7
		body[1].setRotationPoint(68F, -2F, -25F);

		body[2].addBox(-2F, -2F, 0F, 4, 4, 50, 0F); // Box 8
		body[2].setRotationPoint(-70F, -2F, -25F);

		body[3].addShapeBox(0F, 0F, 0F, 20, 2, 9, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 10
		body[3].setRotationPoint(82F, -3F, -32F);

		body[4].addShapeBox(0F, 0F, 0F, 20, 2, 9, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F); // Box 11
		body[4].setRotationPoint(82F, -3F, 23F);

		body[5].addShapeBox(0F, 0F, 0F, 28, 2, 9, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F); // Box 12
		body[5].setRotationPoint(-112F, -3F, 23F);

		body[6].addShapeBox(0F, 0F, 0F, 28, 2, 9, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 13
		body[6].setRotationPoint(-112F, -3F, -32F);

		body[7].addBox(0F, 0F, 0F, 110, 2, 9, 0F); // Box 14
		body[7].setRotationPoint(-56F, -3F, 23F);

		body[8].addBox(0F, 0F, 0F, 110, 2, 9, 0F); // Box 15
		body[8].setRotationPoint(-56F, -3F, -32F);

		body[9].addBox(0F, 0F, 0F, 110, 6, 1, 0F); // Box 16
		body[9].setRotationPoint(-56F, -4F, 30.5F);

		body[10].addBox(0F, 0F, 0F, 110, 6, 1, 0F); // Box 17
		body[10].setRotationPoint(-56F, -4F, -31.5F);

		body[11].addBox(0F, 0F, 0F, 16, 6, 1, 0F); // Box 18
		body[11].setRotationPoint(82F, -4F, 30.5F);

		body[12].addBox(0F, 0F, 0F, 16, 6, 1, 0F); // Box 19
		body[12].setRotationPoint(82F, -4F, -31.5F);

		body[13].addShapeBox(0F, 0F, 0F, 1, 6, 8, 0F, -3F, 0F, 0F, 3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 20
		body[13].setRotationPoint(97F, -4F, 23.5F);

		body[14].addShapeBox(0F, 0F, 0F, 1, 6, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, -3F, 0F, 0F); // Box 21
		body[14].setRotationPoint(97F, -4F, -31.5F);

		body[15].addBox(0F, 0F, 0F, 1, 6, 47, 0F); // Box 22
		body[15].setRotationPoint(100F, -4F, -23.5F);

		body[16].addBox(0F, 0F, 0F, 2, 10, 61, 0F); // Box 23
		body[16].setRotationPoint(-56F, -13F, -30.5F);

		body[17].addBox(0F, 0F, 0F, 24, 6, 1, 0F); // Box 24
		body[17].setRotationPoint(-108F, -4F, -31.5F);

		body[18].addBox(0F, 0F, 0F, 24, 6, 1, 0F); // Box 25
		body[18].setRotationPoint(-108F, -4F, 30.5F);

		body[19].addShapeBox(0F, 0F, 0F, 1, 6, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 3F, 0F, 0F); // Box 26
		body[19].setRotationPoint(-108F, -4F, -31.5F);

		body[20].addShapeBox(0F, 0F, 0F, 1, 6, 8, 0F, 3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 27
		body[20].setRotationPoint(-108F, -4F, 23.5F);

		body[21].addBox(0F, 0F, 0F, 1, 6, 47, 0F); // Box 28
		body[21].setRotationPoint(-111F, -4F, -23.5F);

		body[22].addShapeBox(0F, 0F, 0F, 28, 12, 35, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 29
		body[22].setRotationPoint(54F, -13F, -17.5F);

		body[23].addBox(0F, 0F, 0F, 20, 2, 46, 0F); // Box 30
		body[23].setRotationPoint(82F, -3F, -23F);

		body[24].addBox(0F, 0F, 0F, 37, 1, 61, 0F); // Box 31
		body[24].setRotationPoint(-108F, -19F, -30.5F);

		body[25].addShapeBox(0F, 0F, 0F, 15, 1, 61, 0F, 0F, 0F, 0F, 0F, -6F, 0F, 0F, -6F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 6F, 0F, 0F, 6F, 0F, 0F, 0F, 0F); // Box 32
		body[25].setRotationPoint(-71F, -19F, -30.5F);

		body[26].addBox(0F, 0F, 0F, 92, 1, 61, 0F); // Box 33
		body[26].setRotationPoint(-38F, -13F, -30.5F);

		body[27].addBox(0F, 0F, 0F, 14, 9, 44, 0F); // Box 34
		body[27].setRotationPoint(-54F, -13F, -13.5F);

		body[28].addBox(0F, 0F, 0F, 12, 2, 18, 0F); // Box 60
		body[28].setRotationPoint(71F, -17F, 11F);

		body[29].addShapeBox(0F, 0F, 0F, 1, 4, 47, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F, 0F); // Box 67
		body[29].setRotationPoint(100F, -10F, -23.5F);

		body[30].addShapeBox(0F, 0F, 0F, 2, 10, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, -4.8F, 0F, 0F, 2.8F, -3.6F, 0F, 2.8F, -3.6F, -0.5F, -4.8F, 0F, -0.5F); // Box 84
		body[30].setRotationPoint(77F, -11F, 31.5F);

		body[31].addShapeBox(0F, 0F, 0F, 2, 10, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 2.8F, -3.6F, 0F, -4.8F, 0F, 0F, -4.8F, 0F, -0.5F, 2.8F, -3.6F, -0.5F); // Box 85
		body[31].setRotationPoint(57F, -11F, 31.5F);

		body[32].addShapeBox(0F, 0F, 0F, 2, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, -7F, 0F, 0F, 7F, 0F, 0F, 7F, 0F, -0.5F, -7F, 0F, -0.5F); // Box 86
		body[32].setRotationPoint(70F, -15F, 31.5F);

		body[33].addShapeBox(0F, 0F, 0F, 2, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 7F, 0F, 0F, -7F, 0F, 0F, -7F, 0F, -0.5F, 7F, 0F, -0.5F); // Box 87
		body[33].setRotationPoint(64F, -15F, 31.5F);

		body[34].addShapeBox(0F, 0F, 0F, 8, 1, 1, 0F, -3F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, -0.5F, -3F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 88
		body[34].setRotationPoint(64F, -16F, 31.5F);

		body[35].addShapeBox(0F, 0F, 0F, 1, 14, 43, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F); // Box 92
		body[35].setRotationPoint(-111F, -23F, -21.5F);

		body[36].addShapeBox(0F, 0F, 0F, 1, 4, 1, 0F, 0.2F, -0.4F, 0F, 0F, -2F, 0F, 0F, -2F, -0.5F, 0.2F, -0.4F, -0.5F, 0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0.2F, 0F, -0.5F); // Box 98
		body[36].setRotationPoint(82F, -5F, 31.5F);

		body[37].addShapeBox(0F, 0F, 0F, 1, 4, 1, 0F, 0F, -2F, 0F, 0.2F, -0.4F, 0F, 0.2F, -0.4F, -0.5F, 0F, -2F, -0.5F, 0F, 0F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 99
		body[37].setRotationPoint(53F, -5F, 31.5F);

		body[38].addShapeBox(0F, 0F, 0F, 2, 10, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, -4.8F, 0F, -0.5F, 2.8F, -3.6F, -0.5F, 2.8F, -3.6F, 0F, -4.8F, 0F, 0F); // Box 100
		body[38].setRotationPoint(77F, -11F, -32.5F);

		body[39].addShapeBox(0F, 0F, 0F, 2, 10, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 2.8F, -3.6F, -0.5F, -4.8F, 0F, -0.5F, -4.8F, 0F, 0F, 2.8F, -3.6F, 0F); // Box 101
		body[39].setRotationPoint(57F, -11F, -32.5F);

		body[40].addShapeBox(0F, 0F, 0F, 2, 4, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, -7F, 0F, -0.5F, 7F, 0F, -0.5F, 7F, 0F, 0F, -7F, 0F, 0F); // Box 102
		body[40].setRotationPoint(70F, -15F, -32.5F);

		body[41].addShapeBox(0F, 0F, 0F, 2, 4, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 7F, 0F, -0.5F, -7F, 0F, -0.5F, -7F, 0F, 0F, 7F, 0F, 0F); // Box 103
		body[41].setRotationPoint(64F, -15F, -32.5F);

		body[42].addShapeBox(0F, 0F, 0F, 8, 1, 1, 0F, -3F, 0F, -0.5F, -3F, 0F, -0.5F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 104
		body[42].setRotationPoint(64F, -16F, -32.5F);

		body[43].addShapeBox(0F, 0F, 0F, 1, 4, 1, 0F, 0.2F, -0.4F, -0.5F, 0F, -2F, -0.5F, 0F, -2F, 0F, 0.2F, -0.4F, 0F, 0.2F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0.2F, 0F, 0F); // Box 105
		body[43].setRotationPoint(82F, -5F, -32.5F);

		body[44].addShapeBox(0F, 0F, 0F, 1, 4, 1, 0F, 0F, -2F, -0.5F, 0.2F, -0.4F, -0.5F, 0.2F, -0.4F, 0F, 0F, -2F, 0F, 0F, 0F, -0.5F, 0.2F, 0F, -0.5F, 0.2F, 0F, 0F, 0F, 0F, 0F); // Box 106
		body[44].setRotationPoint(53F, -5F, -32.5F);

		body[45].addBox(0F, 0F, 0F, 15, 1, 61, 0F); // Box 109
		body[45].setRotationPoint(82F, -4F, -30.5F);

		body[46].addBox(0F, 0F, 0F, 1, 1, 47, 0F); // Box 110
		body[46].setRotationPoint(100F, -9.5F, -23.5F);

		body[47].addBox(0F, 0F, 0F, 1, 1, 47, 0F); // Box 111
		body[47].setRotationPoint(100F, -7.5F, -23.5F);

		body[48].addShapeBox(0F, 0F, 0F, 3, 17, 47, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 112
		body[48].setRotationPoint(97F, -21F, -23.5F);

		body[49].addBox(0F, 0F, 0F, 14, 4, 54, 0F); // Box 115
		body[49].setRotationPoint(82F, -8F, -23.5F);

		body[50].addBox(0F, 0F, 0F, 15, 4, 47, 0F); // Box 116
		body[50].setRotationPoint(82F, -12F, -16.5F);

		body[51].addBox(0F, 0F, 0F, 1, 1, 43, 0F); // Box 129
		body[51].setRotationPoint(-111F, -22.5F, -21.5F);

		body[52].addBox(0F, 0F, 0F, 1, 1, 43, 0F); // Box 130
		body[52].setRotationPoint(-111F, -21F, -21.5F);

		body[53].addBox(0F, 0F, 0F, 1, 1, 43, 0F); // Box 131
		body[53].setRotationPoint(-111F, -19.5F, -21.5F);

		body[54].addBox(0F, 0F, 0F, 1, 1, 43, 0F); // Box 132
		body[54].setRotationPoint(-111F, -18F, -21.5F);

		body[55].addBox(0F, 0F, 0F, 1, 1, 43, 0F); // Box 133
		body[55].setRotationPoint(-111F, -16.5F, -21.5F);

		body[56].addBox(0F, 0F, 0F, 1, 1, 43, 0F); // Box 134
		body[56].setRotationPoint(-111F, -15F, -21.5F);

		body[57].addBox(0F, 0F, 0F, 1, 1, 43, 0F); // Box 135
		body[57].setRotationPoint(-111F, -13.5F, -21.5F);

		body[58].addBox(0F, 0F, 0F, 1, 1, 43, 0F); // Box 136
		body[58].setRotationPoint(-111F, -12F, -21.5F);

		body[59].addBox(0F, 0F, 0F, 1, 1, 43, 0F); // Box 137
		body[59].setRotationPoint(-111F, -10.5F, -21.5F);

		body[60].addShapeBox(0F, 0F, 0F, 21, 1, 9, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 175
		body[60].setRotationPoint(-84F, -16F, 21.5F);

		body[61].addShapeBox(0F, 0F, 0F, 21, 1, 9, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 179
		body[61].setRotationPoint(-84F, -16F, -30.5F);

		body[62].addShapeBox(0F, 0F, 0F, 5, 4, 9, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -7F, 0F, 0F, 7F, 0F, 0F, 7F, 0F, 0F, -7F, 0F, 0F); // Box 180
		body[62].setRotationPoint(-68F, -15F, -30.5F);

		body[63].addBox(0F, 0F, 0F, 14, 1, 61, 0F); // Box 190
		body[63].setRotationPoint(-54F, -4F, -30.5F);

		body[64].addBox(0F, 0F, 0F, 14, 4, 11, 0F); // Box 191
		body[64].setRotationPoint(-54F, -8F, -24.5F);

		body[65].addShapeBox(0F, 0F, 0F, 14, 4, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 192
		body[65].setRotationPoint(-54F, -12F, -17.5F);

		body[66].addBox(0F, 0F, 0F, 2, 10, 61, 0F); // Box 193
		body[66].setRotationPoint(-40F, -13F, -30.5F);

		body[67].addShapeBox(0F, 0F, 0F, 5, 4, 9, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -7F, 0F, 0F, 7F, 0F, 0F, 7F, 0F, 0F, -7F, 0F, 0F); // Box 196
		body[67].setRotationPoint(-68F, -15F, 21.5F);

		body[68].addBox(0F, 0F, 0F, 6, 4, 1, 0F); // Box 207
		body[68].setRotationPoint(74F, -16F, 13F);

		body[69].addShapeBox(0F, 0F, 0F, 2, 10, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, -4.8F, 0F, 0F, 2.8F, -3.6F, 0F, 2.8F, -3.6F, -0.5F, -4.8F, 0F, -0.5F); // Box 213
		body[69].setRotationPoint(-61F, -11F, 31.5F);

		body[70].addShapeBox(0F, 0F, 0F, 2, 10, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 2.8F, -3.6F, 0F, -4.8F, 0F, 0F, -4.8F, 0F, -0.5F, 2.8F, -3.6F, -0.5F); // Box 214
		body[70].setRotationPoint(-81F, -11F, 31.5F);

		body[71].addShapeBox(0F, 0F, 0F, 2, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, -7F, 0F, 0F, 7F, 0F, 0F, 7F, 0F, -0.5F, -7F, 0F, -0.5F); // Box 215
		body[71].setRotationPoint(-68F, -15F, 31.5F);

		body[72].addShapeBox(0F, 0F, 0F, 2, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 7F, 0F, 0F, -7F, 0F, 0F, -7F, 0F, -0.5F, 7F, 0F, -0.5F); // Box 216
		body[72].setRotationPoint(-74F, -15F, 31.5F);

		body[73].addShapeBox(0F, 0F, 0F, 8, 1, 1, 0F, -3F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, -0.5F, -3F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 217
		body[73].setRotationPoint(-74F, -16F, 31.5F);

		body[74].addShapeBox(0F, 0F, 0F, 1, 4, 1, 0F, 0.2F, -0.4F, 0F, 0F, -2F, 0F, 0F, -2F, -0.5F, 0.2F, -0.4F, -0.5F, 0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0.2F, 0F, -0.5F); // Box 218
		body[74].setRotationPoint(-56F, -5F, 31.5F);

		body[75].addShapeBox(0F, 0F, 0F, 1, 4, 1, 0F, 0F, -2F, 0F, 0.2F, -0.4F, 0F, 0.2F, -0.4F, -0.5F, 0F, -2F, -0.5F, 0F, 0F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 305
		body[75].setRotationPoint(-85F, -5F, 31.5F);

		body[76].addShapeBox(0F, 0F, 0F, 2, 10, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, -4.8F, 0F, -0.5F, 2.8F, -3.6F, -0.5F, 2.8F, -3.6F, 0F, -4.8F, 0F, 0F); // Box 306
		body[76].setRotationPoint(-61F, -11F, -32.5F);

		body[77].addShapeBox(0F, 0F, 0F, 2, 10, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 2.8F, -3.6F, -0.5F, -4.8F, 0F, -0.5F, -4.8F, 0F, 0F, 2.8F, -3.6F, 0F); // Box 307
		body[77].setRotationPoint(-81F, -11F, -32.5F);

		body[78].addShapeBox(0F, 0F, 0F, 2, 4, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, -7F, 0F, -0.5F, 7F, 0F, -0.5F, 7F, 0F, 0F, -7F, 0F, 0F); // Box 308
		body[78].setRotationPoint(-68F, -15F, -32.5F);

		body[79].addShapeBox(0F, 0F, 0F, 2, 4, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 7F, 0F, -0.5F, -7F, 0F, -0.5F, -7F, 0F, 0F, 7F, 0F, 0F); // Box 309
		body[79].setRotationPoint(-74F, -15F, -32.5F);

		body[80].addShapeBox(0F, 0F, 0F, 8, 1, 1, 0F, -3F, 0F, -0.5F, -3F, 0F, -0.5F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 310
		body[80].setRotationPoint(-74F, -16F, -32.5F);

		body[81].addShapeBox(0F, 0F, 0F, 1, 4, 1, 0F, 0.2F, -0.4F, -0.5F, 0F, -2F, -0.5F, 0F, -2F, 0F, 0.2F, -0.4F, 0F, 0.2F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0.2F, 0F, 0F); // Box 311
		body[81].setRotationPoint(-56F, -5F, -32.5F);

		body[82].addShapeBox(0F, 0F, 0F, 1, 4, 1, 0F, 0F, -2F, -0.5F, 0.2F, -0.4F, -0.5F, 0.2F, -0.4F, 0F, 0F, -2F, 0F, 0F, 0F, -0.5F, 0.2F, 0F, -0.5F, 0.2F, 0F, 0F, 0F, 0F, 0F); // Box 312
		body[82].setRotationPoint(-85F, -5F, -32.5F);

		body[83].addShapeBox(0F, 0F, 0F, 6, 2, 11, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 313
		body[83].setRotationPoint(90F, -23F, 14F);

		body[84].addShapeBox(0F, 0F, 0F, 5, 8, 12, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -7F, 0F, 1F, 1F, 0F, 1F, 1F, 0F, 0F, -7F, 0F); // Box 314
		body[84].setRotationPoint(90F, -21F, 13.5F);

		body[85].addShapeBox(0F, 0F, 0F, 4, 8, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -7F, 0F, 0F, -7F, 0F); // Box 315
		body[85].setRotationPoint(86F, -21F, 8.5F);

		body[86].addShapeBox(0F, 0F, 0F, 4, 8, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -7F, 0F, 0F, -7F, 0F, 0F, 1F, 0F, 0F, 1F, 0F); // Box 316
		body[86].setRotationPoint(86F, -21F, 25.5F);

		body[87].addShapeBox(0F, 0F, 0F, 4, 2, 6, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 317
		body[87].setRotationPoint(86F, -23F, 8F);

		body[88].addShapeBox(0F, 0F, 0F, 4, 2, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 318
		body[88].setRotationPoint(86F, -23F, 25F);

		body[89].addShapeBox(0F, 0F, 0F, 6, 2, 6, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 319
		body[89].setRotationPoint(90F, -23F, 25F);

		body[90].addShapeBox(0F, 0F, 0F, 6, 2, 6, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 320
		body[90].setRotationPoint(90F, -23F, 8F);

		body[91].addShapeBox(0F, 0F, 0F, 6, 8, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -7F, 0F, 0F, -7F, 0F); // Box 321
		body[91].setRotationPoint(90F, -21F, 8.5F);

		body[92].addShapeBox(0F, 0F, 0F, 6, 8, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -7F, 0F, 0F, -7F, 0F, 0F, 1F, 0F, 0F, 1F, 0F); // Box 322
		body[92].setRotationPoint(90F, -21F, 25.5F);

		body[93].addShapeBox(0F, 0F, 0F, 3, 10, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, -3F, 0F, 0F); // Box 323
		body[93].setRotationPoint(87F, -22F, 17.5F);

		body[94].addShapeBox(0F, 0F, 0F, 2, 2, 2, 0F, 0.1F, 0F, -0.1F, -0.4F, 0.4F, -0.1F, -0.4F, 0.4F, -0.1F, 0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F); // Box 324
		body[94].setRotationPoint(87.5F, -24F, 18F);

		body[95].addBox(0F, 0F, 0F, 2, 14, 18, 0F); // Box 330
		body[95].setRotationPoint(70F, -30F, 11F);
		body[95].rotateAngleZ = 0.06981317F;

		body[96].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // Box 295
		body[96].setRotationPoint(80F, -20F, -31F);

		body[97].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // Box 297
		body[97].setRotationPoint(-56F, -24F, -31F);

		body[98].addShapeBox(0F, -2F, -2F, 1, 4, 4, 0F, 0F, -0.5F, -0.5F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -0.5F, -0.5F); // Box 305
		body[98].setRotationPoint(100.5F, -8F, 0F);

		body[99].addBox(0F, 0F, -6F, 1, 3, 12, 0F); // Box 310
		body[99].setRotationPoint(101F, -1F, 0F);
		body[99].rotateAngleZ = -0.08726646F;

		body[100].addBox(-1F, 0F, -6F, 1, 3, 12, 0F); // Box 311
		body[100].setRotationPoint(-110.5F, -6.5F, 0F);

		body[101].addBox(0F, 0F, -6F, 1, 3, 12, 0F); // Box 312
		body[101].setRotationPoint(95.5F, -22.5F, 15F);
		body[101].rotateAngleZ = 0.78539816F;

		body[102].addBox(0F, 0F, 0F, 2, 36, 2, 0F); // Box 313
		body[102].setRotationPoint(57F, -48F, 7F);

		body[103].addBox(0F, 0F, 0F, 2, 36, 2, 0F); // Box 314
		body[103].setRotationPoint(73F, -48F, 7F);

		body[104].addBox(0F, 0F, 0F, 2, 36, 2, 0F); // Box 315
		body[104].setRotationPoint(57F, -48F, 28F);

		bodyColoredSecondary = new ModelRendererTurbo[26];
		bodyColoredSecondary[0] = new ModelRendererTurbo(this, 1017, 49, textureX, textureY); // Box 113
		bodyColoredSecondary[1] = new ModelRendererTurbo(this, 809, 57, textureX, textureY); // Box 114
		bodyColoredSecondary[2] = new ModelRendererTurbo(this, 1001, 113, textureX, textureY); // Box 141
		bodyColoredSecondary[3] = new ModelRendererTurbo(this, 809, 129, textureX, textureY); // Box 142
		bodyColoredSecondary[4] = new ModelRendererTurbo(this, 1, 241, textureX, textureY); // Box 150
		bodyColoredSecondary[5] = new ModelRendererTurbo(this, 1, 265, textureX, textureY); // Box 151
		bodyColoredSecondary[6] = new ModelRendererTurbo(this, 113, 137, textureX, textureY); // Box 152
		bodyColoredSecondary[7] = new ModelRendererTurbo(this, 377, 145, textureX, textureY); // Box 153
		bodyColoredSecondary[8] = new ModelRendererTurbo(this, 537, 121, textureX, textureY); // Box 161
		bodyColoredSecondary[9] = new ModelRendererTurbo(this, 553, 121, textureX, textureY); // Box 162
		bodyColoredSecondary[10] = new ModelRendererTurbo(this, 665, 121, textureX, textureY); // Box 163
		bodyColoredSecondary[11] = new ModelRendererTurbo(this, 721, 121, textureX, textureY); // Box 164
		bodyColoredSecondary[12] = new ModelRendererTurbo(this, 737, 121, textureX, textureY); // Box 165
		bodyColoredSecondary[13] = new ModelRendererTurbo(this, 825, 129, textureX, textureY); // Box 166
		bodyColoredSecondary[14] = new ModelRendererTurbo(this, 841, 129, textureX, textureY); // Box 167
		bodyColoredSecondary[15] = new ModelRendererTurbo(this, 889, 129, textureX, textureY); // Box 168
		bodyColoredSecondary[16] = new ModelRendererTurbo(this, 905, 129, textureX, textureY); // Box 169
		bodyColoredSecondary[17] = new ModelRendererTurbo(this, 921, 129, textureX, textureY); // Box 170
		bodyColoredSecondary[18] = new ModelRendererTurbo(this, 33, 137, textureX, textureY); // Box 182
		bodyColoredSecondary[19] = new ModelRendererTurbo(this, 89, 137, textureX, textureY); // Box 183
		bodyColoredSecondary[20] = new ModelRendererTurbo(this, 225, 137, textureX, textureY); // Box 197
		bodyColoredSecondary[21] = new ModelRendererTurbo(this, 249, 137, textureX, textureY); // Box 198
		bodyColoredSecondary[22] = new ModelRendererTurbo(this, 1017, 81, textureX, textureY); // Box 201
		bodyColoredSecondary[23] = new ModelRendererTurbo(this, 113, 161, textureX, textureY); // Box 341
		bodyColoredSecondary[24] = new ModelRendererTurbo(this, 569, 185, textureX, textureY); // Box 342
		bodyColoredSecondary[25] = new ModelRendererTurbo(this, 945, 153, textureX, textureY); // Box 398

		bodyColoredSecondary[0].addShapeBox(0F, 0F, 0F, 2, 24, 1, 0F, 2F, 0F, -1F, -2F, 0F, -1F, -2F, 0F, 1F, 2F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 113
		bodyColoredSecondary[0].setRotationPoint(95F, -45F, -31.5F);

		bodyColoredSecondary[1].addShapeBox(0F, 0F, 0F, 2, 24, 1, 0F, 2F, 0F, 1F, -2F, 0F, 1F, -2F, 0F, -1F, 2F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 114
		bodyColoredSecondary[1].setRotationPoint(95F, -45F, 30.5F);

		bodyColoredSecondary[2].addShapeBox(0F, 0F, 0F, 4, 26, 1, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 141
		bodyColoredSecondary[2].setRotationPoint(78F, -47F, -31.5F);

		bodyColoredSecondary[3].addShapeBox(0F, 0F, 0F, 4, 26, 1, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 142
		bodyColoredSecondary[3].setRotationPoint(78F, -47F, 30.5F);

		bodyColoredSecondary[4].addShapeBox(0F, 0F, 0F, 186, 1, 19, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F); // Box 150
		bodyColoredSecondary[4].setRotationPoint(-104F, -48F, -30.5F);

		bodyColoredSecondary[5].addShapeBox(0F, 0F, 0F, 186, 1, 19, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 151
		bodyColoredSecondary[5].setRotationPoint(-104F, -48F, 11.5F);

		bodyColoredSecondary[6].addShapeBox(0F, 0F, -1F, 11, 1, 18, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, -2F, 0F, 0F, -2F); // Box 152
		bodyColoredSecondary[6].setRotationPoint(82F, -48F, -28.5F);

		bodyColoredSecondary[7].addShapeBox(0F, 0F, 0F, 11, 1, 19, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 2F, -2F, 0F, 2F, 0F, 0F, 0F, 0F); // Box 153
		bodyColoredSecondary[7].setRotationPoint(82F, -48F, 11.5F);

		bodyColoredSecondary[8].addShapeBox(0F, 0F, 0F, 4, 21, 1, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 161
		bodyColoredSecondary[8].setRotationPoint(50F, -47F, -31.5F);

		bodyColoredSecondary[9].addShapeBox(0F, 0F, 0F, 4, 21, 1, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 162
		bodyColoredSecondary[9].setRotationPoint(20F, -47F, -31.5F);

		bodyColoredSecondary[10].addShapeBox(0F, 0F, 0F, 4, 21, 1, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 163
		bodyColoredSecondary[10].setRotationPoint(-10F, -47F, -31.5F);

		bodyColoredSecondary[11].addShapeBox(0F, 0F, 0F, 4, 21, 1, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 164
		bodyColoredSecondary[11].setRotationPoint(-40F, -47F, -31.5F);

		bodyColoredSecondary[12].addShapeBox(0F, 0F, 0F, 4, 21, 1, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 165
		bodyColoredSecondary[12].setRotationPoint(-58F, -47F, -31.5F);

		bodyColoredSecondary[13].addShapeBox(0F, 0F, 0F, 4, 21, 1, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 166
		bodyColoredSecondary[13].setRotationPoint(-58F, -47F, 30.5F);

		bodyColoredSecondary[14].addShapeBox(0F, 0F, 0F, 4, 21, 1, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 167
		bodyColoredSecondary[14].setRotationPoint(-40F, -47F, 30.5F);

		bodyColoredSecondary[15].addShapeBox(0F, 0F, 0F, 4, 21, 1, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 168
		bodyColoredSecondary[15].setRotationPoint(-10F, -47F, 30.5F);

		bodyColoredSecondary[16].addShapeBox(0F, 0F, 0F, 4, 21, 1, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 169
		bodyColoredSecondary[16].setRotationPoint(20F, -47F, 30.5F);

		bodyColoredSecondary[17].addShapeBox(0F, 0F, 0F, 4, 21, 1, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 170
		bodyColoredSecondary[17].setRotationPoint(50F, -47F, 30.5F);

		bodyColoredSecondary[18].addShapeBox(0F, 0F, 0F, 4, 21, 1, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 182
		bodyColoredSecondary[18].setRotationPoint(-86F, -47F, -31.5F);

		bodyColoredSecondary[19].addShapeBox(0F, 0F, 0F, 4, 21, 1, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 183
		bodyColoredSecondary[19].setRotationPoint(-86F, -47F, 30.5F);

		bodyColoredSecondary[20].addShapeBox(0F, 0F, 0F, 4, 21, 1, 0F, -2F, 0F, 1F, 2F, 0F, 1F, 2F, 0F, -1F, -2F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 197
		bodyColoredSecondary[20].setRotationPoint(-108F, -47F, 30.5F);

		bodyColoredSecondary[21].addShapeBox(0F, 0F, 0F, 4, 21, 1, 0F, -2F, 0F, -1F, 2F, 0F, -1F, 2F, 0F, 1F, -2F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 198
		bodyColoredSecondary[21].setRotationPoint(-108F, -47F, -31.5F);

		bodyColoredSecondary[22].addShapeBox(0F, -24F, -1F, 1, 24, 2, 0F, 3F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 201
		bodyColoredSecondary[22].setRotationPoint(100F, -21F, 0F);

		bodyColoredSecondary[23].addShapeBox(0F, 0F, 0F, 1, 21, 8, 0F, -2F, 0F, -1F, 2F, 0F, -1F, -1F, 0F, 1F, 1F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 3F, 0F, 0F); // Box 341
		bodyColoredSecondary[23].setRotationPoint(-108F, -47F, -31.5F);

		bodyColoredSecondary[24].addShapeBox(0F, 0F, 0F, 1, 21, 8, 0F, 1F, 0F, 1F, -1F, 0F, 1F, 2F, 0F, -1F, -2F, 0F, -1F, 3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 342
		bodyColoredSecondary[24].setRotationPoint(-108F, -47F, 23.5F);

		bodyColoredSecondary[25].addShapeBox(0F, 0F, -1F, 11, 4, 1, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 398
		bodyColoredSecondary[25].setRotationPoint(82F, -48F, -29.5F);


		bodyColoredPrimary = new ModelRendererTurbo[68];
		bodyColoredPrimary[0] = new ModelRendererTurbo(this, 753, 113, textureX, textureY); // Box 35
		bodyColoredPrimary[1] = new ModelRendererTurbo(this, 1, 121, textureX, textureY); // Box 36
		bodyColoredPrimary[2] = new ModelRendererTurbo(this, 713, 25, textureX, textureY); // Box 38
		bodyColoredPrimary[3] = new ModelRendererTurbo(this, 1017, 1, textureX, textureY); // Box 39
		bodyColoredPrimary[4] = new ModelRendererTurbo(this, 1009, 17, textureX, textureY); // Box 40
		bodyColoredPrimary[5] = new ModelRendererTurbo(this, 1017, 25, textureX, textureY); // Box 41
		bodyColoredPrimary[6] = new ModelRendererTurbo(this, 737, 9, textureX, textureY); // Box 52
		bodyColoredPrimary[7] = new ModelRendererTurbo(this, 601, 25, textureX, textureY); // Box 53
		bodyColoredPrimary[8] = new ModelRendererTurbo(this, 241, 33, textureX, textureY); // Box 54
		bodyColoredPrimary[9] = new ModelRendererTurbo(this, 617, 33, textureX, textureY); // Box 57
		bodyColoredPrimary[10] = new ModelRendererTurbo(this, 993, 33, textureX, textureY); // Box 58
		bodyColoredPrimary[11] = new ModelRendererTurbo(this, 1, 49, textureX, textureY); // Box 59
		bodyColoredPrimary[12] = new ModelRendererTurbo(this, 17, 49, textureX, textureY); // Box 62
		bodyColoredPrimary[13] = new ModelRendererTurbo(this, 953, 81, textureX, textureY); // Box 63
		bodyColoredPrimary[14] = new ModelRendererTurbo(this, 745, 73, textureX, textureY); // Box 64
		bodyColoredPrimary[15] = new ModelRendererTurbo(this, 1009, 41, textureX, textureY); // Box 65
		bodyColoredPrimary[16] = new ModelRendererTurbo(this, 57, 49, textureX, textureY); // Box 66
		bodyColoredPrimary[17] = new ModelRendererTurbo(this, 889, 113, textureX, textureY); // Box 68
		bodyColoredPrimary[18] = new ModelRendererTurbo(this, 81, 49, textureX, textureY); // Box 69
		bodyColoredPrimary[19] = new ModelRendererTurbo(this, 113, 49, textureX, textureY); // Box 70
		bodyColoredPrimary[20] = new ModelRendererTurbo(this, 257, 1, textureX, textureY); // Box 71
		bodyColoredPrimary[21] = new ModelRendererTurbo(this, 121, 49, textureX, textureY); // Box 72
		bodyColoredPrimary[22] = new ModelRendererTurbo(this, 689, 89, textureX, textureY); // Box 73
		bodyColoredPrimary[23] = new ModelRendererTurbo(this, 169, 49, textureX, textureY); // Box 75
		bodyColoredPrimary[24] = new ModelRendererTurbo(this, 121, 57, textureX, textureY); // Box 76
		bodyColoredPrimary[25] = new ModelRendererTurbo(this, 193, 113, textureX, textureY); // Box 77
		bodyColoredPrimary[26] = new ModelRendererTurbo(this, 233, 121, textureX, textureY); // Box 78
		bodyColoredPrimary[27] = new ModelRendererTurbo(this, 321, 121, textureX, textureY); // Box 79
		bodyColoredPrimary[28] = new ModelRendererTurbo(this, 257, 57, textureX, textureY); // Box 80
		bodyColoredPrimary[29] = new ModelRendererTurbo(this, 945, 113, textureX, textureY); // Box 81
		bodyColoredPrimary[30] = new ModelRendererTurbo(this, 409, 121, textureX, textureY); // Box 82
		bodyColoredPrimary[31] = new ModelRendererTurbo(this, 377, 57, textureX, textureY); // Box 83
		bodyColoredPrimary[32] = new ModelRendererTurbo(this, 881, 49, textureX, textureY); // Box 89
		bodyColoredPrimary[33] = new ModelRendererTurbo(this, 417, 121, textureX, textureY); // Box 90
		bodyColoredPrimary[34] = new ModelRendererTurbo(this, 521, 121, textureX, textureY); // Box 91
		bodyColoredPrimary[35] = new ModelRendererTurbo(this, 153, 49, textureX, textureY); // Box 93
		bodyColoredPrimary[36] = new ModelRendererTurbo(this, 905, 49, textureX, textureY); // Box 94
		bodyColoredPrimary[37] = new ModelRendererTurbo(this, 457, 57, textureX, textureY); // Box 95
		bodyColoredPrimary[38] = new ModelRendererTurbo(this, 473, 121, textureX, textureY); // Box 96
		bodyColoredPrimary[39] = new ModelRendererTurbo(this, 577, 121, textureX, textureY); // Box 97
		bodyColoredPrimary[40] = new ModelRendererTurbo(this, 793, 97, textureX, textureY); // Box 107
		bodyColoredPrimary[41] = new ModelRendererTurbo(this, 857, 97, textureX, textureY); // Box 108
		bodyColoredPrimary[42] = new ModelRendererTurbo(this, 57, 145, textureX, textureY); // Box 117
		bodyColoredPrimary[43] = new ModelRendererTurbo(this, 1, 65, textureX, textureY); // Box 138
		bodyColoredPrimary[44] = new ModelRendererTurbo(this, 481, 65, textureX, textureY); // Box 139
		bodyColoredPrimary[45] = new ModelRendererTurbo(this, 617, 185, textureX, textureY); // Box 140
		bodyColoredPrimary[46] = new ModelRendererTurbo(this, 953, 97, textureX, textureY); // Box 148
		bodyColoredPrimary[47] = new ModelRendererTurbo(this, 385, 233, textureX, textureY); // Box 149
		bodyColoredPrimary[48] = new ModelRendererTurbo(this, 825, 225, textureX, textureY); // Box 154
		bodyColoredPrimary[49] = new ModelRendererTurbo(this, 1, 137, textureX, textureY); // Box 171
		bodyColoredPrimary[50] = new ModelRendererTurbo(this, 57, 81, textureX, textureY); // Box 172
		bodyColoredPrimary[51] = new ModelRendererTurbo(this, 17, 81, textureX, textureY); // Box 173
		bodyColoredPrimary[52] = new ModelRendererTurbo(this, 57, 137, textureX, textureY); // Box 174
		bodyColoredPrimary[53] = new ModelRendererTurbo(this, 161, 169, textureX, textureY); // Box 176
		bodyColoredPrimary[54] = new ModelRendererTurbo(this, 193, 137, textureX, textureY); // Box 177
		bodyColoredPrimary[55] = new ModelRendererTurbo(this, 169, 81, textureX, textureY); // Box 178
		bodyColoredPrimary[56] = new ModelRendererTurbo(this, 305, 137, textureX, textureY); // Box 181
		bodyColoredPrimary[57] = new ModelRendererTurbo(this, 665, 169, textureX, textureY); // Box 184
		bodyColoredPrimary[58] = new ModelRendererTurbo(this, 897, 73, textureX, textureY); // Box 185
		bodyColoredPrimary[59] = new ModelRendererTurbo(this, 257, 89, textureX, textureY); // Box 186
		bodyColoredPrimary[60] = new ModelRendererTurbo(this, 913, 225, textureX, textureY); // Box 187
		bodyColoredPrimary[61] = new ModelRendererTurbo(this, 1, 89, textureX, textureY); // Box 195
		bodyColoredPrimary[62] = new ModelRendererTurbo(this, 193, 113, textureX, textureY); // Box 338
		bodyColoredPrimary[63] = new ModelRendererTurbo(this, 945, 113, textureX, textureY); // Box 339
		bodyColoredPrimary[64] = new ModelRendererTurbo(this, 1017, 113, textureX, textureY); // Box 340
		bodyColoredPrimary[65] = new ModelRendererTurbo(this, 281, 289, textureX, textureY); // Box 343
		bodyColoredPrimary[66] = new ModelRendererTurbo(this, 529, 321, textureX, textureY); // Box 316
		bodyColoredPrimary[67] = new ModelRendererTurbo(this, 1, 193, textureX, textureY); // Box 317

		bodyColoredPrimary[0].addBox(0F, 0F, 0F, 90, 13, 1, 0F); // Box 35
		bodyColoredPrimary[0].setRotationPoint(-38F, -26F, 30.5F);

		bodyColoredPrimary[1].addBox(0F, 0F, 0F, 90, 13, 1, 0F); // Box 36
		bodyColoredPrimary[1].setRotationPoint(-38F, -26F, -31.5F);

		bodyColoredPrimary[2].addBox(0F, 0F, 0F, 18, 22, 1, 0F); // Box 38
		bodyColoredPrimary[2].setRotationPoint(-56F, -26F, 30.5F);

		bodyColoredPrimary[3].addBox(0F, 0F, 0F, 2, 22, 1, 0F); // Box 39
		bodyColoredPrimary[3].setRotationPoint(-40F, -26F, -31.5F);

		bodyColoredPrimary[4].addBox(0F, 0F, 0F, 2, 22, 1, 0F); // Box 40
		bodyColoredPrimary[4].setRotationPoint(52F, -26F, -31.5F);

		bodyColoredPrimary[5].addBox(0F, 0F, 0F, 2, 22, 1, 0F); // Box 41
		bodyColoredPrimary[5].setRotationPoint(52F, -26F, 30.5F);

		bodyColoredPrimary[6].addBox(0F, 0F, 0F, 5, 9, 1, 0F); // Box 52
		bodyColoredPrimary[6].setRotationPoint(19F, -13F, 30.5F);

		bodyColoredPrimary[7].addBox(0F, 0F, 0F, 5, 9, 1, 0F); // Box 53
		bodyColoredPrimary[7].setRotationPoint(-10F, -13F, 30.5F);

		bodyColoredPrimary[8].addBox(0F, 0F, 0F, 4, 9, 1, 0F); // Box 54
		bodyColoredPrimary[8].setRotationPoint(-38F, -13F, 30.5F);

		bodyColoredPrimary[9].addBox(0F, 0F, 0F, 4, 9, 1, 0F); // Box 57
		bodyColoredPrimary[9].setRotationPoint(-38F, -13F, -31.5F);

		bodyColoredPrimary[10].addBox(0F, 0F, 0F, 5, 9, 1, 0F); // Box 58
		bodyColoredPrimary[10].setRotationPoint(-10F, -13F, -31.5F);

		bodyColoredPrimary[11].addBox(0F, 0F, 0F, 5, 9, 1, 0F); // Box 59
		bodyColoredPrimary[11].setRotationPoint(19F, -13F, -31.5F);

		bodyColoredPrimary[12].addShapeBox(0F, 0F, 0F, 12, 17, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 62
		bodyColoredPrimary[12].setRotationPoint(84F, -21F, 30.5F);

		bodyColoredPrimary[13].addShapeBox(0F, 0F, 0F, 28, 11, 1, 0F, 0F, 0F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 63
		bodyColoredPrimary[13].setRotationPoint(54F, -26F, 30.5F);

		bodyColoredPrimary[14].addBox(0F, 0F, 0F, 28, 6, 1, 0F); // Box 64
		bodyColoredPrimary[14].setRotationPoint(54F, -21F, -31.5F);

		bodyColoredPrimary[15].addShapeBox(0F, 0F, 0F, 2, 17, 1, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 65
		bodyColoredPrimary[15].setRotationPoint(96F, -21F, 30.5F);

		bodyColoredPrimary[16].addShapeBox(0F, 0F, 0F, 1, 17, 8, 0F, 1F, 0F, 0F, 3F, 0F, 0F, -1F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F); // Box 66
		bodyColoredPrimary[16].setRotationPoint(97F, -21F, 23.5F);

		bodyColoredPrimary[17].addBox(0F, 0F, 0F, 1, 11, 47, 0F); // Box 68
		bodyColoredPrimary[17].setRotationPoint(100F, -21F, -23.5F);

		bodyColoredPrimary[18].addShapeBox(0F, 0F, 0F, 1, 17, 8, 0F, 2F, 0F, 0F, -1F, 0F, 0F, 3F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, 0F, 0F, 0F); // Box 69
		bodyColoredPrimary[18].setRotationPoint(97F, -21F, -31.5F);

		bodyColoredPrimary[19].addBox(0F, 0F, 0F, 2, 17, 1, 0F); // Box 70
		bodyColoredPrimary[19].setRotationPoint(82F, -21F, 30.5F);

		bodyColoredPrimary[20].addBox(0F, 0F, 0F, 1, 17, 1, 0F); // Box 71
		bodyColoredPrimary[20].setRotationPoint(95F, -21F, -31.5F);

		bodyColoredPrimary[21].addShapeBox(0F, 0F, 0F, 2, 17, 1, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 72
		bodyColoredPrimary[21].setRotationPoint(96F, -21F, -31.5F);

		bodyColoredPrimary[22].addShapeBox(0F, 0F, 0F, 12, 4, 14, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -7F, 0F, 0F, -7F, 0F, 0F, 0F, 0F, 0F); // Box 73
		bodyColoredPrimary[22].setRotationPoint(54F, -15F, 17.5F);

		bodyColoredPrimary[23].addShapeBox(0F, 0F, 0F, 5, 10, 14, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4.8F, 0F, 0F, -4.8F, 0F, 0F, 0F, 0F, 0F); // Box 75
		bodyColoredPrimary[23].setRotationPoint(54F, -11F, 17.5F);

		bodyColoredPrimary[24].addShapeBox(0F, 0F, 0F, 5, 10, 14, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4.8F, 0F, 0F); // Box 76
		bodyColoredPrimary[24].setRotationPoint(77F, -11F, 17.5F);

		bodyColoredPrimary[25].addShapeBox(0F, 0F, 0F, 12, 4, 14, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -7F, 0F, 0F); // Box 77
		bodyColoredPrimary[25].setRotationPoint(70F, -15F, 17.5F);

		bodyColoredPrimary[26].addBox(0F, 0F, 0F, 28, 1, 13, 0F); // Box 78
		bodyColoredPrimary[26].setRotationPoint(54F, -16F, 17.5F);

		bodyColoredPrimary[27].addBox(0F, 0F, 0F, 28, 1, 13, 0F); // Box 79
		bodyColoredPrimary[27].setRotationPoint(54F, -16F, -30.5F);

		bodyColoredPrimary[28].addShapeBox(0F, 0F, 0F, 5, 10, 14, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4.8F, 0F, 0F); // Box 80
		bodyColoredPrimary[28].setRotationPoint(77F, -11F, -31.5F);

		bodyColoredPrimary[29].addShapeBox(0F, 0F, 0F, 12, 4, 14, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -7F, 0F, 0F); // Box 81
		bodyColoredPrimary[29].setRotationPoint(70F, -15F, -31.5F);

		bodyColoredPrimary[30].addShapeBox(0F, 0F, 0F, 12, 4, 14, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -7F, 0F, 0F, -7F, 0F, 0F, 0F, 0F, 0F); // Box 82
		bodyColoredPrimary[30].setRotationPoint(54F, -15F, -31.5F);

		bodyColoredPrimary[31].addShapeBox(0F, 0F, 0F, 5, 10, 14, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4.8F, 0F, 0F, -4.8F, 0F, 0F, 0F, 0F, 0F); // Box 83
		bodyColoredPrimary[31].setRotationPoint(54F, -11F, -31.5F);

		bodyColoredPrimary[32].addShapeBox(0F, 0F, 0F, 1, 22, 8, 0F, 3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 89
		bodyColoredPrimary[32].setRotationPoint(-108F, -26F, 23.5F);

		bodyColoredPrimary[33].addBox(0F, 0F, 0F, 1, 5, 47, 0F); // Box 90
		bodyColoredPrimary[33].setRotationPoint(-111F, -9F, -23.5F);

		bodyColoredPrimary[34].addBox(0F, 0F, 0F, 1, 3, 47, 0F); // Box 91
		bodyColoredPrimary[34].setRotationPoint(-111F, -26F, -23.5F);

		bodyColoredPrimary[35].addBox(0F, 0F, 0F, 1, 14, 2, 0F); // Box 93
		bodyColoredPrimary[35].setRotationPoint(-111F, -23F, -23.5F);

		bodyColoredPrimary[36].addBox(0F, 0F, 0F, 1, 14, 2, 0F); // Box 94
		bodyColoredPrimary[36].setRotationPoint(-111F, -23F, 21.5F);

		bodyColoredPrimary[37].addShapeBox(0F, 0F, 0F, 1, 22, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 3F, 0F, 0F); // Box 95
		bodyColoredPrimary[37].setRotationPoint(-108F, -26F, -31.5F);

		bodyColoredPrimary[38].addBox(0F, 0F, 0F, 24, 22, 1, 0F); // Box 96
		bodyColoredPrimary[38].setRotationPoint(-108F, -26F, -31.5F);

		bodyColoredPrimary[39].addBox(0F, 0F, 0F, 24, 22, 1, 0F); // Box 97
		bodyColoredPrimary[39].setRotationPoint(-108F, -26F, 30.5F);

		bodyColoredPrimary[40].addBox(0F, 0F, 0F, 28, 5, 1, 0F); // Box 107
		bodyColoredPrimary[40].setRotationPoint(54F, -16F, -17.5F);

		bodyColoredPrimary[41].addBox(0F, 0F, 0F, 28, 5, 1, 0F); // Box 108
		bodyColoredPrimary[41].setRotationPoint(54F, -16F, 16.5F);

		bodyColoredPrimary[42].addBox(0F, 0F, 0F, 1, 2, 47, 0F); // Box 117
		bodyColoredPrimary[42].setRotationPoint(100F, -6F, -23.5F);

		bodyColoredPrimary[43].addShapeBox(0F, 0F, 0F, 2, 2, 8, 0F, 0F, 0F, 0F, 3F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 138
		bodyColoredPrimary[43].setRotationPoint(93F, -47F, 22.5F);

		bodyColoredPrimary[44].addShapeBox(0F, 0F, 0F, 2, 2, 8, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 3F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, 0F, 0F, 0F); // Box 139
		bodyColoredPrimary[44].setRotationPoint(93F, -47F, -30.5F);

		bodyColoredPrimary[45].addShapeBox(0F, 0F, 0F, 5, 2, 45, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 140
		bodyColoredPrimary[45].setRotationPoint(93F, -47F, -22.5F);

		bodyColoredPrimary[46].addShapeBox(0F, 0F, 0F, 28, 5, 1, 0F, 0F, 0F, 0F, 0F, -4.9F, 0F, 0F, -4.9F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 148
		bodyColoredPrimary[46].setRotationPoint(54F, -26F, -31.5F);

		bodyColoredPrimary[47].addBox(0F, 0F, 0F, 186, 1, 61, 0F); // Box 149
		bodyColoredPrimary[47].setRotationPoint(-104F, -49F, -30.5F);

		bodyColoredPrimary[48].addShapeBox(0F, 0F, 0F, 11, 1, 61, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F); // Box 154
		bodyColoredPrimary[48].setRotationPoint(82F, -49F, -30.5F);

		bodyColoredPrimary[49].addShapeBox(0F, 0F, 0F, 5, 10, 10, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4.8F, 0F, 0F, -4.8F, 0F, 0F, 0F, 0F, 0F); // Box 171
		bodyColoredPrimary[49].setRotationPoint(-84F, -11F, 21.5F);

		bodyColoredPrimary[50].addShapeBox(0F, 0F, 0F, 12, 4, 10, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -7F, 0F, 0F, -7F, 0F, 0F, 0F, 0F, 0F); // Box 172
		bodyColoredPrimary[50].setRotationPoint(-84F, -15F, 21.5F);

		bodyColoredPrimary[51].addShapeBox(0F, 0F, 0F, 12, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -7F, 0F, 0F); // Box 173
		bodyColoredPrimary[51].setRotationPoint(-68F, -15F, 30.5F);

		bodyColoredPrimary[52].addShapeBox(0F, 0F, 0F, 5, 10, 10, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4.8F, 0F, 0F); // Box 174
		bodyColoredPrimary[52].setRotationPoint(-61F, -11F, 21.5F);

		bodyColoredPrimary[53].addBox(0F, 0F, 0F, 28, 11, 1, 0F); // Box 176
		bodyColoredPrimary[53].setRotationPoint(-84F, -26F, 30.5F);

		bodyColoredPrimary[54].addShapeBox(0F, 0F, 0F, 5, 10, 10, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4.8F, 0F, 0F, -4.8F, 0F, 0F, 0F, 0F, 0F); // Box 177
		bodyColoredPrimary[54].setRotationPoint(-84F, -11F, -31.5F);

		bodyColoredPrimary[55].addShapeBox(0F, 0F, 0F, 12, 4, 10, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -7F, 0F, 0F, -7F, 0F, 0F, 0F, 0F, 0F); // Box 178
		bodyColoredPrimary[55].setRotationPoint(-84F, -15F, -31.5F);

		bodyColoredPrimary[56].addShapeBox(0F, 0F, 0F, 5, 10, 10, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4.8F, 0F, 0F); // Box 181
		bodyColoredPrimary[56].setRotationPoint(-61F, -11F, -31.5F);

		bodyColoredPrimary[57].addBox(0F, 0F, 0F, 28, 11, 1, 0F); // Box 184
		bodyColoredPrimary[57].setRotationPoint(-84F, -26F, -31.5F);

		bodyColoredPrimary[58].addShapeBox(0F, 0F, 0F, 2, 2, 8, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F); // Box 185
		bodyColoredPrimary[58].setRotationPoint(-106F, -49F, -30.5F);

		bodyColoredPrimary[59].addShapeBox(0F, 0F, 0F, 2, 2, 8, 0F, 3F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 186
		bodyColoredPrimary[59].setRotationPoint(-106F, -49F, 22.5F);

		bodyColoredPrimary[60].addShapeBox(0F, 0F, 0F, 5, 2, 45, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 187
		bodyColoredPrimary[60].setRotationPoint(-109F, -49F, -22.5F);

		bodyColoredPrimary[61].addShapeBox(0F, 0F, 0F, 12, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -7F, 0F, 0F); // Box 195
		bodyColoredPrimary[61].setRotationPoint(-68F, -15F, -31.5F);

		bodyColoredPrimary[62].addBox(0F, 0F, 0F, 4, 9, 1, 0F); // Box 338
		bodyColoredPrimary[62].setRotationPoint(48F, -13F, -31.5F);

		bodyColoredPrimary[63].addBox(0F, 0F, 0F, 4, 9, 1, 0F); // Box 339
		bodyColoredPrimary[63].setRotationPoint(48F, -13F, 30.5F);

		bodyColoredPrimary[64].addBox(0F, 0F, 0F, 2, 22, 1, 0F); // Box 340
		bodyColoredPrimary[64].setRotationPoint(-56F, -26F, -31.5F);

		bodyColoredPrimary[65].addShapeBox(0F, 0F, 0F, 1, 21, 47, 0F, -2F, 0F, -1F, 2F, 0F, -1F, 2F, 0F, -1F, -2F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 343
		bodyColoredPrimary[65].setRotationPoint(-111F, -47F, -23.5F);

		bodyColoredPrimary[66].addBox(0F, 0F, 0F, 1, 27, 19, 0F); // Box 316
		bodyColoredPrimary[66].setRotationPoint(57.5F, -44F, 9F);

		bodyColoredPrimary[67].addBox(0F, 0F, 0F, 14, 27, 1, 0F); // Box 317
		bodyColoredPrimary[67].setRotationPoint(59F, -44F, 7.5F);

		chassis = new ModelRendererTurbo[6];
		chassis[0] = new ModelRendererTurbo(this, 657, 33, textureX, textureY); // Box 42
		chassis[1] = new ModelRendererTurbo(this, 953, 49, textureX, textureY); // Box 43
		chassis[2] = new ModelRendererTurbo(this, 689, 57, textureX, textureY); // Box 44
		chassis[3] = new ModelRendererTurbo(this, 745, 57, textureX, textureY); // Box 49
		chassis[4] = new ModelRendererTurbo(this, 953, 65, textureX, textureY); // Box 50
		chassis[5] = new ModelRendererTurbo(this, 689, 73, textureX, textureY); // Box 51
		chassis[0].addBox(0F, 0F, 0F, 24, 9, 1, 0F); // Box 42
		chassis[0].setRotationPoint(24F, -13F, 30.5F);
		chassis[1].addBox(0F, 0F, 0F, 24, 9, 1, 0F); // Box 43
		chassis[1].setRotationPoint(-5F, -13F, 30.5F);
		chassis[2].addBox(0F, 0F, 0F, 24, 9, 1, 0F); // Box 44
		chassis[2].setRotationPoint(-34F, -13F, 30.5F);
		chassis[3].addBox(0F, 0F, -1F, 24, 9, 1, 0F); // Box 49
		chassis[3].setRotationPoint(-34F, -13F, -30.5F);
		chassis[4].addBox(0F, 0F, -1F, 24, 9, 1, 0F); // Box 50
		chassis[4].setRotationPoint(-5F, -13F, -30.5F);
		chassis[5].addBox(0F, 0F, -1F, 24, 9, 1, 0F); // Box 51
		chassis[5].setRotationPoint(24F, -13F, -30.5F);
		translateAll(0F, 0F, 0F);
		flipAll();
	}
	
	@Override
	public void render(VehicleData data, @Nullable Entity entity, int meta){
		render(body);
		data.getPrimaryColor().glColorApply();
		render(bodyColoredPrimary);
		render(chassis);
		RGB.glColorReset();
		data.getSecondaryColor().glColorApply();
		render(bodyColoredSecondary);
		RGB.glColorReset();
	}
	
}