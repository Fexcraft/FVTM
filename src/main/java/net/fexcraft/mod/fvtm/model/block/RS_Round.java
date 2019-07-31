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
@fModel(registryname = "fvtm:models/roadsign/round")
public class RS_Round extends RoadSignModel {

	//actually might later do a single-instance with cached booleans instead, as intended initially.
	public RS_Round(String[] splits){
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
		group0.add(new ModelRendererTurbo(group0, 0, 0, textureX, textureY).newCylinderBuilder()
			.setPosition(0, 0, 0).setRadius(8, 7).setLength(1).setSegments(16, 0).setScale(1, 1).setDirection(0)
			.setRadialTexture(4, 1).setSidesVisible(false, false, false, false).setTopOffset(null).build()
			.setRotationPoint(0, -8, -3).setRotationAngle(0, 0, 0).setName("border")
		);
		if(l0){
			group0.add(new ModelRendererTurbo(group0, 0, 5, textureX, textureY).addCylinder(0, 0, 0, 7, 0.125f, 16, 1, 1, 2, null)
				.setRotationPoint(0, -8, -2.125f).setRotationAngle(0, 90, 0).setName("layer0")
			);
		}
		if(l1){
			group0.add(new ModelRendererTurbo(group0, 0, 25, textureX, textureY).newCylinderBuilder()
				.setPosition(0, 0, 0).setRadius(7, 0.01f).setLength(0.125f).setSegments(16, 0).setScale(1, 1).setDirection(2)
				.setRadialTexture(3, 6).setSidesVisible(false, true, true, true).setTopOffset(null).build()
				.setRotationPoint(0, -8, -2.25f).setRotationAngle(0, 90, 0).setName("layer1")
			);
		}
		if(l2){
			group0.add(new ModelRendererTurbo(group0, 32, 5, textureX, textureY).addCylinder(0, 0, 0, 7, 0.125f, 16, 1, 1, 2, null)
				.setRotationPoint(0, -8, -2.375f).setRotationAngle(0, 90, 0).setName("layer2")
			);
		}
		if(l3){
			group0.add(new ModelRendererTurbo(group0, 46, 5, textureX, textureY).addCylinder(0, 0, 0, 7, 0.125f, 16, 1, 1, 2, null)
				.setRotationPoint(0, -8, -2.375f).setRotationAngle(0, 90, 0).setName("layer3")
			);
		}
		this.groups.add(group0);
	}

}
