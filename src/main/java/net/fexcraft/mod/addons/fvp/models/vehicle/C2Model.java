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
@fModel(registryname = "fvp:models/vehicle/c2")
public class C2Model extends VehicleModel {

	public C2Model(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList chassis_core = new TurboList("chassis_core");
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 1, textureX, textureY).addBox(0, 0, 0, 64, 5, 48)
			.setRotationPoint(-47, -12, -24).setRotationAngle(0, 0, 0).setName("Box 0")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 233, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 5, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0)
			.setRotationPoint(17, -12, -25).setRotationAngle(0, 0, 0).setName("Box 1")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 337, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 5, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0)
			.setRotationPoint(38, -12, -25).setRotationAngle(0, 0, 0).setName("Box 7")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 113, textureX, textureY).addBox(0, 0, 0, 21, 10, 36)
			.setRotationPoint(19, -17, -18).setRotationAngle(0, 0, 0).setName("Box 8")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 185, 1, textureX, textureY).addBox(0, 0, 0, 3, 3, 44)
			.setRotationPoint(28, -9, -22).setRotationAngle(0, 0, 0).setName("Box 9")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 73, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 5, 50, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, -1, -1, 0, -1, -1, 0, 0, 0)
			.setRotationPoint(42, -12, -25).setRotationAngle(0, 0, 0).setName("Box 11")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 185, 1, textureX, textureY).addBox(0, 0, 0, 1, 3, 16)
			.setRotationPoint(-83.2f, -11.5f, -8).setRotationAngle(0, 0, 0).setName("license plate rear")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 409, 137, textureX, textureY).addBox(0, 0, 0, 1, 4, 44)
			.setRotationPoint(17, -23, -22).setRotationAngle(0, 0, 0).setName("Box 25")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 113, 169, textureX, textureY).addBox(0, 0, 0, 64, 5, 1)
			.setRotationPoint(-47, -12, 24).setRotationAngle(0, 0, 0).setName("Box 31")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 113, 177, textureX, textureY).addBox(0, 0, 0, 64, 5, 1)
			.setRotationPoint(-47, -12, -25).setRotationAngle(0, 0, 0).setName("Box 32")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 241, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 5, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0)
			.setRotationPoint(-51, -12, -25).setRotationAngle(0, 0, 0).setName("Box 33")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 297, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 5, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0)
			.setRotationPoint(-51, -12, 18).setRotationAngle(0, 0, 0).setName("Box 35")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 289, 57, textureX, textureY).addBox(0, 0, 0, 25, 5, 1)
			.setRotationPoint(-72, -12, 17).setRotationAngle(0, 0, 0).setName("Box 36")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 345, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 5, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0)
			.setRotationPoint(-72, -12, 18).setRotationAngle(0, 0, 0).setName("Box 37")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 289, 65, textureX, textureY).addBox(0, 0, 0, 25, 5, 1)
			.setRotationPoint(-72, -12, -18).setRotationAngle(0, 0, 0).setName("Box 38")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 369, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 5, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0)
			.setRotationPoint(-72, -12, -25).setRotationAngle(0, 0, 0).setName("Box 39")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 217, 169, textureX, textureY).addBox(0, 0, 0, 25, 5, 34)
			.setRotationPoint(-72, -12, -17).setRotationAngle(0, 0, 0).setName("Box 40")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 137, 113, textureX, textureY).addBox(0, 0, 0, 3, 3, 44)
			.setRotationPoint(-61, -9, -22).setRotationAngle(0, 0, 0).setName("Box 41")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 289, 177, textureX, textureY).addBox(0, 0, 0, 7, 5, 50)
			.setRotationPoint(-79, -12, -25).setRotationAngle(0, 0, 0).setName("Box 52")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 113, 185, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 5, 50, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, -1, -1)
			.setRotationPoint(-83, -12, -25).setRotationAngle(0, 0, 0).setName("Box 74")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 401, 81, textureX, textureY).addBox(0, 0, 0, 1, 3, 16)
			.setRotationPoint(45.2f, -11.5f, -8).setRotationAngle(0, 0, 0).setName("license plate front")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 465, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(-82, -8, -14).setRotationAngle(0, 0, 0).setName("Box 102")
		);
		this.groups.add(chassis_core);
		//
		TurboList chassis_primary = new TurboList("chassis_primary");
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 345, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 7, 48, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, -4, 0, 0, 0, 0)
			.setRotationPoint(21, -19, -24).setRotationAngle(0, 0, 0).setName("Box 2")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 3, 48, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(25, -19, -24).setRotationAngle(0, 0, 0).setName("Box 3")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 409, 9, textureX, textureY).addBox(0, 0, 0, 1, 2, 48)
			.setRotationPoint(29, -19, -24).setRotationAngle(0, 0, 0).setName("Box 4")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 113, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 3, 48, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(30, -19, -24).setRotationAngle(0, 0, 0).setName("Box 5")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 225, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 7, 48, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0)
			.setRotationPoint(34, -19, -24).setRotationAngle(0, 0, 0).setName("Box 6")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 401, 65, textureX, textureY).addBox(0, 0, 0, 4, 7, 48)
			.setRotationPoint(38, -19, -24).setRotationAngle(0, 0, 0).setName("Box 10")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 185, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 7, 48, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(42, -19, -24).setRotationAngle(0, 0, 0).setName("Box 12")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 17, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(42, -22, 22).setRotationAngle(0, 0, 0).setName("Box 16")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 297, 1, textureX, textureY).addBox(0, 0, 0, 5, 3, 32)
			.setRotationPoint(40, -22, -16).setRotationAngle(0, 0, 0).setName("Box 17")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 289, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 48, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(42, -23, -24).setRotationAngle(0, 0, 0).setName("Box 18")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 185, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 2, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(42, -22, -24).setRotationAngle(0, 0, 0).setName("Box 19")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 409, 1, textureX, textureY).addBox(0, 0, 0, 25, 4, 2)
			.setRotationPoint(17, -23, 22).setRotationAngle(0, 0, 0).setName("Box 20")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 345, 121, textureX, textureY).addBox(0, 0, 0, 4, 7, 48)
			.setRotationPoint(17, -19, -24).setRotationAngle(0, 0, 0).setName("Box 21")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 297, 41, textureX, textureY).addBox(0, 0, 0, 25, 4, 2)
			.setRotationPoint(17, -23, -24).setRotationAngle(0, 0, 0).setName("Box 22")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 65, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 25, 2, 12, 0, 0, 0, 0, 0, -1, 0, 0, -1, -1, 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(17, -25, 12).setRotationAngle(0, 0, 0).setName("Box 24")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 177, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 25, 2, 12, 0, 0, -1, -1, 0, -1, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(17, -25, -24).setRotationAngle(0, 0, 0).setName("Box 26")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 27, 2, 24, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(15, -25, -12).setRotationAngle(0, 0, 0).setName("Box 27")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 57, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 48, 0, 0, 0, -1, -1, 0, -1, -1, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(42, -24, -24).setRotationAngle(0, 0, 0).setName("Box 28")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 465, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 7, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0)
			.setRotationPoint(-55, -19, 18).setRotationAngle(0, 0, 0).setName("Box 42")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 489, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 7, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0)
			.setRotationPoint(-55, -19, -24).setRotationAngle(0, 0, 0).setName("Box 43")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 409, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 7, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, -4, 0, 0, 0, 0)
			.setRotationPoint(-68, -19, 18).setRotationAngle(0, 0, 0).setName("Box 44")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 433, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 7, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, -4, 0, 0, 0, 0)
			.setRotationPoint(-68, -19, -24).setRotationAngle(0, 0, 0).setName("Box 45")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 3, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(-59, -19, 18).setRotationAngle(0, 0, 0).setName("Box 46")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 25, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 3, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(-59, -19, -24).setRotationAngle(0, 0, 0).setName("Box 47")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 241, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 3, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(-64, -19, 18).setRotationAngle(0, 0, 0).setName("Box 48")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 297, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 3, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(-64, -19, -24).setRotationAngle(0, 0, 0).setName("Box 49")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 265, 1, textureX, textureY).addBox(0, 0, 0, 1, 2, 6)
			.setRotationPoint(-60, -19, 18).setRotationAngle(0, 0, 0).setName("Box 50")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 265, 17, textureX, textureY).addBox(0, 0, 0, 1, 2, 6)
			.setRotationPoint(-60, -19, -24).setRotationAngle(0, 0, 0).setName("Box 51")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 65, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 39, 14, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-51, -26, 23).setRotationAngle(0, 0, 0).setName("Box 53")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 177, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 39, 14, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-51, -26, -24).setRotationAngle(0, 0, 0).setName("Box 54")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 345, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 7, 6, 0, 0, 0, 0, 0, -4, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-51, -19, 17).setRotationAngle(0, 0, 0).setName("Box 55")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 369, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 7, 6, 0, 0, 0, 0, 0, -4, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-51, -19, -23).setRotationAngle(0, 0, 0).setName("Box 56")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 465, 17, textureX, textureY).addBox(0, 0, 0, 17, 7, 1)
			.setRotationPoint(-68, -19, 17).setRotationAngle(0, 0, 0).setName("Box 57")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 185, 25, textureX, textureY).addBox(0, 0, 0, 17, 7, 1)
			.setRotationPoint(-68, -19, -18).setRotationAngle(0, 0, 0).setName("Box 58")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 409, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 7, 6, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-72, -19, 17).setRotationAngle(0, 0, 0).setName("Box 59")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 433, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 7, 6, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-72, -19, -23).setRotationAngle(0, 0, 0).setName("Box 61")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 2, 6, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-55, -21, 17).setRotationAngle(0, 0, 0).setName("Box 62")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 241, 33, textureX, textureY).addBox(0, 0, 0, 9, 2, 6)
			.setRotationPoint(-64, -21, 17).setRotationAngle(0, 0, 0).setName("Box 63")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 465, 33, textureX, textureY).addBox(0, 0, 0, 9, 2, 6)
			.setRotationPoint(-64, -21, -23).setRotationAngle(0, 0, 0).setName("Box 64")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 25, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 2, 6, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-55, -21, -23).setRotationAngle(0, 0, 0).setName("Box 65")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 369, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 2, 6, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-68, -21, 17).setRotationAngle(0, 0, 0).setName("Box 66")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 2, 6, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-68, -21, -23).setRotationAngle(0, 0, 0).setName("Box 67")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 345, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 17, 7, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-68, -26, -24).setRotationAngle(0, 0, 0).setName("Box 68")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 401, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 17, 7, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-68, -26, 23).setRotationAngle(0, 0, 0).setName("Box 69")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 465, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 14, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-80, -26, 23).setRotationAngle(0, 0, 0).setName("Box 70")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 14, 1, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-80, -26, -24).setRotationAngle(0, 0, 0).setName("Box 71")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 497, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 14, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(-82, -26, 20).setRotationAngle(0, 0, 0).setName("Box 72")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 33, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 14, 4, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-82, -26, -24).setRotationAngle(0, 0, 0).setName("Box 73")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 289, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 12, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(15, -25, 12).setRotationAngle(0, 0, 0).setName("Box 75")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 321, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 12, 0, 0, 0, 0, 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(15, -25, -24).setRotationAngle(0, 0, 0).setName("Box 76")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 145, 57, textureX, textureY).addBox(0, 0, 0, 4, 11, 2)
			.setRotationPoint(13, -23, 22).setRotationAngle(0, 0, 0).setName("Box 77")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 257, 57, textureX, textureY).addBox(0, 0, 0, 4, 11, 2)
			.setRotationPoint(13, -23, -24).setRotationAngle(0, 0, 0).setName("Box 78")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 201, textureX, textureY).addBox(0, 0, 0, 2, 2, 48)
			.setRotationPoint(13, -25, -24).setRotationAngle(0, 0, 0).setName("Box 80")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 177, 209, textureX, textureY).addBox(0, 0, 0, 2, 14, 48)
			.setRotationPoint(-12, -26, -24).setRotationAngle(0, 0, 0).setName("Box 82")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 321, 1, textureX, textureY).addBox(0, 0, 0, 1, 14, 1)
			.setRotationPoint(12, -25, 22).setRotationAngle(0, 0, 0).setName("Box 95")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 321, 17, textureX, textureY).addBox(0, 0, 0, 1, 14, 1)
			.setRotationPoint(12, -25, -23).setRotationAngle(0, 0, 0).setName("Box 96")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 497, 65, textureX, textureY).addBox(0, 0, 0, 2, 13, 2)
			.setRotationPoint(-12, -39, 22).setRotationAngle(0, 0, 0).setName("Box 99")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 33, 81, textureX, textureY).addBox(0, 0, 0, 2, 13, 2)
			.setRotationPoint(-12, -39, -24).setRotationAngle(0, 0, 0).setName("Box 100")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 233, 233, textureX, textureY).addBox(0, 0, 0, 22, 1, 48)
			.setRotationPoint(-13, -40, -24).setRotationAngle(0, 0, 0).setName("Box 101")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 113, textureX, textureY).addBox(0, 0, 0, 2, 16, 2)
			.setRotationPoint(7, -39, 22).setRotationAngle(0, 0, -0.38397247f).setName("Box 100")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 17, 113, textureX, textureY).addBox(0, 0, 0, 2, 16, 2)
			.setRotationPoint(7, -39, -24).setRotationAngle(0, 0, -0.38397247f).setName("Box 101")
		);
		chassis_primary.addProgram(DefaultPrograms.RGB_PRIMARY);
		this.groups.add(chassis_primary);
		//
		TurboList door_close = new TurboList("door_close");
		door_close.add(new ModelRendererTurbo(door_close, 65, 89, textureX, textureY).addBox(0, 0, 0, 23, 13, 1)
			.setRotationPoint(-10, -25, 23).setRotationAngle(0, 0, 0).setName("Box 104")
		);
		door_close.add(new ModelRendererTurbo(door_close, 177, 89, textureX, textureY).addBox(0, 0, 0, 23, 13, 1)
			.setRotationPoint(-10, -25, -24).setRotationAngle(0, 0, 0).setName("Box 105")
		);
		door_close.add(new ModelRendererTurbo(door_close, 185, 9, textureX, textureY).addBox(0, 0, 0, 3, 1, 1)
			.setRotationPoint(-6, -23, 23.2f).setRotationAngle(0, 0, 0).setName("Box 106")
		);
		door_close.add(new ModelRendererTurbo(door_close, 209, 9, textureX, textureY).addBox(0, 0, 0, 3, 1, 1)
			.setRotationPoint(-6, -23, -24.2f).setRotationAngle(0, 0, 0).setName("Box 107")
		);
		door_close.add(new ModelRendererTurbo(door_close, 425, 9, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(3, -22, 22.5f).setRotationAngle(0, 0, 0).setName("Box 108")
		);
		door_close.add(new ModelRendererTurbo(door_close, 17, 17, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(3, -22, -23.5f).setRotationAngle(0, 0, 0).setName("Box 109")
		);
		door_close.add(new ModelRendererTurbo(door_close, 425, 209, textureX, textureY).addBox(0, 0, 0, 1, 14, 40)
			.setRotationPoint(-81.5f, -26, -20).setRotationAngle(0, 0, 0).setName("Box 110")
		);
		door_close.add(new ModelRendererTurbo(door_close, 217, 17, textureX, textureY).addBox(0, 0, 0, 1, 2, 4)
			.setRotationPoint(-82, -25, -2).setRotationAngle(0, 0, 0).setName("Box 111")
		);
		door_close.addPrograms(DefaultPrograms.RGB_PRIMARY, DefaultPrograms.DOOR_CLOSE);
		this.groups.add(door_close);
		//
		TurboList door_open = new TurboList("door_open");
		door_open.add(new ModelRendererTurbo(door_open, 65, 241, textureX, textureY).addBox(0, 0, 0, 14, 1, 40)
			.setRotationPoint(-95.5f, -13, -20).setRotationAngle(0, 0, 0).setName("Box 112")
		);
		door_open.add(new ModelRendererTurbo(door_open, 257, 17, textureX, textureY).addBox(0, 0, 0, 2, 1, 4)
			.setRotationPoint(-93, -12.5f, -2).setRotationAngle(0, 0, 0).setName("Box 113")
		);
		door_open.add(new ModelRendererTurbo(door_open, 289, 89, textureX, textureY).addBox(0, 0, 0, 23, 13, 1)
			.setRotationPoint(-4, -25, 39).setRotationAngle(0, 0.76794493f, -0.017453292f).setName("Box 114")
		);
		door_open.add(new ModelRendererTurbo(door_open, 409, 121, textureX, textureY).addBox(0, 0, 0, 23, 13, 1)
			.setRotationPoint(-4, -25, -40).setRotationAngle(0, -0.76794493f, -0.017453292f).setName("Box 116")
		);
		door_open.add(new ModelRendererTurbo(door_open, 361, 17, textureX, textureY).addBox(0, 0, 0, 3, 1, 1)
			.setRotationPoint(-1, -23, 36.2f).setRotationAngle(0, 0.76794493f, 0).setName("Box 117")
		);
		door_open.add(new ModelRendererTurbo(door_open, 425, 25, textureX, textureY).addBox(0, 0, 0, 3, 1, 1)
			.setRotationPoint(-1, -23, -37.2f).setRotationAngle(0, -0.76794493f, 0).setName("Box 118")
		);
		door_open.add(new ModelRendererTurbo(door_open, 17, 33, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(5, -22, 29.5f).setRotationAngle(0, 0.76794493f, 0).setName("Box 119")
		);
		door_open.add(new ModelRendererTurbo(door_open, 185, 41, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(6, -22, -29.5f).setRotationAngle(0, -0.76794493f, 0).setName("Box 120")
		);
		door_open.addPrograms(DefaultPrograms.RGB_PRIMARY, DefaultPrograms.DOOR_OPEN);
		this.groups.add(door_open);
	}

}