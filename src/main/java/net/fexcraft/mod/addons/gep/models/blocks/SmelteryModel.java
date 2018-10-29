package net.fexcraft.mod.addons.gep.models.blocks;

import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.addons.gep.scripts.SmelteryScript;
import net.fexcraft.mod.fvtm.api.Block.BlockData;
import net.fexcraft.mod.fvtm.api.Block.BlockTileEntity;
import net.fexcraft.mod.fvtm.model.block.BlockModel;
import net.fexcraft.mod.fvtm.util.RenderCache;
import net.minecraft.entity.Entity;

public class SmelteryModel extends BlockModel {
	
	private ModelRendererTurbo[] left = new ModelRendererTurbo[2];
	private ModelRendererTurbo[] right = new ModelRendererTurbo[2];

    public SmelteryModel(){
        textureX = 512; textureY = 256;
        this.addToCreators("FEX___96");
        body = new ModelRendererTurbo[43];
        body[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
        body[1] = new ModelRendererTurbo(this, 201, 1, textureX, textureY); // Box 1
        body[2] = new ModelRendererTurbo(this, 313, 1, textureX, textureY); // Box 2
        body[3] = new ModelRendererTurbo(this, 377, 25, textureX, textureY); // Box 3
        body[4] = new ModelRendererTurbo(this, 1, 57, textureX, textureY); // Box 4
        body[5] = new ModelRendererTurbo(this, 377, 1, textureX, textureY); // Box 5
        body[6] = new ModelRendererTurbo(this, 65, 57, textureX, textureY); // Box 6
        body[7] = new ModelRendererTurbo(this, 129, 57, textureX, textureY); // Box 7
        body[8] = new ModelRendererTurbo(this, 193, 73, textureX, textureY); // Box 8
        body[9] = new ModelRendererTurbo(this, 257, 73, textureX, textureY); // Box 9
        body[10] = new ModelRendererTurbo(this, 65, 81, textureX, textureY); // Box 10
        body[11] = new ModelRendererTurbo(this, 153, 1, textureX, textureY); // Box 11
        body[12] = new ModelRendererTurbo(this, 305, 97, textureX, textureY); // Box 12
        body[13] = new ModelRendererTurbo(this, 385, 97, textureX, textureY); // Box 13
        body[14] = new ModelRendererTurbo(this, 105, 121, textureX, textureY); // Box 14
        body[15] = new ModelRendererTurbo(this, 1, 129, textureX, textureY); // Box 15
        body[16] = new ModelRendererTurbo(this, 265, 1, textureX, textureY); // Box 16
        body[17] = new ModelRendererTurbo(this, 249, 97, textureX, textureY); // Box 17
        body[18] = new ModelRendererTurbo(this, 129, 121, textureX, textureY); // Box 18
        body[19] = new ModelRendererTurbo(this, 233, 169, textureX, textureY); // Box 19
        body[20] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 20
        body[21] = new ModelRendererTurbo(this, 153, 17, textureX, textureY); // Box 21
        body[22] = new ModelRendererTurbo(this, 265, 25, textureX, textureY); // Box 22
        body[23] = new ModelRendererTurbo(this, 337, 177, textureX, textureY); // Box 23
        body[24] = new ModelRendererTurbo(this, 441, 25, textureX, textureY); // Box 24
        body[25] = new ModelRendererTurbo(this, 193, 17, textureX, textureY); // Box 25
        body[26] = new ModelRendererTurbo(this, 1, 25, textureX, textureY); // Box 26
        body[27] = new ModelRendererTurbo(this, 329, 1, textureX, textureY); // Box 27
        body[28] = new ModelRendererTurbo(this, 329, 9, textureX, textureY); // Box 28
        body[29] = new ModelRendererTurbo(this, 217, 17, textureX, textureY); // Box 29
        body[30] = new ModelRendererTurbo(this, 217, 25, textureX, textureY); // Box 30
        body[31] = new ModelRendererTurbo(this, 377, 25, textureX, textureY); // Box 31
        body[32] = new ModelRendererTurbo(this, 441, 57, textureX, textureY); // Box 32
        body[33] = new ModelRendererTurbo(this, 433, 97, textureX, textureY); // Box 35
        body[34] = new ModelRendererTurbo(this, 433, 113, textureX, textureY); // Box 36
        body[35] = new ModelRendererTurbo(this, 185, 153, textureX, textureY); // Box 37
        body[36] = new ModelRendererTurbo(this, 193, 73, textureX, textureY); // Box 41
        body[37] = new ModelRendererTurbo(this, 41, 1, textureX, textureY); // Box 50
        body[38] = new ModelRendererTurbo(this, 241, 1, textureX, textureY); // Box 51
        body[39] = new ModelRendererTurbo(this, 41, 9, textureX, textureY); // Box 52
        body[40] = new ModelRendererTurbo(this, 241, 9, textureX, textureY); // Box 53
        body[41] = new ModelRendererTurbo(this, 153, 41, textureX, textureY); // Box 54
        body[42] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 56

        body[0].addBox(-24F, 0F, -24F, 48, 4, 48, 0F); // Box 0
        body[0].setRotationPoint(0F, -4F, 0F);

        body[1].addShapeBox(0F, 0F, 0F, 4, 16, 48, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F); // Box 1
        body[1].setRotationPoint(-24F, -20F, -24F);

        body[2].addShapeBox(0F, 0F, 0F, 4, 16, 48, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F); // Box 2
        body[2].setRotationPoint(20F, -20F, -24F);

        body[3].addShapeBox(0F, 0F, 0F, 4, 16, 48, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F); // Box 3
        body[3].setRotationPoint(20F, -36F, -24F);

        body[4].addShapeBox(0F, 0F, 0F, 4, 16, 48, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F); // Box 4
        body[4].setRotationPoint(-24F, -36F, -24F);

        body[5].addShapeBox(0F, 0F, 0F, 48, 16, 4, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 5
        body[5].setRotationPoint(-24F, -20F, 20F);

        body[6].addShapeBox(0F, 0F, 0F, 48, 16, 4, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 6
        body[6].setRotationPoint(-24F, -36F, 20F);

        body[7].addShapeBox(0F, 0F, 0F, 4, 12, 48, 0F, -8F, 0F, -8F, 8F, 0F, -12F, 8F, 0F, -12F, -8F, 0F, -8F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F); // Box 7
        body[7].setRotationPoint(-24F, -48F, -24F);

        body[8].addShapeBox(0F, 0F, 0F, 4, 12, 48, 0F, 8F, 0F, -12F, -8F, 0F, -8F, -8F, 0F, -8F, 8F, 0F, -12F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F); // Box 8
        body[8].setRotationPoint(20F, -48F, -24F);

        body[9].addShapeBox(0F, 0F, 0F, 48, 12, 4, 0F, -8F, 0F, -8F, -8F, 0F, -8F, -12F, 0F, 8F, -12F, 0F, 8F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F); // Box 9
        body[9].setRotationPoint(-24F, -48F, -24F);

        body[10].addShapeBox(0F, 0F, 0F, 48, 12, 4, 0F, -12F, 0F, 8F, -12F, 0F, 8F, -8F, 0F, -8F, -8F, 0F, -8F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 10
        body[10].setRotationPoint(-24F, -48F, 20F);

        body[11].addBox(0F, 0F, 0F, 40, 4, 4, 0F); // Box 11
        body[11].setRotationPoint(-20F, -36F, -24F);

        body[12].addShapeBox(0F, 0F, 0F, 32, 44, 4, 0F, -2F, 0F, -2F, -2F, 0F, -2F, -6F, 0F, 2F, -6F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F); // Box 12
        body[12].setRotationPoint(-16F, -92F, -16F);

        body[13].addShapeBox(0F, 0F, 0F, 4, 44, 32, 0F, -2F, 0F, -2F, 2F, 0F, -6F, 2F, 0F, -6F, -2F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F); // Box 13
        body[13].setRotationPoint(-16F, -92F, -16F);

        body[14].addShapeBox(0F, 0F, 0F, 32, 44, 4, 0F, -6F, 0F, 2F, -6F, 0F, 2F, -2F, 0F, -2F, -2F, 0F, -2F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 14
        body[14].setRotationPoint(-16F, -92F, 12F);

        body[15].addShapeBox(0F, 0F, 0F, 4, 44, 32, 0F, 2F, 0F, -6F, -2F, 0F, -2F, -2F, 0F, -2F, 2F, 0F, -6F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F); // Box 15
        body[15].setRotationPoint(12F, -92F, -16F);

        body[16].addBox(0F, 0F, 0F, 20, 1, 20, 0F); // Box 16
        body[16].setRotationPoint(-10F, -90F, -10F);

        body[17].addShapeBox(0F, 0F, 0F, 1, 18, 49, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 17
        body[17].setRotationPoint(-25F, -18F, -24F);

        body[18].addShapeBox(0F, 0F, 0F, 1, 18, 49, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 18
        body[18].setRotationPoint(24F, -18F, -24F);

        body[19].addShapeBox(0F, 0F, 0F, 48, 18, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 19
        body[19].setRotationPoint(-24F, -18F, 24F);

        body[20].addBox(0F, 0F, 0F, 17, 18, 1, 0F); // Box 20
        body[20].setRotationPoint(-25F, -18F, -25F);

        body[21].addBox(0F, 0F, 0F, 17, 18, 1, 0F); // Box 21
        body[21].setRotationPoint(8F, -18F, -25F);

        body[22].addBox(0F, 0F, 0F, 40, 8, 4, 0F); // Box 22
        body[22].setRotationPoint(-20F, -20F, -24F);

        body[23].addBox(0F, 0F, 0F, 40, 6, 4, 0F); // Box 23
        body[23].setRotationPoint(-20F, -10F, -24F);

        body[24].addBox(0F, 0F, 0F, 16, 13, 16, 0F); // Box 24
        body[24].setRotationPoint(-8F, -13F, -40F);

        body[25].addBox(0F, 0F, 0F, 2, 3, 16, 0F); // Box 25
        body[25].setRotationPoint(-8F, -16F, -40F);

        body[26].addBox(0F, 0F, 0F, 2, 3, 16, 0F); // Box 26
        body[26].setRotationPoint(6F, -16F, -40F);

        body[27].addBox(0F, 0F, 0F, 12, 3, 2, 0F); // Box 27
        body[27].setRotationPoint(-6F, -16F, -40F);

        body[28].addBox(0F, 0F, 0F, 12, 4, 2, 0F); // Box 28
        body[28].setRotationPoint(-6F, -16F, -36F);

        body[29].addBox(0F, 0F, 0F, 12, 4, 2, 0F); // Box 29
        body[29].setRotationPoint(-6F, -16F, -32F);

        body[30].addBox(0F, 0F, 0F, 12, 4, 2, 0F); // Box 30
        body[30].setRotationPoint(-6F, -16F, -28F);

        body[31].addShapeBox(0F, 0F, 0F, 2, 2, 15, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 31
        body[31].setRotationPoint(-1F, -18F, -38.5F);

        body[32].addShapeBox(0F, 0F, 0F, 20, 1, 12, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -10F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -10F); // Box 32
        body[32].setRotationPoint(0F, -20F, -20F);

        body[33].addShapeBox(0F, 0F, 0F, 20, 1, 12, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -10F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -10F, 0F, 0F, 0F); // Box 35
        body[33].setRotationPoint(-20F, -20F, -20F);

        body[34].addShapeBox(0F, 0F, 0F, 20, 1, 12, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -10F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -10F); // Box 36
        body[34].setRotationPoint(0F, -33F, -20F);

        body[35].addShapeBox(0F, 0F, 0F, 20, 1, 12, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -10F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -10F, 0F, 0F, 0F); // Box 37
        body[35].setRotationPoint(-20F, -33F, -20F);

        body[36].addBox(0F, 0F, 0F, 4, 5, 16, 0F); // Box 41
        body[36].setRotationPoint(-2F, -16.5F, -39.5F);

        body[37].addShapeBox(0F, 0F, 0F, 2, 2, 1, 0F, 0F, -1.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 50
        body[37].setRotationPoint(6F, -18F, -25F);

        body[38].addShapeBox(0F, 0F, 0F, 2, 2, 1, 0F, 0F, 0F, 0F, 0F, -1.8F, 0F, 0F, -1.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 51
        body[38].setRotationPoint(-8F, -18F, -25F);

        body[39].addBox(0F, 0F, 0F, 2, 4, 1, 0F); // Box 52
        body[39].setRotationPoint(-23F, -30F, -24.5F);

        body[40].addBox(0F, 0F, 0F, 2, 4, 1, 0F); // Box 53
        body[40].setRotationPoint(21F, -30F, -24.5F);

        body[41].addShapeBox(0F, 0F, 0F, 42, 3, 2, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 2F, 0F, 1F, 2F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F); // Box 54
        body[41].setRotationPoint(-21F, -36F, -25F);

        body[42].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 56
        body[42].setRotationPoint(0F, 0F, 0F);

        /*turretModel = new ModelRendererTurbo[8];
        turretModel[0] = new ModelRendererTurbo(this, 265, 1, textureX, textureY); // Box 40
        turretModel[1] = new ModelRendererTurbo(this, 265, 9, textureX, textureY); // Box 42
        turretModel[2] = new ModelRendererTurbo(this, 193, 17, textureX, textureY); // Box 43
        turretModel[3] = new ModelRendererTurbo(this, 489, 17, textureX, textureY); // Box 44
        turretModel[4] = new ModelRendererTurbo(this, 1, 25, textureX, textureY); // Box 45
        turretModel[5] = new ModelRendererTurbo(this, 193, 25, textureX, textureY); // Box 46
        turretModel[6] = new ModelRendererTurbo(this, 377, 25, textureX, textureY); // Box 47
        turretModel[7] = new ModelRendererTurbo(this, 401, 25, textureX, textureY); // Box 48

        turretModel[0].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 40
        turretModel[0].setRotationPoint(-6F, -15F, -26F);

        turretModel[1].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 42
        turretModel[1].setRotationPoint(2F, -15F, -26F);

        turretModel[2].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 43
        turretModel[2].setRotationPoint(-6F, -15F, -30F);

        turretModel[3].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 44
        turretModel[3].setRotationPoint(2F, -15F, -30F);

        turretModel[4].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 45
        turretModel[4].setRotationPoint(-6F, -15F, -34F);

        turretModel[5].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 46
        turretModel[5].setRotationPoint(2F, -15F, -34F);

        turretModel[6].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 47
        turretModel[6].setRotationPoint(-6F, -15F, -38F);

        turretModel[7].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 48
        turretModel[7].setRotationPoint(2F, -15F, -38F);*/

        right = new ModelRendererTurbo[2];
        right[0] = new ModelRendererTurbo(this, 1, 57, textureX, textureY); // Box 33
        right[1] = new ModelRendererTurbo(this, 489, 1, textureX, textureY); // Box 34

        right[0].addShapeBox(0F, 0F, -21F, 12, 12, 1, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 4F, 0F, 0F, 0F); // Box 33
        right[0].setRotationPoint(0F, -32F, 0F);

        right[1].addShapeBox(12F, 0F, -17F, 9, 12, 1, 0F, 0F, 0F, 0F, 0F, 0F, -9F, 0F, 0F, 9F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -9F, 0F, 0F, 9F, 0F, 0F, 0F); // Box 34
        right[1].setRotationPoint(0F, -32F, 0F);

        left = new ModelRendererTurbo[2];
        left[0] = new ModelRendererTurbo(this, 1, 73, textureX, textureY); // Box 38
        left[1] = new ModelRendererTurbo(this, 25, 25, textureX, textureY); // Box 39

        left[0].addShapeBox(-12F, 0F, -21F, 12, 12, 1, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 4F); // Box 38
        left[0].setRotationPoint(0F, -32F, 0F);

        left[1].addShapeBox(-21F, 0F, -17F, 9, 12, 1, 0F, 0F, 0F, -9F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 9F, 0F, 0F, -9F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 9F); // Box 39
        left[1].setRotationPoint(0F, -32F, 0F);

        translateAll(0F, 0F, 0F);
        flipAll();
    }
    
    private float quarterrad = Static.rad1 / 4;
    
	@Override
	public void render(BlockData data, BlockTileEntity key, Entity ent, int meta){
		render(body);
		if(data.getScript() != null && key != null){
	    	float angle = RenderCache.getData(key.getLongPos(), "openstate", 0) + (data.getScript(SmelteryScript.class).open ? 1 : -1);
	    	RenderCache.updateData(key.getLongPos(), "openstate", angle = angle > 160 ? 160 : angle < 0 ? 0 : angle);
	    	//
	    	rotate(left, 0, quarterrad * angle, 0);
	        render(left);
	    	rotate(left, 0, quarterrad * -angle, 0);
	    	rotate(right, 0, quarterrad * -angle, 0);
	        render(right);
	    	rotate(right, 0, quarterrad * angle, 0);
		}
		else{
			render(right);
			render(left);
		}
	}

}
