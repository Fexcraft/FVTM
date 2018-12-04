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
@fModel(registryname = "fvp:models/vehicle/t2p")
public class T2Model extends VehicleModel {

	public T2Model(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList chassis_core = new TurboList("chassis_core");
		chassis_core.add(new ModelRendererTurbo(chassis_core, 25, 1, textureX, textureY).addBox(0, 0, 0, 12, 5, 50)
			.setRotationPoint(54, -2, -25).setRotationAngle(0, 0, 0).setName("Box 0")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 313, 1, textureX, textureY).addBox(0, 0, 0, 8, 5, 50)
			.setRotationPoint(18, -2, -25).setRotationAngle(0, 0, 0).setName("Box 5")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 385, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 5, 52, 0, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, -1, -3, 0, -1, -3, 0, 0, 0)
			.setRotationPoint(66, -2, -26).setRotationAngle(0, 0, 0).setName("Box 6")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 105, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 84, 10, 4, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, -2, 0, 0, 0, 1, 0, 0, 1, 0, -2, 0, 0)
			.setRotationPoint(-66, -9, 8).setRotationAngle(0, 0, 0).setName("Box 7")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 57, textureX, textureY)
			.addShapeBox(0, 0, -4, 84, 10, 4, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, -2, 0, 0, 0, 1, 0, 0, 1, 0, -2, 0, 0)
			.setRotationPoint(-66, -9, -8).setRotationAngle(0, 0, 0).setName("Box 8")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 5, 20, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, -2, 0, 0, -2, 0, 0, 0, 2)
			.setRotationPoint(26, -2, -10).setRotationAngle(0, 0, 0).setName("Box 9")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 265, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 5, 20, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, -2, 0, 0, 0, 2, 0, 0, 2, 0, -2, 0)
			.setRotationPoint(42, -2, -10).setRotationAngle(0, 0, 0).setName("Box 10")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 385, 1, textureX, textureY).addBox(0, 0, 0, 4, 3, 21)
			.setRotationPoint(38, -2, -10).setRotationAngle(0, 0, 0).setName("Box 11")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 241, 73, textureX, textureY).addBox(0, 0, 0, 46, 1, 50)
			.setRotationPoint(20, -19, -25).setRotationAngle(0, 0, 0).setName("Box 13")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 137, textureX, textureY).addBox(0, 0, 0, 84, 5, 28)
			.setRotationPoint(-66, -14, -14).setRotationAngle(0, 0, 0).setName("Box 20")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 185, 49, textureX, textureY).addBox(-2, -2, 0, 4, 4, 36)
			.setRotationPoint(40, -2, -18).setRotationAngle(0, 0, 0).setName("Box 21")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 329, 129, textureX, textureY).addBox(-2, -2, 0, 4, 4, 36)
			.setRotationPoint(-47, -2, -18).setRotationAngle(0, 0, 0).setName("Box 22")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 425, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 20, 10, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0)
			.setRotationPoint(-57, -9, -8).setRotationAngle(0, 0, 0).setName("Box 26")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 449, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 15, 28, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0)
			.setRotationPoint(-68, -14, -14).setRotationAngle(0, 0, 0).setName("Box 27")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 121, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 10, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, -4, 0, 0, 0, 0, 0)
			.setRotationPoint(20, -12, -25).setRotationAngle(0, 0, 0).setName("Box 141")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 249, 185, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 10, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0)
			.setRotationPoint(50, -12, -25).setRotationAngle(0, 0, 0).setName("Box 142")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 377, 185, textureX, textureY)
			.addShapeBox(0, 0, 0, 16, 3, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -6, 0, 0, -6, 0, 0, 0, 0, 0)
			.setRotationPoint(20, -15, -25).setRotationAngle(0, 0, 0).setName("Box 143")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 233, textureX, textureY)
			.addShapeBox(0, 0, 0, 16, 3, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -6, 0, 0, 0, 0, 0, 0, 0, 0, -6, 0, 0)
			.setRotationPoint(44, -15, -25).setRotationAngle(0, 0, 0).setName("Box 144")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 89, 241, textureX, textureY).addBox(0, 0, 0, 40, 3, 50)
			.setRotationPoint(20, -18, -25).setRotationAngle(0, 0, 0).setName("Box 145")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 353, 257, textureX, textureY).addBox(0, -2, -2, 66, 4, 4)
			.setRotationPoint(-47, -3, 0).setRotationAngle(-0.7853982f, 0, 0).setName("Box 152")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 73, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 13, 20, 0, 0, 0, 2, 0, 0, 2, 0, 0, 2, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2)
			.setRotationPoint(26, -15, -10).setRotationAngle(0, 0, 0).setName("Box 155")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 193, 185, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 13, 20, 0, 0, 0, 2, 0, 0, 2, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0)
			.setRotationPoint(42, -15, -10).setRotationAngle(0, 0, 0).setName("Box 156")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 321, 185, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 13, 20, 0, 0, 0, 2, 0, 0, 2, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(38, -15, -10).setRotationAngle(0, 0, 0).setName("Box 157")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 233, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 28, 0, 0, -0.2f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.2f, 0)
			.setRotationPoint(65.5f, -11, -14).setRotationAngle(0, 0, 0).setName("Box 161")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 361, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 28, 0, 0, -0.2f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.2f, 0)
			.setRotationPoint(65.5f, -12, -14).setRotationAngle(0, 0, 0).setName("Box 162")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 49, 289, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 28, 0, 0, -0.2f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.2f, 0)
			.setRotationPoint(65.5f, -13, -14).setRotationAngle(0, 0, 0).setName("Box 163")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 89, 297, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 28, 0, 0, -0.2f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.2f, 0)
			.setRotationPoint(65.5f, -14, -14).setRotationAngle(0, 0, 0).setName("Box 164")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 161, 297, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 28, 0, 0, -0.2f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.2f, 0)
			.setRotationPoint(65.5f, -15, -14).setRotationAngle(0, 0, 0).setName("Box 165")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 233, 297, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 28, 0, 0, -0.2f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.2f, 0)
			.setRotationPoint(65.5f, -16, -14).setRotationAngle(0, 0, 0).setName("Box 166")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 305, 297, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 28, 0, 0, -0.2f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.2f, 0)
			.setRotationPoint(65.5f, -17, -14).setRotationAngle(0, 0, 0).setName("Box 167")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 345, 305, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 28, 0, 0, -0.2f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.2f, 0)
			.setRotationPoint(65.5f, -18, -14).setRotationAngle(0, 0, 0).setName("Box 168")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 417, 305, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 28, 0, 0, -0.2f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.2f, 0)
			.setRotationPoint(65.5f, -19, -14).setRotationAngle(0, 0, 0).setName("Box 169")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 65, 329, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 28, 0, 0, -0.2f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.2f, 0)
			.setRotationPoint(65.5f, -20, -14).setRotationAngle(0, 0, 0).setName("Box 170")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 137, 329, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 28, 0, 0, -0.2f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.2f, 0)
			.setRotationPoint(65.5f, -21, -14).setRotationAngle(0, 0, 0).setName("Box 171")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 209, 329, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 28, 0, 0, -0.2f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.2f, 0)
			.setRotationPoint(65.5f, -22, -14).setRotationAngle(0, 0, 0).setName("Box 172")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 281, 329, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 28, 0, 0, -0.2f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.2f, 0)
			.setRotationPoint(65.5f, -23, -14).setRotationAngle(0, 0, 0).setName("Box 173")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 337, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 28, 0, 0, -0.2f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.2f, 0)
			.setRotationPoint(65.5f, -24, -14).setRotationAngle(0, 0, 0).setName("Box 174")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 297, 337, textureX, textureY).addBox(0, 0, 0, 6, 16, 50)
			.setRotationPoint(60, -18, -25).setRotationAngle(0, 0, 0).setName("Box 175")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 409, 33, textureX, textureY).addBox(0, 0, 0, 12, 5, 1)
			.setRotationPoint(54, -2, -26).setRotationAngle(0, 0, 0).setName("Box 182")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 25, 73, textureX, textureY).addBox(0, 0, 0, 12, 5, 1)
			.setRotationPoint(54, -2, 25).setRotationAngle(0, 0, 0).setName("Box 183")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 417, 9, textureX, textureY).addBox(0, 0, 0, 8, 5, 1)
			.setRotationPoint(18, -2, -26).setRotationAngle(0, 0, 0).setName("Box 184")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 17, textureX, textureY).addBox(0, 0, 0, 8, 5, 1)
			.setRotationPoint(18, -2, 25).setRotationAngle(0, 0, 0).setName("Box 185")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 385, 17, textureX, textureY).addBox(0, 0, 0, 8, 2, 1)
			.setRotationPoint(56, -4, 24.8f).setRotationAngle(0, 0, 0).setName("Box 196")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 417, 17, textureX, textureY).addBox(0, 0, 0, 8, 2, 1)
			.setRotationPoint(56, -9, 24.8f).setRotationAngle(0, 0, 0).setName("Box 197")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 337, 33, textureX, textureY).addBox(0, 0, 0, 10, 2, 1)
			.setRotationPoint(54, -14, 24.8f).setRotationAngle(0, 0, 0).setName("Box 198")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 409, 41, textureX, textureY).addBox(0, 0, 0, 12, 2, 1)
			.setRotationPoint(51, -18.8f, 24.8f).setRotationAngle(0, 0, 0).setName("Box 199")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 33, textureX, textureY).addBox(0, 0, 0, 8, 2, 1)
			.setRotationPoint(56, -4, -25.8f).setRotationAngle(0, 0, 0).setName("Box 200")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 337, 41, textureX, textureY).addBox(0, 0, 0, 8, 2, 1)
			.setRotationPoint(56, -9, -25.8f).setRotationAngle(0, 0, 0).setName("Box 201")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 49, textureX, textureY).addBox(0, 0, 0, 10, 2, 1)
			.setRotationPoint(54, -14, -25.8f).setRotationAngle(0, 0, 0).setName("Box 202")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 449, 49, textureX, textureY).addBox(0, 0, 0, 12, 2, 1)
			.setRotationPoint(51, -18.8f, -25.8f).setRotationAngle(0, 0, 0).setName("Box 203")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 505, 73, textureX, textureY)
			.addShapeBox(0, -1, -1, 1, 2, 2, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1)
			.setRotationPoint(69, -28, 0).setRotationAngle(0, 0, -0.05235988f).setName("Box 328")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 129, 81, textureX, textureY)
			.addShapeBox(0, -1, -1, 1, 1, 4, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1)
			.setRotationPoint(69.1f, 1, -21).setRotationAngle(0, 0, -0.05235988f).setName("Box 329")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 105, 89, textureX, textureY)
			.addShapeBox(0, -1, -1, 1, 1, 4, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1)
			.setRotationPoint(69.1f, 1, 19).setRotationAngle(0, 0, -0.05235988f).setName("Box 330")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 217, textureX, textureY).addBox(0, 0, 0, 1, 3, 12)
			.setRotationPoint(69.2f, -3.5f, -6).setRotationAngle(0, 0, 0).setName("Box 331")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 89, 265, textureX, textureY).addBox(0, 0, 0, 1, 3, 12)
			.setRotationPoint(-67, -3.5f, -6).setRotationAngle(0, 0, -0.15707964f).setName("Box 332")
		);
		this.groups.add(chassis_core);
		//
		TurboList chassis_primary = new TurboList("chassis_primary");
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 129, 49, textureX, textureY).addBox(0, 0, 0, 2, 30, 50)
			.setRotationPoint(18, -32, -25).setRotationAngle(0, 0, 0).setName("Box 12")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 2, 52, 0, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0)
			.setRotationPoint(66, -10, -26).setRotationAngle(0, 0, 0).setName("Box 14")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 449, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 14, 9, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 6, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 6)
			.setRotationPoint(66, -24, -23).setRotationAngle(0, 0, 0).setName("Box 15")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 481, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 14, 9, 0, 0, 0, 6, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 6, 0, 0, 0, 0, 0, -3, 0, 0, 0)
			.setRotationPoint(66, -24, 14).setRotationAngle(0, 0, 0).setName("Box 16")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 385, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 8, 52, 0, 0.5f, 0, 0, -0.5f, 0, -3, -0.5f, 0, -3, 0.5f, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0)
			.setRotationPoint(66, -32, -26).setRotationAngle(0, 0, 0).setName("Box 17")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 65, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 4, 51, 0, 1, 0, -0.5f, -1.5f, 0, -3, -1.5f, 0, -3, 1, 0, -0.5f, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0)
			.setRotationPoint(62, -56, -25.5f).setRotationAngle(0, 0, 0).setName("Box 18")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 193, 129, textureX, textureY).addBox(0, 0, 0, 41, 2, 46)
			.setRotationPoint(20, -56, -23).setRotationAngle(0, 0, 0).setName("Box 19")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 377, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 2, 38, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(66, -4, -19).setRotationAngle(0, 0, 0).setName("Box 23")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 449, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 20, 2, 0, 0, 0, -0.5f, 0, 0, -3.5f, 0, 0, 3.5f, 0, 0, 0.5f, -3.5f, 0, 0, 3.5f, 0, -3, 3.5f, 0, 3, -3.5f, 0, 0)
			.setRotationPoint(62, -52, -26).setRotationAngle(0, 0, 0).setName("Box 24")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 465, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 20, 2, 0, 0, 0, 0.5f, 0, 0, 3.5f, 0, 0, -3.5f, 0, 0, -0.5f, -3.5f, 0, 0, 3.5f, 0, 3, 3.5f, 0, -3, -3.5f, 0, 0)
			.setRotationPoint(62, -52, 24).setRotationAngle(0, 0, 0).setName("Box 25")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 65, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 6, 10, 0, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0)
			.setRotationPoint(66, -8, -26).setRotationAngle(0, 0, 0).setName("Box 158")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 385, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 6, 10, 0, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0)
			.setRotationPoint(66, -8, 16).setRotationAngle(0, 0, 0).setName("Box 159")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 289, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 2, 38, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0)
			.setRotationPoint(66, -8, -19).setRotationAngle(0, 0, 0).setName("Box 160")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 361, 305, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 24, 50, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(18, -56, -25).setRotationAngle(0, 0, 0).setName("Box 177")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 49, 25, textureX, textureY).addBox(0, 0, 0, 2, 10, 1)
			.setRotationPoint(64, -12, 25).setRotationAngle(0, 0, 0).setName("Box 192")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 57, 25, textureX, textureY).addBox(0, 0, 0, 2, 10, 1)
			.setRotationPoint(64, -12, -26).setRotationAngle(0, 0, 0).setName("Box 193")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 409, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 3, 9, 0, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0)
			.setRotationPoint(66, -13, 17).setRotationAngle(0, 0, 0).setName("Box 205")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 25, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 3, 9, 0, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0)
			.setRotationPoint(66, -13, -26).setRotationAngle(0, 0, 0).setName("Box 207")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 465, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 20, 20, 2, 0, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(18, -52, 24).setRotationAngle(0, 0, 0).setName("Box 210")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 73, 217, textureX, textureY)
			.addShapeBox(0, 0, 0, 42, 4, 2, 0, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(18, -56, 23.5f).setRotationAngle(0, 0, 0).setName("Box 211")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 321, 225, textureX, textureY)
			.addShapeBox(0, 0, 0, 42, 4, 2, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(18, -56, -25.5f).setRotationAngle(0, 0, 0).setName("Box 212")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 20, 20, 2, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(18, -52, -26).setRotationAngle(0, 0, 0).setName("Box 213")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 241, 105, textureX, textureY).addBox(0, 0, 0, 20, 13, 2)
			.setRotationPoint(18, -32, 24).setRotationAngle(0, 0, 0).setName("Box 214")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 121, 177, textureX, textureY).addBox(0, 0, 0, 20, 13, 2)
			.setRotationPoint(18, -32, -26).setRotationAngle(0, 0, 0).setName("Box 215")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 225, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 2, 0, 0, 0, -0.5f, -1, 0, -0.5f, -1, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(60, -56, -25.5f).setRotationAngle(0, 0, 0).setName("Box 216")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 289, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 2, 0, 0, 0, 0.5f, -1, 0, 0.5f, -1, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(60, -56, 23.5f).setRotationAngle(0, 0, 0).setName("Box 217")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 169, 1, textureX, textureY).addBox(0, 0, 0, 2, 5, 1)
			.setRotationPoint(64, -24, 25).setRotationAngle(0, 0, 0).setName("Box 224")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 65, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 8, 1, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(64, -32, 25).setRotationAngle(0, 0, 0).setName("Box 225")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 353, 1, textureX, textureY).addBox(0, 0, 0, 2, 5, 1)
			.setRotationPoint(64, -24, -26).setRotationAngle(0, 0, 0).setName("Box 226")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 481, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 8, 1, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(64, -32, -26).setRotationAngle(0, 0, 0).setName("Box 227")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 505, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 10, 2, 0, 0.25f, 0, 0.25f, -1.2f, 0, 0.25f, -1.2f, 0, -0.25f, 0.25f, 0, -0.25f, 0, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(64, -42, 24).setRotationAngle(0, 0, 0).setName("Box 228")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 185, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 10, 2, 0, 0.25f, 0, -0.25f, -1.2f, 0, -0.25f, -1.2f, 0, 0.25f, 0.25f, 0, 0.25f, 0, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(64, -42, -26).setRotationAngle(0, 0, 0).setName("Box 229")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 401, 185, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 19, 2, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f)
			.setRotationPoint(15, -32, 24).setRotationAngle(0, 0, 0).setName("Box 256")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 49, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 20, 2, 0, 0, 0, -0.5f, 0, 0, 0.5f, 0, 0, -0.5f, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f)
			.setRotationPoint(15, -52, 24).setRotationAngle(0, 0, 0).setName("Box 257")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 473, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 4, 2, 0, 0, 0, -0.5f, 0, 0, 0.5f, 0, 0, -0.5f, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f)
			.setRotationPoint(15, -56, 23.5f).setRotationAngle(0, 0, 0).setName("Box 258")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 145, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 19, 2, 0, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(15, -32, -26).setRotationAngle(0, 0, 0).setName("Box 259")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 273, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 20, 2, 0, 0, 0, -1, 0, 0, -0.5f, 0, 0, 0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(15, -52, -26).setRotationAngle(0, 0, 0).setName("Box 260")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 385, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 4, 2, 0, 0, 0, -1, 0, 0, -0.5f, 0, 0, 0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(15, -56, -25.5f).setRotationAngle(0, 0, 0).setName("Box 261")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 0, 152, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 10, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, -4, 0, 0, 0, 0, 0)
			.setRotationPoint(18, -12, -26).setRotationAngle(0, 0, 0)
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 0, 43, textureX, textureY).addBox(0, 0, 0, 20, 4, 1)
			.setRotationPoint(18, -19, 25).setRotationAngle(0, 0, 0).setName("Box 190")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 380, 26, textureX, textureY).addBox(0, 0, 0, 20, 4, 1)
			.setRotationPoint(18, -19, -26).setRotationAngle(0, 0, 0).setName("Box 191")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 382, 67, textureX, textureY)
			.addShapeBox(0, 0, 0, 18, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -6, 0, 0, -6, 0, 0, 0, 0, 0)
			.setRotationPoint(18, -15, -26).setRotationAngle(0, 0, 0)
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 43, 46, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 3, 1, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, -6, 0, 0, 0, 0, 0, 0, 0, 0, -6, 0, 0)
			.setRotationPoint(44, -15, -26).setRotationAngle(0, 0, 0)
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 456, 67, textureX, textureY)
			.addShapeBox(0, 0, 0, 16, 4, 1, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(38, -19, -26).setRotationAngle(0, 0, 0)
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 34, 109, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 10, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0)
			.setRotationPoint(50, -12, -26).setRotationAngle(0, 0, 0)
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 208, 76, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 7, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0)
			.setRotationPoint(62, -19, -26).setRotationAngle(0, 0, 0)
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 482, 134, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 10, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, -4, 0, 0, 0, 0, 0)
			.setRotationPoint(18, -12, 25).setRotationAngle(0, 0, 0)
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 268, 67, textureX, textureY)
			.addShapeBox(0, 0, 0, 18, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -6, 0, 0, -6, 0, 0, 0, 0, 0)
			.setRotationPoint(18, -15, 25).setRotationAngle(0, 0, 0)
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 46, 16, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 3, 1, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, -6, 0, 0, 0, 0, 0, 0, 0, 0, -6, 0, 0)
			.setRotationPoint(44, -15, 25).setRotationAngle(0, 0, 0)
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 421, 67, textureX, textureY)
			.addShapeBox(0, 0, 0, 16, 4, 1, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(38, -19, 25).setRotationAngle(0, 0, 0)
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 162, 83, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 10, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0)
			.setRotationPoint(50, -12, 25).setRotationAngle(0, 0, 0)
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 0, 24, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 7, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0)
			.setRotationPoint(62, -19, 25).setRotationAngle(0, 0, 0)
		);
		chassis_primary.addProgram(DefaultPrograms.RGB_PRIMARY);
		this.groups.add(chassis_primary);
	}

}