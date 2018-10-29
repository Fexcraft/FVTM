package net.fexcraft.mod.addons.fvp.models.part.c9;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.addons.gep.scripts.MultiDoorScript;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.part.PartModelTMT;
import net.fexcraft.mod.fvtm.util.RenderCache;
import net.minecraft.entity.Entity;

public class ModelC9Hood extends PartModelTMT {

    public ModelC9Hood(){
    	super(); textureX = 512; textureY = 512;
        this.addToCreators("Ferdinand (FEX___96)");
		body_colored_primary = new ModelRendererTurbo[31];
		body_colored_primary[0] = new ModelRendererTurbo(this, 489, 33, textureX, textureY); // Box 70
		body_colored_primary[1] = new ModelRendererTurbo(this, 33, 49, textureX, textureY); // Box 76
		body_colored_primary[2] = new ModelRendererTurbo(this, 265, 41, textureX, textureY); // Box 84
		body_colored_primary[3] = new ModelRendererTurbo(this, 409, 41, textureX, textureY); // Box 86
		body_colored_primary[4] = new ModelRendererTurbo(this, 73, 49, textureX, textureY); // Box 87
		body_colored_primary[5] = new ModelRendererTurbo(this, 105, 49, textureX, textureY); // Box 88
		body_colored_primary[6] = new ModelRendererTurbo(this, 145, 49, textureX, textureY); // Box 89
		body_colored_primary[7] = new ModelRendererTurbo(this, 177, 49, textureX, textureY); // Box 90
		body_colored_primary[8] = new ModelRendererTurbo(this, 217, 49, textureX, textureY); // Box 91
		body_colored_primary[9] = new ModelRendererTurbo(this, 289, 49, textureX, textureY); // Box 91
		body_colored_primary[10] = new ModelRendererTurbo(this, 337, 49, textureX, textureY); // Box 92
		body_colored_primary[11] = new ModelRendererTurbo(this, 409, 49, textureX, textureY); // Box 93
		body_colored_primary[12] = new ModelRendererTurbo(this, 89, 65, textureX, textureY); // Box 123
		body_colored_primary[13] = new ModelRendererTurbo(this, 137, 65, textureX, textureY); // Box 124
		body_colored_primary[14] = new ModelRendererTurbo(this, 185, 65, textureX, textureY); // Box 125
		body_colored_primary[15] = new ModelRendererTurbo(this, 121, 65, textureX, textureY); // Box 126
		body_colored_primary[16] = new ModelRendererTurbo(this, 177, 65, textureX, textureY); // Box 127
		body_colored_primary[17] = new ModelRendererTurbo(this, 225, 65, textureX, textureY); // Box 128
		body_colored_primary[18] = new ModelRendererTurbo(this, 249, 65, textureX, textureY); // Box 129
		body_colored_primary[19] = new ModelRendererTurbo(this, 137, 57, textureX, textureY); // Box 130
		body_colored_primary[20] = new ModelRendererTurbo(this, 169, 57, textureX, textureY); // Box 131
		body_colored_primary[21] = new ModelRendererTurbo(this, 321, 57, textureX, textureY); // Box 132
		body_colored_primary[22] = new ModelRendererTurbo(this, 289, 65, textureX, textureY); // Box 133
		body_colored_primary[23] = new ModelRendererTurbo(this, 209, 57, textureX, textureY); // Box 134
		body_colored_primary[24] = new ModelRendererTurbo(this, 313, 65, textureX, textureY); // Box 135
		body_colored_primary[25] = new ModelRendererTurbo(this, 73, 57, textureX, textureY); // Box 136
		body_colored_primary[26] = new ModelRendererTurbo(this, 249, 57, textureX, textureY); // Box 137
		body_colored_primary[27] = new ModelRendererTurbo(this, 289, 57, textureX, textureY); // Box 138
		body_colored_primary[28] = new ModelRendererTurbo(this, 369, 57, textureX, textureY); // Box 139
		body_colored_primary[29] = new ModelRendererTurbo(this, 409, 57, textureX, textureY); // Box 140
		body_colored_primary[30] = new ModelRendererTurbo(this, 441, 57, textureX, textureY); // Box 141
		body_colored_primary[0].addShapeBox(27.8F, 3F, 7F, 1, 1, 10, 0F, -0.1F, -0.3F, 0F, -0.3F, -0.6F, 0F, -1.9F, -0.6F, -0.5F, 1.3F, -0.3F, -0.5F, -0.1F, 0F, 0F, 0.1F, 0F, 0F, -1.65F, 0F, -0.5F, 1.7F, 0F, -0.5F); // Box 70
		body_colored_primary[0].setRotationPoint(20F, -5F, 0F);
		body_colored_primary[1].addShapeBox(27.8F, 3F, -17F, 1, 1, 10, 0F, 1.3F, -0.3F, -0.5F, -1.9F, -0.6F, -0.5F, -0.3F, -0.6F, 0F, -0.1F, -0.3F, 0F, 1.7F, 0F, -0.5F, -1.65F, 0F, -0.5F, 0.1F, 0F, 0F, -0.1F, 0F, 0F); // Box 76
		body_colored_primary[1].setRotationPoint(20F, -5F, 0F);
		body_colored_primary[2].addShapeBox(28F, 3F, 6F, 1, 1, 1, 0F, 0F, -0.3F, -0.2F, -0.4F, -0.6F, -0.2F, -0.5F, -0.6F, 0F, 0.1F, -0.3F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, -0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 84
		body_colored_primary[2].setRotationPoint(20F, -5F, 0F);
		body_colored_primary[3].addShapeBox(28F, 3F, -7F, 1, 1, 1, 0F, 0.1F, -0.3F, 0F, -0.5F, -0.6F, 0F, -0.4F, -0.6F, -0.2F, 0F, -0.3F, -0.2F, 0.1F, 0F, 0F, -0.1F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F); // Box 86
		body_colored_primary[3].setRotationPoint(20F, -5F, 0F);
		body_colored_primary[4].addShapeBox(24.6F, 3F, 6.2F, 4, 1, 11, 0F, 0F, 0.3F, 0F, -0.6F, -0.3F, 0F, -2.1F, -0.3F, -0.7F, 0F, 0.3F, -0.7F, 0F, -0.3F, 0F, -0.6F, 0.3F, 0F, -2.1F, 0.3F, -0.7F, 0F, -0.3F, -0.7F); // Box 87
		body_colored_primary[4].setRotationPoint(20F, -5F, 0F);
		body_colored_primary[5].addShapeBox(18F, 2F, 6.2F, 7, 1, 11, 0F, 0F, 0.3F, 0F, -0.4F, -0.7F, 0F, -0.4F, -0.7F, -0.7F, 0F, 0.3F, -0.7F, 0F, -0.3F, 0F, -0.4F, 0.7F, 0F, -0.4F, 0.7F, -0.7F, 0F, -0.3F, -0.7F); // Box 88
		body_colored_primary[5].setRotationPoint(20F, -5F, 0F);
		body_colored_primary[6].addShapeBox(24.6F, 3F, -17.2F, 4, 1, 11, 0F, 0F, 0.3F, -0.7F, -2.1F, -0.3F, -0.7F, -0.6F, -0.3F, 0F, 0F, 0.3F, 0F, 0F, -0.3F, -0.7F, -2.1F, 0.3F, -0.7F, -0.6F, 0.3F, 0F, 0F, -0.3F, 0F); // Box 89
		body_colored_primary[6].setRotationPoint(20F, -5F, 0F);
		body_colored_primary[7].addShapeBox(18F, 2F, -17.2F, 7, 1, 11, 0F, 0F, 0.3F, -0.7F, -0.4F, -0.7F, -0.7F, -0.4F, -0.7F, 0F, 0F, 0.3F, 0F, 0F, -0.3F, -0.7F, -0.4F, 0.7F, -0.7F, -0.4F, 0.7F, 0F, 0F, -0.3F, 0F); // Box 90
		body_colored_primary[7].setRotationPoint(20F, -5F, 0F);
		body_colored_primary[8].addShapeBox(8F, 1F, 6.2F, 10, 1, 11, 0F, 0F, 0.4F, 0F, 0F, -0.7F, 0F, 0F, -0.7F, -0.7F, 0F, 0F, -0.7F, 0F, -0.4F, 0F, 0F, 0.7F, 0F, 0F, 0.7F, -0.7F, 0F, 0F, -0.7F); // Box 91
		body_colored_primary[8].setRotationPoint(20F, -5F, 0F);
		body_colored_primary[9].addShapeBox(8F, 1F, -17.2F, 10, 1, 11, 0F, 0F, 0F, -0.7F, 0F, -0.7F, -0.7F, 0F, -0.7F, 0F, 0F, 0.4F, 0F, 0F, 0F, -0.7F, 0F, 0.7F, -0.7F, 0F, 0.7F, 0F, 0F, -0.4F, 0F); // Box 91
		body_colored_primary[9].setRotationPoint(20F, -5F, 0F);
		body_colored_primary[10].addShapeBox(0F, 0.5F, 6.2F, 8, 1, 11, 0F, 0F, 0.4F, 0F, 0F, -0.1F, 0F, 0F, -0.5F, -0.7F, 2F, -0.3F, -0.7F, 0F, -0.4F, 0F, 0F, 0.1F, 0F, 0F, 0.5F, -0.7F, 2F, 0.3F, -0.7F); // Box 92
		body_colored_primary[10].setRotationPoint(20F, -5F, 0F);
		body_colored_primary[11].addShapeBox(0F, 0.5F, -17.2F, 8, 1, 11, 0F, 2F, -0.3F, -0.7F, 0F, -0.5F, -0.7F, 0F, -0.1F, 0F, 0F, 0.4F, 0F, 2F, 0.3F, -0.7F, 0F, 0.5F, -0.7F, 0F, 0.1F, 0F, 0F, -0.4F, 0F); // Box 93
		body_colored_primary[11].setRotationPoint(20F, -5F, 0F);
		body_colored_primary[12].addShapeBox(0F, 0F, -6F, 8, 1, 12, 0F, 0F, 0F, 0F, 0F, -0.6F, 0F, 0F, -0.6F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.6F, 0F, 0F, 0.6F, 0F, 0F, 0F, 0F); // Box 123
		body_colored_primary[12].setRotationPoint(20F, -5F, 0F);
		body_colored_primary[13].addShapeBox(8F, 0.5F, -6F, 10, 1, 12, 0F, 0F, -0.1F, 0F, 0F, -0.9F, 0F, 0F, -0.9F, 0F, 0F, -0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.9F, 0F, 0F, 0.9F, 0F, 0F, 0.1F, 0F); // Box 124
		body_colored_primary[13].setRotationPoint(20F, -5F, 0F);
		body_colored_primary[14].addShapeBox(18F, 1.5F, -6F, 10, 1, 12, 0F, 0F, 0.1F, 0F, 0F, -1.2F, 0F, 0F, -1.2F, 0F, 0F, 0.1F, 0F, 0F, 0F, 0F, 0F, 1.5F, 0F, 0F, 1.2F, 0F, 0F, 0F, 0F); // Box 125
		body_colored_primary[14].setRotationPoint(20F, -5F, 0F);
		body_colored_primary[15].addShapeBox(28F, 2.5F, 0F, 2, 1, 6, 0F, 0F, -0.2F, 0F, -1.3F, -0.2F, 0F, -1.9F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.3F, 0F, -0.4F, -0.3F, 0F, -0.9F, -0.3F, -0.2F, 0F, -0.3F, -0.2F); // Box 126
		body_colored_primary[15].setRotationPoint(20F, -5F, 0F);
		body_colored_primary[16].addShapeBox(28.2F, 3F, 0F, 2, 1, 6, 0F, 0.2F, -0.2F, 0F, -0.6F, -0.2F, 0F, -1.1F, -0.2F, -0.2F, 0.8F, -0.2F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F, -0.6F, 0F, -0.4F, 0.6F, 0F, -0.4F); // Box 127
		body_colored_primary[16].setRotationPoint(20F, -5F, 0F);
		body_colored_primary[17].addShapeBox(28.2F, 3F, -6F, 2, 1, 6, 0F, 0.8F, -0.2F, -0.2F, -1.1F, -0.2F, -0.2F, -0.6F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.6F, 0F, -0.4F, -0.6F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 128
		body_colored_primary[17].setRotationPoint(20F, -5F, 0F);
		body_colored_primary[18].addShapeBox(28F, 2.5F, -6F, 2, 1, 6, 0F, 0F, -0.2F, -0.2F, -1.9F, -0.2F, -0.2F, -1.3F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.3F, -0.2F, -0.9F, -0.3F, -0.2F, -0.4F, -0.3F, 0F, 0F, -0.3F, 0F); // Box 129
		body_colored_primary[18].setRotationPoint(20F, -5F, 0F);
		body_colored_primary[19].addShapeBox(0F, 0F, 6F, 8, 1, 1, 0F, 0F, 0F, 0F, 0F, -0.6F, 0F, 0F, -0.6F, -0.8F, 0F, -0.1F, -0.8F, 0F, 0F, 0F, 0F, 0.6F, 0F, 0F, 0.6F, -0.8F, 0F, 0.1F, -0.8F); // Box 130
		body_colored_primary[19].setRotationPoint(20F, -5F, 0F);
		body_colored_primary[20].addShapeBox(0F, 0F, -7F, 8, 1, 1, 0F, 0F, -0.1F, -0.8F, 0F, -0.6F, -0.8F, 0F, -0.6F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0.6F, -0.8F, 0F, 0.6F, 0F, 0F, 0F, 0F); // Box 131
		body_colored_primary[20].setRotationPoint(20F, -5F, 0F);
		body_colored_primary[21].addShapeBox(8F, 0.5F, 6F, 10, 1, 1, 0F, 0F, -0.1F, 0F, 0F, -0.9F, 0F, 0F, -1.2F, -0.8F, 0F, -0.1F, -0.8F, 0F, 0.1F, 0F, 0F, 0.9F, 0F, 0F, 1.2F, -0.8F, 0F, 0.1F, -0.8F); // Box 132
		body_colored_primary[21].setRotationPoint(20F, -5F, 0F);
		body_colored_primary[22].addShapeBox(8F, 0.5F, -7F, 10, 1, 1, 0F, 0F, -0.1F, -0.8F, 0F, -1.2F, -0.8F, 0F, -0.9F, 0F, 0F, -0.1F, 0F, 0F, 0.1F, -0.8F, 0F, 1.2F, -0.8F, 0F, 0.9F, 0F, 0F, 0.1F, 0F); // Box 133
		body_colored_primary[22].setRotationPoint(20F, -5F, 0F);
		body_colored_primary[23].addShapeBox(18F, 1.5F, 6F, 7, 1, 1, 0F, 0F, 0.1F, 0F, -0.4F, -0.76F, 0F, -0.4F, -1.2F, -0.8F, 0F, -0.2F, -0.8F, 0F, 0F, 0F, -0.4F, 0.8F, 0F, -0.4F, 1.2F, -0.8F, 0F, 0.2F, -0.8F); // Box 134
		body_colored_primary[23].setRotationPoint(20F, -5F, 0F);
		body_colored_primary[24].addShapeBox(18F, 1.5F, -7F, 7, 1, 1, 0F, 0F, -0.2F, -0.8F, -0.4F, -1.2F, -0.8F, -0.4F, -0.76F, 0F, 0F, 0.1F, 0F, 0F, 0.2F, -0.8F, -0.4F, 1.2F, -0.8F, -0.4F, 0.8F, 0F, 0F, 0F, 0F); // Box 135
		body_colored_primary[24].setRotationPoint(20F, -5F, 0F);
		body_colored_primary[25].addShapeBox(24.6F, 2.5F, 6F, 4, 1, 1, 0F, 0F, 0.24F, 0F, -0.6F, -0.2F, 0F, -0.6F, -0.8F, -0.8F, 0F, -0.2F, -0.8F, 0F, 0F, 0F, -0.6F, 0.2F, 0F, -0.6F, 0.8F, -0.8F, 0F, 0.2F, -0.8F); // Box 136
		body_colored_primary[25].setRotationPoint(20F, -5F, 0F);
		body_colored_primary[26].addShapeBox(24.6F, 2.5F, -7F, 4, 1, 1, 0F, 0F, -0.2F, -0.8F, -0.6F, -0.8F, -0.8F, -0.6F, -0.2F, 0F, 0F, 0.24F, 0F, 0F, 0.2F, -0.8F, -0.6F, 0.8F, -0.8F, -0.6F, 0.2F, 0F, 0F, 0F, 0F); // Box 137
		body_colored_primary[26].setRotationPoint(20F, -5F, 0F);
		body_colored_primary[27].addShapeBox(28F, 3F, 5.2F, 1, 1, 1, 0F, 0F, -0.2F, -0.6F, 0.1F, -0.2F, -0.6F, -0.4F, -0.6F, 0F, 0F, -0.3F, 0F, 0F, 0F, -0.4F, 0.6F, 0F, -0.4F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 138
		body_colored_primary[27].setRotationPoint(20F, -5F, 0F);
		body_colored_primary[28].addShapeBox(28F, 3F, -6.2F, 1, 1, 1, 0F, 0F, -0.3F, 0F, -0.4F, -0.6F, 0F, 0.1F, -0.2F, -0.6F, 0F, -0.2F, -0.6F, 0F, 0F, 0F, 0F, 0F, 0F, 0.6F, 0F, -0.4F, 0F, 0F, -0.4F); // Box 139
		body_colored_primary[28].setRotationPoint(20F, -5F, 0F);
		body_colored_primary[29].addShapeBox(28F, 2.5F, 5.8F, 1, 1, 1, 0F, 0F, -0.2F, 0F, -0.9F, -0.2F, 0F, -0.9F, -0.2F, -0.9F, 0F, -0.2F, -0.8F, 0F, -0.4F, 0F, 0.1F, -0.3F, 0F, -0.4F, 0.1F, -0.6F, 0F, -0.2F, -0.6F); // Box 140
		body_colored_primary[29].setRotationPoint(20F, -5F, 0F);
		body_colored_primary[30].addShapeBox(28F, 2.5F, -6.8F, 1, 1, 1, 0F, 0F, -0.2F, -0.8F, -0.9F, -0.2F, -0.9F, -0.9F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, -0.6F, -0.4F, 0.1F, -0.6F, 0.1F, -0.3F, 0F, 0F, -0.4F, 0F); // Box 141
		body_colored_primary[30].setRotationPoint(20F, -5F, 0F);
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
    	float state = ent == null ? data.doorsOpen() ? 45 : 0 : RenderCache.getData(ent, "c9_hood", 0) + ((script == null ? data.doorsOpen() : script.hood) ? 1 : -1);
    	if(ent != null) RenderCache.updateData(ent, "c9_hood", state = state > 45 ? 45 : state < 0 ? 0 : state);
        rotate(body_colored_primary, 0, 0, state * -Static.rad1, true);
        render(body_colored_primary);
        rotate(body_colored_primary, 0, 0, 0, true);
        RGB.glColorReset();
    }

}
