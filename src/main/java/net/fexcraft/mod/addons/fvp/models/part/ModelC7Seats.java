package net.fexcraft.mod.addons.fvp.models.part;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.part.PartModelTMT;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.entity.Entity;

public class ModelC7Seats extends PartModelTMT {

    public ModelC7Seats(){
    	super(); textureX = 512; textureY = 512;
        this.addToCreators("Ferdinand (FEX___96)");
        body = new ModelRendererTurbo[30];
        body[0] = new ModelRendererTurbo(this, 297, 105, textureX, textureY); // Box 210
        body[1] = new ModelRendererTurbo(this, 265, 121, textureX, textureY); // Box 211
        body[2] = new ModelRendererTurbo(this, 425, 121, textureX, textureY); // Box 212
        body[3] = new ModelRendererTurbo(this, 465, 121, textureX, textureY); // Box 213
        body[4] = new ModelRendererTurbo(this, 1, 129, textureX, textureY); // Box 214
        body[5] = new ModelRendererTurbo(this, 409, 121, textureX, textureY); // Box 215
        body[6] = new ModelRendererTurbo(this, 1, 129, textureX, textureY); // Box 216
        body[7] = new ModelRendererTurbo(this, 57, 129, textureX, textureY); // Box 217
        body[8] = new ModelRendererTurbo(this, 89, 129, textureX, textureY); // Box 218
        body[9] = new ModelRendererTurbo(this, 81, 129, textureX, textureY); // Box 219
        body[10] = new ModelRendererTurbo(this, 129, 129, textureX, textureY); // Box 220
        body[11] = new ModelRendererTurbo(this, 273, 129, textureX, textureY); // Box 221
        body[12] = new ModelRendererTurbo(this, 97, 129, textureX, textureY); // Box 222
        body[13] = new ModelRendererTurbo(this, 337, 129, textureX, textureY); // Box 223
        body[14] = new ModelRendererTurbo(this, 361, 129, textureX, textureY); // Box 224
        body[15] = new ModelRendererTurbo(this, 385, 129, textureX, textureY); // Box 225
        body[16] = new ModelRendererTurbo(this, 425, 129, textureX, textureY); // Box 226
        body[17] = new ModelRendererTurbo(this, 145, 137, textureX, textureY); // Box 227
        body[18] = new ModelRendererTurbo(this, 473, 129, textureX, textureY); // Box 228
        body[19] = new ModelRendererTurbo(this, 193, 137, textureX, textureY); // Box 229
        body[20] = new ModelRendererTurbo(this, 225, 137, textureX, textureY); // Box 230
        body[21] = new ModelRendererTurbo(this, 257, 137, textureX, textureY); // Box 231
        body[22] = new ModelRendererTurbo(this, 233, 41, textureX, textureY); // Box 232
        body[23] = new ModelRendererTurbo(this, 257, 41, textureX, textureY); // Box 233
        body[24] = new ModelRendererTurbo(this, 273, 41, textureX, textureY); // Box 234
        body[25] = new ModelRendererTurbo(this, 281, 41, textureX, textureY); // Box 235
        body[26] = new ModelRendererTurbo(this, 297, 137, textureX, textureY); // Box 236
        body[27] = new ModelRendererTurbo(this, 321, 137, textureX, textureY); // Box 237
        body[28] = new ModelRendererTurbo(this, 409, 137, textureX, textureY); // Box 243
        body[29] = new ModelRendererTurbo(this, 1, 145, textureX, textureY); // Box 244

        body[0].addBox(0F, 0F, 0F, 8, 1, 1, 0F); // Box 210
        body[0].setRotationPoint(-20F, -4F, 12F);

        body[1].addBox(0F, 0F, 0F, 8, 1, 1, 0F); // Box 211
        body[1].setRotationPoint(-20F, -4F, -13F);

        body[2].addBox(0F, 0F, 0F, 8, 1, 1, 0F); // Box 212
        body[2].setRotationPoint(-20F, -4F, -6F);

        body[3].addBox(0F, 0F, 0F, 8, 1, 1, 0F); // Box 213
        body[3].setRotationPoint(-20F, -4F, 5F);

        body[4].addBox(0F, 0F, 0F, 10, 2, 30, 0F); // Box 214
        body[4].setRotationPoint(-21F, -6F, -15F);

        body[5].addShapeBox(0F, 0F, 0F, 1, 2, 10, 0F, 0F, 0F, 0F, 0F, -0.2F, -1F, 0F, -0.2F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -1F, 0F, -0.2F, -1F, 0F, 0F, 0F); // Box 215
        body[5].setRotationPoint(-11F, -6F, -15F);

        body[6].addShapeBox(0F, 0F, 0F, 1, 2, 10, 0F, 0F, 0F, 0F, 0F, -0.2F, -1F, 0F, -0.2F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -1F, 0F, -0.2F, -1F, 0F, 0F, 0F); // Box 216
        body[6].setRotationPoint(-11F, -6F, -5F);

        body[7].addShapeBox(0F, 0F, 0F, 1, 2, 10, 0F, 0F, 0F, 0F, 0F, -0.2F, -1F, 0F, -0.2F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -1F, 0F, -0.2F, -1F, 0F, 0F, 0F); // Box 217
        body[7].setRotationPoint(-11F, -6F, 5F);

        body[8].addBox(0F, 0F, 0F, 2, 12, 30, 0F); // Box 218
        body[8].setRotationPoint(-22F, -17.5F, -15F);
        body[8].rotateAngleZ = 0.06981317F;

        body[9].addShapeBox(0F, -1F, 0F, 2, 1, 10, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 219
        body[9].setRotationPoint(-22F, -17.5F, -15F);
        body[9].rotateAngleZ = 0.06981317F;

        body[10].addShapeBox(0F, -1F, 10F, 2, 1, 10, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 220
        body[10].setRotationPoint(-22F, -17.5F, -15F);
        body[10].rotateAngleZ = 0.06981317F;

        body[11].addShapeBox(0F, -1F, 0F, 2, 1, 10, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 221
        body[11].setRotationPoint(-22F, -17.5F, 5F);
        body[11].rotateAngleZ = 0.06981317F;

        body[12].addBox(0F, 0F, 0F, 8, 1, 1, 0F); // Box 222
        body[12].setRotationPoint(1F, -4F, 13F);

        body[13].addBox(0F, 0F, 0F, 8, 1, 1, 0F); // Box 223
        body[13].setRotationPoint(1F, -4F, 6F);

        body[14].addBox(0F, 0F, 0F, 8, 1, 1, 0F); // Box 224
        body[14].setRotationPoint(1F, -4F, -14F);

        body[15].addBox(0F, 0F, 0F, 8, 1, 1, 0F); // Box 225
        body[15].setRotationPoint(1F, -4F, -7F);

        body[16].addBox(0F, 0F, 0F, 10, 2, 10, 0F); // Box 226
        body[16].setRotationPoint(0F, -6F, 5F);

        body[17].addBox(0F, 0F, 0F, 10, 2, 10, 0F); // Box 227
        body[17].setRotationPoint(0F, -6F, -15F);

        body[18].addBox(0F, 0F, 0F, 2, 12, 10, 0F); // Box 228
        body[18].setRotationPoint(-1F, -17.5F, 5F);
        body[18].rotateAngleZ = 0.06981317F;

        body[19].addBox(0F, 0F, 0F, 2, 12, 10, 0F); // Box 229
        body[19].setRotationPoint(-1F, -17.5F, -15F);
        body[19].rotateAngleZ = 0.06981317F;

        body[20].addShapeBox(0F, -1F, 0F, 2, 1, 10, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 230
        body[20].setRotationPoint(-1F, -17.5F, -15F);
        body[20].rotateAngleZ = 0.06981317F;

        body[21].addShapeBox(0F, -1F, 0F, 2, 1, 10, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 231
        body[21].setRotationPoint(-1F, -17.5F, 5F);
        body[21].rotateAngleZ = 0.06981317F;

        body[22].addBox(0.5F, -2F, 2.5F, 1, 1, 1, 0F); // Box 232
        body[22].setRotationPoint(-1F, -17.5F, 5F);
        body[22].rotateAngleZ = 0.06981317F;

        body[23].addBox(0.5F, -2F, 6.5F, 1, 1, 1, 0F); // Box 233
        body[23].setRotationPoint(-1F, -17.5F, 5F);
        body[23].rotateAngleZ = 0.06981317F;

        body[24].addBox(0.5F, -2F, 6.5F, 1, 1, 1, 0F); // Box 234
        body[24].setRotationPoint(-1F, -17.5F, -15F);
        body[24].rotateAngleZ = 0.06981317F;

        body[25].addBox(0.5F, -2F, 2.5F, 1, 1, 1, 0F); // Box 235
        body[25].setRotationPoint(-1F, -17.5F, -15F);
        body[25].rotateAngleZ = 0.06981317F;

        body[26].addBox(0F, -5F, 1.5F, 2, 3, 7, 0F); // Box 236
        body[26].setRotationPoint(-1F, -17.5F, 5F);
        body[26].rotateAngleZ = 0.06981317F;

        body[27].addBox(0F, -5F, 1.5F, 2, 3, 7, 0F); // Box 237
        body[27].setRotationPoint(-1F, -17.5F, -15F);
        body[27].rotateAngleZ = 0.06981317F;

        body[28].addShapeBox(0F, 0F, 0F, 1, 2, 10, 0F, 0F, 0F, 0F, 0F, -0.2F, -1F, 0F, -0.2F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -1F, 0F, -0.2F, -1F, 0F, 0F, 0F); // Box 243
        body[28].setRotationPoint(10F, -6F, 5F);

        body[29].addShapeBox(0F, 0F, 0F, 1, 2, 10, 0F, 0F, 0F, 0F, 0F, -0.2F, -1F, 0F, -0.2F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -1F, 0F, -0.2F, -1F, 0F, 0F, 0F); // Box 244
        body[29].setRotationPoint(10F, -6F, -15F);

        super.fixRotations(body);
        //TODO sub models without paint be.

    }

    @Override
    public void render(VehicleData data, String us){
        data.getSecondaryColor().glColorApply();
        render(body);
        RGB.glColorReset();
    }

    @Override
    public void render(VehicleData data, String us, Entity vehicle, int meta){
        data.getSecondaryColor().glColorApply();
        render(body);
        RGB.glColorReset();
    }

}
