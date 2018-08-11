package net.fexcraft.mod.addons.fvp.models.part;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.part.PartModelTMT;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.minecraft.entity.Entity;

public class ModelC7I4E extends PartModelTMT {

    public ModelC7I4E(){
    	super(); textureX = 512; textureY = 512;
        this.addToCreators("zackyboy18");
        body = new ModelRendererTurbo[130];
        body[0] = new ModelRendererTurbo(this, 33, 169, textureX, textureY); // Box 294
        body[1] = new ModelRendererTurbo(this, 185, 169, textureX, textureY); // Box 295
        body[2] = new ModelRendererTurbo(this, 265, 169, textureX, textureY); // Box 296
        body[3] = new ModelRendererTurbo(this, 425, 169, textureX, textureY); // Box 297
        body[4] = new ModelRendererTurbo(this, 273, 145, textureX, textureY); // Box 298
        body[5] = new ModelRendererTurbo(this, 249, 73, textureX, textureY); // Box 299
        body[6] = new ModelRendererTurbo(this, 273, 89, textureX, textureY); // Box 300
        body[7] = new ModelRendererTurbo(this, 465, 89, textureX, textureY); // Box 301
        body[8] = new ModelRendererTurbo(this, 169, 97, textureX, textureY); // Box 302
        body[9] = new ModelRendererTurbo(this, 233, 137, textureX, textureY); // Box 303
        body[10] = new ModelRendererTurbo(this, 73, 129, textureX, textureY); // Box 304
        body[11] = new ModelRendererTurbo(this, 145, 129, textureX, textureY); // Box 305
        body[12] = new ModelRendererTurbo(this, 161, 129, textureX, textureY); // Box 306
        body[13] = new ModelRendererTurbo(this, 353, 129, textureX, textureY); // Box 307
        body[14] = new ModelRendererTurbo(this, 225, 97, textureX, textureY); // Box 308
        body[15] = new ModelRendererTurbo(this, 377, 129, textureX, textureY); // Box 309
        body[16] = new ModelRendererTurbo(this, 457, 129, textureX, textureY); // Box 310
        body[17] = new ModelRendererTurbo(this, 113, 73, textureX, textureY); // Box 311
        body[18] = new ModelRendererTurbo(this, 145, 73, textureX, textureY); // Box 312
        body[19] = new ModelRendererTurbo(this, 161, 73, textureX, textureY); // Box 313
        body[20] = new ModelRendererTurbo(this, 177, 73, textureX, textureY); // Box 314
        body[21] = new ModelRendererTurbo(this, 193, 97, textureX, textureY); // Box 315
        body[22] = new ModelRendererTurbo(this, 473, 153, textureX, textureY); // Box 316
        body[23] = new ModelRendererTurbo(this, 473, 129, textureX, textureY); // Box 317
        body[24] = new ModelRendererTurbo(this, 401, 137, textureX, textureY); // Box 318
        body[25] = new ModelRendererTurbo(this, 161, 145, textureX, textureY); // Box 319
        body[26] = new ModelRendererTurbo(this, 33, 137, textureX, textureY); // Box 320
        body[27] = new ModelRendererTurbo(this, 449, 145, textureX, textureY); // Box 321
        body[28] = new ModelRendererTurbo(this, 185, 161, textureX, textureY); // Box 322
        body[29] = new ModelRendererTurbo(this, 161, 105, textureX, textureY); // Box 323
        body[30] = new ModelRendererTurbo(this, 233, 121, textureX, textureY); // Box 324
        body[31] = new ModelRendererTurbo(this, 1, 137, textureX, textureY); // Box 325
        body[32] = new ModelRendererTurbo(this, 129, 137, textureX, textureY); // Box 326
        body[33] = new ModelRendererTurbo(this, 289, 81, textureX, textureY); // Box 327
        body[34] = new ModelRendererTurbo(this, 177, 137, textureX, textureY); // Box 328
        body[35] = new ModelRendererTurbo(this, 193, 137, textureX, textureY); // Box 329
        body[36] = new ModelRendererTurbo(this, 249, 137, textureX, textureY); // Box 330
        body[37] = new ModelRendererTurbo(this, 385, 137, textureX, textureY); // Box 331
        body[38] = new ModelRendererTurbo(this, 305, 81, textureX, textureY); // Box 333
        body[39] = new ModelRendererTurbo(this, 337, 81, textureX, textureY); // Box 334
        body[40] = new ModelRendererTurbo(this, 441, 81, textureX, textureY); // Box 335
        body[41] = new ModelRendererTurbo(this, 457, 81, textureX, textureY); // Box 336
        body[42] = new ModelRendererTurbo(this, 137, 97, textureX, textureY); // Box 337
        body[43] = new ModelRendererTurbo(this, 265, 137, textureX, textureY); // Box 338
        body[44] = new ModelRendererTurbo(this, 505, 97, textureX, textureY); // Box 340
        body[45] = new ModelRendererTurbo(this, 145, 145, textureX, textureY); // Box 341
        body[46] = new ModelRendererTurbo(this, 113, 153, textureX, textureY); // Box 342
        body[47] = new ModelRendererTurbo(this, 225, 121, textureX, textureY); // Box 343
        body[48] = new ModelRendererTurbo(this, 313, 137, textureX, textureY); // Box 344
        body[49] = new ModelRendererTurbo(this, 457, 153, textureX, textureY); // Box 345
        body[50] = new ModelRendererTurbo(this, 489, 153, textureX, textureY); // Box 346
        body[51] = new ModelRendererTurbo(this, 505, 137, textureX, textureY); // Box 347
        body[52] = new ModelRendererTurbo(this, 1, 161, textureX, textureY); // Box 348
        body[53] = new ModelRendererTurbo(this, 273, 161, textureX, textureY); // Box 349
        body[54] = new ModelRendererTurbo(this, 417, 161, textureX, textureY); // Box 350
        body[55] = new ModelRendererTurbo(this, 73, 169, textureX, textureY); // Box 351
        body[56] = new ModelRendererTurbo(this, 89, 169, textureX, textureY); // Box 352
        body[57] = new ModelRendererTurbo(this, 217, 169, textureX, textureY); // Box 353
        body[58] = new ModelRendererTurbo(this, 297, 169, textureX, textureY); // Box 354
        body[59] = new ModelRendererTurbo(this, 313, 169, textureX, textureY); // Box 355
        body[60] = new ModelRendererTurbo(this, 329, 169, textureX, textureY); // Box 356
        body[61] = new ModelRendererTurbo(this, 209, 145, textureX, textureY); // Box 357
        body[62] = new ModelRendererTurbo(this, 505, 145, textureX, textureY); // Box 358
        body[63] = new ModelRendererTurbo(this, 345, 169, textureX, textureY); // Box 359
        body[64] = new ModelRendererTurbo(this, 361, 169, textureX, textureY); // Box 360
        body[65] = new ModelRendererTurbo(this, 417, 169, textureX, textureY); // Box 361
        body[66] = new ModelRendererTurbo(this, 465, 169, textureX, textureY); // Box 362
        body[67] = new ModelRendererTurbo(this, 481, 169, textureX, textureY); // Box 363
        body[68] = new ModelRendererTurbo(this, 497, 169, textureX, textureY); // Box 364
        body[69] = new ModelRendererTurbo(this, 169, 153, textureX, textureY); // Box 365
        body[70] = new ModelRendererTurbo(this, 417, 153, textureX, textureY); // Box 367
        body[71] = new ModelRendererTurbo(this, 73, 177, textureX, textureY); // Box 378
        body[72] = new ModelRendererTurbo(this, 89, 177, textureX, textureY); // Box 379
        body[73] = new ModelRendererTurbo(this, 505, 153, textureX, textureY); // Box 380
        body[74] = new ModelRendererTurbo(this, 105, 177, textureX, textureY); // Box 381
        body[75] = new ModelRendererTurbo(this, 97, 161, textureX, textureY); // Box 382
        body[76] = new ModelRendererTurbo(this, 433, 169, textureX, textureY); // Box 383
        body[77] = new ModelRendererTurbo(this, 121, 177, textureX, textureY); // Box 384
        body[78] = new ModelRendererTurbo(this, 137, 177, textureX, textureY); // Box 385
        body[79] = new ModelRendererTurbo(this, 153, 177, textureX, textureY); // Box 389
        body[80] = new ModelRendererTurbo(this, 185, 177, textureX, textureY); // Box 390
        body[81] = new ModelRendererTurbo(this, 217, 177, textureX, textureY); // Box 391
        body[82] = new ModelRendererTurbo(this, 233, 177, textureX, textureY); // Box 392
        body[83] = new ModelRendererTurbo(this, 41, 153, textureX, textureY); // Box 393
        body[84] = new ModelRendererTurbo(this, 129, 153, textureX, textureY); // Box 394
        body[85] = new ModelRendererTurbo(this, 241, 145, textureX, textureY); // Box 395
        body[86] = new ModelRendererTurbo(this, 249, 177, textureX, textureY); // Box 396
        body[87] = new ModelRendererTurbo(this, 297, 169, textureX, textureY); // Box 397
        body[88] = new ModelRendererTurbo(this, 385, 153, textureX, textureY); // Box 398
        body[89] = new ModelRendererTurbo(this, 473, 153, textureX, textureY); // Box 399
        body[90] = new ModelRendererTurbo(this, 9, 161, textureX, textureY); // Box 400
        body[91] = new ModelRendererTurbo(this, 185, 161, textureX, textureY); // Box 401
        body[92] = new ModelRendererTurbo(this, 201, 161, textureX, textureY); // Box 402
        body[93] = new ModelRendererTurbo(this, 505, 161, textureX, textureY); // Box 403
        body[94] = new ModelRendererTurbo(this, 1, 169, textureX, textureY); // Box 404
        body[95] = new ModelRendererTurbo(this, 169, 177, textureX, textureY); // Box 405
        body[96] = new ModelRendererTurbo(this, 313, 177, textureX, textureY); // Box 407
        body[97] = new ModelRendererTurbo(this, 281, 161, textureX, textureY); // Box 408
        body[98] = new ModelRendererTurbo(this, 265, 177, textureX, textureY); // Box 409
        body[99] = new ModelRendererTurbo(this, 425, 161, textureX, textureY); // Box 410
        body[100] = new ModelRendererTurbo(this, 273, 177, textureX, textureY); // Box 411
        body[101] = new ModelRendererTurbo(this, 465, 177, textureX, textureY); // Box 413
        body[102] = new ModelRendererTurbo(this, 81, 169, textureX, textureY); // Box 415
        body[103] = new ModelRendererTurbo(this, 233, 169, textureX, textureY); // Box 416
        body[104] = new ModelRendererTurbo(this, 321, 169, textureX, textureY); // Box 104
        body[105] = new ModelRendererTurbo(this, 337, 177, textureX, textureY); // Box 105
        body[106] = new ModelRendererTurbo(this, 481, 177, textureX, textureY); // Box 106
        body[107] = new ModelRendererTurbo(this, 345, 169, textureX, textureY); // Box 107
        body[108] = new ModelRendererTurbo(this, 121, 177, textureX, textureY); // Box 108
        body[109] = new ModelRendererTurbo(this, 233, 177, textureX, textureY); // Box 109
        body[110] = new ModelRendererTurbo(this, 481, 177, textureX, textureY); // Box 110
        body[111] = new ModelRendererTurbo(this, 1, 185, textureX, textureY); // Box 111
        body[112] = new ModelRendererTurbo(this, 81, 185, textureX, textureY); // Box 112
        body[113] = new ModelRendererTurbo(this, 105, 185, textureX, textureY); // Box 113
        body[114] = new ModelRendererTurbo(this, 25, 193, textureX, textureY); // Box 114
        body[115] = new ModelRendererTurbo(this, 145, 185, textureX, textureY); // Box 115
        body[116] = new ModelRendererTurbo(this, 41, 193, textureX, textureY); // Box 116
        body[117] = new ModelRendererTurbo(this, 97, 185, textureX, textureY); // Box 117
        body[118] = new ModelRendererTurbo(this, 129, 193, textureX, textureY); // Box 118
        body[119] = new ModelRendererTurbo(this, 153, 193, textureX, textureY); // Box 119
        body[120] = new ModelRendererTurbo(this, 497, 177, textureX, textureY); // Box 120
        body[121] = new ModelRendererTurbo(this, 177, 193, textureX, textureY); // Box 121
        body[122] = new ModelRendererTurbo(this, 201, 193, textureX, textureY); // Box 122
        body[123] = new ModelRendererTurbo(this, 1, 185, textureX, textureY); // Box 123
        body[124] = new ModelRendererTurbo(this, 17, 185, textureX, textureY); // Box 124
        body[125] = new ModelRendererTurbo(this, 217, 193, textureX, textureY); // Box 125
        body[126] = new ModelRendererTurbo(this, 337, 169, textureX, textureY); // Box 126
        body[127] = new ModelRendererTurbo(this, 425, 169, textureX, textureY); // Box 127
        body[128] = new ModelRendererTurbo(this, 473, 169, textureX, textureY); // Box 128
        body[129] = new ModelRendererTurbo(this, 297, 177, textureX, textureY); // Box 129

        body[0].addShapeBox(0F, 0F, 0F, 10, 3, 17, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 294
        body[0].setRotationPoint(29F, -9F, -9F);

        body[1].addShapeBox(0F, 0F, 0F, 6, 3, 17, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 295
        body[1].setRotationPoint(31F, -12F, -9F);

        body[2].addShapeBox(0F, 0F, 0F, 6, 2, 17, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 296
        body[2].setRotationPoint(31F, -14F, -9F);

        body[3].addShapeBox(0F, 0F, 0F, 10, 3, 17, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 297
        body[3].setRotationPoint(29F, -6F, -9F);

        body[4].addShapeBox(0F, 0F, 0F, 8, 1, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 298
        body[4].setRotationPoint(30F, -3F, 2F);

        body[5].addShapeBox(0F, 0F, 0F, 2, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 299
        body[5].setRotationPoint(36F, -10F, -7F);
        body[5].rotateAngleZ = 0.73303829F;

        body[6].addShapeBox(0F, 0F, 0F, 2, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 300
        body[6].setRotationPoint(36F, -10F, 5F);
        body[6].rotateAngleZ = 0.73303829F;

        body[7].addShapeBox(0F, 0F, 0F, 2, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 301
        body[7].setRotationPoint(36F, -10F, 1F);
        body[7].rotateAngleZ = 0.73303829F;

        body[8].addShapeBox(0F, 0F, 0F, 2, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 302
        body[8].setRotationPoint(36F, -10F, -3F);
        body[8].rotateAngleZ = 0.73303829F;

        body[9].addShapeBox(0F, 0F, 0F, 4, 1, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 303
        body[9].setRotationPoint(38F, -7F, -4F);

        body[10].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F); // Box 304
        body[10].setRotationPoint(42F, -7F, -4F);

        body[11].addShapeBox(0F, 0F, 0F, 1, 3, 3, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F); // Box 305
        body[11].setRotationPoint(42F, -6F, -4F);

        body[12].addShapeBox(0F, 0F, 0F, 1, 3, 3, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F); // Box 306
        body[12].setRotationPoint(40F, -6F, -4F);

        body[13].addShapeBox(0F, 0F, 0F, 1, 3, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 307
        body[13].setRotationPoint(41F, -6F, -4F);

        body[14].addShapeBox(0F, 0F, 0F, 4, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 308
        body[14].setRotationPoint(37F, -6F, 0F);
        body[14].rotateAngleZ = 0.87266463F;

        body[15].addShapeBox(5F, -1F, -1F, 1, 3, 3, 0F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F); // Box 309
        body[15].setRotationPoint(36F, -5F, 0F);
        body[15].rotateAngleZ = 0.87266463F;

        body[16].addShapeBox(6F, -1F, -1F, 1, 3, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 310
        body[16].setRotationPoint(36F, -5F, 0F);
        body[16].rotateAngleZ = 0.87266463F;

        body[17].addShapeBox(8F, -1F, -1F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 311
        body[17].setRotationPoint(35F, -4F, 0F);
        body[17].rotateAngleZ = 0.87266463F;

        body[18].addShapeBox(8F, 1F, -1F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 312
        body[18].setRotationPoint(35F, -4F, 0F);
        body[18].rotateAngleZ = 0.87266463F;

        body[19].addShapeBox(8F, 1F, 1F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 313
        body[19].setRotationPoint(35F, -4F, 0F);
        body[19].rotateAngleZ = 0.87266463F;

        body[20].addShapeBox(8F, -1F, 1F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 314
        body[20].setRotationPoint(35F, -4F, 0F);
        body[20].rotateAngleZ = 0.87266463F;

        body[21].addShapeBox(8F, 0F, 0F, 2, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 315
        body[21].setRotationPoint(35F, -4F, 0F);
        body[21].rotateAngleZ = 0.87266463F;

        body[22].addShapeBox(0F, 0F, 0F, 4, 4, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 316
        body[22].setRotationPoint(25F, -9F, 5.5F);

        body[23].addShapeBox(0F, 0F, 0F, 4, 4, 0, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F); // Box 317
        body[23].setRotationPoint(28F, -13F, 9.5F);

        body[24].addShapeBox(0F, 0F, 0F, 4, 5, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, -1F, 0F, -3F, -1F, 0F, 0F, 0F, 0F); // Box 318
        body[24].setRotationPoint(38F, -8F, 7F);

        body[25].addShapeBox(0F, 0F, 0F, 4, 2, 3, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 319
        body[25].setRotationPoint(38F, -10F, 7F);

        body[26].addShapeBox(0F, 0F, 0F, 4, 4, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F); // Box 320
        body[26].setRotationPoint(34F, -6F, 8F);

        body[27].addShapeBox(0F, 0F, 0F, 4, 4, 2, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 321
        body[27].setRotationPoint(34F, -10F, 8F);

        body[28].addShapeBox(0F, 0F, 0F, 2, 3, 6, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 322
        body[28].setRotationPoint(37F, -9F, 2F);

        body[29].addShapeBox(0F, 0F, 0F, 2, 3, 1, 0F, 0F, -1F, 0F, -2F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -2F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 323
        body[29].setRotationPoint(37F, -9F, 4F);

        body[30].addShapeBox(0F, 0F, 0F, 1, 5, 2, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 324
        body[30].setRotationPoint(31F, -8F, 8F);

        body[31].addShapeBox(0F, 0F, 0F, 2, 7, 2, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 325
        body[31].setRotationPoint(32F, -9F, 8F);

        body[32].addShapeBox(0F, 0F, 0F, 1, 5, 1, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 326
        body[32].setRotationPoint(32F, -8F, 10F);

        body[33].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 327
        body[33].setRotationPoint(31F, -11F, 8F);

        body[34].addShapeBox(0F, 0F, 0F, 2, 3, 1, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 328
        body[34].setRotationPoint(34F, -12F, 8F);

        body[35].addShapeBox(0F, 0F, 0F, 2, 4, 1, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 329
        body[35].setRotationPoint(32F, -12F, 8F);

        body[36].addShapeBox(0F, 0F, 0F, 1, 5, 1, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 330
        body[36].setRotationPoint(36F, -8F, 10F);

        body[37].addShapeBox(0F, 0F, 0F, 3, 5, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 331
        body[37].setRotationPoint(33F, -8F, 10F);

        body[38].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 333
        body[38].setRotationPoint(32.5F, -11.5F, 10F);

        body[39].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 334
        body[39].setRotationPoint(33.5F, -11.5F, 10F);

        body[40].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 335
        body[40].setRotationPoint(31.5F, -11.5F, 10F);

        body[41].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 336
        body[41].setRotationPoint(27.5F, -8.5F, 10F);

        body[42].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 337
        body[42].setRotationPoint(26.5F, -8.5F, 10F);

        body[43].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 338
        body[43].setRotationPoint(25.5F, -8.5F, 10F);

        body[44].addShapeBox(0F, 0F, 0F, 2, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 340
        body[44].setRotationPoint(29F, -10.5F, -8F);

        body[45].addShapeBox(0F, 0F, 0F, 2, 2, 2, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 341
        body[45].setRotationPoint(29F, -10F, -6F);

        body[46].addShapeBox(0F, 0F, 0F, 2, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F); // Box 342
        body[46].setRotationPoint(29F, -10F, -3F);

        body[47].addShapeBox(0F, 0F, 0F, 2, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 343
        body[47].setRotationPoint(29F, -10.5F, -0.5F);

        body[48].addShapeBox(0F, 0F, 0F, 2, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 344
        body[48].setRotationPoint(29F, -10.5F, 0.6F);

        body[49].addShapeBox(0F, 0F, 0F, 2, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F); // Box 345
        body[49].setRotationPoint(29F, -10F, 5F);

        body[50].addShapeBox(0F, 0F, 0F, 2, 2, 2, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 346
        body[50].setRotationPoint(29F, -10F, 2F);

        body[51].addShapeBox(0F, 0F, 0F, 2, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 347
        body[51].setRotationPoint(29F, -11.5F, 8F);

        body[52].addShapeBox(0F, 0F, 0F, 2, 2, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 348
        body[52].setRotationPoint(27F, -10F, 3F);

        body[53].addShapeBox(0F, 0F, 0F, 2, 2, 3, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 349
        body[53].setRotationPoint(27F, -12F, 3F);

        body[54].addShapeBox(0F, 0F, 0F, 2, 2, 3, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 350
        body[54].setRotationPoint(27F, -12F, -5F);

        body[55].addShapeBox(0F, 0F, 0F, 2, 2, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 351
        body[55].setRotationPoint(27F, -10F, -5F);

        body[56].addShapeBox(0F, 0F, 0F, 6, 2, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 352
        body[56].setRotationPoint(21F, -12F, -5F);

        body[57].addShapeBox(0F, 0F, 0F, 6, 2, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 353
        body[57].setRotationPoint(21F, -12F, 3F);

        body[58].addShapeBox(0F, 0F, 0F, 1, 4, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 354
        body[58].setRotationPoint(23F, -13F, -5F);

        body[59].addShapeBox(0F, 0F, 0F, 1, 4, 3, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F); // Box 355
        body[59].setRotationPoint(24F, -13F, -5F);

        body[60].addShapeBox(0F, 0F, 0F, 1, 4, 3, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F); // Box 356
        body[60].setRotationPoint(22F, -13F, -5F);

        body[61].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 357
        body[61].setRotationPoint(23F, -14F, -4F);

        body[62].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 358
        body[62].setRotationPoint(23F, -14F, 4F);

        body[63].addShapeBox(0F, 0F, 0F, 1, 4, 3, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F); // Box 359
        body[63].setRotationPoint(22F, -13F, 3F);

        body[64].addShapeBox(0F, 0F, 0F, 1, 4, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 360
        body[64].setRotationPoint(23F, -13F, 3F);

        body[65].addShapeBox(0F, 0F, 0F, 1, 4, 3, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F); // Box 361
        body[65].setRotationPoint(24F, -13F, 3F);

        body[66].addShapeBox(0F, 0F, 0F, 2, 3, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 362
        body[66].setRotationPoint(19F, -12.5F, 3F);

        body[67].addShapeBox(0F, 0F, 0F, 2, 1, 3, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 363
        body[67].setRotationPoint(19F, -13.5F, 3F);

        body[68].addShapeBox(0F, 0F, 0F, 2, 1, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 364
        body[68].setRotationPoint(19F, -9.5F, 3F);

        body[69].addShapeBox(0F, 0F, 0F, 2, 3, 1, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 365
        body[69].setRotationPoint(19F, -12.5F, 2F);

        body[70].addShapeBox(0F, 0F, 0F, 2, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 367
        body[70].setRotationPoint(19F, -12.5F, 6F);

        body[71].addShapeBox(0F, 0F, 0F, 2, 3, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 378
        body[71].setRotationPoint(19F, -12.5F, -5F);

        body[72].addShapeBox(0F, 0F, 0F, 2, 1, 3, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 379
        body[72].setRotationPoint(19F, -13.5F, -5F);

        body[73].addShapeBox(0F, 0F, 0F, 2, 3, 1, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 380
        body[73].setRotationPoint(19F, -12.5F, -6F);

        body[74].addShapeBox(0F, 0F, 0F, 2, 1, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 381
        body[74].setRotationPoint(19F, -9.5F, -5F);

        body[75].addShapeBox(0F, 0F, 0F, 2, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 382
        body[75].setRotationPoint(19F, -12.5F, -2F);

        body[76].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 383
        body[76].setRotationPoint(23F, -9F, -5F);

        body[77].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, -1F); // Box 384
        body[77].setRotationPoint(24F, -9F, -5F);

        body[78].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -1F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -1F, -1F); // Box 385
        body[78].setRotationPoint(22F, -9F, -5F);

        body[79].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 389
        body[79].setRotationPoint(23F, -9F, 3F);

        body[80].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -1F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -1F, -1F); // Box 390
        body[80].setRotationPoint(22F, -9F, 3F);

        body[81].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, -1F); // Box 391
        body[81].setRotationPoint(24F, -9F, 3F);

        body[82].addShapeBox(0F, 0F, 0F, 2, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 392
        body[82].setRotationPoint(24F, -12F, 5F);
        body[82].rotateAngleZ = 0.4712389F;

        body[83].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 393
        body[83].setRotationPoint(25F, -13F, 5F);

        body[84].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 394
        body[84].setRotationPoint(25F, -14F, -3F);

        body[85].addShapeBox(0F, 0F, 0F, 1, 2, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 395
        body[85].setRotationPoint(25F, -13F, -2F);

        body[86].addShapeBox(0F, 0F, 0F, 1, 2, 3, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 396
        body[86].setRotationPoint(25F, -13F, 2F);

        body[87].addShapeBox(0F, 0F, 0F, 1, 1, 12, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 397
        body[87].setRotationPoint(27.5F, -11.5F, -5.5F);

        body[88].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 398
        body[88].setRotationPoint(28F, -10.5F, -8F);

        body[89].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 399
        body[89].setRotationPoint(28F, -10.5F, -0.5F);

        body[90].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 400
        body[90].setRotationPoint(28F, -11.5F, 8F);

        body[91].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 401
        body[91].setRotationPoint(28F, -10.5F, 0.599999999999994F);

        body[92].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 402
        body[92].setRotationPoint(28F, -9.5F, 0.599999999999994F);

        body[93].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 403
        body[93].setRotationPoint(28F, -9.5F, -0.5F);

        body[94].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 404
        body[94].setRotationPoint(28F, -9.5F, -8F);

        body[95].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 405
        body[95].setRotationPoint(28F, -10.5F, 9F);

        body[96].addShapeBox(0F, 0F, 0F, 1, 1, 16, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 407
        body[96].setRotationPoint(28F, -7.5F, -7F);

        body[97].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 408
        body[97].setRotationPoint(28F, -7.5F, -8F);

        body[98].addShapeBox(0F, 0F, 0F, 1, 1, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F); // Box 409
        body[98].setRotationPoint(28F, -8.5F, 9F);

        body[99].addShapeBox(0F, 0F, 0F, 2, 1, 1, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F); // Box 410
        body[99].setRotationPoint(27F, -6.5F, -6F);

        body[100].addShapeBox(0F, 0F, 0F, 2, 2, 1, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F); // Box 411
        body[100].setRotationPoint(26F, -5.5F, -6F);

        body[101].addShapeBox(0F, 0F, 0F, 3, 1, 3, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 413
        body[101].setRotationPoint(32.5F, -14.5F, 4F);

        body[102].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 415
        body[102].setRotationPoint(33.5F, -14.5F, 3.5F);

        body[103].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 416
        body[103].setRotationPoint(33.5F, -14.5F, 6.5F);

        body[104].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 104
        body[104].setRotationPoint(38F, -7F, -7F);

        body[105].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 105
        body[105].setRotationPoint(39F, -8.5F, -7.5F);

        body[106].addShapeBox(0F, 0F, 0F, 2, 2, 2, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F); // Box 106
        body[106].setRotationPoint(28F, -5F, 8.5F);

        body[107].addShapeBox(0F, 0F, 0F, 1, 1, 10, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 107
        body[107].setRotationPoint(32F, -14.2F, -8F);

        body[108].addShapeBox(0F, 0F, 0F, 1, 1, 10, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 108
        body[108].setRotationPoint(33F, -14.2F, -8F);

        body[109].addShapeBox(0F, 0F, 0F, 1, 1, 10, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 109
        body[109].setRotationPoint(34F, -14.2F, -8F);

        body[110].addShapeBox(0F, 0F, 0F, 1, 1, 10, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 110
        body[110].setRotationPoint(35F, -14.2F, -8F);

        body[111].addShapeBox(0F, 0F, 0F, 1, 1, 10, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 111
        body[111].setRotationPoint(34.5F, -14.2F, -8F);

        body[112].addShapeBox(0F, 0F, 0F, 1, 1, 10, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 112
        body[112].setRotationPoint(33.5F, -14.2F, -8F);

        body[113].addShapeBox(0F, 0F, 0F, 1, 1, 10, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 113
        body[113].setRotationPoint(32.5F, -14.2F, -8F);

        body[114].addShapeBox(0F, 0F, 0F, 10, 4, 1, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 114
        body[114].setRotationPoint(29F, -9F, -10F);

        body[115].addShapeBox(0F, 0F, 0F, 10, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F); // Box 115
        body[115].setRotationPoint(29F, -5F, -10F);

        body[116].addShapeBox(0F, 0F, 0F, 8, 1, 10, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F); // Box 116
        body[116].setRotationPoint(30F, -3F, -9F);

        body[117].addShapeBox(0F, 0F, 0F, 7, 2, 1, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 117
        body[117].setRotationPoint(30.5F, -8F, -12F);

        body[118].addShapeBox(0F, 0F, 0F, 7, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F); // Box 118
        body[118].setRotationPoint(30.5F, -3F, -11F);

        body[119].addShapeBox(0F, 0F, 0F, 7, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 119
        body[119].setRotationPoint(30.5F, -6F, -11F);

        body[120].addShapeBox(0F, 0F, 0F, 3, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 120
        body[120].setRotationPoint(32.5F, -6F, -12F);

        body[121].addShapeBox(0F, 0F, 0F, 7, 2, 1, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, -1F, -2F, 0F, -1F, -2F, 0F, 0F, -2F, 0F, 0F); // Box 121
        body[121].setRotationPoint(30.5F, -3F, -12F);

        body[122].addShapeBox(0F, 0F, 0F, 7, 2, 1, 0F, -2F, 0F, -1F, -2F, 0F, -1F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 122
        body[122].setRotationPoint(30.5F, -8F, -12F);

        body[123].addShapeBox(0F, 0F, 0F, 2, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 123
        body[123].setRotationPoint(35.5F, -6F, -12F);

        body[124].addShapeBox(0F, 0F, 0F, 2, 3, 1, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 124
        body[124].setRotationPoint(30.5F, -6F, -12F);

        body[125].addShapeBox(0F, 0F, 0F, 12, 1, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 125
        body[125].setRotationPoint(20F, -3F, -2F);

        body[126].addShapeBox(0F, 0F, 0F, 3, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 126
        body[126].setRotationPoint(20.5F, -2.5F, 3F);

        body[127].addShapeBox(0F, 0F, 0F, 3, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 127
        body[127].setRotationPoint(20.5F, -2.5F, -3F);

        body[128].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 128
        body[128].setRotationPoint(26F, -3.5F, -6F);

        body[129].addShapeBox(0F, 0F, 0F, 1, 1, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 129
        body[129].setRotationPoint(26F, -2.5F, -6.5F);

        this.fixRotations(body);

    }

    @Override
    public void render(VehicleData data, String us){
        render(body);
    }

    @Override
    public void render(VehicleData data, String us, Entity vehicle, int meta){
        render(body);
    }

}
