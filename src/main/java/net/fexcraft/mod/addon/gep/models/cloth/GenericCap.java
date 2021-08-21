//FMT-Marker FVTM-1.5
package net.fexcraft.mod.addon.gep.models.cloth;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.ClothModel;
import net.fexcraft.mod.fvtm.model.TurboList;

/** This file was exported via the FVTM Exporter v1.5 of<br>
 *  FMT (Fex's Modelling Toolbox) v.2.6.5 &copy; 2021 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "gep:models/cloth/cap")
public class GenericCap extends ClothModel {

	public GenericCap(){
		super(); textureX = 64; textureY = 32;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList cap = new TurboList("cap");
		cap.add(new ModelRendererTurbo(cap, 0, 0, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 0.5f, 10, 0, 0, 0, -0.1f, 0, 0, -0.6f, 0, 0, -0.6f, 0, 0, -0.1f, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0)
			.setRotationPoint(2, -31.5f, -5).setRotationAngle(0, 0, 0)
		);
		cap.add(new ModelRendererTurbo(cap, 0, 12, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 0.5f, 9, 0, 0, 0, -0.1f, -0.1f, 0, -1.5f, -0.1f, 0, -1.5f, 0, 0, -0.1f, 0, 0, 0, 0, 0, -1.4f, 0, 0, -1.4f, 0, 0, 0)
			.setRotationPoint(7, -31.5f, -4.5f).setRotationAngle(0, 0, 0)
		);
		cap.add(new ModelRendererTurbo(cap, 49, 24, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 1, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-4, -33, -5).setRotationAngle(0, 0, 0)
		);
		cap.add(new ModelRendererTurbo(cap, 14, 23, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, -0.5f, 0, -1.5f, 0, 0, -0.75f, 0, 0, 0, -1, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-4, -35, -5).setRotationAngle(0, 0, 0)
		);
		cap.add(new ModelRendererTurbo(cap, 7, 23, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 1, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(2, -34, -5).setRotationAngle(0, 0, 0)
		);
		cap.add(new ModelRendererTurbo(cap, 0, 23, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, -0.75f, -0.75f, 0, -1.5f, -1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(2, -35, -5).setRotationAngle(0, 0, 0)
		);
		cap.add(new ModelRendererTurbo(cap, 32, 20, textureX, textureY).addBox(0, 0, 0, 4, 3, 1)
			.setRotationPoint(-2, -34, -5).setRotationAngle(0, 0, 0)
		);
		cap.add(new ModelRendererTurbo(cap, 43, 20, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(-4, -34, 4).setRotationAngle(0, 0, 0)
		);
		cap.add(new ModelRendererTurbo(cap, 12, 18, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, -1, 0, 1, 0, 0, 0, 0, 0, -0.75f, -0.5f, 0, -1.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(-4, -35, 4).setRotationAngle(0, 0, 0)
		);
		cap.add(new ModelRendererTurbo(cap, 0, 16, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(2, -34, 4).setRotationAngle(0, 0, 0)
		);
		cap.add(new ModelRendererTurbo(cap, 23, 15, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, -1, 0, 1, -0.5f, 0, -1.5f, 0, 0, -0.75f, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(2, -35, 4).setRotationAngle(0, 0, 0)
		);
		cap.add(new ModelRendererTurbo(cap, 21, 20, textureX, textureY).addBox(0, 0, 0, 4, 3, 1)
			.setRotationPoint(-2, -34, 4).setRotationAngle(0, 0, 0)
		);
		cap.add(new ModelRendererTurbo(cap, 51, 16, textureX, textureY).addBox(0, 0, 0, 1, 3, 4)
			.setRotationPoint(-5, -34, -2).setRotationAngle(0, 0, 0)
		);
		cap.add(new ModelRendererTurbo(cap, 36, 12, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 2, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-5, -34, -4).setRotationAngle(0, 0, 0)
		);
		cap.add(new ModelRendererTurbo(cap, 0, 12, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 2, 0, -1.5f, 0, -0.5f, 1, 0, -1, 0, 0, 0, -0.75f, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-5, -35, -4).setRotationAngle(0, 0, 0)
		);
		cap.add(new ModelRendererTurbo(cap, 57, 10, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0)
			.setRotationPoint(-5, -34, 2).setRotationAngle(0, 0, 0)
		);
		cap.add(new ModelRendererTurbo(cap, 38, 4, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 2, 0, -0.75f, 0, 0, 0, 0, 0, 1, 0, -1, -1.5f, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0)
			.setRotationPoint(-5, -35, 2).setRotationAngle(0, 0, 0)
		);
		cap.add(new ModelRendererTurbo(cap, 44, 12, textureX, textureY).addBox(0, 0, 0, 1, 3, 4)
			.setRotationPoint(4, -34, -2).setRotationAngle(0, 0, 0)
		);
		cap.add(new ModelRendererTurbo(cap, 0, 4, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 2, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(4, -34, -4).setRotationAngle(0, 0, 0)
		);
		cap.add(new ModelRendererTurbo(cap, 38, 0, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 2, 0, 1, 0, -1, -1.75f, 0, -0.5f, -0.75f, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(4, -35, -4).setRotationAngle(0, 0, 0)
		);
		cap.add(new ModelRendererTurbo(cap, 21, 0, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 2, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0)
			.setRotationPoint(4, -34, 2).setRotationAngle(0, 0, 0)
		);
		cap.add(new ModelRendererTurbo(cap, 0, 0, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 2, 0, 0, 0, 0, -0.75f, 0, 0, -1.5f, 0, -0.5f, 1, 0, -1, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0)
			.setRotationPoint(4, -35, 2).setRotationAngle(0, 0, 0)
		);
		cap.add(new ModelRendererTurbo(cap, 21, 0, textureX, textureY).addBox(0, 0, 0, 4, 1, 8)
			.setRotationPoint(-2, -35, -4).setRotationAngle(0, 0, 0)
		);
		cap.add(new ModelRendererTurbo(cap, 19, 12, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 1, 0, 0, 0, -0.75f, 0, 0, -0.75f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-2, -35, -5).setRotationAngle(0, 0, 0)
		);
		cap.add(new ModelRendererTurbo(cap, 51, 6, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.75f, 0, 0, -0.75f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-2, -35, 4).setRotationAngle(0, 0, 0)
		);
		cap.add(new ModelRendererTurbo(cap, 12, 12, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 4, 0, -0.75f, 0, 0, 0, 0, 0, 0, 0, 0, -0.75f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-5, -35, -2).setRotationAngle(0, 0, 0)
		);
		cap.add(new ModelRendererTurbo(cap, 51, 0, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 4, 0, 0, 0, 0, -0.75f, 0, 0, -0.75f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(4, -35, -2).setRotationAngle(0, 0, 0)
		);
		cap.add(new ModelRendererTurbo(cap, 23, 10, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 8, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0)
			.setRotationPoint(2, -35, -4).setRotationAngle(0, 0, 0)
		);
		cap.add(new ModelRendererTurbo(cap, 38, 2, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 8, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2)
			.setRotationPoint(-4, -35, -4).setRotationAngle(0, 0, 0)
		);
		this.groups.add(cap);
		//
		setGroupAs(cap, "head", 0, 25, 0);
	}

}
