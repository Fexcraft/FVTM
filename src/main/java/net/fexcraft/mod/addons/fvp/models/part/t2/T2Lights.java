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
@fModel(registryname = "fvp:models/part/t2_lights")
public class T2Lights extends PartModel {

	public T2Lights(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList lights_front = new TurboList("lights_front");
		lights_front.add(new ModelRendererTurbo(lights_front, 449, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 8, 6, 0, 0, 0, 0, -0.2f, 0, 0, -0.2f, 0, -3, 0, 0, 0, 0, 0, 0, -0.2f, 0, 0, -0.2f, 0, -3, 0, 0, 0)
			.setRotationPoint(66, -24, 20).setRotationAngle(0, 0, 0).setName("Box 206")
		);
		lights_front.add(new ModelRendererTurbo(lights_front, 489, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 8, 6, 0, 0, 0, 0, -0.2f, 0, -3, -0.2f, 0, 0, 0, 0, 0, 0, 0, 0, -0.2f, 0, -3, -0.2f, 0, 0, 0, 0, 0)
			.setRotationPoint(66, -24, -26).setRotationAngle(0, 0, 0).setName("Box 209")
		);
		lights_front.addProgram(DefaultPrograms.FRONT_LIGHTS);
		this.groups.add(lights_front);
		//
		TurboList lights_rear = new TurboList("lights_rear");
		lights_rear.add(new ModelRendererTurbo(lights_rear, 57, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-64, -12.5f, -23).setRotationAngle(0, 0, 0).setName("Box 137")
		);
		lights_rear.add(new ModelRendererTurbo(lights_rear, 385, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-64, -12.5f, 17).setRotationAngle(0, 0, 0).setName("Box 138")
		);
		lights_rear.addProgram(DefaultPrograms.REAR_LIGHTS);
		this.groups.add(lights_rear);
		//
		TurboList lights_rear_chassis = new TurboList("lights_rear_chassis");
		lights_rear_chassis.add(new ModelRendererTurbo(lights_rear_chassis, 17, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 48, 0, 0, 0, 0, 0, 0, -8, 0, 0, -8, 0, 0, 0, 0, 0, 0, 0, 0, -8, 0, 0, -8, 0, 0, 0)
			.setRotationPoint(-63, -12, -24).setRotationAngle(0, 0, 0).setName("Box 136")
		);
		this.groups.add(lights_rear_chassis);
		//
		TurboList lights_turn_left = new TurboList("lights_turn_left");
		lights_turn_left.add(new ModelRendererTurbo(lights_turn_left, 89, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 3, 6, 0, 0, 0, 0, -0.2f, 0, 0, -0.2f, 0, -3, 0, 0, 0, 0, 0, 0, -0.2f, 0, 0, -0.2f, 0, -3, 0, 0, 0)
			.setRotationPoint(66, -16, 20).setRotationAngle(0, 0, 0).setName("Box 204")
		);
		lights_turn_left.add(new ModelRendererTurbo(lights_turn_left, 105, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-64, -12.5f, 23).setRotationAngle(0, 0, 0).setName("Box 139")
		);
		lights_turn_left.addProgram(DefaultPrograms.TURN_SIGNAL_LEFT);
		this.groups.add(lights_turn_left);
		//
		TurboList lights_turn_right = new TurboList("lights_turn_right");
		lights_turn_right.add(new ModelRendererTurbo(lights_turn_right, 153, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 3, 6, 0, 0, 0, 0, -0.2f, 0, -3, -0.2f, 0, 0, 0, 0, 0, 0, 0, 0, -0.2f, 0, -3, -0.2f, 0, 0, 0, 0, 0)
			.setRotationPoint(66, -16, -26).setRotationAngle(0, 0, 0).setName("Box 208")
		);
		lights_turn_right.add(new ModelRendererTurbo(lights_turn_right, 161, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-64, -12.5f, -25).setRotationAngle(0, 0, 0).setName("Box 140")
		);
		lights_turn_right.addProgram(DefaultPrograms.TURN_SIGNAL_RIGHT);
		this.groups.add(lights_turn_right);
	}

}