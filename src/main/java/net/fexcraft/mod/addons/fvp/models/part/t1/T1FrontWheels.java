//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.part.t1;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.4-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/part/t1_front_wheels")
public class T1FrontWheels extends PartModel {

	public T1FrontWheels(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList wheel_front_left = new TurboList("wheel_front_left");
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 185, 1, textureX, textureY).addBox(-3, -8, 0, 6, 5, 1)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 12")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 89, 9, textureX, textureY).addBox(-8, -3, 0, 16, 6, 1)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 13")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 345, 1, textureX, textureY).addBox(-10, -3, -0.5f, 2, 6, 6)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 14")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 217, 1, textureX, textureY).addBox(-3, 3, 0, 6, 5, 1)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 15")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 1, 9, textureX, textureY).addBox(8, -3, -0.5f, 2, 6, 6)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 16")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 129, 9, textureX, textureY).addBox(-3, 8, -0.5f, 6, 2, 6)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 17")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 89, 17, textureX, textureY).addBox(-3, -10, -0.5f, 6, 2, 6)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 18")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 249, 1, textureX, textureY)
			.addShapeBox(3, 8, -0.5f, 3, 2, 6, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 19")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 401, 1, textureX, textureY)
			.addShapeBox(8, 3, -0.5f, 2, 3, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -2, 0, 0, -2, 0, 0, 2, 0, 0)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 20")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 433, 1, textureX, textureY)
			.addShapeBox(6, 6, -0.5f, 2, 2, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 21")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 465, 1, textureX, textureY)
			.addShapeBox(8, -6, -0.5f, 2, 3, 6, 0, 2, 0, 0, -2, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 22")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 377, 17, textureX, textureY)
			.addShapeBox(3, -10, -0.5f, 3, 2, 6, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 23")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 401, 17, textureX, textureY)
			.addShapeBox(6, -8, -0.5f, 2, 2, 6, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 24")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 425, 17, textureX, textureY)
			.addShapeBox(-6, -10, -0.5f, 3, 2, 6, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 25")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 449, 17, textureX, textureY)
			.addShapeBox(-10, -6, -0.5f, 2, 3, 6, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 26")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 473, 17, textureX, textureY)
			.addShapeBox(-8, -8, -0.5f, 2, 2, 6, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 27")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 1, 25, textureX, textureY)
			.addShapeBox(-10, 3, -0.5f, 2, 3, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 28")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 113, 25, textureX, textureY)
			.addShapeBox(-6, 8, -0.5f, 3, 2, 6, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 29")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 137, 25, textureX, textureY)
			.addShapeBox(-8, 6, -0.5f, 2, 2, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 30")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 377, 1, textureX, textureY).addBox(-6, -6, 0, 3, 3, 1)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 31")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 497, 1, textureX, textureY).addBox(3, -6, 0, 3, 3, 1)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 32")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 17, 9, textureX, textureY).addBox(3, 3, 0, 3, 3, 1)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 33")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 113, 17, textureX, textureY).addBox(-6, 3, 0, 3, 3, 1)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 34")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 281, 1, textureX, textureY)
			.addShapeBox(-8, -6, 0, 2, 3, 1, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 35")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 361, 1, textureX, textureY)
			.addShapeBox(6, -6, 0, 2, 3, 1, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 36")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 153, 9, textureX, textureY)
			.addShapeBox(6, 3, 0, 2, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 37")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 505, 9, textureX, textureY)
			.addShapeBox(-8, 3, 0, 2, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 38")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 161, 9, textureX, textureY)
			.addShapeBox(-6, -8, 0, 3, 2, 1, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 39")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 185, 9, textureX, textureY)
			.addShapeBox(3, -8, 0, 3, 2, 1, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 40")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 217, 9, textureX, textureY)
			.addShapeBox(3, 6, 0, 3, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 41")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 153, 17, textureX, textureY)
			.addShapeBox(-6, 6, 0, 3, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 42")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 161, 25, textureX, textureY).addBox(-6, -3, 0.5f, 12, 6, 5)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 43")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 345, 17, textureX, textureY).addBox(-3, -8, 0.5f, 6, 2, 4)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 44")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 201, 25, textureX, textureY).addBox(-3, 6, 0.5f, 6, 2, 4)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 45")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 497, 17, textureX, textureY).addBox(6, -3, 0.5f, 2, 6, 4)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 46")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 225, 25, textureX, textureY).addBox(-8, -3, 0.5f, 2, 6, 4)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 47")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 241, 25, textureX, textureY)
			.addShapeBox(3, 6, 0.5f, 3, 2, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 48")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 193, 33, textureX, textureY)
			.addShapeBox(3, -8, 0.5f, 3, 2, 4, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 49")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 209, 33, textureX, textureY)
			.addShapeBox(-6, 6, 0.5f, 3, 2, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 50")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 241, 33, textureX, textureY)
			.addShapeBox(-6, -8, 0.5f, 3, 2, 4, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 51")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 257, 33, textureX, textureY)
			.addShapeBox(6, 3, 0.5f, 2, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 52")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 273, 33, textureX, textureY)
			.addShapeBox(-8, 3, 0.5f, 2, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 53")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 289, 33, textureX, textureY)
			.addShapeBox(-8, -6, 0.5f, 2, 3, 4, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 54")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 305, 33, textureX, textureY)
			.addShapeBox(6, -6, 0.5f, 2, 3, 4, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 55")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 321, 33, textureX, textureY)
			.addShapeBox(3, 3, 0.5f, 3, 3, 4, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 56")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 337, 33, textureX, textureY)
			.addShapeBox(3, -6, 0.5f, 3, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 57")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 353, 33, textureX, textureY)
			.addShapeBox(-6, -6, 0.5f, 3, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 58")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 377, 33, textureX, textureY)
			.addShapeBox(-6, 3, 0.5f, 3, 3, 4, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 59")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 417, 33, textureX, textureY).addBox(-3, -6, 0.5f, 6, 3, 5)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 60")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 441, 33, textureX, textureY).addBox(-3, 3, 0.5f, 6, 3, 5)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 61")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 465, 33, textureX, textureY)
			.addShapeBox(-6, 3, 0.5f, 3, 3, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 62")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 489, 33, textureX, textureY)
			.addShapeBox(-6, -6, 0.5f, 3, 3, 5, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 63")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 105, 41, textureX, textureY)
			.addShapeBox(3, -6, 0.5f, 3, 3, 5, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 64")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 129, 41, textureX, textureY)
			.addShapeBox(3, 3, 0.5f, 3, 3, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 65")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 393, 17, textureX, textureY)
			.addShapeBox(-6, -6, 5.5f, 3, 3, 1, 0, 0, -3, 0, 0, 0, 0, 0, -1, -0.5f, -1, -3, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, -1, 0, -0.5f)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 66")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 417, 17, textureX, textureY)
			.addShapeBox(-6, 3, 5.5f, 3, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, -1, 0, -0.5f, 0, -3, 0, 0, 0, 0, 0, -1, -0.5f, -1, -3, -0.5f)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 68")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 441, 17, textureX, textureY)
			.addShapeBox(3, 3, 5.5f, 3, 3, 1, 0, 0, 0, 0, 0, 0, 0, -1, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, -3, 0, -1, -3, -0.5f, 0, -1, -0.5f)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 69")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 465, 17, textureX, textureY)
			.addShapeBox(3, -6, 5.5f, 3, 3, 1, 0, 0, 0, 0, 0, -3, 0, -1, -3, -0.5f, 0, -1, -0.5f, 0, 0, 0, 0, 0, 0, -1, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 70")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 281, 9, textureX, textureY)
			.addShapeBox(-3, -3, 5.5f, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 71")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 89, 33, textureX, textureY)
			.addShapeBox(-3, -4, 5.5f, 6, 1, 1, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 72")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 393, 33, textureX, textureY)
			.addShapeBox(-3, 3, 5.5f, 6, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 73")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 257, 25, textureX, textureY)
			.addShapeBox(3, -3, 5.5f, 1, 6, 1, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 74")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 417, 25, textureX, textureY)
			.addShapeBox(-4, -3, 5.5f, 1, 6, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, 0, 0, 0, 0, -0.5f, -0.5f, 0, -0.5f)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 75")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 489, 25, textureX, textureY)
			.addShapeBox(-6, -3, 5.5f, 1, 6, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, -1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, -1, 0, -0.5f)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 76")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 153, 33, textureX, textureY)
			.addShapeBox(5, -3, 5.5f, 1, 6, 1, 0, 0, 0, 0, 0, 0, 0, -1, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, -1, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 77")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 145, 41, textureX, textureY)
			.addShapeBox(-3, 5, 5.5f, 6, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, -1, -0.5f, 0, -1, -0.5f)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 78")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 161, 41, textureX, textureY)
			.addShapeBox(-3, -6, 5.5f, 6, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, -0.5f, 0, -1, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 79")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 249, 1, textureX, textureY)
			.addShapeBox(3.5f, -3, 5.5f, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 80")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 345, 1, textureX, textureY)
			.addShapeBox(3.5f, -1, 5.5f, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 81")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 401, 1, textureX, textureY)
			.addShapeBox(-4.5f, -1, 5.5f, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 82")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 433, 1, textureX, textureY)
			.addShapeBox(3.5f, 2, 5.5f, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 83")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 465, 1, textureX, textureY)
			.addShapeBox(-4.5f, -3, 5.5f, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 84")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 1, 9, textureX, textureY)
			.addShapeBox(-4.5f, 2, 5.5f, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 85")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 129, 9, textureX, textureY)
			.addShapeBox(2, -4.5f, 5.5f, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 86")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 89, 17, textureX, textureY)
			.addShapeBox(-3, -4.5f, 5.5f, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 87")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 489, 17, textureX, textureY)
			.addShapeBox(-1, -4.5f, 5.5f, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 88")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 17, 25, textureX, textureY)
			.addShapeBox(-1, 3.5f, 5.5f, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 89")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 377, 17, textureX, textureY)
			.addShapeBox(2, 3.5f, 5.5f, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 90")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 1, 25, textureX, textureY)
			.addShapeBox(-3, 3.5f, 5.5f, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 91")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 129, 25, textureX, textureY)
			.addShapeBox(-3, 1, 5.5f, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 93")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 153, 25, textureX, textureY)
			.addShapeBox(1, 1, 5.5f, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 94")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 193, 25, textureX, textureY)
			.addShapeBox(1, -3, 5.5f, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 95")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 105, 33, textureX, textureY)
			.addShapeBox(-1, -3, 5.5f, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, -1, -0.5f, 0, -1, -0.5f)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 96")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 409, 33, textureX, textureY)
			.addShapeBox(-1, 1, 5.5f, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, -0.5f, 0, -1, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 97")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 481, 33, textureX, textureY)
			.addShapeBox(1, -1, 5.5f, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, -1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, -1, 0, -0.5f)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 98")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 505, 33, textureX, textureY)
			.addShapeBox(-3, -1, 5.5f, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0, -1, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, -1, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 99")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 121, 41, textureX, textureY)
			.addShapeBox(-1, -1, 5.5f, 2, 2, 1, 0, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 100")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 337, 225, textureX, textureY)
			.addShapeBox(-3, 4, 5.5f, 6, 1, 1, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 533")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 17, 233, textureX, textureY)
			.addShapeBox(-3, -5, 5.5f, 6, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 534")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 289, 145, textureX, textureY)
			.addShapeBox(4, -3, 5.5f, 1, 6, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, 0, 0, 0, 0, -0.5f, -0.5f, 0, -0.5f)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 535")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 1, 161, textureX, textureY)
			.addShapeBox(-5, -3, 5.5f, 1, 6, 1, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 536")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 161, 177, textureX, textureY)
			.addShapeBox(3.5f, -2, 5.5f, 1, 1, 1, 0, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 609")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 81, 185, textureX, textureY)
			.addShapeBox(3.5f, 1, 5.5f, 1, 1, 1, 0, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 610")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 121, 185, textureX, textureY)
			.addShapeBox(-4.5f, 1, 5.5f, 1, 1, 1, 0, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 611")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 177, 185, textureX, textureY)
			.addShapeBox(-4.5f, -2, 5.5f, 1, 1, 1, 0, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 612")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 201, 185, textureX, textureY)
			.addShapeBox(-2, -4.5f, 5.5f, 1, 1, 1, 0, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 613")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 233, 185, textureX, textureY)
			.addShapeBox(1, -4.5f, 5.5f, 1, 1, 1, 0, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 614")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 257, 185, textureX, textureY)
			.addShapeBox(1, 3.5f, 5.5f, 1, 1, 1, 0, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 615")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 297, 185, textureX, textureY)
			.addShapeBox(-2, 3.5f, 5.5f, 1, 1, 1, 0, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f)
			.setRotationPoint(35, 0, 17).setRotationAngle(0, 0, 0).setName("Box 616")
		);
		wheel_front_left.addPrograms(DefaultPrograms.IMPORTED_WHEEL, DefaultPrograms.DEF_WHEEL_ROTATE, DefaultPrograms.STEERING_Y);
		this.groups.add(wheel_front_left);
		//
		TurboList wheel_front_right = new TurboList("wheel_front_right");
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 177, 41, textureX, textureY).addBox(-3, -8, -1, 6, 5, 1)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 12")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 193, 41, textureX, textureY).addBox(-8, -3, -1, 16, 6, 1)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 13")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 233, 41, textureX, textureY).addBox(-10, -3, -5.5f, 2, 6, 6)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 14")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 257, 41, textureX, textureY).addBox(-3, 3, -1, 6, 5, 1)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 15")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 273, 41, textureX, textureY).addBox(8, -3, -5.5f, 2, 6, 6)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 16")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 297, 41, textureX, textureY).addBox(-3, 8, -5.5f, 6, 2, 6)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 17")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 1, 49, textureX, textureY).addBox(-3, -10, -5.5f, 6, 2, 6)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 18")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 33, 49, textureX, textureY)
			.addShapeBox(3, 8, -5.5f, 3, 2, 6, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 19")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 57, 49, textureX, textureY)
			.addShapeBox(8, 3, -5.5f, 2, 3, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -2, 0, 0, -2, 0, 0, 2, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 20")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 81, 49, textureX, textureY)
			.addShapeBox(6, 6, -5.5f, 2, 2, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 21")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 145, 49, textureX, textureY)
			.addShapeBox(8, -6, -5.5f, 2, 3, 6, 0, 2, 0, 0, -2, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 22")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 169, 49, textureX, textureY)
			.addShapeBox(3, -10, -5.5f, 3, 2, 6, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 23")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 193, 49, textureX, textureY)
			.addShapeBox(6, -8, -5.5f, 2, 2, 6, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 24")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 217, 49, textureX, textureY)
			.addShapeBox(-6, -10, -5.5f, 3, 2, 6, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 25")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 249, 49, textureX, textureY)
			.addShapeBox(-10, -6, -5.5f, 2, 3, 6, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 26")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 321, 49, textureX, textureY)
			.addShapeBox(-8, -8, -5.5f, 2, 2, 6, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 27")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 345, 49, textureX, textureY)
			.addShapeBox(-10, 3, -5.5f, 2, 3, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 28")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 369, 49, textureX, textureY)
			.addShapeBox(-6, 8, -5.5f, 3, 2, 6, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 29")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 393, 49, textureX, textureY)
			.addShapeBox(-8, 6, -5.5f, 2, 2, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 30")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 289, 41, textureX, textureY).addBox(-6, -6, -1, 3, 3, 1)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 31")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 481, 41, textureX, textureY).addBox(3, -6, -1, 3, 3, 1)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 32")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 25, 49, textureX, textureY).addBox(3, 3, -1, 3, 3, 1)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 33")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 49, 49, textureX, textureY).addBox(-6, 3, -1, 3, 3, 1)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 34")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 249, 41, textureX, textureY)
			.addShapeBox(-8, -6, -1, 2, 3, 1, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 35")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 321, 41, textureX, textureY)
			.addShapeBox(6, -6, -1, 2, 3, 1, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 36")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 505, 41, textureX, textureY)
			.addShapeBox(6, 3, -1, 2, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 37")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 73, 49, textureX, textureY)
			.addShapeBox(-8, 3, -1, 2, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 38")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 97, 49, textureX, textureY)
			.addShapeBox(-6, -8, -1, 3, 2, 1, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 39")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 121, 49, textureX, textureY)
			.addShapeBox(3, -8, -1, 3, 2, 1, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 40")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 161, 49, textureX, textureY)
			.addShapeBox(3, 6, -1, 3, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 41")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 185, 49, textureX, textureY)
			.addShapeBox(-6, 6, -1, 3, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 42")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 417, 49, textureX, textureY).addBox(-6, -3, -5.5f, 12, 6, 5)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 43")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 457, 49, textureX, textureY).addBox(-3, -8, -4.5f, 6, 2, 4)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 44")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 481, 49, textureX, textureY).addBox(-3, 6, -4.5f, 6, 2, 4)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 45")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 97, 57, textureX, textureY).addBox(6, -3, -4.5f, 2, 6, 4)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 46")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 113, 57, textureX, textureY).addBox(-8, -3, -4.5f, 2, 6, 4)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 47")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 129, 57, textureX, textureY)
			.addShapeBox(3, 6, -4.5f, 3, 2, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 48")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 233, 57, textureX, textureY)
			.addShapeBox(3, -8, -4.5f, 3, 2, 4, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 49")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 265, 57, textureX, textureY)
			.addShapeBox(-6, 6, -4.5f, 3, 2, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 50")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 281, 57, textureX, textureY)
			.addShapeBox(-6, -8, -4.5f, 3, 2, 4, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 51")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 297, 57, textureX, textureY)
			.addShapeBox(6, 3, -4.5f, 2, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 52")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 449, 57, textureX, textureY)
			.addShapeBox(-8, 3, -4.5f, 2, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 53")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 465, 57, textureX, textureY)
			.addShapeBox(-8, -6, -4.5f, 2, 3, 4, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 54")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 481, 57, textureX, textureY)
			.addShapeBox(6, -6, -4.5f, 2, 3, 4, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 55")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 497, 57, textureX, textureY)
			.addShapeBox(3, 3, -4.5f, 3, 3, 4, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 56")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 1, 65, textureX, textureY)
			.addShapeBox(3, -6, -4.5f, 3, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 57")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 17, 65, textureX, textureY)
			.addShapeBox(-6, -6, -4.5f, 3, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 58")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 33, 65, textureX, textureY)
			.addShapeBox(-6, 3, -4.5f, 3, 3, 4, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 59")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 49, 65, textureX, textureY).addBox(-3, -6, -5.5f, 6, 3, 5)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 60")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 73, 65, textureX, textureY).addBox(-3, 3, -5.5f, 6, 3, 5)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 61")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 121, 65, textureX, textureY)
			.addShapeBox(-6, 3, -5.5f, 3, 3, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 62")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 145, 65, textureX, textureY)
			.addShapeBox(-6, -6, -5.5f, 3, 3, 5, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 63")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 169, 65, textureX, textureY)
			.addShapeBox(3, -6, -5.5f, 3, 3, 5, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 64")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 193, 65, textureX, textureY)
			.addShapeBox(3, 3, -5.5f, 3, 3, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 65")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 209, 49, textureX, textureY)
			.addShapeBox(-6, -6, -6.5f, 3, 3, 1, 0, -1, -3, -0.5f, 0, -1, -0.5f, 0, 0, 0, 0, -3, 0, -1, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 66")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 337, 49, textureX, textureY)
			.addShapeBox(-6, 3, -6.5f, 3, 3, 1, 0, -1, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, -1, -3, -0.5f, 0, -1, -0.5f, 0, 0, 0, 0, -3, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 68")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 361, 49, textureX, textureY)
			.addShapeBox(3, 3, -6.5f, 3, 3, 1, 0, 0, 0, -0.5f, -1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, -1, -0.5f, -1, -3, -0.5f, 0, -3, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 69")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 385, 49, textureX, textureY)
			.addShapeBox(3, -6, -6.5f, 3, 3, 1, 0, 0, -1, -0.5f, -1, -3, -0.5f, 0, -3, 0, 0, 0, 0, 0, 0, -0.5f, -1, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 70")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 265, 49, textureX, textureY)
			.addShapeBox(-3, -3, -6.5f, 2, 2, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 71")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 209, 65, textureX, textureY)
			.addShapeBox(-3, -4, -6.5f, 6, 1, 1, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 72")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 225, 65, textureX, textureY)
			.addShapeBox(-3, 3, -6.5f, 6, 1, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, 0, 0, -0.5f, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 73")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 505, 49, textureX, textureY)
			.addShapeBox(3, -3, -6.5f, 1, 6, 1, 0, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, 0, 0, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 74")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 25, 57, textureX, textureY)
			.addShapeBox(-4, -3, -6.5f, 1, 6, 1, 0, -0.5f, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, -0.5f, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 75")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 209, 57, textureX, textureY)
			.addShapeBox(-6, -3, -6.5f, 1, 6, 1, 0, -1, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, -1, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 76")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 313, 57, textureX, textureY)
			.addShapeBox(5, -3, -6.5f, 1, 6, 1, 0, 0, 0, -0.5f, -1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, -1, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 77")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 241, 65, textureX, textureY)
			.addShapeBox(-3, 5, -6.5f, 6, 1, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, -1, -0.5f, 0, -1, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 78")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 257, 65, textureX, textureY)
			.addShapeBox(-3, -6, -6.5f, 6, 1, 1, 0, 0, -1, -0.5f, 0, -1, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 79")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 113, 25, textureX, textureY)
			.addShapeBox(3.5f, -3, -6.5f, 1, 1, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 80")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 137, 25, textureX, textureY)
			.addShapeBox(3.5f, -1, -6.5f, 1, 2, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 81")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 161, 25, textureX, textureY)
			.addShapeBox(-4.5f, -1, -6.5f, 1, 2, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 82")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 417, 33, textureX, textureY)
			.addShapeBox(3.5f, 2, -6.5f, 1, 1, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 83")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 441, 33, textureX, textureY)
			.addShapeBox(-4.5f, -3, -6.5f, 1, 1, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 84")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 465, 33, textureX, textureY)
			.addShapeBox(-4.5f, 2, -6.5f, 1, 1, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 85")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 489, 33, textureX, textureY)
			.addShapeBox(2, -4.5f, -6.5f, 1, 1, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 86")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 129, 41, textureX, textureY)
			.addShapeBox(-3, -4.5f, -6.5f, 1, 1, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 87")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 409, 49, textureX, textureY)
			.addShapeBox(-1, -4.5f, -6.5f, 2, 1, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 88")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 449, 49, textureX, textureY)
			.addShapeBox(-1, 3.5f, -6.5f, 2, 1, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 89")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 233, 41, textureX, textureY)
			.addShapeBox(2, 3.5f, -6.5f, 1, 1, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 90")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 273, 41, textureX, textureY)
			.addShapeBox(-3, 3.5f, -6.5f, 1, 1, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 91")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 337, 57, textureX, textureY)
			.addShapeBox(-3, 1, -6.5f, 2, 2, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 93")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 409, 57, textureX, textureY)
			.addShapeBox(1, 1, -6.5f, 2, 2, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 94")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 137, 65, textureX, textureY)
			.addShapeBox(1, -3, -6.5f, 2, 2, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 95")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 161, 65, textureX, textureY)
			.addShapeBox(-1, -3, -6.5f, 2, 2, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, -1, -0.5f, 0, -1, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 96")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 185, 65, textureX, textureY)
			.addShapeBox(-1, 1, -6.5f, 2, 2, 1, 0, 0, -1, -0.5f, 0, -1, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 97")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 273, 65, textureX, textureY)
			.addShapeBox(1, -1, -6.5f, 2, 2, 1, 0, -1, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, -1, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 98")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 281, 65, textureX, textureY)
			.addShapeBox(-3, -1, -6.5f, 2, 2, 1, 0, 0, 0, -0.5f, -1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, -1, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 99")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 289, 65, textureX, textureY)
			.addShapeBox(-1, -1, -6.5f, 2, 2, 1, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 100")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 25, 161, textureX, textureY)
			.addShapeBox(-5, -3, -6.5f, 1, 6, 1, 0, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, 0, 0, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 537")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 217, 161, textureX, textureY)
			.addShapeBox(4, -3, -6.5f, 1, 6, 1, 0, -0.5f, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, -0.5f, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 538")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 209, 233, textureX, textureY)
			.addShapeBox(-3, -5, -6.5f, 6, 1, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, 0, 0, -0.5f, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 539")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 273, 233, textureX, textureY)
			.addShapeBox(-3, 4, -6.5f, 6, 1, 1, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 541")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 337, 185, textureX, textureY)
			.addShapeBox(3.5f, -2, -6.5f, 1, 1, 1, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 617")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 353, 185, textureX, textureY)
			.addShapeBox(3.5f, 1, -6.5f, 1, 1, 1, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 618")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 377, 185, textureX, textureY)
			.addShapeBox(-4.5f, 1, -6.5f, 1, 1, 1, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 619")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 1, 193, textureX, textureY)
			.addShapeBox(-4.5f, -2, -6.5f, 1, 1, 1, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 620")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 161, 193, textureX, textureY)
			.addShapeBox(-2, -4.5f, -6.5f, 1, 1, 1, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 621")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 433, 193, textureX, textureY)
			.addShapeBox(1, -4.5f, -6.5f, 1, 1, 1, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 622")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 473, 193, textureX, textureY)
			.addShapeBox(1, 3.5f, -6.5f, 1, 1, 1, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 623")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 497, 193, textureX, textureY)
			.addShapeBox(-2, 3.5f, -6.5f, 1, 1, 1, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0)
			.setRotationPoint(35, 0, -17).setRotationAngle(0, 0, 0).setName("Box 624")
		);
		wheel_front_right.addPrograms(DefaultPrograms.IMPORTED_WHEEL, DefaultPrograms.DEF_WHEEL_ROTATE, DefaultPrograms.STEERING_Y);
		this.groups.add(wheel_front_right);
	}

}