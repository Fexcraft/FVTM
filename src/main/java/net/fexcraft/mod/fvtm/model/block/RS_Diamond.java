//FMT-Marker FVTM-1.1
package net.fexcraft.mod.fvtm.model.block;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.RoadSignModel;

/** This file was exported via the FVTM Exporter V1.2 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.2.9 &copy; 2019 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
//@fModel(registryname = "fvtm:models/roadsign/diamond")
public class RS_Diamond extends RoadSignModel {

	public RS_Diamond(String[] splits){
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
		TurboList border = new TurboList("border");
		border.add(new ModelRendererTurbo(border, 16, 16, textureX, textureY).addBox(0, 0, 0, 1, 10.0625f, 1)
			.setRotationPoint(0, -15.125f, -3).setRotationAngle(0, 0, -45)
		);
		border.add(new ModelRendererTurbo(border, 16, 16, textureX, textureY).addBox(-1, 0, 0, 1, 10.0625f, 1)
			.setRotationPoint(0, -15.125f, -3).setRotationAngle(0, 0, 45)
		);
		border.add(new ModelRendererTurbo(border, 16, 16, textureX, textureY).addBox(0, 0, 0, 1, 10.0625f, 1)
			.setRotationPoint(0, -0.875f, -3).setRotationAngle(0, 0, -225)
		);
		border.add(new ModelRendererTurbo(border, 16, 16, textureX, textureY).addBox(-1, 0, 0, 1, 10.0625f, 1)
			.setRotationPoint(0, -0.875f, -3).setRotationAngle(0, 0, -135)
		);
		border.add(new ModelRendererTurbo(border, 16, 16, textureX, textureY).addHollowCylinder(0, 0, 0, 1, 0.01f, 1, 16, 4, 1, 1, 1, null)
			.setRotationPoint(0, -15.125f, -3).setRotationAngle(0, 0, -135)
		);
		border.add(new ModelRendererTurbo(border, 16, 16, textureX, textureY).addHollowCylinder(0, 0, 0, 1, 0.01f, 1, 16, 4, 1, 1, 1, null)
			.setRotationPoint(0, -0.875f, -3).setRotationAngle(0, 0, 45)
		);
		border.add(new ModelRendererTurbo(border, 16, 16, textureX, textureY).addHollowCylinder(0.08f, 0.08f, 0, 1, 0.01f, 1, 16, 4, 1, 1, 1, null)
			.setRotationPoint(-7, -8, -3).setRotationAngle(0, 0, 135)
		);
		border.add(new ModelRendererTurbo(border, 16, 16, textureX, textureY).addHollowCylinder(0, 0, 0, 1, 0.01f, 1, 16, 4, 1, 1, 1, null)
			.setRotationPoint(7.125f, -8, -3).setRotationAngle(0, 0, -45)
		);
		this.groups.add(border);
		//
		TurboList group0 = new TurboList("group0");
		group0.add(new ModelRendererTurbo(group0, 0, 0, textureX, textureY)
			.addTexRect(-7, 0, 0, 14, 14, 0.125f, 0, -7, 0.125f, 0, 0.125f, -7, 0, 0, -7, 0, -6.875f, 0.125f, 0, 0.125f, -7, 0, -7, 0.125f, 0, -7, 0.125f, 0, 0.125f, -7, 0,
			new float[][]{ new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 16.0f, 8.0f, 8.0f, 0.0f, 0.0f, 8.0f, 8.0f, 16.0f }, new float[]{ 32.0f, 8.0f, 24.0f, 0.0f, 16.0f, 8.0f, 24.0f, 16.0f } })
			.setRotationPoint(0, -15, -2.125f).setRotationAngle(0, 0, 0).setName("base")
		);
		if(l0){
			group0.add(new ModelRendererTurbo(group0, 0, 16, textureX, textureY)
				.addShapeBox(0, 0, 0, 16, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
				.setRotationPoint(-8, -16, -2.1875f).setRotationAngle(0, 0, 0).setName("layer0")
			);
		}
		this.groups.add(group0);
		//
	}

}
