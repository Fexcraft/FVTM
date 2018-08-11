//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2018 Minecraft-SMP.de
// This file is for Fex's Vehicle & Transportation Mod
// Model: C1_R1
// Model Creator: FEX___96
// Created on: 22.08.2016 - 20:40:40
// Last changed on: 04.04.2018
package net.fexcraft.mod.addons.fvp.models.part;

import net.fexcraft.mod.fvtm.model.part.PartModelTMT;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelT2FL extends PartModelTMT {

    public ModelT2FL(){
    	super(); textureX = 512; textureY = 512;
        this.addToCreators("01e4af9b-2a30-471e-addf-f6338ffce04b");
        //
        front_lights = new ModelRendererTurbo[4];
        front_lights[0] = new ModelRendererTurbo(this, 89, 73, textureX, textureY); // Box 204
        front_lights[1] = new ModelRendererTurbo(this, 449, 73, textureX, textureY); // Box 206
        front_lights[2] = new ModelRendererTurbo(this, 153, 73, textureX, textureY); // Box 208
        front_lights[3] = new ModelRendererTurbo(this, 489, 73, textureX, textureY); // Box 209
        front_lights[0].addShapeBox(0F, 0F, 0F, 4, 3, 6, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, -3F, 0F, 0F, 0F); // Box 204
        front_lights[0].setRotationPoint(66F, -16F, 20F);
        front_lights[1].addShapeBox(0F, 0F, 0F, 4, 8, 6, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, -3F, 0F, 0F, 0F); // Box 206
        front_lights[1].setRotationPoint(66F, -24F, 20F);
        front_lights[2].addShapeBox(0F, 0F, 0F, 4, 3, 6, 0F, 0F, 0F, 0F, -0.2F, 0F, -3F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -3F, -0.2F, 0F, 0F, 0F, 0F, 0F); // Box 208
        front_lights[2].setRotationPoint(66F, -16F, -26F);
        front_lights[3].addShapeBox(0F, 0F, 0F, 4, 8, 6, 0F, 0F, 0F, 0F, -0.2F, 0F, -3F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -3F, -0.2F, 0F, 0F, 0F, 0F, 0F); // Box 209
        front_lights[3].setRotationPoint(66F, -24F, -26F);
        //
        translateAll(0F, 0F, 0F);
        flipAll();
    }

}
