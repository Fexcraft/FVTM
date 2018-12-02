//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.part.c9;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.addons.gep.models.GeneralPrograms;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.4-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/part/c9_trunk")
public class C9Trunk extends PartModel {

	public C9Trunk(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList door_trunk = new TurboList("door_trunk");
		door_trunk.add(new ModelRendererTurbo(door_trunk, 121, 121, textureX, textureY)
			.addShapeBox(-16.5f, 3, -7.5f, 2, 2, 15, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-38, -6, 0).setRotationAngle(0, 0, 0).setName("Box 260")
		);
		door_trunk.add(new ModelRendererTurbo(door_trunk, 49, 121, textureX, textureY)
			.addShapeBox(-16.5f, 3, -16.5f, 2, 2, 9, 0, -1.3f, 0, 0.1f, 1.3f, 0, 0.1f, 1, 0, 0, -1, 0, 0, -0.5f, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-38, -6, 0).setRotationAngle(0, 0, 0).setName("Box 261")
		);
		door_trunk.add(new ModelRendererTurbo(door_trunk, 177, 121, textureX, textureY)
			.addShapeBox(-16.5f, 3, 7.5f, 2, 2, 9, 0, -1, 0, 0, 1, 0, 0, 1.3f, 0, 0.1f, -1.3f, 0, 0.1f, 0, 0, 0, 0, 0, 0, 0, 0, 0.1f, -0.5f, 0, 0.1f)
			.setRotationPoint(-38, -6, 0).setRotationAngle(0, 0, 0).setName("Box 262")
		);
		door_trunk.add(new ModelRendererTurbo(door_trunk, 281, 121, textureX, textureY)
			.addShapeBox(-15.5f, 2, -7.5f, 1, 1, 15, 0, -0.2f, -0.7f, 0, -0.2f, -0.5f, 0, -0.2f, -0.5f, 0, -0.2f, -0.7f, 0, 0, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, 0, 0, 0)
			.setRotationPoint(-38, -6, 0).setRotationAngle(0, 0, 0).setName("Box 263")
		);
		door_trunk.add(new ModelRendererTurbo(door_trunk, 201, 121, textureX, textureY)
			.addShapeBox(-15.5f, 2, -16.5f, 1, 1, 9, 0, -0.5f, -0.7f, 0, 0.1f, -0.5f, 0, -0.2f, -0.5f, 0, -0.2f, -0.7f, 0, -0.3f, 0, 0, 0.1f, 0, 0, -0.2f, 0, 0, 0, 0, 0)
			.setRotationPoint(-38, -6, 0).setRotationAngle(0, 0, 0).setName("Box 264")
		);
		door_trunk.add(new ModelRendererTurbo(door_trunk, 241, 121, textureX, textureY)
			.addShapeBox(-15.5f, 2, 7.5f, 1, 1, 9, 0, -0.2f, -0.7f, 0, -0.2f, -0.5f, 0, 0.1f, -0.5f, 0, -0.5f, -0.7f, 0, 0, 0, 0, -0.2f, 0, 0, 0.1f, 0, 0, -0.3f, 0, 0)
			.setRotationPoint(-38, -6, 0).setRotationAngle(0, 0, 0).setName("Box 265")
		);
		door_trunk.add(new ModelRendererTurbo(door_trunk, 1, 137, textureX, textureY)
			.addShapeBox(-15, 1.5f, -7, 7, 1, 14, 0, -0.3f, -1, 0.5f, 0, 0.5f, 0, 0, 0.5f, 0, -0.3f, -1, 0.5f, -0.3f, 1, 0.5f, 0, -0.5f, 0, 0, -0.5f, 0, -0.3f, 1, 0.5f)
			.setRotationPoint(-38, -6, 0).setRotationAngle(0, 0, 0).setName("Box 324")
		);
		door_trunk.add(new ModelRendererTurbo(door_trunk, 33, 137, textureX, textureY)
			.addShapeBox(-15, 1.5f, -17, 8, 1, 10, 0, -0.6f, -1, -0.4f, 0, 0.1f, -0.4f, -1, 0.5f, 0, -0.3f, -1, -0.5f, -0.7f, 1, -0.5f, 0, -0.1f, -0.4f, -1, -0.5f, 0, -0.3f, 1, -0.5f)
			.setRotationPoint(-38, -6, 0).setRotationAngle(0, 0, 0).setName("Box 325")
		);
		door_trunk.add(new ModelRendererTurbo(door_trunk, 73, 137, textureX, textureY)
			.addShapeBox(-15, 1.5f, 7, 8, 1, 10, 0, -0.3f, -1, -0.5f, -1, 0.5f, 0, 0, 0.1f, -0.4f, -0.6f, -1, -0.4f, -0.3f, 1, -0.5f, -1, -0.5f, 0, 0, -0.1f, -0.4f, -0.7f, 1, -0.5f)
			.setRotationPoint(-38, -6, 0).setRotationAngle(0, 0, 0).setName("Box 326")
		);
		door_trunk.add(new ModelRendererTurbo(door_trunk, 105, 145, textureX, textureY)
			.addShapeBox(-8, 0, -6, 9, 1, 12, 0, 0, -1, 1, -0.5f, 0.2f, 0, -0.5f, 0.2f, 0, 0, -1, 1, 0, 1, 1, -0.5f, 0, 0, -0.5f, 0, 0, 0, 1, 1)
			.setRotationPoint(-38, -6, 0).setRotationAngle(0, 0, 0).setName("Box 327")
		);
		door_trunk.add(new ModelRendererTurbo(door_trunk, 185, 145, textureX, textureY)
			.addShapeBox(-8, 0, -16.5f, 9, 1, 10, 0, -1, -1.4f, 0.1f, 0.2f, -0.6f, 0.1f, -0.5f, 0.2f, 0.5f, 0, -1, -0.5f, -1, 1.4f, 0.1f, 0.2f, 0.6f, 0.1f, -0.5f, 0, 0.5f, 0, 1, -0.5f)
			.setRotationPoint(-38, -6, 0).setRotationAngle(0, 0, 0).setName("Box 328")
		);
		door_trunk.add(new ModelRendererTurbo(door_trunk, 225, 145, textureX, textureY)
			.addShapeBox(-8, 0, 6.5f, 9, 1, 10, 0, 0, -1, -0.5f, -0.5f, 0.2f, 0.5f, 0.2f, -0.6f, 0.1f, -1, -1.4f, 0.1f, 0, 1, -0.5f, -0.5f, 0, 0.5f, 0.2f, 0.6f, 0.1f, -1, 1.4f, 0.1f)
			.setRotationPoint(-38, -6, 0).setRotationAngle(0, 0, 0).setName("Box 329")
		);
		door_trunk.addPrograms(DefaultPrograms.RGB_PRIMARY, new GeneralPrograms.CustomMultiDoorTrunk(57, 2, true));
		this.groups.add(door_trunk);
	}

}