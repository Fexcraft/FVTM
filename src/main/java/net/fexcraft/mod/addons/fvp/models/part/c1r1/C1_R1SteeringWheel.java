//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.part.c1r1;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.1-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/part/c1_r1_steering_wheel")
public class C1_R1SteeringWheel extends PartModel {

	public C1_R1SteeringWheel(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList steering_wheel = new TurboList("steering_wheel");
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 177, 113, textureX, textureY).addBox(-1, -1, -1, 1, 2, 2)
			.setRotationPoint(15, -14, 11).setRotationAngle(-0.034906585f, 0, 0.2617994f).setName("Box 711")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 217, 113, textureX, textureY).addBox(-1, 3, -1, 1, 1, 2)
			.setRotationPoint(15, -14, 11).setRotationAngle(-0.034906585f, 0, 0.2617994f).setName("Box 712")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 121, 121, textureX, textureY).addBox(-1, -4, -1, 1, 1, 2)
			.setRotationPoint(15, -14, 11).setRotationAngle(-0.034906585f, 0, 0.2617994f).setName("Box 713")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 281, 41, textureX, textureY).addBox(-1, -1, 3, 1, 2, 1)
			.setRotationPoint(15, -14, 11).setRotationAngle(-0.034906585f, 0, 0.2617994f).setName("Box 714")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 345, 41, textureX, textureY).addBox(-1, -1, -4, 1, 2, 1)
			.setRotationPoint(15, -14, 11).setRotationAngle(-0.034906585f, 0, 0.2617994f).setName("Box 715")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 249, 177, textureX, textureY)
			.addShapeBox(-1, 3, 1, 1, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 1, -2, 0, 1, -2, 0, 0, 0, 0, 0, 0, 0, -1, -1, 0, -1, -1)
			.setRotationPoint(15, -14, 11).setRotationAngle(-0.034906585f, 0, 0.2617994f).setName("Box 719")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 73, 185, textureX, textureY)
			.addShapeBox(-1, 2, -0.5f, 1, 1, 3, 0, -0.1f, 2, -1, -0.1f, 2, -1, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, -3, 0, -0.1f, -3, 0, -0.1f, 0, 0, -0.1f, 0, 0)
			.setRotationPoint(15, -14, 11).setRotationAngle(-0.034906585f, 0, 0.2617994f).setName("Box 721")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 385, 193, textureX, textureY)
			.addShapeBox(-1, 3, 1, 1, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 1, -2, 0, 1, -2, 0, 0, 0, 0, 0, 0, 0, -1, -1, 0, -1, -1)
			.setRotationPoint(15, -14, 11).setRotationAngle(-0.034906585f, 0, 0.2617994f).setName("Box 754")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 345, 81, textureX, textureY)
			.addShapeBox(-1, 1, 3, 1, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 1, 0, -2, 1, 0, -1, -1, 0, -1, -1)
			.setRotationPoint(15, -14, 11).setRotationAngle(-0.034906585f, 0, 0.2617994f).setName("Box 755")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 297, 97, textureX, textureY)
			.addShapeBox(-1, -4, 3, 1, 3, 1, 0, 0, -2, 1, 0, -2, 1, 0, -1, -1, 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(15, -14, 11).setRotationAngle(-0.034906585f, 0, 0.2617994f).setName("Box 756")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 41, 201, textureX, textureY)
			.addShapeBox(-1, -4, 1, 1, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 1, -2, 0, 1, -2)
			.setRotationPoint(15, -14, 11).setRotationAngle(-0.034906585f, 0, 0.2617994f).setName("Box 757")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 57, 201, textureX, textureY)
			.addShapeBox(-1, -4, -4, 1, 1, 3, 0, 0, -1, -1, 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 1, -2, 0, 1, -2, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(15, -14, 11).setRotationAngle(-0.034906585f, 0, 0.2617994f).setName("Box 758")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 73, 201, textureX, textureY)
			.addShapeBox(-1, 3, -4, 1, 1, 3, 0, 0, 1, -2, 0, 1, -2, 0, 0, 0, 0, 0, 0, 0, -1, -1, 0, -1, -1, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(15, -14, 11).setRotationAngle(-0.034906585f, 0, 0.2617994f).setName("Box 759")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 121, 113, textureX, textureY)
			.addShapeBox(-1, -4, -4, 1, 3, 1, 0, 0, -1, -1, 0, -1, -1, 0, -2, 1, 0, -2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(15, -14, 11).setRotationAngle(-0.034906585f, 0, 0.2617994f).setName("Box 760")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 81, 129, textureX, textureY)
			.addShapeBox(-1, 1, -4, 1, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, 0, -1, -1, 0, -2, 1, 0, -2, 1)
			.setRotationPoint(15, -14, 11).setRotationAngle(-0.034906585f, 0, 0.2617994f).setName("Box 761")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 209, 201, textureX, textureY)
			.addShapeBox(-1, -3, -2.5f, 1, 1, 3, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, -3, 0, -0.1f, -3, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 2, -1, -0.1f, 2, -1)
			.setRotationPoint(15, -14, 11).setRotationAngle(-0.034906585f, 0, 0.2617994f).setName("Box 762")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 345, 201, textureX, textureY)
			.addShapeBox(-1, -3, -0.5f, 1, 1, 3, 0, -0.1f, -3, 0, -0.1f, -3, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 2, -1, -0.1f, 2, -1, -0.1f, 0, 0, -0.1f, 0, 0)
			.setRotationPoint(15, -14, 11).setRotationAngle(-0.034906585f, 0, 0.2617994f).setName("Box 763")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 1, 209, textureX, textureY)
			.addShapeBox(-1, 2, -2.5f, 1, 1, 3, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 2, -1, -0.1f, 2, -1, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, -3, 0, -0.1f, -3, 0)
			.setRotationPoint(15, -14, 11).setRotationAngle(-0.034906585f, 0, 0.2617994f).setName("Box 764")
		);
		steering_wheel.addProgram(DefaultPrograms.STEERING_X);
		this.groups.add(steering_wheel);
	}

}