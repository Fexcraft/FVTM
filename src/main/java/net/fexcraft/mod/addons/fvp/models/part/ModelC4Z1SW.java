package net.fexcraft.mod.addons.fvp.models.part;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.model.part.PartModel;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.minecraft.entity.Entity;

public class ModelC4Z1SW extends PartModel<VehicleData> {

    private static final int textureX = 1024, textureY = 1024;

    public ModelC4Z1SW(){
        this.creators.add("Ferdinand (FEX___96)");
        steering = new ModelRendererTurbo[13];
        steering[0] = new ModelRendererTurbo(this, 873, 17, textureX, textureY); // Box 261
        steering[1] = new ModelRendererTurbo(this, 817, 105, textureX, textureY); // Box 262
        steering[2] = new ModelRendererTurbo(this, 25, 113, textureX, textureY); // Box 263
        steering[3] = new ModelRendererTurbo(this, 993, 49, textureX, textureY); // Box 264
        steering[4] = new ModelRendererTurbo(this, 329, 57, textureX, textureY); // Box 265
        steering[5] = new ModelRendererTurbo(this, 585, 41, textureX, textureY); // Box 266
        steering[6] = new ModelRendererTurbo(this, 145, 65, textureX, textureY); // Box 267
        steering[7] = new ModelRendererTurbo(this, 217, 121, textureX, textureY); // Box 268
        steering[8] = new ModelRendererTurbo(this, 337, 129, textureX, textureY); // Box 269
        steering[9] = new ModelRendererTurbo(this, 913, 121, textureX, textureY); // Box 270
        steering[10] = new ModelRendererTurbo(this, 1017, 121, textureX, textureY); // Box 271
        steering[11] = new ModelRendererTurbo(this, 313, 129, textureX, textureY); // Box 272
        steering[12] = new ModelRendererTurbo(this, 321, 129, textureX, textureY); // Box 273

        steering[0].addBox(0F, -0.5F, -0.5F, 2, 1, 1, 0F); // Box 261
        steering[0].setRotationPoint(48F, -25F, 13F);

        steering[1].addShapeBox(0F, -2.5F, -0.5F, 1, 2, 1, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F); // Box 262
        steering[1].setRotationPoint(48F, -25F, 13F);

        steering[2].addShapeBox(0F, 0.5F, -0.5F, 1, 2, 1, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F); // Box 263
        steering[2].setRotationPoint(48F, -25F, 13F);

        steering[3].addShapeBox(0F, -0.5F, 0.5F, 1, 1, 2, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F); // Box 264
        steering[3].setRotationPoint(48F, -25F, 13F);

        steering[4].addShapeBox(0F, -0.5F, -2.5F, 1, 1, 2, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F); // Box 265
        steering[4].setRotationPoint(48F, -25F, 13F);

        steering[5].addBox(0F, 2.5F, -1.5F, 1, 1, 3, 0F); // Box 266
        steering[5].setRotationPoint(48F, -25F, 13F);

        steering[6].addBox(0F, -3.5F, -1.5F, 1, 1, 3, 0F); // Box 267
        steering[6].setRotationPoint(48F, -25F, 13F);

        steering[7].addBox(0F, -1.5F, -3.5F, 1, 3, 1, 0F); // Box 268
        steering[7].setRotationPoint(48F, -25F, 13F);

        steering[8].addBox(0F, -1.5F, 2.5F, 1, 3, 1, 0F); // Box 269
        steering[8].setRotationPoint(48F, -25F, 13F);

        steering[9].addShapeBox(0F, 1.5F, 2.5F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 1F, 0F, -1F, 1F, 0F, 0F, -2F, 0F, 0F, -2F); // Box 270
        steering[9].setRotationPoint(48F, -25F, 13F);

        steering[10].addShapeBox(0F, -3.5F, 2.5F, 1, 2, 1, 0F, 0F, -1F, 1F, 0F, -1F, 1F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 271
        steering[10].setRotationPoint(48F, -25F, 13F);

        steering[11].addShapeBox(0F, -3.5F, -3.5F, 1, 2, 1, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, -1F, 1F, 0F, -1F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 272
        steering[11].setRotationPoint(48F, -25F, 13F);

        steering[12].addShapeBox(0F, 1.5F, -3.5F, 1, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, -1F, 1F, 0F, -1F, 1F); // Box 273
        steering[12].setRotationPoint(48F, -25F, 13F);
    }

    @Override
    public void render(VehicleData data, String us){
        render(steering);
    }

    @Override
    public void render(VehicleData data, String us, Entity vehicle){
        VehicleEntity ent = (VehicleEntity) vehicle;
        for(ModelRendererTurbo submodel : steering){
            submodel.rotateAngleX = ent.getWheelsYaw() * 3.14159265F / 180F * 3F;
            submodel.render();
        }
    }

}
