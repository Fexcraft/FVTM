package net.fexcraft.mod.addons.zmp.models.vehicle;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.vehicle.VehicleModel;

public class Model4x4Samu extends VehicleModel {

    public Model4x4Samu(){
    	super(); textureX = 512; textureY = 512;
        this.addToCreators("zackyboy18");
        this.addToCreators("FEX___96");
        ModelRendererTurbo[] body = new ModelRendererTurbo[278];
        body[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
        body[1] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 1
        body[2] = new ModelRendererTurbo(this, 49, 1, textureX, textureY); // Box 2
        body[3] = new ModelRendererTurbo(this, 65, 1, textureX, textureY); // Box 3
        body[4] = new ModelRendererTurbo(this, 89, 1, textureX, textureY); // Box 5
        body[5] = new ModelRendererTurbo(this, 113, 1, textureX, textureY); // Box 6
        body[6] = new ModelRendererTurbo(this, 137, 1, textureX, textureY); // Box 7
        body[7] = new ModelRendererTurbo(this, 161, 1, textureX, textureY); // Box 8
        body[8] = new ModelRendererTurbo(this, 185, 1, textureX, textureY); // Box 9
        body[9] = new ModelRendererTurbo(this, 209, 1, textureX, textureY); // Box 12
        body[10] = new ModelRendererTurbo(this, 273, 1, textureX, textureY); // Box 43
        body[11] = new ModelRendererTurbo(this, 289, 1, textureX, textureY); // Box 44
        body[12] = new ModelRendererTurbo(this, 305, 1, textureX, textureY); // Box 45
        body[13] = new ModelRendererTurbo(this, 321, 1, textureX, textureY); // Box 46
        body[14] = new ModelRendererTurbo(this, 337, 1, textureX, textureY); // Box 47
        body[15] = new ModelRendererTurbo(this, 353, 1, textureX, textureY); // Box 48
        body[16] = new ModelRendererTurbo(this, 369, 1, textureX, textureY); // Box 49
        body[17] = new ModelRendererTurbo(this, 385, 1, textureX, textureY); // Box 50
        body[18] = new ModelRendererTurbo(this, 401, 1, textureX, textureY); // Box 52
        body[19] = new ModelRendererTurbo(this, 417, 1, textureX, textureY); // Box 53
        body[20] = new ModelRendererTurbo(this, 433, 1, textureX, textureY); // Box 55
        body[21] = new ModelRendererTurbo(this, 457, 1, textureX, textureY); // Box 56
        body[22] = new ModelRendererTurbo(this, 481, 1, textureX, textureY); // Box 57
        body[23] = new ModelRendererTurbo(this, 1, 9, textureX, textureY); // Box 58
        body[24] = new ModelRendererTurbo(this, 25, 9, textureX, textureY); // Box 59
        body[25] = new ModelRendererTurbo(this, 89, 9, textureX, textureY); // Box 60
        body[26] = new ModelRendererTurbo(this, 201, 9, textureX, textureY); // Box 61
        body[27] = new ModelRendererTurbo(this, 225, 9, textureX, textureY); // Box 62
        body[28] = new ModelRendererTurbo(this, 249, 9, textureX, textureY); // Box 63
        body[29] = new ModelRendererTurbo(this, 129, 9, textureX, textureY); // Box 64
        body[30] = new ModelRendererTurbo(this, 17, 17, textureX, textureY); // Box 86
        body[31] = new ModelRendererTurbo(this, 41, 17, textureX, textureY); // Box 87
        body[32] = new ModelRendererTurbo(this, 505, 1, textureX, textureY); // Box 98
        body[33] = new ModelRendererTurbo(this, 505, 9, textureX, textureY); // Box 99
        body[34] = new ModelRendererTurbo(this, 65, 17, textureX, textureY); // Box 103
        body[35] = new ModelRendererTurbo(this, 121, 17, textureX, textureY); // Box 104
        body[36] = new ModelRendererTurbo(this, 145, 17, textureX, textureY); // Box 105
        body[37] = new ModelRendererTurbo(this, 201, 17, textureX, textureY); // Box 106
        body[38] = new ModelRendererTurbo(this, 225, 17, textureX, textureY); // Box 107
        body[39] = new ModelRendererTurbo(this, 281, 17, textureX, textureY); // Box 108
        body[40] = new ModelRendererTurbo(this, 305, 17, textureX, textureY); // Box 109
        body[41] = new ModelRendererTurbo(this, 361, 17, textureX, textureY); // Box 110
        body[42] = new ModelRendererTurbo(this, 385, 17, textureX, textureY); // Box 111
        body[43] = new ModelRendererTurbo(this, 433, 17, textureX, textureY); // Box 112
        body[44] = new ModelRendererTurbo(this, 353, 25, textureX, textureY); // Box 114
        body[45] = new ModelRendererTurbo(this, 401, 25, textureX, textureY); // Box 115
        body[46] = new ModelRendererTurbo(this, 441, 25, textureX, textureY); // Box 116
        body[47] = new ModelRendererTurbo(this, 1, 33, textureX, textureY); // Box 117
        body[48] = new ModelRendererTurbo(this, 481, 17, textureX, textureY); // Box 118
        body[49] = new ModelRendererTurbo(this, 1, 33, textureX, textureY); // Box 119
        body[50] = new ModelRendererTurbo(this, 49, 33, textureX, textureY); // Box 120
        body[51] = new ModelRendererTurbo(this, 73, 33, textureX, textureY); // Box 121
        body[52] = new ModelRendererTurbo(this, 97, 33, textureX, textureY); // Box 122
        body[53] = new ModelRendererTurbo(this, 153, 9, textureX, textureY); // Box 123
        body[54] = new ModelRendererTurbo(this, 121, 33, textureX, textureY); // Box 124
        body[55] = new ModelRendererTurbo(this, 145, 33, textureX, textureY); // Box 125
        body[56] = new ModelRendererTurbo(this, 169, 33, textureX, textureY); // Box 126
        body[57] = new ModelRendererTurbo(this, 193, 33, textureX, textureY); // Box 127
        body[58] = new ModelRendererTurbo(this, 257, 33, textureX, textureY); // Box 128
        body[59] = new ModelRendererTurbo(this, 249, 33, textureX, textureY); // Box 129
        body[60] = new ModelRendererTurbo(this, 49, 49, textureX, textureY); // Box 130
        body[61] = new ModelRendererTurbo(this, 297, 33, textureX, textureY); // Box 131
        body[62] = new ModelRendererTurbo(this, 321, 33, textureX, textureY); // Box 132
        body[63] = new ModelRendererTurbo(this, 401, 33, textureX, textureY); // Box 133
        body[64] = new ModelRendererTurbo(this, 345, 33, textureX, textureY); // Box 134
        body[65] = new ModelRendererTurbo(this, 401, 33, textureX, textureY); // Box 135
        body[66] = new ModelRendererTurbo(this, 449, 33, textureX, textureY); // Box 136
        body[67] = new ModelRendererTurbo(this, 177, 9, textureX, textureY); // Box 137
        body[68] = new ModelRendererTurbo(this, 473, 33, textureX, textureY); // Box 138
        body[69] = new ModelRendererTurbo(this, 65, 41, textureX, textureY); // Box 139
        body[70] = new ModelRendererTurbo(this, 361, 41, textureX, textureY); // Box 140
        body[71] = new ModelRendererTurbo(this, 401, 41, textureX, textureY); // Box 141
        body[72] = new ModelRendererTurbo(this, 449, 41, textureX, textureY); // Box 142
        body[73] = new ModelRendererTurbo(this, 1, 49, textureX, textureY); // Box 143
        body[74] = new ModelRendererTurbo(this, 201, 49, textureX, textureY); // Box 144
        body[75] = new ModelRendererTurbo(this, 209, 49, textureX, textureY); // Box 145
        body[76] = new ModelRendererTurbo(this, 81, 57, textureX, textureY); // Box 146
        body[77] = new ModelRendererTurbo(this, 305, 33, textureX, textureY); // Box 147
        body[78] = new ModelRendererTurbo(this, 89, 41, textureX, textureY); // Box 175
        body[79] = new ModelRendererTurbo(this, 105, 57, textureX, textureY); // Box 176
        body[80] = new ModelRendererTurbo(this, 305, 49, textureX, textureY); // Box 196
        body[81] = new ModelRendererTurbo(this, 137, 57, textureX, textureY); // Box 208
        body[82] = new ModelRendererTurbo(this, 89, 65, textureX, textureY); // Box 209
        body[83] = new ModelRendererTurbo(this, 177, 57, textureX, textureY); // Box 210
        body[84] = new ModelRendererTurbo(this, 481, 57, textureX, textureY); // Box 211
        body[85] = new ModelRendererTurbo(this, 241, 49, textureX, textureY); // Box 212
        body[86] = new ModelRendererTurbo(this, 65, 65, textureX, textureY); // Box 213
        body[87] = new ModelRendererTurbo(this, 1, 73, textureX, textureY); // Box 216
        body[88] = new ModelRendererTurbo(this, 353, 65, textureX, textureY); // Box 217
        body[89] = new ModelRendererTurbo(this, 185, 73, textureX, textureY); // Box 218
        body[90] = new ModelRendererTurbo(this, 241, 73, textureX, textureY); // Box 220
        body[91] = new ModelRendererTurbo(this, 57, 97, textureX, textureY); // Box 225
        body[92] = new ModelRendererTurbo(this, 449, 9, textureX, textureY); // Box 226
        body[93] = new ModelRendererTurbo(this, 473, 9, textureX, textureY); // Box 227
        body[94] = new ModelRendererTurbo(this, 1, 25, textureX, textureY); // Box 228
        body[95] = new ModelRendererTurbo(this, 497, 25, textureX, textureY); // Box 229
        body[96] = new ModelRendererTurbo(this, 57, 81, textureX, textureY); // Box 234
        body[97] = new ModelRendererTurbo(this, 233, 49, textureX, textureY); // Box 235
        body[98] = new ModelRendererTurbo(this, 57, 1, textureX, textureY); // Box 236
        body[99] = new ModelRendererTurbo(this, 17, 41, textureX, textureY); // Box 249
        body[100] = new ModelRendererTurbo(this, 505, 17, textureX, textureY); // Box 250
        body[101] = new ModelRendererTurbo(this, 249, 73, textureX, textureY); // Box 255
        body[102] = new ModelRendererTurbo(this, 473, 97, textureX, textureY); // Box 272
        body[103] = new ModelRendererTurbo(this, 1, 73, textureX, textureY); // Box 273
        body[104] = new ModelRendererTurbo(this, 249, 89, textureX, textureY); // Box 274
        body[105] = new ModelRendererTurbo(this, 177, 1, textureX, textureY); // Box 293
        body[106] = new ModelRendererTurbo(this, 201, 1, textureX, textureY); // Box 295
        body[107] = new ModelRendererTurbo(this, 265, 1, textureX, textureY); // Box 296
        body[108] = new ModelRendererTurbo(this, 449, 1, textureX, textureY); // Box 298
        body[109] = new ModelRendererTurbo(this, 201, 97, textureX, textureY); // Box 300
        body[110] = new ModelRendererTurbo(this, 361, 105, textureX, textureY); // Import B13
        body[111] = new ModelRendererTurbo(this, 1, 113, textureX, textureY); // Import B14
        body[112] = new ModelRendererTurbo(this, 241, 113, textureX, textureY); // Import B15
        body[113] = new ModelRendererTurbo(this, 49, 137, textureX, textureY); // Import B16
        body[114] = new ModelRendererTurbo(this, 145, 137, textureX, textureY); // Import B25
        body[115] = new ModelRendererTurbo(this, 409, 105, textureX, textureY); // Import B26
        body[116] = new ModelRendererTurbo(this, 473, 1, textureX, textureY); // Import L1
        body[117] = new ModelRendererTurbo(this, 497, 1, textureX, textureY); // Import L2
        body[118] = new ModelRendererTurbo(this, 17, 9, textureX, textureY); // Box 341
        body[119] = new ModelRendererTurbo(this, 81, 9, textureX, textureY); // Box 342
        body[120] = new ModelRendererTurbo(this, 49, 57, textureX, textureY); // Import D1
        body[121] = new ModelRendererTurbo(this, 289, 121, textureX, textureY); // Import D2
        body[122] = new ModelRendererTurbo(this, 297, 57, textureX, textureY); // Import D3
        body[123] = new ModelRendererTurbo(this, 209, 161, textureX, textureY); // Import D4
        body[124] = new ModelRendererTurbo(this, 449, 57, textureX, textureY); // Import D5
        body[125] = new ModelRendererTurbo(this, 289, 73, textureX, textureY); // Import D6
        body[126] = new ModelRendererTurbo(this, 129, 81, textureX, textureY); // Import D7
        body[127] = new ModelRendererTurbo(this, 401, 89, textureX, textureY); // Import D8
        body[128] = new ModelRendererTurbo(this, 289, 97, textureX, textureY); // Import D9
        body[129] = new ModelRendererTurbo(this, 169, 113, textureX, textureY); // Import D10
        body[130] = new ModelRendererTurbo(this, 425, 121, textureX, textureY); // Import D11
        body[131] = new ModelRendererTurbo(this, 105, 81, textureX, textureY); // Import B49
        body[132] = new ModelRendererTurbo(this, 289, 81, textureX, textureY); // Import B50
        body[133] = new ModelRendererTurbo(this, 1, 153, textureX, textureY); // Import B51
        body[134] = new ModelRendererTurbo(this, 1, 97, textureX, textureY); // Import B52
        body[135] = new ModelRendererTurbo(this, 217, 97, textureX, textureY); // Import B55
        body[136] = new ModelRendererTurbo(this, 49, 113, textureX, textureY); // Import HT1
        body[137] = new ModelRendererTurbo(this, 425, 33, textureX, textureY); // Import HT4
        body[138] = new ModelRendererTurbo(this, 409, 105, textureX, textureY); // Import HT5
        body[139] = new ModelRendererTurbo(this, 441, 113, textureX, textureY); // Import HT7
        body[140] = new ModelRendererTurbo(this, 377, 33, textureX, textureY); // Import HT9
        body[141] = new ModelRendererTurbo(this, 1, 113, textureX, textureY); // Import HT11
        body[142] = new ModelRendererTurbo(this, 17, 113, textureX, textureY); // Import HT13
        body[143] = new ModelRendererTurbo(this, 497, 9, textureX, textureY); // Import HT15
        body[144] = new ModelRendererTurbo(this, 497, 33, textureX, textureY); // Import HT18
        body[145] = new ModelRendererTurbo(this, 353, 161, textureX, textureY); // Import HT1a
        body[146] = new ModelRendererTurbo(this, 57, 97, textureX, textureY); // Import B53
        body[147] = new ModelRendererTurbo(this, 249, 113, textureX, textureY); // Import B54
        body[148] = new ModelRendererTurbo(this, 425, 161, textureX, textureY); // Import HT2
        body[149] = new ModelRendererTurbo(this, 273, 49, textureX, textureY); // Import HT3
        body[150] = new ModelRendererTurbo(this, 265, 113, textureX, textureY); // Import HT6
        body[151] = new ModelRendererTurbo(this, 169, 121, textureX, textureY); // Import HT8
        body[152] = new ModelRendererTurbo(this, 113, 65, textureX, textureY); // Import HT10
        body[153] = new ModelRendererTurbo(this, 289, 113, textureX, textureY); // Import HT12
        body[154] = new ModelRendererTurbo(this, 305, 113, textureX, textureY); // Import HT14
        body[155] = new ModelRendererTurbo(this, 153, 41, textureX, textureY); // Import HT16
        body[156] = new ModelRendererTurbo(this, 185, 41, textureX, textureY); // Import HT17
        body[157] = new ModelRendererTurbo(this, 49, 121, textureX, textureY); // Import HT2a
        body[158] = new ModelRendererTurbo(this, 337, 41, textureX, textureY); // Import Sp1
        body[159] = new ModelRendererTurbo(this, 105, 9, textureX, textureY); // Import Sp2
        body[160] = new ModelRendererTurbo(this, 161, 41, textureX, textureY); // Import Sp3
        body[161] = new ModelRendererTurbo(this, 297, 49, textureX, textureY); // Import Sp4
        body[162] = new ModelRendererTurbo(this, 217, 9, textureX, textureY); // Import Sp5
        body[163] = new ModelRendererTurbo(this, 353, 49, textureX, textureY); // Import Sp6
        body[164] = new ModelRendererTurbo(this, 241, 9, textureX, textureY); // Box 410
        body[165] = new ModelRendererTurbo(this, 177, 57, textureX, textureY); // Box 370
        body[166] = new ModelRendererTurbo(this, 33, 17, textureX, textureY); // Box 371
        body[167] = new ModelRendererTurbo(this, 57, 17, textureX, textureY); // Box 372
        body[168] = new ModelRendererTurbo(this, 265, 9, textureX, textureY); // Box 373
        body[169] = new ModelRendererTurbo(this, 137, 17, textureX, textureY); // Box 374
        body[170] = new ModelRendererTurbo(this, 217, 17, textureX, textureY); // Box 375
        body[171] = new ModelRendererTurbo(this, 297, 17, textureX, textureY); // Box 376
        body[172] = new ModelRendererTurbo(this, 377, 17, textureX, textureY); // Box 377
        body[173] = new ModelRendererTurbo(this, 497, 17, textureX, textureY); // Box 378
        body[174] = new ModelRendererTurbo(this, 473, 57, textureX, textureY); // Box 379
        body[175] = new ModelRendererTurbo(this, 17, 33, textureX, textureY); // Box 380
        body[176] = new ModelRendererTurbo(this, 9, 25, textureX, textureY); // Box 381
        body[177] = new ModelRendererTurbo(this, 505, 25, textureX, textureY); // Box 382
        body[178] = new ModelRendererTurbo(this, 65, 33, textureX, textureY); // Box 383
        body[179] = new ModelRendererTurbo(this, 89, 33, textureX, textureY); // Box 384
        body[180] = new ModelRendererTurbo(this, 113, 33, textureX, textureY); // Box 385
        body[181] = new ModelRendererTurbo(this, 137, 33, textureX, textureY); // Box 386
        body[182] = new ModelRendererTurbo(this, 161, 33, textureX, textureY); // Box 387
        body[183] = new ModelRendererTurbo(this, 17, 57, textureX, textureY); // Box 307
        body[184] = new ModelRendererTurbo(this, 241, 65, textureX, textureY); // Box 309
        body[185] = new ModelRendererTurbo(this, 321, 65, textureX, textureY); // Box 310
        body[186] = new ModelRendererTurbo(this, 185, 33, textureX, textureY); // Box 311
        body[187] = new ModelRendererTurbo(this, 369, 65, textureX, textureY); // Box 9
        body[188] = new ModelRendererTurbo(this, 17, 73, textureX, textureY); // Box 11
        body[189] = new ModelRendererTurbo(this, 1, 121, textureX, textureY); // Box 173
        body[190] = new ModelRendererTurbo(this, 289, 121, textureX, textureY); // Box 174
        body[191] = new ModelRendererTurbo(this, 361, 121, textureX, textureY); // Box 175
        body[192] = new ModelRendererTurbo(this, 313, 73, textureX, textureY); // Box 402
        body[193] = new ModelRendererTurbo(this, 177, 81, textureX, textureY); // Box 403
        body[194] = new ModelRendererTurbo(this, 465, 121, textureX, textureY); // Box 404
        body[195] = new ModelRendererTurbo(this, 481, 129, textureX, textureY); // Box 405
        body[196] = new ModelRendererTurbo(this, 465, 137, textureX, textureY); // Box 406
        body[197] = new ModelRendererTurbo(this, 489, 113, textureX, textureY); // Box 407
        body[198] = new ModelRendererTurbo(this, 1, 137, textureX, textureY); // Box 408
        body[199] = new ModelRendererTurbo(this, 49, 137, textureX, textureY); // Box 409
        body[200] = new ModelRendererTurbo(this, 369, 73, textureX, textureY); // Box 410
        body[201] = new ModelRendererTurbo(this, 297, 89, textureX, textureY); // Box 411
        body[202] = new ModelRendererTurbo(this, 425, 97, textureX, textureY); // Box 412
        body[203] = new ModelRendererTurbo(this, 249, 33, textureX, textureY); // Box 413
        body[204] = new ModelRendererTurbo(this, 225, 137, textureX, textureY); // Box 7
        body[205] = new ModelRendererTurbo(this, 1, 153, textureX, textureY); // Box 8
        body[206] = new ModelRendererTurbo(this, 289, 137, textureX, textureY); // Box 428
        body[207] = new ModelRendererTurbo(this, 49, 153, textureX, textureY); // Box 429
        body[208] = new ModelRendererTurbo(this, 17, 177, textureX, textureY); // Box 526
        body[209] = new ModelRendererTurbo(this, 361, 33, textureX, textureY); // Box 527
        body[210] = new ModelRendererTurbo(this, 369, 33, textureX, textureY); // Box 528
        body[211] = new ModelRendererTurbo(this, 377, 129, textureX, textureY); // Box 532
        body[212] = new ModelRendererTurbo(this, 49, 193, textureX, textureY); // Box 533
        body[213] = new ModelRendererTurbo(this, 73, 193, textureX, textureY); // Box 534
        body[214] = new ModelRendererTurbo(this, 225, 137, textureX, textureY); // Box 582
        body[215] = new ModelRendererTurbo(this, 289, 137, textureX, textureY); // Box 583
        body[216] = new ModelRendererTurbo(this, 313, 137, textureX, textureY); // Box 584
        body[217] = new ModelRendererTurbo(this, 273, 153, textureX, textureY); // Box 572
        body[218] = new ModelRendererTurbo(this, 393, 153, textureX, textureY); // Box 573
        body[219] = new ModelRendererTurbo(this, 409, 153, textureX, textureY); // Box 574
        body[220] = new ModelRendererTurbo(this, 145, 209, textureX, textureY); // Box 259
        body[221] = new ModelRendererTurbo(this, 193, 81, textureX, textureY); // Box 260
        body[222] = new ModelRendererTurbo(this, 425, 49, textureX, textureY); // Box 590
        body[223] = new ModelRendererTurbo(this, 25, 57, textureX, textureY); // Box 591
        body[224] = new ModelRendererTurbo(this, 177, 217, textureX, textureY); // Box 592
        body[225] = new ModelRendererTurbo(this, 161, 57, textureX, textureY); // Box 593
        body[226] = new ModelRendererTurbo(this, 505, 57, textureX, textureY); // Box 594
        body[227] = new ModelRendererTurbo(this, 265, 217, textureX, textureY); // Box 595
        body[228] = new ModelRendererTurbo(this, 241, 89, textureX, textureY); // Box 370
        body[229] = new ModelRendererTurbo(this, 409, 121, textureX, textureY); // Box 371
        body[230] = new ModelRendererTurbo(this, 441, 209, textureX, textureY); // Box 372
        body[231] = new ModelRendererTurbo(this, 321, 217, textureX, textureY); // Box 373
        body[232] = new ModelRendererTurbo(this, 361, 217, textureX, textureY); // Box 374
        body[233] = new ModelRendererTurbo(this, 377, 217, textureX, textureY); // Box 375
        body[234] = new ModelRendererTurbo(this, 25, 81, textureX, textureY); // Box 376
        body[235] = new ModelRendererTurbo(this, 505, 193, textureX, textureY); // Box 377
        body[236] = new ModelRendererTurbo(this, 393, 217, textureX, textureY); // Box 378
        body[237] = new ModelRendererTurbo(this, 425, 217, textureX, textureY); // Box 383
        body[238] = new ModelRendererTurbo(this, 481, 217, textureX, textureY); // Box 385
        body[239] = new ModelRendererTurbo(this, 329, 65, textureX, textureY); // Box 390
        body[240] = new ModelRendererTurbo(this, 353, 65, textureX, textureY); // Box 391
        body[241] = new ModelRendererTurbo(this, 1, 225, textureX, textureY); // Box 392
        body[242] = new ModelRendererTurbo(this, 457, 217, textureX, textureY); // Box 393
        body[243] = new ModelRendererTurbo(this, 1, 225, textureX, textureY); // Box 394
        body[244] = new ModelRendererTurbo(this, 41, 225, textureX, textureY); // Box 375
        body[245] = new ModelRendererTurbo(this, 121, 225, textureX, textureY); // Box 376
        body[246] = new ModelRendererTurbo(this, 241, 65, textureX, textureY); // Box 377
        body[247] = new ModelRendererTurbo(this, 241, 73, textureX, textureY); // Box 378
        body[248] = new ModelRendererTurbo(this, 153, 225, textureX, textureY); // Box 379
        body[249] = new ModelRendererTurbo(this, 201, 225, textureX, textureY); // Box 380
        body[250] = new ModelRendererTurbo(this, 25, 145, textureX, textureY); // Box 383
        body[251] = new ModelRendererTurbo(this, 73, 145, textureX, textureY); // Box 384
        body[252] = new ModelRendererTurbo(this, 497, 153, textureX, textureY); // Box 385
        body[253] = new ModelRendererTurbo(this, 505, 33, textureX, textureY); // Box 386
        body[254] = new ModelRendererTurbo(this, 81, 65, textureX, textureY); // Box 387
        body[255] = new ModelRendererTurbo(this, 105, 65, textureX, textureY); // Box 388
        body[256] = new ModelRendererTurbo(this, 249, 225, textureX, textureY); // Box 389
        body[257] = new ModelRendererTurbo(this, 281, 225, textureX, textureY); // Box 390
        body[258] = new ModelRendererTurbo(this, 329, 73, textureX, textureY); // Box 391
        body[259] = new ModelRendererTurbo(this, 377, 73, textureX, textureY); // Box 392
        body[260] = new ModelRendererTurbo(this, 97, 81, textureX, textureY); // Box 393
        body[261] = new ModelRendererTurbo(this, 505, 81, textureX, textureY); // Box 394
        body[262] = new ModelRendererTurbo(this, 273, 89, textureX, textureY); // Box 395
        body[263] = new ModelRendererTurbo(this, 209, 97, textureX, textureY); // Box 396
        body[264] = new ModelRendererTurbo(this, 297, 225, textureX, textureY); // Box 397
        body[265] = new ModelRendererTurbo(this, 41, 241, textureX, textureY); // Box 399
        body[266] = new ModelRendererTurbo(this, 505, 97, textureX, textureY); // Box 400
        body[267] = new ModelRendererTurbo(this, 25, 113, textureX, textureY); // Box 401
        body[268] = new ModelRendererTurbo(this, 33, 113, textureX, textureY); // Box 402
        body[269] = new ModelRendererTurbo(this, 313, 113, textureX, textureY); // Box 403
        body[270] = new ModelRendererTurbo(this, 505, 113, textureX, textureY); // Box 404
        body[271] = new ModelRendererTurbo(this, 273, 153, textureX, textureY); // Box 376
        body[272] = new ModelRendererTurbo(this, 393, 153, textureX, textureY); // Box 377
        body[273] = new ModelRendererTurbo(this, 409, 153, textureX, textureY); // Box 378
        body[274] = new ModelRendererTurbo(this, 225, 137, textureX, textureY); // Box 379
        body[275] = new ModelRendererTurbo(this, 289, 137, textureX, textureY); // Box 380
        body[276] = new ModelRendererTurbo(this, 313, 137, textureX, textureY); // Box 381
        body[277] = new ModelRendererTurbo(this, 249, 33, textureX, textureY); // Box 380

        body[0].addShapeBox(0F, 0F, 0F, 4, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 0
        body[0].setRotationPoint(34F, 0F, 15F);

        body[1].addShapeBox(0F, 0F, 0F, 4, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 1
        body[1].setRotationPoint(39F, 0F, -19F);

        body[2].addBox(0F, 0F, 0F, 1, 2, 4, 0F); // Box 2
        body[2].setRotationPoint(38F, 0F, 15F);

        body[3].addShapeBox(0F, 0F, 0F, 4, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F); // Box 3
        body[3].setRotationPoint(30F, 0F, 15F);

        body[4].addShapeBox(0F, 0F, 0F, 4, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, 0F, 0F); // Box 5
        body[4].setRotationPoint(43F, 0F, 15F);

        body[5].addShapeBox(0F, 0F, 0F, 4, 6, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 6
        body[5].setRotationPoint(26F, 0F, 15F);

        body[6].addShapeBox(0F, 0F, 0F, 4, 6, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 7
        body[6].setRotationPoint(47F, 0F, 15F);

        body[7].addShapeBox(0F, 0F, 0F, 4, 6, 4, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 8
        body[7].setRotationPoint(48F, 6F, 16F);

        body[8].addShapeBox(0F, 0F, 0F, 4, 6, 4, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -2F, 0F, 0F, -2F, 0F); // Box 9
        body[8].setRotationPoint(25F, 6F, 16F);

        body[9].addBox(0F, 0F, 0F, 25, 3, 4, 0F); // Box 12
        body[9].setRotationPoint(26F, -3F, 15F);

        body[10].addShapeBox(0F, 0F, 0F, 3, 6, 4, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, -1F, 0F); // Box 43
        body[10].setRotationPoint(52F, 6F, 16F);

        body[11].addShapeBox(0F, 0F, 0F, 3, 6, 4, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 44
        body[11].setRotationPoint(52F, 6F, 12F);

        body[12].addShapeBox(0F, 0F, 0F, 3, 6, 4, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 45
        body[12].setRotationPoint(52F, 6F, 8F);

        body[13].addShapeBox(0F, 0F, 0F, 3, 6, 4, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 46
        body[13].setRotationPoint(52F, 6F, 4F);

        body[14].addShapeBox(0F, 0F, 0F, 3, 6, 4, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 47
        body[14].setRotationPoint(52F, 6F, 0F);

        body[15].addShapeBox(0F, 0F, 0F, 3, 6, 4, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 48
        body[15].setRotationPoint(52F, 6F, -4F);

        body[16].addShapeBox(0F, 0F, 0F, 3, 6, 4, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 49
        body[16].setRotationPoint(52F, 6F, -8F);

        body[17].addShapeBox(0F, 0F, 0F, 3, 6, 4, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 50
        body[17].setRotationPoint(52F, 6F, -12F);

        body[18].addShapeBox(0F, 0F, 0F, 3, 6, 4, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 52
        body[18].setRotationPoint(52F, 6F, -16F);

        body[19].addShapeBox(0F, 0F, 0F, 3, 6, 4, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 53
        body[19].setRotationPoint(52F, 6F, -20F);

        body[20].addShapeBox(0F, 0F, 0F, 4, 6, 4, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 55
        body[20].setRotationPoint(48F, 6F, -20F);

        body[21].addShapeBox(0F, 0F, 0F, 4, 6, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 56
        body[21].setRotationPoint(47F, 0F, -19F);

        body[22].addShapeBox(0F, 0F, 0F, 4, 6, 4, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 57
        body[22].setRotationPoint(25F, 6F, -20F);

        body[23].addShapeBox(0F, 0F, 0F, 4, 6, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 58
        body[23].setRotationPoint(26F, 0F, -19F);

        body[24].addBox(0F, 0F, 0F, 25, 3, 4, 0F); // Box 59
        body[24].setRotationPoint(26F, -3F, -19F);

        body[25].addShapeBox(0F, 0F, 0F, 4, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F); // Box 60
        body[25].setRotationPoint(30F, 0F, -19F);

        body[26].addShapeBox(0F, 0F, 0F, 4, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, 0F, 0F); // Box 61
        body[26].setRotationPoint(43F, 0F, -19F);

        body[27].addShapeBox(0F, 0F, 0F, 4, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 62
        body[27].setRotationPoint(34F, 0F, -19F);

        body[28].addShapeBox(0F, 0F, 0F, 4, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 63
        body[28].setRotationPoint(39F, 0F, 15F);

        body[29].addBox(0F, 0F, 0F, 1, 2, 4, 0F); // Box 64
        body[29].setRotationPoint(38F, 0F, -19F);

        body[30].addBox(0F, 0F, 0F, 4, 11, 4, 0F); // Box 86
        body[30].setRotationPoint(22F, -5F, 15F);

        body[31].addBox(0F, 0F, 0F, 4, 11, 4, 0F); // Box 87
        body[31].setRotationPoint(22F, -5F, -19F);

        body[32].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 98
        body[32].setRotationPoint(55.5F, 8.5F, -15.5F);

        body[33].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 99
        body[33].setRotationPoint(55.5F, 8.5F, 13.5F);

        body[34].addShapeBox(0F, 0F, 0F, 22, 6, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -2F, 0F, 0F, -2F, 0F); // Box 103
        body[34].setRotationPoint(3F, 6F, 16F);

        body[35].addBox(0F, 0F, 0F, 4, 11, 4, 0F); // Box 104
        body[35].setRotationPoint(2F, -5F, 15F);

        body[36].addShapeBox(0F, 0F, 0F, 22, 6, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 105
        body[36].setRotationPoint(3F, 6F, -20F);

        body[37].addBox(0F, 0F, 0F, 4, 11, 4, 0F); // Box 106
        body[37].setRotationPoint(2F, -5F, -19F);

        body[38].addShapeBox(0F, 0F, 0F, 22, 6, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -2F, 0F, 0F, -2F, 0F); // Box 107
        body[38].setRotationPoint(-18F, 6F, 16F);

        body[39].addBox(1F, 0F, 0F, 4, 11, 4, 0F); // Box 108
        body[39].setRotationPoint(-20F, -5F, 15F);

        body[40].addShapeBox(0F, 0F, 0F, 22, 6, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 109
        body[40].setRotationPoint(-18F, 6F, -20F);

        body[41].addBox(0F, 0F, 34F, 4, 11, 4, 0F); // Box 110
        body[41].setRotationPoint(-19F, -5F, -53F);

        body[42].addBox(0F, 0F, 0F, 19, 3, 4, 0F); // Box 111
        body[42].setRotationPoint(22F, 8F, 7F);

        body[43].addBox(0F, 0F, 0F, 19, 3, 4, 0F); // Box 112
        body[43].setRotationPoint(22F, 8F, -11F);

        body[44].addBox(0F, 0F, 0F, 4, 3, 32, 0F); // Box 114
        body[44].setRotationPoint(22F, 8F, -16F);

        body[45].addBox(0F, 0F, 0F, 14, 3, 4, 0F); // Box 115
        body[45].setRotationPoint(39F, 8F, 7F);

        body[46].addBox(0F, 0F, 0F, 14, 3, 4, 0F); // Box 116
        body[46].setRotationPoint(39F, 8F, -11F);

        body[47].addShapeBox(0F, 0F, 0F, 4, 3, 32, 0F, -2F, 0F, 0F, 2F, -0.5F, 0F, 2F, -0.5F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 117
        body[47].setRotationPoint(22F, -4F, -16F);

        body[48].addShapeBox(0F, 0F, 0F, 4, 6, 4, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -2F, 0F, 0F, -2F, 0F); // Box 118
        body[48].setRotationPoint(-22F, 6F, 16F);

        body[49].addShapeBox(0F, 0F, 0F, 4, 6, 4, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 119
        body[49].setRotationPoint(-22F, 6F, -20F);

        body[50].addShapeBox(0F, 0F, 0F, 4, 6, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 120
        body[50].setRotationPoint(-23F, 0F, -19F);

        body[51].addShapeBox(0F, 0F, 0F, 4, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, 0F, 0F); // Box 121
        body[51].setRotationPoint(-27F, 0F, -19F);

        body[52].addShapeBox(0F, 0F, 0F, 4, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 122
        body[52].setRotationPoint(-31F, 0F, -19F);

        body[53].addBox(0F, 0F, 0F, 1, 2, 4, 0F); // Box 123
        body[53].setRotationPoint(-32F, 0F, -19F);

        body[54].addShapeBox(0F, 0F, 0F, 4, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 124
        body[54].setRotationPoint(-36F, 0F, -19F);

        body[55].addShapeBox(0F, 0F, 0F, 4, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F); // Box 125
        body[55].setRotationPoint(-40F, 0F, -19F);

        body[56].addShapeBox(0F, 0F, 0F, 4, 6, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 126
        body[56].setRotationPoint(-44F, 0F, -19F);

        body[57].addBox(0F, 0F, 0F, 25, 5, 4, 0F); // Box 127
        body[57].setRotationPoint(-44F, -5F, -19F);

        body[58].addBox(0F, 0F, 0F, 4, 11, 4, 0F); // Box 128
        body[58].setRotationPoint(-48F, -5F, -19F);

        body[59].addBox(0F, 0F, 0F, 4, 3, 32, 0F); // Box 129
        body[59].setRotationPoint(-21F, 8F, -16F);

        body[60].addBox(0F, 0F, 0F, 69, 3, 4, 0F); // Box 130
        body[60].setRotationPoint(-43F, 8F, -1F);

        body[61].addShapeBox(0F, 0F, 0F, 4, 6, 4, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 131
        body[61].setRotationPoint(-45F, 6F, -20F);

        body[62].addShapeBox(0F, 0F, 0F, 4, 6, 4, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 132
        body[62].setRotationPoint(-45F, 6F, 16F);

        body[63].addBox(0F, 0F, 0F, 4, 3, 32, 0F); // Box 133
        body[63].setRotationPoint(-45F, 8F, -16F);

        body[64].addShapeBox(0F, 0F, 0F, 4, 6, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 134
        body[64].setRotationPoint(-23F, 0F, 15F);

        body[65].addShapeBox(0F, 0F, 0F, 4, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, 0F, 0F); // Box 135
        body[65].setRotationPoint(-27F, 0F, 15F);

        body[66].addShapeBox(0F, 0F, 0F, 4, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 136
        body[66].setRotationPoint(-31F, 0F, 15F);

        body[67].addBox(0F, 0F, 0F, 1, 2, 4, 0F); // Box 137
        body[67].setRotationPoint(-32F, 0F, 15F);

        body[68].addShapeBox(0F, 0F, 0F, 4, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 138
        body[68].setRotationPoint(-36F, 0F, 15F);

        body[69].addShapeBox(0F, 0F, 0F, 4, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F); // Box 139
        body[69].setRotationPoint(-40F, 0F, 15F);

        body[70].addShapeBox(0F, 0F, 0F, 4, 6, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 140
        body[70].setRotationPoint(-44F, 0F, 15F);

        body[71].addBox(0F, 0F, 0F, 4, 11, 4, 0F); // Box 141
        body[71].setRotationPoint(-48F, -5F, 15F);

        body[72].addBox(0F, 0F, 0F, 25, 5, 4, 0F); // Box 142
        body[72].setRotationPoint(-44F, -5F, 15F);

        body[73].addShapeBox(0F, 0F, 0F, 4, 6, 4, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 143
        body[73].setRotationPoint(-49F, 6F, 16F);

        body[74].addShapeBox(0F, 0F, 0F, 4, 6, 4, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 144
        body[74].setRotationPoint(-49F, 6F, -20F);

        body[75].addShapeBox(0F, 0F, 0F, 4, 6, 11, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 145
        body[75].setRotationPoint(-49F, 6F, 5F);

        body[76].addShapeBox(0F, 0F, 0F, 4, 6, 11, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 146
        body[76].setRotationPoint(-49F, 6F, -16F);

        body[77].addShapeBox(0F, 0F, 0F, 2, 6, 11, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 147
        body[77].setRotationPoint(-47F, 6F, -6F);

        body[78].addBox(0F, 0F, 0F, 25, 3, 4, 0F); // Box 175
        body[78].setRotationPoint(-42F, 8F, 7F);

        body[79].addBox(0F, 0F, 0F, 25, 3, 4, 0F); // Box 176
        body[79].setRotationPoint(-42F, 8F, -11F);

        body[80].addBox(0F, 0F, 0F, 4, 9, 32, 0F); // Box 196
        body[80].setRotationPoint(22F, -1F, -16F);

        body[81].addBox(0F, 0F, 0F, 3, 2, 30, 0F); // Box 208
        body[81].setRotationPoint(-48F, -6F, -15F);

        body[82].addBox(0F, 0F, 0F, 4, 1, 30, 0F); // Box 209
        body[82].setRotationPoint(-48F, 5F, -15F);

        body[83].addBox(0F, 0F, 0F, 3, 10, 10, 0F); // Box 210
        body[83].setRotationPoint(-48F, -4F, 5F);

        body[84].addBox(0F, 0F, 0F, 3, 10, 10, 0F); // Box 211
        body[84].setRotationPoint(-48F, -4F, -15F);

        body[85].addBox(0F, 0F, 0F, 3, 4, 10, 0F); // Box 212
        body[85].setRotationPoint(-48F, 1F, -5F);

        body[86].addBox(0F, 0F, 0F, 1, 5, 10, 0F); // Box 213
        body[86].setRotationPoint(-46F, -4F, -5F);

        body[87].addBox(0F, 0F, 0F, 10, 2, 32, 0F); // Box 216
        body[87].setRotationPoint(-25F, 6F, -16F);

        body[88].addBox(0F, 0F, 0F, 5, 2, 32, 0F); // Box 217
        body[88].setRotationPoint(-44F, 6F, -16F);

        body[89].addBox(0F, 0F, 0F, 14, 3, 20, 0F); // Box 218
        body[89].setRotationPoint(-39F, 6F, -10F);

        body[90].addBox(0F, 0F, 0F, 14, 5, 5, 0F); // Box 220
        body[90].setRotationPoint(-39F, 2F, -15F);

        body[91].addBox(0F, 0F, 0F, 37, 2, 32, 0F); // Box 225
        body[91].setRotationPoint(-15F, 6F, -16F);

        body[92].addBox(0F, 0F, 0F, 1, 3, 4, 0F); // Box 226
        body[92].setRotationPoint(-48.5F, -1F, 15F);

        body[93].addBox(0F, 0F, 0F, 1, 3, 4, 0F); // Box 227
        body[93].setRotationPoint(-48.5F, -1F, -19F);

        body[94].addBox(0F, 0F, 0F, 1, 2, 4, 0F); // Box 228
        body[94].setRotationPoint(-48.5F, 2.5F, -19F);

        body[95].addBox(0F, 0F, 0F, 1, 2, 4, 0F); // Box 229
        body[95].setRotationPoint(-48.5F, 2.5F, 15F);

        body[96].addShapeBox(0F, 0F, 0F, 16, 6, 6, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 234
        body[96].setRotationPoint(6F, 0F, -3F);

        body[97].addShapeBox(0F, 0F, 0F, 2, 3, 6, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 235
        body[97].setRotationPoint(20F, -3F, -3F);

        body[98].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 236
        body[98].setRotationPoint(21F, -3F, 9F);

        body[99].addShapeBox(0F, 0F, 0F, 1, 2, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F); // Box 249
        body[99].setRotationPoint(23.1F, -3.1F, -12F);

        body[100].addBox(0F, -4F, 0F, 1, 4, 1, 0F); // Box 250
        body[100].setRotationPoint(21F, -4F, 5F);
        body[100].rotateAngleZ = -0.6981317F;

        body[101].addBox(0F, 0F, 0F, 1, 2, 32, 0F); // Box 255
        body[101].setRotationPoint(24.8F, -6F, -16F);

        body[102].addBox(0F, 0F, 0F, 8, 2, 10, 0F); // Box 272
        body[102].setRotationPoint(-8F, 2F, 6F);

        body[103].addShapeBox(0F, 0F, 0F, 1, 12, 10, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 273
        body[103].setRotationPoint(-1F, -10F, 6F);

        body[104].addBox(0F, 0F, 0F, 7, 2, 8, 0F); // Box 274
        body[104].setRotationPoint(-8F, 4F, 7F);

        body[105].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // Box 293
        body[105].setRotationPoint(-1F, -22F, 14.5F);

        body[106].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // Box 295
        body[106].setRotationPoint(-46F, -22F, 14F);

        body[107].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // Box 296
        body[107].setRotationPoint(-46F, -22F, -15F);

        body[108].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // Box 298
        body[108].setRotationPoint(-1F, -22F, -15.5F);

        body[109].addShapeBox(0F, 0F, 0F, 4, 2, 33, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 300
        body[109].setRotationPoint(-2F, -24F, -16.5F);

        body[110].addShapeBox(0F, 0F, 0F, 2, 8, 38, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F); // Import B13
        body[110].setRotationPoint(51F, -2F, -19F);

        body[111].addShapeBox(0F, 0F, 0F, 2, 1, 38, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Import B14
        body[111].setRotationPoint(51F, -3F, -19F);

        body[112].addShapeBox(0F, 0F, 0F, 1, 1, 38, 0F, 0F, 0F, -1F, -0.9999F, 0F, -1F, -0.9999F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Import B15
        body[112].setRotationPoint(51F, -4F, -19F);

        body[113].addShapeBox(0F, 0F, 0F, 25, 1, 38, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Import B16
        body[113].setRotationPoint(26F, -4F, -19F);

        body[114].addShapeBox(0F, 0F, 0F, 26, 15, 20, 0F, 0F, 0F, 5F, 0F, -1.5F, 0F, 0F, -1.5F, 0F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 5F); // Import B25
        body[114].setRotationPoint(26F, -7F, -10F);

        body[115].addShapeBox(0F, 0F, 0F, 2, 14, 20, 0F, 0F, 0F, 0F, 0F, -2F, -0.5F, 0F, -2F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F); // Import B26
        body[115].setRotationPoint(52F, -5.5F, -10F);

        body[116].addBox(0F, 0F, 0F, 2, 1, 1, 0F); // Import L1
        body[116].setRotationPoint(50.9F, 3F, 16F);

        body[117].addBox(0F, 0F, 0F, 2, 1, 1, 0F); // Import L2
        body[117].setRotationPoint(50.9F, 0F, 16F);

        body[118].addBox(0F, 0F, 0F, 2, 1, 1, 0F); // Box 341
        body[118].setRotationPoint(50.9F, 0F, -17F);

        body[119].addBox(0F, 0F, 0F, 2, 1, 1, 0F); // Box 342
        body[119].setRotationPoint(50.9F, 3F, -17F);

        body[120].addShapeBox(0F, 0F, 0F, 15, 4, 1, 0F, 0F, 0F, -0.6F, 0F, -3.9999F, -0.1F, 0F, -3.9999F, -0.3F, 0F, 0F, 0.2F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.3F, 0F, 0F, -0.3F); // Import D1
        body[120].setRotationPoint(5F, -21F, -18F);

        body[121].addShapeBox(0F, 0F, 0F, 15, 4, 34, 0F, 0F, 0F, 0.3F, 0F, -3.9999F, 0.3F, 0F, -3.9999F, 0.3F, 0F, 0F, 0.3F, 0F, -3.4F, 0.3F, -0.6F, 0F, 0.3F, -0.6F, 0F, 0.3F, 0F, -3.4F, 0.3F); // Import D2
        body[121].setRotationPoint(5F, -21F, -17F);

        body[122].addShapeBox(0F, 0F, 0F, 15, 4, 1, 0F, 0F, 0F, 0.2F, 0F, -3.9999F, -0.3F, 0F, -3.9999F, -0.1F, 0F, 0F, -0.6F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.1F, 0F, 0F, -0.1F); // Import D3
        body[122].setRotationPoint(5F, -21F, 17F);

        body[123].addShapeBox(0F, 0F, 0F, 52, 1, 34, 0F, 0.3F, 0F, 0.3F, 0F, 0F, 0.3F, 0F, 0F, 0.3F, 0.3F, 0F, 0.3F, 0.3F, -0.4F, 0.3F, 0F, -0.4F, 0.3F, 0F, -0.4F, 0.3F, 0.3F, -0.4F, 0.3F); // Import D4
        body[123].setRotationPoint(-47F, -21F, -17F);

        body[124].addShapeBox(0F, 0F, 0F, 10, 4, 1, 0F, 0F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.6F, 0F, 0F, -0.6F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.1F, 0F, 0F, -0.1F); // Import D5
        body[124].setRotationPoint(-5F, -21F, 17F);

        body[125].addShapeBox(0F, 0F, 0F, 10, 4, 1, 0F, 0F, 0F, -0.6F, 0F, 0F, -0.6F, 0F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.3F, 0F, 0F, -0.3F); // Import D6
        body[125].setRotationPoint(-5F, -21F, -18F);

        body[126].addShapeBox(0F, 0F, 0F, 16, 1, 1, 0F, 0F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.6F, 0F, 0F, -0.6F, 0F, 0F, 0.075F, 0F, 0F, 0.075F, 0F, 0F, -0.475F, 0F, 0F, -0.475F); // Import D7
        body[126].setRotationPoint(-21F, -21F, 17F);

        body[127].addShapeBox(0F, 0F, 0F, 16, 1, 1, 0F, 0F, 0F, -0.6F, 0F, 0F, -0.6F, 0F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.475F, 0F, 0F, -0.475F, 0F, 0F, 0.075F, 0F, 0F, 0.075F); // Import D8
        body[127].setRotationPoint(-21F, -21F, -18F);

        body[128].addShapeBox(0F, 0F, 0F, 27, 4, 1, 0F, -0.1F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.6F, -0.1F, 0F, -0.6F, -0.1F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.1F, -0.1F, 0F, -0.1F); // Import D9
        body[128].setRotationPoint(-48F, -21F, 17F);

        body[129].addShapeBox(0F, 0F, 0F, 27, 4, 1, 0F, -0.1F, 0F, -0.6F, 0F, 0F, -0.6F, 0F, 0F, 0.2F, -0.1F, 0F, 0.2F, -0.1F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.3F, -0.1F, 0F, -0.3F); // Import D10
        body[129].setRotationPoint(-48F, -21F, -18F);

        body[130].addShapeBox(0F, 0F, 0F, 1, 4, 34, 0F, -0.1F, 0F, 0.3F, -0.3F, 0F, 0.3F, -0.3F, 0F, 0.3F, -0.1F, 0F, 0.3F, -0.1F, 0F, 0.3F, -0.3F, 0F, 0.3F, -0.3F, 0F, 0.3F, -0.1F, 0F, 0.3F); // Import D11
        body[130].setRotationPoint(-48F, -21F, -17F);

        body[131].addShapeBox(0F, 0F, 0F, 3, 11, 1, 0F, 3.5F, 0F, 1F, -5F, 0F, 1F, -5F, 0F, -1F, 3.5F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Import B49
        body[131].setRotationPoint(23F, -16F, 18F);

        body[132].addShapeBox(0F, 0F, 0F, 3, 11, 1, 0F, 3.5F, 0F, -1F, -5F, 0F, -1F, -5F, 0F, 1F, 3.5F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Import B50
        body[132].setRotationPoint(23F, -16F, -19F);

        body[133].addShapeBox(0F, 0F, 0F, 2, 1, 36, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Import B51
        body[133].setRotationPoint(19F, -17F, -18F);

        body[134].addBox(0F, 0F, 0F, 13, 1, 1, 0F); // Import B52
        body[134].setRotationPoint(6F, -17F, 17F);

        body[135].addShapeBox(0F, 0F, 0F, 3, 12, 1, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Import B55
        body[135].setRotationPoint(3F, -17F, 18F);

        body[136].addShapeBox(0F, 0F, 0F, 18, 1, 1, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Import HT1
        body[136].setRotationPoint(-16F, -17F, 17F);

        body[137].addShapeBox(0F, 0F, 0F, 1, 12, 1, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Import HT4
        body[137].setRotationPoint(2F, -17F, 18F);

        body[138].addShapeBox(0F, 0F, 0F, 4, 11, 1, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Import HT5
        body[138].setRotationPoint(-19F, -16F, 18F);

        body[139].addShapeBox(0F, 0F, 0F, 25, 2, 1, 0F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.1F, 0F, 0F, -0.1F); // Import HT7
        body[139].setRotationPoint(-44F, -7F, 18F);

        body[140].addShapeBox(0F, 0F, 0F, 1, 9, 1, 0F, 0F, 0F, 0.6F, 0F, 0F, 0.6F, 0F, 0F, -1.2F, 0F, 0F, -1.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.4F, 0F, 0F, -0.4F); // Import HT9
        body[140].setRotationPoint(-31.5F, -16F, 18F);

        body[141].addShapeBox(0F, 0F, 0F, 4, 11, 1, 0F, -0.1F, 0F, 0.7F, 0F, 0F, 0.7F, 0F, 0F, -1.1F, -0.1F, 0F, -1.1F, -0.1F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.1F, -0.1F, 0F, -0.1F); // Import HT11
        body[141].setRotationPoint(-48F, -16F, 18F);

        body[142].addShapeBox(0F, 0F, 0F, 1, 11, 3, 0F, -0.1F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.1F, 0F, 0F); // Import HT13
        body[142].setRotationPoint(-48F, -16F, 12F);

        body[143].addShapeBox(0F, 0F, 0F, 1, 1, 5, 0F, -0.1F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0.3F, -0.1F, 0F, 0.3F, -0.1F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0.3F, -0.1F, 0F, 0.3F); // Import HT15
        body[143].setRotationPoint(-48F, -17F, 12F);

        body[144].addShapeBox(0F, 0F, 0F, 1, 2, 3, 0F, -0.1F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0.3F, -0.1F, 0F, 0.3F, -0.1F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0.3F, -0.1F, 0F, 0.3F); // Import HT18
        body[144].setRotationPoint(-48F, -7F, 15F);

        body[145].addShapeBox(0F, 0F, 0F, 32, 1, 1, 0F, -0.1F, 0F, -0.3F, 1F, 0F, -0.3F, 1F, 0F, -0.1F, -0.1F, 0F, -0.1F, -0.1F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.1F, -0.1F, 0F, -0.1F); // Import HT1a
        body[145].setRotationPoint(-48F, -17F, 17F);

        body[146].addBox(0F, 0F, 0F, 13, 1, 1, 0F); // Import B53
        body[146].setRotationPoint(6F, -17F, -18F);

        body[147].addShapeBox(0F, 0F, 0F, 3, 12, 1, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Import B54
        body[147].setRotationPoint(3F, -17F, -19F);

        body[148].addShapeBox(0F, 0F, 0F, 32, 1, 1, 0F, -0.1F, 0F, -0.1F, 1F, 0F, -0.1F, 1F, 0F, -0.3F, -0.1F, 0F, -0.3F, -0.1F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.3F, -0.1F, 0F, -0.3F); // Import HT2
        body[148].setRotationPoint(-48F, -17F, -18F);

        body[149].addShapeBox(0F, 0F, 0F, 1, 12, 1, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Import HT3
        body[149].setRotationPoint(2F, -17F, -19F);

        body[150].addShapeBox(0F, 0F, 0F, 4, 11, 1, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Import HT6
        body[150].setRotationPoint(-19F, -16F, -19F);

        body[151].addShapeBox(0F, 0F, 0F, 25, 2, 1, 0F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.3F, 0F, 0F, -0.3F); // Import HT8
        body[151].setRotationPoint(-44F, -7F, -19F);

        body[152].addShapeBox(0F, 0F, 0F, 1, 9, 1, 0F, 0F, 0F, -1.2F, 0F, 0F, -1.2F, 0F, 0F, 0.6F, 0F, 0F, 0.6F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.2F, 0F, 0F, -0.2F); // Import HT10
        body[152].setRotationPoint(-31.5F, -16F, -19F);

        body[153].addShapeBox(0F, 0F, 0F, 4, 11, 1, 0F, -0.1F, 0F, -1.1F, 0F, 0F, -1.1F, 0F, 0F, 0.7F, -0.1F, 0F, 0.7F, -0.1F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.3F, -0.1F, 0F, -0.3F); // Import HT12
        body[153].setRotationPoint(-48F, -16F, -19F);

        body[154].addShapeBox(0F, 0F, 0F, 1, 11, 3, 0F, -0.1F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.1F, 0F, 0F); // Import HT14
        body[154].setRotationPoint(-48F, -16F, -15F);

        body[155].addShapeBox(0F, 0F, 0F, 1, 1, 5, 0F, -0.1F, 0F, 0.3F, -0.3F, 0F, 0.3F, -0.3F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0.3F, -0.3F, 0F, 0.3F, -0.3F, 0F, 0F, -0.1F, 0F, 0F); // Import HT16
        body[155].setRotationPoint(-48F, -17F, -17F);

        body[156].addShapeBox(0F, 0F, 0F, 1, 2, 3, 0F, -0.1F, 0F, 0.3F, -0.3F, 0F, 0.3F, -0.3F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0.3F, -0.3F, 0F, 0.3F, -0.3F, 0F, 0F, -0.1F, 0F, 0F); // Import HT17
        body[156].setRotationPoint(-48F, -7F, -18F);

        body[157].addShapeBox(0F, 0F, 0F, 18, 1, 1, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Import HT2a
        body[157].setRotationPoint(-16F, -17F, -18F);

        body[158].addBox(0F, 0F, 0F, 1, 4, 3, 0F); // Import Sp1
        body[158].setRotationPoint(22F, -9.5F, -23F);
        body[158].rotateAngleY = -0.17453293F;

        body[159].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Import Sp2
        body[159].setRotationPoint(22F, -5.5F, -21F);
        body[159].rotateAngleY = 0.1745329F;

        body[160].addBox(0F, 0F, -2F, 1, 1, 3, 0F); // Import Sp3
        body[160].setRotationPoint(22F, -4.5F, -23F);
        body[160].rotateAngleY = 0.1745329F;

        body[161].addBox(0F, 0F, -3F, 1, 4, 3, 0F); // Import Sp4
        body[161].setRotationPoint(23F, -9.5F, 17F);
        body[161].rotateAngleY = 0.17453293F;

        body[162].addBox(0F, 0F, -1F, 1, 1, 1, 0F); // Import Sp5
        body[162].setRotationPoint(23F, -5.5F, 19F);
        body[162].rotateAngleY = -0.1745329F;

        body[163].addBox(0F, 0F, -1F, 1, 1, 3, 0F); // Import Sp6
        body[163].setRotationPoint(23F, -4.5F, 17F);
        body[163].rotateAngleY = -0.1745329F;

        body[164].addBox(0F, 0F, 0F, 2, 1, 1, 0F); // Box 410
        body[164].setRotationPoint(-50F, -3F, -6F);

        body[165].addBox(0F, 0F, 0F, 2, 2, 2, 0F); // Box 370
        body[165].setRotationPoint(50.9F, 1F, -14F);

        body[166].addBox(0F, 0F, 0F, 2, 1, 2, 0F); // Box 371
        body[166].setRotationPoint(50.9F, 0F, -14F);

        body[167].addBox(0F, 0F, 0F, 2, 1, 2, 0F); // Box 372
        body[167].setRotationPoint(50.9F, 3F, -14F);

        body[168].addShapeBox(0F, 0F, 0F, 2, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 373
        body[168].setRotationPoint(50.9F, 3F, -12F);

        body[169].addShapeBox(0F, 0F, 0F, 2, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 374
        body[169].setRotationPoint(50.9F, 0F, -12F);

        body[170].addShapeBox(0F, 0F, 0F, 2, 1, 1, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 375
        body[170].setRotationPoint(50.9F, 0F, -15F);

        body[171].addShapeBox(0F, 0F, 0F, 2, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 376
        body[171].setRotationPoint(50.9F, 3F, -15F);

        body[172].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // Box 377
        body[172].setRotationPoint(50.9F, 1F, -12F);

        body[173].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // Box 378
        body[173].setRotationPoint(50.9F, 1F, -15F);

        body[174].addBox(0F, 0F, 0F, 2, 2, 2, 0F); // Box 379
        body[174].setRotationPoint(50.9F, 1F, 12F);

        body[175].addBox(0F, 0F, 0F, 2, 1, 2, 0F); // Box 380
        body[175].setRotationPoint(50.9F, 0F, 12F);

        body[176].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // Box 381
        body[176].setRotationPoint(50.9F, 1F, 11F);

        body[177].addShapeBox(0F, 0F, 0F, 2, 1, 1, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 382
        body[177].setRotationPoint(50.9F, 0F, 11F);

        body[178].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // Box 383
        body[178].setRotationPoint(50.9F, 1F, 14F);

        body[179].addShapeBox(0F, 0F, 0F, 2, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 384
        body[179].setRotationPoint(50.9F, 0F, 14F);

        body[180].addShapeBox(0F, 0F, 0F, 2, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 385
        body[180].setRotationPoint(50.9F, 3F, 14F);

        body[181].addBox(0F, 0F, 0F, 2, 1, 2, 0F); // Box 386
        body[181].setRotationPoint(50.9F, 3F, 12F);

        body[182].addShapeBox(0F, 0F, 0F, 2, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 387
        body[182].setRotationPoint(50.9F, 3F, 11F);

        body[183].addShapeBox(0F, 0F, 0F, 1, 2, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 307
        body[183].setRotationPoint(-35F, 10F, -2.5F);

        body[184].addShapeBox(0F, 0F, 0F, 1, 1, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F); // Box 309
        body[184].setRotationPoint(-35F, 12F, -2.5F);

        body[185].addShapeBox(0F, 0F, 0F, 1, 1, 5, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 310
        body[185].setRotationPoint(-35F, 9F, -2.5F);

        body[186].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 311
        body[186].setRotationPoint(-35F, 10F, 2.5F);

        body[187].addShapeBox(0F, 0F, 0F, 4, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 9
        body[187].setRotationPoint(-33.5F, 11F, 5.5F);

        body[188].addShapeBox(0F, 0F, 0F, 4, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 11
        body[188].setRotationPoint(-33.5F, 11F, -7.5F);

        body[189].addShapeBox(0F, 0F, 0F, 1, 3, 11, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 173
        body[189].setRotationPoint(-31F, 11F, 7.5F);

        body[190].addShapeBox(0F, 0F, 0F, 1, 3, 11, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 174
        body[190].setRotationPoint(-32F, 11F, 7.5F);

        body[191].addShapeBox(0F, 0F, 0F, 1, 3, 11, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 175
        body[191].setRotationPoint(-33F, 11F, 7.5F);

        body[192].addShapeBox(0F, 0F, 0F, 4, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 402
        body[192].setRotationPoint(36.5F, 11F, -7.5F);

        body[193].addShapeBox(0F, 0F, 0F, 4, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 403
        body[193].setRotationPoint(36.5F, 11F, 5.5F);

        body[194].addShapeBox(0F, 0F, 0F, 1, 3, 11, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 404
        body[194].setRotationPoint(38F, 11F, 7.5F);

        body[195].addShapeBox(0F, 0F, 0F, 1, 3, 11, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 405
        body[195].setRotationPoint(37F, 11F, 7.5F);

        body[196].addShapeBox(0F, 0F, 0F, 1, 3, 11, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 406
        body[196].setRotationPoint(39F, 11F, 7.5F);

        body[197].addShapeBox(0F, 0F, 0F, 1, 3, 10, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 407
        body[197].setRotationPoint(39F, 11F, -17.5F);

        body[198].addShapeBox(0F, 0F, 0F, 1, 3, 10, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 408
        body[198].setRotationPoint(38F, 11F, -17.5F);

        body[199].addShapeBox(0F, 0F, 0F, 1, 3, 10, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 409
        body[199].setRotationPoint(37F, 11F, -17.5F);

        body[200].addShapeBox(0F, 0F, 0F, 1, 1, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F); // Box 410
        body[200].setRotationPoint(35F, 13F, -2.5F);

        body[201].addShapeBox(0F, 0F, 0F, 1, 2, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 411
        body[201].setRotationPoint(35F, 11F, -2.5F);

        body[202].addShapeBox(0F, 0F, 0F, 1, 1, 5, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 412
        body[202].setRotationPoint(35F, 10F, -2.5F);

        body[203].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 413
        body[203].setRotationPoint(35F, 11F, 2.5F);

        body[204].addShapeBox(0F, 0F, 0F, 5, 1, 9, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 7
        body[204].setRotationPoint(-34F, 14.5F, -4.5F);

        body[205].addShapeBox(0F, 0F, 0F, 5, 4, 11, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 8
        body[205].setRotationPoint(-34F, 10.5F, -5.5F);

        body[206].addShapeBox(0F, 0F, 0F, 5, 1, 9, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 428
        body[206].setRotationPoint(36F, 14.5F, -4.5F);

        body[207].addShapeBox(0F, 0F, 0F, 5, 4, 11, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 429
        body[207].setRotationPoint(36F, 10.5F, -5.5F);

        body[208].addBox(0F, 0F, 0F, 1, 3, 8, 0F); // Box 526
        body[208].setRotationPoint(1F, -13.5F, 7F);

        body[209].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 527
        body[209].setRotationPoint(1F, -11F, 13F);

        body[210].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 528
        body[210].setRotationPoint(1F, -11F, 8F);

        body[211].addShapeBox(0F, 0F, 0F, 1, 3, 9, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 532
        body[211].setRotationPoint(-33F, 11F, -16.5F);

        body[212].addShapeBox(0F, 0F, 0F, 1, 3, 9, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 533
        body[212].setRotationPoint(-32F, 11F, -16.5F);

        body[213].addShapeBox(0F, 0F, 0F, 1, 3, 9, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 534
        body[213].setRotationPoint(-31F, 11F, -16.5F);

        body[214].addShapeBox(0F, 0F, 0F, 1, 3, 3, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 582
        body[214].setRotationPoint(-31F, 11F, 16F);

        body[215].addShapeBox(0F, 0F, 0F, 1, 3, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 583
        body[215].setRotationPoint(-32F, 11F, 16F);

        body[216].addShapeBox(0F, 0F, 0F, 1, 3, 3, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 584
        body[216].setRotationPoint(-33F, 11F, 16F);

        body[217].addShapeBox(0F, 0F, 0F, 1, 3, 3, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 572
        body[217].setRotationPoint(39F, 11F, 16F);

        body[218].addShapeBox(0F, 0F, 0F, 1, 3, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 573
        body[218].setRotationPoint(38F, 11F, 16F);

        body[219].addShapeBox(0F, 0F, 0F, 1, 3, 3, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 574
        body[219].setRotationPoint(37F, 11F, 16F);

        body[220].addShapeBox(0F, 0F, 0F, 4, 4, 10, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F); // Box 259
        body[220].setRotationPoint(21F, -6F, 4F);

        body[221].addShapeBox(0F, 0F, 0F, 2, 2, 2, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F); // Box 260
        body[221].setRotationPoint(19F, -6F, 8F);

        body[222].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 590
        body[222].setRotationPoint(19F, 10F, 18F);

        body[223].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 591
        body[223].setRotationPoint(-16F, 10F, 18F);

        body[224].addShapeBox(0F, 0F, 0F, 39, 1, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 592
        body[224].setRotationPoint(-17F, 12F, 18F);

        body[225].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 593
        body[225].setRotationPoint(19F, 10F, -19F);

        body[226].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 594
        body[226].setRotationPoint(-16F, 10F, -19F);

        body[227].addShapeBox(0F, 0F, 0F, 39, 1, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 595
        body[227].setRotationPoint(-17F, 12F, -20F);

        body[228].addShapeBox(0F, 0F, 0F, 4, 1, 2, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 370
        body[228].setRotationPoint(-47F, -23F, 13.5F);

        body[229].addShapeBox(0F, 0F, 0F, 4, 1, 2, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 371
        body[229].setRotationPoint(-47F, -23F, -15.5F);

        body[230].addBox(0F, 0F, 0F, 2, 11, 32, 0F); // Box 372
        body[230].setRotationPoint(3F, -5F, -16F);

        body[231].addBox(0F, 0F, 0F, 2, 4, 34, 0F); // Box 373
        body[231].setRotationPoint(3F, -20F, -17F);

        body[232].addBox(0F, 0F, 0F, 2, 11, 2, 0F); // Box 374
        body[232].setRotationPoint(3F, -16F, 15F);

        body[233].addBox(0F, 0F, 0F, 2, 11, 2, 0F); // Box 375
        body[233].setRotationPoint(3F, -16F, -17F);

        body[234].addBox(0F, 0F, 0F, 2, 11, 1, 0F); // Box 376
        body[234].setRotationPoint(3F, -16F, -5F);

        body[235].addBox(0F, 0F, 0F, 2, 11, 1, 0F); // Box 377
        body[235].setRotationPoint(3F, -16F, 4F);

        body[236].addShapeBox(0F, 0F, 0F, 2, 11, 12, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 378
        body[236].setRotationPoint(3F, -16F, -17F);

        body[237].addBox(0F, 0F, 0F, 2, 11, 10, 0F); // Box 383
        body[237].setRotationPoint(3F, -16F, 5F);

        body[238].addBox(0F, 0F, 0F, 2, 4, 8, 0F); // Box 385
        body[238].setRotationPoint(3F, -16F, -4F);

        body[239].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 390
        body[239].setRotationPoint(55.5F, 8.5F, -13.5F);

        body[240].addBox(0F, 0F, 0F, 1, 2, 2, 0F); // Box 391
        body[240].setRotationPoint(55.5F, 8.5F, 11.5F);

        body[241].addBox(0F, 0F, 0F, 2, 1, 34, 0F); // Box 392
        body[241].setRotationPoint(-19F, -17F, -17F);

        body[242].addBox(0F, 0F, 0F, 2, 11, 2, 0F); // Box 393
        body[242].setRotationPoint(-19F, -16F, 15F);

        body[243].addBox(0F, 0F, 0F, 2, 11, 2, 0F); // Box 394
        body[243].setRotationPoint(-19F, -16F, -17F);

        body[244].addBox(0F, 0F, 0F, 30, 2, 12, 0F); // Box 375
        body[244].setRotationPoint(-41F, 2F, -9F);

        body[245].addBox(0F, 0F, 0F, 3, 1, 10, 0F); // Box 376
        body[245].setRotationPoint(-14.2F, 1F, -8F);

        body[246].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 377
        body[246].setRotationPoint(-13.2F, 4F, 1F);

        body[247].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 378
        body[247].setRotationPoint(-13.2F, 4F, -8F);

        body[248].addBox(0F, 0F, 0F, 18, 7, 4, 0F); // Box 379
        body[248].setRotationPoint(-36F, -16F, 12F);

        body[249].addBox(0F, 0F, 0F, 26, 10, 6, 0F); // Box 380
        body[249].setRotationPoint(-44F, -4F, 10F);

        body[250].addTrapezoid(0F, 0F, 0F, 3, 4, 1, 0F, 1.00F, ModelRendererTurbo.MR_BACK); // Box 383
        body[250].setRotationPoint(-34.5F, -14.5F, 11F);

        body[251].addTrapezoid(0F, 0F, 0F, 3, 4, 1, 0F, 1.00F, ModelRendererTurbo.MR_BACK); // Box 384
        body[251].setRotationPoint(-28.5F, -14.5F, 11F);

        body[252].addTrapezoid(0F, 0F, 0F, 3, 4, 1, 0F, 1.00F, ModelRendererTurbo.MR_BACK); // Box 385
        body[252].setRotationPoint(-22.5F, -14.5F, 11F);

        body[253].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 386
        body[253].setRotationPoint(-20.5F, -12.5F, 10.5F);

        body[254].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 387
        body[254].setRotationPoint(-26.5F, -12.5F, 10.5F);

        body[255].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 388
        body[255].setRotationPoint(-32.5F, -12.5F, 10.5F);

        body[256].addBox(0F, 0F, 0F, 4, 8, 20, 0F); // Box 389
        body[256].setRotationPoint(-1F, -2F, -15F);

        body[257].addShapeBox(0F, 0F, 0F, 4, 4, 6, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 390
        body[257].setRotationPoint(-1F, -6F, -3F);

        body[258].addBox(0F, 0F, 0F, 1, 3, 1, 0F); // Box 391
        body[258].setRotationPoint(0F, -7F, 2F);

        body[259].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 392
        body[259].setRotationPoint(-41.2F, 1F, 2F);

        body[260].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 393
        body[260].setRotationPoint(-36.2F, 1F, 2F);

        body[261].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 394
        body[261].setRotationPoint(-31.2F, 1F, 2F);

        body[262].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 395
        body[262].setRotationPoint(-26.2F, 1F, 2F);

        body[263].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 396
        body[263].setRotationPoint(-21.2F, 1F, 2F);

        body[264].addBox(0F, 0F, 0F, 25, 1, 1, 0F); // Box 397
        body[264].setRotationPoint(-41.2F, 0F, 2F);

        body[265].addBox(0F, 0F, 0F, 25, 1, 1, 0F); // Box 399
        body[265].setRotationPoint(-41.2F, 0F, -9F);

        body[266].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 400
        body[266].setRotationPoint(-36.2F, 1F, -9F);

        body[267].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 401
        body[267].setRotationPoint(-41.2F, 1F, -9F);

        body[268].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 402
        body[268].setRotationPoint(-31.2F, 1F, -9F);

        body[269].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 403
        body[269].setRotationPoint(-26.2F, 1F, -9F);

        body[270].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 404
        body[270].setRotationPoint(-21.2F, 1F, -9F);

        body[271].addShapeBox(0F, 0F, 0F, 1, 3, 3, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 376
        body[271].setRotationPoint(39F, 11F, -19F);

        body[272].addShapeBox(0F, 0F, 0F, 1, 3, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 377
        body[272].setRotationPoint(38F, 11F, -19F);

        body[273].addShapeBox(0F, 0F, 0F, 1, 3, 3, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 378
        body[273].setRotationPoint(37F, 11F, -19F);

        body[274].addShapeBox(0F, 0F, 0F, 1, 3, 3, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 379
        body[274].setRotationPoint(-31F, 11F, -19F);

        body[275].addShapeBox(0F, 0F, 0F, 1, 3, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 380
        body[275].setRotationPoint(-32F, 11F, -19F);

        body[276].addShapeBox(0F, 0F, 0F, 1, 3, 3, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 381
        body[276].setRotationPoint(-33F, 11F, -19F);

        body[277].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 380
        body[277].setRotationPoint(35F, 11F, -3.5F);
        this.add("body", body);

        ModelRendererTurbo[] body_door_close = new ModelRendererTurbo[8];
        body_door_close[0] = new ModelRendererTurbo(this, 401, 73, textureX, textureY); // Box 230
        body_door_close[1] = new ModelRendererTurbo(this, 441, 73, textureX, textureY); // Box 231
        body_door_close[2] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 232
        body_door_close[3] = new ModelRendererTurbo(this, 41, 1, textureX, textureY); // Box 233
        body_door_close[4] = new ModelRendererTurbo(this, 321, 105, textureX, textureY); // Box 267
        body_door_close[5] = new ModelRendererTurbo(this, 129, 1, textureX, textureY); // Box 268
        body_door_close[6] = new ModelRendererTurbo(this, 361, 105, textureX, textureY); // Box 269
        body_door_close[7] = new ModelRendererTurbo(this, 153, 1, textureX, textureY); // Box 270

        body_door_close[0].addBox(0F, 0F, 34F, 17, 11, 2, 0F); // Box 230
        body_door_close[0].setRotationPoint(-15F, -5F, -17F);

        body_door_close[1].addBox(0F, 0F, 34F, 17, 11, 2, 0F); // Box 231
        body_door_close[1].setRotationPoint(-15F, -5F, -53F);

        body_door_close[2].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 232
        body_door_close[2].setRotationPoint(-13F, -3F, 18.5F);

        body_door_close[3].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 233
        body_door_close[3].setRotationPoint(-13F, -3F, -19.5F);

        body_door_close[4].addBox(0F, 0F, 34F, 16, 11, 2, 0F); // Box 267
        body_door_close[4].setRotationPoint(6F, -5F, -53F);

        body_door_close[5].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 268
        body_door_close[5].setRotationPoint(8F, -3F, 18.5F);

        body_door_close[6].addBox(0F, 0F, 34F, 16, 11, 2, 0F); // Box 269
        body_door_close[6].setRotationPoint(6F, -5F, -17F);

        body_door_close[7].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 270
        this.add("body_door_close", body_door_close);

        translateAll(0F, -12F, 0F);
        flipAll();

    }

}
