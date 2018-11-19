package net.fexcraft.mod.addons.fvp.models.part;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.model.part.PartModel;

public class ModelC5W extends PartModel {

    public ModelC5W(){
    	super(); textureX = 512; textureY = 512;
        this.addToCreators("Ferdinand (FEX___96)");
        ModelRendererTurbo[] wheel_front_left = new ModelRendererTurbo[42];
        wheel_front_left[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
        wheel_front_left[1] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 10
        wheel_front_left[2] = new ModelRendererTurbo(this, 329, 1, textureX, textureY); // Box 12
        wheel_front_left[3] = new ModelRendererTurbo(this, 353, 1, textureX, textureY); // Box 13
        wheel_front_left[4] = new ModelRendererTurbo(this, 369, 1, textureX, textureY); // Box 14
        wheel_front_left[5] = new ModelRendererTurbo(this, 393, 1, textureX, textureY); // Box 15
        wheel_front_left[6] = new ModelRendererTurbo(this, 417, 1, textureX, textureY); // Box 156
        wheel_front_left[7] = new ModelRendererTurbo(this, 433, 1, textureX, textureY); // Box 16
        wheel_front_left[8] = new ModelRendererTurbo(this, 449, 1, textureX, textureY); // Box 17
        wheel_front_left[9] = new ModelRendererTurbo(this, 465, 1, textureX, textureY); // Box 18
        wheel_front_left[10] = new ModelRendererTurbo(this, 489, 1, textureX, textureY); // Box 183
        wheel_front_left[11] = new ModelRendererTurbo(this, 1, 9, textureX, textureY); // Box 19
        wheel_front_left[12] = new ModelRendererTurbo(this, 89, 9, textureX, textureY); // Box 20
        wheel_front_left[13] = new ModelRendererTurbo(this, 129, 9, textureX, textureY); // Box 21
        wheel_front_left[14] = new ModelRendererTurbo(this, 145, 9, textureX, textureY); // Box 22
        wheel_front_left[15] = new ModelRendererTurbo(this, 177, 9, textureX, textureY); // Box 23
        wheel_front_left[16] = new ModelRendererTurbo(this, 193, 9, textureX, textureY); // Box 24
        wheel_front_left[17] = new ModelRendererTurbo(this, 209, 9, textureX, textureY); // Box 25
        wheel_front_left[18] = new ModelRendererTurbo(this, 233, 9, textureX, textureY); // Box 26
        wheel_front_left[19] = new ModelRendererTurbo(this, 289, 9, textureX, textureY); // Box 27
        wheel_front_left[20] = new ModelRendererTurbo(this, 313, 9, textureX, textureY); // Box 28
        wheel_front_left[21] = new ModelRendererTurbo(this, 321, 9, textureX, textureY); // Box 29
        wheel_front_left[22] = new ModelRendererTurbo(this, 337, 9, textureX, textureY); // Box 30
        wheel_front_left[23] = new ModelRendererTurbo(this, 361, 9, textureX, textureY); // Box 31
        wheel_front_left[24] = new ModelRendererTurbo(this, 377, 9, textureX, textureY); // Box 32
        wheel_front_left[25] = new ModelRendererTurbo(this, 393, 9, textureX, textureY); // Box 33
        wheel_front_left[26] = new ModelRendererTurbo(this, 409, 9, textureX, textureY); // Box 34
        wheel_front_left[27] = new ModelRendererTurbo(this, 433, 9, textureX, textureY); // Box 35
        wheel_front_left[28] = new ModelRendererTurbo(this, 465, 9, textureX, textureY); // Box 36
        wheel_front_left[29] = new ModelRendererTurbo(this, 489, 9, textureX, textureY); // Box 37
        wheel_front_left[30] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 38
        wheel_front_left[31] = new ModelRendererTurbo(this, 17, 17, textureX, textureY); // Box 39
        wheel_front_left[32] = new ModelRendererTurbo(this, 81, 17, textureX, textureY); // Box 40
        wheel_front_left[33] = new ModelRendererTurbo(this, 145, 17, textureX, textureY); // Box 41
        wheel_front_left[34] = new ModelRendererTurbo(this, 417, 17, textureX, textureY); // Box 9
        wheel_front_left[35] = new ModelRendererTurbo(this, 473, 97, textureX, textureY); // Box 356
        wheel_front_left[36] = new ModelRendererTurbo(this, 497, 105, textureX, textureY); // Box 357
        wheel_front_left[37] = new ModelRendererTurbo(this, 505, 105, textureX, textureY); // Box 358
        wheel_front_left[38] = new ModelRendererTurbo(this, 393, 113, textureX, textureY); // Box 359
        wheel_front_left[39] = new ModelRendererTurbo(this, 505, 113, textureX, textureY); // Box 360
        wheel_front_left[40] = new ModelRendererTurbo(this, 353, 121, textureX, textureY); // Box 361
        wheel_front_left[41] = new ModelRendererTurbo(this, 361, 121, textureX, textureY); // Box 362

        wheel_front_left[0].addBox(-1F, -1F, 0F, 2, 2, 5, 0F); // Box 0
        wheel_front_left[0].setRotationPoint(46F, 2F, 18.5F);

        wheel_front_left[1].addShapeBox(5F, 2F, 0F, 1, 3, 5, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 10
        wheel_front_left[1].setRotationPoint(46F, 2F, 19F);

        wheel_front_left[2].addShapeBox(2F, -6F, 0F, 3, 1, 5, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 12
        wheel_front_left[2].setRotationPoint(46F, 2F, 19F);

        wheel_front_left[3].addShapeBox(5F, -6F, 0F, 1, 1, 5, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 13
        wheel_front_left[3].setRotationPoint(46F, 2F, 19F);

        wheel_front_left[4].addShapeBox(-5F, -8F, 0F, 3, 1, 5, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F); // Box 14
        wheel_front_left[4].setRotationPoint(46F, 2F, 19F);

        wheel_front_left[5].addShapeBox(-5F, 7F, 0F, 3, 1, 5, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 15
        wheel_front_left[5].setRotationPoint(46F, 2F, 19F);

        wheel_front_left[6].addBox(-8F, -2F, 0F, 1, 4, 5, 0F); // Box 156
        wheel_front_left[6].setRotationPoint(46F, 2F, 19F);

        wheel_front_left[7].addShapeBox(-6F, -6F, 0F, 1, 1, 5, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 16
        wheel_front_left[7].setRotationPoint(46F, 2F, 19F);

        wheel_front_left[8].addShapeBox(7F, -5F, 0F, 1, 3, 5, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 17
        wheel_front_left[8].setRotationPoint(46F, 2F, 19F);

        wheel_front_left[9].addShapeBox(2F, 5F, 0F, 3, 1, 5, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F); // Box 18
        wheel_front_left[9].setRotationPoint(46F, 2F, 19F);

        wheel_front_left[10].addBox(-2F, -8F, 0F, 4, 1, 5, 0F); // Box 183
        wheel_front_left[10].setRotationPoint(46F, 2F, 19F);

        wheel_front_left[11].addShapeBox(5F, 5F, 0F, 1, 1, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F); // Box 19
        wheel_front_left[11].setRotationPoint(46F, 2F, 19F);

        wheel_front_left[12].addShapeBox(-6F, -5F, 0F, 1, 3, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F); // Box 20
        wheel_front_left[12].setRotationPoint(46F, 2F, 19F);

        wheel_front_left[13].addShapeBox(-8F, 2F, 0F, 1, 3, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F); // Box 21
        wheel_front_left[13].setRotationPoint(46F, 2F, 19F);

        wheel_front_left[14].addShapeBox(-6F, 5F, 0F, 1, 1, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 22
        wheel_front_left[14].setRotationPoint(46F, 2F, 19F);

        wheel_front_left[15].addBox(7F, -2F, 0F, 1, 4, 5, 0F); // Box 23
        wheel_front_left[15].setRotationPoint(46F, 2F, 19F);

        wheel_front_left[16].addBox(-1F, -7F, 2F, 2, 6, 2, 0F); // Box 24
        wheel_front_left[16].setRotationPoint(46F, 2F, 19F);

        wheel_front_left[17].addBox(-7F, -1F, 2F, 6, 2, 2, 0F); // Box 25
        wheel_front_left[17].setRotationPoint(46F, 2F, 19F);

        wheel_front_left[18].addBox(-1F, 1F, 2F, 2, 6, 2, 0F); // Box 26
        wheel_front_left[18].setRotationPoint(46F, 2F, 19F);

        wheel_front_left[19].addBox(1F, -1F, 2F, 6, 2, 2, 0F); // Box 27
        wheel_front_left[19].setRotationPoint(46F, 2F, 19F);

        wheel_front_left[20].addShapeBox(-1F, -5F, 2F, 1, 5, 2, 0F, 5F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 28
        wheel_front_left[20].setRotationPoint(46F, 2F, 19F);

        wheel_front_left[21].addBox(-1.5F, -1.5F, 0F, 3, 3, 3, 0F); // Box 29
        wheel_front_left[21].setRotationPoint(46F, 2F, 20F);

        wheel_front_left[22].addBox(-2F, 6F, 0F, 4, 1, 4, 0F); // Box 30
        wheel_front_left[22].setRotationPoint(46F, 2F, 19F);

        wheel_front_left[23].addShapeBox(2F, 4F, 0F, 3, 1, 4, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F); // Box 31
        wheel_front_left[23].setRotationPoint(46F, 2F, 19F);

        wheel_front_left[24].addShapeBox(4F, 2F, 0F, 1, 3, 4, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 32
        wheel_front_left[24].setRotationPoint(46F, 2F, 19F);

        wheel_front_left[25].addBox(6F, -2F, 0F, 1, 4, 4, 0F); // Box 33
        wheel_front_left[25].setRotationPoint(46F, 2F, 19F);

        wheel_front_left[26].addShapeBox(6F, -5F, 0F, 1, 3, 4, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 34
        wheel_front_left[26].setRotationPoint(46F, 2F, 19F);

        wheel_front_left[27].addShapeBox(2F, -5F, 0F, 3, 1, 4, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 35
        wheel_front_left[27].setRotationPoint(46F, 2F, 19F);

        wheel_front_left[28].addBox(-2F, -7F, 0F, 4, 1, 4, 0F); // Box 36
        wheel_front_left[28].setRotationPoint(46F, 2F, 19F);

        wheel_front_left[29].addShapeBox(-5F, -7F, 0F, 3, 1, 4, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F); // Box 37
        wheel_front_left[29].setRotationPoint(46F, 2F, 19F);

        wheel_front_left[30].addShapeBox(-7F, -5F, 0F, 1, 3, 4, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 38
        wheel_front_left[30].setRotationPoint(46F, 2F, 19F);

        wheel_front_left[31].addBox(-7F, -2F, 0F, 1, 4, 4, 0F); // Box 39
        wheel_front_left[31].setRotationPoint(46F, 2F, 19F);

        wheel_front_left[32].addShapeBox(-7F, 2F, 0F, 1, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F); // Box 40
        wheel_front_left[32].setRotationPoint(46F, 2F, 19F);

        wheel_front_left[33].addShapeBox(-5F, 6F, 0F, 3, 1, 4, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 41
        wheel_front_left[33].setRotationPoint(46F, 2F, 19F);

        wheel_front_left[34].addBox(-2F, 7F, 0F, 4, 1, 5, 0F); // Box 9
        wheel_front_left[34].setRotationPoint(46F, 2F, 19F);

        wheel_front_left[35].addShapeBox(0F, -5F, 2F, 1, 5, 2, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 356
        wheel_front_left[35].setRotationPoint(46F, 2F, 19F);

        wheel_front_left[36].addShapeBox(-5F, -5F, 2F, 1, 5, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F); // Box 357
        wheel_front_left[36].setRotationPoint(46F, 2F, 19F);

        wheel_front_left[37].addShapeBox(-1F, -5F, 2F, 1, 5, 2, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 358
        wheel_front_left[37].setRotationPoint(46F, 2F, 19F);

        wheel_front_left[38].addShapeBox(-1F, 0F, 2F, 1, 5, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F); // Box 359
        wheel_front_left[38].setRotationPoint(46F, 2F, 19F);

        wheel_front_left[39].addShapeBox(0F, 0F, 2F, 1, 5, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F); // Box 360
        wheel_front_left[39].setRotationPoint(46F, 2F, 19F);

        wheel_front_left[40].addShapeBox(0F, 0F, 2F, 1, 5, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F); // Box 361
        wheel_front_left[40].setRotationPoint(46F, 2F, 19F);

        wheel_front_left[41].addShapeBox(-1F, 0F, 2F, 1, 5, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F); // Box 362
        wheel_front_left[41].setRotationPoint(46F, 2F, 19F);
        this.add("wheel_front_left", wheel_front_left);

        ModelRendererTurbo[] wheel_front_right = new ModelRendererTurbo[42];
        wheel_front_right[0] = new ModelRendererTurbo(this, 81, 1, textureX, textureY); // Box 100
        wheel_front_right[1] = new ModelRendererTurbo(this, 97, 1, textureX, textureY); // Box 101
        wheel_front_right[2] = new ModelRendererTurbo(this, 121, 1, textureX, textureY); // Box 102
        wheel_front_right[3] = new ModelRendererTurbo(this, 137, 1, textureX, textureY); // Box 103
        wheel_front_right[4] = new ModelRendererTurbo(this, 153, 1, textureX, textureY); // Box 104
        wheel_front_right[5] = new ModelRendererTurbo(this, 177, 1, textureX, textureY); // Box 105
        wheel_front_right[6] = new ModelRendererTurbo(this, 201, 1, textureX, textureY); // Box 106
        wheel_front_right[7] = new ModelRendererTurbo(this, 225, 1, textureX, textureY); // Box 107
        wheel_front_right[8] = new ModelRendererTurbo(this, 241, 1, textureX, textureY); // Box 108
        wheel_front_right[9] = new ModelRendererTurbo(this, 257, 1, textureX, textureY); // Box 109
        wheel_front_right[10] = new ModelRendererTurbo(this, 273, 1, textureX, textureY); // Box 110
        wheel_front_right[11] = new ModelRendererTurbo(this, 289, 1, textureX, textureY); // Box 111
        wheel_front_right[12] = new ModelRendererTurbo(this, 305, 1, textureX, textureY); // Box 113
        wheel_front_right[13] = new ModelRendererTurbo(this, 201, 17, textureX, textureY); // Box 77
        wheel_front_right[14] = new ModelRendererTurbo(this, 217, 17, textureX, textureY); // Box 78
        wheel_front_right[15] = new ModelRendererTurbo(this, 121, 17, textureX, textureY); // Box 79
        wheel_front_right[16] = new ModelRendererTurbo(this, 241, 17, textureX, textureY); // Box 80
        wheel_front_right[17] = new ModelRendererTurbo(this, 265, 17, textureX, textureY); // Box 81
        wheel_front_right[18] = new ModelRendererTurbo(this, 281, 17, textureX, textureY); // Box 82
        wheel_front_right[19] = new ModelRendererTurbo(this, 505, 9, textureX, textureY); // Box 83
        wheel_front_right[20] = new ModelRendererTurbo(this, 305, 17, textureX, textureY); // Box 84
        wheel_front_right[21] = new ModelRendererTurbo(this, 329, 17, textureX, textureY); // Box 85
        wheel_front_right[22] = new ModelRendererTurbo(this, 345, 17, textureX, textureY); // Box 86
        wheel_front_right[23] = new ModelRendererTurbo(this, 361, 17, textureX, textureY); // Box 87
        wheel_front_right[24] = new ModelRendererTurbo(this, 377, 17, textureX, textureY); // Box 88
        wheel_front_right[25] = new ModelRendererTurbo(this, 401, 17, textureX, textureY); // Box 89
        wheel_front_right[26] = new ModelRendererTurbo(this, 441, 17, textureX, textureY); // Box 90
        wheel_front_right[27] = new ModelRendererTurbo(this, 465, 17, textureX, textureY); // Box 91
        wheel_front_right[28] = new ModelRendererTurbo(this, 481, 17, textureX, textureY); // Box 93
        wheel_front_right[29] = new ModelRendererTurbo(this, 497, 17, textureX, textureY); // Box 94
        wheel_front_right[30] = new ModelRendererTurbo(this, 129, 25, textureX, textureY); // Box 95
        wheel_front_right[31] = new ModelRendererTurbo(this, 1, 25, textureX, textureY); // Box 96
        wheel_front_right[32] = new ModelRendererTurbo(this, 145, 25, textureX, textureY); // Box 97
        wheel_front_right[33] = new ModelRendererTurbo(this, 177, 25, textureX, textureY); // Box 98
        wheel_front_right[34] = new ModelRendererTurbo(this, 249, 9, textureX, textureY); // Box 99
        wheel_front_right[35] = new ModelRendererTurbo(this, 369, 121, textureX, textureY); // Box 363
        wheel_front_right[36] = new ModelRendererTurbo(this, 393, 121, textureX, textureY); // Box 364
        wheel_front_right[37] = new ModelRendererTurbo(this, 417, 121, textureX, textureY); // Box 365
        wheel_front_right[38] = new ModelRendererTurbo(this, 425, 121, textureX, textureY); // Box 366
        wheel_front_right[39] = new ModelRendererTurbo(this, 433, 121, textureX, textureY); // Box 367
        wheel_front_right[40] = new ModelRendererTurbo(this, 441, 121, textureX, textureY); // Box 368
        wheel_front_right[41] = new ModelRendererTurbo(this, 449, 121, textureX, textureY); // Box 369

        wheel_front_right[0].addShapeBox(5F, 2F, -5F, 1, 3, 5, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 100
        wheel_front_right[0].setRotationPoint(46F, 2F, -19F);

        wheel_front_right[1].addBox(7F, -2F, -5F, 1, 4, 5, 0F); // Box 101
        wheel_front_right[1].setRotationPoint(46F, 2F, -19F);

        wheel_front_right[2].addShapeBox(7F, -5F, -5F, 1, 3, 5, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 102
        wheel_front_right[2].setRotationPoint(46F, 2F, -19F);

        wheel_front_right[3].addShapeBox(5F, -6F, -5F, 1, 1, 5, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 103
        wheel_front_right[3].setRotationPoint(46F, 2F, -19F);

        wheel_front_right[4].addShapeBox(2F, -6F, -5F, 3, 1, 5, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 104
        wheel_front_right[4].setRotationPoint(46F, 2F, -19F);

        wheel_front_right[5].addBox(-2F, -8F, -5F, 4, 1, 5, 0F); // Box 105
        wheel_front_right[5].setRotationPoint(46F, 2F, -19F);

        wheel_front_right[6].addShapeBox(-5F, -8F, -5F, 3, 1, 5, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F); // Box 106
        wheel_front_right[6].setRotationPoint(46F, 2F, -19F);

        wheel_front_right[7].addShapeBox(-6F, -6F, -5F, 1, 1, 5, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 107
        wheel_front_right[7].setRotationPoint(46F, 2F, -19F);

        wheel_front_right[8].addShapeBox(-8F, -5F, -5F, 1, 3, 5, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 108
        wheel_front_right[8].setRotationPoint(46F, 2F, -19F);

        wheel_front_right[9].addBox(-8F, -2F, -5F, 1, 4, 5, 0F); // Box 109
        wheel_front_right[9].setRotationPoint(46F, 2F, -19F);

        wheel_front_right[10].addShapeBox(-8F, 2F, -5F, 1, 3, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F); // Box 110
        wheel_front_right[10].setRotationPoint(46F, 2F, -19F);

        wheel_front_right[11].addShapeBox(-6F, 5F, -5F, 1, 1, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 111
        wheel_front_right[11].setRotationPoint(46F, 2F, -19F);

        wheel_front_right[12].addShapeBox(-5F, 7F, -5F, 3, 1, 5, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 113
        wheel_front_right[12].setRotationPoint(46F, 2F, -19F);

        wheel_front_right[13].addBox(-1F, -1F, -5F, 2, 2, 5, 0F); // Box 77
        wheel_front_right[13].setRotationPoint(46F, 2F, -18.5F);

        wheel_front_right[14].addBox(-1.5F, -1.5F, -3F, 3, 3, 3, 0F); // Box 78
        wheel_front_right[14].setRotationPoint(46F, 2F, -20F);

        wheel_front_right[15].addBox(-1F, -7F, -4F, 2, 6, 2, 0F); // Box 79
        wheel_front_right[15].setRotationPoint(46F, 2F, -19F);

        wheel_front_right[16].addBox(-7F, -1F, -4F, 6, 2, 2, 0F); // Box 80
        wheel_front_right[16].setRotationPoint(46F, 2F, -19F);

        wheel_front_right[17].addBox(-1F, 1F, -4F, 2, 6, 2, 0F); // Box 81
        wheel_front_right[17].setRotationPoint(46F, 2F, -19F);

        wheel_front_right[18].addBox(1F, -1F, -4F, 6, 2, 2, 0F); // Box 82
        wheel_front_right[18].setRotationPoint(46F, 2F, -19F);

        wheel_front_right[19].addShapeBox(-1F, -5F, -4F, 1, 5, 2, 0F, 5F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 83
        wheel_front_right[19].setRotationPoint(46F, 2F, -19F);

        wheel_front_right[20].addBox(-2F, 6F, -4F, 4, 1, 4, 0F); // Box 84
        wheel_front_right[20].setRotationPoint(46F, 2F, -19F);

        wheel_front_right[21].addShapeBox(2F, 6F, -4F, 3, 1, 4, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F); // Box 85
        wheel_front_right[21].setRotationPoint(46F, 2F, -19F);

        wheel_front_right[22].addShapeBox(4F, 2F, -4F, 1, 3, 4, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 86
        wheel_front_right[22].setRotationPoint(46F, 2F, -19F);

        wheel_front_right[23].addBox(6F, -2F, -4F, 1, 4, 4, 0F); // Box 87
        wheel_front_right[23].setRotationPoint(46F, 2F, -19F);

        wheel_front_right[24].addShapeBox(6F, -5F, -4F, 1, 3, 4, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 88
        wheel_front_right[24].setRotationPoint(46F, 2F, -19F);

        wheel_front_right[25].addShapeBox(2F, -5F, -4F, 3, 1, 4, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 89
        wheel_front_right[25].setRotationPoint(46F, 2F, -19F);

        wheel_front_right[26].addBox(-2F, -7F, -4F, 4, 1, 4, 0F); // Box 90
        wheel_front_right[26].setRotationPoint(46F, 2F, -19F);

        wheel_front_right[27].addShapeBox(-5F, -7F, -4F, 3, 1, 4, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F); // Box 91
        wheel_front_right[27].setRotationPoint(46F, 2F, -19F);

        wheel_front_right[28].addShapeBox(-7F, -5F, -4F, 1, 3, 4, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 93
        wheel_front_right[28].setRotationPoint(46F, 2F, -19F);

        wheel_front_right[29].addBox(-7F, -2F, -4F, 1, 4, 4, 0F); // Box 94
        wheel_front_right[29].setRotationPoint(46F, 2F, -19F);

        wheel_front_right[30].addShapeBox(-7F, 2F, -4F, 1, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F); // Box 95
        wheel_front_right[30].setRotationPoint(46F, 2F, -19F);

        wheel_front_right[31].addShapeBox(-5F, 6F, -4F, 3, 1, 4, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 96
        wheel_front_right[31].setRotationPoint(46F, 2F, -19F);

        wheel_front_right[32].addBox(-2F, 7F, -5F, 4, 1, 5, 0F); // Box 97
        wheel_front_right[32].setRotationPoint(46F, 2F, -19F);

        wheel_front_right[33].addShapeBox(2F, 5F, -5F, 3, 1, 5, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F); // Box 98
        wheel_front_right[33].setRotationPoint(46F, 2F, -19F);

        wheel_front_right[34].addShapeBox(5F, 5F, -5F, 1, 1, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F); // Box 99
        wheel_front_right[34].setRotationPoint(46F, 2F, -19F);

        wheel_front_right[35].addShapeBox(0F, -5F, -4F, 1, 5, 2, 0F, 5F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 363
        wheel_front_right[35].setRotationPoint(46F, 2F, -19F);

        wheel_front_right[36].addShapeBox(5F, 0F, -4F, 1, 5, 2, 0F, 5F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 364
        wheel_front_right[36].setRotationPoint(46F, 2F, -19F);

        wheel_front_right[37].addShapeBox(4F, 0F, -4F, 1, 5, 2, 0F, 5F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 365
        wheel_front_right[37].setRotationPoint(46F, 2F, -19F);

        wheel_front_right[38].addShapeBox(-1F, -5F, -4F, 1, 5, 2, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 366
        wheel_front_right[38].setRotationPoint(46F, 2F, -19F);

        wheel_front_right[39].addShapeBox(0F, -5F, -4F, 1, 5, 2, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 367
        wheel_front_right[39].setRotationPoint(46F, 2F, -19F);

        wheel_front_right[40].addShapeBox(-6F, 0F, -4F, 1, 5, 2, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 368
        wheel_front_right[40].setRotationPoint(46F, 2F, -19F);

        wheel_front_right[41].addShapeBox(-5F, 0F, -4F, 1, 5, 2, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 369
        wheel_front_right[41].setRotationPoint(46F, 2F, -19F);
        this.add("wheel_front_right", wheel_front_right);

        ModelRendererTurbo[] wheel_back_left = new ModelRendererTurbo[42];
        wheel_back_left[0] = new ModelRendererTurbo(this, 97, 17, textureX, textureY); // Box 156
        wheel_back_left[1] = new ModelRendererTurbo(this, 481, 25, textureX, textureY); // Box 183
        wheel_back_left[2] = new ModelRendererTurbo(this, 297, 33, textureX, textureY); // Box 0
        wheel_back_left[3] = new ModelRendererTurbo(this, 337, 33, textureX, textureY); // Box 9
        wheel_back_left[4] = new ModelRendererTurbo(this, 353, 25, textureX, textureY); // Box 10
        wheel_back_left[5] = new ModelRendererTurbo(this, 401, 33, textureX, textureY); // Box 12
        wheel_back_left[6] = new ModelRendererTurbo(this, 265, 9, textureX, textureY); // Box 13
        wheel_back_left[7] = new ModelRendererTurbo(this, 441, 33, textureX, textureY); // Box 14
        wheel_back_left[8] = new ModelRendererTurbo(this, 313, 33, textureX, textureY); // Box 15
        wheel_back_left[9] = new ModelRendererTurbo(this, 281, 9, textureX, textureY); // Box 16
        wheel_back_left[10] = new ModelRendererTurbo(this, 481, 33, textureX, textureY); // Box 17
        wheel_back_left[11] = new ModelRendererTurbo(this, 177, 41, textureX, textureY); // Box 18
        wheel_back_left[12] = new ModelRendererTurbo(this, 185, 17, textureX, textureY); // Box 19
        wheel_back_left[13] = new ModelRendererTurbo(this, 201, 41, textureX, textureY); // Box 20
        wheel_back_left[14] = new ModelRendererTurbo(this, 497, 33, textureX, textureY); // Box 21
        wheel_back_left[15] = new ModelRendererTurbo(this, 233, 41, textureX, textureY); // Box 22
        wheel_back_left[16] = new ModelRendererTurbo(this, 249, 41, textureX, textureY); // Box 23
        wheel_back_left[17] = new ModelRendererTurbo(this, 465, 25, textureX, textureY); // Box 24
        wheel_back_left[18] = new ModelRendererTurbo(this, 81, 25, textureX, textureY); // Box 25
        wheel_back_left[19] = new ModelRendererTurbo(this, 265, 41, textureX, textureY); // Box 26
        wheel_back_left[20] = new ModelRendererTurbo(this, 57, 41, textureX, textureY); // Box 27
        wheel_back_left[21] = new ModelRendererTurbo(this, 281, 41, textureX, textureY); // Box 28
        wheel_back_left[22] = new ModelRendererTurbo(this, 289, 41, textureX, textureY); // Box 29
        wheel_back_left[23] = new ModelRendererTurbo(this, 81, 41, textureX, textureY); // Box 30
        wheel_back_left[24] = new ModelRendererTurbo(this, 121, 41, textureX, textureY); // Box 31
        wheel_back_left[25] = new ModelRendererTurbo(this, 305, 41, textureX, textureY); // Box 32
        wheel_back_left[26] = new ModelRendererTurbo(this, 337, 41, textureX, textureY); // Box 33
        wheel_back_left[27] = new ModelRendererTurbo(this, 353, 41, textureX, textureY); // Box 34
        wheel_back_left[28] = new ModelRendererTurbo(this, 137, 41, textureX, textureY); // Box 35
        wheel_back_left[29] = new ModelRendererTurbo(this, 401, 41, textureX, textureY); // Box 36
        wheel_back_left[30] = new ModelRendererTurbo(this, 441, 41, textureX, textureY); // Box 37
        wheel_back_left[31] = new ModelRendererTurbo(this, 457, 41, textureX, textureY); // Box 38
        wheel_back_left[32] = new ModelRendererTurbo(this, 1, 49, textureX, textureY); // Box 39
        wheel_back_left[33] = new ModelRendererTurbo(this, 17, 49, textureX, textureY); // Box 40
        wheel_back_left[34] = new ModelRendererTurbo(this, 177, 49, textureX, textureY); // Box 41
        wheel_back_left[35] = new ModelRendererTurbo(this, 497, 121, textureX, textureY); // Box 370
        wheel_back_left[36] = new ModelRendererTurbo(this, 505, 121, textureX, textureY); // Box 371
        wheel_back_left[37] = new ModelRendererTurbo(this, 1, 129, textureX, textureY); // Box 372
        wheel_back_left[38] = new ModelRendererTurbo(this, 9, 129, textureX, textureY); // Box 373
        wheel_back_left[39] = new ModelRendererTurbo(this, 17, 129, textureX, textureY); // Box 374
        wheel_back_left[40] = new ModelRendererTurbo(this, 25, 129, textureX, textureY); // Box 375
        wheel_back_left[41] = new ModelRendererTurbo(this, 33, 129, textureX, textureY); // Box 376

        wheel_back_left[0].addBox(-8F, -2F, 0F, 1, 4, 5, 0F); // Box 156
        wheel_back_left[0].setRotationPoint(-26F, 2F, 19F);

        wheel_back_left[1].addBox(-2F, -8F, 0F, 4, 1, 5, 0F); // Box 183
        wheel_back_left[1].setRotationPoint(-26F, 2F, 19F);

        wheel_back_left[2].addBox(-1F, -1F, 0F, 2, 2, 5, 0F); // Box 0
        wheel_back_left[2].setRotationPoint(-26F, 2F, 18.5F);

        wheel_back_left[3].addBox(-2F, 7F, 0F, 4, 1, 5, 0F); // Box 9
        wheel_back_left[3].setRotationPoint(-26F, 2F, 19F);

        wheel_back_left[4].addShapeBox(5F, 2F, 0F, 1, 3, 5, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 10
        wheel_back_left[4].setRotationPoint(-26F, 2F, 19F);

        wheel_back_left[5].addShapeBox(2F, -6F, 0F, 3, 1, 5, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 12
        wheel_back_left[5].setRotationPoint(-26F, 2F, 19F);

        wheel_back_left[6].addShapeBox(5F, -6F, 0F, 1, 1, 5, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 13
        wheel_back_left[6].setRotationPoint(-26F, 2F, 19F);

        wheel_back_left[7].addShapeBox(-5F, -8F, 0F, 3, 1, 5, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F); // Box 14
        wheel_back_left[7].setRotationPoint(-26F, 2F, 19F);

        wheel_back_left[8].addShapeBox(-8F, -5F, 0F, 1, 3, 5, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 15
        wheel_back_left[8].setRotationPoint(-26F, 2F, 19F);

        wheel_back_left[9].addShapeBox(-6F, -6F, 0F, 1, 1, 5, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 16
        wheel_back_left[9].setRotationPoint(-26F, 2F, 19F);

        wheel_back_left[10].addShapeBox(7F, -5F, 0F, 1, 3, 5, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 17
        wheel_back_left[10].setRotationPoint(-26F, 2F, 19F);

        wheel_back_left[11].addShapeBox(2F, 5F, 0F, 3, 1, 5, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F); // Box 18
        wheel_back_left[11].setRotationPoint(-26F, 2F, 19F);

        wheel_back_left[12].addShapeBox(5F, 5F, 0F, 1, 1, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F); // Box 19
        wheel_back_left[12].setRotationPoint(-26F, 2F, 19F);

        wheel_back_left[13].addShapeBox(-5F, 7F, 0F, 3, 1, 5, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 20
        wheel_back_left[13].setRotationPoint(-26F, 2F, 19F);

        wheel_back_left[14].addShapeBox(-8F, 2F, 0F, 1, 3, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F); // Box 21
        wheel_back_left[14].setRotationPoint(-26F, 2F, 19F);

        wheel_back_left[15].addShapeBox(-6F, 5F, 0F, 1, 1, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 22
        wheel_back_left[15].setRotationPoint(-26F, 2F, 19F);

        wheel_back_left[16].addBox(7F, -2F, 0F, 1, 4, 5, 0F); // Box 23
        wheel_back_left[16].setRotationPoint(-26F, 2F, 19F);

        wheel_back_left[17].addBox(-1F, -7F, 2F, 2, 6, 2, 0F); // Box 24
        wheel_back_left[17].setRotationPoint(-26F, 2F, 19F);

        wheel_back_left[18].addBox(-7F, -1F, 2F, 6, 2, 2, 0F); // Box 25
        wheel_back_left[18].setRotationPoint(-26F, 2F, 19F);

        wheel_back_left[19].addBox(-1F, 1F, 2F, 2, 6, 2, 0F); // Box 26
        wheel_back_left[19].setRotationPoint(-26F, 2F, 19F);

        wheel_back_left[20].addBox(1F, -1F, 2F, 6, 2, 2, 0F); // Box 27
        wheel_back_left[20].setRotationPoint(-26F, 2F, 19F);

        wheel_back_left[21].addShapeBox(-1F, -5F, 2F, 1, 5, 2, 0F, 5F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 28
        wheel_back_left[21].setRotationPoint(-26F, 2F, 19F);

        wheel_back_left[22].addBox(-1.5F, -1.5F, 0F, 3, 3, 3, 0F); // Box 29
        wheel_back_left[22].setRotationPoint(-26F, 2F, 20F);

        wheel_back_left[23].addBox(-2F, 6F, 0F, 4, 1, 4, 0F); // Box 30
        wheel_back_left[23].setRotationPoint(-26F, 2F, 19F);

        wheel_back_left[24].addShapeBox(2F, 4F, 0F, 3, 1, 4, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F); // Box 31
        wheel_back_left[24].setRotationPoint(-26F, 2F, 19F);

        wheel_back_left[25].addShapeBox(4F, 2F, 0F, 1, 3, 4, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 32
        wheel_back_left[25].setRotationPoint(-26F, 2F, 19F);

        wheel_back_left[26].addBox(6F, -2F, 0F, 1, 4, 4, 0F); // Box 33
        wheel_back_left[26].setRotationPoint(-26F, 2F, 19F);

        wheel_back_left[27].addShapeBox(6F, -5F, 0F, 1, 3, 4, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 34
        wheel_back_left[27].setRotationPoint(-26F, 2F, 19F);

        wheel_back_left[28].addShapeBox(2F, -5F, 0F, 3, 1, 4, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 35
        wheel_back_left[28].setRotationPoint(-26F, 2F, 19F);

        wheel_back_left[29].addBox(-2F, -7F, 0F, 4, 1, 4, 0F); // Box 36
        wheel_back_left[29].setRotationPoint(-26F, 2F, 19F);

        wheel_back_left[30].addShapeBox(-5F, -7F, 0F, 3, 1, 4, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F); // Box 37
        wheel_back_left[30].setRotationPoint(-26F, 2F, 19F);

        wheel_back_left[31].addShapeBox(-7F, -5F, 0F, 1, 3, 4, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 38
        wheel_back_left[31].setRotationPoint(-26F, 2F, 19F);

        wheel_back_left[32].addBox(-7F, -2F, 0F, 1, 4, 4, 0F); // Box 39
        wheel_back_left[32].setRotationPoint(-26F, 2F, 19F);

        wheel_back_left[33].addShapeBox(-7F, 2F, 0F, 1, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F); // Box 40
        wheel_back_left[33].setRotationPoint(-26F, 2F, 19F);

        wheel_back_left[34].addShapeBox(-5F, 6F, 0F, 3, 1, 4, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 41
        wheel_back_left[34].setRotationPoint(-26F, 2F, 19F);

        wheel_back_left[35].addShapeBox(0F, -5F, 2F, 1, 5, 2, 0F, 5F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 370
        wheel_back_left[35].setRotationPoint(-26F, 2F, 19F);

        wheel_back_left[36].addShapeBox(-1F, 0F, 2F, 1, 5, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F); // Box 371
        wheel_back_left[36].setRotationPoint(-26F, 2F, 19F);

        wheel_back_left[37].addShapeBox(0F, 0F, 2F, 1, 5, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F); // Box 372
        wheel_back_left[37].setRotationPoint(-26F, 2F, 19F);

        wheel_back_left[38].addShapeBox(4F, 0F, 2F, 1, 5, 2, 0F, 5F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 373
        wheel_back_left[38].setRotationPoint(-26F, 2F, 19F);

        wheel_back_left[39].addShapeBox(5F, 0F, 2F, 1, 5, 2, 0F, 5F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 374
        wheel_back_left[39].setRotationPoint(-26F, 2F, 19F);

        wheel_back_left[40].addShapeBox(5F, -5F, 2F, 1, 5, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F); // Box 375
        wheel_back_left[40].setRotationPoint(-26F, 2F, 19F);

        wheel_back_left[41].addShapeBox(4F, -5F, 2F, 1, 5, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F); // Box 376
        wheel_back_left[41].setRotationPoint(-26F, 2F, 19F);
        this.add("wheel_back_left", wheel_back_left);

        ModelRendererTurbo[] wheel_back_right = new ModelRendererTurbo[42];
        wheel_back_right[0] = new ModelRendererTurbo(this, 233, 49, textureX, textureY); // Box 77
        wheel_back_right[1] = new ModelRendererTurbo(this, 33, 49, textureX, textureY); // Box 78
        wheel_back_right[2] = new ModelRendererTurbo(this, 281, 49, textureX, textureY); // Box 79
        wheel_back_right[3] = new ModelRendererTurbo(this, 57, 49, textureX, textureY); // Box 80
        wheel_back_right[4] = new ModelRendererTurbo(this, 193, 49, textureX, textureY); // Box 81
        wheel_back_right[5] = new ModelRendererTurbo(this, 297, 49, textureX, textureY); // Box 82
        wheel_back_right[6] = new ModelRendererTurbo(this, 401, 49, textureX, textureY); // Box 83
        wheel_back_right[7] = new ModelRendererTurbo(this, 345, 49, textureX, textureY); // Box 84
        wheel_back_right[8] = new ModelRendererTurbo(this, 441, 49, textureX, textureY); // Box 85
        wheel_back_right[9] = new ModelRendererTurbo(this, 313, 49, textureX, textureY); // Box 86
        wheel_back_right[10] = new ModelRendererTurbo(this, 457, 49, textureX, textureY); // Box 87
        wheel_back_right[11] = new ModelRendererTurbo(this, 481, 49, textureX, textureY); // Box 88
        wheel_back_right[12] = new ModelRendererTurbo(this, 497, 49, textureX, textureY); // Box 89
        wheel_back_right[13] = new ModelRendererTurbo(this, 9, 57, textureX, textureY); // Box 90
        wheel_back_right[14] = new ModelRendererTurbo(this, 57, 57, textureX, textureY); // Box 91
        wheel_back_right[15] = new ModelRendererTurbo(this, 33, 57, textureX, textureY); // Box 93
        wheel_back_right[16] = new ModelRendererTurbo(this, 73, 57, textureX, textureY); // Box 94
        wheel_back_right[17] = new ModelRendererTurbo(this, 89, 57, textureX, textureY); // Box 95
        wheel_back_right[18] = new ModelRendererTurbo(this, 337, 57, textureX, textureY); // Box 96
        wheel_back_right[19] = new ModelRendererTurbo(this, 1, 65, textureX, textureY); // Box 97
        wheel_back_right[20] = new ModelRendererTurbo(this, 25, 65, textureX, textureY); // Box 98
        wheel_back_right[21] = new ModelRendererTurbo(this, 489, 41, textureX, textureY); // Box 99
        wheel_back_right[22] = new ModelRendererTurbo(this, 257, 49, textureX, textureY); // Box 100
        wheel_back_right[23] = new ModelRendererTurbo(this, 417, 49, textureX, textureY); // Box 101
        wheel_back_right[24] = new ModelRendererTurbo(this, 57, 65, textureX, textureY); // Box 102
        wheel_back_right[25] = new ModelRendererTurbo(this, 81, 65, textureX, textureY); // Box 103
        wheel_back_right[26] = new ModelRendererTurbo(this, 121, 65, textureX, textureY); // Box 104
        wheel_back_right[27] = new ModelRendererTurbo(this, 145, 65, textureX, textureY); // Box 105
        wheel_back_right[28] = new ModelRendererTurbo(this, 489, 65, textureX, textureY); // Box 106
        wheel_back_right[29] = new ModelRendererTurbo(this, 1, 73, textureX, textureY); // Box 107
        wheel_back_right[30] = new ModelRendererTurbo(this, 17, 73, textureX, textureY); // Box 108
        wheel_back_right[31] = new ModelRendererTurbo(this, 33, 73, textureX, textureY); // Box 109
        wheel_back_right[32] = new ModelRendererTurbo(this, 65, 73, textureX, textureY); // Box 110
        wheel_back_right[33] = new ModelRendererTurbo(this, 81, 73, textureX, textureY); // Box 111
        wheel_back_right[34] = new ModelRendererTurbo(this, 121, 73, textureX, textureY); // Box 113
        wheel_back_right[35] = new ModelRendererTurbo(this, 57, 129, textureX, textureY); // Box 378
        wheel_back_right[36] = new ModelRendererTurbo(this, 65, 129, textureX, textureY); // Box 379
        wheel_back_right[37] = new ModelRendererTurbo(this, 73, 129, textureX, textureY); // Box 380
        wheel_back_right[38] = new ModelRendererTurbo(this, 81, 129, textureX, textureY); // Box 381
        wheel_back_right[39] = new ModelRendererTurbo(this, 89, 129, textureX, textureY); // Box 382
        wheel_back_right[40] = new ModelRendererTurbo(this, 385, 137, textureX, textureY); // Box 383
        wheel_back_right[41] = new ModelRendererTurbo(this, 409, 137, textureX, textureY); // Box 384

        wheel_back_right[0].addBox(-1F, -1F, -5F, 2, 2, 5, 0F); // Box 77
        wheel_back_right[0].setRotationPoint(-26F, 2F, -18.5F);

        wheel_back_right[1].addBox(-1.5F, -1.5F, -3F, 3, 3, 3, 0F); // Box 78
        wheel_back_right[1].setRotationPoint(-26F, 2F, -20F);

        wheel_back_right[2].addBox(-1F, -7F, -4F, 2, 6, 2, 0F); // Box 79
        wheel_back_right[2].setRotationPoint(-26F, 2F, -19F);

        wheel_back_right[3].addShapeBox(0F, -5F, -4F, 1, 5, 2, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 80
        wheel_back_right[3].setRotationPoint(-26F, 2F, -19F);

        wheel_back_right[4].addBox(-7F, -1F, -4F, 6, 2, 2, 0F); // Box 81
        wheel_back_right[4].setRotationPoint(-26F, 2F, -19F);

        wheel_back_right[5].addBox(-1F, 1F, -4F, 2, 6, 2, 0F); // Box 82
        wheel_back_right[5].setRotationPoint(-26F, 2F, -19F);

        wheel_back_right[6].addBox(1F, -1F, -4F, 6, 2, 2, 0F); // Box 83
        wheel_back_right[6].setRotationPoint(-26F, 2F, -19F);

        wheel_back_right[7].addBox(-2F, 6F, -4F, 4, 1, 4, 0F); // Box 84
        wheel_back_right[7].setRotationPoint(-26F, 2F, -19F);

        wheel_back_right[8].addShapeBox(2F, 4F, -4F, 3, 1, 4, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F); // Box 85
        wheel_back_right[8].setRotationPoint(-26F, 2F, -19F);

        wheel_back_right[9].addShapeBox(4F, 2F, -4F, 1, 3, 4, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 86
        wheel_back_right[9].setRotationPoint(-26F, 2F, -19F);

        wheel_back_right[10].addBox(6F, -2F, -4F, 1, 4, 4, 0F); // Box 87
        wheel_back_right[10].setRotationPoint(-26F, 2F, -19F);

        wheel_back_right[11].addShapeBox(6F, -5F, -4F, 1, 3, 4, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 88
        wheel_back_right[11].setRotationPoint(-26F, 2F, -19F);

        wheel_back_right[12].addShapeBox(2F, -5F, -4F, 3, 1, 4, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 89
        wheel_back_right[12].setRotationPoint(-26F, 2F, -19F);

        wheel_back_right[13].addBox(-2F, -7F, -4F, 4, 1, 4, 0F); // Box 90
        wheel_back_right[13].setRotationPoint(-26F, 2F, -19F);

        wheel_back_right[14].addShapeBox(-5F, -7F, -4F, 3, 1, 4, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F); // Box 91
        wheel_back_right[14].setRotationPoint(-26F, 2F, -19F);

        wheel_back_right[15].addShapeBox(-7F, -5F, -4F, 1, 3, 4, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 93
        wheel_back_right[15].setRotationPoint(-26F, 2F, -19F);

        wheel_back_right[16].addBox(-7F, -2F, -4F, 1, 4, 4, 0F); // Box 94
        wheel_back_right[16].setRotationPoint(-26F, 2F, -19F);

        wheel_back_right[17].addShapeBox(-7F, 2F, -4F, 1, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F); // Box 95
        wheel_back_right[17].setRotationPoint(-26F, 2F, -19F);

        wheel_back_right[18].addShapeBox(-5F, 6F, -4F, 3, 1, 4, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 96
        wheel_back_right[18].setRotationPoint(-26F, 2F, -19F);

        wheel_back_right[19].addBox(-2F, 7F, -5F, 4, 1, 5, 0F); // Box 97
        wheel_back_right[19].setRotationPoint(-26F, 2F, -19F);

        wheel_back_right[20].addShapeBox(2F, 5F, -5F, 3, 1, 5, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F); // Box 98
        wheel_back_right[20].setRotationPoint(-26F, 2F, -19F);

        wheel_back_right[21].addShapeBox(5F, 5F, -5F, 1, 1, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F); // Box 99
        wheel_back_right[21].setRotationPoint(-26F, 2F, -19F);

        wheel_back_right[22].addShapeBox(5F, 2F, -5F, 1, 3, 5, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 100
        wheel_back_right[22].setRotationPoint(-26F, 2F, -19F);

        wheel_back_right[23].addBox(7F, -2F, -5F, 1, 4, 5, 0F); // Box 101
        wheel_back_right[23].setRotationPoint(-26F, 2F, -19F);

        wheel_back_right[24].addShapeBox(7F, -5F, -5F, 1, 3, 5, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 102
        wheel_back_right[24].setRotationPoint(-26F, 2F, -19F);

        wheel_back_right[25].addShapeBox(5F, -6F, -5F, 1, 1, 5, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 103
        wheel_back_right[25].setRotationPoint(-26F, 2F, -19F);

        wheel_back_right[26].addShapeBox(2F, -6F, -5F, 3, 1, 5, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 104
        wheel_back_right[26].setRotationPoint(-26F, 2F, -19F);

        wheel_back_right[27].addBox(-2F, -8F, -5F, 4, 1, 5, 0F); // Box 105
        wheel_back_right[27].setRotationPoint(-26F, 2F, -19F);

        wheel_back_right[28].addShapeBox(-5F, -8F, -5F, 3, 1, 5, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F); // Box 106
        wheel_back_right[28].setRotationPoint(-26F, 2F, -19F);

        wheel_back_right[29].addShapeBox(-6F, -6F, -5F, 1, 1, 5, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 107
        wheel_back_right[29].setRotationPoint(-26F, 2F, -19F);

        wheel_back_right[30].addShapeBox(-8F, -5F, -5F, 1, 3, 5, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 108
        wheel_back_right[30].setRotationPoint(-26F, 2F, -19F);

        wheel_back_right[31].addBox(-8F, -2F, -5F, 1, 4, 5, 0F); // Box 109
        wheel_back_right[31].setRotationPoint(-26F, 2F, -19F);

        wheel_back_right[32].addShapeBox(-8F, 2F, -5F, 1, 3, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F); // Box 110
        wheel_back_right[32].setRotationPoint(-26F, 2F, -19F);

        wheel_back_right[33].addShapeBox(-6F, 5F, -5F, 1, 1, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 111
        wheel_back_right[33].setRotationPoint(-26F, 2F, -19F);

        wheel_back_right[34].addShapeBox(-5F, 7F, -5F, 3, 1, 5, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 113
        wheel_back_right[34].setRotationPoint(-26F, 2F, -19F);

        wheel_back_right[35].addShapeBox(-1F, -5F, -4F, 1, 5, 2, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 378
        wheel_back_right[35].setRotationPoint(-26F, 2F, -19F);

        wheel_back_right[36].addShapeBox(-6F, 0F, -4F, 1, 5, 2, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 379
        wheel_back_right[36].setRotationPoint(-26F, 2F, -19F);

        wheel_back_right[37].addShapeBox(-5F, 0F, -4F, 1, 5, 2, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 380
        wheel_back_right[37].setRotationPoint(-26F, 2F, -19F);

        wheel_back_right[38].addShapeBox(0F, 0F, -4F, 1, 5, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F); // Box 381
        wheel_back_right[38].setRotationPoint(-26F, 2F, -19F);

        wheel_back_right[39].addShapeBox(-1F, 0F, -4F, 1, 5, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F); // Box 382
        wheel_back_right[39].setRotationPoint(-26F, 2F, -19F);

        wheel_back_right[40].addShapeBox(-6F, -5F, -4F, 1, 5, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F); // Box 383
        wheel_back_right[40].setRotationPoint(-26F, 2F, -19F);

        wheel_back_right[41].addShapeBox(-5F, -5F, -4F, 1, 5, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F); // Box 384
        wheel_back_right[41].setRotationPoint(-26F, 2F, -19F);
        this.add("wheel_back_right", wheel_back_right);
        fixRotations();
    }

    @Override
    public void render(VehicleData data, String us){
        super.def_renderWheels4(data, us);
    }

    @Override
    public void render(VehicleData data, String us, VehicleEntity vehicle, int meta){
        super.def_renderWheels4(data, us, vehicle);
    }

}
