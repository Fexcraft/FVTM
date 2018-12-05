package net.fexcraft.mod.addons.hcp.models.part;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/**
 *
 * @author Ferdinand (FEX___96)
 */
@fModel(registryname = "hcp:models/part/tr1_license_plate")
public class TR1LicensePlate extends PartModel {

    public TR1LicensePlate(){
    	super(); this.addToCreators("FEX___96"); textureX = 512; textureY = 512;
        ModelRendererTurbo[] body = new ModelRendererTurbo[2], lights = new ModelRendererTurbo[1];
        body[0] = new ModelRendererTurbo(this, 321, 177, textureX, textureY); // Box 115
        body[0].addBox(0F, 0F, 0F, 1, 3, 12, 0F); // Box 115
        body[0].setRotationPoint(-235.8F, -19F, -6F);
        //
        body[1] = new ModelRendererTurbo(this, 241, 105, textureX, textureY); // Box 116
        body[1].addShapeBox(0F, 0F, 0F, 1, 1, 14, 0F, -0.2F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, -0.2F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 116
        body[1].setRotationPoint(-236F, -20.5F, -7F);
        //
        lights[0] = new ModelRendererTurbo(this, 361, 177, textureX, textureY); // Box 117
        lights[0].addBox(0F, 0F, 0F, 1, 1, 12, 0F); // Box 117
        lights[0].setRotationPoint(-235.7F, -20.2F, -6F);
        this.add("body", body); this.add("lights", lights); this.get("lights").addProgram(DefaultPrograms.LIGHTS);
    }

}
