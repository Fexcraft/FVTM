//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.part.t1;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.4-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/part/t1_type4")
public class T1Type4 extends PartModel {

	public T1Type4(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList body_core = new TurboList("body_core");
		body_core.add(new ModelRendererTurbo(body_core, 1, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 4, 42, 0, 0, 0, -4, 0, 0, -4, 0, 0, -4, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(9, -16, -21).setRotationAngle(0, 0, 0).setName("Box 0")
		);
		body_core.add(new ModelRendererTurbo(body_core, 97, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 4, 42, 0, 0, 0, -4, 0, 0, -4, 0, 0, -4, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-93, -16, -21).setRotationAngle(0, 0, 0).setName("Box 1")
		);
		body_core.add(new ModelRendererTurbo(body_core, 193, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 4, 42, 0, 0, 0, -4, 0, 0, -4, 0, 0, -4, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-42, -16, -21).setRotationAngle(0, 0, 0).setName("Box 2")
		);
		body_core.add(new ModelRendererTurbo(body_core, 1, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 7, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 3, 0, 0, -3, 0, 0, -3)
			.setRotationPoint(-92, -20, -17).setRotationAngle(0, 0, 0).setName("Box 40")
		);
		body_core.add(new ModelRendererTurbo(body_core, 17, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 7, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 3, 0, 0, -3, 0, 0, -3)
			.setRotationPoint(-41, -20, -17).setRotationAngle(0, 0, 0).setName("Box 41")
		);
		body_core.add(new ModelRendererTurbo(body_core, 57, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 7, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 3, 0, 0, -3, 0, 0, -3)
			.setRotationPoint(10, -20, -17).setRotationAngle(0, 0, 0).setName("Box 42")
		);
		body_core.add(new ModelRendererTurbo(body_core, 73, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 7, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 3, 0, 0, 3)
			.setRotationPoint(-92, -20, 14).setRotationAngle(0, 0, 0).setName("Box 43")
		);
		body_core.add(new ModelRendererTurbo(body_core, 97, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 7, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 3, 0, 0, 3)
			.setRotationPoint(-41, -20, 14).setRotationAngle(0, 0, 0).setName("Box 44")
		);
		body_core.add(new ModelRendererTurbo(body_core, 113, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 7, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 3, 0, 0, 3)
			.setRotationPoint(10, -20, 14).setRotationAngle(0, 0, 0).setName("Box 45")
		);
		body_core.add(new ModelRendererTurbo(body_core, 9, 1, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(-101, -20, -6).setRotationAngle(0, 0, 0).setName("Box 46")
		);
		body_core.add(new ModelRendererTurbo(body_core, 25, 1, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(-101, -20, -12).setRotationAngle(0, 0, 0).setName("Box 47")
		);
		body_core.add(new ModelRendererTurbo(body_core, 33, 1, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(-101, -28, -12).setRotationAngle(0, 0, 0).setName("Box 48")
		);
		body_core.add(new ModelRendererTurbo(body_core, 65, 1, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(-101, -28, -6).setRotationAngle(0, 0, 0).setName("Box 49")
		);
		body_core.add(new ModelRendererTurbo(body_core, 105, 1, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(-101, -36, -12).setRotationAngle(0, 0, 0).setName("Box 50")
		);
		body_core.add(new ModelRendererTurbo(body_core, 121, 1, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(-101, -36, -6).setRotationAngle(0, 0, 0).setName("Box 51")
		);
		body_core.add(new ModelRendererTurbo(body_core, 129, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 9, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(-101, -50, -12).setRotationAngle(0, 0, 0).setName("Box 52")
		);
		body_core.add(new ModelRendererTurbo(body_core, 153, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 9, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(-101, -50, -6).setRotationAngle(0, 0, 0).setName("Box 53")
		);
		body_core.add(new ModelRendererTurbo(body_core, 161, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.25f, 0, 0, 0.25f, 0, 0, 0.25f, -0.5f, 0, 0.25f, -0.5f, 0)
			.setRotationPoint(-90, -49, -12).setRotationAngle(0, 0, 0).setName("Box 54")
		);
		body_core.add(new ModelRendererTurbo(body_core, 161, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 7, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(-102, -20, -12).setRotationAngle(0, 0, 0).setName("Box 55")
		);
		body_core.add(new ModelRendererTurbo(body_core, 193, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 7, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(-102, -28, -12).setRotationAngle(0, 0, 0).setName("Box 56")
		);
		body_core.add(new ModelRendererTurbo(body_core, 217, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 7, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(-102, -36, -12).setRotationAngle(0, 0, 0).setName("Box 57")
		);
		body_core.add(new ModelRendererTurbo(body_core, 25, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 7, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(-102, -44, -12).setRotationAngle(0, 0, 0).setName("Box 58")
		);
		body_core.add(new ModelRendererTurbo(body_core, 177, 1, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(-90, -50, -6).setRotationAngle(0, 0, 0).setName("Box 59")
		);
		body_core.add(new ModelRendererTurbo(body_core, 193, 1, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(-90, -50, -12).setRotationAngle(0, 0, 0).setName("Box 60")
		);
		body_core.add(new ModelRendererTurbo(body_core, 57, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-101, -51, -12).setRotationAngle(0, 0, 0).setName("Box 61")
		);
		body_core.add(new ModelRendererTurbo(body_core, 97, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-101, -51, -6).setRotationAngle(0, 0, 0).setName("Box 62")
		);
		body_core.add(new ModelRendererTurbo(body_core, 209, 1, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(-101, -20, 11).setRotationAngle(0, 0, 0).setName("Box 63")
		);
		body_core.add(new ModelRendererTurbo(body_core, 217, 1, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(-101, -20, 6).setRotationAngle(0, 0, 0).setName("Box 64")
		);
		body_core.add(new ModelRendererTurbo(body_core, 249, 1, textureX, textureY).addBox(0, 0, 0, 1, 5, 1)
			.setRotationPoint(-101, -29, 6).setRotationAngle(0, 0, 0).setName("Box 65")
		);
		body_core.add(new ModelRendererTurbo(body_core, 497, 1, textureX, textureY).addBox(0, 0, 0, 1, 5, 1)
			.setRotationPoint(-101, -29, 11).setRotationAngle(0, 0, 0).setName("Box 66")
		);
		body_core.add(new ModelRendererTurbo(body_core, 1, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 8, 8, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0)
			.setRotationPoint(-102, -26, 5).setRotationAngle(0, 0, 0).setName("Box 67")
		);
		body_core.add(new ModelRendererTurbo(body_core, 505, 1, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(-101, -34, 11).setRotationAngle(0, 0, 0).setName("Box 68")
		);
		body_core.add(new ModelRendererTurbo(body_core, 177, 9, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(-101, -34, 6).setRotationAngle(0, 0, 0).setName("Box 69")
		);
		body_core.add(new ModelRendererTurbo(body_core, 153, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 8, 8, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0)
			.setRotationPoint(-102, -35, 5).setRotationAngle(0, 0, 0).setName("Box 70")
		);
		body_core.add(new ModelRendererTurbo(body_core, 1, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 18, 3, 4, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-11, -49.5f, -10).setRotationAngle(0, 0, 0).setName("Box 71")
		);
		body_core.add(new ModelRendererTurbo(body_core, 49, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 18, 3, 4, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-11, -49.5f, 6).setRotationAngle(0, 0, 0).setName("Box 72")
		);
		body_core.add(new ModelRendererTurbo(body_core, 225, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 14, 2, 14, 0, -1, 0, -1, -1, 0, -1, -1, 0, -1, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-9, -51, -7).setRotationAngle(0, 0, 0).setName("Box 73")
		);
		body_core.add(new ModelRendererTurbo(body_core, 209, 9, textureX, textureY).addBox(0, 0, 0, 2, 1, 2)
			.setRotationPoint(-3, -52, -1).setRotationAngle(0, 0, 0).setName("Box 74")
		);
		body_core.add(new ModelRendererTurbo(body_core, 121, 17, textureX, textureY).addBox(0, 0, 0, 5, 1, 3)
			.setRotationPoint(-4.5f, -52.5f, -1.5f).setRotationAngle(0, 0, 0).setName("Box 75")
		);
		body_core.add(new ModelRendererTurbo(body_core, 497, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 1, 1, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-4.5f, -52.5f, -2.5f).setRotationAngle(0, 0, 0).setName("Box 76")
		);
		body_core.add(new ModelRendererTurbo(body_core, 169, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 1, 1, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0)
			.setRotationPoint(-4.5f, -52.5f, 1.5f).setRotationAngle(0, 0, 0).setName("Box 77")
		);
		body_core.add(new ModelRendererTurbo(body_core, 129, 201, textureX, textureY).addBox(0, 0, 0, 68, 1, 8)
			.setRotationPoint(-53, -11, 13).setRotationAngle(0, 0, 0).setName("Box 78")
		);
		body_core.add(new ModelRendererTurbo(body_core, 281, 209, textureX, textureY).addBox(0, 0, 0, 68, 1, 8)
			.setRotationPoint(-53, -2, 13).setRotationAngle(0, 0, 0).setName("Box 79")
		);
		body_core.add(new ModelRendererTurbo(body_core, 193, 17, textureX, textureY).addBox(0, 0, 0, 1, 8, 8)
			.setRotationPoint(-53, -10, 13).setRotationAngle(0, 0, 0).setName("Box 80")
		);
		body_core.add(new ModelRendererTurbo(body_core, 489, 33, textureX, textureY).addBox(0, 0, 0, 1, 8, 8)
			.setRotationPoint(14, -10, 13).setRotationAngle(0, 0, 0).setName("Box 81")
		);
		body_core.add(new ModelRendererTurbo(body_core, 1, 217, textureX, textureY).addBox(0, 0, 0, 66, 8, 1)
			.setRotationPoint(-52, -10, 13).setRotationAngle(0, 0, 0).setName("Box 82")
		);
		body_core.add(new ModelRendererTurbo(body_core, 137, 217, textureX, textureY).addBox(0, 0, 0, 66, 8, 1)
			.setRotationPoint(-52, -10, 19).setRotationAngle(0, 0, 0).setName("Box 83")
		);
		body_core.add(new ModelRendererTurbo(body_core, 481, 57, textureX, textureY).addBox(0, 0, 0, 2, 8, 7)
			.setRotationPoint(-20, -10, 14).setRotationAngle(0, 0, 0).setName("Box 84")
		);
		body_core.add(new ModelRendererTurbo(body_core, 481, 97, textureX, textureY).addBox(0, 0, 0, 2, 8, 7)
			.setRotationPoint(-3, -10, 14).setRotationAngle(0, 0, 0).setName("Box 85")
		);
		body_core.add(new ModelRendererTurbo(body_core, 481, 113, textureX, textureY).addBox(0, 0, 0, 2, 8, 7)
			.setRotationPoint(-37, -10, 14).setRotationAngle(0, 0, 0).setName("Box 86")
		);
		body_core.add(new ModelRendererTurbo(body_core, 273, 225, textureX, textureY).addBox(0, 0, 0, 66, 8, 1)
			.setRotationPoint(-52, -10, -13).setRotationAngle(0, 0, 0).setName("Box 89")
		);
		body_core.add(new ModelRendererTurbo(body_core, 1, 233, textureX, textureY).addBox(0, 0, 0, 68, 1, 8)
			.setRotationPoint(-53, -2, -20).setRotationAngle(0, 0, 0).setName("Box 90")
		);
		body_core.add(new ModelRendererTurbo(body_core, 1, 129, textureX, textureY).addBox(0, 0, 0, 1, 8, 8)
			.setRotationPoint(-53, -10, -20).setRotationAngle(0, 0, 0).setName("Box 91")
		);
		body_core.add(new ModelRendererTurbo(body_core, 153, 241, textureX, textureY).addBox(0, 0, 0, 68, 1, 8)
			.setRotationPoint(-53, -11, -20).setRotationAngle(0, 0, 0).setName("Box 92")
		);
		body_core.add(new ModelRendererTurbo(body_core, 49, 129, textureX, textureY).addBox(0, 0, 0, 1, 8, 8)
			.setRotationPoint(14, -10, -20).setRotationAngle(0, 0, 0).setName("Box 93")
		);
		body_core.add(new ModelRendererTurbo(body_core, 89, 129, textureX, textureY).addBox(0, 0, 0, 2, 8, 7)
			.setRotationPoint(-3, -10, -20).setRotationAngle(0, 0, 0).setName("Box 94")
		);
		body_core.add(new ModelRendererTurbo(body_core, 113, 129, textureX, textureY).addBox(0, 0, 0, 2, 8, 7)
			.setRotationPoint(-20, -10, -20).setRotationAngle(0, 0, 0).setName("Box 95")
		);
		body_core.add(new ModelRendererTurbo(body_core, 145, 129, textureX, textureY).addBox(0, 0, 0, 2, 8, 7)
			.setRotationPoint(-37, -10, -20).setRotationAngle(0, 0, 0).setName("Box 96")
		);
		body_core.add(new ModelRendererTurbo(body_core, 313, 241, textureX, textureY).addBox(0, 0, 0, 66, 8, 1)
			.setRotationPoint(-52, -10, -19).setRotationAngle(0, 0, 0).setName("Box 97")
		);
		body_core.add(new ModelRendererTurbo(body_core, 345, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 8, 16, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0)
			.setRotationPoint(-101, -43, -3).setRotationAngle(0, 0, 0).setName("Box 98")
		);
		body_core.add(new ModelRendererTurbo(body_core, 217, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(12, -43, 20.5f).setRotationAngle(0, 0, 0).setName("Box 99")
		);
		body_core.add(new ModelRendererTurbo(body_core, 225, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(-17, -43, 20.5f).setRotationAngle(0, 0, 0).setName("Box 100")
		);
		body_core.add(new ModelRendererTurbo(body_core, 209, 1, textureX, textureY).addBox(0, 0, 0, 1, 1, 5)
			.setRotationPoint(12, -43, 15.5f).setRotationAngle(0, 0, 0).setName("Box 101")
		);
		body_core.add(new ModelRendererTurbo(body_core, 9, 9, textureX, textureY).addBox(0, 0, 0, 1, 1, 5)
			.setRotationPoint(-17, -43, 15.5f).setRotationAngle(0, 0, 0).setName("Box 102")
		);
		body_core.add(new ModelRendererTurbo(body_core, 1, 185, textureX, textureY)
			.addShapeBox(0, 0, 0, 32, 12, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0, -0.8f)
			.setRotationPoint(-18, -44, 21.5f).setRotationAngle(0, 0, 0).setName("Box 103")
		);
		body_core.add(new ModelRendererTurbo(body_core, 369, 137, textureX, textureY).addBox(0, 0, 0, 18, 3, 12)
			.setRotationPoint(-11, -49.5f, -6).setRotationAngle(0, 0, 0).setName("Box 104")
		);
		this.groups.add(body_core);
		//
		TurboList body_secondary = new TurboList("body_secondary");
		body_secondary.add(new ModelRendererTurbo(body_secondary, 249, 1, textureX, textureY).addBox(0, 0, 0, 116, 1, 12)
			.setRotationPoint(-98, -14, -6).setRotationAngle(0, 0, 0).setName("Box 3")
		);
		body_secondary.add(new ModelRendererTurbo(body_secondary, 249, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 116, 1, 8, 0, 0, 4, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-98, -14, -14).setRotationAngle(0, 0, 0).setName("Box 4")
		);
		body_secondary.add(new ModelRendererTurbo(body_secondary, 249, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 116, 8, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, -4, 0, 0, 4, 0, 0, 4)
			.setRotationPoint(-98, -28, -21).setRotationAngle(0, 0, 0).setName("Box 5")
		);
		body_secondary.add(new ModelRendererTurbo(body_secondary, 1, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 116, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -3, 0, -1, -3, 0, -2, 2, 0, -2, 2)
			.setRotationPoint(-98, -20, -17).setRotationAngle(0, 0, 0).setName("Box 6")
		);
		body_secondary.add(new ModelRendererTurbo(body_secondary, 241, 49, textureX, textureY).addBox(0, 0, 0, 116, 6, 1)
			.setRotationPoint(-98, -34, -21).setRotationAngle(0, 0, 0).setName("Box 7")
		);
		body_secondary.add(new ModelRendererTurbo(body_secondary, 1, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 116, 8, 1, 0, 0, 0, -4, 0, 0, -4, 0, 0, 4, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-98, -42, -21).setRotationAngle(0, 0, 0).setName("Box 8")
		);
		body_secondary.add(new ModelRendererTurbo(body_secondary, 241, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 116, 4, 1, 0, 0, -1, -3, 0, -1, -3, 0, -2, 2, 0, -2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-98, -46, -17).setRotationAngle(0, 0, 0).setName("Box 9")
		);
		body_secondary.add(new ModelRendererTurbo(body_secondary, 233, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 116, 1, 8, 0, 0, -4, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-98, -49, -14).setRotationAngle(0, 0, 0).setName("Box 10")
		);
		body_secondary.add(new ModelRendererTurbo(body_secondary, 1, 81, textureX, textureY).addBox(0, 0, 0, 116, 1, 12)
			.setRotationPoint(-98, -49, -6).setRotationAngle(0, 0, 0).setName("Box 11")
		);
		body_secondary.add(new ModelRendererTurbo(body_secondary, 249, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 116, 1, 8, 0, 0, 4, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-98, -45, 6).setRotationAngle(0, 0, 0).setName("Box 12")
		);
		body_secondary.add(new ModelRendererTurbo(body_secondary, 1, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 116, 8, 1, 0, 0, 0, 4, 0, 0, 4, 0, 0, -4, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-98, -42, 20).setRotationAngle(0, 0, 0).setName("Box 13")
		);
		body_secondary.add(new ModelRendererTurbo(body_secondary, 241, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 116, 4, 1, 0, 0, -2, 2, 0, -2, 2, 0, -1, -3, 0, -1, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-98, -46, 16).setRotationAngle(0, 0, 0).setName("Box 14")
		);
		body_secondary.add(new ModelRendererTurbo(body_secondary, 241, 105, textureX, textureY).addBox(0, 0, 0, 116, 6, 1)
			.setRotationPoint(-98, -34, 20).setRotationAngle(0, 0, 0).setName("Box 15")
		);
		body_secondary.add(new ModelRendererTurbo(body_secondary, 1, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 116, 8, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 4, 0, 0, -4, 0, 0, -4)
			.setRotationPoint(-98, -28, 20).setRotationAngle(0, 0, 0).setName("Box 16")
		);
		body_secondary.add(new ModelRendererTurbo(body_secondary, 241, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 116, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 2, 0, -2, 2, 0, -1, -3, 0, -1, -3)
			.setRotationPoint(-98, -20, 16).setRotationAngle(0, 0, 0).setName("Box 17")
		);
		body_secondary.add(new ModelRendererTurbo(body_secondary, 233, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 116, 1, 8, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, -4, 0)
			.setRotationPoint(-98, -14, 6).setRotationAngle(0, 0, 0).setName("Box 18")
		);
		body_secondary.add(new ModelRendererTurbo(body_secondary, 57, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 28, 0, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, -2, -8, 0, 0, -8, 0, 0, -8, 0, -2, -8)
			.setRotationPoint(-100, -17, -14).setRotationAngle(0, 0, 0).setName("Box 19")
		);
		body_secondary.add(new ModelRendererTurbo(body_secondary, 153, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 34, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, -7, 0, 0, -3, 0, 0, -3, 0, 0, -7)
			.setRotationPoint(-100, -20, -17).setRotationAngle(0, 0, 0).setName("Box 20")
		);
		body_secondary.add(new ModelRendererTurbo(body_secondary, 1, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 8, 42, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -7, 0, 0, -4, 0, 0, -4, 0, 0, -7)
			.setRotationPoint(-100, -28, -21).setRotationAngle(0, 0, 0).setName("Box 21")
		);
		body_secondary.add(new ModelRendererTurbo(body_secondary, 97, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 6, 42, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2)
			.setRotationPoint(-100, -34, -21).setRotationAngle(0, 0, 0).setName("Box 22")
		);
		body_secondary.add(new ModelRendererTurbo(body_secondary, 145, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 8, 42, 0, 0, 0, -7, 0, 0, -4, 0, 0, -4, 0, 0, -7, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2)
			.setRotationPoint(-100, -42, -21).setRotationAngle(0, 0, 0).setName("Box 23")
		);
		body_secondary.add(new ModelRendererTurbo(body_secondary, 49, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 34, 0, 0, 0, -6, 0, 0, -3, 0, 0, -3, 0, 0, -6, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3)
			.setRotationPoint(-100, -45, -17).setRotationAngle(0, 0, 0).setName("Box 24")
		);
		body_secondary.add(new ModelRendererTurbo(body_secondary, 193, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 28, 0, 0, -2, -8, 0, 0, -8, 0, 0, -8, 0, -2, -8, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3)
			.setRotationPoint(-100, -49, -14).setRotationAngle(0, 0, 0).setName("Box 25")
		);
		body_secondary.add(new ModelRendererTurbo(body_secondary, 233, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 28, 0, 0, 0, 0, 0, 0, -4, 0, 0, -4, 0, 0, 0, 0, 0, -8, 0, -2, -8, 0, -2, -8, 0, 0, -8)
			.setRotationPoint(18, -17, -14).setRotationAngle(0, 0, 0).setName("Box 33")
		);
		body_secondary.add(new ModelRendererTurbo(body_secondary, 265, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 34, 0, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0, -3, 0, 0, -7, 0, 0, -7, 0, 0, -3)
			.setRotationPoint(18, -20, -17).setRotationAngle(0, 0, 0).setName("Box 34")
		);
		body_secondary.add(new ModelRendererTurbo(body_secondary, 297, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 8, 42, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, -4, 0, 0, -7, 0, 0, -7, 0, 0, -4)
			.setRotationPoint(18, -28, -21).setRotationAngle(0, 0, 0).setName("Box 35")
		);
		body_secondary.add(new ModelRendererTurbo(body_secondary, 393, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 6, 42, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0)
			.setRotationPoint(18, -34, -21).setRotationAngle(0, 0, 0).setName("Box 36")
		);
		body_secondary.add(new ModelRendererTurbo(body_secondary, 345, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 8, 42, 0, 0, 0, -4, 0, 0, -7, 0, 0, -7, 0, 0, -4, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0)
			.setRotationPoint(18, -42, -21).setRotationAngle(0, 0, 0).setName("Box 37")
		);
		body_secondary.add(new ModelRendererTurbo(body_secondary, 57, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 34, 0, 0, 0, -3, 0, 0, -6, 0, 0, -6, 0, 0, -3, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0)
			.setRotationPoint(18, -45, -17).setRotationAngle(0, 0, 0).setName("Box 38")
		);
		body_secondary.add(new ModelRendererTurbo(body_secondary, 441, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 28, 0, 0, 0, -8, 0, -2, -8, 0, -2, -8, 0, 0, -8, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0)
			.setRotationPoint(18, -49, -14).setRotationAngle(0, 0, 0).setName("Box 39")
		);
		body_secondary.addProgram(DefaultPrograms.RGB_SECONDARY);
		this.groups.add(body_secondary);
	}

}