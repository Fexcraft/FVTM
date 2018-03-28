//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2017 Minecraft-SMP.de

// Model: 
// Model Creator: 
// Created on: 05.12.2017 - 18:43:59
// Last changed on: 05.12.2017 - 18:43:59

package net.fexcraft.mod.addons.fvp.models.container;

import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.api.Container.ContainerPosition;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.container.ContainerModel;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.entity.Entity;

public class DefaultFVPMediumContainer extends ContainerModel<ContainerData> {
	

	public ModelRendererTurbo lock[] = new ModelRendererTurbo[0];
	
	int textureX = 512;
	int textureY = 512;

	public DefaultFVPMediumContainer(){
		body = new ModelRendererTurbo[91];
		body[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
		body[1] = new ModelRendererTurbo(this, 57, 1, textureX, textureY); // Box 1
		body[2] = new ModelRendererTurbo(this, 201, 1, textureX, textureY); // Box 2
		body[3] = new ModelRendererTurbo(this, 257, 1, textureX, textureY); // Box 3
		body[4] = new ModelRendererTurbo(this, 57, 9, textureX, textureY); // Box 4
		body[5] = new ModelRendererTurbo(this, 257, 9, textureX, textureY); // Box 5
		body[6] = new ModelRendererTurbo(this, 449, 1, textureX, textureY); // Box 6
		body[7] = new ModelRendererTurbo(this, 449, 9, textureX, textureY); // Box 7
		body[8] = new ModelRendererTurbo(this, 57, 17, textureX, textureY); // Box 8
		body[9] = new ModelRendererTurbo(this, 137, 17, textureX, textureY); // Box 9
		body[10] = new ModelRendererTurbo(this, 193, 17, textureX, textureY); // Box 10
		body[11] = new ModelRendererTurbo(this, 257, 17, textureX, textureY); // Box 11
		body[12] = new ModelRendererTurbo(this, 1, 57, textureX, textureY); // Box 12
		body[13] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 13
		body[14] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 14
		body[15] = new ModelRendererTurbo(this, 33, 1, textureX, textureY); // Box 15
		body[16] = new ModelRendererTurbo(this, 337, 17, textureX, textureY); // Box 16
		body[17] = new ModelRendererTurbo(this, 305, 17, textureX, textureY); // Box 17
		body[18] = new ModelRendererTurbo(this, 409, 17, textureX, textureY); // Box 18
		body[19] = new ModelRendererTurbo(this, 57, 25, textureX, textureY); // Box 20
		body[20] = new ModelRendererTurbo(this, 57, 33, textureX, textureY); // Box 21
		body[21] = new ModelRendererTurbo(this, 281, 73, textureX, textureY); // Box 22
		body[22] = new ModelRendererTurbo(this, 1, 105, textureX, textureY); // Box 23
		body[23] = new ModelRendererTurbo(this, 153, 121, textureX, textureY); // Box 24
		body[24] = new ModelRendererTurbo(this, 385, 129, textureX, textureY); // Box 25
		body[25] = new ModelRendererTurbo(this, 457, 97, textureX, textureY); // Box 26
		body[26] = new ModelRendererTurbo(this, 1, 153, textureX, textureY); // Box 27
		body[27] = new ModelRendererTurbo(this, 505, 1, textureX, textureY); // Box 28
		body[28] = new ModelRendererTurbo(this, 361, 17, textureX, textureY); // Box 29
		body[29] = new ModelRendererTurbo(this, 369, 17, textureX, textureY); // Box 30
		body[30] = new ModelRendererTurbo(this, 377, 17, textureX, textureY); // Box 31
		body[31] = new ModelRendererTurbo(this, 385, 17, textureX, textureY); // Box 32
		body[32] = new ModelRendererTurbo(this, 393, 17, textureX, textureY); // Box 33
		body[33] = new ModelRendererTurbo(this, 401, 17, textureX, textureY); // Box 34
		body[34] = new ModelRendererTurbo(this, 409, 17, textureX, textureY); // Box 35
		body[35] = new ModelRendererTurbo(this, 417, 17, textureX, textureY); // Box 36
		body[36] = new ModelRendererTurbo(this, 425, 17, textureX, textureY); // Box 37
		body[37] = new ModelRendererTurbo(this, 433, 17, textureX, textureY); // Box 38
		body[38] = new ModelRendererTurbo(this, 441, 17, textureX, textureY); // Box 39
		body[39] = new ModelRendererTurbo(this, 449, 17, textureX, textureY); // Box 40
		body[40] = new ModelRendererTurbo(this, 465, 17, textureX, textureY); // Box 41
		body[41] = new ModelRendererTurbo(this, 473, 17, textureX, textureY); // Box 42
		body[42] = new ModelRendererTurbo(this, 481, 17, textureX, textureY); // Box 43
		body[43] = new ModelRendererTurbo(this, 489, 17, textureX, textureY); // Box 44
		body[44] = new ModelRendererTurbo(this, 497, 17, textureX, textureY); // Box 45
		body[45] = new ModelRendererTurbo(this, 489, 73, textureX, textureY); // Box 46
		body[46] = new ModelRendererTurbo(this, 497, 73, textureX, textureY); // Box 47
		body[47] = new ModelRendererTurbo(this, 505, 73, textureX, textureY); // Box 48
		body[48] = new ModelRendererTurbo(this, 433, 121, textureX, textureY); // Box 49
		body[49] = new ModelRendererTurbo(this, 441, 121, textureX, textureY); // Box 50
		body[50] = new ModelRendererTurbo(this, 449, 121, textureX, textureY); // Box 52
		body[51] = new ModelRendererTurbo(this, 505, 121, textureX, textureY); // Box 53
		body[52] = new ModelRendererTurbo(this, 49, 153, textureX, textureY); // Box 54
		body[53] = new ModelRendererTurbo(this, 57, 153, textureX, textureY); // Box 55
		body[54] = new ModelRendererTurbo(this, 65, 153, textureX, textureY); // Box 56
		body[55] = new ModelRendererTurbo(this, 73, 153, textureX, textureY); // Box 57
		body[56] = new ModelRendererTurbo(this, 81, 153, textureX, textureY); // Box 58
		body[57] = new ModelRendererTurbo(this, 473, 73, textureX, textureY); // Box 59
		body[58] = new ModelRendererTurbo(this, 89, 153, textureX, textureY); // Box 60
		body[59] = new ModelRendererTurbo(this, 97, 153, textureX, textureY); // Box 61
		body[60] = new ModelRendererTurbo(this, 105, 153, textureX, textureY); // Box 62
		body[61] = new ModelRendererTurbo(this, 113, 153, textureX, textureY); // Box 63
		body[62] = new ModelRendererTurbo(this, 121, 153, textureX, textureY); // Box 64
		body[63] = new ModelRendererTurbo(this, 129, 153, textureX, textureY); // Box 65
		body[64] = new ModelRendererTurbo(this, 137, 153, textureX, textureY); // Box 66
		body[65] = new ModelRendererTurbo(this, 145, 153, textureX, textureY); // Box 67
		body[66] = new ModelRendererTurbo(this, 113, 169, textureX, textureY); // Box 68
		body[67] = new ModelRendererTurbo(this, 209, 169, textureX, textureY); // Box 69
		body[68] = new ModelRendererTurbo(this, 265, 177, textureX, textureY); // Box 70
		body[69] = new ModelRendererTurbo(this, 321, 185, textureX, textureY); // Box 71
		body[70] = new ModelRendererTurbo(this, 9, 201, textureX, textureY); // Box 72
		body[71] = new ModelRendererTurbo(this, 65, 217, textureX, textureY); // Box 73
		body[72] = new ModelRendererTurbo(this, 161, 217, textureX, textureY); // Box 74
		body[73] = new ModelRendererTurbo(this, 377, 217, textureX, textureY); // Box 75
		body[74] = new ModelRendererTurbo(this, 217, 225, textureX, textureY); // Box 76
		body[75] = new ModelRendererTurbo(this, 273, 233, textureX, textureY); // Box 77
		body[76] = new ModelRendererTurbo(this, 1, 249, textureX, textureY); // Box 78
		body[77] = new ModelRendererTurbo(this, 57, 265, textureX, textureY); // Box 79
		body[78] = new ModelRendererTurbo(this, 153, 265, textureX, textureY); // Box 80
		body[79] = new ModelRendererTurbo(this, 329, 265, textureX, textureY); // Box 81
		body[80] = new ModelRendererTurbo(this, 209, 273, textureX, textureY); // Box 82
		body[81] = new ModelRendererTurbo(this, 385, 273, textureX, textureY); // Box 83
		body[82] = new ModelRendererTurbo(this, 281, 33, textureX, textureY); // Box 84
		body[83] = new ModelRendererTurbo(this, 233, 57, textureX, textureY); // Box 85
		body[84] = new ModelRendererTurbo(this, 161, 169, textureX, textureY); // Box 86
		body[85] = new ModelRendererTurbo(this, 457, 201, textureX, textureY); // Box 87
		body[86] = new ModelRendererTurbo(this, 193, 185, textureX, textureY); // Box 88
		body[87] = new ModelRendererTurbo(this, 121, 217, textureX, textureY); // Box 89
		body[88] = new ModelRendererTurbo(this, 153, 225, textureX, textureY); // Box 90
		body[89] = new ModelRendererTurbo(this, 449, 241, textureX, textureY); // Box 91
		body[90] = new ModelRendererTurbo(this, 321, 169, textureX, textureY); // Box 51

		body[0].addBox(0F, 0F, 0F, 2, 3, 48, 0F); // Box 0
		body[0].setRotationPoint(-48F, -3F, -24F);

		body[1].addBox(0F, 0F, 0F, 92, 1, 2, 0F); // Box 1
		body[1].setRotationPoint(-46F, -1F, -24F);

		body[2].addBox(0F, 0F, 0F, 2, 3, 48, 0F); // Box 2
		body[2].setRotationPoint(46F, -3F, -24F);

		body[3].addBox(0F, 0F, 0F, 92, 1, 2, 0F); // Box 3
		body[3].setRotationPoint(-46F, -1F, 22F);

		body[4].addBox(0F, 0F, 0F, 92, 1, 2, 0F); // Box 4
		body[4].setRotationPoint(-46F, -3F, -24F);

		body[5].addBox(0F, 0F, 0F, 92, 1, 2, 0F); // Box 5
		body[5].setRotationPoint(-46F, -3F, 22F);

		body[6].addBox(0F, 0F, 0F, 24, 1, 2, 0F); // Box 6
		body[6].setRotationPoint(-46F, -2F, 22F);

		body[7].addBox(0F, 0F, 0F, 24, 1, 2, 0F); // Box 7
		body[7].setRotationPoint(22F, -2F, 22F);

		body[8].addBox(0F, 0F, 0F, 36, 1, 2, 0F); // Box 8
		body[8].setRotationPoint(-18F, -2F, 22F);

		body[9].addBox(0F, 0F, 0F, 24, 1, 2, 0F); // Box 9
		body[9].setRotationPoint(-46F, -2F, -24F);

		body[10].addBox(0F, 0F, 0F, 24, 1, 2, 0F); // Box 10
		body[10].setRotationPoint(22F, -2F, -24F);

		body[11].addBox(0F, 0F, 0F, 36, 1, 2, 0F); // Box 11
		body[11].setRotationPoint(-18F, -2F, -24F);

		body[12].addBox(0F, 0F, 0F, 92, 1, 44, 0F); // Box 12
		body[12].setRotationPoint(-46F, -3F, -22F);

		body[13].addBox(0F, 0F, 0F, 2, 43, 2, 0F); // Box 13
		body[13].setRotationPoint(-48F, -46F, -24F);

		body[14].addBox(0F, 0F, 0F, 2, 43, 2, 0F); // Box 14
		body[14].setRotationPoint(-48F, -46F, 22F);

		body[15].addBox(0F, 0F, 0F, 2, 43, 2, 0F); // Box 15
		body[15].setRotationPoint(46F, -46F, 22F);

		body[16].addBox(0F, 0F, 0F, 2, 43, 2, 0F); // Box 16
		body[16].setRotationPoint(46F, -46F, -24F);

		body[17].addBox(0F, 0F, 0F, 2, 2, 48, 0F); // Box 17
		body[17].setRotationPoint(46F, -48F, -24F);

		body[18].addBox(0F, 0F, 0F, 2, 2, 48, 0F); // Box 18
		body[18].setRotationPoint(-48F, -48F, -24F);

		body[19].addBox(0F, 0F, 0F, 92, 2, 2, 0F); // Box 20
		body[19].setRotationPoint(-46F, -48F, -24F);

		body[20].addBox(0F, 0F, 0F, 92, 2, 2, 0F); // Box 21
		body[20].setRotationPoint(-46F, -48F, 22F);

		body[21].addBox(0F, 0F, 0F, 94, 43, 1, 0F); // Box 22
		body[21].setRotationPoint(-46F, -46F, -23.5F);

		body[22].addBox(0F, 0F, 0F, 94, 43, 1, 0F); // Box 23
		body[22].setRotationPoint(-46F, -46F, 22.5F);

		body[23].addBox(0F, 0F, 0F, 92, 1, 44, 0F); // Box 24
		body[23].setRotationPoint(-46F, -47.5F, -22F);

		body[24].addBox(0F, 0F, 0F, 1, 43, 44, 0F); // Box 25
		body[24].setRotationPoint(46.5F, -46F, -22F);

		body[25].addBox(0F, 0F, 0F, 1, 44, 22, 0F); // Box 26
		body[25].setRotationPoint(-47.5F, -46F, 0F);

		body[26].addBox(0F, 0F, 22F, 1, 44, 22, 0F); // Box 27
		body[26].setRotationPoint(-47.5F, -46F, -44F);

		body[27].addShapeBox(0F, 0F, 0F, 1, 43, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F); // Box 28
		body[27].setRotationPoint(-46F, -46F, -24F);

		body[28].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F); // Box 29
		body[28].setRotationPoint(-41F, -46F, -24F);

		body[29].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F); // Box 30
		body[29].setRotationPoint(-35F, -46F, -24F);

