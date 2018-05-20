package net.fexcraft.mod.addons.fvp.models.part;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.part.PartModel;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.entity.Entity;

public class ModelAB1Doors extends PartModel<VehicleData> {

    int textureX = 1024;
    int textureY = 1024;

    public ModelAB1Doors(){
        creators.add("Ferdinand (FEX___96)");
        bodyDoorOpen = new ModelRendererTurbo[7];
        bodyDoorOpen[0] = new ModelRendererTurbo(this, 457, 177, textureX, textureY); // Box 298
        bodyDoorOpen[1] = new ModelRendererTurbo(this, 41, 105, textureX, textureY); // Box 299
        bodyDoorOpen[2] = new ModelRendererTurbo(this, 913, 57, textureX, textureY); // Box 300
        bodyDoorOpen[3] = new ModelRendererTurbo(this, 337, 145, textureX, textureY); // Box 301
        bodyDoorOpen[4] = new ModelRendererTurbo(this, 57, 105, textureX, textureY); // Box 302
        bodyDoorOpen[5] = new ModelRendererTurbo(this, 1, 105, textureX, textureY); // Box 303
        bodyDoorOpen[6] = new ModelRendererTurbo(this, 89, 105, textureX, textureY); // Box 304

        bodyDoorOpen[0].addBox(0F, 0F, 0F, 14, 22, 1, 0F); // Box 298
        bodyDoorOpen[0].setRotationPoint(-54F, -26F, -31.5F);

        bodyDoorOpen[1].addBox(9F, 6F, -0.5F, 3, 1, 2, 0F); // Box 299
        bodyDoorOpen[1].setRotationPoint(-54F, -26F, -31.5F);

        bodyDoorOpen[2].addShapeBox(0F, -21F, 0F, 1, 21, 1, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 300
        bodyDoorOpen[2].setRotationPoint(-54F, -26F, -31.5F);

        bodyDoorOpen[3].addShapeBox(13F, -21F, 0F, 1, 21, 1, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 301
        bodyDoorOpen[3].setRotationPoint(-54F, -26F, -31.5F);

        bodyDoorOpen[4].addBox(1F, -21F, 1F, 12, 1, 1, 0F); // Box 302
        bodyDoorOpen[4].setRotationPoint(-54F, -26F, -31.5F);

        bodyDoorOpen[5].addBox(-1F, 2F, 0.5F, 3, 2, 1, 0F); // Box 303
        bodyDoorOpen[5].setRotationPoint(-54F, -26F, -31.5F);

        bodyDoorOpen[6].addBox(-1F, 16F, 0.5F, 3, 2, 1, 0F); // Box 304
        bodyDoorOpen[6].setRotationPoint(-54F, -26F, -31.5F);

        bodyDoorClose = new ModelRendererTurbo[7];
        bodyDoorClose[0] = new ModelRendererTurbo(this, 1, 161, textureX, textureY); // Box 289
        bodyDoorClose[1] = new ModelRendererTurbo(this, 209, 57, textureX, textureY); // Box 290
        bodyDoorClose[2] = new ModelRendererTurbo(this, 297, 57, textureX, textureY); // Box 291
        bodyDoorClose[3] = new ModelRendererTurbo(this, 481, 97, textureX, textureY); // Box 292
        bodyDoorClose[4] = new ModelRendererTurbo(this, 57, 81, textureX, textureY); // Box 293
        bodyDoorClose[5] = new ModelRendererTurbo(this, 169, 81, textureX, textureY); // Box 294
        bodyDoorClose[6] = new ModelRendererTurbo(this, 273, 89, textureX, textureY); // Box 296

        bodyDoorClose[0].addBox(0F, 0F, 0F, 13, 17, 1, 0F); // Box 289
        bodyDoorClose[0].setRotationPoint(82F, -21F, -31.5F);

        bodyDoorClose[1].addShapeBox(0F, -23F, 0F, 1, 23, 1, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 290
        bodyDoorClose[1].setRotationPoint(82F, -21F, -31.5F);

        bodyDoorClose[2].addShapeBox(12F, -23F, 0F, 1, 23, 1, 0F, 2F, 0F, -1F, -2F, 0F, -1F, -2F, 0F, 1F, 2F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 291
        bodyDoorClose[2].setRotationPoint(82F, -21F, -31.5F);

        bodyDoorClose[3].addShapeBox(1F, -23F, 1F, 9, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 292
        bodyDoorClose[3].setRotationPoint(82F, -21F, -31.5F);

        bodyDoorClose[4].addBox(-1F, 1F, 0.5F, 3, 2, 1, 0F); // Box 293
        bodyDoorClose[4].setRotationPoint(82F, -21F, -31.5F);

        bodyDoorClose[5].addBox(-1F, 13F, 0.5F, 3, 2, 1, 0F); // Box 294
        bodyDoorClose[5].setRotationPoint(82F, -21F, -31.5F);

        bodyDoorClose[6].addBox(9F, 1F, -0.5F, 3, 1, 2, 0F); // Box 296
        bodyDoorClose[6].setRotationPoint(82F, -21F, -31.5F);

        //translateAll(0F, 0F, 0F);
        flipAll();
    }

    @Override
    public void render(VehicleData data, String us){
        data.getPrimaryColor().glColorApply();
        for(ModelRendererTurbo mod : bodyDoorOpen){
            mod.rotateAngleY = data.doorsOpen() ? Static.rad90 : 0;
            mod.render();
        }
        for(ModelRendererTurbo mod : bodyDoorClose){
            mod.rotateAngleY = data.doorsOpen() ? Static.rad90 : 0;
            mod.render();
        }
        RGB.glColorReset();
    }

    @Override
    public void render(VehicleData data, String us, Entity vehicle){
        this.render(data, us);
    }

}
