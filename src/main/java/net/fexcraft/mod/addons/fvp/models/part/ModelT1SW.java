//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2016 Minecraft-SMP.de
// This file is for Fex's Vehicle Mod
// Model: T1(P)
// Model Creator: FEX___96
// Created on: 20.01.2016 - 22:15:40
// Last changed on: 20.01.2016 - 22:15:40
package net.fexcraft.mod.addons.fvp.models.part;

import net.fexcraft.mod.fvtm.model.part.PartModel;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelT1SW extends PartModel {

    public ModelT1SW(){
    	super(); textureX = 512; textureY = 512;
        addToCreators("Ferdinand (FEX___96)");
        steering = new ModelRendererTurbo[14];
        steering[0] = new ModelRendererTurbo(this, 369, 97, textureX, textureY); // Box 386
        steering[1] = new ModelRendererTurbo(this, 145, 105, textureX, textureY); // Box 387
        steering[2] = new ModelRendererTurbo(this, 185, 57, textureX, textureY); // Box 389
        steering[3] = new ModelRendererTurbo(this, 385, 57, textureX, textureY); // Box 390
        steering[4] = new ModelRendererTurbo(this, 249, 105, textureX, textureY); // Box 391
        steering[5] = new ModelRendererTurbo(this, 345, 105, textureX, textureY); // Box 392
        steering[6] = new ModelRendererTurbo(this, 1, 113, textureX, textureY); // Box 393
        steering[7] = new ModelRendererTurbo(this, 121, 113, textureX, textureY); // Box 394
        steering[8] = new ModelRendererTurbo(this, 73, 113, textureX, textureY); // Box 395
        steering[9] = new ModelRendererTurbo(this, 145, 113, textureX, textureY); // Box 396
        steering[10] = new ModelRendererTurbo(this, 305, 121, textureX, textureY); // Box 397
        steering[11] = new ModelRendererTurbo(this, 393, 121, textureX, textureY); // Box 398
        steering[12] = new ModelRendererTurbo(this, 409, 121, textureX, textureY); // Box 399
        steering[13] = new ModelRendererTurbo(this, 505, 121, textureX, textureY); // Box 400

        steering[0].addBox(-2F, -0.5F, -0.5F, 2, 1, 1, 0F); // Box 386
        steering[0].setRotationPoint(47.6F, -22F, 11F);

        steering[1].addShapeBox(-2F, -0.5F, -0.5F, 1, 1, 1, 0F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F); // Box 387
        steering[1].setRotationPoint(47.6F, -22F, 11F);

        steering[2].addBox(-2F, -0.5F, 0.5F, 1, 1, 3, 0F); // Box 389
        steering[2].setRotationPoint(47.6F, -22F, 11F);

        steering[3].addBox(-2F, -0.5F, -3.5F, 1, 1, 3, 0F); // Box 390
        steering[3].setRotationPoint(47.6F, -22F, 11F);

        steering[4].addBox(-2F, 0.5F, -0.5F, 1, 3, 1, 0F); // Box 391
        steering[4].setRotationPoint(47.6F, -22F, 11F);

        steering[5].addBox(-2F, -3.5F, -0.5F, 1, 3, 1, 0F); // Box 392
        steering[5].setRotationPoint(47.6F, -22F, 11F);

        steering[6].addBox(-2F, -4.5F, -1.5F, 1, 1, 3, 0F); // Box 393
        steering[6].setRotationPoint(47.6F, -22F, 11F);

        steering[7].addBox(-2F, 3.5F, -1.5F, 1, 1, 3, 0F); // Box 394
        steering[7].setRotationPoint(47.6F, -22F, 11F);

        steering[8].addBox(-2F, -1.5F, 3.5F, 1, 3, 1, 0F); // Box 395
        steering[8].setRotationPoint(47.6F, -22F, 11F);

        steering[9].addBox(-2F, -1.5F, -4.5F, 1, 3, 1, 0F); // Box 396
        steering[9].setRotationPoint(47.6F, -22F, 11F);

        steering[10].addShapeBox(-2F, -4.5F, -4.5F, 1, 3, 1, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, -1F, 2F, 0F, -1F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 397
        steering[10].setRotationPoint(47.6F, -22F, 11F);

        steering[11].addShapeBox(-2F, 1.5F, -4.5F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, -1F, 2F, 0F, -1F, 2F); // Box 398
        steering[11].setRotationPoint(47.6F, -22F, 11F);

        steering[12].addShapeBox(-2F, 1.5F, 3.5F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 2F, 0F, -1F, 2F, 0F, 0F, -3F, 0F, 0F, -3F); // Box 399
        steering[12].setRotationPoint(47.6F, -22F, 11F);

        steering[13].addShapeBox(-2F, -4.5F, 3.5F, 1, 3, 1, 0F, 0F, -1F, 2F, 0F, -1F, 2F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 400
        steering[13].setRotationPoint(47.6F, -22F, 11F);

        translateAll(0F, 0F, 0F);

    }

}
