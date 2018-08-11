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

public class ModelC1R1ST extends PartModelTMT {

    public ModelC1R1ST(){
    	super(); textureX = 512; textureY = 512;
        this.addToCreators("01e4af9b-2a30-471e-addf-f6338ffce04b");
        steering = new ModelRendererTurbo[18];
        steering[0] = new ModelRendererTurbo(this, 177, 113, textureX, textureY); // Box 711
        steering[1] = new ModelRendererTurbo(this, 217, 113, textureX, textureY); // Box 712
        steering[2] = new ModelRendererTurbo(this, 121, 121, textureX, textureY); // Box 713
        steering[3] = new ModelRendererTurbo(this, 281, 41, textureX, textureY); // Box 714
        steering[4] = new ModelRendererTurbo(this, 345, 41, textureX, textureY); // Box 715
        steering[5] = new ModelRendererTurbo(this, 249, 177, textureX, textureY); // Box 719
        steering[6] = new ModelRendererTurbo(this, 73, 185, textureX, textureY); // Box 721
        steering[7] = new ModelRendererTurbo(this, 385, 193, textureX, textureY); // Box 754
        steering[8] = new ModelRendererTurbo(this, 345, 81, textureX, textureY); // Box 755
        steering[9] = new ModelRendererTurbo(this, 297, 97, textureX, textureY); // Box 756
        steering[10] = new ModelRendererTurbo(this, 41, 201, textureX, textureY); // Box 757
        steering[11] = new ModelRendererTurbo(this, 57, 201, textureX, textureY); // Box 758
        steering[12] = new ModelRendererTurbo(this, 73, 201, textureX, textureY); // Box 759
        steering[13] = new ModelRendererTurbo(this, 121, 113, textureX, textureY); // Box 760
        steering[14] = new ModelRendererTurbo(this, 81, 129, textureX, textureY); // Box 761
        steering[15] = new ModelRendererTurbo(this, 209, 201, textureX, textureY); // Box 762
        steering[16] = new ModelRendererTurbo(this, 345, 201, textureX, textureY); // Box 763
        steering[17] = new ModelRendererTurbo(this, 1, 209, textureX, textureY); // Box 764

        steering[0].addBox(-1F, -1F, -1F, 1, 2, 2, 0F); // Box 711
        steering[0].setRotationPoint(15F, -14F, 11F);
        steering[0].rotateAngleX = -0.03490659F;
        steering[0].rotateAngleZ = -0.26179939F;

        steering[1].addBox(-1F, 3F, -1F, 1, 1, 2, 0F); // Box 712
        steering[1].setRotationPoint(15F, -14F, 11F);
        steering[1].rotateAngleX = -0.03490659F;
        steering[1].rotateAngleZ = -0.26179939F;

        steering[2].addBox(-1F, -4F, -1F, 1, 1, 2, 0F); // Box 713
        steering[2].setRotationPoint(15F, -14F, 11F);
        steering[2].rotateAngleX = -0.03490659F;
        steering[2].rotateAngleZ = -0.26179939F;

        steering[3].addBox(-1F, -1F, 3F, 1, 2, 1, 0F); // Box 714
        steering[3].setRotationPoint(15F, -14F, 11F);
        steering[3].rotateAngleX = -0.03490659F;
        steering[3].rotateAngleZ = -0.26179939F;

        steering[4].addBox(-1F, -1F, -4F, 1, 2, 1, 0F); // Box 715
        steering[4].setRotationPoint(15F, -14F, 11F);
        steering[4].rotateAngleX = -0.03490659F;
        steering[4].rotateAngleZ = -0.26179939F;

        steering[5].addShapeBox(-1F, 3F, 1F, 1, 1, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -2F, 0F, 1F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F); // Box 719
        steering[5].setRotationPoint(15F, -14F, 11F);
        steering[5].rotateAngleX = -0.03490659F;
        steering[5].rotateAngleZ = -0.26179939F;

        steering[6].addShapeBox(-1F, 2F, -0.5F, 1, 1, 3, 0F, -0.1F, 2F, -1F, -0.1F, 2F, -1F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, -3F, 0F, -0.1F, -3F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F); // Box 721
        steering[6].setRotationPoint(15F, -14F, 11F);
        steering[6].rotateAngleX = -0.03490659F;
        steering[6].rotateAngleZ = -0.26179939F;

        steering[7].addShapeBox(-1F, 3F, 1F, 1, 1, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -2F, 0F, 1F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F); // Box 754
        steering[7].setRotationPoint(15F, -14F, 11F);
        steering[7].rotateAngleX = -0.03490659F;
        steering[7].rotateAngleZ = -0.26179939F;

        steering[8].addShapeBox(-1F, 1F, 3F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 1F, 0F, -2F, 1F, 0F, -1F, -1F, 0F, -1F, -1F); // Box 755
        steering[8].setRotationPoint(15F, -14F, 11F);
        steering[8].rotateAngleX = -0.03490659F;
        steering[8].rotateAngleZ = -0.26179939F;

        steering[9].addShapeBox(-1F, -4F, 3F, 1, 3, 1, 0F, 0F, -2F, 1F, 0F, -2F, 1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 756
        steering[9].setRotationPoint(15F, -14F, 11F);
        steering[9].rotateAngleX = -0.03490659F;
        steering[9].rotateAngleZ = -0.26179939F;

        steering[10].addShapeBox(-1F, -4F, 1F, 1, 1, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -2F, 0F, 1F, -2F); // Box 757
        steering[10].setRotationPoint(15F, -14F, 11F);
        steering[10].rotateAngleX = -0.03490659F;
        steering[10].rotateAngleZ = -0.26179939F;

        steering[11].addShapeBox(-1F, -4F, -4F, 1, 1, 3, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -2F, 0F, 1F, -2F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 758
        steering[11].setRotationPoint(15F, -14F, 11F);
        steering[11].rotateAngleX = -0.03490659F;
        steering[11].rotateAngleZ = -0.26179939F;

        steering[12].addShapeBox(-1F, 3F, -4F, 1, 1, 3, 0F, 0F, 1F, -2F, 0F, 1F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 759
        steering[12].setRotationPoint(15F, -14F, 11F);
        steering[12].rotateAngleX = -0.03490659F;
        steering[12].rotateAngleZ = -0.26179939F;

        steering[13].addShapeBox(-1F, -4F, -4F, 1, 3, 1, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -2F, 1F, 0F, -2F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 760
        steering[13].setRotationPoint(15F, -14F, 11F);
        steering[13].rotateAngleX = -0.03490659F;
        steering[13].rotateAngleZ = -0.26179939F;

        steering[14].addShapeBox(-1F, 1F, -4F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -2F, 1F, 0F, -2F, 1F); // Box 761
        steering[14].setRotationPoint(15F, -14F, 11F);
        steering[14].rotateAngleX = -0.03490659F;
        steering[14].rotateAngleZ = -0.26179939F;

        steering[15].addShapeBox(-1F, -3F, -2.5F, 1, 1, 3, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, -3F, 0F, -0.1F, -3F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 2F, -1F, -0.1F, 2F, -1F); // Box 762
        steering[15].setRotationPoint(15F, -14F, 11F);
        steering[15].rotateAngleX = -0.03490659F;
        steering[15].rotateAngleZ = -0.26179939F;

        steering[16].addShapeBox(-1F, -3F, -0.5F, 1, 1, 3, 0F, -0.1F, -3F, 0F, -0.1F, -3F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 2F, -1F, -0.1F, 2F, -1F, -0.1F, 0F, 0F, -0.1F, 0F, 0F); // Box 763
        steering[16].setRotationPoint(15F, -14F, 11F);
        steering[16].rotateAngleX = -0.03490659F;
        steering[16].rotateAngleZ = -0.26179939F;

        steering[17].addShapeBox(-1F, 2F, -2.5F, 1, 1, 3, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 2F, -1F, -0.1F, 2F, -1F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, -3F, 0F, -0.1F, -3F, 0F); // Box 764
        steering[17].setRotationPoint(15F, -14F, 11F);
        steering[17].rotateAngleX = -0.03490659F;
        steering[17].rotateAngleZ = -0.26179939F;

        translateAll(0F, 0F, 0F);
        flipAll();
    }

}
