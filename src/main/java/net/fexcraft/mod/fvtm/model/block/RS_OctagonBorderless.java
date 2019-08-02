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
@fModel(registryname = "fvtm:models/roadsign/octagon_flat")
public class RS_OctagonBorderless extends RoadSignModel {

	public static final RS_OctagonBorderless INSTANCE = new RS_OctagonBorderless();
	
	public RS_OctagonBorderless(){
		super(); textureX = 32; textureY = 16;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList group0 = new TurboList("group0");
		group0.add(new ModelRendererTurbo(group0, 0, 0, textureX, textureY)
			.addTexRect(0, 0, 0, 16, 5, 0.125f, 0, -5, 0, 0, -5, 0, 0, -5, 0, 0, -5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			new float[][]{ new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 11.0f, 0.0f, 5.0f, 0.0f, 0.0f, 5.0f, 16.0f, 5.0f }, new float[]{ 27.0f, 0.0f, 21.0f, 0.0f, 16.0f, 5.0f, 32.0f, 5.0f } })
			.setRotationPoint(-8, -16, -2.125f).setRotationAngle(0, 0, 0)
		);
		group0.add(new ModelRendererTurbo(group0, 0, 0, textureX, textureY)
			.addTexRect(0, 0, 0, 16, 6, 0.125f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			new float[][]{ new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 16.0f, 5.0f, 0.0f, 5.0f, 0.0f, 11.0f, 16.0f, 11.0f }, new float[]{ 32.0f, 5.0f, 16.0f, 5.0f, 16.0f, 11.0f, 32.0f, 11.0f } })
			.setRotationPoint(-8, -11, -2.125f).setRotationAngle(0, 0, 0)
		);
		group0.add(new ModelRendererTurbo(group0, 0, 0, textureX, textureY)
			.addTexRect(0, -1, 0, 16, 5, 0.125f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -5, 0, 0, -5, 0, 0, -5, 0, 0, -5, 0, 0,
			new float[][]{ new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 16.0f, 11.0f, 0.0f, 11.0f, 5.0f, 16.0f, 11.0f, 16.0f }, new float[]{ 32.0f, 11.0f, 16.0f, 11.0f, 21.0f, 16.0f, 27.0f, 16.0f } })
			.setRotationPoint(-8, -4, -2.125f).setRotationAngle(0, 0, 0)
		);
		this.groups.add(group0);
	}

}
