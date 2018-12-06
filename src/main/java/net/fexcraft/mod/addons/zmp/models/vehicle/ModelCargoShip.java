package net.fexcraft.mod.addons.zmp.models.vehicle;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.vehicle.VehicleModel;

public class ModelCargoShip extends VehicleModel {

    public ModelCargoShip(){
    	super(); textureX = 4096; textureY = 4096;
        this.addToCreators("643a5fd6-f325-442f-9ea8-6445dbb0cdc9");
        this.gui_scale_x = this.gui_scale_y = this.gui_scale_z = 0.015f;
        ModelRendererTurbo[] body = new ModelRendererTurbo[133];
        body[0] = new ModelRendererTurbo(this, 1, 913, textureX, textureY); // Box 82
        body[1] = new ModelRendererTurbo(this, 1249, 913, textureX, textureY); // Box 83
        body[2] = new ModelRendererTurbo(this, 2697, 913, textureX, textureY); // Box 84
        body[3] = new ModelRendererTurbo(this, 1, 1145, textureX, textureY); // Box 85
        body[4] = new ModelRendererTurbo(this, 809, 1145, textureX, textureY); // Box 88
        body[5] = new ModelRendererTurbo(this, 1817, 1145, textureX, textureY); // Box 89
        body[6] = new ModelRendererTurbo(this, 2825, 1145, textureX, textureY); // Box 90
        body[7] = new ModelRendererTurbo(this, 3457, 817, textureX, textureY); // Box 91
        body[8] = new ModelRendererTurbo(this, 3473, 913, textureX, textureY); // Box 92
        body[9] = new ModelRendererTurbo(this, 3753, 1, textureX, textureY); // Box 93
        body[10] = new ModelRendererTurbo(this, 3457, 761, textureX, textureY); // Box 94
        body[11] = new ModelRendererTurbo(this, 1025, 913, textureX, textureY); // Box 95
        body[12] = new ModelRendererTurbo(this, 2473, 913, textureX, textureY); // Box 97
        body[13] = new ModelRendererTurbo(this, 3473, 937, textureX, textureY); // Box 98
        body[14] = new ModelRendererTurbo(this, 3689, 937, textureX, textureY); // Box 99
        body[15] = new ModelRendererTurbo(this, 3489, 1145, textureX, textureY); // Box 100
        body[16] = new ModelRendererTurbo(this, 2649, 937, textureX, textureY); // Box 101
        body[17] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 102
        body[18] = new ModelRendererTurbo(this, 3553, 841, textureX, textureY); // Box 103
        body[19] = new ModelRendererTurbo(this, 3553, 865, textureX, textureY); // Box 105
        body[20] = new ModelRendererTurbo(this, 1, 1169, textureX, textureY); // Box 106
        body[21] = new ModelRendererTurbo(this, 169, 1169, textureX, textureY); // Box 107
        body[22] = new ModelRendererTurbo(this, 201, 1, textureX, textureY); // Box 108
        body[23] = new ModelRendererTurbo(this, 497, 1, textureX, textureY); // Box 109
        body[24] = new ModelRendererTurbo(this, 721, 1169, textureX, textureY); // Box 110
        body[25] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 111
        body[26] = new ModelRendererTurbo(this, 793, 1, textureX, textureY); // Box 112
        body[27] = new ModelRendererTurbo(this, 857, 1, textureX, textureY); // Box 114
        body[28] = new ModelRendererTurbo(this, 41, 1, textureX, textureY); // Box 115
        body[29] = new ModelRendererTurbo(this, 201, 1, textureX, textureY); // Box 116
        body[30] = new ModelRendererTurbo(this, 65, 1, textureX, textureY); // Box 117
        body[31] = new ModelRendererTurbo(this, 313, 1, textureX, textureY); // Box 118
        body[32] = new ModelRendererTurbo(this, 353, 1, textureX, textureY); // Box 119
        body[33] = new ModelRendererTurbo(this, 497, 1, textureX, textureY); // Box 120
        body[34] = new ModelRendererTurbo(this, 609, 1, textureX, textureY); // Box 121
        body[35] = new ModelRendererTurbo(this, 633, 1, textureX, textureY); // Box 122
        body[36] = new ModelRendererTurbo(this, 833, 1, textureX, textureY); // Box 123
        body[37] = new ModelRendererTurbo(this, 921, 1, textureX, textureY); // Box 124
        body[38] = new ModelRendererTurbo(this, 945, 1, textureX, textureY); // Box 125
        body[39] = new ModelRendererTurbo(this, 1089, 1, textureX, textureY); // Box 126
        body[40] = new ModelRendererTurbo(this, 1129, 1, textureX, textureY); // Box 127
        body[41] = new ModelRendererTurbo(this, 1153, 1, textureX, textureY); // Box 128
        body[42] = new ModelRendererTurbo(this, 1193, 1, textureX, textureY); // Box 129
        body[43] = new ModelRendererTurbo(this, 1233, 1, textureX, textureY); // Box 130
        body[44] = new ModelRendererTurbo(this, 1385, 1, textureX, textureY); // Box 131
        body[45] = new ModelRendererTurbo(this, 1425, 1, textureX, textureY); // Box 132
        body[46] = new ModelRendererTurbo(this, 1257, 1, textureX, textureY); // Box 133
        body[47] = new ModelRendererTurbo(this, 1465, 1, textureX, textureY); // Box 134
        body[48] = new ModelRendererTurbo(this, 1489, 1, textureX, textureY); // Box 135
        body[49] = new ModelRendererTurbo(this, 1529, 1, textureX, textureY); // Box 136
        body[50] = new ModelRendererTurbo(this, 1681, 1, textureX, textureY); // Box 137
        body[51] = new ModelRendererTurbo(this, 1705, 1, textureX, textureY); // Box 138
        body[52] = new ModelRendererTurbo(this, 1729, 1, textureX, textureY); // Box 139
        body[53] = new ModelRendererTurbo(this, 1769, 1, textureX, textureY); // Box 140
        body[54] = new ModelRendererTurbo(this, 1977, 1, textureX, textureY); // Box 141
        body[55] = new ModelRendererTurbo(this, 1809, 1, textureX, textureY); // Box 142
        body[56] = new ModelRendererTurbo(this, 2057, 1, textureX, textureY); // Box 143
        body[57] = new ModelRendererTurbo(this, 2273, 1, textureX, textureY); // Box 144
        body[58] = new ModelRendererTurbo(this, 1849, 1, textureX, textureY); // Box 145
        body[59] = new ModelRendererTurbo(this, 2097, 1, textureX, textureY); // Box 146
        body[60] = new ModelRendererTurbo(this, 2353, 1, textureX, textureY); // Box 147
        body[61] = new ModelRendererTurbo(this, 2393, 1, textureX, textureY); // Box 148
        body[62] = new ModelRendererTurbo(this, 2569, 1, textureX, textureY); // Box 149
        body[63] = new ModelRendererTurbo(this, 2137, 1, textureX, textureY); // Box 150
        body[64] = new ModelRendererTurbo(this, 2609, 1, textureX, textureY); // Box 151
        body[65] = new ModelRendererTurbo(this, 2649, 1, textureX, textureY); // Box 152
        body[66] = new ModelRendererTurbo(this, 2681, 1, textureX, textureY); // Box 153
        body[67] = new ModelRendererTurbo(this, 2865, 1, textureX, textureY); // Box 154
        body[68] = new ModelRendererTurbo(this, 2433, 1, textureX, textureY); // Box 155
        body[69] = new ModelRendererTurbo(this, 2737, 1, textureX, textureY); // Box 156
        body[70] = new ModelRendererTurbo(this, 2921, 1, textureX, textureY); // Box 157
        body[71] = new ModelRendererTurbo(this, 2961, 1, textureX, textureY); // Box 158
        body[72] = new ModelRendererTurbo(this, 3001, 1, textureX, textureY); // Box 159
        body[73] = new ModelRendererTurbo(this, 3161, 1, textureX, textureY); // Box 160
        body[74] = new ModelRendererTurbo(this, 3201, 1, textureX, textureY); // Box 161
        body[75] = new ModelRendererTurbo(this, 3225, 1, textureX, textureY); // Box 162
        body[76] = new ModelRendererTurbo(this, 3177, 1, textureX, textureY); // Box 163
        body[77] = new ModelRendererTurbo(this, 1185, 1169, textureX, textureY); // Box 164
        body[78] = new ModelRendererTurbo(this, 1377, 1169, textureX, textureY); // Box 165
        body[79] = new ModelRendererTurbo(this, 3857, 865, textureX, textureY); // Box 166
        body[80] = new ModelRendererTurbo(this, 1193, 913, textureX, textureY); // Box 168
        body[81] = new ModelRendererTurbo(this, 1617, 1169, textureX, textureY); // Box 178
        body[82] = new ModelRendererTurbo(this, 2649, 1377, textureX, textureY); // Box 179
        body[83] = new ModelRendererTurbo(this, 1, 1401, textureX, textureY); // Box 180
        body[84] = new ModelRendererTurbo(this, 1185, 1433, textureX, textureY); // Box 181
        body[85] = new ModelRendererTurbo(this, 1, 1625, textureX, textureY); // Box 182
        body[86] = new ModelRendererTurbo(this, 1681, 1625, textureX, textureY); // Box 183
        body[87] = new ModelRendererTurbo(this, 1, 1849, textureX, textureY); // Box 184
        body[88] = new ModelRendererTurbo(this, 1977, 1849, textureX, textureY); // Box 185
        body[89] = new ModelRendererTurbo(this, 1, 2097, textureX, textureY); // Box 186
        body[90] = new ModelRendererTurbo(this, 777, 2097, textureX, textureY); // Box 187
        body[91] = new ModelRendererTurbo(this, 1513, 2113, textureX, textureY); // Box 188
        body[92] = new ModelRendererTurbo(this, 2641, 1169, textureX, textureY); // Box 189
        body[93] = new ModelRendererTurbo(this, 2185, 2113, textureX, textureY); // Box 193
        body[94] = new ModelRendererTurbo(this, 2769, 2113, textureX, textureY); // Box 194
        body[95] = new ModelRendererTurbo(this, 3617, 1625, textureX, textureY); // Box 195
        body[96] = new ModelRendererTurbo(this, 1761, 1849, textureX, textureY); // Box 196
        body[97] = new ModelRendererTurbo(this, 3369, 1169, textureX, textureY); // Box 197
        body[98] = new ModelRendererTurbo(this, 3273, 2113, textureX, textureY); // Box 198
        body[99] = new ModelRendererTurbo(this, 1321, 2337, textureX, textureY); // Box 199
        body[100] = new ModelRendererTurbo(this, 3625, 2113, textureX, textureY); // Box 200
        body[101] = new ModelRendererTurbo(this, 553, 2345, textureX, textureY); // Box 204
        body[102] = new ModelRendererTurbo(this, 1849, 2337, textureX, textureY); // Box 205
        body[103] = new ModelRendererTurbo(this, 2153, 1433, textureX, textureY); // Box 206
        body[104] = new ModelRendererTurbo(this, 1273, 1305, textureX, textureY); // Box 207
        body[105] = new ModelRendererTurbo(this, 1689, 9, textureX, textureY); // Box 208
        body[106] = new ModelRendererTurbo(this, 3457, 25, textureX, textureY); // Box 209
        body[107] = new ModelRendererTurbo(this, 2569, 9, textureX, textureY); // Box 210
        body[108] = new ModelRendererTurbo(this, 2921, 25, textureX, textureY); // Box 211
        body[109] = new ModelRendererTurbo(this, 1089, 33, textureX, textureY); // Box 212
        body[110] = new ModelRendererTurbo(this, 1385, 33, textureX, textureY); // Box 213
        body[111] = new ModelRendererTurbo(this, 1977, 33, textureX, textureY); // Box 214
        body[112] = new ModelRendererTurbo(this, 2273, 33, textureX, textureY); // Box 215
        body[113] = new ModelRendererTurbo(this, 2569, 33, textureX, textureY); // Box 216
        body[114] = new ModelRendererTurbo(this, 793, 49, textureX, textureY); // Box 217
        body[115] = new ModelRendererTurbo(this, 2865, 49, textureX, textureY); // Box 218
        body[116] = new ModelRendererTurbo(this, 1, 2361, textureX, textureY); // Box 219
        body[117] = new ModelRendererTurbo(this, 2601, 2361, textureX, textureY); // Box 220
        body[118] = new ModelRendererTurbo(this, 553, 2097, textureX, textureY); // Box 221
        body[119] = new ModelRendererTurbo(this, 2553, 2113, textureX, textureY); // Box 223
        body[120] = new ModelRendererTurbo(this, 1305, 2097, textureX, textureY); // Box 225
        body[121] = new ModelRendererTurbo(this, 2409, 1433, textureX, textureY); // Box 226
        body[122] = new ModelRendererTurbo(this, 3425, 1625, textureX, textureY); // Box 216
        body[123] = new ModelRendererTurbo(this, 3665, 1433, textureX, textureY); // Box 217
        body[124] = new ModelRendererTurbo(this, 1193, 953, textureX, textureY); // Box 218
        body[125] = new ModelRendererTurbo(this, 3753, 1841, textureX, textureY); // Box 219
        body[126] = new ModelRendererTurbo(this, 201, 153, textureX, textureY); // Box 220
        body[127] = new ModelRendererTurbo(this, 2089, 9, textureX, textureY); // Box 221
        body[128] = new ModelRendererTurbo(this, 2385, 9, textureX, textureY); // Box 222
        body[129] = new ModelRendererTurbo(this, 905, 33, textureX, textureY); // Box 223
        body[130] = new ModelRendererTurbo(this, 201, 25, textureX, textureY); // Box 224
        body[131] = new ModelRendererTurbo(this, 313, 25, textureX, textureY); // Box 226
        body[132] = new ModelRendererTurbo(this, 3161, 33, textureX, textureY); // Box 227

        body[0].addBox(0F, 0F, 0F, 400, 5, 220, 0F); // Box 82
        body[0].setRotationPoint(-607F, -81F, -110F);

        body[1].addBox(0F, 0F, 0F, 500, 5, 220, 0F); // Box 83
        body[1].setRotationPoint(-207F, -81F, -110F);

        body[2].addBox(0F, 0F, 0F, 274, 5, 220, 0F); // Box 84
        body[2].setRotationPoint(293F, -81F, -110F);

        body[3].addBox(0F, 0F, 0F, 400, 15, 3, 0F); // Box 85
        body[3].setRotationPoint(-607F, -96F, 106F);

        body[4].addBox(0F, 0F, 0F, 500, 15, 3, 0F); // Box 88
        body[4].setRotationPoint(-207F, -96F, 106F);

        body[5].addBox(0F, 0F, 0F, 500, 15, 3, 0F); // Box 89
        body[5].setRotationPoint(-207F, -96F, -109F);

        body[6].addBox(0F, 0F, 0F, 400, 15, 3, 0F); // Box 90
        body[6].setRotationPoint(-607F, -96F, -109F);

        body[7].addBox(0F, 0F, 0F, 274, 15, 3, 0F); // Box 91
        body[7].setRotationPoint(293F, -96F, 106F);

        body[8].addBox(0F, 0F, 0F, 274, 15, 3, 0F); // Box 92
        body[8].setRotationPoint(293F, -96F, -109F);

        body[9].addShapeBox(0F, 0F, 0F, 120, 30, 10, 0F, 0F, 0F, 0F, -10F, 0F, 0F, -10F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 15F, 0F, 0F, 15F); // Box 93
        body[9].setRotationPoint(-600F, -217F, 73F);

        body[10].addShapeBox(0F, 0F, 0F, 120, 30, 10, 0F, 0F, 0F, 0F, -10F, 0F, 0F, -10F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 15F, 0F, 0F, 15F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 94
        body[10].setRotationPoint(-600F, -217F, -83F);

        body[11].addShapeBox(0F, 0F, 0F, 10, 30, 146, 0F, 0F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 15F, 0F, 0F, 15F, 0F, 0F, 0F, 0F, 0F); // Box 95
        body[11].setRotationPoint(-505F, -217F, -73F);

        body[12].addBox(0F, 0F, 0F, 120, 107, 25, 0F); // Box 97
        body[12].setRotationPoint(-600F, -187F, 73F);

        body[13].addBox(0F, 0F, 0F, 120, 107, 25, 0F); // Box 98
        body[13].setRotationPoint(-600F, -187F, -98F);

        body[14].addBox(0F, 0F, 0F, 25, 107, 147, 0F); // Box 99
        body[14].setRotationPoint(-505F, -187F, -74F);

        body[15].addBox(0F, 0F, 0F, 10, 85, 146, 0F); // Box 100
        body[15].setRotationPoint(-600F, -217F, -73F);

        body[16].addBox(0F, 0F, 0F, 10, 51, 115, 0F); // Box 101
        body[16].setRotationPoint(-600F, -132F, -42F);

        body[17].addBox(0F, 0F, 0F, 3, 51, 32, 0F); // Box 102
        body[17].setRotationPoint(-598F, -132F, -74F);

        body[18].addShapeBox(0F, 0F, 0F, 160, 15, 3, 0F, 0F, 0F, -15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 15F, 0F, 0F, -15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 15F); // Box 103
        body[18].setRotationPoint(-767F, -96F, -109F);

        body[19].addShapeBox(0F, 0F, 0F, 160, 15, 3, 0F, 0F, 0F, 15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -15F, 0F, 0F, 15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -15F); // Box 105
        body[19].setRotationPoint(-767F, -96F, 106F);

        body[20].addShapeBox(0F, 0F, 0F, 5, 15, 188, 0F, 5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 106
        body[20].setRotationPoint(-772F, -96F, -94F);

        body[21].addShapeBox(0F, 0F, 0F, 165, 5, 220, 0F, 0F, 0F, -15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -15F, 0F, 0F, -15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -15F); // Box 107
        body[21].setRotationPoint(-772F, -81F, -110F);

        body[22].addShapeBox(0F, 0F, 0F, 30, 27, 45, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 108
        body[22].setRotationPoint(-540F, -217F, -128F);

        body[23].addShapeBox(0F, 0F, 0F, 30, 27, 45, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -5F, 0F, 0F, -5F); // Box 109
        body[23].setRotationPoint(-540F, -217F, 83F);

        body[24].addBox(0F, 0F, 0F, 85, 5, 146, 0F); // Box 110
        body[24].setRotationPoint(-590F, -197F, -73F);

        body[25].addBox(0F, 0F, 0F, 4, 21, 4, 0F); // Box 111
        body[25].setRotationPoint(-494F, -238F, 55F);

        body[26].addShapeBox(0F, 0F, 0F, 4, 21, 24, 0F, -15F, 0F, 0F, 15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -15F, 0F, 0F, 15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 112
        body[26].setRotationPoint(-509F, -238F, 59F);

        body[27].addShapeBox(0F, 0F, 0F, 4, 21, 24, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 15F, 0F, 0F, -15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 15F, 0F, 0F, -15F, 0F, 0F); // Box 114
        body[27].setRotationPoint(-509F, -238F, -83F);

        body[28].addBox(0F, 0F, 0F, 4, 21, 4, 0F); // Box 115
        body[28].setRotationPoint(-494F, -238F, -59F);

        body[29].addBox(0F, 0F, 0F, 4, 3, 15, 0F); // Box 116
        body[29].setRotationPoint(-494F, -238F, -55F);

        body[30].addBox(0F, 0F, 0F, 4, 21, 4, 0F); // Box 117
        body[30].setRotationPoint(-494F, -238F, -40F);

        body[31].addBox(0F, 0F, 0F, 4, 3, 15, 0F); // Box 118
        body[31].setRotationPoint(-494F, -220F, -55F);

        body[32].addBox(0F, 0F, 0F, 4, 3, 15, 0F); // Box 119
        body[32].setRotationPoint(-494F, -220F, -36F);

        body[33].addBox(0F, 0F, 0F, 4, 3, 15, 0F); // Box 120
        body[33].setRotationPoint(-494F, -238F, -36F);

        body[34].addBox(0F, 0F, 0F, 4, 21, 4, 0F); // Box 121
        body[34].setRotationPoint(-494F, -238F, -21F);

        body[35].addBox(0F, 0F, 0F, 4, 3, 15, 0F); // Box 122
        body[35].setRotationPoint(-494F, -238F, 40F);

        body[36].addBox(0F, 0F, 0F, 4, 3, 15, 0F); // Box 123
        body[36].setRotationPoint(-494F, -220F, 40F);

        body[37].addBox(0F, 0F, 0F, 4, 21, 4, 0F); // Box 124
        body[37].setRotationPoint(-494F, -238F, 36F);

        body[38].addBox(0F, 0F, 0F, 4, 3, 15, 0F); // Box 125
        body[38].setRotationPoint(-494F, -238F, 21F);

        body[39].addBox(0F, 0F, 0F, 4, 3, 15, 0F); // Box 126
        body[39].setRotationPoint(-494F, -220F, 21F);

        body[40].addBox(0F, 0F, 0F, 4, 21, 4, 0F); // Box 127
        body[40].setRotationPoint(-494F, -238F, 17F);

        body[41].addBox(0F, 0F, 0F, 4, 3, 15, 0F); // Box 128
        body[41].setRotationPoint(-494F, -238F, 2F);

        body[42].addBox(0F, 0F, 0F, 4, 3, 15, 0F); // Box 129
        body[42].setRotationPoint(-494F, -238F, -17F);

        body[43].addBox(0F, 0F, 0F, 4, 21, 4, 0F); // Box 130
        body[43].setRotationPoint(-494F, -238F, -2F);

        body[44].addBox(0F, 0F, 0F, 4, 3, 15, 0F); // Box 131
        body[44].setRotationPoint(-494F, -220F, 2F);

        body[45].addBox(0F, 0F, 0F, 4, 3, 15, 0F); // Box 132
        body[45].setRotationPoint(-494F, -220F, -17F);

        body[46].addBox(0F, 0F, 0F, 4, 21, 4, 0F); // Box 133
        body[46].setRotationPoint(-513F, -238F, 79F);

        body[47].addBox(0F, 0F, 0F, 4, 21, 4, 0F); // Box 134
        body[47].setRotationPoint(-513F, -238F, -83F);

        body[48].addBox(0F, 0F, 0F, 15, 3, 4, 0F); // Box 135
        body[48].setRotationPoint(-528F, -238F, 79F);

        body[49].addBox(0F, 0F, 0F, 15, 3, 4, 0F); // Box 136
        body[49].setRotationPoint(-528F, -220F, 79F);

        body[50].addBox(0F, 0F, 0F, 4, 21, 4, 0F); // Box 137
        body[50].setRotationPoint(-532F, -238F, 79F);

        body[51].addBox(0F, 0F, 0F, 4, 21, 4, 0F); // Box 138
        body[51].setRotationPoint(-551F, -238F, 79F);

        body[52].addBox(0F, 0F, 0F, 15, 3, 4, 0F); // Box 139
        body[52].setRotationPoint(-547F, -238F, 79F);

        body[53].addBox(0F, 0F, 0F, 15, 3, 4, 0F); // Box 140
        body[53].setRotationPoint(-547F, -220F, 79F);

        body[54].addBox(0F, 0F, 0F, 34, 21, 10, 0F); // Box 141
        body[54].setRotationPoint(-600F, -238F, 73F);

        body[55].addBox(0F, 0F, 0F, 15, 3, 4, 0F); // Box 142
        body[55].setRotationPoint(-566F, -238F, 79F);

        body[56].addBox(0F, 0F, 0F, 15, 3, 4, 0F); // Box 143
        body[56].setRotationPoint(-566F, -220F, 79F);

        body[57].addBox(0F, 0F, 0F, 34, 21, 10, 0F); // Box 144
        body[57].setRotationPoint(-600F, -238F, -83F);

        body[58].addBox(0F, 0F, 0F, 4, 21, 4, 0F); // Box 145
        body[58].setRotationPoint(-532F, -238F, -83F);

        body[59].addBox(0F, 0F, 0F, 15, 3, 4, 0F); // Box 146
        body[59].setRotationPoint(-528F, -238F, -83F);

        body[60].addBox(0F, 0F, 0F, 15, 3, 4, 0F); // Box 147
        body[60].setRotationPoint(-528F, -220F, -83F);

        body[61].addBox(0F, 0F, 0F, 15, 3, 4, 0F); // Box 148
        body[61].setRotationPoint(-547F, -238F, -83F);

        body[62].addBox(0F, 0F, 0F, 15, 3, 4, 0F); // Box 149
        body[62].setRotationPoint(-547F, -220F, -83F);

        body[63].addBox(0F, 0F, 0F, 4, 21, 4, 0F); // Box 150
        body[63].setRotationPoint(-551F, -238F, -83F);

        body[64].addBox(0F, 0F, 0F, 15, 3, 4, 0F); // Box 151
        body[64].setRotationPoint(-566F, -238F, -83F);

        body[65].addBox(0F, 0F, 0F, 15, 3, 4, 0F); // Box 152
        body[65].setRotationPoint(-566F, -220F, -83F);

        body[66].addBox(0F, 0F, 0F, 10, 21, 14, 0F); // Box 153
        body[66].setRotationPoint(-600F, -238F, -73F);

        body[67].addBox(0F, 0F, 0F, 10, 21, 14, 0F); // Box 154
        body[67].setRotationPoint(-600F, -238F, 59F);

        body[68].addBox(0F, 0F, 0F, 4, 21, 4, 0F); // Box 155
        body[68].setRotationPoint(-600F, -238F, 55F);

        body[69].addBox(0F, 0F, 0F, 4, 21, 4, 0F); // Box 156
        body[69].setRotationPoint(-600F, -238F, -59F);

        body[70].addBox(0F, 0F, 0F, 4, 3, 15, 0F); // Box 157
        body[70].setRotationPoint(-600F, -238F, -55F);

        body[71].addBox(0F, 0F, 0F, 4, 3, 15, 0F); // Box 158
        body[71].setRotationPoint(-600F, -220F, -55F);

        body[72].addBox(0F, 0F, 0F, 4, 3, 15, 0F); // Box 159
        body[72].setRotationPoint(-600F, -220F, 40F);

        body[73].addBox(0F, 0F, 0F, 4, 3, 15, 0F); // Box 160
        body[73].setRotationPoint(-600F, -238F, 40F);

        body[74].addBox(0F, 0F, 0F, 4, 21, 4, 0F); // Box 161
        body[74].setRotationPoint(-600F, -238F, 36F);

        body[75].addBox(0F, 0F, 0F, 4, 21, 4, 0F); // Box 162
        body[75].setRotationPoint(-600F, -238F, -40F);

        body[76].addBox(0F, 0F, 0F, 10, 21, 72, 0F); // Box 163
        body[76].setRotationPoint(-600F, -238F, -36F);

        body[77].addShapeBox(0F, 0F, 0F, 20, 158, 72, 0F, 0F, 0F, 0F, 0F, 8F, 0F, 0F, 8F, 0F, 0F, 0F, 0F, 30F, 0F, 0F, 0F, 0F, 5F, 0F, 0F, 5F, 30F, 0F, 0F); // Box 164
        body[77].setRotationPoint(-620F, -238F, -36F);

        body[78].addShapeBox(0F, 0F, 0F, 110, 8, 118, 0F, 0F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 165
        body[78].setRotationPoint(-600F, -246F, -59F);

        body[79].addShapeBox(0F, 0F, 0F, 91, 8, 24, 0F, 0F, 0F, 0F, 14F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 19F, 0F, 0F, 4F, 0F, 0F, 0F, 0F, 0F); // Box 166
        body[79].setRotationPoint(-600F, -246F, 59F);

        body[80].addShapeBox(0F, 0F, 0F, 91, 8, 24, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 14F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 4F, 0F, 0F, 19F, 0F, 0F, 0F, 0F, 0F); // Box 168
        body[80].setRotationPoint(-600F, -246F, -83F);

        body[81].addShapeBox(0F, 0F, 0F, 400, 40, 220, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, -5F); // Box 178
        body[81].setRotationPoint(-607F, -76F, -110F);

        body[82].addShapeBox(0F, 0F, 0F, 400, 35, 210, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -10F, 0F, 0F, -10F, 0F, 0F, -10F, 0F, 0F, -10F); // Box 179
        body[82].setRotationPoint(-607F, -36F, -105F);

        body[83].addShapeBox(0F, 0F, 0F, 400, 30, 190, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -15F, 0F, 0F, -15F, 0F, 0F, -15F, 0F, 0F, -15F); // Box 180
        body[83].setRotationPoint(-607F, -1F, -95F);

        body[84].addShapeBox(0F, 0F, 0F, 400, 25, 160, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -20F, 0F, 0F, -20F, 0F, 0F, -20F, 0F, 0F, -20F); // Box 181
        body[84].setRotationPoint(-607F, 29F, -80F);

        body[85].addShapeBox(0F, 0F, 0F, 774, 25, 160, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -20F, 0F, 0F, -20F, 0F, 0F, -20F, 0F, 0F, -20F); // Box 182
        body[85].setRotationPoint(-207F, 29F, -80F);

        body[86].addShapeBox(0F, 0F, 0F, 774, 30, 190, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -15F, 0F, 0F, -15F, 0F, 0F, -15F, 0F, 0F, -15F); // Box 183
        body[86].setRotationPoint(-207F, -1F, -95F);

        body[87].addShapeBox(0F, 0F, 0F, 774, 35, 210, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -10F, 0F, 0F, -10F, 0F, 0F, -10F, 0F, 0F, -10F); // Box 184
        body[87].setRotationPoint(-207F, -36F, -105F);

        body[88].addShapeBox(0F, 0F, 0F, 774, 40, 220, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, -5F); // Box 185
        body[88].setRotationPoint(-207F, -76F, -110F);

        body[89].addShapeBox(0F, 0F, 0F, 165, 40, 220, 0F, 0F, 0F, -15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -15F, -10F, 0F, -20F, 0F, 0F, -5F, 0F, 0F, -5F, -10F, 0F, -20F); // Box 186
        body[89].setRotationPoint(-772F, -76F, -110F);

        body[90].addShapeBox(0F, 0F, 0F, 155, 35, 210, 0F, 0F, 0F, -15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -15F, -10F, 0F, -25F, 0F, 0F, -10F, 0F, 0F, -10F, -10F, 0F, -25F); // Box 187
        body[90].setRotationPoint(-762F, -36F, -105F);

        body[91].addShapeBox(0F, 0F, 0F, 145, 30, 190, 0F, 0F, 0F, -15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -15F, -10F, 0F, -25F, 0F, 0F, -15F, 0F, 0F, -15F, -10F, 0F, -25F); // Box 188
        body[91].setRotationPoint(-752F, -1F, -95F);

        body[92].addShapeBox(0F, 0F, 0F, 135, 25, 160, 0F, 0F, 0F, -10F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -10F, -10F, 0F, -25F, 0F, 0F, -20F, 0F, 0F, -20F, -10F, 0F, -25F); // Box 189
        body[92].setRotationPoint(-742F, 29F, -80F);

        body[93].addShapeBox(0F, 0F, 0F, 70, 40, 220, 0F, 0F, 0F, 0F, 0F, 0F, -10F, 0F, 0F, -10F, 0F, 0F, 0F, 0F, 0F, -5F, 0F, 0F, -15F, 0F, 0F, -15F, 0F, 0F, -5F); // Box 193
        body[93].setRotationPoint(567F, -76F, -110F);

        body[94].addShapeBox(0F, 0F, 0F, 50, 40, 200, 0F, 0F, 0F, 0F, 0F, 0F, -15F, 0F, 0F, -15F, 0F, 0F, 0F, 0F, 0F, -5F, 0F, 0F, -20F, 0F, 0F, -20F, 0F, 0F, -5F); // Box 194
        body[94].setRotationPoint(637F, -76F, -100F);

        body[95].addShapeBox(0F, 0F, 0F, 50, 40, 170, 0F, 0F, 0F, 0F, 0F, 0F, -20F, 0F, 0F, -20F, 0F, 0F, 0F, 0F, 0F, -5F, 0F, 0F, -25F, 0F, 0F, -25F, 0F, 0F, -5F); // Box 195
        body[95].setRotationPoint(687F, -76F, -85F);

        body[96].addShapeBox(0F, 0F, 0F, 50, 40, 130, 0F, 0F, 0F, 0F, 0F, 0F, -25F, 0F, 0F, -25F, 0F, 0F, 0F, 0F, 0F, -5F, 0F, 0F, -30F, 0F, 0F, -30F, 0F, 0F, -5F); // Box 196
        body[96].setRotationPoint(737F, -76F, -65F);

        body[97].addShapeBox(0F, 0F, 0F, 45, 40, 80, 0F, 0F, 0F, 0F, 0F, 0F, -30F, 0F, 0F, -30F, 0F, 0F, 0F, 0F, 0F, -5F, 0F, 0F, -35F, 0F, 0F, -35F, 0F, 0F, -5F); // Box 197
        body[97].setRotationPoint(787F, -76F, -40F);

        body[98].addShapeBox(0F, 0F, 0F, 70, 35, 210, 0F, 0F, 0F, 0F, 0F, 0F, -10F, 0F, 0F, -10F, 0F, 0F, 0F, 0F, 0F, -10F, 0F, 0F, -20F, 0F, 0F, -20F, 0F, 0F, -10F); // Box 198
        body[98].setRotationPoint(567F, -36F, -105F);

        body[99].addShapeBox(0F, 0F, 0F, 70, 30, 190, 0F, 0F, 0F, 0F, 0F, 0F, -10F, 0F, 0F, -10F, 0F, 0F, 0F, 0F, 0F, -15F, 0F, 0F, -25F, 0F, 0F, -25F, 0F, 0F, -15F); // Box 199
        body[99].setRotationPoint(567F, -1F, -95F);

        body[100].addShapeBox(0F, 0F, 0F, 70, 25, 160, 0F, 0F, 0F, 0F, 0F, 0F, -10F, 0F, 0F, -10F, 0F, 0F, 0F, 0F, 0F, -20F, 0F, 0F, -30F, 0F, 0F, -30F, 0F, 0F, -20F); // Box 200
        body[100].setRotationPoint(567F, 29F, -80F);

        body[101].addShapeBox(0F, 0F, 0F, 70, 5, 220, 0F, 0F, 0F, 0F, 0F, 0F, -10F, 0F, 0F, -10F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -10F, 0F, 0F, -10F, 0F, 0F, 0F); // Box 204
        body[101].setRotationPoint(567F, -81F, -110F);

        body[102].addShapeBox(0F, 0F, 0F, 50, 5, 190, 0F, 0F, 0F, 5F, 0F, 0F, -10F, 0F, 0F, -10F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, -10F, 0F, 0F, -10F, 0F, 0F, 5F); // Box 205
        body[102].setRotationPoint(637F, -81F, -95F);

        body[103].addShapeBox(0F, 0F, 0F, 50, 5, 150, 0F, 0F, 0F, 10F, 0F, 0F, -10F, 0F, 0F, -10F, 0F, 0F, 10F, 0F, 0F, 10F, 0F, 0F, -10F, 0F, 0F, -10F, 0F, 0F, 10F); // Box 206
        body[103].setRotationPoint(687F, -81F, -75F);

        body[104].addShapeBox(0F, 0F, 0F, 50, 5, 100, 0F, 0F, 0F, 15F, 0F, 0F, -10F, 0F, 0F, -10F, 0F, 0F, 15F, 0F, 0F, 15F, 0F, 0F, -10F, 0F, 0F, -10F, 0F, 0F, 15F); // Box 207
        body[104].setRotationPoint(737F, -81F, -50F);

        body[105].addShapeBox(0F, 0F, 0F, 45, 5, 40, 0F, 0F, 0F, 20F, 0F, 0F, -10F, 0F, 0F, -10F, 0F, 0F, 20F, 0F, 0F, 20F, 0F, 0F, -10F, 0F, 0F, -10F, 0F, 0F, 20F); // Box 208
        body[105].setRotationPoint(787F, -81F, -20F);

        body[106].addShapeBox(0F, 0F, 0F, 70, 15, 3, 0F, 0F, 0F, -10F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 10F, 0F, 0F, -10F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 10F); // Box 209
        body[106].setRotationPoint(567F, -96F, 96F);

        body[107].addShapeBox(0F, 0F, 0F, 50, 15, 3, 0F, 0F, 0F, -15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 15F, 0F, 0F, -15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 15F); // Box 210
        body[107].setRotationPoint(637F, -96F, 81F);

        body[108].addShapeBox(0F, 0F, 0F, 50, 15, 3, 0F, 0F, 0F, -20F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 20F, 0F, 0F, -20F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 20F); // Box 211
        body[108].setRotationPoint(687F, -96F, 61F);

        body[109].addShapeBox(0F, 0F, 0F, 70, 15, 3, 0F, 0F, 0F, 10F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -10F, 0F, 0F, 10F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -10F); // Box 212
        body[109].setRotationPoint(567F, -96F, -99F);

        body[110].addShapeBox(0F, 0F, 0F, 50, 15, 3, 0F, 0F, 0F, 15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -15F, 0F, 0F, 15F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -15F); // Box 213
        body[110].setRotationPoint(637F, -96F, -84F);

        body[111].addShapeBox(0F, 0F, 0F, 50, 15, 3, 0F, 0F, 0F, 20F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -20F, 0F, 0F, 20F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -20F); // Box 214
        body[111].setRotationPoint(687F, -96F, -64F);

        body[112].addShapeBox(0F, 0F, 0F, 50, 15, 3, 0F, 0F, 0F, -25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 25F, 0F, 0F, -25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 25F); // Box 215
        body[112].setRotationPoint(737F, -96F, 36F);

        body[113].addShapeBox(0F, 0F, 0F, 45, 15, 3, 0F, 0F, 0F, -30F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 30F, 0F, 0F, -30F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 30F); // Box 216
        body[113].setRotationPoint(787F, -96F, 6F);

        body[114].addShapeBox(0F, 0F, 0F, 50, 15, 3, 0F, 0F, 0F, 25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -25F, 0F, 0F, 25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -25F); // Box 217
        body[114].setRotationPoint(737F, -96F, -39F);

        body[115].addShapeBox(0F, 0F, 0F, 45, 15, 3, 0F, 0F, 0F, 30F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -30F, 0F, 0F, 30F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -30F); // Box 218
        body[115].setRotationPoint(787F, -96F, -9F);

        body[116].addShapeBox(0F, 0F, 0F, 50, 35, 190, 0F, 0F, 0F, 0F, 0F, 0F, -15F, 0F, 0F, -15F, 0F, 0F, 0F, 0F, 0F, -10F, 0F, 0F, -25F, 0F, 0F, -25F, 0F, 0F, -10F); // Box 219
        body[116].setRotationPoint(637F, -36F, -95F);

        body[117].addShapeBox(0F, 0F, 0F, 50, 30, 170, 0F, 0F, 0F, 0F, 0F, 0F, -15F, 0F, 0F, -15F, 0F, 0F, 0F, 0F, 0F, -15F, 0F, 0F, -30F, 0F, 0F, -30F, 0F, 0F, -15F); // Box 220
        body[117].setRotationPoint(637F, -1F, -85F);

        body[118].addShapeBox(0F, 0F, 0F, 50, 25, 140, 0F, 0F, 0F, 0F, 0F, 0F, -15F, 0F, 0F, -15F, 0F, 0F, 0F, 0F, 0F, -20F, 0F, 0F, -35F, 0F, 0F, -35F, 0F, 0F, -20F); // Box 221
        body[118].setRotationPoint(637F, 29F, -70F);

        body[119].addShapeBox(0F, 0F, 0F, 50, 35, 155, 0F, 0F, 0F, 0F, 0F, 0F, -20F, 0F, 0F, -15F, 0F, 0F, 5F, 0F, 0F, -10F, 0F, 0F, -30F, 0F, 0F, -25F, 0F, 0F, -5F); // Box 223
        body[119].setRotationPoint(687F, -36F, -80F);

        body[120].addShapeBox(0F, 0F, 0F, 50, 30, 135, 0F, 0F, 0F, 0F, 0F, 0F, -20F, 0F, 0F, -15F, 0F, 0F, 5F, 0F, 0F, -15F, 0F, 0F, -35F, 0F, 0F, -35F, 0F, 0F, -10F); // Box 225
        body[120].setRotationPoint(687F, -1F, -70F);

        body[121].addShapeBox(0F, 0F, 0F, 50, 25, 100, 0F, 0F, 0F, 0F, 0F, 0F, -20F, 0F, 0F, -15F, 0F, 0F, 10F, 0F, 0F, -20F, 0F, 0F, -40F, 0F, 0F, -35F, 0F, 0F, -10F); // Box 226
        body[121].setRotationPoint(687F, 29F, -55F);

        body[122].addShapeBox(0F, 0F, 0F, 50, 35, 120, 0F, 0F, 0F, 0F, 0F, 0F, -25F, 0F, 0F, -25F, 0F, 0F, 0F, 0F, 0F, -10F, 0F, 0F, -35F, 0F, 0F, -35F, 0F, 0F, -10F); // Box 216
        body[122].setRotationPoint(737F, -36F, -60F);

        body[123].addShapeBox(0F, 0F, 0F, 50, 30, 100, 0F, 0F, 0F, 0F, 0F, 0F, -25F, 0F, 0F, -25F, 0F, 0F, 0F, 0F, 0F, -15F, 0F, 0F, -44F, 0F, 0F, -45F, 0F, 0F, -20F); // Box 217
        body[123].setRotationPoint(737F, -1F, -50F);

        body[124].addShapeBox(0F, 0F, 0F, 50, 25, 65, 0F, 0F, 0F, 0F, 0F, 0F, -29F, 0F, 0F, -25F, 0F, 0F, 0F, 0F, 0F, -20F, 0F, 0F, -34F, 0F, 0F, -31F, 0F, 0F, -20F); // Box 218
        body[124].setRotationPoint(737F, 29F, -35F);

        body[125].addShapeBox(0F, 0F, 0F, 45, 35, 70, 0F, 0F, 0F, 0F, 0F, 0F, -30F, 0F, 0F, -30F, 0F, 0F, 0F, 0F, 0F, -10F, 0F, 0F, -35F, 0F, 0F, -35F, 0F, 0F, -10F); // Box 219
        body[125].setRotationPoint(787F, -36F, -35F);

        body[126].addShapeBox(0F, 0F, 0F, 45, 30, 50, 0F, 0F, 0F, 0F, 0F, 0F, -25F, 0F, 0F, -25F, 0F, 0F, 0F, 0F, 0F, -19F, -15F, 0F, -25F, -15F, 0F, -25F, 0F, 0F, -20F); // Box 220
        body[126].setRotationPoint(787F, -1F, -25F);

        body[127].addShapeBox(0F, 0F, 0F, 10, 40, 10, 0F, 0F, 0F, 5F, 5F, 0F, -5F, 5F, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 0F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 0F); // Box 221
        body[127].setRotationPoint(832F, -76F, -5F);

        body[128].addShapeBox(0F, 0F, 0F, 10, 35, 10, 0F, 0F, 0F, 0F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 0F, 0F, 0F, -5F, -10F, 0F, -5F, -10F, 0F, -5F, 0F, 0F, -5F); // Box 222
        body[128].setRotationPoint(832F, -36F, -5F);

        body[129].addShapeBox(0F, 0F, 0F, 15, 5, 20, 0F, 0F, 0F, 0F, 0F, 0F, -10F, 0F, 0F, -10F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -10F, 0F, 0F, -10F, 0F, 0F, 0F); // Box 223
        body[129].setRotationPoint(832F, -81F, -10F);

        body[130].addShapeBox(0F, 0F, 0F, 15, 15, 1, 0F, 0F, 0F, 8F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -6F, 0F, 0F, 8F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -6F); // Box 224
        body[130].setRotationPoint(832F, -96F, -1F);

        body[131].addShapeBox(0F, 0F, 0F, 15, 15, 1, 0F, 0F, 0F, -6F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 8F, 0F, 0F, -6F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 8F); // Box 226
        body[131].setRotationPoint(832F, -96F, 0F);

        body[132].addShapeBox(0F, 0F, 0F, 30, 25, 11, 0F, 0F, 0F, 0F, 0F, 0F, -6F, 0F, 0F, -5F, 0F, 0F, 0F, 0F, 0F, -5F, -15F, 0F, -5F, -15F, 0F, -6F, 0F, 0F, -6F); // Box 227
        body[132].setRotationPoint(787F, 29F, -6F);
        this.add("body", body);

        ModelRendererTurbo[] turret = new ModelRendererTurbo[87];
        turret[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
        turret[1] = new ModelRendererTurbo(this, 297, 1, textureX, textureY); // Box 1
        turret[2] = new ModelRendererTurbo(this, 593, 1, textureX, textureY); // Box 2
        turret[3] = new ModelRendererTurbo(this, 889, 1, textureX, textureY); // Box 3
        turret[4] = new ModelRendererTurbo(this, 1185, 1, textureX, textureY); // Box 4
        turret[5] = new ModelRendererTurbo(this, 1481, 1, textureX, textureY); // Box 5
        turret[6] = new ModelRendererTurbo(this, 1777, 1, textureX, textureY); // Box 6
        turret[7] = new ModelRendererTurbo(this, 2073, 1, textureX, textureY); // Box 7
        turret[8] = new ModelRendererTurbo(this, 2369, 1, textureX, textureY); // Box 8
        turret[9] = new ModelRendererTurbo(this, 2665, 1, textureX, textureY); // Box 9
        turret[10] = new ModelRendererTurbo(this, 2961, 1, textureX, textureY); // Box 10
        turret[11] = new ModelRendererTurbo(this, 3257, 1, textureX, textureY); // Box 11
        turret[12] = new ModelRendererTurbo(this, 3553, 1, textureX, textureY); // Box 12
        turret[13] = new ModelRendererTurbo(this, 3753, 57, textureX, textureY); // Box 13
        turret[14] = new ModelRendererTurbo(this, 1, 153, textureX, textureY); // Box 14
        turret[15] = new ModelRendererTurbo(this, 297, 153, textureX, textureY); // Box 15
        turret[16] = new ModelRendererTurbo(this, 593, 153, textureX, textureY); // Box 16
        turret[17] = new ModelRendererTurbo(this, 889, 153, textureX, textureY); // Box 17
        turret[18] = new ModelRendererTurbo(this, 1185, 153, textureX, textureY); // Box 18
        turret[19] = new ModelRendererTurbo(this, 1481, 153, textureX, textureY); // Box 19
        turret[20] = new ModelRendererTurbo(this, 1777, 153, textureX, textureY); // Box 20
        turret[21] = new ModelRendererTurbo(this, 2073, 153, textureX, textureY); // Box 21
        turret[22] = new ModelRendererTurbo(this, 2369, 153, textureX, textureY); // Box 22
        turret[23] = new ModelRendererTurbo(this, 2665, 153, textureX, textureY); // Box 23
        turret[24] = new ModelRendererTurbo(this, 2961, 153, textureX, textureY); // Box 24
        turret[25] = new ModelRendererTurbo(this, 3257, 153, textureX, textureY); // Box 25
        turret[26] = new ModelRendererTurbo(this, 3553, 153, textureX, textureY); // Box 26
        turret[27] = new ModelRendererTurbo(this, 3753, 209, textureX, textureY); // Box 27
        turret[28] = new ModelRendererTurbo(this, 1, 305, textureX, textureY); // Box 28
        turret[29] = new ModelRendererTurbo(this, 297, 305, textureX, textureY); // Box 29
        turret[30] = new ModelRendererTurbo(this, 593, 305, textureX, textureY); // Box 30
        turret[31] = new ModelRendererTurbo(this, 889, 305, textureX, textureY); // Box 31
        turret[32] = new ModelRendererTurbo(this, 1185, 305, textureX, textureY); // Box 32
        turret[33] = new ModelRendererTurbo(this, 1481, 305, textureX, textureY); // Box 33
        turret[34] = new ModelRendererTurbo(this, 1777, 305, textureX, textureY); // Box 34
        turret[35] = new ModelRendererTurbo(this, 2073, 305, textureX, textureY); // Box 35
        turret[36] = new ModelRendererTurbo(this, 2369, 305, textureX, textureY); // Box 36
        turret[37] = new ModelRendererTurbo(this, 2665, 305, textureX, textureY); // Box 37
        turret[38] = new ModelRendererTurbo(this, 2961, 305, textureX, textureY); // Box 38
        turret[39] = new ModelRendererTurbo(this, 3257, 305, textureX, textureY); // Box 39
        turret[40] = new ModelRendererTurbo(this, 3553, 305, textureX, textureY); // Box 40
        turret[41] = new ModelRendererTurbo(this, 3753, 361, textureX, textureY); // Box 41
        turret[42] = new ModelRendererTurbo(this, 1, 457, textureX, textureY); // Box 42
        turret[43] = new ModelRendererTurbo(this, 297, 457, textureX, textureY); // Box 43
        turret[44] = new ModelRendererTurbo(this, 593, 457, textureX, textureY); // Box 44
        turret[45] = new ModelRendererTurbo(this, 889, 457, textureX, textureY); // Box 45
        turret[46] = new ModelRendererTurbo(this, 1185, 457, textureX, textureY); // Box 46
        turret[47] = new ModelRendererTurbo(this, 1481, 457, textureX, textureY); // Box 47
        turret[48] = new ModelRendererTurbo(this, 1777, 457, textureX, textureY); // Box 48
        turret[49] = new ModelRendererTurbo(this, 2073, 457, textureX, textureY); // Box 49
        turret[50] = new ModelRendererTurbo(this, 2369, 457, textureX, textureY); // Box 50
        turret[51] = new ModelRendererTurbo(this, 2665, 457, textureX, textureY); // Box 51
        turret[52] = new ModelRendererTurbo(this, 2961, 457, textureX, textureY); // Box 52
        turret[53] = new ModelRendererTurbo(this, 3257, 457, textureX, textureY); // Box 53
        turret[54] = new ModelRendererTurbo(this, 3553, 457, textureX, textureY); // Box 54
        turret[55] = new ModelRendererTurbo(this, 3753, 513, textureX, textureY); // Box 55
        turret[56] = new ModelRendererTurbo(this, 1, 609, textureX, textureY); // Box 56
        turret[57] = new ModelRendererTurbo(this, 297, 609, textureX, textureY); // Box 57
        turret[58] = new ModelRendererTurbo(this, 593, 609, textureX, textureY); // Box 58
        turret[59] = new ModelRendererTurbo(this, 889, 609, textureX, textureY); // Box 59
        turret[60] = new ModelRendererTurbo(this, 1185, 609, textureX, textureY); // Box 60
        turret[61] = new ModelRendererTurbo(this, 1481, 609, textureX, textureY); // Box 61
        turret[62] = new ModelRendererTurbo(this, 1777, 609, textureX, textureY); // Box 62
        turret[63] = new ModelRendererTurbo(this, 2073, 609, textureX, textureY); // Box 63
        turret[64] = new ModelRendererTurbo(this, 2369, 609, textureX, textureY); // Box 64
        turret[65] = new ModelRendererTurbo(this, 2665, 609, textureX, textureY); // Box 65
        turret[66] = new ModelRendererTurbo(this, 2961, 609, textureX, textureY); // Box 66
        turret[67] = new ModelRendererTurbo(this, 3257, 609, textureX, textureY); // Box 67
        turret[68] = new ModelRendererTurbo(this, 3553, 609, textureX, textureY); // Box 68
        turret[69] = new ModelRendererTurbo(this, 3753, 665, textureX, textureY); // Box 69
        turret[70] = new ModelRendererTurbo(this, 1, 761, textureX, textureY); // Box 70
        turret[71] = new ModelRendererTurbo(this, 297, 761, textureX, textureY); // Box 71
        turret[72] = new ModelRendererTurbo(this, 593, 761, textureX, textureY); // Box 72
        turret[73] = new ModelRendererTurbo(this, 889, 761, textureX, textureY); // Box 73
        turret[74] = new ModelRendererTurbo(this, 1185, 761, textureX, textureY); // Box 74
        turret[75] = new ModelRendererTurbo(this, 1481, 761, textureX, textureY); // Box 75
        turret[76] = new ModelRendererTurbo(this, 1777, 761, textureX, textureY); // Box 76
        turret[77] = new ModelRendererTurbo(this, 2073, 761, textureX, textureY); // Box 77
        turret[78] = new ModelRendererTurbo(this, 2369, 761, textureX, textureY); // Box 78
        turret[79] = new ModelRendererTurbo(this, 2665, 761, textureX, textureY); // Box 79
        turret[80] = new ModelRendererTurbo(this, 2961, 761, textureX, textureY); // Box 80
        turret[81] = new ModelRendererTurbo(this, 3257, 761, textureX, textureY); // Box 81
        turret[82] = new ModelRendererTurbo(this, 3073, 1169, textureX, textureY); // Box 190
        turret[83] = new ModelRendererTurbo(this, 3713, 1281, textureX, textureY); // Box 191
        turret[84] = new ModelRendererTurbo(this, 993, 1401, textureX, textureY); // Box 192
        turret[85] = new ModelRendererTurbo(this, 2001, 2113, textureX, textureY); // Box 228
        turret[86] = new ModelRendererTurbo(this, 3073, 2113, textureX, textureY); // Box 230

        turret[0].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 0
        turret[0].setRotationPoint(-48F, -129F, -96F);

        turret[1].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 1
        turret[1].setRotationPoint(-48F, -129F, 0F);

        turret[2].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 2
        turret[2].setRotationPoint(3F, -129F, -96F);

        turret[3].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 3
        turret[3].setRotationPoint(3F, -129F, 0F);

        turret[4].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 4
        turret[4].setRotationPoint(3F, -177F, 0F);

        turret[5].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 5
        turret[5].setRotationPoint(-48F, -177F, 0F);

        turret[6].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 6
        turret[6].setRotationPoint(3F, -177F, -96F);

        turret[7].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 7
        turret[7].setRotationPoint(-48F, -177F, -96F);

        turret[8].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 8
        turret[8].setRotationPoint(106F, -177F, 0F);

        turret[9].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 9
        turret[9].setRotationPoint(55F, -177F, 0F);

        turret[10].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 10
        turret[10].setRotationPoint(106F, -177F, -96F);

        turret[11].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 11
        turret[11].setRotationPoint(55F, -177F, -96F);

        turret[12].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 12
        turret[12].setRotationPoint(106F, -129F, 0F);

        turret[13].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 13
        turret[13].setRotationPoint(55F, -129F, 0F);

        turret[14].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 14
        turret[14].setRotationPoint(55F, -129F, -96F);

        turret[15].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 15
        turret[15].setRotationPoint(106F, -129F, -96F);

        turret[16].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 16
        turret[16].setRotationPoint(312F, -177F, 0F);

        turret[17].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 17
        turret[17].setRotationPoint(261F, -177F, 0F);

        turret[18].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 18
        turret[18].setRotationPoint(312F, -177F, -96F);

        turret[19].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 19
        turret[19].setRotationPoint(261F, -177F, -96F);

        turret[20].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 20
        turret[20].setRotationPoint(312F, -129F, 0F);

        turret[21].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 21
        turret[21].setRotationPoint(261F, -129F, 0F);

        turret[22].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 22
        turret[22].setRotationPoint(261F, -129F, -96F);

        turret[23].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 23
        turret[23].setRotationPoint(312F, -129F, -96F);

        turret[24].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 24
        turret[24].setRotationPoint(209F, -177F, 0F);

        turret[25].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 25
        turret[25].setRotationPoint(158F, -177F, 0F);

        turret[26].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 26
        turret[26].setRotationPoint(158F, -177F, -96F);

        turret[27].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 27
        turret[27].setRotationPoint(209F, -177F, -96F);

        turret[28].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 28
        turret[28].setRotationPoint(158F, -129F, -96F);

        turret[29].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 29
        turret[29].setRotationPoint(209F, -129F, -96F);

        turret[30].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 30
        turret[30].setRotationPoint(209F, -129F, 0F);

        turret[31].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 31
        turret[31].setRotationPoint(158F, -129F, 0F);

        turret[32].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 32
        turret[32].setRotationPoint(519F, -177F, 0F);

        turret[33].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 33
        turret[33].setRotationPoint(468F, -177F, 0F);

        turret[34].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 34
        turret[34].setRotationPoint(519F, -177F, -96F);

        turret[35].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 35
        turret[35].setRotationPoint(468F, -177F, -96F);

        turret[36].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 36
        turret[36].setRotationPoint(519F, -129F, 0F);

        turret[37].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 37
        turret[37].setRotationPoint(468F, -129F, 0F);

        turret[38].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 38
        turret[38].setRotationPoint(468F, -129F, -96F);

        turret[39].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 39
        turret[39].setRotationPoint(519F, -129F, -96F);

        turret[40].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 40
        turret[40].setRotationPoint(416F, -177F, 0F);

        turret[41].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 41
        turret[41].setRotationPoint(365F, -177F, 0F);

        turret[42].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 42
        turret[42].setRotationPoint(365F, -177F, -96F);

        turret[43].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 43
        turret[43].setRotationPoint(416F, -177F, -96F);

        turret[44].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 44
        turret[44].setRotationPoint(365F, -129F, -96F);

        turret[45].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 45
        turret[45].setRotationPoint(416F, -129F, -96F);

        turret[46].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 46
        turret[46].setRotationPoint(416F, -129F, 0F);

        turret[47].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 47
        turret[47].setRotationPoint(365F, -129F, 0F);

        turret[48].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 48
        turret[48].setRotationPoint(-101F, -177F, 0F);

        turret[49].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 49
        turret[49].setRotationPoint(-152F, -177F, 0F);

        turret[50].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 50
        turret[50].setRotationPoint(-101F, -177F, -96F);

        turret[51].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 51
        turret[51].setRotationPoint(-152F, -177F, -96F);

        turret[52].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 52
        turret[52].setRotationPoint(-101F, -129F, 0F);

        turret[53].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 53
        turret[53].setRotationPoint(-152F, -129F, 0F);

        turret[54].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 54
        turret[54].setRotationPoint(-152F, -129F, -96F);

        turret[55].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 55
        turret[55].setRotationPoint(-101F, -129F, -96F);

        turret[56].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 56
        turret[56].setRotationPoint(-204F, -177F, 0F);

        turret[57].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 57
        turret[57].setRotationPoint(-255F, -177F, 0F);

        turret[58].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 58
        turret[58].setRotationPoint(-255F, -177F, -96F);

        turret[59].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 59
        turret[59].setRotationPoint(-204F, -177F, -96F);

        turret[60].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 60
        turret[60].setRotationPoint(-255F, -129F, -96F);

        turret[61].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 61
        turret[61].setRotationPoint(-204F, -129F, -96F);

        turret[62].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 62
        turret[62].setRotationPoint(-204F, -129F, 0F);

        turret[63].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 63
        turret[63].setRotationPoint(-255F, -129F, 0F);

        turret[64].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 64
        turret[64].setRotationPoint(-307F, -177F, 0F);

        turret[65].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 65
        turret[65].setRotationPoint(-358F, -177F, 0F);

        turret[66].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 66
        turret[66].setRotationPoint(-307F, -177F, -96F);

        turret[67].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 67
        turret[67].setRotationPoint(-358F, -177F, -96F);

        turret[68].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 68
        turret[68].setRotationPoint(-307F, -129F, 0F);

        turret[69].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 69
        turret[69].setRotationPoint(-358F, -129F, 0F);

        turret[70].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 70
        turret[70].setRotationPoint(-358F, -129F, -96F);

        turret[71].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 71
        turret[71].setRotationPoint(-307F, -129F, -96F);

        turret[72].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 72
        turret[72].setRotationPoint(-410F, -177F, 0F);

        turret[73].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 73
        turret[73].setRotationPoint(-461F, -177F, 0F);

        turret[74].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 74
        turret[74].setRotationPoint(-461F, -177F, -96F);

        turret[75].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 75
        turret[75].setRotationPoint(-410F, -177F, -96F);

        turret[76].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 76
        turret[76].setRotationPoint(-461F, -129F, -96F);

        turret[77].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 77
        turret[77].setRotationPoint(-410F, -129F, -96F);

        turret[78].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 78
        turret[78].setRotationPoint(-410F, -129F, 0F);

        turret[79].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 79
        turret[79].setRotationPoint(-461F, -129F, 0F);

        turret[80].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 80
        turret[80].setRotationPoint(575F, -129F, -50F);

        turret[81].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 81
        turret[81].setRotationPoint(568F, -177F, -50F);

        turret[82].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 190
        turret[82].setRotationPoint(-701F, -129F, -48F);

        turret[83].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 191
        turret[83].setRotationPoint(-752F, -129F, -47F);

        turret[84].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 192
        turret[84].setRotationPoint(-701F, -177F, -48F);

        turret[85].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 228
        turret[85].setRotationPoint(625F, -129F, -50F);

        turret[86].addBox(0F, 0F, 0F, 48, 48, 96, 0F); // Box 230
        turret[86].setRotationPoint(618F, -177F, -50F);
        this.add("turret", turret); this.get("turret").addProgram(DefaultPrograms.DOOR_CLOSE);
        //
        fixRotations();
    }

}