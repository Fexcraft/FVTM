package net.fexcraft.mod.addons.test.models;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.RailGaugeModel;

public class ModelRailSTD125_DYNTEST12 extends RailGaugeModel {
	
	public static final int textureX = 256, textureY = 128;

	public ModelRailSTD125_DYNTEST12() {
		base = new ModelRendererTurbo[16];
		base[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box01
		base[1] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box02
		base[2] = new ModelRendererTurbo(this, 57, 1, textureX, textureY); // Box03
		base[3] = new ModelRendererTurbo(this, 97, 1, textureX, textureY); // Box04
		base[4] = new ModelRendererTurbo(this, 153, 1, textureX, textureY); // Box05
		base[5] = new ModelRendererTurbo(this, 193, 1, textureX, textureY); // Box06
		base[6] = new ModelRendererTurbo(this, 1, 9, textureX, textureY); // Box07
		base[7] = new ModelRendererTurbo(this, 57, 9, textureX, textureY); // Box08
		base[8] = new ModelRendererTurbo(this, 97, 9, textureX, textureY); // Box09
		base[9] = new ModelRendererTurbo(this, 153, 9, textureX, textureY); // Box10
		base[10] = new ModelRendererTurbo(this, 193, 9, textureX, textureY); // Box11
		base[11] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box12
		base[12] = new ModelRendererTurbo(this, 57, 17, textureX, textureY); // Box13
		base[13] = new ModelRendererTurbo(this, 233, 1, textureX, textureY); // Box14
		base[14] = new ModelRendererTurbo(this, 1, 49, textureX, textureY); // Box15
		base[15] = new ModelRendererTurbo(this, 241, 1, textureX, textureY); // Box16
		base[0].addBox(-2F, 0F, -20F, 4, 2, 22, 0F); // Box01
		base[0].setRotationPoint(0F, -4F, 9F);
		base[1].addShapeBox(0F, 0F, 0F, 8, 1, 3, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box02
		base[1].setRotationPoint(-4F, -5F, 5.5F);
		base[2].addShapeBox(0F, 0F, 0F, 8, 1, 3, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box03
		base[2].setRotationPoint(-4F, -5F, 5.5F);
		base[3].addBox(0F, 0F, 0F, 8, 2, 1, 0F); // Box04
		base[3].setRotationPoint(-4F, -6.5F, 6.5F);
		base[4].addShapeBox(0F, 0F, 0F, 8, 1, 2, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box05
		base[4].setRotationPoint(-4F, -8F, 6F);
		base[5].addShapeBox(0F, 0F, 0F, 8, 1, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box06
		base[5].setRotationPoint(-4F, -7F, 6F);
		base[6].addShapeBox(0F, 0F, 0F, 8, 1, 2, 0F, 0F, -0.5F, -0.2F, 0F, -0.5F, -0.2F, 0F, -0.5F, -0.2F, 0F, -0.5F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box07
		base[6].setRotationPoint(-4F, -8.5F, 6F);
		base[7].addShapeBox(0F, 0F, 0F, 8, 1, 2, 0F, 0F, -0.5F, -0.2F, 0F, -0.5F, -0.2F, 0F, -0.5F, -0.2F, 0F, -0.5F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box08
		base[7].setRotationPoint(-4F, -8.5F, -8F);
		base[8].addShapeBox(0F, 0F, 0F, 8, 1, 2, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box09
		base[8].setRotationPoint(-4F, -8F, -8F);
		base[9].addShapeBox(0F, 0F, 0F, 8, 1, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box10
		base[9].setRotationPoint(-4F, -7F, -8F);
		base[10].addBox(0F, 0F, 0F, 8, 2, 1, 0F); // Box11
		base[10].setRotationPoint(-4F, -6.5F, -7.5F);
		base[11].addShapeBox(0F, 0F, 0F, 8, 1, 3, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box12
		base[11].setRotationPoint(-4F, -5F, -8.5F);
		base[12].addShapeBox(0F, 0F, 0F, 8, 1, 3, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box13
		base[12].setRotationPoint(-4F, -5F, -8.5F);
		base[13].addBox(-2F, 0F, 0F, 1, 5, 1, 0F); // Box14
		base[13].setRotationPoint(1.5F, -5F, -6.75F);
		base[14].addShapeBox(0F, 0F, 0F, 8, 2, 32, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box15
		base[14].setRotationPoint(-4F, -2F, -16F);
		base[15].addBox(-1F, 0F, 0F, 1, 5, 1, 0F); // Box16
		base[15].setRotationPoint(0.5F, -5F, 5.75F);
	}
	
}