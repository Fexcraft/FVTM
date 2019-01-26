//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.part.t1;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.4-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/part/t1_type5")
public class T1Type5 extends PartModel {

	public T1Type5(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList group0 = new TurboList("group0");
		group0.add(new ModelRendererTurbo(group0, 1, 1, textureX, textureY).addBox(0, 0, 0, 124, 1, 49)
			.setRotationPoint(-102, -13, -24.5f).setRotationAngle(0, 0, 0).setName("Box 1")
		);
		group0.add(new ModelRendererTurbo(group0, 353, 1, textureX, textureY).addBox(0, 0, 0, 1, 4, 49)
			.setRotationPoint(-103, -14, -24.5f).setRotationAngle(0, 0, 0).setName("Box 2")
		);
		group0.add(new ModelRendererTurbo(group0, 1, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 2, 8, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(8, -15, -24.5f).setRotationAngle(0, 0, 0).setName("Box 3")
		);
		group0.add(new ModelRendererTurbo(group0, 305, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 2, 8, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(8, -15, 16.5f).setRotationAngle(0, 0, 0).setName("Box 4")
		);
		group0.add(new ModelRendererTurbo(group0, 337, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 2, 8, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-94, -15, 16.5f).setRotationAngle(0, 0, 0).setName("Box 5")
		);
		group0.add(new ModelRendererTurbo(group0, 369, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 2, 8, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-94, -15, -24.5f).setRotationAngle(0, 0, 0).setName("Box 6")
		);
		group0.add(new ModelRendererTurbo(group0, 25, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 2, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(4, -15, -25).setRotationAngle(0, 0, 0).setName("Box 7")
		);
		group0.add(new ModelRendererTurbo(group0, 329, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(4, -15, 24).setRotationAngle(0, 0, 0).setName("Box 8")
		);
		group0.add(new ModelRendererTurbo(group0, 361, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(-88, -15, 24).setRotationAngle(0, 0, 0).setName("Box 9")
		);
		group0.add(new ModelRendererTurbo(group0, 409, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 2, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-88, -15, -25).setRotationAngle(0, 0, 0).setName("Box 10")
		);
		group0.add(new ModelRendererTurbo(group0, 41, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -1.5f, 0, 0, -0.5f)
			.setRotationPoint(22, -13, 23).setRotationAngle(0, 0, 0).setName("Box 11")
		);
		group0.add(new ModelRendererTurbo(group0, 393, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 2, 0, 0, 0, -0.5f, 0, 0, -1.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -1.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(22, -13, -25).setRotationAngle(0, 0, 0).setName("Box 12")
		);
		this.groups.add(group0);
	}

}