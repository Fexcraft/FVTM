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
@fModel(registryname = "fvp:models/part/c4_steering_wheel")
public class C4R1ST extends PartModel {

	public C4R1ST(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList steering = new TurboList("steering");
		steering.add(new ModelRendererTurbo(steering, 451, 11, textureX, textureY).addHollowCylinder(-1.05f, 0, 0, 4, 3, 1.1f, 11, 0, 1, 1, 2)
			.setRotationPoint(33, -27, 13).setRotationAngle(0, 0, 15)
		);
		steering.add(new ModelRendererTurbo(steering, 155, 81, textureX, textureY).addBox(-1, 0.5f, -1, 1, 3, 2)
			.setRotationPoint(33, -27, 13).setRotationAngle(0, 0, 15).setName("Box 102cp")
		);
		steering.add(new ModelRendererTurbo(steering, 102, 115, textureX, textureY).addBox(-1, -1.5f, -3, 1, 2, 6)
			.setRotationPoint(33, -27, 13).setRotationAngle(0, 0, 15).setName("Box 102")
		);
		steering.addPrograms(DefaultPrograms.STEERING_X);//, DefaultPrograms.NO_CULLFACE);
		this.groups.add(steering);
		//
	}

}
