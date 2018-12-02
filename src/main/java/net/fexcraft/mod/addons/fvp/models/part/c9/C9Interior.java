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
@fModel(registryname = "fvp:models/part/c9_interior")
public class C9Interior extends PartModel {

	public C9Interior(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList interior = new TurboList("interior");
		interior.add(new ModelRendererTurbo(interior, 393, 153, textureX, textureY)
			.addShapeBox(0, 0, -0.5f, 1, 2, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(9, -4, 2.5f).setRotationAngle(0, 0, 0).setName("Box 374")
		);
		interior.add(new ModelRendererTurbo(interior, 249, 161, textureX, textureY)
			.addShapeBox(0, 0, -0.5f, 4, 1, 12, 0, 0, 0.5f, -1, 0, -0.6f, -1, 0, -0.6f, -1, 0, 0.5f, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(9, -5, 2.5f).setRotationAngle(0, 0, 0).setName("Box 376")
		);
		interior.add(new ModelRendererTurbo(interior, 1, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 29, 2, 5, 0, 0, -0.3f, -0.2f, 0, 0.2f, -0.2f, 0, 0.2f, -0.2f, 0, -0.3f, -0.2f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f)
			.setRotationPoint(-11, 8, -2.5f).setRotationAngle(0, 0, 0).setName("Box 379")
		);
		interior.add(new ModelRendererTurbo(interior, 73, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 9, 5, 0, 0, 0, -0.3f, 0, 0, 0.4f, 0, 0, 0.4f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.3f)
			.setRotationPoint(13, 0, -2.5f).setRotationAngle(0, 0, 0.29670596f).setName("Box 380")
		);
		interior.add(new ModelRendererTurbo(interior, 289, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0.5f)
			.setRotationPoint(-2, 7, -1.5f).setRotationAngle(0, 0, 0).setName("Box 526")
		);
		interior.add(new ModelRendererTurbo(interior, 185, 201, textureX, textureY).addBox(0, 0, 0, 6, 1, 1)
			.setRotationPoint(-1.5f, 6.5f, -0.5f).setRotationAngle(0, 0, -0.12217305f).setName("Box 527")
		);
		interior.add(new ModelRendererTurbo(interior, 345, 201, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 4, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f)
			.setRotationPoint(7, 7, -2).setRotationAngle(0, 0, 0).setName("Box 528")
		);
		interior.add(new ModelRendererTurbo(interior, 481, 193, textureX, textureY)
			.addShapeBox(0, -4, 0, 1, 4, 1, 0, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f)
			.setRotationPoint(8, 8, -0.5f).setRotationAngle(0, 0, -0.08726647f).setName("Box 529")
		);
		interior.add(new ModelRendererTurbo(interior, 25, 129, textureX, textureY).addBox(0, -5, 0, 1, 1, 1)
			.setRotationPoint(8, 8, -0.5f).setRotationAngle(0, 0, -0.08726647f).setName("Box 530")
		);
		interior.add(new ModelRendererTurbo(interior, 297, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 4, 0, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f)
			.setRotationPoint(9.2f, -3.5f, -2).setRotationAngle(0, 0, 0).setName("Box 531")
		);
		interior.add(new ModelRendererTurbo(interior, 225, 209, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 4, 8, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0)
			.setRotationPoint(9, -3.5f, -13).setRotationAngle(0, 0, 0).setName("Box 532")
		);
		interior.add(new ModelRendererTurbo(interior, 385, 41, textureX, textureY)
			.addShapeBox(0, -1, 0, 1, 1, 3, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0)
			.setRotationPoint(9.1f, -2.5f, -1.5f).setRotationAngle(0, 0, 0).setName("Box 533")
		);
		interior.add(new ModelRendererTurbo(interior, 177, 177, textureX, textureY)
			.addShapeBox(0, -1, 0, 1, 1, 1, 0, 0, -0.25f, 0, 0, -0.25f, 0, 0, -0.25f, 0, 0, -0.25f, 0, 0, -0.25f, 0, 0, -0.25f, 0, 0, -0.25f, 0, 0, -0.25f, 0)
			.setRotationPoint(9.1f, -0.5f, -1.5f).setRotationAngle(0, 0, 0).setName("Box 534")
		);
		interior.add(new ModelRendererTurbo(interior, 433, 177, textureX, textureY)
			.addShapeBox(0, -1, 0, 1, 1, 1, 0, 0, -0.25f, 0, 0, -0.25f, 0, 0, -0.25f, 0, 0, -0.25f, 0, 0, -0.25f, 0, 0, -0.25f, 0, 0, -0.25f, 0, 0, -0.25f, 0)
			.setRotationPoint(9.1f, -0.5f, -0.5f).setRotationAngle(0, 0, 0).setName("Box 535")
		);
		interior.add(new ModelRendererTurbo(interior, 33, 185, textureX, textureY)
			.addShapeBox(0, -1, 0, 1, 1, 1, 0, 0, -0.25f, 0, 0, -0.25f, 0, 0, -0.25f, 0, 0, -0.25f, 0, 0, -0.25f, 0, 0, -0.25f, 0, 0, -0.25f, 0, 0, -0.25f, 0)
			.setRotationPoint(9.1f, -0.5f, 0.5f).setRotationAngle(0, 0, 0).setName("Box 536")
		);
		interior.add(new ModelRendererTurbo(interior, 89, 185, textureX, textureY)
			.addShapeBox(0, -1, 0, 1, 1, 1, 0, 0, -0.25f, 0, 0, -0.25f, 0, 0, -0.25f, 0, 0, -0.25f, 0, 0, -0.25f, 0, 0, -0.25f, 0, 0, -0.25f, 0, 0, -0.25f, 0)
			.setRotationPoint(9.1f, -1, 0.5f).setRotationAngle(0, 0, 0).setName("Box 537")
		);
		interior.add(new ModelRendererTurbo(interior, 217, 185, textureX, textureY)
			.addShapeBox(0, -1, 0, 1, 1, 1, 0, 0, -0.25f, 0, 0, -0.25f, 0, 0, -0.25f, 0, 0, -0.25f, 0, 0, -0.25f, 0, 0, -0.25f, 0, 0, -0.25f, 0, 0, -0.25f, 0)
			.setRotationPoint(9.1f, -1, -0.5f).setRotationAngle(0, 0, 0).setName("Box 538")
		);
		interior.add(new ModelRendererTurbo(interior, 249, 185, textureX, textureY)
			.addShapeBox(0, -1, 0, 1, 1, 1, 0, 0, -0.25f, 0, 0, -0.25f, 0, 0, -0.25f, 0, 0, -0.25f, 0, 0, -0.25f, 0, 0, -0.25f, 0, 0, -0.25f, 0, 0, -0.25f, 0)
			.setRotationPoint(9.1f, -1, -1.5f).setRotationAngle(0, 0, 0).setName("Box 539")
		);
		interior.add(new ModelRendererTurbo(interior, 273, 201, textureX, textureY)
			.addShapeBox(0, -1, 0, 1, 1, 1, 0, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f)
			.setRotationPoint(9.1f, -1.75f, -1.75f).setRotationAngle(0, 0, 0).setName("Box 540")
		);
		interior.add(new ModelRendererTurbo(interior, 393, 201, textureX, textureY)
			.addShapeBox(0, -1, 0, 1, 1, 1, 0, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f)
			.setRotationPoint(9.1f, -1.75f, 0.75f).setRotationAngle(0, 0, 0).setName("Box 541")
		);
		interior.add(new ModelRendererTurbo(interior, 433, 201, textureX, textureY)
			.addShapeBox(0, -1, 0, 1, 1, 2, 0, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f)
			.setRotationPoint(9.1f, -1.75f, -1).setRotationAngle(0, 0, 0).setName("Box 542")
		);
		interior.add(new ModelRendererTurbo(interior, 321, 201, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 6, 4, 0, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f)
			.setRotationPoint(10.2f, -0.5f, -2).setRotationAngle(0, 0, -0.2443461f).setName("Box 543")
		);
		interior.add(new ModelRendererTurbo(interior, 489, 201, textureX, textureY)
			.addShapeBox(0, -1, -1, 1, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(8.9f, -4, 5.5f).setRotationAngle(0, 0, 0).setName("Box 544")
		);
		interior.add(new ModelRendererTurbo(interior, 497, 201, textureX, textureY)
			.addShapeBox(0, -1, -1, 1, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(8.9f, -4, 8).setRotationAngle(0, 0, 0).setName("Box 545")
		);
		interior.add(new ModelRendererTurbo(interior, 505, 201, textureX, textureY)
			.addShapeBox(0, -1, -1, 1, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(8.9f, -4, 10.5f).setRotationAngle(0, 0, 0).setName("Box 546")
		);
		interior.add(new ModelRendererTurbo(interior, 441, 201, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(8.9f, -4, 12).setRotationAngle(0, 0, 0).setName("Box 547")
		);
		interior.add(new ModelRendererTurbo(interior, 481, 201, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(8.9f, -4, 3).setRotationAngle(0, 0, 0).setName("Box 548")
		);
		interior.add(new ModelRendererTurbo(interior, 41, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(9.1f, -2.5f, 2.5f).setRotationAngle(0, 0, 0).setName("Box 549")
		);
		interior.add(new ModelRendererTurbo(interior, 153, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(9.1f, -2.5f, 10.5f).setRotationAngle(0, 0, 0).setName("Box 550")
		);
		interior.add(new ModelRendererTurbo(interior, 177, 217, textureX, textureY)
			.addShapeBox(0, -1, 0, 1, 1, 3, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0)
			.setRotationPoint(8.8f, -2, -10.5f).setRotationAngle(0, 0, 0).setName("Box 551")
		);
		this.groups.add(interior);
	}

}