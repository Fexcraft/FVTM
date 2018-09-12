//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2018 Minecraft-SMP.de

// Model: RailSTD125D
// Model Creator: FVTM
// Created on: 12.09.2018 - 15:23:16
// Last changed on: 12.09.2018 - 15:23:16

package net.fexcraft.mod.fvtm.model.block;

import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.lib.tmt.GenericModelBase;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.minecraft.util.ResourceLocation;

public class ModelRailSTD125Half extends GenericModelBase {

	private static final ResourceLocation texture = new ResourceLocation(FVTM.MODID, "textures/blocks/railstandard125.png");
	public static final ModelRailSTD125Half INSTANCE = new ModelRailSTD125Half();
	private static final int textureX = 256, textureY = 128;

	public static void bindTexture(){ bindTexture(texture); }

	public ModelRailSTD125Half(){
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
		base[0].addBox(-2F, 0F, -20F, 4, 2, 40, 0F); // Box01
		base[0].setRotationPoint(0F, -4F, 0F);
		base[1].addShapeBox(0F, 0F, 0F, 8, 1, 3, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box02
		base[1].setRotationPoint(-4F, -5F, 14.5F);
		base[2].addShapeBox(0F, 0F, 0F, 8, 1, 3, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box03
		base[2].setRotationPoint(-4F, -5F, 14.5F);
		base[3].addBox(0F, 0F, 0F, 8, 2, 1, 0F); // Box04
		base[3].setRotationPoint(-4F, -6.5F, 15.5F);
		base[4].addShapeBox(0F, 0F, 0F, 8, 1, 2, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box05
		base[4].setRotationPoint(-4F, -8F, 15F);
		base[5].addShapeBox(0F, 0F, 0F, 8, 1, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box06
		base[5].setRotationPoint(-4F, -7F, 15F);
		base[6].addShapeBox(0F, 0F, 0F, 8, 1, 2, 0F, 0F, -0.5F, -0.2F, 0F, -0.5F, -0.2F, 0F, -0.5F, -0.2F, 0F, -0.5F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box07
		base[6].setRotationPoint(-4F, -8.5F, 15F);
		base[7].addShapeBox(0F, 0F, 0F, 8, 1, 2, 0F, 0F, -0.5F, -0.2F, 0F, -0.5F, -0.2F, 0F, -0.5F, -0.2F, 0F, -0.5F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box08
		base[7].setRotationPoint(-4F, -8.5F, -17F);
		base[8].addShapeBox(0F, 0F, 0F, 8, 1, 2, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box09
		base[8].setRotationPoint(-4F, -8F, -17F);
		base[9].addShapeBox(0F, 0F, 0F, 8, 1, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box10
		base[9].setRotationPoint(-4F, -7F, -17F);
		base[10].addBox(0F, 0F, 0F, 8, 2, 1, 0F); // Box11
		base[10].setRotationPoint(-4F, -6.5F, -16.5F);
		base[11].addShapeBox(0F, 0F, 0F, 8, 1, 3, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box12
		base[11].setRotationPoint(-4F, -5F, -17.5F);
		base[12].addShapeBox(0F, 0F, 0F, 8, 1, 3, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box13
		base[12].setRotationPoint(-4F, -5F, -17.5F);
		base[13].addBox(-2F, 0F, 0F, 1, 5, 1, 0F); // Box14
		base[13].setRotationPoint(1.5F, -5F, -15.75F);
		base[14].addShapeBox(0F, 0F, 0F, 8, 2, 48, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box15
		base[14].setRotationPoint(-4F, -2F, -24F);
		base[15].addBox(-1F, 0F, 0F, 1, 5, 1, 0F); // Box16
		base[15].setRotationPoint(0.5F, -5F, 14.75F);
		translateAll(4F, 0F, 0F);
		flipAll();
	}
	
	@Override
	public void render(){ render(base); }
	
}