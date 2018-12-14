package net.fexcraft.mod.addons.zmp.models.trailer;

import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.vehicle.VehicleModel;

public class ModelCarTransporter extends VehicleModel {

    public ModelCarTransporter(){
    	super(); textureX = 512; textureY = 512;
    	ModelRendererTurbo[] body = new ModelRendererTurbo[176];
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
        body[22] = new ModelRendererTurbo(this, 417, 9, textureX, textureY); // Box 33
        body[23] = new ModelRendererTurbo(this, 353, 9, textureX, textureY); // Box 34
        body[24] = new ModelRendererTurbo(this, 385, 9, textureX, textureY); // Box 35
        body[25] = new ModelRendererTurbo(this, 449, 9, textureX, textureY); // Box 36
        body[26] = new ModelRendererTurbo(this, 1, 9, textureX, textureY); // Box 506
        body[27] = new ModelRendererTurbo(this, 177, 9, textureX, textureY); // Box 506
        body[28] = new ModelRendererTurbo(this, 481, 9, textureX, textureY); // Box 506
        body[29] = new ModelRendererTurbo(this, 497, 9, textureX, textureY); // Box 506
        body[30] = new ModelRendererTurbo(this, 201, 17, textureX, textureY); // Box 506
        body[31] = new ModelRendererTurbo(this, 217, 17, textureX, textureY); // Box 506
        body[32] = new ModelRendererTurbo(this, 233, 17, textureX, textureY); // Box 506
        body[33] = new ModelRendererTurbo(this, 281, 17, textureX, textureY); // Box 506
        body[34] = new ModelRendererTurbo(this, 297, 17, textureX, textureY); // Box 506
        body[35] = new ModelRendererTurbo(this, 313, 17, textureX, textureY); // Box 506
        body[36] = new ModelRendererTurbo(this, 433, 17, textureX, textureY); // Box 506
        body[37] = new ModelRendererTurbo(this, 449, 17, textureX, textureY); // Box 506
        body[38] = new ModelRendererTurbo(this, 465, 17, textureX, textureY); // Box 506
        body[39] = new ModelRendererTurbo(this, 481, 17, textureX, textureY); // Box 506
        body[40] = new ModelRendererTurbo(this, 497, 17, textureX, textureY); // Box 506
        body[41] = new ModelRendererTurbo(this, 1, 25, textureX, textureY); // Box 506
        body[42] = new ModelRendererTurbo(this, 17, 25, textureX, textureY); // Box 506
        body[43] = new ModelRendererTurbo(this, 33, 25, textureX, textureY); // Box 506
        body[44] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 506
        body[45] = new ModelRendererTurbo(this, 17, 17, textureX, textureY); // Box 506
        body[46] = new ModelRendererTurbo(this, 33, 17, textureX, textureY); // Box 506
        body[47] = new ModelRendererTurbo(this, 49, 17, textureX, textureY); // Box 506
        body[48] = new ModelRendererTurbo(this, 65, 17, textureX, textureY); // Box 506
        body[49] = new ModelRendererTurbo(this, 81, 17, textureX, textureY); // Box 506
        body[50] = new ModelRendererTurbo(this, 97, 17, textureX, textureY); // Box 506
        body[51] = new ModelRendererTurbo(this, 113, 17, textureX, textureY); // Box 506
        body[52] = new ModelRendererTurbo(this, 129, 17, textureX, textureY); // Box 506
        body[53] = new ModelRendererTurbo(this, 145, 17, textureX, textureY); // Box 506
        body[54] = new ModelRendererTurbo(this, 161, 17, textureX, textureY); // Box 506
        body[55] = new ModelRendererTurbo(this, 177, 17, textureX, textureY); // Box 506
        body[56] = new ModelRendererTurbo(this, 249, 17, textureX, textureY); // Box 506
        body[57] = new ModelRendererTurbo(this, 265, 17, textureX, textureY); // Box 506
        body[58] = new ModelRendererTurbo(this, 329, 17, textureX, textureY); // Box 506
        body[59] = new ModelRendererTurbo(this, 353, 17, textureX, textureY); // Box 506
        body[60] = new ModelRendererTurbo(this, 49, 25, textureX, textureY); // Box 506
        body[61] = new ModelRendererTurbo(this, 65, 25, textureX, textureY); // Box 506
        body[62] = new ModelRendererTurbo(this, 81, 25, textureX, textureY); // Box 506
        body[63] = new ModelRendererTurbo(this, 97, 25, textureX, textureY); // Box 506
        body[64] = new ModelRendererTurbo(this, 113, 25, textureX, textureY); // Box 506
        body[65] = new ModelRendererTurbo(this, 129, 25, textureX, textureY); // Box 506
        body[66] = new ModelRendererTurbo(this, 145, 25, textureX, textureY); // Box 506
        body[67] = new ModelRendererTurbo(this, 161, 25, textureX, textureY); // Box 506
        body[68] = new ModelRendererTurbo(this, 177, 25, textureX, textureY); // Box 506
        body[69] = new ModelRendererTurbo(this, 201, 25, textureX, textureY); // Box 506
        body[70] = new ModelRendererTurbo(this, 217, 25, textureX, textureY); // Box 506
        body[71] = new ModelRendererTurbo(this, 233, 25, textureX, textureY); // Box 506
        body[72] = new ModelRendererTurbo(this, 249, 25, textureX, textureY); // Box 506
        body[73] = new ModelRendererTurbo(this, 265, 25, textureX, textureY); // Box 506
        body[74] = new ModelRendererTurbo(this, 281, 25, textureX, textureY); // Box 506
        body[75] = new ModelRendererTurbo(this, 297, 25, textureX, textureY); // Box 506
        body[76] = new ModelRendererTurbo(this, 313, 25, textureX, textureY); // Box 141
        body[77] = new ModelRendererTurbo(this, 329, 25, textureX, textureY); // Box 142
        body[78] = new ModelRendererTurbo(this, 345, 25, textureX, textureY); // Box 143
        body[79] = new ModelRendererTurbo(this, 361, 25, textureX, textureY); // Box 144
        body[80] = new ModelRendererTurbo(this, 377, 25, textureX, textureY); // Box 145
        body[81] = new ModelRendererTurbo(this, 393, 25, textureX, textureY); // Box 146
        body[82] = new ModelRendererTurbo(this, 409, 25, textureX, textureY); // Box 147
        body[83] = new ModelRendererTurbo(this, 425, 25, textureX, textureY); // Box 148
        body[84] = new ModelRendererTurbo(this, 441, 25, textureX, textureY); // Box 149
        body[85] = new ModelRendererTurbo(this, 457, 25, textureX, textureY); // Box 150
        body[86] = new ModelRendererTurbo(this, 473, 25, textureX, textureY); // Box 151
        body[87] = new ModelRendererTurbo(this, 489, 25, textureX, textureY); // Box 152
        body[88] = new ModelRendererTurbo(this, 1, 33, textureX, textureY); // Box 153
        body[89] = new ModelRendererTurbo(this, 17, 33, textureX, textureY); // Box 154
        body[90] = new ModelRendererTurbo(this, 33, 33, textureX, textureY); // Box 155
        body[91] = new ModelRendererTurbo(this, 57, 33, textureX, textureY); // Box 156
        body[92] = new ModelRendererTurbo(this, 73, 33, textureX, textureY); // Box 157
        body[93] = new ModelRendererTurbo(this, 89, 33, textureX, textureY); // Box 158
        body[94] = new ModelRendererTurbo(this, 369, 17, textureX, textureY); // Box 159
        body[95] = new ModelRendererTurbo(this, 385, 17, textureX, textureY); // Box 160
        body[96] = new ModelRendererTurbo(this, 401, 17, textureX, textureY); // Box 161
        body[97] = new ModelRendererTurbo(this, 417, 17, textureX, textureY); // Box 162
        body[98] = new ModelRendererTurbo(this, 105, 33, textureX, textureY); // Box 163
        body[99] = new ModelRendererTurbo(this, 121, 33, textureX, textureY); // Box 164
        body[100] = new ModelRendererTurbo(this, 137, 33, textureX, textureY); // Box 165
        body[101] = new ModelRendererTurbo(this, 153, 33, textureX, textureY); // Box 166
        body[102] = new ModelRendererTurbo(this, 169, 33, textureX, textureY); // Box 167
        body[103] = new ModelRendererTurbo(this, 209, 33, textureX, textureY); // Box 168
        body[104] = new ModelRendererTurbo(this, 225, 33, textureX, textureY); // Box 169
        body[105] = new ModelRendererTurbo(this, 241, 33, textureX, textureY); // Box 170
        body[106] = new ModelRendererTurbo(this, 257, 33, textureX, textureY); // Box 171
        body[107] = new ModelRendererTurbo(this, 273, 33, textureX, textureY); // Box 172
        body[108] = new ModelRendererTurbo(this, 289, 33, textureX, textureY); // Box 173
        body[109] = new ModelRendererTurbo(this, 305, 33, textureX, textureY); // Box 174
        body[110] = new ModelRendererTurbo(this, 321, 33, textureX, textureY); // Box 175
        body[111] = new ModelRendererTurbo(this, 337, 33, textureX, textureY); // Box 176
        body[112] = new ModelRendererTurbo(this, 353, 33, textureX, textureY); // Box 177
        body[113] = new ModelRendererTurbo(this, 369, 33, textureX, textureY); // Box 178
        body[114] = new ModelRendererTurbo(this, 385, 33, textureX, textureY); // Box 179
        body[115] = new ModelRendererTurbo(this, 401, 33, textureX, textureY); // Box 180
        body[116] = new ModelRendererTurbo(this, 417, 33, textureX, textureY); // Box 181
        body[117] = new ModelRendererTurbo(this, 433, 33, textureX, textureY); // Box 182
        body[118] = new ModelRendererTurbo(this, 449, 33, textureX, textureY); // Box 183
        body[119] = new ModelRendererTurbo(this, 465, 33, textureX, textureY); // Box 184
        body[120] = new ModelRendererTurbo(this, 481, 33, textureX, textureY); // Box 185
        body[121] = new ModelRendererTurbo(this, 497, 33, textureX, textureY); // Box 186
        body[122] = new ModelRendererTurbo(this, 1, 41, textureX, textureY); // Box 187
        body[123] = new ModelRendererTurbo(this, 17, 41, textureX, textureY); // Box 188
        body[124] = new ModelRendererTurbo(this, 33, 41, textureX, textureY); // Box 189
        body[125] = new ModelRendererTurbo(this, 49, 41, textureX, textureY); // Box 190
        body[126] = new ModelRendererTurbo(this, 65, 41, textureX, textureY); // Box 191
        body[127] = new ModelRendererTurbo(this, 89, 41, textureX, textureY); // Box 192
        body[128] = new ModelRendererTurbo(this, 505, 1, textureX, textureY); // Box 143
        body[129] = new ModelRendererTurbo(this, 505, 25, textureX, textureY); // Box 144
        body[130] = new ModelRendererTurbo(this, 17, 9, textureX, textureY); // Box 145
        body[131] = new ModelRendererTurbo(this, 41, 9, textureX, textureY); // Box 146
        body[132] = new ModelRendererTurbo(this, 57, 49, textureX, textureY); // Box 154
        body[133] = new ModelRendererTurbo(this, 225, 41, textureX, textureY); // Box 299
        body[134] = new ModelRendererTurbo(this, 241, 41, textureX, textureY); // Box 300
        body[135] = new ModelRendererTurbo(this, 265, 41, textureX, textureY); // Box 8
        body[136] = new ModelRendererTurbo(this, 113, 41, textureX, textureY); // Box 9
        body[137] = new ModelRendererTurbo(this, 273, 41, textureX, textureY); // Box 173
        body[138] = new ModelRendererTurbo(this, 193, 49, textureX, textureY); // Box 175
        body[139] = new ModelRendererTurbo(this, 297, 49, textureX, textureY); // Box 176
        body[140] = new ModelRendererTurbo(this, 329, 49, textureX, textureY); // Box 178
        body[141] = new ModelRendererTurbo(this, 129, 41, textureX, textureY); // Box 16
        body[142] = new ModelRendererTurbo(this, 321, 49, textureX, textureY); // Box 18
        body[143] = new ModelRendererTurbo(this, 49, 9, textureX, textureY); // Box 37
        body[144] = new ModelRendererTurbo(this, 73, 9, textureX, textureY); // Box 38
        body[145] = new ModelRendererTurbo(this, 81, 9, textureX, textureY); // Box 39
        body[146] = new ModelRendererTurbo(this, 105, 9, textureX, textureY); // Box 40
        body[147] = new ModelRendererTurbo(this, 1, 65, textureX, textureY); // Box 179
        body[148] = new ModelRendererTurbo(this, 353, 33, textureX, textureY); // Box 188
        body[149] = new ModelRendererTurbo(this, 361, 65, textureX, textureY); // Box 173
        body[150] = new ModelRendererTurbo(this, 177, 73, textureX, textureY); // Box 174
        body[151] = new ModelRendererTurbo(this, 313, 81, textureX, textureY); // Box 175
        body[152] = new ModelRendererTurbo(this, 449, 81, textureX, textureY); // Box 176
        body[153] = new ModelRendererTurbo(this, 193, 89, textureX, textureY); // Box 177
        body[154] = new ModelRendererTurbo(this, 225, 89, textureX, textureY); // Box 178
        body[155] = new ModelRendererTurbo(this, 257, 89, textureX, textureY); // Box 179
        body[156] = new ModelRendererTurbo(this, 1, 97, textureX, textureY); // Box 181
        body[157] = new ModelRendererTurbo(this, 33, 97, textureX, textureY); // Box 182
        body[158] = new ModelRendererTurbo(this, 265, 97, textureX, textureY); // Box 183
        body[159] = new ModelRendererTurbo(this, 401, 49, textureX, textureY); // Box 184
        body[160] = new ModelRendererTurbo(this, 353, 49, textureX, textureY); // Box 185
        body[161] = new ModelRendererTurbo(this, 385, 49, textureX, textureY); // Box 186
        body[162] = new ModelRendererTurbo(this, 41, 97, textureX, textureY); // Box 187
        body[163] = new ModelRendererTurbo(this, 105, 97, textureX, textureY); // Box 188
        body[164] = new ModelRendererTurbo(this, 433, 33, textureX, textureY); // Box 164
        body[165] = new ModelRendererTurbo(this, 185, 113, textureX, textureY); // Box 165
        body[166] = new ModelRendererTurbo(this, 433, 113, textureX, textureY); // Box 166
        body[167] = new ModelRendererTurbo(this, 217, 121, textureX, textureY); // Box 167
        body[168] = new ModelRendererTurbo(this, 1, 129, textureX, textureY); // Box 168
        body[169] = new ModelRendererTurbo(this, 73, 129, textureX, textureY); // Box 169
        body[170] = new ModelRendererTurbo(this, 137, 129, textureX, textureY); // Box 170
        body[171] = new ModelRendererTurbo(this, 249, 129, textureX, textureY); // Box 171
        body[172] = new ModelRendererTurbo(this, 17, 9, textureX, textureY); // Box 172
        body[173] = new ModelRendererTurbo(this, 505, 25, textureX, textureY); // Box 173
        body[174] = new ModelRendererTurbo(this, 41, 9, textureX, textureY); // Box 174
        body[175] = new ModelRendererTurbo(this, 505, 1, textureX, textureY); // Box 175

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

        body[22].addBox(0F, 0F, 0F, 14, 1, 1, 0F); // Box 33
        body[22].setRotationPoint(-83F, -2.7F, -16.5F);

        body[23].addBox(0F, 0F, 0F, 12, 1, 1, 0F); // Box 34
        body[23].setRotationPoint(-82F, -3.7F, -16.5F);

        body[24].addBox(0F, 0F, 0F, 12, 1, 1, 0F); // Box 35
        body[24].setRotationPoint(-82F, -3.7F, 14.5F);

        body[25].addBox(0F, 0F, 0F, 14, 1, 1, 0F); // Box 36
        body[25].setRotationPoint(-83F, -2.7F, 14.5F);

        body[26].addShapeBox(-0.5F, -1.5F, -1.5F, 2, 3, 2, 0F, -0.5F, 0.25F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, -0.5F, 0.25F, 0F, -0.5F, 0.25F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, -0.5F, 0.25F, 0F); // Box 506
        body[26].setRotationPoint(-75.5F, 2.05F, 19F);

        body[27].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[27].setRotationPoint(-75.5F, 2.05F, 20F);

        body[28].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[28].setRotationPoint(-75.5F, 2.05F, 20F);
        body[28].rotationAngleZ = Static.toDegrees(-0.39269908F);

        body[29].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[29].setRotationPoint(-75.5F, 2.05F, 20F);
        body[29].rotationAngleZ = Static.toDegrees(-1.17809725F);

        body[30].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[30].setRotationPoint(-75.5F, 2.05F, 20F);
        body[30].rotationAngleZ = Static.toDegrees(-0.78539816F);

        body[31].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[31].setRotationPoint(-75.5F, 2.05F, 20F);
        body[31].rotationAngleZ = Static.toDegrees(-2.74889357F);

        body[32].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[32].setRotationPoint(-75.5F, 2.05F, 20F);
        body[32].rotationAngleZ = Static.toDegrees(-2.35619449F);

        body[33].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[33].setRotationPoint(-75.5F, 2.05F, 20F);
        body[33].rotationAngleZ = Static.toDegrees(-1.96349541F);

        body[34].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[34].setRotationPoint(-75.5F, 2.05F, 20F);
        body[34].rotationAngleZ = Static.toDegrees(-1.57079633F);

        body[35].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[35].setRotationPoint(-75.5F, 2.05F, 20F);
        body[35].rotationAngleZ = Static.toDegrees(-5.89048623F);

        body[36].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[36].setRotationPoint(-75.5F, 2.05F, 20F);
        body[36].rotationAngleZ = Static.toDegrees(-5.49778714F);

        body[37].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[37].setRotationPoint(-75.5F, 2.05F, 20F);
        body[37].rotationAngleZ = Static.toDegrees(-5.10508806F);

        body[38].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[38].setRotationPoint(-75.5F, 2.05F, 20F);
        body[38].rotationAngleZ = Static.toDegrees(-4.71238898F);

        body[39].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[39].setRotationPoint(-75.5F, 2.05F, 20F);
        body[39].rotationAngleZ = Static.toDegrees(-4.3196899F);

        body[40].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[40].setRotationPoint(-75.5F, 2.05F, 20F);
        body[40].rotationAngleZ = Static.toDegrees(-3.92699082F);

        body[41].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[41].setRotationPoint(-75.5F, 2.05F, 20F);
        body[41].rotationAngleZ = Static.toDegrees(-3.53429174F);

        body[42].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 506
        body[42].setRotationPoint(-75.5F, 2.05F, 20F);
        body[42].rotationAngleZ = Static.toDegrees(-3.14159265F);

        body[43].addShapeBox(-1.5F, -1.5F, -1.5F, 2, 3, 2, 0F, 0F, -0.75F, 0F, -0.5F, 0.25F, 0F, -0.5F, 0.25F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, -0.5F, 0.25F, 0F, -0.5F, 0.25F, 0F, 0F, -0.75F, 0F); // Box 506
        body[43].setRotationPoint(-75.5F, 2.05F, 19F);

        body[44].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[44].setRotationPoint(-75.5F, 2.05F, 20F);

        body[45].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[45].setRotationPoint(-75.5F, 2.05F, 20F);
        body[45].rotationAngleZ = Static.toDegrees(-0.39269908F);

        body[46].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[46].setRotationPoint(-75.5F, 2.05F, 20F);
        body[46].rotationAngleZ = Static.toDegrees(-1.17809725F);

        body[47].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[47].setRotationPoint(-75.5F, 2.05F, 20F);
        body[47].rotationAngleZ = Static.toDegrees(-0.78539816F);

        body[48].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[48].setRotationPoint(-75.5F, 2.05F, 20F);
        body[48].rotationAngleZ = Static.toDegrees(-2.74889357F);

        body[49].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[49].setRotationPoint(-75.5F, 2.05F, 20F);
        body[49].rotationAngleZ = Static.toDegrees(-2.35619449F);

        body[50].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[50].setRotationPoint(-75.5F, 2.05F, 20F);
        body[50].rotationAngleZ = Static.toDegrees(-1.96349541F);

        body[51].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[51].setRotationPoint(-75.5F, 2.05F, 20F);
        body[51].rotationAngleZ = Static.toDegrees(-1.57079633F);

        body[52].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[52].setRotationPoint(-75.5F, 2.05F, 20F);
        body[52].rotationAngleZ = Static.toDegrees(-5.89048623F);

        body[53].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[53].setRotationPoint(-75.5F, 2.05F, 20F);
        body[53].rotationAngleZ = Static.toDegrees(-5.49778714F);

        body[54].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[54].setRotationPoint(-75.5F, 2.05F, 20F);
        body[54].rotationAngleZ = Static.toDegrees(-5.10508806F);

        body[55].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[55].setRotationPoint(-75.5F, 2.05F, 20F);
        body[55].rotationAngleZ = Static.toDegrees(-4.71238898F);

        body[56].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[56].setRotationPoint(-75.5F, 2.05F, 20F);
        body[56].rotationAngleZ = Static.toDegrees(-4.3196899F);

        body[57].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[57].setRotationPoint(-75.5F, 2.05F, 20F);
        body[57].rotationAngleZ = Static.toDegrees(-3.92699082F);

        body[58].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[58].setRotationPoint(-75.5F, 2.05F, 20F);
        body[58].rotationAngleZ = Static.toDegrees(-3.53429174F);

        body[59].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F); // Box 506
        body[59].setRotationPoint(-75.5F, 2.05F, 20F);
        body[59].rotationAngleZ = Static.toDegrees(-3.14159265F);

