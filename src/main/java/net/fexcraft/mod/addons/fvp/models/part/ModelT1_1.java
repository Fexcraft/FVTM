package net.fexcraft.mod.addons.fvp.models.part;

import net.fexcraft.mod.fvtm.model.part.PartModel;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelT1_1 extends PartModel {

    int textureX = 1024;
    int textureY = 1024;

    public ModelT1_1(){
        this.creators.add("Ferdinand (FEX___96)");
        body = new ModelRendererTurbo[48];
        body[0] = new ModelRendererTurbo(this, 465, 145, textureX, textureY); // Box 219
        body[1] = new ModelRendererTurbo(this, 977, 177, textureX, textureY); // Box 4
        body[2] = new ModelRendererTurbo(this, 985, 177, textureX, textureY); // Box 5
        body[3] = new ModelRendererTurbo(this, 513, 257, textureX, textureY); // Box 8
        body[4] = new ModelRendererTurbo(this, 345, 161, textureX, textureY); // Box 669
        body[5] = new ModelRendererTurbo(this, 385, 161, textureX, textureY); // Box 670
        body[6] = new ModelRendererTurbo(this, 481, 161, textureX, textureY); // Box 671
        body[7] = new ModelRendererTurbo(this, 505, 161, textureX, textureY); // Box 672
        body[8] = new ModelRendererTurbo(this, 769, 161, textureX, textureY); // Box 673
        body[9] = new ModelRendererTurbo(this, 793, 161, textureX, textureY); // Box 674
        body[10] = new ModelRendererTurbo(this, 889, 169, textureX, textureY); // Box 675
        body[11] = new ModelRendererTurbo(this, 185, 177, textureX, textureY); // Box 676
        body[12] = new ModelRendererTurbo(this, 217, 177, textureX, textureY); // Box 677
        body[13] = new ModelRendererTurbo(this, 849, 177, textureX, textureY); // Box 678
        body[14] = new ModelRendererTurbo(this, 921, 161, textureX, textureY); // Box 679
        body[15] = new ModelRendererTurbo(this, 913, 169, textureX, textureY); // Box 680
        body[16] = new ModelRendererTurbo(this, 185, 177, textureX, textureY); // Box 681
        body[17] = new ModelRendererTurbo(this, 209, 177, textureX, textureY); // Box 682
        body[18] = new ModelRendererTurbo(this, 817, 193, textureX, textureY); // Box 683
        body[19] = new ModelRendererTurbo(this, 305, 225, textureX, textureY); // Box 684
        body[20] = new ModelRendererTurbo(this, 305, 233, textureX, textureY); // Box 685
        body[21] = new ModelRendererTurbo(this, 305, 241, textureX, textureY); // Box 686
        body[22] = new ModelRendererTurbo(this, 449, 161, textureX, textureY); // Box 687
        body[23] = new ModelRendererTurbo(this, 465, 161, textureX, textureY); // Box 688
        body[24] = new ModelRendererTurbo(this, 809, 161, textureX, textureY); // Box 689
        body[25] = new ModelRendererTurbo(this, 825, 161, textureX, textureY); // Box 690
        body[26] = new ModelRendererTurbo(this, 929, 161, textureX, textureY); // Box 691
        body[27] = new ModelRendererTurbo(this, 1, 169, textureX, textureY); // Box 692
        body[28] = new ModelRendererTurbo(this, 9, 169, textureX, textureY); // Box 693
        body[29] = new ModelRendererTurbo(this, 25, 169, textureX, textureY); // Box 694
        body[30] = new ModelRendererTurbo(this, 33, 169, textureX, textureY); // Box 695
        body[31] = new ModelRendererTurbo(this, 57, 169, textureX, textureY); // Box 696
        body[32] = new ModelRendererTurbo(this, 65, 169, textureX, textureY); // Box 697
        body[33] = new ModelRendererTurbo(this, 313, 169, textureX, textureY); // Box 698
        body[34] = new ModelRendererTurbo(this, 321, 169, textureX, textureY); // Box 699
        body[35] = new ModelRendererTurbo(this, 337, 169, textureX, textureY); // Box 700
        body[36] = new ModelRendererTurbo(this, 345, 169, textureX, textureY); // Box 701
        body[37] = new ModelRendererTurbo(this, 361, 169, textureX, textureY); // Box 702
        body[38] = new ModelRendererTurbo(this, 369, 169, textureX, textureY); // Box 703
        body[39] = new ModelRendererTurbo(this, 385, 169, textureX, textureY); // Box 704
        body[40] = new ModelRendererTurbo(this, 393, 169, textureX, textureY); // Box 705
        body[41] = new ModelRendererTurbo(this, 481, 169, textureX, textureY); // Box 706
        body[42] = new ModelRendererTurbo(this, 489, 169, textureX, textureY); // Box 707
        body[43] = new ModelRendererTurbo(this, 505, 169, textureX, textureY); // Box 708
        body[44] = new ModelRendererTurbo(this, 769, 169, textureX, textureY); // Box 709
        body[45] = new ModelRendererTurbo(this, 777, 169, textureX, textureY); // Box 710
        body[46] = new ModelRendererTurbo(this, 793, 169, textureX, textureY); // Box 711
        body[47] = new ModelRendererTurbo(this, 881, 169, textureX, textureY); // Box 712

        body[0].addShapeBox(0F, 0F, 0F, 124, 1, 51, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 219
        body[0].setRotationPoint(-102F, -12F, -25.5F);

        body[1].addBox(0F, 0F, 0F, 2, 48, 1, 0F); // Box 4
        body[1].setRotationPoint(-101.5F, -60F, -24.5F);

        body[2].addBox(0F, 0F, 0F, 2, 48, 1, 0F); // Box 5
        body[2].setRotationPoint(-101.5F, -60F, 23.5F);

        body[3].addBox(0F, 0F, 0F, 2, 3, 46, 0F); // Box 8
        body[3].setRotationPoint(-102.5F, -11.5F, -23F);

        body[4].addShapeBox(0F, 0F, 0F, 2, 4, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 669
        body[4].setRotationPoint(-102.5F, -57F, -25F);

        body[5].addShapeBox(0F, 0F, 0F, 2, 4, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 670
        body[5].setRotationPoint(-102.5F, -36.5F, -25F);

        body[6].addShapeBox(0F, 0F, 0F, 2, 4, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 671
        body[6].setRotationPoint(-102.5F, -19F, -25F);

        body[7].addShapeBox(0F, 0F, 0F, 2, 4, 2, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 672
        body[7].setRotationPoint(-102.5F, -19F, 23F);

        body[8].addShapeBox(0F, 0F, 0F, 2, 4, 2, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 673
        body[8].setRotationPoint(-102.5F, -36.5F, 23F);

        body[9].addShapeBox(0F, 0F, 0F, 2, 4, 2, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 674
        body[9].setRotationPoint(-102.5F, -57F, 23F);

        body[10].addBox(0F, 0F, 0F, 2, 2, 12, 0F); // Box 675
        body[10].setRotationPoint(-2F, -5F, -22.5F);

        body[11].addBox(0F, 0F, 0F, 2, 2, 12, 0F); // Box 676
        body[11].setRotationPoint(-48F, -5F, -22.5F);

        body[12].addBox(0F, 0F, 0F, 2, 2, 12, 0F); // Box 677
        body[12].setRotationPoint(-2F, -5F, 11.5F);

        body[13].addBox(0F, 0F, 0F, 2, 2, 12, 0F); // Box 678
        body[13].setRotationPoint(-48F, -5F, 11.5F);

        body[14].addBox(0F, 0F, 0F, 2, 10, 1, 0F); // Box 679
        body[14].setRotationPoint(-2F, -11F, -23.5F);

        body[15].addBox(0F, 0F, 0F, 2, 10, 1, 0F); // Box 680
        body[15].setRotationPoint(-48F, -11F, -23.5F);

        body[16].addBox(0F, 0F, 0F, 2, 10, 1, 0F); // Box 681
        body[16].setRotationPoint(-2F, -11F, 22.5F);

        body[17].addBox(0F, 0F, 0F, 2, 10, 1, 0F); // Box 682
        body[17].setRotationPoint(-48F, -11F, 22.5F);

        body[18].addBox(0F, 0F, 0F, 64, 4, 1, 0F); // Box 683
        body[18].setRotationPoint(-56F, -10F, -24F);

        body[19].addBox(0F, 0F, 0F, 64, 4, 1, 0F); // Box 684
        body[19].setRotationPoint(-56F, -4F, -24F);

        body[20].addBox(0F, 0F, 0F, 64, 4, 1, 0F); // Box 685
        body[20].setRotationPoint(-56F, -4F, 23F);

        body[21].addBox(0F, 0F, 0F, 64, 4, 1, 0F); // Box 686
        body[21].setRotationPoint(-56F, -10F, 23F);

        body[22].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 687
        body[22].setRotationPoint(-101.5F, -60F, 24.3F);
        body[22].rotateAngleX = 0.01745329F;

        body[23].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 688
        body[23].setRotationPoint(-81.5F, -60F, 24.3F);
        body[23].rotateAngleX = 0.01745329F;

        body[24].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 689
        body[24].setRotationPoint(-71.5F, -60F, 24.3F);
        body[24].rotateAngleX = 0.01745329F;

        body[25].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 690
        body[25].setRotationPoint(-61.5F, -60F, 24.3F);
        body[25].rotateAngleX = 0.01745329F;

        body[26].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 691
        body[26].setRotationPoint(-51.5F, -60F, 24.3F);
        body[26].rotateAngleX = 0.01745329F;

        body[27].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 692
        body[27].setRotationPoint(-41.5F, -60F, 24.3F);
        body[27].rotateAngleX = 0.01745329F;

        body[28].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 693
        body[28].setRotationPoint(-31.5F, -60F, 24.3F);
        body[28].rotateAngleX = 0.01745329F;

        body[29].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 694
        body[29].setRotationPoint(-21.5F, -60F, 24.3F);
        body[29].rotateAngleX = 0.01745329F;

        body[30].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 695
        body[30].setRotationPoint(-11.5F, -60F, 24.3F);
        body[30].rotateAngleX = 0.01745329F;

        body[31].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 696
        body[31].setRotationPoint(-1.5F, -60F, 24.3F);
        body[31].rotateAngleX = 0.01745329F;

        body[32].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 697
        body[32].setRotationPoint(8.5F, -60F, 24.3F);
        body[32].rotateAngleX = 0.01745329F;

        body[33].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 698
        body[33].setRotationPoint(18.5F, -60F, 24.3F);
        body[33].rotateAngleX = 0.01745329F;

        body[34].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 699
        body[34].setRotationPoint(-91.5F, -60F, 24.3F);
        body[34].rotateAngleX = 0.01745329F;

        body[35].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 700
        body[35].setRotationPoint(-101.5F, -60F, -26.3F);
        body[35].rotateAngleX = 0.01745329F;

        body[36].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 701
        body[36].setRotationPoint(-91.5F, -60F, -26.3F);
        body[36].rotateAngleX = 0.01745329F;

        body[37].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 702
        body[37].setRotationPoint(-81.5F, -60F, -26.3F);
        body[37].rotateAngleX = 0.01745329F;

        body[38].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 703
        body[38].setRotationPoint(-71.5F, -60F, -26.3F);
        body[38].rotateAngleX = 0.01745329F;

        body[39].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 704
        body[39].setRotationPoint(-61.5F, -60F, -26.3F);
        body[39].rotateAngleX = 0.01745329F;

        body[40].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 705
        body[40].setRotationPoint(-51.5F, -60F, -26.3F);
        body[40].rotateAngleX = 0.01745329F;

        body[41].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 706
        body[41].setRotationPoint(-41.5F, -60F, -26.3F);
        body[41].rotateAngleX = 0.01745329F;

        body[42].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 707
        body[42].setRotationPoint(-31.5F, -60F, -26.3F);
        body[42].rotateAngleX = 0.01745329F;

        body[43].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 708
        body[43].setRotationPoint(-21.5F, -60F, -26.3F);
        body[43].rotateAngleX = 0.01745329F;

        body[44].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 709
        body[44].setRotationPoint(-11.5F, -60F, -26.3F);
        body[44].rotateAngleX = 0.01745329F;

        body[45].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 710
        body[45].setRotationPoint(-1.5F, -60F, -26.3F);
        body[45].rotateAngleX = 0.01745329F;

        body[46].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 711
        body[46].setRotationPoint(8.5F, -60F, -26.3F);
        body[46].rotateAngleX = 0.01745329F;

        body[47].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 712
        body[47].setRotationPoint(18.5F, -60F, -26.3F);
        body[47].rotateAngleX = 0.01745329F;

        bodyDoorOpen = new ModelRendererTurbo[23];
        bodyDoorOpen[0] = new ModelRendererTurbo(this, 721, 257, textureX, textureY); // Box 645
        bodyDoorOpen[1] = new ModelRendererTurbo(this, 417, 161, textureX, textureY); // Box 646
        bodyDoorOpen[2] = new ModelRendererTurbo(this, 433, 161, textureX, textureY); // Box 647
        bodyDoorOpen[3] = new ModelRendererTurbo(this, 849, 257, textureX, textureY); // Box 648
        bodyDoorOpen[4] = new ModelRendererTurbo(this, 1, 273, textureX, textureY); // Box 649
        bodyDoorOpen[5] = new ModelRendererTurbo(this, 921, 105, textureX, textureY); // Box 650
        bodyDoorOpen[6] = new ModelRendererTurbo(this, 25, 113, textureX, textureY); // Box 651
        bodyDoorOpen[7] = new ModelRendererTurbo(this, 961, 121, textureX, textureY); // Box 652
        bodyDoorOpen[8] = new ModelRendererTurbo(this, 33, 129, textureX, textureY); // Box 653
        bodyDoorOpen[9] = new ModelRendererTurbo(this, 153, 129, textureX, textureY); // Box 654
        bodyDoorOpen[10] = new ModelRendererTurbo(this, 1, 137, textureX, textureY); // Box 655
        bodyDoorOpen[11] = new ModelRendererTurbo(this, 249, 153, textureX, textureY); // Box 656
        bodyDoorOpen[12] = new ModelRendererTurbo(this, 97, 161, textureX, textureY); // Box 657
        bodyDoorOpen[13] = new ModelRendererTurbo(this, 105, 161, textureX, textureY); // Box 658
        bodyDoorOpen[14] = new ModelRendererTurbo(this, 313, 161, textureX, textureY); // Box 659
        bodyDoorOpen[15] = new ModelRendererTurbo(this, 321, 161, textureX, textureY); // Box 660
        bodyDoorOpen[16] = new ModelRendererTurbo(this, 337, 161, textureX, textureY); // Box 664
        bodyDoorOpen[17] = new ModelRendererTurbo(this, 785, 121, textureX, textureY); // Box 665
        bodyDoorOpen[18] = new ModelRendererTurbo(this, 417, 129, textureX, textureY); // Box 666
        bodyDoorOpen[19] = new ModelRendererTurbo(this, 361, 161, textureX, textureY); // Box 667
        bodyDoorOpen[20] = new ModelRendererTurbo(this, 609, 9, textureX, textureY); // Box 668
        bodyDoorOpen[21] = new ModelRendererTurbo(this, 609, 9, textureX, textureY); // Box 717
        bodyDoorOpen[22] = new ModelRendererTurbo(this, 609, 9, textureX, textureY); // Box 718

        bodyDoorOpen[0].addShapeBox(0F, 0F, 0F, 16, 2, 46, 0F, 0F, -1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 645
        bodyDoorOpen[0].setRotationPoint(-120.5F, 8F, -23F);

        bodyDoorOpen[1].addShapeBox(0F, 0F, 0F, 2, 17, 2, 0F, -2.5F, 0F, 0F, 2.5F, 0F, 0F, 2.5F, 0F, 0F, -2.5F, 0F, 0F, 1.5F, 0F, 0F, -1.5F, 1F, 0F, -1.5F, 1F, 0F, 1.5F, 0F, 0F); // Box 646
        bodyDoorOpen[1].setRotationPoint(-105F, -8.5F, -17F);

        bodyDoorOpen[2].addShapeBox(0F, 0F, 0F, 2, 17, 2, 0F, -2.5F, 0F, 0F, 2.5F, 0F, 0F, 2.5F, 0F, 0F, -2.5F, 0F, 0F, 1.5F, 0F, 0F, -1.5F, 1F, 0F, -1.5F, 1F, 0F, 1.5F, 0F, 0F); // Box 647
        bodyDoorOpen[2].setRotationPoint(-105F, -8.5F, 15F);

        bodyDoorOpen[3].addBox(0F, 0F, 0F, 1, 48, 25, 0F); // Box 648
        bodyDoorOpen[3].setRotationPoint(-102.5F, -60F, -50F);

        bodyDoorOpen[4].addBox(0F, 0F, 0F, 1, 48, 25, 0F); // Box 649
        bodyDoorOpen[4].setRotationPoint(-102.5F, -60F, 25F);

        bodyDoorOpen[5].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 650
        bodyDoorOpen[5].setRotationPoint(-102.3F, -60F, -47F);
        bodyDoorOpen[5].rotateAngleX = 0.01745329F;

        bodyDoorOpen[6].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 651
        bodyDoorOpen[6].setRotationPoint(-102.3F, -50F, -27F);
        bodyDoorOpen[6].rotateAngleX = 0.01745329F;

        bodyDoorOpen[7].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 652
        bodyDoorOpen[7].setRotationPoint(-102.3F, -40F, -27F);
        bodyDoorOpen[7].rotateAngleX = 0.01745329F;

        bodyDoorOpen[8].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 653
        bodyDoorOpen[8].setRotationPoint(-102.3F, -30F, -27F);
        bodyDoorOpen[8].rotateAngleX = 0.01745329F;

        bodyDoorOpen[9].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 654
        bodyDoorOpen[9].setRotationPoint(-102.3F, -20F, -27F);
        bodyDoorOpen[9].rotateAngleX = 0.01745329F;

        bodyDoorOpen[10].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 655
        bodyDoorOpen[10].setRotationPoint(-102.3F, -60F, -27F);
        bodyDoorOpen[10].rotateAngleX = 0.01745329F;

        bodyDoorOpen[11].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 656
        bodyDoorOpen[11].setRotationPoint(-102.3F, -60F, 25F);
        bodyDoorOpen[11].rotateAngleX = 0.01745329F;

        bodyDoorOpen[12].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 657
        bodyDoorOpen[12].setRotationPoint(-102.3F, -60F, 45F);
        bodyDoorOpen[12].rotateAngleX = 0.01745329F;

        bodyDoorOpen[13].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 658
        bodyDoorOpen[13].setRotationPoint(-102.3F, -50F, 25F);
        bodyDoorOpen[13].rotateAngleX = 0.01745329F;

        bodyDoorOpen[14].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 659
        bodyDoorOpen[14].setRotationPoint(-102.3F, -40F, 25F);
        bodyDoorOpen[14].rotateAngleX = 0.01745329F;

        bodyDoorOpen[15].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 660
        bodyDoorOpen[15].setRotationPoint(-102.3F, -20F, 25F);
        bodyDoorOpen[15].rotateAngleX = 0.01745329F;

        bodyDoorOpen[16].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 664
        bodyDoorOpen[16].setRotationPoint(-102.3F, -30F, 25F);
        bodyDoorOpen[16].rotateAngleX = 0.01745329F;

        bodyDoorOpen[17].addShapeBox(0F, 0F, 0F, 1, 2, 4, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 665
        bodyDoorOpen[17].setRotationPoint(-102.3F, -58F, -50F);
        bodyDoorOpen[17].rotateAngleX = 0.01745329F;

        bodyDoorOpen[18].addShapeBox(0F, 0F, 0F, 1, 2, 4, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 666
        bodyDoorOpen[18].setRotationPoint(-102.3F, -43F, -50F);
        bodyDoorOpen[18].rotateAngleX = 0.01745329F;

        bodyDoorOpen[19].addShapeBox(0F, 0F, 0F, 1, 2, 4, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 667
        bodyDoorOpen[19].setRotationPoint(-102.3F, -28F, -50F);
        bodyDoorOpen[19].rotateAngleX = 0.01745329F;

        bodyDoorOpen[20].addShapeBox(0F, 0F, 0F, 1, 2, 5, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 668
        bodyDoorOpen[20].setRotationPoint(-102.3F, -58F, 46F);
        bodyDoorOpen[20].rotateAngleX = 0.01745329F;

        bodyDoorOpen[21].addShapeBox(0F, 0F, 0F, 1, 2, 5, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 717
        bodyDoorOpen[21].setRotationPoint(-102.3F, -43F, 46F);
        bodyDoorOpen[21].rotateAngleX = 0.01745329F;

        bodyDoorOpen[22].addShapeBox(0F, 0F, 0F, 1, 2, 5, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 718
        bodyDoorOpen[22].setRotationPoint(-102.3F, -28F, 46F);
        bodyDoorOpen[22].rotateAngleX = 0.01745329F;

        bodyDoorClose = new ModelRendererTurbo[22];
        bodyDoorClose[0] = new ModelRendererTurbo(this, 953, 233, textureX, textureY); // Box 6
        bodyDoorClose[1] = new ModelRendererTurbo(this, 329, 249, textureX, textureY); // Box 7
        bodyDoorClose[2] = new ModelRendererTurbo(this, 617, 257, textureX, textureY); // Box 9
        bodyDoorClose[3] = new ModelRendererTurbo(this, 889, 161, textureX, textureY); // Box 10
        bodyDoorClose[4] = new ModelRendererTurbo(this, 81, 169, textureX, textureY); // Box 11
        bodyDoorClose[5] = new ModelRendererTurbo(this, 1009, 121, textureX, textureY); // Box 12
        bodyDoorClose[6] = new ModelRendererTurbo(this, 137, 161, textureX, textureY); // Box 13
        bodyDoorClose[7] = new ModelRendererTurbo(this, 377, 89, textureX, textureY); // Box 14
        bodyDoorClose[8] = new ModelRendererTurbo(this, 1017, 89, textureX, textureY); // Box 15
        bodyDoorClose[9] = new ModelRendererTurbo(this, 57, 97, textureX, textureY); // Box 16
        bodyDoorClose[10] = new ModelRendererTurbo(this, 97, 97, textureX, textureY); // Box 17
        bodyDoorClose[11] = new ModelRendererTurbo(this, 273, 97, textureX, textureY); // Box 18
        bodyDoorClose[12] = new ModelRendererTurbo(this, 313, 97, textureX, textureY); // Box 19
        bodyDoorClose[13] = new ModelRendererTurbo(this, 473, 97, textureX, textureY); // Box 20
        bodyDoorClose[14] = new ModelRendererTurbo(this, 521, 97, textureX, textureY); // Box 21
        bodyDoorClose[15] = new ModelRendererTurbo(this, 273, 105, textureX, textureY); // Box 22
        bodyDoorClose[16] = new ModelRendererTurbo(this, 377, 105, textureX, textureY); // Box 23
        bodyDoorClose[17] = new ModelRendererTurbo(this, 537, 105, textureX, textureY); // Box 24
        bodyDoorClose[18] = new ModelRendererTurbo(this, 553, 105, textureX, textureY); // Box 25
        bodyDoorClose[19] = new ModelRendererTurbo(this, 449, 161, textureX, textureY); // Box 661
        bodyDoorClose[20] = new ModelRendererTurbo(this, 809, 161, textureX, textureY); // Box 662
        bodyDoorClose[21] = new ModelRendererTurbo(this, 881, 169, textureX, textureY); // Box 663

        bodyDoorClose[0].addBox(0F, 0F, 0F, 1, 48, 25, 0F); // Box 6
        bodyDoorClose[0].setRotationPoint(-102.5F, -60F, -25F);

        bodyDoorClose[1].addBox(0F, 0F, 0F, 1, 48, 25, 0F); // Box 7
        bodyDoorClose[1].setRotationPoint(-102.5F, -60F, 0F);

        bodyDoorClose[2].addShapeBox(0F, 0F, 0F, 2, 16, 46, 0F, -1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 9
        bodyDoorClose[2].setRotationPoint(-104.5F, -26.5F, -23F);

        bodyDoorClose[3].addBox(0F, 0F, 0F, 12, 2, 2, 0F); // Box 10
        bodyDoorClose[3].setRotationPoint(-105F, -11.5F, -17F);

        bodyDoorClose[4].addBox(0F, 0F, 0F, 12, 2, 2, 0F); // Box 11
        bodyDoorClose[4].setRotationPoint(-105F, -11.5F, 15F);

        bodyDoorClose[5].addShapeBox(0F, 0F, 0F, 1, 10, 2, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 12
        bodyDoorClose[5].setRotationPoint(-105F, -21.5F, -17F);

        bodyDoorClose[6].addShapeBox(0F, 0F, 0F, 1, 10, 2, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 13
        bodyDoorClose[6].setRotationPoint(-105F, -21.5F, 15F);

        bodyDoorClose[7].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 14
        bodyDoorClose[7].setRotationPoint(-102.7F, -60F, -25F);
        bodyDoorClose[7].rotateAngleX = 0.01745329F;

        bodyDoorClose[8].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 15
        bodyDoorClose[8].setRotationPoint(-102.7F, -60F, -5F);
        bodyDoorClose[8].rotateAngleX = 0.01745329F;

        bodyDoorClose[9].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 16
        bodyDoorClose[9].setRotationPoint(-102.7F, -60F, 3F);
        bodyDoorClose[9].rotateAngleX = 0.01745329F;

        bodyDoorClose[10].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 17
        bodyDoorClose[10].setRotationPoint(-102.7F, -60F, 23F);
        bodyDoorClose[10].rotateAngleX = 0.01745329F;

        bodyDoorClose[11].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 18
        bodyDoorClose[11].setRotationPoint(-102.7F, -50F, -25F);
        bodyDoorClose[11].rotateAngleX = 0.01745329F;

        bodyDoorClose[12].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 19
        bodyDoorClose[12].setRotationPoint(-102.7F, -40F, -25F);
        bodyDoorClose[12].rotateAngleX = 0.01745329F;

        bodyDoorClose[13].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 20
        bodyDoorClose[13].setRotationPoint(-102.7F, -30F, -25F);
        bodyDoorClose[13].rotateAngleX = 0.01745329F;

        bodyDoorClose[14].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 21
        bodyDoorClose[14].setRotationPoint(-102.7F, -20F, -25F);
        bodyDoorClose[14].rotateAngleX = 0.01745329F;

        bodyDoorClose[15].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 22
        bodyDoorClose[15].setRotationPoint(-102.7F, -50F, 23F);
        bodyDoorClose[15].rotateAngleX = 0.01745329F;

        bodyDoorClose[16].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 23
        bodyDoorClose[16].setRotationPoint(-102.7F, -40F, 23F);
        bodyDoorClose[16].rotateAngleX = 0.01745329F;

        bodyDoorClose[17].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 24
        bodyDoorClose[17].setRotationPoint(-102.7F, -30F, 23F);
        bodyDoorClose[17].rotateAngleX = 0.01745329F;

        bodyDoorClose[18].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 25
        bodyDoorClose[18].setRotationPoint(-102.7F, -20F, 23F);
        bodyDoorClose[18].rotateAngleX = 0.01745329F;

        bodyDoorClose[19].addShapeBox(0F, 0F, 0F, 1, 2, 8, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 661
        bodyDoorClose[19].setRotationPoint(-102.7F, -29F, -4F);
        bodyDoorClose[19].rotateAngleX = 0.01745329F;

        bodyDoorClose[20].addShapeBox(0F, 0F, 0F, 1, 2, 8, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 662
        bodyDoorClose[20].setRotationPoint(-102.7F, -58F, -4F);
        bodyDoorClose[20].rotateAngleX = 0.01745329F;

        bodyDoorClose[21].addShapeBox(0F, 0F, 0F, 1, 2, 8, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 663
        bodyDoorClose[21].setRotationPoint(-102.7F, -43F, -4F);
        bodyDoorClose[21].rotateAngleX = 0.01745329F;

        bodyColoredSecondary = new ModelRendererTurbo[4];
        bodyColoredSecondary[0] = new ModelRendererTurbo(this, 465, 201, textureX, textureY); // Box 0
        bodyColoredSecondary[1] = new ModelRendererTurbo(this, 721, 201, textureX, textureY); // Box 1
        bodyColoredSecondary[2] = new ModelRendererTurbo(this, 1, 217, textureX, textureY); // Box 2
        bodyColoredSecondary[3] = new ModelRendererTurbo(this, 409, 209, textureX, textureY); // Box 3

        bodyColoredSecondary[0].addBox(0F, 0F, 0F, 124, 48, 1, 0F); // Box 0
        bodyColoredSecondary[0].setRotationPoint(-102F, -60F, -25.5F);

        bodyColoredSecondary[1].addBox(0F, 0F, 0F, 124, 48, 1, 0F); // Box 1
        bodyColoredSecondary[1].setRotationPoint(-102F, -60F, 24.5F);

        bodyColoredSecondary[2].addBox(0F, 0F, 0F, 124, 1, 52, 0F); // Box 2
        bodyColoredSecondary[2].setRotationPoint(-102F, -61F, -26F);

        bodyColoredSecondary[3].addBox(0F, 0F, 0F, 1, 48, 49, 0F); // Box 3
        bodyColoredSecondary[3].setRotationPoint(21F, -60F, -24.5F);

        //translateAll(0F, 0F, 0F);
    }

}
