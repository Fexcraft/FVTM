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
@fModel(registryname = "fvp:models/part/c9_hood")
public class C9Hood extends PartModel {

	public C9Hood(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList door_hood = new TurboList("door_hood");
		door_hood.add(new ModelRendererTurbo(door_hood, 489, 33, textureX, textureY)
			.addShapeBox(27.8f, 3, 7, 1, 1, 10, 0, -0.1f, -0.3f, 0, -0.3f, -0.6f, 0, -1.9f, -0.6f, -0.5f, 1.3f, -0.3f, -0.5f, -0.1f, 0, 0, 0.1f, 0, 0, -1.65f, 0, -0.5f, 1.7f, 0, -0.5f)
			.setRotationPoint(20, -5, 0).setRotationAngle(0, 0, 0).setName("Box 70")
		);
		door_hood.add(new ModelRendererTurbo(door_hood, 33, 49, textureX, textureY)
			.addShapeBox(27.8f, 3, -17, 1, 1, 10, 0, 1.3f, -0.3f, -0.5f, -1.9f, -0.6f, -0.5f, -0.3f, -0.6f, 0, -0.1f, -0.3f, 0, 1.7f, 0, -0.5f, -1.65f, 0, -0.5f, 0.1f, 0, 0, -0.1f, 0, 0)
			.setRotationPoint(20, -5, 0).setRotationAngle(0, 0, 0).setName("Box 76")
		);
		door_hood.add(new ModelRendererTurbo(door_hood, 265, 41, textureX, textureY)
			.addShapeBox(28, 3, 6, 1, 1, 1, 0, 0, -0.3f, -0.2f, -0.4f, -0.6f, -0.2f, -0.5f, -0.6f, 0, 0.1f, -0.3f, 0, 0, 0, -0.2f, 0, 0, -0.2f, -0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(20, -5, 0).setRotationAngle(0, 0, 0).setName("Box 84")
		);
		door_hood.add(new ModelRendererTurbo(door_hood, 409, 41, textureX, textureY)
			.addShapeBox(28, 3, -7, 1, 1, 1, 0, 0.1f, -0.3f, 0, -0.5f, -0.6f, 0, -0.4f, -0.6f, -0.2f, 0, -0.3f, -0.2f, 0.1f, 0, 0, -0.1f, 0, 0, 0, 0, -0.2f, 0, 0, -0.2f)
			.setRotationPoint(20, -5, 0).setRotationAngle(0, 0, 0).setName("Box 86")
		);
		door_hood.add(new ModelRendererTurbo(door_hood, 73, 49, textureX, textureY)
			.addShapeBox(24.6f, 3, 6.2f, 4, 1, 11, 0, 0, 0.3f, 0, -0.6f, -0.3f, 0, -2.1f, -0.3f, -0.7f, 0, 0.3f, -0.7f, 0, -0.3f, 0, -0.6f, 0.3f, 0, -2.1f, 0.3f, -0.7f, 0, -0.3f, -0.7f)
			.setRotationPoint(20, -5, 0).setRotationAngle(0, 0, 0).setName("Box 87")
		);
		door_hood.add(new ModelRendererTurbo(door_hood, 105, 49, textureX, textureY)
			.addShapeBox(18, 2, 6.2f, 7, 1, 11, 0, 0, 0.3f, 0, -0.4f, -0.7f, 0, -0.4f, -0.7f, -0.7f, 0, 0.3f, -0.7f, 0, -0.3f, 0, -0.4f, 0.7f, 0, -0.4f, 0.7f, -0.7f, 0, -0.3f, -0.7f)
			.setRotationPoint(20, -5, 0).setRotationAngle(0, 0, 0).setName("Box 88")
		);
		door_hood.add(new ModelRendererTurbo(door_hood, 145, 49, textureX, textureY)
			.addShapeBox(24.6f, 3, -17.2f, 4, 1, 11, 0, 0, 0.3f, -0.7f, -2.1f, -0.3f, -0.7f, -0.6f, -0.3f, 0, 0, 0.3f, 0, 0, -0.3f, -0.7f, -2.1f, 0.3f, -0.7f, -0.6f, 0.3f, 0, 0, -0.3f, 0)
			.setRotationPoint(20, -5, 0).setRotationAngle(0, 0, 0).setName("Box 89")
		);
		door_hood.add(new ModelRendererTurbo(door_hood, 177, 49, textureX, textureY)
			.addShapeBox(18, 2, -17.2f, 7, 1, 11, 0, 0, 0.3f, -0.7f, -0.4f, -0.7f, -0.7f, -0.4f, -0.7f, 0, 0, 0.3f, 0, 0, -0.3f, -0.7f, -0.4f, 0.7f, -0.7f, -0.4f, 0.7f, 0, 0, -0.3f, 0)
			.setRotationPoint(20, -5, 0).setRotationAngle(0, 0, 0).setName("Box 90")
		);
		door_hood.add(new ModelRendererTurbo(door_hood, 217, 49, textureX, textureY)
			.addShapeBox(8, 1, 6.2f, 10, 1, 11, 0, 0, 0.4f, 0, 0, -0.7f, 0, 0, -0.7f, -0.7f, 0, 0, -0.7f, 0, -0.4f, 0, 0, 0.7f, 0, 0, 0.7f, -0.7f, 0, 0, -0.7f)
			.setRotationPoint(20, -5, 0).setRotationAngle(0, 0, 0).setName("Box 91")
		);
		door_hood.add(new ModelRendererTurbo(door_hood, 289, 49, textureX, textureY)
			.addShapeBox(8, 1, -17.2f, 10, 1, 11, 0, 0, 0, -0.7f, 0, -0.7f, -0.7f, 0, -0.7f, 0, 0, 0.4f, 0, 0, 0, -0.7f, 0, 0.7f, -0.7f, 0, 0.7f, 0, 0, -0.4f, 0)
			.setRotationPoint(20, -5, 0).setRotationAngle(0, 0, 0).setName("Box 91")
		);
		door_hood.add(new ModelRendererTurbo(door_hood, 337, 49, textureX, textureY)
			.addShapeBox(0, 0.5f, 6.2f, 8, 1, 11, 0, 0, 0.4f, 0, 0, -0.1f, 0, 0, -0.5f, -0.7f, 2, -0.3f, -0.7f, 0, -0.4f, 0, 0, 0.1f, 0, 0, 0.5f, -0.7f, 2, 0.3f, -0.7f)
			.setRotationPoint(20, -5, 0).setRotationAngle(0, 0, 0).setName("Box 92")
		);
		door_hood.add(new ModelRendererTurbo(door_hood, 409, 49, textureX, textureY)
			.addShapeBox(0, 0.5f, -17.2f, 8, 1, 11, 0, 2, -0.3f, -0.7f, 0, -0.5f, -0.7f, 0, -0.1f, 0, 0, 0.4f, 0, 2, 0.3f, -0.7f, 0, 0.5f, -0.7f, 0, 0.1f, 0, 0, -0.4f, 0)
			.setRotationPoint(20, -5, 0).setRotationAngle(0, 0, 0).setName("Box 93")
		);
		door_hood.add(new ModelRendererTurbo(door_hood, 89, 65, textureX, textureY)
			.addShapeBox(0, 0, -6, 8, 1, 12, 0, 0, 0, 0, 0, -0.6f, 0, 0, -0.6f, 0, 0, 0, 0, 0, 0, 0, 0, 0.6f, 0, 0, 0.6f, 0, 0, 0, 0)
			.setRotationPoint(20, -5, 0).setRotationAngle(0, 0, 0).setName("Box 123")
		);
		door_hood.add(new ModelRendererTurbo(door_hood, 137, 65, textureX, textureY)
			.addShapeBox(8, 0.5f, -6, 10, 1, 12, 0, 0, -0.1f, 0, 0, -0.9f, 0, 0, -0.9f, 0, 0, -0.1f, 0, 0, 0.1f, 0, 0, 0.9f, 0, 0, 0.9f, 0, 0, 0.1f, 0)
			.setRotationPoint(20, -5, 0).setRotationAngle(0, 0, 0).setName("Box 124")
		);
		door_hood.add(new ModelRendererTurbo(door_hood, 185, 65, textureX, textureY)
			.addShapeBox(18, 1.5f, -6, 10, 1, 12, 0, 0, 0.1f, 0, 0, -1.2f, 0, 0, -1.2f, 0, 0, 0.1f, 0, 0, 0, 0, 0, 1.5f, 0, 0, 1.2f, 0, 0, 0, 0)
			.setRotationPoint(20, -5, 0).setRotationAngle(0, 0, 0).setName("Box 125")
		);
		door_hood.add(new ModelRendererTurbo(door_hood, 121, 65, textureX, textureY)
			.addShapeBox(28, 2.5f, 0, 2, 1, 6, 0, 0, -0.2f, 0, -1.3f, -0.2f, 0, -1.9f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.3f, 0, -0.4f, -0.3f, 0, -0.9f, -0.3f, -0.2f, 0, -0.3f, -0.2f)
			.setRotationPoint(20, -5, 0).setRotationAngle(0, 0, 0).setName("Box 126")
		);
		door_hood.add(new ModelRendererTurbo(door_hood, 177, 65, textureX, textureY)
			.addShapeBox(28.2f, 3, 0, 2, 1, 6, 0, 0.2f, -0.2f, 0, -0.6f, -0.2f, 0, -1.1f, -0.2f, -0.2f, 0.8f, -0.2f, -0.2f, 0, 0, 0, 0, 0, 0, -0.6f, 0, -0.4f, 0.6f, 0, -0.4f)
			.setRotationPoint(20, -5, 0).setRotationAngle(0, 0, 0).setName("Box 127")
		);
		door_hood.add(new ModelRendererTurbo(door_hood, 225, 65, textureX, textureY)
			.addShapeBox(28.2f, 3, -6, 2, 1, 6, 0, 0.8f, -0.2f, -0.2f, -1.1f, -0.2f, -0.2f, -0.6f, -0.2f, 0, 0.2f, -0.2f, 0, 0.6f, 0, -0.4f, -0.6f, 0, -0.4f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(20, -5, 0).setRotationAngle(0, 0, 0).setName("Box 128")
		);
		door_hood.add(new ModelRendererTurbo(door_hood, 249, 65, textureX, textureY)
			.addShapeBox(28, 2.5f, -6, 2, 1, 6, 0, 0, -0.2f, -0.2f, -1.9f, -0.2f, -0.2f, -1.3f, -0.2f, 0, 0, -0.2f, 0, 0, -0.3f, -0.2f, -0.9f, -0.3f, -0.2f, -0.4f, -0.3f, 0, 0, -0.3f, 0)
			.setRotationPoint(20, -5, 0).setRotationAngle(0, 0, 0).setName("Box 129")
		);
		door_hood.add(new ModelRendererTurbo(door_hood, 137, 57, textureX, textureY)
			.addShapeBox(0, 0, 6, 8, 1, 1, 0, 0, 0, 0, 0, -0.6f, 0, 0, -0.6f, -0.8f, 0, -0.1f, -0.8f, 0, 0, 0, 0, 0.6f, 0, 0, 0.6f, -0.8f, 0, 0.1f, -0.8f)
			.setRotationPoint(20, -5, 0).setRotationAngle(0, 0, 0).setName("Box 130")
		);
		door_hood.add(new ModelRendererTurbo(door_hood, 169, 57, textureX, textureY)
			.addShapeBox(0, 0, -7, 8, 1, 1, 0, 0, -0.1f, -0.8f, 0, -0.6f, -0.8f, 0, -0.6f, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0.6f, -0.8f, 0, 0.6f, 0, 0, 0, 0)
			.setRotationPoint(20, -5, 0).setRotationAngle(0, 0, 0).setName("Box 131")
		);
		door_hood.add(new ModelRendererTurbo(door_hood, 321, 57, textureX, textureY)
			.addShapeBox(8, 0.5f, 6, 10, 1, 1, 0, 0, -0.1f, 0, 0, -0.9f, 0, 0, -1.2f, -0.8f, 0, -0.1f, -0.8f, 0, 0.1f, 0, 0, 0.9f, 0, 0, 1.2f, -0.8f, 0, 0.1f, -0.8f)
			.setRotationPoint(20, -5, 0).setRotationAngle(0, 0, 0).setName("Box 132")
		);
		door_hood.add(new ModelRendererTurbo(door_hood, 289, 65, textureX, textureY)
			.addShapeBox(8, 0.5f, -7, 10, 1, 1, 0, 0, -0.1f, -0.8f, 0, -1.2f, -0.8f, 0, -0.9f, 0, 0, -0.1f, 0, 0, 0.1f, -0.8f, 0, 1.2f, -0.8f, 0, 0.9f, 0, 0, 0.1f, 0)
			.setRotationPoint(20, -5, 0).setRotationAngle(0, 0, 0).setName("Box 133")
		);
		door_hood.add(new ModelRendererTurbo(door_hood, 209, 57, textureX, textureY)
			.addShapeBox(18, 1.5f, 6, 7, 1, 1, 0, 0, 0.1f, 0, -0.4f, -0.76f, 0, -0.4f, -1.2f, -0.8f, 0, -0.2f, -0.8f, 0, 0, 0, -0.4f, 0.8f, 0, -0.4f, 1.2f, -0.8f, 0, 0.2f, -0.8f)
			.setRotationPoint(20, -5, 0).setRotationAngle(0, 0, 0).setName("Box 134")
		);
		door_hood.add(new ModelRendererTurbo(door_hood, 313, 65, textureX, textureY)
			.addShapeBox(18, 1.5f, -7, 7, 1, 1, 0, 0, -0.2f, -0.8f, -0.4f, -1.2f, -0.8f, -0.4f, -0.76f, 0, 0, 0.1f, 0, 0, 0.2f, -0.8f, -0.4f, 1.2f, -0.8f, -0.4f, 0.8f, 0, 0, 0, 0)
			.setRotationPoint(20, -5, 0).setRotationAngle(0, 0, 0).setName("Box 135")
		);
		door_hood.add(new ModelRendererTurbo(door_hood, 73, 57, textureX, textureY)
			.addShapeBox(24.6f, 2.5f, 6, 4, 1, 1, 0, 0, 0.24f, 0, -0.6f, -0.2f, 0, -0.6f, -0.8f, -0.8f, 0, -0.2f, -0.8f, 0, 0, 0, -0.6f, 0.2f, 0, -0.6f, 0.8f, -0.8f, 0, 0.2f, -0.8f)
			.setRotationPoint(20, -5, 0).setRotationAngle(0, 0, 0).setName("Box 136")
		);
		door_hood.add(new ModelRendererTurbo(door_hood, 249, 57, textureX, textureY)
			.addShapeBox(24.6f, 2.5f, -7, 4, 1, 1, 0, 0, -0.2f, -0.8f, -0.6f, -0.8f, -0.8f, -0.6f, -0.2f, 0, 0, 0.24f, 0, 0, 0.2f, -0.8f, -0.6f, 0.8f, -0.8f, -0.6f, 0.2f, 0, 0, 0, 0)
			.setRotationPoint(20, -5, 0).setRotationAngle(0, 0, 0).setName("Box 137")
		);
		door_hood.add(new ModelRendererTurbo(door_hood, 289, 57, textureX, textureY)
			.addShapeBox(28, 3, 5.2f, 1, 1, 1, 0, 0, -0.2f, -0.6f, 0.1f, -0.2f, -0.6f, -0.4f, -0.6f, 0, 0, -0.3f, 0, 0, 0, -0.4f, 0.6f, 0, -0.4f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(20, -5, 0).setRotationAngle(0, 0, 0).setName("Box 138")
		);
		door_hood.add(new ModelRendererTurbo(door_hood, 369, 57, textureX, textureY)
			.addShapeBox(28, 3, -6.2f, 1, 1, 1, 0, 0, -0.3f, 0, -0.4f, -0.6f, 0, 0.1f, -0.2f, -0.6f, 0, -0.2f, -0.6f, 0, 0, 0, 0, 0, 0, 0.6f, 0, -0.4f, 0, 0, -0.4f)
			.setRotationPoint(20, -5, 0).setRotationAngle(0, 0, 0).setName("Box 139")
		);
		door_hood.add(new ModelRendererTurbo(door_hood, 409, 57, textureX, textureY)
			.addShapeBox(28, 2.5f, 5.8f, 1, 1, 1, 0, 0, -0.2f, 0, -0.9f, -0.2f, 0, -0.9f, -0.2f, -0.9f, 0, -0.2f, -0.8f, 0, -0.4f, 0, 0.1f, -0.3f, 0, -0.4f, 0.1f, -0.6f, 0, -0.2f, -0.6f)
			.setRotationPoint(20, -5, 0).setRotationAngle(0, 0, 0).setName("Box 140")
		);
		door_hood.add(new ModelRendererTurbo(door_hood, 441, 57, textureX, textureY)
			.addShapeBox(28, 2.5f, -6.8f, 1, 1, 1, 0, 0, -0.2f, -0.8f, -0.9f, -0.2f, -0.9f, -0.9f, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, -0.6f, -0.4f, 0.1f, -0.6f, 0.1f, -0.3f, 0, 0, -0.4f, 0)
			.setRotationPoint(20, -5, 0).setRotationAngle(0, 0, 0).setName("Box 141")
		);
		door_hood.addPrograms(DefaultPrograms.RGB_PRIMARY, new GeneralPrograms.CustomMultiDoorHood(-60, 2, true));
		this.groups.add(door_hood);
	}

}