        body[60].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[60].setRotationPoint(-75.5F, 2.05F, 20F);

        body[61].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[61].setRotationPoint(-75.5F, 2.05F, 20F);
        body[61].rotationAngleZ = Static.toDegrees(-0.39269908F);

        body[62].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[62].setRotationPoint(-75.5F, 2.05F, 20F);
        body[62].rotationAngleZ = Static.toDegrees(-1.17809725F);

        body[63].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[63].setRotationPoint(-75.5F, 2.05F, 20F);
        body[63].rotationAngleZ = Static.toDegrees(-0.78539816F);

        body[64].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[64].setRotationPoint(-75.5F, 2.05F, 20F);
        body[64].rotationAngleZ = Static.toDegrees(-2.74889357F);

        body[65].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[65].setRotationPoint(-75.5F, 2.05F, 20F);
        body[65].rotationAngleZ = Static.toDegrees(-2.35619449F);

        body[66].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[66].setRotationPoint(-75.5F, 2.05F, 20F);
        body[66].rotationAngleZ = Static.toDegrees(-1.96349541F);

        body[67].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[67].setRotationPoint(-75.5F, 2.05F, 20F);
        body[67].rotationAngleZ = Static.toDegrees(-1.57079633F);

        body[68].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[68].setRotationPoint(-75.5F, 2.05F, 20F);
        body[68].rotationAngleZ = Static.toDegrees(-5.89048623F);

