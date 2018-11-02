//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2018 Minecraft-SMP.de

// Model: BogieST1
// Model Creator: FEX___96
// Created on: 13.09.2018 - 10:49:51
// Last changed on: 13.09.2018 - 10:49:51

package net.fexcraft.mod.addons.fvp.models.bogie;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.part.AdjustableBogieModel;

public class ModelBogieST1 extends AdjustableBogieModel {

	public ModelBogieST1(){
		this.textureX = this.textureY = 256;
		ModelRendererTurbo[] chassis = new ModelRendererTurbo[43];
		chassis[0] = new ModelRendererTurbo(this, 113, 113, textureX, textureY); // Box 149
		chassis[1] = new ModelRendererTurbo(this, 145, 113, textureX, textureY); // Box 150
		chassis[2] = new ModelRendererTurbo(this, 217, 113, textureX, textureY); // Box 151
		chassis[3] = new ModelRendererTurbo(this, 233, 113, textureX, textureY); // Box 152
		chassis[4] = new ModelRendererTurbo(this, 1, 121, textureX, textureY); // Box 153
		chassis[5] = new ModelRendererTurbo(this, 25, 121, textureX, textureY); // Box 154
		chassis[6] = new ModelRendererTurbo(this, 161, 121, textureX, textureY); // Box 155
		chassis[7] = new ModelRendererTurbo(this, 57, 121, textureX, textureY); // Box 156
		chassis[8] = new ModelRendererTurbo(this, 73, 121, textureX, textureY); // Box 157
		chassis[9] = new ModelRendererTurbo(this, 89, 121, textureX, textureY); // Box 158
		chassis[10] = new ModelRendererTurbo(this, 193, 121, textureX, textureY); // Box 159
		chassis[11] = new ModelRendererTurbo(this, 113, 121, textureX, textureY); // Box 160
		chassis[12] = new ModelRendererTurbo(this, 249, 1, textureX, textureY); // Box 161
		chassis[13] = new ModelRendererTurbo(this, 145, 121, textureX, textureY); // Box 162
		chassis[14] = new ModelRendererTurbo(this, 249, 9, textureX, textureY); // Box 163
		chassis[15] = new ModelRendererTurbo(this, 161, 121, textureX, textureY); // Box 164
		chassis[16] = new ModelRendererTurbo(this, 209, 121, textureX, textureY); // Box 165
		chassis[17] = new ModelRendererTurbo(this, 1, 129, textureX, textureY); // Box 166
		chassis[18] = new ModelRendererTurbo(this, 217, 129, textureX, textureY); // Box 167
		chassis[19] = new ModelRendererTurbo(this, 1, 137, textureX, textureY); // Box 168
		chassis[20] = new ModelRendererTurbo(this, 241, 121, textureX, textureY); // Box 169
		chassis[21] = new ModelRendererTurbo(this, 89, 129, textureX, textureY); // Box 170
		chassis[22] = new ModelRendererTurbo(this, 201, 129, textureX, textureY); // Box 171
		chassis[23] = new ModelRendererTurbo(this, 153, 137, textureX, textureY); // Box 172
		chassis[24] = new ModelRendererTurbo(this, 177, 137, textureX, textureY); // Box 173
		chassis[25] = new ModelRendererTurbo(this, 209, 137, textureX, textureY); // Box 174
		chassis[26] = new ModelRendererTurbo(this, 193, 137, textureX, textureY); // Box 175
		chassis[27] = new ModelRendererTurbo(this, 1, 145, textureX, textureY); // Box 176
		chassis[28] = new ModelRendererTurbo(this, 241, 137, textureX, textureY); // Box 177
		chassis[29] = new ModelRendererTurbo(this, 25, 129, textureX, textureY); // Box 178
		chassis[30] = new ModelRendererTurbo(this, 129, 17, textureX, textureY); // Box 179
		chassis[31] = new ModelRendererTurbo(this, 73, 145, textureX, textureY); // Box 180
		chassis[32] = new ModelRendererTurbo(this, 89, 145, textureX, textureY); // Box 181
		chassis[33] = new ModelRendererTurbo(this, 105, 145, textureX, textureY); // Box 182
		chassis[34] = new ModelRendererTurbo(this, 249, 17, textureX, textureY); // Box 183
		chassis[35] = new ModelRendererTurbo(this, 89, 41, textureX, textureY); // Box 184
		chassis[36] = new ModelRendererTurbo(this, 225, 121, textureX, textureY); // Box 185
		chassis[37] = new ModelRendererTurbo(this, 121, 145, textureX, textureY); // Box 186
		chassis[38] = new ModelRendererTurbo(this, 137, 145, textureX, textureY); // Box 187
		chassis[39] = new ModelRendererTurbo(this, 33, 25, textureX, textureY); // Box 188
		chassis[40] = new ModelRendererTurbo(this, 249, 25, textureX, textureY); // Box 189
		chassis[41] = new ModelRendererTurbo(this, 33, 33, textureX, textureY); // Box 190
		chassis[42] = new ModelRendererTurbo(this, 249, 33, textureX, textureY); // Box 191

		chassis[0].addShapeBox(-4F, 0F, 0F, 8, 5, 13, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, 3F, 0F); // Box 149
		chassis[0].setRotationPoint(0F, -20F, 5F);

		chassis[1].addBox(0F, 0F, 0F, 32, 2, 2, 0F); // Box 150
		chassis[1].setRotationPoint(-16F, -20F, 17.2F);

		chassis[2].addBox(0F, 0F, 0F, 2, 6, 2, 0F); // Box 151
		chassis[2].setRotationPoint(-5F, -18F, 17.2F);

		chassis[3].addBox(0F, 0F, 0F, 2, 6, 2, 0F); // Box 152
		chassis[3].setRotationPoint(3F, -18F, 17.2F);

		chassis[4].addShapeBox(0F, 0F, 0F, 12, 2, 3, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 153
		chassis[4].setRotationPoint(-6F, -12F, 16.4F);

		chassis[5].addShapeBox(-4F, 0F, -13F, 8, 5, 13, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 154
		chassis[5].setRotationPoint(0F, -20F, -5F);

		chassis[6].addBox(-4F, 0F, -10F, 8, 5, 10, 0F); // Box 155
		chassis[6].setRotationPoint(0F, -20F, 5F);

		chassis[7].addShapeBox(0F, 0F, 0F, 2, 10, 2, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, -6F, -2F, 0F, 5F, -4F, 0F, 5F, -4F, 0F, -6F, -2F, 0F); // Box 156
		chassis[7].setRotationPoint(-12F, -18F, 17.2F);

		chassis[8].addShapeBox(0F, 0F, 0F, 2, 10, 2, 0F, 1F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 1F, 0F, -0.1F, 5F, -4F, -0.1F, -6F, -2F, -0.1F, -6F, -2F, -0.1F, 5F, -4F, -0.1F); // Box 157
		chassis[8].setRotationPoint(10F, -18F, 17.2F);

		chassis[9].addBox(0F, 0F, 0F, 4, 4, 3, 0F); // Box 158
		chassis[9].setRotationPoint(-18F, -18F, 16.5F);

		chassis[10].addBox(0F, 0F, 0F, 4, 4, 3, 0F); // Box 159
		chassis[10].setRotationPoint(14F, -18F, 16.5F);

		chassis[11].addShapeBox(0F, 0F, 0F, 3, 2, 2, 0F, -0.5F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 160
		chassis[11].setRotationPoint(-19F, -20F, 17.2F);

		chassis[12].addShapeBox(0F, 0F, 0F, 1, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F); // Box 161
		chassis[12].setRotationPoint(-19F, -18F, 17.2F);

		chassis[13].addShapeBox(0F, 0F, 0F, 3, 2, 2, 0F, 0F, 0F, 0F, -0.5F, -1F, 0F, -0.5F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 162
		chassis[13].setRotationPoint(16F, -20F, 17.2F);

		chassis[14].addShapeBox(0F, 0F, 0F, 1, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F); // Box 163
		chassis[14].setRotationPoint(18F, -18F, 17.2F);

		chassis[15].addShapeBox(0F, 0F, 0F, 2, 6, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F); // Box 164
		chassis[15].setRotationPoint(0.5F, -18F, 17.65F);

		chassis[16].addShapeBox(0F, 0F, 0F, 2, 6, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F); // Box 165
		chassis[16].setRotationPoint(-2.5F, -18F, 17.65F);

		chassis[17].addShapeBox(0F, 0F, 0F, 8, 1, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F); // Box 166
		chassis[17].setRotationPoint(-4F, -18.8F, 17.75F);

		chassis[18].addShapeBox(0F, 0F, 0F, 8, 1, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F); // Box 167
		chassis[18].setRotationPoint(-4F, -12.2F, 17.75F);

		chassis[19].addShapeBox(0F, 0F, 0F, 8, 1, 2, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 168
		chassis[19].setRotationPoint(-4F, -18.8F, -19.75F);

		chassis[20].addShapeBox(0F, 0F, 0F, 2, 6, 2, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 169
		chassis[20].setRotationPoint(-2.5F, -18F, -19.65F);

		chassis[21].addShapeBox(0F, 0F, 0F, 2, 6, 2, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 170
		chassis[21].setRotationPoint(0.5F, -18F, -19.65F);

		chassis[22].addBox(0F, 0F, 0F, 2, 6, 2, 0F); // Box 171
		chassis[22].setRotationPoint(3F, -18F, -19.2F);

		chassis[23].addShapeBox(0F, 0F, 0F, 8, 1, 2, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 172
		chassis[23].setRotationPoint(-4F, -12.2F, -19.75F);

		chassis[24].addBox(0F, 0F, 0F, 2, 6, 2, 0F); // Box 173
		chassis[24].setRotationPoint(-5F, -18F, -19.2F);

		chassis[25].addShapeBox(0F, 0F, 0F, 12, 2, 3, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 174
		chassis[25].setRotationPoint(-6F, -12F, -19.4F);

		chassis[26].addShapeBox(0F, 0F, 0F, 2, 10, 2, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, -6F, -2F, 0F, 5F, -4F, 0F, 5F, -4F, 0F, -6F, -2F, 0F); // Box 175
		chassis[26].setRotationPoint(-12F, -18F, -19.2F);

		chassis[27].addBox(0F, 0F, 0F, 32, 2, 2, 0F); // Box 176
		chassis[27].setRotationPoint(-16F, -20F, -19.2F);

		chassis[28].addShapeBox(0F, 0F, 0F, 2, 10, 2, 0F, 1F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 1F, 0F, -0.1F, 5F, -4F, -0.1F, -6F, -2F, -0.1F, -6F, -2F, -0.1F, 5F, -4F, -0.1F); // Box 177
		chassis[28].setRotationPoint(10F, -18F, -19.2F);

		chassis[29].addShapeBox(0F, 0F, 0F, 3, 2, 2, 0F, 0F, 0F, 0F, -0.5F, -1F, 0F, -0.5F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 178
		chassis[29].setRotationPoint(16F, -20F, -19.2F);

		chassis[30].addShapeBox(0F, 0F, 0F, 1, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F); // Box 179
		chassis[30].setRotationPoint(18F, -18F, -19.2F);

		chassis[31].addBox(0F, 0F, 0F, 4, 4, 3, 0F); // Box 180
		chassis[31].setRotationPoint(14F, -18F, -19.5F);

		chassis[32].addBox(0F, 0F, 0F, 4, 4, 3, 0F); // Box 181
		chassis[32].setRotationPoint(-18F, -18F, -19.5F);

		chassis[33].addShapeBox(0F, 0F, 0F, 3, 2, 2, 0F, -0.5F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 182
		chassis[33].setRotationPoint(-19F, -20F, -19.2F);

		chassis[34].addShapeBox(0F, 0F, 0F, 1, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F); // Box 183
		chassis[34].setRotationPoint(-19F, -18F, -19.2F);

		chassis[35].addShapeBox(2F, 0F, -1.5F, 1, 1, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.8F, 0F, 0F, 0.8F, 0F, 0F, 0F, 0F, 0F); // Box 184
		chassis[35].setRotationPoint(0F, -20.5F, 0F);

		chassis[36].addShapeBox(-3F, 0F, -1.5F, 1, 1, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.8F, 0F, 0F); // Box 185
		chassis[36].setRotationPoint(0F, -20.5F, 0F);

		chassis[37].addShapeBox(-1.5F, 0F, -3F, 3, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.8F, 0F, 0F, 0.8F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 186
		chassis[37].setRotationPoint(0F, -20.5F, 0F);

		chassis[38].addShapeBox(-1.5F, 0F, 2F, 3, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.8F, 0F, 0F, 0.8F); // Box 187
		chassis[38].setRotationPoint(0F, -20.5F, 0F);

		chassis[39].addShapeBox(-3F, 0F, -2.5F, 1, 1, 1, 0F, -1.5F, 0F, 0.5F, 0.5F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F, 0F, 0.5F, 0.5F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 188
		chassis[39].setRotationPoint(0F, -20.5F, 0F);

		chassis[40].addShapeBox(2F, 0F, -2.5F, 1, 1, 1, 0F, 0.5F, 0F, -0.5F, -1.5F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, -0.5F, -1.5F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 189
		chassis[40].setRotationPoint(0F, -20.5F, 0F);

		chassis[41].addShapeBox(2F, 0F, 1.5F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F, 0F, 0.5F, 0.5F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F, 0F, 0.5F, 0.5F, 0F, -0.5F); // Box 190
		chassis[41].setRotationPoint(0F, -20.5F, 0F);

		chassis[42].addShapeBox(-3F, 0F, 1.5F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, -0.5F, -1.5F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, -0.5F, -1.5F, 0F, 0.5F); // Box 191
		chassis[42].setRotationPoint(0F, -20.5F, 0F);
		this.add("chassis", chassis);

		ModelRendererTurbo[] axle0 = new ModelRendererTurbo[67];
		axle0[0] = new ModelRendererTurbo(this, 233, 1, textureX, textureY); // Box 0
		axle0[1] = new ModelRendererTurbo(this, 233, 9, textureX, textureY); // Box 1
		axle0[2] = new ModelRendererTurbo(this, 97, 17, textureX, textureY); // Box 2
		axle0[3] = new ModelRendererTurbo(this, 113, 17, textureX, textureY); // Box 3
		axle0[4] = new ModelRendererTurbo(this, 153, 17, textureX, textureY); // Box 4
		axle0[5] = new ModelRendererTurbo(this, 169, 17, textureX, textureY); // Box 5
		axle0[6] = new ModelRendererTurbo(this, 185, 17, textureX, textureY); // Box 6
		axle0[7] = new ModelRendererTurbo(this, 201, 17, textureX, textureY); // Box 7
		axle0[8] = new ModelRendererTurbo(this, 217, 17, textureX, textureY); // Box 8
		axle0[9] = new ModelRendererTurbo(this, 233, 17, textureX, textureY); // Box 9
		axle0[10] = new ModelRendererTurbo(this, 1, 25, textureX, textureY); // Box 10
		axle0[11] = new ModelRendererTurbo(this, 17, 25, textureX, textureY); // Box 11
		axle0[12] = new ModelRendererTurbo(this, 57, 25, textureX, textureY); // Box 12
		axle0[13] = new ModelRendererTurbo(this, 73, 25, textureX, textureY); // Box 13
		axle0[14] = new ModelRendererTurbo(this, 89, 25, textureX, textureY); // Box 14
		axle0[15] = new ModelRendererTurbo(this, 105, 25, textureX, textureY); // Box 15
		axle0[16] = new ModelRendererTurbo(this, 153, 25, textureX, textureY); // Box 16
		axle0[17] = new ModelRendererTurbo(this, 121, 25, textureX, textureY); // Box 17
		axle0[18] = new ModelRendererTurbo(this, 185, 25, textureX, textureY); // Box 18
		axle0[19] = new ModelRendererTurbo(this, 201, 25, textureX, textureY); // Box 19
		axle0[20] = new ModelRendererTurbo(this, 217, 25, textureX, textureY); // Box 20
		axle0[21] = new ModelRendererTurbo(this, 233, 25, textureX, textureY); // Box 21
		axle0[22] = new ModelRendererTurbo(this, 1, 33, textureX, textureY); // Box 22
		axle0[23] = new ModelRendererTurbo(this, 17, 33, textureX, textureY); // Box 23
		axle0[24] = new ModelRendererTurbo(this, 57, 33, textureX, textureY); // Box 24
		axle0[25] = new ModelRendererTurbo(this, 73, 33, textureX, textureY); // Box 25
		axle0[26] = new ModelRendererTurbo(this, 89, 33, textureX, textureY); // Box 26
		axle0[27] = new ModelRendererTurbo(this, 105, 33, textureX, textureY); // Box 27
		axle0[28] = new ModelRendererTurbo(this, 121, 33, textureX, textureY); // Box 28
		axle0[29] = new ModelRendererTurbo(this, 185, 33, textureX, textureY); // Box 29
		axle0[30] = new ModelRendererTurbo(this, 201, 33, textureX, textureY); // Box 30
		axle0[31] = new ModelRendererTurbo(this, 217, 33, textureX, textureY); // Box 31
		axle0[32] = new ModelRendererTurbo(this, 233, 33, textureX, textureY); // Box 32
		axle0[33] = new ModelRendererTurbo(this, 193, 41, textureX, textureY); // Box 33
		axle0[34] = new ModelRendererTurbo(this, 209, 41, textureX, textureY); // Box 34
		axle0[35] = new ModelRendererTurbo(this, 225, 41, textureX, textureY); // Box 35
		axle0[36] = new ModelRendererTurbo(this, 241, 41, textureX, textureY); // Box 36
		axle0[37] = new ModelRendererTurbo(this, 1, 49, textureX, textureY); // Box 37
		axle0[38] = new ModelRendererTurbo(this, 17, 49, textureX, textureY); // Box 38
		axle0[39] = new ModelRendererTurbo(this, 33, 49, textureX, textureY); // Box 39
		axle0[40] = new ModelRendererTurbo(this, 89, 49, textureX, textureY); // Box 40
		axle0[41] = new ModelRendererTurbo(this, 105, 49, textureX, textureY); // Box 41
		axle0[42] = new ModelRendererTurbo(this, 121, 49, textureX, textureY); // Box 42
		axle0[43] = new ModelRendererTurbo(this, 137, 49, textureX, textureY); // Box 43
		axle0[44] = new ModelRendererTurbo(this, 153, 49, textureX, textureY); // Box 44
		axle0[45] = new ModelRendererTurbo(this, 169, 49, textureX, textureY); // Box 45
		axle0[46] = new ModelRendererTurbo(this, 185, 49, textureX, textureY); // Box 46
		axle0[47] = new ModelRendererTurbo(this, 201, 49, textureX, textureY); // Box 47
		axle0[48] = new ModelRendererTurbo(this, 217, 49, textureX, textureY); // Box 48
		axle0[49] = new ModelRendererTurbo(this, 1, 57, textureX, textureY); // Box 49
		axle0[50] = new ModelRendererTurbo(this, 233, 49, textureX, textureY); // Box 50
		axle0[51] = new ModelRendererTurbo(this, 33, 57, textureX, textureY); // Box 51
		axle0[52] = new ModelRendererTurbo(this, 89, 57, textureX, textureY); // Box 52
		axle0[53] = new ModelRendererTurbo(this, 105, 57, textureX, textureY); // Box 53
		axle0[54] = new ModelRendererTurbo(this, 121, 57, textureX, textureY); // Box 54
		axle0[55] = new ModelRendererTurbo(this, 137, 57, textureX, textureY); // Box 55
		axle0[56] = new ModelRendererTurbo(this, 153, 57, textureX, textureY); // Box 56
		axle0[57] = new ModelRendererTurbo(this, 169, 57, textureX, textureY); // Box 57
		axle0[58] = new ModelRendererTurbo(this, 185, 57, textureX, textureY); // Box 58
		axle0[59] = new ModelRendererTurbo(this, 201, 57, textureX, textureY); // Box 59
		axle0[60] = new ModelRendererTurbo(this, 217, 57, textureX, textureY); // Box 60
		axle0[61] = new ModelRendererTurbo(this, 233, 57, textureX, textureY); // Box 61
		axle0[62] = new ModelRendererTurbo(this, 33, 65, textureX, textureY); // Box 62
		axle0[63] = new ModelRendererTurbo(this, 89, 65, textureX, textureY); // Box 63
		axle0[64] = new ModelRendererTurbo(this, 105, 65, textureX, textureY); // Box 64
		axle0[65] = new ModelRendererTurbo(this, 121, 65, textureX, textureY); // Box 65
		axle0[66] = new ModelRendererTurbo(this, 97, 57, textureX, textureY); // Box 66

		axle0[0].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 0
		axle0[0].setRotationPoint(16F, -16F, -16F);

		axle0[1].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 1
		axle0[1].setRotationPoint(16F, -16F, -16F);
		axle0[1].rotateAngleZ = -0.39269908F;

		axle0[2].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 2
		axle0[2].setRotationPoint(16F, -16F, -16F);
		axle0[2].rotateAngleZ = -0.78539816F;

		axle0[3].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 3
		axle0[3].setRotationPoint(16F, -16F, -16F);
		axle0[3].rotateAngleZ = -1.17809725F;

		axle0[4].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 4
		axle0[4].setRotationPoint(16F, -16F, -16F);
		axle0[4].rotateAngleZ = -1.57079633F;

		axle0[5].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 5
		axle0[5].setRotationPoint(16F, -16F, -16F);
		axle0[5].rotateAngleZ = -1.96349541F;

		axle0[6].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 6
		axle0[6].setRotationPoint(16F, -16F, -16F);
		axle0[6].rotateAngleZ = -2.35619449F;

		axle0[7].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 7
		axle0[7].setRotationPoint(16F, -16F, -16F);
		axle0[7].rotateAngleZ = -2.74889357F;

		axle0[8].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 8
		axle0[8].setRotationPoint(16F, -16F, -16F);
		axle0[8].rotateAngleZ = -3.14159265F;

		axle0[9].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 9
		axle0[9].setRotationPoint(16F, -16F, -16F);
		axle0[9].rotateAngleZ = -3.53429174F;

		axle0[10].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 10
		axle0[10].setRotationPoint(16F, -16F, -16F);
		axle0[10].rotateAngleZ = -3.92699082F;

		axle0[11].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 11
		axle0[11].setRotationPoint(16F, -16F, -16F);
		axle0[11].rotateAngleZ = -4.3196899F;

		axle0[12].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 12
		axle0[12].setRotationPoint(16F, -16F, -16F);
		axle0[12].rotateAngleZ = -4.71238898F;

		axle0[13].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 13
		axle0[13].setRotationPoint(16F, -16F, -16F);
		axle0[13].rotateAngleZ = -5.10508806F;

		axle0[14].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 14
		axle0[14].setRotationPoint(16F, -16F, -16F);
		axle0[14].rotateAngleZ = -5.49778714F;

		axle0[15].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 15
		axle0[15].setRotationPoint(16F, -16F, -16F);
		axle0[15].rotateAngleZ = -5.89048623F;

		axle0[16].addBox(-6F, -6F, -0.1F, 12, 12, 1, 0F); // Box 16
		axle0[16].setRotationPoint(16F, -16F, -16F);

		axle0[17].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F); // Box 17
		axle0[17].setRotationPoint(16F, -16F, -16F);

		axle0[18].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F); // Box 18
		axle0[18].setRotationPoint(16F, -16F, -16F);
		axle0[18].rotateAngleZ = -0.39269908F;

		axle0[19].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F); // Box 19
		axle0[19].setRotationPoint(16F, -16F, -16F);
		axle0[19].rotateAngleZ = -0.78539816F;

		axle0[20].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F); // Box 20
		axle0[20].setRotationPoint(16F, -16F, -16F);
		axle0[20].rotateAngleZ = -1.17809725F;

		axle0[21].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F); // Box 21
		axle0[21].setRotationPoint(16F, -16F, -16F);
		axle0[21].rotateAngleZ = -1.57079633F;

		axle0[22].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F); // Box 22
		axle0[22].setRotationPoint(16F, -16F, -16F);
		axle0[22].rotateAngleZ = -1.96349541F;

		axle0[23].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F); // Box 23
		axle0[23].setRotationPoint(16F, -16F, -16F);
		axle0[23].rotateAngleZ = -2.35619449F;

		axle0[24].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F); // Box 24
		axle0[24].setRotationPoint(16F, -16F, -16F);
		axle0[24].rotateAngleZ = -2.74889357F;

		axle0[25].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F); // Box 25
		axle0[25].setRotationPoint(16F, -16F, -16F);
		axle0[25].rotateAngleZ = -3.14159265F;

		axle0[26].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F); // Box 26
		axle0[26].setRotationPoint(16F, -16F, -16F);
		axle0[26].rotateAngleZ = -3.53429174F;

		axle0[27].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F); // Box 27
		axle0[27].setRotationPoint(16F, -16F, -16F);
		axle0[27].rotateAngleZ = -3.92699082F;

		axle0[28].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F); // Box 28
		axle0[28].setRotationPoint(16F, -16F, -16F);
		axle0[28].rotateAngleZ = -4.3196899F;

		axle0[29].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F); // Box 29
		axle0[29].setRotationPoint(16F, -16F, -16F);
		axle0[29].rotateAngleZ = -4.71238898F;

		axle0[30].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F); // Box 30
		axle0[30].setRotationPoint(16F, -16F, -16F);
		axle0[30].rotateAngleZ = -5.10508806F;

		axle0[31].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F); // Box 31
		axle0[31].setRotationPoint(16F, -16F, -16F);
		axle0[31].rotateAngleZ = -5.49778714F;

