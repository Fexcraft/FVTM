package net.fexcraft.mod.addons.fvp.models.part;

import net.fexcraft.mod.addons.gep.scripts.MultiDoorScript;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.part.PartModelTMT;
import net.fexcraft.mod.lib.tmt.Coord2D;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.tmt.Shape2D;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.entity.Entity;

public class ModelT2Doors extends PartModelTMT {
	
    public ModelRendererTurbo[] front_right;
    public ModelRendererTurbo[] front_left;
    private static final float rad80 = Static.rad60 + Static.rad20;

    public ModelT2Doors(){
    	super(); textureX = 512; textureY = 512;
        this.addToCreators("Ferdinand (FEX___96)");
        //
        front_left = new ModelRendererTurbo[6];
        front_left[0] = new ModelRendererTurbo(this, 425, 89, textureX, textureY); // Box 230
        front_left[1] = new ModelRendererTurbo(this, 209, 49, textureX, textureY); // Box 231
        front_left[2] = new ModelRendererTurbo(this, 233, 57, textureX, textureY); // Box 232
        front_left[3] = new ModelRendererTurbo(this, 1, 129, textureX, textureY); // Box 233
        front_left[4] = new ModelRendererTurbo(this, 44, 426, textureX, textureY); // Shape 234
        front_left[5] = new ModelRendererTurbo(this, 1, 97, textureX, textureY); // Box 333
        //front_left[6] = new ModelRendererTurbo(this, 289, 361, textureX, textureY); // Box 243
        front_left[0].addShapeBox(-26F, -20F, -1F, 3, 20, 2, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 230
        front_left[0].setRotationPoint(64F, -32F, 25F);
        front_left[1].addShapeBox(-2F, -10F, -1F, 2, 10, 2, 0F, 0.25F, 0F, 0.25F, -0.25F, 0F, 0.25F, -0.25F, 0F, -0.25F, 0.25F, 0F, -0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 231
        front_left[1].setRotationPoint(64F, -32F, 25F);
        front_left[2].addShapeBox(-2F, -20F, -1F, 2, 10, 2, 0F, 2F, 0F, 0.5F, -2F, 0F, 0.5F, -2F, 0F, -0.5F, 2F, 0F, -0.5F, 0.25F, 0F, 0.25F, -0.25F, 0F, 0.25F, -0.25F, 0F, -0.25F, 0.25F, 0F, -0.25F); // Box 232
        front_left[2].setRotationPoint(64F, -32F, 25F);
        front_left[3].addShapeBox(-23F, -20F, -1F, 19, 2, 2, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0.45F, 0.4F, 0F, 0.45F, 0.4F, 0F, -0.45F, 0F, 0F, -0.45F); // Box 233
        front_left[3].setRotationPoint(64F, -32F, 25F);
        front_left[4].addShape3D(0F, -13F, -1F, new Shape2D(new Coord2D[]{new Coord2D(0, 0, 0, 0), new Coord2D(13, 0, 13, 0), new Coord2D(25, 13, 25, 13), new Coord2D(0, 13, 0, 13)}), 2, 25, 13, 69, 2, ModelRendererTurbo.MR_FRONT, new float[]{13, 25, 18, 13}); // Shape 234
        front_left[4].setRotationPoint(64F, -32F, 25F);
        front_left[4].rotateAngleZ = Static.rad180;
        front_left[5].addBox(-16F, 2F, -1.5F, 3, 1, 3, 0F); // Box 333
        front_left[5].setRotationPoint(64F, -32F, 25F);
        //front_left[6].addShapeBox(-23F, -18F, -0.5F, 21, 18, 1, 0F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, -0.9F, 0F, 0F, -0.9F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F); // Box 243
        //front_left[6].setRotationPoint(64F, -32F, 25F);
        //
        front_right = new ModelRendererTurbo[6];
        front_right[0] = new ModelRendererTurbo(this, 1, 73, textureX, textureY); // Box 235
        front_right[1] = new ModelRendererTurbo(this, 65, 73, textureX, textureY); // Box 236
        front_right[2] = new ModelRendererTurbo(this, 241, 185, textureX, textureY); // Box 237
        front_right[3] = new ModelRendererTurbo(this, 329, 129, textureX, textureY); // Box 238
        front_right[4] = new ModelRendererTurbo(this, 44, 426, textureX, textureY); // Shape 239
        front_right[5] = new ModelRendererTurbo(this, 241, 97, textureX, textureY); // Box 334
        //front_right[6] = new ModelRendererTurbo(this, 233, 361, textureX, textureY); // Box 242
        front_right[0].addShapeBox(-2F, -10F, -1F, 2, 10, 2, 0F, 0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, 0.25F, 0.25F, 0F, 0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 235
        front_right[0].setRotationPoint(64F, -32F, -25F);
        front_right[1].addShapeBox(-2F, -20F, -1F, 2, 10, 2, 0F, 2F, 0F, -0.5F, -2F, 0F, -0.5F, -2F, 0F, 0.5F, 2F, 0F, 0.5F, 0.25F, 0F, -0.25F, -0.25F, 0F, -0.25F, -0.25F, 0F, 0.25F, 0.25F, 0F, 0.25F); // Box 236
        front_right[1].setRotationPoint(64F, -32F, -25F);
        front_right[2].addShapeBox(-23F, -20F, -1F, 19, 2, 2, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, -0.45F, 0.4F, 0F, -0.45F, 0.4F, 0F, 0.45F, 0F, 0F, 0.45F); // Box 237
        front_right[2].setRotationPoint(64F, -32F, -25F);
        front_right[3].addShapeBox(-26F, -20F, -1F, 3, 20, 2, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 238
        front_right[3].setRotationPoint(64F, -32F, -25F);
        front_right[4].addShape3D(0F, -13F, -1F, new Shape2D(new Coord2D[]{new Coord2D(0, 0, 0, 0), new Coord2D(13, 0, 13, 0), new Coord2D(25, 13, 25, 13), new Coord2D(0, 13, 0, 13)}), 2, 25, 13, 69, 2, ModelRendererTurbo.MR_FRONT, new float[]{13, 25, 18, 13}); // Shape 239
        front_right[4].setRotationPoint(64F, -32F, -25F);
        front_right[4].rotateAngleZ = Static.rad180;
        front_right[5].addBox(-16F, 2F, -1.5F, 3, 1, 3, 0F); // Box 334
        front_right[5].setRotationPoint(64F, -32F, -25F);
        //front_right[6].addShapeBox(-23F, -18F, -0.5F, 21, 18, 1, 0F, 0F, 0F, -0.9F, 0F, 0F, -0.9F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F); // Box 242
        //front_right[6].setRotationPoint(64F, -32F, -25F);
        //
        flipAll();
    }

    @Override
    public void render(VehicleData data, String us){
        data.getPrimaryColor().glColorApply();
        rotate(this.front_left, 0, 0, 0, true);
        front_left[4].rotateAngleZ = Static.rad180;
        render(this.front_left);
        rotate(this.front_right, 0, 0, 0, true);
        front_right[4].rotateAngleZ = Static.rad180;
        render(this.front_right);
        RGB.glColorReset();
    }

    @Override
    public void render(VehicleData data, String us, Entity vehicle, int meta){
        MultiDoorScript script = data.getScript(MultiDoorScript.class);
        if(script == null){
            data.getPrimaryColor().glColorApply();
            rotate(this.front_left, 0, data.doorsOpen() ? rad80 : 0, 0, true);
            front_left[4].rotateAngleZ = Static.rad180;
            render(this.front_left);
            rotate(this.front_right, 0, data.doorsOpen() ? -rad80 : 0, 0, true);
            front_right[4].rotateAngleZ = Static.rad180;
            render(this.front_right);
            RGB.glColorReset();
        }
        else{
            data.getPrimaryColor().glColorApply();
            rotate(this.front_left, 0, script.front_left ? rad80 : 0, 0, true);
            front_left[4].rotateAngleZ = Static.rad180;
            render(this.front_left);
            rotate(this.front_right, 0, script.front_right ? -rad80 : 0, 0, true);
            front_right[4].rotateAngleZ = Static.rad180;
            render(this.front_right);
            RGB.glColorReset();
        }
    }

}
