//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.part.t2;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.4-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/part/t2_steering_wheel")
public class T2SteeringWheel extends PartModel {

	public T2SteeringWheel(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList steering_wheel = new TurboList("steering_wheel");
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 153, 49, textureX, textureY).addBox(-2, -1, -1, 3, 2, 2)
			.setRotationPoint(56, -31.5f, 12).setRotationAngle(0, 0, 1.0471976f).setName("Box 263")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 449, 89, textureX, textureY)
			.addShapeBox(-3, -2, -4, 1, 2, 8, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0)
			.setRotationPoint(56, -31.5f, 12).setRotationAngle(0, 0, 1.0471976f).setName("Box 264")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 57, 1, textureX, textureY).addBox(-2.75f, -2, -5, 1, 4, 1)
			.setRotationPoint(56, -31.5f, 12).setRotationAngle(0, 0, 1.0471976f).setName("Box 265")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 385, 1, textureX, textureY).addBox(-2.75f, -2, 4, 1, 4, 1)
			.setRotationPoint(56, -31.5f, 12).setRotationAngle(0, 0, 1.0471976f).setName("Box 266")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 273, 49, textureX, textureY).addBox(-2.75f, 4, -2, 1, 1, 4)
			.setRotationPoint(56, -31.5f, 12).setRotationAngle(0, 0, 1.0471976f).setName("Box 267")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 257, 65, textureX, textureY).addBox(-2.75f, -5, -2, 1, 1, 4)
			.setRotationPoint(56, -31.5f, 12).setRotationAngle(0, 0, 1.0471976f).setName("Box 268")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 65, 41, textureX, textureY)
			.addShapeBox(-2.75f, -5, -5, 1, 1, 3, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 2, -1, 0, 2, -1, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(56, -31.5f, 12).setRotationAngle(0, 0, 1.0471976f).setName("Box 269")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 169, 49, textureX, textureY)
			.addShapeBox(-2.75f, 4, -5, 1, 1, 3, 0, 0, 2, -1, 0, 2, -1, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(56, -31.5f, 12).setRotationAngle(0, 0, 1.0471976f).setName("Box 270")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 497, 65, textureX, textureY)
			.addShapeBox(-2.75f, 4, 2, 1, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 2, -1, 0, 2, -1, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0)
			.setRotationPoint(56, -31.5f, 12).setRotationAngle(0, 0, 1.0471976f).setName("Box 271")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 105, 73, textureX, textureY)
			.addShapeBox(-2.75f, -5, 2, 1, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 2, -1, 0, 2, -1)
			.setRotationPoint(56, -31.5f, 12).setRotationAngle(0, 0, 1.0471976f).setName("Box 272")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 401, 1, textureX, textureY)
			.addShapeBox(-3, 1, -1.5f, 1, 3, 1, 0, -0.6f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.6f, 0, 0, -0.5f, 0, 1, 0, 0, 1, 0, 0, -1, -0.5f, 0, -1)
			.setRotationPoint(56, -31.5f, 12).setRotationAngle(0, 0, 1.0471976f).setName("Box 273")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 505, 1, textureX, textureY)
			.addShapeBox(-3, 1, 0.5f, 1, 3, 1, 0, -0.6f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.6f, 0, 0, -0.5f, 0, -1, 0, 0, -1, 0, 0, 1, -0.5f, 0, 1)
			.setRotationPoint(56, -31.5f, 12).setRotationAngle(0, 0, 1.0471976f).setName("Box 274")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 489, 89, textureX, textureY)
			.addShapeBox(-3, 0, -4, 1, 2, 8, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, -2.5f, 0, 0, -2.5f, 0, 0, -2.5f, -0.5f, 0, -2.5f)
			.setRotationPoint(56, -31.5f, 12).setRotationAngle(0, 0, 1.0471976f).setName("Box 275")
		);
		steering_wheel.addProgram(DefaultPrograms.STEERING_X);
		this.groups.add(steering_wheel);
	}

}