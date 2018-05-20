package net.fexcraft.mod.addons.zmp.models.part;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.part.PartModel;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class Model4x4EscapeTrailerHitch extends PartModel<VehicleData> {

    int textureX = 512;
    int textureY = 512;

    public Model4x4EscapeTrailerHitch(){
        this.creators.add("zackyboy18");
        this.creators.add("FEX___96");
        body = new ModelRendererTurbo[4];
        body[0] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 376
        body[1] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 377
        body[2] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 378
        body[3] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 380

        body[0].addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 376
        body[0].setRotationPoint(-52F, 12.2F, -0.5F);

        body[1].addShapeBox(0F, 0F, 0F, 17, 1, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 377
        body[1].setRotationPoint(-51F, 13.2F, -1F);

        body[2].addShapeBox(0F, 0F, 0F, 18, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 4F, 0F, 0F, -4F, -1F, 0F, 0F); // Box 378
        body[2].setRotationPoint(-52F, 13.2F, -1F);

        body[3].addShapeBox(0F, 0F, 0F, 18, 1, 1, 0F, 0F, 0F, 0F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 4F, -1F, 0F, 0F); // Box 380
        body[3].setRotationPoint(-52F, 13.2F, 0F);
        //
        translateAll(0F, -12F, 0F);
    }

}