        body[69].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[69].setRotationPoint(-75.5F, 2.05F, 20F);
        body[69].rotationAngleZ = Static.toDegrees(-5.10508806F);

        body[70].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[70].setRotationPoint(-75.5F, 2.05F, 20F);
        body[70].rotationAngleZ = Static.toDegrees(-4.71238898F);

        body[71].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[71].setRotationPoint(-75.5F, 2.05F, 20F);
        body[71].rotationAngleZ = Static.toDegrees(-4.3196899F);

        body[72].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[72].setRotationPoint(-75.5F, 2.05F, 20F);
        body[72].rotationAngleZ = Static.toDegrees(-3.92699082F);

        body[73].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[73].setRotationPoint(-75.5F, 2.05F, 20F);
        body[73].rotationAngleZ = Static.toDegrees(-3.53429174F);

        body[74].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[74].setRotationPoint(-75.5F, 2.05F, 20F);
        body[74].rotationAngleZ = Static.toDegrees(-3.14159265F);

        body[75].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 506
        body[75].setRotationPoint(-75.5F, 2.05F, 20F);
        body[75].rotationAngleZ = Static.toDegrees(-5.49778714F);

        body[76].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 141
        body[76].setRotationPoint(-75.5F, 2.05F, -20F);

        body[77].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 142
        body[77].setRotationPoint(-75.5F, 2.05F, -20F);
        body[77].rotationAngleZ = Static.toDegrees(-0.39269908F);

