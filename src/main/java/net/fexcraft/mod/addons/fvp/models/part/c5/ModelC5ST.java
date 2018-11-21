//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2017 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+
// Model: C2
// Model Creator: 
// Created on: 24.08.2015 - 16:52:34
// Last changed on: 24.08.2015 - 16:52:34
package net.fexcraft.mod.addons.fvp.models.part.c5;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.part.PartModel;

public class ModelC5ST extends PartModel {

    public ModelC5ST(){
    	super(); textureX = 512; textureY = 512;
        this.addToCreators("Ferdinand (FEX___96)");
        ModelRendererTurbo[] steering = new ModelRendererTurbo[13];
        steering[0] = new ModelRendererTurbo(this, 345, 1, textureX, textureY); // Box 277
        steering[1] = new ModelRendererTurbo(this, 97, 1, textureX, textureY); // Box 278
        steering[2] = new ModelRendererTurbo(this, 361, 1, textureX, textureY); // Box 279
        steering[3] = new ModelRendererTurbo(this, 105, 1, textureX, textureY); // Box 280
        steering[4] = new ModelRendererTurbo(this, 385, 1, textureX, textureY); // Box 281
        steering[5] = new ModelRendererTurbo(this, 409, 1, textureX, textureY); // Box 282
        steering[6] = new ModelRendererTurbo(this, 425, 1, textureX, textureY); // Box 283
        steering[7] = new ModelRendererTurbo(this, 441, 1, textureX, textureY); // Box 284
        steering[8] = new ModelRendererTurbo(this, 457, 1, textureX, textureY); // Box 285
        steering[9] = new ModelRendererTurbo(this, 481, 1, textureX, textureY); // Box 286
        steering[10] = new ModelRendererTurbo(this, 353, 17, textureX, textureY); // Box 384
        steering[11] = new ModelRendererTurbo(this, 417, 17, textureX, textureY); // Box 385
        steering[12] = new ModelRendererTurbo(this, 433, 17, textureX, textureY); // Box 386

        steering[0].addBox(-0.6F, -0.5F, -0.5F, 2, 1, 1, 0F); // Box 277
        steering[0].setRotationPoint(25F, -10F, 12F);

        steering[1].addShapeBox(-0.5F, -2.5F, -0.5F, 1, 2, 1, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F); // Box 278
        steering[1].setRotationPoint(25F, -10F, 12F);

        steering[2].addShapeBox(-0.5F, -0.5F, -2.5F, 1, 1, 2, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F); // Box 279
        steering[2].setRotationPoint(25F, -10F, 12F);

        steering[3].addShapeBox(-0.5F, 0.5F, -0.5F, 1, 2, 1, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F); // Box 280
        steering[3].setRotationPoint(25F, -10F, 12F);

        steering[4].addShapeBox(-0.5F, 1.5F, 1.5F, 1, 1, 2, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 281
        steering[4].setRotationPoint(25F, -10F, 12F);

        steering[5].addShapeBox(-0.5F, 1.5F, -3.5F, 1, 1, 2, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F); // Box 282
        steering[5].setRotationPoint(25F, -10F, 12F);

        steering[6].addBox(-0.5F, 2.5F, -1.5F, 1, 1, 3, 0F); // Box 283
        steering[6].setRotationPoint(25F, -10F, 12F);

        steering[7].addBox(-0.5F, -3.5F, -1.5F, 1, 1, 3, 0F); // Box 284
        steering[7].setRotationPoint(25F, -10F, 12F);

        steering[8].addShapeBox(-0.5F, -2.5F, 1.5F, 1, 1, 2, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 285
        steering[8].setRotationPoint(25F, -10F, 12F);

        steering[9].addShapeBox(-0.5F, -2.5F, -3.5F, 1, 1, 2, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 286
        steering[9].setRotationPoint(25F, -10F, 12F);

        steering[10].addShapeBox(-0.5F, -0.5F, 0.5F, 1, 1, 2, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F); // Box 384
        steering[10].setRotationPoint(25F, -10F, 12F);

        steering[11].addBox(-0.5F, -1.5F, 2.5F, 1, 3, 1, 0F); // Box 385
        steering[11].setRotationPoint(25F, -10F, 12F);

        steering[12].addBox(-0.5F, -1.5F, -3.5F, 1, 3, 1, 0F); // Box 386
        steering[12].setRotationPoint(25F, -10F, 12F);
        this.add("steering", steering);
        fixRotations();
    }

    //TODO override rendering to save up processing time
}
