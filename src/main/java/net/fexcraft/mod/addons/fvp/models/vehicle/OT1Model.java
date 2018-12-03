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
@fModel(registryname = "fvp:models/vehicle/ot1")
public class OT1Model extends VehicleModel {

	public OT1Model(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList chassis_core = new TurboList("chassis_core");
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 1, textureX, textureY).addBox(0, 0, 0, 2, 2, 36)
			.setRotationPoint(64, -1, -18).setRotationAngle(0, 0, 0).setName("Box 0")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 153, 17, textureX, textureY).addBox(0, 0, 0, 32, 2, 24)
			.setRotationPoint(50, -2, -12).setRotationAngle(0, 0, 0).setName("Box 71")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 273, 17, textureX, textureY).addBox(0, 0, 0, 3, 4, 22)
			.setRotationPoint(82, -3, -11).setRotationAngle(0, 0, 0).setName("Box 72")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 249, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 4, 11, 0, 3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(82, -3, -22).setRotationAngle(0, 0, 0).setName("Box 73")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 305, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 4, 11, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 3, 0, 0)
			.setRotationPoint(82, -3, 11).setRotationAngle(0, 0, 0).setName("Box 74")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 401, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 16, 9, 0, -0.6f, 0, 0, -1, 0, 0, -4, 0, 0, 2.4f, 0, 0, -1.6f, 0, 0, 0, 0, 0, -3, 0, 0, 1.4f, 0, 0)
			.setRotationPoint(81, -18, 0).setRotationAngle(0, 0, 0).setName("Box 77")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 89, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 16, 9, 0, 2.4f, 0, 0, -4, 0, 0, -1, 0, 0, -0.6f, 0, 0, 1.4f, 0, 0, -3, 0, 0, 0, 0, 0, -1.6f, 0, 0)
			.setRotationPoint(81, -18, -9).setRotationAngle(0, 0, 0).setName("Box 78")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 1, 6, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(62, -12, 16).setRotationAngle(0, 0, 0).setName("Box 82")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 273, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 6, 0, 0, -0.2f, 0, 0, -2.2f, 0, 0, -2.2f, 0, 0, -0.2f, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0)
			.setRotationPoint(68, -12, 16).setRotationAngle(0, 0, 0).setName("Box 83")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 49, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 6, 0, 0, -0.2f, 0, 0, -5.2f, 0, 0, -5.2f, 0, 0, -0.2f, 0, 0, 0, 0, 0, 5, 0, 0, 5, 0, 0, 0, 0)
			.setRotationPoint(72, -10, 16).setRotationAngle(0, 0, 0).setName("Box 84")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 105, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 6, 0, 0, -0.2f, 0, 0.8f, -3, 0, -0.2f, -3, 0, 0, -0.2f, 0, 0, 0, 0, -1, 2, 0, -1, 2, 0, 0, 0, 0)
			.setRotationPoint(76, -5, 16).setRotationAngle(0, 0, 0).setName("Box 85")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 81, 25, textureX, textureY).addBox(0, 0, 0, 5, 2, 44)
			.setRotationPoint(77, -2, -22).setRotationAngle(0, 0, 0).setName("Box 86")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 137, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 6, 0, 0, -2.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -2.2f, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0)
			.setRotationPoint(58, -12, 16).setRotationAngle(0, 0, 0).setName("Box 87")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 425, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 6, 0, 0, -5.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -5.2f, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0)
			.setRotationPoint(54, -10, 16).setRotationAngle(0, 0, 0).setName("Box 88")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 137, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 6, 0, 0.8f, -3, 0, 0, -0.2f, 0, 0, -0.2f, 0, -0.2f, -3, 0, -1, 2, 0, 0, 0, 0, 0, 0, 0, -1, 2, 0)
			.setRotationPoint(52, -5, 16).setRotationAngle(0, 0, 0).setName("Box 89")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 137, 49, textureX, textureY).addBox(0, 0, 0, 3, 2, 44)
			.setRotationPoint(50, -2, -22).setRotationAngle(0, 0, 0).setName("Box 90")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 457, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 1, 7, 0, 0, -1.2f, 0, 0, -1.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(62, -12, 9).setRotationAngle(0, 0, 0).setName("Box 91")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 137, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 7, 0, 0, -1.2f, 0, -1, -3.2f, 0, 0, -2.2f, 0, 0, -0.2f, 0, 0, 1, 0, -1, 3, 0, 0, 2, 0, 0, 0, 0)
			.setRotationPoint(68, -12, 9).setRotationAngle(0, 0, 0).setName("Box 92")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 489, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 7, 0, 1, -1.2f, 0, -1, -6.2f, 0, 0, -5.2f, 0, 0, -0.2f, 0, 1, 0.8f, 0, -1, 6, 0, 0, 5, 0, 0, 0, 0)
			.setRotationPoint(72, -10, 9).setRotationAngle(0, 0, 0).setName("Box 93")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 105, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 7, 0, 1, -1.2f, 0, -0.2f, -3, 0, 0.8f, -3, 0, 0, -0.2f, 0, 1, 1, 0, -2, 2, 0, -1, 2, 0, 0, 0, 0)
			.setRotationPoint(76, -5, 9).setRotationAngle(0, 0, 0).setName("Box 94")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 153, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 7, 0, -1, -3.2f, 0, 0, -1.2f, 0, 0, -0.2f, 0, 0, -2.2f, 0, -1, 3, 0, 0, 1, 0, 0, 0, 0, 0, 2, 0)
			.setRotationPoint(58, -12, 9).setRotationAngle(0, 0, 0).setName("Box 95")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 193, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 7, 0, -1, -6.2f, 0, 1, -1.2f, 0, 0, -0.2f, 0, 0, -5.2f, 0, -1, 6, 0, 1, 1, 0, 0, 0, 0, 0, 5, 0)
			.setRotationPoint(54, -10, 9).setRotationAngle(0, 0, 0).setName("Box 96")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 217, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 7, 0, -0.2f, -3, 0, 1, -1.2f, 0, 0, -0.2f, 0, 0.8f, -3, 0, -2, 2, 0, 1, 1, 0, 0, 0, 0, -1, 2, 0)
			.setRotationPoint(52, -5, 9).setRotationAngle(0, 0, 0).setName("Box 97")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 425, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 1, 6, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(62, -12, -22).setRotationAngle(0, 0, 0).setName("Box 98")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 249, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 6, 0, 0, -2.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -2.2f, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0)
			.setRotationPoint(58, -12, -22).setRotationAngle(0, 0, 0).setName("Box 99")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 241, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 6, 0, 0, -5.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -5.2f, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0)
			.setRotationPoint(54, -10, -22).setRotationAngle(0, 0, 0).setName("Box 100")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 265, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 6, 0, -0.2f, -3, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0.8f, -3, 0, -1, 2, 0, 0, 0, 0, 0, 0, 0, -1, 2, 0)
			.setRotationPoint(52, -5, -22).setRotationAngle(0, 0, 0).setName("Box 101")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 289, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 6, 0, 0, -0.2f, 0, 0, -2.2f, 0, 0, -2.2f, 0, 0, -0.2f, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0)
			.setRotationPoint(68, -12, -22).setRotationAngle(0, 0, 0).setName("Box 102")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 6, 0, 0, -0.2f, 0, 0, -5.2f, 0, 0, -5.2f, 0, 0, -0.2f, 0, 0, 0, 0, 0, 5, 0, 0, 5, 0, 0, 0, 0)
			.setRotationPoint(72, -10, -22).setRotationAngle(0, 0, 0).setName("Box 103")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 25, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 6, 0, 0, -0.2f, 0, -0.2f, -3, 0, 0.8f, -3, 0, 0, -0.2f, 0, 0, 0, 0, -1, 2, 0, -1, 2, 0, 0, 0, 0)
			.setRotationPoint(76, -5, -22).setRotationAngle(0, 0, 0).setName("Box 104")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 49, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 7, 0, 0, -0.2f, 0, 0.8f, -3, 0, -0.2f, -3, 0, 1, -1.2f, 0, 0, 0, 0, -1, 2, 0, -2, 2, 0, 1, 1, 0)
			.setRotationPoint(76, -5, -16).setRotationAngle(0, 0, 0).setName("Box 105")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 73, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 7, 0, 0, -0.2f, 0, 0, -5.2f, 0, -1, -6.2f, 0, 1, -1.2f, 0, 0, 0, 0, 0, 5, 0, -1, 6, 0, 1, 1, 0)
			.setRotationPoint(72, -10, -16).setRotationAngle(0, 0, 0).setName("Box 106")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 137, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 7, 0, 0, -0.2f, 0, 0, -2.2f, 0, -1, -3.2f, 0, 0, -1.2f, 0, 0, 0, 0, 0, 2, 0, -1, 3, 0, 0, 1, 0)
			.setRotationPoint(68, -12, -16).setRotationAngle(0, 0, 0).setName("Box 107")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 233, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 1, 7, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -1.2f, 0, 0, -1.2f, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0)
			.setRotationPoint(62, -12, -16).setRotationAngle(0, 0, 0).setName("Box 108")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 265, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 7, 0, 0, -2.2f, 0, 0, -0.2f, 0, 0, -1.2f, 0, -1, -3.2f, 0, 0, 2, 0, 0, 0, 0, 0, 1, 0, -1, 3, 0)
			.setRotationPoint(58, -12, -16).setRotationAngle(0, 0, 0).setName("Box 109")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 289, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 7, 0, 0, -5.2f, 0, 0, -0.2f, 0, 1, -1.2f, 0, -1, -6.2f, 0, 0, 5, 0, 0, 0, 0, 1, 1, 0, -1, 6, 0)
			.setRotationPoint(54, -10, -16).setRotationAngle(0, 0, 0).setName("Box 110")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 313, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 7, 0, 0.8f, -3, 0, 0, -0.2f, 0, 1, -1.2f, 0, -0.2f, -3, 0, -1, 2, 0, 0, 0, 0, 1, 1, 0, -2, 2, 0)
			.setRotationPoint(52, -5, -16).setRotationAngle(0, 0, 0).setName("Box 111")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 25, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 3, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0, 0, 0.1f, 0, 0, -0.9f, 0, 0, 0, 0, 0)
			.setRotationPoint(81.25f, -16, 0).setRotationAngle(0, 0, 0).setName("Box 112")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 249, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 3, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.9f, 0, 0, 0.1f, 0, 0, 0, 0, 0)
			.setRotationPoint(81.25f, -16, -3).setRotationAngle(0, 0, 0).setName("Box 113")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 241, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 14, 4, 16, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(24, -8, -16).setRotationAngle(0, 0, 0).setName("Box 121")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 377, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 14, 4, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0)
			.setRotationPoint(24, -8, 0).setRotationAngle(0, 0, 0).setName("Box 122")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 201, 81, textureX, textureY).addBox(0, 0, 0, 3, 19, 32)
			.setRotationPoint(21, -23, -16).setRotationAngle(0, 0, 0).setName("Box 126")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 273, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 15, 2, 17, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0)
			.setRotationPoint(24, -10, 0).setRotationAngle(0, 0, 0).setName("Box 127")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 321, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 15, 2, 17, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(24, -10, -17).setRotationAngle(0, 0, 0).setName("Box 128")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 49, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 29, 1, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, -1)
			.setRotationPoint(21, -2, 15).setRotationAngle(0, 0, 0).setName("Box 129")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 153, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 29, 1, 7, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 1, 0, 0, 1, 0, 0, 0, 0)
			.setRotationPoint(21, -2, -22).setRotationAngle(0, 0, 0).setName("Box 130")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 249, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 20, 26, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(48, -21, -13).setRotationAngle(0, 0, 0).setName("Box 140")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 273, 17, textureX, textureY).addBox(0, 0, 0, 1, 2, 1)
			.setRotationPoint(77, -4, 14).setRotationAngle(0, 0, 0).setName("Box 147")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 289, 17, textureX, textureY).addBox(0, 0, 0, 1, 2, 1)
			.setRotationPoint(77, -4, 18).setRotationAngle(0, 0, 0).setName("Box 148")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 65, 25, textureX, textureY).addBox(0, 0, 0, 1, 1, 8)
			.setRotationPoint(77, -6, 12.5f).setRotationAngle(0, 0, 0).setName("Box 151")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 273, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(77, -5, 12.5f).setRotationAngle(0, 0, 0).setName("Box 152")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 8, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(77, -7, 12.5f).setRotationAngle(0, 0, 0).setName("Box 153")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 281, 145, textureX, textureY).addBox(0, 0, 0, 94, 6, 3)
			.setRotationPoint(-75, -8, -10).setRotationAngle(0, 0, 0).setName("Box 157")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 313, 161, textureX, textureY).addBox(0, 0, 0, 94, 6, 3)
			.setRotationPoint(-75, -8, 7).setRotationAngle(0, 0, 0).setName("Box 158")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 94, 4, 5, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(-75, -12, -11).setRotationAngle(0, 0, 0).setName("Box 159")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 201, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 94, 4, 5, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(-75, -12, 6).setRotationAngle(0, 0, 0).setName("Box 160")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 193, textureX, textureY).addBox(0, 0, 0, 96, 1, 42)
			.setRotationPoint(-77, -13, -21).setRotationAngle(0, 0, 0).setName("Box 161")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 377, 177, textureX, textureY).addBox(0, 0, 0, 12, 6, 30)
			.setRotationPoint(-59, -4.9f, -15).setRotationAngle(0, 0, 0).setName("Box 162")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 433, 185, textureX, textureY).addBox(0, 0, 0, 2, 2, 36)
			.setRotationPoint(-54, -1, -18).setRotationAngle(0, 0, 0).setName("Box 163")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 17, 65, textureX, textureY).addBox(0, 0, 0, 6, 1, 6)
			.setRotationPoint(-56, -12, 16).setRotationAngle(0, 0, 0).setName("Box 167")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 193, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 6, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0)
			.setRotationPoint(-60, -12, 16).setRotationAngle(0, 0, 0).setName("Box 168")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 217, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 6, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0)
			.setRotationPoint(-50, -12, 16).setRotationAngle(0, 0, 0).setName("Box 169")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 6, 0, 0, -5, 0, 0, 0, 0, 0, 0, 0, 0, -5, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0)
			.setRotationPoint(-64, -10, 16).setRotationAngle(0, 0, 0).setName("Box 171")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 193, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 6, 0, 0, 0, 0, 0, -5, 0, 0, -5, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 5, 0, 0, 0, 0)
			.setRotationPoint(-46, -10, 16).setRotationAngle(0, 0, 0).setName("Box 172")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 289, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 6, 6, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-65, -5, 16).setRotationAngle(0, 0, 0).setName("Box 173")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 321, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 6, 6, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-42, -5, 16).setRotationAngle(0, 0, 0).setName("Box 174")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 241, 193, textureX, textureY).addBox(0, 0, 0, 2, 4, 32)
			.setRotationPoint(-76, -5.5f, -16).setRotationAngle(0, 0, 0).setName("Box 206")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 241, 97, textureX, textureY).addBox(0, 0, 0, 22, 5, 1)
			.setRotationPoint(-64, -4, 15).setRotationAngle(0, 0, 0).setName("Box 207")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 393, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 22, 7, 1, 0, -6, 0, 0, -6, 0, 0, -6, 0, 0, -6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-64, -11, 15).setRotationAngle(0, 0, 0).setName("Box 208")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 241, 105, textureX, textureY).addBox(0, 0, 0, 22, 5, 1)
			.setRotationPoint(-64, -4, -16).setRotationAngle(0, 0, 0).setName("Box 215")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 201, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 22, 7, 1, 0, -6, 0, 0, -6, 0, 0, -6, 0, 0, -6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-64, -11, -16).setRotationAngle(0, 0, 0).setName("Box 216")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 425, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 6, 6, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-65, -5, -22).setRotationAngle(0, 0, 0).setName("Box 217")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 321, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 6, 6, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-42, -5, -22).setRotationAngle(0, 0, 0).setName("Box 218")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 337, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 6, 0, 0, -5, 0, 0, 0, 0, 0, 0, 0, 0, -5, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0)
			.setRotationPoint(-64, -10, -22).setRotationAngle(0, 0, 0).setName("Box 219")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 361, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 6, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0)
			.setRotationPoint(-60, -12, -22).setRotationAngle(0, 0, 0).setName("Box 220")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 65, 129, textureX, textureY).addBox(0, 0, 0, 6, 1, 6)
			.setRotationPoint(-56, -12, -22).setRotationAngle(0, 0, 0).setName("Box 221")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 281, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 6, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0)
			.setRotationPoint(-50, -12, -22).setRotationAngle(0, 0, 0).setName("Box 222")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 305, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 6, 0, 0, 0, 0, 0, -5, 0, 0, -5, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 5, 0, 0, 0, 0)
			.setRotationPoint(-46, -10, -22).setRotationAngle(0, 0, 0).setName("Box 223")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 185, textureX, textureY).addBox(0, 0, 0, 66, 3, 1)
			.setRotationPoint(-47, -4, -0.5f).setRotationAngle(0, 0, 0).setName("Box 260")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 281, 217, textureX, textureY).addBox(0, 0, 0, 66, 1, 1)
			.setRotationPoint(-47, -3, -1.5f).setRotationAngle(0, 0, 0).setName("Box 261")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 313, 225, textureX, textureY).addBox(0, 0, 0, 66, 1, 1)
			.setRotationPoint(-47, -3, 0.5f).setRotationAngle(0, 0, 0).setName("Box 262")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 281, 233, textureX, textureY)
			.addShapeBox(0, 0, 0, 66, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-47, -4, 0.5f).setRotationAngle(0, 0, 0).setName("Box 263")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 241, textureX, textureY)
			.addShapeBox(0, 0, 0, 66, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(-47, -2, 0.5f).setRotationAngle(0, 0, 0).setName("Box 264")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 137, 241, textureX, textureY)
			.addShapeBox(0, 0, 0, 66, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-47, -2, -1.5f).setRotationAngle(0, 0, 0).setName("Box 265")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 273, 241, textureX, textureY)
			.addShapeBox(0, 0, 0, 66, 1, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-47, -4, -1.5f).setRotationAngle(0, 0, 0).setName("Box 266")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 33, textureX, textureY).addBox(0, 0, 0, 2, 1, 2)
			.setRotationPoint(-54, 1, -1).setRotationAngle(0, 0, 0).setName("Box 267")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 441, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(-52, 1, -1).setRotationAngle(0, 0, 0).setName("Box 268")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 17, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(-55, 1, -1).setRotationAngle(0, 0, 0).setName("Box 269")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 305, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-54, 1, -2).setRotationAngle(0, 0, 0).setName("Box 270")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 329, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(-54, 1, 1).setRotationAngle(0, 0, 0).setName("Box 271")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 153, 33, textureX, textureY).addBox(0, 0, 0, 1, 2, 2)
			.setRotationPoint(18, -6, 12).setRotationAngle(0, 0, 0).setName("Box 272")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 481, 153, textureX, textureY).addBox(0, 0, 0, 10, 4, 2)
			.setRotationPoint(8, -7, 12).setRotationAngle(0, 0, 0).setName("Box 273")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 489, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 4, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(8, -7, 11).setRotationAngle(0, 0, 0).setName("Box 274")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(8, -7, 14).setRotationAngle(0, 0, 0).setName("Box 275")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 289, 25, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(15, -5.5f, 10).setRotationAngle(0, 0, 0).setName("Box 276")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 425, 25, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(10, -5.5f, 10).setRotationAngle(0, 0, 0).setName("Box 277")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 25, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 2, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(5, -6, 12).setRotationAngle(0, 0, 0).setName("Box 278")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 265, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0)
			.setRotationPoint(5, -6, 14).setRotationAngle(0, 0, 0).setName("Box 279")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 433, 177, textureX, textureY).addBox(0, 0, 0, 4, 10, 9)
			.setRotationPoint(15, -11, -20).setRotationAngle(0, 0, 0).setName("Box 280")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 481, 177, textureX, textureY).addBox(0, 0, 0, 4, 9, 8)
			.setRotationPoint(14.8f, -10.5f, -19.5f).setRotationAngle(0, 0, 0).setName("Box 281")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 25, 33, textureX, textureY).addBox(0, 0, 0, 1, 2, 1)
			.setRotationPoint(14.5f, -7, -19).setRotationAngle(0, 0, 0).setName("Box 282")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 385, 25, textureX, textureY).addBox(0, 0, 0, 1, 3, 12)
			.setRotationPoint(-76.2f, -5, -6).setRotationAngle(0, 0, 0).setName("Box 283")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 457, 113, textureX, textureY).addBox(0, 0, 0, 1, 3, 12)
			.setRotationPoint(84.2f, -2.5f, -6).setRotationAngle(0, 0, 0).setName("Box 288")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 201, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 10, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 4, 0, 0, 4, 0, 0, 0, 0)
			.setRotationPoint(46, -21, 2).setRotationAngle(0, 0, 0).setName("Box 304")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 265, 137, textureX, textureY).addBox(0, 0, 0, 2, 2, 2)
			.setRotationPoint(44, -21, 6).setRotationAngle(0, 0, 0).setName("Box 305")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 81, 41, textureX, textureY).addBox(0, -0.5f, -0.5f, 1, 1, 1)
			.setRotationPoint(43, -20, 7).setRotationAngle(0, 0, 0).setName("Box 306")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 33, 81, textureX, textureY).addBox(0, 0, 0, 1, 1, 3)
			.setRotationPoint(45.9f, -21.5f, 8.5f).setRotationAngle(0, 0, 0).setName("Box 320")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 177, 129, textureX, textureY).addBox(0, 0, 0, 1, 1, 3)
			.setRotationPoint(45.9f, -20, 8.5f).setRotationAngle(0, 0, 0).setName("Box 321")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 177, 145, textureX, textureY).addBox(0, 0, 0, 1, 1, 3)
			.setRotationPoint(45.9f, -21.5f, 2.5f).setRotationAngle(0, 0, 0).setName("Box 322")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 265, 145, textureX, textureY).addBox(0, 0, 0, 1, 1, 3)
			.setRotationPoint(45.9f, -20, 2.5f).setRotationAngle(0, 0, 0).setName("Box 323")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 193, textureX, textureY).addBox(0, 0, 0, 2, 6, 10)
			.setRotationPoint(47, -20.5f, -12).setRotationAngle(0, 0, 0).setName("Box 324")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 241, 193, textureX, textureY).addBox(0, 0, 0, 2, 5, 9)
			.setRotationPoint(46.9f, -20, -11.5f).setRotationAngle(0, 0, 0).setName("Box 325")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 473, 177, textureX, textureY).addBox(0, 0, 0, 2, 1, 3)
			.setRotationPoint(46.5f, -19.5f, -8.5f).setRotationAngle(0, 0, 0).setName("Box 326")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 297, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 5, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, 1.5f, 0, 0, -2, 0, 0, -2, 0, 0, 1.5f, 0, 0)
			.setRotationPoint(-65.25f, 1, 16.5f).setRotationAngle(0, 0, 0).setName("Box 327")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 257, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 5, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, 1.5f, 0, 0, -2, 0, 0, -2, 0, 0, 1.5f, 0, 0)
			.setRotationPoint(-65.25f, 1, -21.5f).setRotationAngle(0, 0, 0).setName("Box 328")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 369, 241, textureX, textureY).addBox(0, 0, 0, 3, 1, 42)
			.setRotationPoint(21, -1, -21).setRotationAngle(0, 0, 0).setName("Box 376")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 57, 249, textureX, textureY).addBox(0, 0, 0, 2, 1, 42)
			.setRotationPoint(19, -1, -21).setRotationAngle(0, 0, 0).setName("Box 377")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 153, 249, textureX, textureY)
			.addShapeBox(0, 0, 0, 26, 1, 42, 0, 0, 0, 0, 0, 0, -6, 0, 0, -6, 0, 0, 0, 0, 0, 0, 0, 0, -6, 0, 0, -6, 0, 0, 0)
			.setRotationPoint(24, -1, -21).setRotationAngle(0, 0, 0).setName("Box 378")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 329, 17, textureX, textureY).addBox(0, 0, 0, 1, 2, 1)
			.setRotationPoint(77, -4, -15).setRotationAngle(0, 0, 0).setName("Box 149")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 25, textureX, textureY).addBox(0, 0, 0, 1, 2, 1)
			.setRotationPoint(77, -4, -19).setRotationAngle(0, 0, 0).setName("Box 150")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 17, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(77, -5, -20.5f).setRotationAngle(0, 0, 0).setName("Box 154")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 129, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 8, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(77, -7, -20.5f).setRotationAngle(0, 0, 0).setName("Box 155")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 153, 73, textureX, textureY).addBox(0, 0, 0, 1, 1, 8)
			.setRotationPoint(77, -6, -20.5f).setRotationAngle(0, 0, 0).setName("Box 156")
		);
		this.groups.add(chassis_core);
		//
		TurboList chassis_primary = new TurboList("chassis_primary");
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 337, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 27, 16, 2, 0, 0, 0, 0, 0, 0, -3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 3, 0, 0, 0)
			.setRotationPoint(51, -18, -12).setRotationAngle(0, 0, 0).setName("Box 75")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 449, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 27, 16, 2, 0, 0, 0, 0, 0, 0, 3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, -3, 0, 0, 0)
			.setRotationPoint(51, -18, 10).setRotationAngle(0, 0, 0).setName("Box 76")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 31, 2, 12, 0, 0, 0, 0, -1, -1, 0, -4, -1, -5, 0, 0, -1, 0, 0, 0, 0, 0, 0, -3, 0, -3, 0, 0, 0)
			.setRotationPoint(51, -20, 0).setRotationAngle(0, 0, 0).setName("Box 79")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 313, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 31, 2, 12, 0, 0, 0, -1, -4, -1, -5, -1, -1, 0, 0, 0, 0, 0, 0, 0, -3, 0, -3, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(51, -20, -12).setRotationAngle(0, 0, 0).setName("Box 80")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 361, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 26, 3, 42, 0, 0, 0, 0, 0, 0, -6, 0, 0, -6, 0, 0, 0, 0, 0, 0, 0, 0, -6, 0, 0, -6, 0, 0, 0)
			.setRotationPoint(24, -4, -21).setRotationAngle(0, 0, 0).setName("Box 81")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 57, textureX, textureY).addBox(0, 0, 0, 2, 25, 42)
			.setRotationPoint(19, -26, -21).setRotationAngle(0, 0, 0).setName("Box 114")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 297, 57, textureX, textureY).addBox(0, 0, 0, 2, 4, 42)
			.setRotationPoint(19, -36, -21).setRotationAngle(0, 0, 0).setName("Box 115")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 345, 57, textureX, textureY).addBox(0, 0, 0, 2, 6, 8)
			.setRotationPoint(19, -32, -21).setRotationAngle(0, 0, 0).setName("Box 116")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 369, 57, textureX, textureY).addBox(0, 0, 0, 2, 6, 8)
			.setRotationPoint(19, -32, 13).setRotationAngle(0, 0, 0).setName("Box 117")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 97, 73, textureX, textureY).addBox(0, 0, 0, 1, 20, 26)
			.setRotationPoint(50, -21, -13).setRotationAngle(0, 0, 0).setName("Box 118")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 49, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 26, 1, 2, 0, 0, 0, 0, 0, 0, 6, 0, 0, -6, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, -6, 0, 0, 0)
			.setRotationPoint(24, -5, 19).setRotationAngle(0, 0, 0).setName("Box 119")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 193, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 26, 1, 2, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, -6, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, -6)
			.setRotationPoint(24, -5, -15).setRotationAngle(0, 0, 0).setName("Box 120")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 401, 89, textureX, textureY).addBox(0, 0, 0, 3, 3, 42)
			.setRotationPoint(21, -4, -21).setRotationAngle(0, 0, 0).setName("Box 123")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 457, 89, textureX, textureY).addBox(0, 0, 0, 3, 32, 2)
			.setRotationPoint(21, -36, 19).setRotationAngle(0, 0, 0).setName("Box 124")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 473, 89, textureX, textureY).addBox(0, 0, 0, 3, 32, 2)
			.setRotationPoint(21, -36, -21).setRotationAngle(0, 0, 0).setName("Box 125")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 49, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 26, 1, 42, 0, 0, 0, -1, 0, -2, -7, 0, -2, -7, 0, 0, -1, 0, 0, 0, 0, 2, -6, 0, 2, -6, 0, 0, 0)
			.setRotationPoint(24, -37, -21).setRotationAngle(0, 0, 0).setName("Box 131")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 145, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 1, 42, 0, -1, 0, -1, 0, 0, -1, 0, 0, -1, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(19, -37, -21).setRotationAngle(0, 0, 0).setName("Box 132")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 489, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 32, 2, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0)
			.setRotationPoint(49, -34, 13).setRotationAngle(0, 0, 0).setName("Box 133")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 153, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 32, 2, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(49, -34, -15).setRotationAngle(0, 0, 0).setName("Box 134")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 385, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 2, 0, 0, 0, 0, 0, -1, 0, 0, -1, -2, 0, 0, -1, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0)
			.setRotationPoint(50, -35, 13).setRotationAngle(0, 0, 0).setName("Box 137")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 361, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 26, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(50, -35, -13).setRotationAngle(0, 0, 0).setName("Box 138")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 161, 25, textureX, textureY).addBox(0, 0, 0, 1, 12, 1)
			.setRotationPoint(50, -33, -0.5f).setRotationAngle(0, 0, 0).setName("Box 139")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 345, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 26, 1, 2, 0, 0, 2, 0, 0, 0, 6, 0, 0, -6, 0, 2, 0, 0, 0, 0, 0, 0, 6, 0, 0, -6, 0, 0, 0)
			.setRotationPoint(24, -34, 19).setRotationAngle(0, 0, 0).setName("Box 141")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 26, 1, 2, 0, 0, 2, 0, 0, 0, -6, 0, 0, 6, 0, 2, 0, 0, 0, 0, 0, 0, -6, 0, 0, 6, 0, 0, 0)
			.setRotationPoint(24, -34, -21).setRotationAngle(0, 0, 0).setName("Box 142")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 305, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 2, 0, 0, 0, -1, 0, -1, -2, 0, -1, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(50, -35, -15).setRotationAngle(0, 0, 0).setName("Box 143")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 33, 129, textureX, textureY).addBox(0, 0, 0, 1, 1, 26)
			.setRotationPoint(50, -34, -13).setRotationAngle(0, 0, 0).setName("Box 144")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 17, 201, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 16, 9, 0, 1, 0, 0, -1.4f, 0, 0, -4.4f, 0, 0, 4, 0, 0, 0, 0, 0, -0.4f, 0, 0, -3.4f, 0, 0, 3, 0, 0)
			.setRotationPoint(81, -18, 0).setRotationAngle(0, 0, 0).setName("Box 374")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 457, 225, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 16, 9, 0, 4, 0, 0, -4.4f, 0, 0, -1.4f, 0, 0, 1, 0, 0, 3, 0, 0, -3.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0)
			.setRotationPoint(81, -18, -9).setRotationAngle(0, 0, 0).setName("Box 375")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 481, 201, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 1, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, -0.8f, 0)
			.setRotationPoint(62, -12, 16).setRotationAngle(0, 0, 0).setName("Box 379")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 241, 209, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 1, 7, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0.2f, 0, 0, 0.2f, 0, 0, -0.8f, 0, 0, -0.8f, 0)
			.setRotationPoint(62, -12, 9).setRotationAngle(0, 0, 0).setName("Box 380")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 281, 209, textureX, textureY)
			.addShapeBox(0, 1, 0, 4, 1, 6, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 1.2f, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, 1.2f, 0)
			.setRotationPoint(58, -13, 16).setRotationAngle(0, 0, 0).setName("Box 381")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 481, 209, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 7, 0, -1, -3, 0, 0, -1, 0, 0, 0, 0, 0, -2, 0, -1, 2.2f, 0, 0, 0.2f, 0, 0, -0.8f, 0, 0, 1.2f, 0)
			.setRotationPoint(58, -12, 9).setRotationAngle(0, 0, 0).setName("Box 382")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 225, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 7, 0, -1, -6, 0, 1, -1, 0, 0, 0, 0, 0, -5, 0, -1, 5.2f, 0, 1, 0.2f, 0, 0, -0.8f, 0, 0, 4.2f, 0)
			.setRotationPoint(54, -10, 9).setRotationAngle(0, 0, 0).setName("Box 383")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 305, 209, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 6, 0, 0, -5, 0, 0, 0, 0, 0, 0, 0, 0, -5, 0, 0, 4.2f, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, 4.2f, 0)
			.setRotationPoint(54, -10, 16).setRotationAngle(0, 0, 0).setName("Box 384")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 193, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 6, 0, 1, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0.8f, 2, 0, 0, -0.8f, 0, 0, -0.8f, 0, -0.2f, 2, 0)
			.setRotationPoint(52, -5, 16).setRotationAngle(0, 0, 0).setName("Box 385")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 473, 225, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 7, 0, 0, -3, 0, 1, -1, 0, 0, 0, 0, 1, -3, 0, -0.2f, 2, 0, 1, 0.2f, 0, 0, -0.8f, 0, 0.8f, 2, 0)
			.setRotationPoint(52, -5, 9).setRotationAngle(0, 0, 0).setName("Box 386")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 281, 209, textureX, textureY)
			.addShapeBox(0, 1, 0, 4, 1, 6, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, -0.8f, 0, 0, 1.2f, 0, 0, 1.2f, 0, 0, -0.8f, 0)
			.setRotationPoint(68, -13, 16).setRotationAngle(0, 0, 0).setName("Box 387")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 481, 209, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 7, 0, 0, -1, 0, -1, -3, 0, 0, -2, 0, 0, 0, 0, 0, 0.2f, 0, -1, 2.2f, 0, 0, 1.2f, 0, 0, -0.8f, 0)
			.setRotationPoint(68, -12, 9).setRotationAngle(0, 0, 0).setName("Box 388")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 225, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 7, 0, 1, -1, 0, -1, -6, 0, 0, -5, 0, 0, 0, 0, 1, 0.2f, 0, -1, 5.2f, 0, 0, 4.2f, 0, 0, -0.8f, 0)
			.setRotationPoint(72, -10, 9).setRotationAngle(0, 0, 0).setName("Box 389")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 305, 209, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 6, 0, 0, 0, 0, 0, -5, 0, 0, -5, 0, 0, 0, 0, 0, -0.8f, 0, 0, 4.2f, 0, 0, 4.2f, 0, 0, -0.8f, 0)
			.setRotationPoint(72, -10, 16).setRotationAngle(0, 0, 0).setName("Box 390")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 193, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 6, 0, 0, 0, 0, 1, -3, 0, 0, -3, 0, 0, 0, 0, 0, -0.8f, 0, 0.8f, 2, 0, -0.2f, 2, 0, 0, -0.8f, 0)
			.setRotationPoint(76, -5, 16).setRotationAngle(0, 0, 0).setName("Box 391")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 473, 225, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 7, 0, 1, -1, 0, 0, -3, 0, 1, -3, 0, 0, 0, 0, 1, 0.2f, 0, -0.2f, 2, 0, 0.8f, 2, 0, 0, -0.8f, 0)
			.setRotationPoint(76, -5, 9).setRotationAngle(0, 0, 0).setName("Box 392")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 481, 201, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 1, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, -0.8f, 0)
			.setRotationPoint(62, -12, -22).setRotationAngle(0, 0, 0).setName("Box 393")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 241, 209, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 1, 7, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, 0.2f, 0, 0, 0.2f, 0)
			.setRotationPoint(62, -12, -16).setRotationAngle(0, 0, 0).setName("Box 394")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 481, 209, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 7, 0, 0, 0, 0, 0, -2, 0, -1, -3, 0, 0, -1, 0, 0, -0.8f, 0, 0, 1.2f, 0, -1, 2.2f, 0, 0, 0.2f, 0)
			.setRotationPoint(68, -12, -16).setRotationAngle(0, 0, 0).setName("Box 395")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 281, 209, textureX, textureY)
			.addShapeBox(0, 1, 0, 4, 1, 6, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, -0.8f, 0, 0, 1.2f, 0, 0, 1.2f, 0, 0, -0.8f, 0)
			.setRotationPoint(68, -13, -22).setRotationAngle(0, 0, 0).setName("Box 396")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 305, 209, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 6, 0, 0, 0, 0, 0, -5, 0, 0, -5, 0, 0, 0, 0, 0, -0.8f, 0, 0, 4.2f, 0, 0, 4.2f, 0, 0, -0.8f, 0)
			.setRotationPoint(72, -10, -22).setRotationAngle(0, 0, 0).setName("Box 397")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 473, 225, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 7, 0, 0, 0, 0, 1, -3, 0, 0, -3, 0, 1, -1, 0, 0, -0.8f, 0, 0.8f, 2, 0, -0.2f, 2, 0, 1, 0.2f, 0)
			.setRotationPoint(76, -5, -16).setRotationAngle(0, 0, 0).setName("Box 398")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 193, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 6, 0, 0, 0, 0, 0, -3, 0, 1, -3, 0, 0, 0, 0, 0, -0.8f, 0, -0.2f, 2, 0, 0.8f, 2, 0, 0, -0.8f, 0)
			.setRotationPoint(76, -5, -22).setRotationAngle(0, 0, 0).setName("Box 399")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 225, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 7, 0, 0, 0, 0, 0, -5, 0, -1, -6, 0, 1, -1, 0, 0, -0.8f, 0, 0, 4.2f, 0, -1, 5.2f, 0, 1, 0.2f, 0)
			.setRotationPoint(72, -10, -16).setRotationAngle(0, 0, 0).setName("Box 400")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 481, 209, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 7, 0, 0, -2, 0, 0, 0, 0, 0, -1, 0, -1, -3, 0, 0, 1.2f, 0, 0, -0.8f, 0, 0, 0.2f, 0, -1, 2.2f, 0)
			.setRotationPoint(58, -12, -16).setRotationAngle(0, 0, 0).setName("Box 401")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 281, 209, textureX, textureY)
			.addShapeBox(0, 1, 0, 4, 1, 6, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 1.2f, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, 1.2f, 0)
			.setRotationPoint(58, -13, -22).setRotationAngle(0, 0, 0).setName("Box 402")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 305, 209, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 6, 0, 0, -5, 0, 0, 0, 0, 0, 0, 0, 0, -5, 0, 0, 4.2f, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, 4.2f, 0)
			.setRotationPoint(54, -10, -22).setRotationAngle(0, 0, 0).setName("Box 403")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 225, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 7, 0, 0, -5, 0, 0, 0, 0, 1, -1, 0, -1, -6, 0, 0, 4.2f, 0, 0, -0.8f, 0, 1, 0.2f, 0, -1, 5.2f, 0)
			.setRotationPoint(54, -10, -16).setRotationAngle(0, 0, 0).setName("Box 404")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 193, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 6, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 1, -3, 0, -0.2f, 2, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0.8f, 2, 0)
			.setRotationPoint(52, -5, -22).setRotationAngle(0, 0, 0).setName("Box 405")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 473, 225, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 7, 0, 1, -3, 0, 0, 0, 0, 1, -1, 0, 0, -3, 0, 0.8f, 2, 0, 0, -0.8f, 0, 1, 0.2f, 0, -0.2f, 2, 0)
			.setRotationPoint(52, -5, -16).setRotationAngle(0, 0, 0).setName("Box 406")
		);
		chassis_primary.addProgram(DefaultPrograms.RGB_PRIMARY);
		this.groups.add(chassis_primary);
		//
		TurboList door_close = new TurboList("door_close");
		door_close.add(new ModelRendererTurbo(door_close, 457, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 26, 16, 1, 0, 0, 0, 0, 0, 0, 6, 0, 0, -6, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, -6, 0, 0, 0)
			.setRotationPoint(24, -21, 20).setRotationAngle(0, 0, 0).setName("Box 145")
		);
		door_close.add(new ModelRendererTurbo(door_close, 1, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 26, 16, 1, 0, 0, 0, 0, 0, 0, -6, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, -6, 0, 0, 6, 0, 0, 0)
			.setRotationPoint(24, -21, -21).setRotationAngle(0, 0, 0).setName("Box 146")
		);
		door_close.addPrograms(DefaultPrograms.RGB_PRIMARY, DefaultPrograms.DOOR_CLOSE);
		this.groups.add(door_close);
		//
		TurboList door_close_ = new TurboList("door_close_");
		door_close_.add(new ModelRendererTurbo(door_close_, 1, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(28, -16, 19.5f).setRotationAngle(0, 0, 0).setName("Box 302")
		);
		door_close_.add(new ModelRendererTurbo(door_close_, 305, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 1, 0, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 0, 0)
			.setRotationPoint(28, -16, -20.5f).setRotationAngle(0, 0, 0).setName("Box 303")
		);
		door_close_.add(new ModelRendererTurbo(door_close_, 193, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(28, -16, 18.75f).setRotationAngle(0, 0, 0).setName("Box 365")
		);
		door_close_.add(new ModelRendererTurbo(door_close_, 465, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 1, 0, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 0, 0)
			.setRotationPoint(28, -16, -19.75f).setRotationAngle(0, 0, 0).setName("Box 366")
		);
		door_close_.addProgram(DefaultPrograms.DOOR_CLOSE);
		this.groups.add(door_close_);
		//
		TurboList door_open = new TurboList("door_open");
		door_open.add(new ModelRendererTurbo(door_open, 425, 225, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 16, 26, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, -6, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, -6, 0, 0)
			.setRotationPoint(49, -21, 14).setRotationAngle(0, 0, 0).setName("Box 367")
		);
		door_open.add(new ModelRendererTurbo(door_open, 1, 249, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 16, 26, 0, -6, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, -6, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(49, -21, -40).setRotationAngle(0, 0, 0).setName("Box 368")
		);
		door_open.addPrograms(DefaultPrograms.RGB_PRIMARY, DefaultPrograms.DOOR_OPEN);
		this.groups.add(door_open);
		//
		TurboList door_open_ = new TurboList("door_open_");
		door_open_.add(new ModelRendererTurbo(door_open_, 457, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 4, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(54, -16, 30.5f).setRotationAngle(0, 0, 0).setName("Box 369")
		);
		door_open_.add(new ModelRendererTurbo(door_open_, 377, 201, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 4, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(53.5f, -16, 30.5f).setRotationAngle(0, 0, 0).setName("Box 370")
		);
		door_open_.add(new ModelRendererTurbo(door_open_, 393, 201, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 4, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 0)
			.setRotationPoint(54, -16, -33.5f).setRotationAngle(0, 0, 0).setName("Box 371")
		);
		door_open_.add(new ModelRendererTurbo(door_open_, 433, 201, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 4, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 0)
			.setRotationPoint(53, -16, -33.5f).setRotationAngle(0, 0, 0).setName("Box 372")
		);
		door_open_.addProgram(DefaultPrograms.DOOR_OPEN);
		this.groups.add(door_open_);
	}

}