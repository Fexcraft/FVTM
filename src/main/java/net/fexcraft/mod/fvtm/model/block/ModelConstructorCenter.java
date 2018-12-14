package net.fexcraft.mod.fvtm.model.block;

import net.fexcraft.lib.tmt.ModelConverter;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.FVTM;
import net.minecraft.util.ResourceLocation;

/**
 * @author Ferdinand (FEX___96)
 *
 */
public class ModelConstructorCenter extends ModelConverter {

    int textureX = 256;
    int textureY = 256;

    public ModelConstructorCenter(){

        bodyModel = new ModelRendererTurbo[6];
        bodyModel[0] = new ModelRendererTurbo(this, 113, 1, textureX, textureY); // Box 21
        bodyModel[1] = new ModelRendererTurbo(this, 145, 1, textureX, textureY); // Box 22
        bodyModel[2] = new ModelRendererTurbo(this, 153, 1, textureX, textureY); // Box 23
        bodyModel[3] = new ModelRendererTurbo(this, 161, 1, textureX, textureY); // Box 24
        bodyModel[4] = new ModelRendererTurbo(this, 177, 1, textureX, textureY); // Box 25
        bodyModel[5] = new ModelRendererTurbo(this, 193, 1, textureX, textureY); // Box 26

        bodyModel[0].addShapeBox(0F, 0F, 0F, 12, 16, 1, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 21
        bodyModel[0].setRotationPoint(-6F, -16F, 6F);

        bodyModel[1].addBox(0F, 0F, 0F, 2, 16, 1, 0F); // Box 22
        bodyModel[1].setRotationPoint(-6F, -16F, 7F);

        bodyModel[2].addBox(0F, 0F, 0F, 2, 16, 1, 0F); // Box 23
        bodyModel[2].setRotationPoint(4F, -16F, 7F);

        bodyModel[3].addShapeBox(0F, 0F, 0F, 3, 16, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, 0F); // Box 24
        bodyModel[3].setRotationPoint(-4F, -16F, 7F);

        bodyModel[4].addShapeBox(0F, 0F, 0F, 3, 16, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F); // Box 25
        bodyModel[4].setRotationPoint(1F, -16F, 7F);

        bodyModel[5].addShapeBox(0F, 0F, 0F, 2, 16, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F); // Box 26
        bodyModel[5].setRotationPoint(-1F, -16F, 7F);

        turretModel = new ModelRendererTurbo[5];
        turretModel[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
        turretModel[1] = new ModelRendererTurbo(this, 1, 9, textureX, textureY); // Box 1
        turretModel[2] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 2
        turretModel[3] = new ModelRendererTurbo(this, 1, 33, textureX, textureY); // Box 3
        turretModel[4] = new ModelRendererTurbo(this, 1, 41, textureX, textureY); // Box 4

        turretModel[0].addBox(0F, 0F, 0F, 16, 1, 1, 0F); // Box 0
        turretModel[0].setRotationPoint(-8F, -1F, -3F);

        turretModel[1].addBox(0F, 0F, 0F, 16, 1, 1, 0F); // Box 1
        turretModel[1].setRotationPoint(-8F, -1F, 2F);

        turretModel[2].addShapeBox(0F, 0F, 0F, 16, 1, 8, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 2
        turretModel[2].setRotationPoint(-8F, -2F, -4F);

        turretModel[3].addShapeBox(0F, 0.5F, 0F, 16, 1, 1, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 3
        turretModel[3].setRotationPoint(-8F, -3F, -4F);

        turretModel[4].addShapeBox(0F, 0.5F, 0F, 16, 1, 1, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 4
        turretModel[4].setRotationPoint(-8F, -3F, 3F);

        trailerModel = new ModelRendererTurbo[3];
        trailerModel[0] = new ModelRendererTurbo(this, 25, 1, textureX, textureY); // Box 18
        trailerModel[1] = new ModelRendererTurbo(this, 57, 1, textureX, textureY); // Box 19
        trailerModel[2] = new ModelRendererTurbo(this, 81, 1, textureX, textureY); // Box 20

        trailerModel[0].addShapeBox(0F, 0F, 0F, 3, 1, 12, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 18
        trailerModel[0].setRotationPoint(2F, -0.5F, -6F);

        trailerModel[1].addShapeBox(0F, 0F, 0F, 3, 1, 12, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 19
        trailerModel[1].setRotationPoint(-5F, -0.5F, -6F);

        trailerModel[2].addBox(0F, 0F, 0F, 4, 1, 8, 0F); // Box 20
        trailerModel[2].setRotationPoint(-2F, -0.5F, -6F);

        translate(0F, 24F, 0F);

        //flipAll();
    }

    private static final ResourceLocation texture = new ResourceLocation(FVTM.MODID, "textures/blocks/constructioncenter.png");

    public static final ResourceLocation getTexture(){
        return texture;
    }

}
