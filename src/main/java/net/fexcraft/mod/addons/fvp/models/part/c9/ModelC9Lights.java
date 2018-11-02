package net.fexcraft.mod.addons.fvp.models.part.c9;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.part.PartModel;
import net.minecraft.entity.Entity;

public class ModelC9Lights extends PartModel {
	
	public ModelC9Lights(){
    	super(); textureX = 512; textureY = 512;
    	ModelRendererTurbo[] front_lights = new ModelRendererTurbo[2];
		front_lights[0] = new ModelRendererTurbo(this, 481, 17, textureX, textureY); // Box 47
		front_lights[1] = new ModelRendererTurbo(this, 465, 25, textureX, textureY); // Box 61
		front_lights[0].addShapeBox(0F, 0F, 0F, 1, 3, 10, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.8F, 0F, -0.4F, 1.8F, 0F, -0.4F, 1.1F, 0F, 0F, -1.1F, 0F, 0F, -2.6F, 0F, -0.4F, 2.6F, 0F, -0.4F); // Box 47
		front_lights[0].setRotationPoint(47.6F, 0F, 7F);
		front_lights[1].addShapeBox(0F, 0F, 0F, 1, 3, 10, 0F, 1.8F, 0F, -0.4F, -1.8F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0F, 0F, 2.6F, 0F, -0.4F, -2.6F, 0F, -0.4F, -1.1F, 0F, 0F, 1.1F, 0F, 0F); // Box 61
		front_lights[1].setRotationPoint(47.6F, 0F, -17F);
		this.add("front_lights", front_lights);
		//
		ModelRendererTurbo[] back_lights = new ModelRendererTurbo[2];
		back_lights[0] = new ModelRendererTurbo(this, 401, 121, textureX, textureY); // Box 323
		back_lights[1] = new ModelRendererTurbo(this, 161, 129, textureX, textureY); // Box 324
		back_lights[0].addShapeBox(0F, 0F, 0F, 1, 5, 13, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0.2F, -0.5F, 0F, 0.2F, 0.3F, -0.8F, 0F, -0.3F, -0.8F, 0F, 0.3F, -0.8F, 0.2F, -0.3F, -0.8F, 0.2F); // Box 323
		back_lights[0].setRotationPoint(-54.4F, -1F, 3.4F);
		back_lights[1].addShapeBox(0F, 0F, 0F, 1, 5, 13, 0F, -0.5F, 0F, 0.2F, 0.5F, 0F, 0.2F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, -0.8F, 0.2F, 0.3F, -0.8F, 0.2F, -0.3F, -0.8F, 0F, 0.3F, -0.8F, 0F); // Box 324
		back_lights[1].setRotationPoint(-54.4F, -1F, -16.4F);
		this.add("back_lights", back_lights);
		//
		ModelRendererTurbo[] turn_signal_left = new ModelRendererTurbo[4];
		turn_signal_left[0] = new ModelRendererTurbo(this, 505, 17, textureX, textureY); // Box 48
		turn_signal_left[1] = new ModelRendererTurbo(this, 33, 1, textureX, textureY); // Box 49
		turn_signal_left[2] = new ModelRendererTurbo(this, 49, 121, textureX, textureY); // Box 325
		turn_signal_left[3] = new ModelRendererTurbo(this, 241, 121, textureX, textureY); // Box 327
		turn_signal_left[0].addShapeBox(0F, 0F, 0F, 1, 3, 2, 0F, 0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.9F, 0F, -0.3F, 0.9F, 0F, -0.3F, 1F, 0F, 0F, -1F, 0F, 0F, -1.6F, 0F, -0.3F, 1.6F, 0F, -0.3F); // Box 48
		turn_signal_left[0].setRotationPoint(46F, 0F, 16.6F);
		turn_signal_left[1].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, 0F, 0F, 0.1F, 0F, 0F, -0.8F, 0F, -0.3F, 1.6F, 0F, 0F, 0F, 0F, 0F, -0.6F, 0F, 0F, -1.6F, 0F, -0.1F, 1.8F, 0F, -0.1F); // Box 49
		turn_signal_left[1].setRotationPoint(45F, 0F, 18.3F);
		turn_signal_left[2].addShapeBox(0F, 0F, 0F, 2, 5, 2, 0F, 0.4F, 0F, 0F, -0.6F, 0F, 0F, 0F, 0F, -0.6F, 0.1F, 0F, -0.6F, 0.6F, -0.8F, 0F, -0.7F, -0.8F, 0F, 0F, -0.8F, -0.6F, 0.3F, -0.8F, -0.6F); // Box 325
		turn_signal_left[2].setRotationPoint(-53.5F, -1F, 16.6F);
		turn_signal_left[3].addShapeBox(0F, 0F, 0F, 2, 5, 2, 0F, -0.4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.1F, -1F, 0F, -1.5F, -0.2F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, -1.1F, -0.8F, -0.8F, -1.5F); // Box 327
		turn_signal_left[3].setRotationPoint(-54F, -1F, 18F);
		this.add("turn_signal_left", turn_signal_left);
		//
		ModelRendererTurbo[] turn_signal_right = new ModelRendererTurbo[4];
		turn_signal_right[0] = new ModelRendererTurbo(this, 233, 1, textureX, textureY); // Box 59
		turn_signal_right[1] = new ModelRendererTurbo(this, 313, 25, textureX, textureY); // Box 60
		turn_signal_right[2] = new ModelRendererTurbo(this, 89, 121, textureX, textureY); // Box 326
		turn_signal_right[3] = new ModelRendererTurbo(this, 353, 121, textureX, textureY); // Box 328
		turn_signal_right[0].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 1.6F, 0F, 0F, -0.8F, 0F, -0.3F, 0.1F, 0F, 0F, 0F, 0F, 0F, 1.8F, 0F, -0.1F, -1.6F, 0F, -0.1F, -0.6F, 0F, 0F, 0F, 0F, 0F); // Box 59
		turn_signal_right[0].setRotationPoint(45F, 0F, -19.3F);
		turn_signal_right[1].addShapeBox(0F, 0F, 0F, 1, 3, 2, 0F, 0.9F, 0F, -0.3F, -0.9F, 0F, -0.3F, -0.2F, 0F, 0F, 0.2F, 0F, 0F, 1.6F, 0F, -0.3F, -1.6F, 0F, -0.3F, -1F, 0F, 0F, 1F, 0F, 0F); // Box 60
		turn_signal_right[1].setRotationPoint(46F, 0F, -18.6F);
		turn_signal_right[2].addShapeBox(0F, 0F, 0F, 2, 5, 2, 0F, 0.1F, 0F, -0.6F, 0F, 0F, -0.6F, -0.6F, 0F, 0F, 0.4F, 0F, 0F, 0.3F, -0.8F, -0.6F, 0F, -0.8F, -0.6F, -0.7F, -0.8F, 0F, 0.6F, -0.8F, 0F); // Box 326
		turn_signal_right[2].setRotationPoint(-53.5F, -1F, -18.6F);
		turn_signal_right[3].addShapeBox(0F, 0F, 0F, 2, 5, 2, 0F, -1F, 0F, -1.5F, 0F, 0F, -1.1F, 0F, 0F, 0F, -0.4F, 0F, 0F, -0.8F, -0.8F, -1.5F, 0F, -0.8F, -1.1F, 0F, -0.8F, 0F, -0.2F, -0.8F, 0F); // Box 328
		turn_signal_right[3].setRotationPoint(-54F, -1F, -20F);
		this.add("turn_signal_right", turn_signal_right);
	}
	
    @Override
	public void render(VehicleData data, String us){
	    super.render(data, us);
	    render("turn_signal_left");
	    render("turn_signal_right");
	}
	
	@Override
	public void render(VehicleData data, String us, Entity vehicle, int meta){
	    super.render(data, us, vehicle, meta);
	    render("turn_signal_left");
	    render("turn_signal_right");
	}
	
}