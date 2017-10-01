//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2017 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: ConstructorController
// Model Creator: FEX___96 (Ferdinand Calo')
// Created on: 07.06.2017 - 18:47:56
// Last changed on: 07.06.2017 - 18:47:56

package net.fexcraft.mod.fvtm.model.block;

import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.lib.tmt.ModelConverter;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.minecraft.util.ResourceLocation;

public class ModelConstructorController extends ModelConverter {
	
	int textureX = 128;
	int textureY = 128;

	public ModelConstructorController(){
		bodyModel = new ModelRendererTurbo[29];
		bodyModel[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
		bodyModel[1] = new ModelRendererTurbo(this, 9, 1, textureX, textureY); // Box 1
		bodyModel[2] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 2
		bodyModel[3] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 3
		bodyModel[4] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 4
		bodyModel[5] = new ModelRendererTurbo(this, 1, 33, textureX, textureY); // Box 5
		bodyModel[6] = new ModelRendererTurbo(this, 89, 1, textureX, textureY); // Box 8
		bodyModel[7] = new ModelRendererTurbo(this, 65, 9, textureX, textureY); // Box 11
		bodyModel[8] = new ModelRendererTurbo(this, 1, 9, textureX, textureY); // Box 12
		bodyModel[9] = new ModelRendererTurbo(this, 81, 17, textureX, textureY); // Box 21
		bodyModel[10] = new ModelRendererTurbo(this, 57, 33, textureX, textureY); // Box 22
		bodyModel[11] = new ModelRendererTurbo(this, 89, 33, textureX, textureY); // Box 23
		bodyModel[12] = new ModelRendererTurbo(this, 113, 17, textureX, textureY); // Box 24
		bodyModel[13] = new ModelRendererTurbo(this, 73, 49, textureX, textureY); // Box 25
		bodyModel[14] = new ModelRendererTurbo(this, 1, 57, textureX, textureY); // Box 26
		bodyModel[15] = new ModelRendererTurbo(this, 33, 57, textureX, textureY); // Box 27
		bodyModel[16] = new ModelRendererTurbo(this, 65, 57, textureX, textureY); // Box 28
		bodyModel[17] = new ModelRendererTurbo(this, 1, 25, textureX, textureY); // Box 29
		bodyModel[18] = new ModelRendererTurbo(this, 9, 25, textureX, textureY); // Box 30
		bodyModel[19] = new ModelRendererTurbo(this, 121, 25, textureX, textureY); // Box 31
		bodyModel[20] = new ModelRendererTurbo(this, 1, 33, textureX, textureY); // Box 32
		bodyModel[21] = new ModelRendererTurbo(this, 9, 33, textureX, textureY); // Box 33
		bodyModel[22] = new ModelRendererTurbo(this, 121, 33, textureX, textureY); // Box 34
		bodyModel[23] = new ModelRendererTurbo(this, 1, 41, textureX, textureY); // Box 35
		bodyModel[24] = new ModelRendererTurbo(this, 9, 41, textureX, textureY); // Box 36
		bodyModel[25] = new ModelRendererTurbo(this, 97, 57, textureX, textureY); // Box 37
		bodyModel[26] = new ModelRendererTurbo(this, 1, 65, textureX, textureY); // Box 38
		bodyModel[27] = new ModelRendererTurbo(this, 33, 65, textureX, textureY); // Box 39
		bodyModel[28] = new ModelRendererTurbo(this, 65, 65, textureX, textureY); // Box 40

		bodyModel[0].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 0
		bodyModel[0].setRotationPoint(1F, -1F, 2F);

		bodyModel[1].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 1
		bodyModel[1].setRotationPoint(1F, -1F, 13F);

		bodyModel[2].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 2
		bodyModel[2].setRotationPoint(14F, -1F, 13F);

		bodyModel[3].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 3
		bodyModel[3].setRotationPoint(14F, -1F, 2F);

		bodyModel[4].addBox(0F, 0F, 0F, 15, 14, 14, 0F); // Box 4
		bodyModel[4].setRotationPoint(0.5F, -14.5F, 1.5F);

		bodyModel[5].addBox(0F, 0F, 0F, 16, 2, 16, 0F); // Box 5
		bodyModel[5].setRotationPoint(0F, -16F, 0F);

		bodyModel[6].addBox(0F, 0F, 0F, 2, 1, 5, 0F); // Box 8
		bodyModel[6].setRotationPoint(13F, -16.2F, 6F);

		bodyModel[7].addShapeBox(0F, 0F, 0F, 16, 1, 4, 0F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 11
		bodyModel[7].setRotationPoint(0F, -17F, 12F);

		bodyModel[8].addBox(0F, 0F, 0F, 10, 1, 2, 0F); // Box 12
		bodyModel[8].setRotationPoint(3F, -16.1F, 1F);
		bodyModel[8].rotateAngleY = -1.57079633F;

		bodyModel[9].addBox(0F, 0F, 0F, 8, 1, 8, 0F); // Box 21
		bodyModel[9].setRotationPoint(4F, -16.2F, 1F);

		bodyModel[10].addBox(0F, 0F, 0F, 14, 10, 1, 0F); // Box 22
		bodyModel[10].setRotationPoint(1F, -28F, 13F);

		bodyModel[11].addShapeBox(0F, 0F, 0F, 14, 10, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -5F, 0F, -1F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -2F, 0F, -1F, -2F, 0F); // Box 23
		bodyModel[11].setRotationPoint(1F, -28F, 14F);

		bodyModel[12].addBox(0F, 0F, 0F, 4, 3, 1, 0F); // Box 24
		bodyModel[12].setRotationPoint(6F, -20F, 14F);

		bodyModel[13].addBox(0F, 0F, 0F, 14, 3, 1, 0F); // Box 25
		bodyModel[13].setRotationPoint(1F, -4F, 1F);

		bodyModel[14].addBox(0F, 0F, 0F, 14, 3, 1, 0F); // Box 26
		bodyModel[14].setRotationPoint(1F, -7.5F, 1F);

		bodyModel[15].addBox(0F, 0F, 0F, 14, 3, 1, 0F); // Box 27
		bodyModel[15].setRotationPoint(1F, -11F, 1F);

		bodyModel[16].addBox(0F, 0F, 0F, 14, 2, 1, 0F); // Box 28
		bodyModel[16].setRotationPoint(1F, -13.5F, 1F);

		bodyModel[17].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F); // Box 29
		bodyModel[17].setRotationPoint(2F, -3F, 0.5F);

		bodyModel[18].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F); // Box 30
		bodyModel[18].setRotationPoint(13F, -3F, 0.5F);

		bodyModel[19].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F); // Box 31
		bodyModel[19].setRotationPoint(13F, -10F, 0.5F);

