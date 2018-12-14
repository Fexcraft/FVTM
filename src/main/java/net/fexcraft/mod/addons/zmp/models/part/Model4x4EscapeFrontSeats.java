package net.fexcraft.mod.addons.zmp.models.part;

import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.part.PartModel;

public class Model4x4EscapeFrontSeats extends PartModel {

    public Model4x4EscapeFrontSeats(){
    	super(); textureX = 512; textureY = 512;
        this.addToCreators("zackyboy18"); this.addToCreators("FEX___96");
        ModelRendererTurbo[] body = new ModelRendererTurbo[10];
        body[0] = new ModelRendererTurbo(this, 465, 97, textureX, textureY); // Box 256
        body[1] = new ModelRendererTurbo(this, 1, 105, textureX, textureY); // Box 257
        body[2] = new ModelRendererTurbo(this, 81, 1, textureX, textureY); // Box 258
        body[3] = new ModelRendererTurbo(this, 105, 1, textureX, textureY); // Box 260
        body[4] = new ModelRendererTurbo(this, 137, 65, textureX, textureY); // Box 261
        body[5] = new ModelRendererTurbo(this, 337, 105, textureX, textureY); // Box 262
        body[6] = new ModelRendererTurbo(this, 377, 105, textureX, textureY); // Box 263
        body[7] = new ModelRendererTurbo(this, 273, 33, textureX, textureY); // Box 520
        body[8] = new ModelRendererTurbo(this, 337, 33, textureX, textureY); // Box 521
        body[9] = new ModelRendererTurbo(this, 305, 137, textureX, textureY); // Box 522
        body[0].addBox(0F, 0F, 0F, 8, 2, 10, 0F); // Box 256
        body[0].setRotationPoint(9F, 4F, 4F);
        body[1].addBox(0F, 0F, 0F, 12, 1, 10, 0F); // Box 257
        body[1].setRotationPoint(9F, 4F, 4F);
        body[1].rotationAngleZ = Static.toDegrees(1.8675023F);
        body[2].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 258
        body[2].setRotationPoint(5.5F, -9F, 6F);
        body[3].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 260
        body[3].setRotationPoint(5.5F, -9F, 11F);
        body[4].addBox(0F, 0F, 0F, 1, 3, 8, 0F); // Box 261
        body[4].setRotationPoint(5.5F, -11.5F, 5F);
        body[5].addBox(0F, 0F, 0F, 8, 2, 10, 0F); // Box 262
        body[5].setRotationPoint(9F, 4F, -15F);
        body[6].addBox(0F, 0F, 0F, 12, 1, 10, 0F); // Box 263
        body[6].setRotationPoint(9F, 4F, -15F);
        body[6].rotationAngleZ = Static.toDegrees(1.8675023F);
        body[7].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 520
        body[7].setRotationPoint(5.5F, -9F, -13F);
        body[8].addBox(0F, 0F, 0F, 1, 2, 1, 0F); // Box 521
        body[8].setRotationPoint(5.5F, -9F, -8F);
        body[9].addBox(0F, 0F, 0F, 1, 3, 8, 0F); // Box 522
        body[9].setRotationPoint(5.5F, -11.5F, -14F);
        this.add("body", body);
        //
        translate(0F, -12F, 0F); fixRotations();
    }

}