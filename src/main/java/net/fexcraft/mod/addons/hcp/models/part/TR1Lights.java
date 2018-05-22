package net.fexcraft.mod.addons.hcp.models.part;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.part.PartModel;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

/**
 *
 * @author Ferdinand (FEX___96)
 */
public class TR1Lights extends PartModel<VehicleData> {

    int textureX = 512;
    int textureY = 512;

    public TR1Lights(){
        this.creators.add("FEX___96");
        back_lights = new ModelRendererTurbo[2];
        back_lights[0] = new ModelRendererTurbo(this, 1, 97, textureX, textureY); // Box 119
        back_lights[1] = new ModelRendererTurbo(this, 361, 161, textureX, textureY); // Box 123

        back_lights[0].addBox(0F, 0F, 0F, 1, 2, 7, 0F); // Box 119
        back_lights[0].setRotationPoint(-236F, -20.5F, -22F);

        back_lights[1].addBox(0F, 0F, 0F, 1, 2, 7, 0F); // Box 123
        back_lights[1].setRotationPoint(-236F, -20.5F, 15F);

        reverse_lights = new ModelRendererTurbo[4];
        reverse_lights[0] = new ModelRendererTurbo(this, 505, 1, textureX, textureY); // Box 118
        reverse_lights[1] = new ModelRendererTurbo(this, 505, 9, textureX, textureY); // Box 121
        reverse_lights[2] = new ModelRendererTurbo(this, 505, 17, textureX, textureY); // Box 122
        reverse_lights[3] = new ModelRendererTurbo(this, 505, 25, textureX, textureY); // Box 125

        reverse_lights[0].addBox(0F, 0F, 0F, 1, 4, 2, 0F); // Box 118
        reverse_lights[0].setRotationPoint(-236F, -20.5F, -24F);

        reverse_lights[1].addBox(0F, 0F, 0F, 1, 4, 1, 0F); // Box 121
        reverse_lights[1].setRotationPoint(-236F, -20.5F, -15F);

        reverse_lights[2].addBox(0F, 0F, 0F, 1, 4, 2, 0F); // Box 122
        reverse_lights[2].setRotationPoint(-236F, -20.5F, 22F);

        reverse_lights[3].addBox(0F, 0F, 0F, 1, 4, 1, 0F); // Box 125
        reverse_lights[3].setRotationPoint(-236F, -20.5F, 14F);

        ///---INDICATOR LIGHTS---///
        body = new ModelRendererTurbo[1];
        body[0] = new ModelRendererTurbo(this, 505, 33, textureX, textureY); // Box 371
        body[0].addBox(0F, 0F, 0F, 1, 4, 1, 0F); // Box 371
        body[0].setRotationPoint(-236F, -20.5F, 24F);
        turret = new ModelRendererTurbo[1];
        turret[0] = new ModelRendererTurbo(this, 1, 41, textureX, textureY); // Box 372
        turret[0].addBox(0F, 0F, 0F, 1, 4, 1, 0F); // Box 372
        turret[0].setRotationPoint(-236F, -20.5F, -25F);
        ///---INDICATOR LIGHTS---///

        lights = new ModelRendererTurbo[36];
        lights[0] = new ModelRendererTurbo(this, 33, 49, textureX, textureY); // Box 79
        lights[1] = new ModelRendererTurbo(this, 313, 49, textureX, textureY); // Box 80
        lights[2] = new ModelRendererTurbo(this, 329, 49, textureX, textureY); // Box 81
        lights[3] = new ModelRendererTurbo(this, 345, 49, textureX, textureY); // Box 82
        lights[4] = new ModelRendererTurbo(this, 481, 49, textureX, textureY); // Box 83
        lights[5] = new ModelRendererTurbo(this, 25, 57, textureX, textureY); // Box 84
        lights[6] = new ModelRendererTurbo(this, 41, 57, textureX, textureY); // Box 85
        lights[7] = new ModelRendererTurbo(this, 209, 57, textureX, textureY); // Box 86
        lights[8] = new ModelRendererTurbo(this, 425, 65, textureX, textureY); // Box 87
        lights[9] = new ModelRendererTurbo(this, 441, 65, textureX, textureY); // Box 88
        lights[10] = new ModelRendererTurbo(this, 1, 73, textureX, textureY); // Box 89
        lights[11] = new ModelRendererTurbo(this, 185, 73, textureX, textureY); // Box 90
        lights[12] = new ModelRendererTurbo(this, 209, 73, textureX, textureY); // Box 91
        lights[13] = new ModelRendererTurbo(this, 377, 73, textureX, textureY); // Box 92
        lights[14] = new ModelRendererTurbo(this, 393, 73, textureX, textureY); // Box 93
        lights[15] = new ModelRendererTurbo(this, 425, 73, textureX, textureY); // Box 94
        lights[16] = new ModelRendererTurbo(this, 441, 73, textureX, textureY); // Box 95
        lights[17] = new ModelRendererTurbo(this, 1, 81, textureX, textureY); // Box 96
        lights[18] = new ModelRendererTurbo(this, 41, 81, textureX, textureY); // Box 97
        lights[19] = new ModelRendererTurbo(this, 185, 81, textureX, textureY); // Box 98
        lights[20] = new ModelRendererTurbo(this, 209, 81, textureX, textureY); // Box 99
        lights[21] = new ModelRendererTurbo(this, 233, 81, textureX, textureY); // Box 100
        lights[22] = new ModelRendererTurbo(this, 249, 81, textureX, textureY); // Box 101
        lights[23] = new ModelRendererTurbo(this, 265, 81, textureX, textureY); // Box 102
        lights[24] = new ModelRendererTurbo(this, 321, 81, textureX, textureY); // Box 103
        lights[25] = new ModelRendererTurbo(this, 337, 81, textureX, textureY); // Box 104
        lights[26] = new ModelRendererTurbo(this, 353, 81, textureX, textureY); // Box 105
        lights[27] = new ModelRendererTurbo(this, 377, 81, textureX, textureY); // Box 106
        lights[28] = new ModelRendererTurbo(this, 393, 81, textureX, textureY); // Box 107
        lights[29] = new ModelRendererTurbo(this, 409, 81, textureX, textureY); // Box 108
        lights[30] = new ModelRendererTurbo(this, 425, 81, textureX, textureY); // Box 109
        lights[31] = new ModelRendererTurbo(this, 441, 81, textureX, textureY); // Box 110
        lights[32] = new ModelRendererTurbo(this, 465, 81, textureX, textureY); // Box 111
        lights[33] = new ModelRendererTurbo(this, 481, 81, textureX, textureY); // Box 112
        lights[34] = new ModelRendererTurbo(this, 497, 81, textureX, textureY); // Box 113
        lights[35] = new ModelRendererTurbo(this, 1, 89, textureX, textureY); // Box 114

        lights[0].addBox(0F, 0F, 0F, 3, 1, 1, 0F); // Box 79
        lights[0].setRotationPoint(-232F, -20F, -25.5F);

        lights[1].addBox(0F, 0F, 0F, 3, 1, 1, 0F); // Box 80
        lights[1].setRotationPoint(-222F, -20F, -25.5F);

        lights[2].addBox(0F, 0F, 0F, 3, 1, 1, 0F); // Box 81
        lights[2].setRotationPoint(-212F, -20F, -25.5F);

        lights[3].addBox(0F, 0F, 0F, 3, 1, 1, 0F); // Box 82
        lights[3].setRotationPoint(-202F, -20F, -25.5F);

        lights[4].addBox(0F, 0F, 0F, 3, 1, 1, 0F); // Box 83
        lights[4].setRotationPoint(-192F, -20F, -25.5F);

        lights[5].addBox(0F, 0F, 0F, 3, 1, 1, 0F); // Box 84
        lights[5].setRotationPoint(-182F, -20F, -25.5F);

        lights[6].addBox(0F, 0F, 0F, 3, 1, 1, 0F); // Box 85
        lights[6].setRotationPoint(-172F, -20F, -25.5F);

        lights[7].addBox(0F, 0F, 0F, 3, 1, 1, 0F); // Box 86
        lights[7].setRotationPoint(-162F, -20F, -25.5F);

        lights[8].addBox(0F, 0F, 0F, 3, 1, 1, 0F); // Box 87
        lights[8].setRotationPoint(-152F, -20F, -25.5F);

        lights[9].addBox(0F, 0F, 0F, 3, 1, 1, 0F); // Box 88
        lights[9].setRotationPoint(-142F, -20F, -25.5F);

        lights[10].addBox(0F, 0F, 0F, 3, 1, 1, 0F); // Box 89
        lights[10].setRotationPoint(-132F, -20F, -25.5F);

        lights[11].addBox(0F, 0F, 0F, 3, 1, 1, 0F); // Box 90
        lights[11].setRotationPoint(-122F, -20F, -25.5F);

        lights[12].addBox(0F, 0F, 0F, 3, 1, 1, 0F); // Box 91
        lights[12].setRotationPoint(-112F, -20F, -25.5F);

        lights[13].addBox(0F, 0F, 0F, 3, 1, 1, 0F); // Box 92
        lights[13].setRotationPoint(-102F, -20F, -25.5F);

        lights[14].addBox(0F, 0F, 0F, 3, 1, 1, 0F); // Box 93
        lights[14].setRotationPoint(-92F, -20F, -25.5F);

        lights[15].addBox(0F, 0F, 0F, 3, 1, 1, 0F); // Box 94
        lights[15].setRotationPoint(-82F, -20F, -25.5F);

        lights[16].addBox(0F, 0F, 0F, 3, 1, 1, 0F); // Box 95
        lights[16].setRotationPoint(-72F, -20F, -25.5F);

        lights[17].addBox(0F, 0F, 0F, 3, 1, 1, 0F); // Box 96
        lights[17].setRotationPoint(-62F, -20F, -25.5F);

        lights[18].addBox(0F, 0F, 0F, 3, 1, 1, 0F); // Box 97
        lights[18].setRotationPoint(-232F, -20F, 24.5F);

        lights[19].addBox(0F, 0F, 0F, 3, 1, 1, 0F); // Box 98
        lights[19].setRotationPoint(-222F, -20F, 24.5F);

        lights[20].addBox(0F, 0F, 0F, 3, 1, 1, 0F); // Box 99
        lights[20].setRotationPoint(-212F, -20F, 24.5F);

        lights[21].addBox(0F, 0F, 0F, 3, 1, 1, 0F); // Box 100
        lights[21].setRotationPoint(-202F, -20F, 24.5F);

        lights[22].addBox(0F, 0F, 0F, 3, 1, 1, 0F); // Box 101
        lights[22].setRotationPoint(-192F, -20F, 24.5F);

        lights[23].addBox(0F, 0F, 0F, 3, 1, 1, 0F); // Box 102
        lights[23].setRotationPoint(-182F, -20F, 24.5F);

        lights[24].addBox(0F, 0F, 0F, 3, 1, 1, 0F); // Box 103
        lights[24].setRotationPoint(-172F, -20F, 24.5F);

        lights[25].addBox(0F, 0F, 0F, 3, 1, 1, 0F); // Box 104
        lights[25].setRotationPoint(-162F, -20F, 24.5F);

        lights[26].addBox(0F, 0F, 0F, 3, 1, 1, 0F); // Box 105
        lights[26].setRotationPoint(-152F, -20F, 24.5F);

        lights[27].addBox(0F, 0F, 0F, 3, 1, 1, 0F); // Box 106
        lights[27].setRotationPoint(-142F, -20F, 24.5F);

        lights[28].addBox(0F, 0F, 0F, 3, 1, 1, 0F); // Box 107
        lights[28].setRotationPoint(-132F, -20F, 24.5F);

        lights[29].addBox(0F, 0F, 0F, 3, 1, 1, 0F); // Box 108
        lights[29].setRotationPoint(-122F, -20F, 24.5F);

        lights[30].addBox(0F, 0F, 0F, 3, 1, 1, 0F); // Box 109
        lights[30].setRotationPoint(-112F, -20F, 24.5F);

        lights[31].addBox(0F, 0F, 0F, 3, 1, 1, 0F); // Box 110
        lights[31].setRotationPoint(-102F, -20F, 24.5F);

        lights[32].addBox(0F, 0F, 0F, 3, 1, 1, 0F); // Box 111
        lights[32].setRotationPoint(-92F, -20F, 24.5F);

        lights[33].addBox(0F, 0F, 0F, 3, 1, 1, 0F); // Box 112
        lights[33].setRotationPoint(-82F, -20F, 24.5F);

        lights[34].addBox(0F, 0F, 0F, 3, 1, 1, 0F); // Box 113
        lights[34].setRotationPoint(-72F, -20F, 24.5F);

        lights[35].addBox(0F, 0F, 0F, 3, 1, 1, 0F); // Box 114
        lights[35].setRotationPoint(-62F, -20F, 24.5F);
    }

}
