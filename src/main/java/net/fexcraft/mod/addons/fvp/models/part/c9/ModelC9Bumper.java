package net.fexcraft.mod.addons.fvp.models.part.c9;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.part.PartModelTMT;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.minecraft.entity.Entity;

public class ModelC9Bumper extends PartModelTMT {
	
	public ModelC9Bumper(){
    	super(); textureX = 512; textureY = 512;
		track_wheels_left = new ModelRendererTurbo[8];
		track_wheels_left[0] = new ModelRendererTurbo(this, 169, 97, textureX, textureY); // Box 204
		track_wheels_left[1] = new ModelRendererTurbo(this, 249, 89, textureX, textureY); // Box 205
		track_wheels_left[2] = new ModelRendererTurbo(this, 201, 97, textureX, textureY); // Box 206
		track_wheels_left[3] = new ModelRendererTurbo(this, 353, 97, textureX, textureY); // Box 207
		track_wheels_left[4] = new ModelRendererTurbo(this, 73, 65, textureX, textureY); // Box 339
		track_wheels_left[5] = new ModelRendererTurbo(this, 121, 65, textureX, textureY); // Box 340
		track_wheels_left[6] = new ModelRendererTurbo(this, 177, 65, textureX, textureY); // Box 341
		track_wheels_left[7] = new ModelRendererTurbo(this, 225, 65, textureX, textureY); // Box 342
		track_wheels_left[0].addShapeBox(0F, 0F, 0F, 1, 4, 14, 0F, 0F, 0F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0F, 0F, 0F, -0.6F, 0F, 0F, -0.9F, 0F, 0F, -0.9F, 0F, 0F, -0.6F, 0F); // Box 204
		track_wheels_left[0].setRotationPoint(50.7F, 4F, -7F);
		track_wheels_left[1].addShapeBox(0F, 0F, 0F, 1, 4, 11, 0F, 0F, 0F, 0F, 0F, -0.3F, 0F, -1.8F, -0.3F, 0F, 1.8F, 0F, 0F, 0F, -0.6F, 0F, 0F, -0.9F, 0F, -1.8F, -0.9F, 0F, 1.8F, -0.6F, 0F); // Box 205
		track_wheels_left[1].setRotationPoint(50.7F, 4F, 7F);
		track_wheels_left[2].addShapeBox(0F, 0F, 0F, 1, 4, 11, 0F, 1.8F, 0F, 0F, -1.8F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0F, 0F, 1.8F, -0.6F, 0F, -1.8F, -0.9F, 0F, 0F, -0.9F, 0F, 0F, -0.6F, 0F); // Box 206
		track_wheels_left[2].setRotationPoint(50.7F, 4F, -18F);
		track_wheels_left[3].addShapeBox(0F, 0F, 0F, 1, 3, 10, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F); // Box 207
		track_wheels_left[3].setRotationPoint(50.8F, 5F, -5F);
		track_wheels_left[4].addShapeBox(0F, 0F, 0F, 1, 4, 1, 0F, 0F, 0F, 0F, 0F, -0.3F, 0F, -0.4F, -0.3F, -0.2F, 0.4F, 0F, -0.2F, 0F, -0.6F, 0F, 0F, -0.9F, 0F, -0.4F, -0.9F, -0.2F, 0.4F, -0.6F, -0.2F); // Box 339
		track_wheels_left[4].setRotationPoint(48.9F, 4F, 18F);
		track_wheels_left[5].addShapeBox(0F, 0F, 0F, 1, 4, 1, 0F, 0.4F, 0F, -0.2F, -0.4F, -0.3F, -0.2F, 0F, -0.3F, 0F, 0F, 0F, 0F, 0.4F, -0.6F, -0.2F, -0.4F, -0.9F, -0.2F, 0F, -0.9F, 0F, 0F, -0.6F, 0F); // Box 340
		track_wheels_left[5].setRotationPoint(48.9F, 4F, -19F);
		track_wheels_left[6].addShapeBox(0F, 0F, 0F, 1, 4, 1, 0F, 0F, 0F, 0F, 0F, -0.3F, 0F, -0.8F, -0.3F, -0.5F, 0.9F, 0F, -0.45F, 0F, -0.6F, 0F, 0F, -0.9F, 0F, -0.8F, -0.9F, -0.5F, 0.9F, -0.6F, -0.45F); // Box 341
		track_wheels_left[6].setRotationPoint(48.5F, 4F, 18.8F);
		track_wheels_left[7].addShapeBox(0F, 0F, 0F, 1, 4, 1, 0F, 0.9F, 0F, -0.45F, -0.8F, -0.3F, -0.5F, 0F, -0.3F, 0F, 0F, 0F, 0F, 0.9F, -0.6F, -0.45F, -0.8F, -0.9F, -0.5F, 0F, -0.9F, 0F, 0F, -0.6F, 0F); // Box 342
		track_wheels_left[7].setRotationPoint(48.5F, 4F, -19.8F);
		//
		track_wheels_right = new ModelRendererTurbo[8];
		track_wheels_right[0] = new ModelRendererTurbo(this, 345, 129, textureX, textureY); // Box 329
		track_wheels_right[1] = new ModelRendererTurbo(this, 473, 153, textureX, textureY); // Box 346
		track_wheels_right[2] = new ModelRendererTurbo(this, 385, 129, textureX, textureY); // Box 347
		track_wheels_right[3] = new ModelRendererTurbo(this, 89, 153, textureX, textureY); // Box 348
		track_wheels_right[4] = new ModelRendererTurbo(this, 81, 105, textureX, textureY); // Box 349
		track_wheels_right[5] = new ModelRendererTurbo(this, 225, 129, textureX, textureY); // Box 350
		track_wheels_right[6] = new ModelRendererTurbo(this, 249, 65, textureX, textureY); // Box 351
		track_wheels_right[7] = new ModelRendererTurbo(this, 473, 65, textureX, textureY); // Box 352
		track_wheels_right[0].addShapeBox(0F, 0F, 0F, 1, 3, 6, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F); // Box 329
		track_wheels_right[0].setRotationPoint(-54.1F, 0F, -3F);
		track_wheels_right[1].addShapeBox(0F, 0F, 0F, 1, 4, 14, 0F, 0.1F, -0.3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, -0.3F, 0F, 0.1F, -0.8F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0.1F, -0.8F, 0F); // Box 346
		track_wheels_right[1].setRotationPoint(-57.8F, 4F, -7F);
		track_wheels_right[2].addShapeBox(0F, 0F, 0F, 1, 4, 11, 0F, -0.7F, -0.3F, -0.2F, 0.7F, 0F, -0.2F, 0F, 0F, 0F, 0.1F, -0.3F, 0F, -0.7F, -0.8F, -0.2F, 0.7F, -0.5F, -0.2F, 0F, -0.5F, 0F, 0.1F, -0.8F, 0F); // Box 347
		track_wheels_right[2].setRotationPoint(-57.8F, 4F, -18F);
		track_wheels_right[3].addShapeBox(0F, 0F, 0F, 1, 4, 11, 0F, 0.1F, -0.3F, 0F, 0F, 0F, 0F, 0.7F, 0F, -0.2F, -0.7F, -0.3F, -0.2F, 0.1F, -0.8F, 0F, 0F, -0.5F, 0F, 0.7F, -0.5F, -0.2F, -0.7F, -0.8F, -0.2F); // Box 348
		track_wheels_right[3].setRotationPoint(-57.8F, 4F, 7F);
		track_wheels_right[4].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F, 0.1F, -0.3F, 0F, -0.1F, 0F, 0F, 0.7F, 0F, -0.6F, -1F, -0.3F, -0.3F, 0.1F, -0.8F, 0F, -0.1F, -0.5F, 0F, 0.7F, -0.6F, -0.6F, -1F, -0.9F, -0.3F); // Box 349
		track_wheels_right[4].setRotationPoint(-57F, 4F, 17.8F);
		track_wheels_right[5].addShapeBox(0F, 0F, 0F, 1, 4, 2, 0F, -1F, -0.3F, -0.3F, 0.7F, 0F, -0.6F, -0.1F, 0F, 0F, 0.1F, -0.3F, 0F, -1F, -0.9F, -0.3F, 0.7F, -0.6F, -0.6F, -0.1F, -0.5F, 0F, 0.1F, -0.8F, 0F); // Box 350
		track_wheels_right[5].setRotationPoint(-57F, 4F, -19.8F);
		track_wheels_right[6].addShapeBox(0F, 1F, 0F, 1, 4, 1, 0F, 0F, 0F, 0F, 0.4F, 0F, -0.5F, -0.6F, -0.3F, -0.5F, 0.7F, -0.3F, -0.7F, 0F, -0.6F, 0F, 0.4F, -0.6F, -0.5F, -0.6F, -0.8F, -0.5F, 0.7F, -0.9F, -0.7F); // Box 351
		track_wheels_right[6].setRotationPoint(-55.3F, 3F, 19.2F); 
		track_wheels_right[7].addShapeBox(0F, 1F, 0F, 1, 4, 1, 0F, 0.7F, -0.3F, -0.7F, -0.6F, -0.3F, -0.5F, 0.4F, 0F, -0.5F, 0F, 0F, 0F, 0.7F, -0.9F, -0.7F, -0.6F, -0.8F, -0.5F, 0.4F, -0.6F, -0.5F, 0F, -0.6F, 0F); // Box 352
		track_wheels_right[7].setRotationPoint(-55.3F, 3F, -20.2F);
	}
	
    @Override
	public void render(VehicleData data, String us){
	    switch(us){
	        case "front_bumper": {
	            render(track_wheels_left);
	            return;
	        }
	        case "rear_bumper": {
	            render(track_wheels_right);
	            return;
	        }
	        default: {
	            super.render(data, us);
	            return;
	        }
	    }
	}
	
	@Override
	public void render(VehicleData data, String us, Entity vehicle, int meta){
	    this.render(data, us);
	}
	
}