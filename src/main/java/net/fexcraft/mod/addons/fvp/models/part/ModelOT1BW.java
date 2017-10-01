//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2016 Minecraft-SMP.de
// This file is for Fex's Vehicle Mod

// Model: OT1
// Model Creator: FEX___96
// Created on: 25.02.2016 - 16:09:52
// Last changed on: 25.02.2016 - 16:09:52

package net.fexcraft.mod.addons.fvp.models.part;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.part.PartModel;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.minecraft.entity.Entity;

public class ModelOT1BW extends PartModel {
	
	int textureX = 512;
	int textureY = 512;

	public ModelOT1BW(){
		creators.add("Ferdinand (FEX___96)");
		wheel_back_left = new ModelRendererTurbo[42];
		wheel_back_left[0] = new ModelRendererTurbo(this, 305, 73, textureX, textureY); // Box 164
		wheel_back_left[1] = new ModelRendererTurbo(this, 305, 33, textureX, textureY); // Box 165
		wheel_back_left[2] = new ModelRendererTurbo(this, 321, 33, textureX, textureY); // Box 166
		wheel_back_left[3] = new ModelRendererTurbo(this, 89, 57, textureX, textureY); // Box 170
		wheel_back_left[4] = new ModelRendererTurbo(this, 385, 57, textureX, textureY); // Box 175
		wheel_back_left[5] = new ModelRendererTurbo(this, 217, 81, textureX, textureY); // Box 176
		wheel_back_left[6] = new ModelRendererTurbo(this, 345, 81, textureX, textureY); // Box 177
		wheel_back_left[7] = new ModelRendererTurbo(this, 25, 25, textureX, textureY); // Box 178
		wheel_back_left[8] = new ModelRendererTurbo(this, 113, 33, textureX, textureY); // Box 179
		wheel_back_left[9] = new ModelRendererTurbo(this, 1, 41, textureX, textureY); // Box 180
		wheel_back_left[10] = new ModelRendererTurbo(this, 113, 41, textureX, textureY); // Box 181
		wheel_back_left[11] = new ModelRendererTurbo(this, 393, 41, textureX, textureY); // Box 182
		wheel_back_left[12] = new ModelRendererTurbo(this, 481, 41, textureX, textureY); // Box 183
		wheel_back_left[13] = new ModelRendererTurbo(this, 169, 49, textureX, textureY); // Box 184
		wheel_back_left[14] = new ModelRendererTurbo(this, 209, 49, textureX, textureY); // Box 185
		wheel_back_left[15] = new ModelRendererTurbo(this, 233, 49, textureX, textureY); // Box 186
		wheel_back_left[16] = new ModelRendererTurbo(this, 257, 49, textureX, textureY); // Box 187
		wheel_back_left[17] = new ModelRendererTurbo(this, 281, 49, textureX, textureY); // Box 188
		wheel_back_left[18] = new ModelRendererTurbo(this, 17, 57, textureX, textureY); // Box 189
		wheel_back_left[19] = new ModelRendererTurbo(this, 49, 25, textureX, textureY); // Box 190
		wheel_back_left[20] = new ModelRendererTurbo(this, 65, 25, textureX, textureY); // Box 191
		wheel_back_left[21] = new ModelRendererTurbo(this, 105, 25, textureX, textureY); // Box 192
		wheel_back_left[22] = new ModelRendererTurbo(this, 137, 25, textureX, textureY); // Box 193
		wheel_back_left[23] = new ModelRendererTurbo(this, 361, 57, textureX, textureY); // Box 194
		wheel_back_left[24] = new ModelRendererTurbo(this, 105, 73, textureX, textureY); // Box 195
		wheel_back_left[25] = new ModelRendererTurbo(this, 145, 73, textureX, textureY); // Box 196
		wheel_back_left[26] = new ModelRendererTurbo(this, 241, 81, textureX, textureY); // Box 197
		wheel_back_left[27] = new ModelRendererTurbo(this, 1, 89, textureX, textureY); // Box 198
		wheel_back_left[28] = new ModelRendererTurbo(this, 17, 89, textureX, textureY); // Box 199
		wheel_back_left[29] = new ModelRendererTurbo(this, 313, 89, textureX, textureY); // Box 200
		wheel_back_left[30] = new ModelRendererTurbo(this, 361, 89, textureX, textureY); // Box 201
		wheel_back_left[31] = new ModelRendererTurbo(this, 65, 57, textureX, textureY); // Box 202
		wheel_back_left[32] = new ModelRendererTurbo(this, 257, 57, textureX, textureY); // Box 203
		wheel_back_left[33] = new ModelRendererTurbo(this, 281, 57, textureX, textureY); // Box 204
		wheel_back_left[34] = new ModelRendererTurbo(this, 305, 57, textureX, textureY); // Box 205
		wheel_back_left[35] = new ModelRendererTurbo(this, 137, 185, textureX, textureY); // Box 319
		wheel_back_left[36] = new ModelRendererTurbo(this, 345, 57, textureX, textureY); // Box 320
		wheel_back_left[37] = new ModelRendererTurbo(this, 1, 65, textureX, textureY); // Box 321
		wheel_back_left[38] = new ModelRendererTurbo(this, 81, 49, textureX, textureY); // Box 323
		wheel_back_left[39] = new ModelRendererTurbo(this, 393, 49, textureX, textureY); // Box 324
		wheel_back_left[40] = new ModelRendererTurbo(this, 1, 57, textureX, textureY); // Box 325
		wheel_back_left[41] = new ModelRendererTurbo(this, 49, 57, textureX, textureY); // Box 326

		wheel_back_left[0].addBox(-2F, -8F, 0F, 4, 16, 1, 0F); // Box 164
		wheel_back_left[0].setRotationPoint(-53F, 0F, 18F);

		wheel_back_left[1].addBox(2F, -2F, 0F, 6, 4, 1, 0F); // Box 165
		wheel_back_left[1].setRotationPoint(-53F, 0F, 18F);

		wheel_back_left[2].addBox(-8F, -2F, 0F, 6, 4, 1, 0F); // Box 166
		wheel_back_left[2].setRotationPoint(-53F, 0F, 18F);

		wheel_back_left[3].addBox(-2F, -10F, 0F, 4, 2, 4, 0F); // Box 170
		wheel_back_left[3].setRotationPoint(-53F, 0F, 17F);

		wheel_back_left[4].addBox(-2F, 8F, 0F, 4, 2, 4, 0F); // Box 175
		wheel_back_left[4].setRotationPoint(-53F, 0F, 17F);

		wheel_back_left[5].addBox(-10F, -2F, 0F, 2, 4, 4, 0F); // Box 176
		wheel_back_left[5].setRotationPoint(-53F, 0F, 17F);

		wheel_back_left[6].addBox(8F, -2F, 0F, 2, 4, 4, 0F); // Box 177
		wheel_back_left[6].setRotationPoint(-53F, 0F, 17F);

		wheel_back_left[7].addBox(2F, -5F, 0F, 3, 3, 1, 0F); // Box 178
		wheel_back_left[7].setRotationPoint(-53F, 0F, 18F);

		wheel_back_left[8].addBox(-5F, -5F, 0F, 3, 3, 1, 0F); // Box 179
		wheel_back_left[8].setRotationPoint(-53F, 0F, 18F);

		wheel_back_left[9].addBox(-5F, 2F, 0F, 3, 3, 1, 0F); // Box 180
		wheel_back_left[9].setRotationPoint(-53F, 0F, 18F);

		wheel_back_left[10].addBox(2F, 2F, 0F, 3, 3, 1, 0F); // Box 181
		wheel_back_left[10].setRotationPoint(-53F, 0F, 18F);

		wheel_back_left[11].addShapeBox(-5F, 5F, 0F, 3, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 182
		wheel_back_left[11].setRotationPoint(-53F, 0F, 18F);

		wheel_back_left[12].addShapeBox(-5F, -8F, 0F, 3, 3, 1, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 183
		wheel_back_left[12].setRotationPoint(-53F, 0F, 18F);

		wheel_back_left[13].addShapeBox(2F, -8F, 0F, 3, 3, 1, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 184
		wheel_back_left[13].setRotationPoint(-53F, 0F, 18F);

		wheel_back_left[14].addShapeBox(2F, 5F, 0F, 3, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F); // Box 185
		wheel_back_left[14].setRotationPoint(-53F, 0F, 18F);

		wheel_back_left[15].addShapeBox(-8F, -5F, 0F, 3, 3, 1, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 186
		wheel_back_left[15].setRotationPoint(-53F, 0F, 18F);

		wheel_back_left[16].addShapeBox(-8F, 2F, 0F, 3, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F); // Box 187
		wheel_back_left[16].setRotationPoint(-53F, 0F, 18F);

		wheel_back_left[17].addShapeBox(5F, 2F, 0F, 3, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F); // Box 188
		wheel_back_left[17].setRotationPoint(-53F, 0F, 18F);

		wheel_back_left[18].addShapeBox(5F, -5F, 0F, 3, 3, 1, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 189
		wheel_back_left[18].setRotationPoint(-53F, 0F, 18F);

		wheel_back_left[19].addShapeBox(-6F, 5F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 190
		wheel_back_left[19].setRotationPoint(-53F, 0F, 18F);

		wheel_back_left[20].addShapeBox(-6F, -6F, 0F, 1, 1, 1, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 191
		wheel_back_left[20].setRotationPoint(-53F, 0F, 18F);

		wheel_back_left[21].addShapeBox(5F, -6F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 192
		wheel_back_left[21].setRotationPoint(-53F, 0F, 18F);

		wheel_back_left[22].addShapeBox(5F, 5F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 193
		wheel_back_left[22].setRotationPoint(-53F, 0F, 18F);

		wheel_back_left[23].addShapeBox(-10F, 2F, 0F, 2, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -1.5F, 0F, 0F); // Box 194
		wheel_back_left[23].setRotationPoint(-53F, 0F, 17F);

		wheel_back_left[24].addShapeBox(-10F, -5F, 0F, 2, 3, 4, 0F, -1.5F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 195
		wheel_back_left[24].setRotationPoint(-53F, 0F, 17F);

		wheel_back_left[25].addShapeBox(8F, -5F, 0F, 2, 3, 4, 0F, 2F, 0F, 0F, -1.5F, 0F, 0F, -1.5F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 196
		wheel_back_left[25].setRotationPoint(-53F, 0F, 17F);

		wheel_back_left[26].addShapeBox(8F, 2F, 0F, 2, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -1.5F, 0F, 0F, -1.5F, 0F, 0F, 2F, 0F, 0F); // Box 197
		wheel_back_left[26].setRotationPoint(-53F, 0F, 17F);

		wheel_back_left[27].addShapeBox(-8F, 5F, 0F, 3, 3, 4, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, 0.5F, -3F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0.5F, -3F, 0F); // Box 198
		wheel_back_left[27].setRotationPoint(-53F, 0F, 17F);

		wheel_back_left[28].addShapeBox(-8F, -8F, 0F, 3, 3, 4, 0F, 0.5F, -3F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0.5F, -3F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F); // Box 199
		wheel_back_left[28].setRotationPoint(-53F, 0F, 17F);

		wheel_back_left[29].addShapeBox(5F, -8F, 0F, 3, 3, 4, 0F, 0F, 0.5F, 0F, 0.5F, -3F, 0F, 0.5F, -3F, 0F, 0F, 0.5F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F); // Box 200
		wheel_back_left[29].setRotationPoint(-53F, 0F, 17F);

		wheel_back_left[30].addShapeBox(5F, 5F, 0F, 3, 3, 4, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, 0.5F, 0F, 0.5F, -3F, 0F, 0.5F, -3F, 0F, 0F, 0.5F, 0F); // Box 201
		wheel_back_left[30].setRotationPoint(-53F, 0F, 17F);

		wheel_back_left[31].addShapeBox(-5F, 8F, 0F, 3, 2, 4, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F, 0F); // Box 202
		wheel_back_left[31].setRotationPoint(-53F, 0F, 17F);

		wheel_back_left[32].addShapeBox(-5F, -10F, 0F, 3, 2, 4, 0F, 0F, -1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F); // Box 203
		wheel_back_left[32].setRotationPoint(-53F, 0F, 17F);

		wheel_back_left[33].addShapeBox(2F, -10F, 0F, 3, 2, 4, 0F, 0F, 0F, 0F, 0F, -1.5F, 0F, 0F, -1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F); // Box 204
		wheel_back_left[33].setRotationPoint(-53F, 0F, 17F);

		wheel_back_left[34].addShapeBox(2F, 8F, 0F, 3, 2, 4, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F, 0F, 0F, -1.5F, 0F, 0F, 0F, 0F); // Box 205
		wheel_back_left[34].setRotationPoint(-53F, 0F, 17F);

		wheel_back_left[35].addBox(-2F, -3F, 0F, 4, 6, 1, 0F); // Box 319
		wheel_back_left[35].setRotationPoint(-53F, 0F, 19F);

		wheel_back_left[36].addShapeBox(2F, -3F, 0F, 1, 6, 1, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 320
		wheel_back_left[36].setRotationPoint(-53F, 0F, 19F);

		wheel_back_left[37].addShapeBox(-3F, -3F, 0F, 1, 6, 1, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 321
		wheel_back_left[37].setRotationPoint(-53F, 0F, 19F);

		wheel_back_left[38].addBox(1F, -2F, 0.2F, 1, 1, 1, 0F); // Box 323
		wheel_back_left[38].setRotationPoint(-53F, 0F, 19F);

		wheel_back_left[39].addBox(-2F, -2F, 0.2F, 1, 1, 1, 0F); // Box 324
		wheel_back_left[39].setRotationPoint(-53F, 0F, 19F);

		wheel_back_left[40].addBox(-2F, 1F, 0.2F, 1, 1, 1, 0F); // Box 325
		wheel_back_left[40].setRotationPoint(-53F, 0F, 19F);

		wheel_back_left[41].addBox(1F, 1F, 0.2F, 1, 1, 1, 0F); // Box 326
		wheel_back_left[41].setRotationPoint(-53F, 0F, 19F);


		wheel_back_right = new ModelRendererTurbo[42];
		wheel_back_right[0] = new ModelRendererTurbo(this, 169, 113, textureX, textureY); // Box 225
		wheel_back_right[1] = new ModelRendererTurbo(this, 377, 89, textureX, textureY); // Box 226
		wheel_back_right[2] = new ModelRendererTurbo(this, 273, 113, textureX, textureY); // Box 227
		wheel_back_right[3] = new ModelRendererTurbo(this, 329, 57, textureX, textureY); // Box 228
		wheel_back_right[4] = new ModelRendererTurbo(this, 209, 65, textureX, textureY); // Box 229
		wheel_back_right[5] = new ModelRendererTurbo(this, 393, 65, textureX, textureY); // Box 230
		wheel_back_right[6] = new ModelRendererTurbo(this, 33, 73, textureX, textureY); // Box 231
		wheel_back_right[7] = new ModelRendererTurbo(this, 169, 73, textureX, textureY); // Box 232
		wheel_back_right[8] = new ModelRendererTurbo(this, 33, 89, textureX, textureY); // Box 233
		wheel_back_right[9] = new ModelRendererTurbo(this, 329, 89, textureX, textureY); // Box 234
		wheel_back_right[10] = new ModelRendererTurbo(this, 353, 105, textureX, textureY); // Box 235
		wheel_back_right[11] = new ModelRendererTurbo(this, 369, 113, textureX, textureY); // Box 236
		wheel_back_right[12] = new ModelRendererTurbo(this, 369, 121, textureX, textureY); // Box 237
		wheel_back_right[13] = new ModelRendererTurbo(this, 297, 129, textureX, textureY); // Box 238
		wheel_back_right[14] = new ModelRendererTurbo(this, 497, 129, textureX, textureY); // Box 239
		wheel_back_right[15] = new ModelRendererTurbo(this, 153, 25, textureX, textureY); // Box 240
		wheel_back_right[16] = new ModelRendererTurbo(this, 169, 25, textureX, textureY); // Box 241
		wheel_back_right[17] = new ModelRendererTurbo(this, 249, 25, textureX, textureY); // Box 242
		wheel_back_right[18] = new ModelRendererTurbo(this, 273, 25, textureX, textureY); // Box 243
		wheel_back_right[19] = new ModelRendererTurbo(this, 65, 137, textureX, textureY); // Box 244
		wheel_back_right[20] = new ModelRendererTurbo(this, 169, 137, textureX, textureY); // Box 245
		wheel_back_right[21] = new ModelRendererTurbo(this, 249, 137, textureX, textureY); // Box 246
		wheel_back_right[22] = new ModelRendererTurbo(this, 473, 137, textureX, textureY); // Box 247
		wheel_back_right[23] = new ModelRendererTurbo(this, 497, 121, textureX, textureY); // Box 248
		wheel_back_right[24] = new ModelRendererTurbo(this, 281, 137, textureX, textureY); // Box 249
		wheel_back_right[25] = new ModelRendererTurbo(this, 297, 137, textureX, textureY); // Box 250
		wheel_back_right[26] = new ModelRendererTurbo(this, 313, 137, textureX, textureY); // Box 251
		wheel_back_right[27] = new ModelRendererTurbo(this, 329, 137, textureX, textureY); // Box 252
		wheel_back_right[28] = new ModelRendererTurbo(this, 345, 137, textureX, textureY); // Box 253
		wheel_back_right[29] = new ModelRendererTurbo(this, 417, 137, textureX, textureY); // Box 254
		wheel_back_right[30] = new ModelRendererTurbo(this, 433, 137, textureX, textureY); // Box 255
		wheel_back_right[31] = new ModelRendererTurbo(this, 449, 137, textureX, textureY); // Box 256
		wheel_back_right[32] = new ModelRendererTurbo(this, 489, 137, textureX, textureY); // Box 257
		wheel_back_right[33] = new ModelRendererTurbo(this, 65, 145, textureX, textureY); // Box 258
		wheel_back_right[34] = new ModelRendererTurbo(this, 161, 145, textureX, textureY); // Box 259
		wheel_back_right[35] = new ModelRendererTurbo(this, 153, 185, textureX, textureY); // Box 327
		wheel_back_right[36] = new ModelRendererTurbo(this, 129, 73, textureX, textureY); // Box 328
		wheel_back_right[37] = new ModelRendererTurbo(this, 505, 81, textureX, textureY); // Box 329
		wheel_back_right[38] = new ModelRendererTurbo(this, 137, 57, textureX, textureY); // Box 330
		wheel_back_right[39] = new ModelRendererTurbo(this, 17, 65, textureX, textureY); // Box 331
		wheel_back_right[40] = new ModelRendererTurbo(this, 97, 65, textureX, textureY); // Box 332
		wheel_back_right[41] = new ModelRendererTurbo(this, 105, 65, textureX, textureY); // Box 333

		wheel_back_right[0].addBox(-2F, -8F, -1F, 4, 16, 1, 0F); // Box 225
		wheel_back_right[0].setRotationPoint(-53F, 0F, -18F);

		wheel_back_right[1].addBox(-8F, -2F, -1F, 6, 4, 1, 0F); // Box 226
		wheel_back_right[1].setRotationPoint(-53F, 0F, -18F);

		wheel_back_right[2].addBox(2F, -2F, -1F, 6, 4, 1, 0F); // Box 227
		wheel_back_right[2].setRotationPoint(-53F, 0F, -18F);

		wheel_back_right[3].addBox(2F, 2F, -1F, 3, 3, 1, 0F); // Box 228
		wheel_back_right[3].setRotationPoint(-53F, 0F, -18F);

		wheel_back_right[4].addBox(-5F, 2F, -1F, 3, 3, 1, 0F); // Box 229
		wheel_back_right[4].setRotationPoint(-53F, 0F, -18F);

		wheel_back_right[5].addBox(-5F, -5F, -1F, 3, 3, 1, 0F); // Box 230
		wheel_back_right[5].setRotationPoint(-53F, 0F, -18F);

		wheel_back_right[6].addBox(2F, -5F, -1F, 3, 3, 1, 0F); // Box 231
		wheel_back_right[6].setRotationPoint(-53F, 0F, -18F);

		wheel_back_right[7].addShapeBox(2F, 5F, -1F, 3, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F); // Box 232
		wheel_back_right[7].setRotationPoint(-53F, 0F, -18F);

		wheel_back_right[8].addShapeBox(2F, -8F, -1F, 3, 3, 1, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 233
		wheel_back_right[8].setRotationPoint(-53F, 0F, -18F);

		wheel_back_right[9].addShapeBox(-5F, -8F, -1F, 3, 3, 1, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 234
		wheel_back_right[9].setRotationPoint(-53F, 0F, -18F);

		wheel_back_right[10].addShapeBox(-5F, 5F, -1F, 3, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 235
		wheel_back_right[10].setRotationPoint(-53F, 0F, -18F);

		wheel_back_right[11].addShapeBox(5F, 2F, -1F, 3, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F); // Box 236
		wheel_back_right[11].setRotationPoint(-53F, 0F, -18F);

		wheel_back_right[12].addShapeBox(5F, -5F, -1F, 3, 3, 1, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 237
		wheel_back_right[12].setRotationPoint(-53F, 0F, -18F);

		wheel_back_right[13].addShapeBox(-8F, -5F, -1F, 3, 3, 1, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 238
		wheel_back_right[13].setRotationPoint(-53F, 0F, -18F);

		wheel_back_right[14].addShapeBox(-8F, 2F, -1F, 3, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F); // Box 239
		wheel_back_right[14].setRotationPoint(-53F, 0F, -18F);

		wheel_back_right[15].addShapeBox(-6F, 5F, -1F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 240
		wheel_back_right[15].setRotationPoint(-53F, 0F, -18F);

		wheel_back_right[16].addShapeBox(-6F, -6F, -1F, 1, 1, 1, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 241
		wheel_back_right[16].setRotationPoint(-53F, 0F, -18F);

		wheel_back_right[17].addShapeBox(5F, -6F, -1F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 242
		wheel_back_right[17].setRotationPoint(-53F, 0F, -18F);

		wheel_back_right[18].addShapeBox(5F, 5F, -1F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 243
		wheel_back_right[18].setRotationPoint(-53F, 0F, -18F);

		wheel_back_right[19].addBox(-2F, 8F, -4F, 4, 2, 4, 0F); // Box 244
		wheel_back_right[19].setRotationPoint(-53F, 0F, -17F);

		wheel_back_right[20].addBox(-2F, -10F, -4F, 4, 2, 4, 0F); // Box 245
		wheel_back_right[20].setRotationPoint(-53F, 0F, -17F);

		wheel_back_right[21].addBox(-10F, -2F, -4F, 2, 4, 4, 0F); // Box 246
		wheel_back_right[21].setRotationPoint(-53F, 0F, -17F);

		wheel_back_right[22].addBox(8F, -2F, -4F, 2, 4, 4, 0F); // Box 247
		wheel_back_right[22].setRotationPoint(-53F, 0F, -17F);

		wheel_back_right[23].addShapeBox(5F, 5F, -4F, 3, 3, 4, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, 0.5F, 0F, 0.5F, -3F, 0F, 0.5F, -3F, 0F, 0F, 0.5F, 0F); // Box 248
		wheel_back_right[23].setRotationPoint(-53F, 0F, -17F);

		wheel_back_right[24].addShapeBox(5F, -8F, -4F, 3, 3, 4, 0F, 0F, 0.5F, 0F, 0.5F, -3F, 0F, 0.5F, -3F, 0F, 0F, 0.5F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F); // Box 249
		wheel_back_right[24].setRotationPoint(-53F, 0F, -17F);

		wheel_back_right[25].addShapeBox(-8F, -8F, -4F, 3, 3, 4, 0F, 0.5F, -3F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0.5F, -3F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F); // Box 250
		wheel_back_right[25].setRotationPoint(-53F, 0F, -17F);

		wheel_back_right[26].addShapeBox(-8F, 5F, -4F, 3, 3, 4, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, 0.5F, -3F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0.5F, -3F, 0F); // Box 251
		wheel_back_right[26].setRotationPoint(-53F, 0F, -17F);

		wheel_back_right[27].addShapeBox(-5F, 8F, -4F, 3, 2, 4, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F, 0F); // Box 252
		wheel_back_right[27].setRotationPoint(-53F, 0F, -17F);

		wheel_back_right[28].addShapeBox(-5F, -10F, -4F, 3, 2, 4, 0F, 0F, -1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F); // Box 253
		wheel_back_right[28].setRotationPoint(-53F, 0F, -17F);

		wheel_back_right[29].addShapeBox(2F, -10F, -4F, 3, 2, 4, 0F, 0F, 0F, 0F, 0F, -1.5F, 0F, 0F, -1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F); // Box 254
		wheel_back_right[29].setRotationPoint(-53F, 0F, -17F);

		wheel_back_right[30].addShapeBox(2F, 8F, -4F, 3, 2, 4, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F, 0F, 0F, -1.5F, 0F, 0F, 0F, 0F); // Box 255
		wheel_back_right[30].setRotationPoint(-53F, 0F, -17F);

		wheel_back_right[31].addShapeBox(-10F, 2F, -4F, 2, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -1.5F, 0F, 0F); // Box 256
		wheel_back_right[31].setRotationPoint(-53F, 0F, -17F);

		wheel_back_right[32].addShapeBox(-10F, -5F, -4F, 2, 3, 4, 0F, -1.5F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 257
		wheel_back_right[32].setRotationPoint(-53F, 0F, -17F);

		wheel_back_right[33].addShapeBox(8F, -5F, -4F, 2, 3, 4, 0F, 2F, 0F, 0F, -1.5F, 0F, 0F, -1.5F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 258
		wheel_back_right[33].setRotationPoint(-53F, 0F, -17F);

		wheel_back_right[34].addShapeBox(8F, 2F, -4F, 2, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -1.5F, 0F, 0F, -1.5F, 0F, 0F, 2F, 0F, 0F); // Box 259
		wheel_back_right[34].setRotationPoint(-53F, 0F, -17F);

		wheel_back_right[35].addBox(-2F, -3F, -1F, 4, 6, 1, 0F); // Box 327
		wheel_back_right[35].setRotationPoint(-53F, 0F, -19F);

		wheel_back_right[36].addShapeBox(-3F, -3F, -1F, 1, 6, 1, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 328
		wheel_back_right[36].setRotationPoint(-53F, 0F, -19F);

		wheel_back_right[37].addShapeBox(2F, -3F, -1F, 1, 6, 1, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 329
		wheel_back_right[37].setRotationPoint(-53F, 0F, -19F);

		wheel_back_right[38].addBox(-2F, -2F, -1.2F, 1, 1, 1, 0F); // Box 330
		wheel_back_right[38].setRotationPoint(-53F, 0F, -19F);

		wheel_back_right[39].addBox(1F, -2F, -1.2F, 1, 1, 1, 0F); // Box 331
		wheel_back_right[39].setRotationPoint(-53F, 0F, -19F);

		wheel_back_right[40].addBox(1F, 1F, -1.2F, 1, 1, 1, 0F); // Box 332
		wheel_back_right[40].setRotationPoint(-53F, 0F, -19F);

		wheel_back_right[41].addBox(-2F, 1F, -1.2F, 1, 1, 1, 0F); // Box 333
		wheel_back_right[41].setRotationPoint(-53F, 0F, -19F);

		//translateAll(0F, 0F, 0F);

		//flipAll();
	}
	
	@Override
	public void render(VehicleData data, String us){
		this.def_renderWheels4(data, us);
	}
	
	@Override
	public void render(VehicleData data, String us, Entity vehicle){
		this.def_renderWheels4(data, us, vehicle);
	}
	
}