        body[78].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 143
        body[78].setRotationPoint(-75.5F, 2.05F, -20F);
        body[78].rotationAngleZ = Static.toDegrees(-0.78539816F);

        body[79].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 144
        body[79].setRotationPoint(-75.5F, 2.05F, -20F);
        body[79].rotationAngleZ = Static.toDegrees(-1.17809725F);

        body[80].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 145
        body[80].setRotationPoint(-75.5F, 2.05F, -20F);
        body[80].rotationAngleZ = Static.toDegrees(-1.57079633F);

        body[81].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 146
        body[81].setRotationPoint(-75.5F, 2.05F, -20F);
        body[81].rotationAngleZ = Static.toDegrees(-1.96349541F);

        body[82].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 147
        body[82].setRotationPoint(-75.5F, 2.05F, -20F);
        body[82].rotationAngleZ = Static.toDegrees(-2.35619449F);

        body[83].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 148
        body[83].setRotationPoint(-75.5F, 2.05F, -20F);
        body[83].rotationAngleZ = Static.toDegrees(-2.74889357F);

        body[84].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 149
        body[84].setRotationPoint(-75.5F, 2.05F, -20F);
        body[84].rotationAngleZ = Static.toDegrees(-3.14159265F);

        body[85].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 150
        body[85].setRotationPoint(-75.5F, 2.05F, -20F);
        body[85].rotationAngleZ = Static.toDegrees(-3.53429174F);

