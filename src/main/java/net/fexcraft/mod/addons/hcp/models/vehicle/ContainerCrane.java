package net.fexcraft.mod.addons.hcp.models.vehicle;

import java.util.TreeMap;

import javax.annotation.Nullable;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.addons.hcp.scripts.ContainerCraneScript;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.vehicle.VehicleModel;
import org.lwjgl.opengl.GL11;

/**
 *
 * @author Ferdinand (FEX___96)
 */
public class ContainerCrane extends VehicleModel {

    private final void initChassis(){
    	ModelRendererTurbo[] chassis = new ModelRendererTurbo[502];
        chassis[0] = new ModelRendererTurbo(this, 241, 25, textureX, textureY); // Box 202
        chassis[1] = new ModelRendererTurbo(this, 153, 17, textureX, textureY); // Box 203
        chassis[2] = new ModelRendererTurbo(this, 217, 17, textureX, textureY); // Box 204
        chassis[3] = new ModelRendererTurbo(this, 329, 25, textureX, textureY); // Box 205
        chassis[4] = new ModelRendererTurbo(this, 345, 25, textureX, textureY); // Box 206
        chassis[5] = new ModelRendererTurbo(this, 433, 25, textureX, textureY); // Box 207
        chassis[6] = new ModelRendererTurbo(this, 449, 25, textureX, textureY); // Box 208
        chassis[7] = new ModelRendererTurbo(this, 569, 25, textureX, textureY); // Box 209
        chassis[8] = new ModelRendererTurbo(this, 833, 25, textureX, textureY); // Box 218
        chassis[9] = new ModelRendererTurbo(this, 153, 25, textureX, textureY); // Box 219
        chassis[10] = new ModelRendererTurbo(this, 217, 25, textureX, textureY); // Box 220
        chassis[11] = new ModelRendererTurbo(this, 889, 25, textureX, textureY); // Box 221
        chassis[12] = new ModelRendererTurbo(this, 905, 25, textureX, textureY); // Box 222
        chassis[13] = new ModelRendererTurbo(this, 921, 25, textureX, textureY); // Box 223
        chassis[14] = new ModelRendererTurbo(this, 937, 25, textureX, textureY); // Box 224
        chassis[15] = new ModelRendererTurbo(this, 993, 25, textureX, textureY); // Box 225
        chassis[16] = new ModelRendererTurbo(this, 1009, 25, textureX, textureY); // Box 250
        chassis[17] = new ModelRendererTurbo(this, 1, 33, textureX, textureY); // Box 251
        chassis[18] = new ModelRendererTurbo(this, 17, 33, textureX, textureY); // Box 252
        chassis[19] = new ModelRendererTurbo(this, 33, 33, textureX, textureY); // Box 253
        chassis[20] = new ModelRendererTurbo(this, 65, 33, textureX, textureY); // Box 254
        chassis[21] = new ModelRendererTurbo(this, 81, 33, textureX, textureY); // Box 255
        chassis[22] = new ModelRendererTurbo(this, 97, 33, textureX, textureY); // Box 256
        chassis[23] = new ModelRendererTurbo(this, 113, 33, textureX, textureY); // Box 257
        chassis[24] = new ModelRendererTurbo(this, 129, 33, textureX, textureY); // Box 258
        chassis[25] = new ModelRendererTurbo(this, 145, 33, textureX, textureY); // Box 259
        chassis[26] = new ModelRendererTurbo(this, 177, 33, textureX, textureY); // Box 260
        chassis[27] = new ModelRendererTurbo(this, 193, 33, textureX, textureY); // Box 261
        chassis[28] = new ModelRendererTurbo(this, 209, 33, textureX, textureY); // Box 262
        chassis[29] = new ModelRendererTurbo(this, 553, 33, textureX, textureY); // Box 263
        chassis[30] = new ModelRendererTurbo(this, 569, 33, textureX, textureY); // Box 264
        chassis[31] = new ModelRendererTurbo(this, 705, 33, textureX, textureY); // Box 265
        chassis[32] = new ModelRendererTurbo(this, 721, 33, textureX, textureY); // Box 267
        chassis[33] = new ModelRendererTurbo(this, 753, 33, textureX, textureY); // Box 268
        chassis[34] = new ModelRendererTurbo(this, 817, 33, textureX, textureY); // Box 269
        chassis[35] = new ModelRendererTurbo(this, 833, 33, textureX, textureY); // Box 270
        chassis[36] = new ModelRendererTurbo(this, 849, 33, textureX, textureY); // Box 271
        chassis[37] = new ModelRendererTurbo(this, 865, 33, textureX, textureY); // Box 272
        chassis[38] = new ModelRendererTurbo(this, 881, 33, textureX, textureY); // Box 273
        chassis[39] = new ModelRendererTurbo(this, 897, 33, textureX, textureY); // Box 274
        chassis[40] = new ModelRendererTurbo(this, 913, 33, textureX, textureY); // Box 275
        chassis[41] = new ModelRendererTurbo(this, 929, 33, textureX, textureY); // Box 276
        chassis[42] = new ModelRendererTurbo(this, 945, 33, textureX, textureY); // Box 277
        chassis[43] = new ModelRendererTurbo(this, 1009, 33, textureX, textureY); // Box 278
        chassis[44] = new ModelRendererTurbo(this, 1, 41, textureX, textureY); // Box 279
        chassis[45] = new ModelRendererTurbo(this, 17, 41, textureX, textureY); // Box 280
        chassis[46] = new ModelRendererTurbo(this, 33, 41, textureX, textureY); // Box 281
        chassis[47] = new ModelRendererTurbo(this, 65, 41, textureX, textureY); // Box 282
        chassis[48] = new ModelRendererTurbo(this, 81, 41, textureX, textureY); // Box 283
        chassis[49] = new ModelRendererTurbo(this, 97, 41, textureX, textureY); // Box 284
        chassis[50] = new ModelRendererTurbo(this, 113, 41, textureX, textureY); // Box 285
        chassis[51] = new ModelRendererTurbo(this, 129, 41, textureX, textureY); // Box 286
        chassis[52] = new ModelRendererTurbo(this, 145, 41, textureX, textureY); // Box 287
        chassis[53] = new ModelRendererTurbo(this, 177, 41, textureX, textureY); // Box 288
        chassis[54] = new ModelRendererTurbo(this, 193, 41, textureX, textureY); // Box 289
        chassis[55] = new ModelRendererTurbo(this, 209, 41, textureX, textureY); // Box 290
        chassis[56] = new ModelRendererTurbo(this, 241, 41, textureX, textureY); // Box 291
        chassis[57] = new ModelRendererTurbo(this, 257, 41, textureX, textureY); // Box 292
        chassis[58] = new ModelRendererTurbo(this, 273, 41, textureX, textureY); // Box 293
        chassis[59] = new ModelRendererTurbo(this, 289, 41, textureX, textureY); // Box 294
        chassis[60] = new ModelRendererTurbo(this, 305, 41, textureX, textureY); // Box 295
        chassis[61] = new ModelRendererTurbo(this, 321, 41, textureX, textureY); // Box 296
        chassis[62] = new ModelRendererTurbo(this, 337, 41, textureX, textureY); // Box 297
        chassis[63] = new ModelRendererTurbo(this, 353, 41, textureX, textureY); // Box 298
        chassis[64] = new ModelRendererTurbo(this, 849, 25, textureX, textureY); // Box 299
        chassis[65] = new ModelRendererTurbo(this, 769, 33, textureX, textureY); // Box 300
        chassis[66] = new ModelRendererTurbo(this, 801, 33, textureX, textureY); // Box 301
        chassis[67] = new ModelRendererTurbo(this, 369, 41, textureX, textureY); // Box 302
        chassis[68] = new ModelRendererTurbo(this, 385, 41, textureX, textureY); // Box 303
        chassis[69] = new ModelRendererTurbo(this, 401, 41, textureX, textureY); // Box 304
        chassis[70] = new ModelRendererTurbo(this, 417, 41, textureX, textureY); // Box 305
        chassis[71] = new ModelRendererTurbo(this, 433, 41, textureX, textureY); // Box 306
        chassis[72] = new ModelRendererTurbo(this, 449, 41, textureX, textureY); // Box 307
        chassis[73] = new ModelRendererTurbo(this, 465, 41, textureX, textureY); // Box 308
        chassis[74] = new ModelRendererTurbo(this, 481, 41, textureX, textureY); // Box 309
        chassis[75] = new ModelRendererTurbo(this, 497, 41, textureX, textureY); // Box 310
        chassis[76] = new ModelRendererTurbo(this, 513, 41, textureX, textureY); // Box 311
        chassis[77] = new ModelRendererTurbo(this, 529, 41, textureX, textureY); // Box 312
        chassis[78] = new ModelRendererTurbo(this, 545, 41, textureX, textureY); // Box 313
        chassis[79] = new ModelRendererTurbo(this, 561, 41, textureX, textureY); // Box 314
        chassis[80] = new ModelRendererTurbo(this, 601, 41, textureX, textureY); // Box 319
        chassis[81] = new ModelRendererTurbo(this, 617, 41, textureX, textureY); // Box 320
        chassis[82] = new ModelRendererTurbo(this, 633, 41, textureX, textureY); // Box 321
        chassis[83] = new ModelRendererTurbo(this, 649, 41, textureX, textureY); // Box 322
        chassis[84] = new ModelRendererTurbo(this, 665, 41, textureX, textureY); // Box 323
        chassis[85] = new ModelRendererTurbo(this, 681, 41, textureX, textureY); // Box 324
        chassis[86] = new ModelRendererTurbo(this, 697, 41, textureX, textureY); // Box 325
        chassis[87] = new ModelRendererTurbo(this, 713, 41, textureX, textureY); // Box 326
        chassis[88] = new ModelRendererTurbo(this, 769, 41, textureX, textureY); // Box 327
        chassis[89] = new ModelRendererTurbo(this, 577, 41, textureX, textureY); // Box 328
        chassis[90] = new ModelRendererTurbo(this, 785, 41, textureX, textureY); // Box 329
        chassis[91] = new ModelRendererTurbo(this, 801, 41, textureX, textureY); // Box 330
        chassis[92] = new ModelRendererTurbo(this, 817, 41, textureX, textureY); // Box 331
        chassis[93] = new ModelRendererTurbo(this, 833, 41, textureX, textureY); // Box 332
        chassis[94] = new ModelRendererTurbo(this, 849, 41, textureX, textureY); // Box 333
        chassis[95] = new ModelRendererTurbo(this, 865, 41, textureX, textureY); // Box 334
        chassis[96] = new ModelRendererTurbo(this, 881, 41, textureX, textureY); // Box 335
        chassis[97] = new ModelRendererTurbo(this, 897, 41, textureX, textureY); // Box 336
        chassis[98] = new ModelRendererTurbo(this, 913, 41, textureX, textureY); // Box 337
        chassis[99] = new ModelRendererTurbo(this, 929, 41, textureX, textureY); // Box 338
        chassis[100] = new ModelRendererTurbo(this, 945, 41, textureX, textureY); // Box 339
        chassis[101] = new ModelRendererTurbo(this, 961, 41, textureX, textureY); // Box 340
        chassis[102] = new ModelRendererTurbo(this, 977, 41, textureX, textureY); // Box 341
        chassis[103] = new ModelRendererTurbo(this, 993, 41, textureX, textureY); // Box 342
        chassis[104] = new ModelRendererTurbo(this, 1009, 41, textureX, textureY); // Box 343
        chassis[105] = new ModelRendererTurbo(this, 241, 49, textureX, textureY); // Box 344
        chassis[106] = new ModelRendererTurbo(this, 257, 49, textureX, textureY); // Box 345
        chassis[107] = new ModelRendererTurbo(this, 273, 49, textureX, textureY); // Box 346
        chassis[108] = new ModelRendererTurbo(this, 289, 49, textureX, textureY); // Box 347
        chassis[109] = new ModelRendererTurbo(this, 305, 49, textureX, textureY); // Box 348
        chassis[110] = new ModelRendererTurbo(this, 321, 49, textureX, textureY); // Box 349
        chassis[111] = new ModelRendererTurbo(this, 337, 49, textureX, textureY); // Box 350
        chassis[112] = new ModelRendererTurbo(this, 353, 49, textureX, textureY); // Box 351
        chassis[113] = new ModelRendererTurbo(this, 369, 49, textureX, textureY); // Box 352
        chassis[114] = new ModelRendererTurbo(this, 385, 49, textureX, textureY); // Box 353
        chassis[115] = new ModelRendererTurbo(this, 401, 49, textureX, textureY); // Box 354
        chassis[116] = new ModelRendererTurbo(this, 417, 49, textureX, textureY); // Box 355
        chassis[117] = new ModelRendererTurbo(this, 433, 49, textureX, textureY); // Box 356
        chassis[118] = new ModelRendererTurbo(this, 449, 49, textureX, textureY); // Box 357
        chassis[119] = new ModelRendererTurbo(this, 465, 49, textureX, textureY); // Box 358
        chassis[120] = new ModelRendererTurbo(this, 481, 49, textureX, textureY); // Box 359
        chassis[121] = new ModelRendererTurbo(this, 497, 49, textureX, textureY); // Box 360
        chassis[122] = new ModelRendererTurbo(this, 513, 49, textureX, textureY); // Box 361
        chassis[123] = new ModelRendererTurbo(this, 529, 49, textureX, textureY); // Box 362
        chassis[124] = new ModelRendererTurbo(this, 641, 49, textureX, textureY); // Box 363
        chassis[125] = new ModelRendererTurbo(this, 657, 49, textureX, textureY); // Box 364
        chassis[126] = new ModelRendererTurbo(this, 673, 49, textureX, textureY); // Box 365
        chassis[127] = new ModelRendererTurbo(this, 689, 49, textureX, textureY); // Box 366
        chassis[128] = new ModelRendererTurbo(this, 705, 49, textureX, textureY); // Box 367
        chassis[129] = new ModelRendererTurbo(this, 721, 49, textureX, textureY); // Box 368
        chassis[130] = new ModelRendererTurbo(this, 737, 49, textureX, textureY); // Box 369
        chassis[131] = new ModelRendererTurbo(this, 753, 49, textureX, textureY); // Box 370
        chassis[132] = new ModelRendererTurbo(this, 769, 49, textureX, textureY); // Box 371
        chassis[133] = new ModelRendererTurbo(this, 785, 49, textureX, textureY); // Box 372
        chassis[134] = new ModelRendererTurbo(this, 801, 49, textureX, textureY); // Box 373
        chassis[135] = new ModelRendererTurbo(this, 817, 49, textureX, textureY); // Box 374
        chassis[136] = new ModelRendererTurbo(this, 833, 49, textureX, textureY); // Box 375
        chassis[137] = new ModelRendererTurbo(this, 849, 49, textureX, textureY); // Box 376
        chassis[138] = new ModelRendererTurbo(this, 865, 49, textureX, textureY); // Box 377
        chassis[139] = new ModelRendererTurbo(this, 881, 49, textureX, textureY); // Box 378
        chassis[140] = new ModelRendererTurbo(this, 897, 49, textureX, textureY); // Box 379
        chassis[141] = new ModelRendererTurbo(this, 913, 49, textureX, textureY); // Box 380
        chassis[142] = new ModelRendererTurbo(this, 929, 49, textureX, textureY); // Box 381
        chassis[143] = new ModelRendererTurbo(this, 945, 49, textureX, textureY); // Box 382
        chassis[144] = new ModelRendererTurbo(this, 961, 49, textureX, textureY); // Box 383
        chassis[145] = new ModelRendererTurbo(this, 977, 49, textureX, textureY); // Box 384
        chassis[146] = new ModelRendererTurbo(this, 993, 49, textureX, textureY); // Box 385
        chassis[147] = new ModelRendererTurbo(this, 1009, 49, textureX, textureY); // Box 386
        chassis[148] = new ModelRendererTurbo(this, 1, 57, textureX, textureY); // Box 387
        chassis[149] = new ModelRendererTurbo(this, 17, 57, textureX, textureY); // Box 388
        chassis[150] = new ModelRendererTurbo(this, 33, 57, textureX, textureY); // Box 389
        chassis[151] = new ModelRendererTurbo(this, 49, 57, textureX, textureY); // Box 390
        chassis[152] = new ModelRendererTurbo(this, 65, 57, textureX, textureY); // Box 391
        chassis[153] = new ModelRendererTurbo(this, 81, 57, textureX, textureY); // Box 392
        chassis[154] = new ModelRendererTurbo(this, 97, 57, textureX, textureY); // Box 393
        chassis[155] = new ModelRendererTurbo(this, 113, 57, textureX, textureY); // Box 394
        chassis[156] = new ModelRendererTurbo(this, 129, 57, textureX, textureY); // Box 395
        chassis[157] = new ModelRendererTurbo(this, 145, 57, textureX, textureY); // Box 396
        chassis[158] = new ModelRendererTurbo(this, 161, 57, textureX, textureY); // Box 397
        chassis[159] = new ModelRendererTurbo(this, 281, 57, textureX, textureY); // Box 398
        chassis[160] = new ModelRendererTurbo(this, 297, 57, textureX, textureY); // Box 399
        chassis[161] = new ModelRendererTurbo(this, 313, 57, textureX, textureY); // Box 400
        chassis[162] = new ModelRendererTurbo(this, 329, 57, textureX, textureY); // Box 401
        chassis[163] = new ModelRendererTurbo(this, 345, 57, textureX, textureY); // Box 402
        chassis[164] = new ModelRendererTurbo(this, 361, 57, textureX, textureY); // Box 403
        chassis[165] = new ModelRendererTurbo(this, 377, 57, textureX, textureY); // Box 404
        chassis[166] = new ModelRendererTurbo(this, 393, 57, textureX, textureY); // Box 405
        chassis[167] = new ModelRendererTurbo(this, 409, 57, textureX, textureY); // Box 406
        chassis[168] = new ModelRendererTurbo(this, 425, 57, textureX, textureY); // Box 407
        chassis[169] = new ModelRendererTurbo(this, 441, 57, textureX, textureY); // Box 408
        chassis[170] = new ModelRendererTurbo(this, 457, 57, textureX, textureY); // Box 409
        chassis[171] = new ModelRendererTurbo(this, 473, 57, textureX, textureY); // Box 410
        chassis[172] = new ModelRendererTurbo(this, 489, 57, textureX, textureY); // Box 411
        chassis[173] = new ModelRendererTurbo(this, 505, 57, textureX, textureY); // Box 412
        chassis[174] = new ModelRendererTurbo(this, 521, 57, textureX, textureY); // Box 413
        chassis[175] = new ModelRendererTurbo(this, 537, 57, textureX, textureY); // Box 414
        chassis[176] = new ModelRendererTurbo(this, 553, 57, textureX, textureY); // Box 415
        chassis[177] = new ModelRendererTurbo(this, 569, 57, textureX, textureY); // Box 416
        chassis[178] = new ModelRendererTurbo(this, 585, 57, textureX, textureY); // Box 417
        chassis[179] = new ModelRendererTurbo(this, 601, 57, textureX, textureY); // Box 418
        chassis[180] = new ModelRendererTurbo(this, 617, 57, textureX, textureY); // Box 419
        chassis[181] = new ModelRendererTurbo(this, 633, 57, textureX, textureY); // Box 420
        chassis[182] = new ModelRendererTurbo(this, 649, 57, textureX, textureY); // Box 421
        chassis[183] = new ModelRendererTurbo(this, 665, 57, textureX, textureY); // Box 422
        chassis[184] = new ModelRendererTurbo(this, 681, 57, textureX, textureY); // Box 423
        chassis[185] = new ModelRendererTurbo(this, 697, 57, textureX, textureY); // Box 424
        chassis[186] = new ModelRendererTurbo(this, 713, 57, textureX, textureY); // Box 425
        chassis[187] = new ModelRendererTurbo(this, 729, 57, textureX, textureY); // Box 426
        chassis[188] = new ModelRendererTurbo(this, 745, 57, textureX, textureY); // Box 427
        chassis[189] = new ModelRendererTurbo(this, 761, 57, textureX, textureY); // Box 428
        chassis[190] = new ModelRendererTurbo(this, 777, 57, textureX, textureY); // Box 429
        chassis[191] = new ModelRendererTurbo(this, 793, 57, textureX, textureY); // Box 430
        chassis[192] = new ModelRendererTurbo(this, 809, 57, textureX, textureY); // Box 431
        chassis[193] = new ModelRendererTurbo(this, 825, 57, textureX, textureY); // Box 432
        chassis[194] = new ModelRendererTurbo(this, 841, 57, textureX, textureY); // Box 433
        chassis[195] = new ModelRendererTurbo(this, 857, 57, textureX, textureY); // Box 434
        chassis[196] = new ModelRendererTurbo(this, 873, 57, textureX, textureY); // Box 435
        chassis[197] = new ModelRendererTurbo(this, 889, 57, textureX, textureY); // Box 436
        chassis[198] = new ModelRendererTurbo(this, 905, 57, textureX, textureY); // Box 437
        chassis[199] = new ModelRendererTurbo(this, 921, 57, textureX, textureY); // Box 438
        chassis[200] = new ModelRendererTurbo(this, 937, 57, textureX, textureY); // Box 439
        chassis[201] = new ModelRendererTurbo(this, 953, 57, textureX, textureY); // Box 440
        chassis[202] = new ModelRendererTurbo(this, 969, 57, textureX, textureY); // Box 441
        chassis[203] = new ModelRendererTurbo(this, 985, 57, textureX, textureY); // Box 442
        chassis[204] = new ModelRendererTurbo(this, 1001, 57, textureX, textureY); // Box 443
        chassis[205] = new ModelRendererTurbo(this, 1, 65, textureX, textureY); // Box 444
        chassis[206] = new ModelRendererTurbo(this, 17, 65, textureX, textureY); // Box 445
        chassis[207] = new ModelRendererTurbo(this, 33, 65, textureX, textureY); // Box 446
        chassis[208] = new ModelRendererTurbo(this, 49, 65, textureX, textureY); // Box 447
        chassis[209] = new ModelRendererTurbo(this, 65, 65, textureX, textureY); // Box 448
        chassis[210] = new ModelRendererTurbo(this, 81, 65, textureX, textureY); // Box 449
        chassis[211] = new ModelRendererTurbo(this, 97, 65, textureX, textureY); // Box 450
        chassis[212] = new ModelRendererTurbo(this, 113, 65, textureX, textureY); // Box 451
        chassis[213] = new ModelRendererTurbo(this, 129, 65, textureX, textureY); // Box 452
        chassis[214] = new ModelRendererTurbo(this, 145, 65, textureX, textureY); // Box 453
        chassis[215] = new ModelRendererTurbo(this, 161, 65, textureX, textureY); // Box 454
        chassis[216] = new ModelRendererTurbo(this, 177, 65, textureX, textureY); // Box 455
        chassis[217] = new ModelRendererTurbo(this, 193, 65, textureX, textureY); // Box 456
        chassis[218] = new ModelRendererTurbo(this, 209, 65, textureX, textureY); // Box 457
        chassis[219] = new ModelRendererTurbo(this, 225, 65, textureX, textureY); // Box 458
        chassis[220] = new ModelRendererTurbo(this, 241, 65, textureX, textureY); // Box 459
        chassis[221] = new ModelRendererTurbo(this, 257, 65, textureX, textureY); // Box 460
        chassis[222] = new ModelRendererTurbo(this, 273, 65, textureX, textureY); // Box 461
        chassis[223] = new ModelRendererTurbo(this, 289, 65, textureX, textureY); // Box 462
        chassis[224] = new ModelRendererTurbo(this, 305, 65, textureX, textureY); // Box 463
        chassis[225] = new ModelRendererTurbo(this, 321, 65, textureX, textureY); // Box 464
        chassis[226] = new ModelRendererTurbo(this, 337, 65, textureX, textureY); // Box 465
        chassis[227] = new ModelRendererTurbo(this, 353, 65, textureX, textureY); // Box 466
        chassis[228] = new ModelRendererTurbo(this, 369, 65, textureX, textureY); // Box 467
        chassis[229] = new ModelRendererTurbo(this, 385, 65, textureX, textureY); // Box 468
        chassis[230] = new ModelRendererTurbo(this, 401, 65, textureX, textureY); // Box 469
        chassis[231] = new ModelRendererTurbo(this, 417, 65, textureX, textureY); // Box 470
        chassis[232] = new ModelRendererTurbo(this, 433, 65, textureX, textureY); // Box 471
        chassis[233] = new ModelRendererTurbo(this, 449, 65, textureX, textureY); // Box 472
        chassis[234] = new ModelRendererTurbo(this, 465, 65, textureX, textureY); // Box 473
        chassis[235] = new ModelRendererTurbo(this, 481, 65, textureX, textureY); // Box 474
        chassis[236] = new ModelRendererTurbo(this, 497, 65, textureX, textureY); // Box 475
        chassis[237] = new ModelRendererTurbo(this, 513, 65, textureX, textureY); // Box 476
        chassis[238] = new ModelRendererTurbo(this, 529, 65, textureX, textureY); // Box 477
        chassis[239] = new ModelRendererTurbo(this, 545, 65, textureX, textureY); // Box 478
        chassis[240] = new ModelRendererTurbo(this, 561, 65, textureX, textureY); // Box 479
        chassis[241] = new ModelRendererTurbo(this, 577, 65, textureX, textureY); // Box 480
        chassis[242] = new ModelRendererTurbo(this, 593, 65, textureX, textureY); // Box 481
        chassis[243] = new ModelRendererTurbo(this, 609, 65, textureX, textureY); // Box 482
        chassis[244] = new ModelRendererTurbo(this, 625, 65, textureX, textureY); // Box 483
        chassis[245] = new ModelRendererTurbo(this, 641, 65, textureX, textureY); // Box 484
        chassis[246] = new ModelRendererTurbo(this, 657, 65, textureX, textureY); // Box 485
        chassis[247] = new ModelRendererTurbo(this, 673, 65, textureX, textureY); // Box 486
        chassis[248] = new ModelRendererTurbo(this, 689, 65, textureX, textureY); // Box 487
        chassis[249] = new ModelRendererTurbo(this, 705, 65, textureX, textureY); // Box 488
        chassis[250] = new ModelRendererTurbo(this, 721, 65, textureX, textureY); // Box 489
        chassis[251] = new ModelRendererTurbo(this, 737, 65, textureX, textureY); // Box 490
        chassis[252] = new ModelRendererTurbo(this, 753, 65, textureX, textureY); // Box 491
        chassis[253] = new ModelRendererTurbo(this, 769, 65, textureX, textureY); // Box 492
        chassis[254] = new ModelRendererTurbo(this, 785, 65, textureX, textureY); // Box 493
        chassis[255] = new ModelRendererTurbo(this, 801, 65, textureX, textureY); // Box 494
        chassis[256] = new ModelRendererTurbo(this, 817, 65, textureX, textureY); // Box 495
        chassis[257] = new ModelRendererTurbo(this, 833, 65, textureX, textureY); // Box 496
        chassis[258] = new ModelRendererTurbo(this, 849, 65, textureX, textureY); // Box 497
        chassis[259] = new ModelRendererTurbo(this, 865, 65, textureX, textureY); // Box 498
        chassis[260] = new ModelRendererTurbo(this, 881, 65, textureX, textureY); // Box 499
        chassis[261] = new ModelRendererTurbo(this, 897, 65, textureX, textureY); // Box 500
        chassis[262] = new ModelRendererTurbo(this, 913, 65, textureX, textureY); // Box 501
        chassis[263] = new ModelRendererTurbo(this, 929, 65, textureX, textureY); // Box 502
        chassis[264] = new ModelRendererTurbo(this, 945, 65, textureX, textureY); // Box 503
        chassis[265] = new ModelRendererTurbo(this, 961, 65, textureX, textureY); // Box 504
        chassis[266] = new ModelRendererTurbo(this, 977, 65, textureX, textureY); // Box 505
        chassis[267] = new ModelRendererTurbo(this, 993, 65, textureX, textureY); // Box 506
        chassis[268] = new ModelRendererTurbo(this, 1009, 65, textureX, textureY); // Box 507
        chassis[269] = new ModelRendererTurbo(this, 1, 73, textureX, textureY); // Box 508
        chassis[270] = new ModelRendererTurbo(this, 17, 73, textureX, textureY); // Box 509
        chassis[271] = new ModelRendererTurbo(this, 33, 73, textureX, textureY); // Box 510
        chassis[272] = new ModelRendererTurbo(this, 49, 73, textureX, textureY); // Box 511
        chassis[273] = new ModelRendererTurbo(this, 65, 73, textureX, textureY); // Box 512
        chassis[274] = new ModelRendererTurbo(this, 81, 73, textureX, textureY); // Box 513
        chassis[275] = new ModelRendererTurbo(this, 97, 73, textureX, textureY); // Box 514
        chassis[276] = new ModelRendererTurbo(this, 113, 73, textureX, textureY); // Box 515
        chassis[277] = new ModelRendererTurbo(this, 129, 73, textureX, textureY); // Box 516
        chassis[278] = new ModelRendererTurbo(this, 145, 73, textureX, textureY); // Box 517
        chassis[279] = new ModelRendererTurbo(this, 161, 73, textureX, textureY); // Box 518
        chassis[280] = new ModelRendererTurbo(this, 177, 73, textureX, textureY); // Box 519
        chassis[281] = new ModelRendererTurbo(this, 193, 73, textureX, textureY); // Box 520
        chassis[282] = new ModelRendererTurbo(this, 209, 73, textureX, textureY); // Box 521
        chassis[283] = new ModelRendererTurbo(this, 225, 73, textureX, textureY); // Box 522
        chassis[284] = new ModelRendererTurbo(this, 241, 73, textureX, textureY); // Box 523
        chassis[285] = new ModelRendererTurbo(this, 257, 73, textureX, textureY); // Box 524
        chassis[286] = new ModelRendererTurbo(this, 273, 73, textureX, textureY); // Box 525
        chassis[287] = new ModelRendererTurbo(this, 289, 73, textureX, textureY); // Box 526
        chassis[288] = new ModelRendererTurbo(this, 305, 73, textureX, textureY); // Box 527
        chassis[289] = new ModelRendererTurbo(this, 321, 73, textureX, textureY); // Box 528
        chassis[290] = new ModelRendererTurbo(this, 337, 73, textureX, textureY); // Box 529
        chassis[291] = new ModelRendererTurbo(this, 353, 73, textureX, textureY); // Box 530
        chassis[292] = new ModelRendererTurbo(this, 369, 73, textureX, textureY); // Box 531
        chassis[293] = new ModelRendererTurbo(this, 385, 73, textureX, textureY); // Box 532
        chassis[294] = new ModelRendererTurbo(this, 401, 73, textureX, textureY); // Box 533
        chassis[295] = new ModelRendererTurbo(this, 417, 73, textureX, textureY); // Box 534
        chassis[296] = new ModelRendererTurbo(this, 433, 73, textureX, textureY); // Box 535
        chassis[297] = new ModelRendererTurbo(this, 449, 73, textureX, textureY); // Box 536
        chassis[298] = new ModelRendererTurbo(this, 465, 73, textureX, textureY); // Box 537
        chassis[299] = new ModelRendererTurbo(this, 481, 73, textureX, textureY); // Box 538
        chassis[300] = new ModelRendererTurbo(this, 497, 73, textureX, textureY); // Box 539
        chassis[301] = new ModelRendererTurbo(this, 513, 73, textureX, textureY); // Box 540
        chassis[302] = new ModelRendererTurbo(this, 529, 73, textureX, textureY); // Box 541
        chassis[303] = new ModelRendererTurbo(this, 545, 73, textureX, textureY); // Box 542
        chassis[304] = new ModelRendererTurbo(this, 561, 73, textureX, textureY); // Box 543
        chassis[305] = new ModelRendererTurbo(this, 577, 73, textureX, textureY); // Box 544
        chassis[306] = new ModelRendererTurbo(this, 593, 73, textureX, textureY); // Box 545
        chassis[307] = new ModelRendererTurbo(this, 609, 73, textureX, textureY); // Box 546
        chassis[308] = new ModelRendererTurbo(this, 625, 73, textureX, textureY); // Box 547
        chassis[309] = new ModelRendererTurbo(this, 641, 73, textureX, textureY); // Box 548
        chassis[310] = new ModelRendererTurbo(this, 657, 73, textureX, textureY); // Box 549
        chassis[311] = new ModelRendererTurbo(this, 673, 73, textureX, textureY); // Box 550
        chassis[312] = new ModelRendererTurbo(this, 689, 73, textureX, textureY); // Box 551
        chassis[313] = new ModelRendererTurbo(this, 705, 73, textureX, textureY); // Box 552
        chassis[314] = new ModelRendererTurbo(this, 721, 73, textureX, textureY); // Box 553
        chassis[315] = new ModelRendererTurbo(this, 737, 73, textureX, textureY); // Box 554
        chassis[316] = new ModelRendererTurbo(this, 753, 73, textureX, textureY); // Box 555
        chassis[317] = new ModelRendererTurbo(this, 769, 73, textureX, textureY); // Box 556
        chassis[318] = new ModelRendererTurbo(this, 785, 73, textureX, textureY); // Box 557
        chassis[319] = new ModelRendererTurbo(this, 801, 73, textureX, textureY); // Box 558
        chassis[320] = new ModelRendererTurbo(this, 817, 73, textureX, textureY); // Box 559
        chassis[321] = new ModelRendererTurbo(this, 833, 73, textureX, textureY); // Box 560
        chassis[322] = new ModelRendererTurbo(this, 849, 73, textureX, textureY); // Box 561
        chassis[323] = new ModelRendererTurbo(this, 865, 73, textureX, textureY); // Box 562
        chassis[324] = new ModelRendererTurbo(this, 881, 73, textureX, textureY); // Box 563
        chassis[325] = new ModelRendererTurbo(this, 897, 73, textureX, textureY); // Box 564
        chassis[326] = new ModelRendererTurbo(this, 913, 73, textureX, textureY); // Box 565
        chassis[327] = new ModelRendererTurbo(this, 929, 73, textureX, textureY); // Box 566
        chassis[328] = new ModelRendererTurbo(this, 945, 73, textureX, textureY); // Box 567
        chassis[329] = new ModelRendererTurbo(this, 961, 73, textureX, textureY); // Box 568
        chassis[330] = new ModelRendererTurbo(this, 977, 73, textureX, textureY); // Box 569
        chassis[331] = new ModelRendererTurbo(this, 993, 73, textureX, textureY); // Box 570
        chassis[332] = new ModelRendererTurbo(this, 1009, 73, textureX, textureY); // Box 571
        chassis[333] = new ModelRendererTurbo(this, 1, 81, textureX, textureY); // Box 572
        chassis[334] = new ModelRendererTurbo(this, 17, 81, textureX, textureY); // Box 573
        chassis[335] = new ModelRendererTurbo(this, 33, 81, textureX, textureY); // Box 574
        chassis[336] = new ModelRendererTurbo(this, 49, 81, textureX, textureY); // Box 575
        chassis[337] = new ModelRendererTurbo(this, 65, 81, textureX, textureY); // Box 576
        chassis[338] = new ModelRendererTurbo(this, 81, 81, textureX, textureY); // Box 577
        chassis[339] = new ModelRendererTurbo(this, 97, 81, textureX, textureY); // Box 578
        chassis[340] = new ModelRendererTurbo(this, 113, 81, textureX, textureY); // Box 579
        chassis[341] = new ModelRendererTurbo(this, 129, 81, textureX, textureY); // Box 580
        chassis[342] = new ModelRendererTurbo(this, 145, 81, textureX, textureY); // Box 581
        chassis[343] = new ModelRendererTurbo(this, 161, 81, textureX, textureY); // Box 582
        chassis[344] = new ModelRendererTurbo(this, 177, 81, textureX, textureY); // Box 583
        chassis[345] = new ModelRendererTurbo(this, 193, 81, textureX, textureY); // Box 584
        chassis[346] = new ModelRendererTurbo(this, 209, 81, textureX, textureY); // Box 585
        chassis[347] = new ModelRendererTurbo(this, 225, 81, textureX, textureY); // Box 586
        chassis[348] = new ModelRendererTurbo(this, 241, 81, textureX, textureY); // Box 587
        chassis[349] = new ModelRendererTurbo(this, 257, 81, textureX, textureY); // Box 588
        chassis[350] = new ModelRendererTurbo(this, 273, 81, textureX, textureY); // Box 589
        chassis[351] = new ModelRendererTurbo(this, 289, 81, textureX, textureY); // Box 590
        chassis[352] = new ModelRendererTurbo(this, 297, 81, textureX, textureY); // Box 591
        chassis[353] = new ModelRendererTurbo(this, 321, 81, textureX, textureY); // Box 592
        chassis[354] = new ModelRendererTurbo(this, 345, 81, textureX, textureY); // Box 593
        chassis[355] = new ModelRendererTurbo(this, 369, 81, textureX, textureY); // Box 594
        chassis[356] = new ModelRendererTurbo(this, 393, 81, textureX, textureY); // Box 595
        chassis[357] = new ModelRendererTurbo(this, 417, 81, textureX, textureY); // Box 596
        chassis[358] = new ModelRendererTurbo(this, 441, 81, textureX, textureY); // Box 597
        chassis[359] = new ModelRendererTurbo(this, 465, 81, textureX, textureY); // Box 598
        chassis[360] = new ModelRendererTurbo(this, 489, 81, textureX, textureY); // Box 599
        chassis[361] = new ModelRendererTurbo(this, 513, 81, textureX, textureY); // Box 600
        chassis[362] = new ModelRendererTurbo(this, 537, 81, textureX, textureY); // Box 601
        chassis[363] = new ModelRendererTurbo(this, 561, 81, textureX, textureY); // Box 602
        chassis[364] = new ModelRendererTurbo(this, 585, 81, textureX, textureY); // Box 603
        chassis[365] = new ModelRendererTurbo(this, 609, 81, textureX, textureY); // Box 604
        chassis[366] = new ModelRendererTurbo(this, 633, 81, textureX, textureY); // Box 605
        chassis[367] = new ModelRendererTurbo(this, 657, 81, textureX, textureY); // Box 606
        chassis[368] = new ModelRendererTurbo(this, 681, 81, textureX, textureY); // Box 607
        chassis[369] = new ModelRendererTurbo(this, 705, 81, textureX, textureY); // Box 611
        chassis[370] = new ModelRendererTurbo(this, 729, 81, textureX, textureY); // Box 612
        chassis[371] = new ModelRendererTurbo(this, 753, 81, textureX, textureY); // Box 613
        chassis[372] = new ModelRendererTurbo(this, 817, 73, textureX, textureY); // Box 614
        chassis[373] = new ModelRendererTurbo(this, 777, 81, textureX, textureY); // Box 615
        chassis[374] = new ModelRendererTurbo(this, 849, 81, textureX, textureY); // Box 617
        chassis[375] = new ModelRendererTurbo(this, 873, 81, textureX, textureY); // Box 618
        chassis[376] = new ModelRendererTurbo(this, 897, 81, textureX, textureY); // Box 620
        chassis[377] = new ModelRendererTurbo(this, 993, 73, textureX, textureY); // Box 621
        chassis[378] = new ModelRendererTurbo(this, 17, 81, textureX, textureY); // Box 622
        chassis[379] = new ModelRendererTurbo(this, 49, 81, textureX, textureY); // Box 623
        chassis[380] = new ModelRendererTurbo(this, 921, 81, textureX, textureY); // Box 624
        chassis[381] = new ModelRendererTurbo(this, 945, 81, textureX, textureY); // Box 627
        chassis[382] = new ModelRendererTurbo(this, 969, 81, textureX, textureY); // Box 628
        chassis[383] = new ModelRendererTurbo(this, 81, 89, textureX, textureY); // Box 629
        chassis[384] = new ModelRendererTurbo(this, 145, 81, textureX, textureY); // Box 630
        chassis[385] = new ModelRendererTurbo(this, 105, 89, textureX, textureY); // Box 631
        chassis[386] = new ModelRendererTurbo(this, 177, 89, textureX, textureY); // Box 633
        chassis[387] = new ModelRendererTurbo(this, 201, 89, textureX, textureY); // Box 634
        chassis[388] = new ModelRendererTurbo(this, 225, 97, textureX, textureY); // Box 635
        chassis[389] = new ModelRendererTurbo(this, 313, 97, textureX, textureY); // Box 636
        chassis[390] = new ModelRendererTurbo(this, 801, 81, textureX, textureY); // Box 637
        chassis[391] = new ModelRendererTurbo(this, 1, 89, textureX, textureY); // Box 638
        chassis[392] = new ModelRendererTurbo(this, 33, 89, textureX, textureY); // Box 639
        chassis[393] = new ModelRendererTurbo(this, 337, 97, textureX, textureY); // Box 640
        chassis[394] = new ModelRendererTurbo(this, 425, 97, textureX, textureY); // Box 641
        chassis[395] = new ModelRendererTurbo(this, 513, 97, textureX, textureY); // Box 642
        chassis[396] = new ModelRendererTurbo(this, 601, 97, textureX, textureY); // Box 643
        chassis[397] = new ModelRendererTurbo(this, 689, 97, textureX, textureY); // Box 644
        chassis[398] = new ModelRendererTurbo(this, 833, 97, textureX, textureY); // Box 645
        chassis[399] = new ModelRendererTurbo(this, 921, 97, textureX, textureY); // Box 646
        chassis[400] = new ModelRendererTurbo(this, 65, 105, textureX, textureY); // Box 647
        chassis[401] = new ModelRendererTurbo(this, 153, 105, textureX, textureY); // Box 648
        chassis[402] = new ModelRendererTurbo(this, 337, 105, textureX, textureY); // Box 649
        chassis[403] = new ModelRendererTurbo(this, 425, 105, textureX, textureY); // Box 650
        chassis[404] = new ModelRendererTurbo(this, 513, 105, textureX, textureY); // Box 651
        chassis[405] = new ModelRendererTurbo(this, 601, 105, textureX, textureY); // Box 652
        chassis[406] = new ModelRendererTurbo(this, 689, 105, textureX, textureY); // Box 653
        chassis[407] = new ModelRendererTurbo(this, 777, 105, textureX, textureY); // Box 654
        chassis[408] = new ModelRendererTurbo(this, 865, 105, textureX, textureY); // Box 655
        chassis[409] = new ModelRendererTurbo(this, 1, 113, textureX, textureY); // Box 656
        chassis[410] = new ModelRendererTurbo(this, 113, 113, textureX, textureY); // Box 657
        chassis[411] = new ModelRendererTurbo(this, 225, 113, textureX, textureY); // Box 658
        chassis[412] = new ModelRendererTurbo(this, 337, 113, textureX, textureY); // Box 659
        chassis[413] = new ModelRendererTurbo(this, 449, 113, textureX, textureY); // Box 660
        chassis[414] = new ModelRendererTurbo(this, 561, 113, textureX, textureY); // Box 661
        chassis[415] = new ModelRendererTurbo(this, 673, 113, textureX, textureY); // Box 662
        chassis[416] = new ModelRendererTurbo(this, 977, 105, textureX, textureY); // Box 663
        chassis[417] = new ModelRendererTurbo(this, 785, 113, textureX, textureY); // Box 669
        chassis[418] = new ModelRendererTurbo(this, 825, 113, textureX, textureY); // Box 670
        chassis[419] = new ModelRendererTurbo(this, 865, 121, textureX, textureY); // Box 671
        chassis[420] = new ModelRendererTurbo(this, 905, 121, textureX, textureY); // Box 672
        chassis[421] = new ModelRendererTurbo(this, 945, 121, textureX, textureY); // Box 673
        chassis[422] = new ModelRendererTurbo(this, 1, 129, textureX, textureY); // Box 674
        chassis[423] = new ModelRendererTurbo(this, 41, 129, textureX, textureY); // Box 675
        chassis[424] = new ModelRendererTurbo(this, 81, 129, textureX, textureY); // Box 676
        chassis[425] = new ModelRendererTurbo(this, 185, 129, textureX, textureY); // Box 677
        chassis[426] = new ModelRendererTurbo(this, 289, 129, textureX, textureY); // Box 678
        chassis[427] = new ModelRendererTurbo(this, 393, 129, textureX, textureY); // Box 679
        chassis[428] = new ModelRendererTurbo(this, 497, 129, textureX, textureY); // Box 724
        chassis[429] = new ModelRendererTurbo(this, 521, 129, textureX, textureY); // Box 726
        chassis[430] = new ModelRendererTurbo(this, 545, 129, textureX, textureY); // Box 727
        chassis[431] = new ModelRendererTurbo(this, 1009, 121, textureX, textureY); // Box 730
        chassis[432] = new ModelRendererTurbo(this, 569, 129, textureX, textureY); // Box 731
        chassis[433] = new ModelRendererTurbo(this, 585, 129, textureX, textureY); // Box 748
        chassis[434] = new ModelRendererTurbo(this, 609, 129, textureX, textureY); // Box 749
        chassis[435] = new ModelRendererTurbo(this, 625, 129, textureX, textureY); // Box 750
        chassis[436] = new ModelRendererTurbo(this, 641, 129, textureX, textureY); // Box 751
        chassis[437] = new ModelRendererTurbo(this, 665, 129, textureX, textureY); // Box 752
        chassis[438] = new ModelRendererTurbo(this, 689, 129, textureX, textureY); // Box 753
        chassis[439] = new ModelRendererTurbo(this, 713, 129, textureX, textureY); // Box 754
        chassis[440] = new ModelRendererTurbo(this, 729, 129, textureX, textureY); // Box 755
        chassis[441] = new ModelRendererTurbo(this, 745, 129, textureX, textureY); // Box 756
        chassis[442] = new ModelRendererTurbo(this, 769, 129, textureX, textureY); // Box 757
        chassis[443] = new ModelRendererTurbo(this, 985, 129, textureX, textureY); // Box 758
        chassis[444] = new ModelRendererTurbo(this, 785, 137, textureX, textureY); // Box 759
        chassis[445] = new ModelRendererTurbo(this, 809, 137, textureX, textureY); // Box 760
        chassis[446] = new ModelRendererTurbo(this, 833, 137, textureX, textureY); // Box 761
        chassis[447] = new ModelRendererTurbo(this, 73, 145, textureX, textureY); // Box 762
        chassis[448] = new ModelRendererTurbo(this, 89, 145, textureX, textureY); // Box 763
        chassis[449] = new ModelRendererTurbo(this, 105, 145, textureX, textureY); // Box 764
        chassis[450] = new ModelRendererTurbo(this, 129, 145, textureX, textureY); // Box 765
        chassis[451] = new ModelRendererTurbo(this, 145, 145, textureX, textureY); // Box 766
        chassis[452] = new ModelRendererTurbo(this, 161, 145, textureX, textureY); // Box 767
        chassis[453] = new ModelRendererTurbo(this, 185, 145, textureX, textureY); // Box 768
        chassis[454] = new ModelRendererTurbo(this, 209, 145, textureX, textureY); // Box 769
        chassis[455] = new ModelRendererTurbo(this, 233, 145, textureX, textureY); // Box 770
        chassis[456] = new ModelRendererTurbo(this, 249, 145, textureX, textureY); // Box 771
        chassis[457] = new ModelRendererTurbo(this, 265, 145, textureX, textureY); // Box 772
        chassis[458] = new ModelRendererTurbo(this, 289, 145, textureX, textureY); // Box 773
        chassis[459] = new ModelRendererTurbo(this, 305, 145, textureX, textureY); // Box 774
        chassis[460] = new ModelRendererTurbo(this, 321, 145, textureX, textureY); // Box 775
        chassis[461] = new ModelRendererTurbo(this, 321, 161, textureX, textureY); // Box 776
        chassis[462] = new ModelRendererTurbo(this, 321, 177, textureX, textureY); // Box 777
        chassis[463] = new ModelRendererTurbo(this, 321, 193, textureX, textureY); // Box 778
        chassis[464] = new ModelRendererTurbo(this, 321, 209, textureX, textureY); // Box 779
        chassis[465] = new ModelRendererTurbo(this, 857, 273, textureX, textureY); // Box 780
        chassis[466] = new ModelRendererTurbo(this, 473, 281, textureX, textureY); // Box 781
        chassis[467] = new ModelRendererTurbo(this, 641, 281, textureX, textureY); // Box 782
        chassis[468] = new ModelRendererTurbo(this, 1, 289, textureX, textureY); // Box 579
        chassis[469] = new ModelRendererTurbo(this, 257, 361, textureX, textureY); // Box 580
        chassis[470] = new ModelRendererTurbo(this, 513, 369, textureX, textureY); // Box 581
        chassis[471] = new ModelRendererTurbo(this, 1, 529, textureX, textureY); // Box 582
        chassis[472] = new ModelRendererTurbo(this, 257, 601, textureX, textureY); // Box 583
        chassis[473] = new ModelRendererTurbo(this, 497, 617, textureX, textureY); // Box 584
        chassis[474] = new ModelRendererTurbo(this, 857, 145, textureX, textureY); // Box 585
        chassis[475] = new ModelRendererTurbo(this, 881, 145, textureX, textureY); // Box 586
        chassis[476] = new ModelRendererTurbo(this, 905, 145, textureX, textureY); // Box 587
        chassis[477] = new ModelRendererTurbo(this, 929, 145, textureX, textureY); // Box 588
        chassis[478] = new ModelRendererTurbo(this, 953, 145, textureX, textureY); // Box 589
        chassis[479] = new ModelRendererTurbo(this, 1, 153, textureX, textureY); // Box 590
        chassis[480] = new ModelRendererTurbo(this, 25, 153, textureX, textureY); // Box 591
        chassis[481] = new ModelRendererTurbo(this, 49, 153, textureX, textureY); // Box 592
        chassis[482] = new ModelRendererTurbo(this, 857, 161, textureX, textureY); // Box 593
        chassis[483] = new ModelRendererTurbo(this, 881, 161, textureX, textureY); // Box 594
        chassis[484] = new ModelRendererTurbo(this, 905, 161, textureX, textureY); // Box 595
        chassis[485] = new ModelRendererTurbo(this, 929, 161, textureX, textureY); // Box 596
        chassis[486] = new ModelRendererTurbo(this, 953, 161, textureX, textureY); // Box 597
        chassis[487] = new ModelRendererTurbo(this, 1, 169, textureX, textureY); // Box 598
        chassis[488] = new ModelRendererTurbo(this, 25, 169, textureX, textureY); // Box 599
        chassis[489] = new ModelRendererTurbo(this, 49, 169, textureX, textureY); // Box 600
        chassis[490] = new ModelRendererTurbo(this, 1, 289, textureX, textureY); // Box 601
        chassis[491] = new ModelRendererTurbo(this, 257, 289, textureX, textureY); // Box 602
        chassis[492] = new ModelRendererTurbo(this, 1, 769, textureX, textureY); // Box 603
        chassis[493] = new ModelRendererTurbo(this, 1, 769, textureX, textureY); // Box 604
        chassis[494] = new ModelRendererTurbo(this, 1, 769, textureX, textureY); // Box 605
        chassis[495] = new ModelRendererTurbo(this, 1, 769, textureX, textureY); // Box 606
        chassis[496] = new ModelRendererTurbo(this, 1, 769, textureX, textureY); // Box 620
        chassis[497] = new ModelRendererTurbo(this, 1, 769, textureX, textureY); // Box 621
        chassis[498] = new ModelRendererTurbo(this, 1, 769, textureX, textureY); // Box 622
        chassis[499] = new ModelRendererTurbo(this, 1, 769, textureX, textureY); // Box 623
        chassis[500] = new ModelRendererTurbo(this, 41, 185, textureX, textureY); // Box 853
        chassis[501] = new ModelRendererTurbo(this, 889, 185, textureX, textureY); // Box 855

        chassis[0].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 202
        chassis[0].setRotationPoint(-28F, -4F, -115F);

        chassis[1].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 203
        chassis[1].setRotationPoint(-31F, -9F, -115F);

        chassis[2].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 204
        chassis[2].setRotationPoint(-23F, -9F, -115F);

        chassis[3].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 205
        chassis[3].setRotationPoint(-28F, -12F, -115F);

        chassis[4].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F); // Box 206
        chassis[4].setRotationPoint(-31F, -12F, -115F);

