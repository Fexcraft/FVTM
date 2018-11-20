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
@fModel(registryname = "fvp:models/part/ab1b_lights")
public class AB1Lights extends PartModel {

	public AB1Lights(){
		super(); textureX = 1024; textureY = 1024;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList back_lights = new TurboList("back_lights");
		back_lights.add(new ModelRendererTurbo(back_lights, 33, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 10, 3, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-108.2f, -23, 28.7f).setRotationAngle(0, 0, 0).setName("Box 308")
		);
		back_lights.add(new ModelRendererTurbo(back_lights, 321, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 10, 3, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 0)
			.setRotationPoint(-108.2f, -23, -31.7f).setRotationAngle(0, 0, 0).setName("Box 309")
		);
		back_lights.addProgram(DefaultPrograms.BACK_LIGHTS);
		this.groups.add(back_lights);
		//
		TurboList front_lights = new TurboList("front_lights");
		front_lights.add(new ModelRendererTurbo(front_lights, 57, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 8, 0, 1, 0, 0, 3, 0, 0, -0.2f, 0, 0, 1, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 1, 0, 0)
			.setRotationPoint(97.2f, -10, 23.7f).setRotationAngle(0, 0, 0).setName("Box 306")
		);
		front_lights.add(new ModelRendererTurbo(front_lights, 81, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 8, 0, 1, 0, 0, -0.2f, 0, 0, 3, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0)
			.setRotationPoint(97.2f, -10, -31.7f).setRotationAngle(0, 0, 0).setName("Box 307")
		);
		front_lights.addProgram(DefaultPrograms.FRONT_LIGHTS);
		this.groups.add(front_lights);
	}

}
