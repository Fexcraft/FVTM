//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.test.models;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.vehicle.VehicleModel;

/** This file was exported via the FVTM Exporter V1 of
 *  FMT (Fex's Modelling Toolbox) v.1.0.0-test &copy; 2018 - Fexcraft.net
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "test:models/msbt")
public class MSBT extends VehicleModel {

	public MSBT(){
		super(); textureX = 64; textureY = 32;
		//
		TurboList group0 = new TurboList("group0");
		group0.add(new ModelRendererTurbo(group0, 1, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 8, 8, 0, 0, 0, -4, 0, 0, -4, 0, 0, 4, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-8, -8, -8).setRotationAngle(0, 0, 0).setName("Box 0")
		);
		group0.add(new ModelRendererTurbo(group0, 25, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 8, 3, 0, -4, 0, 0, 4, 0, 0, 4, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(0, -8, 5).setRotationAngle(0, 0, 0).setName("Box 1")
		);
		group0.add(new ModelRendererTurbo(group0, 17, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 3, 8, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, -4, 0, 0)
			.setRotationPoint(0, -29, -6).setRotationAngle(0, 0, 0).setName("Box 2")
		);
		this.groups.add(group0);
	}

}
