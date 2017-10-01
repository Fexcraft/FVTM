package net.fexcraft.mod.addons.fvp.models.part;

import net.fexcraft.mod.addons.gep.attributes.InventoryAttribute.InventoryAttributeData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.part.PartModel;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ModelOT1LogTransportUpgrade extends PartModel {
	
	public ModelRendererTurbo cargo[] = new ModelRendererTurbo[0];
	
	int textureX = 512;
	int textureY = 512;

	public ModelOT1LogTransportUpgrade(){
		this.creators.add("Ferdinand (FEX___96)");
		body = new ModelRendererTurbo[39];
		body[0] = new ModelRendererTurbo(this, 1, 249, textureX, textureY); // Box 0
		body[1] = new ModelRendererTurbo(this, 201, 249, textureX, textureY); // Box 1
		body[2] = new ModelRendererTurbo(this, 201, 161, textureX, textureY); // Box 2
		body[3] = new ModelRendererTurbo(this, 433, 177, textureX, textureY); // Box 3
		body[4] = new ModelRendererTurbo(this, 1, 193, textureX, textureY); // Box 4
		body[5] = new ModelRendererTurbo(this, 33, 193, textureX, textureY); // Box 5
		body[6] = new ModelRendererTurbo(this, 241, 193, textureX, textureY); // Box 6
		body[7] = new ModelRendererTurbo(this, 33, 201, textureX, textureY); // Box 7
		body[8] = new ModelRendererTurbo(this, 377, 201, textureX, textureY); // Box 8
		body[9] = new ModelRendererTurbo(this, 393, 201, textureX, textureY); // Box 9
		body[10] = new ModelRendererTurbo(this, 25, 209, textureX, textureY); // Box 10
		body[11] = new ModelRendererTurbo(this, 481, 201, textureX, textureY); // Box 11
		body[12] = new ModelRendererTurbo(this, 449, 225, textureX, textureY); // Box 12
		body[13] = new ModelRendererTurbo(this, 465, 225, textureX, textureY); // Box 13
		body[14] = new ModelRendererTurbo(this, 481, 225, textureX, textureY); // Box 14
		body[15] = new ModelRendererTurbo(this, 497, 225, textureX, textureY); // Box 15
		body[16] = new ModelRendererTurbo(this, 417, 233, textureX, textureY); // Box 16
		body[17] = new ModelRendererTurbo(this, 433, 233, textureX, textureY); // Box 17
		body[18] = new ModelRendererTurbo(this, 401, 249, textureX, textureY); // Box 18
		body[19] = new ModelRendererTurbo(this, 497, 201, textureX, textureY); // Box 19
		body[20] = new ModelRendererTurbo(this, 241, 209, textureX, textureY); // Box 20
		body[21] = new ModelRendererTurbo(this, 257, 209, textureX, textureY); // Box 21
		body[22] = new ModelRendererTurbo(this, 489, 209, textureX, textureY); // Box 22
		body[23] = new ModelRendererTurbo(this, 1, 217, textureX, textureY); // Box 23
		body[24] = new ModelRendererTurbo(this, 9, 225, textureX, textureY); // Box 24
		body[25] = new ModelRendererTurbo(this, 457, 249, textureX, textureY); // Box 25
		body[26] = new ModelRendererTurbo(this, 385, 233, textureX, textureY); // Box 26
		body[27] = new ModelRendererTurbo(this, 1, 257, textureX, textureY); // Box 28
		body[28] = new ModelRendererTurbo(this, 89, 257, textureX, textureY); // Box 29
		body[29] = new ModelRendererTurbo(this, 177, 257, textureX, textureY); // Box 30
		body[30] = new ModelRendererTurbo(this, 265, 257, textureX, textureY); // Box 31
		body[31] = new ModelRendererTurbo(this, 313, 265, textureX, textureY); // Box 32
		body[32] = new ModelRendererTurbo(this, 361, 281, textureX, textureY); // Box 33
		body[33] = new ModelRendererTurbo(this, 409, 289, textureX, textureY); // Box 34
		body[34] = new ModelRendererTurbo(this, 505, 89, textureX, textureY); // Box 35
		body[35] = new ModelRendererTurbo(this, 489, 249, textureX, textureY); // Box 36
		body[36] = new ModelRendererTurbo(this, 505, 249, textureX, textureY); // Box 37
		body[37] = new ModelRendererTurbo(this, 1, 257, textureX, textureY); // Box 38
		body[38] = new ModelRendererTurbo(this, 49, 257, textureX, textureY); // Box 39

		body[0].addShapeBox(0F, 0F, 0F, 96, 2, 1, 0F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 0
		body[0].setRotationPoint(-77F, -14F, 21F);

		body[1].addShapeBox(0F, 0F, 0F, 96, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 1
		body[1].setRotationPoint(-77F, -14F, -22F);

		body[2].addShapeBox(-0.5F, 0F, 0F, 2, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 2
		body[2].setRotationPoint(-77F, -15F, 21F);

		body[3].addShapeBox(-0.5F, 0F, 0F, 2, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 3
		body[3].setRotationPoint(-77F, -15F, -23F);

		body[4].addShapeBox(-0.5F, 0F, 0F, 2, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 4
		body[4].setRotationPoint(18F, -15F, -23F);

		body[5].addShapeBox(-0.5F, 0F, 0F, 2, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 5
		body[5].setRotationPoint(18F, -15F, 21F);

		body[6].addShapeBox(-0.5F, 0F, 0F, 2, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 6
		body[6].setRotationPoint(-46F, -15F, 21F);

		body[7].addShapeBox(-0.5F, 0F, 0F, 2, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 7
		body[7].setRotationPoint(-14F, -15F, 21F);

		body[8].addShapeBox(-0.5F, 0F, 0F, 2, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 8
		body[8].setRotationPoint(-14F, -15F, -23F);

		body[9].addShapeBox(-0.5F, 0F, 0F, 2, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 9
		body[9].setRotationPoint(-46F, -15F, -23F);

		body[10].addShapeBox(0F, 0F, 0F, 2, 22, 2, 0F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 10
		body[10].setRotationPoint(-77.5F, -37F, 21F);

		body[11].addShapeBox(0F, 0F, 0F, 2, 6, 2, 0F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.3F, 0F, -1.2F, -0.3F, 0F, -1.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 11
		body[11].setRotationPoint(-77.5F, -43F, 21F);

		body[12].addShapeBox(0F, 0F, 0F, 2, 22, 2, 0F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 12
		body[12].setRotationPoint(-46.5F, -37F, 21F);

		body[13].addShapeBox(0F, 0F, 0F, 2, 22, 2, 0F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 13
		body[13].setRotationPoint(-14.5F, -37F, 21F);

		body[14].addShapeBox(0F, 0F, 0F, 2, 22, 2, 0F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 14
		body[14].setRotationPoint(17.5F, -37F, 21F);

		body[15].addShapeBox(0F, 0F, 0F, 2, 22, 2, 0F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 15
		body[15].setRotationPoint(-77.5F, -37F, -23F);

		body[16].addShapeBox(0F, 0F, 0F, 2, 22, 2, 0F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 16
		body[16].setRotationPoint(-46.5F, -37F, -23F);

		body[17].addShapeBox(0F, 0F, 0F, 2, 22, 2, 0F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 17
		body[17].setRotationPoint(-14.5F, -37F, -23F);

		body[18].addShapeBox(0F, 0F, 0F, 2, 22, 2, 0F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 18
		body[18].setRotationPoint(17.5F, -37F, -23F);

		body[19].addShapeBox(0F, 0F, 0F, 2, 6, 2, 0F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.3F, 0F, -1.2F, -0.3F, 0F, -1.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 19
		body[19].setRotationPoint(-46.5F, -43F, 21F);

		body[20].addShapeBox(0F, 0F, 0F, 2, 6, 2, 0F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.3F, 0F, -1.2F, -0.3F, 0F, -1.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 20
		body[20].setRotationPoint(-14.5F, -43F, 21F);

		body[21].addShapeBox(0F, 0F, 0F, 2, 6, 2, 0F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.3F, 0F, -1.2F, -0.3F, 0F, -1.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 21
		body[21].setRotationPoint(17.5F, -43F, 21F);

		body[22].addShapeBox(0F, 0F, 0F, 2, 6, 2, 0F, -0.3F, 0F, -1.2F, -0.3F, 0F, -1.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 22
		body[22].setRotationPoint(-77.5F, -43F, -23F);

		body[23].addShapeBox(0F, 0F, 0F, 2, 6, 2, 0F, -0.3F, 0F, -1.2F, -0.3F, 0F, -1.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 23
		body[23].setRotationPoint(-46.5F, -43F, -23F);

		body[24].addShapeBox(0F, 0F, 0F, 2, 6, 2, 0F, -0.3F, 0F, -1.2F, -0.3F, 0F, -1.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 24
		body[24].setRotationPoint(-14.5F, -43F, -23F);

		body[25].addShapeBox(0F, 0F, 0F, 2, 6, 2, 0F, -0.3F, 0F, -1.2F, -0.3F, 0F, -1.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 25
		body[25].setRotationPoint(17.5F, -43F, -23F);

		body[26].addShapeBox(0F, 0F, 0F, 2, 2, 42, 0F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F); // Box 26
		body[26].setRotationPoint(17.5F, -43F, -21F);

		body[27].addShapeBox(0F, 0F, 0F, 1, 2, 42, 0F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F); // Box 28
		body[27].setRotationPoint(18F, -39F, -21F);

		body[28].addShapeBox(0F, 0F, 0F, 1, 2, 42, 0F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F); // Box 29
		body[28].setRotationPoint(18F, -35F, -21F);

		body[29].addShapeBox(0F, 0F, 0F, 1, 2, 42, 0F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F); // Box 30
		body[29].setRotationPoint(18F, -31F, -21F);

		body[30].addShapeBox(0F, 0F, 0F, 1, 2, 42, 0F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F); // Box 31
		body[30].setRotationPoint(18F, -27F, -21F);

		body[31].addShapeBox(0F, 0F, 0F, 1, 2, 42, 0F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F); // Box 32
		body[31].setRotationPoint(18F, -23F, -21F);

		body[32].addShapeBox(0F, 0F, 0F, 1, 2, 42, 0F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F); // Box 33
		body[32].setRotationPoint(18F, -19F, -21F);

		body[33].addShapeBox(0F, 0F, 0F, 1, 2, 42, 0F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F); // Box 34
		body[33].setRotationPoint(18F, -15F, -21F);

		body[34].addShapeBox(0F, 0F, 0F, 1, 29, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 35
		body[34].setRotationPoint(18F, -42F, -17F);

		body[35].addShapeBox(0F, 0F, 0F, 1, 29, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 36
		body[35].setRotationPoint(18F, -42F, 14F);

		body[36].addShapeBox(0F, 0F, 0F, 1, 29, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 37
		body[36].setRotationPoint(18F, -42F, -6F);

		body[37].addShapeBox(0F, 0F, 0F, 1, 29, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 38
		body[37].setRotationPoint(18F, -42F, 4F);

		body[38].addBox(0F, 0F, 0F, 1, 6, 26, 0F); // Box 39
		body[38].setRotationPoint(19.5F, -32F, -13F);


		cargo = new ModelRendererTurbo[22];
		cargo[0] = new ModelRendererTurbo(this, 1, 305, textureX, textureY); // Box 41
		cargo[1] = new ModelRendererTurbo(this, 1, 321, textureX, textureY); // Box 42
		cargo[2] = new ModelRendererTurbo(this, 1, 337, textureX, textureY); // Box 43
		cargo[3] = new ModelRendererTurbo(this, 209, 337, textureX, textureY); // Box 44
		cargo[4] = new ModelRendererTurbo(this, 1, 353, textureX, textureY); // Box 45
		cargo[5] = new ModelRendererTurbo(this, 209, 353, textureX, textureY); // Box 46
		cargo[6] = new ModelRendererTurbo(this, 1, 369, textureX, textureY); // Box 47
		cargo[7] = new ModelRendererTurbo(this, 209, 369, textureX, textureY); // Box 48
		cargo[8] = new ModelRendererTurbo(this, 1, 385, textureX, textureY); // Box 49
		cargo[9] = new ModelRendererTurbo(this, 209, 385, textureX, textureY); // Box 50
		cargo[10] = new ModelRendererTurbo(this, 1, 401, textureX, textureY); // Box 51
		cargo[11] = new ModelRendererTurbo(this, 209, 401, textureX, textureY); // Box 52
		cargo[12] = new ModelRendererTurbo(this, 1, 417, textureX, textureY); // Box 53
		cargo[13] = new ModelRendererTurbo(this, 217, 417, textureX, textureY); // Box 54
		cargo[14] = new ModelRendererTurbo(this, 1, 433, textureX, textureY); // Box 55
		cargo[15] = new ModelRendererTurbo(this, 217, 433, textureX, textureY); // Box 56
		cargo[16] = new ModelRendererTurbo(this, 1, 449, textureX, textureY); // Box 57
		cargo[17] = new ModelRendererTurbo(this, 217, 449, textureX, textureY); // Box 58
		cargo[18] = new ModelRendererTurbo(this, 1, 465, textureX, textureY); // Box 59
		cargo[19] = new ModelRendererTurbo(this, 217, 465, textureX, textureY); // Box 60
		cargo[20] = new ModelRendererTurbo(this, 1, 481, textureX, textureY); // Box 61
		cargo[21] = new ModelRendererTurbo(this, 217, 481, textureX, textureY); // Box 62

		cargo[0].addBox(0F, 0.2F, 0F, 98, 6, 6, 0F); // Box 41
		cargo[0].setRotationPoint(-81F, -20F, -21F);

		cargo[1].addBox(0F, 0.2F, 0F, 98, 6, 6, 0F); // Box 42
		cargo[1].setRotationPoint(-81F, -20F, 15F);

		cargo[2].addBox(0.5F, 0.2F, -0.5F, 97, 6, 6, 0F); // Box 43
		cargo[2].setRotationPoint(-81F, -20F, -14F);
		cargo[2].rotateAngleX = -0.03490659F;

		cargo[3].addBox(0.5F, 0F, -0.5F, 97, 6, 6, 0F); // Box 44
		cargo[3].setRotationPoint(-81F, -20F, 9F);
		cargo[3].rotateAngleX = -0.06981317F;

		cargo[4].addBox(0F, 0.2F, 0F, 97, 6, 6, 0F); // Box 45
		cargo[4].setRotationPoint(-81F, -20F, 1F);
		cargo[4].rotateAngleX = 0.05235988F;

		cargo[5].addBox(0F, 0.2F, 0F, 98, 6, 6, 0F); // Box 46
		cargo[5].setRotationPoint(-81F, -20F, -6.5F);

		cargo[6].addBox(0F, 0.2F, 0F, 96, 6, 6, 0F); // Box 47
		cargo[6].setRotationPoint(-79F, -26F, -9.5F);

		cargo[7].addBox(0.5F, 0F, -0.5F, 96, 6, 6, 0F); // Box 48
		cargo[7].setRotationPoint(-79F, -26F, -16F);
		cargo[7].rotateAngleX = -0.06981317F;

		cargo[8].addBox(0F, 0.2F, 0F, 97, 6, 6, 0F); // Box 49
		cargo[8].setRotationPoint(-80F, -30F, -21F);
		cargo[8].rotateAngleX = 0.55850536F;

		cargo[9].addBox(0F, 0.2F, 0F, 98, 6, 6, 0F); // Box 50
		cargo[9].setRotationPoint(-81.5F, -26F, -3F);
		cargo[9].rotateAngleX = 0.05235988F;

		cargo[10].addBox(0F, 0.2F, 0F, 95, 6, 6, 0F); // Box 51
		cargo[10].setRotationPoint(-78F, -26F, 4.5F);

		cargo[11].addBox(0.5F, 0F, -0.5F, 97, 6, 6, 0F); // Box 52
		cargo[11].setRotationPoint(-80F, -26F, 13F);
		cargo[11].rotateAngleX = -0.06981317F;

		cargo[12].addBox(0.5F, 0F, -0.5F, 98, 6, 6, 0F); // Box 53
		cargo[12].setRotationPoint(-81F, -32F, 16F);
		cargo[12].rotateAngleX = -0.2268928F;

		cargo[13].addBox(0F, 0.2F, 0F, 98, 6, 6, 0F); // Box 54
		cargo[13].setRotationPoint(-80F, -32F, 7.5F);

		cargo[14].addBox(0F, 0.2F, 0F, 98, 6, 6, 0F); // Box 55
		cargo[14].setRotationPoint(-81F, -32F, -12.5F);

		cargo[15].addBox(0F, 0.2F, 0F, 98, 6, 6, 0F); // Box 56
		cargo[15].setRotationPoint(-80.5F, -32F, -5.5F);

		cargo[16].addBox(0F, 0.2F, 0F, 98, 6, 6, 0F); // Box 57
		cargo[16].setRotationPoint(-80.5F, -32F, 0F);
		cargo[16].rotateAngleX = 0.89011792F;

		cargo[17].addBox(0F, 0.2F, 0F, 98, 6, 6, 0F); // Box 58
		cargo[17].setRotationPoint(-81F, -38F, 15F);
		cargo[17].rotateAngleX = -0.05235988F;

		cargo[18].addBox(0F, 0.2F, 0F, 98, 6, 6, 0F); // Box 59
		cargo[18].setRotationPoint(-80.4F, -38F, 8.5F);

		cargo[19].addBox(0F, 0F, 0F, 99, 6, 6, 0F); // Box 60
		cargo[19].setRotationPoint(-81.5F, -39F, -21F);
		cargo[19].rotateAngleX = -0.03490659F;

		cargo[20].addBox(0.5F, 0F, -0.5F, 98, 6, 6, 0F); // Box 61
		cargo[20].setRotationPoint(-80F, -39F, -13.5F);
		cargo[20].rotateAngleX = -0.2268928F;

		cargo[21].addBox(0F, 0.2F, 0F, 98, 6, 6, 0F); // Box 62
		cargo[21].setRotationPoint(-81.5F, -38F, -8F);
		cargo[21].rotateAngleX = -0.01745329F;

		translateAll(0F, 0F, 0F);
		
	}
	
	@Override
	public void render(VehicleData data, String us){
		super.render(data, us);
	}
	
	@Override
	public void render(VehicleData data, String us, Entity vehicle){
		super.render(data, us, vehicle);
		NonNullList<ItemStack> stacks = data.getPart(us).getAttributeData(InventoryAttributeData.class).getInventory();
		int j = 0;
		for(int i = 0; i < cargo.length; i++){
			if(i < stacks.size() && !stacks.get(i).isEmpty()){
				//cargo[i].render();
				j++;
				continue;
			}
			if(i >= stacks.size()){
				break;
			}
		}
		for(int i = 0; i < j; i++){
			cargo[i].render();
		}
	}
	
}