//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2017 Minecraft-SMP.de
// This file is for FVTM
// Model: C2 Type P
// Model Creator: FEX___96
// Created on: 24.08.2015 - 16:52:34
// Last changed on: 24.08.2015 - 16:52:34
package net.fexcraft.mod.addons.fvp.models.vehicle;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.vehicle.VehicleModel;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelC5 extends VehicleModel<VehicleData> {

    int textureX = 512;
    int textureY = 512;

    public ModelC5(){
        this.creators.add("Ferdinand (FEX___96)");
        body = new ModelRendererTurbo[72];
        body[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
        body[1] = new ModelRendererTurbo(this, 121, 9, textureX, textureY); // Box 2
        body[2] = new ModelRendererTurbo(this, 233, 17, textureX, textureY); // Box 88
        body[3] = new ModelRendererTurbo(this, 337, 33, textureX, textureY); // Box 80
        body[4] = new ModelRendererTurbo(this, 353, 81, textureX, textureY); // Box 82
        body[5] = new ModelRendererTurbo(this, 441, 25, textureX, textureY); // Box 98
        body[6] = new ModelRendererTurbo(this, 305, 81, textureX, textureY); // Box 99
        body[7] = new ModelRendererTurbo(this, 73, 177, textureX, textureY); // Box 114
        body[8] = new ModelRendererTurbo(this, 409, 201, textureX, textureY); // Box 118
        body[9] = new ModelRendererTurbo(this, 137, 249, textureX, textureY); // Box 121
        body[10] = new ModelRendererTurbo(this, 337, 137, textureX, textureY); // Box 88
        body[11] = new ModelRendererTurbo(this, 281, 249, textureX, textureY); // Box 124
        body[12] = new ModelRendererTurbo(this, 385, 321, textureX, textureY); // Box 217
        body[13] = new ModelRendererTurbo(this, 57, 113, textureX, textureY); // Box 254
        body[14] = new ModelRendererTurbo(this, 121, 137, textureX, textureY); // Box 255
        body[15] = new ModelRendererTurbo(this, 241, 105, textureX, textureY); // Box 260
        body[16] = new ModelRendererTurbo(this, 297, 1, textureX, textureY); // Box 261
        body[17] = new ModelRendererTurbo(this, 121, 113, textureX, textureY); // Box 262
        body[18] = new ModelRendererTurbo(this, 201, 65, textureX, textureY); // Box 263
        body[19] = new ModelRendererTurbo(this, 441, 81, textureX, textureY); // Box 304
        body[20] = new ModelRendererTurbo(this, 185, 97, textureX, textureY); // Box 305
        body[21] = new ModelRendererTurbo(this, 425, 41, textureX, textureY); // Box 306
        body[22] = new ModelRendererTurbo(this, 265, 81, textureX, textureY); // Box 307
        body[23] = new ModelRendererTurbo(this, 273, 1, textureX, textureY); // Box 308
        body[24] = new ModelRendererTurbo(this, 289, 1, textureX, textureY); // Box 309
        body[25] = new ModelRendererTurbo(this, 81, 81, textureX, textureY); // Box 310
        body[26] = new ModelRendererTurbo(this, 353, 1, textureX, textureY); // Box 311
        body[27] = new ModelRendererTurbo(this, 369, 1, textureX, textureY); // Box 312
        body[28] = new ModelRendererTurbo(this, 393, 1, textureX, textureY); // Box 313
        body[29] = new ModelRendererTurbo(this, 417, 1, textureX, textureY); // Box 314
        body[30] = new ModelRendererTurbo(this, 81, 97, textureX, textureY); // Box 315
        body[31] = new ModelRendererTurbo(this, 465, 1, textureX, textureY); // Box 316
        body[32] = new ModelRendererTurbo(this, 489, 1, textureX, textureY); // Box 317
        body[33] = new ModelRendererTurbo(this, 369, 81, textureX, textureY); // Box 318
        body[34] = new ModelRendererTurbo(this, 505, 1, textureX, textureY); // Box 319
        body[35] = new ModelRendererTurbo(this, 425, 81, textureX, textureY); // Box 321
        body[36] = new ModelRendererTurbo(this, 409, 193, textureX, textureY); // Box 322
        body[37] = new ModelRendererTurbo(this, 401, 257, textureX, textureY); // Box 323
        body[38] = new ModelRendererTurbo(this, 193, 41, textureX, textureY); // Box 328
        body[39] = new ModelRendererTurbo(this, 241, 41, textureX, textureY); // Box 329
        body[40] = new ModelRendererTurbo(this, 153, 9, textureX, textureY); // Box 330
        body[41] = new ModelRendererTurbo(this, 385, 9, textureX, textureY); // Box 335
        body[42] = new ModelRendererTurbo(this, 401, 9, textureX, textureY); // Box 336
        body[43] = new ModelRendererTurbo(this, 137, 65, textureX, textureY); // Box 337
        body[44] = new ModelRendererTurbo(this, 9, 73, textureX, textureY); // Box 338
        body[45] = new ModelRendererTurbo(this, 97, 89, textureX, textureY); // Box 339
        body[46] = new ModelRendererTurbo(this, 265, 89, textureX, textureY); // Box 340
        body[47] = new ModelRendererTurbo(this, 1, 9, textureX, textureY); // Box 341
        body[48] = new ModelRendererTurbo(this, 177, 9, textureX, textureY); // Box 342
        body[49] = new ModelRendererTurbo(this, 481, 9, textureX, textureY); // Box 343
        body[50] = new ModelRendererTurbo(this, 9, 17, textureX, textureY); // Box 344
        body[51] = new ModelRendererTurbo(this, 145, 113, textureX, textureY); // Box 345
        body[52] = new ModelRendererTurbo(this, 145, 121, textureX, textureY); // Box 346
        body[53] = new ModelRendererTurbo(this, 25, 17, textureX, textureY); // Box 347
        body[54] = new ModelRendererTurbo(this, 105, 17, textureX, textureY); // Box 348
        body[55] = new ModelRendererTurbo(this, 201, 17, textureX, textureY); // Box 349
        body[56] = new ModelRendererTurbo(this, 321, 17, textureX, textureY); // Box 350
        body[57] = new ModelRendererTurbo(this, 201, 97, textureX, textureY); // Box 351
        body[58] = new ModelRendererTurbo(this, 305, 97, textureX, textureY); // Box 352
        body[59] = new ModelRendererTurbo(this, 161, 97, textureX, textureY); // Box 353
        body[60] = new ModelRendererTurbo(this, 265, 97, textureX, textureY); // Box 354
        body[61] = new ModelRendererTurbo(this, 57, 169, textureX, textureY); // Box 354
        body[62] = new ModelRendererTurbo(this, 1, 177, textureX, textureY); // Box 355
        body[63] = new ModelRendererTurbo(this, 449, 1, textureX, textureY); // Box 462
        body[64] = new ModelRendererTurbo(this, 121, 169, textureX, textureY); // Box 463
        body[65] = new ModelRendererTurbo(this, 505, 17, textureX, textureY); // Box 464
        body[66] = new ModelRendererTurbo(this, 1, 177, textureX, textureY); // Box 465
        body[67] = new ModelRendererTurbo(this, 465, 41, textureX, textureY); // Box 466
        body[68] = new ModelRendererTurbo(this, 465, 49, textureX, textureY); // Box 467
        body[69] = new ModelRendererTurbo(this, 241, 209, textureX, textureY); // Box 468
        body[70] = new ModelRendererTurbo(this, 441, 25, textureX, textureY); // Box 469
        body[71] = new ModelRendererTurbo(this, 305, 81, textureX, textureY); // Box 470

        body[0].addBox(0F, 0F, 0F, 22, 9, 30, 0F); // Box 0
        body[0].setRotationPoint(35F, -3F, -15F);

        body[1].addShapeBox(0F, 0F, 0F, 3, 5, 46, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 2
        body[1].setRotationPoint(56F, 2F, -23F);

        body[2].addBox(0F, 0F, 0F, 2, 2, 42, 0F); // Box 88
        body[2].setRotationPoint(45F, 1F, -21F);

        body[3].addBox(0F, 0F, 0F, 16, 4, 30, 0F); // Box 80
        body[3].setRotationPoint(38F, -7F, -15F);

        body[4].addShapeBox(0F, 0F, 0F, 4, 5, 48, 0F, 0F, 0F, 0F, -0.5F, 0F, -1F, -0.5F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, -1F, -1F, -1F, -1F, 0F, 0F, 0F); // Box 82
        body[4].setRotationPoint(59F, 2F, -24F);

        body[5].addShapeBox(0F, 0F, 0F, 1, 1, 34, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 98
        body[5].setRotationPoint(60.8F, -4.15F, -17F);

        body[6].addShapeBox(0F, 0F, 0F, 1, 1, 34, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 99
        body[6].setRotationPoint(60.8F, -5.65F, -17F);

        body[7].addBox(0F, 0F, 0F, 22, 9, 34, 0F); // Box 114
        body[7].setRotationPoint(-37F, -3F, -17F);

        body[8].addShapeBox(0F, 0F, 0F, 2, 5, 46, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 118
        body[8].setRotationPoint(-38F, 2F, -23F);

        body[9].addBox(0F, 0F, 0F, 16, 4, 34, 0F); // Box 121
        body[9].setRotationPoint(-34F, -7F, -17F);

        body[10].addBox(0F, 0F, 0F, 2, 2, 42, 0F); // Box 88
        body[10].setRotationPoint(-27F, 1F, -21F);

        body[11].addShapeBox(0F, 0F, 0F, 4, 5, 48, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -1F); // Box 124
        body[11].setRotationPoint(-42F, 2F, -24F);

        body[12].addShapeBox(0F, 0F, 0F, 1, 14, 44, 0F, -8F, 0F, -2F, 8F, 0F, -2F, 8F, 0F, -2F, -8F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 217
        body[12].setRotationPoint(-38F, -23F, -22F);

        body[13].addShapeBox(0F, 0F, 0F, 16, 14, 0, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 254
        body[13].setRotationPoint(-32F, -23F, 22.5F);

        body[14].addShapeBox(0F, 0F, 0F, 16, 14, 0, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 255
        body[14].setRotationPoint(-32F, -23F, -22.5F);

        body[15].addShapeBox(0F, 0F, 0F, 11, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 4F, 0F, 0F, 0F); // Box 260
        body[15].setRotationPoint(-40F, 5F, -17F);

        body[16].addBox(0F, 0F, 0F, 2, 2, 2, 0F); // Box 261
        body[16].setRotationPoint(-42F, 5F, -17F);

        body[17].addShapeBox(0F, 0F, 0F, 8, 2, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 262
        body[17].setRotationPoint(-29F, 5.5F, -14.5F);

        body[18].addBox(0F, 0F, 0F, 7, 2, 2, 0F); // Box 263
        body[18].setRotationPoint(-21F, 5F, -13F);

        body[19].addShapeBox(0F, 0F, 0F, 3, 5, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 304
        body[19].setRotationPoint(56F, 2F, -24F);

        body[20].addShapeBox(0F, 0F, 0F, 3, 5, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 305
        body[20].setRotationPoint(56F, 2F, 23F);

        body[21].addShapeBox(0F, 0F, 0F, 1, 5, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 4F, 0F, 0F, -2F, 0F, 0F); // Box 306
        body[21].setRotationPoint(54F, -3F, -24F);

        body[22].addShapeBox(0F, 0F, 0F, 1, 5, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 4F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F); // Box 307
        body[22].setRotationPoint(54F, -3F, 23F);

        body[23].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F); // Box 308
        body[23].setRotationPoint(52F, -5F, -24F);

        body[24].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, -3F, 0F, 0F); // Box 309
        body[24].setRotationPoint(49F, -7F, -24F);

        body[25].addShapeBox(0F, 0F, 0F, 8, 1, 1, 0F, -1F, -0.5F, 0F, -1F, -0.5F, 0F, -1F, -0.5F, 0F, -1F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 310
        body[25].setRotationPoint(42F, -8F, -24F);

        body[26].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 3F, 0F, 0F); // Box 311
        body[26].setRotationPoint(42F, -7F, -24F);

        body[27].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F); // Box 312
        body[27].setRotationPoint(39F, -5F, -24F);

        body[28].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F); // Box 313
        body[28].setRotationPoint(52F, -5F, 23F);

        body[29].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, -3F, 0F, 0F); // Box 314
        body[29].setRotationPoint(49F, -7F, 23F);

        body[30].addShapeBox(0F, 0F, 0F, 8, 1, 1, 0F, -1F, -0.5F, 0F, -1F, -0.5F, 0F, -1F, -0.5F, 0F, -1F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 315
        body[30].setRotationPoint(42F, -8F, 23F);

        body[31].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 3F, 0F, 0F); // Box 316
        body[31].setRotationPoint(42F, -7F, 23F);

        body[32].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F); // Box 317
        body[32].setRotationPoint(39F, -5F, 23F);

        body[33].addShapeBox(0F, 0F, 0F, 1, 5, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 3F, 0F, 0F); // Box 318
        body[33].setRotationPoint(37F, -3F, -24F);

        body[34].addShapeBox(0F, 0F, 0F, 2, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 319
        body[34].setRotationPoint(34F, 5F, -24F);

        body[35].addShapeBox(0F, 0F, 0F, 1, 5, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F); // Box 321
        body[35].setRotationPoint(37F, -3F, 23F);

        body[36].addBox(0F, 0F, 0F, 48, 2, 1, 0F); // Box 322
        body[36].setRotationPoint(-14F, 5F, -24F);

        body[37].addBox(0F, 0F, 0F, 48, 2, 1, 0F); // Box 323
        body[37].setRotationPoint(-14F, 5F, 23F);

        body[38].addShapeBox(0F, 0F, 0F, 4, 3, 1, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 328
        body[38].setRotationPoint(32F, 2F, -24F);

        body[39].addShapeBox(0F, 0F, 0F, 4, 3, 1, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 329
        body[39].setRotationPoint(32F, 2F, 23F);

        body[40].addShapeBox(0F, 0F, 0F, 2, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 330
        body[40].setRotationPoint(34F, 5F, 23F);

        body[41].addShapeBox(0F, 0F, 0F, 2, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 335
        body[41].setRotationPoint(-16F, 5F, -24F);

        body[42].addShapeBox(0F, 0F, 0F, 2, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 336
        body[42].setRotationPoint(-16F, 5F, 23F);

        body[43].addShapeBox(0F, 0F, 0F, 4, 3, 1, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 337
        body[43].setRotationPoint(-16F, 2F, -24F);

        body[44].addShapeBox(0F, 0F, 0F, 4, 3, 1, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 338
        body[44].setRotationPoint(-16F, 2F, 23F);

        body[45].addShapeBox(0F, 0F, 0F, 1, 5, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 3F, 0F, 0F, -2F, 0F, 0F); // Box 339
        body[45].setRotationPoint(-18F, -3F, -24F);

        body[46].addShapeBox(0F, 0F, 0F, 1, 5, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 3F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F); // Box 340
        body[46].setRotationPoint(-18F, -3F, 23F);

        body[47].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F); // Box 341
        body[47].setRotationPoint(-20F, -5F, -24F);

        body[48].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, -3F, 0F, 0F); // Box 342
        body[48].setRotationPoint(-23F, -7F, -24F);

        body[49].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F); // Box 343
        body[49].setRotationPoint(-20F, -5F, 23F);

        body[50].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, -3F, 0F, 0F); // Box 344
        body[50].setRotationPoint(-23F, -7F, 23F);

        body[51].addShapeBox(0F, 0F, 0F, 8, 1, 1, 0F, -1F, -0.5F, 0F, -1F, -0.5F, 0F, -1F, -0.5F, 0F, -1F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 345
        body[51].setRotationPoint(-30F, -8F, -24F);

        body[52].addShapeBox(0F, 0F, 0F, 8, 1, 1, 0F, -1F, -0.5F, 0F, -1F, -0.5F, 0F, -1F, -0.5F, 0F, -1F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 346
        body[52].setRotationPoint(-30F, -8F, 23F);

        body[53].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 3F, 0F, 0F); // Box 347
        body[53].setRotationPoint(-30F, -7F, -24F);

        body[54].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F); // Box 348
        body[54].setRotationPoint(-33F, -5F, -24F);

        body[55].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 3F, 0F, 0F); // Box 349
        body[55].setRotationPoint(-30F, -7F, 23F);

        body[56].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F); // Box 350
        body[56].setRotationPoint(-33F, -5F, 23F);

        body[57].addShapeBox(0F, 0F, 0F, 2, 5, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 351
        body[57].setRotationPoint(-38F, 2F, -24F);

        body[58].addShapeBox(0F, 0F, 0F, 2, 5, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 352
        body[58].setRotationPoint(-38F, 2F, 23F);

        body[59].addShapeBox(0F, 0F, 0F, 1, 5, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 3F, 0F, 0F); // Box 353
        body[59].setRotationPoint(-35F, -3F, -24F);

        body[60].addShapeBox(0F, 0F, 0F, 1, 5, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F); // Box 354
        body[60].setRotationPoint(-35F, -3F, 23F);

        body[61].addBox(0F, 0F, 0F, 1, 3, 12, 0F); // Box 354
        body[61].setRotationPoint(61.7F, 2.5F, -6F);
        body[61].rotateAngleZ = -0.12217305F;

        body[62].addBox(0F, 0F, 0F, 1, 3, 12, 0F); // Box 355
        body[62].setRotationPoint(-41.2F, -2.5F, -6F);

        body[63].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, -2F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 2F); // Box 462
        body[63].setRotationPoint(32F, -11F, 21.5F);

        body[64].addShapeBox(0F, 0F, 0F, 1, 3, 4, 0F, -0.5F, -0.2F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, -0.3F, -0.5F, -0.2F, 0F, -0.5F, -0.2F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, -0.3F, -0.5F, -0.2F, 0F); // Box 463
        body[64].setRotationPoint(31.5F, -12F, 23F);
        body[64].rotateAngleY = 0.26179939F;

        body[65].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -2F); // Box 464
        body[65].setRotationPoint(32F, -11F, -22.5F);

        body[66].addShapeBox(0F, 0F, 0F, 1, 3, 4, 0F, -0.5F, -0.2F, 0F, 0F, -0.5F, -0.3F, 0F, -0.5F, 0F, -0.5F, -0.2F, 0F, -0.5F, -0.2F, 0F, 0F, -0.5F, -0.3F, 0F, -0.5F, 0F, -0.5F, -0.2F, 0F); // Box 465
        body[66].setRotationPoint(30.5F, -12F, -27F);
        body[66].rotateAngleY = -0.26179939F;

        body[67].addShapeBox(0F, 0F, 0F, 2, 1, 2, 0F, -0.3F, 0F, -0.3F, -0.3F, 0F, -0.3F, -0.3F, 0F, -0.3F, -0.3F, 0F, -0.3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 466
        body[67].setRotationPoint(61F, -8.5F, -1F);
        body[67].rotateAngleZ = -1.04719755F;

        body[68].addShapeBox(0F, 0F, 0F, 2, 1, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, 0F, -0.3F, -0.3F, 0F, -0.3F, -0.3F, 0F, -0.3F, -0.3F, 0F, -0.3F); // Box 467
        body[68].setRotationPoint(-40.3F, -8F, -1F);
        body[68].rotateAngleZ = -1.57079633F;

        body[69].addShapeBox(0F, 0F, 0F, 1, 1, 14, 0F, 0F, -0.5F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F); // Box 468
        body[69].setRotationPoint(-41.5F, -3.5F, -7F);

        body[70].addShapeBox(0F, 0F, 0F, 1, 1, 34, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 469
        body[70].setRotationPoint(60.8F, -4.9F, -17F);

        body[71].addShapeBox(0F, 0F, 0F, 1, 1, 34, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 470
        body[71].setRotationPoint(60.8F, -6.4F, -17F);

        bodyDoorOpenColoredPrimary = new ModelRendererTurbo[34];
        bodyDoorOpenColoredPrimary[0] = new ModelRendererTurbo(this, 465, 201, textureX, textureY); // Box 426
        bodyDoorOpenColoredPrimary[1] = new ModelRendererTurbo(this, 417, 137, textureX, textureY); // Box 427
        bodyDoorOpenColoredPrimary[2] = new ModelRendererTurbo(this, 505, 153, textureX, textureY); // Box 428
        bodyDoorOpenColoredPrimary[3] = new ModelRendererTurbo(this, 489, 161, textureX, textureY); // Box 429
        bodyDoorOpenColoredPrimary[4] = new ModelRendererTurbo(this, 409, 161, textureX, textureY); // Box 430
        bodyDoorOpenColoredPrimary[5] = new ModelRendererTurbo(this, 65, 65, textureX, textureY); // Box 431
        bodyDoorOpenColoredPrimary[6] = new ModelRendererTurbo(this, 57, 81, textureX, textureY); // Box 432
        bodyDoorOpenColoredPrimary[7] = new ModelRendererTurbo(this, 153, 185, textureX, textureY); // Box 434
        bodyDoorOpenColoredPrimary[8] = new ModelRendererTurbo(this, 201, 193, textureX, textureY); // Box 435
        bodyDoorOpenColoredPrimary[9] = new ModelRendererTurbo(this, 345, 193, textureX, textureY); // Box 436
        bodyDoorOpenColoredPrimary[10] = new ModelRendererTurbo(this, 465, 169, textureX, textureY); // Box 437
        bodyDoorOpenColoredPrimary[11] = new ModelRendererTurbo(this, 281, 249, textureX, textureY); // Box 438
        bodyDoorOpenColoredPrimary[12] = new ModelRendererTurbo(this, 25, 73, textureX, textureY); // Box 439
        bodyDoorOpenColoredPrimary[13] = new ModelRendererTurbo(this, 417, 161, textureX, textureY); // Box 440
        bodyDoorOpenColoredPrimary[14] = new ModelRendererTurbo(this, 425, 161, textureX, textureY); // Box 441
        bodyDoorOpenColoredPrimary[15] = new ModelRendererTurbo(this, 1, 209, textureX, textureY); // Box 442
        bodyDoorOpenColoredPrimary[16] = new ModelRendererTurbo(this, 1, 105, textureX, textureY); // Box 443
        bodyDoorOpenColoredPrimary[17] = new ModelRendererTurbo(this, 33, 169, textureX, textureY); // Box 444
        bodyDoorOpenColoredPrimary[18] = new ModelRendererTurbo(this, 409, 217, textureX, textureY); // Box 447
        bodyDoorOpenColoredPrimary[19] = new ModelRendererTurbo(this, 41, 169, textureX, textureY); // Box 448
        bodyDoorOpenColoredPrimary[20] = new ModelRendererTurbo(this, 457, 265, textureX, textureY); // Box 449
        bodyDoorOpenColoredPrimary[21] = new ModelRendererTurbo(this, 65, 225, textureX, textureY); // Box 450
        bodyDoorOpenColoredPrimary[22] = new ModelRendererTurbo(this, 257, 217, textureX, textureY); // Box 451
        bodyDoorOpenColoredPrimary[23] = new ModelRendererTurbo(this, 1, 233, textureX, textureY); // Box 452
        bodyDoorOpenColoredPrimary[24] = new ModelRendererTurbo(this, 129, 249, textureX, textureY); // Box 453
        bodyDoorOpenColoredPrimary[25] = new ModelRendererTurbo(this, 73, 73, textureX, textureY); // Box 454
        bodyDoorOpenColoredPrimary[26] = new ModelRendererTurbo(this, 249, 121, textureX, textureY); // Box 455
        bodyDoorOpenColoredPrimary[27] = new ModelRendererTurbo(this, 345, 249, textureX, textureY); // Box 456
        bodyDoorOpenColoredPrimary[28] = new ModelRendererTurbo(this, 1, 153, textureX, textureY); // Box 457
        bodyDoorOpenColoredPrimary[29] = new ModelRendererTurbo(this, 57, 169, textureX, textureY); // Box 457
        bodyDoorOpenColoredPrimary[30] = new ModelRendererTurbo(this, 289, 193, textureX, textureY); // Box 458
        bodyDoorOpenColoredPrimary[31] = new ModelRendererTurbo(this, 17, 177, textureX, textureY); // Box 459
        bodyDoorOpenColoredPrimary[32] = new ModelRendererTurbo(this, 137, 73, textureX, textureY); // Box 460
        bodyDoorOpenColoredPrimary[33] = new ModelRendererTurbo(this, 497, 129, textureX, textureY); // Box 461

        bodyDoorOpenColoredPrimary[0].addBox(0F, 0F, 0F, 1, 14, 21, 0F); // Box 426
        bodyDoorOpenColoredPrimary[0].setRotationPoint(29F, -9F, 22F);

        bodyDoorOpenColoredPrimary[1].addShapeBox(0F, 0F, 0F, 1, 5, 1, 0F, 0.7F, -1F, 0F, -0.7F, -1F, 0F, -0.7F, 0F, 0F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 427
        bodyDoorOpenColoredPrimary[1].setRotationPoint(29F, -14F, 22F);

        bodyDoorOpenColoredPrimary[2].addShapeBox(0F, 0F, 0F, 1, 14, 1, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 428
        bodyDoorOpenColoredPrimary[2].setRotationPoint(29F, -23F, 42F);

        bodyDoorOpenColoredPrimary[3].addBox(0F, 0F, 0F, 1, 1, 10, 0F); // Box 429
        bodyDoorOpenColoredPrimary[3].setRotationPoint(27F, -23F, 33F);
        bodyDoorOpenColoredPrimary[3].rotateAngleZ = 0.13962634F;

        bodyDoorOpenColoredPrimary[4].addShapeBox(0F, 0F, 0F, 1, 9, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 10F, -0.2F, 0F, 10F, -0.2F, 1F, -11F, 0.1F, 1F, -11F); // Box 430
        bodyDoorOpenColoredPrimary[4].setRotationPoint(27F, -23F, 33F);
        bodyDoorOpenColoredPrimary[4].rotateAngleZ = 0.15707963F;

        bodyDoorOpenColoredPrimary[5].addShapeBox(0F, -1F, 0F, 1, 1, 3, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.2F); // Box 431
        bodyDoorOpenColoredPrimary[5].setRotationPoint(29.5F, -6F, 37F);

        bodyDoorOpenColoredPrimary[6].addBox(0F, 0F, 0F, 1, 1, 4, 0F); // Box 432
        bodyDoorOpenColoredPrimary[6].setRotationPoint(28.5F, -7F, 25F);

        bodyDoorOpenColoredPrimary[7].addBox(0F, 0F, 0F, 1, 4, 15, 0F); // Box 434
        bodyDoorOpenColoredPrimary[7].setRotationPoint(7F, 1F, 22F);

        bodyDoorOpenColoredPrimary[8].addShapeBox(0F, 0F, 0F, 1, 3, 15, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 435
        bodyDoorOpenColoredPrimary[8].setRotationPoint(7F, -2F, 22F);

        bodyDoorOpenColoredPrimary[9].addShapeBox(0F, 0F, 0F, 1, 3, 17, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 436
        bodyDoorOpenColoredPrimary[9].setRotationPoint(7F, -5F, 22F);

        bodyDoorOpenColoredPrimary[10].addShapeBox(0F, 0F, 0F, 1, 1, 20, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 437
        bodyDoorOpenColoredPrimary[10].setRotationPoint(7F, -6F, 22F);

        bodyDoorOpenColoredPrimary[11].addBox(0F, 0F, 0F, 1, 3, 22, 0F); // Box 438
        bodyDoorOpenColoredPrimary[11].setRotationPoint(7F, -9F, 22F);

        bodyDoorOpenColoredPrimary[12].addShapeBox(0F, -1F, 0F, 1, 1, 3, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.2F); // Box 439
        bodyDoorOpenColoredPrimary[12].setRotationPoint(7.5F, -6F, 38F);

        bodyDoorOpenColoredPrimary[13].addShapeBox(0F, 0F, 0F, 1, 14, 1, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 440
        bodyDoorOpenColoredPrimary[13].setRotationPoint(7F, -23F, 22F);

        bodyDoorOpenColoredPrimary[14].addShapeBox(0F, 0F, 0F, 1, 14, 1, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 441
        bodyDoorOpenColoredPrimary[14].setRotationPoint(7F, -23F, 43F);

        bodyDoorOpenColoredPrimary[15].addBox(0F, 0F, 0F, 1, 1, 20, 0F); // Box 442
        bodyDoorOpenColoredPrimary[15].setRotationPoint(5F, -23F, 23F);
        bodyDoorOpenColoredPrimary[15].rotateAngleZ = 0.13962634F;

        bodyDoorOpenColoredPrimary[16].addBox(0F, 0F, 0F, 1, 1, 4, 0F); // Box 443
        bodyDoorOpenColoredPrimary[16].setRotationPoint(6.5F, -7F, 25F);

        bodyDoorOpenColoredPrimary[17].addShapeBox(0F, 0F, 0F, 1, 14, 1, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 444
        bodyDoorOpenColoredPrimary[17].setRotationPoint(7F, -23F, -23F);

        bodyDoorOpenColoredPrimary[18].addBox(0F, 0F, 0F, 1, 1, 20, 0F); // Box 447
        bodyDoorOpenColoredPrimary[18].setRotationPoint(5F, -23F, -43F);
        bodyDoorOpenColoredPrimary[18].rotateAngleZ = 0.13962634F;

        bodyDoorOpenColoredPrimary[19].addShapeBox(0F, 0F, 0F, 1, 14, 1, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 448
        bodyDoorOpenColoredPrimary[19].setRotationPoint(7F, -23F, -44F);

        bodyDoorOpenColoredPrimary[20].addBox(0F, 0F, 0F, 1, 3, 22, 0F); // Box 449
        bodyDoorOpenColoredPrimary[20].setRotationPoint(7F, -9F, -44F);

        bodyDoorOpenColoredPrimary[21].addShapeBox(0F, 0F, 0F, 1, 1, 20, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 450
        bodyDoorOpenColoredPrimary[21].setRotationPoint(7F, -6F, -42F);

        bodyDoorOpenColoredPrimary[22].addShapeBox(0F, 0F, 0F, 1, 3, 17, 0F, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 451
        bodyDoorOpenColoredPrimary[22].setRotationPoint(7F, -5F, -39F);

        bodyDoorOpenColoredPrimary[23].addShapeBox(0F, 0F, 0F, 1, 3, 15, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 452
        bodyDoorOpenColoredPrimary[23].setRotationPoint(7F, -2F, -37F);

        bodyDoorOpenColoredPrimary[24].addBox(0F, 0F, 0F, 1, 4, 15, 0F); // Box 453
        bodyDoorOpenColoredPrimary[24].setRotationPoint(7F, 1F, -37F);

        bodyDoorOpenColoredPrimary[25].addShapeBox(0F, -1F, 0F, 1, 1, 3, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.2F); // Box 454
        bodyDoorOpenColoredPrimary[25].setRotationPoint(7.5F, -6F, -41F);

        bodyDoorOpenColoredPrimary[26].addBox(0F, 0F, 0F, 1, 1, 4, 0F); // Box 455
        bodyDoorOpenColoredPrimary[26].setRotationPoint(6.5F, -7F, -29F);

        bodyDoorOpenColoredPrimary[27].addBox(0F, 0F, 0F, 1, 14, 21, 0F); // Box 456
        bodyDoorOpenColoredPrimary[27].setRotationPoint(29F, -9F, -43F);

        bodyDoorOpenColoredPrimary[28].addShapeBox(0F, 0F, 0F, 1, 5, 1, 0F, 0.7F, 0F, 0F, -0.7F, 0F, 0F, -0.7F, -1F, 0F, 0.7F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 457
        bodyDoorOpenColoredPrimary[28].setRotationPoint(29F, -14F, -23F);

        bodyDoorOpenColoredPrimary[29].addShapeBox(0F, 0F, 0F, 1, 9, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 1F, -11F, -0.2F, 1F, -11F, -0.2F, 0F, 10F, 0.1F, 0F, 10F); // Box 457
        bodyDoorOpenColoredPrimary[29].setRotationPoint(27F, -23F, -34F);
        bodyDoorOpenColoredPrimary[29].rotateAngleZ = 0.15707963F;

        bodyDoorOpenColoredPrimary[30].addShapeBox(0F, 0F, 0F, 1, 14, 1, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 458
        bodyDoorOpenColoredPrimary[30].setRotationPoint(29F, -23F, -43F);

        bodyDoorOpenColoredPrimary[31].addBox(0F, 0F, 0F, 1, 1, 10, 0F); // Box 459
        bodyDoorOpenColoredPrimary[31].setRotationPoint(27F, -23F, -43F);
        bodyDoorOpenColoredPrimary[31].rotateAngleZ = 0.13962634F;

        bodyDoorOpenColoredPrimary[32].addShapeBox(0F, -1F, 0F, 1, 1, 3, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.2F); // Box 460
        bodyDoorOpenColoredPrimary[32].setRotationPoint(29.5F, -6F, -40F);

        bodyDoorOpenColoredPrimary[33].addBox(0F, 0F, 0F, 1, 1, 4, 0F); // Box 461
        bodyDoorOpenColoredPrimary[33].setRotationPoint(28.5F, -7F, -29F);

        bodyDoorCloseColoredPrimary = new ModelRendererTurbo[34];
        bodyDoorCloseColoredPrimary[0] = new ModelRendererTurbo(this, 241, 193, textureX, textureY); // Box 388
        bodyDoorCloseColoredPrimary[1] = new ModelRendererTurbo(this, 97, 113, textureX, textureY); // Box 389
        bodyDoorCloseColoredPrimary[2] = new ModelRendererTurbo(this, 185, 121, textureX, textureY); // Box 390
        bodyDoorCloseColoredPrimary[3] = new ModelRendererTurbo(this, 161, 105, textureX, textureY); // Box 391
        bodyDoorCloseColoredPrimary[4] = new ModelRendererTurbo(this, 97, 129, textureX, textureY); // Box 392
        bodyDoorCloseColoredPrimary[5] = new ModelRendererTurbo(this, 425, 137, textureX, textureY); // Box 393
        bodyDoorCloseColoredPrimary[6] = new ModelRendererTurbo(this, 441, 137, textureX, textureY); // Box 394
        bodyDoorCloseColoredPrimary[7] = new ModelRendererTurbo(this, 209, 121, textureX, textureY); // Box 395
        bodyDoorCloseColoredPrimary[8] = new ModelRendererTurbo(this, 305, 121, textureX, textureY); // Box 396
        bodyDoorCloseColoredPrimary[9] = new ModelRendererTurbo(this, 57, 153, textureX, textureY); // Box 397
        bodyDoorCloseColoredPrimary[10] = new ModelRendererTurbo(this, 121, 153, textureX, textureY); // Box 398
        bodyDoorCloseColoredPrimary[11] = new ModelRendererTurbo(this, 1, 137, textureX, textureY); // Box 399
        bodyDoorCloseColoredPrimary[12] = new ModelRendererTurbo(this, 73, 169, textureX, textureY); // Box 400
        bodyDoorCloseColoredPrimary[13] = new ModelRendererTurbo(this, 369, 17, textureX, textureY); // Box 401
        bodyDoorCloseColoredPrimary[14] = new ModelRendererTurbo(this, 457, 17, textureX, textureY); // Box 402
        bodyDoorCloseColoredPrimary[15] = new ModelRendererTurbo(this, 385, 17, textureX, textureY); // Box 403
        bodyDoorCloseColoredPrimary[16] = new ModelRendererTurbo(this, 489, 17, textureX, textureY); // Box 405
        bodyDoorCloseColoredPrimary[17] = new ModelRendererTurbo(this, 441, 169, textureX, textureY); // Box 406
        bodyDoorCloseColoredPrimary[18] = new ModelRendererTurbo(this, 153, 177, textureX, textureY); // Box 407
        bodyDoorCloseColoredPrimary[19] = new ModelRendererTurbo(this, 193, 177, textureX, textureY); // Box 408
        bodyDoorCloseColoredPrimary[20] = new ModelRendererTurbo(this, 441, 177, textureX, textureY); // Box 409
        bodyDoorCloseColoredPrimary[21] = new ModelRendererTurbo(this, 57, 185, textureX, textureY); // Box 410
        bodyDoorCloseColoredPrimary[22] = new ModelRendererTurbo(this, 137, 25, textureX, textureY); // Box 411
        bodyDoorCloseColoredPrimary[23] = new ModelRendererTurbo(this, 345, 41, textureX, textureY); // Box 412
        bodyDoorCloseColoredPrimary[24] = new ModelRendererTurbo(this, 505, 137, textureX, textureY); // Box 413
        bodyDoorCloseColoredPrimary[25] = new ModelRendererTurbo(this, 33, 153, textureX, textureY); // Box 414
        bodyDoorCloseColoredPrimary[26] = new ModelRendererTurbo(this, 1, 193, textureX, textureY); // Box 415
        bodyDoorCloseColoredPrimary[27] = new ModelRendererTurbo(this, 409, 201, textureX, textureY); // Box 416
        bodyDoorCloseColoredPrimary[28] = new ModelRendererTurbo(this, 9, 49, textureX, textureY); // Box 417
        bodyDoorCloseColoredPrimary[29] = new ModelRendererTurbo(this, 457, 33, textureX, textureY); // Box 418
        bodyDoorCloseColoredPrimary[30] = new ModelRendererTurbo(this, 41, 153, textureX, textureY); // Box 419
        bodyDoorCloseColoredPrimary[31] = new ModelRendererTurbo(this, 57, 137, textureX, textureY); // Box 420
        bodyDoorCloseColoredPrimary[32] = new ModelRendererTurbo(this, 449, 145, textureX, textureY); // Box 421
        bodyDoorCloseColoredPrimary[33] = new ModelRendererTurbo(this, 457, 121, textureX, textureY); // Box 422

        bodyDoorCloseColoredPrimary[0].addBox(0F, 0F, 0F, 21, 14, 1, 0F); // Box 388
        bodyDoorCloseColoredPrimary[0].setRotationPoint(9F, -9F, 22F);

        bodyDoorCloseColoredPrimary[1].addShapeBox(0F, 0F, 0F, 1, 14, 1, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 389
        bodyDoorCloseColoredPrimary[1].setRotationPoint(9F, -23F, 22F);

        bodyDoorCloseColoredPrimary[2].addBox(0F, 0F, 0F, 10, 1, 1, 0F); // Box 390
        bodyDoorCloseColoredPrimary[2].setRotationPoint(9F, -23F, 20F);
        bodyDoorCloseColoredPrimary[2].rotateAngleX = 0.13962634F;

        bodyDoorCloseColoredPrimary[3].addShapeBox(0F, 0F, 0F, 1, 5, 1, 0F, 0F, 0F, 0.7F, 0F, 0F, 0.7F, 0F, 0F, -0.7F, 0F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 391
        bodyDoorCloseColoredPrimary[3].setRotationPoint(29F, -14F, 22F);

        bodyDoorCloseColoredPrimary[4].addShapeBox(0F, 0F, 0F, 1, 9, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -11F, 1F, 0.1F, 10F, 0F, 0.1F, 10F, 0F, -0.2F, -11F, 1F, -0.2F); // Box 392
        bodyDoorCloseColoredPrimary[4].setRotationPoint(18F, -23F, 20F);
        bodyDoorCloseColoredPrimary[4].rotateAngleX = 0.15707963F;

        bodyDoorCloseColoredPrimary[5].addShapeBox(0F, 0F, 0F, 1, 14, 1, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 393
        bodyDoorCloseColoredPrimary[5].setRotationPoint(7F, -23F, 22F);

        bodyDoorCloseColoredPrimary[6].addShapeBox(0F, 0F, 0F, 1, 14, 1, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 394
        bodyDoorCloseColoredPrimary[6].setRotationPoint(-14F, -23F, 22F);

        bodyDoorCloseColoredPrimary[7].addBox(0F, 0F, 0F, 20, 1, 1, 0F); // Box 395
        bodyDoorCloseColoredPrimary[7].setRotationPoint(-13F, -23F, 20F);
        bodyDoorCloseColoredPrimary[7].rotateAngleX = 0.13962634F;

        bodyDoorCloseColoredPrimary[8].addBox(0F, 0F, 0F, 15, 4, 1, 0F); // Box 396
        bodyDoorCloseColoredPrimary[8].setRotationPoint(-7F, 1F, 22F);

        bodyDoorCloseColoredPrimary[9].addShapeBox(0F, 0F, 0F, 15, 3, 1, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 397
        bodyDoorCloseColoredPrimary[9].setRotationPoint(-7F, -2F, 22F);

        bodyDoorCloseColoredPrimary[10].addShapeBox(0F, 0F, 0F, 17, 3, 1, 0F, 3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 398
        bodyDoorCloseColoredPrimary[10].setRotationPoint(-9F, -5F, 22F);

        bodyDoorCloseColoredPrimary[11].addShapeBox(0F, 0F, 0F, 20, 1, 1, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 399
        bodyDoorCloseColoredPrimary[11].setRotationPoint(-12F, -6F, 22F);

        bodyDoorCloseColoredPrimary[12].addBox(0F, 0F, 0F, 22, 3, 1, 0F); // Box 400
        bodyDoorCloseColoredPrimary[12].setRotationPoint(-14F, -9F, 22F);

        bodyDoorCloseColoredPrimary[13].addShapeBox(0F, -1F, 0F, 3, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F); // Box 401
        bodyDoorCloseColoredPrimary[13].setRotationPoint(12F, -6F, 22.5F);

        bodyDoorCloseColoredPrimary[14].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 402
        bodyDoorCloseColoredPrimary[14].setRotationPoint(22F, -7F, 21.5F);

        bodyDoorCloseColoredPrimary[15].addShapeBox(0F, -1F, 0F, 3, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F); // Box 403
        bodyDoorCloseColoredPrimary[15].setRotationPoint(-11F, -6F, 22.5F);

        bodyDoorCloseColoredPrimary[16].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 405
        bodyDoorCloseColoredPrimary[16].setRotationPoint(1F, -7F, 21.5F);

        bodyDoorCloseColoredPrimary[17].addBox(0F, 0F, 0F, 15, 4, 1, 0F); // Box 406
        bodyDoorCloseColoredPrimary[17].setRotationPoint(-7F, 1F, -23F);

        bodyDoorCloseColoredPrimary[18].addShapeBox(0F, 0F, 0F, 15, 3, 1, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 407
        bodyDoorCloseColoredPrimary[18].setRotationPoint(-7F, -2F, -23F);

        bodyDoorCloseColoredPrimary[19].addShapeBox(0F, 0F, 0F, 17, 3, 1, 0F, 3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 408
        bodyDoorCloseColoredPrimary[19].setRotationPoint(-9F, -5F, -23F);

        bodyDoorCloseColoredPrimary[20].addShapeBox(0F, 0F, 0F, 20, 1, 1, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 409
        bodyDoorCloseColoredPrimary[20].setRotationPoint(-12F, -6F, -23F);

        bodyDoorCloseColoredPrimary[21].addBox(0F, 0F, 0F, 22, 3, 1, 0F); // Box 410
        bodyDoorCloseColoredPrimary[21].setRotationPoint(-14F, -9F, -23F);

        bodyDoorCloseColoredPrimary[22].addShapeBox(0F, -1F, 0F, 3, 1, 1, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F); // Box 411
        bodyDoorCloseColoredPrimary[22].setRotationPoint(-11F, -6F, -23.5F);

        bodyDoorCloseColoredPrimary[23].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 412
        bodyDoorCloseColoredPrimary[23].setRotationPoint(1F, -7F, -22.5F);

        bodyDoorCloseColoredPrimary[24].addShapeBox(0F, 0F, 0F, 1, 14, 1, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 413
        bodyDoorCloseColoredPrimary[24].setRotationPoint(-14F, -23F, -23F);

        bodyDoorCloseColoredPrimary[25].addShapeBox(0F, 0F, 0F, 1, 14, 1, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 414
        bodyDoorCloseColoredPrimary[25].setRotationPoint(7F, -23F, -23F);

        bodyDoorCloseColoredPrimary[26].addBox(0F, 0F, 0F, 20, 1, 1, 0F); // Box 415
        bodyDoorCloseColoredPrimary[26].setRotationPoint(-13F, -23F, -21F);
        bodyDoorCloseColoredPrimary[26].rotateAngleX = -0.13962634F;

        bodyDoorCloseColoredPrimary[27].addBox(0F, 0F, 0F, 21, 14, 1, 0F); // Box 416
        bodyDoorCloseColoredPrimary[27].setRotationPoint(9F, -9F, -23F);

        bodyDoorCloseColoredPrimary[28].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 417
        bodyDoorCloseColoredPrimary[28].setRotationPoint(23F, -7F, -22.5F);

        bodyDoorCloseColoredPrimary[29].addShapeBox(0F, -1F, 0F, 3, 1, 1, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F); // Box 418
        bodyDoorCloseColoredPrimary[29].setRotationPoint(12F, -6F, -23.5F);

        bodyDoorCloseColoredPrimary[30].addShapeBox(0F, 0F, 0F, 1, 14, 1, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 419
        bodyDoorCloseColoredPrimary[30].setRotationPoint(9F, -23F, -23F);

        bodyDoorCloseColoredPrimary[31].addBox(0F, 0F, 0F, 10, 1, 1, 0F); // Box 420
        bodyDoorCloseColoredPrimary[31].setRotationPoint(9F, -23F, -21F);
        bodyDoorCloseColoredPrimary[31].rotateAngleX = -0.13962634F;

        bodyDoorCloseColoredPrimary[32].addShapeBox(0F, 0F, 0F, 1, 9, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -11F, 1F, -0.1F, 10F, 0F, -0.1F, 10F, 0F, 0.1F, -11F, 1F, 0.1F); // Box 421
        bodyDoorCloseColoredPrimary[32].setRotationPoint(18F, -23F, -21F);
        bodyDoorCloseColoredPrimary[32].rotateAngleX = -0.15707963F;

        bodyDoorCloseColoredPrimary[33].addShapeBox(0F, 0F, 0F, 1, 5, 1, 0F, 0F, 0F, -0.7F, 0F, 0F, -0.7F, 0F, 0F, 0.7F, 0F, 0F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 422
        bodyDoorCloseColoredPrimary[33].setRotationPoint(29F, -14F, -23F);

        bodyColoredPrimary = new ModelRendererTurbo[88];
        bodyColoredPrimary[0] = new ModelRendererTurbo(this, 65, 1, textureX, textureY); // Box 1
        bodyColoredPrimary[1] = new ModelRendererTurbo(this, 177, 25, textureX, textureY); // Box 74
        bodyColoredPrimary[2] = new ModelRendererTurbo(this, 281, 25, textureX, textureY); // Box 75
        bodyColoredPrimary[3] = new ModelRendererTurbo(this, 385, 25, textureX, textureY); // Box 76
        bodyColoredPrimary[4] = new ModelRendererTurbo(this, 1, 41, textureX, textureY); // Box 77
        bodyColoredPrimary[5] = new ModelRendererTurbo(this, 57, 57, textureX, textureY); // Box 78
        bodyColoredPrimary[6] = new ModelRendererTurbo(this, 121, 81, textureX, textureY); // Box 79
        bodyColoredPrimary[7] = new ModelRendererTurbo(this, 225, 81, textureX, textureY); // Box 81
        bodyColoredPrimary[8] = new ModelRendererTurbo(this, 1, 97, textureX, textureY); // Box 83
        bodyColoredPrimary[9] = new ModelRendererTurbo(this, 57, 113, textureX, textureY); // Box 84
        bodyColoredPrimary[10] = new ModelRendererTurbo(this, 233, 25, textureX, textureY); // Box 86
        bodyColoredPrimary[11] = new ModelRendererTurbo(this, 249, 25, textureX, textureY); // Box 88
        bodyColoredPrimary[12] = new ModelRendererTurbo(this, 297, 25, textureX, textureY); // Box 91
        bodyColoredPrimary[13] = new ModelRendererTurbo(this, 337, 25, textureX, textureY); // Box 92
        bodyColoredPrimary[14] = new ModelRendererTurbo(this, 377, 25, textureX, textureY); // Box 93
        bodyColoredPrimary[15] = new ModelRendererTurbo(this, 145, 1, textureX, textureY); // Box 94
        bodyColoredPrimary[16] = new ModelRendererTurbo(this, 185, 81, textureX, textureY); // Box 97
        bodyColoredPrimary[17] = new ModelRendererTurbo(this, 393, 25, textureX, textureY); // Box 100
        bodyColoredPrimary[18] = new ModelRendererTurbo(this, 169, 1, textureX, textureY); // Box 101
        bodyColoredPrimary[19] = new ModelRendererTurbo(this, 129, 137, textureX, textureY); // Box 102
        bodyColoredPrimary[20] = new ModelRendererTurbo(this, 441, 25, textureX, textureY); // Box 103
        bodyColoredPrimary[21] = new ModelRendererTurbo(this, 193, 1, textureX, textureY); // Box 104
        bodyColoredPrimary[22] = new ModelRendererTurbo(this, 121, 33, textureX, textureY); // Box 105
        bodyColoredPrimary[23] = new ModelRendererTurbo(this, 417, 81, textureX, textureY); // Box 106
        bodyColoredPrimary[24] = new ModelRendererTurbo(this, 177, 33, textureX, textureY); // Box 107
        bodyColoredPrimary[25] = new ModelRendererTurbo(this, 217, 1, textureX, textureY); // Box 108
        bodyColoredPrimary[26] = new ModelRendererTurbo(this, 233, 33, textureX, textureY); // Box 109
        bodyColoredPrimary[27] = new ModelRendererTurbo(this, 1, 41, textureX, textureY); // Box 110
        bodyColoredPrimary[28] = new ModelRendererTurbo(this, 193, 137, textureX, textureY); // Box 111
        bodyColoredPrimary[29] = new ModelRendererTurbo(this, 385, 137, textureX, textureY); // Box 112
        bodyColoredPrimary[30] = new ModelRendererTurbo(this, 1, 153, textureX, textureY); // Box 113
        bodyColoredPrimary[31] = new ModelRendererTurbo(this, 145, 193, textureX, textureY); // Box 115
        bodyColoredPrimary[32] = new ModelRendererTurbo(this, 249, 193, textureX, textureY); // Box 116
        bodyColoredPrimary[33] = new ModelRendererTurbo(this, 353, 193, textureX, textureY); // Box 117
        bodyColoredPrimary[34] = new ModelRendererTurbo(this, 1, 209, textureX, textureY); // Box 119
        bodyColoredPrimary[35] = new ModelRendererTurbo(this, 65, 225, textureX, textureY); // Box 120
        bodyColoredPrimary[36] = new ModelRendererTurbo(this, 201, 249, textureX, textureY); // Box 122
        bodyColoredPrimary[37] = new ModelRendererTurbo(this, 161, 65, textureX, textureY); // Box 123
        bodyColoredPrimary[38] = new ModelRendererTurbo(this, 345, 257, textureX, textureY); // Box 125
        bodyColoredPrimary[39] = new ModelRendererTurbo(this, 145, 73, textureX, textureY); // Box 126
        bodyColoredPrimary[40] = new ModelRendererTurbo(this, 161, 73, textureX, textureY); // Box 127
        bodyColoredPrimary[41] = new ModelRendererTurbo(this, 489, 73, textureX, textureY); // Box 128
        bodyColoredPrimary[42] = new ModelRendererTurbo(this, 121, 81, textureX, textureY); // Box 129
        bodyColoredPrimary[43] = new ModelRendererTurbo(this, 1, 265, textureX, textureY); // Box 130
        bodyColoredPrimary[44] = new ModelRendererTurbo(this, 57, 297, textureX, textureY); // Box 131
        bodyColoredPrimary[45] = new ModelRendererTurbo(this, 137, 81, textureX, textureY); // Box 133
        bodyColoredPrimary[46] = new ModelRendererTurbo(this, 401, 265, textureX, textureY); // Box 134
        bodyColoredPrimary[47] = new ModelRendererTurbo(this, 185, 81, textureX, textureY); // Box 135
        bodyColoredPrimary[48] = new ModelRendererTurbo(this, 201, 81, textureX, textureY); // Box 136
        bodyColoredPrimary[49] = new ModelRendererTurbo(this, 241, 81, textureX, textureY); // Box 137
        bodyColoredPrimary[50] = new ModelRendererTurbo(this, 209, 297, textureX, textureY); // Box 140
        bodyColoredPrimary[51] = new ModelRendererTurbo(this, 201, 193, textureX, textureY); // Box 141
        bodyColoredPrimary[52] = new ModelRendererTurbo(this, 265, 305, textureX, textureY); // Box 144
        bodyColoredPrimary[53] = new ModelRendererTurbo(this, 265, 1, textureX, textureY); // Box 145
        bodyColoredPrimary[54] = new ModelRendererTurbo(this, 281, 1, textureX, textureY); // Box 146
        bodyColoredPrimary[55] = new ModelRendererTurbo(this, 329, 313, textureX, textureY); // Box 147
        bodyColoredPrimary[56] = new ModelRendererTurbo(this, 505, 73, textureX, textureY); // Box 247
        bodyColoredPrimary[57] = new ModelRendererTurbo(this, 73, 345, textureX, textureY); // Box 248
        bodyColoredPrimary[58] = new ModelRendererTurbo(this, 153, 41, textureX, textureY); // Box 249
        bodyColoredPrimary[59] = new ModelRendererTurbo(this, 385, 81, textureX, textureY); // Box 250
        bodyColoredPrimary[60] = new ModelRendererTurbo(this, 353, 57, textureX, textureY); // Box 251
        bodyColoredPrimary[61] = new ModelRendererTurbo(this, 505, 81, textureX, textureY); // Box 252
        bodyColoredPrimary[62] = new ModelRendererTurbo(this, 209, 89, textureX, textureY); // Box 253
        bodyColoredPrimary[63] = new ModelRendererTurbo(this, 345, 97, textureX, textureY); // Box 256
        bodyColoredPrimary[64] = new ModelRendererTurbo(this, 377, 113, textureX, textureY); // Box 257
        bodyColoredPrimary[65] = new ModelRendererTurbo(this, 201, 137, textureX, textureY); // Box 258
        bodyColoredPrimary[66] = new ModelRendererTurbo(this, 225, 137, textureX, textureY); // Box 259
        bodyColoredPrimary[67] = new ModelRendererTurbo(this, 337, 137, textureX, textureY); // Box 265
        bodyColoredPrimary[68] = new ModelRendererTurbo(this, 393, 81, textureX, textureY); // Box 266
        bodyColoredPrimary[69] = new ModelRendererTurbo(this, 417, 81, textureX, textureY); // Box 267
        bodyColoredPrimary[70] = new ModelRendererTurbo(this, 361, 137, textureX, textureY); // Box 268
        bodyColoredPrimary[71] = new ModelRendererTurbo(this, 473, 81, textureX, textureY); // Box 269
        bodyColoredPrimary[72] = new ModelRendererTurbo(this, 1, 97, textureX, textureY); // Box 272
        bodyColoredPrimary[73] = new ModelRendererTurbo(this, 217, 25, textureX, textureY); // Box 287
        bodyColoredPrimary[74] = new ModelRendererTurbo(this, 425, 25, textureX, textureY); // Box 288
        bodyColoredPrimary[75] = new ModelRendererTurbo(this, 97, 65, textureX, textureY); // Box 289
        bodyColoredPrimary[76] = new ModelRendererTurbo(this, 161, 81, textureX, textureY); // Box 290
        bodyColoredPrimary[77] = new ModelRendererTurbo(this, 1, 81, textureX, textureY); // Box 324
        bodyColoredPrimary[78] = new ModelRendererTurbo(this, 121, 97, textureX, textureY); // Box 325
        bodyColoredPrimary[79] = new ModelRendererTurbo(this, 489, 33, textureX, textureY); // Box 326
        bodyColoredPrimary[80] = new ModelRendererTurbo(this, 9, 9, textureX, textureY); // Box 327
        bodyColoredPrimary[81] = new ModelRendererTurbo(this, 321, 97, textureX, textureY); // Box 331
        bodyColoredPrimary[82] = new ModelRendererTurbo(this, 25, 105, textureX, textureY); // Box 332
        bodyColoredPrimary[83] = new ModelRendererTurbo(this, 17, 65, textureX, textureY); // Box 333
        bodyColoredPrimary[84] = new ModelRendererTurbo(this, 185, 9, textureX, textureY); // Box 334
        bodyColoredPrimary[85] = new ModelRendererTurbo(this, 185, 353, textureX, textureY); // Box 423
        bodyColoredPrimary[86] = new ModelRendererTurbo(this, 369, 193, textureX, textureY); // Box 445
        bodyColoredPrimary[87] = new ModelRendererTurbo(this, 385, 193, textureX, textureY); // Box 446

        bodyColoredPrimary[0].addShapeBox(0F, 0F, 0F, 2, 5, 46, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 1
        bodyColoredPrimary[0].setRotationPoint(34F, 2F, -23F);

        bodyColoredPrimary[1].addShapeBox(0F, 0F, 0F, 4, 5, 46, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F); // Box 74
        bodyColoredPrimary[1].setRotationPoint(34F, -3F, -23F);

        bodyColoredPrimary[2].addShapeBox(0F, 0F, 0F, 4, 5, 46, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F); // Box 75
        bodyColoredPrimary[2].setRotationPoint(54F, -3F, -23F);

        bodyColoredPrimary[3].addShapeBox(0F, 0F, 0F, 4, 2, 46, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F); // Box 76
        bodyColoredPrimary[3].setRotationPoint(36F, -5F, -23F);

        bodyColoredPrimary[4].addShapeBox(0F, 0F, 0F, 2, 2, 46, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F); // Box 77
        bodyColoredPrimary[4].setRotationPoint(52F, -5F, -23F);

        bodyColoredPrimary[5].addShapeBox(0F, 0F, 0F, 5, 2, 46, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F); // Box 78
        bodyColoredPrimary[5].setRotationPoint(38F, -7F, -23F);

        bodyColoredPrimary[6].addShapeBox(0F, 0F, 0F, 5, 2, 46, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F); // Box 79
        bodyColoredPrimary[6].setRotationPoint(49F, -7F, -23F);

        bodyColoredPrimary[7].addBox(0F, 0F, 0F, 16, 2, 46, 0F); // Box 81
        bodyColoredPrimary[7].setRotationPoint(38F, -9F, -23F);

        bodyColoredPrimary[8].addShapeBox(0F, 0F, 0F, 4, 5, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 83
        bodyColoredPrimary[8].setRotationPoint(58F, -3F, -22F);

        bodyColoredPrimary[9].addBox(0F, 0F, 0F, 6, 3, 46, 0F); // Box 84
        bodyColoredPrimary[9].setRotationPoint(54F, -6F, -23F);

        bodyColoredPrimary[10].addShapeBox(0F, 0F, 0F, 2, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F); // Box 86
        bodyColoredPrimary[10].setRotationPoint(59.9F, -6F, -16.9F);

        bodyColoredPrimary[11].addShapeBox(0F, 0F, 0F, 2, 3, 4, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 88
        bodyColoredPrimary[11].setRotationPoint(59.9F, -6F, 12.9F);

        bodyColoredPrimary[12].addShapeBox(0F, 0F, 0F, 8, 2, 5, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 91
        bodyColoredPrimary[12].setRotationPoint(54F, -8F, -22F);

        bodyColoredPrimary[13].addShapeBox(0F, 0F, 0F, 4, 5, 1, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 92
        bodyColoredPrimary[13].setRotationPoint(58F, -3F, -23F);

        bodyColoredPrimary[14].addShapeBox(0F, 0F, 0F, 4, 5, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F); // Box 93
        bodyColoredPrimary[14].setRotationPoint(58F, -3F, 22F);

        bodyColoredPrimary[15].addShapeBox(0F, 0F, 0F, 5, 2, 1, 0F, 3F, 0F, 0F, -3F, 0F, 0F, -2F, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F); // Box 94
        bodyColoredPrimary[15].setRotationPoint(57F, -8F, -23F);

        bodyColoredPrimary[16].addShapeBox(0F, 0F, 0F, 8, 2, 34, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 97
        bodyColoredPrimary[16].setRotationPoint(54F, -8F, -17F);

        bodyColoredPrimary[17].addShapeBox(0F, 0F, 0F, 8, 2, 5, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 100
        bodyColoredPrimary[17].setRotationPoint(54F, -8F, 17F);

        bodyColoredPrimary[18].addShapeBox(0F, 0F, 0F, 5, 2, 1, 0F, 3F, 0F, 0F, -2F, 0F, 0F, -3F, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 3F, 0F, 0F); // Box 101
        bodyColoredPrimary[18].setRotationPoint(57F, -8F, 22F);

        bodyColoredPrimary[19].addBox(0F, 0F, 0F, 18, 1, 34, 0F); // Box 102
        bodyColoredPrimary[19].setRotationPoint(36F, -10F, -17F);

        bodyColoredPrimary[20].addShapeBox(0F, 0F, 0F, 6, 2, 5, 0F, 0F, -1F, 0F, -5F, -1F, 0F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F); // Box 103
        bodyColoredPrimary[20].setRotationPoint(54F, -10F, -22F);

        bodyColoredPrimary[21].addShapeBox(0F, 0F, 0F, 3, 1, 1, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 3F, 0F, 0F, 0F, 0F, 0F); // Box 104
        bodyColoredPrimary[21].setRotationPoint(54F, -9F, -23F);

        bodyColoredPrimary[22].addShapeBox(0F, 0F, 0F, 16, 1, 5, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 105
        bodyColoredPrimary[22].setRotationPoint(38F, -10F, -22F);

        bodyColoredPrimary[23].addShapeBox(0F, 0F, 0F, 7, 2, 34, 0F, 0F, 0F, 0F, -6F, 0F, 0F, -6F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 106
        bodyColoredPrimary[23].setRotationPoint(54F, -10F, -17F);

        bodyColoredPrimary[24].addShapeBox(0F, 0F, 0F, 6, 2, 5, 0F, 0F, 0F, 0F, -5F, 0F, 0F, -5F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 107
        bodyColoredPrimary[24].setRotationPoint(54F, -10F, 17F);

        bodyColoredPrimary[25].addShapeBox(0F, 0F, 0F, 3, 1, 1, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F); // Box 108
        bodyColoredPrimary[25].setRotationPoint(54F, -9F, 22F);

        bodyColoredPrimary[26].addBox(0F, 0F, 0F, 16, 2, 1, 0F); // Box 109
        bodyColoredPrimary[26].setRotationPoint(-34F, -9F, -23F);

        bodyColoredPrimary[27].addShapeBox(0F, 0F, 0F, 16, 1, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 110
        bodyColoredPrimary[27].setRotationPoint(38F, -10F, 17F);

        bodyColoredPrimary[28].addBox(0F, 0F, 0F, 48, 2, 46, 0F); // Box 111
        bodyColoredPrimary[28].setRotationPoint(-14F, 5F, -23F);

        bodyColoredPrimary[29].addShapeBox(0F, 0F, 0F, 2, 5, 46, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 112
        bodyColoredPrimary[29].setRotationPoint(-16F, 2F, -23F);

        bodyColoredPrimary[30].addShapeBox(0F, 0F, 0F, 4, 5, 46, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F); // Box 113
        bodyColoredPrimary[30].setRotationPoint(-18F, -3F, -23F);

        bodyColoredPrimary[31].addShapeBox(0F, 0F, 0F, 4, 5, 46, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F); // Box 115
        bodyColoredPrimary[31].setRotationPoint(-38F, -3F, -23F);

        bodyColoredPrimary[32].addShapeBox(0F, 0F, 0F, 4, 2, 46, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F); // Box 116
        bodyColoredPrimary[32].setRotationPoint(-20F, -5F, -23F);

        bodyColoredPrimary[33].addShapeBox(0F, 0F, 0F, 4, 2, 46, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F); // Box 117
        bodyColoredPrimary[33].setRotationPoint(-36F, -5F, -23F);

        bodyColoredPrimary[34].addShapeBox(0F, 0F, 0F, 5, 2, 46, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F); // Box 119
        bodyColoredPrimary[34].setRotationPoint(-34F, -7F, -23F);

        bodyColoredPrimary[35].addShapeBox(0F, 0F, 0F, 5, 2, 46, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F); // Box 120
        bodyColoredPrimary[35].setRotationPoint(-23F, -7F, -23F);

        bodyColoredPrimary[36].addShapeBox(0F, 0F, 0F, 16, 1, 44, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 122
        bodyColoredPrimary[36].setRotationPoint(-34F, -8F, -22F);

        bodyColoredPrimary[37].addBox(0F, 0F, 0F, 16, 2, 1, 0F); // Box 123
        bodyColoredPrimary[37].setRotationPoint(-34F, -9F, 22F);

        bodyColoredPrimary[38].addBox(0F, 0F, 0F, 2, 4, 46, 0F); // Box 125
        bodyColoredPrimary[38].setRotationPoint(36F, -9F, -23F);

        bodyColoredPrimary[39].addShapeBox(0F, 0F, 0F, 2, 1, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 126
        bodyColoredPrimary[39].setRotationPoint(36F, -10F, 17F);

        bodyColoredPrimary[40].addShapeBox(0F, 0F, 0F, 2, 1, 5, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 127
        bodyColoredPrimary[40].setRotationPoint(36F, -10F, -22F);

        bodyColoredPrimary[41].addShapeBox(0F, 0F, 0F, 3, 14, 1, 0F, 16F, 0F, -2F, -16F, 0F, -2F, -16F, 0F, 2F, 16F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 128
        bodyColoredPrimary[41].setRotationPoint(35F, -23F, -23F);

        bodyColoredPrimary[42].addShapeBox(0F, 0F, 0F, 3, 14, 1, 0F, 16F, 0F, 2F, -16F, 0F, 2F, -16F, 0F, -2F, 16F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 129
        bodyColoredPrimary[42].setRotationPoint(35F, -23F, 22F);

        bodyColoredPrimary[43].addBox(0F, 0F, 0F, 2, 6, 44, 0F); // Box 130
        bodyColoredPrimary[43].setRotationPoint(34F, -9F, -22F);

        bodyColoredPrimary[44].addShapeBox(0F, 0F, 0F, 53, 1, 42, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 131
        bodyColoredPrimary[44].setRotationPoint(-31F, -24F, -21F);

        bodyColoredPrimary[45].addShapeBox(0F, 0F, 0F, 7, 14, 2, 0F, -8F, 0F, 2F, 8F, 0F, 0F, 8F, 0F, -2F, -8F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 133
        bodyColoredPrimary[45].setRotationPoint(-39F, -23F, 21F);

        bodyColoredPrimary[46].addBox(0F, 0F, 0F, 3, 5, 44, 0F); // Box 134
        bodyColoredPrimary[46].setRotationPoint(-41F, -3F, -22F);

        bodyColoredPrimary[47].addShapeBox(0F, 0F, 0F, 3, 5, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 135
        bodyColoredPrimary[47].setRotationPoint(-41F, -3F, 22F);

        bodyColoredPrimary[48].addShapeBox(0F, 0F, 0F, 3, 5, 1, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 136
        bodyColoredPrimary[48].setRotationPoint(-41F, -3F, -23F);

        bodyColoredPrimary[49].addShapeBox(0F, 0F, 0F, 7, 14, 2, 0F, -8F, 0F, -2F, 8F, 0F, -2F, 8F, 0F, 0F, -8F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F); // Box 137
        bodyColoredPrimary[49].setRotationPoint(-39F, -23F, -23F);

        bodyColoredPrimary[50].addBox(0F, 0F, 0F, 3, 2, 46, 0F); // Box 140
        bodyColoredPrimary[50].setRotationPoint(-39F, -5F, -23F);

        bodyColoredPrimary[51].addBox(0F, 0F, 0F, 2, 3, 34, 0F); // Box 141
        bodyColoredPrimary[51].setRotationPoint(-41F, -6F, -17F);

        bodyColoredPrimary[52].addBox(0F, 0F, 0F, 5, 4, 46, 0F); // Box 144
        bodyColoredPrimary[52].setRotationPoint(-39F, -9F, -23F);

        bodyColoredPrimary[53].addShapeBox(0F, 0F, 0F, 2, 3, 1, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 145
        bodyColoredPrimary[53].setRotationPoint(-41F, -9F, -23F);

        bodyColoredPrimary[54].addShapeBox(0F, 0F, 0F, 2, 3, 1, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 146
        bodyColoredPrimary[54].setRotationPoint(-41F, -9F, 22F);

        bodyColoredPrimary[55].addShapeBox(0F, 0F, 0F, 2, 3, 44, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 147
        bodyColoredPrimary[55].setRotationPoint(-41F, -9F, -22F);

        bodyColoredPrimary[56].addBox(0F, 0F, 0F, 2, 6, 1, 0F); // Box 247
        bodyColoredPrimary[56].setRotationPoint(-16F, -9F, -23F);

        bodyColoredPrimary[57].addShapeBox(0F, 0F, 0F, 4, 5, 44, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 248
        bodyColoredPrimary[57].setRotationPoint(-18F, -8F, -22F);

        bodyColoredPrimary[58].addBox(0F, 0F, 0F, 2, 4, 1, 0F); // Box 249
        bodyColoredPrimary[58].setRotationPoint(-18F, -9F, -23F);

        bodyColoredPrimary[59].addBox(0F, 0F, 0F, 2, 6, 1, 0F); // Box 250
        bodyColoredPrimary[59].setRotationPoint(-16F, -9F, 22F);

        bodyColoredPrimary[60].addBox(0F, 0F, 0F, 2, 4, 1, 0F); // Box 251
        bodyColoredPrimary[60].setRotationPoint(-18F, -9F, 22F);

        bodyColoredPrimary[61].addShapeBox(0F, 0F, 0F, 2, 14, 1, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 252
        bodyColoredPrimary[61].setRotationPoint(-16F, -23F, -23F);

        bodyColoredPrimary[62].addShapeBox(0F, 0F, 0F, 2, 14, 1, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 253
        bodyColoredPrimary[62].setRotationPoint(-16F, -23F, 22F);

        bodyColoredPrimary[63].addBox(0F, 0F, 0F, 3, 14, 1, 0F); // Box 256
        bodyColoredPrimary[63].setRotationPoint(7F, -9F, 21F);

        bodyColoredPrimary[64].addShapeBox(0F, 0F, 0F, 3, 14, 1, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 257
        bodyColoredPrimary[64].setRotationPoint(7F, -23F, 21F);

        bodyColoredPrimary[65].addBox(0F, 0F, 0F, 3, 14, 1, 0F); // Box 258
        bodyColoredPrimary[65].setRotationPoint(7F, -9F, -22F);

        bodyColoredPrimary[66].addShapeBox(0F, 0F, 0F, 3, 14, 1, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 259
        bodyColoredPrimary[66].setRotationPoint(7F, -23F, -22F);

        bodyColoredPrimary[67].addBox(0F, 0F, 0F, 4, 14, 1, 0F); // Box 265
        bodyColoredPrimary[67].setRotationPoint(30F, -9F, -23F);

        bodyColoredPrimary[68].addBox(0F, 0F, 0F, 2, 6, 1, 0F); // Box 266
        bodyColoredPrimary[68].setRotationPoint(34F, -9F, -23F);

        bodyColoredPrimary[69].addBox(0F, 0F, 0F, 2, 6, 1, 0F); // Box 267
        bodyColoredPrimary[69].setRotationPoint(34F, -9F, 22F);

        bodyColoredPrimary[70].addBox(0F, 0F, 0F, 4, 14, 1, 0F); // Box 268
        bodyColoredPrimary[70].setRotationPoint(30F, -9F, 22F);

        bodyColoredPrimary[71].addShapeBox(0F, 0F, 0F, 5, 5, 1, 0F, 0F, 0F, 0.7F, -4F, 0F, 0.7F, -4F, 0F, -0.7F, 0F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 269
        bodyColoredPrimary[71].setRotationPoint(30F, -14F, 22F);

        bodyColoredPrimary[72].addShapeBox(0F, 0F, 0F, 5, 5, 1, 0F, 0F, 0F, -0.7F, -4F, 0F, -0.7F, -4F, 0F, 0.7F, 0F, 0F, 0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 272
        bodyColoredPrimary[72].setRotationPoint(30F, -14F, -23F);

        bodyColoredPrimary[73].addBox(0F, 0F, 0F, 1, 14, 1, 0F); // Box 287
        bodyColoredPrimary[73].setRotationPoint(8F, -9F, 22F);

        bodyColoredPrimary[74].addShapeBox(0F, 0F, 0F, 1, 14, 1, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 288
        bodyColoredPrimary[74].setRotationPoint(8F, -23F, 22F);

        bodyColoredPrimary[75].addBox(0F, 0F, 0F, 1, 14, 1, 0F); // Box 289
        bodyColoredPrimary[75].setRotationPoint(8F, -9F, -23F);

        bodyColoredPrimary[76].addShapeBox(0F, 0F, 0F, 1, 14, 1, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 290
        bodyColoredPrimary[76].setRotationPoint(8F, -23F, -23F);

        bodyColoredPrimary[77].addBox(0F, 0F, 0F, 7, 4, 1, 0F); // Box 324
        bodyColoredPrimary[77].setRotationPoint(-14F, 1F, -23F);

        bodyColoredPrimary[78].addShapeBox(0F, 0F, 0F, 7, 3, 1, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 325
        bodyColoredPrimary[78].setRotationPoint(-14F, -2F, -23F);

        bodyColoredPrimary[79].addShapeBox(0F, 0F, 0F, 5, 3, 1, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 326
        bodyColoredPrimary[79].setRotationPoint(-14F, -5F, -23F);

        bodyColoredPrimary[80].addShapeBox(0F, 0F, 0F, 2, 1, 1, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 327
        bodyColoredPrimary[80].setRotationPoint(-14F, -6F, -23F);

        bodyColoredPrimary[81].addBox(0F, 0F, 0F, 7, 4, 1, 0F); // Box 331
        bodyColoredPrimary[81].setRotationPoint(-14F, 1F, 22F);

        bodyColoredPrimary[82].addShapeBox(0F, 0F, 0F, 7, 3, 1, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 332
        bodyColoredPrimary[82].setRotationPoint(-14F, -2F, 22F);

        bodyColoredPrimary[83].addShapeBox(0F, 0F, 0F, 5, 3, 1, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 333
        bodyColoredPrimary[83].setRotationPoint(-14F, -5F, 22F);

        bodyColoredPrimary[84].addShapeBox(0F, 0F, 0F, 2, 1, 1, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 334
        bodyColoredPrimary[84].setRotationPoint(-14F, -6F, 22F);

        bodyColoredPrimary[85].addShapeBox(0F, 0F, 0F, 1, 1, 40, 0F, 3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, 1F, -0.8F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 1F, -0.8F, 0F); // Box 423
        bodyColoredPrimary[85].setRotationPoint(20F, -23F, -20F);

        bodyColoredPrimary[86].addShapeBox(0F, 0F, 0F, 4, 14, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F); // Box 445
        bodyColoredPrimary[86].setRotationPoint(30F, -9F, -22F);

        bodyColoredPrimary[87].addShapeBox(0F, 0F, 0F, 4, 14, 1, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 446
        bodyColoredPrimary[87].setRotationPoint(30F, -9F, 21F);

        //translateAll(0F, 0F, 0F);
        flipAll();
        for(ModelRendererTurbo mod : body){
            mod.rotateAngleY = -mod.rotateAngleY;
        }
    }

}
