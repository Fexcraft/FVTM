//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.part.t2;

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
@fModel(registryname = "fvp:models/part/t2_doors")
public class T2Doors extends PartModel {

	public T2Doors(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList door_left = new TurboList("door_left");
		door_left.add(new ModelRendererTurbo(door_left, 425, 89, textureX, textureY)
			.addShapeBox(-26, -20, -1, 3, 20, 2, 0, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(64, -32, 25).setRotationAngle(0, 0, 0).setName("Box 230")
		);
		door_left.add(new ModelRendererTurbo(door_left, 209, 49, textureX, textureY)
			.addShapeBox(-2, -10, -1, 2, 10, 2, 0, 0.25f, 0, 0.25f, -0.25f, 0, 0.25f, -0.25f, 0, -0.25f, 0.25f, 0, -0.25f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(64, -32, 25).setRotationAngle(0, 0, 0).setName("Box 231")
		);
		door_left.add(new ModelRendererTurbo(door_left, 233, 57, textureX, textureY)
			.addShapeBox(-2, -20, -1, 2, 10, 2, 0, 2, 0, 0.5f, -2, 0, 0.5f, -2, 0, -0.5f, 2, 0, -0.5f, 0.25f, 0, 0.25f, -0.25f, 0, 0.25f, -0.25f, 0, -0.25f, 0.25f, 0, -0.25f)
			.setRotationPoint(64, -32, 25).setRotationAngle(0, 0, 0).setName("Box 232")
		);
		door_left.add(new ModelRendererTurbo(door_left, 1, 129, textureX, textureY)
			.addShapeBox(-23, -20, -1, 19, 2, 2, 0, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0.45f, 0.4f, 0, 0.45f, 0.4f, 0, -0.45f, 0, 0, -0.45f)
			.setRotationPoint(64, -32, 25).setRotationAngle(0, 0, 0).setName("Box 233")
		);
		door_left.add(new ModelRendererTurbo(door_left, 1, 97, textureX, textureY).addBox(-16, 2, -1.5f, 3, 1, 3)
			.setRotationPoint(64, -32, 25).setRotationAngle(0, 0, 0).setName("Box 333")
		);
		door_left.add(new ModelRendererTurbo(door_left, 0, 0, textureX, textureY)
			.addShapeBox(-26, -20, -1, 26, 13, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(64, -12, 25).setRotationAngle(0, 0, 0).setName("Box 237cp")
		);
		door_left.addPrograms(DefaultPrograms.RGB_PRIMARY, new GeneralPrograms.CustomMultiDoorFrontLeft(80, 1, true));
		this.groups.add(door_left);
		//
		TurboList door_right = new TurboList("door_right");
		door_right.add(new ModelRendererTurbo(door_right, 1, 73, textureX, textureY)
			.addShapeBox(-2, -10, -1, 2, 10, 2, 0, 0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, 0.25f, 0.25f, 0, 0.25f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(64, -32, -25).setRotationAngle(0, 0, 0).setName("Box 235")
		);
		door_right.add(new ModelRendererTurbo(door_right, 65, 73, textureX, textureY)
			.addShapeBox(-2, -20, -1, 2, 10, 2, 0, 2, 0, -0.5f, -2, 0, -0.5f, -2, 0, 0.5f, 2, 0, 0.5f, 0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, 0.25f, 0.25f, 0, 0.25f)
			.setRotationPoint(64, -32, -25).setRotationAngle(0, 0, 0).setName("Box 236")
		);
		door_right.add(new ModelRendererTurbo(door_right, 241, 185, textureX, textureY)
			.addShapeBox(-23, -20, -1, 19, 2, 2, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, -0.45f, 0.4f, 0, -0.45f, 0.4f, 0, 0.45f, 0, 0, 0.45f)
			.setRotationPoint(64, -32, -25).setRotationAngle(0, 0, 0).setName("Box 237")
		);
		door_right.add(new ModelRendererTurbo(door_right, 329, 129, textureX, textureY)
			.addShapeBox(-26, -20, -1, 3, 20, 2, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(64, -32, -25).setRotationAngle(0, 0, 0).setName("Box 238")
		);
		door_right.add(new ModelRendererTurbo(door_right, 241, 97, textureX, textureY).addBox(-16, 2, -1.5f, 3, 1, 3)
			.setRotationPoint(64, -32, -25).setRotationAngle(0, 0, 0).setName("Box 334")
		);
		door_right.add(new ModelRendererTurbo(door_right, 102, 327, textureX, textureY)
			.addShapeBox(-26, -20, -1, 26, 13, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(64, -12, -25).setRotationAngle(0, 0, 0).setName("Box 237cp")
		);
		door_right.addPrograms(DefaultPrograms.RGB_PRIMARY, new GeneralPrograms.CustomMultiDoorFrontRight(-80, 1, true));
		this.groups.add(door_right);
	}

}