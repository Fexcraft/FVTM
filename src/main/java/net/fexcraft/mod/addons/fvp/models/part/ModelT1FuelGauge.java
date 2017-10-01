//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2017 Minecraft-SMP.de

// Model: T1FuelGauge
// Model Creator: FEX___96
// Created on: 18.08.2017 - 14:39:34
// Last changed on: 18.08.2017 - 14:39:34

package net.fexcraft.mod.addons.fvp.models.part;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.part.PartModel;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.util.common.Static;
import net.minecraft.entity.Entity;

public class ModelT1FuelGauge extends PartModel {
	
	int textureX = 32;
	int textureY = 32;

	public ModelT1FuelGauge(){
		this.creators.add("Ferdinand (FEX___96)");
		body = new ModelRendererTurbo[3];
		body[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
		body[1] = new ModelRendererTurbo(this, 9, 1, textureX, textureY); // Box 1
		body[2] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 2
		body[0].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 0
		body[0].setRotationPoint(50.3F, -21F, 14F);

		body[1].addShapeBox(0F, 0F, -0.5F, 1, 2, 1, 0F, 0F, 0F, -0.4F, -0.8F, 0F, -0.4F, -0.8F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, -0.6F, -0.4F, -0.8F, -0.6F, -0.4F, -0.8F, -0.6F, -0.4F, 0F, -0.6F, -0.4F); // Box 1
		body[1].setRotationPoint(50.2F, -19.5F, 15F);
		body[1].rotateAngleX = 3.14159265F;

		body[2].addShapeBox(0F, -0.5F, -0.5F, 1, 1, 1, 0F, 0F, -0.3F, -0.3F, 0F, -0.3F, -0.3F, 0F, -0.3F, -0.3F, 0F, -0.3F, -0.3F, 0F, -0.3F, -0.3F, 0F, -0.3F, -0.3F, 0F, -0.3F, -0.3F, 0F, -0.3F, -0.3F); // Box 2
		body[2].setRotationPoint(50.1F, -19.5F, 15F);
		body[2].rotateAngleX = 3.14159265F;
		//translateAll(0F, 0F, 0F);
		//flipAll();
	}
	
	@Override
	public void render(VehicleData data, String usedAS){
		body[1].rotateAngleX = 3.14159265F;
		render(body);
	}
	
	@Override
	public void render(VehicleData data, String us, Entity vehicle){
		//double per = (data.getFuelTankContent() / data.getFuelTankSize()) * 100;
		double rad = (data.getFuelTankContent() / data.getFuelTankSize()) * 90;
		body[1].rotateAngleX = (float)(Static.rad1 * (rad + 135));
		render(body);
	}
	
}