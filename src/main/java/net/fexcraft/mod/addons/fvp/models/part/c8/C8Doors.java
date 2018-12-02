//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.part.c8;

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
@fModel(registryname = "fvp:models/part/c8_doors")
public class C8Doors extends PartModel {

	public C8Doors(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList door_front_left = new TurboList("door_front_left");
		door_front_left.add(new ModelRendererTurbo(door_front_left, 266, 33, textureX, textureY).addBox(-22, 0, 0, 22, 10, 1)
			.setRotationPoint(25, -9, 21).setRotationAngle(0, 0, 0).setName("Box 241")
		);
		door_front_left.add(new ModelRendererTurbo(door_front_left, 0, 52, textureX, textureY)
			.addShapeBox(-22, 0, -1, 16, 10, 1, 0, 0, 0, 0, 0, 0, -0.9f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.9f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(25, -9, 21).setRotationAngle(0, 0, 0).setName("Box 242")
		);
		door_front_left.add(new ModelRendererTurbo(door_front_left, 234, 29, textureX, textureY)
			.addShapeBox(-22, -2, 0, 22, 2, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(25, -9, 21).setRotationAngle(0, 0, 0).setName("Box 243")
		);
		door_front_left.add(new ModelRendererTurbo(door_front_left, 418, 96, textureX, textureY)
			.addShapeBox(-22, -13, -2, 1, 11, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 1)
			.setRotationPoint(25, -9, 21).setRotationAngle(0, 0, 0).setName("Box 244")
		);
		door_front_left.add(new ModelRendererTurbo(door_front_left, 413, 96, textureX, textureY)
			.addShapeBox(-10, -13, -2, 1, 11, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1.6f, 0, 0, -1.6f, 0, 0, 1.5f, 0, 0, 1.5f)
			.setRotationPoint(25, -9, 21).setRotationAngle(0, 0, 0).setName("Box 245")
		);
		door_front_left.add(new ModelRendererTurbo(door_front_left, 399, 96, textureX, textureY)
			.addShapeBox(-10, -13, -2, 1, 11, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -9.1f, -1, -1.7f, 9.1f, -1, -1.7f, 9.1f, -1, 1.7f, -9.1f, -1, 1.7f)
			.setRotationPoint(25, -9, 21).setRotationAngle(0, 0, 0).setName("Box 246")
		);
		door_front_left.add(new ModelRendererTurbo(door_front_left, 313, 31, textureX, textureY)
			.addShapeBox(-3, -5, 0, 3, 3, 1, 0, 0, 0.3f, 0.7f, 0, -1, 0.4f, 0, -1.9f, -0.3f, 0, 0.3f, -0.7f, 0, 0, 0.2f, 0, 0, 0.2f, 0, 0, 0, 0, 0, -0.1f)
			.setRotationPoint(25, -9, 21).setRotationAngle(0, 0, 0).setName("Box 247")
		);
		door_front_left.add(new ModelRendererTurbo(door_front_left, 396, 8, textureX, textureY)
			.addShapeBox(-22, -13, -2, 13, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.1f, 0, 0, 0.1f)
			.setRotationPoint(25, -9, 21).setRotationAngle(0, 0, 0).setName("Box 248")
		);
		door_front_left.addPrograms(DefaultPrograms.RGB_PRIMARY, new GeneralPrograms.CustomMultiDoorFrontLeft(60, 1, true));
		this.groups.add(door_front_left);
		//
		TurboList door_front_right = new TurboList("door_front_right");
		door_front_right.add(new ModelRendererTurbo(door_front_right, 234, 17, textureX, textureY).addBox(-22, 0, -1, 22, 10, 1)
			.setRotationPoint(25, -9, -21).setRotationAngle(0, 0, 0).setName("Box 236")
		);
		door_front_right.add(new ModelRendererTurbo(door_front_right, 234, 13, textureX, textureY)
			.addShapeBox(-22, -2, -1, 22, 2, 1, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1)
			.setRotationPoint(25, -9, -21).setRotationAngle(0, 0, 0).setName("Box 238")
		);
		door_front_right.add(new ModelRendererTurbo(door_front_right, 394, 96, textureX, textureY)
			.addShapeBox(-22, -13, 1, 1, 11, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(25, -9, -21).setRotationAngle(0, 0, 0).setName("Box 239")
		);
		door_front_right.add(new ModelRendererTurbo(door_front_right, 507, 85, textureX, textureY)
			.addShapeBox(-10, -13, 1, 1, 11, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1.5f, 0, 0, 1.5f, 0, 0, -1.6f, 0, 0, -1.6f)
			.setRotationPoint(25, -9, -21).setRotationAngle(0, 0, 0).setName("Box 240")
		);
		door_front_right.add(new ModelRendererTurbo(door_front_right, 63, 85, textureX, textureY)
			.addShapeBox(-10, -13, 1, 1, 11, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -9.1f, -1, 1.7f, 9.1f, -1, 1.7f, 9.1f, -1, -1.7f, -9.1f, -1, -1.7f)
			.setRotationPoint(25, -9, -21).setRotationAngle(0, 0, 0).setName("Box 241")
		);
		door_front_right.add(new ModelRendererTurbo(door_front_right, 314, 26, textureX, textureY)
			.addShapeBox(-3, -5, -1, 3, 3, 1, 0, 0, 0.3f, -0.7f, 0, -1.9f, -0.3f, 0, -1, 0.4f, 0, 0.3f, 0.7f, 0, 0, -0.1f, 0, 0, 0, 0, 0, 0.2f, 0, 0, 0.2f)
			.setRotationPoint(25, -9, -21).setRotationAngle(0, 0, 0).setName("Box 242")
		);
		door_front_right.add(new ModelRendererTurbo(door_front_right, 0, 6, textureX, textureY)
			.addShapeBox(-22, -13, 1, 13, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(25, -9, -21).setRotationAngle(0, 0, 0).setName("Box 243")
		);
		door_front_right.add(new ModelRendererTurbo(door_front_right, 451, 51, textureX, textureY)
			.addShapeBox(-22, 0, 0, 16, 10, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.9f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.9f, 0, 0, 0)
			.setRotationPoint(25, -9, -21).setRotationAngle(0, 0, 0).setName("Box 237")
		);
		door_front_right.addPrograms(DefaultPrograms.RGB_PRIMARY, new GeneralPrograms.CustomMultiDoorFrontRight(-60, 1, true));
		this.groups.add(door_front_right);
		//
		TurboList door_hood = new TurboList("door_hood");
		door_hood.add(new ModelRendererTurbo(door_hood, 396, 8, textureX, textureY)
			.addShapeBox(0, 0, -16, 22, 1, 32, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(29, -10, 0).setRotationAngle(0, 0, 0).setName("Box 125")
		);
		door_hood.add(new ModelRendererTurbo(door_hood, 21, 59, textureX, textureY)
			.addShapeBox(6, 0, -7, 12, 1, 14, 0, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(29, -10.5f, 0).setRotationAngle(0, 0, 0).setName("Box 126")
		);
		door_hood.addPrograms(DefaultPrograms.RGB_PRIMARY, new GeneralPrograms.CustomMultiDoorHood(-70, 2, true));
		this.groups.add(door_hood);
		//
		TurboList door_rear_left = new TurboList("door_rear_left");
		door_rear_left.add(new ModelRendererTurbo(door_rear_left, 473, 18, textureX, textureY).addBox(-17, 0, 0, 17, 10, 2)
			.setRotationPoint(1, -9, 20).setRotationAngle(0, 0, 0).setName("Box 246")
		);
		door_rear_left.add(new ModelRendererTurbo(door_rear_left, 473, 13, textureX, textureY)
			.addShapeBox(-17, -2, 0, 17, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(1, -9, 20).setRotationAngle(0, 0, 0).setName("Box 247")
		);
		door_rear_left.add(new ModelRendererTurbo(door_rear_left, 58, 85, textureX, textureY)
			.addShapeBox(-1, -13, -1, 1, 11, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 1)
			.setRotationPoint(1, -9, 20).setRotationAngle(0, 0, 0).setName("Box 248")
		);
		door_rear_left.add(new ModelRendererTurbo(door_rear_left, 18, 85, textureX, textureY)
			.addShapeBox(-17, -13, -1, 1, 11, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 1)
			.setRotationPoint(1, -9, 20).setRotationAngle(0, 0, 0).setName("Box 249")
		);
		door_rear_left.add(new ModelRendererTurbo(door_rear_left, 281, 29, textureX, textureY)
			.addShapeBox(-16, -13, -1, 15, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.1f, 0, 0, 0.1f)
			.setRotationPoint(1, -9, 20).setRotationAngle(0, 0, 0).setName("Box 250")
		);
		door_rear_left.addPrograms(DefaultPrograms.RGB_PRIMARY, new GeneralPrograms.CustomMultiDoorBackLeft(60, 1, true));
		this.groups.add(door_rear_left);
		//
		TurboList door_rear_right = new TurboList("door_rear_right");
		door_rear_right.add(new ModelRendererTurbo(door_rear_right, 281, 13, textureX, textureY).addBox(-17, 0, -2, 17, 10, 2)
			.setRotationPoint(1, -9, -20).setRotationAngle(0, 0, 0).setName("Box 251")
		);
		door_rear_right.add(new ModelRendererTurbo(door_rear_right, 473, 8, textureX, textureY)
			.addShapeBox(-17, -2, -2, 17, 2, 2, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(1, -9, -20).setRotationAngle(0, 0, 0).setName("Box 252")
		);
		door_rear_right.add(new ModelRendererTurbo(door_rear_right, 13, 85, textureX, textureY)
			.addShapeBox(-1, -13, 0, 1, 11, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(1, -9, -20).setRotationAngle(0, 0, 0).setName("Box 253")
		);
		door_rear_right.add(new ModelRendererTurbo(door_rear_right, 253, 81, textureX, textureY)
			.addShapeBox(-17, -13, 0, 1, 11, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(1, -9, -20).setRotationAngle(0, 0, 0).setName("Box 254")
		);
		door_rear_right.add(new ModelRendererTurbo(door_rear_right, 281, 26, textureX, textureY)
			.addShapeBox(-16, -13, 0, 15, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(1, -9, -20).setRotationAngle(0, 0, 0).setName("Box 255")
		);
		door_rear_right.addPrograms(DefaultPrograms.RGB_PRIMARY, new GeneralPrograms.CustomMultiDoorBackRight(-60, 1, true));
		this.groups.add(door_rear_right);
		//
		TurboList door_trunk = new TurboList("door_trunk");
		door_trunk.add(new ModelRendererTurbo(door_trunk, 396, 130, textureX, textureY)
			.addShapeBox(-26, 2, -16, 2, 3, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0)
			.setRotationPoint(-31, -11, 0).setRotationAngle(0, 0, 0).setName("Box 104")
		);
		door_trunk.add(new ModelRendererTurbo(door_trunk, 310, 166, textureX, textureY).addBox(-25, 5, -16, 1, 4, 32)
			.setRotationPoint(-31, -11, 0).setRotationAngle(0, 0, 0).setName("Box 105")
		);
		door_trunk.add(new ModelRendererTurbo(door_trunk, 192, 82, textureX, textureY).addBox(-25.2f, 5.5f, -6, 1, 3, 12)
			.setRotationPoint(-31, -11, 0).setRotationAngle(0, 0, 0).setName("Box 112")
		);
		door_trunk.add(new ModelRendererTurbo(door_trunk, 149, 11, textureX, textureY)
			.addShapeBox(-26, 0, -16, 26, 2, 32, 0, -1, 0, 0, 0, 1, 0, 0, 1, 0, -1, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(-31, -11, 0).setRotationAngle(0, 0, 0).setName("Box 116")
		);
		door_trunk.addPrograms(DefaultPrograms.RGB_PRIMARY, new GeneralPrograms.CustomMultiDoorTrunk(75, 2, true));
		this.groups.add(door_trunk);
	}

}