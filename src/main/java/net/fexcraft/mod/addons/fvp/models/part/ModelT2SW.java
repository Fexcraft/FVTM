//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2016 Minecraft-SMP.de
// This file is for Fex's Vehicle Mod
// Model: T2 (Steering Wheel)
// Model Creator: FEX___96
package net.fexcraft.mod.addons.fvp.models.part;

import net.fexcraft.mod.fvtm.model.part.PartModelTMT;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelT2SW extends PartModelTMT {

    public ModelT2SW(){
    	super(); textureX = 512; textureY = 512;
        addToCreators("01e4af9b-2a30-471e-addf-f6338ffce04b");
        steering = new ModelRendererTurbo[13];
        steering[0] = new ModelRendererTurbo(this, 153, 49, textureX, textureY); // Box 263
        steering[1] = new ModelRendererTurbo(this, 449, 89, textureX, textureY); // Box 264
        steering[2] = new ModelRendererTurbo(this, 57, 1, textureX, textureY); // Box 265
        steering[3] = new ModelRendererTurbo(this, 385, 1, textureX, textureY); // Box 266
        steering[4] = new ModelRendererTurbo(this, 273, 49, textureX, textureY); // Box 267
        steering[5] = new ModelRendererTurbo(this, 257, 65, textureX, textureY); // Box 268
        steering[6] = new ModelRendererTurbo(this, 65, 41, textureX, textureY); // Box 269
        steering[7] = new ModelRendererTurbo(this, 169, 49, textureX, textureY); // Box 270
        steering[8] = new ModelRendererTurbo(this, 497, 65, textureX, textureY); // Box 271
        steering[9] = new ModelRendererTurbo(this, 105, 73, textureX, textureY); // Box 272
        steering[10] = new ModelRendererTurbo(this, 401, 1, textureX, textureY); // Box 273
        steering[11] = new ModelRendererTurbo(this, 505, 1, textureX, textureY); // Box 274
        steering[12] = new ModelRendererTurbo(this, 489, 89, textureX, textureY); // Box 275

        steering[0].addBox(-2F, -1F, -1F, 3, 2, 2, 0F); // Box 263
        steering[0].setRotationPoint(56F, -31.5F, 12F);
        steering[0].rotateAngleZ = -1.04719755F;

        steering[1].addShapeBox(-3F, -2F, -4F, 1, 2, 8, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F); // Box 264
        steering[1].setRotationPoint(56F, -31.5F, 12F);
        steering[1].rotateAngleZ = -1.04719755F;

        steering[2].addBox(-2.75F, -2F, -5F, 1, 4, 1, 0F); // Box 265
        steering[2].setRotationPoint(56F, -31.5F, 12F);
        steering[2].rotateAngleZ = -1.04719755F;

        steering[3].addBox(-2.75F, -2F, 4F, 1, 4, 1, 0F); // Box 266
        steering[3].setRotationPoint(56F, -31.5F, 12F);
        steering[3].rotateAngleZ = -1.04719755F;

        steering[4].addBox(-2.75F, 4F, -2F, 1, 1, 4, 0F); // Box 267
        steering[4].setRotationPoint(56F, -31.5F, 12F);
        steering[4].rotateAngleZ = -1.04719755F;

        steering[5].addBox(-2.75F, -5F, -2F, 1, 1, 4, 0F); // Box 268
        steering[5].setRotationPoint(56F, -31.5F, 12F);
        steering[5].rotateAngleZ = -1.04719755F;

        steering[6].addShapeBox(-2.75F, -5F, -5F, 1, 1, 3, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, -1F, 0F, 2F, -1F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 269
        steering[6].setRotationPoint(56F, -31.5F, 12F);
        steering[6].rotateAngleZ = -1.04719755F;

        steering[7].addShapeBox(-2.75F, 4F, -5F, 1, 1, 3, 0F, 0F, 2F, -1F, 0F, 2F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 270
        steering[7].setRotationPoint(56F, -31.5F, 12F);
        steering[7].rotateAngleZ = -1.04719755F;

        steering[8].addShapeBox(-2.75F, 4F, 2F, 1, 1, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, -1F, 0F, 2F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F); // Box 271
        steering[8].setRotationPoint(56F, -31.5F, 12F);
        steering[8].rotateAngleZ = -1.04719755F;

        steering[9].addShapeBox(-2.75F, -5F, 2F, 1, 1, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, -1F, 0F, 2F, -1F); // Box 272
        steering[9].setRotationPoint(56F, -31.5F, 12F);
        steering[9].rotateAngleZ = -1.04719755F;

        steering[10].addShapeBox(-3F, 1F, -1.5F, 1, 3, 1, 0F, -0.6F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.6F, 0F, 0F, -0.5F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, -0.5F, 0F, -1F); // Box 273
        steering[10].setRotationPoint(56F, -31.5F, 12F);
        steering[10].rotateAngleZ = -1.04719755F;

        steering[11].addShapeBox(-3F, 1F, 0.5F, 1, 3, 1, 0F, -0.6F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.6F, 0F, 0F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, -0.5F, 0F, 1F); // Box 274
        steering[11].setRotationPoint(56F, -31.5F, 12F);
        steering[11].rotateAngleZ = -1.04719755F;

        steering[12].addShapeBox(-3F, 0F, -4F, 1, 2, 8, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, -2.5F, 0F, 0F, -2.5F, 0F, 0F, -2.5F, -0.5F, 0F, -2.5F); // Box 275
        steering[12].setRotationPoint(56F, -31.5F, 12F);
        steering[12].rotateAngleZ = -1.04719755F;

        //translateAll(0F, 0F, 0F);
        flipAll();
    }

}
