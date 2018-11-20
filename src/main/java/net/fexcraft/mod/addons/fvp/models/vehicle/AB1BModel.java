//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.vehicle;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.vehicle.VehicleModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.1-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/vehicle/ab1b")
public class AB1BModel extends VehicleModel {

	public AB1BModel(){
		super(); textureX = 1024; textureY = 1024;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList cargo_bay_left = new TurboList("cargo_bay_left");
		cargo_bay_left.add(new ModelRendererTurbo(cargo_bay_left, 657, 33, textureX, textureY).addBox(0, 0, 0, 24, 9, 1)
			.setRotationPoint(24, -13, 30.5f).setRotationAngle(0, 0, 0).setName("Box 42")
		);
		cargo_bay_left.add(new ModelRendererTurbo(cargo_bay_left, 953, 49, textureX, textureY).addBox(0, 0, 0, 24, 9, 1)
			.setRotationPoint(-5, -13, 30.5f).setRotationAngle(0, 0, 0).setName("Box 43")
		);
		cargo_bay_left.add(new ModelRendererTurbo(cargo_bay_left, 689, 57, textureX, textureY).addBox(0, 0, 0, 24, 9, 1)
			.setRotationPoint(-34, -13, 30.5f).setRotationAngle(0, 0, 0).setName("Box 44")
		);
		cargo_bay_left.addProgram(DefaultPrograms.RGB_PRIMARY);
		this.groups.add(cargo_bay_left);
		//
		TurboList cargo_bay_right = new TurboList("cargo_bay_right");
		cargo_bay_right.add(new ModelRendererTurbo(cargo_bay_right, 745, 57, textureX, textureY).addBox(0, 0, -1, 24, 9, 1)
			.setRotationPoint(-34, -13, -30.5f).setRotationAngle(0, 0, 0).setName("Box 49")
		);
		cargo_bay_right.add(new ModelRendererTurbo(cargo_bay_right, 953, 65, textureX, textureY).addBox(0, 0, -1, 24, 9, 1)
			.setRotationPoint(-5, -13, -30.5f).setRotationAngle(0, 0, 0).setName("Box 50")
		);
		cargo_bay_right.add(new ModelRendererTurbo(cargo_bay_right, 689, 73, textureX, textureY).addBox(0, 0, -1, 24, 9, 1)
			.setRotationPoint(24, -13, -30.5f).setRotationAngle(0, 0, 0).setName("Box 51")
		);
		cargo_bay_right.addProgram(DefaultPrograms.RGB_PRIMARY);
		this.groups.add(cargo_bay_right);
		//
		TurboList chassis_core = new TurboList("chassis_core");
		chassis_core.add(new ModelRendererTurbo(chassis_core, 217, 1, textureX, textureY).addBox(0, 0, 0, 166, 2, 46)
			.setRotationPoint(-112, -3, -23).setRotationAngle(0, 0, 0).setName("Box 6")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 593, 1, textureX, textureY).addBox(-2, -2, 0, 4, 4, 50)
			.setRotationPoint(68, -2, -25).setRotationAngle(0, 0, 0).setName("Box 7")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 705, 1, textureX, textureY).addBox(-2, -2, 0, 4, 4, 50)
			.setRotationPoint(-70, -2, -25).setRotationAngle(0, 0, 0).setName("Box 8")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 657, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 20, 2, 9, 0, 0, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(82, -3, -32).setRotationAngle(0, 0, 0).setName("Box 10")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 769, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 20, 2, 9, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, 0, 0, 0)
			.setRotationPoint(82, -3, 23).setRotationAngle(0, 0, 0).setName("Box 11")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 833, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 28, 2, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0)
			.setRotationPoint(-112, -3, 23).setRotationAngle(0, 0, 0).setName("Box 12")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 913, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 28, 2, 9, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-112, -3, -32).setRotationAngle(0, 0, 0).setName("Box 13")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 769, 17, textureX, textureY).addBox(0, 0, 0, 110, 2, 9)
			.setRotationPoint(-56, -3, 23).setRotationAngle(0, 0, 0).setName("Box 14")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 33, textureX, textureY).addBox(0, 0, 0, 110, 2, 9)
			.setRotationPoint(-56, -3, -32).setRotationAngle(0, 0, 0).setName("Box 15")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 769, 33, textureX, textureY).addBox(0, 0, 0, 110, 6, 1)
			.setRotationPoint(-56, -4, 30.5f).setRotationAngle(0, 0, 0).setName("Box 16")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 769, 41, textureX, textureY).addBox(0, 0, 0, 110, 6, 1)
			.setRotationPoint(-56, -4, -31.5f).setRotationAngle(0, 0, 0).setName("Box 17")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 601, 1, textureX, textureY).addBox(0, 0, 0, 16, 6, 1)
			.setRotationPoint(82, -4, 30.5f).setRotationAngle(0, 0, 0).setName("Box 18")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 713, 1, textureX, textureY).addBox(0, 0, 0, 16, 6, 1)
			.setRotationPoint(82, -4, -31.5f).setRotationAngle(0, 0, 0).setName("Box 19")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 993, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 6, 8, 0, -3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(97, -4, 23.5f).setRotationAngle(0, 0, 0).setName("Box 20")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 601, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 6, 8, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, -3, 0, 0)
			.setRotationPoint(97, -4, -31.5f).setRotationAngle(0, 0, 0).setName("Box 21")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 49, textureX, textureY).addBox(0, 0, 0, 1, 6, 47)
			.setRotationPoint(100, -4, -23.5f).setRotationAngle(0, 0, 0).setName("Box 22")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 41, 49, textureX, textureY).addBox(0, 0, 0, 2, 10, 61)
			.setRotationPoint(-56, -13, -30.5f).setRotationAngle(0, 0, 0).setName("Box 23")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 657, 17, textureX, textureY).addBox(0, 0, 0, 24, 6, 1)
			.setRotationPoint(-108, -4, -31.5f).setRotationAngle(0, 0, 0).setName("Box 24")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 657, 25, textureX, textureY).addBox(0, 0, 0, 24, 6, 1)
			.setRotationPoint(-108, -4, 30.5f).setRotationAngle(0, 0, 0).setName("Box 25")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 713, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 6, 8, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 3, 0, 0)
			.setRotationPoint(-108, -4, -31.5f).setRotationAngle(0, 0, 0).setName("Box 26")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 617, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 6, 8, 0, 3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-108, -4, 23.5f).setRotationAngle(0, 0, 0).setName("Box 27")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 113, 49, textureX, textureY).addBox(0, 0, 0, 1, 6, 47)
			.setRotationPoint(-111, -4, -23.5f).setRotationAngle(0, 0, 0).setName("Box 28")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 785, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 28, 12, 35, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(54, -13, -17.5f).setRotationAngle(0, 0, 0).setName("Box 29")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 169, 57, textureX, textureY).addBox(0, 0, 0, 20, 2, 46)
			.setRotationPoint(82, -3, -23).setRotationAngle(0, 0, 0).setName("Box 30")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 241, 57, textureX, textureY).addBox(0, 0, 0, 37, 1, 61)
			.setRotationPoint(-108, -19, -30.5f).setRotationAngle(0, 0, 0).setName("Box 31")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 857, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 15, 1, 61, 0, 0, 0, 0, 0, -6, 0, 0, -6, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 6, 0, 0, 0, 0)
			.setRotationPoint(-71, -19, -30.5f).setRotationAngle(0, 0, 0).setName("Box 32")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 441, 57, textureX, textureY).addBox(0, 0, 0, 92, 1, 61)
			.setRotationPoint(-38, -13, -30.5f).setRotationAngle(0, 0, 0).setName("Box 33")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 377, 57, textureX, textureY).addBox(0, 0, 0, 14, 9, 44)
			.setRotationPoint(-54, -13, -13.5f).setRotationAngle(0, 0, 0).setName("Box 34")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 729, 81, textureX, textureY).addBox(0, 0, 0, 12, 2, 18)
			.setRotationPoint(71, -17, 11).setRotationAngle(0, 0, 0).setName("Box 60")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 137, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 47, 0, 0, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, 0, 0, 0, 0, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, 0, 0, 0)
			.setRotationPoint(100, -10, -23.5f).setRotationAngle(0, 0, 0).setName("Box 67")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 633, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 10, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, -4.8f, 0, 0, 2.8f, -3.6f, 0, 2.8f, -3.6f, -0.5f, -4.8f, 0, -0.5f)
			.setRotationPoint(77, -11, 31.5f).setRotationAngle(0, 0, 0).setName("Box 84")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 633, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 10, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 2.8f, -3.6f, 0, -4.8f, 0, 0, -4.8f, 0, -0.5f, 2.8f, -3.6f, -0.5f)
			.setRotationPoint(57, -11, 31.5f).setRotationAngle(0, 0, 0).setName("Box 85")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, -7, 0, 0, 7, 0, 0, 7, 0, -0.5f, -7, 0, -0.5f)
			.setRotationPoint(70, -15, 31.5f).setRotationAngle(0, 0, 0).setName("Box 86")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 57, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 7, 0, 0, -7, 0, 0, -7, 0, -0.5f, 7, 0, -0.5f)
			.setRotationPoint(64, -15, 31.5f).setRotationAngle(0, 0, 0).setName("Box 87")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 129, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 1, 1, 0, -3, 0, 0, -3, 0, 0, -3, 0, -0.5f, -3, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(64, -16, 31.5f).setRotationAngle(0, 0, 0).setName("Box 88")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 705, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 14, 43, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0)
			.setRotationPoint(-111, -23, -21.5f).setRotationAngle(0, 0, 0).setName("Box 92")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 65, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 1, 0, 0.2f, -0.4f, 0, 0, -2, 0, 0, -2, -0.5f, 0.2f, -0.4f, -0.5f, 0.2f, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0.2f, 0, -0.5f)
			.setRotationPoint(82, -5, 31.5f).setRotationAngle(0, 0, 0).setName("Box 98")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 121, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 1, 0, 0, -2, 0, 0.2f, -0.4f, 0, 0.2f, -0.4f, -0.5f, 0, -2, -0.5f, 0, 0, 0, 0.2f, 0, 0, 0.2f, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(53, -5, 31.5f).setRotationAngle(0, 0, 0).setName("Box 99")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 169, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 10, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, -4.8f, 0, -0.5f, 2.8f, -3.6f, -0.5f, 2.8f, -3.6f, 0, -4.8f, 0, 0)
			.setRotationPoint(77, -11, -32.5f).setRotationAngle(0, 0, 0).setName("Box 100")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 201, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 10, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 2.8f, -3.6f, -0.5f, -4.8f, 0, -0.5f, -4.8f, 0, 0, 2.8f, -3.6f, 0)
			.setRotationPoint(57, -11, -32.5f).setRotationAngle(0, 0, 0).setName("Box 101")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 129, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, -7, 0, -0.5f, 7, 0, -0.5f, 7, 0, 0, -7, 0, 0)
			.setRotationPoint(70, -15, -32.5f).setRotationAngle(0, 0, 0).setName("Box 102")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 185, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 7, 0, -0.5f, -7, 0, -0.5f, -7, 0, 0, 7, 0, 0)
			.setRotationPoint(64, -15, -32.5f).setRotationAngle(0, 0, 0).setName("Box 103")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 473, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 1, 1, 0, -3, 0, -0.5f, -3, 0, -0.5f, -3, 0, 0, -3, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(64, -16, -32.5f).setRotationAngle(0, 0, 0).setName("Box 104")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 193, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 1, 0, 0.2f, -0.4f, -0.5f, 0, -2, -0.5f, 0, -2, 0, 0.2f, -0.4f, 0, 0.2f, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0.2f, 0, 0)
			.setRotationPoint(82, -5, -32.5f).setRotationAngle(0, 0, 0).setName("Box 105")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 249, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 1, 0, 0, -2, -0.5f, 0.2f, -0.4f, -0.5f, 0.2f, -0.4f, 0, 0, -2, 0, 0, 0, -0.5f, 0.2f, 0, -0.5f, 0.2f, 0, 0, 0, 0, 0)
			.setRotationPoint(53, -5, -32.5f).setRotationAngle(0, 0, 0).setName("Box 106")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 569, 121, textureX, textureY).addBox(0, 0, 0, 15, 1, 61)
			.setRotationPoint(82, -4, -30.5f).setRotationAngle(0, 0, 0).setName("Box 109")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 753, 129, textureX, textureY).addBox(0, 0, 0, 1, 1, 47)
			.setRotationPoint(100, -9.5f, -23.5f).setRotationAngle(0, 0, 0).setName("Box 110")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 137, textureX, textureY).addBox(0, 0, 0, 1, 1, 47)
			.setRotationPoint(100, -7.5f, -23.5f).setRotationAngle(0, 0, 0).setName("Box 111")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 193, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 17, 47, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(97, -21, -23.5f).setRotationAngle(0, 0, 0).setName("Box 112")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 801, 129, textureX, textureY).addBox(0, 0, 0, 14, 4, 54)
			.setRotationPoint(82, -8, -23.5f).setRotationAngle(0, 0, 0).setName("Box 115")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 297, 137, textureX, textureY).addBox(0, 0, 0, 15, 4, 47)
			.setRotationPoint(82, -12, -16.5f).setRotationAngle(0, 0, 0).setName("Box 116")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 473, 161, textureX, textureY).addBox(0, 0, 0, 1, 1, 43)
			.setRotationPoint(-111, -22.5f, -21.5f).setRotationAngle(0, 0, 0).setName("Box 129")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 113, 169, textureX, textureY).addBox(0, 0, 0, 1, 1, 43)
			.setRotationPoint(-111, -21, -21.5f).setRotationAngle(0, 0, 0).setName("Box 130")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 521, 177, textureX, textureY).addBox(0, 0, 0, 1, 1, 43)
			.setRotationPoint(-111, -19.5f, -21.5f).setRotationAngle(0, 0, 0).setName("Box 131")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 897, 177, textureX, textureY).addBox(0, 0, 0, 1, 1, 43)
			.setRotationPoint(-111, -18, -21.5f).setRotationAngle(0, 0, 0).setName("Box 132")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 569, 185, textureX, textureY).addBox(0, 0, 0, 1, 1, 43)
			.setRotationPoint(-111, -16.5f, -21.5f).setRotationAngle(0, 0, 0).setName("Box 133")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 721, 185, textureX, textureY).addBox(0, 0, 0, 1, 1, 43)
			.setRotationPoint(-111, -15, -21.5f).setRotationAngle(0, 0, 0).setName("Box 134")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 193, textureX, textureY).addBox(0, 0, 0, 1, 1, 43)
			.setRotationPoint(-111, -13.5f, -21.5f).setRotationAngle(0, 0, 0).setName("Box 135")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 257, 193, textureX, textureY).addBox(0, 0, 0, 1, 1, 43)
			.setRotationPoint(-111, -12, -21.5f).setRotationAngle(0, 0, 0).setName("Box 136")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 353, 193, textureX, textureY).addBox(0, 0, 0, 1, 1, 43)
			.setRotationPoint(-111, -10.5f, -21.5f).setRotationAngle(0, 0, 0).setName("Box 137")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 945, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 21, 1, 9, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-84, -16, 21.5f).setRotationAngle(0, 0, 0).setName("Box 175")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 249, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 21, 1, 9, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-84, -16, -30.5f).setRotationAngle(0, 0, 0).setName("Box 179")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 473, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 4, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -7, 0, 0, 7, 0, 0, 7, 0, 0, -7, 0, 0)
			.setRotationPoint(-68, -15, -30.5f).setRotationAngle(0, 0, 0).setName("Box 180")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 289, textureX, textureY).addBox(0, 0, 0, 14, 1, 61)
			.setRotationPoint(-54, -4, -30.5f).setRotationAngle(0, 0, 0).setName("Box 190")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 577, 145, textureX, textureY).addBox(0, 0, 0, 14, 4, 11)
			.setRotationPoint(-54, -8, -24.5f).setRotationAngle(0, 0, 0).setName("Box 191")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 377, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 14, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-54, -12, -17.5f).setRotationAngle(0, 0, 0).setName("Box 192")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 153, 289, textureX, textureY).addBox(0, 0, 0, 2, 10, 61)
			.setRotationPoint(-40, -13, -30.5f).setRotationAngle(0, 0, 0).setName("Box 193")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 4, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -7, 0, 0, 7, 0, 0, 7, 0, 0, -7, 0, 0)
			.setRotationPoint(-68, -15, 21.5f).setRotationAngle(0, 0, 0).setName("Box 196")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 113, 89, textureX, textureY).addBox(0, 0, 0, 6, 4, 1)
			.setRotationPoint(74, -16, 13).setRotationAngle(0, 0, 0).setName("Box 207")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 409, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 10, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, -4.8f, 0, 0, 2.8f, -3.6f, 0, 2.8f, -3.6f, -0.5f, -4.8f, 0, -0.5f)
			.setRotationPoint(-61, -11, 31.5f).setRotationAngle(0, 0, 0).setName("Box 213")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 801, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 10, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 2.8f, -3.6f, 0, -4.8f, 0, 0, -4.8f, 0, -0.5f, 2.8f, -3.6f, -0.5f)
			.setRotationPoint(-81, -11, 31.5f).setRotationAngle(0, 0, 0).setName("Box 214")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 657, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, -7, 0, 0, 7, 0, 0, 7, 0, -0.5f, -7, 0, -0.5f)
			.setRotationPoint(-68, -15, 31.5f).setRotationAngle(0, 0, 0).setName("Box 215")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 769, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 7, 0, 0, -7, 0, 0, -7, 0, -0.5f, 7, 0, -0.5f)
			.setRotationPoint(-74, -15, 31.5f).setRotationAngle(0, 0, 0).setName("Box 216")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 777, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 1, 1, 0, -3, 0, 0, -3, 0, 0, -3, 0, -0.5f, -3, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(-74, -16, 31.5f).setRotationAngle(0, 0, 0).setName("Box 217")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1009, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 1, 0, 0.2f, -0.4f, 0, 0, -2, 0, 0, -2, -0.5f, 0.2f, -0.4f, -0.5f, 0.2f, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0.2f, 0, -0.5f)
			.setRotationPoint(-56, -5, 31.5f).setRotationAngle(0, 0, 0).setName("Box 218")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 601, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 1, 0, 0, -2, 0, 0.2f, -0.4f, 0, 0.2f, -0.4f, -0.5f, 0, -2, -0.5f, 0, 0, 0, 0.2f, 0, 0, 0.2f, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(-85, -5, 31.5f).setRotationAngle(0, 0, 0).setName("Box 305")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1009, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 10, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, -4.8f, 0, -0.5f, 2.8f, -3.6f, -0.5f, 2.8f, -3.6f, 0, -4.8f, 0, 0)
			.setRotationPoint(-61, -11, -32.5f).setRotationAngle(0, 0, 0).setName("Box 306")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 113, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 10, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 2.8f, -3.6f, -0.5f, -4.8f, 0, -0.5f, -4.8f, 0, 0, 2.8f, -3.6f, 0)
			.setRotationPoint(-81, -11, -32.5f).setRotationAngle(0, 0, 0).setName("Box 307")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 729, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, -7, 0, -0.5f, 7, 0, -0.5f, 7, 0, 0, -7, 0, 0)
			.setRotationPoint(-68, -15, -32.5f).setRotationAngle(0, 0, 0).setName("Box 308")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 769, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 7, 0, -0.5f, -7, 0, -0.5f, -7, 0, 0, 7, 0, 0)
			.setRotationPoint(-74, -15, -32.5f).setRotationAngle(0, 0, 0).setName("Box 309")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 129, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 1, 1, 0, -3, 0, -0.5f, -3, 0, -0.5f, -3, 0, 0, -3, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-74, -16, -32.5f).setRotationAngle(0, 0, 0).setName("Box 310")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1001, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 1, 0, 0.2f, -0.4f, -0.5f, 0, -2, -0.5f, 0, -2, 0, 0.2f, -0.4f, 0, 0.2f, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0.2f, 0, 0)
			.setRotationPoint(-56, -5, -32.5f).setRotationAngle(0, 0, 0).setName("Box 311")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 257, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 1, 0, 0, -2, -0.5f, 0.2f, -0.4f, -0.5f, 0.2f, -0.4f, 0, 0, -2, 0, 0, 0, -0.5f, 0.2f, 0, -0.5f, 0.2f, 0, 0, 0, 0, 0)
			.setRotationPoint(-85, -5, -32.5f).setRotationAngle(0, 0, 0).setName("Box 312")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 425, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 2, 11, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(90, -23, 14).setRotationAngle(0, 0, 0).setName("Box 313")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 809, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 8, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -7, 0, 1, 1, 0, 1, 1, 0, 0, -7, 0)
			.setRotationPoint(90, -21, 13.5f).setRotationAngle(0, 0, 0).setName("Box 314")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 281, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 8, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -7, 0, 0, -7, 0)
			.setRotationPoint(86, -21, 8.5f).setRotationAngle(0, 0, 0).setName("Box 315")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 161, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 8, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -7, 0, 0, -7, 0, 0, 1, 0, 0, 1, 0)
			.setRotationPoint(86, -21, 25.5f).setRotationAngle(0, 0, 0).setName("Box 316")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 457, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 2, 6, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(86, -23, 8).setRotationAngle(0, 0, 0).setName("Box 317")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 305, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 2, 6, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(86, -23, 25).setRotationAngle(0, 0, 0).setName("Box 318")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 393, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 2, 6, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(90, -23, 25).setRotationAngle(0, 0, 0).setName("Box 319")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 473, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 2, 6, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(90, -23, 8).setRotationAngle(0, 0, 0).setName("Box 320")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1001, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 8, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -7, 0, 0, -7, 0)
			.setRotationPoint(90, -21, 8.5f).setRotationAngle(0, 0, 0).setName("Box 321")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 665, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 8, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -7, 0, 0, -7, 0, 0, 1, 0, 0, 1, 0)
			.setRotationPoint(90, -21, 25.5f).setRotationAngle(0, 0, 0).setName("Box 322")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 689, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 10, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 3, 0, 0, 3, 0, 0, -3, 0, 0)
			.setRotationPoint(87, -22, 17.5f).setRotationAngle(0, 0, 0).setName("Box 323")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 2, 0, 0.1f, 0, -0.1f, -0.4f, 0.4f, -0.1f, -0.4f, 0.4f, -0.1f, 0.1f, 0, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.1f)
			.setRotationPoint(87.5f, -24, 18).setRotationAngle(0, 0, 0).setName("Box 324")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 945, 177, textureX, textureY).addBox(0, 0, 0, 2, 14, 18)
			.setRotationPoint(70, -30, 11).setRotationAngle(0, 0, -0.06981317f).setName("Box 330")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 457, 57, textureX, textureY).addBox(0, 0, 0, 2, 2, 1)
			.setRotationPoint(80, -20, -31).setRotationAngle(0, 0, 0).setName("Box 295")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 65, textureX, textureY).addBox(0, 0, 0, 2, 2, 1)
			.setRotationPoint(-56, -24, -31).setRotationAngle(0, 0, 0).setName("Box 297")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 753, 129, textureX, textureY)
			.addShapeBox(0, -2, -2, 1, 4, 4, 0, 0, -0.5f, -0.5f, 0, -1, -1, 0, -1, -1, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -1, -1, 0, -1, -1, 0, -0.5f, -0.5f)
			.setRotationPoint(100.5f, -8, 0).setRotationAngle(0, 0, 0).setName("Box 305")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 729, 57, textureX, textureY).addBox(0, 0, -6, 1, 3, 12)
			.setRotationPoint(101, -1, 0).setRotationAngle(0, 0, 0.08726647f).setName("Box 310")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 65, 65, textureX, textureY).addBox(-1, 0, -6, 1, 3, 12)
			.setRotationPoint(-110.5f, -6.5f, 0).setRotationAngle(0, 0, 0).setName("Box 311")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 993, 65, textureX, textureY).addBox(0, 0, -6, 1, 3, 12)
			.setRotationPoint(95.5f, -22.5f, 15).setRotationAngle(0, 0, -0.7853982f).setName("Box 312")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 617, 185, textureX, textureY).addBox(0, 0, 0, 2, 36, 2)
			.setRotationPoint(57, -48, 7).setRotationAngle(0, 0, 0).setName("Box 313")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 633, 185, textureX, textureY).addBox(0, 0, 0, 2, 36, 2)
			.setRotationPoint(73, -48, 7).setRotationAngle(0, 0, 0).setName("Box 314")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 649, 185, textureX, textureY).addBox(0, 0, 0, 2, 36, 2)
			.setRotationPoint(57, -48, 28).setRotationAngle(0, 0, 0).setName("Box 315")
		);
		this.groups.add(chassis_core);
		//
		TurboList chassis_primary = new TurboList("chassis_primary");
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 753, 113, textureX, textureY).addBox(0, 0, 0, 90, 13, 1)
			.setRotationPoint(-38, -26, 30.5f).setRotationAngle(0, 0, 0).setName("Box 35")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 121, textureX, textureY).addBox(0, 0, 0, 90, 13, 1)
			.setRotationPoint(-38, -26, -31.5f).setRotationAngle(0, 0, 0).setName("Box 36")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 713, 25, textureX, textureY).addBox(0, 0, 0, 18, 22, 1)
			.setRotationPoint(-56, -26, 30.5f).setRotationAngle(0, 0, 0).setName("Box 38")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1017, 1, textureX, textureY).addBox(0, 0, 0, 2, 22, 1)
			.setRotationPoint(-40, -26, -31.5f).setRotationAngle(0, 0, 0).setName("Box 39")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1009, 17, textureX, textureY).addBox(0, 0, 0, 2, 22, 1)
			.setRotationPoint(52, -26, -31.5f).setRotationAngle(0, 0, 0).setName("Box 40")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1017, 25, textureX, textureY).addBox(0, 0, 0, 2, 22, 1)
			.setRotationPoint(52, -26, 30.5f).setRotationAngle(0, 0, 0).setName("Box 41")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 737, 9, textureX, textureY).addBox(0, 0, 0, 5, 9, 1)
			.setRotationPoint(19, -13, 30.5f).setRotationAngle(0, 0, 0).setName("Box 52")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 601, 25, textureX, textureY).addBox(0, 0, 0, 5, 9, 1)
			.setRotationPoint(-10, -13, 30.5f).setRotationAngle(0, 0, 0).setName("Box 53")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 241, 33, textureX, textureY).addBox(0, 0, 0, 4, 9, 1)
			.setRotationPoint(-38, -13, 30.5f).setRotationAngle(0, 0, 0).setName("Box 54")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 617, 33, textureX, textureY).addBox(0, 0, 0, 4, 9, 1)
			.setRotationPoint(-38, -13, -31.5f).setRotationAngle(0, 0, 0).setName("Box 57")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 993, 33, textureX, textureY).addBox(0, 0, 0, 5, 9, 1)
			.setRotationPoint(-10, -13, -31.5f).setRotationAngle(0, 0, 0).setName("Box 58")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 49, textureX, textureY).addBox(0, 0, 0, 5, 9, 1)
			.setRotationPoint(19, -13, -31.5f).setRotationAngle(0, 0, 0).setName("Box 59")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 17, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 17, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(84, -21, 30.5f).setRotationAngle(0, 0, 0).setName("Box 62")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 953, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 28, 11, 1, 0, 0, 0, 0, 0, -5, 0, 0, -5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(54, -26, 30.5f).setRotationAngle(0, 0, 0).setName("Box 63")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 745, 73, textureX, textureY).addBox(0, 0, 0, 28, 6, 1)
			.setRotationPoint(54, -21, -31.5f).setRotationAngle(0, 0, 0).setName("Box 64")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1009, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 17, 1, 0, 1, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(96, -21, 30.5f).setRotationAngle(0, 0, 0).setName("Box 65")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 57, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 17, 8, 0, 1, 0, 0, 3, 0, 0, -1, 0, 0, 2, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 1, 0, 0)
			.setRotationPoint(97, -21, 23.5f).setRotationAngle(0, 0, 0).setName("Box 66")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 889, 113, textureX, textureY).addBox(0, 0, 0, 1, 11, 47)
			.setRotationPoint(100, -21, -23.5f).setRotationAngle(0, 0, 0).setName("Box 68")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 81, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 17, 8, 0, 2, 0, 0, -1, 0, 0, 3, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0)
			.setRotationPoint(97, -21, -31.5f).setRotationAngle(0, 0, 0).setName("Box 69")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 113, 49, textureX, textureY).addBox(0, 0, 0, 2, 17, 1)
			.setRotationPoint(82, -21, 30.5f).setRotationAngle(0, 0, 0).setName("Box 70")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 257, 1, textureX, textureY).addBox(0, 0, 0, 1, 17, 1)
			.setRotationPoint(95, -21, -31.5f).setRotationAngle(0, 0, 0).setName("Box 71")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 121, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 17, 1, 0, 1, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(96, -21, -31.5f).setRotationAngle(0, 0, 0).setName("Box 72")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 689, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 4, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -7, 0, 0, -7, 0, 0, 0, 0, 0)
			.setRotationPoint(54, -15, 17.5f).setRotationAngle(0, 0, 0).setName("Box 73")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 169, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 10, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4.8f, 0, 0, -4.8f, 0, 0, 0, 0, 0)
			.setRotationPoint(54, -11, 17.5f).setRotationAngle(0, 0, 0).setName("Box 75")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 121, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 10, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4.8f, 0, 0, 0, 0, 0, 0, 0, 0, -4.8f, 0, 0)
			.setRotationPoint(77, -11, 17.5f).setRotationAngle(0, 0, 0).setName("Box 76")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 193, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 4, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -7, 0, 0, 0, 0, 0, 0, 0, 0, -7, 0, 0)
			.setRotationPoint(70, -15, 17.5f).setRotationAngle(0, 0, 0).setName("Box 77")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 233, 121, textureX, textureY).addBox(0, 0, 0, 28, 1, 13)
			.setRotationPoint(54, -16, 17.5f).setRotationAngle(0, 0, 0).setName("Box 78")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 321, 121, textureX, textureY).addBox(0, 0, 0, 28, 1, 13)
			.setRotationPoint(54, -16, -30.5f).setRotationAngle(0, 0, 0).setName("Box 79")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 257, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 10, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4.8f, 0, 0, 0, 0, 0, 0, 0, 0, -4.8f, 0, 0)
			.setRotationPoint(77, -11, -31.5f).setRotationAngle(0, 0, 0).setName("Box 80")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 945, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 4, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -7, 0, 0, 0, 0, 0, 0, 0, 0, -7, 0, 0)
			.setRotationPoint(70, -15, -31.5f).setRotationAngle(0, 0, 0).setName("Box 81")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 409, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 4, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -7, 0, 0, -7, 0, 0, 0, 0, 0)
			.setRotationPoint(54, -15, -31.5f).setRotationAngle(0, 0, 0).setName("Box 82")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 377, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 10, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4.8f, 0, 0, -4.8f, 0, 0, 0, 0, 0)
			.setRotationPoint(54, -11, -31.5f).setRotationAngle(0, 0, 0).setName("Box 83")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 881, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 22, 8, 0, 3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-108, -26, 23.5f).setRotationAngle(0, 0, 0).setName("Box 89")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 417, 121, textureX, textureY).addBox(0, 0, 0, 1, 5, 47)
			.setRotationPoint(-111, -9, -23.5f).setRotationAngle(0, 0, 0).setName("Box 90")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 521, 121, textureX, textureY).addBox(0, 0, 0, 1, 3, 47)
			.setRotationPoint(-111, -26, -23.5f).setRotationAngle(0, 0, 0).setName("Box 91")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 153, 49, textureX, textureY).addBox(0, 0, 0, 1, 14, 2)
			.setRotationPoint(-111, -23, -23.5f).setRotationAngle(0, 0, 0).setName("Box 93")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 905, 49, textureX, textureY).addBox(0, 0, 0, 1, 14, 2)
			.setRotationPoint(-111, -23, 21.5f).setRotationAngle(0, 0, 0).setName("Box 94")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 457, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 22, 8, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 3, 0, 0)
			.setRotationPoint(-108, -26, -31.5f).setRotationAngle(0, 0, 0).setName("Box 95")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 473, 121, textureX, textureY).addBox(0, 0, 0, 24, 22, 1)
			.setRotationPoint(-108, -26, -31.5f).setRotationAngle(0, 0, 0).setName("Box 96")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 577, 121, textureX, textureY).addBox(0, 0, 0, 24, 22, 1)
			.setRotationPoint(-108, -26, 30.5f).setRotationAngle(0, 0, 0).setName("Box 97")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 793, 97, textureX, textureY).addBox(0, 0, 0, 28, 5, 1)
			.setRotationPoint(54, -16, -17.5f).setRotationAngle(0, 0, 0).setName("Box 107")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 857, 97, textureX, textureY).addBox(0, 0, 0, 28, 5, 1)
			.setRotationPoint(54, -16, 16.5f).setRotationAngle(0, 0, 0).setName("Box 108")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 57, 145, textureX, textureY).addBox(0, 0, 0, 1, 2, 47)
			.setRotationPoint(100, -6, -23.5f).setRotationAngle(0, 0, 0).setName("Box 117")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 8, 0, 0, 0, 0, 3, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(93, -47, 22.5f).setRotationAngle(0, 0, 0).setName("Box 138")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 481, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 8, 0, 0, 0, 0, 0, -1, 0, 3, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0)
			.setRotationPoint(93, -47, -30.5f).setRotationAngle(0, 0, 0).setName("Box 139")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 617, 185, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 2, 45, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(93, -47, -22.5f).setRotationAngle(0, 0, 0).setName("Box 140")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 953, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 28, 5, 1, 0, 0, 0, 0, 0, -5, 0, 0, -5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(54, -26, -31.5f).setRotationAngle(0, 0, 0).setName("Box 148")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 385, 233, textureX, textureY).addBox(0, 0, 0, 186, 1, 61)
			.setRotationPoint(-104, -49, -30.5f).setRotationAngle(0, 0, 0).setName("Box 149")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 825, 225, textureX, textureY)
			.addShapeBox(0, 0, 0, 11, 1, 61, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0)
			.setRotationPoint(82, -49, -30.5f).setRotationAngle(0, 0, 0).setName("Box 154")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 10, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4.8f, 0, 0, -4.8f, 0, 0, 0, 0, 0)
			.setRotationPoint(-84, -11, 21.5f).setRotationAngle(0, 0, 0).setName("Box 171")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 57, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 4, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -7, 0, 0, -7, 0, 0, 0, 0, 0)
			.setRotationPoint(-84, -15, 21.5f).setRotationAngle(0, 0, 0).setName("Box 172")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 17, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -7, 0, 0, 0, 0, 0, 0, 0, 0, -7, 0, 0)
			.setRotationPoint(-68, -15, 30.5f).setRotationAngle(0, 0, 0).setName("Box 173")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 57, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 10, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4.8f, 0, 0, 0, 0, 0, 0, 0, 0, -4.8f, 0, 0)
			.setRotationPoint(-61, -11, 21.5f).setRotationAngle(0, 0, 0).setName("Box 174")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 161, 169, textureX, textureY).addBox(0, 0, 0, 28, 11, 1)
			.setRotationPoint(-84, -26, 30.5f).setRotationAngle(0, 0, 0).setName("Box 176")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 193, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 10, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4.8f, 0, 0, -4.8f, 0, 0, 0, 0, 0)
			.setRotationPoint(-84, -11, -31.5f).setRotationAngle(0, 0, 0).setName("Box 177")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 169, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 4, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -7, 0, 0, -7, 0, 0, 0, 0, 0)
			.setRotationPoint(-84, -15, -31.5f).setRotationAngle(0, 0, 0).setName("Box 178")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 305, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 10, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4.8f, 0, 0, 0, 0, 0, 0, 0, 0, -4.8f, 0, 0)
			.setRotationPoint(-61, -11, -31.5f).setRotationAngle(0, 0, 0).setName("Box 181")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 665, 169, textureX, textureY).addBox(0, 0, 0, 28, 11, 1)
			.setRotationPoint(-84, -26, -31.5f).setRotationAngle(0, 0, 0).setName("Box 184")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 897, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 8, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 3, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0)
			.setRotationPoint(-106, -49, -30.5f).setRotationAngle(0, 0, 0).setName("Box 185")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 257, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 8, 0, 3, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-106, -49, 22.5f).setRotationAngle(0, 0, 0).setName("Box 186")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 913, 225, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 2, 45, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-109, -49, -22.5f).setRotationAngle(0, 0, 0).setName("Box 187")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -7, 0, 0, 0, 0, 0, 0, 0, 0, -7, 0, 0)
			.setRotationPoint(-68, -15, -31.5f).setRotationAngle(0, 0, 0).setName("Box 195")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 193, 113, textureX, textureY).addBox(0, 0, 0, 4, 9, 1)
			.setRotationPoint(48, -13, -31.5f).setRotationAngle(0, 0, 0).setName("Box 338")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 945, 113, textureX, textureY).addBox(0, 0, 0, 4, 9, 1)
			.setRotationPoint(48, -13, 30.5f).setRotationAngle(0, 0, 0).setName("Box 339")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1017, 113, textureX, textureY).addBox(0, 0, 0, 2, 22, 1)
			.setRotationPoint(-56, -26, -31.5f).setRotationAngle(0, 0, 0).setName("Box 340")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 281, 289, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 21, 47, 0, -2, 0, -1, 2, 0, -1, 2, 0, -1, -2, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-111, -47, -23.5f).setRotationAngle(0, 0, 0).setName("Box 343")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 529, 321, textureX, textureY).addBox(0, 0, 0, 1, 27, 19)
			.setRotationPoint(57.5f, -44, 9).setRotationAngle(0, 0, 0).setName("Box 316")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 193, textureX, textureY).addBox(0, 0, 0, 14, 27, 1)
			.setRotationPoint(59, -44, 7.5f).setRotationAngle(0, 0, 0).setName("Box 317")
		);
		chassis_primary.addProgram(DefaultPrograms.RGB_PRIMARY);
		this.groups.add(chassis_primary);
		//
		TurboList chassis_secondary = new TurboList("chassis_secondary");
		chassis_secondary.add(new ModelRendererTurbo(chassis_secondary, 1017, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 24, 1, 0, 2, 0, -1, -2, 0, -1, -2, 0, 1, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(95, -45, -31.5f).setRotationAngle(0, 0, 0).setName("Box 113")
		);
		chassis_secondary.add(new ModelRendererTurbo(chassis_secondary, 809, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 24, 1, 0, 2, 0, 1, -2, 0, 1, -2, 0, -1, 2, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(95, -45, 30.5f).setRotationAngle(0, 0, 0).setName("Box 114")
		);
		chassis_secondary.add(new ModelRendererTurbo(chassis_secondary, 1001, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 26, 1, 0, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(78, -47, -31.5f).setRotationAngle(0, 0, 0).setName("Box 141")
		);
		chassis_secondary.add(new ModelRendererTurbo(chassis_secondary, 809, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 26, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(78, -47, 30.5f).setRotationAngle(0, 0, 0).setName("Box 142")
		);
		chassis_secondary.add(new ModelRendererTurbo(chassis_secondary, 1, 241, textureX, textureY)
			.addShapeBox(0, 0, 0, 186, 1, 19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2)
			.setRotationPoint(-104, -48, -30.5f).setRotationAngle(0, 0, 0).setName("Box 150")
		);
		chassis_secondary.add(new ModelRendererTurbo(chassis_secondary, 1, 265, textureX, textureY)
			.addShapeBox(0, 0, 0, 186, 1, 19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-104, -48, 11.5f).setRotationAngle(0, 0, 0).setName("Box 151")
		);
		chassis_secondary.add(new ModelRendererTurbo(chassis_secondary, 113, 137, textureX, textureY)
			.addShapeBox(0, 0, -1, 11, 1, 18, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, -2, 0, 0, -2)
			.setRotationPoint(82, -48, -28.5f).setRotationAngle(0, 0, 0).setName("Box 152")
		);
		chassis_secondary.add(new ModelRendererTurbo(chassis_secondary, 377, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 11, 1, 19, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, -2, 0, 2, -2, 0, 2, 0, 0, 0, 0)
			.setRotationPoint(82, -48, 11.5f).setRotationAngle(0, 0, 0).setName("Box 153")
		);
		chassis_secondary.add(new ModelRendererTurbo(chassis_secondary, 537, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 21, 1, 0, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(50, -47, -31.5f).setRotationAngle(0, 0, 0).setName("Box 161")
		);
		chassis_secondary.add(new ModelRendererTurbo(chassis_secondary, 553, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 21, 1, 0, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(20, -47, -31.5f).setRotationAngle(0, 0, 0).setName("Box 162")
		);
		chassis_secondary.add(new ModelRendererTurbo(chassis_secondary, 665, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 21, 1, 0, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-10, -47, -31.5f).setRotationAngle(0, 0, 0).setName("Box 163")
		);
		chassis_secondary.add(new ModelRendererTurbo(chassis_secondary, 721, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 21, 1, 0, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-40, -47, -31.5f).setRotationAngle(0, 0, 0).setName("Box 164")
		);
		chassis_secondary.add(new ModelRendererTurbo(chassis_secondary, 737, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 21, 1, 0, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-58, -47, -31.5f).setRotationAngle(0, 0, 0).setName("Box 165")
		);
		chassis_secondary.add(new ModelRendererTurbo(chassis_secondary, 825, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 21, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-58, -47, 30.5f).setRotationAngle(0, 0, 0).setName("Box 166")
		);
		chassis_secondary.add(new ModelRendererTurbo(chassis_secondary, 841, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 21, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-40, -47, 30.5f).setRotationAngle(0, 0, 0).setName("Box 167")
		);
		chassis_secondary.add(new ModelRendererTurbo(chassis_secondary, 889, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 21, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-10, -47, 30.5f).setRotationAngle(0, 0, 0).setName("Box 168")
		);
		chassis_secondary.add(new ModelRendererTurbo(chassis_secondary, 905, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 21, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(20, -47, 30.5f).setRotationAngle(0, 0, 0).setName("Box 169")
		);
		chassis_secondary.add(new ModelRendererTurbo(chassis_secondary, 921, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 21, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(50, -47, 30.5f).setRotationAngle(0, 0, 0).setName("Box 170")
		);
		chassis_secondary.add(new ModelRendererTurbo(chassis_secondary, 33, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 21, 1, 0, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-86, -47, -31.5f).setRotationAngle(0, 0, 0).setName("Box 182")
		);
		chassis_secondary.add(new ModelRendererTurbo(chassis_secondary, 89, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 21, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-86, -47, 30.5f).setRotationAngle(0, 0, 0).setName("Box 183")
		);
		chassis_secondary.add(new ModelRendererTurbo(chassis_secondary, 225, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 21, 1, 0, -2, 0, 1, 2, 0, 1, 2, 0, -1, -2, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-108, -47, 30.5f).setRotationAngle(0, 0, 0).setName("Box 197")
		);
		chassis_secondary.add(new ModelRendererTurbo(chassis_secondary, 249, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 21, 1, 0, -2, 0, -1, 2, 0, -1, 2, 0, 1, -2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-108, -47, -31.5f).setRotationAngle(0, 0, 0).setName("Box 198")
		);
		chassis_secondary.add(new ModelRendererTurbo(chassis_secondary, 1017, 81, textureX, textureY)
			.addShapeBox(0, -24, -1, 1, 24, 2, 0, 3, 0, 0, -3, 0, 0, -3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(100, -21, 0).setRotationAngle(0, 0, 0).setName("Box 201")
		);
		chassis_secondary.add(new ModelRendererTurbo(chassis_secondary, 113, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 21, 8, 0, -2, 0, -1, 2, 0, -1, -1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, -3, 0, 0, 3, 0, 0)
			.setRotationPoint(-108, -47, -31.5f).setRotationAngle(0, 0, 0).setName("Box 341")
		);
		chassis_secondary.add(new ModelRendererTurbo(chassis_secondary, 569, 185, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 21, 8, 0, 1, 0, 1, -1, 0, 1, 2, 0, -1, -2, 0, -1, 3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-108, -47, 23.5f).setRotationAngle(0, 0, 0).setName("Box 342")
		);
		chassis_secondary.add(new ModelRendererTurbo(chassis_secondary, 945, 153, textureX, textureY)
			.addShapeBox(0, 0, -1, 11, 4, 1, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(82, -48, -29.5f).setRotationAngle(0, 0, 0).setName("Box 398")
		);
		chassis_secondary.addProgram(DefaultPrograms.RGB_SECONDARY);
		this.groups.add(chassis_secondary);
		//
	}

}
