package net.fexcraft.mod.addons.zmp.models.trailer;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.vehicle.VehicleModel;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelBoatTrailer extends VehicleModel<VehicleData> {

    int textureX = 512;
    int textureY = 512;

    public ModelBoatTrailer(){
        body = new ModelRendererTurbo[178];
        body[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
        body[1] = new ModelRendererTurbo(this, 217, 1, textureX, textureY); // Box 1
        body[2] = new ModelRendererTurbo(this, 361, 1, textureX, textureY); // Box 2
        body[3] = new ModelRendererTurbo(this, 1, 9, textureX, textureY); // Box 3
        body[4] = new ModelRendererTurbo(this, 33, 9, textureX, textureY); // Box 4
        body[5] = new ModelRendererTurbo(this, 65, 9, textureX, textureY); // Box 5
        body[6] = new ModelRendererTurbo(this, 97, 9, textureX, textureY); // Box 6
        body[7] = new ModelRendererTurbo(this, 129, 9, textureX, textureY); // Box 7
        body[8] = new ModelRendererTurbo(this, 161, 9, textureX, textureY); // Box 8
        body[9] = new ModelRendererTurbo(this, 161, 9, textureX, textureY); // Box 9
        body[10] = new ModelRendererTurbo(this, 201, 9, textureX, textureY); // Box 10
        body[11] = new ModelRendererTurbo(this, 265, 9, textureX, textureY); // Box 11
        body[12] = new ModelRendererTurbo(this, 17, 9, textureX, textureY); // Box 12
        body[13] = new ModelRendererTurbo(this, 49, 9, textureX, textureY); // Box 13
        body[14] = new ModelRendererTurbo(this, 81, 9, textureX, textureY); // Box 14
        body[15] = new ModelRendererTurbo(this, 113, 9, textureX, textureY); // Box 15
        body[16] = new ModelRendererTurbo(this, 145, 9, textureX, textureY); // Box 16
        body[17] = new ModelRendererTurbo(this, 321, 9, textureX, textureY); // Box 17
        body[18] = new ModelRendererTurbo(this, 249, 9, textureX, textureY); // Box 18
        body[19] = new ModelRendererTurbo(this, 337, 9, textureX, textureY); // Box 19
        body[20] = new ModelRendererTurbo(this, 369, 9, textureX, textureY); // Box 20
        body[21] = new ModelRendererTurbo(this, 401, 9, textureX, textureY); // Box 21
        body[22] = new ModelRendererTurbo(this, 505, 1, textureX, textureY); // Box 22
        body[23] = new ModelRendererTurbo(this, 1, 9, textureX, textureY); // Box 299
        body[24] = new ModelRendererTurbo(this, 353, 9, textureX, textureY); // Box 300
        body[25] = new ModelRendererTurbo(this, 385, 9, textureX, textureY); // Box 8
        body[26] = new ModelRendererTurbo(this, 177, 9, textureX, textureY); // Box 9
        body[27] = new ModelRendererTurbo(this, 433, 9, textureX, textureY); // Box 173
        body[28] = new ModelRendererTurbo(this, 465, 9, textureX, textureY); // Box 175
        body[29] = new ModelRendererTurbo(this, 201, 17, textureX, textureY); // Box 176
        body[30] = new ModelRendererTurbo(this, 265, 17, textureX, textureY); // Box 178
        body[31] = new ModelRendererTurbo(this, 369, 9, textureX, textureY); // Box 16
        body[32] = new ModelRendererTurbo(this, 417, 9, textureX, textureY); // Box 18
        body[33] = new ModelRendererTurbo(this, 225, 17, textureX, textureY); // Box 33
        body[34] = new ModelRendererTurbo(this, 17, 17, textureX, textureY); // Box 34
        body[35] = new ModelRendererTurbo(this, 49, 17, textureX, textureY); // Box 35
        body[36] = new ModelRendererTurbo(this, 289, 17, textureX, textureY); // Box 36
        body[37] = new ModelRendererTurbo(this, 1, 9, textureX, textureY); // Box 37
        body[38] = new ModelRendererTurbo(this, 9, 9, textureX, textureY); // Box 38
        body[39] = new ModelRendererTurbo(this, 17, 9, textureX, textureY); // Box 39
        body[40] = new ModelRendererTurbo(this, 41, 9, textureX, textureY); // Box 40
        body[41] = new ModelRendererTurbo(this, 401, 9, textureX, textureY); // Box 506
        body[42] = new ModelRendererTurbo(this, 433, 9, textureX, textureY); // Box 506
        body[43] = new ModelRendererTurbo(this, 457, 9, textureX, textureY); // Box 506
        body[44] = new ModelRendererTurbo(this, 489, 9, textureX, textureY); // Box 506
        body[45] = new ModelRendererTurbo(this, 201, 17, textureX, textureY); // Box 506
        body[46] = new ModelRendererTurbo(this, 321, 17, textureX, textureY); // Box 506
        body[47] = new ModelRendererTurbo(this, 457, 17, textureX, textureY); // Box 506
        body[48] = new ModelRendererTurbo(this, 489, 17, textureX, textureY); // Box 506
        body[49] = new ModelRendererTurbo(this, 1, 25, textureX, textureY); // Box 506
        body[50] = new ModelRendererTurbo(this, 17, 25, textureX, textureY); // Box 506
        body[51] = new ModelRendererTurbo(this, 33, 25, textureX, textureY); // Box 506
        body[52] = new ModelRendererTurbo(this, 49, 25, textureX, textureY); // Box 506
        body[53] = new ModelRendererTurbo(this, 65, 25, textureX, textureY); // Box 506
        body[54] = new ModelRendererTurbo(this, 81, 25, textureX, textureY); // Box 506
        body[55] = new ModelRendererTurbo(this, 97, 25, textureX, textureY); // Box 506
        body[56] = new ModelRendererTurbo(this, 113, 25, textureX, textureY); // Box 506
        body[57] = new ModelRendererTurbo(this, 129, 25, textureX, textureY); // Box 506
        body[58] = new ModelRendererTurbo(this, 145, 25, textureX, textureY); // Box 506
        body[59] = new ModelRendererTurbo(this, 81, 17, textureX, textureY); // Box 506
        body[60] = new ModelRendererTurbo(this, 97, 17, textureX, textureY); // Box 506
        body[61] = new ModelRendererTurbo(this, 113, 17, textureX, textureY); // Box 506
        body[62] = new ModelRendererTurbo(this, 129, 17, textureX, textureY); // Box 506
        body[63] = new ModelRendererTurbo(this, 145, 17, textureX, textureY); // Box 506
        body[64] = new ModelRendererTurbo(this, 161, 17, textureX, textureY); // Box 506
        body[65] = new ModelRendererTurbo(this, 177, 17, textureX, textureY); // Box 506
        body[66] = new ModelRendererTurbo(this, 265, 17, textureX, textureY); // Box 506
        body[67] = new ModelRendererTurbo(this, 337, 17, textureX, textureY); // Box 506
        body[68] = new ModelRendererTurbo(this, 161, 25, textureX, textureY); // Box 506
        body[69] = new ModelRendererTurbo(this, 177, 25, textureX, textureY); // Box 506
        body[70] = new ModelRendererTurbo(this, 201, 25, textureX, textureY); // Box 506
        body[71] = new ModelRendererTurbo(this, 225, 25, textureX, textureY); // Box 506
        body[72] = new ModelRendererTurbo(this, 241, 25, textureX, textureY); // Box 506
        body[73] = new ModelRendererTurbo(this, 257, 25, textureX, textureY); // Box 506
        body[74] = new ModelRendererTurbo(this, 289, 25, textureX, textureY); // Box 506
        body[75] = new ModelRendererTurbo(this, 305, 25, textureX, textureY); // Box 506
        body[76] = new ModelRendererTurbo(this, 321, 25, textureX, textureY); // Box 506
        body[77] = new ModelRendererTurbo(this, 337, 25, textureX, textureY); // Box 506
        body[78] = new ModelRendererTurbo(this, 353, 25, textureX, textureY); // Box 506
        body[79] = new ModelRendererTurbo(this, 369, 25, textureX, textureY); // Box 506
        body[80] = new ModelRendererTurbo(this, 385, 25, textureX, textureY); // Box 506
        body[81] = new ModelRendererTurbo(this, 401, 25, textureX, textureY); // Box 506
        body[82] = new ModelRendererTurbo(this, 417, 25, textureX, textureY); // Box 506
        body[83] = new ModelRendererTurbo(this, 497, 25, textureX, textureY); // Box 506
        body[84] = new ModelRendererTurbo(this, 1, 33, textureX, textureY); // Box 506
        body[85] = new ModelRendererTurbo(this, 17, 33, textureX, textureY); // Box 506
        body[86] = new ModelRendererTurbo(this, 33, 33, textureX, textureY); // Box 506
        body[87] = new ModelRendererTurbo(this, 49, 33, textureX, textureY); // Box 506
        body[88] = new ModelRendererTurbo(this, 65, 33, textureX, textureY); // Box 506
        body[89] = new ModelRendererTurbo(this, 81, 33, textureX, textureY); // Box 506
        body[90] = new ModelRendererTurbo(this, 97, 33, textureX, textureY); // Box 506
        body[91] = new ModelRendererTurbo(this, 113, 33, textureX, textureY); // Box 141
        body[92] = new ModelRendererTurbo(this, 129, 33, textureX, textureY); // Box 142
        body[93] = new ModelRendererTurbo(this, 145, 33, textureX, textureY); // Box 143
        body[94] = new ModelRendererTurbo(this, 161, 33, textureX, textureY); // Box 144
        body[95] = new ModelRendererTurbo(this, 177, 33, textureX, textureY); // Box 145
        body[96] = new ModelRendererTurbo(this, 233, 33, textureX, textureY); // Box 146
        body[97] = new ModelRendererTurbo(this, 249, 33, textureX, textureY); // Box 147
        body[98] = new ModelRendererTurbo(this, 297, 33, textureX, textureY); // Box 148
        body[99] = new ModelRendererTurbo(this, 313, 33, textureX, textureY); // Box 149
        body[100] = new ModelRendererTurbo(this, 329, 33, textureX, textureY); // Box 150
        body[101] = new ModelRendererTurbo(this, 345, 33, textureX, textureY); // Box 151
        body[102] = new ModelRendererTurbo(this, 361, 33, textureX, textureY); // Box 152
        body[103] = new ModelRendererTurbo(this, 377, 33, textureX, textureY); // Box 153
        body[104] = new ModelRendererTurbo(this, 393, 33, textureX, textureY); // Box 154
        body[105] = new ModelRendererTurbo(this, 409, 33, textureX, textureY); // Box 155
        body[106] = new ModelRendererTurbo(this, 425, 33, textureX, textureY); // Box 156
        body[107] = new ModelRendererTurbo(this, 441, 33, textureX, textureY); // Box 157
        body[108] = new ModelRendererTurbo(this, 457, 33, textureX, textureY); // Box 158
        body[109] = new ModelRendererTurbo(this, 473, 33, textureX, textureY); // Box 159
        body[110] = new ModelRendererTurbo(this, 489, 33, textureX, textureY); // Box 160
        body[111] = new ModelRendererTurbo(this, 9, 41, textureX, textureY); // Box 161
        body[112] = new ModelRendererTurbo(this, 25, 41, textureX, textureY); // Box 162
        body[113] = new ModelRendererTurbo(this, 41, 41, textureX, textureY); // Box 163
        body[114] = new ModelRendererTurbo(this, 57, 41, textureX, textureY); // Box 164
        body[115] = new ModelRendererTurbo(this, 73, 41, textureX, textureY); // Box 165
        body[116] = new ModelRendererTurbo(this, 89, 41, textureX, textureY); // Box 166
        body[117] = new ModelRendererTurbo(this, 105, 41, textureX, textureY); // Box 167
        body[118] = new ModelRendererTurbo(this, 121, 41, textureX, textureY); // Box 168
        body[119] = new ModelRendererTurbo(this, 137, 41, textureX, textureY); // Box 169
        body[120] = new ModelRendererTurbo(this, 153, 41, textureX, textureY); // Box 170
        body[121] = new ModelRendererTurbo(this, 225, 41, textureX, textureY); // Box 171
        body[122] = new ModelRendererTurbo(this, 241, 41, textureX, textureY); // Box 172
        body[123] = new ModelRendererTurbo(this, 257, 41, textureX, textureY); // Box 173
        body[124] = new ModelRendererTurbo(this, 273, 41, textureX, textureY); // Box 174
        body[125] = new ModelRendererTurbo(this, 289, 41, textureX, textureY); // Box 175
        body[126] = new ModelRendererTurbo(this, 305, 41, textureX, textureY); // Box 176
        body[127] = new ModelRendererTurbo(this, 321, 41, textureX, textureY); // Box 177
        body[128] = new ModelRendererTurbo(this, 337, 41, textureX, textureY); // Box 178
        body[129] = new ModelRendererTurbo(this, 353, 41, textureX, textureY); // Box 179
        body[130] = new ModelRendererTurbo(this, 369, 41, textureX, textureY); // Box 180
        body[131] = new ModelRendererTurbo(this, 385, 41, textureX, textureY); // Box 181
        body[132] = new ModelRendererTurbo(this, 401, 41, textureX, textureY); // Box 182
        body[133] = new ModelRendererTurbo(this, 417, 41, textureX, textureY); // Box 183
        body[134] = new ModelRendererTurbo(this, 433, 41, textureX, textureY); // Box 184
        body[135] = new ModelRendererTurbo(this, 449, 41, textureX, textureY); // Box 185
        body[136] = new ModelRendererTurbo(this, 465, 41, textureX, textureY); // Box 186
        body[137] = new ModelRendererTurbo(this, 481, 41, textureX, textureY); // Box 187
        body[138] = new ModelRendererTurbo(this, 497, 41, textureX, textureY); // Box 188
        body[139] = new ModelRendererTurbo(this, 1, 49, textureX, textureY); // Box 189
        body[140] = new ModelRendererTurbo(this, 17, 49, textureX, textureY); // Box 190
        body[141] = new ModelRendererTurbo(this, 33, 49, textureX, textureY); // Box 191
        body[142] = new ModelRendererTurbo(this, 57, 49, textureX, textureY); // Box 192
        body[143] = new ModelRendererTurbo(this, 353, 9, textureX, textureY); // Box 143
        body[144] = new ModelRendererTurbo(this, 385, 9, textureX, textureY); // Box 144
        body[145] = new ModelRendererTurbo(this, 49, 9, textureX, textureY); // Box 145
        body[146] = new ModelRendererTurbo(this, 73, 9, textureX, textureY); // Box 146
        body[147] = new ModelRendererTurbo(this, 81, 9, textureX, textureY); // Box 147
        body[148] = new ModelRendererTurbo(this, 105, 9, textureX, textureY); // Box 148
        body[149] = new ModelRendererTurbo(this, 113, 9, textureX, textureY); // Box 149
        body[150] = new ModelRendererTurbo(this, 137, 9, textureX, textureY); // Box 150
        body[151] = new ModelRendererTurbo(this, 145, 9, textureX, textureY); // Box 151
        body[152] = new ModelRendererTurbo(this, 169, 9, textureX, textureY); // Box 152
        body[153] = new ModelRendererTurbo(this, 81, 49, textureX, textureY); // Box 153
        body[154] = new ModelRendererTurbo(this, 169, 49, textureX, textureY); // Box 154
        body[155] = new ModelRendererTurbo(this, 345, 9, textureX, textureY); // Box 155
        body[156] = new ModelRendererTurbo(this, 417, 9, textureX, textureY); // Box 156
        body[157] = new ModelRendererTurbo(this, 505, 17, textureX, textureY); // Box 157
        body[158] = new ModelRendererTurbo(this, 505, 33, textureX, textureY); // Box 158
        body[159] = new ModelRendererTurbo(this, 257, 49, textureX, textureY); // Box 159
        body[160] = new ModelRendererTurbo(this, 273, 49, textureX, textureY); // Box 160
        body[161] = new ModelRendererTurbo(this, 297, 49, textureX, textureY); // Box 161
        body[162] = new ModelRendererTurbo(this, 473, 9, textureX, textureY); // Box 162
        body[163] = new ModelRendererTurbo(this, 257, 17, textureX, textureY); // Box 163
        body[164] = new ModelRendererTurbo(this, 313, 49, textureX, textureY); // Box 164
        body[165] = new ModelRendererTurbo(this, 329, 49, textureX, textureY); // Box 165
        body[166] = new ModelRendererTurbo(this, 377, 17, textureX, textureY); // Box 166
        body[167] = new ModelRendererTurbo(this, 409, 17, textureX, textureY); // Box 167
        body[168] = new ModelRendererTurbo(this, 345, 49, textureX, textureY); // Box 168
        body[169] = new ModelRendererTurbo(this, 441, 17, textureX, textureY); // Box 169
        body[170] = new ModelRendererTurbo(this, 361, 49, textureX, textureY); // Box 170
        body[171] = new ModelRendererTurbo(this, 377, 49, textureX, textureY); // Box 171
        body[172] = new ModelRendererTurbo(this, 473, 17, textureX, textureY); // Box 172
        body[173] = new ModelRendererTurbo(this, 273, 25, textureX, textureY); // Box 173
        body[174] = new ModelRendererTurbo(this, 393, 49, textureX, textureY); // Box 174
        body[175] = new ModelRendererTurbo(this, 409, 49, textureX, textureY); // Box 175
        body[176] = new ModelRendererTurbo(this, 265, 49, textureX, textureY); // Box 176
        body[177] = new ModelRendererTurbo(this, 425, 49, textureX, textureY); // Box 177

        body[0].addBox(0F, 0F, 0F, 105, 2, 2, 0F); // Box 0
        body[0].setRotationPoint(-104F, -2F, -1.5F);

        body[1].addBox(0F, 0F, 0F, 70, 2, 1, 0F); // Box 1
        body[1].setRotationPoint(-104F, -1.7F, -15.5F);

        body[2].addBox(0F, 0F, 0F, 70, 2, 1, 0F); // Box 2
        body[2].setRotationPoint(-104F, -1.7F, 13.5F);

        body[3].addBox(0F, 0F, 0F, 1, 1, 13, 0F); // Box 3
        body[3].setRotationPoint(-61F, -1.7F, 0.5F);

        body[4].addBox(0F, 0F, 0F, 1, 1, 13, 0F); // Box 4
        body[4].setRotationPoint(-48F, -1.7F, 0.5F);

        body[5].addBox(0F, 0F, 0F, 1, 1, 13, 0F); // Box 5
        body[5].setRotationPoint(-35F, -1.7F, 0.5F);

        body[6].addBox(0F, 0F, 0F, 1, 1, 13, 0F); // Box 6
        body[6].setRotationPoint(-35F, -1.7F, -14.5F);

        body[7].addBox(0F, 0F, 0F, 1, 1, 13, 0F); // Box 7
        body[7].setRotationPoint(-48F, -1.7F, -14.5F);

        body[8].addBox(0F, 0F, 0F, 1, 1, 13, 0F); // Box 8
        body[8].setRotationPoint(-61F, -1.7F, -14.5F);

        body[9].addBox(0F, 0F, 0F, 1, 2, 30, 0F); // Box 9
        body[9].setRotationPoint(-105F, -1.7F, -15.5F);

        body[10].addShapeBox(0F, 0F, 0F, 28, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, -14F, 0F, 0F, 14F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -14F, 0F, 0F, 14F, 0F, 0F, 0F); // Box 10
        body[10].setRotationPoint(-34F, -1.7F, -15.5F);

        body[11].addShapeBox(0F, 0F, 0F, 28, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 14F, 0F, 0F, -14F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 14F, 0F, 0F, -14F, 0F, 0F, 0F); // Box 11
        body[11].setRotationPoint(-34F, -1.7F, 13.5F);

        body[12].addBox(0F, 0F, 0F, 8, 1, 6, 0F); // Box 12
        body[12].setRotationPoint(-80F, -5.7F, -21.5F);

        body[13].addShapeBox(0F, 0F, 0F, 6, 1, 6, 0F, 0F, 0F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, 0F, 0F); // Box 13
        body[13].setRotationPoint(-72F, -5.7F, -21.5F);

        body[14].addShapeBox(0F, 0F, 0F, 6, 1, 6, 0F, 0F, 0F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, 0F, 0F); // Box 14
        body[14].setRotationPoint(-72F, -5.7F, 14.5F);

        body[15].addBox(0F, 0F, 0F, 8, 1, 6, 0F); // Box 15
        body[15].setRotationPoint(-80F, -5.7F, 14.5F);

        body[16].addShapeBox(0F, 0F, 0F, 6, 1, 6, 0F, 0F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 5F, 0F); // Box 16
        body[16].setRotationPoint(-86F, -5.7F, -21.5F);

        body[17].addShapeBox(0F, 0F, 0F, 6, 1, 6, 0F, 0F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 5F, 0F); // Box 17
        body[17].setRotationPoint(-86F, -5.7F, 14.5F);

        body[18].addBox(0F, 0F, 0F, 1, 1, 13, 0F); // Box 18
        body[18].setRotationPoint(-77F, -1.7F, -14.5F);

        body[19].addBox(0F, 0F, 0F, 1, 1, 13, 0F); // Box 19
        body[19].setRotationPoint(-77F, -1.7F, 0.5F);

        body[20].addBox(0F, 0F, 0F, 1, 1, 13, 0F); // Box 20
        body[20].setRotationPoint(-91F, -1.7F, -14.5F);

        body[21].addBox(0F, 0F, 0F, 1, 1, 13, 0F); // Box 21
        body[21].setRotationPoint(-91F, -1.7F, 0.5F);

        body[22].addShapeBox(0F, 0F, 0F, 2, 9, 1, 0F, -6F, 0F, 0F, 6F, 0F, 0F, 6F, 0F, 0F, -6F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 22
        body[22].setRotationPoint(-24F, -11F, -1F);

        body[23].addShapeBox(0F, 0F, 0F, 1, 3, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 299
        body[23].setRotationPoint(-74F, -0.5F, -3F);

        body[24].addShapeBox(0F, 0F, 0F, 3, 1, 7, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 300
        body[24].setRotationPoint(-77F, 2.5F, -4F);

        body[25].addShapeBox(0F, 0F, 0F, 3, 3, 7, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 8
        body[25].setRotationPoint(-77F, -0.5F, -4F);

        body[26].addShapeBox(0F, 0F, 0F, 2, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 9
        body[26].setRotationPoint(-76.5F, 0F, 3F);

        body[27].addShapeBox(0F, 0F, 0F, 1, 2, 14, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 173
        body[27].setRotationPoint(-75.5F, 0F, 5F);

        body[28].addShapeBox(0F, 0F, 0F, 1, 2, 14, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 175
        body[28].setRotationPoint(-76.5F, 0F, 5F);

        body[29].addShapeBox(0F, 0F, 0F, 1, 2, 14, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 176
        body[29].setRotationPoint(-76.5F, 0F, -20F);

        body[30].addShapeBox(0F, 0F, 0F, 1, 2, 14, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 178
        body[30].setRotationPoint(-75.5F, 0F, -20F);

        body[31].addShapeBox(0F, 0F, 0F, 2, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 16
        body[31].setRotationPoint(-76.5F, 0F, -6F);

        body[32].addShapeBox(0F, 0F, 0F, 3, 1, 7, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 18
        body[32].setRotationPoint(-77F, -1.5F, -4F);

        body[33].addBox(0F, 0F, 0F, 14, 1, 1, 0F); // Box 33
        body[33].setRotationPoint(-83F, -2.7F, -16.5F);

        body[34].addBox(0F, 0F, 0F, 12, 1, 1, 0F); // Box 34
        body[34].setRotationPoint(-82F, -3.7F, -16.5F);

        body[35].addBox(0F, 0F, 0F, 12, 1, 1, 0F); // Box 35
        body[35].setRotationPoint(-82F, -3.7F, 14.5F);

        body[36].addBox(0F, 0F, 0F, 14, 1, 1, 0F); // Box 36
        body[36].setRotationPoint(-83F, -2.7F, 14.5F);

        body[37].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F); // Box 37
        body[37].setRotationPoint(-81.5F, -2F, 13.5F);

        body[38].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F); // Box 38
        body[38].setRotationPoint(-70.5F, -2F, 13.5F);

        body[39].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F); // Box 39
        body[39].setRotationPoint(-81.5F, -2F, -15.5F);

        body[40].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F); // Box 40
        body[40].setRotationPoint(-70.5F, -2F, -15.5F);

        body[41].addShapeBox(-0.5F, -1.5F, -1.5F, 2, 3, 2, 0F, -0.5F, 0.25F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, -0.5F, 0.25F, 0F, -0.5F, 0.25F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, -0.5F, 0.25F, 0F); // Box 506
        body[41].setRotationPoint(-75.5F, 2.05F, 19F);

        body[42].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[42].setRotationPoint(-75.5F, 2.05F, 20F);

        body[43].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[43].setRotationPoint(-75.5F, 2.05F, 20F);
        body[43].rotateAngleZ = -0.39269908F;

        body[44].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[44].setRotationPoint(-75.5F, 2.05F, 20F);
        body[44].rotateAngleZ = -1.17809725F;

        body[45].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[45].setRotationPoint(-75.5F, 2.05F, 20F);
        body[45].rotateAngleZ = -0.78539816F;

        body[46].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[46].setRotationPoint(-75.5F, 2.05F, 20F);
        body[46].rotateAngleZ = -2.74889357F;

        body[47].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[47].setRotationPoint(-75.5F, 2.05F, 20F);
        body[47].rotateAngleZ = -2.35619449F;

        body[48].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[48].setRotationPoint(-75.5F, 2.05F, 20F);
        body[48].rotateAngleZ = -1.96349541F;

        body[49].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[49].setRotationPoint(-75.5F, 2.05F, 20F);
        body[49].rotateAngleZ = -1.57079633F;

        body[50].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[50].setRotationPoint(-75.5F, 2.05F, 20F);
        body[50].rotateAngleZ = -5.89048623F;

        body[51].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[51].setRotationPoint(-75.5F, 2.05F, 20F);
        body[51].rotateAngleZ = -5.49778714F;

        body[52].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[52].setRotationPoint(-75.5F, 2.05F, 20F);
        body[52].rotateAngleZ = -5.10508806F;

        body[53].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[53].setRotationPoint(-75.5F, 2.05F, 20F);
        body[53].rotateAngleZ = -4.71238898F;

        body[54].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[54].setRotationPoint(-75.5F, 2.05F, 20F);
        body[54].rotateAngleZ = -4.3196899F;

        body[55].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[55].setRotationPoint(-75.5F, 2.05F, 20F);
        body[55].rotateAngleZ = -3.92699082F;

        body[56].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[56].setRotationPoint(-75.5F, 2.05F, 20F);
        body[56].rotateAngleZ = -3.53429174F;

        body[57].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[57].setRotationPoint(-75.5F, 2.05F, 20F);
        body[57].rotateAngleZ = -3.14159265F;

        body[58].addShapeBox(-1.5F, -1.5F, -1.5F, 2, 3, 2, 0F, 0F, -0.75F, 0F, -0.5F, 0.25F, 0F, -0.5F, 0.25F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, -0.5F, 0.25F, 0F, -0.5F, 0.25F, 0F, 0F, -0.75F, 0F); // Box 506
        body[58].setRotationPoint(-75.5F, 2.05F, 19F);

        body[59].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[59].setRotationPoint(-75.5F, 2.05F, 20F);

        body[60].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[60].setRotationPoint(-75.5F, 2.05F, 20F);
        body[60].rotateAngleZ = -0.39269908F;

        body[61].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[61].setRotationPoint(-75.5F, 2.05F, 20F);
        body[61].rotateAngleZ = -1.17809725F;

        body[62].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[62].setRotationPoint(-75.5F, 2.05F, 20F);
        body[62].rotateAngleZ = -0.78539816F;

        body[63].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[63].setRotationPoint(-75.5F, 2.05F, 20F);
        body[63].rotateAngleZ = -2.74889357F;

        body[64].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[64].setRotationPoint(-75.5F, 2.05F, 20F);
        body[64].rotateAngleZ = -2.35619449F;

        body[65].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[65].setRotationPoint(-75.5F, 2.05F, 20F);
        body[65].rotateAngleZ = -1.96349541F;

        body[66].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[66].setRotationPoint(-75.5F, 2.05F, 20F);
        body[66].rotateAngleZ = -1.57079633F;

        body[67].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[67].setRotationPoint(-75.5F, 2.05F, 20F);
        body[67].rotateAngleZ = -5.89048623F;

        body[68].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[68].setRotationPoint(-75.5F, 2.05F, 20F);
        body[68].rotateAngleZ = -5.49778714F;

        body[69].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[69].setRotationPoint(-75.5F, 2.05F, 20F);
        body[69].rotateAngleZ = -5.10508806F;

        body[70].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[70].setRotationPoint(-75.5F, 2.05F, 20F);
        body[70].rotateAngleZ = -4.71238898F;

        body[71].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[71].setRotationPoint(-75.5F, 2.05F, 20F);
        body[71].rotateAngleZ = -4.3196899F;

        body[72].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[72].setRotationPoint(-75.5F, 2.05F, 20F);
        body[72].rotateAngleZ = -3.92699082F;

        body[73].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[73].setRotationPoint(-75.5F, 2.05F, 20F);
        body[73].rotateAngleZ = -3.53429174F;

        body[74].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[74].setRotationPoint(-75.5F, 2.05F, 20F);
        body[74].rotateAngleZ = -3.14159265F;

        body[75].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[75].setRotationPoint(-75.5F, 2.05F, 20F);

        body[76].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[76].setRotationPoint(-75.5F, 2.05F, 20F);
        body[76].rotateAngleZ = -0.39269908F;

        body[77].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[77].setRotationPoint(-75.5F, 2.05F, 20F);
        body[77].rotateAngleZ = -1.17809725F;

        body[78].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[78].setRotationPoint(-75.5F, 2.05F, 20F);
        body[78].rotateAngleZ = -0.78539816F;

        body[79].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[79].setRotationPoint(-75.5F, 2.05F, 20F);
        body[79].rotateAngleZ = -2.74889357F;

        body[80].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[80].setRotationPoint(-75.5F, 2.05F, 20F);
        body[80].rotateAngleZ = -2.35619449F;

        body[81].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[81].setRotationPoint(-75.5F, 2.05F, 20F);
        body[81].rotateAngleZ = -1.96349541F;

        body[82].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[82].setRotationPoint(-75.5F, 2.05F, 20F);
        body[82].rotateAngleZ = -1.57079633F;

        body[83].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[83].setRotationPoint(-75.5F, 2.05F, 20F);
        body[83].rotateAngleZ = -5.89048623F;

        body[84].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[84].setRotationPoint(-75.5F, 2.05F, 20F);
        body[84].rotateAngleZ = -5.10508806F;

        body[85].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[85].setRotationPoint(-75.5F, 2.05F, 20F);
        body[85].rotateAngleZ = -4.71238898F;

        body[86].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[86].setRotationPoint(-75.5F, 2.05F, 20F);
        body[86].rotateAngleZ = -4.3196899F;

        body[87].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[87].setRotationPoint(-75.5F, 2.05F, 20F);
        body[87].rotateAngleZ = -3.92699082F;

        body[88].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[88].setRotationPoint(-75.5F, 2.05F, 20F);
        body[88].rotateAngleZ = -3.53429174F;

        body[89].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[89].setRotationPoint(-75.5F, 2.05F, 20F);
        body[89].rotateAngleZ = -3.14159265F;

        body[90].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[90].setRotationPoint(-75.5F, 2.05F, 20F);
        body[90].rotateAngleZ = -5.49778714F;

        body[91].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 141
        body[91].setRotationPoint(-75.5F, 2.05F, -20F);

        body[92].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 142
        body[92].setRotationPoint(-75.5F, 2.05F, -20F);
        body[92].rotateAngleZ = -0.39269908F;

        body[93].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 143
        body[93].setRotationPoint(-75.5F, 2.05F, -20F);
        body[93].rotateAngleZ = -0.78539816F;

        body[94].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 144
        body[94].setRotationPoint(-75.5F, 2.05F, -20F);
        body[94].rotateAngleZ = -1.17809725F;

        body[95].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 145
        body[95].setRotationPoint(-75.5F, 2.05F, -20F);
        body[95].rotateAngleZ = -1.57079633F;

        body[96].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 146
        body[96].setRotationPoint(-75.5F, 2.05F, -20F);
        body[96].rotateAngleZ = -1.96349541F;

        body[97].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 147
        body[97].setRotationPoint(-75.5F, 2.05F, -20F);
        body[97].rotateAngleZ = -2.35619449F;

        body[98].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 148
        body[98].setRotationPoint(-75.5F, 2.05F, -20F);
        body[98].rotateAngleZ = -2.74889357F;

        body[99].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 149
        body[99].setRotationPoint(-75.5F, 2.05F, -20F);
        body[99].rotateAngleZ = -3.14159265F;

        body[100].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 150
        body[100].setRotationPoint(-75.5F, 2.05F, -20F);
        body[100].rotateAngleZ = -3.53429174F;

        body[101].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 151
        body[101].setRotationPoint(-75.5F, 2.05F, -20F);
        body[101].rotateAngleZ = -3.92699082F;

        body[102].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 152
        body[102].setRotationPoint(-75.5F, 2.05F, -20F);
        body[102].rotateAngleZ = -4.3196899F;

        body[103].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 153
        body[103].setRotationPoint(-75.5F, 2.05F, -20F);
        body[103].rotateAngleZ = -4.71238898F;

        body[104].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 154
        body[104].setRotationPoint(-75.5F, 2.05F, -20F);
        body[104].rotateAngleZ = -5.10508806F;

        body[105].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 155
        body[105].setRotationPoint(-75.5F, 2.05F, -20F);
        body[105].rotateAngleZ = -5.89048623F;

        body[106].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 156
        body[106].setRotationPoint(-75.5F, 2.05F, -20F);
        body[106].rotateAngleZ = -5.49778714F;

        body[107].addShapeBox(-1.5F, -1.5F, -1.5F, 2, 3, 2, 0F, -0.5F, 0.25F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, -0.5F, 0.25F, 0F, -0.5F, 0.25F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, -0.5F, 0.25F, 0F); // Box 157
        body[107].setRotationPoint(-74.5F, 2.05F, -19F);

        body[108].addShapeBox(-0.5F, -1.5F, -1.5F, 2, 3, 2, 0F, 0F, -0.75F, 0F, -0.5F, 0.25F, 0F, -0.5F, 0.25F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, -0.5F, 0.25F, 0F, -0.5F, 0.25F, 0F, 0F, -0.75F, 0F); // Box 158
        body[108].setRotationPoint(-76.5F, 2.05F, -19F);

        body[109].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 159
        body[109].setRotationPoint(-75.5F, 2.05F, -20F);

        body[110].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 160
        body[110].setRotationPoint(-75.5F, 2.05F, -20F);
        body[110].rotateAngleZ = -5.89048623F;

        body[111].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 161
        body[111].setRotationPoint(-75.5F, 2.05F, -20F);
        body[111].rotateAngleZ = -5.49778714F;

        body[112].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 162
        body[112].setRotationPoint(-75.5F, 2.05F, -20F);
        body[112].rotateAngleZ = -5.10508806F;

        body[113].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 163
        body[113].setRotationPoint(-75.5F, 2.05F, -20F);
        body[113].rotateAngleZ = -4.71238898F;

        body[114].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 164
        body[114].setRotationPoint(-75.5F, 2.05F, -20F);
        body[114].rotateAngleZ = -4.3196899F;

        body[115].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 165
        body[115].setRotationPoint(-75.5F, 2.05F, -20F);
        body[115].rotateAngleZ = -3.53429174F;

        body[116].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 166
        body[116].setRotationPoint(-75.5F, 2.05F, -20F);
        body[116].rotateAngleZ = -3.92699082F;

        body[117].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 167
        body[117].setRotationPoint(-75.5F, 2.05F, -20F);
        body[117].rotateAngleZ = -3.14159265F;

        body[118].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 168
        body[118].setRotationPoint(-75.5F, 2.05F, -20F);
        body[118].rotateAngleZ = -2.74889357F;

        body[119].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 169
        body[119].setRotationPoint(-75.5F, 2.05F, -20F);
        body[119].rotateAngleZ = -2.35619449F;

        body[120].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 170
        body[120].setRotationPoint(-75.5F, 2.05F, -20F);
        body[120].rotateAngleZ = -1.96349541F;

        body[121].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 171
        body[121].setRotationPoint(-75.5F, 2.05F, -20F);
        body[121].rotateAngleZ = -1.57079633F;

        body[122].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 172
        body[122].setRotationPoint(-75.5F, 2.05F, -20F);
        body[122].rotateAngleZ = -1.17809725F;

        body[123].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 173
        body[123].setRotationPoint(-75.5F, 2.05F, -20F);
        body[123].rotateAngleZ = -0.78539816F;

        body[124].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 174
        body[124].setRotationPoint(-75.5F, 2.05F, -20F);
        body[124].rotateAngleZ = -0.39269908F;

        body[125].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 175
        body[125].setRotationPoint(-75.5F, 2.05F, -16F);

        body[126].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 176
        body[126].setRotationPoint(-75.5F, 2.05F, -16F);
        body[126].rotateAngleZ = -0.39269908F;

        body[127].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 177
        body[127].setRotationPoint(-75.5F, 2.05F, -16F);
        body[127].rotateAngleZ = -0.78539816F;

        body[128].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 178
        body[128].setRotationPoint(-75.5F, 2.05F, -16F);
        body[128].rotateAngleZ = -1.17809725F;

        body[129].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 179
        body[129].setRotationPoint(-75.5F, 2.05F, -16F);
        body[129].rotateAngleZ = -1.57079633F;

        body[130].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 180
        body[130].setRotationPoint(-75.5F, 2.05F, -16F);
        body[130].rotateAngleZ = -1.96349541F;

        body[131].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 181
        body[131].setRotationPoint(-75.5F, 2.05F, -16F);
        body[131].rotateAngleZ = -2.35619449F;

        body[132].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 182
        body[132].setRotationPoint(-75.5F, 2.05F, -16F);
        body[132].rotateAngleZ = -2.74889357F;

        body[133].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 183
        body[133].setRotationPoint(-75.5F, 2.05F, -16F);
        body[133].rotateAngleZ = -3.14159265F;

        body[134].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 184
        body[134].setRotationPoint(-75.5F, 2.05F, -16F);
        body[134].rotateAngleZ = -3.53429174F;

        body[135].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 185
        body[135].setRotationPoint(-75.5F, 2.05F, -16F);
        body[135].rotateAngleZ = -3.92699082F;

        body[136].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 186
        body[136].setRotationPoint(-75.5F, 2.05F, -16F);
        body[136].rotateAngleZ = -4.3196899F;

        body[137].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 187
        body[137].setRotationPoint(-75.5F, 2.05F, -16F);
        body[137].rotateAngleZ = -4.71238898F;

        body[138].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 188
        body[138].setRotationPoint(-75.5F, 2.05F, -16F);
        body[138].rotateAngleZ = -5.10508806F;

        body[139].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 189
        body[139].setRotationPoint(-75.5F, 2.05F, -16F);
        body[139].rotateAngleZ = -5.49778714F;

        body[140].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 190
        body[140].setRotationPoint(-75.5F, 2.05F, -16F);
        body[140].rotateAngleZ = -5.89048623F;

        body[141].addBox(0F, 0F, 0F, 10, 1, 1, 0F); // Box 191
        body[141].setRotationPoint(-81F, -4.7F, -16.5F);

        body[142].addBox(0F, 0F, 0F, 10, 1, 1, 0F); // Box 192
        body[142].setRotationPoint(-81F, -4.7F, 14.5F);

        body[143].addBox(0F, 0F, 0F, 1, 1, 2, 0F); // Box 143
        body[143].setRotationPoint(-105.5F, -1.2F, -14.5F);

        body[144].addBox(0F, 0F, 0F, 1, 1, 2, 0F); // Box 144
        body[144].setRotationPoint(-105.5F, -1.2F, 11.5F);

        body[145].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 145
        body[145].setRotationPoint(-105.5F, -1.2F, 10.5F);

        body[146].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 146
        body[146].setRotationPoint(-105.5F, -1.2F, -12.5F);

        body[147].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 147
        body[147].setRotationPoint(-35F, -3.7F, 4.5F);

        body[148].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 148
        body[148].setRotationPoint(-35F, -3.7F, -6.5F);

        body[149].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 149
        body[149].setRotationPoint(-91F, -2.7F, -11.5F);

        body[150].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 150
        body[150].setRotationPoint(-91F, -2.7F, 9.5F);

        body[151].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 151
        body[151].setRotationPoint(-61F, -2.7F, -11.5F);

        body[152].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 152
        body[152].setRotationPoint(-61F, -2.7F, 9.5F);

        body[153].addBox(0F, 0F, 0F, 42, 1, 1, 0F); // Box 153
        body[153].setRotationPoint(-98F, -3.7F, 9.5F);

        body[154].addBox(0F, 0F, 0F, 42, 1, 1, 0F); // Box 154
        body[154].setRotationPoint(-98F, -3.7F, -11.5F);

        body[155].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 155
        body[155].setRotationPoint(-48F, -2.7F, -6.5F);

        body[156].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 156
        body[156].setRotationPoint(-48F, -2.7F, 4.5F);

        body[157].addBox(0F, 0F, 0F, 1, 1, 2, 0F); // Box 157
        body[157].setRotationPoint(-48F, -3.2F, -6.5F);

        body[158].addBox(0F, 0F, 0F, 1, 1, 2, 0F); // Box 158
        body[158].setRotationPoint(-48F, -3.2F, 3.5F);

        body[159].addBox(0F, 0F, 0F, 1, 1, 3, 0F); // Box 159
        body[159].setRotationPoint(-35F, -4.2F, 2.5F);

        body[160].addBox(0F, 0F, 0F, 1, 1, 3, 0F); // Box 160
        body[160].setRotationPoint(-35F, -4.2F, -6.5F);

        body[161].addBox(0F, 0F, 0F, 1, 1, 2, 0F); // Box 161
        body[161].setRotationPoint(-105F, -3.2F, -6.5F);

        body[162].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 162
        body[162].setRotationPoint(-105F, -2.7F, -6.5F);

        body[163].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 163
        body[163].setRotationPoint(-105F, -2.7F, 5.5F);

        body[164].addBox(0F, 0F, 0F, 1, 1, 2, 0F); // Box 164
        body[164].setRotationPoint(-105F, -3.2F, 4.5F);

        body[165].addBox(0F, 0F, 0F, 1, 1, 2, 0F); // Box 165
        body[165].setRotationPoint(-77F, -3.2F, -5.5F);

        body[166].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 166
        body[166].setRotationPoint(-77F, -2.7F, -5.5F);

        body[167].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 167
        body[167].setRotationPoint(-77F, -2.7F, 3.5F);

        body[168].addBox(0F, 0F, 0F, 1, 1, 2, 0F); // Box 168
        body[168].setRotationPoint(-77F, -3.2F, 2.5F);

        body[169].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 169
        body[169].setRotationPoint(-91F, -2.7F, 3.5F);

        body[170].addBox(0F, 0F, 0F, 1, 1, 2, 0F); // Box 170
        body[170].setRotationPoint(-91F, -3.2F, 2.5F);

        body[171].addBox(0F, 0F, 0F, 1, 1, 2, 0F); // Box 171
        body[171].setRotationPoint(-91F, -3.2F, -5.5F);

        body[172].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 172
        body[172].setRotationPoint(-91F, -2.7F, -5.5F);

        body[173].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 173
        body[173].setRotationPoint(-61F, -2.7F, 3.5F);

        body[174].addBox(0F, 0F, 0F, 1, 1, 2, 0F); // Box 174
        body[174].setRotationPoint(-61F, -3.2F, 2.5F);

        body[175].addBox(0F, 0F, 0F, 1, 1, 2, 0F); // Box 175
        body[175].setRotationPoint(-61F, -3.2F, -5.5F);

        body[176].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 176
        body[176].setRotationPoint(-61F, -2.7F, -5.5F);

        body[177].addBox(0F, 0F, 0F, 1, 1, 2, 0F); // Box 177
        body[177].setRotationPoint(-19F, -9.2F, -2.5F);

        //translateAll(0F, 0F, 0F);
        flipAll();
    }

}
