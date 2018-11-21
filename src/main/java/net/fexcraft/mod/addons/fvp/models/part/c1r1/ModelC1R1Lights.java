//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2018 Minecraft-SMP.de
// This file is for Fex's Vehicle & Transportation Mod
// Model: C1_R1
// Model Creator: FEX___96
// Created on: 22.08.2016 - 20:40:40
// Last changed on: 04.04.2018
package net.fexcraft.mod.addons.fvp.models.part.c1r1;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.part.PartModel;

public class ModelC1R1Lights extends PartModel {

    public ModelC1R1Lights(){
    	super(); textureX = 512; textureY = 512;
        this.addToCreators("01e4af9b-2a30-471e-addf-f6338ffce04b");
        //
        ModelRendererTurbo[] front_lights = new ModelRendererTurbo[2];
        front_lights[0] = new ModelRendererTurbo(this, 481, 241, textureX, textureY); // Box 654
        front_lights[1] = new ModelRendererTurbo(this, 129, 257, textureX, textureY); // Box 656
        front_lights[0].addShapeBox(0F, 0F, 0F, 3, 2, 10, 0F, 0F, 0F, 0F, 0.7F, 0F, 0F, -0.1F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.9F, 0F, 0F, 0.1F, 0F, -1F, -0.2F, 0F, 0F); // Box 654
        front_lights[0].setRotationPoint(54.5F, -6F, 11F);
        front_lights[1].addShapeBox(0F, 0F, 0F, 3, 2, 10, 0F, 0F, 0F, 0F, -0.1F, 0F, -1F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, 0.1F, 0F, -1F, 0.9F, 0F, 0F, 0F, 0F, 0F); // Box 656
        front_lights[1].setRotationPoint(54.5F, -6F, -21F);
        //
        ModelRendererTurbo[] back_lights = new ModelRendererTurbo[2];
        back_lights[0] = new ModelRendererTurbo(this, 281, 169, textureX, textureY); // Box 659
        back_lights[1] = new ModelRendererTurbo(this, 233, 177, textureX, textureY); // Box 660
        back_lights[0].addShapeBox(0F, 0F, 0F, 3, 5, 4, 0F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.1F, -0.6F, 0F, -0.9F, 0.3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.8F); // Box 659
        back_lights[0].setRotationPoint(-58F, -8F, 17F);
        back_lights[1].addShapeBox(0F, 0F, 0F, 3, 5, 4, 0F, -0.6F, 0F, -0.9F, 0F, 0F, -0.1F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0.3F, 0F, 0F); // Box 660
        back_lights[1].setRotationPoint(-58F, -8F, -21F);
        //
        this.add("front_lights", front_lights);
        this.add("back_lights", back_lights);
        fixRotations();
    }

}
