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
@fModel(registryname = "fvp:models/part/t1p")
public class T1PModel extends VehicleModel {

	public T1PModel(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList chassis_core = new TurboList("chassis_core");
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 1, textureX, textureY).addBox(0, -1.5f, -0.5f, 81, 3, 1)
			.setRotationPoint(-59, -0.5f, 0).setRotationAngle(0, 0, 0).setName("Box 0")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 161, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(22, -2, 11.5f).setRotationAngle(0, 0, 0).setName("Box 1")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 193, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, -1, 0, -0.5f, -1, 0, 0, 0, 0, 0)
			.setRotationPoint(22, -2, -23.5f).setRotationAngle(0, 0, 0).setName("Box 2")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 225, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, -0.5f, -1, 0, -0.5f)
			.setRotationPoint(46, -2, 11.5f).setRotationAngle(0, 0, 0).setName("Box 3")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 257, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, -1, 0, 0)
			.setRotationPoint(46, -2, -23.5f).setRotationAngle(0, 0, 0).setName("Box 4")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 265, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 26, 4, 24, 0, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(22, -2, -12).setRotationAngle(0, 0, 0).setName("Box 5")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 329, 1, textureX, textureY).addBox(0, 0, 0, 3, 3, 40)
			.setRotationPoint(33.5f, -1.5f, -20).setRotationAngle(0, 0, 0).setName("Box 6")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 377, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 4, 10, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0)
			.setRotationPoint(-60, -2, 13.5f).setRotationAngle(0, 0, 0).setName("Box 7")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 409, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 4, 10, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0)
			.setRotationPoint(-85, -2, 13.5f).setRotationAngle(0, 0, 0).setName("Box 8")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 26, 4, 28, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-84, -2, -14).setRotationAngle(0, 0, 0).setName("Box 9")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 441, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 4, 10, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0)
			.setRotationPoint(-60, -2, -23.5f).setRotationAngle(0, 0, 0).setName("Box 10")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 473, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 4, 10, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0)
			.setRotationPoint(-85, -2, -23.5f).setRotationAngle(0, 0, 0).setName("Box 11")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 257, 65, textureX, textureY).addBox(0, 0, 0, 3, 3, 40)
			.setRotationPoint(-72.5f, -1.5f, -20).setRotationAngle(0, 0, 0).setName("Box 100")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 305, 65, textureX, textureY).addBox(0, 0, 0, 8, 4, 45)
			.setRotationPoint(48, -2, -22.5f).setRotationAngle(0, 0, 0).setName("Box 101")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 305, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(48, -2, -23.5f).setRotationAngle(0, 0, 0).setName("Box 102")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 329, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(48, -2, 22.5f).setRotationAngle(0, 0, 0).setName("Box 103")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 369, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 4, 37, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0)
			.setRotationPoint(56, -2, -18.5f).setRotationAngle(0, 0, 0).setName("Box 104")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 369, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 4, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1.5f, 0, 0, -1, 0, 0, 0, 0, 0)
			.setRotationPoint(56, -2, -21.5f).setRotationAngle(0, 0, 0).setName("Box 105")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 385, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 4, 2, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, -3, 0, -0.5f, -1.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(56, -2, -23.5f).setRotationAngle(0, 0, 0).setName("Box 106")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 417, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 4, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(56, -2, 18.5f).setRotationAngle(0, 0, 0).setName("Box 107")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 433, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 4, 2, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1.5f, 0, 0, -3, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(56, -2, 21.5f).setRotationAngle(0, 0, 0).setName("Box 108")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 417, 65, textureX, textureY).addBox(0, 0, 0, 3, 2, 43)
			.setRotationPoint(56, -4, -21.5f).setRotationAngle(0, 0, 0).setName("Box 109")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 449, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 2, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(56, -4, -23.5f).setRotationAngle(0, 0, 0).setName("Box 110")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 473, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 2, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0)
			.setRotationPoint(56, -4, 21.5f).setRotationAngle(0, 0, 0).setName("Box 111")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 489, 65, textureX, textureY).addBox(0, 0, 0, 9, 2, 2)
			.setRotationPoint(47, -4, -23.5f).setRotationAngle(0, 0, 0).setName("Box 112")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 73, textureX, textureY).addBox(0, 0, 0, 9, 2, 2)
			.setRotationPoint(47, -4, 21.5f).setRotationAngle(0, 0, 0).setName("Box 113")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 313, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 11, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0)
			.setRotationPoint(45, -4, 12.5f).setRotationAngle(0, 0, 0).setName("Box 114")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 433, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 11, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0)
			.setRotationPoint(45, -4, -23.5f).setRotationAngle(0, 0, 0).setName("Box 115")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 473, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 11, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0)
			.setRotationPoint(23, -4, 12.5f).setRotationAngle(0, 0, 0).setName("Box 116")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 17, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 11, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0)
			.setRotationPoint(23, -4, -23.5f).setRotationAngle(0, 0, 0).setName("Box 117")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 209, 73, textureX, textureY).addBox(0, 0, 0, 24, 7, 1)
			.setRotationPoint(23, -9, -12.5f).setRotationAngle(0, 0, 0).setName("Box 118")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 49, 81, textureX, textureY).addBox(0, 0, 0, 24, 7, 1)
			.setRotationPoint(23, -9, 11.5f).setRotationAngle(0, 0, 0).setName("Box 119")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 97, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, -1, -0.5f, 0, -1, -0.5f)
			.setRotationPoint(47, -6.5f, 21.5f).setRotationAngle(0, 0, 0).setName("Box 121")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 369, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 2, 2, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, -1, -0.5f, 0, -1, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(47, -6.5f, -23.5f).setRotationAngle(0, 0, 0).setName("Box 123")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 153, 73, textureX, textureY).addBox(0, 0, 0, 1, 7, 34)
			.setRotationPoint(55.5f, -13, -17).setRotationAngle(0, 0, 0).setName("Box 129")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 185, 89, textureX, textureY).addBox(0, 0, 0, 9, 7, 42)
			.setRotationPoint(47, -9, -21).setRotationAngle(0, 0, 0).setName("Box 139")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 393, 113, textureX, textureY).addBox(0, 0, 0, 24, 7, 23)
			.setRotationPoint(23, -9, -11.5f).setRotationAngle(0, 0, 0).setName("Box 140")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 33, 97, textureX, textureY).addBox(0, 0, 0, 1, 2, 47)
			.setRotationPoint(22, -4, -23.5f).setRotationAngle(0, 0, 0).setName("Box 151")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 305, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 34, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(57.4f, -7, -17).setRotationAngle(0, 0, 0).setName("Box 153")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 97, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 34, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(57.4f, -8, -17).setRotationAngle(0, 0, 0).setName("Box 154")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 353, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 34, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(57.4f, -9, -17).setRotationAngle(0, 0, 0).setName("Box 155")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 137, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 34, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(57.4f, -10, -17).setRotationAngle(0, 0, 0).setName("Box 156")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 177, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 34, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(57.4f, -11, -17).setRotationAngle(0, 0, 0).setName("Box 157")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 393, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 34, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(57.4f, -12, -17).setRotationAngle(0, 0, 0).setName("Box 158")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 34, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(57.4f, -13, -17).setRotationAngle(0, 0, 0).setName("Box 159")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 433, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 34, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(57.4f, -6.65f, -17).setRotationAngle(0, 0, 0).setName("Box 160")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 41, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 34, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(57.4f, -7.65f, -17).setRotationAngle(0, 0, 0).setName("Box 161")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 313, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 34, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(57.4f, -8.65f, -17).setRotationAngle(0, 0, 0).setName("Box 162")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 81, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 34, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(57.4f, -9.65f, -17).setRotationAngle(0, 0, 0).setName("Box 163")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 217, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 34, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(57.4f, -10.65f, -17).setRotationAngle(0, 0, 0).setName("Box 164")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 353, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 34, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(57.4f, -11.65f, -17).setRotationAngle(0, 0, 0).setName("Box 165")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 121, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 34, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(57.4f, -12.65f, -17).setRotationAngle(0, 0, 0).setName("Box 166")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 257, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 34, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(57.4f, -7.35f, -17).setRotationAngle(0, 0, 0).setName("Box 167")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 161, 185, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 34, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(57.4f, -8.35f, -17).setRotationAngle(0, 0, 0).setName("Box 168")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 393, 185, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 34, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(57.4f, -9.35f, -17).setRotationAngle(0, 0, 0).setName("Box 169")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 34, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(57.4f, -10.35f, -17).setRotationAngle(0, 0, 0).setName("Box 170")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 433, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 34, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(57.4f, -11.35f, -17).setRotationAngle(0, 0, 0).setName("Box 171")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 41, 201, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 34, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(57.4f, -12.35f, -17).setRotationAngle(0, 0, 0).setName("Box 172")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 297, 201, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 34, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(57.4f, -13.35f, -17).setRotationAngle(0, 0, 0).setName("Box 173")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 401, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 7, 1, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f)
			.setRotationPoint(57.5f, -13, -12).setRotationAngle(0, 0, 0).setName("Box 174")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 345, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 7, 1, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f)
			.setRotationPoint(57.5f, -13, 11).setRotationAngle(0, 0, 0).setName("Box 175")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 145, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 7, 1, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f)
			.setRotationPoint(57.5f, -13, -6).setRotationAngle(0, 0, 0).setName("Box 176")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 401, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 7, 1, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f)
			.setRotationPoint(57.5f, -13, 5).setRotationAngle(0, 0, 0).setName("Box 177")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 417, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 7, 1, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f)
			.setRotationPoint(57.5f, -13, -0.5f).setRotationAngle(0, 0, 0).setName("Box 178")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 89, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 1, 9, 0, -0.5f, 0, 0, -4, 0, 0, -1, 0, 0, -0.5f, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0)
			.setRotationPoint(40, -10, 12).setRotationAngle(0, 0, 0).setName("Box 179")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 1, 9, 0, -0.5f, 0, 0, -1, 0, 0, -4, 0, 0, -0.5f, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0)
			.setRotationPoint(40, -10, -21).setRotationAngle(0, 0, 0).setName("Box 182")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 81, 209, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 1, 24, 0, 0, 0, 0, -4, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(40, -10, -12).setRotationAngle(0, 0, 0).setName("Box 183")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 249, 97, textureX, textureY).addBox(0, 0, 0, 20, 2, 1)
			.setRotationPoint(22, -11, -12.5f).setRotationAngle(0, 0, 0).setName("Box 184")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 345, 121, textureX, textureY).addBox(0, 0, 0, 20, 2, 1)
			.setRotationPoint(22, -11, 11.5f).setRotationAngle(0, 0, 0).setName("Box 185")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 377, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 1, 9, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, -2.5f, 0, 0, 0, 0, 0, 3, 0, 0, -2.5f, 0, 0)
			.setRotationPoint(38, -11, 12).setRotationAngle(0, 0, 0).setName("Box 187")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 49, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 1, 9, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, -2.5f, 0, 0, 3, 0, 0, 0, 0, 0, -2.5f, 0, 0)
			.setRotationPoint(38, -11, -21).setRotationAngle(0, 0, 0).setName("Box 188")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 337, 209, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 24, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(40, -11, -12).setRotationAngle(0, 0, 0).setName("Box 189")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 49, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, -1, -0.5f, 0, -1, -0.5f)
			.setRotationPoint(47, -9, 21.5f).setRotationAngle(0, 0, 0).setName("Box 196")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 185, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 2, 2, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, -1, -0.5f, 0, -1, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(47, -9, -23.5f).setRotationAngle(0, 0, 0).setName("Box 197")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 105, 225, textureX, textureY).addBox(0, 0, 0, 20, 1, 44)
			.setRotationPoint(22, -12, -22).setRotationAngle(0, 0, 0).setName("Box 200")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 441, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 1, 1, 0, 0, 0, 0, -4, 0, 0, -1, 0, 0, 0, 0, 0, -2.5f, 0, 0, 0, 0, 0, 0, 0, 0, -2.5f, 0, 0)
			.setRotationPoint(38, -11, 21).setRotationAngle(0, 0, 0).setName("Box 203")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 473, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 1, 1, 0, 0, 0, 0, -1, 0, 0, -4, 0, 0, 0, 0, 0, -2.5f, 0, 0, 0, 0, 0, 0, 0, 0, -2.5f, 0, 0)
			.setRotationPoint(38, -11, -22).setRotationAngle(0, 0, 0).setName("Box 204")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 113, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 7, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(22.5f, 1, 16).setRotationAngle(0, 0, 0.5061455f).setName("Box 206")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 305, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 7, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(22.5f, 1, -23).setRotationAngle(0, 0, 0.5061455f).setName("Box 207")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 393, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 7, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(-83.5f, 1, 16).setRotationAngle(0, 0, 0.5061455f).setName("Box 208")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 137, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 7, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(-83.5f, 1, -23).setRotationAngle(0, 0, 0.5061455f).setName("Box 209")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 169, 97, textureX, textureY).addBox(0, 0, 0, 3, 1, 3)
			.setRotationPoint(-72.5f, 2, -1.5f).setRotationAngle(0, 0, 0).setName("Box 210")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 329, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-72.5f, 2, -2.5f).setRotationAngle(0, 0, 0).setName("Box 211")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 433, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(-72.5f, 2, 1.5f).setRotationAngle(0, 0, 0).setName("Box 212")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 393, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(-73.5f, 2, -1.5f).setRotationAngle(0, 0, 0).setName("Box 213")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 441, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(-69.5f, 2, -1.5f).setRotationAngle(0, 0, 0).setName("Box 214")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 193, 249, textureX, textureY).addBox(0, 0, 0, 120, 5, 3)
			.setRotationPoint(-98, -6, -10.5f).setRotationAngle(0, 0, 0).setName("Box 215")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 241, 265, textureX, textureY).addBox(0, 0, 0, 120, 5, 3)
			.setRotationPoint(-98, -6, 8.5f).setRotationAngle(0, 0, 0).setName("Box 216")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 281, textureX, textureY)
			.addShapeBox(0, 0, 0, 122, 5, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, -2, 0, 0, -2, 0, 0, -2, -2, 0, -2)
			.setRotationPoint(-100, -11, -12.5f).setRotationAngle(0, 0, 0).setName("Box 217")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 297, textureX, textureY)
			.addShapeBox(0, 0, 0, 122, 5, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, -2, 0, 0, -2, 0, 0, -2, -2, 0, -2)
			.setRotationPoint(-100, -11, 6.5f).setRotationAngle(0, 0, 0).setName("Box 218")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 313, textureX, textureY)
			.addShapeBox(0, 0, 0, 124, 1, 45, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(-102, -12, -22.5f).setRotationAngle(0, 0, 0).setName("Box 219")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 345, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 4, 10, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 0, -2, 0, 0, -2, 0, 0, 1, 0, 0)
			.setRotationPoint(-83, -6, 13.5f).setRotationAngle(0, 0, 0).setName("Box 220")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 297, 241, textureX, textureY).addBox(0, 0, 0, 81, 1, 1)
			.setRotationPoint(-59, -1, -1.5f).setRotationAngle(0, 0, 0).setName("Box 221")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 273, textureX, textureY).addBox(0, 0, 0, 81, 1, 1)
			.setRotationPoint(-59, -1, 0.5f).setRotationAngle(0, 0, 0).setName("Box 222")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 257, 281, textureX, textureY)
			.addShapeBox(0, 0, 0, 81, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-59, -2, 0.5f).setRotationAngle(0, 0, 0).setName("Box 223")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 265, 289, textureX, textureY)
			.addShapeBox(0, 0, 0, 81, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-59, 0, -1.5f).setRotationAngle(0, 0, 0).setName("Box 224")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 257, 297, textureX, textureY)
			.addShapeBox(0, 0, 0, 81, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(-59, 0, 0.5f).setRotationAngle(0, 0, 0).setName("Box 225")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 265, 305, textureX, textureY)
			.addShapeBox(0, 0, 0, 81, 1, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-59, -2, -1.5f).setRotationAngle(0, 0, 0).setName("Box 226")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 305, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 4, 10, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, -2, 0, 0, 1, 0, 0, 1, 0, 0, -2, 0, 0)
			.setRotationPoint(-62, -6, 13.5f).setRotationAngle(0, 0, 0).setName("Box 227")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 481, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 4, 10, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 0, -2, 0, 0, -2, 0, 0, 1, 0, 0)
			.setRotationPoint(-83, -6, -23.5f).setRotationAngle(0, 0, 0).setName("Box 228")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 4, 10, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, -2, 0, 0, 1, 0, 0, 1, 0, 0, -2, 0, 0)
			.setRotationPoint(-62, -6, -23.5f).setRotationAngle(0, 0, 0).setName("Box 229")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 385, 281, textureX, textureY).addBox(0, 0, 0, 2, 5, 45)
			.setRotationPoint(-100, -6, -21.5f).setRotationAngle(0, 0, 0).setName("Box 230")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 4, 10, 0, 2, 0, 0, -3, 0, 0, -3, 0, 0, 2, 0, 0, -2, 0, 0, 1, 0, 0, 1, 0, 0, -2, 0, 0)
			.setRotationPoint(-64, -10, 13.5f).setRotationAngle(0, 0, 0).setName("Box 262")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 217, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 4, 10, 0, -3, 0, 0, 2, 0, 0, 2, 0, 0, -3, 0, 0, 1, 0, 0, -2, 0, 0, -2, 0, 0, 1, 0, 0)
			.setRotationPoint(-81, -10, 13.5f).setRotationAngle(0, 0, 0).setName("Box 263")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 433, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 4, 10, 0, -3, 0, 0, 2, 0, 0, 2, 0, 0, -3, 0, 0, 1, 0, 0, -2, 0, 0, -2, 0, 0, 1, 0, 0)
			.setRotationPoint(-81, -10, -23.5f).setRotationAngle(0, 0, 0).setName("Box 264")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 41, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 4, 10, 0, 2, 0, 0, -3, 0, 0, -3, 0, 0, 2, 0, 0, -2, 0, 0, 1, 0, 0, 1, 0, 0, -2, 0, 0)
			.setRotationPoint(-64, -10, -23.5f).setRotationAngle(0, 0, 0).setName("Box 265")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 81, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 10, 0, 2, 0, 0, -3, 0, 0, -3, 0, 0, 2, 0, 0, -2, 0, 0, 1, 0, 0, 1, 0, 0, -2, 0, 0)
			.setRotationPoint(-68, -11, 13.5f).setRotationAngle(0, 0, 0).setName("Box 267")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 257, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 10, 0, -3, 0, 0, 2, 0, 0, 2, 0, 0, -3, 0, 0, 1, 0, 0, -2, 0, 0, -2, 0, 0, 1, 0, 0)
			.setRotationPoint(-77, -11, 13.5f).setRotationAngle(0, 0, 0).setName("Box 268")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 297, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 10, 0, -3, 0, 0, 2, 0, 0, 2, 0, 0, -3, 0, 0, 1, 0, 0, -2, 0, 0, -2, 0, 0, 1, 0, 0)
			.setRotationPoint(-77, -11, -23.5f).setRotationAngle(0, 0, 0).setName("Box 269")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 353, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 10, 0, 2, 0, 0, -3, 0, 0, -3, 0, 0, 2, 0, 0, -2, 0, 0, 1, 0, 0, 1, 0, 0, -2, 0, 0)
			.setRotationPoint(-68, -11, -23.5f).setRotationAngle(0, 0, 0).setName("Box 270")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 49, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 1, 2, 0, -2, -0.5f, 0, -2, -0.5f, 0, -2, -0.5f, 0, -2, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-74, -12, 21.5f).setRotationAngle(0, 0, 0).setName("Box 271")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 321, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 1, 2, 0, -2, -0.5f, 0, -2, -0.5f, 0, -2, -0.5f, 0, -2, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-74, -12, -23.5f).setRotationAngle(0, 0, 0).setName("Box 272")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 193, textureX, textureY).addBox(0, 0, 0, 3, 11, 9)
			.setRotationPoint(19, -10.5f, 13.5f).setRotationAngle(0, 0, 0).setName("Box 305")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 433, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 11, 9, 0, 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, -1, -1, 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, -1, -1)
			.setRotationPoint(18, -10.5f, 13.5f).setRotationAngle(0, 0, 0).setName("Box 306")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 49, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(20, -2.5f, 21.8f).setRotationAngle(0, 0, 0).setName("Box 307")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 81, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, -0.25f, -0.75f, 0, -0.25f, -0.75f, 0, -0.25f, -0.75f, 0, -0.25f, -0.75f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(20, -3.5f, 21.8f).setRotationAngle(0, 0, 0).setName("Box 308")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 145, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.25f, -0.75f, 0, -0.25f, -0.75f, 0, -0.25f, -0.75f, 0, -0.25f, -0.75f, 0)
			.setRotationPoint(20, -1.5f, 21.8f).setRotationAngle(0, 0, 0).setName("Box 310")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 41, 201, textureX, textureY).addBox(0, 0, 0, 4, 10, 8)
			.setRotationPoint(17.9f, -10, -22).setRotationAngle(0, 0, 0).setName("Box 313")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 321, 49, textureX, textureY).addBox(0, 0, 0, 1, 2, 1)
			.setRotationPoint(17.5f, -7, -21.5f).setRotationAngle(0, 0, 0).setName("Box 314")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 481, 153, textureX, textureY).addBox(0, 0, 0, 1, 3, 12)
			.setRotationPoint(58.5f, -2, -6).setRotationAngle(0, 0, 0.2617994f).setName("Box 315")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 217, 185, textureX, textureY).addBox(0, 0, 0, 1, 3, 12)
			.setRotationPoint(-100.2f, -5, -6).setRotationAngle(0.017453292f, 0, 0).setName("Box 316")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 201, 209, textureX, textureY)
			.addShapeBox(0, 0, 0, 24, 4, 1, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-83, -6, -14).setRotationAngle(0, 0, 0).setName("Box 317")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 369, 209, textureX, textureY)
			.addShapeBox(0, 0, 0, 24, 4, 1, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-83, -6, 13).setRotationAngle(0, 0, 0).setName("Box 318")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 273, 217, textureX, textureY)
			.addShapeBox(0, 0, 0, 20, 4, 1, 0, -4, 0, 0, -4, 0, 0, -4, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-81, -10, 13).setRotationAngle(0, 0, 0).setName("Box 319")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 273, 225, textureX, textureY)
			.addShapeBox(0, 0, 0, 20, 4, 1, 0, -4, 0, 0, -4, 0, 0, -4, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-81, -10, -14).setRotationAngle(0, 0, 0).setName("Box 320")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 457, 145, textureX, textureY).addBox(0, 0, 0, 10, 1, 1)
			.setRotationPoint(31, -13, -19).setRotationAngle(0, 0, 0).setName("Box 322")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 57, 153, textureX, textureY).addBox(0, 0, 0, 10, 1, 1)
			.setRotationPoint(31, -13, -6).setRotationAngle(0, 0, 0).setName("Box 323")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 393, 185, textureX, textureY).addBox(0, 0, 0, 10, 1, 1)
			.setRotationPoint(31, -13, 16).setRotationAngle(0, 0, 0).setName("Box 324")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 393, 193, textureX, textureY).addBox(0, 0, 0, 10, 1, 1)
			.setRotationPoint(31, -13, 5).setRotationAngle(0, 0, 0).setName("Box 325")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 449, 233, textureX, textureY).addBox(0, 0, 0, 12, 2, 18)
			.setRotationPoint(30, -15, -21).setRotationAngle(0, 0, 0).setName("Box 326")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 241, textureX, textureY).addBox(0, 0, 0, 12, 2, 16)
			.setRotationPoint(30, -15, 3).setRotationAngle(0, 0, 0).setName("Box 327")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 65, 241, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0)
			.setRotationPoint(28, -15, 4).setRotationAngle(0, 0, 0).setName("Box 335")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 105, 241, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0)
			.setRotationPoint(28, -15, -20).setRotationAngle(0, 0, 0).setName("Box 336")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 473, 265, textureX, textureY).addBox(0, 0, 0, 2, 16, 16)
			.setRotationPoint(28, -31, 3).setRotationAngle(0, 0, 0).setName("Box 337")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 441, 281, textureX, textureY).addBox(0, 0, 0, 2, 16, 18)
			.setRotationPoint(28, -31, -21).setRotationAngle(0, 0, 0).setName("Box 338")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 473, 305, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 6, 14, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0)
			.setRotationPoint(50.5f, -24, 4).setRotationAngle(0, 0, 0).setName("Box 349")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 313, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 13, 6, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0)
			.setRotationPoint(50.5f, -22, -3).setRotationAngle(0, 0, 0).setName("Box 353")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 297, 201, textureX, textureY)
			.addShapeBox(0, 0, 0, 9, 3, 6, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(41.5f, -12, -3).setRotationAngle(0, 0, 0).setName("Box 354")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 369, 217, textureX, textureY).addBox(0, 0, 0, 1, 4, 10)
			.setRotationPoint(53, -20, -17).setRotationAngle(0, 0, 0).setName("Box 356")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 129, 33, textureX, textureY).addBox(0, 0, 0, 1, 1, 4)
			.setRotationPoint(52.8f, -19.5f, -14).setRotationAngle(0, 0, 0).setName("Box 357")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 73, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.1f, -0.1f, -0.6f, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, 0, -0.1f, -0.1f, 0, -0.1f, -0.1f, -0.6f, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, 0, -0.1f, -0.1f)
			.setRotationPoint(58.5f, -18, -1).setRotationAngle(0, 0, 0).setName("Box 358")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 49, 57, textureX, textureY).addBox(0, 0, -1, 1, 1, 4)
			.setRotationPoint(50.4f, -21.5f, -1).setRotationAngle(0, 0, 0.10471976f).setName("Box 361")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 417, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(50.4f, -21.5f, -2.75f).setRotationAngle(0, 0, 0.10471976f).setName("Box 362")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 49, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(50.4f, -21.5f, 2.25f).setRotationAngle(0, 0, 0.10471976f).setName("Box 363")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 169, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(50.4f, -23.5f, 17.25f).setRotationAngle(0, 0, 0.10471976f).setName("Box 366")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 193, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(50.4f, -23.5f, 16.25f).setRotationAngle(0, 0, 0.10471976f).setName("Box 367")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 449, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(50.4f, -22.5f, 16.25f).setRotationAngle(0, 0, 0.10471976f).setName("Box 368")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 17, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(50.4f, -21.5f, 17.25f).setRotationAngle(0, 0, 0.10471976f).setName("Box 370")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 121, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(50.4f, -20.5f, 16.25f).setRotationAngle(0, 0, 0.10471976f).setName("Box 372")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 169, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(50.4f, -19.5f, 17.25f).setRotationAngle(0, 0, 0.10471976f).setName("Box 374")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 177, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(50.4f, -19.5f, 16.25f).setRotationAngle(0, 0, 0.10471976f).setName("Box 375")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 193, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(50.4f, -22.5f, 5.25f).setRotationAngle(0, 0, 0.10471976f).setName("Box 376")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 289, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(50.4f, -21.5f, 4.25f).setRotationAngle(0, 0, 0.10471976f).setName("Box 377")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 305, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(50.4f, -21.5f, 5.25f).setRotationAngle(0, 0, 0.10471976f).setName("Box 378")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 329, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(50.4f, -20.5f, 5.25f).setRotationAngle(0, 0, 0.10471976f).setName("Box 379")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 473, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(50.4f, -19.5f, 5.25f).setRotationAngle(0, 0, 0.10471976f).setName("Box 380")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 497, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(50.4f, -20.5f, 4.25f).setRotationAngle(0, 0, 0.10471976f).setName("Box 381")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(50.4f, -19.5f, 4.25f).setRotationAngle(0, 0, 0.10471976f).setName("Box 382")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 409, 169, textureX, textureY).addBox(0, 0, 0, 5, 2, 2)
			.setRotationPoint(48.5f, -23, 10).setRotationAngle(0, 0, 0.2617994f).setName("Box 384")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 113, 97, textureX, textureY).addBox(0, 0, 0, 1, 2, 2)
			.setRotationPoint(47.6f, -23, 10).setRotationAngle(0, 0, 0).setName("Box 385")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 217, textureX, textureY)
			.addShapeBox(0, 1, 0, 12, 2, 3, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(28.5f, -15, -1.5f).setRotationAngle(0, 0, 0).setName("Box 401")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 17, 177, textureX, textureY).addBox(0, 1, 0, 7, 1, 1)
			.setRotationPoint(32.5f, -15, -0.5f).setRotationAngle(0, 0, -0.17453294f).setName("Box 402")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 273, 185, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 2, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(52.5f, -10, 8).setRotationAngle(0, 0, 0).setName("Box 419")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 313, 185, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 2, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(52.5f, -10, 13).setRotationAngle(0, 0, 0).setName("Box 420")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 137, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 1, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(49.4f, -23.5f, 15).setRotationAngle(-1.2391838f, 0, 0.08726647f).setName("Box 421")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 153, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 1, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(49.4f, -23, 7).setRotationAngle(1.2391838f, 0, 0.08726647f).setName("Box 422")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 345, 129, textureX, textureY).addBox(0, 0, 0, 1, 5, 1)
			.setRotationPoint(46.5f, -17, -0.5f).setRotationAngle(0, 0, -0.17453294f).setName("Box 423")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 73, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 2, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(54.5f, -20, 23).setRotationAngle(0, 0, 0).setName("Box 425")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 481, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 2, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(54.1f, -28, 23).setRotationAngle(0, 0, 0).setName("Box 426")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 65, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 7, 3, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(54.4f, -25, 23.5f).setRotationAngle(0, -0.10471976f, 0).setName("Box 427")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 177, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 3, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(53.9f, -29, 23.5f).setRotationAngle(0, -0.13962634f, -0.12217305f).setName("Box 428")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 73, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 2, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(54.5f, -24, 23).setRotationAngle(0, 0, 0).setName("Box 429")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 305, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 2, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(54.5f, -20, -25).setRotationAngle(0, 0, 0).setName("Box 430")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 505, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 2, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(54.5f, -24, -25).setRotationAngle(0, 0, 0).setName("Box 431")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 2, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(54, -28, -25).setRotationAngle(0, 0, 0).setName("Box 432")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 417, 185, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 7, 3, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(54.1f, -25, -26.5f).setRotationAngle(0, 0.10471976f, 0).setName("Box 433")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 25, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 3, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(53.4f, -29, -26.5f).setRotationAngle(0.017453292f, 0.13962634f, -0.12217305f).setName("Box 434")
		);
		this.groups.add(chassis_core);
		//
		TurboList chassis_primary = new TurboList("chassis_primary");
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 33, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 7, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(47, -9, 20.5f).setRotationAngle(0, 0, 0).setName("Box 120")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 265, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 7, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(47, -9, -21.5f).setRotationAngle(0, 0, 0).setName("Box 122")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 105, 73, textureX, textureY).addBox(0, 0, 0, 1, 5, 11)
			.setRotationPoint(46, -9, 12).setRotationAngle(0, 0, 0).setName("Box 124")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 153, 73, textureX, textureY).addBox(0, 0, 0, 1, 5, 11)
			.setRotationPoint(46, -9, -23).setRotationAngle(0, 0, 0).setName("Box 125")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 417, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 5, 2, 0, -0.5f, 0, 0, 0, 0, 0, -1, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, -1, 0, 0, -0.5f, 0, 0)
			.setRotationPoint(53.5f, -9, 21).setRotationAngle(0, 0, 0).setName("Box 126")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 5, 2, 0, -0.5f, 0, 0, -1, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -1, 0, 0, 0, 0, 0, -0.5f, 0, 0)
			.setRotationPoint(53.5f, -9, -23).setRotationAngle(0, 0, 0).setName("Box 127")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 89, 81, textureX, textureY).addBox(0, 0, 0, 3, 2, 42)
			.setRotationPoint(55.5f, -6, -21).setRotationAngle(0, 0, 0).setName("Box 128")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 385, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(55.5f, -9, -21).setRotationAngle(0, 0, 0).setName("Box 130")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 193, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 5, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(55.5f, -9, 16).setRotationAngle(0, 0, 0).setName("Box 131")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 281, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 4, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -0.1f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -0.1f, 0, 0)
			.setRotationPoint(55.5f, -13, -18).setRotationAngle(0, 0, 0).setName("Box 132")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 305, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 4, 2, 0, -0.1f, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, -0.1f, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(55.5f, -13, 16).setRotationAngle(0, 0, 0).setName("Box 133")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 89, textureX, textureY).addBox(0, 0, 0, 3, 2, 36)
			.setRotationPoint(55.5f, -15, -18).setRotationAngle(0, 0, 0).setName("Box 134")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 305, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 5, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3.5f, 0, 0, 0, 0, 0, 0, 0, 0, -3.5f, 0, 0)
			.setRotationPoint(42, -9, -23).setRotationAngle(0, 0, 0).setName("Box 135")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 417, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 5, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3.5f, 0, 0, 0, 0, 0, 0, 0, 0, -3.5f, 0, 0)
			.setRotationPoint(42, -9, 12).setRotationAngle(0, 0, 0).setName("Box 136")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 473, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 5, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3.5f, 0, 0, -3.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(24, -9, 12).setRotationAngle(0, 0, 0).setName("Box 137")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 5, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3.5f, 0, 0, -3.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(24, -9, -23).setRotationAngle(0, 0, 0).setName("Box 138")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 257, 81, textureX, textureY).addBox(0, 0, 0, 1, 4, 5)
			.setRotationPoint(54, -13, 18).setRotationAngle(0, 0, 0).setName("Box 141")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 441, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 2, 2, 0, -0.5f, 0, 0, 0, 0, 0, -1, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, -1, 0, 0, -0.5f, 0, 0)
			.setRotationPoint(53.5f, -15, 21).setRotationAngle(0, 0, 0).setName("Box 144")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 209, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 2, 3, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0)
			.setRotationPoint(53.5f, -15, 18).setRotationAngle(0, 0, 0).setName("Box 145")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 273, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 2, 3, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0)
			.setRotationPoint(53.5f, -15, -21).setRotationAngle(0, 0, 0).setName("Box 146")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 497, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 2, 2, 0, -0.5f, 0, 0, -1, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -1, 0, 0, 0, 0, 0, -0.5f, 0, 0)
			.setRotationPoint(53.5f, -15, -23).setRotationAngle(0, 0, 0).setName("Box 147")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 97, 89, textureX, textureY).addBox(0, 0, 0, 1, 4, 5)
			.setRotationPoint(54, -13, -23).setRotationAngle(0, 0, 0).setName("Box 148")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 249, 113, textureX, textureY).addBox(0, 0, 0, 2, 5, 46)
			.setRotationPoint(22, -9, -23).setRotationAngle(0, 0, 0).setName("Box 152")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 249, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 1, 11, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0)
			.setRotationPoint(22, -10, 12).setRotationAngle(0, 0, 0).setName("Box 180")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 465, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 1, 11, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0)
			.setRotationPoint(22, -10, -23).setRotationAngle(0, 0, 0).setName("Box 181")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 209, 217, textureX, textureY).addBox(0, 0, 0, 18, 2, 23)
			.setRotationPoint(22, -11, -11.5f).setRotationAngle(0, 0, 0).setName("Box 186")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 145, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 1, 2, 0, -0.5f, 0, 0, -1, 0, 0, -1, 0, 0, -0.5f, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0)
			.setRotationPoint(40, -10, 21).setRotationAngle(0, 0, 0).setName("Box 190")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 193, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 1, 2, 0, -0.5f, 0, 0, -1, 0, 0, -1, 0, 0, -0.5f, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0)
			.setRotationPoint(40, -10, -23).setRotationAngle(0, 0, 0).setName("Box 191")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 1, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2.5f, 0, 0, -2.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(22, -11, 12).setRotationAngle(0, 0, 0).setName("Box 192")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 217, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 1, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2.5f, 0, 0, -2.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(22, -11, -23).setRotationAngle(0, 0, 0).setName("Box 193")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 305, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 1, 1, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, -2.5f, 0, 0, 0, 0, 0, 0, 0, 0, -2.5f, 0, 0)
			.setRotationPoint(38, -11, 22).setRotationAngle(0, 0, 0).setName("Box 194")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 489, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 1, 1, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, -2.5f, 0, 0, 0, 0, 0, 0, 0, 0, -2.5f, 0, 0)
			.setRotationPoint(38, -11, -23).setRotationAngle(0, 0, 0).setName("Box 195")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 137, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 6, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, -0.5f)
			.setRotationPoint(53.5f, -15, -18).setRotationAngle(0, 0, 0).setName("Box 198")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 289, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 6, 1, 0, -0.5f, 0, -0.5f, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, -0.5f, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0)
			.setRotationPoint(53.5f, -15, 17).setRotationAngle(0, 0, 0).setName("Box 199")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 33, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 19, 8, 1, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(22, -19, -23).setRotationAngle(0, 0, 0).setName("Box 201")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 297, 321, textureX, textureY).addBox(0, 0, 0, 2, 9, 44)
			.setRotationPoint(22, -21, -22).setRotationAngle(0, 0, 0).setName("Box 321")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 353, 337, textureX, textureY).addBox(0, 0, 0, 5, 6, 42)
			.setRotationPoint(53.5f, -21, -21).setRotationAngle(0, 0, 0).setName("Box 329")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 497, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 6, 5, 0, 0, 0, 0, -0.5f, 0, 0.5f, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0.5f, -0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(53.5f, -15, 18).setRotationAngle(0, 0, 0).setName("Box 331")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 161, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 6, 5, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0.5f, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0.5f, 0, 0, 0)
			.setRotationPoint(53.5f, -15, -23).setRotationAngle(0, 0, 0).setName("Box 332")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 17, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 6, 2, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0)
			.setRotationPoint(53.5f, -21, 21).setRotationAngle(0, 0, 0).setName("Box 333")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 449, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 6, 2, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(53.5f, -21, -23).setRotationAngle(0, 0, 0).setName("Box 334")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 121, 217, textureX, textureY)
			.addShapeBox(0, 0, 0, 17, 2, 1, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(22, -21, 22).setRotationAngle(0, 0, 0).setName("Box 339")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 473, 217, textureX, textureY)
			.addShapeBox(0, 0, 0, 17, 2, 1, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(22, -21, -23).setRotationAngle(0, 0, 0).setName("Box 340")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 505, 89, textureX, textureY).addBox(0, 0, 0, 1, 17, 1)
			.setRotationPoint(52.5f, -26, 21).setRotationAngle(0, 0, 0).setName("Box 341")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 289, 121, textureX, textureY).addBox(0, 0, 0, 1, 17, 1)
			.setRotationPoint(52.5f, -26, -22).setRotationAngle(0, 0, 0).setName("Box 342")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 337, 201, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 17, 2, 0, 3, 0, 0, -3, 0, 0, -4, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0)
			.setRotationPoint(53.5f, -38, 21).setRotationAngle(0, 0, 0).setName("Box 343")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 81, 209, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 17, 2, 0, 3, 0, 0, -4, 0, 0, -3, 0, 0, 3, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(53.5f, -38, -23).setRotationAngle(0, 0, 0).setName("Box 344")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 193, 225, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 17, 1, 0, 3, 0, 0, -3, 0, 0, -3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(53.5f, -38, -21).setRotationAngle(0, 0, 0).setName("Box 345")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 233, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 17, 1, 0, 3, 0, 0, -3, 0, 0, -3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(53.5f, -38, 20).setRotationAngle(0, 0, 0).setName("Box 346")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 361, textureX, textureY).addBox(0, 0, 0, 32, 1, 46)
			.setRotationPoint(22, -39, -23).setRotationAngle(0, 0, 0).setName("Box 347")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 409, 345, textureX, textureY).addBox(0, 0, 0, 2, 17, 46)
			.setRotationPoint(22, -38, -23).setRotationAngle(0, 0, 0).setName("Box 348")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 113, 361, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 42, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(54, -39, -21).setRotationAngle(0, 0, 0).setName("Box 350")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 17, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 2, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -1.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(54, -39, 21).setRotationAngle(0, 0, 0).setName("Box 351")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 89, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 2, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -1.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(54, -39, -23).setRotationAngle(0, 0, 0).setName("Box 352")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 497, 257, textureX, textureY).addBox(0, 0, 0, 3, 17, 1)
			.setRotationPoint(24, -38, -23).setRotationAngle(0, 0, 0).setName("Box 359")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 25, 313, textureX, textureY).addBox(0, 0, 0, 3, 17, 1)
			.setRotationPoint(24, -38, 22).setRotationAngle(0, 0, 0).setName("Box 360")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 73, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(50.4f, -23.5f, 4.25f).setRotationAngle(0, 0, 0.10471976f).setName("Box 364")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 145, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(50.4f, -23.5f, 5.25f).setRotationAngle(0, 0, 0.10471976f).setName("Box 365")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 473, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(50.4f, -22.5f, 17.25f).setRotationAngle(0, 0, 0.10471976f).setName("Box 369")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 105, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(50.4f, -21.5f, 16.25f).setRotationAngle(0, 0, 0.10471976f).setName("Box 371")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 153, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(50.4f, -20.5f, 17.25f).setRotationAngle(0, 0, 0.10471976f).setName("Box 373")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 25, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(50.4f, -22.5f, 4.25f).setRotationAngle(0, 0, 0.10471976f).setName("Box 383")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 89, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 19, 8, 1, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(22, -19, 22).setRotationAngle(0, 0, 0).setName("Box 619")
		);
		chassis_primary.addProgram(DefaultPrograms.RGB_PRIMARY);
		this.groups.add(chassis_primary);
		//
		TurboList door_close = new TurboList("door_close");
		door_close.add(new ModelRendererTurbo(door_close, 121, 225, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 2, 1, 0, 0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0.5f, 0, 0, -1.5f, 0, 0, 0, 0, 0, 0, 0, 0, -1.5f, 0, 0)
			.setRotationPoint(45.5f, -11, 22).setRotationAngle(0, 0, 0).setName("Box 403")
		);
		door_close.add(new ModelRendererTurbo(door_close, 393, 225, textureX, textureY)
			.addShapeBox(0, 0, 0, 15, 8, 1, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, -2, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -2, 0, 0)
			.setRotationPoint(39, -19, 22).setRotationAngle(0, 0, 0).setName("Box 404")
		);
		door_close.add(new ModelRendererTurbo(door_close, 441, 257, textureX, textureY)
			.addShapeBox(0, 0, 0, 16, 2, 1, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, -1, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -1, 0, 0)
			.setRotationPoint(38, -21, 22).setRotationAngle(0, 0, 0).setName("Box 405")
		);
		door_close.add(new ModelRendererTurbo(door_close, 1, 265, textureX, textureY)
			.addShapeBox(0, 0, 0, 26, 1, 1, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(27, -22, 22).setRotationAngle(0, 0, 0).setName("Box 406")
		);
		door_close.add(new ModelRendererTurbo(door_close, 505, 185, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 17, 1, 0, 3, 0, 0, -3, 0, 0, -3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(52.5f, -38, 22).setRotationAngle(0, 0, 0).setName("Box 407")
		);
		door_close.add(new ModelRendererTurbo(door_close, 57, 265, textureX, textureY).addBox(0, 0, 0, 23, 1, 1)
			.setRotationPoint(27, -38, 22).setRotationAngle(0, 0, 0).setName("Box 408")
		);
		door_close.add(new ModelRendererTurbo(door_close, 329, 129, textureX, textureY).addBox(0, 0, 0, 1, 15, 1)
			.setRotationPoint(27, -37, 22).setRotationAngle(0, 0, 0).setName("Box 409")
		);
		door_close.add(new ModelRendererTurbo(door_close, 97, 153, textureX, textureY).addBox(0, 0, 0, 3, 1, 2)
			.setRotationPoint(41, -19, 21.5f).setRotationAngle(0, 0, 0).setName("Box 410")
		);
		door_close.add(new ModelRendererTurbo(door_close, 209, 225, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 2, 1, 0, 0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0.5f, 0, 0, -1.5f, 0, 0, 0, 0, 0, 0, 0, 0, -1.5f, 0, 0)
			.setRotationPoint(45.5f, -11, -23).setRotationAngle(0, 0, 0).setName("Box 411")
		);
		door_close.add(new ModelRendererTurbo(door_close, 297, 313, textureX, textureY)
			.addShapeBox(0, 0, 0, 15, 8, 1, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, -2, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -2, 0, 0)
			.setRotationPoint(39, -19, -23).setRotationAngle(0, 0, 0).setName("Box 412")
		);
		door_close.add(new ModelRendererTurbo(door_close, 97, 185, textureX, textureY).addBox(0, 0, 0, 3, 1, 2)
			.setRotationPoint(41, -19, -23.5f).setRotationAngle(0, 0, 0).setName("Box 413")
		);
		door_close.add(new ModelRendererTurbo(door_close, 113, 265, textureX, textureY)
			.addShapeBox(0, 0, 0, 16, 2, 1, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, -1, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -1, 0, 0)
			.setRotationPoint(38, -21, -23).setRotationAngle(0, 0, 0).setName("Box 414")
		);
		door_close.add(new ModelRendererTurbo(door_close, 169, 273, textureX, textureY)
			.addShapeBox(0, 0, 0, 26, 1, 1, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(27, -22, -23).setRotationAngle(0, 0, 0).setName("Box 415")
		);
		door_close.add(new ModelRendererTurbo(door_close, 457, 153, textureX, textureY).addBox(0, 0, 0, 1, 15, 1)
			.setRotationPoint(27, -37, -23).setRotationAngle(0, 0, 0).setName("Box 416")
		);
		door_close.add(new ModelRendererTurbo(door_close, 193, 265, textureX, textureY).addBox(0, 0, 0, 23, 1, 1)
			.setRotationPoint(27, -38, -23).setRotationAngle(0, 0, 0).setName("Box 417")
		);
		door_close.add(new ModelRendererTurbo(door_close, 97, 209, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 17, 1, 0, 3, 0, 0, -3, 0, 0, -3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(52.5f, -38, -23).setRotationAngle(0, 0, 0).setName("Box 418")
		);
		door_close.addPrograms(DefaultPrograms.DOOR_CLOSE, DefaultPrograms.RGB_PRIMARY);
		this.groups.add(door_close);
		//
		TurboList door_open = new TurboList("door_open");
		door_open.add(new ModelRendererTurbo(door_open, 49, 241, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -1.5f, 0, 0, -1.5f)
			.setRotationPoint(52.5f, -11, 22).setRotationAngle(0, 0, 0).setName("Box 441")
		);
		door_open.add(new ModelRendererTurbo(door_open, 353, 321, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 8, 15, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -2, 0, 0, -2)
			.setRotationPoint(52.5f, -19, 21.5f).setRotationAngle(0, 0, 0).setName("Box 442")
		);
		door_open.add(new ModelRendererTurbo(door_open, 297, 329, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 16, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(52.5f, -21, 21.5f).setRotationAngle(0, 0, 0).setName("Box 443")
		);
		door_open.add(new ModelRendererTurbo(door_open, 353, 209, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 17, 1, 0, 0, 0, -3, 0, 0, -3, 0, 0, 3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(52.5f, -38, 22).setRotationAngle(0, 0, 0).setName("Box 444")
		);
		door_open.add(new ModelRendererTurbo(door_open, 161, 361, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 26, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(52.5f, -22, 22).setRotationAngle(0, 0, 0).setName("Box 445")
		);
		door_open.add(new ModelRendererTurbo(door_open, 321, 217, textureX, textureY).addBox(0, 0, 0, 1, 15, 1)
			.setRotationPoint(52.5f, -37, 47).setRotationAngle(0, 0, 0).setName("Box 446")
		);
		door_open.add(new ModelRendererTurbo(door_open, 193, 361, textureX, textureY).addBox(0, 0, 0, 1, 1, 23)
			.setRotationPoint(52.5f, -38, 25).setRotationAngle(0, 0, 0).setName("Box 447")
		);
		door_open.add(new ModelRendererTurbo(door_open, 369, 185, textureX, textureY).addBox(0, 0, 0, 2, 1, 3)
			.setRotationPoint(52, -19, 31.5f).setRotationAngle(0, 0, 0).setName("Box 448")
		);
		door_open.add(new ModelRendererTurbo(door_open, 89, 241, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 8, 0, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -1.5f, 0, 0, -1.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(52.5f, -11, -30).setRotationAngle(0, 0, 0).setName("Box 449")
		);
		door_open.add(new ModelRendererTurbo(door_open, 465, 329, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 8, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -2, 0, 0, -2, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(52.5f, -19, -36.5f).setRotationAngle(0, 0, 0).setName("Box 450")
		);
		door_open.add(new ModelRendererTurbo(door_open, 1, 337, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -1, 0, 0, -1, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(52.5f, -21, -37.5f).setRotationAngle(0, 0, 0).setName("Box 451")
		);
		door_open.add(new ModelRendererTurbo(door_open, 169, 193, textureX, textureY).addBox(0, 0, 0, 2, 1, 3)
			.setRotationPoint(52, -19, -34.5f).setRotationAngle(0, 0, 0).setName("Box 452")
		);
		door_open.add(new ModelRendererTurbo(door_open, 217, 361, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 26, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(52.5f, -22, -48.5f).setRotationAngle(0, 0, 0).setName("Box 453")
		);
		door_open.add(new ModelRendererTurbo(door_open, 505, 225, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 17, 1, 0, 0, 0, 3, 0, 0, 3, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(52.5f, -38, -23).setRotationAngle(0, 0, 0).setName("Box 454")
		);
		door_open.add(new ModelRendererTurbo(door_open, 249, 361, textureX, textureY).addBox(0, 0, 0, 1, 1, 23)
			.setRotationPoint(52.5f, -38, -48).setRotationAngle(0, 0, 0).setName("Box 455")
		);
		door_open.add(new ModelRendererTurbo(door_open, 497, 233, textureX, textureY).addBox(0, 0, 0, 1, 15, 1)
			.setRotationPoint(52.5f, -37, -48).setRotationAngle(0, 0, 0).setName("Box 456")
		);
		door_open.addPrograms(DefaultPrograms.DOOR_OPEN, DefaultPrograms.RGB_PRIMARY);
		this.groups.add(door_open);
		//
		TurboList toolbox = new TurboList("toolbox");
		toolbox.add(new ModelRendererTurbo(toolbox, 473, 193, textureX, textureY).addBox(0, 0, 0, 4, 11, 9)
			.setRotationPoint(18, -10.5f, -22.5f).setRotationAngle(0, 0, 0).setName("Box 312")
		);
		toolbox.addProgram(DefaultPrograms.RGB_SECONDARY);
		this.groups.add(toolbox);
	}

}