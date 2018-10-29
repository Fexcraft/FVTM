package net.fexcraft.mod.addons.zmp.models.part;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.part.PartModelTMT;

public class ModelCargoShipSteeringWheel extends PartModelTMT {


    public ModelCargoShipSteeringWheel(){
    	super(); textureX = 4096; textureY = 4096;
        this.addToCreators("643a5fd6-f325-442f-9ea8-6445dbb0cdc9");
        this.addToCreators("01e4af9b-2a30-471e-addf-f6338ffce04b");
        steering = new ModelRendererTurbo[8];
        steering[0] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 229
        steering[1] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 230
        steering[2] = new ModelRendererTurbo(this, 201, 1, textureX, textureY); // Box 231
        steering[3] = new ModelRendererTurbo(this, 225, 1, textureX, textureY); // Box 232
        steering[4] = new ModelRendererTurbo(this, 313, 1, textureX, textureY); // Box 233
        steering[5] = new ModelRendererTurbo(this, 337, 1, textureX, textureY); // Box 234
        steering[6] = new ModelRendererTurbo(this, 353, 1, textureX, textureY); // Box 235
        steering[7] = new ModelRendererTurbo(this, 377, 1, textureX, textureY); // Box 236

        steering[0].addBox(0F, -4.5F, -0.5F, 1, 9, 1, 0F); // Box 229
        steering[0].setRotationPoint(-517F, -215.5F, 0.5F);

        steering[1].addShapeBox(0F, -0.5F, -0.5F, 2, 1, 1, 0F, 0F, 0F, 0F, 0F, 0.5F, 0.5F, 0F, 0.5F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0.5F, 0F, 0.5F, 0.5F, 0F, 0F, 0F); // Box 230
        steering[1].setRotationPoint(-516F, -215.5F, 0.5F);

        steering[2].addBox(0F, -0.5F, -4.5F, 1, 1, 4, 0F); // Box 231
        steering[2].setRotationPoint(-517F, -215.5F, 0.5F);

        steering[3].addBox(0F, -0.5F, 0.5F, 1, 1, 4, 0F); // Box 232
        steering[3].setRotationPoint(-517F, -215.5F, 0.5F);

        steering[4].addShapeBox(0F, 0.5F, 0.5F, 1, 1, 4, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 233
        steering[4].setRotationPoint(-517F, -215.5F, 0.5F);

        steering[5].addShapeBox(0F, 0.5F, -4.5F, 1, 1, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, 3F, 0F); // Box 234
        steering[5].setRotationPoint(-517F, -215.5F, 0.5F);

        steering[6].addShapeBox(0F, -1.5F, -4.5F, 1, 1, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F); // Box 235
        steering[6].setRotationPoint(-517F, -215.5F, 0.5F);

        steering[7].addShapeBox(0F, -1.5F, 0.5F, 1, 1, 4, 0F, 0F, 3F, 0F, 0F, 3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, 0F, 0F, -3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 236
        steering[7].setRotationPoint(-517F, -215.5F, 0.5F);
        //
        //translateAll(0F, 0F, 0F);
        flipAll();
    }

}
