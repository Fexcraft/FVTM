package net.fexcraft.mod.addons.zmp.models.part.c4;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.model.part.PartModel;

public class ModelC4Z1Interior extends PartModel {

    public ModelC4Z1Interior(){
    	super(); textureX = 1024; textureY = 1024;
        this.addToCreators("zackyboy18");
        this.addToCreators("FEX___96");
        ModelRendererTurbo[] body = new ModelRendererTurbo[14];
        body[0] = new ModelRendererTurbo(this, 905, 145, textureX, textureY); // Box 259
        body[1] = new ModelRendererTurbo(this, 113, 121, textureX, textureY); // Box 260
        body[2] = new ModelRendererTurbo(this, 985, 153, textureX, textureY); // Box 274
        body[3] = new ModelRendererTurbo(this, 193, 177, textureX, textureY); // Box 275
        body[4] = new ModelRendererTurbo(this, 849, 217, textureX, textureY); // Box 276
        body[5] = new ModelRendererTurbo(this, 969, 169, textureX, textureY); // Box 277
        body[6] = new ModelRendererTurbo(this, 1001, 153, textureX, textureY); // Box 278
        body[7] = new ModelRendererTurbo(this, 353, 137, textureX, textureY); // Box 279
        body[8] = new ModelRendererTurbo(this, 561, 161, textureX, textureY); // Box 280
        body[9] = new ModelRendererTurbo(this, 729, 153, textureX, textureY); // Box 281
        body[10] = new ModelRendererTurbo(this, 337, 137, textureX, textureY); // Box 282
        body[11] = new ModelRendererTurbo(this, 385, 49, textureX, textureY); // Box 283
        body[12] = new ModelRendererTurbo(this, 1001, 81, textureX, textureY); // Box 284
        body[13] = new ModelRendererTurbo(this, 865, 73, textureX, textureY); // Box 285

        body[0].addShapeBox(0F, 0F, 0F, 4, 4, 10, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F); // Box 259
        body[0].setRotationPoint(52F, -26F, 8F);

        body[1].addShapeBox(0F, 0F, 0F, 2, 2, 2, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F); // Box 260
        body[1].setRotationPoint(50F, -26F, 12F);

        body[2].addBox(0F, 0F, 0F, 1, 1, 6, 0F); // Box 274
        body[2].setRotationPoint(53.8F, -23F, -14F);

        body[3].addShapeBox(0F, 0F, 0F, 3, 5, 12, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F); // Box 275
        body[3].setRotationPoint(54F, -24F, -17F);

        body[4].addBox(0F, 0F, 0F, 17, 9, 6, 0F); // Box 276
        body[4].setRotationPoint(35F, -14F, 1F);

        body[5].addShapeBox(0F, 0F, 0F, 3, 11, 6, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 277
        body[5].setRotationPoint(52F, -24F, 1F);

        body[6].addShapeBox(0F, 0F, 0F, 7, 1, 3, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 1F, 0F, 0F); // Box 278
        body[6].setRotationPoint(37F, -15F, 2.5F);

        body[7].addBox(0F, 0F, 0F, 6, 1, 1, 0F); // Box 279
        body[7].setRotationPoint(38F, -15.5F, 3.5F);
        body[7].rotateAngleZ = 0.19198622F;

        body[8].addShapeBox(0F, 0F, 0F, 4, 1, 4, 0F, -0.5F, -0.5F, -0.5F, -0.5F, -0.5F, -0.5F, -0.5F, -0.5F, -0.5F, -0.5F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 280
        body[8].setRotationPoint(47F, -15F, 2F);

        body[9].addBox(0F, 0F, 0F, 1, 4, 1, 0F); // Box 281
        body[9].setRotationPoint(48.5F, -17.5F, 3.5F);

        body[10].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F); // Box 282
        body[10].setRotationPoint(48.5F, -18F, 3.5F);

        body[11].addBox(0F, 0F, 0F, 1, 1, 4, 0F); // Box 283
        body[11].setRotationPoint(51.8F, -23F, 2F);

        body[12].addBox(0F, 1F, 0F, 1, 2, 4, 0F); // Box 284
        body[12].setRotationPoint(51.8F, -21F, 2F);

        body[13].addBox(0F, 0F, 0F, 1, 1, 4, 0F); // Box 285
        body[13].setRotationPoint(51.8F, -21.5F, 2F);
        this.add("body", body);
        fixRotations(get("body"));
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
