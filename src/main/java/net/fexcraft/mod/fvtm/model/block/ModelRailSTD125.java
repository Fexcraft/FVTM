//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2018 Minecraft-SMP.de

// Model: RailSTD125
// Model Creator: FEX___96
// Created on: 12.09.2018 - 15:23:16
// Last changed on: 12.09.2018 - 15:23:16

package net.fexcraft.mod.fvtm.model.block;

import net.fexcraft.lib.tmt.GenericModelBase;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.FVTM;
import net.minecraft.util.ResourceLocation;

public class ModelRailSTD125 extends GenericModelBase {
	
	public static final ModelRailSTD125 INSTANCE = new ModelRailSTD125();
	private static final int textureX = 256, textureY = 128;

	public ModelRailSTD125(){
		base = new ModelRendererTurbo[17];
		base[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
		base[1] = new ModelRendererTurbo(this, 97, 1, textureX, textureY); // Box 1
		base[2] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 2
		base[3] = new ModelRendererTurbo(this, 57, 1, textureX, textureY); // Box 3
		base[4] = new ModelRendererTurbo(this, 97, 1, textureX, textureY); // Box 4
		base[5] = new ModelRendererTurbo(this, 153, 1, textureX, textureY); // Box 5
		base[6] = new ModelRendererTurbo(this, 193, 1, textureX, textureY); // Box 6
		base[7] = new ModelRendererTurbo(this, 1, 9, textureX, textureY); // Box 7
		base[8] = new ModelRendererTurbo(this, 57, 9, textureX, textureY); // Box 8
		base[9] = new ModelRendererTurbo(this, 97, 9, textureX, textureY); // Box 9
		base[10] = new ModelRendererTurbo(this, 153, 9, textureX, textureY); // Box 10
		base[11] = new ModelRendererTurbo(this, 193, 9, textureX, textureY); // Box 11
		base[12] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 12
		base[13] = new ModelRendererTurbo(this, 57, 17, textureX, textureY); // Box 13
		base[14] = new ModelRendererTurbo(this, 233, 1, textureX, textureY); // Box 14
		base[15] = new ModelRendererTurbo(this, 1, 49, textureX, textureY); // Box 15
		base[16] = new ModelRendererTurbo(this, 241, 1, textureX, textureY); // Box 16
		base[0].addBox(2F, 0F, -20F, 4, 2, 40, 0F); // Box 0
		base[0].setRotationPoint(0F, -4F, 0F);
		base[1].addBox(-6F, 0F, -20F, 4, 2, 40, 0F); // Box 1
		base[1].setRotationPoint(0F, -4F, 0F);
		base[2].addShapeBox(0F, 0F, 0F, 16, 1, 3, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 2
		base[2].setRotationPoint(-8F, -5F, 14.5F);
		base[3].addShapeBox(0F, 0F, 0F, 16, 1, 3, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 3
		base[3].setRotationPoint(-8F, -5F, 14.5F);
		base[4].addBox(0F, 0F, 0F, 16, 2, 1, 0F); // Box 4
		base[4].setRotationPoint(-8F, -6.5F, 15.5F);
		base[5].addShapeBox(0F, 0F, 0F, 16, 1, 2, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 5
		base[5].setRotationPoint(-8F, -8F, 15F);
		base[6].addShapeBox(0F, 0F, 0F, 16, 1, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 6
		base[6].setRotationPoint(-8F, -7F, 15F);
		base[7].addShapeBox(0F, 0F, 0F, 16, 1, 2, 0F, 0F, -0.5F, -0.2F, 0F, -0.5F, -0.2F, 0F, -0.5F, -0.2F, 0F, -0.5F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 7
		base[7].setRotationPoint(-8F, -8.5F, 15F);
		base[8].addShapeBox(0F, 0F, 0F, 16, 1, 2, 0F, 0F, -0.5F, -0.2F, 0F, -0.5F, -0.2F, 0F, -0.5F, -0.2F, 0F, -0.5F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 8
		base[8].setRotationPoint(-8F, -8.5F, -17F);
		base[9].addShapeBox(0F, 0F, 0F, 16, 1, 2, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 9
		base[9].setRotationPoint(-8F, -8F, -17F);
		base[10].addShapeBox(0F, 0F, 0F, 16, 1, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 10
		base[10].setRotationPoint(-8F, -7F, -17F);
		base[11].addBox(0F, 0F, 0F, 16, 2, 1, 0F); // Box 11
		base[11].setRotationPoint(-8F, -6.5F, -16.5F);
		base[12].addShapeBox(0F, 0F, 0F, 16, 1, 3, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 12
		base[12].setRotationPoint(-8F, -5F, -17.5F);
		base[13].addShapeBox(0F, 0F, 0F, 16, 1, 3, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 13
		base[13].setRotationPoint(-8F, -5F, -17.5F);
		base[14].addBox(0F, 0F, 0F, 1, 8, 1, 0F); // Box 14
		base[14].setRotationPoint(0F, -8F, -15F);
		base[15].addShapeBox(0F, 0F, 0F, 16, 2, 48, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 15
		base[15].setRotationPoint(-8F, -2F, -24F);
		base[16].addBox(-1F, 0F, 0F, 1, 8, 1, 0F); // Box 16
		base[16].setRotationPoint(0F, -8F, 14F);
		translate(0F, 0F, 0F); flipAll();
	}
	
	private static final ResourceLocation texture = new ResourceLocation(FVTM.MODID, "textures/blocks/railstandard125.png");

	public static void bindTexture(){ bindTexture(texture); }
	
}