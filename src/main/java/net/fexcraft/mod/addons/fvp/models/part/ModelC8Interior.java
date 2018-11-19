//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2018 Minecraft-SMP.de
// This file is for Fex's Vehicle & Transportation Mod
// Model: C1_R1
// Model Creator: FEX___96
// Created on: 22.08.2016 - 20:40:40
// Last changed on: 04.04.2018
package net.fexcraft.mod.addons.fvp.models.part;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.part.PartModel;

public class ModelC8Interior extends PartModel {

    public ModelC8Interior(){
    	super(); textureX = 512; textureY = 512;
        this.addToCreators("01e4af9b-2a30-471e-addf-f6338ffce04b");
        ModelRendererTurbo[] body = new ModelRendererTurbo[40];
        body[0] = new ModelRendererTurbo(this, 313, 225, textureX, textureY); // Box 144
        body[1] = new ModelRendererTurbo(this, 81, 161, textureX, textureY); // Box 159
        body[2] = new ModelRendererTurbo(this, 137, 17, textureX, textureY); // Box 183
        body[3] = new ModelRendererTurbo(this, 49, 25, textureX, textureY); // Box 184
        body[4] = new ModelRendererTurbo(this, 265, 25, textureX, textureY); // Box 185
        body[5] = new ModelRendererTurbo(this, 153, 33, textureX, textureY); // Box 188
        body[6] = new ModelRendererTurbo(this, 265, 33, textureX, textureY); // Box 189
        body[7] = new ModelRendererTurbo(this, 105, 41, textureX, textureY); // Box 190
        body[8] = new ModelRendererTurbo(this, 161, 41, textureX, textureY); // Box 191
        body[9] = new ModelRendererTurbo(this, 417, 41, textureX, textureY); // Box 192
        body[10] = new ModelRendererTurbo(this, 33, 49, textureX, textureY); // Box 193
        body[11] = new ModelRendererTurbo(this, 185, 49, textureX, textureY); // Box 194
        body[12] = new ModelRendererTurbo(this, 1, 57, textureX, textureY); // Box 198
        body[13] = new ModelRendererTurbo(this, 65, 65, textureX, textureY); // Box 199
        body[14] = new ModelRendererTurbo(this, 89, 65, textureX, textureY); // Box 200
        body[15] = new ModelRendererTurbo(this, 425, 137, textureX, textureY); // Box 218
        body[16] = new ModelRendererTurbo(this, 185, 161, textureX, textureY); // Box 219
        body[17] = new ModelRendererTurbo(this, 233, 97, textureX, textureY); // Box 220
        body[18] = new ModelRendererTurbo(this, 137, 113, textureX, textureY); // Box 221
        body[19] = new ModelRendererTurbo(this, 249, 105, textureX, textureY); // Box 222
        body[20] = new ModelRendererTurbo(this, 185, 65, textureX, textureY); // Box 223
        body[21] = new ModelRendererTurbo(this, 161, 65, textureX, textureY); // Box 224
        body[22] = new ModelRendererTurbo(this, 97, 121, textureX, textureY); // Box 225
        body[23] = new ModelRendererTurbo(this, 249, 65, textureX, textureY); // Box 227
        body[24] = new ModelRendererTurbo(this, 497, 65, textureX, textureY); // Box 228
        body[25] = new ModelRendererTurbo(this, 361, 73, textureX, textureY); // Box 229
        body[26] = new ModelRendererTurbo(this, 17, 81, textureX, textureY); // Box 230
        body[27] = new ModelRendererTurbo(this, 153, 113, textureX, textureY); // Box 231
        body[28] = new ModelRendererTurbo(this, 33, 81, textureX, textureY); // Box 232
        body[29] = new ModelRendererTurbo(this, 201, 81, textureX, textureY); // Box 233
        body[30] = new ModelRendererTurbo(this, 217, 81, textureX, textureY); // Box 234
        body[31] = new ModelRendererTurbo(this, 233, 81, textureX, textureY); // Box 235
        body[32] = new ModelRendererTurbo(this, 313, 113, textureX, textureY); // Box 236
        body[33] = new ModelRendererTurbo(this, 345, 113, textureX, textureY); // Box 237
        body[34] = new ModelRendererTurbo(this, 81, 105, textureX, textureY); // Box 238
        body[35] = new ModelRendererTurbo(this, 1, 225, textureX, textureY); // Box 239
        body[36] = new ModelRendererTurbo(this, 249, 81, textureX, textureY); // Box 240
        body[37] = new ModelRendererTurbo(this, 433, 113, textureX, textureY); // Box 260
        body[38] = new ModelRendererTurbo(this, 489, 113, textureX, textureY); // Box 261
        body[39] = new ModelRendererTurbo(this, 273, 81, textureX, textureY); // Box 262

        body[0].addShapeBox(0F, 0F, 0F, 4, 4, 42, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F); // Box 144
        body[0].setRotationPoint(21F, -9F, -21F);

        body[1].addShapeBox(0F, 0F, 0F, 5, 6, 12, 0F, -1F, 2F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 159
        body[1].setRotationPoint(19F, -10F, 5F);

        body[2].addShapeBox(0F, -2F, 0F, 1, 2, 1, 0F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 183
        body[2].setRotationPoint(19.6F, -10F, 16F);
        body[2].rotateAngleZ = -0.17453293F;

        body[3].addShapeBox(0F, 2F, 0F, 1, 2, 1, 0F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 184
        body[3].setRotationPoint(19.6F, -10F, 16F);
        body[3].rotateAngleZ = -0.17453293F;

        body[4].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 185
        body[4].setRotationPoint(19.6F, -10F, 16F);
        body[4].rotateAngleZ = -0.17453293F;

        body[5].addShapeBox(0F, 2F, -1F, 1, 2, 1, 0F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 188
        body[5].setRotationPoint(19.6F, -10F, 16F);
        body[5].rotateAngleZ = -0.17453293F;

        body[6].addShapeBox(0F, -2F, -1F, 1, 2, 1, 0F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 189
        body[6].setRotationPoint(19.6F, -10F, 16F);
        body[6].rotateAngleZ = -0.17453293F;

        body[7].addShapeBox(0F, -2F, -1F, 1, 2, 1, 0F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 190
        body[7].setRotationPoint(19.6F, -10F, 6F);
        body[7].rotateAngleZ = -0.17453293F;

        body[8].addShapeBox(0F, -2F, 0F, 1, 2, 1, 0F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 191
        body[8].setRotationPoint(19.6F, -10F, 6F);
        body[8].rotateAngleZ = -0.17453293F;

        body[9].addShapeBox(0F, 2F, 0F, 1, 2, 1, 0F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 192
        body[9].setRotationPoint(19.6F, -10F, 6F);
        body[9].rotateAngleZ = -0.17453293F;

        body[10].addShapeBox(0F, 2F, -1F, 1, 2, 1, 0F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 193
        body[10].setRotationPoint(19.6F, -10F, 6F);
        body[10].rotateAngleZ = -0.17453293F;

        body[11].addShapeBox(0F, 0F, -1F, 1, 2, 1, 0F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 194
        body[11].setRotationPoint(19.6F, -10F, 6F);
        body[11].rotateAngleZ = -0.17453293F;

        body[12].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 198
        body[12].setRotationPoint(20.8F, -8.5F, 17.25F);

        body[13].addShapeBox(0F, 0F, 1F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 199
        body[13].setRotationPoint(20.8F, -8.5F, 17.5F);

        body[14].addShapeBox(0F, 0F, 1F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 200
        body[14].setRotationPoint(20.8F, -8.5F, 18.75F);

        body[15].addShapeBox(0F, 0F, 0F, 4, 8, 5, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F); // Box 218
        body[15].setRotationPoint(21.5F, -5F, -2.5F);

        body[16].addShapeBox(0F, 0F, 0F, 18, 4, 5, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 1F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 1F); // Box 219
        body[16].setRotationPoint(3.5F, -1F, -2.5F);

        body[17].addShapeBox(0F, 0F, 0F, 6, 1, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 220
        body[17].setRotationPoint(5.5F, 0.6F, -1.5F);
        body[17].rotateAngleZ = 0.10471976F;

        body[18].addShapeBox(0F, 0F, 0F, 5, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 221
        body[18].setRotationPoint(6F, 0.3F, -0.5F);
        body[18].rotateAngleZ = 0.26179939F;

        body[19].addShapeBox(0F, 0F, 0F, 3, 1, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 222
        body[19].setRotationPoint(17.5F, -1F, -1.5F);
        body[19].rotateAngleZ = 0.17453293F;

        body[20].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 223
        body[20].setRotationPoint(18.5F, -3F, -0.5F);
        body[20].rotateAngleZ = 0.05235988F;

        body[21].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 224
        body[21].setRotationPoint(18.5F, -4F, -0.5F);
        body[21].rotateAngleZ = 0.05235988F;

        body[22].addBox(0F, 0F, 0F, 1, 3, 5, 0F); // Box 225
        body[22].setRotationPoint(20.9F, -8.5F, -2.5F);

        body[23].addShapeBox(0F, -0.5F, -0.5F, 1, 1, 1, 0F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F); // Box 227
        body[23].setRotationPoint(20.8F, -7.8F, 2F);

        body[24].addShapeBox(0F, -0.5F, -0.5F, 1, 1, 1, 0F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F); // Box 228
        body[24].setRotationPoint(20.8F, -7.8F, 2F);
        body[24].rotateAngleX = 0.78539816F;

        body[25].addShapeBox(0F, -0.5F, -0.5F, 1, 1, 1, 0F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F); // Box 229
        body[25].setRotationPoint(20.8F, -7.8F, -2F);
        body[25].rotateAngleX = 0.78539816F;

        body[26].addShapeBox(0F, -0.5F, -0.5F, 1, 1, 1, 0F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F); // Box 230
        body[26].setRotationPoint(20.8F, -7.8F, -2F);

        body[27].addShapeBox(0F, 0.2F, 1F, 1, 1, 3, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 231
        body[27].setRotationPoint(20.8F, -7.5F, -2.5F);

        body[28].addShapeBox(0F, 0.2F, 1F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 232
        body[28].setRotationPoint(20.8F, -6.5F, 0.3F);

        body[29].addShapeBox(0F, 0.2F, 1F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 233
        body[29].setRotationPoint(20.8F, -6.5F, -3.3F);

        body[30].addShapeBox(0F, 0.2F, 1F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 234
        body[30].setRotationPoint(20.8F, -6.5F, -0.9F);

        body[31].addShapeBox(0F, 0.2F, 1F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 235
        body[31].setRotationPoint(20.8F, -6.5F, -2.1F);

        body[32].addShapeBox(0F, 0F, 1F, 2, 1, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 236
        body[32].setRotationPoint(21.8F, -9.5F, 16.5F);

        body[33].addShapeBox(0F, 0F, 1F, 2, 1, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 237
        body[33].setRotationPoint(21.8F, -9.5F, -21.5F);

        body[34].addShapeBox(0F, 0F, 1F, 2, 1, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 238
        body[34].setRotationPoint(21.8F, -9.5F, -3F);

        body[35].addShapeBox(0F, 0F, 0F, 4, 3, 10, 0F, 0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.2F, 0F, 0F); // Box 239
        body[35].setRotationPoint(21F, -8.5F, -16F);

        body[36].addShapeBox(0F, 0F, 0F, 1, 1, 2, 0F, 0.2F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, 0.2F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0.2F, -0.2F, 0.2F); // Box 240
        body[36].setRotationPoint(21F, -6.5F, -12F);
        body[36].rotateAngleZ = -0.13962634F;

        body[37].addShapeBox(0F, 0F, 0F, 2, 1, 3, 0F, 1F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 1F, 1F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 260
        body[37].setRotationPoint(13F, -22.5F, 0F);

        body[38].addShapeBox(0F, 0F, 0F, 1, 2, 4, 0F, 0F, 0F, 0F, 0F, -0.3F, -0.3F, 0F, -0.3F, -0.3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, -0.3F, 0F, -0.3F, -0.3F, 0F, 0F, 0F); // Box 261
        body[38].setRotationPoint(12.5F, -21F, 0F);
        body[38].rotateAngleY = -0.52359878F;
        body[38].rotateAngleZ = 0.20943951F;

        body[39].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 262
        body[39].setRotationPoint(13.5F, -21.5F, 1F);
        this.add("body", body);
        //
        ModelRendererTurbo[] lights = new ModelRendererTurbo[6];
        lights[0] = new ModelRendererTurbo(this, 81, 33, textureX, textureY); // Box 186
        lights[1] = new ModelRendererTurbo(this, 137, 33, textureX, textureY); // Box 187
        lights[2] = new ModelRendererTurbo(this, 209, 49, textureX, textureY); // Box 195
        lights[3] = new ModelRendererTurbo(this, 265, 49, textureX, textureY); // Box 196
        lights[4] = new ModelRendererTurbo(this, 249, 89, textureX, textureY); // Box 197
        lights[5] = new ModelRendererTurbo(this, 65, 113, textureX, textureY); // Box 226

        lights[0].addShapeBox(0F, 0F, -1F, 1, 1, 1, 0F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 186
        lights[0].setRotationPoint(19.6F, -10F, 16F);
        lights[0].rotateAngleZ = 0.17453293F;

        lights[1].addShapeBox(0F, 1F, -1F, 1, 1, 1, 0F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 187
        lights[1].setRotationPoint(19.6F, -10F, 16F);
        lights[1].rotateAngleZ = 0.17453293F;

        lights[2].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 195
        lights[2].setRotationPoint(19.6F, -10F, 6F);
        lights[2].rotateAngleZ = 0.17453293F;

        lights[3].addShapeBox(0F, 1F, 0F, 1, 1, 1, 0F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 196
        lights[3].setRotationPoint(19.6F, -10F, 6F);
        lights[3].rotateAngleZ = 0.17453293F;

        lights[4].addShapeBox(0F, -2F, -3F, 1, 2, 6, 0F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 197
        lights[4].setRotationPoint(19.6F, -10F, 11F);
        lights[4].rotateAngleZ = 0.17453293F;

        lights[5].addBox(0F, 0.2F, 1F, 1, 1, 3, 0F); // Box 226
        lights[5].setRotationPoint(20.8F, -8.5F, -2.5F);
        this.add("lights", lights);
        fixRotations();
    }

}