		bodyModel[20].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F); // Box 32
		bodyModel[20].setRotationPoint(2F, -10F, 0.5F);

		bodyModel[21].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F); // Box 33
		bodyModel[21].setRotationPoint(2F, -6.5F, 0.5F);

		bodyModel[22].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F); // Box 34
		bodyModel[22].setRotationPoint(13F, -6.5F, 0.5F);

		bodyModel[23].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F); // Box 35
		bodyModel[23].setRotationPoint(13F, -13F, 0.5F);

		bodyModel[24].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F); // Box 36
		bodyModel[24].setRotationPoint(2F, -13F, 0.5F);

		bodyModel[25].addShapeBox(0F, 0F, 0F, 13, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F); // Box 37
		bodyModel[25].setRotationPoint(1.5F, -3F, 0.3F);

		bodyModel[26].addShapeBox(0F, 0F, 0F, 13, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F); // Box 38
		bodyModel[26].setRotationPoint(1.5F, -6.5F, 0.3F);

		bodyModel[27].addShapeBox(0F, 0F, 0F, 13, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F); // Box 39
		bodyModel[27].setRotationPoint(1.5F, -10F, 0.3F);

		bodyModel[28].addShapeBox(0F, 0F, 0F, 13, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F); // Box 40
		bodyModel[28].setRotationPoint(1.5F, -13F, 0.3F);


		turretModel = new ModelRendererTurbo[10];
		turretModel[0] = new ModelRendererTurbo(this, 65, 1, textureX, textureY); // SpawnItem
		turretModel[1] = new ModelRendererTurbo(this, 81, 1, textureX, textureY); // SpawnEntity
		turretModel[2] = new ModelRendererTurbo(this, 121, 1, textureX, textureY); // Remove
		turretModel[3] = new ModelRendererTurbo(this, 25, 9, textureX, textureY); // Select
		turretModel[4] = new ModelRendererTurbo(this, 105, 9, textureX, textureY); // Down
		turretModel[5] = new ModelRendererTurbo(this, 113, 9, textureX, textureY); // Up
		turretModel[6] = new ModelRendererTurbo(this, 121, 9, textureX, textureY); // Right
		turretModel[7] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Left
		turretModel[8] = new ModelRendererTurbo(this, 9, 17, textureX, textureY); // Back
		turretModel[9] = new ModelRendererTurbo(this, 81, 17, textureX, textureY); // Home

		turretModel[0].addBox(0F, 0F, 0F, 2, 1, 2, 0F); // SpawnItem
		turretModel[0].setRotationPoint(13F, -16.2F, 1F);

		turretModel[1].addBox(0F, 0F, 0F, 2, 1, 2, 0F); // SpawnEntity
		turretModel[1].setRotationPoint(13F, -16.2F, 3F);

		turretModel[2].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F); // Remove
		turretModel[2].setRotationPoint(11F, -16.2F, 10F);

		turretModel[3].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F); // Select
		turretModel[3].setRotationPoint(10F, -16.2F, 10F);

		turretModel[4].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F); // Down
		turretModel[4].setRotationPoint(9F, -16.2F, 10F);

		turretModel[5].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F); // Up
		turretModel[5].setRotationPoint(8F, -16.2F, 10F);

		turretModel[6].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F); // Right
		turretModel[6].setRotationPoint(7F, -16.2F, 10F);

		turretModel[7].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F); // Left
		turretModel[7].setRotationPoint(6F, -16.2F, 10F);

		turretModel[8].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F); // Back
		turretModel[8].setRotationPoint(5F, -16.2F, 10F);

		turretModel[9].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.1F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F); // Home
		turretModel[9].setRotationPoint(4F, -16.2F, 10F);


		steeringWheelModel = new ModelRendererTurbo[2];
		steeringWheelModel[0] = new ModelRendererTurbo(this, 105, 1, textureX, textureY); // LeverHead
		steeringWheelModel[1] = new ModelRendererTurbo(this, 113, 1, textureX, textureY); // Lever

		steeringWheelModel[0].addShapeBox(0F, -2.7F, -0.5F, 2, 1, 1, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // LeverHead
		steeringWheelModel[0].setRotationPoint(13F, -16F, 8.5F);

		steeringWheelModel[1].addShapeBox(0F, -2F, -0.5F, 2, 2, 1, 0F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F, -0.4F, 0F, -0.4F); // Lever
		steeringWheelModel[1].setRotationPoint(13F, -16F, 8.5F);
		
		//translateAll(0F, 0F, 0F);
		
	}
	
	private static final ResourceLocation texture = new ResourceLocation(FVTM.MODID, "textures/blocks/constructorcontroller.png");
	
	public static final ResourceLocation getTexture(){
		return texture;
	}
	
}