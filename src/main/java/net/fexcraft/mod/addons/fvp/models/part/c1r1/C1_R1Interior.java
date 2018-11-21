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
@fModel(registryname = "fvp:models/part/c1_r1_interior")
public class C1_R1Interior extends PartModel {

	public C1_R1Interior(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList interior = new TurboList("interior");
		interior.add(new ModelRendererTurbo(interior, 25, 297, textureX, textureY)
			.addShapeBox(0, -2, -19, 4, 9, 38, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -3, -1, 0, 0, 0, 0, 0, 0, 0, -3, -1)
			.setRotationPoint(21, -12, 0).setRotationAngle(0, 0, 0).setName("Box 692")
		);
		interior.add(new ModelRendererTurbo(interior, 1, 305, textureX, textureY)
			.addShapeBox(-1, -1, -16, 4, 7, 12, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -3, -1, 0, 0, 0, 0, 0, 0, 0, -3, -1)
			.setRotationPoint(21, -12, 0).setRotationAngle(0, 0, 0).setName("Box 704")
		);
		interior.add(new ModelRendererTurbo(interior, 497, 9, textureX, textureY)
			.addShapeBox(-1.2f, 0, -12.5f, 1, 1, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(21, -12, 0).setRotationAngle(0, 0, 0).setName("Box 705")
		);
		interior.add(new ModelRendererTurbo(interior, 473, 305, textureX, textureY)
			.addShapeBox(-3, -1.5f, 5, 5, 7, 12, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, -3, -1, 0, 0, 0, 0, 0, 0, 0, -3, -1)
			.setRotationPoint(21, -12, 0).setRotationAngle(0, 0, 0).setName("Box 706")
		);
		interior.add(new ModelRendererTurbo(interior, 337, 185, textureX, textureY)
			.addShapeBox(-4, -1, -1, 3, 2, 2, 0, 0, 1.9f, -0.1f, 0, 0, 0, 0, 0, 0, 0, 1.9f, -0.1f, 0, -2.1f, -0.1f, 0, 0, 0, 0, 0, 0, 0, -2.1f, -0.1f)
			.setRotationPoint(19, -12, 11).setRotationAngle(0, 0, 0).setName("Box 707")
		);
		interior.add(new ModelRendererTurbo(interior, 113, 313, textureX, textureY)
			.addShapeBox(-1, 0, -4, 5, 14, 8, 0, 0, 0, -2, 0, -0.2f, 0, 0, -0.2f, 0, 0, 0, -2, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(21, -14, 0).setRotationAngle(0, 0, 0).setName("Box 708")
		);
		interior.add(new ModelRendererTurbo(interior, 273, 297, textureX, textureY)
			.addShapeBox(-1, 0, -3, 13, 3, 6, 0, 0, -1, -2, 0, 0, -0.5f, 0, 0, -0.5f, 0, -1, -2, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(8, -3, 0).setRotationAngle(0, 0, 0).setName("Box 709")
		);
		interior.add(new ModelRendererTurbo(interior, 489, 185, textureX, textureY)
			.addShapeBox(-1, 0, -4, 6, 2, 4, 0, 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, -1, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(15, -4, 2).setRotationAngle(0, 0, 0).setName("Box 710")
		);
		interior.add(new ModelRendererTurbo(interior, 57, 129, textureX, textureY).addBox(0, 0, -0.5f, 1, 4, 1)
			.setRotationPoint(16, -7, 0).setRotationAngle(0, 0, -0.17453294f).setName("Box 725")
		);
		interior.add(new ModelRendererTurbo(interior, 193, 129, textureX, textureY).addBox(0, 0, 0, 1, 1, 2)
			.setRotationPoint(19.9f, -13.5f, -1).setRotationAngle(0, 0, 0).setName("Box 726")
		);
		interior.add(new ModelRendererTurbo(interior, 289, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 3, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(19.9f, -11.5f, -1.5f).setRotationAngle(0, 0, 0).setName("Box 727")
		);
		interior.add(new ModelRendererTurbo(interior, 337, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 3, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(19.9f, -12, -1.5f).setRotationAngle(0, 0, 0).setName("Box 728")
		);
		interior.add(new ModelRendererTurbo(interior, 361, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(19.9f, -12.5f, -1.75f).setRotationAngle(0, 0, 0).setName("Box 729")
		);
		interior.add(new ModelRendererTurbo(interior, 385, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(19.9f, -12.5f, 0.75f).setRotationAngle(0, 0, 0).setName("Box 730")
		);
		interior.add(new ModelRendererTurbo(interior, 409, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(19.9f, -12.5f, -0.5f).setRotationAngle(0, 0, 0).setName("Box 731")
		);
		interior.add(new ModelRendererTurbo(interior, 425, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(19.9f, -13, -1.75f).setRotationAngle(0, 0, 0).setName("Box 732")
		);
		interior.add(new ModelRendererTurbo(interior, 489, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(19.9f, -13, -0.5f).setRotationAngle(0, 0, 0).setName("Box 733")
		);
		interior.add(new ModelRendererTurbo(interior, 1, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(19.9f, -13, 0.75f).setRotationAngle(0, 0, 0).setName("Box 734")
		);
		interior.add(new ModelRendererTurbo(interior, 17, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(19.9f, -13.5f, 1).setRotationAngle(0, 0, 0).setName("Box 735")
		);
		interior.add(new ModelRendererTurbo(interior, 473, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(19.9f, -13.5f, -2).setRotationAngle(0, 0, 0).setName("Box 736")
		);
		interior.add(new ModelRendererTurbo(interior, 1, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(17.9f, -14.5f, 6).setRotationAngle(0, 0, 0).setName("Box 737")
		);
		interior.add(new ModelRendererTurbo(interior, 41, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(17.9f, -13.5f, 6).setRotationAngle(0, 0, 0).setName("Box 738")
		);
		interior.add(new ModelRendererTurbo(interior, 65, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(17.9f, -12.5f, 6).setRotationAngle(0, 0, 0).setName("Box 739")
		);
		interior.add(new ModelRendererTurbo(interior, 89, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(17.9f, -11.5f, 6).setRotationAngle(0, 0, 0).setName("Box 740")
		);
		interior.add(new ModelRendererTurbo(interior, 249, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(17.9f, -11.5f, 7).setRotationAngle(0, 0, 0).setName("Box 741")
		);
		interior.add(new ModelRendererTurbo(interior, 265, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(17.9f, -12.5f, 7).setRotationAngle(0, 0, 0).setName("Box 742")
		);
		interior.add(new ModelRendererTurbo(interior, 281, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(17.9f, -13.5f, 7).setRotationAngle(0, 0, 0).setName("Box 743")
		);
		interior.add(new ModelRendererTurbo(interior, 1, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(17.9f, -14.5f, 7).setRotationAngle(0, 0, 0).setName("Box 744")
		);
		interior.add(new ModelRendererTurbo(interior, 65, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(17.9f, -14.5f, 14).setRotationAngle(0, 0, 0).setName("Box 745")
		);
		interior.add(new ModelRendererTurbo(interior, 81, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(17.9f, -14.5f, 15).setRotationAngle(0, 0, 0).setName("Box 746")
		);
		interior.add(new ModelRendererTurbo(interior, 105, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(17.9f, -13.5f, 15).setRotationAngle(0, 0, 0).setName("Box 747")
		);
		interior.add(new ModelRendererTurbo(interior, 177, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(17.9f, -11.5f, 15).setRotationAngle(0, 0, 0).setName("Box 748")
		);
		interior.add(new ModelRendererTurbo(interior, 313, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(17.9f, -11.5f, 14).setRotationAngle(0, 0, 0).setName("Box 749")
		);
		interior.add(new ModelRendererTurbo(interior, 329, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(17.9f, -13.5f, 14).setRotationAngle(0, 0, 0).setName("Box 750")
		);
		interior.add(new ModelRendererTurbo(interior, 441, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 2, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(21, -2, 7).setRotationAngle(0, 0, 0).setName("Box 751")
		);
		interior.add(new ModelRendererTurbo(interior, 497, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 2, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(21, -2, 13).setRotationAngle(0, 0, 0).setName("Box 752")
		);
		interior.add(new ModelRendererTurbo(interior, 97, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 1, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(22, -2, 12).setRotationAngle(0, 0, 0).setName("Box 753")
		);
		this.groups.add(interior);
	}

}