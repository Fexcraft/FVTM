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

public class ModelT2RF extends PartModel<VehicleData>{
	
	int textureX = 512;
	int textureY = 512;

	public ModelT2RF(){
		this.creators.add("01e4af9b-2a30-471e-addf-f6338ffce04b");
		body = new ModelRendererTurbo[9];
		body[0] = new ModelRendererTurbo(this, 185, 49, textureX, textureY); // Box 28
		body[1] = new ModelRendererTurbo(this, 233, 57, textureX, textureY); // Box 29
		body[2] = new ModelRendererTurbo(this, 1, 73, textureX, textureY); // Box 30
		body[3] = new ModelRendererTurbo(this, 65, 73, textureX, textureY); // Box 31
		body[4] = new ModelRendererTurbo(this, 481, 25, textureX, textureY); // Box 32
		body[5] = new ModelRendererTurbo(this, 313, 33, textureX, textureY); // Box 33
		body[6] = new ModelRendererTurbo(this, 321, 57, textureX, textureY); // Box 34
		body[7] = new ModelRendererTurbo(this, 281, 33, textureX, textureY); // Box 146
		body[8] = new ModelRendererTurbo(this, 417, 1, textureX, textureY); // Box 147

		body[0].addBox(0F, 0F, 0F, 2, 8, 14, 0F); // Box 28
		body[0].setRotationPoint(-35F, -6F, 12F);

		body[1].addShapeBox(0F, 0F, 0F, 2, 8, 14, 0F, 5F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 29
		body[1].setRotationPoint(-35F, -14F, 12F);

		body[2].addShapeBox(0F, 0F, 0F, 2, 8, 14, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 30
		body[2].setRotationPoint(-62F, -14F, 12F);

		body[3].addBox(0F, 0F, 0F, 2, 8, 14, 0F); // Box 31
		body[3].setRotationPoint(-62F, -6F, 12F);

		body[4].addShapeBox(0F, 0F, 0F, 2, 1, 12, 0F, -1F, 0F, 0F, 4F, 0F, 0F, 4F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 32
		body[4].setRotationPoint(-57F, -15F, 14F);

		body[5].addShapeBox(0F, 0F, 0F, 2, 1, 12, 0F, 4F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 33
		body[5].setRotationPoint(-40F, -15F, 14F);

		body[6].addShapeBox(0F, 0F, 0F, 17, 1, 12, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 34
		body[6].setRotationPoint(-56F, -16F, 14F);

		body[7].addShapeBox(0F, 0F, 0F, 19, 1, 2, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 146
		body[7].setRotationPoint(-57F, -15F, 12F);

		body[8].addShapeBox(0F, 0F, 0F, 17, 1, 2, 0F, -2F, 0F, -1F, -2F, 0F, -1F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 147
		body[8].setRotationPoint(-56F, -16F, 12F);


		turret = new ModelRendererTurbo[9];
		turret[0] = new ModelRendererTurbo(this, 129, 73, textureX, textureY); // Box 35
		turret[1] = new ModelRendererTurbo(this, 385, 73, textureX, textureY); // Box 36
		turret[2] = new ModelRendererTurbo(this, 385, 33, textureX, textureY); // Box 37
		turret[3] = new ModelRendererTurbo(this, 1, 177, textureX, textureY); // Box 38
		turret[4] = new ModelRendererTurbo(this, 473, 41, textureX, textureY); // Box 39
		turret[5] = new ModelRendererTurbo(this, 257, 81, textureX, textureY); // Box 40
		turret[6] = new ModelRendererTurbo(this, 1, 97, textureX, textureY); // Box 41
		turret[7] = new ModelRendererTurbo(this, 233, 49, textureX, textureY); // Box 148
		turret[8] = new ModelRendererTurbo(this, 369, 57, textureX, textureY); // Box 149

		turret[0].addBox(0F, 0F, 0F, 2, 8, 14, 0F); // Box 35
		turret[0].setRotationPoint(-62F, -6F, -26F);

		turret[1].addShapeBox(0F, 0F, 0F, 2, 8, 14, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 36
		turret[1].setRotationPoint(-62F, -14F, -26F);

		turret[2].addShapeBox(0F, 0F, 0F, 2, 1, 12, 0F, -1F, 0F, 0F, 4F, 0F, 0F, 4F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 37
		turret[2].setRotationPoint(-57F, -15F, -26F);

		turret[3].addShapeBox(0F, 0F, 0F, 17, 1, 12, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 38
		turret[3].setRotationPoint(-56F, -16F, -26F);

		turret[4].addShapeBox(0F, 0F, 0F, 2, 1, 12, 0F, 4F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 39
		turret[4].setRotationPoint(-40F, -15F, -26F);

		turret[5].addShapeBox(0F, 0F, 0F, 2, 8, 14, 0F, 5F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 40
		turret[5].setRotationPoint(-35F, -14F, -26F);

		turret[6].addBox(0F, 0F, 0F, 2, 8, 14, 0F); // Box 41
		turret[6].setRotationPoint(-35F, -6F, -26F);

		turret[7].addShapeBox(0F, 0F, 0F, 19, 1, 2, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 148
		turret[7].setRotationPoint(-57F, -15F, -14F);

		turret[8].addShapeBox(0F, 0F, 0F, 17, 1, 2, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, -1F, -2F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 149
		turret[8].setRotationPoint(-56F, -16F, -14F);

		translateAll(0F, 0F, 0F);
		flipAll();
	}

	@Override
	public void render(VehicleData data, String us){
		switch(us){
			case "rear_fender_left":{
				render(body);
				return;
			}
			case "rear_fender_right":{
				render(turret);
				return;
			}
			default:{
				render(body); render(turret);
				return;
			}
		}
	}
	
	@Override
	public void render(VehicleData data, String us, Entity vehicle){
		this.render(data, us);
	}
	
}
