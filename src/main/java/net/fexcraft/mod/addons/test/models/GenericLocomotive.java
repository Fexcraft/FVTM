package net.fexcraft.mod.addons.test.models; //Path where the model is located

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.vehicle.VehicleModel;

public class GenericLocomotive extends VehicleModel {

	public GenericLocomotive(){
		this.textureX = this.textureY = 512;
		ModelRendererTurbo[] body = new ModelRendererTurbo[17];
		body[0] = new ModelRendererTurbo(this, 257, 41, textureX, textureY); // Box 115
		body[1] = new ModelRendererTurbo(this, 73, 33, textureX, textureY); // Box 116
		body[2] = new ModelRendererTurbo(this, 137, 49, textureX, textureY); // Box 117
		body[3] = new ModelRendererTurbo(this, 1, 105, textureX, textureY); // Box 118
		body[4] = new ModelRendererTurbo(this, 1, 153, textureX, textureY); // Box 119
		body[5] = new ModelRendererTurbo(this, 145, 153, textureX, textureY); // Box 120
		body[6] = new ModelRendererTurbo(this, 369, 113, textureX, textureY); // Box 121
		body[7] = new ModelRendererTurbo(this, 289, 153, textureX, textureY); // Box 122
		body[8] = new ModelRendererTurbo(this, 1, 209, textureX, textureY); // Box 123
		body[9] = new ModelRendererTurbo(this, 145, 209, textureX, textureY); // Box 124
		body[10] = new ModelRendererTurbo(this, 1, 33, textureX, textureY); // Box 125
		body[11] = new ModelRendererTurbo(this, 97, 33, textureX, textureY); // Box 126
		body[12] = new ModelRendererTurbo(this, 137, 33, textureX, textureY); // Box 127
		body[13] = new ModelRendererTurbo(this, 161, 33, textureX, textureY); // Box 128
		body[14] = new ModelRendererTurbo(this, 241, 225, textureX, textureY); // Box 129
		body[15] = new ModelRendererTurbo(this, 1, 89, textureX, textureY); // Box 130
		body[16] = new ModelRendererTurbo(this, 369, 97, textureX, textureY); // Box 131

		body[0].addBox(0F, 0F, 0F, 60, 8, 44, 0F); // Box 115
		body[0].setRotationPoint(-30F, -12F, -22F);

		body[1].addShapeBox(0F, 0F, 0F, 8, 8, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F); // Box 116
		body[1].setRotationPoint(-80F, -12F, -22F);

		body[2].addShapeBox(-10F, 0F, 0F, 10, 8, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F); // Box 117
		body[2].setRotationPoint(80F, -12F, -22F);

		body[3].addBox(0F, 0F, 0F, 160, 2, 44, 0F); // Box 118
		body[3].setRotationPoint(-80F, -14F, -22F);

		body[4].addShapeBox(0F, 0F, 0F, 40, 24, 30, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 7F, 0F, 0F, 7F, 0F, 0F, 7F, 2F, 0F, 7F); // Box 119
		body[4].setRotationPoint(-76F, -38F, -15F);

		body[5].addShapeBox(0F, 0F, 0F, 40, 24, 30, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 7F, 2F, 0F, 7F, 2F, 0F, 7F, 0F, 0F, 7F); // Box 120
		body[5].setRotationPoint(36F, -38F, -15F);

		body[6].addBox(0F, 0F, 0F, 4, 24, 44, 0F); // Box 121
		body[6].setRotationPoint(-36F, -38F, -22F);

		body[7].addBox(0F, 0F, 0F, 4, 24, 44, 0F); // Box 122
		body[7].setRotationPoint(32F, -38F, -22F);

		body[8].addBox(0F, 0F, 0F, 64, 24, 4, 0F); // Box 123
		body[8].setRotationPoint(-32F, -38F, -22F);

		body[9].addBox(0F, 0F, 0F, 64, 24, 4, 0F); // Box 124
		body[9].setRotationPoint(-32F, -38F, 18F);

		body[10].addBox(0F, 0F, 0F, 4, 12, 4, 0F); // Box 125
		body[10].setRotationPoint(-36F, -50F, -21F);

		body[11].addBox(0F, 0F, 0F, 4, 12, 4, 0F); // Box 126
		body[11].setRotationPoint(-36F, -50F, 17F);

		body[12].addBox(0F, 0F, 0F, 4, 12, 4, 0F); // Box 127
		body[12].setRotationPoint(32F, -50F, -21F);

		body[13].addBox(0F, 0F, 0F, 4, 12, 4, 0F); // Box 128
		body[13].setRotationPoint(32F, -50F, 17F);

		body[14].addBox(0F, 0F, 0F, 74, 1, 46, 0F); // Box 129
		body[14].setRotationPoint(-37F, -51F, -22F);

		body[15].addBox(0F, 0F, 0F, 48, 12, 2, 0F); // Box 130
		body[15].setRotationPoint(-24F, -50F, -21F);

		body[16].addBox(0F, 0F, 0F, 48, 12, 2, 0F); // Box 131
		body[16].setRotationPoint(-24F, -50F, 19F);
		this.add("body", body);


		/*steering = new ModelRendererTurbo[47];
		steering[0] = new ModelRendererTurbo(this, 137, 1, textureX, textureY); // Box 68
		steering[1] = new ModelRendererTurbo(this, 289, 1, textureX, textureY); // Box 69
		steering[2] = new ModelRendererTurbo(this, 33, 9, textureX, textureY); // Box 70
		steering[3] = new ModelRendererTurbo(this, 49, 9, textureX, textureY); // Box 71
		steering[4] = new ModelRendererTurbo(this, 65, 9, textureX, textureY); // Box 72
		steering[5] = new ModelRendererTurbo(this, 73, 9, textureX, textureY); // Box 73
		steering[6] = new ModelRendererTurbo(this, 81, 9, textureX, textureY); // Box 74
		steering[7] = new ModelRendererTurbo(this, 337, 9, textureX, textureY); // Box 75
		steering[8] = new ModelRendererTurbo(this, 345, 9, textureX, textureY); // Box 76
		steering[9] = new ModelRendererTurbo(this, 353, 9, textureX, textureY); // Box 77
		steering[10] = new ModelRendererTurbo(this, 361, 9, textureX, textureY); // Box 78
		steering[11] = new ModelRendererTurbo(this, 385, 9, textureX, textureY); // Box 79
		steering[12] = new ModelRendererTurbo(this, 401, 9, textureX, textureY); // Box 80
		steering[13] = new ModelRendererTurbo(this, 473, 9, textureX, textureY); // Box 81
		steering[14] = new ModelRendererTurbo(this, 417, 17, textureX, textureY); // Box 82
		steering[15] = new ModelRendererTurbo(this, 441, 17, textureX, textureY); // Box 83
		steering[16] = new ModelRendererTurbo(this, 409, 9, textureX, textureY); // Box 84
		steering[17] = new ModelRendererTurbo(this, 441, 9, textureX, textureY); // Box 85
		steering[18] = new ModelRendererTurbo(this, 505, 9, textureX, textureY); // Box 86
		steering[19] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 87
		steering[20] = new ModelRendererTurbo(this, 9, 17, textureX, textureY); // Box 88
		steering[21] = new ModelRendererTurbo(this, 33, 17, textureX, textureY); // Box 89
		steering[22] = new ModelRendererTurbo(this, 17, 17, textureX, textureY); // Box 90
		steering[23] = new ModelRendererTurbo(this, 49, 17, textureX, textureY); // Box 91
		steering[24] = new ModelRendererTurbo(this, 457, 17, textureX, textureY); // Box 92
		steering[25] = new ModelRendererTurbo(this, 489, 17, textureX, textureY); // Box 93
		steering[26] = new ModelRendererTurbo(this, 353, 25, textureX, textureY); // Box 94
		steering[27] = new ModelRendererTurbo(this, 57, 17, textureX, textureY); // Box 95
		steering[28] = new ModelRendererTurbo(this, 73, 17, textureX, textureY); // Box 96
		steering[29] = new ModelRendererTurbo(this, 81, 17, textureX, textureY); // Box 97
		steering[30] = new ModelRendererTurbo(this, 97, 17, textureX, textureY); // Box 98
		steering[31] = new ModelRendererTurbo(this, 105, 17, textureX, textureY); // Box 99
		steering[32] = new ModelRendererTurbo(this, 113, 17, textureX, textureY); // Box 100
		steering[33] = new ModelRendererTurbo(this, 129, 17, textureX, textureY); // Box 101
		steering[34] = new ModelRendererTurbo(this, 137, 17, textureX, textureY); // Box 102
		steering[35] = new ModelRendererTurbo(this, 145, 17, textureX, textureY); // Box 103
		steering[36] = new ModelRendererTurbo(this, 153, 17, textureX, textureY); // Box 104
		steering[37] = new ModelRendererTurbo(this, 369, 25, textureX, textureY); // Box 105
		steering[38] = new ModelRendererTurbo(this, 169, 17, textureX, textureY); // Box 106
		steering[39] = new ModelRendererTurbo(this, 385, 25, textureX, textureY); // Box 107
		steering[40] = new ModelRendererTurbo(this, 177, 17, textureX, textureY); // Box 108
		steering[41] = new ModelRendererTurbo(this, 193, 17, textureX, textureY); // Box 109
		steering[42] = new ModelRendererTurbo(this, 473, 25, textureX, textureY); // Box 110
		steering[43] = new ModelRendererTurbo(this, 201, 17, textureX, textureY); // Box 111
		steering[44] = new ModelRendererTurbo(this, 281, 17, textureX, textureY); // Box 112
		steering[45] = new ModelRendererTurbo(this, 289, 17, textureX, textureY); // Box 113
		steering[46] = new ModelRendererTurbo(this, 1, 33, textureX, textureY); // Box 114

		steering[0].addBox(0F, 0F, 0F, 1, 1, 28, 0F); // Box 68
		steering[0].setRotationPoint(59F, -5F, -14F);

		steering[1].addBox(0F, 0F, 0F, 1, 1, 28, 0F); // Box 69
		steering[1].setRotationPoint(43F, -5F, -14F);

		steering[2].addBox(0F, 0F, 0F, 5, 1, 1, 0F); // Box 70
		steering[2].setRotationPoint(41F, -10F, -15F);

		steering[3].addBox(0F, 0F, 0F, 5, 1, 1, 0F); // Box 71
		steering[3].setRotationPoint(41F, 0F, -15F);

		steering[4].addBox(0F, 0F, 0F, 1, 5, 1, 0F); // Box 72
		steering[4].setRotationPoint(38F, -7F, -15F);

		steering[5].addBox(0F, 0F, 0F, 1, 5, 1, 0F); // Box 73
		steering[5].setRotationPoint(48F, -7F, -15F);

		steering[6].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, -1F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 2F, -1F, 0F); // Box 74
		steering[6].setRotationPoint(48F, -2F, -15F);

		steering[7].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 2F, -1F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 2F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 75
		steering[7].setRotationPoint(48F, -10F, -15F);

		steering[8].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, -3F, 0F, 0F, 2F, -1F, 0F, 2F, -1F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 76
		steering[8].setRotationPoint(38F, -10F, -15F);

		steering[9].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 2F, -1F, 0F, 2F, -1F, 0F, -3F, 0F, 0F); // Box 77
		steering[9].setRotationPoint(38F, -2F, -15F);

		steering[10].addBox(0F, 0F, 0F, 5, 9, 3, 0F); // Box 78
		steering[10].setRotationPoint(41F, -9F, -17F);

		steering[11].addShapeBox(0F, 0F, 0F, 2, 9, 3, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 79
		steering[11].setRotationPoint(39F, -9F, -17F);

		steering[12].addShapeBox(0F, 0F, 0F, 2, 9, 3, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F); // Box 80
		steering[12].setRotationPoint(46F, -9F, -17F);

		steering[13].addShapeBox(0F, 0F, 0F, 2, 9, 3, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 81
		steering[13].setRotationPoint(55F, -9F, -17F);

		steering[14].addBox(0F, 0F, 0F, 5, 9, 3, 0F); // Box 82
		steering[14].setRotationPoint(57F, -9F, -17F);

		steering[15].addShapeBox(0F, 0F, 0F, 2, 9, 3, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F); // Box 83
		steering[15].setRotationPoint(62F, -9F, -17F);

		steering[16].addBox(0F, 0F, 0F, 5, 1, 1, 0F); // Box 84
		steering[16].setRotationPoint(57F, -10F, -15F);

		steering[17].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 2F, -1F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 2F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 85
		steering[17].setRotationPoint(64F, -10F, -15F);

		steering[18].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, -3F, 0F, 0F, 2F, -1F, 0F, 2F, -1F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 86
		steering[18].setRotationPoint(54F, -10F, -15F);

		steering[19].addBox(0F, 0F, 0F, 1, 5, 1, 0F); // Box 87
		steering[19].setRotationPoint(54F, -7F, -15F);

		steering[20].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 2F, -1F, 0F, 2F, -1F, 0F, -3F, 0F, 0F); // Box 88
		steering[20].setRotationPoint(54F, -2F, -15F);

		steering[21].addBox(0F, 0F, 0F, 5, 1, 1, 0F); // Box 89
		steering[21].setRotationPoint(57F, 0F, -15F);

		steering[22].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, -1F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 2F, -1F, 0F); // Box 90
		steering[22].setRotationPoint(64F, -2F, -15F);

		steering[23].addBox(0F, 0F, 0F, 1, 5, 1, 0F); // Box 91
		steering[23].setRotationPoint(64F, -7F, -15F);

		steering[24].addShapeBox(0F, 0F, 0F, 2, 9, 3, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 92
		steering[24].setRotationPoint(55F, -9F, 14F);

		steering[25].addBox(0F, 0F, 0F, 5, 9, 3, 0F); // Box 93
		steering[25].setRotationPoint(57F, -9F, 14F);

		steering[26].addShapeBox(0F, 0F, 0F, 2, 9, 3, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F); // Box 94
		steering[26].setRotationPoint(62F, -9F, 14F);

		steering[27].addBox(0F, 0F, 0F, 5, 1, 1, 0F); // Box 95
		steering[27].setRotationPoint(57F, -10F, 14F);

		steering[28].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 2F, -1F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 2F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 96
		steering[28].setRotationPoint(64F, -10F, 14F);

		steering[29].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, -3F, 0F, 0F, 2F, -1F, 0F, 2F, -1F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 97
		steering[29].setRotationPoint(54F, -10F, 14F);

		steering[30].addBox(0F, 0F, 0F, 1, 5, 1, 0F); // Box 98
		steering[30].setRotationPoint(54F, -7F, 14F);

		steering[31].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 2F, -1F, 0F, 2F, -1F, 0F, -3F, 0F, 0F); // Box 99
		steering[31].setRotationPoint(54F, -2F, 14F);

		steering[32].addBox(0F, 0F, 0F, 5, 1, 1, 0F); // Box 100
		steering[32].setRotationPoint(57F, 0F, 14F);

		steering[33].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, -1F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 2F, -1F, 0F); // Box 101
		steering[33].setRotationPoint(64F, -2F, 14F);

		steering[34].addBox(0F, 0F, 0F, 1, 5, 1, 0F); // Box 102
		steering[34].setRotationPoint(64F, -7F, 14F);

		steering[35].addBox(0F, 0F, 0F, 1, 5, 1, 0F); // Box 103
		steering[35].setRotationPoint(38F, -7F, 14F);

		steering[36].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, -3F, 0F, 0F, 2F, -1F, 0F, 2F, -1F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 104
		steering[36].setRotationPoint(38F, -10F, 14F);

		steering[37].addShapeBox(0F, 0F, 0F, 2, 9, 3, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 105
		steering[37].setRotationPoint(39F, -9F, 14F);

		steering[38].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 2F, -1F, 0F, 2F, -1F, 0F, -3F, 0F, 0F); // Box 106
		steering[38].setRotationPoint(38F, -2F, 14F);

		steering[39].addBox(0F, 0F, 0F, 5, 9, 3, 0F); // Box 107
		steering[39].setRotationPoint(41F, -9F, 14F);

		steering[40].addBox(0F, 0F, 0F, 5, 1, 1, 0F); // Box 108
		steering[40].setRotationPoint(41F, 0F, 14F);

		steering[41].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, -1F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 2F, -1F, 0F); // Box 109
		steering[41].setRotationPoint(48F, -2F, 14F);

		steering[42].addShapeBox(0F, 0F, 0F, 2, 9, 3, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F); // Box 110
		steering[42].setRotationPoint(46F, -9F, 14F);

		steering[43].addBox(0F, 0F, 0F, 1, 5, 1, 0F); // Box 111
		steering[43].setRotationPoint(48F, -7F, 14F);

		steering[44].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 2F, -1F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 2F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 112
		steering[44].setRotationPoint(48F, -10F, 14F);

		steering[45].addBox(0F, 0F, 0F, 5, 1, 1, 0F); // Box 113
		steering[45].setRotationPoint(41F, -10F, 14F);

		steering[46].addBox(-15.5F, 0F, 0F, 31, 9, 26, 0F); // Box 114
		steering[46].setRotationPoint(51.5F, -12F, -13F);


		turret = new ModelRendererTurbo[47];
		turret[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
		turret[1] = new ModelRendererTurbo(this, 65, 1, textureX, textureY); // Box 1
		turret[2] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 23
		turret[3] = new ModelRendererTurbo(this, 33, 1, textureX, textureY); // Box 24
		turret[4] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 25
		turret[5] = new ModelRendererTurbo(this, 49, 1, textureX, textureY); // Box 26
		turret[6] = new ModelRendererTurbo(this, 57, 1, textureX, textureY); // Box 27
		turret[7] = new ModelRendererTurbo(this, 65, 1, textureX, textureY); // Box 28
		turret[8] = new ModelRendererTurbo(this, 73, 1, textureX, textureY); // Box 29
		turret[9] = new ModelRendererTurbo(this, 81, 1, textureX, textureY); // Box 30
		turret[10] = new ModelRendererTurbo(this, 97, 1, textureX, textureY); // Box 31
		turret[11] = new ModelRendererTurbo(this, 121, 1, textureX, textureY); // Box 32
		turret[12] = new ModelRendererTurbo(this, 137, 1, textureX, textureY); // Box 33
		turret[13] = new ModelRendererTurbo(this, 153, 1, textureX, textureY); // Box 34
		turret[14] = new ModelRendererTurbo(this, 169, 1, textureX, textureY); // Box 35
		turret[15] = new ModelRendererTurbo(this, 193, 1, textureX, textureY); // Box 36
		turret[16] = new ModelRendererTurbo(this, 201, 1, textureX, textureY); // Box 37
		turret[17] = new ModelRendererTurbo(this, 217, 1, textureX, textureY); // Box 38
		turret[18] = new ModelRendererTurbo(this, 225, 1, textureX, textureY); // Box 39
		turret[19] = new ModelRendererTurbo(this, 233, 1, textureX, textureY); // Box 40
		turret[20] = new ModelRendererTurbo(this, 241, 1, textureX, textureY); // Box 41
		turret[21] = new ModelRendererTurbo(this, 249, 1, textureX, textureY); // Box 42
		turret[22] = new ModelRendererTurbo(this, 265, 1, textureX, textureY); // Box 43
		turret[23] = new ModelRendererTurbo(this, 273, 1, textureX, textureY); // Box 44
		turret[24] = new ModelRendererTurbo(this, 281, 1, textureX, textureY); // Box 45
		turret[25] = new ModelRendererTurbo(this, 297, 1, textureX, textureY); // Box 46
		turret[26] = new ModelRendererTurbo(this, 321, 1, textureX, textureY); // Box 47
		turret[27] = new ModelRendererTurbo(this, 329, 1, textureX, textureY); // Box 48
		turret[28] = new ModelRendererTurbo(this, 345, 1, textureX, textureY); // Box 49
		turret[29] = new ModelRendererTurbo(this, 353, 1, textureX, textureY); // Box 50
		turret[30] = new ModelRendererTurbo(this, 361, 1, textureX, textureY); // Box 51
		turret[31] = new ModelRendererTurbo(this, 369, 1, textureX, textureY); // Box 52
		turret[32] = new ModelRendererTurbo(this, 377, 1, textureX, textureY); // Box 53
		turret[33] = new ModelRendererTurbo(this, 393, 1, textureX, textureY); // Box 54
		turret[34] = new ModelRendererTurbo(this, 401, 1, textureX, textureY); // Box 55
		turret[35] = new ModelRendererTurbo(this, 409, 1, textureX, textureY); // Box 56
		turret[36] = new ModelRendererTurbo(this, 417, 1, textureX, textureY); // Box 57
		turret[37] = new ModelRendererTurbo(this, 425, 1, textureX, textureY); // Box 58
		turret[38] = new ModelRendererTurbo(this, 441, 1, textureX, textureY); // Box 59
		turret[39] = new ModelRendererTurbo(this, 449, 1, textureX, textureY); // Box 60
		turret[40] = new ModelRendererTurbo(this, 465, 1, textureX, textureY); // Box 61
		turret[41] = new ModelRendererTurbo(this, 481, 1, textureX, textureY); // Box 62
		turret[42] = new ModelRendererTurbo(this, 489, 1, textureX, textureY); // Box 63
		turret[43] = new ModelRendererTurbo(this, 505, 1, textureX, textureY); // Box 64
		turret[44] = new ModelRendererTurbo(this, 1, 9, textureX, textureY); // Box 65
		turret[45] = new ModelRendererTurbo(this, 9, 9, textureX, textureY); // Box 66
		turret[46] = new ModelRendererTurbo(this, 185, 9, textureX, textureY); // Box 67

		turret[0].addBox(0F, 0F, 0F, 1, 1, 28, 0F); // Box 0
		turret[0].setRotationPoint(-44F, -5F, -14F);

		turret[1].addBox(0F, 0F, 0F, 1, 1, 28, 0F); // Box 1
		turret[1].setRotationPoint(-60F, -5F, -14F);

		turret[2].addBox(0F, 0F, 0F, 5, 1, 1, 0F); // Box 23
		turret[2].setRotationPoint(-62F, -10F, -15F);

		turret[3].addBox(0F, 0F, 0F, 5, 1, 1, 0F); // Box 24
		turret[3].setRotationPoint(-62F, 0F, -15F);

		turret[4].addBox(0F, 0F, 0F, 1, 5, 1, 0F); // Box 25
		turret[4].setRotationPoint(-65F, -7F, -15F);

		turret[5].addBox(0F, 0F, 0F, 1, 5, 1, 0F); // Box 26
		turret[5].setRotationPoint(-55F, -7F, -15F);

		turret[6].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, -1F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 2F, -1F, 0F); // Box 27
		turret[6].setRotationPoint(-55F, -2F, -15F);

		turret[7].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 2F, -1F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 2F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 28
		turret[7].setRotationPoint(-55F, -10F, -15F);

		turret[8].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, -3F, 0F, 0F, 2F, -1F, 0F, 2F, -1F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 29
		turret[8].setRotationPoint(-65F, -10F, -15F);

		turret[9].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 2F, -1F, 0F, 2F, -1F, 0F, -3F, 0F, 0F); // Box 30
		turret[9].setRotationPoint(-65F, -2F, -15F);

		turret[10].addBox(0F, 0F, 0F, 5, 9, 3, 0F); // Box 31
		turret[10].setRotationPoint(-62F, -9F, -17F);

		turret[11].addShapeBox(0F, 0F, 0F, 2, 9, 3, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 32
		turret[11].setRotationPoint(-64F, -9F, -17F);

		turret[12].addShapeBox(0F, 0F, 0F, 2, 9, 3, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F); // Box 33
		turret[12].setRotationPoint(-57F, -9F, -17F);

		turret[13].addShapeBox(0F, 0F, 0F, 2, 9, 3, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 34
		turret[13].setRotationPoint(-48F, -9F, -17F);

		turret[14].addBox(0F, 0F, 0F, 5, 9, 3, 0F); // Box 35
		turret[14].setRotationPoint(-46F, -9F, -17F);

		turret[15].addShapeBox(0F, 0F, 0F, 2, 9, 3, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F); // Box 36
		turret[15].setRotationPoint(-41F, -9F, -17F);

		turret[16].addBox(0F, 0F, 0F, 5, 1, 1, 0F); // Box 37
		turret[16].setRotationPoint(-46F, -10F, -15F);

		turret[17].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 2F, -1F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 2F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 38
		turret[17].setRotationPoint(-39F, -10F, -15F);

		turret[18].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, -3F, 0F, 0F, 2F, -1F, 0F, 2F, -1F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 39
		turret[18].setRotationPoint(-49F, -10F, -15F);

		turret[19].addBox(0F, 0F, 0F, 1, 5, 1, 0F); // Box 40
		turret[19].setRotationPoint(-49F, -7F, -15F);

		turret[20].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 2F, -1F, 0F, 2F, -1F, 0F, -3F, 0F, 0F); // Box 41
		turret[20].setRotationPoint(-49F, -2F, -15F);

		turret[21].addBox(0F, 0F, 0F, 5, 1, 1, 0F); // Box 42
		turret[21].setRotationPoint(-46F, 0F, -15F);

		turret[22].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, -1F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 2F, -1F, 0F); // Box 43
		turret[22].setRotationPoint(-39F, -2F, -15F);

		turret[23].addBox(0F, 0F, 0F, 1, 5, 1, 0F); // Box 44
		turret[23].setRotationPoint(-39F, -7F, -15F);

		turret[24].addShapeBox(0F, 0F, 0F, 2, 9, 3, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 45
		turret[24].setRotationPoint(-48F, -9F, 14F);

		turret[25].addBox(0F, 0F, 0F, 5, 9, 3, 0F); // Box 46
		turret[25].setRotationPoint(-46F, -9F, 14F);

		turret[26].addShapeBox(0F, 0F, 0F, 2, 9, 3, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F); // Box 47
		turret[26].setRotationPoint(-41F, -9F, 14F);

		turret[27].addBox(0F, 0F, 0F, 5, 1, 1, 0F); // Box 48
		turret[27].setRotationPoint(-46F, -10F, 14F);

		turret[28].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 2F, -1F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 2F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 49
		turret[28].setRotationPoint(-39F, -10F, 14F);

		turret[29].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, -3F, 0F, 0F, 2F, -1F, 0F, 2F, -1F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 50
		turret[29].setRotationPoint(-49F, -10F, 14F);

		turret[30].addBox(0F, 0F, 0F, 1, 5, 1, 0F); // Box 51
		turret[30].setRotationPoint(-49F, -7F, 14F);

		turret[31].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 2F, -1F, 0F, 2F, -1F, 0F, -3F, 0F, 0F); // Box 52
		turret[31].setRotationPoint(-49F, -2F, 14F);

		turret[32].addBox(0F, 0F, 0F, 5, 1, 1, 0F); // Box 53
		turret[32].setRotationPoint(-46F, 0F, 14F);

		turret[33].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, -1F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 2F, -1F, 0F); // Box 54
		turret[33].setRotationPoint(-39F, -2F, 14F);

		turret[34].addBox(0F, 0F, 0F, 1, 5, 1, 0F); // Box 55
		turret[34].setRotationPoint(-39F, -7F, 14F);

		turret[35].addBox(0F, 0F, 0F, 1, 5, 1, 0F); // Box 56
		turret[35].setRotationPoint(-65F, -7F, 14F);

		turret[36].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, -3F, 0F, 0F, 2F, -1F, 0F, 2F, -1F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 57
		turret[36].setRotationPoint(-65F, -10F, 14F);

		turret[37].addShapeBox(0F, 0F, 0F, 2, 9, 3, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 58
		turret[37].setRotationPoint(-64F, -9F, 14F);

		turret[38].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 2F, -1F, 0F, 2F, -1F, 0F, -3F, 0F, 0F); // Box 59
		turret[38].setRotationPoint(-65F, -2F, 14F);

		turret[39].addBox(0F, 0F, 0F, 5, 9, 3, 0F); // Box 60
		turret[39].setRotationPoint(-62F, -9F, 14F);

		turret[40].addBox(0F, 0F, 0F, 5, 1, 1, 0F); // Box 61
		turret[40].setRotationPoint(-62F, 0F, 14F);

		turret[41].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, -1F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 2F, -1F, 0F); // Box 62
		turret[41].setRotationPoint(-55F, -2F, 14F);

		turret[42].addShapeBox(0F, 0F, 0F, 2, 9, 3, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F); // Box 63
		turret[42].setRotationPoint(-57F, -9F, 14F);

		turret[43].addBox(0F, 0F, 0F, 1, 5, 1, 0F); // Box 64
		turret[43].setRotationPoint(-55F, -7F, 14F);

		turret[44].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 2F, -1F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 2F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 65
		turret[44].setRotationPoint(-55F, -10F, 14F);

		turret[45].addBox(0F, 0F, 0F, 5, 1, 1, 0F); // Box 66
		turret[45].setRotationPoint(-62F, -10F, 14F);

		turret[46].addBox(-15.5F, 0F, 0F, 31, 9, 26, 0F); // Box 67
		turret[46].setRotationPoint(-51.5F, -12F, -13F);*/

		translateAll(0F, 0F, 0F);
		flipAll();
	}
	
}