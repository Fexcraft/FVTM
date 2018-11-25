package net.fexcraft.mod.addons.fvp.models.part.c7;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.addons.gep.models.GeneralPrograms;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

@fModel(registryname = "fvp:models/part/c7_hood")
public class C7Hood extends PartModel {

    public C7Hood(){
    	super(); textureX = 512; textureY = 512;
        this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList door_hood = new TurboList("door_hood");
		door_hood.add(new ModelRendererTurbo(door_hood, 57, 41, textureX, textureY).addBox(0, 0, 0, 10, 1, 26)
			.setRotationPoint(22, -15, -13).setRotationAngle(0, 0, 0).setName("Box 58")
		);
		door_hood.add(new ModelRendererTurbo(door_hood, 305, 49, textureX, textureY)
			.addShapeBox(10, 0, 0, 11, 1, 26, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0, 0)
			.setRotationPoint(22, -15, -13).setRotationAngle(0, 0, 0).setName("Box 59")
		);
		door_hood.add(new ModelRendererTurbo(door_hood, 105, 57, textureX, textureY)
			.addShapeBox(21, 1, 0, 3, 1, 26, 0, 0, 0.5f, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0.5f, 0, 0, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0, 0, 0)
			.setRotationPoint(22, -15, -13).setRotationAngle(0, 0, 0).setName("Box 67")
		);
		door_hood.add(new ModelRendererTurbo(door_hood, 393, 49, textureX, textureY).addBox(20, 1.5f, 0, 1, 1, 18)
			.setRotationPoint(22, -15, -9).setRotationAngle(0, 0, 0).setName("Box 96")
		);
		door_hood.addPrograms(DefaultPrograms.RGB_PRIMARY, new GeneralPrograms.CustomMultiDoorHood(-60, 2, true));
		this.groups.add(door_hood);
    }

}