        chassis[5].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F); // Box 207
        chassis[5].setRotationPoint(-24F, -12F, -115F);

        chassis[6].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 208
        chassis[6].setRotationPoint(-31F, -5F, -115F);

        chassis[7].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 209
        chassis[7].setRotationPoint(-24F, -5F, -115F);

        chassis[8].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 218
        chassis[8].setRotationPoint(-40F, -4F, -115F);

        chassis[9].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 219
        chassis[9].setRotationPoint(-43F, -9F, -115F);

        chassis[10].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 220
        chassis[10].setRotationPoint(-35F, -9F, -115F);

        chassis[11].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 221
        chassis[11].setRotationPoint(-40F, -12F, -115F);

        chassis[12].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F); // Box 222
        chassis[12].setRotationPoint(-43F, -12F, -115F);

        chassis[13].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F); // Box 223
        chassis[13].setRotationPoint(-36F, -12F, -115F);

        chassis[14].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 224
        chassis[14].setRotationPoint(-43F, -5F, -115F);

        chassis[15].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 225
        chassis[15].setRotationPoint(-36F, -5F, -115F);

        chassis[16].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 250
        chassis[16].setRotationPoint(36F, -4F, 113F);

        chassis[17].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 251
        chassis[17].setRotationPoint(33F, -9F, 113F);

        chassis[18].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 252
        chassis[18].setRotationPoint(41F, -9F, 113F);

        chassis[19].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 253
        chassis[19].setRotationPoint(36F, -12F, 113F);

        chassis[20].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F); // Box 254
        chassis[20].setRotationPoint(33F, -12F, 113F);

        chassis[21].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F); // Box 255
        chassis[21].setRotationPoint(40F, -12F, 113F);

        chassis[22].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 256
        chassis[22].setRotationPoint(33F, -5F, 113F);

        chassis[23].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 257
        chassis[23].setRotationPoint(40F, -5F, 113F);

        chassis[24].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 258
        chassis[24].setRotationPoint(24F, -4F, 113F);

        chassis[25].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 259
        chassis[25].setRotationPoint(21F, -9F, 113F);

        chassis[26].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 260
        chassis[26].setRotationPoint(29F, -9F, 113F);

        chassis[27].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 261
        chassis[27].setRotationPoint(24F, -12F, 113F);

        chassis[28].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F); // Box 262
        chassis[28].setRotationPoint(21F, -12F, 113F);

        chassis[29].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F); // Box 263
        chassis[29].setRotationPoint(28F, -12F, 113F);

        chassis[30].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 264
        chassis[30].setRotationPoint(21F, -5F, 113F);

        chassis[31].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 265
        chassis[31].setRotationPoint(28F, -5F, 113F);

        chassis[32].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 267
        chassis[32].setRotationPoint(-28F, -4F, 113F);

        chassis[33].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 268
        chassis[33].setRotationPoint(-31F, -9F, 113F);

        chassis[34].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 269
        chassis[34].setRotationPoint(-23F, -9F, 113F);

        chassis[35].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 270
        chassis[35].setRotationPoint(-28F, -12F, 113F);

        chassis[36].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F); // Box 271
        chassis[36].setRotationPoint(-31F, -12F, 113F);

        chassis[37].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F); // Box 272
        chassis[37].setRotationPoint(-24F, -12F, 113F);

        chassis[38].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 273
        chassis[38].setRotationPoint(-31F, -5F, 113F);

        chassis[39].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 274
        chassis[39].setRotationPoint(-24F, -5F, 113F);

        chassis[40].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 275
        chassis[40].setRotationPoint(-40F, -4F, 113F);

        chassis[41].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 276
        chassis[41].setRotationPoint(-43F, -9F, 113F);

        chassis[42].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 277
        chassis[42].setRotationPoint(-35F, -9F, 113F);

        chassis[43].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 278
        chassis[43].setRotationPoint(-40F, -12F, 113F);

        chassis[44].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F); // Box 279
        chassis[44].setRotationPoint(-43F, -12F, 113F);

        chassis[45].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F); // Box 280
        chassis[45].setRotationPoint(-36F, -12F, 113F);

        chassis[46].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 281
        chassis[46].setRotationPoint(-43F, -5F, 113F);

        chassis[47].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 282
        chassis[47].setRotationPoint(-36F, -5F, 113F);

        chassis[48].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 283
        chassis[48].setRotationPoint(36F, -4F, -115F);

        chassis[49].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 284
        chassis[49].setRotationPoint(33F, -9F, -115F);

        chassis[50].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 285
        chassis[50].setRotationPoint(41F, -9F, -115F);

        chassis[51].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 286
        chassis[51].setRotationPoint(36F, -12F, -115F);

        chassis[52].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F); // Box 287
        chassis[52].setRotationPoint(33F, -12F, -115F);

        chassis[53].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F); // Box 288
        chassis[53].setRotationPoint(40F, -12F, -115F);

        chassis[54].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 289
        chassis[54].setRotationPoint(33F, -5F, -115F);

        chassis[55].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 290
        chassis[55].setRotationPoint(40F, -5F, -115F);

        chassis[56].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 291
        chassis[56].setRotationPoint(24F, -4F, -115F);

        chassis[57].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 292
        chassis[57].setRotationPoint(21F, -9F, -115F);

        chassis[58].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 293
        chassis[58].setRotationPoint(29F, -9F, -115F);

        chassis[59].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 294
        chassis[59].setRotationPoint(24F, -12F, -115F);

        chassis[60].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F); // Box 295
        chassis[60].setRotationPoint(21F, -12F, -115F);

        chassis[61].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F); // Box 296
        chassis[61].setRotationPoint(28F, -12F, -115F);

        chassis[62].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 297
        chassis[62].setRotationPoint(21F, -5F, -115F);

        chassis[63].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 298
        chassis[63].setRotationPoint(28F, -5F, -115F);

        chassis[64].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 299
        chassis[64].setRotationPoint(-41F, -10F, -114.5F);

        chassis[65].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 300
        chassis[65].setRotationPoint(-41F, -10F, 113.5F);

        chassis[66].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 301
        chassis[66].setRotationPoint(-29F, -10F, -114.5F);

        chassis[67].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 302
        chassis[67].setRotationPoint(23F, -10F, 113.5F);

        chassis[68].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 303
        chassis[68].setRotationPoint(35F, -10F, 113.5F);

        chassis[69].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 304
        chassis[69].setRotationPoint(23F, -10F, -114.5F);

        chassis[70].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 305
        chassis[70].setRotationPoint(35F, -10F, -114.5F);

        chassis[71].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 306
        chassis[71].setRotationPoint(-29F, -10F, 113.5F);

        chassis[72].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 307
        chassis[72].setRotationPoint(-41F, -5F, -114.5F);

        chassis[73].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 308
        chassis[73].setRotationPoint(23F, -5F, -114.5F);

        chassis[74].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 309
        chassis[74].setRotationPoint(35F, -5F, -114.5F);

        chassis[75].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 310
        chassis[75].setRotationPoint(-29F, -5F, -114.5F);

        chassis[76].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 311
        chassis[76].setRotationPoint(-41F, -5F, 113.5F);

        chassis[77].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 312
        chassis[77].setRotationPoint(23F, -5F, 113.5F);

        chassis[78].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 313
        chassis[78].setRotationPoint(35F, -5F, 113.5F);

        chassis[79].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 314
        chassis[79].setRotationPoint(-29F, -5F, 113.5F);

        chassis[80].addShapeBox(0F, 0F, 0F, 6, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 319
        chassis[80].setRotationPoint(-41F, -9F, 113.5F);

        chassis[81].addShapeBox(0F, 0F, 0F, 6, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 320
        chassis[81].setRotationPoint(-41F, -9F, -114.5F);

        chassis[82].addShapeBox(0F, 0F, 0F, 6, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 321
        chassis[82].setRotationPoint(-29F, -9F, 113.5F);

        chassis[83].addShapeBox(0F, 0F, 0F, 6, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 322
        chassis[83].setRotationPoint(-29F, -9F, -114.5F);

        chassis[84].addShapeBox(0F, 0F, 0F, 6, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 323
        chassis[84].setRotationPoint(23F, -9F, -114.5F);

        chassis[85].addShapeBox(0F, 0F, 0F, 6, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 324
        chassis[85].setRotationPoint(23F, -9F, 113.5F);

        chassis[86].addShapeBox(0F, 0F, 0F, 6, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 325
        chassis[86].setRotationPoint(35F, -9F, -114.5F);

        chassis[87].addShapeBox(0F, 0F, 0F, 6, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 326
        chassis[87].setRotationPoint(35F, -9F, 113.5F);

        chassis[88].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 327
        chassis[88].setRotationPoint(36F, -4F, 109F);

        chassis[89].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 328
        chassis[89].setRotationPoint(33F, -9F, 109F);

        chassis[90].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 329
        chassis[90].setRotationPoint(41F, -9F, 109F);

        chassis[91].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 330
        chassis[91].setRotationPoint(36F, -12F, 109F);

        chassis[92].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F); // Box 331
        chassis[92].setRotationPoint(33F, -12F, 109F);

        chassis[93].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F); // Box 332
        chassis[93].setRotationPoint(40F, -12F, 109F);

        chassis[94].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 333
        chassis[94].setRotationPoint(33F, -5F, 109F);

        chassis[95].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 334
        chassis[95].setRotationPoint(40F, -5F, 109F);

        chassis[96].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 335
        chassis[96].setRotationPoint(24F, -4F, 109F);

        chassis[97].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 336
        chassis[97].setRotationPoint(21F, -9F, 109F);

        chassis[98].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 337
        chassis[98].setRotationPoint(29F, -9F, 109F);

        chassis[99].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 338
        chassis[99].setRotationPoint(24F, -12F, 109F);

        chassis[100].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F); // Box 339
        chassis[100].setRotationPoint(21F, -12F, 109F);

        chassis[101].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F); // Box 340
        chassis[101].setRotationPoint(28F, -12F, 109F);

        chassis[102].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 341
        chassis[102].setRotationPoint(21F, -5F, 109F);

        chassis[103].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 342
        chassis[103].setRotationPoint(28F, -5F, 109F);

        chassis[104].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 343
        chassis[104].setRotationPoint(23F, -10F, 109.5F);

        chassis[105].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 344
        chassis[105].setRotationPoint(35F, -10F, 109.5F);

        chassis[106].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 345
        chassis[106].setRotationPoint(23F, -5F, 109.5F);

        chassis[107].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 346
        chassis[107].setRotationPoint(35F, -5F, 109.5F);

        chassis[108].addShapeBox(0F, 0F, 0F, 6, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 347
        chassis[108].setRotationPoint(23F, -9F, 109.5F);

        chassis[109].addShapeBox(0F, 0F, 0F, 6, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 348
        chassis[109].setRotationPoint(35F, -9F, 109.5F);

        chassis[110].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 349
        chassis[110].setRotationPoint(36F, -4F, -111F);

        chassis[111].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 350
        chassis[111].setRotationPoint(33F, -9F, -111F);

        chassis[112].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 351
        chassis[112].setRotationPoint(41F, -9F, -111F);

        chassis[113].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 352
        chassis[113].setRotationPoint(36F, -12F, -111F);

        chassis[114].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F); // Box 353
        chassis[114].setRotationPoint(33F, -12F, -111F);

        chassis[115].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F); // Box 354
        chassis[115].setRotationPoint(40F, -12F, -111F);

        chassis[116].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 355
        chassis[116].setRotationPoint(33F, -5F, -111F);

        chassis[117].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 356
        chassis[117].setRotationPoint(40F, -5F, -111F);

        chassis[118].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 357
        chassis[118].setRotationPoint(24F, -4F, -111F);

        chassis[119].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 358
        chassis[119].setRotationPoint(21F, -9F, -111F);

        chassis[120].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 359
        chassis[120].setRotationPoint(29F, -9F, -111F);

        chassis[121].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 360
        chassis[121].setRotationPoint(24F, -12F, -111F);

        chassis[122].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F); // Box 361
        chassis[122].setRotationPoint(21F, -12F, -111F);

        chassis[123].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F); // Box 362
        chassis[123].setRotationPoint(28F, -12F, -111F);

        chassis[124].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 363
        chassis[124].setRotationPoint(21F, -5F, -111F);

        chassis[125].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 364
        chassis[125].setRotationPoint(28F, -5F, -111F);

        chassis[126].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 365
        chassis[126].setRotationPoint(23F, -10F, -110.5F);

        chassis[127].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 366
        chassis[127].setRotationPoint(35F, -10F, -110.5F);

        chassis[128].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 367
        chassis[128].setRotationPoint(23F, -5F, -110.5F);

        chassis[129].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 368
        chassis[129].setRotationPoint(35F, -5F, -110.5F);

        chassis[130].addShapeBox(0F, 0F, 0F, 6, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 369
        chassis[130].setRotationPoint(23F, -9F, -110.5F);

        chassis[131].addShapeBox(0F, 0F, 0F, 6, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 370
        chassis[131].setRotationPoint(35F, -9F, -110.5F);

        chassis[132].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 371
        chassis[132].setRotationPoint(-28F, -4F, 109F);

        chassis[133].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 372
        chassis[133].setRotationPoint(-31F, -9F, 109F);

        chassis[134].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 373
        chassis[134].setRotationPoint(-23F, -9F, 109F);

        chassis[135].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 374
        chassis[135].setRotationPoint(-28F, -12F, 109F);

        chassis[136].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F); // Box 375
        chassis[136].setRotationPoint(-31F, -12F, 109F);

        chassis[137].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F); // Box 376
        chassis[137].setRotationPoint(-24F, -12F, 109F);

        chassis[138].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 377
        chassis[138].setRotationPoint(-31F, -5F, 109F);

        chassis[139].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 378
        chassis[139].setRotationPoint(-24F, -5F, 109F);

        chassis[140].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 379
        chassis[140].setRotationPoint(-40F, -4F, 109F);

        chassis[141].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 380
        chassis[141].setRotationPoint(-43F, -9F, 109F);

        chassis[142].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 381
        chassis[142].setRotationPoint(-35F, -9F, 109F);

        chassis[143].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 382
        chassis[143].setRotationPoint(-40F, -12F, 109F);

        chassis[144].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F); // Box 383
        chassis[144].setRotationPoint(-43F, -12F, 109F);

        chassis[145].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F); // Box 384
        chassis[145].setRotationPoint(-36F, -12F, 109F);

        chassis[146].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 385
        chassis[146].setRotationPoint(-43F, -5F, 109F);

        chassis[147].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 386
        chassis[147].setRotationPoint(-36F, -5F, 109F);

        chassis[148].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 387
        chassis[148].setRotationPoint(-41F, -10F, 109.5F);

        chassis[149].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 388
        chassis[149].setRotationPoint(-29F, -10F, 109.5F);

        chassis[150].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 389
        chassis[150].setRotationPoint(-41F, -5F, 109.5F);

        chassis[151].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 390
        chassis[151].setRotationPoint(-29F, -5F, 109.5F);

        chassis[152].addShapeBox(0F, 0F, 0F, 6, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 391
        chassis[152].setRotationPoint(-41F, -9F, 109.5F);

        chassis[153].addShapeBox(0F, 0F, 0F, 6, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 392
        chassis[153].setRotationPoint(-29F, -9F, 109.5F);

        chassis[154].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 393
        chassis[154].setRotationPoint(-28F, -4F, -111F);

        chassis[155].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 394
        chassis[155].setRotationPoint(-31F, -9F, -111F);

        chassis[156].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 395
        chassis[156].setRotationPoint(-23F, -9F, -111F);

        chassis[157].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 396
        chassis[157].setRotationPoint(-28F, -12F, -111F);

        chassis[158].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F); // Box 397
        chassis[158].setRotationPoint(-31F, -12F, -111F);

        chassis[159].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F); // Box 398
        chassis[159].setRotationPoint(-24F, -12F, -111F);

        chassis[160].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 399
        chassis[160].setRotationPoint(-31F, -5F, -111F);

        chassis[161].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 400
        chassis[161].setRotationPoint(-24F, -5F, -111F);

        chassis[162].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 401
        chassis[162].setRotationPoint(-40F, -4F, -111F);

        chassis[163].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 402
        chassis[163].setRotationPoint(-43F, -9F, -111F);

        chassis[164].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 403
        chassis[164].setRotationPoint(-35F, -9F, -111F);

        chassis[165].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 404
        chassis[165].setRotationPoint(-40F, -12F, -111F);

        chassis[166].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F); // Box 405
        chassis[166].setRotationPoint(-43F, -12F, -111F);

        chassis[167].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F); // Box 406
        chassis[167].setRotationPoint(-36F, -12F, -111F);

        chassis[168].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 407
        chassis[168].setRotationPoint(-43F, -5F, -111F);

        chassis[169].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 408
        chassis[169].setRotationPoint(-36F, -5F, -111F);

        chassis[170].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 409
        chassis[170].setRotationPoint(-41F, -10F, -110.5F);

        chassis[171].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 410
        chassis[171].setRotationPoint(-29F, -10F, -110.5F);

        chassis[172].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 411
        chassis[172].setRotationPoint(-41F, -5F, -110.5F);

        chassis[173].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 412
        chassis[173].setRotationPoint(-29F, -5F, -110.5F);

        chassis[174].addShapeBox(0F, 0F, 0F, 6, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 413
        chassis[174].setRotationPoint(-41F, -9F, -110.5F);

        chassis[175].addShapeBox(0F, 0F, 0F, 6, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 414
        chassis[175].setRotationPoint(-29F, -9F, -110.5F);

        chassis[176].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 415
        chassis[176].setRotationPoint(48F, -4F, -115F);

        chassis[177].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 416
        chassis[177].setRotationPoint(45F, -9F, -115F);

        chassis[178].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 417
        chassis[178].setRotationPoint(53F, -9F, -115F);

        chassis[179].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 418
        chassis[179].setRotationPoint(48F, -12F, -115F);

        chassis[180].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F); // Box 419
        chassis[180].setRotationPoint(45F, -12F, -115F);

        chassis[181].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F); // Box 420
        chassis[181].setRotationPoint(52F, -12F, -115F);

        chassis[182].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 421
        chassis[182].setRotationPoint(45F, -5F, -115F);

        chassis[183].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 422
        chassis[183].setRotationPoint(52F, -5F, -115F);

        chassis[184].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 423
        chassis[184].setRotationPoint(47F, -10F, -114.5F);

        chassis[185].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 424
        chassis[185].setRotationPoint(47F, -5F, -114.5F);

        chassis[186].addShapeBox(0F, 0F, 0F, 6, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 425
        chassis[186].setRotationPoint(47F, -9F, -114.5F);

        chassis[187].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 426
        chassis[187].setRotationPoint(48F, -4F, -111F);

        chassis[188].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 427
        chassis[188].setRotationPoint(45F, -9F, -111F);

        chassis[189].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 428
        chassis[189].setRotationPoint(53F, -9F, -111F);

        chassis[190].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 429
        chassis[190].setRotationPoint(48F, -12F, -111F);

        chassis[191].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F); // Box 430
        chassis[191].setRotationPoint(45F, -12F, -111F);

        chassis[192].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F); // Box 431
        chassis[192].setRotationPoint(52F, -12F, -111F);

        chassis[193].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 432
        chassis[193].setRotationPoint(45F, -5F, -111F);

        chassis[194].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 433
        chassis[194].setRotationPoint(52F, -5F, -111F);

        chassis[195].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 434
        chassis[195].setRotationPoint(47F, -10F, -110.5F);

        chassis[196].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 435
        chassis[196].setRotationPoint(47F, -5F, -110.5F);

        chassis[197].addShapeBox(0F, 0F, 0F, 6, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 436
        chassis[197].setRotationPoint(47F, -9F, -110.5F);

        chassis[198].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 437
        chassis[198].setRotationPoint(48F, -4F, 113F);

        chassis[199].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 438
        chassis[199].setRotationPoint(45F, -9F, 113F);

        chassis[200].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 439
        chassis[200].setRotationPoint(53F, -9F, 113F);

        chassis[201].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 440
        chassis[201].setRotationPoint(48F, -12F, 113F);

        chassis[202].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F); // Box 441
        chassis[202].setRotationPoint(45F, -12F, 113F);

        chassis[203].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F); // Box 442
        chassis[203].setRotationPoint(52F, -12F, 113F);

        chassis[204].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 443
        chassis[204].setRotationPoint(45F, -5F, 113F);

        chassis[205].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 444
        chassis[205].setRotationPoint(52F, -5F, 113F);

        chassis[206].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 445
        chassis[206].setRotationPoint(47F, -10F, 113.5F);

        chassis[207].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 446
        chassis[207].setRotationPoint(47F, -5F, 113.5F);

        chassis[208].addShapeBox(0F, 0F, 0F, 6, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 447
        chassis[208].setRotationPoint(47F, -9F, 113.5F);

        chassis[209].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 448
        chassis[209].setRotationPoint(48F, -4F, 109F);

        chassis[210].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 449
        chassis[210].setRotationPoint(45F, -9F, 109F);

        chassis[211].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 450
        chassis[211].setRotationPoint(53F, -9F, 109F);

        chassis[212].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 451
        chassis[212].setRotationPoint(48F, -12F, 109F);

        chassis[213].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F); // Box 452
        chassis[213].setRotationPoint(45F, -12F, 109F);

        chassis[214].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F); // Box 453
        chassis[214].setRotationPoint(52F, -12F, 109F);

        chassis[215].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 454
        chassis[215].setRotationPoint(45F, -5F, 109F);

        chassis[216].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 455
        chassis[216].setRotationPoint(52F, -5F, 109F);

        chassis[217].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 456
        chassis[217].setRotationPoint(47F, -10F, 109.5F);

        chassis[218].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 457
        chassis[218].setRotationPoint(47F, -5F, 109.5F);

        chassis[219].addShapeBox(0F, 0F, 0F, 6, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 458
        chassis[219].setRotationPoint(47F, -9F, 109.5F);

        chassis[220].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 459
        chassis[220].setRotationPoint(-52F, -4F, -115F);

        chassis[221].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 460
        chassis[221].setRotationPoint(-55F, -9F, -115F);

        chassis[222].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 461
        chassis[222].setRotationPoint(-47F, -9F, -115F);

        chassis[223].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 462
        chassis[223].setRotationPoint(-52F, -12F, -115F);

        chassis[224].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F); // Box 463
        chassis[224].setRotationPoint(-55F, -12F, -115F);

        chassis[225].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F); // Box 464
        chassis[225].setRotationPoint(-48F, -12F, -115F);

        chassis[226].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 465
        chassis[226].setRotationPoint(-55F, -5F, -115F);

        chassis[227].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 466
        chassis[227].setRotationPoint(-48F, -5F, -115F);

        chassis[228].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 467
        chassis[228].setRotationPoint(-53F, -10F, -114.5F);

        chassis[229].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 468
        chassis[229].setRotationPoint(-53F, -5F, -114.5F);

        chassis[230].addShapeBox(0F, 0F, 0F, 6, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 469
        chassis[230].setRotationPoint(-53F, -9F, -114.5F);

        chassis[231].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 470
        chassis[231].setRotationPoint(-52F, -4F, -111F);

        chassis[232].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 471
        chassis[232].setRotationPoint(-55F, -9F, -111F);

        chassis[233].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 472
        chassis[233].setRotationPoint(-47F, -9F, -111F);

        chassis[234].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 473
        chassis[234].setRotationPoint(-52F, -12F, -111F);

        chassis[235].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F); // Box 474
        chassis[235].setRotationPoint(-55F, -12F, -111F);

        chassis[236].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F); // Box 475
        chassis[236].setRotationPoint(-48F, -12F, -111F);

        chassis[237].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 476
        chassis[237].setRotationPoint(-55F, -5F, -111F);

        chassis[238].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 477
        chassis[238].setRotationPoint(-48F, -5F, -111F);

        chassis[239].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 478
        chassis[239].setRotationPoint(-53F, -10F, -110.5F);

        chassis[240].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 479
        chassis[240].setRotationPoint(-53F, -5F, -110.5F);

        chassis[241].addShapeBox(0F, 0F, 0F, 6, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 480
        chassis[241].setRotationPoint(-53F, -9F, -110.5F);

        chassis[242].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 481
        chassis[242].setRotationPoint(-52F, -4F, 113F);

        chassis[243].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 482
        chassis[243].setRotationPoint(-55F, -9F, 113F);

        chassis[244].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 483
        chassis[244].setRotationPoint(-47F, -9F, 113F);

        chassis[245].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 484
        chassis[245].setRotationPoint(-52F, -12F, 113F);

        chassis[246].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F); // Box 485
        chassis[246].setRotationPoint(-55F, -12F, 113F);

        chassis[247].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F); // Box 486
        chassis[247].setRotationPoint(-48F, -12F, 113F);

        chassis[248].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 487
        chassis[248].setRotationPoint(-55F, -5F, 113F);

        chassis[249].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 488
        chassis[249].setRotationPoint(-48F, -5F, 113F);

        chassis[250].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 489
        chassis[250].setRotationPoint(-53F, -10F, 113.5F);

        chassis[251].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 490
        chassis[251].setRotationPoint(-53F, -5F, 113.5F);

        chassis[252].addShapeBox(0F, 0F, 0F, 6, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 491
        chassis[252].setRotationPoint(-53F, -9F, 113.5F);

        chassis[253].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 492
        chassis[253].setRotationPoint(-52F, -4F, 109F);

        chassis[254].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 493
        chassis[254].setRotationPoint(-55F, -9F, 109F);

        chassis[255].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 494
        chassis[255].setRotationPoint(-47F, -9F, 109F);

        chassis[256].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 495
        chassis[256].setRotationPoint(-52F, -12F, 109F);

        chassis[257].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F); // Box 496
        chassis[257].setRotationPoint(-55F, -12F, 109F);

        chassis[258].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F); // Box 497
        chassis[258].setRotationPoint(-48F, -12F, 109F);

        chassis[259].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 498
        chassis[259].setRotationPoint(-55F, -5F, 109F);

        chassis[260].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 499
        chassis[260].setRotationPoint(-48F, -5F, 109F);

        chassis[261].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 500
        chassis[261].setRotationPoint(-53F, -10F, 109.5F);

        chassis[262].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 501
        chassis[262].setRotationPoint(-53F, -5F, 109.5F);

        chassis[263].addShapeBox(0F, 0F, 0F, 6, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 502
        chassis[263].setRotationPoint(-53F, -9F, 109.5F);

        chassis[264].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 503
        chassis[264].setRotationPoint(-64F, -4F, -115F);

        chassis[265].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 504
        chassis[265].setRotationPoint(-67F, -9F, -115F);

        chassis[266].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 505
        chassis[266].setRotationPoint(-59F, -9F, -115F);

        chassis[267].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 506
        chassis[267].setRotationPoint(-64F, -12F, -115F);

        chassis[268].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F); // Box 507
        chassis[268].setRotationPoint(-67F, -12F, -115F);

        chassis[269].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F); // Box 508
        chassis[269].setRotationPoint(-60F, -12F, -115F);

        chassis[270].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 509
        chassis[270].setRotationPoint(-67F, -5F, -115F);

        chassis[271].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 510
        chassis[271].setRotationPoint(-60F, -5F, -115F);

        chassis[272].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 511
        chassis[272].setRotationPoint(-65F, -10F, -114.5F);

        chassis[273].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 512
        chassis[273].setRotationPoint(-65F, -5F, -114.5F);

        chassis[274].addShapeBox(0F, 0F, 0F, 6, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 513
        chassis[274].setRotationPoint(-65F, -9F, -114.5F);

        chassis[275].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 514
        chassis[275].setRotationPoint(-64F, -4F, -111F);

        chassis[276].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 515
        chassis[276].setRotationPoint(-67F, -9F, -111F);

        chassis[277].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 516
        chassis[277].setRotationPoint(-59F, -9F, -111F);

        chassis[278].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 517
        chassis[278].setRotationPoint(-64F, -12F, -111F);

        chassis[279].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F); // Box 518
        chassis[279].setRotationPoint(-67F, -12F, -111F);

        chassis[280].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F); // Box 519
        chassis[280].setRotationPoint(-60F, -12F, -111F);

        chassis[281].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 520
        chassis[281].setRotationPoint(-67F, -5F, -111F);

        chassis[282].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 521
        chassis[282].setRotationPoint(-60F, -5F, -111F);

        chassis[283].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 522
        chassis[283].setRotationPoint(-65F, -10F, -110.5F);

        chassis[284].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 523
        chassis[284].setRotationPoint(-65F, -5F, -110.5F);

        chassis[285].addShapeBox(0F, 0F, 0F, 6, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 524
        chassis[285].setRotationPoint(-65F, -9F, -110.5F);

        chassis[286].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 525
        chassis[286].setRotationPoint(-64F, -4F, 113F);

        chassis[287].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 526
        chassis[287].setRotationPoint(-67F, -9F, 113F);

        chassis[288].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 527
        chassis[288].setRotationPoint(-59F, -9F, 113F);

        chassis[289].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 528
        chassis[289].setRotationPoint(-64F, -12F, 113F);

        chassis[290].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F); // Box 529
        chassis[290].setRotationPoint(-67F, -12F, 113F);

        chassis[291].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F); // Box 530
        chassis[291].setRotationPoint(-60F, -12F, 113F);

        chassis[292].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 531
        chassis[292].setRotationPoint(-67F, -5F, 113F);

        chassis[293].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 532
        chassis[293].setRotationPoint(-60F, -5F, 113F);

        chassis[294].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 533
        chassis[294].setRotationPoint(-65F, -10F, 113.5F);

        chassis[295].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 534
        chassis[295].setRotationPoint(-65F, -5F, 113.5F);

        chassis[296].addShapeBox(0F, 0F, 0F, 6, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 535
        chassis[296].setRotationPoint(-65F, -9F, 113.5F);

        chassis[297].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 536
        chassis[297].setRotationPoint(-64F, -4F, 109F);

        chassis[298].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 537
        chassis[298].setRotationPoint(-67F, -9F, 109F);

        chassis[299].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 538
        chassis[299].setRotationPoint(-59F, -9F, 109F);

        chassis[300].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 539
        chassis[300].setRotationPoint(-64F, -12F, 109F);

        chassis[301].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F); // Box 540
        chassis[301].setRotationPoint(-67F, -12F, 109F);

        chassis[302].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F); // Box 541
        chassis[302].setRotationPoint(-60F, -12F, 109F);

        chassis[303].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 542
        chassis[303].setRotationPoint(-67F, -5F, 109F);

        chassis[304].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 543
        chassis[304].setRotationPoint(-60F, -5F, 109F);

        chassis[305].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 544
        chassis[305].setRotationPoint(-65F, -10F, 109.5F);

        chassis[306].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 545
        chassis[306].setRotationPoint(-65F, -5F, 109.5F);

        chassis[307].addShapeBox(0F, 0F, 0F, 6, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 546
        chassis[307].setRotationPoint(-65F, -9F, 109.5F);

        chassis[308].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 547
        chassis[308].setRotationPoint(60F, -4F, -115F);

        chassis[309].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 548
        chassis[309].setRotationPoint(57F, -9F, -115F);

        chassis[310].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 549
        chassis[310].setRotationPoint(65F, -9F, -115F);

        chassis[311].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 550
        chassis[311].setRotationPoint(60F, -12F, -115F);

        chassis[312].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F); // Box 551
        chassis[312].setRotationPoint(57F, -12F, -115F);

        chassis[313].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F); // Box 552
        chassis[313].setRotationPoint(64F, -12F, -115F);

        chassis[314].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 553
        chassis[314].setRotationPoint(57F, -5F, -115F);

        chassis[315].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 554
        chassis[315].setRotationPoint(64F, -5F, -115F);

        chassis[316].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 555
        chassis[316].setRotationPoint(59F, -10F, -114.5F);

        chassis[317].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 556
        chassis[317].setRotationPoint(59F, -5F, -114.5F);

        chassis[318].addShapeBox(0F, 0F, 0F, 6, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 557
        chassis[318].setRotationPoint(59F, -9F, -114.5F);

        chassis[319].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 558
        chassis[319].setRotationPoint(60F, -4F, -111F);

        chassis[320].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 559
        chassis[320].setRotationPoint(57F, -9F, -111F);

        chassis[321].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 560
        chassis[321].setRotationPoint(65F, -9F, -111F);

        chassis[322].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 561
        chassis[322].setRotationPoint(60F, -12F, -111F);

        chassis[323].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F); // Box 562
        chassis[323].setRotationPoint(57F, -12F, -111F);

        chassis[324].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F); // Box 563
        chassis[324].setRotationPoint(64F, -12F, -111F);

        chassis[325].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 564
        chassis[325].setRotationPoint(57F, -5F, -111F);

        chassis[326].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 565
        chassis[326].setRotationPoint(64F, -5F, -111F);

        chassis[327].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 566
        chassis[327].setRotationPoint(59F, -10F, -110.5F);

        chassis[328].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 567
        chassis[328].setRotationPoint(59F, -5F, -110.5F);

        chassis[329].addShapeBox(0F, 0F, 0F, 6, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 568
        chassis[329].setRotationPoint(59F, -9F, -110.5F);

        chassis[330].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 569
        chassis[330].setRotationPoint(60F, -4F, 113F);

        chassis[331].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 570
        chassis[331].setRotationPoint(57F, -9F, 113F);

        chassis[332].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 571
        chassis[332].setRotationPoint(65F, -9F, 113F);

        chassis[333].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 572
        chassis[333].setRotationPoint(60F, -12F, 113F);

        chassis[334].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F); // Box 573
        chassis[334].setRotationPoint(57F, -12F, 113F);

        chassis[335].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F); // Box 574
        chassis[335].setRotationPoint(64F, -12F, 113F);

        chassis[336].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 575
        chassis[336].setRotationPoint(57F, -5F, 113F);

        chassis[337].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 576
        chassis[337].setRotationPoint(64F, -5F, 113F);

        chassis[338].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 577
        chassis[338].setRotationPoint(59F, -10F, 113.5F);

        chassis[339].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 578
        chassis[339].setRotationPoint(59F, -5F, 113.5F);

        chassis[340].addShapeBox(0F, 0F, 0F, 6, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 579
        chassis[340].setRotationPoint(59F, -9F, 113.5F);

        chassis[341].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 580
        chassis[341].setRotationPoint(60F, -4F, 109F);

        chassis[342].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 581
        chassis[342].setRotationPoint(57F, -9F, 109F);

        chassis[343].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 582
        chassis[343].setRotationPoint(65F, -9F, 109F);

        chassis[344].addBox(0F, 0F, 0F, 4, 2, 2, 0F); // Box 583
        chassis[344].setRotationPoint(60F, -12F, 109F);

        chassis[345].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F); // Box 584
        chassis[345].setRotationPoint(57F, -12F, 109F);

        chassis[346].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F); // Box 585
        chassis[346].setRotationPoint(64F, -12F, 109F);

        chassis[347].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -2F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 586
        chassis[347].setRotationPoint(57F, -5F, 109F);

        chassis[348].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, -1F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 587
        chassis[348].setRotationPoint(64F, -5F, 109F);

        chassis[349].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 588
        chassis[349].setRotationPoint(59F, -10F, 109.5F);

        chassis[350].addShapeBox(0F, 0F, 0F, 6, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 589
        chassis[350].setRotationPoint(59F, -5F, 109.5F);

        chassis[351].addShapeBox(0F, 0F, 0F, 6, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 590
        chassis[351].setRotationPoint(59F, -9F, 109.5F);

        chassis[352].addShapeBox(0F, 0F, 0F, 2, 2, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 591
        chassis[352].setRotationPoint(61F, -8F, -116F);

        chassis[353].addShapeBox(0F, 0F, 0F, 2, 2, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 592
        chassis[353].setRotationPoint(61F, -8F, 108F);

        chassis[354].addShapeBox(0F, 0F, 0F, 2, 2, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 593
        chassis[354].setRotationPoint(49F, -8F, -116F);

        chassis[355].addShapeBox(0F, 0F, 0F, 2, 2, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 594
        chassis[355].setRotationPoint(49F, -8F, 108F);

        chassis[356].addShapeBox(0F, 0F, 0F, 2, 2, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 595
        chassis[356].setRotationPoint(37F, -8F, 108F);

        chassis[357].addShapeBox(0F, 0F, 0F, 2, 2, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 596
        chassis[357].setRotationPoint(37F, -8F, -116F);

        chassis[358].addShapeBox(0F, 0F, 0F, 2, 2, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 597
        chassis[358].setRotationPoint(25F, -8F, 108F);

        chassis[359].addShapeBox(0F, 0F, 0F, 2, 2, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 598
        chassis[359].setRotationPoint(25F, -8F, -116F);

        chassis[360].addShapeBox(0F, 0F, 0F, 2, 2, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 599
        chassis[360].setRotationPoint(-27F, -8F, -116F);

        chassis[361].addShapeBox(0F, 0F, 0F, 2, 2, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 600
        chassis[361].setRotationPoint(-27F, -8F, 108F);

        chassis[362].addShapeBox(0F, 0F, 0F, 2, 2, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 601
        chassis[362].setRotationPoint(-39F, -8F, -116F);

        chassis[363].addShapeBox(0F, 0F, 0F, 2, 2, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 602
        chassis[363].setRotationPoint(-39F, -8F, 108F);

        chassis[364].addShapeBox(0F, 0F, 0F, 2, 2, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 603
        chassis[364].setRotationPoint(-51F, -8F, 108F);

        chassis[365].addShapeBox(0F, 0F, 0F, 2, 2, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 604
        chassis[365].setRotationPoint(-51F, -8F, -116F);

        chassis[366].addShapeBox(0F, 0F, 0F, 2, 2, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 605
        chassis[366].setRotationPoint(-63F, -8F, 108F);

        chassis[367].addShapeBox(0F, 0F, 0F, 2, 2, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 606
        chassis[367].setRotationPoint(-63F, -8F, -116F);

        chassis[368].addShapeBox(0F, 0F, 0F, 6, 10, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 607
        chassis[368].setRotationPoint(-69F, -14F, 106F);

        chassis[369].addShapeBox(0F, 0F, 0F, 6, 10, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 611
        chassis[369].setRotationPoint(-69F, -14F, -108F);

        chassis[370].addShapeBox(0F, 0F, 0F, 6, 10, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 612
        chassis[370].setRotationPoint(-25F, -14F, -108F);

        chassis[371].addShapeBox(0F, 0F, 0F, 6, 10, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 613
        chassis[371].setRotationPoint(-25F, -14F, 106F);

        chassis[372].addShapeBox(0F, 0F, 0F, 1, 7, 12, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 614
        chassis[372].setRotationPoint(-19F, -14F, 106F);

        chassis[373].addShapeBox(0F, 0F, 0F, 6, 10, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 615
        chassis[373].setRotationPoint(-69F, -14F, -118F);

        chassis[374].addShapeBox(0F, 0F, 0F, 6, 10, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 617
        chassis[374].setRotationPoint(-25F, -14F, -118F);

        chassis[375].addShapeBox(0F, 0F, 0F, 6, 10, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 618
        chassis[375].setRotationPoint(-69F, -14F, 116F);

        chassis[376].addShapeBox(0F, 0F, 0F, 6, 10, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 620
        chassis[376].setRotationPoint(-25F, -14F, 116F);

        chassis[377].addShapeBox(0F, 0F, 0F, 1, 7, 12, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 621
        chassis[377].setRotationPoint(-19F, -14F, -118F);

        chassis[378].addShapeBox(0F, 0F, 0F, 1, 7, 12, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 622
        chassis[378].setRotationPoint(-70F, -14F, -118F);

        chassis[379].addShapeBox(0F, 0F, 0F, 1, 7, 12, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 623
        chassis[379].setRotationPoint(-70F, -14F, 106F);

        chassis[380].addShapeBox(0F, 0F, 0F, 6, 10, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 624
        chassis[380].setRotationPoint(19F, -14F, -108F);

        chassis[381].addShapeBox(0F, 0F, 0F, 6, 10, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 627
        chassis[381].setRotationPoint(19F, -14F, 106F);

        chassis[382].addShapeBox(0F, 0F, 0F, 6, 10, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 628
        chassis[382].setRotationPoint(63F, -14F, 106F);

        chassis[383].addShapeBox(0F, 0F, 0F, 6, 10, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 629
        chassis[383].setRotationPoint(63F, -14F, -108F);

        chassis[384].addShapeBox(0F, 0F, 0F, 1, 7, 12, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 630
        chassis[384].setRotationPoint(69F, -14F, -118F);

        chassis[385].addShapeBox(0F, 0F, 0F, 6, 10, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 631
        chassis[385].setRotationPoint(19F, -14F, 116F);

        chassis[386].addShapeBox(0F, 0F, 0F, 6, 10, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 633
        chassis[386].setRotationPoint(63F, -14F, 116F);

        chassis[387].addShapeBox(0F, 0F, 0F, 6, 10, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F); // Box 634
        chassis[387].setRotationPoint(19F, -14F, -118F);

        chassis[388].addShapeBox(0F, 0F, 0F, 38, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 635
        chassis[388].setRotationPoint(25F, -14F, -118F);

        chassis[389].addShapeBox(0F, 0F, 0F, 6, 10, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F); // Box 636
        chassis[389].setRotationPoint(63F, -14F, -118F);

        chassis[390].addShapeBox(0F, 0F, 0F, 1, 7, 12, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 637
        chassis[390].setRotationPoint(69F, -14F, 106F);

        chassis[391].addShapeBox(0F, 0F, 0F, 1, 7, 12, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 638
        chassis[391].setRotationPoint(18F, -14F, 106F);

        chassis[392].addShapeBox(0F, 0F, 0F, 1, 7, 12, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 639
        chassis[392].setRotationPoint(18F, -14F, -118F);

        chassis[393].addShapeBox(0F, 0F, 0F, 38, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 640
        chassis[393].setRotationPoint(25F, -14F, 116F);

        chassis[394].addShapeBox(0F, 0F, 0F, 38, 5, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 641
        chassis[394].setRotationPoint(25F, -9F, -118F);

        chassis[395].addShapeBox(0F, 0F, 0F, 38, 5, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 642
        chassis[395].setRotationPoint(25F, -9F, 116F);

        chassis[396].addShapeBox(0F, 0F, 0F, 38, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 643
        chassis[396].setRotationPoint(25F, -14F, -108F);

        chassis[397].addShapeBox(0F, 0F, 0F, 38, 5, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 644
        chassis[397].setRotationPoint(25F, -9F, -108F);

        chassis[398].addShapeBox(0F, 0F, 0F, 38, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 645
        chassis[398].setRotationPoint(25F, -14F, 106F);

        chassis[399].addShapeBox(0F, 0F, 0F, 38, 5, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 646
        chassis[399].setRotationPoint(25F, -9F, 106F);

        chassis[400].addShapeBox(0F, 0F, 0F, 38, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 647
        chassis[400].setRotationPoint(-63F, -14F, 116F);

        chassis[401].addShapeBox(0F, 0F, 0F, 38, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 648
        chassis[401].setRotationPoint(-63F, -14F, -118F);

        chassis[402].addShapeBox(0F, 0F, 0F, 38, 5, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 649
        chassis[402].setRotationPoint(-63F, -9F, 116F);

        chassis[403].addShapeBox(0F, 0F, 0F, 38, 5, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 650
        chassis[403].setRotationPoint(-63F, -9F, -118F);

        chassis[404].addShapeBox(0F, 0F, 0F, 38, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 651
        chassis[404].setRotationPoint(-63F, -14F, -108F);

        chassis[405].addShapeBox(0F, 0F, 0F, 38, 5, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 652
        chassis[405].setRotationPoint(-63F, -9F, -108F);

        chassis[406].addShapeBox(0F, 0F, 0F, 38, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 653
        chassis[406].setRotationPoint(-63F, -14F, 106F);

        chassis[407].addShapeBox(0F, 0F, 0F, 38, 5, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 654
        chassis[407].setRotationPoint(-63F, -9F, 106F);

        chassis[408].addShapeBox(0F, 0F, 0F, 52, 8, 2, 0F, -8F, 0F, 0F, -8F, 0F, 0F, -8F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 655
        chassis[408].setRotationPoint(18F, -22F, -118F);

        chassis[409].addShapeBox(0F, 0F, 0F, 52, 8, 2, 0F, -8F, 0F, 0F, -8F, 0F, 0F, -8F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 656
        chassis[409].setRotationPoint(18F, -22F, 116F);

        chassis[410].addShapeBox(0F, 0F, 0F, 52, 8, 2, 0F, -8F, 0F, 0F, -8F, 0F, 0F, -8F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 657
        chassis[410].setRotationPoint(18F, -22F, 106F);

        chassis[411].addShapeBox(0F, 0F, 0F, 52, 8, 2, 0F, -8F, 0F, 0F, -8F, 0F, 0F, -8F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 658
        chassis[411].setRotationPoint(18F, -22F, -108F);

        chassis[412].addShapeBox(0F, 0F, 0F, 52, 8, 2, 0F, -8F, 0F, 0F, -8F, 0F, 0F, -8F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 659
        chassis[412].setRotationPoint(-70F, -22F, 116F);

        chassis[413].addShapeBox(0F, 0F, 0F, 52, 8, 2, 0F, -8F, 0F, 0F, -8F, 0F, 0F, -8F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 660
        chassis[413].setRotationPoint(-70F, -22F, -118F);

        chassis[414].addShapeBox(0F, 0F, 0F, 52, 8, 2, 0F, -8F, 0F, 0F, -8F, 0F, 0F, -8F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 661
        chassis[414].setRotationPoint(-70F, -22F, -108F);

        chassis[415].addShapeBox(0F, 0F, 0F, 52, 8, 2, 0F, -8F, 0F, 0F, -8F, 0F, 0F, -8F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 662
        chassis[415].setRotationPoint(-70F, -22F, 106F);

        chassis[416].addShapeBox(0F, 0F, 0F, 9, 8, 8, 0F, -8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F, -8F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F); // Box 663
        chassis[416].setRotationPoint(-70F, -22F, -116F);

        chassis[417].addShapeBox(0F, 0F, 0F, 9, 8, 8, 0F, -8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F, -8F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F); // Box 669
        chassis[417].setRotationPoint(-70F, -22F, 108F);

        chassis[418].addShapeBox(0F, 0F, 0F, 9, 8, 8, 0F, 0F, 0F, 0F, -8F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -8F, 0F, 0F); // Box 670
        chassis[418].setRotationPoint(-27F, -22F, 108F);

        chassis[419].addShapeBox(0F, 0F, 0F, 9, 8, 8, 0F, 0F, 0F, 0F, -8F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -8F, 0F, 0F); // Box 671
        chassis[419].setRotationPoint(-27F, -22F, -116F);

        chassis[420].addShapeBox(0F, 0F, 0F, 9, 8, 8, 0F, -8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F, -8F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F); // Box 672
        chassis[420].setRotationPoint(18F, -22F, 108F);

        chassis[421].addShapeBox(0F, 0F, 0F, 9, 8, 8, 0F, -8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F, -8F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F); // Box 673
        chassis[421].setRotationPoint(18F, -22F, -116F);

        chassis[422].addShapeBox(0F, 0F, 0F, 9, 8, 8, 0F, 0F, 0F, 0F, -8F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -8F, 0F, 0F); // Box 674
        chassis[422].setRotationPoint(61F, -22F, -116F);

        chassis[423].addShapeBox(0F, 0F, 0F, 9, 8, 8, 0F, 0F, 0F, 0F, -8F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -8F, 0F, 0F); // Box 675
        chassis[423].setRotationPoint(61F, -22F, 108F);

        chassis[424].addShapeBox(0F, 0F, 0F, 36, 1, 12, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 676
        chassis[424].setRotationPoint(-62F, -23F, -118F);

        chassis[425].addShapeBox(0F, 0F, 0F, 36, 1, 12, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 677
        chassis[425].setRotationPoint(-62F, -23F, 106F);

        chassis[426].addShapeBox(0F, 0F, 0F, 36, 1, 12, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 678
        chassis[426].setRotationPoint(26F, -23F, 106F);

        chassis[427].addShapeBox(0F, 0F, 0F, 36, 1, 12, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 679
        chassis[427].setRotationPoint(26F, -23F, -118F);

        chassis[428].addShapeBox(0F, 0F, 0F, 6, 140, 2, 0F, 8F, 0F, 6F, -8F, 0F, 6F, -8F, 0F, -6F, 8F, 0F, -6F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 724
        chassis[428].setRotationPoint(41F, -163F, 106F);

        chassis[429].addShapeBox(0F, 0F, 0F, 2, 140, 6, 0F, 8F, 0F, 6F, -8F, 0F, 6F, -8F, 0F, -6F, 8F, 0F, -6F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 726
        chassis[429].setRotationPoint(48F, -163F, 109F);

        chassis[430].addShapeBox(0F, 0F, 0F, 2, 140, 6, 0F, 8F, 0F, 6F, -8F, 0F, 6F, -8F, 0F, -6F, 8F, 0F, -6F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 727
        chassis[430].setRotationPoint(38F, -163F, 109F);

        chassis[431].addShapeBox(0F, 0F, 0F, 3, 140, 3, 0F, 8F, 0F, 3F, -8F, 0F, 6F, -8F, 0F, -7F, 6F, 0F, -6F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, -1F, -2F, 0F, 0F); // Box 730
        chassis[431].setRotationPoint(38F, -163F, 106F);

        chassis[432].addShapeBox(0F, 0F, 0F, 3, 140, 3, 0F, 8F, 0F, 6F, -8F, 0F, 3F, -10F, 0F, -6F, 8F, 0F, -7F, 0F, 0F, 0F, 0F, 0F, -3F, -2F, 0F, 0F, 0F, 0F, -1F); // Box 731
        chassis[432].setRotationPoint(47F, -163F, 106F);

        chassis[433].addShapeBox(0F, 0F, 0F, 6, 140, 2, 0F, 8F, 0F, 6F, -8F, 0F, 6F, -8F, 0F, -6F, 8F, 0F, -6F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 748
        chassis[433].setRotationPoint(41F, -163F, 116F);

        chassis[434].addShapeBox(0F, 0F, 0F, 3, 140, 3, 0F, 0F, 0F, -1F, -2F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, -8F, 0F, -7F, 6F, 0F, -6F, 8F, 0F, 3F, -8F, 0F, 6F); // Box 749
        chassis[434].setRotationPoint(39F, -163F, 109F);

        chassis[435].addShapeBox(0F, 0F, 0F, 3, 140, 3, 0F, -2F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -3F, -10F, 0F, -6F, 8F, 0F, -7F, 8F, 0F, 6F, -8F, 0F, 3F); // Box 750
        chassis[435].setRotationPoint(30F, -163F, 109F);

        chassis[436].addShapeBox(0F, 0F, 0F, 6, 140, 2, 0F, 8F, 0F, -6F, -8F, 0F, -6F, -8F, 0F, 6F, 8F, 0F, 6F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 751
        chassis[436].setRotationPoint(41F, -163F, -108F);

        chassis[437].addShapeBox(0F, 0F, 0F, 2, 140, 6, 0F, 8F, 0F, -6F, -8F, 0F, -6F, -8F, 0F, 6F, 8F, 0F, 6F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 752
        chassis[437].setRotationPoint(48F, -163F, -115F);

        chassis[438].addShapeBox(0F, 0F, 0F, 2, 140, 6, 0F, 8F, 0F, -6F, -8F, 0F, -6F, -8F, 0F, 6F, 8F, 0F, 6F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 753
        chassis[438].setRotationPoint(38F, -163F, -115F);

        chassis[439].addShapeBox(0F, 0F, 0F, 3, 140, 3, 0F, 6F, 0F, -6F, -8F, 0F, -7F, -8F, 0F, 6F, 8F, 0F, 3F, -2F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -3F); // Box 754
        chassis[439].setRotationPoint(38F, -163F, -109F);

        chassis[440].addShapeBox(0F, 0F, 0F, 3, 140, 3, 0F, 8F, 0F, -7F, -10F, 0F, -6F, -8F, 0F, 3F, 8F, 0F, 6F, 0F, 0F, -1F, -2F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F); // Box 755
        chassis[440].setRotationPoint(47F, -163F, -109F);

        chassis[441].addShapeBox(0F, 0F, 0F, 6, 140, 2, 0F, 8F, 0F, -6F, -8F, 0F, -6F, -8F, 0F, 6F, 8F, 0F, 6F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 756
        chassis[441].setRotationPoint(41F, -163F, -118F);

        chassis[442].addShapeBox(0F, 0F, 0F, 3, 140, 3, 0F, 0F, 0F, 0F, 0F, 0F, -3F, -2F, 0F, 0F, 0F, 0F, -1F, -8F, 0F, 6F, 8F, 0F, 3F, 6F, 0F, -6F, -8F, 0F, -7F); // Box 757
        chassis[442].setRotationPoint(39F, -163F, -112F);

        chassis[443].addShapeBox(0F, 0F, 0F, 3, 140, 3, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, -1F, -2F, 0F, 0F, -8F, 0F, 3F, 8F, 0F, 6F, 8F, 0F, -7F, -10F, 0F, -6F); // Box 758
        chassis[443].setRotationPoint(30F, -163F, -112F);

        chassis[444].addShapeBox(0F, 0F, 0F, 6, 140, 2, 0F, -8F, 0F, -6F, 8F, 0F, -6F, 8F, 0F, 6F, -8F, 0F, 6F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 759
        chassis[444].setRotationPoint(-47F, -163F, -108F);

        chassis[445].addShapeBox(0F, 0F, 0F, 2, 140, 6, 0F, -8F, 0F, -6F, 8F, 0F, -6F, 8F, 0F, 6F, -8F, 0F, 6F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 760
        chassis[445].setRotationPoint(-50F, -163F, -115F);

        chassis[446].addShapeBox(0F, 0F, 0F, 2, 140, 6, 0F, -8F, 0F, -6F, 8F, 0F, -6F, 8F, 0F, 6F, -8F, 0F, 6F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 761
        chassis[446].setRotationPoint(-40F, -163F, -115F);

        chassis[447].addShapeBox(0F, 0F, 0F, 3, 140, 3, 0F, -8F, 0F, -7F, 6F, 0F, -6F, 8F, 0F, 3F, -8F, 0F, 6F, 0F, 0F, -1F, -2F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F); // Box 762
        chassis[447].setRotationPoint(-41F, -163F, -109F);

        chassis[448].addShapeBox(0F, 0F, 0F, 3, 140, 3, 0F, -10F, 0F, -6F, 8F, 0F, -7F, 8F, 0F, 6F, -8F, 0F, 3F, -2F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -3F); // Box 763
        chassis[448].setRotationPoint(-50F, -163F, -109F);

        chassis[449].addShapeBox(0F, 0F, 0F, 6, 140, 2, 0F, -8F, 0F, -6F, 8F, 0F, -6F, 8F, 0F, 6F, -8F, 0F, 6F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 764
        chassis[449].setRotationPoint(-47F, -163F, -118F);

        chassis[450].addShapeBox(0F, 0F, 0F, 3, 140, 3, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, -1F, -2F, 0F, 0F, 8F, 0F, 3F, -8F, 0F, 6F, -8F, 0F, -7F, 6F, 0F, -6F); // Box 765
        chassis[450].setRotationPoint(-42F, -163F, -112F);

        chassis[451].addShapeBox(0F, 0F, 0F, 3, 140, 3, 0F, 0F, 0F, 0F, 0F, 0F, -3F, -2F, 0F, 0F, 0F, 0F, -1F, 8F, 0F, 6F, -8F, 0F, 3F, -10F, 0F, -6F, 8F, 0F, -7F); // Box 766
        chassis[451].setRotationPoint(-33F, -163F, -112F);

        chassis[452].addShapeBox(0F, 0F, 0F, 6, 140, 2, 0F, -8F, 0F, 6F, 8F, 0F, 6F, 8F, 0F, -6F, -8F, 0F, -6F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 767
        chassis[452].setRotationPoint(-47F, -163F, 106F);

        chassis[453].addShapeBox(0F, 0F, 0F, 2, 140, 6, 0F, -8F, 0F, 6F, 8F, 0F, 6F, 8F, 0F, -6F, -8F, 0F, -6F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 768
        chassis[453].setRotationPoint(-50F, -163F, 109F);

        chassis[454].addShapeBox(0F, 0F, 0F, 2, 140, 6, 0F, -8F, 0F, 6F, 8F, 0F, 6F, 8F, 0F, -6F, -8F, 0F, -6F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 769
        chassis[454].setRotationPoint(-40F, -163F, 109F);

        chassis[455].addShapeBox(0F, 0F, 0F, 3, 140, 3, 0F, -8F, 0F, 6F, 8F, 0F, 3F, 6F, 0F, -6F, -8F, 0F, -7F, 0F, 0F, 0F, 0F, 0F, -3F, -2F, 0F, 0F, 0F, 0F, -1F); // Box 770
        chassis[455].setRotationPoint(-41F, -163F, 106F);

        chassis[456].addShapeBox(0F, 0F, 0F, 3, 140, 3, 0F, -8F, 0F, 3F, 8F, 0F, 6F, 8F, 0F, -7F, -10F, 0F, -6F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, -1F, -2F, 0F, 0F); // Box 771
        chassis[456].setRotationPoint(-50F, -163F, 106F);

        chassis[457].addShapeBox(0F, 0F, 0F, 6, 140, 2, 0F, -8F, 0F, 6F, 8F, 0F, 6F, 8F, 0F, -6F, -8F, 0F, -6F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 772
        chassis[457].setRotationPoint(-47F, -163F, 116F);

        chassis[458].addShapeBox(0F, 0F, 0F, 3, 140, 3, 0F, -2F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -3F, 6F, 0F, -6F, -8F, 0F, -7F, -8F, 0F, 6F, 8F, 0F, 3F); // Box 773
        chassis[458].setRotationPoint(-42F, -163F, 109F);

        chassis[459].addShapeBox(0F, 0F, 0F, 3, 140, 3, 0F, 0F, 0F, -1F, -2F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 8F, 0F, -7F, -10F, 0F, -6F, -8F, 0F, 3F, 8F, 0F, 6F); // Box 774
        chassis[459].setRotationPoint(-33F, -163F, 109F);

        chassis[460].addShapeBox(0F, 0F, 0F, 76, 8, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 775
        chassis[460].setRotationPoint(-38F, -56F, 108F);

        chassis[461].addShapeBox(0F, 0F, 0F, 76, 8, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 776
        chassis[461].setRotationPoint(-38F, -56F, -114F);

        chassis[462].addShapeBox(0F, 0F, 0F, 76, 8, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 777
        chassis[462].setRotationPoint(-38F, -129F, 104F);

        chassis[463].addShapeBox(0F, 0F, 0F, 76, 8, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 778
        chassis[463].setRotationPoint(-38F, -129F, -110F);

        chassis[464].addShapeBox(0F, 0F, 0F, 70, 65, 10, 0F, 0F, 0F, 0F, -62F, 0F, 0F, -62F, 0F, -4F, 0F, 0F, -4F, -62F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, -62F, 0F, 0F); // Box 779
        chassis[464].setRotationPoint(-35F, -121F, 104F);

        chassis[465].addShapeBox(0F, 0F, 0F, 70, 65, 10, 0F, 0F, 0F, -4F, -62F, 0F, -4F, -62F, 0F, 0F, 0F, 0F, 0F, -62F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, -62F, 0F, -4F); // Box 780
        chassis[465].setRotationPoint(-35F, -121F, -114F);

        chassis[466].addShapeBox(0F, 0F, 0F, 70, 65, 10, 0F, -62F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, -62F, 0F, 0F, 0F, 0F, 0F, -62F, 0F, 0F, -62F, 0F, -4F, 0F, 0F, -4F); // Box 781
        chassis[466].setRotationPoint(-35F, -121F, -114F);

        chassis[467].addShapeBox(0F, 0F, 0F, 70, 65, 10, 0F, -62F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, -62F, 0F, -4F, 0F, 0F, -4F, -62F, 0F, -4F, -62F, 0F, 0F, 0F, 0F, 0F); // Box 782
        chassis[467].setRotationPoint(-35F, -121F, 104F);

        chassis[468].addShapeBox(0F, 0F, 0F, 12, 4, 228, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 579
        chassis[468].setRotationPoint(30F, -167F, -114F);

        chassis[469].addShapeBox(0F, 0F, 0F, 12, 4, 228, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 580
        chassis[469].setRotationPoint(-42F, -167F, -114F);

        chassis[470].addShapeBox(0F, 0F, 0F, 12, 4, 228, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 581
        chassis[470].setRotationPoint(-42F, -179F, -114F);

        chassis[471].addShapeBox(0F, 0F, 0F, 12, 4, 228, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 582
        chassis[471].setRotationPoint(30F, -179F, -114F);

        chassis[472].addShapeBox(0F, 0F, 0F, 4, 8, 228, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 583
        chassis[472].setRotationPoint(34F, -175F, -114F);

        chassis[473].addShapeBox(0F, 0F, 0F, 4, 8, 228, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 584
        chassis[473].setRotationPoint(-38F, -175F, -114F);

        chassis[474].addShapeBox(0F, 0F, 0F, 4, 8, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 585
        chassis[474].setRotationPoint(-42F, -175F, -103F);

        chassis[475].addShapeBox(0F, 0F, 0F, 4, 8, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 586
        chassis[475].setRotationPoint(-42F, -175F, 99F);

        chassis[476].addShapeBox(0F, 0F, 0F, 4, 8, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 587
        chassis[476].setRotationPoint(-42F, -175F, -114F);

        chassis[477].addShapeBox(0F, 0F, 0F, 4, 8, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 588
        chassis[477].setRotationPoint(-42F, -175F, 110F);

        chassis[478].addShapeBox(0F, 0F, 0F, 4, 8, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 589
        chassis[478].setRotationPoint(-34F, -175F, -103F);

        chassis[479].addShapeBox(0F, 0F, 0F, 4, 8, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 590
        chassis[479].setRotationPoint(-34F, -175F, -114F);

        chassis[480].addShapeBox(0F, 0F, 0F, 4, 8, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 591
        chassis[480].setRotationPoint(-34F, -175F, 99F);

        chassis[481].addShapeBox(0F, 0F, 0F, 4, 8, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 592
        chassis[481].setRotationPoint(-34F, -175F, 110F);

        chassis[482].addShapeBox(0F, 0F, 0F, 4, 8, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 593
        chassis[482].setRotationPoint(30F, -175F, -103F);

        chassis[483].addShapeBox(0F, 0F, 0F, 4, 8, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 594
        chassis[483].setRotationPoint(30F, -175F, -114F);

        chassis[484].addShapeBox(0F, 0F, 0F, 4, 8, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 595
        chassis[484].setRotationPoint(38F, -175F, -103F);

        chassis[485].addShapeBox(0F, 0F, 0F, 4, 8, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 596
        chassis[485].setRotationPoint(38F, -175F, -114F);

        chassis[486].addShapeBox(0F, 0F, 0F, 4, 8, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 597
        chassis[486].setRotationPoint(30F, -175F, 99F);

        chassis[487].addShapeBox(0F, 0F, 0F, 4, 8, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 598
        chassis[487].setRotationPoint(30F, -175F, 110F);

        chassis[488].addShapeBox(0F, 0F, 0F, 4, 8, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 599
        chassis[488].setRotationPoint(38F, -175F, 99F);

        chassis[489].addShapeBox(0F, 0F, 0F, 4, 8, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 600
        chassis[489].setRotationPoint(38F, -175F, 110F);

        chassis[490].addShapeBox(0F, 0F, 0F, 68, 8, 7, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 601
        chassis[490].setRotationPoint(-34F, -175F, -110F);

        chassis[491].addShapeBox(0F, 0F, 0F, 68, 8, 7, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 602
        chassis[491].setRotationPoint(-34F, -175F, 103F);

        chassis[492].addShapeBox(0F, 0F, 0F, 1, 1, 198, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 603
        chassis[492].setRotationPoint(40F, -168F, -99F);

        chassis[493].addShapeBox(0F, 0F, 0F, 1, 1, 198, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 604
        chassis[493].setRotationPoint(31F, -168F, -99F);

        chassis[494].addShapeBox(0F, 0F, 0F, 1, 1, 198, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 605
        chassis[494].setRotationPoint(-32F, -168F, -99F);

        chassis[495].addShapeBox(0F, 0F, 0F, 1, 1, 198, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 606
        chassis[495].setRotationPoint(-41F, -168F, -99F);

        chassis[496].addShapeBox(0F, 0F, 0F, 1, 1, 198, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 620
        chassis[496].setRotationPoint(-34F, -168F, -99F);

        chassis[497].addShapeBox(0F, 0F, 0F, 1, 1, 198, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 621
        chassis[497].setRotationPoint(-39F, -168F, -99F);

        chassis[498].addShapeBox(0F, 0F, 0F, 1, 1, 198, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 622
        chassis[498].setRotationPoint(38F, -168F, -99F);

        chassis[499].addShapeBox(0F, 0F, 0F, 1, 1, 198, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 623
        chassis[499].setRotationPoint(33F, -168F, -99F);

        chassis[500].addShapeBox(0F, 0F, 0F, 2, 2, 8, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F); // Box 853
        chassis[500].setRotationPoint(-44F, -172F, 8F);

        chassis[501].addShapeBox(0F, 0F, 0F, 2, 2, 8, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F); // Box 855
        chassis[501].setRotationPoint(-44F, -172F, 20F);
        this.add("chassis", chassis); this.chassis = this.get("chassis");
    }

    public ContainerCrane(){
    	super(); textureX = 1024; textureY = 1024;
        this.addToCreators("Ferdinand (FEX___96)");
        this.addToCreators("GolddolphinSKB");
        this.initChassis();
        ModelRendererTurbo[] body = new ModelRendererTurbo[396];
        body[0] = new ModelRendererTurbo(this, 617, 1, textureX, textureY); // Box 633
        body[1] = new ModelRendererTurbo(this, 657, 1, textureX, textureY); // Box 634
        body[2] = new ModelRendererTurbo(this, 961, 33, textureX, textureY); // Box 635
        body[3] = new ModelRendererTurbo(this, 313, 81, textureX, textureY); // Box 636
        body[4] = new ModelRendererTurbo(this, 337, 81, textureX, textureY); // Box 637
        body[5] = new ModelRendererTurbo(this, 361, 81, textureX, textureY); // Box 638
        body[6] = new ModelRendererTurbo(this, 601, 1, textureX, textureY); // Box 639
        body[7] = new ModelRendererTurbo(this, 641, 1, textureX, textureY); // Box 640
        body[8] = new ModelRendererTurbo(this, 681, 1, textureX, textureY); // Box 641
        body[9] = new ModelRendererTurbo(this, 697, 1, textureX, textureY); // Box 642
        body[10] = new ModelRendererTurbo(this, 977, 17, textureX, textureY); // Box 663
        body[11] = new ModelRendererTurbo(this, 737, 33, textureX, textureY); // Box 664
        body[12] = new ModelRendererTurbo(this, 385, 81, textureX, textureY); // Box 665
        body[13] = new ModelRendererTurbo(this, 409, 81, textureX, textureY); // Box 666
        body[14] = new ModelRendererTurbo(this, 433, 81, textureX, textureY); // Box 667
        body[15] = new ModelRendererTurbo(this, 457, 81, textureX, textureY); // Box 668
        body[16] = new ModelRendererTurbo(this, 721, 1, textureX, textureY); // Box 669
        body[17] = new ModelRendererTurbo(this, 881, 25, textureX, textureY); // Box 670
        body[18] = new ModelRendererTurbo(this, 953, 25, textureX, textureY); // Box 671
        body[19] = new ModelRendererTurbo(this, 977, 25, textureX, textureY); // Box 672
        body[20] = new ModelRendererTurbo(this, 177, 57, textureX, textureY); // Box 673
        body[21] = new ModelRendererTurbo(this, 1017, 57, textureX, textureY); // Box 674
        body[22] = new ModelRendererTurbo(this, 481, 81, textureX, textureY); // Box 675
        body[23] = new ModelRendererTurbo(this, 505, 81, textureX, textureY); // Box 676
        body[24] = new ModelRendererTurbo(this, 529, 81, textureX, textureY); // Box 677
        body[25] = new ModelRendererTurbo(this, 553, 81, textureX, textureY); // Box 678
        body[26] = new ModelRendererTurbo(this, 321, 81, textureX, textureY); // Box 679
        body[27] = new ModelRendererTurbo(this, 345, 81, textureX, textureY); // Box 680
        body[28] = new ModelRendererTurbo(this, 369, 81, textureX, textureY); // Box 681
        body[29] = new ModelRendererTurbo(this, 393, 81, textureX, textureY); // Box 682
        body[30] = new ModelRendererTurbo(this, 577, 81, textureX, textureY); // Box 683
        body[31] = new ModelRendererTurbo(this, 585, 81, textureX, textureY); // Box 684
        body[32] = new ModelRendererTurbo(this, 601, 81, textureX, textureY); // Box 685
        body[33] = new ModelRendererTurbo(this, 625, 81, textureX, textureY); // Box 686
        body[34] = new ModelRendererTurbo(this, 649, 81, textureX, textureY); // Box 687
        body[35] = new ModelRendererTurbo(this, 801, 81, textureX, textureY); // Box 688
        body[36] = new ModelRendererTurbo(this, 417, 81, textureX, textureY); // Box 689
        body[37] = new ModelRendererTurbo(this, 441, 81, textureX, textureY); // Box 690
        body[38] = new ModelRendererTurbo(this, 465, 81, textureX, textureY); // Box 691
        body[39] = new ModelRendererTurbo(this, 489, 81, textureX, textureY); // Box 692
        body[40] = new ModelRendererTurbo(this, 673, 81, textureX, textureY); // Box 693
        body[41] = new ModelRendererTurbo(this, 1, 89, textureX, textureY); // Box 694
        body[42] = new ModelRendererTurbo(this, 129, 89, textureX, textureY); // Box 695
        body[43] = new ModelRendererTurbo(this, 225, 89, textureX, textureY); // Box 696
        body[44] = new ModelRendererTurbo(this, 241, 89, textureX, textureY); // Box 697
        body[45] = new ModelRendererTurbo(this, 257, 89, textureX, textureY); // Box 698
        body[46] = new ModelRendererTurbo(this, 513, 81, textureX, textureY); // Box 699
        body[47] = new ModelRendererTurbo(this, 537, 81, textureX, textureY); // Box 700
        body[48] = new ModelRendererTurbo(this, 561, 81, textureX, textureY); // Box 701
        body[49] = new ModelRendererTurbo(this, 609, 81, textureX, textureY); // Box 702
        body[50] = new ModelRendererTurbo(this, 273, 89, textureX, textureY); // Box 703
        body[51] = new ModelRendererTurbo(this, 281, 89, textureX, textureY); // Box 704
        body[52] = new ModelRendererTurbo(this, 289, 89, textureX, textureY); // Box 705
        body[53] = new ModelRendererTurbo(this, 129, 97, textureX, textureY); // Box 706
        body[54] = new ModelRendererTurbo(this, 777, 97, textureX, textureY); // Box 707
        body[55] = new ModelRendererTurbo(this, 793, 97, textureX, textureY); // Box 708
        body[56] = new ModelRendererTurbo(this, 633, 81, textureX, textureY); // Box 709
        body[57] = new ModelRendererTurbo(this, 657, 81, textureX, textureY); // Box 710
        body[58] = new ModelRendererTurbo(this, 817, 81, textureX, textureY); // Box 711
        body[59] = new ModelRendererTurbo(this, 833, 81, textureX, textureY); // Box 712
        body[60] = new ModelRendererTurbo(this, 1009, 97, textureX, textureY); // Box 713
        body[61] = new ModelRendererTurbo(this, 1017, 97, textureX, textureY); // Box 714
        body[62] = new ModelRendererTurbo(this, 25, 105, textureX, textureY); // Box 715
        body[63] = new ModelRendererTurbo(this, 241, 105, textureX, textureY); // Box 716
        body[64] = new ModelRendererTurbo(this, 257, 105, textureX, textureY); // Box 717
        body[65] = new ModelRendererTurbo(this, 273, 105, textureX, textureY); // Box 718
        body[66] = new ModelRendererTurbo(this, 841, 81, textureX, textureY); // Box 719
        body[67] = new ModelRendererTurbo(this, 993, 81, textureX, textureY); // Box 720
        body[68] = new ModelRendererTurbo(this, 1009, 81, textureX, textureY); // Box 721
        body[69] = new ModelRendererTurbo(this, 1017, 81, textureX, textureY); // Box 722
        body[70] = new ModelRendererTurbo(this, 289, 105, textureX, textureY); // Box 723
        body[71] = new ModelRendererTurbo(this, 297, 105, textureX, textureY); // Box 724
        body[72] = new ModelRendererTurbo(this, 1009, 105, textureX, textureY); // Box 725
        body[73] = new ModelRendererTurbo(this, 817, 113, textureX, textureY); // Box 726
        body[74] = new ModelRendererTurbo(this, 857, 113, textureX, textureY); // Box 727
        body[75] = new ModelRendererTurbo(this, 897, 121, textureX, textureY); // Box 728
        body[76] = new ModelRendererTurbo(this, 17, 89, textureX, textureY); // Box 729
        body[77] = new ModelRendererTurbo(this, 33, 89, textureX, textureY); // Box 730
        body[78] = new ModelRendererTurbo(this, 49, 89, textureX, textureY); // Box 731
        body[79] = new ModelRendererTurbo(this, 65, 89, textureX, textureY); // Box 732
        body[80] = new ModelRendererTurbo(this, 305, 105, textureX, textureY); // Box 733
        body[81] = new ModelRendererTurbo(this, 977, 105, textureX, textureY); // Box 734
        body[82] = new ModelRendererTurbo(this, 937, 121, textureX, textureY); // Box 735
        body[83] = new ModelRendererTurbo(this, 33, 129, textureX, textureY); // Box 736
        body[84] = new ModelRendererTurbo(this, 73, 129, textureX, textureY); // Box 737
        body[85] = new ModelRendererTurbo(this, 169, 129, textureX, textureY); // Box 738
        body[86] = new ModelRendererTurbo(this, 73, 89, textureX, textureY); // Box 739
        body[87] = new ModelRendererTurbo(this, 137, 89, textureX, textureY); // Box 740
        body[88] = new ModelRendererTurbo(this, 145, 89, textureX, textureY); // Box 741
        body[89] = new ModelRendererTurbo(this, 161, 89, textureX, textureY); // Box 742
        body[90] = new ModelRendererTurbo(this, 785, 113, textureX, textureY); // Box 743
        body[91] = new ModelRendererTurbo(this, 1017, 113, textureX, textureY); // Box 744
        body[92] = new ModelRendererTurbo(this, 185, 129, textureX, textureY); // Box 745
        body[93] = new ModelRendererTurbo(this, 273, 129, textureX, textureY); // Box 746
        body[94] = new ModelRendererTurbo(this, 289, 129, textureX, textureY); // Box 747
        body[95] = new ModelRendererTurbo(this, 377, 129, textureX, textureY); // Box 748
        body[96] = new ModelRendererTurbo(this, 169, 89, textureX, textureY); // Box 749
        body[97] = new ModelRendererTurbo(this, 233, 89, textureX, textureY); // Box 750
        body[98] = new ModelRendererTurbo(this, 249, 89, textureX, textureY); // Box 751
        body[99] = new ModelRendererTurbo(this, 265, 89, textureX, textureY); // Box 752
        body[100] = new ModelRendererTurbo(this, 865, 121, textureX, textureY); // Box 753
        body[101] = new ModelRendererTurbo(this, 1, 129, textureX, textureY); // Box 754
        body[102] = new ModelRendererTurbo(this, 393, 129, textureX, textureY); // Box 755
        body[103] = new ModelRendererTurbo(this, 481, 129, textureX, textureY); // Box 756
        body[104] = new ModelRendererTurbo(this, 537, 129, textureX, textureY); // Box 757
        body[105] = new ModelRendererTurbo(this, 681, 129, textureX, textureY); // Box 758
        body[106] = new ModelRendererTurbo(this, 801, 89, textureX, textureY); // Box 759
        body[107] = new ModelRendererTurbo(this, 1, 97, textureX, textureY); // Box 760
        body[108] = new ModelRendererTurbo(this, 137, 97, textureX, textureY); // Box 761
        body[109] = new ModelRendererTurbo(this, 785, 97, textureX, textureY); // Box 762
        body[110] = new ModelRendererTurbo(this, 561, 129, textureX, textureY); // Box 763
        body[111] = new ModelRendererTurbo(this, 705, 129, textureX, textureY); // Box 764
        body[112] = new ModelRendererTurbo(this, 817, 129, textureX, textureY); // Box 765
        body[113] = new ModelRendererTurbo(this, 825, 137, textureX, textureY); // Box 766
        body[114] = new ModelRendererTurbo(this, 849, 137, textureX, textureY); // Box 767
        body[115] = new ModelRendererTurbo(this, 897, 137, textureX, textureY); // Box 768
        body[116] = new ModelRendererTurbo(this, 249, 105, textureX, textureY); // Box 769
        body[117] = new ModelRendererTurbo(this, 265, 105, textureX, textureY); // Box 770
        body[118] = new ModelRendererTurbo(this, 281, 105, textureX, textureY); // Box 771
        body[119] = new ModelRendererTurbo(this, 1017, 105, textureX, textureY); // Box 772
        body[120] = new ModelRendererTurbo(this, 1001, 129, textureX, textureY); // Box 773
        body[121] = new ModelRendererTurbo(this, 1001, 137, textureX, textureY); // Box 774
        body[122] = new ModelRendererTurbo(this, 937, 137, textureX, textureY); // Box 775
        body[123] = new ModelRendererTurbo(this, 33, 145, textureX, textureY); // Box 776
        body[124] = new ModelRendererTurbo(this, 201, 145, textureX, textureY); // Box 777
        body[125] = new ModelRendererTurbo(this, 481, 145, textureX, textureY); // Box 778
        body[126] = new ModelRendererTurbo(this, 825, 113, textureX, textureY); // Box 779
        body[127] = new ModelRendererTurbo(this, 905, 121, textureX, textureY); // Box 780
        body[128] = new ModelRendererTurbo(this, 945, 121, textureX, textureY); // Box 781
        body[129] = new ModelRendererTurbo(this, 41, 129, textureX, textureY); // Box 782
        body[130] = new ModelRendererTurbo(this, 225, 145, textureX, textureY); // Box 783
        body[131] = new ModelRendererTurbo(this, 977, 145, textureX, textureY); // Box 784
        body[132] = new ModelRendererTurbo(this, 481, 161, textureX, textureY); // Box 785
        body[133] = new ModelRendererTurbo(this, 481, 177, textureX, textureY); // Box 786
        body[134] = new ModelRendererTurbo(this, 857, 177, textureX, textureY); // Box 787
        body[135] = new ModelRendererTurbo(this, 873, 177, textureX, textureY); // Box 788
        body[136] = new ModelRendererTurbo(this, 81, 129, textureX, textureY); // Box 789
        body[137] = new ModelRendererTurbo(this, 177, 129, textureX, textureY); // Box 790
        body[138] = new ModelRendererTurbo(this, 281, 129, textureX, textureY); // Box 791
        body[139] = new ModelRendererTurbo(this, 385, 129, textureX, textureY); // Box 792
        body[140] = new ModelRendererTurbo(this, 1001, 145, textureX, textureY); // Box 793
        body[141] = new ModelRendererTurbo(this, 489, 153, textureX, textureY); // Box 794
        body[142] = new ModelRendererTurbo(this, 889, 177, textureX, textureY); // Box 795
        body[143] = new ModelRendererTurbo(this, 905, 177, textureX, textureY); // Box 796
        body[144] = new ModelRendererTurbo(this, 921, 177, textureX, textureY); // Box 797
        body[145] = new ModelRendererTurbo(this, 937, 177, textureX, textureY); // Box 798
        body[146] = new ModelRendererTurbo(this, 489, 129, textureX, textureY); // Box 799
        body[147] = new ModelRendererTurbo(this, 521, 129, textureX, textureY); // Box 800
        body[148] = new ModelRendererTurbo(this, 545, 129, textureX, textureY); // Box 801
        body[149] = new ModelRendererTurbo(this, 665, 129, textureX, textureY); // Box 802
        body[150] = new ModelRendererTurbo(this, 977, 153, textureX, textureY); // Box 803
        body[151] = new ModelRendererTurbo(this, 1001, 153, textureX, textureY); // Box 804
        body[152] = new ModelRendererTurbo(this, 953, 177, textureX, textureY); // Box 805
        body[153] = new ModelRendererTurbo(this, 969, 177, textureX, textureY); // Box 806
        body[154] = new ModelRendererTurbo(this, 1, 185, textureX, textureY); // Box 807
        body[155] = new ModelRendererTurbo(this, 17, 185, textureX, textureY); // Box 808
        body[156] = new ModelRendererTurbo(this, 689, 129, textureX, textureY); // Box 809
        body[157] = new ModelRendererTurbo(this, 81, 137, textureX, textureY); // Box 810
        body[158] = new ModelRendererTurbo(this, 169, 137, textureX, textureY); // Box 811
        body[159] = new ModelRendererTurbo(this, 177, 137, textureX, textureY); // Box 812
        body[160] = new ModelRendererTurbo(this, 185, 137, textureX, textureY); // Box 813
        body[161] = new ModelRendererTurbo(this, 273, 137, textureX, textureY); // Box 814
        body[162] = new ModelRendererTurbo(this, 281, 137, textureX, textureY); // Box 815
        body[163] = new ModelRendererTurbo(this, 289, 137, textureX, textureY); // Box 816
        body[164] = new ModelRendererTurbo(this, 377, 137, textureX, textureY); // Box 817
        body[165] = new ModelRendererTurbo(this, 385, 137, textureX, textureY); // Box 818
        body[166] = new ModelRendererTurbo(this, 393, 137, textureX, textureY); // Box 819
        body[167] = new ModelRendererTurbo(this, 481, 137, textureX, textureY); // Box 820
        body[168] = new ModelRendererTurbo(this, 489, 137, textureX, textureY); // Box 821
        body[169] = new ModelRendererTurbo(this, 809, 137, textureX, textureY); // Box 822
        body[170] = new ModelRendererTurbo(this, 833, 137, textureX, textureY); // Box 823
        body[171] = new ModelRendererTurbo(this, 857, 137, textureX, textureY); // Box 824
        body[172] = new ModelRendererTurbo(this, 185, 145, textureX, textureY); // Box 825
        body[173] = new ModelRendererTurbo(this, 209, 145, textureX, textureY); // Box 826
        body[174] = new ModelRendererTurbo(this, 321, 145, textureX, textureY); // Box 827
        body[175] = new ModelRendererTurbo(this, 489, 145, textureX, textureY); // Box 828
        body[176] = new ModelRendererTurbo(this, 873, 145, textureX, textureY); // Box 829
        body[177] = new ModelRendererTurbo(this, 897, 145, textureX, textureY); // Box 830
        body[178] = new ModelRendererTurbo(this, 921, 145, textureX, textureY); // Box 831
        body[179] = new ModelRendererTurbo(this, 945, 145, textureX, textureY); // Box 832
        body[180] = new ModelRendererTurbo(this, 969, 145, textureX, textureY); // Box 833
        body[181] = new ModelRendererTurbo(this, 17, 153, textureX, textureY); // Box 834
        body[182] = new ModelRendererTurbo(this, 41, 153, textureX, textureY); // Box 835
        body[183] = new ModelRendererTurbo(this, 65, 153, textureX, textureY); // Box 836
        body[184] = new ModelRendererTurbo(this, 321, 161, textureX, textureY); // Box 837
        body[185] = new ModelRendererTurbo(this, 489, 161, textureX, textureY); // Box 838
        body[186] = new ModelRendererTurbo(this, 873, 161, textureX, textureY); // Box 839
        body[187] = new ModelRendererTurbo(this, 897, 161, textureX, textureY); // Box 840
        body[188] = new ModelRendererTurbo(this, 921, 161, textureX, textureY); // Box 841
        body[189] = new ModelRendererTurbo(this, 945, 161, textureX, textureY); // Box 842
        body[190] = new ModelRendererTurbo(this, 969, 161, textureX, textureY); // Box 843
        body[191] = new ModelRendererTurbo(this, 977, 161, textureX, textureY); // Box 844
        body[192] = new ModelRendererTurbo(this, 9, 185, textureX, textureY); // Box 845
        body[193] = new ModelRendererTurbo(this, 857, 185, textureX, textureY); // Box 846
        body[194] = new ModelRendererTurbo(this, 905, 185, textureX, textureY); // Box 847
        body[195] = new ModelRendererTurbo(this, 937, 193, textureX, textureY); // Box 848
        body[196] = new ModelRendererTurbo(this, 1, 217, textureX, textureY); // Box 849
        body[197] = new ModelRendererTurbo(this, 857, 217, textureX, textureY); // Box 850
        body[198] = new ModelRendererTurbo(this, 905, 217, textureX, textureY); // Box 851
        body[199] = new ModelRendererTurbo(this, 937, 225, textureX, textureY); // Box 852
        body[200] = new ModelRendererTurbo(this, 857, 185, textureX, textureY); // Box 854
        body[201] = new ModelRendererTurbo(this, 937, 185, textureX, textureY); // Box 856
        body[202] = new ModelRendererTurbo(this, 913, 185, textureX, textureY); // Box 857
        body[203] = new ModelRendererTurbo(this, 969, 185, textureX, textureY); // Box 858
        body[204] = new ModelRendererTurbo(this, 57, 201, textureX, textureY); // Box 859
        body[205] = new ModelRendererTurbo(this, 1, 217, textureX, textureY); // Box 860
        body[206] = new ModelRendererTurbo(this, 1, 193, textureX, textureY); // Box 861
        body[207] = new ModelRendererTurbo(this, 33, 217, textureX, textureY); // Box 862
        body[208] = new ModelRendererTurbo(this, 857, 217, textureX, textureY); // Box 863
        body[209] = new ModelRendererTurbo(this, 889, 217, textureX, textureY); // Box 864
        body[210] = new ModelRendererTurbo(this, 1, 249, textureX, textureY); // Box 877
        body[211] = new ModelRendererTurbo(this, 137, 289, textureX, textureY); // Box 878
        body[212] = new ModelRendererTurbo(this, 393, 289, textureX, textureY); // Box 879
        body[213] = new ModelRendererTurbo(this, 809, 289, textureX, textureY); // Box 880
        body[214] = new ModelRendererTurbo(this, 49, 225, textureX, textureY); // Box 881
        body[215] = new ModelRendererTurbo(this, 905, 225, textureX, textureY); // Box 882
        body[216] = new ModelRendererTurbo(this, 969, 225, textureX, textureY); // Box 883
        body[217] = new ModelRendererTurbo(this, 49, 241, textureX, textureY); // Box 884
        body[218] = new ModelRendererTurbo(this, 937, 225, textureX, textureY); // Box 885
        body[219] = new ModelRendererTurbo(this, 1, 249, textureX, textureY); // Box 886
        body[220] = new ModelRendererTurbo(this, 857, 249, textureX, textureY); // Box 887
        body[221] = new ModelRendererTurbo(this, 881, 249, textureX, textureY); // Box 888
        body[222] = new ModelRendererTurbo(this, 33, 249, textureX, textureY); // Box 889
        body[223] = new ModelRendererTurbo(this, 905, 249, textureX, textureY); // Box 890
        body[224] = new ModelRendererTurbo(this, 921, 249, textureX, textureY); // Box 891
        body[225] = new ModelRendererTurbo(this, 937, 257, textureX, textureY); // Box 892
        body[226] = new ModelRendererTurbo(this, 169, 297, textureX, textureY); // Box 839
        body[227] = new ModelRendererTurbo(this, 425, 297, textureX, textureY); // Box 840
        body[228] = new ModelRendererTurbo(this, 1, 305, textureX, textureY); // Box 841
        body[229] = new ModelRendererTurbo(this, 49, 305, textureX, textureY); // Box 842
        body[230] = new ModelRendererTurbo(this, 513, 361, textureX, textureY); // Box 843
        body[231] = new ModelRendererTurbo(this, 497, 609, textureX, textureY); // Box 844
        body[232] = new ModelRendererTurbo(this, 737, 617, textureX, textureY); // Box 845
        body[233] = new ModelRendererTurbo(this, 737, 625, textureX, textureY); // Box 846
        body[234] = new ModelRendererTurbo(this, 97, 305, textureX, textureY); // Box 847
        body[235] = new ModelRendererTurbo(this, 257, 305, textureX, textureY); // Box 848
        body[236] = new ModelRendererTurbo(this, 305, 305, textureX, textureY); // Box 849
        body[237] = new ModelRendererTurbo(this, 353, 305, textureX, textureY); // Box 850
        body[238] = new ModelRendererTurbo(this, 473, 209, textureX, textureY); // Box 851
        body[239] = new ModelRendererTurbo(this, 961, 257, textureX, textureY); // Box 852
        body[240] = new ModelRendererTurbo(this, 49, 265, textureX, textureY); // Box 853
        body[241] = new ModelRendererTurbo(this, 625, 273, textureX, textureY); // Box 854
        body[242] = new ModelRendererTurbo(this, 793, 281, textureX, textureY); // Box 855
        body[243] = new ModelRendererTurbo(this, 201, 297, textureX, textureY); // Box 856
        body[244] = new ModelRendererTurbo(this, 33, 305, textureX, textureY); // Box 857
        body[245] = new ModelRendererTurbo(this, 81, 305, textureX, textureY); // Box 858
        body[246] = new ModelRendererTurbo(this, 169, 289, textureX, textureY); // Box 859
        body[247] = new ModelRendererTurbo(this, 425, 289, textureX, textureY); // Box 860
        body[248] = new ModelRendererTurbo(this, 809, 289, textureX, textureY); // Box 861
        body[249] = new ModelRendererTurbo(this, 1, 305, textureX, textureY); // Box 862
        body[250] = new ModelRendererTurbo(this, 1009, 265, textureX, textureY); // Box 863
        body[251] = new ModelRendererTurbo(this, 457, 289, textureX, textureY); // Box 864
        body[252] = new ModelRendererTurbo(this, 841, 289, textureX, textureY); // Box 865
        body[253] = new ModelRendererTurbo(this, 57, 305, textureX, textureY); // Box 866
        body[254] = new ModelRendererTurbo(this, 257, 305, textureX, textureY); // Box 867
        body[255] = new ModelRendererTurbo(this, 281, 305, textureX, textureY); // Box 868
        body[256] = new ModelRendererTurbo(this, 305, 305, textureX, textureY); // Box 869
        body[257] = new ModelRendererTurbo(this, 329, 305, textureX, textureY); // Box 870
        body[258] = new ModelRendererTurbo(this, 121, 313, textureX, textureY); // Box 871
        body[259] = new ModelRendererTurbo(this, 345, 313, textureX, textureY); // Box 872
        body[260] = new ModelRendererTurbo(this, 377, 313, textureX, textureY); // Box 873
        body[261] = new ModelRendererTurbo(this, 145, 321, textureX, textureY); // Box 874
        body[262] = new ModelRendererTurbo(this, 401, 321, textureX, textureY); // Box 875
        body[263] = new ModelRendererTurbo(this, 809, 321, textureX, textureY); // Box 876
        body[264] = new ModelRendererTurbo(this, 825, 321, textureX, textureY); // Box 877
        body[265] = new ModelRendererTurbo(this, 841, 321, textureX, textureY); // Box 878
        body[266] = new ModelRendererTurbo(this, 97, 313, textureX, textureY); // Box 879
        body[267] = new ModelRendererTurbo(this, 209, 321, textureX, textureY); // Box 880
        body[268] = new ModelRendererTurbo(this, 161, 329, textureX, textureY); // Box 881
        body[269] = new ModelRendererTurbo(this, 185, 329, textureX, textureY); // Box 882
        body[270] = new ModelRendererTurbo(this, 401, 329, textureX, textureY); // Box 883
        body[271] = new ModelRendererTurbo(this, 1, 337, textureX, textureY); // Box 884
        body[272] = new ModelRendererTurbo(this, 65, 337, textureX, textureY); // Box 885
        body[273] = new ModelRendererTurbo(this, 257, 337, textureX, textureY); // Box 886
        body[274] = new ModelRendererTurbo(this, 49, 337, textureX, textureY); // Box 887
        body[275] = new ModelRendererTurbo(this, 113, 337, textureX, textureY); // Box 888
        body[276] = new ModelRendererTurbo(this, 201, 337, textureX, textureY); // Box 889
        body[277] = new ModelRendererTurbo(this, 305, 337, textureX, textureY); // Box 890
        body[278] = new ModelRendererTurbo(this, 129, 337, textureX, textureY); // Box 891
        body[279] = new ModelRendererTurbo(this, 321, 337, textureX, textureY); // Box 892
        body[280] = new ModelRendererTurbo(this, 161, 345, textureX, textureY); // Box 932
        body[281] = new ModelRendererTurbo(this, 809, 345, textureX, textureY); // Box 933
        body[282] = new ModelRendererTurbo(this, 169, 345, textureX, textureY); // Box 934
        body[283] = new ModelRendererTurbo(this, 201, 353, textureX, textureY); // Box 935
        body[284] = new ModelRendererTurbo(this, 393, 353, textureX, textureY); // Box 936
        body[285] = new ModelRendererTurbo(this, 817, 345, textureX, textureY); // Box 937
        body[286] = new ModelRendererTurbo(this, 361, 305, textureX, textureY); // Box 934
        body[287] = new ModelRendererTurbo(this, 449, 329, textureX, textureY); // Box 935
        body[288] = new ModelRendererTurbo(this, 1, 337, textureX, textureY); // Box 936
        body[289] = new ModelRendererTurbo(this, 257, 337, textureX, textureY); // Box 937
        body[290] = new ModelRendererTurbo(this, 353, 337, textureX, textureY); // Box 938
        body[291] = new ModelRendererTurbo(this, 425, 353, textureX, textureY); // Box 939
        body[292] = new ModelRendererTurbo(this, 849, 353, textureX, textureY); // Box 940
        body[293] = new ModelRendererTurbo(this, 873, 353, textureX, textureY); // Box 941
        body[294] = new ModelRendererTurbo(this, 897, 353, textureX, textureY); // Box 942
        body[295] = new ModelRendererTurbo(this, 921, 353, textureX, textureY); // Box 943
        body[296] = new ModelRendererTurbo(this, 945, 353, textureX, textureY); // Box 944
        body[297] = new ModelRendererTurbo(this, 969, 353, textureX, textureY); // Box 945
        body[298] = new ModelRendererTurbo(this, 993, 353, textureX, textureY); // Box 946
        body[299] = new ModelRendererTurbo(this, 1, 361, textureX, textureY); // Box 947
        body[300] = new ModelRendererTurbo(this, 25, 361, textureX, textureY); // Box 948
        body[301] = new ModelRendererTurbo(this, 49, 361, textureX, textureY); // Box 949
        body[302] = new ModelRendererTurbo(this, 449, 353, textureX, textureY); // Box 951
        body[303] = new ModelRendererTurbo(this, 73, 361, textureX, textureY); // Box 952
        body[304] = new ModelRendererTurbo(this, 89, 361, textureX, textureY); // Box 953
        body[305] = new ModelRendererTurbo(this, 113, 361, textureX, textureY); // Box 954
        body[306] = new ModelRendererTurbo(this, 137, 361, textureX, textureY); // Box 955
        body[307] = new ModelRendererTurbo(this, 257, 361, textureX, textureY); // Box 956
        body[308] = new ModelRendererTurbo(this, 281, 361, textureX, textureY); // Box 957
        body[309] = new ModelRendererTurbo(this, 305, 361, textureX, textureY); // Box 958
        body[310] = new ModelRendererTurbo(this, 321, 361, textureX, textureY); // Box 959
        body[311] = new ModelRendererTurbo(this, 337, 361, textureX, textureY); // Box 960
        body[312] = new ModelRendererTurbo(this, 777, 361, textureX, textureY); // Box 961
        body[313] = new ModelRendererTurbo(this, 801, 361, textureX, textureY); // Box 962
        body[314] = new ModelRendererTurbo(this, 153, 369, textureX, textureY); // Box 963
        body[315] = new ModelRendererTurbo(this, 177, 369, textureX, textureY); // Box 964
        body[316] = new ModelRendererTurbo(this, 513, 369, textureX, textureY); // Box 965
        body[317] = new ModelRendererTurbo(this, 601, 369, textureX, textureY); // Box 966
        body[318] = new ModelRendererTurbo(this, 969, 169, textureX, textureY); // Box 967
        body[319] = new ModelRendererTurbo(this, 57, 193, textureX, textureY); // Box 968
        body[320] = new ModelRendererTurbo(this, 57, 257, textureX, textureY); // Box 969
        body[321] = new ModelRendererTurbo(this, 721, 273, textureX, textureY); // Box 970
        body[322] = new ModelRendererTurbo(this, 737, 273, textureX, textureY); // Box 971
        body[323] = new ModelRendererTurbo(this, 761, 273, textureX, textureY); // Box 972
        body[324] = new ModelRendererTurbo(this, 1, 281, textureX, textureY); // Box 973
        body[325] = new ModelRendererTurbo(this, 25, 281, textureX, textureY); // Box 974
        body[326] = new ModelRendererTurbo(this, 41, 281, textureX, textureY); // Box 975
        body[327] = new ModelRendererTurbo(this, 57, 281, textureX, textureY); // Box 976
        body[328] = new ModelRendererTurbo(this, 441, 289, textureX, textureY); // Box 977
        body[329] = new ModelRendererTurbo(this, 97, 305, textureX, textureY); // Box 978
        body[330] = new ModelRendererTurbo(this, 121, 305, textureX, textureY); // Box 979
        body[331] = new ModelRendererTurbo(this, 297, 305, textureX, textureY); // Box 980
        body[332] = new ModelRendererTurbo(this, 137, 305, textureX, textureY); // Box 981
        body[333] = new ModelRendererTurbo(this, 169, 305, textureX, textureY); // Box 982
        body[334] = new ModelRendererTurbo(this, 17, 201, textureX, textureY); // Box 983
        body[335] = new ModelRendererTurbo(this, 953, 265, textureX, textureY); // Box 984
        body[336] = new ModelRendererTurbo(this, 537, 273, textureX, textureY); // Box 985
        body[337] = new ModelRendererTurbo(this, 657, 273, textureX, textureY); // Box 986
        body[338] = new ModelRendererTurbo(this, 681, 273, textureX, textureY); // Box 987
        body[339] = new ModelRendererTurbo(this, 753, 273, textureX, textureY); // Box 988
        body[340] = new ModelRendererTurbo(this, 17, 281, textureX, textureY); // Box 989
        body[341] = new ModelRendererTurbo(this, 825, 281, textureX, textureY); // Box 990
        body[342] = new ModelRendererTurbo(this, 145, 289, textureX, textureY); // Box 991
        body[343] = new ModelRendererTurbo(this, 201, 289, textureX, textureY); // Box 992
        body[344] = new ModelRendererTurbo(this, 401, 289, textureX, textureY); // Box 993
        body[345] = new ModelRendererTurbo(this, 217, 297, textureX, textureY); // Box 994
        body[346] = new ModelRendererTurbo(this, 345, 305, textureX, textureY); // Box 995
        body[347] = new ModelRendererTurbo(this, 377, 305, textureX, textureY); // Box 996
        body[348] = new ModelRendererTurbo(this, 393, 305, textureX, textureY); // Box 997
        body[349] = new ModelRendererTurbo(this, 425, 305, textureX, textureY); // Box 998
        body[350] = new ModelRendererTurbo(this, 809, 305, textureX, textureY); // Box 999
        body[351] = new ModelRendererTurbo(this, 201, 313, textureX, textureY); // Box 1000
        body[352] = new ModelRendererTurbo(this, 217, 313, textureX, textureY); // Box 1001
        body[353] = new ModelRendererTurbo(this, 297, 313, textureX, textureY); // Box 1002
        body[354] = new ModelRendererTurbo(this, 457, 313, textureX, textureY); // Box 1003
        body[355] = new ModelRendererTurbo(this, 1, 321, textureX, textureY); // Box 1004
        body[356] = new ModelRendererTurbo(this, 33, 321, textureX, textureY); // Box 1005
        body[357] = new ModelRendererTurbo(this, 49, 321, textureX, textureY); // Box 1006
        body[358] = new ModelRendererTurbo(this, 81, 321, textureX, textureY); // Box 1007
        body[359] = new ModelRendererTurbo(this, 161, 321, textureX, textureY); // Box 1008
        body[360] = new ModelRendererTurbo(this, 417, 321, textureX, textureY); // Box 1009
        body[361] = new ModelRendererTurbo(this, 177, 329, textureX, textureY); // Box 1010
        body[362] = new ModelRendererTurbo(this, 201, 329, textureX, textureY); // Box 1011
        body[363] = new ModelRendererTurbo(this, 73, 337, textureX, textureY); // Box 1012
        body[364] = new ModelRendererTurbo(this, 137, 337, textureX, textureY); // Box 1013
        body[365] = new ModelRendererTurbo(this, 177, 337, textureX, textureY); // Box 1014
        body[366] = new ModelRendererTurbo(this, 329, 337, textureX, textureY); // Box 1015
        body[367] = new ModelRendererTurbo(this, 393, 337, textureX, textureY); // Box 1016
        body[368] = new ModelRendererTurbo(this, 9, 345, textureX, textureY); // Box 1017
        body[369] = new ModelRendererTurbo(this, 73, 345, textureX, textureY); // Box 1018
        body[370] = new ModelRendererTurbo(this, 137, 345, textureX, textureY); // Box 1019
        body[371] = new ModelRendererTurbo(this, 265, 345, textureX, textureY); // Box 1020
        body[372] = new ModelRendererTurbo(this, 329, 345, textureX, textureY); // Box 1021
        body[373] = new ModelRendererTurbo(this, 849, 345, textureX, textureY); // Box 1022
        body[374] = new ModelRendererTurbo(this, 417, 353, textureX, textureY); // Box 1023
        body[375] = new ModelRendererTurbo(this, 633, 353, textureX, textureY); // Box 1024
        body[376] = new ModelRendererTurbo(this, 801, 353, textureX, textureY); // Box 1025
        body[377] = new ModelRendererTurbo(this, 865, 353, textureX, textureY); // Box 1026
        body[378] = new ModelRendererTurbo(this, 889, 353, textureX, textureY); // Box 1027
        body[379] = new ModelRendererTurbo(this, 913, 353, textureX, textureY); // Box 1028
        body[380] = new ModelRendererTurbo(this, 937, 353, textureX, textureY); // Box 1029
        body[381] = new ModelRendererTurbo(this, 961, 353, textureX, textureY); // Box 1030
        body[382] = new ModelRendererTurbo(this, 985, 353, textureX, textureY); // Box 1031
        body[383] = new ModelRendererTurbo(this, 1009, 353, textureX, textureY); // Box 1032
        body[384] = new ModelRendererTurbo(this, 17, 361, textureX, textureY); // Box 1033
        body[385] = new ModelRendererTurbo(this, 41, 361, textureX, textureY); // Box 1034
        body[386] = new ModelRendererTurbo(this, 105, 361, textureX, textureY); // Box 1035
        body[387] = new ModelRendererTurbo(this, 129, 361, textureX, textureY); // Box 1036
        body[388] = new ModelRendererTurbo(this, 153, 361, textureX, textureY); // Box 1037
        body[389] = new ModelRendererTurbo(this, 273, 361, textureX, textureY); // Box 1038
        body[390] = new ModelRendererTurbo(this, 353, 361, textureX, textureY); // Box 1039
        body[391] = new ModelRendererTurbo(this, 473, 361, textureX, textureY); // Box 1040
        body[392] = new ModelRendererTurbo(this, 793, 361, textureX, textureY); // Box 1041
        body[393] = new ModelRendererTurbo(this, 169, 369, textureX, textureY); // Box 1042
        body[394] = new ModelRendererTurbo(this, 193, 369, textureX, textureY); // Box 1043
        body[395] = new ModelRendererTurbo(this, 273, 361, textureX, textureY); // Box 1061

        body[0].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 633
        body[0].setRotationPoint(-33F, -170F, -10F);

        body[1].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 634
        body[1].setRotationPoint(-33F, -170F, -16F);

        body[2].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 635
        body[2].setRotationPoint(-33F, -168F, -11F);

        body[3].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 636
        body[3].setRotationPoint(-33F, -168F, -17F);

        body[4].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 637
        body[4].setRotationPoint(-33F, -171F, -11F);

        body[5].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 638
        body[5].setRotationPoint(-33F, -171F, -17F);

        body[6].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 639
        body[6].setRotationPoint(-33F, -170F, -8F);

        body[7].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 640
        body[7].setRotationPoint(-33F, -170F, -17F);

        body[8].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 641
        body[8].setRotationPoint(-33F, -170F, -11F);

        body[9].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 642
        body[9].setRotationPoint(-33F, -170F, -14F);

        body[10].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 663
        body[10].setRotationPoint(-33F, -170F, -22F);

        body[11].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 664
        body[11].setRotationPoint(-33F, -170F, -28F);

        body[12].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 665
        body[12].setRotationPoint(-33F, -168F, -23F);

        body[13].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 666
        body[13].setRotationPoint(-33F, -168F, -29F);

        body[14].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 667
        body[14].setRotationPoint(-33F, -171F, -23F);

        body[15].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 668
        body[15].setRotationPoint(-33F, -171F, -29F);

        body[16].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 669
        body[16].setRotationPoint(-33F, -170F, -20F);

        body[17].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 670
        body[17].setRotationPoint(-33F, -170F, -29F);

        body[18].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 671
        body[18].setRotationPoint(-33F, -170F, -23F);

        body[19].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 672
        body[19].setRotationPoint(-33F, -170F, -26F);

        body[20].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 673
        body[20].setRotationPoint(32F, -170F, 8F);

        body[21].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 674
        body[21].setRotationPoint(32F, -170F, 14F);

        body[22].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 675
        body[22].setRotationPoint(32F, -168F, 7F);

        body[23].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 676
        body[23].setRotationPoint(32F, -168F, 13F);

        body[24].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 677
        body[24].setRotationPoint(32F, -171F, 7F);

        body[25].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 678
        body[25].setRotationPoint(32F, -171F, 13F);

        body[26].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 679
        body[26].setRotationPoint(32F, -170F, 7F);

        body[27].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 680
        body[27].setRotationPoint(32F, -170F, 16F);

        body[28].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 681
        body[28].setRotationPoint(32F, -170F, 10F);

        body[29].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 682
        body[29].setRotationPoint(32F, -170F, 13F);

        body[30].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 683
        body[30].setRotationPoint(32F, -170F, 20F);

        body[31].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 684
        body[31].setRotationPoint(32F, -170F, 26F);

        body[32].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 685
        body[32].setRotationPoint(32F, -168F, 19F);

        body[33].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 686
        body[33].setRotationPoint(32F, -168F, 25F);

        body[34].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 687
        body[34].setRotationPoint(32F, -171F, 19F);

        body[35].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 688
        body[35].setRotationPoint(32F, -171F, 25F);

        body[36].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 689
        body[36].setRotationPoint(32F, -170F, 19F);

        body[37].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 690
        body[37].setRotationPoint(32F, -170F, 28F);

        body[38].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 691
        body[38].setRotationPoint(32F, -170F, 22F);

        body[39].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 692
        body[39].setRotationPoint(32F, -170F, 25F);

        body[40].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 693
        body[40].setRotationPoint(32F, -170F, -10F);

        body[41].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 694
        body[41].setRotationPoint(32F, -170F, -16F);

        body[42].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 695
        body[42].setRotationPoint(32F, -168F, -11F);

        body[43].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 696
        body[43].setRotationPoint(32F, -168F, -17F);

        body[44].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 697
        body[44].setRotationPoint(32F, -171F, -11F);

        body[45].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 698
        body[45].setRotationPoint(32F, -171F, -17F);

        body[46].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 699
        body[46].setRotationPoint(32F, -170F, -8F);

        body[47].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 700
        body[47].setRotationPoint(32F, -170F, -17F);

        body[48].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 701
        body[48].setRotationPoint(32F, -170F, -11F);

        body[49].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 702
        body[49].setRotationPoint(32F, -170F, -14F);

        body[50].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 703
        body[50].setRotationPoint(32F, -170F, -22F);

        body[51].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 704
        body[51].setRotationPoint(32F, -170F, -28F);

        body[52].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 705
        body[52].setRotationPoint(32F, -168F, -23F);

        body[53].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 706
        body[53].setRotationPoint(32F, -168F, -29F);

        body[54].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 707
        body[54].setRotationPoint(32F, -171F, -23F);

        body[55].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 708
        body[55].setRotationPoint(32F, -171F, -29F);

        body[56].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 709
        body[56].setRotationPoint(32F, -170F, -20F);

        body[57].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 710
        body[57].setRotationPoint(32F, -170F, -29F);

        body[58].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 711
        body[58].setRotationPoint(32F, -170F, -23F);

        body[59].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 712
        body[59].setRotationPoint(32F, -170F, -26F);

        body[60].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 713
        body[60].setRotationPoint(-33F, -170F, 8F);

        body[61].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 714
        body[61].setRotationPoint(-33F, -170F, 14F);

        body[62].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 715
        body[62].setRotationPoint(-33F, -168F, 7F);

        body[63].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 716
        body[63].setRotationPoint(-33F, -168F, 13F);

        body[64].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 717
        body[64].setRotationPoint(-33F, -171F, 7F);

        body[65].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 718
        body[65].setRotationPoint(-33F, -171F, 13F);

        body[66].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 719
        body[66].setRotationPoint(-33F, -170F, 7F);

        body[67].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 720
        body[67].setRotationPoint(-33F, -170F, 16F);

        body[68].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 721
        body[68].setRotationPoint(-33F, -170F, 10F);

        body[69].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 722
        body[69].setRotationPoint(-33F, -170F, 13F);

        body[70].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 723
        body[70].setRotationPoint(-33F, -170F, 20F);

        body[71].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 724
        body[71].setRotationPoint(-33F, -170F, 26F);

        body[72].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 725
        body[72].setRotationPoint(-33F, -168F, 19F);

        body[73].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 726
        body[73].setRotationPoint(-33F, -168F, 25F);

        body[74].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 727
        body[74].setRotationPoint(-33F, -171F, 19F);

        body[75].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 728
        body[75].setRotationPoint(-33F, -171F, 25F);

        body[76].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 729
        body[76].setRotationPoint(-33F, -170F, 19F);

        body[77].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 730
        body[77].setRotationPoint(-33F, -170F, 28F);

        body[78].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 731
        body[78].setRotationPoint(-33F, -170F, 22F);

        body[79].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 732
        body[79].setRotationPoint(-33F, -170F, 25F);

        body[80].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 733
        body[80].setRotationPoint(-40F, -170F, -10F);

        body[81].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 734
        body[81].setRotationPoint(-40F, -170F, -16F);

        body[82].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 735
        body[82].setRotationPoint(-40F, -168F, -11F);

        body[83].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 736
        body[83].setRotationPoint(-40F, -168F, -17F);

        body[84].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 737
        body[84].setRotationPoint(-40F, -171F, -11F);

        body[85].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 738
        body[85].setRotationPoint(-40F, -171F, -17F);

        body[86].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 739
        body[86].setRotationPoint(-40F, -170F, -8F);

        body[87].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 740
        body[87].setRotationPoint(-40F, -170F, -17F);

        body[88].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 741
        body[88].setRotationPoint(-40F, -170F, -11F);

        body[89].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 742
        body[89].setRotationPoint(-40F, -170F, -14F);

        body[90].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 743
        body[90].setRotationPoint(-40F, -170F, -22F);

        body[91].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 744
        body[91].setRotationPoint(-40F, -170F, -28F);

        body[92].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 745
        body[92].setRotationPoint(-40F, -168F, -23F);

        body[93].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 746
        body[93].setRotationPoint(-40F, -168F, -29F);

        body[94].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 747
        body[94].setRotationPoint(-40F, -171F, -23F);

        body[95].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 748
        body[95].setRotationPoint(-40F, -171F, -29F);

        body[96].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 749
        body[96].setRotationPoint(-40F, -170F, -20F);

        body[97].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 750
        body[97].setRotationPoint(-40F, -170F, -29F);

        body[98].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 751
        body[98].setRotationPoint(-40F, -170F, -23F);

        body[99].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 752
        body[99].setRotationPoint(-40F, -170F, -26F);

        body[100].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 753
        body[100].setRotationPoint(-40F, -170F, 8F);

        body[101].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 754
        body[101].setRotationPoint(-40F, -170F, 14F);

        body[102].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 755
        body[102].setRotationPoint(-40F, -168F, 7F);

        body[103].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 756
        body[103].setRotationPoint(-40F, -168F, 13F);

        body[104].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 757
        body[104].setRotationPoint(-40F, -171F, 7F);

        body[105].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 758
        body[105].setRotationPoint(-40F, -171F, 13F);

        body[106].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 759
        body[106].setRotationPoint(-40F, -170F, 7F);

        body[107].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 760
        body[107].setRotationPoint(-40F, -170F, 16F);

        body[108].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 761
        body[108].setRotationPoint(-40F, -170F, 10F);

        body[109].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 762
        body[109].setRotationPoint(-40F, -170F, 13F);

        body[110].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 763
        body[110].setRotationPoint(-40F, -170F, 20F);

        body[111].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 764
        body[111].setRotationPoint(-40F, -170F, 26F);

        body[112].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 765
        body[112].setRotationPoint(-40F, -168F, 19F);

        body[113].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 766
        body[113].setRotationPoint(-40F, -168F, 25F);

        body[114].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 767
        body[114].setRotationPoint(-40F, -171F, 19F);

        body[115].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 768
        body[115].setRotationPoint(-40F, -171F, 25F);

        body[116].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 769
        body[116].setRotationPoint(-40F, -170F, 19F);

        body[117].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 770
        body[117].setRotationPoint(-40F, -170F, 28F);

        body[118].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 771
        body[118].setRotationPoint(-40F, -170F, 22F);

        body[119].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 772
        body[119].setRotationPoint(-40F, -170F, 25F);

        body[120].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 773
        body[120].setRotationPoint(39F, -170F, -10F);

        body[121].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 774
        body[121].setRotationPoint(39F, -170F, -16F);

        body[122].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 775
        body[122].setRotationPoint(39F, -168F, -11F);

        body[123].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 776
        body[123].setRotationPoint(39F, -168F, -17F);

        body[124].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 777
        body[124].setRotationPoint(39F, -171F, -11F);

        body[125].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 778
        body[125].setRotationPoint(39F, -171F, -17F);

        body[126].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 779
        body[126].setRotationPoint(39F, -170F, -8F);

        body[127].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 780
        body[127].setRotationPoint(39F, -170F, -17F);

        body[128].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 781
        body[128].setRotationPoint(39F, -170F, -11F);

        body[129].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 782
        body[129].setRotationPoint(39F, -170F, -14F);

        body[130].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 783
        body[130].setRotationPoint(39F, -170F, -22F);

        body[131].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 784
        body[131].setRotationPoint(39F, -170F, -28F);

        body[132].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 785
        body[132].setRotationPoint(39F, -168F, -23F);

        body[133].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 786
        body[133].setRotationPoint(39F, -168F, -29F);

        body[134].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 787
        body[134].setRotationPoint(39F, -171F, -23F);

        body[135].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 788
        body[135].setRotationPoint(39F, -171F, -29F);

        body[136].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 789
        body[136].setRotationPoint(39F, -170F, -20F);

        body[137].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 790
        body[137].setRotationPoint(39F, -170F, -29F);

        body[138].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 791
        body[138].setRotationPoint(39F, -170F, -23F);

        body[139].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 792
        body[139].setRotationPoint(39F, -170F, -26F);

        body[140].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 793
        body[140].setRotationPoint(39F, -170F, 8F);

        body[141].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 794
        body[141].setRotationPoint(39F, -170F, 14F);

        body[142].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 795
        body[142].setRotationPoint(39F, -168F, 7F);

        body[143].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 796
        body[143].setRotationPoint(39F, -168F, 13F);

        body[144].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 797
        body[144].setRotationPoint(39F, -171F, 7F);

        body[145].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 798
        body[145].setRotationPoint(39F, -171F, 13F);

        body[146].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 799
        body[146].setRotationPoint(39F, -170F, 7F);

        body[147].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 800
        body[147].setRotationPoint(39F, -170F, 16F);

        body[148].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 801
        body[148].setRotationPoint(39F, -170F, 10F);

        body[149].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 802
        body[149].setRotationPoint(39F, -170F, 13F);

        body[150].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 803
        body[150].setRotationPoint(39F, -170F, 20F);

        body[151].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 804
        body[151].setRotationPoint(39F, -170F, 26F);

        body[152].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 805
        body[152].setRotationPoint(39F, -168F, 19F);

        body[153].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 806
        body[153].setRotationPoint(39F, -168F, 25F);

        body[154].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 807
        body[154].setRotationPoint(39F, -171F, 19F);

        body[155].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 808
        body[155].setRotationPoint(39F, -171F, 25F);

        body[156].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 809
        body[156].setRotationPoint(39F, -170F, 19F);

        body[157].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 810
        body[157].setRotationPoint(39F, -170F, 28F);

        body[158].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 811
        body[158].setRotationPoint(39F, -170F, 22F);

        body[159].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 812
        body[159].setRotationPoint(39F, -170F, 25F);

        body[160].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 813
        body[160].setRotationPoint(40F, -169.5F, -9.5F);

        body[161].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 814
        body[161].setRotationPoint(40F, -169.5F, 8.5F);

        body[162].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 815
        body[162].setRotationPoint(40F, -169.5F, -15.5F);

        body[163].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 816
        body[163].setRotationPoint(40F, -169.5F, 14.5F);

        body[164].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 817
        body[164].setRotationPoint(40F, -169.5F, -21.5F);

        body[165].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 818
        body[165].setRotationPoint(40F, -169.5F, 20.5F);

        body[166].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 819
        body[166].setRotationPoint(40F, -169.5F, -27.5F);

        body[167].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 820
        body[167].setRotationPoint(40F, -169.5F, 26.5F);

        body[168].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 821
        body[168].setRotationPoint(31F, -169.5F, 8.5F);

        body[169].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 822
        body[169].setRotationPoint(31F, -169.5F, -9.5F);

        body[170].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 823
        body[170].setRotationPoint(31F, -169.5F, 14.5F);

        body[171].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 824
        body[171].setRotationPoint(31F, -169.5F, -15.5F);

        body[172].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 825
        body[172].setRotationPoint(31F, -169.5F, 20.5F);

        body[173].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 826
        body[173].setRotationPoint(31F, -169.5F, -21.5F);

        body[174].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 827
        body[174].setRotationPoint(31F, -169.5F, 26.5F);

        body[175].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 828
        body[175].setRotationPoint(31F, -169.5F, -27.5F);

        body[176].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 829
        body[176].setRotationPoint(-32F, -169.5F, -9.5F);

        body[177].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 830
        body[177].setRotationPoint(-32F, -169.5F, 8.5F);

        body[178].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 831
        body[178].setRotationPoint(-32F, -169.5F, -15.5F);

        body[179].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 832
        body[179].setRotationPoint(-32F, -169.5F, 14.5F);

        body[180].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 833
        body[180].setRotationPoint(-32F, -169.5F, -21.5F);

        body[181].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 834
        body[181].setRotationPoint(-32F, -169.5F, 20.5F);

        body[182].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 835
        body[182].setRotationPoint(-32F, -169.5F, -27.5F);

        body[183].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 836
        body[183].setRotationPoint(-32F, -169.5F, 26.5F);

        body[184].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 837
        body[184].setRotationPoint(-41F, -169.5F, 8.5F);

        body[185].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 838
        body[185].setRotationPoint(-41F, -169.5F, -9.5F);

        body[186].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 839
        body[186].setRotationPoint(-41F, -169.5F, 14.5F);

        body[187].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 840
        body[187].setRotationPoint(-41F, -169.5F, -15.5F);

        body[188].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 841
        body[188].setRotationPoint(-41F, -169.5F, 20.5F);

        body[189].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 842
        body[189].setRotationPoint(-41F, -169.5F, -21.5F);

        body[190].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 843
        body[190].setRotationPoint(-41F, -169.5F, 26.5F);

        body[191].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 844
        body[191].setRotationPoint(-41F, -169.5F, -27.5F);

        body[192].addShapeBox(0F, 0F, 0F, 1, 2, 22, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -1F, 0F); // Box 845
        body[192].setRotationPoint(-42F, -170F, -29F);

        body[193].addShapeBox(0F, 0F, 0F, 1, 2, 22, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -1F, 0F); // Box 846
        body[193].setRotationPoint(-42F, -170F, 7F);

        body[194].addShapeBox(0F, 0F, 0F, 1, 2, 22, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 847
        body[194].setRotationPoint(-42F, -172F, -29F);

        body[195].addShapeBox(0F, 0F, 0F, 1, 2, 22, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 848
        body[195].setRotationPoint(-42F, -172F, 7F);

        body[196].addShapeBox(0F, 0F, 0F, 1, 2, 22, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -0.5F, 0F); // Box 849
        body[196].setRotationPoint(-31F, -170F, 7F);

        body[197].addShapeBox(0F, 0F, 0F, 1, 2, 22, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -0.5F, 0F); // Box 850
        body[197].setRotationPoint(-31F, -170F, -29F);

        body[198].addShapeBox(0F, 0F, 0F, 1, 2, 22, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 851
        body[198].setRotationPoint(-31F, -172F, 7F);

        body[199].addShapeBox(0F, 0F, 0F, 1, 2, 22, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 852
        body[199].setRotationPoint(-31F, -172F, -29F);

        body[200].addShapeBox(0F, 0F, 0F, 2, 2, 8, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F); // Box 854
        body[200].setRotationPoint(-44F, -172F, -16F);

        body[201].addShapeBox(0F, 0F, 0F, 2, 2, 8, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F); // Box 856
        body[201].setRotationPoint(-44F, -172F, -28F);

        body[202].addShapeBox(0F, 0F, 0F, 2, 12, 4, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 857
        body[202].setRotationPoint(-46F, -172F, 22F);

        body[203].addShapeBox(0F, 0F, 0F, 2, 12, 4, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 858
        body[203].setRotationPoint(-46F, -172F, -26F);

        body[204].addShapeBox(0F, 0F, 0F, 2, 12, 4, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 859
        body[204].setRotationPoint(-46F, -172F, 10F);

        body[205].addShapeBox(0F, 0F, 0F, 2, 12, 4, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 860
        body[205].setRotationPoint(-46F, -172F, -14F);

        body[206].addShapeBox(0F, 0F, 0F, 1, 2, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 861
        body[206].setRotationPoint(-45.5F, -169F, 14F);

        body[207].addShapeBox(0F, 0F, 0F, 1, 2, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 862
        body[207].setRotationPoint(-45.5F, -169F, -22F);

        body[208].addShapeBox(0F, 0F, 0F, 1, 2, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 863
        body[208].setRotationPoint(-45.5F, -163F, 14F);

        body[209].addShapeBox(0F, 0F, 0F, 1, 2, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 864
        body[209].setRotationPoint(-45.5F, -163F, -22F);

        body[210].addShapeBox(0F, 0F, 0F, 1, 2, 22, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -0.5F, 0F); // Box 877
        body[210].setRotationPoint(41F, -170F, -29F);

        body[211].addShapeBox(0F, 0F, 0F, 1, 2, 22, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -0.5F, 0F); // Box 878
        body[211].setRotationPoint(41F, -170F, 7F);

        body[212].addShapeBox(0F, 0F, 0F, 1, 2, 22, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 879
        body[212].setRotationPoint(41F, -172F, -29F);

        body[213].addShapeBox(0F, 0F, 0F, 1, 2, 22, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 880
        body[213].setRotationPoint(41F, -172F, 7F);

        body[214].addShapeBox(0F, 0F, 0F, 2, 2, 8, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F); // Box 881
        body[214].setRotationPoint(42F, -172F, -16F);

        body[215].addShapeBox(0F, 0F, 0F, 2, 2, 8, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F); // Box 882
        body[215].setRotationPoint(42F, -172F, -28F);

        body[216].addShapeBox(0F, 0F, 0F, 2, 12, 4, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 883
        body[216].setRotationPoint(44F, -172F, -26F);

        body[217].addShapeBox(0F, 0F, 0F, 2, 12, 4, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 884
        body[217].setRotationPoint(44F, -172F, -14F);

        body[218].addShapeBox(0F, 0F, 0F, 1, 2, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 885
        body[218].setRotationPoint(44.5F, -169F, -22F);

        body[219].addShapeBox(0F, 0F, 0F, 1, 2, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 886
        body[219].setRotationPoint(44.5F, -163F, -22F);

        body[220].addShapeBox(0F, 0F, 0F, 2, 2, 8, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F); // Box 887
        body[220].setRotationPoint(42F, -172F, 8F);

        body[221].addShapeBox(0F, 0F, 0F, 2, 2, 8, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F); // Box 888
        body[221].setRotationPoint(42F, -172F, 20F);

        body[222].addShapeBox(0F, 0F, 0F, 2, 12, 4, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 889
        body[222].setRotationPoint(44F, -172F, 22F);

        body[223].addShapeBox(0F, 0F, 0F, 2, 12, 4, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 890
        body[223].setRotationPoint(44F, -172F, 10F);

        body[224].addShapeBox(0F, 0F, 0F, 1, 2, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 891
        body[224].setRotationPoint(44.5F, -169F, 14F);

        body[225].addShapeBox(0F, 0F, 0F, 1, 2, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 892
        body[225].setRotationPoint(44.5F, -163F, 14F);

        body[226].addShapeBox(0F, 0F, 0F, 1, 2, 22, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -1F, 0F); // Box 839
        body[226].setRotationPoint(30F, -170F, -29F);

        body[227].addShapeBox(0F, 0F, 0F, 1, 2, 22, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -1F, 0F); // Box 840
        body[227].setRotationPoint(30F, -170F, 7F);

        body[228].addShapeBox(0F, 0F, 0F, 1, 2, 22, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 841
        body[228].setRotationPoint(30F, -172F, -29F);

        body[229].addShapeBox(0F, 0F, 0F, 1, 2, 22, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 842
        body[229].setRotationPoint(30F, -172F, 7F);

        body[230].addShapeBox(0F, 0F, 0F, 128, 2, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 843
        body[230].setRotationPoint(-64F, -160F, 10F);

        body[231].addShapeBox(0F, 0F, 0F, 128, 2, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 844
        body[231].setRotationPoint(-64F, -160F, -14F);

        body[232].addShapeBox(0F, 0F, 0F, 128, 2, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 845
        body[232].setRotationPoint(-63F, -160F, 22F);

        body[233].addShapeBox(0F, 0F, 0F, 128, 2, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 846
        body[233].setRotationPoint(-64F, -160F, -26F);

        body[234].addShapeBox(0F, 0F, 0F, 1, 10, 20, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -8F, 0F, 0F, -8F, 0F, 0F, -8F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 847
        body[234].setRotationPoint(-45.5F, -170F, -10F);

        body[235].addShapeBox(0F, 0F, 0F, 1, 10, 20, 0F, 0F, -8F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -8F, 0F, 0F, -8F, 0F); // Box 848
        body[235].setRotationPoint(-45.5F, -170F, -10F);

        body[236].addShapeBox(0F, 0F, 0F, 1, 10, 20, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -8F, 0F, 0F, -8F, 0F, 0F, -8F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 849
        body[236].setRotationPoint(44.5F, -170F, -10F);

        body[237].addShapeBox(0F, 0F, 0F, 1, 10, 20, 0F, 0F, -8F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -8F, 0F, 0F, -8F, 0F); // Box 850
        body[237].setRotationPoint(44.5F, -170F, -10F);

        body[238].addShapeBox(0F, 0F, 0F, 3, 1, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 851
        body[238].setRotationPoint(-44F, -159.5F, 14F);

        body[239].addShapeBox(0F, 0F, 0F, 3, 1, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 852
        body[239].setRotationPoint(-44F, -159.5F, -22F);

        body[240].addShapeBox(0F, 0F, 0F, 3, 1, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 853
        body[240].setRotationPoint(41F, -159.5F, -22F);

        body[241].addShapeBox(0F, 0F, 0F, 3, 1, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 854
        body[241].setRotationPoint(41F, -159.5F, 14F);

        body[242].addShapeBox(0F, 0F, 0F, 3, 1, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 855
        body[242].setRotationPoint(28F, -159.5F, 14F);

        body[243].addShapeBox(0F, 0F, 0F, 3, 1, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 856
        body[243].setRotationPoint(28F, -159.5F, -22F);

        body[244].addShapeBox(0F, 0F, 0F, 3, 1, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 857
        body[244].setRotationPoint(-31F, -159.5F, -22F);

        body[245].addShapeBox(0F, 0F, 0F, 3, 1, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 858
        body[245].setRotationPoint(-31F, -159.5F, 14F);

        body[246].addShapeBox(0F, 0F, 0F, 2, 2, 8, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F); // Box 859
        body[246].setRotationPoint(-30F, -172F, 8F);

        body[247].addShapeBox(0F, 0F, 0F, 2, 2, 8, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F); // Box 860
        body[247].setRotationPoint(-30F, -172F, -16F);

        body[248].addShapeBox(0F, 0F, 0F, 2, 2, 8, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F); // Box 861
        body[248].setRotationPoint(-30F, -172F, 20F);

        body[249].addShapeBox(0F, 0F, 0F, 2, 2, 8, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F); // Box 862
        body[249].setRotationPoint(-30F, -172F, -28F);

        body[250].addShapeBox(0F, 0F, 0F, 2, 12, 4, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 863
        body[250].setRotationPoint(-28F, -172F, 22F);

        body[251].addShapeBox(0F, 0F, 0F, 2, 12, 4, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 864
        body[251].setRotationPoint(-28F, -172F, -26F);

        body[252].addShapeBox(0F, 0F, 0F, 2, 12, 4, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 865
        body[252].setRotationPoint(-28F, -172F, 10F);

        body[253].addShapeBox(0F, 0F, 0F, 2, 12, 4, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 866
        body[253].setRotationPoint(-28F, -172F, -14F);

        body[254].addShapeBox(0F, 0F, 0F, 1, 2, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 867
        body[254].setRotationPoint(-27.5F, -169F, 14F);

        body[255].addShapeBox(0F, 0F, 0F, 1, 2, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 868
        body[255].setRotationPoint(-27.5F, -169F, -22F);

        body[256].addShapeBox(0F, 0F, 0F, 1, 2, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 869
        body[256].setRotationPoint(-27.5F, -163F, 14F);

        body[257].addShapeBox(0F, 0F, 0F, 1, 2, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 870
        body[257].setRotationPoint(-27.5F, -163F, -22F);

        body[258].addShapeBox(0F, 0F, 0F, 2, 2, 8, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F); // Box 871
        body[258].setRotationPoint(28F, -172F, 8F);

        body[259].addShapeBox(0F, 0F, 0F, 2, 2, 8, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F); // Box 872
        body[259].setRotationPoint(28F, -172F, -16F);

        body[260].addShapeBox(0F, 0F, 0F, 2, 2, 8, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F); // Box 873
        body[260].setRotationPoint(28F, -172F, 20F);

        body[261].addShapeBox(0F, 0F, 0F, 2, 2, 8, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F); // Box 874
        body[261].setRotationPoint(28F, -172F, -28F);

        body[262].addShapeBox(0F, 0F, 0F, 2, 12, 4, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 875
        body[262].setRotationPoint(26F, -172F, 22F);

        body[263].addShapeBox(0F, 0F, 0F, 2, 12, 4, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 876
        body[263].setRotationPoint(26F, -172F, -26F);

        body[264].addShapeBox(0F, 0F, 0F, 2, 12, 4, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 877
        body[264].setRotationPoint(26F, -172F, 10F);

        body[265].addShapeBox(0F, 0F, 0F, 2, 12, 4, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 878
        body[265].setRotationPoint(26F, -172F, -14F);

        body[266].addShapeBox(0F, 0F, 0F, 1, 2, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 879
        body[266].setRotationPoint(26.5F, -169F, 14F);

        body[267].addShapeBox(0F, 0F, 0F, 1, 2, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 880
        body[267].setRotationPoint(26.5F, -169F, -22F);

        body[268].addShapeBox(0F, 0F, 0F, 1, 2, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 881
        body[268].setRotationPoint(26.5F, -163F, 14F);

        body[269].addShapeBox(0F, 0F, 0F, 1, 2, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 882
        body[269].setRotationPoint(26.5F, -163F, -22F);

        body[270].addShapeBox(0F, 0F, 0F, 10, 1, 20, 0F, 0F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F, -8F, 0F, 0F); // Box 883
        body[270].setRotationPoint(-41F, -159.5F, -10F);

        body[271].addShapeBox(0F, 0F, 0F, 10, 1, 20, 0F, -8F, 0F, 0F, 0F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F); // Box 884
        body[271].setRotationPoint(-41F, -159.5F, -10F);

        body[272].addShapeBox(0F, 0F, 0F, 10, 1, 20, 0F, -8F, 0F, 0F, 0F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F); // Box 885
        body[272].setRotationPoint(31F, -159.5F, -10F);

        body[273].addShapeBox(0F, 0F, 0F, 10, 1, 20, 0F, 0F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F, -8F, 0F, 0F, 0F, 0F, 0F, -8F, 0F, 0F); // Box 886
        body[273].setRotationPoint(31F, -159.5F, -10F);

        body[274].addShapeBox(0F, 0F, 0F, 4, 2, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 887
        body[274].setRotationPoint(-14F, -160F, -22F);

        body[275].addShapeBox(0F, 0F, 0F, 4, 2, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 888
        body[275].setRotationPoint(-14F, -160F, 14F);

        body[276].addShapeBox(0F, 0F, 0F, 4, 2, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 889
        body[276].setRotationPoint(10F, -160F, 14F);

        body[277].addShapeBox(0F, 0F, 0F, 4, 2, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 890
        body[277].setRotationPoint(10F, -160F, -22F);

        body[278].addShapeBox(0F, 0F, 0F, 4, 2, 20, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 891
        body[278].setRotationPoint(10F, -160F, -10F);

        body[279].addShapeBox(0F, 0F, 0F, 4, 2, 20, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 892
        body[279].setRotationPoint(-14F, -160F, -10F);

        body[280].addShapeBox(0F, 0F, 0F, 4, 2, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 932
        body[280].setRotationPoint(-64F, -160F, -22F);

        body[281].addShapeBox(0F, 0F, 0F, 4, 2, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 933
        body[281].setRotationPoint(-64F, -160F, 14F);

        body[282].addShapeBox(0F, 0F, 0F, 4, 2, 20, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 934
        body[282].setRotationPoint(-64F, -160F, -10F);

        body[283].addShapeBox(0F, 0F, 0F, 4, 2, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 935
        body[283].setRotationPoint(60F, -160F, -22F);

        body[284].addShapeBox(0F, 0F, 0F, 4, 2, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 936
        body[284].setRotationPoint(60F, -160F, 14F);

        body[285].addShapeBox(0F, 0F, 0F, 4, 2, 20, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 937
        body[285].setRotationPoint(60F, -160F, -10F);

        body[286].addShapeBox(0F, 0F, 0F, 3, 8, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 934
        body[286].setRotationPoint(-50F, -168F, 12F);

        body[287].addShapeBox(0F, 0F, 0F, 3, 8, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 935
        body[287].setRotationPoint(-50F, -168F, -14F);

        body[288].addShapeBox(0F, 0F, 0F, 3, 8, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 936
        body[288].setRotationPoint(-50F, -168F, 22F);

        body[289].addShapeBox(0F, 0F, 0F, 3, 8, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 937
        body[289].setRotationPoint(-50F, -168F, -24F);

        body[290].addShapeBox(0F, 0F, 0F, 3, 3, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 938
        body[290].setRotationPoint(-49F, -167F, 14F);

        body[291].addShapeBox(0F, 0F, 0F, 3, 3, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 939
        body[291].setRotationPoint(-49F, -167F, -22F);

        body[292].addShapeBox(0F, 0F, 0F, 1, 3, 8, 0F, 0F, 0F, 0F, -0.5F, -1F, 0F, -0.5F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -1F, 0F, -0.5F, -1F, 0F, 0F, 0F, 0F); // Box 940
        body[292].setRotationPoint(-47F, -167F, 14F);

        body[293].addShapeBox(0F, 0F, 0F, 1, 3, 8, 0F, 0F, 0F, 0F, -0.5F, -1F, 0F, -0.5F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -1F, 0F, -0.5F, -1F, 0F, 0F, 0F, 0F); // Box 941
        body[293].setRotationPoint(-47F, -167F, -22F);

        body[294].addShapeBox(0F, 0F, 0F, 3, 1, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -0.5F, 0F, -1F, -0.5F, 0F, -1F, -0.5F, 0F, -1F, -0.5F, 0F); // Box 942
        body[294].setRotationPoint(-50F, -164F, 14F);

        body[295].addShapeBox(0F, 0F, 0F, 3, 1, 8, 0F, -1F, -0.5F, 0F, -1F, -0.5F, 0F, -1F, -0.5F, 0F, -1F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 943
        body[295].setRotationPoint(-50F, -168F, -22F);

        body[296].addShapeBox(0F, 0F, 0F, 1, 3, 8, 0F, -0.5F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -1F, 0F, -0.5F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -1F, 0F); // Box 944
        body[296].setRotationPoint(-51F, -167F, -22F);

        body[297].addShapeBox(0F, 0F, 0F, 3, 1, 8, 0F, -1F, -0.5F, 0F, -1F, -0.5F, 0F, -1F, -0.5F, 0F, -1F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 945
        body[297].setRotationPoint(-50F, -168F, 14F);

        body[298].addShapeBox(0F, 0F, 0F, 1, 3, 8, 0F, -0.5F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -1F, 0F, -0.5F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -1F, 0F); // Box 946
        body[298].setRotationPoint(-51F, -167F, 14F);

        body[299].addShapeBox(0F, 0F, 0F, 3, 1, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -0.5F, 0F, -1F, -0.5F, 0F, -1F, -0.5F, 0F, -1F, -0.5F, 0F); // Box 947
        body[299].setRotationPoint(-50F, -164F, -22F);

        body[300].addShapeBox(0F, 0F, 0F, 3, 1, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 948
        body[300].setRotationPoint(-54F, -159.5F, -22F);

        body[301].addShapeBox(0F, 0F, 0F, 3, 1, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 949
        body[301].setRotationPoint(-54F, -159.5F, 14F);

        body[302].addShapeBox(0F, 0F, 0F, 3, 8, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 951
        body[302].setRotationPoint(47F, -168F, 12F);

        body[303].addShapeBox(0F, 0F, 0F, 3, 8, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 952
        body[303].setRotationPoint(47F, -168F, 22F);

        body[304].addShapeBox(0F, 0F, 0F, 1, 3, 8, 0F, -0.5F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -1F, 0F, -0.5F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -1F, 0F); // Box 953
        body[304].setRotationPoint(46F, -167F, 14F);

        body[305].addShapeBox(0F, 0F, 0F, 3, 1, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -0.5F, 0F, -1F, -0.5F, 0F, -1F, -0.5F, 0F, -1F, -0.5F, 0F); // Box 954
        body[305].setRotationPoint(47F, -164F, 14F);

        body[306].addShapeBox(0F, 0F, 0F, 3, 1, 8, 0F, -1F, -0.5F, 0F, -1F, -0.5F, 0F, -1F, -0.5F, 0F, -1F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 955
        body[306].setRotationPoint(47F, -168F, 14F);

        body[307].addShapeBox(0F, 0F, 0F, 1, 3, 8, 0F, 0F, 0F, 0F, -0.5F, -1F, 0F, -0.5F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -1F, 0F, -0.5F, -1F, 0F, 0F, 0F, 0F); // Box 956
        body[307].setRotationPoint(50F, -167F, 14F);

        body[308].addShapeBox(0F, 0F, 0F, 3, 1, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 957
        body[308].setRotationPoint(51F, -159.5F, 14F);

        body[309].addShapeBox(0F, 0F, 0F, 3, 8, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 958
        body[309].setRotationPoint(47F, -168F, -14F);

        body[310].addShapeBox(0F, 0F, 0F, 3, 8, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 959
        body[310].setRotationPoint(47F, -168F, -24F);

        body[311].addShapeBox(0F, 0F, 0F, 1, 3, 8, 0F, -0.5F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -1F, 0F, -0.5F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -1F, 0F); // Box 960
        body[311].setRotationPoint(46F, -167F, -22F);

        body[312].addShapeBox(0F, 0F, 0F, 3, 1, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -0.5F, 0F, -1F, -0.5F, 0F, -1F, -0.5F, 0F, -1F, -0.5F, 0F); // Box 961
        body[312].setRotationPoint(47F, -164F, -22F);

        body[313].addShapeBox(0F, 0F, 0F, 3, 1, 8, 0F, -1F, -0.5F, 0F, -1F, -0.5F, 0F, -1F, -0.5F, 0F, -1F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 962
        body[313].setRotationPoint(47F, -168F, -22F);

        body[314].addShapeBox(0F, 0F, 0F, 1, 3, 8, 0F, 0F, 0F, 0F, -0.5F, -1F, 0F, -0.5F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -1F, 0F, -0.5F, -1F, 0F, 0F, 0F, 0F); // Box 963
        body[314].setRotationPoint(50F, -167F, -22F);

        body[315].addShapeBox(0F, 0F, 0F, 3, 1, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 964
        body[315].setRotationPoint(51F, -159.5F, -22F);

        body[316].addShapeBox(0F, 0F, 0F, 28, 4, 14, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 965
        body[316].setRotationPoint(-14F, -164F, -25F);

        body[317].addShapeBox(0F, 0F, 0F, 28, 4, 14, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 966
        body[317].setRotationPoint(-14F, -164F, 11F);

        body[318].addShapeBox(0F, 0F, 0F, 1, 1, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 967
        body[318].setRotationPoint(-14F, -165F, -25F);

        body[319].addShapeBox(0F, 0F, 0F, 1, 1, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 968
        body[319].setRotationPoint(-14F, -165F, 19F);

        body[320].addShapeBox(0F, 0F, 0F, 1, 1, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 969
        body[320].setRotationPoint(-6F, -165F, -25F);

        body[321].addShapeBox(0F, 0F, 0F, 1, 1, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 970
        body[321].setRotationPoint(-6F, -165F, 19F);

        body[322].addShapeBox(0F, 0F, 0F, 7, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 971
        body[322].setRotationPoint(-13F, -165F, -25F);

        body[323].addShapeBox(0F, 0F, 0F, 7, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 972
        body[323].setRotationPoint(-13F, -165F, 24F);

        body[324].addShapeBox(0F, 0F, 0F, 7, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 973
        body[324].setRotationPoint(-13F, -165F, -20F);

        body[325].addShapeBox(0F, 0F, 0F, 7, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 974
        body[325].setRotationPoint(-13F, -165F, 19F);

        body[326].addShapeBox(0F, 0F, 0F, 1, 1, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 975
        body[326].setRotationPoint(13F, -165F, 19F);

        body[327].addShapeBox(0F, 0F, 0F, 1, 1, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 976
        body[327].setRotationPoint(5F, -165F, 19F);

        body[328].addShapeBox(0F, 0F, 0F, 7, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 977
        body[328].setRotationPoint(6F, -165F, 24F);

        body[329].addShapeBox(0F, 0F, 0F, 7, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 978
        body[329].setRotationPoint(6F, -165F, 19F);

        body[330].addShapeBox(0F, 0F, 0F, 1, 1, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 979
        body[330].setRotationPoint(13F, -165F, -25F);

        body[331].addShapeBox(0F, 0F, 0F, 1, 1, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 980
        body[331].setRotationPoint(5F, -165F, -25F);

        body[332].addShapeBox(0F, 0F, 0F, 7, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 981
        body[332].setRotationPoint(6F, -165F, -25F);

        body[333].addShapeBox(0F, 0F, 0F, 7, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 982
        body[333].setRotationPoint(6F, -165F, -20F);

        body[334].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F); // Box 983
        body[334].setRotationPoint(6F, -165F, 20F);

        body[335].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F); // Box 984
        body[335].setRotationPoint(6F, -165F, -24F);

        body[336].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F); // Box 985
        body[336].setRotationPoint(7F, -165F, 20F);

        body[337].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F); // Box 986
        body[337].setRotationPoint(7F, -165F, -24F);

        body[338].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F); // Box 987
        body[338].setRotationPoint(8F, -165F, 20F);

        body[339].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F); // Box 988
        body[339].setRotationPoint(8F, -165F, -24F);

        body[340].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F); // Box 989
        body[340].setRotationPoint(9F, -165F, 20F);

        body[341].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F); // Box 990
        body[341].setRotationPoint(9F, -165F, -24F);

        body[342].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F); // Box 991
        body[342].setRotationPoint(10F, -165F, 20F);

        body[343].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F); // Box 992
        body[343].setRotationPoint(10F, -165F, -24F);

        body[344].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F); // Box 993
        body[344].setRotationPoint(11F, -165F, 20F);

        body[345].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F); // Box 994
        body[345].setRotationPoint(11F, -165F, -24F);

        body[346].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F); // Box 995
        body[346].setRotationPoint(12F, -165F, 20F);

        body[347].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F); // Box 996
        body[347].setRotationPoint(12F, -165F, -24F);

        body[348].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F); // Box 997
        body[348].setRotationPoint(5.5F, -165F, 20F);

        body[349].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F); // Box 998
        body[349].setRotationPoint(6.5F, -165F, 20F);

        body[350].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F); // Box 999
        body[350].setRotationPoint(7.5F, -165F, 20F);

        body[351].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F); // Box 1000
        body[351].setRotationPoint(8.5F, -165F, 20F);

        body[352].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F); // Box 1001
        body[352].setRotationPoint(9.5F, -165F, 20F);

        body[353].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F); // Box 1002
        body[353].setRotationPoint(10.5F, -165F, 20F);

        body[354].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F); // Box 1003
        body[354].setRotationPoint(11.5F, -165F, 20F);

        body[355].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F); // Box 1004
        body[355].setRotationPoint(5.5F, -165F, -24F);

        body[356].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F); // Box 1005
        body[356].setRotationPoint(6.5F, -165F, -24F);

        body[357].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F); // Box 1006
        body[357].setRotationPoint(7.5F, -165F, -24F);

        body[358].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F); // Box 1007
        body[358].setRotationPoint(8.5F, -165F, -24F);

        body[359].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F); // Box 1008
        body[359].setRotationPoint(9.5F, -165F, -24F);

        body[360].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F); // Box 1009
        body[360].setRotationPoint(10.5F, -165F, -24F);

        body[361].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F); // Box 1010
        body[361].setRotationPoint(11.5F, -165F, -24F);

        body[362].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F); // Box 1011
        body[362].setRotationPoint(-7F, -165F, -24F);

        body[363].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F); // Box 1012
        body[363].setRotationPoint(-8F, -165F, -24F);

        body[364].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F); // Box 1013
        body[364].setRotationPoint(-9F, -165F, -24F);

        body[365].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F); // Box 1014
        body[365].setRotationPoint(-10F, -165F, -24F);

        body[366].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F); // Box 1015
        body[366].setRotationPoint(-11F, -165F, -24F);

        body[367].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F); // Box 1016
        body[367].setRotationPoint(-12F, -165F, -24F);

        body[368].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F); // Box 1017
        body[368].setRotationPoint(-6.5F, -165F, -24F);

        body[369].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F); // Box 1018
        body[369].setRotationPoint(-7.5F, -165F, -24F);

        body[370].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F); // Box 1019
        body[370].setRotationPoint(-8.5F, -165F, -24F);

        body[371].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F); // Box 1020
        body[371].setRotationPoint(-9.5F, -165F, -24F);

        body[372].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F); // Box 1021
        body[372].setRotationPoint(-10.5F, -165F, -24F);

        body[373].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F); // Box 1022
        body[373].setRotationPoint(-11.5F, -165F, -24F);

        body[374].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F); // Box 1023
        body[374].setRotationPoint(-12.5F, -165F, -24F);

        body[375].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F); // Box 1024
        body[375].setRotationPoint(-7F, -165F, 20F);

        body[376].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F); // Box 1025
        body[376].setRotationPoint(-8F, -165F, 20F);

        body[377].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F); // Box 1026
        body[377].setRotationPoint(-9F, -165F, 20F);

        body[378].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F); // Box 1027
        body[378].setRotationPoint(-10F, -165F, 20F);

        body[379].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F); // Box 1028
        body[379].setRotationPoint(-11F, -165F, 20F);

        body[380].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F); // Box 1029
        body[380].setRotationPoint(-12F, -165F, 20F);

        body[381].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F); // Box 1030
        body[381].setRotationPoint(-6.5F, -165F, 20F);

        body[382].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F); // Box 1031
        body[382].setRotationPoint(-7.5F, -165F, 20F);

        body[383].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F); // Box 1032
        body[383].setRotationPoint(-8.5F, -165F, 20F);

        body[384].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F); // Box 1033
        body[384].setRotationPoint(-9.5F, -165F, 20F);

        body[385].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F); // Box 1034
        body[385].setRotationPoint(-10.5F, -165F, 20F);

        body[386].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F); // Box 1035
        body[386].setRotationPoint(-11.5F, -165F, 20F);

        body[387].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.75F, 0F, 0F); // Box 1036
        body[387].setRotationPoint(-12.5F, -165F, 20F);

        body[388].addShapeBox(0F, 0F, 0F, 4, 6, 1, 0F, -4F, 0F, 0F, 0F, -1.5F, 0F, 0F, -1.5F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F); // Box 1037
        body[388].setRotationPoint(-54F, -166F, 22.5F);

        body[389].addShapeBox(0F, 0F, 0F, 4, 6, 1, 0F, -4F, 0F, 0F, 0F, -1.5F, 0F, 0F, -1.5F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F); // Box 1038
        body[389].setRotationPoint(-54F, -166F, -23.5F);

        body[390].addShapeBox(0F, 0F, 0F, 4, 6, 1, 0F, -4F, 0F, 0F, 0F, -1.5F, 0F, 0F, -1.5F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F); // Box 1039
        body[390].setRotationPoint(-54F, -166F, 12.5F);

        body[391].addShapeBox(0F, 0F, 0F, 4, 6, 1, 0F, 0F, -1.5F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, -1.5F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F); // Box 1040
        body[391].setRotationPoint(50F, -166F, 22.5F);

        body[392].addShapeBox(0F, 0F, 0F, 4, 6, 1, 0F, 0F, -1.5F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, -1.5F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F); // Box 1041
        body[392].setRotationPoint(50F, -166F, 12.5F);

        body[393].addShapeBox(0F, 0F, 0F, 4, 6, 1, 0F, 0F, -1.5F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, -1.5F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F); // Box 1042
        body[393].setRotationPoint(50F, -166F, -23.5F);

        body[394].addShapeBox(0F, 0F, 0F, 4, 6, 1, 0F, 0F, -1.5F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 0F, -1.5F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F); // Box 1043
        body[394].setRotationPoint(50F, -166F, -13.5F);

        body[395].addShapeBox(0F, 0F, 0F, 4, 6, 1, 0F, -4F, 0F, 0F, 0F, -1.5F, 0F, 0F, -1.5F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F); // Box 1061
        body[395].setRotationPoint(-54F, -166F, -13.5F);
        this.add("body", body); this.body = this.get("body");

        ModelRendererTurbo[] wheels_import = new ModelRendererTurbo[16];
        wheels_import[0] = new ModelRendererTurbo(this, 857, 17, textureX, textureY); // Box 147
        wheels_import[1] = new ModelRendererTurbo(this, 881, 17, textureX, textureY); // Box 148
        wheels_import[2] = new ModelRendererTurbo(this, 921, 17, textureX, textureY); // Box 149
        wheels_import[3] = new ModelRendererTurbo(this, 705, 25, textureX, textureY); // Box 150
        wheels_import[4] = new ModelRendererTurbo(this, 953, 17, textureX, textureY); // Box 152
        wheels_import[5] = new ModelRendererTurbo(this, 969, 17, textureX, textureY); // Box 154
        wheels_import[6] = new ModelRendererTurbo(this, 729, 25, textureX, textureY); // Box 156
        wheels_import[7] = new ModelRendererTurbo(this, 777, 25, textureX, textureY); // Box 158
        wheels_import[8] = new ModelRendererTurbo(this, 953, 17, textureX, textureY); // Box 1053
        wheels_import[9] = new ModelRendererTurbo(this, 729, 25, textureX, textureY); // Box 1054
        wheels_import[10] = new ModelRendererTurbo(this, 777, 25, textureX, textureY); // Box 1055
        wheels_import[11] = new ModelRendererTurbo(this, 969, 17, textureX, textureY); // Box 1056
        wheels_import[12] = new ModelRendererTurbo(this, 857, 17, textureX, textureY); // Box 1057
        wheels_import[13] = new ModelRendererTurbo(this, 921, 17, textureX, textureY); // Box 1058
        wheels_import[14] = new ModelRendererTurbo(this, 881, 17, textureX, textureY); // Box 1059
        wheels_import[15] = new ModelRendererTurbo(this, 705, 25, textureX, textureY); // Box 1060

        wheels_import[0].addBox(0F, 0F, 0F, 3, 2, 12, 0F); // Box 147
        wheels_import[0].setRotationPoint(5F, -2F, -118F);

        wheels_import[1].addBox(0F, 0F, 0F, 16, 2, 2, 0F); // Box 148
        wheels_import[1].setRotationPoint(-8F, -4F, -109F);

        wheels_import[2].addBox(0F, 0F, 0F, 16, 2, 2, 0F); // Box 149
        wheels_import[2].setRotationPoint(-8F, -4F, -117F);

        wheels_import[3].addBox(0F, 0F, 0F, 16, 2, 2, 0F); // Box 150
        wheels_import[3].setRotationPoint(-8F, -4F, -113F);

        wheels_import[4].addBox(0F, 0F, 0F, 3, 2, 12, 0F); // Box 152
        wheels_import[4].setRotationPoint(-8F, -2F, -118F);

        wheels_import[5].addShapeBox(0F, 0F, 0F, 3, 2, 16, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 154
        wheels_import[5].setRotationPoint(2F, -2F, -120F);

        wheels_import[6].addShapeBox(0F, 0F, 0F, 3, 2, 16, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 156
        wheels_import[6].setRotationPoint(-5F, -2F, -120F);

        wheels_import[7].addBox(0F, 0F, 0F, 4, 2, 12, 0F); // Box 158
        wheels_import[7].setRotationPoint(-2F, -2F, -118F);

        wheels_import[8].addBox(0F, 0F, 0F, 3, 2, 12, 0F); // Box 1053
        wheels_import[8].setRotationPoint(-8F, -2F, 106F);

        wheels_import[9].addShapeBox(0F, 0F, 0F, 3, 2, 16, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 1054
        wheels_import[9].setRotationPoint(-5F, -2F, 104F);

        wheels_import[10].addBox(0F, 0F, 0F, 4, 2, 12, 0F); // Box 1055
        wheels_import[10].setRotationPoint(-2F, -2F, 106F);

        wheels_import[11].addShapeBox(0F, 0F, 0F, 3, 2, 16, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 1056
        wheels_import[11].setRotationPoint(2F, -2F, 104F);

        wheels_import[12].addBox(0F, 0F, 0F, 3, 2, 12, 0F); // Box 1057
        wheels_import[12].setRotationPoint(5F, -2F, 106F);

        wheels_import[13].addBox(0F, 0F, 0F, 16, 2, 2, 0F); // Box 1058
        wheels_import[13].setRotationPoint(-8F, -4F, 107F);

        wheels_import[14].addBox(0F, 0F, 0F, 16, 2, 2, 0F); // Box 1059
        wheels_import[14].setRotationPoint(-8F, -4F, 115F);

        wheels_import[15].addBox(0F, 0F, 0F, 16, 2, 2, 0F); // Box 1060
        wheels_import[15].setRotationPoint(-8F, -4F, 111F);
        this.add("wheels_import", wheels_import); this.rail_piece = this.get("wheels_import");
        
        ModelRendererTurbo[] turret = new ModelRendererTurbo[132];
        turret[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 2
        turret[1] = new ModelRendererTurbo(this, 113, 1, textureX, textureY); // Box 3
        turret[2] = new ModelRendererTurbo(this, 177, 1, textureX, textureY); // Box 4
        turret[3] = new ModelRendererTurbo(this, 369, 1, textureX, textureY); // Box 5
        turret[4] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 6
        turret[5] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 7
        turret[6] = new ModelRendererTurbo(this, 65, 1, textureX, textureY); // Box 9
        turret[7] = new ModelRendererTurbo(this, 89, 1, textureX, textureY); // Box 10
        turret[8] = new ModelRendererTurbo(this, 113, 1, textureX, textureY); // Box 11
        turret[9] = new ModelRendererTurbo(this, 137, 1, textureX, textureY); // Box 12
        turret[10] = new ModelRendererTurbo(this, 561, 1, textureX, textureY); // Box 13
        turret[11] = new ModelRendererTurbo(this, 585, 1, textureX, textureY); // Box 14
        turret[12] = new ModelRendererTurbo(this, 601, 1, textureX, textureY); // Box 15
        turret[13] = new ModelRendererTurbo(this, 625, 1, textureX, textureY); // Box 16
        turret[14] = new ModelRendererTurbo(this, 641, 1, textureX, textureY); // Box 17
        turret[15] = new ModelRendererTurbo(this, 665, 1, textureX, textureY); // Box 18
        turret[16] = new ModelRendererTurbo(this, 681, 1, textureX, textureY); // Box 19
        turret[17] = new ModelRendererTurbo(this, 705, 1, textureX, textureY); // Box 20
        turret[18] = new ModelRendererTurbo(this, 721, 1, textureX, textureY); // Box 21
        turret[19] = new ModelRendererTurbo(this, 737, 1, textureX, textureY); // Box 22
        turret[20] = new ModelRendererTurbo(this, 761, 1, textureX, textureY); // Box 23
        turret[21] = new ModelRendererTurbo(this, 785, 1, textureX, textureY); // Box 24
        turret[22] = new ModelRendererTurbo(this, 809, 1, textureX, textureY); // Box 25
        turret[23] = new ModelRendererTurbo(this, 833, 1, textureX, textureY); // Box 26
        turret[24] = new ModelRendererTurbo(this, 849, 1, textureX, textureY); // Box 27
        turret[25] = new ModelRendererTurbo(this, 865, 1, textureX, textureY); // Box 28
        turret[26] = new ModelRendererTurbo(this, 881, 1, textureX, textureY); // Box 29
        turret[27] = new ModelRendererTurbo(this, 897, 1, textureX, textureY); // Box 30
        turret[28] = new ModelRendererTurbo(this, 913, 1, textureX, textureY); // Box 33
        turret[29] = new ModelRendererTurbo(this, 929, 1, textureX, textureY); // Box 34
        turret[30] = new ModelRendererTurbo(this, 945, 1, textureX, textureY); // Box 35
        turret[31] = new ModelRendererTurbo(this, 961, 1, textureX, textureY); // Box 36
        turret[32] = new ModelRendererTurbo(this, 977, 1, textureX, textureY); // Box 37
        turret[33] = new ModelRendererTurbo(this, 993, 1, textureX, textureY); // Box 38
        turret[34] = new ModelRendererTurbo(this, 1009, 1, textureX, textureY); // Box 39
        turret[35] = new ModelRendererTurbo(this, 1, 9, textureX, textureY); // Box 40
        turret[36] = new ModelRendererTurbo(this, 17, 9, textureX, textureY); // Box 41
        turret[37] = new ModelRendererTurbo(this, 33, 9, textureX, textureY); // Box 42
        turret[38] = new ModelRendererTurbo(this, 65, 9, textureX, textureY); // Box 43
        turret[39] = new ModelRendererTurbo(this, 81, 9, textureX, textureY); // Box 44
        turret[40] = new ModelRendererTurbo(this, 97, 9, textureX, textureY); // Box 45
        turret[41] = new ModelRendererTurbo(this, 113, 9, textureX, textureY); // Box 46
        turret[42] = new ModelRendererTurbo(this, 129, 9, textureX, textureY); // Box 47
        turret[43] = new ModelRendererTurbo(this, 145, 9, textureX, textureY); // Box 48
        turret[44] = new ModelRendererTurbo(this, 561, 9, textureX, textureY); // Box 49
        turret[45] = new ModelRendererTurbo(this, 577, 9, textureX, textureY); // Box 50
        turret[46] = new ModelRendererTurbo(this, 625, 9, textureX, textureY); // Box 51
        turret[47] = new ModelRendererTurbo(this, 665, 9, textureX, textureY); // Box 52
        turret[48] = new ModelRendererTurbo(this, 705, 9, textureX, textureY); // Box 53
        turret[49] = new ModelRendererTurbo(this, 745, 9, textureX, textureY); // Box 54
        turret[50] = new ModelRendererTurbo(this, 761, 9, textureX, textureY); // Box 55
        turret[51] = new ModelRendererTurbo(this, 777, 9, textureX, textureY); // Box 56
        turret[52] = new ModelRendererTurbo(this, 793, 9, textureX, textureY); // Box 57
        turret[53] = new ModelRendererTurbo(this, 809, 9, textureX, textureY); // Box 58
        turret[54] = new ModelRendererTurbo(this, 825, 9, textureX, textureY); // Box 59
        turret[55] = new ModelRendererTurbo(this, 841, 9, textureX, textureY); // Box 60
        turret[56] = new ModelRendererTurbo(this, 865, 9, textureX, textureY); // Box 62
        turret[57] = new ModelRendererTurbo(this, 881, 9, textureX, textureY); // Box 63
        turret[58] = new ModelRendererTurbo(this, 897, 9, textureX, textureY); // Box 64
        turret[59] = new ModelRendererTurbo(this, 913, 9, textureX, textureY); // Box 65
        turret[60] = new ModelRendererTurbo(this, 929, 9, textureX, textureY); // Box 66
        turret[61] = new ModelRendererTurbo(this, 945, 9, textureX, textureY); // Box 67
        turret[62] = new ModelRendererTurbo(this, 961, 9, textureX, textureY); // Box 68
        turret[63] = new ModelRendererTurbo(this, 977, 9, textureX, textureY); // Box 69
        turret[64] = new ModelRendererTurbo(this, 993, 9, textureX, textureY); // Box 70
        turret[65] = new ModelRendererTurbo(this, 1009, 9, textureX, textureY); // Box 71
        turret[66] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 72
        turret[67] = new ModelRendererTurbo(this, 17, 17, textureX, textureY); // Box 73
        turret[68] = new ModelRendererTurbo(this, 33, 17, textureX, textureY); // Box 74
        turret[69] = new ModelRendererTurbo(this, 65, 17, textureX, textureY); // Box 75
        turret[70] = new ModelRendererTurbo(this, 81, 17, textureX, textureY); // Box 76
        turret[71] = new ModelRendererTurbo(this, 97, 17, textureX, textureY); // Box 77
        turret[72] = new ModelRendererTurbo(this, 545, 9, textureX, textureY); // Box 78
        turret[73] = new ModelRendererTurbo(this, 185, 17, textureX, textureY); // Box 80
        turret[74] = new ModelRendererTurbo(this, 113, 17, textureX, textureY); // Box 81
        turret[75] = new ModelRendererTurbo(this, 177, 17, textureX, textureY); // Box 82
        turret[76] = new ModelRendererTurbo(this, 241, 17, textureX, textureY); // Box 89
        turret[77] = new ModelRendererTurbo(this, 345, 17, textureX, textureY); // Box 90
        turret[78] = new ModelRendererTurbo(this, 449, 17, textureX, textureY); // Box 91
        turret[79] = new ModelRendererTurbo(this, 601, 17, textureX, textureY); // Box 92
        turret[80] = new ModelRendererTurbo(this, 241, 17, textureX, textureY); // Box 93
        turret[81] = new ModelRendererTurbo(this, 329, 17, textureX, textureY); // Box 94
        turret[82] = new ModelRendererTurbo(this, 345, 17, textureX, textureY); // Box 95
        turret[83] = new ModelRendererTurbo(this, 433, 17, textureX, textureY); // Box 96
        turret[84] = new ModelRendererTurbo(this, 449, 17, textureX, textureY); // Box 100
        turret[85] = new ModelRendererTurbo(this, 537, 17, textureX, textureY); // Box 104
        turret[86] = new ModelRendererTurbo(this, 553, 17, textureX, textureY); // Box 106
        turret[87] = new ModelRendererTurbo(this, 569, 17, textureX, textureY); // Box 107
        turret[88] = new ModelRendererTurbo(this, 601, 17, textureX, textureY); // Box 108
        turret[89] = new ModelRendererTurbo(this, 689, 17, textureX, textureY); // Box 109
        turret[90] = new ModelRendererTurbo(this, 705, 17, textureX, textureY); // Box 110
        turret[91] = new ModelRendererTurbo(this, 721, 17, textureX, textureY); // Box 111
        turret[92] = new ModelRendererTurbo(this, 737, 17, textureX, textureY); // Box 112
        turret[93] = new ModelRendererTurbo(this, 753, 17, textureX, textureY); // Box 113
        turret[94] = new ModelRendererTurbo(this, 769, 17, textureX, textureY); // Box 114
        turret[95] = new ModelRendererTurbo(this, 785, 17, textureX, textureY); // Box 115
        turret[96] = new ModelRendererTurbo(this, 801, 17, textureX, textureY); // Box 116
        turret[97] = new ModelRendererTurbo(this, 817, 17, textureX, textureY); // Box 117
        turret[98] = new ModelRendererTurbo(this, 833, 17, textureX, textureY); // Box 118
        turret[99] = new ModelRendererTurbo(this, 849, 17, textureX, textureY); // Box 119
        turret[100] = new ModelRendererTurbo(this, 57, 185, textureX, textureY); // Box 895
        turret[101] = new ModelRendererTurbo(this, 953, 185, textureX, textureY); // Box 896
        turret[102] = new ModelRendererTurbo(this, 17, 193, textureX, textureY); // Box 897
        turret[103] = new ModelRendererTurbo(this, 1, 209, textureX, textureY); // Box 898
        turret[104] = new ModelRendererTurbo(this, 321, 209, textureX, textureY); // Box 899
        turret[105] = new ModelRendererTurbo(this, 49, 217, textureX, textureY); // Box 900
        turret[106] = new ModelRendererTurbo(this, 481, 193, textureX, textureY); // Box 901
        turret[107] = new ModelRendererTurbo(this, 41, 201, textureX, textureY); // Box 902
        turret[108] = new ModelRendererTurbo(this, 857, 201, textureX, textureY); // Box 903
        turret[109] = new ModelRendererTurbo(this, 889, 201, textureX, textureY); // Box 904
        turret[110] = new ModelRendererTurbo(this, 905, 217, textureX, textureY); // Box 906
        turret[111] = new ModelRendererTurbo(this, 873, 249, textureX, textureY); // Box 907
        turret[112] = new ModelRendererTurbo(this, 953, 257, textureX, textureY); // Box 908
        turret[113] = new ModelRendererTurbo(this, 857, 265, textureX, textureY); // Box 909
        turret[114] = new ModelRendererTurbo(this, 937, 201, textureX, textureY); // Box 910
        turret[115] = new ModelRendererTurbo(this, 969, 209, textureX, textureY); // Box 911
        turret[116] = new ModelRendererTurbo(this, 905, 201, textureX, textureY); // Box 912
        turret[117] = new ModelRendererTurbo(this, 873, 265, textureX, textureY); // Box 913
        turret[118] = new ModelRendererTurbo(this, 889, 265, textureX, textureY); // Box 914
        turret[119] = new ModelRendererTurbo(this, 33, 233, textureX, textureY); // Box 915
        turret[120] = new ModelRendererTurbo(this, 857, 233, textureX, textureY); // Box 916
        turret[121] = new ModelRendererTurbo(this, 921, 265, textureX, textureY); // Box 917
        turret[122] = new ModelRendererTurbo(this, 489, 273, textureX, textureY); // Box 918
        turret[123] = new ModelRendererTurbo(this, 889, 233, textureX, textureY); // Box 919
        turret[124] = new ModelRendererTurbo(this, 1, 265, textureX, textureY); // Box 920
        turret[125] = new ModelRendererTurbo(this, 505, 273, textureX, textureY); // Box 921
        turret[126] = new ModelRendererTurbo(this, 569, 273, textureX, textureY); // Box 922
        turret[127] = new ModelRendererTurbo(this, 585, 273, textureX, textureY); // Box 923
        turret[128] = new ModelRendererTurbo(this, 601, 273, textureX, textureY); // Box 924
        turret[129] = new ModelRendererTurbo(this, 617, 273, textureX, textureY); // Box 925
        turret[130] = new ModelRendererTurbo(this, 641, 273, textureX, textureY); // Box 926
        turret[131] = new ModelRendererTurbo(this, 713, 273, textureX, textureY); // Box 927

        turret[0].addBox(0F, 0F, 0F, 4, 4, 50, 0F); // Box 2
        turret[0].setRotationPoint(45F, -52F, -25F);

        turret[1].addBox(0F, 0F, 0F, 4, 4, 50, 0F); // Box 3
        turret[1].setRotationPoint(-49F, -52F, -25F);

        turret[2].addBox(0F, 0F, 0F, 90, 4, 4, 0F); // Box 4
        turret[2].setRotationPoint(-45F, -52F, -25F);

        turret[3].addBox(0F, 0F, 0F, 90, 4, 4, 0F); // Box 5
        turret[3].setRotationPoint(-45F, -52F, 21F);

        turret[4].addShapeBox(0F, 0F, 0F, 6, 2, 2, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 6
        turret[4].setRotationPoint(-48F, -48F, -26F);

        turret[5].addShapeBox(0F, 0F, 0F, 6, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 7
        turret[5].setRotationPoint(-48F, -48F, 24F);

        turret[6].addShapeBox(0F, 0F, 0F, 8, 4, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 9
        turret[6].setRotationPoint(-48F, -46F, 24F);

        turret[7].addShapeBox(0F, 0F, 0F, 6, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 10
        turret[7].setRotationPoint(42F, -48F, 24F);

        turret[8].addShapeBox(0F, 0F, 0F, 6, 2, 2, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 11
        turret[8].setRotationPoint(42F, -48F, -26F);

        turret[9].addShapeBox(0F, 0F, 0F, 8, 4, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 12
        turret[9].setRotationPoint(40F, -46F, 24F);

        turret[10].addShapeBox(0F, 0F, 0F, 8, 4, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 13
        turret[10].setRotationPoint(40F, -46F, -26F);

        turret[11].addShapeBox(0F, 0F, 0F, 2, 2, 4, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 14
        turret[11].setRotationPoint(48F, -48F, 20F);

        turret[12].addShapeBox(0F, 0F, 0F, 2, 4, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 15
        turret[12].setRotationPoint(48F, -46F, 18F);

        turret[13].addShapeBox(0F, 0F, 0F, 2, 2, 4, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 16
        turret[13].setRotationPoint(48F, -48F, -24F);

        turret[14].addShapeBox(0F, 0F, 0F, 2, 4, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 17
        turret[14].setRotationPoint(48F, -46F, -24F);

        turret[15].addShapeBox(0F, 0F, 0F, 2, 2, 4, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 18
        turret[15].setRotationPoint(-50F, -48F, -24F);

        turret[16].addShapeBox(0F, 0F, 0F, 2, 4, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 19
        turret[16].setRotationPoint(-50F, -46F, -24F);

        turret[17].addShapeBox(0F, 0F, 0F, 2, 2, 4, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 20
        turret[17].setRotationPoint(-50F, -48F, 20F);

        turret[18].addShapeBox(0F, 0F, 0F, 2, 4, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 21
        turret[18].setRotationPoint(-50F, -46F, 18F);

        turret[19].addShapeBox(0F, 0F, 0F, 6, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.25F, -0.5F, 0F, -1.25F, -0.5F); // Box 22
        turret[19].setRotationPoint(-48F, -42F, 24F);

        turret[20].addShapeBox(0F, 0F, 0F, 6, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.25F, -0.5F, 0F, -1.25F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 23
        turret[20].setRotationPoint(-48F, -42F, -26F);

        turret[21].addShapeBox(0F, 0F, 0F, 6, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.25F, -0.5F, 0F, -1.25F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 24
        turret[21].setRotationPoint(42F, -42F, -26F);

        turret[22].addShapeBox(0F, 0F, 0F, 6, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.25F, -0.5F, 0F, -1.25F, -0.5F); // Box 25
        turret[22].setRotationPoint(42F, -42F, 24F);

        turret[23].addShapeBox(0F, 0F, 0F, 2, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -1.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -1.25F, 0F); // Box 26
        turret[23].setRotationPoint(-50F, -42F, -24F);

        turret[24].addShapeBox(0F, 0F, 0F, 2, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -1.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -1.25F, 0F); // Box 27
        turret[24].setRotationPoint(-50F, -42F, 20F);

        turret[25].addShapeBox(0F, 0F, 0F, 2, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -1.25F, 0F, -0.5F, -1.25F, 0F, 0F, 0F, 0F); // Box 28
        turret[25].setRotationPoint(48F, -42F, 20F);

        turret[26].addShapeBox(0F, 0F, 0F, 2, 3, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -1.25F, 0F, -0.5F, -1.25F, 0F, 0F, 0F, 0F); // Box 29
        turret[26].setRotationPoint(48F, -42F, -24F);

        turret[27].addShapeBox(0F, 0F, 0F, 2, 4, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.625F, 0F, -0.625F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.625F, 0F, -0.625F); // Box 30
        turret[27].setRotationPoint(-50F, -46F, 24F);

        turret[28].addShapeBox(0F, 0F, 0F, 2, 4, 2, 0F, -0.625F, 0F, -0.625F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.625F, 0F, -0.625F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 33
        turret[28].setRotationPoint(-50F, -46F, -26F);

        turret[29].addShapeBox(0F, 0F, 0F, 2, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.625F, 0F, -0.625F, -0.5F, -1.25F, 0F, 0F, 0F, 0F, 0F, -1.25F, -0.5F, -0.625F, -2F, -0.625F); // Box 34
        turret[29].setRotationPoint(-50F, -42F, 24F);

        turret[30].addShapeBox(0F, 0F, 0F, 2, 3, 2, 0F, -0.625F, 0F, -0.625F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.625F, -2F, -0.625F, 0F, -1.25F, -0.5F, 0F, 0F, 0F, -0.5F, -1.25F, 0F); // Box 35
        turret[30].setRotationPoint(-50F, -42F, -26F);

        turret[31].addShapeBox(0F, 0F, 0F, 2, 4, 2, 0F, 0F, 0F, 0F, -0.625F, 0F, -0.625F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.625F, 0F, -0.625F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 36
        turret[31].setRotationPoint(48F, -46F, -26F);

        turret[32].addShapeBox(0F, 0F, 0F, 2, 4, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.625F, 0F, -0.625F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.625F, 0F, -0.625F, 0F, 0F, 0F); // Box 37
        turret[32].setRotationPoint(48F, -46F, 24F);

        turret[33].addShapeBox(0F, 0F, 0F, 2, 3, 2, 0F, 0F, 0F, 0F, -0.625F, 0F, -0.625F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.25F, -0.5F, -0.625F, -2F, -0.625F, -0.5F, -1.25F, 0F, 0F, 0F, 0F); // Box 38
        turret[33].setRotationPoint(48F, -42F, -26F);

        turret[34].addShapeBox(0F, 0F, 0F, 2, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.625F, 0F, -0.625F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -1.25F, 0F, -0.625F, -2F, -0.625F, 0F, -1.25F, -0.5F); // Box 39
        turret[34].setRotationPoint(48F, -42F, 24F);

        turret[35].addShapeBox(0F, 0F, 0F, 2, 2, 2, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, -0.625F, 0F, -0.625F, 0F, 0F, 0F); // Box 40
        turret[35].setRotationPoint(48F, -48F, 24F);

        turret[36].addShapeBox(0F, 0F, 0F, 2, 2, 2, 0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.625F, 0F, -0.625F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 41
        turret[36].setRotationPoint(48F, -48F, -26F);

        turret[37].addShapeBox(0F, 0F, 0F, 2, 2, 2, 0F, -1F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, -1F, 0F, 0F, -0.625F, 0F, -0.625F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 42
        turret[37].setRotationPoint(-50F, -48F, -26F);

        turret[38].addShapeBox(0F, 0F, 0F, 2, 2, 2, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.625F, 0F, -0.625F); // Box 43
        turret[38].setRotationPoint(-50F, -48F, 24F);

        turret[39].addShapeBox(0F, 0F, 0F, 2, 3, 2, 0F, -0.625F, 0F, -0.625F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.625F, -2F, -0.625F, 0F, -1.25F, -0.5F, 0F, 0F, 0F, -0.5F, -1.25F, 0F); // Box 44
        turret[39].setRotationPoint(-50F, -42F, 18F);

        turret[40].addShapeBox(0F, 0F, 0F, 2, 2, 2, 0F, -1F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, -1F, 0F, 0F, -0.625F, 0F, -0.625F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 45
        turret[40].setRotationPoint(-50F, -48F, 18F);

        turret[41].addShapeBox(0F, 0F, 0F, 2, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.625F, 0F, -0.625F, -0.5F, -1.25F, 0F, 0F, 0F, 0F, 0F, -1.25F, -0.5F, -0.625F, -2F, -0.625F); // Box 46
        turret[41].setRotationPoint(-50F, -42F, -20F);

        turret[42].addShapeBox(0F, 0F, 0F, 2, 2, 2, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.625F, 0F, -0.625F); // Box 47
        turret[42].setRotationPoint(-50F, -48F, -20F);

        turret[43].addShapeBox(0F, 0F, 0F, 2, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.625F, 0F, -0.625F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -1.25F, 0F, -0.625F, -2F, -0.625F, 0F, -1.25F, -0.5F); // Box 48
        turret[43].setRotationPoint(48F, -42F, -20F);

        turret[44].addShapeBox(0F, 0F, 0F, 2, 2, 2, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, -0.625F, 0F, -0.625F, 0F, 0F, 0F); // Box 49
        turret[44].setRotationPoint(48F, -48F, -20F);

        turret[45].addShapeBox(0F, 0F, 0F, 2, 3, 2, 0F, 0F, 0F, 0F, -0.625F, 0F, -0.625F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.25F, -0.5F, -0.625F, -2F, -0.625F, -0.5F, -1.25F, 0F, 0F, 0F, 0F); // Box 50
        turret[45].setRotationPoint(48F, -42F, 18F);

        turret[46].addShapeBox(0F, 0F, 0F, 2, 2, 2, 0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.625F, 0F, -0.625F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 51
        turret[46].setRotationPoint(48F, -48F, 18F);

        turret[47].addShapeBox(0F, 0F, 0F, 2, 3, 2, 0F, -0.625F, 0F, -0.625F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.625F, -2F, -0.625F, 0F, -1.25F, -0.5F, 0F, 0F, 0F, -0.5F, -1.25F, 0F); // Box 52
        turret[47].setRotationPoint(40F, -42F, -26F);

        turret[48].addShapeBox(0F, 0F, 0F, 2, 2, 2, 0F, -1F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, -1F, 0F, 0F, -0.625F, 0F, -0.625F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 53
        turret[48].setRotationPoint(40F, -48F, -26F);

        turret[49].addShapeBox(0F, 0F, 0F, 2, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.625F, 0F, -0.625F, -0.5F, -1.25F, 0F, 0F, 0F, 0F, 0F, -1.25F, -0.5F, -0.625F, -2F, -0.625F); // Box 54
        turret[49].setRotationPoint(40F, -42F, 24F);

        turret[50].addShapeBox(0F, 0F, 0F, 2, 2, 2, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.625F, 0F, -0.625F); // Box 55
        turret[50].setRotationPoint(40F, -48F, 24F);

        turret[51].addShapeBox(0F, 0F, 0F, 2, 3, 2, 0F, 0F, 0F, 0F, -0.625F, 0F, -0.625F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.25F, -0.5F, -0.625F, -2F, -0.625F, -0.5F, -1.25F, 0F, 0F, 0F, 0F); // Box 56
        turret[51].setRotationPoint(-42F, -42F, -26F);

        turret[52].addShapeBox(0F, 0F, 0F, 2, 2, 2, 0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.625F, 0F, -0.625F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 57
        turret[52].setRotationPoint(-42F, -48F, -26F);

        turret[53].addShapeBox(0F, 0F, 0F, 2, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.625F, 0F, -0.625F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -1.25F, 0F, -0.625F, -2F, -0.625F, 0F, -1.25F, -0.5F); // Box 58
        turret[53].setRotationPoint(-42F, -42F, 24F);

        turret[54].addShapeBox(0F, 0F, 0F, 2, 2, 2, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, -0.625F, 0F, -0.625F, 0F, 0F, 0F); // Box 59
        turret[54].setRotationPoint(-42F, -48F, 24F);

        turret[55].addShapeBox(0F, 0F, 0F, 8, 4, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 60
        turret[55].setRotationPoint(-48F, -46F, -26F);

        turret[56].addShapeBox(0F, 0F, 0F, 4, 4, 2, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 62
        turret[56].setRotationPoint(-40F, -46F, 24F);

        turret[57].addShapeBox(0F, 0F, 0F, 4, 4, 2, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 63
        turret[57].setRotationPoint(-40F, -46F, -26F);

        turret[58].addShapeBox(0F, 0F, 0F, 4, 4, 2, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 64
        turret[58].setRotationPoint(36F, -46F, -26F);

        turret[59].addShapeBox(0F, 0F, 0F, 4, 4, 2, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 65
        turret[59].setRotationPoint(36F, -46F, 24F);

        turret[60].addShapeBox(0F, 0F, 0F, 4, 4, 2, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -1F, 6F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 6F, -5F, -1F); // Box 66
        turret[60].setRotationPoint(32F, -47F, 24F);

        turret[61].addShapeBox(0F, 0F, 0F, 4, 4, 2, 0F, 0F, 1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 6F, -5F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 6F, -5F, 0F); // Box 67
        turret[61].setRotationPoint(32F, -47F, -26F);

        turret[62].addShapeBox(0F, 0F, 0F, 4, 4, 2, 0F, 0F, 0F, 0F, 0F, 1F, -1F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 6F, -5F, -1F, 6F, -5F, 0F, 0F, 0F, 0F); // Box 68
        turret[62].setRotationPoint(-36F, -47F, -26F);

        turret[63].addShapeBox(0F, 0F, 0F, 4, 4, 2, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 6F, -5F, 0F, 6F, -5F, -1F, 0F, 0F, 0F); // Box 69
        turret[63].setRotationPoint(-36F, -47F, 24F);

        turret[64].addShapeBox(0F, 0F, 0F, 2, 4, 4, 0F, -1F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -5F, 6F, 0F, -5F, 6F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 70
        turret[64].setRotationPoint(-50F, -47F, 10F);

        turret[65].addShapeBox(0F, 0F, 0F, 2, 4, 4, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 71
        turret[65].setRotationPoint(-50F, -46F, 14F);

        turret[66].addShapeBox(0F, 0F, 0F, 2, 4, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, -1F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -5F, 6F, -1F, -5F, 6F); // Box 72
        turret[66].setRotationPoint(-50F, -47F, -14F);

        turret[67].addShapeBox(0F, 0F, 0F, 2, 4, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 73
        turret[67].setRotationPoint(-50F, -46F, -18F);

        turret[68].addShapeBox(0F, 0F, 0F, 2, 4, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -5F, 6F, 0F, -5F, 6F); // Box 74
        turret[68].setRotationPoint(48F, -47F, -14F);

        turret[69].addShapeBox(0F, 0F, 0F, 2, 4, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 75
        turret[69].setRotationPoint(48F, -46F, -18F);

        turret[70].addShapeBox(0F, 0F, 0F, 2, 4, 4, 0F, 0F, 1F, 0F, -1F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -5F, 6F, -1F, -5F, 6F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 76
        turret[70].setRotationPoint(48F, -47F, 10F);

        turret[71].addShapeBox(0F, 0F, 0F, 2, 4, 4, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 77
        turret[71].setRotationPoint(48F, -46F, 14F);

        turret[72].addShapeBox(0F, 0F, 0F, 4, 4, 42, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 78
        turret[72].setRotationPoint(7F, -52F, -21F);

        turret[73].addShapeBox(0F, 0F, 0F, 4, 4, 42, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 80
        turret[73].setRotationPoint(-11F, -52F, -21F);

        turret[74].addShapeBox(0F, 0F, 0F, 14, 4, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 81
        turret[74].setRotationPoint(-7F, -52F, -8F);

        turret[75].addShapeBox(0F, 0F, 0F, 14, 4, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 82
        turret[75].setRotationPoint(-7F, -52F, 4F);

        turret[76].addShapeBox(0F, 0F, 0F, 34, 4, 17, 0F, 0F, 0F, -13F, 0F, 0F, 0F, 0F, 0F, -13F, 0F, 0F, 0F, 0F, 0F, -13F, 0F, 0F, 0F, 0F, 0F, -13F, 0F, 0F, 0F); // Box 89
        turret[76].setRotationPoint(-45F, -52F, 4F);

        turret[77].addShapeBox(0F, 0F, 0F, 34, 4, 17, 0F, 0F, 0F, 0F, 0F, 0F, -13F, 0F, 0F, 0F, 0F, 0F, -13F, 0F, 0F, 0F, 0F, 0F, -13F, 0F, 0F, 0F, 0F, 0F, -13F); // Box 90
        turret[77].setRotationPoint(-45F, -52F, -21F);

        turret[78].addShapeBox(0F, 0F, 0F, 34, 4, 17, 0F, 0F, 0F, -13F, 0F, 0F, 0F, 0F, 0F, -13F, 0F, 0F, 0F, 0F, 0F, -13F, 0F, 0F, 0F, 0F, 0F, -13F, 0F, 0F, 0F); // Box 91
        turret[78].setRotationPoint(11F, -52F, -21F);

        turret[79].addShapeBox(0F, 0F, 0F, 34, 4, 17, 0F, 0F, 0F, 0F, 0F, 0F, -13F, 0F, 0F, 0F, 0F, 0F, -13F, 0F, 0F, 0F, 0F, 0F, -13F, 0F, 0F, 0F, 0F, 0F, -13F); // Box 92
        turret[79].setRotationPoint(11F, -52F, 4F);

        turret[80].addBox(0F, 0F, 0F, 2, 2, 4, 0F); // Box 93
        turret[80].setRotationPoint(-48F, -58F, -18F);

        turret[81].addBox(0F, 0F, 0F, 2, 2, 4, 0F); // Box 94
        turret[81].setRotationPoint(-48F, -58F, 14F);

        turret[82].addBox(0F, 0F, 0F, 2, 2, 4, 0F); // Box 95
        turret[82].setRotationPoint(46F, -58F, 14F);

        turret[83].addBox(0F, 0F, 0F, 2, 2, 4, 0F); // Box 96
        turret[83].setRotationPoint(46F, -58F, -18F);

        turret[84].addShapeBox(0F, 0F, 0F, 4, 2, 3, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 100
        turret[84].setRotationPoint(45F, -54F, 10F);

        turret[85].addShapeBox(0F, 0F, 0F, 2, 4, 4, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 104
        turret[85].setRotationPoint(46F, -58F, 10F);

        turret[86].addShapeBox(0F, 0F, 0F, 2, 4, 4, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 106
        turret[86].setRotationPoint(46F, -58F, -14F);

        turret[87].addShapeBox(0F, 0F, 0F, 4, 2, 3, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 107
        turret[87].setRotationPoint(45F, -54F, -13F);

        turret[88].addShapeBox(0F, 0F, 0F, 2, 4, 4, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 108
        turret[88].setRotationPoint(46F, -58F, 18F);

        turret[89].addShapeBox(0F, 0F, 0F, 2, 4, 4, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 109
        turret[89].setRotationPoint(46F, -58F, -22F);

        turret[90].addShapeBox(0F, 0F, 0F, 4, 2, 3, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 110
        turret[90].setRotationPoint(45F, -54F, 19F);

        turret[91].addShapeBox(0F, 0F, 0F, 4, 2, 3, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 111
        turret[91].setRotationPoint(45F, -54F, -22F);

        turret[92].addShapeBox(0F, 0F, 0F, 4, 2, 3, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 112
        turret[92].setRotationPoint(-49F, -54F, -13F);

        turret[93].addShapeBox(0F, 0F, 0F, 2, 4, 4, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 113
        turret[93].setRotationPoint(-48F, -58F, -14F);

        turret[94].addShapeBox(0F, 0F, 0F, 2, 4, 4, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 114
        turret[94].setRotationPoint(-48F, -58F, 10F);

        turret[95].addShapeBox(0F, 0F, 0F, 4, 2, 3, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 115
        turret[95].setRotationPoint(-49F, -54F, 10F);

        turret[96].addShapeBox(0F, 0F, 0F, 2, 4, 4, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 116
        turret[96].setRotationPoint(-48F, -58F, -22F);

        turret[97].addShapeBox(0F, 0F, 0F, 2, 4, 4, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 117
        turret[97].setRotationPoint(-48F, -58F, 18F);

        turret[98].addShapeBox(0F, 0F, 0F, 4, 2, 3, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 118
        turret[98].setRotationPoint(-49F, -54F, -22F);

        turret[99].addShapeBox(0F, 0F, 0F, 4, 2, 3, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 119
        turret[99].setRotationPoint(-49F, -54F, 19F);

        turret[100].addBox(0F, 0F, 0F, 2, 2, 2, 0F); // Box 895
        turret[100].setRotationPoint(46F, -56F, 15F);

        turret[101].addBox(0F, 0F, 0F, 2, 2, 2, 0F); // Box 896
        turret[101].setRotationPoint(46F, -56F, -17F);

        turret[102].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 897
        turret[102].setRotationPoint(43F, -61F, -17F);

        turret[103].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 898
        turret[103].setRotationPoint(43F, -61F, 15F);

        turret[104].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 899
        turret[104].setRotationPoint(49F, -61F, 15F);

        turret[105].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 900
        turret[105].setRotationPoint(49F, -61F, -17F);

        turret[106].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, -3F, 0F, 0F); // Box 901
        turret[106].setRotationPoint(43F, -57F, -17F);

        turret[107].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, -3F, 0F, 0F); // Box 902
        turret[107].setRotationPoint(43F, -57F, 15F);

        turret[108].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, -2F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, -2F, 0F); // Box 903
        turret[108].setRotationPoint(48F, -57F, -17F);

        turret[109].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, -2F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, -2F, 0F); // Box 904
        turret[109].setRotationPoint(48F, -57F, 15F);

        turret[110].addShapeBox(0F, 0F, 0F, 4, 4, 2, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F); // Box 906
        turret[110].setRotationPoint(43F, -65F, 15F);

        turret[111].addShapeBox(0F, 0F, 0F, 4, 4, 2, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F); // Box 907
        turret[111].setRotationPoint(43F, -65F, -17F);

        turret[112].addShapeBox(0F, 0F, 0F, 4, 4, 2, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F); // Box 908
        turret[112].setRotationPoint(47F, -65F, 15F);

        turret[113].addShapeBox(0F, 0F, 0F, 4, 4, 2, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F); // Box 909
        turret[113].setRotationPoint(47F, -65F, -17F);

        turret[114].addShapeBox(0F, 0F, 0F, 4, 3, 2, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 910
        turret[114].setRotationPoint(45F, -68F, 15F);

        turret[115].addShapeBox(0F, 0F, 0F, 4, 3, 2, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 911
        turret[115].setRotationPoint(45F, -68F, -17F);

        turret[116].addBox(0F, 0F, 0F, 2, 2, 2, 0F); // Box 912
        turret[116].setRotationPoint(-48F, -56F, -17F);

        turret[117].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 913
        turret[117].setRotationPoint(-45F, -61F, -17F);

        turret[118].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 914
        turret[118].setRotationPoint(-51F, -61F, -17F);

        turret[119].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, -2F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, -2F, 0F); // Box 915
        turret[119].setRotationPoint(-46F, -57F, -17F);

        turret[120].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, -3F, 0F, 0F); // Box 916
        turret[120].setRotationPoint(-51F, -57F, -17F);

        turret[121].addShapeBox(0F, 0F, 0F, 4, 4, 2, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F); // Box 917
        turret[121].setRotationPoint(-47F, -65F, -17F);

        turret[122].addShapeBox(0F, 0F, 0F, 4, 4, 2, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F); // Box 918
        turret[122].setRotationPoint(-51F, -65F, -17F);

        turret[123].addShapeBox(0F, 0F, 0F, 4, 3, 2, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 919
        turret[123].setRotationPoint(-49F, -68F, -17F);

        turret[124].addBox(0F, 0F, 0F, 2, 2, 2, 0F); // Box 920
        turret[124].setRotationPoint(-48F, -56F, 15F);

        turret[125].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 921
        turret[125].setRotationPoint(-45F, -61F, 15F);

        turret[126].addBox(0F, 0F, 0F, 2, 4, 2, 0F); // Box 922
        turret[126].setRotationPoint(-51F, -61F, 15F);

        turret[127].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, -2F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, -2F, 0F); // Box 923
        turret[127].setRotationPoint(-46F, -57F, 15F);

        turret[128].addShapeBox(0F, 0F, 0F, 3, 3, 2, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, -3F, 0F, 0F); // Box 924
        turret[128].setRotationPoint(-51F, -57F, 15F);

        turret[129].addShapeBox(0F, 0F, 0F, 4, 4, 2, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F); // Box 925
        turret[129].setRotationPoint(-47F, -65F, 15F);

        turret[130].addShapeBox(0F, 0F, 0F, 4, 4, 2, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F); // Box 926
        turret[130].setRotationPoint(-51F, -65F, 15F);

        turret[131].addShapeBox(0F, 0F, 0F, 4, 3, 2, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 927
        turret[131].setRotationPoint(-49F, -68F, 15F);
        this.add("turret", turret); this.turret = this.get("turret");
        this.fixRotations();
        //
        this.gui_scale_x = this.gui_scale_x / 2;
        this.gui_scale_y = this.gui_scale_y / 2;
        this.gui_scale_z = this.gui_scale_z / 2;
        //
        this.groups.add(box = new TurboList("box"));
		ModelRendererTurbo mbox = new ModelRendererTurbo(this, 332, 215, textureX, textureY); // Box 1062
		mbox.addBox(0F, 0F, 0F, 16, 16, 16, 0F); // Box 1062
		mbox.setRotationPoint(-8F, -16F, -8F);
		box.add(mbox); box.translate(-16f, 16f, 112f);
		box.addProgram(DefaultPrograms.ALWAYS_GLOW);
		//translate(box, -16F, 16F, 112F);
		this.translate(-8, 16, 112);
    }
    
    private TurboList rail_piece, chassis, body, turret, box, rope;
    private TreeMap<Integer, TurboList> ropes = new TreeMap<>();

    @Override
    public void render(VehicleData data, Object obj, @Nullable VehicleEntity entity, int meta){
        ContainerCraneScript script = data.getScript(ContainerCraneScript.class);
        if(script == null){
            super.render(data, obj, entity, meta);
        }
        else{
        	GL11.glTranslatef(-script.length + 1, 0, 0);
        	int len = (script.length * 2) + 1;
            for(int i = 0; i < len; i++){
                rail_piece.render(entity, data);
                GL11.glTranslatef(1, 0, 0);
            }
            GL11.glTranslatef(-script.length - 1, 0, 0);
        	GL11.glPushMatrix();
        	GL11.glTranslated(script.xpos * 0.001, 0, 0);
        	chassis.render(entity, data);
        	GL11.glTranslated(0, 0, script.zpos * 0.001);
        	body.render(entity, data);
        	rope = getRopes(script.ypos);
        	if(rope != null){ rope.render(entity, data, data, "rope"); }
        	GL11.glTranslated(0, script.ypos * 0.001, 0);
        	turret.render(entity, data);
        	if(script.searchbox){
        		box.render(entity, data, data, "box");
        	}
        	if(script.getContainerData() != null){
        		GL11.glTranslatef(-0.5f, 1, 7);
        		bindTexture(script.getContainerData().getTexture());
        		script.getContainerData().getContainer().getModel().render(script.getContainerData(), obj);
        	}
        	GL11.glPopMatrix();
        }
    }

	private final TurboList getRopes(int ypos){
		int i = 101 + (ypos / 60); if(ropes.containsKey(i)){ return ropes.get(i); }
		TurboList newropes = generate(i); ropes.put(i, newropes); return newropes;
	}

	private final TurboList generate(int i){
		ModelRendererTurbo[] model = new ModelRendererTurbo[4];
		model[0] = new ModelRendererTurbo(this, 1001, 161, textureX, textureY);
		model[1] = new ModelRendererTurbo(this, 465, 329, textureX, textureY);
		model[2] = new ModelRendererTurbo(this, 377, 337, textureX, textureY);
		model[3] = new ModelRendererTurbo(this, 385, 337, textureX, textureY);
		model[0].addBox(0F, 0F, 0F, 1, i, 1, 0F);
		model[0].setRotationPoint(-47.5F, -165F, -16.5F);
		model[1].addBox(0F, 0F, 0F, 1, i, 1, 0F);
		model[1].setRotationPoint(-47.5F, -165F, 15.5F);
		model[2].addBox(0F, 0F, 0F, 1, i, 1, 0F);
		model[2].setRotationPoint(46.5F, -165F, -16.5F);
		model[3].addBox(0F, 0F, 0F, 1, i, 1, 0F);
		model[3].setRotationPoint(46.5F, -165F, 15.5F);
		TurboList list = new TurboList("rope" + i, model);
		list.translate(-8, 16, 112);
		return list;
	}

}
