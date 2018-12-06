//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.hcp.models.part;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.4-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "hcp:models/part/container_lift_cabin")
public class ContainerLiftCabin extends PartModel {

	public ContainerLiftCabin(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList cabin = new TurboList("cabin");
		cabin.add(new ModelRendererTurbo(cabin, 0, 108, textureX, textureY).addBox(0, 0, 0, 14, 1, 16)
			.setRotationPoint(48, -93, -41).setRotationAngle(0, 0, 0)
		);
		cabin.add(new ModelRendererTurbo(cabin, 358, 144, textureX, textureY).addBox(0, 0, 0, 1, 14, 8)
			.setRotationPoint(48, -107, -34).setRotationAngle(0, 0, 0)
		);
		cabin.add(new ModelRendererTurbo(cabin, 423, 139, textureX, textureY).addBox(0, 0, 0, 3, 24, 1)
			.setRotationPoint(48, -117, -41).setRotationAngle(0, 0, 0)
		);
		cabin.add(new ModelRendererTurbo(cabin, 395, 139, textureX, textureY).addBox(0, 0, 0, 3, 24, 1)
			.setRotationPoint(48, -117, -26).setRotationAngle(0, 0, 0)
		);
		cabin.add(new ModelRendererTurbo(cabin, 182, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 1, 1, 0, 0, 0, 0, 0, 6, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, -6, 0, 0, -6, 0, 0, 0, 0)
			.setRotationPoint(62, -93, -26).setRotationAngle(0, 0, 0)
		);
		cabin.add(new ModelRendererTurbo(cabin, 231, 102, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 1, 1, 0, 0, 0, 0, 0, 6, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, -6, 0, 0, -6, 0, 0, 0, 0)
			.setRotationPoint(62, -93, -33.5f).setRotationAngle(0, 0, 0)
		);
		cabin.add(new ModelRendererTurbo(cabin, 149, 92, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 1, 1, 0, 0, 0, 0, 0, -6, 0, 0, -6, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 6, 0, 0, 0, 0)
			.setRotationPoint(60, -118, -41).setRotationAngle(0, 0, 0)
		);
		cabin.add(new ModelRendererTurbo(cabin, 246, 74, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 1, 1, 0, 0, 0, 0, 0, -6, 0, 0, -6, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 6, 0, 0, 0, 0)
			.setRotationPoint(60, -118, -26).setRotationAngle(0, 0, 0)
		);
		cabin.add(new ModelRendererTurbo(cabin, 227, 74, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 1, 1, 0, 0, 0, 0, 0, -6, 0, 0, -6, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 6, 0, 0, 0, 0)
			.setRotationPoint(60, -118, -33.5f).setRotationAngle(0, 0, 0)
		);
		cabin.add(new ModelRendererTurbo(cabin, 358, 136, textureX, textureY).addBox(0, 0, 0, 8, 6, 1)
			.setRotationPoint(51, -99, -26).setRotationAngle(0, 0, 0)
		);
		cabin.add(new ModelRendererTurbo(cabin, 236, 136, textureX, textureY).addBox(0, 0, 0, 8, 6, 1)
			.setRotationPoint(51, -99, -41).setRotationAngle(0, 0, 0)
		);
		cabin.add(new ModelRendererTurbo(cabin, 343, 123, textureX, textureY).addBox(0, 0, 0, 10, 4, 8)
			.setRotationPoint(49, -97, -34).setRotationAngle(0, 0, 0.05235988f)
		);
		cabin.add(new ModelRendererTurbo(cabin, 386, 139, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 24, 1, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(59, -117, -41).setRotationAngle(0, 0, 0)
		);
		cabin.add(new ModelRendererTurbo(cabin, 377, 139, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 24, 1, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(59, -117, -26).setRotationAngle(0, 0, 0)
		);
		cabin.add(new ModelRendererTurbo(cabin, 0, 108, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 14, 1, 0, 0, 0, 0, -0.5f, -1, 0, -0.5f, -1, 0, 0, 0, 0, 0, 0, 0, -0.5f, -1, 0, -0.5f, -1, 0, 0, 0, 0)
			.setRotationPoint(68, -112, -41).setRotationAngle(0, 0, 0)
		);
		cabin.add(new ModelRendererTurbo(cabin, 488, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 14, 1, 0, 0, 0, 0, -0.5f, -1, 0, -0.5f, -1, 0, 0, 0, 0, 0, 0, 0, -0.5f, -1, 0, -0.5f, -1, 0, 0, 0, 0)
			.setRotationPoint(68, -112, -33.5f).setRotationAngle(0, 0, 0)
		);
		cabin.add(new ModelRendererTurbo(cabin, 504, 22, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 14, 1, 0, 0, 0, 0, -0.5f, -1, 0, -0.5f, -1, 0, 0, 0, 0, 0, 0, 0, -0.5f, -1, 0, -0.5f, -1, 0, 0, 0, 0)
			.setRotationPoint(68, -112, -26).setRotationAngle(0, 0, 0)
		);
		cabin.add(new ModelRendererTurbo(cabin, 217, 144, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 0.5f, 16, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(67.5f, -112, -41).setRotationAngle(0, 0, 0)
		);
		cabin.add(new ModelRendererTurbo(cabin, 285, 141, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 0.5f, 16, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(67.5f, -98.5f, -41).setRotationAngle(0, 0, 0)
		);
		cabin.add(new ModelRendererTurbo(cabin, 282, 141, textureX, textureY).addBox(0, 0, 0, 2, 6, 7)
			.setRotationPoint(60, -99, -33).setRotationAngle(0, 0, 0.05235988f)
		);
		cabin.add(new ModelRendererTurbo(cabin, 0, 3, textureX, textureY)
			.addShapeBox(-0.5f, -0.5f, -0.5f, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(61, -99, -29.25f).setRotationAngle(0, 0, 0)
		);
		cabin.add(new ModelRendererTurbo(cabin, 5, 0, textureX, textureY)
			.addShapeBox(-0.5f, -0.5f, -0.5f, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(61, -99, -30.5f).setRotationAngle(0, 0, 0)
		);
		cabin.add(new ModelRendererTurbo(cabin, 0, 0, textureX, textureY)
			.addShapeBox(-0.5f, -0.5f, -0.5f, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(61, -99, -31.75f).setRotationAngle(0, 0, 0)
		);
		cabin.add(new ModelRendererTurbo(cabin, 300, 123, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 9, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0)
			.setRotationPoint(36, -118, -41).setRotationAngle(0, 0, 0)
		);
		cabin.add(new ModelRendererTurbo(cabin, 370, 21, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, 0, 0, 0, -16, 0, 0, -16, 0, 0, 0, 0, 0, 0, 0, 0, 16, 0, 0, 16, 0, 0, 0, 0)
			.setRotationPoint(36, -116, -41).setRotationAngle(0, 0, 0)
		);
		cabin.add(new ModelRendererTurbo(cabin, 373, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, 0, 0, 0, -16, 0, 0, -16, 0, 0, 0, 0, 0, 0, 0, 0, 16, 0, 0, 16, 0, 0, 0, 0)
			.setRotationPoint(36, -116, -33).setRotationAngle(0, 0, 0)
		);
		cabin.add(new ModelRendererTurbo(cabin, 259, 123, textureX, textureY).addBox(0, 0, 0, 12, 1, 16)
			.setRotationPoint(48, -118, -41).setRotationAngle(0, 0, 0)
		);
		cabin.add(new ModelRendererTurbo(cabin, 397, 21, textureX, textureY).addBox(0, 0, 0, 1, 10, 2)
			.setRotationPoint(48, -117, -34).setRotationAngle(0, 0, 0)
		);
		cabin.add(new ModelRendererTurbo(cabin, 504, 9, textureX, textureY).addBox(0, 0, 0, 1, 10, 2)
			.setRotationPoint(48, -117, -28).setRotationAngle(0, 0, 0)
		);
		cabin.add(new ModelRendererTurbo(cabin, 182, 102, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 1, 1, 0, 0, 0, 0, 0, 6, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, -6, 0, 0, -6, 0, 0, 0, 0)
			.setRotationPoint(62, -93, -41).setRotationAngle(0, 0, 0)
		);
		cabin.add(new ModelRendererTurbo(cabin, 432, 139, textureX, textureY).addBox(0, 0, 0, 2, 9, 8)
			.setRotationPoint(49, -106, -34).setRotationAngle(0, 0, 0)
		);
		this.groups.add(cabin);
		//
		TurboList cabin_steering = new TurboList("cabin_steering");
		cabin_steering.add(new ModelRendererTurbo(cabin_steering, 0, 6, textureX, textureY)
			.addShapeBox(-0.5f, -0.5f, -0.5f, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(61, -100, -27.5f).setRotationAngle(0, 0, 0)
		);
		cabin_steering.add(new ModelRendererTurbo(cabin_steering, 5, 3, textureX, textureY)
			.addShapeBox(-0.5f, -0.5f, -0.5f, 1, 0.25f, 1, 0, -0.25f, 0, 0.25f, -0.25f, 0, 0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(61, -100.25f, -27.5f).setRotationAngle(0, 0, 0)
		);
		cabin_steering.addProgram(DefaultPrograms.STEERING_Y);
		this.groups.add(cabin_steering);
		this.translate(0, 144, 0);
	}

}
