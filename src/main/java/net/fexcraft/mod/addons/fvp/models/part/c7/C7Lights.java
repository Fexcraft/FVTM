//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.part.c7;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.1-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/part/c7_lights")
public class C7Lights extends PartModel {

	public C7Lights(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList lights_front = new TurboList("lights_front");
		lights_front.add(new ModelRendererTurbo(lights_front, 209, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 3, 0, 0, -0.2f, 0, -0.3f, -0.2f, 0, -0.3f, -0.2f, -0.8f, 0, -0.2f, 0, 0, -0.2f, 0, -0.3f, -0.2f, 0, -0.3f, -0.2f, -0.55f, 0, -0.2f, 0.25f)
			.setRotationPoint(43, -12, 14).setRotationAngle(0, 0, 0).setName("Box 75")
		);
		lights_front.add(new ModelRendererTurbo(lights_front, 385, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 3, 0, 0, -0.2f, 0, -0.3f, -0.2f, -0.8f, -0.3f, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0.25f, -0.3f, -0.2f, -0.55f, -0.3f, -0.2f, 0, 0, -0.2f, 0)
			.setRotationPoint(43, -12, -17).setRotationAngle(0, 0, 0).setName("Box 83")
		);
		lights_front.addProgram(DefaultPrograms.FRONT_LIGHTS);
		this.groups.add(lights_front);
		//
		TurboList lights_indicator_left = new TurboList("lights_indicator_left");
		lights_indicator_left.add(new ModelRendererTurbo(lights_indicator_left, 137, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, 0, 0, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(17, -7, 17.5f).setRotationAngle(0, 0, 0).setName("Box 42")
		);
		lights_indicator_left.add(new ModelRendererTurbo(lights_indicator_left, 225, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 3, 0, 0, 0, 0, -0.3f, 0, 0, -0.3f, 0, -0.55f, 0, 0, 0.25f, 0, -0.2f, 0, -0.3f, -0.2f, 0, -0.3f, -0.2f, -0.3f, 0, -0.2f, 0.5f)
			.setRotationPoint(43, -9, 14).setRotationAngle(0, 0, 0).setName("Box 76")
		);
		lights_indicator_left.addProgram(DefaultPrograms.TURN_SIGNAL_LEFT);
		this.groups.add(lights_indicator_left);
		//
		TurboList lights_indicator_right = new TurboList("lights_indicator_right");
		lights_indicator_right.add(new ModelRendererTurbo(lights_indicator_right, 153, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 2, 1, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, 0, 0, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(17, -7, -18.5f).setRotationAngle(0, 0, 0).setName("Box 43")
		);
		lights_indicator_right.add(new ModelRendererTurbo(lights_indicator_right, 321, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 3, 0, 0, 0, 0.25f, -0.3f, 0, -0.55f, -0.3f, 0, 0, 0, 0, 0, 0, -0.2f, 0.5f, -0.3f, -0.2f, -0.3f, -0.3f, -0.2f, 0, 0, -0.2f, 0)
			.setRotationPoint(43, -9, -17).setRotationAngle(0, 0, 0).setName("Box 80")
		);
		lights_indicator_right.addProgram(DefaultPrograms.TURN_SIGNAL_RIGHT);
		this.groups.add(lights_indicator_right);
		//
		TurboList lights_rear = new TurboList("lights_rear");
		lights_rear.add(new ModelRendererTurbo(lights_rear, 73, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 2, 0, 0.1f, 0, -1.3f, 0, 0, -0.65f, 0, 0, 0, 0.1f, 0, 0, 0.1f, 0, -1.1f, 0, 0, -0.3f, 0, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(-46, -12, -18).setRotationAngle(0, 0, 0).setName("Box 106")
		);
		lights_rear.add(new ModelRendererTurbo(lights_rear, 105, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 2, 0, 0.1f, 0, 0, 0, 0, 0, 0, 0, -0.65f, 0.1f, 0, -1.3f, 0.1f, 0, 0, 0, 0, 0, 0, 0, -0.3f, 0.1f, 0, -1.1f)
			.setRotationPoint(-46, -12, 16).setRotationAngle(0, 0, 0).setName("Box 107")
		);
		lights_rear.addProgram(DefaultPrograms.REAR_LIGHTS);
		this.groups.add(lights_rear);
	}

}