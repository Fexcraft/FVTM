package net.fexcraft.mod.addons.hcp.models.trailer;

import javax.annotation.Nullable;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.model.vehicle.VehicleModelTMT;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.util.common.Static;
import net.minecraft.entity.Entity;

public class ModelTR1 extends VehicleModelTMT {

    public ModelTR1(){
    	super(); textureX = 512; textureY = 512;
        this.addToCreators("FEX___96");
        body = new ModelRendererTurbo[30];
        body[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 221
        body[1] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
        body[2] = new ModelRendererTurbo(this, 1, 57, textureX, textureY); // Box 1
        body[3] = new ModelRendererTurbo(this, 313, 1, textureX, textureY); // Box 2
        body[4] = new ModelRendererTurbo(this, 313, 25, textureX, textureY); // Box 3
        body[5] = new ModelRendererTurbo(this, 329, 49, textureX, textureY); // Box 4
        body[6] = new ModelRendererTurbo(this, 417, 49, textureX, textureY); // Box 5
        body[7] = new ModelRendererTurbo(this, 185, 57, textureX, textureY); // Box 10
        body[8] = new ModelRendererTurbo(this, 265, 97, textureX, textureY); // Box 13
        body[9] = new ModelRendererTurbo(this, 1, 121, textureX, textureY); // Box 14
        body[10] = new ModelRendererTurbo(this, 217, 121, textureX, textureY); // Box 15
        body[11] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 16
        body[12] = new ModelRendererTurbo(this, 377, 49, textureX, textureY); // Box 17
        body[13] = new ModelRendererTurbo(this, 233, 57, textureX, textureY); // Box 18
        body[14] = new ModelRendererTurbo(this, 1, 145, textureX, textureY); // Box 19
        body[15] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 21
        body[16] = new ModelRendererTurbo(this, 41, 1, textureX, textureY); // Box 22
        body[17] = new ModelRendererTurbo(this, 377, 121, textureX, textureY); // Box 23
        body[18] = new ModelRendererTurbo(this, 41, 17, textureX, textureY); // Box 24
        body[19] = new ModelRendererTurbo(this, 33, 33, textureX, textureY); // Box 25
        body[20] = new ModelRendererTurbo(this, 81, 145, textureX, textureY); // Box 26
        body[21] = new ModelRendererTurbo(this, 1, 201, textureX, textureY); // Box 27
        body[22] = new ModelRendererTurbo(this, 1, 209, textureX, textureY); // Box 28
        body[23] = new ModelRendererTurbo(this, 417, 49, textureX, textureY); // Box 29
        body[24] = new ModelRendererTurbo(this, 433, 49, textureX, textureY); // Box 30
        body[25] = new ModelRendererTurbo(this, 1, 41, textureX, textureY); // Box 31
        body[26] = new ModelRendererTurbo(this, 185, 57, textureX, textureY); // Box 34
        body[27] = new ModelRendererTurbo(this, 409, 121, textureX, textureY); // Box 120
        body[28] = new ModelRendererTurbo(this, 385, 161, textureX, textureY); // Box 124
        body[29] = new ModelRendererTurbo(this, 105, 233, textureX, textureY); // Box 370

        body[0].addBox(-2F, 0F, -2F, 4, 8, 4, 0F); // Box 221
        body[0].setRotationPoint(0F, -19F, 0F);
        body[0].rotateAngleY = -0.78539816F;

        body[1].addBox(0F, 0F, 0F, 128, 3, 52, 0F); // Box 0
        body[1].setRotationPoint(-236F, -24F, -26F);

        body[2].addShapeBox(0F, 0F, 0F, 64, 4, 52, 0F, 4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 4F, 0F, 0F, 0F, 0F, -2F, -2F, 0F, -2F, -2F, 0F, -2F, 0F, 0F, -2F); // Box 1
        body[2].setRotationPoint(-44F, -21F, -26F);

        body[3].addShapeBox(0F, 0F, 0F, 90, 12, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 2
        body[3].setRotationPoint(-201F, -9F, 8F);

        body[4].addShapeBox(0F, 0F, -4F, 90, 12, 4, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 3
        body[4].setRotationPoint(-201F, -9F, -8F);

        body[5].addBox(-2F, -2F, 0F, 4, 4, 36, 0F); // Box 4
        body[5].setRotationPoint(-184.5F, -2F, -18F);

        body[6].addBox(-2F, -2F, 0F, 4, 4, 36, 0F); // Box 5
        body[6].setRotationPoint(-155.5F, -2F, -18F);

        body[7].addBox(-2F, -2F, 0F, 4, 4, 36, 0F); // Box 10
        body[7].setRotationPoint(-126.5F, -2F, -18F);

        body[8].addBox(0F, 0F, 0F, 110, 12, 4, 0F); // Box 13
        body[8].setRotationPoint(-210F, -21F, 10F);

        body[9].addBox(0F, 0F, -4F, 110, 12, 4, 0F); // Box 14
        body[9].setRotationPoint(-210F, -21F, -10F);

        body[10].addBox(0F, 0F, 0F, 84, 12, 20, 0F); // Box 15
        body[10].setRotationPoint(-199F, -11F, -10F);

        body[11].addShapeBox(0F, 0F, -4F, 12, 12, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -11F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -11F, 0F, 0F); // Box 16
        body[11].setRotationPoint(-222F, -21F, -10F);

        body[12].addShapeBox(0F, 0F, 0F, 12, 12, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -11F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -11F, 0F, 0F); // Box 17
        body[12].setRotationPoint(-222F, -21F, 10F);

        body[13].addShapeBox(0F, 0F, 0F, 58, 12, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -56F, 0F, 0F, -56F, 0F, 0F, 0F, 0F, 0F); // Box 18
        body[13].setRotationPoint(-100F, -21F, 10F);

        body[14].addShapeBox(0F, 0F, -4F, 58, 12, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -56F, 0F, 0F, -56F, 0F, 0F, 0F, 0F, 0F); // Box 19
        body[14].setRotationPoint(-100F, -21F, -10F);

        body[15].addBox(0F, 0F, 0F, 2, 12, 2, 0F); // Box 21
        body[15].setRotationPoint(-234F, -21F, -20F);

        body[16].addBox(0F, 0F, 0F, 2, 12, 2, 0F); // Box 22
        body[16].setRotationPoint(-234F, -21F, 18F);

        body[17].addBox(0F, 0F, 0F, 2, 6, 51, 0F); // Box 23
        body[17].setRotationPoint(-235.5F, -21F, -25.5F);

        body[18].addShapeBox(0F, 0F, 0F, 2, 12, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 8F, 0F, 0F, -8F, 0F, 0F, -8F, 0F, 0F, 8F, 0F, 0F); // Box 24
        body[18].setRotationPoint(-226F, -21F, -20F);

        body[19].addShapeBox(0F, 0F, 0F, 2, 12, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 8F, 0F, 0F, -8F, 0F, 0F, -8F, 0F, 0F, 8F, 0F, 0F); // Box 25
        body[19].setRotationPoint(-226F, -21F, 18F);

        body[20].addBox(0F, 0F, 0F, 4, 4, 48, 0F); // Box 26
        body[20].setRotationPoint(-235F, -9F, -24F);

        body[21].addBox(0F, 0F, 0F, 190, 3, 1, 0F); // Box 27
        body[21].setRotationPoint(-235F, -21F, -25F);

        body[22].addBox(0F, 0F, 0F, 190, 3, 1, 0F); // Box 28
        body[22].setRotationPoint(-235F, -21F, 24F);

        body[23].addBox(0F, 0F, 0F, 2, 12, 2, 0F); // Box 29
        body[23].setRotationPoint(-234F, -21F, -1F);

        body[24].addShapeBox(0F, 0F, 0F, 2, 12, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 8F, 0F, 0F, -8F, 0F, 0F, -8F, 0F, 0F, 8F, 0F, 0F); // Box 30
        body[24].setRotationPoint(-226F, -21F, -1F);

        body[25].addBox(0F, 0F, 0F, 6, 4, 6, 0F); // Box 31
        body[25].setRotationPoint(-50F, -21F, -22F);

        body[26].addBox(0F, 0F, 0F, 6, 4, 6, 0F); // Box 34
        body[26].setRotationPoint(-50F, -21F, 16F);

        body[27].addBox(0F, 0F, 0F, 1, 2, 7, 0F); // Box 120
        body[27].setRotationPoint(-236F, -18.5F, -22F);

        body[28].addBox(0F, 0F, 0F, 1, 2, 7, 0F); // Box 124
        body[28].setRotationPoint(-236F, -18.5F, 15F);

        body[29].addBox(0F, 0F, 0F, 128, 3, 52, 0F); // Box 370
        body[29].setRotationPoint(-108F, -24F, -26F);

        chassis = new ModelRendererTurbo[4];
        chassis[0] = new ModelRendererTurbo(this, 465, 49, textureX, textureY); // Box 32
        chassis[1] = new ModelRendererTurbo(this, 1, 57, textureX, textureY); // Box 33
        chassis[2] = new ModelRendererTurbo(this, 489, 49, textureX, textureY); // Box 35
        chassis[3] = new ModelRendererTurbo(this, 25, 65, textureX, textureY); // Box 36

        chassis[0].addBox(-2F, 0F, -2F, 4, 24, 4, 0F); // Box 32
        chassis[0].setRotationPoint(-47F, -17F, -19F);

        chassis[1].addBox(-3F, 24F, -3F, 6, 3, 6, 0F); // Box 33
        chassis[1].setRotationPoint(-47F, -17F, -19F);

        chassis[2].addBox(-2F, 0F, -2F, 4, 24, 4, 0F); // Box 35
        chassis[2].setRotationPoint(-47F, -17F, 19F);

        chassis[3].addBox(-3F, 24F, -3F, 6, 3, 6, 0F); // Box 36
        chassis[3].setRotationPoint(-47F, -17F, 19F);
        //
        //translateAll(0, 0, 0);
        flipAll();
    }

    @Override
    public void render(VehicleData data, Object obj, @Nullable Entity entity, int meta){
        render(body);
        for(ModelRendererTurbo turbo : chassis){
            turbo.rotateAngleZ = entity == null || ((VehicleEntity)entity).getEntityAtFront() == null ? 0 : Static.rad90;
        }
        render(chassis);
    }

}
