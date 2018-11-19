package net.fexcraft.mod.addons.fvp.models.part;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.model.part.PartModel;

public class ModelC5IF extends PartModel {

    public ModelC5IF(){
    	super(); textureX = 512; textureY = 512;
        this.addToCreators("Ferdinand (FEX___96)");
        ModelRendererTurbo[] body = new ModelRendererTurbo[26];
        body[0] = new ModelRendererTurbo(this, 1, 321, textureX, textureY); // Box 216
        body[1] = new ModelRendererTurbo(this, 305, 217, textureX, textureY); // Box 230
        body[2] = new ModelRendererTurbo(this, 129, 353, textureX, textureY); // Box 264
        body[3] = new ModelRendererTurbo(this, 385, 137, textureX, textureY); // Box 275
        body[4] = new ModelRendererTurbo(this, 321, 1, textureX, textureY); // Box 276
        body[5] = new ModelRendererTurbo(this, 161, 9, textureX, textureY); // Box 287
        body[6] = new ModelRendererTurbo(this, 161, 17, textureX, textureY); // Box 288
        body[7] = new ModelRendererTurbo(this, 137, 9, textureX, textureY); // Box 289
        body[8] = new ModelRendererTurbo(this, 353, 9, textureX, textureY); // Box 290
        body[9] = new ModelRendererTurbo(this, 409, 145, textureX, textureY); // Box 291
        body[10] = new ModelRendererTurbo(this, 401, 57, textureX, textureY); // Box 292
        body[11] = new ModelRendererTurbo(this, 1, 153, textureX, textureY); // Box 293
        body[12] = new ModelRendererTurbo(this, 385, 153, textureX, textureY); // Box 294
        body[13] = new ModelRendererTurbo(this, 25, 97, textureX, textureY); // Box 295
        body[14] = new ModelRendererTurbo(this, 121, 1, textureX, textureY); // Box 296
        body[15] = new ModelRendererTurbo(this, 137, 1, textureX, textureY); // Box 297
        body[16] = new ModelRendererTurbo(this, 241, 1, textureX, textureY); // Box 298
        body[17] = new ModelRendererTurbo(this, 257, 1, textureX, textureY); // Box 299
        body[18] = new ModelRendererTurbo(this, 193, 25, textureX, textureY); // Box 300
        body[19] = new ModelRendererTurbo(this, 105, 41, textureX, textureY); // Box 301
        body[20] = new ModelRendererTurbo(this, 121, 121, textureX, textureY); // Box 302
        body[21] = new ModelRendererTurbo(this, 305, 65, textureX, textureY); // Box 303
        body[22] = new ModelRendererTurbo(this, 385, 89, textureX, textureY); // Box 424
        body[23] = new ModelRendererTurbo(this, 433, 1, textureX, textureY); // Box 425
        body[24] = new ModelRendererTurbo(this, 489, 145, textureX, textureY); // Box 426
        body[25] = new ModelRendererTurbo(this, 417, 89, textureX, textureY); // Box 427

        body[0].addShapeBox(0F, 0F, 0F, 1, 14, 44, 0F, 16F, 0F, -2F, -16F, 0F, -2F, -16F, 0F, -2F, 16F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 216
        body[0].setRotationPoint(36F, -23F, -22F);

        body[1].addShapeBox(0F, 0F, 0F, 30, 4, 6, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 230
        body[1].setRotationPoint(4F, 1F, -3F);

        body[2].addShapeBox(0F, 0F, 0F, 4, 14, 44, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F); // Box 264
        body[2].setRotationPoint(30F, -9F, -22F);

        body[3].addShapeBox(0F, 0F, 0F, 6, 4, 8, 0F, -1F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F); // Box 275
        body[3].setRotationPoint(28F, -9F, 8F);

        body[4].addBox(0F, 0F, 0F, 3, 2, 2, 0F); // Box 276
        body[4].setRotationPoint(26F, -11F, 11F);
        body[4].rotateAngleZ = -0.15707963F;

        body[5].addBox(0F, 0F, 0F, 1, 4, 1, 0F); // Box 287
        body[5].setRotationPoint(28.8F, -9F, 14F);
        body[5].rotateAngleX = 1.90240888F;
        body[5].rotateAngleY = 0.41887902F;
        body[5].rotateAngleZ = 0.05235988F;

        body[6].addBox(0F, 0F, 0F, 1, 4, 1, 0F); // Box 288
        body[6].setRotationPoint(28.8F, -10F, 10F);
        body[6].rotateAngleX = -1.90240888F;
        body[6].rotateAngleY = -0.41887902F;
        body[6].rotateAngleZ = -0.05235988F;

        body[7].addShapeBox(0F, 0F, 0F, 3, 1, 2, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 289
        body[7].setRotationPoint(29F, 4F, 9F);

        body[8].addShapeBox(0F, 0F, 0F, 3, 1, 2, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 290
        body[8].setRotationPoint(29F, 4F, 13F);

        body[9].addBox(0F, 0F, 0F, 1, 6, 8, 0F); // Box 291
        body[9].setRotationPoint(30F, -7F, -16F);

        body[10].addShapeBox(0F, 0F, 0F, 1, 1, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 292
        body[10].setRotationPoint(29.8F, -6F, -14F);

        body[11].addShapeBox(0F, 0F, 0F, 6, 8, 8, 0F, 0F, -4F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F); // Box 293
        body[11].setRotationPoint(24F, -3F, -4F);

        body[12].addBox(0F, 0F, 0F, 2, 12, 8, 0F); // Box 294
        body[12].setRotationPoint(30F, -7F, -4F);

        body[13].addBox(0F, 0F, 0F, 1, 1, 6, 0F); // Box 295
        body[13].setRotationPoint(29.8F, -6.5F, -3F);

        body[14].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 296
        body[14].setRotationPoint(29.8F, -5F, -2F);

        body[15].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 297
        body[15].setRotationPoint(29.8F, -4.5F, -2.25F);
        body[15].rotateAngleX = 0.78539816F;

        body[16].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 298
        body[16].setRotationPoint(29.8F, -5F, 1F);

        body[17].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 299
        body[17].setRotationPoint(29.8F, -4.5F, 0.75F);
        body[17].rotateAngleX = 0.78539816F;

        body[18].addShapeBox(0F, 0F, 0F, 3, 1, 3, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F); // Box 300
        body[18].setRotationPoint(26F, -2.5F, -1.5F);

        body[19].addBox(0F, 0F, 0F, 1, 4, 1, 0F); // Box 301
        body[19].setRotationPoint(26F, -4.5F, -0.5F);
        body[19].rotateAngleZ = 0.34906585F;

        body[20].addBox(0F, 0F, 0F, 8, 1, 3, 0F); // Box 302
        body[20].setRotationPoint(11F, 0.5F, -1.5F);

        body[21].addBox(0F, 0F, 0F, 6, 1, 1, 0F); // Box 303
        body[21].setRotationPoint(12F, 0.5F, -0.5F);
        body[21].rotateAngleY = -0.01745329F;
        body[21].rotateAngleZ = 0.26179939F;

        body[22].addShapeBox(0F, 0F, 0F, 3, 1, 4, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F); // Box 424
        body[22].setRotationPoint(18F, -23F, -2F);

        body[23].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F); // Box 425
        body[23].setRotationPoint(19.5F, -22.5F, -0.5F);

        body[24].addShapeBox(0F, 0F, 0F, 1, 2, 4, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 426
        body[24].setRotationPoint(18.7F, -21.5F, -1.5F);
        body[24].rotateAngleY = -0.45378561F;
        body[24].rotateAngleZ = 0.06981317F;

        body[25].addShapeBox(0F, 0F, 0F, 2, 1, 4, 0F, 1F, 0F, 1F, 1F, 0F, 1F, 1F, 0F, 1F, 1F, 0F, 1F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 427
        body[25].setRotationPoint(4F, -23F, -2F);
        this.add("body", body);
        for(ModelRendererTurbo mod : body){
            mod.rotateAngleY = -mod.rotateAngleY;
        }
        fixRotations();
    }

    @Override
    public void render(VehicleData data, String us){
        render(data, "body");
    }

    @Override
    public void render(VehicleData data, String us, VehicleEntity vehicle, int meta){
        render(data, "body");
    }

}
