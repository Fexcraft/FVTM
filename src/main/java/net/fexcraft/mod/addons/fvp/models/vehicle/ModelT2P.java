//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2016 Minecraft-SMP.de
// This file is for Fex's Vehicle Mod
// Model: T1(P)
// Model Creator: FEX___96
// Created on: 20.01.2016 - 22:15:40
// Last changed on: 20.01.2016 - 22:15:40
package net.fexcraft.mod.addons.fvp.models.vehicle;

import net.fexcraft.mod.fvtm.model.vehicle.VehicleModelTMT;
import net.fexcraft.mod.lib.tmt.Coord2D;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.tmt.Shape2D;

public class ModelT2P extends VehicleModelTMT {

    public ModelT2P(){
    	super(); addToCreators("Ferdinand (FEX___96)");
        textureX = 512; textureY = 512;
        //
        body = new ModelRendererTurbo[55];
        body[0] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 0
        body[1] = new ModelRendererTurbo(this, 313, 1, textureX, textureY); // Box 5
        body[2] = new ModelRendererTurbo(this, 385, 9, textureX, textureY); // Box 6
        body[3] = new ModelRendererTurbo(this, 105, 33, textureX, textureY); // Box 7
        body[4] = new ModelRendererTurbo(this, 1, 57, textureX, textureY); // Box 8
        body[5] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 9
        body[6] = new ModelRendererTurbo(this, 265, 41, textureX, textureY); // Box 10
        body[7] = new ModelRendererTurbo(this, 385, 1, textureX, textureY); // Box 11
        body[8] = new ModelRendererTurbo(this, 241, 73, textureX, textureY); // Box 13
        body[9] = new ModelRendererTurbo(this, 1, 137, textureX, textureY); // Box 20
        body[10] = new ModelRendererTurbo(this, 185, 49, textureX, textureY); // Box 21
        body[11] = new ModelRendererTurbo(this, 329, 129, textureX, textureY); // Box 22
        body[12] = new ModelRendererTurbo(this, 425, 137, textureX, textureY); // Box 26
        body[13] = new ModelRendererTurbo(this, 449, 73, textureX, textureY); // Box 27
        body[14] = new ModelRendererTurbo(this, 121, 177, textureX, textureY); // Box 141
        body[15] = new ModelRendererTurbo(this, 249, 185, textureX, textureY); // Box 142
        body[16] = new ModelRendererTurbo(this, 377, 185, textureX, textureY); // Box 143
        body[17] = new ModelRendererTurbo(this, 1, 233, textureX, textureY); // Box 144
        body[18] = new ModelRendererTurbo(this, 89, 241, textureX, textureY); // Box 145
        body[19] = new ModelRendererTurbo(this, 353, 257, textureX, textureY); // Box 152
        body[20] = new ModelRendererTurbo(this, 73, 177, textureX, textureY); // Box 155
        body[21] = new ModelRendererTurbo(this, 193, 185, textureX, textureY); // Box 156
        body[22] = new ModelRendererTurbo(this, 321, 185, textureX, textureY); // Box 157
        body[23] = new ModelRendererTurbo(this, 233, 193, textureX, textureY); // Box 161
        body[24] = new ModelRendererTurbo(this, 361, 193, textureX, textureY); // Box 162
        body[25] = new ModelRendererTurbo(this, 49, 289, textureX, textureY); // Box 163
        body[26] = new ModelRendererTurbo(this, 89, 297, textureX, textureY); // Box 164
        body[27] = new ModelRendererTurbo(this, 161, 297, textureX, textureY); // Box 165
        body[28] = new ModelRendererTurbo(this, 233, 297, textureX, textureY); // Box 166
        body[29] = new ModelRendererTurbo(this, 305, 297, textureX, textureY); // Box 167
        body[30] = new ModelRendererTurbo(this, 345, 305, textureX, textureY); // Box 168
        body[31] = new ModelRendererTurbo(this, 417, 305, textureX, textureY); // Box 169
        body[32] = new ModelRendererTurbo(this, 65, 329, textureX, textureY); // Box 170
        body[33] = new ModelRendererTurbo(this, 137, 329, textureX, textureY); // Box 171
        body[34] = new ModelRendererTurbo(this, 209, 329, textureX, textureY); // Box 172
        body[35] = new ModelRendererTurbo(this, 281, 329, textureX, textureY); // Box 173
        body[36] = new ModelRendererTurbo(this, 1, 337, textureX, textureY); // Box 174
        body[37] = new ModelRendererTurbo(this, 297, 337, textureX, textureY); // Box 175
        body[38] = new ModelRendererTurbo(this, 409, 33, textureX, textureY); // Box 182
        body[39] = new ModelRendererTurbo(this, 25, 73, textureX, textureY); // Box 183
        body[40] = new ModelRendererTurbo(this, 417, 9, textureX, textureY); // Box 184
        body[41] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 185
        body[42] = new ModelRendererTurbo(this, 385, 17, textureX, textureY); // Box 196
        body[43] = new ModelRendererTurbo(this, 417, 17, textureX, textureY); // Box 197
        body[44] = new ModelRendererTurbo(this, 337, 33, textureX, textureY); // Box 198
        body[45] = new ModelRendererTurbo(this, 409, 41, textureX, textureY); // Box 199
        body[46] = new ModelRendererTurbo(this, 1, 33, textureX, textureY); // Box 200
        body[47] = new ModelRendererTurbo(this, 337, 41, textureX, textureY); // Box 201
        body[48] = new ModelRendererTurbo(this, 1, 49, textureX, textureY); // Box 202
        body[49] = new ModelRendererTurbo(this, 449, 49, textureX, textureY); // Box 203
        body[50] = new ModelRendererTurbo(this, 505, 73, textureX, textureY); // Box 328
        body[51] = new ModelRendererTurbo(this, 129, 81, textureX, textureY); // Box 329
        body[52] = new ModelRendererTurbo(this, 105, 89, textureX, textureY); // Box 330
        body[53] = new ModelRendererTurbo(this, 1, 217, textureX, textureY); // Box 331
        body[54] = new ModelRendererTurbo(this, 89, 265, textureX, textureY); // Box 332

        body[0].addBox(0F, 0F, 0F, 12, 5, 50, 0F); // Box 0
        body[0].setRotationPoint(54F, -2F, -25F);

        body[1].addBox(0F, 0F, 0F, 8, 5, 50, 0F); // Box 5
        body[1].setRotationPoint(18F, -2F, -25F);

        body[2].addShapeBox(0F, 0F, 0F, 4, 5, 52, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -3F, 0F, -1F, -3F, 0F, 0F, 0F); // Box 6
        body[2].setRotationPoint(66F, -2F, -26F);

        body[3].addShapeBox(0F, 0F, 0F, 84, 10, 4, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, -2F, 0F, 0F); // Box 7
        body[3].setRotationPoint(-66F, -9F, 8F);

        body[4].addShapeBox(0F, 0F, -4F, 84, 10, 4, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, -2F, 0F, 0F); // Box 8
        body[4].setRotationPoint(-66F, -9F, -8F);

        body[5].addShapeBox(0F, 0F, 0F, 12, 5, 20, 0F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 2F); // Box 9
        body[5].setRotationPoint(26F, -2F, -10F);

        body[6].addShapeBox(0F, 0F, 0F, 12, 5, 20, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, -2F, 0F); // Box 10
        body[6].setRotationPoint(42F, -2F, -10F);

        body[7].addBox(0F, 0F, 0F, 4, 3, 21, 0F); // Box 11
        body[7].setRotationPoint(38F, -2F, -10F);

        body[8].addBox(0F, 0F, 0F, 46, 1, 50, 0F); // Box 13
        body[8].setRotationPoint(20F, -19F, -25F);

        body[9].addBox(0F, 0F, 0F, 84, 5, 28, 0F); // Box 20
        body[9].setRotationPoint(-66F, -14F, -14F);

        body[10].addBox(-2F, -2F, 0F, 4, 4, 36, 0F); // Box 21
        body[10].setRotationPoint(40F, -2F, -18F);

        body[11].addBox(-2F, -2F, 0F, 4, 4, 36, 0F); // Box 22
        body[11].setRotationPoint(-47F, -2F, -18F);

        body[12].addShapeBox(0F, 0F, 0F, 20, 10, 16, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F); // Box 26
        body[12].setRotationPoint(-57F, -9F, -8F);

        body[13].addShapeBox(0F, 0F, 0F, 2, 15, 28, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F); // Box 27
        body[13].setRotationPoint(-68F, -14F, -14F);

        body[14].addShapeBox(0F, 0F, 0F, 10, 10, 50, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F); // Box 141
        body[14].setRotationPoint(20F, -12F, -25F);

        body[15].addShapeBox(0F, 0F, 0F, 10, 10, 50, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F); // Box 142
        body[15].setRotationPoint(50F, -12F, -25F);

        body[16].addShapeBox(0F, 0F, 0F, 16, 3, 50, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -6F, 0F, 0F, -6F, 0F, 0F, 0F, 0F, 0F); // Box 143
        body[16].setRotationPoint(20F, -15F, -25F);

        body[17].addShapeBox(0F, 0F, 0F, 16, 3, 50, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -6F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -6F, 0F, 0F); // Box 144
        body[17].setRotationPoint(44F, -15F, -25F);

        body[18].addBox(0F, 0F, 0F, 40, 3, 50, 0F); // Box 145
        body[18].setRotationPoint(20F, -18F, -25F);

        body[19].addBox(0F, -2F, -2F, 66, 4, 4, 0F); // Box 152
        body[19].setRotationPoint(-47F, -3F, 0F);
        body[19].rotateAngleX = -0.78539816F;

        body[20].addShapeBox(0F, 0F, 0F, 12, 13, 20, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F); // Box 155
        body[20].setRotationPoint(26F, -15F, -10F);

        body[21].addShapeBox(0F, 0F, 0F, 12, 13, 20, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F); // Box 156
        body[21].setRotationPoint(42F, -15F, -10F);

        body[22].addShapeBox(0F, 0F, 0F, 12, 13, 20, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 157
        body[22].setRotationPoint(38F, -15F, -10F);

        body[23].addShapeBox(0F, 0F, 0F, 4, 1, 28, 0F, 0F, -0.2F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.2F, 0F); // Box 161
        body[23].setRotationPoint(65.5F, -11F, -14F);

        body[24].addShapeBox(0F, 0F, 0F, 4, 1, 28, 0F, 0F, -0.2F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.2F, 0F); // Box 162
        body[24].setRotationPoint(65.5F, -12F, -14F);

        body[25].addShapeBox(0F, 0F, 0F, 4, 1, 28, 0F, 0F, -0.2F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.2F, 0F); // Box 163
        body[25].setRotationPoint(65.5F, -13F, -14F);

        body[26].addShapeBox(0F, 0F, 0F, 4, 1, 28, 0F, 0F, -0.2F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.2F, 0F); // Box 164
        body[26].setRotationPoint(65.5F, -14F, -14F);

        body[27].addShapeBox(0F, 0F, 0F, 4, 1, 28, 0F, 0F, -0.2F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.2F, 0F); // Box 165
        body[27].setRotationPoint(65.5F, -15F, -14F);

        body[28].addShapeBox(0F, 0F, 0F, 4, 1, 28, 0F, 0F, -0.2F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.2F, 0F); // Box 166
        body[28].setRotationPoint(65.5F, -16F, -14F);

        body[29].addShapeBox(0F, 0F, 0F, 4, 1, 28, 0F, 0F, -0.2F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.2F, 0F); // Box 167
        body[29].setRotationPoint(65.5F, -17F, -14F);

        body[30].addShapeBox(0F, 0F, 0F, 4, 1, 28, 0F, 0F, -0.2F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.2F, 0F); // Box 168
        body[30].setRotationPoint(65.5F, -18F, -14F);

        body[31].addShapeBox(0F, 0F, 0F, 4, 1, 28, 0F, 0F, -0.2F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.2F, 0F); // Box 169
        body[31].setRotationPoint(65.5F, -19F, -14F);

        body[32].addShapeBox(0F, 0F, 0F, 4, 1, 28, 0F, 0F, -0.2F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.2F, 0F); // Box 170
        body[32].setRotationPoint(65.5F, -20F, -14F);

        body[33].addShapeBox(0F, 0F, 0F, 4, 1, 28, 0F, 0F, -0.2F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.2F, 0F); // Box 171
        body[33].setRotationPoint(65.5F, -21F, -14F);

        body[34].addShapeBox(0F, 0F, 0F, 4, 1, 28, 0F, 0F, -0.2F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.2F, 0F); // Box 172
        body[34].setRotationPoint(65.5F, -22F, -14F);

        body[35].addShapeBox(0F, 0F, 0F, 4, 1, 28, 0F, 0F, -0.2F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.2F, 0F); // Box 173
        body[35].setRotationPoint(65.5F, -23F, -14F);

        body[36].addShapeBox(0F, 0F, 0F, 4, 1, 28, 0F, 0F, -0.2F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.2F, 0F); // Box 174
        body[36].setRotationPoint(65.5F, -24F, -14F);

        body[37].addBox(0F, 0F, 0F, 6, 16, 50, 0F); // Box 175
        body[37].setRotationPoint(60F, -18F, -25F);

        body[38].addBox(0F, 0F, 0F, 12, 5, 1, 0F); // Box 182
        body[38].setRotationPoint(54F, -2F, -26F);

        body[39].addBox(0F, 0F, 0F, 12, 5, 1, 0F); // Box 183
        body[39].setRotationPoint(54F, -2F, 25F);

        body[40].addBox(0F, 0F, 0F, 8, 5, 1, 0F); // Box 184
        body[40].setRotationPoint(18F, -2F, -26F);

        body[41].addBox(0F, 0F, 0F, 8, 5, 1, 0F); // Box 185
        body[41].setRotationPoint(18F, -2F, 25F);

        body[42].addBox(0F, 0F, 0F, 8, 2, 1, 0F); // Box 196
        body[42].setRotationPoint(56F, -4F, 24.8F);

        body[43].addBox(0F, 0F, 0F, 8, 2, 1, 0F); // Box 197
        body[43].setRotationPoint(56F, -9F, 24.8F);

        body[44].addBox(0F, 0F, 0F, 10, 2, 1, 0F); // Box 198
        body[44].setRotationPoint(54F, -14F, 24.8F);

        body[45].addBox(0F, 0F, 0F, 12, 2, 1, 0F); // Box 199
        body[45].setRotationPoint(51F, -18.8F, 24.8F);

        body[46].addBox(0F, 0F, 0F, 8, 2, 1, 0F); // Box 200
        body[46].setRotationPoint(56F, -4F, -25.8F);

        body[47].addBox(0F, 0F, 0F, 8, 2, 1, 0F); // Box 201
        body[47].setRotationPoint(56F, -9F, -25.8F);

        body[48].addBox(0F, 0F, 0F, 10, 2, 1, 0F); // Box 202
        body[48].setRotationPoint(54F, -14F, -25.8F);

        body[49].addBox(0F, 0F, 0F, 12, 2, 1, 0F); // Box 203
        body[49].setRotationPoint(51F, -18.8F, -25.8F);

        body[50].addShapeBox(0F, -1F, -1F, 1, 2, 2, 0F, 0F, 1F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 1F, 0F, 1F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 1F); // Box 328
        body[50].setRotationPoint(69F, -28F, 0F);
        body[50].rotateAngleZ = 0.05235988F;

        body[51].addShapeBox(0F, -1F, -1F, 1, 1, 4, 0F, 0F, 1F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 1F, 0F, 1F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 1F); // Box 329
        body[51].setRotationPoint(69.1F, 1F, -21F);
        body[51].rotateAngleZ = 0.05235988F;

        body[52].addShapeBox(0F, -1F, -1F, 1, 1, 4, 0F, 0F, 1F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 1F, 0F, 1F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 1F); // Box 330
        body[52].setRotationPoint(69.1F, 1F, 19F);
        body[52].rotateAngleZ = 0.05235988F;

        body[53].addBox(0F, 0F, 0F, 1, 3, 12, 0F); // Box 331
        body[53].setRotationPoint(69.2F, -3.5F, -6F);

        body[54].addBox(0F, 0F, 0F, 1, 3, 12, 0F); // Box 332
        body[54].setRotationPoint(-67F, -3.5F, -6F);
        body[54].rotateAngleZ = 0.15707963F;
        //
        body_colored_primary = new ModelRendererTurbo[52];
        body_colored_primary[0] = new ModelRendererTurbo(this, 129, 49, textureX, textureY); // Box 12
        body_colored_primary[1] = new ModelRendererTurbo(this, 1, 73, textureX, textureY); // Box 14
        body_colored_primary[2] = new ModelRendererTurbo(this, 449, 1, textureX, textureY); // Box 15
        body_colored_primary[3] = new ModelRendererTurbo(this, 481, 1, textureX, textureY); // Box 16
        body_colored_primary[4] = new ModelRendererTurbo(this, 385, 73, textureX, textureY); // Box 17
        body_colored_primary[5] = new ModelRendererTurbo(this, 65, 81, textureX, textureY); // Box 18
        body_colored_primary[6] = new ModelRendererTurbo(this, 193, 129, textureX, textureY); // Box 19
        body_colored_primary[7] = new ModelRendererTurbo(this, 377, 137, textureX, textureY); // Box 23
        body_colored_primary[8] = new ModelRendererTurbo(this, 449, 25, textureX, textureY); // Box 24
        body_colored_primary[9] = new ModelRendererTurbo(this, 465, 25, textureX, textureY); // Box 25
        body_colored_primary[10] = new ModelRendererTurbo(this, 65, 97, textureX, textureY); // Box 158
        body_colored_primary[11] = new ModelRendererTurbo(this, 385, 97, textureX, textureY); // Box 159
        body_colored_primary[12] = new ModelRendererTurbo(this, 1, 289, textureX, textureY); // Box 160
        body_colored_primary[13] = new ModelRendererTurbo(this, 361, 305, textureX, textureY); // Box 177
        body_colored_primary[14] = new ModelRendererTurbo(this, 1, 430, textureX, textureY); // Shape 178
        body_colored_primary[15] = new ModelRendererTurbo(this, 1, 430, textureX, textureY); // Shape 179
        body_colored_primary[16] = new ModelRendererTurbo(this, 1, 392, textureX, textureY); // Shape 180
        body_colored_primary[17] = new ModelRendererTurbo(this, 1, 392, textureX, textureY); // Shape 181
        body_colored_primary[18] = new ModelRendererTurbo(this, 1, 372, textureX, textureY); // Shape 186
        body_colored_primary[19] = new ModelRendererTurbo(this, 1, 372, textureX, textureY); // Shape 187
        body_colored_primary[20] = new ModelRendererTurbo(this, 1, 382, textureX, textureY); // Shape 188
        body_colored_primary[21] = new ModelRendererTurbo(this, 1, 382, textureX, textureY); // Shape 189
        body_colored_primary[22] = new ModelRendererTurbo(this, 49, 17, textureX, textureY); // Box 190
        body_colored_primary[23] = new ModelRendererTurbo(this, 1, 25, textureX, textureY); // Box 191
        body_colored_primary[24] = new ModelRendererTurbo(this, 49, 25, textureX, textureY); // Box 192
        body_colored_primary[25] = new ModelRendererTurbo(this, 57, 25, textureX, textureY); // Box 193
        body_colored_primary[26] = new ModelRendererTurbo(this, 37, 382, textureX, textureY); // Shape 194
        body_colored_primary[27] = new ModelRendererTurbo(this, 36, 382, textureX, textureY); // Shape 195
        body_colored_primary[28] = new ModelRendererTurbo(this, 409, 73, textureX, textureY); // Box 205
        body_colored_primary[29] = new ModelRendererTurbo(this, 25, 89, textureX, textureY); // Box 207
        body_colored_primary[30] = new ModelRendererTurbo(this, 465, 169, textureX, textureY); // Box 210
        body_colored_primary[31] = new ModelRendererTurbo(this, 73, 217, textureX, textureY); // Box 211
        body_colored_primary[32] = new ModelRendererTurbo(this, 321, 225, textureX, textureY); // Box 212
        body_colored_primary[33] = new ModelRendererTurbo(this, 1, 193, textureX, textureY); // Box 213
        body_colored_primary[34] = new ModelRendererTurbo(this, 241, 105, textureX, textureY); // Box 214
        body_colored_primary[35] = new ModelRendererTurbo(this, 121, 177, textureX, textureY); // Box 215
        body_colored_primary[36] = new ModelRendererTurbo(this, 225, 1, textureX, textureY); // Box 216
        body_colored_primary[37] = new ModelRendererTurbo(this, 289, 1, textureX, textureY); // Box 217
        body_colored_primary[38] = new ModelRendererTurbo(this, 44, 332, textureX, textureY); // Shape 222
        body_colored_primary[39] = new ModelRendererTurbo(this, 44, 332, textureX, textureY); // Shape 223
        body_colored_primary[40] = new ModelRendererTurbo(this, 169, 1, textureX, textureY); // Box 224
        body_colored_primary[41] = new ModelRendererTurbo(this, 65, 25, textureX, textureY); // Box 225
        body_colored_primary[42] = new ModelRendererTurbo(this, 353, 1, textureX, textureY); // Box 226
        body_colored_primary[43] = new ModelRendererTurbo(this, 481, 25, textureX, textureY); // Box 227
        body_colored_primary[44] = new ModelRendererTurbo(this, 505, 41, textureX, textureY); // Box 228
        body_colored_primary[45] = new ModelRendererTurbo(this, 185, 49, textureX, textureY); // Box 229
        body_colored_primary[46] = new ModelRendererTurbo(this, 401, 185, textureX, textureY); // Box 256
        body_colored_primary[47] = new ModelRendererTurbo(this, 49, 193, textureX, textureY); // Box 257
        body_colored_primary[48] = new ModelRendererTurbo(this, 473, 1, textureX, textureY); // Box 258
        body_colored_primary[49] = new ModelRendererTurbo(this, 145, 193, textureX, textureY); // Box 259
        body_colored_primary[50] = new ModelRendererTurbo(this, 273, 193, textureX, textureY); // Box 260
        body_colored_primary[51] = new ModelRendererTurbo(this, 385, 33, textureX, textureY); // Box 261

        body_colored_primary[0].addBox(0F, 0F, 0F, 2, 30, 50, 0F); // Box 12
        body_colored_primary[0].setRotationPoint(18F, -32F, -25F);

        body_colored_primary[1].addShapeBox(0F, 0F, 0F, 4, 2, 52, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F); // Box 14
        body_colored_primary[1].setRotationPoint(66F, -10F, -26F);

        body_colored_primary[2].addShapeBox(0F, 0F, 0F, 4, 14, 9, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 6F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 6F); // Box 15
        body_colored_primary[2].setRotationPoint(66F, -24F, -23F);

        body_colored_primary[3].addShapeBox(0F, 0F, 0F, 4, 14, 9, 0F, 0F, 0F, 6F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 6F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F); // Box 16
        body_colored_primary[3].setRotationPoint(66F, -24F, 14F);

        body_colored_primary[4].addShapeBox(0F, 0F, 0F, 4, 8, 52, 0F, 0.5F, 0F, 0F, -0.5F, 0F, -3F, -0.5F, 0F, -3F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F); // Box 17
        body_colored_primary[4].setRotationPoint(66F, -32F, -26F);

        body_colored_primary[5].addShapeBox(0F, 0F, 0F, 4, 4, 51, 0F, 1F, 0F, -0.5F, -1.5F, 0F, -3F, -1.5F, 0F, -3F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F); // Box 18
        body_colored_primary[5].setRotationPoint(62F, -56F, -25.5F);

        body_colored_primary[6].addBox(0F, 0F, 0F, 41, 2, 46, 0F); // Box 19
        body_colored_primary[6].setRotationPoint(20F, -56F, -23F);

        body_colored_primary[7].addShapeBox(0F, 0F, 0F, 4, 2, 38, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 23
        body_colored_primary[7].setRotationPoint(66F, -4F, -19F);

        body_colored_primary[8].addShapeBox(0F, 0F, 0F, 4, 20, 2, 0F, 0F, 0F, -0.5F, 0F, 0F, -3.5F, 0F, 0F, 3.5F, 0F, 0F, 0.5F, -3.5F, 0F, 0F, 3.5F, 0F, -3F, 3.5F, 0F, 3F, -3.5F, 0F, 0F); // Box 24
        body_colored_primary[8].setRotationPoint(62F, -52F, -26F);

        body_colored_primary[9].addShapeBox(0F, 0F, 0F, 4, 20, 2, 0F, 0F, 0F, 0.5F, 0F, 0F, 3.5F, 0F, 0F, -3.5F, 0F, 0F, -0.5F, -3.5F, 0F, 0F, 3.5F, 0F, 3F, 3.5F, 0F, -3F, -3.5F, 0F, 0F); // Box 25
        body_colored_primary[9].setRotationPoint(62F, -52F, 24F);

        body_colored_primary[10].addShapeBox(0F, 0F, 0F, 4, 6, 10, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F); // Box 158
        body_colored_primary[10].setRotationPoint(66F, -8F, -26F);

        body_colored_primary[11].addShapeBox(0F, 0F, 0F, 4, 6, 10, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F); // Box 159
        body_colored_primary[11].setRotationPoint(66F, -8F, 16F);

        body_colored_primary[12].addShapeBox(0F, 0F, 0F, 4, 2, 38, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F); // Box 160
        body_colored_primary[12].setRotationPoint(66F, -8F, -19F);

        body_colored_primary[13].addShapeBox(0F, 0F, 0F, 2, 24, 50, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 177
        body_colored_primary[13].setRotationPoint(18F, -56F, -25F);

        body_colored_primary[14].addShape3D(0F, 0F, 0F, new Shape2D(new Coord2D[]{new Coord2D(4, 0, 4, 0), new Coord2D(12, 0, 12, 0), new Coord2D(12, 10, 12, 10), new Coord2D(0, 10, 0, 10)}), 1, 12, 10, 41, 1, ModelRendererTurbo.MR_FRONT, new float[]{11, 12, 10, 8}); // Shape 178
        body_colored_primary[14].setRotationPoint(30F, -2F, 26F);

        body_colored_primary[15].addShape3D(0F, 0F, 0F, new Shape2D(new Coord2D[]{new Coord2D(4, 0, 4, 0), new Coord2D(12, 0, 12, 0), new Coord2D(12, 10, 12, 10), new Coord2D(0, 10, 0, 10)}), 1, 12, 10, 41, 1, ModelRendererTurbo.MR_FRONT, new float[]{11, 12, 10, 8}); // Shape 179
        body_colored_primary[15].setRotationPoint(30F, -2F, -25F);

        body_colored_primary[16].addShape3D(0F, 0F, 0F, new Shape2D(new Coord2D[]{new Coord2D(0, 0, 0, 0), new Coord2D(2, 0, 2, 0), new Coord2D(6, 10, 6, 10), new Coord2D(0, 10, 0, 10)}), 1, 6, 10, 29, 1, ModelRendererTurbo.MR_FRONT, new float[]{10, 6, 11, 2}); // Shape 180
        body_colored_primary[16].setRotationPoint(56F, -2F, 26F);

        body_colored_primary[17].addShape3D(0F, 0F, 0F, new Shape2D(new Coord2D[]{new Coord2D(0, 0, 0, 0), new Coord2D(2, 0, 2, 0), new Coord2D(6, 10, 6, 10), new Coord2D(0, 10, 0, 10)}), 1, 6, 10, 29, 1, ModelRendererTurbo.MR_FRONT, new float[]{10, 6, 11, 2}); // Shape 181
        body_colored_primary[17].setRotationPoint(56F, -2F, -25F);

        body_colored_primary[18].addShape3D(0F, 0F, 0F, new Shape2D(new Coord2D[]{new Coord2D(0, 3, 0, 3), new Coord2D(6, 0, 6, 0), new Coord2D(18, 0, 18, 0), new Coord2D(18, 7, 18, 7), new Coord2D(0, 7, 0, 7)}), 1, 18, 7, 48, 1, ModelRendererTurbo.MR_FRONT, new float[]{4, 18, 7, 12, 7}); // Shape 186
        body_colored_primary[18].setRotationPoint(36F, -12F, 26F);

        body_colored_primary[19].addShape3D(0F, 0F, 0F, new Shape2D(new Coord2D[]{new Coord2D(0, 3, 0, 3), new Coord2D(6, 0, 6, 0), new Coord2D(18, 0, 18, 0), new Coord2D(18, 7, 18, 7), new Coord2D(0, 7, 0, 7)}), 1, 18, 7, 48, 1, ModelRendererTurbo.MR_FRONT, new float[]{4, 18, 7, 12, 7}); // Shape 187
        body_colored_primary[19].setRotationPoint(36F, -12F, -25F);

        body_colored_primary[20].addShape3D(0F, 0F, 0F, new Shape2D(new Coord2D[]{new Coord2D(0, 0, 0, 0), new Coord2D(6, 0, 6, 0), new Coord2D(12, 3, 12, 3), new Coord2D(12, 7, 12, 7), new Coord2D(5, 7, 5, 7)}), 1, 12, 7, 33, 1, ModelRendererTurbo.MR_FRONT, new float[]{9, 7, 4, 7, 6}); // Shape 188
        body_colored_primary[20].setRotationPoint(56F, -12F, 26F);

        body_colored_primary[21].addShape3D(0F, 0F, 0F, new Shape2D(new Coord2D[]{new Coord2D(0, 0, 0, 0), new Coord2D(6, 0, 6, 0), new Coord2D(12, 3, 12, 3), new Coord2D(12, 7, 12, 7), new Coord2D(5, 7, 5, 7)}), 1, 12, 7, 33, 1, ModelRendererTurbo.MR_FRONT, new float[]{9, 7, 4, 7, 6}); // Shape 189
        body_colored_primary[21].setRotationPoint(56F, -12F, -25F);

        body_colored_primary[22].addBox(0F, 0F, 0F, 8, 4, 1, 0F); // Box 190
        body_colored_primary[22].setRotationPoint(36F, -19F, 25F);

        body_colored_primary[23].addBox(0F, 0F, 0F, 8, 4, 1, 0F); // Box 191
        body_colored_primary[23].setRotationPoint(36F, -19F, -26F);

        body_colored_primary[24].addBox(0F, 0F, 0F, 2, 10, 1, 0F); // Box 192
        body_colored_primary[24].setRotationPoint(64F, -12F, 25F);

        body_colored_primary[25].addBox(0F, 0F, 0F, 2, 10, 1, 0F); // Box 193
        body_colored_primary[25].setRotationPoint(64F, -12F, -26F);

        body_colored_primary[26].addShape3D(0F, 0F, 0F, new Shape2D(new Coord2D[]{new Coord2D(0, 0, 0, 0), new Coord2D(2, 0, 2, 0), new Coord2D(5, 7, 5, 7), new Coord2D(0, 7, 0, 7)}), 1, 6, 7, 22, 1, ModelRendererTurbo.MR_FRONT, new float[]{7, 5, 8, 2}); // Shape 194
        body_colored_primary[26].setRotationPoint(66F, -12F, 26F);

        body_colored_primary[27].addShape3D(0F, 0F, 0F, new Shape2D(new Coord2D[]{new Coord2D(0, 0, 0, 0), new Coord2D(2, 0, 2, 0), new Coord2D(5, 7, 5, 7), new Coord2D(0, 7, 0, 7)}), 1, 6, 7, 22, 1, ModelRendererTurbo.MR_FRONT, new float[]{7, 5, 8, 2}); // Shape 195
        body_colored_primary[27].setRotationPoint(66F, -12F, -25F);

        body_colored_primary[28].addShapeBox(0F, 0F, 0F, 4, 3, 9, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F); // Box 205
        body_colored_primary[28].setRotationPoint(66F, -13F, 17F);

        body_colored_primary[29].addShapeBox(0F, 0F, 0F, 4, 3, 9, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F); // Box 207
        body_colored_primary[29].setRotationPoint(66F, -13F, -26F);

        body_colored_primary[30].addShapeBox(0F, 0F, 0F, 20, 20, 2, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 210
        body_colored_primary[30].setRotationPoint(18F, -52F, 24F);

        body_colored_primary[31].addShapeBox(0F, 0F, 0F, 42, 4, 2, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 211
        body_colored_primary[31].setRotationPoint(18F, -56F, 23.5F);

        body_colored_primary[32].addShapeBox(0F, 0F, 0F, 42, 4, 2, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 212
        body_colored_primary[32].setRotationPoint(18F, -56F, -25.5F);

        body_colored_primary[33].addShapeBox(0F, 0F, 0F, 20, 20, 2, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 213
        body_colored_primary[33].setRotationPoint(18F, -52F, -26F);

        body_colored_primary[34].addBox(0F, 0F, 0F, 20, 13, 2, 0F); // Box 214
        body_colored_primary[34].setRotationPoint(18F, -32F, 24F);

        body_colored_primary[35].addBox(0F, 0F, 0F, 20, 13, 2, 0F); // Box 215
        body_colored_primary[35].setRotationPoint(18F, -32F, -26F);

        body_colored_primary[36].addShapeBox(0F, 0F, 0F, 2, 4, 2, 0F, 0F, 0F, -0.5F, -1F, 0F, -0.5F, -1F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 216
        body_colored_primary[36].setRotationPoint(60F, -56F, -25.5F);

        body_colored_primary[37].addShapeBox(0F, 0F, 0F, 2, 4, 2, 0F, 0F, 0F, 0.5F, -1F, 0F, 0.5F, -1F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 217
        body_colored_primary[37].setRotationPoint(60F, -56F, 23.5F);

        body_colored_primary[38].addShape3D(0F, 0F, 0F, new Shape2D(new Coord2D[]{new Coord2D(0, 0, 0, 0), new Coord2D(13, 0, 13, 0), new Coord2D(13, 13, 13, 13), new Coord2D(12, 13, 12, 13)}), 2, 13, 13, 45, 2, ModelRendererTurbo.MR_FRONT, new float[]{18, 1, 13, 13}); // Shape 222
        body_colored_primary[38].setRotationPoint(51F, -19F, 26F);

        body_colored_primary[39].addShape3D(0F, 0F, 0F, new Shape2D(new Coord2D[]{new Coord2D(0, 0, 0, 0), new Coord2D(13, 0, 13, 0), new Coord2D(13, 13, 13, 13), new Coord2D(12, 13, 12, 13)}), 2, 13, 13, 45, 2, ModelRendererTurbo.MR_FRONT, new float[]{18, 1, 13, 13}); // Shape 223
        body_colored_primary[39].setRotationPoint(51F, -19F, -24F);

        body_colored_primary[40].addBox(0F, 0F, 0F, 2, 5, 1, 0F); // Box 224
        body_colored_primary[40].setRotationPoint(64F, -24F, 25F);

        body_colored_primary[41].addShapeBox(0F, 0F, 0F, 2, 8, 1, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 225
        body_colored_primary[41].setRotationPoint(64F, -32F, 25F);

        body_colored_primary[42].addBox(0F, 0F, 0F, 2, 5, 1, 0F); // Box 226
        body_colored_primary[42].setRotationPoint(64F, -24F, -26F);

        body_colored_primary[43].addShapeBox(0F, 0F, 0F, 2, 8, 1, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 227
        body_colored_primary[43].setRotationPoint(64F, -32F, -26F);

        body_colored_primary[44].addShapeBox(0F, 0F, 0F, 1, 10, 2, 0F, 0.25F, 0F, 0.25F, -1.2F, 0F, 0.25F, -1.2F, 0F, -0.25F, 0.25F, 0F, -0.25F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F); // Box 228
        body_colored_primary[44].setRotationPoint(64F, -42F, 24F);

        body_colored_primary[45].addShapeBox(0F, 0F, 0F, 1, 10, 2, 0F, 0.25F, 0F, -0.25F, -1.2F, 0F, -0.25F, -1.2F, 0F, 0.25F, 0.25F, 0F, 0.25F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F); // Box 229
        body_colored_primary[45].setRotationPoint(64F, -42F, -26F);

        body_colored_primary[46].addShapeBox(0F, 0F, 0F, 3, 19, 2, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F); // Box 256
        body_colored_primary[46].setRotationPoint(15F, -32F, 24F);

        body_colored_primary[47].addShapeBox(0F, 0F, 0F, 3, 20, 2, 0F, 0F, 0F, -0.5F, 0F, 0F, 0.5F, 0F, 0F, -0.5F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F); // Box 257
        body_colored_primary[47].setRotationPoint(15F, -52F, 24F);

        body_colored_primary[48].addShapeBox(0F, 0F, 0F, 3, 4, 2, 0F, 0F, 0F, -0.5F, 0F, 0F, 0.5F, 0F, 0F, -0.5F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F); // Box 258
        body_colored_primary[48].setRotationPoint(15F, -56F, 23.5F);

        body_colored_primary[49].addShapeBox(0F, 0F, 0F, 3, 19, 2, 0F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F); // Box 259
        body_colored_primary[49].setRotationPoint(15F, -32F, -26F);

        body_colored_primary[50].addShapeBox(0F, 0F, 0F, 3, 20, 2, 0F, 0F, 0F, -1F, 0F, 0F, -0.5F, 0F, 0F, 0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F); // Box 260
        body_colored_primary[50].setRotationPoint(15F, -52F, -26F);

        body_colored_primary[51].addShapeBox(0F, 0F, 0F, 3, 4, 2, 0F, 0F, 0F, -1F, 0F, 0F, -0.5F, 0F, 0F, 0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F); // Box 261
        body_colored_primary[51].setRotationPoint(15F, -56F, -25.5F);
        //
        translateAll(0F, 0F, 0F);
        flipAll();
    }

}
