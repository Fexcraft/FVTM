//FMT-Marker FVTM-1.1
package net.fexcraft.mod.fvtm.model.block;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.RoadSignModel;

/** This file was exported via the FVTM Exporter V1.2 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.2.9 &copy; 2019 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
//@fModel(registryname = "fvtm:models/roadsign/triangle_up")
public class RS_TriangleUp extends RoadSignModel {

	public RS_TriangleUp(String[] splits){
		super(); textureX = 64; textureY = 32;
		this.addToCreators("Ferdinand (FEX___96)");
		boolean l0 = false, l1 = false, l2 = false, l3 = false;
		for(String str : splits){
			if(str.startsWith("layer")){
				String[] strs = str.replace("layer:", "").split(",");
				for(String s : strs){
					if(s.equals("0")) l0 = true;
					if(s.equals("1")) l1 = true;
					if(s.equals("2")) l2 = true;
					if(s.equals("3")) l3 = true;
				}
				break;
			}
		}
		//
		TurboList group0 = new TurboList("group0");
		group0.add(new ModelRendererTurbo(group0, 0, 26, textureX, textureY)
			.addShapeBox(0, 0, 0, 14, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-7, -2, -3).setRotationAngle(0, 0, 0).setName("border0")
		);
		group0.add(new ModelRendererTurbo(group0, 58, 0, textureX, textureY).addHollowCylinder(0, 0, 0, 1, 0.001f, 1, 12, 4, 1, 1, 1, null)
			.setRotationPoint(-7, -2, -3).setRotationAngle(0, 0, 120).setName("border1")
		);
		group0.add(new ModelRendererTurbo(group0, 0, 28, textureX, textureY)
			.addShapeBox(0, 0, 0, 14, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-7, -2, -2).setRotationAngle(0, 180, -120).setName("border2")
		);
		group0.add(new ModelRendererTurbo(group0, 58, 5, textureX, textureY).addHollowCylinder(0, 0, 0, 1, 0.001f, 1, 12, 4, 1, 1, 1, null)
			.setRotationPoint(7, -2, -3).setRotationAngle(0, 0, 0).setName("border3")
		);
		group0.add(new ModelRendererTurbo(group0, 0, 30, textureX, textureY)
			.addShapeBox(0, 0, 0, 14, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(7, -2, -3).setRotationAngle(0, 0, -120).setName("border4")
		);
		group0.add(new ModelRendererTurbo(group0, 58, 10, textureX, textureY).addHollowCylinder(0, 0, 0, 1, 0.001f, 1, 12, 4, 1, 1, 1, null)
			.setRotationPoint(0, -14.125f, -3).setRotationAngle(0, 0, 240).setName("border5")
		);
		if(l0){
			group0.add(new ModelRendererTurbo(group0, 0, 0, textureX, textureY)
				.addTexRect(0, 0, 0, 14, 12, 0, 0, -7, 0, 0, -7, 0, 0, -7, 0, 0, -7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				new float[][]{ new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 7.0f, 0.0f, 7.0f, 0.0f, 0.0f, 12.0f, 14.0f, 12.0f }, new float[]{ 0.0f, 0.0f, 21.0f, 0.0f, 14.0f, 12.0f, 28.0f, 12.0f } })
				.setRotationPoint(-7, -14, -2.25f).setRotationAngle(0, 0, 0).setName("layer0")
			);
		}
		if(l1){
			group0.add(new ModelRendererTurbo(group0, 29, 0, textureX, textureY)
				.addTexRect(0, 0, 0, 14, 12, 0, 0, -7, 0, 0, -7, 0, 0, -7, 0, 0, -7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				new float[][]{ new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 7.0f, 0.0f, 7.0f, 0.0f, 0.0f, 12.0f, 14.0f, 12.0f }, new float[]{ 0.0f, 0.0f, 21.0f, 0.0f, 14.0f, 12.0f, 28.0f, 12.0f } })
				.setRotationPoint(-7, -14, -2.5f).setRotationAngle(0, 0, 0).setName("layer1")
			);
		}
		if(l2){
			group0.add(new ModelRendererTurbo(group0, 0, 13, textureX, textureY)
				.addTexRect(0, 0, 0, 14, 12, 0, 0, -7, 0, 0, -7, 0, 0, -7, 0, 0, -7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				new float[][]{ new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 7.0f, 0.0f, 7.0f, 0.0f, 0.0f, 12.0f, 14.0f, 12.0f }, new float[]{ 0.0f, 0.0f, 21.0f, 0.0f, 14.0f, 12.0f, 28.0f, 12.0f } })
				.setRotationPoint(-7, -14, -2.75f).setRotationAngle(0, 0, 0).setName("layer2")
			);
		}
		if(l3){
			group0.add(new ModelRendererTurbo(group0, 29, 13, textureX, textureY)
				.addTexRect(0, 0, 0, 14, 12, 0, 0, -7, 0, 0, -7, 0, 0, -7, 0, 0, -7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				new float[][]{ new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 7.0f, 0.0f, 7.0f, 0.0f, 0.0f, 12.0f, 14.0f, 12.0f }, new float[]{ 0.0f, 0.0f, 21.0f, 0.0f, 14.0f, 12.0f, 28.0f, 12.0f } })
				.setRotationPoint(-7, -14, -2.875f).setRotationAngle(0, 0, 0).setName("layer3")
			);
		}
		this.groups.add(group0);
	}

}
