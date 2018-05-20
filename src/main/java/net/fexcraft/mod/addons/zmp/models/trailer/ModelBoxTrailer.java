package net.fexcraft.mod.addons.zmp.models.trailer;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.vehicle.VehicleModel;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelBoxTrailer extends VehicleModel<VehicleData> {

    int textureX = 512;
    int textureY = 512;

    public ModelBoxTrailer(){
        this.creators.add("zackyboy18");
        body = new ModelRendererTurbo[198];
        body[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 298
        body[1] = new ModelRendererTurbo(this, 9, 1, textureX, textureY); // Box 299
        body[2] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 300
        body[3] = new ModelRendererTurbo(this, 57, 1, textureX, textureY); // Box 307
        body[4] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 308
        body[5] = new ModelRendererTurbo(this, 73, 1, textureX, textureY); // Box 309
        body[6] = new ModelRendererTurbo(this, 89, 1, textureX, textureY); // Box 310
        body[7] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 311
        body[8] = new ModelRendererTurbo(this, 97, 1, textureX, textureY); // Box 8
        body[9] = new ModelRendererTurbo(this, 49, 1, textureX, textureY); // Box 9
        body[10] = new ModelRendererTurbo(this, 113, 1, textureX, textureY); // Box 173
        body[11] = new ModelRendererTurbo(this, 145, 1, textureX, textureY); // Box 175
        body[12] = new ModelRendererTurbo(this, 177, 1, textureX, textureY); // Box 176
        body[13] = new ModelRendererTurbo(this, 209, 1, textureX, textureY); // Box 178
        body[14] = new ModelRendererTurbo(this, 65, 1, textureX, textureY); // Box 16
        body[15] = new ModelRendererTurbo(this, 225, 1, textureX, textureY); // Box 0
        body[16] = new ModelRendererTurbo(this, 369, 1, textureX, textureY); // Box 1
        body[17] = new ModelRendererTurbo(this, 225, 9, textureX, textureY); // Box 2
        body[18] = new ModelRendererTurbo(this, 9, 1, textureX, textureY); // Box 3
        body[19] = new ModelRendererTurbo(this, 73, 1, textureX, textureY); // Box 4
        body[20] = new ModelRendererTurbo(this, 353, 1, textureX, textureY); // Box 5
        body[21] = new ModelRendererTurbo(this, 441, 1, textureX, textureY); // Box 6
        body[22] = new ModelRendererTurbo(this, 473, 1, textureX, textureY); // Box 7
        body[23] = new ModelRendererTurbo(this, 41, 9, textureX, textureY); // Box 8
        body[24] = new ModelRendererTurbo(this, 113, 1, textureX, textureY); // Box 9
        body[25] = new ModelRendererTurbo(this, 313, 9, textureX, textureY); // Box 10
        body[26] = new ModelRendererTurbo(this, 369, 9, textureX, textureY); // Box 11
        body[27] = new ModelRendererTurbo(this, 457, 1, textureX, textureY); // Box 12
        body[28] = new ModelRendererTurbo(this, 161, 1, textureX, textureY); // Box 13
        body[29] = new ModelRendererTurbo(this, 193, 1, textureX, textureY); // Box 14
        body[30] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 15
        body[31] = new ModelRendererTurbo(this, 73, 17, textureX, textureY); // Box 16
        body[32] = new ModelRendererTurbo(this, 105, 17, textureX, textureY); // Box 17
        body[33] = new ModelRendererTurbo(this, 417, 9, textureX, textureY); // Box 18
        body[34] = new ModelRendererTurbo(this, 145, 17, textureX, textureY); // Box 19
        body[35] = new ModelRendererTurbo(this, 257, 17, textureX, textureY); // Box 20
        body[36] = new ModelRendererTurbo(this, 337, 17, textureX, textureY); // Box 21
        body[37] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 22
        body[38] = new ModelRendererTurbo(this, 129, 1, textureX, textureY); // Box 506
        body[39] = new ModelRendererTurbo(this, 145, 1, textureX, textureY); // Box 506
        body[40] = new ModelRendererTurbo(this, 489, 1, textureX, textureY); // Box 506
        body[41] = new ModelRendererTurbo(this, 57, 9, textureX, textureY); // Box 506
        body[42] = new ModelRendererTurbo(this, 97, 17, textureX, textureY); // Box 506
        body[43] = new ModelRendererTurbo(this, 129, 17, textureX, textureY); // Box 506
        body[44] = new ModelRendererTurbo(this, 145, 17, textureX, textureY); // Box 506
        body[45] = new ModelRendererTurbo(this, 161, 17, textureX, textureY); // Box 506
        body[46] = new ModelRendererTurbo(this, 441, 17, textureX, textureY); // Box 506
        body[47] = new ModelRendererTurbo(this, 457, 17, textureX, textureY); // Box 506
        body[48] = new ModelRendererTurbo(this, 473, 17, textureX, textureY); // Box 506
        body[49] = new ModelRendererTurbo(this, 489, 17, textureX, textureY); // Box 506
        body[50] = new ModelRendererTurbo(this, 1, 25, textureX, textureY); // Box 506
        body[51] = new ModelRendererTurbo(this, 17, 25, textureX, textureY); // Box 506
        body[52] = new ModelRendererTurbo(this, 41, 25, textureX, textureY); // Box 506
        body[53] = new ModelRendererTurbo(this, 57, 25, textureX, textureY); // Box 506
        body[54] = new ModelRendererTurbo(this, 73, 25, textureX, textureY); // Box 506
        body[55] = new ModelRendererTurbo(this, 89, 25, textureX, textureY); // Box 506
        body[56] = new ModelRendererTurbo(this, 1, 9, textureX, textureY); // Box 506
        body[57] = new ModelRendererTurbo(this, 73, 9, textureX, textureY); // Box 506
        body[58] = new ModelRendererTurbo(this, 129, 9, textureX, textureY); // Box 506
        body[59] = new ModelRendererTurbo(this, 145, 9, textureX, textureY); // Box 506
        body[60] = new ModelRendererTurbo(this, 161, 9, textureX, textureY); // Box 506
        body[61] = new ModelRendererTurbo(this, 177, 9, textureX, textureY); // Box 506
        body[62] = new ModelRendererTurbo(this, 193, 9, textureX, textureY); // Box 506
        body[63] = new ModelRendererTurbo(this, 209, 9, textureX, textureY); // Box 506
        body[64] = new ModelRendererTurbo(this, 441, 9, textureX, textureY); // Box 506
        body[65] = new ModelRendererTurbo(this, 457, 9, textureX, textureY); // Box 506
        body[66] = new ModelRendererTurbo(this, 473, 9, textureX, textureY); // Box 506
        body[67] = new ModelRendererTurbo(this, 489, 9, textureX, textureY); // Box 506
        body[68] = new ModelRendererTurbo(this, 41, 17, textureX, textureY); // Box 506
        body[69] = new ModelRendererTurbo(this, 57, 17, textureX, textureY); // Box 506
        body[70] = new ModelRendererTurbo(this, 105, 25, textureX, textureY); // Box 506
        body[71] = new ModelRendererTurbo(this, 121, 25, textureX, textureY); // Box 506
        body[72] = new ModelRendererTurbo(this, 417, 25, textureX, textureY); // Box 506
        body[73] = new ModelRendererTurbo(this, 433, 25, textureX, textureY); // Box 506
        body[74] = new ModelRendererTurbo(this, 449, 25, textureX, textureY); // Box 506
        body[75] = new ModelRendererTurbo(this, 465, 25, textureX, textureY); // Box 506
        body[76] = new ModelRendererTurbo(this, 481, 25, textureX, textureY); // Box 506
        body[77] = new ModelRendererTurbo(this, 497, 25, textureX, textureY); // Box 506
        body[78] = new ModelRendererTurbo(this, 1, 33, textureX, textureY); // Box 506
        body[79] = new ModelRendererTurbo(this, 17, 33, textureX, textureY); // Box 506
        body[80] = new ModelRendererTurbo(this, 41, 33, textureX, textureY); // Box 506
        body[81] = new ModelRendererTurbo(this, 57, 33, textureX, textureY); // Box 506
        body[82] = new ModelRendererTurbo(this, 73, 33, textureX, textureY); // Box 506
        body[83] = new ModelRendererTurbo(this, 89, 33, textureX, textureY); // Box 506
        body[84] = new ModelRendererTurbo(this, 105, 33, textureX, textureY); // Box 506
        body[85] = new ModelRendererTurbo(this, 121, 33, textureX, textureY); // Box 506
        body[86] = new ModelRendererTurbo(this, 137, 33, textureX, textureY); // Box 506
        body[87] = new ModelRendererTurbo(this, 153, 33, textureX, textureY); // Box 506
        body[88] = new ModelRendererTurbo(this, 257, 33, textureX, textureY); // Box 89
        body[89] = new ModelRendererTurbo(this, 273, 33, textureX, textureY); // Box 90
        body[90] = new ModelRendererTurbo(this, 289, 33, textureX, textureY); // Box 91
        body[91] = new ModelRendererTurbo(this, 145, 25, textureX, textureY); // Box 92
        body[92] = new ModelRendererTurbo(this, 161, 25, textureX, textureY); // Box 93
        body[93] = new ModelRendererTurbo(this, 305, 33, textureX, textureY); // Box 94
        body[94] = new ModelRendererTurbo(this, 321, 33, textureX, textureY); // Box 95
        body[95] = new ModelRendererTurbo(this, 337, 33, textureX, textureY); // Box 96
        body[96] = new ModelRendererTurbo(this, 353, 33, textureX, textureY); // Box 97
        body[97] = new ModelRendererTurbo(this, 369, 33, textureX, textureY); // Box 98
        body[98] = new ModelRendererTurbo(this, 385, 33, textureX, textureY); // Box 99
        body[99] = new ModelRendererTurbo(this, 401, 33, textureX, textureY); // Box 100
        body[100] = new ModelRendererTurbo(this, 425, 33, textureX, textureY); // Box 101
        body[101] = new ModelRendererTurbo(this, 441, 33, textureX, textureY); // Box 102
        body[102] = new ModelRendererTurbo(this, 457, 33, textureX, textureY); // Box 103
        body[103] = new ModelRendererTurbo(this, 473, 33, textureX, textureY); // Box 104
        body[104] = new ModelRendererTurbo(this, 489, 33, textureX, textureY); // Box 105
        body[105] = new ModelRendererTurbo(this, 9, 41, textureX, textureY); // Box 106
        body[106] = new ModelRendererTurbo(this, 49, 41, textureX, textureY); // Box 107
        body[107] = new ModelRendererTurbo(this, 65, 41, textureX, textureY); // Box 108
        body[108] = new ModelRendererTurbo(this, 81, 41, textureX, textureY); // Box 109
        body[109] = new ModelRendererTurbo(this, 97, 41, textureX, textureY); // Box 110
        body[110] = new ModelRendererTurbo(this, 113, 41, textureX, textureY); // Box 111
        body[111] = new ModelRendererTurbo(this, 129, 41, textureX, textureY); // Box 112
        body[112] = new ModelRendererTurbo(this, 145, 41, textureX, textureY); // Box 113
        body[113] = new ModelRendererTurbo(this, 161, 41, textureX, textureY); // Box 114
        body[114] = new ModelRendererTurbo(this, 257, 41, textureX, textureY); // Box 115
        body[115] = new ModelRendererTurbo(this, 273, 41, textureX, textureY); // Box 116
        body[116] = new ModelRendererTurbo(this, 289, 41, textureX, textureY); // Box 117
        body[117] = new ModelRendererTurbo(this, 305, 41, textureX, textureY); // Box 118
        body[118] = new ModelRendererTurbo(this, 321, 41, textureX, textureY); // Box 119
        body[119] = new ModelRendererTurbo(this, 337, 41, textureX, textureY); // Box 120
        body[120] = new ModelRendererTurbo(this, 353, 41, textureX, textureY); // Box 121
        body[121] = new ModelRendererTurbo(this, 369, 41, textureX, textureY); // Box 122
        body[122] = new ModelRendererTurbo(this, 385, 41, textureX, textureY); // Box 123
        body[123] = new ModelRendererTurbo(this, 401, 41, textureX, textureY); // Box 124
        body[124] = new ModelRendererTurbo(this, 417, 41, textureX, textureY); // Box 125
        body[125] = new ModelRendererTurbo(this, 433, 41, textureX, textureY); // Box 126
        body[126] = new ModelRendererTurbo(this, 449, 41, textureX, textureY); // Box 127
        body[127] = new ModelRendererTurbo(this, 465, 41, textureX, textureY); // Box 128
        body[128] = new ModelRendererTurbo(this, 481, 41, textureX, textureY); // Box 129
        body[129] = new ModelRendererTurbo(this, 497, 41, textureX, textureY); // Box 130
        body[130] = new ModelRendererTurbo(this, 65, 49, textureX, textureY); // Box 131
        body[131] = new ModelRendererTurbo(this, 81, 49, textureX, textureY); // Box 132
        body[132] = new ModelRendererTurbo(this, 97, 49, textureX, textureY); // Box 133
        body[133] = new ModelRendererTurbo(this, 113, 49, textureX, textureY); // Box 134
        body[134] = new ModelRendererTurbo(this, 129, 49, textureX, textureY); // Box 135
        body[135] = new ModelRendererTurbo(this, 145, 49, textureX, textureY); // Box 136
        body[136] = new ModelRendererTurbo(this, 161, 49, textureX, textureY); // Box 137
        body[137] = new ModelRendererTurbo(this, 177, 49, textureX, textureY); // Box 138
        body[138] = new ModelRendererTurbo(this, 193, 49, textureX, textureY); // Box 141
        body[139] = new ModelRendererTurbo(this, 209, 49, textureX, textureY); // Box 142
        body[140] = new ModelRendererTurbo(this, 225, 49, textureX, textureY); // Box 143
        body[141] = new ModelRendererTurbo(this, 241, 49, textureX, textureY); // Box 144
        body[142] = new ModelRendererTurbo(this, 257, 49, textureX, textureY); // Box 145
        body[143] = new ModelRendererTurbo(this, 273, 49, textureX, textureY); // Box 146
        body[144] = new ModelRendererTurbo(this, 289, 49, textureX, textureY); // Box 147
        body[145] = new ModelRendererTurbo(this, 305, 49, textureX, textureY); // Box 148
        body[146] = new ModelRendererTurbo(this, 321, 49, textureX, textureY); // Box 149
        body[147] = new ModelRendererTurbo(this, 337, 49, textureX, textureY); // Box 150
        body[148] = new ModelRendererTurbo(this, 353, 49, textureX, textureY); // Box 151
        body[149] = new ModelRendererTurbo(this, 369, 49, textureX, textureY); // Box 152
        body[150] = new ModelRendererTurbo(this, 393, 49, textureX, textureY); // Box 153
        body[151] = new ModelRendererTurbo(this, 409, 49, textureX, textureY); // Box 154
        body[152] = new ModelRendererTurbo(this, 425, 49, textureX, textureY); // Box 155
        body[153] = new ModelRendererTurbo(this, 441, 49, textureX, textureY); // Box 156
        body[154] = new ModelRendererTurbo(this, 457, 49, textureX, textureY); // Box 157
        body[155] = new ModelRendererTurbo(this, 473, 49, textureX, textureY); // Box 158
        body[156] = new ModelRendererTurbo(this, 489, 49, textureX, textureY); // Box 159
        body[157] = new ModelRendererTurbo(this, 1, 57, textureX, textureY); // Box 160
        body[158] = new ModelRendererTurbo(this, 17, 57, textureX, textureY); // Box 161
        body[159] = new ModelRendererTurbo(this, 33, 57, textureX, textureY); // Box 162
        body[160] = new ModelRendererTurbo(this, 49, 57, textureX, textureY); // Box 163
        body[161] = new ModelRendererTurbo(this, 73, 57, textureX, textureY); // Box 164
        body[162] = new ModelRendererTurbo(this, 89, 57, textureX, textureY); // Box 165
        body[163] = new ModelRendererTurbo(this, 105, 57, textureX, textureY); // Box 166
        body[164] = new ModelRendererTurbo(this, 121, 57, textureX, textureY); // Box 167
        body[165] = new ModelRendererTurbo(this, 137, 57, textureX, textureY); // Box 168
        body[166] = new ModelRendererTurbo(this, 153, 57, textureX, textureY); // Box 169
        body[167] = new ModelRendererTurbo(this, 169, 57, textureX, textureY); // Box 170
        body[168] = new ModelRendererTurbo(this, 185, 57, textureX, textureY); // Box 171
        body[169] = new ModelRendererTurbo(this, 201, 57, textureX, textureY); // Box 172
        body[170] = new ModelRendererTurbo(this, 217, 57, textureX, textureY); // Box 173
        body[171] = new ModelRendererTurbo(this, 233, 57, textureX, textureY); // Box 174
        body[172] = new ModelRendererTurbo(this, 249, 57, textureX, textureY); // Box 175
        body[173] = new ModelRendererTurbo(this, 265, 57, textureX, textureY); // Box 176
        body[174] = new ModelRendererTurbo(this, 297, 57, textureX, textureY); // Box 177
        body[175] = new ModelRendererTurbo(this, 313, 57, textureX, textureY); // Box 178
        body[176] = new ModelRendererTurbo(this, 329, 57, textureX, textureY); // Box 179
        body[177] = new ModelRendererTurbo(this, 361, 57, textureX, textureY); // Box 180
        body[178] = new ModelRendererTurbo(this, 377, 57, textureX, textureY); // Box 181
        body[179] = new ModelRendererTurbo(this, 401, 57, textureX, textureY); // Box 182
        body[180] = new ModelRendererTurbo(this, 417, 57, textureX, textureY); // Box 183
        body[181] = new ModelRendererTurbo(this, 433, 57, textureX, textureY); // Box 184
        body[182] = new ModelRendererTurbo(this, 449, 57, textureX, textureY); // Box 185
        body[183] = new ModelRendererTurbo(this, 465, 57, textureX, textureY); // Box 186
        body[184] = new ModelRendererTurbo(this, 481, 57, textureX, textureY); // Box 187
        body[185] = new ModelRendererTurbo(this, 497, 57, textureX, textureY); // Box 188
        body[186] = new ModelRendererTurbo(this, 1, 65, textureX, textureY); // Box 189
        body[187] = new ModelRendererTurbo(this, 17, 65, textureX, textureY); // Box 190
        body[188] = new ModelRendererTurbo(this, 505, 1, textureX, textureY); // Box 191
        body[189] = new ModelRendererTurbo(this, 33, 65, textureX, textureY); // Box 192
        body[190] = new ModelRendererTurbo(this, 41, 65, textureX, textureY); // Box 193
        body[191] = new ModelRendererTurbo(this, 49, 65, textureX, textureY); // Box 194
        body[192] = new ModelRendererTurbo(this, 1, 57, textureX, textureY); // Box 195
        body[193] = new ModelRendererTurbo(this, 361, 57, textureX, textureY); // Box 196
        body[194] = new ModelRendererTurbo(this, 81, 1, textureX, textureY); // Box 197
        body[195] = new ModelRendererTurbo(this, 89, 1, textureX, textureY); // Box 198
        body[196] = new ModelRendererTurbo(this, 97, 1, textureX, textureY); // Box 199
        body[197] = new ModelRendererTurbo(this, 161, 1, textureX, textureY); // Box 200

        body[0].addShapeBox(0F, 0F, 0F, 5, 1, 1, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 298
        body[0].setRotationPoint(-45F, 0.5F, -0.5F);

        body[1].addShapeBox(0F, 0F, 0F, 1, 3, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 299
        body[1].setRotationPoint(-46F, -0.5F, -2.5F);

        body[2].addShapeBox(0F, 0F, 0F, 5, 1, 7, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 300
        body[2].setRotationPoint(-51F, 2.5F, -3.5F);

        body[3].addShapeBox(0F, 0F, 0F, 1, 2, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 307
        body[3].setRotationPoint(-52F, 0F, -2.5F);

        body[4].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 308
        body[4].setRotationPoint(-52F, 0F, -3.5F);

        body[5].addShapeBox(0F, 0F, 0F, 1, 1, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F); // Box 309
        body[5].setRotationPoint(-52F, 2F, -2.5F);

        body[6].addShapeBox(0F, 0F, 0F, 1, 1, 5, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 310
        body[6].setRotationPoint(-52F, -1F, -2.5F);

        body[7].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 311
        body[7].setRotationPoint(-52F, 0F, 2.5F);

        body[8].addShapeBox(0F, 0F, 0F, 5, 3, 7, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 8
        body[8].setRotationPoint(-51F, -0.5F, -3.5F);

        body[9].addShapeBox(0F, 0F, 0F, 4, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 9
        body[9].setRotationPoint(-50.5F, 0F, 3.5F);

        body[10].addShapeBox(0F, 0F, 0F, 1, 2, 12, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 173
        body[10].setRotationPoint(-48.5F, 0F, 5.5F);

        body[11].addShapeBox(0F, 0F, 0F, 1, 2, 12, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 175
        body[11].setRotationPoint(-49.5F, 0F, 5.5F);

        body[12].addShapeBox(0F, 0F, 0F, 1, 2, 12, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 176
        body[12].setRotationPoint(-49.5F, 0F, -17.5F);

        body[13].addShapeBox(0F, 0F, 0F, 1, 2, 12, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 178
        body[13].setRotationPoint(-48.5F, 0F, -17.5F);

        body[14].addShapeBox(0F, 0F, 0F, 4, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 16
        body[14].setRotationPoint(-50.5F, 0F, -5.5F);

        body[15].addBox(0F, 0F, 0F, 68, 2, 2, 0F); // Box 0
        body[15].setRotationPoint(-67F, -3.3F, -1F);

        body[16].addBox(0F, 0F, 0F, 39, 1, 1, 0F); // Box 1
        body[16].setRotationPoint(-67F, -3F, -15F);

        body[17].addBox(0F, 0F, 0F, 39, 1, 1, 0F); // Box 2
        body[17].setRotationPoint(-67F, -3F, 14F);

        body[18].addBox(0F, 0F, 0F, 1, 1, 13, 0F); // Box 3
        body[18].setRotationPoint(-55F, -3F, 1F);

        body[19].addBox(0F, 0F, 0F, 1, 1, 13, 0F); // Box 4
        body[19].setRotationPoint(-42F, -3F, 1F);

        body[20].addBox(0F, 0F, 0F, 1, 1, 13, 0F); // Box 5
        body[20].setRotationPoint(-29F, -3F, 1F);

        body[21].addBox(0F, 0F, 0F, 1, 1, 13, 0F); // Box 6
        body[21].setRotationPoint(-29F, -3F, -14F);

        body[22].addBox(0F, 0F, 0F, 1, 1, 13, 0F); // Box 7
        body[22].setRotationPoint(-42F, -3F, -14F);

        body[23].addBox(0F, 0F, 0F, 1, 1, 13, 0F); // Box 8
        body[23].setRotationPoint(-55F, -3F, -14F);

        body[24].addBox(0F, 0F, 0F, 1, 1, 28, 0F); // Box 9
        body[24].setRotationPoint(-67F, -3F, -14F);

        body[25].addShapeBox(0F, 0F, 0F, 24, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, -14F, 0F, 0F, 14F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -14F, 0F, 0F, 14F, 0F, 0F, 0F); // Box 10
        body[25].setRotationPoint(-28F, -3F, -15F);

        body[26].addShapeBox(0F, 0F, 0F, 24, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 14F, 0F, 0F, -14F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 14F, 0F, 0F, -14F, 0F, 0F, 0F); // Box 11
        body[26].setRotationPoint(-28F, -3F, 14F);

        body[27].addBox(0F, 0F, 0F, 8, 1, 6, 0F); // Box 12
        body[27].setRotationPoint(-52.5F, -7F, -21F);

        body[28].addShapeBox(0F, 0F, 0F, 6, 1, 6, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 4F, 0F, 0F, 4F, 0F, 0F, 0F, 0F); // Box 13
        body[28].setRotationPoint(-44.5F, -7F, -21F);

        body[29].addShapeBox(0F, 0F, 0F, 6, 1, 6, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 4F, 0F, 0F, 4F, 0F, 0F, 0F, 0F); // Box 14
        body[29].setRotationPoint(-44.5F, -7F, 15F);

        body[30].addBox(0F, 0F, 0F, 8, 1, 6, 0F); // Box 15
        body[30].setRotationPoint(-52.5F, -7F, 15F);

        body[31].addShapeBox(0F, 0F, 0F, 6, 1, 6, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 4F, 0F); // Box 16
        body[31].setRotationPoint(-58.5F, -7F, -21F);

        body[32].addShapeBox(0F, 0F, 0F, 6, 1, 6, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 4F, 0F); // Box 17
        body[32].setRotationPoint(-58.5F, -7F, 15F);

        body[33].addShapeBox(0F, 0F, 0F, 5, 1, 7, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 18
        body[33].setRotationPoint(-51F, -1.5F, -3.5F);

        body[34].addBox(0F, 0F, 0F, 39, 1, 30, 0F); // Box 19
        body[34].setRotationPoint(-67F, -4F, -15F);

        body[35].addBox(0F, 0F, 0F, 38, 8, 1, 0F); // Box 20
        body[35].setRotationPoint(-67F, -12F, -15F);

        body[36].addBox(0F, 0F, 0F, 38, 8, 1, 0F); // Box 21
        body[36].setRotationPoint(-67F, -12F, 14F);

        body[37].addBox(0F, 0F, 0F, 1, 8, 30, 0F); // Box 22
        body[37].setRotationPoint(-29F, -12F, -15F);

        body[38].addShapeBox(-0.5F, -1.5F, -1.5F, 2, 3, 2, 0F, -0.5F, 0.25F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, -0.5F, 0.25F, 0F, -0.5F, 0.25F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, -0.5F, 0.25F, 0F); // Box 506
        body[38].setRotationPoint(-48.5F, 0.949999999999999F, 18.5F);

        body[39].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[39].setRotationPoint(-48.5F, 0.949999999999999F, 19.5F);

        body[40].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[40].setRotationPoint(-48.5F, 0.949999999999999F, 19.5F);
        body[40].rotateAngleZ = -0.39269908F;

        body[41].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[41].setRotationPoint(-48.5F, 0.949999999999999F, 19.5F);
        body[41].rotateAngleZ = -1.17809725F;

        body[42].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[42].setRotationPoint(-48.5F, 0.949999999999999F, 19.5F);
        body[42].rotateAngleZ = -0.78539816F;

        body[43].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[43].setRotationPoint(-48.5F, 0.949999999999999F, 19.5F);
        body[43].rotateAngleZ = -2.74889357F;

        body[44].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[44].setRotationPoint(-48.5F, 0.949999999999999F, 19.5F);
        body[44].rotateAngleZ = -2.35619449F;

        body[45].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[45].setRotationPoint(-48.5F, 0.949999999999999F, 19.5F);
        body[45].rotateAngleZ = -1.96349541F;

        body[46].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[46].setRotationPoint(-48.5F, 0.949999999999999F, 19.5F);
        body[46].rotateAngleZ = -1.57079633F;

        body[47].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[47].setRotationPoint(-48.5F, 0.949999999999999F, 19.5F);
        body[47].rotateAngleZ = -5.89048623F;

        body[48].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[48].setRotationPoint(-48.5F, 0.949999999999999F, 19.5F);
        body[48].rotateAngleZ = -5.49778714F;

        body[49].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[49].setRotationPoint(-48.5F, 0.949999999999999F, 19.5F);
        body[49].rotateAngleZ = -5.10508806F;

        body[50].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[50].setRotationPoint(-48.5F, 0.949999999999999F, 19.5F);
        body[50].rotateAngleZ = -4.71238898F;

        body[51].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[51].setRotationPoint(-48.5F, 0.949999999999999F, 19.5F);
        body[51].rotateAngleZ = -4.3196899F;

        body[52].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[52].setRotationPoint(-48.5F, 0.949999999999999F, 19.5F);
        body[52].rotateAngleZ = -3.92699082F;

        body[53].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[53].setRotationPoint(-48.5F, 0.949999999999999F, 19.5F);
        body[53].rotateAngleZ = -3.53429174F;

        body[54].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[54].setRotationPoint(-48.5F, 0.949999999999999F, 19.5F);
        body[54].rotateAngleZ = -3.14159265F;

        body[55].addShapeBox(-1.5F, -1.5F, -1.5F, 2, 3, 2, 0F, 0F, -0.75F, 0F, -0.5F, 0.25F, 0F, -0.5F, 0.25F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, -0.5F, 0.25F, 0F, -0.5F, 0.25F, 0F, 0F, -0.75F, 0F); // Box 506
        body[55].setRotationPoint(-48.5F, 0.949999999999999F, 18.5F);

        body[56].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[56].setRotationPoint(-48.5F, 0.949999999999999F, 19.5F);

        body[57].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[57].setRotationPoint(-48.5F, 0.949999999999999F, 19.5F);
        body[57].rotateAngleZ = -0.39269908F;

        body[58].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[58].setRotationPoint(-48.5F, 0.949999999999999F, 19.5F);
        body[58].rotateAngleZ = -1.17809725F;

        body[59].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[59].setRotationPoint(-48.5F, 0.949999999999999F, 19.5F);
        body[59].rotateAngleZ = -0.78539816F;

        body[60].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[60].setRotationPoint(-48.5F, 0.949999999999999F, 19.5F);
        body[60].rotateAngleZ = -2.74889357F;

        body[61].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[61].setRotationPoint(-48.5F, 0.949999999999999F, 19.5F);
        body[61].rotateAngleZ = -2.35619449F;

        body[62].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[62].setRotationPoint(-48.5F, 0.949999999999999F, 19.5F);
        body[62].rotateAngleZ = -1.96349541F;

        body[63].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[63].setRotationPoint(-48.5F, 0.949999999999999F, 19.5F);
        body[63].rotateAngleZ = -1.57079633F;

        body[64].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[64].setRotationPoint(-48.5F, 0.949999999999999F, 19.5F);
        body[64].rotateAngleZ = -5.89048623F;

        body[65].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[65].setRotationPoint(-48.5F, 0.949999999999999F, 19.5F);
        body[65].rotateAngleZ = -5.49778714F;

        body[66].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[66].setRotationPoint(-48.5F, 0.949999999999999F, 19.5F);
        body[66].rotateAngleZ = -5.10508806F;

        body[67].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[67].setRotationPoint(-48.5F, 0.949999999999999F, 19.5F);
        body[67].rotateAngleZ = -4.71238898F;

        body[68].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[68].setRotationPoint(-48.5F, 0.949999999999999F, 19.5F);
        body[68].rotateAngleZ = -4.3196899F;

        body[69].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[69].setRotationPoint(-48.5F, 0.949999999999999F, 19.5F);
        body[69].rotateAngleZ = -3.92699082F;

        body[70].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[70].setRotationPoint(-48.5F, 0.949999999999999F, 19.5F);
        body[70].rotateAngleZ = -3.53429174F;

        body[71].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[71].setRotationPoint(-48.5F, 0.949999999999999F, 19.5F);
        body[71].rotateAngleZ = -3.14159265F;

        body[72].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[72].setRotationPoint(-48.5F, 0.949999999999999F, 19.5F);

        body[73].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[73].setRotationPoint(-48.5F, 0.949999999999999F, 19.5F);
        body[73].rotateAngleZ = -0.39269908F;

        body[74].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[74].setRotationPoint(-48.5F, 0.949999999999999F, 19.5F);
        body[74].rotateAngleZ = -1.17809725F;

        body[75].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[75].setRotationPoint(-48.5F, 0.949999999999999F, 19.5F);
        body[75].rotateAngleZ = -0.78539816F;

        body[76].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[76].setRotationPoint(-48.5F, 0.949999999999999F, 19.5F);
        body[76].rotateAngleZ = -2.74889357F;

        body[77].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[77].setRotationPoint(-48.5F, 0.949999999999999F, 19.5F);
        body[77].rotateAngleZ = -2.35619449F;

        body[78].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[78].setRotationPoint(-48.5F, 0.949999999999999F, 19.5F);
        body[78].rotateAngleZ = -1.96349541F;

        body[79].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[79].setRotationPoint(-48.5F, 0.949999999999999F, 19.5F);
        body[79].rotateAngleZ = -1.57079633F;

        body[80].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[80].setRotationPoint(-48.5F, 0.949999999999999F, 19.5F);
        body[80].rotateAngleZ = -5.89048623F;

        body[81].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[81].setRotationPoint(-48.5F, 0.949999999999999F, 19.5F);
        body[81].rotateAngleZ = -5.49778714F;

        body[82].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[82].setRotationPoint(-48.5F, 0.949999999999999F, 19.5F);
        body[82].rotateAngleZ = -5.10508806F;

        body[83].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[83].setRotationPoint(-48.5F, 0.949999999999999F, 19.5F);
        body[83].rotateAngleZ = -4.71238898F;

        body[84].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[84].setRotationPoint(-48.5F, 0.949999999999999F, 19.5F);
        body[84].rotateAngleZ = -4.3196899F;

        body[85].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[85].setRotationPoint(-48.5F, 0.949999999999999F, 19.5F);
        body[85].rotateAngleZ = -3.92699082F;

        body[86].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[86].setRotationPoint(-48.5F, 0.949999999999999F, 19.5F);
        body[86].rotateAngleZ = -3.53429174F;

        body[87].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[87].setRotationPoint(-48.5F, 0.949999999999999F, 19.5F);
        body[87].rotateAngleZ = -3.14159265F;

        body[88].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 89
        body[88].setRotationPoint(-48.5F, 0.949999999999999F, -18.5F);
        body[88].rotateAngleZ = -5.49778714F;

        body[89].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 90
        body[89].setRotationPoint(-48.5F, 0.949999999999999F, -18.5F);

        body[90].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 91
        body[90].setRotationPoint(-48.5F, 0.949999999999999F, -18.5F);
        body[90].rotateAngleZ = -5.89048623F;

        body[91].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 92
        body[91].setRotationPoint(-48.5F, 0.949999999999999F, -18.5F);
        body[91].rotateAngleZ = -5.89048623F;

        body[92].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 93
        body[92].setRotationPoint(-48.5F, 0.949999999999999F, -18.5F);
        body[92].rotateAngleZ = -5.49778714F;

        body[93].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 94
        body[93].setRotationPoint(-48.5F, 0.949999999999999F, -18.5F);
        body[93].rotateAngleZ = -5.10508806F;

        body[94].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 95
        body[94].setRotationPoint(-48.5F, 0.949999999999999F, -18.5F);
        body[94].rotateAngleZ = -5.10508806F;

        body[95].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 96
        body[95].setRotationPoint(-48.5F, 0.949999999999999F, -18.5F);
        body[95].rotateAngleZ = -4.71238898F;

        body[96].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 97
        body[96].setRotationPoint(-48.5F, 0.949999999999999F, -18.5F);
        body[96].rotateAngleZ = -4.71238898F;

        body[97].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 98
        body[97].setRotationPoint(-48.5F, 0.949999999999999F, -18.5F);
        body[97].rotateAngleZ = -4.3196899F;

        body[98].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 99
        body[98].setRotationPoint(-48.5F, 0.949999999999999F, -18.5F);
        body[98].rotateAngleZ = -4.3196899F;

        body[99].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 100
        body[99].setRotationPoint(-48.5F, 0.949999999999999F, -18.5F);
        body[99].rotateAngleZ = -3.92699082F;

        body[100].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 101
        body[100].setRotationPoint(-48.5F, 0.949999999999999F, -18.5F);
        body[100].rotateAngleZ = -3.92699082F;

        body[101].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 102
        body[101].setRotationPoint(-48.5F, 0.949999999999999F, -18.5F);
        body[101].rotateAngleZ = -3.53429174F;

        body[102].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 103
        body[102].setRotationPoint(-48.5F, 0.949999999999999F, -18.5F);
        body[102].rotateAngleZ = -3.53429174F;

        body[103].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 104
        body[103].setRotationPoint(-48.5F, 0.949999999999999F, -18.5F);
        body[103].rotateAngleZ = -3.14159265F;

        body[104].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 105
        body[104].setRotationPoint(-48.5F, 0.949999999999999F, -18.5F);
        body[104].rotateAngleZ = -3.14159265F;

        body[105].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 106
        body[105].setRotationPoint(-48.5F, 0.949999999999999F, -18.5F);
        body[105].rotateAngleZ = -2.74889357F;

        body[106].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 107
        body[106].setRotationPoint(-48.5F, 0.949999999999999F, -18.5F);
        body[106].rotateAngleZ = -2.35619449F;

        body[107].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 108
        body[107].setRotationPoint(-48.5F, 0.949999999999999F, -18.5F);
        body[107].rotateAngleZ = -2.74889357F;

        body[108].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 109
        body[108].setRotationPoint(-48.5F, 0.949999999999999F, -18.5F);
        body[108].rotateAngleZ = -2.35619449F;

        body[109].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 110
        body[109].setRotationPoint(-48.5F, 0.949999999999999F, -18.5F);
        body[109].rotateAngleZ = -1.96349541F;

        body[110].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 111
        body[110].setRotationPoint(-48.5F, 0.949999999999999F, -18.5F);
        body[110].rotateAngleZ = -1.96349541F;

        body[111].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 112
        body[111].setRotationPoint(-48.5F, 0.949999999999999F, -18.5F);
        body[111].rotateAngleZ = -1.57079633F;

        body[112].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 113
        body[112].setRotationPoint(-48.5F, 0.949999999999999F, -18.5F);
        body[112].rotateAngleZ = -0.78539816F;

        body[113].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 114
        body[113].setRotationPoint(-48.5F, 0.949999999999999F, -18.5F);
        body[113].rotateAngleZ = -0.39269908F;

        body[114].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 115
        body[114].setRotationPoint(-48.5F, 0.949999999999999F, -18.5F);
        body[114].rotateAngleZ = -1.17809725F;

        body[115].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 116
        body[115].setRotationPoint(-48.5F, 0.949999999999999F, -18.5F);

        body[116].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 117
        body[116].setRotationPoint(-48.5F, 0.949999999999999F, -18.5F);
        body[116].rotateAngleZ = -0.78539816F;

        body[117].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 118
        body[117].setRotationPoint(-48.5F, 0.949999999999999F, -18.5F);
        body[117].rotateAngleZ = -0.39269908F;

        body[118].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 119
        body[118].setRotationPoint(-48.5F, 0.949999999999999F, -18.5F);
        body[118].rotateAngleZ = -1.17809725F;

        body[119].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 120
        body[119].setRotationPoint(-48.5F, 0.949999999999999F, -18.5F);
        body[119].rotateAngleZ = -1.57079633F;

        body[120].addShapeBox(-0.5F, -1.5F, -1.5F, 2, 3, 2, 0F, -0.5F, 0.25F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, -0.5F, 0.25F, 0F, -0.5F, 0.25F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, -0.5F, 0.25F, 0F); // Box 121
        body[120].setRotationPoint(-48.5F, 0.949999999999999F, -17.5F);

        body[121].addShapeBox(-1.5F, -1.5F, -1.5F, 2, 3, 2, 0F, 0F, -0.75F, 0F, -0.5F, 0.25F, 0F, -0.5F, 0.25F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, -0.5F, 0.25F, 0F, -0.5F, 0.25F, 0F, 0F, -0.75F, 0F); // Box 122
        body[121].setRotationPoint(-48.5F, 0.949999999999999F, -17.5F);

        body[122].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 123
        body[122].setRotationPoint(-48.5F, 0.949999999999999F, -14.5F);

        body[123].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 124
        body[123].setRotationPoint(-48.5F, 0.949999999999999F, -14.5F);
        body[123].rotateAngleZ = -0.39269908F;

        body[124].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 125
        body[124].setRotationPoint(-48.5F, 0.949999999999999F, -14.5F);
        body[124].rotateAngleZ = -0.78539816F;

        body[125].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 126
        body[125].setRotationPoint(-48.5F, 0.949999999999999F, -14.5F);
        body[125].rotateAngleZ = -1.17809725F;

        body[126].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 127
        body[126].setRotationPoint(-48.5F, 0.949999999999999F, -14.5F);
        body[126].rotateAngleZ = -1.57079633F;

        body[127].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 128
        body[127].setRotationPoint(-48.5F, 0.949999999999999F, -14.5F);
        body[127].rotateAngleZ = -1.96349541F;

        body[128].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 129
        body[128].setRotationPoint(-48.5F, 0.949999999999999F, -14.5F);
        body[128].rotateAngleZ = -2.35619449F;

        body[129].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 130
        body[129].setRotationPoint(-48.5F, 0.949999999999999F, -14.5F);
        body[129].rotateAngleZ = -2.74889357F;

        body[130].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 131
        body[130].setRotationPoint(-48.5F, 0.949999999999999F, -14.5F);
        body[130].rotateAngleZ = -3.14159265F;

        body[131].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 132
        body[131].setRotationPoint(-48.5F, 0.949999999999999F, -14.5F);
        body[131].rotateAngleZ = -3.53429174F;

        body[132].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 133
        body[132].setRotationPoint(-48.5F, 0.949999999999999F, -14.5F);
        body[132].rotateAngleZ = -5.89048623F;

        body[133].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 134
        body[133].setRotationPoint(-48.5F, 0.949999999999999F, -14.5F);
        body[133].rotateAngleZ = -5.49778714F;

        body[134].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 135
        body[134].setRotationPoint(-48.5F, 0.949999999999999F, -14.5F);
        body[134].rotateAngleZ = -5.10508806F;

        body[135].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 136
        body[135].setRotationPoint(-48.5F, 0.949999999999999F, -14.5F);
        body[135].rotateAngleZ = -4.71238898F;

        body[136].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 137
        body[136].setRotationPoint(-48.5F, 0.949999999999999F, -14.5F);
        body[136].rotateAngleZ = -4.3196899F;

        body[137].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 138
        body[137].setRotationPoint(-48.5F, 0.949999999999999F, -14.5F);
        body[137].rotateAngleZ = -3.92699082F;

        body[138].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 141
        body[138].setRotationPoint(-24.5F, -10.05F, 0F);
        body[138].rotateAngleY = -1.55334303F;
        body[138].rotateAngleZ = -1.58824962F;

        body[139].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 142
        body[139].setRotationPoint(-24.5F, -10.05F, 0F);
        body[139].rotateAngleY = -1.55334303F;
        body[139].rotateAngleZ = -1.9809487F;

        body[140].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 143
        body[140].setRotationPoint(-24.5F, -10.05F, 0F);
        body[140].rotateAngleY = -1.55334303F;
        body[140].rotateAngleZ = -2.37364778F;

        body[141].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 144
        body[141].setRotationPoint(-24.5F, -10.05F, 0F);
        body[141].rotateAngleY = -1.55334303F;
        body[141].rotateAngleZ = -2.76634686F;

        body[142].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 145
        body[142].setRotationPoint(-24.5F, -10.05F, 0F);
        body[142].rotateAngleY = -1.55334303F;
        body[142].rotateAngleZ = -4.72984227F;

        body[143].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 146
        body[143].setRotationPoint(-24.5F, -10.05F, 0F);
        body[143].rotateAngleY = -1.55334303F;
        body[143].rotateAngleZ = -4.33714319F;

        body[144].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 147
        body[144].setRotationPoint(-24.5F, -10.05F, 0F);
        body[144].rotateAngleY = -1.55334303F;
        body[144].rotateAngleZ = -3.94444411F;

        body[145].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 148
        body[145].setRotationPoint(-24.5F, -10.05F, 0F);
        body[145].rotateAngleY = -1.55334303F;
        body[145].rotateAngleZ = -3.55174503F;

        body[146].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 149
        body[146].setRotationPoint(-24.5F, -10.05F, 0F);
        body[146].rotateAngleY = -1.55334303F;
        body[146].rotateAngleZ = -3.15904595F;

        body[147].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 150
        body[147].setRotationPoint(-24.5F, -10.05F, 0F);
        body[147].rotateAngleY = -1.55334303F;
        body[147].rotateAngleZ = -5.51524044F;

        body[148].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 151
        body[148].setRotationPoint(-24.5F, -10.05F, 0F);
        body[148].rotateAngleY = -1.55334303F;
        body[148].rotateAngleZ = -5.12254135F;

        body[149].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 152
        body[149].setRotationPoint(-24.5F, -10.05F, 0F);
        body[149].rotateAngleY = -1.55334303F;
        body[149].rotateAngleZ = -5.90793952F;

        body[150].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 153
        body[150].setRotationPoint(-24.5F, -10.05F, 0F);
        body[150].rotateAngleY = -1.55334303F;
        body[150].rotateAngleZ = -0.01745329F;

        body[151].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 154
        body[151].setRotationPoint(-24.5F, -10.05F, 0F);
        body[151].rotateAngleY = -1.55334303F;
        body[151].rotateAngleZ = -0.41015237F;

        body[152].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 155
        body[152].setRotationPoint(-24.5F, -10.05F, 0F);
        body[152].rotateAngleY = -1.55334303F;
        body[152].rotateAngleZ = -0.80285146F;

        body[153].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 156
        body[153].setRotationPoint(-24.5F, -10.05F, 0F);
        body[153].rotateAngleY = -1.55334303F;
        body[153].rotateAngleZ = -1.19555054F;

        body[154].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 157
        body[154].setRotationPoint(-24.5F, -10.05F, 0F);
        body[154].rotateAngleY = -1.55334303F;
        body[154].rotateAngleZ = -1.19555054F;

        body[155].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 158
        body[155].setRotationPoint(-24.5F, -10.05F, 0F);
        body[155].rotateAngleY = -1.55334303F;
        body[155].rotateAngleZ = -0.80285146F;

        body[156].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 159
        body[156].setRotationPoint(-24.5F, -10.05F, 0F);
        body[156].rotateAngleY = -1.55334303F;
        body[156].rotateAngleZ = -0.41015237F;

        body[157].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 160
        body[157].setRotationPoint(-24.5F, -10.05F, 0F);
        body[157].rotateAngleY = -1.55334303F;
        body[157].rotateAngleZ = -0.01745329F;

        body[158].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 161
        body[158].setRotationPoint(-24.5F, -10.05F, 0F);
        body[158].rotateAngleY = -1.55334303F;
        body[158].rotateAngleZ = -5.90793952F;

        body[159].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 162
        body[159].setRotationPoint(-24.5F, -10.05F, 0F);
        body[159].rotateAngleY = -1.55334303F;
        body[159].rotateAngleZ = -5.51524044F;

        body[160].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 163
        body[160].setRotationPoint(-24.5F, -10.05F, 0F);
        body[160].rotateAngleY = -1.55334303F;
        body[160].rotateAngleZ = -5.12254135F;

        body[161].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 164
        body[161].setRotationPoint(-24.5F, -10.05F, 0F);
        body[161].rotateAngleY = -1.55334303F;
        body[161].rotateAngleZ = -4.72984227F;

        body[162].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 165
        body[162].setRotationPoint(-24.5F, -10.05F, 0F);
        body[162].rotateAngleY = -1.55334303F;
        body[162].rotateAngleZ = -4.33714319F;

        body[163].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 166
        body[163].setRotationPoint(-24.5F, -10.05F, 0F);
        body[163].rotateAngleY = -1.55334303F;
        body[163].rotateAngleZ = -3.94444411F;

        body[164].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 167
        body[164].setRotationPoint(-24.5F, -10.05F, 0F);
        body[164].rotateAngleY = -1.55334303F;
        body[164].rotateAngleZ = -3.55174503F;

        body[165].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 168
        body[165].setRotationPoint(-24.5F, -10.05F, 0F);
        body[165].rotateAngleY = -1.55334303F;
        body[165].rotateAngleZ = -3.15904595F;

        body[166].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 169
        body[166].setRotationPoint(-24.5F, -10.05F, 0F);
        body[166].rotateAngleY = -1.55334303F;
        body[166].rotateAngleZ = -2.76634686F;

        body[167].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 170
        body[167].setRotationPoint(-24.5F, -10.05F, 0F);
        body[167].rotateAngleY = -1.55334303F;
        body[167].rotateAngleZ = -1.9809487F;

        body[168].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 171
        body[168].setRotationPoint(-24.5F, -10.05F, 0F);
        body[168].rotateAngleY = -1.55334303F;
        body[168].rotateAngleZ = -1.58824962F;

        body[169].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 172
        body[169].setRotationPoint(-24.5F, -10.05F, 0F);
        body[169].rotateAngleY = -1.55334303F;
        body[169].rotateAngleZ = -2.37364778F;

        body[170].addShapeBox(-1.5F, -1.5F, -1.5F, 2, 3, 2, 0F, 0F, -0.75F, 0F, -0.5F, 0.25F, 0F, -0.5F, 0.25F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, -0.5F, 0.25F, 0F, -0.5F, 0.25F, 0F, 0F, -0.75F, 0F); // Box 173
        body[170].setRotationPoint(-25.5F, -10.05F, 0F);
        body[170].rotateAngleY = -1.55334303F;
        body[170].rotateAngleZ = -0.01745329F;

        body[171].addShapeBox(-0.5F, -1.5F, -1.5F, 2, 3, 2, 0F, -0.5F, 0.25F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, -0.5F, 0.25F, 0F, -0.5F, 0.25F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, -0.5F, 0.25F, 0F); // Box 174
        body[171].setRotationPoint(-25.5F, -10.05F, 0F);
        body[171].rotateAngleY = -1.55334303F;
        body[171].rotateAngleZ = -0.01745329F;

        body[172].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 175
        body[172].setRotationPoint(-24.5F, -10.05F, 0F);
        body[172].rotateAngleY = -1.55334303F;
        body[172].rotateAngleZ = -0.41015237F;

        body[173].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 176
        body[173].setRotationPoint(-24.5F, -10.05F, 0F);
        body[173].rotateAngleY = -1.55334303F;
        body[173].rotateAngleZ = -0.01745329F;

        body[174].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 177
        body[174].setRotationPoint(-24.5F, -10.05F, 0F);
        body[174].rotateAngleY = -1.55334303F;
        body[174].rotateAngleZ = -5.90793952F;

        body[175].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 178
        body[175].setRotationPoint(-24.5F, -10.05F, 0F);
        body[175].rotateAngleY = -1.55334303F;
        body[175].rotateAngleZ = -5.51524044F;

        body[176].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 179
        body[176].setRotationPoint(-24.5F, -10.05F, 0F);
        body[176].rotateAngleY = -1.55334303F;
        body[176].rotateAngleZ = -5.12254135F;

        body[177].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 180
        body[177].setRotationPoint(-24.5F, -10.05F, 0F);
        body[177].rotateAngleY = -1.55334303F;
        body[177].rotateAngleZ = -4.72984227F;

        body[178].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 181
        body[178].setRotationPoint(-24.5F, -10.05F, 0F);
        body[178].rotateAngleY = -1.55334303F;
        body[178].rotateAngleZ = -4.33714319F;

        body[179].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 182
        body[179].setRotationPoint(-24.5F, -10.05F, 0F);
        body[179].rotateAngleY = -1.55334303F;
        body[179].rotateAngleZ = -3.94444411F;

        body[180].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 183
        body[180].setRotationPoint(-24.5F, -10.05F, 0F);
        body[180].rotateAngleY = -1.55334303F;
        body[180].rotateAngleZ = -3.55174503F;

        body[181].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 184
        body[181].setRotationPoint(-24.5F, -10.05F, 0F);
        body[181].rotateAngleY = -1.55334303F;
        body[181].rotateAngleZ = -3.15904595F;

        body[182].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 185
        body[182].setRotationPoint(-24.5F, -10.05F, 0F);
        body[182].rotateAngleY = -1.55334303F;
        body[182].rotateAngleZ = -2.76634686F;

        body[183].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 186
        body[183].setRotationPoint(-24.5F, -10.05F, 0F);
        body[183].rotateAngleY = -1.55334303F;
        body[183].rotateAngleZ = -2.37364778F;

        body[184].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 187
        body[184].setRotationPoint(-24.5F, -10.05F, 0F);
        body[184].rotateAngleY = -1.55334303F;
        body[184].rotateAngleZ = -1.9809487F;

        body[185].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 188
        body[185].setRotationPoint(-24.5F, -10.05F, 0F);
        body[185].rotateAngleY = -1.55334303F;
        body[185].rotateAngleZ = -1.58824962F;

        body[186].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 189
        body[186].setRotationPoint(-24.5F, -10.05F, 0F);
        body[186].rotateAngleY = -1.55334303F;
        body[186].rotateAngleZ = -1.19555054F;

        body[187].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 190
        body[187].setRotationPoint(-24.5F, -10.05F, 0F);
        body[187].rotateAngleY = -1.55334303F;
        body[187].rotateAngleZ = -0.80285146F;

        body[188].addShapeBox(0F, 0F, 0F, 1, 10, 1, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 191
        body[188].setRotationPoint(-29F, -22F, -15F);

        body[189].addShapeBox(0F, 0F, 0F, 1, 10, 1, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 192
        body[189].setRotationPoint(-67F, -22F, -15F);

        body[190].addShapeBox(0F, 0F, 0F, 1, 10, 1, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 193
        body[190].setRotationPoint(-67F, -22F, 14F);

        body[191].addShapeBox(0F, 0F, 0F, 1, 10, 1, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 194
        body[191].setRotationPoint(-29F, -22F, 14F);

        body[192].addShapeBox(0F, 0F, 0F, 1, 1, 26, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 195
        body[192].setRotationPoint(-67F, -23F, -13F);

        body[193].addShapeBox(0F, 0F, 0F, 1, 1, 26, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 196
        body[193].setRotationPoint(-29F, -23F, -13F);

        body[194].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 197
        body[194].setRotationPoint(-29F, -24F, -12F);

        body[195].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 198
        body[195].setRotationPoint(-67F, -24F, -12F);

        body[196].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 199
        body[196].setRotationPoint(-67F, -24F, 11F);

        body[197].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 200
        body[197].setRotationPoint(-29F, -24F, 11F);
        //
        bodyDoorOpen = new ModelRendererTurbo[1];
        bodyDoorOpen[0] = new ModelRendererTurbo(this, 321, 33, textureX, textureY); // Box 140
        bodyDoorOpen[0].addShapeBox(0F, 0F, 0F, 1, 7, 28, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 3F, 0F, 0F); // Box 140
        bodyDoorOpen[0].setRotationPoint(-67F, -4F, -14F);
        //
        bodyDoorClose = new ModelRendererTurbo[1];
        bodyDoorClose[0] = new ModelRendererTurbo(this, 257, 33, textureX, textureY); // Box 139
        bodyDoorClose[0].addBox(0F, 0F, 0F, 1, 7, 28, 0F); // Box 139
        bodyDoorClose[0].setRotationPoint(-67F, -11F, -14F);
        //
        translateAll(0, 2, 0);
        flipAll();
    }

}
