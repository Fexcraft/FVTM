//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.part.c9;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.4-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/part/c9_seats")
public class C9Seats extends PartModel {

	public C9Seats(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList seats = new TurboList("seats");
		seats.add(new ModelRendererTurbo(seats, 65, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 11, 4, 34, 0, 0, 0, 0.4f, -0.3f, 0, -0.4f, -0.3f, 0, -0.4f, 0, 0, 0.4f, 0, 0, 0.6f, 0.4f, 0, 0, 0.4f, 0, 0, 0, 0, 0.6f)
			.setRotationPoint(-21.5f, 7.8f, -17).setRotationAngle(0, 0, 0).setName("Box 381")
		);
		seats.add(new ModelRendererTurbo(seats, 249, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 15, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -5, 0, 2, 4, 0, 0, 4, 0, 0, -5, 0, 2)
			.setRotationPoint(-27, -6.6f, -16).setRotationAngle(0, 0, 0).setName("Box 427")
		);
		seats.add(new ModelRendererTurbo(seats, 393, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 11, 1, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-37, -6.5f, -6).setRotationAngle(0, 0, 0).setName("Box 428")
		);
		seats.add(new ModelRendererTurbo(seats, 441, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 11, 1, 11, 0, -0.8f, -0.85f, -0.5f, 0, -0.2f, -0.5f, 0, 0, 0, 0, 0, 0, -0.9f, 0.8f, 0, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-37, -6.5f, -17).setRotationAngle(0, 0, 0).setName("Box 429")
		);
		seats.add(new ModelRendererTurbo(seats, 145, 201, textureX, textureY)
			.addShapeBox(0, 0, 0, 11, 1, 11, 0, 0, 0, 0, 0, 0, 0, 0, -0.2f, -0.5f, -0.8f, -0.85f, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, -0.9f, 0.8f, 0)
			.setRotationPoint(-37, -6.5f, 6).setRotationAngle(0, 0, 0).setName("Box 430")
		);
		seats.add(new ModelRendererTurbo(seats, 1, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 17, 2, 0, 7.5f, 0, 0, 0, 0, 0, -1.5f, -0.5f, -1, 2, -0.1f, -0.5f, 1, -9.5f, 0, 5, 0, 0, 4, 0, 1, 0, -8, 0)
			.setRotationPoint(-27, -6.6f, 16).setRotationAngle(0, 0, 0).setName("Box 431")
		);
		seats.add(new ModelRendererTurbo(seats, 393, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 9, 1, 0, -0.4f, 0.5f, -0.5f, 0, 0, 0, -1.2f, -6.2f, 0.8f, 0.1f, -1.1f, 0.3f, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0)
			.setRotationPoint(-29.5f, -6.1f, 17).setRotationAngle(0, 0, 0).setName("Box 432")
		);
		seats.add(new ModelRendererTurbo(seats, 49, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 17, 2, 0, 2, -0.1f, -0.5f, -1.5f, -0.5f, -1, 0, 0, 0, 7.5f, 0, 0, 0, -8, 0, 4, 0, 1, 5, 0, 0, 1, -9.5f, 0)
			.setRotationPoint(-27, -6.6f, -18).setRotationAngle(0, 0, 0).setName("Box 433")
		);
		seats.add(new ModelRendererTurbo(seats, 409, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 9, 1, 0, 0.1f, -1.1f, 0.3f, -1.2f, -6.2f, 0.8f, 0, 0, 0, -0.4f, 0.5f, -0.5f, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0)
			.setRotationPoint(-29.5f, -6.1f, -18).setRotationAngle(0, 0, 0).setName("Box 434")
		);
		seats.add(new ModelRendererTurbo(seats, 193, 201, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 15, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0)
			.setRotationPoint(-7.5f, -6, -15.5f).setRotationAngle(0, 0, 0).setName("Box 442")
		);
		seats.add(new ModelRendererTurbo(seats, 321, 201, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 15, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0)
			.setRotationPoint(-7.5f, -6, 3.5f).setRotationAngle(0, 0, 0).setName("Box 443")
		);
		seats.add(new ModelRendererTurbo(seats, 353, 201, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 3, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-4.5f, 7.8f, -15.5f).setRotationAngle(0, 0, 0).setName("Box 444")
		);
		seats.add(new ModelRendererTurbo(seats, 9, 209, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 3, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-4.5f, 7.8f, 3.5f).setRotationAngle(0, 0, 0).setName("Box 445")
		);
		this.groups.add(seats);
	}

}