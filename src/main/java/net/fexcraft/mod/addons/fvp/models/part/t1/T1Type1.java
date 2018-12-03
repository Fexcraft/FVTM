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
@fModel(registryname = "fvp:models/part/t1_type1")
public class T1Type1 extends PartModel {

	public T1Type1(){
		super(); textureX = 1024; textureY = 1024;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList chassis = new TurboList("chassis");
		chassis.add(new ModelRendererTurbo(chassis, 465, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 124, 1, 51, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(-102, -12, -25.5f).setRotationAngle(0, 0, 0).setName("Box 219")
		);
		chassis.add(new ModelRendererTurbo(chassis, 977, 177, textureX, textureY).addBox(0, 0, 0, 2, 48, 1)
			.setRotationPoint(-101.5f, -60, -24.5f).setRotationAngle(0, 0, 0).setName("Box 4")
		);
		chassis.add(new ModelRendererTurbo(chassis, 985, 177, textureX, textureY).addBox(0, 0, 0, 2, 48, 1)
			.setRotationPoint(-101.5f, -60, 23.5f).setRotationAngle(0, 0, 0).setName("Box 5")
		);
		chassis.add(new ModelRendererTurbo(chassis, 513, 257, textureX, textureY).addBox(0, 0, 0, 2, 3, 46)
			.setRotationPoint(-102.5f, -11.5f, -23).setRotationAngle(0, 0, 0).setName("Box 8")
		);
		chassis.add(new ModelRendererTurbo(chassis, 345, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0)
			.setRotationPoint(-102.5f, -57, -25).setRotationAngle(0, 0, 0).setName("Box 669")
		);
		chassis.add(new ModelRendererTurbo(chassis, 385, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0)
			.setRotationPoint(-102.5f, -36.5f, -25).setRotationAngle(0, 0, 0).setName("Box 670")
		);
		chassis.add(new ModelRendererTurbo(chassis, 481, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0)
			.setRotationPoint(-102.5f, -19, -25).setRotationAngle(0, 0, 0).setName("Box 671")
		);
		chassis.add(new ModelRendererTurbo(chassis, 505, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 2, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-102.5f, -19, 23).setRotationAngle(0, 0, 0).setName("Box 672")
		);
		chassis.add(new ModelRendererTurbo(chassis, 769, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 2, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-102.5f, -36.5f, 23).setRotationAngle(0, 0, 0).setName("Box 673")
		);
		chassis.add(new ModelRendererTurbo(chassis, 793, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 2, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-102.5f, -57, 23).setRotationAngle(0, 0, 0).setName("Box 674")
		);
		chassis.add(new ModelRendererTurbo(chassis, 889, 169, textureX, textureY).addBox(0, 0, 0, 2, 2, 12)
			.setRotationPoint(-2, -5, -22.5f).setRotationAngle(0, 0, 0).setName("Box 675")
		);
		chassis.add(new ModelRendererTurbo(chassis, 185, 177, textureX, textureY).addBox(0, 0, 0, 2, 2, 12)
			.setRotationPoint(-48, -5, -22.5f).setRotationAngle(0, 0, 0).setName("Box 676")
		);
		chassis.add(new ModelRendererTurbo(chassis, 217, 177, textureX, textureY).addBox(0, 0, 0, 2, 2, 12)
			.setRotationPoint(-2, -5, 11.5f).setRotationAngle(0, 0, 0).setName("Box 677")
		);
		chassis.add(new ModelRendererTurbo(chassis, 849, 177, textureX, textureY).addBox(0, 0, 0, 2, 2, 12)
			.setRotationPoint(-48, -5, 11.5f).setRotationAngle(0, 0, 0).setName("Box 678")
		);
		chassis.add(new ModelRendererTurbo(chassis, 921, 161, textureX, textureY).addBox(0, 0, 0, 2, 10, 1)
			.setRotationPoint(-2, -11, -23.5f).setRotationAngle(0, 0, 0).setName("Box 679")
		);
		chassis.add(new ModelRendererTurbo(chassis, 913, 169, textureX, textureY).addBox(0, 0, 0, 2, 10, 1)
			.setRotationPoint(-48, -11, -23.5f).setRotationAngle(0, 0, 0).setName("Box 680")
		);
		chassis.add(new ModelRendererTurbo(chassis, 185, 177, textureX, textureY).addBox(0, 0, 0, 2, 10, 1)
			.setRotationPoint(-2, -11, 22.5f).setRotationAngle(0, 0, 0).setName("Box 681")
		);
		chassis.add(new ModelRendererTurbo(chassis, 209, 177, textureX, textureY).addBox(0, 0, 0, 2, 10, 1)
			.setRotationPoint(-48, -11, 22.5f).setRotationAngle(0, 0, 0).setName("Box 682")
		);
		chassis.add(new ModelRendererTurbo(chassis, 817, 193, textureX, textureY).addBox(0, 0, 0, 64, 4, 1)
			.setRotationPoint(-56, -10, -24).setRotationAngle(0, 0, 0).setName("Box 683")
		);
		chassis.add(new ModelRendererTurbo(chassis, 305, 225, textureX, textureY).addBox(0, 0, 0, 64, 4, 1)
			.setRotationPoint(-56, -4, -24).setRotationAngle(0, 0, 0).setName("Box 684")
		);
		chassis.add(new ModelRendererTurbo(chassis, 305, 233, textureX, textureY).addBox(0, 0, 0, 64, 4, 1)
			.setRotationPoint(-56, -4, 23).setRotationAngle(0, 0, 0).setName("Box 685")
		);
		chassis.add(new ModelRendererTurbo(chassis, 305, 241, textureX, textureY).addBox(0, 0, 0, 64, 4, 1)
			.setRotationPoint(-56, -10, 23).setRotationAngle(0, 0, 0).setName("Box 686")
		);
		this.groups.add(chassis);
		//
		TurboList chassis_lights = new TurboList("chassis_lights");
		chassis_lights.add(new ModelRendererTurbo(chassis_lights, 449, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-101.5f, -60, 24.3f).setRotationAngle(0.017453292f, 0, 0).setName("Box 687")
		);
		chassis_lights.add(new ModelRendererTurbo(chassis_lights, 465, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-81.5f, -60, 24.3f).setRotationAngle(0.017453292f, 0, 0).setName("Box 688")
		);
		chassis_lights.add(new ModelRendererTurbo(chassis_lights, 809, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-71.5f, -60, 24.3f).setRotationAngle(0.017453292f, 0, 0).setName("Box 689")
		);
		chassis_lights.add(new ModelRendererTurbo(chassis_lights, 825, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-61.5f, -60, 24.3f).setRotationAngle(0.017453292f, 0, 0).setName("Box 690")
		);
		chassis_lights.add(new ModelRendererTurbo(chassis_lights, 929, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-51.5f, -60, 24.3f).setRotationAngle(0.017453292f, 0, 0).setName("Box 691")
		);
		chassis_lights.add(new ModelRendererTurbo(chassis_lights, 1, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-41.5f, -60, 24.3f).setRotationAngle(0.017453292f, 0, 0).setName("Box 692")
		);
		chassis_lights.add(new ModelRendererTurbo(chassis_lights, 9, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-31.5f, -60, 24.3f).setRotationAngle(0.017453292f, 0, 0).setName("Box 693")
		);
		chassis_lights.add(new ModelRendererTurbo(chassis_lights, 25, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-21.5f, -60, 24.3f).setRotationAngle(0.017453292f, 0, 0).setName("Box 694")
		);
		chassis_lights.add(new ModelRendererTurbo(chassis_lights, 33, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-11.5f, -60, 24.3f).setRotationAngle(0.017453292f, 0, 0).setName("Box 695")
		);
		chassis_lights.add(new ModelRendererTurbo(chassis_lights, 57, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-1.5f, -60, 24.3f).setRotationAngle(0.017453292f, 0, 0).setName("Box 696")
		);
		chassis_lights.add(new ModelRendererTurbo(chassis_lights, 65, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(8.5f, -60, 24.3f).setRotationAngle(0.017453292f, 0, 0).setName("Box 697")
		);
		chassis_lights.add(new ModelRendererTurbo(chassis_lights, 313, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(18.5f, -60, 24.3f).setRotationAngle(0.017453292f, 0, 0).setName("Box 698")
		);
		chassis_lights.add(new ModelRendererTurbo(chassis_lights, 321, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-91.5f, -60, 24.3f).setRotationAngle(0.017453292f, 0, 0).setName("Box 699")
		);
		chassis_lights.add(new ModelRendererTurbo(chassis_lights, 337, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-101.5f, -60, -26.3f).setRotationAngle(0.017453292f, 0, 0).setName("Box 700")
		);
		chassis_lights.add(new ModelRendererTurbo(chassis_lights, 345, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-91.5f, -60, -26.3f).setRotationAngle(0.017453292f, 0, 0).setName("Box 701")
		);
		chassis_lights.add(new ModelRendererTurbo(chassis_lights, 361, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-81.5f, -60, -26.3f).setRotationAngle(0.017453292f, 0, 0).setName("Box 702")
		);
		chassis_lights.add(new ModelRendererTurbo(chassis_lights, 369, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-71.5f, -60, -26.3f).setRotationAngle(0.017453292f, 0, 0).setName("Box 703")
		);
		chassis_lights.add(new ModelRendererTurbo(chassis_lights, 385, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-61.5f, -60, -26.3f).setRotationAngle(0.017453292f, 0, 0).setName("Box 704")
		);
		chassis_lights.add(new ModelRendererTurbo(chassis_lights, 393, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-51.5f, -60, -26.3f).setRotationAngle(0.017453292f, 0, 0).setName("Box 705")
		);
		chassis_lights.add(new ModelRendererTurbo(chassis_lights, 481, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-41.5f, -60, -26.3f).setRotationAngle(0.017453292f, 0, 0).setName("Box 706")
		);
		chassis_lights.add(new ModelRendererTurbo(chassis_lights, 489, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-31.5f, -60, -26.3f).setRotationAngle(0.017453292f, 0, 0).setName("Box 707")
		);
		chassis_lights.add(new ModelRendererTurbo(chassis_lights, 505, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-21.5f, -60, -26.3f).setRotationAngle(0.017453292f, 0, 0).setName("Box 708")
		);
		chassis_lights.add(new ModelRendererTurbo(chassis_lights, 769, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-11.5f, -60, -26.3f).setRotationAngle(0.017453292f, 0, 0).setName("Box 709")
		);
		chassis_lights.add(new ModelRendererTurbo(chassis_lights, 777, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-1.5f, -60, -26.3f).setRotationAngle(0.017453292f, 0, 0).setName("Box 710")
		);
		chassis_lights.add(new ModelRendererTurbo(chassis_lights, 793, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(8.5f, -60, -26.3f).setRotationAngle(0.017453292f, 0, 0).setName("Box 711")
		);
		chassis_lights.add(new ModelRendererTurbo(chassis_lights, 881, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(18.5f, -60, -26.3f).setRotationAngle(0.017453292f, 0, 0).setName("Box 712")
		);
		chassis_lights.addProgram(DefaultPrograms.LIGHTS);
		this.groups.add(chassis_lights);
		//
		TurboList chassis_primary = new TurboList("chassis_primary");
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 465, 201, textureX, textureY).addBox(0, 0, 0, 124, 48, 1)
			.setRotationPoint(-102, -60, -25.5f).setRotationAngle(0, 0, 0).setName("Box 0")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 721, 201, textureX, textureY).addBox(0, 0, 0, 124, 48, 1)
			.setRotationPoint(-102, -60, 24.5f).setRotationAngle(0, 0, 0).setName("Box 1")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 217, textureX, textureY).addBox(0, 0, 0, 124, 1, 52)
			.setRotationPoint(-102, -61, -26).setRotationAngle(0, 0, 0).setName("Box 2")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 409, 209, textureX, textureY).addBox(0, 0, 0, 1, 48, 49)
			.setRotationPoint(21, -60, -24.5f).setRotationAngle(0, 0, 0).setName("Box 3")
		);
		chassis_primary.addProgram(DefaultPrograms.RGB_SECONDARY);
		this.groups.add(chassis_primary);
		//
		TurboList doors_close = new TurboList("doors_close");
		doors_close.add(new ModelRendererTurbo(doors_close, 953, 233, textureX, textureY).addBox(0, 0, 0, 1, 48, 25)
			.setRotationPoint(-102.5f, -60, -25).setRotationAngle(0, 0, 0).setName("Box 6")
		);
		doors_close.add(new ModelRendererTurbo(doors_close, 329, 249, textureX, textureY).addBox(0, 0, 0, 1, 48, 25)
			.setRotationPoint(-102.5f, -60, 0).setRotationAngle(0, 0, 0).setName("Box 7")
		);
		doors_close.add(new ModelRendererTurbo(doors_close, 617, 257, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 16, 46, 0, -1.5f, 0, 0, 0, 0, 0, 0, 0, 0, -1.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-104.5f, -26.5f, -23).setRotationAngle(0, 0, 0).setName("Box 9")
		);
		doors_close.add(new ModelRendererTurbo(doors_close, 889, 161, textureX, textureY).addBox(0, 0, 0, 12, 2, 2)
			.setRotationPoint(-105, -11.5f, -17).setRotationAngle(0, 0, 0).setName("Box 10")
		);
		doors_close.add(new ModelRendererTurbo(doors_close, 81, 169, textureX, textureY).addBox(0, 0, 0, 12, 2, 2)
			.setRotationPoint(-105, -11.5f, 15).setRotationAngle(0, 0, 0).setName("Box 11")
		);
		doors_close.add(new ModelRendererTurbo(doors_close, 1009, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 10, 2, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-105, -21.5f, -17).setRotationAngle(0, 0, 0).setName("Box 12")
		);
		doors_close.add(new ModelRendererTurbo(doors_close, 137, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 10, 2, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-105, -21.5f, 15).setRotationAngle(0, 0, 0).setName("Box 13")
		);
		doors_close.add(new ModelRendererTurbo(doors_close, 449, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 8, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-102.7f, -29, -4).setRotationAngle(0.017453292f, 0, 0).setName("Box 661")
		);
		doors_close.add(new ModelRendererTurbo(doors_close, 809, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 8, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-102.7f, -58, -4).setRotationAngle(0.017453292f, 0, 0).setName("Box 662")
		);
		doors_close.add(new ModelRendererTurbo(doors_close, 881, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 8, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-102.7f, -43, -4).setRotationAngle(0.017453292f, 0, 0).setName("Box 663")
		);
		doors_close.addProgram(DefaultPrograms.DOOR_CLOSE);
		this.groups.add(doors_close);
		//
		TurboList doors_close_lights = new TurboList("doors_close_lights");
		doors_close_lights.add(new ModelRendererTurbo(doors_close_lights, 377, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-102.7f, -60, -25).setRotationAngle(0.017453292f, 0, 0).setName("Box 14")
		);
		doors_close_lights.add(new ModelRendererTurbo(doors_close_lights, 1017, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-102.7f, -60, -5).setRotationAngle(0.017453292f, 0, 0).setName("Box 15")
		);
		doors_close_lights.add(new ModelRendererTurbo(doors_close_lights, 57, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-102.7f, -60, 3).setRotationAngle(0.017453292f, 0, 0).setName("Box 16")
		);
		doors_close_lights.add(new ModelRendererTurbo(doors_close_lights, 97, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-102.7f, -60, 23).setRotationAngle(0.017453292f, 0, 0).setName("Box 17")
		);
		doors_close_lights.add(new ModelRendererTurbo(doors_close_lights, 273, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-102.7f, -50, -25).setRotationAngle(0.017453292f, 0, 0).setName("Box 18")
		);
		doors_close_lights.add(new ModelRendererTurbo(doors_close_lights, 313, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-102.7f, -40, -25).setRotationAngle(0.017453292f, 0, 0).setName("Box 19")
		);
		doors_close_lights.add(new ModelRendererTurbo(doors_close_lights, 473, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-102.7f, -30, -25).setRotationAngle(0.017453292f, 0, 0).setName("Box 20")
		);
		doors_close_lights.add(new ModelRendererTurbo(doors_close_lights, 521, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-102.7f, -20, -25).setRotationAngle(0.017453292f, 0, 0).setName("Box 21")
		);
		doors_close_lights.add(new ModelRendererTurbo(doors_close_lights, 273, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-102.7f, -50, 23).setRotationAngle(0.017453292f, 0, 0).setName("Box 22")
		);
		doors_close_lights.add(new ModelRendererTurbo(doors_close_lights, 377, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-102.7f, -40, 23).setRotationAngle(0.017453292f, 0, 0).setName("Box 23")
		);
		doors_close_lights.add(new ModelRendererTurbo(doors_close_lights, 537, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-102.7f, -30, 23).setRotationAngle(0.017453292f, 0, 0).setName("Box 24")
		);
		doors_close_lights.add(new ModelRendererTurbo(doors_close_lights, 553, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-102.7f, -20, 23).setRotationAngle(0.017453292f, 0, 0).setName("Box 25")
		);
		doors_close_lights.addPrograms(DefaultPrograms.DOOR_CLOSE, DefaultPrograms.LIGHTS);
		this.groups.add(doors_close_lights);
		//
		TurboList doors_open = new TurboList("doors_open");
		doors_open.add(new ModelRendererTurbo(doors_open, 721, 257, textureX, textureY)
			.addShapeBox(0, 0, 0, 16, 2, 46, 0, 0, -1.5f, 0, 0, 0, 0, 0, 0, 0, 0, -1.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-120.5f, 8, -23).setRotationAngle(0, 0, 0).setName("Box 645")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 417, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 17, 2, 0, -2.5f, 0, 0, 2.5f, 0, 0, 2.5f, 0, 0, -2.5f, 0, 0, 1.5f, 0, 0, -1.5f, 1, 0, -1.5f, 1, 0, 1.5f, 0, 0)
			.setRotationPoint(-105, -8.5f, -17).setRotationAngle(0, 0, 0).setName("Box 646")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 433, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 17, 2, 0, -2.5f, 0, 0, 2.5f, 0, 0, 2.5f, 0, 0, -2.5f, 0, 0, 1.5f, 0, 0, -1.5f, 1, 0, -1.5f, 1, 0, 1.5f, 0, 0)
			.setRotationPoint(-105, -8.5f, 15).setRotationAngle(0, 0, 0).setName("Box 647")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 849, 257, textureX, textureY).addBox(0, 0, 0, 1, 48, 25)
			.setRotationPoint(-102.5f, -60, -50).setRotationAngle(0, 0, 0).setName("Box 648")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 1, 273, textureX, textureY).addBox(0, 0, 0, 1, 48, 25)
			.setRotationPoint(-102.5f, -60, 25).setRotationAngle(0, 0, 0).setName("Box 649")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 785, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 4, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-102.3f, -58, -50).setRotationAngle(0.017453292f, 0, 0).setName("Box 665")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 417, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 4, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-102.3f, -43, -50).setRotationAngle(0.017453292f, 0, 0).setName("Box 666")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 361, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 4, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-102.3f, -28, -50).setRotationAngle(0.017453292f, 0, 0).setName("Box 667")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 609, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 5, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-102.3f, -58, 46).setRotationAngle(0.017453292f, 0, 0).setName("Box 668")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 609, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 5, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-102.3f, -43, 46).setRotationAngle(0.017453292f, 0, 0).setName("Box 717")
		);
		doors_open.add(new ModelRendererTurbo(doors_open, 609, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 5, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-102.3f, -28, 46).setRotationAngle(0.017453292f, 0, 0).setName("Box 718")
		);
		doors_open.addProgram(DefaultPrograms.DOOR_OPEN);
		this.groups.add(doors_open);
		//
		TurboList doors_open_lights = new TurboList("doors_open_lights");
		doors_open_lights.add(new ModelRendererTurbo(doors_open_lights, 921, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-102.3f, -60, -47).setRotationAngle(0.017453292f, 0, 0).setName("Box 650")
		);
		doors_open_lights.add(new ModelRendererTurbo(doors_open_lights, 25, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-102.3f, -50, -27).setRotationAngle(0.017453292f, 0, 0).setName("Box 651")
		);
		doors_open_lights.add(new ModelRendererTurbo(doors_open_lights, 961, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-102.3f, -40, -27).setRotationAngle(0.017453292f, 0, 0).setName("Box 652")
		);
		doors_open_lights.add(new ModelRendererTurbo(doors_open_lights, 33, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-102.3f, -30, -27).setRotationAngle(0.017453292f, 0, 0).setName("Box 653")
		);
		doors_open_lights.add(new ModelRendererTurbo(doors_open_lights, 153, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-102.3f, -20, -27).setRotationAngle(0.017453292f, 0, 0).setName("Box 654")
		);
		doors_open_lights.add(new ModelRendererTurbo(doors_open_lights, 1, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-102.3f, -60, -27).setRotationAngle(0.017453292f, 0, 0).setName("Box 655")
		);
		doors_open_lights.add(new ModelRendererTurbo(doors_open_lights, 249, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-102.3f, -60, 25).setRotationAngle(0.017453292f, 0, 0).setName("Box 656")
		);
		doors_open_lights.add(new ModelRendererTurbo(doors_open_lights, 97, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-102.3f, -60, 45).setRotationAngle(0.017453292f, 0, 0).setName("Box 657")
		);
		doors_open_lights.add(new ModelRendererTurbo(doors_open_lights, 105, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-102.3f, -50, 25).setRotationAngle(0.017453292f, 0, 0).setName("Box 658")
		);
		doors_open_lights.add(new ModelRendererTurbo(doors_open_lights, 313, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-102.3f, -40, 25).setRotationAngle(0.017453292f, 0, 0).setName("Box 659")
		);
		doors_open_lights.add(new ModelRendererTurbo(doors_open_lights, 321, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-102.3f, -20, 25).setRotationAngle(0.017453292f, 0, 0).setName("Box 660")
		);
		doors_open_lights.add(new ModelRendererTurbo(doors_open_lights, 337, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-102.3f, -30, 25).setRotationAngle(0.017453292f, 0, 0).setName("Box 664")
		);
		doors_open_lights.addPrograms(DefaultPrograms.DOOR_OPEN, DefaultPrograms.LIGHTS);
		this.groups.add(doors_open_lights);
		//
		TurboList lights_front = new TurboList("lights_front");
		lights_front.add(new ModelRendererTurbo(lights_front, 921, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 5, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0)
			.setRotationPoint(49.5f, -42.5f, 7.5f).setRotationAngle(0, 0, 0).setName("Box 715")
		);
		lights_front.add(new ModelRendererTurbo(lights_front, 945, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 5, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0)
			.setRotationPoint(49.5f, -42.5f, -14.5f).setRotationAngle(0, 0, 0).setName("Box 716")
		);
		lights_front.addProgram(DefaultPrograms.RGB_PRIMARY);
		this.groups.add(lights_front);
		//
		TurboList lights_front_glow = new TurboList("lights_front_glow");
		lights_front_glow.add(new ModelRendererTurbo(lights_front_glow, 153, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 4, 0, 0, -0.1f, -0.1f, -0.6f, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, 0, -0.1f, -0.1f, 0, -0.1f, -0.1f, -0.6f, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, 0, -0.1f, -0.1f)
			.setRotationPoint(52.5f, -42.25f, 8).setRotationAngle(0, 0, 0).setName("Box 713")
		);
		lights_front_glow.add(new ModelRendererTurbo(lights_front_glow, 217, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 4, 0, 0, -0.1f, -0.1f, -0.6f, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, 0, -0.1f, -0.1f, 0, -0.1f, -0.1f, -0.6f, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, 0, -0.1f, -0.1f)
			.setRotationPoint(52.5f, -42.25f, -14).setRotationAngle(0, 0, 0).setName("Box 714")
		);
		lights_front_glow.addProgram(DefaultPrograms.LIGHTS);
		this.groups.add(lights_front_glow);
	}

}