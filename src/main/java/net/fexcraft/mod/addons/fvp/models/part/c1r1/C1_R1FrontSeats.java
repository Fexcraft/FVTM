//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.part.c1r1;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.1-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/part/c1_r1_front_seats")
public class C1_R1FrontSeats extends PartModel {

	public C1_R1FrontSeats(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList front_seats = new TurboList("front_seats");
		front_seats.add(new ModelRendererTurbo(front_seats, 329, 289, textureX, textureY).addBox(0, 0, 0, 12, 1, 12)
			.setRotationPoint(0, -4, 4).setRotationAngle(0, 0, 0).setName("Box 677")
		);
		front_seats.add(new ModelRendererTurbo(front_seats, 481, 217, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 2, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(0, -4, 2).setRotationAngle(0, 0, 0).setName("Box 679")
		);
		front_seats.add(new ModelRendererTurbo(front_seats, 481, 225, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0)
			.setRotationPoint(0, -4, 16).setRotationAngle(0, 0, 0).setName("Box 680")
		);
		front_seats.add(new ModelRendererTurbo(front_seats, 433, 289, textureX, textureY)
			.addShapeBox(-0.5f, -16, -7, 2, 16, 14, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0)
			.setRotationPoint(-1, -4, 10).setRotationAngle(0, 0, -0.17453294f).setName("Box 681")
		);
		front_seats.add(new ModelRendererTurbo(front_seats, 57, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 12, 0, 0, 0, 0, -0.05f, 0.2f, 0, -0.05f, 0.2f, 0, 0, 0, 0, -1, 0, 0, 0, -1, 0, 0, -1, 0, -1, 0, 0)
			.setRotationPoint(-1, -4, 4).setRotationAngle(0, 0, 0).setName("Box 682")
		);
		front_seats.add(new ModelRendererTurbo(front_seats, 305, 9, textureX, textureY)
			.addShapeBox(0, -18, -3, 1, 2, 1, 0, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f)
			.setRotationPoint(-1, -4, 10).setRotationAngle(0, 0, -0.17453294f).setName("Box 683")
		);
		front_seats.add(new ModelRendererTurbo(front_seats, 441, 9, textureX, textureY)
			.addShapeBox(0, -18, 2, 1, 2, 1, 0, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f)
			.setRotationPoint(-1, -4, 10).setRotationAngle(0, 0, -0.17453294f).setName("Box 684")
		);
		front_seats.add(new ModelRendererTurbo(front_seats, 369, 209, textureX, textureY)
			.addShapeBox(-0.5f, -20.5f, -3.5f, 2, 3, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-1, -4, 10).setRotationAngle(0, 0, -0.17453294f).setName("Box 685")
		);
		front_seats.add(new ModelRendererTurbo(front_seats, 433, 161, textureX, textureY).addBox(0, 0, -4, 8, 2, 1)
			.setRotationPoint(2, -2, 10).setRotationAngle(0, 0, 0).setName("Box 689")
		);
		front_seats.add(new ModelRendererTurbo(front_seats, 89, 177, textureX, textureY).addBox(0, 0, 3, 8, 2, 1)
			.setRotationPoint(2, -2, 10).setRotationAngle(0, 0, 0).setName("Box 690")
		);
		front_seats.add(new ModelRendererTurbo(front_seats, 457, 289, textureX, textureY)
			.addShapeBox(0, 0, 0, 11, 1, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, -1, 0, -1, -1, 0, -1, -1, 0, -1)
			.setRotationPoint(0.5f, -3, 4.5f).setRotationAngle(0, 0, 0).setName("Box 691")
		);
		front_seats.add(new ModelRendererTurbo(front_seats, 193, 265, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0)
			.setRotationPoint(0, -4, -4).setRotationAngle(0, 0, 0).setName("Box 693")
		);
		front_seats.add(new ModelRendererTurbo(front_seats, 473, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 12, 0, 0, 0, 0, -0.05f, 0.2f, 0, -0.05f, 0.2f, 0, 0, 0, 0, -1, 0, 0, 0, -1, 0, 0, -1, 0, -1, 0, 0)
			.setRotationPoint(-1, -4, -16).setRotationAngle(0, 0, 0).setName("Box 694")
		);
		front_seats.add(new ModelRendererTurbo(front_seats, 481, 265, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 2, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(0, -4, -18).setRotationAngle(0, 0, 0).setName("Box 695")
		);
		front_seats.add(new ModelRendererTurbo(front_seats, 233, 297, textureX, textureY).addBox(0, 0, 0, 12, 1, 12)
			.setRotationPoint(0, -4, -16).setRotationAngle(0, 0, 0).setName("Box 696")
		);
		front_seats.add(new ModelRendererTurbo(front_seats, 369, 297, textureX, textureY)
			.addShapeBox(0, 0, 0, 11, 1, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, -1, 0, -1, -1, 0, -1, -1, 0, -1)
			.setRotationPoint(0.5f, -3, -15.5f).setRotationAngle(0, 0, 0).setName("Box 697")
		);
		front_seats.add(new ModelRendererTurbo(front_seats, 393, 177, textureX, textureY).addBox(0, 0, -4, 8, 2, 1)
			.setRotationPoint(2, -2, -10).setRotationAngle(0, 0, 0).setName("Box 698")
		);
		front_seats.add(new ModelRendererTurbo(front_seats, 185, 185, textureX, textureY).addBox(0, 0, 3, 8, 2, 1)
			.setRotationPoint(2, -2, -10).setRotationAngle(0, 0, 0).setName("Box 699")
		);
		front_seats.add(new ModelRendererTurbo(front_seats, 73, 297, textureX, textureY)
			.addShapeBox(-0.5f, -16, -7, 2, 16, 14, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0)
			.setRotationPoint(-1, -4, -10).setRotationAngle(0, 0, -0.17453294f).setName("Box 700")
		);
		front_seats.add(new ModelRendererTurbo(front_seats, 457, 9, textureX, textureY)
			.addShapeBox(0, -18, -3, 1, 2, 1, 0, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f)
			.setRotationPoint(-1, -4, -10).setRotationAngle(0, 0, -0.17453294f).setName("Box 701")
		);
		front_seats.add(new ModelRendererTurbo(front_seats, 473, 9, textureX, textureY)
			.addShapeBox(0, -18, 2, 1, 2, 1, 0, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f)
			.setRotationPoint(-1, -4, -10).setRotationAngle(0, 0, -0.17453294f).setName("Box 702")
		);
		front_seats.add(new ModelRendererTurbo(front_seats, 425, 209, textureX, textureY)
			.addShapeBox(-0.5f, -20.5f, -3.5f, 2, 3, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-1, -4, -10).setRotationAngle(0, 0, -0.17453294f).setName("Box 703")
		);
		this.groups.add(front_seats);
	}

}