//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2017 Minecraft-SMP.de

// Model: C2R2T1 Wheel
// Model Creator: FEX___96
// Created on: 31.03.2017 - 14:38:29
// Last changed on: 31.03.2017 - 14:38:29

package net.fexcraft.mod.addons.fvp.models.part;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.part.PartModel;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.math.Pos;
import net.minecraft.entity.Entity;

public class ModelC2R2T1Wheel extends PartModel {
	
	int textureX = 128;
	int textureY = 64;

	public ModelC2R2T1Wheel(){
		this.creators.add("Ferdinand (FEX___96)");
		wheels = new ModelRendererTurbo[48];
		wheels[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 18
		wheels[1] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 19
		wheels[2] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 20
		wheels[3] = new ModelRendererTurbo(this, 41, 1, textureX, textureY); // Box 47
		wheels[4] = new ModelRendererTurbo(this, 57, 1, textureX, textureY); // Box 48
		wheels[5] = new ModelRendererTurbo(this, 73, 1, textureX, textureY); // Box 49
		wheels[6] = new ModelRendererTurbo(this, 89, 1, textureX, textureY); // Box 50
		wheels[7] = new ModelRendererTurbo(this, 105, 1, textureX, textureY); // Box 51
		wheels[8] = new ModelRendererTurbo(this, 1, 9, textureX, textureY); // Box 65
		wheels[9] = new ModelRendererTurbo(this, 17, 9, textureX, textureY); // Box 66
		wheels[10] = new ModelRendererTurbo(this, 33, 9, textureX, textureY); // Box 67
		wheels[11] = new ModelRendererTurbo(this, 49, 9, textureX, textureY); // Box 71
		wheels[12] = new ModelRendererTurbo(this, 65, 9, textureX, textureY); // Box 73
		wheels[13] = new ModelRendererTurbo(this, 81, 9, textureX, textureY); // Box 74
		wheels[14] = new ModelRendererTurbo(this, 97, 9, textureX, textureY); // Box 75
		wheels[15] = new ModelRendererTurbo(this, 113, 9, textureX, textureY); // Box 76
		wheels[16] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 77
		wheels[17] = new ModelRendererTurbo(this, 17, 17, textureX, textureY); // Box 78
		wheels[18] = new ModelRendererTurbo(this, 33, 17, textureX, textureY); // Box 79
		wheels[19] = new ModelRendererTurbo(this, 49, 17, textureX, textureY); // Box 81
		wheels[20] = new ModelRendererTurbo(this, 65, 17, textureX, textureY); // Box 82
		wheels[21] = new ModelRendererTurbo(this, 81, 17, textureX, textureY); // Box 83
		wheels[22] = new ModelRendererTurbo(this, 97, 17, textureX, textureY); // Box 84
		wheels[23] = new ModelRendererTurbo(this, 113, 17, textureX, textureY); // Box 85
		wheels[24] = new ModelRendererTurbo(this, 1, 25, textureX, textureY); // Box 86
		wheels[25] = new ModelRendererTurbo(this, 17, 25, textureX, textureY); // Box 87
		wheels[26] = new ModelRendererTurbo(this, 33, 25, textureX, textureY); // Box 88
		wheels[27] = new ModelRendererTurbo(this, 49, 25, textureX, textureY); // Box 89
		wheels[28] = new ModelRendererTurbo(this, 49, 25, textureX, textureY); // Box 90
		wheels[29] = new ModelRendererTurbo(this, 49, 25, textureX, textureY); // Box 91
		wheels[30] = new ModelRendererTurbo(this, 49, 25, textureX, textureY); // Box 92
		wheels[31] = new ModelRendererTurbo(this, 49, 25, textureX, textureY); // Box 94
		wheels[32] = new ModelRendererTurbo(this, 9, 25, textureX, textureY); // Box 96
		wheels[33] = new ModelRendererTurbo(this, 25, 25, textureX, textureY); // Box 97
		wheels[34] = new ModelRendererTurbo(this, 41, 25, textureX, textureY); // Box 98
		wheels[35] = new ModelRendererTurbo(this, 65, 25, textureX, textureY); // Box 99
		wheels[36] = new ModelRendererTurbo(this, 81, 25, textureX, textureY); // Box 100
		wheels[37] = new ModelRendererTurbo(this, 97, 25, textureX, textureY); // Box 101
		wheels[38] = new ModelRendererTurbo(this, 113, 25, textureX, textureY); // Box 102
		wheels[39] = new ModelRendererTurbo(this, 1, 33, textureX, textureY); // Box 103
		wheels[40] = new ModelRendererTurbo(this, 121, 1, textureX, textureY); // Box 104
		wheels[41] = new ModelRendererTurbo(this, 17, 33, textureX, textureY); // Box 105
		wheels[42] = new ModelRendererTurbo(this, 25, 33, textureX, textureY); // Box 106
		wheels[43] = new ModelRendererTurbo(this, 33, 33, textureX, textureY); // Box 107
		wheels[44] = new ModelRendererTurbo(this, 41, 33, textureX, textureY); // Box 108
		wheels[45] = new ModelRendererTurbo(this, 49, 33, textureX, textureY); // Box 109
		wheels[46] = new ModelRendererTurbo(this, 57, 33, textureX, textureY); // Box 111
		wheels[47] = new ModelRendererTurbo(this, 65, 33, textureX, textureY); // Box 112

		wheels[0].addBox(-1.5F, -1.5F, -1F, 3, 3, 2, 0F); // Box 18
		wheels[0].setRotationPoint(0F, 0F, 0F);

		wheels[1].addBox(-1F, -1F, -2F, 2, 2, 1, 0F); // Box 19
		wheels[1].setRotationPoint(0F, 0F, 0F);

		wheels[2].addShapeBox(-1.5F, -1.5F, 1F, 3, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, -0.75F, -0.5F, -0.75F, -0.75F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, -0.75F, -0.5F, -0.75F, -0.75F, -0.5F); // Box 20
		wheels[2].setRotationPoint(0F, 0F, 0F);

		wheels[3].addShapeBox(0F, 6F, -2.5F, 3, 2, 4, 0F, 0F, 0F, 0F, -0.7F, 0.45F, 0F, -0.7F, 0.45F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.06F, -0.6F, 0F, 0.06F, -0.6F, 0F, 0F, 0F, 0F); // Box 47
		wheels[3].setRotationPoint(0F, 0F, 0F);

		wheels[4].addShapeBox(-3F, 6F, -2.5F, 3, 2, 4, 0F, -0.7F, 0.45F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.7F, 0.45F, 0F, 0.06F, -0.6F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.06F, -0.6F, 0F); // Box 48
		wheels[4].setRotationPoint(0F, 0F, 0F);

		wheels[5].addShapeBox(0F, -8F, -2.5F, 3, 2, 4, 0F, 0F, 0F, 0F, 0.06F, -0.6F, 0F, 0.06F, -0.6F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.7F, 0.45F, 0F, -0.7F, 0.45F, 0F, 0F, 0F, 0F); // Box 49
		wheels[5].setRotationPoint(0F, 0F, 0F);

		wheels[6].addShapeBox(-3F, -8F, -2.5F, 3, 2, 4, 0F, 0.06F, -0.6F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.06F, -0.6F, 0F, -0.7F, 0.45F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.7F, 0.45F, 0F); // Box 50
		wheels[6].setRotationPoint(0F, 0F, 0F);

		wheels[7].addShapeBox(6F, 0F, -2.5F, 2, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.45F, -0.7F, 0F, -0.6F, 0.06F, 0F, -0.6F, 0.06F, 0F, 0.45F, -0.7F, 0F); // Box 51
		wheels[7].setRotationPoint(0F, 0F, 0F);

		wheels[8].addShapeBox(6F, -3F, -2.5F, 2, 3, 4, 0F, 0.45F, -0.7F, 0F, -0.6F, 0.06F, 0F, -0.6F, 0.06F, 0F, 0.45F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 65
		wheels[8].setRotationPoint(0F, 0F, 0F);

		wheels[9].addShapeBox(-8F, -3F, -2.5F, 2, 3, 4, 0F, -0.6F, 0.06F, 0F, 0.45F, -0.7F, 0F, 0.45F, -0.7F, 0F, -0.6F, 0.06F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 66
		wheels[9].setRotationPoint(0F, 0F, 0F);

		wheels[10].addShapeBox(-8F, 0F, -2.5F, 2, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.6F, 0.06F, 0F, 0.45F, -0.7F, 0F, 0.45F, -0.7F, 0F, -0.6F, 0.06F, 0F); // Box 67
		wheels[10].setRotationPoint(0F, 0F, 0F);

		wheels[11].addShapeBox(3F, 5F, -2.5F, 3, 2, 4, 0F, 0.7F, -0.55F, 0F, -1.8F, 0.8F, 0F, -1.8F, 0.8F, 0F, 0.7F, -0.55F, 0F, -0.05F, 0.4F, 0F, -0.35F, -1.35F, 0F, -0.35F, -1.35F, 0F, -0.05F, 0.4F, 0F); // Box 71
		wheels[11].setRotationPoint(0F, 0F, 0F);

		wheels[12].addShapeBox(5F, 3F, -2.5F, 2, 3, 4, 0F, -0.55F, 0.7F, 0F, 0.4F, -0.05F, 0F, 0.4F, -0.05F, 0F, -0.55F, 0.7F, 0F, 0.8F, -1.8F, 0F, -1.35F, -0.35F, 0F, -1.35F, -0.35F, 0F, 0.8F, -1.8F, 0F); // Box 73
		wheels[12].setRotationPoint(0F, 0F, 0F);

		wheels[13].addShapeBox(3F, -7F, -2.5F, 3, 2, 4, 0F, -0.05F, 0.4F, 0F, -0.35F, -1.35F, 0F, -0.35F, -1.35F, 0F, -0.05F, 0.4F, 0F, 0.7F, -0.55F, 0F, -1.8F, 0.8F, 0F, -1.8F, 0.8F, 0F, 0.7F, -0.55F, 0F); // Box 74
		wheels[13].setRotationPoint(0F, 0F, 0F);

		wheels[14].addShapeBox(-6F, -7F, -2.5F, 3, 2, 4, 0F, -0.35F, -1.35F, 0F, -0.05F, 0.4F, 0F, -0.05F, 0.4F, 0F, -0.35F, -1.35F, 0F, -1.8F, 0.8F, 0F, 0.7F, -0.55F, 0F, 0.7F, -0.55F, 0F, -1.8F, 0.8F, 0F); // Box 75
		wheels[14].setRotationPoint(0F, 0F, 0F);

		wheels[15].addShapeBox(-6F, 5F, -2.5F, 3, 2, 4, 0F, -1.8F, 0.8F, 0F, 0.7F, -0.55F, 0F, 0.7F, -0.55F, 0F, -1.8F, 0.8F, 0F, -0.35F, -1.35F, 0F, -0.05F, 0.4F, 0F, -0.05F, 0.4F, 0F, -0.35F, -1.35F, 0F); // Box 76
		wheels[15].setRotationPoint(0F, 0F, 0F);

		wheels[16].addShapeBox(-7F, 3F, -2.5F, 2, 3, 4, 0F, 0.4F, -0.05F, 0F, -0.55F, 0.7F, 0F, -0.55F, 0.7F, 0F, 0.4F, -0.05F, 0F, -1.35F, -0.35F, 0F, 0.8F, -1.8F, 0F, 0.8F, -1.8F, 0F, -1.35F, -0.35F, 0F); // Box 77
		wheels[16].setRotationPoint(0F, 0F, 0F);

		wheels[17].addShapeBox(-7F, -6F, -2.5F, 2, 3, 4, 0F, -1.35F, -0.35F, 0F, 0.8F, -1.8F, 0F, 0.8F, -1.8F, 0F, -1.35F, -0.35F, 0F, 0.4F, -0.05F, 0F, -0.55F, 0.7F, 0F, -0.55F, 0.7F, 0F, 0.4F, -0.05F, 0F); // Box 78
		wheels[17].setRotationPoint(0F, 0F, 0F);

		wheels[18].addShapeBox(5F, -6F, -2.5F, 2, 3, 4, 0F, 0.8F, -1.8F, 0F, -1.35F, -0.35F, 0F, -1.35F, -0.35F, 0F, 0.8F, -1.8F, 0F, -0.55F, 0.7F, 0F, 0.4F, -0.05F, 0F, 0.4F, -0.05F, 0F, -0.55F, 0.7F, 0F); // Box 79
		wheels[18].setRotationPoint(0F, 0F, 0F);

		wheels[19].addShapeBox(0F, 5F, -2.5F, 3, 1, 4, 0F, 0F, 0F, -0.2F, -0.7F, 0.45F, -0.2F, -0.7F, 0.45F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.1F, 0.06F, -0.6F, -0.1F, 0.06F, -0.6F, -0.1F, 0F, 0F, -0.1F); // Box 81
		wheels[19].setRotationPoint(0F, 0F, 0F);

		wheels[20].addShapeBox(-3F, 5F, -2.5F, 3, 1, 4, 0F, -0.7F, 0.45F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, -0.7F, 0.45F, -0.2F, 0.06F, -0.6F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0.06F, -0.6F, -0.1F); // Box 82
		wheels[20].setRotationPoint(0F, 0F, 0F);

		wheels[21].addShapeBox(-3F, -6F, -2.5F, 3, 1, 4, 0F, 0.06F, -0.6F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0.06F, -0.6F, -0.1F, -0.7F, 0.45F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, -0.7F, 0.45F, -0.2F); // Box 83
		wheels[21].setRotationPoint(0F, 0F, 0F);

		wheels[22].addShapeBox(0F, -6F, -2.5F, 3, 1, 4, 0F, 0F, 0F, -0.1F, 0.06F, -0.6F, -0.1F, 0.06F, -0.6F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.2F, -0.7F, 0.45F, -0.2F, -0.7F, 0.45F, -0.2F, 0F, 0F, -0.2F); // Box 84
		wheels[22].setRotationPoint(0F, 0F, 0F);

		wheels[23].addShapeBox(5F, -3F, -2.5F, 1, 3, 4, 0F, 0.45F, -0.7F, -0.2F, -0.6F, 0.06F, -0.1F, -0.6F, 0.06F, -0.1F, 0.45F, -0.7F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.2F); // Box 85
		wheels[23].setRotationPoint(0F, 0F, 0F);

		wheels[24].addShapeBox(5F, 0F, -2.5F, 1, 3, 4, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.2F, 0.45F, -0.7F, -0.2F, -0.6F, 0.06F, -0.1F, -0.6F, 0.06F, -0.1F, 0.45F, -0.7F, -0.2F); // Box 86
		wheels[24].setRotationPoint(0F, 0F, 0F);

		wheels[25].addShapeBox(-6F, -3F, -2.5F, 1, 3, 4, 0F, -0.6F, 0.06F, -0.1F, 0.45F, -0.7F, -0.2F, 0.45F, -0.7F, -0.2F, -0.6F, 0.06F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.1F); // Box 87
		wheels[25].setRotationPoint(0F, 0F, 0F);

		wheels[26].addShapeBox(-6F, 0F, -2.5F, 1, 3, 4, 0F, 0F, 0F, -0.1F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.1F, -0.6F, 0.06F, -0.1F, 0.45F, -0.7F, -0.2F, 0.45F, -0.7F, -0.2F, -0.6F, 0.06F, -0.1F); // Box 88
		wheels[26].setRotationPoint(0F, 0F, 0F);

		wheels[27].addShapeBox(2F, 4F, -2.5F, 3, 1, 4, 0F, -0.2F, -0.6F, -0.2F, -0.45F, 1.7F, -0.2F, -0.45F, 1.7F, -0.2F, -0.2F, -0.6F, -0.2F, -1F, 0.3F, -0.1F, 0.4F, -2F, -0.1F, 0.4F, -2F, -0.1F, -1F, 0.3F, -0.1F); // Box 89
		wheels[27].setRotationPoint(0F, 0F, 0F);

		wheels[28].addShapeBox(2F, -5F, -2.5F, 3, 1, 4, 0F, -1F, 0.3F, -0.1F, 0.4F, -2F, -0.1F, 0.4F, -2F, -0.1F, -1F, 0.3F, -0.1F, -0.2F, -0.6F, -0.2F, -0.45F, 1.7F, -0.2F, -0.45F, 1.7F, -0.2F, -0.2F, -0.6F, -0.2F); // Box 90
		wheels[28].setRotationPoint(0F, 0F, 0F);

		wheels[29].addShapeBox(2F, -5F, -2.5F, 3, 1, 4, 0F, -1F, 0.3F, -0.1F, 0.4F, -2F, -0.1F, 0.4F, -2F, -0.1F, -1F, 0.3F, -0.1F, -0.2F, -0.6F, -0.2F, -0.5F, 1.7F, -0.2F, -0.5F, 1.7F, -0.2F, -0.2F, -0.6F, -0.2F); // Box 91
		wheels[29].setRotationPoint(0F, 0F, 0F);

		wheels[30].addShapeBox(-5.6F, -3.6F, -2.5F, 3, 1, 4, 0F, -0.2F, -0.6F, -0.1F, -0.5F, 1.7F, -0.1F, -0.5F, 1.7F, -0.1F, -0.2F, -0.6F, -0.1F, -1.05F, 0.3F, -0.2F, 0.4F, -2F, -0.2F, 0.4F, -2F, -0.2F, -1.05F, 0.3F, -0.2F); // Box 92
		wheels[30].setRotationPoint(0F, 0F, 0F);

		wheels[31].addShapeBox(-5.6F, 2.6F, -2.5F, 3, 1, 4, 0F, -1.05F, 0.3F, -0.2F, 0.4F, -2F, -0.2F, 0.4F, -2F, -0.2F, -1.05F, 0.3F, -0.2F, -0.2F, -0.6F, -0.1F, -0.5F, 1.7F, -0.1F, -0.5F, 1.7F, -0.1F, -0.2F, -0.6F, -0.1F); // Box 94
		wheels[31].setRotationPoint(0F, 0F, 0F);

		wheels[32].addShapeBox(-1.5F, 2.5F, 0F, 3, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 96
		wheels[32].setRotationPoint(0F, 0F, 0F);

		wheels[33].addShapeBox(-1.5F, 4.5F, -1F, 3, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 97
		wheels[33].setRotationPoint(0F, 0F, 0F);

		wheels[34].addShapeBox(-1.5F, 1.5F, -0.5F, 3, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 98
		wheels[34].setRotationPoint(0F, 0F, 0F);

		wheels[35].addShapeBox(-1.5F, 3.5F, 0F, 3, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1.5F, 0F, 0F, -1.5F); // Box 99
		wheels[35].setRotationPoint(0F, 0F, 0F);

		wheels[36].addShapeBox(-1.5F, -2.5F, -0.5F, 3, 1, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 100
		wheels[36].setRotationPoint(0F, 0F, 0F);

		wheels[37].addShapeBox(-1.5F, -3.5F, 0F, 3, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 101
		wheels[37].setRotationPoint(0F, 0F, 0F);

		wheels[38].addShapeBox(-1.5F, -4.5F, 0F, 3, 1, 1, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1.5F, 0F, 0F, -1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 102
		wheels[38].setRotationPoint(0F, 0F, 0F);

		wheels[39].addShapeBox(-1.5F, -5.5F, -1F, 3, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 103
		wheels[39].setRotationPoint(0F, 0F, 0F);

		wheels[40].addShapeBox(2.5F, -1.5F, 0F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 104
		wheels[40].setRotationPoint(0F, 0F, 0F);

		wheels[41].addShapeBox(1.5F, -1.5F, -0.5F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, -0.5F); // Box 105
		wheels[41].setRotationPoint(0F, 0F, 0F);

		wheels[42].addShapeBox(4.5F, -1.5F, -1F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 106
		wheels[42].setRotationPoint(0F, 0F, 0F);

		wheels[43].addShapeBox(3.5F, -1.5F, -1F, 1, 3, 1, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, 0.5F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, 0.5F); // Box 107
		wheels[43].setRotationPoint(0F, 0F, 0F);

		wheels[44].addShapeBox(-2.5F, -1.5F, -0.5F, 1, 3, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, 0F); // Box 108
		wheels[44].setRotationPoint(0F, 0F, 0F);

		wheels[45].addShapeBox(-3.5F, -1.5F, 0F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 109
		wheels[45].setRotationPoint(0F, 0F, 0F);

		wheels[46].addShapeBox(-4.5F, -1.5F, -1F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0.5F, 0F, 0F, -0.5F); // Box 111
		wheels[46].setRotationPoint(0F, 0F, 0F);

		wheels[47].addShapeBox(-5.5F, -1.5F, -1F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 112
		wheels[47].setRotationPoint(0F, 0F, 0F);

		//translateAll(0F, 0F, 0F);

		//flipAll();
	}
	
	private static final Pos leftfront  = new Pos( 29.5f, -7.5f, -22f);
	private static final Pos rightfront = new Pos( 29.5f, -7.5f,  22f);
	private static final Pos leftback   = new Pos(-59.5f, -7.5f, -22f);
	private static final Pos rightback  = new Pos(-59.5f, -7.5f,  22f);
	
	@Override
	public void render(VehicleData data, String us){
		switch(us){
			case "right_front_wheel":{
				leftfront.translate();
				GL11.glRotated( 180, 0, 1, 0);
				render(wheels);
				GL11.glRotated(-180, 0, 1, 0);
				leftfront.translateR();
				break;
			}
			case "left_front_wheel":{
				rightfront.translate();
				render(wheels);
				rightfront.translateR();
				break;
			}
			case "right_back_wheel":{
				leftback.translate();
				GL11.glRotated( 180, 0, 1, 0);
				render(wheels);
				GL11.glRotated(-180, 0, 1, 0);
				leftback.translateR();
				break;
			}
			case "left_back_wheel":{
				rightback.translate();
				render(wheels);
				rightback.translateR();
				break;
			}
			default: return;
		}
	}
	
	@Override
	public void render(VehicleData data, String us, Entity veh){
		com.flansmod.fvtm.LandVehicle vehicle = (com.flansmod.fvtm.LandVehicle)veh;
		switch(us){
			case "right_front_wheel":{
				leftfront.translate();
				GL11.glRotated( 180, 0, 1, 0);
				for(ModelRendererTurbo element : wheels){
					element.rotateAngleZ = vehicle.wheelsAngle;
					element.rotateAngleY = vehicle.wheelsYaw * Static.rad180 / 180F * 3F;
					element.render();
					element.rotateAngleY = 0;
				}
				GL11.glRotated(-180, 0, 1, 0);
				leftfront.translateR();
				break;
			}
			case "left_front_wheel":{
				rightfront.translate();
				for(ModelRendererTurbo element : wheels){
					element.rotateAngleZ = vehicle.wheelsAngle;
					element.rotateAngleY = vehicle.wheelsYaw * Static.rad180 / 180F * 3F;
					element.render();
					element.rotateAngleY = 0;
				}
				rightfront.translateR();
				break;
			}
			case "right_back_wheel":{
				leftback.translate();
				GL11.glRotated( 180, 0, 1, 0);
				for(ModelRendererTurbo element : wheels){
					element.rotateAngleZ = vehicle.wheelsAngle;
					element.render();
				}
				GL11.glRotated(-180, 0, 1, 0);
				leftback.translateR();
				break;
			}
			case "left_back_wheel":{
				rightback.translate();
				for(ModelRendererTurbo element : wheels){
					element.rotateAngleZ = vehicle.wheelsAngle;
					element.render();
				}
				rightback.translateR();
				break;
			}
			default: return;
		}
	}
	
}