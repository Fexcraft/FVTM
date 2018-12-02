//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.part.c8;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.4-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/part/c8_bumpers")
public class C8Bumpers extends PartModel {

	public C8Bumpers(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList bumpers = new TurboList("bumpers");
		bumpers.add(new ModelRendererTurbo(bumpers, 318, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 4, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(56, 1, -16).setRotationAngle(0, 0, 0).setName("Box 49")
		);
		bumpers.add(new ModelRendererTurbo(bumpers, 134, 69, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 4, 6, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, -1, 0, 2, -1, 0, -2, 0, 0)
			.setRotationPoint(54, 1, -22).setRotationAngle(0, 0, 0).setName("Box 51")
		);
		bumpers.add(new ModelRendererTurbo(bumpers, 306, 62, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 4, 1, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(54, 1, -23).setRotationAngle(0, 0, 0).setName("Box 52")
		);
		bumpers.add(new ModelRendererTurbo(bumpers, 113, 69, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 4, 6, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(54, 1, 16).setRotationAngle(0, 0, 0).setName("Box 53")
		);
		bumpers.add(new ModelRendererTurbo(bumpers, 285, 62, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 4, 1, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -2, -1, 0, 0, 0, 0)
			.setRotationPoint(54, 1, 22).setRotationAngle(0, 0, 0).setName("Box 54")
		);
		bumpers.add(new ModelRendererTurbo(bumpers, 164, 31, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0)
			.setRotationPoint(48, 1, 22).setRotationAngle(0, 0, 0).setName("Box 55")
		);
		bumpers.add(new ModelRendererTurbo(bumpers, 149, 31, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0)
			.setRotationPoint(48, 1, -23).setRotationAngle(0, 0, 0).setName("Box 56")
		);
		bumpers.add(new ModelRendererTurbo(bumpers, 123, 0, textureX, textureY)
			.addShapeBox(0, 0, 0, 60, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0)
			.setRotationPoint(-30, 1, 22).setRotationAngle(0, 0, 0).setName("Box 57")
		);
		bumpers.add(new ModelRendererTurbo(bumpers, 0, 0, textureX, textureY)
			.addShapeBox(0, 0, 0, 60, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0)
			.setRotationPoint(-30, 1, -23).setRotationAngle(0, 0, 0).setName("Box 58")
		);
		bumpers.add(new ModelRendererTurbo(bumpers, 53, 116, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 4, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(-59, 1, -16).setRotationAngle(0, 0, 0).setName("Box 59")
		);
		bumpers.add(new ModelRendererTurbo(bumpers, 0, 64, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 4, 6, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 0, -1, 0, 0, 0, 0, -2, 0, 0, 2, -1, 0)
			.setRotationPoint(-57, 1, -22).setRotationAngle(0, 0, 0).setName("Box 60")
		);
		bumpers.add(new ModelRendererTurbo(bumpers, 449, 63, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 4, 6, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 2, -1, 0, -2, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(-57, 1, 16).setRotationAngle(0, 0, 0).setName("Box 61")
		);
		bumpers.add(new ModelRendererTurbo(bumpers, 497, 55, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 4, 1, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(-57, 1, -23).setRotationAngle(0, 0, 0).setName("Box 62")
		);
		bumpers.add(new ModelRendererTurbo(bumpers, 214, 46, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, -2, -1, 0)
			.setRotationPoint(-57, 1, 22).setRotationAngle(0, 0, 0).setName("Box 63")
		);
		bumpers.add(new ModelRendererTurbo(bumpers, 497, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0)
			.setRotationPoint(-53, 1, -23).setRotationAngle(0, 0, 0).setName("Box 64")
		);
		bumpers.add(new ModelRendererTurbo(bumpers, 86, 48, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0)
			.setRotationPoint(-53, 1, 22).setRotationAngle(0, 0, 0).setName("Box 65")
		);
		bumpers.add(new ModelRendererTurbo(bumpers, 318, 99, textureX, textureY).addBox(0, 0, 0, 1, 3, 12)
			.setRotationPoint(59.2f, 1.5f, -6).setRotationAngle(0, 0, 0).setName("Box 113")
		);
		this.groups.add(bumpers);
	}

}