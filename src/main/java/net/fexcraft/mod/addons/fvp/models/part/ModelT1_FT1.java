package net.fexcraft.mod.addons.fvp.models.part;

import net.fexcraft.mod.addons.fvp.scripts.T1SnowPlowScript;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.part.PartModelTMT;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.util.common.Static;
import net.minecraft.entity.Entity;

public class ModelT1_FT1 extends PartModelTMT {

    private ModelRendererTurbo[] snowplow;

    public ModelT1_FT1(){
    	super(); textureX = 512; textureY = 128;
        addToCreators("Ferdinand (FEX___96)");
        body = new ModelRendererTurbo[1];
        body[0] = new ModelRendererTurbo(this, 185, 1, textureX, textureY); // Box 9

        body[0].addShapeBox(0F, 0F, -24F, 4, 7, 48, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, 0F); // Box 9
        body[0].setRotationPoint(56F, -4.5F, 0F);

        snowplow = new ModelRendererTurbo[13];
        snowplow[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
        snowplow[1] = new ModelRendererTurbo(this, 121, 1, textureX, textureY); // Box 1
        snowplow[2] = new ModelRendererTurbo(this, 241, 1, textureX, textureY); // Box 2
        snowplow[3] = new ModelRendererTurbo(this, 361, 1, textureX, textureY); // Box 3
        snowplow[4] = new ModelRendererTurbo(this, 1, 65, textureX, textureY); // Box 4
        snowplow[5] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 5
        snowplow[6] = new ModelRendererTurbo(this, 65, 1, textureX, textureY); // Box 6
        snowplow[7] = new ModelRendererTurbo(this, 105, 1, textureX, textureY); // Box 7
        snowplow[8] = new ModelRendererTurbo(this, 137, 1, textureX, textureY); // Box 8
        snowplow[9] = new ModelRendererTurbo(this, 33, 1, textureX, textureY); // Box 10
        snowplow[10] = new ModelRendererTurbo(this, 185, 1, textureX, textureY); // Box 11
        snowplow[11] = new ModelRendererTurbo(this, 201, 1, textureX, textureY); // Box 12
        snowplow[12] = new ModelRendererTurbo(this, 217, 1, textureX, textureY); // Box 13

        snowplow[0].addShapeBox(5F, -3F, -27.5F, 2, 6, 56, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F); // Box 0
        snowplow[0].setRotationPoint(58F, -5F, 0F);

        snowplow[1].addShapeBox(5F, 3F, -27.5F, 2, 6, 56, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 6F, 0F, 0F, -6F, 0F, 0F); // Box 1
        snowplow[1].setRotationPoint(58F, -5F, 0F);

        snowplow[2].addShapeBox(6F, 9F, -27.5F, 2, 6, 56, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F, -4F, 0F, 0F, 4F, 0F, 0F, 10F, 0F, 0F, -10F, 0F, 0F); // Box 2
        snowplow[2].setRotationPoint(58F, -5F, 0F);

        snowplow[3].addShapeBox(5F, -6F, -27.5F, 2, 3, 56, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 7F, 0F, 0F, -7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 5F, 0F, 0F, -5F, 0F, 0F); // Box 3
        snowplow[3].setRotationPoint(58F, -5F, 0F);

        snowplow[4].addShapeBox(10.5F, 14F, -28F, 1, 1, 57, 0F, 0F, 0F, -0.3F, 0F, 0F, 0F, 6F, 0F, 0F, -6F, 0F, -0.3F, 0F, 0F, -0.3F, 1F, 0F, 0F, 7F, 0F, 0F, -6F, 0F, -0.3F); // Box 4
        snowplow[4].setRotationPoint(58F, -5F, 0F);

        snowplow[5].addBox(-2F, 4F, -13.5F, 10, 2, 4, 0F); // Box 5
        snowplow[5].setRotationPoint(58F, -5F, 0F);

        snowplow[6].addBox(-2F, 4F, 10.5F, 12, 2, 4, 0F); // Box 6
        snowplow[6].setRotationPoint(58F, -5F, 0F);

        snowplow[7].addShapeBox(-2F, -2F, 17.5F, 12, 2, 3, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 3F, 0F, 0F, 0F); // Box 7
        snowplow[7].setRotationPoint(58F, -5F, 0F);

        snowplow[8].addShapeBox(-2F, -3F, -20.5F, 9, 2, 3, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, -3F, 0F, 0F, 0F); // Box 8
        snowplow[8].setRotationPoint(58F, -5F, 0F);

        snowplow[9].addShapeBox(12F, -8F, 21.5F, 1, 2, 4, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 10
        snowplow[9].setRotationPoint(58F, -5F, 0F);

        snowplow[10].addShapeBox(8F, -8F, -24.5F, 1, 2, 4, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 11
        snowplow[10].setRotationPoint(58F, -5F, 0F);

        snowplow[11].addShapeBox(13F, -8F, 21.5F, 1, 2, 4, 0F, 0F, -0.2F, -0.2F, -0.8F, -0.45F, -0.45F, -0.8F, -0.45F, -0.45F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, -0.8F, -0.45F, -0.45F, -0.8F, -0.45F, -0.45F, 0F, -0.2F, -0.2F); // Box 12
        snowplow[11].setRotationPoint(58F, -5F, 0F);

        snowplow[12].addShapeBox(9F, -8F, -24.5F, 1, 2, 4, 0F, 0F, -0.2F, -0.2F, -0.8F, -0.45F, -0.45F, -0.8F, -0.45F, -0.45F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, -0.8F, -0.45F, -0.45F, -0.8F, -0.45F, -0.45F, 0F, -0.2F, -0.2F); // Box 13
        snowplow[12].setRotationPoint(58F, -5F, 0F);

        translateAll(0F, 0F, 0F);

    }

    @Override
    public void render(VehicleData data, String usedAS){
        super.render(data, usedAS);
        rotate(snowplow, 0, 0, -Static.rad20, true);
        render(snowplow);
    }

    @Override
    public void render(VehicleData data, String us, Entity vehicle, int meta){
        render(body);
        T1SnowPlowScript sps = data.getScript(T1SnowPlowScript.class);
        rotate(snowplow, 0, 0, sps == null ? 0 : sps.on ? 0 : -Static.rad20, true);
        render(snowplow);
    }

}
