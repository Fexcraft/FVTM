//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2016 Minecraft-SMP.de
// This file is for Fex's Vehicle Mod
// Model: T1(P)
// Model Creator: FEX___96
// Created on: 20.01.2016 - 22:15:40
// Last changed on: 20.01.2016 - 22:15:40
package net.fexcraft.mod.addons.fvp.models.part;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.part.PartModel;

public class ModelT1TC extends PartModel {

    public ModelT1TC(){
    	super(); textureX = 128; textureY = 32;
        addToCreators("Ferdinand (FEX___96)");
        ModelRendererTurbo[] body = new ModelRendererTurbo[5];
        body[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
        body[1] = new ModelRendererTurbo(this, 49, 1, textureX, textureY); // Box 1
        body[2] = new ModelRendererTurbo(this, 1, 9, textureX, textureY); // Box 2
        body[3] = new ModelRendererTurbo(this, 97, 1, textureX, textureY); // Box 3
        body[4] = new ModelRendererTurbo(this, 113, 1, textureX, textureY); // Box 4

        body[0].addBox(0F, 0F, 0F, 20, 2, 2, 0F); // Box 0
        body[0].setRotationPoint(-104F, -1F, -1F);

        body[1].addShapeBox(0F, 0F, 0F, 20, 1, 2, 0F, 0F, 0F, 0F, 0F, 0F, 10F, 0F, 0F, -10F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 10F, 0F, 0F, -10F, 0F, 0F, 0F); // Box 1
        body[1].setRotationPoint(-104F, -0.5F, -1F);

        body[2].addShapeBox(0F, 0F, 0F, 20, 1, 2, 0F, 0F, 0F, 0F, 0F, 0F, -10F, 0F, 0F, 10F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -10F, 0F, 0F, 10F, 0F, 0F, 0F); // Box 2
        body[2].setRotationPoint(-104F, -0.5F, -1F);

        body[3].addBox(0F, 0F, 0F, 3, 3, 3, 0F); // Box 3
        body[3].setRotationPoint(-106.5F, -1.5F, -1.5F);

        body[4].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 4
        body[4].setRotationPoint(-105.5F, -3F, -0.5F);
        this.add("body", body);

        //translateAll(0F, 0F, 0F);
        //flipAll();
    }

}
