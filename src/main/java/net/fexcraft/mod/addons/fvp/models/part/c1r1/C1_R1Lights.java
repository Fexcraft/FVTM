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
@fModel(registryname = "fvp:models/part/c1_r1_lights")
public class C1_R1Lights extends PartModel {

	public C1_R1Lights(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList back_lights = new TurboList("back_lights");
		back_lights.add(new ModelRendererTurbo(back_lights, 281, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 5, 4, 0, -0.2f, 0, 0, 0, 0, 0, 0, 0, -0.1f, -0.6f, 0, -0.9f, 0.3f, 0, 0, 0, 0, 0, 0, 0, 0, -0.2f, 0, -0.8f)
			.setRotationPoint(-58, -8, 17).setRotationAngle(0, 0, 0).setName("Box 659")
		);
		back_lights.add(new ModelRendererTurbo(back_lights, 233, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 5, 4, 0, -0.6f, 0, -0.9f, 0, 0, -0.1f, 0, 0, 0, -0.2f, 0, 0, -0.2f, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0.3f, 0, 0)
			.setRotationPoint(-58, -8, -21).setRotationAngle(0, 0, 0).setName("Box 660")
		);
		back_lights.addProgram(DefaultPrograms.BACK_LIGHTS);
		this.groups.add(back_lights);
		//
		TurboList front_lights = new TurboList("front_lights");
		front_lights.add(new ModelRendererTurbo(front_lights, 481, 241, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 10, 0, 0, 0, 0, 0.7f, 0, 0, -0.1f, 0, -1, 0, 0, 0, 0, 0, 0, 0.9f, 0, 0, 0.1f, 0, -1, -0.2f, 0, 0)
			.setRotationPoint(54.5f, -6, 11).setRotationAngle(0, 0, 0).setName("Box 654")
		);
		front_lights.add(new ModelRendererTurbo(front_lights, 129, 257, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 10, 0, 0, 0, 0, -0.1f, 0, -1, 0.7f, 0, 0, 0, 0, 0, -0.2f, 0, 0, 0.1f, 0, -1, 0.9f, 0, 0, 0, 0, 0)
			.setRotationPoint(54.5f, -6, -21).setRotationAngle(0, 0, 0).setName("Box 656")
		);
		front_lights.addProgram(DefaultPrograms.FRONT_LIGHTS);
		this.groups.add(front_lights);
		//
	}

}