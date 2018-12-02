//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.vehicle;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.vehicle.VehicleModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.4-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/vehicle/c8")
public class C8Model extends VehicleModel {

	public C8Model(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList chassis_core = new TurboList("chassis_core");
		chassis_core.add(new ModelRendererTurbo(chassis_core, 129, 149, textureX, textureY).addBox(-1, -1, 0, 2, 2, 34)
			.setRotationPoint(39, 2, -17).setRotationAngle(0, 0, 0).setName("Box 8")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 236, 75, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 1, 24, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0.5f, 0)
			.setRotationPoint(29, 3, -12).setRotationAngle(0, 0, 0).setName("Box 19")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 0, 75, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 1, 24, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0)
			.setRotationPoint(39, 3, -12).setRotationAngle(0, 0, 0).setName("Box 20")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 211, 148, textureX, textureY).addBox(-1, -1, 0, 2, 2, 34)
			.setRotationPoint(-39, 2, -17).setRotationAngle(0, 0, 0).setName("Box 26")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 396, 62, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 1, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0)
			.setRotationPoint(-49, 3, -16).setRotationAngle(0, 0, 0).setName("Box 32")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 343, 60, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 1, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, -0.5f, 0)
			.setRotationPoint(-39, 3, -16).setRotationAngle(0, 0, 0).setName("Box 33")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 0, 6, textureX, textureY)
			.addShapeBox(0, 0, 0, 58, 1, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0.5f, 0)
			.setRotationPoint(-29, 3, -16).setRotationAngle(0, 0, 0).setName("Box 34")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 369, 0, textureX, textureY)
			.addShapeBox(0, 0, 0, 58, 1, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, 0)
			.setRotationPoint(-29, 3, -22).setRotationAngle(0, 0, 0).setName("Box 35")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 240, 0, textureX, textureY)
			.addShapeBox(0, 0, 0, 58, 1, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-29, 3, 16).setRotationAngle(0, 0, 0).setName("Box 36")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 347, 94, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 2, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(49, 3, -16).setRotationAngle(0, 0, 0).setName("Box 37")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 0, 21, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 2, 6, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -2, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(49, 3, -22).setRotationAngle(0, 0, 0).setName("Box 38")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 396, 19, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 2, 6, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, -2, 0, 0, 0, -1, 0)
			.setRotationPoint(49, 3, 16).setRotationAngle(0, 0, 0).setName("Box 39")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 273, 99, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 1, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0)
			.setRotationPoint(-55, 3, -16).setRotationAngle(0, 0, 0).setName("Box 40")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 473, 31, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 1, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, -2, 1, 0)
			.setRotationPoint(-55, 3, 16).setRotationAngle(0, 0, 0).setName("Box 41")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 0, 30, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 1, 6, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0)
			.setRotationPoint(-55, 3, -22).setRotationAngle(0, 0, 0).setName("Box 42")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 27, 174, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 24, 0, 0, -0.4f, 0, -0.1f, -0.4f, 0, -0.1f, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, -0.1f, -0.4f, 0, -0.1f, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(56, -2, -12).setRotationAngle(0, 0, 0).setName("Box 78")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 0, 172, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 24, 0, 0, -0.4f, 0, -0.1f, -0.4f, 0, -0.1f, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, -0.1f, -0.4f, 0, -0.1f, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(56, -3, -12).setRotationAngle(0, 0, 0).setName("Box 79")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 287, 171, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 24, 0, 0, -0.4f, 0, -0.1f, -0.4f, 0, -0.1f, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, -0.1f, -0.4f, 0, -0.1f, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(56, -4, -12).setRotationAngle(0, 0, 0).setName("Box 80")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 459, 170, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 24, 0, 0, -0.4f, 0, -0.1f, -0.4f, 0, -0.1f, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, -0.1f, -0.4f, 0, -0.1f, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(56, -5, -12).setRotationAngle(0, 0, 0).setName("Box 81")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 408, 170, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 24, 0, 0, -0.4f, 0, -0.1f, -0.4f, 0, -0.1f, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, -0.1f, -0.4f, 0, -0.1f, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(56, -1.6f, -12).setRotationAngle(0, 0, 0).setName("Box 82")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 260, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 24, 0, 0, -0.4f, 0, -0.1f, -0.4f, 0, -0.1f, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, -0.1f, -0.4f, 0, -0.1f, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(56, -5.4f, -12).setRotationAngle(0, 0, 0).setName("Box 83")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 73, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 24, 0, 0, -0.4f, 0, -0.1f, -0.4f, 0, -0.1f, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, -0.1f, -0.4f, 0, -0.1f, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(56, -4.5f, -12).setRotationAngle(0, 0, 0).setName("Box 84")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 94, 114, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 24, 0, 0, -0.4f, 0, -0.1f, -0.4f, 0, -0.1f, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, -0.1f, -0.4f, 0, -0.1f, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(56, -2.5f, -12).setRotationAngle(0, 0, 0).setName("Box 85")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 321, 99, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 24, 0, 0, -0.4f, 0, -0.1f, -0.4f, 0, -0.1f, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, -0.1f, -0.4f, 0, -0.1f, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(56, -3.5f, -12).setRotationAngle(0, 0, 0).setName("Box 86")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 141, 80, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0)
			.setRotationPoint(25.5f, -12.5f, 21.5f).setRotationAngle(0, 0, 0).setName("Box 256")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 292, 84, textureX, textureY).addBox(0, 0, 0, 1, 3, 4)
			.setRotationPoint(25.5f, -13, 22.5f).setRotationAngle(0, -0.20943952f, 0).setName("Box 257")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 462, 74, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0)
			.setRotationPoint(25.5f, -12.5f, -23.5f).setRotationAngle(0, 0, 0).setName("Box 258")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 281, 84, textureX, textureY).addBox(0, 0, 0, 1, 3, 4)
			.setRotationPoint(26.5f, -13, -23).setRotationAngle(0, -2.9321535f, 0).setName("Box 259")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 220, 46, textureX, textureY)
			.addShapeBox(0, 0, 0, 21, 1, 6, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-50, -7, 15).setRotationAngle(0, 0, 0)
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 442, 96, textureX, textureY).addBox(0, 0, 0, 1, 9, 6)
			.setRotationPoint(-50, -6, 15).setRotationAngle(0, 0, 0).setName("Box 47cp")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 427, 96, textureX, textureY).addBox(0, 0, 0, 1, 9, 6)
			.setRotationPoint(-50, -6, -21).setRotationAngle(0, 0, 0).setName("Box 47cp")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 165, 46, textureX, textureY)
			.addShapeBox(0, 0, 0, 21, 1, 6, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-50, -7, -21).setRotationAngle(0, 0, 0)
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 275, 51, textureX, textureY).addBox(0, 0, 0, 20, 9, 1)
			.setRotationPoint(-49, -6, 15).setRotationAngle(0, 0, 0).setName("Box 47")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 43, 48, textureX, textureY).addBox(0, 0, 0, 20, 9, 1)
			.setRotationPoint(-49, -6, -16).setRotationAngle(0, 0, 0).setName("Box 48")
		);
		this.groups.add(chassis_core);
		//
		TurboList chassis_primary = new TurboList("chassis_primary");
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 361, 51, textureX, textureY).addBox(0, 0, 0, 20, 7, 1)
			.setRotationPoint(29, -4, -12).setRotationAngle(0, 0, 0).setName("Box 0")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 318, 51, textureX, textureY).addBox(0, 0, 0, 20, 7, 1)
			.setRotationPoint(29, -4, 11).setRotationAngle(0, 0, 0).setName("Box 7")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 94, 148, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 32, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(56, -1, -16).setRotationAngle(0, 0, 0).setName("Box 66")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 367, 83, textureX, textureY).addBox(0, 0, 0, 1, 4, 2)
			.setRotationPoint(56, -5, -14).setRotationAngle(0, 0, 0).setName("Box 67")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 360, 83, textureX, textureY).addBox(0, 0, 0, 1, 4, 2)
			.setRotationPoint(56, -5, 12).setRotationAngle(0, 0, 0).setName("Box 68")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 176, 147, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0)
			.setRotationPoint(56, -7, -16).setRotationAngle(0, 0, 0).setName("Box 69")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 166, 101, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 2, 32, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(54, -9, -16).setRotationAngle(0, 0, 0).setName("Box 70")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 220, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 6, 0, 2, 0, 0, -3, 0, 0, -1, 0, 0, 0, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(56, -1, -22).setRotationAngle(0, 0, 0).setName("Box 71")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 147, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 6, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -3, 0, 0, -1, 0, 0, 0, 0, 0)
			.setRotationPoint(56, -7, -22).setRotationAngle(0, 0, 0).setName("Box 72")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 130, 80, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 6, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, -1, 0, 0, -3, 0, 0, 2, 0, 0)
			.setRotationPoint(56, -7, 16).setRotationAngle(0, 0, 0).setName("Box 73")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 113, 80, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 6, 0, 0, 0, 0, -1, 0, 0, -3, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0)
			.setRotationPoint(56, -1, 16).setRotationAngle(0, 0, 0).setName("Box 74")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 396, 82, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 2, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(56, -5, 1).setRotationAngle(0, 0, 0).setName("Box 75")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 207, 82, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 2, 0, 0, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(56, -5, -3).setRotationAngle(0, 0, 0).setName("Box 76")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 192, 82, textureX, textureY).addBox(0, 0, 0, 1, 4, 2)
			.setRotationPoint(56, -5, -1).setRotationAngle(0, 0, 0).setName("Box 77")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 291, 62, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 2, 6, 0, 0, 0, 0, -3, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(54, -9, -22).setRotationAngle(0, 0, 0).setName("Box 87")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 270, 62, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 2, 6, 0, 0, 0, 0, -1, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0)
			.setRotationPoint(54, -9, 16).setRotationAngle(0, 0, 0).setName("Box 88")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 269, 45, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(49, -1, 21).setRotationAngle(0, 0, 0).setName("Box 89")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 134, 40, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(49, -9, 21).setRotationAngle(0, 0, 0).setName("Box 90")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 159, 46, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(49, -5, 21).setRotationAngle(0, 0, 0).setName("Box 91")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 121, 40, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(49, -1, -22).setRotationAngle(0, 0, 0).setName("Box 92")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 51, 40, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(49, -5, -22).setRotationAngle(0, 0, 0).setName("Box 93")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 108, 40, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(49, -9, -22).setRotationAngle(0, 0, 0).setName("Box 94")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 433, 134, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 32, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-57, -2, -16).setRotationAngle(0, 0, 0).setName("Box 103")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 69, 79, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 6, 0, -3, 0, 0, 2, 0, 0, 0, 0, 0, -1, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-57, -2, -22).setRotationAngle(0, 0, 0).setName("Box 106")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 343, 77, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 6, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 2, 0, 0, 0, 0, 0, -1, 0, 0)
			.setRotationPoint(-57, -9, -22).setRotationAngle(0, 0, 0).setName("Box 107")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 417, 61, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 12, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-53, -9, -22).setRotationAngle(0, 0, 0).setName("Box 108")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 60, 59, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 12, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-53, -9, 21).setRotationAngle(0, 0, 0).setName("Box 109")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 408, 76, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 6, 0, -1, 0, 0, 0, 0, 0, 2, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -2, 0, 0)
			.setRotationPoint(-57, -2, 16).setRotationAngle(0, 0, 0).setName("Box 110")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 58, 75, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 6, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -2, 0, 0, -1, 0, 0, 0, 0, 0, 2, 0, 0, -3, 0, 0)
			.setRotationPoint(-57, -9, 16).setRotationAngle(0, 0, 0).setName("Box 111")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 396, 61, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 2, 6, 0, -1, 0, 0, 2, 0, 0, 2, 0, -1, -3, 0, -1, 0, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0)
			.setRotationPoint(-57, -11, 16).setRotationAngle(0, 0, 0).setName("Box 114")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 354, 60, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 2, 6, 0, -3, 0, -1, 2, 0, -1, 2, 0, 0, -1, 0, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0)
			.setRotationPoint(-57, -11, -22).setRotationAngle(0, 0, 0).setName("Box 115")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 108, 46, textureX, textureY)
			.addShapeBox(0, 0, 0, 22, 2, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-51, -11, 16).setRotationAngle(0, 0, 0).setName("Box 117")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 436, 42, textureX, textureY)
			.addShapeBox(0, 0, 0, 22, 2, 6, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-51, -11, -22).setRotationAngle(0, 0, 0).setName("Box 118")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 273, 134, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 2, 0, 0, 2)
			.setRotationPoint(-31, -12, -16).setRotationAngle(0, 0, 0).setName("Box 119")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 396, 28, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 1, 6, 0, 0, 0, 0, -1, 0, 0, -3, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0)
			.setRotationPoint(51, -10, 16).setRotationAngle(0, 0, 0).setName("Box 120")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 149, 23, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 1, 6, 0, 0, 0, -1, -3, 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(51, -10, -22).setRotationAngle(0, 0, 0).setName("Box 121")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 426, 96, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 1, 32, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(51, -10, -16).setRotationAngle(0, 0, 0).setName("Box 122")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 57, 40, textureX, textureY)
			.addShapeBox(0, 0, 0, 22, 1, 6, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(29, -10, -22).setRotationAngle(0, 0, 0).setName("Box 123")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 0, 40, textureX, textureY)
			.addShapeBox(0, 0, 0, 22, 1, 6, 0, 0, 1, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(29, -10, 16).setRotationAngle(0, 0, 0).setName("Box 124")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 0, 114, textureX, textureY).addBox(0, 0, 0, 4, 13, 44)
			.setRotationPoint(25, -10, -22).setRotationAngle(0, 0, 0).setName("Box 127")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 42, 57, textureX, textureY).addBox(0, 0, 0, 13, 12, 44)
			.setRotationPoint(-29, -9, -22).setRotationAngle(0, 0, 0).setName("Box 128")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 45, 75, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 13, 4, 0, 12, 0, 2, -12, 0, 2, -12, 0, -2, 12, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(27, -23, 18).setRotationAngle(0, 0, 0).setName("Box 129")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 0, 75, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 13, 4, 0, 12, 0, -2, -12, 0, -2, -12, 0, 2, 12, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(27, -23, -22).setRotationAngle(0, 0, 0).setName("Box 130")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 449, 74, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 12, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 12, 0, -1, -12, 0, -1, -12, 0, 1, 12, 0, 1)
			.setRotationPoint(-19, -23, 16).setRotationAngle(0, 0, 0).setName("Box 131")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 240, 74, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 12, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 12, 0, 1, -12, 0, 1, -12, 0, -1, 12, 0, -1)
			.setRotationPoint(-19, -23, -20).setRotationAngle(0, 0, 0).setName("Box 132")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 283, 8, textureX, textureY)
			.addShapeBox(0, 0, 0, 36, 2, 40, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-19, -24, -20).setRotationAngle(0, 0, 0).setName("Box 133")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 208, 101, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 44, 0, 0, 0, 0, 0, -0.9f, 0, 0, -0.9f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(29, -10, -22).setRotationAngle(0, 0, 0).setName("Box 134")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 121, 54, textureX, textureY)
			.addShapeBox(0, 0, 0, 13, 2, 44, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-29, -11, -22).setRotationAngle(0, 0, 0).setName("Box 135")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 233, 74, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 11, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 1)
			.setRotationPoint(-18, -22, 19).setRotationAngle(0, 0, 0).setName("Box 138")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 300, 71, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 11, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(-18, -22, -20).setRotationAngle(0, 0, 0).setName("Box 139")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 407, 36, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 2, 1, 0, 0, 0.2f, -0.3f, -1.85f, 0, -0.3f, -1.85f, 0, 0.3f, 0, 0.2f, 0.3f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(25, -12, -22).setRotationAngle(0, 0, 0).setName("Box 145")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 396, 36, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 2, 1, 0, 0, 0.2f, 0.3f, -1.85f, 0, 0.3f, -1.85f, 0, -0.3f, 0, 0.2f, -0.3f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(25, -12, 21).setRotationAngle(0, 0, 0).setName("Box 146")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 231, 54, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 11, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 1)
			.setRotationPoint(0, -22, 18).setRotationAngle(0, 0, 0).setName("Box 147")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 293, 71, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 11, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 1)
			.setRotationPoint(1, -22, 19).setRotationAngle(0, 0, 0).setName("Box 148")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 343, 60, textureX, textureY).addBox(0, 0, 0, 4, 14, 1)
			.setRotationPoint(0, -11, 19).setRotationAngle(0, 0, 0).setName("Box 149")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 284, 71, textureX, textureY).addBox(0, 0, 0, 2, 10, 2)
			.setRotationPoint(1, -9, 20).setRotationAngle(0, 0, 0).setName("Box 150")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 74, 59, textureX, textureY).addBox(0, 0, 0, 4, 14, 1)
			.setRotationPoint(0, -11, -20).setRotationAngle(0, 0, 0).setName("Box 151")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 501, 70, textureX, textureY).addBox(0, 0, 0, 2, 12, 2)
			.setRotationPoint(1, -9, -22).setRotationAngle(0, 0, 0).setName("Box 152")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 192, 54, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 11, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(0, -22, -19).setRotationAngle(0, 0, 0).setName("Box 153")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 311, 70, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 11, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(1, -22, -20).setRotationAngle(0, 0, 0).setName("Box 154")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 156, 55, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 2, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(1, -11, -22).setRotationAngle(0, 0, 0).setName("Box 155")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 419, 34, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(1, -11, 20).setRotationAngle(0, 0, 0).setName("Box 156")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 236, 8, textureX, textureY)
			.addShapeBox(0, 0, 0, 41, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-16, 1, 20).setRotationAngle(0, 0, 0).setName("Box 157")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 149, 6, textureX, textureY)
			.addShapeBox(0, 0, 0, 41, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1)
			.setRotationPoint(-16, 1, -22).setRotationAngle(0, 0, 0).setName("Box 158")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 493, 42, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 5, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0)
			.setRotationPoint(-37, -9, 21).setRotationAngle(0, 0, 0)
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 21, 21, textureX, textureY).addBox(0, 0, 0, 4, 3, 1)
			.setRotationPoint(-41, -9, 21).setRotationAngle(0, 0, 0)
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 479, 70, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 12, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -7, 0, 0, 0, 0, 0, 0, 0, 0, -7, 0)
			.setRotationPoint(-32, -9, 21).setRotationAngle(0, 0, 0)
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 247, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0)
			.setRotationPoint(-46, -9, 21).setRotationAngle(0, 0, 0)
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 470, 70, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 12, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -7, 0, 0, -7, 0, 0, 0, 0)
			.setRotationPoint(-49, -9, 21).setRotationAngle(0, 0, 0)
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 234, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0)
			.setRotationPoint(41, -7, -22).setRotationAngle(0, 0, 0)
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 363, 3, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(37, -7, -22).setRotationAngle(0, 0, 0)
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 405, 70, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 10, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -7, 0, 0, 0, 0, 0, 0, 0, 0, -7, 0)
			.setRotationPoint(46, -7, -22).setRotationAngle(0, 0, 0)
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 168, 26, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0)
			.setRotationPoint(32, -7, -22).setRotationAngle(0, 0, 0)
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 396, 70, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 10, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -7, 0, 0, -7, 0, 0, 0, 0)
			.setRotationPoint(29, -7, -22).setRotationAngle(0, 0, 0)
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 498, 31, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 5, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0)
			.setRotationPoint(-37, -9, -22).setRotationAngle(0, 0, 0)
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 417, 19, textureX, textureY).addBox(0, 0, 0, 4, 3, 1)
			.setRotationPoint(-41, -9, -22).setRotationAngle(0, 0, 0)
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 363, 69, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 12, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -7, 0, 0, 0, 0, 0, 0, 0, 0, -7, 0)
			.setRotationPoint(-32, -9, -22).setRotationAngle(0, 0, 0)
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 19, 30, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0)
			.setRotationPoint(-46, -9, -22).setRotationAngle(0, 0, 0)
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 354, 69, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 12, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -7, 0, 0, -7, 0, 0, 0, 0)
			.setRotationPoint(-49, -9, -22).setRotationAngle(0, 0, 0)
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 0, 48, textureX, textureY)
			.addShapeBox(0, 0, 0, 20, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(29, -9, -22).setRotationAngle(0, 0, 0)
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 396, 42, textureX, textureY)
			.addShapeBox(0, 0, 0, 20, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(29, -9, 21).setRotationAngle(0, 0, 0)
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 415, 28, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0)
			.setRotationPoint(41, -7, 21).setRotationAngle(0, 0, 0)
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 363, 0, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(37, -7, 21).setRotationAngle(0, 0, 0)
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 155, 69, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 10, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -7, 0, 0, 0, 0, 0, 0, 0, 0, -7, 0)
			.setRotationPoint(46, -7, 21).setRotationAngle(0, 0, 0)
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 168, 23, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0)
			.setRotationPoint(32, -7, 21).setRotationAngle(0, 0, 0)
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 313, 36, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 10, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -7, 0, 0, -7, 0, 0, 0, 0)
			.setRotationPoint(29, -7, 21).setRotationAngle(0, 0, 0)
		);
		chassis_primary.addProgram(DefaultPrograms.RGB_PRIMARY);
		this.groups.add(chassis_primary);
	}

}