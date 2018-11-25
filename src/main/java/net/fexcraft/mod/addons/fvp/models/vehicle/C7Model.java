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
@fModel(registryname = "fvp:models/vehicle/c7")
public class C7Model extends VehicleModel {

	public C7Model(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand");
		//
		TurboList chassis_body = new TurboList("chassis_body");
		chassis_body.add(new ModelRendererTurbo(chassis_body, 1, 1, textureX, textureY).addBox(0, 0, 0, 48, 1, 32)
			.setRotationPoint(-24, -3, -16).setRotationAngle(0, 0, 0).setName("Box 0")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 137, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 50, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.9f, 0, 0, -0.9f, 0, 0, -0.9f, 0, 0, -0.9f, 0, 0)
			.setRotationPoint(-25, -4, -18).setRotationAngle(0, 0, 0).setName("Box 1")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 249, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 50, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.9f, 0, 0, -0.9f, 0, 0, -0.9f, 0, 0, -0.9f, 0, 0)
			.setRotationPoint(-25, -4, 16).setRotationAngle(0, 0, 0).setName("Box 2")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 1, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 5, 2, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(23, -9, -18).setRotationAngle(0, 0, 0).setName("Box 3")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 17, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 5, 2, 0, 1, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(38, -9, -18).setRotationAngle(0, 0, 0).setName("Box 4")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 361, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 2, 0, 1, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(37, -10, -18).setRotationAngle(0, 0, 0).setName("Box 5")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 377, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 2, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(24, -10, -18).setRotationAngle(0, 0, 0).setName("Box 6")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 393, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 13, 1, 2, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(25, -11, -18).setRotationAngle(0, 0, 0).setName("Box 7")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 425, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 5, 2, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(23, -9, 16).setRotationAngle(0, 0, 0).setName("Box 8")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 441, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 2, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(24, -10, 16).setRotationAngle(0, 0, 0).setName("Box 9")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 457, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 13, 1, 2, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(25, -11, 16).setRotationAngle(0, 0, 0).setName("Box 10")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 489, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 2, 0, 1, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(37, -10, 16).setRotationAngle(0, 0, 0).setName("Box 11")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 1, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 5, 2, 0, 1, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(38, -9, 16).setRotationAngle(0, 0, 0).setName("Box 12")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 17, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 5, 2, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-40, -9, 16).setRotationAngle(0, 0, 0).setName("Box 13")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 137, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 5, 2, 0, 1, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-25, -9, 16).setRotationAngle(0, 0, 0).setName("Box 14")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 153, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 2, 0, 1, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-26, -10, 16).setRotationAngle(0, 0, 0).setName("Box 15")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 169, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 13, 1, 2, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-38, -11, 16).setRotationAngle(0, 0, 0).setName("Box 16")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 201, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 2, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-39, -10, 16).setRotationAngle(0, 0, 0).setName("Box 17")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 217, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 5, 2, 0, 1, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-25, -9, -18).setRotationAngle(0, 0, 0).setName("Box 18")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 233, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 2, 0, 1, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-26, -10, -18).setRotationAngle(0, 0, 0).setName("Box 19")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 249, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 13, 1, 2, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-38, -11, -18).setRotationAngle(0, 0, 0).setName("Box 20")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 281, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 2, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-39, -10, -18).setRotationAngle(0, 0, 0).setName("Box 21")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 297, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 5, 2, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-40, -9, -18).setRotationAngle(0, 0, 0).setName("Box 22")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 313, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.9f, 0, 0, -0.9f, 0, 0, 0, 0, 0)
			.setRotationPoint(-44, -4, 16).setRotationAngle(0, 0, 0).setName("Box 23")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 337, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.9f, 0, 0, -0.9f, 0, 0, 0, 0, 0)
			.setRotationPoint(-44, -4, -18).setRotationAngle(0, 0, 0).setName("Box 24")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 329, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0)
			.setRotationPoint(-47, -4, -16).setRotationAngle(0, 0, 0).setName("Box 25")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 369, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 2, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, 0, 0, 0, 0, 0, 0, -1, 0, 0)
			.setRotationPoint(-47, -4, -18).setRotationAngle(0, 0, 0).setName("Box 26")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 385, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1)
			.setRotationPoint(-47, -4, 16).setRotationAngle(0, 0, 0).setName("Box 27")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 401, 9, textureX, textureY).addBox(0, 0, 0, 2, 1, 32)
			.setRotationPoint(-47, -5, -16).setRotationAngle(0, 0, 0).setName("Box 28")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 401, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 2, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-47, -5, -18).setRotationAngle(0, 0, 0).setName("Box 29")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 417, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(-47, -5, 16).setRotationAngle(0, 0, 0).setName("Box 30")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 441, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.9f, 0, 0, 0, 0, 0, 0, 0, 0, -0.9f, 0, 0)
			.setRotationPoint(38, -4, 16).setRotationAngle(0, 0, 0).setName("Box 31")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 457, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 2, 0, 0.25f, 0, 0, 0, 0, 0, 0, 0, 0, 0.25f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(40, -5, 16).setRotationAngle(0, 0, 0).setName("Box 32")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 473, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.9f, 0, 0, 0, 0, 0, 0, 0, 0, -0.9f, 0, 0)
			.setRotationPoint(38, -4, -18).setRotationAngle(0, 0, 0).setName("Box 33")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 489, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 2, 0, 0.25f, 0, 0, 0, 0, 0, 0, 0, 0, 0.25f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(40, -5, -18).setRotationAngle(0, 0, 0).setName("Box 34")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 137, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 32, 0, 0, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0, 0, 0, 0, 0, 0, -0.9f, 0, 0, -0.9f, 0, 0, 0, 0, 0)
			.setRotationPoint(43, -5, -16).setRotationAngle(0, 0, 0).setName("Box 35")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 1, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 2, 0, 0, 0, 0, 0.1f, 0, 0, 0.1f, 0, -1, 0, 0, 0, 0, 0, 0, -0.9f, 0, 0, -0.9f, 0, -1, 0, 0, 0)
			.setRotationPoint(43, -5, 16).setRotationAngle(0, 0, 0).setName("Box 36")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 17, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 2, 0, 0, 0, 0, 0.1f, 0, -1, 0.1f, 0, 0, 0, 0, 0, 0, 0, 0, -0.9f, 0, -1, -0.9f, 0, 0, 0, 0, 0)
			.setRotationPoint(43, -5, -18).setRotationAngle(0, 0, 0).setName("Box 37")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 209, 17, textureX, textureY).addBox(0, 0, 0, 6, 1, 32)
			.setRotationPoint(-45, -3, -16).setRotationAngle(0, 0, 0).setName("Box 38")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 257, 25, textureX, textureY).addBox(0, 0, 0, 4, 1, 32)
			.setRotationPoint(39, -4, -16).setRotationAngle(0, 0, 0).setName("Box 39")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 1, 41, textureX, textureY).addBox(0, 0, 0, 15, 1, 24)
			.setRotationPoint(-39, -3, -12).setRotationAngle(0, 0, 0).setName("Box 40")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 441, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 15, 2, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(24, -4, -10).setRotationAngle(0, 0, 0).setName("Box 41")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 441, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0, 0, 0)
			.setRotationPoint(43, -7, -16).setRotationAngle(0, 0, 0).setName("Box 60")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 417, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -0.25f, 0, 0, 0, 0.1f, 0, 0, 0.1f, 0, -1, 0, 0, 0)
			.setRotationPoint(43, -7, 16).setRotationAngle(0, 0, 0).setName("Box 61")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 441, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 2, 0, 0, 0, -0.25f, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.1f, 0, -1, 0.1f, 0, 0, 0, 0, 0)
			.setRotationPoint(43, -7, -18).setRotationAngle(0, 0, 0).setName("Box 66")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 497, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 4, 0, 0, -0.8f, 0, -0.2f, -0.8f, 0, -0.2f, -0.8f, -1.2f, 0, -0.8f, -0.4f, 0, 0, 0, -0.2f, 0, 0, -0.2f, 0, -1.2f, 0, 0, -0.4f)
			.setRotationPoint(43, -8, 14).setRotationAngle(0, 0, 0).setName("Box 72")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 497, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 4, 0, 0, 0, 0, -0.2f, 0, 0, -0.2f, 0, -1.7f, 0, 0, -0.9f, 0, -0.8f, 0, -0.2f, -0.8f, 0, -0.2f, -0.8f, -1.7f, 0, -0.8f, -0.9f)
			.setRotationPoint(43, -12, 14).setRotationAngle(0, 0, 0).setName("Box 73")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 417, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 4, 0, 0, -0.8f, 0, -0.2f, -0.8f, 0, -0.2f, -0.8f, -1.45f, 0, -0.8f, -0.65f, 0, 0, 0, -0.2f, 0, 0, -0.2f, 0, -1.45f, 0, 0, -0.65f)
			.setRotationPoint(43, -10, 14).setRotationAngle(0, 0, 0).setName("Box 74")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 305, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 4, 0, 0, -0.8f, -0.4f, -0.2f, -0.8f, -1.2f, -0.2f, -0.8f, 0, 0, -0.8f, 0, 0, 0, -0.4f, -0.2f, 0, -1.2f, -0.2f, 0, 0, 0, 0, 0)
			.setRotationPoint(43, -8, -18).setRotationAngle(0, 0, 0).setName("Box 79")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 337, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 4, 0, 0, -0.8f, -0.65f, -0.2f, -0.8f, -1.45f, -0.2f, -0.8f, 0, 0, -0.8f, 0, 0, 0, -0.65f, -0.2f, 0, -1.45f, -0.2f, 0, 0, 0, 0, 0)
			.setRotationPoint(43, -10, -18).setRotationAngle(0, 0, 0).setName("Box 81")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 369, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 4, 0, 0, 0, -0.9f, -0.2f, 0, -1.7f, -0.2f, 0, 0, 0, 0, 0, 0, -0.8f, -0.9f, -0.2f, -0.8f, -1.7f, -0.2f, -0.8f, 0, 0, -0.8f, 0)
			.setRotationPoint(43, -12, -18).setRotationAngle(0, 0, 0).setName("Box 82")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 225, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 6, 0, 0, -0.2f, 0, -0.8f, -0.2f, 0, -0.8f, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, -0.8f, -0.2f, 0, -0.8f, -0.2f, 0, 0, -0.2f, 0)
			.setRotationPoint(46.1f, -8.5f, -3).setRotationAngle(0, 0, 0).setName("Box 84")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 401, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 6, 0, 0, -0.2f, 0, -0.8f, -0.2f, 0, -0.8f, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, -0.8f, -0.2f, 0, -0.8f, -0.2f, 0, 0, -0.2f, 0)
			.setRotationPoint(46.1f, -10, -3).setRotationAngle(0, 0, 0).setName("Box 85")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 417, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 6, 0, 0, -0.2f, 0, -0.8f, -0.2f, 0, -0.8f, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, -0.8f, -0.2f, 0, -0.8f, -0.2f, 0, 0, -0.2f, 0)
			.setRotationPoint(46.1f, -11.5f, -3).setRotationAngle(0, 0, 0).setName("Box 86")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 321, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 11, 0, 0, -0.2f, 0, -0.8f, -0.2f, 0, -1.1f, -0.2f, -0.5f, 0.3f, -0.2f, -0.5f, 0, -0.2f, 0, -0.8f, -0.2f, 0, -1.1f, -0.2f, -0.5f, 0.3f, -0.2f, -0.5f)
			.setRotationPoint(46.1f, -11.5f, 3).setRotationAngle(0, 0, 0).setName("Box 87")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 257, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 11, 0, 0, -0.2f, 0, -0.8f, -0.2f, 0, -1.1f, -0.2f, -0.5f, 0.3f, -0.2f, -0.5f, 0, -0.2f, 0, -0.8f, -0.2f, 0, -1.1f, -0.2f, -0.5f, 0.3f, -0.2f, -0.5f)
			.setRotationPoint(46.1f, -10, 3).setRotationAngle(0, 0, 0).setName("Box 88")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 57, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 11, 0, 0, -0.2f, 0, -0.8f, -0.2f, 0, -1.1f, -0.2f, -0.5f, 0.3f, -0.2f, -0.5f, 0, -0.2f, 0, -0.8f, -0.2f, 0, -1.1f, -0.2f, -0.5f, 0.3f, -0.2f, -0.5f)
			.setRotationPoint(46.1f, -8.5f, 3).setRotationAngle(0, 0, 0).setName("Box 89")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 105, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 11, 0, 0.3f, -0.2f, -0.5f, -1.1f, -0.2f, -0.5f, -0.8f, -0.2f, 0, 0, -0.2f, 0, 0.3f, -0.2f, -0.5f, -1.1f, -0.2f, -0.5f, -0.8f, -0.2f, 0, 0, -0.2f, 0)
			.setRotationPoint(46.1f, -11.5f, -14).setRotationAngle(0, 0, 0).setName("Box 90")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 305, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 11, 0, 0.3f, -0.2f, -0.5f, -1.1f, -0.2f, -0.5f, -0.8f, -0.2f, 0, 0, -0.2f, 0, 0.3f, -0.2f, -0.5f, -1.1f, -0.2f, -0.5f, -0.8f, -0.2f, 0, 0, -0.2f, 0)
			.setRotationPoint(46.1f, -10, -14).setRotationAngle(0, 0, 0).setName("Box 91")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 481, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 11, 0, 0.3f, -0.2f, -0.5f, -1.1f, -0.2f, -0.5f, -0.8f, -0.2f, 0, 0, -0.2f, 0, 0.3f, -0.2f, -0.5f, -1.1f, -0.2f, -0.5f, -0.8f, -0.2f, 0, 0, -0.2f, 0)
			.setRotationPoint(46.1f, -8.5f, -14).setRotationAngle(0, 0, 0).setName("Box 92")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 17, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 1, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0)
			.setRotationPoint(45, -12, -4).setRotationAngle(0, 0, 0).setName("Box 99")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 57, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 1, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0)
			.setRotationPoint(45, -12, 2).setRotationAngle(0, 0, 0).setName("Box 100")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 137, 57, textureX, textureY).addBox(0, 0, 0, 2, 2, 30)
			.setRotationPoint(30.5f, -4.5f, -15).setRotationAngle(0, 0, 0).setName("Box 108")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 209, 57, textureX, textureY).addBox(0, 0, 0, 2, 2, 30)
			.setRotationPoint(-32.5f, -4.5f, -15).setRotationAngle(0, 0, 0).setName("Box 109")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 465, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 12, 1, 0, 8, 0, 1, -8, 0, 1, -8, 0, -1, 8, 0, -1, 4, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0.5f)
			.setRotationPoint(20, -26, 15).setRotationAngle(0, 0, 0).setName("Box 121")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 225, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 12, 1, 0, 8, 0, -1, -8, 0, -1, -8, 0, 1, 8, 0, 1, 4, 0, 0.5f, 0, 0, 0, 0, 0, 0, 4, 0, 0)
			.setRotationPoint(20, -26, -16).setRotationAngle(0, 0, 0).setName("Box 123")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 249, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 11, 1, 0, -4, 0, 1, 4, 0, 1, 4, 0, -1, -4, 0, -1, 0.5f, 0, 0, 0, 0, 0, 0, 0, 0.5f, 0.5f, 0, 0.5f)
			.setRotationPoint(-45, -26, 15).setRotationAngle(0, 0, 0).setName("Box 124")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 505, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 11, 1, 0, -4, 0, -1, 4, 0, -1, 4, 0, 1, -4, 0, 1, 0.5f, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0, 0.5f, 0, 0)
			.setRotationPoint(-45, -26, -16).setRotationAngle(0, 0, 0).setName("Box 125")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 273, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 11, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f)
			.setRotationPoint(-24, -26, 15).setRotationAngle(0, 0, 0).setName("Box 131")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 1, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 11, 1, 0, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-24, -26, -16).setRotationAngle(0, 0, 0).setName("Box 132")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 289, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 4, 32, 0, 1, 0, 0, 0, -1, 0, 0, -1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1)
			.setRotationPoint(17, -15, -16).setRotationAngle(0, 0, 0).setName("Box 133")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 169, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 8, 34, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0)
			.setRotationPoint(21, -11, -17).setRotationAngle(0, 0, 0).setName("Box 135")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 369, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.9f, 0, 0, 0, 0, 0, 0, 0, 0, -0.9f, 0, 0)
			.setRotationPoint(-25, -4, 12).setRotationAngle(0, 0, 0).setName("Box 138")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 385, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.9f, 0, 0, -0.9f, 0, 0, 0, 0, 0)
			.setRotationPoint(-39, -4, 12).setRotationAngle(0, 0, 0).setName("Box 139")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 449, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.9f, 0, 0, -0.9f, 0, 0, 0, 0, 0)
			.setRotationPoint(-39, -4, -16).setRotationAngle(0, 0, 0).setName("Box 140")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 161, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.9f, 0, 0, 0, 0, 0, 0, 0, 0, -0.9f, 0, 0)
			.setRotationPoint(-25, -4, -16).setRotationAngle(0, 0, 0).setName("Box 141")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 305, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.9f, 0, 0, -0.9f, 0, 0, 0, 0, 0)
			.setRotationPoint(24, -4, -16).setRotationAngle(0, 0, 0).setName("Box 142")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 361, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.9f, 0, 0, -0.9f, 0, 0, 0, 0, 0)
			.setRotationPoint(24, -4, 10).setRotationAngle(0, 0, 0).setName("Box 143")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 9, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.9f, 0, 0, 0, 0, 0, 0, 0, 0, -0.9f, 0, 0)
			.setRotationPoint(38, -4, 10).setRotationAngle(0, 0, 0).setName("Box 144")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 497, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.9f, 0, 0, 0, 0, 0, 0, 0, 0, -0.9f, 0, 0)
			.setRotationPoint(38, -4, -16).setRotationAngle(0, 0, 0).setName("Box 145")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 337, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 2, 34, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-45, -5, -17).setRotationAngle(0, 0, 0).setName("Box 156")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 217, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 1, 24, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-39, -4, -12).setRotationAngle(0, 0, 0).setName("Box 157")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 449, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 1, 24, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-31, -4, -12).setRotationAngle(0, 0, 0).setName("Box 158")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 377, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 11, 1, 0, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-4, -26, -16).setRotationAngle(0, 0, 0).setName("Box 241")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 393, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 11, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f)
			.setRotationPoint(-4, -26, 15).setRotationAngle(0, 0, 0).setName("Box 242")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 433, 129, textureX, textureY).addBox(0, 0, 0, 1, 1, 34)
			.setRotationPoint(23, -4, -17).setRotationAngle(0, 0, 0).setName("Box 245")
		);
		chassis_body.addProgram("fvtm:example_program");//TODO do not forget these exists!
		this.groups.add(chassis_body);
		//
		TurboList chassis_primary = new TurboList("chassis_primary");
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 177, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 11, 2, 3, 0, 0, 0, 0, 0, -0.5f, 0, 0, -1.5f, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(32, -15, 13).setRotationAngle(0, 0, 0).setName("Box 44")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 209, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 9, 9, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(16, -13, 17).setRotationAngle(0, 0, 0).setName("Box 45")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 257, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 9, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(38, -13, 17).setRotationAngle(0, 0, 0).setName("Box 46")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 273, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 13, 3, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, -0.65f, 0, 0, -0.65f)
			.setRotationPoint(25, -13, 17).setRotationAngle(0, 0, 0).setName("Box 47")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 305, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 11, 1, 1, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.9f, 0, 0, -0.9f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(32, -14, 16).setRotationAngle(0, 0, 0).setName("Box 48")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 337, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 9, 9, 1, 0, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(16, -13, -18).setRotationAngle(0, 0, 0).setName("Box 49")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 369, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 9, 1, 0, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(38, -13, -18).setRotationAngle(0, 0, 0).setName("Box 50")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 385, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 13, 3, 1, 0, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, -0.65f, 0, 0, -0.65f, 0, 0, 0.5f, 0, 0, 0.5f)
			.setRotationPoint(25, -13, -18).setRotationAngle(0, 0, 0).setName("Box 51")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 11, 1, 1, 0, 0, -0.9f, 0, 0, -0.9f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(32, -14, -17).setRotationAngle(0, 0, 0).setName("Box 52")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 137, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 11, 2, 3, 0, 0, -1, 0, 0, -1.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(32, -15, -16).setRotationAngle(0, 0, 0).setName("Box 53")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 177, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(22, -15, 13).setRotationAngle(0, 0, 0).setName("Box 54")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 305, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, -0.9f, 0, 0, -0.9f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(22, -14, 16).setRotationAngle(0, 0, 0).setName("Box 55")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 385, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 1, 1, 0, 0, -0.9f, 0, 0, -0.9f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(22, -14, -17).setRotationAngle(0, 0, 0).setName("Box 56")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 177, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 2, 3, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(22, -15, -16).setRotationAngle(0, 0, 0).setName("Box 57")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 497, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 3, 0, 0, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, 0, 0, 0, 0.5f, 0, 0, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0, 0, 0)
			.setRotationPoint(43, -14, -16).setRotationAngle(0, 0, 0).setName("Box 63")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 273, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 3, 0, 0, 0.5f, 0, -0.5f, 0, 0, -0.5f, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0, 0, 0)
			.setRotationPoint(43, -14, 13).setRotationAngle(0, 0, 0).setName("Box 64")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 441, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 1, 0, 0, -0.5f, 0, -0.5f, -0.5f, 0, 0, -0.9f, -0.6f, 0, -0.9f, 0, 0, 0, 0, 0.1f, 0, 0, 0.1f, 0, -0.6f, 0, 0, 0)
			.setRotationPoint(43, -14, 16).setRotationAngle(0, 0, 0).setName("Box 66")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 497, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 1, 0, 0, 0, 0, 0.1f, 0, -0.6f, 0.1f, 0, 0, 0, 0, 0, 0, 0, 0.11f, 0.1f, 0, -0.6f, 0.1f, 0, 0, 0, 0, 0)
			.setRotationPoint(43, -13, -17).setRotationAngle(0, 0, 0).setName("Box 69")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 201, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 1, 0, 0, 0, 0, 0.1f, 0, 0, 0.1f, 0, -0.6f, 0, 0, 0, 0, 0, 0, 0.1f, 0, 0, 0.1f, 0, -0.6f, 0, 0, 0.11f)
			.setRotationPoint(43, -13, 16).setRotationAngle(0, 0, 0).setName("Box 70")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 353, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 32, 0, 0, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0, 0, 0, 0, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0, 0, 0)
			.setRotationPoint(43, -13, -16).setRotationAngle(0, 0, 0).setName("Box 71")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 257, 33, textureX, textureY).addBox(0, 0, 0, 3, 5, 1)
			.setRotationPoint(43, -12, 13).setRotationAngle(0, 0, 0).setName("Box 77")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 273, 33, textureX, textureY).addBox(0, 0, 0, 3, 5, 1)
			.setRotationPoint(43, -12, -14).setRotationAngle(0, 0, 0).setName("Box 78")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 5, 3, 0, 0, 0, 0, 0, 0, 0, -1.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(43, -12, -13).setRotationAngle(0, 0, 0).setName("Box 93")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 121, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 5, 3, 0, 0, 0, 0, -1.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1.5f, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(43, -12, 10).setRotationAngle(0, 0, 0).setName("Box 95")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 233, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 1, 0, 0, 0, 0, 0.5f, 0, 0, -0.75f, 0, 0, 0, 0, 0, 0, 0, 0, 0.5f, 0, 0, -0.75f, 0, 0, 0, 0, 0)
			.setRotationPoint(43, -12, -10).setRotationAngle(0, 0, 0).setName("Box 97")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 353, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 1, 0, 0, 0, 0, -0.75f, 0, 0, 0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.75f, 0, 0, 0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(43, -12, 9).setRotationAngle(0, 0, 0).setName("Box 98")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 361, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 11, 2, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-44, -15, 16).setRotationAngle(0, 0, 0).setName("Box 99")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 393, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 11, 2, 0, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-44, -15, -18).setRotationAngle(0, 0, 0).setName("Box 100")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 137, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 13, 5, 2, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0.55f, 0, 0, 0.55f, 0, 0, -0.55f, 0, 0, -0.55f)
			.setRotationPoint(-38, -15, 16).setRotationAngle(0, 0, 0).setName("Box 101")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 177, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 13, 5, 2, 0, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, -0.55f, 0, 0, -0.55f, 0, 0, 0.55f, 0, 0, 0.55f)
			.setRotationPoint(-38, -15, -18).setRotationAngle(0, 0, 0).setName("Box 102")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 417, 49, textureX, textureY).addBox(0, 0, 0, 2, 11, 2)
			.setRotationPoint(-46, -15, -16).setRotationAngle(0, 0, 0).setName("Box 103")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 433, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 10, 2, 0, 0, 0, -1.5f, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -0.1f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-46, -15, -18).setRotationAngle(0, 0, 0).setName("Box 104")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 449, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 10, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.1f, 0, 0, -1)
			.setRotationPoint(-46, -15, 16).setRotationAngle(0, 0, 0).setName("Box 105")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 249, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 31, 0, 0, 0, 0, -1, 0, -1, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(11.5f, -27, -15.5f).setRotationAngle(0, 0, 0).setName("Box 126")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 401, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 31, 0, -1, 0, -1, 0, 0, 0, 0, 0, 0, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-41.5f, -27, -15.5f).setRotationAngle(0, 0, 0).setName("Box 127")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 89, textureX, textureY).addBox(0, 0, 0, 50, 1, 31)
			.setRotationPoint(-38.5f, -27, -15.5f).setRotationAngle(0, 0, 0).setName("Box 128")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 257, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 11, 1, 0, 0, 0, 1, -1, 0, 1, -1, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-25, -15, 17).setRotationAngle(0, 0, 0).setName("Box 129")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 289, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 11, 1, 0, 0, 0, -1, -1, 0, -1, -1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-25, -15, -18).setRotationAngle(0, 0, 0).setName("Box 130")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 441, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 1, 1, 0, 0, 0, -0.5f, 0, 0, 0, 0, -0.9f, 0, 0, -0.9f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(16, -14, 16).setRotationAngle(0, 0, 0).setName("Box 136")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 497, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 1, 1, 0, 0, -0.9f, 0, 0, -0.9f, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(16, -14, -17).setRotationAngle(0, 0, 0).setName("Box 137")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 305, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 4, 0, 1, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-25, -9, 12).setRotationAngle(0, 0, 0).setName("Box 146")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 481, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 4, 0, 1, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-25, -9, -16).setRotationAngle(0, 0, 0).setName("Box 147")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 9, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 4, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-39, -9, -16).setRotationAngle(0, 0, 0).setName("Box 148")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 25, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 4, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-39, -9, 12).setRotationAngle(0, 0, 0).setName("Box 149")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 409, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 4, 0, 1, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-26, -10, 12).setRotationAngle(0, 0, 0).setName("Box 150")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 465, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 4, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-38, -10, 12).setRotationAngle(0, 0, 0).setName("Box 151")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 449, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 4, 0, 1, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-26, -10, -16).setRotationAngle(0, 0, 0).setName("Box 152")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 321, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 4, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-38, -10, -16).setRotationAngle(0, 0, 0).setName("Box 153")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 441, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 11, 1, 4, 0, -1, -0.5f, -1, -1, -0.5f, -1, -1, -0.5f, 0, -1, -0.5f, 0, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-37, -11, 12).setRotationAngle(0, 0, 0).setName("Box 154")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 41, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 11, 1, 4, 0, -1, -0.5f, 0, -1, -0.5f, 0, -1, -0.5f, -1, -1, -0.5f, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0.1f, 0, 0, 0.1f)
			.setRotationPoint(-37, -11, -16).setRotationAngle(0, 0, 0).setName("Box 155")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 73, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 15, 5, 1, 0, -1, 0, 0, -1, 0, 0, -1, 0, -0.5f, -1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-39, -9, -12).setRotationAngle(0, 0, 0).setName("Box 159")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 393, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 15, 5, 1, 0, -1, 0, -0.5f, -1, 0, -0.5f, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-39, -9, 11).setRotationAngle(0, 0, 0).setName("Box 160")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 209, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 13, 1, 1, 0, -1, 0, 0, -1, 0, 0, -1, 0, -0.9f, -1, 0, -0.9f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(-38, -10, -12).setRotationAngle(0, 0, 0).setName("Box 161")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 41, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 13, 1, 1, 0, -1, 0, -0.9f, -1, 0, -0.9f, -1, 0, 0, -1, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-38, -10, 11).setRotationAngle(0, 0, 0).setName("Box 162")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 177, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 6, 0, 1, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(38, -9, -16).setRotationAngle(0, 0, 0).setName("Box 163")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 289, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 6, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(24, -9, -16).setRotationAngle(0, 0, 0).setName("Box 164")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 57, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 6, 0, 1, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(37, -10, -16).setRotationAngle(0, 0, 0).setName("Box 165")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 113, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 6, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(25, -10, -16).setRotationAngle(0, 0, 0).setName("Box 166")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 65, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 11, 1, 6, 0, -1, -0.5f, 0, -1, -0.5f, 0, -1, -0.5f, -1, -1, -0.5f, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0.1f, 0, 0, 0.1f)
			.setRotationPoint(26, -11, -16).setRotationAngle(0, 0, 0).setName("Box 167")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 337, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 15, 5, 1, 0, -1, 0, 0, -1, 0, 0, -1, 0, -0.5f, -1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(24, -9, -10).setRotationAngle(0, 0, 0).setName("Box 168")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 209, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 13, 1, 1, 0, -1, 0, 0, -1, 0, 0, -1, 0, -0.9f, -1, 0, -0.9f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(25, -10, -10).setRotationAngle(0, 0, 0).setName("Box 169")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 305, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 6, 0, 1, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(38, -9, 10).setRotationAngle(0, 0, 0).setName("Box 170")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 441, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 6, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(24, -9, 10).setRotationAngle(0, 0, 0).setName("Box 171")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 145, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 6, 0, 1, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(37, -10, 10).setRotationAngle(0, 0, 0).setName("Box 172")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 337, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 6, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(25, -10, 10).setRotationAngle(0, 0, 0).setName("Box 173")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 385, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 15, 5, 1, 0, -1, 0, -0.5f, -1, 0, -0.5f, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(24, -9, 9).setRotationAngle(0, 0, 0).setName("Box 174")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 249, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 13, 1, 1, 0, -1, 0, -0.9f, -1, 0, -0.9f, -1, 0, 0, -1, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(25, -10, 9).setRotationAngle(0, 0, 0).setName("Box 175")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 137, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 11, 1, 6, 0, -1, -0.5f, -1, -1, -0.5f, -1, -1, -0.5f, 0, -1, -0.5f, 0, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(26, -11, 10).setRotationAngle(0, 0, 0).setName("Box 176")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 457, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 11, 1, 0, 0, 0, -1, -1, 0, -1, -1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-25, -15, -17).setRotationAngle(0, 0, 0).setName("Box 177")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 489, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 11, 1, 0, 0, 0, 1, -1, 0, 1, -1, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-25, -15, 16).setRotationAngle(0, 0, 0).setName("Box 178")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 201, 25, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(-26, -10, 15.5f).setRotationAngle(0, 0, 0).setName("Box 179")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 401, 33, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(-38, -10, 15.5f).setRotationAngle(0, 0, 0).setName("Box 180")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 417, 33, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(-38, -10, -16.5f).setRotationAngle(0, 0, 0).setName("Box 181")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 225, 41, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(-26, -10, -16.5f).setRotationAngle(0, 0, 0).setName("Box 182")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 193, 73, textureX, textureY).addBox(0, 0, 0, 2, 11, 2)
			.setRotationPoint(-46, -15, 14).setRotationAngle(0, 0, 0).setName("Box 238")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 345, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 11, 2, 0, 0, 0, 1, -1, 0, 1, -1, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-4, -15, 16).setRotationAngle(0, 0, 0).setName("Box 239")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 361, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 11, 2, 0, 0, 0, -1, -1, 0, -1, -1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-4, -15, -18).setRotationAngle(0, 0, 0).setName("Box 240")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 409, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 1, 0, 0, -0.9f, 0, 0, -0.9f, -0.6f, -0.5f, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0.1f, 0, -0.6f, 0.1f, 0, 0, 0, 0, 0)
			.setRotationPoint(43, -14, -17).setRotationAngle(0, 0, 0).setName("Box 65")
		);
		chassis_primary.addProgram(DefaultPrograms.RGB_PRIMARY);
		this.groups.add(chassis_primary);
	}

}