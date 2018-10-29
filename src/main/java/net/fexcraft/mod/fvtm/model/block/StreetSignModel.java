//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2018 Minecraft-SMP.de
// Model Creator: FEX___96
// Created on: 20.06.2018 - 14:36:42
// Last changed on: 20.06.2018 - 14:36:42

package net.fexcraft.mod.fvtm.model.block;

import net.fexcraft.lib.tmt.ModelConverter;
import net.fexcraft.lib.tmt.ModelRendererTurbo;

public class StreetSignModel extends ModelConverter {
	
	int textureX = 64;
	int textureY = 128;

	public StreetSignModel(){
		bodyModel = new ModelRendererTurbo[12];
		bodyModel[0] = new ModelRendererTurbo(this, 49, 1, textureX, textureY); // Box 5
		bodyModel[1] = new ModelRendererTurbo(this, 41, 1, textureX, textureY); // Box 6
		bodyModel[2] = new ModelRendererTurbo(this, 57, 1, textureX, textureY); // Box 7
		bodyModel[3] = new ModelRendererTurbo(this, 41, 9, textureX, textureY); // Box 8
		bodyModel[4] = new ModelRendererTurbo(this, 49, 9, textureX, textureY); // Box 9
		bodyModel[5] = new ModelRendererTurbo(this, 57, 9, textureX, textureY); // Box 10
		bodyModel[6] = new ModelRendererTurbo(this, 41, 17, textureX, textureY); // Box 11
		bodyModel[7] = new ModelRendererTurbo(this, 49, 17, textureX, textureY); // Box 12
		bodyModel[8] = new ModelRendererTurbo(this, 57, 17, textureX, textureY); // Box 13
		bodyModel[9] = new ModelRendererTurbo(this, 41, 25, textureX, textureY); // Box 14
		bodyModel[10] = new ModelRendererTurbo(this, 49, 25, textureX, textureY); // Box 15
		bodyModel[11] = new ModelRendererTurbo(this, 57, 25, textureX, textureY); // Box 16

		bodyModel[0].addShapeBox(0F, 0F, 0F, 2, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 5
		bodyModel[0].setRotationPoint(-7F, -16F, -3F);

		bodyModel[1].addShapeBox(0F, 0F, 0F, 2, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 6
		bodyModel[1].setRotationPoint(-7F, -12F, -3F);

		bodyModel[2].addShapeBox(0F, 0F, 0F, 2, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 7
		bodyModel[2].setRotationPoint(-7F, -6F, -3F);

		bodyModel[3].addShapeBox(0F, 0F, 0F, 2, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F); // Box 8
		bodyModel[3].setRotationPoint(-7F, -4F, -3F);

		bodyModel[4].addShapeBox(0F, 0F, 0F, 2, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 9
		bodyModel[4].setRotationPoint(5F, -16F, -3F);

		bodyModel[5].addShapeBox(0F, 0F, 0F, 2, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 10
		bodyModel[5].setRotationPoint(5F, -12F, -3F);

		bodyModel[6].addShapeBox(0F, 0F, 0F, 2, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 11
		bodyModel[6].setRotationPoint(5F, -6F, -3F);

		bodyModel[7].addShapeBox(0F, 0F, 0F, 2, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F); // Box 12
		bodyModel[7].setRotationPoint(5F, -4F, -3F);

		bodyModel[8].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // Box 13
		bodyModel[8].setRotationPoint(-7F, -10F, -3F);

		bodyModel[9].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // Box 14
		bodyModel[9].setRotationPoint(-7F, -8F, -3F);

		bodyModel[10].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // Box 15
		bodyModel[10].setRotationPoint(5F, -10F, -3F);

		bodyModel[11].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // Box 16
		bodyModel[11].setRotationPoint(5F, -8F, -3F);


		turretModel = new ModelRendererTurbo[4];
		turretModel[0] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 1
		turretModel[1] = new ModelRendererTurbo(this, 1, 25, textureX, textureY); // Box 2
		turretModel[2] = new ModelRendererTurbo(this, 1, 33, textureX, textureY); // Box 3
		turretModel[3] = new ModelRendererTurbo(this, 1, 41, textureX, textureY); // Box 4

		turretModel[0].addShapeBox(0F, 0F, 0F, 16, 4, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 1
		turretModel[0].setRotationPoint(-8F, -16F, -4F);

		turretModel[1].addShapeBox(0F, 0F, 0F, 16, 4, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 2
		turretModel[1].setRotationPoint(-8F, -12F, -4F);

		turretModel[2].addShapeBox(0F, 0F, 0F, 16, 4, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 3
		turretModel[2].setRotationPoint(-8F, -8F, -4F);

		turretModel[3].addShapeBox(0F, 0F, 0F, 16, 4, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 4
		turretModel[3].setRotationPoint(-8F, -4F, -4F);


		leftFrontWheelModel = new ModelRendererTurbo[2];
		leftFrontWheelModel[0] = new ModelRendererTurbo(this, 1, 49, textureX, textureY); // Box 17
		leftFrontWheelModel[1] = new ModelRendererTurbo(this, 1, 57, textureX, textureY); // Box 18

		leftFrontWheelModel[0].addShapeBox(0F, 0F, 0F, 16, 2, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 17
		leftFrontWheelModel[0].setRotationPoint(-8F, -18F, -4F);

		leftFrontWheelModel[1].addShapeBox(0F, 0F, 0F, 16, 2, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 18
		leftFrontWheelModel[1].setRotationPoint(-8F, 0F, -4F);


		rightFrontWheelModel = new ModelRendererTurbo[8];
		rightFrontWheelModel[0] = new ModelRendererTurbo(this, 57, 49, textureX, textureY); // Box 27
		rightFrontWheelModel[1] = new ModelRendererTurbo(this, 41, 57, textureX, textureY); // Box 28
		rightFrontWheelModel[2] = new ModelRendererTurbo(this, 49, 57, textureX, textureY); // Box 29
		rightFrontWheelModel[3] = new ModelRendererTurbo(this, 57, 57, textureX, textureY); // Box 30
		rightFrontWheelModel[4] = new ModelRendererTurbo(this, 1, 65, textureX, textureY); // Box 31
		rightFrontWheelModel[5] = new ModelRendererTurbo(this, 9, 65, textureX, textureY); // Box 32
		rightFrontWheelModel[6] = new ModelRendererTurbo(this, 17, 65, textureX, textureY); // Box 33
		rightFrontWheelModel[7] = new ModelRendererTurbo(this, 25, 65, textureX, textureY); // Box 34

		rightFrontWheelModel[0].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, -0.95F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, -0.95F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 27
		rightFrontWheelModel[0].setRotationPoint(-9F, -17F, -4F);

		rightFrontWheelModel[1].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, -2F, 0F, -0.5F, 1F, -1F, -0.5F, 1F, -1F, 0F, -2F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 28
		rightFrontWheelModel[1].setRotationPoint(-10F, -18F, -4F);

		rightFrontWheelModel[2].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 1F, -1F, -0.5F, -2F, 0F, -0.5F, -2F, 0F, 0F, 1F, -1F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 29
		rightFrontWheelModel[2].setRotationPoint(9F, -18F, -4F);

		rightFrontWheelModel[3].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, -0.5F, 0F, -0.95F, -0.5F, 0F, -0.95F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 30
		rightFrontWheelModel[3].setRotationPoint(8F, -17F, -4F);

		rightFrontWheelModel[4].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.95F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, -0.95F, 0F); // Box 31
		rightFrontWheelModel[4].setRotationPoint(-9F, 0F, -4F);

		rightFrontWheelModel[5].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, -0.5F, 1F, -1F, -0.5F, 1F, -1F, 0F, -2F, 0F, 0F); // Box 32
		rightFrontWheelModel[5].setRotationPoint(-10F, 0F, -4F);

		rightFrontWheelModel[6].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -1F, -0.5F, -2F, 0F, -0.5F, -2F, 0F, 0F, 1F, -1F, 0F); // Box 33
		rightFrontWheelModel[6].setRotationPoint(9F, 0F, -4F);

		rightFrontWheelModel[7].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, -0.95F, -0.5F, 0F, -0.95F, 0F, 0F, 0F, 0F); // Box 34
		rightFrontWheelModel[7].setRotationPoint(8F, 0F, -4F);


		frontWheelModel = new ModelRendererTurbo[4];
		frontWheelModel[0] = new ModelRendererTurbo(this, 41, 33, textureX, textureY); // Box 19
		frontWheelModel[1] = new ModelRendererTurbo(this, 49, 33, textureX, textureY); // Box 20
		frontWheelModel[2] = new ModelRendererTurbo(this, 57, 33, textureX, textureY); // Box 21
		frontWheelModel[3] = new ModelRendererTurbo(this, 41, 41, textureX, textureY); // Box 22

		frontWheelModel[0].addShapeBox(0F, 0F, 0F, 2, 4, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 19
		frontWheelModel[0].setRotationPoint(-10F, -16F, -4F);

		frontWheelModel[1].addShapeBox(0F, 0F, 0F, 2, 4, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 20
		frontWheelModel[1].setRotationPoint(-10F, -12F, -4F);

		frontWheelModel[2].addShapeBox(0F, 0F, 0F, 2, 4, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 21
		frontWheelModel[2].setRotationPoint(-10F, -8F, -4F);

		frontWheelModel[3].addShapeBox(0F, 0F, 0F, 2, 4, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 22
		frontWheelModel[3].setRotationPoint(-10F, -4F, -4F);


		backWheelModel = new ModelRendererTurbo[4];
		backWheelModel[0] = new ModelRendererTurbo(this, 49, 41, textureX, textureY); // Box 23
		backWheelModel[1] = new ModelRendererTurbo(this, 57, 41, textureX, textureY); // Box 24
		backWheelModel[2] = new ModelRendererTurbo(this, 41, 49, textureX, textureY); // Box 25
		backWheelModel[3] = new ModelRendererTurbo(this, 49, 49, textureX, textureY); // Box 26

		backWheelModel[0].addShapeBox(0F, 0F, 0F, 2, 4, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 23
		backWheelModel[0].setRotationPoint(8F, -16F, -4F);

		backWheelModel[1].addShapeBox(0F, 0F, 0F, 2, 4, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 24
		backWheelModel[1].setRotationPoint(8F, -12F, -4F);

		backWheelModel[2].addShapeBox(0F, 0F, 0F, 2, 4, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 25
		backWheelModel[2].setRotationPoint(8F, -8F, -4F);

		backWheelModel[3].addShapeBox(0F, 0F, 0F, 2, 4, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 26
		backWheelModel[3].setRotationPoint(8F, -4F, -4F);

		translateAll(0F, 16F, 0F);
		flipAll();
	}
	
}