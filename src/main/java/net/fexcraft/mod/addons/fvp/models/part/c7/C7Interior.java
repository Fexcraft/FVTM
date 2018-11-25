//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.part.c7;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.1-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/part/c7_interior")
public class C7Interior extends PartModel {

	public C7Interior(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList interior = new TurboList("interior");
		interior.add(new ModelRendererTurbo(interior, 401, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 4, 10, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0)
			.setRotationPoint(15, -16, 4).setRotationAngle(0, 0, 0).setName("Box 259")
		);
		interior.add(new ModelRendererTurbo(interior, 73, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0)
			.setRotationPoint(13, -16, 8).setRotationAngle(0, 0, 0).setName("Box 260")
		);
		interior.add(new ModelRendererTurbo(interior, 97, 81, textureX, textureY).addBox(0, 0, 0, 1, 1, 4)
			.setRotationPoint(14.8f, -13, -12).setRotationAngle(0, 0, 0).setName("Box 274")
		);
		interior.add(new ModelRendererTurbo(interior, 257, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 4, 10, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0)
			.setRotationPoint(15, -14, -15).setRotationAngle(0, 0, 0).setName("Box 275")
		);
		interior.add(new ModelRendererTurbo(interior, 1, 169, textureX, textureY).addBox(0, 0, 0, 17, 3, 6)
			.setRotationPoint(-1, -6, -3).setRotationAngle(0, 0, 0).setName("Box 276")
		);
		interior.add(new ModelRendererTurbo(interior, 49, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 10, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(16, -13, -3).setRotationAngle(0, 0, 0).setName("Box 277")
		);
		interior.add(new ModelRendererTurbo(interior, 489, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 1, 3, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, 1, 0, 0)
			.setRotationPoint(1, -7, -1.5f).setRotationAngle(0, 0, 0).setName("Box 278")
		);
		interior.add(new ModelRendererTurbo(interior, 73, 129, textureX, textureY).addBox(0, 0, 0, 6, 1, 1)
			.setRotationPoint(2, -7.5f, -0.5f).setRotationAngle(0, 0, -0.19198623f).setName("Box 279")
		);
		interior.add(new ModelRendererTurbo(interior, 145, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 4, 0, -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(11, -7, -2).setRotationAngle(0, 0, 0).setName("Box 280")
		);
		interior.add(new ModelRendererTurbo(interior, 377, 65, textureX, textureY).addBox(0, 0, 0, 1, 4, 1)
			.setRotationPoint(12.5f, -9.5f, -0.5f).setRotationAngle(0, 0, 0).setName("Box 281")
		);
		interior.add(new ModelRendererTurbo(interior, 17, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0.2f, 0.2f, 0.2f, 0.2f, 0.2f, 0.2f, 0.2f, 0.2f, 0.2f, 0.2f, 0.2f, 0.2f, 0.2f, 0.2f, 0.2f, 0.2f, 0.2f, 0.2f, 0.2f, 0.2f, 0.2f, 0.2f, 0.2f, 0.2f)
			.setRotationPoint(12.5f, -10, -0.5f).setRotationAngle(0, 0, 0).setName("Box 282")
		);
		interior.add(new ModelRendererTurbo(interior, 241, 97, textureX, textureY).addBox(0, 0, 0, 1, 1, 4)
			.setRotationPoint(15.8f, -12, -2).setRotationAngle(0, 0, 0).setName("Box 283")
		);
		interior.add(new ModelRendererTurbo(interior, 161, 113, textureX, textureY).addBox(0, 1, 0, 1, 2, 4)
			.setRotationPoint(15.8f, -10, -2).setRotationAngle(0, 0, 0).setName("Box 284")
		);
		interior.add(new ModelRendererTurbo(interior, 441, 121, textureX, textureY).addBox(0, 0, 0, 1, 1, 4)
			.setRotationPoint(15.8f, -10.5f, -2).setRotationAngle(0, 0, 0).setName("Box 285")
		);
		this.groups.add(interior);
	}

}