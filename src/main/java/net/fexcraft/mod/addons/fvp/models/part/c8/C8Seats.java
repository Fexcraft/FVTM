//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.part.c8;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.4-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/part/c8_seats")
public class C8Seats extends PartModel {

	public C8Seats(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList seats = new TurboList("seats");
		seats.add(new ModelRendererTurbo(seats, 282, 60, textureX, textureY).addBox(0, 0, 0, 12, 2, 36)
			.setRotationPoint(-16, 0, -18).setRotationAngle(0, 0, 0).setName("Box 136")
		);
		seats.add(new ModelRendererTurbo(seats, 355, 130, textureX, textureY).addBox(0, 0, 0, 2, 14, 36)
			.setRotationPoint(-18, -13, -18).setRotationAngle(0, 0, -0.15707964f).setName("Box 137")
		);
		seats.add(new ModelRendererTurbo(seats, 231, 57, textureX, textureY).addBox(0, 0, 0, 12, 2, 14)
			.setRotationPoint(3, 0, 4).setRotationAngle(0, 0, 0).setName("Box 140")
		);
		seats.add(new ModelRendererTurbo(seats, 192, 54, textureX, textureY).addBox(0, 0, 0, 12, 2, 14)
			.setRotationPoint(3, 0, -18).setRotationAngle(0, 0, 0).setName("Box 141")
		);
		seats.add(new ModelRendererTurbo(seats, 394, 96, textureX, textureY).addBox(0, 0, 0, 2, 14, 14)
			.setRotationPoint(1, -13, 4).setRotationAngle(0, 0, -0.15707964f).setName("Box 142")
		);
		seats.add(new ModelRendererTurbo(seats, 474, 82, textureX, textureY).addBox(0, 0, 0, 2, 14, 14)
			.setRotationPoint(1, -13, -18).setRotationAngle(0, 0, -0.15707964f).setName("Box 143")
		);
		seats.add(new ModelRendererTurbo(seats, 149, 19, textureX, textureY).addBox(0, 0, 0, 10, 1, 2)
			.setRotationPoint(4, 2, 6).setRotationAngle(0, 0, 0).setName("Box 201")
		);
		seats.add(new ModelRendererTurbo(seats, 0, 17, textureX, textureY).addBox(0, 0, 0, 10, 1, 2)
			.setRotationPoint(4, 2, 14).setRotationAngle(0, 0, 0).setName("Box 202")
		);
		seats.add(new ModelRendererTurbo(seats, 396, 15, textureX, textureY).addBox(0, 0, 0, 10, 1, 2)
			.setRotationPoint(4, 2, -8).setRotationAngle(0, 0, 0).setName("Box 203")
		);
		seats.add(new ModelRendererTurbo(seats, 149, 15, textureX, textureY).addBox(0, 0, 0, 10, 1, 2)
			.setRotationPoint(4, 2, -16).setRotationAngle(0, 0, 0).setName("Box 204")
		);
		seats.add(new ModelRendererTurbo(seats, 0, 13, textureX, textureY).addBox(0, 0, 0, 10, 1, 2)
			.setRotationPoint(-15, 2, 6).setRotationAngle(0, 0, 0).setName("Box 205")
		);
		seats.add(new ModelRendererTurbo(seats, 396, 11, textureX, textureY).addBox(0, 0, 0, 10, 1, 2)
			.setRotationPoint(-15, 2, 14).setRotationAngle(0, 0, 0).setName("Box 206")
		);
		seats.add(new ModelRendererTurbo(seats, 149, 11, textureX, textureY).addBox(0, 0, 0, 10, 1, 2)
			.setRotationPoint(-15, 2, -16).setRotationAngle(0, 0, 0).setName("Box 207")
		);
		seats.add(new ModelRendererTurbo(seats, 0, 9, textureX, textureY).addBox(0, 0, 0, 10, 1, 2)
			.setRotationPoint(-15, 2, -8).setRotationAngle(0, 0, 0).setName("Box 208")
		);
		seats.addProgram(DefaultPrograms.RGB_SECONDARY);
		this.groups.add(seats);
	}

}