//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2018 Minecraft-SMP.de
// This file is for Fex's Vehicle & Transportation Mod

// Model: C1_R1
// Model Creator: FEX___96
// Created on: 22.08.2016 - 20:40:40
// Last changed on: 04.04.2018

package net.fexcraft.mod.addons.fvp.models.part;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.part.PartModel;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelC1R1FS extends PartModel<VehicleData>{
	
	int textureX = 512;
	int textureY = 512;

	public ModelC1R1FS(){
		this.creators.add("01e4af9b-2a30-471e-addf-f6338ffce04b");
		body = new ModelRendererTurbo[22];
		body[0] = new ModelRendererTurbo(this, 329, 289, textureX, textureY); // Box 677
		body[1] = new ModelRendererTurbo(this, 481, 217, textureX, textureY); // Box 679
		body[2] = new ModelRendererTurbo(this, 481, 225, textureX, textureY); // Box 680
		body[3] = new ModelRendererTurbo(this, 433, 289, textureX, textureY); // Box 681
		body[4] = new ModelRendererTurbo(this, 57, 113, textureX, textureY); // Box 682
		body[5] = new ModelRendererTurbo(this, 305, 9, textureX, textureY); // Box 683
		body[6] = new ModelRendererTurbo(this, 441, 9, textureX, textureY); // Box 684
		body[7] = new ModelRendererTurbo(this, 369, 209, textureX, textureY); // Box 685
		body[8] = new ModelRendererTurbo(this, 433, 161, textureX, textureY); // Box 689
		body[9] = new ModelRendererTurbo(this, 89, 177, textureX, textureY); // Box 690
		body[10] = new ModelRendererTurbo(this, 457, 289, textureX, textureY); // Box 691
		body[11] = new ModelRendererTurbo(this, 193, 265, textureX, textureY); // Box 693
		body[12] = new ModelRendererTurbo(this, 473, 169, textureX, textureY); // Box 694
		body[13] = new ModelRendererTurbo(this, 481, 265, textureX, textureY); // Box 695
		body[14] = new ModelRendererTurbo(this, 233, 297, textureX, textureY); // Box 696
		body[15] = new ModelRendererTurbo(this, 369, 297, textureX, textureY); // Box 697
		body[16] = new ModelRendererTurbo(this, 393, 177, textureX, textureY); // Box 698
		body[17] = new ModelRendererTurbo(this, 185, 185, textureX, textureY); // Box 699
		body[18] = new ModelRendererTurbo(this, 73, 297, textureX, textureY); // Box 700
		body[19] = new ModelRendererTurbo(this, 457, 9, textureX, textureY); // Box 701
		body[20] = new ModelRendererTurbo(this, 473, 9, textureX, textureY); // Box 702
		body[21] = new ModelRendererTurbo(this, 425, 209, textureX, textureY); // Box 703

		body[0].addBox(0F, 0F, 0F, 12, 1, 12, 0F); // Box 677
		body[0].setRotationPoint(0F, -4F, 4F);

		body[1].addShapeBox(0F, 0F, 0F, 12, 1, 2, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 679
		body[1].setRotationPoint(0F, -4F, 2F);

		body[2].addShapeBox(0F, 0F, 0F, 12, 1, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 680
		body[2].setRotationPoint(0F, -4F, 16F);

		body[3].addShapeBox(-0.5F, -16F, -7F, 2, 16, 14, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F); // Box 681
		body[3].setRotationPoint(-1F, -4F, 10F);
		body[3].rotateAngleZ = 0.17453293F;

		body[4].addShapeBox(0F, 0F, 0F, 1, 1, 12, 0F, 0F, 0F, 0F, -0.05F, 0.2F, 0F, -0.05F, 0.2F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -1F, 0F, 0F); // Box 682
		body[4].setRotationPoint(-1F, -4F, 4F);

		body[5].addShapeBox(0F, -18F, -3F, 1, 2, 1, 0F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 683
		body[5].setRotationPoint(-1F, -4F, 10F);
		body[5].rotateAngleZ = 0.17453293F;

		body[6].addShapeBox(0F, -18F, 2F, 1, 2, 1, 0F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 684
		body[6].setRotationPoint(-1F, -4F, 10F);
		body[6].rotateAngleZ = 0.17453293F;

		body[7].addShapeBox(-0.5F, -20.5F, -3.5F, 2, 3, 7, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 685
		body[7].setRotationPoint(-1F, -4F, 10F);
		body[7].rotateAngleZ = 0.17453293F;

		body[8].addBox(0F, 0F, -4F, 8, 2, 1, 0F); // Box 689
		body[8].setRotationPoint(2F, -2F, 10F);

		body[9].addBox(0F, 0F, 3F, 8, 2, 1, 0F); // Box 690
		body[9].setRotationPoint(2F, -2F, 10F);

		body[10].addShapeBox(0F, 0F, 0F, 11, 1, 11, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F); // Box 691
		body[10].setRotationPoint(0.5F, -3F, 4.5F);

		body[11].addShapeBox(0F, 0F, 0F, 12, 1, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 693
		body[11].setRotationPoint(0F, -4F, -4F);

		body[12].addShapeBox(0F, 0F, 0F, 1, 1, 12, 0F, 0F, 0F, 0F, -0.05F, 0.2F, 0F, -0.05F, 0.2F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -1F, 0F, 0F); // Box 694
		body[12].setRotationPoint(-1F, -4F, -16F);

		body[13].addShapeBox(0F, 0F, 0F, 12, 1, 2, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 695
		body[13].setRotationPoint(0F, -4F, -18F);

		body[14].addBox(0F, 0F, 0F, 12, 1, 12, 0F); // Box 696
		body[14].setRotationPoint(0F, -4F, -16F);

		body[15].addShapeBox(0F, 0F, 0F, 11, 1, 11, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F); // Box 697
		body[15].setRotationPoint(0.5F, -3F, -15.5F);

		body[16].addBox(0F, 0F, -4F, 8, 2, 1, 0F); // Box 698
		body[16].setRotationPoint(2F, -2F, -10F);

		body[17].addBox(0F, 0F, 3F, 8, 2, 1, 0F); // Box 699
		body[17].setRotationPoint(2F, -2F, -10F);

		body[18].addShapeBox(-0.5F, -16F, -7F, 2, 16, 14, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F); // Box 700
		body[18].setRotationPoint(-1F, -4F, -10F);
		body[18].rotateAngleZ = 0.17453293F;

		body[19].addShapeBox(0F, -18F, -3F, 1, 2, 1, 0F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 701
		body[19].setRotationPoint(-1F, -4F, -10F);
		body[19].rotateAngleZ = 0.17453293F;

		body[20].addShapeBox(0F, -18F, 2F, 1, 2, 1, 0F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 702
		body[20].setRotationPoint(-1F, -4F, -10F);
		body[20].rotateAngleZ = 0.17453293F;

		body[21].addShapeBox(-0.5F, -20.5F, -3.5F, 2, 3, 7, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 703
		body[21].setRotationPoint(-1F, -4F, -10F);
		body[21].rotateAngleZ = 0.17453293F;

		translateAll(0F, 0F, 0F);
		flipAll();
	}
	
}
