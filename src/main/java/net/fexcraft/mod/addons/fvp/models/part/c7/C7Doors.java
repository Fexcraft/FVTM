//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.part.c7;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.addons.gep.models.GeneralPrograms;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.1-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/part/c7_doors")
public class C7Doors extends PartModel {

	public C7Doors(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList door_front_left = new TurboList("door_front_left");
		door_front_left.add(new ModelRendererTurbo(door_front_left, 57, 145, textureX, textureY)
			.addShapeBox(-16, 0, -1, 17, 11, 1, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, -1, 0, -1, 0, 0, -1, 0, 0, 1, -1, 0, 1)
			.setRotationPoint(15, -15, 17).setRotationAngle(0, 0, 0).setName("Box 242")
		);
		door_front_left.add(new ModelRendererTurbo(door_front_left, 129, 153, textureX, textureY)
			.addShapeBox(-16, -2, -1, 17, 1, 1, 0, 0, -0.9f, 0, 0, -2, -0.5f, 0, -2.9f, 0, 0, -0.9f, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0)
			.setRotationPoint(15, -14, 17).setRotationAngle(0, 0, 0).setName("Box 243")
		);
		door_front_left.add(new ModelRendererTurbo(door_front_left, 57, 49, textureX, textureY).addBox(-15, 0, -0.5f, 3, 1, 1)
			.setRotationPoint(15, -12, 17).setRotationAngle(0, 0, 0).setName("Box 248")
		);
		door_front_left.addPrograms(DefaultPrograms.RGB_PRIMARY, new GeneralPrograms.CustomMultiDoorFrontLeft(60, 1, true));
		this.groups.add(door_front_left);
		//
		TurboList door_front_right = new TurboList("door_front_right");
		door_front_right.add(new ModelRendererTurbo(door_front_right, 225, 153, textureX, textureY)
			.addShapeBox(-16, 0, -1, 17, 11, 1, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, -1, 0, 1, 0, 0, 1, 0, 0, -1, -1, 0, -1)
			.setRotationPoint(15, -15, -16).setRotationAngle(0, 0, 0).setName("Box 244")
		);
		door_front_right.add(new ModelRendererTurbo(door_front_right, 265, 153, textureX, textureY)
			.addShapeBox(-16, -2, -1, 17, 1, 1, 0, 0, -0.9f, 0, 0, -2.9f, 0, 0, -2, -0.5f, 0, -0.9f, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0)
			.setRotationPoint(15, -14, -16).setRotationAngle(0, 0, 0).setName("Box 245")
		);
		door_front_right.add(new ModelRendererTurbo(door_front_right, 73, 49, textureX, textureY).addBox(-15, 0, -1.5f, 3, 1, 1)
			.setRotationPoint(15, -12, -16).setRotationAngle(0, 0, 0).setName("Box 249")
		);
		door_front_right.addPrograms(DefaultPrograms.RGB_PRIMARY, new GeneralPrograms.CustomMultiDoorFrontRight(-60, 1, true));
		this.groups.add(door_front_right);
		//
		TurboList door_rear_left = new TurboList("door_rear_left");
		door_rear_left.add(new ModelRendererTurbo(door_rear_left, 305, 153, textureX, textureY)
			.addShapeBox(-17, 0, 1, 18, 11, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, 0, 0, -1, 0, 0, 1, -1, 0, 1)
			.setRotationPoint(-5, -15, 15).setRotationAngle(0, 0, 0).setName("Box 246")
		);
		door_rear_left.add(new ModelRendererTurbo(door_rear_left, 105, 49, textureX, textureY).addBox(-14, 0, 1.5f, 3, 1, 1)
			.setRotationPoint(-5, -12, 15).setRotationAngle(0, 0, 0).setName("Box 250")
		);
		door_rear_left.addPrograms(DefaultPrograms.RGB_PRIMARY, new GeneralPrograms.CustomMultiDoorBackLeft(60, 1, true));
		this.groups.add(door_rear_left);
		//
		TurboList door_rear_right = new TurboList("door_rear_right");
		door_rear_right.add(new ModelRendererTurbo(door_rear_right, 345, 153, textureX, textureY)
			.addShapeBox(-17, 0, 1, 18, 11, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 1, 0, 0, 1, 0, 0, -1, -1, 0, -1)
			.setRotationPoint(-5, -15, -18).setRotationAngle(0, 0, 0).setName("Box 247")
		);
		door_rear_right.add(new ModelRendererTurbo(door_rear_right, 321, 49, textureX, textureY).addBox(-14, 0, 0.5f, 3, 1, 1)
			.setRotationPoint(-5, -12, -18).setRotationAngle(0, 0, 0).setName("Box 251")
		);
		door_rear_right.addPrograms(DefaultPrograms.RGB_PRIMARY, new GeneralPrograms.CustomMultiDoorBackRight(-60, 1, true));
		this.groups.add(door_rear_right);
		//
		TurboList door_trunk = new TurboList("door_trunk");
		door_trunk.add(new ModelRendererTurbo(door_trunk, 425, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 11, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4.5f, 0, -1, -4, 0, -1, -4, 0, 1, 4.5f, 0, 1)
			.setRotationPoint(-41, -26, 13).setRotationAngle(0, 0, -88.10422f).setName("Box 255")
		);
		door_trunk.add(new ModelRendererTurbo(door_trunk, 25, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 11, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4.5f, 0, 1, -4, 0, 1, -4, 0, -1, 4.5f, 0, -1)
			.setRotationPoint(-41, -26, -14).setRotationAngle(0, 0, -88.10422f).setName("Box 256")
		);
		door_trunk.addProgram(new GeneralPrograms.CustomMultiDoorTrunk(100, 2, true));
		this.groups.add(door_trunk);
		//
		TurboList door_trunk_primary = new TurboList("door_trunk_primary");
		door_trunk_primary.add(new ModelRendererTurbo(door_trunk_primary, 145, 153, textureX, textureY).addBox(-5, 11, 0, 2, 10, 28)
			.setRotationPoint(-41, -26, -14).setRotationAngle(0, 0, 0).setName("Box 252")
		);
		door_trunk_primary.add(new ModelRendererTurbo(door_trunk_primary, 361, 153, textureX, textureY)
			.addShapeBox(-3, 11, 0, 1, 1, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.9f, 0, 0, -0.9f, 0, 0, 0, 0, 0)
			.setRotationPoint(-41, -26, -15).setRotationAngle(0, 0, 0).setName("Box 253")
		);
		door_trunk_primary.add(new ModelRendererTurbo(door_trunk_primary, 193, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 26, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0)
			.setRotationPoint(-41, -26, -13).setRotationAngle(0, 0, 0).setName("Box 254")
		);
		door_trunk_primary.add(new ModelRendererTurbo(door_trunk_primary, 233, 1, textureX, textureY)
			.addShapeBox(-6, 13, 4, 1, 1, 12, 0, -0.5f, -0.4f, -0.5f, 0, 0, 0, 0, 0, 0, -0.5f, -0.4f, -0.5f, -0.5f, 0, -0.5f, 0, 0, 0, 0, 0, 0, -0.5f, 0, -0.5f)
			.setRotationPoint(-41, -26, -10).setRotationAngle(0, 0, 0).setName("Box 257")
		);
		door_trunk_primary.add(new ModelRendererTurbo(door_trunk_primary, 425, 145, textureX, textureY)
			.addShapeBox(-6, 13, 4, 1, 3, 10, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0)
			.setRotationPoint(-41, -25, -9).setRotationAngle(0, 0, 0).setName("Box 258")
		);
		door_trunk_primary.addPrograms(DefaultPrograms.RGB_PRIMARY, new GeneralPrograms.CustomMultiDoorTrunk(100, 2, true));
		this.groups.add(door_trunk_primary);
	}

}