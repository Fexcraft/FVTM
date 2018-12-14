//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.part.ab1b;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of
 *  FMT (Fex's Modelling Toolbox) v.1.0.1-test &copy; 2018 - Fexcraft.net
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/part/ab1b_steering_wheel")
public class AB1SW extends PartModel {

	public AB1SW(){
		super(); textureX = 1024; textureY = 1024;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList steering_wheel = new TurboList("steering_wheel");
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 233, 33, textureX, textureY)
			.addShapeBox(0, -1, -1, 1, 2, 2, 0, 0.1f, 0.1f, 0.1f, 0, 0, 0, 0, 0, 0, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0, 0, 0, 0, 0, 0, 0.1f, 0.1f, 0.1f)
			.setRotationPoint(88, -25, 19).setRotationAngle(0, 0, 74).setName("Box 325")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 257, 33, textureX, textureY).addBox(0, -4, -0.5f, 1, 3, 1)
			.setRotationPoint(88, -25, 19).setRotationAngle(0, 0, 74).setName("Box 331")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 257, 41, textureX, textureY).addBox(0, 1, -0.5f, 1, 3, 1)
			.setRotationPoint(88, -25, 19).setRotationAngle(0, 0, 74).setName("Box 332")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 209, 49, textureX, textureY).addBox(0, -0.5f, 1, 1, 1, 3)
			.setRotationPoint(88, -25, 19).setRotationAngle(0, 0, 74).setName("Box 333")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 489, 57, textureX, textureY).addBox(0, -0.5f, -4, 1, 1, 3)
			.setRotationPoint(88, -25, 19).setRotationAngle(0, 0, 74).setName("Box 334")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 825, 9, textureX, textureY).addBox(0, -5, -2, 1, 1, 4)
			.setRotationPoint(88, -25, 19).setRotationAngle(0, 0, 74).setName("Box 335")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 905, 9, textureX, textureY).addBox(0, 4, -2, 1, 1, 4)
			.setRotationPoint(88, -25, 19).setRotationAngle(0, 0, 74).setName("Box 336")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 57, 49, textureX, textureY).addBox(0, -2, -5, 1, 4, 1)
			.setRotationPoint(88, -25, 19).setRotationAngle(0, 0, 74).setName("Box 337")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 97, 49, textureX, textureY).addBox(0, -2, 4, 1, 4, 1)
			.setRotationPoint(88, -25, 19).setRotationAngle(0, 0, 74).setName("Box 338")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 177, 49, textureX, textureY)
			.addShapeBox(0, -5, -5, 1, 3, 1, 0, 0, 0, -3, 0, 0, -3, 0, -1, 2, 0, -1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(88, -25, 19).setRotationAngle(0, 0, 74).setName("Box 339")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 881, 49, textureX, textureY)
			.addShapeBox(0, 2, -5, 1, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, -1, 2, 0, -1, 2)
			.setRotationPoint(88, -25, 19).setRotationAngle(0, 0, 74).setName("Box 340")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 897, 49, textureX, textureY)
			.addShapeBox(0, 2, 4, 1, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 2, 0, -1, 2, 0, 0, -3, 0, 0, -3)
			.setRotationPoint(88, -25, 19).setRotationAngle(0, 0, 74).setName("Box 341")
		);
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 913, 49, textureX, textureY)
			.addShapeBox(0, -5, 4, 1, 3, 1, 0, 0, -1, 2, 0, -1, 2, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(88, -25, 19).setRotationAngle(0, 0, 74).setName("Box 342")
		);
		steering_wheel.addProgram(DefaultPrograms.STEERING_Y);
		this.groups.add(steering_wheel);
		//
	}

}