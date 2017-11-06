//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2017 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: T1_Type2
// Model Creator: FEX___96
// Created on: 13.03.2017 - 19:28:44
// Last changed on: 13.03.2017 - 19:28:44

package net.fexcraft.mod.addons.fvp.models.part;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.part.PartModel;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelT1_4 extends PartModel<VehicleData> {
	
	int textureX = 512;
	int textureY = 512;

	public ModelT1_4(){
		this.creators.add("Ferdinand (FEX___96)");
		//
		body = new ModelRendererTurbo[66];
		body[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
		body[1] = new ModelRendererTurbo(this, 97, 1, textureX, textureY); // Box 1
		body[2] = new ModelRendererTurbo(this, 193, 1, textureX, textureY); // Box 2
		body[3] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 40
		body[4] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 41
		body[5] = new ModelRendererTurbo(this, 57, 1, textureX, textureY); // Box 42
		body[6] = new ModelRendererTurbo(this, 73, 1, textureX, textureY); // Box 43
		body[7] = new ModelRendererTurbo(this, 97, 1, textureX, textureY); // Box 44
		body[8] = new ModelRendererTurbo(this, 113, 1, textureX, textureY); // Box 45
		body[9] = new ModelRendererTurbo(this, 9, 1, textureX, textureY); // Box 46
		body[10] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 47
		body[11] = new ModelRendererTurbo(this, 33, 1, textureX, textureY); // Box 48
		body[12] = new ModelRendererTurbo(this, 65, 1, textureX, textureY); // Box 49
		body[13] = new ModelRendererTurbo(this, 105, 1, textureX, textureY); // Box 50
		body[14] = new ModelRendererTurbo(this, 121, 1, textureX, textureY); // Box 51
		body[15] = new ModelRendererTurbo(this, 129, 1, textureX, textureY); // Box 52
		body[16] = new ModelRendererTurbo(this, 153, 1, textureX, textureY); // Box 53
		body[17] = new ModelRendererTurbo(this, 161, 1, textureX, textureY); // Box 54
		body[18] = new ModelRendererTurbo(this, 161, 1, textureX, textureY); // Box 55
		body[19] = new ModelRendererTurbo(this, 193, 1, textureX, textureY); // Box 56
		body[20] = new ModelRendererTurbo(this, 217, 1, textureX, textureY); // Box 57
		body[21] = new ModelRendererTurbo(this, 25, 9, textureX, textureY); // Box 58
		body[22] = new ModelRendererTurbo(this, 177, 1, textureX, textureY); // Box 59
		body[23] = new ModelRendererTurbo(this, 193, 1, textureX, textureY); // Box 60
		body[24] = new ModelRendererTurbo(this, 57, 17, textureX, textureY); // Box 61
		body[25] = new ModelRendererTurbo(this, 97, 17, textureX, textureY); // Box 62
		body[26] = new ModelRendererTurbo(this, 209, 1, textureX, textureY); // Box 63
		body[27] = new ModelRendererTurbo(this, 217, 1, textureX, textureY); // Box 64
		body[28] = new ModelRendererTurbo(this, 249, 1, textureX, textureY); // Box 65
		body[29] = new ModelRendererTurbo(this, 497, 1, textureX, textureY); // Box 66
		body[30] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 67
		body[31] = new ModelRendererTurbo(this, 505, 1, textureX, textureY); // Box 68
		body[32] = new ModelRendererTurbo(this, 177, 9, textureX, textureY); // Box 69
		body[33] = new ModelRendererTurbo(this, 153, 17, textureX, textureY); // Box 70
		body[34] = new ModelRendererTurbo(this, 1, 73, textureX, textureY); // Box 71
		body[35] = new ModelRendererTurbo(this, 49, 73, textureX, textureY); // Box 72
		body[36] = new ModelRendererTurbo(this, 225, 177, textureX, textureY); // Box 73
		body[37] = new ModelRendererTurbo(this, 209, 9, textureX, textureY); // Box 74
		body[38] = new ModelRendererTurbo(this, 121, 17, textureX, textureY); // Box 75
		body[39] = new ModelRendererTurbo(this, 497, 9, textureX, textureY); // Box 76
		body[40] = new ModelRendererTurbo(this, 169, 17, textureX, textureY); // Box 77
		body[41] = new ModelRendererTurbo(this, 129, 201, textureX, textureY); // Box 78
		body[42] = new ModelRendererTurbo(this, 281, 209, textureX, textureY); // Box 79
		body[43] = new ModelRendererTurbo(this, 193, 17, textureX, textureY); // Box 80
		body[44] = new ModelRendererTurbo(this, 489, 33, textureX, textureY); // Box 81
		body[45] = new ModelRendererTurbo(this, 1, 217, textureX, textureY); // Box 82
		body[46] = new ModelRendererTurbo(this, 137, 217, textureX, textureY); // Box 83
		body[47] = new ModelRendererTurbo(this, 481, 57, textureX, textureY); // Box 84
		body[48] = new ModelRendererTurbo(this, 481, 97, textureX, textureY); // Box 85
		body[49] = new ModelRendererTurbo(this, 481, 113, textureX, textureY); // Box 86
		body[50] = new ModelRendererTurbo(this, 273, 225, textureX, textureY); // Box 89
		body[51] = new ModelRendererTurbo(this, 1, 233, textureX, textureY); // Box 90
		body[52] = new ModelRendererTurbo(this, 1, 129, textureX, textureY); // Box 91
		body[53] = new ModelRendererTurbo(this, 153, 241, textureX, textureY); // Box 92
		body[54] = new ModelRendererTurbo(this, 49, 129, textureX, textureY); // Box 93
		body[55] = new ModelRendererTurbo(this, 89, 129, textureX, textureY); // Box 94
		body[56] = new ModelRendererTurbo(this, 113, 129, textureX, textureY); // Box 95
		body[57] = new ModelRendererTurbo(this, 145, 129, textureX, textureY); // Box 96
		body[58] = new ModelRendererTurbo(this, 313, 241, textureX, textureY); // Box 97
		body[59] = new ModelRendererTurbo(this, 345, 137, textureX, textureY); // Box 98
		body[60] = new ModelRendererTurbo(this, 217, 17, textureX, textureY); // Box 99
		body[61] = new ModelRendererTurbo(this, 225, 17, textureX, textureY); // Box 100
		body[62] = new ModelRendererTurbo(this, 209, 1, textureX, textureY); // Box 101
		body[63] = new ModelRendererTurbo(this, 9, 9, textureX, textureY); // Box 102
		body[64] = new ModelRendererTurbo(this, 1, 185, textureX, textureY); // Box 103
		body[65] = new ModelRendererTurbo(this, 369, 137, textureX, textureY); // Box 104

		body[0].addShapeBox(0F, 0F, 0F, 4, 4, 42, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 0
		body[0].setRotationPoint(9F, -16F, -21F);

		body[1].addShapeBox(0F, 0F, 0F, 4, 4, 42, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 1
		body[1].setRotationPoint(-93F, -16F, -21F);

		body[2].addShapeBox(0F, 0F, 0F, 4, 4, 42, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 2
		body[2].setRotationPoint(-42F, -16F, -21F);

		body[3].addShapeBox(0F, 0F, 0F, 2, 7, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, -3F, 0F, 0F, -3F); // Box 40
		body[3].setRotationPoint(-92F, -20F, -17F);

		body[4].addShapeBox(0F, 0F, 0F, 2, 7, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, -3F, 0F, 0F, -3F); // Box 41
		body[4].setRotationPoint(-41F, -20F, -17F);

		body[5].addShapeBox(0F, 0F, 0F, 2, 7, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, -3F, 0F, 0F, -3F); // Box 42
		body[5].setRotationPoint(10F, -20F, -17F);

		body[6].addShapeBox(0F, 0F, 0F, 2, 7, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 3F, 0F, 0F, 3F); // Box 43
		body[6].setRotationPoint(-92F, -20F, 14F);

		body[7].addShapeBox(0F, 0F, 0F, 2, 7, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 3F, 0F, 0F, 3F); // Box 44
		body[7].setRotationPoint(-41F, -20F, 14F);

		body[8].addShapeBox(0F, 0F, 0F, 2, 7, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 3F, 0F, 0F, 3F); // Box 45
		body[8].setRotationPoint(10F, -20F, 14F);

		body[9].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 46
		body[9].setRotationPoint(-101F, -20F, -6F);

		body[10].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 47
		body[10].setRotationPoint(-101F, -20F, -12F);

		body[11].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 48
		body[11].setRotationPoint(-101F, -28F, -12F);

		body[12].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 49
		body[12].setRotationPoint(-101F, -28F, -6F);

		body[13].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 50
		body[13].setRotationPoint(-101F, -36F, -12F);

		body[14].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 51
		body[14].setRotationPoint(-101F, -36F, -6F);

		body[15].addShapeBox(0F, 0F, 0F, 1, 9, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 52
		body[15].setRotationPoint(-101F, -50F, -12F);

		body[16].addShapeBox(0F, 0F, 0F, 1, 9, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 53
		body[16].setRotationPoint(-101F, -50F, -6F);

		body[17].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.25F, 0F, 0F, 0.25F, 0F, 0F, 0.25F, -0.5F, 0F, 0.25F, -0.5F, 0F); // Box 54
		body[17].setRotationPoint(-90F, -49F, -12F);

		body[18].addShapeBox(0F, 0F, 0F, 1, 1, 7, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F); // Box 55
		body[18].setRotationPoint(-102F, -20F, -12F);

		body[19].addShapeBox(0F, 0F, 0F, 1, 1, 7, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F); // Box 56
		body[19].setRotationPoint(-102F, -28F, -12F);

		body[20].addShapeBox(0F, 0F, 0F, 1, 1, 7, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F); // Box 57
		body[20].setRotationPoint(-102F, -36F, -12F);

		body[21].addShapeBox(0F, 0F, 0F, 1, 1, 7, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F); // Box 58
		body[21].setRotationPoint(-102F, -44F, -12F);

		body[22].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 59
		body[22].setRotationPoint(-90F, -50F, -6F);

		body[23].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 60
		body[23].setRotationPoint(-90F, -50F, -12F);

		body[24].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 61
		body[24].setRotationPoint(-101F, -51F, -12F);

		body[25].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 62
		body[25].setRotationPoint(-101F, -51F, -6F);

		body[26].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 63
		body[26].setRotationPoint(-101F, -20F, 11F);

		body[27].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 64
		body[27].setRotationPoint(-101F, -20F, 6F);

		body[28].addBox(0F, 0F, 0F, 1, 5, 1, 0F); // Box 65
		body[28].setRotationPoint(-101F, -29F, 6F);

		body[29].addBox(0F, 0F, 0F, 1, 5, 1, 0F); // Box 66
		body[29].setRotationPoint(-101F, -29F, 11F);

		body[30].addShapeBox(0F, 0F, 0F, 1, 8, 8, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F); // Box 67
		body[30].setRotationPoint(-102F, -26F, 5F);

		body[31].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 68
		body[31].setRotationPoint(-101F, -34F, 11F);

		body[32].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 69
		body[32].setRotationPoint(-101F, -34F, 6F);

		body[33].addShapeBox(0F, 0F, 0F, 1, 8, 8, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F); // Box 70
		body[33].setRotationPoint(-102F, -35F, 5F);

		body[34].addShapeBox(0F, 0F, 0F, 18, 3, 4, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 71
		body[34].setRotationPoint(-11F, -49.5F, -10F);

		body[35].addShapeBox(0F, 0F, 0F, 18, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 72
		body[35].setRotationPoint(-11F, -49.5F, 6F);

		body[36].addShapeBox(0F, 0F, 0F, 14, 2, 14, 0F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 73
		body[36].setRotationPoint(-9F, -51F, -7F);

		body[37].addBox(0F, 0F, 0F, 2, 1, 2, 0F); // Box 74
		body[37].setRotationPoint(-3F, -52F, -1F);

		body[38].addBox(0F, 0F, 0F, 5, 1, 3, 0F); // Box 75
		body[38].setRotationPoint(-4.5F, -52.5F, -1.5F);

		body[39].addShapeBox(0F, 0F, 0F, 5, 1, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 76
		body[39].setRotationPoint(-4.5F, -52.5F, -2.5F);

		body[40].addShapeBox(0F, 0F, 0F, 5, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 77
		body[40].setRotationPoint(-4.5F, -52.5F, 1.5F);

		body[41].addBox(0F, 0F, 0F, 68, 1, 8, 0F); // Box 78
		body[41].setRotationPoint(-53F, -11F, 13F);

		body[42].addBox(0F, 0F, 0F, 68, 1, 8, 0F); // Box 79
		body[42].setRotationPoint(-53F, -2F, 13F);

		body[43].addBox(0F, 0F, 0F, 1, 8, 8, 0F); // Box 80
		body[43].setRotationPoint(-53F, -10F, 13F);

		body[44].addBox(0F, 0F, 0F, 1, 8, 8, 0F); // Box 81
		body[44].setRotationPoint(14F, -10F, 13F);

		body[45].addBox(0F, 0F, 0F, 66, 8, 1, 0F); // Box 82
		body[45].setRotationPoint(-52F, -10F, 13F);

		body[46].addBox(0F, 0F, 0F, 66, 8, 1, 0F); // Box 83
		body[46].setRotationPoint(-52F, -10F, 19F);

		body[47].addBox(0F, 0F, 0F, 2, 8, 7, 0F); // Box 84
		body[47].setRotationPoint(-20F, -10F, 14F);

		body[48].addBox(0F, 0F, 0F, 2, 8, 7, 0F); // Box 85
		body[48].setRotationPoint(-3F, -10F, 14F);

		body[49].addBox(0F, 0F, 0F, 2, 8, 7, 0F); // Box 86
		body[49].setRotationPoint(-37F, -10F, 14F);

		body[50].addBox(0F, 0F, 0F, 66, 8, 1, 0F); // Box 89
		body[50].setRotationPoint(-52F, -10F, -13F);

		body[51].addBox(0F, 0F, 0F, 68, 1, 8, 0F); // Box 90
		body[51].setRotationPoint(-53F, -2F, -20F);

		body[52].addBox(0F, 0F, 0F, 1, 8, 8, 0F); // Box 91
		body[52].setRotationPoint(-53F, -10F, -20F);

		body[53].addBox(0F, 0F, 0F, 68, 1, 8, 0F); // Box 92
		body[53].setRotationPoint(-53F, -11F, -20F);

		body[54].addBox(0F, 0F, 0F, 1, 8, 8, 0F); // Box 93
		body[54].setRotationPoint(14F, -10F, -20F);

		body[55].addBox(0F, 0F, 0F, 2, 8, 7, 0F); // Box 94
		body[55].setRotationPoint(-3F, -10F, -20F);

		body[56].addBox(0F, 0F, 0F, 2, 8, 7, 0F); // Box 95
		body[56].setRotationPoint(-20F, -10F, -20F);

		body[57].addBox(0F, 0F, 0F, 2, 8, 7, 0F); // Box 96
		body[57].setRotationPoint(-37F, -10F, -20F);

		body[58].addBox(0F, 0F, 0F, 66, 8, 1, 0F); // Box 97
		body[58].setRotationPoint(-52F, -10F, -19F);

		body[59].addShapeBox(0F, 0F, 0F, 1, 8, 16, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F); // Box 98
		body[59].setRotationPoint(-101F, -43F, -3F);

		body[60].addShapeBox(0F, 0F, 0F, 1, 10, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 99
		body[60].setRotationPoint(12F, -43F, 20.5F);

		body[61].addShapeBox(0F, 0F, 0F, 1, 10, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 100
		body[61].setRotationPoint(-17F, -43F, 20.5F);

		body[62].addBox(0F, 0F, 0F, 1, 1, 5, 0F); // Box 101
		body[62].setRotationPoint(12F, -43F, 15.5F);

		body[63].addBox(0F, 0F, 0F, 1, 1, 5, 0F); // Box 102
		body[63].setRotationPoint(-17F, -43F, 15.5F);

		body[64].addShapeBox(0F, 0F, 0F, 32, 12, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F); // Box 103
		body[64].setRotationPoint(-18F, -44F, 21.5F);

		body[65].addBox(0F, 0F, 0F, 18, 3, 12, 0F); // Box 104
		body[65].setRotationPoint(-11F, -49.5F, -6F);


		bodyColoredSecondary = new ModelRendererTurbo[30];
		bodyColoredSecondary[0] = new ModelRendererTurbo(this, 249, 1, textureX, textureY); // Box 3
		bodyColoredSecondary[1] = new ModelRendererTurbo(this, 249, 17, textureX, textureY); // Box 4
		bodyColoredSecondary[2] = new ModelRendererTurbo(this, 249, 33, textureX, textureY); // Box 5
		bodyColoredSecondary[3] = new ModelRendererTurbo(this, 1, 49, textureX, textureY); // Box 6
		bodyColoredSecondary[4] = new ModelRendererTurbo(this, 241, 49, textureX, textureY); // Box 7
		bodyColoredSecondary[5] = new ModelRendererTurbo(this, 1, 57, textureX, textureY); // Box 8
		bodyColoredSecondary[6] = new ModelRendererTurbo(this, 241, 57, textureX, textureY); // Box 9
		bodyColoredSecondary[7] = new ModelRendererTurbo(this, 233, 65, textureX, textureY); // Box 10
		bodyColoredSecondary[8] = new ModelRendererTurbo(this, 1, 81, textureX, textureY); // Box 11
		bodyColoredSecondary[9] = new ModelRendererTurbo(this, 249, 81, textureX, textureY); // Box 12
		bodyColoredSecondary[10] = new ModelRendererTurbo(this, 1, 97, textureX, textureY); // Box 13
		bodyColoredSecondary[11] = new ModelRendererTurbo(this, 241, 97, textureX, textureY); // Box 14
		bodyColoredSecondary[12] = new ModelRendererTurbo(this, 241, 105, textureX, textureY); // Box 15
		bodyColoredSecondary[13] = new ModelRendererTurbo(this, 1, 113, textureX, textureY); // Box 16
		bodyColoredSecondary[14] = new ModelRendererTurbo(this, 241, 113, textureX, textureY); // Box 17
		bodyColoredSecondary[15] = new ModelRendererTurbo(this, 233, 121, textureX, textureY); // Box 18
		bodyColoredSecondary[16] = new ModelRendererTurbo(this, 57, 1, textureX, textureY); // Box 19
		bodyColoredSecondary[17] = new ModelRendererTurbo(this, 153, 1, textureX, textureY); // Box 20
		bodyColoredSecondary[18] = new ModelRendererTurbo(this, 1, 129, textureX, textureY); // Box 21
		bodyColoredSecondary[19] = new ModelRendererTurbo(this, 97, 129, textureX, textureY); // Box 22
		bodyColoredSecondary[20] = new ModelRendererTurbo(this, 145, 137, textureX, textureY); // Box 23
		bodyColoredSecondary[21] = new ModelRendererTurbo(this, 49, 129, textureX, textureY); // Box 24
		bodyColoredSecondary[22] = new ModelRendererTurbo(this, 193, 129, textureX, textureY); // Box 25
		bodyColoredSecondary[23] = new ModelRendererTurbo(this, 233, 137, textureX, textureY); // Box 33
		bodyColoredSecondary[24] = new ModelRendererTurbo(this, 265, 137, textureX, textureY); // Box 34
		bodyColoredSecondary[25] = new ModelRendererTurbo(this, 297, 137, textureX, textureY); // Box 35
		bodyColoredSecondary[26] = new ModelRendererTurbo(this, 393, 137, textureX, textureY); // Box 36
		bodyColoredSecondary[27] = new ModelRendererTurbo(this, 345, 153, textureX, textureY); // Box 37
		bodyColoredSecondary[28] = new ModelRendererTurbo(this, 57, 169, textureX, textureY); // Box 38
		bodyColoredSecondary[29] = new ModelRendererTurbo(this, 441, 137, textureX, textureY); // Box 39

		bodyColoredSecondary[0].addBox(0F, 0F, 0F, 116, 1, 12, 0F); // Box 3
		bodyColoredSecondary[0].setRotationPoint(-98F, -14F, -6F);

		bodyColoredSecondary[1].addShapeBox(0F, 0F, 0F, 116, 1, 8, 0F, 0F, 4F, 0F, 0F, 4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 4
		bodyColoredSecondary[1].setRotationPoint(-98F, -14F, -14F);

		bodyColoredSecondary[2].addShapeBox(0F, 0F, 0F, 116, 8, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 4F, 0F, 0F, 4F); // Box 5
		bodyColoredSecondary[2].setRotationPoint(-98F, -28F, -21F);

		bodyColoredSecondary[3].addShapeBox(0F, 0F, 0F, 116, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -3F, 0F, -1F, -3F, 0F, -2F, 2F, 0F, -2F, 2F); // Box 6
		bodyColoredSecondary[3].setRotationPoint(-98F, -20F, -17F);

		bodyColoredSecondary[4].addBox(0F, 0F, 0F, 116, 6, 1, 0F); // Box 7
		bodyColoredSecondary[4].setRotationPoint(-98F, -34F, -21F);

		bodyColoredSecondary[5].addShapeBox(0F, 0F, 0F, 116, 8, 1, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 4F, 0F, 0F, 4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 8
		bodyColoredSecondary[5].setRotationPoint(-98F, -42F, -21F);

		bodyColoredSecondary[6].addShapeBox(0F, 0F, 0F, 116, 4, 1, 0F, 0F, -1F, -3F, 0F, -1F, -3F, 0F, -2F, 2F, 0F, -2F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 9
		bodyColoredSecondary[6].setRotationPoint(-98F, -46F, -17F);

		bodyColoredSecondary[7].addShapeBox(0F, 0F, 0F, 116, 1, 8, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 4F, 0F, 0F, 4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 10
		bodyColoredSecondary[7].setRotationPoint(-98F, -49F, -14F);

		bodyColoredSecondary[8].addBox(0F, 0F, 0F, 116, 1, 12, 0F); // Box 11
		bodyColoredSecondary[8].setRotationPoint(-98F, -49F, -6F);

		bodyColoredSecondary[9].addShapeBox(0F, 0F, 0F, 116, 1, 8, 0F, 0F, 4F, 0F, 0F, 4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 12
		bodyColoredSecondary[9].setRotationPoint(-98F, -45F, 6F);

		bodyColoredSecondary[10].addShapeBox(0F, 0F, 0F, 116, 8, 1, 0F, 0F, 0F, 4F, 0F, 0F, 4F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 13
		bodyColoredSecondary[10].setRotationPoint(-98F, -42F, 20F);

		bodyColoredSecondary[11].addShapeBox(0F, 0F, 0F, 116, 4, 1, 0F, 0F, -2F, 2F, 0F, -2F, 2F, 0F, -1F, -3F, 0F, -1F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 14
		bodyColoredSecondary[11].setRotationPoint(-98F, -46F, 16F);

		bodyColoredSecondary[12].addBox(0F, 0F, 0F, 116, 6, 1, 0F); // Box 15
		bodyColoredSecondary[12].setRotationPoint(-98F, -34F, 20F);

		bodyColoredSecondary[13].addShapeBox(0F, 0F, 0F, 116, 8, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 4F, 0F, 0F, 4F, 0F, 0F, -4F, 0F, 0F, -4F); // Box 16
		bodyColoredSecondary[13].setRotationPoint(-98F, -28F, 20F);

		bodyColoredSecondary[14].addShapeBox(0F, 0F, 0F, 116, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 2F, 0F, -2F, 2F, 0F, -1F, -3F, 0F, -1F, -3F); // Box 17
		bodyColoredSecondary[14].setRotationPoint(-98F, -20F, 16F);

		bodyColoredSecondary[15].addShapeBox(0F, 0F, 0F, 116, 1, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 4F, 0F, 0F, 4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F); // Box 18
		bodyColoredSecondary[15].setRotationPoint(-98F, -14F, 6F);

		bodyColoredSecondary[16].addShapeBox(0F, 0F, 0F, 2, 4, 28, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, -2F, -8F, 0F, 0F, -8F, 0F, 0F, -8F, 0F, -2F, -8F); // Box 19
		bodyColoredSecondary[16].setRotationPoint(-100F, -17F, -14F);

		bodyColoredSecondary[17].addShapeBox(0F, 0F, 0F, 2, 3, 34, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -7F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, -7F); // Box 20
		bodyColoredSecondary[17].setRotationPoint(-100F, -20F, -17F);

		bodyColoredSecondary[18].addShapeBox(0F, 0F, 0F, 2, 8, 42, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -7F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, -7F); // Box 21
		bodyColoredSecondary[18].setRotationPoint(-100F, -28F, -21F);

		bodyColoredSecondary[19].addShapeBox(0F, 0F, 0F, 2, 6, 42, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F); // Box 22
		bodyColoredSecondary[19].setRotationPoint(-100F, -34F, -21F);

		bodyColoredSecondary[20].addShapeBox(0F, 0F, 0F, 2, 8, 42, 0F, 0F, 0F, -7F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, -7F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F); // Box 23
		bodyColoredSecondary[20].setRotationPoint(-100F, -42F, -21F);

		bodyColoredSecondary[21].addShapeBox(0F, 0F, 0F, 2, 3, 34, 0F, 0F, 0F, -6F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, -6F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F); // Box 24
		bodyColoredSecondary[21].setRotationPoint(-100F, -45F, -17F);

		bodyColoredSecondary[22].addShapeBox(0F, 0F, 0F, 2, 4, 28, 0F, 0F, -2F, -8F, 0F, 0F, -8F, 0F, 0F, -8F, 0F, -2F, -8F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F); // Box 25
		bodyColoredSecondary[22].setRotationPoint(-100F, -49F, -14F);

		bodyColoredSecondary[23].addShapeBox(0F, 0F, 0F, 2, 4, 28, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, -8F, 0F, -2F, -8F, 0F, -2F, -8F, 0F, 0F, -8F); // Box 33
		bodyColoredSecondary[23].setRotationPoint(18F, -17F, -14F);

		bodyColoredSecondary[24].addShapeBox(0F, 0F, 0F, 2, 3, 34, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -7F, 0F, 0F, -7F, 0F, 0F, -3F); // Box 34
		bodyColoredSecondary[24].setRotationPoint(18F, -20F, -17F);

		bodyColoredSecondary[25].addShapeBox(0F, 0F, 0F, 2, 8, 42, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, -7F, 0F, 0F, -7F, 0F, 0F, -4F); // Box 35
		bodyColoredSecondary[25].setRotationPoint(18F, -28F, -21F);

		bodyColoredSecondary[26].addShapeBox(0F, 0F, 0F, 2, 6, 42, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F); // Box 36
		bodyColoredSecondary[26].setRotationPoint(18F, -34F, -21F);

		bodyColoredSecondary[27].addShapeBox(0F, 0F, 0F, 2, 8, 42, 0F, 0F, 0F, -4F, 0F, 0F, -7F, 0F, 0F, -7F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F); // Box 37
		bodyColoredSecondary[27].setRotationPoint(18F, -42F, -21F);

		bodyColoredSecondary[28].addShapeBox(0F, 0F, 0F, 2, 3, 34, 0F, 0F, 0F, -3F, 0F, 0F, -6F, 0F, 0F, -6F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F); // Box 38
		bodyColoredSecondary[28].setRotationPoint(18F, -45F, -17F);

		bodyColoredSecondary[29].addShapeBox(0F, 0F, 0F, 2, 4, 28, 0F, 0F, 0F, -8F, 0F, -2F, -8F, 0F, -2F, -8F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F); // Box 39
		bodyColoredSecondary[29].setRotationPoint(18F, -49F, -14F);
		
	}
	
}