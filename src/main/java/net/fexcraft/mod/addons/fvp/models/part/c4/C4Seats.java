//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.part.c4;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.7-test &copy; 2019 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/part/c4_front_seats")
public class C4Seats extends PartModel {

	public C4Seats(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList seats = new TurboList("seats");
		seats.add(new ModelRendererTurbo(seats, 474, 61, textureX, textureY).addBox(0, 0, 0, 14, 2, 1)
			.setRotationPoint(14, -12, 17).setRotationAngle(0, 0, 0).setName("Box 77")
		);
		seats.add(new ModelRendererTurbo(seats, 235, 57, textureX, textureY).addBox(0, 0, 0, 14, 2, 1)
			.setRotationPoint(14, -12, 8).setRotationAngle(0, 0, 0).setName("Box 78")
		);
		seats.add(new ModelRendererTurbo(seats, 352, 99, textureX, textureY).addBox(0, 0, 0, 16, 2, 14)
			.setRotationPoint(13, -14, 6).setRotationAngle(0, 0, 0).setName("Box 79")
		);
		seats.add(new ModelRendererTurbo(seats, 286, 52, textureX, textureY).addBox(0, 0, 0, 14, 2, 1)
			.setRotationPoint(14, -12, -18).setRotationAngle(0, 0, 0).setName("Box 82")
		);
		seats.add(new ModelRendererTurbo(seats, 286, 48, textureX, textureY).addBox(0, 0, 0, 14, 2, 1)
			.setRotationPoint(14, -12, -9).setRotationAngle(0, 0, 0).setName("Box 83")
		);
		seats.add(new ModelRendererTurbo(seats, 217, 84, textureX, textureY).addBox(0, 0, 0, 16, 2, 14)
			.setRotationPoint(13, -14, -20).setRotationAngle(0, 0, 0).setName("Box 84")
		);
		seats.add(new ModelRendererTurbo(seats, 327, 143, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 16, 14, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(13, -30, 6).setRotationAngle(0, 0, 0).setName("Box 85")
		);
		seats.add(new ModelRendererTurbo(seats, 59, 141, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 16, 14, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(13, -30, -20).setRotationAngle(0, 0, 0).setName("Box 86")
		);
		seats.add(new ModelRendererTurbo(seats, 317, 51, textureX, textureY).addBox(0, 0, 0, 1, 2, 1)
			.setRotationPoint(13.5f, -31, 15).setRotationAngle(0, 0, 0).setName("Box 87")
		);
		seats.add(new ModelRendererTurbo(seats, 317, 47, textureX, textureY).addBox(0, 0, 0, 1, 2, 1)
			.setRotationPoint(13.5f, -31, 10).setRotationAngle(0, 0, 0).setName("Box 88")
		);
		seats.add(new ModelRendererTurbo(seats, 317, 37, textureX, textureY).addBox(0, 0, 0, 1, 2, 1)
			.setRotationPoint(13.5f, -31, -11).setRotationAngle(0, 0, 0).setName("Box 89")
		);
		seats.add(new ModelRendererTurbo(seats, 277, 30, textureX, textureY).addBox(0, 0, 0, 1, 2, 1)
			.setRotationPoint(13.5f, -31, -16).setRotationAngle(0, 0, 0).setName("Box 90")
		);
		seats.add(new ModelRendererTurbo(seats, 491, 135, textureX, textureY).addBox(0, 0, 0, 2, 4, 8)
			.setRotationPoint(13, -35, 9).setRotationAngle(0, 0, 0).setName("Box 91")
		);
		seats.add(new ModelRendererTurbo(seats, 442, 132, textureX, textureY).addBox(0, 0, 0, 2, 4, 8)
			.setRotationPoint(13, -35, -17).setRotationAngle(0, 0, 0).setName("Box 92")
		);
		seats.addProgram(DefaultPrograms.RGB_SECONDARY); this.groups.add(seats);
	}

}
