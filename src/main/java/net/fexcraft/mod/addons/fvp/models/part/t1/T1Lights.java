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
@fModel(registryname = "fvp:models/part/t1_lights")
public class T1Lights extends PartModel {

	public T1Lights(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList lights_brake = new TurboList("lights_brake");
		lights_brake.add(new ModelRendererTurbo(lights_brake, 169, 201, textureX, textureY).addBox(0, 0, 0, 1, 2, 6)
			.setRotationPoint(-100.5f, -5, 15).setRotationAngle(0.017453292f, 0, 0).setName("Box 439")
		);
		lights_brake.addProgram(DefaultPrograms.REVERSE_LIGHTS);
		this.groups.add(lights_brake);
		//
		TurboList lights_front = new TurboList("lights_front");
		lights_front.add(new ModelRendererTurbo(lights_front, 369, 81, textureX, textureY).addBox(0, 0, 0, 4, 4, 3)
			.setRotationPoint(54.2f, -13, 17.8f).setRotationAngle(0, 0, 0).setName("Box 143")
		);
		lights_front.add(new ModelRendererTurbo(lights_front, 369, 89, textureX, textureY).addBox(0, 0, 0, 4, 4, 3)
			.setRotationPoint(54.2f, -13, -20.8f).setRotationAngle(0, 0, 0).setName("Box 149")
		);
		lights_front.addProgram(DefaultPrograms.FRONT_LIGHTS);
		this.groups.add(lights_front);
		//
		TurboList lights_rear = new TurboList("lights_rear");
		lights_rear.add(new ModelRendererTurbo(lights_rear, 273, 193, textureX, textureY).addBox(0, 0, 0, 1, 1, 6)
			.setRotationPoint(-100.5f, -2.5f, -19).setRotationAngle(0.017453292f, 0, 0).setName("Box 437")
		);
		lights_rear.add(new ModelRendererTurbo(lights_rear, 201, 201, textureX, textureY).addBox(0, 0, 0, 1, 1, 6)
			.setRotationPoint(-100.5f, -2.5f, 15).setRotationAngle(0.017453292f, 0, 0).setName("Box 440")
		);
		lights_rear.addProgram(DefaultPrograms.REAR_LIGHTS);
		this.groups.add(lights_rear);
		//
		TurboList lights_reverse = new TurboList("lights_reverse");
		lights_reverse.add(new ModelRendererTurbo(lights_reverse, 137, 193, textureX, textureY).addBox(0, 0, 0, 1, 2, 6)
			.setRotationPoint(-100.5f, -5, -19).setRotationAngle(0.017453292f, 0, 0).setName("Box 436")
		);
		lights_reverse.addProgram(DefaultPrograms.REVERSE_LIGHTS);
		this.groups.add(lights_reverse);
		//
		TurboList lights_turn_left = new TurboList("lights_turn_left");
		lights_turn_left.add(new ModelRendererTurbo(lights_turn_left, 137, 145, textureX, textureY).addBox(0, 0, 0, 1, 3, 1)
			.setRotationPoint(-100.5f, -5, 22).setRotationAngle(0.017453292f, 0, 0).setName("Box 438")
		);
		lights_turn_left.add(new ModelRendererTurbo(lights_turn_left, 329, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 4, 2, 0, -0.5f, 0, 0, 0, 0, 0, -1, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, -1, 0, 0, -0.5f, 0, 0)
			.setRotationPoint(54.2f, -13, 20.8f).setRotationAngle(0, 0, 0).setName("Box 142")
		);
		lights_turn_left.addProgram(DefaultPrograms.INDICATOR_LIGHT_LEFT);
		this.groups.add(lights_turn_left);
		//
		TurboList lights_turn_right = new TurboList("lights_turn_right");
		lights_turn_right.add(new ModelRendererTurbo(lights_turn_right, 369, 129, textureX, textureY).addBox(0, 0, 0, 1, 3, 1)
			.setRotationPoint(-100.5f, -5, -21).setRotationAngle(0.017453292f, 0, 0).setName("Box 435")
		);
		lights_turn_right.add(new ModelRendererTurbo(lights_turn_right, 337, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 4, 2, 0, -0.5f, 0, 0, -1, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -1, 0, 0, 0, 0, 0, -0.5f, 0, 0)
			.setRotationPoint(54.2f, -13, -22.8f).setRotationAngle(0, 0, 0).setName("Box 150")
		);
		lights_turn_right.addProgram(DefaultPrograms.INDICATOR_LIGHT_RIGHT);
		this.groups.add(lights_turn_right);
	}

}