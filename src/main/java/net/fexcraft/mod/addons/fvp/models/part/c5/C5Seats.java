//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.part.c5;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.1-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/part/c5_seats")
public class C5Seats extends PartModel {

	public C5Seats(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList seats = new TurboList("seats");
		seats.add(new ModelRendererTurbo(seats, 233, 65, textureX, textureY).addBox(0, 0, 0, 10, 1, 1)
			.setRotationPoint(-12, 4, 10).setRotationAngle(0, 0, 0).setName("Box 218")
		);
		seats.add(new ModelRendererTurbo(seats, 449, 121, textureX, textureY).addBox(0, 0, 0, 14, 2, 14)
			.setRotationPoint(-14, 2, 7).setRotationAngle(0, 0, 0).setName("Box 219")
		);
		seats.add(new ModelRendererTurbo(seats, 257, 65, textureX, textureY).addBox(0, 0, 0, 10, 1, 1)
			.setRotationPoint(-12, 4, 17).setRotationAngle(0, 0, 0).setName("Box 220")
		);
		seats.add(new ModelRendererTurbo(seats, 281, 65, textureX, textureY).addBox(0, 0, 0, 10, 1, 1)
			.setRotationPoint(-12, 4, -18).setRotationAngle(0, 0, 0).setName("Box 221")
		);
		seats.add(new ModelRendererTurbo(seats, 441, 65, textureX, textureY).addBox(0, 0, 0, 10, 1, 1)
			.setRotationPoint(-12, 4, -11).setRotationAngle(0, 0, 0).setName("Box 222")
		);
		seats.add(new ModelRendererTurbo(seats, 441, 145, textureX, textureY).addBox(0, 0, 0, 14, 2, 14)
			.setRotationPoint(-14, 2, -21).setRotationAngle(0, 0, 0).setName("Box 223")
		);
		seats.add(new ModelRendererTurbo(seats, 305, 193, textureX, textureY).addBox(0, 0, 0, 14, 2, 14)
			.setRotationPoint(-14, 2, -7).setRotationAngle(0, 0, 0).setName("Box 224")
		);
		seats.add(new ModelRendererTurbo(seats, 465, 65, textureX, textureY).addBox(0, 0, 0, 10, 1, 1)
			.setRotationPoint(-12, 4, -4).setRotationAngle(0, 0, 0).setName("Box 225")
		);
		seats.add(new ModelRendererTurbo(seats, 345, 81, textureX, textureY).addBox(0, 0, 0, 10, 1, 1)
			.setRotationPoint(-12, 4, 3).setRotationAngle(0, 0, 0).setName("Box 226")
		);
		seats.add(new ModelRendererTurbo(seats, 361, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 14, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0)
			.setRotationPoint(-17, -12, 7).setRotationAngle(0, 0, -0.017453292f).setName("Box 227")
		);
		seats.add(new ModelRendererTurbo(seats, 417, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 14, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0)
			.setRotationPoint(-17, -12, -7).setRotationAngle(0, 0, -0.017453292f).setName("Box 228")
		);
		seats.add(new ModelRendererTurbo(seats, 1, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 14, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0)
			.setRotationPoint(-17, -12, -21).setRotationAngle(0, 0, -0.017453292f).setName("Box 229")
		);
		seats.add(new ModelRendererTurbo(seats, 185, 89, textureX, textureY).addBox(0, 0, 0, 10, 1, 1)
			.setRotationPoint(11, 4, 16).setRotationAngle(0, 0, 0).setName("Box 231")
		);
		seats.add(new ModelRendererTurbo(seats, 345, 89, textureX, textureY).addBox(0, 0, 0, 10, 1, 1)
			.setRotationPoint(11, 4, 7).setRotationAngle(0, 0, 0).setName("Box 232")
		);
		seats.add(new ModelRendererTurbo(seats, 433, 321, textureX, textureY).addBox(0, 0, 0, 14, 2, 16)
			.setRotationPoint(9, 2, 4).setRotationAngle(0, 0, 0).setName("Box 233")
		);
		seats.add(new ModelRendererTurbo(seats, 473, 89, textureX, textureY).addBox(0, 0, 0, 10, 1, 1)
			.setRotationPoint(11, 4, -17).setRotationAngle(0, 0, 0).setName("Box 234")
		);
		seats.add(new ModelRendererTurbo(seats, 57, 97, textureX, textureY).addBox(0, 0, 0, 10, 1, 1)
			.setRotationPoint(11, 4, -8).setRotationAngle(0, 0, 0).setName("Box 235")
		);
		seats.add(new ModelRendererTurbo(seats, 49, 345, textureX, textureY).addBox(0, 0, 0, 14, 2, 16)
			.setRotationPoint(9, 2, -20).setRotationAngle(0, 0, 0).setName("Box 236")
		);
		seats.add(new ModelRendererTurbo(seats, 201, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 16, 16, 0, 1, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(8, -14, 4).setRotationAngle(0, 0, 0).setName("Box 237")
		);
		seats.add(new ModelRendererTurbo(seats, 337, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 16, 16, 0, 1, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(8, -14, -20).setRotationAngle(0, 0, 0).setName("Box 238")
		);
		seats.add(new ModelRendererTurbo(seats, 185, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0)
			.setRotationPoint(8, 2, 6).setRotationAngle(0, 0, 0).setName("Box 239")
		);
		seats.add(new ModelRendererTurbo(seats, 305, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0)
			.setRotationPoint(8, 2, -18).setRotationAngle(0, 0, 0).setName("Box 240")
		);
		seats.add(new ModelRendererTurbo(seats, 1, 1, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(7.5f, -15, 9).setRotationAngle(0, 0, 0).setName("Box 241")
		);
		seats.add(new ModelRendererTurbo(seats, 17, 1, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(7.5f, -15, 14).setRotationAngle(0, 0, 0).setName("Box 242")
		);
		seats.add(new ModelRendererTurbo(seats, 489, 89, textureX, textureY).addBox(0, 0, 0, 2, 3, 8)
			.setRotationPoint(7, -18, 8).setRotationAngle(0, 0, 0).setName("Box 243")
		);
		seats.add(new ModelRendererTurbo(seats, 25, 1, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(7.5f, -15, -15).setRotationAngle(0, 0, 0).setName("Box 244")
		);
		seats.add(new ModelRendererTurbo(seats, 81, 1, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(7.5f, -15, -10).setRotationAngle(0, 0, 0).setName("Box 245")
		);
		seats.add(new ModelRendererTurbo(seats, 473, 97, textureX, textureY).addBox(0, 0, 0, 2, 3, 8)
			.setRotationPoint(7, -18, -16).setRotationAngle(0, 0, 0).setName("Box 246")
		);
		this.groups.add(seats);
	}

}