        body[86].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 151
        body[86].setRotationPoint(-75.5F, 2.05F, -20F);
        body[86].rotationAngleZ = Static.toDegrees(-3.92699082F);

        body[87].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 152
        body[87].setRotationPoint(-75.5F, 2.05F, -20F);
        body[87].rotationAngleZ = Static.toDegrees(-4.3196899F);

        body[88].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 153
        body[88].setRotationPoint(-75.5F, 2.05F, -20F);
        body[88].rotationAngleZ = Static.toDegrees(-4.71238898F);

        body[89].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 154
        body[89].setRotationPoint(-75.5F, 2.05F, -20F);
        body[89].rotationAngleZ = Static.toDegrees(-5.10508806F);

        body[90].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 155
        body[90].setRotationPoint(-75.5F, 2.05F, -20F);
        body[90].rotationAngleZ = Static.toDegrees(-5.89048623F);

        body[91].addShapeBox(-1F, -6F, -1.5F, 2, 3, 2, 0F, 0.05F, -0.7F, 0F, 0.05F, -0.7F, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F, -0.35F, -0.2F, 0F); // Box 156
        body[91].setRotationPoint(-75.5F, 2.05F, -20F);
        body[91].rotationAngleZ = Static.toDegrees(-5.49778714F);

        body[92].addShapeBox(-1.5F, -1.5F, -1.5F, 2, 3, 2, 0F, -0.5F, 0.25F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, -0.5F, 0.25F, 0F, -0.5F, 0.25F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, -0.5F, 0.25F, 0F); // Box 157
        body[92].setRotationPoint(-74.5F, 2.05F, -19F);

