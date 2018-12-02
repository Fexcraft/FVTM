//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.part.c8;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.4-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/part/c8_steering_wheel")
public class C8SteeringWheel extends PartModel {

	public C8SteeringWheel(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList steering_wheel = new TurboList("steering_wheel");
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 234, 38, textureX, textureY).addBox(0, -1, -1, 3, 2, 2)
			.setRotationPoint(18, -9, 11).setRotationAngle(0, 0, 0.34906587f).setName("Box 170")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 419, 75, textureX, textureY).addBox(-1, -1.5f, -1.5f, 1, 3, 3)
			.setRotationPoint(18, -9, 11).setRotationAngle(0, 0, 0.34906587f).setName("Box 171")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 0, 21, textureX, textureY).addBox(-1, -1.5f, 3.5f, 1, 3, 1)
			.setRotationPoint(18, -9, 11).setRotationAngle(0, 0, 0.34906587f).setName("Box 172")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 396, 19, textureX, textureY).addBox(-1, -1.5f, -4.5f, 1, 3, 1)
			.setRotationPoint(18, -9, 11).setRotationAngle(0, 0, 0.34906587f).setName("Box 173")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 13, 75, textureX, textureY).addBox(-1, -4.5f, -1.5f, 1, 1, 3)
			.setRotationPoint(18, -9, 11).setRotationAngle(0, 0, 0.34906587f).setName("Box 174")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 203, 71, textureX, textureY).addBox(-1, 3.5f, -1.5f, 1, 1, 3)
			.setRotationPoint(18, -9, 11).setRotationAngle(0, 0, 0.34906587f).setName("Box 175")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 128, 69, textureX, textureY)
			.addShapeBox(-1, 3.5f, 1.5f, 1, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 2, -1, 0, 2, -1, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0)
			.setRotationPoint(18, -9, 11).setRotationAngle(0, 0, 0.34906587f).setName("Box 176")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 464, 63, textureX, textureY)
			.addShapeBox(-1, -4.5f, 1.5f, 1, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 2, -1, 0, 2, -1)
			.setRotationPoint(18, -9, 11).setRotationAngle(0, 0, 0.34906587f).setName("Box 177")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 132, 60, textureX, textureY)
			.addShapeBox(-1, 3.5f, -4.5f, 1, 1, 3, 0, 0, 2, -1, 0, 2, -1, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(18, -9, 11).setRotationAngle(0, 0, 0.34906587f).setName("Box 178")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 257, 35, textureX, textureY)
			.addShapeBox(-1, -4.5f, -4.5f, 1, 1, 3, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 2, -1, 0, 2, -1, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(18, -9, 11).setRotationAngle(0, 0, 0.34906587f).setName("Box 179")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 174, 17, textureX, textureY)
			.addShapeBox(-1, 1.5f, -1, 1, 2, 2, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0)
			.setRotationPoint(18, -9, 11).setRotationAngle(0, 0, 0.34906587f).setName("Box 180")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 25, 15, textureX, textureY)
			.addShapeBox(-1, -1, 1.5f, 1, 2, 2, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0)
			.setRotationPoint(18, -9, 11).setRotationAngle(0, 0, 0.34906587f).setName("Box 181")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 421, 11, textureX, textureY)
			.addShapeBox(-1, -1, -3.5f, 1, 2, 2, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0)
			.setRotationPoint(18, -9, 11).setRotationAngle(0, 0, 0.34906587f).setName("Box 182")
		);
		steering_wheel.addProgram(DefaultPrograms.STEERING_X);
		this.groups.add(steering_wheel);
	}

}