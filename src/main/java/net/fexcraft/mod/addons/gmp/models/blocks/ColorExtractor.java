//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2018 Minecraft-SMP.de
// This file is for Fex's Vehicle and Transportation Mod

// Model: ColorExtractor
// Model Creator: FEX___96
// Created on: 26.06.2018 - 10:46:45
// Last changed on: 26.06.2018 - 10:46:45

package net.fexcraft.mod.addons.gmp.models.blocks; //Path where the model is located

import net.fexcraft.mod.fvtm.api.Block.BlockData;
import net.fexcraft.mod.fvtm.api.Block.BlockTileEntity;
import net.fexcraft.mod.fvtm.impl.block.CrafterBlockScriptBase;
import net.fexcraft.mod.fvtm.model.block.BlockModel;
import net.fexcraft.mod.fvtm.util.RenderCache;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.entity.Entity;

public class ColorExtractor extends BlockModel {
	
	public ColorExtractor(){
		textureX = textureY = 256;
		body = new ModelRendererTurbo[140];
		body[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
		body[1] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 1
		body[2] = new ModelRendererTurbo(this, 49, 1, textureX, textureY); // Box 2
		body[3] = new ModelRendererTurbo(this, 73, 1, textureX, textureY); // Box 3
		body[4] = new ModelRendererTurbo(this, 97, 1, textureX, textureY); // Box 4
		body[5] = new ModelRendererTurbo(this, 121, 1, textureX, textureY); // Box 5
		body[6] = new ModelRendererTurbo(this, 145, 1, textureX, textureY); // Box 6
		body[7] = new ModelRendererTurbo(this, 169, 1, textureX, textureY); // Box 7
		body[8] = new ModelRendererTurbo(this, 193, 1, textureX, textureY); // Box 8
		body[9] = new ModelRendererTurbo(this, 217, 1, textureX, textureY); // Box 9
		body[10] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 10
		body[11] = new ModelRendererTurbo(this, 25, 17, textureX, textureY); // Box 11
		body[12] = new ModelRendererTurbo(this, 49, 17, textureX, textureY); // Box 12
		body[13] = new ModelRendererTurbo(this, 73, 17, textureX, textureY); // Box 13
		body[14] = new ModelRendererTurbo(this, 97, 17, textureX, textureY); // Box 14
		body[15] = new ModelRendererTurbo(this, 121, 17, textureX, textureY); // Box 15
		body[16] = new ModelRendererTurbo(this, 129, 17, textureX, textureY); // Box 16
		body[17] = new ModelRendererTurbo(this, 185, 17, textureX, textureY); // Box 17
		body[18] = new ModelRendererTurbo(this, 209, 17, textureX, textureY); // Box 18
		body[19] = new ModelRendererTurbo(this, 233, 17, textureX, textureY); // Box 19
		body[20] = new ModelRendererTurbo(this, 1, 33, textureX, textureY); // Box 20
		body[21] = new ModelRendererTurbo(this, 25, 33, textureX, textureY); // Box 21
		body[22] = new ModelRendererTurbo(this, 49, 33, textureX, textureY); // Box 22
		body[23] = new ModelRendererTurbo(this, 73, 33, textureX, textureY); // Box 23
		body[24] = new ModelRendererTurbo(this, 97, 33, textureX, textureY); // Box 24
		body[25] = new ModelRendererTurbo(this, 193, 33, textureX, textureY); // Box 25
		body[26] = new ModelRendererTurbo(this, 217, 33, textureX, textureY); // Box 26
		body[27] = new ModelRendererTurbo(this, 25, 41, textureX, textureY); // Box 27
		body[28] = new ModelRendererTurbo(this, 49, 41, textureX, textureY); // Box 28
		body[29] = new ModelRendererTurbo(this, 73, 41, textureX, textureY); // Box 29
		body[30] = new ModelRendererTurbo(this, 97, 41, textureX, textureY); // Box 30
		body[31] = new ModelRendererTurbo(this, 121, 41, textureX, textureY); // Box 31
		body[32] = new ModelRendererTurbo(this, 145, 41, textureX, textureY); // Box 32
		body[33] = new ModelRendererTurbo(this, 169, 41, textureX, textureY); // Box 33
		body[34] = new ModelRendererTurbo(this, 193, 41, textureX, textureY); // Box 34
		body[35] = new ModelRendererTurbo(this, 217, 41, textureX, textureY); // Box 35
		body[36] = new ModelRendererTurbo(this, 1, 49, textureX, textureY); // Box 36
		body[37] = new ModelRendererTurbo(this, 25, 49, textureX, textureY); // Box 37
		body[38] = new ModelRendererTurbo(this, 49, 49, textureX, textureY); // Box 38
		body[39] = new ModelRendererTurbo(this, 73, 49, textureX, textureY); // Box 39
		body[40] = new ModelRendererTurbo(this, 97, 49, textureX, textureY); // Box 40
		body[41] = new ModelRendererTurbo(this, 121, 49, textureX, textureY); // Box 41
		body[42] = new ModelRendererTurbo(this, 145, 49, textureX, textureY); // Box 42
		body[43] = new ModelRendererTurbo(this, 169, 49, textureX, textureY); // Box 43
		body[44] = new ModelRendererTurbo(this, 193, 49, textureX, textureY); // Box 44
		body[45] = new ModelRendererTurbo(this, 217, 49, textureX, textureY); // Box 45
		body[46] = new ModelRendererTurbo(this, 1, 57, textureX, textureY); // Box 46
		body[47] = new ModelRendererTurbo(this, 25, 57, textureX, textureY); // Box 47
		body[48] = new ModelRendererTurbo(this, 49, 57, textureX, textureY); // Box 48
		body[49] = new ModelRendererTurbo(this, 73, 57, textureX, textureY); // Box 49
		body[50] = new ModelRendererTurbo(this, 97, 57, textureX, textureY); // Box 50
		body[51] = new ModelRendererTurbo(this, 121, 57, textureX, textureY); // Box 51
		body[52] = new ModelRendererTurbo(this, 145, 57, textureX, textureY); // Box 52
		body[53] = new ModelRendererTurbo(this, 169, 57, textureX, textureY); // Box 53
		body[54] = new ModelRendererTurbo(this, 193, 57, textureX, textureY); // Box 54
		body[55] = new ModelRendererTurbo(this, 217, 57, textureX, textureY); // Box 55
		body[56] = new ModelRendererTurbo(this, 1, 65, textureX, textureY); // Box 56
		body[57] = new ModelRendererTurbo(this, 25, 65, textureX, textureY); // Box 57
		body[58] = new ModelRendererTurbo(this, 49, 65, textureX, textureY); // Box 58
		body[59] = new ModelRendererTurbo(this, 73, 65, textureX, textureY); // Box 59
		body[60] = new ModelRendererTurbo(this, 97, 65, textureX, textureY); // Box 60
		body[61] = new ModelRendererTurbo(this, 121, 65, textureX, textureY); // Box 61
		body[62] = new ModelRendererTurbo(this, 145, 65, textureX, textureY); // Box 62
		body[63] = new ModelRendererTurbo(this, 169, 65, textureX, textureY); // Box 63
		body[64] = new ModelRendererTurbo(this, 193, 65, textureX, textureY); // Box 64
		body[65] = new ModelRendererTurbo(this, 217, 65, textureX, textureY); // Box 65
		body[66] = new ModelRendererTurbo(this, 1, 73, textureX, textureY); // Box 66
		body[67] = new ModelRendererTurbo(this, 25, 73, textureX, textureY); // Box 67
		body[68] = new ModelRendererTurbo(this, 49, 73, textureX, textureY); // Box 68
		body[69] = new ModelRendererTurbo(this, 73, 73, textureX, textureY); // Box 69
		body[70] = new ModelRendererTurbo(this, 113, 73, textureX, textureY); // Box 70
		body[71] = new ModelRendererTurbo(this, 153, 73, textureX, textureY); // Box 71
		body[72] = new ModelRendererTurbo(this, 193, 73, textureX, textureY); // Box 72
		body[73] = new ModelRendererTurbo(this, 217, 73, textureX, textureY); // Box 73
		body[74] = new ModelRendererTurbo(this, 1, 81, textureX, textureY); // Box 74
		body[75] = new ModelRendererTurbo(this, 41, 81, textureX, textureY); // Box 75
		body[76] = new ModelRendererTurbo(this, 65, 89, textureX, textureY); // Box 76
		body[77] = new ModelRendererTurbo(this, 105, 89, textureX, textureY); // Box 77
		body[78] = new ModelRendererTurbo(this, 145, 89, textureX, textureY); // Box 78
		body[79] = new ModelRendererTurbo(this, 185, 89, textureX, textureY); // Box 79
		body[80] = new ModelRendererTurbo(this, 209, 97, textureX, textureY); // Box 80
		body[81] = new ModelRendererTurbo(this, 1, 105, textureX, textureY); // Box 93
		body[82] = new ModelRendererTurbo(this, 49, 105, textureX, textureY); // Box 106
		body[83] = new ModelRendererTurbo(this, 65, 113, textureX, textureY); // Box 107
		body[84] = new ModelRendererTurbo(this, 97, 105, textureX, textureY); // Box 108
		body[85] = new ModelRendererTurbo(this, 137, 105, textureX, textureY); // Box 109
		body[86] = new ModelRendererTurbo(this, 177, 105, textureX, textureY); // Box 110
		body[87] = new ModelRendererTurbo(this, 81, 113, textureX, textureY); // Box 111
		body[88] = new ModelRendererTurbo(this, 113, 113, textureX, textureY); // Box 112
		body[89] = new ModelRendererTurbo(this, 153, 113, textureX, textureY); // Box 113
		body[90] = new ModelRendererTurbo(this, 193, 113, textureX, textureY); // Box 114
		body[91] = new ModelRendererTurbo(this, 241, 113, textureX, textureY); // Box 115
		body[92] = new ModelRendererTurbo(this, 1, 121, textureX, textureY); // Box 116
		body[93] = new ModelRendererTurbo(this, 17, 121, textureX, textureY); // Box 117
		body[94] = new ModelRendererTurbo(this, 129, 113, textureX, textureY); // Box 118
		body[95] = new ModelRendererTurbo(this, 169, 113, textureX, textureY); // Box 119
		body[96] = new ModelRendererTurbo(this, 33, 121, textureX, textureY); // Box 120
		body[97] = new ModelRendererTurbo(this, 41, 121, textureX, textureY); // Box 121
		body[98] = new ModelRendererTurbo(this, 193, 121, textureX, textureY); // Box 122
		body[99] = new ModelRendererTurbo(this, 49, 121, textureX, textureY); // Box 123
		body[100] = new ModelRendererTurbo(this, 89, 121, textureX, textureY); // Box 124
		body[101] = new ModelRendererTurbo(this, 169, 97, textureX, textureY); // Box 125
		body[102] = new ModelRendererTurbo(this, 137, 129, textureX, textureY); // Box 126
		body[103] = new ModelRendererTurbo(this, 137, 121, textureX, textureY); // Box 135
		body[104] = new ModelRendererTurbo(this, 65, 137, textureX, textureY); // Box 136
		body[105] = new ModelRendererTurbo(this, 249, 97, textureX, textureY); // Box 137
		body[106] = new ModelRendererTurbo(this, 49, 121, textureX, textureY); // Box 138
		body[107] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 139
		body[108] = new ModelRendererTurbo(this, 41, 1, textureX, textureY); // Box 140
		body[109] = new ModelRendererTurbo(this, 65, 1, textureX, textureY); // Box 141
		body[110] = new ModelRendererTurbo(this, 89, 1, textureX, textureY); // Box 142
		body[111] = new ModelRendererTurbo(this, 113, 1, textureX, textureY); // Box 143
		body[112] = new ModelRendererTurbo(this, 137, 1, textureX, textureY); // Box 144
		body[113] = new ModelRendererTurbo(this, 161, 1, textureX, textureY); // Box 145
		body[114] = new ModelRendererTurbo(this, 185, 1, textureX, textureY); // Box 146
		body[115] = new ModelRendererTurbo(this, 209, 1, textureX, textureY); // Box 147
		body[116] = new ModelRendererTurbo(this, 17, 17, textureX, textureY); // Box 148
		body[117] = new ModelRendererTurbo(this, 41, 17, textureX, textureY); // Box 149
		body[118] = new ModelRendererTurbo(this, 65, 17, textureX, textureY); // Box 150
		body[119] = new ModelRendererTurbo(this, 89, 17, textureX, textureY); // Box 151
		body[120] = new ModelRendererTurbo(this, 113, 17, textureX, textureY); // Box 152
		body[121] = new ModelRendererTurbo(this, 201, 17, textureX, textureY); // Box 153
		body[122] = new ModelRendererTurbo(this, 225, 17, textureX, textureY); // Box 154
		body[123] = new ModelRendererTurbo(this, 65, 81, textureX, textureY); // Box 155
		body[124] = new ModelRendererTurbo(this, 177, 137, textureX, textureY); // Box 156
		body[125] = new ModelRendererTurbo(this, 145, 97, textureX, textureY); // Box 157
		body[126] = new ModelRendererTurbo(this, 153, 97, textureX, textureY); // Box 158
		body[127] = new ModelRendererTurbo(this, 105, 121, textureX, textureY); // Box 159
		body[128] = new ModelRendererTurbo(this, 233, 121, textureX, textureY); // Box 160
		body[129] = new ModelRendererTurbo(this, 249, 129, textureX, textureY); // Box 161
		body[130] = new ModelRendererTurbo(this, 25, 137, textureX, textureY); // Box 162
		body[131] = new ModelRendererTurbo(this, 201, 137, textureX, textureY); // Box 163
		body[132] = new ModelRendererTurbo(this, 177, 121, textureX, textureY); // Box 164
		body[133] = new ModelRendererTurbo(this, 1, 137, textureX, textureY); // Box 165
		body[134] = new ModelRendererTurbo(this, 209, 137, textureX, textureY); // Box 166
		body[135] = new ModelRendererTurbo(this, 217, 137, textureX, textureY); // Box 167
		body[136] = new ModelRendererTurbo(this, 225, 137, textureX, textureY); // Box 168
		body[137] = new ModelRendererTurbo(this, 233, 137, textureX, textureY); // Box 169
		body[138] = new ModelRendererTurbo(this, 241, 137, textureX, textureY); // Box 170
		body[139] = new ModelRendererTurbo(this, 33, 145, textureX, textureY); // Box 171

		body[0].addShapeBox(0F, 0F, 0F, 4, 8, 4, 0F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F); // Box 0
		body[0].setRotationPoint(-24F, -8F, -8F);

		body[1].addShapeBox(0F, 0F, 0F, 4, 8, 4, 0F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F); // Box 1
		body[1].setRotationPoint(-20F, -8F, -8F);

		body[2].addShapeBox(0F, 0F, 0F, 4, 8, 4, 0F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F); // Box 2
		body[2].setRotationPoint(-16F, -8F, -8F);

		body[3].addShapeBox(0F, 0F, 0F, 4, 8, 4, 0F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F); // Box 3
		body[3].setRotationPoint(-12F, -8F, -8F);

		body[4].addShapeBox(0F, 0F, 0F, 4, 8, 4, 0F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F); // Box 4
		body[4].setRotationPoint(-12F, -8F, -4F);

		body[5].addShapeBox(0F, 0F, 0F, 4, 8, 4, 0F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F); // Box 5
		body[5].setRotationPoint(-12F, -8F, 0F);

		body[6].addShapeBox(0F, 0F, 0F, 4, 8, 4, 0F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F); // Box 6
		body[6].setRotationPoint(-12F, -8F, 4F);

		body[7].addShapeBox(0F, 0F, 0F, 4, 8, 4, 0F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F); // Box 7
		body[7].setRotationPoint(-16F, -8F, -4F);

		body[8].addShapeBox(0F, 0F, 0F, 4, 8, 4, 0F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F); // Box 8
		body[8].setRotationPoint(-16F, -8F, 0F);

		body[9].addShapeBox(0F, 0F, 0F, 4, 8, 4, 0F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F); // Box 9
		body[9].setRotationPoint(-16F, -8F, 4F);

		body[10].addShapeBox(0F, 0F, 0F, 4, 8, 4, 0F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F); // Box 10
		body[10].setRotationPoint(-20F, -8F, -4F);

		body[11].addShapeBox(0F, 0F, 0F, 4, 8, 4, 0F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F); // Box 11
		body[11].setRotationPoint(-20F, -8F, 0F);

		body[12].addShapeBox(0F, 0F, 0F, 4, 8, 4, 0F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F); // Box 12
		body[12].setRotationPoint(-20F, -8F, 4F);

		body[13].addShapeBox(0F, 0F, 0F, 4, 8, 4, 0F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F); // Box 13
		body[13].setRotationPoint(-24F, -8F, -4F);

		body[14].addShapeBox(0F, 0F, 0F, 4, 8, 4, 0F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F); // Box 14
		body[14].setRotationPoint(-24F, -8F, 0F);

		body[15].addShapeBox(0F, 0F, 0F, 4, 8, 4, 0F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F); // Box 15
		body[15].setRotationPoint(-24F, -8F, 4F);

		body[16].addShapeBox(0F, 0F, 0F, 16, 1, 16, 0F, 0.25F, 0F, 0.25F, 0.25F, 0F, 0.25F, 0.25F, 0F, 0.25F, 0.25F, 0F, 0.25F, 0.25F, 0F, 0.25F, 0.25F, 0F, 0.25F, 0.25F, 0F, 0.25F, 0.25F, 0F, 0.25F); // Box 16
		body[16].setRotationPoint(-8F, -12F, -8F);

		body[17].addBox(0F, 0F, 0F, 4, 11, 4, 0F); // Box 17
		body[17].setRotationPoint(-7F, -11F, -7F);

		body[18].addBox(0F, 0F, 0F, 4, 11, 4, 0F); // Box 18
		body[18].setRotationPoint(3F, -11F, -7F);

		body[19].addBox(0F, 0F, 0F, 4, 11, 4, 0F); // Box 19
		body[19].setRotationPoint(3F, -11F, 3F);

		body[20].addBox(0F, 0F, 0F, 4, 11, 4, 0F); // Box 20
		body[20].setRotationPoint(-7F, -11F, 3F);

		body[21].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F); // Box 21
		body[21].setRotationPoint(-12F, -9F, -8F);

		body[22].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F); // Box 22
		body[22].setRotationPoint(-12F, -9F, -4F);

