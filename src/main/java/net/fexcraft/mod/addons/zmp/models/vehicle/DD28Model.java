//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.zmp.models.vehicle;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.vehicle.VehicleModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.4-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "zmp:models/vehicle/dd28")
public class DD28Model extends VehicleModel {

	public DD28Model(){
		super(); textureX = 1024; textureY = 1024;
		this.addToCreators("zackyboy19");
		//
		TurboList chassis = new TurboList("chassis");
		chassis.add(new ModelRendererTurbo(chassis, 28, 103, textureX, textureY).addBox(0, 0, 0, 1, 20, 1)
			.setRotationPoint(79, -33, -20).setRotationAngle(0, 0, 0).setName("Box 0")
		);
		chassis.add(new ModelRendererTurbo(chassis, 379, 11, textureX, textureY).addBox(0, 0, 0, 17, 2, 1)
			.setRotationPoint(80, -15, -20).setRotationAngle(0, 0, 0).setName("Box 3")
		);
		chassis.add(new ModelRendererTurbo(chassis, 64, 195, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 42, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(97, -18, -21).setRotationAngle(0, 0, 0).setName("Box 4")
		);
		chassis.add(new ModelRendererTurbo(chassis, 633, 191, textureX, textureY).addBox(0, 0, 0, 1, 16, 42)
			.setRotationPoint(97, -34, -21).setRotationAngle(0, 0, 0).setName("Box 5")
		);
		chassis.add(new ModelRendererTurbo(chassis, 5, 11, textureX, textureY).addBox(0, 0, 0, 17, 2, 1)
			.setRotationPoint(80, -15, 19).setRotationAngle(0, 0, 0).setName("Box 6")
		);
		chassis.add(new ModelRendererTurbo(chassis, 1005, 92, textureX, textureY).addBox(0, 0, 0, 1, 20, 1)
			.setRotationPoint(79, -33, 19).setRotationAngle(0, 0, 0).setName("Box 7")
		);
		chassis.add(new ModelRendererTurbo(chassis, 216, 42, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 4, 3, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(98, -32, 16).setRotationAngle(0, 0, 0).setName("Box 9")
		);
		chassis.add(new ModelRendererTurbo(chassis, 331, 39, textureX, textureY).addBox(0, 0, 0, 3, 2, 3)
			.setRotationPoint(98, -28, 16).setRotationAngle(0, 0, 0).setName("Box 10")
		);
		chassis.add(new ModelRendererTurbo(chassis, 208, 36, textureX, textureY).addBox(0, 0, 0, 3, 2, 3)
			.setRotationPoint(98, -28, -19).setRotationAngle(0, 0, 0).setName("Box 11")
		);
		chassis.add(new ModelRendererTurbo(chassis, 200, 42, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 4, 3, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(98, -32, -19).setRotationAngle(0, 0, 0).setName("Box 12")
		);
		chassis.add(new ModelRendererTurbo(chassis, 425, 90, textureX, textureY).addBox(0, 0, 0, 1, 14, 1)
			.setRotationPoint(21, -33, -20).setRotationAngle(0, 0, 0).setName("Box 13")
		);
		chassis.add(new ModelRendererTurbo(chassis, 411, 90, textureX, textureY).addBox(0, 0, 0, 1, 14, 1)
			.setRotationPoint(21, -33, 19).setRotationAngle(0, 0, 0).setName("Box 14")
		);
		chassis.add(new ModelRendererTurbo(chassis, 253, 22, textureX, textureY).addBox(0, 0, 0, 57, 7, 1)
			.setRotationPoint(22, -33, -20).setRotationAngle(0, 0, 0).setName("Box 15")
		);
		chassis.add(new ModelRendererTurbo(chassis, 827, 15, textureX, textureY).addBox(0, 0, 0, 57, 7, 1)
			.setRotationPoint(22, -33, 19).setRotationAngle(0, 0, 0).setName("Box 16")
		);
		chassis.add(new ModelRendererTurbo(chassis, 805, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 12, 1, 0, 0, 0, 0, 4, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(22, -25, -20).setRotationAngle(0, 0, 0).setName("Box 17")
		);
		chassis.add(new ModelRendererTurbo(chassis, 801, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 12, 1, 0, 0, 0, 0, 4, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(22, -25, 19).setRotationAngle(0, 0, 0).setName("Box 18")
		);
		chassis.add(new ModelRendererTurbo(chassis, 797, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 12, 1, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(78, -25, 19).setRotationAngle(0, 0, 0).setName("Box 19")
		);
		chassis.add(new ModelRendererTurbo(chassis, 793, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 12, 1, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(78, -25, -20).setRotationAngle(0, 0, 0).setName("Box 20")
		);
		chassis.add(new ModelRendererTurbo(chassis, 235, 5, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(74, -26, -20).setRotationAngle(0, 0, 0).setName("Box 21")
		);
		chassis.add(new ModelRendererTurbo(chassis, 1012, 4, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(74, -26, 19).setRotationAngle(0, 0, 0).setName("Box 22")
		);
		chassis.add(new ModelRendererTurbo(chassis, 484, 3, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(22, -26, 19).setRotationAngle(0, 0, 0).setName("Box 23")
		);
		chassis.add(new ModelRendererTurbo(chassis, 977, 2, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(22, -26, -20).setRotationAngle(0, 0, 0).setName("Box 24")
		);
		chassis.add(new ModelRendererTurbo(chassis, 202, 188, textureX, textureY).addBox(0, 0, 0, 1, 19, 38)
			.setRotationPoint(79, -33, -19).setRotationAngle(0, 0, 0).setName("Box 25")
		);
		chassis.add(new ModelRendererTurbo(chassis, 525, 140, textureX, textureY).addBox(0, 0, 0, 17, 19, 26)
			.setRotationPoint(80, -33, -15).setRotationAngle(0, 0, 0).setName("Box 26")
		);
		chassis.add(new ModelRendererTurbo(chassis, 249, 45, textureX, textureY).addBox(0, 0, 0, 57, 7, 38)
			.setRotationPoint(22, -33, -19).setRotationAngle(0, 0, 0).setName("Box 27")
		);
		chassis.add(new ModelRendererTurbo(chassis, 439, 27, textureX, textureY).addBox(0, 0, 0, 18, 2, 10)
			.setRotationPoint(79, -15, 9).setRotationAngle(0, 0, 0).setName("Box 29")
		);
		chassis.add(new ModelRendererTurbo(chassis, 967, 21, textureX, textureY).addBox(0, 0, 0, 18, 2, 10)
			.setRotationPoint(79, -15, -19).setRotationAngle(0, 0, 0).setName("Box 31")
		);
		chassis.add(new ModelRendererTurbo(chassis, 4, 32, textureX, textureY).addBox(0, 0, 0, 4, 1, 5)
			.setRotationPoint(80, -21, -18).setRotationAngle(0, 0, 0).setName("Box 44")
		);
		chassis.add(new ModelRendererTurbo(chassis, 422, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 1, 5, 0, 0, 0, 0, 0, 0, -5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -5, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(84, -21, -18).setRotationAngle(0, 0, 0).setName("Box 45")
		);
		chassis.add(new ModelRendererTurbo(chassis, 23, 27, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 1, 4, 0, 0, 0, 0, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(82, -28, -17).setRotationAngle(0, 0, 0).setName("Box 46")
		);
		chassis.add(new ModelRendererTurbo(chassis, 869, 39, textureX, textureY).addBox(0, 0, 0, 2, 1, 4)
			.setRotationPoint(80, -28, -17).setRotationAngle(0, 0, 0).setName("Box 47")
		);
		chassis.add(new ModelRendererTurbo(chassis, 41, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 1, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, 0)
			.setRotationPoint(82, -28, 13).setRotationAngle(0, 0, 0).setName("Box 48")
		);
		chassis.add(new ModelRendererTurbo(chassis, 475, 39, textureX, textureY).addBox(0, 0, 0, 2, 1, 4)
			.setRotationPoint(80, -28, 13).setRotationAngle(0, 0, 0).setName("Box 49")
		);
		chassis.add(new ModelRendererTurbo(chassis, 38, 30, textureX, textureY).addBox(0, 0, 0, 4, 1, 5)
			.setRotationPoint(80, -21, 13).setRotationAngle(0, 0, 0).setName("Box 50")
		);
		chassis.add(new ModelRendererTurbo(chassis, 398, 24, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 1, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, -5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -5, 0, 0, 0)
			.setRotationPoint(84, -21, 13).setRotationAngle(0, 0, 0).setName("Box 51")
		);
		chassis.add(new ModelRendererTurbo(chassis, 763, 89, textureX, textureY).addBox(0, 0, 0, 1, 6, 6)
			.setRotationPoint(97.5f, -24, -3).setRotationAngle(0, 0, 0).setName("Box 52")
		);
		chassis.add(new ModelRendererTurbo(chassis, 995, 51, textureX, textureY).addBox(0, 0, 0, 1, 3, 3)
			.setRotationPoint(98.5f, -22.5f, -1.5f).setRotationAngle(0, 0, 0).setName("Box 55")
		);
		chassis.add(new ModelRendererTurbo(chassis, 484, 22, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(98.5f, -22.5f, 0.5f).setRotationAngle(0, 0, 0).setName("Box 57")
		);
		chassis.add(new ModelRendererTurbo(chassis, 1013, 20, textureX, textureY).addBox(0, 0, 0, 4, 3, 1)
			.setRotationPoint(98.5f, -22.5f, -0.5f).setRotationAngle(0, 0, 0).setName("Box 60")
		);
		chassis.add(new ModelRendererTurbo(chassis, 516, 19, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 3, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(98.5f, -22.5f, -1.5f).setRotationAngle(0, 0, 0).setName("Box 62")
		);
		chassis.add(new ModelRendererTurbo(chassis, 211, 19, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(98.5f, -23.5f, -0.5f).setRotationAngle(0, 0, 0).setName("Box 63")
		);
		chassis.add(new ModelRendererTurbo(chassis, 195, 19, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(98.5f, -19.5f, -0.5f).setRotationAngle(0, 0, 0).setName("Box 64")
		);
		chassis.add(new ModelRendererTurbo(chassis, 179, 19, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(97.5f, -21.5f, -2.5f).setRotationAngle(0, 0, 0).setName("Box 65")
		);
		chassis.add(new ModelRendererTurbo(chassis, 163, 19, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(98.5f, -21.5f, 1.5f).setRotationAngle(0, 0, 0).setName("Box 66")
		);
		chassis.add(new ModelRendererTurbo(chassis, 471, 39, textureX, textureY).addBox(0, 0, 0, 1, 2, 2)
			.setRotationPoint(102.5f, -22, -1).setRotationAngle(0, 0, 0).setName("Box 67")
		);
		chassis.add(new ModelRendererTurbo(chassis, 463, 39, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 4, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0)
			.setRotationPoint(103.5f, -22, -2).setRotationAngle(0, 0, 0).setName("Box 68")
		);
		chassis.add(new ModelRendererTurbo(chassis, 409, 105, textureX, textureY).addBox(0, 0, 0, 1, 6, 8)
			.setRotationPoint(105.5f, -24, -4).setRotationAngle(0, 0, 0).setName("Box 69")
		);
		chassis.add(new ModelRendererTurbo(chassis, 755, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 6, 3, 0, 0, 0, 0, 0, 0, 0, -1, -1, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, -1, -2, 0, 1, -2, 0)
			.setRotationPoint(105.5f, -24, 4).setRotationAngle(0, 0, 0).setName("Box 70")
		);
		chassis.add(new ModelRendererTurbo(chassis, 169, 85, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 6, 3, 0, 1, -1, 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 1, -2, 0, -1, -2, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(105.5f, -24, -7).setRotationAngle(0, 0, 0).setName("Box 71")
		);
		chassis.add(new ModelRendererTurbo(chassis, 147, 19, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(103.5f, -23, -1.5f).setRotationAngle(0, 0, 0).setName("Box 72")
		);
		chassis.add(new ModelRendererTurbo(chassis, 141, 19, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(103.5f, -23, 0.5f).setRotationAngle(0, 0, 0).setName("Box 73")
		);
		chassis.add(new ModelRendererTurbo(chassis, 135, 19, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(103.5f, -20, -1.5f).setRotationAngle(0, 0, 0).setName("Box 75")
		);
		chassis.add(new ModelRendererTurbo(chassis, 123, 19, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(103.5f, -20, 0.5f).setRotationAngle(0, 0, 0).setName("Box 76")
		);
		chassis.add(new ModelRendererTurbo(chassis, 220, 39, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(106, -22, -1).setRotationAngle(0, 0, 0).setName("Box 77")
		);
		chassis.add(new ModelRendererTurbo(chassis, 201, 39, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(106, -22, 0).setRotationAngle(0, 0, 0).setName("Box 78")
		);
		chassis.add(new ModelRendererTurbo(chassis, 177, 45, textureX, textureY).addBox(0, 0, 0, 1, 5, 1)
			.setRotationPoint(78.5f, -31, -22).setRotationAngle(0, 0, 0).setName("Box 79")
		);
		chassis.add(new ModelRendererTurbo(chassis, 7, 39, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(78.5f, -32, -22).setRotationAngle(0, 0, 0).setName("Box 80")
		);
		chassis.add(new ModelRendererTurbo(chassis, 588, 38, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(78.5f, -26, -22).setRotationAngle(0, 0, 0).setName("Box 81")
		);
		chassis.add(new ModelRendererTurbo(chassis, 380, 38, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(78.5f, -32, -21).setRotationAngle(0, 0, 0).setName("Box 82")
		);
		chassis.add(new ModelRendererTurbo(chassis, 376, 38, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(78.5f, -26, -21).setRotationAngle(0, 0, 0).setName("Box 83")
		);
		chassis.add(new ModelRendererTurbo(chassis, 167, 45, textureX, textureY).addBox(0, 0, 0, 1, 5, 1)
			.setRotationPoint(78.5f, -31, 21).setRotationAngle(0, 0, 0).setName("Box 84")
		);
		chassis.add(new ModelRendererTurbo(chassis, 17, 38, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(78.5f, -26, 20).setRotationAngle(0, 0, 0).setName("Box 85")
		);
		chassis.add(new ModelRendererTurbo(chassis, 4, 38, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(78.5f, -26, 21).setRotationAngle(0, 0, 0).setName("Box 86")
		);
		chassis.add(new ModelRendererTurbo(chassis, 969, 37, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(78.5f, -32, 21).setRotationAngle(0, 0, 0).setName("Box 87")
		);
		chassis.add(new ModelRendererTurbo(chassis, 501, 37, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(78.5f, -32, 20).setRotationAngle(0, 0, 0).setName("Box 88")
		);
		chassis.add(new ModelRendererTurbo(chassis, 885, 39, textureX, textureY).addBox(0, 0, 0, 1, 4, 1)
			.setRotationPoint(100, -24, 11.5f).setRotationAngle(0, 0, 0).setName("Box 89")
		);
		chassis.add(new ModelRendererTurbo(chassis, 107, 19, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(99, -25, 11.5f).setRotationAngle(0, 0, 0).setName("Box 90")
		);
		chassis.add(new ModelRendererTurbo(chassis, 497, 37, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(98, -25, 11.5f).setRotationAngle(0, 0, 0).setName("Box 91")
		);
		chassis.add(new ModelRendererTurbo(chassis, 357, 36, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(98, -19, 11.5f).setRotationAngle(0, 0, 0).setName("Box 92")
		);
		chassis.add(new ModelRendererTurbo(chassis, 149, 36, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(100, -20, 11.5f).setRotationAngle(0, 0, 0).setName("Box 93")
		);
		chassis.add(new ModelRendererTurbo(chassis, 881, 39, textureX, textureY).addBox(0, 0, 0, 1, 4, 1)
			.setRotationPoint(100, -24, -12.5f).setRotationAngle(0, 0, 0).setName("Box 94")
		);
		chassis.add(new ModelRendererTurbo(chassis, 89, 19, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(99, -25, -12.5f).setRotationAngle(0, 0, 0).setName("Box 95")
		);
		chassis.add(new ModelRendererTurbo(chassis, 979, 35, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(98, -25, -12.5f).setRotationAngle(0, 0, 0).setName("Box 96")
		);
		chassis.add(new ModelRendererTurbo(chassis, 585, 35, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(98, -19, -12.5f).setRotationAngle(0, 0, 0).setName("Box 97")
		);
		chassis.add(new ModelRendererTurbo(chassis, 387, 35, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(100, -20, -12.5f).setRotationAngle(0, 0, 0).setName("Box 98")
		);
		chassis.add(new ModelRendererTurbo(chassis, 737, 89, textureX, textureY).addBox(0, 0, 0, 5, 30, 1)
			.setRotationPoint(68, -63, -12).setRotationAngle(0, 0, 0).setName("Box 99")
		);
		chassis.add(new ModelRendererTurbo(chassis, 277, 171, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 28, 24, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(92, -61, -12).setRotationAngle(0, 0, 0).setName("Box 100")
		);
		chassis.add(new ModelRendererTurbo(chassis, 587, 185, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 28, 22, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(94, -61, -11).setRotationAngle(0, 0, 0).setName("Box 101")
		);
		chassis.add(new ModelRendererTurbo(chassis, 114, 173, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 28, 20, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0)
			.setRotationPoint(95, -61, -10).setRotationAngle(0, 0, 0).setName("Box 102")
		);
		chassis.add(new ModelRendererTurbo(chassis, 576, 7, textureX, textureY).addBox(0, 0, 0, 18, 1, 1)
			.setRotationPoint(73, -61, -12.5f).setRotationAngle(0, 0, 0).setName("Box 103")
		);
		chassis.add(new ModelRendererTurbo(chassis, 213, 7, textureX, textureY).addBox(0, 0, 0, 18, 1, 1)
			.setRotationPoint(73, -35, -12.5f).setRotationAngle(0, 0, 0).setName("Box 104")
		);
		chassis.add(new ModelRendererTurbo(chassis, 102, 184, textureX, textureY).addBox(0, 0, 0, 1, 25, 1)
			.setRotationPoint(73, -60, -12.5f).setRotationAngle(0, 0, 0).setName("Box 105")
		);
		chassis.add(new ModelRendererTurbo(chassis, 98, 184, textureX, textureY).addBox(0, 0, 0, 1, 25, 1)
			.setRotationPoint(90, -60, -12.5f).setRotationAngle(0, 0, 0).setName("Box 106")
		);
		chassis.add(new ModelRendererTurbo(chassis, 94, 184, textureX, textureY).addBox(0, 0, 0, 1, 25, 1)
			.setRotationPoint(74.5f, -60, -12.5f).setRotationAngle(0, 0, 0).setName("Box 107")
		);
		chassis.add(new ModelRendererTurbo(chassis, 90, 184, textureX, textureY).addBox(0, 0, 0, 1, 25, 1)
			.setRotationPoint(76, -60, -12.5f).setRotationAngle(0, 0, 0).setName("Box 114")
		);
		chassis.add(new ModelRendererTurbo(chassis, 52, 177, textureX, textureY).addBox(0, 0, 0, 1, 25, 1)
			.setRotationPoint(77.5f, -60, -12.5f).setRotationAngle(0, 0, 0).setName("Box 115")
		);
		chassis.add(new ModelRendererTurbo(chassis, 48, 177, textureX, textureY).addBox(0, 0, 0, 1, 25, 1)
			.setRotationPoint(79, -60, -12.5f).setRotationAngle(0, 0, 0).setName("Box 116")
		);
		chassis.add(new ModelRendererTurbo(chassis, 44, 177, textureX, textureY).addBox(0, 0, 0, 1, 25, 1)
			.setRotationPoint(80.5f, -60, -12.5f).setRotationAngle(0, 0, 0).setName("Box 117")
		);
		chassis.add(new ModelRendererTurbo(chassis, 114, 164, textureX, textureY).addBox(0, 0, 0, 1, 25, 1)
			.setRotationPoint(82, -60, -12.5f).setRotationAngle(0, 0, 0).setName("Box 118")
		);
		chassis.add(new ModelRendererTurbo(chassis, 1019, 140, textureX, textureY).addBox(0, 0, 0, 1, 25, 1)
			.setRotationPoint(83.5f, -60, -12.5f).setRotationAngle(0, 0, 0).setName("Box 119")
		);
		chassis.add(new ModelRendererTurbo(chassis, 1015, 140, textureX, textureY).addBox(0, 0, 0, 1, 25, 1)
			.setRotationPoint(85, -60, -12.5f).setRotationAngle(0, 0, 0).setName("Box 120")
		);
		chassis.add(new ModelRendererTurbo(chassis, 1011, 140, textureX, textureY).addBox(0, 0, 0, 1, 25, 1)
			.setRotationPoint(86.5f, -60, -12.5f).setRotationAngle(0, 0, 0).setName("Box 121")
		);
		chassis.add(new ModelRendererTurbo(chassis, 1007, 140, textureX, textureY).addBox(0, 0, 0, 1, 25, 1)
			.setRotationPoint(88, -60, -12.5f).setRotationAngle(0, 0, 0).setName("Box 122")
		);
		chassis.add(new ModelRendererTurbo(chassis, 1003, 140, textureX, textureY).addBox(0, 0, 0, 1, 25, 1)
			.setRotationPoint(90, -60, 11.5f).setRotationAngle(0, 0, 0).setName("Box 123")
		);
		chassis.add(new ModelRendererTurbo(chassis, 422, 6, textureX, textureY).addBox(0, 0, 0, 18, 1, 1)
			.setRotationPoint(73, -61, 11.5f).setRotationAngle(0, 0, 0).setName("Box 124")
		);
		chassis.add(new ModelRendererTurbo(chassis, 999, 140, textureX, textureY).addBox(0, 0, 0, 1, 25, 1)
			.setRotationPoint(73, -60, 11.5f).setRotationAngle(0, 0, 0).setName("Box 125")
		);
		chassis.add(new ModelRendererTurbo(chassis, 593, 140, textureX, textureY).addBox(0, 0, 0, 1, 25, 1)
			.setRotationPoint(74.5f, -60, 11.5f).setRotationAngle(0, 0, 0).setName("Box 126")
		);
		chassis.add(new ModelRendererTurbo(chassis, 0, 6, textureX, textureY).addBox(0, 0, 0, 18, 1, 1)
			.setRotationPoint(73, -35, 11.5f).setRotationAngle(0, 0, 0).setName("Box 127")
		);
		chassis.add(new ModelRendererTurbo(chassis, 589, 140, textureX, textureY).addBox(0, 0, 0, 1, 25, 1)
			.setRotationPoint(88, -60, 11.5f).setRotationAngle(0, 0, 0).setName("Box 128")
		);
		chassis.add(new ModelRendererTurbo(chassis, 585, 140, textureX, textureY).addBox(0, 0, 0, 1, 25, 1)
			.setRotationPoint(86.5f, -60, 11.5f).setRotationAngle(0, 0, 0).setName("Box 129")
		);
		chassis.add(new ModelRendererTurbo(chassis, 545, 140, textureX, textureY).addBox(0, 0, 0, 1, 25, 1)
			.setRotationPoint(85, -60, 11.5f).setRotationAngle(0, 0, 0).setName("Box 130")
		);
		chassis.add(new ModelRendererTurbo(chassis, 541, 140, textureX, textureY).addBox(0, 0, 0, 1, 25, 1)
			.setRotationPoint(83.5f, -60, 11.5f).setRotationAngle(0, 0, 0).setName("Box 131")
		);
		chassis.add(new ModelRendererTurbo(chassis, 537, 140, textureX, textureY).addBox(0, 0, 0, 1, 25, 1)
			.setRotationPoint(82, -60, 11.5f).setRotationAngle(0, 0, 0).setName("Box 132")
		);
		chassis.add(new ModelRendererTurbo(chassis, 533, 140, textureX, textureY).addBox(0, 0, 0, 1, 25, 1)
			.setRotationPoint(80.5f, -60, 11.5f).setRotationAngle(0, 0, 0).setName("Box 133")
		);
		chassis.add(new ModelRendererTurbo(chassis, 529, 140, textureX, textureY).addBox(0, 0, 0, 1, 25, 1)
			.setRotationPoint(79, -60, 11.5f).setRotationAngle(0, 0, 0).setName("Box 134")
		);
		chassis.add(new ModelRendererTurbo(chassis, 525, 140, textureX, textureY).addBox(0, 0, 0, 1, 25, 1)
			.setRotationPoint(77.5f, -60, 11.5f).setRotationAngle(0, 0, 0).setName("Box 135")
		);
		chassis.add(new ModelRendererTurbo(chassis, 121, 93, textureX, textureY).addBox(0, 0, 0, 1, 25, 1)
			.setRotationPoint(76, -60, 11.5f).setRotationAngle(0, 0, 0).setName("Box 136")
		);
		chassis.add(new ModelRendererTurbo(chassis, 487, 169, textureX, textureY).addBox(0, 0, 0, 2, 28, 24)
			.setRotationPoint(90, -61, -12).setRotationAngle(0, 0, 0).setName("Box 137")
		);
		chassis.add(new ModelRendererTurbo(chassis, 894, 71, textureX, textureY).addBox(0, 0, 0, 17, 2, 24)
			.setRotationPoint(73, -63, -12).setRotationAngle(0, 0, 0).setName("Box 138")
		);
		chassis.add(new ModelRendererTurbo(chassis, 925, 46, textureX, textureY).addBox(0, 0, 0, 17, 1, 24)
			.setRotationPoint(73, -34, -12).setRotationAngle(0, 0, 0).setName("Box 139")
		);
		chassis.add(new ModelRendererTurbo(chassis, 549, 83, textureX, textureY).addBox(0, 0, 0, 5, 30, 1)
			.setRotationPoint(68, -63, 11).setRotationAngle(0, 0, 0).setName("Box 140")
		);
		chassis.add(new ModelRendererTurbo(chassis, 494, 21, textureX, textureY).addBox(0, 0, 0, 10, 2, 1)
			.setRotationPoint(58, -35, -12).setRotationAngle(0, 0, 0).setName("Box 141")
		);
		chassis.add(new ModelRendererTurbo(chassis, 414, 21, textureX, textureY).addBox(0, 0, 0, 10, 2, 1)
			.setRotationPoint(58, -35, 11).setRotationAngle(0, 0, 0).setName("Box 142")
		);
		chassis.add(new ModelRendererTurbo(chassis, 392, 21, textureX, textureY).addBox(0, 0, 0, 10, 2, 1)
			.setRotationPoint(47, -35, -12).setRotationAngle(0, 0, 0).setName("Box 143")
		);
		chassis.add(new ModelRendererTurbo(chassis, 370, 21, textureX, textureY).addBox(0, 0, 0, 10, 2, 1)
			.setRotationPoint(47, -35, 11).setRotationAngle(0, 0, 0).setName("Box 144")
		);
		chassis.add(new ModelRendererTurbo(chassis, 36, 177, textureX, textureY).addBox(0, 0, 0, 1, 30, 1)
			.setRotationPoint(57, -63, -12).setRotationAngle(0, 0, 0).setName("Box 145")
		);
		chassis.add(new ModelRendererTurbo(chassis, 32, 177, textureX, textureY).addBox(0, 0, 0, 1, 30, 1)
			.setRotationPoint(57, -63, 11).setRotationAngle(0, 0, 0).setName("Box 146")
		);
		chassis.add(new ModelRendererTurbo(chassis, 481, 169, textureX, textureY).addBox(0, 0, 0, 2, 30, 1)
			.setRotationPoint(45, -63, -12).setRotationAngle(0, 0, 0).setName("Box 147")
		);
		chassis.add(new ModelRendererTurbo(chassis, 951, 166, textureX, textureY).addBox(0, 0, 0, 2, 30, 1)
			.setRotationPoint(45, -63, 11).setRotationAngle(0, 0, 0).setName("Box 148")
		);
		chassis.add(new ModelRendererTurbo(chassis, 945, 166, textureX, textureY).addBox(0, 0, 0, 2, 30, 1)
			.setRotationPoint(22, -63, -12).setRotationAngle(0, 0, 0).setName("Box 149")
		);
		chassis.add(new ModelRendererTurbo(chassis, 505, 124, textureX, textureY).addBox(0, 0, 0, 2, 30, 1)
			.setRotationPoint(22, -63, 11).setRotationAngle(0, 0, 0).setName("Box 150")
		);
		chassis.add(new ModelRendererTurbo(chassis, 222, 21, textureX, textureY).addBox(0, 0, 0, 10, 2, 1)
			.setRotationPoint(24, -35, -12).setRotationAngle(0, 0, 0).setName("Box 151")
		);
		chassis.add(new ModelRendererTurbo(chassis, 200, 21, textureX, textureY).addBox(0, 0, 0, 10, 2, 1)
			.setRotationPoint(35, -35, -12).setRotationAngle(0, 0, 0).setName("Box 152")
		);
		chassis.add(new ModelRendererTurbo(chassis, 28, 177, textureX, textureY).addBox(0, 0, 0, 1, 30, 1)
			.setRotationPoint(34, -63, -12).setRotationAngle(0, 0, 0).setName("Box 153")
		);
		chassis.add(new ModelRendererTurbo(chassis, 178, 21, textureX, textureY).addBox(0, 0, 0, 10, 2, 1)
			.setRotationPoint(35, -35, 11).setRotationAngle(0, 0, 0).setName("Box 154")
		);
		chassis.add(new ModelRendererTurbo(chassis, 24, 175, textureX, textureY).addBox(0, 0, 0, 1, 30, 1)
			.setRotationPoint(34, -63, 11).setRotationAngle(0, 0, 0).setName("Box 155")
		);
		chassis.add(new ModelRendererTurbo(chassis, 156, 21, textureX, textureY).addBox(0, 0, 0, 10, 2, 1)
			.setRotationPoint(24, -35, 11).setRotationAngle(0, 0, 0).setName("Box 156")
		);
		chassis.add(new ModelRendererTurbo(chassis, 499, 124, textureX, textureY).addBox(0, 0, 0, 2, 30, 1)
			.setRotationPoint(-1, -63, -12).setRotationAngle(0, 0, 0).setName("Box 157")
		);
		chassis.add(new ModelRendererTurbo(chassis, 749, 89, textureX, textureY).addBox(0, 0, 0, 2, 30, 1)
			.setRotationPoint(-1, -63, 11).setRotationAngle(0, 0, 0).setName("Box 158")
		);
		chassis.add(new ModelRendererTurbo(chassis, 134, 21, textureX, textureY).addBox(0, 0, 0, 10, 2, 1)
			.setRotationPoint(1, -35, -12).setRotationAngle(0, 0, 0).setName("Box 159")
		);
		chassis.add(new ModelRendererTurbo(chassis, 89, 21, textureX, textureY).addBox(0, 0, 0, 10, 2, 1)
			.setRotationPoint(12, -35, -12).setRotationAngle(0, 0, 0).setName("Box 160")
		);
		chassis.add(new ModelRendererTurbo(chassis, 20, 175, textureX, textureY).addBox(0, 0, 0, 1, 30, 1)
			.setRotationPoint(11, -63, -12).setRotationAngle(0, 0, 0).setName("Box 161")
		);
		chassis.add(new ModelRendererTurbo(chassis, 22, 21, textureX, textureY).addBox(0, 0, 0, 10, 2, 1)
			.setRotationPoint(12, -35, 11).setRotationAngle(0, 0, 0).setName("Box 162")
		);
		chassis.add(new ModelRendererTurbo(chassis, 16, 175, textureX, textureY).addBox(0, 0, 0, 1, 30, 1)
			.setRotationPoint(11, -63, 11).setRotationAngle(0, 0, 0).setName("Box 163")
		);
		chassis.add(new ModelRendererTurbo(chassis, 0, 21, textureX, textureY).addBox(0, 0, 0, 10, 2, 1)
			.setRotationPoint(1, -35, 11).setRotationAngle(0, 0, 0).setName("Box 164")
		);
		chassis.add(new ModelRendererTurbo(chassis, 719, 102, textureX, textureY).addBox(0, 0, 0, 76, 7, 38)
			.setRotationPoint(-54, -33, -19).setRotationAngle(0, 0, 0).setName("Box 165")
		);
		chassis.add(new ModelRendererTurbo(chassis, 429, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 24, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(92, -63, -12).setRotationAngle(0, 0, 0).setName("Box 167")
		);
		chassis.add(new ModelRendererTurbo(chassis, 409, 149, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 20, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0)
			.setRotationPoint(95, -63, -10).setRotationAngle(0, 0, 0).setName("Box 168")
		);
		chassis.add(new ModelRendererTurbo(chassis, 541, 185, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 22, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(94, -63, -11).setRotationAngle(0, 0, 0).setName("Box 169")
		);
		chassis.add(new ModelRendererTurbo(chassis, 167, 168, textureX, textureY).addBox(0, 0, 0, 2, 2, 24)
			.setRotationPoint(90, -63, -12).setRotationAngle(0, 0, 0).setName("Box 170")
		);
		chassis.add(new ModelRendererTurbo(chassis, 218, 55, textureX, textureY).addBox(0, 0, 0, 2, 1, 7)
			.setRotationPoint(-10, -67, -19).setRotationAngle(0, 0, 0).setName("Box 504")
		);
		chassis.add(new ModelRendererTurbo(chassis, 927, 166, textureX, textureY).addBox(0, 0, 0, 2, 20, 7)
			.setRotationPoint(-10, -53, -19).setRotationAngle(0, 0, 0).setName("Box 505")
		);
		chassis.add(new ModelRendererTurbo(chassis, 12, 175, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 34, 1, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-9, -67, -20).setRotationAngle(0, 0, 0).setName("Box 507")
		);
		chassis.add(new ModelRendererTurbo(chassis, 983, 51, textureX, textureY).addBox(0, 0, 0, 2, 13, 1)
			.setRotationPoint(-10, -66, -19).setRotationAngle(0, 0, 0).setName("Box 508")
		);
		chassis.add(new ModelRendererTurbo(chassis, 921, 166, textureX, textureY).addBox(0, 0, 0, 2, 34, 1)
			.setRotationPoint(-10, -67, -12).setRotationAngle(0, 0, 0).setName("Box 509")
		);
		chassis.add(new ModelRendererTurbo(chassis, 203, 55, textureX, textureY).addBox(0, 0, 0, 2, 1, 6)
			.setRotationPoint(-10, -54, -18).setRotationAngle(0, 0, 0).setName("Box 510")
		);
		chassis.add(new ModelRendererTurbo(chassis, 8, 175, textureX, textureY).addBox(0, 0, 0, 1, 34, 1)
			.setRotationPoint(-10, -67, -20).setRotationAngle(0, 0, 0).setName("Box 512")
		);
		chassis.add(new ModelRendererTurbo(chassis, 108, 164, textureX, textureY).addBox(0, 0, 0, 2, 34, 1)
			.setRotationPoint(-12, -67, -20).setRotationAngle(0, 0, 0).setName("Box 513")
		);
		chassis.add(new ModelRendererTurbo(chassis, 555, 49, textureX, textureY).addBox(0, 0, 0, 91, 4, 24)
			.setRotationPoint(-1, -67, -12).setRotationAngle(0, 0, 0).setName("Box 514")
		);
		chassis.add(new ModelRendererTurbo(chassis, 689, 163, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 24, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(90, -67, -12).setRotationAngle(0, 0, 0).setName("Box 515")
		);
		chassis.add(new ModelRendererTurbo(chassis, 637, 163, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 24, 0, 0, 0, -1, 0, 0, -2, 0, 0, -2, 0, 0, -1, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(92, -67, -12).setRotationAngle(0, 0, 0).setName("Box 516")
		);
		chassis.add(new ModelRendererTurbo(chassis, 44, 184, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 22, 0, 0, 0, -1, 0, 0, -2, 0, 0, -2, 0, 0, -1, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(94, -67, -11).setRotationAngle(0, 0, 0).setName("Box 517")
		);
		chassis.add(new ModelRendererTurbo(chassis, 617, 163, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 20, 0, 0, 0, -1, -1, 0, -3, -1, 0, -3, 0, 0, -1, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0)
			.setRotationPoint(95, -67, -10).setRotationAngle(0, 0, 0).setName("Box 518")
		);
		chassis.add(new ModelRendererTurbo(chassis, 611, 163, textureX, textureY).addBox(0, 0, 0, 2, 34, 1)
			.setRotationPoint(-10, -67, 11).setRotationAngle(0, 0, 0).setName("Box 519")
		);
		chassis.add(new ModelRendererTurbo(chassis, 283, 160, textureX, textureY).addBox(0, 0, 0, 2, 20, 7)
			.setRotationPoint(-10, -53, 12).setRotationAngle(0, 0, 0).setName("Box 520")
		);
		chassis.add(new ModelRendererTurbo(chassis, 154, 54, textureX, textureY).addBox(0, 0, 0, 2, 1, 7)
			.setRotationPoint(-10, -67, 12).setRotationAngle(0, 0, 0).setName("Box 521")
		);
		chassis.add(new ModelRendererTurbo(chassis, 277, 160, textureX, textureY).addBox(0, 0, 0, 2, 34, 1)
			.setRotationPoint(-12, -67, 19).setRotationAngle(0, 0, 0).setName("Box 522")
		);
		chassis.add(new ModelRendererTurbo(chassis, 4, 175, textureX, textureY).addBox(0, 0, 0, 1, 34, 1)
			.setRotationPoint(-10, -67, 19).setRotationAngle(0, 0, 0).setName("Box 523")
		);
		chassis.add(new ModelRendererTurbo(chassis, 0, 175, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 34, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(-9, -67, 19).setRotationAngle(0, 0, 0).setName("Box 524")
		);
		chassis.add(new ModelRendererTurbo(chassis, 115, 51, textureX, textureY).addBox(0, 0, 0, 2, 13, 1)
			.setRotationPoint(-10, -66, 18).setRotationAngle(0, 0, 0).setName("Box 525")
		);
		chassis.add(new ModelRendererTurbo(chassis, 999, 51, textureX, textureY).addBox(0, 0, 0, 2, 1, 6)
			.setRotationPoint(-10, -54, 12).setRotationAngle(0, 0, 0).setName("Box 527")
		);
		chassis.add(new ModelRendererTurbo(chassis, 271, 160, textureX, textureY).addBox(0, 0, 0, 2, 34, 1)
			.setRotationPoint(-29, -67, -20).setRotationAngle(0, 0, 0).setName("Box 528")
		);
		chassis.add(new ModelRendererTurbo(chassis, 561, 83, textureX, textureY).addBox(0, 0, 0, 2, 34, 1)
			.setRotationPoint(-29, -67, 19).setRotationAngle(0, 0, 0).setName("Box 529")
		);
		chassis.add(new ModelRendererTurbo(chassis, 160, 173, textureX, textureY).addBox(0, 0, 0, 1, 34, 1)
			.setRotationPoint(-54, -67, -20).setRotationAngle(0, 0, 0).setName("Box 530")
		);
		chassis.add(new ModelRendererTurbo(chassis, 917, 171, textureX, textureY).addBox(0, 0, 0, 1, 34, 1)
			.setRotationPoint(-54, -67, 19).setRotationAngle(0, 0, 0).setName("Box 531")
		);
		chassis.add(new ModelRendererTurbo(chassis, 524, 0, textureX, textureY).addBox(0, 0, 0, 24, 1, 1)
			.setRotationPoint(-53, -67, -20).setRotationAngle(0, 0, 0).setName("Box 532")
		);
		chassis.add(new ModelRendererTurbo(chassis, 167, 9, textureX, textureY).addBox(0, 0, 0, 15, 1, 1)
			.setRotationPoint(-27, -67, -20).setRotationAngle(0, 0, 0).setName("Box 533")
		);
		chassis.add(new ModelRendererTurbo(chassis, 581, 3, textureX, textureY).addBox(0, 0, 0, 15, 1, 1)
			.setRotationPoint(-27, -67, 19).setRotationAngle(0, 0, 0).setName("Box 534")
		);
		chassis.add(new ModelRendererTurbo(chassis, 430, 0, textureX, textureY).addBox(0, 0, 0, 24, 1, 1)
			.setRotationPoint(-53, -67, 19).setRotationAngle(0, 0, 0).setName("Box 535")
		);
		chassis.add(new ModelRendererTurbo(chassis, 893, 46, textureX, textureY).addBox(0, 0, 0, 24, 17, 1)
			.setRotationPoint(-53, -50, -20).setRotationAngle(0, 0, 0).setName("Box 536")
		);
		chassis.add(new ModelRendererTurbo(chassis, 527, 8, textureX, textureY).addBox(0, 0, 0, 24, 17, 1)
			.setRotationPoint(-53, -50, 19).setRotationAngle(0, 0, 0).setName("Box 537")
		);
		chassis.add(new ModelRendererTurbo(chassis, 956, 71, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 12, 1, 0, 0, 0, 0, 4, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-79, -25, -20).setRotationAngle(0, 0, 0).setName("Box 538")
		);
		chassis.add(new ModelRendererTurbo(chassis, 517, 83, textureX, textureY).addBox(0, 0, 0, 1, 20, 1)
			.setRotationPoint(-80, -33, -20).setRotationAngle(0, 0, 0).setName("Box 539")
		);
		chassis.add(new ModelRendererTurbo(chassis, 957, 2, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-79, -26, -20).setRotationAngle(0, 0, 0).setName("Box 540")
		);
		chassis.add(new ModelRendererTurbo(chassis, 255, 14, textureX, textureY).addBox(0, 0, 0, 57, 7, 1)
			.setRotationPoint(-79, -33, -20).setRotationAngle(0, 0, 0).setName("Box 541")
		);
		chassis.add(new ModelRendererTurbo(chassis, 952, 71, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 12, 1, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-23, -25, -20).setRotationAngle(0, 0, 0).setName("Box 542")
		);
		chassis.add(new ModelRendererTurbo(chassis, 509, 2, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-27, -26, -20).setRotationAngle(0, 0, 0).setName("Box 543")
		);
		chassis.add(new ModelRendererTurbo(chassis, 972, 75, textureX, textureY).addBox(0, 0, 0, 1, 14, 1)
			.setRotationPoint(-22, -33, -20).setRotationAngle(0, 0, 0).setName("Box 544")
		);
		chassis.add(new ModelRendererTurbo(chassis, 195, 71, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 12, 1, 0, 0, 0, 0, 4, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-79, -25, 19).setRotationAngle(0, 0, 0).setName("Box 545")
		);
		chassis.add(new ModelRendererTurbo(chassis, 513, 83, textureX, textureY).addBox(0, 0, 0, 1, 20, 1)
			.setRotationPoint(-80, -33, 19).setRotationAngle(0, 0, 0).setName("Box 546")
		);
		chassis.add(new ModelRendererTurbo(chassis, 485, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-79, -26, 19).setRotationAngle(0, 0, 0).setName("Box 547")
		);
		chassis.add(new ModelRendererTurbo(chassis, 805, 7, textureX, textureY).addBox(0, 0, 0, 57, 7, 1)
			.setRotationPoint(-79, -33, 19).setRotationAngle(0, 0, 0).setName("Box 548")
		);
		chassis.add(new ModelRendererTurbo(chassis, 179, 71, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 12, 1, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-23, -25, 19).setRotationAngle(0, 0, 0).setName("Box 549")
		);
		chassis.add(new ModelRendererTurbo(chassis, 956, 0, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-27, -26, 19).setRotationAngle(0, 0, 0).setName("Box 550")
		);
		chassis.add(new ModelRendererTurbo(chassis, 163, 71, textureX, textureY).addBox(0, 0, 0, 1, 14, 1)
			.setRotationPoint(-22, -33, 19).setRotationAngle(0, 0, 0).setName("Box 551")
		);
		chassis.add(new ModelRendererTurbo(chassis, 805, 31, textureX, textureY).addBox(0, 0, 0, 42, 7, 1)
			.setRotationPoint(-21, -33, -20).setRotationAngle(0, 0, 0).setName("Box 552")
		);
		chassis.add(new ModelRendererTurbo(chassis, 253, 30, textureX, textureY).addBox(0, 0, 0, 42, 7, 1)
			.setRotationPoint(-21, -26, -20).setRotationAngle(0, 0, 0).setName("Box 553")
		);
		chassis.add(new ModelRendererTurbo(chassis, 131, 11, textureX, textureY)
			.addShapeBox(0, 0, 0, 42, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 1)
			.setRotationPoint(-21, -19, -20).setRotationAngle(0, 0, 0).setName("Box 554")
		);
		chassis.add(new ModelRendererTurbo(chassis, 927, 5, textureX, textureY)
			.addShapeBox(0, 0, 0, 42, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 1)
			.setRotationPoint(-21, -15, -19).setRotationAngle(0, 0, 0).setName("Box 555")
		);
		chassis.add(new ModelRendererTurbo(chassis, 487, 39, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 0, 1)
			.setRotationPoint(-22, -19, -20).setRotationAngle(0, 0, 0).setName("Box 556")
		);
		chassis.add(new ModelRendererTurbo(chassis, 459, 39, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 1, 0, 0, 1)
			.setRotationPoint(-22, -15, -20).setRotationAngle(0, 0, 0).setName("Box 558")
		);
		chassis.add(new ModelRendererTurbo(chassis, 449, 39, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 1, 0, 0, 1)
			.setRotationPoint(21, -15, -20).setRotationAngle(0, 0, 0).setName("Box 559")
		);
		chassis.add(new ModelRendererTurbo(chassis, 389, 38, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 1, 0, 0, 1)
			.setRotationPoint(21, -19, -20).setRotationAngle(0, 0, 0).setName("Box 560")
		);
		chassis.add(new ModelRendererTurbo(chassis, 505, 27, textureX, textureY).addBox(0, 0, 0, 42, 7, 1)
			.setRotationPoint(-21, -33, 19).setRotationAngle(0, 0, 0).setName("Box 561")
		);
		chassis.add(new ModelRendererTurbo(chassis, 805, 23, textureX, textureY).addBox(0, 0, 0, 42, 7, 1)
			.setRotationPoint(-21, -26, 19).setRotationAngle(0, 0, 0).setName("Box 562")
		);
		chassis.add(new ModelRendererTurbo(chassis, 45, 11, textureX, textureY)
			.addShapeBox(0, 0, 0, 42, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(-21, -19, 19).setRotationAngle(0, 0, 0).setName("Box 563")
		);
		chassis.add(new ModelRendererTurbo(chassis, 462, 5, textureX, textureY)
			.addShapeBox(0, 0, 0, 42, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(-21, -15, 18).setRotationAngle(0, 0, 0).setName("Box 564")
		);
		chassis.add(new ModelRendererTurbo(chassis, 385, 38, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(-22, -19, 19).setRotationAngle(0, 0, 0).setName("Box 565")
		);
		chassis.add(new ModelRendererTurbo(chassis, 372, 38, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -2, 0, 0, 0)
			.setRotationPoint(-22, -15, 18).setRotationAngle(0, 0, 0).setName("Box 566")
		);
		chassis.add(new ModelRendererTurbo(chassis, 114, 38, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, -2)
			.setRotationPoint(21, -15, 18).setRotationAngle(0, 0, 0).setName("Box 567")
		);
		chassis.add(new ModelRendererTurbo(chassis, 87, 38, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(21, -19, 19).setRotationAngle(0, 0, 0).setName("Box 568")
		);
		chassis.add(new ModelRendererTurbo(chassis, 501, 185, textureX, textureY).addBox(0, 0, 0, 1, 2, 38)
			.setRotationPoint(-54, -67, -19).setRotationAngle(0, 0, 0).setName("Box 569")
		);
		chassis.add(new ModelRendererTurbo(chassis, 599, 135, textureX, textureY).addBox(0, 0, 0, 35, 4, 24)
			.setRotationPoint(-89, -67, -12).setRotationAngle(0, 0, 0).setName("Box 570")
		);
		chassis.add(new ModelRendererTurbo(chassis, 998, 71, textureX, textureY).addBox(0, 0, 0, 2, 30, 1)
			.setRotationPoint(-89, -63, -12).setRotationAngle(0, 0, 0).setName("Box 571")
		);
		chassis.add(new ModelRendererTurbo(chassis, 331, 90, textureX, textureY).addBox(0, 0, 0, 12, 30, 1)
			.setRotationPoint(-66, -63, -12).setRotationAngle(0, 0, 0).setName("Box 572")
		);
		chassis.add(new ModelRendererTurbo(chassis, 913, 171, textureX, textureY).addBox(0, 0, 0, 1, 30, 1)
			.setRotationPoint(-77, -63, -12).setRotationAngle(0, 0, 0).setName("Box 573")
		);
		chassis.add(new ModelRendererTurbo(chassis, 401, 51, textureX, textureY).addBox(0, 0, 0, 2, 30, 1)
			.setRotationPoint(-89, -63, 11).setRotationAngle(0, 0, 0).setName("Box 574")
		);
		chassis.add(new ModelRendererTurbo(chassis, 523, 83, textureX, textureY).addBox(0, 0, 0, 12, 30, 1)
			.setRotationPoint(-66, -63, 11).setRotationAngle(0, 0, 0).setName("Box 575")
		);
		chassis.add(new ModelRendererTurbo(chassis, 909, 171, textureX, textureY).addBox(0, 0, 0, 1, 30, 1)
			.setRotationPoint(-77, -63, 11).setRotationAngle(0, 0, 0).setName("Box 576")
		);
		chassis.add(new ModelRendererTurbo(chassis, 219, 160, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 24, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-91, -67, -12).setRotationAngle(0, 0, 0).setName("Box 577")
		);
		chassis.add(new ModelRendererTurbo(chassis, 56, 156, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 24, 0, 0, 0, -2, 0, 0, -1, 0, 0, -1, 0, 0, -2, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(-93, -67, -12).setRotationAngle(0, 0, 0).setName("Box 578")
		);
		chassis.add(new ModelRendererTurbo(chassis, 399, 181, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 22, 0, 0, 0, -2, 0, 0, -1, 0, 0, -1, 0, 0, -2, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(-94, -67, -11).setRotationAngle(0, 0, 0).setName("Box 579")
		);
		chassis.add(new ModelRendererTurbo(chassis, 877, 147, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 20, 0, -1, 0, -3, 0, 0, -1, 0, 0, -1, -1, 0, -3, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2)
			.setRotationPoint(-96, -67, -10).setRotationAngle(0, 0, 0).setName("Box 580")
		);
		chassis.add(new ModelRendererTurbo(chassis, 28, 151, textureX, textureY).addBox(0, 0, 0, 2, 2, 24)
			.setRotationPoint(-91, -63, -12).setRotationAngle(0, 0, 0).setName("Box 581")
		);
		chassis.add(new ModelRendererTurbo(chassis, 0, 149, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 24, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(-93, -63, -12).setRotationAngle(0, 0, 0).setName("Box 582")
		);
		chassis.add(new ModelRendererTurbo(chassis, 375, 179, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 22, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(-94, -63, -11).setRotationAngle(0, 0, 0).setName("Box 583")
		);
		chassis.add(new ModelRendererTurbo(chassis, 825, 147, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 20, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2)
			.setRotationPoint(-96, -63, -10).setRotationAngle(0, 0, 0).setName("Box 584")
		);
		chassis.add(new ModelRendererTurbo(chassis, 849, 147, textureX, textureY).addBox(0, 0, 0, 2, 28, 24)
			.setRotationPoint(-91, -61, -12).setRotationAngle(0, 0, 0).setName("Box 585")
		);
		chassis.add(new ModelRendererTurbo(chassis, 797, 147, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 28, 24, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(-93, -61, -12).setRotationAngle(0, 0, 0).setName("Box 586")
		);
		chassis.add(new ModelRendererTurbo(chassis, 329, 179, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 28, 22, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(-94, -61, -11).setRotationAngle(0, 0, 0).setName("Box 587")
		);
		chassis.add(new ModelRendererTurbo(chassis, 753, 147, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 28, 20, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2)
			.setRotationPoint(-96, -61, -10).setRotationAngle(0, 0, 0).setName("Box 588")
		);
		chassis.add(new ModelRendererTurbo(chassis, 735, 147, textureX, textureY).addBox(0, 0, 0, 2, 20, 7)
			.setRotationPoint(-55, -53, -19).setRotationAngle(0, 0, 0).setName("Box 589")
		);
		chassis.add(new ModelRendererTurbo(chassis, 125, 48, textureX, textureY).addBox(0, 0, 0, 2, 1, 6)
			.setRotationPoint(-55, -54, -18).setRotationAngle(0, 0, 0).setName("Box 590")
		);
		chassis.add(new ModelRendererTurbo(chassis, 221, 47, textureX, textureY).addBox(0, 0, 0, 2, 1, 7)
			.setRotationPoint(-55, -67, -19).setRotationAngle(0, 0, 0).setName("Box 591")
		);
		chassis.add(new ModelRendererTurbo(chassis, 195, 48, textureX, textureY).addBox(0, 0, 0, 2, 13, 1)
			.setRotationPoint(-55, -66, -19).setRotationAngle(0, 0, 0).setName("Box 592")
		);
		chassis.add(new ModelRendererTurbo(chassis, 11, 72, textureX, textureY).addBox(0, 0, 0, 2, 34, 1)
			.setRotationPoint(-55, -67, -12).setRotationAngle(0, 0, 0).setName("Box 594")
		);
		chassis.add(new ModelRendererTurbo(chassis, 147, 48, textureX, textureY).addBox(0, 0, 0, 2, 34, 1)
			.setRotationPoint(-55, -67, 11).setRotationAngle(0, 0, 0).setName("Box 595")
		);
		chassis.add(new ModelRendererTurbo(chassis, 717, 147, textureX, textureY).addBox(0, 0, 0, 2, 20, 7)
			.setRotationPoint(-55, -53, 12).setRotationAngle(0, 0, 0).setName("Box 596")
		);
		chassis.add(new ModelRendererTurbo(chassis, 1015, 47, textureX, textureY).addBox(0, 0, 0, 2, 13, 1)
			.setRotationPoint(-55, -66, 18).setRotationAngle(0, 0, 0).setName("Box 597")
		);
		chassis.add(new ModelRendererTurbo(chassis, 5, 47, textureX, textureY).addBox(0, 0, 0, 2, 1, 6)
			.setRotationPoint(-55, -54, 12).setRotationAngle(0, 0, 0).setName("Box 599")
		);
		chassis.add(new ModelRendererTurbo(chassis, 581, 40, textureX, textureY).addBox(0, 0, 0, 2, 1, 7)
			.setRotationPoint(-55, -67, 12).setRotationAngle(0, 0, 0).setName("Box 600")
		);
		chassis.add(new ModelRendererTurbo(chassis, 305, 134, textureX, textureY).addBox(0, 0, 0, 33, 7, 38)
			.setRotationPoint(-87, -33, -19).setRotationAngle(0, 0, 0).setName("Box 601")
		);
		chassis.add(new ModelRendererTurbo(chassis, 119, 140, textureX, textureY).addBox(0, 0, 0, 10, 7, 26)
			.setRotationPoint(-97, -33, -13).setRotationAngle(0, 0, 0).setName("Box 602")
		);
		chassis.add(new ModelRendererTurbo(chassis, 505, 13, textureX, textureY).addBox(0, 0, 0, 10, 2, 1)
			.setRotationPoint(-87, -35, 11).setRotationAngle(0, 0, 0).setName("Box 644")
		);
		chassis.add(new ModelRendererTurbo(chassis, 483, 13, textureX, textureY).addBox(0, 0, 0, 10, 2, 1)
			.setRotationPoint(-76, -35, 11).setRotationAngle(0, 0, 0).setName("Box 645")
		);
		chassis.add(new ModelRendererTurbo(chassis, 461, 13, textureX, textureY).addBox(0, 0, 0, 10, 2, 1)
			.setRotationPoint(-87, -35, -12).setRotationAngle(0, 0, 0).setName("Box 646")
		);
		chassis.add(new ModelRendererTurbo(chassis, 217, 13, textureX, textureY).addBox(0, 0, 0, 10, 2, 1)
			.setRotationPoint(-76, -35, -12).setRotationAngle(0, 0, 0).setName("Box 647")
		);
		chassis.add(new ModelRendererTurbo(chassis, 461, 10, textureX, textureY).addBox(0, 0, 0, 17, 2, 1)
			.setRotationPoint(-97, -15, 19).setRotationAngle(0, 0, 0).setName("Box 648")
		);
		chassis.add(new ModelRendererTurbo(chassis, 31, 37, textureX, textureY).addBox(0, 0, 0, 17, 2, 10)
			.setRotationPoint(-97, -15, 9).setRotationAngle(0, 0, 0).setName("Box 649")
		);
		chassis.add(new ModelRendererTurbo(chassis, 116, 179, textureX, textureY).addBox(0, 0, 0, 1, 16, 42)
			.setRotationPoint(-98, -34, -21).setRotationAngle(0, 0, 0).setName("Box 650")
		);
		chassis.add(new ModelRendererTurbo(chassis, 0, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 42, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(-98, -18, -21).setRotationAngle(0, 0, 0).setName("Box 651")
		);
		chassis.add(new ModelRendererTurbo(chassis, 5, 8, textureX, textureY).addBox(0, 0, 0, 17, 2, 1)
			.setRotationPoint(-97, -15, -20).setRotationAngle(0, 0, 0).setName("Box 652")
		);
		chassis.add(new ModelRendererTurbo(chassis, 532, 35, textureX, textureY).addBox(0, 0, 0, 17, 2, 10)
			.setRotationPoint(-97, -15, -19).setRotationAngle(0, 0, 0).setName("Box 653")
		);
		chassis.add(new ModelRendererTurbo(chassis, 435, 132, textureX, textureY).addBox(0, 0, 0, 19, 11, 26)
			.setRotationPoint(-97, -26, -13).setRotationAngle(0, 0, 0).setName("Box 654")
		);
		chassis.add(new ModelRendererTurbo(chassis, 419, 40, textureX, textureY).addBox(0, 0, 0, 7, 18, 1)
			.setRotationPoint(-87, -33, -20).setRotationAngle(0, 0, 0).setName("Box 655")
		);
		chassis.add(new ModelRendererTurbo(chassis, 681, 101, textureX, textureY).addBox(0, 0, 0, 1, 11, 6)
			.setRotationPoint(-81, -26, -19).setRotationAngle(0, 0, 0).setName("Box 656")
		);
		chassis.add(new ModelRendererTurbo(chassis, 317, 90, textureX, textureY).addBox(0, 0, 0, 1, 11, 6)
			.setRotationPoint(-81, -26, 13).setRotationAngle(0, 0, 0).setName("Box 657")
		);
		chassis.add(new ModelRendererTurbo(chassis, 601, 23, textureX, textureY).addBox(0, 0, 0, 7, 18, 1)
			.setRotationPoint(-87, -33, 19).setRotationAngle(0, 0, 0).setName("Box 658")
		);
		chassis.add(new ModelRendererTurbo(chassis, 905, 171, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 34, 1, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-55, -67, -20).setRotationAngle(0, 0, 0).setName("Box 659")
		);
		chassis.add(new ModelRendererTurbo(chassis, 901, 171, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 34, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(-55, -67, 19).setRotationAngle(0, 0, 0).setName("Box 660")
		);
		chassis.add(new ModelRendererTurbo(chassis, 236, 25, textureX, textureY).addBox(0, 0, 0, 4, 1, 5)
			.setRotationPoint(-97, -21, -18).setRotationAngle(0, 0, 0).setName("Box 661")
		);
		chassis.add(new ModelRendererTurbo(chassis, 126, 24, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 1, 5, 0, 0, 0, 0, 0, 0, -5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -5, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-93, -21, -18).setRotationAngle(0, 0, 0).setName("Box 662")
		);
		chassis.add(new ModelRendererTurbo(chassis, 451, 39, textureX, textureY).addBox(0, 0, 0, 2, 1, 4)
			.setRotationPoint(-97, -28, -17).setRotationAngle(0, 0, 0).setName("Box 663")
		);
		chassis.add(new ModelRendererTurbo(chassis, 953, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 1, 4, 0, 0, 0, 0, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-95, -28, -17).setRotationAngle(0, 0, 0).setName("Box 664")
		);
		chassis.add(new ModelRendererTurbo(chassis, 220, 24, textureX, textureY).addBox(0, 0, 0, 4, 1, 5)
			.setRotationPoint(-97, -21, 13).setRotationAngle(0, 0, 0).setName("Box 665")
		);
		chassis.add(new ModelRendererTurbo(chassis, 598, 16, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 1, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, -5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -5, 0, 0, 0)
			.setRotationPoint(-93, -21, 13).setRotationAngle(0, 0, 0).setName("Box 666")
		);
		chassis.add(new ModelRendererTurbo(chassis, 240, 20, textureX, textureY).addBox(0, 0, 0, 2, 1, 4)
			.setRotationPoint(-97, -28, 13).setRotationAngle(0, 0, 0).setName("Box 667")
		);
		chassis.add(new ModelRendererTurbo(chassis, 437, 12, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 1, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, 0)
			.setRotationPoint(-95, -28, 13).setRotationAngle(0, 0, 0).setName("Box 668")
		);
		chassis.add(new ModelRendererTurbo(chassis, 576, 35, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 4, 3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-101, -32, 16).setRotationAngle(0, 0, 0).setName("Box 669")
		);
		chassis.add(new ModelRendererTurbo(chassis, 239, 35, textureX, textureY).addBox(0, 0, 0, 3, 2, 3)
			.setRotationPoint(-101, -28, 16).setRotationAngle(0, 0, 0).setName("Box 670")
		);
		chassis.add(new ModelRendererTurbo(chassis, 94, 35, textureX, textureY).addBox(0, 0, 0, 3, 2, 3)
			.setRotationPoint(-101, -28, -19).setRotationAngle(0, 0, 0).setName("Box 671")
		);
		chassis.add(new ModelRendererTurbo(chassis, 22, 34, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 4, 3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-101, -32, -19).setRotationAngle(0, 0, 0).setName("Box 672")
		);
		chassis.add(new ModelRendererTurbo(chassis, 355, 39, textureX, textureY).addBox(0, 0, 0, 1, 3, 3)
			.setRotationPoint(-99.5f, -22.5f, -1.5f).setRotationAngle(0, 0, 0).setName("Box 673")
		);
		chassis.add(new ModelRendererTurbo(chassis, 663, 77, textureX, textureY).addBox(0, 0, 0, 1, 6, 6)
			.setRotationPoint(-98.5f, -24, -3).setRotationAngle(0, 0, 0).setName("Box 674")
		);
		chassis.add(new ModelRendererTurbo(chassis, 31, 19, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-100.5f, -23.5f, -0.5f).setRotationAngle(0, 0, 0).setName("Box 675")
		);
		chassis.add(new ModelRendererTurbo(chassis, 25, 19, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(-100.5f, -21.5f, 1.5f).setRotationAngle(0, 0, 0).setName("Box 676")
		);
		chassis.add(new ModelRendererTurbo(chassis, 221, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(-102.5f, -22.5f, 0.5f).setRotationAngle(0, 0, 0).setName("Box 677")
		);
		chassis.add(new ModelRendererTurbo(chassis, 957, 8, textureX, textureY).addBox(0, 0, 0, 4, 3, 1)
			.setRotationPoint(-102.5f, -22.5f, -0.5f).setRotationAngle(0, 0, 0).setName("Box 678")
		);
		chassis.add(new ModelRendererTurbo(chassis, 421, 8, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 3, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-102.5f, -22.5f, -1.5f).setRotationAngle(0, 0, 0).setName("Box 679")
		);
		chassis.add(new ModelRendererTurbo(chassis, 13, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-100.5f, -21.5f, -2.5f).setRotationAngle(0, 0, 0).setName("Box 680")
		);
		chassis.add(new ModelRendererTurbo(chassis, 1018, 11, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(-100.5f, -19.5f, -0.5f).setRotationAngle(0, 0, 0).setName("Box 681")
		);
		chassis.add(new ModelRendererTurbo(chassis, 595, 37, textureX, textureY).addBox(0, 0, 0, 1, 2, 2)
			.setRotationPoint(-103.5f, -22, -1).setRotationAngle(0, 0, 0).setName("Box 682")
		);
		chassis.add(new ModelRendererTurbo(chassis, 587, 11, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-105.5f, -23, -1.5f).setRotationAngle(0, 0, 0).setName("Box 683")
		);
		chassis.add(new ModelRendererTurbo(chassis, 243, 11, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-105.5f, -23, 0.5f).setRotationAngle(0, 0, 0).setName("Box 684")
		);
		chassis.add(new ModelRendererTurbo(chassis, 243, 3, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(-105.5f, -20, 0.5f).setRotationAngle(0, 0, 0).setName("Box 685")
		);
		chassis.add(new ModelRendererTurbo(chassis, 571, 2, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(-105.5f, -20, -1.5f).setRotationAngle(0, 0, 0).setName("Box 686")
		);
		chassis.add(new ModelRendererTurbo(chassis, 343, 39, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 4, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1)
			.setRotationPoint(-105.5f, -22, -2).setRotationAngle(0, 0, 0).setName("Box 687")
		);
		chassis.add(new ModelRendererTurbo(chassis, 137, 77, textureX, textureY).addBox(0, 0, 0, 1, 6, 8)
			.setRotationPoint(-106.5f, -24, -4).setRotationAngle(0, 0, 0).setName("Box 688")
		);
		chassis.add(new ModelRendererTurbo(chassis, 423, 70, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 6, 3, 0, -1, -1, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, -1, -2, 0, 1, -2, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-106.5f, -24, -7).setRotationAngle(0, 0, 0).setName("Box 689")
		);
		chassis.add(new ModelRendererTurbo(chassis, 429, 35, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-107, -22, -1).setRotationAngle(0, 0, 0).setName("Box 690")
		);
		chassis.add(new ModelRendererTurbo(chassis, 425, 35, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(-107, -22, 0).setRotationAngle(0, 0, 0).setName("Box 691")
		);
		chassis.add(new ModelRendererTurbo(chassis, 562, 64, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 6, 3, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 1, -2, 0, -1, -2, 0)
			.setRotationPoint(-106.5f, -24, 4).setRotationAngle(0, 0, 0).setName("Box 692")
		);
		chassis.add(new ModelRendererTurbo(chassis, 248, 35, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(-86.5f, -26, 20).setRotationAngle(0, 0, 0).setName("Box 693")
		);
		chassis.add(new ModelRendererTurbo(chassis, 11, 38, textureX, textureY).addBox(0, 0, 0, 1, 5, 1)
			.setRotationPoint(-86.5f, -31, 21).setRotationAngle(0, 0, 0).setName("Box 694")
		);
		chassis.add(new ModelRendererTurbo(chassis, 179, 35, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(-86.5f, -32, 20).setRotationAngle(0, 0, 0).setName("Box 695")
		);
		chassis.add(new ModelRendererTurbo(chassis, 69, 35, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-86.5f, -32, 21).setRotationAngle(0, 0, 0).setName("Box 696")
		);
		chassis.add(new ModelRendererTurbo(chassis, 65, 35, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(-86.5f, -32, -21).setRotationAngle(0, 0, 0).setName("Box 697")
		);
		chassis.add(new ModelRendererTurbo(chassis, 361, 34, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-86.5f, -32, -22).setRotationAngle(0, 0, 0).setName("Box 698")
		);
		chassis.add(new ModelRendererTurbo(chassis, 0, 37, textureX, textureY).addBox(0, 0, 0, 1, 5, 1)
			.setRotationPoint(-86.5f, -31, -22).setRotationAngle(0, 0, 0).setName("Box 699")
		);
		chassis.add(new ModelRendererTurbo(chassis, 357, 34, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-86.5f, -26, -22).setRotationAngle(0, 0, 0).setName("Box 700")
		);
		chassis.add(new ModelRendererTurbo(chassis, 213, 34, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(-86.5f, -26, -21).setRotationAngle(0, 0, 0).setName("Box 701")
		);
		chassis.add(new ModelRendererTurbo(chassis, 505, 83, textureX, textureY).addBox(0, 0, 0, 1, 20, 1)
			.setRotationPoint(90.5f, -60, 13).setRotationAngle(0, 0, 0).setName("Box 702")
		);
		chassis.add(new ModelRendererTurbo(chassis, 209, 34, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(90.5f, -61, 13).setRotationAngle(0, 0, 0).setName("Box 703")
		);
		chassis.add(new ModelRendererTurbo(chassis, 979, 33, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(90.5f, -61, 12).setRotationAngle(0, 0, 0).setName("Box 704")
		);
		chassis.add(new ModelRendererTurbo(chassis, 439, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(90.5f, -40, 13).setRotationAngle(0, 0, 0).setName("Box 705")
		);
		chassis.add(new ModelRendererTurbo(chassis, 391, 33, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(90.5f, -40, 12).setRotationAngle(0, 0, 0).setName("Box 706")
		);
		chassis.add(new ModelRendererTurbo(chassis, 387, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(90.5f, -40, -14).setRotationAngle(0, 0, 0).setName("Box 707")
		);
		chassis.add(new ModelRendererTurbo(chassis, 179, 33, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(90.5f, -40, -13).setRotationAngle(0, 0, 0).setName("Box 708")
		);
		chassis.add(new ModelRendererTurbo(chassis, 27, 72, textureX, textureY).addBox(0, 0, 0, 1, 20, 1)
			.setRotationPoint(90.5f, -60, -14).setRotationAngle(0, 0, 0).setName("Box 709")
		);
		chassis.add(new ModelRendererTurbo(chassis, 101, 33, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(90.5f, -61, -13).setRotationAngle(0, 0, 0).setName("Box 710")
		);
		chassis.add(new ModelRendererTurbo(chassis, 97, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(90.5f, -61, -14).setRotationAngle(0, 0, 0).setName("Box 711")
		);
		chassis.add(new ModelRendererTurbo(chassis, 69, 33, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(68.5f, -65, -13).setRotationAngle(0, 0, 0).setName("Box 712")
		);
		chassis.add(new ModelRendererTurbo(chassis, 65, 33, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(45.5f, -65, -13).setRotationAngle(0, 0, 0).setName("Box 713")
		);
		chassis.add(new ModelRendererTurbo(chassis, 167, 7, textureX, textureY).addBox(0, 0, 0, 22, 1, 1)
			.setRotationPoint(46.5f, -65, -14).setRotationAngle(0, 0, 0).setName("Box 714")
		);
		chassis.add(new ModelRendererTurbo(chassis, 39, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(45.5f, -65, -14).setRotationAngle(0, 0, 0).setName("Box 715")
		);
		chassis.add(new ModelRendererTurbo(chassis, 212, 32, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(68.5f, -65, -14).setRotationAngle(0, 0, 0).setName("Box 716")
		);
		chassis.add(new ModelRendererTurbo(chassis, 208, 32, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(43.5f, -65, -14).setRotationAngle(0, 0, 0).setName("Box 717")
		);
		chassis.add(new ModelRendererTurbo(chassis, 51, 32, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(43.5f, -65, -13).setRotationAngle(0, 0, 0).setName("Box 718")
		);
		chassis.add(new ModelRendererTurbo(chassis, 36, 32, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(0.5f, -65, -14).setRotationAngle(0, 0, 0).setName("Box 719")
		);
		chassis.add(new ModelRendererTurbo(chassis, 377, 4, textureX, textureY).addBox(0, 0, 0, 42, 1, 1)
			.setRotationPoint(1.5f, -65, -14).setRotationAngle(0, 0, 0).setName("Box 720")
		);
		chassis.add(new ModelRendererTurbo(chassis, 28, 32, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(0.5f, -65, -13).setRotationAngle(0, 0, 0).setName("Box 721")
		);
		chassis.add(new ModelRendererTurbo(chassis, 377, 2, textureX, textureY).addBox(0, 0, 0, 42, 1, 1)
			.setRotationPoint(1.5f, -65, 13).setRotationAngle(0, 0, 0).setName("Box 722")
		);
		chassis.add(new ModelRendererTurbo(chassis, 376, 6, textureX, textureY).addBox(0, 0, 0, 22, 1, 1)
			.setRotationPoint(46.5f, -65, 13).setRotationAngle(0, 0, 0).setName("Box 723")
		);
		chassis.add(new ModelRendererTurbo(chassis, 24, 32, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(0.5f, -65, 12).setRotationAngle(0, 0, 0).setName("Box 724")
		);
		chassis.add(new ModelRendererTurbo(chassis, 961, 31, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(43.5f, -65, 12).setRotationAngle(0, 0, 0).setName("Box 725")
		);
		chassis.add(new ModelRendererTurbo(chassis, 439, 31, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(45.5f, -65, 12).setRotationAngle(0, 0, 0).setName("Box 726")
		);
		chassis.add(new ModelRendererTurbo(chassis, 395, 31, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(68.5f, -65, 12).setRotationAngle(0, 0, 0).setName("Box 727")
		);
		chassis.add(new ModelRendererTurbo(chassis, 249, 31, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(0.5f, -65, 13).setRotationAngle(0, 0, 0).setName("Box 728")
		);
		chassis.add(new ModelRendererTurbo(chassis, 234, 31, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(43.5f, -65, 13).setRotationAngle(0, 0, 0).setName("Box 729")
		);
		chassis.add(new ModelRendererTurbo(chassis, 187, 31, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(45.5f, -65, 13).setRotationAngle(0, 0, 0).setName("Box 730")
		);
		chassis.add(new ModelRendererTurbo(chassis, 58, 31, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(68.5f, -65, 13).setRotationAngle(0, 0, 0).setName("Box 731")
		);
		chassis.add(new ModelRendererTurbo(chassis, 943, 46, textureX, textureY).addBox(0, 0, 0, 2, 16, 1)
			.setRotationPoint(-53, -66, 19).setRotationAngle(0, 0, 0).setName("Box 732")
		);
		chassis.add(new ModelRendererTurbo(chassis, 101, 71, textureX, textureY).addBox(0, 0, 0, 1, 16, 1)
			.setRotationPoint(-39, -66, 19).setRotationAngle(0, 0, 0).setName("Box 733")
		);
		chassis.add(new ModelRendererTurbo(chassis, 85, 71, textureX, textureY).addBox(0, 0, 0, 1, 16, 1)
			.setRotationPoint(-39, -66, -20).setRotationAngle(0, 0, 0).setName("Box 734")
		);
		chassis.add(new ModelRendererTurbo(chassis, 617, 27, textureX, textureY).addBox(0, 0, 0, 2, 16, 1)
			.setRotationPoint(-53, -66, -20).setRotationAngle(0, 0, 0).setName("Box 735")
		);
		chassis.add(new ModelRendererTurbo(chassis, 998, 8, textureX, textureY).addBox(0, 0, 0, 12, 1, 1)
			.setRotationPoint(-51, -66, -20).setRotationAngle(0, 0, 0).setName("Box 736")
		);
		chassis.add(new ModelRendererTurbo(chassis, 921, 12, textureX, textureY).addBox(0, 0, 0, 12, 2, 1)
			.setRotationPoint(-51, -52, -20).setRotationAngle(0, 0, 0).setName("Box 737")
		);
		chassis.add(new ModelRendererTurbo(chassis, 415, 12, textureX, textureY).addBox(0, 0, 0, 12, 2, 1)
			.setRotationPoint(-51, -52, 19).setRotationAngle(0, 0, 0).setName("Box 738")
		);
		chassis.add(new ModelRendererTurbo(chassis, 997, 2, textureX, textureY).addBox(0, 0, 0, 12, 1, 1)
			.setRotationPoint(-51, -66, 19).setRotationAngle(0, 0, 0).setName("Box 739")
		);
		chassis.add(new ModelRendererTurbo(chassis, 548, 68, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 13, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(-51, -65, 19).setRotationAngle(0, 0, 0).setName("Box 740")
		);
		chassis.add(new ModelRendererTurbo(chassis, 544, 68, textureX, textureY).addBox(0, 0, 0, 1, 13, 1)
			.setRotationPoint(-51, -65, -20).setRotationAngle(0, 0, 0).setName("Box 741")
		);
		chassis.add(new ModelRendererTurbo(chassis, 540, 68, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 13, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(-40, -65, 19).setRotationAngle(0, 0, 0).setName("Box 742")
		);
		chassis.add(new ModelRendererTurbo(chassis, 536, 68, textureX, textureY).addBox(0, 0, 0, 1, 13, 1)
			.setRotationPoint(-40, -65, -20).setRotationAngle(0, 0, 0).setName("Box 743")
		);
		chassis.add(new ModelRendererTurbo(chassis, 927, 2, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-51, -53, 19).setRotationAngle(0, 0, 0).setName("Box 744")
		);
		chassis.add(new ModelRendererTurbo(chassis, 996, 0, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(-51, -65, 19).setRotationAngle(0, 0, 0).setName("Box 745")
		);
		chassis.add(new ModelRendererTurbo(chassis, 22, 14, textureX, textureY)
			.addShapeBox(0, 0, 0, 9, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(-38, -66, 19).setRotationAngle(0, 0, 0).setName("Box 746")
		);
		chassis.add(new ModelRendererTurbo(chassis, 437, 10, textureX, textureY)
			.addShapeBox(0, 0, 0, 9, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-38, -51, 19).setRotationAngle(0, 0, 0).setName("Box 747")
		);
		chassis.add(new ModelRendererTurbo(chassis, 81, 71, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 16, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(-30, -66, 19).setRotationAngle(0, 0, 0).setName("Box 748")
		);
		chassis.add(new ModelRendererTurbo(chassis, 887, 70, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 16, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(-38, -66, 19).setRotationAngle(0, 0, 0).setName("Box 749")
		);
		chassis.add(new ModelRendererTurbo(chassis, 883, 70, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 16, 1, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-38, -66, -20).setRotationAngle(0, 0, 0).setName("Box 750")
		);
		chassis.add(new ModelRendererTurbo(chassis, 460, 8, textureX, textureY)
			.addShapeBox(0, 0, 0, 9, 1, 1, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-38, -51, -20).setRotationAngle(0, 0, 0).setName("Box 751")
		);
		chassis.add(new ModelRendererTurbo(chassis, 879, 70, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 16, 1, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-30, -66, -20).setRotationAngle(0, 0, 0).setName("Box 752")
		);
		chassis.add(new ModelRendererTurbo(chassis, 462, 3, textureX, textureY)
			.addShapeBox(0, 0, 0, 9, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-38, -66, -20).setRotationAngle(0, 0, 0).setName("Box 753")
		);
		chassis.add(new ModelRendererTurbo(chassis, 927, 0, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-51, -53, -20).setRotationAngle(0, 0, 0).setName("Box 754")
		);
		chassis.add(new ModelRendererTurbo(chassis, 532, 68, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 13, 1, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-51, -65, -20).setRotationAngle(0, 0, 0).setName("Box 755")
		);
		chassis.add(new ModelRendererTurbo(chassis, 14, 0, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-51, -65, -20).setRotationAngle(0, 0, 0).setName("Box 756")
		);
		chassis.add(new ModelRendererTurbo(chassis, 415, 45, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 13, 1, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-40, -65, -20).setRotationAngle(0, 0, 0).setName("Box 757")
		);
		chassis.add(new ModelRendererTurbo(chassis, 717, 174, textureX, textureY).addBox(0, 0, 0, 1, 34, 24)
			.setRotationPoint(-53, -67, -12).setRotationAngle(0, 0, 0).setName("Box 758")
		);
		chassis.add(new ModelRendererTurbo(chassis, 599, 23, textureX, textureY)
			.addShapeBox(0, 0, 0, 91, 2, 24, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-1, -69, -12).setRotationAngle(0, 0, 0).setName("Box 759")
		);
		chassis.add(new ModelRendererTurbo(chassis, 601, 0, textureX, textureY)
			.addShapeBox(0, 0, 0, 91, 1, 22, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-1, -70, -11).setRotationAngle(0, 0, 0).setName("Box 760")
		);
		chassis.add(new ModelRendererTurbo(chassis, 191, 142, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 24, 0, 0, 0, -1, 0, 0, -2, 0, 0, -2, 0, 0, -1, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(90, -69, -12).setRotationAngle(0, 0, 0).setName("Box 761")
		);
		chassis.add(new ModelRendererTurbo(chassis, 93, 141, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 22, 0, 0, 0, -1, 0, 0, -2, 0, 0, -2, 0, 0, -1, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(90, -70, -11).setRotationAngle(0, 0, 0).setName("Box 762")
		);
		chassis.add(new ModelRendererTurbo(chassis, 165, 136, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 22, 0, 0, 0, -1, 0, 0, -2, 0, 0, -2, 0, 0, -1, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(92, -69, -11).setRotationAngle(0, 0, 0).setName("Box 763")
		);
		chassis.add(new ModelRendererTurbo(chassis, 977, 108, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 20, 0, 0, 0, -1, 0, 0, -2, 0, 0, -2, 0, 0, -1, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(92, -70, -10).setRotationAngle(0, 0, 0).setName("Box 764")
		);
		chassis.add(new ModelRendererTurbo(chassis, 195, 168, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 20, 0, 0, 0, -1, 0, 0, -2, 0, 0, -2, 0, 0, -1, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(94, -69, -10).setRotationAngle(0, 0, 0).setName("Box 765")
		);
		chassis.add(new ModelRendererTurbo(chassis, 231, 93, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 18, 0, 0, 0, -1, -1, 0, -2, -1, 0, -2, 0, 0, -1, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(94, -70, -9).setRotationAngle(0, 0, 0).setName("Box 766")
		);
		chassis.add(new ModelRendererTurbo(chassis, 209, 68, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 18, 0, 0, 0, -1, -2, 0, -2, -2, 0, -2, 0, 0, -1, 0, 0, 0, -1, 0, -2, -1, 0, -2, 0, 0, 0)
			.setRotationPoint(95, -69, -9).setRotationAngle(0, 0, 0).setName("Box 767")
		);
		chassis.add(new ModelRendererTurbo(chassis, 923, 140, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 2, 24, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-8, -69, -12).setRotationAngle(0, 0, 0).setName("Box 768")
		);
		chassis.add(new ModelRendererTurbo(chassis, 357, 90, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 1, 22, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-8, -70, -11).setRotationAngle(0, 0, 0).setName("Box 769")
		);
		chassis.add(new ModelRendererTurbo(chassis, 225, 134, textureX, textureY)
			.addShapeBox(0, 0, 0, 35, 2, 24, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-89, -69, -12).setRotationAngle(0, 0, 0).setName("Box 770")
		);
		chassis.add(new ModelRendererTurbo(chassis, 869, 23, textureX, textureY)
			.addShapeBox(0, 0, 0, 35, 1, 22, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-89, -70, -11).setRotationAngle(0, 0, 0).setName("Box 771")
		);
		chassis.add(new ModelRendererTurbo(chassis, 43, 118, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 24, 0, 0, 0, -2, 0, 0, -1, 0, 0, -1, 0, 0, -2, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(-91, -69, -12).setRotationAngle(0, 0, 0).setName("Box 772")
		);
		chassis.add(new ModelRendererTurbo(chassis, 489, 94, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 20, 0, 0, 0, -2, 0, 0, -1, 0, 0, -1, 0, 0, -2, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(-93, -70, -10).setRotationAngle(0, 0, 0).setName("Box 773")
		);
		chassis.add(new ModelRendererTurbo(chassis, 77, 48, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 22, 0, 0, 0, -2, 0, 0, -1, 0, 0, -1, 0, 0, -2, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(-91, -70, -11).setRotationAngle(0, 0, 0).setName("Box 774")
		);
		chassis.add(new ModelRendererTurbo(chassis, 5, 48, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 22, 0, 0, 0, -2, 0, 0, -1, 0, 0, -1, 0, 0, -2, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(-93, -69, -11).setRotationAngle(0, 0, 0).setName("Box 775")
		);
		chassis.add(new ModelRendererTurbo(chassis, 161, 51, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 18, 0, -2, 0, -2, 0, 0, -1, 0, 0, -1, -2, 0, -2, -1, 0, -2, 0, 0, 0, 0, 0, 0, -1, 0, -2)
			.setRotationPoint(-96, -69, -9).setRotationAngle(0, 0, 0).setName("Box 776")
		);
		chassis.add(new ModelRendererTurbo(chassis, 665, 163, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 20, 0, 0, 0, -2, 0, 0, -1, 0, 0, -1, 0, 0, -2, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(-94, -69, -10).setRotationAngle(0, 0, 0).setName("Box 777")
		);
		chassis.add(new ModelRendererTurbo(chassis, 81, 71, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 18, 0, -1, 0, -2, 0, 0, -1, 0, 0, -1, -1, 0, -2, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(-94, -70, -9).setRotationAngle(0, 0, 0).setName("Box 778")
		);
		chassis.add(new ModelRendererTurbo(chassis, 528, 77, textureX, textureY)
			.addShapeBox(0, 0, 0, 47, 2, 41, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-55, -69, -20).setRotationAngle(0, 0, 0).setName("Box 779")
		);
		chassis.add(new ModelRendererTurbo(chassis, 746, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 47, 1, 39, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-55, -70, -19).setRotationAngle(0, 0, 0).setName("Box 780")
		);
		chassis.add(new ModelRendererTurbo(chassis, 401, 45, textureX, textureY)
			.addShapeBox(0, 0, 0, 47, 1, 37, 0, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-55, -71, -18).setRotationAngle(0, 0, 0).setName("Box 781")
		);
		chassis.add(new ModelRendererTurbo(chassis, 478, 0, textureX, textureY).addBox(0, 0, 0, 10, 0, 1)
			.setRotationPoint(-50, -57, -20).setRotationAngle(0, 0, 0).setName("Box 782")
		);
		chassis.add(new ModelRendererTurbo(chassis, 222, 0, textureX, textureY).addBox(0, 0, 0, 10, 0, 1)
			.setRotationPoint(-50, -57, 19).setRotationAngle(0, 0, 0).setName("Box 783")
		);
		chassis.add(new ModelRendererTurbo(chassis, 204, 45, textureX, textureY).addBox(0, 0, 0, 2, 1, 8)
			.setRotationPoint(-96.5f, -61, -4).setRotationAngle(0, 0, 0).setName("Box 1071")
		);
		chassis.add(new ModelRendererTurbo(chassis, 155, 45, textureX, textureY).addBox(0, 0, 0, 2, 1, 8)
			.setRotationPoint(-96.5f, -58, -4).setRotationAngle(0, 0, 0).setName("Box 1072")
		);
		chassis.add(new ModelRendererTurbo(chassis, 987, 18, textureX, textureY).addBox(0, 0, 0, 2, 2, 1)
			.setRotationPoint(-96.5f, -60, -4).setRotationAngle(0, 0, 0).setName("Box 1073")
		);
		chassis.add(new ModelRendererTurbo(chassis, 371, 17, textureX, textureY).addBox(0, 0, 0, 2, 2, 1)
			.setRotationPoint(-96.5f, -60, 3).setRotationAngle(0, 0, 0).setName("Box 1074")
		);
		chassis.add(new ModelRendererTurbo(chassis, 183, 40, textureX, textureY).addBox(0, 0, 0, 2, 2, 6)
			.setRotationPoint(-96.399994f, -60, -3).setRotationAngle(0, 0, 0).setName("Box 1075")
		);
		chassis.add(new ModelRendererTurbo(chassis, 947, 12, textureX, textureY).addBox(0, 0, 0, 10, 1, 1)
			.setRotationPoint(-24, -32, -21.5f).setRotationAngle(0, 0, 0).setName("Box 1076")
		);
		chassis.add(new ModelRendererTurbo(chassis, 17, 31, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-25, -32, -20.5f).setRotationAngle(0, 0, 0).setName("Box 1077")
		);
		chassis.add(new ModelRendererTurbo(chassis, 445, 30, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-14, -32, -20.5f).setRotationAngle(0, 0, 0).setName("Box 1078")
		);
		chassis.add(new ModelRendererTurbo(chassis, 417, 30, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-14, -29.5f, -20.5f).setRotationAngle(0, 0, 0).setName("Box 1079")
		);
		chassis.add(new ModelRendererTurbo(chassis, 601, 11, textureX, textureY).addBox(0, 0, 0, 10, 1, 1)
			.setRotationPoint(-24, -29.5f, -21.5f).setRotationAngle(0, 0, 0).setName("Box 1080")
		);
		chassis.add(new ModelRendererTurbo(chassis, 231, 30, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-25, -29.5f, -20.5f).setRotationAngle(0, 0, 0).setName("Box 1081")
		);
		chassis.add(new ModelRendererTurbo(chassis, 55, 30, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-14, -27, -20.5f).setRotationAngle(0, 0, 0).setName("Box 1082")
		);
		chassis.add(new ModelRendererTurbo(chassis, 505, 11, textureX, textureY).addBox(0, 0, 0, 10, 1, 1)
			.setRotationPoint(-24, -27, -21.5f).setRotationAngle(0, 0, 0).setName("Box 1083")
		);
		chassis.add(new ModelRendererTurbo(chassis, 51, 30, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-25, -27, -20.5f).setRotationAngle(0, 0, 0).setName("Box 1084")
		);
		chassis.add(new ModelRendererTurbo(chassis, 973, 29, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-14, -24.5f, -20.5f).setRotationAngle(0, 0, 0).setName("Box 1085")
		);
		chassis.add(new ModelRendererTurbo(chassis, 975, 8, textureX, textureY).addBox(0, 0, 0, 8, 1, 1)
			.setRotationPoint(-22, -24.5f, -21.5f).setRotationAngle(0, 0, 0).setName("Box 1086")
		);
		chassis.add(new ModelRendererTurbo(chassis, 969, 29, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-23, -24.5f, -20.5f).setRotationAngle(0, 0, 0).setName("Box 1087")
		);
		chassis.add(new ModelRendererTurbo(chassis, 965, 29, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-23, -22, -20.5f).setRotationAngle(0, 0, 0).setName("Box 1088")
		);
		chassis.add(new ModelRendererTurbo(chassis, 504, 8, textureX, textureY).addBox(0, 0, 0, 8, 1, 1)
			.setRotationPoint(-22, -22, -21.5f).setRotationAngle(0, 0, 0).setName("Box 1089")
		);
		chassis.add(new ModelRendererTurbo(chassis, 961, 29, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-14, -22, -20.5f).setRotationAngle(0, 0, 0).setName("Box 1090")
		);
		chassis.add(new ModelRendererTurbo(chassis, 395, 29, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-14, -19.5f, -20.5f).setRotationAngle(0, 0, 0).setName("Box 1091")
		);
		chassis.add(new ModelRendererTurbo(chassis, 580, 0, textureX, textureY).addBox(0, 0, 0, 6, 1, 1)
			.setRotationPoint(-20, -19.5f, -21.5f).setRotationAngle(0, 0, 0).setName("Box 1092")
		);
		chassis.add(new ModelRendererTurbo(chassis, 187, 29, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-21, -19.5f, -20.5f).setRotationAngle(0, 0, 0).setName("Box 1093")
		);
		chassis.add(new ModelRendererTurbo(chassis, 199, 9, textureX, textureY).addBox(0, 0, 0, 10, 1, 1)
			.setRotationPoint(-24, -29.5f, 20.5f).setRotationAngle(0, 0, 0).setName("Box 1094")
		);
		chassis.add(new ModelRendererTurbo(chassis, 436, 8, textureX, textureY).addBox(0, 0, 0, 10, 1, 1)
			.setRotationPoint(-24, -27, 20.5f).setRotationAngle(0, 0, 0).setName("Box 1095")
		);
		chassis.add(new ModelRendererTurbo(chassis, 396, 8, textureX, textureY).addBox(0, 0, 0, 10, 1, 1)
			.setRotationPoint(-24, -32, 20.5f).setRotationAngle(0, 0, 0).setName("Box 1096")
		);
		chassis.add(new ModelRendererTurbo(chassis, 976, 0, textureX, textureY).addBox(0, 0, 0, 8, 1, 1)
			.setRotationPoint(-22, -24.5f, 20.5f).setRotationAngle(0, 0, 0).setName("Box 1097")
		);
		chassis.add(new ModelRendererTurbo(chassis, 600, 0, textureX, textureY).addBox(0, 0, 0, 8, 1, 1)
			.setRotationPoint(-22, -22, 20.5f).setRotationAngle(0, 0, 0).setName("Box 1098")
		);
		chassis.add(new ModelRendererTurbo(chassis, 508, 0, textureX, textureY).addBox(0, 0, 0, 6, 1, 1)
			.setRotationPoint(-20, -19.5f, 20.5f).setRotationAngle(0, 0, 0).setName("Box 1099")
		);
		chassis.add(new ModelRendererTurbo(chassis, 109, 29, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0)
			.setRotationPoint(-21, -19.5f, 19.5f).setRotationAngle(0, 0, 0).setName("Box 1100")
		);
		chassis.add(new ModelRendererTurbo(chassis, 105, 29, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1)
			.setRotationPoint(-14, -19.5f, 19.5f).setRotationAngle(0, 0, 0).setName("Box 1101")
		);
		chassis.add(new ModelRendererTurbo(chassis, 93, 29, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1)
			.setRotationPoint(-14, -22, 19.5f).setRotationAngle(0, 0, 0).setName("Box 1102")
		);
		chassis.add(new ModelRendererTurbo(chassis, 89, 29, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0)
			.setRotationPoint(-23, -22, 19.5f).setRotationAngle(0, 0, 0).setName("Box 1103")
		);
		chassis.add(new ModelRendererTurbo(chassis, 60, 29, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0)
			.setRotationPoint(-23, -24.5f, 19.5f).setRotationAngle(0, 0, 0).setName("Box 1104")
		);
		chassis.add(new ModelRendererTurbo(chassis, 22, 29, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1)
			.setRotationPoint(-14, -24.5f, 19.5f).setRotationAngle(0, 0, 0).setName("Box 1105")
		);
		chassis.add(new ModelRendererTurbo(chassis, 18, 29, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1)
			.setRotationPoint(-14, -27, 19.5f).setRotationAngle(0, 0, 0).setName("Box 1106")
		);
		chassis.add(new ModelRendererTurbo(chassis, 377, 27, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0)
			.setRotationPoint(-25, -27, 19.5f).setRotationAngle(0, 0, 0).setName("Box 1107")
		);
		chassis.add(new ModelRendererTurbo(chassis, 249, 27, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0)
			.setRotationPoint(-25, -29.5f, 19.5f).setRotationAngle(0, 0, 0).setName("Box 1108")
		);
		chassis.add(new ModelRendererTurbo(chassis, 115, 27, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0)
			.setRotationPoint(-25, -32, 19.5f).setRotationAngle(0, 0, 0).setName("Box 1109")
		);
		chassis.add(new ModelRendererTurbo(chassis, 83, 27, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1)
			.setRotationPoint(-14, -32, 19.5f).setRotationAngle(0, 0, 0).setName("Box 1110")
		);
		chassis.add(new ModelRendererTurbo(chassis, 39, 27, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1)
			.setRotationPoint(-14, -29.5f, 19.5f).setRotationAngle(0, 0, 0).setName("Box 1111")
		);
		chassis.add(new ModelRendererTurbo(chassis, 525, 2, textureX, textureY).addBox(0, 0, 0, 22, 1, 1)
			.setRotationPoint(-87.5f, -65, 13).setRotationAngle(0, 0, 0).setName("Box 1112")
		);
		chassis.add(new ModelRendererTurbo(chassis, 389, 26, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(-88.5f, -65, 13).setRotationAngle(0, 0, 0).setName("Box 1113")
		);
		chassis.add(new ModelRendererTurbo(chassis, 12, 26, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(-65.5f, -65, 13).setRotationAngle(0, 0, 0).setName("Box 1114")
		);
		chassis.add(new ModelRendererTurbo(chassis, 477, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-65.5f, -65, -14).setRotationAngle(0, 0, 0).setName("Box 1115")
		);
		chassis.add(new ModelRendererTurbo(chassis, 377, 0, textureX, textureY).addBox(0, 0, 0, 22, 1, 1)
			.setRotationPoint(-87.5f, -65, -14).setRotationAngle(0, 0, 0).setName("Box 1116")
		);
		chassis.add(new ModelRendererTurbo(chassis, 473, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-88.5f, -65, -14).setRotationAngle(0, 0, 0).setName("Box 1117")
		);
		chassis.add(new ModelRendererTurbo(chassis, 469, 25, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(-65.5f, -65, -13).setRotationAngle(0, 0, 0).setName("Box 1118")
		);
		chassis.add(new ModelRendererTurbo(chassis, 459, 25, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(-88.5f, -65, -13).setRotationAngle(0, 0, 0).setName("Box 1119")
		);
		chassis.add(new ModelRendererTurbo(chassis, 455, 25, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(-65.5f, -65, 12).setRotationAngle(0, 0, 0).setName("Box 1120")
		);
		chassis.add(new ModelRendererTurbo(chassis, 451, 25, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(-88.5f, -65, 12).setRotationAngle(0, 0, 0).setName("Box 1121")
		);
		chassis.add(new ModelRendererTurbo(chassis, 694, 132, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 18, 7, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(-58, -51, 12).setRotationAngle(0, 0, 0).setName("Box 1122")
		);
		chassis.add(new ModelRendererTurbo(chassis, 909, 103, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 18, 7, 0, 0, -3, -1, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-58, -51, -19).setRotationAngle(0, 0, 0).setName("Box 1123")
		);
		chassis.add(new ModelRendererTurbo(chassis, 423, 31, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(95, -38, 9).setRotationAngle(0, 0, 0).setName("Box 1124")
		);
		chassis.add(new ModelRendererTurbo(chassis, 241, 31, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(95, -38, 7).setRotationAngle(0, 0, 0).setName("Box 1125")
		);
		chassis.add(new ModelRendererTurbo(chassis, 357, 30, textureX, textureY).addBox(0, 0, 0, 3, 3, 1)
			.setRotationPoint(95, -38, 8).setRotationAngle(0, 0, 0).setName("Box 1126")
		);
		chassis.add(new ModelRendererTurbo(chassis, 591, 29, textureX, textureY).addBox(0, 0, 0, 3, 3, 1)
			.setRotationPoint(95, -38, -9).setRotationAngle(0, 0, 0).setName("Box 1127")
		);
		chassis.add(new ModelRendererTurbo(chassis, 497, 29, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(95, -38, -10).setRotationAngle(0, 0, 0).setName("Box 1128")
		);
		chassis.add(new ModelRendererTurbo(chassis, 387, 29, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(95, -38, -8).setRotationAngle(0, 0, 0).setName("Box 1129")
		);
		chassis.add(new ModelRendererTurbo(chassis, 179, 29, textureX, textureY).addBox(0, 0, 0, 3, 3, 1)
			.setRotationPoint(-97, -39, 8).setRotationAngle(0, 0, 0).setName("Box 1130")
		);
		chassis.add(new ModelRendererTurbo(chassis, 119, 29, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(-97, -39, 9).setRotationAngle(0, 0, 0).setName("Box 1131")
		);
		chassis.add(new ModelRendererTurbo(chassis, 75, 29, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-97, -39, 7).setRotationAngle(0, 0, 0).setName("Box 1132")
		);
		chassis.add(new ModelRendererTurbo(chassis, 0, 29, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(-97, -39, -8).setRotationAngle(0, 0, 0).setName("Box 1133")
		);
		chassis.add(new ModelRendererTurbo(chassis, 10, 28, textureX, textureY).addBox(0, 0, 0, 3, 3, 1)
			.setRotationPoint(-97, -39, -9).setRotationAngle(0, 0, 0).setName("Box 1134")
		);
		chassis.add(new ModelRendererTurbo(chassis, 381, 24, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-97, -39, -10).setRotationAngle(0, 0, 0).setName("Box 1135")
		);
		chassis.add(new ModelRendererTurbo(chassis, 369, 24, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 4, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(94.5f, -63.5f, -2).setRotationAngle(0, 0, 0).setName("Box 1136")
		);
		chassis.add(new ModelRendererTurbo(chassis, 65, 27, textureX, textureY).addBox(0, 0, 0, 3, 4, 2)
			.setRotationPoint(94.5f, -63.5f, -1).setRotationAngle(0, 0, 0).setName("Box 1137")
		);
		chassis.add(new ModelRendererTurbo(chassis, 145, 24, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(94.5f, -63.5f, 1).setRotationAngle(0, 0, 0).setName("Box 1138")
		);
		chassis.add(new ModelRendererTurbo(chassis, 179, 26, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(99, -20, -12.5f).setRotationAngle(0, 0, 0).setName("Box 1139")
		);
		chassis.add(new ModelRendererTurbo(chassis, 592, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(99, -20, 11.5f).setRotationAngle(0, 0, 0).setName("Box 1140")
		);
		chassis.add(new ModelRendererTurbo(chassis, 45, 2, textureX, textureY).addBox(0, 0, 0, 89, 1, 1)
			.setRotationPoint(-9, -34, 19).setRotationAngle(0, 0, 0).setName("Box 1141")
		);
		chassis.add(new ModelRendererTurbo(chassis, 548, 5, textureX, textureY).addBox(0, 0, 0, 33, 1, 1)
			.setRotationPoint(-87, -34, 19).setRotationAngle(0, 0, 0).setName("Box 1142")
		);
		chassis.add(new ModelRendererTurbo(chassis, 167, 5, textureX, textureY).addBox(0, 0, 0, 33, 1, 1)
			.setRotationPoint(-87, -34, -20).setRotationAngle(0, 0, 0).setName("Box 1143")
		);
		chassis.add(new ModelRendererTurbo(chassis, 44, 0, textureX, textureY).addBox(0, 0, 0, 89, 1, 1)
			.setRotationPoint(-9, -34, -20).setRotationAngle(0, 0, 0).setName("Box 1144")
		);
		chassis.add(new ModelRendererTurbo(chassis, 915, 166, textureX, textureY).addBox(0, 0, 0, 1, 16, 42)
			.setRotationPoint(96, -34, -21).setRotationAngle(0, 0, 0).setName("Box 1145")
		);
		chassis.add(new ModelRendererTurbo(chassis, 34, 35, textureX, textureY).addBox(0, 0, 0, 1, 5, 1)
			.setRotationPoint(-100, -24, -12.5f).setRotationAngle(0, 0, 0).setName("Box 1146")
		);
		chassis.add(new ModelRendererTurbo(chassis, 447, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-100, -25, -12.5f).setRotationAngle(0, 0, 0).setName("Box 1147")
		);
		chassis.add(new ModelRendererTurbo(chassis, 117, 25, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(-99, -19, -12.5f).setRotationAngle(0, 0, 0).setName("Box 1148")
		);
		chassis.add(new ModelRendererTurbo(chassis, 113, 25, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(-99, -19, 11.5f).setRotationAngle(0, 0, 0).setName("Box 1149")
		);
		chassis.add(new ModelRendererTurbo(chassis, 85, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-100, -25, 11.5f).setRotationAngle(0, 0, 0).setName("Box 1150")
		);
		chassis.add(new ModelRendererTurbo(chassis, 365, 30, textureX, textureY).addBox(0, 0, 0, 1, 5, 1)
			.setRotationPoint(-100, -24, 11.5f).setRotationAngle(0, 0, 0).setName("Box 1151")
		);
		chassis.add(new ModelRendererTurbo(chassis, 81, 25, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(-99, -25, -12.5f).setRotationAngle(0, 0, 0).setName("Box 1152")
		);
		chassis.add(new ModelRendererTurbo(chassis, 69, 25, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(-99, -25, 11.5f).setRotationAngle(0, 0, 0).setName("Box 1153")
		);
		chassis.add(new ModelRendererTurbo(chassis, 65, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(-100, -19, -12.5f).setRotationAngle(0, 0, 0).setName("Box 1154")
		);
		chassis.add(new ModelRendererTurbo(chassis, 589, 24, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(-100, -19, 11.5f).setRotationAngle(0, 0, 0).setName("Box 1155")
		);
		chassis.add(new ModelRendererTurbo(chassis, 491, 36, textureX, textureY).addBox(0, 0, 0, 1, 1, 4)
			.setRotationPoint(-7, -52, 13.5f).setRotationAngle(0, 0, 0).setName("Box 1156")
		);
		chassis.add(new ModelRendererTurbo(chassis, 585, 24, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0)
			.setRotationPoint(-8, -52, 12.5f).setRotationAngle(0, 0, 0).setName("Box 1157")
		);
		chassis.add(new ModelRendererTurbo(chassis, 581, 24, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-8, -52, 17.5f).setRotationAngle(0, 0, 0).setName("Box 1158")
		);
		chassis.add(new ModelRendererTurbo(chassis, 577, 24, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-8, -52, -13.5f).setRotationAngle(0, 0, 0).setName("Box 1159")
		);
		chassis.add(new ModelRendererTurbo(chassis, 587, 33, textureX, textureY).addBox(0, 0, 0, 1, 1, 4)
			.setRotationPoint(-7, -52, -17.5f).setRotationAngle(0, 0, 0).setName("Box 1160")
		);
		chassis.add(new ModelRendererTurbo(chassis, 511, 24, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0)
			.setRotationPoint(-8, -52, -18.5f).setRotationAngle(0, 0, 0).setName("Box 1161")
		);
		chassis.add(new ModelRendererTurbo(chassis, 0, 4, textureX, textureY).addBox(0, 0, 0, 18, 1, 1)
			.setRotationPoint(-50, -49, -22).setRotationAngle(0, 0, 0).setName("Box 1162")
		);
		chassis.add(new ModelRendererTurbo(chassis, 507, 24, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-51, -49, -22).setRotationAngle(0, 0, 0).setName("Box 1163")
		);
		chassis.add(new ModelRendererTurbo(chassis, 503, 24, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(-51, -49, -21).setRotationAngle(0, 0, 0).setName("Box 1164")
		);
		chassis.add(new ModelRendererTurbo(chassis, 494, 24, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-32, -49, -22).setRotationAngle(0, 0, 0).setName("Box 1165")
		);
		chassis.add(new ModelRendererTurbo(chassis, 389, 24, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(-32, -49, -21).setRotationAngle(0, 0, 0).setName("Box 1166")
		);
		chassis.add(new ModelRendererTurbo(chassis, 0, 2, textureX, textureY).addBox(0, 0, 0, 18, 1, 1)
			.setRotationPoint(-50, -49, 21).setRotationAngle(0, 0, 0).setName("Box 1167")
		);
		chassis.add(new ModelRendererTurbo(chassis, 196, 24, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(-32, -49, 21).setRotationAngle(0, 0, 0).setName("Box 1168")
		);
		chassis.add(new ModelRendererTurbo(chassis, 192, 24, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(-32, -49, 20).setRotationAngle(0, 0, 0).setName("Box 1169")
		);
		chassis.add(new ModelRendererTurbo(chassis, 182, 24, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(-51, -49, 20).setRotationAngle(0, 0, 0).setName("Box 1170")
		);
		chassis.add(new ModelRendererTurbo(chassis, 178, 24, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(-51, -49, 21).setRotationAngle(0, 0, 0).setName("Box 1171")
		);
		chassis.add(new ModelRendererTurbo(chassis, 251, 38, textureX, textureY).addBox(0, 0, 0, 15, 17, 1)
			.setRotationPoint(-27, -51, -19.8f).setRotationAngle(0, 0, 0).setName("Box 1172")
		);
		chassis.add(new ModelRendererTurbo(chassis, 983, 33, textureX, textureY).addBox(0, 0, 0, 15, 17, 1)
			.setRotationPoint(-27, -51, 18.8f).setRotationAngle(0, 0, 0).setName("Box 1173")
		);
		chassis.add(new ModelRendererTurbo(chassis, 975, 11, textureX, textureY).addBox(0, 0, 0, 15, 1, 2)
			.setRotationPoint(-27, -52, 18.8f).setRotationAngle(0, 0, 0).setName("Box 1174")
		);
		chassis.add(new ModelRendererTurbo(chassis, 921, 9, textureX, textureY).addBox(0, 0, 0, 15, 1, 2)
			.setRotationPoint(-27, -52, -20.8f).setRotationAngle(0, 0, 0).setName("Box 1175")
		);
		chassis.add(new ModelRendererTurbo(chassis, 36, 24, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-18.5f, -50, -20).setRotationAngle(0, 0, 0).setName("Box 1176")
		);
		chassis.add(new ModelRendererTurbo(chassis, 5, 19, textureX, textureY).addBox(0, 0, 0, 3, 1, 1)
			.setRotationPoint(-17.5f, -50, -21).setRotationAngle(0, 0, 0).setName("Box 1177")
		);
		chassis.add(new ModelRendererTurbo(chassis, 29, 24, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-14.5f, -50, -20).setRotationAngle(0, 0, 0).setName("Box 1178")
		);
		chassis.add(new ModelRendererTurbo(chassis, 25, 24, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0)
			.setRotationPoint(-18.5f, -50, 19).setRotationAngle(0, 0, 0).setName("Box 1179")
		);
		chassis.add(new ModelRendererTurbo(chassis, 979, 18, textureX, textureY).addBox(0, 0, 0, 3, 1, 1)
			.setRotationPoint(-17.5f, -50, 20).setRotationAngle(0, 0, 0).setName("Box 1180")
		);
		chassis.add(new ModelRendererTurbo(chassis, 13, 24, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1)
			.setRotationPoint(-14.5f, -50, 19).setRotationAngle(0, 0, 0).setName("Box 1181")
		);
		chassis.add(new ModelRendererTurbo(chassis, 25, 77, textureX, textureY).addBox(0, 0, 0, 20, 10, 16)
			.setRotationPoint(-52, -43, -19).setRotationAngle(0, 0, 0).setName("Box 1436")
		);
		chassis.add(new ModelRendererTurbo(chassis, 121, 30, textureX, textureY).addBox(0, 0, 0, 10, 10, 8)
			.setRotationPoint(-52, -43, -3).setRotationAngle(0, 0, 0).setName("Box 1437")
		);
		chassis.add(new ModelRendererTurbo(chassis, 425, 31, textureX, textureY).addBox(0, 0, 0, 3, 1, 8)
			.setRotationPoint(-42, -42, -3).setRotationAngle(0, 0, 0).setName("Box 1438")
		);
		chassis.add(new ModelRendererTurbo(chassis, 217, 30, textureX, textureY).addBox(0, 0, 0, 3, 1, 8)
			.setRotationPoint(-40, -40, -3).setRotationAngle(0, 0, 0).setName("Box 1439")
		);
		chassis.add(new ModelRendererTurbo(chassis, 105, 29, textureX, textureY).addBox(0, 0, 0, 3, 1, 8)
			.setRotationPoint(-38, -38, -3).setRotationAngle(0, 0, 0).setName("Box 1440")
		);
		chassis.add(new ModelRendererTurbo(chassis, 75, 29, textureX, textureY).addBox(0, 0, 0, 3, 1, 8)
			.setRotationPoint(-36, -36, -3).setRotationAngle(0, 0, 0).setName("Box 1441")
		);
		chassis.add(new ModelRendererTurbo(chassis, 91, 24, textureX, textureY).addBox(0, 0, 0, 3, 1, 8)
			.setRotationPoint(-34, -34, -3).setRotationAngle(0, 0, 0).setName("Box 1442")
		);
		chassis.add(new ModelRendererTurbo(chassis, 663, 77, textureX, textureY).addBox(0, 0, 0, 23, 10, 14)
			.setRotationPoint(-52, -43, 5).setRotationAngle(0, 0, 0).setName("Box 1443")
		);
		chassis.add(new ModelRendererTurbo(chassis, 255, 7, textureX, textureY).addBox(0, 0, 0, 60, 6, 1)
			.setRotationPoint(18.5f, -27, 6.5f).setRotationAngle(0, 0, 0).setName("Box 1461")
		);
		chassis.add(new ModelRendererTurbo(chassis, 45, 4, textureX, textureY).addBox(0, 0, 0, 60, 6, 1)
			.setRotationPoint(18.5f, -27, -8.5f).setRotationAngle(0, 0, 0).setName("Box 1462")
		);
		chassis.add(new ModelRendererTurbo(chassis, 805, 0, textureX, textureY).addBox(0, 0, 0, 60, 6, 1)
			.setRotationPoint(-79.5f, -27, -8.5f).setRotationAngle(0, 0, 0).setName("Box 1463")
		);
		chassis.add(new ModelRendererTurbo(chassis, 255, 0, textureX, textureY).addBox(0, 0, 0, 60, 6, 1)
			.setRotationPoint(-79.5f, -27, 6.5f).setRotationAngle(0, 0, 0).setName("Box 1464")
		);
		chassis.add(new ModelRendererTurbo(chassis, 1013, 24, textureX, textureY).addBox(0, 0, 0, 3, 6, 1)
			.setRotationPoint(-52, -27, -2.5f).setRotationAngle(0, 0, 0).setName("Box 1412")
		);
		chassis.add(new ModelRendererTurbo(chassis, 149, 29, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 6, 1, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-49, -27, -2.5f).setRotationAngle(0, 0, 0).setName("Box 1413")
		);
		chassis.add(new ModelRendererTurbo(chassis, 554, 64, textureX, textureY).addBox(0, 0, 0, 1, 6, 3)
			.setRotationPoint(-49, -27, -1.5f).setRotationAngle(0, 0, 0).setName("Box 1414")
		);
		chassis.add(new ModelRendererTurbo(chassis, 961, 22, textureX, textureY).addBox(0, 0, 0, 3, 6, 1)
			.setRotationPoint(-52, -27, 1.5f).setRotationAngle(0, 0, 0).setName("Box 1415")
		);
		chassis.add(new ModelRendererTurbo(chassis, 485, 26, textureX, textureY).addBox(0, 0, 0, 3, 7, 3)
			.setRotationPoint(-52, -28, -1.5f).setRotationAngle(0, 0, 0).setName("Box 1416")
		);
		chassis.add(new ModelRendererTurbo(chassis, 879, 46, textureX, textureY).addBox(0, 0, 0, 3, 7, 3)
			.setRotationPoint(49.5f, -28, -1.5f).setRotationAngle(0, 0, 0).setName("Box 32")
		);
		chassis.add(new ModelRendererTurbo(chassis, 241, 45, textureX, textureY).addBox(0, 0, 0, 3, 6, 1)
			.setRotationPoint(49.5f, -27, 1.5f).setRotationAngle(0, 0, 0).setName("Box 33")
		);
		chassis.add(new ModelRendererTurbo(chassis, 402, 44, textureX, textureY).addBox(0, 0, 0, 3, 6, 1)
			.setRotationPoint(49.5f, -27, -2.5f).setRotationAngle(0, 0, 0).setName("Box 34")
		);
		chassis.add(new ModelRendererTurbo(chassis, 785, 89, textureX, textureY).addBox(0, 0, 0, 1, 6, 3)
			.setRotationPoint(48.5f, -27, -1.5f).setRotationAngle(0, 0, 0).setName("Box 35")
		);
		chassis.add(new ModelRendererTurbo(chassis, 574, 55, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 6, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0)
			.setRotationPoint(48.5f, -27, 1.5f).setRotationAngle(0, 0, 0).setName("Box 36")
		);
		chassis.add(new ModelRendererTurbo(chassis, 229, 55, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 6, 1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(48.5f, -27, -2.5f).setRotationAngle(0, 0, 0).setName("Box 37")
		);
		chassis.add(new ModelRendererTurbo(chassis, 213, 54, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 6, 1, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0)
			.setRotationPoint(52.5f, -27, 1.5f).setRotationAngle(0, 0, 0).setName("Box 41")
		);
		chassis.add(new ModelRendererTurbo(chassis, 165, 54, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 6, 1, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(52.5f, -27, -2.5f).setRotationAngle(0, 0, 0).setName("Box 42")
		);
		chassis.add(new ModelRendererTurbo(chassis, 777, 89, textureX, textureY).addBox(0, 0, 0, 1, 6, 3)
			.setRotationPoint(52.5f, -27, -1.5f).setRotationAngle(0, 0, 0).setName("Box 43")
		);
		chassis.add(new ModelRendererTurbo(chassis, 961, 142, textureX, textureY).addBox(0, 0, 0, 7, 34, 24)
			.setRotationPoint(-8, -67, -12).setRotationAngle(0, 0, 0).setName("Box 171")
		);
		this.groups.add(chassis);
		//
		TurboList doors_closed = new TurboList("doors_closed");
		doors_closed.add(new ModelRendererTurbo(doors_closed, 357, 90, textureX, textureY).addBox(0, 0, 0, 10, 20, 1)
			.setRotationPoint(12, -55, -12.5f).setRotationAngle(0, 0, 0).setName("Box 189")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 97, 40, textureX, textureY).addBox(0, 0, 0, 3, 6, 1)
			.setRotationPoint(19, -61, -12.5f).setRotationAngle(0, 0, 0).setName("Box 190")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 451, 19, textureX, textureY).addBox(0, 0, 0, 10, 2, 1)
			.setRotationPoint(12, -63, -12.5f).setRotationAngle(0, 0, 0).setName("Box 191")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 861, 39, textureX, textureY).addBox(0, 0, 0, 3, 6, 1)
			.setRotationPoint(12, -61, -12.5f).setRotationAngle(0, 0, 0).setName("Box 192")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 1014, 77, textureX, textureY).addBox(0, 0, 0, 1, 7, 1)
			.setRotationPoint(14, -61, -12.7f).setRotationAngle(0, 0, 0).setName("Box 193")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 401, 18, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(15, -55, -12.7f).setRotationAngle(0, 0, 0).setName("Box 194")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 1008, 77, textureX, textureY).addBox(0, 0, 0, 1, 7, 1)
			.setRotationPoint(19, -61, -12.7f).setRotationAngle(0, 0, 0).setName("Box 195")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 381, 18, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(15, -61, -12.7f).setRotationAngle(0, 0, 0).setName("Box 196")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 120, 18, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(15, -59.5f, -12.5f).setRotationAngle(0, 0, 0).setName("Box 197")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 104, 18, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(15, -59, -12.5f).setRotationAngle(0, 0, 0).setName("Box 198")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 88, 18, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(15, -58.5f, -12.5f).setRotationAngle(0, 0, 0).setName("Box 199")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 30, 18, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(15, -58, -12.5f).setRotationAngle(0, 0, 0).setName("Box 200")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 22, 18, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(15, -57.5f, -12.5f).setRotationAngle(0, 0, 0).setName("Box 201")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 4, 18, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(15, -57, -12.5f).setRotationAngle(0, 0, 0).setName("Box 202")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 984, 17, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(15, -56.5f, -12.5f).setRotationAngle(0, 0, 0).setName("Box 203")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 976, 17, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(15, -56, -12.5f).setRotationAngle(0, 0, 0).setName("Box 204")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 942, 17, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(15, -55.5f, -12.5f).setRotationAngle(0, 0, 0).setName("Box 205")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 439, 83, textureX, textureY).addBox(0, 0, 0, 10, 20, 1)
			.setRotationPoint(12, -55, 11.5f).setRotationAngle(0, 0, 0).setName("Box 275")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 165, 38, textureX, textureY).addBox(0, 0, 0, 3, 6, 1)
			.setRotationPoint(19, -61, 11.5f).setRotationAngle(0, 0, 0).setName("Box 292")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 371, 14, textureX, textureY).addBox(0, 0, 0, 10, 2, 1)
			.setRotationPoint(12, -63, 11.5f).setRotationAngle(0, 0, 0).setName("Box 293")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 157, 38, textureX, textureY).addBox(0, 0, 0, 3, 6, 1)
			.setRotationPoint(12, -61, 11.5f).setRotationAngle(0, 0, 0).setName("Box 294")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 512, 10, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(15, -56.5f, 11.5f).setRotationAngle(0, 0, 0).setName("Box 311")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 504, 10, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(15, -55.5f, 11.5f).setRotationAngle(0, 0, 0).setName("Box 312")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 404, 10, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(15, -56, 11.5f).setRotationAngle(0, 0, 0).setName("Box 313")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 396, 10, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(15, -57, 11.5f).setRotationAngle(0, 0, 0).setName("Box 314")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 378, 10, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(15, -57.5f, 11.5f).setRotationAngle(0, 0, 0).setName("Box 315")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 609, 9, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(15, -58, 11.5f).setRotationAngle(0, 0, 0).setName("Box 316")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 965, 8, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(15, -58.5f, 11.5f).setRotationAngle(0, 0, 0).setName("Box 317")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 944, 8, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(15, -59, 11.5f).setRotationAngle(0, 0, 0).setName("Box 318")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 936, 8, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(15, -59.5f, 11.5f).setRotationAngle(0, 0, 0).setName("Box 319")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 739, 77, textureX, textureY).addBox(0, 0, 0, 1, 7, 1)
			.setRotationPoint(19, -61, 11.7f).setRotationAngle(0, 0, 0).setName("Box 320")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 415, 15, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(15, -55, 11.7f).setRotationAngle(0, 0, 0).setName("Box 321")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 735, 77, textureX, textureY).addBox(0, 0, 0, 1, 7, 1)
			.setRotationPoint(14, -61, 11.7f).setRotationAngle(0, 0, 0).setName("Box 322")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 238, 15, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(15, -61, 11.7f).setRotationAngle(0, 0, 0).setName("Box 323")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 893, 64, textureX, textureY).addBox(0, 0, 0, 10, 20, 1)
			.setRotationPoint(35, -55, 11.5f).setRotationAngle(0, 0, 0).setName("Box 277")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 243, 56, textureX, textureY).addBox(0, 0, 0, 10, 20, 1)
			.setRotationPoint(58, -55, 11.5f).setRotationAngle(0, 0, 0).setName("Box 279")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 364, 38, textureX, textureY).addBox(0, 0, 0, 3, 6, 1)
			.setRotationPoint(65, -61, 11.5f).setRotationAngle(0, 0, 0).setName("Box 280")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 990, 14, textureX, textureY).addBox(0, 0, 0, 10, 2, 1)
			.setRotationPoint(58, -63, 11.5f).setRotationAngle(0, 0, 0).setName("Box 281")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 323, 38, textureX, textureY).addBox(0, 0, 0, 3, 6, 1)
			.setRotationPoint(58, -61, 11.5f).setRotationAngle(0, 0, 0).setName("Box 282")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 299, 38, textureX, textureY).addBox(0, 0, 0, 3, 6, 1)
			.setRotationPoint(42, -61, 11.5f).setRotationAngle(0, 0, 0).setName("Box 286")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 946, 14, textureX, textureY).addBox(0, 0, 0, 10, 2, 1)
			.setRotationPoint(35, -63, 11.5f).setRotationAngle(0, 0, 0).setName("Box 287")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 291, 38, textureX, textureY).addBox(0, 0, 0, 3, 6, 1)
			.setRotationPoint(35, -61, 11.5f).setRotationAngle(0, 0, 0).setName("Box 288")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 246, 6, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(38, -56.5f, 11.5f).setRotationAngle(0, 0, 0).setName("Box 337")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 36, 6, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(38, -55.5f, 11.5f).setRotationAngle(0, 0, 0).setName("Box 338")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 614, 5, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(38, -56, 11.5f).setRotationAngle(0, 0, 0).setName("Box 339")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 1004, 4, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(38, -57, 11.5f).setRotationAngle(0, 0, 0).setName("Box 340")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 996, 4, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(38, -57.5f, 11.5f).setRotationAngle(0, 0, 0).setName("Box 341")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 984, 4, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(38, -58, 11.5f).setRotationAngle(0, 0, 0).setName("Box 342")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 976, 4, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(38, -58.5f, 11.5f).setRotationAngle(0, 0, 0).setName("Box 343")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 956, 4, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(38, -59, 11.5f).setRotationAngle(0, 0, 0).setName("Box 344")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 942, 4, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(38, -59.5f, 11.5f).setRotationAngle(0, 0, 0).setName("Box 345")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 723, 77, textureX, textureY).addBox(0, 0, 0, 1, 7, 1)
			.setRotationPoint(42, -61, 11.7f).setRotationAngle(0, 0, 0).setName("Box 346")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 1009, 12, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(38, -55, 11.7f).setRotationAngle(0, 0, 0).setName("Box 347")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 245, 77, textureX, textureY).addBox(0, 0, 0, 1, 7, 1)
			.setRotationPoint(37, -61, 11.7f).setRotationAngle(0, 0, 0).setName("Box 348")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 577, 11, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(38, -61, 11.7f).setRotationAngle(0, 0, 0).setName("Box 349")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 503, 4, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(61, -56.5f, 11.5f).setRotationAngle(0, 0, 0).setName("Box 363")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 495, 4, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(61, -55.5f, 11.5f).setRotationAngle(0, 0, 0).setName("Box 364")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 221, 4, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(61, -56, 11.5f).setRotationAngle(0, 0, 0).setName("Box 365")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 213, 4, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(61, -57, 11.5f).setRotationAngle(0, 0, 0).setName("Box 366")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 205, 4, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(61, -57.5f, 11.5f).setRotationAngle(0, 0, 0).setName("Box 367")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 197, 4, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(61, -58, 11.5f).setRotationAngle(0, 0, 0).setName("Box 368")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 189, 4, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(61, -58.5f, 11.5f).setRotationAngle(0, 0, 0).setName("Box 369")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 181, 4, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(61, -59, 11.5f).setRotationAngle(0, 0, 0).setName("Box 370")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 173, 4, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(61, -59.5f, 11.5f).setRotationAngle(0, 0, 0).setName("Box 371")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 962, 76, textureX, textureY).addBox(0, 0, 0, 1, 7, 1)
			.setRotationPoint(65, -61, 11.7f).setRotationAngle(0, 0, 0).setName("Box 372")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 580, 9, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(61, -55, 11.7f).setRotationAngle(0, 0, 0).setName("Box 373")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 1004, 71, textureX, textureY).addBox(0, 0, 0, 1, 7, 1)
			.setRotationPoint(60, -61, 11.7f).setRotationAngle(0, 0, 0).setName("Box 374")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 241, 9, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(61, -61, 11.7f).setRotationAngle(0, 0, 0).setName("Box 375")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 273, 90, textureX, textureY).addBox(0, 0, 0, 10, 20, 1)
			.setRotationPoint(35, -55, -12.5f).setRotationAngle(0, 0, 0).setName("Box 223")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 837, 39, textureX, textureY).addBox(0, 0, 0, 3, 6, 1)
			.setRotationPoint(42, -61, -12.5f).setRotationAngle(0, 0, 0).setName("Box 224")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 997, 17, textureX, textureY).addBox(0, 0, 0, 10, 2, 1)
			.setRotationPoint(35, -63, -12.5f).setRotationAngle(0, 0, 0).setName("Box 225")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 829, 39, textureX, textureY).addBox(0, 0, 0, 3, 6, 1)
			.setRotationPoint(35, -61, -12.5f).setRotationAngle(0, 0, 0).setName("Box 226")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 771, 77, textureX, textureY).addBox(0, 0, 0, 1, 7, 1)
			.setRotationPoint(37, -61, -12.7f).setRotationAngle(0, 0, 0).setName("Box 227")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 177, 17, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(38, -55, -12.7f).setRotationAngle(0, 0, 0).setName("Box 228")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 767, 77, textureX, textureY).addBox(0, 0, 0, 1, 7, 1)
			.setRotationPoint(42, -61, -12.7f).setRotationAngle(0, 0, 0).setName("Box 229")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 161, 17, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(38, -61, -12.7f).setRotationAngle(0, 0, 0).setName("Box 230")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 120, 17, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(38, -59.5f, -12.5f).setRotationAngle(0, 0, 0).setName("Box 231")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 104, 17, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(38, -59, -12.5f).setRotationAngle(0, 0, 0).setName("Box 232")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 3, 17, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(38, -58.5f, -12.5f).setRotationAngle(0, 0, 0).setName("Box 233")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 1011, 16, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(38, -58, -12.5f).setRotationAngle(0, 0, 0).setName("Box 234")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 592, 16, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(38, -57.5f, -12.5f).setRotationAngle(0, 0, 0).setName("Box 235")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 584, 16, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(38, -57, -12.5f).setRotationAngle(0, 0, 0).setName("Box 236")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 576, 16, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(38, -56.5f, -12.5f).setRotationAngle(0, 0, 0).setName("Box 237")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 513, 16, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(38, -56, -12.5f).setRotationAngle(0, 0, 0).setName("Box 238")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 496, 16, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(38, -55.5f, -12.5f).setRotationAngle(0, 0, 0).setName("Box 239")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 483, 83, textureX, textureY).addBox(0, 0, 0, 10, 20, 1)
			.setRotationPoint(58, -55, -12.5f).setRotationAngle(0, 0, 0).setName("Box 257")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 805, 39, textureX, textureY).addBox(0, 0, 0, 3, 6, 1)
			.setRotationPoint(65, -61, -12.5f).setRotationAngle(0, 0, 0).setName("Box 258")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 805, 15, textureX, textureY).addBox(0, 0, 0, 10, 2, 1)
			.setRotationPoint(58, -63, -12.5f).setRotationAngle(0, 0, 0).setName("Box 259")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 181, 39, textureX, textureY).addBox(0, 0, 0, 3, 6, 1)
			.setRotationPoint(58, -61, -12.5f).setRotationAngle(0, 0, 0).setName("Box 260")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 755, 77, textureX, textureY).addBox(0, 0, 0, 1, 7, 1)
			.setRotationPoint(60, -61, -12.7f).setRotationAngle(0, 0, 0).setName("Box 261")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 209, 16, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(61, -55, -12.7f).setRotationAngle(0, 0, 0).setName("Box 262")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 751, 77, textureX, textureY).addBox(0, 0, 0, 1, 7, 1)
			.setRotationPoint(65, -61, -12.7f).setRotationAngle(0, 0, 0).setName("Box 263")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 193, 16, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(61, -61, -12.7f).setRotationAngle(0, 0, 0).setName("Box 264")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 177, 16, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(61, -59.5f, -12.5f).setRotationAngle(0, 0, 0).setName("Box 265")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 169, 16, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(61, -59, -12.5f).setRotationAngle(0, 0, 0).setName("Box 266")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 161, 16, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(61, -58.5f, -12.5f).setRotationAngle(0, 0, 0).setName("Box 267")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 153, 16, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(61, -58, -12.5f).setRotationAngle(0, 0, 0).setName("Box 268")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 121, 16, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(61, -57.5f, -12.5f).setRotationAngle(0, 0, 0).setName("Box 269")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 113, 16, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(61, -57, -12.5f).setRotationAngle(0, 0, 0).setName("Box 270")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 105, 16, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(61, -56.5f, -12.5f).setRotationAngle(0, 0, 0).setName("Box 271")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 97, 16, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(61, -56, -12.5f).setRotationAngle(0, 0, 0).setName("Box 272")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 37, 16, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(61, -55.5f, -12.5f).setRotationAngle(0, 0, 0).setName("Box 273")
		);
		this.groups.add(doors_closed);
		//
		TurboList doors_frontal = new TurboList("doors_frontal");
		doors_frontal.add(new ModelRendererTurbo(doors_frontal, 45, 16, textureX, textureY).addBox(0, 0, 0, 10, 8, 1)
			.setRotationPoint(-87, -63, 11.5f).setRotationAngle(0, 0, 0).setName("Box 608")
		);
		doors_frontal.add(new ModelRendererTurbo(doors_frontal, 65, 49, textureX, textureY).addBox(0, 0, 0, 10, 20, 1)
			.setRotationPoint(-87, -55, 11.5f).setRotationAngle(0, 0, 0).setName("Box 609")
		);
		doors_frontal.add(new ModelRendererTurbo(doors_frontal, 43, 49, textureX, textureY).addBox(0, 0, 0, 10, 20, 1)
			.setRotationPoint(-76, -55, 11.5f).setRotationAngle(0, 0, 0).setName("Box 610")
		);
		doors_frontal.add(new ModelRendererTurbo(doors_frontal, 531, 35, textureX, textureY).addBox(0, 0, 0, 3, 6, 1)
			.setRotationPoint(-76, -61, 11.5f).setRotationAngle(0, 0, 0).setName("Box 611")
		);
		doors_frontal.add(new ModelRendererTurbo(doors_frontal, 599, 13, textureX, textureY).addBox(0, 0, 0, 10, 2, 1)
			.setRotationPoint(-76, -63, 11.5f).setRotationAngle(0, 0, 0).setName("Box 612")
		);
		doors_frontal.add(new ModelRendererTurbo(doors_frontal, 505, 35, textureX, textureY).addBox(0, 0, 0, 3, 6, 1)
			.setRotationPoint(-69, -61, 11.5f).setRotationAngle(0, 0, 0).setName("Box 613")
		);
		doors_frontal.add(new ModelRendererTurbo(doors_frontal, 434, 58, textureX, textureY).addBox(0, 0, 0, 1, 7, 1)
			.setRotationPoint(-74, -61, 11.7f).setRotationAngle(0, 0, 0).setName("Box 631")
		);
		doors_frontal.add(new ModelRendererTurbo(doors_frontal, 554, 47, textureX, textureY).addBox(0, 0, 0, 1, 7, 1)
			.setRotationPoint(-69, -61, 11.7f).setRotationAngle(0, 0, 0).setName("Box 632")
		);
		doors_frontal.add(new ModelRendererTurbo(doors_frontal, 1013, 6, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(-73, -55, 11.7f).setRotationAngle(0, 0, 0).setName("Box 633")
		);
		doors_frontal.add(new ModelRendererTurbo(doors_frontal, 241, 1, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(-73, -61, 11.7f).setRotationAngle(0, 0, 0).setName("Box 634")
		);
		doors_frontal.add(new ModelRendererTurbo(doors_frontal, 223, 1, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(-73, -59.5f, 11.5f).setRotationAngle(0, 0, 0).setName("Box 635")
		);
		doors_frontal.add(new ModelRendererTurbo(doors_frontal, 0, 1, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(-73, -59, 11.5f).setRotationAngle(0, 0, 0).setName("Box 636")
		);
		doors_frontal.add(new ModelRendererTurbo(doors_frontal, 966, 0, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(-73, -58.5f, 11.5f).setRotationAngle(0, 0, 0).setName("Box 637")
		);
		doors_frontal.add(new ModelRendererTurbo(doors_frontal, 592, 0, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(-73, -58, 11.5f).setRotationAngle(0, 0, 0).setName("Box 638")
		);
		doors_frontal.add(new ModelRendererTurbo(doors_frontal, 572, 0, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(-73, -57.5f, 11.5f).setRotationAngle(0, 0, 0).setName("Box 639")
		);
		doors_frontal.add(new ModelRendererTurbo(doors_frontal, 498, 0, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(-73, -57, 11.5f).setRotationAngle(0, 0, 0).setName("Box 640")
		);
		doors_frontal.add(new ModelRendererTurbo(doors_frontal, 421, 0, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(-73, -56.5f, 11.5f).setRotationAngle(0, 0, 0).setName("Box 641")
		);
		doors_frontal.add(new ModelRendererTurbo(doors_frontal, 242, 0, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(-73, -56, 11.5f).setRotationAngle(0, 0, 0).setName("Box 642")
		);
		doors_frontal.add(new ModelRendererTurbo(doors_frontal, 0, 0, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(-73, -55.5f, 11.5f).setRotationAngle(0, 0, 0).setName("Box 643")
		);
		doors_frontal.add(new ModelRendererTurbo(doors_frontal, 613, 3, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(-67.5f, -51, 13).setRotationAngle(0, 0, 0).setName("Box 1217")
		);
		doors_frontal.add(new ModelRendererTurbo(doors_frontal, 1019, 16, textureX, textureY).addBox(0, 0, 0, 1, 2, 1)
			.setRotationPoint(-67.5f, -53, 13).setRotationAngle(0, 0, 0).setName("Box 1218")
		);
		doors_frontal.add(new ModelRendererTurbo(doors_frontal, 989, 2, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-67.5f, -54, 13).setRotationAngle(0, 0, 0).setName("Box 1219")
		);
		doors_frontal.add(new ModelRendererTurbo(doors_frontal, 761, 49, textureX, textureY).addBox(0, 0, 0, 10, 20, 1)
			.setRotationPoint(-87, -55, -12.5f).setRotationAngle(0, 0, 0).setName("Box 603")
		);
		doors_frontal.add(new ModelRendererTurbo(doors_frontal, 67, 16, textureX, textureY).addBox(0, 0, 0, 10, 8, 1)
			.setRotationPoint(-87, -63, -12.5f).setRotationAngle(0, 0, 0).setName("Box 605")
		);
		doors_frontal.add(new ModelRendererTurbo(doors_frontal, 1015, 33, textureX, textureY).addBox(0, 0, 0, 3, 6, 1)
			.setRotationPoint(-69, -61, -12.5f).setRotationAngle(0, 0, 0).setName("Box 614")
		);
		doors_frontal.add(new ModelRendererTurbo(doors_frontal, 577, 13, textureX, textureY).addBox(0, 0, 0, 10, 2, 1)
			.setRotationPoint(-76, -63, -12.5f).setRotationAngle(0, 0, 0).setName("Box 615")
		);
		doors_frontal.add(new ModelRendererTurbo(doors_frontal, 961, 33, textureX, textureY).addBox(0, 0, 0, 3, 6, 1)
			.setRotationPoint(-76, -61, -12.5f).setRotationAngle(0, 0, 0).setName("Box 616")
		);
		doors_frontal.add(new ModelRendererTurbo(doors_frontal, 532, 47, textureX, textureY).addBox(0, 0, 0, 10, 20, 1)
			.setRotationPoint(-76, -55, -12.5f).setRotationAngle(0, 0, 0).setName("Box 617")
		);
		doors_frontal.add(new ModelRendererTurbo(doors_frontal, 115, 71, textureX, textureY).addBox(0, 0, 0, 1, 7, 1)
			.setRotationPoint(-74, -61, -12.7f).setRotationAngle(0, 0, 0).setName("Box 618")
		);
		doors_frontal.add(new ModelRendererTurbo(doors_frontal, 485, 8, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(-73, -61, -12.7f).setRotationAngle(0, 0, 0).setName("Box 619")
		);
		doors_frontal.add(new ModelRendererTurbo(doors_frontal, 407, 65, textureX, textureY).addBox(0, 0, 0, 1, 7, 1)
			.setRotationPoint(-69, -61, -12.7f).setRotationAngle(0, 0, 0).setName("Box 620")
		);
		doors_frontal.add(new ModelRendererTurbo(doors_frontal, 379, 8, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(-73, -55, -12.7f).setRotationAngle(0, 0, 0).setName("Box 621")
		);
		doors_frontal.add(new ModelRendererTurbo(doors_frontal, 165, 4, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(-73, -55.5f, -12.5f).setRotationAngle(0, 0, 0).setName("Box 622")
		);
		doors_frontal.add(new ModelRendererTurbo(doors_frontal, 36, 4, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(-73, -56, -12.5f).setRotationAngle(0, 0, 0).setName("Box 623")
		);
		doors_frontal.add(new ModelRendererTurbo(doors_frontal, 224, 3, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(-73, -56.5f, -12.5f).setRotationAngle(0, 0, 0).setName("Box 624")
		);
		doors_frontal.add(new ModelRendererTurbo(doors_frontal, 608, 2, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(-73, -57, -12.5f).setRotationAngle(0, 0, 0).setName("Box 625")
		);
		doors_frontal.add(new ModelRendererTurbo(doors_frontal, 600, 2, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(-73, -57.5f, -12.5f).setRotationAngle(0, 0, 0).setName("Box 626")
		);
		doors_frontal.add(new ModelRendererTurbo(doors_frontal, 580, 2, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(-73, -58, -12.5f).setRotationAngle(0, 0, 0).setName("Box 627")
		);
		doors_frontal.add(new ModelRendererTurbo(doors_frontal, 469, 2, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(-73, -58.5f, -12.5f).setRotationAngle(0, 0, 0).setName("Box 628")
		);
		doors_frontal.add(new ModelRendererTurbo(doors_frontal, 461, 2, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(-73, -59, -12.5f).setRotationAngle(0, 0, 0).setName("Box 629")
		);
		doors_frontal.add(new ModelRendererTurbo(doors_frontal, 223, 2, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(-73, -59.5f, -12.5f).setRotationAngle(0, 0, 0).setName("Box 630")
		);
		doors_frontal.add(new ModelRendererTurbo(doors_frontal, 435, 19, textureX, textureY).addBox(0, 0, 0, 1, 2, 1)
			.setRotationPoint(-67.5f, -53, -14).setRotationAngle(0, 0, 0).setName("Box 1212")
		);
		doors_frontal.add(new ModelRendererTurbo(doors_frontal, 388, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-67.5f, -54, -14).setRotationAngle(0, 0, 0).setName("Box 1213")
		);
		doors_frontal.add(new ModelRendererTurbo(doors_frontal, 231, 9, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(-67.5f, -54, -13).setRotationAngle(0, 0, 0).setName("Box 1214")
		);
		doors_frontal.add(new ModelRendererTurbo(doors_frontal, 251, 7, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(-67.5f, -51, -13).setRotationAngle(0, 0, 0).setName("Box 1215")
		);
		doors_frontal.add(new ModelRendererTurbo(doors_frontal, 40, 7, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-67.5f, -51, -14).setRotationAngle(0, 0, 0).setName("Box 1216")
		);
		this.groups.add(doors_frontal);
		//
		TurboList doors_openable = new TurboList("doors_openable");
		doors_openable.add(new ModelRendererTurbo(doors_openable, 295, 90, textureX, textureY).addBox(0, 0, 0, 10, 20, 1)
			.setRotationPoint(24, -55, -12.5f).setRotationAngle(0, 0, 0).setName("Box 206")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 853, 39, textureX, textureY).addBox(0, 0, 0, 3, 6, 1)
			.setRotationPoint(31, -61, -12.5f).setRotationAngle(0, 0, 0).setName("Box 207")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 805, 18, textureX, textureY).addBox(0, 0, 0, 10, 2, 1)
			.setRotationPoint(24, -63, -12.5f).setRotationAngle(0, 0, 0).setName("Box 208")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 845, 39, textureX, textureY).addBox(0, 0, 0, 3, 6, 1)
			.setRotationPoint(24, -61, -12.5f).setRotationAngle(0, 0, 0).setName("Box 209")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 779, 77, textureX, textureY).addBox(0, 0, 0, 1, 7, 1)
			.setRotationPoint(26, -61, -12.7f).setRotationAngle(0, 0, 0).setName("Box 210")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 581, 17, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(27, -55, -12.7f).setRotationAngle(0, 0, 0).setName("Box 211")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 775, 77, textureX, textureY).addBox(0, 0, 0, 1, 7, 1)
			.setRotationPoint(31, -61, -12.7f).setRotationAngle(0, 0, 0).setName("Box 212")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 471, 17, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(27, -61, -12.7f).setRotationAngle(0, 0, 0).setName("Box 213")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 456, 17, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(27, -59.5f, -12.5f).setRotationAngle(0, 0, 0).setName("Box 214")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 448, 17, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(27, -59, -12.5f).setRotationAngle(0, 0, 0).setName("Box 215")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 430, 17, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(27, -58.5f, -12.5f).setRotationAngle(0, 0, 0).setName("Box 216")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 422, 17, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(27, -58, -12.5f).setRotationAngle(0, 0, 0).setName("Box 217")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 406, 17, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(27, -57.5f, -12.5f).setRotationAngle(0, 0, 0).setName("Box 218")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 398, 17, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(27, -57, -12.5f).setRotationAngle(0, 0, 0).setName("Box 219")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 379, 17, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(27, -56.5f, -12.5f).setRotationAngle(0, 0, 0).setName("Box 220")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 240, 17, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(27, -56, -12.5f).setRotationAngle(0, 0, 0).setName("Box 221")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 224, 17, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(27, -55.5f, -12.5f).setRotationAngle(0, 0, 0).setName("Box 222")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 13, 19, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(32.5f, -54, -13).setRotationAngle(0, 0, 0).setName("Box 1202")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 591, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(32.5f, -54, -14).setRotationAngle(0, 0, 0).setName("Box 1203")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 947, 20, textureX, textureY).addBox(0, 0, 0, 1, 2, 1)
			.setRotationPoint(32.5f, -53, -14).setRotationAngle(0, 0, 0).setName("Box 1204")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 516, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(32.5f, -51, -14).setRotationAngle(0, 0, 0).setName("Box 1205")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 485, 17, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(32.5f, -51, -13).setRotationAngle(0, 0, 0).setName("Box 1206")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 265, 56, textureX, textureY).addBox(0, 0, 0, 10, 20, 1)
			.setRotationPoint(47, -55, 11.5f).setRotationAngle(0, 0, 0).setName("Box 278")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 315, 38, textureX, textureY).addBox(0, 0, 0, 3, 6, 1)
			.setRotationPoint(54, -61, 11.5f).setRotationAngle(0, 0, 0).setName("Box 283")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 968, 14, textureX, textureY).addBox(0, 0, 0, 10, 2, 1)
			.setRotationPoint(47, -63, 11.5f).setRotationAngle(0, 0, 0).setName("Box 284")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 307, 38, textureX, textureY).addBox(0, 0, 0, 3, 6, 1)
			.setRotationPoint(47, -61, 11.5f).setRotationAngle(0, 0, 0).setName("Box 285")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 934, 4, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(50, -56.5f, 11.5f).setRotationAngle(0, 0, 0).setName("Box 350")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 926, 4, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(50, -55.5f, 11.5f).setRotationAngle(0, 0, 0).setName("Box 351")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 564, 4, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(50, -56, 11.5f).setRotationAngle(0, 0, 0).setName("Box 352")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 556, 4, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(50, -57, 11.5f).setRotationAngle(0, 0, 0).setName("Box 353")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 548, 4, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(50, -57.5f, 11.5f).setRotationAngle(0, 0, 0).setName("Box 354")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 540, 4, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(50, -58, 11.5f).setRotationAngle(0, 0, 0).setName("Box 355")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 532, 4, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(50, -58.5f, 11.5f).setRotationAngle(0, 0, 0).setName("Box 356")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 524, 4, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(50, -59, 11.5f).setRotationAngle(0, 0, 0).setName("Box 357")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 511, 4, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(50, -59.5f, 11.5f).setRotationAngle(0, 0, 0).setName("Box 358")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 241, 77, textureX, textureY).addBox(0, 0, 0, 1, 7, 1)
			.setRotationPoint(54, -61, 11.7f).setRotationAngle(0, 0, 0).setName("Box 359")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 1007, 10, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(50, -55, 11.7f).setRotationAngle(0, 0, 0).setName("Box 360")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 966, 76, textureX, textureY).addBox(0, 0, 0, 1, 7, 1)
			.setRotationPoint(49, -61, 11.7f).setRotationAngle(0, 0, 0).setName("Box 361")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 601, 9, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(50, -61, 11.7f).setRotationAngle(0, 0, 0).setName("Box 362")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 9, 24, textureX, textureY).addBox(0, 0, 0, 1, 2, 1)
			.setRotationPoint(55.5f, -53, 13).setRotationAngle(0, 0, 0).setName("Box 1182")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 969, 23, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(55.5f, -54, 12).setRotationAngle(0, 0, 0).setName("Box 1183")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 617, 23, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(55.5f, -54, 13).setRotationAngle(0, 0, 0).setName("Box 1184")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 523, 23, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(55.5f, -51, 13).setRotationAngle(0, 0, 0).setName("Box 1185")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 519, 23, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(55.5f, -51, 12).setRotationAngle(0, 0, 0).setName("Box 1186")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 411, 127, textureX, textureY).addBox(0, 0, 0, 10, 20, 1)
			.setRotationPoint(1, -55, -12.5f).setRotationAngle(0, 0, 0).setName("Box 172")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 473, 19, textureX, textureY).addBox(0, 0, 0, 10, 2, 1)
			.setRotationPoint(1, -63, -12.5f).setRotationAngle(0, 0, 0).setName("Box 173")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 113, 44, textureX, textureY).addBox(0, 0, 0, 3, 6, 1)
			.setRotationPoint(1, -61, -12.5f).setRotationAngle(0, 0, 0).setName("Box 174")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 1015, 40, textureX, textureY).addBox(0, 0, 0, 3, 6, 1)
			.setRotationPoint(8, -61, -12.5f).setRotationAngle(0, 0, 0).setName("Box 175")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 113, 79, textureX, textureY).addBox(0, 0, 0, 1, 7, 1)
			.setRotationPoint(3, -61, -12.7f).setRotationAngle(0, 0, 0).setName("Box 176")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 1018, 77, textureX, textureY).addBox(0, 0, 0, 1, 7, 1)
			.setRotationPoint(8, -61, -12.7f).setRotationAngle(0, 0, 0).setName("Box 177")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 943, 18, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(4, -61, -12.7f).setRotationAngle(0, 0, 0).setName("Box 178")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 507, 18, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(4, -55, -12.7f).setRotationAngle(0, 0, 0).setName("Box 179")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 456, 18, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(4, -56, -12.5f).setRotationAngle(0, 0, 0).setName("Box 180")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 448, 18, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(4, -56.5f, -12.5f).setRotationAngle(0, 0, 0).setName("Box 181")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 430, 18, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(4, -57.5f, -12.5f).setRotationAngle(0, 0, 0).setName("Box 182")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 422, 18, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(4, -57, -12.5f).setRotationAngle(0, 0, 0).setName("Box 183")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 409, 18, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(4, -58.5f, -12.5f).setRotationAngle(0, 0, 0).setName("Box 184")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 240, 18, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(4, -58, -12.5f).setRotationAngle(0, 0, 0).setName("Box 185")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 224, 18, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(4, -59.5f, -12.5f).setRotationAngle(0, 0, 0).setName("Box 186")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 208, 18, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(4, -59, -12.5f).setRotationAngle(0, 0, 0).setName("Box 187")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 192, 18, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(4, -55.5f, -12.5f).setRotationAngle(0, 0, 0).setName("Box 188")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 439, 17, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(9.5f, -54, -13).setRotationAngle(0, 0, 0).setName("Box 1207")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 390, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(9.5f, -54, -14).setRotationAngle(0, 0, 0).setName("Box 1208")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 943, 20, textureX, textureY).addBox(0, 0, 0, 1, 2, 1)
			.setRotationPoint(9.5f, -53, -14).setRotationAngle(0, 0, 0).setName("Box 1209")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 217, 11, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(9.5f, -51, -14).setRotationAngle(0, 0, 0).setName("Box 1210")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 967, 9, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(9.5f, -51, -13).setRotationAngle(0, 0, 0).setName("Box 1211")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 251, 90, textureX, textureY).addBox(0, 0, 0, 10, 20, 1)
			.setRotationPoint(47, -55, -12.5f).setRotationAngle(0, 0, 0).setName("Box 240")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 821, 39, textureX, textureY).addBox(0, 0, 0, 3, 6, 1)
			.setRotationPoint(54, -61, -12.5f).setRotationAngle(0, 0, 0).setName("Box 241")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 133, 16, textureX, textureY).addBox(0, 0, 0, 10, 2, 1)
			.setRotationPoint(47, -63, -12.5f).setRotationAngle(0, 0, 0).setName("Box 242")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 813, 39, textureX, textureY).addBox(0, 0, 0, 3, 6, 1)
			.setRotationPoint(47, -61, -12.5f).setRotationAngle(0, 0, 0).setName("Box 243")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 763, 77, textureX, textureY).addBox(0, 0, 0, 1, 7, 1)
			.setRotationPoint(49, -61, -12.7f).setRotationAngle(0, 0, 0).setName("Box 244")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 505, 16, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(50, -55, -12.7f).setRotationAngle(0, 0, 0).setName("Box 245")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 759, 77, textureX, textureY).addBox(0, 0, 0, 1, 7, 1)
			.setRotationPoint(54, -61, -12.7f).setRotationAngle(0, 0, 0).setName("Box 246")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 488, 16, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(50, -61, -12.7f).setRotationAngle(0, 0, 0).setName("Box 247")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 480, 16, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(50, -59.5f, -12.5f).setRotationAngle(0, 0, 0).setName("Box 248")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 472, 16, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(50, -59, -12.5f).setRotationAngle(0, 0, 0).setName("Box 249")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 464, 16, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(50, -58.5f, -12.5f).setRotationAngle(0, 0, 0).setName("Box 250")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 456, 16, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(50, -58, -12.5f).setRotationAngle(0, 0, 0).setName("Box 251")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 424, 16, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(50, -57.5f, -12.5f).setRotationAngle(0, 0, 0).setName("Box 252")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 225, 16, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(50, -57, -12.5f).setRotationAngle(0, 0, 0).setName("Box 253")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 217, 16, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(50, -56.5f, -12.5f).setRotationAngle(0, 0, 0).setName("Box 254")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 201, 16, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(50, -56, -12.5f).setRotationAngle(0, 0, 0).setName("Box 255")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 185, 16, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(50, -55.5f, -12.5f).setRotationAngle(0, 0, 0).setName("Box 256")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 425, 19, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(55.5f, -51, -14).setRotationAngle(0, 0, 0).setName("Box 1197")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 972, 21, textureX, textureY).addBox(0, 0, 0, 1, 2, 1)
			.setRotationPoint(55.5f, -53, -14).setRotationAngle(0, 0, 0).setName("Box 1198")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 410, 19, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(55.5f, -54, -14).setRotationAngle(0, 0, 0).setName("Box 1199")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 227, 19, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(55.5f, -54, -13).setRotationAngle(0, 0, 0).setName("Box 1200")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 37, 19, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(55.5f, -51, -13).setRotationAngle(0, 0, 0).setName("Box 1201")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 976, 76, textureX, textureY).addBox(0, 0, 0, 10, 20, 1)
			.setRotationPoint(24, -55, 11.5f).setRotationAngle(0, 0, 0).setName("Box 276")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 283, 38, textureX, textureY).addBox(0, 0, 0, 3, 6, 1)
			.setRotationPoint(31, -61, 11.5f).setRotationAngle(0, 0, 0).setName("Box 289")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 393, 14, textureX, textureY).addBox(0, 0, 0, 10, 2, 1)
			.setRotationPoint(24, -63, 11.5f).setRotationAngle(0, 0, 0).setName("Box 290")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 173, 38, textureX, textureY).addBox(0, 0, 0, 3, 6, 1)
			.setRotationPoint(24, -61, 11.5f).setRotationAngle(0, 0, 0).setName("Box 291")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 928, 8, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(27, -56.5f, 11.5f).setRotationAngle(0, 0, 0).setName("Box 324")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 920, 8, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(27, -55.5f, 11.5f).setRotationAngle(0, 0, 0).setName("Box 325")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 613, 8, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(27, -56, 11.5f).setRotationAngle(0, 0, 0).setName("Box 326")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 493, 8, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(27, -57, 11.5f).setRotationAngle(0, 0, 0).setName("Box 327")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 387, 8, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(27, -57.5f, 11.5f).setRotationAngle(0, 0, 0).setName("Box 328")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 612, 7, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(27, -58, 11.5f).setRotationAngle(0, 0, 0).setName("Box 329")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 563, 7, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(27, -58.5f, 11.5f).setRotationAngle(0, 0, 0).setName("Box 330")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 555, 7, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(27, -59, 11.5f).setRotationAngle(0, 0, 0).setName("Box 331")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 547, 7, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(27, -59.5f, 11.5f).setRotationAngle(0, 0, 0).setName("Box 332")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 731, 77, textureX, textureY).addBox(0, 0, 0, 1, 7, 1)
			.setRotationPoint(31, -61, 11.7f).setRotationAngle(0, 0, 0).setName("Box 333")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 1012, 14, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(27, -55, 11.7f).setRotationAngle(0, 0, 0).setName("Box 334")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 727, 77, textureX, textureY).addBox(0, 0, 0, 1, 7, 1)
			.setRotationPoint(26, -61, 11.7f).setRotationAngle(0, 0, 0).setName("Box 335")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 239, 13, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(27, -61, 11.7f).setRotationAngle(0, 0, 0).setName("Box 336")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 454, 22, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(32.5f, -51, 13).setRotationAngle(0, 0, 0).setName("Box 1187")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 515, 23, textureX, textureY).addBox(0, 0, 0, 1, 2, 1)
			.setRotationPoint(32.5f, -53, 13).setRotationAngle(0, 0, 0).setName("Box 1188")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 248, 22, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(32.5f, -54, 13).setRotationAngle(0, 0, 0).setName("Box 1189")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 129, 22, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(32.5f, -54, 12).setRotationAngle(0, 0, 0).setName("Box 1190")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 993, 19, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(32.5f, -51, 12).setRotationAngle(0, 0, 0).setName("Box 1191")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 461, 83, textureX, textureY).addBox(0, 0, 0, 10, 20, 1)
			.setRotationPoint(1, -55, 11.5f).setRotationAngle(0, 0, 0).setName("Box 274")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 106, 38, textureX, textureY).addBox(0, 0, 0, 3, 6, 1)
			.setRotationPoint(8, -61, 11.5f).setRotationAngle(0, 0, 0).setName("Box 295")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 0, 14, textureX, textureY).addBox(0, 0, 0, 10, 2, 1)
			.setRotationPoint(1, -63, 11.5f).setRotationAngle(0, 0, 0).setName("Box 296")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 75, 38, textureX, textureY).addBox(0, 0, 0, 3, 6, 1)
			.setRotationPoint(1, -61, 11.5f).setRotationAngle(0, 0, 0).setName("Box 297")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 747, 77, textureX, textureY).addBox(0, 0, 0, 1, 7, 1)
			.setRotationPoint(8, -61, 11.7f).setRotationAngle(0, 0, 0).setName("Box 298")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 89, 16, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(4, -61, 11.7f).setRotationAngle(0, 0, 0).setName("Box 299")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 743, 77, textureX, textureY).addBox(0, 0, 0, 1, 7, 1)
			.setRotationPoint(3, -61, 11.7f).setRotationAngle(0, 0, 0).setName("Box 300")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 29, 16, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(4, -55, 11.7f).setRotationAngle(0, 0, 0).setName("Box 301")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 21, 16, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(4, -56.5f, 11.5f).setRotationAngle(0, 0, 0).setName("Box 302")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 452, 15, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(4, -55.5f, 11.5f).setRotationAngle(0, 0, 0).setName("Box 303")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 431, 15, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(4, -56, 11.5f).setRotationAngle(0, 0, 0).setName("Box 304")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 423, 15, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(4, -57, 11.5f).setRotationAngle(0, 0, 0).setName("Box 305")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 246, 15, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(4, -57.5f, 11.5f).setRotationAngle(0, 0, 0).setName("Box 306")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 1015, 10, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(4, -58, 11.5f).setRotationAngle(0, 0, 0).setName("Box 307")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 998, 10, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(4, -58.5f, 11.5f).setRotationAngle(0, 0, 0).setName("Box 308")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 982, 10, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(4, -59, 11.5f).setRotationAngle(0, 0, 0).setName("Box 309")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 974, 10, textureX, textureY).addBox(0, 0, 0, 4, 0, 1)
			.setRotationPoint(4, -59.5f, 11.5f).setRotationAngle(0, 0, 0).setName("Box 310")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 589, 19, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(9.5f, -51, 13).setRotationAngle(0, 0, 0).setName("Box 1192")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 478, 22, textureX, textureY).addBox(0, 0, 0, 1, 2, 1)
			.setRotationPoint(9.5f, -53, 13).setRotationAngle(0, 0, 0).setName("Box 1193")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 585, 19, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(9.5f, -54, 13).setRotationAngle(0, 0, 0).setName("Box 1194")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 581, 19, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(9.5f, -54, 12).setRotationAngle(0, 0, 0).setName("Box 1195")
		);
		doors_openable.add(new ModelRendererTurbo(doors_openable, 429, 19, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(9.5f, -51, 12).setRotationAngle(0, 0, 0).setName("Box 1196")
		);
		doors_openable.addProgram(DefaultPrograms.DOOR_CLOSE);
		this.groups.add(doors_openable);
		this.translate(0, 8, 0);
	}
	
	@Override
	public void render(VehicleData data, Object key){
		GL11.glRotatef(180f, 0, 1, 0);
		super.render(data, key);
		GL11.glRotatef(-180f, 0, 1, 0);
	}

	@Override
	public void render(VehicleData data, Object key, VehicleEntity ent, int meta){
		GL11.glRotatef(180f, 0, 1, 0);
		super.render(data, key, ent, meta);
		GL11.glRotatef(-180f, 0, 1, 0);
	}

}
