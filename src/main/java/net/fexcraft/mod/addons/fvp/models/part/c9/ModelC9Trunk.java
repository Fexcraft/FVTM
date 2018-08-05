package net.fexcraft.mod.addons.fvp.models.part.c9;

import net.fexcraft.mod.addons.gep.scripts.MultiDoorScript;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.part.PartModel;
import net.fexcraft.mod.fvtm.util.RenderCache;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.entity.Entity;

public class ModelC9Trunk extends PartModel {

    public ModelC9Trunk(){
    	super(); textureX = 512; textureY = 512;
        this.addToCreators("Ferdinand (FEX___96)");
		body_colored_primary = new ModelRendererTurbo[12];
		body_colored_primary[0] = new ModelRendererTurbo(this, 121, 121, textureX, textureY); // Box 260
		body_colored_primary[1] = new ModelRendererTurbo(this, 49, 121, textureX, textureY); // Box 261
		body_colored_primary[2] = new ModelRendererTurbo(this, 177, 121, textureX, textureY); // Box 262
		body_colored_primary[3] = new ModelRendererTurbo(this, 281, 121, textureX, textureY); // Box 263
		body_colored_primary[4] = new ModelRendererTurbo(this, 201, 121, textureX, textureY); // Box 264
		body_colored_primary[5] = new ModelRendererTurbo(this, 241, 121, textureX, textureY); // Box 265
		body_colored_primary[6] = new ModelRendererTurbo(this, 1, 137, textureX, textureY); // Box 324
		body_colored_primary[7] = new ModelRendererTurbo(this, 33, 137, textureX, textureY); // Box 325
		body_colored_primary[8] = new ModelRendererTurbo(this, 73, 137, textureX, textureY); // Box 326
		body_colored_primary[9] = new ModelRendererTurbo(this, 105, 145, textureX, textureY); // Box 327
		body_colored_primary[10] = new ModelRendererTurbo(this, 185, 145, textureX, textureY); // Box 328
		body_colored_primary[11] = new ModelRendererTurbo(this, 225, 145, textureX, textureY); // Box 329
		body_colored_primary[0].addShapeBox(-16.5F, 3F, -7.5F, 2, 2, 15, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 260
		body_colored_primary[0].setRotationPoint(-38F, -6F, 0F);
		body_colored_primary[1].addShapeBox(-16.5F, 3F, -16.5F, 2, 2, 9, 0F, -1.3F, 0F, 0.1F, 1.3F, 0F, 0.1F, 1F, 0F, 0F, -1F, 0F, 0F, -0.5F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 261
		body_colored_primary[1].setRotationPoint(-38F, -6F, 0F);
		body_colored_primary[2].addShapeBox(-16.5F, 3F, 7.5F, 2, 2, 9, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1.3F, 0F, 0.1F, -1.3F, 0F, 0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, -0.5F, 0F, 0.1F); // Box 262
		body_colored_primary[2].setRotationPoint(-38F, -6F, 0F);
		body_colored_primary[3].addShapeBox(-15.5F, 2F, -7.5F, 1, 1, 15, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.5F, 0F, -0.2F, -0.5F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F, 0F); // Box 263
		body_colored_primary[3].setRotationPoint(-38F, -6F, 0F);
		body_colored_primary[4].addShapeBox(-15.5F, 2F, -16.5F, 1, 1, 9, 0F, -0.5F, -0.7F, 0F, 0.1F, -0.5F, 0F, -0.2F, -0.5F, 0F, -0.2F, -0.7F, 0F, -0.3F, 0F, 0F, 0.1F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F, 0F); // Box 264
		body_colored_primary[4].setRotationPoint(-38F, -6F, 0F);
		body_colored_primary[5].addShapeBox(-15.5F, 2F, 7.5F, 1, 1, 9, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.5F, 0F, 0.1F, -0.5F, 0F, -0.5F, -0.7F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, 0.1F, 0F, 0F, -0.3F, 0F, 0F); // Box 265
		body_colored_primary[5].setRotationPoint(-38F, -6F, 0F);
		body_colored_primary[6].addShapeBox(-15F, 1.5F, -7F, 7, 1, 14, 0F, -0.3F, -1F, 0.5F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, -0.3F, -1F, 0.5F, -0.3F, 1F, 0.5F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, -0.3F, 1F, 0.5F); // Box 324
		body_colored_primary[6].setRotationPoint(-38F, -6F, 0F);
		body_colored_primary[7].addShapeBox(-15F, 1.5F, -17F, 8, 1, 10, 0F, -0.6F, -1F, -0.4F, 0F, 0.1F, -0.4F, -1F, 0.5F, 0F, -0.3F, -1F, -0.5F, -0.7F, 1F, -0.5F, 0F, -0.1F, -0.4F, -1F, -0.5F, 0F, -0.3F, 1F, -0.5F); // Box 325
		body_colored_primary[7].setRotationPoint(-38F, -6F, 0F);
		body_colored_primary[8].addShapeBox(-15F, 1.5F, 7F, 8, 1, 10, 0F, -0.3F, -1F, -0.5F, -1F, 0.5F, 0F, 0F, 0.1F, -0.4F, -0.6F, -1F, -0.4F, -0.3F, 1F, -0.5F, -1F, -0.5F, 0F, 0F, -0.1F, -0.4F, -0.7F, 1F, -0.5F); // Box 326
		body_colored_primary[8].setRotationPoint(-38F, -6F, 0F);
		body_colored_primary[9].addShapeBox(-8F, 0F, -6F, 9, 1, 12, 0F, 0F, -1F, 1F, -0.5F, 0.2F, 0F, -0.5F, 0.2F, 0F, 0F, -1F, 1F, 0F, 1F, 1F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 1F, 1F); // Box 327
		body_colored_primary[9].setRotationPoint(-38F, -6F, 0F);
		body_colored_primary[10].addShapeBox(-8F, 0F, -16.5F, 9, 1, 10, 0F, -1F, -1.4F, 0.1F, 0.2F, -0.6F, 0.1F, -0.5F, 0.2F, 0.5F, 0F, -1F, -0.5F, -1F, 1.4F, 0.1F, 0.2F, 0.6F, 0.1F, -0.5F, 0F, 0.5F, 0F, 1F, -0.5F); // Box 328
		body_colored_primary[10].setRotationPoint(-38F, -6F, 0F);
		body_colored_primary[11].addShapeBox(-8F, 0F, 6.5F, 9, 1, 10, 0F, 0F, -1F, -0.5F, -0.5F, 0.2F, 0.5F, 0.2F, -0.6F, 0.1F, -1F, -1.4F, 0.1F, 0F, 1F, -0.5F, -0.5F, 0F, 0.5F, 0.2F, 0.6F, 0.1F, -1F, 1.4F, 0.1F); // Box 329
		body_colored_primary[11].setRotationPoint(-38F, -6F, 0F);
    }

    @Override
    public void render(VehicleData data, String us){
        data.getPrimaryColor().glColorApply();
        render(body_colored_primary);
        RGB.glColorReset();
    }

    @Override
    public void render(VehicleData data, String us, Entity ent, int meta){
        data.getPrimaryColor().glColorApply();
        MultiDoorScript script = data.getScript(MultiDoorScript.class);
    	float state = RenderCache.getData(ent, "c9_trunk", 0) + ((script == null ? data.doorsOpen() : script.trunk) ? 1 : -1);
    	RenderCache.updateData(ent, "c9_trunk", state = state > 75 ? 75 : state < 0 ? 0 : state);
        rotate(body_colored_primary, 0, 0, state * Static.rad1, true);
        render(body_colored_primary);
        rotate(body_colored_primary, 0, 0, 0, true);
        RGB.glColorReset();
    }

}
