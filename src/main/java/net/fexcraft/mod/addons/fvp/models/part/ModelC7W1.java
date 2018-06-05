package net.fexcraft.mod.addons.fvp.models.part;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.part.PartModel;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.minecraft.entity.Entity;

public class ModelC7W1 extends PartModel {

    public ModelC7W1(){
    	super(); textureX = 512; textureY = 512;
        this.addToCreators("Ferdinand (FEX___96)");
        wheel_front_left = new ModelRendererTurbo[9];
        wheel_front_left[0] = new ModelRendererTurbo(this, 209, 41, textureX, textureY); // Box 110
        wheel_front_left[1] = new ModelRendererTurbo(this, 1, 57, textureX, textureY); // Box 111
        wheel_front_left[2] = new ModelRendererTurbo(this, 497, 41, textureX, textureY); // Box 112
        wheel_front_left[3] = new ModelRendererTurbo(this, 105, 57, textureX, textureY); // Box 113
        wheel_front_left[4] = new ModelRendererTurbo(this, 145, 57, textureX, textureY); // Box 114
        wheel_front_left[5] = new ModelRendererTurbo(this, 177, 57, textureX, textureY); // Box 115
        wheel_front_left[6] = new ModelRendererTurbo(this, 193, 57, textureX, textureY); // Box 116
        wheel_front_left[7] = new ModelRendererTurbo(this, 209, 57, textureX, textureY); // Box 117
        wheel_front_left[8] = new ModelRendererTurbo(this, 481, 57, textureX, textureY); // Box 118

        wheel_front_left[0].addBox(-2F, -6F, -1F, 4, 2, 4, 0F); // Box 110
        wheel_front_left[0].setRotationPoint(31.5F, -3.5F, 14F);

        wheel_front_left[1].addBox(-2F, 4F, -1F, 4, 2, 4, 0F); // Box 111
        wheel_front_left[1].setRotationPoint(31.5F, -3.5F, 14F);

        wheel_front_left[2].addBox(4F, -2F, -1F, 2, 4, 4, 0F); // Box 112
        wheel_front_left[2].setRotationPoint(31.5F, -3.5F, 14F);

        wheel_front_left[3].addBox(-6F, -2F, -1F, 2, 4, 4, 0F); // Box 113
        wheel_front_left[3].setRotationPoint(31.5F, -3.5F, 14F);

        wheel_front_left[4].addShapeBox(-6F, -6F, -1F, 2, 4, 4, 0F, -4F, 0F, 0F, 2F, -2F, 0F, 2F, -2F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 114
        wheel_front_left[4].setRotationPoint(31.5F, -3.5F, 14F);

        wheel_front_left[5].addShapeBox(-6F, 2F, -1F, 2, 4, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 2F, -2F, 0F, 2F, -2F, 0F, -4F, 0F, 0F); // Box 115
        wheel_front_left[5].setRotationPoint(31.5F, -3.5F, 14F);

        wheel_front_left[6].addShapeBox(4F, 2F, -1F, 2, 4, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, -2F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 2F, -2F, 0F); // Box 116
        wheel_front_left[6].setRotationPoint(31.5F, -3.5F, 14F);

        wheel_front_left[7].addShapeBox(4F, -6F, -1F, 2, 4, 4, 0F, 2F, -2F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 2F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 117
        wheel_front_left[7].setRotationPoint(31.5F, -3.5F, 14F);

        wheel_front_left[8].addBox(-4F, -4F, 0F, 8, 8, 2, 0F); // Box 118
        wheel_front_left[8].setRotationPoint(31.5F, -3.5F, 14F);

        wheel_front_right = new ModelRendererTurbo[9];
        wheel_front_right[0] = new ModelRendererTurbo(this, 1, 89, textureX, textureY); // Box 183
        wheel_front_right[1] = new ModelRendererTurbo(this, 1, 97, textureX, textureY); // Box 184
        wheel_front_right[2] = new ModelRendererTurbo(this, 177, 97, textureX, textureY); // Box 185
        wheel_front_right[3] = new ModelRendererTurbo(this, 209, 97, textureX, textureY); // Box 186
        wheel_front_right[4] = new ModelRendererTurbo(this, 225, 97, textureX, textureY); // Box 187
        wheel_front_right[5] = new ModelRendererTurbo(this, 337, 97, textureX, textureY); // Box 188
        wheel_front_right[6] = new ModelRendererTurbo(this, 353, 97, textureX, textureY); // Box 189
        wheel_front_right[7] = new ModelRendererTurbo(this, 385, 97, textureX, textureY); // Box 190
        wheel_front_right[8] = new ModelRendererTurbo(this, 1, 105, textureX, textureY); // Box 191

        wheel_front_right[0].addBox(-2F, 4F, -1F, 4, 2, 4, 0F); // Box 183
        wheel_front_right[0].setRotationPoint(31.5F, -3.5F, -16F);

        wheel_front_right[1].addBox(-2F, -6F, -1F, 4, 2, 4, 0F); // Box 184
        wheel_front_right[1].setRotationPoint(31.5F, -3.5F, -16F);

        wheel_front_right[2].addShapeBox(-6F, 2F, -1F, 2, 4, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 2F, -2F, 0F, 2F, -2F, 0F, -4F, 0F, 0F); // Box 185
        wheel_front_right[2].setRotationPoint(31.5F, -3.5F, -16F);

        wheel_front_right[3].addShapeBox(4F, 2F, -1F, 2, 4, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, -2F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 2F, -2F, 0F); // Box 186
        wheel_front_right[3].setRotationPoint(31.5F, -3.5F, -16F);

        wheel_front_right[4].addBox(-6F, -2F, -1F, 2, 4, 4, 0F); // Box 187
        wheel_front_right[4].setRotationPoint(31.5F, -3.5F, -16F);

        wheel_front_right[5].addBox(4F, -2F, -1F, 2, 4, 4, 0F); // Box 188
        wheel_front_right[5].setRotationPoint(31.5F, -3.5F, -16F);

        wheel_front_right[6].addShapeBox(4F, -6F, -1F, 2, 4, 4, 0F, 2F, -2F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 2F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 189
        wheel_front_right[6].setRotationPoint(31.5F, -3.5F, -16F);

        wheel_front_right[7].addShapeBox(-6F, -6F, -1F, 2, 4, 4, 0F, -4F, 0F, 0F, 2F, -2F, 0F, 2F, -2F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 190
        wheel_front_right[7].setRotationPoint(31.5F, -3.5F, -16F);

        wheel_front_right[8].addBox(-4F, -4F, 0F, 8, 8, 2, 0F); // Box 191
        wheel_front_right[8].setRotationPoint(31.5F, -3.5F, -16F);

        wheel_back_left = new ModelRendererTurbo[9];
        wheel_back_left[0] = new ModelRendererTurbo(this, 137, 105, textureX, textureY); // Box 192
        wheel_back_left[1] = new ModelRendererTurbo(this, 489, 97, textureX, textureY); // Box 193
        wheel_back_left[2] = new ModelRendererTurbo(this, 265, 105, textureX, textureY); // Box 194
        wheel_back_left[3] = new ModelRendererTurbo(this, 401, 105, textureX, textureY); // Box 195
        wheel_back_left[4] = new ModelRendererTurbo(this, 417, 105, textureX, textureY); // Box 196
        wheel_back_left[5] = new ModelRendererTurbo(this, 281, 105, textureX, textureY); // Box 197
        wheel_back_left[6] = new ModelRendererTurbo(this, 433, 105, textureX, textureY); // Box 198
        wheel_back_left[7] = new ModelRendererTurbo(this, 385, 113, textureX, textureY); // Box 199
        wheel_back_left[8] = new ModelRendererTurbo(this, 449, 113, textureX, textureY); // Box 200

        wheel_back_left[0].addBox(-4F, -4F, 0F, 8, 8, 2, 0F); // Box 192
        wheel_back_left[0].setRotationPoint(-31.5F, -3.5F, 14F);

        wheel_back_left[1].addBox(-2F, -6F, -1F, 4, 2, 4, 0F); // Box 193
        wheel_back_left[1].setRotationPoint(-31.5F, -3.5F, 14F);

        wheel_back_left[2].addShapeBox(4F, -6F, -1F, 2, 4, 4, 0F, 2F, -2F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 2F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 194
        wheel_back_left[2].setRotationPoint(-31.5F, -3.5F, 14F);

        wheel_back_left[3].addBox(4F, -2F, -1F, 2, 4, 4, 0F); // Box 195
        wheel_back_left[3].setRotationPoint(-31.5F, -3.5F, 14F);

        wheel_back_left[4].addShapeBox(4F, 2F, -1F, 2, 4, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, -2F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 2F, -2F, 0F); // Box 196
        wheel_back_left[4].setRotationPoint(-31.5F, -3.5F, 14F);

        wheel_back_left[5].addBox(-2F, 4F, -1F, 4, 2, 4, 0F); // Box 197
        wheel_back_left[5].setRotationPoint(-31.5F, -3.5F, 14F);

        wheel_back_left[6].addShapeBox(-6F, 2F, -1F, 2, 4, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 2F, -2F, 0F, 2F, -2F, 0F, -4F, 0F, 0F); // Box 198
        wheel_back_left[6].setRotationPoint(-31.5F, -3.5F, 14F);

        wheel_back_left[7].addBox(-6F, -2F, -1F, 2, 4, 4, 0F); // Box 199
        wheel_back_left[7].setRotationPoint(-31.5F, -3.5F, 14F);

        wheel_back_left[8].addShapeBox(-6F, -6F, -1F, 2, 4, 4, 0F, -4F, 0F, 0F, 2F, -2F, 0F, 2F, -2F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 200
        wheel_back_left[8].setRotationPoint(-31.5F, -3.5F, 14F);

        wheel_back_right = new ModelRendererTurbo[9];
        wheel_back_right[0] = new ModelRendererTurbo(this, 465, 113, textureX, textureY); // Box 201
        wheel_back_right[1] = new ModelRendererTurbo(this, 489, 113, textureX, textureY); // Box 202
        wheel_back_right[2] = new ModelRendererTurbo(this, 161, 121, textureX, textureY); // Box 203
        wheel_back_right[3] = new ModelRendererTurbo(this, 177, 121, textureX, textureY); // Box 204
        wheel_back_right[4] = new ModelRendererTurbo(this, 201, 121, textureX, textureY); // Box 205
        wheel_back_right[5] = new ModelRendererTurbo(this, 289, 121, textureX, textureY); // Box 206
        wheel_back_right[6] = new ModelRendererTurbo(this, 217, 121, textureX, textureY); // Box 207
        wheel_back_right[7] = new ModelRendererTurbo(this, 305, 121, textureX, textureY); // Box 208
        wheel_back_right[8] = new ModelRendererTurbo(this, 321, 121, textureX, textureY); // Box 209

        wheel_back_right[0].addBox(-2F, -6F, -1F, 4, 2, 4, 0F); // Box 201
        wheel_back_right[0].setRotationPoint(-31.5F, -3.5F, -16F);

        wheel_back_right[1].addShapeBox(4F, 2F, -1F, 2, 4, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, -2F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 2F, -2F, 0F); // Box 202
        wheel_back_right[1].setRotationPoint(-31.5F, -3.5F, -16F);

        wheel_back_right[2].addShapeBox(4F, -6F, -1F, 2, 4, 4, 0F, 2F, -2F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 2F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 203
        wheel_back_right[2].setRotationPoint(-31.5F, -3.5F, -16F);

        wheel_back_right[3].addBox(-4F, -4F, 0F, 8, 8, 2, 0F); // Box 204
        wheel_back_right[3].setRotationPoint(-31.5F, -3.5F, -16F);

        wheel_back_right[4].addShapeBox(-6F, 2F, -1F, 2, 4, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 0F, 2F, -2F, 0F, 2F, -2F, 0F, -4F, 0F, 0F); // Box 205
        wheel_back_right[4].setRotationPoint(-31.5F, -3.5F, -16F);

        wheel_back_right[5].addBox(4F, -2F, -1F, 2, 4, 4, 0F); // Box 206
        wheel_back_right[5].setRotationPoint(-31.5F, -3.5F, -16F);

        wheel_back_right[6].addBox(-2F, 4F, -1F, 4, 2, 4, 0F); // Box 207
        wheel_back_right[6].setRotationPoint(-31.5F, -3.5F, -16F);

        wheel_back_right[7].addShapeBox(-6F, -6F, -1F, 2, 4, 4, 0F, -4F, 0F, 0F, 2F, -2F, 0F, 2F, -2F, 0F, -4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 208
        wheel_back_right[7].setRotationPoint(-31.5F, -3.5F, -16F);

        wheel_back_right[8].addBox(-6F, -2F, -1F, 2, 4, 4, 0F); // Box 209
        wheel_back_right[8].setRotationPoint(-31.5F, -3.5F, -16F);

    }

    @Override
    public void render(VehicleData data, String us){
        super.def_renderWheels4(data, us);
    }

    @Override
    public void render(VehicleData data, String us, Entity vehicle, int meta){
        super.def_renderWheels4(data, us, vehicle);
    }

}
