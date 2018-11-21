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
@fModel(registryname = "fvp:models/part/c5_interior")
public class C5Interior extends PartModel {

	public C5Interior(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList interior = new TurboList("interior");
		interior.add(new ModelRendererTurbo(interior, 1, 321, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 14, 44, 0, 16, 0, -2, -16, 0, -2, -16, 0, -2, 16, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(36, -23, -22).setRotationAngle(0, 0, 0).setName("Box 216")
		);
		interior.add(new ModelRendererTurbo(interior, 305, 217, textureX, textureY)
			.addShapeBox(0, 0, 0, 30, 4, 6, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(4, 1, -3).setRotationAngle(0, 0, 0).setName("Box 230")
		);
		interior.add(new ModelRendererTurbo(interior, 129, 353, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 14, 44, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0)
			.setRotationPoint(30, -9, -22).setRotationAngle(0, 0, 0).setName("Box 264")
		);
		interior.add(new ModelRendererTurbo(interior, 385, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 4, 8, 0, -1, 2, 0, 0, 0, 0, 0, 0, 0, -1, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0)
			.setRotationPoint(28, -9, 8).setRotationAngle(0, 0, 0).setName("Box 275")
		);
		interior.add(new ModelRendererTurbo(interior, 321, 1, textureX, textureY).addBox(0, 0, 0, 3, 2, 2)
			.setRotationPoint(26, -11, 11).setRotationAngle(0, 0, 0.15707964f).setName("Box 276")
		);
		interior.add(new ModelRendererTurbo(interior, 161, 9, textureX, textureY).addBox(0, 0, 0, 1, 4, 1)
			.setRotationPoint(28.8f, -9, 14).setRotationAngle(1.9024088f, -0.41887903f, -0.05235988f).setName("Box 287")
		);
		interior.add(new ModelRendererTurbo(interior, 161, 17, textureX, textureY).addBox(0, 0, 0, 1, 4, 1)
			.setRotationPoint(28.8f, -10, 10).setRotationAngle(-1.9024088f, 0.41887903f, 0.05235988f).setName("Box 288")
		);
		interior.add(new ModelRendererTurbo(interior, 137, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 2, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(29, 4, 9).setRotationAngle(0, 0, 0).setName("Box 289")
		);
		interior.add(new ModelRendererTurbo(interior, 353, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 2, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(29, 4, 13).setRotationAngle(0, 0, 0).setName("Box 290")
		);
		interior.add(new ModelRendererTurbo(interior, 409, 145, textureX, textureY).addBox(0, 0, 0, 1, 6, 8)
			.setRotationPoint(30, -7, -16).setRotationAngle(0, 0, 0).setName("Box 291")
		);
		interior.add(new ModelRendererTurbo(interior, 401, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0)
			.setRotationPoint(29.8f, -6, -14).setRotationAngle(0, 0, 0).setName("Box 292")
		);
		interior.add(new ModelRendererTurbo(interior, 1, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 8, 8, 0, 0, -4, -1, 0, 0, 0, 0, 0, 0, 0, -4, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(24, -3, -4).setRotationAngle(0, 0, 0).setName("Box 293")
		);
		interior.add(new ModelRendererTurbo(interior, 385, 153, textureX, textureY).addBox(0, 0, 0, 2, 12, 8)
			.setRotationPoint(30, -7, -4).setRotationAngle(0, 0, 0).setName("Box 294")
		);
		interior.add(new ModelRendererTurbo(interior, 25, 97, textureX, textureY).addBox(0, 0, 0, 1, 1, 6)
			.setRotationPoint(29.8f, -6.5f, -3).setRotationAngle(0, 0, 0).setName("Box 295")
		);
		interior.add(new ModelRendererTurbo(interior, 121, 1, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(29.8f, -5, -2).setRotationAngle(0, 0, 0).setName("Box 296")
		);
		interior.add(new ModelRendererTurbo(interior, 137, 1, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(29.8f, -4.5f, -2.25f).setRotationAngle(0.7853982f, 0, 0).setName("Box 297")
		);
		interior.add(new ModelRendererTurbo(interior, 241, 1, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(29.8f, -5, 1).setRotationAngle(0, 0, 0).setName("Box 298")
		);
		interior.add(new ModelRendererTurbo(interior, 257, 1, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(29.8f, -4.5f, 0.75f).setRotationAngle(0.7853982f, 0, 0).setName("Box 299")
		);
		interior.add(new ModelRendererTurbo(interior, 193, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 3, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0)
			.setRotationPoint(26, -2.5f, -1.5f).setRotationAngle(0, 0, 0).setName("Box 300")
		);
		interior.add(new ModelRendererTurbo(interior, 105, 41, textureX, textureY).addBox(0, 0, 0, 1, 4, 1)
			.setRotationPoint(26, -4.5f, -0.5f).setRotationAngle(0, 0, -0.34906587f).setName("Box 301")
		);
		interior.add(new ModelRendererTurbo(interior, 121, 121, textureX, textureY).addBox(0, 0, 0, 8, 1, 3)
			.setRotationPoint(11, 0.5f, -1.5f).setRotationAngle(0, 0, 0).setName("Box 302")
		);
		interior.add(new ModelRendererTurbo(interior, 305, 65, textureX, textureY).addBox(0, 0, 0, 6, 1, 1)
			.setRotationPoint(12, 0.5f, -0.5f).setRotationAngle(0, 0.017453292f, -0.2617994f).setName("Box 303")
		);
		interior.add(new ModelRendererTurbo(interior, 385, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 4, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0)
			.setRotationPoint(18, -23, -2).setRotationAngle(0, 0, 0).setName("Box 424")
		);
		interior.add(new ModelRendererTurbo(interior, 433, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(19.5f, -22.5f, -0.5f).setRotationAngle(0, 0, 0).setName("Box 425")
		);
		interior.add(new ModelRendererTurbo(interior, 489, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 4, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, 0, -0.5f, 0)
			.setRotationPoint(18.7f, -21.5f, -1.5f).setRotationAngle(0, 0.4537856f, -0.06981317f).setName("Box 426")
		);
		interior.add(new ModelRendererTurbo(interior, 417, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 4, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0)
			.setRotationPoint(4, -23, -2).setRotationAngle(0, 0, 0).setName("Box 427")
		);
		this.groups.add(interior);
	}

}