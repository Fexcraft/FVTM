package net.fexcraft.mod.addons.fvp.models.part;

import net.fexcraft.mod.addons.gep.scripts.MultiDoorScript;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.part.PartModel;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.entity.Entity;

public class ModelC7Hood extends PartModel {

    public ModelC7Hood(){
    	super(); textureX = 512; textureY = 512;
        this.addToCreators("Ferdinand (FEX___96)");
        body = new ModelRendererTurbo[4];
        body[0] = new ModelRendererTurbo(this, 57, 41, textureX, textureY); // Box 58
        body[1] = new ModelRendererTurbo(this, 305, 49, textureX, textureY); // Box 59
        body[2] = new ModelRendererTurbo(this, 105, 57, textureX, textureY); // Box 67
        body[3] = new ModelRendererTurbo(this, 393, 49, textureX, textureY); // Box 96
        body[0].addBox(0F, 0F, 0F, 10, 1, 26, 0F); // Box 58
        body[0].setRotationPoint(22F, -15F, -13F);
        body[1].addShapeBox(10F, 0F, 0F, 11, 1, 26, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F); // Box 59
        body[1].setRotationPoint(22F, -15F, -13F);
        body[2].addShapeBox(21F, 1F, 0F, 3, 1, 26, 0F, 0F, 0.5F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0F, 0F, 0F); // Box 67
        body[2].setRotationPoint(22F, -15F, -13F);
        body[3].addBox(20F, 1.5F, 0F, 1, 1, 18, 0F); // Box 96
        body[3].setRotationPoint(22F, -15F, -9F);
    }

    @Override
    public void render(VehicleData data, String us){
        data.getPrimaryColor().glColorApply();
        render(body);
        RGB.glColorReset();
    }

    @Override
    public void render(VehicleData data, String us, Entity vehicle, int meta){
        data.getPrimaryColor().glColorApply();
        MultiDoorScript script = data.getScript(MultiDoorScript.class);
        rotate(body, 0, 0, script == null ? data.doorsOpen() ? -Static.rad60 : 0 : script.hood ? -Static.rad60 : 0, true);
        render(body);
        RGB.glColorReset();
    }

}
