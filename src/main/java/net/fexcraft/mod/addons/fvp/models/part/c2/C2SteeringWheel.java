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
@fModel(registryname = "fvp:models/part/c2_steering_wheel")
public class C2SteeringWheel extends PartModel {

	public C2SteeringWheel(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList steering_wheel = new TurboList("steering_wheel");
		steering_wheel.add(new ModelRendererTurbo(steering_wheel, 425, 81, textureX, textureY).addBox(0, -3, -3, 1, 7, 7)
			.setRotationPoint(5, -26, 13).setRotationAngle(0, 0, 0.2617994f).setName("Box 94")
		);
		steering_wheel.addProgram(DefaultPrograms.STEERING_X);
		this.groups.add(steering_wheel);
	}

}