		body[23].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F); // Box 23
		body[23].setRotationPoint(-12F, -9F, 0F);

		body[24].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F); // Box 24
		body[24].setRotationPoint(-12F, -9F, 4F);

		body[25].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F); // Box 25
		body[25].setRotationPoint(-16F, -9F, 4F);

		body[26].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F); // Box 26
		body[26].setRotationPoint(-16F, -9F, 0F);

		body[27].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F); // Box 27
		body[27].setRotationPoint(-16F, -9F, -4F);

		body[28].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F); // Box 28
		body[28].setRotationPoint(-16F, -9F, -8F);

		body[29].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F); // Box 29
		body[29].setRotationPoint(-20F, -9F, -8F);

		body[30].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F); // Box 30
		body[30].setRotationPoint(-20F, -9F, -4F);

		body[31].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F); // Box 31
		body[31].setRotationPoint(-20F, -9F, 0F);

		body[32].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F); // Box 32
		body[32].setRotationPoint(-20F, -9F, 4F);

		body[33].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F); // Box 33
		body[33].setRotationPoint(-24F, -9F, 4F);

		body[34].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F); // Box 34
		body[34].setRotationPoint(-24F, -9F, 0F);

		body[35].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F); // Box 35
		body[35].setRotationPoint(-24F, -9F, -4F);

		body[36].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F); // Box 36
		body[36].setRotationPoint(-24F, -9F, -8F);

		body[37].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F); // Box 37
		body[37].setRotationPoint(-12F, -7F, -8F);

		body[38].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F); // Box 38
		body[38].setRotationPoint(-12F, -2F, -8F);

		body[39].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F); // Box 39
		body[39].setRotationPoint(-12F, -7F, -4F);

		body[40].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F); // Box 40
		body[40].setRotationPoint(-12F, -7F, 0F);

		body[41].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F); // Box 41
		body[41].setRotationPoint(-12F, -7F, 4F);

		body[42].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F); // Box 42
		body[42].setRotationPoint(-16F, -7F, 4F);

		body[43].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F); // Box 43
		body[43].setRotationPoint(-16F, -7F, 0F);

		body[44].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F); // Box 44
		body[44].setRotationPoint(-16F, -7F, -4F);

		body[45].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F); // Box 45
		body[45].setRotationPoint(-16F, -7F, -8F);

		body[46].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F); // Box 46
		body[46].setRotationPoint(-20F, -7F, -8F);

		body[47].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F); // Box 47
		body[47].setRotationPoint(-20F, -7F, -4F);

		body[48].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F); // Box 48
		body[48].setRotationPoint(-20F, -7F, 0F);

		body[49].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F); // Box 49
		body[49].setRotationPoint(-20F, -7F, 4F);

		body[50].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F); // Box 50
		body[50].setRotationPoint(-24F, -7F, 4F);

		body[51].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F); // Box 51
		body[51].setRotationPoint(-24F, -7F, 0F);

		body[52].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F); // Box 52
		body[52].setRotationPoint(-24F, -7F, -4F);

		body[53].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F); // Box 53
		body[53].setRotationPoint(-24F, -7F, -8F);

		body[54].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F); // Box 54
		body[54].setRotationPoint(-12F, -2F, -4F);

		body[55].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F); // Box 55
		body[55].setRotationPoint(-12F, -2F, 0F);

		body[56].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F); // Box 56
		body[56].setRotationPoint(-12F, -2F, 4F);

		body[57].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F); // Box 57
		body[57].setRotationPoint(-16F, -2F, 4F);

		body[58].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F); // Box 58
		body[58].setRotationPoint(-16F, -2F, 0F);

		body[59].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F); // Box 59
		body[59].setRotationPoint(-16F, -2F, -4F);

		body[60].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F); // Box 60
		body[60].setRotationPoint(-16F, -2F, -8F);

		body[61].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F); // Box 61
		body[61].setRotationPoint(-20F, -2F, -8F);

		body[62].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F); // Box 62
		body[62].setRotationPoint(-20F, -2F, -4F);

		body[63].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F); // Box 63
		body[63].setRotationPoint(-20F, -2F, 0F);

		body[64].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F); // Box 64
		body[64].setRotationPoint(-20F, -2F, 4F);

		body[65].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F); // Box 65
		body[65].setRotationPoint(-24F, -2F, 4F);

		body[66].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F); // Box 66
		body[66].setRotationPoint(-24F, -2F, 0F);

		body[67].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F); // Box 67
		body[67].setRotationPoint(-24F, -2F, -4F);

		body[68].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F); // Box 68
		body[68].setRotationPoint(-24F, -2F, -8F);

		body[69].addBox(0F, 0F, 0F, 15, 8, 1, 0F); // Box 69
		body[69].setRotationPoint(8F, -8F, -8F);

		body[70].addBox(0F, 0F, 0F, 15, 8, 1, 0F); // Box 70
		body[70].setRotationPoint(23F, -8F, 7F);
		body[70].rotateAngleY = 1.57079633F;

		body[71].addBox(0F, 0F, 0F, 15, 8, 1, 0F); // Box 71
		body[71].setRotationPoint(9F, -8F, 7F);

		body[72].addBox(0F, 0F, 0F, 15, 8, 1, 0F); // Box 72
		body[72].setRotationPoint(8F, -8F, 8F);
		body[72].rotateAngleY = 1.57079633F;

		body[73].addBox(0F, 0F, 0F, 1, 1, 16, 0F); // Box 73
		body[73].setRotationPoint(7.5F, -2F, -8.5F);

		body[74].addBox(0F, 0F, 0F, 1, 1, 16, 0F); // Box 74
		body[74].setRotationPoint(8.5F, -2F, -7.5F);
		body[74].rotateAngleY = 1.57079633F;

		body[75].addBox(0F, 0F, 0F, 1, 1, 16, 0F); // Box 75
		body[75].setRotationPoint(23.5F, -2F, -7.5F);

		body[76].addBox(0F, 0F, 0F, 1, 1, 16, 0F); // Box 76
		body[76].setRotationPoint(7.5F, -2F, 8.5F);
		body[76].rotateAngleY = 1.57079633F;

		body[77].addBox(0F, 0F, 0F, 1, 1, 16, 0F); // Box 77
		body[77].setRotationPoint(7.5F, -7F, -8.5F);

		body[78].addBox(0F, 0F, 0F, 1, 1, 16, 0F); // Box 78
		body[78].setRotationPoint(8.5F, -7F, -7.5F);
		body[78].rotateAngleY = 1.57079633F;

		body[79].addBox(0F, 0F, 0F, 1, 1, 16, 0F); // Box 79
		body[79].setRotationPoint(23.5F, -7F, -7.5F);

		body[80].addBox(0F, 0F, 0F, 1, 1, 16, 0F); // Box 80
		body[80].setRotationPoint(7.5F, -7F, 8.5F);
		body[80].rotateAngleY = 1.57079633F;

		body[81].addBox(0F, 0F, 0F, 14, 0, 14, 0F); // Box 93
		body[81].setRotationPoint(9F, -0.1F, -7F);

		body[82].addBox(0F, 0F, 0F, 4, 11, 1, 0F); // Box 106
		body[82].setRotationPoint(-2F, -27F, -8F);

		body[83].addShapeBox(0F, 0F, 0F, 4, 8, 1, 0F, -1F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 2F, -1F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 2F); // Box 107
		body[83].setRotationPoint(-6F, -24F, -8F);

		body[84].addShapeBox(0F, 0F, 0F, 1, 8, 4, 0F, -2F, 0F, -1F, 2F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, -1F, 2F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 108
		body[84].setRotationPoint(-8F, -24F, -6F);

		body[85].addBox(0F, 0F, 0F, 1, 11, 4, 0F); // Box 109
		body[85].setRotationPoint(-8F, -27F, -2F);

		body[86].addShapeBox(0F, 0F, 0F, 1, 8, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, -1F, -2F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, -1F, -2F, 0F, -1F); // Box 110
		body[86].setRotationPoint(-8F, -24F, 2F);

		body[87].addShapeBox(0F, 0F, 0F, 4, 8, 1, 0F, -1F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -2F, -1F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -2F); // Box 111
		body[87].setRotationPoint(-6F, -24F, 7F);

		body[88].addBox(0F, 0F, 0F, 4, 11, 1, 0F); // Box 112
		body[88].setRotationPoint(-2F, -27F, 7F);

		body[89].addShapeBox(0F, 0F, 0F, 4, 8, 1, 0F, -1F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 2F, -1F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 2F); // Box 113
		body[89].setRotationPoint(1F, -24F, 5F);

		body[90].addShapeBox(0F, 0F, 0F, 1, 8, 4, 0F, -2F, 0F, -1F, 2F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, -1F, 2F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 114
		body[90].setRotationPoint(5F, -24F, 1F);

		body[91].addBox(0F, 0F, 0F, 1, 11, 4, 0F); // Box 115
		body[91].setRotationPoint(7F, -27F, -2F);

		body[92].addShapeBox(0F, 0F, 0F, 1, 8, 4, 0F, 2F, 0F, -1F, -2F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, -1F, -2F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 116
		body[92].setRotationPoint(7F, -24F, -6F);

		body[93].addShapeBox(0F, 0F, 0F, 4, 8, 1, 0F, -1F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -2F, -1F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -2F); // Box 117
		body[93].setRotationPoint(1F, -24F, -6F);

		body[94].addBox(0F, 0F, 0F, 1, 19, 1, 0F); // Box 118
		body[94].setRotationPoint(-6F, -31F, -6F);

		body[95].addBox(0F, 0F, 0F, 1, 19, 1, 0F); // Box 119
		body[95].setRotationPoint(5F, -31F, -6F);

		body[96].addBox(0F, 0F, 0F, 1, 19, 1, 0F); // Box 120
		body[96].setRotationPoint(5F, -31F, 5F);

		body[97].addBox(0F, 0F, 0F, 1, 19, 1, 0F); // Box 121
		body[97].setRotationPoint(-6F, -31F, 5F);

		body[98].addBox(0F, 0F, 0F, 12, 1, 12, 0F); // Box 122
		body[98].setRotationPoint(-6F, -32F, -6F);

		body[99].addShapeBox(0F, 0F, 0F, 2, 1, 10, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F); // Box 123
		body[99].setRotationPoint(-8F, -32F, -5F);

		body[100].addShapeBox(0F, 0F, 0F, 2, 1, 10, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F); // Box 124
		body[100].setRotationPoint(6F, -32F, -5F);

		body[101].addShapeBox(0F, 0F, 0F, 10, 1, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F); // Box 125
		body[101].setRotationPoint(-5F, -32F, 6F);

		body[102].addShapeBox(0F, 0F, 0F, 10, 1, 2, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 126
		body[102].setRotationPoint(-5F, -32F, -8F);

		body[103].addBox(-2F, 0F, -2F, 4, 1, 4, 0F); // Box 135
		body[103].setRotationPoint(0F, -32.2F, 0F);

		body[104].addShapeBox(0F, 0F, 0F, 1, 6, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F); // Box 136
		body[104].setRotationPoint(7F, -14F, -2F);

		body[105].addShapeBox(0F, 0F, 0F, 2, 8, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F); // Box 137
		body[105].setRotationPoint(7F, -16F, -3F);

		body[106].addShapeBox(0F, 0F, 0F, 2, 8, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F); // Box 138
		body[106].setRotationPoint(7F, -16F, 2F);

		body[107].addShapeBox(0F, 0F, 0F, 2, 1, 2, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 139
		body[107].setRotationPoint(-11F, -10F, 1F);

		body[108].addShapeBox(0F, 0F, 0F, 2, 1, 2, 0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 140
		body[108].setRotationPoint(-11F, -10F, -3F);

		body[109].addShapeBox(0F, 0F, 0F, 2, 1, 2, 0F, -1F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 141
		body[109].setRotationPoint(-15F, -10F, -3F);

		body[110].addShapeBox(0F, 0F, 0F, 2, 1, 2, 0F, -1F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 142
		body[110].setRotationPoint(-19F, -10F, -3F);

		body[111].addShapeBox(0F, 0F, 0F, 2, 1, 2, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 143
		body[111].setRotationPoint(-15F, -10F, 1F);

		body[112].addShapeBox(0F, 0F, 0F, 2, 1, 2, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 144
		body[112].setRotationPoint(-19F, -10F, 1F);

		body[113].addShapeBox(0F, 0F, 0F, 2, 1, 2, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 145
		body[113].setRotationPoint(-23F, -10F, 1F);

		body[114].addShapeBox(0F, 0F, 0F, 2, 1, 2, 0F, -1F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 146
		body[114].setRotationPoint(-23F, -10F, -3F);

		body[115].addShapeBox(0F, 0F, 0F, 2, 1, 2, 0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 147
		body[115].setRotationPoint(-11F, -10F, -7F);

		body[116].addShapeBox(0F, 0F, 0F, 2, 1, 2, 0F, -1F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 148
		body[116].setRotationPoint(-15F, -10F, -7F);

		body[117].addShapeBox(0F, 0F, 0F, 2, 1, 2, 0F, -1F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 149
		body[117].setRotationPoint(-19F, -10F, -7F);

		body[118].addShapeBox(0F, 0F, 0F, 2, 1, 2, 0F, -1F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 150
		body[118].setRotationPoint(-23F, -10F, -7F);

		body[119].addShapeBox(0F, 0F, 0F, 2, 1, 2, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 151
		body[119].setRotationPoint(-23F, -10F, 5F);

		body[120].addShapeBox(0F, 0F, 0F, 2, 1, 2, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 152
		body[120].setRotationPoint(-19F, -10F, 5F);

		body[121].addShapeBox(0F, 0F, 0F, 2, 1, 2, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 153
		body[121].setRotationPoint(-15F, -10F, 5F);

		body[122].addShapeBox(0F, 0F, 0F, 2, 1, 2, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 154
		body[122].setRotationPoint(-11F, -10F, 5F);

		body[123].addShapeBox(0F, 0F, 0F, 1, 5, 1, 0F, -3F, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 155
		body[123].setRotationPoint(-11F, -15F, 1F);

		body[124].addBox(0F, 0F, 0F, 2, 6, 6, 0F); // Box 156
		body[124].setRotationPoint(-8.5F, -18F, -3F);

		body[125].addShapeBox(0F, 0F, 0F, 1, 5, 1, 0F, -3F, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 157
		body[125].setRotationPoint(-11F, -15F, -2F);

		body[126].addShapeBox(0F, 0F, 0F, 1, 6, 1, 0F, -6F, 0F, 0F, 6F, 0F, 0F, 6F, 0F, 0F, -6F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 158
		body[126].setRotationPoint(-14F, -16F, -2F);

		body[127].addShapeBox(0F, 0F, 0F, 1, 6, 1, 0F, -6F, 0F, 0F, 6F, 0F, 0F, 6F, 0F, 0F, -6F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 159
		body[127].setRotationPoint(-14F, -16F, 1F);

		body[128].addShapeBox(0F, 0F, 0F, 1, 7, 1, 0F, -10F, 0F, 0F, 10F, 0F, 0F, 10F, 0F, 0F, -10F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 160
		body[128].setRotationPoint(-18F, -17F, 1F);

		body[129].addShapeBox(0F, 0F, 0F, 1, 7, 1, 0F, -10F, 0F, 0F, 10F, 0F, 0F, 10F, 0F, 0F, -10F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 161
		body[129].setRotationPoint(-18F, -17F, -2F);

		body[130].addShapeBox(0F, 0F, 0F, 1, 8, 1, 0F, -14F, 0F, 0F, 14F, 0F, 0F, 14F, 0F, 0F, -14F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 162
		body[130].setRotationPoint(-22F, -18F, 1F);

		body[131].addShapeBox(0F, 0F, 0F, 1, 8, 1, 0F, -14F, 0F, 0F, 14F, 0F, 0F, 14F, 0F, 0F, -14F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 163
		body[131].setRotationPoint(-22F, -18F, -2F);

		body[132].addShapeBox(0F, 0F, 0F, 1, 5, 1, 0F, -3F, 0F, 4F, 3F, 0F, 4F, 3F, 0F, -4F, -3F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 164
		body[132].setRotationPoint(-11F, -15F, 5F);

		body[133].addShapeBox(0F, 0F, 0F, 1, 5, 1, 0F, -3F, 0F, -4F, 3F, 0F, -4F, 3F, 0F, 4F, -3F, 0F, 4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 165
		body[133].setRotationPoint(-11F, -15F, -6F);

		body[134].addShapeBox(0F, 0F, 0F, 1, 6, 1, 0F, -6F, 0F, 4F, 6F, 0F, 4F, 6F, 0F, -4F, -6F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 166
		body[134].setRotationPoint(-14F, -16F, 5F);

		body[135].addShapeBox(0F, 0F, 0F, 1, 6, 1, 0F, -6F, 0F, -4F, 6F, 0F, -4F, 6F, 0F, 4F, -6F, 0F, 4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 167
		body[135].setRotationPoint(-14F, -16F, -6F);

		body[136].addShapeBox(0F, 0F, 0F, 1, 7, 1, 0F, -10F, 0F, 4F, 10F, 0F, 4F, 10F, 0F, -4F, -10F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 168
		body[136].setRotationPoint(-18F, -17F, 5F);

		body[137].addShapeBox(0F, 0F, 0F, 1, 7, 1, 0F, -10F, 0F, -4F, 10F, 0F, -4F, 10F, 0F, 4F, -10F, 0F, 4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 169
		body[137].setRotationPoint(-18F, -17F, -6F);

		body[138].addShapeBox(0F, 0F, 0F, 1, 8, 1, 0F, -14F, 0F, 4F, 14F, 0F, 4F, 14F, 0F, -4F, -14F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 170
		body[138].setRotationPoint(-22F, -18F, 5F);

		body[139].addShapeBox(0F, 0F, 0F, 1, 8, 1, 0F, -14F, 0F, -4F, 14F, 0F, -4F, 14F, 0F, 4F, -14F, 0F, 4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 171
		body[139].setRotationPoint(-22F, -18F, -6F);


		glow = new ModelRendererTurbo[8];
		glow[0] = new ModelRendererTurbo(this, 177, 121, textureX, textureY); // Box 127
		glow[1] = new ModelRendererTurbo(this, 73, 129, textureX, textureY); // Box 128
		glow[2] = new ModelRendererTurbo(this, 113, 129, textureX, textureY); // Box 129
		glow[3] = new ModelRendererTurbo(this, 1, 137, textureX, textureY); // Box 130
		glow[4] = new ModelRendererTurbo(this, 41, 137, textureX, textureY); // Box 131
		glow[5] = new ModelRendererTurbo(this, 89, 137, textureX, textureY); // Box 132
		glow[6] = new ModelRendererTurbo(this, 129, 137, textureX, textureY); // Box 133
		glow[7] = new ModelRendererTurbo(this, 153, 137, textureX, textureY); // Box 134

		glow[0].addShapeBox(0F, 0F, 0F, 1, 3, 7, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, 2F, 0F, -0.6F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, 2F, 0F, -0.6F, 0F, 0F, 0F); // Box 127
		glow[0].setRotationPoint(0F, -27F, 0F);

		glow[1].addShapeBox(0F, 0F, 0F, 1, 3, 7, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, 2F, 0F, -0.6F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, 2F, 0F, -0.6F, 0F, 0F, 0F); // Box 128
		glow[1].setRotationPoint(0F, -27F, 0F);
		glow[1].rotateAngleY = -0.78539816F;

		glow[2].addShapeBox(0F, 0F, 0F, 1, 3, 7, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, 2F, 0F, -0.6F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, 2F, 0F, -0.6F, 0F, 0F, 0F); // Box 129
		glow[2].setRotationPoint(0F, -27F, 0F);
		glow[2].rotateAngleY = -1.57079633F;

		glow[3].addShapeBox(0F, 0F, 0F, 1, 3, 7, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, 2F, 0F, -0.6F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, 2F, 0F, -0.6F, 0F, 0F, 0F); // Box 130
		glow[3].setRotationPoint(0F, -27F, 0F);
		glow[3].rotateAngleY = -2.35619449F;

		glow[4].addShapeBox(0F, 0F, 0F, 1, 3, 7, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, 2F, 0F, -0.6F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, 2F, 0F, -0.6F, 0F, 0F, 0F); // Box 131
		glow[4].setRotationPoint(0F, -27F, 0F);
		glow[4].rotateAngleY = -3.14159265F;

		glow[5].addShapeBox(0F, 0F, 0F, 1, 3, 7, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, 2F, 0F, -0.6F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, 2F, 0F, -0.6F, 0F, 0F, 0F); // Box 132
		glow[5].setRotationPoint(0F, -27F, 0F);
		glow[5].rotateAngleY = -3.92699082F;

		glow[6].addShapeBox(0F, 0F, 0F, 1, 3, 7, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, 2F, 0F, -0.6F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, 2F, 0F, -0.6F, 0F, 0F, 0F); // Box 133
		glow[6].setRotationPoint(0F, -27F, 0F);
		glow[6].rotateAngleY = -4.71238898F;

		glow[7].addShapeBox(0F, 0F, 0F, 1, 3, 7, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, 2F, 0F, -0.6F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, 2F, 0F, -0.6F, 0F, 0F, 0F); // Box 134
		glow[7].setRotationPoint(0F, -27F, 0F);
		glow[7].rotateAngleY = -5.49778714F;


		body_colored_primary = new ModelRendererTurbo[24];
		body_colored_primary[0] = new ModelRendererTurbo(this, 241, 1, textureX, textureY); // Box 81
		body_colored_primary[1] = new ModelRendererTurbo(this, 241, 9, textureX, textureY); // Box 82
		body_colored_primary[2] = new ModelRendererTurbo(this, 241, 33, textureX, textureY); // Box 83
		body_colored_primary[3] = new ModelRendererTurbo(this, 121, 33, textureX, textureY); // Box 84
		body_colored_primary[4] = new ModelRendererTurbo(this, 241, 49, textureX, textureY); // Box 85
		body_colored_primary[5] = new ModelRendererTurbo(this, 241, 57, textureX, textureY); // Box 86
		body_colored_primary[6] = new ModelRendererTurbo(this, 241, 73, textureX, textureY); // Box 87
		body_colored_primary[7] = new ModelRendererTurbo(this, 1, 81, textureX, textureY); // Box 88
		body_colored_primary[8] = new ModelRendererTurbo(this, 25, 81, textureX, textureY); // Box 89
		body_colored_primary[9] = new ModelRendererTurbo(this, 41, 81, textureX, textureY); // Box 90
		body_colored_primary[10] = new ModelRendererTurbo(this, 241, 81, textureX, textureY); // Box 91
		body_colored_primary[11] = new ModelRendererTurbo(this, 65, 89, textureX, textureY); // Box 92
		body_colored_primary[12] = new ModelRendererTurbo(this, 89, 89, textureX, textureY); // Box 94
		body_colored_primary[13] = new ModelRendererTurbo(this, 105, 81, textureX, textureY); // Box 95
		body_colored_primary[14] = new ModelRendererTurbo(this, 145, 81, textureX, textureY); // Box 96
		body_colored_primary[15] = new ModelRendererTurbo(this, 185, 81, textureX, textureY); // Box 97
		body_colored_primary[16] = new ModelRendererTurbo(this, 129, 89, textureX, textureY); // Box 98
		body_colored_primary[17] = new ModelRendererTurbo(this, 169, 89, textureX, textureY); // Box 99
		body_colored_primary[18] = new ModelRendererTurbo(this, 89, 97, textureX, textureY); // Box 100
		body_colored_primary[19] = new ModelRendererTurbo(this, 209, 89, textureX, textureY); // Box 101
		body_colored_primary[20] = new ModelRendererTurbo(this, 233, 97, textureX, textureY); // Box 102
		body_colored_primary[21] = new ModelRendererTurbo(this, 1, 105, textureX, textureY); // Box 103
		body_colored_primary[22] = new ModelRendererTurbo(this, 105, 97, textureX, textureY); // Box 104
		body_colored_primary[23] = new ModelRendererTurbo(this, 129, 97, textureX, textureY); // Box 105

		body_colored_primary[0].addBox(0F, 0F, 0F, 4, 4, 1, 0F); // Box 81
		body_colored_primary[0].setRotationPoint(-2F, -16F, -8F);

		body_colored_primary[1].addBox(0F, 0F, 0F, 4, 4, 1, 0F); // Box 82
		body_colored_primary[1].setRotationPoint(-2F, -16F, 7F);

		body_colored_primary[2].addBox(0F, 0F, 0F, 1, 4, 4, 0F); // Box 83
		body_colored_primary[2].setRotationPoint(-8F, -16F, -2F);

		body_colored_primary[3].addBox(0F, 0F, 0F, 1, 2, 4, 0F); // Box 84
		body_colored_primary[3].setRotationPoint(7F, -14F, -2F);

		body_colored_primary[4].addShapeBox(0F, 0F, 0F, 4, 5, 1, 0F, -1F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 2F, -1F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 2F); // Box 85
		body_colored_primary[4].setRotationPoint(-6F, -16F, -8F);

		body_colored_primary[5].addShapeBox(0F, 0F, 0F, 1, 4, 4, 0F, -2F, 0F, -1F, 2F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, -1F, 2F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 86
		body_colored_primary[5].setRotationPoint(-8F, -16F, -6F);

		body_colored_primary[6].addShapeBox(0F, 0F, 0F, 4, 4, 1, 0F, -1F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -2F, -1F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -2F); // Box 87
		body_colored_primary[6].setRotationPoint(1F, -16F, -6F);

		body_colored_primary[7].addShapeBox(0F, 0F, 0F, 1, 4, 4, 0F, 2F, 0F, -1F, -2F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, -1F, -2F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 88
		body_colored_primary[7].setRotationPoint(7F, -16F, -6F);

		body_colored_primary[8].addShapeBox(0F, 0F, 0F, 1, 4, 4, 0F, -2F, 0F, -1F, 2F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, -1F, 2F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 89
		body_colored_primary[8].setRotationPoint(5F, -16F, 1F);

		body_colored_primary[9].addShapeBox(0F, 0F, 0F, 1, 4, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, -1F, -2F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, -1F, -2F, 0F, -1F); // Box 90
		body_colored_primary[9].setRotationPoint(-8F, -16F, 2F);

		body_colored_primary[10].addShapeBox(0F, 0F, 0F, 4, 4, 1, 0F, -1F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -2F, -1F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -2F); // Box 91
		body_colored_primary[10].setRotationPoint(-6F, -16F, 7F);

		body_colored_primary[11].addShapeBox(0F, 0F, 0F, 4, 4, 1, 0F, -1F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 2F, -1F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 2F); // Box 92
		body_colored_primary[11].setRotationPoint(1F, -16F, 5F);

		body_colored_primary[12].addShapeBox(0F, 0F, 0F, 4, 4, 1, 0F, -1F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 2F, -1F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 2F); // Box 94
		body_colored_primary[12].setRotationPoint(-6F, -31F, -8F);

		body_colored_primary[13].addShapeBox(0F, 0F, 0F, 1, 4, 4, 0F, -2F, 0F, -1F, 2F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, -1F, 2F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 95
		body_colored_primary[13].setRotationPoint(-8F, -31F, -6F);

		body_colored_primary[14].addBox(0F, 0F, 0F, 1, 4, 4, 0F); // Box 96
		body_colored_primary[14].setRotationPoint(-8F, -31F, -2F);

		body_colored_primary[15].addShapeBox(0F, 0F, 0F, 1, 4, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, -1F, -2F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, -1F, -2F, 0F, -1F); // Box 97
		body_colored_primary[15].setRotationPoint(-8F, -31F, 2F);

		body_colored_primary[16].addShapeBox(0F, 0F, 0F, 4, 4, 1, 0F, -1F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -2F, -1F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -2F); // Box 98
		body_colored_primary[16].setRotationPoint(-6F, -31F, 7F);

		body_colored_primary[17].addBox(0F, 0F, 0F, 4, 4, 1, 0F); // Box 99
		body_colored_primary[17].setRotationPoint(-2F, -31F, 7F);

		body_colored_primary[18].addShapeBox(0F, 0F, 0F, 4, 4, 1, 0F, -1F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 2F, -1F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 2F); // Box 100
		body_colored_primary[18].setRotationPoint(1F, -31F, 5F);

		body_colored_primary[19].addShapeBox(0F, 0F, 0F, 1, 4, 4, 0F, -2F, 0F, -1F, 2F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, -1F, 2F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 101
		body_colored_primary[19].setRotationPoint(5F, -31F, 1F);

		body_colored_primary[20].addBox(0F, 0F, 0F, 1, 4, 4, 0F); // Box 102
		body_colored_primary[20].setRotationPoint(7F, -31F, -2F);

		body_colored_primary[21].addShapeBox(0F, 0F, 0F, 1, 4, 4, 0F, 2F, 0F, -1F, -2F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, -1F, -2F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 103
		body_colored_primary[21].setRotationPoint(7F, -31F, -6F);

		body_colored_primary[22].addShapeBox(0F, 0F, 0F, 4, 4, 1, 0F, -1F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -2F, -1F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -2F); // Box 104
		body_colored_primary[22].setRotationPoint(1F, -31F, -6F);

		body_colored_primary[23].addBox(0F, 0F, 0F, 4, 4, 1, 0F); // Box 105
		body_colored_primary[23].setRotationPoint(-2F, -31F, -8F);

		translateAll(0F, 0F, 0F);
		flipAll();
	}
	
	@Override
	public void render(BlockData data, BlockTileEntity tile, Entity ent, int meta){
		render(body); data.getPrimaryColor().glColorApply(); render(body_colored_primary); RGB.glColorReset();
		//
		if(tile == null){ return; }
    	float rot = RenderCache.getData(tile.getLongPos(), "rotation", 0) + (data.getScript() == null ? 1 : data.getScript(CrafterBlockScriptBase.class).getProgress() > 0 ? 1 : 0);
    	RenderCache.updateData(tile.getLongPos(), "rotation", rot = rot > 360 ? 0 : rot < 0 ? 0 : rot);
    	for(ModelRendererTurbo model : glow){
    		model.rotateAngleY += rot * Static.rad1; model.render(); model.rotateAngleY -= rot * Static.rad1;
    	}
	}
	
}