//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.part.t1;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.4-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/part/t1_steering_wheel")
public class T1SteeringWheel extends PartModel {

	public T1SteeringWheel(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList steering_wheel = new TurboList("steering_wheel");
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 369, 97, textureX, textureY).addBox(-2, -0.5f, -0.5f, 2, 1, 1)
			.setRotationPoint(47.6f, -22, 11).setRotationAngle(0, 0, 0).setName("Box 386")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 145, 105, textureX, textureY)
			.addShapeBox(-2, -0.5f, -0.5f, 1, 1, 1, 0, 0.2f, 0.2f, 0.2f, 0.2f, 0.2f, 0.2f, 0.2f, 0.2f, 0.2f, 0.2f, 0.2f, 0.2f, 0.2f, 0.2f, 0.2f, 0.2f, 0.2f, 0.2f, 0.2f, 0.2f, 0.2f, 0.2f, 0.2f, 0.2f)
			.setRotationPoint(47.6f, -22, 11).setRotationAngle(0, 0, 0).setName("Box 387")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 185, 57, textureX, textureY).addBox(-2, -0.5f, 0.5f, 1, 1, 3)
			.setRotationPoint(47.6f, -22, 11).setRotationAngle(0, 0, 0).setName("Box 389")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 385, 57, textureX, textureY).addBox(-2, -0.5f, -3.5f, 1, 1, 3)
			.setRotationPoint(47.6f, -22, 11).setRotationAngle(0, 0, 0).setName("Box 390")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 249, 105, textureX, textureY).addBox(-2, 0.5f, -0.5f, 1, 3, 1)
			.setRotationPoint(47.6f, -22, 11).setRotationAngle(0, 0, 0).setName("Box 391")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 345, 105, textureX, textureY).addBox(-2, -3.5f, -0.5f, 1, 3, 1)
			.setRotationPoint(47.6f, -22, 11).setRotationAngle(0, 0, 0).setName("Box 392")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 1, 113, textureX, textureY).addBox(-2, -4.5f, -1.5f, 1, 1, 3)
			.setRotationPoint(47.6f, -22, 11).setRotationAngle(0, 0, 0).setName("Box 393")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 121, 113, textureX, textureY).addBox(-2, 3.5f, -1.5f, 1, 1, 3)
			.setRotationPoint(47.6f, -22, 11).setRotationAngle(0, 0, 0).setName("Box 394")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 73, 113, textureX, textureY).addBox(-2, -1.5f, 3.5f, 1, 3, 1)
			.setRotationPoint(47.6f, -22, 11).setRotationAngle(0, 0, 0).setName("Box 395")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 145, 113, textureX, textureY).addBox(-2, -1.5f, -4.5f, 1, 3, 1)
			.setRotationPoint(47.6f, -22, 11).setRotationAngle(0, 0, 0).setName("Box 396")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 305, 121, textureX, textureY)
			.addShapeBox(-2, -4.5f, -4.5f, 1, 3, 1, 0, 0, 0, -3, 0, 0, -3, 0, -1, 2, 0, -1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(47.6f, -22, 11).setRotationAngle(0, 0, 0).setName("Box 397")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 393, 121, textureX, textureY)
			.addShapeBox(-2, 1.5f, -4.5f, 1, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, -1, 2, 0, -1, 2)
			.setRotationPoint(47.6f, -22, 11).setRotationAngle(0, 0, 0).setName("Box 398")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 409, 121, textureX, textureY)
			.addShapeBox(-2, 1.5f, 3.5f, 1, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 2, 0, -1, 2, 0, 0, -3, 0, 0, -3)
			.setRotationPoint(47.6f, -22, 11).setRotationAngle(0, 0, 0).setName("Box 399")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 505, 121, textureX, textureY)
			.addShapeBox(-2, -4.5f, 3.5f, 1, 3, 1, 0, 0, -1, 2, 0, -1, 2, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(47.6f, -22, 11).setRotationAngle(0, 0, 0).setName("Box 400")
		);
		steering_wheel.addProgram(DefaultPrograms.STEERING_X);
		this.groups.add(steering_wheel);
	}

}