package net.fexcraft.mod.addons.zmp.models.vehicle;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.vehicle.VehicleModel;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelHuonclass extends VehicleModel<VehicleData> {

    private int textureX = 512;
    private int textureY = 512;

    public ModelHuonclass(){
        this.creators.add("zackyboy18");
        body = new ModelRendererTurbo[207];
        body[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
        body[1] = new ModelRendererTurbo(this, 89, 1, textureX, textureY); // Box 1
        body[2] = new ModelRendererTurbo(this, 177, 1, textureX, textureY); // Box 2
        body[3] = new ModelRendererTurbo(this, 273, 1, textureX, textureY); // Box 3
        body[4] = new ModelRendererTurbo(this, 369, 1, textureX, textureY); // Box 4
        body[5] = new ModelRendererTurbo(this, 1, 25, textureX, textureY); // Box 5
        body[6] = new ModelRendererTurbo(this, 441, 1, textureX, textureY); // Box 7
        body[7] = new ModelRendererTurbo(this, 457, 17, textureX, textureY); // Box 8
        body[8] = new ModelRendererTurbo(this, 73, 25, textureX, textureY); // Box 9
        body[9] = new ModelRendererTurbo(this, 145, 25, textureX, textureY); // Box 10
        body[10] = new ModelRendererTurbo(this, 217, 25, textureX, textureY); // Box 11
        body[11] = new ModelRendererTurbo(this, 273, 25, textureX, textureY); // Box 12
        body[12] = new ModelRendererTurbo(this, 441, 17, textureX, textureY); // Box 13
        body[13] = new ModelRendererTurbo(this, 129, 25, textureX, textureY); // Box 14
        body[14] = new ModelRendererTurbo(this, 193, 25, textureX, textureY); // Box 15
        body[15] = new ModelRendererTurbo(this, 297, 25, textureX, textureY); // Box 16
        body[16] = new ModelRendererTurbo(this, 425, 33, textureX, textureY); // Box 21
        body[17] = new ModelRendererTurbo(this, 457, 33, textureX, textureY); // Box 22
        body[18] = new ModelRendererTurbo(this, 73, 41, textureX, textureY); // Box 23
        body[19] = new ModelRendererTurbo(this, 145, 41, textureX, textureY); // Box 24
        body[20] = new ModelRendererTurbo(this, 217, 41, textureX, textureY); // Box 25
        body[21] = new ModelRendererTurbo(this, 257, 41, textureX, textureY); // Box 26
        body[22] = new ModelRendererTurbo(this, 1, 49, textureX, textureY); // Box 27
        body[23] = new ModelRendererTurbo(this, 353, 49, textureX, textureY); // Box 28
        body[24] = new ModelRendererTurbo(this, 393, 49, textureX, textureY); // Box 29
        body[25] = new ModelRendererTurbo(this, 161, 1, textureX, textureY); // Box 30
        body[26] = new ModelRendererTurbo(this, 257, 1, textureX, textureY); // Box 31
        body[27] = new ModelRendererTurbo(this, 89, 1, textureX, textureY); // Box 32
        body[28] = new ModelRendererTurbo(this, 353, 1, textureX, textureY); // Box 33
        body[29] = new ModelRendererTurbo(this, 377, 25, textureX, textureY); // Box 35
        body[30] = new ModelRendererTurbo(this, 297, 41, textureX, textureY); // Box 36
        body[31] = new ModelRendererTurbo(this, 41, 49, textureX, textureY); // Box 37
        body[32] = new ModelRendererTurbo(this, 433, 57, textureX, textureY); // Box 38
        body[33] = new ModelRendererTurbo(this, 465, 57, textureX, textureY); // Box 39
        body[34] = new ModelRendererTurbo(this, 1, 65, textureX, textureY); // Box 40
        body[35] = new ModelRendererTurbo(this, 33, 65, textureX, textureY); // Box 41
        body[36] = new ModelRendererTurbo(this, 65, 65, textureX, textureY); // Box 42
        body[37] = new ModelRendererTurbo(this, 497, 1, textureX, textureY); // Box 43
        body[38] = new ModelRendererTurbo(this, 1, 25, textureX, textureY); // Box 44
        body[39] = new ModelRendererTurbo(this, 353, 25, textureX, textureY); // Box 45
        body[40] = new ModelRendererTurbo(this, 417, 25, textureX, textureY); // Box 46
        body[41] = new ModelRendererTurbo(this, 497, 33, textureX, textureY); // Box 50
        body[42] = new ModelRendererTurbo(this, 97, 65, textureX, textureY); // Box 56
        body[43] = new ModelRendererTurbo(this, 169, 65, textureX, textureY); // Box 57
        body[44] = new ModelRendererTurbo(this, 225, 65, textureX, textureY); // Box 58
        body[45] = new ModelRendererTurbo(this, 281, 65, textureX, textureY); // Box 59
        body[46] = new ModelRendererTurbo(this, 353, 65, textureX, textureY); // Box 62
        body[47] = new ModelRendererTurbo(this, 97, 73, textureX, textureY); // Box 63
        body[48] = new ModelRendererTurbo(this, 153, 73, textureX, textureY); // Box 64
        body[49] = new ModelRendererTurbo(this, 225, 73, textureX, textureY); // Box 65
        body[50] = new ModelRendererTurbo(this, 281, 73, textureX, textureY); // Box 66
        body[51] = new ModelRendererTurbo(this, 337, 73, textureX, textureY); // Box 67
        body[52] = new ModelRendererTurbo(this, 409, 73, textureX, textureY); // Box 68
        body[53] = new ModelRendererTurbo(this, 1, 81, textureX, textureY); // Box 69
        body[54] = new ModelRendererTurbo(this, 57, 81, textureX, textureY); // Box 70
        body[55] = new ModelRendererTurbo(this, 113, 81, textureX, textureY); // Box 71
        body[56] = new ModelRendererTurbo(this, 185, 81, textureX, textureY); // Box 72
        body[57] = new ModelRendererTurbo(this, 241, 81, textureX, textureY); // Box 73
        body[58] = new ModelRendererTurbo(this, 297, 81, textureX, textureY); // Box 74
        body[59] = new ModelRendererTurbo(this, 369, 81, textureX, textureY); // Box 75
        body[60] = new ModelRendererTurbo(this, 425, 81, textureX, textureY); // Box 76
        body[61] = new ModelRendererTurbo(this, 1, 89, textureX, textureY); // Box 77
        body[62] = new ModelRendererTurbo(this, 57, 89, textureX, textureY); // Box 78
        body[63] = new ModelRendererTurbo(this, 129, 89, textureX, textureY); // Box 79
        body[64] = new ModelRendererTurbo(this, 201, 89, textureX, textureY); // Box 80
        body[65] = new ModelRendererTurbo(this, 257, 89, textureX, textureY); // Box 81
        body[66] = new ModelRendererTurbo(this, 73, 9, textureX, textureY); // Box 82
        body[67] = new ModelRendererTurbo(this, 161, 9, textureX, textureY); // Box 85
        body[68] = new ModelRendererTurbo(this, 257, 9, textureX, textureY); // Box 86
        body[69] = new ModelRendererTurbo(this, 353, 9, textureX, textureY); // Box 87
        body[70] = new ModelRendererTurbo(this, 113, 49, textureX, textureY); // Box 88
        body[71] = new ModelRendererTurbo(this, 185, 49, textureX, textureY); // Box 89
        body[72] = new ModelRendererTurbo(this, 465, 73, textureX, textureY); // Box 90
        body[73] = new ModelRendererTurbo(this, 481, 81, textureX, textureY); // Box 91
        body[74] = new ModelRendererTurbo(this, 313, 89, textureX, textureY); // Box 92
        body[75] = new ModelRendererTurbo(this, 345, 89, textureX, textureY); // Box 93
        body[76] = new ModelRendererTurbo(this, 377, 89, textureX, textureY); // Box 94
        body[77] = new ModelRendererTurbo(this, 409, 89, textureX, textureY); // Box 95
        body[78] = new ModelRendererTurbo(this, 441, 89, textureX, textureY); // Box 96
        body[79] = new ModelRendererTurbo(this, 473, 89, textureX, textureY); // Box 97
        body[80] = new ModelRendererTurbo(this, 1, 97, textureX, textureY); // Box 98
        body[81] = new ModelRendererTurbo(this, 33, 97, textureX, textureY); // Box 100
        body[82] = new ModelRendererTurbo(this, 65, 97, textureX, textureY); // Box 101
        body[83] = new ModelRendererTurbo(this, 97, 97, textureX, textureY); // Box 102
        body[84] = new ModelRendererTurbo(this, 129, 97, textureX, textureY); // Box 103
        body[85] = new ModelRendererTurbo(this, 161, 97, textureX, textureY); // Box 104
        body[86] = new ModelRendererTurbo(this, 193, 97, textureX, textureY); // Box 105
        body[87] = new ModelRendererTurbo(this, 225, 97, textureX, textureY); // Box 106
        body[88] = new ModelRendererTurbo(this, 257, 97, textureX, textureY); // Box 107
        body[89] = new ModelRendererTurbo(this, 289, 97, textureX, textureY); // Box 108
        body[90] = new ModelRendererTurbo(this, 321, 97, textureX, textureY); // Box 109
        body[91] = new ModelRendererTurbo(this, 353, 97, textureX, textureY); // Box 111
        body[92] = new ModelRendererTurbo(this, 385, 97, textureX, textureY); // Box 113
        body[93] = new ModelRendererTurbo(this, 417, 97, textureX, textureY); // Box 115
        body[94] = new ModelRendererTurbo(this, 1, 9, textureX, textureY); // Box 117
        body[95] = new ModelRendererTurbo(this, 113, 41, textureX, textureY); // Box 118
        body[96] = new ModelRendererTurbo(this, 457, 41, textureX, textureY); // Box 120
        body[97] = new ModelRendererTurbo(this, 73, 49, textureX, textureY); // Box 123
        body[98] = new ModelRendererTurbo(this, 145, 49, textureX, textureY); // Box 125
        body[99] = new ModelRendererTurbo(this, 257, 41, textureX, textureY); // Box 126
        body[100] = new ModelRendererTurbo(this, 273, 57, textureX, textureY); // Box 127
        body[101] = new ModelRendererTurbo(this, 409, 65, textureX, textureY); // Box 128
        body[102] = new ModelRendererTurbo(this, 297, 57, textureX, textureY); // Box 129
        body[103] = new ModelRendererTurbo(this, 449, 97, textureX, textureY); // Box 130
        body[104] = new ModelRendererTurbo(this, 217, 49, textureX, textureY); // Box 131
        body[105] = new ModelRendererTurbo(this, 385, 49, textureX, textureY); // Box 132
        body[106] = new ModelRendererTurbo(this, 433, 25, textureX, textureY); // Box 133
        body[107] = new ModelRendererTurbo(this, 129, 57, textureX, textureY); // Box 134
        body[108] = new ModelRendererTurbo(this, 201, 57, textureX, textureY); // Box 135
        body[109] = new ModelRendererTurbo(this, 489, 89, textureX, textureY); // Box 136
        body[110] = new ModelRendererTurbo(this, 17, 97, textureX, textureY); // Box 137
        body[111] = new ModelRendererTurbo(this, 497, 57, textureX, textureY); // Box 138
        body[112] = new ModelRendererTurbo(this, 473, 97, textureX, textureY); // Box 139
        body[113] = new ModelRendererTurbo(this, 1, 105, textureX, textureY); // Box 140
        body[114] = new ModelRendererTurbo(this, 41, 105, textureX, textureY); // Box 141
        body[115] = new ModelRendererTurbo(this, 57, 105, textureX, textureY); // Box 142
        body[116] = new ModelRendererTurbo(this, 121, 105, textureX, textureY); // Box 143
        body[117] = new ModelRendererTurbo(this, 185, 105, textureX, textureY); // Box 144
        body[118] = new ModelRendererTurbo(this, 265, 105, textureX, textureY); // Box 145
        body[119] = new ModelRendererTurbo(this, 1, 49, textureX, textureY); // Box 146
        body[120] = new ModelRendererTurbo(this, 345, 105, textureX, textureY); // Box 147
        body[121] = new ModelRendererTurbo(this, 353, 105, textureX, textureY); // Box 148
        body[122] = new ModelRendererTurbo(this, 361, 105, textureX, textureY); // Box 149
        body[123] = new ModelRendererTurbo(this, 369, 105, textureX, textureY); // Box 150
        body[124] = new ModelRendererTurbo(this, 377, 105, textureX, textureY); // Box 151
        body[125] = new ModelRendererTurbo(this, 385, 105, textureX, textureY); // Box 152
        body[126] = new ModelRendererTurbo(this, 393, 105, textureX, textureY); // Box 153
        body[127] = new ModelRendererTurbo(this, 409, 105, textureX, textureY); // Box 154
        body[128] = new ModelRendererTurbo(this, 425, 105, textureX, textureY); // Box 155
        body[129] = new ModelRendererTurbo(this, 433, 105, textureX, textureY); // Box 156
        body[130] = new ModelRendererTurbo(this, 441, 105, textureX, textureY); // Box 157
        body[131] = new ModelRendererTurbo(this, 449, 105, textureX, textureY); // Box 159
        body[132] = new ModelRendererTurbo(this, 457, 105, textureX, textureY); // Box 162
        body[133] = new ModelRendererTurbo(this, 449, 105, textureX, textureY); // Box 163
        body[134] = new ModelRendererTurbo(this, 185, 113, textureX, textureY); // Box 164
        body[135] = new ModelRendererTurbo(this, 193, 113, textureX, textureY); // Box 165
        body[136] = new ModelRendererTurbo(this, 217, 113, textureX, textureY); // Box 166
        body[137] = new ModelRendererTurbo(this, 241, 113, textureX, textureY); // Box 167
        body[138] = new ModelRendererTurbo(this, 249, 113, textureX, textureY); // Box 168
        body[139] = new ModelRendererTurbo(this, 321, 105, textureX, textureY); // Box 169
        body[140] = new ModelRendererTurbo(this, 41, 105, textureX, textureY); // Box 170
        body[141] = new ModelRendererTurbo(this, 361, 105, textureX, textureY); // Box 171
        body[142] = new ModelRendererTurbo(this, 257, 113, textureX, textureY); // Box 172
        body[143] = new ModelRendererTurbo(this, 281, 113, textureX, textureY); // Box 173
        body[144] = new ModelRendererTurbo(this, 185, 1, textureX, textureY); // Box 174
        body[145] = new ModelRendererTurbo(this, 281, 1, textureX, textureY); // Box 175
        body[146] = new ModelRendererTurbo(this, 297, 113, textureX, textureY); // Box 176
        body[147] = new ModelRendererTurbo(this, 57, 121, textureX, textureY); // Box 177
        body[148] = new ModelRendererTurbo(this, 81, 121, textureX, textureY); // Box 178
        body[149] = new ModelRendererTurbo(this, 369, 1, textureX, textureY); // Box 179
        body[150] = new ModelRendererTurbo(this, 321, 113, textureX, textureY); // Box 181
        body[151] = new ModelRendererTurbo(this, 105, 121, textureX, textureY); // Box 183
        body[152] = new ModelRendererTurbo(this, 129, 121, textureX, textureY); // Box 184
        body[153] = new ModelRendererTurbo(this, 81, 129, textureX, textureY); // Box 185
        body[154] = new ModelRendererTurbo(this, 241, 129, textureX, textureY); // Box 186
        body[155] = new ModelRendererTurbo(this, 153, 121, textureX, textureY); // Box 187
        body[156] = new ModelRendererTurbo(this, 377, 121, textureX, textureY); // Box 188
        body[157] = new ModelRendererTurbo(this, 409, 121, textureX, textureY); // Box 189
        body[158] = new ModelRendererTurbo(this, 489, 121, textureX, textureY); // Box 190
        body[159] = new ModelRendererTurbo(this, 1, 129, textureX, textureY); // Box 191
        body[160] = new ModelRendererTurbo(this, 145, 121, textureX, textureY); // Box 192
        body[161] = new ModelRendererTurbo(this, 161, 1, textureX, textureY); // Box 193
        body[162] = new ModelRendererTurbo(this, 257, 1, textureX, textureY); // Box 194
        body[163] = new ModelRendererTurbo(this, 425, 121, textureX, textureY); // Box 195
        body[164] = new ModelRendererTurbo(this, 353, 49, textureX, textureY); // Box 196
        body[165] = new ModelRendererTurbo(this, 177, 121, textureX, textureY); // Box 197
        body[166] = new ModelRendererTurbo(this, 25, 129, textureX, textureY); // Box 198
        body[167] = new ModelRendererTurbo(this, 33, 129, textureX, textureY); // Box 199
        body[168] = new ModelRendererTurbo(this, 41, 129, textureX, textureY); // Box 200
        body[169] = new ModelRendererTurbo(this, 177, 137, textureX, textureY); // Box 202
        body[170] = new ModelRendererTurbo(this, 65, 137, textureX, textureY); // Box 203
        body[171] = new ModelRendererTurbo(this, 41, 145, textureX, textureY); // Box 204
        body[172] = new ModelRendererTurbo(this, 449, 25, textureX, textureY); // Box 205
        body[173] = new ModelRendererTurbo(this, 185, 41, textureX, textureY); // Box 206
        body[174] = new ModelRendererTurbo(this, 441, 41, textureX, textureY); // Box 207
        body[175] = new ModelRendererTurbo(this, 449, 41, textureX, textureY); // Box 208
        body[176] = new ModelRendererTurbo(this, 321, 57, textureX, textureY); // Box 209
        body[177] = new ModelRendererTurbo(this, 497, 73, textureX, textureY); // Box 210
        body[178] = new ModelRendererTurbo(this, 505, 73, textureX, textureY); // Box 211
        body[179] = new ModelRendererTurbo(this, 505, 89, textureX, textureY); // Box 212
        body[180] = new ModelRendererTurbo(this, 193, 113, textureX, textureY); // Box 213
        body[181] = new ModelRendererTurbo(this, 209, 113, textureX, textureY); // Box 214
        body[182] = new ModelRendererTurbo(this, 217, 113, textureX, textureY); // Box 215
        body[183] = new ModelRendererTurbo(this, 233, 113, textureX, textureY); // Box 216
        body[184] = new ModelRendererTurbo(this, 257, 113, textureX, textureY); // Box 217
        body[185] = new ModelRendererTurbo(this, 273, 113, textureX, textureY); // Box 218
        body[186] = new ModelRendererTurbo(this, 281, 113, textureX, textureY); // Box 219
        body[187] = new ModelRendererTurbo(this, 473, 113, textureX, textureY); // Box 220
        body[188] = new ModelRendererTurbo(this, 481, 113, textureX, textureY); // Box 221
        body[189] = new ModelRendererTurbo(this, 1, 121, textureX, textureY); // Box 222
        body[190] = new ModelRendererTurbo(this, 9, 121, textureX, textureY); // Box 223
        body[191] = new ModelRendererTurbo(this, 305, 121, textureX, textureY); // Box 224
        body[192] = new ModelRendererTurbo(this, 313, 121, textureX, textureY); // Box 226
        body[193] = new ModelRendererTurbo(this, 441, 121, textureX, textureY); // Box 227
        body[194] = new ModelRendererTurbo(this, 41, 129, textureX, textureY); // Box 228
        body[195] = new ModelRendererTurbo(this, 57, 129, textureX, textureY); // Box 229
        body[196] = new ModelRendererTurbo(this, 65, 129, textureX, textureY); // Box 230
        body[197] = new ModelRendererTurbo(this, 313, 145, textureX, textureY); // Box 231
        body[198] = new ModelRendererTurbo(this, 57, 49, textureX, textureY); // Box 232
        body[199] = new ModelRendererTurbo(this, 449, 57, textureX, textureY); // Box 233
        body[200] = new ModelRendererTurbo(this, 161, 129, textureX, textureY); // Box 234
        body[201] = new ModelRendererTurbo(this, 185, 129, textureX, textureY); // Box 235
        body[202] = new ModelRendererTurbo(this, 321, 129, textureX, textureY); // Box 236
        body[203] = new ModelRendererTurbo(this, 329, 129, textureX, textureY); // Box 237
        body[204] = new ModelRendererTurbo(this, 337, 129, textureX, textureY); // Box 238
        body[205] = new ModelRendererTurbo(this, 345, 129, textureX, textureY); // Box 239
        body[206] = new ModelRendererTurbo(this, 497, 129, textureX, textureY); // Box 253

        body[0].addBox(0F, 0F, 0F, 25, 1, 17, 0F); // Box 0
        body[0].setRotationPoint(-45F, -2F, 0F);

        body[1].addBox(0F, 0F, 0F, 25, 1, 17, 0F); // Box 1
        body[1].setRotationPoint(-45F, -2F, -17F);

        body[2].addBox(0F, 0F, 0F, 30, 1, 17, 0F); // Box 2
        body[2].setRotationPoint(-20F, -2F, 0F);

        body[3].addBox(0F, 0F, 0F, 30, 1, 17, 0F); // Box 3
        body[3].setRotationPoint(-20F, -2F, -17F);

        body[4].addBox(0F, 0F, 0F, 25, 1, 17, 0F); // Box 4
        body[4].setRotationPoint(10F, -2F, 0F);

        body[5].addBox(0F, 0F, 0F, 25, 1, 17, 0F); // Box 5
        body[5].setRotationPoint(10F, -2F, -17F);

        body[6].addShapeBox(0F, 0F, 0F, 25, 9, 2, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 7
        body[6].setRotationPoint(-45F, -10F, 17F);

        body[7].addShapeBox(0F, 0F, 0F, 25, 9, 2, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 8
        body[7].setRotationPoint(-45F, -10F, -19F);

        body[8].addShapeBox(0F, 0F, 0F, 30, 9, 2, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 9
        body[8].setRotationPoint(-20F, -10F, -19F);

        body[9].addShapeBox(0F, 0F, 0F, 30, 9, 2, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 10
        body[9].setRotationPoint(-20F, -10F, 17F);

        body[10].addShapeBox(0F, 0F, 0F, 25, 9, 2, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 11
        body[10].setRotationPoint(10F, -10F, -19F);

        body[11].addShapeBox(0F, 0F, 0F, 25, 9, 2, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 12
        body[11].setRotationPoint(10F, -10F, 17F);

        body[12].addShapeBox(0F, 0F, 0F, 1, 9, 13, 0F, 2F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 13
        body[12].setRotationPoint(-46F, -10F, -19F);

        body[13].addShapeBox(0F, 0F, 0F, 1, 9, 13, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 2F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 14
        body[13].setRotationPoint(-46F, -10F, 6F);

        body[14].addShapeBox(0F, 0F, 0F, 1, 4, 17, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 15
        body[14].setRotationPoint(-45F, -1F, -17F);

        body[15].addBox(0F, 0F, 0F, 6, 1, 36, 0F); // Box 16
        body[15].setRotationPoint(-52F, -2F, -18F);

        body[16].addBox(0F, 0F, 0F, 1, 9, 12, 0F); // Box 21
        body[16].setRotationPoint(-46F, -10F, -6F);

        body[17].addShapeBox(0F, 0F, 0F, 10, 1, 17, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F); // Box 22
        body[17].setRotationPoint(35F, -2F, 0F);

        body[18].addShapeBox(0F, 0F, 0F, 10, 1, 17, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 23
        body[18].setRotationPoint(35F, -2F, -17F);

        body[19].addShapeBox(0F, 0F, 0F, 10, 1, 15, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F); // Box 24
        body[19].setRotationPoint(45F, -2F, 0F);

        body[20].addShapeBox(0F, 0F, 0F, 10, 1, 15, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 25
        body[20].setRotationPoint(45F, -2F, -15F);

        body[21].addShapeBox(0F, 0F, 0F, 10, 1, 12, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 26
        body[21].setRotationPoint(55F, -2F, -12F);

        body[22].addShapeBox(0F, 0F, 0F, 10, 1, 12, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F); // Box 27
        body[22].setRotationPoint(55F, -2F, 0F);

        body[23].addShapeBox(0F, 0F, 0F, 10, 1, 9, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F); // Box 28
        body[23].setRotationPoint(65F, -2F, 0F);

        body[24].addShapeBox(0F, 0F, 0F, 10, 1, 9, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 29
        body[24].setRotationPoint(65F, -2F, -9F);

        body[25].addShapeBox(0F, 0F, 0F, 5, 1, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F); // Box 30
        body[25].setRotationPoint(75F, -2F, 0F);

        body[26].addShapeBox(0F, 0F, 0F, 5, 1, 6, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 31
        body[26].setRotationPoint(75F, -2F, -6F);

        body[27].addShapeBox(0F, 0F, 0F, 5, 1, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F); // Box 32
        body[27].setRotationPoint(80F, -2F, 0F);

        body[28].addShapeBox(0F, 0F, 0F, 5, 1, 3, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 33
        body[28].setRotationPoint(80F, -2F, -3F);

        body[29].addShapeBox(0F, 0F, 0F, 10, 9, 2, 0F, 0F, 0F, 2F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 3F, 0F, 0F, 0F); // Box 35
        body[29].setRotationPoint(35F, -10F, -19F);

        body[30].addShapeBox(0F, 0F, 0F, 10, 9, 2, 0F, 0F, 0F, -2F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, -3F, 0F, 0F, 0F); // Box 36
        body[30].setRotationPoint(35F, -10F, 17F);

        body[31].addShapeBox(0F, 0F, 0F, 10, 9, 2, 0F, 0F, 0F, -2F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, -3F, 0F, 0F, 0F); // Box 37
        body[31].setRotationPoint(45F, -10F, 14F);

        body[32].addShapeBox(0F, 0F, 0F, 10, 9, 2, 0F, 0F, 0F, 2F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 3F, 0F, 0F, 0F); // Box 38
        body[32].setRotationPoint(45F, -10F, -16F);

        body[33].addShapeBox(0F, 0F, 0F, 10, 9, 2, 0F, 0F, 0F, -2F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, -3F, 0F, 0F, 0F); // Box 39
        body[33].setRotationPoint(55F, -10F, 11F);

        body[34].addShapeBox(0F, 0F, 0F, 10, 9, 2, 0F, 0F, 0F, 2F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 3F, 0F, 0F, 0F); // Box 40
        body[34].setRotationPoint(55F, -10F, -13F);

        body[35].addShapeBox(0F, 0F, 0F, 10, 9, 2, 0F, 0F, 0F, -2F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, -3F, 0F, 0F, 0F); // Box 41
        body[35].setRotationPoint(65F, -10F, 8F);

        body[36].addShapeBox(0F, 0F, 0F, 10, 9, 2, 0F, 0F, 0F, 2F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 3F, 0F, 0F, 0F); // Box 42
        body[36].setRotationPoint(65F, -10F, -10F);

        body[37].addShapeBox(0F, 0F, 0F, 5, 9, 2, 0F, 0F, 0F, 2F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 3F, 0F, 0F, 0F); // Box 43
        body[37].setRotationPoint(75F, -10F, -7F);

        body[38].addShapeBox(0F, 0F, 0F, 5, 9, 2, 0F, 0F, 0F, -2F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, -3F, 0F, 0F, 0F); // Box 44
        body[38].setRotationPoint(75F, -10F, 5F);

        body[39].addShapeBox(0F, 0F, 0F, 5, 9, 2, 0F, 0F, 0F, -2F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, -3F, 0F, 0F, 0F); // Box 45
        body[39].setRotationPoint(80F, -10F, 2F);

        body[40].addShapeBox(0F, 0F, 0F, 5, 9, 2, 0F, 0F, 0F, 2F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 3F, 0F, 0F, 0F); // Box 46
        body[40].setRotationPoint(80F, -10F, -4F);

        body[41].addShapeBox(0F, 0F, 0F, 3, 9, 2, 0F, 0F, 0F, 0F, 2F, 0F, 1F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 1F, -2F, 0F, -3F, 0F, 0F, -2F); // Box 50
        body[41].setRotationPoint(85F, -10F, 1F);

        body[42].addShapeBox(0F, 0F, 0F, 30, 4, 2, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F); // Box 56
        body[42].setRotationPoint(-20F, -1F, -17F);

        body[43].addShapeBox(0F, 0F, 0F, 25, 4, 2, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F); // Box 57
        body[43].setRotationPoint(-45F, -1F, -17F);

        body[44].addShapeBox(0F, 0F, 0F, 25, 4, 2, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F); // Box 58
        body[44].setRotationPoint(10F, -1F, -17F);

        body[45].addShapeBox(0F, 0F, 0F, 30, 4, 2, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F); // Box 59
        body[45].setRotationPoint(-20F, 3F, -14F);

        body[46].addShapeBox(0F, 0F, 0F, 25, 4, 2, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F); // Box 62
        body[46].setRotationPoint(-45F, 3F, -14F);

        body[47].addShapeBox(0F, 0F, 0F, 25, 4, 2, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F); // Box 63
        body[47].setRotationPoint(10F, 3F, -14F);

        body[48].addShapeBox(0F, 0F, 0F, 30, 4, 2, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 64
        body[48].setRotationPoint(-20F, -1F, 15F);

        body[49].addShapeBox(0F, 0F, 0F, 25, 4, 2, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 65
        body[49].setRotationPoint(-45F, -1F, 15F);

        body[50].addShapeBox(0F, 0F, 0F, 25, 4, 2, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 66
        body[50].setRotationPoint(10F, -1F, 15F);

        body[51].addShapeBox(0F, 0F, 0F, 30, 4, 2, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F); // Box 67
        body[51].setRotationPoint(-20F, 3F, 12F);

        body[52].addShapeBox(0F, 0F, 0F, 25, 4, 2, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F); // Box 68
        body[52].setRotationPoint(-45F, 3F, 12F);

        body[53].addShapeBox(0F, 0F, 0F, 25, 4, 2, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F); // Box 69
        body[53].setRotationPoint(10F, 3F, 12F);

        body[54].addShapeBox(0F, 0F, 0F, 25, 3, 2, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, -3F, 0F, 0F, -3F); // Box 70
        body[54].setRotationPoint(-45F, 7F, 8F);

        body[55].addShapeBox(0F, 0F, 0F, 30, 3, 2, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, -3F, 0F, 0F, -3F); // Box 71
        body[55].setRotationPoint(-20F, 7F, 8F);

        body[56].addShapeBox(0F, 0F, 0F, 25, 3, 2, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, -3F, 0F, 0F, -3F); // Box 72
        body[56].setRotationPoint(10F, 7F, 8F);

        body[57].addShapeBox(0F, 0F, 0F, 25, 3, 2, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 3F, 0F, 0F, 3F); // Box 73
        body[57].setRotationPoint(-45F, 7F, -10F);

        body[58].addShapeBox(0F, 0F, 0F, 30, 3, 2, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 3F, 0F, 0F, 3F); // Box 74
        body[58].setRotationPoint(-20F, 7F, -10F);

        body[59].addShapeBox(0F, 0F, 0F, 25, 3, 2, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 3F, 0F, 0F, 3F); // Box 75
        body[59].setRotationPoint(10F, 7F, -10F);

        body[60].addShapeBox(0F, 0F, 0F, 25, 2, 2, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 3F, 0F, 0F, 3F); // Box 76
        body[60].setRotationPoint(-45F, 10F, -5F);

        body[61].addShapeBox(0F, 0F, 0F, 25, 2, 2, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, -3F, 0F, 0F, -3F); // Box 77
        body[61].setRotationPoint(-45F, 10F, 3F);

        body[62].addShapeBox(0F, 0F, 0F, 30, 2, 2, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, -3F, 0F, 0F, -3F); // Box 78
        body[62].setRotationPoint(-20F, 10F, 3F);

        body[63].addShapeBox(0F, 0F, 0F, 30, 2, 2, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 3F, 0F, 0F, 3F); // Box 79
        body[63].setRotationPoint(-20F, 10F, -5F);

        body[64].addShapeBox(0F, 0F, 0F, 25, 2, 2, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, -3F, 0F, 0F, -3F); // Box 80
        body[64].setRotationPoint(10F, 10F, 3F);

        body[65].addShapeBox(0F, 0F, 0F, 25, 2, 2, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 3F, 0F, 0F, 3F); // Box 81
        body[65].setRotationPoint(10F, 10F, -5F);

        body[66].addShapeBox(0F, 0F, 0F, 10, 4, 2, 0F, 0F, 0F, 2F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, -2F, 0F, 0F, -1F, 0F, 0F, -4F, 0F, 0F, 4F, 0F, 0F, 1F); // Box 82
        body[66].setRotationPoint(35F, -1F, -17F);

        body[67].addShapeBox(0F, 0F, 0F, 10, 4, 2, 0F, 0F, 0F, 2F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, -2F, 0F, 0F, -1F, 0F, 0F, -4F, 0F, 0F, 4F, 0F, 0F, 1F); // Box 85
        body[67].setRotationPoint(45F, -1F, -14F);

        body[68].addShapeBox(0F, 0F, 0F, 10, 4, 2, 0F, 0F, 0F, -2F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 2F, 0F, 0F, 1F, 0F, 0F, 4F, 0F, 0F, -4F, 0F, 0F, -1F); // Box 86
        body[68].setRotationPoint(35F, -1F, 15F);

        body[69].addShapeBox(0F, 0F, 0F, 10, 4, 2, 0F, 0F, 0F, -2F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 2F, 0F, 0F, 1F, 0F, 0F, 4F, 0F, 0F, -4F, 0F, 0F, -1F); // Box 87
        body[69].setRotationPoint(45F, -1F, 12F);

        body[70].addShapeBox(0F, 0F, 0F, 10, 4, 2, 0F, 0F, 0F, -2F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 4F, 0F, 0F, -4F, 0F, 0F, -2F); // Box 88
        body[70].setRotationPoint(35F, 3F, 12F);

        body[71].addShapeBox(0F, 0F, 0F, 10, 4, 2, 0F, 0F, 0F, -2F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 2F, 0F, 0F, 1F, 0F, 0F, 4F, 0F, 0F, -4F, 0F, 0F, -1F); // Box 89
        body[71].setRotationPoint(45F, 3F, 9F);

        body[72].addShapeBox(0F, 0F, 0F, 10, 4, 2, 0F, 0F, 0F, 2F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -4F, 0F, 0F, 4F, 0F, 0F, 2F); // Box 90
        body[72].setRotationPoint(35F, 3F, -14F);

        body[73].addShapeBox(0F, 0F, 0F, 10, 4, 2, 0F, 0F, 0F, 2F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, -2F, 0F, 0F, -1F, 0F, 0F, -4F, 0F, 0F, 4F, 0F, 0F, 1F); // Box 91
        body[73].setRotationPoint(45F, 3F, -11F);

        body[74].addShapeBox(0F, 0F, 0F, 10, 3, 2, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, -3F, 0F, 0F, -3F); // Box 92
        body[74].setRotationPoint(35F, 7F, 8F);

        body[75].addShapeBox(0F, 0F, 0F, 10, 3, 2, 0F, 0F, 0F, -2F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 2F, 0F, 0F, 1F, 0F, 0F, 4F, 0F, 0F, -4F, 0F, 0F, -1F); // Box 93
        body[75].setRotationPoint(45F, 7F, 6F);

        body[76].addShapeBox(0F, 0F, 0F, 10, 3, 2, 0F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 3F, 0F, 0F, 3F); // Box 94
        body[76].setRotationPoint(35F, 7F, -10F);

        body[77].addShapeBox(0F, 0F, 0F, 10, 3, 2, 0F, 0F, 0F, 2F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, -2F, 0F, 0F, -1F, 0F, 0F, -4F, 0F, 0F, 4F, 0F, 0F, 1F); // Box 95
        body[77].setRotationPoint(45F, 7F, -8F);

        body[78].addShapeBox(0F, 0F, 0F, 10, 2, 2, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, -3F, 0F, 0F, -3F); // Box 96
        body[78].setRotationPoint(35F, 10F, 3F);

        body[79].addShapeBox(0F, 0F, 0F, 10, 2, 2, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 3F, 0F, 0F, 3F); // Box 97
        body[79].setRotationPoint(35F, 10F, -5F);

        body[80].addShapeBox(0F, 0F, 0F, 10, 2, 2, 0F, 0F, 0F, -2F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 2F, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, -4F, 0F, 0F, -3F); // Box 98
        body[80].setRotationPoint(45F, 10F, 3F);

        body[81].addShapeBox(0F, 0F, 0F, 10, 2, 2, 0F, 0F, 0F, 2F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, -2F, 0F, 0F, -3F, 0F, 0F, -4F, 0F, 0F, 3F, 0F, 0F, 3F); // Box 100
        body[81].setRotationPoint(45F, 10F, -5F);

        body[82].addShapeBox(0F, 0F, 0F, 10, 4, 2, 0F, 0F, 0F, -2F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 2F, 0F, 0F, 1F, 0F, 0F, 4F, 0F, 0F, -4F, 0F, 0F, -1F); // Box 101
        body[82].setRotationPoint(55F, -1F, 9F);

        body[83].addShapeBox(0F, 0F, 0F, 10, 4, 2, 0F, 0F, 0F, -2F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 2F, 0F, 0F, 1F, 0F, 0F, 4F, 0F, 0F, -4F, 0F, 0F, -1F); // Box 102
        body[83].setRotationPoint(55F, 3F, 6F);

        body[84].addShapeBox(0F, 0F, 0F, 10, 3, 2, 0F, 0F, 0F, -2F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 2F, 0F, 0F, 1F, 0F, 0F, 3F, 0F, 0F, -4F, 0F, 0F, -1F); // Box 103
        body[84].setRotationPoint(55F, 7F, 3F);

        body[85].addShapeBox(0F, 0F, 0F, 10, 2, 2, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -1F); // Box 104
        body[85].setRotationPoint(55F, 10F, 0F);

        body[86].addShapeBox(0F, 0F, 0F, 10, 4, 2, 0F, 0F, 0F, 2F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, -2F, 0F, 0F, -1F, 0F, 0F, -4F, 0F, 0F, 4F, 0F, 0F, 1F); // Box 105
        body[86].setRotationPoint(55F, -1F, -11F);

        body[87].addShapeBox(0F, 0F, 0F, 10, 4, 2, 0F, 0F, 0F, 2F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, -2F, 0F, 0F, -1F, 0F, 0F, -4F, 0F, 0F, 4F, 0F, 0F, 1F); // Box 106
        body[87].setRotationPoint(55F, 3F, -8F);

        body[88].addShapeBox(0F, 0F, 0F, 10, 3, 2, 0F, 0F, 0F, 2F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, -2F, 0F, 0F, -1F, 0F, 0F, -4F, 0F, 0F, 3F, 0F, 0F, 1F); // Box 107
        body[88].setRotationPoint(55F, 7F, -5F);

        body[89].addShapeBox(0F, 0F, 0F, 10, 2, 2, 0F, 0F, 0F, 2F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -1F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 108
        body[89].setRotationPoint(55F, 10F, -2F);

        body[90].addShapeBox(0F, 0F, 0F, 10, 4, 2, 0F, 0F, 0F, -2F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 2F, 0F, 0F, 1F, 0F, 0F, 4F, 0F, 0F, -4F, 0F, 0F, -1F); // Box 109
        body[90].setRotationPoint(65F, -1F, 6F);

        body[91].addShapeBox(0F, 0F, 0F, 10, 4, 2, 0F, 0F, 0F, -2F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 2F, 0F, 0F, 1F, 0F, 0F, 3F, 0F, 0F, -4F, 0F, 0F, -1F); // Box 111
        body[91].setRotationPoint(65F, 3F, 3F);

        body[92].addShapeBox(0F, 0F, 0F, 10, 4, 2, 0F, 0F, 0F, 2F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, -2F, 0F, 0F, -1F, 0F, 0F, -4F, 0F, 0F, 4F, 0F, 0F, 1F); // Box 113
        body[92].setRotationPoint(65F, -1F, -8F);

        body[93].addShapeBox(0F, 0F, 0F, 10, 4, 2, 0F, 0F, 0F, 2F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, -2F, 0F, 0F, -1F, 0F, 0F, -4F, 0F, 0F, 3F, 0F, 0F, 1F); // Box 115
        body[93].setRotationPoint(65F, 3F, -5F);

        body[94].addShapeBox(0F, 0F, 0F, 5, 4, 2, 0F, 0F, 0F, -2F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 2F, 0F, 0F, 1F, 0F, 0F, 3F, 0F, 0F, -4F, 0F, 0F, -1F); // Box 117
        body[94].setRotationPoint(75F, -1F, 3F);

        body[95].addShapeBox(0F, 0F, 0F, 5, 4, 2, 0F, 0F, 0F, 2F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, -2F, 0F, 0F, -1F, 0F, 0F, -4F, 0F, 0F, 3F, 0F, 0F, 1F); // Box 118
        body[95].setRotationPoint(75F, -1F, -5F);

        body[96].addShapeBox(0F, 0F, 0F, 5, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 3F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -4F, 0F, 0F, 3F, 0F, 0F, 3F); // Box 120
        body[96].setRotationPoint(75F, 3F, -4F);

        body[97].addShapeBox(0F, 0F, 0F, 5, 4, 1, 0F, 0F, 0F, 0F, 1F, 0F, 3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, -4F, 0F, 0F, -3F); // Box 123
        body[97].setRotationPoint(80F, -1F, 3F);

        body[98].addShapeBox(0F, 0F, 0F, 5, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, -4F, 0F, 0F, -3F); // Box 125
        body[98].setRotationPoint(75F, 3F, 3F);

        body[99].addShapeBox(0F, 0F, 0F, 3, 9, 2, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 2F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, -2F, -2F, 0F, -3F, -2F, 0F, 1F, 0F, 0F, 0F); // Box 126
        body[99].setRotationPoint(85F, -10F, -3F);

        body[100].addShapeBox(0F, 0F, 0F, 10, 3, 1, 0F, 0F, 0F, 2F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -2F, 0F, 0F, 1F, 0F, 0F, 1F); // Box 127
        body[100].setRotationPoint(65F, 7F, -2F);

        body[101].addShapeBox(0F, 0F, 0F, 10, 3, 1, 0F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 2F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -2F, 0F, 0F, -1F); // Box 128
        body[101].setRotationPoint(65F, 7F, 1F);

        body[102].addShapeBox(0F, 0F, 0F, 10, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -2F, -1F, 0F, -2F, 0F, 0F, 0F, 0F); // Box 129
        body[102].setRotationPoint(65F, 10F, -1F);

        body[103].addShapeBox(0F, 0F, 0F, 10, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, -1F, 0F, 0F, -1F); // Box 130
        body[103].setRotationPoint(65F, 10F, 0F);

        body[104].addShapeBox(0F, 0F, 0F, 5, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, -4F, -1F, 0F, 0F, -1F); // Box 131
        body[104].setRotationPoint(80F, 3F, 0F);

        body[105].addShapeBox(0F, 0F, 0F, 5, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -4F, -1F, 0F, -4F, 0F, 0F, 0F, 0F); // Box 132
        body[105].setRotationPoint(80F, 3F, -1F);

        body[106].addShapeBox(0F, 0F, 0F, 5, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -3F, -1F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 133
        body[106].setRotationPoint(75F, 7F, -1F);

        body[107].addShapeBox(0F, 0F, 0F, 5, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, -1F, 0F, 0F, -1F); // Box 134
        body[107].setRotationPoint(75F, 7F, 0F);

        body[108].addShapeBox(0F, 0F, 0F, 5, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 1F, 0F, 3F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -4F, 0F, 0F, 3F, 0F, 0F, 3F); // Box 135
        body[108].setRotationPoint(80F, -1F, -4F);

        body[109].addBox(0F, 0F, 0F, 1, 20, 9, 0F); // Box 136
        body[109].setRotationPoint(-23F, -22F, 6F);

        body[110].addBox(0F, 0F, 0F, 1, 20, 9, 0F); // Box 137
        body[110].setRotationPoint(-23F, -22F, -15F);

        body[111].addShapeBox(0F, 0F, 0F, 5, 10, 1, 0F, 0F, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 138
        body[111].setRotationPoint(-22F, -22F, -15F);

        body[112].addBox(0F, 0F, 0F, 5, 10, 1, 0F); // Box 139
        body[112].setRotationPoint(-22F, -12F, -15F);

        body[113].addBox(0F, 0F, 0F, 5, 10, 1, 0F); // Box 140
        body[113].setRotationPoint(-22F, -12F, 14F);

        body[114].addShapeBox(0F, 0F, 0F, 5, 10, 1, 0F, 0F, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 141
        body[114].setRotationPoint(-22F, -22F, 14F);

        body[115].addBox(0F, 0F, 0F, 30, 10, 1, 0F); // Box 142
        body[115].setRotationPoint(-17F, -12F, -15F);

        body[116].addBox(0F, 0F, 0F, 30, 10, 1, 0F); // Box 143
        body[116].setRotationPoint(-17F, -12F, 14F);

        body[117].addBox(0F, 0F, 0F, 35, 1, 1, 0F); // Box 144
        body[117].setRotationPoint(-15F, -22F, -15F);

        body[118].addBox(0F, 0F, 0F, 35, 1, 1, 0F); // Box 145
        body[118].setRotationPoint(-15F, -22F, 14F);

        body[119].addBox(0F, 0F, 0F, 2, 9, 1, 0F); // Box 146
        body[119].setRotationPoint(-9F, -21F, -15F);

        body[120].addBox(0F, 0F, 0F, 2, 9, 1, 0F); // Box 147
        body[120].setRotationPoint(-9F, -21F, -15F);

        body[121].addBox(0F, 0F, 0F, 2, 9, 1, 0F); // Box 148
        body[121].setRotationPoint(-9F, -21F, 14F);

        body[122].addBox(0F, 0F, 0F, 1, 9, 1, 0F); // Box 149
        body[122].setRotationPoint(-1F, -21F, 14F);

        body[123].addBox(0F, 0F, 0F, 1, 9, 1, 0F); // Box 150
        body[123].setRotationPoint(-1F, -21F, -15F);

        body[124].addBox(0F, 0F, 0F, 1, 9, 1, 0F); // Box 151
        body[124].setRotationPoint(6F, -21F, 14F);

        body[125].addBox(0F, 0F, 0F, 1, 9, 1, 0F); // Box 152
        body[125].setRotationPoint(6F, -21F, -15F);

        body[126].addBox(0F, 0F, 0F, 6, 10, 1, 0F); // Box 153
        body[126].setRotationPoint(19F, -12F, -15F);

        body[127].addBox(0F, 0F, 0F, 6, 10, 1, 0F); // Box 154
        body[127].setRotationPoint(19F, -12F, 14F);

        body[128].addBox(0F, 0F, 0F, 1, 9, 1, 0F); // Box 155
        body[128].setRotationPoint(19F, -21F, -15F);

        body[129].addBox(0F, 0F, 0F, 1, 9, 1, 0F); // Box 156
        body[129].setRotationPoint(19F, -21F, 14F);

        body[130].addShapeBox(0F, 0F, 0F, 1, 9, 1, 0F, -3F, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 157
        body[130].setRotationPoint(26F, -21F, -15F);

        body[131].addShapeBox(0F, 0F, 0F, 1, 9, 1, 0F, -3F, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 159
        body[131].setRotationPoint(26F, -21F, 14F);

        body[132].addShapeBox(0F, 0F, 0F, 1, 9, 1, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 162
        body[132].setRotationPoint(34F, -21F, -7F);

        body[133].addBox(0F, 0F, 0F, 3, 9, 14, 0F); // Box 163
        body[133].setRotationPoint(32F, -12F, -7F);

        body[134].addShapeBox(0F, 0F, 0F, 1, 9, 1, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 164
        body[134].setRotationPoint(34F, -21F, 6F);

        body[135].addShapeBox(0F, 0F, 0F, 3, 9, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 7F, 0F, 0F, -7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 7F, 0F, 0F, -7F, 0F, 0F); // Box 165
        body[135].setRotationPoint(25F, -12F, -15F);

        body[136].addShapeBox(0F, 0F, 0F, 3, 9, 8, 0F, -7F, 0F, 0F, 7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -7F, 0F, 0F, 7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 166
        body[136].setRotationPoint(25F, -12F, 7F);

        body[137].addBox(0F, 0F, 0F, 1, 9, 1, 0F); // Box 167
        body[137].setRotationPoint(12F, -21F, -15F);

        body[138].addBox(0F, 0F, 0F, 1, 9, 1, 0F); // Box 168
        body[138].setRotationPoint(12F, -21F, 14F);

        body[139].addShapeBox(0F, 0F, 0F, 1, 4, 17, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F); // Box 169
        body[139].setRotationPoint(-45F, -1F, 0F);

        body[140].addShapeBox(0F, 0F, 0F, 1, 4, 13, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F); // Box 170
        body[140].setRotationPoint(-45F, 3F, 0F);

        body[141].addShapeBox(0F, 0F, 0F, 1, 4, 13, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 171
        body[141].setRotationPoint(-45F, 3F, -13F);

        body[142].addShapeBox(0F, 0F, 0F, 1, 3, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F); // Box 172
        body[142].setRotationPoint(-45F, 7F, 0F);

        body[143].addShapeBox(0F, 0F, 0F, 1, 3, 8, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 173
        body[143].setRotationPoint(-45F, 7F, -8F);

        body[144].addShapeBox(0F, 0F, 0F, 1, 2, 3, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 174
        body[144].setRotationPoint(-45F, 10F, -3F);

        body[145].addShapeBox(0F, 0F, 0F, 1, 2, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F); // Box 175
        body[145].setRotationPoint(-45F, 10F, 0F);

        body[146].addBox(0F, 0F, 0F, 10, 1, 1, 0F); // Box 176
        body[146].setRotationPoint(20F, -22F, 14F);

        body[147].addBox(0F, 0F, 0F, 1, 1, 14, 0F); // Box 177
        body[147].setRotationPoint(36F, -22F, -7F);

        body[148].addBox(0F, 0F, 0F, 10, 1, 1, 0F); // Box 178
        body[148].setRotationPoint(20F, -22F, -15F);

        body[149].addShapeBox(0F, 0F, 0F, 7, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 7F, 0F, 0F, -7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 7F, 0F, 0F, -7F, 0F, 0F, 0F); // Box 179
        body[149].setRotationPoint(30F, -22F, 14F);

        body[150].addShapeBox(0F, 0F, 0F, 7, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, -7F, 0F, 0F, 7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -7F, 0F, 0F, 7F, 0F, 0F, 0F); // Box 181
        body[150].setRotationPoint(30F, -22F, -15F);

        body[151].addShapeBox(0F, 0F, 0F, 10, 4, 1, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 183
        body[151].setRotationPoint(20F, -26F, -15F);

        body[152].addShapeBox(0F, 0F, 0F, 10, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 184
        body[152].setRotationPoint(20F, -26F, 14F);

        body[153].addShapeBox(0F, 0F, 0F, 35, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 185
        body[153].setRotationPoint(-15F, -26F, 14F);

        body[154].addShapeBox(0F, 0F, 0F, 35, 4, 1, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 186
        body[154].setRotationPoint(-15F, -26F, -15F);

        body[155].addShapeBox(0F, 0F, 0F, 7, 4, 1, 0F, 0F, -2F, 0F, 0F, -2F, -7F, 0F, 0F, 7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -7F, 0F, 0F, 7F, 0F, 0F, 0F); // Box 187
        body[155].setRotationPoint(30F, -26F, -15F);

        body[156].addShapeBox(0F, 0F, 0F, 7, 4, 14, 0F, 0F, 0F, 7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 7F, 0F, 0F, 7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 5F); // Box 188
        body[156].setRotationPoint(30F, -26F, -7F);

        body[157].addShapeBox(0F, 0F, 0F, 7, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 7F, 0F, -2F, -7F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 7F, 0F, 0F, -7F, 0F, 0F, 0F); // Box 189
        body[157].setRotationPoint(30F, -26F, 14F);

        body[158].addShapeBox(0F, 0F, 0F, 7, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 190
        body[158].setRotationPoint(-22F, -26F, 14F);

        body[159].addShapeBox(0F, 0F, 0F, 7, 4, 1, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 191
        body[159].setRotationPoint(-22F, -26F, -15F);

        body[160].addShapeBox(0F, 0F, 0F, 1, 4, 28, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 192
        body[160].setRotationPoint(-23F, -26F, -14F);

        body[161].addShapeBox(0F, 0F, 0F, 1, 4, 1, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 193
        body[161].setRotationPoint(-23F, -26F, -15F);

        body[162].addShapeBox(0F, 0F, 0F, 1, 4, 1, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 194
        body[162].setRotationPoint(-23F, -26F, 14F);

        body[163].addBox(0F, 0F, 0F, 1, 19, 10, 0F); // Box 195
        body[163].setRotationPoint(-23F, -21F, -5F);

        body[164].addBox(0F, 0F, 0F, 1, 1, 3, 0F); // Box 196
        body[164].setRotationPoint(-23.5F, -13F, -5F);

        body[165].addBox(0F, 0F, 0F, 1, 20, 1, 0F); // Box 197
        body[165].setRotationPoint(-23.3F, -22F, -6F);

        body[166].addBox(0F, 0F, 0F, 1, 20, 1, 0F); // Box 198
        body[166].setRotationPoint(-23.3F, -22F, 5F);

        body[167].addBox(0F, 0F, 0F, 1, 20, 1, 0F); // Box 199
        body[167].setRotationPoint(-23.3F, -22F, -6F);

        body[168].addBox(0F, 0F, 0F, 1, 1, 10, 0F); // Box 200
        body[168].setRotationPoint(-23.3F, -22F, -5F);

        body[169].addBox(0F, 0F, 0F, 52, 1, 28, 0F); // Box 202
        body[169].setRotationPoint(-22F, -26F, -14F);

        body[170].addBox(0F, 0F, 0F, 41, 1, 1, 0F); // Box 203
        body[170].setRotationPoint(-45F, -13F, -20F);

        body[171].addBox(0F, 0F, 0F, 41, 1, 1, 0F); // Box 204
        body[171].setRotationPoint(-45F, -13F, 19F);

        body[172].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 205
        body[172].setRotationPoint(-45F, -12F, 19F);

        body[173].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 206
        body[173].setRotationPoint(-41F, -12F, 19F);

        body[174].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 207
        body[174].setRotationPoint(-33F, -12F, 19F);

        body[175].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 208
        body[175].setRotationPoint(-37F, -12F, 19F);

        body[176].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 209
        body[176].setRotationPoint(-21F, -12F, 19F);

        body[177].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 210
        body[177].setRotationPoint(-25F, -12F, 19F);

        body[178].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 211
        body[178].setRotationPoint(-29F, -12F, 19F);

        body[179].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 212
        body[179].setRotationPoint(-45F, -12F, -20F);

        body[180].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 213
        body[180].setRotationPoint(-41F, -12F, -20F);

        body[181].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 214
        body[181].setRotationPoint(-37F, -12F, -20F);

        body[182].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 215
        body[182].setRotationPoint(-33F, -12F, -20F);

        body[183].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 216
        body[183].setRotationPoint(-25F, -12F, -20F);

        body[184].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 217
        body[184].setRotationPoint(-29F, -12F, -20F);

        body[185].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 218
        body[185].setRotationPoint(-21F, -12F, -20F);

        body[186].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 219
        body[186].setRotationPoint(-13F, -12F, -20F);

        body[187].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 220
        body[187].setRotationPoint(-9F, -12F, -20F);

        body[188].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F); // Box 221
        body[188].setRotationPoint(-5F, -12F, -20F);

        body[189].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 222
        body[189].setRotationPoint(-17F, -12F, -20F);

        body[190].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 223
        body[190].setRotationPoint(-13F, -12F, -20F);

        body[191].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 224
        body[191].setRotationPoint(-9F, -12F, -20F);

        body[192].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 226
        body[192].setRotationPoint(-17F, -12F, -20F);

        body[193].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 227
        body[193].setRotationPoint(-13F, -12F, 19F);

        body[194].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 228
        body[194].setRotationPoint(-9F, -12F, 19F);

        body[195].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F); // Box 229
        body[195].setRotationPoint(-5F, -12F, 19F);

        body[196].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 230
        body[196].setRotationPoint(-17F, -12F, 19F);

        body[197].addBox(0F, 0F, 0F, 41, 1, 1, 0F); // Box 231
        body[197].setRotationPoint(-45F, -13F, -20F);

        body[198].addBox(0F, 0F, 0F, 1, 1, 12, 0F); // Box 232
        body[198].setRotationPoint(-46F, -13F, -20F);

        body[199].addBox(0F, 0F, 0F, 1, 1, 12, 0F); // Box 233
        body[199].setRotationPoint(-46F, -13F, 8F);

        body[200].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F); // Box 234
        body[200].setRotationPoint(-46F, -12F, -9F);

        body[201].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F); // Box 235
        body[201].setRotationPoint(-46F, -12F, 8F);

        body[202].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F); // Box 236
        body[202].setRotationPoint(-46F, -12F, 13F);

        body[203].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F); // Box 237
        body[203].setRotationPoint(-46F, -12F, 18F);

        body[204].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F); // Box 238
        body[204].setRotationPoint(-46F, -12F, -14F);

        body[205].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F); // Box 239
        body[205].setRotationPoint(-46F, -12F, -19F);

        body[206].addBox(0F, -2.5F, 0.5F, 1, 2, 1, 0F); // Box 253
        body[206].setRotationPoint(32F, -11F, -1F);


        /*trailerModel = new ModelRendererTurbo[13];
		trailerModel[0] = new ModelRendererTurbo(this, 353, 25, textureX, textureY); // Box 243
		trailerModel[1] = new ModelRendererTurbo(this, 393, 25, textureX, textureY); // Box 18
		trailerModel[2] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 19
		trailerModel[3] = new ModelRendererTurbo(this, 73, 1, textureX, textureY); // Box 20
		trailerModel[4] = new ModelRendererTurbo(this, 449, 137, textureX, textureY); // Box 226
		trailerModel[5] = new ModelRendererTurbo(this, 1, 137, textureX, textureY); // Box 228
		trailerModel[6] = new ModelRendererTurbo(this, 393, 145, textureX, textureY); // Box 256
		trailerModel[7] = new ModelRendererTurbo(this, 489, 137, textureX, textureY); // Box 257
		trailerModel[8] = new ModelRendererTurbo(this, 17, 153, textureX, textureY); // Box 258
		trailerModel[9] = new ModelRendererTurbo(this, 121, 145, textureX, textureY); // Box 259
		trailerModel[10] = new ModelRendererTurbo(this, 57, 153, textureX, textureY); // Box 260
		trailerModel[11] = new ModelRendererTurbo(this, 313, 153, textureX, textureY); // Box 261
		trailerModel[12] = new ModelRendererTurbo(this, 353, 153, textureX, textureY); // Box 262

		trailerModel[0].addShapeBox(0F, 0F, 0F, 1, 1, 18, 0F, 0F, -0.2F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -1F, 0F, -0.2F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -1F); // Box 243
		trailerModel[0].setRotationPoint(-53F, -2F, 0F);

		trailerModel[1].addShapeBox(0F, 0F, 0F, 1, 1, 18, 0F, 0F, -0.2F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -1F, 0F, -0.2F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -1F); // Box 18
		trailerModel[1].setRotationPoint(-53F, -2F, -18F);

		trailerModel[2].addShapeBox(0F, 0F, 0F, 7, 1, 1, 0F, -1F, -0.2F, 0F, -1F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -0.2F, 0F, -1F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 19
		trailerModel[2].setRotationPoint(-52F, -2F, -19F);

		trailerModel[3].addShapeBox(0F, 0F, 0F, 7, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -0.2F, 0F, -1F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -0.2F, 0F, -1F, -0.2F, 0F); // Box 20
		trailerModel[3].setRotationPoint(-52F, -2F, 18F);

		trailerModel[4].addBox(0F, 0F, 0F, 10, 2, 8, 0F); // Box 226
		trailerModel[4].setRotationPoint(-20F, -7F, 4F);

		trailerModel[5].addBox(0F, 0F, 0F, 2, 10, 8, 0F); // Box 228
		trailerModel[5].setRotationPoint(-21F, -16.5F, 4F);
		trailerModel[5].rotateAngleZ = 0.06981317F;

		trailerModel[6].addBox(0F, 0F, 0F, 10, 2, 8, 0F); // Box 256
		trailerModel[6].setRotationPoint(-4F, -7F, 4F);

		trailerModel[7].addBox(0F, 0F, 0F, 2, 10, 8, 0F); // Box 257
		trailerModel[7].setRotationPoint(-5F, -16.5F, 4F);
		trailerModel[7].rotateAngleZ = 0.06981317F;

		trailerModel[8].addBox(0F, 0F, 0F, 8, 2, 8, 0F); // Box 258
		trailerModel[8].setRotationPoint(19F, -7F, -4F);

		trailerModel[9].addBox(0F, 0F, 0F, 2, 10, 8, 0F); // Box 259
		trailerModel[9].setRotationPoint(18F, -16.5F, -4F);
		trailerModel[9].rotateAngleZ = 0.06981317F;

		trailerModel[10].addBox(0F, 0F, 0F, 8, 3, 8, 0F); // Box 260
		trailerModel[10].setRotationPoint(-18F, -5F, 4F);

		trailerModel[11].addBox(0F, 0F, 0F, 8, 3, 8, 0F); // Box 261
		trailerModel[11].setRotationPoint(-3F, -5F, 4F);

		trailerModel[12].addBox(0F, 0F, 0F, 6, 3, 6, 0F); // Box 262
		trailerModel[12].setRotationPoint(20F, -5F, -2F);*/
 /*steeringWheelModel = new ModelRendererTurbo[13];
		steeringWheelModel[0] = new ModelRendererTurbo(this, 353, 129, textureX, textureY); // Box 261
		steeringWheelModel[1] = new ModelRendererTurbo(this, 361, 129, textureX, textureY); // Box 262
		steeringWheelModel[2] = new ModelRendererTurbo(this, 369, 129, textureX, textureY); // Box 263
		steeringWheelModel[3] = new ModelRendererTurbo(this, 377, 129, textureX, textureY); // Box 264
		steeringWheelModel[4] = new ModelRendererTurbo(this, 409, 129, textureX, textureY); // Box 265
		steeringWheelModel[5] = new ModelRendererTurbo(this, 257, 105, textureX, textureY); // Box 266
		steeringWheelModel[6] = new ModelRendererTurbo(this, 449, 129, textureX, textureY); // Box 267
		steeringWheelModel[7] = new ModelRendererTurbo(this, 385, 129, textureX, textureY); // Box 268
		steeringWheelModel[8] = new ModelRendererTurbo(this, 417, 129, textureX, textureY); // Box 269
		steeringWheelModel[9] = new ModelRendererTurbo(this, 465, 129, textureX, textureY); // Box 270
		steeringWheelModel[10] = new ModelRendererTurbo(this, 473, 129, textureX, textureY); // Box 271
		steeringWheelModel[11] = new ModelRendererTurbo(this, 481, 129, textureX, textureY); // Box 272
		steeringWheelModel[12] = new ModelRendererTurbo(this, 489, 129, textureX, textureY); // Box 273

		steeringWheelModel[0].addBox(0F, -0.5F, 0.5F, 2, 1, 1, 0F); // Box 261
		steeringWheelModel[0].setRotationPoint(30F, -13F, -1F);

		steeringWheelModel[1].addShapeBox(0F, -2.5F, 0.5F, 1, 2, 1, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F); // Box 262
		steeringWheelModel[1].setRotationPoint(30F, -13F, -1F);

		steeringWheelModel[2].addShapeBox(0F, 0.5F, 0.5F, 1, 2, 1, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F); // Box 263
		steeringWheelModel[2].setRotationPoint(30F, -13F, -1F);

		steeringWheelModel[3].addShapeBox(0F, -0.5F, 1.5F, 1, 1, 2, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F); // Box 264
		steeringWheelModel[3].setRotationPoint(30F, -13F, -1F);

		steeringWheelModel[4].addShapeBox(0F, -0.5F, -1.5F, 1, 1, 2, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F); // Box 265
		steeringWheelModel[4].setRotationPoint(30F, -13F, -1F);

		steeringWheelModel[5].addBox(0F, 2.5F, -0.5F, 1, 1, 3, 0F); // Box 266
		steeringWheelModel[5].setRotationPoint(30F, -13F, -1F);

		steeringWheelModel[6].addBox(0F, -3.5F, -0.5F, 1, 1, 3, 0F); // Box 267
		steeringWheelModel[6].setRotationPoint(30F, -13F, -1F);

		steeringWheelModel[7].addBox(0F, -1.5F, -2.5F, 1, 3, 1, 0F); // Box 268
		steeringWheelModel[7].setRotationPoint(30F, -13F, -1F);

		steeringWheelModel[8].addBox(0F, -1.5F, 3.5F, 1, 3, 1, 0F); // Box 269
		steeringWheelModel[8].setRotationPoint(30F, -13F, -1F);

		steeringWheelModel[9].addShapeBox(0F, 1.5F, 3.5F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 1F, 0F, -1F, 1F, 0F, 0F, -2F, 0F, 0F, -2F); // Box 270
		steeringWheelModel[9].setRotationPoint(30F, -13F, -1F);

		steeringWheelModel[10].addShapeBox(0F, -3.5F, 3.5F, 1, 2, 1, 0F, 0F, -1F, 1F, 0F, -1F, 1F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 271
		steeringWheelModel[10].setRotationPoint(30F, -13F, -1F);

		steeringWheelModel[11].addShapeBox(0F, -3.5F, -2.5F, 1, 2, 1, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, -1F, 1F, 0F, -1F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 272
		steeringWheelModel[11].setRotationPoint(30F, -13F, -1F);

		steeringWheelModel[12].addShapeBox(0F, 1.5F, -2.5F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, -1F, 1F, 0F, -1F, 1F); // Box 273
		steeringWheelModel[12].setRotationPoint(30F, -13F, -1F);*/
        //
        translateAll(0F, 0F, 0F);
        flipAll();
    }
}
