package net.fexcraft.mod.addons.fvp.models.part;

import net.fexcraft.mod.addons.gep.scripts.MultiDoorScript;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.part.PartModel;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.entity.Entity;

public class ModelC8Doors extends PartModel<VehicleData> {
	
	private static final int textureX = 512, textureY = 512;
	public ModelRendererTurbo[] hood, trunk;
	public ModelRendererTurbo[] front_right;
	public ModelRendererTurbo[] front_left;
	public ModelRendererTurbo[] back_left;
	public ModelRendererTurbo[] back_right;
	
	public ModelC8Doors(){
		this.creators.add("Ferdinand (FEX___96)");
		//
		front_left = new ModelRendererTurbo[8];
		front_left[0] = new ModelRendererTurbo(this, 249, 169, textureX, textureY); // Box 241
		front_left[1] = new ModelRendererTurbo(this, 473, 153, textureX, textureY); // Box 242
		front_left[2] = new ModelRendererTurbo(this, 329, 169, textureX, textureY); // Box 243
		front_left[3] = new ModelRendererTurbo(this, 425, 81, textureX, textureY); // Box 244
		front_left[4] = new ModelRendererTurbo(this, 185, 89, textureX, textureY); // Box 245
		front_left[5] = new ModelRendererTurbo(this, 457, 89, textureX, textureY); // Box 246
		front_left[6] = new ModelRendererTurbo(this, 33, 121, textureX, textureY); // Box 247
		front_left[7] = new ModelRendererTurbo(this, 329, 145, textureX, textureY); // Box 248
		front_left[0].addBox(-22F, 0F, 0F, 22, 10, 1, 0F); // Box 241
		front_left[0].setRotationPoint(25F, -9F, 21F);
		front_left[1].addShapeBox(-22F, 0F, -1F, 16, 10, 1, 0F, 0F, 0F, 0F, 0F, 0F, -0.9F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.9F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 242
		front_left[1].setRotationPoint(25F, -9F, 21F);
		front_left[2].addShapeBox(-22F, -2F, 0F, 22, 2, 1, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 243
		front_left[2].setRotationPoint(25F, -9F, 21F);
		front_left[3].addShapeBox(-22F, -13F, -2F, 1, 11, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F); // Box 244
		front_left[3].setRotationPoint(25F, -9F, 21F);
		front_left[4].addShapeBox(-10F, -13F, -2F, 1, 11, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.6F, 0F, 0F, -1.6F, 0F, 0F, 1.5F, 0F, 0F, 1.5F); // Box 245
		front_left[4].setRotationPoint(25F, -9F, 21F);
		front_left[5].addShapeBox(-10F, -13F, -2F, 1, 11, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -9.1F, -1F, -1.7F, 9.1F, -1F, -1.7F, 9.1F, -1F, 1.7F, -9.1F, -1F, 1.7F); // Box 246
		front_left[5].setRotationPoint(25F, -9F, 21F);
		front_left[6].addShapeBox(-3F, -5F, 0F, 3, 3, 1, 0F, 0F, 0.3F, 0.7F, 0F, -1F, 0.4F, 0F, -1.9F, -0.3F, 0F, 0.3F, -0.7F, 0F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0F, 0F, 0F, -0.1F); // Box 247
		front_left[6].setRotationPoint(25F, -9F, 21F);
		front_left[7].addShapeBox(-22F, -13F, -2F, 13, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0F, 0.1F); // Box 248
		front_left[7].setRotationPoint(25F, -9F, 21F);
		//
		front_right = new ModelRendererTurbo[8];
		front_right[0] = new ModelRendererTurbo(this, 329, 177, textureX, textureY); // Box 236
		front_right[1] = new ModelRendererTurbo(this, 201, 177, textureX, textureY); // Box 237
		front_right[2] = new ModelRendererTurbo(this, 377, 169, textureX, textureY); // Box 238
		front_right[3] = new ModelRendererTurbo(this, 505, 89, textureX, textureY); // Box 239
		front_right[4] = new ModelRendererTurbo(this, 121, 97, textureX, textureY); // Box 240
		front_right[5] = new ModelRendererTurbo(this, 297, 97, textureX, textureY); // Box 241
		front_right[6] = new ModelRendererTurbo(this, 265, 121, textureX, textureY); // Box 242
		front_right[7] = new ModelRendererTurbo(this, 25, 153, textureX, textureY); // Box 243
		front_right[0].addBox(-22F, 0F, -1F, 22, 10, 1, 0F); // Box 236
		front_right[0].setRotationPoint(25F, -9F, -21F);
		front_right[1].addShapeBox(-22F, 0F, 0F, 16, 10, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.9F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.9F, 0F, 0F, 0F); // Box 237
		front_right[1].setRotationPoint(25F, -9F, -21F);
		front_right[2].addShapeBox(-22F, -2F, -1F, 22, 2, 1, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F); // Box 238
		front_right[2].setRotationPoint(25F, -9F, -21F);
		front_right[3].addShapeBox(-22F, -13F, 1F, 1, 11, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 239
		front_right[3].setRotationPoint(25F, -9F, -21F);
		front_right[4].addShapeBox(-10F, -13F, 1F, 1, 11, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1.5F, 0F, 0F, 1.5F, 0F, 0F, -1.6F, 0F, 0F, -1.6F); // Box 240
		front_right[4].setRotationPoint(25F, -9F, -21F);
		front_right[5].addShapeBox(-10F, -13F, 1F, 1, 11, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -9.1F, -1F, 1.7F, 9.1F, -1F, 1.7F, 9.1F, -1F, -1.7F, -9.1F, -1F, -1.7F); // Box 241
		front_right[5].setRotationPoint(25F, -9F, -21F);
		front_right[6].addShapeBox(-3F, -5F, -1F, 3, 3, 1, 0F, 0F, 0.3F, -0.7F, 0F, -1.9F, -0.3F, 0F, -1F, 0.4F, 0F, 0.3F, 0.7F, 0F, 0F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0.2F, 0F, 0F, 0.2F); // Box 242
		front_right[6].setRotationPoint(25F, -9F, -21F);
		front_right[7].addShapeBox(-22F, -13F, 1F, 13, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 243
		front_right[7].setRotationPoint(25F, -9F, -21F);
		//
		back_left = new ModelRendererTurbo[5];
		back_left[0] = new ModelRendererTurbo(this, 457, 177, textureX, textureY); // Box 246
		back_left[1] = new ModelRendererTurbo(this, 417, 161, textureX, textureY); // Box 247
		back_left[2] = new ModelRendererTurbo(this, 225, 129, textureX, textureY); // Box 248
		back_left[3] = new ModelRendererTurbo(this, 265, 129, textureX, textureY); // Box 249
		back_left[4] = new ModelRendererTurbo(this, 81, 185, textureX, textureY); // Box 250
		back_left[0].addBox(-17F, 0F, 0F, 17, 10, 2, 0F); // Box 246
		back_left[0].setRotationPoint(1F, -9F, 20F);
		back_left[1].addShapeBox(-17F, -2F, 0F, 17, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 247
		back_left[1].setRotationPoint(1F, -9F, 20F);
		back_left[2].addShapeBox(-1F, -13F, -1F, 1, 11, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F); // Box 248
		back_left[2].setRotationPoint(1F, -9F, 20F);
		back_left[3].addShapeBox(-17F, -13F, -1F, 1, 11, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F); // Box 249
		back_left[3].setRotationPoint(1F, -9F, 20F);
		back_left[4].addShapeBox(-16F, -13F, -1F, 15, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0F, 0.1F); // Box 250
		back_left[4].setRotationPoint(1F, -9F, 20F);
		//
		back_right = new ModelRendererTurbo[5];
		back_right[0] = new ModelRendererTurbo(this, 145, 185, textureX, textureY); // Box 251
		back_right[1] = new ModelRendererTurbo(this, 185, 193, textureX, textureY); // Box 252
		back_right[2] = new ModelRendererTurbo(this, 281, 129, textureX, textureY); // Box 253
		back_right[3] = new ModelRendererTurbo(this, 289, 129, textureX, textureY); // Box 254
		back_right[4] = new ModelRendererTurbo(this, 249, 185, textureX, textureY); // Box 255
		back_right[0].addBox(-17F, 0F, -2F, 17, 10, 2, 0F); // Box 251
		back_right[0].setRotationPoint(1F, -9F, -20F);
		back_right[1].addShapeBox(-17F, -2F, -2F, 17, 2, 2, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 252
		back_right[1].setRotationPoint(1F, -9F, -20F);
		back_right[2].addShapeBox(-1F, -13F, 0F, 1, 11, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 253
		back_right[2].setRotationPoint(1F, -9F, -20F);
		back_right[3].addShapeBox(-17F, -13F, 0F, 1, 11, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 254
		back_right[3].setRotationPoint(1F, -9F, -20F);
		back_right[4].addShapeBox(-16F, -13F, 0F, 15, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 255
		back_right[4].setRotationPoint(1F, -9F, -20F);
		//
		hood = new ModelRendererTurbo[2];
		hood[0] = new ModelRendererTurbo(this, 1, 161, textureX, textureY); // Box 125
		hood[1] = new ModelRendererTurbo(this, 281, 81, textureX, textureY); // Box 126
		hood[0].addShapeBox(0F, 0F, -16F, 22, 1, 32, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 125
		hood[0].setRotationPoint(29F, -10F, 0F);
		hood[1].addShapeBox(6F, 0F, -7F, 12, 1, 14, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 126
		hood[1].setRotationPoint(29F, -10.5F, 0F);
		//
		trunk = new ModelRendererTurbo[4];
		trunk[0] = new ModelRendererTurbo(this, 129, 121, textureX, textureY); // Box 104
		trunk[1] = new ModelRendererTurbo(this, 201, 121, textureX, textureY); // Box 105
		trunk[2] = new ModelRendererTurbo(this, 193, 49, textureX, textureY); // Box 112
		trunk[3] = new ModelRendererTurbo(this, 337, 121, textureX, textureY); // Box 116
		trunk[0].addShapeBox(-26F, 2F, -16F, 2, 3, 32, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 104
		trunk[0].setRotationPoint(-31F, -11F, 0F);
		trunk[1].addBox(-25F, 5F, -16F, 1, 4, 32, 0F); // Box 105
		trunk[1].setRotationPoint(-31F, -11F, 0F);
		trunk[2].addBox(-25.2F, 5.5F, -6F, 1, 3, 12, 0F); // Box 112
		trunk[2].setRotationPoint(-31F, -11F, 0F);
		trunk[3].addShapeBox(-26F, 0F, -16F, 26, 2, 32, 0F, -1F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 116
		trunk[3].setRotationPoint(-31F, -11F, 0F);
	}
	
	@Override
	public void render(VehicleData data, String us){
		data.getPrimaryColor().glColorApply();
		render(this.front_left);
		render(this.front_right);
		render(this.back_left);
		render(this.back_right);
		render(this.hood);
		render(this.trunk);
		RGB.glColorReset();
	}
	
	@Override
	public void render(VehicleData data, String us, Entity vehicle){
		MultiDoorScript script = data.getScript(MultiDoorScript.class);
		if(script == null){
			data.getPrimaryColor().glColorApply();
			rotate(this.front_left,  0, data.doorsOpen() ?  Static.rad60 : 0, 0, true);
			render(this.front_left);
			rotate(this.front_right, 0, data.doorsOpen() ? -Static.rad60 : 0, 0, true);
			render(this.front_right);
			rotate(this.back_left,   0, data.doorsOpen() ?  Static.rad60 : 0, 0, true);
			render(this.back_left);
			rotate(this.back_right,  0, data.doorsOpen() ? -Static.rad60 : 0, 0, true);
			render(this.back_right);
			//
			rotate(this.hood, 0, 0, data.doorsOpen() ? -Static.rad60 : 0, true);
			render(this.hood);
			rotate(this.trunk, 0, 0, data.doorsOpen() ? Static.rad60 : 0, true);
			render(this.trunk);
			RGB.glColorReset();
		}
		else{
			data.getPrimaryColor().glColorApply();
			rotate(this.front_left,  0, script.front_left ?  Static.rad60 : 0, 0, true);
			render(this.front_left);
			rotate(this.front_right, 0, script.front_right ? -Static.rad60 : 0, 0, true);
			render(this.front_right);
			rotate(this.back_left,   0, script.back_left ?  Static.rad60 : 0, 0, true);
			render(this.back_left);
			rotate(this.back_right,  0, script.back_right ? -Static.rad60 : 0, 0, true);
			render(this.back_right);
			//
			rotate(this.hood, 0, 0, script.hood ? -Static.rad60 : 0, true);
			render(this.hood);
			rotate(this.trunk, 0, 0, script.trunk ? Static.rad60 : 0, true);
			render(this.trunk);
			RGB.glColorReset();
		}
	}
	
}