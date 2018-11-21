package net.fexcraft.mod.addons.fvp.models.part.t1;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.model.part.PartModel;

public class ModelT1_5 extends PartModel {

    public ModelT1_5(){
    	super(); textureX = 512; textureY = 512;
        this.addToCreators("Ferdinand (FEX___96)");
        //
        ModelRendererTurbo[] body = new ModelRendererTurbo[12];
        body[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 1
        body[1] = new ModelRendererTurbo(this, 353, 1, textureX, textureY); // Box 2
        body[2] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 3
        body[3] = new ModelRendererTurbo(this, 305, 1, textureX, textureY); // Box 4
        body[4] = new ModelRendererTurbo(this, 337, 1, textureX, textureY); // Box 5
        body[5] = new ModelRendererTurbo(this, 369, 1, textureX, textureY); // Box 6
        body[6] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 7
        body[7] = new ModelRendererTurbo(this, 329, 1, textureX, textureY); // Box 8
        body[8] = new ModelRendererTurbo(this, 361, 1, textureX, textureY); // Box 9
        body[9] = new ModelRendererTurbo(this, 409, 1, textureX, textureY); // Box 10
        body[10] = new ModelRendererTurbo(this, 41, 1, textureX, textureY); // Box 11
        body[11] = new ModelRendererTurbo(this, 393, 1, textureX, textureY); // Box 12

        body[0].addBox(0F, 0F, 0F, 124, 1, 49, 0F); // Box 1
        body[0].setRotationPoint(-102F, -13F, -24.5F);

        body[1].addBox(0F, 0F, 0F, 1, 4, 49, 0F); // Box 2
        body[1].setRotationPoint(-103F, -14F, -24.5F);

        body[2].addShapeBox(0F, 0F, 0F, 6, 2, 8, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 3
        body[2].setRotationPoint(8F, -15F, -24.5F);

        body[3].addShapeBox(0F, 0F, 0F, 6, 2, 8, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 4
        body[3].setRotationPoint(8F, -15F, 16.5F);

        body[4].addShapeBox(0F, 0F, 0F, 6, 2, 8, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 5
        body[4].setRotationPoint(-94F, -15F, 16.5F);

        body[5].addShapeBox(0F, 0F, 0F, 6, 2, 8, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 6
        body[5].setRotationPoint(-94F, -15F, -24.5F);

        body[6].addShapeBox(0F, 0F, 0F, 4, 2, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 7
        body[6].setRotationPoint(4F, -15F, -25F);

        body[7].addShapeBox(0F, 0F, 0F, 4, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 8
        body[7].setRotationPoint(4F, -15F, 24F);

        body[8].addShapeBox(0F, 0F, 0F, 4, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 9
        body[8].setRotationPoint(-88F, -15F, 24F);

        body[9].addShapeBox(0F, 0F, 0F, 4, 2, 1, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 10
        body[9].setRotationPoint(-88F, -15F, -25F);

        body[10].addShapeBox(0F, 0F, 0F, 2, 1, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F, 0F, 0F, -0.5F); // Box 11
        body[10].setRotationPoint(22F, -13F, 23F);

        body[11].addShapeBox(0F, 0F, 0F, 2, 1, 2, 0F, 0F, 0F, -0.5F, 0F, 0F, -1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -1.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 12
        body[11].setRotationPoint(22F, -13F, -25F);
        this.add("body", body);

        /*trailerModel = new ModelRendererTurbo[1];
		trailerModel[0] = new ModelRendererTurbo(this, 200, 200, textureX, textureY); // Box 0
		trailerModel[0].addBox(-41F, -13F, 0F, 96, 48, 48, 0F); // Box 0
		trailerModel[0].setRotationPoint(-47F, -48F, -24F);*/
        //Placeholder Container Box
        //flipAll();
    }

    @Override
    public void render(VehicleData data, String usedAS){
        render(data, "body");
        super.def_renderContainer(data, usedAS);
    }

    @Override
    public void render(VehicleData data, String usedAS, VehicleEntity vehicle, int meta){
        render(data, "body");
        super.def_renderContainer(data, usedAS, vehicle);
    }

}
