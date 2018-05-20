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

public class ModelC1R1BS extends PartModel<VehicleData> {

    int textureX = 512;
    int textureY = 512;

    public ModelC1R1BS(){
        this.creators.add("01e4af9b-2a30-471e-addf-f6338ffce04b");
        body = new ModelRendererTurbo[8];
        body[0] = new ModelRendererTurbo(this, 89, 177, textureX, textureY); // Box 695
        body[1] = new ModelRendererTurbo(this, 433, 161, textureX, textureY); // Box 696
        body[2] = new ModelRendererTurbo(this, 185, 185, textureX, textureY); // Box 697
        body[3] = new ModelRendererTurbo(this, 393, 177, textureX, textureY); // Box 698
        body[4] = new ModelRendererTurbo(this, 321, 313, textureX, textureY); // Box 699
        body[5] = new ModelRendererTurbo(this, 377, 321, textureX, textureY); // Box 700
        body[6] = new ModelRendererTurbo(this, 1, 345, textureX, textureY); // Box 701
        body[7] = new ModelRendererTurbo(this, 281, 321, textureX, textureY); // Box 702

        body[0].addBox(0F, 0F, 3F, 8, 2, 1, 0F); // Box 695
        body[0].setRotationPoint(-19F, -2F, 10F);

        body[1].addBox(0F, 0F, -4F, 8, 2, 1, 0F); // Box 696
        body[1].setRotationPoint(-19F, -2F, 10F);

        body[2].addBox(0F, 0F, 3F, 8, 2, 1, 0F); // Box 697
        body[2].setRotationPoint(-19F, -2F, -10F);

        body[3].addBox(0F, 0F, -4F, 8, 2, 1, 0F); // Box 698
        body[3].setRotationPoint(-19F, -2F, -10F);

        body[4].addShapeBox(0F, 0F, 0F, 11, 1, 31, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F); // Box 699
        body[4].setRotationPoint(-20.5F, -3F, -15.5F);

        body[5].addBox(0F, 0F, 0F, 12, 2, 36, 0F); // Box 700
        body[5].setRotationPoint(-21F, -5F, -18F);

        body[6].addBox(0F, 0F, 0F, 2, 12, 36, 0F); // Box 701
        body[6].setRotationPoint(-23F, -17F, -18F);

        body[7].addShapeBox(0F, 0F, 0F, 2, 2, 32, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.25F, 0F, 0F, -1.75F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, -1.75F, -0.25F, 0F); // Box 702
        body[7].setRotationPoint(-23F, -5F, -16F);

        translateAll(0F, 0F, 0F);
        flipAll();
    }

}
