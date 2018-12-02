//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.part.c9;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.4-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/part/c9_steering_wheel")
public class C9SteeringWheel extends PartModel {

	public C9SteeringWheel(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList steering_wheel = new TurboList("steering_wheel");
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 161, 137, textureX, textureY)
			.addShapeBox(0, -1, -1, 4, 2, 2, 0, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f, 0, -0.4f, -0.4f)
			.setRotationPoint(6.5f, -2.5f, 8).setRotationAngle(0, 0, 0.20943952f).setName("Box 446")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 273, 137, textureX, textureY)
			.addShapeBox(-1, -1, -1, 1, 3, 2, 0, -0.4f, 0, 0, 0, 0, 0, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0, 0, 0, 0, -0.4f, 0, 0)
			.setRotationPoint(6.5f, -2.5f, 8).setRotationAngle(0, 0, 0.20943952f).setName("Box 447")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 489, 9, textureX, textureY).addBox(-0.8f, 2, -1.5f, 1, 1, 3)
			.setRotationPoint(6.5f, -2.5f, 8).setRotationAngle(0, 0, 0.20943952f).setName("Box 448")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 97, 41, textureX, textureY).addBox(-0.8f, -3, -1.5f, 1, 1, 3)
			.setRotationPoint(6.5f, -2.5f, 8).setRotationAngle(0, 0, 0.20943952f).setName("Box 449")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 73, 129, textureX, textureY).addBox(-0.8f, -1.5f, 2, 1, 3, 1)
			.setRotationPoint(6.5f, -2.5f, 8).setRotationAngle(0, 0, 0.20943952f).setName("Box 450")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 345, 129, textureX, textureY).addBox(-0.8f, -1.5f, -3, 1, 3, 1)
			.setRotationPoint(6.5f, -2.5f, 8).setRotationAngle(0, 0, 0.20943952f).setName("Box 451")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 241, 113, textureX, textureY)
			.addShapeBox(-0.8f, -3, -2.5f, 1, 1, 1, 0, 0, -1.5f, 0.5f, 0, -1.5f, 0.5f, 0, 0, 0, 0, 0, 0, 0, 0.5f, -0.5f, 0, 0.5f, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(6.5f, -2.5f, 8).setRotationAngle(0, 0, 0.20943952f).setName("Box 452")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 297, 113, textureX, textureY)
			.addShapeBox(-0.8f, 2, -2.5f, 1, 1, 1, 0, 0, 0.5f, -0.5f, 0, 0.5f, -0.5f, 0, 0, 0, 0, 0, 0, 0, -1.5f, 0.5f, 0, -1.5f, 0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(6.5f, -2.5f, 8).setRotationAngle(0, 0, 0.20943952f).setName("Box 453")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 329, 113, textureX, textureY)
			.addShapeBox(-0.8f, 2, 1.5f, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0.5f, -0.5f, 0, 0.5f, -0.5f, 0, 0, 0, 0, 0, 0, 0, -1.5f, 0.5f, 0, -1.5f, 0.5f)
			.setRotationPoint(6.5f, -2.5f, 8).setRotationAngle(0, 0, 0.20943952f).setName("Box 454")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 353, 113, textureX, textureY)
			.addShapeBox(-0.8f, -3, 1.5f, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1.5f, 0.5f, 0, -1.5f, 0.5f, 0, 0, 0, 0, 0, 0, 0, 0.5f, -0.5f, 0, 0.5f, -0.5f)
			.setRotationPoint(6.5f, -2.5f, 8).setRotationAngle(0, 0, 0.20943952f).setName("Box 455")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 409, 129, textureX, textureY)
			.addShapeBox(-1, 0, -0.5f, 1, 3, 1, 0, -0.4f, 0, 0, 0, 0, 0, 0, 0, 0, -0.4f, 0, 0, -0.3f, 0, 0, 0, 0, 0, 0, 0, 0, -0.3f, 0, 0)
			.setRotationPoint(6.5f, -2.5f, 8).setRotationAngle(2.268928f, 0, 0.20943952f).setName("Box 456")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 433, 145, textureX, textureY)
			.addShapeBox(-1, 0, -0.5f, 1, 3, 1, 0, -0.4f, 0, 0, 0, 0, 0, 0, 0, 0, -0.4f, 0, 0, -0.3f, 0, 0, 0, 0, 0, 0, 0, 0, -0.3f, 0, 0)
			.setRotationPoint(6.5f, -2.5f, 8).setRotationAngle(-2.268928f, 0, 0.20943952f).setName("Box 457")
		);
		steering_wheel.addProgram(DefaultPrograms.STEERING_X);
		this.groups.add(steering_wheel);
	}

}