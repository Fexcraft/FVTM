//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2017 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: C2
// Model Creator: 
// Created on: 24.08.2015 - 16:52:34
// Last changed on: 24.08.2015 - 16:52:34

package net.fexcraft.mod.addons.fvp.models.part;

import net.fexcraft.mod.fvtm.model.part.PartModel;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelC2ST extends PartModel {
	
	int textureX = 512;
	int textureY = 512;

	public ModelC2ST(){
		this.creators.add("Ferdinand (FEX___96)");
		steering = new ModelRendererTurbo[1];
		steering[0] = new ModelRendererTurbo(this, 425, 81, textureX, textureY); // Box 94

		steering[0].addBox(0F, -3F, -3F, 1, 7, 7, 0F); // Box 94
		steering[0].setRotationPoint(5F, -26F, 13F);
		steering[0].rotateAngleZ = 0.26179939F;


		body = new ModelRendererTurbo[4];
		body[0] = new ModelRendererTurbo(this, 353, 73, textureX, textureY); // Box 81
		body[1] = new ModelRendererTurbo(this, 257, 1, textureX, textureY); // Box 93
		body[2] = new ModelRendererTurbo(this, 361, 1, textureX, textureY); // Box 97
		body[3] = new ModelRendererTurbo(this, 481, 1, textureX, textureY); // Box 98

		body[0].addShapeBox(0F, 0F, 0F, 4, 4, 12, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 81
		body[0].setRotationPoint(9F, -25F, 7F);

		body[1].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 93
		body[1].setRotationPoint(6F, -26F, 12.5F);
		body[1].rotateAngleZ = 0.26179939F;

		body[2].addShapeBox(0F, 0F, 0F, 3, 2, 2, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 97
		body[2].setRotationPoint(14F, -14F, 9F);

		body[3].addShapeBox(0F, 0F, 0F, 3, 2, 2, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 98
		body[3].setRotationPoint(14F, -14F, 13F);
		
	}
	
	//TODO override rendering to save up processing time
	
}