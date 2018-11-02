package net.fexcraft.mod.addons.fvp.models.vehicle;

import javax.annotation.Nullable;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.vehicle.VehicleModel;
import net.minecraft.entity.Entity;

public class ModelC4Z1 extends VehicleModel {

    private static final int texture = 1024;

    public ModelC4Z1(){
    	super(); this.textureX = this.textureY = texture;
    	this.addToCreators("Ferdinand (FEX___96)");
        this.addToCreators("zackyboy18");
        ModelRendererTurbo[] body = new ModelRendererTurbo[193];
        body[0] = new ModelRendererTurbo(this, 1, 1, texture, texture); // Box 364
        body[1] = new ModelRendererTurbo(this, 33, 1, texture, texture); // Box 365
        body[2] = new ModelRendererTurbo(this, 81, 1, texture, texture); // Box 366
        body[3] = new ModelRendererTurbo(this, 105, 1, texture, texture); // Box 367
        body[4] = new ModelRendererTurbo(this, 25, 1, texture, texture); // Box 368
        body[5] = new ModelRendererTurbo(this, 129, 1, texture, texture); // Box 369
        body[6] = new ModelRendererTurbo(this, 153, 1, texture, texture); // Box 370
        body[7] = new ModelRendererTurbo(this, 177, 1, texture, texture); // Box 371
        body[8] = new ModelRendererTurbo(this, 201, 1, texture, texture); // Box 372
        body[9] = new ModelRendererTurbo(this, 233, 1, texture, texture); // Box 373
        body[10] = new ModelRendererTurbo(this, 281, 1, texture, texture); // Box 374
        body[11] = new ModelRendererTurbo(this, 305, 1, texture, texture); // Box 419
        body[12] = new ModelRendererTurbo(this, 345, 1, texture, texture); // Box 295
        body[13] = new ModelRendererTurbo(this, 377, 1, texture, texture); // Box 296
        body[14] = new ModelRendererTurbo(this, 409, 1, texture, texture); // Box 297
        body[15] = new ModelRendererTurbo(this, 433, 1, texture, texture); // Box 298
        body[16] = new ModelRendererTurbo(this, 225, 1, texture, texture); // Box 299
        body[17] = new ModelRendererTurbo(this, 633, 1, texture, texture); // Box 300
        body[18] = new ModelRendererTurbo(this, 657, 1, texture, texture); // Box 307
        body[19] = new ModelRendererTurbo(this, 81, 1, texture, texture); // Box 308
        body[20] = new ModelRendererTurbo(this, 121, 1, texture, texture); // Box 309
        body[21] = new ModelRendererTurbo(this, 193, 1, texture, texture); // Box 310
        body[22] = new ModelRendererTurbo(this, 97, 1, texture, texture); // Box 311
        body[23] = new ModelRendererTurbo(this, 649, 1, texture, texture); // Box 312
        body[24] = new ModelRendererTurbo(this, 145, 1, texture, texture); // Box 314
        body[25] = new ModelRendererTurbo(this, 169, 1, texture, texture); // Box 315
        body[26] = new ModelRendererTurbo(this, 713, 1, texture, texture); // Box 316
        body[27] = new ModelRendererTurbo(this, 105, 1, texture, texture); // Box 319
        body[28] = new ModelRendererTurbo(this, 689, 1, texture, texture); // Box 7
        body[29] = new ModelRendererTurbo(this, 753, 1, texture, texture); // Box 8
        body[30] = new ModelRendererTurbo(this, 713, 1, texture, texture); // Box 9
        body[31] = new ModelRendererTurbo(this, 777, 1, texture, texture); // Box 11
        body[32] = new ModelRendererTurbo(this, 793, 1, texture, texture); // Box 156
        body[33] = new ModelRendererTurbo(this, 873, 1, texture, texture); // Box 157
        body[34] = new ModelRendererTurbo(this, 953, 1, texture, texture); // Box 158
        body[35] = new ModelRendererTurbo(this, 345, 9, texture, texture); // Box 159
        body[36] = new ModelRendererTurbo(this, 393, 9, texture, texture); // Box 160
        body[37] = new ModelRendererTurbo(this, 793, 9, texture, texture); // Box 161
        body[38] = new ModelRendererTurbo(this, 753, 1, texture, texture); // Box 162
        body[39] = new ModelRendererTurbo(this, 1001, 1, texture, texture); // Box 163
        body[40] = new ModelRendererTurbo(this, 129, 1, texture, texture); // Box 164
        body[41] = new ModelRendererTurbo(this, 73, 9, texture, texture); // Box 167
        body[42] = new ModelRendererTurbo(this, 137, 9, texture, texture); // Box 168
        body[43] = new ModelRendererTurbo(this, 513, 9, texture, texture); // Box 169
        body[44] = new ModelRendererTurbo(this, 585, 9, texture, texture); // Box 170
        body[45] = new ModelRendererTurbo(this, 913, 9, texture, texture); // Box 171
        body[46] = new ModelRendererTurbo(this, 953, 9, texture, texture); // Box 172
        body[47] = new ModelRendererTurbo(this, 1, 17, texture, texture); // Box 173
        body[48] = new ModelRendererTurbo(this, 41, 17, texture, texture); // Box 174
        body[49] = new ModelRendererTurbo(this, 97, 17, texture, texture); // Box 175
        body[50] = new ModelRendererTurbo(this, 161, 17, texture, texture); // Box 176
        body[51] = new ModelRendererTurbo(this, 201, 17, texture, texture); // Box 177
        body[52] = new ModelRendererTurbo(this, 241, 17, texture, texture); // Box 178
        body[53] = new ModelRendererTurbo(this, 369, 1, texture, texture); // Box 179
        body[54] = new ModelRendererTurbo(this, 401, 1, texture, texture); // Box 180
        body[55] = new ModelRendererTurbo(this, 1009, 1, texture, texture); // Box 181
        body[56] = new ModelRendererTurbo(this, 161, 9, texture, texture); // Box 182
        body[57] = new ModelRendererTurbo(this, 553, 33, texture, texture); // Box 125
        body[58] = new ModelRendererTurbo(this, 449, 25, texture, texture); // Box 126
        body[59] = new ModelRendererTurbo(this, 465, 25, texture, texture); // Box 127
        body[60] = new ModelRendererTurbo(this, 489, 25, texture, texture); // Box 128
        body[61] = new ModelRendererTurbo(this, 129, 25, texture, texture); // Box 129
        body[62] = new ModelRendererTurbo(this, 673, 33, texture, texture); // Box 18
        body[63] = new ModelRendererTurbo(this, 161, 41, texture, texture); // Box 20
        body[64] = new ModelRendererTurbo(this, 1009, 25, texture, texture); // Box 21
        body[65] = new ModelRendererTurbo(this, 817, 33, texture, texture); // Box 35
        body[66] = new ModelRendererTurbo(this, 353, 33, texture, texture); // Box 36
        body[67] = new ModelRendererTurbo(this, 593, 33, texture, texture); // Box 46
        body[68] = new ModelRendererTurbo(this, 449, 57, texture, texture); // Box 47
        body[69] = new ModelRendererTurbo(this, 57, 41, texture, texture); // Box 48
        body[70] = new ModelRendererTurbo(this, 849, 33, texture, texture); // Box 50
        body[71] = new ModelRendererTurbo(this, 889, 57, texture, texture); // Box 56
        body[72] = new ModelRendererTurbo(this, 929, 57, texture, texture); // Box 59
        body[73] = new ModelRendererTurbo(this, 601, 49, texture, texture); // Box 60
        body[74] = new ModelRendererTurbo(this, 57, 65, texture, texture); // Box 61
        body[75] = new ModelRendererTurbo(this, 161, 65, texture, texture); // Box 62
        body[76] = new ModelRendererTurbo(this, 17, 57, texture, texture); // Box 63
        body[77] = new ModelRendererTurbo(this, 889, 49, texture, texture); // Box 64
        body[78] = new ModelRendererTurbo(this, 265, 65, texture, texture); // Box 65
        body[79] = new ModelRendererTurbo(this, 665, 17, texture, texture); // Box 67
        body[80] = new ModelRendererTurbo(this, 705, 17, texture, texture); // Box 68
        body[81] = new ModelRendererTurbo(this, 721, 17, texture, texture); // Box 69
        body[82] = new ModelRendererTurbo(this, 1017, 41, texture, texture); // Box 70
        body[83] = new ModelRendererTurbo(this, 457, 65, texture, texture); // Box 87
        body[84] = new ModelRendererTurbo(this, 777, 65, texture, texture); // Box 93
        body[85] = new ModelRendererTurbo(this, 545, 41, texture, texture); // Box 116
        body[86] = new ModelRendererTurbo(this, 297, 73, texture, texture); // Box 117
        body[87] = new ModelRendererTurbo(this, 817, 65, texture, texture); // Box 118
        body[88] = new ModelRendererTurbo(this, 41, 65, texture, texture); // Box 121
        body[89] = new ModelRendererTurbo(this, 201, 65, texture, texture); // Box 122
        body[90] = new ModelRendererTurbo(this, 793, 73, texture, texture); // Box 123
        body[91] = new ModelRendererTurbo(this, 849, 65, texture, texture); // Box 124
        body[92] = new ModelRendererTurbo(this, 961, 81, texture, texture); // Box 217
        body[93] = new ModelRendererTurbo(this, 321, 89, texture, texture); // Box 219
        body[94] = new ModelRendererTurbo(this, 33, 81, texture, texture); // Box 220
        body[95] = new ModelRendererTurbo(this, 905, 89, texture, texture); // Box 233
        body[96] = new ModelRendererTurbo(this, 809, 89, texture, texture); // Box 234
        body[97] = new ModelRendererTurbo(this, 97, 89, texture, texture); // Box 244
        body[98] = new ModelRendererTurbo(this, 593, 97, texture, texture); // Box 245
        body[99] = new ModelRendererTurbo(this, 81, 97, texture, texture); // Box 246
        body[100] = new ModelRendererTurbo(this, 921, 89, texture, texture); // Box 248
        body[101] = new ModelRendererTurbo(this, 881, 97, texture, texture); // Box 254
        body[102] = new ModelRendererTurbo(this, 953, 97, texture, texture); // Box 257
        body[103] = new ModelRendererTurbo(this, 1001, 97, texture, texture); // Box 258
        body[104] = new ModelRendererTurbo(this, 945, 89, texture, texture); // Box 259
        body[105] = new ModelRendererTurbo(this, 1017, 89, texture, texture); // Box 260
        body[106] = new ModelRendererTurbo(this, 1, 105, texture, texture); // Box 261
        body[107] = new ModelRendererTurbo(this, 33, 105, texture, texture); // Box 262
        body[108] = new ModelRendererTurbo(this, 297, 97, texture, texture); // Box 263
        body[109] = new ModelRendererTurbo(this, 769, 17, texture, texture); // Box 265
        body[110] = new ModelRendererTurbo(this, 1, 113, texture, texture); // Box 285
        body[111] = new ModelRendererTurbo(this, 1009, 105, texture, texture); // Box 291
        body[112] = new ModelRendererTurbo(this, 873, 105, texture, texture); // Box 312
        body[113] = new ModelRendererTurbo(this, 1, 113, texture, texture); // Box 313
        body[114] = new ModelRendererTurbo(this, 345, 121, texture, texture); // Box 314
        body[115] = new ModelRendererTurbo(this, 353, 121, texture, texture); // Box 318
        body[116] = new ModelRendererTurbo(this, 257, 113, texture, texture); // Box 319
        body[117] = new ModelRendererTurbo(this, 97, 105, texture, texture); // Box 320
        body[118] = new ModelRendererTurbo(this, 569, 105, texture, texture); // Box 324
        body[119] = new ModelRendererTurbo(this, 849, 121, texture, texture); // Box 327
        body[120] = new ModelRendererTurbo(this, 425, 129, texture, texture); // Box 328
        body[121] = new ModelRendererTurbo(this, 481, 129, texture, texture); // Box 329
        body[122] = new ModelRendererTurbo(this, 577, 129, texture, texture); // Box 330
        body[123] = new ModelRendererTurbo(this, 737, 129, texture, texture); // Box 331
        body[124] = new ModelRendererTurbo(this, 385, 137, texture, texture); // Box 332
        body[125] = new ModelRendererTurbo(this, 849, 169, texture, texture); // Box 333
        body[126] = new ModelRendererTurbo(this, 905, 129, texture, texture); // Box 334
        body[127] = new ModelRendererTurbo(this, 689, 137, texture, texture); // Box 335
        body[128] = new ModelRendererTurbo(this, 305, 145, texture, texture); // Box 336
        body[129] = new ModelRendererTurbo(this, 497, 145, texture, texture); // Box 337
        body[130] = new ModelRendererTurbo(this, 1, 177, texture, texture); // Box 338
        body[131] = new ModelRendererTurbo(this, 97, 177, texture, texture); // Box 339
        body[132] = new ModelRendererTurbo(this, 193, 177, texture, texture); // Box 340
        body[133] = new ModelRendererTurbo(this, 545, 177, texture, texture); // Box 341
        body[134] = new ModelRendererTurbo(this, 401, 121, texture, texture); // Box 147
        body[135] = new ModelRendererTurbo(this, 905, 121, texture, texture); // Box 148
        body[136] = new ModelRendererTurbo(this, 33, 33, texture, texture); // Box 152
        body[137] = new ModelRendererTurbo(this, 193, 33, texture, texture); // Box 153
        body[138] = new ModelRendererTurbo(this, 689, 129, texture, texture); // Box 155
        body[139] = new ModelRendererTurbo(this, 545, 137, texture, texture); // Box 159
        body[140] = new ModelRendererTurbo(this, 497, 137, texture, texture); // Box 161
        body[141] = new ModelRendererTurbo(this, 1009, 121, texture, texture); // Box 350
        body[142] = new ModelRendererTurbo(this, 305, 129, texture, texture); // Box 351
        body[143] = new ModelRendererTurbo(this, 233, 33, texture, texture); // Box 352
        body[144] = new ModelRendererTurbo(this, 665, 33, texture, texture); // Box 353
        body[145] = new ModelRendererTurbo(this, 1, 145, texture, texture); // Box 354
        body[146] = new ModelRendererTurbo(this, 353, 145, texture, texture); // Box 355
        body[147] = new ModelRendererTurbo(this, 1, 153, texture, texture); // Box 356
        body[148] = new ModelRendererTurbo(this, 737, 177, texture, texture); // Box 357
        body[149] = new ModelRendererTurbo(this, 49, 185, texture, texture); // Box 358
        body[150] = new ModelRendererTurbo(this, 145, 185, texture, texture); // Box 359
        body[151] = new ModelRendererTurbo(this, 737, 129, texture, texture); // Box 360
        body[152] = new ModelRendererTurbo(this, 849, 129, texture, texture); // Box 361
        body[153] = new ModelRendererTurbo(this, 689, 137, texture, texture); // Box 362
        body[154] = new ModelRendererTurbo(this, 321, 129, texture, texture); // Box 363
        body[155] = new ModelRendererTurbo(this, 713, 33, texture, texture); // Box 364
        body[156] = new ModelRendererTurbo(this, 305, 145, texture, texture); // Box 365
        body[157] = new ModelRendererTurbo(this, 497, 145, texture, texture); // Box 366
        body[158] = new ModelRendererTurbo(this, 801, 33, texture, texture); // Box 367
        body[159] = new ModelRendererTurbo(this, 769, 129, texture, texture); // Box 368
        body[160] = new ModelRendererTurbo(this, 305, 153, texture, texture); // Box 369
        body[161] = new ModelRendererTurbo(this, 881, 129, texture, texture); // Box 370
        body[162] = new ModelRendererTurbo(this, 241, 41, texture, texture); // Box 371
        body[163] = new ModelRendererTurbo(this, 497, 153, texture, texture); // Box 372
        body[164] = new ModelRendererTurbo(this, 545, 153, texture, texture); // Box 373
        body[165] = new ModelRendererTurbo(this, 353, 41, texture, texture); // Box 374
        body[166] = new ModelRendererTurbo(this, 921, 129, texture, texture); // Box 375
        body[167] = new ModelRendererTurbo(this, 985, 137, texture, texture); // Box 376
        body[168] = new ModelRendererTurbo(this, 593, 145, texture, texture); // Box 377
        body[169] = new ModelRendererTurbo(this, 449, 185, texture, texture); // Box 396
        body[170] = new ModelRendererTurbo(this, 793, 177, texture, texture); // Box 398
        body[171] = new ModelRendererTurbo(this, 689, 185, texture, texture); // Box 399
        body[172] = new ModelRendererTurbo(this, 305, 193, texture, texture); // Box 400
        body[173] = new ModelRendererTurbo(this, 497, 193, texture, texture); // Box 401
        body[174] = new ModelRendererTurbo(this, 369, 129, texture, texture); // Box 106
        body[175] = new ModelRendererTurbo(this, 913, 17, texture, texture); // Box 405
        body[176] = new ModelRendererTurbo(this, 1, 121, texture, texture); // Box 406
        body[177] = new ModelRendererTurbo(this, 385, 129, texture, texture); // Box 407
        body[178] = new ModelRendererTurbo(this, 393, 129, texture, texture); // Box 408
        body[179] = new ModelRendererTurbo(this, 537, 129, texture, texture); // Box 409
        body[180] = new ModelRendererTurbo(this, 553, 129, texture, texture); // Box 410
        body[181] = new ModelRendererTurbo(this, 753, 129, texture, texture); // Box 411
        body[182] = new ModelRendererTurbo(this, 865, 129, texture, texture); // Box 412
        body[183] = new ModelRendererTurbo(this, 985, 129, texture, texture); // Box 413
        body[184] = new ModelRendererTurbo(this, 881, 129, texture, texture); // Box 414
        body[185] = new ModelRendererTurbo(this, 601, 137, texture, texture); // Box 415
        body[186] = new ModelRendererTurbo(this, 753, 137, texture, texture); // Box 416
        body[187] = new ModelRendererTurbo(this, 449, 225, texture, texture); // Box 452
        body[188] = new ModelRendererTurbo(this, 513, 249, texture, texture); // Box 0
        body[189] = new ModelRendererTurbo(this, 321, 89, texture, texture); // Box 680
        body[190] = new ModelRendererTurbo(this, 321, 89, texture, texture); // Box 681
        body[191] = new ModelRendererTurbo(this, 537, 129, texture, texture); // Box 682
        body[192] = new ModelRendererTurbo(this, 985, 129, texture, texture); // Box 683

        body[0].addShapeBox(0F, 0F, 0F, 4, 3, 10, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -1F, -2F, 0F, 0F, -2F, 0F, 0F, -1F, 0F, -1F, -1F); // Box 364
        body[0].setRotationPoint(46F, 0F, -6F);

        body[1].addShapeBox(0F, 0F, 0F, 15, 3, 10, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 365
        body[1].setRotationPoint(50F, 0F, -6F);

        body[2].addShapeBox(0F, 0F, 0F, 4, 1, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 366
        body[2].setRotationPoint(42F, 2F, -3.5F);

        body[3].addShapeBox(0F, 0F, 0F, 4, 2, 7, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 367
        body[3].setRotationPoint(42F, 0F, -4F);

        body[4].addShapeBox(0F, 0F, 0F, 2, 3, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 368
        body[4].setRotationPoint(41F, -2F, -2F);

        body[5].addShapeBox(0F, 0F, 0F, 4, 3, 7, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 369
        body[5].setRotationPoint(42F, -3F, -4F);

        body[6].addShapeBox(0F, 0F, 0F, 4, 2, 5, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 370
        body[6].setRotationPoint(42F, -5F, -3F);

        body[7].addShapeBox(0F, 0F, 0F, 4, 3, 7, 0F, 0F, -1F, -2F, 0F, 0F, -1F, 0F, 0F, -2F, 0F, -1F, -2F, 0F, 0F, -1F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, -1F); // Box 371
        body[7].setRotationPoint(46F, -6F, -4F);

        body[8].addShapeBox(0F, 0F, 0F, 4, 4, 10, 0F, 0F, -1F, -3F, 0F, 0F, -2F, 0F, 0F, -1F, 0F, -1F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F); // Box 372
        body[8].setRotationPoint(46F, -4F, -6F);

        body[9].addShapeBox(0F, 0F, 0F, 15, 4, 10, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 373
        body[9].setRotationPoint(50F, -4F, -6F);

        body[10].addShapeBox(0F, 0F, 0F, 15, 2, 7, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 374
        body[10].setRotationPoint(50F, -6F, -4F);

        body[11].addShapeBox(0F, 0F, 0F, 5, 1, 25, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F); // Box 419
        body[11].setRotationPoint(-99F, 2.5F, -14F);

        body[12].addShapeBox(0F, 0F, 0F, 8, 1, 5, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 295
        body[12].setRotationPoint(-12F, -1F, -10F);

        body[13].addShapeBox(0F, 0F, 0F, 8, 2, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 296
        body[13].setRotationPoint(-12F, 0F, -10F);

        body[14].addShapeBox(0F, 0F, 0F, 8, 1, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 297
        body[14].setRotationPoint(-12F, 2F, -10F);

        body[15].addBox(0F, 0F, 0F, 100, 2, 2, 0F); // Box 298
        body[15].setRotationPoint(-58F, -2.5F, -1.5F);

        body[16].addShapeBox(0F, 0F, 0F, 3, 4, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 299
        body[16].setRotationPoint(-61F, -3.5F, -3F);

        body[17].addShapeBox(0F, 0F, 0F, 5, 1, 9, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 300
        body[17].setRotationPoint(-66F, -4.5F, -5F);

        body[18].addShapeBox(0F, 0F, 0F, 1, 2, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 307
        body[18].setRotationPoint(-67F, -2F, -3F);

        body[19].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 308
        body[19].setRotationPoint(-67F, -2F, -4F);

        body[20].addShapeBox(0F, 0F, 0F, 1, 1, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F); // Box 309
        body[20].setRotationPoint(-67F, 0F, -3F);

        body[21].addShapeBox(0F, 0F, 0F, 1, 1, 5, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 310
        body[21].setRotationPoint(-67F, -3F, -3F);

        body[22].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 311
        body[22].setRotationPoint(-67F, -2F, 2F);

        body[23].addShapeBox(0F, 0F, 0F, 5, 1, 25, 0F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 312
        body[23].setRotationPoint(-99F, -1.5F, -14F);

        body[24].addShapeBox(0F, 0F, 0F, 3, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 314
        body[24].setRotationPoint(-107F, -0.5F, -10.5F);

        body[25].addShapeBox(0F, 0F, 0F, 3, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 315
        body[25].setRotationPoint(-107F, -0.5F, 5.5F);

        body[26].addShapeBox(0F, 0F, 0F, 5, 3, 25, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 316
        body[26].setRotationPoint(-99F, -0.5F, -14F);

        body[27].addShapeBox(0F, 0F, 0F, 2, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F); // Box 319
        body[27].setRotationPoint(-36F, 0.5F, -8F);

        body[28].addShapeBox(0F, 0F, 0F, 5, 1, 9, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 7
        body[28].setRotationPoint(-66F, 0.5F, -5F);

        body[29].addShapeBox(0F, 0F, 0F, 5, 4, 11, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 8
        body[29].setRotationPoint(-66F, -3.5F, -6F);

        body[30].addShapeBox(0F, 0F, 0F, 4, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 9
        body[30].setRotationPoint(-65.5F, -3F, 5F);

        body[31].addShapeBox(0F, 0F, 0F, 4, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 11
        body[31].setRotationPoint(-65.5F, -3F, -8F);

        body[32].addShapeBox(0F, 0F, 0F, 38, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 156
        body[32].setRotationPoint(-73F, 0.5F, -12F);

        body[33].addShapeBox(0F, 0F, 0F, 38, 2, 1, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 157
        body[33].setRotationPoint(-73F, 0.5F, -13F);

        body[34].addShapeBox(0F, 0F, 0F, 22, 2, 1, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 158
        body[34].setRotationPoint(-34F, 0.5F, -9F);

        body[35].addShapeBox(0F, 0F, 0F, 22, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 159
        body[35].setRotationPoint(-34F, 0.5F, -8F);

        body[36].addShapeBox(0F, 0F, 0F, 67, 2, 1, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 160
        body[36].setRotationPoint(-4F, 0.5F, -9F);

        body[37].addShapeBox(0F, 0F, 0F, 67, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 161
        body[37].setRotationPoint(-4F, 0.5F, -8F);

        body[38].addShapeBox(0F, 0F, 0F, 1, 2, 4, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 162
        body[38].setRotationPoint(-35F, 0.5F, -12F);

        body[39].addShapeBox(0F, 0F, 0F, 1, 2, 4, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 163
        body[39].setRotationPoint(-36F, 0.5F, -12F);

        body[40].addShapeBox(0F, 0F, 0F, 2, 2, 1, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 164
        body[40].setRotationPoint(-36F, 0.5F, -13F);

        body[41].addShapeBox(0F, 0F, 0F, 1, 3, 17, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 167
        body[41].setRotationPoint(60.5F, -3F, -21F);

        body[42].addShapeBox(0F, 0F, 0F, 1, 3, 17, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 168
        body[42].setRotationPoint(59.5F, -3F, -21F);

        body[43].addShapeBox(0F, 0F, 0F, 1, 3, 17, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 169
        body[43].setRotationPoint(58.5F, -3F, -21F);

        body[44].addShapeBox(0F, 0F, 0F, 1, 3, 17, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 170
        body[44].setRotationPoint(60.5F, -3F, 3F);

        body[45].addShapeBox(0F, 0F, 0F, 1, 3, 17, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 171
        body[45].setRotationPoint(59.5F, -3F, 3F);

        body[46].addShapeBox(0F, 0F, 0F, 1, 3, 17, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 172
        body[46].setRotationPoint(58.5F, -3F, 3F);

        body[47].addShapeBox(0F, 0F, 0F, 1, 3, 15, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 173
        body[47].setRotationPoint(-62.5F, -3F, 7F);

        body[48].addShapeBox(0F, 0F, 0F, 1, 3, 15, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 174
        body[48].setRotationPoint(-63.5F, -3F, 7F);

        body[49].addShapeBox(0F, 0F, 0F, 1, 3, 15, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 175
        body[49].setRotationPoint(-64.5F, -3F, 7F);

        body[50].addShapeBox(0F, 0F, 0F, 1, 3, 15, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 176
        body[50].setRotationPoint(-64.5F, -3F, -23F);

        body[51].addShapeBox(0F, 0F, 0F, 1, 3, 15, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 177
        body[51].setRotationPoint(-63.5F, -3F, -23F);

        body[52].addShapeBox(0F, 0F, 0F, 1, 3, 15, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 178
        body[52].setRotationPoint(-62.5F, -3F, -23F);

        body[53].addShapeBox(0F, 0F, 0F, 5, 2, 1, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 179
        body[53].setRotationPoint(-104F, -0.5F, -10.5F);

        body[54].addShapeBox(0F, 0F, 0F, 5, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 180
        body[54].setRotationPoint(-104F, -0.5F, -9.5F);

        body[55].addShapeBox(0F, 0F, 0F, 5, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 181
        body[55].setRotationPoint(-104F, -0.5F, 6.5F);

        body[56].addShapeBox(0F, 0F, 0F, 5, 2, 1, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 182
        body[56].setRotationPoint(-104F, -0.5F, 5.5F);

        body[57].addShapeBox(0F, 0F, 0F, 12, 4, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 125
        body[57].setRotationPoint(52.5F, -0.5F, -4F);

        body[58].addShapeBox(0F, 0F, 0F, 3, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 126
        body[58].setRotationPoint(53F, 0F, 1F);

        body[59].addShapeBox(0F, 0F, 0F, 3, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 127
        body[59].setRotationPoint(53F, 0F, -5F);

        body[60].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 128
        body[60].setRotationPoint(58.5F, -2F, -8F);

        body[61].addShapeBox(0F, 0F, 0F, 1, 1, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 129
        body[61].setRotationPoint(58.5F, 0F, -8.5F);

        body[62].addShapeBox(0F, 0F, 0F, 20, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F); // Box 18
        body[62].setRotationPoint(-96.5F, -0.5F, -24F);

        body[63].addBox(0F, 0F, 0F, 39, 1, 1, 0F); // Box 20
        body[63].setRotationPoint(-13.5F, 0.5F, -24F);

        body[64].addBox(0F, 0F, 0F, 3, 2, 1, 0F); // Box 21
        body[64].setRotationPoint(-76.5F, -0.5F, -24F);

        body[65].addShapeBox(0F, 0F, 0F, 6, 2, 1, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 35
        body[65].setRotationPoint(69.5F, -6.5F, -24F);

        body[66].addShapeBox(0F, 0F, 0F, 5, 2, 1, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 36
        body[66].setRotationPoint(70.5F, -4.5F, -24F);

        body[67].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 46
        body[67].setRotationPoint(47.5F, 0.5F, -24F);

        body[68].addBox(0F, 0F, 0F, 22, 1, 1, 0F); // Box 47
        body[68].setRotationPoint(25.5F, 0.5F, -24F);

        body[69].addShapeBox(0F, 0F, 0F, 7, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 48
        body[69].setRotationPoint(40.5F, 1.5F, -24F);

        body[70].addShapeBox(0F, 0F, 0F, 4, 5, 1, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 50
        body[70].setRotationPoint(71.5F, -2.5F, -24F);

        body[71].addShapeBox(0F, 0F, 0F, 18, 15, 1, 0F, 0F, 0F, 0F, 0F, -15F, 0F, 0F, -15F, 0F, 0F, 0F, 0F, 0F, -14F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -14F, 0F); // Box 56
        body[71].setRotationPoint(45.5F, -39.5F, -24F);

        body[72].addBox(0F, 0F, 0F, 20, 1, 1, 0F); // Box 59
        body[72].setRotationPoint(25.5F, -39.5F, -24F);

        body[73].addBox(0F, 0F, 0F, 9, 6, 1, 0F); // Box 60
        body[73].setRotationPoint(-105.5F, -5.5F, -24F);

        body[74].addBox(0F, 0F, 0F, 2, 4, 46, 0F); // Box 61
        body[74].setRotationPoint(-107.5F, -5.5F, -24F);

        body[75].addShapeBox(0F, 0F, 0F, 2, 2, 46, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 62
        body[75].setRotationPoint(-107.5F, -1.5F, -24F);

        body[76].addBox(0F, 0F, 0F, 11, 2, 1, 0F); // Box 63
        body[76].setRotationPoint(-107.5F, -7.5F, -24F);

        body[77].addBox(0F, 0F, 0F, 9, 2, 1, 0F); // Box 64
        body[77].setRotationPoint(-105.5F, -9.5F, -24F);

        body[78].addShapeBox(0F, 0F, 0F, 2, 2, 46, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 65
        body[78].setRotationPoint(-107.5F, -9.5F, -24F);

        body[79].addBox(0F, 0F, 0F, 2, 1, 1, 0F); // Box 67
        body[79].setRotationPoint(-105.5F, -19.5F, -24F);

        body[80].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 68
        body[80].setRotationPoint(-104.5F, -16.5F, -24.2F);

        body[81].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 69
        body[81].setRotationPoint(-104.5F, -13.5F, -24.2F);

        body[82].addBox(0F, 0F, 0F, 1, 7, 1, 0F); // Box 70
        body[82].setRotationPoint(-105.5F, -18.5F, -24.2F);

        body[83].addShapeBox(0F, 0F, 0F, 6, 4, 11, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 87
        body[83].setRotationPoint(75.5F, -6.5F, -24F);

        body[84].addShapeBox(0F, 0F, 0F, 4, 5, 46, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 93
        body[84].setRotationPoint(75.5F, -2.5F, -24F);

        body[85].addShapeBox(0F, 0F, 0F, 2, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F); // Box 116
        body[85].setRotationPoint(28.5F, -38.5F, -24F);

        body[86].addShapeBox(0F, 0F, 0F, 3, 2, 1, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 117
        body[86].setRotationPoint(29.5F, -24.5F, -24F);

        body[87].addShapeBox(0F, 0F, 0F, 1, 16, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, -3F, 0F, 0F); // Box 118
        body[87].setRotationPoint(40.5F, -38.5F, -24F);

        body[88].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F); // Box 121
        body[88].setRotationPoint(55.5F, -20.5F, -24F);

        body[89].addShapeBox(0F, 0F, 0F, 1, 9, 1, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 122
        body[89].setRotationPoint(55.5F, -29.5F, -24F);

        body[90].addShapeBox(0F, 0F, 0F, 3, 5, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 123
        body[90].setRotationPoint(26.5F, -20.5F, -24F);

        body[91].addShapeBox(0F, 0F, 0F, 1, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 124
        body[91].setRotationPoint(27.5F, -20F, -24.5F);

        body[92].addShapeBox(0F, 0F, 0F, 20, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F); // Box 217
        body[92].setRotationPoint(-96.5F, -0.5F, 22F);

        body[93].addBox(0F, 0F, 0F, 39, 1, 1, 0F); // Box 219
        body[93].setRotationPoint(-13.5F, 0.5F, 22F);

        body[94].addBox(0F, 0F, 0F, 3, 2, 1, 0F); // Box 220
        body[94].setRotationPoint(-76.5F, -0.5F, 22F);

        body[95].addShapeBox(0F, 0F, 0F, 6, 2, 1, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 233
        body[95].setRotationPoint(69.5F, -6.5F, 22F);

        body[96].addShapeBox(0F, 0F, 0F, 5, 2, 1, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 234
        body[96].setRotationPoint(70.5F, -4.5F, 22F);

        body[97].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 244
        body[97].setRotationPoint(47.5F, 0.5F, 22F);

        body[98].addBox(0F, 0F, 0F, 22, 1, 1, 0F); // Box 245
        body[98].setRotationPoint(25.5F, 0.5F, 22F);

        body[99].addShapeBox(0F, 0F, 0F, 7, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 246
        body[99].setRotationPoint(40.5F, 1.5F, 22F);

        body[100].addShapeBox(0F, 0F, 0F, 4, 5, 1, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 248
        body[100].setRotationPoint(71.5F, -2.5F, 22F);

        body[101].addShapeBox(0F, 0F, 0F, 18, 15, 1, 0F, 0F, 0F, 0F, 0F, -15F, 0F, 0F, -15F, 0F, 0F, 0F, 0F, 0F, -14F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -14F, 0F); // Box 254
        body[101].setRotationPoint(45.5F, -39.5F, 22F);

        body[102].addBox(0F, 0F, 0F, 20, 1, 1, 0F); // Box 257
        body[102].setRotationPoint(25.5F, -39.5F, 22F);

        body[103].addBox(0F, 0F, 0F, 9, 6, 1, 0F); // Box 258
        body[103].setRotationPoint(-105.5F, -5.5F, 22F);

        body[104].addBox(0F, 0F, 0F, 2, 4, 1, 0F); // Box 259
        body[104].setRotationPoint(-107.5F, -5.5F, 22F);

        body[105].addShapeBox(0F, 0F, 0F, 2, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 260
        body[105].setRotationPoint(-107.5F, -1.5F, 22F);

        body[106].addBox(0F, 0F, 0F, 11, 2, 1, 0F); // Box 261
        body[106].setRotationPoint(-107.5F, -7.5F, 22F);

        body[107].addBox(0F, 0F, 0F, 9, 2, 1, 0F); // Box 262
        body[107].setRotationPoint(-105.5F, -9.5F, 22F);

        body[108].addShapeBox(0F, 0F, 0F, 2, 2, 1, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 263
        body[108].setRotationPoint(-107.5F, -9.5F, 22F);

        body[109].addBox(0F, 0F, 0F, 2, 1, 1, 0F); // Box 265
        body[109].setRotationPoint(-105.5F, -19.5F, 22F);

        body[110].addShapeBox(0F, 0F, 0F, 6, 4, 11, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 285
        body[110].setRotationPoint(75.5F, -6.5F, 12F);

        body[111].addShapeBox(0F, 0F, 0F, 4, 5, 1, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 291
        body[111].setRotationPoint(75.5F, -2.5F, 22F);

        body[112].addShapeBox(0F, 0F, 0F, 2, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F); // Box 312
        body[112].setRotationPoint(28.5F, -38.5F, 22F);

        body[113].addShapeBox(0F, 0F, 0F, 3, 2, 1, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 313
        body[113].setRotationPoint(29.5F, -24.5F, 22F);

        body[114].addShapeBox(0F, 0F, 0F, 1, 16, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, -3F, 0F, 0F); // Box 314
        body[114].setRotationPoint(40.5F, -38.5F, 22F);

        body[115].addShapeBox(0F, 0F, 0F, 1, 9, 1, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 318
        body[115].setRotationPoint(55.5F, -29.5F, 22F);

        body[116].addShapeBox(0F, 0F, 0F, 3, 5, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 319
        body[116].setRotationPoint(26.5F, -20.5F, 22F);

        body[117].addShapeBox(0F, 0F, 0F, 1, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 320
        body[117].setRotationPoint(27.5F, -20F, 22.5F);

        body[118].addShapeBox(0F, 0F, 0F, 1, 4, 25, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 324
        body[118].setRotationPoint(80.5F, -6.5F, -13F);

        body[119].addBox(0F, 0F, 0F, 2, 2, 45, 0F); // Box 327
        body[119].setRotationPoint(-107.5F, -7.5F, -23F);

        body[120].addShapeBox(0F, 0F, 0F, 23, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 328
        body[120].setRotationPoint(-96F, 0.5F, -12F);

        body[121].addShapeBox(0F, 0F, 0F, 23, 2, 1, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 329
        body[121].setRotationPoint(-96F, 0.5F, -13F);

        body[122].addBox(0F, 0F, 0F, 32, 2, 45, 0F); // Box 330
        body[122].setRotationPoint(-105.5F, -5.5F, -23F);

        body[123].addBox(0F, 0F, 0F, 32, 2, 45, 0F); // Box 331
        body[123].setRotationPoint(-51.5F, -5.5F, -23F);

        body[124].addBox(0F, 0F, 0F, 32, 2, 45, 0F); // Box 332
        body[124].setRotationPoint(-19.5F, -5.5F, -23F);

        body[125].addBox(0F, 0F, 0F, 35, 2, 45, 0F); // Box 333
        body[125].setRotationPoint(12.5F, -5.5F, -23F);

        body[126].addBox(0F, 0F, 0F, 22, 2, 34, 0F); // Box 334
        body[126].setRotationPoint(-73.5F, -5.5F, -17F);

        body[127].addShapeBox(0F, 0F, 0F, 1, 2, 45, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F); // Box 335
        body[127].setRotationPoint(51.5F, -10.5F, -23F);

        body[128].addShapeBox(0F, 0F, 0F, 1, 2, 45, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F); // Box 336
        body[128].setRotationPoint(49.5F, -8.5F, -23F);

        body[129].addShapeBox(0F, 0F, 0F, 1, 2, 45, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F); // Box 337
        body[129].setRotationPoint(48.5F, -6.5F, -23F);

        body[130].addShapeBox(0F, 0F, 0F, 1, 2, 45, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F); // Box 338
        body[130].setRotationPoint(52.5F, -12.5F, -23F);

        body[131].addShapeBox(0F, 0F, 0F, 1, 3, 45, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F); // Box 339
        body[131].setRotationPoint(53.5F, -15.5F, -23F);

        body[132].addShapeBox(0F, 0F, 0F, 2, 3, 45, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F); // Box 340
        body[132].setRotationPoint(54.5F, -18.5F, -23F);

        body[133].addShapeBox(0F, 0F, 0F, 1, 2, 45, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F); // Box 341
        body[133].setRotationPoint(55.5F, -20.5F, -23F);

        body[134].addShapeBox(0F, 0F, 0F, 1, 9, 4, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 147
        body[134].setRotationPoint(-52F, -14.5F, -23F);

        body[135].addShapeBox(0F, 0F, 0F, 1, 9, 4, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 148
        body[135].setRotationPoint(-74F, -14.5F, -23F);

        body[136].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 152
        body[136].setRotationPoint(-53F, -15.5F, -23F);

        body[137].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 153
        body[137].setRotationPoint(-73F, -15.5F, -23F);

        body[138].addShapeBox(0F, 0F, 0F, 19, 1, 5, 0F, -1F, -0.5F, 0F, -1F, -0.5F, 0F, -1F, -0.5F, -1F, -1F, -0.5F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0F, 0.1F); // Box 155
        body[138].setRotationPoint(-72F, -16.5F, -23F);

        body[139].addShapeBox(0F, 0F, 0F, 23, 9, 2, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -0.5F, -1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 159
        body[139].setRotationPoint(-74F, -14.5F, -19F);

        body[140].addShapeBox(0F, 0F, 0F, 21, 1, 2, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -0.9F, -1F, 0F, -0.9F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 161
        body[140].setRotationPoint(-73F, -15.5F, -19F);

        body[141].addShapeBox(0F, 0F, 0F, 1, 9, 4, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 350
        body[141].setRotationPoint(-52F, -14.5F, 18F);

        body[142].addShapeBox(0F, 0F, 0F, 1, 9, 4, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 351
        body[142].setRotationPoint(-74F, -14.5F, 18F);

        body[143].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 352
        body[143].setRotationPoint(-53F, -15.5F, 18F);

        body[144].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 353
        body[144].setRotationPoint(-73F, -15.5F, 18F);

        body[145].addShapeBox(0F, 0F, 0F, 19, 1, 5, 0F, -1F, -0.5F, -1F, -1F, -0.5F, -1F, -1F, -0.5F, 0F, -1F, -0.5F, 0F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 354
        body[145].setRotationPoint(-72F, -16.5F, 17F);

        body[146].addShapeBox(0F, 0F, 0F, 23, 9, 2, 0F, -1F, 0F, -0.5F, -1F, 0F, -0.5F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 355
        body[146].setRotationPoint(-74F, -14.5F, 16F);

        body[147].addShapeBox(0F, 0F, 0F, 21, 1, 2, 0F, -1F, 0F, -0.9F, -1F, 0F, -0.9F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 356
        body[147].setRotationPoint(-73F, -15.5F, 16F);

        body[148].addShapeBox(0F, 0F, 0F, 3, 4, 45, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 357
        body[148].setRotationPoint(55.5F, -24.5F, -23F);

        body[149].addBox(0F, 0F, 0F, 1, 10, 45, 0F); // Box 358
        body[149].setRotationPoint(24.5F, -47.5F, -23F);

        body[150].addBox(0F, 0F, 0F, 1, 20, 45, 0F); // Box 359
        body[150].setRotationPoint(24.5F, -25.5F, -23F);

        body[151].addBox(0F, 0F, 0F, 1, 12, 12, 0F); // Box 360
        body[151].setRotationPoint(24.5F, -37.5F, -23F);

        body[152].addBox(0F, 0F, 0F, 1, 12, 12, 0F); // Box 361
        body[152].setRotationPoint(24.5F, -37.5F, 10F);

        body[153].addShapeBox(0F, 0F, 0F, 20, 9, 2, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -0.5F, -1F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 362
        body[153].setRotationPoint(52F, -14.5F, -19F);

        body[154].addShapeBox(0F, 0F, 0F, 0, 9, 4, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 363
        body[154].setRotationPoint(52F, -14.5F, -23F);

        body[155].addShapeBox(0F, 0F, 0F, 0, 1, 4, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 364
        body[155].setRotationPoint(53F, -15.5F, -23F);

        body[156].addShapeBox(0F, 0F, 0F, 16, 1, 5, 0F, -1F, -0.5F, 0F, -1F, -0.5F, 0F, -1F, -0.5F, -1F, -1F, -0.5F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0F, 0.1F); // Box 365
        body[156].setRotationPoint(54F, -16.5F, -23F);

        body[157].addShapeBox(0F, 0F, 0F, 18, 1, 2, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -0.9F, -1F, 0F, -0.9F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 366
        body[157].setRotationPoint(53F, -15.5F, -19F);

        body[158].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 367
        body[158].setRotationPoint(70F, -15.5F, -23F);

        body[159].addShapeBox(0F, 0F, 0F, 1, 9, 4, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 368
        body[159].setRotationPoint(71F, -14.5F, -23F);

        body[160].addShapeBox(0F, 0F, 0F, 20, 9, 2, 0F, -1F, 0F, -0.5F, -1F, 0F, -0.5F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 369
        body[160].setRotationPoint(52F, -14.5F, 16F);

        body[161].addShapeBox(0F, 0F, 0F, 0, 9, 4, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 370
        body[161].setRotationPoint(52F, -14.5F, 18F);

        body[162].addShapeBox(0F, 0F, 0F, 0, 1, 4, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 371
        body[162].setRotationPoint(53F, -15.5F, 18F);

        body[163].addShapeBox(0F, 0F, 0F, 16, 1, 5, 0F, -1F, -0.5F, -1F, -1F, -0.5F, -1F, -1F, -0.5F, 0F, -1F, -0.5F, 0F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 372
        body[163].setRotationPoint(54F, -16.5F, 17F);

        body[164].addShapeBox(0F, 0F, 0F, 18, 1, 2, 0F, -1F, 0F, -0.9F, -1F, 0F, -0.9F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 373
        body[164].setRotationPoint(53F, -15.5F, 16F);

        body[165].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 374
        body[165].setRotationPoint(70F, -15.5F, 18F);

        body[166].addShapeBox(0F, 0F, 0F, 1, 9, 4, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 375
        body[166].setRotationPoint(71F, -14.5F, 18F);

        body[167].addShapeBox(0F, 0F, 0F, 4, 1, 10, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -5F); // Box 376
        body[167].setRotationPoint(71.5F, -6.5F, -23F);

        body[168].addShapeBox(0F, 0F, 0F, 4, 1, 10, 0F, 0F, 0F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 377
        body[168].setRotationPoint(71.5F, -6.5F, 12F);

        body[169].addBox(0F, 0F, 0F, 5, 2, 35, 0F); // Box 396
        body[169].setRotationPoint(58.5F, -24.5F, -18F);

        body[170].addShapeBox(0F, 0F, 0F, 1, 1, 34, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 398
        body[170].setRotationPoint(80.5F, -8.5F, -17.5F);

        body[171].addShapeBox(0F, 0F, 0F, 1, 1, 34, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 399
        body[171].setRotationPoint(80.5F, -10.5F, -17.5F);

        body[172].addShapeBox(0F, 0F, 0F, 1, 1, 34, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 400
        body[172].setRotationPoint(79.5F, -12.5F, -17.5F);
        body[172].rotateAngleZ = 0.40142573F;

        body[173].addShapeBox(0F, 0F, 0F, 1, 1, 34, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 401
        body[173].setRotationPoint(78.5F, -14.5F, -17.5F);
        body[173].rotateAngleZ = 0.40142573F;

        body[174].addBox(0F, 0F, 0F, 2, 7, 1, 0F); // Box 106
        body[174].setRotationPoint(-105.5F, -18.5F, -24F);

        body[175].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 405
        body[175].setRotationPoint(-104.5F, -16.5F, 22.2F);

        body[176].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 406
        body[176].setRotationPoint(-104.5F, -13.5F, 22.2F);

        body[177].addBox(0F, 0F, 0F, 1, 7, 1, 0F); // Box 407
        body[177].setRotationPoint(-105.5F, -18.5F, 22.2F);

        body[178].addBox(0F, 0F, 0F, 2, 7, 1, 0F); // Box 408
        body[178].setRotationPoint(-105.5F, -18.5F, 22F);

        body[179].addShapeBox(0F, 0F, 0F, 5, 2, 1, 0F, 0F, 0F, 1.5F, -1F, 0F, -0.5F, -1F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 1.5F, -1F, 0F, -0.5F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 409
        body[179].setRotationPoint(77.5F, -10.5F, -22.5F);

        body[180].addShapeBox(0F, 0F, 0F, 5, 2, 1, 0F, 0F, 0F, 1.5F, -1F, 0F, -0.5F, -1F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 1.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 410
        body[180].setRotationPoint(76.5F, -12.5F, -22.5F);

        body[181].addShapeBox(0F, 0F, 0F, 5, 2, 1, 0F, 0F, 0F, 1.5F, -1F, 0F, -0.5F, -1F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 1.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 411
        body[181].setRotationPoint(75.5F, -14.5F, -22.5F);

        body[182].addShapeBox(0F, 0F, 0F, 5, 2, 1, 0F, 0F, 0F, 1.5F, -1F, 0F, -0.5F, -1F, 0F, 0F, 0F, 1F, 0F, -1F, 0F, 1.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 412
        body[182].setRotationPoint(74.5F, -16.5F, -22.5F);

        body[183].addShapeBox(0F, 0F, 0F, 5, 2, 1, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -0.5F, 0F, 0F, 1.5F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -0.5F, -1F, 0F, 1.5F); // Box 413
        body[183].setRotationPoint(77.5F, -10.5F, 20.5F);

        body[184].addShapeBox(0F, 0F, 0F, 5, 2, 1, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -0.5F, 0F, 0F, 1.5F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -1F, 0F, 1.5F); // Box 414
        body[184].setRotationPoint(76.5F, -12.5F, 20.5F);

        body[185].addShapeBox(0F, 0F, 0F, 5, 2, 1, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -0.5F, 0F, 0F, 1.5F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -1F, 0F, 1.5F); // Box 415
        body[185].setRotationPoint(75.5F, -14.5F, 20.5F);

        body[186].addShapeBox(0F, 0F, 0F, 5, 2, 1, 0F, 0F, 1F, 0F, -1F, 0F, 0F, -1F, 0F, -0.5F, 0F, 0F, 1.5F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -1F, 0F, 1.5F); // Box 416
        body[186].setRotationPoint(74.5F, -16.5F, 20.5F);

        body[187].addBox(0F, 0F, 0F, 1, 3, 45, 0F); // Box 452
        body[187].setRotationPoint(-105.5F, -8.5F, -23F);

        body[188].addBox(0F, 0F, 0F, 48, 1, 32, 0F); // Box 0
        body[188].setRotationPoint(-24F, -3F, -16F);

        body[189].addBox(0F, 0F, 0F, 38, 1, 1, 0F); // Box 680
        body[189].setRotationPoint(-51.5F, 0.5F, 22F);

        body[190].addBox(0F, 0F, 0F, 38, 1, 1, 0F); // Box 681
        body[190].setRotationPoint(-51.5F, 0.5F, -24F);

        body[191].addShapeBox(0F, 0F, 0F, 3, 1, 2, 0F, 0F, 0F, 0.5F, 0F, 0F, -1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, -1.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 682
        body[191].setRotationPoint(78.5F, -8.5F, -23.5F);

        body[192].addShapeBox(0F, 0F, 0F, 5, 1, 1, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -0.5F, -1F, 0F, 1.5F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -0.5F, -1F, 0F, 1.5F); // Box 683
        body[192].setRotationPoint(77.5F, -8.5F, 20.5F);
        this.add("body", body);

        //-//-//-//-//-//
        ModelRendererTurbo[] body_colored_primary = new ModelRendererTurbo[177];
        body_colored_primary[0] = new ModelRendererTurbo(this, 625, 41, texture, texture); // Box 0
        body_colored_primary[1] = new ModelRendererTurbo(this, 865, 33, texture, texture); // Box 1
        body_colored_primary[2] = new ModelRendererTurbo(this, 833, 33, texture, texture); // Box 7
        body_colored_primary[3] = new ModelRendererTurbo(this, 1, 41, texture, texture); // Box 8
        body_colored_primary[4] = new ModelRendererTurbo(this, 625, 33, texture, texture); // Box 9
        body_colored_primary[5] = new ModelRendererTurbo(this, 889, 33, texture, texture); // Box 10
        body_colored_primary[6] = new ModelRendererTurbo(this, 113, 33, texture, texture); // Box 11
        body_colored_primary[7] = new ModelRendererTurbo(this, 505, 25, texture, texture); // Box 12
        body_colored_primary[8] = new ModelRendererTurbo(this, 161, 49, texture, texture); // Box 13
        body_colored_primary[9] = new ModelRendererTurbo(this, 913, 41, texture, texture); // Box 14
        body_colored_primary[10] = new ModelRendererTurbo(this, 809, 25, texture, texture); // Box 15
        body_colored_primary[11] = new ModelRendererTurbo(this, 561, 25, texture, texture); // Box 16
        body_colored_primary[12] = new ModelRendererTurbo(this, 841, 25, texture, texture); // Box 17
        body_colored_primary[13] = new ModelRendererTurbo(this, 57, 49, texture, texture); // Box 19
        body_colored_primary[14] = new ModelRendererTurbo(this, 1, 41, texture, texture); // Box 22
        body_colored_primary[15] = new ModelRendererTurbo(this, 9, 41, texture, texture); // Box 23
        body_colored_primary[16] = new ModelRendererTurbo(this, 721, 33, texture, texture); // Box 24
        body_colored_primary[17] = new ModelRendererTurbo(this, 745, 33, texture, texture); // Box 25
        body_colored_primary[18] = new ModelRendererTurbo(this, 921, 33, texture, texture); // Box 26
        body_colored_primary[19] = new ModelRendererTurbo(this, 321, 41, texture, texture); // Box 27
        body_colored_primary[20] = new ModelRendererTurbo(this, 337, 49, texture, texture); // Box 28
        body_colored_primary[21] = new ModelRendererTurbo(this, 393, 49, texture, texture); // Box 29
        body_colored_primary[22] = new ModelRendererTurbo(this, 449, 49, texture, texture); // Box 30
        body_colored_primary[23] = new ModelRendererTurbo(this, 545, 49, texture, texture); // Box 32
        body_colored_primary[24] = new ModelRendererTurbo(this, 337, 57, texture, texture); // Box 33
        body_colored_primary[25] = new ModelRendererTurbo(this, 785, 33, texture, texture); // Box 34
        body_colored_primary[26] = new ModelRendererTurbo(this, 17, 41, texture, texture); // Box 37
        body_colored_primary[27] = new ModelRendererTurbo(this, 577, 25, texture, texture); // Box 38
        body_colored_primary[28] = new ModelRendererTurbo(this, 873, 25, texture, texture); // Box 39
        body_colored_primary[29] = new ModelRendererTurbo(this, 905, 25, texture, texture); // Box 40
        body_colored_primary[30] = new ModelRendererTurbo(this, 409, 33, texture, texture); // Box 41
        body_colored_primary[31] = new ModelRendererTurbo(this, 417, 33, texture, texture); // Box 42
        body_colored_primary[32] = new ModelRendererTurbo(this, 473, 33, texture, texture); // Box 43
        body_colored_primary[33] = new ModelRendererTurbo(this, 489, 33, texture, texture); // Box 44
        body_colored_primary[34] = new ModelRendererTurbo(this, 585, 33, texture, texture); // Box 45
        body_colored_primary[35] = new ModelRendererTurbo(this, 649, 17, texture, texture); // Box 49
        body_colored_primary[36] = new ModelRendererTurbo(this, 497, 57, texture, texture); // Box 51
        body_colored_primary[37] = new ModelRendererTurbo(this, 673, 57, texture, texture); // Box 52
        body_colored_primary[38] = new ModelRendererTurbo(this, 1001, 41, texture, texture); // Box 53
        body_colored_primary[39] = new ModelRendererTurbo(this, 41, 41, texture, texture); // Box 54
        body_colored_primary[40] = new ModelRendererTurbo(this, 105, 41, texture, texture); // Box 55
        body_colored_primary[41] = new ModelRendererTurbo(this, 361, 41, texture, texture); // Box 57
        body_colored_primary[42] = new ModelRendererTurbo(this, 17, 49, texture, texture); // Box 58
        body_colored_primary[43] = new ModelRendererTurbo(this, 833, 33, texture, texture); // Box 66
        body_colored_primary[44] = new ModelRendererTurbo(this, 217, 65, texture, texture); // Box 71
        body_colored_primary[45] = new ModelRendererTurbo(this, 737, 65, texture, texture); // Box 77
        body_colored_primary[46] = new ModelRendererTurbo(this, 401, 73, texture, texture); // Box 80
        body_colored_primary[47] = new ModelRendererTurbo(this, 857, 57, texture, texture); // Box 81
        body_colored_primary[48] = new ModelRendererTurbo(this, 953, 33, texture, texture); // Box 82
        body_colored_primary[49] = new ModelRendererTurbo(this, 1017, 57, texture, texture); // Box 83
        body_colored_primary[50] = new ModelRendererTurbo(this, 57, 65, texture, texture); // Box 84
        body_colored_primary[51] = new ModelRendererTurbo(this, 609, 33, texture, texture); // Box 85
        body_colored_primary[52] = new ModelRendererTurbo(this, 809, 17, texture, texture); // Box 86
        body_colored_primary[53] = new ModelRendererTurbo(this, 465, 41, texture, texture); // Box 88
        body_colored_primary[54] = new ModelRendererTurbo(this, 161, 65, texture, texture); // Box 94
        body_colored_primary[55] = new ModelRendererTurbo(this, 57, 73, texture, texture); // Box 95
        body_colored_primary[56] = new ModelRendererTurbo(this, 665, 73, texture, texture); // Box 97
        body_colored_primary[57] = new ModelRendererTurbo(this, 969, 57, texture, texture); // Box 98
        body_colored_primary[58] = new ModelRendererTurbo(this, 17, 65, texture, texture); // Box 99
        body_colored_primary[59] = new ModelRendererTurbo(this, 713, 73, texture, texture); // Box 100
        body_colored_primary[60] = new ModelRendererTurbo(this, 113, 73, texture, texture); // Box 101
        body_colored_primary[61] = new ModelRendererTurbo(this, 281, 65, texture, texture); // Box 102
        body_colored_primary[62] = new ModelRendererTurbo(this, 113, 65, texture, texture); // Box 103
        body_colored_primary[63] = new ModelRendererTurbo(this, 481, 65, texture, texture); // Box 104
        body_colored_primary[64] = new ModelRendererTurbo(this, 833, 65, texture, texture); // Box 105
        body_colored_primary[65] = new ModelRendererTurbo(this, 17, 73, texture, texture); // Box 106
        body_colored_primary[66] = new ModelRendererTurbo(this, 33, 73, texture, texture); // Box 107
        body_colored_primary[67] = new ModelRendererTurbo(this, 761, 73, texture, texture); // Box 109
        body_colored_primary[68] = new ModelRendererTurbo(this, 161, 73, texture, texture); // Box 110
        body_colored_primary[69] = new ModelRendererTurbo(this, 937, 73, texture, texture); // Box 111
        body_colored_primary[70] = new ModelRendererTurbo(this, 833, 73, texture, texture); // Box 112
        body_colored_primary[71] = new ModelRendererTurbo(this, 321, 81, texture, texture); // Box 113
        body_colored_primary[72] = new ModelRendererTurbo(this, 1009, 65, texture, texture); // Box 114
        body_colored_primary[73] = new ModelRendererTurbo(this, 977, 73, texture, texture); // Box 115
        body_colored_primary[74] = new ModelRendererTurbo(this, 385, 81, texture, texture); // Box 119
        body_colored_primary[75] = new ModelRendererTurbo(this, 57, 81, texture, texture); // Box 120
        body_colored_primary[76] = new ModelRendererTurbo(this, 449, 81, texture, texture); // Box 198
        body_colored_primary[77] = new ModelRendererTurbo(this, 513, 81, texture, texture); // Box 200
        body_colored_primary[78] = new ModelRendererTurbo(this, 529, 81, texture, texture); // Box 205
        body_colored_primary[79] = new ModelRendererTurbo(this, 17, 81, texture, texture); // Box 206
        body_colored_primary[80] = new ModelRendererTurbo(this, 705, 73, texture, texture); // Box 207
        body_colored_primary[81] = new ModelRendererTurbo(this, 545, 81, texture, texture); // Box 208
        body_colored_primary[82] = new ModelRendererTurbo(this, 593, 81, texture, texture); // Box 209
        body_colored_primary[83] = new ModelRendererTurbo(this, 809, 73, texture, texture); // Box 210
        body_colored_primary[84] = new ModelRendererTurbo(this, 625, 81, texture, texture); // Box 211
        body_colored_primary[85] = new ModelRendererTurbo(this, 633, 81, texture, texture); // Box 212
        body_colored_primary[86] = new ModelRendererTurbo(this, 113, 89, texture, texture); // Box 213
        body_colored_primary[87] = new ModelRendererTurbo(this, 937, 81, texture, texture); // Box 214
        body_colored_primary[88] = new ModelRendererTurbo(this, 945, 81, texture, texture); // Box 215
        body_colored_primary[89] = new ModelRendererTurbo(this, 953, 81, texture, texture); // Box 216
        body_colored_primary[90] = new ModelRendererTurbo(this, 217, 89, texture, texture); // Box 218
        body_colored_primary[91] = new ModelRendererTurbo(this, 409, 89, texture, texture); // Box 221
        body_colored_primary[92] = new ModelRendererTurbo(this, 417, 89, texture, texture); // Box 222
        body_colored_primary[93] = new ModelRendererTurbo(this, 425, 89, texture, texture); // Box 223
        body_colored_primary[94] = new ModelRendererTurbo(this, 545, 89, texture, texture); // Box 224
        body_colored_primary[95] = new ModelRendererTurbo(this, 833, 89, texture, texture); // Box 225
        body_colored_primary[96] = new ModelRendererTurbo(this, 865, 89, texture, texture); // Box 226
        body_colored_primary[97] = new ModelRendererTurbo(this, 961, 89, texture, texture); // Box 227
        body_colored_primary[98] = new ModelRendererTurbo(this, 1, 97, texture, texture); // Box 228
        body_colored_primary[99] = new ModelRendererTurbo(this, 321, 97, texture, texture); // Box 229
        body_colored_primary[100] = new ModelRendererTurbo(this, 425, 97, texture, texture); // Box 230
        body_colored_primary[101] = new ModelRendererTurbo(this, 481, 97, texture, texture); // Box 231
        body_colored_primary[102] = new ModelRendererTurbo(this, 569, 89, texture, texture); // Box 232
        body_colored_primary[103] = new ModelRendererTurbo(this, 57, 97, texture, texture); // Box 235
        body_colored_primary[104] = new ModelRendererTurbo(this, 113, 65, texture, texture); // Box 236
        body_colored_primary[105] = new ModelRendererTurbo(this, 713, 73, texture, texture); // Box 237
        body_colored_primary[106] = new ModelRendererTurbo(this, 753, 73, texture, texture); // Box 238
        body_colored_primary[107] = new ModelRendererTurbo(this, 873, 73, texture, texture); // Box 239
        body_colored_primary[108] = new ModelRendererTurbo(this, 929, 73, texture, texture); // Box 240
        body_colored_primary[109] = new ModelRendererTurbo(this, 1, 81, texture, texture); // Box 241
        body_colored_primary[110] = new ModelRendererTurbo(this, 97, 81, texture, texture); // Box 242
        body_colored_primary[111] = new ModelRendererTurbo(this, 617, 89, texture, texture); // Box 243
        body_colored_primary[112] = new ModelRendererTurbo(this, 841, 17, texture, texture); // Box 247
        body_colored_primary[113] = new ModelRendererTurbo(this, 425, 105, texture, texture); // Box 249
        body_colored_primary[114] = new ModelRendererTurbo(this, 641, 97, texture, texture); // Box 250
        body_colored_primary[115] = new ModelRendererTurbo(this, 385, 97, texture, texture); // Box 251
        body_colored_primary[116] = new ModelRendererTurbo(this, 201, 89, texture, texture); // Box 252
        body_colored_primary[117] = new ModelRendererTurbo(this, 833, 97, texture, texture); // Box 253
        body_colored_primary[118] = new ModelRendererTurbo(this, 921, 97, texture, texture); // Box 255
        body_colored_primary[119] = new ModelRendererTurbo(this, 857, 97, texture, texture); // Box 256
        body_colored_primary[120] = new ModelRendererTurbo(this, 401, 97, texture, texture); // Box 264
        body_colored_primary[121] = new ModelRendererTurbo(this, 113, 105, texture, texture); // Box 269
        body_colored_primary[122] = new ModelRendererTurbo(this, 761, 105, texture, texture); // Box 278
        body_colored_primary[123] = new ModelRendererTurbo(this, 401, 105, texture, texture); // Box 279
        body_colored_primary[124] = new ModelRendererTurbo(this, 57, 105, texture, texture); // Box 280
        body_colored_primary[125] = new ModelRendererTurbo(this, 1001, 105, texture, texture); // Box 281
        body_colored_primary[126] = new ModelRendererTurbo(this, 321, 105, texture, texture); // Box 282
        body_colored_primary[127] = new ModelRendererTurbo(this, 305, 89, texture, texture); // Box 283
        body_colored_primary[128] = new ModelRendererTurbo(this, 457, 73, texture, texture); // Box 284
        body_colored_primary[129] = new ModelRendererTurbo(this, 481, 73, texture, texture); // Box 286
        body_colored_primary[130] = new ModelRendererTurbo(this, 833, 105, texture, texture); // Box 292
        body_colored_primary[131] = new ModelRendererTurbo(this, 41, 121, texture, texture); // Box 293
        body_colored_primary[132] = new ModelRendererTurbo(this, 73, 121, texture, texture); // Box 294
        body_colored_primary[133] = new ModelRendererTurbo(this, 25, 113, texture, texture); // Box 295
        body_colored_primary[134] = new ModelRendererTurbo(this, 177, 105, texture, texture); // Box 296
        body_colored_primary[135] = new ModelRendererTurbo(this, 121, 121, texture, texture); // Box 297
        body_colored_primary[136] = new ModelRendererTurbo(this, 161, 121, texture, texture); // Box 298
        body_colored_primary[137] = new ModelRendererTurbo(this, 281, 105, texture, texture); // Box 299
        body_colored_primary[138] = new ModelRendererTurbo(this, 193, 121, texture, texture); // Box 300
        body_colored_primary[139] = new ModelRendererTurbo(this, 1009, 113, texture, texture); // Box 301
        body_colored_primary[140] = new ModelRendererTurbo(this, 225, 121, texture, texture); // Box 302
        body_colored_primary[141] = new ModelRendererTurbo(this, 241, 121, texture, texture); // Box 303
        body_colored_primary[142] = new ModelRendererTurbo(this, 257, 121, texture, texture); // Box 304
        body_colored_primary[143] = new ModelRendererTurbo(this, 273, 121, texture, texture); // Box 305
        body_colored_primary[144] = new ModelRendererTurbo(this, 305, 121, texture, texture); // Box 306
        body_colored_primary[145] = new ModelRendererTurbo(this, 617, 121, texture, texture); // Box 307
        body_colored_primary[146] = new ModelRendererTurbo(this, 657, 121, texture, texture); // Box 308
        body_colored_primary[147] = new ModelRendererTurbo(this, 697, 121, texture, texture); // Box 309
        body_colored_primary[148] = new ModelRendererTurbo(this, 361, 113, texture, texture); // Box 310
        body_colored_primary[149] = new ModelRendererTurbo(this, 761, 121, texture, texture); // Box 311
        body_colored_primary[150] = new ModelRendererTurbo(this, 793, 121, texture, texture); // Box 315
        body_colored_primary[151] = new ModelRendererTurbo(this, 857, 121, texture, texture); // Box 316
        body_colored_primary[152] = new ModelRendererTurbo(this, 305, 97, texture, texture); // Box 317
        body_colored_primary[153] = new ModelRendererTurbo(this, 1, 129, texture, texture); // Box 323
        body_colored_primary[154] = new ModelRendererTurbo(this, 25, 129, texture, texture); // Box 325
        body_colored_primary[155] = new ModelRendererTurbo(this, 337, 97, texture, texture); // Box 326
        body_colored_primary[156] = new ModelRendererTurbo(this, 641, 177, texture, texture); // Box 342
        body_colored_primary[157] = new ModelRendererTurbo(this, 593, 177, texture, texture); // Box 394
        body_colored_primary[158] = new ModelRendererTurbo(this, 369, 185, texture, texture); // Box 395
        body_colored_primary[159] = new ModelRendererTurbo(this, 401, 185, texture, texture); // Box 397
        body_colored_primary[160] = new ModelRendererTurbo(this, 969, 169, texture, texture); // Box 417
        body_colored_primary[161] = new ModelRendererTurbo(this, 833, 177, texture, texture); // Box 419
        body_colored_primary[162] = new ModelRendererTurbo(this, 817, 217, texture, texture); // Box 421
        body_colored_primary[163] = new ModelRendererTurbo(this, 345, 193, texture, texture); // Box 423
        body_colored_primary[164] = new ModelRendererTurbo(this, 873, 217, texture, texture); // Box 425
        body_colored_primary[165] = new ModelRendererTurbo(this, 929, 217, texture, texture); // Box 426
        body_colored_primary[166] = new ModelRendererTurbo(this, 1, 225, texture, texture); // Box 427
        body_colored_primary[167] = new ModelRendererTurbo(this, 265, 225, texture, texture); // Box 428
        body_colored_primary[168] = new ModelRendererTurbo(this, 729, 185, texture, texture); // Box 430
        body_colored_primary[169] = new ModelRendererTurbo(this, 849, 129, texture, texture); // Box 432
        body_colored_primary[170] = new ModelRendererTurbo(this, 537, 193, texture, texture); // Box 433
        body_colored_primary[171] = new ModelRendererTurbo(this, 1009, 137, texture, texture); // Box 434
        body_colored_primary[172] = new ModelRendererTurbo(this, 57, 145, texture, texture); // Box 435
        body_colored_primary[173] = new ModelRendererTurbo(this, 409, 145, texture, texture); // Box 436
        body_colored_primary[174] = new ModelRendererTurbo(this, 769, 145, texture, texture); // Box 437
        body_colored_primary[175] = new ModelRendererTurbo(this, 881, 145, texture, texture); // Box 438
        body_colored_primary[176] = new ModelRendererTurbo(this, 497, 233, texture, texture); // Box 439

        body_colored_primary[0].addShapeBox(0F, 0F, 0F, 117, 8, 1, 0F, 0F, 0F, -1F, 0F, 0F, -2F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 0
        body_colored_primary[0].setRotationPoint(-97.5F, -55.5F, -24F);

        body_colored_primary[1].addBox(0F, 0F, 0F, 4, 8, 1, 0F); // Box 1
        body_colored_primary[1].setRotationPoint(-101.5F, -47.5F, -24F);

        body_colored_primary[2].addShapeBox(0F, 0F, 0F, 4, 4, 46, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 7
        body_colored_primary[2].setRotationPoint(39.5F, -44.5F, -24F);

        body_colored_primary[3].addShapeBox(0F, 0F, 0F, 2, 2, 46, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 8
        body_colored_primary[3].setRotationPoint(43.5F, -41.5F, -24F);

        body_colored_primary[4].addBox(0F, 0F, 0F, 19, 1, 1, 0F); // Box 9
        body_colored_primary[4].setRotationPoint(24.5F, -40.5F, -24F);

        body_colored_primary[5].addBox(0F, 0F, 0F, 11, 7, 1, 0F); // Box 10
        body_colored_primary[5].setRotationPoint(24.5F, -47.5F, -24F);

        body_colored_primary[6].addShapeBox(0F, 0F, 0F, 1, 8, 44, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 2F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 2F, 0F, 0F); // Box 11
        body_colored_primary[6].setRotationPoint(-100.5F, -55.5F, -23F);

        body_colored_primary[7].addShapeBox(0F, 0F, 0F, 2, 8, 1, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 12
        body_colored_primary[7].setRotationPoint(-99.5F, -55.5F, -24F);

        body_colored_primary[8].addBox(0F, 0F, 0F, 83, 8, 1, 0F); // Box 13
        body_colored_primary[8].setRotationPoint(-97.5F, -47.5F, -24F);

        body_colored_primary[9].addBox(0F, 0F, 0F, 39, 8, 1, 0F); // Box 14
        body_colored_primary[9].setRotationPoint(-14.5F, -47.5F, -24F);

        body_colored_primary[10].addShapeBox(0F, 0F, 0F, 1, 8, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F); // Box 15
        body_colored_primary[10].setRotationPoint(-102.5F, -47.5F, -24F);

        body_colored_primary[11].addShapeBox(0F, 0F, 0F, 1, 6, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F); // Box 16
        body_colored_primary[11].setRotationPoint(-103.5F, -39.5F, -24F);

        body_colored_primary[12].addShapeBox(0F, 0F, 0F, 1, 14, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F); // Box 17
        body_colored_primary[12].setRotationPoint(-104.5F, -33.5F, -24F);

        body_colored_primary[13].addShapeBox(0F, 0F, 0F, 38, 6, 1, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 19
        body_colored_primary[13].setRotationPoint(-51.5F, -5.5F, -24F);

        body_colored_primary[14].addBox(0F, 0F, 0F, 1, 34, 1, 0F); // Box 22
        body_colored_primary[14].setRotationPoint(-14.5F, -39.5F, -24F);

        body_colored_primary[15].addBox(0F, 0F, 0F, 1, 40, 1, 0F); // Box 23
        body_colored_primary[15].setRotationPoint(24.5F, -39.5F, -24F);

        body_colored_primary[16].addShapeBox(0F, 0F, 0F, 9, 2, 1, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 24
        body_colored_primary[16].setRotationPoint(-52.5F, -7.5F, -24F);

        body_colored_primary[17].addShapeBox(0F, 0F, 0F, 10, 2, 1, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 25
        body_colored_primary[17].setRotationPoint(-53.5F, -9.5F, -24F);

        body_colored_primary[18].addShapeBox(0F, 0F, 0F, 12, 2, 1, 0F, 3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 26
        body_colored_primary[18].setRotationPoint(-55.5F, -11.5F, -24F);

        body_colored_primary[19].addShapeBox(0F, 0F, 0F, 15, 2, 1, 0F, 4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 4F, 0F, 0F, 4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 4F, 0F, 0F); // Box 27
        body_colored_primary[19].setRotationPoint(-58.5F, -13.5F, -24F);

        body_colored_primary[20].addShapeBox(0F, 0F, 0F, 24, 2, 1, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 28
        body_colored_primary[20].setRotationPoint(-96.5F, -7.5F, -24F);

        body_colored_primary[21].addShapeBox(0F, 0F, 0F, 25, 2, 1, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 29
        body_colored_primary[21].setRotationPoint(-96.5F, -9.5F, -24F);

        body_colored_primary[22].addShapeBox(0F, 0F, 0F, 27, 2, 1, 0F, 0F, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 30
        body_colored_primary[22].setRotationPoint(-96.5F, -11.5F, -24F);

        body_colored_primary[23].addShapeBox(0F, 0F, 0F, 23, 5, 1, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 32
        body_colored_primary[23].setRotationPoint(-96.5F, -5.5F, -24F);

        body_colored_primary[24].addBox(0F, 0F, 0F, 53, 2, 1, 0F); // Box 33
        body_colored_primary[24].setRotationPoint(-96.5F, -15.5F, -24F);

        body_colored_primary[25].addShapeBox(0F, 0F, 0F, 7, 2, 1, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 34
        body_colored_primary[25].setRotationPoint(68.5F, -8.5F, -24F);

        body_colored_primary[26].addShapeBox(0F, 0F, 0F, 9, 2, 1, 0F, 4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 37
        body_colored_primary[26].setRotationPoint(66.5F, -10.5F, -24F);

        body_colored_primary[27].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 38
        body_colored_primary[27].setRotationPoint(50.5F, -8.5F, -24F);

        body_colored_primary[28].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 39
        body_colored_primary[28].setRotationPoint(49.5F, -6.5F, -24F);

        body_colored_primary[29].addShapeBox(0F, 0F, 0F, 2, 2, 1, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F); // Box 40
        body_colored_primary[29].setRotationPoint(47.5F, -4.5F, -24F);

        body_colored_primary[30].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 4F, 0F, 0F, 4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 41
        body_colored_primary[30].setRotationPoint(52.5F, -10.5F, -24F);

        body_colored_primary[31].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F); // Box 42
        body_colored_primary[31].setRotationPoint(48.5F, -6.5F, -24F);

        body_colored_primary[32].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F); // Box 43
        body_colored_primary[32].setRotationPoint(49.5F, -8.5F, -24F);

        body_colored_primary[33].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F); // Box 44
        body_colored_primary[33].setRotationPoint(51.5F, -10.5F, -24F);

        body_colored_primary[34].addShapeBox(0F, 0F, 0F, 2, 2, 1, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F); // Box 45
        body_colored_primary[34].setRotationPoint(46.5F, -2.5F, -24F);

        body_colored_primary[35].addShapeBox(0F, 0F, 0F, 3, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 49
        body_colored_primary[35].setRotationPoint(45.5F, -0.5F, -24F);

        body_colored_primary[36].addBox(0F, 0F, 0F, 83, 18, 1, 0F); // Box 51
        body_colored_primary[36].setRotationPoint(-97.5F, -39.5F, -24F);

        body_colored_primary[37].addBox(0F, 0F, 0F, 89, 6, 1, 0F); // Box 52
        body_colored_primary[37].setRotationPoint(-103.5F, -21.5F, -24F);

        body_colored_primary[38].addBox(0F, 0F, 0F, 5, 18, 1, 0F); // Box 53
        body_colored_primary[38].setRotationPoint(-102.5F, -39.5F, -24F);

        body_colored_primary[39].addBox(0F, 0F, 0F, 1, 12, 1, 0F); // Box 54
        body_colored_primary[39].setRotationPoint(-103.5F, -33.5F, -24F);

        body_colored_primary[40].addBox(0F, 0F, 0F, 7, 6, 1, 0F); // Box 55
        body_colored_primary[40].setRotationPoint(-103.5F, -15.5F, -24F);

        body_colored_primary[41].addShapeBox(0F, 0F, 0F, 13, 1, 1, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 57
        body_colored_primary[41].setRotationPoint(62.5F, -11.5F, -24F);

        body_colored_primary[42].addShapeBox(0F, 0F, 0F, 7, 1, 1, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 58
        body_colored_primary[42].setRotationPoint(50.5F, -11.5F, -24F);

        body_colored_primary[43].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // Box 66
        body_colored_primary[43].setRotationPoint(-105.5F, -11.5F, -24F);

        body_colored_primary[44].addShapeBox(0F, 0F, 0F, 30, 2, 1, 0F, 0F, 0F, 0F, 4F, 0F, 0F, 4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 4F, 0F, 0F, 4F, 0F, 0F, 0F, 0F, 0F); // Box 71
        body_colored_primary[44].setRotationPoint(-96.5F, -13.5F, -24F);

        body_colored_primary[45].addBox(0F, 0F, 0F, 38, 6, 1, 0F); // Box 77
        body_colored_primary[45].setRotationPoint(-13.5F, -5.5F, -24F);

        body_colored_primary[46].addShapeBox(0F, 0F, 0F, 25, 1, 1, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 80
        body_colored_primary[46].setRotationPoint(50.5F, -12.5F, -24F);

        body_colored_primary[47].addShapeBox(0F, 0F, 0F, 2, 13, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F); // Box 81
        body_colored_primary[47].setRotationPoint(25.5F, -12.5F, -24F);

        body_colored_primary[48].addShapeBox(0F, 0F, 0F, 2, 3, 1, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 82
        body_colored_primary[48].setRotationPoint(25.5F, -15.5F, -24F);

        body_colored_primary[49].addBox(0F, 0F, 0F, 1, 23, 1, 0F); // Box 83
        body_colored_primary[49].setRotationPoint(25.5F, -38.5F, -24F);

        body_colored_primary[50].addShapeBox(0F, 0F, 0F, 19, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F); // Box 84
        body_colored_primary[50].setRotationPoint(56.5F, -14.5F, -24F);

        body_colored_primary[51].addShapeBox(0F, 0F, 0F, 1, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F); // Box 85
        body_colored_primary[51].setRotationPoint(75.5F, -12.5F, -24F);

        body_colored_primary[52].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F); // Box 86
        body_colored_primary[52].setRotationPoint(75.5F, -8.5F, -24F);

        body_colored_primary[53].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 88
        body_colored_primary[53].setRotationPoint(75.5F, -7.5F, -24F);

        body_colored_primary[54].addShapeBox(0F, 0F, 0F, 18, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F); // Box 94
        body_colored_primary[54].setRotationPoint(56.5F, -16.5F, -24F);

        body_colored_primary[55].addShapeBox(0F, 0F, 0F, 17, 2, 1, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 2F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 5F, 0F, 1F, 0F, 0F, 0F); // Box 95
        body_colored_primary[55].setRotationPoint(56.5F, -18.5F, -24F);

        body_colored_primary[56].addShapeBox(0F, 0F, 0F, 15, 2, 5, 0F, 0F, 0F, 0F, -2F, 0F, -1F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -1F, 1F, 0F, 0F, 0F, 0F, 0F); // Box 97
        body_colored_primary[56].setRotationPoint(59.5F, -20.5F, -23F);

        body_colored_primary[57].addShapeBox(0F, 0F, 0F, 12, 2, 5, 0F, 0F, 0F, 0F, -2F, 0F, -1F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -1F, 1F, 0F, 0F, 0F, 0F, 0F); // Box 98
        body_colored_primary[57].setRotationPoint(59.5F, -22.5F, -23F);

        body_colored_primary[58].addShapeBox(0F, 0F, 0F, 9, 2, 1, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 4F, 0F, 1F, 0F, 0F, 0F); // Box 99
        body_colored_primary[58].setRotationPoint(56.5F, -24.5F, -24F);

        body_colored_primary[59].addShapeBox(0F, 0F, 0F, 17, 2, 5, 0F, 0F, 0F, 0F, -1F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, -1F, 2F, 0F, 0F, 0F, 0F, 0F); // Box 100
        body_colored_primary[59].setRotationPoint(59.5F, -18.5F, -23F);

        body_colored_primary[60].addShapeBox(0F, 0F, 0F, 15, 2, 1, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 1F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 4F, 0F, 1F, 0F, 0F, 0F); // Box 101
        body_colored_primary[60].setRotationPoint(56.5F, -20.5F, -24F);

        body_colored_primary[61].addShapeBox(0F, 0F, 0F, 12, 2, 1, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 1F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 4F, 0F, 1F, 0F, 0F, 0F); // Box 102
        body_colored_primary[61].setRotationPoint(56.5F, -22.5F, -24F);

        body_colored_primary[62].addShapeBox(0F, 0F, 0F, 9, 2, 5, 0F, 0F, 0F, 0F, -2F, 0F, -1F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, -1F, 2F, 0F, 0F, 0F, 0F, 0F); // Box 103
        body_colored_primary[62].setRotationPoint(58.5F, -24.5F, -23F);

        body_colored_primary[63].addShapeBox(0F, 0F, 0F, 2, 2, 4, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 104
        body_colored_primary[63].setRotationPoint(77.5F, -16.5F, -21.5F);

        body_colored_primary[64].addShapeBox(0F, 0F, 0F, 2, 2, 4, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 105
        body_colored_primary[64].setRotationPoint(78.5F, -14.5F, -21.5F);

        body_colored_primary[65].addShapeBox(0F, 0F, 0F, 2, 2, 4, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 106
        body_colored_primary[65].setRotationPoint(79.5F, -12.5F, -21.5F);

        body_colored_primary[66].addShapeBox(0F, 0F, 0F, 2, 3, 4, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F); // Box 107
        body_colored_primary[66].setRotationPoint(80.5F, -10.5F, -21.5F);

        body_colored_primary[67].addShapeBox(0F, 0F, 0F, 14, 4, 1, 0F, 1F, 0F, 0F, 4F, 0F, 0F, 4F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F); // Box 109
        body_colored_primary[67].setRotationPoint(29.5F, -4.5F, -24F);

        body_colored_primary[68].addShapeBox(0F, 0F, 0F, 16, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 110
        body_colored_primary[68].setRotationPoint(29.5F, -0.5F, -24F);

        body_colored_primary[69].addShapeBox(0F, 0F, 0F, 18, 6, 1, 0F, 1F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F); // Box 111
        body_colored_primary[69].setRotationPoint(28.5F, -12.5F, -24F);

        body_colored_primary[70].addShapeBox(0F, 0F, 0F, 15, 2, 1, 0F, 1F, 0F, 0F, 4F, 0F, 0F, 4F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, 1F, 0F, 0F); // Box 112
        body_colored_primary[70].setRotationPoint(29.5F, -6.5F, -24F);

        body_colored_primary[71].addShapeBox(0F, 0F, 0F, 29, 3, 1, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 113
        body_colored_primary[71].setRotationPoint(27.5F, -15.5F, -24F);

        body_colored_primary[72].addShapeBox(0F, 0F, 0F, 2, 18, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F); // Box 114
        body_colored_primary[72].setRotationPoint(26.5F, -38.5F, -24F);

        body_colored_primary[73].addShapeBox(0F, 0F, 0F, 14, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F); // Box 115
        body_colored_primary[73].setRotationPoint(30.5F, -22.5F, -24F);

        body_colored_primary[74].addShapeBox(0F, 0F, 0F, 27, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 119
        body_colored_primary[74].setRotationPoint(29.5F, -18.5F, -24F);

        body_colored_primary[75].addShapeBox(0F, 0F, 0F, 17, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F); // Box 120
        body_colored_primary[75].setRotationPoint(29.5F, -20.5F, -24F);

        body_colored_primary[76].addBox(0F, 0F, 0F, 29, 10, 1, 0F); // Box 198
        body_colored_primary[76].setRotationPoint(-43.5F, -15.5F, -24F);

        body_colored_primary[77].addBox(0F, 0F, 0F, 4, 8, 1, 0F); // Box 200
        body_colored_primary[77].setRotationPoint(-101.5F, -47.5F, 22F);

        body_colored_primary[78].addShapeBox(0F, 0F, 0F, 4, 7, 1, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 205
        body_colored_primary[78].setRotationPoint(35.5F, -47.5F, 22F);

        body_colored_primary[79].addShapeBox(0F, 0F, 0F, 4, 4, 1, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 206
        body_colored_primary[79].setRotationPoint(39.5F, -44.5F, 22F);

        body_colored_primary[80].addShapeBox(0F, 0F, 0F, 2, 2, 1, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 207
        body_colored_primary[80].setRotationPoint(43.5F, -41.5F, 22F);

        body_colored_primary[81].addBox(0F, 0F, 0F, 19, 1, 1, 0F); // Box 208
        body_colored_primary[81].setRotationPoint(24.5F, -40.5F, 22F);

        body_colored_primary[82].addBox(0F, 0F, 0F, 11, 7, 1, 0F); // Box 209
        body_colored_primary[82].setRotationPoint(24.5F, -47.5F, 22F);

        body_colored_primary[83].addShapeBox(0F, 0F, 0F, 1, 8, 1, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 2F, 0F, 1F); // Box 210
        body_colored_primary[83].setRotationPoint(-100.5F, -55.5F, 21F);

        body_colored_primary[84].addShapeBox(0F, 0F, 0F, 2, 8, 1, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 211
        body_colored_primary[84].setRotationPoint(-99.5F, -55.5F, 22F);

        body_colored_primary[85].addBox(0F, 0F, 0F, 83, 8, 1, 0F); // Box 212
        body_colored_primary[85].setRotationPoint(-97.5F, -47.5F, 22F);

        body_colored_primary[86].addBox(0F, 0F, 0F, 39, 8, 1, 0F); // Box 213
        body_colored_primary[86].setRotationPoint(-14.5F, -47.5F, 22F);

        body_colored_primary[87].addShapeBox(0F, 0F, 0F, 1, 8, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F); // Box 214
        body_colored_primary[87].setRotationPoint(-102.5F, -47.5F, 22F);

        body_colored_primary[88].addShapeBox(0F, 0F, 0F, 1, 6, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F); // Box 215
        body_colored_primary[88].setRotationPoint(-103.5F, -39.5F, 22F);

        body_colored_primary[89].addShapeBox(0F, 0F, 0F, 1, 14, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F); // Box 216
        body_colored_primary[89].setRotationPoint(-104.5F, -33.5F, 22F);

        body_colored_primary[90].addShapeBox(0F, 0F, 0F, 39, 6, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 218
        body_colored_primary[90].setRotationPoint(-52.5F, -5.5F, 22F);

        body_colored_primary[91].addBox(0F, 0F, 0F, 1, 34, 1, 0F); // Box 221
        body_colored_primary[91].setRotationPoint(-14.5F, -39.5F, 22F);

        body_colored_primary[92].addBox(0F, 0F, 0F, 1, 40, 1, 0F); // Box 222
        body_colored_primary[92].setRotationPoint(24.5F, -39.5F, 22F);

        body_colored_primary[93].addShapeBox(0F, 0F, 0F, 9, 2, 1, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 223
        body_colored_primary[93].setRotationPoint(-52.5F, -7.5F, 22F);

        body_colored_primary[94].addShapeBox(0F, 0F, 0F, 10, 2, 1, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 224
        body_colored_primary[94].setRotationPoint(-53.5F, -9.5F, 22F);

        body_colored_primary[95].addShapeBox(0F, 0F, 0F, 12, 2, 1, 0F, 3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 225
        body_colored_primary[95].setRotationPoint(-55.5F, -11.5F, 22F);

        body_colored_primary[96].addShapeBox(0F, 0F, 0F, 15, 2, 1, 0F, 4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 4F, 0F, 0F, 4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 4F, 0F, 0F); // Box 226
        body_colored_primary[96].setRotationPoint(-58.5F, -13.5F, 22F);

        body_colored_primary[97].addShapeBox(0F, 0F, 0F, 24, 2, 1, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 227
        body_colored_primary[97].setRotationPoint(-96.5F, -7.5F, 22F);

        body_colored_primary[98].addShapeBox(0F, 0F, 0F, 25, 2, 1, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 228
        body_colored_primary[98].setRotationPoint(-96.5F, -9.5F, 22F);

        body_colored_primary[99].addShapeBox(0F, 0F, 0F, 27, 2, 1, 0F, 0F, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 229
        body_colored_primary[99].setRotationPoint(-96.5F, -11.5F, 22F);

        body_colored_primary[100].addShapeBox(0F, 0F, 0F, 23, 5, 1, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 230
        body_colored_primary[100].setRotationPoint(-96.5F, -5.5F, 22F);

        body_colored_primary[101].addBox(0F, 0F, 0F, 53, 2, 1, 0F); // Box 231
        body_colored_primary[101].setRotationPoint(-96.5F, -15.5F, 22F);

        body_colored_primary[102].addShapeBox(0F, 0F, 0F, 7, 2, 1, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 232
        body_colored_primary[102].setRotationPoint(68.5F, -8.5F, 22F);

        body_colored_primary[103].addShapeBox(0F, 0F, 0F, 9, 2, 1, 0F, 4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 235
        body_colored_primary[103].setRotationPoint(66.5F, -10.5F, 22F);

        body_colored_primary[104].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 236
        body_colored_primary[104].setRotationPoint(50.5F, -8.5F, 22F);

        body_colored_primary[105].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 237
        body_colored_primary[105].setRotationPoint(49.5F, -6.5F, 22F);

        body_colored_primary[106].addShapeBox(0F, 0F, 0F, 2, 2, 1, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F); // Box 238
        body_colored_primary[106].setRotationPoint(47.5F, -4.5F, 22F);

        body_colored_primary[107].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 4F, 0F, 0F, 4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 239
        body_colored_primary[107].setRotationPoint(52.5F, -10.5F, 22F);

        body_colored_primary[108].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F); // Box 240
        body_colored_primary[108].setRotationPoint(48.5F, -6.5F, 22F);

        body_colored_primary[109].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F); // Box 241
        body_colored_primary[109].setRotationPoint(49.5F, -8.5F, 22F);

        body_colored_primary[110].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F); // Box 242
        body_colored_primary[110].setRotationPoint(51.5F, -10.5F, 22F);

        body_colored_primary[111].addShapeBox(0F, 0F, 0F, 2, 2, 1, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F); // Box 243
        body_colored_primary[111].setRotationPoint(46.5F, -2.5F, 22F);

        body_colored_primary[112].addShapeBox(0F, 0F, 0F, 3, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 247
        body_colored_primary[112].setRotationPoint(45.5F, -0.5F, 22F);

        body_colored_primary[113].addBox(0F, 0F, 0F, 83, 18, 1, 0F); // Box 249
        body_colored_primary[113].setRotationPoint(-97.5F, -39.5F, 22F);

        body_colored_primary[114].addBox(0F, 0F, 0F, 89, 6, 1, 0F); // Box 250
        body_colored_primary[114].setRotationPoint(-103.5F, -21.5F, 22F);

        body_colored_primary[115].addBox(0F, 0F, 0F, 5, 18, 1, 0F); // Box 251
        body_colored_primary[115].setRotationPoint(-102.5F, -39.5F, 22F);

        body_colored_primary[116].addBox(0F, 0F, 0F, 1, 12, 1, 0F); // Box 252
        body_colored_primary[116].setRotationPoint(-103.5F, -33.5F, 22F);

        body_colored_primary[117].addBox(0F, 0F, 0F, 7, 6, 1, 0F); // Box 253
        body_colored_primary[117].setRotationPoint(-103.5F, -15.5F, 22F);

        body_colored_primary[118].addShapeBox(0F, 0F, 0F, 13, 1, 1, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 255
        body_colored_primary[118].setRotationPoint(62.5F, -11.5F, 22F);

        body_colored_primary[119].addShapeBox(0F, 0F, 0F, 7, 1, 1, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 256
        body_colored_primary[119].setRotationPoint(50.5F, -11.5F, 22F);

        body_colored_primary[120].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // Box 264
        body_colored_primary[120].setRotationPoint(-105.5F, -11.5F, 22F);

        body_colored_primary[121].addShapeBox(0F, 0F, 0F, 30, 2, 1, 0F, 0F, 0F, 0F, 4F, 0F, 0F, 4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 4F, 0F, 0F, 4F, 0F, 0F, 0F, 0F, 0F); // Box 269
        body_colored_primary[121].setRotationPoint(-96.5F, -13.5F, 22F);

        body_colored_primary[122].addShapeBox(0F, 0F, 0F, 25, 1, 1, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 278
        body_colored_primary[122].setRotationPoint(50.5F, -12.5F, 22F);

        body_colored_primary[123].addShapeBox(0F, 0F, 0F, 2, 13, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F); // Box 279
        body_colored_primary[123].setRotationPoint(25.5F, -12.5F, 22F);

        body_colored_primary[124].addShapeBox(0F, 0F, 0F, 2, 3, 1, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 280
        body_colored_primary[124].setRotationPoint(25.5F, -15.5F, 22F);

        body_colored_primary[125].addBox(0F, 0F, 0F, 1, 23, 1, 0F); // Box 281
        body_colored_primary[125].setRotationPoint(25.5F, -38.5F, 22F);

        body_colored_primary[126].addShapeBox(0F, 0F, 0F, 19, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F); // Box 282
        body_colored_primary[126].setRotationPoint(56.5F, -14.5F, 22F);

        body_colored_primary[127].addShapeBox(0F, 0F, 0F, 1, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F); // Box 283
        body_colored_primary[127].setRotationPoint(75.5F, -12.5F, 22F);

        body_colored_primary[128].addShapeBox(0F, 0F, 0F, 3, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 284
        body_colored_primary[128].setRotationPoint(75.5F, -8.5F, 22F);

        body_colored_primary[129].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F); // Box 286
        body_colored_primary[129].setRotationPoint(75.5F, -7.5F, 22F);

        body_colored_primary[130].addShapeBox(0F, 0F, 0F, 18, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F); // Box 292
        body_colored_primary[130].setRotationPoint(56.5F, -16.5F, 22F);

        body_colored_primary[131].addShapeBox(0F, 0F, 0F, 17, 2, 1, 0F, 0F, 0F, 0F, 2F, 0F, 1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 5F, 0F, 1F, 1F, 0F, 0F, 0F, 0F, 0F); // Box 293
        body_colored_primary[131].setRotationPoint(56.5F, -18.5F, 22F);

        body_colored_primary[132].addShapeBox(0F, 0F, 0F, 15, 2, 5, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, -1F, 0F, 0F, 0F); // Box 294
        body_colored_primary[132].setRotationPoint(59.5F, -20.5F, 17F);

        body_colored_primary[133].addShapeBox(0F, 0F, 0F, 12, 2, 5, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, -1F, 0F, 0F, 0F); // Box 295
        body_colored_primary[133].setRotationPoint(59.5F, -22.5F, 17F);

        body_colored_primary[134].addShapeBox(0F, 0F, 0F, 9, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 4F, 0F, 1F, 1F, 0F, 0F, 0F, 0F, 0F); // Box 296
        body_colored_primary[134].setRotationPoint(56.5F, -24.5F, 22F);

        body_colored_primary[135].addShapeBox(0F, 0F, 0F, 17, 2, 5, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, -1F, 0F, 0F, 0F); // Box 297
        body_colored_primary[135].setRotationPoint(59.5F, -18.5F, 17F);

        body_colored_primary[136].addShapeBox(0F, 0F, 0F, 15, 2, 1, 0F, 0F, 0F, 0F, 1F, 0F, 1F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 4F, 0F, 1F, 1F, 0F, 0F, 0F, 0F, 0F); // Box 298
        body_colored_primary[136].setRotationPoint(56.5F, -20.5F, 22F);

        body_colored_primary[137].addShapeBox(0F, 0F, 0F, 12, 2, 1, 0F, 0F, 0F, 0F, 1F, 0F, 1F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 4F, 0F, 1F, 1F, 0F, 0F, 0F, 0F, 0F); // Box 299
        body_colored_primary[137].setRotationPoint(56.5F, -22.5F, 22F);

        body_colored_primary[138].addShapeBox(0F, 0F, 0F, 9, 2, 5, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, -1F, 0F, 0F, 0F); // Box 300
        body_colored_primary[138].setRotationPoint(58.5F, -24.5F, 17F);

        body_colored_primary[139].addShapeBox(0F, 0F, 0F, 2, 2, 4, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 301
        body_colored_primary[139].setRotationPoint(77.5F, -16.5F, 16.5F);

        body_colored_primary[140].addShapeBox(0F, 0F, 0F, 2, 2, 4, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 302
        body_colored_primary[140].setRotationPoint(78.5F, -14.5F, 16.5F);

        body_colored_primary[141].addShapeBox(0F, 0F, 0F, 2, 2, 4, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 303
        body_colored_primary[141].setRotationPoint(79.5F, -12.5F, 16.5F);

        body_colored_primary[142].addShapeBox(0F, 0F, 0F, 2, 3, 4, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F); // Box 304
        body_colored_primary[142].setRotationPoint(80.5F, -10.5F, 16.5F);

        body_colored_primary[143].addShapeBox(0F, 0F, 0F, 14, 4, 1, 0F, 1F, 0F, 0F, 4F, 0F, 0F, 4F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F); // Box 305
        body_colored_primary[143].setRotationPoint(29.5F, -4.5F, 22F);

        body_colored_primary[144].addShapeBox(0F, 0F, 0F, 16, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 306
        body_colored_primary[144].setRotationPoint(29.5F, -0.5F, 22F);

        body_colored_primary[145].addShapeBox(0F, 0F, 0F, 18, 6, 1, 0F, 1F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F); // Box 307
        body_colored_primary[145].setRotationPoint(28.5F, -12.5F, 22F);

        body_colored_primary[146].addShapeBox(0F, 0F, 0F, 15, 2, 1, 0F, 1F, 0F, 0F, 4F, 0F, 0F, 4F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, 1F, 0F, 0F); // Box 308
        body_colored_primary[146].setRotationPoint(29.5F, -6.5F, 22F);

        body_colored_primary[147].addShapeBox(0F, 0F, 0F, 29, 3, 1, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 309
        body_colored_primary[147].setRotationPoint(27.5F, -15.5F, 22F);

        body_colored_primary[148].addShapeBox(0F, 0F, 0F, 2, 18, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F); // Box 310
        body_colored_primary[148].setRotationPoint(26.5F, -38.5F, 22F);

        body_colored_primary[149].addShapeBox(0F, 0F, 0F, 14, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F); // Box 311
        body_colored_primary[149].setRotationPoint(30.5F, -22.5F, 22F);

        body_colored_primary[150].addShapeBox(0F, 0F, 0F, 27, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 315
        body_colored_primary[150].setRotationPoint(29.5F, -18.5F, 22F);

        body_colored_primary[151].addShapeBox(0F, 0F, 0F, 17, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F); // Box 316
        body_colored_primary[151].setRotationPoint(29.5F, -20.5F, 22F);

        body_colored_primary[152].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F); // Box 317
        body_colored_primary[152].setRotationPoint(55.5F, -20.5F, 22F);

        body_colored_primary[153].addBox(0F, 0F, 0F, 29, 10, 1, 0F); // Box 323
        body_colored_primary[153].setRotationPoint(-43.5F, -15.5F, 22F);

        body_colored_primary[154].addBox(0F, 0F, 0F, 117, 2, 43, 0F); // Box 325
        body_colored_primary[154].setRotationPoint(-97.5F, -55.5F, -22F);

        body_colored_primary[155].addShapeBox(0F, 0F, 0F, 2, 2, 43, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 326
        body_colored_primary[155].setRotationPoint(-99.5F, -55.5F, -22F);

        body_colored_primary[156].addShapeBox(0F, 0F, 0F, 2, 1, 45, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 342
        body_colored_primary[156].setRotationPoint(79.5F, -7.5F, -23F);

        body_colored_primary[157].addShapeBox(0F, 0F, 0F, 4, 2, 36, 0F, 0F, 0F, -1F, -2F, 0F, -1F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, -1F, 2F, 0F, -1F, 2F, 0F, 0F, 0F, -2F, 0F); // Box 394
        body_colored_primary[157].setRotationPoint(63.5F, -24.5F, -19F);

        body_colored_primary[158].addShapeBox(0F, 0F, 0F, 2, 2, 35, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 395
        body_colored_primary[158].setRotationPoint(77.5F, -16.5F, -18F);

        body_colored_primary[159].addShapeBox(0F, 0F, 0F, 1, 3, 45, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 4F, 0F, 0F, 4F, 0F, 0F, -4F, 0F, 0F); // Box 397
        body_colored_primary[159].setRotationPoint(58.5F, -27.5F, -23F);

        body_colored_primary[160].addShapeBox(0F, 0F, 0F, 4, 8, 23, 0F, 0F, 0F, -2F, 0F, -1F, -2F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 417
        body_colored_primary[160].setRotationPoint(19.5F, -55.5F, -24F);

        body_colored_primary[161].addShapeBox(0F, 0F, 0F, 4, 7, 23, 0F, 0F, 0F, -2F, 0F, -2F, -2F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 419
        body_colored_primary[161].setRotationPoint(23.5F, -54.5F, -24F);

        body_colored_primary[162].addShapeBox(0F, 0F, 0F, 4, 5, 23, 0F, 0F, 0F, -2F, 0F, -2F, -2F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 421
        body_colored_primary[162].setRotationPoint(27.5F, -52.5F, -24F);

        body_colored_primary[163].addShapeBox(0F, 0F, 0F, 4, 3, 23, 0F, 0F, 0F, -2F, 0F, -2.8F, -2F, 0F, -2.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 423
        body_colored_primary[163].setRotationPoint(31.5F, -50.5F, -24F);

        body_colored_primary[164].addShapeBox(0F, 0F, 0F, 4, 8, 23, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 425
        body_colored_primary[164].setRotationPoint(19.5F, -55.5F, 0F);

        body_colored_primary[165].addShapeBox(0F, 0F, 0F, 4, 7, 23, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 426
        body_colored_primary[165].setRotationPoint(23.5F, -54.5F, 0F);

        body_colored_primary[166].addShapeBox(0F, 0F, 0F, 4, 5, 23, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 427
        body_colored_primary[166].setRotationPoint(27.5F, -52.5F, 0F);

        body_colored_primary[167].addShapeBox(0F, 0F, 0F, 4, 3, 23, 0F, 0F, 0F, 0F, 0F, -2.8F, 0F, 0F, -2.8F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 428
        body_colored_primary[167].setRotationPoint(31.5F, -50.5F, 0F);

        body_colored_primary[168].addShapeBox(0F, 0F, 0F, 4, 3, 22, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 430
        body_colored_primary[168].setRotationPoint(35.5F, -47.5F, -23F);

        body_colored_primary[169].addShapeBox(0F, 0F, 0F, 4, 7, 1, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 432
        body_colored_primary[169].setRotationPoint(35.5F, -47.5F, -24F);

        body_colored_primary[170].addShapeBox(0F, 0F, 0F, 4, 3, 22, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 433
        body_colored_primary[170].setRotationPoint(35.5F, -47.5F, 0F);

        body_colored_primary[171].addShapeBox(0F, 0F, 0F, 4, 7, 1, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 434
        body_colored_primary[171].setRotationPoint(23.5F, -54.5F, -1F);

        body_colored_primary[172].addShapeBox(0F, 0F, 0F, 4, 7, 1, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 435
        body_colored_primary[172].setRotationPoint(19.5F, -55.5F, -1F);

        body_colored_primary[173].addShapeBox(0F, 0F, 0F, 4, 7, 1, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 436
        body_colored_primary[173].setRotationPoint(27.5F, -52.5F, -1F);

        body_colored_primary[174].addShapeBox(0F, 0F, 0F, 4, 7, 1, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 437
        body_colored_primary[174].setRotationPoint(31.5F, -50.5F, -1F);

        body_colored_primary[175].addShapeBox(0F, 0F, 0F, 4, 7, 1, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 438
        body_colored_primary[175].setRotationPoint(35.5F, -47.5F, -1F);

        body_colored_primary[176].addShapeBox(0F, 0F, 0F, 117, 8, 1, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -2F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 439
        body_colored_primary[176].setRotationPoint(-97.5F, -55.5F, 22F);
        this.add("body_colored_primary", body_colored_primary);

        ModelRendererTurbo[] body_door_close = new ModelRendererTurbo[15];
        body_door_close[0] = new ModelRendererTurbo(this, 97, 73, texture, texture); // Box 125
        body_door_close[1] = new ModelRendererTurbo(this, 297, 81, texture, texture); // Box 126
        body_door_close[2] = new ModelRendererTurbo(this, 201, 105, texture, texture); // Box 321
        body_door_close[3] = new ModelRendererTurbo(this, 385, 121, texture, texture); // Box 322
        body_door_close[4] = new ModelRendererTurbo(this, 617, 137, texture, texture); // Box 446
        body_door_close[5] = new ModelRendererTurbo(this, 905, 137, texture, texture); // Box 447
        body_door_close[6] = new ModelRendererTurbo(this, 425, 145, texture, texture); // Box 448
        body_door_close[7] = new ModelRendererTurbo(this, 49, 153, texture, texture); // Box 449
        body_door_close[8] = new ModelRendererTurbo(this, 689, 153, texture, texture); // Box 451
        body_door_close[9] = new ModelRendererTurbo(this, 697, 153, texture, texture); // Box 453
        body_door_close[10] = new ModelRendererTurbo(this, 705, 153, texture, texture); // Box 454
        body_door_close[11] = new ModelRendererTurbo(this, 521, 89, texture, texture); // Box 455
        body_door_close[12] = new ModelRendererTurbo(this, 313, 17, texture, texture); // Box 456
        body_door_close[13] = new ModelRendererTurbo(this, 353, 17, texture, texture); // Box 457
        body_door_close[14] = new ModelRendererTurbo(this, 153, 113, texture, texture); // Box 458

        body_door_close[0].addShapeBox(0F, 0F, 0F, 1, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 125
        body_door_close[0].setRotationPoint(20.5F, -20F, -24.8F);

        body_door_close[1].addShapeBox(0F, 0F, 0F, 3, 5, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 126
        body_door_close[1].setRotationPoint(19.5F, -20.5F, -24.4F);

        body_door_close[2].addShapeBox(0F, 0F, 0F, 1, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 321
        body_door_close[2].setRotationPoint(20.5F, -20F, 22.8F);

        body_door_close[3].addShapeBox(0F, 0F, 0F, 3, 5, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 322
        body_door_close[3].setRotationPoint(19.5F, -20.5F, 22.4F);

        body_door_close[4].addShapeBox(0F, 0F, 0F, 1, 8, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F); // Box 446
        body_door_close[4].setRotationPoint(-102.5F, -47.5F, -1F);

        body_door_close[5].addShapeBox(0F, 0F, 0F, 1, 15, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F); // Box 447
        body_door_close[5].setRotationPoint(-103.5F, -39.5F, -1F);

        body_door_close[6].addShapeBox(0F, 0F, 0F, 1, 15, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F); // Box 448
        body_door_close[6].setRotationPoint(-103.5F, -39.5F, -23F);

        body_door_close[7].addShapeBox(0F, 0F, 0F, 1, 15, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F); // Box 449
        body_door_close[7].setRotationPoint(-103.5F, -39.5F, 21F);

        body_door_close[8].addBox(0F, 0F, 0F, 1, 15, 1, 0F); // Box 451
        body_door_close[8].setRotationPoint(-105.5F, -24.5F, -1F);

        body_door_close[9].addBox(0F, 0F, 0F, 1, 15, 1, 0F); // Box 453
        body_door_close[9].setRotationPoint(-105.5F, -24.5F, 21F);

        body_door_close[10].addBox(0F, 0F, 0F, 1, 15, 1, 0F); // Box 454
        body_door_close[10].setRotationPoint(-105.5F, -24.5F, -23F);

        body_door_close[11].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 455
        body_door_close[11].setRotationPoint(-106.5F, -22.5F, -6.2F);

        body_door_close[12].addShapeBox(0F, 0F, 0F, 1, 3, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 456
        body_door_close[12].setRotationPoint(-105.9F, -23F, -6.5F);

        body_door_close[13].addShapeBox(0F, 0F, 0F, 1, 3, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 457
        body_door_close[13].setRotationPoint(-105.9F, -23F, 0.5F);

        body_door_close[14].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 458
        body_door_close[14].setRotationPoint(-106.5F, -22.5F, 2.2F);
        this.add("body_door_close", body_door_close);

        ModelRendererTurbo[] body_door_close_colored_primary = new ModelRendererTurbo[35];
        body_door_close_colored_primary[0] = new ModelRendererTurbo(this, 137, 49, texture, texture); // Box 72
        body_door_close_colored_primary[1] = new ModelRendererTurbo(this, 865, 49, texture, texture); // Box 73
        body_door_close_colored_primary[2] = new ModelRendererTurbo(this, 321, 65, texture, texture); // Box 74
        body_door_close_colored_primary[3] = new ModelRendererTurbo(this, 401, 65, texture, texture); // Box 75
        body_door_close_colored_primary[4] = new ModelRendererTurbo(this, 673, 65, texture, texture); // Box 76
        body_door_close_colored_primary[5] = new ModelRendererTurbo(this, 929, 65, texture, texture); // Box 78
        body_door_close_colored_primary[6] = new ModelRendererTurbo(this, 217, 73, texture, texture); // Box 79
        body_door_close_colored_primary[7] = new ModelRendererTurbo(this, 961, 33, texture, texture); // Box 89
        body_door_close_colored_primary[8] = new ModelRendererTurbo(this, 249, 41, texture, texture); // Box 90
        body_door_close_colored_primary[9] = new ModelRendererTurbo(this, 393, 41, texture, texture); // Box 91
        body_door_close_colored_primary[10] = new ModelRendererTurbo(this, 537, 41, texture, texture); // Box 92
        body_door_close_colored_primary[11] = new ModelRendererTurbo(this, 369, 105, texture, texture); // Box 270
        body_door_close_colored_primary[12] = new ModelRendererTurbo(this, 601, 105, texture, texture); // Box 271
        body_door_close_colored_primary[13] = new ModelRendererTurbo(this, 617, 105, texture, texture); // Box 272
        body_door_close_colored_primary[14] = new ModelRendererTurbo(this, 217, 105, texture, texture); // Box 273
        body_door_close_colored_primary[15] = new ModelRendererTurbo(this, 697, 105, texture, texture); // Box 274
        body_door_close_colored_primary[16] = new ModelRendererTurbo(this, 921, 105, texture, texture); // Box 275
        body_door_close_colored_primary[17] = new ModelRendererTurbo(this, 697, 113, texture, texture); // Box 276
        body_door_close_colored_primary[18] = new ModelRendererTurbo(this, 921, 113, texture, texture); // Box 277
        body_door_close_colored_primary[19] = new ModelRendererTurbo(this, 65, 105, texture, texture); // Box 287
        body_door_close_colored_primary[20] = new ModelRendererTurbo(this, 73, 105, texture, texture); // Box 288
        body_door_close_colored_primary[21] = new ModelRendererTurbo(this, 81, 105, texture, texture); // Box 289
        body_door_close_colored_primary[22] = new ModelRendererTurbo(this, 89, 105, texture, texture); // Box 290
        body_door_close_colored_primary[23] = new ModelRendererTurbo(this, 385, 145, texture, texture); // Box 443
        body_door_close_colored_primary[24] = new ModelRendererTurbo(this, 217, 233, texture, texture); // Box 444
        body_door_close_colored_primary[25] = new ModelRendererTurbo(this, 305, 233, texture, texture); // Box 445
        body_door_close_colored_primary[26] = new ModelRendererTurbo(this, 1, 161, texture, texture); // Box 450
        body_door_close_colored_primary[27] = new ModelRendererTurbo(this, 801, 89, texture, texture); // Box 461
        body_door_close_colored_primary[28] = new ModelRendererTurbo(this, 193, 97, texture, texture); // Box 463
        body_door_close_colored_primary[29] = new ModelRendererTurbo(this, 737, 129, texture, texture); // Box 464
        body_door_close_colored_primary[30] = new ModelRendererTurbo(this, 913, 137, texture, texture); // Box 465
        body_door_close_colored_primary[31] = new ModelRendererTurbo(this, 985, 137, texture, texture); // Box 466
        body_door_close_colored_primary[32] = new ModelRendererTurbo(this, 49, 145, texture, texture); // Box 467
        body_door_close_colored_primary[33] = new ModelRendererTurbo(this, 929, 145, texture, texture); // Box 468
        body_door_close_colored_primary[34] = new ModelRendererTurbo(this, 713, 153, texture, texture); // Box 469

        body_door_close_colored_primary[0].addBox(0F, 0F, 0F, 4, 17, 1, 0F); // Box 72
        body_door_close_colored_primary[0].setRotationPoint(-13.5F, -39.5F, -24F);

        body_door_close_colored_primary[1].addShapeBox(0F, 0F, 0F, 4, 17, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 73
        body_door_close_colored_primary[1].setRotationPoint(20.5F, -39.5F, -24F);

        body_door_close_colored_primary[2].addBox(0F, 0F, 0F, 38, 8, 1, 0F); // Box 74
        body_door_close_colored_primary[2].setRotationPoint(-13.5F, -22.5F, -24F);

        body_door_close_colored_primary[3].addBox(0F, 0F, 0F, 30, 1, 1, 0F); // Box 75
        body_door_close_colored_primary[3].setRotationPoint(-9.5F, -23.5F, -24F);

        body_door_close_colored_primary[4].addBox(0F, 0F, 0F, 30, 1, 1, 0F); // Box 76
        body_door_close_colored_primary[4].setRotationPoint(-9.5F, -39.5F, -24F);

        body_door_close_colored_primary[5].addBox(0F, 0F, 0F, 38, 1, 1, 0F); // Box 78
        body_door_close_colored_primary[5].setRotationPoint(-13.5F, -14.5F, -24F);

        body_door_close_colored_primary[6].addBox(0F, 0F, 0F, 38, 8, 1, 0F); // Box 79
        body_door_close_colored_primary[6].setRotationPoint(-13.5F, -13.5F, -24F);

        body_door_close_colored_primary[7].addShapeBox(0F, 0F, 0F, 2, 2, 1, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 89
        body_door_close_colored_primary[7].setRotationPoint(-9.5F, -25.5F, -24F);

        body_door_close_colored_primary[8].addShapeBox(0F, 0F, 0F, 2, 2, 1, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 90
        body_door_close_colored_primary[8].setRotationPoint(18.5F, -25.5F, -24F);

        body_door_close_colored_primary[9].addShapeBox(0F, 0F, 0F, 2, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F); // Box 91
        body_door_close_colored_primary[9].setRotationPoint(18.5F, -38.5F, -24F);

        body_door_close_colored_primary[10].addShapeBox(0F, 0F, 0F, 2, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F); // Box 92
        body_door_close_colored_primary[10].setRotationPoint(-9.5F, -38.5F, -24F);

        body_door_close_colored_primary[11].addBox(0F, 0F, 0F, 4, 17, 1, 0F); // Box 270
        body_door_close_colored_primary[11].setRotationPoint(-13.5F, -39.5F, 22F);

        body_door_close_colored_primary[12].addShapeBox(0F, 0F, 0F, 4, 17, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 271
        body_door_close_colored_primary[12].setRotationPoint(20.5F, -39.5F, 22F);

        body_door_close_colored_primary[13].addBox(0F, 0F, 0F, 38, 8, 1, 0F); // Box 272
        body_door_close_colored_primary[13].setRotationPoint(-13.5F, -22.5F, 22F);

        body_door_close_colored_primary[14].addBox(0F, 0F, 0F, 30, 1, 1, 0F); // Box 273
        body_door_close_colored_primary[14].setRotationPoint(-9.5F, -23.5F, 22F);

        body_door_close_colored_primary[15].addBox(0F, 0F, 0F, 30, 1, 1, 0F); // Box 274
        body_door_close_colored_primary[15].setRotationPoint(-9.5F, -39.5F, 22F);

        body_door_close_colored_primary[16].addBox(0F, 0F, 0F, 38, 6, 1, 0F); // Box 275
        body_door_close_colored_primary[16].setRotationPoint(-13.5F, -5.5F, 22F);

        body_door_close_colored_primary[17].addBox(0F, 0F, 0F, 38, 1, 1, 0F); // Box 276
        body_door_close_colored_primary[17].setRotationPoint(-13.5F, -14.5F, 22F);

        body_door_close_colored_primary[18].addBox(0F, 0F, 0F, 38, 8, 1, 0F); // Box 277
        body_door_close_colored_primary[18].setRotationPoint(-13.5F, -13.5F, 22F);

        body_door_close_colored_primary[19].addShapeBox(0F, 0F, 0F, 2, 2, 1, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 287
        body_door_close_colored_primary[19].setRotationPoint(-9.5F, -25.5F, 22F);

        body_door_close_colored_primary[20].addShapeBox(0F, 0F, 0F, 2, 2, 1, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 288
        body_door_close_colored_primary[20].setRotationPoint(18.5F, -25.5F, 22F);

        body_door_close_colored_primary[21].addShapeBox(0F, 0F, 0F, 2, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F); // Box 289
        body_door_close_colored_primary[21].setRotationPoint(18.5F, -38.5F, 22F);

        body_door_close_colored_primary[22].addShapeBox(0F, 0F, 0F, 2, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F); // Box 290
        body_door_close_colored_primary[22].setRotationPoint(-9.5F, -38.5F, 22F);

        body_door_close_colored_primary[23].addBox(0F, 0F, 0F, 1, 15, 21, 0F); // Box 443
        body_door_close_colored_primary[23].setRotationPoint(-105.5F, -24.5F, -22F);

        body_door_close_colored_primary[24].addShapeBox(0F, 0F, 0F, 1, 8, 22, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F); // Box 444
        body_door_close_colored_primary[24].setRotationPoint(-102.5F, -47.5F, -23F);

        body_door_close_colored_primary[25].addShapeBox(0F, 0F, 0F, 1, 8, 22, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F); // Box 445
        body_door_close_colored_primary[25].setRotationPoint(-102.5F, -47.5F, 0F);

        body_door_close_colored_primary[26].addBox(0F, 0F, 0F, 1, 15, 21, 0F); // Box 450
        body_door_close_colored_primary[26].setRotationPoint(-105.5F, -24.5F, 0F);

        body_door_close_colored_primary[27].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F); // Box 461
        body_door_close_colored_primary[27].setRotationPoint(-103.5F, -39.5F, -22F);

        body_door_close_colored_primary[28].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 463
        body_door_close_colored_primary[28].setRotationPoint(-105.5F, -26.5F, -22F);

        body_door_close_colored_primary[29].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 464
        body_door_close_colored_primary[29].setRotationPoint(-105.5F, -26.5F, -3F);

        body_door_close_colored_primary[30].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 465
        body_door_close_colored_primary[30].setRotationPoint(-103.5F, -39.5F, -3F);

        body_door_close_colored_primary[31].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 466
        body_door_close_colored_primary[31].setRotationPoint(-105.5F, -26.5F, 19F);

        body_door_close_colored_primary[32].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 467
        body_door_close_colored_primary[32].setRotationPoint(-105.5F, -26.5F, 0F);

        body_door_close_colored_primary[33].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F); // Box 468
        body_door_close_colored_primary[33].setRotationPoint(-103.5F, -39.5F, 0F);

        body_door_close_colored_primary[34].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 469
        body_door_close_colored_primary[34].setRotationPoint(-103.5F, -39.5F, 19F);
        this.add("body_door_close_colored_primary", body_door_close_colored_primary);

        ModelRendererTurbo[] turret = new ModelRendererTurbo[1];
        turret[0] = new ModelRendererTurbo(this, 249, 177, texture, texture); // hood

        turret[0].addShapeBox(0F, 0F, 0F, 8, 6, 35, 0F, 0F, 0F, 0F, -8F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F, 0F, -5F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, -5F, 0F); // hood
        turret[0].setRotationPoint(69.5F, -22.5F, -18F);
        this.add("turret", turret);
    }

    @Override
    public void render(VehicleData data, Object obj, @Nullable Entity entity, int meta){
        render("body");
        render("body_door_close");
        data.getPrimaryColor().glColorApply();
        render("body_door_close_colored_primary");
        render("body_colored_primary");
        if(!data.doorsOpen()){ render("turret"); }
        RGB.glColorReset();
    }

}
