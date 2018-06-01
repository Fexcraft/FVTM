package net.fexcraft.mod.addons.hcp.models.part;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.part.PartModel;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.minecraft.entity.Entity;

/**
 *
 * @author Ferdinand (FEX___96)
 */
public class TR1ContainerHolder extends PartModel<VehicleData> {

    int textureX = 512;
    int textureY = 512;

    public TR1ContainerHolder(){
        this.creators.add("FEX___96");
		body = new ModelRendererTurbo[21];
		body[0] = new ModelRendererTurbo(this, 409, 185, textureX, textureY); // Box 131
		body[1] = new ModelRendererTurbo(this, 449, 185, textureX, textureY); // Box 132
		body[2] = new ModelRendererTurbo(this, 145, 217, textureX, textureY); // Box 133
		body[3] = new ModelRendererTurbo(this, 185, 217, textureX, textureY); // Box 134
		body[4] = new ModelRendererTurbo(this, 401, 209, textureX, textureY); // Box 135
		body[5] = new ModelRendererTurbo(this, 441, 209, textureX, textureY); // Box 136
		body[6] = new ModelRendererTurbo(this, 225, 217, textureX, textureY); // Box 137
		body[7] = new ModelRendererTurbo(this, 265, 217, textureX, textureY); // Box 138
		body[8] = new ModelRendererTurbo(this, 401, 161, textureX, textureY); // Box 139
		body[9] = new ModelRendererTurbo(this, 145, 185, textureX, textureY); // Box 140
		body[10] = new ModelRendererTurbo(this, 169, 185, textureX, textureY); // Box 141
		body[11] = new ModelRendererTurbo(this, 257, 185, textureX, textureY); // Box 142
		body[12] = new ModelRendererTurbo(this, 369, 193, textureX, textureY); // Box 143
		body[13] = new ModelRendererTurbo(this, 497, 89, textureX, textureY); // Box 144
		body[14] = new ModelRendererTurbo(this, 489, 193, textureX, textureY); // Box 145
		body[15] = new ModelRendererTurbo(this, 497, 97, textureX, textureY); // Box 146
		body[16] = new ModelRendererTurbo(this, 489, 201, textureX, textureY); // Box 147
		body[17] = new ModelRendererTurbo(this, 25, 217, textureX, textureY); // Box 148
		body[18] = new ModelRendererTurbo(this, 1, 241, textureX, textureY); // Box 149
		body[19] = new ModelRendererTurbo(this, 249, 289, textureX, textureY); // Box 150
		body[20] = new ModelRendererTurbo(this, 345, 289, textureX, textureY); // Box 151

		body[0].addBox(0F, 0F, 0F, 4, 4, 8, 0F); // Box 131
		body[0].setRotationPoint(-16F, -28F, -25F);

		body[1].addBox(0F, 0F, 0F, 4, 4, 8, 0F); // Box 132
		body[1].setRotationPoint(-16F, -28F, 17F);

		body[2].addShapeBox(0F, 0F, 0F, 8, 4, 8, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 133
		body[2].setRotationPoint(-12F, -28F, -25F);

		body[3].addShapeBox(0F, 0F, 0F, 8, 4, 8, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 134
		body[3].setRotationPoint(-12F, -28F, 17F);

		body[4].addBox(0F, 0F, 0F, 4, 4, 8, 0F); // Box 135
		body[4].setRotationPoint(-212F, -28F, -25F);

		body[5].addBox(0F, 0F, 0F, 4, 4, 8, 0F); // Box 136
		body[5].setRotationPoint(-212F, -28F, 17F);

		body[6].addShapeBox(0F, 0F, 0F, 8, 4, 8, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 137
		body[6].setRotationPoint(-220F, -28F, -25F);

		body[7].addShapeBox(0F, 0F, 0F, 8, 4, 8, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 138
		body[7].setRotationPoint(-220F, -28F, 17F);

		body[8].addShapeBox(0F, 0F, 0F, 8, 4, 1, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 139
		body[8].setRotationPoint(-24F, -28F, -25F);

		body[9].addShapeBox(0F, 0F, 0F, 8, 4, 1, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 140
		body[9].setRotationPoint(-24F, -28F, 24F);

		body[10].addShapeBox(0F, 0F, 0F, 8, 4, 1, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 141
		body[10].setRotationPoint(-208F, -28F, 24F);

		body[11].addShapeBox(0F, 0F, 0F, 8, 4, 1, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 142
		body[11].setRotationPoint(-208F, -28F, -25F);

		body[12].addShapeBox(0F, 0F, 0F, 8, 4, 1, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 143
		body[12].setRotationPoint(-110F, -28F, -25F);

		body[13].addShapeBox(0F, 0F, 0F, 4, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 144
		body[13].setRotationPoint(-114F, -28F, -25F);

		body[14].addShapeBox(0F, 0F, 0F, 8, 4, 1, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 145
		body[14].setRotationPoint(-122F, -28F, -25F);

		body[15].addShapeBox(0F, 0F, 0F, 4, 4, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F); // Box 146
		body[15].setRotationPoint(-114F, -28F, 24F);

		body[16].addShapeBox(0F, 0F, 0F, 8, 4, 1, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 147
		body[16].setRotationPoint(-110F, -28F, 24F);

		body[17].addShapeBox(0F, 0F, 0F, 8, 4, 1, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 148
		body[17].setRotationPoint(-122F, -28F, 24F);

		body[18].addBox(0F, 0F, 0F, 20, 4, 50, 0F); // Box 149
		body[18].setRotationPoint(-2F, -28F, -25F);

		body[19].addShapeBox(0F, 0F, 0F, 20, 2, 50, 0F, -2F, 0F, -2F, -2F, 0F, -2F, -2F, 0F, -2F, -2F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 150
		body[19].setRotationPoint(-2F, -30F, -25F);

		body[20].addBox(0F, 0F, 0F, 18, 1, 48, 0F); // Box 151
		body[20].setRotationPoint(-1F, -31F, -24F);
    }
    
        @Override
    public void render(VehicleData data, String us){
        render(body);
        super.def_renderContainer(data, us);
    }

    @Override
    public void render(VehicleData data, String us, Entity ent){
        render(body);
        super.def_renderContainer(data, us, ent);
    }

}
