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
@fModel(registryname = "fvp:models/part/c1_r1_back_seats")
public class C1_R1BackSeats extends PartModel {

	public C1_R1BackSeats(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList back_seats = new TurboList("back_seats");
		back_seats.add(new ModelRendererTurbo(back_seats, 89, 177, textureX, textureY).addBox(0, 0, 3, 8, 2, 1)
			.setRotationPoint(-19, -2, 10).setRotationAngle(0, 0, 0).setName("Box 695")
		);
		back_seats.add(new ModelRendererTurbo(back_seats, 433, 161, textureX, textureY).addBox(0, 0, -4, 8, 2, 1)
			.setRotationPoint(-19, -2, 10).setRotationAngle(0, 0, 0).setName("Box 696")
		);
		back_seats.add(new ModelRendererTurbo(back_seats, 185, 185, textureX, textureY).addBox(0, 0, 3, 8, 2, 1)
			.setRotationPoint(-19, -2, -10).setRotationAngle(0, 0, 0).setName("Box 697")
		);
		back_seats.add(new ModelRendererTurbo(back_seats, 393, 177, textureX, textureY).addBox(0, 0, -4, 8, 2, 1)
			.setRotationPoint(-19, -2, -10).setRotationAngle(0, 0, 0).setName("Box 698")
		);
		back_seats.add(new ModelRendererTurbo(back_seats, 321, 313, textureX, textureY)
			.addShapeBox(0, 0, 0, 11, 1, 31, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, -1, 0, -1, -1, 0, -1, -1, 0, -1)
			.setRotationPoint(-20.5f, -3, -15.5f).setRotationAngle(0, 0, 0).setName("Box 699")
		);
		back_seats.add(new ModelRendererTurbo(back_seats, 377, 321, textureX, textureY).addBox(0, 0, 0, 12, 2, 36)
			.setRotationPoint(-21, -5, -18).setRotationAngle(0, 0, 0).setName("Box 700")
		);
		back_seats.add(new ModelRendererTurbo(back_seats, 1, 345, textureX, textureY).addBox(0, 0, 0, 2, 12, 36)
			.setRotationPoint(-23, -17, -18).setRotationAngle(0, 0, 0).setName("Box 701")
		);
		back_seats.add(new ModelRendererTurbo(back_seats, 281, 321, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 32, 0, -0.25f, 0, 0, 0, 0, 0, 0, 0, 0, -0.25f, 0, 0, -1.75f, -0.25f, 0, 0, -0.25f, 0, 0, -0.25f, 0, -1.75f, -0.25f, 0)
			.setRotationPoint(-23, -5, -16).setRotationAngle(0, 0, 0).setName("Box 702")
		);
		this.groups.add(back_seats);
	}

}