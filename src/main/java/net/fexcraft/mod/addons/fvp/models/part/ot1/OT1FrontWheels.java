//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.part.ot1;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.4-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/part/ot1_front_wheels")
public class OT1FrontWheels extends PartModel {

	public OT1FrontWheels(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList wheel_front_left = new TurboList("wheel_front_left");
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 1, 1, textureX, textureY).addBox(-2, -8, 0, 4, 16, 1)
			.setRotationPoint(65, 0, 18).setRotationAngle(0, 0, 0).setName("Box 01")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 17, 1, textureX, textureY).addBox(-8, -2, 0, 6, 4, 1)
			.setRotationPoint(65, 0, 18).setRotationAngle(0, 0, 0).setName("Box 02")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 49, 1, textureX, textureY).addBox(2, -2, 0, 6, 4, 1)
			.setRotationPoint(65, 0, 18).setRotationAngle(0, 0, 0).setName("Box 03")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 65, 1, textureX, textureY)
			.addShapeBox(-8, 2, 0, 3, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0)
			.setRotationPoint(65, 0, 18).setRotationAngle(0, 0, 0).setName("Box 04")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 81, 1, textureX, textureY)
			.addShapeBox(-5, 5, 0, 3, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0)
			.setRotationPoint(65, 0, 18).setRotationAngle(0, 0, 0).setName("Box 05")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 97, 1, textureX, textureY).addBox(-5, 2, 0, 3, 3, 1)
			.setRotationPoint(65, 0, 18).setRotationAngle(0, 0, 0).setName("Box 06")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 113, 1, textureX, textureY)
			.addShapeBox(-6, 5, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(65, 0, 18).setRotationAngle(0, 0, 0).setName("Box 07")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 121, 1, textureX, textureY).addBox(-5, -5, 0, 3, 3, 1)
			.setRotationPoint(65, 0, 18).setRotationAngle(0, 0, 0).setName("Box 08")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 137, 1, textureX, textureY)
			.addShapeBox(-8, -5, 0, 3, 3, 1, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(65, 0, 18).setRotationAngle(0, 0, 0).setName("Box 09")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 153, 1, textureX, textureY)
			.addShapeBox(-5, -8, 0, 3, 3, 1, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(65, 0, 18).setRotationAngle(0, 0, 0).setName("Box 10")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 169, 1, textureX, textureY)
			.addShapeBox(-6, -6, 0, 1, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(65, 0, 18).setRotationAngle(0, 0, 0).setName("Box 11")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 177, 1, textureX, textureY).addBox(2, -5, 0, 3, 3, 1)
			.setRotationPoint(65, 0, 18).setRotationAngle(0, 0, 0).setName("Box 12")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 193, 1, textureX, textureY).addBox(2, 2, 0, 3, 3, 1)
			.setRotationPoint(65, 0, 18).setRotationAngle(0, 0, 0).setName("Box 13")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 209, 1, textureX, textureY)
			.addShapeBox(2, 5, 0, 3, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0)
			.setRotationPoint(65, 0, 18).setRotationAngle(0, 0, 0).setName("Box 14")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 225, 1, textureX, textureY)
			.addShapeBox(2, -8, 0, 3, 3, 1, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(65, 0, 18).setRotationAngle(0, 0, 0).setName("Box 15")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 241, 1, textureX, textureY)
			.addShapeBox(5, -5, 0, 3, 3, 1, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(65, 0, 18).setRotationAngle(0, 0, 0).setName("Box 16")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 257, 1, textureX, textureY)
			.addShapeBox(5, 2, 0, 3, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0)
			.setRotationPoint(65, 0, 18).setRotationAngle(0, 0, 0).setName("Box 17")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 273, 1, textureX, textureY)
			.addShapeBox(5, 5, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(65, 0, 18).setRotationAngle(0, 0, 0).setName("Box 18")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 281, 1, textureX, textureY)
			.addShapeBox(5, -6, 0, 1, 1, 1, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(65, 0, 18).setRotationAngle(0, 0, 0).setName("Box 19")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 289, 1, textureX, textureY).addBox(-2, 8, 0, 4, 2, 4)
			.setRotationPoint(65, 0, 17).setRotationAngle(0, 0, 0).setName("Box 20")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 313, 1, textureX, textureY).addBox(-2, -10, 0, 4, 2, 4)
			.setRotationPoint(65, 0, 17).setRotationAngle(0, 0, 0).setName("Box 21")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 337, 1, textureX, textureY).addBox(8, -2, 0, 2, 4, 4)
			.setRotationPoint(65, 0, 17).setRotationAngle(0, 0, 0).setName("Box 22")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 353, 1, textureX, textureY).addBox(-10, -2, 0, 2, 4, 4)
			.setRotationPoint(65, 0, 17).setRotationAngle(0, 0, 0).setName("Box 23")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 369, 1, textureX, textureY)
			.addShapeBox(2, 8, 0, 3, 2, 4, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, -1.5f, 0, 0, -1.5f, 0, 0, 0, 0)
			.setRotationPoint(65, 0, 17).setRotationAngle(0, 0, 0).setName("Box 24")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 385, 1, textureX, textureY)
			.addShapeBox(8, 2, 0, 2, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -1.5f, 0, 0, -1.5f, 0, 0, 2, 0, 0)
			.setRotationPoint(65, 0, 17).setRotationAngle(0, 0, 0).setName("Box 25")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 401, 1, textureX, textureY)
			.addShapeBox(5, 5, 0, 3, 3, 4, 0, 0, -1, 0, -2, 0, 0, -2, 0, 0, 0, -1, 0, 0, 0.5f, 0, 0.5f, -3, 0, 0.5f, -3, 0, 0, 0.5f, 0)
			.setRotationPoint(65, 0, 17).setRotationAngle(0, 0, 0).setName("Box 26")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 417, 1, textureX, textureY)
			.addShapeBox(-5, 8, 0, 3, 2, 4, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -1.5f, 0, 0, 0, 0, 0, 0, 0, 0, -1.5f, 0)
			.setRotationPoint(65, 0, 17).setRotationAngle(0, 0, 0).setName("Box 27")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 433, 1, textureX, textureY)
			.addShapeBox(-5, -10, 0, 3, 2, 4, 0, 0, -1.5f, 0, 0, 0, 0, 0, 0, 0, 0, -1.5f, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0)
			.setRotationPoint(65, 0, 17).setRotationAngle(0, 0, 0).setName("Box 28")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 449, 1, textureX, textureY)
			.addShapeBox(2, -10, 0, 3, 2, 4, 0, 0, 0, 0, 0, -1.5f, 0, 0, -1.5f, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0)
			.setRotationPoint(65, 0, 17).setRotationAngle(0, 0, 0).setName("Box 29")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 465, 1, textureX, textureY)
			.addShapeBox(8, -5, 0, 2, 3, 4, 0, 2, 0, 0, -1.5f, 0, 0, -1.5f, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(65, 0, 17).setRotationAngle(0, 0, 0).setName("Box 30")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 481, 1, textureX, textureY)
			.addShapeBox(-10, -5, 0, 2, 3, 4, 0, -1.5f, 0, 0, 2, 0, 0, 2, 0, 0, -1.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(65, 0, 17).setRotationAngle(0, 0, 0).setName("Box 31")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 497, 1, textureX, textureY)
			.addShapeBox(-10, 2, 0, 2, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1.5f, 0, 0, 2, 0, 0, 2, 0, 0, -1.5f, 0, 0)
			.setRotationPoint(65, 0, 17).setRotationAngle(0, 0, 0).setName("Box 32")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 17, 9, textureX, textureY)
			.addShapeBox(-8, 5, 0, 3, 3, 4, 0, -2, 0, 0, 0, -1, 0, 0, -1, 0, -2, 0, 0, 0.5f, -3, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0.5f, -3, 0)
			.setRotationPoint(65, 0, 17).setRotationAngle(0, 0, 0).setName("Box 33")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 49, 9, textureX, textureY)
			.addShapeBox(-8, -8, 0, 3, 3, 4, 0, 0.5f, -3, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0.5f, -3, 0, -2, 0, 0, 0, -1, 0, 0, -1, 0, -2, 0, 0)
			.setRotationPoint(65, 0, 17).setRotationAngle(0, 0, 0).setName("Box 34")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 65, 9, textureX, textureY)
			.addShapeBox(5, -8, 0, 3, 3, 4, 0, 0, 0.5f, 0, 0.5f, -3, 0, 0.5f, -3, 0, 0, 0.5f, 0, 0, -1, 0, -2, 0, 0, -2, 0, 0, 0, -1, 0)
			.setRotationPoint(65, 0, 17).setRotationAngle(0, 0, 0).setName("Box 35")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 281, 193, textureX, textureY).addBox(-2, -6, 1, 4, 12, 1)
			.setRotationPoint(65, 0, 18).setRotationAngle(0, 0, 0).setName("Box 334")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 169, 185, textureX, textureY).addBox(2, -2, 1, 4, 4, 1)
			.setRotationPoint(65, 0, 18).setRotationAngle(0, 0, 0).setName("Box 335")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 185, 185, textureX, textureY).addBox(-6, -2, 1, 4, 4, 1)
			.setRotationPoint(65, 0, 18).setRotationAngle(0, 0, 0).setName("Box 336")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 17, 193, textureX, textureY)
			.addShapeBox(2, 2, 1, 4, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, -4, 0, 0, 0, 0, 0)
			.setRotationPoint(65, 0, 18).setRotationAngle(0, 0, 0).setName("Box 337")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 257, 193, textureX, textureY)
			.addShapeBox(2, -6, 1, 4, 4, 1, 0, 0, 0, 0, -4, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(65, 0, 18).setRotationAngle(0, 0, 0).setName("Box 338")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 297, 193, textureX, textureY)
			.addShapeBox(-6, -6, 1, 4, 4, 1, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(65, 0, 18).setRotationAngle(0, 0, 0).setName("Box 339")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 313, 193, textureX, textureY)
			.addShapeBox(-6, 2, 1, 4, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0)
			.setRotationPoint(65, 0, 18).setRotationAngle(0, 0, 0).setName("Box 340")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 113, 65, textureX, textureY).addBox(1.5f, -4.5f, 1.2f, 1, 1, 1)
			.setRotationPoint(65, 0, 18).setRotationAngle(0, 0, 0).setName("Box 348")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 161, 65, textureX, textureY).addBox(-2.5f, -4.5f, 1.2f, 1, 1, 1)
			.setRotationPoint(65, 0, 18).setRotationAngle(0, 0, 0).setName("Box 349")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 169, 65, textureX, textureY).addBox(-2.5f, 3.5f, 1.2f, 1, 1, 1)
			.setRotationPoint(65, 0, 18).setRotationAngle(0, 0, 0).setName("Box 350")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 193, 65, textureX, textureY).addBox(1.5f, 3.5f, 1.2f, 1, 1, 1)
			.setRotationPoint(65, 0, 18).setRotationAngle(0, 0, 0).setName("Box 351")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 289, 73, textureX, textureY).addBox(3.5f, -2.5f, 1.2f, 1, 1, 1)
			.setRotationPoint(65, 0, 18).setRotationAngle(0, 0, 0).setName("Box 352")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 321, 73, textureX, textureY).addBox(3.5f, 1.5f, 1.2f, 1, 1, 1)
			.setRotationPoint(65, 0, 18).setRotationAngle(0, 0, 0).setName("Box 353")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 1, 81, textureX, textureY).addBox(-4.5f, 1.5f, 1.2f, 1, 1, 1)
			.setRotationPoint(65, 0, 18).setRotationAngle(0, 0, 0).setName("Box 354")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 49, 81, textureX, textureY).addBox(-4.5f, -2.5f, 1.2f, 1, 1, 1)
			.setRotationPoint(65, 0, 18).setRotationAngle(0, 0, 0).setName("Box 355")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 345, 201, textureX, textureY)
			.addShapeBox(-2, -2, 1.5f, 4, 4, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(65, 0, 18).setRotationAngle(0, 0, 0).setName("Box 364")
		);
		wheel_front_left.addProgram(DefaultPrograms.IMPORTED_WHEEL);
		this.groups.add(wheel_front_left);
		//
		TurboList wheel_front_right = new TurboList("wheel_front_right");
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 81, 9, textureX, textureY).addBox(-2, -8, -1, 4, 16, 1)
			.setRotationPoint(65, 0, -18).setRotationAngle(0, 0, 0).setName("Box 36")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 97, 9, textureX, textureY).addBox(-8, -2, -1, 6, 4, 1)
			.setRotationPoint(65, 0, -18).setRotationAngle(0, 0, 0).setName("Box 37")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 113, 9, textureX, textureY).addBox(2, -2, -1, 6, 4, 1)
			.setRotationPoint(65, 0, -18).setRotationAngle(0, 0, 0).setName("Box 38")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 129, 9, textureX, textureY).addBox(-5, 2, -1, 3, 3, 1)
			.setRotationPoint(65, 0, -18).setRotationAngle(0, 0, 0).setName("Box 39")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 145, 9, textureX, textureY).addBox(-5, -5, -1, 3, 3, 1)
			.setRotationPoint(65, 0, -18).setRotationAngle(0, 0, 0).setName("Box 40")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 161, 9, textureX, textureY).addBox(2, -5, -1, 3, 3, 1)
			.setRotationPoint(65, 0, -18).setRotationAngle(0, 0, 0).setName("Box 41")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 177, 9, textureX, textureY).addBox(2, 2, -1, 3, 3, 1)
			.setRotationPoint(65, 0, -18).setRotationAngle(0, 0, 0).setName("Box 42")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 193, 9, textureX, textureY)
			.addShapeBox(-5, 5, -1, 3, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0)
			.setRotationPoint(65, 0, -18).setRotationAngle(0, 0, 0).setName("Box 43")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 209, 9, textureX, textureY)
			.addShapeBox(-5, -8, -1, 3, 3, 1, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(65, 0, -18).setRotationAngle(0, 0, 0).setName("Box 44")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 225, 9, textureX, textureY)
			.addShapeBox(2, -8, -1, 3, 3, 1, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(65, 0, -18).setRotationAngle(0, 0, 0).setName("Box 45")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 241, 9, textureX, textureY)
			.addShapeBox(2, 5, -1, 3, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0)
			.setRotationPoint(65, 0, -18).setRotationAngle(0, 0, 0).setName("Box 46")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 257, 9, textureX, textureY)
			.addShapeBox(-8, 2, -1, 3, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0)
			.setRotationPoint(65, 0, -18).setRotationAngle(0, 0, 0).setName("Box 47")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 273, 9, textureX, textureY)
			.addShapeBox(-8, -5, -1, 3, 3, 1, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(65, 0, -18).setRotationAngle(0, 0, 0).setName("Box 48")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 289, 9, textureX, textureY)
			.addShapeBox(5, -5, -1, 3, 3, 1, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(65, 0, -18).setRotationAngle(0, 0, 0).setName("Box 49")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 305, 9, textureX, textureY)
			.addShapeBox(5, 2, -1, 3, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0)
			.setRotationPoint(65, 0, -18).setRotationAngle(0, 0, 0).setName("Box 50")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 305, 1, textureX, textureY)
			.addShapeBox(-6, 5, -1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(65, 0, -18).setRotationAngle(0, 0, 0).setName("Box 51")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 329, 1, textureX, textureY)
			.addShapeBox(-6, -6, -1, 1, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(65, 0, -18).setRotationAngle(0, 0, 0).setName("Box 52")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 321, 9, textureX, textureY)
			.addShapeBox(5, -6, -1, 1, 1, 1, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(65, 0, -18).setRotationAngle(0, 0, 0).setName("Box 53")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 329, 9, textureX, textureY)
			.addShapeBox(5, 5, -1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(65, 0, -18).setRotationAngle(0, 0, 0).setName("Box 54")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 369, 9, textureX, textureY).addBox(-2, 8, -4, 4, 2, 4)
			.setRotationPoint(65, 0, -17).setRotationAngle(0, 0, 0).setName("Box 55")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 393, 9, textureX, textureY).addBox(-2, -10, -4, 4, 2, 4)
			.setRotationPoint(65, 0, -17).setRotationAngle(0, 0, 0).setName("Box 56")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 417, 9, textureX, textureY).addBox(-10, -2, -4, 2, 4, 4)
			.setRotationPoint(65, 0, -17).setRotationAngle(0, 0, 0).setName("Box 57")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 433, 9, textureX, textureY).addBox(8, -2, -4, 2, 4, 4)
			.setRotationPoint(65, 0, -17).setRotationAngle(0, 0, 0).setName("Box 58")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 449, 9, textureX, textureY)
			.addShapeBox(-5, 8, -4, 3, 2, 4, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -1.5f, 0, 0, 0, 0, 0, 0, 0, 0, -1.5f, 0)
			.setRotationPoint(65, 0, -17).setRotationAngle(0, 0, 0).setName("Box 59")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 465, 9, textureX, textureY)
			.addShapeBox(-5, -10, -4, 3, 2, 4, 0, 0, -1.5f, 0, 0, 0, 0, 0, 0, 0, 0, -1.5f, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0)
			.setRotationPoint(65, 0, -17).setRotationAngle(0, 0, 0).setName("Box 60")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 481, 9, textureX, textureY)
			.addShapeBox(2, -10, -4, 3, 2, 4, 0, 0, 0, 0, 0, -1.5f, 0, 0, -1.5f, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0)
			.setRotationPoint(65, 0, -17).setRotationAngle(0, 0, 0).setName("Box 61")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 497, 9, textureX, textureY)
			.addShapeBox(2, 8, -4, 3, 2, 4, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, -1.5f, 0, 0, -1.5f, 0, 0, 0, 0)
			.setRotationPoint(65, 0, -17).setRotationAngle(0, 0, 0).setName("Box 62")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 9, 17, textureX, textureY)
			.addShapeBox(-10, 2, -4, 2, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1.5f, 0, 0, 2, 0, 0, 2, 0, 0, -1.5f, 0, 0)
			.setRotationPoint(65, 0, -17).setRotationAngle(0, 0, 0).setName("Box 63")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 49, 17, textureX, textureY)
			.addShapeBox(-10, -5, -4, 2, 3, 4, 0, -1.5f, 0, 0, 2, 0, 0, 2, 0, 0, -1.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(65, 0, -17).setRotationAngle(0, 0, 0).setName("Box 64")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 65, 17, textureX, textureY)
			.addShapeBox(8, -5, -4, 2, 3, 4, 0, 2, 0, 0, -1.5f, 0, 0, -1.5f, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(65, 0, -17).setRotationAngle(0, 0, 0).setName("Box 65")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 97, 17, textureX, textureY)
			.addShapeBox(8, 2, -4, 2, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -1.5f, 0, 0, -1.5f, 0, 0, 2, 0, 0)
			.setRotationPoint(65, 0, -17).setRotationAngle(0, 0, 0).setName("Box 66")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 113, 17, textureX, textureY)
			.addShapeBox(-8, 5, -4, 3, 3, 4, 0, -2, 0, 0, 0, -1, 0, 0, -1, 0, -2, 0, 0, 0.5f, -3, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0.5f, -3, 0)
			.setRotationPoint(65, 0, -17).setRotationAngle(0, 0, 0).setName("Box 67")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 129, 17, textureX, textureY)
			.addShapeBox(-8, -8, -4, 3, 3, 4, 0, 0.5f, -3, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0.5f, -3, 0, -2, 0, 0, 0, -1, 0, 0, -1, 0, -2, 0, 0)
			.setRotationPoint(65, 0, -17).setRotationAngle(0, 0, 0).setName("Box 68")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 145, 17, textureX, textureY)
			.addShapeBox(5, -8, -4, 3, 3, 4, 0, 0, 0.5f, 0, 0.5f, -3, 0, 0.5f, -3, 0, 0, 0.5f, 0, 0, -1, 0, -2, 0, 0, -2, 0, 0, 0, -1, 0)
			.setRotationPoint(65, 0, -17).setRotationAngle(0, 0, 0).setName("Box 69")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 161, 17, textureX, textureY)
			.addShapeBox(5, 5, -4, 3, 3, 4, 0, 0, -1, 0, -2, 0, 0, -2, 0, 0, 0, -1, 0, 0, 0.5f, 0, 0.5f, -3, 0, 0.5f, -3, 0, 0, 0.5f, 0)
			.setRotationPoint(65, 0, -17).setRotationAngle(0, 0, 0).setName("Box 70")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 329, 193, textureX, textureY).addBox(-2, -6, -2, 4, 12, 1)
			.setRotationPoint(65, 0, -18).setRotationAngle(0, 0, 0).setName("Box 341")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 345, 193, textureX, textureY).addBox(-6, -2, -2, 4, 4, 1)
			.setRotationPoint(65, 0, -18).setRotationAngle(0, 0, 0).setName("Box 342")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 361, 193, textureX, textureY).addBox(2, -2, -2, 4, 4, 1)
			.setRotationPoint(65, 0, -18).setRotationAngle(0, 0, 0).setName("Box 343")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 377, 193, textureX, textureY)
			.addShapeBox(-6, -6, -2, 4, 4, 1, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(65, 0, -18).setRotationAngle(0, 0, 0).setName("Box 344")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 393, 193, textureX, textureY)
			.addShapeBox(-6, 2, -2, 4, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0)
			.setRotationPoint(65, 0, -18).setRotationAngle(0, 0, 0).setName("Box 345")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 297, 201, textureX, textureY)
			.addShapeBox(2, 2, -2, 4, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, -4, 0, 0, 0, 0, 0)
			.setRotationPoint(65, 0, -18).setRotationAngle(0, 0, 0).setName("Box 346")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 313, 201, textureX, textureY)
			.addShapeBox(2, -6, -2, 4, 4, 1, 0, 0, 0, 0, -4, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(65, 0, -18).setRotationAngle(0, 0, 0).setName("Box 347")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 193, 81, textureX, textureY).addBox(-4.5f, -2.5f, -2.2f, 1, 1, 1)
			.setRotationPoint(65, 0, -18).setRotationAngle(0, 0, 0).setName("Box 356")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 209, 81, textureX, textureY).addBox(-2.5f, -4.5f, -2.2f, 1, 1, 1)
			.setRotationPoint(65, 0, -18).setRotationAngle(0, 0, 0).setName("Box 357")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 129, 89, textureX, textureY).addBox(1.5f, -4.5f, -2.2f, 1, 1, 1)
			.setRotationPoint(65, 0, -18).setRotationAngle(0, 0, 0).setName("Box 358")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 137, 89, textureX, textureY).addBox(1.5f, 3.5f, -2.2f, 1, 1, 1)
			.setRotationPoint(65, 0, -18).setRotationAngle(0, 0, 0).setName("Box 359")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 145, 89, textureX, textureY).addBox(-2.5f, 3.5f, -2.2f, 1, 1, 1)
			.setRotationPoint(65, 0, -18).setRotationAngle(0, 0, 0).setName("Box 360")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 153, 89, textureX, textureY).addBox(-4.5f, 1.5f, -2.2f, 1, 1, 1)
			.setRotationPoint(65, 0, -18).setRotationAngle(0, 0, 0).setName("Box 361")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 161, 89, textureX, textureY).addBox(3.5f, 1.5f, -2.2f, 1, 1, 1)
			.setRotationPoint(65, 0, -18).setRotationAngle(0, 0, 0).setName("Box 362")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 169, 89, textureX, textureY).addBox(3.5f, -2.5f, -2.2f, 1, 1, 1)
			.setRotationPoint(65, 0, -18).setRotationAngle(0, 0, 0).setName("Box 363")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 361, 201, textureX, textureY)
			.addShapeBox(-2, -2, -2.5f, 4, 4, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0)
			.setRotationPoint(65, 0, -18).setRotationAngle(0, 0, 0).setName("Box 365")
		);
		wheel_front_right.addProgram(DefaultPrograms.IMPORTED_WHEEL);
		this.groups.add(wheel_front_right);
	}

}