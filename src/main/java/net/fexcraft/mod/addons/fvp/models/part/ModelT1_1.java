package net.fexcraft.mod.addons.fvp.models.part;

import net.fexcraft.mod.fvtm.model.part.PartModelTMT;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelT1_1 extends PartModelTMT {

    public ModelT1_1(){
    	super(); textureX = 1024; textureY = 1024;
        this.addToCreators("Ferdinand (FEX___96)");
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

        body_door_open = new ModelRendererTurbo[23];
        body_door_open[0] = new ModelRendererTurbo(this, 721, 257, textureX, textureY); // Box 645
        body_door_open[1] = new ModelRendererTurbo(this, 417, 161, textureX, textureY); // Box 646
        body_door_open[2] = new ModelRendererTurbo(this, 433, 161, textureX, textureY); // Box 647
        body_door_open[3] = new ModelRendererTurbo(this, 849, 257, textureX, textureY); // Box 648
        body_door_open[4] = new ModelRendererTurbo(this, 1, 273, textureX, textureY); // Box 649
        body_door_open[5] = new ModelRendererTurbo(this, 921, 105, textureX, textureY); // Box 650
        body_door_open[6] = new ModelRendererTurbo(this, 25, 113, textureX, textureY); // Box 651
        body_door_open[7] = new ModelRendererTurbo(this, 961, 121, textureX, textureY); // Box 652
        body_door_open[8] = new ModelRendererTurbo(this, 33, 129, textureX, textureY); // Box 653
        body_door_open[9] = new ModelRendererTurbo(this, 153, 129, textureX, textureY); // Box 654
        body_door_open[10] = new ModelRendererTurbo(this, 1, 137, textureX, textureY); // Box 655
        body_door_open[11] = new ModelRendererTurbo(this, 249, 153, textureX, textureY); // Box 656
        body_door_open[12] = new ModelRendererTurbo(this, 97, 161, textureX, textureY); // Box 657
        body_door_open[13] = new ModelRendererTurbo(this, 105, 161, textureX, textureY); // Box 658
        body_door_open[14] = new ModelRendererTurbo(this, 313, 161, textureX, textureY); // Box 659
        body_door_open[15] = new ModelRendererTurbo(this, 321, 161, textureX, textureY); // Box 660
        body_door_open[16] = new ModelRendererTurbo(this, 337, 161, textureX, textureY); // Box 664
        body_door_open[17] = new ModelRendererTurbo(this, 785, 121, textureX, textureY); // Box 665
        body_door_open[18] = new ModelRendererTurbo(this, 417, 129, textureX, textureY); // Box 666
        body_door_open[19] = new ModelRendererTurbo(this, 361, 161, textureX, textureY); // Box 667
        body_door_open[20] = new ModelRendererTurbo(this, 609, 9, textureX, textureY); // Box 668
        body_door_open[21] = new ModelRendererTurbo(this, 609, 9, textureX, textureY); // Box 717
        body_door_open[22] = new ModelRendererTurbo(this, 609, 9, textureX, textureY); // Box 718

        body_door_open[0].addShapeBox(0F, 0F, 0F, 16, 2, 46, 0F, 0F, -1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 645
        body_door_open[0].setRotationPoint(-120.5F, 8F, -23F);

        body_door_open[1].addShapeBox(0F, 0F, 0F, 2, 17, 2, 0F, -2.5F, 0F, 0F, 2.5F, 0F, 0F, 2.5F, 0F, 0F, -2.5F, 0F, 0F, 1.5F, 0F, 0F, -1.5F, 1F, 0F, -1.5F, 1F, 0F, 1.5F, 0F, 0F); // Box 646
        body_door_open[1].setRotationPoint(-105F, -8.5F, -17F);

        body_door_open[2].addShapeBox(0F, 0F, 0F, 2, 17, 2, 0F, -2.5F, 0F, 0F, 2.5F, 0F, 0F, 2.5F, 0F, 0F, -2.5F, 0F, 0F, 1.5F, 0F, 0F, -1.5F, 1F, 0F, -1.5F, 1F, 0F, 1.5F, 0F, 0F); // Box 647
        body_door_open[2].setRotationPoint(-105F, -8.5F, 15F);

        body_door_open[3].addBox(0F, 0F, 0F, 1, 48, 25, 0F); // Box 648
        body_door_open[3].setRotationPoint(-102.5F, -60F, -50F);

        body_door_open[4].addBox(0F, 0F, 0F, 1, 48, 25, 0F); // Box 649
        body_door_open[4].setRotationPoint(-102.5F, -60F, 25F);

        body_door_open[5].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 650
        body_door_open[5].setRotationPoint(-102.3F, -60F, -47F);
        body_door_open[5].rotateAngleX = 0.01745329F;

        body_door_open[6].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 651
        body_door_open[6].setRotationPoint(-102.3F, -50F, -27F);
        body_door_open[6].rotateAngleX = 0.01745329F;

        body_door_open[7].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 652
        body_door_open[7].setRotationPoint(-102.3F, -40F, -27F);
        body_door_open[7].rotateAngleX = 0.01745329F;

        body_door_open[8].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 653
        body_door_open[8].setRotationPoint(-102.3F, -30F, -27F);
        body_door_open[8].rotateAngleX = 0.01745329F;

        body_door_open[9].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 654
        body_door_open[9].setRotationPoint(-102.3F, -20F, -27F);
        body_door_open[9].rotateAngleX = 0.01745329F;

        body_door_open[10].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 655
        body_door_open[10].setRotationPoint(-102.3F, -60F, -27F);
        body_door_open[10].rotateAngleX = 0.01745329F;

        body_door_open[11].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 656
        body_door_open[11].setRotationPoint(-102.3F, -60F, 25F);
        body_door_open[11].rotateAngleX = 0.01745329F;

        body_door_open[12].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 657
        body_door_open[12].setRotationPoint(-102.3F, -60F, 45F);
        body_door_open[12].rotateAngleX = 0.01745329F;

        body_door_open[13].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 658
        body_door_open[13].setRotationPoint(-102.3F, -50F, 25F);
        body_door_open[13].rotateAngleX = 0.01745329F;

        body_door_open[14].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 659
        body_door_open[14].setRotationPoint(-102.3F, -40F, 25F);
        body_door_open[14].rotateAngleX = 0.01745329F;

        body_door_open[15].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 660
        body_door_open[15].setRotationPoint(-102.3F, -20F, 25F);
        body_door_open[15].rotateAngleX = 0.01745329F;

        body_door_open[16].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 664
        body_door_open[16].setRotationPoint(-102.3F, -30F, 25F);
        body_door_open[16].rotateAngleX = 0.01745329F;

        body_door_open[17].addShapeBox(0F, 0F, 0F, 1, 2, 4, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 665
        body_door_open[17].setRotationPoint(-102.3F, -58F, -50F);
        body_door_open[17].rotateAngleX = 0.01745329F;

        body_door_open[18].addShapeBox(0F, 0F, 0F, 1, 2, 4, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 666
        body_door_open[18].setRotationPoint(-102.3F, -43F, -50F);
        body_door_open[18].rotateAngleX = 0.01745329F;

        body_door_open[19].addShapeBox(0F, 0F, 0F, 1, 2, 4, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 667
        body_door_open[19].setRotationPoint(-102.3F, -28F, -50F);
        body_door_open[19].rotateAngleX = 0.01745329F;

        body_door_open[20].addShapeBox(0F, 0F, 0F, 1, 2, 5, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 668
        body_door_open[20].setRotationPoint(-102.3F, -58F, 46F);
        body_door_open[20].rotateAngleX = 0.01745329F;

        body_door_open[21].addShapeBox(0F, 0F, 0F, 1, 2, 5, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 717
        body_door_open[21].setRotationPoint(-102.3F, -43F, 46F);
        body_door_open[21].rotateAngleX = 0.01745329F;

        body_door_open[22].addShapeBox(0F, 0F, 0F, 1, 2, 5, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 718
        body_door_open[22].setRotationPoint(-102.3F, -28F, 46F);
        body_door_open[22].rotateAngleX = 0.01745329F;

        body_door_close = new ModelRendererTurbo[22];
        body_door_close[0] = new ModelRendererTurbo(this, 953, 233, textureX, textureY); // Box 6
        body_door_close[1] = new ModelRendererTurbo(this, 329, 249, textureX, textureY); // Box 7
        body_door_close[2] = new ModelRendererTurbo(this, 617, 257, textureX, textureY); // Box 9
        body_door_close[3] = new ModelRendererTurbo(this, 889, 161, textureX, textureY); // Box 10
        body_door_close[4] = new ModelRendererTurbo(this, 81, 169, textureX, textureY); // Box 11
        body_door_close[5] = new ModelRendererTurbo(this, 1009, 121, textureX, textureY); // Box 12
        body_door_close[6] = new ModelRendererTurbo(this, 137, 161, textureX, textureY); // Box 13
        body_door_close[7] = new ModelRendererTurbo(this, 377, 89, textureX, textureY); // Box 14
        body_door_close[8] = new ModelRendererTurbo(this, 1017, 89, textureX, textureY); // Box 15
        body_door_close[9] = new ModelRendererTurbo(this, 57, 97, textureX, textureY); // Box 16
        body_door_close[10] = new ModelRendererTurbo(this, 97, 97, textureX, textureY); // Box 17
        body_door_close[11] = new ModelRendererTurbo(this, 273, 97, textureX, textureY); // Box 18
        body_door_close[12] = new ModelRendererTurbo(this, 313, 97, textureX, textureY); // Box 19
        body_door_close[13] = new ModelRendererTurbo(this, 473, 97, textureX, textureY); // Box 20
        body_door_close[14] = new ModelRendererTurbo(this, 521, 97, textureX, textureY); // Box 21
        body_door_close[15] = new ModelRendererTurbo(this, 273, 105, textureX, textureY); // Box 22
        body_door_close[16] = new ModelRendererTurbo(this, 377, 105, textureX, textureY); // Box 23
        body_door_close[17] = new ModelRendererTurbo(this, 537, 105, textureX, textureY); // Box 24
        body_door_close[18] = new ModelRendererTurbo(this, 553, 105, textureX, textureY); // Box 25
        body_door_close[19] = new ModelRendererTurbo(this, 449, 161, textureX, textureY); // Box 661
        body_door_close[20] = new ModelRendererTurbo(this, 809, 161, textureX, textureY); // Box 662
        body_door_close[21] = new ModelRendererTurbo(this, 881, 169, textureX, textureY); // Box 663

        body_door_close[0].addBox(0F, 0F, 0F, 1, 48, 25, 0F); // Box 6
        body_door_close[0].setRotationPoint(-102.5F, -60F, -25F);

        body_door_close[1].addBox(0F, 0F, 0F, 1, 48, 25, 0F); // Box 7
        body_door_close[1].setRotationPoint(-102.5F, -60F, 0F);

        body_door_close[2].addShapeBox(0F, 0F, 0F, 2, 16, 46, 0F, -1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 9
        body_door_close[2].setRotationPoint(-104.5F, -26.5F, -23F);

        body_door_close[3].addBox(0F, 0F, 0F, 12, 2, 2, 0F); // Box 10
        body_door_close[3].setRotationPoint(-105F, -11.5F, -17F);

        body_door_close[4].addBox(0F, 0F, 0F, 12, 2, 2, 0F); // Box 11
        body_door_close[4].setRotationPoint(-105F, -11.5F, 15F);

        body_door_close[5].addShapeBox(0F, 0F, 0F, 1, 10, 2, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 12
        body_door_close[5].setRotationPoint(-105F, -21.5F, -17F);

        body_door_close[6].addShapeBox(0F, 0F, 0F, 1, 10, 2, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 13
        body_door_close[6].setRotationPoint(-105F, -21.5F, 15F);

        body_door_close[7].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 14
        body_door_close[7].setRotationPoint(-102.7F, -60F, -25F);
        body_door_close[7].rotateAngleX = 0.01745329F;

        body_door_close[8].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 15
        body_door_close[8].setRotationPoint(-102.7F, -60F, -5F);
        body_door_close[8].rotateAngleX = 0.01745329F;

        body_door_close[9].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 16
        body_door_close[9].setRotationPoint(-102.7F, -60F, 3F);
        body_door_close[9].rotateAngleX = 0.01745329F;

        body_door_close[10].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 17
        body_door_close[10].setRotationPoint(-102.7F, -60F, 23F);
        body_door_close[10].rotateAngleX = 0.01745329F;

        body_door_close[11].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 18
        body_door_close[11].setRotationPoint(-102.7F, -50F, -25F);
        body_door_close[11].rotateAngleX = 0.01745329F;

        body_door_close[12].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 19
        body_door_close[12].setRotationPoint(-102.7F, -40F, -25F);
        body_door_close[12].rotateAngleX = 0.01745329F;

        body_door_close[13].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 20
        body_door_close[13].setRotationPoint(-102.7F, -30F, -25F);
        body_door_close[13].rotateAngleX = 0.01745329F;

        body_door_close[14].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 21
        body_door_close[14].setRotationPoint(-102.7F, -20F, -25F);
        body_door_close[14].rotateAngleX = 0.01745329F;

        body_door_close[15].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 22
        body_door_close[15].setRotationPoint(-102.7F, -50F, 23F);
        body_door_close[15].rotateAngleX = 0.01745329F;

        body_door_close[16].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 23
        body_door_close[16].setRotationPoint(-102.7F, -40F, 23F);
        body_door_close[16].rotateAngleX = 0.01745329F;

        body_door_close[17].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 24
        body_door_close[17].setRotationPoint(-102.7F, -30F, 23F);
        body_door_close[17].rotateAngleX = 0.01745329F;

        body_door_close[18].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 25
        body_door_close[18].setRotationPoint(-102.7F, -20F, 23F);
        body_door_close[18].rotateAngleX = 0.01745329F;

        body_door_close[19].addShapeBox(0F, 0F, 0F, 1, 2, 8, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 661
        body_door_close[19].setRotationPoint(-102.7F, -29F, -4F);
        body_door_close[19].rotateAngleX = 0.01745329F;

        body_door_close[20].addShapeBox(0F, 0F, 0F, 1, 2, 8, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 662
        body_door_close[20].setRotationPoint(-102.7F, -58F, -4F);
        body_door_close[20].rotateAngleX = 0.01745329F;

        body_door_close[21].addShapeBox(0F, 0F, 0F, 1, 2, 8, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 663
        body_door_close[21].setRotationPoint(-102.7F, -43F, -4F);
        body_door_close[21].rotateAngleX = 0.01745329F;

        body_colored_secondary = new ModelRendererTurbo[4];
        body_colored_secondary[0] = new ModelRendererTurbo(this, 465, 201, textureX, textureY); // Box 0
        body_colored_secondary[1] = new ModelRendererTurbo(this, 721, 201, textureX, textureY); // Box 1
        body_colored_secondary[2] = new ModelRendererTurbo(this, 1, 217, textureX, textureY); // Box 2
        body_colored_secondary[3] = new ModelRendererTurbo(this, 409, 209, textureX, textureY); // Box 3

        body_colored_secondary[0].addBox(0F, 0F, 0F, 124, 48, 1, 0F); // Box 0
        body_colored_secondary[0].setRotationPoint(-102F, -60F, -25.5F);

        body_colored_secondary[1].addBox(0F, 0F, 0F, 124, 48, 1, 0F); // Box 1
        body_colored_secondary[1].setRotationPoint(-102F, -60F, 24.5F);

        body_colored_secondary[2].addBox(0F, 0F, 0F, 124, 1, 52, 0F); // Box 2
        body_colored_secondary[2].setRotationPoint(-102F, -61F, -26F);

        body_colored_secondary[3].addBox(0F, 0F, 0F, 1, 48, 49, 0F); // Box 3
        body_colored_secondary[3].setRotationPoint(21F, -60F, -24.5F);

        //translateAll(0F, 0F, 0F);
    }

}
