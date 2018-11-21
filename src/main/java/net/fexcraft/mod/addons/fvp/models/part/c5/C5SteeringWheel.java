//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.part.c5;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.1-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/part/c5_steering_wheel")
public class C5SteeringWheel extends PartModel {

	public C5SteeringWheel(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList steering_wheel = new TurboList("steering_wheel");
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 345, 1, textureX, textureY).addBox(-0.6f, -0.5f, -0.5f, 2, 1, 1)
			.setRotationPoint(25, -10, 12).setRotationAngle(0, 0, 0).setName("Box 277")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 97, 1, textureX, textureY)
			.addShapeBox(-0.5f, -2.5f, -0.5f, 1, 2, 1, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0)
			.setRotationPoint(25, -10, 12).setRotationAngle(0, 0, 0).setName("Box 278")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 361, 1, textureX, textureY)
			.addShapeBox(-0.5f, -0.5f, -2.5f, 1, 1, 2, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0)
			.setRotationPoint(25, -10, 12).setRotationAngle(0, 0, 0).setName("Box 279")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 105, 1, textureX, textureY)
			.addShapeBox(-0.5f, 0.5f, -0.5f, 1, 2, 1, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0)
			.setRotationPoint(25, -10, 12).setRotationAngle(0, 0, 0).setName("Box 280")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 385, 1, textureX, textureY)
			.addShapeBox(-0.5f, 1.5f, 1.5f, 1, 1, 2, 0, 0, -1, 0, 0, -1, 0, 0, 0, -1, 0, 0, -1, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(25, -10, 12).setRotationAngle(0, 0, 0).setName("Box 281")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 409, 1, textureX, textureY)
			.addShapeBox(-0.5f, 1.5f, -3.5f, 1, 1, 2, 0, 0, 0, -1, 0, 0, -1, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 1, 0)
			.setRotationPoint(25, -10, 12).setRotationAngle(0, 0, 0).setName("Box 282")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 425, 1, textureX, textureY).addBox(-0.5f, 2.5f, -1.5f, 1, 1, 3)
			.setRotationPoint(25, -10, 12).setRotationAngle(0, 0, 0).setName("Box 283")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 441, 1, textureX, textureY).addBox(-0.5f, -3.5f, -1.5f, 1, 1, 3)
			.setRotationPoint(25, -10, 12).setRotationAngle(0, 0, 0).setName("Box 284")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 457, 1, textureX, textureY)
			.addShapeBox(-0.5f, -2.5f, 1.5f, 1, 1, 2, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(25, -10, 12).setRotationAngle(0, 0, 0).setName("Box 285")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 481, 1, textureX, textureY)
			.addShapeBox(-0.5f, -2.5f, -3.5f, 1, 1, 2, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, 0, -1, 0, 0, -1, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(25, -10, 12).setRotationAngle(0, 0, 0).setName("Box 286")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 353, 17, textureX, textureY)
			.addShapeBox(-0.5f, -0.5f, 0.5f, 1, 1, 2, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0)
			.setRotationPoint(25, -10, 12).setRotationAngle(0, 0, 0).setName("Box 384")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 417, 17, textureX, textureY).addBox(-0.5f, -1.5f, 2.5f, 1, 3, 1)
			.setRotationPoint(25, -10, 12).setRotationAngle(0, 0, 0).setName("Box 385")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 433, 17, textureX, textureY).addBox(-0.5f, -1.5f, -3.5f, 1, 3, 1)
			.setRotationPoint(25, -10, 12).setRotationAngle(0, 0, 0).setName("Box 386")
		);
		steering_wheel.addProgram(DefaultPrograms.STEERING_X);
		this.groups.add(steering_wheel);
	}

}