        body[93].addShapeBox(-0.5F, -1.5F, -1.5F, 2, 3, 2, 0F, 0F, -0.75F, 0F, -0.5F, 0.25F, 0F, -0.5F, 0.25F, 0F, 0F, -0.75F, 0F, 0F, -0.75F, 0F, -0.5F, 0.25F, 0F, -0.5F, 0.25F, 0F, 0F, -0.75F, 0F); // Box 158
        body[93].setRotationPoint(-76.5F, 2.05F, -19F);

        body[94].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 159
        body[94].setRotationPoint(-75.5F, 2.05F, -20F);

        body[95].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 160
        body[95].setRotationPoint(-75.5F, 2.05F, -20F);
        body[95].rotationAngleZ = Static.toDegrees(-5.89048623F);

        body[96].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 161
        body[96].setRotationPoint(-75.5F, 2.05F, -20F);
        body[96].rotationAngleZ = Static.toDegrees(-5.49778714F);

        body[97].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 162
        body[97].setRotationPoint(-75.5F, 2.05F, -20F);
        body[97].rotationAngleZ = Static.toDegrees(-5.10508806F);

        body[98].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 163
        body[98].setRotationPoint(-75.5F, 2.05F, -20F);
        body[98].rotationAngleZ = Static.toDegrees(-4.71238898F);

        body[99].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 164
        body[99].setRotationPoint(-75.5F, 2.05F, -20F);
        body[99].rotationAngleZ = Static.toDegrees(-4.3196899F);

        body[100].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 165
        body[100].setRotationPoint(-75.5F, 2.05F, -20F);
        body[100].rotationAngleZ = Static.toDegrees(-3.53429174F);

        body[101].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 166
        body[101].setRotationPoint(-75.5F, 2.05F, -20F);
        body[101].rotationAngleZ = Static.toDegrees(-3.92699082F);

        body[102].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 167
        body[102].setRotationPoint(-75.5F, 2.05F, -20F);
        body[102].rotationAngleZ = Static.toDegrees(-3.14159265F);

        body[103].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 168
        body[103].setRotationPoint(-75.5F, 2.05F, -20F);
        body[103].rotationAngleZ = Static.toDegrees(-2.74889357F);

        body[104].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 169
        body[104].setRotationPoint(-75.5F, 2.05F, -20F);
        body[104].rotationAngleZ = Static.toDegrees(-2.35619449F);

        body[105].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 170
        body[105].setRotationPoint(-75.5F, 2.05F, -20F);
        body[105].rotationAngleZ = Static.toDegrees(-1.96349541F);

        body[106].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 171
        body[106].setRotationPoint(-75.5F, 2.05F, -20F);
        body[106].rotationAngleZ = Static.toDegrees(-1.57079633F);

        body[107].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 172
        body[107].setRotationPoint(-75.5F, 2.05F, -20F);
        body[107].rotationAngleZ = Static.toDegrees(-1.17809725F);

        body[108].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 173
        body[108].setRotationPoint(-75.5F, 2.05F, -20F);
        body[108].rotationAngleZ = Static.toDegrees(-0.78539816F);

        body[109].addShapeBox(-1F, -3F, -1.5F, 2, 1, 2, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.35F, 0.2F, 0F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, -0.6F, -0.525F, -0.4F, 0F, -0.525F, -0.4F, 0F); // Box 174
        body[109].setRotationPoint(-75.5F, 2.05F, -20F);
        body[109].rotationAngleZ = Static.toDegrees(-0.39269908F);

        body[110].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 175
        body[110].setRotationPoint(-75.5F, 2.05F, -16F);

        body[111].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 176
        body[111].setRotationPoint(-75.5F, 2.05F, -16F);
        body[111].rotationAngleZ = Static.toDegrees(-0.39269908F);

        body[112].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 177
        body[112].setRotationPoint(-75.5F, 2.05F, -16F);
        body[112].rotationAngleZ = Static.toDegrees(-0.78539816F);

        body[113].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 178
        body[113].setRotationPoint(-75.5F, 2.05F, -16F);
        body[113].rotationAngleZ = Static.toDegrees(-1.17809725F);

        body[114].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 179
        body[114].setRotationPoint(-75.5F, 2.05F, -16F);
        body[114].rotationAngleZ = Static.toDegrees(-1.57079633F);

        body[115].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 180
        body[115].setRotationPoint(-75.5F, 2.05F, -16F);
        body[115].rotationAngleZ = Static.toDegrees(-1.96349541F);