		body[30].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F); // Box 31
		body[30].setRotationPoint(-29F, -46F, -24F);

		body[31].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F); // Box 32
		body[31].setRotationPoint(-23F, -46F, -24F);

		body[32].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F); // Box 33
		body[32].setRotationPoint(-17F, -46F, -24F);

		body[33].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F); // Box 34
		body[33].setRotationPoint(-11F, -46F, -24F);

		body[34].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F); // Box 35
		body[34].setRotationPoint(-5F, -46F, -24F);

		body[35].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F); // Box 36
		body[35].setRotationPoint(3F, -46F, -24F);

		body[36].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F); // Box 37
		body[36].setRotationPoint(9F, -46F, -24F);

		body[37].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F); // Box 38
		body[37].setRotationPoint(15F, -46F, -24F);

		body[38].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F); // Box 39
		body[38].setRotationPoint(21F, -46F, -24F);

		body[39].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F); // Box 40
		body[39].setRotationPoint(27F, -46F, -24F);

		body[40].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F); // Box 41
		body[40].setRotationPoint(33F, -46F, -24F);

		body[41].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F); // Box 42
		body[41].setRotationPoint(39F, -46F, -24F);

		body[42].addShapeBox(0F, 0F, 0F, 1, 43, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F); // Box 43
		body[42].setRotationPoint(45F, -46F, -24F);

		body[43].addShapeBox(0F, 0F, 0F, 1, 43, 1, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 44
		body[43].setRotationPoint(-46F, -46F, 23F);

		body[44].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 45
		body[44].setRotationPoint(-41F, -46F, 23F);

		body[45].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 46
		body[45].setRotationPoint(-35F, -46F, 23F);

		body[46].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 47
		body[46].setRotationPoint(-29F, -46F, 23F);

		body[47].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 48
		body[47].setRotationPoint(-23F, -46F, 23F);

		body[48].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 49
		body[48].setRotationPoint(-17F, -46F, 23F);

		body[49].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 50
		body[49].setRotationPoint(-11F, -46F, 23F);

		body[50].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 52
		body[50].setRotationPoint(3F, -46F, 23F);

		body[51].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 53
		body[51].setRotationPoint(9F, -46F, 23F);

		body[52].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 54
		body[52].setRotationPoint(15F, -46F, 23F);

		body[53].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 55
		body[53].setRotationPoint(21F, -46F, 23F);

		body[54].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 56
		body[54].setRotationPoint(27F, -46F, 23F);

		body[55].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 57
		body[55].setRotationPoint(33F, -46F, 23F);

		body[56].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 58
		body[56].setRotationPoint(39F, -46F, 23F);

		body[57].addShapeBox(0F, 0F, 0F, 1, 43, 1, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 59
		body[57].setRotationPoint(45F, -46F, 23F);

		body[58].addShapeBox(0F, 0F, 0F, 1, 43, 1, 0F, -0.5F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 1F); // Box 60
		body[58].setRotationPoint(47F, -46F, -22F);

		body[59].addShapeBox(0F, 0F, 0F, 1, 43, 1, 0F, -0.5F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 1F); // Box 61
		body[59].setRotationPoint(47F, -46F, 21F);

		body[60].addShapeBox(0F, 0F, 0F, 1, 43, 2, 0F, -0.5F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 1F); // Box 62
		body[60].setRotationPoint(47F, -46F, 15F);

		body[61].addShapeBox(0F, 0F, 0F, 1, 43, 2, 0F, -0.5F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 1F); // Box 63
		body[61].setRotationPoint(47F, -46F, -17F);

		body[62].addShapeBox(0F, 0F, 0F, 1, 43, 2, 0F, -0.5F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 1F); // Box 64
		body[62].setRotationPoint(47F, -46F, -11F);

		body[63].addShapeBox(0F, 0F, 0F, 1, 43, 2, 0F, -0.5F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 1F); // Box 65
		body[63].setRotationPoint(47F, -46F, 9F);

		body[64].addShapeBox(0F, 0F, 0F, 1, 43, 2, 0F, -0.5F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 1F); // Box 66
		body[64].setRotationPoint(47F, -46F, 2F);

		body[65].addShapeBox(0F, 0F, 0F, 1, 43, 2, 0F, -0.5F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 1F); // Box 67
		body[65].setRotationPoint(47F, -46F, -5F);

		body[66].addShapeBox(0F, 0F, 0F, 1, 1, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F); // Box 68
		body[66].setRotationPoint(-46F, -48F, -22F);

		body[67].addShapeBox(0F, 0F, 0F, 2, 1, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F); // Box 69
		body[67].setRotationPoint(-41F, -48F, -22F);

		body[68].addShapeBox(0F, 0F, 0F, 2, 1, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F); // Box 70
		body[68].setRotationPoint(-35F, -48F, -22F);

		body[69].addShapeBox(0F, 0F, 0F, 2, 1, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F); // Box 71
		body[69].setRotationPoint(-29F, -48F, -22F);

		body[70].addShapeBox(0F, 0F, 0F, 2, 1, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F); // Box 72
		body[70].setRotationPoint(-23F, -48F, -22F);

		body[71].addShapeBox(0F, 0F, 0F, 2, 1, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F); // Box 73
		body[71].setRotationPoint(-17F, -48F, -22F);

		body[72].addShapeBox(0F, 0F, 0F, 2, 1, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F); // Box 74
		body[72].setRotationPoint(-11F, -48F, -22F);

		body[73].addShapeBox(0F, 0F, 0F, 2, 1, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F); // Box 75
		body[73].setRotationPoint(-5F, -48F, -22F);

		body[74].addShapeBox(0F, 0F, 0F, 2, 1, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F); // Box 76
		body[74].setRotationPoint(3F, -48F, -22F);

		body[75].addShapeBox(0F, 0F, 0F, 2, 1, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F); // Box 77
		body[75].setRotationPoint(9F, -48F, -22F);

		body[76].addShapeBox(0F, 0F, 0F, 2, 1, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F); // Box 78
		body[76].setRotationPoint(15F, -48F, -22F);

		body[77].addShapeBox(0F, 0F, 0F, 2, 1, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F); // Box 79
		body[77].setRotationPoint(21F, -48F, -22F);

		body[78].addShapeBox(0F, 0F, 0F, 2, 1, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F); // Box 80
		body[78].setRotationPoint(27F, -48F, -22F);

		body[79].addShapeBox(0F, 0F, 0F, 2, 1, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F); // Box 81
		body[79].setRotationPoint(33F, -48F, -22F);

		body[80].addShapeBox(0F, 0F, 0F, 2, 1, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F); // Box 82
		body[80].setRotationPoint(39F, -48F, -22F);

		body[81].addShapeBox(0F, 0F, 0F, 1, 1, 44, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F, 1F, -0.5F, 0F); // Box 83
		body[81].setRotationPoint(45F, -48F, -22F);

		body[82].addShapeBox(-1F, 0F, 0F, 1, 5, 22, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, -0.5F, 0F, 0F); // Box 84
		body[82].setRotationPoint(-47.5F, -46F, 0F);

		body[83].addShapeBox(-1F, 37F, 0F, 1, 6, 22, 0F, -0.5F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F); // Box 85
		body[83].setRotationPoint(-47.5F, -46F, 0F);

		body[84].addShapeBox(-1F, 9F, 0F, 1, 10, 22, 0F, -0.5F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, -0.5F, 0F, 0F); // Box 86
		body[84].setRotationPoint(-47.5F, -46F, 0F);

		body[85].addShapeBox(-1F, 23F, 0F, 1, 10, 22, 0F, -0.5F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, -0.5F, 0F, 0F); // Box 87
		body[85].setRotationPoint(-47.5F, -46F, 0F);

		body[86].addShapeBox(-1F, 0F, 22F, 1, 5, 22, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, -0.5F, 0F, 0F); // Box 88
		body[86].setRotationPoint(-47.5F, -46F, -44F);

		body[87].addShapeBox(-1F, 37F, 22F, 1, 6, 22, 0F, -0.5F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F); // Box 89
		body[87].setRotationPoint(-47.5F, -46F, -44F);

		body[88].addShapeBox(-1F, 9F, 22F, 1, 10, 22, 0F, -0.5F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, -0.5F, 0F, 0F); // Box 90
		body[88].setRotationPoint(-47.5F, -46F, -44F);

		body[89].addShapeBox(-1F, 23F, 22F, 1, 10, 22, 0F, -0.5F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, -0.5F, 0F, 0F); // Box 91
		body[89].setRotationPoint(-47.5F, -46F, -44F);

		body[90].addShapeBox(0F, 0F, 0F, 2, 43, 1, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -0.5F, 1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 51
		body[90].setRotationPoint(-5F, -46F, 23F);


		lock = new ModelRendererTurbo[32];
		lock[0] = new ModelRendererTurbo(this, 257, 25, textureX, textureY); // Box 92
		lock[1] = new ModelRendererTurbo(this, 265, 25, textureX, textureY); // Box 93
		lock[2] = new ModelRendererTurbo(this, 273, 25, textureX, textureY); // Box 94
		lock[3] = new ModelRendererTurbo(this, 281, 25, textureX, textureY); // Box 95
		lock[4] = new ModelRendererTurbo(this, 289, 25, textureX, textureY); // Box 97
		lock[5] = new ModelRendererTurbo(this, 297, 25, textureX, textureY); // Box 98
		lock[6] = new ModelRendererTurbo(this, 305, 25, textureX, textureY); // Box 99
		lock[7] = new ModelRendererTurbo(this, 313, 25, textureX, textureY); // Box 100
		lock[8] = new ModelRendererTurbo(this, 321, 25, textureX, textureY); // Box 101
		lock[9] = new ModelRendererTurbo(this, 329, 25, textureX, textureY); // Box 102
		lock[10] = new ModelRendererTurbo(this, 257, 33, textureX, textureY); // Box 103
		lock[11] = new ModelRendererTurbo(this, 265, 33, textureX, textureY); // Box 104
		lock[12] = new ModelRendererTurbo(this, 273, 33, textureX, textureY); // Box 105
		lock[13] = new ModelRendererTurbo(this, 281, 33, textureX, textureY); // Box 106
		lock[14] = new ModelRendererTurbo(this, 289, 33, textureX, textureY); // Box 107
		lock[15] = new ModelRendererTurbo(this, 297, 33, textureX, textureY); // Box 108
		lock[16] = new ModelRendererTurbo(this, 329, 169, textureX, textureY); // Box 109
		lock[17] = new ModelRendererTurbo(this, 337, 169, textureX, textureY); // Box 110
		lock[18] = new ModelRendererTurbo(this, 345, 169, textureX, textureY); // Box 111
		lock[19] = new ModelRendererTurbo(this, 353, 169, textureX, textureY); // Box 112
		lock[20] = new ModelRendererTurbo(this, 313, 33, textureX, textureY); // Box 113
		lock[21] = new ModelRendererTurbo(this, 105, 41, textureX, textureY); // Box 114
		lock[22] = new ModelRendererTurbo(this, 129, 41, textureX, textureY); // Box 115
		lock[23] = new ModelRendererTurbo(this, 153, 41, textureX, textureY); // Box 116
		lock[24] = new ModelRendererTurbo(this, 313, 33, textureX, textureY); // Box 117
		lock[25] = new ModelRendererTurbo(this, 329, 33, textureX, textureY); // Box 118
		lock[26] = new ModelRendererTurbo(this, 57, 41, textureX, textureY); // Box 119
		lock[27] = new ModelRendererTurbo(this, 65, 41, textureX, textureY); // Box 120
		lock[28] = new ModelRendererTurbo(this, 81, 41, textureX, textureY); // Box 122
		lock[29] = new ModelRendererTurbo(this, 89, 41, textureX, textureY); // Box 123
		lock[30] = new ModelRendererTurbo(this, 97, 41, textureX, textureY); // Box 124
		lock[31] = new ModelRendererTurbo(this, 105, 41, textureX, textureY); // Box 125

		lock[0].addShapeBox(-2F, -1.5F, -18F, 1, 1, 1, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F); // Box 92
		lock[0].setRotationPoint(-47F, -46F, 21F);

		lock[1].addShapeBox(-2F, -1.5F, -8F, 1, 1, 1, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F); // Box 93
		lock[1].setRotationPoint(-47F, -46F, 21F);

		lock[2].addShapeBox(-2F, 43.5F, -18F, 1, 1, 1, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F); // Box 94
		lock[2].setRotationPoint(-47F, -46F, 21F);

		lock[3].addShapeBox(-2F, 43.5F, -8F, 1, 1, 1, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F); // Box 95
		lock[3].setRotationPoint(-47F, -46F, 21F);

		lock[4].addShapeBox(-1.5F, -1.5F, 18F, 1, 1, 1, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F); // Box 97
		lock[4].setRotationPoint(-47.5F, -46F, -22F);

		lock[5].addShapeBox(-1.5F, -1.5F, 8F, 1, 1, 1, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F); // Box 98
		lock[5].setRotationPoint(-47.5F, -46F, -22F);

		lock[6].addShapeBox(-1.5F, 43.5F, 18F, 1, 1, 1, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F); // Box 99
		lock[6].setRotationPoint(-47.5F, -46F, -22F);

		lock[7].addShapeBox(-1.5F, 43.5F, 8F, 1, 1, 1, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F); // Box 100
		lock[7].setRotationPoint(-47.5F, -46F, -22F);

		lock[8].addShapeBox(-1.5F, 26.5F, 5F, 1, 1, 1, 0F, -0.4F, 0F, -0.1F, 0F, 0.5F, -0.1F, 0F, 0.5F, -0.1F, -0.4F, 0F, -0.1F, -0.4F, 0F, -0.1F, 0F, 0.5F, -0.1F, 0F, 0.5F, -0.1F, -0.4F, 0F, -0.1F); // Box 101
		lock[8].setRotationPoint(-47.5F, -46F, -22F);

		lock[9].addShapeBox(-1.5F, 1.5F, 18F, 1, 1, 1, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F); // Box 102
		lock[9].setRotationPoint(-47.5F, -46F, -22F);

		lock[10].addShapeBox(-2F, 1.5F, -8F, 1, 1, 1, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F); // Box 103
		lock[10].setRotationPoint(-47F, -46F, 21F);

		lock[11].addShapeBox(-2F, 1.5F, -18F, 1, 1, 1, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F); // Box 104
		lock[11].setRotationPoint(-47F, -46F, 21F);

		lock[12].addShapeBox(-1.5F, 40.5F, 8F, 1, 1, 1, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F); // Box 105
		lock[12].setRotationPoint(-47.5F, -46F, -22F);

		lock[13].addShapeBox(-1.5F, 40.5F, 18F, 1, 1, 1, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F); // Box 106
		lock[13].setRotationPoint(-47.5F, -46F, -22F);

		lock[14].addShapeBox(-2F, 40.5F, -8F, 1, 1, 1, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F); // Box 107
		lock[14].setRotationPoint(-47F, -46F, 21F);

		lock[15].addShapeBox(-2F, 40.5F, -18F, 1, 1, 1, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F); // Box 108
		lock[15].setRotationPoint(-47F, -46F, 21F);

		lock[16].addShapeBox(-1.5F, 0F, 8F, 1, 46, 1, 0F, -0.6F, 0.4F, -0.2F, 0F, 0.4F, -0.2F, 0F, 0.4F, -0.2F, -0.6F, 0.4F, -0.2F, -0.6F, 0.4F, -0.2F, 0F, 0.4F, -0.2F, 0F, 0.4F, -0.2F, -0.6F, 0.4F, -0.2F); // Box 109
		lock[16].setRotationPoint(-47.5F, -47.5F, -22F);

		lock[17].addShapeBox(-1.5F, 0F, 18F, 1, 46, 1, 0F, -0.6F, 0.4F, -0.2F, 0F, 0.4F, -0.2F, 0F, 0.4F, -0.2F, -0.6F, 0.4F, -0.2F, -0.6F, 0.4F, -0.2F, 0F, 0.4F, -0.2F, 0F, 0.4F, -0.2F, -0.6F, 0.4F, -0.2F); // Box 110
		lock[17].setRotationPoint(-47.5F, -47.5F, -22F);

		lock[18].addShapeBox(-2F, 0F, -8F, 1, 46, 1, 0F, -0.6F, 0.4F, -0.2F, 0F, 0.4F, -0.2F, 0F, 0.4F, -0.2F, -0.6F, 0.4F, -0.2F, -0.6F, 0.4F, -0.2F, 0F, 0.4F, -0.2F, 0F, 0.4F, -0.2F, -0.6F, 0.4F, -0.2F); // Box 111
		lock[18].setRotationPoint(-47F, -47.5F, 21F);

		lock[19].addShapeBox(-2F, 0F, -18F, 1, 46, 1, 0F, -0.6F, 0.4F, -0.2F, 0F, 0.4F, -0.2F, 0F, 0.4F, -0.2F, -0.6F, 0.4F, -0.2F, -0.6F, 0.4F, -0.2F, 0F, 0.4F, -0.2F, 0F, 0.4F, -0.2F, -0.6F, 0.4F, -0.2F); // Box 112
		lock[19].setRotationPoint(-47F, -47.5F, 21F);

		lock[20].addShapeBox(-1.5F, 10F, -9F, 1, 1, 7, 0F, -0.6F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, -0.6F, -0.2F, -0.2F, -0.6F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, -0.6F, -0.2F, -0.2F); // Box 113
		lock[20].setRotationPoint(-47.5F, -29.5F, 22F);

		lock[21].addShapeBox(-1.5F, 12F, -19F, 1, 1, 7, 0F, -0.6F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, -0.6F, -0.2F, -0.2F, -0.6F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, -0.6F, -0.2F, -0.2F); // Box 114
		lock[21].setRotationPoint(-47.5F, -29.5F, 22F);

		lock[22].addShapeBox(-1.5F, 12F, 12F, 1, 1, 7, 0F, -0.6F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, -0.6F, -0.2F, -0.2F, -0.6F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, -0.6F, -0.2F, -0.2F); // Box 115
		lock[22].setRotationPoint(-47.5F, -29.5F, -22F);

		lock[23].addShapeBox(-1.5F, 10F, 2F, 1, 1, 7, 0F, -0.6F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, -0.6F, -0.2F, -0.2F, -0.6F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, -0.6F, -0.2F, -0.2F); // Box 116
		lock[23].setRotationPoint(-47.5F, -29.5F, -22F);

		lock[24].addShapeBox(-1.5F, 26.5F, 8F, 1, 1, 1, 0F, -0.4F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, -0.4F, 0.2F, 0.2F, -0.4F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, -0.4F, 0.2F, 0.2F); // Box 117
		lock[24].setRotationPoint(-47.5F, -46F, -22F);

		lock[25].addShapeBox(-1.5F, 28.5F, 18F, 1, 1, 1, 0F, -0.4F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, -0.4F, 0.2F, 0.2F, -0.4F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, -0.4F, 0.2F, 0.2F); // Box 118
		lock[25].setRotationPoint(-47.5F, -46F, -22F);

		lock[26].addShapeBox(-1.5F, 28.5F, -18F, 1, 1, 1, 0F, -0.4F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, -0.4F, 0.2F, 0.2F, -0.4F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, -0.4F, 0.2F, 0.2F); // Box 119
		lock[26].setRotationPoint(-47.5F, -46F, 21F);

		lock[27].addShapeBox(-1.5F, 26.5F, -8F, 1, 1, 1, 0F, -0.4F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, -0.4F, 0.2F, 0.2F, -0.4F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, 0F, 0.2F, 0.2F, -0.4F, 0.2F, 0.2F); // Box 120
		lock[27].setRotationPoint(-47.5F, -46F, 21F);

		lock[28].addShapeBox(-1.5F, 1.5F, 8F, 1, 1, 1, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.4F, 0F, 0F); // Box 122
		lock[28].setRotationPoint(-47.5F, -46F, -22F);

		lock[29].addShapeBox(-1.5F, 28.5F, 15F, 1, 1, 1, 0F, -0.4F, 0F, -0.1F, 0F, 0.5F, -0.1F, 0F, 0.5F, -0.1F, -0.4F, 0F, -0.1F, -0.4F, 0F, -0.1F, 0F, 0.5F, -0.1F, 0F, 0.5F, -0.1F, -0.4F, 0F, -0.1F); // Box 123
		lock[29].setRotationPoint(-47.5F, -46F, -22F);

		lock[30].addShapeBox(-1.5F, 28.5F, -15F, 1, 1, 1, 0F, -0.4F, 0F, -0.1F, 0F, 0.5F, -0.1F, 0F, 0.5F, -0.1F, -0.4F, 0F, -0.1F, -0.4F, 0F, -0.1F, 0F, 0.5F, -0.1F, 0F, 0.5F, -0.1F, -0.4F, 0F, -0.1F); // Box 124
		lock[30].setRotationPoint(-47.5F, -46F, 21F);

		lock[31].addShapeBox(-1.5F, 26.5F, -5F, 1, 1, 1, 0F, -0.4F, 0F, -0.1F, 0F, 0.5F, -0.1F, 0F, 0.5F, -0.1F, -0.4F, 0F, -0.1F, -0.4F, 0F, -0.1F, 0F, 0.5F, -0.1F, 0F, 0.5F, -0.1F, -0.4F, 0F, -0.1F); // Box 125
		lock[31].setRotationPoint(-47.5F, -46F, 21F);
		
		flipAll();
	}
	
	@Override
	public void render(ContainerData data){
		render(lock);
		render(body);
	}
	
	@Override
	public void render(VehicleData vehdata, String part, ContainerData data, ContainerPosition pos){
		render(lock);
		vehdata.getSecondaryColor().glColorApply();
		render(body);
		RGB.glColorReset();
	}
	
	@Override
	public void render(VehicleData vehdata, String part, ContainerData data, ContainerPosition pos, Entity vehicle){
		render(lock);
		vehdata.getSecondaryColor().glColorApply();
		render(body);
		RGB.glColorReset();
	}
	
}