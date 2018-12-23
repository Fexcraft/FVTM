//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.zmp.models.part.flatbedwagon;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;//TODO replace this one if needed

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.5-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "zmp:models/part/flatbedwagon_logtransport")
public class FlatbedWagonLogTransport extends PartModel {

	public FlatbedWagonLogTransport(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("zackyboy19");
		//
		TurboList container_holder = new TurboList("container_holder");
		container_holder.add(new ModelRendererTurbo(container_holder, 389, 148, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 50, 0, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, -2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0)
			.setRotationPoint(112, -33, -25).setRotationAngle(0, 0, 0).setName("Box 225")
		);
		container_holder.add(new ModelRendererTurbo(container_holder, 332, 120, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 50, 0, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0)
			.setRotationPoint(-115, -33, -25).setRotationAngle(0, 0, 0).setName("Box 226")
		);
		container_holder.addProgram("fvtm:example_program");//TODO do not forget these exists!
		this.groups.add(container_holder);
		//
		TurboList log_upgrade = new TurboList("log_upgrade");
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 0, 114, textureX, textureY).addBox(0, 0, 0, 4, 3, 50)
			.setRotationPoint(111, -78, -25).setRotationAngle(0, 0, 0).setName("Box 487")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 0, 114, textureX, textureY).addBox(0, 0, 0, 4, 45, 2)
			.setRotationPoint(111, -75, -25).setRotationAngle(0, 0, 0).setName("Box 488")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 488, 94, textureX, textureY).addBox(0, 0, 0, 4, 45, 2)
			.setRotationPoint(111, -75, 23).setRotationAngle(0, 0, 0).setName("Box 489")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 411, 276, textureX, textureY).addBox(0, 0, 0, 1, 2, 46)
			.setRotationPoint(113, -66, -23).setRotationAngle(0, 0, 0).setName("Box 491")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 273, 273, textureX, textureY).addBox(0, 0, 0, 1, 2, 46)
			.setRotationPoint(113, -53, -23).setRotationAngle(0, 0, 0).setName("Box 492")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 224, 270, textureX, textureY).addBox(0, 0, 0, 1, 2, 46)
			.setRotationPoint(113, -40, -23).setRotationAngle(0, 0, 0).setName("Box 493")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 35, 169, textureX, textureY).addBox(0, 0, 0, 2, 45, 46)
			.setRotationPoint(111, -75, -23).setRotationAngle(0, 0, 0).setName("Box 69")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 496, 56, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 8, 2, 0, 0, 0, -4, 0, 0, -4, 0, 0, 4, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(111, -86, -25).setRotationAngle(0, 0, 0).setName("Box 494")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 483, 56, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 8, 2, 0, 0, 0, 4, 0, 0, 4, 0, 0, -4, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(111, -86, 23).setRotationAngle(0, 0, 0).setName("Box 495")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 289, 104, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 42, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(111, -87, -21).setRotationAngle(0, 0, 0).setName("Box 496")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 0, 168, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 8, 38, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 4, 0, 0, 4, 0, 0, 4)
			.setRotationPoint(111, -86, -19).setRotationAngle(0, 0, 0).setName("Box 497")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 475, 94, textureX, textureY).addBox(0, 0, 0, 4, 45, 2)
			.setRotationPoint(-115, -75, -25).setRotationAngle(0, 0, 0).setName("Box 498")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 462, 94, textureX, textureY).addBox(0, 0, 0, 4, 45, 2)
			.setRotationPoint(-115, -75, 23).setRotationAngle(0, 0, 0).setName("Box 499")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 403, 94, textureX, textureY).addBox(0, 0, 0, 4, 3, 50)
			.setRotationPoint(-115, -78, -25).setRotationAngle(0, 0, 0).setName("Box 500")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 450, 40, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 8, 2, 0, 0, 0, 4, 0, 0, 4, 0, 0, -4, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-115, -86, 23).setRotationAngle(0, 0, 0).setName("Box 501")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 360, 76, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 42, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-115, -87, -21).setRotationAngle(0, 0, 0).setName("Box 502")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 27, 36, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 8, 2, 0, 0, 0, -4, 0, 0, -4, 0, 0, 4, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-115, -86, -25).setRotationAngle(0, 0, 0).setName("Box 503")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 188, 166, textureX, textureY).addBox(0, 0, 0, 2, 45, 46)
			.setRotationPoint(-113, -75, -23).setRotationAngle(0, 0, 0).setName("Box 504")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 289, 148, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 8, 38, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 4, 0, 0, 4, 0, 0, 4)
			.setRotationPoint(-113, -86, -19).setRotationAngle(0, 0, 0).setName("Box 505")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 95, 261, textureX, textureY).addBox(0, 0, 0, 1, 2, 46)
			.setRotationPoint(-114, -66, -23).setRotationAngle(0, 0, 0).setName("Box 506")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 0, 261, textureX, textureY).addBox(0, 0, 0, 1, 2, 46)
			.setRotationPoint(-114, -53, -23).setRotationAngle(0, 0, 0).setName("Box 507")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 175, 258, textureX, textureY).addBox(0, 0, 0, 1, 2, 46)
			.setRotationPoint(-114, -40, -23).setRotationAngle(0, 0, 0).setName("Box 508")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 179, 166, textureX, textureY).addBox(0, 0, 0, 2, 46, 2)
			.setRotationPoint(89, -75, -26).setRotationAngle(0, 0, 0).setName("Box 509")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 59, 144, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 10, 2, 0, -1, 0, -1, -1, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(89, -85, -26).setRotationAngle(0, 0, 0).setName("Box 510")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 358, 140, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 2, 0, 0, 2, 0, 0)
			.setRotationPoint(89, -29, -26).setRotationAngle(0, 0, 0).setName("Box 512")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 40, 144, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 10, 2, 0, -1, 0, -1, -1, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(64, -85, -26).setRotationAngle(0, 0, 0).setName("Box 513")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 170, 166, textureX, textureY).addBox(0, 0, 0, 2, 46, 2)
			.setRotationPoint(64, -75, -26).setRotationAngle(0, 0, 0).setName("Box 514")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 322, 140, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 2, 0, 0, 2, 0, 0)
			.setRotationPoint(64, -29, -26).setRotationAngle(0, 0, 0).setName("Box 515")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 31, 144, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 10, 2, 0, -1, 0, -1, -1, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(39, -85, -26).setRotationAngle(0, 0, 0).setName("Box 516")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 161, 166, textureX, textureY).addBox(0, 0, 0, 2, 46, 2)
			.setRotationPoint(39, -75, -26).setRotationAngle(0, 0, 0).setName("Box 517")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 304, 140, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 2, 0, 0, 2, 0, 0)
			.setRotationPoint(39, -29, -26).setRotationAngle(0, 0, 0).setName("Box 518")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 349, 139, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 2, 0, 0, 2, 0, 0)
			.setRotationPoint(-88, -29, -26).setRotationAngle(0, 0, 0).setName("Box 519")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 152, 166, textureX, textureY).addBox(0, 0, 0, 2, 46, 2)
			.setRotationPoint(-88, -75, -26).setRotationAngle(0, 0, 0).setName("Box 520")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 22, 144, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 10, 2, 0, -1, 0, -1, -1, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-88, -85, -26).setRotationAngle(0, 0, 0).setName("Box 521")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 340, 139, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 2, 0, 0, 2, 0, 0)
			.setRotationPoint(-63, -29, -26).setRotationAngle(0, 0, 0).setName("Box 522")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 143, 166, textureX, textureY).addBox(0, 0, 0, 2, 46, 2)
			.setRotationPoint(-63, -75, -26).setRotationAngle(0, 0, 0).setName("Box 523")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 13, 144, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 10, 2, 0, -1, 0, -1, -1, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-63, -85, -26).setRotationAngle(0, 0, 0).setName("Box 524")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 389, 140, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 10, 2, 0, -1, 0, -1, -1, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-38, -85, -26).setRotationAngle(0, 0, 0).setName("Box 525")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 134, 166, textureX, textureY).addBox(0, 0, 0, 2, 46, 2)
			.setRotationPoint(-38, -75, -26).setRotationAngle(0, 0, 0).setName("Box 526")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 295, 139, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 2, 0, 0, 2, 0, 0)
			.setRotationPoint(-38, -29, -26).setRotationAngle(0, 0, 0).setName("Box 527")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 286, 139, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 2, 0, 0, 2, 0, 0)
			.setRotationPoint(-14, -29, -26).setRotationAngle(0, 0, 0).setName("Box 528")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 125, 166, textureX, textureY).addBox(0, 0, 0, 2, 46, 2)
			.setRotationPoint(-14, -75, -26).setRotationAngle(0, 0, 0).setName("Box 529")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 277, 139, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 10, 2, 0, -1, 0, -1, -1, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-14, -85, -26).setRotationAngle(0, 0, 0).setName("Box 530")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 249, 139, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 2, 0, 0, 2, 0, 0)
			.setRotationPoint(11, -29, -26).setRotationAngle(0, 0, 0).setName("Box 531")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 116, 166, textureX, textureY).addBox(0, 0, 0, 2, 46, 2)
			.setRotationPoint(11, -75, -26).setRotationAngle(0, 0, 0).setName("Box 532")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 240, 139, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 10, 2, 0, -1, 0, -1, -1, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(11, -85, -26).setRotationAngle(0, 0, 0).setName("Box 533")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 107, 166, textureX, textureY).addBox(0, 0, 0, 2, 46, 2)
			.setRotationPoint(11, -75, 24).setRotationAngle(0, 0, 0).setName("Box 537")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 231, 139, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 10, 2, 0, 0, 0, 1, 0, 0, 1, -1, 0, -1, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(11, -85, 24).setRotationAngle(0, 0, 0).setName("Box 538")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 222, 139, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(11, -29, 24).setRotationAngle(0, 0, 0).setName("Box 539")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 213, 139, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(39, -29, 24).setRotationAngle(0, 0, 0).setName("Box 540")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 204, 139, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(64, -29, 24).setRotationAngle(0, 0, 0).setName("Box 541")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 195, 139, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 10, 2, 0, 0, 0, 1, 0, 0, 1, -1, 0, -1, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(64, -85, 24).setRotationAngle(0, 0, 0).setName("Box 542")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 186, 139, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 10, 2, 0, 0, 0, 1, 0, 0, 1, -1, 0, -1, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(39, -85, 24).setRotationAngle(0, 0, 0).setName("Box 543")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 500, 148, textureX, textureY).addBox(0, 0, 0, 2, 46, 2)
			.setRotationPoint(39, -75, 24).setRotationAngle(0, 0, 0).setName("Box 544")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 491, 148, textureX, textureY).addBox(0, 0, 0, 2, 46, 2)
			.setRotationPoint(64, -75, 24).setRotationAngle(0, 0, 0).setName("Box 545")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 482, 148, textureX, textureY).addBox(0, 0, 0, 2, 46, 2)
			.setRotationPoint(89, -75, 24).setRotationAngle(0, 0, 0).setName("Box 546")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 177, 139, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 10, 2, 0, 0, 0, 1, 0, 0, 1, -1, 0, -1, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(89, -85, 24).setRotationAngle(0, 0, 0).setName("Box 547")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 168, 139, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(89, -29, 24).setRotationAngle(0, 0, 0).setName("Box 548")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 148, 139, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(-63, -29, 24).setRotationAngle(0, 0, 0).setName("Box 549")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 139, 139, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(-38, -29, 24).setRotationAngle(0, 0, 0).setName("Box 550")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 130, 139, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(-14, -29, 24).setRotationAngle(0, 0, 0).setName("Box 551")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 473, 148, textureX, textureY).addBox(0, 0, 0, 2, 46, 2)
			.setRotationPoint(-14, -75, 24).setRotationAngle(0, 0, 0).setName("Box 552")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 464, 148, textureX, textureY).addBox(0, 0, 0, 2, 46, 2)
			.setRotationPoint(-38, -75, 24).setRotationAngle(0, 0, 0).setName("Box 553")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 121, 139, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 10, 2, 0, 0, 0, 1, 0, 0, 1, -1, 0, -1, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-38, -85, 24).setRotationAngle(0, 0, 0).setName("Box 554")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 112, 139, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 10, 2, 0, 0, 0, 1, 0, 0, 1, -1, 0, -1, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-14, -85, 24).setRotationAngle(0, 0, 0).setName("Box 555")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 455, 148, textureX, textureY).addBox(0, 0, 0, 2, 46, 2)
			.setRotationPoint(-63, -75, 24).setRotationAngle(0, 0, 0).setName("Box 556")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 103, 139, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 10, 2, 0, 0, 0, 1, 0, 0, 1, -1, 0, -1, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-63, -85, 24).setRotationAngle(0, 0, 0).setName("Box 557")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 258, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 10, 2, 0, 0, 0, 1, 0, 0, 1, -1, 0, -1, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-88, -85, 24).setRotationAngle(0, 0, 0).setName("Box 558")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 446, 148, textureX, textureY).addBox(0, 0, 0, 2, 46, 2)
			.setRotationPoint(-88, -75, 24).setRotationAngle(0, 0, 0).setName("Box 559")
		);
		log_upgrade.add(new ModelRendererTurbo(log_upgrade, 393, 112, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(-88, -29, 24).setRotationAngle(0, 0, 0).setName("Box 560")
		);
		log_upgrade.addProgram(DefaultPrograms.RGB_PRIMARY);
		this.groups.add(log_upgrade);
		this.translate(0, 8, 0);
	}

}