        body[116].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 181
        body[116].setRotationPoint(-75.5F, 2.05F, -16F);
        body[116].rotationAngleZ = Static.toDegrees(-2.35619449F);

        body[117].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 182
        body[117].setRotationPoint(-75.5F, 2.05F, -16F);
        body[117].rotationAngleZ = Static.toDegrees(-2.74889357F);

        body[118].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 183
        body[118].setRotationPoint(-75.5F, 2.05F, -16F);
        body[118].rotationAngleZ = Static.toDegrees(-3.14159265F);

        body[119].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 184
        body[119].setRotationPoint(-75.5F, 2.05F, -16F);
        body[119].rotationAngleZ = Static.toDegrees(-3.53429174F);

        body[120].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 185
        body[120].setRotationPoint(-75.5F, 2.05F, -16F);
        body[120].rotationAngleZ = Static.toDegrees(-3.92699082F);

        body[121].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 186
        body[121].setRotationPoint(-75.5F, 2.05F, -16F);
        body[121].rotationAngleZ = Static.toDegrees(-4.3196899F);

        body[122].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 187
        body[122].setRotationPoint(-75.5F, 2.05F, -16F);
        body[122].rotationAngleZ = Static.toDegrees(-4.71238898F);

        body[123].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 188
        body[123].setRotationPoint(-75.5F, 2.05F, -16F);
        body[123].rotationAngleZ = Static.toDegrees(-5.10508806F);

        body[124].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 189
        body[124].setRotationPoint(-75.5F, 2.05F, -16F);
        body[124].rotationAngleZ = Static.toDegrees(-5.49778714F);

        body[125].addShapeBox(-1F, -6F, -3.5F, 2, 6, 2, 0F, 0.2F, 0F, 0F, 0.2F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F, -0.5F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F); // Box 190
        body[125].setRotationPoint(-75.5F, 2.05F, -16F);
        body[125].rotationAngleZ = Static.toDegrees(-5.89048623F);

        body[126].addBox(0F, 0F, 0F, 10, 1, 1, 0F); // Box 191
        body[126].setRotationPoint(-81F, -4.7F, -16.5F);

        body[127].addBox(0F, 0F, 0F, 10, 1, 1, 0F); // Box 192
        body[127].setRotationPoint(-81F, -4.7F, 14.5F);

        body[128].addBox(0F, 0F, 0F, 1, 1, 2, 0F); // Box 143
        body[128].setRotationPoint(-105.5F, -1.2F, -14.5F);

        body[129].addBox(0F, 0F, 0F, 1, 1, 2, 0F); // Box 144
        body[129].setRotationPoint(-105.5F, -1.2F, 11.5F);

        body[130].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 145
        body[130].setRotationPoint(-105.5F, -1.2F, 10.5F);

        body[131].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 146
        body[131].setRotationPoint(-105.5F, -1.2F, -12.5F);

        body[132].addBox(0F, 0F, 0F, 65, 13, 1, 0F); // Box 154
        body[132].setRotationPoint(-105F, -14.7F, -15.5F);

