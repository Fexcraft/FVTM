//FMT-Marker FVTM-1
package net.fexcraft.mod.fvtm.model;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.vehicle.VehicleModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.7-test &copy; 2019 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvtm:nrvph")//"No Rail Vehicle - Placeholder Model"
public class NRVPH extends VehicleModel {
	
	public static NRVPH INSTANCE = new NRVPH();

	public NRVPH(){
		super(); textureX = 256; textureY = 256;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList group0 = new TurboList("group0");
		group0.add(new ModelRendererTurbo(group0, 25, 4, textureX, textureY).addCylinder(0, 0, 0, 6, 2, 16, 1, 1, 1)
			.setRotationPoint(10, -14, 15).setRotationAngle(0, 0, 0)
		);
		group0.add(new ModelRendererTurbo(group0, 0, 4, textureX, textureY).addCylinder(0, 0, -2, 6, 2, 16, 1, 1, 0)
			.setRotationPoint(10, -14, -15).setRotationAngle(0, 0, 0)
		);
		group0.add(new ModelRendererTurbo(group0, 229, 0, textureX, textureY).addCylinder(0, 0, 0, 6, 2, 16, 1, 1, 1)
			.setRotationPoint(-10, -14, 15).setRotationAngle(0, 0, 0)
		);
		group0.add(new ModelRendererTurbo(group0, 204, 0, textureX, textureY).addCylinder(0, 0, -2, 6, 2, 16, 1, 1, 0)
			.setRotationPoint(-10, -14, -15).setRotationAngle(0, 0, 0)
		);
		group0.add(new ModelRendererTurbo(group0, 153, 0, textureX, textureY)
			.addShapeBox(0, 0, 0, 24, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-12, -15, 17).setRotationAngle(0, 0, 0)
		);
		group0.add(new ModelRendererTurbo(group0, 102, 0, textureX, textureY)
			.addShapeBox(0, 0, 0, 24, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-12, -15, -18).setRotationAngle(0, 0, 0)
		);
		group0.add(new ModelRendererTurbo(group0, 51, 0, textureX, textureY)
			.addShapeBox(0, 0, 0, 24, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-12, -15, -15).setRotationAngle(0, 0, 0)
		);
		group0.add(new ModelRendererTurbo(group0, 0, 0, textureX, textureY)
			.addShapeBox(0, 0, 0, 24, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-12, -15, 14).setRotationAngle(0, 0, 0)
		);
		group0.add(new ModelRendererTurbo(group0, 22, 4, textureX, textureY)
			.addShapeBox(0, 0, 0, 22, 1, 28, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-11, -14.5f, -14).setRotationAngle(0, 0, 0)
		);
		group0.addProgram(DefaultPrograms.LIGHTS);
		this.groups.add(group0);
	}

}
