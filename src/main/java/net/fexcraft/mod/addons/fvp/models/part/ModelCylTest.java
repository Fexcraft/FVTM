//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2017 Minecraft-SMP.de

// Model: C2R2T1 Wheel
// Model Creator: FEX___96
// Created on: 31.03.2017 - 14:38:29
// Last changed on: 31.03.2017 - 14:38:29

package net.fexcraft.mod.addons.fvp.models.part;

import net.fexcraft.mod.fvtm.model.part.PartModel;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelCylTest extends PartModel {

	public ModelCylTest(){
		this.creators.add("Ferdinand (FEX___96)");
		//
		body = new ModelRendererTurbo[1];
		body[0] = new ModelRendererTurbo(this, 0, 0, 512, 512);
		body[0].addCylinder(0, -24, 0, 5, 20, 16, 1, 1, ModelRendererTurbo.MR_TOP, 4, 4, 5);
		body[0].setRotationPoint(0, -24F, 0);
		body[0].setOldRotationOrder(true);
	}
	
}