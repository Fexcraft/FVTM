//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2018 Minecraft-SMP.de
// This file is for Fex's Vehicle & Transportation Mod
// Model: C1_R1
// Model Creator: FEX___96
// Created on: 22.08.2016 - 20:40:40
// Last changed on: 04.04.2018
package net.fexcraft.mod.addons.fvp.models.part.c8;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.part.PartModel;

public class ModelC8Lights extends PartModel {

    public ModelC8Lights(){
    	super(); textureX = 512; textureY = 512;
        this.addToCreators("01e4af9b-2a30-471e-addf-f6338ffce04b");
        //
        ModelRendererTurbo[] front_lights = new ModelRendererTurbo[2];
        front_lights[0] = new ModelRendererTurbo(this, 193, 137, textureX, textureY); // Box 209
        front_lights[1] = new ModelRendererTurbo(this, 241, 137, textureX, textureY); // Box 211
        front_lights[0].addShapeBox(0F, 0F, 0F, 2, 4, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.4F, 0F, 0F, 1.4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.4F, 0F, 0F, 1.4F, 0F, 0F); // Box 209
        front_lights[0].setRotationPoint(54.8F, -5F, 14F);
        front_lights[1].addShapeBox(0F, 0F, 0F, 2, 4, 6, 0F, 1.4F, 0F, 0F, -1.4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1.4F, 0F, 0F, -1.4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 211
        front_lights[1].setRotationPoint(54.8F, -5F, -20F);
        //
        ModelRendererTurbo[] back_lights = new ModelRendererTurbo[2];
        back_lights[0] = new ModelRendererTurbo(this, 497, 105, textureX, textureY); // Box 213
        back_lights[1] = new ModelRendererTurbo(this, 497, 121, textureX, textureY); // Box 215
        back_lights[0].addShapeBox(0F, 0F, 0F, 2, 4, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1.4F, 0F, 0F, -1.4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1.4F, 0F, 0F, -1.4F, 0F, 0F); // Box 213
        back_lights[0].setRotationPoint(-55.8F, -6F, 16F);
        back_lights[1].addShapeBox(0F, 0F, 0F, 2, 4, 4, 0F, -1.4F, 0F, 0F, 1.4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.4F, 0F, 0F, 1.4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 215
        back_lights[1].setRotationPoint(-55.8F, -6F, -20F);
        //
        ModelRendererTurbo[] reverse_lights = new ModelRendererTurbo[1];
        reverse_lights[0] = new ModelRendererTurbo(this, 377, 73, textureX, textureY); // Box 217
        reverse_lights[0].addShapeBox(0F, 0F, 0F, 1, 1, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.7F, 0F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.7F, 0F, 0F, -0.7F, 0F, 0F); // Box 217
        reverse_lights[0].setRotationPoint(-55.7F, -3F, 16.5F);
        //
        this.add("front_lights", front_lights);
        this.add("back_lights", back_lights);
        this.add("reverse_lights", reverse_lights);
        fixRotations();
    }

}
