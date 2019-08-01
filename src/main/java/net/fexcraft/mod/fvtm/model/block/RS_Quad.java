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
@fModel(registryname = "fvtm:models/roadsign/quad")
public class RS_Quad extends RoadSignModel {

	public static final RS_Quad INSTANCE = new RS_Quad();

	public RS_Quad(){
		super(); textureX = 32; textureY = 16;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList group0 = new TurboList("group0");
		group0.add(new ModelRendererTurbo(group0, 0, 0, textureX, textureY)
			.addTexRect(0, 0, 0, 16, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			new float[][]{ new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 16.0f, 1.0f, 0.0f, 1.0f, 0.0f, 15.0f, 16.0f, 15.0f }, new float[]{ 32.0f, 1.0f, 16.0f, 1.0f, 16.0f, 15.0f, 32.0f, 15.0f } })
			.setRotationPoint(-8, -15, -2.0625f).setRotationAngle(0, 0, 0)
		);
		group0.add(new ModelRendererTurbo(group0, 0, 0, textureX, textureY)
			.addTexRect(0, 0, 0, 16, 1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			new float[][]{ new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 15.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 16.0f, 1.0f }, new float[]{ 31.0f, 0.0f, 17.0f, 0.0f, 16.0f, 1.0f, 32.0f, 1.0f } })
			.setRotationPoint(-8, -16, -2.0625f).setRotationAngle(0, 0, 0)
		);
		group0.add(new ModelRendererTurbo(group0, 0, 0, textureX, textureY)
			.addTexRect(0, 0, 0, 16, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0,
			new float[][]{ new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 16.0f, 15.0f, 0.0f, 15.0f, 1.0f, 16.0f, 15.0f, 16.0f }, new float[]{ 32.0f, 15.0f, 16.0f, 15.0f, 16.0f, 16.0f, 31.0f, 16.0f } })
			.setRotationPoint(-8, -1, -2.0625f).setRotationAngle(0, 0, 0)
		);
		this.groups.add(group0);
	}

}
