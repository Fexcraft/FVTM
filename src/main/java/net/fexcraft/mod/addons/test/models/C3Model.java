//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.test.models;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.vehicle.VehicleModel;

/** This file was exported via the FVTM Exporter V1 of
 *  FMT (Fex's Modelling Toolbox) v.1.0.0-test &copy; 2018 - Fexcraft.net
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "test:models/c3")
public class C3Model extends VehicleModel {

	public C3Model(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand Calo' [FEX___96]");
		//
		TurboList group0 = new TurboList("group0");
		group0.add(new ModelRendererTurbo(group0, 1, 1, textureX, textureY).addBox(0, 0, 0, 64, 3, 48)
			.setRotationPoint(-31, -10, -24).setRotationAngle(0, 0, 0).setName("Box 0")
		);
		group0.add(new ModelRendererTurbo(group0, 233, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 5, 48, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0)
			.setRotationPoint(33, -12, -24).setRotationAngle(0, 0, 0).setName("Box 1")
		);
		group0.add(new ModelRendererTurbo(group0, 345, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 7, 48, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, -4, 0, 0, 0, 0)
			.setRotationPoint(37, -19, -24).setRotationAngle(0, 0, 0).setName("Box 2")
		);
		group0.add(new ModelRendererTurbo(group0, 1, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 3, 48, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(41, -19, -24).setRotationAngle(0, 0, 0).setName("Box 3")
		);
		group0.add(new ModelRendererTurbo(group0, 409, 9, textureX, textureY).addBox(0, 0, 0, 1, 2, 48)
			.setRotationPoint(45, -19, -24).setRotationAngle(0, 0, 0).setName("Box 5")
		);
		group0.add(new ModelRendererTurbo(group0, 113, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 3, 48, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(46, -19, -24).setRotationAngle(0, 0, 0).setName("Box 6")
		);
		group0.add(new ModelRendererTurbo(group0, 225, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 7, 48, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0)
			.setRotationPoint(50, -19, -24).setRotationAngle(0, 0, 0).setName("Box 7")
		);
		group0.add(new ModelRendererTurbo(group0, 337, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 5, 48, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0)
			.setRotationPoint(54, -12, -24).setRotationAngle(0, 0, 0).setName("Box 8")
		);
		group0.add(new ModelRendererTurbo(group0, 1, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 5, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0)
			.setRotationPoint(-35, -12, -24).setRotationAngle(0, 0, 0).setName("Box 9")
		);
		group0.add(new ModelRendererTurbo(group0, 185, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 7, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0)
			.setRotationPoint(-39, -19, -24).setRotationAngle(0, 0, 0).setName("Box 10")
		);
		group0.add(new ModelRendererTurbo(group0, 217, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 3, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(-43, -19, -24).setRotationAngle(0, 0, 0).setName("Box 11")
		);
		group0.add(new ModelRendererTurbo(group0, 249, 1, textureX, textureY).addBox(0, 0, 0, 1, 2, 8)
			.setRotationPoint(-44, -19, -24).setRotationAngle(0, 0, 0).setName("Box 12")
		);
		group0.add(new ModelRendererTurbo(group0, 297, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 3, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(-48, -19, -24).setRotationAngle(0, 0, 0).setName("Box 13")
		);
		group0.add(new ModelRendererTurbo(group0, 329, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 7, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, -4, 0, 0, 0, 0)
			.setRotationPoint(-52, -19, -24).setRotationAngle(0, 0, 0).setName("Box 14")
		);
		group0.add(new ModelRendererTurbo(group0, 361, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 5, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0)
			.setRotationPoint(-56, -12, -24).setRotationAngle(0, 0, 0).setName("Box 15")
		);
		group0.add(new ModelRendererTurbo(group0, 401, 65, textureX, textureY).addBox(0, 0, 0, 4, 7, 48)
			.setRotationPoint(33, -19, -24).setRotationAngle(0, 0, 0).setName("Box 16")
		);
		group0.add(new ModelRendererTurbo(group0, 1, 113, textureX, textureY).addBox(0, 0, 0, 4, 7, 48)
			.setRotationPoint(54, -19, -24).setRotationAngle(0, 0, 0).setName("Box 17")
		);
		group0.add(new ModelRendererTurbo(group0, 113, 113, textureX, textureY).addBox(0, 0, 0, 4, 9, 48)
			.setRotationPoint(-35, -21, -24).setRotationAngle(0, 0, 0).setName("Box 18")
		);
		group0.add(new ModelRendererTurbo(group0, 409, 1, textureX, textureY).addBox(0, 0, 0, 4, 7, 8)
			.setRotationPoint(-56, -19, -24).setRotationAngle(0, 0, 0).setName("Box 19")
		);
		group0.add(new ModelRendererTurbo(group0, 225, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 5, 48, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, -1, -1, 0, -1, -1, 0, 0, 0)
			.setRotationPoint(58, -12, -24).setRotationAngle(0, 0, 0).setName("Box 20")
		);
		group0.add(new ModelRendererTurbo(group0, 337, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 4, 48, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(58, -16, -24).setRotationAngle(0, 0, 0).setName("Box 21")
		);
		group0.add(new ModelRendererTurbo(group0, 465, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 7, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(57.5f, -19, -24).setRotationAngle(0, 0, 0).setName("Box 22")
		);
		group0.add(new ModelRendererTurbo(group0, 489, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(57.5f, -19, 17).setRotationAngle(0, 0, 0).setName("Box 24")
		);
		group0.add(new ModelRendererTurbo(group0, 65, 57, textureX, textureY).addBox(0, 0, 0, 3, 3, 34)
			.setRotationPoint(58, -19, -17).setRotationAngle(0, 0, 0).setName("Box 26")
		);
		group0.add(new ModelRendererTurbo(group0, 393, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 48, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(58, -21, -24).setRotationAngle(0, 0, 0).setName("Box 27")
		);
		group0.add(new ModelRendererTurbo(group0, 1, 169, textureX, textureY).addBox(0, 0, 0, 25, 2, 48)
			.setRotationPoint(33, -21, -24).setRotationAngle(0, 0, 0).setName("Box 28")
		);
		group0.add(new ModelRendererTurbo(group0, 185, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 25, 2, 16, 0, 0, 0, 0, 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(33, -23, -24).setRotationAngle(0, 0, 0).setName("Box 26")
		);
		group0.add(new ModelRendererTurbo(group0, 297, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 25, 2, 16, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(33, -23, 8).setRotationAngle(0, 0, 0).setName("Box 27")
		);
		group0.add(new ModelRendererTurbo(group0, 177, 57, textureX, textureY).addBox(0, 0, 0, 25, 2, 16)
			.setRotationPoint(33, -23, -8).setRotationAngle(0, 0, 0).setName("Box 28")
		);
		group0.add(new ModelRendererTurbo(group0, 1, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 16, 0, 0, -1, -1, -1, -1, -2, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(58, -23, -24).setRotationAngle(0, 0, 0).setName("Box 29")
		);
		group0.add(new ModelRendererTurbo(group0, 409, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 16, 0, 0, 0, 0, -1, -1, 0, -1, -1, -2, 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(58, -23, 8).setRotationAngle(0, 0, 0).setName("Box 31")
		);
		group0.add(new ModelRendererTurbo(group0, 25, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 6, 0, 0, 0, 0, -1, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(58, -23, -8).setRotationAngle(0, 0, 0).setName("Box 32")
		);
		group0.add(new ModelRendererTurbo(group0, 257, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 6, 0, 0, 0, 0, -1, 0, 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(58, -23, 2).setRotationAngle(0, 0, 0).setName("Box 34")
		);
		group0.add(new ModelRendererTurbo(group0, 25, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 4, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(58, -23, -2).setRotationAngle(0, 0, 0).setName("Box 35")
		);
		group0.add(new ModelRendererTurbo(group0, 177, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 5, 48, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, -1, -1)
			.setRotationPoint(-60, -12, -24).setRotationAngle(0, 0, 0).setName("Box 36")
		);
		group0.add(new ModelRendererTurbo(group0, 289, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 48, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(-59, -13, -24).setRotationAngle(0, 0, 0).setName("Box 37")
		);
		group0.add(new ModelRendererTurbo(group0, 465, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 7, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0)
			.setRotationPoint(-39, -19, 16).setRotationAngle(0, 0, 0).setName("Box 38")
		);
		group0.add(new ModelRendererTurbo(group0, 465, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 3, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(-43, -19, 16).setRotationAngle(0, 0, 0).setName("Box 39")
		);
		group0.add(new ModelRendererTurbo(group0, 433, 9, textureX, textureY).addBox(0, 0, 0, 1, 2, 8)
			.setRotationPoint(-44, -19, 16).setRotationAngle(0, 0, 0).setName("Box 40")
		);
		group0.add(new ModelRendererTurbo(group0, 1, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 3, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(-48, -19, 16).setRotationAngle(0, 0, 0).setName("Box 41")
		);
		group0.add(new ModelRendererTurbo(group0, 65, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 7, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, -4, 0, 0, 0, 0)
			.setRotationPoint(-52, -19, 16).setRotationAngle(0, 0, 0).setName("Box 42")
		);
		group0.add(new ModelRendererTurbo(group0, 113, 57, textureX, textureY).addBox(0, 0, 0, 4, 7, 8)
			.setRotationPoint(-56, -19, 16).setRotationAngle(0, 0, 0).setName("Box 43")
		);
		group0.add(new ModelRendererTurbo(group0, 105, 177, textureX, textureY).addBox(-1, 0, 0, 25, 2, 32)
			.setRotationPoint(-55, -9, -16).setRotationAngle(0, 0, 0).setName("Box 44")
		);
		group0.add(new ModelRendererTurbo(group0, 289, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 5, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0)
			.setRotationPoint(-35, -12, 16).setRotationAngle(0, 0, 0).setName("Box 45")
		);
		group0.add(new ModelRendererTurbo(group0, 321, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 5, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0)
			.setRotationPoint(-56, -12, 16).setRotationAngle(0, 0, 0).setName("Box 46")
		);
		group0.add(new ModelRendererTurbo(group0, 65, 113, textureX, textureY).addBox(0, 0, 0, 4, 4, 32)
			.setRotationPoint(-35, -12, -16).setRotationAngle(0, 0, 0).setName("Box 47")
		);
		group0.add(new ModelRendererTurbo(group0, 401, 65, textureX, textureY).addBox(0, 0, 0, 21, 11, 1)
			.setRotationPoint(-56, -19, -16).setRotationAngle(0, 0, 0).setName("Box 48")
		);
		group0.add(new ModelRendererTurbo(group0, 465, 65, textureX, textureY).addBox(0, 0, 0, 21, 11, 1)
			.setRotationPoint(-56, -19, 15).setRotationAngle(0, 0, 0).setName("Box 49")
		);
		group0.add(new ModelRendererTurbo(group0, 369, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(-58.5f, -19, 17).setRotationAngle(0, 0, 0).setName("Box 50")
		);
		group0.add(new ModelRendererTurbo(group0, 489, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 7, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-58.5f, -19, -24).setRotationAngle(0, 0, 0).setName("Box 51")
		);
		group0.add(new ModelRendererTurbo(group0, 353, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(-59, -16, 15).setRotationAngle(0, 0, 0).setName("Box 52")
		);
		group0.add(new ModelRendererTurbo(group0, 17, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 9, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-59, -16, -24).setRotationAngle(0, 0, 0).setName("Box 53")
		);
		group0.add(new ModelRendererTurbo(group0, 209, 1, textureX, textureY).addBox(0, 0, 0, 3, 3, 2)
			.setRotationPoint(-59, -19, 15).setRotationAngle(0, 0, 0).setName("Box 54")
		);
		group0.add(new ModelRendererTurbo(group0, 241, 1, textureX, textureY).addBox(0, 0, 0, 3, 3, 2)
			.setRotationPoint(-59, -19, -17).setRotationAngle(0, 0, 0).setName("Box 55")
		);
		group0.add(new ModelRendererTurbo(group0, 177, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 5, 30, 0, 0, 0, 0, 0, -4, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-56, -13, -15).setRotationAngle(0, 0, 0).setName("Box 56")
		);
		group0.add(new ModelRendererTurbo(group0, 289, 73, textureX, textureY).addBox(0, 0, 0, 21, 2, 9)
			.setRotationPoint(-56, -21, -24).setRotationAngle(0, 0, 0).setName("Box 57")
		);
		group0.add(new ModelRendererTurbo(group0, 177, 81, textureX, textureY).addBox(0, 0, 0, 21, 2, 9)
			.setRotationPoint(-56, -21, 15).setRotationAngle(0, 0, 0).setName("Box 58")
		);
		group0.add(new ModelRendererTurbo(group0, 129, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 9, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-59, -21, -24).setRotationAngle(0, 0, 0).setName("Box 59")
		);
		group0.add(new ModelRendererTurbo(group0, 1, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(-59, -21, 15).setRotationAngle(0, 0, 0).setName("Box 60")
		);
		group0.add(new ModelRendererTurbo(group0, 289, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 25, 2, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-56, -23, 15).setRotationAngle(0, 0, 0).setName("Box 61")
		);
		group0.add(new ModelRendererTurbo(group0, 289, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 25, 2, 9, 0, 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-56, -23, -24).setRotationAngle(0, 0, 0).setName("Box 62")
		);
		group0.add(new ModelRendererTurbo(group0, 241, 169, textureX, textureY).addBox(0, 0, 0, 4, 2, 30)
			.setRotationPoint(-35, -23, -15).setRotationAngle(0, 0, 0).setName("Box 63")
		);
		group0.add(new ModelRendererTurbo(group0, 65, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 9, 0, -1, -1, -2, 0, -1, -1, 0, 0, 0, -1, -1, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-59, -23, -24).setRotationAngle(0, 0, 0).setName("Box 64")
		);
		group0.add(new ModelRendererTurbo(group0, 113, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 9, 0, -1, -1, 0, 0, 0, 0, 0, -1, -1, -1, -1, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(-59, -23, 15).setRotationAngle(0, 0, 0).setName("Box 65")
		);
		group0.add(new ModelRendererTurbo(group0, 1, 17, textureX, textureY).addBox(0, 0, 0, 4, 11, 2)
			.setRotationPoint(29, -21, -24).setRotationAngle(0, 0, 0).setName("Box 66")
		);
		group0.add(new ModelRendererTurbo(group0, 185, 17, textureX, textureY).addBox(0, 0, 0, 4, 11, 2)
			.setRotationPoint(29, -21, 22).setRotationAngle(0, 0, 0).setName("Box 67")
		);
		group0.add(new ModelRendererTurbo(group0, 249, 57, textureX, textureY).addBox(0, 0, 0, 6, 11, 2)
			.setRotationPoint(-31, -21, 22).setRotationAngle(0, 0, 0).setName("Box 68")
		);
		group0.add(new ModelRendererTurbo(group0, 353, 73, textureX, textureY).addBox(0, 0, 0, 6, 11, 2)
			.setRotationPoint(-31, -21, -24).setRotationAngle(0, 0, 0).setName("Box 69")
		);
		group0.add(new ModelRendererTurbo(group0, 345, 177, textureX, textureY).addBox(0, 0, 0, 4, 2, 48)
			.setRotationPoint(29, -23, -24).setRotationAngle(0, 0, 0).setName("Box 70")
		);
		group0.add(new ModelRendererTurbo(group0, 105, 217, textureX, textureY).addBox(0, 0, 0, 6, 2, 48)
			.setRotationPoint(-31, -23, -24).setRotationAngle(0, 0, 0).setName("Box 71")
		);
		group0.add(new ModelRendererTurbo(group0, 289, 129, textureX, textureY).addBox(0, 0, 0, 16, 3, 16)
			.setRotationPoint(5, -13, 4).setRotationAngle(0, 0, 0).setName("Box 72")
		);
		group0.add(new ModelRendererTurbo(group0, 409, 177, textureX, textureY).addBox(0, 0, 0, 16, 3, 16)
			.setRotationPoint(5, -13, -20).setRotationAngle(0, 0, 0).setName("Box 73")
		);
		group0.add(new ModelRendererTurbo(group0, 1, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 16, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(2, -26, 4).setRotationAngle(0, 0, 0).setName("Box 74")
		);
		group0.add(new ModelRendererTurbo(group0, 393, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 16, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(2, -26, -20).setRotationAngle(0, 0, 0).setName("Box 75")
		);
		group0.add(new ModelRendererTurbo(group0, 217, 225, textureX, textureY).addBox(0, 0, 0, 16, 3, 40)
			.setRotationPoint(-20, -13, -20).setRotationAngle(0, 0, 0).setName("Box 76")
		);
		group0.add(new ModelRendererTurbo(group0, 417, 201, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 16, 40, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-23, -26, -20).setRotationAngle(0, 0, 0).setName("Box 77")
		);
		group0.add(new ModelRendererTurbo(group0, 233, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 4, 12, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0)
			.setRotationPoint(26, -21, 6).setRotationAngle(0, 0, 0).setName("Box 78")
		);
		group0.add(new ModelRendererTurbo(group0, 401, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 6, 6, 0, -6, 0, 0, 0, 0, 0, 0, 0, 0, -6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(21, -16, -3).setRotationAngle(0, 0, 0).setName("Box 79")
		);
		group0.add(new ModelRendererTurbo(group0, 465, 81, textureX, textureY).addBox(0, 0, 0, 6, 6, 6)
			.setRotationPoint(27, -22, -3).setRotationAngle(0, 0, 0).setName("Box 80")
		);
		group0.add(new ModelRendererTurbo(group0, 433, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 6, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(27, -23, -3).setRotationAngle(0, 0, 0).setName("Box 81")
		);
		group0.add(new ModelRendererTurbo(group0, 25, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 4, 4, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(22, -15, -2).setRotationAngle(0, 0, 0).setName("Box 83")
		);
		group0.add(new ModelRendererTurbo(group0, 1, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 11, 2, 4, 0, -5, 0, 0, 0, 0, 0, 0, 0, 0, -5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(7, -12, -2).setRotationAngle(0, 0, 0).setName("Box 84")
		);
		group0.add(new ModelRendererTurbo(group0, 337, 233, textureX, textureY).addBox(0, 0, 0, 21, 10, 32)
			.setRotationPoint(35, -17, -16).setRotationAngle(0, 0, 0).setName("Box 85")
		);
		group0.add(new ModelRendererTurbo(group0, 497, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 16, 2, 0, -12, 0, 0, 12, 0, 0, 12, 0, 0, -12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-31, -39, 22).setRotationAngle(0, 0, 0).setName("Box 86")
		);
		group0.add(new ModelRendererTurbo(group0, 145, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 16, 2, 0, -12, 0, 0, 12, 0, 0, 12, 0, 0, -12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-31, -39, -24).setRotationAngle(0, 0, 0).setName("Box 84")
		);
		group0.add(new ModelRendererTurbo(group0, 497, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 16, 2, 0, 12, 0, 0, -12, 0, 0, -12, 0, 0, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(31, -39, 22).setRotationAngle(0, 0, 0).setName("Box 85")
		);
		group0.add(new ModelRendererTurbo(group0, 65, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 16, 2, 0, 12, 0, 0, -12, 0, 0, -12, 0, 0, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(31, -39, -24).setRotationAngle(0, 0, 0).setName("Box 86")
		);
		group0.add(new ModelRendererTurbo(group0, 1, 273, textureX, textureY)
			.addShapeBox(0, 0, 0, 40, 1, 48, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-19, -40, -24).setRotationAngle(0, 0, 0).setName("Box 87")
		);
		group0.add(new ModelRendererTurbo(group0, 1, 225, textureX, textureY).addBox(0, 0, 0, 3, 3, 42)
			.setRotationPoint(44, -9, -21).setRotationAngle(0, 0, 0).setName("Box 88")
		);
		group0.add(new ModelRendererTurbo(group0, 409, 265, textureX, textureY).addBox(0, 0, 0, 3, 3, 42)
			.setRotationPoint(-45, -9, -21).setRotationAngle(0, 0, 0).setName("Box 89")
		);
		group0.add(new ModelRendererTurbo(group0, 265, 1, textureX, textureY).addBox(0, 0, 0, 5, 2, 2)
			.setRotationPoint(-60.5f, -9, 13).setRotationAngle(0, 0, 0).setName("Box 90")
		);
		group0.add(new ModelRendererTurbo(group0, 321, 1, textureX, textureY).addBox(0, 0, 0, 5, 2, 2)
			.setRotationPoint(-60.5f, -9, 10.5f).setRotationAngle(0, 0, 0).setName("Box 91")
		);
		group0.add(new ModelRendererTurbo(group0, 113, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 6, 13, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0)
			.setRotationPoint(27, -22, -19).setRotationAngle(0, 0, 0).setName("Box 92")
		);
		group0.add(new ModelRendererTurbo(group0, 353, 1, textureX, textureY).addBox(0, 0, 0, 5, 1, 1)
			.setRotationPoint(13, -12, -0.5f).setRotationAngle(0, 0, -0.31415927f).setName("Box 93")
		);
		group0.add(new ModelRendererTurbo(group0, 1, 1, textureX, textureY).addBox(0, 0, 0, 1, 4, 1)
			.setRotationPoint(23, -18, -0.5f).setRotationAngle(0, 0, -0.08726646f).setName("Box 94")
		);
		group0.add(new ModelRendererTurbo(group0, 81, 113, textureX, textureY).addBox(0, 0, 0, 3, 29, 1)
			.setRotationPoint(0, -39, 22).setRotationAngle(0, 0, 0).setName("Box 95")
		);
		group0.add(new ModelRendererTurbo(group0, 257, 113, textureX, textureY).addBox(0, 0, 0, 3, 29, 1)
			.setRotationPoint(0, -39, -23).setRotationAngle(0, 0, 0).setName("Box 96")
		);
		group0.add(new ModelRendererTurbo(group0, 377, 73, textureX, textureY).addBox(0, 0, 0, 1, 29, 1)
			.setRotationPoint(1, -39, 23).setRotationAngle(0, 0, 0).setName("Box 97")
		);
		group0.add(new ModelRendererTurbo(group0, 41, 113, textureX, textureY).addBox(0, 0, 0, 1, 29, 1)
			.setRotationPoint(1, -39, -24).setRotationAngle(0, 0, 0).setName("Box 98")
		);
		group0.add(new ModelRendererTurbo(group0, 449, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 2, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(29, -26, -24).setRotationAngle(0, 0, 0).setName("Box 99")
		);
		group0.add(new ModelRendererTurbo(group0, 481, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 2, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(29, -26, 22).setRotationAngle(0, 0, 0).setName("Box 101")
		);
		group0.add(new ModelRendererTurbo(group0, 297, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 6, 2, 0, 0, -6, 0, 0, 0, 0, 0, 0, 0, 0, -6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-29, -29, 22).setRotationAngle(0, 0, 0).setName("Box 102")
		);
		group0.add(new ModelRendererTurbo(group0, 409, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 6, 2, 0, 0, -6, 0, 0, 0, 0, 0, 0, 0, 0, -6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-29, -29, -24).setRotationAngle(0, 0, 0).setName("Box 103")
		);
		group0.add(new ModelRendererTurbo(group0, 289, 233, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 16, 44, 0, 12, 0, 0, -12, 0, 0, -12, 0, 0, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(31, -39, -22).setRotationAngle(0, 0, 0).setName("Box 104")
		);
		group0.add(new ModelRendererTurbo(group0, 185, 273, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 16, 44, 0, -12, 0, 0, 12, 0, 0, 12, 0, 0, -12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-30, -39, -22).setRotationAngle(0, 0, 0).setName("Box 105")
		);
		group0.add(new ModelRendererTurbo(group0, 41, 1, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(3, -27, 9).setRotationAngle(0, 0, 0).setName("Box 106")
		);
		group0.add(new ModelRendererTurbo(group0, 185, 1, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(3, -27, 14).setRotationAngle(0, 0, 0).setName("Box 107")
		);
		group0.add(new ModelRendererTurbo(group0, 1, 89, textureX, textureY).addBox(0, 0, 0, 2, 4, 8)
			.setRotationPoint(2.5f, -31, 8).setRotationAngle(0, 0, 0).setName("Box 108")
		);
		group0.add(new ModelRendererTurbo(group0, 297, 1, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(3, -27, -10).setRotationAngle(0, 0, 0).setName("Box 109")
		);
		group0.add(new ModelRendererTurbo(group0, 385, 1, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(3, -27, -15).setRotationAngle(0, 0, 0).setName("Box 110")
		);
		group0.add(new ModelRendererTurbo(group0, 465, 97, textureX, textureY).addBox(0, 0, 0, 2, 4, 8)
			.setRotationPoint(2.5f, -31, -16).setRotationAngle(0, 0, 0).setName("Box 111")
		);
		group0.add(new ModelRendererTurbo(group0, 481, 89, textureX, textureY).addBox(0, 0, 0, 1, 3, 12)
			.setRotationPoint(61.2f, -11.5f, -6).setRotationAngle(0, 0, 0).setName("Box 118")
		);
		group0.add(new ModelRendererTurbo(group0, 241, 9, textureX, textureY).addBox(0, 0, 0, 1, 1, 4)
			.setRotationPoint(45, -8, 20.5f).setRotationAngle(0, 0, 0).setName("Box 149")
		);
		group0.add(new ModelRendererTurbo(group0, 265, 33, textureX, textureY).addBox(0, 0, 0, 1, 1, 4)
			.setRotationPoint(45, -8, -24.5f).setRotationAngle(0, 0, 0).setName("Box 150")
		);
		group0.add(new ModelRendererTurbo(group0, 489, 33, textureX, textureY).addBox(-1, 0, 0, 1, 1, 4)
			.setRotationPoint(-43, -8, -24.5f).setRotationAngle(0, 0, 0).setName("Box 151")
		);
		group0.add(new ModelRendererTurbo(group0, 33, 41, textureX, textureY).addBox(-1, 0, 0, 1, 1, 4)
			.setRotationPoint(-43, -8, 20.5f).setRotationAngle(0, 0, 0).setName("Box 152")
		);
		group0.add(new ModelRendererTurbo(group0, 345, 57, textureX, textureY).addBox(0, 0, 0, 4, 2, 2)
			.setRotationPoint(23, -24.5f, 11).setRotationAngle(0, 0, 0.34906584f).setName("Box 194")
		);
		group0.add(new ModelRendererTurbo(group0, 361, 113, textureX, textureY).addBox(0, -3, -3, 1, 7, 7)
			.setRotationPoint(22.5f, -24, 11.5f).setRotationAngle(0, 0, 0.34906584f).setName("Box 195")
		);
		group0.addProgram("fvtm:example_program");//TODO do not forget these exists!
		this.groups.add(group0);
		//
		TurboList group1 = new TurboList("group1");
		group1.add(new ModelRendererTurbo(group1, 41, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 11, 1, 0, -8, 0, 0, 8, 0, 0, 8, 0, 0, -8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(1, -39, -49).setRotationAngle(0, -1.5707964f, 0).setName("Box 144")
		);
		group1.add(new ModelRendererTurbo(group1, 361, 313, textureX, textureY).addBox(0, 0, 0, 21, 1, 30)
			.setRotationPoint(-49, -37, -15).setRotationAngle(0, 0, 0.7853982f).setName("Box 177")
		);
		group1.add(new ModelRendererTurbo(group1, 441, 321, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 30, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(-51, -39, -15).setRotationAngle(0, 0, 0.7853982f).setName("Box 178")
		);
		group1.add(new ModelRendererTurbo(group1, 1, 329, textureX, textureY).addBox(0, 0, 0, 1, 8, 30)
			.setRotationPoint(-52, -38, -15).setRotationAngle(0, 0, 0.7679449f).setName("Box 179")
		);
		group1.add(new ModelRendererTurbo(group1, 177, 113, textureX, textureY).addBox(0, 0, 0, 1, 3, 12)
			.setRotationPoint(-54.7f, -35.5f, -6).setRotationAngle(0, 0, 0.80285144f).setName("Box 180")
		);
		group1.add(new ModelRendererTurbo(group1, 225, 113, textureX, textureY).addBox(0, 0, 0, 1, 1, 14)
			.setRotationPoint(-54.3f, -36.5f, -7).setRotationAngle(0, 0, 0.7679449f).setName("Box 181")
		);
		group1.add(new ModelRendererTurbo(group1, 385, 281, textureX, textureY).addBox(0, 0, 0, 27, 13, 1)
			.setRotationPoint(28, -23, 50).setRotationAngle(0, 1.5707964f, 0).setName("Box 170")
		);
		group1.add(new ModelRendererTurbo(group1, 465, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(28.5f, -21, 47).setRotationAngle(0, 1.5707964f, 0).setName("Box 171")
		);
		group1.add(new ModelRendererTurbo(group1, 393, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 16, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(28, -39, 50).setRotationAngle(0, 1.5707964f, 0).setName("Box 172")
		);
		group1.add(new ModelRendererTurbo(group1, 113, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 16, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(28, -39, 50).setRotationAngle(0, 1.5707964f, 0).setName("Box 174")
		);
		group1.add(new ModelRendererTurbo(group1, 41, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(28, -26, 25).setRotationAngle(0, 1.5707964f, 0).setName("Box 175")
		);
		group1.add(new ModelRendererTurbo(group1, 145, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 13, 1, 0, 10, 0, 0, -10, 0, 0, -10, 0, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(28, -39, 25).setRotationAngle(0, 1.5707964f, 0).setName("Box 176")
		);
		group1.add(new ModelRendererTurbo(group1, 137, 289, textureX, textureY).addBox(0, 0, 0, 26, 13, 1)
			.setRotationPoint(0, -23, 49).setRotationAngle(0, 1.5707964f, 0).setName("Box 178")
		);
		group1.add(new ModelRendererTurbo(group1, 89, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(0.5f, -21, 46).setRotationAngle(0, 1.5707964f, 0).setName("Box 179")
		);
		group1.add(new ModelRendererTurbo(group1, 153, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 11, 1, 0, -8, 0, 0, 8, 0, 0, 8, 0, 0, -8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(0, -39, 49).setRotationAngle(0, 1.5707964f, 0).setName("Box 178")
		);
		group1.add(new ModelRendererTurbo(group1, 345, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 17, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(0, -39, 41).setRotationAngle(0, 1.5707964f, 0).setName("Box 179")
		);
		group1.add(new ModelRendererTurbo(group1, 433, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 16, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(0, -39, 24).setRotationAngle(0, 1.5707964f, 0).setName("Box 180")
		);
		group1.add(new ModelRendererTurbo(group1, 449, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(0, -28, 49).setRotationAngle(0, 1.5707964f, 0).setName("Box 181")
		);
		group1.add(new ModelRendererTurbo(group1, 233, 297, textureX, textureY).addBox(0, 0, 0, 27, 13, 1)
			.setRotationPoint(29, -23, -50).setRotationAngle(0, -1.5707964f, 0).setName("Box 182")
		);
		group1.add(new ModelRendererTurbo(group1, 177, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(29.5f, -21, -47).setRotationAngle(0, -1.5707964f, 0).setName("Box 183")
		);
		group1.add(new ModelRendererTurbo(group1, 449, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 16, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(29, -39, -50).setRotationAngle(0, -1.5707964f, 0).setName("Box 184")
		);
		group1.add(new ModelRendererTurbo(group1, 1, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 16, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(29, -39, -50).setRotationAngle(0, -1.5707964f, 0).setName("Box 185")
		);
		group1.add(new ModelRendererTurbo(group1, 1, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 13, 1, 0, 10, 0, 0, -10, 0, 0, -10, 0, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(29, -39, -25).setRotationAngle(0, -1.5707964f, 0).setName("Box 186")
		);
		group1.add(new ModelRendererTurbo(group1, 273, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(29, -26, -25).setRotationAngle(0, -1.5707964f, 0).setName("Box 187")
		);
		group1.add(new ModelRendererTurbo(group1, 41, 329, textureX, textureY).addBox(0, 0, 0, 26, 13, 1)
			.setRotationPoint(1, -23, -49).setRotationAngle(0, -1.5707964f, 0).setName("Box 188")
		);
		group1.add(new ModelRendererTurbo(group1, 369, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(1, -28, -49).setRotationAngle(0, -1.5707964f, 0).setName("Box 189")
		);
		group1.add(new ModelRendererTurbo(group1, 65, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 17, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(1, -39, -41).setRotationAngle(0, -1.5707964f, 0).setName("Box 191")
		);
		group1.add(new ModelRendererTurbo(group1, 457, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 16, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(1, -39, -24).setRotationAngle(0, -1.5707964f, 0).setName("Box 192")
		);
		group1.add(new ModelRendererTurbo(group1, 313, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(1.5f, -21, -47).setRotationAngle(0, -1.5707964f, 0).setName("Box 193")
		);
		this.groups.add(group1);
		//
		TurboList group2 = new TurboList("group2");
		group2.add(new ModelRendererTurbo(group2, 281, 297, textureX, textureY).addBox(0, 0, 0, 21, 1, 30)
			.setRotationPoint(-56, -23, -15).setRotationAngle(0, 0, 0).setName("Box 113")
		);
		group2.add(new ModelRendererTurbo(group2, 449, 121, textureX, textureY).addBox(0, 0, 0, 1, 8, 30)
			.setRotationPoint(-59, -21, -15).setRotationAngle(0, 0, 0).setName("Box 114")
		);
		group2.add(new ModelRendererTurbo(group2, 57, 225, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 30, 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, -1, -1, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(-59, -23, -15).setRotationAngle(0, 0, 0).setName("Box 115")
		);
		group2.add(new ModelRendererTurbo(group2, 345, 89, textureX, textureY).addBox(0, 0, 0, 1, 1, 14)
			.setRotationPoint(-59.5f, -18, -7).setRotationAngle(0, 0, 0).setName("Box 116")
		);
		group2.add(new ModelRendererTurbo(group2, 129, 89, textureX, textureY).addBox(0, 0, 0, 1, 3, 12)
			.setRotationPoint(-59.2f, -17, -6).setRotationAngle(0, 0, 0).setName("Box 117")
		);
		group2.add(new ModelRendererTurbo(group2, 169, 225, textureX, textureY).addBox(0, 0, 0, 27, 13, 1)
			.setRotationPoint(2, -23, 23).setRotationAngle(0, 0, 0).setName("Box 119")
		);
		group2.add(new ModelRendererTurbo(group2, 281, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 24, 12, 1, 0, 0, 0, 0, -9, 0, 0, -9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(3, -38, 23).setRotationAngle(0, 0, 0).setName("Box 121")
		);
		group2.add(new ModelRendererTurbo(group2, 185, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 24, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(3, -26, 23).setRotationAngle(0, 0, 0).setName("Box 126")
		);
		group2.add(new ModelRendererTurbo(group2, 41, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 16, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(2, -39, 23).setRotationAngle(0, 0, 0).setName("Box 127")
		);
		group2.add(new ModelRendererTurbo(group2, 409, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(27, -26, 23).setRotationAngle(0, 0, 0).setName("Box 128")
		);
		group2.add(new ModelRendererTurbo(group2, 449, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 13, 1, 0, 10, 0, 0, -10, 0, 0, -10, 0, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(27, -39, 23).setRotationAngle(0, 0, 0).setName("Box 129")
		);
		group2.add(new ModelRendererTurbo(group2, 241, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 16, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(2, -39, 23).setRotationAngle(0, 0, 0).setName("Box 130")
		);
		group2.add(new ModelRendererTurbo(group2, 25, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(5, -21, 23.5f).setRotationAngle(0, 0, 0).setName("Box 131")
		);
		group2.add(new ModelRendererTurbo(group2, 169, 241, textureX, textureY).addBox(0, 0, 0, 27, 13, 1)
			.setRotationPoint(2, -23, -24).setRotationAngle(0, 0, 0).setName("Box 132")
		);
		group2.add(new ModelRendererTurbo(group2, 297, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 24, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(3, -26, -24).setRotationAngle(0, 0, 0).setName("Box 133")
		);
		group2.add(new ModelRendererTurbo(group2, 265, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 16, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(2, -39, -24).setRotationAngle(0, 0, 0).setName("Box 134")
		);
		group2.add(new ModelRendererTurbo(group2, 465, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(27, -26, -24).setRotationAngle(0, 0, 0).setName("Box 135")
		);
		group2.add(new ModelRendererTurbo(group2, 385, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 13, 1, 0, 10, 0, 0, -10, 0, 0, -10, 0, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(27, -39, -24).setRotationAngle(0, 0, 0).setName("Box 136")
		);
		group2.add(new ModelRendererTurbo(group2, 409, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 16, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(2, -39, -24).setRotationAngle(0, 0, 0).setName("Box 137")
		);
		group2.add(new ModelRendererTurbo(group2, 281, 185, textureX, textureY)
			.addShapeBox(0, 0, 0, 24, 12, 1, 0, 0, 0, 0, -9, 0, 0, -9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(3, -38, -24).setRotationAngle(0, 0, 0).setName("Box 138")
		);
		group2.add(new ModelRendererTurbo(group2, 433, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(5, -21, -24.5f).setRotationAngle(0, 0, 0).setName("Box 132")
		);
		group2.add(new ModelRendererTurbo(group2, 97, 225, textureX, textureY).addBox(0, 0, 0, 26, 13, 1)
			.setRotationPoint(-25, -23, 23).setRotationAngle(0, 0, 0).setName("Box 133")
		);
		group2.add(new ModelRendererTurbo(group2, 137, 273, textureX, textureY).addBox(0, 0, 0, 26, 13, 1)
			.setRotationPoint(-25, -23, -24).setRotationAngle(0, 0, 0).setName("Box 134")
		);
		group2.add(new ModelRendererTurbo(group2, 353, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-22, -21, 23.5f).setRotationAngle(0, 0, 0).setName("Box 135")
		);
		group2.add(new ModelRendererTurbo(group2, 369, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-22, -21, -24.5f).setRotationAngle(0, 0, 0).setName("Box 136")
		);
		group2.add(new ModelRendererTurbo(group2, 441, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 16, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(0, -39, 23).setRotationAngle(0, 0, 0).setName("Box 137")
		);
		group2.add(new ModelRendererTurbo(group2, 153, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 16, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(0, -39, -24).setRotationAngle(0, 0, 0).setName("Box 138")
		);
		group2.add(new ModelRendererTurbo(group2, 65, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 24, 5, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-24, -28, 23).setRotationAngle(0, 0, 0).setName("Box 139")
		);
		group2.add(new ModelRendererTurbo(group2, 505, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-25, -28, 23).setRotationAngle(0, 0, 0).setName("Box 140")
		);
		group2.add(new ModelRendererTurbo(group2, 273, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-25, -28, -24).setRotationAngle(0, 0, 0).setName("Box 141")
		);
		group2.add(new ModelRendererTurbo(group2, 177, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 24, 5, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-24, -28, -24).setRotationAngle(0, 0, 0).setName("Box 142")
		);
		group2.add(new ModelRendererTurbo(group2, 33, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 11, 1, 0, -8, 0, 0, 8, 0, 0, 8, 0, 0, -8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-25, -39, 23).setRotationAngle(0, 0, 0).setName("Box 143")
		);
		group2.add(new ModelRendererTurbo(group2, 401, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 17, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-17, -39, 23).setRotationAngle(0, 0, 0).setName("Box 145")
		);
		group2.add(new ModelRendererTurbo(group2, 345, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 17, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-17, -39, -24).setRotationAngle(0, 0, 0).setName("Box 146")
		);
		group2.add(new ModelRendererTurbo(group2, 97, 241, textureX, textureY)
			.addShapeBox(0, 0, 0, 24, 10, 1, 0, -7, 0, 0, 0, 0, 0, 0, 0, 0, -7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-24, -38, 23).setRotationAngle(0, 0, 0).setName("Box 147")
		);
		group2.add(new ModelRendererTurbo(group2, 233, 273, textureX, textureY)
			.addShapeBox(0, 0, 0, 24, 10, 1, 0, -7, 0, 0, 0, 0, 0, 0, 0, 0, -7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-24, -38, -24).setRotationAngle(0, 0, 0).setName("Box 148")
		);
		group2.add(new ModelRendererTurbo(group2, 369, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 11, 1, 0, -8, 0, 0, 8, 0, 0, 8, 0, 0, -8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-25, -39, -24).setRotationAngle(0, 0, 0).setName("Box 190")
		);
		this.groups.add(group2);
		//
		TurboList group5 = new TurboList("group5");
		group5.add(new ModelRendererTurbo(group5, 465, 177, textureX, textureY).addBox(-8, -2, 0, 17, 5, 5)
			.setRotationPoint(45, -8, -24).setRotationAngle(0, 0, 0).setName("Box 162")
		);
		group5.add(new ModelRendererTurbo(group5, 345, 201, textureX, textureY)
			.addShapeBox(-8, 3, 0, 17, 6, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -6, 0, 0, -6, 0, 0, -6, 0, 0, -6, 0, 0)
			.setRotationPoint(45, -8, -24).setRotationAngle(0, 0, 0).setName("Box 184")
		);
		group5.add(new ModelRendererTurbo(group5, 409, 201, textureX, textureY)
			.addShapeBox(-8, -8, 0, 17, 6, 5, 0, -6, 0, 0, -6, 0, 0, -6, 0, 0, -6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(45, -8, -24).setRotationAngle(0, 0, 0).setName("Box 185")
		);
		this.groups.add(group5);
		//
		TurboList group6 = new TurboList("group6");
		group6.add(new ModelRendererTurbo(group6, 1, 169, textureX, textureY).addBox(-8, -2, 0, 17, 5, 5)
			.setRotationPoint(45, -8, 19).setRotationAngle(0, 0, 0).setName("Box 156")
		);
		group6.add(new ModelRendererTurbo(group6, 345, 169, textureX, textureY)
			.addShapeBox(-8, 3, 0, 17, 6, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -6, 0, 0, -6, 0, 0, -6, 0, 0, -6, 0, 0)
			.setRotationPoint(45, -8, 19).setRotationAngle(0, 0, 0).setName("Box 159")
		);
		group6.add(new ModelRendererTurbo(group6, 1, 201, textureX, textureY)
			.addShapeBox(-8, -8, 0, 17, 6, 5, 0, -6, 0, 0, -6, 0, 0, -6, 0, 0, -6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(45, -8, 19).setRotationAngle(0, 0, 0).setName("Box 183")
		);
		this.groups.add(group6);
		//
		TurboList group7 = new TurboList("group7");
		group7.add(new ModelRendererTurbo(group7, 345, 185, textureX, textureY).addBox(-8, -2, 0, 17, 5, 5)
			.setRotationPoint(-44, -8, -24).setRotationAngle(0, 0, 0).setName("Box 173")
		);
		group7.add(new ModelRendererTurbo(group7, 465, 201, textureX, textureY)
			.addShapeBox(-8, -8, 0, 17, 6, 5, 0, -6, 0, 0, -6, 0, 0, -6, 0, 0, -6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-44, -8, -24).setRotationAngle(0, 0, 0).setName("Box 186")
		);
		group7.add(new ModelRendererTurbo(group7, 465, 217, textureX, textureY)
			.addShapeBox(-8, 3, 0, 17, 6, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -6, 0, 0, -6, 0, 0, -6, 0, 0, -6, 0, 0)
			.setRotationPoint(-44, -8, -24).setRotationAngle(0, 0, 0).setName("Box 187")
		);
		this.groups.add(group7);
		//
		TurboList group8 = new TurboList("group8");
		group8.add(new ModelRendererTurbo(group8, 1, 185, textureX, textureY).addBox(-8, -2, 0, 17, 5, 5)
			.setRotationPoint(-44, -8, 19).setRotationAngle(0, 0, 0).setName("Box 167")
		);
		group8.add(new ModelRendererTurbo(group8, 465, 265, textureX, textureY)
			.addShapeBox(-8, -8, 0, 17, 6, 5, 0, -6, 0, 0, -6, 0, 0, -6, 0, 0, -6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-44, -8, 19).setRotationAngle(0, 0, 0).setName("Box 188")
		);
		group8.add(new ModelRendererTurbo(group8, 1, 273, textureX, textureY)
			.addShapeBox(-8, 3, 0, 17, 6, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -6, 0, 0, -6, 0, 0, -6, 0, 0, -6, 0, 0)
			.setRotationPoint(-44, -8, 19).setRotationAngle(0, 0, 0).setName("Box 189")
		);
		this.groups.add(group8);
		//
		//fixRotations();
	}

}
