package net.fexcraft.mod.addons.fvp.models.part;

import net.fexcraft.mod.fvtm.model.part.PartModelTMT;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelC5S extends PartModelTMT {

    public ModelC5S(){
    	super(); textureX = 512; textureY = 512;
        this.addToCreators("Ferdinand (FEX___96)");
        body = new ModelRendererTurbo[28];
        body[0] = new ModelRendererTurbo(this, 233, 65, textureX, textureY); // Box 218
        body[1] = new ModelRendererTurbo(this, 449, 121, textureX, textureY); // Box 219
        body[2] = new ModelRendererTurbo(this, 257, 65, textureX, textureY); // Box 220
        body[3] = new ModelRendererTurbo(this, 281, 65, textureX, textureY); // Box 221
        body[4] = new ModelRendererTurbo(this, 441, 65, textureX, textureY); // Box 222
        body[5] = new ModelRendererTurbo(this, 441, 145, textureX, textureY); // Box 223
        body[6] = new ModelRendererTurbo(this, 305, 193, textureX, textureY); // Box 224
        body[7] = new ModelRendererTurbo(this, 465, 65, textureX, textureY); // Box 225
        body[8] = new ModelRendererTurbo(this, 345, 81, textureX, textureY); // Box 226
        body[9] = new ModelRendererTurbo(this, 361, 81, textureX, textureY); // Box 227
        body[10] = new ModelRendererTurbo(this, 417, 81, textureX, textureY); // Box 228
        body[11] = new ModelRendererTurbo(this, 1, 97, textureX, textureY); // Box 229
        body[12] = new ModelRendererTurbo(this, 185, 89, textureX, textureY); // Box 231
        body[13] = new ModelRendererTurbo(this, 345, 89, textureX, textureY); // Box 232
        body[14] = new ModelRendererTurbo(this, 433, 321, textureX, textureY); // Box 233
        body[15] = new ModelRendererTurbo(this, 473, 89, textureX, textureY); // Box 234
        body[16] = new ModelRendererTurbo(this, 57, 97, textureX, textureY); // Box 235
        body[17] = new ModelRendererTurbo(this, 49, 345, textureX, textureY); // Box 236
        body[18] = new ModelRendererTurbo(this, 201, 137, textureX, textureY); // Box 237
        body[19] = new ModelRendererTurbo(this, 337, 137, textureX, textureY); // Box 238
        body[20] = new ModelRendererTurbo(this, 185, 97, textureX, textureY); // Box 239
        body[21] = new ModelRendererTurbo(this, 305, 97, textureX, textureY); // Box 240
        body[22] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 241
        body[23] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 242
        body[24] = new ModelRendererTurbo(this, 489, 89, textureX, textureY); // Box 243
        body[25] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 244
        body[26] = new ModelRendererTurbo(this, 81, 1, textureX, textureY); // Box 245
        body[27] = new ModelRendererTurbo(this, 473, 97, textureX, textureY); // Box 246

        body[0].addBox(0F, 0F, 0F, 10, 1, 1, 0F); // Box 218
        body[0].setRotationPoint(-12F, 4F, 10F);

        body[1].addBox(0F, 0F, 0F, 14, 2, 14, 0F); // Box 219
        body[1].setRotationPoint(-14F, 2F, 7F);

        body[2].addBox(0F, 0F, 0F, 10, 1, 1, 0F); // Box 220
        body[2].setRotationPoint(-12F, 4F, 17F);

        body[3].addBox(0F, 0F, 0F, 10, 1, 1, 0F); // Box 221
        body[3].setRotationPoint(-12F, 4F, -18F);

        body[4].addBox(0F, 0F, 0F, 10, 1, 1, 0F); // Box 222
        body[4].setRotationPoint(-12F, 4F, -11F);

        body[5].addBox(0F, 0F, 0F, 14, 2, 14, 0F); // Box 223
        body[5].setRotationPoint(-14F, 2F, -21F);

        body[6].addBox(0F, 0F, 0F, 14, 2, 14, 0F); // Box 224
        body[6].setRotationPoint(-14F, 2F, -7F);

        body[7].addBox(0F, 0F, 0F, 10, 1, 1, 0F); // Box 225
        body[7].setRotationPoint(-12F, 4F, -4F);

        body[8].addBox(0F, 0F, 0F, 10, 1, 1, 0F); // Box 226
        body[8].setRotationPoint(-12F, 4F, 3F);

        body[9].addShapeBox(0F, 0F, 0F, 2, 14, 14, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F); // Box 227
        body[9].setRotationPoint(-17F, -12F, 7F);
        body[9].rotateAngleZ = 0.01745329F;

        body[10].addShapeBox(0F, 0F, 0F, 2, 14, 14, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F); // Box 228
        body[10].setRotationPoint(-17F, -12F, -7F);
        body[10].rotateAngleZ = 0.01745329F;

        body[11].addShapeBox(0F, 0F, 0F, 2, 14, 14, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F); // Box 229
        body[11].setRotationPoint(-17F, -12F, -21F);
        body[11].rotateAngleZ = 0.01745329F;

        body[12].addBox(0F, 0F, 0F, 10, 1, 1, 0F); // Box 231
        body[12].setRotationPoint(11F, 4F, 16F);

        body[13].addBox(0F, 0F, 0F, 10, 1, 1, 0F); // Box 232
        body[13].setRotationPoint(11F, 4F, 7F);

        body[14].addBox(0F, 0F, 0F, 14, 2, 16, 0F); // Box 233
        body[14].setRotationPoint(9F, 2F, 4F);

        body[15].addBox(0F, 0F, 0F, 10, 1, 1, 0F); // Box 234
        body[15].setRotationPoint(11F, 4F, -17F);

        body[16].addBox(0F, 0F, 0F, 10, 1, 1, 0F); // Box 235
        body[16].setRotationPoint(11F, 4F, -8F);

        body[17].addBox(0F, 0F, 0F, 14, 2, 16, 0F); // Box 236
        body[17].setRotationPoint(9F, 2F, -20F);

        body[18].addShapeBox(0F, 0F, 0F, 2, 16, 16, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 237
        body[18].setRotationPoint(8F, -14F, 4F);

        body[19].addShapeBox(0F, 0F, 0F, 2, 16, 16, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 238
        body[19].setRotationPoint(8F, -14F, -20F);

        body[20].addShapeBox(0F, 0F, 0F, 1, 2, 12, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 239
        body[20].setRotationPoint(8F, 2F, 6F);

        body[21].addShapeBox(0F, 0F, 0F, 1, 2, 12, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 240
        body[21].setRotationPoint(8F, 2F, -18F);

        body[22].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 241
        body[22].setRotationPoint(7.5F, -15F, 9F);

        body[23].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 242
        body[23].setRotationPoint(7.5F, -15F, 14F);

        body[24].addBox(0F, 0F, 0F, 2, 3, 8, 0F); // Box 243
        body[24].setRotationPoint(7F, -18F, 8F);

        body[25].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 244
        body[25].setRotationPoint(7.5F, -15F, -15F);

        body[26].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 245
        body[26].setRotationPoint(7.5F, -15F, -10F);

        body[27].addBox(0F, 0F, 0F, 2, 3, 8, 0F); // Box 246
        body[27].setRotationPoint(7F, -18F, -16F);
        this.flipAll();
        //TODO sub models without paint be.
    }

    /*@Override
	public void render(VehicleData data, String us){
		data.getSecondaryColor().glColorApply();
		render(body);
		data.getSecondaryColor().glColorReset();
	}
	
	@Override
	public void render(VehicleData data, String us, Entity vehicle){
		data.getSecondaryColor().glColorApply();
		render(body);
		data.getSecondaryColor().glColorReset();
	}*/
}
