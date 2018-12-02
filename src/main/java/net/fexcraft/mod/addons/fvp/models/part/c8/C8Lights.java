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
@fModel(registryname = "fvp:models/part/c8_lights")
public class C8Lights extends PartModel {

	public C8Lights(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList lights_front = new TurboList("lights_front");
		lights_front.add(new ModelRendererTurbo(lights_front, 209, 71, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 6, 0, 0, 0, 0, 0, 0, 0, -1.4f, 0, 0, 1.4f, 0, 0, 0, 0, 0, 0, 0, 0, -1.4f, 0, 0, 1.4f, 0, 0)
			.setRotationPoint(54.8f, -5, 14).setRotationAngle(0, 0, 0).setName("Box 209")
		);
		lights_front.add(new ModelRendererTurbo(lights_front, 192, 71, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 6, 0, 1.4f, 0, 0, -1.4f, 0, 0, 0, 0, 0, 0, 0, 0, 1.4f, 0, 0, -1.4f, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(54.8f, -5, -20).setRotationAngle(0, 0, 0).setName("Box 211")
		);
		lights_front.addProgram(DefaultPrograms.FRONT_LIGHTS);
		this.groups.add(lights_front);
		//
		TurboList lights_rear = new TurboList("lights_rear");
		lights_rear.add(new ModelRendererTurbo(lights_rear, 488, 70, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 4, 0, 0, 0, 0, 0, 0, 0, 1.4f, 0, 0, -1.4f, 0, 0, 0, 0, 0, 0, 0, 0, 1.4f, 0, 0, -1.4f, 0, 0)
			.setRotationPoint(-55.8f, -6, 16).setRotationAngle(0, 0, 0).setName("Box 213")
		);
		lights_rear.add(new ModelRendererTurbo(lights_rear, 21, 64, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 4, 0, -1.4f, 0, 0, 1.4f, 0, 0, 0, 0, 0, 0, 0, 0, -1.4f, 0, 0, 1.4f, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-55.8f, -6, -20).setRotationAngle(0, 0, 0).setName("Box 215")
		);
		lights_rear.addProgram(DefaultPrograms.REAR_LIGHTS);
		this.groups.add(lights_rear);
		//
		TurboList lights_reverse = new TurboList("lights_reverse");
		lights_reverse.add(new ModelRendererTurbo(lights_reverse, 505, 38, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0.7f, 0, 0, -0.7f, 0, 0, 0, 0, 0, 0, 0, 0, 0.7f, 0, 0, -0.7f, 0, 0)
			.setRotationPoint(-55.7f, -3, 16.5f).setRotationAngle(0, 0, 0).setName("Box 217")
		);
		this.groups.add(lights_reverse);
		//
		TurboList lights_turn_left = new TurboList("lights_turn_left");
		lights_turn_left.add(new ModelRendererTurbo(lights_turn_left, 113, 55, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 2, 0, -0.6f, 0, 0, 0.6f, 0, 0, 0, 0, -0.2f, 0, 0, -0.2f, -0.6f, 0, 0, 0.6f, 0, 0, 0, 0, -0.2f, 0, 0, -0.2f)
			.setRotationPoint(52.8f, -5, 20).setRotationAngle(0, 0, 0).setName("Box 210")
		);
		lights_turn_left.add(new ModelRendererTurbo(lights_turn_left, 253, 74, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 2, 0, 0, 0, 0, 0, 0, 0, 0.6f, 0, -0.2f, -0.6f, 0, -0.2f, 0, 0, 0, 0, 0, 0, 0.6f, 0, -0.2f, -0.6f, 0, -0.2f)
			.setRotationPoint(-54.4f, -6, 20).setRotationAngle(0, 0, 0).setName("Box 214")
		);
		lights_turn_left.addProgram(DefaultPrograms.INDICATOR_LIGHT_LEFT);
		this.groups.add(lights_turn_left);
		//
		TurboList lights_turn_right = new TurboList("lights_turn_right");
		lights_turn_right.add(new ModelRendererTurbo(lights_turn_right, 99, 48, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 2, 0, 0, 0, -0.2f, 0, 0, -0.2f, 0.6f, 0, 0, -0.6f, 0, 0, 0, 0, -0.2f, 0, 0, -0.2f, 0.6f, 0, 0, -0.6f, 0, 0)
			.setRotationPoint(52.8f, -5, -22).setRotationAngle(0, 0, 0).setName("Box 212")
		);
		lights_turn_right.add(new ModelRendererTurbo(lights_turn_right, 35, 52, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 2, 0, -0.6f, 0, -0.2f, 0.6f, 0, -0.2f, 0, 0, 0, 0, 0, 0, -0.6f, 0, -0.2f, 0.6f, 0, -0.2f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-54.4f, -6, -22).setRotationAngle(0, 0, 0).setName("Box 216")
		);
		lights_turn_right.addProgram(DefaultPrograms.INDICATOR_LIGHT_RIGHT);
		this.groups.add(lights_turn_right);
	}

}