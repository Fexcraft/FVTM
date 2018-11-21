//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.part.c2;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.1-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/part/c2_interior")
public class C2Interior extends PartModel {

	public C2Interior(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList interior = new TurboList("interior");
		interior.add(new ModelRendererTurbo(interior, 353, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 4, 12, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(9, -25, 7).setRotationAngle(0, 0, 0).setName("Box 81")
		);
		interior.add(new ModelRendererTurbo(interior, 257, 1, textureX, textureY).addBox(0, 0, 0, 4, 2, 2)
			.setRotationPoint(6, -26, 12.5f).setRotationAngle(0, 0, 0.2617994f).setName("Box 93")
		);
		interior.add(new ModelRendererTurbo(interior, 361, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 2, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(14, -14, 9).setRotationAngle(0, 0, 0).setName("Box 97")
		);
		interior.add(new ModelRendererTurbo(interior, 481, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 2, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(14, -14, 13).setRotationAngle(0, 0, 0).setName("Box 98")
		);
		interior.add(new ModelRendererTurbo(interior, 361, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 4, 44, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0)
			.setRotationPoint(11, -23, -22).setRotationAngle(0, 0, 0).setName("Box 79")
		);
		interior.add(new ModelRendererTurbo(interior, 241, 113, textureX, textureY).addBox(0, 0, 0, 15, 2, 16)
			.setRotationPoint(-9, -14, 5).setRotationAngle(0, 0, 0).setName("Box 83")
		);
		interior.add(new ModelRendererTurbo(interior, 241, 137, textureX, textureY).addBox(0, 0, 0, 15, 2, 16)
			.setRotationPoint(-9, -14, -21).setRotationAngle(0, 0, 0).setName("Box 84")
		);
		interior.add(new ModelRendererTurbo(interior, 81, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 16, 16, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-9, -30, 5).setRotationAngle(0, 0, 0).setName("Box 85")
		);
		interior.add(new ModelRendererTurbo(interior, 137, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 16, 16, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-9, -30, -21).setRotationAngle(0, 0, 0).setName("Box 86")
		);
		interior.add(new ModelRendererTurbo(interior, 409, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 3, 4, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-8, -15, -2).setRotationAngle(0, 0, 0).setName("Box 88")
		);
		interior.add(new ModelRendererTurbo(interior, 465, 81, textureX, textureY).addBox(0, 0, 0, 10, 4, 8)
			.setRotationPoint(7, -16, -4).setRotationAngle(0, 0, 0).setName("Box 89")
		);
		interior.add(new ModelRendererTurbo(interior, 1, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 6, 8, 0, -5, 0, 0, 0, 0, 0, 0, 0, 0, -5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(7, -22, -4).setRotationAngle(0, 0, 0).setName("Box 90")
		);
		interior.add(new ModelRendererTurbo(interior, 217, 1, textureX, textureY).addBox(0, 0, 0, 1, 7, 1)
			.setRotationPoint(3, -17, -0.5f).setRotationAngle(0, 0.017453292f, 1.2391838f).setName("Box 91")
		);
		interior.add(new ModelRendererTurbo(interior, 241, 1, textureX, textureY).addBox(0, 0, 0, 1, 5, 1)
			.setRotationPoint(8, -23, -0.5f).setRotationAngle(0, 0, -0.34906587f).setName("Box 92")
		);
		this.groups.add(interior);
	}

}