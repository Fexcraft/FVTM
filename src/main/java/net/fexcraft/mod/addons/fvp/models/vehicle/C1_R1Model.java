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
@fModel(registryname = "fvp:models/vehicle/c1_r1")
public class C1_R1Model extends VehicleModel {

	public C1_R1Model(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList chassis_core = new TurboList("chassis_core");
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 1, textureX, textureY).addBox(-32, 1, -21, 64, 1, 42).setName("Box 0"));
		chassis_core.add(new ModelRendererTurbo(chassis_core, 177, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 2, 18, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(32, 1, -9).setRotationAngle(0, 0, 0).setName("Box 1")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 209, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 2, 28, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(-42, 1, -14).setRotationAngle(0, 0, 0).setName("Box 2")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 257, 1, textureX, textureY).addBox(0, 0, 0, 3, 3, 34)
			.setRotationPoint(42, -1, -17).setRotationAngle(0, 0, 0).setName("Box 3")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 337, 1, textureX, textureY).addBox(0, 0, 0, 3, 3, 34)
			.setRotationPoint(-45, -1, -17).setRotationAngle(0, 0, 0).setName("Box 4")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 305, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 2, 18, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(45, 1, -9).setRotationAngle(0, 0, 0).setName("Box 9")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 385, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 2, 28, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(-55, 1, -14).setRotationAngle(0, 0, 0).setName("Box 10")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 377, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 58, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, 0, 0, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-29, 0.5f, 21).setRotationAngle(0, 0, 0).setName("Box 432")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 58, 3, 1, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, 0, 0, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-29, 0.5f, -22).setRotationAngle(0, 0, 0).setName("Box 433")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 121, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 64, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, -0.5f, 0, 0, -0.5f, 0)
			.setRotationPoint(-32, 3, 18).setRotationAngle(0, 0, 0).setName("Box 434")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 257, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 64, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(-32, 3, -21).setRotationAngle(0, 0, 0).setName("Box 435")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 353, 105, textureX, textureY).addBox(0, 0, -21, 3, 3, 42)
			.setRotationPoint(55, 0, 0).setRotationAngle(0, 0, 0).setName("Box 436")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 113, textureX, textureY).addBox(0, 0, -21, 3, 3, 42)
			.setRotationPoint(-58, 0, 0).setRotationAngle(0, 0, 0).setName("Box 437")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 105, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 1, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0.5f, -0.5f, 0, 0.5f, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, -1, -0.5f)
			.setRotationPoint(55, 0.5f, 21).setRotationAngle(0, 0, 0).setName("Box 438")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 121, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 2, 3, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -2, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(32, 1, -12).setRotationAngle(0, 0, 0).setName("Box 440")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 153, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 2, 3, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -2, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(45, 1, -12).setRotationAngle(0, 0, 0).setName("Box 441")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 185, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, -2)
			.setRotationPoint(45, 1, 9).setRotationAngle(0, 0, 0).setName("Box 442")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 233, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, -2, 0, 0, 0)
			.setRotationPoint(32, 1, 9).setRotationAngle(0, 0, 0).setName("Box 443")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 193, 113, textureX, textureY)
			.addShapeBox(0, 0, -21, 2, 4, 42, 0, 0, 0, 0.5f, 0, 0, -1, 0, 0, -1, 0, 0, 0.5f, 0, -0.5f, 0.5f, 0, -1, -1, 0, -1, -1, 0, -0.5f, 0.5f)
			.setRotationPoint(58, 0, 0).setRotationAngle(0, 0, 0).setName("Box 450")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 265, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 1, 0, 0, 0.5f, -0.5f, 0, 0.5f, -0.5f, 0, 0.5f, 0, 0, 0.5f, 0, 0, -1, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(55, 0.5f, -22).setRotationAngle(0, 0, 0).setName("Box 451")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 297, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1.5f, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0)
			.setRotationPoint(55, 3, 15).setRotationAngle(0, 0, 0).setName("Box 452")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 321, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, -1.5f, -0.5f, 0)
			.setRotationPoint(55, 3, -20).setRotationAngle(0, 0, 0).setName("Box 453")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 329, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0)
			.setRotationPoint(55, 3, -21).setRotationAngle(0, 0, 0).setName("Box 454")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 345, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0)
			.setRotationPoint(55, 3, 20).setRotationAngle(0, 0, 0).setName("Box 455")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 57, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1.5f, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, -1.5f, -0.5f, 0)
			.setRotationPoint(55, 3, -15).setRotationAngle(0, 0, 0).setName("Box 456")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 417, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 18, 0, 0, -0.4f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.4f, 0, 0, -0.5f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.5f, 0)
			.setRotationPoint(57.65f, -2.7f, -9).setRotationAngle(0, 0, 0).setName("Box 462")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 241, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 18, 0, 0, -0.4f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.4f, 0, 0, -0.5f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.5f, 0)
			.setRotationPoint(57.6f, -3, -9).setRotationAngle(0, 0, 0).setName("Box 463")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 281, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 18, 0, 0, -0.4f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.4f, 0, 0, -0.5f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.5f, 0)
			.setRotationPoint(57.55f, -3.3f, -9).setRotationAngle(0, 0, 0).setName("Box 464")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 321, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 18, 0, 0, -0.4f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.4f, 0, 0, -0.5f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.5f, 0)
			.setRotationPoint(57.5f, -3.6f, -9).setRotationAngle(0, 0, 0).setName("Box 465")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 449, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 18, 0, 0, -0.4f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.4f, 0, 0, -0.5f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.5f, 0)
			.setRotationPoint(57.45f, -3.9f, -9).setRotationAngle(0, 0, 0).setName("Box 466")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 345, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 18, 0, 0, -0.4f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.4f, 0, 0, -0.5f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.5f, 0)
			.setRotationPoint(57.4f, -4.2f, -9).setRotationAngle(0, 0, 0).setName("Box 467")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 473, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 18, 0, 0, -0.4f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.4f, 0, 0, -0.5f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.5f, 0)
			.setRotationPoint(57.35f, -4.5f, -9).setRotationAngle(0, 0, 0).setName("Box 468")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 18, 0, 0, -0.4f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.4f, 0, 0, -0.5f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.5f, 0)
			.setRotationPoint(57.3f, -4.8f, -9).setRotationAngle(0, 0, 0).setName("Box 469")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 169, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 18, 0, 0, -0.4f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.4f, 0, 0, -0.5f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.5f, 0)
			.setRotationPoint(57.25f, -5.1f, -9).setRotationAngle(0, 0, 0).setName("Box 470")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 289, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 18, 0, 0, -0.4f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.4f, 0, 0, -0.5f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.5f, 0)
			.setRotationPoint(57.2f, -5.4f, -9).setRotationAngle(0, 0, 0).setName("Box 471")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 433, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 18, 0, 0, -0.4f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.4f, 0, 0, -0.5f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.5f, 0)
			.setRotationPoint(57.15f, -5.7f, -9).setRotationAngle(0, 0, 0).setName("Box 472")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 265, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 18, 0, 0, -0.4f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.4f, 0, 0, -0.5f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.5f, 0)
			.setRotationPoint(57.1f, -6, -9).setRotationAngle(0, 0, 0).setName("Box 473")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 313, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 18, 0, 0, -0.4f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.4f, 0, 0, -0.5f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.5f, 0)
			.setRotationPoint(57.05f, -6.3f, -9).setRotationAngle(0, 0, 0).setName("Box 474")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 457, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 18, 0, 0, -0.4f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.4f, 0, 0, -0.5f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.5f, 0)
			.setRotationPoint(57, -6.6f, -9).setRotationAngle(0, 0, 0).setName("Box 475")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 337, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 18, 0, 0, -0.4f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.4f, 0, 0, -0.5f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.5f, 0)
			.setRotationPoint(56.95f, -6.9f, -9).setRotationAngle(0, 0, 0).setName("Box 476")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 377, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 18, 0, 0, -0.4f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.4f, 0, 0, -0.5f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.5f, 0)
			.setRotationPoint(56.9f, -7.2f, -9).setRotationAngle(0, 0, 0).setName("Box 477")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 18, 0, 0, -0.4f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.4f, 0, 0, -0.5f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.5f, 0)
			.setRotationPoint(56.85f, -7.5f, -9).setRotationAngle(0, 0, 0).setName("Box 478")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 41, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 18, 0, 0, -0.4f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.4f, 0, 0, -0.5f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.5f, 0)
			.setRotationPoint(56.8f, -7.8f, -9).setRotationAngle(0, 0, 0).setName("Box 479")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 177, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 18, 0, 0, -0.4f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.4f, 0, 0, -0.5f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.5f, 0)
			.setRotationPoint(56.75f, -8.1f, -9).setRotationAngle(0, 0, 0).setName("Box 480")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 41, 177, textureX, textureY)
			.addShapeBox(0, 0, -21, 2, 4, 42, 0, 0, 0, -1, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, -1, 0, -1, -1, 0, -0.5f, 0.5f, 0, -0.5f, 0.5f, 0, -1, -1)
			.setRotationPoint(-60, 0, 0).setRotationAngle(0, 0, 0).setName("Box 503")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 313, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 1, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0.5f, -0.5f, 0, 0.5f, -0.5f, 0, 0, 0, 0, 0, 0, 0, -1, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(-58, 0.5f, 21).setRotationAngle(0, 0, 0).setName("Box 504")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 337, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 1, 0, 0, 0.5f, -0.5f, 0, 0.5f, -0.5f, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0, -0.5f, 0, -1, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-58, 0.5f, -22).setRotationAngle(0, 0, 0).setName("Box 505")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 193, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, -1.5f, -0.5f, 0, -1.5f, -0.5f, 0, 0, -0.5f, 0)
			.setRotationPoint(-58, 3, -15).setRotationAngle(0, 0, 0).setName("Box 506")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 345, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, -1.5f, -0.5f, 0, 0, -0.5f, 0)
			.setRotationPoint(-58, 3, -20).setRotationAngle(0, 0, 0).setName("Box 507")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 121, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, -1.5f, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0)
			.setRotationPoint(-58, 3, 15).setRotationAngle(0, 0, 0).setName("Box 508")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 361, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0)
			.setRotationPoint(-58, 3, 20).setRotationAngle(0, 0, 0).setName("Box 509")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 249, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0)
			.setRotationPoint(-58, 3, -21).setRotationAngle(0, 0, 0).setName("Box 510")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 33, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, -0.5f, -0.5f, 0, -1, -0.5f)
			.setRotationPoint(-32, 0.5f, 21).setRotationAngle(0, 0, 0).setName("Box 511")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 97, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, 0, 0, 0, 0, -1, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(29, 0.5f, 21).setRotationAngle(0, 0, 0).setName("Box 512")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 153, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 1, 0, 0, 0, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, 0, 0, 0, 0, -1, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-32, 0.5f, -22).setRotationAngle(0, 0, 0).setName("Box 513")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 193, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 1, 0, 0, -0.5f, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, -0.5f, -0.5f, 0, -1, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(29, 0.5f, -22).setRotationAngle(0, 0, 0).setName("Box 514")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 369, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 2, 28, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-55, -1, -14).setRotationAngle(0, 0, 0).setName("Box 524")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 425, 201, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 2, 28, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-42, -1, -14).setRotationAngle(0, 0, 0).setName("Box 525")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 97, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 13, 2, 1, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(-3.5f, -28.5f, -10.5f).setRotationAngle(0, 0, 0).setName("Box 554")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 153, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 13, 2, 1, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(-3.5f, -28.5f, 9.5f).setRotationAngle(0, 0, 0).setName("Box 555")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 193, 209, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 19, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(-3.5f, -28.5f, -9.5f).setRotationAngle(0, 0, 0).setName("Box 556")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 281, 225, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 19, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(8.5f, -28.5f, -9.5f).setRotationAngle(0, 0, 0).setName("Box 557")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 129, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 7, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 1)
			.setRotationPoint(-3.5f, -27, 17).setRotationAngle(0, 0, 0).setName("Box 559")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 497, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 10, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 1)
			.setRotationPoint(-3.5f, -20, 18).setRotationAngle(0, 0, 0).setName("Box 560")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 129, textureX, textureY).addBox(0, 0, 0, 3, 11, 1)
			.setRotationPoint(-3.5f, -10, 19).setRotationAngle(0, 0, 0).setName("Box 561")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 225, 129, textureX, textureY).addBox(0, 0, 0, 3, 11, 1)
			.setRotationPoint(-3.5f, -10, -20).setRotationAngle(0, 0, 0).setName("Box 562")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 385, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 10, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(-3.5f, -20, -19).setRotationAngle(0, 0, 0).setName("Box 563")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 457, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 7, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(-3.5f, -27, -18).setRotationAngle(0, 0, 0).setName("Box 564")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 193, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 3, 0, 0, 0, 0, -0.1f, 0, 0, -0.3f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.2f, 0, 0, 0, 0, 0)
			.setRotationPoint(57.4f, -1.5f, 16).setRotationAngle(0, 0, 0).setName("Box 657")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 89, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 3, 0, 0, 0, 0, -0.3f, 0, 0, -0.1f, 0, 0, 0, 0, 0, 0, 0, 0, -0.2f, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(57.4f, -1.5f, -19).setRotationAngle(0, 0, 0).setName("Box 658")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 225, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 10, 0, 0, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, 0, 0, 0)
			.setRotationPoint(60, 0.5f, -5).setRotationAngle(0, 0, 0.034906585f).setName("Box 661")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 473, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0.5f, 0.5f, 0, 0.5f, 0.5f, 0, 0, 0, -0.7f, 0, 0, -0.7f, 0.5f, 0.5f, 0, 0.5f, 0.5f, 0, 0, 0, -0.7f, 0, 0, -0.7f)
			.setRotationPoint(29, -9, 20.9f).setRotationAngle(0, 0, 0).setName("Box 662")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 297, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, -0.7f, 0, 0, -0.7f, 0.5f, 0.5f, 0, 0.5f, 0.5f, 0, 0, 0, -0.7f, 0, 0, -0.7f, 0.5f, 0.5f, 0, 0.5f, 0.5f, 0)
			.setRotationPoint(29, -9, -21.9f).setRotationAngle(0, 0, 0).setName("Box 663")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 265, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, -0.8f, 0, 0, -0.8f, 0, 0, -0.8f, 0, -0.5f, -0.8f, 0)
			.setRotationPoint(30.5f, -2, 20.1f).setRotationAngle(0, 0, 0).setName("Box 666")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 305, 1, textureX, textureY)
			.addShapeBox(0, 0.8f, 0, 1, 1, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, -0.8f, 0, 0, -0.8f, 0, 0, -0.8f, 0, -0.5f, -0.8f, 0)
			.setRotationPoint(30.5f, -2, 20.1f).setRotationAngle(0, 0, 0).setName("Box 667")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 345, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, 0, 0, 0)
			.setRotationPoint(31.5f, -2, 20.1f).setRotationAngle(0, 0, 0).setName("Box 668")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 385, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, 0, 0, 0)
			.setRotationPoint(30.5f, -2, 20.1f).setRotationAngle(0, 0, -0.17453294f).setName("Box 669")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 441, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, 0, 0, 0)
			.setRotationPoint(30.1f, -2, 20.1f).setRotationAngle(0, 0, 0).setName("Box 670")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 465, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, -0.8f, 0, 0, -0.8f, 0, 0, -0.8f, 0, -0.5f, -0.8f, 0)
			.setRotationPoint(29.1f, -2, 20.1f).setRotationAngle(0, 0, 0).setName("Box 671")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, -0.8f, 0, 0, -0.8f, 0, 0, -0.8f, 0, -0.5f, -0.8f, 0)
			.setRotationPoint(29.1f, -1.6f, 20.1f).setRotationAngle(0, 0, 0).setName("Box 672")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 177, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, 0, 0, 0)
			.setRotationPoint(29, -2, 20.1f).setRotationAngle(0, 0, -0.17453294f).setName("Box 674")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 217, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, -0.5f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.5f, 0, 0, -0.5f, -0.8f, 0, 0.5f, -0.8f, 0, -0.3f, -0.8f, 0, -0.5f, -0.8f, 0)
			.setRotationPoint(29.1f, -1.8f, 20.1f).setRotationAngle(0, 0, 0).setName("Box 675")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 265, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, -0.5f, -0.4f, 0, 0, 0, 0, 0, 0, 0, -0.5f, -0.4f, 0, -0.5f, -0.4f, 0, 0, -0.8f, 0, 0, -0.8f, 0, -0.5f, -0.4f, 0)
			.setRotationPoint(29.1f, -1.6f, 20.1f).setRotationAngle(0, 0, 0).setName("Box 676")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 105, 321, textureX, textureY).addBox(-32, 1, -21, 64, 1, 42)
			.setRotationPoint(0, 1, 0).setRotationAngle(0, 0, 0).setName("Box 742")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 41, 353, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 13, 40, 0, 0, -0.1f, 0, -1, -0.5f, -2, -1, -0.5f, -2, 0, -0.1f, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0)
			.setRotationPoint(-29, -13, -20).setRotationAngle(0, 0, 0).setName("Box 703")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 1, textureX, textureY).addBox(-32, 1, -21, 64, 1, 40)
			.setRotationPoint(0, -1, 1).setRotationAngle(0, 0, 0).setName("Box 704")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 0, 0, textureX, textureY).addBox(-0.5f, -0.5f, 0, 1, 1, 2).setName("Box 705"));
		this.groups.add(chassis_core);
		//
		TurboList chassis_primary = new TurboList("chassis_primary");
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 97, 113, textureX, textureY).addBox(0, 0, 0, 3, 11, 42)
			.setRotationPoint(25, -10, -21).setRotationAngle(0, 0, 0).setName("Box 439")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 409, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 9, 2, 0, 0, 0, -2, 0, 0, 1, 0, 0, -1, 0, 0, 2, 0, 0, -4, 0, 0, -2, 0, 0, 2, 0, 0, 4)
			.setRotationPoint(45, -8, -14).setRotationAngle(0, 0, 0).setName("Box 444")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 441, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 9, 2, 0, 0, 0, 1, 0, 0, -2, 0, 0, 2, 0, 0, -1, 0, 0, -2, 0, 0, -4, 0, 0, 4, 0, 0, 2)
			.setRotationPoint(32, -8, -14).setRotationAngle(0, 0, 0).setName("Box 445")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 473, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 9, 2, 0, 0, 0, -1, 0, 0, 2, 0, 0, -2, 0, 0, 1, 0, 0, 2, 0, 0, 4, 0, 0, -4, 0, 0, -2)
			.setRotationPoint(32, -8, 12).setRotationAngle(0, 0, 0).setName("Box 446")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 9, 2, 0, 0, 0, 2, 0, 0, -1, 0, 0, 1, 0, 0, -2, 0, 0, 4, 0, 0, 2, 0, 0, -2, 0, 0, -4)
			.setRotationPoint(45, -8, 12).setRotationAngle(0, 0, 0).setName("Box 447")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 57, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 9, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2)
			.setRotationPoint(42, -8, -12).setRotationAngle(0, 0, 0).setName("Box 448")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 73, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 9, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(42, -8, 10).setRotationAngle(0, 0, 0).setName("Box 449")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 97, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 8, 12, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(55, -8, 9).setRotationAngle(0, 0, 0).setName("Box 457")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 153, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 8, 12, 0, 1, 0, 0, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 1, 0, 0, 0, 0, 0)
			.setRotationPoint(55, -8, -21).setRotationAngle(0, 0, 0).setName("Box 458")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 177, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 8, 0, 0.25f, 0, 0, -0.25f, 0, 0, -0.25f, 0, 0, 0.25f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(58, -2, -9).setRotationAngle(0, 0, 0).setName("Box 459")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 505, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 8, 2, 0, 1, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(58.2f, -8, -1).setRotationAngle(0, 0, 0).setName("Box 460")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 201, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 8, 0, 0.25f, 0, 0, -0.25f, 0, 0, -0.25f, 0, 0, 0.25f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(58, -2, 1).setRotationAngle(0, 0, 0).setName("Box 461")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 401, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 9, 3, 12, 0, 0, 1, 0, 0, -1, 0, -1, -1, -1, 1, 1, -1, 0, -2, 0, 1, 0, 0, 0, 0, 0, 1, -2, 0)
			.setRotationPoint(45, -11, 9).setRotationAngle(0, 0, 0).setName("Box 482")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 265, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 12, 0, 0, 0, 0, 0, -1, 0, -1, -1, -1, 1, 0, -1, -1, 0, 0, 1, 0, 0, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(54, -10, 9).setRotationAngle(0, 0, 0).setName("Box 484")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 201, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 16, 2, 12, 0, 0, 0, 0, 1, -1, 0, 0, -1, -1, 0, 0, -1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0)
			.setRotationPoint(28, -13, 9).setRotationAngle(0, 0, 0).setName("Box 485")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 305, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 12, 0, 1, 0, -1, -1, -1, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 1, 0, 0, -1, 0, 0)
			.setRotationPoint(54, -10, -21).setRotationAngle(0, 0, 0).setName("Box 486")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 65, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 9, 3, 12, 0, 1, 1, -1, -1, -1, -1, 0, -1, 0, 0, 1, 0, 1, -2, 0, 0, 0, 0, 1, 0, 0, 0, -2, 0)
			.setRotationPoint(45, -11, -21).setRotationAngle(0, 0, 0).setName("Box 487")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 97, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 16, 2, 12, 0, 0, 0, -1, 0, -1, -1, 1, -1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0)
			.setRotationPoint(28, -13, -21).setRotationAngle(0, 0, 0).setName("Box 488")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 137, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 2, 18, 0, 0, 0, 0, -1, -1, 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(54, -10, -9).setRotationAngle(0, 0, 0).setName("Box 489")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 241, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 9, 2, 18, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0)
			.setRotationPoint(45, -12, -9).setRotationAngle(0, 0, 0).setName("Box 490")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 401, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 17, 2, 18, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0)
			.setRotationPoint(28, -13, -9).setRotationAngle(0, 0, 0).setName("Box 491")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 57, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 5, 8, 0, 0, 0, 0, -1, -1, 0, -1, -1, 0, 0, 0, 0, -3.5f, -0.5f, 1, 0, -0.5f, 0, -0.5f, -0.5f, 0, -3.5f, -0.5f, 0)
			.setRotationPoint(49, -9, 13).setRotationAngle(0, 0, 0).setName("Box 494")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 369, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 5, 8, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, -2.5f, -0.5f, 1, -0.5f, -0.5f, 1, -0.5f, -0.5f, 0, -2.5f, -0.5f, 0)
			.setRotationPoint(52.5f, -4.5f, 13).setRotationAngle(0, 0, 0).setName("Box 495")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 193, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 5, 8, 0, 0, 0, 0, -1, -1, 0, -1, -1, 0, 0, 0, 0, -3.5f, -0.5f, 0, -0.5f, -0.5f, 0, 0, -0.5f, 0, -3.5f, -0.5f, 1)
			.setRotationPoint(49, -9, -21).setRotationAngle(0, 0, 0).setName("Box 496")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 409, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 5, 8, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -2.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 1, -2.5f, -0.5f, 1)
			.setRotationPoint(52.5f, -4.5f, -21).setRotationAngle(0, 0, 0).setName("Box 497")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 257, 169, textureX, textureY).addBox(0, 0, 0, 4, 11, 42)
			.setRotationPoint(28, -10, -21).setRotationAngle(0, 0, 0).setName("Box 498")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 241, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 5, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -6, 0, 0, -6, 0, 0, 0, 0, 0)
			.setRotationPoint(32, -10, 13).setRotationAngle(0, 0, 0).setName("Box 499")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 481, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 5, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -2, 0, 1, -2, 0, 0, 0, 0, 0)
			.setRotationPoint(32, -5, 13).setRotationAngle(0, 0, 0).setName("Box 500")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 361, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 5, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -6, 0, 0, -6, 0, 0, 0, 0, 0)
			.setRotationPoint(32, -10, -21).setRotationAngle(0, 0, 0).setName("Box 501")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 25, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 5, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 1, 0, 0, 1)
			.setRotationPoint(32, -5, -21).setRotationAngle(0, 0, 0).setName("Box 502")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 489, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 10, 8, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(-58, -10, 13).setRotationAngle(0, 0, 0).setName("Box 515")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 313, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 10, 8, 0, -1, 0, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 1, 0, 0)
			.setRotationPoint(-58, -10, -21).setRotationAngle(0, 0, 0).setName("Box 516")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 313, 185, textureX, textureY).addBox(0, 0, 0, 3, 11, 42)
			.setRotationPoint(-32, -10, -21).setRotationAngle(0, 0, 0).setName("Box 517")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 185, textureX, textureY).addBox(0, 0, 0, 23, 11, 1)
			.setRotationPoint(-55, -10, -14).setRotationAngle(0, 0, 0).setName("Box 518")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 89, 193, textureX, textureY).addBox(0, 0, 0, 23, 11, 1)
			.setRotationPoint(-55, -10, 13).setRotationAngle(0, 0, 0).setName("Box 519")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 145, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 22, 2, 8, 0, 0, 0, 0, 0, 1, 0, 0, 1, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-54, -12, 13).setRotationAngle(0, 0, 0).setName("Box 520")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 233, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 22, 2, 8, 0, 0, 0, -1, 0, 1, -1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-54, -12, -21).setRotationAngle(0, 0, 0).setName("Box 521")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 457, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 2, 8, 0, -1, 0, 0, 0, 0, 0, 0, 0, -1, -2, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1)
			.setRotationPoint(-58, -12, 13).setRotationAngle(0, 0, 0).setName("Box 522")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 369, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 2, 8, 0, -2, 0, -2, 0, 0, -1, 0, 0, 0, -1, 0, 0, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-58, -12, -21).setRotationAngle(0, 0, 0).setName("Box 523")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 25, 185, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 26, 0, -0.2f, 0, 0, 0, 0, 0, 0, 0, 0, -0.2f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-59, -2, -13).setRotationAngle(0, 0, 0).setName("Box 527")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 465, 185, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 5, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -6, 0, 0, 0, 0, 0, 0, 0, 0, -6, 0, 0)
			.setRotationPoint(-40, -10, 14).setRotationAngle(0, 0, 0).setName("Box 530")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 57, 185, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 6, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0)
			.setRotationPoint(-34, -5, 14).setRotationAngle(0, 0, 0).setName("Box 531")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 313, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 5, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, -6, 0, 0, -6, 0, 0, -0.5f, 0, 0)
			.setRotationPoint(-55, -10, 14).setRotationAngle(0, 0, 0).setName("Box 532")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 201, 185, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 6, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0)
			.setRotationPoint(-55, -5, 14).setRotationAngle(0, 0, 0).setName("Box 533")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 481, 201, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 5, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -6, 0, 0, 0, 0, 0, 0, 0, 0, -6, 0, 0)
			.setRotationPoint(-40, -10, -21).setRotationAngle(0, 0, 0).setName("Box 534")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 369, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 6, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0)
			.setRotationPoint(-34, -5, -21).setRotationAngle(0, 0, 0).setName("Box 535")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 177, 209, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 5, 7, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -6, 0, 0, -6, 0, 0, 0, 0, 0)
			.setRotationPoint(-55, -10, -21).setRotationAngle(0, 0, 0).setName("Box 536")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 425, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 6, 7, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0)
			.setRotationPoint(-55, -5, -21).setRotationAngle(0, 0, 0).setName("Box 537")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 25, 225, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 42, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-32, -13, -21).setRotationAngle(0, 0, 0).setName("Box 538")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 225, 225, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 42, 0, 0, 1, -1, 0, 0, -1, 0, 0, -1, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(25, -13, -21).setRotationAngle(0, 0, 0).setName("Box 539")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 225, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 10, 2, 0, 4, 0, 1, -4, 0, 1, -4, 0, -1, 4, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(25, -20, 19).setRotationAngle(0, 0, 0).setName("Box 540")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 241, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 10, 2, 0, 4, 0, -1, -4, 0, -1, -4, 0, 1, 4, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(25, -20, -21).setRotationAngle(0, 0, 0).setName("Box 541")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 265, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 7, 2, 0, 4, 0, 0, -4, 0, 0, -4, 0, 0, 4, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 1)
			.setRotationPoint(21, -27, 17).setRotationAngle(0, 0, 0).setName("Box 542")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 289, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 7, 2, 0, 4, 0, 0, -4, 0, 0, -4, 0, 0, 4, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(21, -27, -19).setRotationAngle(0, 0, 0).setName("Box 543")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 345, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 10, 2, 0, -4, 0, 1, 4, 0, 1, 4, 0, -1, -4, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-31, -20, 19).setRotationAngle(0, 0, 0).setName("Box 544")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 33, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 10, 2, 0, -4, 0, -1, 4, 0, -1, 4, 0, 1, -4, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-31, -20, -21).setRotationAngle(0, 0, 0).setName("Box 545")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 305, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 7, 2, 0, -4, 0, 0, 4, 0, 0, 4, 0, 0, -4, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 1)
			.setRotationPoint(-27, -27, 17).setRotationAngle(0, 0, 0).setName("Box 546")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 329, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 7, 2, 0, -4, 0, 0, 4, 0, 0, 4, 0, 0, -4, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(-27, -27, -19).setRotationAngle(0, 0, 0).setName("Box 547")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 409, 233, textureX, textureY)
			.addShapeBox(0, 0, 0, 42, 1, 2, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-23, -28, 17).setRotationAngle(0, 0, 0).setName("Box 548")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 81, 241, textureX, textureY)
			.addShapeBox(0, 0, 0, 42, 1, 2, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-23, -28, -19).setRotationAngle(0, 0, 0).setName("Box 549")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 137, 241, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 1, 34, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(9, -28, -17).setRotationAngle(0, 0, 0).setName("Box 550")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 289, 241, textureX, textureY)
			.addShapeBox(0, 0, 0, 20, 1, 34, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-23, -28, -17).setRotationAngle(0, 0, 0).setName("Box 551")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 57, 145, textureX, textureY).addBox(0, 0, 0, 12, 1, 7)
			.setRotationPoint(-3, -28, -17).setRotationAngle(0, 0, 0).setName("Box 552")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 97, 145, textureX, textureY).addBox(0, 0, 0, 12, 1, 7)
			.setRotationPoint(-3, -28, 10).setRotationAngle(0, 0, 0).setName("Box 553")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 369, 241, textureX, textureY).addBox(0, 0, 0, 11, 1, 19)
			.setRotationPoint(-2.5f, -28, -9.5f).setRotationAngle(0, 0, 0).setName("Box 558")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 497, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 7, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 1)
			.setRotationPoint(-2.5f, -27, 18).setRotationAngle(0, 0, 0).setName("Box 565")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 409, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 1)
			.setRotationPoint(-2.5f, -20, 19).setRotationAngle(0, 0, 0).setName("Box 566")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 25, 129, textureX, textureY).addBox(0, 0, 0, 1, 10, 1)
			.setRotationPoint(-2.5f, -10, 20).setRotationAngle(0, 0, 0).setName("Box 567")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 433, 129, textureX, textureY).addBox(0, 0, 0, 1, 10, 1)
			.setRotationPoint(-2.5f, -10, -21).setRotationAngle(0, 0, 0).setName("Box 568")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 441, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(-2.5f, -20, -20).setRotationAngle(0, 0, 0).setName("Box 569")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 505, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 7, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(-2.5f, -27, -19).setRotationAngle(0, 0, 0).setName("Box 570")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 369, 265, textureX, textureY).addBox(0, 0, 0, 54, 1, 1)
			.setRotationPoint(-29, 0, 20).setRotationAngle(0, 0, 0).setName("Box 567")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 273, textureX, textureY).addBox(0, 0, 0, 54, 1, 1)
			.setRotationPoint(-29, 0, -21).setRotationAngle(0, 0, 0).setName("Box 568")
		);
		chassis_primary.addProgram(DefaultPrograms.RGB_PRIMARY);
		this.groups.add(chassis_primary);
		//
		TurboList doors_closed = new TurboList("doors_closed");
		doors_closed.add(new ModelRendererTurbo(doors_closed, 105, 209, textureX, textureY)
			.addShapeBox(-22, 0, -13, 22, 2, 26, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(-32, -12, 0).setRotationAngle(0, 0, 0).setName("Box 526")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 209, 209, textureX, textureY)
			.addShapeBox(-26, 2, -13, 2, 8, 26, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.8f, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, 0.8f, 0, 0)
			.setRotationPoint(-32, -12, 0).setRotationAngle(0, 0, 0).setName("Box 528")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 1, 217, textureX, textureY)
			.addShapeBox(-26, 0, -13, 4, 2, 26, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-32, -12, 0).setRotationAngle(0, 0, 0).setName("Box 529")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 417, 241, textureX, textureY)
			.addShapeBox(-27, 0, -0.5f, 27, 10, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0)
			.setRotationPoint(25, -10, 20.5f).setRotationAngle(0, 0, 0).setName("Box 569")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 1, 249, textureX, textureY)
			.addShapeBox(-27, 0, -0.5f, 27, 10, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0)
			.setRotationPoint(-2.5f, -10, 20.5f).setRotationAngle(0, 0, 0).setName("Box 570")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 81, 249, textureX, textureY)
			.addShapeBox(-27, 0, -0.5f, 27, 10, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0)
			.setRotationPoint(25, -10, -20.5f).setRotationAngle(0, 0, 0).setName("Box 571")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 193, 249, textureX, textureY)
			.addShapeBox(-27, 0, -0.5f, 27, 10, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0)
			.setRotationPoint(-2.5f, -10, -20.5f).setRotationAngle(0, 0, 0).setName("Box 572")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 433, 257, textureX, textureY)
			.addShapeBox(-27, -2, -0.5f, 27, 2, 1, 0, -0.5f, 0.5f, 0.25f, -1, 0.5f, 0.25f, -1, 0.5f, -0.25f, -0.5f, 0.5f, -0.25f, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0)
			.setRotationPoint(25, -10, 20.5f).setRotationAngle(0, 0, 0).setName("Box 573")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 401, 273, textureX, textureY)
			.addShapeBox(-26.5f, -2, -0.5f, 27, 2, 1, 0, -1, 0.5f, 0.25f, -0.5f, 0.5f, 0.25f, -0.5f, 0.5f, -0.25f, -1, 0.5f, -0.25f, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(-2.5f, -10, 20.5f).setRotationAngle(0, 0, 0).setName("Box 577")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 1, 281, textureX, textureY)
			.addShapeBox(-26.5f, -2, -0.5f, 27, 2, 1, 0, -1, 0.5f, -0.25f, -0.5f, 0.5f, -0.25f, -0.5f, 0.5f, 0.25f, -1, 0.5f, 0.25f, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(-2.5f, -10, -20.5f).setRotationAngle(0, 0, 0).setName("Box 578")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 65, 281, textureX, textureY)
			.addShapeBox(-27, -2, -0.5f, 27, 2, 1, 0, -0.5f, 0.5f, -0.25f, -1, 0.5f, -0.25f, -1, 0.5f, 0.25f, -0.5f, 0.5f, 0.25f, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0)
			.setRotationPoint(25, -10, -20.5f).setRotationAngle(0, 0, 0).setName("Box 579")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 473, 121, textureX, textureY)
			.addShapeBox(-5, -10, -1.5f, 1, 8, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, -0.5f, -0.75f, 3, -0.5f, -0.75f, 3, -0.5f, 0.75f, -3, -0.5f, 0.75f)
			.setRotationPoint(25, -10, 20.5f).setRotationAngle(0, 0, 0).setName("Box 580")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 481, 121, textureX, textureY)
			.addShapeBox(-5, -10, 0.5f, 1, 8, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, -0.5f, 0.75f, 3, -0.5f, 0.75f, 3, -0.5f, -0.75f, -3, -0.5f, -0.75f)
			.setRotationPoint(25, -10, -20.5f).setRotationAngle(0, 0, 0).setName("Box 581")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 369, 129, textureX, textureY)
			.addShapeBox(-22.5f, -10, 0.5f, 1, 8, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, -0.5f, 0.75f, -3, -0.5f, 0.75f, -3, -0.5f, -0.75f, 3, -0.5f, -0.75f)
			.setRotationPoint(-2.5f, -10, -20.5f).setRotationAngle(0, 0, 0).setName("Box 583")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 377, 129, textureX, textureY)
			.addShapeBox(-22.5f, -10, -1.5f, 1, 8, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, -0.5f, -0.75f, -3, -0.5f, -0.75f, -3, -0.5f, 0.75f, 3, -0.5f, 0.75f)
			.setRotationPoint(-2.5f, -10, 20.5f).setRotationAngle(0, 0, 0).setName("Box 584")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 33, 137, textureX, textureY)
			.addShapeBox(-26.5f, -10, -1.5f, 1, 8, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, -0.75f, 0, -0.5f, -0.75f, 0, -0.5f, 0.75f, 0, -0.5f, 0.75f)
			.setRotationPoint(25, -10, 20.5f).setRotationAngle(0, 0, 0).setName("Box 585")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 129, 137, textureX, textureY)
			.addShapeBox(-1, -10, -1.5f, 1, 8, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, -0.75f, 0, -0.5f, -0.75f, 0, -0.5f, 0.75f, 0, -0.5f, 0.75f)
			.setRotationPoint(-2.5f, -10, 20.5f).setRotationAngle(0, 0, 0).setName("Box 586")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 289, 137, textureX, textureY)
			.addShapeBox(-1, -10, 0.5f, 1, 8, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0.75f, 0, -0.5f, 0.75f, 0, -0.5f, -0.75f, 0, -0.5f, -0.75f)
			.setRotationPoint(-2.5f, -10, -20.5f).setRotationAngle(0, 0, 0).setName("Box 587")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 297, 137, textureX, textureY)
			.addShapeBox(-26.5f, -10, 0.5f, 1, 8, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0.75f, 0, -0.5f, 0.75f, 0, -0.5f, -0.75f, 0, -0.5f, -0.75f)
			.setRotationPoint(25, -10, -20.5f).setRotationAngle(0, 0, 0).setName("Box 588")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 313, 137, textureX, textureY)
			.addShapeBox(-26.5f, -17, -2.5f, 1, 7, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 1)
			.setRotationPoint(25, -10, 20.5f).setRotationAngle(0, 0, 0).setName("Box 589")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 321, 137, textureX, textureY)
			.addShapeBox(-26.5f, -17, 1.5f, 1, 7, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(25, -10, -20.5f).setRotationAngle(0, 0, 0).setName("Box 590")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 337, 137, textureX, textureY)
			.addShapeBox(-1, -17, 1.5f, 1, 7, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(-2.5f, -10, -20.5f).setRotationAngle(0, 0, 0).setName("Box 591")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 457, 137, textureX, textureY)
			.addShapeBox(-1, -17, -2.5f, 1, 7, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 1)
			.setRotationPoint(-2.5f, -10, 20.5f).setRotationAngle(0, 0, 0).setName("Box 592")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 465, 137, textureX, textureY)
			.addShapeBox(-9, -17, -2.5f, 1, 7, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, -1, 4, 0, -1, 4, 0, 1, -4, 0, 1)
			.setRotationPoint(25, -10, 20.5f).setRotationAngle(0, 0, 0).setName("Box 593")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 153, 145, textureX, textureY)
			.addShapeBox(-9, -17, 1.5f, 1, 7, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 1, 4, 0, 1, 4, 0, -1, -4, 0, -1)
			.setRotationPoint(25, -10, -20.5f).setRotationAngle(0, 0, 0).setName("Box 594")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 161, 145, textureX, textureY)
			.addShapeBox(-18.5f, -17, 1.5f, 1, 7, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 1, -4, 0, 1, -4, 0, -1, 4, 0, -1)
			.setRotationPoint(-2.5f, -10, -20.5f).setRotationAngle(0, 0, 0).setName("Box 595")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 209, 145, textureX, textureY)
			.addShapeBox(-18.5f, -17, -2.5f, 1, 7, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, -1, -4, 0, -1, -4, 0, 1, 4, 0, 1)
			.setRotationPoint(-2.5f, -10, 20.5f).setRotationAngle(0, 0, 0).setName("Box 596")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 337, 177, textureX, textureY)
			.addShapeBox(-25.5f, -17, -2.5f, 17, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.14285715f, 0, 0, -0.14285715f, 0, 0, 0.14285715f, 0, 0, 0.14285715f)
			.setRotationPoint(25, -10, 20.5f).setRotationAngle(0, 0, 0).setName("Box 597")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 89, 185, textureX, textureY)
			.addShapeBox(-25.5f, -17, 1.5f, 17, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.14285715f, 0, 0, 0.14285715f, 0, 0, -0.14285715f, 0, 0, -0.14285715f)
			.setRotationPoint(25, -10, -20.5f).setRotationAngle(0, 0, 0).setName("Box 599")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 1, 201, textureX, textureY)
			.addShapeBox(-18, -17, 1.5f, 17, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.14285715f, 0, 0, 0.14285715f, 0, 0, -0.14285715f, 0, 0, -0.14285715f)
			.setRotationPoint(-2.5f, -10, -20.5f).setRotationAngle(0, 0, 0).setName("Box 600")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 89, 209, textureX, textureY)
			.addShapeBox(-18, -17, -2.5f, 17, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.14285715f, 0, 0, -0.14285715f, 0, 0, 0.14285715f, 0, 0, 0.14285715f)
			.setRotationPoint(-2.5f, -10, 20.5f).setRotationAngle(0, 0, 0).setName("Box 601")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 265, 49, textureX, textureY)
			.addShapeBox(-24, 0, -0.1f, 3, 1, 1, 0, 0.2f, 0, 0, 0, 0, 0, 0, 0, -0.2f, 0.2f, 0, -0.2f, 0, 0, 0.4f, 0, 0, 0.4f, 0.4f, 0, 0, 0.4f, 0, 0)
			.setRotationPoint(25, -10, 20.5f).setRotationAngle(0, 0, 0).setName("Box 602")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 281, 49, textureX, textureY)
			.addShapeBox(-24, 0, -0.9f, 3, 1, 1, 0, 0.2f, 0, -0.2f, 0, 0, -0.2f, 0, 0, 0, 0.2f, 0, 0, 0.4f, 0, 0, 0.4f, 0, 0, 0, 0, 0.4f, 0, 0, 0.4f)
			.setRotationPoint(25, -10, -20.5f).setRotationAngle(0, 0, 0).setName("Box 603")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 425, 57, textureX, textureY)
			.addShapeBox(-21, 0, -0.9f, 3, 1, 1, 0, 0.2f, 0, -0.2f, 0, 0, -0.2f, 0, 0, 0, 0.2f, 0, 0, 0.4f, 0, 0, 0.4f, 0, 0, 0, 0, 0.4f, 0, 0, 0.4f)
			.setRotationPoint(-2.5f, -10, -20.5f).setRotationAngle(0, 0, 0).setName("Box 604")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 441, 57, textureX, textureY)
			.addShapeBox(-21, 0, -0.1f, 3, 1, 1, 0, 0.2f, 0, 0, 0, 0, 0, 0, 0, -0.2f, 0.2f, 0, -0.2f, 0, 0, 0.4f, 0, 0, 0.4f, 0.4f, 0, 0, 0.4f, 0, 0)
			.setRotationPoint(-2.5f, -10, 20.5f).setRotationAngle(0, 0, 0).setName("Box 605")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 457, 57, textureX, textureY)
			.addShapeBox(-12.5f, 0, -1, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(25, -10, 20.5f).setRotationAngle(0, 0, 0).setName("Box 606")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 161, 89, textureX, textureY)
			.addShapeBox(-12.5f, 0, 0, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(25, -10, -20.5f).setRotationAngle(0, 0, 0).setName("Box 607")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 177, 89, textureX, textureY)
			.addShapeBox(-7.5f, 0, 0, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-2.5f, -10, -20.5f).setRotationAngle(0, 0, 0).setName("Box 608")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 193, 89, textureX, textureY)
			.addShapeBox(-7.5f, 0, -1, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-2.5f, -10, 20.5f).setRotationAngle(0, 0, 0).setName("Box 609")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 1, 17, textureX, textureY)
			.addShapeBox(-26.5f, 4, -7, 1, 1, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, 0.2f, 0, 0)
			.setRotationPoint(-32, -12, 0).setRotationAngle(0, 0, 0).setName("Box 649")
		);
		doors_closed.add(new ModelRendererTurbo(doors_closed, 1, 209, textureX, textureY)
			.addShapeBox(-26.5f, 5, -6, 1, 3, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.3f, 0, 0)
			.setRotationPoint(-32, -12, 0).setRotationAngle(0, 0, 0).setName("Box 650")
		);
		doors_closed.addPrograms(DefaultPrograms.RGB_PRIMARY, DefaultPrograms.DOOR_CLOSE);
		this.groups.add(doors_closed);
		//
		TurboList doors_open = new TurboList("doors_open");
		doors_open.add(new ModelRendererTurbo(doors_open, 129, 281, textureX, textureY)
			.addShapeBox(-27, 0, -0.5f, 27, 10, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0)
			.setRotationPoint(25, -10, 20.5f).setRotationAngle(0, 1.0471976f, 0).setName("Box 610")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 193, 281, textureX, textureY)
			.addShapeBox(-27, -2, -0.5f, 27, 2, 1, 0, -0.5f, 0.5f, 0.25f, -1, 0.5f, 0.25f, -1, 0.5f, -0.25f, -0.5f, 0.5f, -0.25f, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0)
			.setRotationPoint(25, -10, 20.5f).setRotationAngle(0, 1.0471976f, 0).setName("Box 611")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 217, 145, textureX, textureY)
			.addShapeBox(-5, -10, -1.5f, 1, 8, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, -0.5f, -0.75f, 3, -0.5f, -0.75f, 3, -0.5f, 0.75f, -3, -0.5f, 0.75f)
			.setRotationPoint(25, -10, 20.5f).setRotationAngle(0, 1.0471976f, 0).setName("Box 612")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 225, 145, textureX, textureY)
			.addShapeBox(-9, -17, -2.5f, 1, 7, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, -1, 4, 0, -1, 4, 0, 1, -4, 0, 1)
			.setRotationPoint(25, -10, 20.5f).setRotationAngle(0, 1.0471976f, 0).setName("Box 613")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 81, 225, textureX, textureY)
			.addShapeBox(-25.5f, -17, -2.5f, 17, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.14285715f, 0, 0, -0.14285715f, 0, 0, 0.14285715f, 0, 0, 0.14285715f)
			.setRotationPoint(25, -10, 20.5f).setRotationAngle(0, 1.0471976f, 0).setName("Box 614")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 345, 145, textureX, textureY)
			.addShapeBox(-26.5f, -17, -2.5f, 1, 7, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 1)
			.setRotationPoint(25, -10, 20.5f).setRotationAngle(0, 1.0471976f, 0).setName("Box 615")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 505, 145, textureX, textureY)
			.addShapeBox(-26.5f, -10, -1.5f, 1, 8, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, -0.75f, 0, -0.5f, -0.75f, 0, -0.5f, 0.75f, 0, -0.5f, 0.75f)
			.setRotationPoint(25, -10, 20.5f).setRotationAngle(0, 1.0471976f, 0).setName("Box 616")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 145, 97, textureX, textureY)
			.addShapeBox(-24, 0, -0.1f, 3, 1, 1, 0, 0.2f, 0, 0, 0, 0, 0, 0, 0, -0.2f, 0.2f, 0, -0.2f, 0, 0, 0.4f, 0, 0, 0.4f, 0.4f, 0, 0, 0.4f, 0, 0)
			.setRotationPoint(25, -10, 20.5f).setRotationAngle(0, 1.0471976f, 0).setName("Box 617")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 177, 97, textureX, textureY)
			.addShapeBox(-12.5f, 0, -1, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(25, -10, 20.5f).setRotationAngle(0, 1.0471976f, 0).setName("Box 618")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 257, 281, textureX, textureY)
			.addShapeBox(-27, 0, -0.5f, 27, 10, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0)
			.setRotationPoint(25, -10, -20.5f).setRotationAngle(0, -1.0471976f, 0).setName("Box 619")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 321, 281, textureX, textureY)
			.addShapeBox(-27, -2, -0.5f, 27, 2, 1, 0, -0.5f, 0.5f, -0.25f, -1, 0.5f, -0.25f, -1, 0.5f, 0.25f, -0.5f, 0.5f, 0.25f, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0)
			.setRotationPoint(25, -10, -20.5f).setRotationAngle(0, -1.0471976f, 0).setName("Box 620")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 337, 153, textureX, textureY)
			.addShapeBox(-5, -10, 0.5f, 1, 8, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, -0.5f, 0.75f, 3, -0.5f, 0.75f, 3, -0.5f, -0.75f, -3, -0.5f, -0.75f)
			.setRotationPoint(25, -10, -20.5f).setRotationAngle(0, -1.0471976f, 0).setName("Box 621")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 401, 153, textureX, textureY)
			.addShapeBox(-9, -17, 1.5f, 1, 7, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 1, 4, 0, 1, 4, 0, -1, -4, 0, -1)
			.setRotationPoint(25, -10, -20.5f).setRotationAngle(0, -1.0471976f, 0).setName("Box 622")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 409, 225, textureX, textureY)
			.addShapeBox(-25.5f, -17, 1.5f, 17, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.14285715f, 0, 0, 0.14285715f, 0, 0, -0.14285715f, 0, 0, -0.14285715f)
			.setRotationPoint(25, -10, -20.5f).setRotationAngle(0, -1.0471976f, 0).setName("Box 623")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 1, 161, textureX, textureY)
			.addShapeBox(-26.5f, -10, 0.5f, 1, 8, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0.75f, 0, -0.5f, 0.75f, 0, -0.5f, -0.75f, 0, -0.5f, -0.75f)
			.setRotationPoint(25, -10, -20.5f).setRotationAngle(0, -1.0471976f, 0).setName("Box 624")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 9, 161, textureX, textureY)
			.addShapeBox(-26.5f, -17, 1.5f, 1, 7, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(25, -10, -20.5f).setRotationAngle(0, -1.0471976f, 0).setName("Box 625")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 209, 97, textureX, textureY)
			.addShapeBox(-24, 0, -0.9f, 3, 1, 1, 0, 0.2f, 0, -0.2f, 0, 0, -0.2f, 0, 0, 0, 0.2f, 0, 0, 0.4f, 0, 0, 0.4f, 0, 0, 0, 0, 0.4f, 0, 0, 0.4f)
			.setRotationPoint(25, -10, -20.5f).setRotationAngle(0, -1.0471976f, 0).setName("Box 626")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 361, 113, textureX, textureY)
			.addShapeBox(-12.5f, 0, 0, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(25, -10, -20.5f).setRotationAngle(0, -1.0471976f, 0).setName("Box 627")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 385, 281, textureX, textureY)
			.addShapeBox(-27, 0, -0.5f, 27, 10, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0)
			.setRotationPoint(-2.5f, -10, 20.5f).setRotationAngle(0, 1.0471976f, 0).setName("Box 628")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 449, 281, textureX, textureY)
			.addShapeBox(-26.5f, -2, -0.5f, 27, 2, 1, 0, -1, 0.5f, 0.25f, -0.5f, 0.5f, 0.25f, -0.5f, 0.5f, -0.25f, -1, 0.5f, -0.25f, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(-2.5f, -10, 20.5f).setRotationAngle(0, 1.0471976f, 0).setName("Box 629")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 49, 161, textureX, textureY)
			.addShapeBox(-1, -10, -1.5f, 1, 8, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, -0.75f, 0, -0.5f, -0.75f, 0, -0.5f, 0.75f, 0, -0.5f, 0.75f)
			.setRotationPoint(-2.5f, -10, 20.5f).setRotationAngle(0, 1.0471976f, 0).setName("Box 630")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 65, 161, textureX, textureY)
			.addShapeBox(-1, -17, -2.5f, 1, 7, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 1)
			.setRotationPoint(-2.5f, -10, 20.5f).setRotationAngle(0, 1.0471976f, 0).setName("Box 631")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 281, 249, textureX, textureY)
			.addShapeBox(-18, -17, -2.5f, 17, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.14285715f, 0, 0, -0.14285715f, 0, 0, 0.14285715f, 0, 0, 0.14285715f)
			.setRotationPoint(-2.5f, -10, 20.5f).setRotationAngle(0, 1.0471976f, 0).setName("Box 632")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 201, 161, textureX, textureY)
			.addShapeBox(-18.5f, -17, -2.5f, 1, 7, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, -1, -4, 0, -1, -4, 0, 1, 4, 0, 1)
			.setRotationPoint(-2.5f, -10, 20.5f).setRotationAngle(0, 1.0471976f, 0).setName("Box 633")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 249, 161, textureX, textureY)
			.addShapeBox(-22.5f, -10, -1.5f, 1, 8, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, -0.5f, -0.75f, -3, -0.5f, -0.75f, -3, -0.5f, 0.75f, 3, -0.5f, 0.75f)
			.setRotationPoint(-2.5f, -10, 20.5f).setRotationAngle(0, 1.0471976f, 0).setName("Box 634")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 385, 113, textureX, textureY)
			.addShapeBox(-21, 0, -0.1f, 3, 1, 1, 0, 0.2f, 0, 0, 0, 0, 0, 0, 0, -0.2f, 0.2f, 0, -0.2f, 0, 0, 0.4f, 0, 0, 0.4f, 0.4f, 0, 0, 0.4f, 0, 0)
			.setRotationPoint(-2.5f, -10, 20.5f).setRotationAngle(0, 1.0471976f, 0).setName("Box 635")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 97, 121, textureX, textureY)
			.addShapeBox(-7.5f, 0, -1, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-2.5f, -10, 20.5f).setRotationAngle(0, 1.0471976f, 0).setName("Box 636")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 1, 289, textureX, textureY)
			.addShapeBox(-27, 0, -0.5f, 27, 10, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0)
			.setRotationPoint(-2.5f, -10, -20.5f).setRotationAngle(0, -1.0471976f, 0).setName("Box 637")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 65, 289, textureX, textureY)
			.addShapeBox(-26.5f, -2, -0.5f, 27, 2, 1, 0, -1, 0.5f, -0.25f, -0.5f, 0.5f, -0.25f, -0.5f, 0.5f, 0.25f, -1, 0.5f, 0.25f, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(-2.5f, -10, -20.5f).setRotationAngle(0, -1.0471976f, 0).setName("Box 638")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 145, 169, textureX, textureY)
			.addShapeBox(-1, -10, 0.5f, 1, 8, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0.75f, 0, -0.5f, 0.75f, 0, -0.5f, -0.75f, 0, -0.5f, -0.75f)
			.setRotationPoint(-2.5f, -10, -20.5f).setRotationAngle(0, -1.0471976f, 0).setName("Box 639")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 169, 169, textureX, textureY)
			.addShapeBox(-1, -17, 1.5f, 1, 7, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(-2.5f, -10, -20.5f).setRotationAngle(0, -1.0471976f, 0).setName("Box 640")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 281, 257, textureX, textureY)
			.addShapeBox(-18, -17, 1.5f, 17, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.14285715f, 0, 0, 0.14285715f, 0, 0, -0.14285715f, 0, 0, -0.14285715f)
			.setRotationPoint(-2.5f, -10, -20.5f).setRotationAngle(0, -1.0471976f, 0).setName("Box 641")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 177, 169, textureX, textureY)
			.addShapeBox(-18.5f, -17, 1.5f, 1, 7, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 1, -4, 0, 1, -4, 0, -1, 4, 0, -1)
			.setRotationPoint(-2.5f, -10, -20.5f).setRotationAngle(0, -1.0471976f, 0).setName("Box 642")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 185, 169, textureX, textureY)
			.addShapeBox(-22.5f, -10, 0.5f, 1, 8, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, -0.5f, 0.75f, -3, -0.5f, 0.75f, -3, -0.5f, -0.75f, 3, -0.5f, -0.75f)
			.setRotationPoint(-2.5f, -10, -20.5f).setRotationAngle(0, -1.0471976f, 0).setName("Box 643")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 153, 121, textureX, textureY)
			.addShapeBox(-21, 0, -0.9f, 3, 1, 1, 0, 0.2f, 0, -0.2f, 0, 0, -0.2f, 0, 0, 0, 0.2f, 0, 0, 0.4f, 0, 0, 0.4f, 0, 0, 0, 0, 0.4f, 0, 0, 0.4f)
			.setRotationPoint(-2.5f, -10, -20.5f).setRotationAngle(0, -1.0471976f, 0).setName("Box 644")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 273, 137, textureX, textureY)
			.addShapeBox(-7.5f, 0, 0, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-2.5f, -10, -20.5f).setRotationAngle(0, -1.0471976f, 0).setName("Box 645")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 161, 289, textureX, textureY)
			.addShapeBox(-22, 0, -13, 22, 2, 26, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(-32, -12, 0).setRotationAngle(0, 0, 1.0471976f).setName("Box 646")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 289, 289, textureX, textureY)
			.addShapeBox(-26, 0, -13, 4, 2, 26, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-32, -12, 0).setRotationAngle(0, 0, 1.0471976f).setName("Box 647")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 97, 273, textureX, textureY)
			.addShapeBox(-26, 2, -13, 2, 8, 26, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.8f, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, 0.8f, 0, 0)
			.setRotationPoint(-32, -12, 0).setRotationAngle(0, 0, 1.0471976f).setName("Box 648")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 201, 49, textureX, textureY)
			.addShapeBox(-26.5f, 4, -7, 1, 1, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, 0.2f, 0, 0)
			.setRotationPoint(-32, -12, 0).setRotationAngle(0, 0, 1.0471976f).setName("Box 652")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 241, 217, textureX, textureY)
			.addShapeBox(-26.5f, 5, -6, 1, 3, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.3f, 0, 0)
			.setRotationPoint(-32, -12, 0).setRotationAngle(0, 0, 1.0471976f).setName("Box 653")
		);
		doors_open.addPrograms(DefaultPrograms.RGB_PRIMARY, DefaultPrograms.DOOR_OPEN);
		this.groups.add(doors_open);
	}

}