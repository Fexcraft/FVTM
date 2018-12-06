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
@fModel(registryname = "hcp:models/part/container_lift_wheels")
public class ContainerLiftWheels extends PartModel {

	public ContainerLiftWheels(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList wheels = new TurboList("wheels");
		wheels.add(new ModelRendererTurbo(wheels, 447, 73, textureX, textureY).setFlipped(true).addCylinder(0, 0, 0, 12, 7, 16, 1, 1, 0)
			.setRotationPoint(-27, -1, 33).setRotationAngle(0, 0, 0)
		);
		wheels.add(new ModelRendererTurbo(wheels, 425, 41, textureX, textureY).setFlipped(true).addCylinder(0, 0, 0, 12, 7, 16, 1, 1, 0)
			.setRotationPoint(27, -1, 34).setRotationAngle(0, 0, 0)
		);
		wheels.add(new ModelRendererTurbo(wheels, 376, 41, textureX, textureY).setFlipped(true).addCylinder(0, 0, 0, 12, 7, 16, 1, 1, 0)
			.setRotationPoint(-27, -1, -41).setRotationAngle(0, 0, 0)
		);
		wheels.add(new ModelRendererTurbo(wheels, 0, 28, textureX, textureY).setFlipped(true).addCylinder(0, 0, 0, 12, 7, 16, 1, 1, 0)
			.setRotationPoint(27, -1, -41).setRotationAngle(0, 0, 0)
		);
		wheels.add(new ModelRendererTurbo(wheels, 455, 9, textureX, textureY).setFlipped(true).addCylinder(0, 0, 0, 12, 7, 16, 1, 1, 0)
			.setRotationPoint(0, -1, 34).setRotationAngle(0, 0, 0)
		);
		wheels.add(new ModelRendererTurbo(wheels, 406, 9, textureX, textureY).setFlipped(true).addCylinder(0, 0, 0, 12, 7, 16, 1, 1, 0)
			.setRotationPoint(0, -1, -41).setRotationAngle(0, 0, 0)
		);
		wheels.addProgram(DefaultPrograms.DEF_WHEEL_ROTATE);
		this.groups.add(wheels);
		this.translate(0, 144, 0);
	}

}
