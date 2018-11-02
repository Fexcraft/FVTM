package net.fexcraft.mod.addons.fvp.models.part;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.addons.gep.scripts.MultiDoorScript;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.part.PartModel;
import net.minecraft.entity.Entity;

public class ModelC7Doors extends PartModel {

    public ModelC7Doors(){
    	super(); textureX = 512; textureY = 512;
        this.addToCreators("Ferdinand (FEX___96)");
        //
        ModelRendererTurbo[] front_left = new ModelRendererTurbo[3];
        front_left[0] = new ModelRendererTurbo(this, 57, 145, textureX, textureY); // Box 242
        front_left[1] = new ModelRendererTurbo(this, 129, 153, textureX, textureY); // Box 243
        front_left[2] = new ModelRendererTurbo(this, 57, 49, textureX, textureY); // Box 248
        front_left[0].addShapeBox(-16F, 0F, -1F, 17, 11, 1, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, -1F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, -1F, 0F, 1F); // Box 242
        front_left[0].setRotationPoint(15F, -15F, 17F);
        front_left[1].addShapeBox(-16F, -2F, -1F, 17, 1, 1, 0F, 0F, -0.9F, 0F, 0F, -2F, -0.5F, 0F, -2.9F, 0F, 0F, -0.9F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F); // Box 243
        front_left[1].setRotationPoint(15F, -14F, 17F);
        front_left[2].addBox(-15F, 0F, -0.5F, 3, 1, 1, 0F); // Box 248
        front_left[2].setRotationPoint(15F, -12F, 17F);
        this.add("front_left", front_left);
        //
        ModelRendererTurbo[] front_right = new ModelRendererTurbo[3];
        front_right[0] = new ModelRendererTurbo(this, 225, 153, textureX, textureY); // Box 244
        front_right[1] = new ModelRendererTurbo(this, 265, 153, textureX, textureY); // Box 245
        front_right[2] = new ModelRendererTurbo(this, 73, 49, textureX, textureY); // Box 249
        front_right[0].addShapeBox(-16F, 0F, -1F, 17, 11, 1, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, -1F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, -1F, 0F, -1F); // Box 244
        front_right[0].setRotationPoint(15F, -15F, -16F);
        front_right[1].addShapeBox(-16F, -2F, -1F, 17, 1, 1, 0F, 0F, -0.9F, 0F, 0F, -2.9F, 0F, 0F, -2F, -0.5F, 0F, -0.9F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F); // Box 245
        front_right[1].setRotationPoint(15F, -14F, -16F);
        front_right[2].addBox(-15F, 0F, -1.5F, 3, 1, 1, 0F); // Box 249
        front_right[2].setRotationPoint(15F, -12F, -16F);
        this.add("front_right", front_right);
        //
        ModelRendererTurbo[] back_left = new ModelRendererTurbo[2];
        back_left[0] = new ModelRendererTurbo(this, 305, 153, textureX, textureY); // Box 246
        back_left[1] = new ModelRendererTurbo(this, 105, 49, textureX, textureY); // Box 250
        back_left[0].addShapeBox(-17F, 0F, 1F, 18, 11, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, -1F, 0F, 1F); // Box 246
        back_left[0].setRotationPoint(-5F, -15F, 15F);
        back_left[1].addBox(-14F, 0F, 1.5F, 3, 1, 1, 0F); // Box 250
        back_left[1].setRotationPoint(-5F, -12F, 15F);
        this.add("back_left", back_left);
        //
        ModelRendererTurbo[] back_right = new ModelRendererTurbo[2];
        back_right[0] = new ModelRendererTurbo(this, 345, 153, textureX, textureY); // Box 247
        back_right[1] = new ModelRendererTurbo(this, 321, 49, textureX, textureY); // Box 251
        back_right[0].addShapeBox(-17F, 0F, 1F, 18, 11, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, -1F, 0F, -1F); // Box 247
        back_right[0].setRotationPoint(-5F, -15F, -18F);
        back_right[1].addBox(-14F, 0F, 0.5F, 3, 1, 1, 0F); // Box 251
        back_right[1].setRotationPoint(-5F, -12F, -18F);
        this.add("back_right", back_right);
        //
        ModelRendererTurbo[] trunkc = new ModelRendererTurbo[3];
        trunkc[0] = new ModelRendererTurbo(this, 145, 153, textureX, textureY); // Box 252
        trunkc[1] = new ModelRendererTurbo(this, 361, 153, textureX, textureY); // Box 253
        trunkc[2] = new ModelRendererTurbo(this, 193, 145, textureX, textureY); // Box 254
        trunkc[0].addBox(-5F, 11F, 0F, 2, 10, 28, 0F); // Box 252
        trunkc[0].setRotationPoint(-41F, -26F, -14F);
        trunkc[1].addShapeBox(-3F, 11F, 0F, 1, 1, 30, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.9F, 0F, 0F, -0.9F, 0F, 0F, 0F, 0F, 0F); // Box 253
        trunkc[1].setRotationPoint(-41F, -26F, -15F);
        trunkc[2].addShapeBox(0F, 0F, 0F, 2, 1, 26, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F); // Box 254
        trunkc[2].setRotationPoint(-41F, -26F, -13F);
        this.add("trunkc", trunkc);
        //
        ModelRendererTurbo[] trunkn = new ModelRendererTurbo[4];
        trunkn[0] = new ModelRendererTurbo(this, 425, 81, textureX, textureY); // Box 255
        trunkn[1] = new ModelRendererTurbo(this, 25, 89, textureX, textureY); // Box 256
        trunkn[2] = new ModelRendererTurbo(this, 233, 1, textureX, textureY); // Box 257
        trunkn[3] = new ModelRendererTurbo(this, 425, 145, textureX, textureY); // Box 258
        trunkn[0].addShapeBox(0F, 0F, 0F, 2, 11, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 4.5F, 0F, -1F, -4F, 0F, -1F, -4F, 0F, 1F, 4.5F, 0F, 1F); // Box 255
        trunkn[0].setRotationPoint(-41F, -26F, 13F);
        trunkn[1].addShapeBox(0F, 0F, 0F, 2, 11, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 4.5F, 0F, 1F, -4F, 0F, 1F, -4F, 0F, -1F, 4.5F, 0F, -1F); // Box 256
        trunkn[1].setRotationPoint(-41F, -26F, -14F);
        trunkn[2].addShapeBox(-6F, 13F, 4F, 1, 1, 12, 0F, -0.5F, -0.4F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.4F, -0.5F, -0.5F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, -0.5F); // Box 257
        trunkn[2].setRotationPoint(-41F, -26F, -10F);
        trunkn[3].addShapeBox(-6F, 13F, 4F, 1, 3, 10, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F); // Box 258
        trunkn[3].setRotationPoint(-41F, -25F, -9F);
        this.add("trunkn", trunkn);
    }