		axle0[32].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F); // Box 32
		axle0[32].setRotationPoint(16F, -16F, -16F);
		axle0[32].rotateAngleZ = -5.89048623F;

		axle0[33].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 33
		axle0[33].setRotationPoint(16F, -16F, 16F);

		axle0[34].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 34
		axle0[34].setRotationPoint(16F, -16F, 16F);
		axle0[34].rotateAngleZ = -0.39269908F;

		axle0[35].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 35
		axle0[35].setRotationPoint(16F, -16F, 16F);
		axle0[35].rotateAngleZ = -0.78539816F;

		axle0[36].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 36
		axle0[36].setRotationPoint(16F, -16F, 16F);
		axle0[36].rotateAngleZ = -1.17809725F;

		axle0[37].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 37
		axle0[37].setRotationPoint(16F, -16F, 16F);
		axle0[37].rotateAngleZ = -1.57079633F;

		axle0[38].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 38
		axle0[38].setRotationPoint(16F, -16F, 16F);
		axle0[38].rotateAngleZ = -1.96349541F;

		axle0[39].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 39
		axle0[39].setRotationPoint(16F, -16F, 16F);
		axle0[39].rotateAngleZ = -2.35619449F;

		axle0[40].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 40
		axle0[40].setRotationPoint(16F, -16F, 16F);
		axle0[40].rotateAngleZ = -2.74889357F;

		axle0[41].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 41
		axle0[41].setRotationPoint(16F, -16F, 16F);
		axle0[41].rotateAngleZ = -3.14159265F;

		axle0[42].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 42
		axle0[42].setRotationPoint(16F, -16F, 16F);
		axle0[42].rotateAngleZ = -3.53429174F;

		axle0[43].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 43
		axle0[43].setRotationPoint(16F, -16F, 16F);
		axle0[43].rotateAngleZ = -3.92699082F;

		axle0[44].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 44
		axle0[44].setRotationPoint(16F, -16F, 16F);
		axle0[44].rotateAngleZ = -4.3196899F;

		axle0[45].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 45
		axle0[45].setRotationPoint(16F, -16F, 16F);
		axle0[45].rotateAngleZ = -4.71238898F;

		axle0[46].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 46
		axle0[46].setRotationPoint(16F, -16F, 16F);
		axle0[46].rotateAngleZ = -5.10508806F;

		axle0[47].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 47
		axle0[47].setRotationPoint(16F, -16F, 16F);
		axle0[47].rotateAngleZ = -5.49778714F;

		axle0[48].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 48
		axle0[48].setRotationPoint(16F, -16F, 16F);
		axle0[48].rotateAngleZ = -5.89048623F;

		axle0[49].addBox(-6F, -6F, -0.1F, 12, 12, 1, 0F); // Box 49
		axle0[49].setRotationPoint(16F, -16F, 15F);

		axle0[50].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F); // Box 50
		axle0[50].setRotationPoint(16F, -16F, 13F);

		axle0[51].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F); // Box 51
		axle0[51].setRotationPoint(16F, -16F, 13F);
		axle0[51].rotateAngleZ = -0.39269908F;

		axle0[52].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F); // Box 52
		axle0[52].setRotationPoint(16F, -16F, 13F);
		axle0[52].rotateAngleZ = -0.78539816F;

		axle0[53].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F); // Box 53
		axle0[53].setRotationPoint(16F, -16F, 13F);
		axle0[53].rotateAngleZ = -1.17809725F;

		axle0[54].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F); // Box 54
		axle0[54].setRotationPoint(16F, -16F, 13F);
		axle0[54].rotateAngleZ = -1.57079633F;

		axle0[55].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F); // Box 55
		axle0[55].setRotationPoint(16F, -16F, 13F);
		axle0[55].rotateAngleZ = -1.96349541F;

		axle0[56].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F); // Box 56
		axle0[56].setRotationPoint(16F, -16F, 13F);
		axle0[56].rotateAngleZ = -2.35619449F;

		axle0[57].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F); // Box 57
		axle0[57].setRotationPoint(16F, -16F, 13F);
		axle0[57].rotateAngleZ = -2.74889357F;

		axle0[58].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F); // Box 58
		axle0[58].setRotationPoint(16F, -16F, 13F);
		axle0[58].rotateAngleZ = -3.14159265F;

		axle0[59].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F); // Box 59
		axle0[59].setRotationPoint(16F, -16F, 13F);
		axle0[59].rotateAngleZ = -3.53429174F;

		axle0[60].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F); // Box 60
		axle0[60].setRotationPoint(16F, -16F, 13F);
		axle0[60].rotateAngleZ = -3.92699082F;

		axle0[61].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F); // Box 61
		axle0[61].setRotationPoint(16F, -16F, 13F);
		axle0[61].rotateAngleZ = -4.3196899F;

		axle0[62].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F); // Box 62
		axle0[62].setRotationPoint(16F, -16F, 13F);
		axle0[62].rotateAngleZ = -4.71238898F;

		axle0[63].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F); // Box 63
		axle0[63].setRotationPoint(16F, -16F, 13F);
		axle0[63].rotateAngleZ = -5.10508806F;

		axle0[64].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F); // Box 64
		axle0[64].setRotationPoint(16F, -16F, 13F);
		axle0[64].rotateAngleZ = -5.49778714F;

		axle0[65].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F); // Box 65
		axle0[65].setRotationPoint(16F, -16F, 13F);
		axle0[65].rotateAngleZ = -5.89048623F;

		axle0[66].addBox(-1F, -1F, -17F, 2, 2, 34, 0F); // Box 66
		axle0[66].setRotationPoint(16F, -16F, 0F);
		this.add("axle0", axle0);

		ModelRendererTurbo[] axle1 = new ModelRendererTurbo[67];
		axle1[0] = new ModelRendererTurbo(this, 137, 65, textureX, textureY); // Box 67
		axle1[1] = new ModelRendererTurbo(this, 153, 65, textureX, textureY); // Box 68
		axle1[2] = new ModelRendererTurbo(this, 169, 65, textureX, textureY); // Box 69
		axle1[3] = new ModelRendererTurbo(this, 185, 65, textureX, textureY); // Box 70
		axle1[4] = new ModelRendererTurbo(this, 201, 65, textureX, textureY); // Box 71
		axle1[5] = new ModelRendererTurbo(this, 217, 65, textureX, textureY); // Box 72
		axle1[6] = new ModelRendererTurbo(this, 233, 65, textureX, textureY); // Box 73
		axle1[7] = new ModelRendererTurbo(this, 1, 73, textureX, textureY); // Box 74
		axle1[8] = new ModelRendererTurbo(this, 17, 73, textureX, textureY); // Box 75
		axle1[9] = new ModelRendererTurbo(this, 33, 73, textureX, textureY); // Box 76
		axle1[10] = new ModelRendererTurbo(this, 89, 73, textureX, textureY); // Box 77
		axle1[11] = new ModelRendererTurbo(this, 105, 73, textureX, textureY); // Box 78
		axle1[12] = new ModelRendererTurbo(this, 137, 73, textureX, textureY); // Box 79
		axle1[13] = new ModelRendererTurbo(this, 153, 73, textureX, textureY); // Box 80
		axle1[14] = new ModelRendererTurbo(this, 169, 73, textureX, textureY); // Box 81
		axle1[15] = new ModelRendererTurbo(this, 185, 73, textureX, textureY); // Box 82
		axle1[16] = new ModelRendererTurbo(this, 201, 73, textureX, textureY); // Box 83
		axle1[17] = new ModelRendererTurbo(this, 121, 73, textureX, textureY); // Box 84
		axle1[18] = new ModelRendererTurbo(this, 233, 73, textureX, textureY); // Box 85
		axle1[19] = new ModelRendererTurbo(this, 1, 81, textureX, textureY); // Box 86
		axle1[20] = new ModelRendererTurbo(this, 17, 81, textureX, textureY); // Box 87
		axle1[21] = new ModelRendererTurbo(this, 33, 81, textureX, textureY); // Box 88
		axle1[22] = new ModelRendererTurbo(this, 89, 81, textureX, textureY); // Box 89
		axle1[23] = new ModelRendererTurbo(this, 105, 81, textureX, textureY); // Box 90
		axle1[24] = new ModelRendererTurbo(this, 121, 81, textureX, textureY); // Box 91
		axle1[25] = new ModelRendererTurbo(this, 137, 81, textureX, textureY); // Box 92
		axle1[26] = new ModelRendererTurbo(this, 153, 81, textureX, textureY); // Box 93
		axle1[27] = new ModelRendererTurbo(this, 169, 81, textureX, textureY); // Box 94
		axle1[28] = new ModelRendererTurbo(this, 185, 81, textureX, textureY); // Box 95
		axle1[29] = new ModelRendererTurbo(this, 233, 81, textureX, textureY); // Box 96
		axle1[30] = new ModelRendererTurbo(this, 1, 89, textureX, textureY); // Box 97
		axle1[31] = new ModelRendererTurbo(this, 17, 89, textureX, textureY); // Box 98
		axle1[32] = new ModelRendererTurbo(this, 33, 89, textureX, textureY); // Box 99
		axle1[33] = new ModelRendererTurbo(this, 177, 89, textureX, textureY); // Box 100
		axle1[34] = new ModelRendererTurbo(this, 193, 89, textureX, textureY); // Box 101
		axle1[35] = new ModelRendererTurbo(this, 209, 89, textureX, textureY); // Box 102
		axle1[36] = new ModelRendererTurbo(this, 225, 89, textureX, textureY); // Box 103
		axle1[37] = new ModelRendererTurbo(this, 241, 89, textureX, textureY); // Box 104
		axle1[38] = new ModelRendererTurbo(this, 137, 97, textureX, textureY); // Box 105
		axle1[39] = new ModelRendererTurbo(this, 153, 97, textureX, textureY); // Box 106
		axle1[40] = new ModelRendererTurbo(this, 169, 97, textureX, textureY); // Box 107
		axle1[41] = new ModelRendererTurbo(this, 185, 97, textureX, textureY); // Box 108
		axle1[42] = new ModelRendererTurbo(this, 201, 97, textureX, textureY); // Box 109
		axle1[43] = new ModelRendererTurbo(this, 217, 97, textureX, textureY); // Box 110
		axle1[44] = new ModelRendererTurbo(this, 233, 97, textureX, textureY); // Box 111
		axle1[45] = new ModelRendererTurbo(this, 1, 105, textureX, textureY); // Box 112
		axle1[46] = new ModelRendererTurbo(this, 17, 105, textureX, textureY); // Box 113
		axle1[47] = new ModelRendererTurbo(this, 33, 105, textureX, textureY); // Box 114
		axle1[48] = new ModelRendererTurbo(this, 49, 105, textureX, textureY); // Box 115
		axle1[49] = new ModelRendererTurbo(this, 65, 105, textureX, textureY); // Box 116
		axle1[50] = new ModelRendererTurbo(this, 97, 105, textureX, textureY); // Box 117
		axle1[51] = new ModelRendererTurbo(this, 113, 105, textureX, textureY); // Box 118
		axle1[52] = new ModelRendererTurbo(this, 129, 105, textureX, textureY); // Box 119
		axle1[53] = new ModelRendererTurbo(this, 145, 105, textureX, textureY); // Box 120
		axle1[54] = new ModelRendererTurbo(this, 161, 105, textureX, textureY); // Box 121
		axle1[55] = new ModelRendererTurbo(this, 177, 105, textureX, textureY); // Box 122
		axle1[56] = new ModelRendererTurbo(this, 193, 105, textureX, textureY); // Box 123
		axle1[57] = new ModelRendererTurbo(this, 209, 105, textureX, textureY); // Box 124
		axle1[58] = new ModelRendererTurbo(this, 225, 105, textureX, textureY); // Box 125
		axle1[59] = new ModelRendererTurbo(this, 241, 105, textureX, textureY); // Box 126
		axle1[60] = new ModelRendererTurbo(this, 1, 113, textureX, textureY); // Box 127
		axle1[61] = new ModelRendererTurbo(this, 17, 113, textureX, textureY); // Box 128
		axle1[62] = new ModelRendererTurbo(this, 33, 113, textureX, textureY); // Box 129
		axle1[63] = new ModelRendererTurbo(this, 49, 113, textureX, textureY); // Box 130
		axle1[64] = new ModelRendererTurbo(this, 97, 113, textureX, textureY); // Box 131
		axle1[65] = new ModelRendererTurbo(this, 113, 113, textureX, textureY); // Box 132
		axle1[66] = new ModelRendererTurbo(this, 73, 105, textureX, textureY); // Box 133

		axle1[0].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 67
		axle1[0].setRotationPoint(-16F, -16F, -16F);

		axle1[1].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 68
		axle1[1].setRotationPoint(-16F, -16F, -16F);
		axle1[1].rotateAngleZ = -0.39269908F;

		axle1[2].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 69
		axle1[2].setRotationPoint(-16F, -16F, -16F);
		axle1[2].rotateAngleZ = -0.78539816F;

		axle1[3].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 70
		axle1[3].setRotationPoint(-16F, -16F, -16F);
		axle1[3].rotateAngleZ = -1.17809725F;

		axle1[4].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 71
		axle1[4].setRotationPoint(-16F, -16F, -16F);
		axle1[4].rotateAngleZ = -1.57079633F;

		axle1[5].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 72
		axle1[5].setRotationPoint(-16F, -16F, -16F);
		axle1[5].rotateAngleZ = -1.96349541F;

		axle1[6].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 73
		axle1[6].setRotationPoint(-16F, -16F, -16F);
		axle1[6].rotateAngleZ = -2.35619449F;

		axle1[7].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 74
		axle1[7].setRotationPoint(-16F, -16F, -16F);
		axle1[7].rotateAngleZ = -2.74889357F;

		axle1[8].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 75
		axle1[8].setRotationPoint(-16F, -16F, -16F);
		axle1[8].rotateAngleZ = -3.14159265F;

		axle1[9].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 76
		axle1[9].setRotationPoint(-16F, -16F, -16F);
		axle1[9].rotateAngleZ = -3.53429174F;

		axle1[10].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 77
		axle1[10].setRotationPoint(-16F, -16F, -16F);
		axle1[10].rotateAngleZ = -3.92699082F;

		axle1[11].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 78
		axle1[11].setRotationPoint(-16F, -16F, -16F);
		axle1[11].rotateAngleZ = -4.3196899F;

		axle1[12].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 79
		axle1[12].setRotationPoint(-16F, -16F, -16F);
		axle1[12].rotateAngleZ = -4.71238898F;

		axle1[13].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 80
		axle1[13].setRotationPoint(-16F, -16F, -16F);
		axle1[13].rotateAngleZ = -5.10508806F;

		axle1[14].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 81
		axle1[14].setRotationPoint(-16F, -16F, -16F);
		axle1[14].rotateAngleZ = -5.49778714F;

		axle1[15].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 82
		axle1[15].setRotationPoint(-16F, -16F, -16F);
		axle1[15].rotateAngleZ = -5.89048623F;

		axle1[16].addBox(-6F, -6F, -0.1F, 12, 12, 1, 0F); // Box 83
		axle1[16].setRotationPoint(-16F, -16F, -16F);

		axle1[17].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F); // Box 84
		axle1[17].setRotationPoint(-16F, -16F, -16F);

		axle1[18].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F); // Box 85
		axle1[18].setRotationPoint(-16F, -16F, -16F);
		axle1[18].rotateAngleZ = -0.39269908F;

		axle1[19].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F); // Box 86
		axle1[19].setRotationPoint(-16F, -16F, -16F);
		axle1[19].rotateAngleZ = -0.78539816F;

		axle1[20].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F); // Box 87
		axle1[20].setRotationPoint(-16F, -16F, -16F);
		axle1[20].rotateAngleZ = -1.17809725F;

		axle1[21].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F); // Box 88
		axle1[21].setRotationPoint(-16F, -16F, -16F);
		axle1[21].rotateAngleZ = -1.57079633F;

		axle1[22].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F); // Box 89
		axle1[22].setRotationPoint(-16F, -16F, -16F);
		axle1[22].rotateAngleZ = -1.96349541F;

		axle1[23].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F); // Box 90
		axle1[23].setRotationPoint(-16F, -16F, -16F);
		axle1[23].rotateAngleZ = -2.35619449F;

		axle1[24].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F); // Box 91
		axle1[24].setRotationPoint(-16F, -16F, -16F);
		axle1[24].rotateAngleZ = -2.74889357F;

		axle1[25].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F); // Box 92
		axle1[25].setRotationPoint(-16F, -16F, -16F);
		axle1[25].rotateAngleZ = -3.14159265F;

		axle1[26].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F); // Box 93
		axle1[26].setRotationPoint(-16F, -16F, -16F);
		axle1[26].rotateAngleZ = -3.53429174F;

		axle1[27].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F); // Box 94
		axle1[27].setRotationPoint(-16F, -16F, -16F);
		axle1[27].rotateAngleZ = -3.92699082F;

		axle1[28].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F); // Box 95
		axle1[28].setRotationPoint(-16F, -16F, -16F);
		axle1[28].rotateAngleZ = -4.3196899F;

		axle1[29].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F); // Box 96
		axle1[29].setRotationPoint(-16F, -16F, -16F);
		axle1[29].rotateAngleZ = -4.71238898F;

		axle1[30].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F); // Box 97
		axle1[30].setRotationPoint(-16F, -16F, -16F);
		axle1[30].rotateAngleZ = -5.10508806F;

		axle1[31].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F); // Box 98
		axle1[31].setRotationPoint(-16F, -16F, -16F);
		axle1[31].rotateAngleZ = -5.49778714F;

		axle1[32].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F); // Box 99
		axle1[32].setRotationPoint(-16F, -16F, -16F);
		axle1[32].rotateAngleZ = -5.89048623F;

		axle1[33].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 100
		axle1[33].setRotationPoint(-16F, -16F, 16F);

		axle1[34].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 101
		axle1[34].setRotationPoint(-16F, -16F, 16F);
		axle1[34].rotateAngleZ = -0.39269908F;

		axle1[35].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 102
		axle1[35].setRotationPoint(-16F, -16F, 16F);
		axle1[35].rotateAngleZ = -0.78539816F;

		axle1[36].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 103
		axle1[36].setRotationPoint(-16F, -16F, 16F);
		axle1[36].rotateAngleZ = -1.17809725F;

		axle1[37].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 104
		axle1[37].setRotationPoint(-16F, -16F, 16F);
		axle1[37].rotateAngleZ = -1.57079633F;

		axle1[38].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 105
		axle1[38].setRotationPoint(-16F, -16F, 16F);
		axle1[38].rotateAngleZ = -1.96349541F;

		axle1[39].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 106
		axle1[39].setRotationPoint(-16F, -16F, 16F);
		axle1[39].rotateAngleZ = -2.35619449F;

		axle1[40].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 107
		axle1[40].setRotationPoint(-16F, -16F, 16F);
		axle1[40].rotateAngleZ = -2.74889357F;

		axle1[41].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 108
		axle1[41].setRotationPoint(-16F, -16F, 16F);
		axle1[41].rotateAngleZ = -3.14159265F;

		axle1[42].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 109
		axle1[42].setRotationPoint(-16F, -16F, 16F);
		axle1[42].rotateAngleZ = -3.53429174F;

		axle1[43].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 110
		axle1[43].setRotationPoint(-16F, -16F, 16F);
		axle1[43].rotateAngleZ = -3.92699082F;

		axle1[44].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 111
		axle1[44].setRotationPoint(-16F, -16F, 16F);
		axle1[44].rotateAngleZ = -4.3196899F;

		axle1[45].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 112
		axle1[45].setRotationPoint(-16F, -16F, 16F);
		axle1[45].rotateAngleZ = -4.71238898F;

		axle1[46].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 113
		axle1[46].setRotationPoint(-16F, -16F, 16F);
		axle1[46].rotateAngleZ = -5.10508806F;

		axle1[47].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 114
		axle1[47].setRotationPoint(-16F, -16F, 16F);
		axle1[47].rotateAngleZ = -5.49778714F;

		axle1[48].addShapeBox(-1.5F, 6F, -1F, 3, 2, 2, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 115
		axle1[48].setRotationPoint(-16F, -16F, 16F);
		axle1[48].rotateAngleZ = -5.89048623F;

		axle1[49].addBox(-6F, -6F, -0.1F, 12, 12, 1, 0F); // Box 116
		axle1[49].setRotationPoint(-16F, -16F, 15F);

		axle1[50].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F); // Box 117
		axle1[50].setRotationPoint(-16F, -16F, 13F);

		axle1[51].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F); // Box 118
		axle1[51].setRotationPoint(-16F, -16F, 13F);
		axle1[51].rotateAngleZ = -0.39269908F;

		axle1[52].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F); // Box 119
		axle1[52].setRotationPoint(-16F, -16F, 13F);
		axle1[52].rotateAngleZ = -0.78539816F;

		axle1[53].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F); // Box 120
		axle1[53].setRotationPoint(-16F, -16F, 13F);
		axle1[53].rotateAngleZ = -1.17809725F;

		axle1[54].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F); // Box 121
		axle1[54].setRotationPoint(-16F, -16F, 13F);
		axle1[54].rotateAngleZ = -1.57079633F;

		axle1[55].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F); // Box 122
		axle1[55].setRotationPoint(-16F, -16F, 13F);
		axle1[55].rotateAngleZ = -1.96349541F;

		axle1[56].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F); // Box 123
		axle1[56].setRotationPoint(-16F, -16F, 13F);
		axle1[56].rotateAngleZ = -2.35619449F;

		axle1[57].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F); // Box 124
		axle1[57].setRotationPoint(-16F, -16F, 13F);
		axle1[57].rotateAngleZ = -2.74889357F;

		axle1[58].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F); // Box 125
		axle1[58].setRotationPoint(-16F, -16F, 13F);
		axle1[58].rotateAngleZ = -3.14159265F;

		axle1[59].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F); // Box 126
		axle1[59].setRotationPoint(-16F, -16F, 13F);
		axle1[59].rotateAngleZ = -3.53429174F;

		axle1[60].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F); // Box 127
		axle1[60].setRotationPoint(-16F, -16F, 13F);
		axle1[60].rotateAngleZ = -3.92699082F;

		axle1[61].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F); // Box 128
		axle1[61].setRotationPoint(-16F, -16F, 13F);
		axle1[61].rotateAngleZ = -4.3196899F;

		axle1[62].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F); // Box 129
		axle1[62].setRotationPoint(-16F, -16F, 13F);
		axle1[62].rotateAngleZ = -4.71238898F;

		axle1[63].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F); // Box 130
		axle1[63].setRotationPoint(-16F, -16F, 13F);
		axle1[63].rotateAngleZ = -5.10508806F;

		axle1[64].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F); // Box 131
		axle1[64].setRotationPoint(-16F, -16F, 13F);
		axle1[64].rotateAngleZ = -5.49778714F;

		axle1[65].addShapeBox(-1.5F, 6F, 1F, 3, 3, 1, 0F, -0.3F, 0F, -0.5F, -0.3F, 0F, -0.5F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.3F, 0F, -0.5F, 0.3F, 0F, -0.5F, 0.3F, 0F, 0F, 0.3F, 0F, 0F); // Box 132
		axle1[65].setRotationPoint(-16F, -16F, 13F);
		axle1[65].rotateAngleZ = -5.89048623F;

		axle1[66].addBox(-1F, -1F, -17F, 2, 2, 34, 0F); // Box 133
		axle1[66].setRotationPoint(-16F, -16F, 0F);
		this.add("axle1", axle1);
		
		translateAll(0F, 8F, 0F);
		flipAll();
	}
	
}