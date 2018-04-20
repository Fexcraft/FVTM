//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2018 Minecraft-SMP.de
// This file is for Fex's Vehicle & Transportation Mod

// Model: T2 (Rear Fenders)
// Model Creator: FEX___96

package net.fexcraft.mod.addons.fvp.models.part;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.part.PartModel;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.minecraft.entity.Entity;

public class ModelT2SK extends PartModel<VehicleData>{
	
	int textureX = 512;
	int textureY = 512;

	public ModelT2SK(){
		this.creators.add("01e4af9b-2a30-471e-addf-f6338ffce04b");
		body = new ModelRendererTurbo[4];
		body[0] = new ModelRendererTurbo(this, 361, 241, textureX, textureY); // Box 150
		body[1] = new ModelRendererTurbo(this, 225, 249, textureX, textureY); // Box 151
		body[2] = new ModelRendererTurbo(this, 225, 265, textureX, textureY); // Box 153
		body[3] = new ModelRendererTurbo(this, 353, 273, textureX, textureY); // Box 154

		body[0].addShapeBox(0F, 0F, 0F, 50, 1, 12, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F); // Box 150
		body[0].setRotationPoint(-32F, -14F, 14F);

		body[1].addShapeBox(0F, 0F, 0F, 50, 1, 12, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 151
		body[1].setRotationPoint(-32F, -14F, -26F);

		body[2].addShapeBox(0F, 0F, 0F, 50, 13, 12, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 153
		body[2].setRotationPoint(-32F, -12F, 14F);

		body[3].addShapeBox(0F, 0F, 0F, 50, 13, 12, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 154
		body[3].setRotationPoint(-32F, -12F, -26F);

		translateAll(0F, 0F, 0F);
		flipAll();
	}

	@Override
	public void render(VehicleData data, String us){
		switch(us){
			case "side_left":{
				body[0].render();
				body[2].render();
				return;
			}
			case "side_right":{
				body[1].render();
				body[3].render();
				return;
			}
			case "sides": default:{
				render(body);
				return;
			}
		}
	}
	
	@Override
	public void render(VehicleData data, String us, Entity vehicle){
		this.render(data, us);
	}
	
}
