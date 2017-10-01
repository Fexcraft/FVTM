package net.fexcraft.mod.addons.fvp.models.part;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.part.PartModel;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.minecraft.entity.Entity;

public class ModelC4Z1Seats extends PartModel {
	
	private static final int textureX = 1024, textureY = 1024;
	
	public ModelC4Z1Seats(){
		this.creators.add("FEX___96");
		this.creators.add("zackyboy18");
		body = new ModelRendererTurbo[22];
		body[0] = new ModelRendererTurbo(this, 497, 161, textureX, textureY); // Box 226
		body[1] = new ModelRendererTurbo(this, 353, 161, textureX, textureY); // Box 228
		body[2] = new ModelRendererTurbo(this, 577, 153, textureX, textureY); // Box 231
		body[3] = new ModelRendererTurbo(this, 25, 121, textureX, textureY); // Box 232
		body[4] = new ModelRendererTurbo(this, 33, 121, textureX, textureY); // Box 233
		body[5] = new ModelRendererTurbo(this, 713, 153, textureX, textureY); // Box 236
		body[6] = new ModelRendererTurbo(this, 545, 161, textureX, textureY); // Box 243
		body[7] = new ModelRendererTurbo(this, 329, 129, textureX, textureY); // Box 478
		body[8] = new ModelRendererTurbo(this, 753, 145, textureX, textureY); // Box 479
		body[9] = new ModelRendererTurbo(this, 865, 145, textureX, textureY); // Box 480
		body[10] = new ModelRendererTurbo(this, 689, 129, textureX, textureY); // Box 481
		body[11] = new ModelRendererTurbo(this, 1, 161, textureX, textureY); // Box 482
		body[12] = new ModelRendererTurbo(this, 49, 177, textureX, textureY); // Box 483
		body[13] = new ModelRendererTurbo(this, 561, 169, textureX, textureY); // Box 484
		body[14] = new ModelRendererTurbo(this, 777, 129, textureX, textureY); // Box 485
		body[15] = new ModelRendererTurbo(this, 97, 177, textureX, textureY); // Box 486
		body[16] = new ModelRendererTurbo(this, 593, 161, textureX, textureY); // Box 487
		body[17] = new ModelRendererTurbo(this, 929, 129, textureX, textureY); // Box 488
		body[18] = new ModelRendererTurbo(this, 25, 161, textureX, textureY); // Box 489
		body[19] = new ModelRendererTurbo(this, 145, 177, textureX, textureY); // Box 490
		body[20] = new ModelRendererTurbo(this, 737, 161, textureX, textureY); // Box 491
		body[21] = new ModelRendererTurbo(this, 697, 233, textureX, textureY); // Box 504

		body[0].addBox(0F, 0F, 0F, 10, 10, 10, 0F); // Box 226
		body[0].setRotationPoint(35F, -14F, 8F);

		body[1].addBox(0F, 0F, 0F, 2, 12, 10, 0F); // Box 228
		body[1].setRotationPoint(34F, -25.5F, 8F);
		body[1].rotateAngleZ = 0.06981317F;

		body[2].addShapeBox(0F, -1F, 0F, 2, 1, 10, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 231
		body[2].setRotationPoint(34F, -25.5F, 8F);
		body[2].rotateAngleZ = 0.06981317F;

		body[3].addBox(0.5F, -2F, 2.5F, 1, 1, 1, 0F); // Box 232
		body[3].setRotationPoint(34F, -25.5F, 8F);
		body[3].rotateAngleZ = 0.06981317F;

		body[4].addBox(0.5F, -2F, 6.5F, 1, 1, 1, 0F); // Box 233
		body[4].setRotationPoint(34F, -25.5F, 8F);
		body[4].rotateAngleZ = 0.06981317F;

		body[5].addBox(0F, -5F, 1.5F, 2, 3, 7, 0F); // Box 236
		body[5].setRotationPoint(34F, -25.5F, 8F);
		body[5].rotateAngleZ = 0.06981317F;

		body[6].addShapeBox(0F, 0F, 0F, 1, 2, 10, 0F, 0F, 0F, 0F, 0F, -0.2F, -1F, 0F, -0.2F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -1F, 0F, -0.2F, -1F, 0F, 0F, 0F); // Box 243
		body[6].setRotationPoint(45F, -14F, 8F);

		body[7].addBox(0.5F, -2F, 6.5F, 1, 1, 1, 0F); // Box 478
		body[7].setRotationPoint(34F, -25.5F, -19F);
		body[7].rotateAngleZ = 0.06981317F;

		body[8].addBox(0F, 0F, 0F, 2, 12, 11, 0F); // Box 479
		body[8].setRotationPoint(34F, -25.5F, -20F);
		body[8].rotateAngleZ = 0.06981317F;

		body[9].addShapeBox(0F, -1F, 0F, 2, 1, 11, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 480
		body[9].setRotationPoint(34F, -25.5F, -20F);
		body[9].rotateAngleZ = 0.06981317F;

		body[10].addBox(0.5F, -2F, 2.5F, 1, 1, 1, 0F); // Box 481
		body[10].setRotationPoint(34F, -25.5F, -20F);
		body[10].rotateAngleZ = 0.06981317F;

		body[11].addBox(0F, -5F, 1.5F, 2, 3, 8, 0F); // Box 482
		body[11].setRotationPoint(34F, -25.5F, -20F);
		body[11].rotateAngleZ = 0.06981317F;

		body[12].addBox(0F, 0F, 0F, 10, 10, 11, 0F); // Box 483
		body[12].setRotationPoint(35F, -14F, -20F);

		body[13].addShapeBox(0F, 0F, 0F, 1, 2, 11, 0F, 0F, 0F, 0F, 0F, -0.2F, -1F, 0F, -0.2F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -1F, 0F, -0.2F, -1F, 0F, 0F, 0F); // Box 484
		body[13].setRotationPoint(45F, -14F, -20F);

		body[14].addBox(0.5F, -2F, 6.5F, 1, 1, 1, 0F); // Box 485
		body[14].setRotationPoint(34F, -25.5F, -9F);
		body[14].rotateAngleZ = 0.06981317F;

		body[15].addBox(0F, 0F, 0F, 2, 12, 10, 0F); // Box 486
		body[15].setRotationPoint(34F, -25.5F, -9F);
		body[15].rotateAngleZ = 0.06981317F;

		body[16].addShapeBox(0F, -1F, 0F, 2, 1, 10, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 487
		body[16].setRotationPoint(34F, -25.5F, -9F);
		body[16].rotateAngleZ = 0.06981317F;

		body[17].addBox(0.5F, -2F, 2.5F, 1, 1, 1, 0F); // Box 488
		body[17].setRotationPoint(34F, -25.5F, -9F);
		body[17].rotateAngleZ = 0.06981317F;

		body[18].addBox(0F, -5F, 1.5F, 2, 3, 7, 0F); // Box 489
		body[18].setRotationPoint(34F, -25.5F, -9F);
		body[18].rotateAngleZ = 0.06981317F;

		body[19].addBox(0F, 0F, 0F, 10, 10, 10, 0F); // Box 490
		body[19].setRotationPoint(35F, -14F, -9F);

		body[20].addShapeBox(0F, 0F, 0F, 1, 2, 10, 0F, 0F, 0F, 0F, 0F, -0.2F, -1F, 0F, -0.2F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -1F, 0F, -0.2F, -1F, 0F, 0F, 0F); // Box 491
		body[20].setRotationPoint(45F, -14F, -9F);

		body[21].addBox(0F, 0F, 0F, 9, 10, 42, 0F); // Box 504
		body[21].setRotationPoint(25F, -14F, -20F);
		
		super.fixRotation(body, false, false, true);
		//TODO sub models without paint be.
	}
	
	@Override
	public void render(VehicleData data, String us){
		data.getSecondaryColor().glColorApply();
		render(body);
		data.getSecondaryColor().glColorReset();
	}
	
	@Override
	public void render(VehicleData data, String us, Entity vehicle){
		data.getSecondaryColor().glColorApply();
		render(body);
		data.getSecondaryColor().glColorReset();
	}
	
}