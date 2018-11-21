//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2018 Minecraft-SMP.de
// This file is for Fex's Vehicle & Transportation Mod
// Model: C1_R1
// Model Creator: FEX___96
// Created on: 22.08.2016 - 20:40:40
// Last changed on: 04.04.2018
package net.fexcraft.mod.addons.fvp.models.part.t2;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.part.PartModel;

public class ModelT2RL extends PartModel {

    public ModelT2RL(){
    	super(); textureX = 512; textureY = 512;
        this.addToCreators("01e4af9b-2a30-471e-addf-f6338ffce04b");
        ModelRendererTurbo[] body = new ModelRendererTurbo[1];
        body[0] = new ModelRendererTurbo(this, 17, 177, textureX, textureY); // Box 136
        body[0].addShapeBox(0F, 0F, 0F, 2, 2, 48, 0F, 0F, 0F, 0F, 0F, 0F, -8F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -8F, 0F, 0F, -8F, 0F, 0F, 0F); // Box 136
        body[0].setRotationPoint(-63F, -12F, -24F);
        //
        ModelRendererTurbo[] back_lights = new ModelRendererTurbo[4];
        back_lights[0] = new ModelRendererTurbo(this, 57, 1, textureX, textureY); // Box 137
        back_lights[1] = new ModelRendererTurbo(this, 385, 1, textureX, textureY); // Box 138
        back_lights[2] = new ModelRendererTurbo(this, 105, 1, textureX, textureY); // Box 139
        back_lights[3] = new ModelRendererTurbo(this, 161, 1, textureX, textureY); // Box 140
        back_lights[0].addShapeBox(0F, 0F, 0F, 1, 3, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 137
        back_lights[0].setRotationPoint(-64F, -12.5F, -23F);
        back_lights[1].addShapeBox(0F, 0F, 0F, 1, 3, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 138
        back_lights[1].setRotationPoint(-64F, -12.5F, 17F);
        back_lights[2].addShapeBox(0F, 0F, 0F, 1, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 139
        back_lights[2].setRotationPoint(-64F, -12.5F, 23F);
        back_lights[3].addShapeBox(0F, 0F, 0F, 1, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 140
        back_lights[3].setRotationPoint(-64F, -12.5F, -25F);
        //
        this.add("body", body);
        this.add("back_lights", back_lights);
        this.get("back_lights").addProgram(DefaultPrograms.BACK_LIGHTS);
        fixRotations();
    }

}
