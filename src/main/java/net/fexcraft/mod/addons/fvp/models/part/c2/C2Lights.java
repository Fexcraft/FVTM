//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.part.c2;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.1-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/part/c2_lights")
public class C2Lights extends PartModel {

	public C2Lights(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList back_lights = new TurboList("back_lights");
		back_lights.add(new ModelRendererTurbo(back_lights, 505, 17, textureX, textureY).addBox(0, 0, 0, 1, 7, 2)
			.setRotationPoint(-82.2f, -25, 20.5f).setRotationAngle(0, 0, 0).setName("Box 148")
		);
		back_lights.add(new ModelRendererTurbo(back_lights, 273, 33, textureX, textureY).addBox(0, 0, 0, 1, 7, 2)
			.setRotationPoint(-82.2f, -25, -22.5f).setRotationAngle(0, 0, 0).setName("Box 149")
		);
		back_lights.addProgram(DefaultPrograms.BACK_LIGHTS);
		this.groups.add(back_lights);
		//
		TurboList front_lights = new TurboList("front_lights");
		front_lights.add(new ModelRendererTurbo(front_lights, 1, 1, textureX, textureY).addBox(0, 0, 0, 4, 3, 6)
			.setRotationPoint(40.5f, -22, 16).setRotationAngle(0, 0, 0).setName("Box 14")
		);
		front_lights.add(new ModelRendererTurbo(front_lights, 25, 1, textureX, textureY).addBox(0, 0, 0, 4, 3, 6)
			.setRotationPoint(40.5f, -22, -22).setRotationAngle(0, 0, 0).setName("Box 15")
		);
		front_lights.addProgram(DefaultPrograms.FRONT_LIGHTS);
		this.groups.add(front_lights);
		//
		TurboList indicator_lights = new TurboList("indicator_lights");
		indicator_lights.add(new ModelRendererTurbo(indicator_lights, 41, 1, textureX, textureY).addBox(0, 0, 0, 2, 2, 1)
			.setRotationPoint(42.5f, -21.5f, -24).setRotationAngle(0, 0, 0).setName("Box 29")
		);
		indicator_lights.add(new ModelRendererTurbo(indicator_lights, 209, 1, textureX, textureY).addBox(0, 0, 0, 2, 2, 1)
			.setRotationPoint(42.5f, -21.5f, 23).setRotationAngle(0, 0, 0).setName("Box 30")
		);
		indicator_lights.addProgram(DefaultPrograms.REVERSE_LIGHTS);
		this.groups.add(indicator_lights);
		//
	}

}