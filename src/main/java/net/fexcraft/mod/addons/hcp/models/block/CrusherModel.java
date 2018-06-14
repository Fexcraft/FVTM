//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2018 Minecraft-SMP.de
// This file is for Fex's Vehicle and Transportation Mod

// Model: Crusher
// Model Creator: FEX___96
// Created on: 12.06.2018 - 22:28:48
// Last changed on: 12.06.2018 - 22:28:48

package net.fexcraft.mod.addons.hcp.models.block;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.addons.hcp.scripts.CrusherScript;
import net.fexcraft.mod.fvtm.api.Block.BlockData;
import net.fexcraft.mod.fvtm.api.Block.BlockTileEntity;

import net.fexcraft.mod.fvtm.model.block.BlockModel;
import net.fexcraft.mod.fvtm.util.RenderCache;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.util.common.Static;
import net.minecraft.entity.Entity;

public class CrusherModel extends BlockModel {
	
	private ModelRendererTurbo[] state = new ModelRendererTurbo[0];
	private ModelRendererTurbo[] rot = new ModelRendererTurbo[0];

	public CrusherModel(){
		this.textureX = 512; this.textureY = 256;
		this.creators.add("FEX___96");
		body = new ModelRendererTurbo[62];
		body[0] = new ModelRendererTurbo(this, 345, 1, textureX, textureY); // Box 4
		body[1] = new ModelRendererTurbo(this, 369, 1, textureX, textureY); // Box 5
		body[2] = new ModelRendererTurbo(this, 393, 1, textureX, textureY); // Box 6
		body[3] = new ModelRendererTurbo(this, 417, 1, textureX, textureY); // Box 7
		body[4] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 12
		body[5] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 13
		body[6] = new ModelRendererTurbo(this, 33, 1, textureX, textureY); // Box 14
		body[7] = new ModelRendererTurbo(this, 57, 1, textureX, textureY); // Box 15
		body[8] = new ModelRendererTurbo(this, 73, 1, textureX, textureY); // Box 16
		body[9] = new ModelRendererTurbo(this, 97, 1, textureX, textureY); // Box 17
		body[10] = new ModelRendererTurbo(this, 449, 1, textureX, textureY); // Box 18
		body[11] = new ModelRendererTurbo(this, 473, 1, textureX, textureY); // Box 19
		body[12] = new ModelRendererTurbo(this, 73, 9, textureX, textureY); // Box 20
		body[13] = new ModelRendererTurbo(this, 473, 9, textureX, textureY); // Box 21
		body[14] = new ModelRendererTurbo(this, 1, 25, textureX, textureY); // Box 22
		body[15] = new ModelRendererTurbo(this, 265, 25, textureX, textureY); // Box 23
		body[16] = new ModelRendererTurbo(this, 305, 25, textureX, textureY); // Box 24
		body[17] = new ModelRendererTurbo(this, 97, 25, textureX, textureY); // Box 25
		body[18] = new ModelRendererTurbo(this, 1, 33, textureX, textureY); // Box 26
		body[19] = new ModelRendererTurbo(this, 449, 25, textureX, textureY); // Box 27
		body[20] = new ModelRendererTurbo(this, 121, 1, textureX, textureY); // Box 28
		body[21] = new ModelRendererTurbo(this, 441, 1, textureX, textureY); // Box 29
		body[22] = new ModelRendererTurbo(this, 73, 9, textureX, textureY); // Box 30
		body[23] = new ModelRendererTurbo(this, 497, 9, textureX, textureY); // Box 31
		body[24] = new ModelRendererTurbo(this, 1, 41, textureX, textureY); // Box 213
		body[25] = new ModelRendererTurbo(this, 57, 41, textureX, textureY); // Box 214
		body[26] = new ModelRendererTurbo(this, 153, 41, textureX, textureY); // Box 215
		body[27] = new ModelRendererTurbo(this, 377, 57, textureX, textureY); // Box 216
		body[28] = new ModelRendererTurbo(this, 409, 57, textureX, textureY); // Box 217
		body[29] = new ModelRendererTurbo(this, 449, 57, textureX, textureY); // Box 218
		body[30] = new ModelRendererTurbo(this, 409, 105, textureX, textureY); // Box 219
		body[31] = new ModelRendererTurbo(this, 441, 105, textureX, textureY); // Box 220
		body[32] = new ModelRendererTurbo(this, 481, 105, textureX, textureY); // Box 221
		body[33] = new ModelRendererTurbo(this, 1, 113, textureX, textureY); // Box 222
		body[34] = new ModelRendererTurbo(this, 113, 113, textureX, textureY); // Box 223
		body[35] = new ModelRendererTurbo(this, 145, 113, textureX, textureY); // Box 224
		body[36] = new ModelRendererTurbo(this, 177, 113, textureX, textureY); // Box 225
		body[37] = new ModelRendererTurbo(this, 209, 113, textureX, textureY); // Box 226
		body[38] = new ModelRendererTurbo(this, 361, 113, textureX, textureY); // Box 227
		body[39] = new ModelRendererTurbo(this, 393, 113, textureX, textureY); // Box 228
		body[40] = new ModelRendererTurbo(this, 425, 113, textureX, textureY); // Box 229
		body[41] = new ModelRendererTurbo(this, 1, 121, textureX, textureY); // Box 230
		body[42] = new ModelRendererTurbo(this, 57, 105, textureX, textureY); // Box 231
		body[43] = new ModelRendererTurbo(this, 97, 105, textureX, textureY); // Box 232
		body[44] = new ModelRendererTurbo(this, 289, 105, textureX, textureY); // Box 233
		body[45] = new ModelRendererTurbo(this, 225, 113, textureX, textureY); // Box 234
		body[46] = new ModelRendererTurbo(this, 17, 121, textureX, textureY); // Box 235
		body[47] = new ModelRendererTurbo(this, 65, 121, textureX, textureY); // Box 236
		body[48] = new ModelRendererTurbo(this, 105, 121, textureX, textureY); // Box 237
		body[49] = new ModelRendererTurbo(this, 145, 121, textureX, textureY); // Box 238
		body[50] = new ModelRendererTurbo(this, 185, 121, textureX, textureY); // Box 239
		body[51] = new ModelRendererTurbo(this, 249, 121, textureX, textureY); // Box 240
		body[52] = new ModelRendererTurbo(this, 313, 121, textureX, textureY); // Box 241
		body[53] = new ModelRendererTurbo(this, 337, 121, textureX, textureY); // Box 242
		body[54] = new ModelRendererTurbo(this, 401, 121, textureX, textureY); // Box 243
		body[55] = new ModelRendererTurbo(this, 449, 129, textureX, textureY); // Box 244
		body[56] = new ModelRendererTurbo(this, 1, 145, textureX, textureY); // Box 245
		body[57] = new ModelRendererTurbo(this, 257, 145, textureX, textureY); // Box 221
		body[58] = new ModelRendererTurbo(this, 257, 145, textureX, textureY); // Box 222
		body[59] = new ModelRendererTurbo(this, 305, 145, textureX, textureY); // Box 223
		body[60] = new ModelRendererTurbo(this, 305, 145, textureX, textureY); // Box 224
		body[61] = new ModelRendererTurbo(this, 305, 145, textureX, textureY); // Box 225

		body[0].addBox(0F, 0F, 0F, 4, 48, 4, 0F); // Box 4
		body[0].setRotationPoint(-22F, -48F, -22F);

		body[1].addBox(0F, 0F, 0F, 4, 48, 4, 0F); // Box 5
		body[1].setRotationPoint(-22F, -48F, 18F);

		body[2].addBox(0F, 0F, 0F, 4, 48, 4, 0F); // Box 6
		body[2].setRotationPoint(18F, -48F, 18F);

		body[3].addBox(0F, 0F, 0F, 4, 48, 4, 0F); // Box 7
		body[3].setRotationPoint(18F, -48F, -22F);

		body[4].addBox(0F, 0F, 0F, 2, 20, 2, 0F); // Box 12
		body[4].setRotationPoint(-8F, -20F, -8F);

		body[5].addBox(0F, 0F, 0F, 2, 20, 2, 0F); // Box 13
		body[5].setRotationPoint(6F, -20F, -8F);

		body[6].addBox(0F, 0F, 0F, 2, 20, 2, 0F); // Box 14
		body[6].setRotationPoint(6F, -20F, 6F);

		body[7].addBox(0F, 0F, 0F, 2, 20, 2, 0F); // Box 15
		body[7].setRotationPoint(-8F, -20F, 6F);

		body[8].addBox(0F, 0F, 0F, 15, 3, 3, 0F); // Box 16
		body[8].setRotationPoint(-9F, -23F, -9F);

		body[9].addBox(0F, 0F, 0F, 3, 3, 15, 0F); // Box 17
		body[9].setRotationPoint(-9F, -23F, -6F);

		body[10].addBox(0F, 0F, 0F, 3, 3, 15, 0F); // Box 18
		body[10].setRotationPoint(6F, -23F, -9F);

		body[11].addBox(0F, 0F, 0F, 15, 3, 3, 0F); // Box 19
		body[11].setRotationPoint(-6F, -23F, 6F);

		body[12].addShapeBox(0F, 0F, 0F, 2, 4, 14, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -13F, 0F, 0F, 13F, 0F, 0F, 13F, 0F, 0F, -13F, 0F, 0F); // Box 20
		body[12].setRotationPoint(-22F, -40F, -7F);

		body[13].addShapeBox(0F, 0F, 0F, 2, 4, 14, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 13F, 0F, 0F, -13F, 0F, 0F, -13F, 0F, 0F, 13F, 0F, 0F); // Box 21
		body[13].setRotationPoint(20F, -40F, -7F);

		body[14].addShapeBox(0F, 0F, 0F, 14, 4, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -13F, 0F, 0F, -13F, 0F, 0F, 13F, 0F, 0F, 13F); // Box 22
		body[14].setRotationPoint(-7F, -40F, -22F);

		body[15].addShapeBox(0F, 0F, 0F, 14, 4, 2, 0F, 0F, 0F, -13F, 0F, 0F, -13F, 0F, 0F, 13F, 0F, 0F, 13F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 23
		body[15].setRotationPoint(-7F, -40F, 7F);

		body[16].addBox(0F, 0F, 0F, 15, 3, 3, 0F); // Box 24
		body[16].setRotationPoint(-6F, -36F, 6F);

		body[17].addBox(0F, 0F, 0F, 3, 3, 15, 0F); // Box 25
		body[17].setRotationPoint(6F, -36F, -9F);

		body[18].addBox(0F, 0F, 0F, 15, 3, 3, 0F); // Box 26
		body[18].setRotationPoint(-9F, -36F, -9F);

		body[19].addBox(0F, 0F, 0F, 3, 3, 15, 0F); // Box 27
		body[19].setRotationPoint(-9F, -36F, -6F);

		body[20].addBox(0F, 0F, 0F, 3, 10, 3, 0F); // Box 28
		body[20].setRotationPoint(-9F, -33F, -9F);

		body[21].addBox(0F, 0F, 0F, 3, 10, 3, 0F); // Box 29
		body[21].setRotationPoint(6F, -33F, -9F);

		body[22].addBox(0F, 0F, 0F, 3, 10, 3, 0F); // Box 30
		body[22].setRotationPoint(-9F, -33F, 6F);

		body[23].addBox(0F, 0F, 0F, 3, 10, 3, 0F); // Box 31
		body[23].setRotationPoint(6F, -33F, 6F);

		body[24].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 213
		body[24].setRotationPoint(-6F, -32.5F, -9F);

		body[25].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 214
		body[25].setRotationPoint(-6F, -31.5F, -9F);

		body[26].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 215
		body[26].setRotationPoint(-6F, -30.5F, -9F);

		body[27].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 216
		body[27].setRotationPoint(-6F, -29.5F, -9F);

		body[28].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 217
		body[28].setRotationPoint(-6F, -28.5F, -9F);

		body[29].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 218
		body[29].setRotationPoint(-6F, -27.5F, -9F);

		body[30].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 219
		body[30].setRotationPoint(-6F, -26.5F, -9F);

		body[31].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 220
		body[31].setRotationPoint(-6F, -25.5F, -9F);

		body[32].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 221
		body[32].setRotationPoint(-6F, -24.5F, -9F);

		body[33].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 222
		body[33].setRotationPoint(-6F, -32.5F, 8F);

		body[34].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 223
		body[34].setRotationPoint(-6F, -31.5F, 8F);

		body[35].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 224
		body[35].setRotationPoint(-6F, -30.5F, 8F);

		body[36].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 225
		body[36].setRotationPoint(-6F, -29.5F, 8F);

		body[37].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 226
		body[37].setRotationPoint(-6F, -28.5F, 8F);

		body[38].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 227
		body[38].setRotationPoint(-6F, -27.5F, 8F);

		body[39].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 228
		body[39].setRotationPoint(-6F, -26.5F, 8F);

		body[40].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 229
		body[40].setRotationPoint(-6F, -25.5F, 8F);

		body[41].addShapeBox(0F, 0F, 0F, 12, 1, 1, 0F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 230
		body[41].setRotationPoint(-6F, -24.5F, 8F);

		body[42].addBox(0F, 0F, 0F, 0, 10, 12, 0F); // Box 231
		body[42].setRotationPoint(8F, -33F, -6F);

		body[43].addBox(0F, 0F, 0F, 0, 10, 12, 0F); // Box 232
		body[43].setRotationPoint(-8F, -33F, -6F);

		body[44].addShapeBox(-0.5F, -0.5F, 0F, 1, 1, 18, 0F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F); // Box 233
		body[44].setRotationPoint(0F, -24F, -9F);

		body[45].addShapeBox(-0.5F, -0.5F, 0F, 1, 1, 18, 0F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F); // Box 234
		body[45].setRotationPoint(4F, -24F, -9F);

		body[46].addShapeBox(-0.5F, -0.5F, 0F, 1, 1, 18, 0F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F); // Box 235
		body[46].setRotationPoint(-4F, -24F, -9F);

		body[47].addShapeBox(-0.5F, -0.5F, 0F, 1, 1, 18, 0F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F); // Box 236
		body[47].setRotationPoint(-4F, -28F, -9F);

		body[48].addShapeBox(-0.5F, -0.5F, 0F, 1, 1, 18, 0F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F); // Box 237
		body[48].setRotationPoint(0F, -28F, -9F);

		body[49].addShapeBox(-0.5F, -0.5F, 0F, 1, 1, 18, 0F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F); // Box 238
		body[49].setRotationPoint(4F, -28F, -9F);

		body[50].addShapeBox(-0.5F, -0.5F, 0F, 1, 1, 18, 0F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F); // Box 239
		body[50].setRotationPoint(4F, -32F, -9F);

		body[51].addShapeBox(-0.5F, -0.5F, 0F, 1, 1, 18, 0F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F); // Box 240
		body[51].setRotationPoint(0F, -32F, -9F);

		body[52].addShapeBox(-0.5F, -0.5F, 0F, 1, 1, 18, 0F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F, -0.1F); // Box 241
		body[52].setRotationPoint(-4F, -32F, -9F);

		body[53].addShapeBox(0F, 0F, 0F, 15, 1, 15, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 5F, 0F); // Box 242
		body[53].setRotationPoint(7F, -41F, -22F);

		body[54].addShapeBox(0F, 0F, 0F, 15, 1, 15, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 5F, 0F, 0F, 0F, 0F); // Box 243
		body[54].setRotationPoint(-22F, -41F, -22F);

		body[55].addShapeBox(0F, 0F, 0F, 15, 1, 15, 0F, 0F, 0F, 0F, 0F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 244
		body[55].setRotationPoint(-22F, -41F, 7F);

		body[56].addShapeBox(0F, 0F, 0F, 15, 1, 15, 0F, 0F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 245
		body[56].setRotationPoint(7F, -41F, 7F);

		body[57].addBox(0F, 0F, 0F, 44, 2, 1, 0F); // Box 221
		body[57].setRotationPoint(-22F, -18F, 22F);

		body[58].addBox(0F, 0F, 0F, 44, 2, 1, 0F); // Box 222
		body[58].setRotationPoint(-22F, -18F, -23F);

		body[59].addBox(0F, 0F, 0F, 1, 2, 44, 0F); // Box 223
		body[59].setRotationPoint(-23F, -18F, -22F);

		body[60].addBox(0F, 0F, 0F, 1, 2, 44, 0F); // Box 224
		body[60].setRotationPoint(22F, -18F, -22F);

		body[61].addBox(0F, 0F, 0F, 1, 2, 44, 0F); // Box 225
		body[61].setRotationPoint(22F, -18F, -22F);


		body_colored_primary = new ModelRendererTurbo[8];
		body_colored_primary[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
		body_colored_primary[1] = new ModelRendererTurbo(this, 97, 1, textureX, textureY); // Box 1
		body_colored_primary[2] = new ModelRendererTurbo(this, 153, 1, textureX, textureY); // Box 2
		body_colored_primary[3] = new ModelRendererTurbo(this, 249, 1, textureX, textureY); // Box 3
		body_colored_primary[4] = new ModelRendererTurbo(this, 393, 17, textureX, textureY); // Box 8
		body_colored_primary[5] = new ModelRendererTurbo(this, 153, 25, textureX, textureY); // Box 9
		body_colored_primary[6] = new ModelRendererTurbo(this, 209, 25, textureX, textureY); // Box 10
		body_colored_primary[7] = new ModelRendererTurbo(this, 265, 57, textureX, textureY); // Box 11

		body_colored_primary[0].addBox(0F, 0F, 0F, 2, 16, 44, 0F); // Box 0
		body_colored_primary[0].setRotationPoint(-24F, -16F, -22F);

		body_colored_primary[1].addBox(0F, 0F, 0F, 2, 16, 44, 0F); // Box 1
		body_colored_primary[1].setRotationPoint(22F, -16F, -22F);

		body_colored_primary[2].addBox(0F, 0F, 0F, 44, 16, 2, 0F); // Box 2
		body_colored_primary[2].setRotationPoint(-22F, -16F, -24F);

		body_colored_primary[3].addBox(0F, 0F, 0F, 44, 16, 2, 0F); // Box 3
		body_colored_primary[3].setRotationPoint(-22F, -16F, 22F);

		body_colored_primary[4].addBox(0F, 0F, 0F, 2, 8, 44, 0F); // Box 8
		body_colored_primary[4].setRotationPoint(22F, -48F, -22F);

		body_colored_primary[5].addBox(0F, 0F, 0F, 44, 8, 2, 0F); // Box 9
		body_colored_primary[5].setRotationPoint(-22F, -48F, -24F);

		body_colored_primary[6].addBox(0F, 0F, 0F, 2, 8, 44, 0F); // Box 10
		body_colored_primary[6].setRotationPoint(-24F, -48F, -22F);

		body_colored_primary[7].addBox(0F, 0F, 0F, 44, 8, 2, 0F); // Box 11
		body_colored_primary[7].setRotationPoint(-22F, -48F, 22F);


		state = new ModelRendererTurbo[3];
		state[0] = new ModelRendererTurbo(this, 25, 145, textureX, textureY); // Box 218
		state[1] = new ModelRendererTurbo(this, 161, 145, textureX, textureY); // Box 219
		state[2] = new ModelRendererTurbo(this, 217, 145, textureX, textureY); // Box 220

		state[0].addBox(0F, -0.5F, 0F, 44, 1, 44, 0F); // Box 218
		state[0].setRotationPoint(-22F, 0F, -22F);

		state[1].addShapeBox(0F, -0.5F, 0F, 12, 4, 12, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 4F, 0F, 0F, 4F, 0F, 0F, 4F, 0F, 0F, 4F, 0F, 0F); // Box 219
		state[1].setRotationPoint(-6F, -4F, -6F);

		state[2].addShapeBox(0F, -0.5F, 0F, 12, 4, 12, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 4F, 0F, 0F, 4F, 0F, 0F, 4F, 0F, 0F, 4F); // Box 220
		state[2].setRotationPoint(-6F, -4F, -6F);


		rot = new ModelRendererTurbo[153];
		rot[0] = new ModelRendererTurbo(this, 265, 33, textureX, textureY); // Box 38
		rot[1] = new ModelRendererTurbo(this, 305, 33, textureX, textureY); // Box 39
		rot[2] = new ModelRendererTurbo(this, 473, 33, textureX, textureY); // Box 40
		rot[3] = new ModelRendererTurbo(this, 97, 9, textureX, textureY); // Box 53
		rot[4] = new ModelRendererTurbo(this, 473, 9, textureX, textureY); // Box 55
		rot[5] = new ModelRendererTurbo(this, 57, 25, textureX, textureY); // Box 65
		rot[6] = new ModelRendererTurbo(this, 121, 25, textureX, textureY); // Box 66
		rot[7] = new ModelRendererTurbo(this, 449, 25, textureX, textureY); // Box 67
		rot[8] = new ModelRendererTurbo(this, 57, 33, textureX, textureY); // Box 68
		rot[9] = new ModelRendererTurbo(this, 73, 33, textureX, textureY); // Box 69
		rot[10] = new ModelRendererTurbo(this, 89, 33, textureX, textureY); // Box 70
		rot[11] = new ModelRendererTurbo(this, 121, 33, textureX, textureY); // Box 71
		rot[12] = new ModelRendererTurbo(this, 265, 33, textureX, textureY); // Box 72
		rot[13] = new ModelRendererTurbo(this, 289, 33, textureX, textureY); // Box 73
		rot[14] = new ModelRendererTurbo(this, 305, 33, textureX, textureY); // Box 74
		rot[15] = new ModelRendererTurbo(this, 329, 33, textureX, textureY); // Box 75
		rot[16] = new ModelRendererTurbo(this, 449, 33, textureX, textureY); // Box 76
		rot[17] = new ModelRendererTurbo(this, 193, 41, textureX, textureY); // Box 77
		rot[18] = new ModelRendererTurbo(this, 217, 49, textureX, textureY); // Box 78
		rot[19] = new ModelRendererTurbo(this, 345, 57, textureX, textureY); // Box 79
		rot[20] = new ModelRendererTurbo(this, 473, 33, textureX, textureY); // Box 80
		rot[21] = new ModelRendererTurbo(this, 497, 33, textureX, textureY); // Box 81
		rot[22] = new ModelRendererTurbo(this, 193, 41, textureX, textureY); // Box 82
		rot[23] = new ModelRendererTurbo(this, 217, 41, textureX, textureY); // Box 83
		rot[24] = new ModelRendererTurbo(this, 233, 41, textureX, textureY); // Box 84
		rot[25] = new ModelRendererTurbo(this, 265, 41, textureX, textureY); // Box 85
		rot[26] = new ModelRendererTurbo(this, 289, 41, textureX, textureY); // Box 86
		rot[27] = new ModelRendererTurbo(this, 305, 41, textureX, textureY); // Box 87
		rot[28] = new ModelRendererTurbo(this, 329, 41, textureX, textureY); // Box 88
		rot[29] = new ModelRendererTurbo(this, 497, 41, textureX, textureY); // Box 89
		rot[30] = new ModelRendererTurbo(this, 193, 49, textureX, textureY); // Box 90
		rot[31] = new ModelRendererTurbo(this, 217, 49, textureX, textureY); // Box 91
		rot[32] = new ModelRendererTurbo(this, 241, 49, textureX, textureY); // Box 92
		rot[33] = new ModelRendererTurbo(this, 449, 49, textureX, textureY); // Box 93
		rot[34] = new ModelRendererTurbo(this, 473, 57, textureX, textureY); // Box 94
		rot[35] = new ModelRendererTurbo(this, 1, 65, textureX, textureY); // Box 95
		rot[36] = new ModelRendererTurbo(this, 41, 65, textureX, textureY); // Box 96
		rot[37] = new ModelRendererTurbo(this, 241, 57, textureX, textureY); // Box 97
		rot[38] = new ModelRendererTurbo(this, 369, 57, textureX, textureY); // Box 98
		rot[39] = new ModelRendererTurbo(this, 497, 57, textureX, textureY); // Box 99
		rot[40] = new ModelRendererTurbo(this, 1, 65, textureX, textureY); // Box 100
		rot[41] = new ModelRendererTurbo(this, 25, 65, textureX, textureY); // Box 101
		rot[42] = new ModelRendererTurbo(this, 41, 65, textureX, textureY); // Box 102
		rot[43] = new ModelRendererTurbo(this, 65, 65, textureX, textureY); // Box 103
		rot[44] = new ModelRendererTurbo(this, 81, 65, textureX, textureY); // Box 104
		rot[45] = new ModelRendererTurbo(this, 97, 65, textureX, textureY); // Box 105
		rot[46] = new ModelRendererTurbo(this, 113, 65, textureX, textureY); // Box 106
		rot[47] = new ModelRendererTurbo(this, 129, 65, textureX, textureY); // Box 107
		rot[48] = new ModelRendererTurbo(this, 145, 65, textureX, textureY); // Box 108
		rot[49] = new ModelRendererTurbo(this, 161, 65, textureX, textureY); // Box 109
		rot[50] = new ModelRendererTurbo(this, 177, 65, textureX, textureY); // Box 110
		rot[51] = new ModelRendererTurbo(this, 177, 65, textureX, textureY); // Box 111
		rot[52] = new ModelRendererTurbo(this, 369, 65, textureX, textureY); // Box 112
		rot[53] = new ModelRendererTurbo(this, 65, 73, textureX, textureY); // Box 113
		rot[54] = new ModelRendererTurbo(this, 369, 65, textureX, textureY); // Box 114
		rot[55] = new ModelRendererTurbo(this, 497, 65, textureX, textureY); // Box 115
		rot[56] = new ModelRendererTurbo(this, 1, 73, textureX, textureY); // Box 116
		rot[57] = new ModelRendererTurbo(this, 25, 73, textureX, textureY); // Box 117
		rot[58] = new ModelRendererTurbo(this, 41, 73, textureX, textureY); // Box 118
		rot[59] = new ModelRendererTurbo(this, 65, 73, textureX, textureY); // Box 119
		rot[60] = new ModelRendererTurbo(this, 89, 73, textureX, textureY); // Box 120
		rot[61] = new ModelRendererTurbo(this, 105, 73, textureX, textureY); // Box 121
		rot[62] = new ModelRendererTurbo(this, 121, 73, textureX, textureY); // Box 122
		rot[63] = new ModelRendererTurbo(this, 137, 73, textureX, textureY); // Box 123
		rot[64] = new ModelRendererTurbo(this, 153, 73, textureX, textureY); // Box 124
		rot[65] = new ModelRendererTurbo(this, 169, 73, textureX, textureY); // Box 125
		rot[66] = new ModelRendererTurbo(this, 305, 73, textureX, textureY); // Box 126
		rot[67] = new ModelRendererTurbo(this, 321, 73, textureX, textureY); // Box 127
		rot[68] = new ModelRendererTurbo(this, 321, 73, textureX, textureY); // Box 128
		rot[69] = new ModelRendererTurbo(this, 393, 73, textureX, textureY); // Box 129
		rot[70] = new ModelRendererTurbo(this, 433, 73, textureX, textureY); // Box 130
		rot[71] = new ModelRendererTurbo(this, 393, 73, textureX, textureY); // Box 131
		rot[72] = new ModelRendererTurbo(this, 417, 73, textureX, textureY); // Box 132
		rot[73] = new ModelRendererTurbo(this, 433, 73, textureX, textureY); // Box 133
		rot[74] = new ModelRendererTurbo(this, 457, 73, textureX, textureY); // Box 134
		rot[75] = new ModelRendererTurbo(this, 89, 81, textureX, textureY); // Box 135
		rot[76] = new ModelRendererTurbo(this, 105, 81, textureX, textureY); // Box 136
		rot[77] = new ModelRendererTurbo(this, 121, 81, textureX, textureY); // Box 137
		rot[78] = new ModelRendererTurbo(this, 137, 81, textureX, textureY); // Box 138
		rot[79] = new ModelRendererTurbo(this, 153, 81, textureX, textureY); // Box 139
		rot[80] = new ModelRendererTurbo(this, 217, 81, textureX, textureY); // Box 140
		rot[81] = new ModelRendererTurbo(this, 233, 81, textureX, textureY); // Box 141
		rot[82] = new ModelRendererTurbo(this, 249, 81, textureX, textureY); // Box 142
		rot[83] = new ModelRendererTurbo(this, 265, 81, textureX, textureY); // Box 143
		rot[84] = new ModelRendererTurbo(this, 281, 81, textureX, textureY); // Box 144
		rot[85] = new ModelRendererTurbo(this, 153, 81, textureX, textureY); // Box 145
		rot[86] = new ModelRendererTurbo(this, 281, 81, textureX, textureY); // Box 146
		rot[87] = new ModelRendererTurbo(this, 345, 81, textureX, textureY); // Box 147
		rot[88] = new ModelRendererTurbo(this, 305, 81, textureX, textureY); // Box 148
		rot[89] = new ModelRendererTurbo(this, 321, 81, textureX, textureY); // Box 149
		rot[90] = new ModelRendererTurbo(this, 345, 81, textureX, textureY); // Box 150
		rot[91] = new ModelRendererTurbo(this, 417, 81, textureX, textureY); // Box 151
		rot[92] = new ModelRendererTurbo(this, 433, 81, textureX, textureY); // Box 152
		rot[93] = new ModelRendererTurbo(this, 457, 81, textureX, textureY); // Box 153
		rot[94] = new ModelRendererTurbo(this, 473, 81, textureX, textureY); // Box 154
		rot[95] = new ModelRendererTurbo(this, 489, 81, textureX, textureY); // Box 155
		rot[96] = new ModelRendererTurbo(this, 1, 89, textureX, textureY); // Box 156
		rot[97] = new ModelRendererTurbo(this, 17, 89, textureX, textureY); // Box 157
		rot[98] = new ModelRendererTurbo(this, 33, 89, textureX, textureY); // Box 158
		rot[99] = new ModelRendererTurbo(this, 49, 89, textureX, textureY); // Box 159
		rot[100] = new ModelRendererTurbo(this, 105, 89, textureX, textureY); // Box 160
		rot[101] = new ModelRendererTurbo(this, 121, 89, textureX, textureY); // Box 161
		rot[102] = new ModelRendererTurbo(this, 121, 89, textureX, textureY); // Box 162
		rot[103] = new ModelRendererTurbo(this, 177, 89, textureX, textureY); // Box 163
		rot[104] = new ModelRendererTurbo(this, 217, 89, textureX, textureY); // Box 164
		rot[105] = new ModelRendererTurbo(this, 145, 89, textureX, textureY); // Box 165
		rot[106] = new ModelRendererTurbo(this, 177, 89, textureX, textureY); // Box 166
		rot[107] = new ModelRendererTurbo(this, 201, 89, textureX, textureY); // Box 167
		rot[108] = new ModelRendererTurbo(this, 217, 89, textureX, textureY); // Box 168
		rot[109] = new ModelRendererTurbo(this, 241, 89, textureX, textureY); // Box 169
		rot[110] = new ModelRendererTurbo(this, 257, 89, textureX, textureY); // Box 170
		rot[111] = new ModelRendererTurbo(this, 273, 89, textureX, textureY); // Box 171
		rot[112] = new ModelRendererTurbo(this, 305, 89, textureX, textureY); // Box 172
		rot[113] = new ModelRendererTurbo(this, 369, 89, textureX, textureY); // Box 173
		rot[114] = new ModelRendererTurbo(this, 473, 89, textureX, textureY); // Box 174
		rot[115] = new ModelRendererTurbo(this, 489, 89, textureX, textureY); // Box 175
		rot[116] = new ModelRendererTurbo(this, 1, 97, textureX, textureY); // Box 176
		rot[117] = new ModelRendererTurbo(this, 17, 97, textureX, textureY); // Box 177
		rot[118] = new ModelRendererTurbo(this, 33, 97, textureX, textureY); // Box 178
		rot[119] = new ModelRendererTurbo(this, 369, 89, textureX, textureY); // Box 179
		rot[120] = new ModelRendererTurbo(this, 33, 97, textureX, textureY); // Box 180
		rot[121] = new ModelRendererTurbo(this, 73, 97, textureX, textureY); // Box 181
		rot[122] = new ModelRendererTurbo(this, 57, 97, textureX, textureY); // Box 182
		rot[123] = new ModelRendererTurbo(this, 73, 97, textureX, textureY); // Box 183
		rot[124] = new ModelRendererTurbo(this, 97, 97, textureX, textureY); // Box 184
		rot[125] = new ModelRendererTurbo(this, 113, 97, textureX, textureY); // Box 185
		rot[126] = new ModelRendererTurbo(this, 201, 97, textureX, textureY); // Box 186
		rot[127] = new ModelRendererTurbo(this, 217, 97, textureX, textureY); // Box 187
		rot[128] = new ModelRendererTurbo(this, 241, 97, textureX, textureY); // Box 188
		rot[129] = new ModelRendererTurbo(this, 257, 97, textureX, textureY); // Box 189
		rot[130] = new ModelRendererTurbo(this, 321, 97, textureX, textureY); // Box 190
		rot[131] = new ModelRendererTurbo(this, 393, 97, textureX, textureY); // Box 191
		rot[132] = new ModelRendererTurbo(this, 409, 97, textureX, textureY); // Box 192
		rot[133] = new ModelRendererTurbo(this, 425, 97, textureX, textureY); // Box 193
		rot[134] = new ModelRendererTurbo(this, 441, 97, textureX, textureY); // Box 194
		rot[135] = new ModelRendererTurbo(this, 457, 97, textureX, textureY); // Box 195
		rot[136] = new ModelRendererTurbo(this, 257, 97, textureX, textureY); // Box 196
		rot[137] = new ModelRendererTurbo(this, 321, 97, textureX, textureY); // Box 197
		rot[138] = new ModelRendererTurbo(this, 457, 97, textureX, textureY); // Box 198
		rot[139] = new ModelRendererTurbo(this, 481, 97, textureX, textureY); // Box 199
		rot[140] = new ModelRendererTurbo(this, 497, 97, textureX, textureY); // Box 200
		rot[141] = new ModelRendererTurbo(this, 1, 105, textureX, textureY); // Box 201
		rot[142] = new ModelRendererTurbo(this, 17, 105, textureX, textureY); // Box 202
		rot[143] = new ModelRendererTurbo(this, 33, 105, textureX, textureY); // Box 203
		rot[144] = new ModelRendererTurbo(this, 57, 105, textureX, textureY); // Box 204
		rot[145] = new ModelRendererTurbo(this, 73, 105, textureX, textureY); // Box 205
		rot[146] = new ModelRendererTurbo(this, 97, 105, textureX, textureY); // Box 206
		rot[147] = new ModelRendererTurbo(this, 161, 105, textureX, textureY); // Box 207
		rot[148] = new ModelRendererTurbo(this, 257, 105, textureX, textureY); // Box 208
		rot[149] = new ModelRendererTurbo(this, 281, 105, textureX, textureY); // Box 209
		rot[150] = new ModelRendererTurbo(this, 297, 105, textureX, textureY); // Box 210
		rot[151] = new ModelRendererTurbo(this, 313, 105, textureX, textureY); // Box 211
		rot[152] = new ModelRendererTurbo(this, 345, 105, textureX, textureY); // Box 212

		rot[0].addShapeBox(0.5F, -1.5F, 0F, 1, 3, 16, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 38
		rot[0].setRotationPoint(0F, -24F, -8F);

		rot[1].addBox(-0.5F, -1.5F, 0F, 1, 3, 16, 0F); // Box 39
		rot[1].setRotationPoint(0F, -24F, -8F);

		rot[2].addShapeBox(-1.5F, -1.5F, 0F, 1, 3, 16, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 40
		rot[2].setRotationPoint(0F, -24F, -8F);

		rot[3].addBox(-0.5F, -1.8F, 1F, 1, 1, 3, 0F); // Box 53
		rot[3].setRotationPoint(0F, -24F, -8F);
		rot[3].rotateAngleZ = 0.78539816F;

		rot[4].addBox(-0.5F, -1.8F, 5.5F, 1, 1, 3, 0F); // Box 55
		rot[4].setRotationPoint(0F, -24F, -7F);
		rot[4].rotateAngleZ = -0.78539816F;

		rot[5].addBox(-0.5F, -1.8F, 3F, 1, 1, 3, 0F); // Box 65
		rot[5].setRotationPoint(0F, -24F, -8F);
		rot[5].rotateAngleZ = 0.26179939F;

		rot[6].addBox(-0.5F, -1.8F, 5F, 1, 1, 3, 0F); // Box 66
		rot[6].setRotationPoint(0F, -24F, -8F);
		rot[6].rotateAngleZ = -0.26179939F;

		rot[7].addBox(-0.5F, -1.8F, 7F, 1, 1, 3, 0F); // Box 67
		rot[7].setRotationPoint(0F, -24F, -7F);
		rot[7].rotateAngleZ = -1.30899694F;

		rot[8].addBox(-0.5F, -1.8F, 9F, 1, 1, 3, 0F); // Box 68
		rot[8].setRotationPoint(0F, -24F, -7F);
		rot[8].rotateAngleZ = -1.83259571F;

		rot[9].addBox(-0.5F, -1.8F, 11F, 1, 1, 3, 0F); // Box 69
		rot[9].setRotationPoint(0F, -24F, -7F);
		rot[9].rotateAngleZ = -2.35619449F;

		rot[10].addBox(-0.5F, 0.800000000000001F, 11F, 1, 1, 3, 0F); // Box 70
		rot[10].setRotationPoint(0F, -24F, -7F);
		rot[10].rotateAngleZ = -2.35619449F;

		rot[11].addBox(-0.5F, 0.800000000000001F, 9F, 1, 1, 3, 0F); // Box 71
		rot[11].setRotationPoint(0F, -24F, -7F);
		rot[11].rotateAngleZ = -1.83259571F;

		rot[12].addBox(-0.5F, 0.800000000000001F, 7F, 1, 1, 3, 0F); // Box 72
		rot[12].setRotationPoint(0F, -24F, -7F);
		rot[12].rotateAngleZ = -1.30899694F;

		rot[13].addBox(-0.5F, 0.800000000000001F, 5.5F, 1, 1, 3, 0F); // Box 73
		rot[13].setRotationPoint(0F, -24F, -7F);
		rot[13].rotateAngleZ = -0.78539816F;

		rot[14].addBox(-0.5F, 0.800000000000001F, 4F, 1, 1, 3, 0F); // Box 74
		rot[14].setRotationPoint(0F, -24F, -7F);
		rot[14].rotateAngleZ = -0.26179939F;

		rot[15].addBox(-0.5F, 0.800000000000001F, 2F, 1, 1, 3, 0F); // Box 75
		rot[15].setRotationPoint(0F, -24F, -7F);
		rot[15].rotateAngleZ = 0.26179939F;

		rot[16].addBox(-0.5F, 0.800000000000001F, 0F, 1, 1, 3, 0F); // Box 76
		rot[16].setRotationPoint(0F, -24F, -7F);
		rot[16].rotateAngleZ = 0.78539816F;

		rot[17].addShapeBox(0.5F, -1.5F, 0F, 1, 3, 16, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 77
		rot[17].setRotationPoint(-4F, -24F, -8F);

		rot[18].addBox(-0.5F, -1.5F, 0F, 1, 3, 16, 0F); // Box 78
		rot[18].setRotationPoint(-4F, -24F, -8F);

		rot[19].addShapeBox(-1.5F, -1.5F, 0F, 1, 3, 16, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 79
		rot[19].setRotationPoint(-4F, -24F, -8F);

		rot[20].addBox(-0.5F, -1.8F, 1F, 1, 1, 3, 0F); // Box 80
		rot[20].setRotationPoint(-4F, -24F, -8F);
		rot[20].rotateAngleZ = 0.78539816F;

		rot[21].addBox(-0.5F, -1.8F, 5.5F, 1, 1, 3, 0F); // Box 81
		rot[21].setRotationPoint(-4F, -24F, -7F);
		rot[21].rotateAngleZ = -0.78539816F;

		rot[22].addBox(-0.5F, -1.8F, 3F, 1, 1, 3, 0F); // Box 82
		rot[22].setRotationPoint(-4F, -24F, -8F);
		rot[22].rotateAngleZ = 0.26179939F;

		rot[23].addBox(-0.5F, -1.8F, 5F, 1, 1, 3, 0F); // Box 83
		rot[23].setRotationPoint(-4F, -24F, -8F);
		rot[23].rotateAngleZ = -0.26179939F;

		rot[24].addBox(-0.5F, -1.8F, 7F, 1, 1, 3, 0F); // Box 84
		rot[24].setRotationPoint(-4F, -24F, -7F);
		rot[24].rotateAngleZ = -1.30899694F;

		rot[25].addBox(-0.5F, -1.8F, 9F, 1, 1, 3, 0F); // Box 85
		rot[25].setRotationPoint(-4F, -24F, -7F);
		rot[25].rotateAngleZ = -1.83259571F;

		rot[26].addBox(-0.5F, -1.8F, 11F, 1, 1, 3, 0F); // Box 86
		rot[26].setRotationPoint(-4F, -24F, -7F);
		rot[26].rotateAngleZ = -2.35619449F;

		rot[27].addBox(-0.5F, 0.800000000000001F, 11F, 1, 1, 3, 0F); // Box 87
		rot[27].setRotationPoint(-4F, -24F, -7F);
		rot[27].rotateAngleZ = -2.35619449F;

		rot[28].addBox(-0.5F, 0.800000000000001F, 9F, 1, 1, 3, 0F); // Box 88
		rot[28].setRotationPoint(-4F, -24F, -7F);
		rot[28].rotateAngleZ = -1.83259571F;

		rot[29].addBox(-0.5F, 0.800000000000001F, 7F, 1, 1, 3, 0F); // Box 89
		rot[29].setRotationPoint(-4F, -24F, -7F);
		rot[29].rotateAngleZ = -1.30899694F;

		rot[30].addBox(-0.5F, 0.800000000000001F, 5.5F, 1, 1, 3, 0F); // Box 90
		rot[30].setRotationPoint(-4F, -24F, -7F);
		rot[30].rotateAngleZ = -0.78539816F;

		rot[31].addBox(-0.5F, 0.800000000000001F, 4F, 1, 1, 3, 0F); // Box 91
		rot[31].setRotationPoint(-4F, -24F, -7F);
		rot[31].rotateAngleZ = -0.26179939F;

		rot[32].addBox(-0.5F, 0.800000000000001F, 2F, 1, 1, 3, 0F); // Box 92
		rot[32].setRotationPoint(-4F, -24F, -7F);
		rot[32].rotateAngleZ = 0.26179939F;

		rot[33].addBox(-0.5F, 0.800000000000001F, 0F, 1, 1, 3, 0F); // Box 93
		rot[33].setRotationPoint(-4F, -24F, -7F);
		rot[33].rotateAngleZ = 0.78539816F;

		rot[34].addShapeBox(0.5F, -1.5F, 0F, 1, 3, 16, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 94
		rot[34].setRotationPoint(4F, -24F, -8F);

		rot[35].addBox(-0.5F, -1.5F, 0F, 1, 3, 16, 0F); // Box 95
		rot[35].setRotationPoint(4F, -24F, -8F);

		rot[36].addShapeBox(-1.5F, -1.5F, 0F, 1, 3, 16, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 96
		rot[36].setRotationPoint(4F, -24F, -8F);

		rot[37].addBox(-0.5F, -1.8F, 1F, 1, 1, 3, 0F); // Box 97
		rot[37].setRotationPoint(4F, -24F, -8F);
		rot[37].rotateAngleZ = 0.78539816F;

		rot[38].addBox(-0.5F, -1.8F, 5.5F, 1, 1, 3, 0F); // Box 98
		rot[38].setRotationPoint(4F, -24F, -7F);
		rot[38].rotateAngleZ = -0.78539816F;

		rot[39].addBox(-0.5F, -1.8F, 3F, 1, 1, 3, 0F); // Box 99
		rot[39].setRotationPoint(4F, -24F, -8F);
		rot[39].rotateAngleZ = 0.26179939F;

		rot[40].addBox(-0.5F, -1.8F, 5F, 1, 1, 3, 0F); // Box 100
		rot[40].setRotationPoint(4F, -24F, -8F);
		rot[40].rotateAngleZ = -0.26179939F;

		rot[41].addBox(-0.5F, -1.8F, 7F, 1, 1, 3, 0F); // Box 101
		rot[41].setRotationPoint(4F, -24F, -7F);
		rot[41].rotateAngleZ = -1.30899694F;

		rot[42].addBox(-0.5F, -1.8F, 9F, 1, 1, 3, 0F); // Box 102
		rot[42].setRotationPoint(4F, -24F, -7F);
		rot[42].rotateAngleZ = -1.83259571F;

		rot[43].addBox(-0.5F, -1.8F, 11F, 1, 1, 3, 0F); // Box 103
		rot[43].setRotationPoint(4F, -24F, -7F);
		rot[43].rotateAngleZ = -2.35619449F;

		rot[44].addBox(-0.5F, 0.800000000000001F, 11F, 1, 1, 3, 0F); // Box 104
		rot[44].setRotationPoint(4F, -24F, -7F);
		rot[44].rotateAngleZ = -2.35619449F;

		rot[45].addBox(-0.5F, 0.800000000000001F, 9F, 1, 1, 3, 0F); // Box 105
		rot[45].setRotationPoint(4F, -24F, -7F);
		rot[45].rotateAngleZ = -1.83259571F;

		rot[46].addBox(-0.5F, 0.800000000000001F, 7F, 1, 1, 3, 0F); // Box 106
		rot[46].setRotationPoint(4F, -24F, -7F);
		rot[46].rotateAngleZ = -1.30899694F;

		rot[47].addBox(-0.5F, 0.800000000000001F, 5.5F, 1, 1, 3, 0F); // Box 107
		rot[47].setRotationPoint(4F, -24F, -7F);
		rot[47].rotateAngleZ = -0.78539816F;

		rot[48].addBox(-0.5F, 0.800000000000001F, 4F, 1, 1, 3, 0F); // Box 108
		rot[48].setRotationPoint(4F, -24F, -7F);
		rot[48].rotateAngleZ = -0.26179939F;

		rot[49].addBox(-0.5F, 0.800000000000001F, 2F, 1, 1, 3, 0F); // Box 109
		rot[49].setRotationPoint(4F, -24F, -7F);
		rot[49].rotateAngleZ = 0.26179939F;

		rot[50].addBox(-0.5F, 0.800000000000001F, 0F, 1, 1, 3, 0F); // Box 110
		rot[50].setRotationPoint(4F, -24F, -7F);
		rot[50].rotateAngleZ = 0.78539816F;

		rot[51].addShapeBox(0.5F, -1.5F, 0F, 1, 3, 16, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 111
		rot[51].setRotationPoint(0F, -28F, -8F);

		rot[52].addBox(-0.5F, -1.5F, 0F, 1, 3, 16, 0F); // Box 112
		rot[52].setRotationPoint(0F, -28F, -8F);

		rot[53].addShapeBox(-1.5F, -1.5F, 0F, 1, 3, 16, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 113
		rot[53].setRotationPoint(0F, -28F, -8F);

		rot[54].addBox(-0.5F, -1.8F, 1F, 1, 1, 3, 0F); // Box 114
		rot[54].setRotationPoint(0F, -28F, -8F);
		rot[54].rotateAngleZ = 0.78539816F;

		rot[55].addBox(-0.5F, -1.8F, 5.5F, 1, 1, 3, 0F); // Box 115
		rot[55].setRotationPoint(0F, -28F, -7F);
		rot[55].rotateAngleZ = -0.78539816F;

		rot[56].addBox(-0.5F, -1.8F, 3F, 1, 1, 3, 0F); // Box 116
		rot[56].setRotationPoint(0F, -28F, -8F);
		rot[56].rotateAngleZ = 0.26179939F;

		rot[57].addBox(-0.5F, -1.8F, 5F, 1, 1, 3, 0F); // Box 117
		rot[57].setRotationPoint(0F, -28F, -8F);
		rot[57].rotateAngleZ = -0.26179939F;

		rot[58].addBox(-0.5F, -1.8F, 7F, 1, 1, 3, 0F); // Box 118
		rot[58].setRotationPoint(0F, -28F, -7F);
		rot[58].rotateAngleZ = -1.30899694F;

		rot[59].addBox(-0.5F, -1.8F, 9F, 1, 1, 3, 0F); // Box 119
		rot[59].setRotationPoint(0F, -28F, -7F);
		rot[59].rotateAngleZ = -1.83259571F;

		rot[60].addBox(-0.5F, -1.8F, 11F, 1, 1, 3, 0F); // Box 120
		rot[60].setRotationPoint(0F, -28F, -7F);
		rot[60].rotateAngleZ = -2.35619449F;

		rot[61].addBox(-0.5F, 0.800000000000001F, 11F, 1, 1, 3, 0F); // Box 121
		rot[61].setRotationPoint(0F, -28F, -7F);
		rot[61].rotateAngleZ = -2.35619449F;

		rot[62].addBox(-0.5F, 0.800000000000001F, 9F, 1, 1, 3, 0F); // Box 122
		rot[62].setRotationPoint(0F, -28F, -7F);
		rot[62].rotateAngleZ = -1.83259571F;

		rot[63].addBox(-0.5F, 0.800000000000001F, 7F, 1, 1, 3, 0F); // Box 123
		rot[63].setRotationPoint(0F, -28F, -7F);
		rot[63].rotateAngleZ = -1.30899694F;

		rot[64].addBox(-0.5F, 0.800000000000001F, 5.5F, 1, 1, 3, 0F); // Box 124
		rot[64].setRotationPoint(0F, -28F, -7F);
		rot[64].rotateAngleZ = -0.78539816F;

		rot[65].addBox(-0.5F, 0.800000000000001F, 4F, 1, 1, 3, 0F); // Box 125
		rot[65].setRotationPoint(0F, -28F, -7F);
		rot[65].rotateAngleZ = -0.26179939F;

		rot[66].addBox(-0.5F, 0.800000000000001F, 2F, 1, 1, 3, 0F); // Box 126
		rot[66].setRotationPoint(0F, -28F, -7F);
		rot[66].rotateAngleZ = 0.26179939F;

		rot[67].addBox(-0.5F, 0.800000000000001F, 0F, 1, 1, 3, 0F); // Box 127
		rot[67].setRotationPoint(0F, -28F, -7F);
		rot[67].rotateAngleZ = 0.78539816F;

		rot[68].addShapeBox(0.5F, -1.5F, 0F, 1, 3, 16, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 128
		rot[68].setRotationPoint(-4F, -28F, -8F);

		rot[69].addBox(-0.5F, -1.5F, 0F, 1, 3, 16, 0F); // Box 129
		rot[69].setRotationPoint(-4F, -28F, -8F);

		rot[70].addShapeBox(-1.5F, -1.5F, 0F, 1, 3, 16, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 130
		rot[70].setRotationPoint(-4F, -28F, -8F);

		rot[71].addBox(-0.5F, -1.8F, 1F, 1, 1, 3, 0F); // Box 131
		rot[71].setRotationPoint(-4F, -28F, -8F);
		rot[71].rotateAngleZ = 0.78539816F;

		rot[72].addBox(-0.5F, -1.8F, 5.5F, 1, 1, 3, 0F); // Box 132
		rot[72].setRotationPoint(-4F, -28F, -7F);
		rot[72].rotateAngleZ = -0.78539816F;

		rot[73].addBox(-0.5F, -1.8F, 3F, 1, 1, 3, 0F); // Box 133
		rot[73].setRotationPoint(-4F, -28F, -8F);
		rot[73].rotateAngleZ = 0.26179939F;

		rot[74].addBox(-0.5F, -1.8F, 5F, 1, 1, 3, 0F); // Box 134
		rot[74].setRotationPoint(-4F, -28F, -8F);
		rot[74].rotateAngleZ = -0.26179939F;

		rot[75].addBox(-0.5F, -1.8F, 7F, 1, 1, 3, 0F); // Box 135
		rot[75].setRotationPoint(-4F, -28F, -7F);
		rot[75].rotateAngleZ = -1.30899694F;

		rot[76].addBox(-0.5F, -1.8F, 9F, 1, 1, 3, 0F); // Box 136
		rot[76].setRotationPoint(-4F, -28F, -7F);
		rot[76].rotateAngleZ = -1.83259571F;

		rot[77].addBox(-0.5F, -1.8F, 11F, 1, 1, 3, 0F); // Box 137
		rot[77].setRotationPoint(-4F, -28F, -7F);
		rot[77].rotateAngleZ = -2.35619449F;

		rot[78].addBox(-0.5F, 0.800000000000001F, 11F, 1, 1, 3, 0F); // Box 138
		rot[78].setRotationPoint(-4F, -28F, -7F);
		rot[78].rotateAngleZ = -2.35619449F;

		rot[79].addBox(-0.5F, 0.800000000000001F, 9F, 1, 1, 3, 0F); // Box 139
		rot[79].setRotationPoint(-4F, -28F, -7F);
		rot[79].rotateAngleZ = -1.83259571F;

		rot[80].addBox(-0.5F, 0.800000000000001F, 7F, 1, 1, 3, 0F); // Box 140
		rot[80].setRotationPoint(-4F, -28F, -7F);
		rot[80].rotateAngleZ = -1.30899694F;

		rot[81].addBox(-0.5F, 0.800000000000001F, 5.5F, 1, 1, 3, 0F); // Box 141
		rot[81].setRotationPoint(-4F, -28F, -7F);
		rot[81].rotateAngleZ = -0.78539816F;

		rot[82].addBox(-0.5F, 0.800000000000001F, 4F, 1, 1, 3, 0F); // Box 142
		rot[82].setRotationPoint(-4F, -28F, -7F);
		rot[82].rotateAngleZ = -0.26179939F;

		rot[83].addBox(-0.5F, 0.800000000000001F, 2F, 1, 1, 3, 0F); // Box 143
		rot[83].setRotationPoint(-4F, -28F, -7F);
		rot[83].rotateAngleZ = 0.26179939F;

		rot[84].addBox(-0.5F, 0.800000000000001F, 0F, 1, 1, 3, 0F); // Box 144
		rot[84].setRotationPoint(-4F, -28F, -7F);
		rot[84].rotateAngleZ = 0.78539816F;

		rot[85].addShapeBox(0.5F, -1.5F, 0F, 1, 3, 16, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 145
		rot[85].setRotationPoint(4F, -28F, -8F);

		rot[86].addBox(-0.5F, -1.5F, 0F, 1, 3, 16, 0F); // Box 146
		rot[86].setRotationPoint(4F, -28F, -8F);

		rot[87].addShapeBox(-1.5F, -1.5F, 0F, 1, 3, 16, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 147
		rot[87].setRotationPoint(4F, -28F, -8F);

		rot[88].addBox(-0.5F, -1.8F, 1F, 1, 1, 3, 0F); // Box 148
		rot[88].setRotationPoint(4F, -28F, -8F);
		rot[88].rotateAngleZ = 0.78539816F;

		rot[89].addBox(-0.5F, -1.8F, 5.5F, 1, 1, 3, 0F); // Box 149
		rot[89].setRotationPoint(4F, -28F, -7F);
		rot[89].rotateAngleZ = -0.78539816F;

		rot[90].addBox(-0.5F, -1.8F, 3F, 1, 1, 3, 0F); // Box 150
		rot[90].setRotationPoint(4F, -28F, -8F);
		rot[90].rotateAngleZ = 0.26179939F;

		rot[91].addBox(-0.5F, -1.8F, 5F, 1, 1, 3, 0F); // Box 151
		rot[91].setRotationPoint(4F, -28F, -8F);
		rot[91].rotateAngleZ = -0.26179939F;

		rot[92].addBox(-0.5F, -1.8F, 7F, 1, 1, 3, 0F); // Box 152
		rot[92].setRotationPoint(4F, -28F, -7F);
		rot[92].rotateAngleZ = -1.30899694F;

		rot[93].addBox(-0.5F, -1.8F, 9F, 1, 1, 3, 0F); // Box 153
		rot[93].setRotationPoint(4F, -28F, -7F);
		rot[93].rotateAngleZ = -1.83259571F;

		rot[94].addBox(-0.5F, -1.8F, 11F, 1, 1, 3, 0F); // Box 154
		rot[94].setRotationPoint(4F, -28F, -7F);
		rot[94].rotateAngleZ = -2.35619449F;

		rot[95].addBox(-0.5F, 0.800000000000001F, 11F, 1, 1, 3, 0F); // Box 155
		rot[95].setRotationPoint(4F, -28F, -7F);
		rot[95].rotateAngleZ = -2.35619449F;

		rot[96].addBox(-0.5F, 0.800000000000001F, 9F, 1, 1, 3, 0F); // Box 156
		rot[96].setRotationPoint(4F, -28F, -7F);
		rot[96].rotateAngleZ = -1.83259571F;

		rot[97].addBox(-0.5F, 0.800000000000001F, 7F, 1, 1, 3, 0F); // Box 157
		rot[97].setRotationPoint(4F, -28F, -7F);
		rot[97].rotateAngleZ = -1.30899694F;

		rot[98].addBox(-0.5F, 0.800000000000001F, 5.5F, 1, 1, 3, 0F); // Box 158
		rot[98].setRotationPoint(4F, -28F, -7F);
		rot[98].rotateAngleZ = -0.78539816F;

		rot[99].addBox(-0.5F, 0.800000000000001F, 4F, 1, 1, 3, 0F); // Box 159
		rot[99].setRotationPoint(4F, -28F, -7F);
		rot[99].rotateAngleZ = -0.26179939F;

		rot[100].addBox(-0.5F, 0.800000000000001F, 2F, 1, 1, 3, 0F); // Box 160
		rot[100].setRotationPoint(4F, -28F, -7F);
		rot[100].rotateAngleZ = 0.26179939F;

		rot[101].addBox(-0.5F, 0.800000000000001F, 0F, 1, 1, 3, 0F); // Box 161
		rot[101].setRotationPoint(4F, -28F, -7F);
		rot[101].rotateAngleZ = 0.78539816F;

		rot[102].addShapeBox(0.5F, -1.5F, 0F, 1, 3, 16, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 162
		rot[102].setRotationPoint(0F, -32F, -8F);

		rot[103].addBox(-0.5F, -1.5F, 0F, 1, 3, 16, 0F); // Box 163
		rot[103].setRotationPoint(0F, -32F, -8F);

		rot[104].addShapeBox(-1.5F, -1.5F, 0F, 1, 3, 16, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 164
		rot[104].setRotationPoint(0F, -32F, -8F);

		rot[105].addBox(-0.5F, -1.8F, 1F, 1, 1, 3, 0F); // Box 165
		rot[105].setRotationPoint(0F, -32F, -8F);
		rot[105].rotateAngleZ = 0.78539816F;

		rot[106].addBox(-0.5F, -1.8F, 5.5F, 1, 1, 3, 0F); // Box 166
		rot[106].setRotationPoint(0F, -32F, -7F);
		rot[106].rotateAngleZ = -0.78539816F;

		rot[107].addBox(-0.5F, -1.8F, 3F, 1, 1, 3, 0F); // Box 167
		rot[107].setRotationPoint(0F, -32F, -8F);
		rot[107].rotateAngleZ = 0.26179939F;

		rot[108].addBox(-0.5F, -1.8F, 5F, 1, 1, 3, 0F); // Box 168
		rot[108].setRotationPoint(0F, -32F, -8F);
		rot[108].rotateAngleZ = -0.26179939F;

		rot[109].addBox(-0.5F, -1.8F, 7F, 1, 1, 3, 0F); // Box 169
		rot[109].setRotationPoint(0F, -32F, -7F);
		rot[109].rotateAngleZ = -1.30899694F;

		rot[110].addBox(-0.5F, -1.8F, 9F, 1, 1, 3, 0F); // Box 170
		rot[110].setRotationPoint(0F, -32F, -7F);
		rot[110].rotateAngleZ = -1.83259571F;

		rot[111].addBox(-0.5F, -1.8F, 11F, 1, 1, 3, 0F); // Box 171
		rot[111].setRotationPoint(0F, -32F, -7F);
		rot[111].rotateAngleZ = -2.35619449F;

		rot[112].addBox(-0.5F, 0.800000000000001F, 11F, 1, 1, 3, 0F); // Box 172
		rot[112].setRotationPoint(0F, -32F, -7F);
		rot[112].rotateAngleZ = -2.35619449F;

		rot[113].addBox(-0.5F, 0.800000000000001F, 9F, 1, 1, 3, 0F); // Box 173
		rot[113].setRotationPoint(0F, -32F, -7F);
		rot[113].rotateAngleZ = -1.83259571F;

		rot[114].addBox(-0.5F, 0.800000000000001F, 7F, 1, 1, 3, 0F); // Box 174
		rot[114].setRotationPoint(0F, -32F, -7F);
		rot[114].rotateAngleZ = -1.30899694F;

		rot[115].addBox(-0.5F, 0.800000000000001F, 5.5F, 1, 1, 3, 0F); // Box 175
		rot[115].setRotationPoint(0F, -32F, -7F);
		rot[115].rotateAngleZ = -0.78539816F;

		rot[116].addBox(-0.5F, 0.800000000000001F, 4F, 1, 1, 3, 0F); // Box 176
		rot[116].setRotationPoint(0F, -32F, -7F);
		rot[116].rotateAngleZ = -0.26179939F;

		rot[117].addBox(-0.5F, 0.800000000000001F, 2F, 1, 1, 3, 0F); // Box 177
		rot[117].setRotationPoint(0F, -32F, -7F);
		rot[117].rotateAngleZ = 0.26179939F;

		rot[118].addBox(-0.5F, 0.800000000000001F, 0F, 1, 1, 3, 0F); // Box 178
		rot[118].setRotationPoint(0F, -32F, -7F);
		rot[118].rotateAngleZ = 0.78539816F;

		rot[119].addShapeBox(0.5F, -1.5F, 0F, 1, 3, 16, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 179
		rot[119].setRotationPoint(-4F, -32F, -8F);

		rot[120].addBox(-0.5F, -1.5F, 0F, 1, 3, 16, 0F); // Box 180
		rot[120].setRotationPoint(-4F, -32F, -8F);

		rot[121].addShapeBox(-1.5F, -1.5F, 0F, 1, 3, 16, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 181
		rot[121].setRotationPoint(-4F, -32F, -8F);

		rot[122].addBox(-0.5F, -1.8F, 1F, 1, 1, 3, 0F); // Box 182
		rot[122].setRotationPoint(-4F, -32F, -8F);
		rot[122].rotateAngleZ = 0.78539816F;

		rot[123].addBox(-0.5F, -1.8F, 5.5F, 1, 1, 3, 0F); // Box 183
		rot[123].setRotationPoint(-4F, -32F, -7F);
		rot[123].rotateAngleZ = -0.78539816F;

		rot[124].addBox(-0.5F, -1.8F, 3F, 1, 1, 3, 0F); // Box 184
		rot[124].setRotationPoint(-4F, -32F, -8F);
		rot[124].rotateAngleZ = 0.26179939F;

		rot[125].addBox(-0.5F, -1.8F, 5F, 1, 1, 3, 0F); // Box 185
		rot[125].setRotationPoint(-4F, -32F, -8F);
		rot[125].rotateAngleZ = -0.26179939F;

		rot[126].addBox(-0.5F, -1.8F, 7F, 1, 1, 3, 0F); // Box 186
		rot[126].setRotationPoint(-4F, -32F, -7F);
		rot[126].rotateAngleZ = -1.30899694F;

		rot[127].addBox(-0.5F, -1.8F, 9F, 1, 1, 3, 0F); // Box 187
		rot[127].setRotationPoint(-4F, -32F, -7F);
		rot[127].rotateAngleZ = -1.83259571F;

		rot[128].addBox(-0.5F, -1.8F, 11F, 1, 1, 3, 0F); // Box 188
		rot[128].setRotationPoint(-4F, -32F, -7F);
		rot[128].rotateAngleZ = -2.35619449F;

		rot[129].addBox(-0.5F, 0.800000000000001F, 11F, 1, 1, 3, 0F); // Box 189
		rot[129].setRotationPoint(-4F, -32F, -7F);
		rot[129].rotateAngleZ = -2.35619449F;

		rot[130].addBox(-0.5F, 0.800000000000001F, 9F, 1, 1, 3, 0F); // Box 190
		rot[130].setRotationPoint(-4F, -32F, -7F);
		rot[130].rotateAngleZ = -1.83259571F;

		rot[131].addBox(-0.5F, 0.800000000000001F, 7F, 1, 1, 3, 0F); // Box 191
		rot[131].setRotationPoint(-4F, -32F, -7F);
		rot[131].rotateAngleZ = -1.30899694F;

		rot[132].addBox(-0.5F, 0.800000000000001F, 5.5F, 1, 1, 3, 0F); // Box 192
		rot[132].setRotationPoint(-4F, -32F, -7F);
		rot[132].rotateAngleZ = -0.78539816F;

		rot[133].addBox(-0.5F, 0.800000000000001F, 4F, 1, 1, 3, 0F); // Box 193
		rot[133].setRotationPoint(-4F, -32F, -7F);
		rot[133].rotateAngleZ = -0.26179939F;

		rot[134].addBox(-0.5F, 0.800000000000001F, 2F, 1, 1, 3, 0F); // Box 194
		rot[134].setRotationPoint(-4F, -32F, -7F);
		rot[134].rotateAngleZ = 0.26179939F;

		rot[135].addBox(-0.5F, 0.800000000000001F, 0F, 1, 1, 3, 0F); // Box 195
		rot[135].setRotationPoint(-4F, -32F, -7F);
		rot[135].rotateAngleZ = 0.78539816F;

		rot[136].addShapeBox(0.5F, -1.5F, 0F, 1, 3, 16, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 196
		rot[136].setRotationPoint(4F, -32F, -8F);

		rot[137].addBox(-0.5F, -1.5F, 0F, 1, 3, 16, 0F); // Box 197
		rot[137].setRotationPoint(4F, -32F, -8F);

		rot[138].addShapeBox(-1.5F, -1.5F, 0F, 1, 3, 16, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 198
		rot[138].setRotationPoint(4F, -32F, -8F);

		rot[139].addBox(-0.5F, -1.8F, 1F, 1, 1, 3, 0F); // Box 199
		rot[139].setRotationPoint(4F, -32F, -8F);
		rot[139].rotateAngleZ = 0.78539816F;

		rot[140].addBox(-0.5F, -1.8F, 5.5F, 1, 1, 3, 0F); // Box 200
		rot[140].setRotationPoint(4F, -32F, -7F);
		rot[140].rotateAngleZ = -0.78539816F;

		rot[141].addBox(-0.5F, -1.8F, 3F, 1, 1, 3, 0F); // Box 201
		rot[141].setRotationPoint(4F, -32F, -8F);
		rot[141].rotateAngleZ = 0.26179939F;

		rot[142].addBox(-0.5F, -1.8F, 5F, 1, 1, 3, 0F); // Box 202
		rot[142].setRotationPoint(4F, -32F, -8F);
		rot[142].rotateAngleZ = -0.26179939F;

		rot[143].addBox(-0.5F, -1.8F, 7F, 1, 1, 3, 0F); // Box 203
		rot[143].setRotationPoint(4F, -32F, -7F);
		rot[143].rotateAngleZ = -1.30899694F;

		rot[144].addBox(-0.5F, -1.8F, 9F, 1, 1, 3, 0F); // Box 204
		rot[144].setRotationPoint(4F, -32F, -7F);
		rot[144].rotateAngleZ = -1.83259571F;

		rot[145].addBox(-0.5F, -1.8F, 11F, 1, 1, 3, 0F); // Box 205
		rot[145].setRotationPoint(4F, -32F, -7F);
		rot[145].rotateAngleZ = -2.35619449F;

		rot[146].addBox(-0.5F, 0.800000000000001F, 11F, 1, 1, 3, 0F); // Box 206
		rot[146].setRotationPoint(4F, -32F, -7F);
		rot[146].rotateAngleZ = -2.35619449F;

		rot[147].addBox(-0.5F, 0.800000000000001F, 9F, 1, 1, 3, 0F); // Box 207
		rot[147].setRotationPoint(4F, -32F, -7F);
		rot[147].rotateAngleZ = -1.83259571F;

		rot[148].addBox(-0.5F, 0.800000000000001F, 7F, 1, 1, 3, 0F); // Box 208
		rot[148].setRotationPoint(4F, -32F, -7F);
		rot[148].rotateAngleZ = -1.30899694F;

		rot[149].addBox(-0.5F, 0.800000000000001F, 5.5F, 1, 1, 3, 0F); // Box 209
		rot[149].setRotationPoint(4F, -32F, -7F);
		rot[149].rotateAngleZ = -0.78539816F;

		rot[150].addBox(-0.5F, 0.800000000000001F, 4F, 1, 1, 3, 0F); // Box 210
		rot[150].setRotationPoint(4F, -32F, -7F);
		rot[150].rotateAngleZ = -0.26179939F;

		rot[151].addBox(-0.5F, 0.800000000000001F, 2F, 1, 1, 3, 0F); // Box 211
		rot[151].setRotationPoint(4F, -32F, -7F);
		rot[151].rotateAngleZ = 0.26179939F;

		rot[152].addBox(-0.5F, 0.800000000000001F, 0F, 1, 1, 3, 0F); // Box 212
		rot[152].setRotationPoint(4F, -32F, -7F);
		rot[152].rotateAngleZ = 0.78539816F;
		translateAll(0F, 0F, 0F);
		flipAll();
	}
	
	@Override
	public void render(BlockData data, BlockTileEntity tile, Entity ent, int meta){
		super.render(data, tile, ent, meta);
		if(tile == null){
			render(rot);
		}
		else{
	    	float rotation = RenderCache.getData(tile.getLongPos(), "rot_state", 0) + 1;
	    	RenderCache.updateData(tile.getLongPos(), "rot_state", rotation > 360 ? 0 : rotation);
	    	for(ModelRendererTurbo turbo : rot){
	    		turbo.rotateAngleZ += Static.rad1 * rotation;
	    		turbo.render();
	    		turbo.rotateAngleZ -= Static.rad1 * rotation;
	    	}
		}
		//
		if(data.getScript() != null){
			GL11.glTranslated(0, data.getScript(CrusherScript.class).state * -0.065, 0);
			render(state);
		}
		else{
			render(state);
		}
	}
	
}