package net.fexcraft.mod.addons.zmp.models.part;

import net.fexcraft.mod.fvtm.model.part.PartModel;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelCargoShipInterior extends PartModel {
	
    public ModelCargoShipInterior(){
    	super(); textureX = 4096; textureY = 4096;
        this.addToCreators("643a5fd6-f325-442f-9ea8-6445dbb0cdc9");
        body = new ModelRendererTurbo[41];
        body[0] = new ModelRendererTurbo(this, 3273, 1, textureX, textureY); // Box 169
        body[1] = new ModelRendererTurbo(this, 3457, 1, textureX, textureY); // Box 170
        body[2] = new ModelRendererTurbo(this, 3305, 1, textureX, textureY); // Box 171
        body[3] = new ModelRendererTurbo(this, 3521, 1, textureX, textureY); // Box 172
        body[4] = new ModelRendererTurbo(this, 3553, 1, textureX, textureY); // Box 173
        body[5] = new ModelRendererTurbo(this, 4017, 1, textureX, textureY); // Box 174
        body[6] = new ModelRendererTurbo(this, 3617, 1, textureX, textureY); // Box 175
        body[7] = new ModelRendererTurbo(this, 1489, 9, textureX, textureY); // Box 176
        body[8] = new ModelRendererTurbo(this, 4057, 1, textureX, textureY); // Box 177
        body[9] = new ModelRendererTurbo(this, 2158, 2760, textureX, textureY); // Box 237
        body[10] = new ModelRendererTurbo(this, 242, 464, textureX, textureY); // Box 238
        body[11] = new ModelRendererTurbo(this, 521, 487, textureX, textureY); // Box 239
        body[12] = new ModelRendererTurbo(this, 225, 307, textureX, textureY); // Box 240
        body[13] = new ModelRendererTurbo(this, 234, 359, textureX, textureY); // Box 241
        body[14] = new ModelRendererTurbo(this, 1126, 2688, textureX, textureY); // Box 242
        body[15] = new ModelRendererTurbo(this, 74, 38, textureX, textureY); // Box 243
        body[16] = new ModelRendererTurbo(this, 0, 88, textureX, textureY); // Box 244
        body[17] = new ModelRendererTurbo(this, 47, 377, textureX, textureY); // Box 245
        body[18] = new ModelRendererTurbo(this, 22, 88, textureX, textureY); // Box 246
        body[19] = new ModelRendererTurbo(this, 5, 362, textureX, textureY); // Box 247
        body[20] = new ModelRendererTurbo(this, 45, 88, textureX, textureY); // Box 248
        body[21] = new ModelRendererTurbo(this, 55, 345, textureX, textureY); // Box 249
        body[22] = new ModelRendererTurbo(this, 73, 86, textureX, textureY); // Box 250
        body[23] = new ModelRendererTurbo(this, -4, 323, textureX, textureY); // Box 251
        body[24] = new ModelRendererTurbo(this, 75, 76, textureX, textureY); // Box 252
        body[25] = new ModelRendererTurbo(this, 26, 340, textureX, textureY); // Box 253
        body[26] = new ModelRendererTurbo(this, 75, 68, textureX, textureY); // Box 254
        body[27] = new ModelRendererTurbo(this, -2, 217, textureX, textureY); // Box 255
        body[28] = new ModelRendererTurbo(this, 75, 47, textureX, textureY); // Box 256
        body[29] = new ModelRendererTurbo(this, 36, 307, textureX, textureY); // Box 257
        body[30] = new ModelRendererTurbo(this, 38, 214, textureX, textureY); // Box 258
        body[31] = new ModelRendererTurbo(this, 76, 58, textureX, textureY); // Box 259
        body[32] = new ModelRendererTurbo(this, 67, 182, textureX, textureY); // Box 260
        body[33] = new ModelRendererTurbo(this, 205, 347, textureX, textureY); // Box 261
        body[34] = new ModelRendererTurbo(this, 30, 190, textureX, textureY); // Box 262
        body[35] = new ModelRendererTurbo(this, 19, 151, textureX, textureY); // Box 263
        body[36] = new ModelRendererTurbo(this, 2218, 3134, textureX, textureY); // Box 264
        body[37] = new ModelRendererTurbo(this, -5, 177, textureX, textureY); // Box 265
        body[38] = new ModelRendererTurbo(this, 32, 157, textureX, textureY); // Box 266
        body[39] = new ModelRendererTurbo(this, 1126, 2688, textureX, textureY); // Box 267
        body[40] = new ModelRendererTurbo(this, 2158, 2760, textureX, textureY); // Box 268

        body[0].addBox(0F, 0F, 0F, 7, 13, 6, 0F); // Box 169
        body[0].setRotationPoint(-527F, -206F, -3F);

        body[1].addBox(0F, 0F, 0F, 15, 4, 14, 0F); // Box 170
        body[1].setRotationPoint(-529F, -207F, -7F);

        body[2].addShapeBox(0F, 0F, 0F, 2, 15, 14, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 171
        body[2].setRotationPoint(-529F, -222F, -7F);

        body[3].addBox(0F, 0F, 0F, 7, 13, 6, 0F); // Box 172
        body[3].setRotationPoint(-532F, -206F, 24F);

        body[4].addBox(0F, 0F, 0F, 15, 4, 14, 0F); // Box 173
        body[4].setRotationPoint(-534F, -207F, 20F);

        body[5].addShapeBox(0F, 0F, 0F, 2, 15, 14, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 174
        body[5].setRotationPoint(-534F, -222F, 20F);

        body[6].addBox(0F, 0F, 0F, 7, 13, 6, 0F); // Box 175
        body[6].setRotationPoint(-532F, -206F, -30F);

        body[7].addBox(0F, 0F, 0F, 15, 4, 14, 0F); // Box 176
        body[7].setRotationPoint(-534F, -207F, -34F);

        body[8].addShapeBox(0F, 0F, 0F, 2, 15, 14, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 177
        body[8].setRotationPoint(-534F, -222F, -34F);

        body[9].addBox(0F, 0F, 0F, 15, 1, 117, 0F); // Box 237
        body[9].setRotationPoint(-514F, -216F, -58F);

        body[10].addBox(0F, 0F, 0F, 45, 1, 15, 0F); // Box 238
        body[10].setRotationPoint(-550F, -216F, -73F);

        body[11].addBox(0F, 0F, 0F, 45, 1, 15, 0F); // Box 239
        body[11].setRotationPoint(-550F, -216F, 59F);

        body[12].addBox(0F, 0F, 0F, 45, 18, 13, 0F); // Box 240
        body[12].setRotationPoint(-550F, -215F, 61F);

        body[13].addBox(0F, 0F, 0F, 45, 18, 13, 0F); // Box 241
        body[13].setRotationPoint(-550F, -215F, -73F);

        body[14].addBox(0F, 0F, 0F, 7, 18, 121, 0F); // Box 242
        body[14].setRotationPoint(-512F, -215F, -60F);

        body[15].addShapeBox(0F, 0F, 0F, 9, 4, 1, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 243
        body[15].setRotationPoint(-514F, -220F, -58F);

        body[16].addShapeBox(0F, 0F, 0F, 9, 4, 1, 0F, 0F, -3F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 244
        body[16].setRotationPoint(-514F, -220F, -48F);

        body[17].addShapeBox(0F, 0F, 0F, 9, 4, 9, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 245
        body[17].setRotationPoint(-514F, -220F, -57F);

        body[18].addShapeBox(0F, 0F, 0F, 9, 5, 1, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 246
        body[18].setRotationPoint(-514F, -221F, 5F);

        body[19].addShapeBox(0F, 0F, 0F, 9, 5, 9, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 247
        body[19].setRotationPoint(-514F, -221F, -4F);

        body[20].addShapeBox(0F, 0F, 0F, 9, 5, 1, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 248
        body[20].setRotationPoint(-514F, -221F, -5F);

        body[21].addShapeBox(0F, 0F, 0F, 9, 5, 9, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 249
        body[21].setRotationPoint(-514F, -221F, -14F);

        body[22].addShapeBox(0F, 0F, 0F, 9, 5, 1, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 250
        body[22].setRotationPoint(-514F, -221F, -15F);

        body[23].addShapeBox(0F, 0F, 0F, 9, 5, 9, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 251
        body[23].setRotationPoint(-514F, -221F, 6F);

        body[24].addShapeBox(0F, 0F, 0F, 9, 5, 1, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 252
        body[24].setRotationPoint(-514F, -221F, 15F);

        body[25].addShapeBox(0F, 0F, 0F, 9, 5, 9, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 253
        body[25].setRotationPoint(-514F, -221F, -24F);

        body[26].addShapeBox(0F, 0F, 0F, 9, 5, 1, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 254
        body[26].setRotationPoint(-514F, -221F, -25F);

        body[27].addShapeBox(0F, 0F, 0F, 9, 5, 9, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 255
        body[27].setRotationPoint(-514F, -221F, -34F);

        body[28].addShapeBox(0F, 0F, 0F, 9, 5, 1, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 256
        body[28].setRotationPoint(-514F, -221F, -35F);

        body[29].addShapeBox(0F, 0F, 0F, 9, 5, 9, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 257
        body[29].setRotationPoint(-514F, -221F, 16F);

        body[30].addShapeBox(0F, 0F, 0F, 9, 5, 9, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 258
        body[30].setRotationPoint(-514F, -221F, 26F);

        body[31].addShapeBox(0F, 0F, 0F, 9, 5, 1, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 259
        body[31].setRotationPoint(-514F, -221F, 25F);

        body[32].addShapeBox(0F, 0F, 0F, 9, 5, 1, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 260
        body[32].setRotationPoint(-514F, -221F, 35F);

        body[33].addShapeBox(0F, 0F, 0F, 9, 4, 1, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 261
        body[33].setRotationPoint(-514F, -220F, 58F);

        body[34].addShapeBox(0F, 0F, 0F, 9, 4, 9, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 262
        body[34].setRotationPoint(-514F, -220F, 49F);

        body[35].addShapeBox(0F, 0F, 0F, 9, 4, 1, 0F, 0F, -3F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 263
        body[35].setRotationPoint(-514F, -220F, 48F);

        body[36].addBox(0F, 0F, 0F, 11, 5, 117, 0F); // Box 264
        body[36].setRotationPoint(-505F, -221F, -58F);

        body[37].addShapeBox(0F, 0F, 0F, 9, 4, 12, 0F, 0F, -3F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 265
        body[37].setRotationPoint(-514F, -220F, -47F);

        body[38].addShapeBox(0F, 0F, 0F, 9, 4, 12, 0F, 0F, -3F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 266
        body[38].setRotationPoint(-514F, -220F, 36F);

        body[39].addBox(0F, 0F, 0F, 12, 18, 121, 0F); // Box 267
        body[39].setRotationPoint(-590F, -215F, -60F);

        body[40].addBox(0F, 0F, 0F, 15, 1, 117, 0F); // Box 268
        body[40].setRotationPoint(-590F, -216F, -58F);
        //
        //translateAll(0F, 0F, 0F);
        flipAll();
    }

}
