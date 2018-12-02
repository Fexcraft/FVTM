//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.part.c9;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.4-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/part/c9_lights")
public class C9Lights extends PartModel {

	public C9Lights(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList lights_front = new TurboList("lights_front");
		lights_front.add(new ModelRendererTurbo(lights_front, 481, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 10, 0, 0, 0, 0, 0, 0, 0, -1.8f, 0, -0.4f, 1.8f, 0, -0.4f, 1.1f, 0, 0, -1.1f, 0, 0, -2.6f, 0, -0.4f, 2.6f, 0, -0.4f)
			.setRotationPoint(47.6f, 0, 7).setRotationAngle(0, 0, 0).setName("Box 47")
		);
		lights_front.add(new ModelRendererTurbo(lights_front, 465, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 10, 0, 1.8f, 0, -0.4f, -1.8f, 0, -0.4f, 0, 0, 0, 0, 0, 0, 2.6f, 0, -0.4f, -2.6f, 0, -0.4f, -1.1f, 0, 0, 1.1f, 0, 0)
			.setRotationPoint(47.6f, 0, -17).setRotationAngle(0, 0, 0).setName("Box 61")
		);
		lights_front.addProgram(DefaultPrograms.FRONT_LIGHTS);
		this.groups.add(lights_front);
		//
		TurboList lights_indicator_left = new TurboList("lights_indicator_left");
		lights_indicator_left.add(new ModelRendererTurbo(lights_indicator_left, 505, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 2, 0, 0.2f, 0, 0, -0.2f, 0, 0, -0.9f, 0, -0.3f, 0.9f, 0, -0.3f, 1, 0, 0, -1, 0, 0, -1.6f, 0, -0.3f, 1.6f, 0, -0.3f)
			.setRotationPoint(46, 0, 16.6f).setRotationAngle(0, 0, 0).setName("Box 48")
		);
		lights_indicator_left.add(new ModelRendererTurbo(lights_indicator_left, 33, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 1, 0, 0, 0, 0, 0.1f, 0, 0, -0.8f, 0, -0.3f, 1.6f, 0, 0, 0, 0, 0, -0.6f, 0, 0, -1.6f, 0, -0.1f, 1.8f, 0, -0.1f)
			.setRotationPoint(45, 0, 18.300001f).setRotationAngle(0, 0, 0).setName("Box 49")
		);
		lights_indicator_left.add(new ModelRendererTurbo(lights_indicator_left, 49, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 5, 2, 0, 0.4f, 0, 0, -0.6f, 0, 0, 0, 0, -0.6f, 0.1f, 0, -0.6f, 0.6f, -0.8f, 0, -0.7f, -0.8f, 0, 0, -0.8f, -0.6f, 0.3f, -0.8f, -0.6f)
			.setRotationPoint(-53.5f, -1, 16.6f).setRotationAngle(0, 0, 0).setName("Box 325")
		);
		lights_indicator_left.add(new ModelRendererTurbo(lights_indicator_left, 241, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 5, 2, 0, -0.4f, 0, 0, 0, 0, 0, 0, 0, -1.1f, -1, 0, -1.5f, -0.2f, -0.8f, 0, 0, -0.8f, 0, 0, -0.8f, -1.1f, -0.8f, -0.8f, -1.5f)
			.setRotationPoint(-54, -1, 18.000002f).setRotationAngle(0, 0, 0).setName("Box 327")
		);
		lights_indicator_left.addProgram(DefaultPrograms.INDICATOR_LIGHT_LEFT);
		this.groups.add(lights_indicator_left);
		//
		TurboList lights_indicator_right = new TurboList("lights_indicator_right");
		lights_indicator_right.add(new ModelRendererTurbo(lights_indicator_right, 233, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 1, 0, 1.6f, 0, 0, -0.8f, 0, -0.3f, 0.1f, 0, 0, 0, 0, 0, 1.8f, 0, -0.1f, -1.6f, 0, -0.1f, -0.6f, 0, 0, 0, 0, 0)
			.setRotationPoint(45, 0, -19.3f).setRotationAngle(0, 0, 0).setName("Box 59")
		);
		lights_indicator_right.add(new ModelRendererTurbo(lights_indicator_right, 313, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 2, 0, 0.9f, 0, -0.3f, -0.9f, 0, -0.3f, -0.2f, 0, 0, 0.2f, 0, 0, 1.6f, 0, -0.3f, -1.6f, 0, -0.3f, -1, 0, 0, 1, 0, 0)
			.setRotationPoint(46, 0, -18.599998f).setRotationAngle(0, 0, 0).setName("Box 60")
		);
		lights_indicator_right.add(new ModelRendererTurbo(lights_indicator_right, 89, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 5, 2, 0, 0.1f, 0, -0.6f, 0, 0, -0.6f, -0.6f, 0, 0, 0.4f, 0, 0, 0.3f, -0.8f, -0.6f, 0, -0.8f, -0.6f, -0.7f, -0.8f, 0, 0.6f, -0.8f, 0)
			.setRotationPoint(-53.5f, -1, -18.599998f).setRotationAngle(0, 0, 0).setName("Box 326")
		);
		lights_indicator_right.add(new ModelRendererTurbo(lights_indicator_right, 353, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 5, 2, 0, -1, 0, -1.5f, 0, 0, -1.1f, 0, 0, 0, -0.4f, 0, 0, -0.8f, -0.8f, -1.5f, 0, -0.8f, -1.1f, 0, -0.8f, 0, -0.2f, -0.8f, 0)
			.setRotationPoint(-54, -1, -20).setRotationAngle(0, 0, 0).setName("Box 328")
		);
		lights_indicator_right.addProgram(DefaultPrograms.INDICATOR_LIGHT_RIGHT);
		this.groups.add(lights_indicator_right);
		//
		TurboList lights_rear = new TurboList("lights_rear");
		lights_rear.add(new ModelRendererTurbo(lights_rear, 401, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 13, 0, 0, 0, 0, 0, 0, 0, 0.5f, 0, 0.2f, -0.5f, 0, 0.2f, 0.3f, -0.8f, 0, -0.3f, -0.8f, 0, 0.3f, -0.8f, 0.2f, -0.3f, -0.8f, 0.2f)
			.setRotationPoint(-54.4f, -1, 3.4f).setRotationAngle(0, 0, 0).setName("Box 323")
		);
		lights_rear.add(new ModelRendererTurbo(lights_rear, 161, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 13, 0, -0.5f, 0, 0.2f, 0.5f, 0, 0.2f, 0, 0, 0, 0, 0, 0, -0.3f, -0.8f, 0.2f, 0.3f, -0.8f, 0.2f, -0.3f, -0.8f, 0, 0.3f, -0.8f, 0)
			.setRotationPoint(-54.4f, -1, -16.4f).setRotationAngle(0, 0, 0).setName("Box 324")
		);
		lights_rear.addProgram(DefaultPrograms.REAR_LIGHTS);
		this.groups.add(lights_rear);
	}

}