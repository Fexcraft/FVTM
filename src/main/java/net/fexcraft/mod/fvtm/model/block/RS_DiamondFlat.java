//FMT-Marker FVTM-1.1
package net.fexcraft.mod.fvtm.model.block;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.RoadSignModel;
import net.fexcraft.mod.fvtm.model.TurboList;

/** This file was exported via the FVTM Exporter V1.2 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.2.9 &copy; 2019 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
//@fModel(registryname = "fvtm:models/roadsign/diamond_flat")
public class RS_DiamondFlat extends RoadSignModel {

	public RS_DiamondFlat(String[] splits){
		super(); textureX = 32; textureY = 32;
		this.addToCreators("Ferdinand (FEX___96)");
		boolean l0 = false;
		for(String str : splits){
			if(str.startsWith("layer")){
				String[] strs = str.replace("layer:", "").split(",");
				for(String s : strs){
					if(s.equals("0")) l0 = true;
				}
				break;
			}
		}
		//
		TurboList group0 = new TurboList("group0");
		group0.add(new ModelRendererTurbo(group0, 0, 0, textureX, textureY)
			.addTexRect(-8, 0, 0, 16, 16, 0.125f, 0, -8, 0, 0, 0, -8, 0, 0, -8, 0, -8, 0, 0, 0, -8, 0, -8, 0, 0, -8, 0, 0, 0, -8, 0,
			new float[][]{ new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 16.0f, 8.0f, 8.0f, 0.0f, 0.0f, 8.0f, 8.0f, 16.0f }, new float[]{ 32.0f, 8.0f, 24.0f, 0.0f, 16.0f, 8.0f, 24.0f, 16.0f } })
			.setRotationPoint(0, -16, -2.125f).setRotationAngle(0, 0, 0).setName("base")
		);
		if(l0){
			group0.add(new ModelRendererTurbo(group0, 0, 16, textureX, textureY)
				.addShapeBox(0, 0, 0, 16, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
				.setRotationPoint(-8, -16, -2.1875f).setRotationAngle(0, 0, 0).setName("layer0")
			);
		}
		this.groups.add(group0);
	}

}
