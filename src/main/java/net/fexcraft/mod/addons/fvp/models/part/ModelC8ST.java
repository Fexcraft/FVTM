//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2018 Minecraft-SMP.de
// This file is for Fex's Vehicle & Transportation Mod
// Model: C1_R1
// Model Creator: FEX___96
// Created on: 22.08.2016 - 20:40:40
// Last changed on: 04.04.2018
package net.fexcraft.mod.addons.fvp.models.part;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.part.PartModel;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelC8ST extends PartModel<VehicleData> {

    int textureX = 512;
    int textureY = 512;

    public ModelC8ST(){
        this.creators.add("01e4af9b-2a30-471e-addf-f6338ffce04b");
        steering = new ModelRendererTurbo[13];
        steering[0] = new ModelRendererTurbo(this, 105, 65, textureX, textureY); // Box 170
        steering[1] = new ModelRendererTurbo(this, 185, 9, textureX, textureY); // Box 171
        steering[2] = new ModelRendererTurbo(this, 49, 17, textureX, textureY); // Box 172
        steering[3] = new ModelRendererTurbo(this, 81, 17, textureX, textureY); // Box 173
        steering[4] = new ModelRendererTurbo(this, 129, 65, textureX, textureY); // Box 174
        steering[5] = new ModelRendererTurbo(this, 153, 65, textureX, textureY); // Box 175
        steering[6] = new ModelRendererTurbo(this, 241, 65, textureX, textureY); // Box 176
        steering[7] = new ModelRendererTurbo(this, 257, 65, textureX, textureY); // Box 177
        steering[8] = new ModelRendererTurbo(this, 489, 65, textureX, textureY); // Box 178
        steering[9] = new ModelRendererTurbo(this, 409, 73, textureX, textureY); // Box 179
        steering[10] = new ModelRendererTurbo(this, 105, 17, textureX, textureY); // Box 180
        steering[11] = new ModelRendererTurbo(this, 505, 25, textureX, textureY); // Box 181
        steering[12] = new ModelRendererTurbo(this, 17, 33, textureX, textureY); // Box 182

        steering[0].addBox(0F, -1F, -1F, 3, 2, 2, 0F); // Box 170
        steering[0].setRotationPoint(18F, -9F, 11F);
        steering[0].rotateAngleZ = -0.34906585F;

        steering[1].addBox(-1F, -1.5F, -1.5F, 1, 3, 3, 0F); // Box 171
        steering[1].setRotationPoint(18F, -9F, 11F);
        steering[1].rotateAngleZ = -0.34906585F;

        steering[2].addBox(-1F, -1.5F, 3.5F, 1, 3, 1, 0F); // Box 172
        steering[2].setRotationPoint(18F, -9F, 11F);
        steering[2].rotateAngleZ = -0.34906585F;

        steering[3].addBox(-1F, -1.5F, -4.5F, 1, 3, 1, 0F); // Box 173
        steering[3].setRotationPoint(18F, -9F, 11F);
        steering[3].rotateAngleZ = -0.34906585F;

        steering[4].addBox(-1F, -4.5F, -1.5F, 1, 1, 3, 0F); // Box 174
        steering[4].setRotationPoint(18F, -9F, 11F);
        steering[4].rotateAngleZ = -0.34906585F;

        steering[5].addBox(-1F, 3.5F, -1.5F, 1, 1, 3, 0F); // Box 175
        steering[5].setRotationPoint(18F, -9F, 11F);
        steering[5].rotateAngleZ = -0.34906585F;

        steering[6].addShapeBox(-1F, 3.5F, 1.5F, 1, 1, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, -1F, 0F, 2F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F); // Box 176
        steering[6].setRotationPoint(18F, -9F, 11F);
        steering[6].rotateAngleZ = -0.34906585F;

        steering[7].addShapeBox(-1F, -4.5F, 1.5F, 1, 1, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, -1F, 0F, 2F, -1F); // Box 177
        steering[7].setRotationPoint(18F, -9F, 11F);
        steering[7].rotateAngleZ = -0.34906585F;

        steering[8].addShapeBox(-1F, 3.5F, -4.5F, 1, 1, 3, 0F, 0F, 2F, -1F, 0F, 2F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 178
        steering[8].setRotationPoint(18F, -9F, 11F);
        steering[8].rotateAngleZ = -0.34906585F;

        steering[9].addShapeBox(-1F, -4.5F, -4.5F, 1, 1, 3, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, -1F, 0F, 2F, -1F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 179
        steering[9].setRotationPoint(18F, -9F, 11F);
        steering[9].rotateAngleZ = -0.34906585F;

        steering[10].addShapeBox(-1F, 1.5F, -1F, 1, 2, 2, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F); // Box 180
        steering[10].setRotationPoint(18F, -9F, 11F);
        steering[10].rotateAngleZ = -0.34906585F;

        steering[11].addShapeBox(-1F, -1F, 1.5F, 1, 2, 2, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F); // Box 181
        steering[11].setRotationPoint(18F, -9F, 11F);
        steering[11].rotateAngleZ = -0.34906585F;

        steering[12].addShapeBox(-1F, -1F, -3.5F, 1, 2, 2, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F); // Box 182
        steering[12].setRotationPoint(18F, -9F, 11F);
        steering[12].rotateAngleZ = -0.34906585F;

        translateAll(0F, 0F, 0F);
        flipAll();
    }

}
