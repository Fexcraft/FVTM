package net.fexcraft.mod.addons.fvp.models.vehicle;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.vehicle.VehicleModel;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelTestArrow extends VehicleModel<VehicleData> {
	
	int textureX = 512;
	int textureY = 512;

	public ModelTestArrow(){
		body = new ModelRendererTurbo[5];
		body[0] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 0
		body[1] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 1
		body[2] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 2
		body[3] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 3
		body[4] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 4
		body[0].addBox(0F, 0F, 0F, 48, 1, 2, 0F); // Box 0
		body[0].setRotationPoint(-16F, -1F, -1F);
		body[1].addBox(0F, 0F, 0F, 2, 1, 24, 0F); // Box 1
		body[1].setRotationPoint(-1F, -1F, -12F);
		body[2].addShapeBox(0F, 0F, 0F, 2, 1, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -8F, 0F, 0F, 8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -8F, 0F, 0F, 8F, 0F, 0F); // Box 2
		body[2].setRotationPoint(30F, -1F, 1F);
		body[3].addShapeBox(0F, 0F, 0F, 2, 1, 8, 0F, 8F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 8F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 3
		body[3].setRotationPoint(30F, -1F, -9F);
		body[4].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 4
		body[4].setRotationPoint(0F, 0F, 0F);
		//
		//translateAll(0F, 0F, 0F);
		//flipAll();
	}
	
}