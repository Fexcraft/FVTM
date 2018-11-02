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

public class ModelAB1SW extends PartModel {

    public ModelAB1SW(){
    	super(); textureX = 1024; textureY = 1024;
        addToCreators("Ferdinand (FEX___96)");
        ModelRendererTurbo[] steering = new ModelRendererTurbo[13];
        steering[0] = new ModelRendererTurbo(this, 233, 33, textureX, textureY); // Box 325
        steering[1] = new ModelRendererTurbo(this, 257, 33, textureX, textureY); // Box 331
        steering[2] = new ModelRendererTurbo(this, 257, 41, textureX, textureY); // Box 332
        steering[3] = new ModelRendererTurbo(this, 209, 49, textureX, textureY); // Box 333
        steering[4] = new ModelRendererTurbo(this, 489, 57, textureX, textureY); // Box 334
        steering[5] = new ModelRendererTurbo(this, 825, 9, textureX, textureY); // Box 335
        steering[6] = new ModelRendererTurbo(this, 905, 9, textureX, textureY); // Box 336
        steering[7] = new ModelRendererTurbo(this, 57, 49, textureX, textureY); // Box 337
        steering[8] = new ModelRendererTurbo(this, 97, 49, textureX, textureY); // Box 338
        steering[9] = new ModelRendererTurbo(this, 177, 49, textureX, textureY); // Box 339
        steering[10] = new ModelRendererTurbo(this, 881, 49, textureX, textureY); // Box 340
        steering[11] = new ModelRendererTurbo(this, 897, 49, textureX, textureY); // Box 341
        steering[12] = new ModelRendererTurbo(this, 913, 49, textureX, textureY); // Box 342
        steering[0].addShapeBox(0F, -1F, -1F, 1, 2, 2, 0F, 0.1F, 0.1F, 0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0.1F, 0.1F); // Box 325
        steering[0].setRotationPoint(88F, -25F, 19F);
        steering[0].rotateAngleZ = -1.29154365F;
        steering[1].addBox(0F, -4F, -0.5F, 1, 3, 1, 0F); // Box 331
        steering[1].setRotationPoint(88F, -25F, 19F);
        steering[1].rotateAngleZ = -1.29154365F;
        steering[2].addBox(0F, 1F, -0.5F, 1, 3, 1, 0F); // Box 332
        steering[2].setRotationPoint(88F, -25F, 19F);
        steering[2].rotateAngleZ = -1.29154365F;
        steering[3].addBox(0F, -0.5F, 1F, 1, 1, 3, 0F); // Box 333
        steering[3].setRotationPoint(88F, -25F, 19F);
        steering[3].rotateAngleZ = -1.29154365F;
        steering[4].addBox(0F, -0.5F, -4F, 1, 1, 3, 0F); // Box 334
        steering[4].setRotationPoint(88F, -25F, 19F);
        steering[4].rotateAngleZ = -1.29154365F;
        steering[5].addBox(0F, -5F, -2F, 1, 1, 4, 0F); // Box 335
        steering[5].setRotationPoint(88F, -25F, 19F);
        steering[5].rotateAngleZ = -1.29154365F;
        steering[6].addBox(0F, 4F, -2F, 1, 1, 4, 0F); // Box 336
        steering[6].setRotationPoint(88F, -25F, 19F);
        steering[6].rotateAngleZ = -1.29154365F;
        steering[7].addBox(0F, -2F, -5F, 1, 4, 1, 0F); // Box 337
        steering[7].setRotationPoint(88F, -25F, 19F);
        steering[7].rotateAngleZ = -1.29154365F;
        steering[8].addBox(0F, -2F, 4F, 1, 4, 1, 0F); // Box 338
        steering[8].setRotationPoint(88F, -25F, 19F);
        steering[8].rotateAngleZ = -1.29154365F;
        steering[9].addShapeBox(0F, -5F, -5F, 1, 3, 1, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, -1F, 2F, 0F, -1F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 339
        steering[9].setRotationPoint(88F, -25F, 19F);
        steering[9].rotateAngleZ = -1.29154365F;
        steering[10].addShapeBox(0F, 2F, -5F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, -1F, 2F, 0F, -1F, 2F); // Box 340
        steering[10].setRotationPoint(88F, -25F, 19F);
        steering[10].rotateAngleZ = -1.29154365F;
        steering[11].addShapeBox(0F, 2F, 4F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 2F, 0F, -1F, 2F, 0F, 0F, -3F, 0F, 0F, -3F); // Box 341
        steering[11].setRotationPoint(88F, -25F, 19F);
        steering[11].rotateAngleZ = -1.29154365F;
        steering[12].addShapeBox(0F, -5F, 4F, 1, 3, 1, 0F, 0F, -1F, 2F, 0F, -1F, 2F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 342
        steering[12].setRotationPoint(88F, -25F, 19F);
        steering[12].rotateAngleZ = -1.29154365F;
        this.add("steering", steering);
        //translateAll(0F, 0F, 0F);
        flipAll();
    }

}
