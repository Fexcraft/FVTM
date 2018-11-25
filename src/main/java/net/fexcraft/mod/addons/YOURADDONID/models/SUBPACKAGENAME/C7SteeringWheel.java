//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.YOURADDONID.models.SUBPACKAGENAME;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.1-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/part/c7_steering_wheel")
public class C7SteeringWheel extends PartModel {

	public C7SteeringWheel(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList steering_wheel = new TurboList("steering_wheel");
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 17, 57, textureX, textureY).addBox(0, -0.5f, 0.5f, 2, 1, 1)
			.setRotationPoint(11, -15, 8).setRotationAngle(0, 0, 0).setName("Box 261")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 57, 57, textureX, textureY)
			.addShapeBox(0, -2.5f, 0.5f, 1, 2, 1, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0)
			.setRotationPoint(11, -15, 8).setRotationAngle(0, 0, 0).setName("Box 262")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 121, 57, textureX, textureY)
			.addShapeBox(0, 0.5f, 0.5f, 1, 2, 1, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0)
			.setRotationPoint(11, -15, 8).setRotationAngle(0, 0, 0).setName("Box 263")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 161, 33, textureX, textureY)
			.addShapeBox(0, -0.5f, 1.5f, 1, 1, 2, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0)
			.setRotationPoint(11, -15, 8).setRotationAngle(0, 0, 0).setName("Box 264")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 321, 65, textureX, textureY)
			.addShapeBox(0, -0.5f, -1.5f, 1, 1, 2, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0)
			.setRotationPoint(11, -15, 8).setRotationAngle(0, 0, 0).setName("Box 265")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 17, 81, textureX, textureY).addBox(0, 2.5f, -0.5f, 1, 1, 3)
			.setRotationPoint(11, -15, 8).setRotationAngle(0, 0, 0).setName("Box 266")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 33, 81, textureX, textureY).addBox(0, -3.5f, -0.5f, 1, 1, 3)
			.setRotationPoint(11, -15, 8).setRotationAngle(0, 0, 0).setName("Box 267")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 161, 57, textureX, textureY).addBox(0, -1.5f, -2.5f, 1, 3, 1)
			.setRotationPoint(11, -15, 8).setRotationAngle(0, 0, 0).setName("Box 268")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 233, 57, textureX, textureY).addBox(0, -1.5f, 3.5f, 1, 3, 1)
			.setRotationPoint(11, -15, 8).setRotationAngle(0, 0, 0).setName("Box 269")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 161, 65, textureX, textureY)
			.addShapeBox(0, 1.5f, 3.5f, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 1, 0, -1, 1, 0, 0, -2, 0, 0, -2)
			.setRotationPoint(11, -15, 8).setRotationAngle(0, 0, 0).setName("Box 270")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 233, 65, textureX, textureY)
			.addShapeBox(0, -3.5f, 3.5f, 1, 2, 1, 0, 0, -1, 1, 0, -1, 1, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(11, -15, 8).setRotationAngle(0, 0, 0).setName("Box 271")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 305, 65, textureX, textureY)
			.addShapeBox(0, -3.5f, -2.5f, 1, 2, 1, 0, 0, 0, -2, 0, 0, -2, 0, -1, 1, 0, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(11, -15, 8).setRotationAngle(0, 0, 0).setName("Box 272")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 361, 65, textureX, textureY)
			.addShapeBox(0, 1.5f, -2.5f, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, -1, 1, 0, -1, 1)
			.setRotationPoint(11, -15, 8).setRotationAngle(0, 0, 0).setName("Box 273")
		);
		this.groups.add(steering_wheel);
	}

}