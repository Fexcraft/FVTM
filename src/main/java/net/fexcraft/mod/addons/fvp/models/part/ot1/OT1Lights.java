//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.part.ot1;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.4-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/part/ot1_lights") 
public class OT1Lights extends PartModel {

	public OT1Lights(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinandn (FEX___96)");
		//
		TurboList lights_front = new TurboList("lights_front");
		lights_front.add(new ModelRendererTurbo(lights_front, 65, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 3, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 1, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 1)
			.setRotationPoint(78, -7, -16.5f).setRotationAngle(0, 0, 0).setName("Box 298")
		);
		lights_front.add(new ModelRendererTurbo(lights_front, 329, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 3, 0, 0, 0, 1, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 1, 0, 0, 1, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 1)
			.setRotationPoint(78, -6, -16.5f).setRotationAngle(0, 0, 0).setName("Box 301")
		);
		lights_front.add(new ModelRendererTurbo(lights_front, 257, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 3, 0, 0, 0, 1, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 1, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0)
			.setRotationPoint(78, -5, -16.5f).setRotationAngle(0, 0, 0).setName("Box 299")
		);
		lights_front.add(new ModelRendererTurbo(lights_front, 89, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 3, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 1, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 1)
			.setRotationPoint(78, -7, 13.5f).setRotationAngle(0, 0, 0).setName("Box 292")
		);
		lights_front.add(new ModelRendererTurbo(lights_front, 265, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 3, 0, 0, 0, 1, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 1, 0, 0, 1, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 1)
			.setRotationPoint(78, -6, 13.5f).setRotationAngle(0, 0, 0).setName("Box 293")
		);
		lights_front.add(new ModelRendererTurbo(lights_front, 481, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 3, 0, 0, 0, 1, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 1, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0)
			.setRotationPoint(78, -5, 13.5f).setRotationAngle(0, 0, 0).setName("Box 294")
		);
		lights_front.addProgram(DefaultPrograms.FRONT_LIGHTS);
		this.groups.add(lights_front);
		//
		TurboList lights_rear = new TurboList("lights_rear");
		lights_rear.add(new ModelRendererTurbo(lights_rear, 73, 1, textureX, textureY).addBox(0, 0, 0, 1, 2, 5)
			.setRotationPoint(-76.2f, -5.25f, -15).setRotationAngle(0, 0, 0).setName("Box 284")
		);
		lights_rear.add(new ModelRendererTurbo(lights_rear, 129, 1, textureX, textureY).addBox(0, 0, 0, 1, 2, 5)
			.setRotationPoint(-76.2f, -5.25f, 10).setRotationAngle(0, 0, 0).setName("Box 287")
		);
		lights_rear.addProgram(DefaultPrograms.REAR_LIGHTS);
		this.groups.add(lights_rear);
		//
		TurboList lights_turn_left = new TurboList("lights_turn_left");
		lights_turn_left.add(new ModelRendererTurbo(lights_turn_left, 105, 1, textureX, textureY).addBox(0, 0, 0, 1, 1, 5)
			.setRotationPoint(-76.2f, -2.75f, 10).setRotationAngle(0, 0, 0).setName("Box 286")
		);
		lights_turn_left.add(new ModelRendererTurbo(lights_turn_left, 49, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 1, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 1, 0, 0, 1, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 1)
			.setRotationPoint(78, -6, 18.5f).setRotationAngle(0, 0, 0).setName("Box 289")
		);
		lights_turn_left.add(new ModelRendererTurbo(lights_turn_left, 57, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 1, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 1, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0)
			.setRotationPoint(78, -5, 18.5f).setRotationAngle(0, 0, 0).setName("Box 290")
		);
		lights_turn_left.add(new ModelRendererTurbo(lights_turn_left, 137, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 1, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 1)
			.setRotationPoint(78, -7, 18.5f).setRotationAngle(0, 0, 0).setName("Box 291")
		);
		lights_turn_left.addProgram(DefaultPrograms.INDICATOR_LIGHT_LEFT);
		this.groups.add(lights_turn_left);
		//
		TurboList lights_turn_right = new TurboList("lights_turn_right");
		lights_turn_right.add(new ModelRendererTurbo(lights_turn_right, 89, 1, textureX, textureY).addBox(0, 0, 0, 1, 1, 5)
			.setRotationPoint(-76.2f, -2.75f, -15).setRotationAngle(0, 0, 0).setName("Box 285")
		);
		lights_turn_right.add(new ModelRendererTurbo(lights_turn_right, 169, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 1, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 1, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0)
			.setRotationPoint(78, -5, -19.5f).setRotationAngle(0, 0, 0).setName("Box 295")
		);
		lights_turn_right.add(new ModelRendererTurbo(lights_turn_right, 249, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 1, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 1, 0, 0, 1, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 1)
			.setRotationPoint(78, -6, -19.5f).setRotationAngle(0, 0, 0).setName("Box 296")
		);
		lights_turn_right.add(new ModelRendererTurbo(lights_turn_right, 425, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 1, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 1)
			.setRotationPoint(78, -7, -19.5f).setRotationAngle(0, 0, 0).setName("Box 297")
		);
		lights_turn_right.addProgram(DefaultPrograms.INDICATOR_LIGHT_RIGHT);
		this.groups.add(lights_turn_right);
	}

}