        body[133].addShapeBox(0F, 0F, 0F, 1, 3, 5, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 299
        body[133].setRotationPoint(-74F, -0.5F, -3F);

        body[134].addShapeBox(0F, 0F, 0F, 3, 1, 7, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 300
        body[134].setRotationPoint(-77F, 2.5F, -4F);

        body[135].addShapeBox(0F, 0F, 0F, 3, 3, 7, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 8
        body[135].setRotationPoint(-77F, -0.5F, -4F);

        body[136].addShapeBox(0F, 0F, 0F, 2, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 9
        body[136].setRotationPoint(-76.5F, 0F, 3F);

        body[137].addShapeBox(0F, 0F, 0F, 1, 2, 14, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 173
        body[137].setRotationPoint(-75.5F, 0F, 5F);

        body[138].addShapeBox(0F, 0F, 0F, 1, 2, 14, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 175
        body[138].setRotationPoint(-76.5F, 0F, 5F);

        body[139].addShapeBox(0F, 0F, 0F, 1, 2, 14, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 176
        body[139].setRotationPoint(-76.5F, 0F, -20F);

        body[140].addShapeBox(0F, 0F, 0F, 1, 2, 14, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 178
        body[140].setRotationPoint(-75.5F, 0F, -20F);

        body[141].addShapeBox(0F, 0F, 0F, 2, 2, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 16
        body[141].setRotationPoint(-76.5F, 0F, -6F);

        body[142].addShapeBox(0F, 0F, 0F, 3, 1, 7, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 18
        body[142].setRotationPoint(-77F, -1.5F, -4F);

        body[143].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F); // Box 37
        body[143].setRotationPoint(-81.5F, -2F, 13.5F);

        body[144].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F); // Box 38
        body[144].setRotationPoint(-70.5F, -2F, 13.5F);

        body[145].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F); // Box 39
        body[145].setRotationPoint(-81.5F, -2F, -15.5F);

        body[146].addShapeBox(0F, 0F, 0F, 1, 3, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F); // Box 40
        body[146].setRotationPoint(-70.5F, -2F, -15.5F);

        body[147].addBox(0F, 0F, 0F, 70, 1, 28, 0F); // Box 179
        body[147].setRotationPoint(-105F, -2.5F, -14.5F);

        body[148].addBox(0F, 0F, 0F, 1, 1, 28, 0F); // Box 188
        body[148].setRotationPoint(-35F, -2.5F, -14.5F);

        body[149].addBox(0F, 0F, 0F, 65, 13, 1, 0F); // Box 173
        body[149].setRotationPoint(-105F, -14.7F, 13.5F);

        body[150].addBox(0F, 0F, 0F, 65, 13, 1, 0F); // Box 174
        body[150].setRotationPoint(-105F, -27.7F, 13.5F);

        body[151].addBox(0F, 0F, 0F, 65, 13, 1, 0F); // Box 175
        body[151].setRotationPoint(-105F, -27.7F, -15.5F);

        body[152].addShapeBox(0F, 0F, 0F, 6, 13, 14, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 176
        body[152].setRotationPoint(-34F, -14.7F, -7.5F);

        body[153].addShapeBox(0F, 0F, 0F, 6, 13, 8, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 4F, 0F, 0F, -6F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 6F, 0F, 0F, -6F, 0F, 0F); // Box 177
        body[153].setRotationPoint(-40F, -14.7F, -15.5F);

        body[154].addShapeBox(0F, 0F, 0F, 6, 13, 8, 0F, -6F, 0F, 0F, 4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -6F, 0F, 0F, 6F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 178
        body[154].setRotationPoint(-40F, -14.7F, 6.5F);

        body[155].addShapeBox(0F, 0F, 0F, 4, 13, 14, 0F, 3F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 179
        body[155].setRotationPoint(-34F, -27.7F, -7.5F);

        body[156].addShapeBox(0F, 0F, 0F, 6, 13, 8, 0F, -3F, 0F, 0F, -1F, 0F, 0F, -4F, 0F, -1F, 0F, 0F, 0F, -6F, 0F, 0F, 4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 181
        body[156].setRotationPoint(-40F, -27.7F, 6.5F);

        body[157].addShapeBox(0F, 0F, 0F, 6, 13, 8, 0F, 0F, 0F, 0F, -4F, 0F, -1F, -1F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 4F, 0F, 0F, -6F, 0F, 0F); // Box 182
        body[157].setRotationPoint(-40F, -27.7F, -15.5F);

        body[158].addBox(0F, 0F, 0F, 65, 1, 30, 0F); // Box 183
        body[158].setRotationPoint(-105F, -28.7F, -15.5F);

        body[159].addShapeBox(0F, 0F, 0F, 5, 1, 14, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 184
        body[159].setRotationPoint(-40F, -28.7F, -7.5F);

        body[160].addShapeBox(0F, 0F, 0F, 5, 1, 8, 0F, 0F, 0F, 0F, -4F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 185
        body[160].setRotationPoint(-40F, -28.7F, -15.5F);

        body[161].addShapeBox(0F, 0F, 0F, 5, 1, 8, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -4F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, -1F, 0F, 0F, 0F); // Box 186
        body[161].setRotationPoint(-40F, -28.7F, 6.5F);

        body[162].addShapeBox(0F, 0F, 0F, 1, 25, 28, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 187
        body[162].setRotationPoint(-105F, -27.5F, -14.5F);

        body[163].addShapeBox(0F, 0F, 0F, 25, 1, 28, 0F, -2F, 0F, 0F, 0F, 9F, 0F, 0F, 9F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, -9F, 0F, 0F, -9F, 0F, 0F, 0F, 0F); // Box 188
        body[163].setRotationPoint(-130F, 6.5F, -14.5F);

        body[164].addBox(0F, 0F, 0F, 1, 1, 28, 0F); // Box 164
        body[164].setRotationPoint(-105.5F, -26.5F, -14.5F);

        body[165].addBox(0F, 0F, 0F, 1, 1, 28, 0F); // Box 165
        body[165].setRotationPoint(-105.5F, -23.5F, -14.5F);

        body[166].addBox(0F, 0F, 0F, 1, 1, 28, 0F); // Box 166
        body[166].setRotationPoint(-105.5F, -20.5F, -14.5F);

        body[167].addBox(0F, 0F, 0F, 1, 1, 28, 0F); // Box 167
        body[167].setRotationPoint(-105.5F, -17.5F, -14.5F);

        body[168].addBox(0F, 0F, 0F, 1, 1, 28, 0F); // Box 168
        body[168].setRotationPoint(-105.5F, -14.5F, -14.5F);

        body[169].addBox(0F, 0F, 0F, 1, 1, 28, 0F); // Box 169
        body[169].setRotationPoint(-105.5F, -11.5F, -14.5F);

        body[170].addBox(0F, 0F, 0F, 1, 1, 28, 0F); // Box 170
        body[170].setRotationPoint(-105.5F, -8.5F, -14.5F);

        body[171].addBox(0F, 0F, 0F, 1, 1, 28, 0F); // Box 171
        body[171].setRotationPoint(-105.5F, -5.5F, -14.5F);

        body[172].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 172
        body[172].setRotationPoint(-105.3F, -28.5F, 10.5F);

        body[173].addBox(0F, 0F, 0F, 1, 1, 2, 0F); // Box 173
        body[173].setRotationPoint(-105.3F, -28.5F, 11.5F);

        body[174].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 174
        body[174].setRotationPoint(-105.3F, -28.5F, -12.5F);

        body[175].addBox(0F, 0F, 0F, 1, 1, 2, 0F); // Box 175
        body[175].setRotationPoint(-105.3F, -28.5F, -14.5F);
        this.add("body", body);
        fixRotations();
    }

}