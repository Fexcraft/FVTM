package net.fexcraft.mod.addons.zmp.models.trailer;

import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.vehicle.VehicleModel;

public class ModelFoodvanTrailer extends VehicleModel {

    public ModelFoodvanTrailer(){
    	super(); textureX = 512; textureY = 512;
        this.addToCreators("zackyboy18");
        ModelRendererTurbo[] body = new ModelRendererTurbo[265];
        body[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
        body[1] = new ModelRendererTurbo(this, 209, 1, textureX, textureY); // Box 1
        body[2] = new ModelRendererTurbo(this, 353, 1, textureX, textureY); // Box 2
        body[3] = new ModelRendererTurbo(this, 193, 1, textureX, textureY); // Box 3
        body[4] = new ModelRendererTurbo(this, 1, 9, textureX, textureY); // Box 4
        body[5] = new ModelRendererTurbo(this, 33, 9, textureX, textureY); // Box 5
        body[6] = new ModelRendererTurbo(this, 65, 9, textureX, textureY); // Box 6
        body[7] = new ModelRendererTurbo(this, 97, 9, textureX, textureY); // Box 7
        body[8] = new ModelRendererTurbo(this, 129, 9, textureX, textureY); // Box 8
        body[9] = new ModelRendererTurbo(this, 129, 9, textureX, textureY); // Box 9
        body[10] = new ModelRendererTurbo(this, 209, 9, textureX, textureY); // Box 10
        body[11] = new ModelRendererTurbo(this, 265, 9, textureX, textureY); // Box 11
        body[12] = new ModelRendererTurbo(this, 17, 9, textureX, textureY); // Box 12
        body[13] = new ModelRendererTurbo(this, 49, 9, textureX, textureY); // Box 13
        body[14] = new ModelRendererTurbo(this, 81, 9, textureX, textureY); // Box 14
        body[15] = new ModelRendererTurbo(this, 113, 9, textureX, textureY); // Box 15
        body[16] = new ModelRendererTurbo(this, 321, 9, textureX, textureY); // Box 16
        body[17] = new ModelRendererTurbo(this, 353, 9, textureX, textureY); // Box 17
        body[18] = new ModelRendererTurbo(this, 169, 9, textureX, textureY); // Box 18
        body[19] = new ModelRendererTurbo(this, 337, 9, textureX, textureY); // Box 19
        body[20] = new ModelRendererTurbo(this, 369, 9, textureX, textureY); // Box 20
        body[21] = new ModelRendererTurbo(this, 401, 9, textureX, textureY); // Box 21
        body[22] = new ModelRendererTurbo(this, 497, 1, textureX, textureY); // Box 299
        body[23] = new ModelRendererTurbo(this, 385, 9, textureX, textureY); // Box 300
        body[24] = new ModelRendererTurbo(this, 417, 9, textureX, textureY); // Box 8
        body[25] = new ModelRendererTurbo(this, 1, 9, textureX, textureY); // Box 9
        body[26] = new ModelRendererTurbo(this, 433, 9, textureX, textureY); // Box 173
        body[27] = new ModelRendererTurbo(this, 465, 9, textureX, textureY); // Box 175
        body[28] = new ModelRendererTurbo(this, 185, 17, textureX, textureY); // Box 176
        body[29] = new ModelRendererTurbo(this, 217, 17, textureX, textureY); // Box 178
        body[30] = new ModelRendererTurbo(this, 145, 9, textureX, textureY); // Box 16
        body[31] = new ModelRendererTurbo(this, 457, 9, textureX, textureY); // Box 18
        body[32] = new ModelRendererTurbo(this, 241, 17, textureX, textureY); // Box 33
        body[33] = new ModelRendererTurbo(this, 17, 17, textureX, textureY); // Box 34
        body[34] = new ModelRendererTurbo(this, 49, 17, textureX, textureY); // Box 35
        body[35] = new ModelRendererTurbo(this, 273, 17, textureX, textureY); // Box 36
        body[36] = new ModelRendererTurbo(this, 497, 1, textureX, textureY); // Box 37
        body[37] = new ModelRendererTurbo(this, 505, 1, textureX, textureY); // Box 38
        body[38] = new ModelRendererTurbo(this, 17, 9, textureX, textureY); // Box 39
        body[39] = new ModelRendererTurbo(this, 41, 9, textureX, textureY); // Box 40
        body[40] = new ModelRendererTurbo(this, 169, 9, textureX, textureY); // Box 506
        body[41] = new ModelRendererTurbo(this, 401, 9, textureX, textureY); // Box 506
        body[42] = new ModelRendererTurbo(this, 433, 9, textureX, textureY); // Box 506
        body[43] = new ModelRendererTurbo(this, 489, 9, textureX, textureY); // Box 506
        body[44] = new ModelRendererTurbo(this, 209, 17, textureX, textureY); // Box 506
        body[45] = new ModelRendererTurbo(this, 305, 17, textureX, textureY); // Box 506
        body[46] = new ModelRendererTurbo(this, 321, 17, textureX, textureY); // Box 506
        body[47] = new ModelRendererTurbo(this, 489, 17, textureX, textureY); // Box 506
        body[48] = new ModelRendererTurbo(this, 1, 25, textureX, textureY); // Box 506
        body[49] = new ModelRendererTurbo(this, 17, 25, textureX, textureY); // Box 506
        body[50] = new ModelRendererTurbo(this, 33, 25, textureX, textureY); // Box 506
        body[51] = new ModelRendererTurbo(this, 49, 25, textureX, textureY); // Box 506
        body[52] = new ModelRendererTurbo(this, 65, 25, textureX, textureY); // Box 506
        body[53] = new ModelRendererTurbo(this, 81, 25, textureX, textureY); // Box 506
        body[54] = new ModelRendererTurbo(this, 97, 25, textureX, textureY); // Box 506
        body[55] = new ModelRendererTurbo(this, 113, 25, textureX, textureY); // Box 506
        body[56] = new ModelRendererTurbo(this, 129, 25, textureX, textureY); // Box 506
        body[57] = new ModelRendererTurbo(this, 145, 25, textureX, textureY); // Box 506
        body[58] = new ModelRendererTurbo(this, 185, 9, textureX, textureY); // Box 506
        body[59] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 506
        body[60] = new ModelRendererTurbo(this, 81, 17, textureX, textureY); // Box 506
        body[61] = new ModelRendererTurbo(this, 97, 17, textureX, textureY); // Box 506
        body[62] = new ModelRendererTurbo(this, 113, 17, textureX, textureY); // Box 506
        body[63] = new ModelRendererTurbo(this, 129, 17, textureX, textureY); // Box 506
        body[64] = new ModelRendererTurbo(this, 145, 17, textureX, textureY); // Box 506
        body[65] = new ModelRendererTurbo(this, 169, 17, textureX, textureY); // Box 506
        body[66] = new ModelRendererTurbo(this, 185, 17, textureX, textureY); // Box 506
        body[67] = new ModelRendererTurbo(this, 337, 17, textureX, textureY); // Box 506
        body[68] = new ModelRendererTurbo(this, 353, 17, textureX, textureY); // Box 506
        body[69] = new ModelRendererTurbo(this, 369, 17, textureX, textureY); // Box 506
        body[70] = new ModelRendererTurbo(this, 169, 25, textureX, textureY); // Box 506
        body[71] = new ModelRendererTurbo(this, 185, 25, textureX, textureY); // Box 506
        body[72] = new ModelRendererTurbo(this, 209, 25, textureX, textureY); // Box 506
        body[73] = new ModelRendererTurbo(this, 241, 25, textureX, textureY); // Box 506
        body[74] = new ModelRendererTurbo(this, 257, 25, textureX, textureY); // Box 506
        body[75] = new ModelRendererTurbo(this, 273, 25, textureX, textureY); // Box 506
        body[76] = new ModelRendererTurbo(this, 289, 25, textureX, textureY); // Box 506
        body[77] = new ModelRendererTurbo(this, 305, 25, textureX, textureY); // Box 506
        body[78] = new ModelRendererTurbo(this, 321, 25, textureX, textureY); // Box 506
        body[79] = new ModelRendererTurbo(this, 337, 25, textureX, textureY); // Box 506
        body[80] = new ModelRendererTurbo(this, 353, 25, textureX, textureY); // Box 506
        body[81] = new ModelRendererTurbo(this, 369, 25, textureX, textureY); // Box 506
        body[82] = new ModelRendererTurbo(this, 385, 25, textureX, textureY); // Box 506
        body[83] = new ModelRendererTurbo(this, 401, 25, textureX, textureY); // Box 506
        body[84] = new ModelRendererTurbo(this, 417, 25, textureX, textureY); // Box 506
        body[85] = new ModelRendererTurbo(this, 497, 25, textureX, textureY); // Box 506
        body[86] = new ModelRendererTurbo(this, 1, 33, textureX, textureY); // Box 506
        body[87] = new ModelRendererTurbo(this, 17, 33, textureX, textureY); // Box 506
        body[88] = new ModelRendererTurbo(this, 33, 33, textureX, textureY); // Box 506
        body[89] = new ModelRendererTurbo(this, 49, 33, textureX, textureY); // Box 506
        body[90] = new ModelRendererTurbo(this, 65, 33, textureX, textureY); // Box 141
        body[91] = new ModelRendererTurbo(this, 81, 33, textureX, textureY); // Box 142
        body[92] = new ModelRendererTurbo(this, 97, 33, textureX, textureY); // Box 143
        body[93] = new ModelRendererTurbo(this, 113, 33, textureX, textureY); // Box 144
        body[94] = new ModelRendererTurbo(this, 129, 33, textureX, textureY); // Box 145
        body[95] = new ModelRendererTurbo(this, 145, 33, textureX, textureY); // Box 146
        body[96] = new ModelRendererTurbo(this, 169, 33, textureX, textureY); // Box 147
        body[97] = new ModelRendererTurbo(this, 249, 33, textureX, textureY); // Box 148
        body[98] = new ModelRendererTurbo(this, 265, 33, textureX, textureY); // Box 149
        body[99] = new ModelRendererTurbo(this, 281, 33, textureX, textureY); // Box 150
        body[100] = new ModelRendererTurbo(this, 297, 33, textureX, textureY); // Box 151
        body[101] = new ModelRendererTurbo(this, 313, 33, textureX, textureY); // Box 152
        body[102] = new ModelRendererTurbo(this, 329, 33, textureX, textureY); // Box 153
        body[103] = new ModelRendererTurbo(this, 345, 33, textureX, textureY); // Box 154
        body[104] = new ModelRendererTurbo(this, 361, 33, textureX, textureY); // Box 155
        body[105] = new ModelRendererTurbo(this, 377, 33, textureX, textureY); // Box 156
        body[106] = new ModelRendererTurbo(this, 393, 33, textureX, textureY); // Box 157
        body[107] = new ModelRendererTurbo(this, 409, 33, textureX, textureY); // Box 158
        body[108] = new ModelRendererTurbo(this, 425, 33, textureX, textureY); // Box 159
        body[109] = new ModelRendererTurbo(this, 441, 33, textureX, textureY); // Box 160
        body[110] = new ModelRendererTurbo(this, 457, 33, textureX, textureY); // Box 161
        body[111] = new ModelRendererTurbo(this, 473, 33, textureX, textureY); // Box 162
        body[112] = new ModelRendererTurbo(this, 489, 33, textureX, textureY); // Box 163
        body[113] = new ModelRendererTurbo(this, 9, 41, textureX, textureY); // Box 164
        body[114] = new ModelRendererTurbo(this, 25, 41, textureX, textureY); // Box 165
        body[115] = new ModelRendererTurbo(this, 41, 41, textureX, textureY); // Box 166
        body[116] = new ModelRendererTurbo(this, 57, 41, textureX, textureY); // Box 167
        body[117] = new ModelRendererTurbo(this, 73, 41, textureX, textureY); // Box 168
        body[118] = new ModelRendererTurbo(this, 89, 41, textureX, textureY); // Box 169
        body[119] = new ModelRendererTurbo(this, 105, 41, textureX, textureY); // Box 170
        body[120] = new ModelRendererTurbo(this, 121, 41, textureX, textureY); // Box 171
        body[121] = new ModelRendererTurbo(this, 193, 41, textureX, textureY); // Box 172
        body[122] = new ModelRendererTurbo(this, 209, 41, textureX, textureY); // Box 173
        body[123] = new ModelRendererTurbo(this, 225, 41, textureX, textureY); // Box 174
        body[124] = new ModelRendererTurbo(this, 241, 41, textureX, textureY); // Box 175
        body[125] = new ModelRendererTurbo(this, 257, 41, textureX, textureY); // Box 176
        body[126] = new ModelRendererTurbo(this, 273, 41, textureX, textureY); // Box 177
        body[127] = new ModelRendererTurbo(this, 289, 41, textureX, textureY); // Box 178
        body[128] = new ModelRendererTurbo(this, 305, 41, textureX, textureY); // Box 179
        body[129] = new ModelRendererTurbo(this, 321, 41, textureX, textureY); // Box 180
        body[130] = new ModelRendererTurbo(this, 337, 41, textureX, textureY); // Box 181
        body[131] = new ModelRendererTurbo(this, 353, 41, textureX, textureY); // Box 182
        body[132] = new ModelRendererTurbo(this, 369, 41, textureX, textureY); // Box 183
        body[133] = new ModelRendererTurbo(this, 385, 41, textureX, textureY); // Box 184
        body[134] = new ModelRendererTurbo(this, 401, 41, textureX, textureY); // Box 185
        body[135] = new ModelRendererTurbo(this, 417, 41, textureX, textureY); // Box 186
        body[136] = new ModelRendererTurbo(this, 433, 41, textureX, textureY); // Box 187
        body[137] = new ModelRendererTurbo(this, 449, 41, textureX, textureY); // Box 188
        body[138] = new ModelRendererTurbo(this, 465, 41, textureX, textureY); // Box 189
        body[139] = new ModelRendererTurbo(this, 481, 41, textureX, textureY); // Box 190
        body[140] = new ModelRendererTurbo(this, 1, 49, textureX, textureY); // Box 191
        body[141] = new ModelRendererTurbo(this, 25, 49, textureX, textureY); // Box 192
        body[142] = new ModelRendererTurbo(this, 385, 9, textureX, textureY); // Box 143
        body[143] = new ModelRendererTurbo(this, 417, 9, textureX, textureY); // Box 144
        body[144] = new ModelRendererTurbo(this, 49, 9, textureX, textureY); // Box 145
        body[145] = new ModelRendererTurbo(this, 73, 9, textureX, textureY); // Box 146
        body[146] = new ModelRendererTurbo(this, 49, 49, textureX, textureY); // Box 154
        body[147] = new ModelRendererTurbo(this, 169, 57, textureX, textureY); // Box 178
        body[148] = new ModelRendererTurbo(this, 297, 57, textureX, textureY); // Box 179
        body[149] = new ModelRendererTurbo(this, 1, 65, textureX, textureY); // Box 180
        body[150] = new ModelRendererTurbo(this, 497, 41, textureX, textureY); // Box 181
        body[151] = new ModelRendererTurbo(this, 1, 57, textureX, textureY); // Box 182
        body[152] = new ModelRendererTurbo(this, 449, 49, textureX, textureY); // Box 183
        body[153] = new ModelRendererTurbo(this, 145, 73, textureX, textureY); // Box 184
        body[154] = new ModelRendererTurbo(this, 457, 49, textureX, textureY); // Box 185
        body[155] = new ModelRendererTurbo(this, 489, 49, textureX, textureY); // Box 188
        body[156] = new ModelRendererTurbo(this, 465, 57, textureX, textureY); // Box 189
        body[157] = new ModelRendererTurbo(this, 177, 73, textureX, textureY); // Box 192
        body[158] = new ModelRendererTurbo(this, 193, 73, textureX, textureY); // Box 193
        body[159] = new ModelRendererTurbo(this, 209, 73, textureX, textureY); // Box 196
        body[160] = new ModelRendererTurbo(this, 225, 73, textureX, textureY); // Box 198
        body[161] = new ModelRendererTurbo(this, 169, 49, textureX, textureY); // Box 207
        body[162] = new ModelRendererTurbo(this, 401, 73, textureX, textureY); // Box 211
        body[163] = new ModelRendererTurbo(this, 1, 81, textureX, textureY); // Box 187
        body[164] = new ModelRendererTurbo(this, 497, 57, textureX, textureY); // Box 188
        body[165] = new ModelRendererTurbo(this, 409, 73, textureX, textureY); // Box 189
        body[166] = new ModelRendererTurbo(this, 57, 81, textureX, textureY); // Box 190
        body[167] = new ModelRendererTurbo(this, 137, 81, textureX, textureY); // Box 191
        body[168] = new ModelRendererTurbo(this, 1, 89, textureX, textureY); // Box 192
        body[169] = new ModelRendererTurbo(this, 425, 73, textureX, textureY); // Box 193
        body[170] = new ModelRendererTurbo(this, 409, 89, textureX, textureY); // Box 194
        body[171] = new ModelRendererTurbo(this, 81, 9, textureX, textureY); // Box 195
        body[172] = new ModelRendererTurbo(this, 105, 9, textureX, textureY); // Box 196
        body[173] = new ModelRendererTurbo(this, 113, 9, textureX, textureY); // Box 197
        body[174] = new ModelRendererTurbo(this, 137, 9, textureX, textureY); // Box 198
        body[175] = new ModelRendererTurbo(this, 449, 89, textureX, textureY); // Box 199
        body[176] = new ModelRendererTurbo(this, 57, 97, textureX, textureY); // Box 200
        body[177] = new ModelRendererTurbo(this, 201, 9, textureX, textureY); // Box 201
        body[178] = new ModelRendererTurbo(this, 321, 9, textureX, textureY); // Box 202
        body[179] = new ModelRendererTurbo(this, 345, 9, textureX, textureY); // Box 203
        body[180] = new ModelRendererTurbo(this, 353, 9, textureX, textureY); // Box 204
        body[181] = new ModelRendererTurbo(this, 417, 81, textureX, textureY); // Box 205
        body[182] = new ModelRendererTurbo(this, 113, 97, textureX, textureY); // Box 206
        body[183] = new ModelRendererTurbo(this, 209, 97, textureX, textureY); // Box 207
        body[184] = new ModelRendererTurbo(this, 225, 41, textureX, textureY); // Box 208
        body[185] = new ModelRendererTurbo(this, 257, 41, textureX, textureY); // Box 209
        body[186] = new ModelRendererTurbo(this, 449, 97, textureX, textureY); // Box 210
        body[187] = new ModelRendererTurbo(this, 1, 105, textureX, textureY); // Box 211
        body[188] = new ModelRendererTurbo(this, 49, 105, textureX, textureY); // Box 212
        body[189] = new ModelRendererTurbo(this, 1, 113, textureX, textureY); // Box 213
        body[190] = new ModelRendererTurbo(this, 489, 97, textureX, textureY); // Box 214
        body[191] = new ModelRendererTurbo(this, 89, 105, textureX, textureY); // Box 215
        body[192] = new ModelRendererTurbo(this, 129, 113, textureX, textureY); // Box 216
        body[193] = new ModelRendererTurbo(this, 153, 113, textureX, textureY); // Box 217
        body[194] = new ModelRendererTurbo(this, 177, 113, textureX, textureY); // Box 218
        body[195] = new ModelRendererTurbo(this, 225, 113, textureX, textureY); // Box 219
        body[196] = new ModelRendererTurbo(this, 249, 113, textureX, textureY); // Box 220
        body[197] = new ModelRendererTurbo(this, 289, 113, textureX, textureY); // Box 221
        body[198] = new ModelRendererTurbo(this, 329, 113, textureX, textureY); // Box 222
        body[199] = new ModelRendererTurbo(this, 369, 113, textureX, textureY); // Box 223
        body[200] = new ModelRendererTurbo(this, 393, 121, textureX, textureY); // Box 224
        body[201] = new ModelRendererTurbo(this, 153, 65, textureX, textureY); // Box 225
        body[202] = new ModelRendererTurbo(this, 481, 65, textureX, textureY); // Box 226
        body[203] = new ModelRendererTurbo(this, 73, 121, textureX, textureY); // Box 227
        body[204] = new ModelRendererTurbo(this, 113, 121, textureX, textureY); // Box 228
        body[205] = new ModelRendererTurbo(this, 201, 121, textureX, textureY); // Box 229
        body[206] = new ModelRendererTurbo(this, 129, 97, textureX, textureY); // Box 230
        body[207] = new ModelRendererTurbo(this, 481, 121, textureX, textureY); // Box 231
        body[208] = new ModelRendererTurbo(this, 17, 57, textureX, textureY); // Box 232
        body[209] = new ModelRendererTurbo(this, 225, 97, textureX, textureY); // Box 233
        body[210] = new ModelRendererTurbo(this, 401, 97, textureX, textureY); // Box 234
        body[211] = new ModelRendererTurbo(this, 1, 129, textureX, textureY); // Box 235
        body[212] = new ModelRendererTurbo(this, 33, 57, textureX, textureY); // Box 236
        body[213] = new ModelRendererTurbo(this, 425, 81, textureX, textureY); // Box 237
        body[214] = new ModelRendererTurbo(this, 393, 113, textureX, textureY); // Box 238
        body[215] = new ModelRendererTurbo(this, 377, 9, textureX, textureY); // Box 239
        body[216] = new ModelRendererTurbo(this, 457, 9, textureX, textureY); // Box 240
        body[217] = new ModelRendererTurbo(this, 473, 9, textureX, textureY); // Box 241
        body[218] = new ModelRendererTurbo(this, 241, 129, textureX, textureY); // Box 242
        body[219] = new ModelRendererTurbo(this, 33, 129, textureX, textureY); // Box 243
        body[220] = new ModelRendererTurbo(this, 81, 129, textureX, textureY); // Box 244
        body[221] = new ModelRendererTurbo(this, 57, 129, textureX, textureY); // Box 245
        body[222] = new ModelRendererTurbo(this, 321, 129, textureX, textureY); // Box 246
        body[223] = new ModelRendererTurbo(this, 209, 129, textureX, textureY); // Box 247
        body[224] = new ModelRendererTurbo(this, 353, 129, textureX, textureY); // Box 248
        body[225] = new ModelRendererTurbo(this, 433, 97, textureX, textureY); // Box 249
        body[226] = new ModelRendererTurbo(this, 497, 121, textureX, textureY); // Box 250
        body[227] = new ModelRendererTurbo(this, 377, 129, textureX, textureY); // Box 251
        body[228] = new ModelRendererTurbo(this, 145, 97, textureX, textureY); // Box 252
        body[229] = new ModelRendererTurbo(this, 449, 105, textureX, textureY); // Box 253
        body[230] = new ModelRendererTurbo(this, 225, 17, textureX, textureY); // Box 254
        body[231] = new ModelRendererTurbo(this, 505, 17, textureX, textureY); // Box 255
        body[232] = new ModelRendererTurbo(this, 417, 129, textureX, textureY); // Box 256
        body[233] = new ModelRendererTurbo(this, 441, 129, textureX, textureY); // Box 257
        body[234] = new ModelRendererTurbo(this, 113, 137, textureX, textureY); // Box 258
        body[235] = new ModelRendererTurbo(this, 393, 137, textureX, textureY); // Box 259
        body[236] = new ModelRendererTurbo(this, 185, 129, textureX, textureY); // Box 260
        body[237] = new ModelRendererTurbo(this, 457, 129, textureX, textureY); // Box 261
        body[238] = new ModelRendererTurbo(this, 345, 137, textureX, textureY); // Box 262
        body[239] = new ModelRendererTurbo(this, 481, 137, textureX, textureY); // Box 263
        body[240] = new ModelRendererTurbo(this, 1, 145, textureX, textureY); // Box 264
        body[241] = new ModelRendererTurbo(this, 105, 145, textureX, textureY); // Box 265
        body[242] = new ModelRendererTurbo(this, 137, 145, textureX, textureY); // Box 266
        body[243] = new ModelRendererTurbo(this, 233, 145, textureX, textureY); // Box 267
        body[244] = new ModelRendererTurbo(this, 265, 145, textureX, textureY); // Box 268
        body[245] = new ModelRendererTurbo(this, 305, 145, textureX, textureY); // Box 269
        body[246] = new ModelRendererTurbo(this, 369, 145, textureX, textureY); // Box 270
        body[247] = new ModelRendererTurbo(this, 393, 145, textureX, textureY); // Box 271
        body[248] = new ModelRendererTurbo(this, 409, 145, textureX, textureY); // Box 272
        body[249] = new ModelRendererTurbo(this, 433, 33, textureX, textureY); // Box 273
        body[250] = new ModelRendererTurbo(this, 361, 137, textureX, textureY); // Box 274
        body[251] = new ModelRendererTurbo(this, 433, 145, textureX, textureY); // Box 275
        body[252] = new ModelRendererTurbo(this, 33, 153, textureX, textureY); // Box 276
        body[253] = new ModelRendererTurbo(this, 505, 33, textureX, textureY); // Box 277
        body[254] = new ModelRendererTurbo(this, 249, 49, textureX, textureY); // Box 278
        body[255] = new ModelRendererTurbo(this, 57, 153, textureX, textureY); // Box 279
        body[256] = new ModelRendererTurbo(this, 81, 153, textureX, textureY); // Box 280
        body[257] = new ModelRendererTurbo(this, 409, 17, textureX, textureY); // Box 281
        body[258] = new ModelRendererTurbo(this, 441, 17, textureX, textureY); // Box 282
        body[259] = new ModelRendererTurbo(this, 225, 25, textureX, textureY); // Box 283
        body[260] = new ModelRendererTurbo(this, 169, 49, textureX, textureY); // Box 284
        body[261] = new ModelRendererTurbo(this, 217, 49, textureX, textureY); // Box 285
        body[262] = new ModelRendererTurbo(this, 281, 49, textureX, textureY); // Box 286
        body[263] = new ModelRendererTurbo(this, 297, 49, textureX, textureY); // Box 287
        body[264] = new ModelRendererTurbo(this, 313, 49, textureX, textureY); // Box 288

        body[0].addBox(0F, 0F, 0F, 100, 2, 2, 0F); // Box 0
        body[0].setRotationPoint(-99F, -2F, -1.5F);

        body[1].addBox(0F, 0F, 0F, 70, 2, 1, 0F); // Box 1
        body[1].setRotationPoint(-99F, -1.7F, -15.5F);

        body[2].addBox(0F, 0F, 0F, 70, 2, 1, 0F); // Box 2
        body[2].setRotationPoint(-99F, -1.7F, 13.5F);

        body[3].addBox(0F, 0F, 0F, 1, 1, 13, 0F); // Box 3
        body[3].setRotationPoint(-56F, -1.7F, 0.5F);

        body[4].addBox(0F, 0F, 0F, 1, 1, 13, 0F); // Box 4
        body[4].setRotationPoint(-43F, -1.7F, 0.5F);

        body[5].addBox(0F, 0F, 0F, 1, 1, 13, 0F); // Box 5
        body[5].setRotationPoint(-30F, -1.7F, 0.5F);

        body[6].addBox(0F, 0F, 0F, 1, 1, 13, 0F); // Box 6
        body[6].setRotationPoint(-30F, -1.7F, -14.5F);

        body[7].addBox(0F, 0F, 0F, 1, 1, 13, 0F); // Box 7
        body[7].setRotationPoint(-43F, -1.7F, -14.5F);

        body[8].addBox(0F, 0F, 0F, 1, 1, 13, 0F); // Box 8
        body[8].setRotationPoint(-56F, -1.7F, -14.5F);

        body[9].addBox(0F, 0F, 0F, 1, 2, 30, 0F); // Box 9
        body[9].setRotationPoint(-100F, -1.7F, -15.5F);

        body[10].addShapeBox(0F, 0F, 0F, 26, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, -14F, 0F, 0F, 14F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -14F, 0F, 0F, 14F, 0F, 0F, 0F); // Box 10
        body[10].setRotationPoint(-29F, -1.7F, -15.5F);

        body[11].addShapeBox(0F, 0F, 0F, 26, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 14F, 0F, 0F, -14F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 14F, 0F, 0F, -14F, 0F, 0F, 0F); // Box 11
        body[11].setRotationPoint(-29F, -1.7F, 13.5F);

        body[12].addBox(0F, 0F, 0F, 8, 1, 6, 0F); // Box 12
        body[12].setRotationPoint(-81F, -5.7F, -21.5F);

        body[13].addShapeBox(0F, 0F, 0F, 6, 1, 6, 0F, 0F, 0F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, 0F, 0F); // Box 13
        body[13].setRotationPoint(-73F, -5.7F, -21.5F);

        body[14].addShapeBox(0F, 0F, 0F, 6, 1, 6, 0F, 0F, 0F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, 0F, 0F); // Box 14
        body[14].setRotationPoint(-73F, -5.7F, 14.5F);

        body[15].addBox(0F, 0F, 0F, 8, 1, 6, 0F); // Box 15
        body[15].setRotationPoint(-81F, -5.7F, 14.5F);

        body[16].addShapeBox(0F, 0F, 0F, 6, 1, 6, 0F, 0F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 5F, 0F); // Box 16
        body[16].setRotationPoint(-87F, -5.7F, -21.5F);

        body[17].addShapeBox(0F, 0F, 0F, 6, 1, 6, 0F, 0F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 5F, 0F); // Box 17
        body[17].setRotationPoint(-87F, -5.7F, 14.5F);

        body[18].addBox(0F, 0F, 0F, 1, 1, 13, 0F); // Box 18
        body[18].setRotationPoint(-72F, -1.7F, -14.5F);

        body[19].addBox(0F, 0F, 0F, 1, 1, 13, 0F); // Box 19
        body[19].setRotationPoint(-72F, -1.7F, 0.5F);

        body[20].addBox(0F, 0F, 0F, 1, 1, 13, 0F); // Box 20
        body[20].setRotationPoint(-86F, -1.7F, -14.5F);

        body[21].addBox(0F, 0F, 0F, 1, 1, 13, 0F); // Box 21
        body[21].setRotationPoint(-86F, -1.7F, 0.5F);

        body[22].addShapeBox(0F, 0F, 0F, 1, 3, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 299
        body[22].setRotationPoint(-80F, -0.5F, -3F);

        body[23].addShapeBox(0F, 0F, 0F, 3, 1, 7, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 300
        body[23].setRotationPoint(-83F, 2.5F, -4F);

        body[24].addShapeBox(0F, 0F, 0F, 3, 3, 7, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 8
        body[24].setRotationPoint(-83F, -0.5F, -4F);

        body[25].addShapeBox(0F, 0F, 0F, 2, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 9
        body[25].setRotationPoint(-82.5F, 0F, 3F);

        body[26].addShapeBox(0F, 0F, 0F, 1, 2, 14, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 173
        body[26].setRotationPoint(-81.5F, 0F, 5F);

        body[27].addShapeBox(0F, 0F, 0F, 1, 2, 14, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 175
        body[27].setRotationPoint(-82.5F, 0F, 5F);

        body[28].addShapeBox(0F, 0F, 0F, 1, 2, 14, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 176
        body[28].setRotationPoint(-82.5F, 0F, -20F);

        body[29].addShapeBox(0F, 0F, 0F, 1, 2, 14, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 178
        body[29].setRotationPoint(-81.5F, 0F, -20F);

        body[30].addShapeBox(0F, 0F, 0F, 2, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 16
        body[30].setRotationPoint(-82.5F, 0F, -6F);

        body[31].addShapeBox(0F, 0F, 0F, 3, 1, 7, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 18
        body[31].setRotationPoint(-83F, -1.5F, -4F);

        body[32].addBox(0F, 0F, 0F, 14, 1, 1, 0F); // Box 33
        body[32].setRotationPoint(-84F, -2.7F, -16.5F);

        body[33].addBox(0F, 0F, 0F, 12, 1, 1, 0F); // Box 34
        body[33].setRotationPoint(-83F, -3.7F, -16.5F);

        body[34].addBox(0F, 0F, 0F, 12, 1, 1, 0F); // Box 35
        body[34].setRotationPoint(-83F, -3.7F, 14.5F);

        body[35].addBox(0F, 0F, 0F, 14, 1, 1, 0F); // Box 36
        body[35].setRotationPoint(-84F, -2.7F, 14.5F);

        body[36].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F); // Box 37
        body[36].setRotationPoint(-87.5F, -2F, 13.5F);

        body[37].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F); // Box 38
        body[37].setRotationPoint(-76.5F, -2F, 13.5F);

        body[38].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F); // Box 39
        body[38].setRotationPoint(-87.5F, -2F, -15.5F);

        body[39].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F); // Box 40
        body[39].setRotationPoint(-76.5F, -2F, -15.5F);

        body[40].addShapeBox(-0.5F, -1.5F, -1.5F, 2, 3, 2, 0F, -0.5F, 0.25F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, -0.5F, 0.25F, 0F, -0.5F, 0.25F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, -0.5F, 0.25F, 0F); // Box 506
        body[40].setRotationPoint(-76.5F, 2.05F, 19F);

        body[41].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[41].setRotationPoint(-76.5F, 2.05F, 20F);

        body[42].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[42].setRotationPoint(-76.5F, 2.05F, 20F);
        body[42].rotationAngleZ = Static.toDegrees(-0.39269908F);

        body[43].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[43].setRotationPoint(-76.5F, 2.05F, 20F);
        body[43].rotationAngleZ = Static.toDegrees(-1.17809725F);

        body[44].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[44].setRotationPoint(-76.5F, 2.05F, 20F);
        body[44].rotationAngleZ = Static.toDegrees(-0.78539816F);

        body[45].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[45].setRotationPoint(-76.5F, 2.05F, 20F);
        body[45].rotationAngleZ = Static.toDegrees(-2.74889357F);

        body[46].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[46].setRotationPoint(-76.5F, 2.05F, 20F);
        body[46].rotationAngleZ = Static.toDegrees(-2.35619449F);

        body[47].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[47].setRotationPoint(-76.5F, 2.05F, 20F);
        body[47].rotationAngleZ = Static.toDegrees(-1.96349541F);

        body[48].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[48].setRotationPoint(-76.5F, 2.05F, 20F);
        body[48].rotationAngleZ = Static.toDegrees(-1.57079633F);

        body[49].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[49].setRotationPoint(-76.5F, 2.05F, 20F);
        body[49].rotationAngleZ = Static.toDegrees(-5.89048623F);

        body[50].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[50].setRotationPoint(-76.5F, 2.05F, 20F);
        body[50].rotationAngleZ = Static.toDegrees(-5.49778714F);

        body[51].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[51].setRotationPoint(-76.5F, 2.05F, 20F);
        body[51].rotationAngleZ = Static.toDegrees(-5.10508806F);

        body[52].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[52].setRotationPoint(-76.5F, 2.05F, 20F);
        body[52].rotationAngleZ = Static.toDegrees(-4.71238898F);

        body[53].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[53].setRotationPoint(-76.5F, 2.05F, 20F);
        body[53].rotationAngleZ = Static.toDegrees(-4.3196899F);

        body[54].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[54].setRotationPoint(-76.5F, 2.05F, 20F);
        body[54].rotationAngleZ = Static.toDegrees(-3.92699082F);

        body[55].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[55].setRotationPoint(-76.5F, 2.05F, 20F);
        body[55].rotationAngleZ = Static.toDegrees(-3.53429174F);

        body[56].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[56].setRotationPoint(-76.5F, 2.05F, 20F);
        body[56].rotationAngleZ = Static.toDegrees(-3.14159265F);

        body[57].addShapeBox(-1.5F, -1.5F, -1.5F, 2, 3, 2, 0F, 0F, -0.75F, 0F, -0.5F, 0.25F, 0F, -0.5F, 0.25F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, -0.5F, 0.25F, 0F, -0.5F, 0.25F, 0F, 0F, -0.75F, 0F); // Box 506
        body[57].setRotationPoint(-76.5F, 2.05F, 19F);

        body[58].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[58].setRotationPoint(-76.5F, 2.05F, 20F);

        body[59].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[59].setRotationPoint(-76.5F, 2.05F, 20F);
        body[59].rotationAngleZ = Static.toDegrees(-0.39269908F);

        body[60].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[60].setRotationPoint(-76.5F, 2.05F, 20F);
        body[60].rotationAngleZ = Static.toDegrees(-1.17809725F);

        body[61].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[61].setRotationPoint(-76.5F, 2.05F, 20F);
        body[61].rotationAngleZ = Static.toDegrees(-0.78539816F);

        body[62].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[62].setRotationPoint(-76.5F, 2.05F, 20F);
        body[62].rotationAngleZ = Static.toDegrees(-2.74889357F);

        body[63].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[63].setRotationPoint(-76.5F, 2.05F, 20F);
        body[63].rotationAngleZ = Static.toDegrees(-2.35619449F);

        body[64].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[64].setRotationPoint(-76.5F, 2.05F, 20F);
        body[64].rotationAngleZ = Static.toDegrees(-1.96349541F);

        body[65].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[65].setRotationPoint(-76.5F, 2.05F, 20F);
        body[65].rotationAngleZ = Static.toDegrees(-1.57079633F);

        body[66].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[66].setRotationPoint(-76.5F, 2.05F, 20F);
        body[66].rotationAngleZ = Static.toDegrees(-5.89048623F);

        body[67].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[67].setRotationPoint(-76.5F, 2.05F, 20F);
        body[67].rotationAngleZ = Static.toDegrees(-5.49778714F);

        body[68].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[68].setRotationPoint(-76.5F, 2.05F, 20F);
        body[68].rotationAngleZ = Static.toDegrees(-5.10508806F);

        body[69].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[69].setRotationPoint(-76.5F, 2.05F, 20F);
        body[69].rotationAngleZ = Static.toDegrees(-4.71238898F);

        body[70].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[70].setRotationPoint(-76.5F, 2.05F, 20F);
        body[70].rotationAngleZ = Static.toDegrees(-4.3196899F);

        body[71].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[71].setRotationPoint(-76.5F, 2.05F, 20F);
        body[71].rotationAngleZ = Static.toDegrees(-3.92699082F);

        body[72].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[72].setRotationPoint(-76.5F, 2.05F, 20F);
        body[72].rotationAngleZ = Static.toDegrees(-3.53429174F);

        body[73].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[73].setRotationPoint(-76.5F, 2.05F, 20F);
        body[73].rotationAngleZ = Static.toDegrees(-3.14159265F);

        body[74].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[74].setRotationPoint(-76.5F, 2.05F, 20F);

        body[75].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[75].setRotationPoint(-76.5F, 2.05F, 20F);
        body[75].rotationAngleZ = Static.toDegrees(-0.39269908F);

        body[76].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[76].setRotationPoint(-76.5F, 2.05F, 20F);
        body[76].rotationAngleZ = Static.toDegrees(-1.17809725F);

        body[77].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[77].setRotationPoint(-76.5F, 2.05F, 20F);
        body[77].rotationAngleZ = Static.toDegrees(-0.78539816F);

        body[78].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[78].setRotationPoint(-76.5F, 2.05F, 20F);
        body[78].rotationAngleZ = Static.toDegrees(-2.74889357F);

        body[79].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[79].setRotationPoint(-76.5F, 2.05F, 20F);
        body[79].rotationAngleZ = Static.toDegrees(-2.35619449F);

        body[80].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[80].setRotationPoint(-76.5F, 2.05F, 20F);
        body[80].rotationAngleZ = Static.toDegrees(-1.96349541F);

        body[81].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[81].setRotationPoint(-76.5F, 2.05F, 20F);
        body[81].rotationAngleZ = Static.toDegrees(-1.57079633F);

        body[82].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[82].setRotationPoint(-76.5F, 2.05F, 20F);
        body[82].rotationAngleZ = Static.toDegrees(-5.89048623F);

        body[83].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[83].setRotationPoint(-76.5F, 2.05F, 20F);
        body[83].rotationAngleZ = Static.toDegrees(-5.10508806F);

        body[84].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[84].setRotationPoint(-76.5F, 2.05F, 20F);
        body[84].rotationAngleZ = Static.toDegrees(-4.71238898F);

        body[85].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[85].setRotationPoint(-76.5F, 2.05F, 20F);
        body[85].rotationAngleZ = Static.toDegrees(-4.3196899F);

        body[86].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[86].setRotationPoint(-76.5F, 2.05F, 20F);
        body[86].rotationAngleZ = Static.toDegrees(-3.92699082F);

        body[87].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[87].setRotationPoint(-76.5F, 2.05F, 20F);
        body[87].rotationAngleZ = Static.toDegrees(-3.53429174F);

        body[88].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[88].setRotationPoint(-76.5F, 2.05F, 20F);
        body[88].rotationAngleZ = Static.toDegrees(-3.14159265F);

        body[89].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[89].setRotationPoint(-76.5F, 2.05F, 20F);
        body[89].rotationAngleZ = Static.toDegrees(-5.49778714F);

        body[90].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 141
        body[90].setRotationPoint(-76.5F, 2.05F, -20F);

        body[91].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 142
        body[91].setRotationPoint(-76.5F, 2.05F, -20F);
        body[91].rotationAngleZ = Static.toDegrees(-0.39269908F);

        body[92].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 143
        body[92].setRotationPoint(-76.5F, 2.05F, -20F);
        body[92].rotationAngleZ = Static.toDegrees(-0.78539816F);

        body[93].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 144
        body[93].setRotationPoint(-76.5F, 2.05F, -20F);
        body[93].rotationAngleZ = Static.toDegrees(-1.17809725F);

        body[94].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 145
        body[94].setRotationPoint(-76.5F, 2.05F, -20F);
        body[94].rotationAngleZ = Static.toDegrees(-1.57079633F);

        body[95].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 146
        body[95].setRotationPoint(-76.5F, 2.05F, -20F);
        body[95].rotationAngleZ = Static.toDegrees(-1.96349541F);

        body[96].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 147
        body[96].setRotationPoint(-76.5F, 2.05F, -20F);
        body[96].rotationAngleZ = Static.toDegrees(-2.35619449F);

        body[97].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 148
        body[97].setRotationPoint(-76.5F, 2.05F, -20F);
        body[97].rotationAngleZ = Static.toDegrees(-2.74889357F);

        body[98].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 149
        body[98].setRotationPoint(-76.5F, 2.05F, -20F);
        body[98].rotationAngleZ = Static.toDegrees(-3.14159265F);

        body[99].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 150
        body[99].setRotationPoint(-76.5F, 2.05F, -20F);
        body[99].rotationAngleZ = Static.toDegrees(-3.53429174F);

        body[100].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 151
        body[100].setRotationPoint(-76.5F, 2.05F, -20F);
        body[100].rotationAngleZ = Static.toDegrees(-3.92699082F);

        body[101].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 152
        body[101].setRotationPoint(-76.5F, 2.05F, -20F);
        body[101].rotationAngleZ = Static.toDegrees(-4.3196899F);

        body[102].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 153
        body[102].setRotationPoint(-76.5F, 2.05F, -20F);
        body[102].rotationAngleZ = Static.toDegrees(-4.71238898F);

        body[103].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 154
        body[103].setRotationPoint(-76.5F, 2.05F, -20F);
        body[103].rotationAngleZ = Static.toDegrees(-5.10508806F);

        body[104].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 155
        body[104].setRotationPoint(-76.5F, 2.05F, -20F);
        body[104].rotationAngleZ = Static.toDegrees(-5.89048623F);

        body[105].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 156
        body[105].setRotationPoint(-76.5F, 2.05F, -20F);
        body[105].rotationAngleZ = Static.toDegrees(-5.49778714F);

        body[106].addShapeBox(-1.5F, -1.5F, -1.5F, 2, 3, 2, 0F, -0.5F, 0.25F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, -0.5F, 0.25F, 0F, -0.5F, 0.25F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, -0.5F, 0.25F, 0F); // Box 157
        body[106].setRotationPoint(-75.5F, 2.05F, -19F);

        body[107].addShapeBox(-0.5F, -1.5F, -1.5F, 2, 3, 2, 0F, 0F, -0.75F, 0F, -0.5F, 0.25F, 0F, -0.5F, 0.25F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, -0.5F, 0.25F, 0F, -0.5F, 0.25F, 0F, 0F, -0.75F, 0F); // Box 158
        body[107].setRotationPoint(-77.5F, 2.05F, -19F);

        body[108].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 159
        body[108].setRotationPoint(-76.5F, 2.05F, -20F);

        body[109].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 160
        body[109].setRotationPoint(-76.5F, 2.05F, -20F);
        body[109].rotationAngleZ = Static.toDegrees(-5.89048623F);

        body[110].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 161
        body[110].setRotationPoint(-76.5F, 2.05F, -20F);
        body[110].rotationAngleZ = Static.toDegrees(-5.49778714F);

        body[111].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 162
        body[111].setRotationPoint(-76.5F, 2.05F, -20F);
        body[111].rotationAngleZ = Static.toDegrees(-5.10508806F);

        body[112].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 163
        body[112].setRotationPoint(-76.5F, 2.05F, -20F);
        body[112].rotationAngleZ = Static.toDegrees(-4.71238898F);

        body[113].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 164
        body[113].setRotationPoint(-76.5F, 2.05F, -20F);
        body[113].rotationAngleZ = Static.toDegrees(-4.3196899F);

        body[114].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 165
        body[114].setRotationPoint(-76.5F, 2.05F, -20F);
        body[114].rotationAngleZ = Static.toDegrees(-3.53429174F);

        body[115].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 166
        body[115].setRotationPoint(-76.5F, 2.05F, -20F);
        body[115].rotationAngleZ = Static.toDegrees(-3.92699082F);

        body[116].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 167
        body[116].setRotationPoint(-76.5F, 2.05F, -20F);
        body[116].rotationAngleZ = Static.toDegrees(-3.14159265F);

        body[117].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 168
        body[117].setRotationPoint(-76.5F, 2.05F, -20F);
        body[117].rotationAngleZ = Static.toDegrees(-2.74889357F);

        body[118].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 169
        body[118].setRotationPoint(-76.5F, 2.05F, -20F);
        body[118].rotationAngleZ = Static.toDegrees(-2.35619449F);

        body[119].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 170
        body[119].setRotationPoint(-76.5F, 2.05F, -20F);
        body[119].rotationAngleZ = Static.toDegrees(-1.96349541F);

        body[120].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 171
        body[120].setRotationPoint(-76.5F, 2.05F, -20F);
        body[120].rotationAngleZ = Static.toDegrees(-1.57079633F);

        body[121].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 172
        body[121].setRotationPoint(-76.5F, 2.05F, -20F);
        body[121].rotationAngleZ = Static.toDegrees(-1.17809725F);

        body[122].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 173
        body[122].setRotationPoint(-76.5F, 2.05F, -20F);
        body[122].rotationAngleZ = Static.toDegrees(-0.78539816F);

        body[123].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 174
        body[123].setRotationPoint(-76.5F, 2.05F, -20F);
        body[123].rotationAngleZ = Static.toDegrees(-0.39269908F);

        body[124].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 175
        body[124].setRotationPoint(-76.5F, 2.05F, -16F);

        body[125].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 176
        body[125].setRotationPoint(-76.5F, 2.05F, -16F);
        body[125].rotationAngleZ = Static.toDegrees(-0.39269908F);

        body[126].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 177
        body[126].setRotationPoint(-76.5F, 2.05F, -16F);
        body[126].rotationAngleZ = Static.toDegrees(-0.78539816F);

        body[127].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 178
        body[127].setRotationPoint(-76.5F, 2.05F, -16F);
        body[127].rotationAngleZ = Static.toDegrees(-1.17809725F);

        body[128].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 179
        body[128].setRotationPoint(-76.5F, 2.05F, -16F);
        body[128].rotationAngleZ = Static.toDegrees(-1.57079633F);

        body[129].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 180
        body[129].setRotationPoint(-76.5F, 2.05F, -16F);
        body[129].rotationAngleZ = Static.toDegrees(-1.96349541F);

        body[130].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 181
        body[130].setRotationPoint(-76.5F, 2.05F, -16F);
        body[130].rotationAngleZ = Static.toDegrees(-2.35619449F);

        body[131].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 182
        body[131].setRotationPoint(-76.5F, 2.05F, -16F);
        body[131].rotationAngleZ = Static.toDegrees(-2.74889357F);

        body[132].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 183
        body[132].setRotationPoint(-76.5F, 2.05F, -16F);
        body[132].rotationAngleZ = Static.toDegrees(-3.14159265F);

        body[133].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 184
        body[133].setRotationPoint(-76.5F, 2.05F, -16F);
        body[133].rotationAngleZ = Static.toDegrees(-3.53429174F);

        body[134].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 185
        body[134].setRotationPoint(-76.5F, 2.05F, -16F);
        body[134].rotationAngleZ = Static.toDegrees(-3.92699082F);

        body[135].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 186
        body[135].setRotationPoint(-76.5F, 2.05F, -16F);
        body[135].rotationAngleZ = Static.toDegrees(-4.3196899F);

        body[136].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 187
        body[136].setRotationPoint(-76.5F, 2.05F, -16F);
        body[136].rotationAngleZ = Static.toDegrees(-4.71238898F);

        body[137].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 188
        body[137].setRotationPoint(-76.5F, 2.05F, -16F);
        body[137].rotationAngleZ = Static.toDegrees(-5.10508806F);

        body[138].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 189
        body[138].setRotationPoint(-76.5F, 2.05F, -16F);
        body[138].rotationAngleZ = Static.toDegrees(-5.49778714F);

        body[139].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 190
        body[139].setRotationPoint(-76.5F, 2.05F, -16F);
        body[139].rotationAngleZ = Static.toDegrees(-5.89048623F);

        body[140].addBox(0F, 0F, 0F, 10, 1, 1, 0F); // Box 191
        body[140].setRotationPoint(-82F, -4.7F, -16.5F);

        body[141].addBox(0F, 0F, 0F, 10, 1, 1, 0F); // Box 192
        body[141].setRotationPoint(-82F, -4.7F, 14.5F);

        body[142].addBox(0F, 0F, 0F, 1, 1, 2, 0F); // Box 143
        body[142].setRotationPoint(-100.5F, -1.2F, -14.5F);

        body[143].addBox(0F, 0F, 0F, 1, 1, 2, 0F); // Box 144
        body[143].setRotationPoint(-100.5F, -1.2F, 11.5F);

        body[144].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 145
        body[144].setRotationPoint(-100.5F, -1.2F, 10.5F);

        body[145].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 146
        body[145].setRotationPoint(-100.5F, -1.2F, -12.5F);

        body[146].addBox(0F, 0F, 0F, 58, 10, 1, 0F); // Box 154
        body[146].setRotationPoint(-100F, -11.7F, -15.5F);

        body[147].addBox(0F, 0F, 0F, 67, 10, 1, 0F); // Box 178
        body[147].setRotationPoint(-100F, -11.7F, 13.5F);

        body[148].addBox(0F, 0F, 0F, 69, 1, 13, 0F); // Box 179
        body[148].setRotationPoint(-99F, -2F, -14.5F);

        body[149].addBox(0F, 0F, 0F, 69, 1, 13, 0F); // Box 180
        body[149].setRotationPoint(-99F, -2F, 0.5F);

        body[150].addBox(0F, 0F, 0F, 4, 10, 1, 0F); // Box 181
        body[150].setRotationPoint(-33F, -11.7F, 13.5F);

        body[151].addBox(0F, 0F, 0F, 4, 10, 1, 0F); // Box 182
        body[151].setRotationPoint(-33F, -11.7F, -15.5F);

        body[152].addBox(0F, 0F, 0F, 1, 10, 28, 0F); // Box 183
        body[152].setRotationPoint(-30F, -11.7F, -14.5F);

        body[153].addBox(0F, 0F, 0F, 1, 10, 28, 0F); // Box 184
        body[153].setRotationPoint(-100F, -11.7F, -14.5F);

        body[154].addBox(0F, 0F, 0F, 1, 13, 1, 0F); // Box 185
        body[154].setRotationPoint(-100F, -24.7F, -15.5F);

        body[155].addBox(0F, 0F, 0F, 1, 13, 1, 0F); // Box 188
        body[155].setRotationPoint(-100F, -24.7F, 13.5F);

        body[156].addBox(0F, 0F, 0F, 4, 13, 1, 0F); // Box 189
        body[156].setRotationPoint(-33F, -24.7F, 13.5F);

        body[157].addBox(0F, 0F, 0F, 1, 21, 6, 0F); // Box 192
        body[157].setRotationPoint(-79F, -23.7F, 7.5F);

        body[158].addBox(0F, 0F, 0F, 1, 21, 6, 0F); // Box 193
        body[158].setRotationPoint(-99F, -23.7F, 7.5F);

        body[159].addBox(0F, 0F, 0F, 19, 21, 1, 0F); // Box 196
        body[159].setRotationPoint(-98F, -23.7F, 12.5F);

        body[160].addShapeBox(0F, 0F, 0F, 71, 2, 30, 0F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 198
        body[160].setRotationPoint(-100F, -26.7F, -15.5F);

        body[161].addBox(0F, 0F, 0F, 19, 1, 5, 0F); // Box 207
        body[161].setRotationPoint(-98F, -23.7F, 7.5F);

        body[162].addBox(0F, 0F, 0F, 1, 20, 1, 0F); // Box 211
        body[162].setRotationPoint(-89F, -22.7F, 7.5F);

        body[163].addBox(0F, 0F, 0F, 21, 1, 6, 0F); // Box 187
        body[163].setRotationPoint(-99F, -2.7F, 7.5F);

        body[164].addBox(0F, 0F, 0F, 4, 13, 1, 0F); // Box 188
        body[164].setRotationPoint(-46F, -24.7F, -15.5F);

        body[165].addBox(0F, 0F, 0F, 4, 13, 1, 0F); // Box 189
        body[165].setRotationPoint(-33F, -24.7F, -15.5F);

        body[166].addBox(0F, 0F, 0F, 36, 13, 1, 0F); // Box 190
        body[166].setRotationPoint(-99F, -24.7F, 13.5F);

        body[167].addBox(0F, 0F, 0F, 14, 13, 1, 0F); // Box 191
        body[167].setRotationPoint(-47F, -24.7F, 13.5F);

        body[168].addBox(0F, 0F, 0F, 25, 13, 1, 0F); // Box 192
        body[168].setRotationPoint(-99F, -24.7F, -15.5F);

        body[169].addBox(0F, 0F, 0F, 16, 2, 1, 0F); // Box 193
        body[169].setRotationPoint(-63F, -24.7F, 13.5F);

        body[170].addBox(0F, 0F, 0F, 16, 4, 1, 0F); // Box 194
        body[170].setRotationPoint(-63F, -15.7F, 13.5F);

        body[171].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 195
        body[171].setRotationPoint(-63F, -16.7F, 13.5F);

        body[172].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F); // Box 196
        body[172].setRotationPoint(-63F, -22.7F, 13.5F);

        body[173].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 197
        body[173].setRotationPoint(-48F, -22.7F, 13.5F);

        body[174].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 198
        body[174].setRotationPoint(-48F, -16.7F, 13.5F);

        body[175].addBox(0F, 0F, 0F, 28, 3, 1, 0F); // Box 199
        body[175].setRotationPoint(-74F, -24.7F, -15.5F);

        body[176].addBox(0F, 0F, 0F, 28, 1, 1, 0F); // Box 200
        body[176].setRotationPoint(-74F, -12.7F, -15.5F);

        body[177].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 201
        body[177].setRotationPoint(-74F, -13.7F, -15.5F);

        body[178].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F); // Box 202
        body[178].setRotationPoint(-74F, -21.7F, -15.5F);

        body[179].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 203
        body[179].setRotationPoint(-47F, -13.7F, -15.5F);

        body[180].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 204
        body[180].setRotationPoint(-47F, -21.7F, -15.5F);

        body[181].addBox(0F, 0F, 0F, 1, 13, 28, 0F); // Box 205
        body[181].setRotationPoint(-30F, -24.7F, -14.5F);

        body[182].addBox(0F, 0F, 0F, 1, 13, 9, 0F); // Box 206
        body[182].setRotationPoint(-100F, -24.7F, -14.5F);

        body[183].addBox(0F, 0F, 0F, 1, 13, 9, 0F); // Box 207
        body[183].setRotationPoint(-100F, -24.7F, 4.5F);

        body[184].addBox(0F, 0F, 0F, 1, 3, 10, 0F); // Box 208
        body[184].setRotationPoint(-100F, -24.7F, -5.5F);

        body[185].addBox(0F, 0F, 0F, 1, 3, 10, 0F); // Box 209
        body[185].setRotationPoint(-100F, -14.7F, -5.5F);

        body[186].addBox(0F, 0F, 0F, 19, 1, 4, 0F); // Box 210
        body[186].setRotationPoint(-98F, -17.7F, 8.5F);

        body[187].addBox(0F, 0F, 0F, 19, 1, 4, 0F); // Box 211
        body[187].setRotationPoint(-98F, -12.7F, 8.5F);

        body[188].addBox(0F, 0F, 0F, 19, 1, 4, 0F); // Box 212
        body[188].setRotationPoint(-98F, -7.7F, 8.5F);

        body[189].addBox(0F, 0F, 0F, 29, 1, 7, 0F); // Box 213
        body[189].setRotationPoint(-78F, -12.7F, 6.5F);

        body[190].addBox(0F, 0F, 0F, 1, 10, 7, 0F); // Box 214
        body[190].setRotationPoint(-78F, -11.7F, 6.5F);

        body[191].addBox(0F, 0F, 0F, 1, 10, 7, 0F); // Box 215
        body[191].setRotationPoint(-31F, -11.7F, 6.5F);

        body[192].addBox(0F, 0F, 0F, 1, 8, 7, 0F); // Box 216
        body[192].setRotationPoint(-39F, -9.7F, 6.5F);

        body[193].addBox(0F, 0F, 0F, 1, 10, 7, 0F); // Box 217
        body[193].setRotationPoint(-50F, -11.7F, 6.5F);

        body[194].addBox(0F, 0F, 0F, 1, 10, 7, 0F); // Box 218
        body[194].setRotationPoint(-61F, -11.7F, 6.5F);

        body[195].addBox(0F, 0F, 0F, 1, 10, 7, 0F); // Box 219
        body[195].setRotationPoint(-72F, -11.7F, 6.5F);

        body[196].addBox(0F, 0F, 0F, 10, 1, 7, 0F); // Box 220
        body[196].setRotationPoint(-71F, -2.7F, 6.5F);

        body[197].addBox(0F, 0F, 0F, 10, 1, 7, 0F); // Box 221
        body[197].setRotationPoint(-60F, -2.7F, 6.5F);

        body[198].addBox(0F, 0F, 0F, 10, 1, 7, 0F); // Box 222
        body[198].setRotationPoint(-49F, -2.7F, 6.5F);

        body[199].addBox(0F, 0F, 0F, 7, 1, 7, 0F); // Box 223
        body[199].setRotationPoint(-38F, -2.7F, 6.5F);

        body[200].addBox(0F, 0F, 0F, 5, 1, 7, 0F); // Box 224
        body[200].setRotationPoint(-77F, -2.7F, 6.5F);

        body[201].addShapeBox(0F, 0F, 0F, 5, 9, 0, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 225
        body[201].setRotationPoint(-77F, -11.7F, 6.5F);

        body[202].addShapeBox(0F, 0F, 0F, 5, 9, 0, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 226
        body[202].setRotationPoint(-71F, -11.7F, 6.5F);

        body[203].addShapeBox(0F, 0F, 0F, 5, 9, 0, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 227
        body[203].setRotationPoint(-66F, -11.7F, 6.5F);

        body[204].addShapeBox(0F, 0F, 0F, 5, 9, 0, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 228
        body[204].setRotationPoint(-55F, -11.7F, 6.5F);

        body[205].addShapeBox(0F, 0F, 0F, 5, 9, 0, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 229
        body[205].setRotationPoint(-60F, -11.7F, 6.5F);

        body[206].addShapeBox(0F, 0F, 0F, 5, 7, 0, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 230
        body[206].setRotationPoint(-44F, -9.7F, 6.5F);

        body[207].addShapeBox(0F, 0F, 0F, 5, 7, 0, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 231
        body[207].setRotationPoint(-49F, -9.7F, 6.5F);

        body[208].addBox(0F, 0F, 0F, 7, 1, 1, 0F); // Box 232
        body[208].setRotationPoint(-38F, -3.7F, 6.5F);

        body[209].addBox(0F, 0F, 0F, 11, 3, 1, 0F); // Box 233
        body[209].setRotationPoint(-49F, -12.7F, 6.5F);

        body[210].addBox(0F, 0F, 0F, 11, 3, 2, 0F); // Box 234
        body[210].setRotationPoint(-49F, -12.7F, 11.5F);

        body[211].addBox(0F, 0F, 0F, 8, 1, 7, 0F); // Box 235
        body[211].setRotationPoint(-38F, -12.7F, 6.5F);

        body[212].addBox(0F, 0F, 0F, 2, 3, 4, 0F); // Box 236
        body[212].setRotationPoint(-49F, -12.7F, 7.5F);

        body[213].addBox(0F, 0F, 0F, 2, 3, 4, 0F); // Box 237
        body[213].setRotationPoint(-40F, -12.7F, 7.5F);

        body[214].addBox(0F, 0F, 0F, 7, 1, 4, 0F); // Box 238
        body[214].setRotationPoint(-47F, -9.7F, 7.5F);

        body[215].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 239
        body[215].setRotationPoint(-44F, -14.7F, 11.5F);

        body[216].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 240
        body[216].setRotationPoint(-43F, -13.5F, 11.5F);

        body[217].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 241
        body[217].setRotationPoint(-45F, -13.5F, 11.5F);

        body[218].addBox(0F, 0F, 0F, 31, 1, 7, 0F); // Box 242
        body[218].setRotationPoint(-73F, -11.7F, -14.5F);

        body[219].addBox(0F, 0F, 0F, 1, 9, 7, 0F); // Box 243
        body[219].setRotationPoint(-73F, -10.7F, -14.5F);

        body[220].addBox(0F, 0F, 0F, 5, 9, 7, 0F); // Box 244
        body[220].setRotationPoint(-47F, -10.7F, -14.5F);

        body[221].addBox(0F, 0F, 0F, 1, 9, 7, 0F); // Box 245
        body[221].setRotationPoint(-48F, -10.7F, -14.5F);

        body[222].addBox(0F, 0F, 0F, 7, 7, 7, 0F); // Box 246
        body[222].setRotationPoint(-55F, -8.7F, -14.5F);

        body[223].addBox(0F, 0F, 0F, 2, 9, 7, 0F); // Box 247
        body[223].setRotationPoint(-57F, -10.7F, -14.5F);

        body[224].addShapeBox(0F, 0F, 0F, 6, 2, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 248
        body[224].setRotationPoint(-54F, -13.7F, -14.5F);

        body[225].addShapeBox(0F, 0F, 0F, 5, 9, 0, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F); // Box 249
        body[225].setRotationPoint(-72F, -10.7F, -7.5F);

        body[226].addShapeBox(0F, 0F, 0F, 5, 9, 0, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F); // Box 250
        body[226].setRotationPoint(-67F, -10.7F, -7.5F);

        body[227].addShapeBox(0F, 0F, 0F, 5, 9, 0, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F); // Box 251
        body[227].setRotationPoint(-62F, -10.7F, -7.5F);

        body[228].addBox(0F, 0F, 0F, 7, 1, 1, 0F); // Box 252
        body[228].setRotationPoint(-38F, -9.7F, 6.5F);

        body[229].addBox(0F, 0F, 0F, 7, 2, 1, 0F); // Box 253
        body[229].setRotationPoint(-38F, -11.7F, 6.5F);

        body[230].addBox(0F, 0F, 0F, 1, 5, 1, 0F); // Box 254
        body[230].setRotationPoint(-38F, -8.7F, 6.5F);

        body[231].addBox(0F, 0F, 0F, 1, 5, 1, 0F); // Box 255
        body[231].setRotationPoint(-32F, -8.7F, 6.5F);

        body[232].addBox(0F, 0F, 0F, 7, 0, 7, 0F); // Box 256
        body[232].setRotationPoint(-38F, -6.7F, 7.5F);

        body[233].addBox(0F, 0F, 0F, 7, 0, 7, 0F); // Box 257
        body[233].setRotationPoint(-38F, -4.7F, 7.5F);

        body[234].addBox(0F, 0F, 0F, 28, 1, 6, 0F); // Box 258
        body[234].setRotationPoint(-74F, -22.7F, -21.5F);

        body[235].addBox(0F, 0F, 0F, 28, 1, 1, 0F); // Box 259
        body[235].setRotationPoint(-74F, -11.7F, -16.5F);

        body[236].addShapeBox(0F, 0F, 0F, 1, 9, 9, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 260
        body[236].setRotationPoint(-99F, -10.7F, -14.5F);

        body[237].addShapeBox(0F, 0F, 0F, 1, 9, 9, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 261
        body[237].setRotationPoint(-87F, -10.7F, -14.5F);

        body[238].addBox(0F, 0F, 0F, 1, 8, 8, 0F); // Box 262
        body[238].setRotationPoint(-93F, -9.7F, -14.5F);

        body[239].addBox(0F, 0F, 0F, 11, 9, 1, 0F); // Box 263
        body[239].setRotationPoint(-98F, -10.7F, -6.5F);

        body[240].addBox(0F, 0F, 0F, 5, 1, 8, 0F); // Box 264
        body[240].setRotationPoint(-92F, -5.7F, -14.5F);

        body[241].addBox(0F, 0F, 0F, 5, 1, 8, 0F); // Box 265
        body[241].setRotationPoint(-98F, -5.7F, -14.5F);

        body[242].addShapeBox(0F, 0F, 0F, 13, 1, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 266
        body[242].setRotationPoint(-86F, -5.7F, -14.5F);

        body[243].addShapeBox(0F, 0F, 0F, 13, 7, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F); // Box 267
        body[243].setRotationPoint(-86F, -12.7F, -14.5F);

        body[244].addBox(0F, 0F, 0F, 13, 3, 7, 0F); // Box 268
        body[244].setRotationPoint(-86F, -4.7F, -13.5F);

        body[245].addShapeBox(0F, 0F, 0F, 11, 1, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 269
        body[245].setRotationPoint(-98F, -13.7F, -14.5F);

        body[246].addBox(0F, 0F, 0F, 8, 1, 5, 0F); // Box 270
        body[246].setRotationPoint(-77F, -13.7F, 8.5F);

        body[247].addBox(0F, 0F, 0F, 8, 3, 1, 0F); // Box 271
        body[247].setRotationPoint(-77F, -16.7F, 12.5F);

        body[248].addBox(0F, 0F, 0F, 8, 1, 5, 0F); // Box 272
        body[248].setRotationPoint(-77F, -17.7F, 8.5F);

        body[249].addBox(0F, 0F, 0F, 1, 3, 4, 0F); // Box 273
        body[249].setRotationPoint(-77F, -16.7F, 8.5F);

        body[250].addBox(0F, 0F, 0F, 2, 3, 4, 0F); // Box 274
        body[250].setRotationPoint(-71F, -16.7F, 8.5F);

        body[251].addBox(0F, 0F, 0F, 9, 3, 1, 0F); // Box 275
        body[251].setRotationPoint(-42F, -24.7F, -15.5F);

        body[252].addBox(0F, 0F, 0F, 9, 14, 1, 0F); // Box 276
        body[252].setRotationPoint(-42F, -15.7F, -15.5F);

        body[253].addBox(0F, 0F, 0F, 1, 6, 1, 0F); // Box 277
        body[253].setRotationPoint(-42F, -21.7F, -15.5F);

        body[254].addBox(0F, 0F, 0F, 1, 6, 1, 0F); // Box 278
        body[254].setRotationPoint(-34F, -21.7F, -15.5F);

        body[255].addBox(0F, 0F, 0F, 9, 1, 2, 0F); // Box 279
        body[255].setRotationPoint(-42F, 0.3F, -16.5F);

        body[256].addBox(0F, 0F, 0F, 9, 1, 2, 0F); // Box 280
        body[256].setRotationPoint(-42F, 2.3F, -17.5F);

        body[257].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 281
        body[257].setRotationPoint(-35F, 1.3F, -16.5F);

        body[258].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 282
        body[258].setRotationPoint(-41F, 1.3F, -16.5F);

        body[259].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F); // Box 283
        body[259].setRotationPoint(-41F, -21.7F, -15.5F);

        body[260].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 284
        body[260].setRotationPoint(-35F, -21.7F, -15.5F);

        body[261].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 285
        body[261].setRotationPoint(-35F, -16.7F, -15.5F);

        body[262].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 286
        body[262].setRotationPoint(-41F, -16.7F, -15.5F);

        body[263].addBox(0F, 0F, 0F, 1, 1, 2, 0F); // Box 287
        body[263].setRotationPoint(-100.5F, -23.2F, -14.5F);

        body[264].addBox(0F, 0F, 0F, 1, 1, 2, 0F); // Box 288
        body[264].setRotationPoint(-100.5F, -23.2F, 11.5F);
        this.add("body", body); fixRotations();
    }

}