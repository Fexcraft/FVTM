//FMT-Marker FVTM-1.1
package net.fexcraft.mod.fvtm.model.block;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.RoadSignModel;

/** This file was exported via the FVTM Exporter V1.2 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.2.9 &copy; 2019 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvtm:models/roadsign/round_borderless")
public class RS_RoundBorderless extends RoadSignModel {
	
	public static final RS_RoundBorderless INSTANCE = new RS_RoundBorderless();

	public RS_RoundBorderless(){
		super(); textureX = 32; textureY = 16;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList group0 = new TurboList("group0");
		group0.add(new ModelRendererTurbo(group0, 0, 0, textureX, textureY).addCylinder(0, 0, 0, 8, 0.01f, 16, 1, 1, 2, null)
			.setRotationPoint(0, -8, -2).setRotationAngle(0, 90, 0)
		);
		this.groups.add(group0);
	}

}
