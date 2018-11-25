//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.part.c7;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.1-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/part/c7_seats")
public class C7Seats extends PartModel {

	public C7Seats(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList seats = new TurboList("seats");
		seats.add(new ModelRendererTurbo(seats, 297, 105, textureX, textureY).addBox(0, 0, 0, 8, 1, 1)
			.setRotationPoint(-20, -4, 12).setRotationAngle(0, 0, 0).setName("Box 210")
		);
		seats.add(new ModelRendererTurbo(seats, 265, 121, textureX, textureY).addBox(0, 0, 0, 8, 1, 1)
			.setRotationPoint(-20, -4, -13).setRotationAngle(0, 0, 0).setName("Box 211")
		);
		seats.add(new ModelRendererTurbo(seats, 425, 121, textureX, textureY).addBox(0, 0, 0, 8, 1, 1)
			.setRotationPoint(-20, -4, -6).setRotationAngle(0, 0, 0).setName("Box 212")
		);
		seats.add(new ModelRendererTurbo(seats, 465, 121, textureX, textureY).addBox(0, 0, 0, 8, 1, 1)
			.setRotationPoint(-20, -4, 5).setRotationAngle(0, 0, 0).setName("Box 213")
		);
		seats.add(new ModelRendererTurbo(seats, 1, 129, textureX, textureY).addBox(0, 0, 0, 10, 2, 30)
			.setRotationPoint(-21, -6, -15).setRotationAngle(0, 0, 0).setName("Box 214")
		);
		seats.add(new ModelRendererTurbo(seats, 409, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 10, 0, 0, 0, 0, 0, -0.2f, -1, 0, -0.2f, -1, 0, 0, 0, 0, 0, 0, 0, -0.2f, -1, 0, -0.2f, -1, 0, 0, 0)
			.setRotationPoint(-11, -6, -15).setRotationAngle(0, 0, 0).setName("Box 215")
		);
		seats.add(new ModelRendererTurbo(seats, 1, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 10, 0, 0, 0, 0, 0, -0.2f, -1, 0, -0.2f, -1, 0, 0, 0, 0, 0, 0, 0, -0.2f, -1, 0, -0.2f, -1, 0, 0, 0)
			.setRotationPoint(-11, -6, -5).setRotationAngle(0, 0, 0).setName("Box 216")
		);
		seats.add(new ModelRendererTurbo(seats, 57, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 10, 0, 0, 0, 0, 0, -0.2f, -1, 0, -0.2f, -1, 0, 0, 0, 0, 0, 0, 0, -0.2f, -1, 0, -0.2f, -1, 0, 0, 0)
			.setRotationPoint(-11, -6, 5).setRotationAngle(0, 0, 0).setName("Box 217")
		);
		seats.add(new ModelRendererTurbo(seats, 89, 129, textureX, textureY).addBox(0, 0, 0, 2, 12, 30)
			.setRotationPoint(-22, -17.5f, -15).setRotationAngle(0, 0, -0.06981317f).setName("Box 218")
		);
		seats.add(new ModelRendererTurbo(seats, 81, 129, textureX, textureY)
			.addShapeBox(0, -1, 0, 2, 1, 10, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-22, -17.5f, -15).setRotationAngle(0, 0, -0.06981317f).setName("Box 219")
		);
		seats.add(new ModelRendererTurbo(seats, 129, 129, textureX, textureY)
			.addShapeBox(0, -1, 10, 2, 1, 10, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-22, -17.5f, -15).setRotationAngle(0, 0, -0.06981317f).setName("Box 220")
		);
		seats.add(new ModelRendererTurbo(seats, 273, 129, textureX, textureY)
			.addShapeBox(0, -1, 0, 2, 1, 10, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-22, -17.5f, 5).setRotationAngle(0, 0, -0.06981317f).setName("Box 221")
		);
		seats.add(new ModelRendererTurbo(seats, 97, 129, textureX, textureY).addBox(0, 0, 0, 8, 1, 1)
			.setRotationPoint(1, -4, 13).setRotationAngle(0, 0, 0).setName("Box 222")
		);
		seats.add(new ModelRendererTurbo(seats, 337, 129, textureX, textureY).addBox(0, 0, 0, 8, 1, 1)
			.setRotationPoint(1, -4, 6).setRotationAngle(0, 0, 0).setName("Box 223")
		);
		seats.add(new ModelRendererTurbo(seats, 361, 129, textureX, textureY).addBox(0, 0, 0, 8, 1, 1)
			.setRotationPoint(1, -4, -14).setRotationAngle(0, 0, 0).setName("Box 224")
		);
		seats.add(new ModelRendererTurbo(seats, 385, 129, textureX, textureY).addBox(0, 0, 0, 8, 1, 1)
			.setRotationPoint(1, -4, -7).setRotationAngle(0, 0, 0).setName("Box 225")
		);
		seats.add(new ModelRendererTurbo(seats, 425, 129, textureX, textureY).addBox(0, 0, 0, 10, 2, 10)
			.setRotationPoint(0, -6, 5).setRotationAngle(0, 0, 0).setName("Box 226")
		);
		seats.add(new ModelRendererTurbo(seats, 145, 137, textureX, textureY).addBox(0, 0, 0, 10, 2, 10)
			.setRotationPoint(0, -6, -15).setRotationAngle(0, 0, 0).setName("Box 227")
		);
		seats.add(new ModelRendererTurbo(seats, 473, 129, textureX, textureY).addBox(0, 0, 0, 2, 12, 10)
			.setRotationPoint(-1, -17.5f, 5).setRotationAngle(0, 0, -0.06981317f).setName("Box 228")
		);
		seats.add(new ModelRendererTurbo(seats, 193, 137, textureX, textureY).addBox(0, 0, 0, 2, 12, 10)
			.setRotationPoint(-1, -17.5f, -15).setRotationAngle(0, 0, -0.06981317f).setName("Box 229")
		);
		seats.add(new ModelRendererTurbo(seats, 225, 137, textureX, textureY)
			.addShapeBox(0, -1, 0, 2, 1, 10, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-1, -17.5f, -15).setRotationAngle(0, 0, -0.06981317f).setName("Box 230")
		);
		seats.add(new ModelRendererTurbo(seats, 257, 137, textureX, textureY)
			.addShapeBox(0, -1, 0, 2, 1, 10, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-1, -17.5f, 5).setRotationAngle(0, 0, -0.06981317f).setName("Box 231")
		);
		seats.add(new ModelRendererTurbo(seats, 233, 41, textureX, textureY).addBox(0.5f, -2, 2.5f, 1, 1, 1)
			.setRotationPoint(-1, -17.5f, 5).setRotationAngle(0, 0, -0.06981317f).setName("Box 232")
		);
		seats.add(new ModelRendererTurbo(seats, 257, 41, textureX, textureY).addBox(0.5f, -2, 6.5f, 1, 1, 1)
			.setRotationPoint(-1, -17.5f, 5).setRotationAngle(0, 0, -0.06981317f).setName("Box 233")
		);
		seats.add(new ModelRendererTurbo(seats, 273, 41, textureX, textureY).addBox(0.5f, -2, 6.5f, 1, 1, 1)
			.setRotationPoint(-1, -17.5f, -15).setRotationAngle(0, 0, -0.06981317f).setName("Box 234")
		);
		seats.add(new ModelRendererTurbo(seats, 281, 41, textureX, textureY).addBox(0.5f, -2, 2.5f, 1, 1, 1)
			.setRotationPoint(-1, -17.5f, -15).setRotationAngle(0, 0, -0.06981317f).setName("Box 235")
		);
		seats.add(new ModelRendererTurbo(seats, 297, 137, textureX, textureY).addBox(0, -5, 1.5f, 2, 3, 7)
			.setRotationPoint(-1, -17.5f, 5).setRotationAngle(0, 0, -0.06981317f).setName("Box 236")
		);
		seats.add(new ModelRendererTurbo(seats, 321, 137, textureX, textureY).addBox(0, -5, 1.5f, 2, 3, 7)
			.setRotationPoint(-1, -17.5f, -15).setRotationAngle(0, 0, -0.06981317f).setName("Box 237")
		);
		seats.add(new ModelRendererTurbo(seats, 409, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 10, 0, 0, 0, 0, 0, -0.2f, -1, 0, -0.2f, -1, 0, 0, 0, 0, 0, 0, 0, -0.2f, -1, 0, -0.2f, -1, 0, 0, 0)
			.setRotationPoint(10, -6, 5).setRotationAngle(0, 0, 0).setName("Box 243")
		);
		seats.add(new ModelRendererTurbo(seats, 1, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 10, 0, 0, 0, 0, 0, -0.2f, -1, 0, -0.2f, -1, 0, 0, 0, 0, 0, 0, 0, -0.2f, -1, 0, -0.2f, -1, 0, 0, 0)
			.setRotationPoint(10, -6, -15).setRotationAngle(0, 0, 0).setName("Box 244")
		);
		seats.addProgram(DefaultPrograms.RGB_SECONDARY);
		this.groups.add(seats);
		//
	}

}