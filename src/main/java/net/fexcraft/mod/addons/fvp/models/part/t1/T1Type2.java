//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.part.t1;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.addons.fvp.scripts.T1_2Script;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.api.root.Colorable;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.4-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/part/t1_type2")
public class T1Type2 extends PartModel {

	public T1Type2(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList chassis_core = new TurboList("chassis_core");
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 8, 54, 0, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(18, -22, -27).setRotationAngle(0, 0, 0).setName("Box 0")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 65, 1, textureX, textureY).addBox(0, 0, 0, 2, 2, 40)
			.setRotationPoint(20, -49, -20).setRotationAngle(0, 0, 0).setName("Box 1")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 1, textureX, textureY).addBox(0, 0, 0, 2, 22, 2)
			.setRotationPoint(20, -44, -25).setRotationAngle(0, 0, 0).setName("Box 2")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 17, 1, textureX, textureY).addBox(0, 0, 0, 2, 22, 2)
			.setRotationPoint(20, -44, 23).setRotationAngle(0, 0, 0).setName("Box 3")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 33, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 5, 0, 0, -5, 0, 0, -5, 0, 0, 0, 0, 0, 0, 0, 0, 3, -2, 0, 3, -2, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(20, -49, -25).setRotationAngle(0, 0, 0).setName("Box 4")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 65, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 5, 0, 0, 0, 0, 0, 0, 0, 0, -5, 0, 0, -5, 0, 0, 0, 0, 0, 0, 0, 0, 3, -2, 0, 3, -2)
			.setRotationPoint(20, -49, 20).setRotationAngle(0, 0, 0).setName("Box 5")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 81, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 25, 2, 0, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f)
			.setRotationPoint(20, -47, -19).setRotationAngle(0, 0, 0).setName("Box 6")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 113, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 25, 2, 0, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f)
			.setRotationPoint(20, -47, 17).setRotationAngle(0, 0, 0).setName("Box 7")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 129, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 25, 2, 0, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f)
			.setRotationPoint(20, -47, -13).setRotationAngle(0, 0, 0).setName("Box 8")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 145, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 25, 2, 0, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f)
			.setRotationPoint(20, -47, 11).setRotationAngle(0, 0, 0).setName("Box 9")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 161, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 25, 2, 0, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f)
			.setRotationPoint(20, -47, -7).setRotationAngle(0, 0, 0).setName("Box 10")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 177, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 25, 2, 0, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f)
			.setRotationPoint(20, -47, 5).setRotationAngle(0, 0, 0).setName("Box 11")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 193, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 25, 2, 0, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f)
			.setRotationPoint(20, -47, -1).setRotationAngle(0, 0, 0).setName("Box 12")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 161, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 46, 0, 0, -0.25f, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, -0.25f, 0, 0, -0.25f, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, -0.25f, 0)
			.setRotationPoint(20.5f, -24, -23).setRotationAngle(0, 0, 0).setName("Box 13")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 257, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 46, 0, -0.5f, 0, 0, 0, -0.25f, 0, 0, -0.25f, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, -0.25f, 0, 0, -0.25f, 0, -0.5f, 0, 0)
			.setRotationPoint(20.5f, -24, -23).setRotationAngle(0, 0, 0).setName("Box 14")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 353, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 46, 0, 0, -0.25f, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, -0.25f, 0, 0, -0.25f, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, -0.25f, 0)
			.setRotationPoint(20.5f, -28, -23).setRotationAngle(0, 0, 0).setName("Box 15")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 409, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 46, 0, -0.5f, 0, 0, 0, -0.25f, 0, 0, -0.25f, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, -0.25f, 0, 0, -0.25f, 0, -0.5f, 0, 0)
			.setRotationPoint(20.5f, -28, -23).setRotationAngle(0, 0, 0).setName("Box 16")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 105, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 46, 0, 0, -0.25f, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, -0.25f, 0, 0, -0.25f, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, -0.25f, 0)
			.setRotationPoint(20.5f, -32, -23).setRotationAngle(0, 0, 0).setName("Box 17")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 161, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 46, 0, -0.5f, 0, 0, 0, -0.25f, 0, 0, -0.25f, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, -0.25f, 0, 0, -0.25f, 0, -0.5f, 0, 0)
			.setRotationPoint(20.5f, -32, -23).setRotationAngle(0, 0, 0).setName("Box 18")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 257, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 46, 0, 0, -0.25f, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, -0.25f, 0, 0, -0.25f, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, -0.25f, 0)
			.setRotationPoint(20.5f, -36, -23).setRotationAngle(0, 0, 0).setName("Box 19")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 353, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 46, 0, -0.5f, 0, 0, 0, -0.25f, 0, 0, -0.25f, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, -0.25f, 0, 0, -0.25f, 0, -0.5f, 0, 0)
			.setRotationPoint(20.5f, -36, -23).setRotationAngle(0, 0, 0).setName("Box 20")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 409, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 46, 0, 0, -0.25f, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, -0.25f, 0, 0, -0.25f, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, -0.25f, 0)
			.setRotationPoint(20.5f, -40, -23).setRotationAngle(0, 0, 0).setName("Box 21")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 46, 0, -0.5f, 0, 0, 0, -0.25f, 0, 0, -0.25f, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, -0.25f, 0, 0, -0.25f, 0, -0.5f, 0, 0)
			.setRotationPoint(20.5f, -40, -23).setRotationAngle(0, 0, 0).setName("Box 22")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 57, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 46, 0, 0, -0.25f, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, -0.25f, 0, 0, -0.25f, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, -0.25f, 0)
			.setRotationPoint(20.5f, -44, -23).setRotationAngle(0, 0, 0).setName("Box 23")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 113, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 46, 0, -0.5f, 0, 0, 0, -0.25f, 0, 0, -0.25f, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, -0.25f, 0, 0, -0.25f, 0, -0.5f, 0, 0)
			.setRotationPoint(20.5f, -44, -23).setRotationAngle(0, 0, 0).setName("Box 24")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 169, 105, textureX, textureY).addBox(0, 0, 0, 119, 3, 5)
			.setRotationPoint(-97, -14, -27).setRotationAngle(0, 0, 0).setName("Box 25")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 169, 121, textureX, textureY).addBox(0, 0, 0, 119, 3, 5)
			.setRotationPoint(-97, -14, 22).setRotationAngle(0, 0, 0).setName("Box 27")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 377, 105, textureX, textureY).addBox(0, 0, 0, 1, 3, 44)
			.setRotationPoint(-103, -14, -22).setRotationAngle(0, 0, 0).setName("Box 28")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 145, textureX, textureY).addBox(0, 0, 0, 122, 1, 44)
			.setRotationPoint(-102, -14, -22).setRotationAngle(0, 0, 0).setName("Box 29")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 217, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 3, 5, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-103, -14, -27).setRotationAngle(0, 0, 0).setName("Box 30")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 241, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 3, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0)
			.setRotationPoint(-103, -14, 22).setRotationAngle(0, 0, 0).setName("Box 31")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 297, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 1, 50, 0, -1, 0, -1, -1, 0, -1, -1, 0, -1, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(12, -23, -25).setRotationAngle(0, 0, 0).setName("Box 33")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 369, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 8, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(12, -22, -23).setRotationAngle(0, 0, 0).setName("Box 34")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 265, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 6, 3, 0, 0, 0, -0.75f, 0, 0, -0.75f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.75f, 0, 0, -0.75f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(10, -20, 24).setRotationAngle(0, 0, 0).setName("Box 36")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 281, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 6, 3, 0, 0, 0, -0.75f, 0, 0, -0.75f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.75f, 0, 0, -0.75f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-17, -20, 24).setRotationAngle(0, 0, 0).setName("Box 37")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 313, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 6, 3, 0, 0, 0, -0.75f, 0, 0, -0.75f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.75f, 0, 0, -0.75f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-45, -20, 24).setRotationAngle(0, 0, 0).setName("Box 38")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 329, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 6, 3, 0, 0, 0, -0.75f, 0, 0, -0.75f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.75f, 0, 0, -0.75f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-73, -20, 24).setRotationAngle(0, 0, 0).setName("Box 39")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 345, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 6, 3, 0, 0, 0, -0.75f, 0, 0, -0.75f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.75f, 0, 0, -0.75f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-100, -20, 24).setRotationAngle(0, 0, 0).setName("Box 40")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 361, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 6, 3, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.75f, 0, 0, -0.75f, 0, 0, 0, 0, 0, 0, 0, 0, -0.75f, 0, 0, -0.75f)
			.setRotationPoint(10, -20, -27).setRotationAngle(0, 0, 0).setName("Box 41")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 377, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 6, 3, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.75f, 0, 0, -0.75f, 0, 0, 0, 0, 0, 0, 0, 0, -0.75f, 0, 0, -0.75f)
			.setRotationPoint(-17, -20, -27).setRotationAngle(0, 0, 0).setName("Box 42")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 409, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 6, 3, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.75f, 0, 0, -0.75f, 0, 0, 0, 0, 0, 0, 0, 0, -0.75f, 0, 0, -0.75f)
			.setRotationPoint(-45, -20, -27).setRotationAngle(0, 0, 0).setName("Box 43")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 425, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 6, 3, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.75f, 0, 0, -0.75f, 0, 0, 0, 0, 0, 0, 0, 0, -0.75f, 0, 0, -0.75f)
			.setRotationPoint(-73, -20, -27).setRotationAngle(0, 0, 0).setName("Box 44")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 441, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 6, 3, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.75f, 0, 0, -0.75f, 0, 0, 0, 0, 0, 0, 0, 0, -0.75f, 0, 0, -0.75f)
			.setRotationPoint(-100, -20, -27).setRotationAngle(0, 0, 0).setName("Box 45")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 465, 1, textureX, textureY).addBox(0, 0, 0, 3, 1, 12)
			.setRotationPoint(-45, -3, -22).setRotationAngle(0, 0, 0).setName("Box 46")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 17, 17, textureX, textureY).addBox(0, 0, 0, 3, 1, 12)
			.setRotationPoint(-4, -3, -22).setRotationAngle(0, 0, 0).setName("Box 47")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 50, 2, 1, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(-48, -3.5f, -21.5f).setRotationAngle(0, 0, 0).setName("Box 48")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 50, 2, 1, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(-48, -3.5f, -20).setRotationAngle(0, 0, 0).setName("Box 49")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 169, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 50, 2, 1, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(-48, -3.5f, -18.5f).setRotationAngle(0, 0, 0).setName("Box 50")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 233, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 50, 2, 1, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(-48, -3.5f, -17).setRotationAngle(0, 0, 0).setName("Box 51")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 201, textureX, textureY)
			.addShapeBox(0, 0, 0, 50, 2, 1, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(-48, -3.5f, -15.5f).setRotationAngle(0, 0, 0).setName("Box 52")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 105, 201, textureX, textureY)
			.addShapeBox(0, 0, 0, 50, 2, 1, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(-48, -3.5f, -14).setRotationAngle(0, 0, 0).setName("Box 53")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 209, 201, textureX, textureY)
			.addShapeBox(0, 0, 0, 50, 2, 1, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(-48, -3.5f, -12.5f).setRotationAngle(0, 0, 0).setName("Box 54")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 97, 1, textureX, textureY).addBox(0, 0, 0, 1, 8, 2)
			.setRotationPoint(-3, -11, -21.5f).setRotationAngle(0, 0, 0).setName("Box 55")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 465, 1, textureX, textureY).addBox(0, 0, 0, 1, 8, 2)
			.setRotationPoint(-44, -11, -21.5f).setRotationAngle(0, 0, 0).setName("Box 56")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 289, 193, textureX, textureY).addBox(0, 0, 0, 2, 1, 48)
			.setRotationPoint(-103.5f, -12.5f, -24).setRotationAngle(0, 0, 0).setName("Box 57")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 233, 209, textureX, textureY)
			.addShapeBox(0, 0, 0, 50, 2, 1, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(-48, -3.5f, -23).setRotationAngle(0, 0, 0).setName("Box 61")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 273, 1, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(-9, -6, 20.5f).setRotationAngle(0, 0, 0).setName("Box 66")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 289, 1, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(-41, -6, 20.5f).setRotationAngle(0, 0, 0).setName("Box 67")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 409, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 8, 4, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(12, -22, -27).setRotationAngle(0, 0, 0).setName("Box 69")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 33, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 1, 0, 0, 0, -0.25f, 0, 0, -0.25f, 0, 0, 0, 0, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(12.5f, -17.5f, -26.5f).setRotationAngle(0, 0, 0).setName("Box 71")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 65, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, -0.25f, 0, 0, -0.25f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(15.25f, -17.5f, -26.5f).setRotationAngle(0, 0, 0).setName("Box 73")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 337, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, -0.25f, 0, 0, -0.25f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(16.5f, -15.5f, -27).setRotationAngle(0, 0, 0).setName("Box 77")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 457, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 6, 1, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0)
			.setRotationPoint(10, -22, 6).setRotationAngle(0, 0, 0).setName("Box 82")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 505, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 6, 1, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0)
			.setRotationPoint(10, -22, 17).setRotationAngle(0, 0, 0).setName("Box 83")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 481, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 6, 10, 0, 0, -2, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -2, 0, 0, -2, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -2, 0)
			.setRotationPoint(10.5f, -22, 7).setRotationAngle(0, 0, 0).setName("Box 84")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 33, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 3, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(11, -16, -4).setRotationAngle(0, 0, 0).setName("Box 85")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 65, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 3, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(11, -18, -4).setRotationAngle(0, 0, 0).setName("Box 86")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 273, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 3, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(11, -18, -9).setRotationAngle(0, 0, 0).setName("Box 87")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 289, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 3, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(11, -16, -9).setRotationAngle(0, 0, 0).setName("Box 88")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 353, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f)
			.setRotationPoint(11, -17, -3).setRotationAngle(0, 0, 0).setName("Box 89")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 369, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f)
			.setRotationPoint(11, -17, -8).setRotationAngle(0, 0, 0).setName("Box 90")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 497, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 6, 1, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0)
			.setRotationPoint(10, -22, -22).setRotationAngle(0, 0, 0).setName("Box 91")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 385, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 6, 3, 0, 0, -2, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -2, 0, 0, -2, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -2, 0)
			.setRotationPoint(10.5f, -22, -21).setRotationAngle(0, 0, 0).setName("Box 92")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 505, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 6, 1, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0)
			.setRotationPoint(10, -22, -18).setRotationAngle(0, 0, 0).setName("Box 93")
		);
		this.groups.add(chassis_core);
		//
		TurboList chassis_lights = new TurboList("chassis_lights");
		chassis_lights.add(new ModelRendererTurbo(chassis_lights, 489, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 3, 1, 0, 0, 0, -0.25f, 0, 0, -0.25f, 0, 0, 0, 0, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(12.5f, -21.5f, -25.5f).setRotationAngle(0, 0, 0).setName("Box 70")
		);
		chassis_lights.add(new ModelRendererTurbo(chassis_lights, 49, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, -0.25f, 0, 0, -0.25f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(14, -17.5f, -26.5f).setRotationAngle(0, 0, 0).setName("Box 72")
		);
		chassis_lights.add(new ModelRendererTurbo(chassis_lights, 217, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, -0.25f, 0, 0, -0.25f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(16.5f, -17.5f, -26.5f).setRotationAngle(0, 0, 0).setName("Box 74")
		);
		chassis_lights.add(new ModelRendererTurbo(chassis_lights, 241, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, -0.25f, 0, 0, -0.25f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(14, -15.5f, -27).setRotationAngle(0, 0, 0).setName("Box 75")
		);
		chassis_lights.add(new ModelRendererTurbo(chassis_lights, 321, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, -0.25f, 0, 0, -0.25f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(15.25f, -15.5f, -27).setRotationAngle(0, 0, 0).setName("Box 76")
		);
		chassis_lights.addProgram(DefaultPrograms.LIGHTS);
		this.groups.add(chassis_lights);
		//
		TurboList chassis_primary = new TurboList("chassis_primary");
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 169, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 110, 5, 2, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-99, -19, -27).setRotationAngle(0, 0, 0).setName("Box 32")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 110, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-99, -19, 25).setRotationAngle(0, 0, 0).setName("Box 35")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 217, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 30, 8, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, -3)
			.setRotationPoint(-22, -11, 13).setRotationAngle(0, 0, 0).setName("Box 63")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 313, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 30, 8, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, -3)
			.setRotationPoint(-54, -11, 13).setRotationAngle(0, 0, 0).setName("Box 64")
		);
		chassis_primary.addProgram(DefaultPrograms.RGB_SECONDARY);
		this.groups.add(chassis_primary);
		//
		TurboList tracks_in = new TurboList("tracks_in");
		tracks_in.add(new ModelRendererTurbo(tracks_in, 345, 217, textureX, textureY).addBox(0, 0, 0, 48, 1, 8)
			.setRotationPoint(-47, -4, -19.5f).setRotationAngle(0, 0, 0).setName("Box 60")
		);
		tracks_in.add(new ModelRendererTurbo(tracks_in, 1, 225, textureX, textureY).addBox(0, 0, 0, 48, 1, 8)
			.setRotationPoint(-47, -5, -19).setRotationAngle(0, 0, 0).setName("Box 62")
		);
		tracks_in.add(new ModelRendererTurbo(tracks_in, 1, 33, textureX, textureY).addBox(0, 0, 0, 4, 1, 8)
			.setRotationPoint(-34, -6, -19.5f).setRotationAngle(0, -0.06981317f, 0).setName("Box 80")
		);
		tracks_in.add(new ModelRendererTurbo(tracks_in, 161, 33, textureX, textureY).addBox(0, 0, 0, 4, 1, 8)
			.setRotationPoint(-26, -6, -19.5f).setRotationAngle(0, 0.10471976f, 0).setName("Box 81")
		);
		tracks_in.add(new ModelRendererTurbo(tracks_in, 65, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 6, 0, -0.2f, 0, -0.5f, -0.2f, 0, -0.5f, -0.2f, 0, -0.5f, -0.2f, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-102, -16, 15).setRotationAngle(0, 0, 0).setName("Box 94")
		);
		tracks_in.add(new ModelRendererTurbo(tracks_in, 497, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 6, 0, -0.2f, 0, -0.5f, -0.2f, 0, -0.5f, -0.2f, 0, -0.5f, -0.2f, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-102, -16, -21).setRotationAngle(0, 0, 0).setName("Box 95")
		);
		tracks_in.addProgram(new TurboList.Program(){
			@Override public String getId(){ return "fvp:t1_type2_out"; }
			@Override
			public void preRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
				list.visible = data.getScript(T1_2Script.class) == null ? false : !data.getScript(T1_2Script.class).out;
			}
			@Override public void postRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){ list.visible = true; }
		});
		this.groups.add(tracks_in);
		//
		TurboList tracks_out = new TurboList("tracks_out");
		tracks_out.add(new ModelRendererTurbo(tracks_out, 1, 209, textureX, textureY)
			.addShapeBox(0, 0, 0, 48, 1, 8, 0, 0, -22, 0, 0, 0, 0, 0, 0, 0, 0, -22, 0, 0, 22, 0, 0, 0, 0, 0, 0, 0, 0, 22, 0)
			.setRotationPoint(-151, -13.5f, -22).setRotationAngle(0, 0, 0).setName("Box 58")
		);
		tracks_out.add(new ModelRendererTurbo(tracks_out, 121, 209, textureX, textureY)
			.addShapeBox(0, 0, 0, 48, 1, 8, 0, 0, -22, 0, 0, 0, 0, 0, 0, 0, 0, -22, 0, 0, 22, 0, 0, 0, 0, 0, 0, 0, 0, 22, 0)
			.setRotationPoint(-151, -13.5f, 14).setRotationAngle(0, 0, 0).setName("Box 59")
		);
		tracks_out.add(new ModelRendererTurbo(tracks_out, 465, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 8, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0)
			.setRotationPoint(-155, 8.5f, -22).setRotationAngle(0, 0, 0).setName("Box 78")
		);
		tracks_out.add(new ModelRendererTurbo(tracks_out, 425, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 8, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0)
			.setRotationPoint(-155, 8.5f, 14).setRotationAngle(0, 0, 0).setName("Box 79")
		);
		tracks_out.addProgram(new TurboList.Program(){
			@Override public String getId(){ return "fvp:t1_type2_in"; }
			@Override
			public void preRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
				list.visible = data.getScript(T1_2Script.class) == null ? false : data.getScript(T1_2Script.class).out;
			}
			@Override public void postRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){ list.visible = true; }
		});
		this.groups.add(tracks_out);
	}

}