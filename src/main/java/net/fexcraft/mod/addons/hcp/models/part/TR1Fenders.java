package net.fexcraft.mod.addons.hcp.models.part;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.part.PartModel;
import net.minecraft.entity.Entity;

/**
 *
 * @author Ferdinand (FEX___96)
 */
public class TR1Fenders extends PartModel {

    public TR1Fenders(){
    	super(); this.addToCreators("FEX___96");
        textureX = 512; textureY = 512;
        ModelRendererTurbo[] track_wheels_left = new ModelRendererTurbo[21];
        track_wheels_left[0] = new ModelRendererTurbo(this, 145, 169, textureX, textureY); // Box 58
        track_wheels_left[1] = new ModelRendererTurbo(this, 457, 145, textureX, textureY); // Box 59
        track_wheels_left[2] = new ModelRendererTurbo(this, 473, 169, textureX, textureY); // Box 60
        track_wheels_left[3] = new ModelRendererTurbo(this, 193, 177, textureX, textureY); // Box 61
        track_wheels_left[4] = new ModelRendererTurbo(this, 281, 161, textureX, textureY); // Box 62
        track_wheels_left[5] = new ModelRendererTurbo(this, 233, 177, textureX, textureY); // Box 63
        track_wheels_left[6] = new ModelRendererTurbo(this, 385, 185, textureX, textureY); // Box 64
        track_wheels_left[7] = new ModelRendererTurbo(this, 425, 185, textureX, textureY); // Box 65
        track_wheels_left[8] = new ModelRendererTurbo(this, 465, 193, textureX, textureY); // Box 66
        track_wheels_left[9] = new ModelRendererTurbo(this, 321, 161, textureX, textureY); // Box 67
        track_wheels_left[10] = new ModelRendererTurbo(this, 1, 185, textureX, textureY); // Box 68
        track_wheels_left[11] = new ModelRendererTurbo(this, 73, 169, textureX, textureY); // Box 69
        track_wheels_left[12] = new ModelRendererTurbo(this, 377, 209, textureX, textureY); // Box 70
        track_wheels_left[13] = new ModelRendererTurbo(this, 417, 209, textureX, textureY); // Box 71
        track_wheels_left[14] = new ModelRendererTurbo(this, 1, 217, textureX, textureY); // Box 72
        track_wheels_left[15] = new ModelRendererTurbo(this, 41, 217, textureX, textureY); // Box 73
        track_wheels_left[16] = new ModelRendererTurbo(this, 81, 217, textureX, textureY); // Box 74
        track_wheels_left[17] = new ModelRendererTurbo(this, 217, 177, textureX, textureY); // Box 75
        track_wheels_left[18] = new ModelRendererTurbo(this, 273, 185, textureX, textureY); // Box 76
        track_wheels_left[19] = new ModelRendererTurbo(this, 337, 185, textureX, textureY); // Box 77
        track_wheels_left[20] = new ModelRendererTurbo(this, 121, 217, textureX, textureY); // Box 78

        track_wheels_left[0].addShapeBox(0F, 0F, 0F, 17, 1, 12, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 58
        track_wheels_left[0].setRotationPoint(-135F, -16F, 14F);

        track_wheels_left[1].addShapeBox(0F, 0F, 0F, 2, 1, 12, 0F, 4F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 59
        track_wheels_left[1].setRotationPoint(-119F, -15F, 14F);

        track_wheels_left[2].addShapeBox(0F, 0F, 0F, 2, 8, 14, 0F, 5F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 60
        track_wheels_left[2].setRotationPoint(-114F, -14F, 12F);

        track_wheels_left[3].addBox(0F, 0F, 0F, 2, 8, 14, 0F); // Box 61
        track_wheels_left[3].setRotationPoint(-114F, -6F, 12F);

        track_wheels_left[4].addShapeBox(0F, 0F, 0F, 2, 1, 12, 0F, -1F, 0F, 0F, 4F, 0F, 0F, 4F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 62
        track_wheels_left[4].setRotationPoint(-136F, -15F, 14F);

        track_wheels_left[5].addShapeBox(0F, 0F, 0F, 2, 8, 14, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 63
        track_wheels_left[5].setRotationPoint(-141F, -14F, 12F);

        track_wheels_left[6].addBox(0F, 0F, 0F, 2, 8, 14, 0F); // Box 64
        track_wheels_left[6].setRotationPoint(-141F, -6F, 12F);

        track_wheels_left[7].addBox(0F, 0F, 0F, 2, 8, 14, 0F); // Box 65
        track_wheels_left[7].setRotationPoint(-143F, -6F, 12F);

        track_wheels_left[8].addShapeBox(0F, 0F, 0F, 2, 8, 14, 0F, 5F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 66
        track_wheels_left[8].setRotationPoint(-143F, -14F, 12F);

        track_wheels_left[9].addShapeBox(0F, 0F, 0F, 2, 1, 12, 0F, 4F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 67
        track_wheels_left[9].setRotationPoint(-148F, -15F, 14F);

        track_wheels_left[10].addShapeBox(0F, 0F, 0F, 17, 1, 12, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 68
        track_wheels_left[10].setRotationPoint(-164F, -16F, 14F);

        track_wheels_left[11].addShapeBox(0F, 0F, 0F, 2, 1, 12, 0F, -1F, 0F, 0F, 4F, 0F, 0F, 4F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 69
        track_wheels_left[11].setRotationPoint(-165F, -15F, 14F);

        track_wheels_left[12].addShapeBox(0F, 0F, 0F, 2, 8, 14, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 70
        track_wheels_left[12].setRotationPoint(-170F, -14F, 12F);

        track_wheels_left[13].addBox(0F, 0F, 0F, 2, 8, 14, 0F); // Box 71
        track_wheels_left[13].setRotationPoint(-170F, -6F, 12F);

        track_wheels_left[14].addBox(0F, 0F, 0F, 2, 8, 14, 0F); // Box 72
        track_wheels_left[14].setRotationPoint(-172F, -6F, 12F);

        track_wheels_left[15].addBox(0F, 0F, 0F, 2, 8, 14, 0F); // Box 73
        track_wheels_left[15].setRotationPoint(-199F, -6F, 12F);

        track_wheels_left[16].addShapeBox(0F, 0F, 0F, 2, 8, 14, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 74
        track_wheels_left[16].setRotationPoint(-199F, -14F, 12F);

        track_wheels_left[17].addShapeBox(0F, 0F, 0F, 2, 1, 12, 0F, -1F, 0F, 0F, 4F, 0F, 0F, 4F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 75
        track_wheels_left[17].setRotationPoint(-194F, -15F, 14F);

        track_wheels_left[18].addShapeBox(0F, 0F, 0F, 17, 1, 12, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 76
        track_wheels_left[18].setRotationPoint(-193F, -16F, 14F);

        track_wheels_left[19].addShapeBox(0F, 0F, 0F, 2, 1, 12, 0F, 4F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 77
        track_wheels_left[19].setRotationPoint(-177F, -15F, 14F);

        track_wheels_left[20].addShapeBox(0F, 0F, 0F, 2, 8, 14, 0F, 5F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 78
        track_wheels_left[20].setRotationPoint(-172F, -14F, 12F);
        this.add("track_wheels_left", track_wheels_left);

        ModelRendererTurbo[] track_wheels_right = new ModelRendererTurbo[21];
        track_wheels_right[0] = new ModelRendererTurbo(this, 273, 81, textureX, textureY); // Box 37
        track_wheels_right[1] = new ModelRendererTurbo(this, 401, 65, textureX, textureY); // Box 38
        track_wheels_right[2] = new ModelRendererTurbo(this, 1, 73, textureX, textureY); // Box 39
        track_wheels_right[3] = new ModelRendererTurbo(this, 17, 81, textureX, textureY); // Box 40
        track_wheels_right[4] = new ModelRendererTurbo(this, 433, 121, textureX, textureY); // Box 41
        track_wheels_right[5] = new ModelRendererTurbo(this, 473, 121, textureX, textureY); // Box 42
        track_wheels_right[6] = new ModelRendererTurbo(this, 145, 145, textureX, textureY); // Box 43
        track_wheels_right[7] = new ModelRendererTurbo(this, 185, 145, textureX, textureY); // Box 44
        track_wheels_right[8] = new ModelRendererTurbo(this, 433, 145, textureX, textureY); // Box 45
        track_wheels_right[9] = new ModelRendererTurbo(this, 185, 73, textureX, textureY); // Box 46
        track_wheels_right[10] = new ModelRendererTurbo(this, 209, 161, textureX, textureY); // Box 47
        track_wheels_right[11] = new ModelRendererTurbo(this, 225, 105, textureX, textureY); // Box 48
        track_wheels_right[12] = new ModelRendererTurbo(this, 473, 145, textureX, textureY); // Box 49
        track_wheels_right[13] = new ModelRendererTurbo(this, 257, 161, textureX, textureY); // Box 50
        track_wheels_right[14] = new ModelRendererTurbo(this, 297, 161, textureX, textureY); // Box 51
        track_wheels_right[15] = new ModelRendererTurbo(this, 337, 161, textureX, textureY); // Box 52
        track_wheels_right[16] = new ModelRendererTurbo(this, 457, 121, textureX, textureY); // Box 53
        track_wheels_right[17] = new ModelRendererTurbo(this, 1, 169, textureX, textureY); // Box 54
        track_wheels_right[18] = new ModelRendererTurbo(this, 169, 145, textureX, textureY); // Box 55
        track_wheels_right[19] = new ModelRendererTurbo(this, 49, 169, textureX, textureY); // Box 56
        track_wheels_right[20] = new ModelRendererTurbo(this, 89, 169, textureX, textureY); // Box 57

        track_wheels_right[0].addShapeBox(0F, 0F, 0F, 17, 1, 12, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 37
        track_wheels_right[0].setRotationPoint(-135F, -16F, -26F);

        track_wheels_right[1].addShapeBox(0F, 0F, 0F, 2, 1, 12, 0F, -1F, 0F, 0F, 4F, 0F, 0F, 4F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 38
        track_wheels_right[1].setRotationPoint(-136F, -15F, -26F);

        track_wheels_right[2].addShapeBox(0F, 0F, 0F, 2, 1, 12, 0F, 4F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 39
        track_wheels_right[2].setRotationPoint(-119F, -15F, -26F);

        track_wheels_right[3].addShapeBox(0F, 0F, 0F, 2, 8, 14, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 40
        track_wheels_right[3].setRotationPoint(-141F, -14F, -26F);

        track_wheels_right[4].addShapeBox(0F, 0F, 0F, 2, 8, 14, 0F, 5F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 41
        track_wheels_right[4].setRotationPoint(-114F, -14F, -26F);

        track_wheels_right[5].addBox(0F, 0F, 0F, 2, 8, 14, 0F); // Box 42
        track_wheels_right[5].setRotationPoint(-141F, -6F, -26F);

        track_wheels_right[6].addBox(0F, 0F, 0F, 2, 8, 14, 0F); // Box 43
        track_wheels_right[6].setRotationPoint(-114F, -6F, -26F);

        track_wheels_right[7].addBox(0F, 0F, 0F, 2, 8, 14, 0F); // Box 44
        track_wheels_right[7].setRotationPoint(-143F, -6F, -26F);

        track_wheels_right[8].addShapeBox(0F, 0F, 0F, 2, 8, 14, 0F, 5F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 45
        track_wheels_right[8].setRotationPoint(-143F, -14F, -26F);

        track_wheels_right[9].addShapeBox(0F, 0F, 0F, 2, 1, 12, 0F, 4F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 46
        track_wheels_right[9].setRotationPoint(-148F, -15F, -26F);

        track_wheels_right[10].addShapeBox(0F, 0F, 0F, 17, 1, 12, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 47
        track_wheels_right[10].setRotationPoint(-164F, -16F, -26F);

        track_wheels_right[11].addShapeBox(0F, 0F, 0F, 2, 1, 12, 0F, -1F, 0F, 0F, 4F, 0F, 0F, 4F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 48
        track_wheels_right[11].setRotationPoint(-165F, -15F, -26F);

        track_wheels_right[12].addShapeBox(0F, 0F, 0F, 2, 8, 14, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 49
        track_wheels_right[12].setRotationPoint(-170F, -14F, -26F);

        track_wheels_right[13].addBox(0F, 0F, 0F, 2, 8, 14, 0F); // Box 50
        track_wheels_right[13].setRotationPoint(-170F, -6F, -26F);

        track_wheels_right[14].addBox(0F, 0F, 0F, 2, 8, 14, 0F); // Box 51
        track_wheels_right[14].setRotationPoint(-172F, -6F, -26F);

        track_wheels_right[15].addShapeBox(0F, 0F, 0F, 2, 8, 14, 0F, 5F, 0F, 0F, -5F, 0F, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 52
        track_wheels_right[15].setRotationPoint(-172F, -14F, -26F);

        track_wheels_right[16].addShapeBox(0F, 0F, 0F, 2, 1, 12, 0F, 4F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 53
        track_wheels_right[16].setRotationPoint(-177F, -15F, -26F);

        track_wheels_right[17].addShapeBox(0F, 0F, 0F, 17, 1, 12, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 54
        track_wheels_right[17].setRotationPoint(-193F, -16F, -26F);

        track_wheels_right[18].addShapeBox(0F, 0F, 0F, 2, 1, 12, 0F, -1F, 0F, 0F, 4F, 0F, 0F, 4F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 55
        track_wheels_right[18].setRotationPoint(-194F, -15F, -26F);

        track_wheels_right[19].addShapeBox(0F, 0F, 0F, 2, 8, 14, 0F, -5F, 0F, 0F, 5F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 56
        track_wheels_right[19].setRotationPoint(-199F, -14F, -26F);

        track_wheels_right[20].addBox(0F, 0F, 0F, 2, 8, 14, 0F); // Box 57
        track_wheels_right[20].setRotationPoint(-199F, -6F, -26F);
        this.add("track_wheels_right", track_wheels_right);
    }
    
    @Override
    public void render(VehicleData data, String us){
        switch(us){
            case "fender_left": {
                render("track_wheels_left");
                return;
            }
            case "fender_right": {
                render("track_wheels_right");
                return;
            }
            default: {
                super.render(data, us);
                return;
            }
        }
    }

    @Override
    public void render(VehicleData data, String us, Entity vehicle, int meta){
        this.render(data, us);
    }

}
