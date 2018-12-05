//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.hcp.models.part;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.4-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "hcp:models/part/tr1_lights")
public class TR1Lights extends PartModel {

	public TR1Lights(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList indicator_left = new TurboList("indicator_left");
		indicator_left.add(new ModelRendererTurbo(indicator_left, 505, 33, textureX, textureY).addBox(0, 0, 0, 1, 4, 1)
			.setRotationPoint(-236, -20.5f, 24).setRotationAngle(0, 0, 0).setName("Box 371")
		);
		indicator_left.addProgram(DefaultPrograms.INDICATOR_LIGHT_LEFT);
		this.groups.add(indicator_left);
		//
		TurboList indicator_right = new TurboList("indicator_right");
		indicator_right.add(new ModelRendererTurbo(indicator_right, 1, 41, textureX, textureY).addBox(0, 0, 0, 1, 4, 1)
			.setRotationPoint(-236, -20.5f, -25).setRotationAngle(0, 0, 0).setName("Box 372")
		);
		indicator_right.addProgram(DefaultPrograms.INDICATOR_LIGHT_RIGHT);
		this.groups.add(indicator_right);
		//
		TurboList lights = new TurboList("lights");
		lights.add(new ModelRendererTurbo(lights, 33, 49, textureX, textureY).addBox(0, 0, 0, 3, 1, 1)
			.setRotationPoint(-232, -20, -25.5f).setRotationAngle(0, 0, 0).setName("Box 79")
		);
		lights.add(new ModelRendererTurbo(lights, 313, 49, textureX, textureY).addBox(0, 0, 0, 3, 1, 1)
			.setRotationPoint(-222, -20, -25.5f).setRotationAngle(0, 0, 0).setName("Box 80")
		);
		lights.add(new ModelRendererTurbo(lights, 329, 49, textureX, textureY).addBox(0, 0, 0, 3, 1, 1)
			.setRotationPoint(-212, -20, -25.5f).setRotationAngle(0, 0, 0).setName("Box 81")
		);
		lights.add(new ModelRendererTurbo(lights, 345, 49, textureX, textureY).addBox(0, 0, 0, 3, 1, 1)
			.setRotationPoint(-202, -20, -25.5f).setRotationAngle(0, 0, 0).setName("Box 82")
		);
		lights.add(new ModelRendererTurbo(lights, 481, 49, textureX, textureY).addBox(0, 0, 0, 3, 1, 1)
			.setRotationPoint(-192, -20, -25.5f).setRotationAngle(0, 0, 0).setName("Box 83")
		);
		lights.add(new ModelRendererTurbo(lights, 25, 57, textureX, textureY).addBox(0, 0, 0, 3, 1, 1)
			.setRotationPoint(-182, -20, -25.5f).setRotationAngle(0, 0, 0).setName("Box 84")
		);
		lights.add(new ModelRendererTurbo(lights, 41, 57, textureX, textureY).addBox(0, 0, 0, 3, 1, 1)
			.setRotationPoint(-172, -20, -25.5f).setRotationAngle(0, 0, 0).setName("Box 85")
		);
		lights.add(new ModelRendererTurbo(lights, 209, 57, textureX, textureY).addBox(0, 0, 0, 3, 1, 1)
			.setRotationPoint(-162, -20, -25.5f).setRotationAngle(0, 0, 0).setName("Box 86")
		);
		lights.add(new ModelRendererTurbo(lights, 425, 65, textureX, textureY).addBox(0, 0, 0, 3, 1, 1)
			.setRotationPoint(-152, -20, -25.5f).setRotationAngle(0, 0, 0).setName("Box 87")
		);
		lights.add(new ModelRendererTurbo(lights, 441, 65, textureX, textureY).addBox(0, 0, 0, 3, 1, 1)
			.setRotationPoint(-142, -20, -25.5f).setRotationAngle(0, 0, 0).setName("Box 88")
		);
		lights.add(new ModelRendererTurbo(lights, 1, 73, textureX, textureY).addBox(0, 0, 0, 3, 1, 1)
			.setRotationPoint(-132, -20, -25.5f).setRotationAngle(0, 0, 0).setName("Box 89")
		);
		lights.add(new ModelRendererTurbo(lights, 185, 73, textureX, textureY).addBox(0, 0, 0, 3, 1, 1)
			.setRotationPoint(-122, -20, -25.5f).setRotationAngle(0, 0, 0).setName("Box 90")
		);
		lights.add(new ModelRendererTurbo(lights, 209, 73, textureX, textureY).addBox(0, 0, 0, 3, 1, 1)
			.setRotationPoint(-112, -20, -25.5f).setRotationAngle(0, 0, 0).setName("Box 91")
		);
		lights.add(new ModelRendererTurbo(lights, 377, 73, textureX, textureY).addBox(0, 0, 0, 3, 1, 1)
			.setRotationPoint(-102, -20, -25.5f).setRotationAngle(0, 0, 0).setName("Box 92")
		);
		lights.add(new ModelRendererTurbo(lights, 393, 73, textureX, textureY).addBox(0, 0, 0, 3, 1, 1)
			.setRotationPoint(-92, -20, -25.5f).setRotationAngle(0, 0, 0).setName("Box 93")
		);
		lights.add(new ModelRendererTurbo(lights, 425, 73, textureX, textureY).addBox(0, 0, 0, 3, 1, 1)
			.setRotationPoint(-82, -20, -25.5f).setRotationAngle(0, 0, 0).setName("Box 94")
		);
		lights.add(new ModelRendererTurbo(lights, 441, 73, textureX, textureY).addBox(0, 0, 0, 3, 1, 1)
			.setRotationPoint(-72, -20, -25.5f).setRotationAngle(0, 0, 0).setName("Box 95")
		);
		lights.add(new ModelRendererTurbo(lights, 1, 81, textureX, textureY).addBox(0, 0, 0, 3, 1, 1)
			.setRotationPoint(-62, -20, -25.5f).setRotationAngle(0, 0, 0).setName("Box 96")
		);
		lights.add(new ModelRendererTurbo(lights, 41, 81, textureX, textureY).addBox(0, 0, 0, 3, 1, 1)
			.setRotationPoint(-232, -20, 24.5f).setRotationAngle(0, 0, 0).setName("Box 97")
		);
		lights.add(new ModelRendererTurbo(lights, 185, 81, textureX, textureY).addBox(0, 0, 0, 3, 1, 1)
			.setRotationPoint(-222, -20, 24.5f).setRotationAngle(0, 0, 0).setName("Box 98")
		);
		lights.add(new ModelRendererTurbo(lights, 209, 81, textureX, textureY).addBox(0, 0, 0, 3, 1, 1)
			.setRotationPoint(-212, -20, 24.5f).setRotationAngle(0, 0, 0).setName("Box 99")
		);
		lights.add(new ModelRendererTurbo(lights, 233, 81, textureX, textureY).addBox(0, 0, 0, 3, 1, 1)
			.setRotationPoint(-202, -20, 24.5f).setRotationAngle(0, 0, 0).setName("Box 100")
		);
		lights.add(new ModelRendererTurbo(lights, 249, 81, textureX, textureY).addBox(0, 0, 0, 3, 1, 1)
			.setRotationPoint(-192, -20, 24.5f).setRotationAngle(0, 0, 0).setName("Box 101")
		);
		lights.add(new ModelRendererTurbo(lights, 265, 81, textureX, textureY).addBox(0, 0, 0, 3, 1, 1)
			.setRotationPoint(-182, -20, 24.5f).setRotationAngle(0, 0, 0).setName("Box 102")
		);
		lights.add(new ModelRendererTurbo(lights, 321, 81, textureX, textureY).addBox(0, 0, 0, 3, 1, 1)
			.setRotationPoint(-172, -20, 24.5f).setRotationAngle(0, 0, 0).setName("Box 103")
		);
		lights.add(new ModelRendererTurbo(lights, 337, 81, textureX, textureY).addBox(0, 0, 0, 3, 1, 1)
			.setRotationPoint(-162, -20, 24.5f).setRotationAngle(0, 0, 0).setName("Box 104")
		);
		lights.add(new ModelRendererTurbo(lights, 353, 81, textureX, textureY).addBox(0, 0, 0, 3, 1, 1)
			.setRotationPoint(-152, -20, 24.5f).setRotationAngle(0, 0, 0).setName("Box 105")
		);
		lights.add(new ModelRendererTurbo(lights, 377, 81, textureX, textureY).addBox(0, 0, 0, 3, 1, 1)
			.setRotationPoint(-142, -20, 24.5f).setRotationAngle(0, 0, 0).setName("Box 106")
		);
		lights.add(new ModelRendererTurbo(lights, 393, 81, textureX, textureY).addBox(0, 0, 0, 3, 1, 1)
			.setRotationPoint(-132, -20, 24.5f).setRotationAngle(0, 0, 0).setName("Box 107")
		);
		lights.add(new ModelRendererTurbo(lights, 409, 81, textureX, textureY).addBox(0, 0, 0, 3, 1, 1)
			.setRotationPoint(-122, -20, 24.5f).setRotationAngle(0, 0, 0).setName("Box 108")
		);
		lights.add(new ModelRendererTurbo(lights, 425, 81, textureX, textureY).addBox(0, 0, 0, 3, 1, 1)
			.setRotationPoint(-112, -20, 24.5f).setRotationAngle(0, 0, 0).setName("Box 109")
		);
		lights.add(new ModelRendererTurbo(lights, 441, 81, textureX, textureY).addBox(0, 0, 0, 3, 1, 1)
			.setRotationPoint(-102, -20, 24.5f).setRotationAngle(0, 0, 0).setName("Box 110")
		);
		lights.add(new ModelRendererTurbo(lights, 465, 81, textureX, textureY).addBox(0, 0, 0, 3, 1, 1)
			.setRotationPoint(-92, -20, 24.5f).setRotationAngle(0, 0, 0).setName("Box 111")
		);
		lights.add(new ModelRendererTurbo(lights, 481, 81, textureX, textureY).addBox(0, 0, 0, 3, 1, 1)
			.setRotationPoint(-82, -20, 24.5f).setRotationAngle(0, 0, 0).setName("Box 112")
		);
		lights.add(new ModelRendererTurbo(lights, 497, 81, textureX, textureY).addBox(0, 0, 0, 3, 1, 1)
			.setRotationPoint(-72, -20, 24.5f).setRotationAngle(0, 0, 0).setName("Box 113")
		);
		lights.add(new ModelRendererTurbo(lights, 1, 89, textureX, textureY).addBox(0, 0, 0, 3, 1, 1)
			.setRotationPoint(-62, -20, 24.5f).setRotationAngle(0, 0, 0).setName("Box 114")
		);
		lights.addProgram(DefaultPrograms.LIGHTS);
		this.groups.add(lights);
		//
		TurboList lights_brake = new TurboList("lights_brake");
		lights_brake.add(new ModelRendererTurbo(lights_brake, 505, 1, textureX, textureY).addBox(0, 0, 0, 1, 4, 2)
			.setRotationPoint(-236, -20.5f, -24).setRotationAngle(0, 0, 0).setName("Box 118")
		);
		lights_brake.add(new ModelRendererTurbo(lights_brake, 505, 9, textureX, textureY).addBox(0, 0, 0, 1, 4, 1)
			.setRotationPoint(-236, -20.5f, -15).setRotationAngle(0, 0, 0).setName("Box 121")
		);
		lights_brake.add(new ModelRendererTurbo(lights_brake, 505, 17, textureX, textureY).addBox(0, 0, 0, 1, 4, 2)
			.setRotationPoint(-236, -20.5f, 22).setRotationAngle(0, 0, 0).setName("Box 122")
		);
		lights_brake.add(new ModelRendererTurbo(lights_brake, 505, 25, textureX, textureY).addBox(0, 0, 0, 1, 4, 1)
			.setRotationPoint(-236, -20.5f, 14).setRotationAngle(0, 0, 0).setName("Box 125")
		);
		lights_brake.addProgram(DefaultPrograms.REVERSE_LIGHTS);
		this.groups.add(lights_brake);
		//
		TurboList lights_rear = new TurboList("lights_rear");
		lights_rear.add(new ModelRendererTurbo(lights_rear, 1, 97, textureX, textureY).addBox(0, 0, 0, 1, 2, 7)
			.setRotationPoint(-236, -20.5f, -22).setRotationAngle(0, 0, 0).setName("Box 119")
		);
		lights_rear.add(new ModelRendererTurbo(lights_rear, 361, 161, textureX, textureY).addBox(0, 0, 0, 1, 2, 7)
			.setRotationPoint(-236, -20.5f, 15).setRotationAngle(0, 0, 0).setName("Box 123")
		);
		lights_rear.addProgram(DefaultPrograms.REAR_LIGHTS);
		this.groups.add(lights_rear);
	}

}