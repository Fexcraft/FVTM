//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2017 Minecraft-SMP.de
// This file is for FVM
// Model: C2 Type P
// Model Creator: FEX___96
// Created on: 24.08.2015 - 16:52:34
// Last changed on: 24.08.2015 - 16:52:34
package net.fexcraft.mod.addons.fvp.models.vehicle;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.vehicle.VehicleModel;

public class ModelC2 extends VehicleModel {

    public ModelC2(){
    	super(); textureX = 512; textureY = 512;
        this.addToCreators("Ferdinand (FEX___96)");
        ModelRendererTurbo[] body = new ModelRendererTurbo[38];
        body[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
        body[1] = new ModelRendererTurbo(this, 233, 1, textureX, textureY); // Box 1
        body[2] = new ModelRendererTurbo(this, 337, 57, textureX, textureY); // Box 7
        body[3] = new ModelRendererTurbo(this, 1, 113, textureX, textureY); // Box 8
        body[4] = new ModelRendererTurbo(this, 185, 1, textureX, textureY); // Box 9
        body[5] = new ModelRendererTurbo(this, 73, 113, textureX, textureY); // Box 11
        body[6] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 14
        body[7] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 15
        body[8] = new ModelRendererTurbo(this, 185, 1, textureX, textureY); // Box 23
        body[9] = new ModelRendererTurbo(this, 409, 137, textureX, textureY); // Box 25
        body[10] = new ModelRendererTurbo(this, 41, 1, textureX, textureY); // Box 29
        body[11] = new ModelRendererTurbo(this, 209, 1, textureX, textureY); // Box 30
        body[12] = new ModelRendererTurbo(this, 113, 169, textureX, textureY); // Box 31
        body[13] = new ModelRendererTurbo(this, 113, 177, textureX, textureY); // Box 32
        body[14] = new ModelRendererTurbo(this, 241, 1, textureX, textureY); // Box 33
        body[15] = new ModelRendererTurbo(this, 297, 1, textureX, textureY); // Box 35
        body[16] = new ModelRendererTurbo(this, 289, 57, textureX, textureY); // Box 36
        body[17] = new ModelRendererTurbo(this, 345, 1, textureX, textureY); // Box 37
        body[18] = new ModelRendererTurbo(this, 289, 65, textureX, textureY); // Box 38
        body[19] = new ModelRendererTurbo(this, 369, 1, textureX, textureY); // Box 39
        body[20] = new ModelRendererTurbo(this, 217, 169, textureX, textureY); // Box 40
        body[21] = new ModelRendererTurbo(this, 137, 113, textureX, textureY); // Box 41
        body[22] = new ModelRendererTurbo(this, 289, 177, textureX, textureY); // Box 52
        body[23] = new ModelRendererTurbo(this, 113, 185, textureX, textureY); // Box 74
        body[24] = new ModelRendererTurbo(this, 361, 193, textureX, textureY); // Box 79
        body[25] = new ModelRendererTurbo(this, 241, 113, textureX, textureY); // Box 83
        body[26] = new ModelRendererTurbo(this, 241, 137, textureX, textureY); // Box 84
        body[27] = new ModelRendererTurbo(this, 81, 113, textureX, textureY); // Box 85
        body[28] = new ModelRendererTurbo(this, 137, 113, textureX, textureY); // Box 86
        body[29] = new ModelRendererTurbo(this, 401, 81, textureX, textureY); // Box 87
        body[30] = new ModelRendererTurbo(this, 409, 41, textureX, textureY); // Box 88
        body[31] = new ModelRendererTurbo(this, 465, 81, textureX, textureY); // Box 89
        body[32] = new ModelRendererTurbo(this, 1, 89, textureX, textureY); // Box 90
        body[33] = new ModelRendererTurbo(this, 217, 1, textureX, textureY); // Box 91
        body[34] = new ModelRendererTurbo(this, 241, 1, textureX, textureY); // Box 92
        body[35] = new ModelRendererTurbo(this, 465, 49, textureX, textureY); // Box 102
        body[36] = new ModelRendererTurbo(this, 505, 17, textureX, textureY); // Box 148
        body[37] = new ModelRendererTurbo(this, 273, 33, textureX, textureY); // Box 149

        body[0].addBox(0F, 0F, 0F, 64, 5, 48, 0F); // Box 0
        body[0].setRotationPoint(-47F, -12F, -24F);

        body[1].addShapeBox(0F, 0F, 0F, 4, 5, 50, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F); // Box 1
        body[1].setRotationPoint(17F, -12F, -25F);

        body[2].addShapeBox(0F, 0F, 0F, 4, 5, 50, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 7
        body[2].setRotationPoint(38F, -12F, -25F);

        body[3].addBox(0F, 0F, 0F, 21, 10, 36, 0F); // Box 8
        body[3].setRotationPoint(19F, -17F, -18F);

        body[4].addBox(0F, 0F, 0F, 3, 3, 44, 0F); // Box 9
        body[4].setRotationPoint(28F, -9F, -22F);

        body[5].addShapeBox(0F, 0F, 0F, 4, 5, 50, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, 0F); // Box 11
        body[5].setRotationPoint(42F, -12F, -25F);

        body[6].addBox(0F, 0F, 0F, 4, 3, 6, 0F); // Box 14
        body[6].setRotationPoint(40.5F, -22F, 16F);

        body[7].addBox(0F, 0F, 0F, 4, 3, 6, 0F); // Box 15
        body[7].setRotationPoint(40.5F, -22F, -22F);

        body[8].addBox(0F, 0F, 0F, 1, 3, 16, 0F); // Box 23
        body[8].setRotationPoint(-83.2F, -11.5F, -8F);

        body[9].addBox(0F, 0F, 0F, 1, 4, 44, 0F); // Box 25
        body[9].setRotationPoint(17F, -23F, -22F);

        body[10].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // Box 29
        body[10].setRotationPoint(42.5F, -21.5F, -24F);

        body[11].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // Box 30
        body[11].setRotationPoint(42.5F, -21.5F, 23F);

        body[12].addBox(0F, 0F, 0F, 64, 5, 1, 0F); // Box 31
        body[12].setRotationPoint(-47F, -12F, 24F);

        body[13].addBox(0F, 0F, 0F, 64, 5, 1, 0F); // Box 32
        body[13].setRotationPoint(-47F, -12F, -25F);

        body[14].addShapeBox(0F, 0F, 0F, 4, 5, 7, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 33
        body[14].setRotationPoint(-51F, -12F, -25F);

        body[15].addShapeBox(0F, 0F, 0F, 4, 5, 7, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 35
        body[15].setRotationPoint(-51F, -12F, 18F);

        body[16].addBox(0F, 0F, 0F, 25, 5, 1, 0F); // Box 36
        body[16].setRotationPoint(-72F, -12F, 17F);

        body[17].addShapeBox(0F, 0F, 0F, 4, 5, 7, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F); // Box 37
        body[17].setRotationPoint(-72F, -12F, 18F);

        body[18].addBox(0F, 0F, 0F, 25, 5, 1, 0F); // Box 38
        body[18].setRotationPoint(-72F, -12F, -18F);

        body[19].addShapeBox(0F, 0F, 0F, 4, 5, 7, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F); // Box 39
        body[19].setRotationPoint(-72F, -12F, -25F);

        body[20].addBox(0F, 0F, 0F, 25, 5, 34, 0F); // Box 40
        body[20].setRotationPoint(-72F, -12F, -17F);

        body[21].addBox(0F, 0F, 0F, 3, 3, 44, 0F); // Box 41
        body[21].setRotationPoint(-61F, -9F, -22F);

        body[22].addBox(0F, 0F, 0F, 7, 5, 50, 0F); // Box 52
        body[22].setRotationPoint(-79F, -12F, -25F);

        body[23].addShapeBox(0F, 0F, 0F, 4, 5, 50, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F); // Box 74
        body[23].setRotationPoint(-83F, -12F, -25F);

        body[24].addShapeBox(0F, 0F, 0F, 6, 4, 44, 0F, 0F, 3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 79
        body[24].setRotationPoint(11F, -23F, -22F);

        body[25].addBox(0F, 0F, 0F, 15, 2, 16, 0F); // Box 83
        body[25].setRotationPoint(-9F, -14F, 5F);

        body[26].addBox(0F, 0F, 0F, 15, 2, 16, 0F); // Box 84
        body[26].setRotationPoint(-9F, -14F, -21F);

        body[27].addShapeBox(0F, 0F, 0F, 3, 16, 16, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 85
        body[27].setRotationPoint(-9F, -30F, 5F);

        body[28].addShapeBox(0F, 0F, 0F, 3, 16, 16, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 86
        body[28].setRotationPoint(-9F, -30F, -21F);

        body[29].addBox(0F, 0F, 0F, 1, 3, 16, 0F); // Box 87
        body[29].setRotationPoint(45.2F, -11.5F, -8F);

        body[30].addShapeBox(0F, 0F, 0F, 12, 3, 4, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 88
        body[30].setRotationPoint(-8F, -15F, -2F);

        body[31].addBox(0F, 0F, 0F, 10, 4, 8, 0F); // Box 89
        body[31].setRotationPoint(7F, -16F, -4F);

        body[32].addShapeBox(0F, 0F, 0F, 10, 6, 8, 0F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 90
        body[32].setRotationPoint(7F, -22F, -4F);

        body[33].addBox(0F, 0F, 0F, 1, 7, 1, 0F); // Box 91
        body[33].setRotationPoint(3F, -17F, -0.5F);
        body[33].rotateAngleY = 0.01745329F;
        body[33].rotateAngleZ = 1.23918377F;

        body[34].addBox(0F, 0F, 0F, 1, 5, 1, 0F); // Box 92
        body[34].setRotationPoint(8F, -23F, -0.5F);
        body[34].rotateAngleZ = -0.34906585F;

        body[35].addShapeBox(0F, 0F, 0F, 12, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 102
        body[35].setRotationPoint(-82F, -8F, -14F);

        body[36].addBox(0F, 0F, 0F, 1, 7, 2, 0F); // Box 148
        body[36].setRotationPoint(-82.2F, -25F, 20.5F);

        body[37].addBox(0F, 0F, 0F, 1, 7, 2, 0F); // Box 149
        body[37].setRotationPoint(-82.2F, -25F, -22.5F);
        this.add("body", body);

        ModelRendererTurbo[] body_door_open_colored_primary = new ModelRendererTurbo[8];
        body_door_open_colored_primary[0] = new ModelRendererTurbo(this, 65, 241, textureX, textureY); // Box 112
        body_door_open_colored_primary[1] = new ModelRendererTurbo(this, 257, 17, textureX, textureY); // Box 113
        body_door_open_colored_primary[2] = new ModelRendererTurbo(this, 289, 89, textureX, textureY); // Box 114
        body_door_open_colored_primary[3] = new ModelRendererTurbo(this, 409, 121, textureX, textureY); // Box 116
        body_door_open_colored_primary[4] = new ModelRendererTurbo(this, 361, 17, textureX, textureY); // Box 117
        body_door_open_colored_primary[5] = new ModelRendererTurbo(this, 425, 25, textureX, textureY); // Box 118
        body_door_open_colored_primary[6] = new ModelRendererTurbo(this, 17, 33, textureX, textureY); // Box 119
        body_door_open_colored_primary[7] = new ModelRendererTurbo(this, 185, 41, textureX, textureY); // Box 120

        body_door_open_colored_primary[0].addBox(0F, 0F, 0F, 14, 1, 40, 0F); // Box 112
        body_door_open_colored_primary[0].setRotationPoint(-95.5F, -13F, -20F);

        body_door_open_colored_primary[1].addBox(0F, 0F, 0F, 2, 1, 4, 0F); // Box 113
        body_door_open_colored_primary[1].setRotationPoint(-93F, -12.5F, -2F);

        body_door_open_colored_primary[2].addBox(0F, 0F, 0F, 23, 13, 1, 0F); // Box 114
        body_door_open_colored_primary[2].setRotationPoint(-4F, -25F, 39F);
        body_door_open_colored_primary[2].rotateAngleY = 0.76794487F;
        body_door_open_colored_primary[2].rotateAngleZ = -0.01745329F;

        body_door_open_colored_primary[3].addBox(0F, 0F, 0F, 23, 13, 1, 0F); // Box 116
        body_door_open_colored_primary[3].setRotationPoint(-4F, -25F, -40F);
        body_door_open_colored_primary[3].rotateAngleY = -0.76794487F;
        body_door_open_colored_primary[3].rotateAngleZ = -0.01745329F;

        body_door_open_colored_primary[4].addBox(0F, 0F, 0F, 3, 1, 1, 0F); // Box 117
        body_door_open_colored_primary[4].setRotationPoint(-1F, -23F, 36.2F);
        body_door_open_colored_primary[4].rotateAngleY = 0.76794487F;

        body_door_open_colored_primary[5].addBox(0F, 0F, 0F, 3, 1, 1, 0F); // Box 118
        body_door_open_colored_primary[5].setRotationPoint(-1F, -23F, -37.2F);
        body_door_open_colored_primary[5].rotateAngleY = -0.76794487F;

        body_door_open_colored_primary[6].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 119
        body_door_open_colored_primary[6].setRotationPoint(5F, -22F, 29.5F);
        body_door_open_colored_primary[6].rotateAngleY = 0.76794487F;

        body_door_open_colored_primary[7].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 120
        body_door_open_colored_primary[7].setRotationPoint(6F, -22F, -29.5F);
        body_door_open_colored_primary[7].rotateAngleY = -0.76794487F;
        this.add("body_door_open_colored_primary", body_door_open_colored_primary);

        ModelRendererTurbo[] body_door_close_colored_primary = new ModelRendererTurbo[8];
        body_door_close_colored_primary[0] = new ModelRendererTurbo(this, 65, 89, textureX, textureY); // Box 104
        body_door_close_colored_primary[1] = new ModelRendererTurbo(this, 177, 89, textureX, textureY); // Box 105
        body_door_close_colored_primary[2] = new ModelRendererTurbo(this, 185, 9, textureX, textureY); // Box 106
        body_door_close_colored_primary[3] = new ModelRendererTurbo(this, 209, 9, textureX, textureY); // Box 107
        body_door_close_colored_primary[4] = new ModelRendererTurbo(this, 425, 9, textureX, textureY); // Box 108
        body_door_close_colored_primary[5] = new ModelRendererTurbo(this, 17, 17, textureX, textureY); // Box 109
        body_door_close_colored_primary[6] = new ModelRendererTurbo(this, 425, 209, textureX, textureY); // Box 110
        body_door_close_colored_primary[7] = new ModelRendererTurbo(this, 217, 17, textureX, textureY); // Box 111

        body_door_close_colored_primary[0].addBox(0F, 0F, 0F, 23, 13, 1, 0F); // Box 104
        body_door_close_colored_primary[0].setRotationPoint(-10F, -25F, 23F);

        body_door_close_colored_primary[1].addBox(0F, 0F, 0F, 23, 13, 1, 0F); // Box 105
        body_door_close_colored_primary[1].setRotationPoint(-10F, -25F, -24F);

        body_door_close_colored_primary[2].addBox(0F, 0F, 0F, 3, 1, 1, 0F); // Box 106
        body_door_close_colored_primary[2].setRotationPoint(-6F, -23F, 23.2F);

        body_door_close_colored_primary[3].addBox(0F, 0F, 0F, 3, 1, 1, 0F); // Box 107
        body_door_close_colored_primary[3].setRotationPoint(-6F, -23F, -24.2F);

        body_door_close_colored_primary[4].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 108
        body_door_close_colored_primary[4].setRotationPoint(3F, -22F, 22.5F);

        body_door_close_colored_primary[5].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 109
        body_door_close_colored_primary[5].setRotationPoint(3F, -22F, -23.5F);

        body_door_close_colored_primary[6].addBox(0F, 0F, 0F, 1, 14, 40, 0F); // Box 110
        body_door_close_colored_primary[6].setRotationPoint(-81.5F, -26F, -20F);

        body_door_close_colored_primary[7].addBox(0F, 0F, 0F, 1, 2, 4, 0F); // Box 111
        body_door_close_colored_primary[7].setRotationPoint(-82F, -25F, -2F);
        this.add("body_door_close_colored_primary", body_door_close_colored_primary);

        ModelRendererTurbo[] body_colored_primary = new ModelRendererTurbo[61];
        body_colored_primary[0] = new ModelRendererTurbo(this, 345, 1, textureX, textureY); // Box 2
        body_colored_primary[1] = new ModelRendererTurbo(this, 1, 57, textureX, textureY); // Box 3
        body_colored_primary[2] = new ModelRendererTurbo(this, 409, 9, textureX, textureY); // Box 4
        body_colored_primary[3] = new ModelRendererTurbo(this, 113, 57, textureX, textureY); // Box 5
        body_colored_primary[4] = new ModelRendererTurbo(this, 225, 57, textureX, textureY); // Box 6
        body_colored_primary[5] = new ModelRendererTurbo(this, 401, 65, textureX, textureY); // Box 10
        body_colored_primary[6] = new ModelRendererTurbo(this, 185, 113, textureX, textureY); // Box 12
        body_colored_primary[7] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 16
        body_colored_primary[8] = new ModelRendererTurbo(this, 297, 1, textureX, textureY); // Box 17
        body_colored_primary[9] = new ModelRendererTurbo(this, 289, 113, textureX, textureY); // Box 18
        body_colored_primary[10] = new ModelRendererTurbo(this, 185, 1, textureX, textureY); // Box 19
        body_colored_primary[11] = new ModelRendererTurbo(this, 409, 1, textureX, textureY); // Box 20
        body_colored_primary[12] = new ModelRendererTurbo(this, 345, 121, textureX, textureY); // Box 21
        body_colored_primary[13] = new ModelRendererTurbo(this, 297, 41, textureX, textureY); // Box 22
        body_colored_primary[14] = new ModelRendererTurbo(this, 65, 57, textureX, textureY); // Box 24
        body_colored_primary[15] = new ModelRendererTurbo(this, 177, 57, textureX, textureY); // Box 26
        body_colored_primary[16] = new ModelRendererTurbo(this, 1, 169, textureX, textureY); // Box 27
        body_colored_primary[17] = new ModelRendererTurbo(this, 57, 169, textureX, textureY); // Box 28
        body_colored_primary[18] = new ModelRendererTurbo(this, 465, 1, textureX, textureY); // Box 42
        body_colored_primary[19] = new ModelRendererTurbo(this, 489, 1, textureX, textureY); // Box 43
        body_colored_primary[20] = new ModelRendererTurbo(this, 409, 9, textureX, textureY); // Box 44
        body_colored_primary[21] = new ModelRendererTurbo(this, 433, 9, textureX, textureY); // Box 45
        body_colored_primary[22] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 46
        body_colored_primary[23] = new ModelRendererTurbo(this, 25, 17, textureX, textureY); // Box 47
        body_colored_primary[24] = new ModelRendererTurbo(this, 241, 17, textureX, textureY); // Box 48
        body_colored_primary[25] = new ModelRendererTurbo(this, 297, 17, textureX, textureY); // Box 49
        body_colored_primary[26] = new ModelRendererTurbo(this, 265, 1, textureX, textureY); // Box 50
        body_colored_primary[27] = new ModelRendererTurbo(this, 265, 17, textureX, textureY); // Box 51
        body_colored_primary[28] = new ModelRendererTurbo(this, 65, 73, textureX, textureY); // Box 53
        body_colored_primary[29] = new ModelRendererTurbo(this, 177, 73, textureX, textureY); // Box 54
        body_colored_primary[30] = new ModelRendererTurbo(this, 345, 17, textureX, textureY); // Box 55
        body_colored_primary[31] = new ModelRendererTurbo(this, 369, 17, textureX, textureY); // Box 56
        body_colored_primary[32] = new ModelRendererTurbo(this, 465, 17, textureX, textureY); // Box 57
        body_colored_primary[33] = new ModelRendererTurbo(this, 185, 25, textureX, textureY); // Box 58
        body_colored_primary[34] = new ModelRendererTurbo(this, 409, 25, textureX, textureY); // Box 59
        body_colored_primary[35] = new ModelRendererTurbo(this, 433, 25, textureX, textureY); // Box 61
        body_colored_primary[36] = new ModelRendererTurbo(this, 1, 33, textureX, textureY); // Box 62
        body_colored_primary[37] = new ModelRendererTurbo(this, 241, 33, textureX, textureY); // Box 63
        body_colored_primary[38] = new ModelRendererTurbo(this, 465, 33, textureX, textureY); // Box 64
        body_colored_primary[39] = new ModelRendererTurbo(this, 25, 33, textureX, textureY); // Box 65
        body_colored_primary[40] = new ModelRendererTurbo(this, 369, 33, textureX, textureY); // Box 66
        body_colored_primary[41] = new ModelRendererTurbo(this, 1, 57, textureX, textureY); // Box 67
        body_colored_primary[42] = new ModelRendererTurbo(this, 345, 57, textureX, textureY); // Box 68
        body_colored_primary[43] = new ModelRendererTurbo(this, 401, 65, textureX, textureY); // Box 69
        body_colored_primary[44] = new ModelRendererTurbo(this, 465, 65, textureX, textureY); // Box 70
        body_colored_primary[45] = new ModelRendererTurbo(this, 1, 73, textureX, textureY); // Box 71
        body_colored_primary[46] = new ModelRendererTurbo(this, 497, 33, textureX, textureY); // Box 72
        body_colored_primary[47] = new ModelRendererTurbo(this, 33, 57, textureX, textureY); // Box 73
        body_colored_primary[48] = new ModelRendererTurbo(this, 289, 73, textureX, textureY); // Box 75
        body_colored_primary[49] = new ModelRendererTurbo(this, 321, 73, textureX, textureY); // Box 76
        body_colored_primary[50] = new ModelRendererTurbo(this, 145, 57, textureX, textureY); // Box 77
        body_colored_primary[51] = new ModelRendererTurbo(this, 257, 57, textureX, textureY); // Box 78
        body_colored_primary[52] = new ModelRendererTurbo(this, 1, 201, textureX, textureY); // Box 80
        body_colored_primary[53] = new ModelRendererTurbo(this, 177, 209, textureX, textureY); // Box 82
        body_colored_primary[54] = new ModelRendererTurbo(this, 321, 1, textureX, textureY); // Box 95
        body_colored_primary[55] = new ModelRendererTurbo(this, 321, 17, textureX, textureY); // Box 96
        body_colored_primary[56] = new ModelRendererTurbo(this, 497, 65, textureX, textureY); // Box 99
        body_colored_primary[57] = new ModelRendererTurbo(this, 33, 81, textureX, textureY); // Box 100
        body_colored_primary[58] = new ModelRendererTurbo(this, 233, 233, textureX, textureY); // Box 101
        body_colored_primary[59] = new ModelRendererTurbo(this, 1, 113, textureX, textureY); // Box 100
        body_colored_primary[60] = new ModelRendererTurbo(this, 17, 113, textureX, textureY); // Box 101

        body_colored_primary[0].addShapeBox(0F, 0F, 0F, 4, 7, 48, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F); // Box 2
        body_colored_primary[0].setRotationPoint(21F, -19F, -24F);

        body_colored_primary[1].addShapeBox(0F, 0F, 0F, 4, 3, 48, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 3
        body_colored_primary[1].setRotationPoint(25F, -19F, -24F);

        body_colored_primary[2].addBox(0F, 0F, 0F, 1, 2, 48, 0F); // Box 4
        body_colored_primary[2].setRotationPoint(29F, -19F, -24F);

        body_colored_primary[3].addShapeBox(0F, 0F, 0F, 4, 3, 48, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 5
        body_colored_primary[3].setRotationPoint(30F, -19F, -24F);

        body_colored_primary[4].addShapeBox(0F, 0F, 0F, 4, 7, 48, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F); // Box 6
        body_colored_primary[4].setRotationPoint(34F, -19F, -24F);

        body_colored_primary[5].addBox(0F, 0F, 0F, 4, 7, 48, 0F); // Box 10
        body_colored_primary[5].setRotationPoint(38F, -19F, -24F);

        body_colored_primary[6].addShapeBox(0F, 0F, 0F, 3, 7, 48, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F); // Box 12
        body_colored_primary[6].setRotationPoint(42F, -19F, -24F);

        body_colored_primary[7].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F); // Box 16
        body_colored_primary[7].setRotationPoint(42F, -22F, 22F);

        body_colored_primary[8].addBox(0F, 0F, 0F, 5, 3, 32, 0F); // Box 17
        body_colored_primary[8].setRotationPoint(40F, -22F, -16F);

        body_colored_primary[9].addShapeBox(0F, 0F, 0F, 3, 1, 48, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F); // Box 18
        body_colored_primary[9].setRotationPoint(42F, -23F, -24F);

        body_colored_primary[10].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 19
        body_colored_primary[10].setRotationPoint(42F, -22F, -24F);

        body_colored_primary[11].addBox(0F, 0F, 0F, 25, 4, 2, 0F); // Box 20
        body_colored_primary[11].setRotationPoint(17F, -23F, 22F);

        body_colored_primary[12].addBox(0F, 0F, 0F, 4, 7, 48, 0F); // Box 21
        body_colored_primary[12].setRotationPoint(17F, -19F, -24F);

        body_colored_primary[13].addBox(0F, 0F, 0F, 25, 4, 2, 0F); // Box 22
        body_colored_primary[13].setRotationPoint(17F, -23F, -24F);

        body_colored_primary[14].addShapeBox(0F, 0F, 0F, 25, 2, 12, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 24
        body_colored_primary[14].setRotationPoint(17F, -25F, 12F);

        body_colored_primary[15].addShapeBox(0F, 0F, 0F, 25, 2, 12, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 26
        body_colored_primary[15].setRotationPoint(17F, -25F, -24F);

        body_colored_primary[16].addShapeBox(0F, 0F, 0F, 27, 2, 24, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 27
        body_colored_primary[16].setRotationPoint(15F, -25F, -12F);

        body_colored_primary[17].addShapeBox(0F, 0F, 0F, 3, 1, 48, 0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F); // Box 28
        body_colored_primary[17].setRotationPoint(42F, -24F, -24F);

        body_colored_primary[18].addShapeBox(0F, 0F, 0F, 4, 7, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F); // Box 42
        body_colored_primary[18].setRotationPoint(-55F, -19F, 18F);

        body_colored_primary[19].addShapeBox(0F, 0F, 0F, 4, 7, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F); // Box 43
        body_colored_primary[19].setRotationPoint(-55F, -19F, -24F);

        body_colored_primary[20].addShapeBox(0F, 0F, 0F, 4, 7, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F); // Box 44
        body_colored_primary[20].setRotationPoint(-68F, -19F, 18F);

        body_colored_primary[21].addShapeBox(0F, 0F, 0F, 4, 7, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F); // Box 45
        body_colored_primary[21].setRotationPoint(-68F, -19F, -24F);

        body_colored_primary[22].addShapeBox(0F, 0F, 0F, 4, 3, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 46
        body_colored_primary[22].setRotationPoint(-59F, -19F, 18F);

        body_colored_primary[23].addShapeBox(0F, 0F, 0F, 4, 3, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 47
        body_colored_primary[23].setRotationPoint(-59F, -19F, -24F);

        body_colored_primary[24].addShapeBox(0F, 0F, 0F, 4, 3, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 48
        body_colored_primary[24].setRotationPoint(-64F, -19F, 18F);

        body_colored_primary[25].addShapeBox(0F, 0F, 0F, 4, 3, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 49
        body_colored_primary[25].setRotationPoint(-64F, -19F, -24F);

        body_colored_primary[26].addBox(0F, 0F, 0F, 1, 2, 6, 0F); // Box 50
        body_colored_primary[26].setRotationPoint(-60F, -19F, 18F);

        body_colored_primary[27].addBox(0F, 0F, 0F, 1, 2, 6, 0F); // Box 51
        body_colored_primary[27].setRotationPoint(-60F, -19F, -24F);

        body_colored_primary[28].addShapeBox(0F, 0F, 0F, 39, 14, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 53
        body_colored_primary[28].setRotationPoint(-51F, -26F, 23F);

        body_colored_primary[29].addShapeBox(0F, 0F, 0F, 39, 14, 1, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 54
        body_colored_primary[29].setRotationPoint(-51F, -26F, -24F);

        body_colored_primary[30].addShapeBox(0F, 0F, 0F, 4, 7, 6, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 55
        body_colored_primary[30].setRotationPoint(-51F, -19F, 17F);

        body_colored_primary[31].addShapeBox(0F, 0F, 0F, 4, 7, 6, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 56
        body_colored_primary[31].setRotationPoint(-51F, -19F, -23F);

        body_colored_primary[32].addBox(0F, 0F, 0F, 17, 7, 1, 0F); // Box 57
        body_colored_primary[32].setRotationPoint(-68F, -19F, 17F);

        body_colored_primary[33].addBox(0F, 0F, 0F, 17, 7, 1, 0F); // Box 58
        body_colored_primary[33].setRotationPoint(-68F, -19F, -18F);

        body_colored_primary[34].addShapeBox(0F, 0F, 0F, 4, 7, 6, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 59
        body_colored_primary[34].setRotationPoint(-72F, -19F, 17F);

        body_colored_primary[35].addShapeBox(0F, 0F, 0F, 4, 7, 6, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 61
        body_colored_primary[35].setRotationPoint(-72F, -19F, -23F);

        body_colored_primary[36].addShapeBox(0F, 0F, 0F, 4, 2, 6, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 62
        body_colored_primary[36].setRotationPoint(-55F, -21F, 17F);

        body_colored_primary[37].addBox(0F, 0F, 0F, 9, 2, 6, 0F); // Box 63
        body_colored_primary[37].setRotationPoint(-64F, -21F, 17F);

        body_colored_primary[38].addBox(0F, 0F, 0F, 9, 2, 6, 0F); // Box 64
        body_colored_primary[38].setRotationPoint(-64F, -21F, -23F);

        body_colored_primary[39].addShapeBox(0F, 0F, 0F, 4, 2, 6, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 65
        body_colored_primary[39].setRotationPoint(-55F, -21F, -23F);

        body_colored_primary[40].addShapeBox(0F, 0F, 0F, 4, 2, 6, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 66
        body_colored_primary[40].setRotationPoint(-68F, -21F, 17F);

        body_colored_primary[41].addShapeBox(0F, 0F, 0F, 4, 2, 6, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 67
        body_colored_primary[41].setRotationPoint(-68F, -21F, -23F);

        body_colored_primary[42].addShapeBox(0F, 0F, 0F, 17, 7, 1, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 68
        body_colored_primary[42].setRotationPoint(-68F, -26F, -24F);

        body_colored_primary[43].addShapeBox(0F, 0F, 0F, 17, 7, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 69
        body_colored_primary[43].setRotationPoint(-68F, -26F, 23F);

        body_colored_primary[44].addShapeBox(0F, 0F, 0F, 12, 14, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 70
        body_colored_primary[44].setRotationPoint(-80F, -26F, 23F);

        body_colored_primary[45].addShapeBox(0F, 0F, 0F, 12, 14, 1, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 71
        body_colored_primary[45].setRotationPoint(-80F, -26F, -24F);

        body_colored_primary[46].addShapeBox(0F, 0F, 0F, 2, 14, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F); // Box 72
        body_colored_primary[46].setRotationPoint(-82F, -26F, 20F);

        body_colored_primary[47].addShapeBox(0F, 0F, 0F, 2, 14, 4, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 73
        body_colored_primary[47].setRotationPoint(-82F, -26F, -24F);

        body_colored_primary[48].addShapeBox(0F, 0F, 0F, 2, 2, 12, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 75
        body_colored_primary[48].setRotationPoint(15F, -25F, 12F);

        body_colored_primary[49].addShapeBox(0F, 0F, 0F, 2, 2, 12, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 76
        body_colored_primary[49].setRotationPoint(15F, -25F, -24F);

        body_colored_primary[50].addBox(0F, 0F, 0F, 4, 11, 2, 0F); // Box 77
        body_colored_primary[50].setRotationPoint(13F, -23F, 22F);

        body_colored_primary[51].addBox(0F, 0F, 0F, 4, 11, 2, 0F); // Box 78
        body_colored_primary[51].setRotationPoint(13F, -23F, -24F);

        body_colored_primary[52].addBox(0F, 0F, 0F, 2, 2, 48, 0F); // Box 80
        body_colored_primary[52].setRotationPoint(13F, -25F, -24F);

        body_colored_primary[53].addBox(0F, 0F, 0F, 2, 14, 48, 0F); // Box 82
        body_colored_primary[53].setRotationPoint(-12F, -26F, -24F);

        body_colored_primary[54].addBox(0F, 0F, 0F, 1, 14, 1, 0F); // Box 95
        body_colored_primary[54].setRotationPoint(12F, -25F, 22F);

        body_colored_primary[55].addBox(0F, 0F, 0F, 1, 14, 1, 0F); // Box 96
        body_colored_primary[55].setRotationPoint(12F, -25F, -23F);

        body_colored_primary[56].addBox(0F, 0F, 0F, 2, 13, 2, 0F); // Box 99
        body_colored_primary[56].setRotationPoint(-12F, -39F, 22F);

        body_colored_primary[57].addBox(0F, 0F, 0F, 2, 13, 2, 0F); // Box 100
        body_colored_primary[57].setRotationPoint(-12F, -39F, -24F);

        body_colored_primary[58].addBox(0F, 0F, 0F, 22, 1, 48, 0F); // Box 101
        body_colored_primary[58].setRotationPoint(-13F, -40F, -24F);

        body_colored_primary[59].addBox(0F, 0F, 0F, 2, 16, 2, 0F); // Box 100
        body_colored_primary[59].setRotationPoint(7F, -39F, 22F);
        body_colored_primary[59].rotateAngleZ = -0.38397244F;

        body_colored_primary[60].addBox(0F, 0F, 0F, 2, 16, 2, 0F); // Box 101
        body_colored_primary[60].setRotationPoint(7F, -39F, -24F);
        body_colored_primary[60].rotateAngleZ = -0.38397244F;
        this.add("body_colored_primary", body_colored_primary);

        fixRotations();
    }

}
