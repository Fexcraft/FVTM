package net.fexcraft.mod.fvtm.model.block;

import net.fexcraft.mod.lib.tmt.ModelConverter;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class SmelteryModel extends ModelConverter {

    int textureX = 512;
    int textureY = 256;

    public SmelteryModel(){
        bodyModel = new ModelRendererTurbo[43];
        bodyModel[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
        bodyModel[1] = new ModelRendererTurbo(this, 201, 1, textureX, textureY); // Box 1
        bodyModel[2] = new ModelRendererTurbo(this, 313, 1, textureX, textureY); // Box 2
        bodyModel[3] = new ModelRendererTurbo(this, 377, 25, textureX, textureY); // Box 3
        bodyModel[4] = new ModelRendererTurbo(this, 1, 57, textureX, textureY); // Box 4
        bodyModel[5] = new ModelRendererTurbo(this, 377, 1, textureX, textureY); // Box 5
        bodyModel[6] = new ModelRendererTurbo(this, 65, 57, textureX, textureY); // Box 6
        bodyModel[7] = new ModelRendererTurbo(this, 129, 57, textureX, textureY); // Box 7
        bodyModel[8] = new ModelRendererTurbo(this, 193, 73, textureX, textureY); // Box 8
        bodyModel[9] = new ModelRendererTurbo(this, 257, 73, textureX, textureY); // Box 9
        bodyModel[10] = new ModelRendererTurbo(this, 65, 81, textureX, textureY); // Box 10
        bodyModel[11] = new ModelRendererTurbo(this, 153, 1, textureX, textureY); // Box 11
        bodyModel[12] = new ModelRendererTurbo(this, 305, 97, textureX, textureY); // Box 12
        bodyModel[13] = new ModelRendererTurbo(this, 385, 97, textureX, textureY); // Box 13
        bodyModel[14] = new ModelRendererTurbo(this, 105, 121, textureX, textureY); // Box 14
        bodyModel[15] = new ModelRendererTurbo(this, 1, 129, textureX, textureY); // Box 15
        bodyModel[16] = new ModelRendererTurbo(this, 265, 1, textureX, textureY); // Box 16
        bodyModel[17] = new ModelRendererTurbo(this, 249, 97, textureX, textureY); // Box 17
        bodyModel[18] = new ModelRendererTurbo(this, 129, 121, textureX, textureY); // Box 18
        bodyModel[19] = new ModelRendererTurbo(this, 233, 169, textureX, textureY); // Box 19
        bodyModel[20] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 20
        bodyModel[21] = new ModelRendererTurbo(this, 153, 17, textureX, textureY); // Box 21
        bodyModel[22] = new ModelRendererTurbo(this, 265, 25, textureX, textureY); // Box 22
        bodyModel[23] = new ModelRendererTurbo(this, 337, 177, textureX, textureY); // Box 23
        bodyModel[24] = new ModelRendererTurbo(this, 441, 25, textureX, textureY); // Box 24
        bodyModel[25] = new ModelRendererTurbo(this, 193, 17, textureX, textureY); // Box 25
        bodyModel[26] = new ModelRendererTurbo(this, 1, 25, textureX, textureY); // Box 26
        bodyModel[27] = new ModelRendererTurbo(this, 329, 1, textureX, textureY); // Box 27
        bodyModel[28] = new ModelRendererTurbo(this, 329, 9, textureX, textureY); // Box 28
        bodyModel[29] = new ModelRendererTurbo(this, 217, 17, textureX, textureY); // Box 29
        bodyModel[30] = new ModelRendererTurbo(this, 217, 25, textureX, textureY); // Box 30
        bodyModel[31] = new ModelRendererTurbo(this, 377, 25, textureX, textureY); // Box 31
        bodyModel[32] = new ModelRendererTurbo(this, 441, 57, textureX, textureY); // Box 32
        bodyModel[33] = new ModelRendererTurbo(this, 433, 97, textureX, textureY); // Box 35
        bodyModel[34] = new ModelRendererTurbo(this, 433, 113, textureX, textureY); // Box 36
        bodyModel[35] = new ModelRendererTurbo(this, 185, 153, textureX, textureY); // Box 37
        bodyModel[36] = new ModelRendererTurbo(this, 193, 73, textureX, textureY); // Box 41
        bodyModel[37] = new ModelRendererTurbo(this, 41, 1, textureX, textureY); // Box 50
        bodyModel[38] = new ModelRendererTurbo(this, 241, 1, textureX, textureY); // Box 51
        bodyModel[39] = new ModelRendererTurbo(this, 41, 9, textureX, textureY); // Box 52
        bodyModel[40] = new ModelRendererTurbo(this, 241, 9, textureX, textureY); // Box 53
        bodyModel[41] = new ModelRendererTurbo(this, 153, 41, textureX, textureY); // Box 54
        bodyModel[42] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 56

        bodyModel[0].addBox(-24F, 0F, -24F, 48, 4, 48, 0F); // Box 0
        bodyModel[0].setRotationPoint(0F, -4F, 0F);

        bodyModel[1].addShapeBox(0F, 0F, 0F, 4, 16, 48, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F); // Box 1
        bodyModel[1].setRotationPoint(-24F, -20F, -24F);

        bodyModel[2].addShapeBox(0F, 0F, 0F, 4, 16, 48, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F); // Box 2
        bodyModel[2].setRotationPoint(20F, -20F, -24F);

        bodyModel[3].addShapeBox(0F, 0F, 0F, 4, 16, 48, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F); // Box 3
        bodyModel[3].setRotationPoint(20F, -36F, -24F);

        bodyModel[4].addShapeBox(0F, 0F, 0F, 4, 16, 48, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F); // Box 4
        bodyModel[4].setRotationPoint(-24F, -36F, -24F);

        bodyModel[5].addShapeBox(0F, 0F, 0F, 48, 16, 4, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 5
        bodyModel[5].setRotationPoint(-24F, -20F, 20F);

        bodyModel[6].addShapeBox(0F, 0F, 0F, 48, 16, 4, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 6
        bodyModel[6].setRotationPoint(-24F, -36F, 20F);

        bodyModel[7].addShapeBox(0F, 0F, 0F, 4, 12, 48, 0F, -8F, 0F, -8F, 8F, 0F, -12F, 8F, 0F, -12F, -8F, 0F, -8F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F); // Box 7
        bodyModel[7].setRotationPoint(-24F, -48F, -24F);

        bodyModel[8].addShapeBox(0F, 0F, 0F, 4, 12, 48, 0F, 8F, 0F, -12F, -8F, 0F, -8F, -8F, 0F, -8F, 8F, 0F, -12F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F); // Box 8
        bodyModel[8].setRotationPoint(20F, -48F, -24F);

        bodyModel[9].addShapeBox(0F, 0F, 0F, 48, 12, 4, 0F, -8F, 0F, -8F, -8F, 0F, -8F, -12F, 0F, 8F, -12F, 0F, 8F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F); // Box 9
        bodyModel[9].setRotationPoint(-24F, -48F, -24F);

        bodyModel[10].addShapeBox(0F, 0F, 0F, 48, 12, 4, 0F, -12F, 0F, 8F, -12F, 0F, 8F, -8F, 0F, -8F, -8F, 0F, -8F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 10
        bodyModel[10].setRotationPoint(-24F, -48F, 20F);

        bodyModel[11].addBox(0F, 0F, 0F, 40, 4, 4, 0F); // Box 11
        bodyModel[11].setRotationPoint(-20F, -36F, -24F);

        bodyModel[12].addShapeBox(0F, 0F, 0F, 32, 44, 4, 0F, -2F, 0F, -2F, -2F, 0F, -2F, -6F, 0F, 2F, -6F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F); // Box 12
        bodyModel[12].setRotationPoint(-16F, -92F, -16F);

        bodyModel[13].addShapeBox(0F, 0F, 0F, 4, 44, 32, 0F, -2F, 0F, -2F, 2F, 0F, -6F, 2F, 0F, -6F, -2F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F); // Box 13
        bodyModel[13].setRotationPoint(-16F, -92F, -16F);

        bodyModel[14].addShapeBox(0F, 0F, 0F, 32, 44, 4, 0F, -6F, 0F, 2F, -6F, 0F, 2F, -2F, 0F, -2F, -2F, 0F, -2F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 14
        bodyModel[14].setRotationPoint(-16F, -92F, 12F);

        bodyModel[15].addShapeBox(0F, 0F, 0F, 4, 44, 32, 0F, 2F, 0F, -6F, -2F, 0F, -2F, -2F, 0F, -2F, 2F, 0F, -6F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F); // Box 15
        bodyModel[15].setRotationPoint(12F, -92F, -16F);

        bodyModel[16].addBox(0F, 0F, 0F, 20, 1, 20, 0F); // Box 16
        bodyModel[16].setRotationPoint(-10F, -90F, -10F);

        bodyModel[17].addShapeBox(0F, 0F, 0F, 1, 18, 49, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 17
        bodyModel[17].setRotationPoint(-25F, -18F, -24F);

        bodyModel[18].addShapeBox(0F, 0F, 0F, 1, 18, 49, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 18
        bodyModel[18].setRotationPoint(24F, -18F, -24F);

        bodyModel[19].addShapeBox(0F, 0F, 0F, 48, 18, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 19
        bodyModel[19].setRotationPoint(-24F, -18F, 24F);

        bodyModel[20].addBox(0F, 0F, 0F, 17, 18, 1, 0F); // Box 20
        bodyModel[20].setRotationPoint(-25F, -18F, -25F);

        bodyModel[21].addBox(0F, 0F, 0F, 17, 18, 1, 0F); // Box 21
        bodyModel[21].setRotationPoint(8F, -18F, -25F);

        bodyModel[22].addBox(0F, 0F, 0F, 40, 8, 4, 0F); // Box 22
        bodyModel[22].setRotationPoint(-20F, -20F, -24F);

        bodyModel[23].addBox(0F, 0F, 0F, 40, 6, 4, 0F); // Box 23
        bodyModel[23].setRotationPoint(-20F, -10F, -24F);

        bodyModel[24].addBox(0F, 0F, 0F, 16, 13, 16, 0F); // Box 24
        bodyModel[24].setRotationPoint(-8F, -13F, -40F);

        bodyModel[25].addBox(0F, 0F, 0F, 2, 3, 16, 0F); // Box 25
        bodyModel[25].setRotationPoint(-8F, -16F, -40F);

        bodyModel[26].addBox(0F, 0F, 0F, 2, 3, 16, 0F); // Box 26
        bodyModel[26].setRotationPoint(6F, -16F, -40F);

        bodyModel[27].addBox(0F, 0F, 0F, 12, 3, 2, 0F); // Box 27
        bodyModel[27].setRotationPoint(-6F, -16F, -40F);

        bodyModel[28].addBox(0F, 0F, 0F, 12, 4, 2, 0F); // Box 28
        bodyModel[28].setRotationPoint(-6F, -16F, -36F);

        bodyModel[29].addBox(0F, 0F, 0F, 12, 4, 2, 0F); // Box 29
        bodyModel[29].setRotationPoint(-6F, -16F, -32F);

        bodyModel[30].addBox(0F, 0F, 0F, 12, 4, 2, 0F); // Box 30
        bodyModel[30].setRotationPoint(-6F, -16F, -28F);

        bodyModel[31].addShapeBox(0F, 0F, 0F, 2, 2, 15, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 31
        bodyModel[31].setRotationPoint(-1F, -18F, -38.5F);

        bodyModel[32].addShapeBox(0F, 0F, 0F, 20, 1, 12, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -10F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -10F); // Box 32
        bodyModel[32].setRotationPoint(0F, -20F, -20F);

        bodyModel[33].addShapeBox(0F, 0F, 0F, 20, 1, 12, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -10F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -10F, 0F, 0F, 0F); // Box 35
        bodyModel[33].setRotationPoint(-20F, -20F, -20F);

        bodyModel[34].addShapeBox(0F, 0F, 0F, 20, 1, 12, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -10F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -10F); // Box 36
        bodyModel[34].setRotationPoint(0F, -33F, -20F);

        bodyModel[35].addShapeBox(0F, 0F, 0F, 20, 1, 12, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -10F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -10F, 0F, 0F, 0F); // Box 37
        bodyModel[35].setRotationPoint(-20F, -33F, -20F);

        bodyModel[36].addBox(0F, 0F, 0F, 4, 5, 16, 0F); // Box 41
        bodyModel[36].setRotationPoint(-2F, -16.5F, -39.5F);

        bodyModel[37].addShapeBox(0F, 0F, 0F, 2, 2, 1, 0F, 0F, -1.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 50
        bodyModel[37].setRotationPoint(6F, -18F, -25F);

        bodyModel[38].addShapeBox(0F, 0F, 0F, 2, 2, 1, 0F, 0F, 0F, 0F, 0F, -1.8F, 0F, 0F, -1.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 51
        bodyModel[38].setRotationPoint(-8F, -18F, -25F);

        bodyModel[39].addBox(0F, 0F, 0F, 2, 4, 1, 0F); // Box 52
        bodyModel[39].setRotationPoint(-23F, -30F, -24.5F);

        bodyModel[40].addBox(0F, 0F, 0F, 2, 4, 1, 0F); // Box 53
        bodyModel[40].setRotationPoint(21F, -30F, -24.5F);

        bodyModel[41].addShapeBox(0F, 0F, 0F, 42, 3, 2, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 2F, 0F, 1F, 2F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F); // Box 54
        bodyModel[41].setRotationPoint(-21F, -36F, -25F);

        bodyModel[42].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 56
        bodyModel[42].setRotationPoint(0F, 0F, 0F);

        turretModel = new ModelRendererTurbo[8];
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
        turretModel[7].setRotationPoint(2F, -15F, -38F);

        barrelModel = new ModelRendererTurbo[1];
        barrelModel[0] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 55

        barrelModel[0].addBox(0F, 0F, 0F, 16, 16, 16, 0F); // Box 55
        barrelModel[0].setRotationPoint(-8F, 0F, -8F);

        trailerModel = new ModelRendererTurbo[2];
        trailerModel[0] = new ModelRendererTurbo(this, 1, 57, textureX, textureY); // Box 33
        trailerModel[1] = new ModelRendererTurbo(this, 489, 1, textureX, textureY); // Box 34

        trailerModel[0].addShapeBox(0F, 0F, -21F, 12, 12, 1, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 4F, 0F, 0F, 0F); // Box 33
        trailerModel[0].setRotationPoint(0F, -32F, 0F);

        trailerModel[1].addShapeBox(12F, 0F, -17F, 9, 12, 1, 0F, 0F, 0F, 0F, 0F, 0F, -9F, 0F, 0F, 9F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -9F, 0F, 0F, 9F, 0F, 0F, 0F); // Box 34
        trailerModel[1].setRotationPoint(0F, -32F, 0F);

        barrelModel = new ModelRendererTurbo[2];
        barrelModel[0] = new ModelRendererTurbo(this, 1, 73, textureX, textureY); // Box 38
        barrelModel[1] = new ModelRendererTurbo(this, 25, 25, textureX, textureY); // Box 39

        barrelModel[0].addShapeBox(-12F, 0F, -21F, 12, 12, 1, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 4F); // Box 38
        barrelModel[0].setRotationPoint(0F, -32F, 0F);

        barrelModel[1].addShapeBox(-21F, 0F, -17F, 9, 12, 1, 0F, 0F, 0F, -9F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 9F, 0F, 0F, -9F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 9F); // Box 39
        barrelModel[1].setRotationPoint(0F, -32F, 0F);

        translateAll(0F, 0F, 0F);
        flipAll();
    }

}