    @Override
    public void render(VehicleData data, String us){
        data.getPrimaryColor().glColorApply();
        render("front_left");
        render("front_right");
        render("back_left");
        render("back_right");
        render("trunkc");
        RGB.glColorReset();
        render("trunkn");
    }

    @Override
    public void render(VehicleData data, String us, Entity vehicle, int meta){
        MultiDoorScript script = data.getScript(MultiDoorScript.class);
        if(script == null){
            data.getPrimaryColor().glColorApply();
            get("front_left").rotate(0, data.doorsOpen() ? Static.rad60 : 0, 0, true);
            render("front_left");
            get("front_right").rotate(0, data.doorsOpen() ? -Static.rad60 : 0, 0, true);
            render("front_right");
            get("back_left").rotate(0, data.doorsOpen() ? Static.rad60 : 0, 0, true);
            render("back_left");
            get("back_right").rotate(0, data.doorsOpen() ? -Static.rad60 : 0, 0, true);
            render("back_right");
            //
            get("trunkc").rotate(0, 0, data.doorsOpen() ? Static.rad120 : 0, true);
            render("trunkc");
            RGB.glColorReset();
            get("trunkn").rotate(0, 0, data.doorsOpen() ? Static.rad120 : 0, true);
            render("trunkn");
        }
        else{
            data.getPrimaryColor().glColorApply();
            get("front_left").rotate(0, script.front_left ? Static.rad60 : 0, 0, true);
            render("front_left");
            get("front_right").rotate(0, script.front_right ? -Static.rad60 : 0, 0, true);
            render("front_right");
            get("back_left").rotate(0, script.back_left ? Static.rad60 : 0, 0, true);
            render("back_left");
            get("back_right").rotate(0, script.back_right ? -Static.rad60 : 0, 0, true);
            render("back_right");
            //
            get("trunkc").rotate(0, 0, script.trunk ? Static.rad120 : 0, true);
            render("trunkc");
            RGB.glColorReset();
            get("trunkn").rotate(0, 0, script.trunk ? Static.rad120 : 0, true);
            render("trunkn");
        }
    }

}
