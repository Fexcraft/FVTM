package net.fexcraft.mod.addons.fvp.models.part.c7;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.model.part.PartModel;

public class ModelC7Interior extends PartModel {

    public ModelC7Interior(){
    	super(); textureX = 512; textureY = 512;
        this.addToCreators("Ferdinand (FEX___96)");
        ModelRendererTurbo[] body = new ModelRendererTurbo[14];
        body[0] = new ModelRendererTurbo(this, 401, 153, textureX, textureY); // Box 259
        body[1] = new ModelRendererTurbo(this, 73, 57, textureX, textureY); // Box 260
        body[2] = new ModelRendererTurbo(this, 97, 81, textureX, textureY); // Box 274
        body[3] = new ModelRendererTurbo(this, 257, 161, textureX, textureY); // Box 275
        body[4] = new ModelRendererTurbo(this, 1, 169, textureX, textureY); // Box 276
        body[5] = new ModelRendererTurbo(this, 49, 169, textureX, textureY); // Box 277
        body[6] = new ModelRendererTurbo(this, 489, 129, textureX, textureY); // Box 278
        body[7] = new ModelRendererTurbo(this, 73, 129, textureX, textureY); // Box 279
        body[8] = new ModelRendererTurbo(this, 145, 129, textureX, textureY); // Box 280
        body[9] = new ModelRendererTurbo(this, 377, 65, textureX, textureY); // Box 281
        body[10] = new ModelRendererTurbo(this, 17, 73, textureX, textureY); // Box 282
        body[11] = new ModelRendererTurbo(this, 241, 97, textureX, textureY); // Box 283
        body[12] = new ModelRendererTurbo(this, 161, 113, textureX, textureY); // Box 284
        body[13] = new ModelRendererTurbo(this, 441, 121, textureX, textureY); // Box 285
        body[0].addShapeBox(0F, 0F, 0F, 4, 4, 10, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F); // Box 259
        body[0].setRotationPoint(15F, -16F, 4F);
        body[1].addShapeBox(0F, 0F, 0F, 2, 2, 2, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F); // Box 260
        body[1].setRotationPoint(13F, -16F, 8F);
        body[2].addBox(0F, 0F, 0F, 1, 1, 4, 0F); // Box 274
        body[2].setRotationPoint(14.8F, -13F, -12F);
        body[3].addShapeBox(0F, 0F, 0F, 7, 4, 10, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F); // Box 275
        body[3].setRotationPoint(15F, -14F, -15F);
        body[4].addBox(0F, 0F, 0F, 17, 3, 6, 0F); // Box 276
        body[4].setRotationPoint(-1F, -6F, -3F);
        body[5].addShapeBox(0F, 0F, 0F, 6, 10, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 277
        body[5].setRotationPoint(16F, -13F, -3F);
        body[6].addShapeBox(0F, 0F, 0F, 7, 1, 3, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 1F, 0F, 0F); // Box 278
        body[6].setRotationPoint(1F, -7F, -1.5F);
        body[7].addBox(0F, 0F, 0F, 6, 1, 1, 0F); // Box 279
        body[7].setRotationPoint(2F, -7.5F, -0.5F);
        body[7].rotateAngleZ = -0.19198622F;
        body[8].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -0.5F, -0.5F, -0.5F, -0.5F, -0.5F, -0.5F, -0.5F, -0.5F, -0.5F, -0.5F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 280
        body[8].setRotationPoint(11F, -7F, -2F);
        body[9].addBox(0F, 0F, 0F, 1, 4, 1, 0F); // Box 281
        body[9].setRotationPoint(12.5F, -9.5F, -0.5F);
        body[10].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F); // Box 282
        body[10].setRotationPoint(12.5F, -10F, -0.5F);
        body[11].addBox(0F, 0F, 0F, 1, 1, 4, 0F); // Box 283
        body[11].setRotationPoint(15.8F, -12F, -2F);
        body[12].addBox(0F, 1F, 0F, 1, 2, 4, 0F); // Box 284
        body[12].setRotationPoint(15.8F, -10F, -2F);
        body[13].addBox(0F, 0F, 0F, 1, 1, 4, 0F); // Box 285
        body[13].setRotationPoint(15.8F, -10.5F, -2F);
        this.add("body", body);
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
