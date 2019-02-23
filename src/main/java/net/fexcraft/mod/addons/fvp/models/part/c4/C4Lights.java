//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.part.c4;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.7-test &copy; 2019 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/part/c4_lights")
public class C4Lights extends PartModel {

	public C4Lights(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList indicator_left = new TurboList("indicator_left");
		indicator_left.add(new ModelRendererTurbo(indicator_left, 228, 70, textureX, textureY).addBox(0, 0, 0, 1, 2, 1)
			.setRotationPoint(-64.2f, -11, 21.5f).setRotationAngle(0, 0, 0).setName("Box 132")
		);
		indicator_left.add(new ModelRendererTurbo(indicator_left, 402, 85, textureX, textureY)
			.addShapeBox(0, -2, 0, 5, 4, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0)
			.setRotationPoint(57.5f, -21, 20).setRotationAngle(0, 0, 0).setName("Box 52cp")
		);
		indicator_left.addProgram(DefaultPrograms.INDICATOR_LIGHT_LEFT);
		this.groups.add(indicator_left);
		//
		TurboList indicator_right = new TurboList("indicator_right");
		indicator_right.add(new ModelRendererTurbo(indicator_right, 159, 67, textureX, textureY).addBox(0, 0, 0, 1, 2, 1)
			.setRotationPoint(-64.2f, -11, -22.5f).setRotationAngle(0, 0, 0).setName("Box 131")
		);
		indicator_right.add(new ModelRendererTurbo(indicator_right, 217, 62, textureX, textureY)
			.addShapeBox(0, -2, 0, 5, 4, 3, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(57.5f, -21, -23).setRotationAngle(0, 0, 0).setName("Box 50cp")
		);
		indicator_right.addProgram(DefaultPrograms.INDICATOR_LIGHT_RIGHT);
		this.groups.add(indicator_right);
		//
		TurboList lights_fog = new TurboList("lights_fog");
		lights_fog.add(new ModelRendererTurbo(lights_fog, 374, 94, textureX, textureY).addBox(0, 0, 0, 1, 1, 3)
			.setRotationPoint(63.2f, -11, -20).setRotationAngle(0, 0, 0).setName("Box 143")
		);
		lights_fog.add(new ModelRendererTurbo(lights_fog, 155, 90, textureX, textureY).addBox(0, 0, 0, 1, 1, 3)
			.setRotationPoint(63.2f, -11, 17).setRotationAngle(0, 0, 0).setName("Box 144")
		);
		lights_fog.addProgram(DefaultPrograms.FOG_LIGHTS);
		this.groups.add(lights_fog);
		//
		TurboList lights_front = new TurboList("lights_front");
		lights_front.add(new ModelRendererTurbo(lights_front, 189, 106, textureX, textureY)
			.addShapeBox(0, -2, 0, 5, 4, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(57.5f, -21, -20).setRotationAngle(0, 0, 0).setName("Box 50")
		);
		lights_front.add(new ModelRendererTurbo(lights_front, 270, 103, textureX, textureY)
			.addShapeBox(0, -2, 0, 5, 4, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(57.5f, -21, 13).setRotationAngle(0, 0, 0).setName("Box 52")
		);
		lights_front.addProgram(DefaultPrograms.FRONT_LIGHTS);
		this.groups.add(lights_front);
		//
		TurboList lights_rear = new TurboList("lights_rear");
		lights_rear.add(new ModelRendererTurbo(lights_rear, 463, 132, textureX, textureY).addBox(0, 0, 0, 1, 2, 6)
			.setRotationPoint(-64.2f, -11, -21).setRotationAngle(0, 0, 0).setName("Box 129")
		);
		lights_rear.add(new ModelRendererTurbo(lights_rear, 396, 130, textureX, textureY).addBox(0, 0, 0, 1, 2, 6)
			.setRotationPoint(-64.2f, -11, 15).setRotationAngle(0, 0, 0).setName("Box 130")
		);
		lights_rear.addProgram(DefaultPrograms.REAR_LIGHTS);
		this.groups.add(lights_rear);
	}

}
