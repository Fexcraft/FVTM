//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.part.ab1b;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of
 *  FMT (Fex's Modelling Toolbox) v.1.0.1-test &copy; 2018 - Fexcraft.net
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/part/ab1b_passenger_seats")
public class AB1PS extends PartModel {

	public AB1PS(){
		super(); textureX = 1024; textureY = 1024;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList seats = new TurboList("seats");
		seats.add(new ModelRendererTurbo(seats, 825, 1, textureX, textureY).addBox(0, 0, 0, 6, 4, 1)
			.setRotationPoint(42, -17, 27).setRotationAngle(0, 0, 0).setName("Box 118")
		);
		seats.add(new ModelRendererTurbo(seats, 905, 1, textureX, textureY).addBox(0, 0, 0, 6, 4, 1)
			.setRotationPoint(42, -17, 8).setRotationAngle(0, 0, 0).setName("Box 119")
		);
		seats.add(new ModelRendererTurbo(seats, 665, 121, textureX, textureY).addBox(0, 0, 0, 12, 2, 24)
			.setRotationPoint(39, -18, 6).setRotationAngle(0, 0, 0).setName("Box 120")
		);
		seats.add(new ModelRendererTurbo(seats, 505, 121, textureX, textureY).addBox(0, 0, 0, 2, 14, 24)
			.setRotationPoint(38, -31, 6).setRotationAngle(0, 0, -0.06981317f).setName("Box 121")
		);
		seats.add(new ModelRendererTurbo(seats, 985, 1, textureX, textureY).addBox(0, 0, 0, 6, 4, 1)
			.setRotationPoint(42, -17, -28).setRotationAngle(0, 0, 0).setName("Box 122")
		);
		seats.add(new ModelRendererTurbo(seats, 617, 9, textureX, textureY).addBox(0, 0, 0, 6, 4, 1)
			.setRotationPoint(42, -17, -9).setRotationAngle(0, 0, 0).setName("Box 123")
		);
		seats.add(new ModelRendererTurbo(seats, 249, 137, textureX, textureY).addBox(0, 0, 0, 12, 2, 24)
			.setRotationPoint(39, -18, -30).setRotationAngle(0, 0, 0).setName("Box 124")
		);
		seats.add(new ModelRendererTurbo(seats, 969, 153, textureX, textureY).addBox(0, 0, 0, 2, 14, 24)
			.setRotationPoint(38, -31, -30).setRotationAngle(0, 0, -0.06981317f).setName("Box 125")
		);
		seats.add(new ModelRendererTurbo(seats, 601, 41, textureX, textureY).addBox(0, 0, 0, 6, 4, 1)
			.setRotationPoint(24, -17, 8).setRotationAngle(0, 0, 0).setName("Box 126")
		);
		seats.add(new ModelRendererTurbo(seats, 401, 177, textureX, textureY).addBox(0, 0, 0, 12, 2, 24)
			.setRotationPoint(21, -18, 6).setRotationAngle(0, 0, 0).setName("Box 127")
		);
		seats.add(new ModelRendererTurbo(seats, 705, 169, textureX, textureY).addBox(0, 0, 0, 2, 14, 24)
			.setRotationPoint(20, -31, 6).setRotationAngle(0, 0, -0.06981317f).setName("Box 128")
		);
		seats.add(new ModelRendererTurbo(seats, 73, 49, textureX, textureY).addBox(0, 0, 0, 6, 4, 1)
			.setRotationPoint(24, -17, 27).setRotationAngle(0, 0, 0).setName("Box 143")
		);
		seats.add(new ModelRendererTurbo(seats, 25, 73, textureX, textureY).addBox(0, 0, 0, 6, 4, 1)
			.setRotationPoint(24, -17, -28).setRotationAngle(0, 0, 0).setName("Box 144")
		);
		seats.add(new ModelRendererTurbo(seats, 1, 81, textureX, textureY).addBox(0, 0, 0, 6, 4, 1)
			.setRotationPoint(24, -17, -9).setRotationAngle(0, 0, 0).setName("Box 145")
		);
		seats.add(new ModelRendererTurbo(seats, 305, 193, textureX, textureY).addBox(0, 0, 0, 12, 2, 24)
			.setRotationPoint(21, -18, -30).setRotationAngle(0, 0, 0).setName("Box 146")
		);
		seats.add(new ModelRendererTurbo(seats, 673, 185, textureX, textureY).addBox(0, 0, 0, 2, 14, 24)
			.setRotationPoint(20, -31, -30).setRotationAngle(0, 0, -0.06981317f).setName("Box 147")
		);
		seats.add(new ModelRendererTurbo(seats, 769, 193, textureX, textureY).addBox(0, 0, 0, 12, 2, 24)
			.setRotationPoint(57, -18, -30).setRotationAngle(0, 0, 0).setName("Box 204")
		);
		seats.add(new ModelRendererTurbo(seats, 33, 89, textureX, textureY).addBox(0, 0, 0, 6, 4, 1)
			.setRotationPoint(60, -16, -9).setRotationAngle(0, 0, 0).setName("Box 205")
		);
		seats.add(new ModelRendererTurbo(seats, 825, 201, textureX, textureY).addBox(0, 0, 0, 2, 14, 24)
			.setRotationPoint(56, -31, -30).setRotationAngle(0, 0, -0.06981317f).setName("Box 206")
		);
		seats.add(new ModelRendererTurbo(seats, 753, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 4, 11, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, 0, 0, 0)
			.setRotationPoint(75, -16, -17).setRotationAngle(0, 0, 0).setName("Box 208")
		);
		seats.add(new ModelRendererTurbo(seats, 257, 57, textureX, textureY).addBox(0, 0, 0, 1, 7, 2)
			.setRotationPoint(79, -23, -10).setRotationAngle(0, 0, 0).setName("Box 209")
		);
		seats.add(new ModelRendererTurbo(seats, 289, 57, textureX, textureY).addBox(0, 0, 0, 1, 7, 2)
			.setRotationPoint(79, -23, -29).setRotationAngle(0, 0, 0).setName("Box 210")
		);
		seats.add(new ModelRendererTurbo(seats, 161, 185, textureX, textureY).addBox(0, 0, 0, 2, 1, 24)
			.setRotationPoint(78.5f, -24, -31).setRotationAngle(0, 0, 0).setName("Box 211")
		);
		seats.add(new ModelRendererTurbo(seats, 377, 57, textureX, textureY).addBox(0, 0, 0, 1, 7, 2)
			.setRotationPoint(79, -23, -19.5f).setRotationAngle(0, 0, 0).setName("Box 212")
		);
		seats.add(new ModelRendererTurbo(seats, 729, 89, textureX, textureY).addBox(0, 0, 0, 6, 4, 1)
			.setRotationPoint(6, -17, 8).setRotationAngle(0, 0, 0).setName("Box 344")
		);
		seats.add(new ModelRendererTurbo(seats, 25, 105, textureX, textureY).addBox(0, 0, 0, 6, 4, 1)
			.setRotationPoint(6, -17, 27).setRotationAngle(0, 0, 0).setName("Box 345")
		);
		seats.add(new ModelRendererTurbo(seats, 969, 201, textureX, textureY).addBox(0, 0, 0, 2, 14, 24)
			.setRotationPoint(2, -31, 6).setRotationAngle(0, 0, -0.06981317f).setName("Box 346")
		);
		seats.add(new ModelRendererTurbo(seats, 857, 193, textureX, textureY).addBox(0, 0, 0, 12, 2, 24)
			.setRotationPoint(3, -18, 6).setRotationAngle(0, 0, 0).setName("Box 347")
		);
		seats.add(new ModelRendererTurbo(seats, 753, 105, textureX, textureY).addBox(0, 0, 0, 6, 4, 1)
			.setRotationPoint(-12, -17, 8).setRotationAngle(0, 0, 0).setName("Box 348")
		);
		seats.add(new ModelRendererTurbo(seats, 769, 105, textureX, textureY).addBox(0, 0, 0, 6, 4, 1)
			.setRotationPoint(-12, -17, 27).setRotationAngle(0, 0, 0).setName("Box 349")
		);
		seats.add(new ModelRendererTurbo(seats, 393, 241, textureX, textureY).addBox(0, 0, 0, 2, 14, 24)
			.setRotationPoint(-16, -31, 6).setRotationAngle(0, 0, -0.06981317f).setName("Box 350")
		);
		seats.add(new ModelRendererTurbo(seats, 49, 201, textureX, textureY).addBox(0, 0, 0, 12, 2, 24)
			.setRotationPoint(-15, -18, 6).setRotationAngle(0, 0, 0).setName("Box 351")
		);
		seats.add(new ModelRendererTurbo(seats, 785, 105, textureX, textureY).addBox(0, 0, 0, 6, 4, 1)
			.setRotationPoint(-30, -17, 8).setRotationAngle(0, 0, 0).setName("Box 352")
		);
		seats.add(new ModelRendererTurbo(seats, 801, 105, textureX, textureY).addBox(0, 0, 0, 6, 4, 1)
			.setRotationPoint(-30, -17, 27).setRotationAngle(0, 0, 0).setName("Box 353")
		);
		seats.add(new ModelRendererTurbo(seats, 825, 241, textureX, textureY).addBox(0, 0, 0, 2, 14, 24)
			.setRotationPoint(-34, -31, 6).setRotationAngle(0, 0, -0.06981317f).setName("Box 354")
		);
		seats.add(new ModelRendererTurbo(seats, 193, 209, textureX, textureY).addBox(0, 0, 0, 12, 2, 24)
			.setRotationPoint(-33, -18, 6).setRotationAngle(0, 0, 0).setName("Box 355")
		);
		seats.add(new ModelRendererTurbo(seats, 817, 105, textureX, textureY).addBox(0, 0, 0, 6, 4, 1)
			.setRotationPoint(-48, -17, 8).setRotationAngle(0, 0, 0).setName("Box 356")
		);
		seats.add(new ModelRendererTurbo(seats, 833, 105, textureX, textureY).addBox(0, 0, 0, 6, 4, 1)
			.setRotationPoint(-48, -17, 27).setRotationAngle(0, 0, 0).setName("Box 357")
		);
		seats.add(new ModelRendererTurbo(seats, 953, 273, textureX, textureY).addBox(0, 0, 0, 2, 14, 24)
			.setRotationPoint(-52, -31, 6).setRotationAngle(0, 0, -0.06981317f).setName("Box 358")
		);
		seats.add(new ModelRendererTurbo(seats, 97, 289, textureX, textureY).addBox(0, 0, 0, 12, 2, 24)
			.setRotationPoint(-51, -18, 6).setRotationAngle(0, 0, 0).setName("Box 359")
		);
		seats.add(new ModelRendererTurbo(seats, 169, 113, textureX, textureY).addBox(0, 0, 0, 6, 4, 1)
			.setRotationPoint(-68, -19, 8).setRotationAngle(0, 0, 0).setName("Box 360")
		);
		seats.add(new ModelRendererTurbo(seats, 985, 113, textureX, textureY).addBox(0, 0, 0, 6, 4, 1)
			.setRotationPoint(-68, -19, 27).setRotationAngle(0, 0, 0).setName("Box 361")
		);
		seats.add(new ModelRendererTurbo(seats, 1, 289, textureX, textureY).addBox(0, 0, 0, 2, 14, 24)
			.setRotationPoint(-72, -34, 6).setRotationAngle(0, 0, -0.06981317f).setName("Box 362")
		);
		seats.add(new ModelRendererTurbo(seats, 225, 289, textureX, textureY).addBox(0, 0, 0, 12, 2, 24)
			.setRotationPoint(-71, -21, 6).setRotationAngle(0, 0, 0).setName("Box 363")
		);
		seats.add(new ModelRendererTurbo(seats, 449, 121, textureX, textureY).addBox(0, 0, 0, 6, 4, 1)
			.setRotationPoint(6, -17, -9).setRotationAngle(0, 0, 0).setName("Box 364")
		);
		seats.add(new ModelRendererTurbo(seats, 857, 289, textureX, textureY).addBox(0, 0, 0, 12, 2, 24)
			.setRotationPoint(3, -18, -30).setRotationAngle(0, 0, 0).setName("Box 365")
		);
		seats.add(new ModelRendererTurbo(seats, 985, 121, textureX, textureY).addBox(0, 0, 0, 6, 4, 1)
			.setRotationPoint(6, -17, -28).setRotationAngle(0, 0, 0).setName("Box 366")
		);
		seats.add(new ModelRendererTurbo(seats, 337, 289, textureX, textureY).addBox(0, 0, 0, 2, 14, 24)
			.setRotationPoint(2, -31, -30).setRotationAngle(0, 0, -0.06981317f).setName("Box 367")
		);
		seats.add(new ModelRendererTurbo(seats, 449, 129, textureX, textureY).addBox(0, 0, 0, 6, 4, 1)
			.setRotationPoint(-12, -17, -9).setRotationAngle(0, 0, 0).setName("Box 368")
		);
		seats.add(new ModelRendererTurbo(seats, 393, 297, textureX, textureY).addBox(0, 0, 0, 12, 2, 24)
			.setRotationPoint(-15, -18, -30).setRotationAngle(0, 0, 0).setName("Box 369")
		);
		seats.add(new ModelRendererTurbo(seats, 785, 129, textureX, textureY).addBox(0, 0, 0, 6, 4, 1)
			.setRotationPoint(-12, -17, -28).setRotationAngle(0, 0, 0).setName("Box 370")
		);
		seats.add(new ModelRendererTurbo(seats, 153, 297, textureX, textureY).addBox(0, 0, 0, 2, 14, 24)
			.setRotationPoint(-16, -31, -30).setRotationAngle(0, 0, -0.06981317f).setName("Box 371")
		);
		seats.add(new ModelRendererTurbo(seats, 105, 137, textureX, textureY).addBox(0, 0, 0, 6, 4, 1)
			.setRotationPoint(-30, -17, -9).setRotationAngle(0, 0, 0).setName("Box 372")
		);
		seats.add(new ModelRendererTurbo(seats, 473, 297, textureX, textureY).addBox(0, 0, 0, 12, 2, 24)
			.setRotationPoint(-33, -18, -30).setRotationAngle(0, 0, 0).setName("Box 373")
		);
		seats.add(new ModelRendererTurbo(seats, 329, 137, textureX, textureY).addBox(0, 0, 0, 6, 4, 1)
			.setRotationPoint(-30, -17, -28).setRotationAngle(0, 0, 0).setName("Box 374")
		);
		seats.add(new ModelRendererTurbo(seats, 553, 297, textureX, textureY).addBox(0, 0, 0, 2, 14, 24)
			.setRotationPoint(-34, -31, -30).setRotationAngle(0, 0, -0.06981317f).setName("Box 375")
		);
		seats.add(new ModelRendererTurbo(seats, 873, 289, textureX, textureY).addBox(0, 0, 0, 2, 14, 59)
			.setRotationPoint(-106.5f, -36, -30).setRotationAngle(0, 0, -0.06981317f).setName("Box 376")
		);
		seats.add(new ModelRendererTurbo(seats, 681, 121, textureX, textureY).addBox(0, 0, 0, 1, 13, 2)
			.setRotationPoint(-55.5f, -26, -29).setRotationAngle(0, 0, 0).setName("Box 377")
		);
		seats.add(new ModelRendererTurbo(seats, 969, 241, textureX, textureY).addBox(0, 0, 0, 2, 1, 24)
			.setRotationPoint(-56, -27, -31).setRotationAngle(0, 0, 0).setName("Box 378")
		);
		seats.add(new ModelRendererTurbo(seats, 121, 137, textureX, textureY).addBox(0, 0, 0, 1, 13, 2)
			.setRotationPoint(-55.5f, -26, -19.5f).setRotationAngle(0, 0, 0).setName("Box 379")
		);
		seats.add(new ModelRendererTurbo(seats, 265, 137, textureX, textureY).addBox(0, 0, 0, 1, 13, 2)
			.setRotationPoint(-55.5f, -26, -10).setRotationAngle(0, 0, 0).setName("Box 380")
		);
		seats.add(new ModelRendererTurbo(seats, 377, 137, textureX, textureY).addBox(0, 0, 0, 6, 4, 1)
			.setRotationPoint(-68, -19, -9).setRotationAngle(0, 0, 0).setName("Box 381")
		);
		seats.add(new ModelRendererTurbo(seats, 393, 137, textureX, textureY).addBox(0, 0, 0, 6, 4, 1)
			.setRotationPoint(-68, -19, -28).setRotationAngle(0, 0, 0).setName("Box 382")
		);
		seats.add(new ModelRendererTurbo(seats, 609, 297, textureX, textureY).addBox(0, 0, 0, 12, 2, 24)
			.setRotationPoint(-71, -21, -30).setRotationAngle(0, 0, 0).setName("Box 383")
		);
		seats.add(new ModelRendererTurbo(seats, 689, 297, textureX, textureY).addBox(0, 0, 0, 2, 14, 24)
			.setRotationPoint(-72, -34, -30).setRotationAngle(0, 0, -0.06981317f).setName("Box 384")
		);
		seats.add(new ModelRendererTurbo(seats, 745, 297, textureX, textureY).addBox(0, 0, 0, 2, 14, 24)
			.setRotationPoint(-90, -37, 6).setRotationAngle(0, 0, -0.06981317f).setName("Box 385")
		);
		seats.add(new ModelRendererTurbo(seats, 377, 145, textureX, textureY).addBox(0, 0, 0, 6, 4, 1)
			.setRotationPoint(-86, -23, 27).setRotationAngle(0, 0, 0).setName("Box 386")
		);
		seats.add(new ModelRendererTurbo(seats, 449, 145, textureX, textureY).addBox(0, 0, 0, 6, 4, 1)
			.setRotationPoint(-86, -23, 8).setRotationAngle(0, 0, 0).setName("Box 387")
		);
		seats.add(new ModelRendererTurbo(seats, 801, 297, textureX, textureY).addBox(0, 0, 0, 12, 2, 24)
			.setRotationPoint(-89, -24, 6).setRotationAngle(0, 0, 0).setName("Box 388")
		);
		seats.add(new ModelRendererTurbo(seats, 385, 329, textureX, textureY).addBox(0, 0, 0, 2, 14, 24)
			.setRotationPoint(-90, -37, -30).setRotationAngle(0, 0, -0.06981317f).setName("Box 389")
		);
		seats.add(new ModelRendererTurbo(seats, 377, 153, textureX, textureY).addBox(0, 0, 0, 6, 4, 1)
			.setRotationPoint(-86, -23, -9).setRotationAngle(0, 0, 0).setName("Box 390")
		);
		seats.add(new ModelRendererTurbo(seats, 689, 153, textureX, textureY).addBox(0, 0, 0, 6, 4, 1)
			.setRotationPoint(-86, -23, -28).setRotationAngle(0, 0, 0).setName("Box 391")
		);
		seats.add(new ModelRendererTurbo(seats, 937, 313, textureX, textureY).addBox(0, 0, 0, 12, 2, 24)
			.setRotationPoint(-89, -24, -30).setRotationAngle(0, 0, 0).setName("Box 392")
		);
		seats.add(new ModelRendererTurbo(seats, 385, 329, textureX, textureY).addBox(0, 0, 0, 12, 2, 59)
			.setRotationPoint(-105, -24, -30).setRotationAngle(0, 0, 0).setName("Box 393")
		);
		seats.add(new ModelRendererTurbo(seats, 833, 153, textureX, textureY).addBox(0, 0, 0, 6, 4, 1)
			.setRotationPoint(-102, -23, 8).setRotationAngle(0, 0, 0).setName("Box 394")
		);
		seats.add(new ModelRendererTurbo(seats, 889, 153, textureX, textureY).addBox(0, 0, 0, 6, 4, 1)
			.setRotationPoint(-102, -23, 27).setRotationAngle(0, 0, 0).setName("Box 395")
		);
		seats.add(new ModelRendererTurbo(seats, 905, 153, textureX, textureY).addBox(0, 0, 0, 6, 4, 1)
			.setRotationPoint(-102, -23, -9).setRotationAngle(0, 0, 0).setName("Box 396")
		);
		seats.add(new ModelRendererTurbo(seats, 921, 153, textureX, textureY).addBox(0, 0, 0, 6, 4, 1)
			.setRotationPoint(-102, -23, -28).setRotationAngle(0, 0, 0).setName("Box 397")
		);
		this.groups.add(seats);
		//
	}

}